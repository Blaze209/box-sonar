package com.box.android.preview.annotations;

import android.content.Context;
import android.graphics.PointF;
import android.graphics.RectF;
import com.box.android.domain.models.annotations.AnnotationLocationModel;
import com.box.android.domain.models.annotations.AnnotationPath;
import com.box.android.domain.models.annotations.AnnotationPathGroup;
import com.box.android.domain.models.annotations.AnnotationPoint;
import com.box.android.domain.models.annotations.AnnotationRectangle;
import com.box.android.domain.models.annotations.AnnotationStroke;
import com.box.android.domain.models.annotations.AnnotationTargetModel;
import com.box.android.domain.models.annotations.FileActivityModel;
import com.box.android.preview.annotations.model.Annotation;
import com.box.android.preview.annotations.model.DocumentSize;
import com.pspdfkit.annotations.InkAnnotation;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;

/* JADX INFO: compiled from: PdfAnnotationModelMapper.kt */
/* JADX INFO: loaded from: classes12.dex */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0011\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0018\u0010\b\u001a\u0004\u0018\u00010\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rJ\u001a\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\t2\u0006\u0010\f\u001a\u00020\rJ\u0018\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\f\u001a\u00020\rH\u0002J\u0014\u0010\u0015\u001a\u00020\u0016*\u00020\u00172\u0006\u0010\f\u001a\u00020\rH\u0002R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0018"}, d2 = {"Lcom/box/android/preview/annotations/PdfAnnotationModelMapper;", "", "applicationContext", "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "getApplicationContext", "()Landroid/content/Context;", "toAnnotation", "Lcom/box/android/preview/annotations/model/Annotation;", "annotationModel", "Lcom/box/android/domain/models/annotations/FileActivityModel$AnnotationModel;", "documentSize", "Lcom/box/android/preview/annotations/model/DocumentSize;", "toAnnotationTargetModel", "Lcom/box/android/domain/models/annotations/AnnotationTargetModel;", "annotation", "transformDocumentSpecificRectToAnnotationRectangle", "Lcom/box/android/domain/models/annotations/AnnotationRectangle;", "rect", "Landroid/graphics/RectF;", "toAnnotationPathGroup", "Lcom/box/android/domain/models/annotations/AnnotationPathGroup;", "Lcom/pspdfkit/annotations/InkAnnotation;", "preview_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class PdfAnnotationModelMapper {
    public static final int $stable = 8;
    private final Context applicationContext;

    @Inject
    public PdfAnnotationModelMapper(Context applicationContext) {
        Intrinsics.checkNotNullParameter(applicationContext, "applicationContext");
        this.applicationContext = applicationContext;
    }

    public final Context getApplicationContext() {
        return this.applicationContext;
    }

    public final Annotation toAnnotation(FileActivityModel.AnnotationModel annotationModel, DocumentSize documentSize) {
        Intrinsics.checkNotNullParameter(annotationModel, "annotationModel");
        Intrinsics.checkNotNullParameter(documentSize, "documentSize");
        AnnotationTargetModel target = annotationModel.getTarget();
        Annotation pdfDrawingAnnotation = null;
        if (target instanceof AnnotationTargetModel.Area) {
            AnnotationTargetModel target2 = annotationModel.getTarget();
            Intrinsics.checkNotNull(target2, "null cannot be cast to non-null type com.box.android.domain.models.annotations.AnnotationTargetModel.Area");
            AnnotationTargetModel.Area area = (AnnotationTargetModel.Area) target2;
            return PdfAnnotationTransformationHelper.INSTANCE.isValidRect(PdfAnnotationTransformationHelper.INSTANCE.createValidationRect(area.getAnnotationRectangle())) ? new PdfRegionAnnotation(PdfAnnotationTransformationHelper.INSTANCE.createTransformedRectF(area.getAnnotationRectangle(), documentSize), this.applicationContext, annotationModel.getId()) : null;
        }
        if (target instanceof AnnotationTargetModel.TextSelection) {
            AnnotationTargetModel target3 = annotationModel.getTarget();
            Intrinsics.checkNotNull(target3, "null cannot be cast to non-null type com.box.android.domain.models.annotations.AnnotationTargetModel.TextSelection");
            RectF rectF = new RectF(0.0f, 0.0f, 0.0f, 0.0f);
            List<AnnotationRectangle> highlights = ((AnnotationTargetModel.TextSelection) target3).getHighlights();
            ArrayList arrayList = new ArrayList();
            Iterator<T> it = highlights.iterator();
            while (it.hasNext()) {
                RectF rectFTransformAnnotationRectangle = PdfAnnotationTransformationHelper.INSTANCE.transformAnnotationRectangle((AnnotationRectangle) it.next(), documentSize, rectF);
                if (rectFTransformAnnotationRectangle != null) {
                    arrayList.add(rectFTransformAnnotationRectangle);
                }
            }
            ArrayList arrayList2 = arrayList;
            AnnotationLocationModel location = annotationModel.getLocation();
            return location instanceof AnnotationLocationModel.Page ? new PdfTextSelectionAnnotation(rectF, arrayList2, annotationModel.getId(), ((AnnotationLocationModel.Page) location).getPageNumber() - 1) : null;
        }
        if (!(target instanceof AnnotationTargetModel.Drawing)) {
            throw new NoWhenBranchMatchedException();
        }
        AnnotationLocationModel location2 = annotationModel.getLocation();
        if (location2 instanceof AnnotationLocationModel.Page) {
            RectF rectF2 = new RectF(0.0f, 0.0f, 0.0f, 0.0f);
            PdfAnnotationTransformationHelper pdfAnnotationTransformationHelper = PdfAnnotationTransformationHelper.INSTANCE;
            AnnotationTargetModel target4 = annotationModel.getTarget();
            Intrinsics.checkNotNull(target4, "null cannot be cast to non-null type com.box.android.domain.models.annotations.AnnotationTargetModel.Drawing");
            pdfDrawingAnnotation = new PdfDrawingAnnotation(rectF2, pdfAnnotationTransformationHelper.createTransformedPathGroups(((AnnotationTargetModel.Drawing) target4).getPathGroups(), documentSize), annotationModel.getId(), ((AnnotationLocationModel.Page) location2).getPageNumber() - 1, this.applicationContext);
        }
        return pdfDrawingAnnotation;
    }

    public final AnnotationTargetModel toAnnotationTargetModel(Annotation annotation, DocumentSize documentSize) {
        Intrinsics.checkNotNullParameter(documentSize, "documentSize");
        if (annotation instanceof PdfDrawingAnnotation) {
            List<InkAnnotation> inkAnnotations = ((PdfDrawingAnnotation) annotation).getInkAnnotations();
            ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(inkAnnotations, 10));
            Iterator<T> it = inkAnnotations.iterator();
            while (it.hasNext()) {
                arrayList.add(toAnnotationPathGroup((InkAnnotation) it.next(), documentSize));
            }
            return new AnnotationTargetModel.Drawing(arrayList);
        }
        if (annotation instanceof PdfRegionAnnotation) {
            return new AnnotationTargetModel.Area(transformDocumentSpecificRectToAnnotationRectangle(((PdfRegionAnnotation) annotation).getBoundingRect(), documentSize), null);
        }
        if (!(annotation instanceof PdfTextSelectionAnnotation)) {
            return null;
        }
        List<RectF> rects = ((PdfTextSelectionAnnotation) annotation).getRects();
        ArrayList arrayList2 = new ArrayList(CollectionsKt.collectionSizeOrDefault(rects, 10));
        Iterator<T> it2 = rects.iterator();
        while (it2.hasNext()) {
            arrayList2.add(transformDocumentSpecificRectToAnnotationRectangle((RectF) it2.next(), documentSize));
        }
        return new AnnotationTargetModel.TextSelection(null, null, arrayList2);
    }

    private final AnnotationRectangle transformDocumentSpecificRectToAnnotationRectangle(RectF rect, DocumentSize documentSize) {
        float f = rect.top;
        float f2 = rect.left;
        float fWidth = rect.width();
        return new AnnotationRectangle(100 - ((f * 100.0f) / documentSize.getHeight()), (f2 * 100.0f) / documentSize.getWidth(), (Math.abs(rect.height()) * 100.0f) / documentSize.getHeight(), (fWidth * 100.0f) / documentSize.getWidth());
    }

    private final AnnotationPathGroup toAnnotationPathGroup(InkAnnotation inkAnnotation, DocumentSize documentSize) {
        StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
        String str = String.format("#%06X", Arrays.copyOf(new Object[]{Integer.valueOf(16777215 & inkAnnotation.getColor())}, 1));
        Intrinsics.checkNotNullExpressionValue(str, "format(...)");
        AnnotationStroke annotationStroke = new AnnotationStroke(str, inkAnnotation.getLineWidth());
        List<List<PointF>> lines = inkAnnotation.getLines();
        Intrinsics.checkNotNullExpressionValue(lines, "getLines(...)");
        List<List<PointF>> list = lines;
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
        Iterator<T> it = list.iterator();
        while (it.hasNext()) {
            List list2 = (List) it.next();
            Intrinsics.checkNotNull(list2);
            List<PointF> list3 = list2;
            ArrayList arrayList2 = new ArrayList(CollectionsKt.collectionSizeOrDefault(list3, 10));
            for (PointF pointF : list3) {
                float f = 100;
                arrayList2.add(new AnnotationPoint((pointF.x / documentSize.getWidth()) * f, ((double) 100) - ((double) ((pointF.y / documentSize.getHeight()) * f))));
            }
            arrayList.add(new AnnotationPath(arrayList2));
        }
        return new AnnotationPathGroup(annotationStroke, arrayList);
    }
}
