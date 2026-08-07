package com.splunk.rum;

import android.content.Context;
import android.net.ConnectivityManager;
import android.telephony.TelephonyManager;
import androidx.autofill.HintConstants;

/* JADX INFO: loaded from: classes3.dex */
interface NetworkDetector {
    CurrentNetwork detectCurrentNetwork();

    static NetworkDetector create(Context context) {
        ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
        TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService(HintConstants.AUTOFILL_HINT_PHONE);
        return new PostApi28NetworkDetector(connectivityManager, telephonyManager, new CarrierFinder(telephonyManager), context);
    }
}
