package com.microsoft.intune.mam.client.app;

import android.app.DownloadManager;
import com.microsoft.intune.mam.client.CachedBehaviorProvider;

/* JADX INFO: loaded from: classes3.dex */
public final class MAMDownloadManagement {
    private static CachedBehaviorProvider<DownloadManagementBehavior> sCachedBehavior = new CachedBehaviorProvider<>(DownloadManagementBehavior.class);

    public static long enqueue(DownloadManager downloadManager, DownloadManager.Request request) {
        return getBehavior().enqueue(downloadManager, request);
    }

    private static DownloadManagementBehavior getBehavior() {
        return sCachedBehavior.get();
    }

    private MAMDownloadManagement() {
    }
}
