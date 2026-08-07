package com.box.android.common.utilities;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

/* JADX INFO: loaded from: classes10.dex */
public class Connectivity {
    static boolean isConnectionFast(int i, int i2) {
        if (i == 1) {
            return true;
        }
        if (i != 0) {
            return false;
        }
        switch (i2) {
            case 3:
            case 5:
            case 6:
            case 8:
            case 9:
            case 10:
            case 12:
            case 13:
            case 14:
            case 15:
                return true;
            case 4:
            case 7:
            case 11:
            default:
                return false;
        }
    }

    static NetworkInfo getNetworkInfo(Context context) {
        ConnectivityManager connectivityManager;
        if (context == null || (connectivityManager = (ConnectivityManager) context.getSystemService("connectivity")) == null) {
            return null;
        }
        return connectivityManager.getActiveNetworkInfo();
    }

    public static boolean isConnected() {
        NetworkInfo networkInfo = getNetworkInfo(ApplicationProvider.application);
        return networkInfo != null && networkInfo.isConnected();
    }

    public static boolean isConnectedWifi() {
        NetworkInfo networkInfo = getNetworkInfo(ApplicationProvider.application);
        return networkInfo != null && networkInfo.isConnected() && networkInfo.getType() == 1;
    }

    public static boolean isConnectedMobile() {
        NetworkInfo networkInfo = getNetworkInfo(ApplicationProvider.application);
        return networkInfo != null && networkInfo.isConnected() && networkInfo.getType() == 0;
    }

    public static boolean isConnectedFast() {
        NetworkInfo networkInfo = getNetworkInfo(ApplicationProvider.application);
        return networkInfo != null && networkInfo.isConnected() && isConnectionFast(networkInfo.getType(), networkInfo.getSubtype());
    }
}
