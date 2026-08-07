package com.microsoft.identity.common.internal.ui.webview.challengehandlers;

import android.webkit.WebView;
import com.microsoft.identity.common.java.challengehandlers.PKeyAuthChallenge;
import com.microsoft.identity.common.java.providers.RawAuthorizationResult;
import com.microsoft.identity.common.java.ui.webview.authorization.IAuthorizationCompletionCallback;
import com.microsoft.identity.common.logging.Logger;
import java.util.Map;

/* JADX INFO: loaded from: classes14.dex */
public final class PKeyAuthChallengeHandler implements IChallengeHandler<PKeyAuthChallenge, Void> {
    private static final String TAG = "PKeyAuthChallengeHandler";
    private final IAuthorizationCompletionCallback mChallengeCallback;
    private final WebView mWebView;

    public PKeyAuthChallengeHandler(WebView webView, IAuthorizationCompletionCallback iAuthorizationCompletionCallback) {
        this.mWebView = webView;
        this.mChallengeCallback = iAuthorizationCompletionCallback;
    }

    @Override // com.microsoft.identity.common.internal.ui.webview.challengehandlers.IChallengeHandler
    public Void processChallenge(final PKeyAuthChallenge pKeyAuthChallenge) {
        final String str = TAG + ":processChallenge";
        this.mWebView.stopLoading();
        this.mChallengeCallback.setPKeyAuthStatus(true);
        try {
            final Map<String, String> challengeHeader = pKeyAuthChallenge.getChallengeHeader();
            this.mWebView.post(new Runnable() { // from class: com.microsoft.identity.common.internal.ui.webview.challengehandlers.PKeyAuthChallengeHandler.1
                @Override // java.lang.Runnable
                public void run() {
                    String submitUrl = pKeyAuthChallenge.getSubmitUrl();
                    Logger.info(str, "Respond to pkeyAuth challenge");
                    Logger.infoPII(str, "Challenge submit url:" + pKeyAuthChallenge.getSubmitUrl());
                    PKeyAuthChallengeHandler.this.mWebView.loadUrl(submitUrl, challengeHeader);
                }
            });
            return null;
        } catch (Throwable th) {
            this.mChallengeCallback.onChallengeResponseReceived(RawAuthorizationResult.fromThrowable(th));
            if (th instanceof InterruptedException) {
                Thread.currentThread().interrupt();
            }
            if (th instanceof Error) {
                throw th;
            }
            return null;
        }
    }
}
