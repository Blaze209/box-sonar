package androidx.media3.inspector.frame;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.ColorSpace;
import android.graphics.Matrix;
import android.opengl.GLES20;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.util.DisplayMetrics;
import androidx.camera.view.PreviewView$1$$ExternalSyntheticBackportWithForwarding0;
import androidx.concurrent.futures.CallbackToFutureAdapter;
import androidx.media3.common.ColorInfo;
import androidx.media3.common.Effect;
import androidx.media3.common.Format;
import androidx.media3.common.GlObjectsProvider;
import androidx.media3.common.GlTextureInfo;
import androidx.media3.common.MediaItem;
import androidx.media3.common.MimeTypes;
import androidx.media3.common.PlaybackException;
import androidx.media3.common.VideoFrameProcessingException;
import androidx.media3.common.util.GlProgram;
import androidx.media3.common.util.GlUtil;
import androidx.media3.common.util.Util;
import androidx.media3.effect.DefaultVideoFrameProcessor;
import androidx.media3.effect.GlEffect;
import androidx.media3.effect.GlShaderProgram;
import androidx.media3.effect.MatrixTransformation;
import androidx.media3.effect.PassthroughShaderProgram;
import androidx.media3.effect.ScaleAndRotateTransformation;
import androidx.media3.effect.SingleInputVideoGraph;
import androidx.media3.exoplayer.DecoderCounters;
import androidx.media3.exoplayer.DecoderReuseEvaluation;
import androidx.media3.exoplayer.ExoPlaybackException;
import androidx.media3.exoplayer.ExoPlayer;
import androidx.media3.exoplayer.FormatHolder;
import androidx.media3.exoplayer.Renderer;
import androidx.media3.exoplayer.RenderersFactory;
import androidx.media3.exoplayer.SeekParameters;
import androidx.media3.exoplayer.analytics.AnalyticsListener;
import androidx.media3.exoplayer.audio.AudioRendererEventListener;
import androidx.media3.exoplayer.mediacodec.MediaCodecAdapter;
import androidx.media3.exoplayer.mediacodec.MediaCodecSelector;
import androidx.media3.exoplayer.metadata.MetadataOutput;
import androidx.media3.exoplayer.source.DefaultMediaSourceFactory;
import androidx.media3.exoplayer.source.MediaSource;
import androidx.media3.exoplayer.text.TextOutput;
import androidx.media3.exoplayer.video.MediaCodecVideoRenderer;
import androidx.media3.exoplayer.video.PlaybackVideoGraphWrapper;
import androidx.media3.exoplayer.video.VideoFrameReleaseControl;
import androidx.media3.exoplayer.video.VideoRendererEventListener;
import androidx.media3.extractor.DefaultExtractorsFactory;
import androidx.media3.extractor.metadata.ThumbnailMetadata;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableList;
import com.google.common.util.concurrent.AsyncCallable;
import com.google.common.util.concurrent.AsyncFunction;
import com.google.common.util.concurrent.ExecutionSequencer;
import com.google.common.util.concurrent.Futures;
import com.google.common.util.concurrent.ListenableFuture;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.Callable;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes8.dex */
final class FrameExtractorInternal {
    private static final Object LOCK = new Object();
    private static final MatrixTransformation MIRROR_Y_TRANSFORMATION = new MatrixTransformation() { // from class: androidx.media3.inspector.frame.FrameExtractorInternal$$ExternalSyntheticLambda4
        @Override // androidx.media3.effect.MatrixTransformation
        public final Matrix getMatrix(long j) {
            return FrameExtractorInternal.lambda$static$0(j);
        }
    };
    private static FrameExtractorInternal instance;
    private boolean currentExtractHdrFrames;
    private GlObjectsProvider currentGlObjectsProvider;
    private MediaSource.Factory currentMediaSourceFactory;
    private FrameExtractor.Frame lastSeekDedupeFrame;
    private ExoPlayer player;
    private final AtomicInteger referenceCount = new AtomicInteger(0);
    private final ExecutionSequencer executionSequencer = ExecutionSequencer.create();
    private final AtomicBoolean extractedFrameNeedsRendering = new AtomicBoolean(false);
    private final AtomicReference<CallbackToFutureAdapter.Completer<FrameExtractor.Frame>> activeTaskCompleter = new AtomicReference<>();
    private final Handler playerHandler = new Handler(Looper.getMainLooper());
    private MediaCodecSelector currentMediaCodecSelector = MediaCodecSelector.DEFAULT;
    private long thumbnailPresentationTimeMs = -9223372036854775807L;

    static final class FrameExtractionRequest {
        private final Context context;
        private final List<Effect> effects;
        private final boolean extractHdrFrames;
        private final GlObjectsProvider glObjectsProvider;
        private final MediaCodecSelector mediaCodecSelector;
        private final MediaItem mediaItem;
        private final MediaSource.Factory mediaSourceFactory;
        private final long positionMs;
        private final SeekParameters seekParameters;

        FrameExtractionRequest(Context context, MediaItem mediaItem, List<Effect> list, SeekParameters seekParameters, MediaCodecSelector mediaCodecSelector, GlObjectsProvider glObjectsProvider, MediaSource.Factory factory, boolean z, long j) {
            this.context = context;
            this.mediaItem = mediaItem;
            this.effects = list;
            this.seekParameters = seekParameters;
            this.mediaCodecSelector = mediaCodecSelector;
            this.glObjectsProvider = glObjectsProvider;
            this.mediaSourceFactory = factory;
            this.extractHdrFrames = z;
            this.positionMs = j;
        }

        FrameExtractionRequest copyWithPositionMs(long j) {
            return this.positionMs == j ? this : new FrameExtractionRequest(this.context, this.mediaItem, this.effects, this.seekParameters, this.mediaCodecSelector, this.glObjectsProvider, this.mediaSourceFactory, this.extractHdrFrames, j);
        }
    }

    static /* synthetic */ Matrix lambda$static$0(long j) {
        Matrix matrix = new Matrix();
        matrix.setScale(1.0f, -1.0f);
        return matrix;
    }

    private FrameExtractorInternal() {
    }

    static FrameExtractorInternal getInstance() {
        FrameExtractorInternal frameExtractorInternal;
        synchronized (LOCK) {
            if (instance == null) {
                instance = new FrameExtractorInternal();
            }
            frameExtractorInternal = instance;
        }
        return frameExtractorInternal;
    }

    void addReference() {
        this.referenceCount.incrementAndGet();
    }

    void releaseReference() {
        ExecutionSequencer executionSequencer = this.executionSequencer;
        Callable callable = new Callable() { // from class: androidx.media3.inspector.frame.FrameExtractorInternal$$ExternalSyntheticLambda1
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return this.f$0.m10629x2047215a();
            }
        };
        Handler handler = this.playerHandler;
        Objects.requireNonNull(handler);
        executionSequencer.submit(callable, new FrameExtractorInternal$$ExternalSyntheticLambda2(handler));
    }

    /* JADX INFO: renamed from: lambda$releaseReference$1$androidx-media3-inspector-frame-FrameExtractorInternal, reason: not valid java name */
    /* synthetic */ Void m10629x2047215a() throws Exception {
        if (this.referenceCount.decrementAndGet() == 0) {
            ExoPlayer exoPlayer = this.player;
            if (exoPlayer != null) {
                exoPlayer.release();
                this.player = null;
            }
            this.currentMediaCodecSelector = MediaCodecSelector.DEFAULT;
            this.currentExtractHdrFrames = false;
            this.currentGlObjectsProvider = null;
            this.currentMediaSourceFactory = null;
            this.lastSeekDedupeFrame = null;
            this.thumbnailPresentationTimeMs = -9223372036854775807L;
        }
        return null;
    }

    ListenableFuture<FrameExtractor.Frame> submitTask(final FrameExtractionRequest frameExtractionRequest) {
        ExecutionSequencer executionSequencer = this.executionSequencer;
        AsyncCallable asyncCallable = new AsyncCallable() { // from class: androidx.media3.inspector.frame.FrameExtractorInternal$$ExternalSyntheticLambda7
            @Override // com.google.common.util.concurrent.AsyncCallable
            public final ListenableFuture call() {
                return this.f$0.m10631xecc74bf(frameExtractionRequest);
            }
        };
        Handler handler = this.playerHandler;
        Objects.requireNonNull(handler);
        return executionSequencer.submitAsync(asyncCallable, new FrameExtractorInternal$$ExternalSyntheticLambda2(handler));
    }

    /* JADX INFO: renamed from: lambda$submitTask$3$androidx-media3-inspector-frame-FrameExtractorInternal, reason: not valid java name */
    /* synthetic */ ListenableFuture m10631xecc74bf(final FrameExtractionRequest frameExtractionRequest) throws Exception {
        long thumbnailPresentationTimeMs;
        boolean z = (this.player != null && !this.currentExtractHdrFrames && !frameExtractionRequest.extractHdrFrames && this.player.getPlayerError() == null && frameExtractionRequest.mediaCodecSelector == this.currentMediaCodecSelector && frameExtractionRequest.glObjectsProvider == this.currentGlObjectsProvider && frameExtractionRequest.mediaSourceFactory == this.currentMediaSourceFactory) ? false : true;
        boolean z2 = z || !frameExtractionRequest.mediaItem.equals(((ExoPlayer) Preconditions.checkNotNull(this.player)).getCurrentMediaItem());
        final boolean z3 = frameExtractionRequest.positionMs == -9223372036854775807L;
        if (z2) {
            ListenableFuture<FrameExtractor.Frame> listenableFutureProcessTask = processTask(frameExtractionRequest.copyWithPositionMs(0L), z, true);
            AsyncFunction asyncFunction = new AsyncFunction() { // from class: androidx.media3.inspector.frame.FrameExtractorInternal$$ExternalSyntheticLambda6
                @Override // com.google.common.util.concurrent.AsyncFunction
                public final ListenableFuture apply(Object obj) {
                    return this.f$0.m10630xd9621e0(z3, frameExtractionRequest, (FrameExtractor.Frame) obj);
                }
            };
            Handler handler = this.playerHandler;
            Objects.requireNonNull(handler);
            return Futures.transformAsync(listenableFutureProcessTask, asyncFunction, new FrameExtractorInternal$$ExternalSyntheticLambda2(handler));
        }
        if (!z3) {
            thumbnailPresentationTimeMs = frameExtractionRequest.positionMs;
        } else {
            thumbnailPresentationTimeMs = getThumbnailPresentationTimeMs();
        }
        return processTask(frameExtractionRequest.copyWithPositionMs(thumbnailPresentationTimeMs), z, z2);
    }

    /* JADX INFO: renamed from: lambda$submitTask$2$androidx-media3-inspector-frame-FrameExtractorInternal, reason: not valid java name */
    /* synthetic */ ListenableFuture m10630xd9621e0(boolean z, FrameExtractionRequest frameExtractionRequest, FrameExtractor.Frame frame) throws Exception {
        long thumbnailPresentationTimeMs = z ? getThumbnailPresentationTimeMs() : frameExtractionRequest.positionMs;
        return frame.presentationTimeMs == thumbnailPresentationTimeMs ? Futures.immediateFuture(frame) : processTask(frameExtractionRequest.copyWithPositionMs(thumbnailPresentationTimeMs), false, false);
    }

    ListenableFuture<DecoderCounters> getDecoderCounters() {
        return CallbackToFutureAdapter.getFuture(new CallbackToFutureAdapter.Resolver() { // from class: androidx.media3.inspector.frame.FrameExtractorInternal$$ExternalSyntheticLambda3
            @Override // androidx.concurrent.futures.CallbackToFutureAdapter.Resolver
            public final Object attachCompleter(CallbackToFutureAdapter.Completer completer) {
                return this.f$0.m10627x2500c215(completer);
            }
        });
    }

    /* JADX INFO: renamed from: lambda$getDecoderCounters$5$androidx-media3-inspector-frame-FrameExtractorInternal, reason: not valid java name */
    /* synthetic */ Object m10627x2500c215(final CallbackToFutureAdapter.Completer completer) throws Exception {
        ExecutionSequencer executionSequencer = this.executionSequencer;
        Callable callable = new Callable() { // from class: androidx.media3.inspector.frame.FrameExtractorInternal$$ExternalSyntheticLambda8
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return this.f$0.m10626x23ca6f36(completer);
            }
        };
        Handler handler = this.playerHandler;
        Objects.requireNonNull(handler);
        executionSequencer.submit(callable, new FrameExtractorInternal$$ExternalSyntheticLambda2(handler));
        return "FrameExtractorInternal.getDecoderCounters";
    }

    /* JADX INFO: renamed from: lambda$getDecoderCounters$4$androidx-media3-inspector-frame-FrameExtractorInternal, reason: not valid java name */
    /* synthetic */ Void m10626x23ca6f36(CallbackToFutureAdapter.Completer completer) throws Exception {
        ExoPlayer exoPlayer = this.player;
        completer.set(exoPlayer != null ? exoPlayer.getVideoDecoderCounters() : null);
        return null;
    }

    private long getThumbnailPresentationTimeMs() {
        long j = this.thumbnailPresentationTimeMs;
        if (j != -9223372036854775807L) {
            return j;
        }
        return 0L;
    }

    private ListenableFuture<FrameExtractor.Frame> processTask(final FrameExtractionRequest frameExtractionRequest, final boolean z, final boolean z2) {
        return CallbackToFutureAdapter.getFuture(new CallbackToFutureAdapter.Resolver() { // from class: androidx.media3.inspector.frame.FrameExtractorInternal$$ExternalSyntheticLambda0
            @Override // androidx.concurrent.futures.CallbackToFutureAdapter.Resolver
            public final Object attachCompleter(CallbackToFutureAdapter.Completer completer) {
                return this.f$0.m10628x758b377f(frameExtractionRequest, z, z2, completer);
            }
        });
    }

    /* JADX INFO: renamed from: lambda$processTask$6$androidx-media3-inspector-frame-FrameExtractorInternal, reason: not valid java name */
    /* synthetic */ Object m10628x758b377f(FrameExtractionRequest frameExtractionRequest, boolean z, boolean z2, CallbackToFutureAdapter.Completer completer) throws Exception {
        if (!PreviewView$1$$ExternalSyntheticBackportWithForwarding0.m(this.activeTaskCompleter, null, completer)) {
            completer.setException(new IllegalStateException("Another task is already active"));
            return "FrameExtractorInternal.processTask - conflict";
        }
        ensurePlayerInitialized(frameExtractionRequest, z);
        ImmutableList<Effect> immutableListBuildVideoEffects = buildVideoEffects(frameExtractionRequest.effects, new FrameReader());
        ExoPlayer exoPlayer = (ExoPlayer) Preconditions.checkNotNull(this.player);
        if (z2) {
            this.lastSeekDedupeFrame = null;
            this.extractedFrameNeedsRendering.set(true);
            this.thumbnailPresentationTimeMs = -9223372036854775807L;
            exoPlayer.setVideoEffects(immutableListBuildVideoEffects);
            exoPlayer.setMediaItem(frameExtractionRequest.mediaItem);
            exoPlayer.setSeekParameters(frameExtractionRequest.seekParameters);
            exoPlayer.prepare();
            return "FrameExtractorInternal.processTask - scheduled";
        }
        this.extractedFrameNeedsRendering.set(false);
        exoPlayer.setVideoEffects(immutableListBuildVideoEffects);
        exoPlayer.setSeekParameters(frameExtractionRequest.seekParameters);
        exoPlayer.seekTo(frameExtractionRequest.positionMs);
        return "FrameExtractorInternal.processTask - scheduled";
    }

    private void ensurePlayerInitialized(final FrameExtractionRequest frameExtractionRequest, boolean z) {
        MediaSource.Factory defaultMediaSourceFactory;
        if (z) {
            ExoPlayer exoPlayer = this.player;
            if (exoPlayer != null) {
                exoPlayer.release();
            }
            this.currentMediaCodecSelector = frameExtractionRequest.mediaCodecSelector;
            this.currentExtractHdrFrames = frameExtractionRequest.extractHdrFrames;
            this.currentGlObjectsProvider = frameExtractionRequest.glObjectsProvider;
            this.currentMediaSourceFactory = frameExtractionRequest.mediaSourceFactory;
            if (frameExtractionRequest.mediaSourceFactory != null) {
                defaultMediaSourceFactory = frameExtractionRequest.mediaSourceFactory;
            } else {
                defaultMediaSourceFactory = new DefaultMediaSourceFactory(frameExtractionRequest.context, new DefaultExtractorsFactory());
            }
            ExoPlayer exoPlayerBuild = new ExoPlayer.Builder(frameExtractionRequest.context, new RenderersFactory() { // from class: androidx.media3.inspector.frame.FrameExtractorInternal$$ExternalSyntheticLambda5
                @Override // androidx.media3.exoplayer.RenderersFactory
                public final Renderer[] createRenderers(Handler handler, VideoRendererEventListener videoRendererEventListener, AudioRendererEventListener audioRendererEventListener, TextOutput textOutput, MetadataOutput metadataOutput) {
                    return this.f$0.m10625x9f4931fd(frameExtractionRequest, handler, videoRendererEventListener, audioRendererEventListener, textOutput, metadataOutput);
                }
            }, defaultMediaSourceFactory).setLooper(this.playerHandler.getLooper()).experimentalSetDynamicSchedulingEnabled(true).build();
            this.player = exoPlayerBuild;
            exoPlayerBuild.addAnalyticsListener(new PlayerListener());
            this.player.setPlayWhenReady(false);
        }
    }

    /* JADX INFO: renamed from: lambda$ensurePlayerInitialized$7$androidx-media3-inspector-frame-FrameExtractorInternal, reason: not valid java name */
    /* synthetic */ Renderer[] m10625x9f4931fd(FrameExtractionRequest frameExtractionRequest, Handler handler, VideoRendererEventListener videoRendererEventListener, AudioRendererEventListener audioRendererEventListener, TextOutput textOutput, MetadataOutput metadataOutput) {
        return new Renderer[]{new FrameExtractorRenderer(frameExtractionRequest.context, this.playerHandler, frameExtractionRequest.mediaCodecSelector, videoRendererEventListener, !frameExtractionRequest.extractHdrFrames, frameExtractionRequest.glObjectsProvider, this.extractedFrameNeedsRendering, this)};
    }

    private static ImmutableList<Effect> buildVideoEffects(List<Effect> list, FrameReader frameReader) {
        ImmutableList.Builder builder = new ImmutableList.Builder();
        builder.addAll((Iterable) list);
        builder.add(MIRROR_Y_TRANSFORMATION);
        builder.add(frameReader);
        return builder.build();
    }

    private static final class PlayerListener implements AnalyticsListener {
        private final FrameExtractorInternal internal;

        private PlayerListener(FrameExtractorInternal frameExtractorInternal) {
            this.internal = frameExtractorInternal;
        }

        @Override // androidx.media3.exoplayer.analytics.AnalyticsListener
        public void onPlayerError(AnalyticsListener.EventTime eventTime, PlaybackException playbackException) {
            ((CallbackToFutureAdapter.Completer) Preconditions.checkNotNull((CallbackToFutureAdapter.Completer) this.internal.activeTaskCompleter.getAndSet(null))).setException(playbackException);
        }

        @Override // androidx.media3.exoplayer.analytics.AnalyticsListener
        public void onPlaybackStateChanged(AnalyticsListener.EventTime eventTime, int i) {
            if (i != 3 || this.internal.extractedFrameNeedsRendering.get()) {
                return;
            }
            ((CallbackToFutureAdapter.Completer) Preconditions.checkNotNull((CallbackToFutureAdapter.Completer) this.internal.activeTaskCompleter.getAndSet(null))).set((FrameExtractor.Frame) Preconditions.checkNotNull(this.internal.lastSeekDedupeFrame));
        }
    }

    private static final class FrameReader implements GlEffect {
        private final FrameExtractorInternal internal;

        private FrameReader(FrameExtractorInternal frameExtractorInternal) {
            this.internal = frameExtractorInternal;
        }

        @Override // androidx.media3.effect.GlEffect
        public GlShaderProgram toGlShaderProgram(Context context, boolean z) throws VideoFrameProcessingException {
            return new FrameReadingGlShaderProgram(context, z, this.internal);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || getClass() != obj.getClass()) {
                return false;
            }
            return this.internal.equals(((FrameReader) obj).internal);
        }

        public int hashCode() {
            return this.internal.hashCode();
        }
    }

    private static final class FrameReadingGlShaderProgram extends PassthroughShaderProgram {
        private ByteBuffer byteBuffer;
        private final int bytesPerPixel;
        private GlProgram glProgram;
        private final boolean hdrUses16BitFloat;
        private GlTextureInfo hlgTextureInfo;
        private final FrameExtractorInternal internal;
        private final boolean useHdr;
        private final ImmutableList<float[]> visiblePolygon;

        private FrameReadingGlShaderProgram(Context context, boolean z, FrameExtractorInternal frameExtractorInternal) throws VideoFrameProcessingException {
            int i = 4;
            ImmutableList<float[]> immutableListOf = ImmutableList.of(new float[]{-1.0f, -1.0f, 0.0f, 1.0f}, new float[]{-1.0f, 1.0f, 0.0f, 1.0f}, new float[]{1.0f, 1.0f, 0.0f, 1.0f}, new float[]{1.0f, -1.0f, 0.0f, 1.0f});
            this.visiblePolygon = immutableListOf;
            this.useHdr = z;
            this.internal = frameExtractorInternal;
            this.byteBuffer = ByteBuffer.allocateDirect(0);
            if (z) {
                Preconditions.checkState(Build.VERSION.SDK_INT >= 34);
                try {
                    GlProgram glProgram = new GlProgram(context, androidx.media3.effect.R.raw.vertex_shader_transformation_es3, androidx.media3.effect.R.raw.fragment_shader_oetf_es3);
                    this.glProgram = glProgram;
                    glProgram.setFloatsUniform("uTexTransformationMatrix", GlUtil.create4x4IdentityMatrix());
                    this.glProgram.setFloatsUniform("uTransformationMatrix", GlUtil.create4x4IdentityMatrix());
                    this.glProgram.setFloatsUniform("uRgbMatrix", GlUtil.create4x4IdentityMatrix());
                    this.glProgram.setIntUniform("uOutputColorTransfer", 7);
                    this.glProgram.setBufferAttribute("aFramePosition", GlUtil.createVertexBuffer(immutableListOf), 4);
                } catch (GlUtil.GlException | IOException e) {
                    throw new VideoFrameProcessingException(e);
                }
            }
            boolean z2 = Build.VERSION.SDK_INT <= 35;
            this.hdrUses16BitFloat = z2;
            if (z && z2) {
                i = 8;
            }
            this.bytesPerPixel = i;
        }

        @Override // androidx.media3.effect.PassthroughShaderProgram, androidx.media3.effect.GlShaderProgram
        public void queueInputFrame(GlObjectsProvider glObjectsProvider, GlTextureInfo glTextureInfo, long j) {
            Bitmap bitmapCreateBitmap;
            GlTextureInfo glTextureInfo2;
            ensureConfigured(glObjectsProvider, glTextureInfo.width, glTextureInfo.height);
            if (this.useHdr) {
                if (Build.VERSION.SDK_INT < 34 || (glTextureInfo2 = this.hlgTextureInfo) == null) {
                    onError(new VideoFrameProcessingException(ExoPlaybackException.createForUnexpected(new IllegalArgumentException(), -2)));
                    return;
                }
                try {
                    GlUtil.focusFramebufferUsingCurrentContext(glTextureInfo2.fboId, this.hlgTextureInfo.width, this.hlgTextureInfo.height);
                    GlUtil.checkGlError();
                    ((GlProgram) Preconditions.checkNotNull(this.glProgram)).use();
                    this.glProgram.setSamplerTexIdUniform("uTexSampler", glTextureInfo.texId, 0);
                    this.glProgram.bindAttributesAndUniforms();
                    GLES20.glDrawArrays(6, 0, this.visiblePolygon.size());
                    GlUtil.checkGlError();
                    GLES20.glReadPixels(0, 0, this.hlgTextureInfo.width, this.hlgTextureInfo.height, 6408, this.hdrUses16BitFloat ? 5131 : 33640, this.byteBuffer);
                    GlUtil.checkGlError();
                    bitmapCreateBitmap = Bitmap.createBitmap((DisplayMetrics) null, this.hlgTextureInfo.width, this.hlgTextureInfo.height, this.hdrUses16BitFloat ? Bitmap.Config.RGBA_F16 : Bitmap.Config.RGBA_1010102, false, ColorSpace.get(ColorSpace.Named.BT2020_HLG));
                } catch (GlUtil.GlException e) {
                    onError(new VideoFrameProcessingException(e));
                    return;
                }
            } else {
                try {
                    GlUtil.focusFramebufferUsingCurrentContext(glTextureInfo.fboId, glTextureInfo.width, glTextureInfo.height);
                    GlUtil.checkGlError();
                    GLES20.glReadPixels(0, 0, glTextureInfo.width, glTextureInfo.height, 6408, 5121, this.byteBuffer);
                    GlUtil.checkGlError();
                    bitmapCreateBitmap = Bitmap.createBitmap(glTextureInfo.width, glTextureInfo.height, Bitmap.Config.ARGB_8888);
                } catch (GlUtil.GlException e2) {
                    onError(new VideoFrameProcessingException(e2));
                    return;
                }
            }
            bitmapCreateBitmap.copyPixelsFromBuffer(this.byteBuffer);
            CallbackToFutureAdapter.Completer completer = (CallbackToFutureAdapter.Completer) Preconditions.checkNotNull((CallbackToFutureAdapter.Completer) this.internal.activeTaskCompleter.getAndSet(null));
            FrameExtractor.Frame frame = new FrameExtractor.Frame(Util.usToMs(j), bitmapCreateBitmap);
            this.internal.lastSeekDedupeFrame = frame;
            completer.set(frame);
            getInputListener().onInputFrameProcessed(glTextureInfo);
        }

        private void ensureConfigured(GlObjectsProvider glObjectsProvider, int i, int i2) {
            int iCreateRgb10A2Texture;
            int i3 = i * i2 * this.bytesPerPixel;
            if (this.byteBuffer.capacity() != i3) {
                this.byteBuffer = ByteBuffer.allocateDirect(i3);
            }
            this.byteBuffer.clear();
            if (this.useHdr) {
                GlTextureInfo glTextureInfo = this.hlgTextureInfo;
                if (glTextureInfo != null && glTextureInfo.width == i && this.hlgTextureInfo.height == i2) {
                    return;
                }
                try {
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
                } catch (GlUtil.GlException e) {
                    onError(new VideoFrameProcessingException(e));
                }
            }
        }
    }

    private static final class FrameExtractorRenderer extends MediaCodecVideoRenderer {
        private List<Effect> effectsFromPlayer;
        private final AtomicBoolean extractedFrameNeedsRendering;
        private boolean frameRenderedSinceLastPositionReset;
        private final GlObjectsProvider glObjectsProvider;
        private final FrameExtractorInternal internal;
        private Effect rotation;
        private final boolean toneMapHdrToSdr;

        private FrameExtractorRenderer(Context context, Handler handler, MediaCodecSelector mediaCodecSelector, VideoRendererEventListener videoRendererEventListener, boolean z, GlObjectsProvider glObjectsProvider, AtomicBoolean atomicBoolean, FrameExtractorInternal frameExtractorInternal) {
            super(new MediaCodecVideoRenderer.Builder(context).setMediaCodecSelector(mediaCodecSelector).setAllowedJoiningTimeMs(0L).setEventHandler(handler).setEventListener(videoRendererEventListener).setMaxDroppedFramesToNotify(0));
            this.toneMapHdrToSdr = z;
            this.glObjectsProvider = glObjectsProvider;
            this.extractedFrameNeedsRendering = atomicBoolean;
            this.internal = frameExtractorInternal;
            this.effectsFromPlayer = ImmutableList.of();
        }

        @Override // androidx.media3.exoplayer.video.MediaCodecVideoRenderer
        protected PlaybackVideoGraphWrapper createPlaybackVideoGraphWrapper(Context context, VideoFrameReleaseControl videoFrameReleaseControl) {
            DefaultVideoFrameProcessor.Factory.Builder builder = new DefaultVideoFrameProcessor.Factory.Builder();
            GlObjectsProvider glObjectsProvider = this.glObjectsProvider;
            if (glObjectsProvider != null) {
                builder.setGlObjectsProvider(glObjectsProvider);
            }
            return new PlaybackVideoGraphWrapper.Builder(context, videoFrameReleaseControl).experimentalSetLateThresholdToDropInputUs(-9223372036854775807L).setEnablePlaylistMode(true).setClock(getClock()).setVideoGraphFactory(new SingleInputVideoGraph.Factory(builder.build())).build();
        }

        @Override // androidx.media3.exoplayer.video.MediaCodecVideoRenderer, androidx.media3.exoplayer.mediacodec.MediaCodecRenderer, androidx.media3.exoplayer.BaseRenderer
        protected void onStreamChanged(Format[] formatArr, long j, long j2, MediaSource.MediaPeriodId mediaPeriodId) throws ExoPlaybackException {
            ThumbnailMetadata thumbnailMetadata;
            super.onStreamChanged(formatArr, j, j2, mediaPeriodId);
            this.frameRenderedSinceLastPositionReset = false;
            setRotation(null);
            for (Format format : formatArr) {
                if (MimeTypes.isVideo(format.sampleMimeType) && format.metadata != null && (thumbnailMetadata = (ThumbnailMetadata) format.metadata.getFirstEntryOfType(ThumbnailMetadata.class)) != null && thumbnailMetadata.presentationTimeUs >= 0) {
                    this.internal.thumbnailPresentationTimeMs = Util.usToMs(thumbnailMetadata.presentationTimeUs);
                    return;
                }
            }
        }

        @Override // androidx.media3.exoplayer.video.MediaCodecVideoRenderer
        public void setVideoEffects(List<Effect> list) {
            this.effectsFromPlayer = list;
            setEffectsWithRotation();
        }

        @Override // androidx.media3.exoplayer.video.MediaCodecVideoRenderer, androidx.media3.exoplayer.mediacodec.MediaCodecRenderer
        protected boolean maybeInitializeProcessingPipeline(Format format) throws ExoPlaybackException {
            if (ColorInfo.isTransferHdr(format.colorInfo) && this.toneMapHdrToSdr) {
                format = format.buildUpon().setColorInfo(ColorInfo.SDR_BT709_LIMITED).build();
            }
            return super.maybeInitializeProcessingPipeline(format);
        }

        @Override // androidx.media3.exoplayer.video.MediaCodecVideoRenderer, androidx.media3.exoplayer.mediacodec.MediaCodecRenderer
        protected DecoderReuseEvaluation onInputFormatChanged(FormatHolder formatHolder) throws ExoPlaybackException {
            if (formatHolder.format != null) {
                Format format = formatHolder.format;
                if (format.rotationDegrees != 0) {
                    setRotation(new ScaleAndRotateTransformation.Builder().setRotationDegrees(360 - format.rotationDegrees).build());
                    formatHolder.format = format.buildUpon().setRotationDegrees(0).build();
                }
            }
            return super.onInputFormatChanged(formatHolder);
        }

        private void setRotation(Effect effect) {
            this.rotation = effect;
            setEffectsWithRotation();
        }

        private void setEffectsWithRotation() {
            ImmutableList.Builder builder = new ImmutableList.Builder();
            Effect effect = this.rotation;
            if (effect != null) {
                builder.add(effect);
            }
            builder.addAll((Iterable) this.effectsFromPlayer);
            super.setVideoEffects(builder.build());
        }

        @Override // androidx.media3.exoplayer.video.MediaCodecVideoRenderer, androidx.media3.exoplayer.mediacodec.MediaCodecRenderer, androidx.media3.exoplayer.Renderer
        public boolean isReady() {
            return this.frameRenderedSinceLastPositionReset;
        }

        @Override // androidx.media3.exoplayer.video.MediaCodecVideoRenderer, androidx.media3.exoplayer.mediacodec.MediaCodecRenderer
        protected boolean processOutputBuffer(long j, long j2, MediaCodecAdapter mediaCodecAdapter, ByteBuffer byteBuffer, int i, int i2, int i3, long j3, boolean z, boolean z2, Format format) throws ExoPlaybackException {
            if (this.frameRenderedSinceLastPositionReset) {
                return false;
            }
            return super.processOutputBuffer(j, j2, mediaCodecAdapter, byteBuffer, i, i2, i3, j3, z, z2, format);
        }

        @Override // androidx.media3.exoplayer.video.MediaCodecVideoRenderer
        protected void renderOutputBufferV21(MediaCodecAdapter mediaCodecAdapter, int i, long j, long j2) {
            if (this.frameRenderedSinceLastPositionReset) {
                return;
            }
            this.frameRenderedSinceLastPositionReset = true;
            super.renderOutputBufferV21(mediaCodecAdapter, i, j, j2);
        }

        @Override // androidx.media3.exoplayer.video.MediaCodecVideoRenderer, androidx.media3.exoplayer.mediacodec.MediaCodecRenderer, androidx.media3.exoplayer.BaseRenderer
        protected void onPositionReset(long j, boolean z, boolean z2) throws ExoPlaybackException {
            this.frameRenderedSinceLastPositionReset = false;
            this.extractedFrameNeedsRendering.set(true);
            super.onPositionReset(j, z, z2);
        }
    }
}
