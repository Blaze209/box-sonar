package com.box.android.preview.annotations.cpl;

import com.box.android.domain.models.ItemId;
import com.box.android.domain.models.annotations.AnnotationLocationModel;
import com.box.android.domain.models.annotations.FileActivityModel;
import com.box.android.preview.annotations.PdfAnnotationModelMapper;
import com.box.android.preview.annotations.model.Annotation;
import com.box.android.preview.annotations.model.AnnotationKt;
import com.box.android.preview.annotations.model.AnnotationWithLocation;
import com.box.android.preview.annotations.model.DocumentSize;
import com.microsoft.identity.common.java.cache.CacheKeyValueDelegate;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: AnnotationsReducer.kt */
/* JADX INFO: loaded from: classes12.dex */
@Metadata(d1 = {"\u0000*\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a\u0016\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0001\u001a\"\u0010\u0005\u001a\u0004\u0018\u00010\u0006*\u00020\u00072\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\t2\u0006\u0010\u000b\u001a\u00020\f¨\u0006\r"}, d2 = {"createAnnotFetchKey", "", "fileId", "Lcom/box/android/domain/models/ItemId;", "fileVersionId", "toAnnotationWithLocation", "Lcom/box/android/preview/annotations/model/AnnotationWithLocation;", "Lcom/box/android/domain/models/annotations/FileActivityModel$AnnotationModel;", "documentSizes", "", "Lcom/box/android/preview/annotations/model/DocumentSize;", "annotationModelMapper", "Lcom/box/android/preview/annotations/PdfAnnotationModelMapper;", "preview_generalProdRelease"}, k = 2, mv = {2, 2, 0}, xi = 48)
public final class AnnotationsReducerKt {
    public static final String createAnnotFetchKey(ItemId fileId, String fileVersionId) {
        Intrinsics.checkNotNullParameter(fileId, "fileId");
        Intrinsics.checkNotNullParameter(fileVersionId, "fileVersionId");
        return "ANNOT_FETCH_KEY-" + fileId + CacheKeyValueDelegate.CACHE_VALUE_SEPARATOR + fileVersionId;
    }

    public static final AnnotationWithLocation toAnnotationWithLocation(FileActivityModel.AnnotationModel annotationModel, List<DocumentSize> documentSizes, PdfAnnotationModelMapper annotationModelMapper) {
        FileActivityModel.AnnotationModel annotationModelCopy$default;
        Annotation annotation;
        Annotation annotation2;
        Intrinsics.checkNotNullParameter(annotationModel, "<this>");
        Intrinsics.checkNotNullParameter(documentSizes, "documentSizes");
        Intrinsics.checkNotNullParameter(annotationModelMapper, "annotationModelMapper");
        AnnotationLocationModel location = annotationModel.getLocation();
        if (location instanceof AnnotationLocationModel.Page) {
            AnnotationLocationModel.Page page = (AnnotationLocationModel.Page) location;
            if (page.getPageNumber() <= documentSizes.size() && (annotation2 = annotationModelMapper.toAnnotation(annotationModel, documentSizes.get(page.getPageNumber() - 1))) != null) {
                return AnnotationKt.toAnnotationWithLocation(annotation2, annotationModel);
            }
            return null;
        }
        if (!(location instanceof AnnotationLocationModel.Frame) || documentSizes.isEmpty() || (annotation = annotationModelMapper.toAnnotation((annotationModelCopy$default = FileActivityModel.AnnotationModel.copy$default(annotationModel, null, null, null, null, null, null, null, new AnnotationLocationModel.Page(1), null, null, 0, null, 3967, null)), documentSizes.get(0))) == null) {
            return null;
        }
        return AnnotationKt.toAnnotationWithLocation(annotation, annotationModelCopy$default);
    }
}
