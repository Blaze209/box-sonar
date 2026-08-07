package com.pspdfkit.internal;

import com.pspdfkit.configuration.PdfConfiguration;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final class i5 {
    public final ot a;
    public final List<fo> b;
    public final PdfConfiguration c;
    public final boolean d;
    public final boolean e;
    public final boolean f;
    public final boolean g;
    public final boolean h;
    public final boolean i;
    public final boolean j;

    public i5() {
        this(0);
    }

    public static i5 a(i5 i5Var, ot otVar, List list, PdfConfiguration pdfConfiguration, boolean z, boolean z2, boolean z3, boolean z4, boolean z5, boolean z6, boolean z7, int i) {
        if ((i & 1) != 0) {
            otVar = i5Var.a;
        }
        ot otVar2 = otVar;
        if ((i & 2) != 0) {
            list = i5Var.b;
        }
        List list2 = list;
        if ((i & 4) != 0) {
            pdfConfiguration = i5Var.c;
        }
        PdfConfiguration pdfConfiguration2 = pdfConfiguration;
        if ((i & 8) != 0) {
            z = i5Var.d;
        }
        boolean z8 = z;
        boolean z9 = (i & 16) != 0 ? i5Var.e : z2;
        boolean z10 = (i & 32) != 0 ? i5Var.f : z3;
        boolean z11 = (i & 64) != 0 ? i5Var.g : z4;
        boolean z12 = (i & 128) != 0 ? i5Var.h : z5;
        boolean z13 = (i & 256) != 0 ? i5Var.i : z6;
        boolean z14 = (i & 512) != 0 ? i5Var.j : z7;
        i5Var.getClass();
        list2.getClass();
        return new i5(otVar2, list2, pdfConfiguration2, z8, z9, z10, z11, z12, z13, z14);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof i5)) {
            return false;
        }
        i5 i5Var = (i5) obj;
        return Intrinsics.areEqual(this.a, i5Var.a) && Intrinsics.areEqual(this.b, i5Var.b) && Intrinsics.areEqual(this.c, i5Var.c) && this.d == i5Var.d && this.e == i5Var.e && this.f == i5Var.f && this.g == i5Var.g && this.h == i5Var.h && this.i == i5Var.i && this.j == i5Var.j;
    }

    public final int hashCode() {
        ot otVar = this.a;
        int iA = lv.a(this.b, (otVar == null ? 0 : otVar.hashCode()) * 31, 31);
        PdfConfiguration pdfConfiguration = this.c;
        return Boolean.hashCode(this.j) + mv.a(this.i, mv.a(this.h, mv.a(this.g, mv.a(this.f, mv.a(this.e, mv.a(this.d, (iA + (pdfConfiguration != null ? pdfConfiguration.hashCode() : 0)) * 31, 31), 31), 31), 31), 31), 31);
    }

    public final String toString() {
        return "AnnotationsListState(themeConfiguration=" + this.a + ", annotationListItems=" + this.b + ", currentConfiguration=" + this.c + ", isEditingAllowed=" + this.d + ", isEditingEnabled=" + this.e + ", annotationListReorderingEnabled=" + this.f + ", isParentVisible=" + this.g + ", isLoadingAnnotations=" + this.h + ", isEditing=" + this.i + ", isInstantDocument=" + this.j + ")";
    }

    /* JADX WARN: Multi-variable type inference failed */
    public i5(ot otVar, List<? extends fo> list, PdfConfiguration pdfConfiguration, boolean z, boolean z2, boolean z3, boolean z4, boolean z5, boolean z6, boolean z7) {
        list.getClass();
        this.a = otVar;
        this.b = list;
        this.c = pdfConfiguration;
        this.d = z;
        this.e = z2;
        this.f = z3;
        this.g = z4;
        this.h = z5;
        this.i = z6;
        this.j = z7;
    }

    public /* synthetic */ i5(int i) {
        this(null, CollectionsKt.emptyList(), null, false, true, false, false, false, false, false);
    }
}
