package com.microsoft.identity.client;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;
import com.microsoft.identity.common.internal.providers.oauth2.BrowserAuthorizationFragment;
import com.microsoft.identity.common.internal.util.StringUtil;
import com.microsoft.intune.mam.client.app.MAMActivity;

/* JADX INFO: loaded from: classes14.dex */
public final class BrowserTabActivity extends MAMActivity {
    private static final String TAG = "BrowserTabActivity";

    @Override // com.microsoft.intune.mam.client.app.MAMActivity, com.microsoft.intune.mam.client.app.HookedActivity
    public void onMAMCreate(Bundle bundle) {
        super.onMAMCreate(bundle);
        String str = TAG + ":onCreate";
        if (bundle != null || getIntent() == null || StringUtil.isEmpty(getIntent().getDataString())) {
            return;
        }
        Intent intentCreateCustomTabResponseIntent = BrowserAuthorizationFragment.createCustomTabResponseIntent(this, getIntent().getDataString());
        if (intentCreateCustomTabResponseIntent != null) {
            startActivity(intentCreateCustomTabResponseIntent);
        } else {
            com.microsoft.identity.common.logging.Logger.warn(str, "Received NULL response intent. Unable to complete authorization.");
            Toast.makeText(getApplicationContext(), "Unable to complete authorization as there is no interactive call in progress. This can be due to closing the app while the authorization was in process.", 1).show();
        }
        finish();
    }
}
