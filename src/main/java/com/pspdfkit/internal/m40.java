package com.pspdfkit.internal;

import android.graphics.Rect;
import android.graphics.RectF;
import com.pspdfkit.annotations.Annotation;
import com.pspdfkit.annotations.AnnotationType;
import com.pspdfkit.configuration.rendering.PageRenderConfiguration;
import com.pspdfkit.utils.Size;
import java.util.EnumSet;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.sequences.SequencesKt;

/* JADX INFO: loaded from: classes3.dex */
public final class m40 {
    public final lm a;
    public final int b;
    public final PageRenderConfiguration c;
    public final boolean d;
    public final Rect e;
    public final float f;
    public Size g;
    public boolean h;
    public final boolean i;
    public final boolean j;
    public final EnumSet<AnnotationType> k;
    public final List<Annotation> l;
    public final List<AnnotationType> m;
    public final List<Integer> n;
    public final Lazy o;
    public final Lazy p;

    /* JADX WARN: Multi-variable type inference failed */
    public m40(lm lmVar, int i, PageRenderConfiguration pageRenderConfiguration, boolean z, Rect rect, float f, Size size, boolean z2, boolean z3, boolean z4, EnumSet<AnnotationType> enumSet, List<? extends Annotation> list, List<? extends AnnotationType> list2, List<Integer> list3) {
        pageRenderConfiguration.getClass();
        rect.getClass();
        enumSet.getClass();
        list.getClass();
        list2.getClass();
        list3.getClass();
        this.a = lmVar;
        this.b = i;
        this.c = pageRenderConfiguration;
        this.d = z;
        this.e = rect;
        this.f = f;
        this.g = size;
        this.h = z2;
        this.i = z3;
        this.j = z4;
        this.k = enumSet;
        this.l = list;
        this.m = list2;
        this.n = list3;
        this.o = LazyKt.lazy(new Function0() { // from class: com.pspdfkit.internal.m40$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return m40.b(this.f$0);
            }
        });
        this.p = LazyKt.lazy(new Function0() { // from class: com.pspdfkit.internal.m40$$ExternalSyntheticLambda1
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return m40.a(this.f$0);
            }
        });
    }

    public static m40 a(m40 m40Var, boolean z, Rect rect, float f, boolean z2, boolean z3, List list, List list2, List list3, int i) {
        lm lmVar = m40Var.a;
        int i2 = m40Var.b;
        PageRenderConfiguration pageRenderConfiguration = m40Var.c;
        boolean z4 = (i & 8) != 0 ? m40Var.d : z;
        Rect rect2 = (i & 16) != 0 ? m40Var.e : rect;
        float f2 = (i & 32) != 0 ? m40Var.f : f;
        Size size = m40Var.g;
        boolean z5 = z4;
        Rect rect3 = rect2;
        float f3 = f2;
        boolean z6 = m40Var.h;
        boolean z7 = (i & 256) != 0 ? m40Var.i : z2;
        boolean z8 = (i & 512) != 0 ? m40Var.j : z3;
        EnumSet<AnnotationType> enumSet = m40Var.k;
        List list4 = (i & 2048) != 0 ? m40Var.l : list;
        List list5 = (i & 4096) != 0 ? m40Var.m : list2;
        List list6 = (i & 8192) != 0 ? m40Var.n : list3;
        m40Var.getClass();
        pageRenderConfiguration.getClass();
        rect3.getClass();
        enumSet.getClass();
        list4.getClass();
        list5.getClass();
        list6.getClass();
        return new m40(lmVar, i2, pageRenderConfiguration, z5, rect3, f3, size, z6, z7, z8, enumSet, list4, list5, list6);
    }

    public static final RectF b(m40 m40Var) {
        Size pageSize = m40Var.a.getPageSize(m40Var.b);
        return new RectF(0.0f, pageSize.height, pageSize.width, 0.0f);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof m40)) {
            return false;
        }
        m40 m40Var = (m40) obj;
        if (!Intrinsics.areEqual(this.a, m40Var.a) || this.b != m40Var.b || !Intrinsics.areEqual((RectF) this.o.getValue(), (RectF) m40Var.o.getValue()) || this.f != m40Var.f || !Intrinsics.areEqual(this.g, m40Var.g) || this.h != m40Var.h || this.i != m40Var.i || !Intrinsics.areEqual(this.c, m40Var.c) || this.d != m40Var.d || this.j != m40Var.j || !Intrinsics.areEqual(this.k, m40Var.k) || !Intrinsics.areEqual(this.l, m40Var.l) || !Intrinsics.areEqual(this.m, m40Var.m) || !Intrinsics.areEqual(this.n, m40Var.n)) {
            return false;
        }
        Rect rect = this.e;
        String str = rect.left + "_" + rect.bottom + "_" + rect.right + "_" + rect.top;
        Rect rect2 = m40Var.e;
        return Intrinsics.areEqual(str, rect2.left + "_" + rect2.bottom + "_" + rect2.right + "_" + rect2.top);
    }

    public final int hashCode() {
        return this.n.hashCode() + lv.a(this.m, lv.a(this.l, (this.k.hashCode() + mv.a(this.j, (this.e.hashCode() + mv.a(this.d, (this.c.hashCode() + mv.a(this.i, mv.a(this.h, (this.g.hashCode() + kv.a(this.f, (((RectF) this.o.getValue()).hashCode() + (((this.a.hashCode() * 31) + this.b) * 31)) * 31, 31)) * 31, 31), 31)) * 31, 31)) * 31, 31)) * 31, 31), 31);
    }

    public final String toString() {
        return "State(pageIndex=" + this.b + ", unscaledPageLayoutSize=" + this.g + ", zoom=" + this.f + ", pageRect=" + ((RectF) this.o.getValue()) + ", localVisibleRect=" + this.e + ", isRedactionPreviewEnabled=" + this.h + ", dontRenderText=" + this.i + ", pageRenderConfiguration=" + this.c + ", isPageVisible=" + this.d + ")";
    }

    public static final List a(m40 m40Var) {
        return SequencesKt.toList(SequencesKt.distinct(SequencesKt.plus(SequencesKt.map(CollectionsKt.asSequence(m40Var.l), new Function1() { // from class: com.pspdfkit.internal.m40$$ExternalSyntheticLambda2
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return Integer.valueOf(m40.a((Annotation) obj));
            }
        }), CollectionsKt.asSequence(m40Var.n))));
    }

    public static final int a(Annotation annotation) {
        annotation.getClass();
        return annotation.getObjectNumber();
    }

    public final String a() {
        List<AnnotationType> list = this.m;
        return new StringBuilder().append(list).append((List) this.p.getValue()).toString();
    }
}
