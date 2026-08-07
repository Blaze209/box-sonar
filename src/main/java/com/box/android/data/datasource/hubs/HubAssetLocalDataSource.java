package com.box.android.data.datasource.hubs;

import com.box.android.common.utilities.BoxCommonConstants;
import com.box.android.domain.identity.IUserContextManager;
import com.box.android.domain.models.hubs.HubAssetModel;
import com.microsoft.identity.client.internal.MsalUtils;
import java.io.File;
import java.util.Date;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: compiled from: HubAssetLocalDataSource.kt */
/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0011\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u00072\u0006\u0010\b\u001a\u00020\tJ\u0012\u0010\n\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\b\u001a\u00020\tH\u0007J\u0010\u0010\f\u001a\u00020\u00072\u0006\u0010\r\u001a\u00020\u000bH\u0007R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000e"}, d2 = {"Lcom/box/android/data/datasource/hubs/HubAssetLocalDataSource;", "", "userContextManager", "Lcom/box/android/domain/identity/IUserContextManager;", "<init>", "(Lcom/box/android/domain/identity/IUserContextManager;)V", "getCachedHubAssetFile", "Ljava/io/File;", "hubAssetModel", "Lcom/box/android/domain/models/hubs/HubAssetModel;", "createFileName", "", "createFile", BoxCommonConstants.EXTRA_FILE_NAME, "data_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class HubAssetLocalDataSource {
    private final IUserContextManager userContextManager;

    @Inject
    public HubAssetLocalDataSource(IUserContextManager userContextManager) {
        Intrinsics.checkNotNullParameter(userContextManager, "userContextManager");
        this.userContextManager = userContextManager;
    }

    public final File getCachedHubAssetFile(HubAssetModel hubAssetModel) {
        Intrinsics.checkNotNullParameter(hubAssetModel, "hubAssetModel");
        String strCreateFileName = createFileName(hubAssetModel);
        if (strCreateFileName != null) {
            return createFile(strCreateFileName);
        }
        return null;
    }

    public final String createFileName(HubAssetModel hubAssetModel) {
        Intrinsics.checkNotNullParameter(hubAssetModel, "hubAssetModel");
        String signedUrl = hubAssetModel.getSignedUrl();
        Date lastUpdated = hubAssetModel.getLastUpdated();
        Long lValueOf = lastUpdated != null ? Long.valueOf(lastUpdated.getTime()) : null;
        String str = signedUrl;
        if (str != null && !StringsKt.isBlank(str) && lValueOf != null) {
            String strSubstringBefore$default = StringsKt.substringBefore$default(StringsKt.substringAfterLast$default(signedUrl, "/", (String) null, 2, (Object) null), MsalUtils.QUERY_STRING_SYMBOL, (String) null, 2, (Object) null);
            String str2 = strSubstringBefore$default;
            if (str2.length() > 0 && StringsKt.contains$default((CharSequence) str2, '.', false, 2, (Object) null)) {
                return lValueOf + "_" + strSubstringBefore$default;
            }
        }
        return null;
    }

    public final File createFile(String fileName) {
        Intrinsics.checkNotNullParameter(fileName, "fileName");
        return new File(this.userContextManager.getPreviewStorage().getCachedHubAssetsDirectory(), fileName);
    }
}
