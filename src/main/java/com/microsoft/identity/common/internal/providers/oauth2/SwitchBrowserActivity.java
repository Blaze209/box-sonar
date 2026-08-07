package com.microsoft.identity.common.internal.providers.oauth2;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import androidx.fragment.app.FragmentActivity;
import com.microsoft.identity.common.internal.ui.browser.CustomTabsManager;
import com.microsoft.identity.common.logging.Logger;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: compiled from: SwitchBrowserActivity.kt */
/* JADX INFO: loaded from: classes14.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 \u00112\u00020\u0001:\u0001\u0011B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u0007\u001a\u00020\bH\u0002J\u0012\u0010\t\u001a\u00020\b2\b\u0010\n\u001a\u0004\u0018\u00010\u000bH\u0014J\b\u0010\f\u001a\u00020\bH\u0014J\u0012\u0010\r\u001a\u00020\b2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fH\u0014J\b\u0010\u0010\u001a\u00020\bH\u0014R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0012"}, d2 = {"Lcom/microsoft/identity/common/internal/providers/oauth2/SwitchBrowserActivity;", "Landroidx/fragment/app/FragmentActivity;", "()V", "cctLaunched", "", "customTabsManager", "Lcom/microsoft/identity/common/internal/ui/browser/CustomTabsManager;", "launchBrowser", "", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "onNewIntent", "intent", "Landroid/content/Intent;", "onResume", "Companion", "common_distRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class SwitchBrowserActivity extends FragmentActivity {
    public static final String BROWSER_PACKAGE_NAME = "browser_package_name";
    public static final String BROWSER_SUPPORTS_CUSTOM_TABS = "browser_supports_custom_tabs";
    public static final String PROCESS_URI = "process_uri";
    public static final String RESUME_REQUEST = "resume_request";
    private static final String TAG;
    private boolean cctLaunched;
    private CustomTabsManager customTabsManager = new CustomTabsManager(this);

    static {
        Intrinsics.checkNotNullExpressionValue("SwitchBrowserActivity", "SwitchBrowserActivity::class.java.simpleName");
        TAG = "SwitchBrowserActivity";
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, com.microsoft.intune.mam.client.app.MAMActivity, com.microsoft.intune.mam.client.app.HookedActivity
    public void onMAMCreate(Bundle bundle) {
        String str = TAG + ":onCreate";
        super.onMAMCreate(bundle);
        Logger.info(str, "SwitchBrowserActivity created - Launching browser");
        launchBrowser();
    }

    private final void launchBrowser() {
        Intent intent;
        String str = TAG + ":launchBrowser";
        this.cctLaunched = false;
        Bundle extras = getIntent().getExtras();
        if (extras == null) {
            extras = new Bundle();
        }
        String string = extras.getString(BROWSER_PACKAGE_NAME);
        boolean z = extras.getBoolean(BROWSER_SUPPORTS_CUSTOM_TABS, false);
        String string2 = extras.getString(PROCESS_URI);
        String str2 = string;
        if (str2 == null || StringsKt.isBlank(str2)) {
            Logger.error(str, "No browser package name found in extras - Cannot proceed with browser switch", null);
            finish();
            return;
        }
        String str3 = string2;
        if (str3 == null || StringsKt.isBlank(str3)) {
            Logger.error(str, "No process URI found in extras - Cannot proceed with browser switch", null);
            finish();
            return;
        }
        Logger.info(str, "Launching switch browser request on browser: " + string + ", Custom Tabs supported: " + z);
        if (z) {
            Logger.info(str, "CustomTabsService is supported.");
            if (!this.customTabsManager.bind(this, string)) {
                Logger.warn(str, "Failed to bind CustomTabsService.");
                intent = new Intent("android.intent.action.VIEW");
            } else {
                intent = this.customTabsManager.getCustomTabsIntent().intent;
                Intrinsics.checkNotNullExpressionValue(intent, "customTabsManager.customTabsIntent.intent");
            }
        } else {
            Logger.warn(str, "CustomTabsService is NOT supported");
            intent = new Intent("android.intent.action.VIEW");
            intent.setPackage(string);
        }
        Uri uri = Uri.parse(string2);
        Intrinsics.checkExpressionValueIsNotNull(uri, "Uri.parse(this)");
        intent.setData(uri);
        startActivity(intent);
    }

    @Override // androidx.activity.ComponentActivity, com.microsoft.intune.mam.client.app.MAMActivity, com.microsoft.intune.mam.client.app.HookedActivity
    public void onMAMNewIntent(Intent intent) {
        String str = TAG + ":onNewIntent";
        super.onMAMNewIntent(intent);
        Logger.info(str, "On new intent received.");
        setIntent(intent);
        if (intent != null) {
            if (intent.hasExtra(PROCESS_URI)) {
                Logger.warn(str, "Received new switch browser request while one is already in progress - Restarting browser switch flow");
                launchBrowser();
                return;
            } else if (intent.hasExtra(RESUME_REQUEST)) {
                WebViewAuthorizationFragment.setSwitchBrowserBundle(intent.getExtras());
                Logger.info(str, "Finishing activity and removing from task stack");
                finishAndRemoveTask();
                return;
            }
        }
        Logger.info(str, "Unexpected intent - Finishing activity and removing from task stack");
        finishAndRemoveTask();
    }

    @Override // androidx.fragment.app.FragmentActivity, com.microsoft.intune.mam.client.app.MAMActivity, com.microsoft.intune.mam.client.app.HookedActivity
    public void onMAMResume() {
        super.onMAMResume();
        String str = TAG + ":onResume";
        Logger.info(str, "onResume called - Managing CCT launch state");
        if (this.cctLaunched) {
            Logger.info(str, "CCT was launched previously and user returned - Assuming cancellation, finishing activity");
            finishAndRemoveTask();
        } else {
            Logger.info(str, "First resume after onCreate - Marking CCT as launched");
        }
        this.cctLaunched = true;
    }

    @Override // androidx.fragment.app.FragmentActivity, com.microsoft.intune.mam.client.app.MAMActivity, com.microsoft.intune.mam.client.app.HookedActivity
    public void onMAMDestroy() {
        super.onMAMDestroy();
        this.customTabsManager.unbind();
    }
}
