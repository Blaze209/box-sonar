package com.pspdfkit.internal.jni;

import java.util.ArrayList;

/* JADX INFO: loaded from: classes3.dex */
public final class NativeTabOrder {
    final Integer mPageFrom;
    final Integer mPageTo;
    final ArrayList<Integer> mWidgetIDs;

    public NativeTabOrder(ArrayList<Integer> arrayList, Integer num, Integer num2) {
        this.mWidgetIDs = arrayList;
        this.mPageFrom = num;
        this.mPageTo = num2;
    }

    public Integer getPageFrom() {
        return this.mPageFrom;
    }

    public Integer getPageTo() {
        return this.mPageTo;
    }

    public ArrayList<Integer> getWidgetIDs() {
        return this.mWidgetIDs;
    }

    public String toString() {
        return "NativeTabOrder{mWidgetIDs=" + this.mWidgetIDs + ",mPageFrom=" + this.mPageFrom + ",mPageTo=" + this.mPageTo + "}";
    }
}
