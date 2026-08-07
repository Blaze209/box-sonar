package com.pspdfkit.internal;

import android.graphics.Matrix;
import android.graphics.PointF;
import android.view.MotionEvent;
import com.pspdfkit.annotations.Annotation;
import com.pspdfkit.annotations.AnnotationType;
import java.util.ArrayList;
import java.util.Collection;
import java.util.EnumSet;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
import kotlin.collections.CollectionsKt;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final class nf {
    public final k2 a;
    public EnumSet<AnnotationType> b;
    public a c;

    public interface a {
        boolean a(Annotation annotation);
    }

    public static final /* synthetic */ class b {
        public static final /* synthetic */ EnumEntries<AnnotationType> a = EnumEntriesKt.enumEntries(AnnotationType.values());
    }

    public nf(k2 k2Var) {
        k2Var.getClass();
        this.a = k2Var;
        EnumSet<AnnotationType> enumSetCopyOf = EnumSet.copyOf((Collection) b.a);
        enumSetCopyOf.getClass();
        this.b = enumSetCopyOf;
    }

    public final Annotation a(MotionEvent motionEvent, Matrix matrix, boolean z) {
        motionEvent.getClass();
        matrix.getClass();
        List<Annotation> listA = this.a.a(motionEvent, matrix);
        ArrayList arrayList = new ArrayList();
        for (Object obj : listA) {
            if (a((Annotation) obj, z)) {
                arrayList.add(obj);
            }
        }
        if (arrayList.size() <= 1) {
            return (Annotation) CollectionsKt.firstOrNull((List) arrayList);
        }
        PointF pointF = new PointF(motionEvent.getX(), motionEvent.getY());
        Matrix matrix2 = new Matrix();
        matrix.invert(matrix2);
        s60.a(pointF, matrix2);
        Iterator it = arrayList.iterator();
        if (!it.hasNext()) {
            throw new NoSuchElementException();
        }
        Object next = it.next();
        if (it.hasNext()) {
            Annotation annotation = (Annotation) next;
            float fA = ip.a(pointF.x, pointF.y, annotation.getBoundingBox().centerX(), annotation.getBoundingBox().centerY());
            do {
                Object next2 = it.next();
                Annotation annotation2 = (Annotation) next2;
                float fA2 = ip.a(pointF.x, pointF.y, annotation2.getBoundingBox().centerX(), annotation2.getBoundingBox().centerY());
                if (Float.compare(fA, fA2) > 0) {
                    next = next2;
                    fA = fA2;
                }
            } while (it.hasNext());
        }
        return (Annotation) next;
    }

    public final ArrayList a(String str) {
        k2 k2Var = this.a;
        if (str == null) {
            k2Var.getClass();
            return null;
        }
        ArrayList arrayListA = k2Var.a();
        ArrayList arrayList = new ArrayList();
        int size = arrayListA.size();
        int i = 0;
        while (i < size) {
            Object obj = arrayListA.get(i);
            i++;
            if (Intrinsics.areEqual(((Annotation) obj).getGroup(), str)) {
                arrayList.add(obj);
            }
        }
        if (arrayList.size() > 1) {
            return arrayList;
        }
        return null;
    }

    public final boolean a(Annotation annotation) {
        annotation.getClass();
        return this.b.contains(annotation.getType()) && ww.f(annotation) && annotation.isAttached();
    }

    public final boolean a(Annotation annotation, boolean z) {
        if (!z && !a(annotation)) {
            return false;
        }
        annotation.getClass();
        if (!this.a.a(annotation)) {
            return false;
        }
        a aVar = this.c;
        return aVar == null || aVar.a(annotation);
    }
}
