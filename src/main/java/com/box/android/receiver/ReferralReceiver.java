package com.box.android.receiver;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import com.box.android.domain.analytics.BoxAmplitudeAnalytics;
import javax.inject.Inject;
import javax.inject.Named;

/* JADX INFO: loaded from: classes12.dex */
public class ReferralReceiver extends Hilt_ReferralReceiver {
    private static final String EXTRA_REFERRER = "referrer";

    @Inject
    @Named("app-flavor")
    String mAppFlavor;

    @Inject
    @Named("global-shared-preference")
    SharedPreferences mGlobalSharedPreferences;

    @Override // com.box.android.receiver.Hilt_ReferralReceiver, com.microsoft.intune.mam.client.content.HookedBroadcastReceiver
    public void onMAMReceive(Context context, Intent intent) {
        super.onMAMReceive(context, intent);
        if (intent != null) {
            BoxAmplitudeAnalytics.createAppInfoBuilder(this.mGlobalSharedPreferences, this.mAppFlavor).setInstallationReferrerTrackingCode(new Uri.Builder().encodedQuery(intent.getStringExtra(EXTRA_REFERRER)).build()).update();
        }
    }
}
