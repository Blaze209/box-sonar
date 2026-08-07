package com.splunk.rum;

import android.net.ConnectivityManager;
import android.net.NetworkInfo;

/* JADX INFO: loaded from: classes3.dex */
class SimpleNetworkDetector implements NetworkDetector {
    private final ConnectivityManager connectivityManager;

    SimpleNetworkDetector(ConnectivityManager connectivityManager) {
        this.connectivityManager = connectivityManager;
    }

    @Override // com.splunk.rum.NetworkDetector
    public CurrentNetwork detectCurrentNetwork() {
        NetworkInfo activeNetworkInfo = this.connectivityManager.getActiveNetworkInfo();
        if (activeNetworkInfo == null) {
            return ConnectionUtil.NO_NETWORK;
        }
        int type = activeNetworkInfo.getType();
        if (type == 0) {
            return CurrentNetwork.builder(NetworkState.TRANSPORT_CELLULAR).subType(activeNetworkInfo.getSubtypeName()).build();
        }
        if (type == 1) {
            return CurrentNetwork.builder(NetworkState.TRANSPORT_WIFI).subType(activeNetworkInfo.getSubtypeName()).build();
        }
        if (type == 17) {
            return CurrentNetwork.builder(NetworkState.TRANSPORT_VPN).subType(activeNetworkInfo.getSubtypeName()).build();
        }
        return ConnectionUtil.UNKNOWN_NETWORK;
    }
}
