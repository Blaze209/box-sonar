package com.box.android.preview.annotations.cpl;

import com.box.android.domain.configuration.FeatureFlips;
import com.box.android.domain.models.ItemId;
import com.box.android.domain.usecases.fileactivities.annotation.DeleteAnnotationInteractor;
import com.box.android.domain.usecases.fileactivities.annotation.GetAnnotationForFileVersionInteractor;
import com.box.android.preview.annotations.PdfAnnotationModelMapper;
import com.box.android.preview.annotations.managers.AnnotationManagersProvider;
import com.box.android.preview.annotations.managers.BoxPdfAnnotationManager;
import com.box.android.preview.annotations.managers.CreateAnnotationsManager;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: AnnotationsReducer.kt */
/* JADX INFO: loaded from: classes12.dex */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B1\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b¢\u0006\u0004\b\f\u0010\rJ\u000e\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u001bJ\u000e\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001a\u001a\u00020\u001bJ\u000e\u0010\u001e\u001a\u00020\u001f2\u0006\u0010\u001a\u001a\u00020\u001bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0011\u0010\n\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017¨\u0006 "}, d2 = {"Lcom/box/android/preview/annotations/cpl/AnnotationsEnvironment;", "", "getAnnotationsVersionInteractor", "Lcom/box/android/domain/usecases/fileactivities/annotation/GetAnnotationForFileVersionInteractor;", "annotationModelMapper", "Lcom/box/android/preview/annotations/PdfAnnotationModelMapper;", "annotationManagersProvider", "Lcom/box/android/preview/annotations/managers/AnnotationManagersProvider;", "deleteAnnotationInteractor", "Lcom/box/android/domain/usecases/fileactivities/annotation/DeleteAnnotationInteractor;", "featureFlips", "Lcom/box/android/domain/configuration/FeatureFlips;", "<init>", "(Lcom/box/android/domain/usecases/fileactivities/annotation/GetAnnotationForFileVersionInteractor;Lcom/box/android/preview/annotations/PdfAnnotationModelMapper;Lcom/box/android/preview/annotations/managers/AnnotationManagersProvider;Lcom/box/android/domain/usecases/fileactivities/annotation/DeleteAnnotationInteractor;Lcom/box/android/domain/configuration/FeatureFlips;)V", "getGetAnnotationsVersionInteractor", "()Lcom/box/android/domain/usecases/fileactivities/annotation/GetAnnotationForFileVersionInteractor;", "getAnnotationModelMapper", "()Lcom/box/android/preview/annotations/PdfAnnotationModelMapper;", "getAnnotationManagersProvider", "()Lcom/box/android/preview/annotations/managers/AnnotationManagersProvider;", "getDeleteAnnotationInteractor", "()Lcom/box/android/domain/usecases/fileactivities/annotation/DeleteAnnotationInteractor;", "getFeatureFlips", "()Lcom/box/android/domain/configuration/FeatureFlips;", "getPdfAnnotationManager", "Lcom/box/android/preview/annotations/managers/BoxPdfAnnotationManager;", "itemId", "Lcom/box/android/domain/models/ItemId;", "getCreateAnnotationManager", "Lcom/box/android/preview/annotations/managers/CreateAnnotationsManager;", "removeAnnotationManagers", "", "preview_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class AnnotationsEnvironment {
    public static final int $stable = 8;
    private final AnnotationManagersProvider annotationManagersProvider;
    private final PdfAnnotationModelMapper annotationModelMapper;
    private final DeleteAnnotationInteractor deleteAnnotationInteractor;
    private final FeatureFlips featureFlips;
    private final GetAnnotationForFileVersionInteractor getAnnotationsVersionInteractor;

    @Inject
    public AnnotationsEnvironment(GetAnnotationForFileVersionInteractor getAnnotationsVersionInteractor, PdfAnnotationModelMapper annotationModelMapper, AnnotationManagersProvider annotationManagersProvider, DeleteAnnotationInteractor deleteAnnotationInteractor, FeatureFlips featureFlips) {
        Intrinsics.checkNotNullParameter(getAnnotationsVersionInteractor, "getAnnotationsVersionInteractor");
        Intrinsics.checkNotNullParameter(annotationModelMapper, "annotationModelMapper");
        Intrinsics.checkNotNullParameter(annotationManagersProvider, "annotationManagersProvider");
        Intrinsics.checkNotNullParameter(deleteAnnotationInteractor, "deleteAnnotationInteractor");
        Intrinsics.checkNotNullParameter(featureFlips, "featureFlips");
        this.getAnnotationsVersionInteractor = getAnnotationsVersionInteractor;
        this.annotationModelMapper = annotationModelMapper;
        this.annotationManagersProvider = annotationManagersProvider;
        this.deleteAnnotationInteractor = deleteAnnotationInteractor;
        this.featureFlips = featureFlips;
    }

    public final GetAnnotationForFileVersionInteractor getGetAnnotationsVersionInteractor() {
        return this.getAnnotationsVersionInteractor;
    }

    public final PdfAnnotationModelMapper getAnnotationModelMapper() {
        return this.annotationModelMapper;
    }

    public final AnnotationManagersProvider getAnnotationManagersProvider() {
        return this.annotationManagersProvider;
    }

    public final DeleteAnnotationInteractor getDeleteAnnotationInteractor() {
        return this.deleteAnnotationInteractor;
    }

    public final FeatureFlips getFeatureFlips() {
        return this.featureFlips;
    }

    public final BoxPdfAnnotationManager getPdfAnnotationManager(ItemId itemId) {
        Intrinsics.checkNotNullParameter(itemId, "itemId");
        return this.annotationManagersProvider.getPdfAnnotationManager(itemId);
    }

    public final CreateAnnotationsManager getCreateAnnotationManager(ItemId itemId) {
        Intrinsics.checkNotNullParameter(itemId, "itemId");
        return this.annotationManagersProvider.getCreateAnnotationManager(itemId);
    }

    public final void removeAnnotationManagers(ItemId itemId) {
        Intrinsics.checkNotNullParameter(itemId, "itemId");
        this.annotationManagersProvider.removeAnnotationManagers(itemId);
    }
}
