package com.pspdfkit.internal.jni;

/* JADX INFO: loaded from: classes3.dex */
public final class NativeDocumentLibraryIndexStatusProgress {
    final NativeDocumentLibraryIndexStatus mIndexStatus;
    final float mProgress;

    public NativeDocumentLibraryIndexStatusProgress(NativeDocumentLibraryIndexStatus nativeDocumentLibraryIndexStatus, float f) {
        this.mIndexStatus = nativeDocumentLibraryIndexStatus;
        this.mProgress = f;
    }

    public NativeDocumentLibraryIndexStatus getIndexStatus() {
        return this.mIndexStatus;
    }

    public float getProgress() {
        return this.mProgress;
    }

    public String toString() {
        return "NativeDocumentLibraryIndexStatusProgress{mIndexStatus=" + this.mIndexStatus + ",mProgress=" + this.mProgress + "}";
    }
}
