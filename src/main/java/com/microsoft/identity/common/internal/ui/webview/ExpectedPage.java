package com.microsoft.identity.common.internal.ui.webview;

/* JADX INFO: loaded from: classes14.dex */
public class ExpectedPage {
    OnPageLoadedCallback mCallback;
    String mExpectedPageUrlStartsWith;

    public ExpectedPage(String str, OnPageLoadedCallback onPageLoadedCallback) {
        this.mExpectedPageUrlStartsWith = str;
        this.mCallback = onPageLoadedCallback;
    }
}
