package com.box.android.preview.annotations.cpl;

import com.box.android.base.presentation.components.commentbar.CommentWithMentionsEnvironment;
import com.box.android.domain.usecases.fileactivities.annotation.CreateAnnotationInteractor;
import com.box.android.preview.annotations.PdfAnnotationModelMapper;
import com.box.android.preview.annotations.managers.AnnotationManagersProvider;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: CreateAnnotationReducer.kt */
/* JADX INFO: loaded from: classes12.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\b\u0007\u0018\u00002\u00020\u0001B)\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0004\b\n\u0010\u000bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013¨\u0006\u0014"}, d2 = {"Lcom/box/android/preview/annotations/cpl/CreateAnnotationEnvironment;", "", "commentWithMentionsEnvironment", "Lcom/box/android/base/presentation/components/commentbar/CommentWithMentionsEnvironment;", "pdfAnnotationModelMapper", "Lcom/box/android/preview/annotations/PdfAnnotationModelMapper;", "createAnnotationInteractor", "Lcom/box/android/domain/usecases/fileactivities/annotation/CreateAnnotationInteractor;", "annotationManagersProvider", "Lcom/box/android/preview/annotations/managers/AnnotationManagersProvider;", "<init>", "(Lcom/box/android/base/presentation/components/commentbar/CommentWithMentionsEnvironment;Lcom/box/android/preview/annotations/PdfAnnotationModelMapper;Lcom/box/android/domain/usecases/fileactivities/annotation/CreateAnnotationInteractor;Lcom/box/android/preview/annotations/managers/AnnotationManagersProvider;)V", "getCommentWithMentionsEnvironment", "()Lcom/box/android/base/presentation/components/commentbar/CommentWithMentionsEnvironment;", "getPdfAnnotationModelMapper", "()Lcom/box/android/preview/annotations/PdfAnnotationModelMapper;", "getCreateAnnotationInteractor", "()Lcom/box/android/domain/usecases/fileactivities/annotation/CreateAnnotationInteractor;", "getAnnotationManagersProvider", "()Lcom/box/android/preview/annotations/managers/AnnotationManagersProvider;", "preview_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class CreateAnnotationEnvironment {
    public static final int $stable = 8;
    private final AnnotationManagersProvider annotationManagersProvider;
    private final CommentWithMentionsEnvironment commentWithMentionsEnvironment;
    private final CreateAnnotationInteractor createAnnotationInteractor;
    private final PdfAnnotationModelMapper pdfAnnotationModelMapper;

    @Inject
    public CreateAnnotationEnvironment(CommentWithMentionsEnvironment commentWithMentionsEnvironment, PdfAnnotationModelMapper pdfAnnotationModelMapper, CreateAnnotationInteractor createAnnotationInteractor, AnnotationManagersProvider annotationManagersProvider) {
        Intrinsics.checkNotNullParameter(commentWithMentionsEnvironment, "commentWithMentionsEnvironment");
        Intrinsics.checkNotNullParameter(pdfAnnotationModelMapper, "pdfAnnotationModelMapper");
        Intrinsics.checkNotNullParameter(createAnnotationInteractor, "createAnnotationInteractor");
        Intrinsics.checkNotNullParameter(annotationManagersProvider, "annotationManagersProvider");
        this.commentWithMentionsEnvironment = commentWithMentionsEnvironment;
        this.pdfAnnotationModelMapper = pdfAnnotationModelMapper;
        this.createAnnotationInteractor = createAnnotationInteractor;
        this.annotationManagersProvider = annotationManagersProvider;
    }

    public final CommentWithMentionsEnvironment getCommentWithMentionsEnvironment() {
        return this.commentWithMentionsEnvironment;
    }

    public final PdfAnnotationModelMapper getPdfAnnotationModelMapper() {
        return this.pdfAnnotationModelMapper;
    }

    public final CreateAnnotationInteractor getCreateAnnotationInteractor() {
        return this.createAnnotationInteractor;
    }

    public final AnnotationManagersProvider getAnnotationManagersProvider() {
        return this.annotationManagersProvider;
    }
}
