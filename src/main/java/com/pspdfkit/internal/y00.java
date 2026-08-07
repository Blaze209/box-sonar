package com.pspdfkit.internal;

import com.pspdfkit.internal.jni.NativeContentEditingResult;
import com.pspdfkit.utils.Size;

/* JADX INFO: loaded from: classes3.dex */
public final class y00 extends kn {
    public final Float g;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public y00(i50 i50Var, Size size, Float f) {
        super(i50Var, size, null, null, i50.a(i50Var, f, null, null, 6));
        i50Var.getClass();
        this.g = f;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.pspdfkit.internal.ha, com.pspdfkit.internal.ga
    public final void a(g70 g70Var, NativeContentEditingResult nativeContentEditingResult) {
        g70Var.getClass();
        nativeContentEditingResult.getClass();
        l50 l50Var = this.a.d;
        Float f = this.g;
        l50Var.f = Float.valueOf(Float.max(f != null ? f.floatValue() : 0.0f, ((Number) g70Var.j.getValue()).floatValue()));
        i50 i50Var = this.a;
        Size size = this.b;
        i50Var.getClass();
        tc tcVar = g70Var.e;
        zq zqVar = tcVar.a;
        i50Var.e = g70Var;
        if (zqVar == null) {
            tcVar.a = zqVar;
        }
        if (size != null) {
            i50Var.a(size);
        }
    }
}
