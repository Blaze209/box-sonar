package com.box.android.data.datasource;

import android.content.Context;
import com.amplitude.api.Constants;
import com.box.android.domain.utils.result.Result;
import com.box.androidsdk.content.models.BoxFile;
import java.io.File;
import java.net.URL;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: VersionsPreviewCache.kt */
/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0011\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J6\u0010\u0006\u001a\u001a\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\n0\b\u0012\u0004\u0012\u00020\u000b0\u00072\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u000f\u001a\u00020\rR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0010"}, d2 = {"Lcom/box/android/data/datasource/VersionsPreviewCache;", "", "context", "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "getDestinationUrl", "Lcom/box/android/domain/utils/result/Result;", "Lkotlin/Pair;", "", "Ljava/net/URL;", "Lcom/box/android/data/datasource/CacheError;", "fileId", "", Constants.AMP_PLAN_VERSION_ID, BoxFile.FIELD_EXTENSION, "data_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class VersionsPreviewCache {
    private final Context context;

    @Inject
    public VersionsPreviewCache(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        this.context = context;
    }

    public final Result<Pair<Boolean, URL>, CacheError> getDestinationUrl(String fileId, String versionId, String extension) {
        Intrinsics.checkNotNullParameter(fileId, "fileId");
        Intrinsics.checkNotNullParameter(versionId, "versionId");
        Intrinsics.checkNotNullParameter(extension, "extension");
        try {
            File file = new File(this.context.getCacheDir() + "/" + fileId + "/" + versionId);
            File file2 = new File(file, "preview." + extension);
            if (!file.exists()) {
                file.mkdirs();
            }
            return new Result.Success(TuplesKt.to(Boolean.valueOf(file2.createNewFile()), file2.toURI().toURL()));
        } catch (Exception unused) {
            return new Result.Error(CacheError.SaveError.INSTANCE);
        }
    }
}
