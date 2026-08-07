package com.box.android.data.persistence.annotations;

import com.amplitude.api.Constants;
import java.util.Date;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: GroupedFileVersionsEntity.kt */
/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\f\b\u0007\u0018\u00002\u00020\u0001B1\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\b\b\u0002\u0010\t\u001a\u00020\u0006¢\u0006\u0004\b\n\u0010\u000bR\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0016\u0010\u0004\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\rR\u0016\u0010\u0005\u001a\u00020\u00068\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0016\u0010\t\u001a\u00020\u00068\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0010¨\u0006\u0014"}, d2 = {"Lcom/box/android/data/persistence/annotations/FileVersionEntity;", "", Constants.AMP_PLAN_VERSION_ID, "", "fileId", "createdAt", "Ljava/util/Date;", "number", "", "networkFetchedAt", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/util/Date;ILjava/util/Date;)V", "getVersionId", "()Ljava/lang/String;", "getFileId", "getCreatedAt", "()Ljava/util/Date;", "getNumber", "()I", "getNetworkFetchedAt", "data_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class FileVersionEntity {
    private final Date createdAt;
    private final String fileId;
    private final Date networkFetchedAt;
    private final int number;
    private final String versionId;

    public FileVersionEntity(String versionId, String fileId, Date createdAt, int i, Date networkFetchedAt) {
        Intrinsics.checkNotNullParameter(versionId, "versionId");
        Intrinsics.checkNotNullParameter(fileId, "fileId");
        Intrinsics.checkNotNullParameter(createdAt, "createdAt");
        Intrinsics.checkNotNullParameter(networkFetchedAt, "networkFetchedAt");
        this.versionId = versionId;
        this.fileId = fileId;
        this.createdAt = createdAt;
        this.number = i;
        this.networkFetchedAt = networkFetchedAt;
    }

    public final String getVersionId() {
        return this.versionId;
    }

    public final String getFileId() {
        return this.fileId;
    }

    public final Date getCreatedAt() {
        return this.createdAt;
    }

    public final int getNumber() {
        return this.number;
    }

    public /* synthetic */ FileVersionEntity(String str, String str2, Date date, int i, Date date2, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, str2, date, i, (i2 & 16) != 0 ? new Date() : date2);
    }

    public final Date getNetworkFetchedAt() {
        return this.networkFetchedAt;
    }
}
