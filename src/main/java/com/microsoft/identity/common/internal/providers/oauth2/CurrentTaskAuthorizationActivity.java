package com.microsoft.identity.common.internal.providers.oauth2;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Build;
import android.os.Bundle;
import androidx.fragment.app.Fragment;
import com.microsoft.identity.common.adal.internal.AuthenticationConstants;
import com.microsoft.identity.common.internal.ui.DualScreenActivity;
import com.microsoft.identity.common.logging.Logger;
import com.microsoft.intune.mam.client.content.MAMBroadcastReceiver;

/* JADX INFO: loaded from: classes14.dex */
public class CurrentTaskAuthorizationActivity extends DualScreenActivity {
    private static final String TAG = "CurrentTaskAuthorizationActivity";
    private boolean mCloseCustomTabs = true;
    private CurrentTaskBrowserAuthorizationFragment mFragment;
    private BroadcastReceiver redirectReceiver;

    @Override // com.microsoft.identity.common.internal.ui.DualScreenActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, com.microsoft.intune.mam.client.app.MAMActivity, com.microsoft.intune.mam.client.app.HookedActivity
    public void onMAMCreate(Bundle bundle) {
        super.onMAMCreate(bundle);
        String str = TAG + ":onCreate";
        Fragment authorizationFragmentFromStartIntent = AuthorizationActivityFactory.getAuthorizationFragmentFromStartIntent(getIntent());
        if (authorizationFragmentFromStartIntent instanceof CurrentTaskBrowserAuthorizationFragment) {
            CurrentTaskBrowserAuthorizationFragment currentTaskBrowserAuthorizationFragment = (CurrentTaskBrowserAuthorizationFragment) authorizationFragmentFromStartIntent;
            this.mFragment = currentTaskBrowserAuthorizationFragment;
            currentTaskBrowserAuthorizationFragment.setInstanceState(getIntent().getExtras());
            if (AuthenticationConstants.AuthorizationIntentAction.REDIRECT_RETURNED_ACTION.equals(getIntent().getAction())) {
                if (CurrentTaskBrowserAuthorizationFragment.class.isInstance(this.mFragment)) {
                    Bundle bundle2 = new Bundle();
                    bundle2.putBoolean("RESPONSE", true);
                    this.mFragment.setArguments(bundle2);
                    this.mFragment.completeAuthorizationInBrowserFlow(getIntent().getStringExtra("RESPONSE_URI"));
                    finish();
                    return;
                }
                return;
            }
            setFragment(this.mFragment);
            if (bundle == null) {
                this.mCloseCustomTabs = false;
                this.redirectReceiver = new MAMBroadcastReceiver() { // from class: com.microsoft.identity.common.internal.providers.oauth2.CurrentTaskAuthorizationActivity.1
                    @Override // com.microsoft.intune.mam.client.content.HookedBroadcastReceiver
                    public void onMAMReceive(Context context, Intent intent) {
                        Intent intent2 = new Intent(CurrentTaskAuthorizationActivity.this, (Class<?>) CurrentTaskAuthorizationActivity.class);
                        intent2.setAction(AuthenticationConstants.AuthorizationIntentAction.REFRESH_TO_CLOSE);
                        intent2.addFlags(603979776);
                        CurrentTaskAuthorizationActivity.this.startActivity(intent2);
                    }
                };
                IntentFilter intentFilter = new IntentFilter(AuthenticationConstants.AuthorizationIntentAction.REDIRECT_RETURNED_ACTION);
                if (Build.VERSION.SDK_INT >= 33) {
                    registerReceiver(this.redirectReceiver, intentFilter, 4);
                    return;
                } else {
                    registerReceiver(this.redirectReceiver, intentFilter);
                    return;
                }
            }
            return;
        }
        IllegalStateException illegalStateException = new IllegalStateException("Unexpected fragment type");
        Logger.error(str, "Fragment provided was not of type CurrentTaskBrowserAuthorizationFragment", illegalStateException);
        throw illegalStateException;
    }

    @Override // androidx.activity.ComponentActivity, com.microsoft.intune.mam.client.app.MAMActivity, com.microsoft.intune.mam.client.app.HookedActivity
    public void onMAMNewIntent(Intent intent) {
        super.onMAMNewIntent(intent);
        if (AuthenticationConstants.AuthorizationIntentAction.REFRESH_TO_CLOSE.equals(intent.getAction())) {
            Intent intent2 = new Intent(AuthenticationConstants.AuthorizationIntentAction.DESTROY_REDIRECT_RECEIVING_ACTIVITY_ACTION);
            intent2.setPackage(getPackageName());
            sendBroadcast(intent2);
            unregisterAndFinish();
        }
        setIntent(intent);
    }

    @Override // androidx.fragment.app.FragmentActivity, com.microsoft.intune.mam.client.app.MAMActivity, com.microsoft.intune.mam.client.app.HookedActivity
    public void onMAMResume() {
        super.onMAMResume();
        if (AuthenticationConstants.AuthorizationIntentAction.REDIRECT_RETURNED_ACTION.equals(getIntent().getAction())) {
            Bundle bundle = new Bundle();
            bundle.putBoolean("RESPONSE", true);
            this.mFragment.setArguments(bundle);
            this.mFragment.completeAuthorizationInBrowserFlow(getIntent().getStringExtra("RESPONSE_URI"));
            setResult(-1);
            unregisterAndFinish();
        }
        if (this.mCloseCustomTabs) {
            unregisterAndFinish();
        }
        this.mCloseCustomTabs = true;
    }

    private void unregisterAndFinish() {
        BroadcastReceiver broadcastReceiver = this.redirectReceiver;
        if (broadcastReceiver != null) {
            unregisterReceiver(broadcastReceiver);
        }
        finish();
    }
}
