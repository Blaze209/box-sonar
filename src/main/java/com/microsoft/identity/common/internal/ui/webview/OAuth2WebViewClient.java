package com.microsoft.identity.common.internal.ui.webview;

import android.app.Activity;
import android.graphics.Bitmap;
import android.net.Uri;
import android.net.http.SslError;
import android.webkit.HttpAuthHandler;
import android.webkit.RenderProcessGoneDetail;
import android.webkit.SslErrorHandler;
import android.webkit.WebResourceError;
import android.webkit.WebResourceRequest;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.microsoft.identity.common.internal.broker.AuthUxJavaScriptInterface;
import com.microsoft.identity.common.internal.ui.webview.challengehandlers.ChallengeFactory;
import com.microsoft.identity.common.internal.ui.webview.challengehandlers.NtlmChallengeHandler;
import com.microsoft.identity.common.internal.util.StringUtil;
import com.microsoft.identity.common.java.exception.ClientException;
import com.microsoft.identity.common.java.flighting.CommonFlight;
import com.microsoft.identity.common.java.flighting.CommonFlightsManager;
import com.microsoft.identity.common.java.opentelemetry.AttributeName;
import com.microsoft.identity.common.java.opentelemetry.OTelUtility;
import com.microsoft.identity.common.java.providers.RawAuthorizationResult;
import com.microsoft.identity.common.java.ui.webview.authorization.IAuthorizationCompletionCallback;
import com.microsoft.identity.common.logging.Logger;
import io.opentelemetry.api.common.Attributes;
import io.opentelemetry.api.metrics.LongCounter;

/* JADX INFO: loaded from: classes14.dex */
public abstract class OAuth2WebViewClient extends WebViewClient {
    private static final String TAG = "OAuth2WebViewClient";
    private final Activity mActivity;
    protected boolean mAuthUxJavaScriptInterfaceAdded = false;
    private final IAuthorizationCompletionCallback mCompletionCallback;
    private final OnPageLoadedCallback mPageLoadedCallback;
    private static final LongCounter sWebViewSslErrorCount = OTelUtility.createLongCounter("web_view_ssl_error_count", "Number of SSL errors received in onReceivedSslError");
    public static ExpectedPage mExpectedPage = null;

    public Activity getActivity() {
        return this.mActivity;
    }

    IAuthorizationCompletionCallback getCompletionCallback() {
        return this.mCompletionCallback;
    }

    OAuth2WebViewClient(Activity activity, IAuthorizationCompletionCallback iAuthorizationCompletionCallback, OnPageLoadedCallback onPageLoadedCallback) {
        this.mActivity = activity;
        this.mCompletionCallback = iAuthorizationCompletionCallback;
        this.mPageLoadedCallback = onPageLoadedCallback;
    }

    @Override // android.webkit.WebViewClient
    public void onReceivedHttpAuthRequest(WebView webView, HttpAuthHandler httpAuthHandler, String str, String str2) {
        String str3 = TAG + ":onReceivedHttpAuthRequest";
        Logger.info(str3, "Receive the http auth request. Start the dialog to ask for creds. ");
        Logger.infoPII(str3, "Host:" + str);
        new NtlmChallengeHandler(this.mActivity, this.mCompletionCallback).processChallenge(ChallengeFactory.getNtlmChallenge(webView, httpAuthHandler, str, str2));
    }

    @Override // android.webkit.WebViewClient
    public void onReceivedError(WebView webView, int i, String str, String str2) {
        sendErrorToCallback(webView, i, str);
    }

    @Override // android.webkit.WebViewClient
    public void onReceivedError(WebView webView, WebResourceRequest webResourceRequest, WebResourceError webResourceError) {
        String str = TAG + ":onReceivedError";
        Logger.warn(str, "WebResourceError - isForMainFrame? " + webResourceRequest.isForMainFrame());
        Logger.warnPII(str, "Failing url: " + webResourceRequest.getUrl());
        if (webResourceRequest.isForMainFrame()) {
            sendErrorToCallback(webView, webResourceError.getErrorCode(), webResourceError.getDescription().toString());
        }
    }

    private void sendErrorToCallback(WebView webView, int i, String str) {
        webView.stopLoading();
        this.mCompletionCallback.onChallengeResponseReceived(RawAuthorizationResult.fromException(new ClientException("Code:" + i, str)));
    }

    @Override // android.webkit.WebViewClient
    public void onReceivedSslError(WebView webView, SslErrorHandler sslErrorHandler, SslError sslError) {
        String str = TAG + ":onReceivedSslError";
        super.onReceivedSslError(webView, sslErrorHandler, sslError);
        Logger.warn(str, "Received SSL Error during request. For more info see: https://go.microsoft.com/fwlink/?linkid=2138180. Error: " + sslError.toString());
        sWebViewSslErrorCount.add(1L, Attributes.builder().put(AttributeName.web_view_ssl_primary_error_code.name(), sslError.getPrimaryError()).build());
        if (CommonFlightsManager.INSTANCE.getFlightsProvider().isFlightEnabled(CommonFlight.SHOULD_PRESERVE_WEBVIEW_FLOW_ON_SSL_ERROR)) {
            return;
        }
        this.mCompletionCallback.onChallengeResponseReceived(RawAuthorizationResult.fromException(new ClientException("Code:-11", sslError.toString())));
    }

    @Override // android.webkit.WebViewClient
    public void onPageFinished(WebView webView, String str) {
        super.onPageFinished(webView, str);
        this.mPageLoadedCallback.onPageLoaded(str);
        ExpectedPage expectedPage = mExpectedPage;
        if (expectedPage != null && str.startsWith(expectedPage.mExpectedPageUrlStartsWith)) {
            mExpectedPage.mCallback.onPageLoaded(str);
        }
        webView.setVisibility(0);
    }

    @Override // android.webkit.WebViewClient
    public boolean onRenderProcessGone(WebView webView, RenderProcessGoneDetail renderProcessGoneDetail) {
        sendErrorToCallback(webView, -1, "WebView render process gone, crashed? : " + renderProcessGoneDetail.didCrash());
        return true;
    }

    @Override // android.webkit.WebViewClient
    public void onPageStarted(WebView webView, String str, Bitmap bitmap) {
        String str2 = TAG + ":onPageStarted";
        checkStartUrl(str);
        if (shouldExposeJavaScriptInterface(str)) {
            Logger.info(str2, "Adding AuthUx JavaScript Interface");
            webView.addJavascriptInterface(new AuthUxJavaScriptInterface(), AuthUxJavaScriptInterface.INSTANCE.getInterfaceName());
            this.mAuthUxJavaScriptInterfaceAdded = true;
        } else if (this.mAuthUxJavaScriptInterfaceAdded) {
            Logger.info(str2, "Removing AuthUx JavaScript Interface");
            webView.removeJavascriptInterface(AuthUxJavaScriptInterface.INSTANCE.getInterfaceName());
            this.mAuthUxJavaScriptInterfaceAdded = false;
        }
        Logger.info(str2, "WebView starts loading.");
        super.onPageStarted(webView, str, bitmap);
    }

    private void checkStartUrl(String str) {
        String str2 = TAG + ":checkStartUrl";
        if (StringUtil.isEmpty(str)) {
            Logger.info(str2, "onPageStarted: Null url for page to load.");
            return;
        }
        Uri uri = Uri.parse(str);
        if (uri.isOpaque()) {
            Logger.info(str2, "onPageStarted: Non-hierarchical loading uri.");
            Logger.infoPII(str2, "start url: " + str);
        } else if (StringUtil.isEmpty(uri.getQueryParameter("code"))) {
            Logger.info(str2, "onPageStarted: URI has no auth code ('code') query parameter.");
            Logger.infoPII(str2, "Scheme:" + uri.getScheme() + " Host: " + uri.getHost() + " Path: " + uri.getPath());
        } else {
            Logger.info(str2, "Auth code is returned for the loading url.");
            Logger.infoPII(str2, "Scheme:" + uri.getScheme() + " Host: " + uri.getHost() + " Path: " + uri.getPath());
        }
    }

    protected boolean shouldExposeJavaScriptInterface(String str) {
        return ProcessUtil.isRunningOnAuthService(getActivity().getApplicationContext()) && AuthUxJavaScriptInterface.INSTANCE.isValidUriForInterface(str) && CommonFlightsManager.INSTANCE.getFlightsProvider().isFlightEnabled(CommonFlight.ENABLE_JS_API_FOR_AUTHUX);
    }
}
