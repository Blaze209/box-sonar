package com.box.android.data.service;

import android.content.Context;
import android.net.Uri;
import androidx.core.content.FileProvider;
import com.box.android.coreservices.R;
import com.box.android.domain.services.IUploadFileProvider;
import dagger.hilt.android.qualifiers.ApplicationContext;
import java.io.File;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: UploadFileProvider.kt */
/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0013\b\u0007\u0012\b\b\u0001\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0016J\u0010\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u0007H\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\r"}, d2 = {"Lcom/box/android/data/service/UploadFileProvider;", "Lcom/box/android/domain/services/IUploadFileProvider;", "context", "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "getTemporaryUploadFile", "Ljava/io/File;", "itemId", "", "getUriForFile", "Landroid/net/Uri;", "file", "data_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class UploadFileProvider implements IUploadFileProvider {
    private final Context context;

    @Inject
    public UploadFileProvider(@ApplicationContext Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        this.context = context;
    }

    @Override // com.box.android.domain.services.IUploadFileProvider
    public File getTemporaryUploadFile(String itemId) {
        Intrinsics.checkNotNullParameter(itemId, "itemId");
        return new File(this.context.getCacheDir(), itemId);
    }

    @Override // com.box.android.domain.services.IUploadFileProvider
    public Uri getUriForFile(File file) {
        Intrinsics.checkNotNullParameter(file, "file");
        Context context = this.context;
        Uri uriForFile = FileProvider.getUriForFile(context, context.getString(R.string.fileProviderAuthority), file);
        Intrinsics.checkNotNullExpressionValue(uriForFile, "getUriForFile(...)");
        return uriForFile;
    }
}
