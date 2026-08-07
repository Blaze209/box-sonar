package com.box.android.hubs.hubDetails.presentation;

import android.webkit.WebSettings;
import android.webkit.WebView;
import com.box.android.domain.webBridgeAuth.AuthenticatedWebClient;
import com.box.android.domain.webBridgeAuth.IBoxWebBridgeAuthenticator;
import com.box.androidsdk.content.utils.BoxLogUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: HubDetailsWebViewLoader.kt */
/* JADX INFO: loaded from: classes12.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u0018\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rH\u0007R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000e"}, d2 = {"Lcom/box/android/hubs/hubDetails/presentation/HubDetailsWebViewLoader;", "", "webBridgeAuthenticator", "Lcom/box/android/domain/webBridgeAuth/IBoxWebBridgeAuthenticator;", "callbacks", "Lcom/box/android/hubs/hubDetails/presentation/HubDetailsWebCallbacks;", "<init>", "(Lcom/box/android/domain/webBridgeAuth/IBoxWebBridgeAuthenticator;Lcom/box/android/hubs/hubDetails/presentation/HubDetailsWebCallbacks;)V", "initWebView", "", "webView", "Landroid/webkit/WebView;", "hubsUrl", "", "hubs_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class HubDetailsWebViewLoader {
    public static final int $stable = 8;
    private final HubDetailsWebCallbacks callbacks;
    private final IBoxWebBridgeAuthenticator webBridgeAuthenticator;

    public HubDetailsWebViewLoader(IBoxWebBridgeAuthenticator webBridgeAuthenticator, HubDetailsWebCallbacks callbacks) {
        Intrinsics.checkNotNullParameter(webBridgeAuthenticator, "webBridgeAuthenticator");
        Intrinsics.checkNotNullParameter(callbacks, "callbacks");
        this.webBridgeAuthenticator = webBridgeAuthenticator;
        this.callbacks = callbacks;
    }

    public final void initWebView(WebView webView, String hubsUrl) {
        Intrinsics.checkNotNullParameter(webView, "webView");
        Intrinsics.checkNotNullParameter(hubsUrl, "hubsUrl");
        WebSettings settings = webView.getSettings();
        settings.setJavaScriptEnabled(true);
        settings.setDomStorageEnabled(true);
        try {
            AuthenticatedWebClient authenticatedWebClientAuthenticate = this.webBridgeAuthenticator.authenticate(hubsUrl);
            authenticatedWebClientAuthenticate.onPageFinished(this.callbacks.getOnHubLoaded());
            authenticatedWebClientAuthenticate.onShouldOverrideUrlLoading(this.callbacks.getOnShouldOverrideUrlLoading());
            authenticatedWebClientAuthenticate.onReceivedError(this.callbacks.getOnLoadError());
            webView.setWebViewClient(authenticatedWebClientAuthenticate);
            webView.loadUrl(hubsUrl);
        } catch (Exception e) {
            BoxLogUtils.e("HubDetailsWebView", "Error initializing WebView: " + e.getMessage());
            this.callbacks.getOnLoadError().invoke(e.getMessage());
        }
    }
}
