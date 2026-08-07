package com.pspdfkit.instant.internal.jni;

import java.util.ArrayList;

/* JADX INFO: loaded from: classes3.dex */
public final class NativeCommentInsertion {
    final String mCreatedCommentId;
    final ArrayList<NativeComment> mUpdatedThread;

    public NativeCommentInsertion(String str, ArrayList<NativeComment> arrayList) {
        this.mCreatedCommentId = str;
        this.mUpdatedThread = arrayList;
    }

    public String getCreatedCommentId() {
        return this.mCreatedCommentId;
    }

    public ArrayList<NativeComment> getUpdatedThread() {
        return this.mUpdatedThread;
    }

    public String toString() {
        return "NativeCommentInsertion{mCreatedCommentId=" + this.mCreatedCommentId + ",mUpdatedThread=" + this.mUpdatedThread + "}";
    }
}
