package com.microsoft.identity.common.internal.ui.webview.challengehandlers;

import android.webkit.HttpAuthHandler;
import android.webkit.WebView;

/* JADX INFO: loaded from: classes14.dex */
public class NtlmChallenge {
    private HttpAuthHandler mHandler;
    private String mHost;
    private String mRealm;
    private WebView mView;

    NtlmChallenge(WebView webView, HttpAuthHandler httpAuthHandler, String str, String str2) {
        this.mHandler = httpAuthHandler;
        this.mView = webView;
        this.mHost = str;
        this.mRealm = str2;
    }

    HttpAuthHandler getHandler() {
        return this.mHandler;
    }

    WebView getView() {
        return this.mView;
    }

    String getHost() {
        return this.mHost;
    }

    String getRealm() {
        return this.mRealm;
    }
}
