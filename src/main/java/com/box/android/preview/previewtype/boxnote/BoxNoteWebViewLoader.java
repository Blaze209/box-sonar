package com.box.android.preview.previewtype.boxnote;

import android.webkit.ConsoleMessage;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import com.box.androidsdk.content.utils.BoxLogUtils;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: BoxNoteWebViewLoader.kt */
/* JADX INFO: loaded from: classes12.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010$\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0007J*\u0010\f\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\u000e2\u0012\u0010\u000f\u001a\u000e\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u000e0\u0010R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0011"}, d2 = {"Lcom/box/android/preview/previewtype/boxnote/BoxNoteWebViewLoader;", "", "callbacks", "Lcom/box/android/preview/previewtype/boxnote/BoxNoteWebViewCallbacks;", "assetCache", "Lcom/box/android/preview/previewtype/boxnote/BoxNotesWebviewAssetCache;", "<init>", "(Lcom/box/android/preview/previewtype/boxnote/BoxNoteWebViewCallbacks;Lcom/box/android/preview/previewtype/boxnote/BoxNotesWebviewAssetCache;)V", "initWebView", "", "webView", "Landroid/webkit/WebView;", "loadUrl", "url", "", "headers", "", "preview_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class BoxNoteWebViewLoader {
    public static final int $stable = 8;
    private final BoxNotesWebviewAssetCache assetCache;
    private final BoxNoteWebViewCallbacks callbacks;

    public BoxNoteWebViewLoader(BoxNoteWebViewCallbacks callbacks, BoxNotesWebviewAssetCache assetCache) {
        Intrinsics.checkNotNullParameter(callbacks, "callbacks");
        Intrinsics.checkNotNullParameter(assetCache, "assetCache");
        this.callbacks = callbacks;
        this.assetCache = assetCache;
    }

    public final void initWebView(WebView webView) {
        Intrinsics.checkNotNullParameter(webView, "webView");
        webView.getSettings().setJavaScriptEnabled(true);
        webView.getSettings().setDomStorageEnabled(true);
        webView.getSettings().setSupportZoom(false);
        webView.getSettings().setBuiltInZoomControls(false);
        webView.getSettings().setDisplayZoomControls(false);
        webView.getSettings().setLoadWithOverviewMode(true);
        webView.getSettings().setUseWideViewPort(true);
        webView.setFocusable(true);
        webView.setFocusableInTouchMode(true);
        webView.setWebViewClient(new BoxNoteWebViewClient(this.callbacks.getBridgeDelegate(), this.assetCache));
        webView.setWebChromeClient(new WebChromeClient() { // from class: com.box.android.preview.previewtype.boxnote.BoxNoteWebViewLoader$initWebView$1$1
            @Override // android.webkit.WebChromeClient
            public boolean onConsoleMessage(ConsoleMessage consoleMessage) {
                Intrinsics.checkNotNullParameter(consoleMessage, "consoleMessage");
                BoxLogUtils.v(BoxNoteConstants.LOG_TAG, "Console: " + consoleMessage.message());
                return true;
            }
        });
        webView.setVisibility(4);
    }

    public final void loadUrl(WebView webView, String url, Map<String, String> headers) {
        Intrinsics.checkNotNullParameter(webView, "webView");
        Intrinsics.checkNotNullParameter(url, "url");
        Intrinsics.checkNotNullParameter(headers, "headers");
        webView.loadUrl(url, headers);
    }
}
