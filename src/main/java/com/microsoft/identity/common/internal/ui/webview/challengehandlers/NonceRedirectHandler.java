package com.microsoft.identity.common.internal.ui.webview.challengehandlers;

import android.webkit.WebView;
import com.microsoft.identity.common.adal.internal.AuthenticationConstants;
import com.microsoft.identity.common.adal.internal.util.StringExtensions;
import com.microsoft.identity.common.java.broker.CommonRefreshTokenCredentialProvider;
import com.microsoft.identity.common.java.opentelemetry.AttributeName;
import com.microsoft.identity.common.logging.Logger;
import io.opentelemetry.api.trace.Span;
import java.net.URL;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: NonceRedirectHandler.kt */
/* JADX INFO: loaded from: classes14.dex */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u0002\n\u0002\b\u0004\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B9\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\"\u0010\u0006\u001a\u001e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\b0\u0007j\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\b`\t\u0012\u0006\u0010\n\u001a\u00020\u000b¢\u0006\u0002\u0010\fJ\u0012\u0010\u000f\u001a\u0004\u0018\u00010\b2\u0006\u0010\u0010\u001a\u00020\u0002H\u0002J.\u0010\u0011\u001a\u0004\u0018\u00010\b2\"\u0010\u0012\u001a\u001e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\b0\u0007j\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\b`\tH\u0002J\u0012\u0010\u0013\u001a\u0004\u0018\u00010\b2\u0006\u0010\u0010\u001a\u00020\bH\u0002J\u0018\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\b2\u0006\u0010\u0010\u001a\u00020\bH\u0002J\u0012\u0010\u0017\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u0018\u001a\u00020\u0002H\u0016R\u0016\u0010\r\u001a\n \u000e*\u0004\u0018\u00010\b0\bX\u0082\u0004¢\u0006\u0002\n\u0000R*\u0010\u0006\u001a\u001e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\b0\u0007j\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\b`\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0019"}, d2 = {"Lcom/microsoft/identity/common/internal/ui/webview/challengehandlers/NonceRedirectHandler;", "Lcom/microsoft/identity/common/internal/ui/webview/challengehandlers/IChallengeHandler;", "Ljava/net/URL;", "Ljava/lang/Void;", "webView", "Landroid/webkit/WebView;", "headers", "Ljava/util/HashMap;", "", "Lkotlin/collections/HashMap;", "span", "Lio/opentelemetry/api/trace/Span;", "(Landroid/webkit/WebView;Ljava/util/HashMap;Lio/opentelemetry/api/trace/Span;)V", "TAG", "kotlin.jvm.PlatformType", "getNonceFromRedirectUrl", "url", "getPrtHeader", "requestHeaders", "getUserNameFromWebViewUrl", "modifyHeadersWithNewRefreshTokenCredential", "", "nonce", "processChallenge", "input", "common_distRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class NonceRedirectHandler implements IChallengeHandler<URL, Void> {
    private final String TAG;
    private final HashMap<String, String> headers;
    private final Span span;
    private final WebView webView;

    public NonceRedirectHandler(WebView webView, HashMap<String, String> headers, Span span) {
        Intrinsics.checkNotNullParameter(webView, "webView");
        Intrinsics.checkNotNullParameter(headers, "headers");
        Intrinsics.checkNotNullParameter(span, "span");
        this.webView = webView;
        this.headers = headers;
        this.span = span;
        this.TAG = "NonceRedirectHandler";
    }

    @Override // com.microsoft.identity.common.internal.ui.webview.challengehandlers.IChallengeHandler
    public Void processChallenge(URL input) {
        Intrinsics.checkNotNullParameter(input, "input");
        String nonceFromRedirectUrl = getNonceFromRedirectUrl(input);
        if (nonceFromRedirectUrl != null) {
            String string = input.toString();
            Intrinsics.checkNotNullExpressionValue(string, "input.toString()");
            modifyHeadersWithNewRefreshTokenCredential(nonceFromRedirectUrl, string);
        }
        this.webView.loadUrl(input.toString(), this.headers);
        return null;
    }

    private final String getNonceFromRedirectUrl(URL url) {
        return StringExtensions.getUrlParameters(url.toString()).get(AuthenticationConstants.Broker.SSO_NONCE_PARAMETER);
    }

    private final String getPrtHeader(HashMap<String, String> requestHeaders) {
        return requestHeaders.get(AuthenticationConstants.Broker.PRT_RESPONSE_HEADER);
    }

    private final void modifyHeadersWithNewRefreshTokenCredential(String nonce, String url) {
        String refreshTokenCredentialUsingNewNonce;
        String str = this.TAG + ":getHeadersWithNewRefreshTokenCredential";
        String prtHeader = getPrtHeader(this.headers);
        if (prtHeader == null || prtHeader.length() == 0) {
            return;
        }
        Logger.info(str, "PRT credential header found in headers!");
        String userNameFromWebViewUrl = getUserNameFromWebViewUrl(url);
        if (userNameFromWebViewUrl == null || (refreshTokenCredentialUsingNewNonce = CommonRefreshTokenCredentialProvider.INSTANCE.getRefreshTokenCredentialUsingNewNonce(url, userNameFromWebViewUrl, nonce)) == null) {
            return;
        }
        this.headers.put(AuthenticationConstants.Broker.PRT_RESPONSE_HEADER, refreshTokenCredentialUsingNewNonce);
        this.span.setAttribute(AttributeName.is_new_refresh_token_cred_header_attached.name(), true);
    }

    private final String getUserNameFromWebViewUrl(String url) {
        HashMap<String, String> urlParameters = StringExtensions.getUrlParameters(url);
        Intrinsics.checkNotNullExpressionValue(urlParameters, "getUrlParameters(url)");
        return urlParameters.get("login_hint");
    }
}
