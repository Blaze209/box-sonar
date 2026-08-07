package com.box.androidsdk.content.auth;

import android.content.Context;
import android.content.DialogInterface;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.net.Uri;
import android.net.http.SslCertificate;
import android.net.http.SslError;
import android.os.Handler;
import android.os.Looper;
import android.text.format.DateFormat;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.HttpAuthHandler;
import android.webkit.SslErrorHandler;
import android.webkit.WebResourceRequest;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.EditText;
import android.widget.TextView;
import com.box.android.dataaccess.content.R;
import com.box.androidsdk.content.utils.BoxLogUtils;
import com.box.androidsdk.content.utils.OAuthUtils;
import com.box.androidsdk.content.utils.SdkUtils;
import com.google.android.material.dialog.MaterialAlertDialogBuilder;
import com.microsoft.intune.mam.client.widget.MAMWebView;
import java.lang.ref.WeakReference;
import java.util.Date;
import java.util.Formatter;

/* JADX INFO: loaded from: classes13.dex */
public class OAuthWebView extends MAMWebView {
    public static final String CODE_CHALLENGE = "code_challenge";
    public static final String MSAL_INTERCEPT_PARAM = "box_auth_mode=msal";
    public static final String MSAL_INTERCEPT_USER_PARAM = "box_auth_user";
    private static final String STATE = "state";
    private static final String URL_QUERY_LOGIN = "box_login";
    private boolean isAppFedrampCompliant;
    private String mBoxAccountEmail;

    public static class InvalidUrlException extends Exception {
        private static final long serialVersionUID = 1;
    }

    public interface OnPageFinishedListener {
        void onPageFinished(WebView webView, String str);
    }

    public OAuthWebView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.isAppFedrampCompliant = false;
    }

    public void setBoxAccountEmail(String str) {
        this.mBoxAccountEmail = str;
    }

    public void setIsAppFedrampCompliant(boolean z) {
        this.isAppFedrampCompliant = z;
    }

    public void authenticate(String str, String str2, String str3) {
        authenticate(buildUrl(str, str2, this.isAppFedrampCompliant), str3);
    }

    public void authenticate(Uri.Builder builder, String str) {
        builder.appendQueryParameter("state", OAuthUtils.generateStateToken());
        builder.appendQueryParameter(CODE_CHALLENGE, str);
        loadUrl(builder.build().toString());
    }

    protected Uri.Builder buildUrl(String str, String str2, boolean z) {
        Uri.Builder builder = new Uri.Builder();
        builder.scheme("https");
        builder.authority(z ? "account.box-gov.com" : "account.box.com");
        builder.appendPath("api");
        builder.appendPath("oauth2");
        builder.appendPath("authorize");
        builder.appendQueryParameter("response_type", "code");
        builder.appendQueryParameter("client_id", str);
        builder.appendQueryParameter("redirect_uri", str2);
        String str3 = this.mBoxAccountEmail;
        if (str3 != null) {
            builder.appendQueryParameter(URL_QUERY_LOGIN, str3);
        }
        return builder;
    }

    public static class OAuthWebViewClient extends WebViewClient {
        private static final String TAG = "OAuthWebViewClient";
        private static final int WEB_VIEW_TIMEOUT = 30000;
        private Handler mHandler = new Handler(Looper.getMainLooper());
        private OnPageFinishedListener mOnPageFinishedListener;
        private String mRedirectUrl;
        private WebViewTimeOutRunnable mTimeOutRunnable;
        private WebEventListener mWebEventListener;
        private boolean sslErrorDialogContinueButtonClicked;

        public interface WebEventListener {
            void interceptCodeReceived(String str);

            boolean onAuthFailure(AuthFailure authFailure);

            void onReceivedAuthCode(String str);

            void onReceivedAuthCode(String str, String str2);

            void onVerifiedEnterprise(String str);
        }

        public OAuthWebViewClient(WebEventListener webEventListener, String str) {
            this.mWebEventListener = webEventListener;
            this.mRedirectUrl = str;
        }

        @Override // android.webkit.WebViewClient
        public void onPageStarted(WebView webView, String str, Bitmap bitmap) {
            try {
                detectDomainAndVerifyEnterprise(str);
                Uri uRIfromURL = getURIfromURL(str);
                String valueFromURI = getValueFromURI(uRIfromURL, "code");
                if (str.contains(OAuthWebView.MSAL_INTERCEPT_PARAM)) {
                    interceptMSALCode(webView, uRIfromURL);
                    return;
                }
                if (!SdkUtils.isEmptyString(valueFromURI) && (webView instanceof OAuthWebView) && !OAuthUtils.isValidStateString(uRIfromURL.getQueryParameter("state"))) {
                    throw new InvalidUrlException();
                }
                String valueFromURI2 = getValueFromURI(uRIfromURL, "error");
                if (!SdkUtils.isEmptyString(valueFromURI2)) {
                    BoxLogUtils.e("login error ", valueFromURI2);
                    this.mWebEventListener.onAuthFailure(new AuthFailure(0, null));
                } else if (!SdkUtils.isEmptyString(valueFromURI)) {
                    String valueFromURI3 = getValueFromURI(uRIfromURL, BoxAuthentication.BoxAuthenticationInfo.FIELD_BASE_DOMAIN);
                    BoxLogUtils.v(TAG, "onReceivedAuthCode: baseDomain=" + valueFromURI3);
                    if (valueFromURI3 != null) {
                        this.mWebEventListener.onReceivedAuthCode(valueFromURI, valueFromURI3);
                    } else {
                        this.mWebEventListener.onReceivedAuthCode(valueFromURI);
                    }
                }
                WebViewTimeOutRunnable webViewTimeOutRunnable = this.mTimeOutRunnable;
                if (webViewTimeOutRunnable != null) {
                    this.mHandler.removeCallbacks(webViewTimeOutRunnable);
                }
                WebViewTimeOutRunnable webViewTimeOutRunnable2 = new WebViewTimeOutRunnable(webView, str);
                this.mTimeOutRunnable = webViewTimeOutRunnable2;
                this.mHandler.postDelayed(webViewTimeOutRunnable2, 30000L);
            } catch (InvalidUrlException unused) {
                this.mWebEventListener.onAuthFailure(new AuthFailure(1, null));
            }
        }

        private void detectDomainAndVerifyEnterprise(String str) {
            String host = Uri.parse(str).getHost();
            BoxLogUtils.i(TAG, "onPageStarted – raw URL host: " + host);
            if (host == null || !host.endsWith("ent.box.com")) {
                return;
            }
            this.mWebEventListener.onVerifiedEnterprise(host);
        }

        private void interceptMSALCode(WebView webView, Uri uri) throws InvalidUrlException {
            String valueFromURI = getValueFromURI(uri, OAuthWebView.MSAL_INTERCEPT_USER_PARAM);
            if (!SdkUtils.isEmptyString(valueFromURI)) {
                this.mWebEventListener.interceptCodeReceived(valueFromURI);
            } else {
                this.mWebEventListener.onAuthFailure(new AuthFailure(1, null));
                BoxLogUtils.e("login error ", "No user email found in the url");
            }
            webView.stopLoading();
        }

        @Override // android.webkit.WebViewClient
        public boolean shouldOverrideUrlLoading(WebView webView, WebResourceRequest webResourceRequest) {
            try {
                detectDomainAndVerifyEnterprise(webResourceRequest.getUrl().toString());
                Uri uri = Uri.parse(webResourceRequest.getUrl().toString());
                if (webResourceRequest.getUrl().toString().contains(OAuthWebView.MSAL_INTERCEPT_PARAM)) {
                    String valueFromURI = getValueFromURI(uri, OAuthWebView.MSAL_INTERCEPT_USER_PARAM);
                    if (valueFromURI == null || valueFromURI.isEmpty()) {
                        throw new InvalidUrlException();
                    }
                    this.mWebEventListener.interceptCodeReceived(valueFromURI);
                    webView.stopLoading();
                    return true;
                }
                return super.shouldOverrideUrlLoading(webView, webResourceRequest);
            } catch (InvalidUrlException unused) {
                this.mWebEventListener.onAuthFailure(new AuthFailure(1, null));
                return true;
            }
        }

        @Override // android.webkit.WebViewClient
        public void onPageFinished(WebView webView, String str) {
            WebViewTimeOutRunnable webViewTimeOutRunnable = this.mTimeOutRunnable;
            if (webViewTimeOutRunnable != null) {
                this.mHandler.removeCallbacks(webViewTimeOutRunnable);
            }
            super.onPageFinished(webView, str);
            OnPageFinishedListener onPageFinishedListener = this.mOnPageFinishedListener;
            if (onPageFinishedListener != null) {
                onPageFinishedListener.onPageFinished(webView, str);
            }
        }

        @Override // android.webkit.WebViewClient
        public void onReceivedError(WebView webView, int i, String str, String str2) {
            WebViewTimeOutRunnable webViewTimeOutRunnable = this.mTimeOutRunnable;
            if (webViewTimeOutRunnable != null) {
                this.mHandler.removeCallbacks(webViewTimeOutRunnable);
            }
            if (this.mWebEventListener.onAuthFailure(new AuthFailure(new WebViewException(i, str, str2)))) {
                return;
            }
            if (i == -8) {
                String assetFile = SdkUtils.getAssetFile(webView.getContext(), "offline.html");
                Formatter formatter = new Formatter();
                formatter.format(assetFile, webView.getContext().getString(R.string.boxsdk_unable_to_connect), webView.getContext().getString(R.string.boxsdk_unable_to_connect_detail), webView.getContext().getString(R.string.boxsdk_unable_to_connect_todo));
                webView.loadDataWithBaseURL(null, formatter.toString(), "text/html", "UTF-8", null);
                formatter.close();
            } else if ((i == -6 || i == -2) && !SdkUtils.isInternetAvailable(webView.getContext())) {
                String assetFile2 = SdkUtils.getAssetFile(webView.getContext(), "offline.html");
                Formatter formatter2 = new Formatter();
                formatter2.format(assetFile2, webView.getContext().getString(R.string.boxsdk_no_offline_access), webView.getContext().getString(R.string.boxsdk_no_offline_access_detail), webView.getContext().getString(R.string.boxsdk_no_offline_access_todo));
                webView.loadDataWithBaseURL(null, formatter2.toString(), "text/html", "UTF-8", null);
                formatter2.close();
            }
            super.onReceivedError(webView, i, str, str2);
        }

        @Override // android.webkit.WebViewClient
        public void onReceivedHttpAuthRequest(WebView webView, final HttpAuthHandler httpAuthHandler, String str, String str2) {
            final View viewInflate = LayoutInflater.from(webView.getContext()).inflate(R.layout.boxsdk_alert_dialog_text_entry, (ViewGroup) null);
            new MaterialAlertDialogBuilder(webView.getContext()).setTitle(R.string.boxsdk_alert_dialog_text_entry).setView(viewInflate).setPositiveButton(R.string.boxsdk_alert_dialog_ok, new DialogInterface.OnClickListener() { // from class: com.box.androidsdk.content.auth.OAuthWebView.OAuthWebViewClient.2
                @Override // android.content.DialogInterface.OnClickListener
                public void onClick(DialogInterface dialogInterface, int i) {
                    httpAuthHandler.proceed(((EditText) viewInflate.findViewById(R.id.username_edit)).getText().toString(), ((EditText) viewInflate.findViewById(R.id.password_edit)).getText().toString());
                }
            }).setNegativeButton(R.string.boxsdk_alert_dialog_cancel, new DialogInterface.OnClickListener() { // from class: com.box.androidsdk.content.auth.OAuthWebView.OAuthWebViewClient.1
                @Override // android.content.DialogInterface.OnClickListener
                public void onClick(DialogInterface dialogInterface, int i) {
                    httpAuthHandler.cancel();
                    OAuthWebViewClient.this.mWebEventListener.onAuthFailure(new AuthFailure(0, null));
                }
            }).show();
        }

        @Override // android.webkit.WebViewClient
        public void onReceivedSslError(final WebView webView, final SslErrorHandler sslErrorHandler, final SslError sslError) {
            String string;
            WebViewTimeOutRunnable webViewTimeOutRunnable = this.mTimeOutRunnable;
            if (webViewTimeOutRunnable != null) {
                this.mHandler.removeCallbacks(webViewTimeOutRunnable);
            }
            Resources resources = webView.getContext().getResources();
            StringBuilder sb = new StringBuilder(resources.getString(R.string.boxsdk_There_are_problems_with_the_security_certificate_for_this_site));
            sb.append(" ");
            int primaryError = sslError.getPrimaryError();
            if (primaryError == 0) {
                string = resources.getString(R.string.boxsdk_ssl_error_warning_NOT_YET_VALID);
            } else if (primaryError == 1) {
                string = resources.getString(R.string.boxsdk_ssl_error_warning_EXPIRED);
            } else if (primaryError == 2) {
                string = resources.getString(R.string.boxsdk_ssl_error_warning_ID_MISMATCH);
            } else if (primaryError == 3) {
                string = resources.getString(R.string.boxsdk_ssl_error_warning_UNTRUSTED);
            } else if (primaryError == 4) {
                string = webView.getResources().getString(R.string.boxsdk_ssl_error_warning_DATE_INVALID);
            } else {
                string = resources.getString(R.string.boxsdk_ssl_error_warning_INVALID);
            }
            sb.append(string);
            sb.append(" ");
            sb.append(resources.getString(R.string.boxsdk_ssl_should_not_proceed));
            this.sslErrorDialogContinueButtonClicked = false;
            new MaterialAlertDialogBuilder(webView.getContext()).setTitle(R.string.boxsdk_Security_Warning).setMessage((CharSequence) sb.toString()).setIcon(R.drawable.boxsdk_dialog_warning).setNegativeButton(R.string.boxsdk_Go_back, new DialogInterface.OnClickListener() { // from class: com.box.androidsdk.content.auth.OAuthWebView.OAuthWebViewClient.5
                @Override // android.content.DialogInterface.OnClickListener
                public void onClick(DialogInterface dialogInterface, int i) {
                    OAuthWebViewClient.this.sslErrorDialogContinueButtonClicked = true;
                    sslErrorHandler.cancel();
                    OAuthWebViewClient.this.mWebEventListener.onAuthFailure(new AuthFailure(0, null));
                }
            }).setNeutralButton(R.string.boxsdk_ssl_error_details, new DialogInterface.OnClickListener() { // from class: com.box.androidsdk.content.auth.OAuthWebView.OAuthWebViewClient.4
                @Override // android.content.DialogInterface.OnClickListener
                public void onClick(DialogInterface dialogInterface, int i) {
                    OAuthWebViewClient.this.showCertDialog(webView.getContext(), sslError);
                }
            }).setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: com.box.androidsdk.content.auth.OAuthWebView.OAuthWebViewClient.3
                @Override // android.content.DialogInterface.OnDismissListener
                public void onDismiss(DialogInterface dialogInterface) {
                    if (OAuthWebViewClient.this.sslErrorDialogContinueButtonClicked) {
                        return;
                    }
                    OAuthWebViewClient.this.mWebEventListener.onAuthFailure(new AuthFailure(0, null));
                }
            }).show();
        }

        protected void showCertDialog(Context context, SslError sslError) {
            new MaterialAlertDialogBuilder(context).setTitle(R.string.boxsdk_Security_Warning).setView(getCertErrorView(context, sslError.getCertificate())).show();
        }

        private View getCertErrorView(Context context, SslCertificate sslCertificate) {
            View viewInflate = LayoutInflater.from(context).inflate(R.layout.ssl_certificate, (ViewGroup) null);
            SslCertificate.DName issuedTo = sslCertificate.getIssuedTo();
            if (issuedTo != null) {
                ((TextView) viewInflate.findViewById(R.id.to_common)).setText(issuedTo.getCName());
                ((TextView) viewInflate.findViewById(R.id.to_org)).setText(issuedTo.getOName());
                ((TextView) viewInflate.findViewById(R.id.to_org_unit)).setText(issuedTo.getUName());
            }
            SslCertificate.DName issuedBy = sslCertificate.getIssuedBy();
            if (issuedBy != null) {
                ((TextView) viewInflate.findViewById(R.id.by_common)).setText(issuedBy.getCName());
                ((TextView) viewInflate.findViewById(R.id.by_org)).setText(issuedBy.getOName());
                ((TextView) viewInflate.findViewById(R.id.by_org_unit)).setText(issuedBy.getUName());
            }
            ((TextView) viewInflate.findViewById(R.id.issued_on)).setText(formatCertificateDate(context, sslCertificate.getValidNotBeforeDate()));
            ((TextView) viewInflate.findViewById(R.id.expires_on)).setText(formatCertificateDate(context, sslCertificate.getValidNotAfterDate()));
            return viewInflate;
        }

        private String formatCertificateDate(Context context, Date date) {
            if (date == null) {
                return "";
            }
            return DateFormat.getDateFormat(context).format(date);
        }

        public void destroy() {
            this.mWebEventListener = null;
        }

        protected Uri getURIfromURL(String str) {
            Uri uri = Uri.parse(str);
            if (!SdkUtils.isEmptyString(this.mRedirectUrl)) {
                Uri uri2 = Uri.parse(this.mRedirectUrl);
                if (uri2.getScheme() == null || !uri2.getScheme().equals(uri.getScheme()) || !uri2.getAuthority().equals(uri.getAuthority())) {
                    return null;
                }
            }
            return uri;
        }

        protected String getValueFromURI(Uri uri, String str) throws InvalidUrlException {
            if (uri == null) {
                return null;
            }
            try {
                return uri.getQueryParameter(str);
            } catch (Exception unused) {
                return null;
            }
        }

        public void setOnPageFinishedListener(OnPageFinishedListener onPageFinishedListener) {
            this.mOnPageFinishedListener = onPageFinishedListener;
        }

        class WebViewTimeOutRunnable implements Runnable {
            final String mFailingUrl;
            final WeakReference<WebView> mViewHolder;

            public WebViewTimeOutRunnable(WebView webView, String str) {
                this.mFailingUrl = str;
                this.mViewHolder = new WeakReference<>(webView);
            }

            @Override // java.lang.Runnable
            public void run() {
                OAuthWebViewClient.this.onReceivedError(this.mViewHolder.get(), -8, "loading timed out", this.mFailingUrl);
            }
        }
    }

    public static class AuthFailure {
        public static final int TYPE_AUTHENTICATION_UNAUTHORIZED = 3;
        public static final int TYPE_GENERIC = -1;
        public static final int TYPE_URL_MISMATCH = 1;
        public static final int TYPE_USER_INTERACTION = 0;
        public static final int TYPE_WEB_ERROR = 2;
        public WebViewException mWebException;
        public String message;
        public int type;

        public AuthFailure(int i, String str) {
            this.type = i;
            this.message = str;
        }

        public AuthFailure(WebViewException webViewException) {
            this(2, null);
            this.mWebException = webViewException;
        }
    }

    public static class WebViewException extends Exception {
        private final String mDescription;
        private final int mErrorCode;
        private final String mFailingUrl;

        public WebViewException(int i, String str, String str2) {
            this.mErrorCode = i;
            this.mDescription = str;
            this.mFailingUrl = str2;
        }

        public int getErrorCode() {
            return this.mErrorCode;
        }

        public String getDescription() {
            return this.mDescription;
        }

        public String getFailingUrl() {
            return this.mFailingUrl;
        }
    }
}
