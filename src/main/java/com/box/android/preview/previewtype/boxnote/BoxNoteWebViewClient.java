package com.box.android.preview.previewtype.boxnote;

import android.net.Uri;
import android.util.Base64;
import android.webkit.WebResourceError;
import android.webkit.WebResourceRequest;
import android.webkit.WebResourceResponse;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.box.androidsdk.content.utils.BoxLogUtils;
import com.microsoft.identity.common.java.providers.microsoft.MicrosoftAuthorizationErrorResponse;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;

/* JADX INFO: compiled from: BoxNoteWebViewLoader.kt */
/* JADX INFO: loaded from: classes12.dex */
@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0007\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u0018\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rH\u0016J\u0018\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\u000fH\u0017J \u0010\u0010\u001a\u00020\u00112\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u0012\u001a\u00020\u0013H\u0016J\u001a\u0010\u0014\u001a\u0004\u0018\u00010\u00152\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rH\u0016J\u0018\u0010\u0016\u001a\u00020\t2\u0006\u0010\u0017\u001a\u00020\u000b2\u0006\u0010\u0018\u001a\u00020\u0019H\u0002J\u0012\u0010\u001a\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\u001b\u001a\u00020\u000fH\u0002J\u0010\u0010\u001c\u001a\u00020\u00112\u0006\u0010\u0017\u001a\u00020\u000bH\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001d"}, d2 = {"Lcom/box/android/preview/previewtype/boxnote/BoxNoteWebViewClient;", "Landroid/webkit/WebViewClient;", "bridgeDelegate", "Lcom/box/android/preview/previewtype/boxnote/BoxNoteBridgeDelegate;", "assetCache", "Lcom/box/android/preview/previewtype/boxnote/BoxNotesWebviewAssetCache;", "<init>", "(Lcom/box/android/preview/previewtype/boxnote/BoxNoteBridgeDelegate;Lcom/box/android/preview/previewtype/boxnote/BoxNotesWebviewAssetCache;)V", "shouldOverrideUrlLoading", "", "view", "Landroid/webkit/WebView;", "request", "Landroid/webkit/WebResourceRequest;", "url", "", "onReceivedError", "", "error", "Landroid/webkit/WebResourceError;", "shouldInterceptRequest", "Landroid/webkit/WebResourceResponse;", "handleBridgeUrl", "webView", "uri", "Landroid/net/Uri;", "uriAndBase64Decode", "encodedString", "addSelectionListener", "preview_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class BoxNoteWebViewClient extends WebViewClient {
    public static final int $stable = 8;
    private final BoxNotesWebviewAssetCache assetCache;
    private final BoxNoteBridgeDelegate bridgeDelegate;

    public BoxNoteWebViewClient(BoxNoteBridgeDelegate bridgeDelegate, BoxNotesWebviewAssetCache assetCache) {
        Intrinsics.checkNotNullParameter(bridgeDelegate, "bridgeDelegate");
        Intrinsics.checkNotNullParameter(assetCache, "assetCache");
        this.bridgeDelegate = bridgeDelegate;
        this.assetCache = assetCache;
    }

    @Override // android.webkit.WebViewClient
    public boolean shouldOverrideUrlLoading(WebView view, WebResourceRequest request) {
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(request, "request");
        Uri url = request.getUrl();
        Intrinsics.checkNotNull(url);
        return handleBridgeUrl(view, url);
    }

    @Override // android.webkit.WebViewClient
    public void onReceivedError(WebView view, WebResourceRequest request, WebResourceError error) {
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(request, "request");
        Intrinsics.checkNotNullParameter(error, "error");
        BoxLogUtils.w(BoxNoteConstants.LOG_TAG, "Box notes webview received an error: " + ((Object) error.getDescription()));
        this.bridgeDelegate.onError(error.getErrorCode(), error.getDescription().toString());
    }

    @Override // android.webkit.WebViewClient
    public WebResourceResponse shouldInterceptRequest(WebView view, WebResourceRequest request) {
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(request, "request");
        WebResourceResponse webResourceResponseShouldInterceptRequest = this.assetCache.shouldInterceptRequest(request.getUrl().toString());
        Uri url = request.getUrl();
        BoxLogUtils.v(BoxNoteConstants.LOG_TAG, "Intercepting box note asset request " + (url.getScheme() + "://" + url.getHost() + url.getPath()) + ", cached asset exists: " + (webResourceResponseShouldInterceptRequest != null));
        return webResourceResponseShouldInterceptRequest != null ? webResourceResponseShouldInterceptRequest : super.shouldInterceptRequest(view, request);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    private final boolean handleBridgeUrl(WebView webView, Uri uri) {
        if (!Intrinsics.areEqual(uri.getScheme(), BoxNoteConstants.BOX_NOTE_BRIDGE_SCHEME)) {
            return false;
        }
        String host = uri.getHost();
        if (host == null) {
            return true;
        }
        try {
            String str = "";
            switch (host.hashCode()) {
                case -2131127654:
                    if (host.equals(BoxNoteConstants.BOX_NOTE_EVENT_EXTERNAL_LINK)) {
                        String queryParameter = uri.getQueryParameter(BoxNoteConstants.BOX_NOTE_BRIDGE_KEY_LINK);
                        if (queryParameter != null) {
                            str = queryParameter;
                        }
                        String strDecode = URLDecoder.decode(str, "UTF-8");
                        BoxNoteBridgeDelegate boxNoteBridgeDelegate = this.bridgeDelegate;
                        Intrinsics.checkNotNull(strDecode);
                        boxNoteBridgeDelegate.onExternalLinkClicked(strDecode);
                    }
                    break;
                case -1271104311:
                    if (host.equals(BoxNoteConstants.BOX_NOTE_EVENT_CONNECTION_STATE_CHANGE)) {
                        String queryParameter2 = uri.getQueryParameter("value");
                        if (queryParameter2 == null) {
                            queryParameter2 = "";
                        }
                        String queryParameter3 = uri.getQueryParameter(BoxNoteConstants.BOX_NOTE_BRIDGE_KEY_REASON);
                        if (queryParameter3 != null) {
                            str = queryParameter3;
                        }
                        BoxLogUtils.d(BoxNoteConstants.LOG_TAG, "Connection state changed: " + queryParameter2 + ", reason: " + str);
                        this.bridgeDelegate.onConnectionStateChanged(queryParameter2, str);
                    }
                    break;
                case -220015849:
                    if (host.equals(BoxNoteConstants.BOX_NOTE_EVENT_FOCUS_EDITOR)) {
                        String queryParameter4 = uri.getQueryParameter("value");
                        if (queryParameter4 == null) {
                            queryParameter4 = "off";
                        }
                        boolean zAreEqual = Intrinsics.areEqual(queryParameter4, "on");
                        BoxLogUtils.d(BoxNoteConstants.LOG_TAG, "Editor focus changed: " + zAreEqual);
                        this.bridgeDelegate.onEditorFocus(zAreEqual);
                    }
                    break;
                case -178236565:
                    if (host.equals(BoxNoteConstants.BOX_NOTE_EVENT_EDITOR_INIT_ERROR)) {
                        String queryParameter5 = uri.getQueryParameter("error");
                        if (queryParameter5 == null) {
                            queryParameter5 = MicrosoftAuthorizationErrorResponse.UNKNOWN_ERROR;
                        }
                        BoxLogUtils.e(BoxNoteConstants.LOG_TAG, "Editor init error: " + queryParameter5);
                        this.bridgeDelegate.onError(-1, queryParameter5);
                    }
                    break;
                case -32562536:
                    if (host.equals(BoxNoteConstants.BOX_NOTE_EVENT_STYLE_CHANGE)) {
                        String queryParameter6 = uri.getQueryParameter(BoxNoteConstants.BOX_NOTE_BRIDGE_KEY_STYLE_TYPE);
                        if (queryParameter6 == null) {
                            queryParameter6 = "";
                        }
                        String queryParameter7 = uri.getQueryParameter(BoxNoteConstants.BOX_NOTE_BRIDGE_KEY_STYLE_VALUE);
                        if (queryParameter7 != null) {
                            str = queryParameter7;
                        }
                        this.bridgeDelegate.onStyleChanged(queryParameter6, str);
                    }
                    break;
                case 449080179:
                    if (host.equals(BoxNoteConstants.BOX_NOTE_EVENT_SELECTION_CHANGED)) {
                        String queryParameter8 = uri.getQueryParameter(BoxNoteConstants.BOX_NOTE_BRIDGE_KEY_HAS_SELECTION);
                        boolean z = queryParameter8 != null ? Boolean.parseBoolean(queryParameter8) : false;
                        BoxLogUtils.d(BoxNoteConstants.LOG_TAG, "Selection changed: hasSelection=" + z);
                        this.bridgeDelegate.onSelectionChanged(z);
                    }
                    break;
                case 1918908529:
                    if (host.equals(BoxNoteConstants.BOX_NOTE_EVENT_SELECTED_HTML_RESPONSE)) {
                        String queryParameter9 = uri.getQueryParameter(BoxNoteConstants.BOX_NOTE_BRIDGE_KEY_ENCODED_HTML);
                        if (queryParameter9 == null) {
                            queryParameter9 = "";
                        }
                        String strUriAndBase64Decode = uriAndBase64Decode(queryParameter9);
                        BoxNoteBridgeDelegate boxNoteBridgeDelegate2 = this.bridgeDelegate;
                        if (strUriAndBase64Decode != null) {
                            str = strUriAndBase64Decode;
                        }
                        boxNoteBridgeDelegate2.onSelectedHtmlFetched(str);
                    }
                    break;
                case 2146863427:
                    if (host.equals(BoxNoteConstants.BOX_NOTE_EVENT_EDITOR_READY)) {
                        BoxLogUtils.d(BoxNoteConstants.LOG_TAG, "Editor ready");
                        this.bridgeDelegate.onEditorReady();
                        addSelectionListener(webView);
                    }
                    break;
            }
        } catch (Exception e) {
            BoxLogUtils.e(BoxNoteConstants.LOG_TAG, "Error handling bridge URL", e);
        }
        return true;
    }

    private final String uriAndBase64Decode(String encodedString) {
        byte[] bArrDecode = Base64.decode(encodedString, 0);
        Intrinsics.checkNotNullExpressionValue(bArrDecode, "decode(...)");
        try {
            return URLDecoder.decode(new String(bArrDecode, Charsets.UTF_8), "UTF-8");
        } catch (UnsupportedEncodingException e) {
            BoxLogUtils.logException(e);
            return null;
        }
    }

    private final void addSelectionListener(WebView webView) {
        webView.evaluateJavascript("(function() {\n    let lastHasSelection = false;\n\n    document.addEventListener('selectionchange', function() {\n        const selection = window.getSelection();\n        const hasSelection = selection && selection.toString().length > 0;\n\n        if (hasSelection !== lastHasSelection) {\n            lastHasSelection = hasSelection;\n\n            // Use iframe trick to avoid navigation confirmation dialog\n            const iframe = document.createElement('iframe');\n            iframe.style.display = 'none';\n            iframe.src = 'box-notes://selection-changed?hasSelection=' + hasSelection;\n            document.body.appendChild(iframe);\n\n            // Clean up iframe after a short delay\n            setTimeout(function() {\n                document.body.removeChild(iframe);\n            }, 100);\n        }\n    });\n})();", null);
        BoxLogUtils.d(BoxNoteConstants.LOG_TAG, "Selection listener injected");
    }

    @Override // android.webkit.WebViewClient
    @Deprecated(message = "Deprecated in Java")
    public boolean shouldOverrideUrlLoading(WebView view, String url) {
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(url, "url");
        return handleBridgeUrl(view, Uri.parse(url));
    }
}
