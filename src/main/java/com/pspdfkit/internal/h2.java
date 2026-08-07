package com.pspdfkit.internal;

import android.graphics.PointF;
import android.graphics.RectF;
import androidx.core.util.Pair;
import com.pspdfkit.annotations.Annotation;
import com.pspdfkit.annotations.AnnotationType;
import com.pspdfkit.annotations.InkAnnotation;
import com.pspdfkit.annotations.LineAnnotation;
import com.pspdfkit.annotations.PolygonAnnotation;
import com.pspdfkit.annotations.PolylineAnnotation;
import com.pspdfkit.annotations.WidgetAnnotation;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import kotlin.collections.CollectionsKt;
import kotlin.collections.SetsKt;
import kotlin.comparisons.ComparisonsKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: classes3.dex */
public final class h2 {

    public static final /* synthetic */ class a {
        public static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[AnnotationType.values().length];
            try {
                iArr[AnnotationType.INK.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[AnnotationType.LINE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[AnnotationType.POLYLINE.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[AnnotationType.POLYGON.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr[AnnotationType.SQUARE.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                iArr[AnnotationType.CIRCLE.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            a = iArr;
        }
    }

    public static final class b<T> implements Comparator {
        public final /* synthetic */ RectF a;

        public b(RectF rectF) {
            this.a = rectF;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // java.util.Comparator
        public final int compare(T t, T t2) {
            float fCoerceAtLeast;
            RectF boundingBox = ((Annotation) t2).getBoundingBox();
            RectF rectF = this.a;
            boundingBox.getClass();
            float fA = h2.a(boundingBox, rectF);
            float fCoerceAtLeast2 = 0.0f;
            if (fA == 0.0f) {
                fCoerceAtLeast = 0.0f;
            } else {
                fCoerceAtLeast = fA / RangesKt.coerceAtLeast((boundingBox.top - boundingBox.bottom) * boundingBox.width(), 0.01f);
            }
            Float fValueOf = Float.valueOf(fCoerceAtLeast);
            RectF boundingBox2 = ((Annotation) t).getBoundingBox();
            RectF rectF2 = this.a;
            boundingBox2.getClass();
            float fA2 = h2.a(boundingBox2, rectF2);
            if (fA2 != 0.0f) {
                fCoerceAtLeast2 = fA2 / RangesKt.coerceAtLeast((boundingBox2.top - boundingBox2.bottom) * boundingBox2.width(), 0.01f);
            }
            return ComparisonsKt.compareValues(fValueOf, Float.valueOf(fCoerceAtLeast2));
        }
    }

    public static ArrayList a(ArrayList arrayList, final RectF rectF, final float f, Set set, boolean z) {
        int size;
        rectF.getClass();
        set.getClass();
        ArrayList arrayList2 = new ArrayList();
        int size2 = arrayList.size();
        int i = 0;
        int i2 = 0;
        int i3 = 0;
        while (i < size2) {
            Object obj = arrayList.get(i);
            i++;
            Annotation annotation = (Annotation) obj;
            if (set.isEmpty() || set.contains(annotation.getType())) {
                RectF rectF2 = new RectF(annotation.getBoundingBox());
                if (a(annotation, rectF, (rectF2.width() < 40.0f || rectF2.top - rectF2.bottom < 40.0f) ? false : z, f)) {
                    arrayList2.add(annotation);
                    if (annotation.getType() == AnnotationType.INK) {
                        i2++;
                        List listA = a(annotation);
                        if (listA != null) {
                            size = listA.size();
                        } else {
                            List<List<PointF>> lines = annotation instanceof InkAnnotation ? ((InkAnnotation) annotation).getLines() : null;
                            if (lines != null) {
                                Iterator<T> it = lines.iterator();
                                int size3 = 0;
                                while (it.hasNext()) {
                                    size3 += ((List) it.next()).size();
                                }
                                size = size3;
                            } else {
                                size = 0;
                            }
                        }
                        i3 += size;
                    }
                }
            }
        }
        if (arrayList2.size() <= 1) {
            return arrayList2;
        }
        final PointF pointF = new PointF(rectF.centerX(), rectF.centerY());
        CollectionsKt.sortWith(arrayList2, new j2(new i2(pointF), arrayList));
        if ((i2 <= 2 || i3 <= 200) && ((i2 != 2 || i3 <= 2000) && z)) {
            final Function2 function2 = new Function2() { // from class: com.pspdfkit.internal.h2$$ExternalSyntheticLambda0
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj2, Object obj3) {
                    return Integer.valueOf(h2.a(f, rectF, (Annotation) obj2, (Annotation) obj3));
                }
            };
            CollectionsKt.sortWith(arrayList2, new Comparator() { // from class: com.pspdfkit.internal.h2$$ExternalSyntheticLambda1
                @Override // java.util.Comparator
                public final int compare(Object obj2, Object obj3) {
                    return h2.a(function2, obj2, obj3);
                }
            });
        }
        final Function2 function3 = new Function2() { // from class: com.pspdfkit.internal.h2$$ExternalSyntheticLambda2
            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(Object obj2, Object obj3) {
                return Integer.valueOf(h2.a(pointF, (Annotation) obj2, (Annotation) obj3));
            }
        };
        CollectionsKt.sortWith(arrayList2, new Comparator() { // from class: com.pspdfkit.internal.h2$$ExternalSyntheticLambda3
            @Override // java.util.Comparator
            public final int compare(Object obj2, Object obj3) {
                return h2.b(function3, obj2, obj3);
            }
        });
        return arrayList2;
    }

    public static final int b(Function2 function2, Object obj, Object obj2) {
        return ((Number) function2.invoke(obj, obj2)).intValue();
    }

    public static final int a(Function2 function2, Object obj, Object obj2) {
        return ((Number) function2.invoke(obj, obj2)).intValue();
    }

    public static final int a(float f, RectF rectF, Annotation annotation, Annotation annotation2) {
        boolean zA = true;
        boolean zA2 = true;
        for (float f2 = f / 2.0f; zA && zA2 && f2 > 6.0f; f2 /= 2.0f) {
            annotation.getClass();
            zA = a(annotation, rectF, true, f2);
            annotation2.getClass();
            zA2 = a(annotation2, rectF, true, f2);
        }
        if (!zA || zA2) {
            return (zA || !zA2) ? 0 : 1;
        }
        return -1;
    }

    public static final int a(PointF pointF, Annotation annotation, Annotation annotation2) {
        RectF rectF = new RectF(annotation.getBoundingBox());
        RectF boundingBox = annotation.getBoundingBox();
        boolean z = boundingBox.width() < 64.0f && boundingBox.top - boundingBox.bottom < 64.0f && kx.a(rectF, pointF.x, pointF.y);
        RectF rectF2 = new RectF(annotation2.getBoundingBox());
        RectF boundingBox2 = annotation2.getBoundingBox();
        boolean z2 = boundingBox2.width() < 64.0f && boundingBox2.top - boundingBox2.bottom < 64.0f && kx.a(rectF2, pointF.x, pointF.y);
        if (!z || z2) {
            return (z || !z2) ? 0 : 1;
        }
        return -1;
    }

    public static boolean a(Annotation annotation, RectF rectF, boolean z, float f) {
        RectF rectF2;
        if (!z) {
            return a(annotation.getBoundingBox(), rectF, f);
        }
        switch (a.a[annotation.getType().ordinal()]) {
            case 1:
            case 2:
            case 3:
                float fMax = Math.max(annotation.getBorderWidth(), f);
                List listA = a(annotation);
                if (listA != null && !listA.isEmpty()) {
                    return a(listA, fMax, rectF);
                }
                List<List<PointF>> lines = annotation instanceof InkAnnotation ? ((InkAnnotation) annotation).getLines() : null;
                if (lines != null && !lines.isEmpty()) {
                    if (lines.isEmpty()) {
                        return false;
                    }
                    Iterator<T> it = lines.iterator();
                    while (it.hasNext()) {
                        if (a((List) it.next(), fMax, rectF)) {
                            return true;
                        }
                    }
                    return false;
                }
                return a(annotation.getBoundingBox(), rectF, f);
            case 4:
                float fMax2 = Math.max(ww.b(annotation), f);
                int fillColor = annotation.getFillColor();
                List<PointF> listA2 = a(annotation);
                if (listA2 == null) {
                    return a(annotation.getBoundingBox(), rectF, f);
                }
                if (!Intrinsics.areEqual(CollectionsKt.first(listA2), CollectionsKt.last(listA2))) {
                    listA2 = CollectionsKt.plus((Collection<? extends Object>) listA2, CollectionsKt.first(listA2));
                }
                if (fillColor != 0) {
                    List<PointF> listListOf = CollectionsKt.listOf((Object[]) new PointF[]{new PointF(rectF.left, rectF.bottom), new PointF(rectF.right, rectF.bottom), new PointF(rectF.left, rectF.top), new PointF(rectF.right, rectF.top), new PointF(rectF.centerX(), rectF.centerY())});
                    if (!(listListOf instanceof Collection) || !listListOf.isEmpty()) {
                        for (PointF pointF : listListOf) {
                            listA2.getClass();
                            pointF.getClass();
                            if (listA2.size() >= 3) {
                                if (listA2.isEmpty()) {
                                    rectF2 = new RectF();
                                } else {
                                    float fMin = ((PointF) listA2.get(0)).x;
                                    float fMax3 = ((PointF) listA2.get(0)).x;
                                    float fMin2 = ((PointF) listA2.get(0)).y;
                                    float fMax4 = ((PointF) listA2.get(0)).y;
                                    for (PointF pointF2 : listA2) {
                                        fMin = Math.min(fMin, pointF2.x);
                                        fMax3 = Math.max(fMax3, pointF2.x);
                                        fMin2 = Math.min(fMin2, pointF2.y);
                                        fMax4 = Math.max(fMax4, pointF2.y);
                                    }
                                    rectF2 = new RectF(fMin, fMax4, fMax3, fMin2);
                                }
                                if (kx.a(rectF2, pointF.x, pointF.y)) {
                                    List listPlus = !Intrinsics.areEqual(CollectionsKt.first(listA2), CollectionsKt.last(listA2)) ? CollectionsKt.plus((Collection<? extends Object>) listA2, CollectionsKt.first(listA2)) : listA2;
                                    PointF pointF3 = new PointF(rectF2.left - 5, pointF.y);
                                    int size = listPlus.size();
                                    int i = 0;
                                    int i2 = 1;
                                    while (i2 < size) {
                                        PointF pointF4 = pointF;
                                        if (ui.a((PointF) listPlus.get(i2 - 1), (PointF) listPlus.get(i2), 0.1f, pointF3, pointF4, 0.1f)) {
                                            i++;
                                        }
                                        i2++;
                                        pointF = pointF4;
                                    }
                                    if (i % 2 == 1) {
                                        return true;
                                    }
                                } else {
                                    continue;
                                }
                            }
                        }
                    }
                }
                return a(listA2, fMax2, rectF);
            case 5:
                RectF boundingBox = annotation.getBoundingBox();
                float fMax5 = Math.max(annotation.getBorderWidth(), f);
                if (annotation.getFillColor() != 0 && a(boundingBox, rectF, f)) {
                    return true;
                }
                if (rectF.left <= boundingBox.left && rectF.right >= boundingBox.right && rectF.top >= boundingBox.top && rectF.bottom <= boundingBox.bottom) {
                    return true;
                }
                if (kx.a(rectF, boundingBox)) {
                    return a(CollectionsKt.listOf((Object[]) new PointF[]{new PointF(boundingBox.left, boundingBox.top), new PointF(boundingBox.right, boundingBox.top), new PointF(boundingBox.right, boundingBox.bottom), new PointF(boundingBox.left, boundingBox.bottom), new PointF(boundingBox.left, boundingBox.top)}), fMax5, rectF);
                }
                return false;
            case 6:
                RectF rectF3 = new RectF(annotation.getBoundingBox());
                float fMax6 = Math.max(annotation.getBorderWidth(), f);
                if (annotation.getFillColor() != 0) {
                    List<PointF> listListOf2 = CollectionsKt.listOf((Object[]) new PointF[]{new PointF(rectF.left, rectF.bottom), new PointF(rectF.right, rectF.bottom), new PointF(rectF.left, rectF.top), new PointF(rectF.right, rectF.top), new PointF(rectF.centerX(), rectF.centerY())});
                    if (!(listListOf2 instanceof Collection) || !listListOf2.isEmpty()) {
                        for (PointF pointF5 : listListOf2) {
                            pointF5.getClass();
                            PointF pointF6 = new PointF(rectF3.centerX(), rectF3.centerY());
                            float fWidth = rectF3.width() / 2.0f;
                            float f2 = (rectF3.top - rectF3.bottom) / 2.0f;
                            if (fWidth > 0.0f && f2 > 0.0f) {
                                float f3 = pointF5.x - pointF6.x;
                                float f4 = pointF5.y - pointF6.y;
                                if (((f4 * f4) / (f2 * f2)) + ((f3 * f3) / (fWidth * fWidth)) <= 1.0f) {
                                    return true;
                                }
                            }
                        }
                    }
                }
                if (rectF.left <= rectF3.left && rectF.right >= rectF3.right && rectF.top >= rectF3.top && rectF.bottom <= rectF3.bottom) {
                    return true;
                }
                if (!kx.a(rectF, rectF3)) {
                    return false;
                }
                PointF pointF7 = new PointF(rectF.left, rectF.top);
                PointF pointF8 = new PointF(rectF.right, rectF.top);
                PointF pointF9 = new PointF(rectF.left, rectF.bottom);
                PointF pointF10 = new PointF(rectF.right, rectF.bottom);
                return ui.a(rectF3, fMax6, pointF7, pointF8) || ui.a(rectF3, fMax6, pointF8, pointF10) || ui.a(rectF3, fMax6, pointF10, pointF9) || ui.a(rectF3, fMax6, pointF9, pointF7);
            default:
                return a(annotation.getBoundingBox(), rectF, f);
        }
    }

    public static boolean a(List list, float f, RectF rectF) {
        if (list.size() < 2) {
            return false;
        }
        PointF pointF = new PointF(rectF.left, rectF.top);
        PointF pointF2 = new PointF(rectF.right, rectF.top);
        PointF pointF3 = new PointF(rectF.left, rectF.bottom);
        PointF pointF4 = new PointF(rectF.right, rectF.bottom);
        int size = list.size();
        int i = 1;
        while (i < size) {
            PointF pointF5 = (PointF) list.get(i - 1);
            PointF pointF6 = (PointF) list.get(i);
            if (!kx.a(rectF, pointF5.x, pointF5.y) && !kx.a(rectF, pointF6.x, pointF6.y) && !ui.a(pointF5, pointF6, f, pointF, pointF2, 1.0f)) {
                PointF pointF7 = pointF2;
                if (!ui.a(pointF5, pointF6, f, pointF7, pointF4, 1.0f)) {
                    int i2 = i;
                    PointF pointF8 = pointF3;
                    if (!ui.a(pointF5, pointF6, f, pointF4, pointF8, 1.0f)) {
                        PointF pointF9 = pointF;
                        pointF = pointF9;
                        if (!ui.a(pointF5, pointF6, f, pointF8, pointF9, 1.0f)) {
                            i = i2 + 1;
                            pointF3 = pointF8;
                            pointF2 = pointF7;
                        }
                    }
                }
            }
            return true;
        }
        return false;
    }

    public static List a(Annotation annotation) {
        try {
            if (annotation instanceof LineAnnotation) {
                Pair<PointF, PointF> points = ((LineAnnotation) annotation).getPoints();
                points.getClass();
                return CollectionsKt.listOf((Object[]) new PointF[]{points.first, points.second});
            }
            if (annotation instanceof PolylineAnnotation) {
                return ((PolylineAnnotation) annotation).getPoints();
            }
            if (annotation instanceof PolygonAnnotation) {
                return ((PolygonAnnotation) annotation).getPoints();
            }
            return null;
        } catch (Exception unused) {
        }
    }

    public static boolean a(RectF rectF, RectF rectF2, float f) {
        if (f > 0.0f) {
            if (rectF.width() < f) {
                float fWidth = (f - rectF.width()) / 2.0f;
                rectF.left -= fWidth;
                rectF.right += fWidth;
            }
            float f2 = rectF.top;
            float f3 = rectF.bottom;
            float f4 = f2 - f3;
            if (f4 < f) {
                float f5 = (f - f4) / 2.0f;
                rectF.top = f2 + f5;
                rectF.bottom = f3 - f5;
            }
        }
        return kx.a(rectF, rectF2);
    }

    public static float a(RectF rectF, RectF rectF2) {
        rectF.getClass();
        rectF2.getClass();
        if (!kx.a(rectF, rectF2)) {
            return 0.0f;
        }
        float fMax = Math.max(rectF.left, rectF2.left);
        float fMin = Math.min(rectF.right, rectF2.right) - fMax;
        float fMin2 = Math.min(rectF.top, rectF2.top) - Math.max(rectF.bottom, rectF2.bottom);
        if (fMin <= 0.0f || fMin2 <= 0.0f) {
            return 0.0f;
        }
        return fMin * fMin2;
    }

    public static List a(List list, WidgetAnnotation widgetAnnotation) {
        list.getClass();
        widgetAnnotation.getClass();
        RectF boundingBox = widgetAnnotation.getBoundingBox();
        float fCoerceAtLeast = RangesKt.coerceAtLeast((boundingBox.top - boundingBox.bottom) * boundingBox.width(), 0.01f);
        int i = 0;
        Set of = SetsKt.setOf((Object[]) new AnnotationType[]{AnnotationType.INK, AnnotationType.STAMP});
        ArrayList arrayList = new ArrayList();
        for (Object obj : list) {
            Annotation annotation = (Annotation) obj;
            if (of.contains(annotation.getType()) && ww.h(annotation) && annotation.isAttached()) {
                arrayList.add(obj);
            }
        }
        ArrayList arrayListA = a(arrayList, boundingBox, 0.0f, of, false);
        ArrayList arrayList2 = new ArrayList();
        int size = arrayListA.size();
        while (i < size) {
            Object obj2 = arrayListA.get(i);
            i++;
            if (a(boundingBox, ((Annotation) obj2).getBoundingBox()) / fCoerceAtLeast >= 0.001f) {
                arrayList2.add(obj2);
            }
        }
        return CollectionsKt.sortedWith(arrayList2, new b(boundingBox));
    }
}
