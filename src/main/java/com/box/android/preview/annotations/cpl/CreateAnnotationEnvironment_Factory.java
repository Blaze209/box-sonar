package com.box.android.preview.annotations.cpl;

import com.box.android.base.presentation.components.commentbar.CommentWithMentionsEnvironment;
import com.box.android.domain.usecases.fileactivities.annotation.CreateAnnotationInteractor;
import com.box.android.preview.annotations.PdfAnnotationModelMapper;
import com.box.android.preview.annotations.managers.AnnotationManagersProvider;
import dagger.internal.Factory;
import dagger.internal.Provider;

/* JADX INFO: loaded from: classes12.dex */
public final class CreateAnnotationEnvironment_Factory implements Factory<CreateAnnotationEnvironment> {
    private final Provider<AnnotationManagersProvider> annotationManagersProvider;
    private final Provider<CommentWithMentionsEnvironment> commentWithMentionsEnvironmentProvider;
    private final Provider<CreateAnnotationInteractor> createAnnotationInteractorProvider;
    private final Provider<PdfAnnotationModelMapper> pdfAnnotationModelMapperProvider;

    private CreateAnnotationEnvironment_Factory(Provider<CommentWithMentionsEnvironment> provider, Provider<PdfAnnotationModelMapper> provider2, Provider<CreateAnnotationInteractor> provider3, Provider<AnnotationManagersProvider> provider4) {
        this.commentWithMentionsEnvironmentProvider = provider;
        this.pdfAnnotationModelMapperProvider = provider2;
        this.createAnnotationInteractorProvider = provider3;
        this.annotationManagersProvider = provider4;
    }

    @Override // javax.inject.Provider, jakarta.inject.Provider
    public CreateAnnotationEnvironment get() {
        return newInstance(this.commentWithMentionsEnvironmentProvider.get(), this.pdfAnnotationModelMapperProvider.get(), this.createAnnotationInteractorProvider.get(), this.annotationManagersProvider.get());
    }

    public static CreateAnnotationEnvironment_Factory create(Provider<CommentWithMentionsEnvironment> provider, Provider<PdfAnnotationModelMapper> provider2, Provider<CreateAnnotationInteractor> provider3, Provider<AnnotationManagersProvider> provider4) {
        return new CreateAnnotationEnvironment_Factory(provider, provider2, provider3, provider4);
    }

    public static CreateAnnotationEnvironment newInstance(CommentWithMentionsEnvironment commentWithMentionsEnvironment, PdfAnnotationModelMapper pdfAnnotationModelMapper, CreateAnnotationInteractor createAnnotationInteractor, AnnotationManagersProvider annotationManagersProvider) {
        return new CreateAnnotationEnvironment(commentWithMentionsEnvironment, pdfAnnotationModelMapper, createAnnotationInteractor, annotationManagersProvider);
    }
}
