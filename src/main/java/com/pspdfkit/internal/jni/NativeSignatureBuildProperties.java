package com.pspdfkit.internal.jni;

import java.util.HashMap;

/* JADX INFO: loaded from: classes3.dex */
public final class NativeSignatureBuildProperties {
    public static final String SIGNATURE_APP_KEY = "App";
    public static final String SIGNATURE_FILTER_KEY = "Filter";
    public static final String SIGNATURE_PUB_SEC_KEY = "PubSec";
    public static final String SIGNATURE_SIGQ_KEY = "SigQ";
    final HashMap<String, NativeSignatureBuildData> mSignatureBuildData;

    public NativeSignatureBuildProperties(HashMap<String, NativeSignatureBuildData> map) {
        this.mSignatureBuildData = map;
    }

    public HashMap<String, NativeSignatureBuildData> getSignatureBuildData() {
        return this.mSignatureBuildData;
    }

    public String toString() {
        return "NativeSignatureBuildProperties{mSignatureBuildData=" + this.mSignatureBuildData + "}";
    }
}
