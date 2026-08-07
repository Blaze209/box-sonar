package com.box.android.base.presentation.views;

import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Bitmap;
import android.net.Uri;
import android.net.http.SslError;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.HttpAuthHandler;
import android.webkit.SslErrorHandler;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.EditText;
import com.box.android.base.R;
import com.box.androidsdk.content.utils.BoxLogUtils;
import com.google.android.material.dialog.MaterialAlertDialogBuilder;
import com.microsoft.identity.nativeauth.statemachine.errors.ErrorTypes;
import com.microsoft.intune.mam.client.widget.MAMWebView;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.UUID;
import org.apache.commons.lang3.StringUtils;

/* JADX INFO: loaded from: classes9.dex */
public class BoxSDKOAuthWebView extends MAMWebView {
    private static final String STATE = "state";
    private String mState;

    public interface AuthListener {
        void onAuthFailure(AuthFailure authFailure);

        void onReceivedAuthCode(String str);
    }

    public interface OnPageFinishedListener {
        void onPageFinished(WebView webView, String str);
    }

    public BoxSDKOAuthWebView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public String getStateString() {
        return this.mState;
    }

    public void authenticate(String str, String str2) {
        this.mState = generateStateToken();
        loadUrl(buildUrl(str, str2).build().toString());
    }

    public static String generateStateToken() {
        try {
            return URLEncoder.encode(UUID.randomUUID().toString(), "utf-8");
        } catch (UnsupportedEncodingException e) {
            BoxLogUtils.logException(e);
            return UUID.randomUUID().toString();
        }
    }

    protected Uri.Builder buildUrl(String str, String str2) {
        Uri.Builder builder = new Uri.Builder();
        builder.scheme("https");
        builder.authority("account.box.com");
        builder.appendPath("api");
        builder.appendPath("oauth2");
        builder.appendPath("authorize");
        builder.appendQueryParameter("response_type", "code");
        builder.appendQueryParameter("client_id", str);
        builder.appendQueryParameter("redirect_uri", str2);
        builder.appendQueryParameter("state", this.mState);
        return builder;
    }

    public static class OAuthWebViewClient extends WebViewClient {
        private AuthListener mActivity;
        private OnPageFinishedListener mOnPageFinishedListener;
        private String mRedirectUrl;
        private String state;

        public OAuthWebViewClient(AuthListener authListener, String str, String str2) {
            this.mActivity = authListener;
            this.mRedirectUrl = str;
            this.state = str2;
        }

        @Override // android.webkit.WebViewClient
        public void onPageStarted(WebView webView, String str, Bitmap bitmap) {
            try {
                String codeFromUrl = getCodeFromUrl(str);
                if (StringUtils.isEmpty(codeFromUrl)) {
                    return;
                }
                this.mActivity.onReceivedAuthCode(codeFromUrl);
            } catch (InvalidUrlException e) {
                this.mActivity.onAuthFailure(new AuthFailure(1, e.getMessage()));
            }
        }

        @Override // android.webkit.WebViewClient
        public void onPageFinished(WebView webView, String str) {
            super.onPageFinished(webView, str);
            OnPageFinishedListener onPageFinishedListener = this.mOnPageFinishedListener;
            if (onPageFinishedListener != null) {
                onPageFinishedListener.onPageFinished(webView, str);
            }
        }

        @Override // android.webkit.WebViewClient
        public void onReceivedHttpAuthRequest(WebView webView, final HttpAuthHandler httpAuthHandler, String str, String str2) {
            final View viewInflate = LayoutInflater.from(webView.getContext()).inflate(R.layout.boxsdk_alert_dialog_text_entry, (ViewGroup) null);
            new MaterialAlertDialogBuilder(webView.getContext()).setTitle(R.string.alert_dialog_text_entry).setView(viewInflate).setPositiveButton(R.string.alert_dialog_ok, new DialogInterface.OnClickListener() { // from class: com.box.android.base.presentation.views.BoxSDKOAuthWebView.OAuthWebViewClient.2
                @Override // android.content.DialogInterface.OnClickListener
                public void onClick(DialogInterface dialogInterface, int i) {
                    httpAuthHandler.proceed(((EditText) viewInflate.findViewById(R.id.username_edit)).getText().toString(), ((EditText) viewInflate.findViewById(R.id.password_edit)).getText().toString());
                }
            }).setNegativeButton(R.string.alert_dialog_cancel, new DialogInterface.OnClickListener() { // from class: com.box.android.base.presentation.views.BoxSDKOAuthWebView.OAuthWebViewClient.1
                @Override // android.content.DialogInterface.OnClickListener
                public void onClick(DialogInterface dialogInterface, int i) {
                    httpAuthHandler.cancel();
                    OAuthWebViewClient.this.mActivity.onAuthFailure(new AuthFailure(0, null));
                }
            }).show();
        }

        @Override // android.webkit.WebViewClient
        public void onReceivedError(WebView webView, int i, String str, String str2) {
            this.mActivity.onAuthFailure(new AuthFailure(2, Integer.toString(i)));
        }

        @Override // android.webkit.WebViewClient
        public void onReceivedSslError(WebView webView, SslErrorHandler sslErrorHandler, SslError sslError) {
            this.mActivity.onAuthFailure(new AuthFailure(0, null));
        }

        public void destroy() {
            this.mActivity = null;
        }

        private String getCodeFromUrl(String str) throws InvalidUrlException {
            Uri uri = Uri.parse(str);
            String queryParameter = null;
            if (!StringUtils.isEmpty(this.mRedirectUrl)) {
                Uri uri2 = Uri.parse(this.mRedirectUrl);
                if (uri2.getScheme() == null || !uri2.getScheme().equals(uri.getScheme()) || !uri2.getAuthority().equals(uri.getAuthority())) {
                    return null;
                }
            }
            try {
                queryParameter = uri.getQueryParameter("code");
            } catch (Exception unused) {
            }
            if (!StringUtils.isEmpty(queryParameter)) {
                if (!StringUtils.isEmpty(this.state)) {
                    if (!this.state.equals(uri.getQueryParameter("state"))) {
                        throw new InvalidUrlException(ErrorTypes.INVALID_STATE);
                    }
                }
            } else {
                String queryParameter2 = uri.getQueryParameter("error");
                if (!StringUtils.isEmpty(queryParameter2)) {
                    throw new InvalidUrlException(queryParameter2);
                }
            }
            return queryParameter;
        }

        public void setOnPageFinishedListener(OnPageFinishedListener onPageFinishedListener) {
            this.mOnPageFinishedListener = onPageFinishedListener;
        }
    }

    private static class InvalidUrlException extends Exception {
        private static final long serialVersionUID = 1;

        public InvalidUrlException(String str) {
            super(str);
        }
    }

    public static class AuthFailure {
        public static final int TYPE_URL_MISMATCH = 1;
        public static final int TYPE_USER_INTERACTION = 0;
        public static final int TYPE_WEB_ERROR = 2;
        public String message;
        public int type;

        public AuthFailure(int i, String str) {
            this.type = i;
            this.message = str;
        }
    }
}
