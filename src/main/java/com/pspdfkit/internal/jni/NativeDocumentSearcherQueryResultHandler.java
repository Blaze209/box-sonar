package com.pspdfkit.internal.jni;

import java.util.ArrayList;

/* JADX INFO: loaded from: classes3.dex */
public abstract class NativeDocumentSearcherQueryResultHandler {
    public abstract void pageResultHandler(NativeDocumentSearcherQuery nativeDocumentSearcherQuery, String str, long j, ArrayList<NativeDocumentSearcherResult> arrayList);

    public abstract void searchCompleteHandler(NativeDocumentSearcherQuery nativeDocumentSearcherQuery, String str);
}
