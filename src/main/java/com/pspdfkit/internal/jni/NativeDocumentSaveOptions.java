package com.pspdfkit.internal.jni;

import java.util.EnumSet;

/* JADX INFO: loaded from: classes3.dex */
public final class NativeDocumentSaveOptions {
    final EnumSet<NativeDocumentSaveFlags> mSaveFlags;
    final NativeDocumentSecurityOptions mSecurityOptions;

    public NativeDocumentSaveOptions(NativeDocumentSecurityOptions nativeDocumentSecurityOptions, EnumSet<NativeDocumentSaveFlags> enumSet) {
        this.mSecurityOptions = nativeDocumentSecurityOptions;
        this.mSaveFlags = enumSet;
    }

    public EnumSet<NativeDocumentSaveFlags> getSaveFlags() {
        return this.mSaveFlags;
    }

    public NativeDocumentSecurityOptions getSecurityOptions() {
        return this.mSecurityOptions;
    }

    public String toString() {
        return "NativeDocumentSaveOptions{mSecurityOptions=" + this.mSecurityOptions + ",mSaveFlags=" + this.mSaveFlags + "}";
    }
}
