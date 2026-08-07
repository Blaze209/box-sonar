package com.pspdfkit.internal.jni;

import com.pspdfkit.utils.Size;
import java.util.EnumSet;

/* JADX INFO: loaded from: classes3.dex */
public final class NativeSnapperConfiguration {
    final EnumSet<NativeSnapPointType> mSnapPointTypes;
    final Size mSnapSize;

    public NativeSnapperConfiguration(Size size, EnumSet<NativeSnapPointType> enumSet) {
        this.mSnapSize = size;
        this.mSnapPointTypes = enumSet;
    }

    public EnumSet<NativeSnapPointType> getSnapPointTypes() {
        return this.mSnapPointTypes;
    }

    public Size getSnapSize() {
        return this.mSnapSize;
    }

    public String toString() {
        return "NativeSnapperConfiguration{mSnapSize=" + this.mSnapSize + ",mSnapPointTypes=" + this.mSnapPointTypes + "}";
    }
}
