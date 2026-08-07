package com.box.android.preview.previewtype.video;

import com.box.android.domain.identity.IUserContextManager;
import com.box.android.preview.annotations.cpl.AnnotationsEnvironment;
import com.box.android.preview.annotations.cpl.CreateAnnotationEnvironment;
import dagger.internal.Factory;
import dagger.internal.Provider;

/* JADX INFO: loaded from: classes12.dex */
public final class FrameAnnotationEnvironment_Factory implements Factory<FrameAnnotationEnvironment> {
    private final Provider<AnnotationsEnvironment> annotationsEnvironmentProvider;
    private final Provider<CreateAnnotationEnvironment> createAnnotationEnvironmentProvider;
    private final Provider<FrameExporter> frameExporterProvider;
    private final Provider<IUserContextManager> userContextManagerProvider;
    private final Provider<VideoPlayerInteractor> videoPlayersInteractorProvider;

    private FrameAnnotationEnvironment_Factory(Provider<VideoPlayerInteractor> provider, Provider<CreateAnnotationEnvironment> provider2, Provider<IUserContextManager> provider3, Provider<FrameExporter> provider4, Provider<AnnotationsEnvironment> provider5) {
        this.videoPlayersInteractorProvider = provider;
        this.createAnnotationEnvironmentProvider = provider2;
        this.userContextManagerProvider = provider3;
        this.frameExporterProvider = provider4;
        this.annotationsEnvironmentProvider = provider5;
    }

    @Override // javax.inject.Provider, jakarta.inject.Provider
    public FrameAnnotationEnvironment get() {
        return newInstance(this.videoPlayersInteractorProvider.get(), this.createAnnotationEnvironmentProvider.get(), this.userContextManagerProvider.get(), this.frameExporterProvider.get(), this.annotationsEnvironmentProvider.get());
    }

    public static FrameAnnotationEnvironment_Factory create(Provider<VideoPlayerInteractor> provider, Provider<CreateAnnotationEnvironment> provider2, Provider<IUserContextManager> provider3, Provider<FrameExporter> provider4, Provider<AnnotationsEnvironment> provider5) {
        return new FrameAnnotationEnvironment_Factory(provider, provider2, provider3, provider4, provider5);
    }

    public static FrameAnnotationEnvironment newInstance(VideoPlayerInteractor videoPlayerInteractor, CreateAnnotationEnvironment createAnnotationEnvironment, IUserContextManager iUserContextManager, FrameExporter frameExporter, AnnotationsEnvironment annotationsEnvironment) {
        return new FrameAnnotationEnvironment(videoPlayerInteractor, createAnnotationEnvironment, iUserContextManager, frameExporter, annotationsEnvironment);
    }
}
