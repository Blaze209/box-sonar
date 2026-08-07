package com.pspdfkit.document.html;

import android.webkit.WebChromeClient;
import android.webkit.WebView;

/* JADX INFO: loaded from: classes3.dex */
class WebChromeClientImpl extends WebChromeClient {
    private final HtmlToPdfConverter.PageLoadingProgressListener pageLoadingProgressListener;

    public WebChromeClientImpl(HtmlToPdfConverter.PageLoadingProgressListener pageLoadingProgressListener) {
        this.pageLoadingProgressListener = pageLoadingProgressListener;
    }

    @Override // android.webkit.WebChromeClient
    public void onProgressChanged(WebView webView, int i) {
        super.onProgressChanged(webView, i);
        this.pageLoadingProgressListener.onPageLoadingProgress(i);
    }
}
