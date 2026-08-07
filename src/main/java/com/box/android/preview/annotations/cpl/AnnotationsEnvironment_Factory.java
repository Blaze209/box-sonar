package com.box.android.preview.annotations.cpl;

import com.box.android.domain.configuration.FeatureFlips;
import com.box.android.domain.usecases.fileactivities.annotation.DeleteAnnotationInteractor;
import com.box.android.domain.usecases.fileactivities.annotation.GetAnnotationForFileVersionInteractor;
import com.box.android.preview.annotations.PdfAnnotationModelMapper;
import com.box.android.preview.annotations.managers.AnnotationManagersProvider;
import dagger.internal.Factory;
import dagger.internal.Provider;

/* JADX INFO: loaded from: classes12.dex */
public final class AnnotationsEnvironment_Factory implements Factory<AnnotationsEnvironment> {
    private final Provider<AnnotationManagersProvider> annotationManagersProvider;
    private final Provider<PdfAnnotationModelMapper> annotationModelMapperProvider;
    private final Provider<DeleteAnnotationInteractor> deleteAnnotationInteractorProvider;
    private final Provider<FeatureFlips> featureFlipsProvider;
    private final Provider<GetAnnotationForFileVersionInteractor> getAnnotationsVersionInteractorProvider;

    private AnnotationsEnvironment_Factory(Provider<GetAnnotationForFileVersionInteractor> provider, Provider<PdfAnnotationModelMapper> provider2, Provider<AnnotationManagersProvider> provider3, Provider<DeleteAnnotationInteractor> provider4, Provider<FeatureFlips> provider5) {
        this.getAnnotationsVersionInteractorProvider = provider;
        this.annotationModelMapperProvider = provider2;
        this.annotationManagersProvider = provider3;
        this.deleteAnnotationInteractorProvider = provider4;
        this.featureFlipsProvider = provider5;
    }

    @Override // javax.inject.Provider, jakarta.inject.Provider
    public AnnotationsEnvironment get() {
        return newInstance(this.getAnnotationsVersionInteractorProvider.get(), this.annotationModelMapperProvider.get(), this.annotationManagersProvider.get(), this.deleteAnnotationInteractorProvider.get(), this.featureFlipsProvider.get());
    }

    public static AnnotationsEnvironment_Factory create(Provider<GetAnnotationForFileVersionInteractor> provider, Provider<PdfAnnotationModelMapper> provider2, Provider<AnnotationManagersProvider> provider3, Provider<DeleteAnnotationInteractor> provider4, Provider<FeatureFlips> provider5) {
        return new AnnotationsEnvironment_Factory(provider, provider2, provider3, provider4, provider5);
    }

    public static AnnotationsEnvironment newInstance(GetAnnotationForFileVersionInteractor getAnnotationForFileVersionInteractor, PdfAnnotationModelMapper pdfAnnotationModelMapper, AnnotationManagersProvider annotationManagersProvider, DeleteAnnotationInteractor deleteAnnotationInteractor, FeatureFlips featureFlips) {
        return new AnnotationsEnvironment(getAnnotationForFileVersionInteractor, pdfAnnotationModelMapper, annotationManagersProvider, deleteAnnotationInteractor, featureFlips);
    }
}
