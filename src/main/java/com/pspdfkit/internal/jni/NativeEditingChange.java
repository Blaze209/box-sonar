package com.pspdfkit.internal.jni;

/* JADX INFO: loaded from: classes3.dex */
public final class NativeEditingChange {
    final int mAffectedPageIndex;
    final NativeEditingOperation mOperation;
    final int mPageIndexDestination;
    final int mPageReferenceSourceIndex;

    public NativeEditingChange(NativeEditingOperation nativeEditingOperation, int i, int i2, int i3) {
        this.mOperation = nativeEditingOperation;
        this.mAffectedPageIndex = i;
        this.mPageIndexDestination = i2;
        this.mPageReferenceSourceIndex = i3;
    }

    public int getAffectedPageIndex() {
        return this.mAffectedPageIndex;
    }

    public NativeEditingOperation getOperation() {
        return this.mOperation;
    }

    public int getPageIndexDestination() {
        return this.mPageIndexDestination;
    }

    public int getPageReferenceSourceIndex() {
        return this.mPageReferenceSourceIndex;
    }

    public String toString() {
        return "NativeEditingChange{mOperation=" + this.mOperation + ",mAffectedPageIndex=" + this.mAffectedPageIndex + ",mPageIndexDestination=" + this.mPageIndexDestination + ",mPageReferenceSourceIndex=" + this.mPageReferenceSourceIndex + "}";
    }
}
