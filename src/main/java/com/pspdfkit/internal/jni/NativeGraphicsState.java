package com.pspdfkit.internal.jni;

/* JADX INFO: loaded from: classes3.dex */
public final class NativeGraphicsState {
    final Float mAlphaFill;
    final Float mAlphaStroke;
    final NativeBlendMode mBlendMode;

    public NativeGraphicsState(NativeBlendMode nativeBlendMode, Float f, Float f2) {
        this.mBlendMode = nativeBlendMode;
        this.mAlphaStroke = f;
        this.mAlphaFill = f2;
    }

    public Float getAlphaFill() {
        return this.mAlphaFill;
    }

    public Float getAlphaStroke() {
        return this.mAlphaStroke;
    }

    public NativeBlendMode getBlendMode() {
        return this.mBlendMode;
    }

    public String toString() {
        return "NativeGraphicsState{mBlendMode=" + this.mBlendMode + ",mAlphaStroke=" + this.mAlphaStroke + ",mAlphaFill=" + this.mAlphaFill + "}";
    }
}
