package com.pspdfkit.document.library;

/* JADX INFO: loaded from: classes3.dex */
public interface LibraryIndexingListener {
    boolean enableOnPageIndexedEvents();

    void onFinishIndexingDocument(String str, boolean z);

    void onPageIndexed(String str, int i, String str2);

    void onStartIndexingDocument(String str);
}
