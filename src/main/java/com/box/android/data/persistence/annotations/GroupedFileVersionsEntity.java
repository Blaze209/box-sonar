package com.box.android.data.persistence.annotations;

import java.util.Date;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: GroupedFileVersionsEntity.kt */
/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0012\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\b\u0007\u0018\u00002\u00020\u0001B1\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\t¢\u0006\u0004\b\n\u0010\u000bR\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0016\u0010\u0004\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\rR\u0016\u0010\u0005\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\rR\u0016\u0010\u0006\u001a\u00020\u00078\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0016\u0010\b\u001a\u00020\t8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013¨\u0006\u0014"}, d2 = {"Lcom/box/android/data/persistence/annotations/GroupedFileVersionsEntity;", "", "startId", "", "endId", "fileId", "createdByJsonData", "", "networkFetchedAt", "Ljava/util/Date;", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;[BLjava/util/Date;)V", "getStartId", "()Ljava/lang/String;", "getEndId", "getFileId", "getCreatedByJsonData", "()[B", "getNetworkFetchedAt", "()Ljava/util/Date;", "data_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class GroupedFileVersionsEntity {
    private final byte[] createdByJsonData;
    private final String endId;
    private final String fileId;
    private final Date networkFetchedAt;
    private final String startId;

    public GroupedFileVersionsEntity(String startId, String endId, String fileId, byte[] createdByJsonData, Date networkFetchedAt) {
        Intrinsics.checkNotNullParameter(startId, "startId");
        Intrinsics.checkNotNullParameter(endId, "endId");
        Intrinsics.checkNotNullParameter(fileId, "fileId");
        Intrinsics.checkNotNullParameter(createdByJsonData, "createdByJsonData");
        Intrinsics.checkNotNullParameter(networkFetchedAt, "networkFetchedAt");
        this.startId = startId;
        this.endId = endId;
        this.fileId = fileId;
        this.createdByJsonData = createdByJsonData;
        this.networkFetchedAt = networkFetchedAt;
    }

    public final String getStartId() {
        return this.startId;
    }

    public final String getEndId() {
        return this.endId;
    }

    public final String getFileId() {
        return this.fileId;
    }

    public final byte[] getCreatedByJsonData() {
        return this.createdByJsonData;
    }

    public /* synthetic */ GroupedFileVersionsEntity(String str, String str2, String str3, byte[] bArr, Date date, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, str2, str3, bArr, (i & 16) != 0 ? new Date() : date);
    }

    public final Date getNetworkFetchedAt() {
        return this.networkFetchedAt;
    }
}
