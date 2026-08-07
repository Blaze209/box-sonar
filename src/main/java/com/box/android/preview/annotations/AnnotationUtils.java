package com.box.android.preview.annotations;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PointF;
import android.graphics.Rect;
import android.graphics.RectF;
import com.box.android.common.utilities.CommonBoxUtil;
import com.box.android.preview.R;
import com.pspdfkit.annotations.Annotation;
import com.pspdfkit.document.PdfDocument;
import com.pspdfkit.projection.ViewProjection;
import com.pspdfkit.ui.PdfFragment;
import com.pspdfkit.utils.Size;
import java.util.Collection;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: AnnotationUtils.kt */
/* JADX INFO: loaded from: classes12.dex */
@Metadata(d1 = {"\u0000f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u001e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003JH\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u000b2\b\b\u0002\u0010\r\u001a\u00020\u000e2\b\b\u0002\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0010\u001a\u00020\u00112\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0013H\u0007J(\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00152\u0006\u0010\u0019\u001a\u00020\u00052\u0006\u0010\u001a\u001a\u00020\u001bH\u0007J*\u0010\u001c\u001a\u000e\u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u00020\u00050\u001d2\f\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020 0\u001f2\u0006\u0010!\u001a\u00020\"H\u0007J\n\u0010#\u001a\u00020\u0007*\u00020\"R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006$"}, d2 = {"Lcom/box/android/preview/annotations/AnnotationUtils;", "", "<init>", "()V", "DPI_MULTIPLIER", "", "drawRect", "", "canvas", "Landroid/graphics/Canvas;", "paint", "Landroid/graphics/Paint;", "clearPaint", "shadowRadius", "", "cornerRadius", "outerRect", "Landroid/graphics/Rect;", "innerRect", "Landroid/graphics/RectF;", "calculateAnnotationContextMenuPosition", "Landroid/graphics/PointF;", "context", "Landroid/content/Context;", "pointF", "pageIndex", "viewProjection", "Lcom/pspdfkit/projection/ViewProjection;", "calculateCommentPopupPosition", "Lkotlin/Pair;", "annotations", "", "Lcom/pspdfkit/annotations/Annotation;", "pdfFragment", "Lcom/pspdfkit/ui/PdfFragment;", "clearUndoRedoHistory", "preview_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class AnnotationUtils {
    public static final int $stable = 0;
    private static final int DPI_MULTIPLIER = 4;
    public static final AnnotationUtils INSTANCE = new AnnotationUtils();

    private AnnotationUtils() {
    }

    public static /* synthetic */ void drawRect$default(Canvas canvas, Paint paint, Paint paint2, float f, float f2, Rect rect, RectF rectF, int i, Object obj) {
        if ((i & 8) != 0) {
            f = 0.0f;
        }
        if ((i & 16) != 0) {
            f2 = 0.0f;
        }
        if ((i & 64) != 0) {
            rectF = null;
        }
        drawRect(canvas, paint, paint2, f, f2, rect, rectF);
    }

    @JvmStatic
    public static final void drawRect(Canvas canvas, Paint paint, Paint clearPaint, float shadowRadius, float cornerRadius, Rect outerRect, RectF innerRect) {
        Intrinsics.checkNotNullParameter(canvas, "canvas");
        Intrinsics.checkNotNullParameter(paint, "paint");
        Intrinsics.checkNotNullParameter(clearPaint, "clearPaint");
        Intrinsics.checkNotNullParameter(outerRect, "outerRect");
        float strokeWidth = ((float) (((double) paint.getStrokeWidth()) * 0.5d)) + (4 * shadowRadius);
        float f = 2 * strokeWidth;
        float f2 = outerRect.right - outerRect.left;
        float f3 = outerRect.bottom - outerRect.top;
        Bitmap bitmapCreateBitmap = Bitmap.createBitmap((int) (f2 + f), (int) (f + f3), Bitmap.Config.ARGB_8888);
        Intrinsics.checkNotNullExpressionValue(bitmapCreateBitmap, "createBitmap(...)");
        Canvas canvas2 = new Canvas(bitmapCreateBitmap);
        RectF rectF = new RectF(strokeWidth, strokeWidth, f2 + strokeWidth, f3 + strokeWidth);
        canvas2.drawRoundRect(rectF, cornerRadius, cornerRadius, paint);
        if (innerRect == null) {
            canvas2.drawRoundRect(new RectF(rectF.left + 10.0f, rectF.top + 10.0f, rectF.right - 10.0f, rectF.bottom - 10.0f), cornerRadius, cornerRadius, clearPaint);
        } else {
            float f4 = (innerRect.left - outerRect.left) + strokeWidth;
            float f5 = ((innerRect.right + f4) - innerRect.left) + strokeWidth;
            float f6 = (innerRect.top - outerRect.top) + strokeWidth;
            canvas2.drawRoundRect(new RectF(f4, f6, f5, ((innerRect.bottom + f6) - innerRect.top) + strokeWidth), cornerRadius, cornerRadius, clearPaint);
        }
        canvas.drawBitmap(bitmapCreateBitmap, outerRect.left - strokeWidth, outerRect.top - strokeWidth, (Paint) null);
    }

    @JvmStatic
    public static final PointF calculateAnnotationContextMenuPosition(Context context, PointF pointF, int pageIndex, ViewProjection viewProjection) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(pointF, "pointF");
        Intrinsics.checkNotNullParameter(viewProjection, "viewProjection");
        int dimension = (int) context.getResources().getDimension(R.dimen.box_annotation_popup_touch_offset);
        viewProjection.toViewPoint(pointF, pageIndex);
        pointF.set(pointF.x, (pointF.y - dimension) - CommonBoxUtil.INSTANCE.getNavigationBarHeight(context));
        return pointF;
    }

    @JvmStatic
    public static final Pair<PointF, Integer> calculateCommentPopupPosition(Collection<? extends Annotation> annotations, PdfFragment pdfFragment) {
        Object next;
        Intrinsics.checkNotNullParameter(annotations, "annotations");
        Intrinsics.checkNotNullParameter(pdfFragment, "pdfFragment");
        int pageIndex = pdfFragment.getPageIndex();
        Iterator<T> it = annotations.iterator();
        if (it.hasNext()) {
            next = it.next();
            if (it.hasNext()) {
                float f = ((Annotation) next).getBoundingBox().top;
                do {
                    Object next2 = it.next();
                    float f2 = ((Annotation) next2).getBoundingBox().top;
                    if (Float.compare(f, f2) < 0) {
                        next = next2;
                        f = f2;
                    }
                } while (it.hasNext());
            }
        } else {
            next = null;
        }
        Annotation annotation = (Annotation) next;
        if (annotation != null) {
            RectF boundingBox = annotation.getBoundingBox();
            PointF pointF = new PointF(boundingBox.left, boundingBox.top);
            pdfFragment.getViewProjection().toViewPoint(pointF, annotation.getPageIndex());
            float f3 = pointF.x;
            float f4 = pointF.y;
            CommonBoxUtil commonBoxUtil = CommonBoxUtil.INSTANCE;
            Context contextRequireContext = pdfFragment.requireContext();
            Intrinsics.checkNotNullExpressionValue(contextRequireContext, "requireContext(...)");
            pointF.set(f3, f4 - commonBoxUtil.getNavigationBarHeight(contextRequireContext));
            return new Pair<>(pointF, 0);
        }
        Context contextRequireContext2 = pdfFragment.requireContext();
        Intrinsics.checkNotNullExpressionValue(contextRequireContext2, "requireContext(...)");
        int dimension = ((int) contextRequireContext2.getResources().getDimension(R.dimen.box_previewsdk_toolbar_height)) * 2;
        ViewProjection viewProjection = pdfFragment.getViewProjection();
        Intrinsics.checkNotNullExpressionValue(viewProjection, "getViewProjection(...)");
        PdfDocument document = pdfFragment.getDocument();
        Size pageSize = document != null ? document.getPageSize(pageIndex) : null;
        PointF pointF2 = new PointF(0.0f, pageSize != null ? pageSize.height : 0.0f);
        viewProjection.toViewPoint(pointF2, pageIndex);
        float f5 = dimension;
        if (pointF2.y < f5) {
            pointF2.y = f5;
        }
        return new Pair<>(pointF2, 49);
    }

    public final void clearUndoRedoHistory(PdfFragment pdfFragment) {
        Intrinsics.checkNotNullParameter(pdfFragment, "<this>");
        pdfFragment.getUndoManager().clearHistory();
    }
}
