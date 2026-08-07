package com.box.android.domain.services;

import android.net.Uri;
import java.io.File;
import kotlin.Metadata;

/* JADX INFO: compiled from: IUploadFileProvider.kt */
/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0010\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0003H&¨\u0006\tÀ\u0006\u0003"}, d2 = {"Lcom/box/android/domain/services/IUploadFileProvider;", "", "getTemporaryUploadFile", "Ljava/io/File;", "itemId", "", "getUriForFile", "Landroid/net/Uri;", "file", "domain_prodRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public interface IUploadFileProvider {
    File getTemporaryUploadFile(String itemId);

    Uri getUriForFile(File file);
}
