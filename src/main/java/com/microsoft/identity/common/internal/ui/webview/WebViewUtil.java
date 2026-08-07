package com.microsoft.identity.common.internal.ui.webview;

import android.content.Context;
import android.webkit.CookieManager;
import android.webkit.WebView;

/* JADX INFO: loaded from: classes14.dex */
public class WebViewUtil {
    public static void setDataDirectorySuffix(Context context) {
        try {
            if (ProcessUtil.isRunningOnAuthService(context)) {
                WebView.setDataDirectorySuffix(ProcessUtil.AuthServiceProcess);
            }
        } catch (IllegalStateException unused) {
        }
    }

    public static void setAcceptCookie(boolean z, Context context) {
        getCookieManager(context).setAcceptCookie(z);
    }

    public static void removeCookiesFromWebView(Context context) {
        CookieManager cookieManager = getCookieManager(context);
        cookieManager.removeAllCookies(null);
        cookieManager.flush();
    }

    public static void removeSessionCookiesFromWebView(Context context) {
        CookieManager cookieManager = getCookieManager(context);
        cookieManager.removeAllCookies(null);
        cookieManager.flush();
    }

    private static CookieManager getCookieManager(Context context) {
        setDataDirectorySuffix(context);
        return CookieManager.getInstance();
    }
}
