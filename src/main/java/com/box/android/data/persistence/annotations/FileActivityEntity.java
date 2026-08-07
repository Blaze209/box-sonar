package com.box.android.data.persistence.annotations;

import com.box.android.domain.analytics.BoxAmplitudeAnalytics;
import com.box.androidsdk.content.models.BoxIterator;
import java.util.Date;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: FileActivityEntity.kt */
/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0014\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0087\b\u0018\u00002\u00020\u0001B9\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\b\b\u0002\u0010\t\u001a\u00020\b\u0012\u0006\u0010\n\u001a\u00020\u000b¢\u0006\u0004\b\f\u0010\rJ\t\u0010\u0018\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0019\u001a\u00020\u0005HÆ\u0003J\t\u0010\u001a\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001b\u001a\u00020\bHÆ\u0003J\t\u0010\u001c\u001a\u00020\bHÆ\u0003J\t\u0010\u001d\u001a\u00020\u000bHÆ\u0003JE\u0010\u001e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\b2\b\b\u0002\u0010\n\u001a\u00020\u000bHÆ\u0001J\u0013\u0010\u001f\u001a\u00020 2\b\u0010!\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\"\u001a\u00020\u000bHÖ\u0001J\t\u0010#\u001a\u00020\u0003HÖ\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0016\u0010\u0004\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0016\u0010\u0006\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u000fR\u0016\u0010\u0007\u001a\u00020\b8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0016\u0010\t\u001a\u00020\b8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0014R\u0016\u0010\n\u001a\u00020\u000b8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017¨\u0006$"}, d2 = {"Lcom/box/android/data/persistence/annotations/FileActivityEntity;", "", "activityId", "", "type", "Lcom/box/android/data/persistence/annotations/FileActivityType;", "fileId", "createdAt", "Ljava/util/Date;", "networkFetchedAt", BoxIterator.FIELD_ORDER, "", "<init>", "(Ljava/lang/String;Lcom/box/android/data/persistence/annotations/FileActivityType;Ljava/lang/String;Ljava/util/Date;Ljava/util/Date;I)V", "getActivityId", "()Ljava/lang/String;", "getType", "()Lcom/box/android/data/persistence/annotations/FileActivityType;", "getFileId", "getCreatedAt", "()Ljava/util/Date;", "getNetworkFetchedAt", "getOrder", "()I", "component1", "component2", "component3", "component4", "component5", "component6", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "", "other", "hashCode", "toString", "data_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final /* data */ class FileActivityEntity {
    private final String activityId;
    private final Date createdAt;
    private final String fileId;
    private final Date networkFetchedAt;
    private final int order;
    private final FileActivityType type;

    public static /* synthetic */ FileActivityEntity copy$default(FileActivityEntity fileActivityEntity, String str, FileActivityType fileActivityType, String str2, Date date, Date date2, int i, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = fileActivityEntity.activityId;
        }
        if ((i2 & 2) != 0) {
            fileActivityType = fileActivityEntity.type;
        }
        if ((i2 & 4) != 0) {
            str2 = fileActivityEntity.fileId;
        }
        if ((i2 & 8) != 0) {
            date = fileActivityEntity.createdAt;
        }
        if ((i2 & 16) != 0) {
            date2 = fileActivityEntity.networkFetchedAt;
        }
        if ((i2 & 32) != 0) {
            i = fileActivityEntity.order;
        }
        Date date3 = date2;
        int i3 = i;
        return fileActivityEntity.copy(str, fileActivityType, str2, date, date3, i3);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getActivityId() {
        return this.activityId;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final FileActivityType getType() {
        return this.type;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final String getFileId() {
        return this.fileId;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final Date getCreatedAt() {
        return this.createdAt;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final Date getNetworkFetchedAt() {
        return this.networkFetchedAt;
    }

    /* JADX INFO: renamed from: component6, reason: from getter */
    public final int getOrder() {
        return this.order;
    }

    public final FileActivityEntity copy(String activityId, FileActivityType type, String fileId, Date createdAt, Date networkFetchedAt, int order) {
        Intrinsics.checkNotNullParameter(activityId, "activityId");
        Intrinsics.checkNotNullParameter(type, "type");
        Intrinsics.checkNotNullParameter(fileId, "fileId");
        Intrinsics.checkNotNullParameter(createdAt, "createdAt");
        Intrinsics.checkNotNullParameter(networkFetchedAt, "networkFetchedAt");
        return new FileActivityEntity(activityId, type, fileId, createdAt, networkFetchedAt, order);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof FileActivityEntity)) {
            return false;
        }
        FileActivityEntity fileActivityEntity = (FileActivityEntity) other;
        return Intrinsics.areEqual(this.activityId, fileActivityEntity.activityId) && this.type == fileActivityEntity.type && Intrinsics.areEqual(this.fileId, fileActivityEntity.fileId) && Intrinsics.areEqual(this.createdAt, fileActivityEntity.createdAt) && Intrinsics.areEqual(this.networkFetchedAt, fileActivityEntity.networkFetchedAt) && this.order == fileActivityEntity.order;
    }

    public int hashCode() {
        return (((((((((this.activityId.hashCode() * 31) + this.type.hashCode()) * 31) + this.fileId.hashCode()) * 31) + this.createdAt.hashCode()) * 31) + this.networkFetchedAt.hashCode()) * 31) + Integer.hashCode(this.order);
    }

    public String toString() {
        return "FileActivityEntity(activityId=" + this.activityId + ", type=" + this.type + ", fileId=" + this.fileId + ", createdAt=" + this.createdAt + ", networkFetchedAt=" + this.networkFetchedAt + ", order=" + this.order + ")";
    }

    public FileActivityEntity(String activityId, FileActivityType type, String fileId, Date createdAt, Date networkFetchedAt, int i) {
        Intrinsics.checkNotNullParameter(activityId, "activityId");
        Intrinsics.checkNotNullParameter(type, "type");
        Intrinsics.checkNotNullParameter(fileId, "fileId");
        Intrinsics.checkNotNullParameter(createdAt, "createdAt");
        Intrinsics.checkNotNullParameter(networkFetchedAt, "networkFetchedAt");
        this.activityId = activityId;
        this.type = type;
        this.fileId = fileId;
        this.createdAt = createdAt;
        this.networkFetchedAt = networkFetchedAt;
        this.order = i;
    }

    public final String getActivityId() {
        return this.activityId;
    }

    public final FileActivityType getType() {
        return this.type;
    }

    public final String getFileId() {
        return this.fileId;
    }

    public final Date getCreatedAt() {
        return this.createdAt;
    }

    public /* synthetic */ FileActivityEntity(String str, FileActivityType fileActivityType, String str2, Date date, Date date2, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, fileActivityType, str2, date, (i2 & 16) != 0 ? new Date() : date2, i);
    }

    public final Date getNetworkFetchedAt() {
        return this.networkFetchedAt;
    }

    public final int getOrder() {
        return this.order;
    }
}
