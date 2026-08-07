package com.pspdfkit.internal.jni;

/* JADX INFO: loaded from: classes3.dex */
public final class NativeProgressiveRenderStepResult {
    final boolean mBitmapUpdated;
    final NativeProgressiveRenderStatus mStatus;

    public NativeProgressiveRenderStepResult(NativeProgressiveRenderStatus nativeProgressiveRenderStatus, boolean z) {
        this.mStatus = nativeProgressiveRenderStatus;
        this.mBitmapUpdated = z;
    }

    public boolean getBitmapUpdated() {
        return this.mBitmapUpdated;
    }

    public NativeProgressiveRenderStatus getStatus() {
        return this.mStatus;
    }

    public String toString() {
        return "NativeProgressiveRenderStepResult{mStatus=" + this.mStatus + ",mBitmapUpdated=" + this.mBitmapUpdated + "}";
    }
}
