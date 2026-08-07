package com.pspdfkit.internal.jni;

import com.pspdfkit.internal.nv;

/* JADX INFO: loaded from: classes3.dex */
public final class NativeLabelParseResult {
    final String mLabel;
    final int mPageIndex;

    public NativeLabelParseResult(int i, String str) {
        this.mPageIndex = i;
        this.mLabel = str;
    }

    public String getLabel() {
        return this.mLabel;
    }

    public int getPageIndex() {
        return this.mPageIndex;
    }

    public String toString() {
        return nv.a(new StringBuilder("NativeLabelParseResult{mPageIndex=").append(this.mPageIndex).append(",mLabel="), this.mLabel, "}");
    }
}
