package androidx.media3.exoplayer.video;

import android.content.Context;
import android.graphics.Point;
import android.hardware.display.DisplayManager;
import android.media.MediaCrypto;
import android.media.MediaFormat;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Pair;
import android.view.Display;
import android.view.Surface;
import androidx.media3.common.Effect;
import androidx.media3.common.Format;
import androidx.media3.common.MimeTypes;
import androidx.media3.common.PlaybackException;
import androidx.media3.common.Timeline;
import androidx.media3.common.VideoFrameProcessor;
import androidx.media3.common.VideoSize;
import androidx.media3.common.util.CodecSpecificDataUtil;
import androidx.media3.common.util.Log;
import androidx.media3.common.util.MediaFormatUtil;
import androidx.media3.common.util.Size;
import androidx.media3.common.util.TraceUtil;
import androidx.media3.common.util.Util;
import androidx.media3.decoder.DecoderInputBuffer;
import androidx.media3.exoplayer.CodecParameters;
import androidx.media3.exoplayer.DecoderReuseEvaluation;
import androidx.media3.exoplayer.ExoPlaybackException;
import androidx.media3.exoplayer.FormatHolder;
import androidx.media3.exoplayer.Renderer;
import androidx.media3.exoplayer.RendererCapabilities;
import androidx.media3.exoplayer.ScrubbingModeParameters;
import androidx.media3.exoplayer.mediacodec.MediaCodecAdapter;
import androidx.media3.exoplayer.mediacodec.MediaCodecDecoderException;
import androidx.media3.exoplayer.mediacodec.MediaCodecInfo;
import androidx.media3.exoplayer.mediacodec.MediaCodecRenderer;
import androidx.media3.exoplayer.mediacodec.MediaCodecSelector;
import androidx.media3.exoplayer.mediacodec.MediaCodecUtil;
import androidx.media3.exoplayer.source.MediaSource;
import androidx.window.core.layout.WindowSizeClass;
import com.facebook.react.uimanager.ViewProps;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableList;
import com.google.common.util.concurrent.MoreExecutors;
import java.nio.ByteBuffer;
import java.util.List;
import java.util.PriorityQueue;
import org.apache.commons.logging.LogFactory;
import org.checkerframework.checker.nullness.qual.RequiresNonNull;

/* JADX INFO: loaded from: classes8.dex */
public class MediaCodecVideoRenderer extends MediaCodecRenderer implements VideoFrameReleaseControl.FrameTimingEvaluator {
    public static final long DEFAULT_LATE_THRESHOLD_TO_DROP_DECODER_INPUT_US = 15000;
    private static final int HEVC_MAX_INPUT_SIZE_THRESHOLD = 2097152;
    private static final float INITIAL_FORMAT_MAX_INPUT_SIZE_SCALE_FACTOR = 1.5f;
    private static final String KEY_CROP_BOTTOM = "crop-bottom";
    private static final String KEY_CROP_LEFT = "crop-left";
    private static final String KEY_CROP_RIGHT = "crop-right";
    private static final String KEY_CROP_TOP = "crop-top";
    private static final int MAX_CONSECUTIVE_DROPPED_INPUT_BUFFERS_COUNT_TO_DISCARD_HEADER = 0;
    private static final long MIN_EARLY_US_LATE_THRESHOLD = -30000;
    private static final long MIN_EARLY_US_VERY_LATE_THRESHOLD = -500000;
    private static final long OFFSET_FROM_PERIOD_END_TO_TREAT_AS_LAST_US = 100000;
    private static final int[] STANDARD_LONG_EDGE_VIDEO_PX = {1920, 1600, 1440, 1280, 960, 854, 640, 540, WindowSizeClass.HEIGHT_DP_MEDIUM_LOWER_BOUND};
    private static final String TAG = "MediaCodecVideoRenderer";
    private static final long TUNNELING_EOS_PRESENTATION_TIME_US = Long.MAX_VALUE;
    private static boolean deviceNeedsSetOutputSurfaceWorkaround;
    private static boolean evaluatedDeviceNeedsSetOutputSurfaceWorkaround;
    private final Av1SampleDependencyParser av1SampleDependencyParser;
    private int buffersInCodecCount;
    private int changeFrameRateStrategy;
    private boolean codecHandlesHdr10PlusOutOfBandMetadata;
    private CodecMaxValues codecMaxValues;
    private boolean codecNeedsSetOutputSurfaceWorkaround;
    private int consecutiveDroppedFrameCount;
    private int consecutiveDroppedInputBufferCount;
    private final Context context;
    private VideoSize decodedVideoSize;
    private final boolean deviceNeedsNoPostProcessWorkaround;
    private Surface displaySurface;
    private final PriorityQueue<Long> droppedDecoderInputBufferTimestamps;
    private long droppedFrameAccumulationStartTimeMs;
    private int droppedFrames;
    private final boolean enableDurationToProgressUs;
    private final boolean enableMediaCodecBufferDecodeOnlyFlag;
    private final VideoRendererEventListener.EventDispatcher eventDispatcher;
    private VideoFrameMetadataListener frameMetadataListener;
    private boolean hasSetVideoSink;
    private boolean haveReportedFirstFrameRenderedForCurrentSurface;
    private boolean isFlushRequired;
    private long lastFrameReleaseTimeNs;
    private long lastResetToKeyFramePositionUs;
    private final int maxDroppedFramesToNotify;
    private final long minEarlyUsToDropDecoderInput;
    private long nextOutputBufferToProcessPresentationTimeUs;
    private int nextVideoSinkFirstFrameReleaseInstruction;
    private Size outputResolution;
    private final boolean ownsVideoSink;
    private boolean pendingVideoSinkInputStreamChange;
    private long periodDurationUs;
    private PlaceholderSurface placeholderSurface;
    private int rendererPriority;
    private VideoSize reportedVideoSize;
    private int scalingMode;
    private ScrubbingModeParameters scrubbingModeParameters;
    private long startPositionUs;
    private long totalVideoFrameProcessingOffsetUs;
    private boolean tunneling;
    private int tunnelingAudioSessionId;
    OnFrameRenderedListener tunnelingOnFrameRenderedListener;
    private List<Effect> videoEffects;
    private int videoFrameProcessingOffsetCount;
    private final VideoFrameReleaseControl videoFrameReleaseControl;
    private final VideoFrameReleaseEarlyTimeForecaster videoFrameReleaseEarlyTimeForecaster;
    private final VideoFrameReleaseControl.FrameReleaseInfo videoFrameReleaseInfo;
    private VideoSink videoSink;

    protected boolean shouldDropBuffersToKeyframe(long j, long j2, boolean z) {
        return j < MIN_EARLY_US_VERY_LATE_THRESHOLD && !z;
    }

    protected boolean shouldDropOutputBuffer(long j, long j2, boolean z) {
        return j < MIN_EARLY_US_LATE_THRESHOLD && !z;
    }

    protected boolean shouldForceRenderOutputBuffer(long j, long j2) {
        return j < MIN_EARLY_US_LATE_THRESHOLD && j2 > 100000;
    }

    protected boolean shouldSkipBuffersWithIdenticalReleaseTime() {
        return true;
    }

    public static final class Builder {
        private long allowedJoiningTimeMs;
        private boolean buildCalled;
        private MediaCodecAdapter.Factory codecAdapterFactory;
        private final Context context;
        private boolean enableDecoderFallback;
        private boolean enableDurationToProgressUs;
        private boolean enableMediaCodecBufferDecodeOnlyFlag;
        private Handler eventHandler;
        private VideoRendererEventListener eventListener;
        private int maxDroppedFramesToNotify;
        private VideoSink videoSink;
        private MediaCodecSelector mediaCodecSelector = MediaCodecSelector.DEFAULT;
        private float assumedMinimumCodecOperatingRate = 30.0f;
        private boolean parseAv1SampleDependencies = true;
        private long lateThresholdToDropDecoderInputUs = 15000;

        public Builder(Context context) {
            this.context = context;
            this.codecAdapterFactory = MediaCodecAdapter.Factory.getDefault(context);
        }

        public Builder setMediaCodecSelector(MediaCodecSelector mediaCodecSelector) {
            this.mediaCodecSelector = mediaCodecSelector;
            return this;
        }

        public Builder setCodecAdapterFactory(MediaCodecAdapter.Factory factory) {
            this.codecAdapterFactory = factory;
            return this;
        }

        public Builder setAllowedJoiningTimeMs(long j) {
            this.allowedJoiningTimeMs = j;
            return this;
        }

        public Builder setEnableDecoderFallback(boolean z) {
            this.enableDecoderFallback = z;
            return this;
        }

        public Builder setEventHandler(Handler handler) {
            this.eventHandler = handler;
            return this;
        }

        public Builder setEventListener(VideoRendererEventListener videoRendererEventListener) {
            this.eventListener = videoRendererEventListener;
            return this;
        }

        public Builder setMaxDroppedFramesToNotify(int i) {
            this.maxDroppedFramesToNotify = i;
            return this;
        }

        public Builder setAssumedMinimumCodecOperatingRate(float f) {
            this.assumedMinimumCodecOperatingRate = f;
            return this;
        }

        public Builder setVideoSink(VideoSink videoSink) {
            this.videoSink = videoSink;
            return this;
        }

        public Builder experimentalSetParseAv1SampleDependencies(boolean z) {
            this.parseAv1SampleDependencies = z;
            return this;
        }

        public Builder experimentalSetLateThresholdToDropDecoderInputUs(long j) {
            this.lateThresholdToDropDecoderInputUs = j;
            return this;
        }

        public Builder experimentalSetEnableMediaCodecBufferDecodeOnlyFlag(boolean z) {
            this.enableMediaCodecBufferDecodeOnlyFlag = z;
            return this;
        }

        public Builder setEnableDurationToProgressUs(boolean z) {
            this.enableDurationToProgressUs = z;
            return this;
        }

        public MediaCodecVideoRenderer build() {
            Preconditions.checkState(!this.buildCalled);
            Handler handler = this.eventHandler;
            Preconditions.checkState((handler == null && this.eventListener == null) || !(handler == null || this.eventListener == null));
            this.buildCalled = true;
            return new MediaCodecVideoRenderer(this);
        }
    }

    @Deprecated
    public MediaCodecVideoRenderer(Context context, MediaCodecSelector mediaCodecSelector) {
        this(new Builder(context).setMediaCodecSelector(mediaCodecSelector));
    }

    @Deprecated
    public MediaCodecVideoRenderer(Context context, MediaCodecSelector mediaCodecSelector, long j) {
        this(new Builder(context).setMediaCodecSelector(mediaCodecSelector).setAllowedJoiningTimeMs(j));
    }

    @Deprecated
    public MediaCodecVideoRenderer(Context context, MediaCodecSelector mediaCodecSelector, long j, Handler handler, VideoRendererEventListener videoRendererEventListener, int i) {
        this(new Builder(context).setMediaCodecSelector(mediaCodecSelector).setAllowedJoiningTimeMs(j).setEventHandler(handler).setEventListener(videoRendererEventListener).setMaxDroppedFramesToNotify(i));
    }

    @Deprecated
    public MediaCodecVideoRenderer(Context context, MediaCodecSelector mediaCodecSelector, long j, boolean z, Handler handler, VideoRendererEventListener videoRendererEventListener, int i) {
        this(new Builder(context).setMediaCodecSelector(mediaCodecSelector).setAllowedJoiningTimeMs(j).setEnableDecoderFallback(z).setEventHandler(handler).setEventListener(videoRendererEventListener).setMaxDroppedFramesToNotify(i));
    }

    @Deprecated
    public MediaCodecVideoRenderer(Context context, MediaCodecAdapter.Factory factory, MediaCodecSelector mediaCodecSelector, long j, boolean z, Handler handler, VideoRendererEventListener videoRendererEventListener, int i) {
        this(new Builder(context).setMediaCodecSelector(mediaCodecSelector).setCodecAdapterFactory(factory).setAllowedJoiningTimeMs(j).setEnableDecoderFallback(z).setEventHandler(handler).setEventListener(videoRendererEventListener).setMaxDroppedFramesToNotify(i));
    }

    @Deprecated
    public MediaCodecVideoRenderer(Context context, MediaCodecAdapter.Factory factory, MediaCodecSelector mediaCodecSelector, long j, boolean z, Handler handler, VideoRendererEventListener videoRendererEventListener, int i, float f) {
        this(new Builder(context).setMediaCodecSelector(mediaCodecSelector).setCodecAdapterFactory(factory).setAllowedJoiningTimeMs(j).setEnableDecoderFallback(z).setEventHandler(handler).setEventListener(videoRendererEventListener).setMaxDroppedFramesToNotify(i).setAssumedMinimumCodecOperatingRate(f));
    }

    @Deprecated
    public MediaCodecVideoRenderer(Context context, MediaCodecAdapter.Factory factory, MediaCodecSelector mediaCodecSelector, long j, boolean z, Handler handler, VideoRendererEventListener videoRendererEventListener, int i, float f, VideoSink videoSink) {
        this(new Builder(context).setMediaCodecSelector(mediaCodecSelector).setCodecAdapterFactory(factory).setAllowedJoiningTimeMs(j).setEnableDecoderFallback(z).setEventHandler(handler).setEventListener(videoRendererEventListener).setMaxDroppedFramesToNotify(i).setAssumedMinimumCodecOperatingRate(f).setVideoSink(videoSink));
    }

    protected MediaCodecVideoRenderer(Builder builder) {
        super(builder.context.getApplicationContext(), 2, builder.codecAdapterFactory, builder.mediaCodecSelector, builder.enableDecoderFallback, builder.assumedMinimumCodecOperatingRate);
        Context applicationContext = builder.context.getApplicationContext();
        this.context = applicationContext;
        this.maxDroppedFramesToNotify = builder.maxDroppedFramesToNotify;
        this.videoSink = builder.videoSink;
        this.eventDispatcher = new VideoRendererEventListener.EventDispatcher(builder.eventHandler, builder.eventListener);
        this.ownsVideoSink = this.videoSink == null;
        this.videoFrameReleaseControl = new VideoFrameReleaseControl(applicationContext, this, builder.allowedJoiningTimeMs);
        this.videoFrameReleaseInfo = new VideoFrameReleaseControl.FrameReleaseInfo();
        this.deviceNeedsNoPostProcessWorkaround = deviceNeedsNoPostProcessWorkaround();
        this.outputResolution = Size.UNKNOWN;
        this.scalingMode = 1;
        this.changeFrameRateStrategy = 0;
        this.decodedVideoSize = VideoSize.UNKNOWN;
        this.tunnelingAudioSessionId = 0;
        this.reportedVideoSize = null;
        this.rendererPriority = -1000;
        this.startPositionUs = -9223372036854775807L;
        this.periodDurationUs = -9223372036854775807L;
        this.av1SampleDependencyParser = builder.parseAv1SampleDependencies ? new Av1SampleDependencyParser() : null;
        this.droppedDecoderInputBufferTimestamps = new PriorityQueue<>();
        if (builder.lateThresholdToDropDecoderInputUs != -9223372036854775807L) {
            this.minEarlyUsToDropDecoderInput = -builder.lateThresholdToDropDecoderInputUs;
            this.videoFrameReleaseEarlyTimeForecaster = new VideoFrameReleaseEarlyTimeForecaster(1.0f);
        } else {
            this.minEarlyUsToDropDecoderInput = -9223372036854775807L;
            this.videoFrameReleaseEarlyTimeForecaster = null;
        }
        this.enableMediaCodecBufferDecodeOnlyFlag = builder.enableMediaCodecBufferDecodeOnlyFlag;
        this.enableDurationToProgressUs = builder.enableDurationToProgressUs;
        this.nextOutputBufferToProcessPresentationTimeUs = -9223372036854775807L;
        this.scrubbingModeParameters = null;
    }

    @Override // androidx.media3.exoplayer.video.VideoFrameReleaseControl.FrameTimingEvaluator
    public boolean shouldForceReleaseFrame(long j, long j2) {
        return shouldForceRenderOutputBuffer(j, j2);
    }

    @Override // androidx.media3.exoplayer.video.VideoFrameReleaseControl.FrameTimingEvaluator
    public boolean shouldDropFrame(long j, long j2, boolean z) {
        return shouldDropOutputBuffer(j, j2, z);
    }

    @Override // androidx.media3.exoplayer.video.VideoFrameReleaseControl.FrameTimingEvaluator
    public boolean shouldIgnoreFrame(long j, long j2, long j3, boolean z, boolean z2) throws ExoPlaybackException {
        if (this.videoSink != null && this.ownsVideoSink) {
            j2 -= getBufferTimestampAdjustmentUs();
        }
        return shouldDropBuffersToKeyframe(j, j3, z) && maybeDropBuffersToKeyframe(j2, z2);
    }

    @Override // androidx.media3.exoplayer.Renderer
    public String getName() {
        return TAG;
    }

    public static int supportsFormat(Context context, MediaCodecSelector mediaCodecSelector, Format format) throws MediaCodecUtil.DecoderQueryException {
        return supportsFormatInternal(context, mediaCodecSelector, format);
    }

    @Override // androidx.media3.exoplayer.mediacodec.MediaCodecRenderer
    protected int supportsFormat(MediaCodecSelector mediaCodecSelector, Format format) throws MediaCodecUtil.DecoderQueryException {
        return supportsFormatInternal(this.context, mediaCodecSelector, format);
    }

    private static int supportsFormatInternal(Context context, MediaCodecSelector mediaCodecSelector, Format format) throws MediaCodecUtil.DecoderQueryException {
        boolean z;
        int i = 0;
        if (!MimeTypes.isVideo(format.sampleMimeType)) {
            return RendererCapabilities.create(0);
        }
        boolean z2 = format.drmInitData != null;
        List<MediaCodecInfo> decoderInfos = getDecoderInfos(context, mediaCodecSelector, format, z2, false);
        if (z2 && decoderInfos.isEmpty()) {
            decoderInfos = getDecoderInfos(context, mediaCodecSelector, format, false, false);
        }
        if (decoderInfos.isEmpty()) {
            return RendererCapabilities.create(1);
        }
        if (!supportsFormatDrm(format)) {
            return RendererCapabilities.create(2);
        }
        MediaCodecInfo mediaCodecInfo = decoderInfos.get(0);
        boolean zIsFormatSupported = mediaCodecInfo.isFormatSupported(context, format);
        if (!zIsFormatSupported) {
            int i2 = 1;
            while (true) {
                if (i2 >= decoderInfos.size()) {
                    z = true;
                    break;
                }
                MediaCodecInfo mediaCodecInfo2 = decoderInfos.get(i2);
                if (mediaCodecInfo2.isFormatSupported(context, format)) {
                    z = false;
                    zIsFormatSupported = true;
                    mediaCodecInfo = mediaCodecInfo2;
                    break;
                }
                i2++;
            }
        } else {
            z = true;
            break;
        }
        int i3 = zIsFormatSupported ? 4 : 3;
        int i4 = mediaCodecInfo.isSeamlessAdaptationSupported(format) ? 16 : 8;
        int i5 = mediaCodecInfo.hardwareAccelerated ? 64 : 0;
        int i6 = z ? 128 : 0;
        if (MimeTypes.VIDEO_DOLBY_VISION.equals(format.sampleMimeType) && !Api26.doesDisplaySupportDolbyVision(context)) {
            i6 = 256;
        }
        if (zIsFormatSupported) {
            List<MediaCodecInfo> decoderInfos2 = getDecoderInfos(context, mediaCodecSelector, format, z2, true);
            if (!decoderInfos2.isEmpty()) {
                MediaCodecInfo mediaCodecInfo3 = MediaCodecUtil.getDecoderInfosSortedByFormatSupport(context, decoderInfos2, format).get(0);
                if (mediaCodecInfo3.isFormatSupported(context, format) && mediaCodecInfo3.isSeamlessAdaptationSupported(format)) {
                    i = 32;
                }
            }
        }
        return RendererCapabilities.create(i3, i4, i, i5, i6);
    }

    @Override // androidx.media3.exoplayer.mediacodec.MediaCodecRenderer
    protected List<MediaCodecInfo> getDecoderInfos(MediaCodecSelector mediaCodecSelector, Format format, boolean z) throws MediaCodecUtil.DecoderQueryException {
        Context context = this.context;
        return MediaCodecUtil.getDecoderInfosSortedByFormatSupport(context, getDecoderInfos(context, mediaCodecSelector, format, z, this.tunneling), format);
    }

    private static List<MediaCodecInfo> getDecoderInfos(Context context, MediaCodecSelector mediaCodecSelector, Format format, boolean z, boolean z2) throws MediaCodecUtil.DecoderQueryException {
        if (format.sampleMimeType == null) {
            return ImmutableList.of();
        }
        if (MimeTypes.VIDEO_DOLBY_VISION.equals(format.sampleMimeType) && !Api26.doesDisplaySupportDolbyVision(context)) {
            List<MediaCodecInfo> alternativeDecoderInfos = MediaCodecUtil.getAlternativeDecoderInfos(mediaCodecSelector, format, z, z2);
            if (!alternativeDecoderInfos.isEmpty()) {
                return alternativeDecoderInfos;
            }
        }
        return MediaCodecUtil.getDecoderInfosSoftMatch(mediaCodecSelector, format, z, z2);
    }

    private static final class Api26 {
        private Api26() {
        }

        public static boolean doesDisplaySupportDolbyVision(Context context) {
            Display.HdrCapabilities hdrCapabilities;
            DisplayManager displayManager = (DisplayManager) context.getSystemService(ViewProps.DISPLAY);
            Display display = displayManager != null ? displayManager.getDisplay(0) : null;
            if (display == null || !display.isHdr() || (hdrCapabilities = display.getHdrCapabilities()) == null) {
                return false;
            }
            for (int i : hdrCapabilities.getSupportedHdrTypes()) {
                if (i == 1) {
                    return true;
                }
            }
            return false;
        }
    }

    @Override // androidx.media3.exoplayer.BaseRenderer
    protected void onInit() {
        super.onInit();
    }

    @Override // androidx.media3.exoplayer.mediacodec.MediaCodecRenderer, androidx.media3.exoplayer.BaseRenderer
    protected void onEnabled(boolean z, boolean z2) throws ExoPlaybackException {
        super.onEnabled(z, z2);
        boolean z3 = getConfiguration().tunneling;
        Preconditions.checkState((z3 && this.tunnelingAudioSessionId == 0) ? false : true);
        if (this.tunneling != z3) {
            this.tunneling = z3;
            releaseCodec();
        }
        this.eventDispatcher.enabled(this.decoderCounters);
        if (!this.hasSetVideoSink) {
            if (this.videoEffects != null && this.videoSink == null) {
                PlaybackVideoGraphWrapper playbackVideoGraphWrapperCreatePlaybackVideoGraphWrapper = createPlaybackVideoGraphWrapper(this.context, this.videoFrameReleaseControl);
                playbackVideoGraphWrapperCreatePlaybackVideoGraphWrapper.setTotalVideoInputCount(1);
                this.videoSink = playbackVideoGraphWrapperCreatePlaybackVideoGraphWrapper.getSink(0);
            }
            this.hasSetVideoSink = true;
        }
        if (this.videoSink != null) {
            configureVideoSink();
            this.nextVideoSinkFirstFrameReleaseInstruction = !z2 ? 1 : 0;
            experimentalEnableProcessedStreamChangedAtStart();
        } else {
            this.videoFrameReleaseControl.setClock(getClock());
            this.videoFrameReleaseControl.onStreamChanged(!z2 ? 1 : 0);
        }
    }

    @RequiresNonNull({"videoSink"})
    private void configureVideoSink() {
        this.videoSink.setListener(new VideoSink.Listener() { // from class: androidx.media3.exoplayer.video.MediaCodecVideoRenderer.1
            @Override // androidx.media3.exoplayer.video.VideoSink.Listener
            public void onVideoSizeChanged(VideoSize videoSize) {
            }

            @Override // androidx.media3.exoplayer.video.VideoSink.Listener
            public void onFrameAvailableForRendering() {
                Renderer.WakeupListener wakeupListener = MediaCodecVideoRenderer.this.getWakeupListener();
                if (wakeupListener != null) {
                    wakeupListener.onWakeup();
                }
            }

            @Override // androidx.media3.exoplayer.video.VideoSink.Listener
            public void onFirstFrameRendered() {
                if (MediaCodecVideoRenderer.this.displaySurface != null) {
                    MediaCodecVideoRenderer.this.notifyRenderedFirstFrame();
                }
            }

            @Override // androidx.media3.exoplayer.video.VideoSink.Listener
            public void onFrameDropped() {
                if (MediaCodecVideoRenderer.this.displaySurface != null) {
                    MediaCodecVideoRenderer.this.updateDroppedBufferCounters(0, 1);
                }
            }

            @Override // androidx.media3.exoplayer.video.VideoSink.Listener
            public void onError(VideoSink.VideoSinkException videoSinkException) {
                MediaCodecVideoRenderer mediaCodecVideoRenderer = MediaCodecVideoRenderer.this;
                mediaCodecVideoRenderer.setPendingPlaybackException(mediaCodecVideoRenderer.createRendererException(videoSinkException, videoSinkException.format, PlaybackException.ERROR_CODE_VIDEO_FRAME_PROCESSING_FAILED));
            }
        }, MoreExecutors.directExecutor());
        VideoFrameMetadataListener videoFrameMetadataListener = this.frameMetadataListener;
        if (videoFrameMetadataListener != null) {
            this.videoSink.setVideoFrameMetadataListener(videoFrameMetadataListener);
        }
        if (this.displaySurface != null && !this.outputResolution.equals(Size.UNKNOWN)) {
            this.videoSink.setOutputSurfaceInfo(this.displaySurface, this.outputResolution);
        }
        this.videoSink.setChangeFrameRateStrategy(this.changeFrameRateStrategy);
        this.videoSink.setPlaybackSpeed(getPlaybackSpeed());
        List<Effect> list = this.videoEffects;
        if (list != null) {
            this.videoSink.setVideoEffects(list);
        }
    }

    protected PlaybackVideoGraphWrapper createPlaybackVideoGraphWrapper(Context context, VideoFrameReleaseControl videoFrameReleaseControl) {
        PlaybackVideoGraphWrapper.Builder enablePlaylistMode = new PlaybackVideoGraphWrapper.Builder(context, videoFrameReleaseControl).setEnablePlaylistMode(true);
        long j = this.minEarlyUsToDropDecoderInput;
        return enablePlaylistMode.experimentalSetLateThresholdToDropInputUs(j != -9223372036854775807L ? -j : -9223372036854775807L).setClock(getClock()).build();
    }

    @Override // androidx.media3.exoplayer.Renderer
    public void enableMayRenderStartOfStream() {
        VideoSink videoSink = this.videoSink;
        if (videoSink != null) {
            int i = this.nextVideoSinkFirstFrameReleaseInstruction;
            if (i == 0 || i == 1) {
                this.nextVideoSinkFirstFrameReleaseInstruction = 0;
                return;
            } else {
                videoSink.allowReleaseFirstFrameBeforeStarted();
                return;
            }
        }
        this.videoFrameReleaseControl.allowReleaseFirstFrameBeforeStarted();
    }

    @Override // androidx.media3.exoplayer.mediacodec.MediaCodecRenderer, androidx.media3.exoplayer.BaseRenderer
    protected void onStreamChanged(Format[] formatArr, long j, long j2, MediaSource.MediaPeriodId mediaPeriodId) throws ExoPlaybackException {
        super.onStreamChanged(formatArr, j, j2, mediaPeriodId);
        updatePeriodDurationUs(mediaPeriodId);
        VideoFrameReleaseEarlyTimeForecaster videoFrameReleaseEarlyTimeForecaster = this.videoFrameReleaseEarlyTimeForecaster;
        if (videoFrameReleaseEarlyTimeForecaster != null) {
            videoFrameReleaseEarlyTimeForecaster.reset();
        }
    }

    @Override // androidx.media3.exoplayer.BaseRenderer
    protected void onTimelineChanged(Timeline timeline) {
        super.onTimelineChanged(timeline);
        MediaSource.MediaPeriodId mediaPeriodId = getMediaPeriodId();
        if (mediaPeriodId != null) {
            updatePeriodDurationUs(mediaPeriodId);
        }
    }

    private void updatePeriodDurationUs(MediaSource.MediaPeriodId mediaPeriodId) {
        Timeline timeline = getTimeline();
        if (timeline.isEmpty()) {
            this.periodDurationUs = -9223372036854775807L;
            return;
        }
        int indexOfPeriod = timeline.getIndexOfPeriod(mediaPeriodId.periodUid);
        if (indexOfPeriod == -1) {
            this.periodDurationUs = -9223372036854775807L;
        } else {
            this.periodDurationUs = timeline.getPeriod(indexOfPeriod, new Timeline.Period()).getDurationUs();
        }
    }

    @Override // androidx.media3.exoplayer.mediacodec.MediaCodecRenderer, androidx.media3.exoplayer.BaseRenderer
    protected void onPositionReset(long j, boolean z, boolean z2) throws ExoPlaybackException {
        VideoSink videoSink = this.videoSink;
        if (videoSink != null && !z) {
            videoSink.flush(true);
        }
        if (z2) {
            this.lastResetToKeyFramePositionUs = j;
        }
        super.onPositionReset(j, z, z2);
        if (this.videoSink == null) {
            this.videoFrameReleaseControl.reset();
        }
        VideoFrameReleaseEarlyTimeForecaster videoFrameReleaseEarlyTimeForecaster = this.videoFrameReleaseEarlyTimeForecaster;
        if (videoFrameReleaseEarlyTimeForecaster != null) {
            videoFrameReleaseEarlyTimeForecaster.reset();
        }
        if (z) {
            VideoSink videoSink2 = this.videoSink;
            if (videoSink2 != null) {
                videoSink2.join(false);
            } else {
                this.videoFrameReleaseControl.join(false);
            }
        }
        maybeSetupTunnelingForFirstFrame();
        this.consecutiveDroppedFrameCount = 0;
        this.nextOutputBufferToProcessPresentationTimeUs = -9223372036854775807L;
    }

    @Override // androidx.media3.exoplayer.Renderer
    public boolean supportsResetPositionWithoutKeyFrameReset(long j) {
        if (getLargestQueuedPresentationTimeUs() == -9223372036854775807L || j < this.lastResetToKeyFramePositionUs) {
            return false;
        }
        long lastProcessedOutputBufferTimeUs = getLastProcessedOutputBufferTimeUs();
        return lastProcessedOutputBufferTimeUs == -9223372036854775807L || j > lastProcessedOutputBufferTimeUs;
    }

    @Override // androidx.media3.exoplayer.mediacodec.MediaCodecRenderer, androidx.media3.exoplayer.Renderer
    public boolean isEnded() {
        if (!super.isEnded()) {
            return false;
        }
        VideoSink videoSink = this.videoSink;
        return videoSink == null || videoSink.isEnded();
    }

    @Override // androidx.media3.exoplayer.mediacodec.MediaCodecRenderer, androidx.media3.exoplayer.Renderer
    public boolean isReady() {
        boolean zIsReadyForDecoding = isReadyForDecoding();
        VideoSink videoSink = this.videoSink;
        if (videoSink != null) {
            return videoSink.isReady(zIsReadyForDecoding);
        }
        if (zIsReadyForDecoding && (getCodec() == null || this.tunneling)) {
            return true;
        }
        return this.videoFrameReleaseControl.isReady(zIsReadyForDecoding);
    }

    @Override // androidx.media3.exoplayer.mediacodec.MediaCodecRenderer, androidx.media3.exoplayer.BaseRenderer
    protected void onStarted() {
        super.onStarted();
        this.droppedFrames = 0;
        this.droppedFrameAccumulationStartTimeMs = getClock().elapsedRealtime();
        this.totalVideoFrameProcessingOffsetUs = 0L;
        this.videoFrameProcessingOffsetCount = 0;
        VideoSink videoSink = this.videoSink;
        if (videoSink != null) {
            videoSink.startRendering();
        } else {
            this.videoFrameReleaseControl.onStarted();
        }
    }

    @Override // androidx.media3.exoplayer.mediacodec.MediaCodecRenderer, androidx.media3.exoplayer.BaseRenderer
    protected void onStopped() {
        maybeNotifyDroppedFrames();
        maybeNotifyVideoFrameProcessingOffset();
        VideoSink videoSink = this.videoSink;
        if (videoSink != null) {
            videoSink.stopRendering();
        } else {
            this.videoFrameReleaseControl.onStopped();
        }
        VideoFrameReleaseEarlyTimeForecaster videoFrameReleaseEarlyTimeForecaster = this.videoFrameReleaseEarlyTimeForecaster;
        if (videoFrameReleaseEarlyTimeForecaster != null) {
            videoFrameReleaseEarlyTimeForecaster.reset();
        }
        super.onStopped();
    }

    @Override // androidx.media3.exoplayer.mediacodec.MediaCodecRenderer, androidx.media3.exoplayer.BaseRenderer
    protected void onDisabled() {
        this.reportedVideoSize = null;
        this.periodDurationUs = -9223372036854775807L;
        maybeSetupTunnelingForFirstFrame();
        this.haveReportedFirstFrameRenderedForCurrentSurface = false;
        this.tunnelingOnFrameRenderedListener = null;
        this.isFlushRequired = true;
        this.nextOutputBufferToProcessPresentationTimeUs = -9223372036854775807L;
        try {
            super.onDisabled();
        } finally {
            this.eventDispatcher.disabled(this.decoderCounters);
            this.eventDispatcher.videoSizeChanged(VideoSize.UNKNOWN);
        }
    }

    @Override // androidx.media3.exoplayer.mediacodec.MediaCodecRenderer, androidx.media3.exoplayer.BaseRenderer
    protected void onReset() {
        try {
            super.onReset();
        } finally {
            this.hasSetVideoSink = false;
            this.startPositionUs = -9223372036854775807L;
            this.nextOutputBufferToProcessPresentationTimeUs = -9223372036854775807L;
            releasePlaceholderSurface();
        }
    }

    @Override // androidx.media3.exoplayer.BaseRenderer
    protected void onRelease() {
        super.onRelease();
        VideoSink videoSink = this.videoSink;
        if (videoSink == null || !this.ownsVideoSink) {
            return;
        }
        videoSink.release();
    }

    @Override // androidx.media3.exoplayer.mediacodec.MediaCodecRenderer, androidx.media3.exoplayer.BaseRenderer, androidx.media3.exoplayer.PlayerMessage.Target
    public void handleMessage(int i, Object obj) throws ExoPlaybackException {
        if (i == 1) {
            setOutput(obj);
            return;
        }
        if (i == 7) {
            VideoFrameMetadataListener videoFrameMetadataListener = (VideoFrameMetadataListener) Preconditions.checkNotNull(obj);
            this.frameMetadataListener = videoFrameMetadataListener;
            VideoSink videoSink = this.videoSink;
            if (videoSink != null) {
                videoSink.setVideoFrameMetadataListener(videoFrameMetadataListener);
                return;
            }
            return;
        }
        if (i == 10) {
            int iIntValue = ((Integer) Preconditions.checkNotNull(obj)).intValue();
            if (this.tunnelingAudioSessionId != iIntValue) {
                this.tunnelingAudioSessionId = iIntValue;
                if (this.tunneling) {
                    releaseCodec();
                    return;
                }
                return;
            }
            return;
        }
        if (i == 4) {
            this.scalingMode = ((Integer) Preconditions.checkNotNull(obj)).intValue();
            MediaCodecAdapter codec = getCodec();
            if (codec != null) {
                codec.setVideoScalingMode(this.scalingMode);
                return;
            }
            return;
        }
        if (i == 5) {
            int iIntValue2 = ((Integer) Preconditions.checkNotNull(obj)).intValue();
            this.changeFrameRateStrategy = iIntValue2;
            VideoSink videoSink2 = this.videoSink;
            if (videoSink2 != null) {
                videoSink2.setChangeFrameRateStrategy(iIntValue2);
                return;
            } else {
                this.videoFrameReleaseControl.setChangeFrameRateStrategy(iIntValue2);
                return;
            }
        }
        if (i == 13) {
            setVideoEffects((List) Preconditions.checkNotNull(obj));
            return;
        }
        if (i == 14) {
            Size size = (Size) Preconditions.checkNotNull(obj);
            if (size.getWidth() == 0 || size.getHeight() == 0) {
                return;
            }
            this.outputResolution = size;
            VideoSink videoSink3 = this.videoSink;
            if (videoSink3 != null) {
                videoSink3.setOutputSurfaceInfo((Surface) Preconditions.checkNotNull(this.displaySurface), size);
                return;
            }
            return;
        }
        switch (i) {
            case 16:
                this.rendererPriority = ((Integer) Preconditions.checkNotNull(obj)).intValue();
                updateCodecImportance();
                break;
            case 17:
                Surface surface = this.displaySurface;
                setOutput(null);
                ((MediaCodecVideoRenderer) Preconditions.checkNotNull(obj)).handleMessage(1, surface);
                break;
            case 18:
                ScrubbingModeParameters scrubbingModeParameters = this.scrubbingModeParameters;
                boolean z = scrubbingModeParameters != null && scrubbingModeParameters.shouldIncreaseCodecOperatingRate;
                ScrubbingModeParameters scrubbingModeParameters2 = (ScrubbingModeParameters) obj;
                this.scrubbingModeParameters = scrubbingModeParameters2;
                if (z != (scrubbingModeParameters2 != null && scrubbingModeParameters2.shouldIncreaseCodecOperatingRate)) {
                    updateCodecOperatingRate();
                }
                break;
            default:
                super.handleMessage(i, obj);
                break;
        }
    }

    private void setOutput(Object obj) throws ExoPlaybackException {
        Surface surface = obj instanceof Surface ? (Surface) obj : null;
        if (this.displaySurface == surface) {
            if (surface != null) {
                maybeRenotifyVideoSizeChanged();
                maybeRenotifyRenderedFirstFrame();
                return;
            }
            return;
        }
        this.displaySurface = surface;
        if (this.videoSink == null) {
            this.videoFrameReleaseControl.setOutputSurface(surface);
        }
        this.haveReportedFirstFrameRenderedForCurrentSurface = false;
        int state = getState();
        MediaCodecAdapter codec = getCodec();
        if (codec != null && this.videoSink == null) {
            MediaCodecInfo mediaCodecInfo = (MediaCodecInfo) Preconditions.checkNotNull(getCodecInfo());
            if (hasSurfaceForCodec(mediaCodecInfo) && !this.codecNeedsSetOutputSurfaceWorkaround) {
                setOutputSurface(codec, getSurfaceForCodec(mediaCodecInfo));
            } else {
                releaseCodec();
                maybeInitCodecOrBypass();
            }
        }
        if (surface != null) {
            maybeRenotifyVideoSizeChanged();
        } else {
            this.reportedVideoSize = null;
            VideoSink videoSink = this.videoSink;
            if (videoSink != null) {
                videoSink.clearOutputSurfaceInfo();
            }
        }
        if (state == 2) {
            VideoSink videoSink2 = this.videoSink;
            if (videoSink2 != null) {
                videoSink2.join(true);
            } else {
                this.videoFrameReleaseControl.join(true);
            }
        }
        maybeSetupTunnelingForFirstFrame();
    }

    @Override // androidx.media3.exoplayer.mediacodec.MediaCodecRenderer
    protected boolean shouldInitCodec(MediaCodecInfo mediaCodecInfo) {
        return hasSurfaceForCodec(mediaCodecInfo);
    }

    @Override // androidx.media3.exoplayer.mediacodec.MediaCodecRenderer
    protected MediaCodecAdapter.Configuration getMediaCodecConfiguration(MediaCodecInfo mediaCodecInfo, Format format, MediaCrypto mediaCrypto, float f) {
        String str = mediaCodecInfo.codecMimeType;
        CodecMaxValues codecMaxValues = getCodecMaxValues(mediaCodecInfo, format, getStreamFormats());
        this.codecMaxValues = codecMaxValues;
        MediaFormat mediaFormat = getMediaFormat(format, str, codecMaxValues, f, this.deviceNeedsNoPostProcessWorkaround, this.tunneling ? this.tunnelingAudioSessionId : 0);
        Surface surfaceForCodec = getSurfaceForCodec(mediaCodecInfo);
        maybeSetKeyAllowFrameDrop(mediaFormat);
        return MediaCodecAdapter.Configuration.createForVideoDecoding(mediaCodecInfo, mediaFormat, format, surfaceForCodec, mediaCrypto);
    }

    private void maybeSetKeyAllowFrameDrop(MediaFormat mediaFormat) {
        if (this.videoSink == null || Util.isFrameDropAllowedOnSurfaceInput(this.context)) {
            return;
        }
        mediaFormat.setInteger("allow-frame-drop", 0);
    }

    @Override // androidx.media3.exoplayer.mediacodec.MediaCodecRenderer
    protected DecoderReuseEvaluation canReuseCodec(MediaCodecInfo mediaCodecInfo, Format format, Format format2) {
        DecoderReuseEvaluation decoderReuseEvaluationCanReuseCodec = mediaCodecInfo.canReuseCodec(format, format2);
        int i = decoderReuseEvaluationCanReuseCodec.discardReasons;
        CodecMaxValues codecMaxValues = (CodecMaxValues) Preconditions.checkNotNull(this.codecMaxValues);
        if (format2.width > codecMaxValues.width || format2.height > codecMaxValues.height) {
            i |= 256;
        }
        if (getMaxInputSize(mediaCodecInfo, format2) > codecMaxValues.inputSize) {
            i |= 64;
        }
        if (this.changeFrameRateStrategy != Integer.MIN_VALUE && format.frameRate != -1.0f && format2.frameRate != -1.0f && Math.abs(format2.frameRate - format.frameRate) > 1.0f && cannotChangeSurfaceFrameRateMidPlayback()) {
            i |= 65536;
        }
        int i2 = i;
        return new DecoderReuseEvaluation(mediaCodecInfo.name, format, format2, i2 != 0 ? 0 : decoderReuseEvaluationCanReuseCodec.result, i2);
    }

    @Override // androidx.media3.exoplayer.mediacodec.MediaCodecRenderer, androidx.media3.exoplayer.Renderer
    public void render(long j, long j2) throws ExoPlaybackException {
        VideoSink videoSink = this.videoSink;
        if (videoSink != null) {
            try {
                videoSink.render(j, j2);
            } catch (VideoSink.VideoSinkException e) {
                throw createRendererException(e, e.format, PlaybackException.ERROR_CODE_VIDEO_FRAME_PROCESSING_FAILED);
            }
        }
        super.render(j, j2);
    }

    @Override // androidx.media3.exoplayer.mediacodec.MediaCodecRenderer
    protected void resetCodecStateForFlush() {
        super.resetCodecStateForFlush();
        this.droppedDecoderInputBufferTimestamps.clear();
        this.buffersInCodecCount = 0;
        this.consecutiveDroppedInputBufferCount = 0;
        this.isFlushRequired = false;
        this.nextOutputBufferToProcessPresentationTimeUs = -9223372036854775807L;
        Av1SampleDependencyParser av1SampleDependencyParser = this.av1SampleDependencyParser;
        if (av1SampleDependencyParser != null) {
            av1SampleDependencyParser.reset();
        }
    }

    @Override // androidx.media3.exoplayer.mediacodec.MediaCodecRenderer, androidx.media3.exoplayer.Renderer
    public void setPlaybackSpeed(float f, float f2) throws ExoPlaybackException {
        super.setPlaybackSpeed(f, f2);
        VideoSink videoSink = this.videoSink;
        if (videoSink != null) {
            videoSink.setPlaybackSpeed(f);
        } else {
            this.videoFrameReleaseControl.setPlaybackSpeed(f);
        }
        VideoFrameReleaseEarlyTimeForecaster videoFrameReleaseEarlyTimeForecaster = this.videoFrameReleaseEarlyTimeForecaster;
        if (videoFrameReleaseEarlyTimeForecaster != null) {
            videoFrameReleaseEarlyTimeForecaster.setPlaybackSpeed(f);
        }
    }

    /* JADX WARN: Code duplicated, block: B:19:0x0046  */
    public static int getCodecMaxInputSize(MediaCodecInfo mediaCodecInfo, Format format) {
        int i = format.width;
        int i2 = format.height;
        if (i == -1 || i2 == -1) {
            return -1;
        }
        String str = (String) Preconditions.checkNotNull(format.sampleMimeType);
        if (MimeTypes.VIDEO_DOLBY_VISION.equals(str)) {
            Pair<Integer, Integer> codecProfileAndLevel = CodecSpecificDataUtil.getCodecProfileAndLevel(format);
            if (codecProfileAndLevel == null) {
                str = MimeTypes.VIDEO_H265;
            } else {
                int iIntValue = ((Integer) codecProfileAndLevel.first).intValue();
                if (iIntValue == 512 || iIntValue == 1 || iIntValue == 2) {
                    str = MimeTypes.VIDEO_H264;
                } else if (iIntValue == 1024) {
                    str = MimeTypes.VIDEO_AV1;
                } else {
                    str = MimeTypes.VIDEO_H265;
                }
            }
        }
        str.hashCode();
        switch (str) {
            case "video/3gpp":
            case "video/av01":
            case "video/mp4v-es":
            case "video/x-vnd.on2.vp8":
                return getMaxSampleSize(i * i2, 2);
            case "video/hevc":
                return Math.max(2097152, getMaxSampleSize(i * i2, 2));
            case "video/avc":
                if ("BRAVIA 4K 2015".equals(Build.MODEL) || ("Amazon".equals(Build.MANUFACTURER) && ("KFSOWI".equals(Build.MODEL) || ("AFTS".equals(Build.MODEL) && mediaCodecInfo.secure)))) {
                    return -1;
                }
                return getMaxSampleSize(Util.ceilDivide(i, 16) * Util.ceilDivide(i2, 16) * 256, 2);
            case "video/x-vnd.on2.vp9":
                return getMaxSampleSize(i * i2, 4);
            default:
                return -1;
        }
    }

    @Override // androidx.media3.exoplayer.mediacodec.MediaCodecRenderer
    protected long getDurationToProgressUs(long j, long j2, boolean z) {
        if (!this.enableDurationToProgressUs || !z) {
            return super.getDurationToProgressUs(j, j2, z);
        }
        if (getState() != 2) {
            return (isReady() || isEnded()) ? 1000000L : 10000L;
        }
        if (this.nextOutputBufferToProcessPresentationTimeUs != -9223372036854775807L && this.videoSink == null) {
            if (isEnded()) {
                return Math.max(10000L, (long) (((this.nextOutputBufferToProcessPresentationTimeUs - j) / getPlaybackSpeed()) / 2.0f));
            }
            try {
                if (this.videoFrameReleaseControl.getFrameReleaseAction(this.nextOutputBufferToProcessPresentationTimeUs, j, j2, getOutputStreamStartPositionUs(), false, false, this.videoFrameReleaseInfo) != 5) {
                    return 0L;
                }
                return Math.max(0L, (this.videoFrameReleaseInfo.getEarlyUs() + (Util.msToUs(getClock().elapsedRealtime()) - j2)) - 25000);
            } catch (ExoPlaybackException unused) {
                Log.w(TAG, "Error while evaluating frame release action");
            }
        }
        return 10000L;
    }

    @Override // androidx.media3.exoplayer.mediacodec.MediaCodecRenderer
    protected float getCodecOperatingRateV23(float f, Format format, Format[] formatArr) {
        MediaCodecInfo codecInfo;
        float fMax = -1.0f;
        for (Format format2 : formatArr) {
            float f2 = format2.frameRate;
            if (f2 != -1.0f) {
                fMax = Math.max(fMax, f2);
            }
        }
        float f3 = fMax == -1.0f ? -1.0f : fMax * f;
        if (this.scrubbingModeParameters == null || (codecInfo = getCodecInfo()) == null) {
            return f3;
        }
        float maxSupportedFrameRate = codecInfo.getMaxSupportedFrameRate(format.width, format.height);
        return f3 != -1.0f ? Math.max(f3, maxSupportedFrameRate) : maxSupportedFrameRate;
    }

    @Override // androidx.media3.exoplayer.mediacodec.MediaCodecRenderer
    protected boolean maybeInitializeProcessingPipeline(Format format) throws ExoPlaybackException {
        VideoSink videoSink = this.videoSink;
        if (videoSink == null || videoSink.isInitialized()) {
            return true;
        }
        try {
            return this.videoSink.initialize(format);
        } catch (VideoSink.VideoSinkException e) {
            throw createRendererException(e, format, 7000);
        }
    }

    public void setVideoEffects(List<Effect> list) {
        if (list.equals(VideoFrameProcessor.REDRAW)) {
            VideoSink videoSink = this.videoSink;
            if (videoSink == null || !videoSink.isInitialized()) {
                return;
            }
            this.videoSink.redraw();
            return;
        }
        this.videoEffects = list;
        VideoSink videoSink2 = this.videoSink;
        if (videoSink2 != null) {
            videoSink2.setVideoEffects(list);
        }
    }

    @Override // androidx.media3.exoplayer.mediacodec.MediaCodecRenderer
    protected void onCodecInitialized(String str, MediaCodecAdapter.Configuration configuration, long j, long j2) {
        this.eventDispatcher.decoderInitialized(str, j, j2);
        this.codecNeedsSetOutputSurfaceWorkaround = codecNeedsSetOutputSurfaceWorkaround(str);
        this.codecHandlesHdr10PlusOutOfBandMetadata = ((MediaCodecInfo) Preconditions.checkNotNull(getCodecInfo())).isHdr10PlusOutOfBandMetadataSupported();
        maybeSetupTunnelingForFirstFrame();
    }

    @Override // androidx.media3.exoplayer.mediacodec.MediaCodecRenderer
    protected void onCodecReleased(String str) {
        this.eventDispatcher.decoderReleased(str);
    }

    @Override // androidx.media3.exoplayer.mediacodec.MediaCodecRenderer
    protected void onCodecError(Exception exc) {
        Log.e(TAG, "Video codec error", exc);
        this.eventDispatcher.videoCodecError(exc);
    }

    @Override // androidx.media3.exoplayer.mediacodec.MediaCodecRenderer
    protected final boolean shouldReleaseCodecInsteadOfFlushing() {
        MediaCodecInfo codecInfo = getCodecInfo();
        if (this.videoSink == null || codecInfo == null || !(codecInfo.name.equals("c2.mtk.avc.decoder") || codecInfo.name.equals("c2.mtk.hevc.decoder"))) {
            return super.shouldReleaseCodecInsteadOfFlushing();
        }
        return true;
    }

    /* JADX WARN: Code duplicated, block: B:8:0x002d  */
    @Override // androidx.media3.exoplayer.mediacodec.MediaCodecRenderer
    protected final boolean shouldFlushCodec() {
        boolean z;
        Format codecInputFormat = getCodecInputFormat();
        long j = this.periodDurationUs;
        if (j != -9223372036854775807L) {
            if (getSkippedFlushOffsetUs() + j + 1 > Long.MAX_VALUE - (getOutputStreamOffsetUs() + this.periodDurationUs)) {
                z = true;
            } else {
                z = false;
            }
        } else {
            z = true;
        }
        ScrubbingModeParameters scrubbingModeParameters = this.scrubbingModeParameters;
        if (scrubbingModeParameters == null) {
            return super.shouldFlushCodec();
        }
        return !scrubbingModeParameters.allowSkippingMediaCodecFlush || this.isFlushRequired || this.tunneling || (codecInputFormat != null && codecInputFormat.maxNumReorderSamples > 0) || z || getLastBufferInStreamPresentationTimeUs() != -9223372036854775807L;
    }

    @Override // androidx.media3.exoplayer.mediacodec.MediaCodecRenderer
    protected DecoderReuseEvaluation onInputFormatChanged(FormatHolder formatHolder) throws ExoPlaybackException {
        DecoderReuseEvaluation decoderReuseEvaluationOnInputFormatChanged = super.onInputFormatChanged(formatHolder);
        this.eventDispatcher.inputFormatChanged((Format) Preconditions.checkNotNull(formatHolder.format), decoderReuseEvaluationOnInputFormatChanged);
        VideoFrameReleaseEarlyTimeForecaster videoFrameReleaseEarlyTimeForecaster = this.videoFrameReleaseEarlyTimeForecaster;
        if (videoFrameReleaseEarlyTimeForecaster != null) {
            videoFrameReleaseEarlyTimeForecaster.reset();
        }
        return decoderReuseEvaluationOnInputFormatChanged;
    }

    @Override // androidx.media3.exoplayer.mediacodec.MediaCodecRenderer
    protected void onQueueInputBuffer(DecoderInputBuffer decoderInputBuffer) throws ExoPlaybackException {
        if (this.av1SampleDependencyParser != null && ((MediaCodecInfo) Preconditions.checkNotNull(getCodecInfo())).mimeType.equals(MimeTypes.VIDEO_AV1) && decoderInputBuffer.isKeyFrame() && decoderInputBuffer.data != null) {
            this.av1SampleDependencyParser.queueInputBuffer(decoderInputBuffer.data);
        }
        this.consecutiveDroppedInputBufferCount = 0;
        int codecBufferFlags = getCodecBufferFlags(decoderInputBuffer);
        if ((Build.VERSION.SDK_INT < 34 || (codecBufferFlags & 32) == 0) && !this.tunneling) {
            this.buffersInCodecCount++;
        }
    }

    @Override // androidx.media3.exoplayer.mediacodec.MediaCodecRenderer
    protected int getCodecBufferFlags(DecoderInputBuffer decoderInputBuffer) {
        ScrubbingModeParameters scrubbingModeParameters;
        if (Build.VERSION.SDK_INT >= 34) {
            return ((this.enableMediaCodecBufferDecodeOnlyFlag || (((scrubbingModeParameters = this.scrubbingModeParameters) != null && scrubbingModeParameters.useDecodeOnlyFlag) || this.tunneling)) && isBufferBeforeStartTime(decoderInputBuffer) && !isBufferProbablyLastSample(decoderInputBuffer)) ? 32 : 0;
        }
        return 0;
    }

    /* JADX WARN: Code duplicated, block: B:12:0x0028  */
    /* JADX WARN: Code duplicated, block: B:46:0x00a7 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:47:0x00a9  */
    /* JADX WARN: Code duplicated, block: B:49:0x00b1  */
    @Override // androidx.media3.exoplayer.mediacodec.MediaCodecRenderer
    protected boolean shouldDiscardDecoderInputBuffer(DecoderInputBuffer decoderInputBuffer) {
        boolean z;
        boolean z2 = false;
        if (isBufferProbablyLastSample(decoderInputBuffer)) {
            return false;
        }
        boolean zIsBufferBeforeStartTime = isBufferBeforeStartTime(decoderInputBuffer);
        VideoFrameReleaseEarlyTimeForecaster videoFrameReleaseEarlyTimeForecaster = this.videoFrameReleaseEarlyTimeForecaster;
        if (videoFrameReleaseEarlyTimeForecaster != null) {
            long jPredictEarlyUs = videoFrameReleaseEarlyTimeForecaster.predictEarlyUs(decoderInputBuffer.timeUs);
            if (jPredictEarlyUs == -9223372036854775807L || jPredictEarlyUs >= this.minEarlyUsToDropDecoderInput) {
                z = false;
            } else {
                z = true;
            }
        } else {
            z = false;
        }
        if ((!zIsBufferBeforeStartTime && !z) || decoderInputBuffer.hasSupplementalData()) {
            return false;
        }
        if (decoderInputBuffer.notDependedOn()) {
            decoderInputBuffer.clear();
        } else {
            if (this.av1SampleDependencyParser != null && ((MediaCodecInfo) Preconditions.checkNotNull(getCodecInfo())).mimeType.equals(MimeTypes.VIDEO_AV1) && decoderInputBuffer.data != null) {
                boolean z3 = zIsBufferBeforeStartTime || this.consecutiveDroppedInputBufferCount <= 0;
                ByteBuffer byteBufferAsReadOnlyBuffer = decoderInputBuffer.data.asReadOnlyBuffer();
                byteBufferAsReadOnlyBuffer.flip();
                int iSampleLimitAfterSkippingNonReferenceFrame = this.av1SampleDependencyParser.sampleLimitAfterSkippingNonReferenceFrame(byteBufferAsReadOnlyBuffer, z3);
                if (iSampleLimitAfterSkippingNonReferenceFrame == 0) {
                    decoderInputBuffer.clear();
                } else if (iSampleLimitAfterSkippingNonReferenceFrame != byteBufferAsReadOnlyBuffer.limit() && ((CodecMaxValues) Preconditions.checkNotNull(this.codecMaxValues)).inputSize + iSampleLimitAfterSkippingNonReferenceFrame < byteBufferAsReadOnlyBuffer.capacity() && !decoderInputBuffer.isEncrypted()) {
                    ((ByteBuffer) Preconditions.checkNotNull(decoderInputBuffer.data)).position(iSampleLimitAfterSkippingNonReferenceFrame);
                }
            }
            if (z2) {
                if (zIsBufferBeforeStartTime) {
                    this.decoderCounters.skippedInputBufferCount++;
                    return z2;
                }
                this.droppedDecoderInputBufferTimestamps.add(Long.valueOf(decoderInputBuffer.timeUs));
                this.consecutiveDroppedInputBufferCount++;
            }
            return z2;
        }
        z2 = true;
        if (z2) {
            if (zIsBufferBeforeStartTime) {
                this.decoderCounters.skippedInputBufferCount++;
                return z2;
            }
            this.droppedDecoderInputBufferTimestamps.add(Long.valueOf(decoderInputBuffer.timeUs));
            this.consecutiveDroppedInputBufferCount++;
        }
        return z2;
    }

    private boolean isBufferProbablyLastSample(DecoderInputBuffer decoderInputBuffer) {
        if (hasReadStreamToEnd() || decoderInputBuffer.isLastSample() || this.periodDurationUs == -9223372036854775807L) {
            return true;
        }
        return this.periodDurationUs - (decoderInputBuffer.timeUs - getOutputStreamOffsetUs()) <= 100000;
    }

    private boolean isBufferBeforeStartTime(DecoderInputBuffer decoderInputBuffer) {
        return decoderInputBuffer.timeUs < getLastResetPositionUs();
    }

    @Override // androidx.media3.exoplayer.mediacodec.MediaCodecRenderer
    protected void onOutputFormatChanged(Format format, MediaFormat mediaFormat) {
        int integer;
        int integer2;
        int i;
        int i2;
        MediaCodecAdapter codec = getCodec();
        if (codec != null) {
            codec.setVideoScalingMode(this.scalingMode);
        }
        if (this.tunneling) {
            i2 = format.width;
            i = format.height;
        } else {
            Preconditions.checkNotNull(mediaFormat);
            boolean z = mediaFormat.containsKey(KEY_CROP_RIGHT) && mediaFormat.containsKey(KEY_CROP_LEFT) && mediaFormat.containsKey(KEY_CROP_BOTTOM) && mediaFormat.containsKey(KEY_CROP_TOP);
            if (z) {
                integer = (mediaFormat.getInteger(KEY_CROP_RIGHT) - mediaFormat.getInteger(KEY_CROP_LEFT)) + 1;
            } else {
                integer = mediaFormat.getInteger("width");
            }
            if (z) {
                integer2 = (mediaFormat.getInteger(KEY_CROP_BOTTOM) - mediaFormat.getInteger(KEY_CROP_TOP)) + 1;
            } else {
                integer2 = mediaFormat.getInteger("height");
            }
            int i3 = integer;
            i = integer2;
            i2 = i3;
        }
        float f = format.pixelWidthHeightRatio;
        if (format.rotationDegrees == 90 || format.rotationDegrees == 270) {
            f = 1.0f / f;
            int i4 = i;
            i = i2;
            i2 = i4;
        }
        this.decodedVideoSize = new VideoSize(i2, i, f);
        VideoSink videoSink = this.videoSink;
        if (videoSink != null && this.pendingVideoSinkInputStreamChange) {
            changeVideoSinkInputStream(videoSink, 1, format.buildUpon().setWidth(i2).setHeight(i).setPixelWidthHeightRatio(f).build(), this.nextVideoSinkFirstFrameReleaseInstruction);
            this.nextVideoSinkFirstFrameReleaseInstruction = 2;
        } else {
            this.videoFrameReleaseControl.setFrameRate(format.frameRate);
        }
        this.pendingVideoSinkInputStreamChange = false;
    }

    protected void changeVideoSinkInputStream(VideoSink videoSink, int i, Format format, int i2) {
        List<Effect> listOf = this.videoEffects;
        if (listOf == null) {
            listOf = ImmutableList.of();
        }
        videoSink.onInputStreamChanged(i, format, getOutputStreamStartPositionUs(), i2, listOf);
    }

    @Override // androidx.media3.exoplayer.mediacodec.MediaCodecRenderer
    protected void handleInputBufferSupplementalData(DecoderInputBuffer decoderInputBuffer) throws ExoPlaybackException {
        if (this.codecHandlesHdr10PlusOutOfBandMetadata) {
            ByteBuffer byteBuffer = (ByteBuffer) Preconditions.checkNotNull(decoderInputBuffer.supplementalData);
            if (byteBuffer.remaining() >= 7) {
                byte b = byteBuffer.get();
                short s = byteBuffer.getShort();
                short s2 = byteBuffer.getShort();
                byte b2 = byteBuffer.get();
                byte b3 = byteBuffer.get();
                byteBuffer.position(0);
                if (b == -75 && s == 60 && s2 == 1 && b2 == 4) {
                    if (b3 == 0 || b3 == 1) {
                        byte[] bArr = new byte[byteBuffer.remaining()];
                        byteBuffer.get(bArr);
                        byteBuffer.position(0);
                        setHdr10PlusInfoV29((MediaCodecAdapter) Preconditions.checkNotNull(getCodec()), bArr);
                    }
                }
            }
        }
    }

    @Override // androidx.media3.exoplayer.mediacodec.MediaCodecRenderer
    protected boolean processOutputBuffer(long j, long j2, final MediaCodecAdapter mediaCodecAdapter, ByteBuffer byteBuffer, final int i, int i2, int i3, long j3, boolean z, boolean z2, Format format) throws ExoPlaybackException {
        Preconditions.checkNotNull(mediaCodecAdapter);
        final long outputStreamOffsetUs = j3 - getOutputStreamOffsetUs();
        updateDroppedBufferCountersWithInputBuffers(j3);
        VideoSink videoSink = this.videoSink;
        if (videoSink != null) {
            if (z && !z2) {
                skipOutputBuffer(mediaCodecAdapter, i, outputStreamOffsetUs);
                return true;
            }
            return videoSink.handleInputFrame(j3, new VideoSink.VideoFrameHandler() { // from class: androidx.media3.exoplayer.video.MediaCodecVideoRenderer.2
                @Override // androidx.media3.exoplayer.video.VideoSink.VideoFrameHandler
                public void render(long j4) {
                    MediaCodecVideoRenderer.this.renderOutputBuffer(mediaCodecAdapter, i, outputStreamOffsetUs, j4);
                }

                @Override // androidx.media3.exoplayer.video.VideoSink.VideoFrameHandler
                public void skip() {
                    MediaCodecVideoRenderer.this.dropOutputBuffer(mediaCodecAdapter, i, outputStreamOffsetUs);
                }
            });
        }
        long j4 = j3;
        int frameReleaseAction = this.videoFrameReleaseControl.getFrameReleaseAction(j4, j, j2, getOutputStreamStartPositionUs(), z, z2, this.videoFrameReleaseInfo);
        VideoFrameReleaseEarlyTimeForecaster videoFrameReleaseEarlyTimeForecaster = this.videoFrameReleaseEarlyTimeForecaster;
        if (videoFrameReleaseEarlyTimeForecaster != null && frameReleaseAction != 5 && frameReleaseAction != 4) {
            videoFrameReleaseEarlyTimeForecaster.onVideoFrameProcessed(j4, this.videoFrameReleaseInfo.getEarlyUs());
        }
        if (frameReleaseAction != 5) {
            j4 = -9223372036854775807L;
        }
        this.nextOutputBufferToProcessPresentationTimeUs = j4;
        if (frameReleaseAction == 0) {
            long jNanoTime = getClock().nanoTime();
            notifyFrameMetadataListener(outputStreamOffsetUs, jNanoTime, format);
            renderOutputBuffer(mediaCodecAdapter, i, outputStreamOffsetUs, jNanoTime);
            updateVideoFrameProcessingOffsetCounters(this.videoFrameReleaseInfo.getEarlyUs());
            return true;
        }
        if (frameReleaseAction == 1) {
            releaseFrame((MediaCodecAdapter) Preconditions.checkNotNull(mediaCodecAdapter), i, outputStreamOffsetUs, format);
            return true;
        }
        if (frameReleaseAction == 2) {
            dropOutputBuffer(mediaCodecAdapter, i, outputStreamOffsetUs);
            updateVideoFrameProcessingOffsetCounters(this.videoFrameReleaseInfo.getEarlyUs());
            return true;
        }
        if (frameReleaseAction == 3) {
            skipOutputBuffer(mediaCodecAdapter, i, outputStreamOffsetUs);
            updateVideoFrameProcessingOffsetCounters(this.videoFrameReleaseInfo.getEarlyUs());
            return true;
        }
        if (frameReleaseAction == 4 || frameReleaseAction == 5) {
            return false;
        }
        throw new IllegalStateException(String.valueOf(frameReleaseAction));
    }

    @Override // androidx.media3.exoplayer.mediacodec.MediaCodecRenderer
    protected void onCodecParametersChanged(CodecParameters codecParameters) {
        this.eventDispatcher.videoCodecParametersChanged(codecParameters);
    }

    @Override // androidx.media3.exoplayer.mediacodec.MediaCodecRenderer
    protected void renderToEndOfStream() {
        VideoSink videoSink = this.videoSink;
        if (videoSink != null) {
            videoSink.signalEndOfCurrentInputStream();
        } else if (getLastBufferInStreamPresentationTimeUs() != -9223372036854775807L) {
            this.nextOutputBufferToProcessPresentationTimeUs = getLastBufferInStreamPresentationTimeUs();
        }
    }

    protected void experimentalDisableAdvancingTimestampChecksInVideoFrameReleaseControl() {
        this.videoFrameReleaseControl.experimentalDisableAdvancingTimestampChecks();
    }

    protected long getBufferTimestampAdjustmentUs() {
        return -this.startPositionUs;
    }

    private void releaseFrame(MediaCodecAdapter mediaCodecAdapter, int i, long j, Format format) {
        MediaCodecVideoRenderer mediaCodecVideoRenderer;
        long releaseTimeNs = this.videoFrameReleaseInfo.getReleaseTimeNs();
        long earlyUs = this.videoFrameReleaseInfo.getEarlyUs();
        if (shouldSkipBuffersWithIdenticalReleaseTime() && releaseTimeNs == this.lastFrameReleaseTimeNs) {
            skipOutputBuffer(mediaCodecAdapter, i, j);
            mediaCodecVideoRenderer = this;
        } else {
            mediaCodecVideoRenderer = this;
            mediaCodecVideoRenderer.notifyFrameMetadataListener(j, releaseTimeNs, format);
            mediaCodecVideoRenderer.renderOutputBufferV21(mediaCodecAdapter, i, j, releaseTimeNs);
            releaseTimeNs = releaseTimeNs;
        }
        mediaCodecVideoRenderer.updateVideoFrameProcessingOffsetCounters(earlyUs);
        mediaCodecVideoRenderer.lastFrameReleaseTimeNs = releaseTimeNs;
    }

    private void notifyFrameMetadataListener(long j, long j2, Format format) {
        VideoFrameMetadataListener videoFrameMetadataListener = this.frameMetadataListener;
        if (videoFrameMetadataListener != null) {
            videoFrameMetadataListener.onVideoFrameAboutToBeRendered(j, j2, format, getCodecOutputMediaFormat());
        }
    }

    protected void onProcessedTunneledBuffer(long j) throws ExoPlaybackException {
        updateOutputFormatForTime(j);
        maybeNotifyVideoSizeChanged(this.decodedVideoSize);
        this.decoderCounters.renderedOutputBufferCount++;
        maybeNotifyRenderedFirstFrame();
        onProcessedOutputBuffer(j);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onProcessedTunneledEndOfStream() {
        setPendingOutputEndOfStream();
    }

    @Override // androidx.media3.exoplayer.mediacodec.MediaCodecRenderer
    protected void onProcessedOutputBuffer(long j) {
        super.onProcessedOutputBuffer(j);
        if (this.tunneling) {
            return;
        }
        this.buffersInCodecCount--;
    }

    @Override // androidx.media3.exoplayer.mediacodec.MediaCodecRenderer
    protected void onProcessedStreamChange() {
        super.onProcessedStreamChange();
        VideoSink videoSink = this.videoSink;
        if (videoSink != null) {
            videoSink.signalEndOfCurrentInputStream();
            if (this.startPositionUs == -9223372036854775807L) {
                this.startPositionUs = getOutputStreamStartPositionUs();
            }
            this.videoSink.setBufferTimestampAdjustmentUs(getBufferTimestampAdjustmentUs());
        } else {
            this.videoFrameReleaseControl.onStreamChanged(2);
        }
        this.pendingVideoSinkInputStreamChange = true;
        maybeSetupTunnelingForFirstFrame();
    }

    protected void skipOutputBuffer(MediaCodecAdapter mediaCodecAdapter, int i, long j) {
        TraceUtil.beginSection("skipVideoBuffer");
        mediaCodecAdapter.releaseOutputBuffer(i, false);
        TraceUtil.endSection();
        this.decoderCounters.skippedOutputBufferCount++;
    }

    protected void dropOutputBuffer(MediaCodecAdapter mediaCodecAdapter, int i, long j) {
        TraceUtil.beginSection("dropVideoBuffer");
        mediaCodecAdapter.releaseOutputBuffer(i, false);
        TraceUtil.endSection();
        updateDroppedBufferCounters(0, 1);
    }

    protected boolean maybeDropBuffersToKeyframe(long j, boolean z) throws ExoPlaybackException {
        int iSkipSource = skipSource(j);
        if (iSkipSource == 0) {
            return false;
        }
        this.lastResetToKeyFramePositionUs = j;
        if (z) {
            this.decoderCounters.skippedInputBufferCount += iSkipSource;
            this.decoderCounters.skippedOutputBufferCount += this.buffersInCodecCount;
            this.decoderCounters.skippedInputBufferCount += this.droppedDecoderInputBufferTimestamps.size();
        } else {
            this.decoderCounters.droppedToKeyframeCount++;
            updateDroppedBufferCounters(iSkipSource + this.droppedDecoderInputBufferTimestamps.size(), this.buffersInCodecCount);
        }
        flushOrReinitializeCodec();
        VideoSink videoSink = this.videoSink;
        if (videoSink != null) {
            videoSink.flush(false);
        }
        return true;
    }

    protected void updateDroppedBufferCounters(int i, int i2) {
        this.decoderCounters.droppedInputBufferCount += i;
        int i3 = i + i2;
        this.decoderCounters.droppedBufferCount += i3;
        this.droppedFrames += i3;
        this.consecutiveDroppedFrameCount += i3;
        this.decoderCounters.maxConsecutiveDroppedBufferCount = Math.max(this.consecutiveDroppedFrameCount, this.decoderCounters.maxConsecutiveDroppedBufferCount);
        int i4 = this.maxDroppedFramesToNotify;
        if (i4 <= 0 || this.droppedFrames < i4) {
            return;
        }
        maybeNotifyDroppedFrames();
    }

    private void updateDroppedBufferCountersWithInputBuffers(long j) {
        int i = 0;
        while (true) {
            Long lPeek = this.droppedDecoderInputBufferTimestamps.peek();
            if (lPeek == null || lPeek.longValue() >= j) {
                break;
            }
            i++;
            this.droppedDecoderInputBufferTimestamps.poll();
        }
        updateDroppedBufferCounters(i, 0);
    }

    protected void updateVideoFrameProcessingOffsetCounters(long j) {
        this.decoderCounters.addVideoFrameProcessingOffset(j);
        this.totalVideoFrameProcessingOffsetUs += j;
        this.videoFrameProcessingOffsetCount++;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void renderOutputBuffer(MediaCodecAdapter mediaCodecAdapter, int i, long j, long j2) {
        renderOutputBufferV21(mediaCodecAdapter, i, j, j2);
    }

    @Deprecated
    protected void renderOutputBuffer(MediaCodecAdapter mediaCodecAdapter, int i, long j) {
        TraceUtil.beginSection("releaseOutputBuffer");
        mediaCodecAdapter.releaseOutputBuffer(i, true);
        TraceUtil.endSection();
        this.decoderCounters.renderedOutputBufferCount++;
        this.consecutiveDroppedFrameCount = 0;
        if (this.videoSink == null) {
            maybeNotifyVideoSizeChanged(this.decodedVideoSize);
            maybeNotifyRenderedFirstFrame();
        }
    }

    protected void renderOutputBufferV21(MediaCodecAdapter mediaCodecAdapter, int i, long j, long j2) {
        TraceUtil.beginSection("releaseOutputBuffer");
        mediaCodecAdapter.releaseOutputBuffer(i, j2);
        TraceUtil.endSection();
        this.decoderCounters.renderedOutputBufferCount++;
        this.consecutiveDroppedFrameCount = 0;
        if (this.videoSink == null) {
            maybeNotifyVideoSizeChanged(this.decodedVideoSize);
            maybeNotifyRenderedFirstFrame();
        }
    }

    private boolean hasSurfaceForCodec(MediaCodecInfo mediaCodecInfo) {
        if (this.videoSink != null) {
            return true;
        }
        Surface surface = this.displaySurface;
        return (surface != null && surface.isValid()) || shouldUseDetachedSurface(mediaCodecInfo) || shouldUsePlaceholderSurface(mediaCodecInfo);
    }

    private Surface getSurfaceForCodec(MediaCodecInfo mediaCodecInfo) {
        VideoSink videoSink = this.videoSink;
        if (videoSink != null) {
            return videoSink.getInputSurface();
        }
        Surface surface = this.displaySurface;
        if (surface != null) {
            return surface;
        }
        if (shouldUseDetachedSurface(mediaCodecInfo)) {
            return null;
        }
        Preconditions.checkState(shouldUsePlaceholderSurface(mediaCodecInfo));
        PlaceholderSurface placeholderSurface = this.placeholderSurface;
        if (placeholderSurface != null && placeholderSurface.secure != mediaCodecInfo.secure) {
            releasePlaceholderSurface();
        }
        if (this.placeholderSurface == null) {
            this.placeholderSurface = PlaceholderSurface.newInstance(this.context, mediaCodecInfo.secure);
        }
        return this.placeholderSurface;
    }

    protected boolean shouldUseDetachedSurface(MediaCodecInfo mediaCodecInfo) {
        return Build.VERSION.SDK_INT >= 35 && mediaCodecInfo.detachedSurfaceSupported;
    }

    protected boolean shouldUsePlaceholderSurface(MediaCodecInfo mediaCodecInfo) {
        if (this.tunneling || codecNeedsSetOutputSurfaceWorkaround(mediaCodecInfo.name)) {
            return false;
        }
        return !mediaCodecInfo.secure || PlaceholderSurface.isSecureSupported(this.context);
    }

    private void releasePlaceholderSurface() {
        PlaceholderSurface placeholderSurface = this.placeholderSurface;
        if (placeholderSurface != null) {
            placeholderSurface.release();
            this.placeholderSurface = null;
        }
    }

    private void maybeSetupTunnelingForFirstFrame() {
        MediaCodecAdapter codec;
        if (this.tunneling && (codec = getCodec()) != null) {
            this.tunnelingOnFrameRenderedListener = new OnFrameRenderedListener(codec);
            if (Build.VERSION.SDK_INT >= 33) {
                Bundle bundle = new Bundle();
                bundle.putInt("tunnel-peek", 1);
                codec.setParameters(bundle);
            }
        }
    }

    private void updateCodecImportance() {
        MediaCodecAdapter codec = getCodec();
        if (codec != null && Build.VERSION.SDK_INT >= 35) {
            Bundle bundle = new Bundle();
            bundle.putInt("importance", Math.max(0, -this.rendererPriority));
            codec.setParameters(bundle);
        }
    }

    private void maybeNotifyRenderedFirstFrame() {
        if (!this.videoFrameReleaseControl.onFrameReleasedIsFirstFrame() || this.displaySurface == null) {
            return;
        }
        notifyRenderedFirstFrame();
    }

    /* JADX INFO: Access modifiers changed from: private */
    @RequiresNonNull({"displaySurface"})
    public void notifyRenderedFirstFrame() {
        this.eventDispatcher.renderedFirstFrame(this.displaySurface);
        this.haveReportedFirstFrameRenderedForCurrentSurface = true;
    }

    private void maybeRenotifyRenderedFirstFrame() {
        Surface surface = this.displaySurface;
        if (surface == null || !this.haveReportedFirstFrameRenderedForCurrentSurface) {
            return;
        }
        this.eventDispatcher.renderedFirstFrame(surface);
    }

    private void maybeNotifyVideoSizeChanged(VideoSize videoSize) {
        if (videoSize.equals(VideoSize.UNKNOWN) || videoSize.equals(this.reportedVideoSize)) {
            return;
        }
        this.reportedVideoSize = videoSize;
        this.eventDispatcher.videoSizeChanged(videoSize);
    }

    private void maybeRenotifyVideoSizeChanged() {
        VideoSize videoSize = this.reportedVideoSize;
        if (videoSize != null) {
            this.eventDispatcher.videoSizeChanged(videoSize);
        }
    }

    private void maybeNotifyDroppedFrames() {
        if (this.droppedFrames > 0) {
            long jElapsedRealtime = getClock().elapsedRealtime();
            this.eventDispatcher.droppedFrames(this.droppedFrames, jElapsedRealtime - this.droppedFrameAccumulationStartTimeMs);
            this.droppedFrames = 0;
            this.droppedFrameAccumulationStartTimeMs = jElapsedRealtime;
        }
    }

    private void maybeNotifyVideoFrameProcessingOffset() {
        int i = this.videoFrameProcessingOffsetCount;
        if (i != 0) {
            this.eventDispatcher.reportVideoFrameProcessingOffset(this.totalVideoFrameProcessingOffsetUs, i);
            this.totalVideoFrameProcessingOffsetUs = 0L;
            this.videoFrameProcessingOffsetCount = 0;
        }
    }

    private static void setHdr10PlusInfoV29(MediaCodecAdapter mediaCodecAdapter, byte[] bArr) {
        Bundle bundle = new Bundle();
        bundle.putByteArray("hdr10-plus-info", bArr);
        mediaCodecAdapter.setParameters(bundle);
    }

    private void setOutputSurface(MediaCodecAdapter mediaCodecAdapter, Surface surface) {
        if (surface != null) {
            setOutputSurfaceV23(mediaCodecAdapter, surface);
        } else {
            if (Build.VERSION.SDK_INT >= 35) {
                detachOutputSurfaceV35(mediaCodecAdapter);
                return;
            }
            throw new IllegalStateException();
        }
    }

    protected void setOutputSurfaceV23(MediaCodecAdapter mediaCodecAdapter, Surface surface) {
        mediaCodecAdapter.setOutputSurface(surface);
    }

    protected void detachOutputSurfaceV35(MediaCodecAdapter mediaCodecAdapter) {
        mediaCodecAdapter.detachOutputSurface();
    }

    protected MediaFormat getMediaFormat(Format format, String str, CodecMaxValues codecMaxValues, float f, boolean z, int i) {
        Pair<Integer, Integer> codecProfileAndLevel;
        MediaFormat mediaFormat = new MediaFormat();
        mediaFormat.setString("mime", str);
        mediaFormat.setInteger("width", format.width);
        mediaFormat.setInteger("height", format.height);
        MediaFormatUtil.setCsdBuffers(mediaFormat, format.initializationData);
        MediaFormatUtil.maybeSetFloat(mediaFormat, "frame-rate", format.frameRate);
        MediaFormatUtil.maybeSetInteger(mediaFormat, "rotation-degrees", format.rotationDegrees);
        MediaFormatUtil.maybeSetColorInfo(mediaFormat, format.colorInfo);
        if (MimeTypes.VIDEO_DOLBY_VISION.equals(format.sampleMimeType) && (codecProfileAndLevel = CodecSpecificDataUtil.getCodecProfileAndLevel(format)) != null) {
            MediaFormatUtil.maybeSetInteger(mediaFormat, "profile", ((Integer) codecProfileAndLevel.first).intValue());
        }
        mediaFormat.setInteger("max-width", codecMaxValues.width);
        mediaFormat.setInteger("max-height", codecMaxValues.height);
        MediaFormatUtil.maybeSetInteger(mediaFormat, "max-input-size", codecMaxValues.inputSize);
        mediaFormat.setInteger(LogFactory.PRIORITY_KEY, 0);
        if (f != -1.0f) {
            mediaFormat.setFloat("operating-rate", f);
        }
        if (z) {
            mediaFormat.setInteger("no-post-process", 1);
            mediaFormat.setInteger("auto-frc", 0);
        }
        if (i != 0) {
            mediaFormat.setFeatureEnabled("tunneled-playback", true);
            mediaFormat.setInteger("audio-session-id", i);
        }
        if (Build.VERSION.SDK_INT >= 35) {
            mediaFormat.setInteger("importance", Math.max(0, -this.rendererPriority));
        }
        applyCodecParametersToMediaFormat(mediaFormat);
        return mediaFormat;
    }

    protected CodecMaxValues getCodecMaxValues(MediaCodecInfo mediaCodecInfo, Format format, Format[] formatArr) {
        int codecMaxInputSize;
        int iMax = format.width;
        int iMax2 = format.height;
        int maxInputSize = getMaxInputSize(mediaCodecInfo, format);
        if (formatArr.length == 1) {
            if (maxInputSize != -1 && (codecMaxInputSize = getCodecMaxInputSize(mediaCodecInfo, format)) != -1) {
                maxInputSize = Math.min((int) (maxInputSize * INITIAL_FORMAT_MAX_INPUT_SIZE_SCALE_FACTOR), codecMaxInputSize);
            }
            return new CodecMaxValues(iMax, iMax2, maxInputSize);
        }
        int length = formatArr.length;
        boolean z = false;
        for (int i = 0; i < length; i++) {
            Format formatBuild = formatArr[i];
            if (format.colorInfo != null && formatBuild.colorInfo == null) {
                formatBuild = formatBuild.buildUpon().setColorInfo(format.colorInfo).build();
            }
            if (mediaCodecInfo.canReuseCodec(format, formatBuild).result != 0) {
                z |= formatBuild.width == -1 || formatBuild.height == -1;
                iMax = Math.max(iMax, formatBuild.width);
                iMax2 = Math.max(iMax2, formatBuild.height);
                maxInputSize = Math.max(maxInputSize, getMaxInputSize(mediaCodecInfo, formatBuild));
            }
        }
        if (z) {
            Log.w(TAG, "Resolutions unknown. Codec max resolution: " + iMax + "x" + iMax2);
            Point codecMaxSize = getCodecMaxSize(mediaCodecInfo, format);
            if (codecMaxSize != null) {
                iMax = Math.max(iMax, codecMaxSize.x);
                iMax2 = Math.max(iMax2, codecMaxSize.y);
                maxInputSize = Math.max(maxInputSize, getCodecMaxInputSize(mediaCodecInfo, format.buildUpon().setWidth(iMax).setHeight(iMax2).build()));
                Log.w(TAG, "Codec max resolution adjusted to: " + iMax + "x" + iMax2);
            }
        }
        return new CodecMaxValues(iMax, iMax2, maxInputSize);
    }

    @Override // androidx.media3.exoplayer.mediacodec.MediaCodecRenderer
    protected MediaCodecDecoderException createDecoderException(Throwable th, MediaCodecInfo mediaCodecInfo) {
        return new MediaCodecVideoDecoderException(th, mediaCodecInfo, this.displaySurface);
    }

    private static Point getCodecMaxSize(MediaCodecInfo mediaCodecInfo, Format format) {
        boolean z = format.height > format.width;
        int i = z ? format.height : format.width;
        int i2 = z ? format.width : format.height;
        float f = i2 / i;
        for (int i3 : STANDARD_LONG_EDGE_VIDEO_PX) {
            int i4 = (int) (i3 * f);
            if (i3 <= i || i4 <= i2) {
                break;
            }
            int i5 = z ? i4 : i3;
            if (!z) {
                i3 = i4;
            }
            Point pointAlignVideoSizeV21 = mediaCodecInfo.alignVideoSizeV21(i5, i3);
            float f2 = format.frameRate;
            if (pointAlignVideoSizeV21 != null && mediaCodecInfo.isVideoSizeAndRateSupportedV21(pointAlignVideoSizeV21.x, pointAlignVideoSizeV21.y, f2)) {
                return pointAlignVideoSizeV21;
            }
        }
        return null;
    }

    protected static int getMaxInputSize(MediaCodecInfo mediaCodecInfo, Format format) {
        if (format.maxInputSize != -1) {
            int size = format.initializationData.size();
            int length = 0;
            for (int i = 0; i < size; i++) {
                length += format.initializationData.get(i).length;
            }
            return format.maxInputSize + length;
        }
        return getCodecMaxInputSize(mediaCodecInfo, format);
    }

    private static boolean deviceNeedsNoPostProcessWorkaround() {
        return "NVIDIA".equals(Build.MANUFACTURER);
    }

    protected boolean codecNeedsSetOutputSurfaceWorkaround(String str) {
        if (str.startsWith("OMX.google")) {
            return false;
        }
        synchronized (MediaCodecVideoRenderer.class) {
            if (!evaluatedDeviceNeedsSetOutputSurfaceWorkaround) {
                deviceNeedsSetOutputSurfaceWorkaround = evaluateDeviceNeedsSetOutputSurfaceWorkaround();
                evaluatedDeviceNeedsSetOutputSurfaceWorkaround = true;
            }
        }
        return deviceNeedsSetOutputSurfaceWorkaround;
    }

    protected Surface getSurface() {
        return this.displaySurface;
    }

    protected static final class CodecMaxValues {
        public final int height;
        public final int inputSize;
        public final int width;

        public CodecMaxValues(int i, int i2, int i3) {
            this.width = i;
            this.height = i2;
            this.inputSize = i3;
        }
    }

    private static void debugLogForBufferRelease(int i, long j, long j2, boolean z, boolean z2, VideoFrameReleaseControl.FrameReleaseInfo frameReleaseInfo, long j3) {
        if (i == 5) {
            return;
        }
        String str = "video, release output, pts=" + j + ", pos=" + j2 + ", early=" + frameReleaseInfo.getEarlyUs();
        if (z) {
            str = str + ", decode-only";
        }
        if (z2) {
            str = str + ", last-buffer";
        }
        if (i == 0) {
            str = str + ", release immediately";
        } else if (i == 1) {
            long releaseTimeNs = frameReleaseInfo.getReleaseTimeNs();
            str = str + ", release=" + (releaseTimeNs / 1000);
            if (j3 != 0) {
                str = str + " (+" + ((releaseTimeNs - j3) / 1000) + ")";
            }
        } else if (i == 2) {
            str = str + ", drop";
        } else if (i == 3) {
            str = str + ", skip";
        } else if (i == 4) {
            str = str + ", ignore";
        }
        Log.d("MCRdebug", str);
    }

    private static int getMaxSampleSize(int i, int i2) {
        return (i * 3) / (i2 * 2);
    }

    private static boolean cannotChangeSurfaceFrameRateMidPlayback() {
        return Build.VERSION.SDK_INT == 30 && Build.MODEL.startsWith("MiTV");
    }

    private static boolean evaluateDeviceNeedsSetOutputSurfaceWorkaround() {
        String str = Build.MODEL;
        str.hashCode();
        switch (str) {
            case "AFTJMST12":
            case "AFTKMST12":
            case "AFTA":
            case "AFTN":
            case "AFTR":
            case "AFTEU011":
            case "AFTEU014":
            case "AFTSO001":
            case "AFTEUFF014":
                return true;
            default:
                return false;
        }
    }

    private final class OnFrameRenderedListener implements MediaCodecAdapter.OnFrameRenderedListener, Handler.Callback {
        private static final int HANDLE_FRAME_RENDERED = 0;
        private final Handler handler;

        public OnFrameRenderedListener(MediaCodecAdapter mediaCodecAdapter) {
            Handler handlerCreateHandlerForCurrentLooper = Util.createHandlerForCurrentLooper(this);
            this.handler = handlerCreateHandlerForCurrentLooper;
            mediaCodecAdapter.setOnFrameRenderedListener(this, handlerCreateHandlerForCurrentLooper);
        }

        @Override // androidx.media3.exoplayer.mediacodec.MediaCodecAdapter.OnFrameRenderedListener
        public void onFrameRendered(MediaCodecAdapter mediaCodecAdapter, long j, long j2) {
            handleFrameRendered(j);
        }

        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            if (message.what != 0) {
                return false;
            }
            handleFrameRendered(Util.toLong(message.arg1, message.arg2));
            return true;
        }

        private void handleFrameRendered(long j) {
            if (this != MediaCodecVideoRenderer.this.tunnelingOnFrameRenderedListener || MediaCodecVideoRenderer.this.getCodec() == null) {
                return;
            }
            if (j == Long.MAX_VALUE) {
                MediaCodecVideoRenderer.this.onProcessedTunneledEndOfStream();
                return;
            }
            try {
                MediaCodecVideoRenderer.this.onProcessedTunneledBuffer(j);
            } catch (ExoPlaybackException e) {
                MediaCodecVideoRenderer.this.setPendingPlaybackException(e);
            }
        }
    }
}
