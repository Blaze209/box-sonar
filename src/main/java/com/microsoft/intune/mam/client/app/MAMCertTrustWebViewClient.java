package com.microsoft.intune.mam.client.app;

import android.net.http.SslError;
import android.webkit.SslErrorHandler;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.microsoft.intune.mam.client.InterfaceComponentsAccess;
import com.microsoft.intune.mam.http.WebViewClientBehavior;

/* JADX INFO: loaded from: classes3.dex */
public class MAMCertTrustWebViewClient extends WebViewClient {
    private final WebViewClientBehavior mBehavior = (WebViewClientBehavior) InterfaceComponentsAccess.get(WebViewClientBehavior.class);

    @Override // android.webkit.WebViewClient
    public void onReceivedSslError(WebView webView, SslErrorHandler sslErrorHandler, SslError sslError) {
        if (this.mBehavior.onReceivedSslError(webView, sslErrorHandler, sslError)) {
            return;
        }
        super.onReceivedSslError(webView, sslErrorHandler, sslError);
    }
}
