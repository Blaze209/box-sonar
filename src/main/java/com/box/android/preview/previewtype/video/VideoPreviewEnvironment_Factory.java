package com.box.android.preview.previewtype.video;

import com.box.android.domain.metrics.preview.PreviewObservability;
import com.box.android.preview.preview.PreviewAnalytics;
import dagger.internal.Factory;
import dagger.internal.Provider;

/* JADX INFO: loaded from: classes12.dex */
public final class VideoPreviewEnvironment_Factory implements Factory<VideoPreviewEnvironment> {
    private final Provider<PreviewAnalytics> analyticsProvider;
    private final Provider<FrameAnnotationEnvironment> frameAnnotationEnvironmentProvider;
    private final Provider<PreviewObservability> observabilityProvider;
    private final Provider<VideoPlayerInteractor> videoPlayerInteractorProvider;

    private VideoPreviewEnvironment_Factory(Provider<PreviewObservability> provider, Provider<PreviewAnalytics> provider2, Provider<VideoPlayerInteractor> provider3, Provider<FrameAnnotationEnvironment> provider4) {
        this.observabilityProvider = provider;
        this.analyticsProvider = provider2;
        this.videoPlayerInteractorProvider = provider3;
        this.frameAnnotationEnvironmentProvider = provider4;
    }

    @Override // javax.inject.Provider, jakarta.inject.Provider
    public VideoPreviewEnvironment get() {
        return newInstance(this.observabilityProvider.get(), this.analyticsProvider.get(), this.videoPlayerInteractorProvider.get(), this.frameAnnotationEnvironmentProvider.get());
    }

    public static VideoPreviewEnvironment_Factory create(Provider<PreviewObservability> provider, Provider<PreviewAnalytics> provider2, Provider<VideoPlayerInteractor> provider3, Provider<FrameAnnotationEnvironment> provider4) {
        return new VideoPreviewEnvironment_Factory(provider, provider2, provider3, provider4);
    }

    public static VideoPreviewEnvironment newInstance(PreviewObservability previewObservability, PreviewAnalytics previewAnalytics, VideoPlayerInteractor videoPlayerInteractor, FrameAnnotationEnvironment frameAnnotationEnvironment) {
        return new VideoPreviewEnvironment(previewObservability, previewAnalytics, videoPlayerInteractor, frameAnnotationEnvironment);
    }
}
