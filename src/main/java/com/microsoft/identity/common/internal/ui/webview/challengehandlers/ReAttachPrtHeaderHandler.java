package com.microsoft.identity.common.internal.ui.webview.challengehandlers;

import android.webkit.WebView;
import com.microsoft.identity.common.adal.internal.AuthenticationConstants;
import com.microsoft.identity.common.adal.internal.util.StringExtensions;
import com.microsoft.identity.common.java.broker.CommonRefreshTokenCredentialProvider;
import com.microsoft.identity.common.java.opentelemetry.AttributeName;
import com.microsoft.identity.common.logging.Logger;
import io.opentelemetry.api.trace.Span;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: ReAttachPrtHeaderHandler.kt */
/* JADX INFO: loaded from: classes14.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0004\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B9\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\"\u0010\u0006\u001a\u001e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\u0007j\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0002`\b\u0012\u0006\u0010\t\u001a\u00020\n¢\u0006\u0002\u0010\u000bJ\u000e\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0002J\u0012\u0010\u0011\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u0012\u001a\u00020\u0002H\u0016R\u0016\u0010\f\u001a\n \r*\u0004\u0018\u00010\u00020\u0002X\u0082\u0004¢\u0006\u0002\n\u0000R*\u0010\u0006\u001a\u001e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\u0007j\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0002`\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0013"}, d2 = {"Lcom/microsoft/identity/common/internal/ui/webview/challengehandlers/ReAttachPrtHeaderHandler;", "Lcom/microsoft/identity/common/internal/ui/webview/challengehandlers/IChallengeHandler;", "", "Ljava/lang/Void;", "webView", "Landroid/webkit/WebView;", "headers", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "span", "Lio/opentelemetry/api/trace/Span;", "(Landroid/webkit/WebView;Ljava/util/HashMap;Lio/opentelemetry/api/trace/Span;)V", "TAG", "kotlin.jvm.PlatformType", "modifyHeadersWithRefreshTokenCredential", "", "url", "processChallenge", "inputUrl", "common_distRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class ReAttachPrtHeaderHandler implements IChallengeHandler<String, Void> {
    private final String TAG;
    private final HashMap<String, String> headers;
    private final Span span;
    private final WebView webView;

    public ReAttachPrtHeaderHandler(WebView webView, HashMap<String, String> headers, Span span) {
        Intrinsics.checkNotNullParameter(webView, "webView");
        Intrinsics.checkNotNullParameter(headers, "headers");
        Intrinsics.checkNotNullParameter(span, "span");
        this.webView = webView;
        this.headers = headers;
        this.span = span;
        this.TAG = "ReAttachPrtHeaderHandler";
    }

    @Override // com.microsoft.identity.common.internal.ui.webview.challengehandlers.IChallengeHandler
    public Void processChallenge(String inputUrl) {
        Intrinsics.checkNotNullParameter(inputUrl, "inputUrl");
        Logger.info(this.TAG, "Processing challenge to attach prt header.");
        modifyHeadersWithRefreshTokenCredential(inputUrl);
        this.webView.loadUrl(inputUrl, this.headers);
        return null;
    }

    public final void modifyHeadersWithRefreshTokenCredential(String url) {
        Intrinsics.checkNotNullParameter(url, "url");
        String str = this.TAG + ":modifyHeadersWithRefreshTokenCredential";
        HashMap<String, String> urlParameters = StringExtensions.getUrlParameters(url);
        Intrinsics.checkNotNullExpressionValue(urlParameters, "getUrlParameters(url)");
        String str2 = urlParameters.get("login_hint");
        String str3 = str2;
        if (str3 == null || str3.length() == 0) {
            return;
        }
        String refreshTokenCredential = CommonRefreshTokenCredentialProvider.INSTANCE.getRefreshTokenCredential(url, str2);
        String str4 = refreshTokenCredential;
        if (str4 == null || str4.length() == 0) {
            return;
        }
        Logger.info(str, "Attaching refresh token credential in headers.");
        this.span.setAttribute(AttributeName.is_new_refresh_token_cred_header_attached.name(), true);
        this.headers.put(AuthenticationConstants.Broker.PRT_RESPONSE_HEADER, refreshTokenCredential);
    }
}
