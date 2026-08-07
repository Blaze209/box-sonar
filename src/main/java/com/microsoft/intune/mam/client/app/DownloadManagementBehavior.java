package com.microsoft.intune.mam.client.app;

import android.app.DownloadManager;

/* JADX INFO: loaded from: classes3.dex */
public interface DownloadManagementBehavior {
    long enqueue(DownloadManager downloadManager, DownloadManager.Request request);
}
