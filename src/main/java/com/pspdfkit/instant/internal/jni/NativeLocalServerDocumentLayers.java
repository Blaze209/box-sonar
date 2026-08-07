package com.pspdfkit.instant.internal.jni;

import java.util.ArrayList;

/* JADX INFO: loaded from: classes3.dex */
public final class NativeLocalServerDocumentLayers {
    final String mDocumentId;
    final ArrayList<NativeServerDocumentLayer> mLoadedLayers;

    public NativeLocalServerDocumentLayers(String str, ArrayList<NativeServerDocumentLayer> arrayList) {
        this.mDocumentId = str;
        this.mLoadedLayers = arrayList;
    }

    public String getDocumentId() {
        return this.mDocumentId;
    }

    public ArrayList<NativeServerDocumentLayer> getLoadedLayers() {
        return this.mLoadedLayers;
    }

    public String toString() {
        return "NativeLocalServerDocumentLayers{mDocumentId=" + this.mDocumentId + ",mLoadedLayers=" + this.mLoadedLayers + "}";
    }
}
