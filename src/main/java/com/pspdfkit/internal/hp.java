package com.pspdfkit.internal;

import android.graphics.RectF;
import com.pspdfkit.annotations.Annotation;
import com.pspdfkit.annotations.AnnotationType;
import com.pspdfkit.annotations.BaseRectsAnnotation;
import com.pspdfkit.annotations.UnderlineAnnotation;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.EnumSet;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.StringCompanionObject;
import kotlinx.coroutines.BuildersKt__BuildersKt;

/* JADX INFO: loaded from: classes3.dex */
public final class hp {
    public static final EnumSet<AnnotationType> a = EnumSet.of(AnnotationType.REDACT, AnnotationType.HIGHLIGHT, AnnotationType.SQUIGGLY, AnnotationType.STRIKEOUT, AnnotationType.UNDERLINE);
    public static final UnderlineAnnotation b = new UnderlineAnnotation(0, new ArrayList());

    public static BaseRectsAnnotation a(lm lmVar, int i, AnnotationType annotationType, int i2, float f, List list) {
        Object next;
        annotationType.getClass();
        list.getClass();
        EnumSet<AnnotationType> enumSet = a;
        if (!enumSet.contains(annotationType)) {
            StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
            throw new IllegalArgumentException(String.format("The passed annotation type (%s) is not a markup annotation (%s)", Arrays.copyOf(new Object[]{annotationType, enumSet}, 2)).toString());
        }
        b.setName("com.pspdfkit.internal.annotations.markup.default-rect-name");
        Iterator it = ((List) BuildersKt__BuildersKt.runBlocking$default(null, new gp(lmVar, i, null), 1, null)).iterator();
        loop0: while (true) {
            if (!it.hasNext()) {
                next = null;
                break;
            }
            next = it.next();
            Annotation annotation = (Annotation) next;
            if (annotation.getType() == annotationType) {
                BaseRectsAnnotation baseRectsAnnotation = annotation instanceof BaseRectsAnnotation ? (BaseRectsAnnotation) annotation : null;
                if (baseRectsAnnotation != null && baseRectsAnnotation.getColor() == i2 && Math.abs(baseRectsAnnotation.getAlpha() - f) <= 0.001f && !list.isEmpty()) {
                    ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
                    Iterator it2 = list.iterator();
                    while (it2.hasNext()) {
                        RectF rectF = new RectF((RectF) it2.next());
                        rectF.sort();
                        arrayList.add(rectF);
                    }
                    List<RectF> rects = baseRectsAnnotation.getRects();
                    if (rects.isEmpty()) {
                        rects = null;
                    }
                    if (rects == null) {
                        rects = CollectionsKt.listOf(baseRectsAnnotation.getBoundingBox());
                    }
                    if (!(rects instanceof Collection) || !rects.isEmpty()) {
                        Iterator<T> it3 = rects.iterator();
                        while (it3.hasNext()) {
                            RectF rectF2 = new RectF((RectF) it3.next());
                            rectF2.sort();
                            if (!arrayList.isEmpty()) {
                                int size = arrayList.size();
                                int i3 = 0;
                                while (i3 < size) {
                                    Object obj = arrayList.get(i3);
                                    i3++;
                                    if (RectF.intersects(rectF2, (RectF) obj)) {
                                        break loop0;
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        BaseRectsAnnotation baseRectsAnnotation2 = next instanceof BaseRectsAnnotation ? (BaseRectsAnnotation) next : null;
        return baseRectsAnnotation2 == null ? b : baseRectsAnnotation2;
    }

    public static void a(BaseRectsAnnotation baseRectsAnnotation, List list) {
        baseRectsAnnotation.getClass();
        list.getClass();
        List<RectF> rects = baseRectsAnnotation.getRects();
        if (rects.isEmpty() && list.isEmpty()) {
            return;
        }
        ArrayList arrayList = new ArrayList(rects.size());
        Iterator<RectF> it = rects.iterator();
        while (it.hasNext()) {
            arrayList.add(new RectF(it.next()));
        }
        ArrayList arrayList2 = new ArrayList(list.size());
        Iterator it2 = list.iterator();
        while (it2.hasNext()) {
            arrayList2.add(new RectF((RectF) it2.next()));
        }
        arrayList.addAll(arrayList2);
        int size = arrayList.size();
        int i = 0;
        int i2 = 0;
        while (i2 < size) {
            Object obj = arrayList.get(i2);
            i2++;
            ((RectF) obj).sort();
        }
        int i3 = 0;
        while (i3 < arrayList.size()) {
            RectF rectF = (RectF) arrayList.get(i3);
            for (int i4 = i3 + 1; i4 < arrayList.size(); i4++) {
                RectF rectF2 = (RectF) arrayList.get(i4);
                if (rectF2.contains(rectF)) {
                    arrayList.remove(i3);
                    i3--;
                    break;
                } else {
                    if (rectF.contains(rectF2)) {
                        arrayList.remove(i4);
                    }
                }
            }
            i3++;
        }
        int size2 = arrayList.size();
        while (i < size2) {
            Object obj2 = arrayList.get(i);
            i++;
            RectF rectF3 = (RectF) obj2;
            float f = rectF3.left;
            float f2 = rectF3.right;
            if (f > f2) {
                rectF3.left = f2;
                rectF3.right = f;
            }
            float f3 = rectF3.bottom;
            float f4 = rectF3.top;
            if (f3 > f4) {
                rectF3.bottom = f4;
                rectF3.top = f3;
            }
        }
        baseRectsAnnotation.setRects(arrayList);
    }
}
