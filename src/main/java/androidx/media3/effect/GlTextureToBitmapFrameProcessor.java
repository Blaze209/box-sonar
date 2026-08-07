package androidx.media3.effect;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.ColorSpace;
import android.opengl.GLES20;
import android.os.Build;
import android.util.DisplayMetrics;
import android.util.Pair;
import androidx.camera.view.PreviewView$1$$ExternalSyntheticBackportWithForwarding0;
import androidx.media3.common.GlObjectsProvider;
import androidx.media3.common.GlTextureInfo;
import androidx.media3.common.VideoFrameProcessingException;
import androidx.media3.common.util.Consumer;
import androidx.media3.common.util.GlProgram;
import androidx.media3.common.util.GlUtil;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableList;
import com.google.common.util.concurrent.FutureCallback;
import com.google.common.util.concurrent.Futures;
import com.google.common.util.concurrent.ListenableFuture;
import com.google.common.util.concurrent.ListeningExecutorService;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.concurrent.Callable;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes8.dex */
final class GlTextureToBitmapFrameProcessor implements FrameProcessor<GlTextureFrame, BitmapFrame> {
    private static final ImmutableList<float[]> visiblePolygon = ImmutableList.of(new float[]{-1.0f, -1.0f, 0.0f, 1.0f}, new float[]{-1.0f, 1.0f, 0.0f, 1.0f}, new float[]{1.0f, 1.0f, 0.0f, 1.0f}, new float[]{1.0f, -1.0f, 0.0f, 1.0f});
    private ByteBuffer byteBuffer;
    private final int bytesPerPixel;
    private FrameConsumer<BitmapFrame> downstreamConsumer;
    private final GlObjectsProvider glObjectsProvider;
    private final GlProgram glProgram;
    private final ListeningExecutorService glThreadExecutorService;
    private final boolean hdrUses16BitFloat;
    private GlTextureInfo hlgTextureInfo;
    private final boolean useHdr;
    private final InputConsumer inputConsumer = new InputConsumer();
    private final Queue<BitmapFrame> processedFrames = new ArrayDeque();
    private final AtomicBoolean canAcceptInput = new AtomicBoolean(true);
    private final AtomicReference<Pair<Executor, Consumer<VideoFrameProcessingException>>> onErrorCallback = new AtomicReference<>();
    private final AtomicBoolean isReleased = new AtomicBoolean();

    public GlTextureToBitmapFrameProcessor(Context context, boolean z, ListeningExecutorService listeningExecutorService, GlObjectsProvider glObjectsProvider) throws VideoFrameProcessingException {
        this.glThreadExecutorService = listeningExecutorService;
        this.useHdr = z;
        this.glObjectsProvider = glObjectsProvider;
        boolean z2 = Build.VERSION.SDK_INT <= 35;
        this.hdrUses16BitFloat = z2;
        this.bytesPerPixel = (z && z2) ? 8 : 4;
        if (z) {
            Preconditions.checkState(Build.VERSION.SDK_INT >= 34);
            try {
                GlProgram glProgram = new GlProgram(context, R.raw.vertex_shader_transformation_es3, R.raw.fragment_shader_oetf_es3);
                this.glProgram = glProgram;
                glProgram.setFloatsUniform("uTexTransformationMatrix", GlUtil.create4x4IdentityMatrix());
                glProgram.setFloatsUniform("uTransformationMatrix", GlUtil.create4x4IdentityMatrix());
                glProgram.setFloatsUniform("uRgbMatrix", GlUtil.create4x4IdentityMatrix());
                glProgram.setIntUniform("uOutputColorTransfer", 7);
                glProgram.setBufferAttribute("aFramePosition", GlUtil.createVertexBuffer(visiblePolygon), 4);
                return;
            } catch (GlUtil.GlException | IOException e) {
                throw new VideoFrameProcessingException(e);
            }
        }
        this.glProgram = null;
    }

    @Override // androidx.media3.effect.FrameProcessor
    public FrameConsumer<GlTextureFrame> getInput() {
        Preconditions.checkState(!this.isReleased.get());
        return this.inputConsumer;
    }

    @Override // androidx.media3.effect.FrameProcessor
    public ListenableFuture<Void> setOutputAsync(final FrameConsumer<BitmapFrame> frameConsumer) {
        Preconditions.checkState(!this.isReleased.get());
        return Futures.submit(new Runnable() { // from class: androidx.media3.effect.GlTextureToBitmapFrameProcessor$$ExternalSyntheticLambda1
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.m10411x52f75485(frameConsumer);
            }
        }, this.glThreadExecutorService);
    }

    @Override // androidx.media3.effect.FrameProcessor
    public ListenableFuture<Void> releaseAsync() {
        if (!this.isReleased.compareAndSet(false, true)) {
            return Futures.immediateVoidFuture();
        }
        return this.glThreadExecutorService.submit(new Callable() { // from class: androidx.media3.effect.GlTextureToBitmapFrameProcessor$$ExternalSyntheticLambda3
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return this.f$0.m10410xad1a1d28();
            }
        });
    }

    /* JADX INFO: renamed from: lambda$releaseAsync$1$androidx-media3-effect-GlTextureToBitmapFrameProcessor, reason: not valid java name */
    /* synthetic */ Void m10410xad1a1d28() throws Exception {
        releaseInternal();
        return null;
    }

    @Override // androidx.media3.effect.FrameProcessor
    public void setOnErrorCallback(Executor executor, Consumer<VideoFrameProcessingException> consumer) {
        this.onErrorCallback.set(Pair.create(executor, consumer));
    }

    @Override // androidx.media3.effect.FrameProcessor
    public void clearOnErrorCallback() {
        this.onErrorCallback.set(null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: setOutputInternal, reason: merged with bridge method [inline-methods] */
    public void m10411x52f75485(FrameConsumer<BitmapFrame> frameConsumer) {
        FrameConsumer<BitmapFrame> frameConsumer2 = this.downstreamConsumer;
        if (frameConsumer2 == frameConsumer) {
            return;
        }
        if (frameConsumer2 != null) {
            frameConsumer2.clearOnCapacityAvailableCallback();
        }
        this.downstreamConsumer = frameConsumer;
        if (frameConsumer != null) {
            frameConsumer.setOnCapacityAvailableCallback(this.glThreadExecutorService, new Runnable() { // from class: androidx.media3.effect.GlTextureToBitmapFrameProcessor$$ExternalSyntheticLambda2
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.maybeDrainProcessedFrames();
                }
            });
        }
    }

    private void releaseInternal() {
        BitmapFrame bitmapFramePoll = this.processedFrames.poll();
        while (bitmapFramePoll != null) {
            bitmapFramePoll.release(null);
            bitmapFramePoll = this.processedFrames.poll();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void processFrameInternal(GlTextureFrame glTextureFrame) {
        GlTextureInfo glTextureInfo = glTextureFrame.glTextureInfo;
        try {
            ensureConfigured(this.glObjectsProvider, glTextureInfo.width, glTextureInfo.height);
            Bitmap bitmapGenerateHdrBitmap = this.useHdr ? generateHdrBitmap(glTextureInfo) : generateSdrBitmap(glTextureInfo);
            Preconditions.checkState(this.byteBuffer != null);
            bitmapGenerateHdrBitmap.copyPixelsFromBuffer(this.byteBuffer);
            this.processedFrames.add(new BitmapFrame(bitmapGenerateHdrBitmap, new BitmapFrame.Metadata(glTextureFrame.presentationTimeUs, glTextureFrame.format)));
            glTextureFrame.release(null);
            this.canAcceptInput.set(true);
            this.inputConsumer.notifyCapacityListener();
            maybeDrainProcessedFrames();
        } catch (Exception e) {
            glTextureFrame.release(null);
            onError(new VideoFrameProcessingException(e));
        }
    }

    private Bitmap generateHdrBitmap(GlTextureInfo glTextureInfo) throws GlUtil.GlException {
        Preconditions.checkState(this.hlgTextureInfo != null);
        Preconditions.checkState(this.byteBuffer != null);
        if (Build.VERSION.SDK_INT < 34) {
            throw new IllegalStateException(String.format("HDR requires SDK_INT of 34+. Current value is: %s", Integer.valueOf(Build.VERSION.SDK_INT)));
        }
        GlUtil.focusFramebufferUsingCurrentContext(this.hlgTextureInfo.fboId, this.hlgTextureInfo.width, this.hlgTextureInfo.height);
        GlUtil.checkGlError();
        ((GlProgram) Preconditions.checkNotNull(this.glProgram)).use();
        this.glProgram.setSamplerTexIdUniform("uTexSampler", glTextureInfo.texId, 0);
        this.glProgram.bindAttributesAndUniforms();
        GLES20.glDrawArrays(6, 0, visiblePolygon.size());
        GlUtil.checkGlError();
        GLES20.glReadPixels(0, 0, this.hlgTextureInfo.width, this.hlgTextureInfo.height, 6408, this.hdrUses16BitFloat ? 5131 : 33640, this.byteBuffer);
        GlUtil.checkGlError();
        return Bitmap.createBitmap((DisplayMetrics) null, this.hlgTextureInfo.width, this.hlgTextureInfo.height, this.hdrUses16BitFloat ? Bitmap.Config.RGBA_F16 : Bitmap.Config.RGBA_1010102, false, ColorSpace.get(ColorSpace.Named.BT2020_HLG));
    }

    private Bitmap generateSdrBitmap(GlTextureInfo glTextureInfo) throws GlUtil.GlException {
        Preconditions.checkState(this.byteBuffer != null);
        GlUtil.focusFramebufferUsingCurrentContext(glTextureInfo.fboId, glTextureInfo.width, glTextureInfo.height);
        GlUtil.checkGlError();
        GLES20.glReadPixels(0, 0, glTextureInfo.width, glTextureInfo.height, 6408, 5121, this.byteBuffer);
        GlUtil.checkGlError();
        return Bitmap.createBitmap(glTextureInfo.width, glTextureInfo.height, Bitmap.Config.ARGB_8888);
    }

    private void ensureConfigured(GlObjectsProvider glObjectsProvider, int i, int i2) throws GlUtil.GlException {
        int iCreateRgb10A2Texture;
        int i3 = i * i2 * this.bytesPerPixel;
        ByteBuffer byteBuffer = this.byteBuffer;
        if (byteBuffer == null || byteBuffer.capacity() != i3) {
            this.byteBuffer = ByteBuffer.allocateDirect(i3);
        }
        this.byteBuffer.clear();
        if (this.useHdr) {
            GlTextureInfo glTextureInfo = this.hlgTextureInfo;
            if (glTextureInfo != null && glTextureInfo.width == i && this.hlgTextureInfo.height == i2) {
                return;
            }
            GlTextureInfo glTextureInfo2 = this.hlgTextureInfo;
            if (glTextureInfo2 != null) {
                glTextureInfo2.release();
            }
            if (this.hdrUses16BitFloat) {
                iCreateRgb10A2Texture = GlUtil.createTexture(i, i2, true);
            } else {
                iCreateRgb10A2Texture = GlUtil.createRgb10A2Texture(i, i2);
            }
            this.hlgTextureInfo = glObjectsProvider.createBuffersForTexture(iCreateRgb10A2Texture, i, i2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void maybeDrainProcessedFrames() {
        if (this.isReleased.get()) {
            return;
        }
        BitmapFrame bitmapFramePeek = this.processedFrames.peek();
        while (bitmapFramePeek != null) {
            FrameConsumer<BitmapFrame> frameConsumer = this.downstreamConsumer;
            if (frameConsumer == null || !frameConsumer.queueFrame(bitmapFramePeek)) {
                return;
            }
            this.processedFrames.poll();
            bitmapFramePeek = this.processedFrames.peek();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onError(final VideoFrameProcessingException videoFrameProcessingException) {
        final Pair<Executor, Consumer<VideoFrameProcessingException>> pair = this.onErrorCallback.get();
        if (pair != null) {
            ((Executor) pair.first).execute(new Runnable() { // from class: androidx.media3.effect.GlTextureToBitmapFrameProcessor$$ExternalSyntheticLambda0
                @Override // java.lang.Runnable
                public final void run() {
                    ((Consumer) pair.second).accept(videoFrameProcessingException);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    final class InputConsumer implements FrameConsumer<GlTextureFrame> {
        private final AtomicReference<Pair<Executor, Runnable>> onCapacityAvailableCallbackReference = new AtomicReference<>(null);

        public InputConsumer() {
        }

        @Override // androidx.media3.effect.FrameConsumer
        public boolean queueFrame(final GlTextureFrame glTextureFrame) {
            Preconditions.checkState(!GlTextureToBitmapFrameProcessor.this.isReleased.get());
            if (!GlTextureToBitmapFrameProcessor.this.canAcceptInput.compareAndSet(true, false)) {
                return false;
            }
            Futures.addCallback(GlTextureToBitmapFrameProcessor.this.glThreadExecutorService.submit(new Callable() { // from class: androidx.media3.effect.GlTextureToBitmapFrameProcessor$InputConsumer$$ExternalSyntheticLambda0
                @Override // java.util.concurrent.Callable
                public final Object call() {
                    return this.f$0.m10412x373ec55e(glTextureFrame);
                }
            }), new FutureCallback<Object>() { // from class: androidx.media3.effect.GlTextureToBitmapFrameProcessor.InputConsumer.1
                @Override // com.google.common.util.concurrent.FutureCallback
                public void onSuccess(Object obj) {
                }

                @Override // com.google.common.util.concurrent.FutureCallback
                public void onFailure(Throwable th) {
                    GlTextureToBitmapFrameProcessor.this.onError(new VideoFrameProcessingException(th));
                }
            }, GlTextureToBitmapFrameProcessor.this.glThreadExecutorService);
            return true;
        }

        /* JADX INFO: renamed from: lambda$queueFrame$0$androidx-media3-effect-GlTextureToBitmapFrameProcessor$InputConsumer, reason: not valid java name */
        /* synthetic */ Object m10412x373ec55e(GlTextureFrame glTextureFrame) throws Exception {
            GlTextureToBitmapFrameProcessor.this.processFrameInternal(glTextureFrame);
            return null;
        }

        @Override // androidx.media3.effect.FrameConsumer
        public void setOnCapacityAvailableCallback(Executor executor, Runnable runnable) {
            if (!PreviewView$1$$ExternalSyntheticBackportWithForwarding0.m(this.onCapacityAvailableCallbackReference, null, Pair.create(executor, runnable))) {
                throw new IllegalStateException("onCapacityAvailableCallback already set");
            }
        }

        @Override // androidx.media3.effect.FrameConsumer
        public void clearOnCapacityAvailableCallback() {
            this.onCapacityAvailableCallbackReference.set(null);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void notifyCapacityListener() {
            Pair<Executor, Runnable> pair;
            if (GlTextureToBitmapFrameProcessor.this.isReleased.get() || (pair = this.onCapacityAvailableCallbackReference.get()) == null) {
                return;
            }
            ((Executor) pair.first).execute((Runnable) pair.second);
        }
    }
}
