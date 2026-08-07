package com.pspdfkit.internal;

import android.graphics.Color;
import android.view.Window;
import com.microsoft.intune.mam.client.view.MAMWindowManagement;

/* JADX INFO: loaded from: classes3.dex */
public final class i9 {
    public static int a(int i, float f) {
        return Color.argb(Color.alpha(i), (int) (Math.min((Color.red(i) / 255.0f) + f, 1.0f) * 255.0f), (int) (Math.min((Color.green(i) / 255.0f) + f, 1.0f) * 255.0f), (int) (Math.min((Color.blue(i) / 255.0f) + f, 1.0f) * 255.0f));
    }

    public static void a(Window window, int i) {
        window.addFlags(Integer.MIN_VALUE);
        MAMWindowManagement.clearFlags(window, 67108864);
        window.setStatusBarColor(i);
    }
}
