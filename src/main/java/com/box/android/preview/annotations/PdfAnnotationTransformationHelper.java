package com.box.android.preview.annotations;

import android.graphics.RectF;
import com.box.android.domain.models.annotations.AnnotationPath;
import com.box.android.domain.models.annotations.AnnotationPathGroup;
import com.box.android.domain.models.annotations.AnnotationPoint;
import com.box.android.domain.models.annotations.AnnotationRectangle;
import com.box.android.domain.models.annotations.AnnotationStroke;
import com.box.android.preview.annotations.model.DocumentSize;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: PdfAnnotationTransformationHelper.kt */
/* JADX INFO: loaded from: classes12.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007J\u000e\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\nJ\"\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\r0\f2\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\r0\f2\u0006\u0010\u000f\u001a\u00020\u0010J\u0016\u0010\u0011\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000f\u001a\u00020\u0010J \u0010\u0012\u001a\u0004\u0018\u00010\u00072\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0013\u001a\u00020\u0007¨\u0006\u0014"}, d2 = {"Lcom/box/android/preview/annotations/PdfAnnotationTransformationHelper;", "", "<init>", "()V", "isValidRect", "", "rect", "Landroid/graphics/RectF;", "createValidationRect", "annotationRectangle", "Lcom/box/android/domain/models/annotations/AnnotationRectangle;", "createTransformedPathGroups", "", "Lcom/box/android/domain/models/annotations/AnnotationPathGroup;", "annotationPathGroups", "documentSize", "Lcom/box/android/preview/annotations/model/DocumentSize;", "createTransformedRectF", "transformAnnotationRectangle", "boundingBox", "preview_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class PdfAnnotationTransformationHelper {
    public static final int $stable = 0;
    public static final PdfAnnotationTransformationHelper INSTANCE = new PdfAnnotationTransformationHelper();

    private PdfAnnotationTransformationHelper() {
    }

    public final boolean isValidRect(RectF rect) {
        Intrinsics.checkNotNullParameter(rect, "rect");
        return rect.left >= 0.0f && rect.top >= 0.0f && rect.right <= 100.0f && rect.bottom <= 100.0f;
    }

    public final RectF createValidationRect(AnnotationRectangle annotationRectangle) {
        Intrinsics.checkNotNullParameter(annotationRectangle, "annotationRectangle");
        return new RectF((float) annotationRectangle.getLeft(), (float) annotationRectangle.getTop(), ((float) annotationRectangle.getWidth()) + ((float) annotationRectangle.getLeft()), ((float) annotationRectangle.getHeight()) + ((float) annotationRectangle.getTop()));
    }

    public final List<AnnotationPathGroup> createTransformedPathGroups(List<AnnotationPathGroup> annotationPathGroups, DocumentSize documentSize) {
        Intrinsics.checkNotNullParameter(annotationPathGroups, "annotationPathGroups");
        Intrinsics.checkNotNullParameter(documentSize, "documentSize");
        List<AnnotationPathGroup> list = annotationPathGroups;
        int i = 10;
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
        for (AnnotationPathGroup annotationPathGroup : list) {
            AnnotationStroke stroke = annotationPathGroup.getStroke();
            List<AnnotationPath> paths = annotationPathGroup.getPaths();
            ArrayList arrayList2 = new ArrayList(CollectionsKt.collectionSizeOrDefault(paths, i));
            Iterator it = paths.iterator();
            while (it.hasNext()) {
                List<AnnotationPoint> points = ((AnnotationPath) it.next()).getPoints();
                ArrayList arrayList3 = new ArrayList(CollectionsKt.collectionSizeOrDefault(points, i));
                for (AnnotationPoint annotationPoint : points) {
                    double d = 100;
                    arrayList3.add(new AnnotationPoint((annotationPoint.getX() / d) * ((double) documentSize.getWidth()), ((d - annotationPoint.getY()) / d) * ((double) documentSize.getHeight())));
                    it = it;
                }
                arrayList2.add(new AnnotationPath(arrayList3));
                i = 10;
            }
            arrayList.add(new AnnotationPathGroup(stroke, arrayList2));
            i = 10;
        }
        return arrayList;
    }

    public final RectF createTransformedRectF(AnnotationRectangle annotationRectangle, DocumentSize documentSize) {
        Intrinsics.checkNotNullParameter(annotationRectangle, "annotationRectangle");
        Intrinsics.checkNotNullParameter(documentSize, "documentSize");
        float f = 100;
        return new RectF((((float) annotationRectangle.getLeft()) / f) * documentSize.getWidth(), (((f - ((float) annotationRectangle.getTop())) - ((float) annotationRectangle.getHeight())) / f) * documentSize.getHeight(), ((((float) annotationRectangle.getWidth()) / f) * documentSize.getWidth()) + ((((float) annotationRectangle.getLeft()) / f) * documentSize.getWidth()), ((((float) annotationRectangle.getHeight()) / f) * documentSize.getHeight()) + ((((f - ((float) annotationRectangle.getTop())) - ((float) annotationRectangle.getHeight())) / f) * documentSize.getHeight()));
    }

    public final RectF transformAnnotationRectangle(AnnotationRectangle annotationRectangle, DocumentSize documentSize, RectF boundingBox) {
        Intrinsics.checkNotNullParameter(annotationRectangle, "annotationRectangle");
        Intrinsics.checkNotNullParameter(documentSize, "documentSize");
        Intrinsics.checkNotNullParameter(boundingBox, "boundingBox");
        if (!isValidRect(createValidationRect(annotationRectangle))) {
            return null;
        }
        RectF rectFCreateTransformedRectF = createTransformedRectF(annotationRectangle, documentSize);
        if (boundingBox.left == 0.0f && boundingBox.right == 0.0f && boundingBox.top == 0.0f && boundingBox.bottom == 0.0f) {
            boundingBox.set(rectFCreateTransformedRectF.left, rectFCreateTransformedRectF.top, rectFCreateTransformedRectF.right, rectFCreateTransformedRectF.bottom);
        }
        if (rectFCreateTransformedRectF.left < boundingBox.left) {
            boundingBox.left = rectFCreateTransformedRectF.left;
        }
        if (rectFCreateTransformedRectF.top < boundingBox.top) {
            boundingBox.top = rectFCreateTransformedRectF.top;
        }
        if (rectFCreateTransformedRectF.right > boundingBox.right) {
            boundingBox.right = rectFCreateTransformedRectF.right;
        }
        if (rectFCreateTransformedRectF.bottom > boundingBox.bottom) {
            boundingBox.bottom = rectFCreateTransformedRectF.bottom;
        }
        return rectFCreateTransformedRectF;
    }
}
