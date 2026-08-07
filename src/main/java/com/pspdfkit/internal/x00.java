package com.pspdfkit.internal;

import com.pspdfkit.internal.jni.NativeContentEditingResult;
import com.pspdfkit.utils.Size;

/* JADX INFO: loaded from: classes3.dex */
public final class x00 extends kn {
    public final Float g;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public x00(i50 i50Var, Size size, Float f) {
        super(i50Var, size, null, null, i50.a(i50Var, null, null, f, 3));
        i50Var.getClass();
        this.g = f;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.pspdfkit.internal.ha, com.pspdfkit.internal.ga
    public final void a(g70 g70Var, NativeContentEditingResult nativeContentEditingResult) {
        g70Var.getClass();
        nativeContentEditingResult.getClass();
        this.a.d.d = this.g;
        super.a(g70Var, nativeContentEditingResult);
    }
}
