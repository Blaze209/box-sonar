package com.splunk.rum;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkCapabilities;
import android.telephony.TelephonyManager;
import androidx.core.app.ActivityCompat;

/* JADX INFO: loaded from: classes3.dex */
class PostApi28NetworkDetector implements NetworkDetector {
    private final CarrierFinder carrierFinder;
    private final ConnectivityManager connectivityManager;
    private final Context context;
    private final TelephonyManager telephonyManager;

    PostApi28NetworkDetector(ConnectivityManager connectivityManager, TelephonyManager telephonyManager, CarrierFinder carrierFinder, Context context) {
        this.connectivityManager = connectivityManager;
        this.telephonyManager = telephonyManager;
        this.carrierFinder = carrierFinder;
        this.context = context;
    }

    @Override // com.splunk.rum.NetworkDetector
    public CurrentNetwork detectCurrentNetwork() {
        ConnectivityManager connectivityManager = this.connectivityManager;
        NetworkCapabilities networkCapabilities = connectivityManager.getNetworkCapabilities(connectivityManager.getActiveNetwork());
        if (networkCapabilities == null) {
            return ConnectionUtil.NO_NETWORK;
        }
        Carrier carrier = this.carrierFinder.get();
        if (networkCapabilities.hasTransport(0)) {
            return CurrentNetwork.builder(NetworkState.TRANSPORT_CELLULAR).carrier(carrier).subType(hasPermission("android.permission.READ_PHONE_STATE") ? getDataNetworkTypeName(this.telephonyManager.getDataNetworkType()) : null).build();
        }
        if (networkCapabilities.hasTransport(1)) {
            return CurrentNetwork.builder(NetworkState.TRANSPORT_WIFI).carrier(carrier).build();
        }
        if (networkCapabilities.hasTransport(4)) {
            return CurrentNetwork.builder(NetworkState.TRANSPORT_VPN).carrier(carrier).build();
        }
        return ConnectionUtil.UNKNOWN_NETWORK;
    }

    boolean hasPermission(String str) {
        return ActivityCompat.checkSelfPermission(this.context, str) == 0;
    }

    private String getDataNetworkTypeName(int i) {
        switch (i) {
            case 1:
                return "GPRS";
            case 2:
                return "EDGE";
            case 3:
                return "UMTS";
            case 4:
                return "CDMA";
            case 5:
                return "EVDO_0";
            case 6:
                return "EVDO_A";
            case 7:
                return "1xRTT";
            case 8:
                return "HSDPA";
            case 9:
                return "HSUPA";
            case 10:
                return "HSPA";
            case 11:
                return "IDEN";
            case 12:
                return "EVDO_B";
            case 13:
                return "LTE";
            case 14:
                return "EHRPD";
            case 15:
                return "HSPAP";
            case 16:
                return "GSM";
            case 17:
                return "SCDMA";
            case 18:
                return "IWLAN";
            case 19:
            default:
                return "UNKNOWN";
            case 20:
                return "NR";
        }
    }
}
