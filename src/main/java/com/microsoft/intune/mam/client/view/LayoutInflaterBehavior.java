package com.microsoft.intune.mam.client.view;

import android.view.LayoutInflater;

/* JADX INFO: loaded from: classes3.dex */
public interface LayoutInflaterBehavior {
    void initialize(HookedLayoutInflater hookedLayoutInflater);

    void setFactory(LayoutInflater.Factory factory);

    void setFactory2(LayoutInflater.Factory2 factory2);
}
