package com.microsoft.intune.mam.client.app;

import android.app.DownloadManager;

/* JADX INFO: loaded from: classes3.dex */
public class OfflineDownloadManagementBehavior implements DownloadManagementBehavior {
    @Override // com.microsoft.intune.mam.client.app.DownloadManagementBehavior
    public long enqueue(DownloadManager downloadManager, DownloadManager.Request request) {
        return downloadManager.enqueue(request);
    }
}
