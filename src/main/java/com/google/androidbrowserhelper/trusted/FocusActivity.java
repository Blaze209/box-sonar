package com.google.androidbrowserhelper.trusted;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.microsoft.intune.mam.client.app.MAMActivity;
import com.microsoft.intune.mam.client.app.MAMPendingIntent;

/* JADX INFO: loaded from: classes13.dex */
public class FocusActivity extends MAMActivity {
    private static final String EXTRA_FOCUS_INTENT = "androidx.browser.customtabs.extra.FOCUS_INTENT";
    private static Boolean mActivityExistsCached;

    public static void addToIntent(Intent intent, Context context) {
        Intent intent2 = new Intent(context, (Class<?>) FocusActivity.class);
        if (mActivityExistsCached == null) {
            mActivityExistsCached = Boolean.valueOf(intent2.resolveActivityInfo(context.getPackageManager(), 0) != null);
        }
        if (Boolean.FALSE.equals(mActivityExistsCached)) {
            return;
        }
        intent2.setFlags(268435456);
        intent.putExtra(EXTRA_FOCUS_INTENT, MAMPendingIntent.getActivity(context, 0, intent2, 67108864));
    }

    @Override // com.microsoft.intune.mam.client.app.MAMActivity, com.microsoft.intune.mam.client.app.HookedActivity
    public void onMAMCreate(Bundle bundle) {
        super.onMAMCreate(bundle);
        finish();
    }
}
