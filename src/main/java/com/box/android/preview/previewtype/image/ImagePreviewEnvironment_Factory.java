package com.box.android.preview.previewtype.image;

import com.box.android.domain.identity.IUserContextManager;
import com.box.android.domain.metrics.preview.PreviewObservability;
import com.box.android.preview.annotations.cpl.AnnotationsEnvironment;
import com.box.android.preview.annotations.cpl.CreateAnnotationEnvironment;
import dagger.internal.Factory;
import dagger.internal.Provider;

/* JADX INFO: loaded from: classes12.dex */
public final class ImagePreviewEnvironment_Factory implements Factory<ImagePreviewEnvironment> {
    private final Provider<AnnotationsEnvironment> annotationsEnvironmentProvider;
    private final Provider<CreateAnnotationEnvironment> createAnnotationEnvironmentProvider;
    private final Provider<PreviewObservability> observabilityProvider;
    private final Provider<IUserContextManager> userContextManagerProvider;

    private ImagePreviewEnvironment_Factory(Provider<AnnotationsEnvironment> provider, Provider<CreateAnnotationEnvironment> provider2, Provider<IUserContextManager> provider3, Provider<PreviewObservability> provider4) {
        this.annotationsEnvironmentProvider = provider;
        this.createAnnotationEnvironmentProvider = provider2;
        this.userContextManagerProvider = provider3;
        this.observabilityProvider = provider4;
    }

    @Override // javax.inject.Provider, jakarta.inject.Provider
    public ImagePreviewEnvironment get() {
        return newInstance(this.annotationsEnvironmentProvider.get(), this.createAnnotationEnvironmentProvider.get(), this.userContextManagerProvider.get(), this.observabilityProvider.get());
    }

    public static ImagePreviewEnvironment_Factory create(Provider<AnnotationsEnvironment> provider, Provider<CreateAnnotationEnvironment> provider2, Provider<IUserContextManager> provider3, Provider<PreviewObservability> provider4) {
        return new ImagePreviewEnvironment_Factory(provider, provider2, provider3, provider4);
    }

    public static ImagePreviewEnvironment newInstance(AnnotationsEnvironment annotationsEnvironment, CreateAnnotationEnvironment createAnnotationEnvironment, IUserContextManager iUserContextManager, PreviewObservability previewObservability) {
        return new ImagePreviewEnvironment(annotationsEnvironment, createAnnotationEnvironment, iUserContextManager, previewObservability);
    }
}
