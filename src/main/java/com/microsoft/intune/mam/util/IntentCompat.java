package com.microsoft.intune.mam.util;

import android.content.Intent;
import android.os.Build;
import android.os.Parcelable;
import java.io.Serializable;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes3.dex */
public final class IntentCompat {
    private IntentCompat() {
    }

    public static <T extends Parcelable> T getParcelableExtra(Intent intent, String str, Class<T> cls) {
        if (isAndroidTOrHigher()) {
            return (T) intent.getParcelableExtra(str, cls);
        }
        return (T) intent.getParcelableExtra(str);
    }

    public static <T extends Parcelable> Parcelable[] getParcelableArrayExtra(Intent intent, String str, Class<T> cls) {
        if (isAndroidTOrHigher()) {
            return (Parcelable[]) intent.getParcelableArrayExtra(str, cls);
        }
        return intent.getParcelableArrayExtra(str);
    }

    public static <T extends Serializable> Serializable getSerializableExtra(Intent intent, String str, Class<T> cls) {
        if (isAndroidTOrHigher()) {
            return intent.getSerializableExtra(str, cls);
        }
        return intent.getSerializableExtra(str);
    }

    public static <T extends Parcelable> ArrayList<T> getParcelableArrayListExtra(Intent intent, String str, Class<T> cls) {
        if (isAndroidTOrHigher()) {
            return intent.getParcelableArrayListExtra(str, cls);
        }
        return intent.getParcelableArrayListExtra(str);
    }

    private static boolean isAndroidTOrHigher() {
        return Build.VERSION.SDK_INT >= 33;
    }
}
