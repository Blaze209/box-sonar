package com.pspdfkit.internal;

import com.pspdfkit.internal.jni.NativeContentEditingResult;
import com.pspdfkit.utils.Size;
import kotlinx.serialization.DeserializationStrategy;
import kotlinx.serialization.KSerializer;

/* JADX INFO: loaded from: classes3.dex */
public abstract class ha<InputType> extends ga<InputType, g70> {
    public final i50 a;
    public final Size b;
    public final KSerializer<g70> c;

    public ha(i50 i50Var, Size size) {
        i50Var.getClass();
        this.a = i50Var;
        this.b = size;
        this.c = g70.Companion.serializer();
    }

    @Override // com.pspdfkit.internal.ga
    public final DeserializationStrategy<g70> f() {
        return this.c;
    }

    @Override // com.pspdfkit.internal.ga
    public void a(g70 g70Var, NativeContentEditingResult nativeContentEditingResult) {
        g70Var.getClass();
        nativeContentEditingResult.getClass();
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
