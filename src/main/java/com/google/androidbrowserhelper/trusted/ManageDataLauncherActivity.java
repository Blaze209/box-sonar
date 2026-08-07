package com.google.androidbrowserhelper.trusted;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.content.pm.ShortcutInfo;
import android.content.pm.ShortcutManager;
import android.graphics.drawable.Icon;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ProgressBar;
import android.widget.Toast;
import androidx.browser.customtabs.CustomTabsCallback;
import androidx.browser.customtabs.CustomTabsClient;
import androidx.browser.customtabs.CustomTabsIntent;
import androidx.browser.customtabs.CustomTabsService;
import androidx.browser.customtabs.CustomTabsServiceConnection;
import androidx.browser.customtabs.CustomTabsSession;
import com.google.androidbrowserhelper.R;
import com.microsoft.intune.mam.client.app.MAMActivity;
import com.microsoft.intune.mam.client.content.pm.MAMPackageManagement;
import java.util.Collections;
import java.util.List;

/* JADX INFO: loaded from: classes13.dex */
public class ManageDataLauncherActivity extends MAMActivity {
    public static final String ACTION_MANAGE_TRUSTED_WEB_ACTIVITY_DATA = "android.support.customtabs.action.ACTION_MANAGE_TRUSTED_WEB_ACTIVITY_DATA";
    public static final String CATEGORY_LAUNCH_SITE_SETTINGS = "androidx.browser.trusted.category.LaunchSiteSettings";
    private static final String METADATA_MANAGE_SPACE_DEFAULT_URL = "android.support.customtabs.trusted.MANAGE_SPACE_URL";
    public static final String OVERRIDE_IC_SITE_SETTINGS_ID = "drawable/override_ic_site_settings";
    public static final String SITE_SETTINGS_SHORTCUT_ID = "android.support.customtabs.action.SITE_SETTINGS_SHORTCUT";
    private static final String TAG = "ManageDataLauncher";
    private CustomTabsServiceConnection mConnection;
    private String mProviderPackage;

    @Override // com.microsoft.intune.mam.client.app.MAMActivity, com.microsoft.intune.mam.client.app.HookedActivity
    public void onMAMCreate(Bundle bundle) {
        super.onMAMCreate(bundle);
        String lastLaunchedProviderPackageName = new TwaSharedPreferencesManager(this).readLastLaunchedProviderPackageName();
        this.mProviderPackage = lastLaunchedProviderPackageName;
        if (lastLaunchedProviderPackageName == null) {
            handleTwaNeverLaunched();
            return;
        }
        if (!supportsTrustedWebActivities(lastLaunchedProviderPackageName)) {
            handleNoSupportForManageSpace();
            return;
        }
        View viewCreateLoadingView = createLoadingView();
        if (viewCreateLoadingView != null) {
            setContentView(viewCreateLoadingView);
        }
        if (ChromeLegacyUtils.supportsManageSpaceWithoutWarmupAndValidation(getPackageManager(), this.mProviderPackage)) {
            this.mConnection = new Connection();
        } else {
            this.mConnection = new LegacyChromeConnection();
        }
        CustomTabsClient.bindCustomTabsService(this, this.mProviderPackage, this.mConnection);
    }

    protected Uri getDefaultUrlForManagingSpace() {
        try {
            ActivityInfo activityInfo = MAMPackageManagement.getActivityInfo(getPackageManager(), getComponentName(), 128);
            if (activityInfo.metaData == null || !activityInfo.metaData.containsKey(METADATA_MANAGE_SPACE_DEFAULT_URL)) {
                return null;
            }
            Uri uri = Uri.parse(activityInfo.metaData.getString(METADATA_MANAGE_SPACE_DEFAULT_URL));
            Log.d(TAG, "Using clean-up URL from Manifest (" + uri + ").");
            return uri;
        } catch (PackageManager.NameNotFoundException e) {
            onError(new RuntimeException(e));
            return null;
        }
    }

    protected View createLoadingView() {
        ProgressBar progressBar = new ProgressBar(this);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
        layoutParams.gravity = 17;
        progressBar.setLayoutParams(layoutParams);
        FrameLayout frameLayout = new FrameLayout(this);
        frameLayout.addView(progressBar);
        return frameLayout;
    }

    protected void onError(RuntimeException runtimeException) {
        throw runtimeException;
    }

    protected void handleTwaNeverLaunched() {
        Toast.makeText(this, getString(R.string.manage_space_no_data_toast), 1).show();
        finish();
    }

    protected void handleNoSupportForManageSpace() {
        String string;
        try {
            string = MAMPackageManagement.getApplicationLabel(getPackageManager(), MAMPackageManagement.getApplicationInfo(getPackageManager(), this.mProviderPackage, 0)).toString();
        } catch (PackageManager.NameNotFoundException unused) {
            string = this.mProviderPackage;
        }
        Toast.makeText(this, getString(R.string.manage_space_not_supported_toast, new Object[]{string}), 1).show();
        finish();
    }

    @Override // android.app.Activity
    protected void onStop() {
        super.onStop();
        CustomTabsServiceConnection customTabsServiceConnection = this.mConnection;
        if (customTabsServiceConnection != null) {
            unbindService(customTabsServiceConnection);
        }
        finish();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void launchSettings(CustomTabsSession customTabsSession) {
        if (launchBrowserSiteSettings(this, customTabsSession, this.mProviderPackage, getDefaultUrlForManagingSpace())) {
            finish();
        } else {
            handleNoSupportForManageSpace();
        }
    }

    private static boolean launchBrowserSiteSettings(Activity activity, CustomTabsSession customTabsSession, String str, Uri uri) {
        Intent intent = new CustomTabsIntent.Builder().setSession(customTabsSession).build().intent;
        intent.setAction("android.support.customtabs.action.ACTION_MANAGE_TRUSTED_WEB_ACTIVITY_DATA");
        intent.setPackage(str);
        intent.setData(uri);
        try {
            activity.startActivity(intent);
            return true;
        } catch (ActivityNotFoundException unused) {
            return false;
        }
    }

    private boolean supportsTrustedWebActivities(String str) {
        if (ChromeLegacyUtils.supportsTrustedWebActivities(getPackageManager(), str)) {
            return true;
        }
        List<ResolveInfo> listQueryIntentServices = MAMPackageManagement.queryIntentServices(getPackageManager(), new Intent(CustomTabsService.ACTION_CUSTOM_TABS_CONNECTION).setPackage(str), 64);
        if (listQueryIntentServices.isEmpty()) {
            return false;
        }
        ResolveInfo resolveInfo = listQueryIntentServices.get(0);
        return resolveInfo.filter != null && resolveInfo.filter.hasCategory(CustomTabsService.TRUSTED_WEB_ACTIVITY_CATEGORY);
    }

    private class Connection extends CustomTabsServiceConnection {
        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName componentName) {
        }

        private Connection() {
        }

        @Override // androidx.browser.customtabs.CustomTabsServiceConnection
        public void onCustomTabsServiceConnected(ComponentName componentName, CustomTabsClient customTabsClient) {
            if (ManageDataLauncherActivity.this.isFinishing()) {
                return;
            }
            ManageDataLauncherActivity.this.launchSettings(customTabsClient.newSession(null));
        }
    }

    private class LegacyChromeConnection extends CustomTabsServiceConnection {
        private CustomTabsCallback mCustomTabsCallback;
        private CustomTabsSession mSession;

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName componentName) {
        }

        private LegacyChromeConnection() {
            this.mCustomTabsCallback = new CustomTabsCallback() { // from class: com.google.androidbrowserhelper.trusted.ManageDataLauncherActivity.LegacyChromeConnection.1
                @Override // androidx.browser.customtabs.CustomTabsCallback
                public void onRelationshipValidationResult(int i, Uri uri, boolean z, Bundle bundle) {
                    if (ManageDataLauncherActivity.this.isFinishing()) {
                        return;
                    }
                    if (z) {
                        ManageDataLauncherActivity.this.launchSettings(LegacyChromeConnection.this.mSession);
                    } else {
                        ManageDataLauncherActivity.this.onError(new RuntimeException("Failed to validate origin " + uri));
                        ManageDataLauncherActivity.this.finish();
                    }
                }
            };
        }

        @Override // androidx.browser.customtabs.CustomTabsServiceConnection
        public void onCustomTabsServiceConnected(ComponentName componentName, CustomTabsClient customTabsClient) {
            if (ManageDataLauncherActivity.this.isFinishing()) {
                return;
            }
            Uri defaultUrlForManagingSpace = ManageDataLauncherActivity.this.getDefaultUrlForManagingSpace();
            if (defaultUrlForManagingSpace == null) {
                ManageDataLauncherActivity.this.onError(new RuntimeException("Can't launch settings without an url"));
                ManageDataLauncherActivity.this.finish();
                return;
            }
            this.mSession = customTabsClient.newSession(this.mCustomTabsCallback);
            if (!customTabsClient.warmup(0L)) {
                ManageDataLauncherActivity.this.handleTwaNeverLaunched();
            } else {
                this.mSession.validateRelationship(2, defaultUrlForManagingSpace, null);
            }
        }
    }

    public static boolean packageSupportsSiteSettings(String str, PackageManager packageManager) {
        if (str == null) {
            return false;
        }
        if (ChromeLegacyUtils.supportsSiteSettings(packageManager, str)) {
            return true;
        }
        Intent intent = new Intent(CustomTabsService.ACTION_CUSTOM_TABS_CONNECTION);
        intent.addCategory(CATEGORY_LAUNCH_SITE_SETTINGS);
        intent.setPackage(str);
        return MAMPackageManagement.queryIntentServices(packageManager, intent, 64).size() > 0;
    }

    static ShortcutInfo getSiteSettingsShortcutOrNull(Context context, PackageManager packageManager) {
        Intent intent = new Intent(context, (Class<?>) ManageDataLauncherActivity.class);
        intent.setAction("android.support.customtabs.action.ACTION_MANAGE_TRUSTED_WEB_ACTIVITY_DATA");
        if (MAMPackageManagement.queryIntentActivities(packageManager, intent, 65536).size() == 0) {
            return null;
        }
        int identifier = context.getResources().getIdentifier(OVERRIDE_IC_SITE_SETTINGS_ID, "drawable", context.getPackageName());
        ShortcutInfo.Builder longLabel = new ShortcutInfo.Builder(context, SITE_SETTINGS_SHORTCUT_ID).setShortLabel("Site Settings").setLongLabel("Manage website notifications, permissions, etc.");
        if (identifier == 0) {
            identifier = R.drawable.ic_site_settings;
        }
        return longLabel.setIcon(Icon.createWithResource(context, identifier)).setIntent(intent).build();
    }

    public static void addSiteSettingsShortcut(Context context, String str) {
        PackageManager packageManager = context.getPackageManager();
        ShortcutManager shortcutManager = (ShortcutManager) context.getSystemService(ShortcutManager.class);
        if (!packageSupportsSiteSettings(str, packageManager)) {
            shortcutManager.removeDynamicShortcuts(Collections.singletonList(SITE_SETTINGS_SHORTCUT_ID));
            return;
        }
        ShortcutInfo siteSettingsShortcutOrNull = getSiteSettingsShortcutOrNull(context, packageManager);
        if (siteSettingsShortcutOrNull == null) {
            shortcutManager.removeDynamicShortcuts(Collections.singletonList(SITE_SETTINGS_SHORTCUT_ID));
        } else {
            shortcutManager.addDynamicShortcuts(Collections.singletonList(siteSettingsShortcutOrNull));
        }
    }
}
