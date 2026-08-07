package com.google.androidbrowserhelper.trusted;

import android.content.Intent;
import android.graphics.Matrix;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import androidx.browser.customtabs.CustomTabColorSchemeParams;
import androidx.browser.customtabs.CustomTabsCallback;
import androidx.browser.trusted.TrustedWebActivityDisplayMode;
import androidx.browser.trusted.TrustedWebActivityIntentBuilder;
import androidx.browser.trusted.sharing.ShareData;
import androidx.core.content.ContextCompat;
import com.google.androidbrowserhelper.trusted.splashscreens.PwaWrapperSplashScreenStrategy;
import com.microsoft.intune.mam.client.app.MAMActivity;
import org.json.JSONException;

/* JADX INFO: loaded from: classes13.dex */
public class LauncherActivity extends MAMActivity {
    private static final String BROWSER_WAS_LAUNCHED_KEY = "android.support.customtabs.trusted.BROWSER_WAS_LAUNCHED_KEY";
    private static final String FALLBACK_TYPE_WEBVIEW = "webview";
    private static final String TAG = "TWALauncherActivity";
    private static boolean sChromeVersionChecked;
    private static int sLauncherActivitiesAlive;
    private boolean mBrowserWasLaunched;
    private CustomTabsCallback mCustomTabsCallback = new QualityEnforcer();
    private LauncherActivityMetadata mMetadata;
    private PwaWrapperSplashScreenStrategy mSplashScreenStrategy;
    private TwaLauncher mTwaLauncher;

    protected Matrix getSplashImageTransformationMatrix() {
        return null;
    }

    protected boolean shouldLaunchImmediately() {
        return true;
    }

    @Override // com.microsoft.intune.mam.client.app.MAMActivity, com.microsoft.intune.mam.client.app.HookedActivity
    public void onMAMCreate(Bundle bundle) {
        LauncherActivity launcherActivity;
        super.onMAMCreate(bundle);
        int i = sLauncherActivitiesAlive + 1;
        sLauncherActivitiesAlive = i;
        boolean z = i > 1;
        boolean z2 = getIntent().getData() != null;
        boolean zIsShareIntent = SharingUtils.isShareIntent(getIntent());
        if (z && !z2 && !zIsShareIntent) {
            finish();
            return;
        }
        if (restartInNewTask()) {
            finish();
            return;
        }
        if (bundle != null && bundle.getBoolean(BROWSER_WAS_LAUNCHED_KEY)) {
            finish();
            return;
        }
        this.mMetadata = LauncherActivityMetadata.parse(this);
        if (splashScreenNeeded()) {
            launcherActivity = this;
            launcherActivity.mSplashScreenStrategy = new PwaWrapperSplashScreenStrategy(launcherActivity, this.mMetadata.splashImageDrawableId, getColorCompat(this.mMetadata.splashScreenBackgroundColorId), getSplashImageScaleType(), getSplashImageTransformationMatrix(), this.mMetadata.splashScreenFadeOutDurationMillis, this.mMetadata.fileProviderAuthority);
        } else {
            launcherActivity = this;
        }
        if (launcherActivity.shouldLaunchImmediately()) {
            launcherActivity.launchTwa();
        }
    }

    protected void launchTwa() {
        if (isFinishing()) {
            Log.d(TAG, "Aborting launchTwa() as Activity is finishing");
            return;
        }
        TrustedWebActivityIntentBuilder screenOrientation = new TrustedWebActivityIntentBuilder(getLaunchingUrl()).setToolbarColor(getColorCompat(this.mMetadata.statusBarColorId)).setNavigationBarColor(getColorCompat(this.mMetadata.navigationBarColorId)).setNavigationBarDividerColor(getColorCompat(this.mMetadata.navigationBarDividerColorId)).setColorScheme(0).setColorSchemeParams(2, new CustomTabColorSchemeParams.Builder().setToolbarColor(getColorCompat(this.mMetadata.statusBarColorDarkId)).setNavigationBarColor(getColorCompat(this.mMetadata.navigationBarColorDarkId)).setNavigationBarDividerColor(getColorCompat(this.mMetadata.navigationBarDividerColorDarkId)).build()).setDisplayMode(getDisplayMode()).setScreenOrientation(this.mMetadata.screenOrientation);
        if (this.mMetadata.additionalTrustedOrigins != null) {
            screenOrientation.setAdditionalTrustedOrigins(this.mMetadata.additionalTrustedOrigins);
        }
        addShareDataIfPresent(screenOrientation);
        TwaLauncher twaLauncherCreateTwaLauncher = createTwaLauncher();
        this.mTwaLauncher = twaLauncherCreateTwaLauncher;
        twaLauncherCreateTwaLauncher.launch(screenOrientation, this.mCustomTabsCallback, this.mSplashScreenStrategy, new Runnable() { // from class: com.google.androidbrowserhelper.trusted.LauncherActivity$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.m13725x9a3728ed();
            }
        }, getFallbackStrategy());
        if (!sChromeVersionChecked) {
            ChromeUpdatePrompt.promptIfNeeded(this, this.mTwaLauncher.getProviderPackage());
            sChromeVersionChecked = true;
        }
        if (ChromeOsSupport.isRunningOnArc(getApplicationContext().getPackageManager())) {
            new TwaSharedPreferencesManager(this).writeLastLaunchedProviderPackageName(ChromeOsSupport.ARC_PAYMENT_APP);
        } else {
            new TwaSharedPreferencesManager(this).writeLastLaunchedProviderPackageName(this.mTwaLauncher.getProviderPackage());
        }
        ManageDataLauncherActivity.addSiteSettingsShortcut(this, this.mTwaLauncher.getProviderPackage());
    }

    /* JADX INFO: renamed from: lambda$launchTwa$0$com-google-androidbrowserhelper-trusted-LauncherActivity, reason: not valid java name */
    /* synthetic */ void m13725x9a3728ed() {
        this.mBrowserWasLaunched = true;
    }

    protected TwaLauncher createTwaLauncher() {
        return new TwaLauncher(this);
    }

    private boolean splashScreenNeeded() {
        if (this.mMetadata.splashImageDrawableId == 0) {
            return false;
        }
        return isTaskRoot();
    }

    private void addShareDataIfPresent(TrustedWebActivityIntentBuilder trustedWebActivityIntentBuilder) {
        ShareData shareDataRetrieveShareDataFromIntent = SharingUtils.retrieveShareDataFromIntent(getIntent());
        if (shareDataRetrieveShareDataFromIntent == null) {
            return;
        }
        if (this.mMetadata.shareTarget == null) {
            Log.d(TAG, "Failed to share: share target not defined in the AndroidManifest");
            return;
        }
        try {
            trustedWebActivityIntentBuilder.setShareParams(SharingUtils.parseShareTargetJson(this.mMetadata.shareTarget), shareDataRetrieveShareDataFromIntent);
        } catch (JSONException e) {
            Log.d(TAG, "Failed to parse share target json: " + e.toString());
        }
    }

    protected ImageView.ScaleType getSplashImageScaleType() {
        return ImageView.ScaleType.CENTER;
    }

    private int getColorCompat(int i) {
        return ContextCompat.getColor(this, i);
    }

    @Override // android.app.Activity
    protected void onRestart() {
        super.onRestart();
        if (this.mBrowserWasLaunched) {
            finish();
        }
    }

    @Override // com.microsoft.intune.mam.client.app.MAMActivity, com.microsoft.intune.mam.client.app.HookedActivity
    public void onMAMDestroy() {
        super.onMAMDestroy();
        sLauncherActivitiesAlive--;
        TwaLauncher twaLauncher = this.mTwaLauncher;
        if (twaLauncher != null) {
            twaLauncher.destroy();
        }
        PwaWrapperSplashScreenStrategy pwaWrapperSplashScreenStrategy = this.mSplashScreenStrategy;
        if (pwaWrapperSplashScreenStrategy != null) {
            pwaWrapperSplashScreenStrategy.destroy();
        }
    }

    @Override // com.microsoft.intune.mam.client.app.MAMActivity, com.microsoft.intune.mam.client.app.HookedActivity
    public void onMAMSaveInstanceState(Bundle bundle) {
        super.onMAMSaveInstanceState(bundle);
        bundle.putBoolean(BROWSER_WAS_LAUNCHED_KEY, this.mBrowserWasLaunched);
    }

    @Override // android.app.Activity
    public void onEnterAnimationComplete() {
        super.onEnterAnimationComplete();
        PwaWrapperSplashScreenStrategy pwaWrapperSplashScreenStrategy = this.mSplashScreenStrategy;
        if (pwaWrapperSplashScreenStrategy != null) {
            pwaWrapperSplashScreenStrategy.onActivityEnterAnimationComplete();
        }
    }

    protected Uri getLaunchingUrl() {
        Uri data = getIntent().getData();
        if (data != null) {
            Log.d(TAG, "Using URL from Intent (" + data + ").");
            return data;
        }
        if (this.mMetadata.defaultUrl != null) {
            Log.d(TAG, "Using URL from Manifest (" + this.mMetadata.defaultUrl + ").");
            return Uri.parse(this.mMetadata.defaultUrl);
        }
        return Uri.parse("https://www.example.com/");
    }

    protected TwaLauncher.FallbackStrategy getFallbackStrategy() {
        if (FALLBACK_TYPE_WEBVIEW.equalsIgnoreCase(this.mMetadata.fallbackStrategyType)) {
            return TwaLauncher.WEBVIEW_FALLBACK_STRATEGY;
        }
        return TwaLauncher.CCT_FALLBACK_STRATEGY;
    }

    protected TrustedWebActivityDisplayMode getDisplayMode() {
        return this.mMetadata.displayMode;
    }

    private boolean restartInNewTask() {
        boolean z = (getIntent().getFlags() & 268435456) != 0;
        boolean z2 = (getIntent().getFlags() & 524288) != 0;
        if (z && !z2) {
            return false;
        }
        Intent intent = new Intent(getIntent());
        intent.setFlags((268435456 | getIntent().getFlags()) & (-524289));
        startActivity(intent);
        return true;
    }
}
