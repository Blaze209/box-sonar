package com.box.android.domain.services;

import android.net.Uri;
import com.google.firebase.analytics.FirebaseAnalytics;
import java.io.File;
import kotlin.Metadata;

/* JADX INFO: compiled from: IContentFileService.kt */
/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\bf\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H&J\u0010\u0010\b\u001a\u00020\t2\u0006\u0010\u0004\u001a\u00020\u0005H&J\b\u0010\n\u001a\u00020\u000bH&¨\u0006\fÀ\u0006\u0003"}, d2 = {"Lcom/box/android/domain/services/IContentFileService;", "", "copyFileFromUri", "", "uri", "Landroid/net/Uri;", FirebaseAnalytics.Param.DESTINATION, "Ljava/io/File;", "getDisplayName", "", "hasStoragePermission", "", "domain_prodRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public interface IContentFileService {
    void copyFileFromUri(Uri uri, File destination);

    String getDisplayName(Uri uri);

    boolean hasStoragePermission();
}
