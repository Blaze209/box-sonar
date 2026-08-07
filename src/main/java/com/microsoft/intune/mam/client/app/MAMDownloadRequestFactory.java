package com.microsoft.intune.mam.client.app;

import android.app.DownloadManager;
import android.net.Uri;

/* JADX INFO: loaded from: classes3.dex */
public interface MAMDownloadRequestFactory {
    DownloadManager.Request create(Uri uri);
}
