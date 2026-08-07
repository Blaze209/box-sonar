package com.microsoft.intune.mam.client.view;

import android.view.LayoutInflater;

/* JADX INFO: loaded from: classes3.dex */
public class OfflineLayoutInflaterManagementBehavior implements LayoutInflaterManagementBehavior {
    @Override // com.microsoft.intune.mam.client.view.LayoutInflaterManagementBehavior
    public void setFactory(LayoutInflater layoutInflater, LayoutInflater.Factory factory) {
        layoutInflater.setFactory(factory);
    }

    @Override // com.microsoft.intune.mam.client.view.LayoutInflaterManagementBehavior
    public void setFactory2(LayoutInflater layoutInflater, LayoutInflater.Factory2 factory2) {
        layoutInflater.setFactory2(factory2);
    }
}
