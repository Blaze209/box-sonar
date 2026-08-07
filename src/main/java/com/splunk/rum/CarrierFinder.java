package com.splunk.rum;

import android.telephony.TelephonyManager;

/* JADX INFO: loaded from: classes3.dex */
class CarrierFinder {
    private final TelephonyManager telephonyManager;

    CarrierFinder(TelephonyManager telephonyManager) {
        this.telephonyManager = telephonyManager;
    }

    Carrier get() {
        Carrier.Builder builder = Carrier.builder();
        builder.id(this.telephonyManager.getSimCarrierId());
        CharSequence simCarrierIdName = this.telephonyManager.getSimCarrierIdName();
        if (validString(simCarrierIdName)) {
            builder.name(simCarrierIdName.toString());
        }
        String simOperator = this.telephonyManager.getSimOperator();
        if (validString(simOperator) && simOperator.length() >= 5) {
            String strSubstring = simOperator.substring(0, 3);
            builder.mobileCountryCode(strSubstring).mobileNetworkCode(simOperator.substring(3));
        }
        String simCountryIso = this.telephonyManager.getSimCountryIso();
        if (validString(simCountryIso)) {
            builder.isoCountryCode(simCountryIso);
        }
        return builder.build();
    }

    private boolean validString(CharSequence charSequence) {
        return (charSequence == null || charSequence.length() == 0) ? false : true;
    }
}
