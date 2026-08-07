package com.box.android.data.persistence.annotations;

import java.util.Date;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: CommentEntity.kt */
/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0012\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0011\b\u0007\u0018\u00002\u00020\u0001BQ\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\b\b\u0002\u0010\t\u001a\u00020\u0005\u0012\b\b\u0002\u0010\n\u001a\u00020\u000b\u0012\b\b\u0002\u0010\f\u001a\u00020\r\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u000f\u0010\u0010R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0016\u0010\u0004\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0016\u0010\u0006\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0012R\u0016\u0010\u0007\u001a\u00020\b8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u0016\u0010\t\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0014R\u0016\u0010\n\u001a\u00020\u000b8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001aR\u0016\u0010\f\u001a\u00020\r8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001cR\u0018\u0010\u000e\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u0012¨\u0006\u001e"}, d2 = {"Lcom/box/android/data/persistence/annotations/CommentEntity;", "", "commentId", "", "createdAt", "Ljava/util/Date;", "fileId", "JsonData", "", "networkFetchedAt", "totalReplyCount", "", "status", "Lcom/box/android/data/persistence/annotations/FileActivityStatus;", "parentFileActivityId", "<init>", "(Ljava/lang/String;Ljava/util/Date;Ljava/lang/String;[BLjava/util/Date;ILcom/box/android/data/persistence/annotations/FileActivityStatus;Ljava/lang/String;)V", "getCommentId", "()Ljava/lang/String;", "getCreatedAt", "()Ljava/util/Date;", "getFileId", "getJsonData", "()[B", "getNetworkFetchedAt", "getTotalReplyCount", "()I", "getStatus", "()Lcom/box/android/data/persistence/annotations/FileActivityStatus;", "getParentFileActivityId", "data_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class CommentEntity {
    private final byte[] JsonData;
    private final String commentId;
    private final Date createdAt;
    private final String fileId;
    private final Date networkFetchedAt;
    private final String parentFileActivityId;
    private final FileActivityStatus status;
    private final int totalReplyCount;

    public CommentEntity(String commentId, Date createdAt, String fileId, byte[] JsonData, Date networkFetchedAt, int i, FileActivityStatus status, String str) {
        Intrinsics.checkNotNullParameter(commentId, "commentId");
        Intrinsics.checkNotNullParameter(createdAt, "createdAt");
        Intrinsics.checkNotNullParameter(fileId, "fileId");
        Intrinsics.checkNotNullParameter(JsonData, "JsonData");
        Intrinsics.checkNotNullParameter(networkFetchedAt, "networkFetchedAt");
        Intrinsics.checkNotNullParameter(status, "status");
        this.commentId = commentId;
        this.createdAt = createdAt;
        this.fileId = fileId;
        this.JsonData = JsonData;
        this.networkFetchedAt = networkFetchedAt;
        this.totalReplyCount = i;
        this.status = status;
        this.parentFileActivityId = str;
    }

    public final String getCommentId() {
        return this.commentId;
    }

    public final Date getCreatedAt() {
        return this.createdAt;
    }

    public final String getFileId() {
        return this.fileId;
    }

    public final byte[] getJsonData() {
        return this.JsonData;
    }

    public /* synthetic */ CommentEntity(String str, Date date, String str2, byte[] bArr, Date date2, int i, FileActivityStatus fileActivityStatus, String str3, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, date, str2, bArr, (i2 & 16) != 0 ? new Date() : date2, (i2 & 32) != 0 ? 0 : i, (i2 & 64) != 0 ? FileActivityStatus.OPEN : fileActivityStatus, (i2 & 128) != 0 ? null : str3);
    }

    public final Date getNetworkFetchedAt() {
        return this.networkFetchedAt;
    }

    public final int getTotalReplyCount() {
        return this.totalReplyCount;
    }

    public final FileActivityStatus getStatus() {
        return this.status;
    }

    public final String getParentFileActivityId() {
        return this.parentFileActivityId;
    }
}
