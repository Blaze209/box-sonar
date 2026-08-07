package com.margelo.nitro;

import android.util.Log;

/* JADX INFO: loaded from: classes14.dex */
public class JNIOnLoad {
    private static final String TAG = "NitroModules";
    private static boolean isInitialized = false;

    public static synchronized void initializeNativeNitro() {
        if (isInitialized) {
            return;
        }
        try {
            Log.i("NitroModules", "Loading NitroModules C++ library...");
            System.loadLibrary("NitroModules");
            Log.i("NitroModules", "Successfully loaded NitroModules C++ library!");
            isInitialized = true;
        } catch (Throwable th) {
            Log.e("NitroModules", "Failed to load NitroModules C++ library! Is it properly installed and linked?", th);
            throw th;
        }
    }
}
