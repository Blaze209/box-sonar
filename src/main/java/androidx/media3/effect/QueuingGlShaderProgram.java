package androidx.media3.effect;

import androidx.media3.common.GlObjectsProvider;
import androidx.media3.common.GlTextureInfo;
import androidx.media3.common.VideoFrameProcessingException;
import androidx.media3.common.util.GlRect;
import androidx.media3.common.util.GlUtil;
import androidx.media3.common.util.Log;
import com.google.common.base.Preconditions;
import com.google.common.util.concurrent.Futures;
import com.google.common.util.concurrent.MoreExecutors;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.concurrent.Executor;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes8.dex */
final class QueuingGlShaderProgram<T> implements GlShaderProgram {
    private static final long PROCESSING_TIMEOUT_MS = 500000;
    private static final String TAG = "QueuingGlShaderProgram";
    private final ConcurrentEffect<T> concurrentEffect;
    private GlShaderProgram.ErrorListener errorListener;
    private Executor errorListenerExecutor;
    private final Queue<QueuedFrame<T>> frameQueue;
    private int inputHeight;
    private GlShaderProgram.InputListener inputListener;
    private int inputWidth;
    private GlShaderProgram.OutputListener outputListener;
    private final TexturePool outputTexturePool;

    public interface ConcurrentEffect<T> {
        void finishProcessingAndBlend(GlTextureInfo glTextureInfo, long j, T t) throws VideoFrameProcessingException;

        void flush() throws VideoFrameProcessingException;

        Future<T> queueInputFrame(GlObjectsProvider glObjectsProvider, GlTextureInfo glTextureInfo, long j);

        void release() throws VideoFrameProcessingException;

        void signalEndOfCurrentInputStream() throws VideoFrameProcessingException;
    }

    public QueuingGlShaderProgram(boolean z, int i, ConcurrentEffect<T> concurrentEffect) {
        Preconditions.checkArgument(i > 0);
        this.concurrentEffect = concurrentEffect;
        this.frameQueue = new ArrayDeque(i);
        this.outputTexturePool = new TexturePool(z, i);
        this.inputListener = new GlShaderProgram.InputListener() { // from class: androidx.media3.effect.QueuingGlShaderProgram.1
        };
        this.outputListener = new GlShaderProgram.OutputListener() { // from class: androidx.media3.effect.QueuingGlShaderProgram.2
        };
        this.errorListener = new GlShaderProgram.ErrorListener() { // from class: androidx.media3.effect.QueuingGlShaderProgram$$ExternalSyntheticLambda1
            @Override // androidx.media3.effect.GlShaderProgram.ErrorListener
            public final void onError(VideoFrameProcessingException videoFrameProcessingException) {
                Log.e(QueuingGlShaderProgram.TAG, "Exception caught by default QueuingGlShaderProgram errorListener.", videoFrameProcessingException);
            }
        };
        this.errorListenerExecutor = MoreExecutors.directExecutor();
        this.inputWidth = -1;
        this.inputHeight = -1;
    }

    @Override // androidx.media3.effect.GlShaderProgram
    public void setInputListener(GlShaderProgram.InputListener inputListener) {
        this.inputListener = inputListener;
        for (int i = 0; i < this.outputTexturePool.freeTextureCount(); i++) {
            inputListener.onReadyToAcceptInputFrame();
        }
    }

    @Override // androidx.media3.effect.GlShaderProgram
    public void setOutputListener(GlShaderProgram.OutputListener outputListener) {
        this.outputListener = outputListener;
    }

    @Override // androidx.media3.effect.GlShaderProgram
    public void setErrorListener(Executor executor, GlShaderProgram.ErrorListener errorListener) {
        this.errorListenerExecutor = executor;
        this.errorListener = errorListener;
    }

    @Override // androidx.media3.effect.GlShaderProgram
    public void queueInputFrame(GlObjectsProvider glObjectsProvider, GlTextureInfo glTextureInfo, long j) {
        try {
            if (this.inputWidth != glTextureInfo.width || this.inputHeight != glTextureInfo.height || !this.outputTexturePool.isConfigured()) {
                while (outputOneFrame()) {
                }
                this.inputWidth = glTextureInfo.width;
                int i = glTextureInfo.height;
                this.inputHeight = i;
                this.outputTexturePool.ensureConfigured(glObjectsProvider, this.inputWidth, i);
            }
            GlTextureInfo glTextureInfoUseTexture = this.outputTexturePool.useTexture();
            Preconditions.checkState(glTextureInfo.fboId != -1);
            GlUtil.blitFrameBuffer(glTextureInfo.fboId, new GlRect(this.inputWidth, this.inputHeight), glTextureInfoUseTexture.fboId, new GlRect(this.inputWidth, this.inputHeight));
            this.frameQueue.add(new QueuedFrame<>(new TimedGlTextureInfo(glTextureInfoUseTexture, j), this.concurrentEffect.queueInputFrame(glObjectsProvider, glTextureInfoUseTexture, j)));
            this.inputListener.onInputFrameProcessed(glTextureInfo);
            if (this.frameQueue.size() == this.outputTexturePool.capacity()) {
                Preconditions.checkState(outputOneFrame());
            }
        } catch (GlUtil.GlException e) {
            onError(e);
        }
    }

    @Override // androidx.media3.effect.GlShaderProgram
    public void releaseOutputFrame(GlTextureInfo glTextureInfo) {
        if (this.outputTexturePool.isUsingTexture(glTextureInfo)) {
            this.outputTexturePool.freeTexture(glTextureInfo);
            this.inputListener.onReadyToAcceptInputFrame();
        }
    }

    @Override // androidx.media3.effect.GlShaderProgram
    public void signalEndOfCurrentInputStream() {
        try {
            this.concurrentEffect.signalEndOfCurrentInputStream();
        } catch (VideoFrameProcessingException e) {
            onError(e);
        }
        while (outputOneFrame()) {
        }
        this.outputListener.onCurrentOutputStreamEnded();
    }

    @Override // androidx.media3.effect.GlShaderProgram
    public void flush() {
        try {
            this.concurrentEffect.flush();
        } catch (VideoFrameProcessingException e) {
            onError(e);
        }
        cancelProcessingOfPendingFrames();
        this.outputTexturePool.freeAllTextures();
        this.inputListener.onFlush();
        for (int i = 0; i < this.outputTexturePool.capacity(); i++) {
            this.inputListener.onReadyToAcceptInputFrame();
        }
    }

    @Override // androidx.media3.effect.GlShaderProgram
    public void release() throws VideoFrameProcessingException {
        try {
            cancelProcessingOfPendingFrames();
            this.concurrentEffect.release();
            this.outputTexturePool.deleteAllTextures();
        } catch (GlUtil.GlException e) {
            throw new VideoFrameProcessingException(e);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$PrimitiveArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    private boolean outputOneFrame() {
        QueuedFrame<T> queuedFramePoll = this.frameQueue.poll();
        if (queuedFramePoll == null) {
            return false;
        }
        try {
            Object checked = Futures.getChecked(queuedFramePoll.task, VideoFrameProcessingException.class, PROCESSING_TIMEOUT_MS, TimeUnit.MILLISECONDS);
            GlUtil.focusFramebufferUsingCurrentContext(queuedFramePoll.timedGlTextureInfo.glTextureInfo.fboId, queuedFramePoll.timedGlTextureInfo.glTextureInfo.width, queuedFramePoll.timedGlTextureInfo.glTextureInfo.height);
            this.concurrentEffect.finishProcessingAndBlend(queuedFramePoll.timedGlTextureInfo.glTextureInfo, queuedFramePoll.timedGlTextureInfo.presentationTimeUs, checked);
            this.outputListener.onOutputFrameAvailable(queuedFramePoll.timedGlTextureInfo.glTextureInfo, queuedFramePoll.timedGlTextureInfo.presentationTimeUs);
            return true;
        } catch (VideoFrameProcessingException | GlUtil.GlException e) {
            onError(e);
            return false;
        }
    }

    private void cancelProcessingOfPendingFrames() {
        while (true) {
            QueuedFrame<T> queuedFramePoll = this.frameQueue.poll();
            if (queuedFramePoll == null) {
                return;
            } else {
                queuedFramePoll.task.cancel(false);
            }
        }
    }

    private void onError(final Exception exc) {
        this.errorListenerExecutor.execute(new Runnable() { // from class: androidx.media3.effect.QueuingGlShaderProgram$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.m10425lambda$onError$1$androidxmedia3effectQueuingGlShaderProgram(exc);
            }
        });
    }

    /* JADX INFO: renamed from: lambda$onError$1$androidx-media3-effect-QueuingGlShaderProgram, reason: not valid java name */
    /* synthetic */ void m10425lambda$onError$1$androidxmedia3effectQueuingGlShaderProgram(Exception exc) {
        this.errorListener.onError(VideoFrameProcessingException.from(exc));
    }

    private static final class QueuedFrame<T> {
        public final Future<T> task;
        public final TimedGlTextureInfo timedGlTextureInfo;

        public QueuedFrame(TimedGlTextureInfo timedGlTextureInfo, Future<T> future) {
            this.timedGlTextureInfo = timedGlTextureInfo;
            this.task = future;
        }
    }
}
