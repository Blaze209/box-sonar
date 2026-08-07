package com.pspdfkit.internal.jni;

import android.graphics.RectF;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes3.dex */
public final class NativeExtractedLink {
    final ArrayList<RectF> mRects;
    final String mUrl;

    public NativeExtractedLink(String str, ArrayList<RectF> arrayList) {
        this.mUrl = str;
        this.mRects = arrayList;
    }

    public ArrayList<RectF> getRects() {
        return this.mRects;
    }

    public String getUrl() {
        return this.mUrl;
    }

    public String toString() {
        return "NativeExtractedLink{mUrl=" + this.mUrl + ",mRects=" + this.mRects + "}";
    }
}
