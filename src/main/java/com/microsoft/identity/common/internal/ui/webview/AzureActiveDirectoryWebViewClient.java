package com.microsoft.identity.common.internal.ui.webview;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.ComponentName;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Build;
import android.os.Handler;
import android.webkit.ClientCertRequest;
import android.webkit.WebResourceRequest;
import android.webkit.WebView;
import androidx.lifecycle.ViewTreeLifecycleOwner;
import com.microsoft.identity.common.adal.internal.AuthenticationConstants;
import com.microsoft.identity.common.adal.internal.util.StringExtensions;
import com.microsoft.identity.common.internal.broker.AuthUxJavaScriptInterface;
import com.microsoft.identity.common.internal.broker.BrokerData;
import com.microsoft.identity.common.internal.broker.PackageHelper;
import com.microsoft.identity.common.internal.fido.AuthFidoChallengeHandler;
import com.microsoft.identity.common.internal.fido.CredManFidoManager;
import com.microsoft.identity.common.internal.fido.FidoChallenge;
import com.microsoft.identity.common.internal.fido.LegacyFido2ApiManager;
import com.microsoft.identity.common.internal.providers.oauth2.AuthorizationActivity;
import com.microsoft.identity.common.internal.providers.oauth2.WebViewAuthorizationFragment;
import com.microsoft.identity.common.internal.ui.webview.certbasedauth.AbstractCertBasedAuthChallengeHandler;
import com.microsoft.identity.common.internal.ui.webview.certbasedauth.AbstractSmartcardCertBasedAuthChallengeHandler;
import com.microsoft.identity.common.internal.ui.webview.certbasedauth.CertBasedAuthFactory;
import com.microsoft.identity.common.internal.ui.webview.challengehandlers.NonceRedirectHandler;
import com.microsoft.identity.common.internal.ui.webview.challengehandlers.PKeyAuthChallengeHandler;
import com.microsoft.identity.common.internal.ui.webview.challengehandlers.ReAttachPrtHeaderHandler;
import com.microsoft.identity.common.internal.ui.webview.challengehandlers.SwitchBrowserChallenge;
import com.microsoft.identity.common.internal.ui.webview.challengehandlers.SwitchBrowserRequestHandler;
import com.microsoft.identity.common.java.authorities.Authority;
import com.microsoft.identity.common.java.broker.CommonTenantInfoProvider;
import com.microsoft.identity.common.java.challengehandlers.PKeyAuthChallengeFactory;
import com.microsoft.identity.common.java.constants.FidoConstants;
import com.microsoft.identity.common.java.exception.ClientException;
import com.microsoft.identity.common.java.exception.ErrorStrings;
import com.microsoft.identity.common.java.exception.IErrorInformation;
import com.microsoft.identity.common.java.flighting.CommonFlight;
import com.microsoft.identity.common.java.flighting.CommonFlightsManager;
import com.microsoft.identity.common.java.opentelemetry.AttributeName;
import com.microsoft.identity.common.java.opentelemetry.BaggageExtension;
import com.microsoft.identity.common.java.opentelemetry.OTelUtility;
import com.microsoft.identity.common.java.opentelemetry.SpanExtension;
import com.microsoft.identity.common.java.opentelemetry.SpanName;
import com.microsoft.identity.common.java.providers.RawAuthorizationResult;
import com.microsoft.identity.common.java.providers.microsoft.azureactivedirectory.AzureActiveDirectory;
import com.microsoft.identity.common.java.ui.webview.authorization.IAuthorizationCompletionCallback;
import com.microsoft.identity.common.java.util.StringUtil;
import com.microsoft.identity.common.logging.Logger;
import io.opentelemetry.api.baggage.Baggage;
import io.opentelemetry.api.trace.Span;
import io.opentelemetry.api.trace.SpanContext;
import io.opentelemetry.api.trace.StatusCode;
import io.opentelemetry.context.Context;
import io.opentelemetry.context.Scope;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.security.Principal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Set;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes14.dex */
public class AzureActiveDirectoryWebViewClient extends OAuth2WebViewClient {
    private static final String DEVICE_CERT_ISSUER = "CN=MS-Organization-Access";
    public static final String ERROR = "error";
    public static final String ERROR_DESCRIPTION = "error_description";
    private static final String TAG = "AzureActiveDirectoryWebViewClient";
    private static final int THREAD_SLEEP_FOR_INTENT_LAUNCH_MS = 3;
    private boolean mAuthUxJavaScriptInterfaceAdded;
    private AbstractCertBasedAuthChallengeHandler mCertBasedAuthChallengeHandler;
    private final CertBasedAuthFactory mCertBasedAuthFactory;
    private boolean mInWebCpFlow;
    private final boolean mIsWebViewWebCpEnabledInBrokerlessCase;
    private final List<JsScriptRecord> mOnPageStartedScripts;
    private final String mRedirectUrl;
    private HashMap<String, String> mRequestHeaders;
    private String mRequestUrl;
    private final SpanContext mSpanContext;
    private final SwitchBrowserRequestHandler mSwitchBrowserRequestHandler;
    private final String mUtid;

    public AzureActiveDirectoryWebViewClient(Activity activity, IAuthorizationCompletionCallback iAuthorizationCompletionCallback, OnPageLoadedCallback onPageLoadedCallback, String str, SwitchBrowserRequestHandler switchBrowserRequestHandler, String str2, boolean z) {
        super(activity, iAuthorizationCompletionCallback, onPageLoadedCallback);
        this.mInWebCpFlow = false;
        this.mAuthUxJavaScriptInterfaceAdded = false;
        this.mOnPageStartedScripts = new ArrayList();
        this.mRedirectUrl = str;
        this.mCertBasedAuthFactory = new CertBasedAuthFactory(activity);
        this.mSwitchBrowserRequestHandler = switchBrowserRequestHandler;
        this.mUtid = str2;
        this.mSpanContext = activity instanceof AuthorizationActivity ? ((AuthorizationActivity) getActivity()).getSpanContext() : null;
        this.mIsWebViewWebCpEnabledInBrokerlessCase = z;
    }

    public void initializeAuthUxJavaScriptApi(WebView webView, String str) {
        if (shouldExposeJavaScriptInterface(str)) {
            Logger.info(TAG, "Adding AuthUx JavaScript Interface");
            webView.addJavascriptInterface(new AuthUxJavaScriptInterface(), AuthUxJavaScriptInterface.INSTANCE.getInterfaceName());
            this.mAuthUxJavaScriptInterfaceAdded = true;
        }
    }

    @Override // com.microsoft.identity.common.internal.ui.webview.OAuth2WebViewClient, android.webkit.WebViewClient
    public void onPageFinished(WebView webView, String str) {
        super.onPageFinished(webView, str);
        if (this.mAuthUxJavaScriptInterfaceAdded) {
            webView.evaluateJavascript("window." + AuthUxJavaScriptInterface.INSTANCE.getInterfaceName() + ".postMessageToBroker = function(message) {     window." + AuthUxJavaScriptInterface.INSTANCE.getInterfaceName() + ".receiveAuthUxMessage(JSON.stringify(message)); };", null);
        }
    }

    @Override // android.webkit.WebViewClient
    public boolean shouldOverrideUrlLoading(WebView webView, String str) {
        if (StringUtil.isNullOrEmpty(str)) {
            throw new IllegalArgumentException("Redirect to empty url in web view.");
        }
        return handleUrl(webView, str);
    }

    @Override // android.webkit.WebViewClient
    public boolean shouldOverrideUrlLoading(WebView webView, WebResourceRequest webResourceRequest) {
        return handleUrl(webView, webResourceRequest.getUrl().toString());
    }

    public void setRequestHeaders(HashMap<String, String> map) {
        this.mRequestHeaders = map;
    }

    public void setRequestUrl(String str) {
        this.mRequestUrl = str;
    }

    private boolean handleUrl(WebView webView, String str) {
        String str2 = TAG + ":handleUrl";
        String lowerCase = str.toLowerCase(Locale.US);
        try {
            if (isPkeyAuthUrl(lowerCase)) {
                Logger.info(str2, "WebView detected request for pkeyauth challenge.");
                new PKeyAuthChallengeHandler(webView, getCompletionCallback()).processChallenge(new PKeyAuthChallengeFactory().getPKeyAuthChallengeFromWebViewRedirect(str));
                return true;
            }
            if (isPasskeyUrl(lowerCase)) {
                Logger.info(str2, "WebView detected request for passkey protocol.");
                FidoChallenge fidoChallengeCreateFromRedirectUri = FidoChallenge.createFromRedirectUri(str);
                Activity activity = getActivity();
                new AuthFidoChallengeHandler(new CredManFidoManager(webView.getContext(), ((activity instanceof AuthorizationActivity) && (((AuthorizationActivity) activity).getFragment() instanceof WebViewAuthorizationFragment) && CommonFlightsManager.INSTANCE.getFlightsProvider().isFlightEnabled(CommonFlight.ENABLE_LEGACY_FIDO_SECURITY_KEY_LOGIC) && Build.VERSION.SDK_INT < 34) ? new LegacyFido2ApiManager(webView.getContext(), (WebViewAuthorizationFragment) ((AuthorizationActivity) activity).getFragment()) : null), webView, activity instanceof AuthorizationActivity ? ((AuthorizationActivity) activity).getOtelContext() : null, ViewTreeLifecycleOwner.get(webView)).processChallenge(fidoChallengeCreateFromRedirectUri);
                return true;
            }
            if (CommonFlightsManager.INSTANCE.getFlightsProvider().isFlightEnabled(CommonFlight.ENABLE_ATTACH_NEW_PRT_HEADER_WHEN_NONCE_EXPIRED) && isNonceRedirect(lowerCase)) {
                Logger.info(str2, "Navigation contains new nonce within the redirect uri.");
                processNonceAndReAttachHeaders(webView, str);
                return true;
            }
            if (isRedirectUrl(lowerCase)) {
                Logger.info(str2, "Navigation starts with the redirect uri.");
                if (this.mSwitchBrowserRequestHandler.isSwitchBrowserRequest(lowerCase, this.mRedirectUrl)) {
                    Logger.info(str2, "Request to switch browser.");
                    processSwitchBrowserRequest(str);
                    return true;
                }
                Logger.info(str2, "It is a redirect request.");
                processRedirectUrl(webView, str);
                return true;
            }
            if (isWebsiteRequestUrl(lowerCase)) {
                Logger.info(str2, "It is an external website request");
                processWebsiteRequest(webView, str);
                return true;
            }
            if (isInstallRequestUrl(lowerCase)) {
                Logger.info(str2, "It is an install request");
                processInstallRequest(webView, str);
                return true;
            }
            if (isWebCpUrl(lowerCase)) {
                Logger.info(str2, "It is a request from WebCP");
                processWebCpRequest(webView, str);
                return true;
            }
            if (isPlayStoreUrl(lowerCase)) {
                Logger.info(str2, "Request to open PlayStore.");
                return processPlayStoreURL(webView, str);
            }
            if (CommonFlightsManager.INSTANCE.getFlightsProvider().isFlightEnabled(CommonFlight.ENABLE_PLAYSTORE_URL_LAUNCH) && isPlaystoreUrlToInstallBrokerApp(lowerCase)) {
                Logger.info(str2, "Request to open PlayStore for broker app install.");
                return processPlayStoreURLForBrokerApps(webView, str);
            }
            if (isAuthAppMFAUrl(lowerCase)) {
                Logger.info(str2, "Request to link account with Authenticator.");
                processAuthAppMFAUrl(str);
                return true;
            }
            if (isAmazonAppRedirect(lowerCase)) {
                Logger.info(str2, "It is an Amazon app request");
                processAmazonAppUri(str);
                return true;
            }
            if (isInvalidRedirectUri(str)) {
                Logger.info(str2, "Check for Redirect Uri.");
                processInvalidRedirectUri(webView, str);
                return true;
            }
            if (isBlankPageRequest(lowerCase)) {
                Logger.info(str2, "It is an blank page request");
                return true;
            }
            if (isIntentRequestToInstallBrokerApp(lowerCase)) {
                Logger.info(str2, "It is an intent request");
                processIntentToInstallBrokerApp(webView, str);
                return true;
            }
            if (!isUriSSLProtected(lowerCase)) {
                Logger.info(str2, "Check for SSL protection");
                processSSLProtectionCheck(webView, str);
                return true;
            }
            if (isHeaderForwardingRequiredUri(str)) {
                processHeaderForwardingRequiredUri(webView, str);
                return true;
            }
            if (CommonFlightsManager.INSTANCE.getFlightsProvider().isFlightEnabled(CommonFlight.ENABLE_ATTACH_PRT_HEADER_WHEN_CROSS_CLOUD) && isCrossCloudRedirect(lowerCase)) {
                Logger.info(str2, "Navigation contains cross cloud redirect.");
                processCrossCloudRedirect(webView, str);
                return true;
            }
            if (this.mInWebCpFlow && isWebCpEnrollmentUrl(str)) {
                Logger.info(str2, "Navigation contains web cp enrollment url.");
                processWebCpEnrollmentUrl(webView, str);
                return true;
            }
            if (this.mInWebCpFlow && isWebCpAuthorizeUrl(str)) {
                processWebCpAuthorize(webView, str);
                return true;
            }
            if (isDeviceCaRequest(str) && isHttpsScheme(str) && isWebCpInWebviewFeatureEnabled(str)) {
                Logger.info(str2, "Navigation contains device CA request with https scheme.");
                processDeviceCaRequest(webView, str);
                return true;
            }
            Logger.info(str2, "This maybe a valid URI, but no special handling for this mentioned URI, hence deferring to WebView for loading.");
            processInvalidUrl(str);
            return false;
        } catch (ClientException e) {
            Logger.error(str2, e.getErrorCode(), null);
            Logger.errorPII(str2, e.getMessage(), e);
            returnError(e.getErrorCode(), e.getMessage());
            webView.stopLoading();
            return true;
        }
    }

    private boolean isUriSSLProtected(String str) {
        return str.startsWith(AuthenticationConstants.Broker.REDIRECT_SSL_PREFIX);
    }

    private boolean isBlankPageRequest(String str) {
        return "about:blank".equals(str);
    }

    private boolean isInvalidRedirectUri(String str) {
        return isBrokerRequest(getActivity().getIntent()) && str.startsWith("msauth");
    }

    private boolean isAuthAppMFAUrl(String str) {
        return str.startsWith(AuthenticationConstants.Broker.AUTHENTICATOR_MFA_LINKING_PREFIX);
    }

    private boolean isPlayStoreUrl(String str) {
        return str.startsWith("market://details?id=");
    }

    private boolean isPlaystoreUrlToInstallBrokerApp(String str) {
        if (!str.startsWith(AuthenticationConstants.Broker.PLAY_STORE_INSTALL_APP_PREFIX)) {
            return false;
        }
        Iterator<BrokerData> it = BrokerData.getAllBrokers().iterator();
        while (it.hasNext()) {
            if (str.contains("id=" + it.next().getPackageName())) {
                return true;
            }
        }
        return false;
    }

    private boolean isPkeyAuthUrl(String str) {
        return str.startsWith(AuthenticationConstants.Broker.PKEYAUTH_REDIRECT.toLowerCase(Locale.ROOT));
    }

    private boolean isPasskeyUrl(String str) {
        return str.startsWith(FidoConstants.PASSKEY_PROTOCOL_REDIRECT.toLowerCase(Locale.ROOT));
    }

    private boolean isRedirectUrl(String str) {
        return str.startsWith(this.mRedirectUrl.toLowerCase(Locale.US));
    }

    private boolean isNonceRedirect(String str) {
        return str.contains(AuthenticationConstants.Broker.SSO_NONCE_PARAMETER);
    }

    private boolean isIntentRequestToInstallBrokerApp(String str) {
        if (!str.startsWith(AuthenticationConstants.Broker.INTENT_PREFIX) || !str.contains(";package=com.android.vending;")) {
            return false;
        }
        Iterator<BrokerData> it = BrokerData.getAllBrokers().iterator();
        while (it.hasNext()) {
            if (str.contains("id=" + it.next().getPackageName())) {
                return true;
            }
        }
        return false;
    }

    private boolean isCrossCloudRedirect(String str) {
        try {
            URL url = new URL(str);
            URL url2 = new URL(this.mRequestUrl);
            if (!AzureActiveDirectory.isValidCloudHost(url) || !AzureActiveDirectory.isValidCloudHost(url2)) {
                return false;
            }
            if (Authority.getAuthorityFromAuthorityUrl(this.mRequestUrl).getAuthorityURL().getHost().equalsIgnoreCase(Authority.getAuthorityFromAuthorityUrl(str).getAuthorityURL().getHost())) {
                return false;
            }
            Logger.info(TAG, "Detected a cross cloud redirect.");
            return true;
        } catch (Throwable th) {
            Logger.warn(TAG, "Failure in detecting if it is a cross cloud redirect url." + th);
            return false;
        }
    }

    private boolean isWebsiteRequestUrl(String str) {
        return str.startsWith(AuthenticationConstants.Broker.BROWSER_EXT_PREFIX);
    }

    private boolean isInstallRequestUrl(String str) {
        return str.startsWith(AuthenticationConstants.Broker.BROWSER_EXT_INSTALL_PREFIX);
    }

    private boolean isBrokerRequest(Intent intent) {
        return (intent == null || StringExtensions.isNullOrBlank(intent.getStringExtra(AuthenticationConstants.Broker.BROKER_REQUEST))) ? false : true;
    }

    private boolean isWebCpUrl(String str) {
        return str.startsWith(AuthenticationConstants.Broker.BROWSER_EXT_WEB_CP);
    }

    private boolean isAmazonAppRedirect(String str) {
        return str.startsWith(AuthenticationConstants.Broker.AMAZON_APP_REDIRECT_PREFIX);
    }

    private boolean isWebCpEnrollmentUrl(String str) {
        return str.startsWith(AuthenticationConstants.Broker.WEBCP_ENROLLMENT_URL);
    }

    private boolean isWebCpAuthorizeUrl(String str) {
        String str2;
        String str3 = TAG + ":isWebCpAuthorizeUrl";
        try {
            URI uri = new URI(str);
            String host = uri.getHost();
            String path = uri.getPath();
            if (host != null && path != null) {
                if (!AzureActiveDirectory.isValidCloudHost(new URL(str))) {
                    Logger.info(str3, "URL host is not a valid Azure cloud host");
                    return false;
                }
                if (!path.contains("/authorize")) {
                    Logger.info(str3, "URL path does not contain /authorize");
                    return false;
                }
                String str4 = StringExtensions.getUrlParameters(str).get("client_id");
                if (StringUtil.isNullOrEmpty(str4)) {
                    Logger.info(str3, "Authorize URL does not contain client_id");
                    return false;
                }
                boolean zEqualsIgnoreCase = AuthenticationConstants.Broker.WEBCP_CLIENT_ID.equalsIgnoreCase(str4);
                if (zEqualsIgnoreCase) {
                    str2 = "WebCP authorize URL contains valid WebCP client_id.";
                } else {
                    str2 = "Not running WebCP flow as client_id in authorize is not webcp client_id";
                }
                Logger.info(str3, str2);
                return zEqualsIgnoreCase;
            }
            Logger.verbose(str3, "URL missing host or path");
            return false;
        } catch (MalformedURLException | URISyntaxException e) {
            Logger.info(str3, "Invalid URL: " + e.getMessage());
            return false;
        }
    }

    private boolean isHeaderForwardingRequiredUri(String str) {
        boolean zStartsWith = str.startsWith("https://login.live.com/");
        HashMap<String, String> map = this.mRequestHeaders;
        return zStartsWith && (map != null && !map.isEmpty());
    }

    private void processRedirectUrl(WebView webView, String str) {
        Logger.info(TAG + ":processRedirectUrl", "It is pointing to redirect. Final url can be processed to get the code or error.");
        getCompletionCallback().onChallengeResponseReceived(RawAuthorizationResult.fromRedirectUri(str));
        webView.stopLoading();
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void processSwitchBrowserRequest(String str) {
        String errorCode;
        String str2 = TAG + ":processSwitchBrowserRequest";
        try {
            this.mSwitchBrowserRequestHandler.processChallenge2(SwitchBrowserChallenge.constructFromRedirectUrl(str, this.mRequestUrl));
        } catch (Throwable th) {
            Logger.error(str2, "Switch browser challenge could not be processed.", th);
            if (th instanceof IErrorInformation) {
                errorCode = ((IErrorInformation) th).getErrorCode();
            } else {
                errorCode = "unknown_error";
            }
            returnError(errorCode, th.getMessage());
        }
    }

    protected void processWebsiteRequest(WebView webView, String str) {
        String str2 = TAG + ":processWebsiteRequest";
        webView.stopLoading();
        Span spanCreateSpanWithAttributesFromParent = createSpanWithAttributesFromParent(SpanName.ProcessWebsiteRequest.name());
        spanCreateSpanWithAttributesFromParent.setAttribute(AttributeName.is_in_web_cp_flow.name(), this.mInWebCpFlow);
        try {
            Scope scopeMakeCurrentSpan = SpanExtension.makeCurrentSpan(spanCreateSpanWithAttributesFromParent);
            try {
                if (isDeviceCaRequest(str)) {
                    processDeviceCaRequest(webView, str);
                    spanCreateSpanWithAttributesFromParent.setStatus(StatusCode.OK);
                    if (scopeMakeCurrentSpan != null) {
                        scopeMakeCurrentSpan.close();
                    }
                    spanCreateSpanWithAttributesFromParent.end();
                    return;
                }
                if (isRedirectToPlaystoreToInstallCp(str) && this.mInWebCpFlow) {
                    handlePlaystoreLaunchUrlFromWebCp(str);
                    spanCreateSpanWithAttributesFromParent.setStatus(StatusCode.OK);
                    if (scopeMakeCurrentSpan != null) {
                        scopeMakeCurrentSpan.close();
                    }
                    spanCreateSpanWithAttributesFromParent.end();
                    return;
                }
                handleBrowserRedirect(str2, str);
                spanCreateSpanWithAttributesFromParent.setStatus(StatusCode.OK);
                if (scopeMakeCurrentSpan != null) {
                    scopeMakeCurrentSpan.close();
                }
                spanCreateSpanWithAttributesFromParent.end();
            } catch (Throwable th) {
                if (scopeMakeCurrentSpan != null) {
                    try {
                        scopeMakeCurrentSpan.close();
                    } catch (Throwable th2) {
                        th.addSuppressed(th2);
                    }
                }
                throw th;
            }
        } catch (Throwable th3) {
            try {
                Logger.error(str2, "Failed to open link in browser.", th3);
                spanCreateSpanWithAttributesFromParent.recordException(th3);
                spanCreateSpanWithAttributesFromParent.setStatus(StatusCode.ERROR);
                returnError(ErrorStrings.UNEXPECTED_ERROR, "No browser found to open the link.");
            } finally {
                spanCreateSpanWithAttributesFromParent.end();
            }
        }
    }

    private void handleBrowserRedirect(String str, String str2) {
        RawAuthorizationResult.ResultCode resultCode;
        Logger.info(str, "Not a device CA request. Redirecting to browser.");
        openLinkInBrowser(str2);
        if (this.mInWebCpFlow) {
            resultCode = RawAuthorizationResult.ResultCode.MDM_FLOW;
        } else {
            resultCode = RawAuthorizationResult.ResultCode.CANCELLED;
        }
        Logger.info(str, "Returning result code: " + resultCode);
        returnResult(resultCode);
    }

    private void handlePlaystoreLaunchUrlFromWebCp(String str) {
        Logger.info(TAG + ":handlePlaystoreLaunchUrlFromWebCp", "Handling playstore launch URL from WebCP.");
        SpanExtension.current().setAttribute(AttributeName.is_redirect_to_playstore_launch_from_webcp.name(), true);
        openLinkInBrowser(str);
        returnResult(RawAuthorizationResult.ResultCode.MDM_FLOW);
    }

    private boolean isRedirectToPlaystoreToInstallCp(String str) {
        if (!str.contains("https://play.google.com/store/apps/details?id=com.microsoft.windowsintune.companyportal")) {
            return false;
        }
        Logger.info(TAG, "Redirect to Playstore to install Company Portal app.");
        return true;
    }

    private void processDeviceCaRequest(WebView webView, String str) {
        String str2 = TAG + ":processDeviceCaRequest";
        Logger.info(str2, "This is a device CA request.");
        if (shouldLaunchCompanyPortal()) {
            try {
                launchCompanyPortal();
                return;
            } catch (Exception unused) {
                Logger.warn(str2, "Failed to launch Company Portal, falling back to browser.");
            }
        }
        loadDeviceCaUrl(str, webView);
    }

    private boolean isDeviceCaRequest(String str) {
        return str.contains(AuthenticationConstants.Broker.BROWSER_DEVICE_CA_URL_QUERY_STRING_PARAMETER);
    }

    private boolean isHttpsScheme(String str) {
        return str.startsWith("https");
    }

    private boolean shouldLaunchCompanyPortal() {
        PackageHelper packageHelper = new PackageHelper(getActivity().getPackageManager());
        return packageHelper.isPackageInstalledAndEnabled(AuthenticationConstants.Broker.IPPHONE_APP_PACKAGE_NAME) && AuthenticationConstants.Broker.IPPHONE_APP_SHA512_RELEASE_SIGNATURE.equals(packageHelper.getSha512SignatureForPackage(AuthenticationConstants.Broker.IPPHONE_APP_PACKAGE_NAME)) && packageHelper.isPackageInstalledAndEnabled("com.microsoft.windowsintune.companyportal");
    }

    protected void loadDeviceCaUrl(String str, WebView webView) {
        String str2 = TAG + ":loadDeviceCaUrl";
        Span spanCreateSpanWithAttributesFromParent = createSpanWithAttributesFromParent(SpanName.ProcessWebCpRedirects.name());
        try {
            Scope scopeMakeCurrentSpan = SpanExtension.makeCurrentSpan(spanCreateSpanWithAttributesFromParent);
            try {
                if (isWebCpInWebviewFeatureEnabled(str)) {
                    Logger.info(str2, "Loading device CA request in WebView.");
                    spanCreateSpanWithAttributesFromParent.setAttribute(AttributeName.is_webcp_in_webview_enabled.name(), true);
                    webView.loadUrl(str.replace(AuthenticationConstants.Broker.BROWSER_EXT_PREFIX, AuthenticationConstants.Broker.REDIRECT_SSL_PREFIX), this.mRequestHeaders);
                } else {
                    Logger.info(str2, "Loading device CA request in browser.");
                    spanCreateSpanWithAttributesFromParent.setAttribute(AttributeName.is_webcp_in_webview_enabled.name(), false);
                    openLinkInBrowser(str);
                    returnResult(RawAuthorizationResult.ResultCode.MDM_FLOW);
                }
                spanCreateSpanWithAttributesFromParent.setStatus(StatusCode.OK);
                if (scopeMakeCurrentSpan != null) {
                    scopeMakeCurrentSpan.close();
                }
                spanCreateSpanWithAttributesFromParent.end();
            } catch (Throwable th) {
                if (scopeMakeCurrentSpan != null) {
                    try {
                        scopeMakeCurrentSpan.close();
                    } catch (Throwable th2) {
                        th.addSuppressed(th2);
                    }
                }
                throw th;
            }
        } catch (Throwable th3) {
            try {
                Logger.error(str2, "Failed to load device CA URL in WebView.", th3);
                spanCreateSpanWithAttributesFromParent.recordException(th3);
                spanCreateSpanWithAttributesFromParent.setStatus(StatusCode.ERROR);
                returnError("unknown_error", th3.getMessage());
            } finally {
                spanCreateSpanWithAttributesFromParent.end();
            }
        }
    }

    protected boolean isWebCpInWebviewFeatureEnabled(String str) {
        String str2 = TAG + ":isWebCpInWebviewFeatureEnabled";
        try {
            if (!ProcessUtil.isRunningOnAuthService(getActivity().getApplicationContext())) {
                this.mInWebCpFlow = this.mIsWebViewWebCpEnabledInBrokerlessCase;
                Logger.info(str2, "Not running on AuthService, WebCP in WebView feature enabled? " + this.mIsWebViewWebCpEnabledInBrokerlessCase);
                return this.mInWebCpFlow;
            }
            String homeTenantIdFromUrl = !StringUtil.isNullOrEmpty(this.mUtid) ? this.mUtid : getHomeTenantIdFromUrl(str);
            if (StringUtil.isNullOrEmpty(homeTenantIdFromUrl)) {
                Logger.info(str2, "Home tenantId is empty");
                return false;
            }
            long jCurrentTimeMillis = System.currentTimeMillis();
            boolean zIsFlightEnabled = CommonFlightsManager.INSTANCE.getFlightsProviderForTenant(homeTenantIdFromUrl, CommonFlightsManager.INSTANCE.getFlightsProvider().getIntValue(CommonFlight.WEB_CP_WAIT_TIMEOUT_FOR_FLIGHTS)).isFlightEnabled(CommonFlight.ENABLE_WEB_CP_IN_WEBVIEW);
            SpanExtension.current().setAttribute(AttributeName.web_cp_flight_get_time.name(), System.currentTimeMillis() - jCurrentTimeMillis);
            SpanExtension.current().setAttribute(AttributeName.tenant_id.name(), homeTenantIdFromUrl);
            if (!zIsFlightEnabled) {
                return false;
            }
            Logger.info(str2, "WebCP in WebView feature is enabled.");
            this.mInWebCpFlow = true;
            return true;
        } catch (Throwable th) {
            Logger.error(str2, "Failed to check if WebCP in WebView feature is enabled.", th);
            return false;
        }
    }

    private String getHomeTenantIdFromUrl(String str) {
        String str2 = StringExtensions.getUrlParameters(str).get("login_hint");
        if (StringUtil.isNullOrEmpty(str2)) {
            return null;
        }
        return CommonTenantInfoProvider.INSTANCE.getHomeTenantId(str2);
    }

    private void processWebCpEnrollmentUrl(WebView webView, String str) {
        String str2 = TAG + ":processWebCpEnrollmentUrl";
        Span spanCreateSpanWithAttributesFromParent = createSpanWithAttributesFromParent(SpanName.ProcessWebCpEnrollmentRedirect.name());
        try {
            Scope scopeMakeCurrentSpan = SpanExtension.makeCurrentSpan(spanCreateSpanWithAttributesFromParent);
            try {
                webView.stopLoading();
                Logger.info(str2, "Loading WebCP enrollment url in browser.");
                openGoogleEnrollmentUrl(str);
                new Handler().postDelayed(new Runnable() { // from class: com.microsoft.identity.common.internal.ui.webview.AzureActiveDirectoryWebViewClient.1
                    @Override // java.lang.Runnable
                    public void run() {
                        AzureActiveDirectoryWebViewClient.this.returnResult(RawAuthorizationResult.ResultCode.MDM_FLOW);
                    }
                }, TimeUnit.SECONDS.toMillis(3L));
                spanCreateSpanWithAttributesFromParent.setStatus(StatusCode.OK);
                if (scopeMakeCurrentSpan != null) {
                    scopeMakeCurrentSpan.close();
                }
                spanCreateSpanWithAttributesFromParent.end();
            } catch (Throwable th) {
                if (scopeMakeCurrentSpan != null) {
                    try {
                        scopeMakeCurrentSpan.close();
                    } catch (Throwable th2) {
                        th.addSuppressed(th2);
                    }
                }
                throw th;
            }
        } catch (Throwable th3) {
            try {
                Logger.error(str2, "Failed to process WebCP enrollment URL.", th3);
                spanCreateSpanWithAttributesFromParent.recordException(th3);
                spanCreateSpanWithAttributesFromParent.setStatus(StatusCode.ERROR);
                returnError("unknown_error", th3.getMessage());
            } finally {
                spanCreateSpanWithAttributesFromParent.end();
            }
        }
    }

    private void openGoogleEnrollmentUrl(String str) {
        String str2 = TAG + ":openGoogleEnrollmentUrl";
        Logger.info(str2, "Opening Google enrollment URL");
        try {
            Intent intent = new Intent("android.intent.action.VIEW", Uri.parse(str));
            intent.addFlags(268468224);
            getActivity().startActivity(intent);
        } catch (ActivityNotFoundException e) {
            Logger.error(str2, "Failed to open the intent for google enrollment.", e);
            throw e;
        }
    }

    private boolean processPlayStoreURL(WebView webView, String str) {
        String str2 = TAG + ":processPlayStoreURL";
        webView.stopLoading();
        if (!str.startsWith("market://details?id=com.microsoft.windowsintune.companyportal") && !str.startsWith("market://details?id=com.azure.authenticator")) {
            Logger.info(str2, "The URI is either trying to open an unknown application or contains unknown query parameters");
            return false;
        }
        String brokerAppPackageNameFromUrl = getBrokerAppPackageNameFromUrl(str);
        Logger.info(str2, "Request to open PlayStore to install package : '" + brokerAppPackageNameFromUrl + "'");
        try {
            Intent intent = new Intent("android.intent.action.VIEW", Uri.parse("market://details?id=" + brokerAppPackageNameFromUrl));
            intent.addFlags(268468224);
            getActivity().startActivity(intent);
            return true;
        } catch (ActivityNotFoundException e) {
            Logger.error(str2, "PlayStore is not present on the device", e);
            return true;
        }
    }

    private boolean processPlayStoreURLForBrokerApps(WebView webView, String str) {
        String str2 = TAG + ":processPlayStoreURL";
        String brokerAppPackageNameFromUrl = getBrokerAppPackageNameFromUrl(str);
        Logger.info(str2, "Request to open PlayStore to install package : '" + brokerAppPackageNameFromUrl + "'");
        try {
            getActivity().startActivity(new Intent("android.intent.action.VIEW", Uri.parse(AuthenticationConstants.Broker.PLAY_STORE_INSTALL_APP_PREFIX + brokerAppPackageNameFromUrl)));
            webView.stopLoading();
            return true;
        } catch (ActivityNotFoundException e) {
            Logger.error(str2, "PlayStore is not present on the device", e);
            return false;
        } catch (Exception e2) {
            Logger.error(str2, "Failed to intercept install broker playstore URL and launch the intent", e2);
            return false;
        }
    }

    private void processAuthAppMFAUrl(String str) {
        String str2 = TAG + ":processAuthAppMFAUrl";
        Logger.verbose(str2, "Linking Account in Broker for MFA.");
        try {
            Intent intent = new Intent("android.intent.action.VIEW", Uri.parse(str));
            intent.addFlags(268435456);
            getActivity().startActivity(intent);
        } catch (ActivityNotFoundException e) {
            Logger.error(str2, "Failed to open the Authenticator application.", e);
        }
    }

    private void launchCompanyPortal() {
        Logger.verbose(TAG + ":launchCompanyPortal", "Sending intent to launch the CompanyPortal.");
        Intent intent = new Intent();
        intent.setComponent(new ComponentName("com.microsoft.windowsintune.companyportal", AuthenticationConstants.Broker.COMPANY_PORTAL_APP_LAUNCH_ACTIVITY_NAME));
        intent.addFlags(268468224);
        getActivity().startActivity(intent);
        returnResult(RawAuthorizationResult.ResultCode.MDM_FLOW);
    }

    private void processAmazonAppUri(String str) {
        String str2 = TAG + ":processAmazonAppUri";
        getActivity().startActivity(new Intent("android.intent.action.VIEW", Uri.parse(str)));
        Logger.info(str2, "Sent Intent to launch Amazon app");
    }

    protected void openLinkInBrowser(String str) {
        String str2 = TAG + ":openLinkInBrowser";
        Logger.info(str2, "Try to open url link in browser");
        Intent intent = new Intent("android.intent.action.VIEW", Uri.parse(str.replace(AuthenticationConstants.Broker.BROWSER_EXT_PREFIX, AuthenticationConstants.Broker.REDIRECT_SSL_PREFIX)));
        if (intent.resolveActivity(getActivity().getPackageManager()) != null) {
            getActivity().startActivity(intent);
        } else {
            Logger.warn(str2, "Unable to find an app to resolve the activity.");
        }
    }

    private void processWebCpRequest(WebView webView, String str) {
        webView.stopLoading();
        if (str.equalsIgnoreCase(AuthenticationConstants.Broker.WEBCP_LAUNCH_COMPANY_PORTAL_URL)) {
            launchCompanyPortal();
        } else {
            returnError(ErrorStrings.WEBCP_URI_INVALID, "Unexpected URL from WebCP: " + str);
        }
    }

    private void processInstallRequest(final WebView webView, String str) {
        String str2 = TAG + ":processInstallRequest";
        RawAuthorizationResult rawAuthorizationResultFromRedirectUri = RawAuthorizationResult.fromRedirectUri(str);
        if (rawAuthorizationResultFromRedirectUri.getResultCode() != RawAuthorizationResult.ResultCode.BROKER_INSTALLATION_TRIGGERED) {
            getCompletionCallback().onChallengeResponseReceived(rawAuthorizationResultFromRedirectUri);
            webView.stopLoading();
            return;
        }
        final String str3 = StringExtensions.getUrlParameters(str).get(com.microsoft.identity.common.java.AuthenticationConstants.AAD.APP_LINK_KEY);
        Logger.info(str2, "Launching the link to app:" + str3);
        getCompletionCallback().onChallengeResponseReceived(rawAuthorizationResultFromRedirectUri);
        new Handler().postDelayed(new Runnable() { // from class: com.microsoft.identity.common.internal.ui.webview.AzureActiveDirectoryWebViewClient.2
            @Override // java.lang.Runnable
            public void run() {
                AzureActiveDirectoryWebViewClient.this.getActivity().startActivity(new Intent("android.intent.action.VIEW", Uri.parse(str3.replace(AuthenticationConstants.Broker.BROWSER_EXT_PREFIX, AuthenticationConstants.Broker.REDIRECT_SSL_PREFIX))));
                webView.stopLoading();
            }
        }, 1000L);
        webView.stopLoading();
    }

    private void processInvalidRedirectUri(WebView webView, String str) {
        String str2 = TAG + ":processInvalidRedirectUri";
        Logger.error(str2, "The RedirectUri is not as expected.", null);
        Logger.errorPII(str2, String.format("Received %s and expected %s", str, this.mRedirectUrl), null);
        returnError(ErrorStrings.DEVELOPER_REDIRECTURI_INVALID, String.format("The RedirectUri is not as expected. Received %s and expected %s", str, this.mRedirectUrl));
        webView.stopLoading();
    }

    private void processIntentToInstallBrokerApp(WebView webView, String str) {
        String str2 = TAG + ":processIntentToInstallBrokerApp";
        try {
            Intent uri = Intent.parseUri(str, 1);
            if (uri != null && uri.getPackage() != null) {
                webView.getContext().startActivity(uri);
                Logger.info(str2, "Intent request sent to launch the app: " + uri.getPackage());
            } else {
                Logger.warn(str2, "Unable to parse the intent URI");
            }
        } catch (ActivityNotFoundException e) {
            Logger.error(str2, "No activity found to handle the intent.", e);
            returnError(ErrorStrings.ACTIVITY_NOT_FOUND, e.getMessage());
        } catch (URISyntaxException e2) {
            Logger.error(str2, "Failed to parse the intent URI due to invalid syntax.", e2);
            returnError(ErrorStrings.URI_SYNTAX_ERROR, e2.getMessage());
        } catch (Throwable th) {
            Logger.error(str2, "An unexpected error occurred while processing the intent URI.", th);
            returnError(ErrorStrings.UNEXPECTED_ERROR, th.getMessage());
        }
    }

    private void processSSLProtectionCheck(WebView webView, String str) {
        Logger.error(TAG + ":processSSLProtectionCheck", "The webView was redirected to an unsafe URL: " + removeQueryParametersOrRedact(str), null);
        returnError(ErrorStrings.WEBVIEW_REDIRECTURL_NOT_SSL_PROTECTED, "The webView was redirected to an unsafe URL.");
        webView.stopLoading();
    }

    private void processInvalidUrl(String str) {
        Logger.infoPII(TAG + ":processInvalidUrl", "We are declining to override loading and redirect to invalid URL: '" + removeQueryParametersOrRedact(str) + "' the user's url pattern is '" + this.mRedirectUrl + "'");
    }

    private void processHeaderForwardingRequiredUri(WebView webView, String str) {
        Logger.infoPII(TAG + ":processHeaderForwardingRequiredUri", "We are loading this new URL: '" + removeQueryParametersOrRedact(str) + "' with original requestHeaders appended.");
        webView.loadUrl(str, this.mRequestHeaders);
    }

    private void processNonceAndReAttachHeaders(WebView webView, String str) {
        String str2 = TAG + ":processNonceAndReAttachHeaders";
        String str3 = StringExtensions.getUrlParameters(str).get(AuthenticationConstants.Broker.SSO_NONCE_PARAMETER);
        SpanExtension.current().setAttribute(AttributeName.is_sso_nonce_found_in_ests_request.name(), str3 != null);
        if (str3 != null) {
            Span spanCreateSpanFromParent = OTelUtility.createSpanFromParent(SpanName.ProcessNonceFromEstsRedirect.name(), this.mSpanContext);
            try {
                try {
                    Scope scopeMakeCurrentSpan = SpanExtension.makeCurrentSpan(spanCreateSpanFromParent);
                    try {
                        new NonceRedirectHandler(webView, this.mRequestHeaders, spanCreateSpanFromParent).processChallenge(new URL(str));
                        spanCreateSpanFromParent.setStatus(StatusCode.OK);
                        if (scopeMakeCurrentSpan != null) {
                            scopeMakeCurrentSpan.close();
                        }
                        spanCreateSpanFromParent.end();
                    } catch (Throwable th) {
                        if (scopeMakeCurrentSpan != null) {
                            try {
                                scopeMakeCurrentSpan.close();
                            } catch (Throwable th2) {
                                th.addSuppressed(th2);
                            }
                        }
                        throw th;
                    }
                } catch (Throwable th3) {
                    spanCreateSpanFromParent.end();
                    throw th3;
                }
            } catch (MalformedURLException e) {
                Logger.errorPII(str2, "Redirect URI has invalid syntax, unable to parse", e);
                spanCreateSpanFromParent.setStatus(StatusCode.ERROR, "Redirect URI has invalid syntax, unable to parse");
                spanCreateSpanFromParent.recordException(e);
                spanCreateSpanFromParent.end();
            } catch (Throwable th4) {
                Logger.error(str2, "Error processing nonce and re-attaching headers", th4);
                spanCreateSpanFromParent.setStatus(StatusCode.ERROR, "Error processing nonce and re-attaching headers");
                spanCreateSpanFromParent.recordException(th4);
                webView.loadUrl(str, this.mRequestHeaders);
                spanCreateSpanFromParent.end();
            }
        }
    }

    private void processWebCpAuthorize(WebView webView, String str) {
        String str2 = TAG + ":processWebCPAuthorize";
        Logger.info(str2, "Processing WebCP authorize request.");
        Span spanCreateSpanWithAttributesFromParent = createSpanWithAttributesFromParent(SpanName.ProcessWebCpAuthorizeUrlRedirect.name());
        reAttachPrtHeader(str, new ReAttachPrtHeaderHandler(webView, this.mRequestHeaders, spanCreateSpanWithAttributesFromParent), webView, str2, spanCreateSpanWithAttributesFromParent);
    }

    private void processCrossCloudRedirect(WebView webView, String str) {
        String str2 = TAG + ":processCrossCloudRedirect";
        Span spanCreateSpanFromParent = OTelUtility.createSpanFromParent(SpanName.ProcessCrossCloudRedirect.name(), this.mSpanContext);
        reAttachPrtHeader(str, new ReAttachPrtHeaderHandler(webView, this.mRequestHeaders, spanCreateSpanFromParent), webView, str2, spanCreateSpanFromParent);
    }

    public void reAttachPrtHeader(String str, ReAttachPrtHeaderHandler reAttachPrtHeaderHandler, WebView webView, String str2, Span span) {
        try {
            Scope scopeMakeCurrentSpan = SpanExtension.makeCurrentSpan(span);
            try {
                reAttachPrtHeaderHandler.processChallenge(str);
                span.setStatus(StatusCode.OK);
                if (scopeMakeCurrentSpan != null) {
                    scopeMakeCurrentSpan.close();
                }
                span.end();
            } catch (Throwable th) {
                if (scopeMakeCurrentSpan != null) {
                    try {
                        scopeMakeCurrentSpan.close();
                    } catch (Throwable th2) {
                        th.addSuppressed(th2);
                    }
                }
                throw th;
            }
        } catch (Throwable th3) {
            try {
                Logger.warn(str2, "Error attaching PRT header." + th3);
                span.recordException(th3);
                span.setStatus(StatusCode.ERROR);
                webView.loadUrl(str);
            } finally {
                span.end();
            }
        }
    }

    private String removeQueryParametersOrRedact(String str) {
        String str2 = TAG + ":removeQueryParametersOrRedact";
        try {
            return StringExtensions.removeQueryParameterFromUrl(str);
        } catch (URISyntaxException e) {
            Logger.errorPII(str2, "Redirect URI has invalid syntax, unable to parse", e);
            return "redacted";
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void returnResult(RawAuthorizationResult.ResultCode resultCode) {
        getCompletionCallback().onChallengeResponseReceived(RawAuthorizationResult.fromResultCode(resultCode));
    }

    private void returnError(String str, String str2) {
        getCompletionCallback().onChallengeResponseReceived(RawAuthorizationResult.fromException(new ClientException(str, str2)));
    }

    @Override // android.webkit.WebViewClient
    public void onReceivedClientCertRequest(WebView webView, final ClientCertRequest clientCertRequest) {
        String str = TAG + ":onReceivedClientCertRequest";
        Principal[] principals = clientCertRequest.getPrincipals();
        if (principals != null) {
            for (Principal principal : principals) {
                if (principal.getName().contains(DEVICE_CERT_ISSUER)) {
                    Logger.info(str, "Cancelling the TLS request, not responding to TLS challenge triggered by device authentication.");
                    clientCertRequest.cancel();
                    return;
                }
            }
        }
        AbstractCertBasedAuthChallengeHandler abstractCertBasedAuthChallengeHandler = this.mCertBasedAuthChallengeHandler;
        if (abstractCertBasedAuthChallengeHandler != null) {
            abstractCertBasedAuthChallengeHandler.cleanUp();
        }
        this.mCertBasedAuthFactory.createCertBasedAuthChallengeHandler(new CertBasedAuthFactory.CertBasedAuthChallengeHandlerCallback() { // from class: com.microsoft.identity.common.internal.ui.webview.AzureActiveDirectoryWebViewClient.3
            @Override // com.microsoft.identity.common.internal.ui.webview.certbasedauth.CertBasedAuthFactory.CertBasedAuthChallengeHandlerCallback
            public void onReceived(AbstractCertBasedAuthChallengeHandler abstractCertBasedAuthChallengeHandler2) {
                AzureActiveDirectoryWebViewClient.this.mCertBasedAuthChallengeHandler = abstractCertBasedAuthChallengeHandler2;
                if (AzureActiveDirectoryWebViewClient.this.mCertBasedAuthChallengeHandler != null) {
                    AzureActiveDirectoryWebViewClient.this.mCertBasedAuthChallengeHandler.processChallenge(clientCertRequest);
                } else {
                    clientCertRequest.cancel();
                }
            }
        });
    }

    @Override // com.microsoft.identity.common.internal.ui.webview.OAuth2WebViewClient, android.webkit.WebViewClient
    public void onPageStarted(WebView webView, String str, Bitmap bitmap) {
        super.onPageStarted(webView, str, bitmap);
        for (JsScriptRecord jsScriptRecord : this.mOnPageStartedScripts) {
            if (jsScriptRecord.isAllowedForUrl(str)) {
                Logger.info(TAG, "Executing onPageStarted script: " + jsScriptRecord.getId());
                webView.evaluateJavascript(jsScriptRecord.getScript(), null);
            }
        }
    }

    public void onDestroy() {
        AbstractCertBasedAuthChallengeHandler abstractCertBasedAuthChallengeHandler = this.mCertBasedAuthChallengeHandler;
        if (abstractCertBasedAuthChallengeHandler != null) {
            abstractCertBasedAuthChallengeHandler.cleanUp();
        }
        this.mCertBasedAuthFactory.onDestroy();
    }

    public void finalizeBeforeSendingResult(RawAuthorizationResult rawAuthorizationResult, ISendResultCallback iSendResultCallback) {
        AbstractCertBasedAuthChallengeHandler abstractCertBasedAuthChallengeHandler = this.mCertBasedAuthChallengeHandler;
        if (abstractCertBasedAuthChallengeHandler == null) {
            iSendResultCallback.onResultReady();
            return;
        }
        abstractCertBasedAuthChallengeHandler.emitTelemetryForCertBasedAuthResults(rawAuthorizationResult);
        AbstractCertBasedAuthChallengeHandler abstractCertBasedAuthChallengeHandler2 = this.mCertBasedAuthChallengeHandler;
        if (!(abstractCertBasedAuthChallengeHandler2 instanceof AbstractSmartcardCertBasedAuthChallengeHandler)) {
            iSendResultCallback.onResultReady();
        } else {
            ((AbstractSmartcardCertBasedAuthChallengeHandler) abstractCertBasedAuthChallengeHandler2).promptSmartcardRemovalForResult(iSendResultCallback);
        }
    }

    private String getBrokerAppPackageNameFromUrl(String str) {
        for (BrokerData brokerData : BrokerData.getAllBrokers()) {
            if (str.contains(brokerData.getPackageName())) {
                return brokerData.getPackageName();
            }
        }
        Logger.warn(TAG + ":getBrokerAppPackageNameFromUrl", "No known broker app package name found in URL: " + str);
        return "";
    }

    private Span createSpanWithAttributesFromParent(String str) {
        Span spanCreateSpanFromParent = OTelUtility.createSpanFromParent(str, this.mSpanContext);
        if (this.mUtid != null) {
            spanCreateSpanFromParent.setAttribute(AttributeName.tenant_id.name(), this.mUtid);
        }
        Context otelContext = getActivity() instanceof AuthorizationActivity ? ((AuthorizationActivity) getActivity()).getOtelContext() : null;
        if (otelContext != null) {
            Baggage baggageFromContext = BaggageExtension.fromContext(otelContext);
            for (AttributeName attributeName : Arrays.asList(AttributeName.correlation_id, AttributeName.calling_package_name)) {
                String entryValue = baggageFromContext.getEntryValue(attributeName.name());
                if (entryValue != null) {
                    spanCreateSpanFromParent.setAttribute(attributeName.name(), entryValue);
                }
            }
        }
        return spanCreateSpanFromParent;
    }

    public void addOnPageStartedScript(String str, String str2, Set<String> set) {
        this.mOnPageStartedScripts.add(new JsScriptRecord(str, str2, set));
    }
}
