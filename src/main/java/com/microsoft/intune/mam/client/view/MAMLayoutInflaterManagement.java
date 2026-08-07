package com.microsoft.intune.mam.client.view;

import android.view.LayoutInflater;
import com.microsoft.intune.mam.client.CachedBehaviorProvider;

/* JADX INFO: loaded from: classes3.dex */
public final class MAMLayoutInflaterManagement {
    private static CachedBehaviorProvider<LayoutInflaterManagementBehavior> sCachedBehavior = new CachedBehaviorProvider<>(LayoutInflaterManagementBehavior.class);

    public static void setFactory(LayoutInflater layoutInflater, LayoutInflater.Factory factory) {
        sCachedBehavior.get().setFactory(layoutInflater, factory);
    }

    public static void setFactory2(LayoutInflater layoutInflater, LayoutInflater.Factory2 factory2) {
        sCachedBehavior.get().setFactory2(layoutInflater, factory2);
    }

    private MAMLayoutInflaterManagement() {
    }
}
