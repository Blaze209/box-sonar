package com.box.android.preview.previewtype.video;

import com.box.android.domain.metrics.preview.PreviewObservability;
import com.box.android.preview.preview.PreviewAnalytics;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: VideoPreviewReducer.kt */
/* JADX INFO: loaded from: classes12.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\b\u0007\u0018\u00002\u00020\u0001B)\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0004\b\n\u0010\u000bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013¨\u0006\u0014"}, d2 = {"Lcom/box/android/preview/previewtype/video/VideoPreviewEnvironment;", "", "observability", "Lcom/box/android/domain/metrics/preview/PreviewObservability;", "analytics", "Lcom/box/android/preview/preview/PreviewAnalytics;", "videoPlayerInteractor", "Lcom/box/android/preview/previewtype/video/VideoPlayerInteractor;", "frameAnnotationEnvironment", "Lcom/box/android/preview/previewtype/video/FrameAnnotationEnvironment;", "<init>", "(Lcom/box/android/domain/metrics/preview/PreviewObservability;Lcom/box/android/preview/preview/PreviewAnalytics;Lcom/box/android/preview/previewtype/video/VideoPlayerInteractor;Lcom/box/android/preview/previewtype/video/FrameAnnotationEnvironment;)V", "getObservability", "()Lcom/box/android/domain/metrics/preview/PreviewObservability;", "getAnalytics", "()Lcom/box/android/preview/preview/PreviewAnalytics;", "getVideoPlayerInteractor", "()Lcom/box/android/preview/previewtype/video/VideoPlayerInteractor;", "getFrameAnnotationEnvironment", "()Lcom/box/android/preview/previewtype/video/FrameAnnotationEnvironment;", "preview_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class VideoPreviewEnvironment {
    public static final int $stable = 8;
    private final PreviewAnalytics analytics;
    private final FrameAnnotationEnvironment frameAnnotationEnvironment;
    private final PreviewObservability observability;
    private final VideoPlayerInteractor videoPlayerInteractor;

    @Inject
    public VideoPreviewEnvironment(PreviewObservability observability, PreviewAnalytics analytics, VideoPlayerInteractor videoPlayerInteractor, FrameAnnotationEnvironment frameAnnotationEnvironment) {
        Intrinsics.checkNotNullParameter(observability, "observability");
        Intrinsics.checkNotNullParameter(analytics, "analytics");
        Intrinsics.checkNotNullParameter(videoPlayerInteractor, "videoPlayerInteractor");
        Intrinsics.checkNotNullParameter(frameAnnotationEnvironment, "frameAnnotationEnvironment");
        this.observability = observability;
        this.analytics = analytics;
        this.videoPlayerInteractor = videoPlayerInteractor;
        this.frameAnnotationEnvironment = frameAnnotationEnvironment;
    }

    public final PreviewObservability getObservability() {
        return this.observability;
    }

    public final PreviewAnalytics getAnalytics() {
        return this.analytics;
    }

    public final VideoPlayerInteractor getVideoPlayerInteractor() {
        return this.videoPlayerInteractor;
    }

    public final FrameAnnotationEnvironment getFrameAnnotationEnvironment() {
        return this.frameAnnotationEnvironment;
    }
}
