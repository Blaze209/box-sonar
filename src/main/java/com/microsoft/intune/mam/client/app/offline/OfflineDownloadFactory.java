package com.microsoft.intune.mam.client.app.offline;

import android.app.DownloadManager;
import android.net.Uri;
import com.microsoft.intune.mam.client.app.MAMDownloadQueryFactory;
import com.microsoft.intune.mam.client.app.MAMDownloadRequestFactory;

/* JADX INFO: loaded from: classes3.dex */
final class OfflineDownloadFactory implements MAMDownloadRequestFactory, MAMDownloadQueryFactory {
    OfflineDownloadFactory() {
    }

    @Override // com.microsoft.intune.mam.client.app.MAMDownloadRequestFactory
    public DownloadManager.Request create(Uri uri) {
        return new DownloadManager.Request(uri);
    }

    @Override // com.microsoft.intune.mam.client.app.MAMDownloadQueryFactory
    public DownloadManager.Query create() {
        return new DownloadManager.Query();
    }
}
