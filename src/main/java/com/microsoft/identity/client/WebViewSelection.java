package com.microsoft.identity.client;

/* JADX INFO: loaded from: classes14.dex */
public enum WebViewSelection {
    EMBEDDED_WEBVIEW(1),
    SYSTEM_BROWSER(2);

    private int mId;

    WebViewSelection(int i) {
        this.mId = i;
    }

    public int getId() {
        return this.mId;
    }
}
