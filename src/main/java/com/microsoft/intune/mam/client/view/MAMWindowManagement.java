package com.microsoft.intune.mam.client.view;

import android.view.Window;
import com.microsoft.intune.mam.client.CachedBehaviorProvider;

/* JADX INFO: loaded from: classes3.dex */
public final class MAMWindowManagement {
    private static CachedBehaviorProvider<WindowManagementBehavior> sCachedBehavior = new CachedBehaviorProvider<>(WindowManagementBehavior.class);

    public static void clearFlags(Window window, int i) {
        getBehavior().clearFlags(window, i);
    }

    private static WindowManagementBehavior getBehavior() {
        return sCachedBehavior.get();
    }

    private MAMWindowManagement() {
    }
}
