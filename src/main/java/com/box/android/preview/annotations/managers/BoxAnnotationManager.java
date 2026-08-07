package com.box.android.preview.annotations.managers;

import android.graphics.PointF;
import android.graphics.RectF;
import androidx.media3.exoplayer.upstream.CmcdData;
import com.box.android.domain.models.annotations.AnnotationLocationModel;
import com.box.android.preview.annotations.model.Annotation;
import com.box.android.preview.annotations.model.AnnotationWithLocation;
import com.google.firebase.analytics.FirebaseAnalytics;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: BoxAnnotationManager.kt */
/* JADX INFO: loaded from: classes12.dex */
@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\bf\u0018\u00002\u00020\u0001J\u001a\u0010\r\u001a\u0004\u0018\u00010\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0012H\u0016J\u001a\u0010\u0013\u001a\u0004\u0018\u00010\u000e2\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0011\u001a\u00020\u0012H\u0016J\b\u0010\u0016\u001a\u00020\u0017H\u0016J\u0018\u0010\u0018\u001a\n\u0012\u0004\u0012\u00020\u000e\u0018\u00010\u00192\u0006\u0010\u0011\u001a\u00020\u0012H&J\u0010\u0010\u001a\u001a\u00020\u00172\u0006\u0010\u001b\u001a\u00020\nH\u0016J\b\u0010\u001c\u001a\u00020\u0017H\u0016J\u0018\u0010\u001d\u001a\u00020\u00032\u0006\u0010\u001e\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010H\u0016J\u001a\u0010\u001f\u001a\u0004\u0018\u00010 2\u0006\u0010!\u001a\u00020 2\u0006\u0010\"\u001a\u00020 H\u0017J\u0018\u0010#\u001a\u0004\u0018\u00010\u000e2\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u000e0\u0019H\u0017J\b\u0010$\u001a\u00020\u0017H&R\u0018\u0010\u0002\u001a\u00020\u0003X¦\u000e¢\u0006\f\u001a\u0004\b\u0004\u0010\u0005\"\u0004\b\u0006\u0010\u0007R\u0018\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\tX¦\u0004¢\u0006\u0006\u001a\u0004\b\u000b\u0010\f¨\u0006%À\u0006\u0003"}, d2 = {"Lcom/box/android/preview/annotations/managers/BoxAnnotationManager;", "", "annotationVisibility", "", "getAnnotationVisibility", "()Z", "setAnnotationVisibility", "(Z)V", "annotations", "", "Lcom/box/android/preview/annotations/model/AnnotationWithLocation;", "getAnnotations", "()Ljava/util/List;", "selectAnnotationContainingPoint", "Lcom/box/android/preview/annotations/model/Annotation;", "point", "Landroid/graphics/PointF;", FirebaseAnalytics.Param.LOCATION, "Lcom/box/android/domain/models/annotations/AnnotationLocationModel;", "selectAnnotationWithId", "annotationId", "", "unselectAllAnnotations", "", "getAnnotationsForLocation", "", "addAnnotation", "annotationWithLocation", "removeAllAnnotations", "isPointInAnnotation", "annotation", "getIntersectionIfAny", "Landroid/graphics/RectF;", CmcdData.OBJECT_TYPE_AUDIO_ONLY, "b", "getSmallestAnnotation", "notifyAnnotationsChanged", "preview_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public interface BoxAnnotationManager {
    boolean getAnnotationVisibility();

    List<AnnotationWithLocation> getAnnotations();

    List<Annotation> getAnnotationsForLocation(AnnotationLocationModel location);

    void notifyAnnotationsChanged();

    void setAnnotationVisibility(boolean z);

    /* JADX INFO: compiled from: BoxAnnotationManager.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    public static final class DefaultImpls {
        @Deprecated
        public static Annotation selectAnnotationContainingPoint(BoxAnnotationManager boxAnnotationManager, PointF point, AnnotationLocationModel location) {
            Intrinsics.checkNotNullParameter(point, "point");
            Intrinsics.checkNotNullParameter(location, "location");
            return BoxAnnotationManager.super.selectAnnotationContainingPoint(point, location);
        }

        @Deprecated
        public static Annotation selectAnnotationWithId(BoxAnnotationManager boxAnnotationManager, String annotationId, AnnotationLocationModel location) {
            Intrinsics.checkNotNullParameter(annotationId, "annotationId");
            Intrinsics.checkNotNullParameter(location, "location");
            return BoxAnnotationManager.super.selectAnnotationWithId(annotationId, location);
        }

        @Deprecated
        public static void unselectAllAnnotations(BoxAnnotationManager boxAnnotationManager) {
            BoxAnnotationManager.super.unselectAllAnnotations();
        }

        @Deprecated
        public static void addAnnotation(BoxAnnotationManager boxAnnotationManager, AnnotationWithLocation annotationWithLocation) {
            Intrinsics.checkNotNullParameter(annotationWithLocation, "annotationWithLocation");
            BoxAnnotationManager.super.addAnnotation(annotationWithLocation);
        }

        @Deprecated
        public static void removeAllAnnotations(BoxAnnotationManager boxAnnotationManager) {
            BoxAnnotationManager.super.removeAllAnnotations();
        }

        @Deprecated
        public static boolean isPointInAnnotation(BoxAnnotationManager boxAnnotationManager, Annotation annotation, PointF point) {
            Intrinsics.checkNotNullParameter(annotation, "annotation");
            Intrinsics.checkNotNullParameter(point, "point");
            return BoxAnnotationManager.super.isPointInAnnotation(annotation, point);
        }

        @Deprecated
        public static RectF getIntersectionIfAny(BoxAnnotationManager boxAnnotationManager, RectF a, RectF b) {
            Intrinsics.checkNotNullParameter(a, "a");
            Intrinsics.checkNotNullParameter(b, "b");
            return BoxAnnotationManager.super.getIntersectionIfAny(a, b);
        }

        @Deprecated
        public static Annotation getSmallestAnnotation(BoxAnnotationManager boxAnnotationManager, List<? extends Annotation> annotations) {
            Intrinsics.checkNotNullParameter(annotations, "annotations");
            return BoxAnnotationManager.super.getSmallestAnnotation(annotations);
        }
    }

    default Annotation selectAnnotationContainingPoint(PointF point, AnnotationLocationModel location) {
        Intrinsics.checkNotNullParameter(point, "point");
        Intrinsics.checkNotNullParameter(location, "location");
        List<Annotation> annotationsForLocation = getAnnotationsForLocation(location);
        if (annotationsForLocation == null) {
            return null;
        }
        unselectAllAnnotations();
        ArrayList arrayList = new ArrayList();
        for (Object obj : annotationsForLocation) {
            if (isPointInAnnotation((Annotation) obj, point)) {
                arrayList.add(obj);
            }
        }
        Annotation smallestAnnotation = getSmallestAnnotation(arrayList);
        if (smallestAnnotation != null) {
            smallestAnnotation.setSelected();
        }
        return smallestAnnotation;
    }

    default Annotation selectAnnotationWithId(String annotationId, AnnotationLocationModel location) {
        Intrinsics.checkNotNullParameter(annotationId, "annotationId");
        Intrinsics.checkNotNullParameter(location, "location");
        List<Annotation> annotationsForLocation = getAnnotationsForLocation(location);
        Object obj = null;
        if (annotationsForLocation == null) {
            return null;
        }
        unselectAllAnnotations();
        for (Object obj2 : annotationsForLocation) {
            if (Intrinsics.areEqual(annotationId, ((Annotation) obj2).getAnnotationId())) {
                obj = obj2;
                break;
            }
        }
        Annotation annotation = (Annotation) obj;
        if (annotation != null) {
            annotation.setSelected();
        }
        return annotation;
    }

    default void unselectAllAnnotations() {
        Iterator<T> it = getAnnotations().iterator();
        while (it.hasNext()) {
            ((AnnotationWithLocation) it.next()).getAnnotation().setUnselected();
        }
        notifyAnnotationsChanged();
    }

    default void addAnnotation(AnnotationWithLocation annotationWithLocation) {
        Intrinsics.checkNotNullParameter(annotationWithLocation, "annotationWithLocation");
        getAnnotations().add(annotationWithLocation);
    }

    default void removeAllAnnotations() {
        getAnnotations().clear();
    }

    default boolean isPointInAnnotation(Annotation annotation, PointF point) {
        Intrinsics.checkNotNullParameter(annotation, "annotation");
        Intrinsics.checkNotNullParameter(point, "point");
        return annotation.getBoundingRect().top <= point.y && annotation.getBoundingRect().bottom >= point.y && annotation.getBoundingRect().left <= point.x && annotation.getBoundingRect().right >= point.x;
    }

    default RectF getIntersectionIfAny(RectF a, RectF b) {
        Intrinsics.checkNotNullParameter(a, "a");
        Intrinsics.checkNotNullParameter(b, "b");
        float fMax = Math.max(a.left, b.left);
        float fMax2 = Math.max(a.top, b.top);
        float fMin = Math.min(a.right, b.right);
        float fMin2 = Math.min(a.bottom, b.bottom);
        if (fMax >= fMin || fMin2 <= fMax2) {
            return null;
        }
        return new RectF(fMax, fMax2, fMin, fMin2);
    }

    default Annotation getSmallestAnnotation(List<? extends Annotation> annotations) {
        Object obj;
        Intrinsics.checkNotNullParameter(annotations, "annotations");
        Iterator<T> it = annotations.iterator();
        if (it.hasNext()) {
            Object next = it.next();
            if (it.hasNext()) {
                RectF boundingRect = ((Annotation) next).getBoundingRect();
                float fAbs = Math.abs((boundingRect.right - boundingRect.left) * (boundingRect.bottom - boundingRect.top));
                do {
                    Object next2 = it.next();
                    RectF boundingRect2 = ((Annotation) next2).getBoundingRect();
                    float fAbs2 = Math.abs((boundingRect2.right - boundingRect2.left) * (boundingRect2.bottom - boundingRect2.top));
                    if (Float.compare(fAbs, fAbs2) > 0) {
                        next = next2;
                        fAbs = fAbs2;
                    }
                } while (it.hasNext());
            }
            obj = next;
        } else {
            obj = null;
        }
        return (Annotation) obj;
    }
}
