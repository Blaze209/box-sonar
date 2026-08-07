package com.google.androidbrowserhelper.trusted;

import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.view.ViewGroup;
import android.webkit.RenderProcessGoneDetail;
import android.webkit.WebResourceRequest;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Toast;
import androidx.browser.customtabs.CustomTabsIntent;
import androidx.core.content.ContextCompat;
import com.microsoft.intune.mam.client.app.MAMActivity;
import com.microsoft.intune.mam.client.widget.MAMWebView;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes13.dex */
public class WebViewFallbackActivity extends MAMActivity {
    private static final String KEY_EXTRA_ORIGINS = "com.google.browser.examples.twawebviewfallback.WebViewFallbackActivity.KEY_EXTRA_ORIGINS";
    private static final String KEY_LAUNCH_URI = "com.google.browser.examples.twawebviewfallback.WebViewFallbackActivity.LAUNCH_URL";
    private static final String KEY_NAVIGATION_BAR_COLOR = "com.google.browser.examples.twawebviewfallback.WebViewFallbackActivity.KEY_NAVIGATION_BAR_COLOR";
    private static final String KEY_PREFIX = "com.google.browser.examples.twawebviewfallback.WebViewFallbackActivity.";
    private static final String KEY_STATUS_BAR_COLOR = "com.google.browser.examples.twawebviewfallback.WebViewFallbackActivity.KEY_STATUS_BAR_COLOR";
    private static final String TAG = "WebViewFallbackActivity";
    private List<Uri> mExtraOrigins = new ArrayList();
    private Uri mLaunchUrl;
    private int mStatusBarColor;
    private WebView mWebView;

    public static Intent createLaunchIntent(Context context, Uri uri, LauncherActivityMetadata launcherActivityMetadata) {
        Intent intent = new Intent(context, (Class<?>) WebViewFallbackActivity.class);
        intent.putExtra(KEY_LAUNCH_URI, uri);
        intent.putExtra(KEY_STATUS_BAR_COLOR, ContextCompat.getColor(context, launcherActivityMetadata.statusBarColorId));
        intent.putExtra(KEY_NAVIGATION_BAR_COLOR, ContextCompat.getColor(context, launcherActivityMetadata.navigationBarColorId));
        if (launcherActivityMetadata.additionalTrustedOrigins != null) {
            intent.putStringArrayListExtra(KEY_EXTRA_ORIGINS, new ArrayList<>(launcherActivityMetadata.additionalTrustedOrigins));
        }
        return intent;
    }

    @Override // com.microsoft.intune.mam.client.app.MAMActivity, com.microsoft.intune.mam.client.app.HookedActivity
    public void onMAMCreate(Bundle bundle) {
        ArrayList<String> stringArrayListExtra;
        super.onMAMCreate(bundle);
        Uri uri = (Uri) getIntent().getParcelableExtra(KEY_LAUNCH_URI);
        this.mLaunchUrl = uri;
        if (!"https".equals(uri.getScheme())) {
            throw new IllegalArgumentException("launchUrl scheme must be 'https'");
        }
        if (getIntent().hasExtra(KEY_NAVIGATION_BAR_COLOR)) {
            getWindow().setNavigationBarColor(getIntent().getIntExtra(KEY_NAVIGATION_BAR_COLOR, 0));
        }
        if (getIntent().hasExtra(KEY_STATUS_BAR_COLOR)) {
            this.mStatusBarColor = getIntent().getIntExtra(KEY_STATUS_BAR_COLOR, 0);
            getWindow().setStatusBarColor(this.mStatusBarColor);
        } else {
            this.mStatusBarColor = getWindow().getStatusBarColor();
        }
        if (getIntent().hasExtra(KEY_EXTRA_ORIGINS) && (stringArrayListExtra = getIntent().getStringArrayListExtra(KEY_EXTRA_ORIGINS)) != null) {
            for (String str : stringArrayListExtra) {
                Uri uri2 = Uri.parse(str);
                if (!"https".equalsIgnoreCase(uri2.getScheme())) {
                    Log.w(TAG, "Only 'https' origins are accepted. Ignoring extra origin: " + str);
                } else {
                    this.mExtraOrigins.add(uri2);
                }
            }
        }
        MAMWebView mAMWebView = new MAMWebView(this);
        this.mWebView = mAMWebView;
        mAMWebView.setWebViewClient(createWebViewClient());
        setupWebSettings(this.mWebView.getSettings());
        setContentView(this.mWebView, new ViewGroup.LayoutParams(-1, -1));
        if (bundle != null) {
            this.mWebView.restoreState(bundle);
            return;
        }
        HashMap map = new HashMap();
        map.put("Referer", "android-app://" + getPackageName() + "/");
        this.mWebView.loadUrl(this.mLaunchUrl.toString(), map);
    }

    @Override // android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4 && this.mWebView.canGoBack()) {
            this.mWebView.goBack();
            return true;
        }
        return super.onKeyDown(i, keyEvent);
    }

    @Override // com.microsoft.intune.mam.client.app.MAMActivity, com.microsoft.intune.mam.client.app.HookedActivity
    public void onMAMPause() {
        super.onMAMPause();
        WebView webView = this.mWebView;
        if (webView != null) {
            webView.onPause();
        }
    }

    @Override // com.microsoft.intune.mam.client.app.MAMActivity, com.microsoft.intune.mam.client.app.HookedActivity
    public void onMAMResume() {
        super.onMAMResume();
        WebView webView = this.mWebView;
        if (webView != null) {
            webView.onResume();
        }
    }

    @Override // com.microsoft.intune.mam.client.app.MAMActivity, com.microsoft.intune.mam.client.app.HookedActivity
    public void onMAMSaveInstanceState(Bundle bundle) {
        super.onMAMSaveInstanceState(bundle);
        WebView webView = this.mWebView;
        if (webView != null) {
            webView.saveState(bundle);
        }
    }

    @Override // android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
    }

    private WebViewClient createWebViewClient() {
        return new WebViewClient() { // from class: com.google.androidbrowserhelper.trusted.WebViewFallbackActivity.1
            @Override // android.webkit.WebViewClient
            public boolean onRenderProcessGone(WebView webView, RenderProcessGoneDetail renderProcessGoneDetail) {
                ViewGroup viewGroup = (ViewGroup) webView.getParent();
                viewGroup.removeView(webView);
                webView.destroy();
                WebViewFallbackActivity.this.mWebView = new MAMWebView(webView.getContext());
                WebViewFallbackActivity.this.mWebView.setWebViewClient(this);
                WebViewFallbackActivity.setupWebSettings(WebViewFallbackActivity.this.mWebView.getSettings());
                viewGroup.addView(WebViewFallbackActivity.this.mWebView);
                Toast.makeText(webView.getContext(), "Recovering from crash", 1).show();
                WebViewFallbackActivity.this.mWebView.loadUrl(WebViewFallbackActivity.this.mLaunchUrl.toString());
                return true;
            }

            private boolean shouldOverrideUrlLoading(Uri uri) {
                Uri uri2 = WebViewFallbackActivity.this.mLaunchUrl;
                if (!"data".equals(uri.getScheme()) && !uriOriginsMatch(uri, uri2) && !matchExtraOrigins(uri)) {
                    try {
                        new CustomTabsIntent.Builder().setToolbarColor(WebViewFallbackActivity.this.mStatusBarColor).build().launchUrl(WebViewFallbackActivity.this, uri);
                        return true;
                    } catch (ActivityNotFoundException unused) {
                        Log.e(WebViewFallbackActivity.TAG, String.format("ActivityNotFoundException while launching '%s'", uri));
                    }
                }
                return false;
            }

            @Override // android.webkit.WebViewClient
            public boolean shouldOverrideUrlLoading(WebView webView, String str) {
                return shouldOverrideUrlLoading(Uri.parse(str));
            }

            @Override // android.webkit.WebViewClient
            public boolean shouldOverrideUrlLoading(WebView webView, WebResourceRequest webResourceRequest) {
                return shouldOverrideUrlLoading(webResourceRequest.getUrl());
            }

            private boolean matchExtraOrigins(Uri uri) {
                Iterator it = WebViewFallbackActivity.this.mExtraOrigins.iterator();
                while (it.hasNext()) {
                    if (uriOriginsMatch((Uri) it.next(), uri)) {
                        return true;
                    }
                }
                return false;
            }

            private boolean uriOriginsMatch(Uri uri, Uri uri2) {
                return uri.getScheme().equalsIgnoreCase(uri2.getScheme()) && uri.getHost().equalsIgnoreCase(uri2.getHost()) && uri.getPort() == uri2.getPort();
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void setupWebSettings(WebSettings webSettings) {
        webSettings.setJavaScriptEnabled(true);
        webSettings.setDomStorageEnabled(true);
        webSettings.setDatabaseEnabled(true);
    }
}
