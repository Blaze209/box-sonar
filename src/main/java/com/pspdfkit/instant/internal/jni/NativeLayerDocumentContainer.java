package com.pspdfkit.instant.internal.jni;

import com.pspdfkit.internal.jni.NativeDocument;
import java.util.EnumSet;

/* JADX INFO: loaded from: classes3.dex */
public final class NativeLayerDocumentContainer {
    final NativeDocument mDocument;
    final EnumSet<NativeLayerCapabilities> mLayerCapabilities;

    public NativeLayerDocumentContainer(NativeDocument nativeDocument, EnumSet<NativeLayerCapabilities> enumSet) {
        this.mDocument = nativeDocument;
        this.mLayerCapabilities = enumSet;
    }

    public NativeDocument getDocument() {
        return this.mDocument;
    }

    public EnumSet<NativeLayerCapabilities> getLayerCapabilities() {
        return this.mLayerCapabilities;
    }

    public String toString() {
        return "NativeLayerDocumentContainer{mDocument=" + this.mDocument + ",mLayerCapabilities=" + this.mLayerCapabilities + "}";
    }
}
