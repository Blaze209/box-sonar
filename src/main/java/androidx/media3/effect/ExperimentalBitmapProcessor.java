package androidx.media3.effect;

import android.content.Context;
import android.graphics.Bitmap;
import android.opengl.EGLDisplay;
import androidx.concurrent.futures.CallbackToFutureAdapter;
import androidx.media3.common.ColorInfo;
import androidx.media3.common.Effect;
import androidx.media3.common.Format;
import androidx.media3.common.GlObjectsProvider;
import androidx.media3.common.VideoFrameProcessingException;
import androidx.media3.common.util.Consumer;
import androidx.media3.common.util.GlUtil;
import androidx.media3.common.util.Util;
import com.google.common.base.Function;
import com.google.common.base.Preconditions;
import com.google.common.base.Supplier;
import com.google.common.util.concurrent.AsyncCallable;
import com.google.common.util.concurrent.AsyncFunction;
import com.google.common.util.concurrent.FutureCallback;
import com.google.common.util.concurrent.Futures;
import com.google.common.util.concurrent.ListenableFuture;
import com.google.common.util.concurrent.ListeningExecutorService;
import com.google.common.util.concurrent.MoreExecutors;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Queue;
import java.util.concurrent.Callable;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes8.dex */
public final class ExperimentalBitmapProcessor {
    private static final String GL_THREAD_NAME = "Effect:BitmapProcessor:GlThread";
    private final Map<Integer, ListenableFuture<Void>> activeFutures;
    private final Thread callingThread;
    private EGLDisplay eglDisplay;
    private final GlTextureFrameProcessorFactory frameProcessorFactory;
    private final GlObjectsProvider glObjectsProvider;
    public final ListeningExecutorService glThreadExecutorService;
    private boolean isConfigured;
    private ListenableFuture<Void> lastOperationFuture;
    private ListenableFuture<Void> lastSetEffectsFuture;
    private int nextActiveFutureId;
    private final Queue<CallbackToFutureAdapter.Completer<Bitmap>> pendingCompleters;
    private Pipeline pipeline;
    private Exception pipelineException;
    private ListenableFuture<Void> releaseFuture;
    private volatile boolean releaseInitiated;

    static /* synthetic */ Void lambda$applyEffectsAsync$4(Bitmap bitmap) {
        return null;
    }

    public static final class Builder {
        private final Context context;
        private Supplier<GlObjectsProvider> glObjectsProviderSupplier = new Supplier() { // from class: androidx.media3.effect.ExperimentalBitmapProcessor$Builder$$ExternalSyntheticLambda1
            @Override // com.google.common.base.Supplier
            public final Object get() {
                return new DefaultGlObjectsProvider();
            }
        };

        static /* synthetic */ GlObjectsProvider lambda$setGlObjectsProvider$0(GlObjectsProvider glObjectsProvider) {
            return glObjectsProvider;
        }

        public Builder(Context context) {
            this.context = context;
        }

        public Builder setGlObjectsProvider(final GlObjectsProvider glObjectsProvider) {
            Preconditions.checkNotNull(glObjectsProvider);
            this.glObjectsProviderSupplier = new Supplier() { // from class: androidx.media3.effect.ExperimentalBitmapProcessor$Builder$$ExternalSyntheticLambda0
                @Override // com.google.common.base.Supplier
                public final Object get() {
                    return ExperimentalBitmapProcessor.Builder.lambda$setGlObjectsProvider$0(glObjectsProvider);
                }
            };
            return this;
        }

        public ExperimentalBitmapProcessor build() {
            return new ExperimentalBitmapProcessor(this);
        }
    }

    private ExperimentalBitmapProcessor(Builder builder) {
        ListeningExecutorService listeningExecutorServiceListeningDecorator = MoreExecutors.listeningDecorator(Util.newSingleThreadExecutor(GL_THREAD_NAME));
        this.glThreadExecutorService = listeningExecutorServiceListeningDecorator;
        GlObjectsProvider glObjectsProvider = (GlObjectsProvider) builder.glObjectsProviderSupplier.get();
        this.glObjectsProvider = glObjectsProvider;
        this.frameProcessorFactory = new GlTextureFrameProcessorFactory(builder.context, listeningExecutorServiceListeningDecorator, glObjectsProvider);
        ListenableFuture<Void> listenableFutureImmediateFailedFuture = Futures.immediateFailedFuture(new IllegalStateException());
        this.lastSetEffectsFuture = listenableFutureImmediateFailedFuture;
        this.lastOperationFuture = listenableFutureImmediateFailedFuture;
        this.callingThread = Thread.currentThread();
        this.pendingCompleters = new ConcurrentLinkedQueue();
        this.activeFutures = new ConcurrentHashMap();
    }

    public ListenableFuture<Void> setEffectsAsync(final List<Effect> list) {
        verifyCallingThread();
        if (this.releaseInitiated) {
            return Futures.immediateFailedFuture(new IllegalStateException("BitmapProcessor has been released."));
        }
        ListenableFuture<Void> listenableFutureTransformAsync = Futures.transformAsync(Futures.whenAllComplete(Futures.nonCancellationPropagating(this.lastOperationFuture)).callAsync(new AsyncCallable() { // from class: androidx.media3.effect.ExperimentalBitmapProcessor$$ExternalSyntheticLambda11
            @Override // com.google.common.util.concurrent.AsyncCallable
            public final ListenableFuture call() {
                return this.f$0.m10381xcce72fd2();
            }
        }, this.glThreadExecutorService), new AsyncFunction() { // from class: androidx.media3.effect.ExperimentalBitmapProcessor$$ExternalSyntheticLambda12
            @Override // com.google.common.util.concurrent.AsyncFunction
            public final ListenableFuture apply(Object obj) {
                return this.f$0.m10382xfabfca31(list, (Void) obj);
            }
        }, this.glThreadExecutorService);
        this.lastSetEffectsFuture = listenableFutureTransformAsync;
        this.lastOperationFuture = listenableFutureTransformAsync;
        final int i = this.nextActiveFutureId;
        this.nextActiveFutureId = i + 1;
        this.activeFutures.put(Integer.valueOf(i), this.lastOperationFuture);
        this.lastOperationFuture.addListener(new Runnable() { // from class: androidx.media3.effect.ExperimentalBitmapProcessor$$ExternalSyntheticLambda1
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.m10383x28986490(i);
            }
        }, MoreExecutors.directExecutor());
        return this.lastSetEffectsFuture;
    }

    /* JADX INFO: renamed from: lambda$setEffectsAsync$0$androidx-media3-effect-ExperimentalBitmapProcessor, reason: not valid java name */
    /* synthetic */ ListenableFuture m10381xcce72fd2() throws Exception {
        Preconditions.checkState(!this.releaseInitiated);
        return maybeReleasePipeline();
    }

    /* JADX INFO: renamed from: lambda$setEffectsAsync$1$androidx-media3-effect-ExperimentalBitmapProcessor, reason: not valid java name */
    /* synthetic */ ListenableFuture m10382xfabfca31(List list, Void r2) throws Exception {
        return buildPipelineAsync(list);
    }

    /* JADX INFO: renamed from: lambda$setEffectsAsync$2$androidx-media3-effect-ExperimentalBitmapProcessor, reason: not valid java name */
    /* synthetic */ void m10383x28986490(int i) {
        this.activeFutures.remove(Integer.valueOf(i));
    }

    public ListenableFuture<Bitmap> applyEffectsAsync(final Bitmap bitmap) {
        verifyCallingThread();
        if (this.releaseInitiated) {
            return Futures.immediateFailedFuture(new IllegalStateException("BitmapProcessor has been released."));
        }
        ListenableFuture<Bitmap> future = CallbackToFutureAdapter.getFuture(new CallbackToFutureAdapter.Resolver() { // from class: androidx.media3.effect.ExperimentalBitmapProcessor$$ExternalSyntheticLambda7
            @Override // androidx.concurrent.futures.CallbackToFutureAdapter.Resolver
            public final Object attachCompleter(CallbackToFutureAdapter.Completer completer) {
                return this.f$0.m10376x9df7be23(bitmap, completer);
            }
        });
        this.lastOperationFuture = Futures.transform(future, new Function() { // from class: androidx.media3.effect.ExperimentalBitmapProcessor$$ExternalSyntheticLambda8
            @Override // com.google.common.base.Function
            public final Object apply(Object obj) {
                return ExperimentalBitmapProcessor.lambda$applyEffectsAsync$4((Bitmap) obj);
            }
        }, MoreExecutors.directExecutor());
        final int i = this.nextActiveFutureId;
        this.nextActiveFutureId = i + 1;
        this.activeFutures.put(Integer.valueOf(i), this.lastOperationFuture);
        this.lastOperationFuture.addListener(new Runnable() { // from class: androidx.media3.effect.ExperimentalBitmapProcessor$$ExternalSyntheticLambda9
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.m10377xf9a8f2e1(i);
            }
        }, MoreExecutors.directExecutor());
        return future;
    }

    /* JADX INFO: renamed from: lambda$applyEffectsAsync$3$androidx-media3-effect-ExperimentalBitmapProcessor, reason: not valid java name */
    /* synthetic */ Object m10376x9df7be23(final Bitmap bitmap, final CallbackToFutureAdapter.Completer completer) throws Exception {
        Futures.addCallback(this.lastSetEffectsFuture, new FutureCallback<Void>() { // from class: androidx.media3.effect.ExperimentalBitmapProcessor.1
            @Override // com.google.common.util.concurrent.FutureCallback
            public void onSuccess(Void r2) {
                ExperimentalBitmapProcessor.this.processNext(completer, bitmap);
            }

            @Override // com.google.common.util.concurrent.FutureCallback
            public void onFailure(Throwable th) {
                completer.setException(th);
            }
        }, this.glThreadExecutorService);
        return "BitmapProcessor::applyEffects";
    }

    /* JADX INFO: renamed from: lambda$applyEffectsAsync$5$androidx-media3-effect-ExperimentalBitmapProcessor, reason: not valid java name */
    /* synthetic */ void m10377xf9a8f2e1(int i) {
        this.activeFutures.remove(Integer.valueOf(i));
    }

    public ListenableFuture<Void> releaseAsync() {
        verifyCallingThread();
        ListenableFuture<Void> listenableFuture = this.releaseFuture;
        if (listenableFuture != null) {
            return listenableFuture;
        }
        this.releaseInitiated = true;
        while (true) {
            CallbackToFutureAdapter.Completer<Bitmap> completerPoll = this.pendingCompleters.poll();
            if (completerPoll == null) {
                break;
            }
            completerPoll.setCancelled();
        }
        Iterator<ListenableFuture<Void>> it = this.activeFutures.values().iterator();
        while (it.hasNext()) {
            it.next().cancel(false);
        }
        this.activeFutures.clear();
        ListenableFuture<Void> listenableFutureCall = Futures.whenAllComplete(Futures.whenAllComplete(maybeReleasePipeline()).call(new Callable() { // from class: androidx.media3.effect.ExperimentalBitmapProcessor$$ExternalSyntheticLambda2
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return this.f$0.m10379x8bbff0b9();
            }
        }, this.glThreadExecutorService)).call(new Callable() { // from class: androidx.media3.effect.ExperimentalBitmapProcessor$$ExternalSyntheticLambda3
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return this.f$0.m10380xb9988b18();
            }
        }, MoreExecutors.directExecutor());
        this.releaseFuture = listenableFutureCall;
        return listenableFutureCall;
    }

    /* JADX INFO: renamed from: lambda$releaseAsync$6$androidx-media3-effect-ExperimentalBitmapProcessor, reason: not valid java name */
    /* synthetic */ Void m10379x8bbff0b9() throws Exception {
        EGLDisplay eGLDisplay = this.eglDisplay;
        if (eGLDisplay == null) {
            return null;
        }
        this.glObjectsProvider.release(eGLDisplay);
        return null;
    }

    /* JADX INFO: renamed from: lambda$releaseAsync$7$androidx-media3-effect-ExperimentalBitmapProcessor, reason: not valid java name */
    /* synthetic */ Void m10380xb9988b18() throws Exception {
        this.glThreadExecutorService.shutdownNow();
        return null;
    }

    private void verifyCallingThread() {
        Thread threadCurrentThread = Thread.currentThread();
        if (this.callingThread != threadCurrentThread) {
            throw new IllegalStateException("Object accessed from incorrect thread. Owner: " + this.callingThread.getName() + ", Current: " + threadCurrentThread.getName());
        }
    }

    private ListenableFuture<Void> maybeReleasePipeline() {
        Pipeline pipeline = this.pipeline;
        return pipeline == null ? Futures.immediateVoidFuture() : pipeline.releaseAsync();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void processNext(CallbackToFutureAdapter.Completer<Bitmap> completer, Bitmap bitmap) {
        final AtomicBoolean atomicBoolean = new AtomicBoolean(false);
        completer.addCancellationListener(new Runnable() { // from class: androidx.media3.effect.ExperimentalBitmapProcessor$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                atomicBoolean.set(true);
            }
        }, MoreExecutors.directExecutor());
        if (atomicBoolean.get()) {
            return;
        }
        if (this.releaseInitiated) {
            completer.setException(new IllegalStateException("BitmapProcessor is released"));
            return;
        }
        if (this.pipelineException != null) {
            completer.setException(new IllegalStateException("BitmapProcessor previously failed with exception", this.pipelineException));
            return;
        }
        if (this.pipeline == null) {
            completer.setException(new IllegalStateException("setEffectsAsync has not been called"));
            return;
        }
        if (!this.pipeline.getInput().queueFrame(new BitmapFrame(bitmap, new BitmapFrame.Metadata(0L, new Format.Builder().setWidth(bitmap.getWidth()).setHeight(bitmap.getHeight()).setColorInfo(ColorInfo.SRGB_BT709_FULL).build())))) {
            completer.setException(new IllegalStateException("Expected pipeline to accept input frame."));
        } else {
            this.pendingCompleters.add(completer);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void handleException(VideoFrameProcessingException videoFrameProcessingException) {
        this.pipelineException = videoFrameProcessingException;
        CallbackToFutureAdapter.Completer<Bitmap> completerPoll = this.pendingCompleters.poll();
        while (completerPoll != null) {
            completerPoll.setException(videoFrameProcessingException);
            completerPoll = this.pendingCompleters.poll();
        }
    }

    private ListenableFuture<Void> buildPipelineAsync(List<Effect> list) throws VideoFrameProcessingException, GlUtil.GlException {
        maybeConfigureGlContext();
        ArrayList arrayList = new ArrayList();
        for (Effect effect : list) {
            if (!(effect instanceof GlEffect)) {
                throw new IllegalArgumentException("BitmapProcessor can only be applied to GlEffect");
            }
            arrayList.add((GlEffect) effect);
        }
        return Futures.transform(Pipeline.createAsync(this.frameProcessorFactory.buildBitmapToGlTextureFrameProcessor(ColorInfo.SRGB_BT709_FULL, ColorInfo.SDR_BT709_LIMITED, new Consumer() { // from class: androidx.media3.effect.ExperimentalBitmapProcessor$$ExternalSyntheticLambda4
            @Override // androidx.media3.common.util.Consumer
            public final void accept(Object obj) {
                this.f$0.handleException((VideoFrameProcessingException) obj);
            }
        }), this.frameProcessorFactory.buildFrameProcessors(arrayList, false), this.frameProcessorFactory.buildGlTextureToBitmapFrameProcessor(false), this.glThreadExecutorService, new Consumer() { // from class: androidx.media3.effect.ExperimentalBitmapProcessor$$ExternalSyntheticLambda4
            @Override // androidx.media3.common.util.Consumer
            public final void accept(Object obj) {
                this.f$0.handleException((VideoFrameProcessingException) obj);
            }
        }, new Consumer() { // from class: androidx.media3.effect.ExperimentalBitmapProcessor$$ExternalSyntheticLambda5
            @Override // androidx.media3.common.util.Consumer
            public final void accept(Object obj) {
                this.f$0.onOutputFrameAvailable((BitmapFrame) obj);
            }
        }), new Function() { // from class: androidx.media3.effect.ExperimentalBitmapProcessor$$ExternalSyntheticLambda6
            @Override // com.google.common.base.Function
            public final Object apply(Object obj) {
                return this.f$0.m10378xbe5d937f((ExperimentalBitmapProcessor.Pipeline) obj);
            }
        }, this.glThreadExecutorService);
    }

    /* JADX INFO: renamed from: lambda$buildPipelineAsync$9$androidx-media3-effect-ExperimentalBitmapProcessor, reason: not valid java name */
    /* synthetic */ Void m10378xbe5d937f(Pipeline pipeline) {
        this.pipelineException = null;
        this.pipeline = pipeline;
        return null;
    }

    private void maybeConfigureGlContext() throws GlUtil.GlException {
        if (this.isConfigured) {
            return;
        }
        EGLDisplay defaultEglDisplay = GlUtil.getDefaultEglDisplay();
        this.eglDisplay = defaultEglDisplay;
        this.glObjectsProvider.createFocusedPlaceholderEglSurface(this.glObjectsProvider.createEglContext(defaultEglDisplay, 2, GlUtil.EGL_CONFIG_ATTRIBUTES_RGBA_8888), this.eglDisplay);
        this.isConfigured = true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onOutputFrameAvailable(BitmapFrame bitmapFrame) {
        CallbackToFutureAdapter.Completer<Bitmap> completerPoll = this.pendingCompleters.poll();
        if (completerPoll != null) {
            final AtomicBoolean atomicBoolean = new AtomicBoolean(false);
            completerPoll.addCancellationListener(new Runnable() { // from class: androidx.media3.effect.ExperimentalBitmapProcessor$$ExternalSyntheticLambda10
                @Override // java.lang.Runnable
                public final void run() {
                    atomicBoolean.set(true);
                }
            }, MoreExecutors.directExecutor());
            if (atomicBoolean.get()) {
                bitmapFrame.release(null);
                return;
            } else {
                completerPoll.set(bitmapFrame.getBitmap());
                return;
            }
        }
        bitmapFrame.release(null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    static final class Pipeline {
        private final List<FrameProcessor<?, ?>> frameProcessors;
        private final InputConsumer inputConsumer;

        static /* synthetic */ Void lambda$releaseAsync$2(List list) {
            return null;
        }

        public static ListenableFuture<Pipeline> createAsync(BitmapToGlTextureFrameProcessor bitmapToGlTextureFrameProcessor, List<GlShaderProgramFrameProcessor> list, GlTextureToBitmapFrameProcessor glTextureToBitmapFrameProcessor, ListeningExecutorService listeningExecutorService, Consumer<VideoFrameProcessingException> consumer, Consumer<BitmapFrame> consumer2) {
            ArrayList arrayList = new ArrayList();
            GlShaderProgramFrameProcessor glShaderProgramFrameProcessor = bitmapToGlTextureFrameProcessor;
            for (int i = 0; i < list.size(); i++) {
                arrayList.add(glShaderProgramFrameProcessor.setOutputAsync(list.get(i).getInput()));
                glShaderProgramFrameProcessor.setOnErrorCallback(listeningExecutorService, consumer);
                glShaderProgramFrameProcessor = list.get(i);
            }
            arrayList.add(glShaderProgramFrameProcessor.setOutputAsync(glTextureToBitmapFrameProcessor.getInput()));
            glShaderProgramFrameProcessor.setOnErrorCallback(listeningExecutorService, consumer);
            glTextureToBitmapFrameProcessor.setOnErrorCallback(listeningExecutorService, consumer);
            final InputConsumer inputConsumer = new InputConsumer(bitmapToGlTextureFrameProcessor.getInput());
            FrameConsumer<BitmapFrame> input = bitmapToGlTextureFrameProcessor.getInput();
            Objects.requireNonNull(inputConsumer);
            input.setOnCapacityAvailableCallback(listeningExecutorService, new Runnable() { // from class: androidx.media3.effect.ExperimentalBitmapProcessor$Pipeline$$ExternalSyntheticLambda1
                @Override // java.lang.Runnable
                public final void run() {
                    inputConsumer.maybeDrainInputFrames();
                }
            });
            arrayList.add(glTextureToBitmapFrameProcessor.setOutputAsync(new FinalConsumer(consumer2)));
            final ArrayList arrayList2 = new ArrayList();
            arrayList2.add(bitmapToGlTextureFrameProcessor);
            arrayList2.addAll(list);
            arrayList2.add(glTextureToBitmapFrameProcessor);
            return Futures.transform(Futures.allAsList(arrayList), new Function() { // from class: androidx.media3.effect.ExperimentalBitmapProcessor$Pipeline$$ExternalSyntheticLambda2
                @Override // com.google.common.base.Function
                public final Object apply(Object obj) {
                    return ExperimentalBitmapProcessor.Pipeline.lambda$createAsync$1(inputConsumer, arrayList2, (List) obj);
                }
            }, MoreExecutors.directExecutor());
        }

        static /* synthetic */ Pipeline lambda$createAsync$1(InputConsumer inputConsumer, ArrayList arrayList, List list) {
            return new Pipeline(inputConsumer, arrayList);
        }

        public Pipeline(InputConsumer inputConsumer, List<FrameProcessor<?, ?>> list) {
            this.inputConsumer = inputConsumer;
            this.frameProcessors = list;
        }

        public FrameConsumer<BitmapFrame> getInput() {
            return this.inputConsumer;
        }

        public ListenableFuture<Void> releaseAsync() {
            ArrayList arrayList = new ArrayList();
            this.inputConsumer.release();
            Iterator<FrameProcessor<?, ?>> it = this.frameProcessors.iterator();
            while (it.hasNext()) {
                arrayList.add(it.next().releaseAsync());
            }
            return Futures.transform(Futures.allAsList(arrayList), new Function() { // from class: androidx.media3.effect.ExperimentalBitmapProcessor$Pipeline$$ExternalSyntheticLambda0
                @Override // com.google.common.base.Function
                public final Object apply(Object obj) {
                    return ExperimentalBitmapProcessor.Pipeline.lambda$releaseAsync$2((List) obj);
                }
            }, MoreExecutors.directExecutor());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    static final class InputConsumer implements FrameConsumer<BitmapFrame> {
        private final FrameConsumer<BitmapFrame> downstreamConsumer;
        private final Queue<BitmapFrame> inputFrames = new ArrayDeque();
        private boolean isReleased;

        @Override // androidx.media3.effect.FrameConsumer
        public void clearOnCapacityAvailableCallback() {
        }

        @Override // androidx.media3.effect.FrameConsumer
        public void setOnCapacityAvailableCallback(Executor executor, Runnable runnable) {
        }

        public InputConsumer(FrameConsumer<BitmapFrame> frameConsumer) {
            this.downstreamConsumer = frameConsumer;
        }

        public void release() {
            this.isReleased = true;
            this.inputFrames.clear();
        }

        @Override // androidx.media3.effect.FrameConsumer
        public boolean queueFrame(BitmapFrame bitmapFrame) {
            Preconditions.checkState(!this.isReleased);
            this.inputFrames.add(bitmapFrame);
            maybeDrainInputFrames();
            return true;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void maybeDrainInputFrames() {
            BitmapFrame bitmapFramePeek = this.inputFrames.peek();
            while (bitmapFramePeek != null && this.downstreamConsumer.queueFrame(bitmapFramePeek)) {
                this.inputFrames.poll();
                bitmapFramePeek = this.inputFrames.peek();
            }
        }
    }

    private static final class FinalConsumer implements FrameConsumer<BitmapFrame> {
        private final Consumer<BitmapFrame> onQueueFrameCallback;

        @Override // androidx.media3.effect.FrameConsumer
        public void clearOnCapacityAvailableCallback() {
        }

        @Override // androidx.media3.effect.FrameConsumer
        public void setOnCapacityAvailableCallback(Executor executor, Runnable runnable) {
        }

        public FinalConsumer(Consumer<BitmapFrame> consumer) {
            this.onQueueFrameCallback = consumer;
        }

        @Override // androidx.media3.effect.FrameConsumer
        public boolean queueFrame(BitmapFrame bitmapFrame) {
            this.onQueueFrameCallback.accept(bitmapFrame);
            return true;
        }
    }
}
