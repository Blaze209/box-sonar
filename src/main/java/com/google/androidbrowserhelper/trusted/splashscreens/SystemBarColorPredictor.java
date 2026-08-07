package com.google.androidbrowserhelper.trusted.splashscreens;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ResolveInfo;
import android.os.Bundle;
import androidx.browser.customtabs.CustomTabsIntent;
import androidx.browser.customtabs.CustomTabsService;
import androidx.browser.trusted.TrustedWebActivityIntentBuilder;
import com.google.androidbrowserhelper.trusted.ChromeLegacyUtils;
import com.microsoft.intune.mam.client.content.pm.MAMPackageManagement;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes13.dex */
class SystemBarColorPredictor {
    private Map<String, SupportedFeatures> mSupportedFeaturesCache = new HashMap();

    SystemBarColorPredictor() {
    }

    Integer getExpectedStatusBarColor(Context context, String str, TrustedWebActivityIntentBuilder trustedWebActivityIntentBuilder) {
        Intent intent = trustedWebActivityIntentBuilder.buildCustomTabsIntent().intent;
        if (providerSupportsColorSchemeParams(context, str)) {
            return CustomTabsIntent.getColorSchemeParams(intent, getExpectedColorScheme(context, trustedWebActivityIntentBuilder)).toolbarColor;
        }
        Bundle extras = intent.getExtras();
        if (extras == null) {
            return null;
        }
        return (Integer) extras.get(CustomTabsIntent.EXTRA_TOOLBAR_COLOR);
    }

    Integer getExpectedNavbarColor(Context context, String str, TrustedWebActivityIntentBuilder trustedWebActivityIntentBuilder) {
        Intent intent = trustedWebActivityIntentBuilder.buildCustomTabsIntent().intent;
        if (!providerSupportsNavBarColorCustomization(context, str)) {
            return ChromeLegacyUtils.usesWhiteNavbar(str) ? -1 : null;
        }
        if (providerSupportsColorSchemeParams(context, str)) {
            return CustomTabsIntent.getColorSchemeParams(intent, getExpectedColorScheme(context, trustedWebActivityIntentBuilder)).navigationBarColor;
        }
        Bundle extras = intent.getExtras();
        if (extras == null) {
            return null;
        }
        return (Integer) extras.get(CustomTabsIntent.EXTRA_NAVIGATION_BAR_COLOR);
    }

    private boolean providerSupportsNavBarColorCustomization(Context context, String str) {
        return getSupportedFeatures(context, str).navbarColorCustomization;
    }

    private boolean providerSupportsColorSchemeParams(Context context, String str) {
        return getSupportedFeatures(context, str).colorSchemeCustomization;
    }

    private SupportedFeatures getSupportedFeatures(Context context, String str) {
        SupportedFeatures supportedFeatures = this.mSupportedFeaturesCache.get(str);
        if (supportedFeatures != null) {
            return supportedFeatures;
        }
        if (ChromeLegacyUtils.supportsNavbarAndColorCustomization(context.getPackageManager(), str)) {
            boolean z = true;
            SupportedFeatures supportedFeatures2 = new SupportedFeatures(z, z);
            this.mSupportedFeaturesCache.put(str, supportedFeatures2);
            return supportedFeatures2;
        }
        ResolveInfo resolveInfoResolveService = MAMPackageManagement.resolveService(context.getPackageManager(), new Intent().setAction(CustomTabsService.ACTION_CUSTOM_TABS_CONNECTION).setPackage(str), 64);
        SupportedFeatures supportedFeatures3 = new SupportedFeatures(hasCategory(resolveInfoResolveService, CustomTabsService.CATEGORY_NAVBAR_COLOR_CUSTOMIZATION), hasCategory(resolveInfoResolveService, CustomTabsService.CATEGORY_COLOR_SCHEME_CUSTOMIZATION));
        this.mSupportedFeaturesCache.put(str, supportedFeatures3);
        return supportedFeatures3;
    }

    private static boolean hasCategory(ResolveInfo resolveInfo, String str) {
        return (resolveInfo == null || resolveInfo.filter == null || !resolveInfo.filter.hasCategory(str)) ? false : true;
    }

    private static int getExpectedColorScheme(Context context, TrustedWebActivityIntentBuilder trustedWebActivityIntentBuilder) {
        Bundle extras = trustedWebActivityIntentBuilder.buildCustomTabsIntent().intent.getExtras();
        Integer num = extras == null ? null : (Integer) extras.get(CustomTabsIntent.EXTRA_COLOR_SCHEME);
        if (num == null || num.intValue() == 0) {
            return (context.getResources().getConfiguration().uiMode & 48) == 32 ? 2 : 1;
        }
        return num.intValue();
    }

    private static class SupportedFeatures {
        public final boolean colorSchemeCustomization;
        public final boolean navbarColorCustomization;

        private SupportedFeatures(boolean z, boolean z2) {
            this.navbarColorCustomization = z;
            this.colorSchemeCustomization = z2;
        }
    }
}
