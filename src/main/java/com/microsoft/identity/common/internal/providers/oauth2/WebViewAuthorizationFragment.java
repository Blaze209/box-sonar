package com.microsoft.identity.common.internal.providers.oauth2;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.PermissionRequest;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.ProgressBar;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.fragment.app.FragmentActivity;
import com.microsoft.identity.common.R;
import com.microsoft.identity.common.adal.internal.AuthenticationConstants;
import com.microsoft.identity.common.adal.internal.util.StringExtensions;
import com.microsoft.identity.common.internal.fido.LegacyFido2ApiObject;
import com.microsoft.identity.common.internal.fido.LegacyFidoActivityResultContract;
import com.microsoft.identity.common.internal.ui.webview.AzureActiveDirectoryWebViewClient;
import com.microsoft.identity.common.internal.ui.webview.ISendResultCallback;
import com.microsoft.identity.common.internal.ui.webview.OnPageLoadedCallback;
import com.microsoft.identity.common.internal.ui.webview.ProcessUtil;
import com.microsoft.identity.common.internal.ui.webview.WebViewUtil;
import com.microsoft.identity.common.internal.ui.webview.switchbrowser.SwitchBrowserProtocolCoordinator;
import com.microsoft.identity.common.java.constants.FidoConstants;
import com.microsoft.identity.common.java.exception.ClientException;
import com.microsoft.identity.common.java.flighting.CommonFlight;
import com.microsoft.identity.common.java.flighting.CommonFlightsManager;
import com.microsoft.identity.common.java.providers.RawAuthorizationResult;
import com.microsoft.identity.common.java.ui.webview.authorization.IAuthorizationCompletionCallback;
import com.microsoft.identity.common.java.util.ClientExtraSku;
import com.microsoft.identity.common.java.util.StringUtil;
import com.microsoft.identity.common.logging.Logger;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.Arrays;
import java.util.HashMap;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;

/* JADX INFO: loaded from: classes14.dex */
public class WebViewAuthorizationFragment extends AuthorizationFragment {
    private static final String PKEYAUTH_STATUS = "pkeyAuthStatus";
    private static final String TAG = "WebViewAuthorizationFragment";
    private static Bundle switchBrowserBundle;
    private boolean isWebViewWebcpEnabledInBrokerlessCase;
    private AzureActiveDirectoryWebViewClient mAADWebViewClient;
    private Intent mAuthIntent;
    private String mAuthorizationRequestUrl;
    private ActivityResultLauncher<LegacyFido2ApiObject> mFidoLauncher;
    private String mPostPageLoadedJavascript;
    private ProgressBar mProgressBar;
    private String mRedirectUri;
    private HashMap<String, String> mRequestHeaders;
    private String mUtid;
    private WebView mWebView;
    private boolean webViewZoomControlsEnabled;
    private boolean webViewZoomEnabled;
    private boolean mPkeyAuthStatus = false;
    private final CameraPermissionRequestHandler mCameraPermissionRequestHandler = new CameraPermissionRequestHandler(this);
    private SwitchBrowserProtocolCoordinator mSwitchBrowserProtocolCoordinator = null;
    private boolean isBrokerRequest = false;

    @Override // com.microsoft.identity.common.internal.providers.oauth2.AuthorizationFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        final String str = TAG + ":onCreate";
        Logger.verbose(str, "WebViewAuthorizationFragment onCreate");
        FragmentActivity activity = getActivity();
        if (activity != null) {
            WebViewUtil.setDataDirectorySuffix(activity.getApplicationContext());
        }
        if (!CommonFlightsManager.INSTANCE.getFlightsProvider().isFlightEnabled(CommonFlight.ENABLE_LEGACY_FIDO_SECURITY_KEY_LOGIC) || Build.VERSION.SDK_INT >= 34) {
            return;
        }
        this.mFidoLauncher = registerForActivityResult(new LegacyFidoActivityResultContract(), new ActivityResultCallback() { // from class: com.microsoft.identity.common.internal.providers.oauth2.WebViewAuthorizationFragment$$ExternalSyntheticLambda1
            @Override // androidx.activity.result.ActivityResultCallback
            public final void onActivityResult(Object obj) {
                Logger.info(str, "Legacy FIDO2 API result received.");
            }
        });
    }

    @Override // androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        Logger.verbose(TAG + ":onResume", "WebViewAuthorizationFragment onResume");
        if (getSwitchBrowserCoordinator().isExpectingSwitchBrowserResume()) {
            resumeSwitchBrowser();
        } else {
            setSwitchBrowserBundle(null);
        }
    }

    private void resumeSwitchBrowser() {
        String str = TAG + ":resumeSwitchBrowser";
        try {
            if (switchBrowserBundle == null) {
                throw new ClientException("null_object", "No switch browser bundle found to resume the flow.");
            }
            Logger.info(str, "Resuming switch browser flow");
            getSwitchBrowserCoordinator().processSwitchBrowserResume(this.mAuthorizationRequestUrl, switchBrowserBundle, new Function2() { // from class: com.microsoft.identity.common.internal.providers.oauth2.WebViewAuthorizationFragment$$ExternalSyntheticLambda0
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return this.f$0.m13853x367f0552((Uri) obj, (HashMap) obj2);
                }
            });
            setSwitchBrowserBundle(null);
        } catch (ClientException e) {
            Logger.error(str, "Error processing switch browser resume", e);
            sendResult(RawAuthorizationResult.fromException(e));
            finish();
        }
    }

    /* JADX INFO: renamed from: lambda$resumeSwitchBrowser$1$com-microsoft-identity-common-internal-providers-oauth2-WebViewAuthorizationFragment, reason: not valid java name */
    /* synthetic */ Unit m13853x367f0552(Uri uri, HashMap map) {
        launchWebView(uri.toString(), map);
        return null;
    }

    @Override // androidx.fragment.app.Fragment
    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putParcelable(AuthenticationConstants.AuthorizationIntentKey.AUTH_INTENT, this.mAuthIntent);
        bundle.putBoolean(PKEYAUTH_STATUS, this.mPkeyAuthStatus);
        bundle.putString(AuthenticationConstants.AuthorizationIntentKey.REDIRECT_URI, this.mRedirectUri);
        bundle.putString(AuthenticationConstants.AuthorizationIntentKey.REQUEST_URL, this.mAuthorizationRequestUrl);
        bundle.putSerializable(AuthenticationConstants.AuthorizationIntentKey.REQUEST_HEADERS, this.mRequestHeaders);
        bundle.putSerializable(AuthenticationConstants.AuthorizationIntentKey.POST_PAGE_LOADED_URL, this.mPostPageLoadedJavascript);
        bundle.putBoolean(AuthenticationConstants.AuthorizationIntentKey.WEB_VIEW_ZOOM_CONTROLS_ENABLED, this.webViewZoomControlsEnabled);
        bundle.putBoolean(AuthenticationConstants.AuthorizationIntentKey.WEB_VIEW_ZOOM_ENABLED, this.webViewZoomEnabled);
        bundle.putBoolean(AuthenticationConstants.AuthorizationIntentKey.WEB_VIEW_WEB_CP_ENABLED, this.isWebViewWebcpEnabledInBrokerlessCase);
        bundle.putString(com.microsoft.identity.common.java.AuthenticationConstants.OAuth2.UTID, this.mUtid);
    }

    @Override // com.microsoft.identity.common.internal.providers.oauth2.AuthorizationFragment
    void extractState(Bundle bundle) {
        super.extractState(bundle);
        this.mAuthIntent = (Intent) bundle.getParcelable(AuthenticationConstants.AuthorizationIntentKey.AUTH_INTENT);
        this.mPkeyAuthStatus = bundle.getBoolean(PKEYAUTH_STATUS, false);
        this.mAuthorizationRequestUrl = bundle.getString(AuthenticationConstants.AuthorizationIntentKey.REQUEST_URL);
        Context context = getContext();
        if (context != null) {
            this.isBrokerRequest = ProcessUtil.isRunningOnAuthService(context);
        }
        this.mRedirectUri = bundle.getString(AuthenticationConstants.AuthorizationIntentKey.REDIRECT_URI);
        this.mRequestHeaders = getRequestHeaders(bundle);
        this.mPostPageLoadedJavascript = bundle.getString(AuthenticationConstants.AuthorizationIntentKey.POST_PAGE_LOADED_URL);
        this.webViewZoomEnabled = bundle.getBoolean(AuthenticationConstants.AuthorizationIntentKey.WEB_VIEW_ZOOM_ENABLED, true);
        this.webViewZoomControlsEnabled = bundle.getBoolean(AuthenticationConstants.AuthorizationIntentKey.WEB_VIEW_ZOOM_CONTROLS_ENABLED, true);
        this.isWebViewWebcpEnabledInBrokerlessCase = bundle.getBoolean(AuthenticationConstants.AuthorizationIntentKey.WEB_VIEW_WEB_CP_ENABLED, false);
        this.mUtid = bundle.getString(com.microsoft.identity.common.java.AuthenticationConstants.OAuth2.UTID);
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        final String str = TAG + ":onCreateView";
        View viewInflate = layoutInflater.inflate(R.layout.common_activity_authentication, viewGroup, false);
        this.mProgressBar = (ProgressBar) viewInflate.findViewById(R.id.common_auth_webview_progressbar);
        FragmentActivity activity = getActivity();
        if (activity == null) {
            return null;
        }
        AzureActiveDirectoryWebViewClient azureActiveDirectoryWebViewClient = new AzureActiveDirectoryWebViewClient(activity, new AuthorizationCompletionCallback(), new OnPageLoadedCallback() { // from class: com.microsoft.identity.common.internal.providers.oauth2.WebViewAuthorizationFragment.1
            @Override // com.microsoft.identity.common.internal.ui.webview.OnPageLoadedCallback
            public void onPageLoaded(String str2) {
                String[] strArr = new String[1];
                WebViewAuthorizationFragment.this.mProgressBar.setVisibility(4);
                try {
                    strArr[0] = String.format("window.expectedUrl = '%s';%n%s", URLEncoder.encode(str2, "UTF-8"), WebViewAuthorizationFragment.this.mPostPageLoadedJavascript);
                } catch (UnsupportedEncodingException unused) {
                    Logger.warn(str, "Inject expectedUrl failed.");
                }
                if (WebViewAuthorizationFragment.this.mAuthResultSent || StringExtensions.isNullOrBlank(strArr[0])) {
                    return;
                }
                WebViewAuthorizationFragment.this.mWebView.evaluateJavascript(strArr[0], null);
            }
        }, this.mRedirectUri, getSwitchBrowserCoordinator().getSwitchBrowserRequestHandler(), this.mUtid, this.isWebViewWebcpEnabledInBrokerlessCase);
        this.mAADWebViewClient = azureActiveDirectoryWebViewClient;
        setUpWebView(viewInflate, azureActiveDirectoryWebViewClient);
        this.mAADWebViewClient.initializeAuthUxJavaScriptApi(this.mWebView, this.mAuthorizationRequestUrl);
        launchWebView(this.mAuthorizationRequestUrl, this.mRequestHeaders);
        return viewInflate;
    }

    @Override // com.microsoft.identity.common.internal.providers.oauth2.AuthorizationFragment
    public void handleBackButtonPressed() {
        Logger.info(TAG + ":handleBackButtonPressed", "Back button is pressed");
        if (this.mWebView.canGoBack()) {
            this.mWebView.goBack();
        } else {
            cancelAuthorization(true);
        }
    }

    private void setUpWebView(View view, AzureActiveDirectoryWebViewClient azureActiveDirectoryWebViewClient) {
        String str = TAG + ":setUpWebView";
        WebView webView = (WebView) view.findViewById(R.id.common_auth_webview);
        this.mWebView = webView;
        WebSettings settings = webView.getSettings();
        settings.setUserAgentString(settings.getUserAgentString() + AuthenticationConstants.Broker.CLIENT_TLS_NOT_SUPPORTED);
        settings.setJavaScriptEnabled(true);
        if (CommonFlightsManager.INSTANCE.getFlightsProvider().isFlightEnabled(CommonFlight.ENABLE_WEBVIEW_SECURITY_SETTINGS)) {
            settings.setAllowFileAccess(false);
            settings.setAllowContentAccess(false);
            settings.setAllowFileAccessFromFileURLs(false);
            settings.setAllowUniversalAccessFromFileURLs(false);
            settings.setGeolocationEnabled(false);
        }
        this.mWebView.requestFocus(130);
        this.mWebView.setOnTouchListener(new View.OnTouchListener() { // from class: com.microsoft.identity.common.internal.providers.oauth2.WebViewAuthorizationFragment.2
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view2, MotionEvent motionEvent) {
                int action = motionEvent.getAction();
                if ((action != 0 && action != 1) || view2.hasFocus()) {
                    return false;
                }
                view2.requestFocus();
                return false;
            }
        });
        this.mWebView.getSettings().setLoadWithOverviewMode(true);
        this.mWebView.getSettings().setDomStorageEnabled(true);
        this.mWebView.getSettings().setUseWideViewPort(true);
        this.mWebView.getSettings().setBuiltInZoomControls(this.webViewZoomControlsEnabled);
        this.mWebView.getSettings().setSupportZoom(this.webViewZoomEnabled);
        this.mWebView.setVisibility(4);
        this.mWebView.setWebViewClient(azureActiveDirectoryWebViewClient);
        this.mWebView.setWebChromeClient(new AnonymousClass3(str));
        setupPasskeyWebListener(this.mWebView, azureActiveDirectoryWebViewClient);
    }

    /* JADX INFO: renamed from: com.microsoft.identity.common.internal.providers.oauth2.WebViewAuthorizationFragment$3, reason: invalid class name */
    class AnonymousClass3 extends WebChromeClient {
        final /* synthetic */ String val$methodTag;

        AnonymousClass3(String str) {
            this.val$methodTag = str;
        }

        @Override // android.webkit.WebChromeClient
        public void onPermissionRequest(final PermissionRequest permissionRequest) {
            FragmentActivity fragmentActivityRequireActivity = WebViewAuthorizationFragment.this.requireActivity();
            final String str = this.val$methodTag;
            fragmentActivityRequireActivity.runOnUiThread(new Runnable() { // from class: com.microsoft.identity.common.internal.providers.oauth2.WebViewAuthorizationFragment$3$$ExternalSyntheticLambda0
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.m13854x2cff1c48(str, permissionRequest);
                }
            });
        }

        /* JADX INFO: renamed from: lambda$onPermissionRequest$0$com-microsoft-identity-common-internal-providers-oauth2-WebViewAuthorizationFragment$3, reason: not valid java name */
        /* synthetic */ void m13854x2cff1c48(String str, PermissionRequest permissionRequest) {
            Logger.info(str, "Permission requested from:" + permissionRequest.getOrigin() + " for resources:" + Arrays.toString(permissionRequest.getResources()));
            WebViewAuthorizationFragment.this.mCameraPermissionRequestHandler.handle(permissionRequest, WebViewAuthorizationFragment.this.requireContext());
        }

        @Override // android.webkit.WebChromeClient
        public Bitmap getDefaultVideoPoster() {
            return Bitmap.createBitmap(10, 10, Bitmap.Config.ARGB_8888);
        }
    }

    private void launchWebView(final String str, final HashMap<String, String> map) {
        final String str2 = TAG + ":launchWebView";
        this.mWebView.post(new Runnable() { // from class: com.microsoft.identity.common.internal.providers.oauth2.WebViewAuthorizationFragment.4
            @Override // java.lang.Runnable
            public void run() {
                Logger.info(str2, "Launching embedded WebView for acquiring auth code.");
                Logger.infoPII(str2, "The start url is " + str);
                WebViewAuthorizationFragment.this.mAADWebViewClient.setRequestHeaders(map);
                WebViewAuthorizationFragment.this.mAADWebViewClient.setRequestUrl(str);
                WebViewAuthorizationFragment.this.mWebView.loadUrl(str, map);
                WebViewAuthorizationFragment.this.mProgressBar.setVisibility(0);
            }
        });
    }

    @Override // com.microsoft.identity.common.internal.providers.oauth2.AuthorizationFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        ActivityResultLauncher<LegacyFido2ApiObject> activityResultLauncher;
        super.onDestroy();
        String str = TAG + ":onDestroy";
        AzureActiveDirectoryWebViewClient azureActiveDirectoryWebViewClient = this.mAADWebViewClient;
        if (azureActiveDirectoryWebViewClient != null) {
            azureActiveDirectoryWebViewClient.onDestroy();
        } else {
            Logger.error(str, "Fragment destroyed, but smartcard usb discovery was unable to be stopped.", null);
        }
        if (!CommonFlightsManager.INSTANCE.getFlightsProvider().isFlightEnabled(CommonFlight.ENABLE_LEGACY_FIDO_SECURITY_KEY_LOGIC) || Build.VERSION.SDK_INT >= 34 || (activityResultLauncher = this.mFidoLauncher) == null) {
            return;
        }
        activityResultLauncher.unregister();
    }

    private HashMap<String, String> getRequestHeaders(Bundle bundle) {
        try {
            HashMap<String, String> map = (HashMap) bundle.getSerializable(AuthenticationConstants.AuthorizationIntentKey.REQUEST_HEADERS);
            if (map == null) {
                map = new HashMap<>();
            }
            if (this.isBrokerRequest) {
                map.put(com.microsoft.identity.common.java.AuthenticationConstants.SdkPlatformFields.CLIENT_EXTRA_SKU, ClientExtraSku.builder().srcSku(bundle.getString("x-client-SKU")).srcSkuVer(bundle.getString("x-client-Ver")).build().toString());
            }
            injectPasskeyProtocolHeader(map);
            return map;
        } catch (Exception unused) {
            return new HashMap<>();
        }
    }

    public ActivityResultLauncher<LegacyFido2ApiObject> getFidoLauncher() {
        return this.mFidoLauncher;
    }

    class AuthorizationCompletionCallback implements IAuthorizationCompletionCallback {
        AuthorizationCompletionCallback() {
        }

        @Override // com.microsoft.identity.common.java.ui.webview.authorization.IAuthorizationCompletionCallback
        public void onChallengeResponseReceived(final RawAuthorizationResult rawAuthorizationResult) {
            Logger.info(WebViewAuthorizationFragment.TAG + ":onChallengeResponseReceived", null, "onChallengeResponseReceived:" + rawAuthorizationResult.getResultCode());
            if (WebViewAuthorizationFragment.this.mAADWebViewClient != null) {
                WebViewAuthorizationFragment.this.mAADWebViewClient.finalizeBeforeSendingResult(rawAuthorizationResult, new ISendResultCallback() { // from class: com.microsoft.identity.common.internal.providers.oauth2.WebViewAuthorizationFragment.AuthorizationCompletionCallback.1
                    @Override // com.microsoft.identity.common.internal.ui.webview.ISendResultCallback
                    public void onResultReady() {
                        WebViewAuthorizationFragment.this.sendResult(rawAuthorizationResult);
                        WebViewAuthorizationFragment.this.finish();
                    }
                });
            } else {
                WebViewAuthorizationFragment.this.sendResult(rawAuthorizationResult);
                WebViewAuthorizationFragment.this.finish();
            }
        }

        @Override // com.microsoft.identity.common.java.ui.webview.authorization.IAuthorizationCompletionCallback
        public void setPKeyAuthStatus(boolean z) {
            String str = WebViewAuthorizationFragment.TAG + ":setPKeyAuthStatus";
            WebViewAuthorizationFragment.this.mPkeyAuthStatus = z;
            Logger.info(str, null, "setPKeyAuthStatus:" + z);
        }
    }

    private SwitchBrowserProtocolCoordinator getSwitchBrowserCoordinator() {
        if (this.mSwitchBrowserProtocolCoordinator == null) {
            this.mSwitchBrowserProtocolCoordinator = new SwitchBrowserProtocolCoordinator(requireActivity(), requireActivity() instanceof AuthorizationActivity ? ((AuthorizationActivity) requireActivity()).getSpanContext() : null);
        }
        return this.mSwitchBrowserProtocolCoordinator;
    }

    public static synchronized void setSwitchBrowserBundle(Bundle bundle) {
        switchBrowserBundle = bundle;
    }

    private void setupPasskeyWebListener(WebView webView, AzureActiveDirectoryWebViewClient azureActiveDirectoryWebViewClient) {
        String str = TAG + ":setupPasskeyWebListener";
        if (FidoConstants.PASSKEY_PROTOCOL_HEADER_AUTH_AND_REG.equals(this.mRequestHeaders.get(FidoConstants.PASSKEY_PROTOCOL_HEADER_NAME))) {
            if (PasskeyWebListener.hook(webView, requireActivity(), azureActiveDirectoryWebViewClient)) {
                return;
            }
            Logger.warn(str, "PasskeyWebListener hook failed, Downgrading to auth only.");
            this.mRequestHeaders.put(FidoConstants.PASSKEY_PROTOCOL_HEADER_NAME, FidoConstants.PASSKEY_PROTOCOL_HEADER_AUTH_ONLY);
            return;
        }
        Logger.warn(str, "Passkey protocol header not found or not for both auth and reg. Not hooking the PasskeyWebListener.");
    }

    private void injectPasskeyProtocolHeader(HashMap<String, String> map) {
        String str = TAG + ":injectPasskeyProtocolHeader";
        if (StringUtil.isNullOrEmpty(Uri.parse(this.mAuthorizationRequestUrl).getQueryParameter(FidoConstants.WEBAUTHN_QUERY_PARAMETER_FIELD))) {
            return;
        }
        boolean z = this.isBrokerRequest;
        String str2 = FidoConstants.PASSKEY_PROTOCOL_HEADER_AUTH_ONLY;
        if (z) {
            if (CommonFlightsManager.INSTANCE.getFlightsProvider().isFlightEnabled(CommonFlight.ENABLE_PASSKEY_REGISTRATION)) {
                str2 = FidoConstants.PASSKEY_PROTOCOL_HEADER_AUTH_AND_REG;
            }
            Logger.verbose(str, "Injecting Passkey protocol header for broker request: ".concat(str2));
            map.put(FidoConstants.PASSKEY_PROTOCOL_HEADER_NAME, str2);
            return;
        }
        if (map.containsKey(FidoConstants.PASSKEY_PROTOCOL_HEADER_NAME)) {
            Logger.verbose(str, "Passkey protocol header already exists in request headers  " + map.get(FidoConstants.PASSKEY_PROTOCOL_HEADER_NAME));
        } else {
            Logger.verbose(str, "Injecting Passkey protocol header for auth only.");
            map.put(FidoConstants.PASSKEY_PROTOCOL_HEADER_NAME, FidoConstants.PASSKEY_PROTOCOL_HEADER_AUTH_ONLY);
        }
    }
}
