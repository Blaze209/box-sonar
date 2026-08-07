package com.pspdfkit.document.html;

import android.content.Context;
import android.graphics.Bitmap;
import android.net.Uri;
import android.text.TextUtils;
import android.webkit.URLUtil;
import android.webkit.WebResourceError;
import android.webkit.WebResourceRequest;
import android.webkit.WebResourceResponse;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.pspdfkit.internal.hw;
import com.pspdfkit.utils.PdfLog;
import io.reactivex.rxjava3.core.CompletableEmitter;
import java.util.Locale;
import java.util.Objects;

/* JADX INFO: loaded from: classes3.dex */
class WebViewClientImpl extends WebViewClient {
    private final String LOG_TAG = "Nutri.WebViewClientImpl";
    private final Context context;
    private boolean isFinished;
    private final ResourceInterceptor resourceInterceptor;
    private final Uri sourceUri;
    private final CompletableEmitter subscriber;

    public WebViewClientImpl(Context context, Uri uri, ResourceInterceptor resourceInterceptor, CompletableEmitter completableEmitter) {
        this.context = context;
        this.sourceUri = uri;
        this.resourceInterceptor = resourceInterceptor;
        this.subscriber = completableEmitter;
    }

    private CharSequence getErrorDescription(Uri uri, CharSequence charSequence) {
        if (URLUtil.isNetworkUrl(uri.toString())) {
            Context context = this.context;
            context.getClass();
            if (!new hw(context).a("android.permission.INTERNET")) {
                return "Could not load network Uri because of missing android.permission.INTERNET in AndroidManifest.xml";
            }
        }
        return charSequence;
    }

    private void handleError(Uri uri, int i, CharSequence charSequence, boolean z) {
        boolean zIsBaseUri = isBaseUri(uri);
        String str = z ? "HTTP error: %d" : "Error code: %d";
        String str2 = String.format(Locale.US, zIsBaseUri ? "Error loading URI: %s, " + str + ", description: %s" : "Error loading resource: %s, " + str + ", description: %s", uri, Integer.valueOf(i), getErrorDescription(uri, charSequence));
        if (zIsBaseUri) {
            this.subscriber.tryOnError(new HtmlConversionException(str2));
        } else {
            if (shouldIgnoreUri(uri)) {
                return;
            }
            PdfLog.w("Nutri.WebViewClientImpl", str2, new Object[0]);
        }
    }

    private boolean isBaseUri(Uri uri) {
        return Objects.equals(uri.getScheme(), this.sourceUri.getScheme()) && Objects.equals(uri.getAuthority(), this.sourceUri.getAuthority()) && isSamePath(uri.getPath(), this.sourceUri.getPath());
    }

    private boolean isEmptyPath(String str) {
        return TextUtils.isEmpty(str) || str.equals("/");
    }

    private boolean isSamePath(String str, String str2) {
        if (Objects.equals(str, str2)) {
            return true;
        }
        return isEmptyPath(str) && isEmptyPath(str2);
    }

    private boolean shouldIgnoreUri(Uri uri) {
        if ("data".equals(uri.getScheme())) {
            return true;
        }
        return uri.getLastPathSegment() != null && uri.getLastPathSegment().equals("favicon.ico");
    }

    private void tryOnSuccess() {
        if (this.isFinished) {
            return;
        }
        this.isFinished = true;
        this.subscriber.onComplete();
    }

    @Override // android.webkit.WebViewClient
    public void onLoadResource(WebView webView, String str) {
        super.onLoadResource(webView, str);
        PdfLog.d("Nutri.WebViewClientImpl", "Loading resource: %s", str);
    }

    @Override // android.webkit.WebViewClient
    public void onPageFinished(WebView webView, String str) {
        tryOnSuccess();
        PdfLog.d("Nutri.WebViewClientImpl", "Finished loading page: %s", str);
    }

    @Override // android.webkit.WebViewClient
    public void onPageStarted(WebView webView, String str, Bitmap bitmap) {
        super.onPageStarted(webView, str, bitmap);
        PdfLog.d("Nutri.WebViewClientImpl", "Started loading page: %s", str);
    }

    @Override // android.webkit.WebViewClient
    public void onReceivedError(WebView webView, WebResourceRequest webResourceRequest, WebResourceError webResourceError) {
        super.onReceivedError(webView, webResourceRequest, webResourceError);
        handleError(webResourceRequest.getUrl(), webResourceError.getErrorCode(), webResourceError.getDescription(), false);
    }

    @Override // android.webkit.WebViewClient
    public void onReceivedHttpError(WebView webView, WebResourceRequest webResourceRequest, WebResourceResponse webResourceResponse) {
        super.onReceivedHttpError(webView, webResourceRequest, webResourceResponse);
        handleError(webResourceRequest.getUrl(), webResourceResponse.getStatusCode(), webResourceResponse.getReasonPhrase(), true);
    }

    @Override // android.webkit.WebViewClient
    public WebResourceResponse shouldInterceptRequest(WebView webView, WebResourceRequest webResourceRequest) {
        if (this.resourceInterceptor == null || shouldIgnoreUri(webResourceRequest.getUrl())) {
            return super.shouldInterceptRequest(webView, webResourceRequest);
        }
        ResourceResponse resourceResponseShouldInterceptRequest = this.resourceInterceptor.shouldInterceptRequest(new ResourceRequest(webResourceRequest));
        if (resourceResponseShouldInterceptRequest != null) {
            return resourceResponseShouldInterceptRequest.toWebResourceResponse();
        }
        return null;
    }

    @Override // android.webkit.WebViewClient
    public WebResourceResponse shouldInterceptRequest(WebView webView, String str) {
        if (this.resourceInterceptor != null && !shouldIgnoreUri(Uri.parse(str))) {
            ResourceResponse resourceResponseShouldInterceptRequest = this.resourceInterceptor.shouldInterceptRequest(new ResourceRequest(str));
            if (resourceResponseShouldInterceptRequest != null) {
                return resourceResponseShouldInterceptRequest.toWebResourceResponse();
            }
            return null;
        }
        return super.shouldInterceptRequest(webView, str);
    }
}
