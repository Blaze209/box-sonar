package com.google.androidbrowserhelper.trusted;

import android.content.ComponentName;
import android.content.Context;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.os.Bundle;
import androidx.browser.trusted.TrustedWebActivityDisplayMode;
import com.microsoft.intune.mam.client.content.pm.MAMPackageManagement;
import java.util.Arrays;
import java.util.List;

/* JADX INFO: loaded from: classes13.dex */
public class LauncherActivityMetadata {
    private static final int DEFAULT_COLOR_ID = 17170443;
    private static final int DEFAULT_DIVIDER_COLOR_ID = 17170445;
    private static final String METADATA_ADDITIONAL_TRUSTED_ORIGINS = "android.support.customtabs.trusted.ADDITIONAL_TRUSTED_ORIGINS";
    private static final String METADATA_DEFAULT_URL = "android.support.customtabs.trusted.DEFAULT_URL";
    private static final String METADATA_DISPLAY_MODE = "android.support.customtabs.trusted.DISPLAY_MODE";
    private static final String METADATA_FALLBACK_STRATEGY = "android.support.customtabs.trusted.FALLBACK_STRATEGY";
    private static final String METADATA_FILE_PROVIDER_AUTHORITY = "android.support.customtabs.trusted.FILE_PROVIDER_AUTHORITY";
    private static final String METADATA_NAVIGATION_BAR_COLOR_DARK_ID = "android.support.customtabs.trusted.NAVIGATION_BAR_COLOR_DARK";
    private static final String METADATA_NAVIGATION_BAR_COLOR_ID = "android.support.customtabs.trusted.NAVIGATION_BAR_COLOR";
    private static final String METADATA_NAVIGATION_BAR_DIVIDER_COLOR_DARK_ID = "androix.browser.trusted.NAVIGATION_BAR_DIVIDER_COLOR_DARK";
    private static final String METADATA_NAVIGATION_BAR_DIVIDER_COLOR_ID = "androix.browser.trusted.NAVIGATION_BAR_DIVIDER_COLOR";
    private static final String METADATA_SCREEN_ORIENTATION = "android.support.customtabs.trusted.SCREEN_ORIENTATION";
    private static final String METADATA_SHARE_TARGET = "android.support.customtabs.trusted.METADATA_SHARE_TARGET";
    private static final String METADATA_SPLASH_IMAGE_DRAWABLE_ID = "android.support.customtabs.trusted.SPLASH_IMAGE_DRAWABLE";
    private static final String METADATA_SPLASH_SCREEN_BACKGROUND_COLOR = "android.support.customtabs.trusted.SPLASH_SCREEN_BACKGROUND_COLOR";
    private static final String METADATA_SPLASH_SCREEN_FADE_OUT_DURATION = "android.support.customtabs.trusted.SPLASH_SCREEN_FADE_OUT_DURATION";
    private static final String METADATA_STATUS_BAR_COLOR_DARK_ID = "android.support.customtabs.trusted.STATUS_BAR_COLOR_DARK";
    private static final String METADATA_STATUS_BAR_COLOR_ID = "android.support.customtabs.trusted.STATUS_BAR_COLOR";
    private static final String TAG = "LauncherActivityMetadata";
    public final List<String> additionalTrustedOrigins;
    public final String defaultUrl;
    public final TrustedWebActivityDisplayMode displayMode;
    public final String fallbackStrategyType;
    public final String fileProviderAuthority;
    public final int navigationBarColorDarkId;
    public final int navigationBarColorId;
    public final int navigationBarDividerColorDarkId;
    public final int navigationBarDividerColorId;
    public final int screenOrientation;
    public final String shareTarget;
    public final int splashImageDrawableId;
    public final int splashScreenBackgroundColorId;
    public final int splashScreenFadeOutDurationMillis;
    public final int statusBarColorDarkId;
    public final int statusBarColorId;

    private LauncherActivityMetadata(Bundle bundle, Resources resources) {
        this.defaultUrl = bundle.getString(METADATA_DEFAULT_URL);
        int i = bundle.getInt(METADATA_STATUS_BAR_COLOR_ID, 17170443);
        this.statusBarColorId = i;
        this.statusBarColorDarkId = bundle.getInt(METADATA_STATUS_BAR_COLOR_DARK_ID, i);
        int i2 = bundle.getInt(METADATA_NAVIGATION_BAR_COLOR_ID, 17170443);
        this.navigationBarColorId = i2;
        this.navigationBarColorDarkId = bundle.getInt(METADATA_NAVIGATION_BAR_COLOR_DARK_ID, i2);
        this.navigationBarDividerColorId = bundle.getInt(METADATA_NAVIGATION_BAR_DIVIDER_COLOR_ID, 17170445);
        this.navigationBarDividerColorDarkId = bundle.getInt(METADATA_NAVIGATION_BAR_DIVIDER_COLOR_DARK_ID, i2);
        this.splashImageDrawableId = bundle.getInt(METADATA_SPLASH_IMAGE_DRAWABLE_ID, 0);
        this.splashScreenBackgroundColorId = bundle.getInt(METADATA_SPLASH_SCREEN_BACKGROUND_COLOR, 17170443);
        this.fileProviderAuthority = bundle.getString(METADATA_FILE_PROVIDER_AUTHORITY);
        this.splashScreenFadeOutDurationMillis = bundle.getInt(METADATA_SPLASH_SCREEN_FADE_OUT_DURATION, 0);
        if (bundle.containsKey(METADATA_ADDITIONAL_TRUSTED_ORIGINS)) {
            this.additionalTrustedOrigins = Arrays.asList(resources.getStringArray(bundle.getInt(METADATA_ADDITIONAL_TRUSTED_ORIGINS)));
        } else {
            this.additionalTrustedOrigins = null;
        }
        this.fallbackStrategyType = bundle.getString(METADATA_FALLBACK_STRATEGY);
        this.displayMode = getDisplayMode(bundle);
        this.screenOrientation = getOrientation(bundle.getString(METADATA_SCREEN_ORIENTATION));
        int i3 = bundle.getInt(METADATA_SHARE_TARGET, 0);
        this.shareTarget = i3 != 0 ? resources.getString(i3) : null;
    }

    private int getOrientation(String str) {
        if (str == null) {
            return 0;
        }
        str.hashCode();
        switch (str) {
            case "portrait-primary":
                return 1;
            case "landscape-secondary":
                return 4;
            case "any":
                return 5;
            case "portrait":
                return 7;
            case "landscape":
                return 6;
            case "natural":
                return 8;
            case "landscape-primary":
                return 3;
            case "portrait-secondary":
                return 2;
            default:
                return 0;
        }
    }

    private static TrustedWebActivityDisplayMode getDisplayMode(Bundle bundle) {
        String string = bundle.getString(METADATA_DISPLAY_MODE);
        if ("immersive".equals(string)) {
            return new TrustedWebActivityDisplayMode.ImmersiveMode(false, 0);
        }
        if ("sticky-immersive".equals(string)) {
            return new TrustedWebActivityDisplayMode.ImmersiveMode(true, 0);
        }
        return new TrustedWebActivityDisplayMode.DefaultMode();
    }

    public static LauncherActivityMetadata parse(Context context) {
        Bundle bundle;
        Resources resources = context.getResources();
        try {
            bundle = MAMPackageManagement.getActivityInfo(context.getPackageManager(), new ComponentName(context, context.getClass()), 128).metaData;
        } catch (PackageManager.NameNotFoundException unused) {
            bundle = null;
        }
        if (bundle == null) {
            bundle = new Bundle();
        }
        return new LauncherActivityMetadata(bundle, resources);
    }
}
