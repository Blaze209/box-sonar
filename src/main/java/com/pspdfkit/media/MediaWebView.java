package com.pspdfkit.media;

import android.content.Context;
import android.util.AttributeSet;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.microsoft.identity.common.adal.internal.AuthenticationConstants;
import com.microsoft.intune.mam.client.widget.MAMWebView;

/* JADX INFO: loaded from: classes3.dex */
public class MediaWebView extends MAMWebView implements MediaViewController {
    MediaViewListener listener;

    public MediaWebView(Context context) {
        super(context);
        init();
    }

    private void init() {
        WebSettings settings = getSettings();
        settings.setJavaScriptEnabled(true);
        settings.setPluginState(WebSettings.PluginState.ON);
        settings.setJavaScriptCanOpenWindowsAutomatically(true);
        settings.setSupportMultipleWindows(true);
        settings.setSupportZoom(true);
        settings.setBuiltInZoomControls(true);
        setWebViewClient(new WebViewClient() { // from class: com.pspdfkit.media.MediaWebView.1
            @Override // android.webkit.WebViewClient
            public void onPageFinished(WebView webView, String str) {
                super.onPageFinished(webView, str);
                MediaViewListener mediaViewListener = MediaWebView.this.listener;
                if (mediaViewListener != null) {
                    mediaViewListener.onContentReady();
                }
            }
        });
        setWebChromeClient(new WebChromeClient());
    }

    @Override // com.pspdfkit.media.MediaViewController
    public void close() {
        destroy();
    }

    public void setMediaViewListener(MediaViewListener mediaViewListener) {
        this.listener = mediaViewListener;
    }

    @Override // com.pspdfkit.media.MediaViewController
    public void start(String str, String str2) {
        if (!str2.startsWith("http://") && !str2.startsWith(AuthenticationConstants.Broker.REDIRECT_SSL_PREFIX)) {
            str2 = "http://".concat(str2);
        }
        loadUrl(str2);
    }

    public MediaWebView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init();
    }

    public MediaWebView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        init();
    }
}
