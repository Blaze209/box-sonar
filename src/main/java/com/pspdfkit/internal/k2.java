package com.pspdfkit.internal;

import android.content.Context;
import android.graphics.Matrix;
import android.graphics.PointF;
import android.graphics.RectF;
import android.view.MotionEvent;
import com.pspdfkit.R;
import com.pspdfkit.annotations.Annotation;
import com.pspdfkit.annotations.AnnotationType;
import java.util.ArrayList;
import java.util.EnumSet;
import java.util.List;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final class k2 {
    public final EnumSet<AnnotationType> a;
    public final int b;
    public List<? extends Annotation> c;
    public Function1<? super Annotation, Boolean> d;
    public final PointF e;
    public final ArrayList f;
    public final PointF g;
    public final RectF h;

    public k2(Context context, EnumSet<AnnotationType> enumSet) {
        context.getClass();
        enumSet.getClass();
        this.a = enumSet;
        this.b = context.getResources().getDimensionPixelSize(R.dimen.pspdf__min_editable_annotation_touch_size);
        this.c = CollectionsKt.emptyList();
        this.e = new PointF();
        this.f = new ArrayList();
        this.g = new PointF();
        this.h = new RectF();
    }

    public final boolean a(Annotation annotation) {
        annotation.getClass();
        return !this.a.contains(annotation.getType()) && ww.h(annotation);
    }

    public final List<Annotation> a(MotionEvent motionEvent, Matrix matrix) {
        ArrayList arrayList;
        motionEvent.getClass();
        matrix.getClass();
        float x = motionEvent.getX();
        float y = motionEvent.getY();
        if (this.c.isEmpty()) {
            return CollectionsKt.emptyList();
        }
        this.g.set(x, y);
        l4.a(matrix, this.g);
        RectF rectF = this.h;
        PointF pointF = this.g;
        float f = pointF.x;
        float f2 = pointF.y;
        float f3 = 1;
        rectF.set(f, f2 + f3, f3 + f, f2);
        synchronized (this) {
            if (Intrinsics.areEqual(this.e, this.g)) {
                return this.f;
            }
            Unit unit = Unit.INSTANCE;
            RectF rectF2 = this.h;
            float fA = s60.a(this.b, matrix);
            ArrayList arrayListA = a();
            List listEmptyList = arrayListA.isEmpty() ? CollectionsKt.emptyList() : h2.a(arrayListA, rectF2, fA, SetsKt.emptySet(), true);
            synchronized (this) {
                this.e.set(this.g);
                this.f.clear();
                this.f.addAll(listEmptyList);
                arrayList = this.f;
            }
            return arrayList;
        }
    }

    public final ArrayList a() {
        Function1<? super Annotation, Boolean> function1 = this.d;
        List<? extends Annotation> list = this.c;
        ArrayList arrayList = new ArrayList();
        for (Object obj : list) {
            Annotation annotation = (Annotation) obj;
            boolean z = annotation.isAttached() || annotation.getType() == AnnotationType.LINK;
            if (a(annotation) && z && (function1 == null || function1.invoke(annotation).booleanValue())) {
                arrayList.add(obj);
            }
        }
        return arrayList;
    }
}
