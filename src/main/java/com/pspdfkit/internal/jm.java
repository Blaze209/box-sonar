package com.pspdfkit.internal;

import android.graphics.Bitmap;
import android.util.Size;
import com.pspdfkit.annotations.AnnotationType;
import com.pspdfkit.internal.jni.NativeDocumentEditor;
import com.pspdfkit.ui.drawable.PdfDrawable;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final class jm {
    public final ou a;
    public final int b;
    public final Bitmap c;
    public final Size d;
    public final boolean e;
    public final NativeDocumentEditor f;
    public final oy g;
    public final int h;
    public final int i;
    public final Integer j;
    public final Integer k;
    public final Integer l;
    public final Integer m;
    public final boolean n;
    public final boolean o;
    public final List<Integer> p;
    public final List<AnnotationType> q;
    public final List<PdfDrawable> r;
    public final boolean s;
    public final boolean t;
    public final boolean u;

    /* JADX WARN: Multi-variable type inference failed */
    public jm(ou ouVar, int i, Bitmap bitmap, Size size, boolean z, NativeDocumentEditor nativeDocumentEditor, oy oyVar, int i2, int i3, Integer num, Integer num2, Integer num3, Integer num4, boolean z2, boolean z3, List<Integer> list, List<? extends AnnotationType> list2, List<? extends PdfDrawable> list3, boolean z4, boolean z5, boolean z6) {
        ouVar.getClass();
        list.getClass();
        list2.getClass();
        list3.getClass();
        this.a = ouVar;
        this.b = i;
        this.c = bitmap;
        this.d = size;
        this.e = z;
        this.f = nativeDocumentEditor;
        this.g = oyVar;
        this.h = i2;
        this.i = i3;
        this.j = num;
        this.k = num2;
        this.l = num3;
        this.m = num4;
        this.n = z2;
        this.o = z3;
        this.p = list;
        this.q = list2;
        this.r = list3;
        this.s = z4;
        this.t = z5;
        this.u = z6;
        if (bitmap != null) {
            if (bitmap.getWidth() != size.getWidth() || bitmap.getHeight() != size.getHeight()) {
                throw new IllegalArgumentException("Reusable bitmap has to be the same size as passed width and height.");
            }
        }
    }

    public static jm a(jm jmVar, Bitmap bitmap, NativeDocumentEditor nativeDocumentEditor, oy oyVar, int i, Integer num, List list, List list2, List list3, boolean z, boolean z2, int i2) {
        ou ouVar = jmVar.a;
        int i3 = jmVar.b;
        Bitmap bitmap2 = (i2 & 4) != 0 ? jmVar.c : bitmap;
        Size size = jmVar.d;
        Bitmap bitmap3 = bitmap2;
        boolean z3 = jmVar.e;
        NativeDocumentEditor nativeDocumentEditor2 = (i2 & 32) != 0 ? jmVar.f : nativeDocumentEditor;
        oy oyVar2 = (i2 & 64) != 0 ? jmVar.g : oyVar;
        int i4 = jmVar.i;
        Integer num2 = jmVar.j;
        Integer num3 = jmVar.k;
        Integer num4 = (i2 & 2048) != 0 ? jmVar.l : num;
        Integer num5 = jmVar.m;
        boolean z4 = jmVar.n;
        boolean z5 = jmVar.o;
        List list4 = (i2 & 32768) != 0 ? jmVar.p : list;
        List list5 = (i2 & 65536) != 0 ? jmVar.q : list2;
        List list6 = (i2 & 131072) != 0 ? jmVar.r : list3;
        boolean z6 = (i2 & 262144) != 0 ? jmVar.s : z;
        boolean z7 = jmVar.t;
        boolean z8 = (i2 & 1048576) != 0 ? jmVar.u : z2;
        jmVar.getClass();
        ouVar.getClass();
        list4.getClass();
        list5.getClass();
        list6.getClass();
        return new jm(ouVar, i3, bitmap3, size, z3, nativeDocumentEditor2, oyVar2, i, i4, num2, num3, num4, num5, z4, z5, list4, list5, list6, z6, z7, z8);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof jm)) {
            return false;
        }
        jm jmVar = (jm) obj;
        return Intrinsics.areEqual(this.a, jmVar.a) && this.b == jmVar.b && Intrinsics.areEqual(this.c, jmVar.c) && Intrinsics.areEqual(this.d, jmVar.d) && this.e == jmVar.e && Intrinsics.areEqual(this.f, jmVar.f) && Intrinsics.areEqual(this.g, jmVar.g) && this.h == jmVar.h && this.i == jmVar.i && Intrinsics.areEqual(this.j, jmVar.j) && Intrinsics.areEqual(this.k, jmVar.k) && Intrinsics.areEqual(this.l, jmVar.l) && Intrinsics.areEqual(this.m, jmVar.m) && this.n == jmVar.n && this.o == jmVar.o && Intrinsics.areEqual(this.p, jmVar.p) && Intrinsics.areEqual(this.q, jmVar.q) && Intrinsics.areEqual(this.r, jmVar.r) && this.s == jmVar.s && this.t == jmVar.t && this.u == jmVar.u;
    }

    public final int hashCode() {
        int iA = nd.a(this.b, this.a.hashCode() * 31, 31);
        Bitmap bitmap = this.c;
        int iA2 = mv.a(this.e, (this.d.hashCode() + ((iA + (bitmap == null ? 0 : bitmap.hashCode())) * 31)) * 31, 31);
        NativeDocumentEditor nativeDocumentEditor = this.f;
        int iHashCode = (iA2 + (nativeDocumentEditor == null ? 0 : nativeDocumentEditor.hashCode())) * 31;
        oy oyVar = this.g;
        int iA3 = nd.a(this.i, nd.a(this.h, (iHashCode + (oyVar == null ? 0 : oyVar.hashCode())) * 31, 31), 31);
        Integer num = this.j;
        int iHashCode2 = (iA3 + (num == null ? 0 : num.hashCode())) * 31;
        Integer num2 = this.k;
        int iHashCode3 = (iHashCode2 + (num2 == null ? 0 : num2.hashCode())) * 31;
        Integer num3 = this.l;
        int iHashCode4 = (iHashCode3 + (num3 == null ? 0 : num3.hashCode())) * 31;
        Integer num4 = this.m;
        return Boolean.hashCode(this.u) + mv.a(this.t, mv.a(this.s, lv.a(this.r, lv.a(this.q, lv.a(this.p, mv.a(this.o, mv.a(this.n, (iHashCode4 + (num4 != null ? num4.hashCode() : 0)) * 31, 31), 31), 31), 31), 31), 31), 31);
    }

    public final String toString() {
        return "InternalPageRenderConfig(renderingHelper=" + this.a + ", pageIndex=" + this.b + ", reuseBitmap=" + this.c + ", bitmapSize=" + this.d + ", cachePage=" + this.e + ", documentEditor=" + this.f + ", regionRenderOptions=" + this.g + ", priority=" + this.h + ", paperColor=" + this.i + ", formHighlightColor=" + this.j + ", formItemHighlightColor=" + this.k + ", formRequiredFieldBorderColor=" + this.l + ", signHereOverlayBackgroundColor=" + this.m + ", invertColors=" + this.n + ", toGrayscale=" + this.o + ", excludedAnnotations=" + this.p + ", excludedAnnotationTypes=" + this.q + ", pdfDrawables=" + this.r + ", drawRedactAsRedacted=" + this.s + ", showSignHereOverlay=" + this.t + ", renderText=" + this.u + ")";
    }
}
