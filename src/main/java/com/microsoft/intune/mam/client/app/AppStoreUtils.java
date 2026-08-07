package com.microsoft.intune.mam.client.app;

import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.net.Uri;
import com.microsoft.intune.mam.client.content.pm.PackageManagerCompat;
import com.microsoft.intune.mam.client.telemetry.events.MAMInterfaceError;
import com.microsoft.intune.mam.http.KnownClouds;
import com.microsoft.intune.mam.log.MAMLogger;
import com.microsoft.intune.mam.log.MAMLoggerProvider;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

/* JADX INFO: loaded from: classes3.dex */
public final class AppStoreUtils {
    private static final String GOOGLE_PLAY_STORE = "com.android.vending";
    private static final String INSTALL_VIA_IWP = "https://go.microsoft.com/fwlink/?linkid=534633";
    private static final MAMLogger LOGGER = MAMLoggerProvider.getLogger(AppStoreUtils.class);
    private static final String MARKET_LINK = "market://details?id=";
    private static final String REFERRER = "&referrer=";
    private static final String SSP_DEEP_LINK = "market://details?id=com.microsoft.windowsintune.companyportal";

    private AppStoreUtils() {
    }

    public static void onClickInstallPortal(Context context) {
        onClickInstallPortal(null, context);
    }

    public static void onClickInstallPortal(String str, Context context) {
        String installationFWLink;
        Intent intent = new Intent("android.intent.action.VIEW");
        if (isGooglePlayEnabled(context)) {
            installationFWLink = "market://details?id=com.microsoft.windowsintune.companyportal&referrer=" + context.getPackageName();
        } else {
            installationFWLink = KnownClouds.fromAuthority(str).getInstallationFWLink();
        }
        intent.setData(Uri.parse(installationFWLink));
        intent.addFlags(268435456);
        try {
            context.startActivity(intent);
        } catch (ActivityNotFoundException e) {
            LOGGER.error(MAMInterfaceError.PLAY_STORE_NOT_FOUND, "Google Play Store not found, cannot redirect to install Company Portal.", e);
        }
    }

    public static void onClickInstallPortal(String str, DialogInterface dialogInterface, Context context) {
        onClickInstallPortal(str, context);
        dialogInterface.dismiss();
    }

    public static boolean isGooglePlayEnabled(Context context) {
        try {
            ApplicationInfo applicationInfo = PackageManagerCompat.getApplicationInfo(context.getPackageManager(), "com.android.vending", 0L);
            LOGGER.info("play store is: " + applicationInfo.enabled, new Object[0]);
            return applicationInfo.enabled;
        } catch (PackageManager.NameNotFoundException unused) {
            LOGGER.info("play store is not available", new Object[0]);
            return false;
        }
    }

    public static Intent getPlayLink(Context context, String str) {
        return getPlayLinkWithReferrer(context, str, null);
    }

    public static String getAppInstallationURI(Context context, String str) {
        if (isGooglePlayEnabled(context) || marketLinksHandled(context)) {
            LOGGER.info("directing IW to store", new Object[0]);
            return "market://details?id=" + str;
        }
        LOGGER.info("directing IW to IWP", new Object[0]);
        return INSTALL_VIA_IWP;
    }

    private static boolean marketLinksHandled(Context context) {
        if (PackageManagerCompat.queryIntentActivities(context.getPackageManager(), new Intent("android.intent.action.VIEW", Uri.parse("market://details?id=")), 0L).size() > 0) {
            LOGGER.info("device can handle market:// URIs", new Object[0]);
            return true;
        }
        LOGGER.info("device can not handle market:// URIs", new Object[0]);
        return false;
    }

    public static Intent getPlayLinkWithReferrer(Context context, String str, String str2) {
        String strEncode;
        StringBuilder sb = new StringBuilder(getAppInstallationURI(context, str));
        if (str2 != null) {
            try {
                strEncode = URLEncoder.encode(str2, "UTF-8");
            } catch (UnsupportedEncodingException e) {
                LOGGER.warning("Unsupported url encoding method UTF-8, falling back to system encoding.", e);
                strEncode = URLEncoder.encode(str2);
            }
            sb.append(REFERRER + strEncode);
        }
        Intent intent = new Intent("android.intent.action.VIEW");
        intent.setData(Uri.parse(sb.toString()));
        intent.addFlags(268435456);
        intent.setPackage("com.android.vending");
        return intent;
    }
}
