package com.microsoft.intune.mam.client.view;

import android.view.Window;

/* JADX INFO: loaded from: classes3.dex */
public class OfflineWindowManagementBehavior implements WindowManagementBehavior {
    @Override // com.microsoft.intune.mam.client.view.WindowManagementBehavior
    public void clearFlags(Window window, int i) {
        window.clearFlags(i);
    }
}
