package com.pspdfkit.internal;

import com.pspdfkit.annotations.Annotation;

/* JADX INFO: loaded from: classes3.dex */
public final class j4<T extends Annotation> implements z4.a {
    public final /* synthetic */ i4 a;
    public final /* synthetic */ z4<?> b;

    public j4(i4 i4Var, z4<?> z4Var) {
        this.a = i4Var;
        this.b = z4Var;
    }

    @Override // com.pspdfkit.internal.z4.a
    public final void a(z4<?> z4Var) {
        z4Var.getClass();
        c3 c3Var = this.a.l;
        z4<?> z4Var2 = this.b;
        c3Var.getClass();
        c3Var.removeView(z4Var2.a());
        i4 i4Var = this.a;
        z4<?> z4Var3 = this.b;
        i4Var.b.b(z4Var3);
        i4Var.d.remove(z4Var3);
        this.a.c();
    }
}
