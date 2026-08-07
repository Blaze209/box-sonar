package com.box.android.data.persistence.annotations;

import com.box.android.domain.analytics.BoxAmplitudeAnalytics;
import java.util.Arrays;
import java.util.Date;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: AnnotationEntity.kt */
/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0012\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b%\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0087\b\u0018\u00002\u00020\u0001B}\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\n\u0012\u0006\u0010\u000b\u001a\u00020\b\u0012\u0006\u0010\f\u001a\u00020\n\u0012\u0006\u0010\r\u001a\u00020\n\u0012\u0006\u0010\u000e\u001a\u00020\n\u0012\u0006\u0010\u000f\u001a\u00020\n\u0012\u0006\u0010\u0010\u001a\u00020\n\u0012\b\b\u0002\u0010\u0011\u001a\u00020\b\u0012\b\b\u0002\u0010\u0012\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u0013\u001a\u00020\u0014¢\u0006\u0004\b\u0015\u0010\u0016J\t\u0010*\u001a\u00020\u0003HÆ\u0003J\t\u0010+\u001a\u00020\u0003HÆ\u0003J\t\u0010,\u001a\u00020\u0006HÆ\u0003J\t\u0010-\u001a\u00020\bHÆ\u0003J\t\u0010.\u001a\u00020\nHÆ\u0003J\t\u0010/\u001a\u00020\bHÆ\u0003J\t\u00100\u001a\u00020\nHÆ\u0003J\t\u00101\u001a\u00020\nHÆ\u0003J\t\u00102\u001a\u00020\nHÆ\u0003J\t\u00103\u001a\u00020\nHÆ\u0003J\t\u00104\u001a\u00020\nHÆ\u0003J\t\u00105\u001a\u00020\bHÆ\u0003J\t\u00106\u001a\u00020\u0006HÆ\u0003J\t\u00107\u001a\u00020\u0014HÆ\u0003J\u0095\u0001\u00108\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u000b\u001a\u00020\b2\b\b\u0002\u0010\f\u001a\u00020\n2\b\b\u0002\u0010\r\u001a\u00020\n2\b\b\u0002\u0010\u000e\u001a\u00020\n2\b\b\u0002\u0010\u000f\u001a\u00020\n2\b\b\u0002\u0010\u0010\u001a\u00020\n2\b\b\u0002\u0010\u0011\u001a\u00020\b2\b\b\u0002\u0010\u0012\u001a\u00020\u00062\b\b\u0002\u0010\u0013\u001a\u00020\u0014HÆ\u0001J\u0013\u00109\u001a\u00020:2\b\u0010;\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010<\u001a\u00020\u0006HÖ\u0001J\t\u0010=\u001a\u00020\u0003HÖ\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u0016\u0010\u0004\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0018R\u0016\u0010\u0005\u001a\u00020\u00068\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u001bR\u0016\u0010\u0007\u001a\u00020\b8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001dR\u0016\u0010\t\u001a\u00020\n8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001fR\u0016\u0010\u000b\u001a\u00020\b8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b \u0010\u001dR\u0016\u0010\f\u001a\u00020\n8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\u001fR\u0016\u0010\r\u001a\u00020\n8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010\u001fR\u0016\u0010\u000e\u001a\u00020\n8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b#\u0010\u001fR\u0016\u0010\u000f\u001a\u00020\n8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b$\u0010\u001fR\u0016\u0010\u0010\u001a\u00020\n8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b%\u0010\u001fR\u0016\u0010\u0011\u001a\u00020\b8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b&\u0010\u001dR\u0016\u0010\u0012\u001a\u00020\u00068\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b'\u0010\u001bR\u0016\u0010\u0013\u001a\u00020\u00148\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b(\u0010)¨\u0006>"}, d2 = {"Lcom/box/android/data/persistence/annotations/AnnotationEntity;", "", "annotationId", "", "fileVersionId", "fileVersionNumber", "", "createdAt", "Ljava/util/Date;", "createdByJsonData", "", "modifiedAt", "modifiedByJsonData", "descriptionJsonData", "locationJsonData", "targetJsonData", "permissionsJsonData", "networkFetchedAt", "totalReplyCount", "status", "Lcom/box/android/data/persistence/annotations/FileActivityStatus;", "<init>", "(Ljava/lang/String;Ljava/lang/String;ILjava/util/Date;[BLjava/util/Date;[B[B[B[B[BLjava/util/Date;ILcom/box/android/data/persistence/annotations/FileActivityStatus;)V", "getAnnotationId", "()Ljava/lang/String;", "getFileVersionId", "getFileVersionNumber", "()I", "getCreatedAt", "()Ljava/util/Date;", "getCreatedByJsonData", "()[B", "getModifiedAt", "getModifiedByJsonData", "getDescriptionJsonData", "getLocationJsonData", "getTargetJsonData", "getPermissionsJsonData", "getNetworkFetchedAt", "getTotalReplyCount", "getStatus", "()Lcom/box/android/data/persistence/annotations/FileActivityStatus;", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "component12", "component13", "component14", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "", "other", "hashCode", "toString", "data_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final /* data */ class AnnotationEntity {
    private final String annotationId;
    private final Date createdAt;
    private final byte[] createdByJsonData;
    private final byte[] descriptionJsonData;
    private final String fileVersionId;
    private final int fileVersionNumber;
    private final byte[] locationJsonData;
    private final Date modifiedAt;
    private final byte[] modifiedByJsonData;
    private final Date networkFetchedAt;
    private final byte[] permissionsJsonData;
    private final FileActivityStatus status;
    private final byte[] targetJsonData;
    private final int totalReplyCount;

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getAnnotationId() {
        return this.annotationId;
    }

    /* JADX INFO: renamed from: component10, reason: from getter */
    public final byte[] getTargetJsonData() {
        return this.targetJsonData;
    }

    /* JADX INFO: renamed from: component11, reason: from getter */
    public final byte[] getPermissionsJsonData() {
        return this.permissionsJsonData;
    }

    /* JADX INFO: renamed from: component12, reason: from getter */
    public final Date getNetworkFetchedAt() {
        return this.networkFetchedAt;
    }

    /* JADX INFO: renamed from: component13, reason: from getter */
    public final int getTotalReplyCount() {
        return this.totalReplyCount;
    }

    /* JADX INFO: renamed from: component14, reason: from getter */
    public final FileActivityStatus getStatus() {
        return this.status;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getFileVersionId() {
        return this.fileVersionId;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final int getFileVersionNumber() {
        return this.fileVersionNumber;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final Date getCreatedAt() {
        return this.createdAt;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final byte[] getCreatedByJsonData() {
        return this.createdByJsonData;
    }

    /* JADX INFO: renamed from: component6, reason: from getter */
    public final Date getModifiedAt() {
        return this.modifiedAt;
    }

    /* JADX INFO: renamed from: component7, reason: from getter */
    public final byte[] getModifiedByJsonData() {
        return this.modifiedByJsonData;
    }

    /* JADX INFO: renamed from: component8, reason: from getter */
    public final byte[] getDescriptionJsonData() {
        return this.descriptionJsonData;
    }

    /* JADX INFO: renamed from: component9, reason: from getter */
    public final byte[] getLocationJsonData() {
        return this.locationJsonData;
    }

    public final AnnotationEntity copy(String annotationId, String fileVersionId, int fileVersionNumber, Date createdAt, byte[] createdByJsonData, Date modifiedAt, byte[] modifiedByJsonData, byte[] descriptionJsonData, byte[] locationJsonData, byte[] targetJsonData, byte[] permissionsJsonData, Date networkFetchedAt, int totalReplyCount, FileActivityStatus status) {
        Intrinsics.checkNotNullParameter(annotationId, "annotationId");
        Intrinsics.checkNotNullParameter(fileVersionId, "fileVersionId");
        Intrinsics.checkNotNullParameter(createdAt, "createdAt");
        Intrinsics.checkNotNullParameter(createdByJsonData, "createdByJsonData");
        Intrinsics.checkNotNullParameter(modifiedAt, "modifiedAt");
        Intrinsics.checkNotNullParameter(modifiedByJsonData, "modifiedByJsonData");
        Intrinsics.checkNotNullParameter(descriptionJsonData, "descriptionJsonData");
        Intrinsics.checkNotNullParameter(locationJsonData, "locationJsonData");
        Intrinsics.checkNotNullParameter(targetJsonData, "targetJsonData");
        Intrinsics.checkNotNullParameter(permissionsJsonData, "permissionsJsonData");
        Intrinsics.checkNotNullParameter(networkFetchedAt, "networkFetchedAt");
        Intrinsics.checkNotNullParameter(status, "status");
        return new AnnotationEntity(annotationId, fileVersionId, fileVersionNumber, createdAt, createdByJsonData, modifiedAt, modifiedByJsonData, descriptionJsonData, locationJsonData, targetJsonData, permissionsJsonData, networkFetchedAt, totalReplyCount, status);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof AnnotationEntity)) {
            return false;
        }
        AnnotationEntity annotationEntity = (AnnotationEntity) other;
        return Intrinsics.areEqual(this.annotationId, annotationEntity.annotationId) && Intrinsics.areEqual(this.fileVersionId, annotationEntity.fileVersionId) && this.fileVersionNumber == annotationEntity.fileVersionNumber && Intrinsics.areEqual(this.createdAt, annotationEntity.createdAt) && Intrinsics.areEqual(this.createdByJsonData, annotationEntity.createdByJsonData) && Intrinsics.areEqual(this.modifiedAt, annotationEntity.modifiedAt) && Intrinsics.areEqual(this.modifiedByJsonData, annotationEntity.modifiedByJsonData) && Intrinsics.areEqual(this.descriptionJsonData, annotationEntity.descriptionJsonData) && Intrinsics.areEqual(this.locationJsonData, annotationEntity.locationJsonData) && Intrinsics.areEqual(this.targetJsonData, annotationEntity.targetJsonData) && Intrinsics.areEqual(this.permissionsJsonData, annotationEntity.permissionsJsonData) && Intrinsics.areEqual(this.networkFetchedAt, annotationEntity.networkFetchedAt) && this.totalReplyCount == annotationEntity.totalReplyCount && this.status == annotationEntity.status;
    }

    public int hashCode() {
        return (((((((((((((((((((((((((this.annotationId.hashCode() * 31) + this.fileVersionId.hashCode()) * 31) + Integer.hashCode(this.fileVersionNumber)) * 31) + this.createdAt.hashCode()) * 31) + Arrays.hashCode(this.createdByJsonData)) * 31) + this.modifiedAt.hashCode()) * 31) + Arrays.hashCode(this.modifiedByJsonData)) * 31) + Arrays.hashCode(this.descriptionJsonData)) * 31) + Arrays.hashCode(this.locationJsonData)) * 31) + Arrays.hashCode(this.targetJsonData)) * 31) + Arrays.hashCode(this.permissionsJsonData)) * 31) + this.networkFetchedAt.hashCode()) * 31) + Integer.hashCode(this.totalReplyCount)) * 31) + this.status.hashCode();
    }

    public String toString() {
        return "AnnotationEntity(annotationId=" + this.annotationId + ", fileVersionId=" + this.fileVersionId + ", fileVersionNumber=" + this.fileVersionNumber + ", createdAt=" + this.createdAt + ", createdByJsonData=" + Arrays.toString(this.createdByJsonData) + ", modifiedAt=" + this.modifiedAt + ", modifiedByJsonData=" + Arrays.toString(this.modifiedByJsonData) + ", descriptionJsonData=" + Arrays.toString(this.descriptionJsonData) + ", locationJsonData=" + Arrays.toString(this.locationJsonData) + ", targetJsonData=" + Arrays.toString(this.targetJsonData) + ", permissionsJsonData=" + Arrays.toString(this.permissionsJsonData) + ", networkFetchedAt=" + this.networkFetchedAt + ", totalReplyCount=" + this.totalReplyCount + ", status=" + this.status + ")";
    }

    public AnnotationEntity(String annotationId, String fileVersionId, int i, Date createdAt, byte[] createdByJsonData, Date modifiedAt, byte[] modifiedByJsonData, byte[] descriptionJsonData, byte[] locationJsonData, byte[] targetJsonData, byte[] permissionsJsonData, Date networkFetchedAt, int i2, FileActivityStatus status) {
        Intrinsics.checkNotNullParameter(annotationId, "annotationId");
        Intrinsics.checkNotNullParameter(fileVersionId, "fileVersionId");
        Intrinsics.checkNotNullParameter(createdAt, "createdAt");
        Intrinsics.checkNotNullParameter(createdByJsonData, "createdByJsonData");
        Intrinsics.checkNotNullParameter(modifiedAt, "modifiedAt");
        Intrinsics.checkNotNullParameter(modifiedByJsonData, "modifiedByJsonData");
        Intrinsics.checkNotNullParameter(descriptionJsonData, "descriptionJsonData");
        Intrinsics.checkNotNullParameter(locationJsonData, "locationJsonData");
        Intrinsics.checkNotNullParameter(targetJsonData, "targetJsonData");
        Intrinsics.checkNotNullParameter(permissionsJsonData, "permissionsJsonData");
        Intrinsics.checkNotNullParameter(networkFetchedAt, "networkFetchedAt");
        Intrinsics.checkNotNullParameter(status, "status");
        this.annotationId = annotationId;
        this.fileVersionId = fileVersionId;
        this.fileVersionNumber = i;
        this.createdAt = createdAt;
        this.createdByJsonData = createdByJsonData;
        this.modifiedAt = modifiedAt;
        this.modifiedByJsonData = modifiedByJsonData;
        this.descriptionJsonData = descriptionJsonData;
        this.locationJsonData = locationJsonData;
        this.targetJsonData = targetJsonData;
        this.permissionsJsonData = permissionsJsonData;
        this.networkFetchedAt = networkFetchedAt;
        this.totalReplyCount = i2;
        this.status = status;
    }

    public final String getAnnotationId() {
        return this.annotationId;
    }

    public final String getFileVersionId() {
        return this.fileVersionId;
    }

    public final int getFileVersionNumber() {
        return this.fileVersionNumber;
    }

    public final Date getCreatedAt() {
        return this.createdAt;
    }

    public final byte[] getCreatedByJsonData() {
        return this.createdByJsonData;
    }

    public final Date getModifiedAt() {
        return this.modifiedAt;
    }

    public final byte[] getModifiedByJsonData() {
        return this.modifiedByJsonData;
    }

    public final byte[] getDescriptionJsonData() {
        return this.descriptionJsonData;
    }

    public final byte[] getLocationJsonData() {
        return this.locationJsonData;
    }

    public final byte[] getTargetJsonData() {
        return this.targetJsonData;
    }

    public final byte[] getPermissionsJsonData() {
        return this.permissionsJsonData;
    }

    public /* synthetic */ AnnotationEntity(String str, String str2, int i, Date date, byte[] bArr, Date date2, byte[] bArr2, byte[] bArr3, byte[] bArr4, byte[] bArr5, byte[] bArr6, Date date3, int i2, FileActivityStatus fileActivityStatus, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, str2, i, date, bArr, date2, bArr2, bArr3, bArr4, bArr5, bArr6, (i3 & 2048) != 0 ? new Date() : date3, (i3 & 4096) != 0 ? 0 : i2, (i3 & 8192) != 0 ? FileActivityStatus.OPEN : fileActivityStatus);
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
}
