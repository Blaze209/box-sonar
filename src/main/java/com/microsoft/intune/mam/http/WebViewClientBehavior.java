package com.microsoft.intune.mam.http;

import android.net.http.SslError;
import android.webkit.SslErrorHandler;
import android.webkit.WebView;

/* JADX INFO: loaded from: classes3.dex */
public interface WebViewClientBehavior {
    boolean onReceivedSslError(WebView webView, SslErrorHandler sslErrorHandler, SslError sslError);
}
