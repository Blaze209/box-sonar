package com.microsoft.identity.client;

import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.widget.Toast;
import com.microsoft.identity.common.adal.internal.AuthenticationConstants;
import com.microsoft.identity.common.internal.providers.oauth2.CurrentTaskBrowserAuthorizationFragment;
import com.microsoft.identity.common.internal.util.StringUtil;
import com.microsoft.intune.mam.client.app.MAMActivity;
import com.microsoft.intune.mam.client.content.MAMBroadcastReceiver;
import com.microsoft.intune.mam.client.content.pm.MAMPackageManagement;

/* JADX INFO: loaded from: classes14.dex */
public final class CurrentTaskBrowserTabActivity extends MAMActivity {
    private static final int REDIRECT_RECEIVED_CODE = 2;
    private static final String TAG = "CurrentTaskBrowserTabActivity";
    private BroadcastReceiver mCloseBroadcastReceiver;

    @Override // com.microsoft.intune.mam.client.app.MAMActivity, com.microsoft.intune.mam.client.app.HookedActivity
    public void onMAMCreate(Bundle bundle) {
        super.onMAMCreate(bundle);
        String str = TAG + ":onCreate";
        String dataString = getIntent().getDataString();
        if (bundle != null || getIntent() == null || StringUtil.isEmpty(getIntent().getDataString())) {
            return;
        }
        Intent intentCreateCustomTabResponseIntent = CurrentTaskBrowserAuthorizationFragment.createCustomTabResponseIntent(this, dataString);
        if (intentCreateCustomTabResponseIntent != null) {
            startActivityForResult(intentCreateCustomTabResponseIntent, 2);
        } else {
            com.microsoft.identity.common.logging.Logger.warn(str, "Received NULL response intent. Unable to complete authorization.");
            Toast.makeText(getApplicationContext(), "Unable to complete authorization as there is no interactive call in progress. This can be due to closing the app while the authorization was in process.", 1).show();
        }
    }

    @Override // com.microsoft.intune.mam.client.app.MAMActivity, com.microsoft.intune.mam.client.app.HookedActivity
    public void onMAMActivityResult(int i, int i2, Intent intent) {
        super.onMAMActivityResult(i, i2, intent);
        final String str = TAG + ":onActivityResult";
        if (i2 == 0) {
            Intent intent2 = new Intent(AuthenticationConstants.AuthorizationIntentAction.REDIRECT_RETURNED_ACTION);
            intent2.setPackage(getPackageName());
            sendBroadcast(intent2);
            this.mCloseBroadcastReceiver = new MAMBroadcastReceiver() { // from class: com.microsoft.identity.client.CurrentTaskBrowserTabActivity.1
                @Override // com.microsoft.intune.mam.client.content.HookedBroadcastReceiver
                public void onMAMReceive(Context context, Intent intent3) {
                    PackageManager packageManager = CurrentTaskBrowserTabActivity.this.getApplicationContext().getPackageManager();
                    boolean z = false;
                    try {
                        ComponentName componentName = CurrentTaskBrowserTabActivity.this.getComponentName();
                        ActivityInfo activityInfo = componentName != null ? MAMPackageManagement.getActivityInfo(packageManager, componentName, 0) : null;
                        if (activityInfo == null || activityInfo.taskAffinity == null) {
                            z = true;
                        }
                    } catch (PackageManager.NameNotFoundException unused) {
                        com.microsoft.identity.common.logging.Logger.warn(str, null, "Package name not found for: " + CurrentTaskBrowserTabActivity.this.getComponentName());
                    }
                    CurrentTaskBrowserTabActivity.this.finishActivity(2);
                    if (z) {
                        CurrentTaskBrowserTabActivity.this.finishAndRemoveTask();
                    } else {
                        CurrentTaskBrowserTabActivity.this.finish();
                    }
                }
            };
            IntentFilter intentFilter = new IntentFilter(AuthenticationConstants.AuthorizationIntentAction.DESTROY_REDIRECT_RECEIVING_ACTIVITY_ACTION);
            if (Build.VERSION.SDK_INT >= 33) {
                registerReceiver(this.mCloseBroadcastReceiver, intentFilter, 4);
            } else {
                registerReceiver(this.mCloseBroadcastReceiver, intentFilter);
            }
        }
    }

    @Override // com.microsoft.intune.mam.client.app.MAMActivity, com.microsoft.intune.mam.client.app.HookedActivity
    public void onMAMDestroy() {
        String str = TAG + ":onDestroy";
        BroadcastReceiver broadcastReceiver = this.mCloseBroadcastReceiver;
        if (broadcastReceiver != null) {
            try {
                unregisterReceiver(broadcastReceiver);
            } catch (Exception e) {
                com.microsoft.identity.common.logging.Logger.error(str, "Failed to unregister receiver: " + e.getMessage(), e);
            }
        }
        super.onMAMDestroy();
    }
}
