package com.box.android.domain.models.fileversions;

import com.box.android.common.utilities.BoxCommonConstants;
import com.box.android.domain.analytics.BoxAmplitudeAnalytics;
import com.box.android.domain.models.DomainModel;
import com.box.android.domain.models.item.UserModel;
import java.util.Date;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: FileVersionModel.kt */
/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0014\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0086\b\u0018\u00002\u00020\u0001B;\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\b\u0010\t\u001a\u0004\u0018\u00010\b\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u000b¢\u0006\u0004\b\f\u0010\rJ\t\u0010\u0018\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0019\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001a\u001a\u00020\u0006HÆ\u0003J\t\u0010\u001b\u001a\u00020\bHÆ\u0003J\u000b\u0010\u001c\u001a\u0004\u0018\u00010\bHÆ\u0003J\u000b\u0010\u001d\u001a\u0004\u0018\u00010\u000bHÆ\u0003JI\u0010\u001e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\b2\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000bHÆ\u0001J\u0013\u0010\u001f\u001a\u00020 2\b\u0010!\u001a\u0004\u0018\u00010\"HÖ\u0003J\t\u0010#\u001a\u00020\u0006HÖ\u0001J\t\u0010$\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000fR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0013\u0010\t\u001a\u0004\u0018\u00010\b¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0014R\u0013\u0010\n\u001a\u0004\u0018\u00010\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017¨\u0006%"}, d2 = {"Lcom/box/android/domain/models/fileversions/FileVersionModel;", "Lcom/box/android/domain/models/DomainModel;", "id", "", BoxCommonConstants.EXTRA_FILE_NAME, "number", "", "createdAt", "Ljava/util/Date;", "modifiedAt", "modifiedBy", "Lcom/box/android/domain/models/item/UserModel;", "<init>", "(Ljava/lang/String;Ljava/lang/String;ILjava/util/Date;Ljava/util/Date;Lcom/box/android/domain/models/item/UserModel;)V", "getId", "()Ljava/lang/String;", "getFileName", "getNumber", "()I", "getCreatedAt", "()Ljava/util/Date;", "getModifiedAt", "getModifiedBy", "()Lcom/box/android/domain/models/item/UserModel;", "component1", "component2", "component3", "component4", "component5", "component6", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "", "other", "", "hashCode", "toString", "domain_prodRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final /* data */ class FileVersionModel implements DomainModel {
    private final Date createdAt;
    private final String fileName;
    private final String id;
    private final Date modifiedAt;
    private final UserModel modifiedBy;
    private final int number;

    public static /* synthetic */ FileVersionModel copy$default(FileVersionModel fileVersionModel, String str, String str2, int i, Date date, Date date2, UserModel userModel, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = fileVersionModel.id;
        }
        if ((i2 & 2) != 0) {
            str2 = fileVersionModel.fileName;
        }
        if ((i2 & 4) != 0) {
            i = fileVersionModel.number;
        }
        if ((i2 & 8) != 0) {
            date = fileVersionModel.createdAt;
        }
        if ((i2 & 16) != 0) {
            date2 = fileVersionModel.modifiedAt;
        }
        if ((i2 & 32) != 0) {
            userModel = fileVersionModel.modifiedBy;
        }
        Date date3 = date2;
        UserModel userModel2 = userModel;
        return fileVersionModel.copy(str, str2, i, date, date3, userModel2);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getId() {
        return this.id;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getFileName() {
        return this.fileName;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final int getNumber() {
        return this.number;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final Date getCreatedAt() {
        return this.createdAt;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final Date getModifiedAt() {
        return this.modifiedAt;
    }

    /* JADX INFO: renamed from: component6, reason: from getter */
    public final UserModel getModifiedBy() {
        return this.modifiedBy;
    }

    public final FileVersionModel copy(String id, String fileName, int number, Date createdAt, Date modifiedAt, UserModel modifiedBy) {
        Intrinsics.checkNotNullParameter(id, "id");
        Intrinsics.checkNotNullParameter(fileName, "fileName");
        Intrinsics.checkNotNullParameter(createdAt, "createdAt");
        return new FileVersionModel(id, fileName, number, createdAt, modifiedAt, modifiedBy);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof FileVersionModel)) {
            return false;
        }
        FileVersionModel fileVersionModel = (FileVersionModel) other;
        return Intrinsics.areEqual(this.id, fileVersionModel.id) && Intrinsics.areEqual(this.fileName, fileVersionModel.fileName) && this.number == fileVersionModel.number && Intrinsics.areEqual(this.createdAt, fileVersionModel.createdAt) && Intrinsics.areEqual(this.modifiedAt, fileVersionModel.modifiedAt) && Intrinsics.areEqual(this.modifiedBy, fileVersionModel.modifiedBy);
    }

    public int hashCode() {
        int iHashCode = ((((((this.id.hashCode() * 31) + this.fileName.hashCode()) * 31) + Integer.hashCode(this.number)) * 31) + this.createdAt.hashCode()) * 31;
        Date date = this.modifiedAt;
        int iHashCode2 = (iHashCode + (date == null ? 0 : date.hashCode())) * 31;
        UserModel userModel = this.modifiedBy;
        return iHashCode2 + (userModel != null ? userModel.hashCode() : 0);
    }

    public String toString() {
        return "FileVersionModel(id=" + this.id + ", fileName=" + this.fileName + ", number=" + this.number + ", createdAt=" + this.createdAt + ", modifiedAt=" + this.modifiedAt + ", modifiedBy=" + this.modifiedBy + ")";
    }

    public FileVersionModel(String id, String fileName, int i, Date createdAt, Date date, UserModel userModel) {
        Intrinsics.checkNotNullParameter(id, "id");
        Intrinsics.checkNotNullParameter(fileName, "fileName");
        Intrinsics.checkNotNullParameter(createdAt, "createdAt");
        this.id = id;
        this.fileName = fileName;
        this.number = i;
        this.createdAt = createdAt;
        this.modifiedAt = date;
        this.modifiedBy = userModel;
    }

    public final String getId() {
        return this.id;
    }

    public final String getFileName() {
        return this.fileName;
    }

    public final int getNumber() {
        return this.number;
    }

    public final Date getCreatedAt() {
        return this.createdAt;
    }

    public final Date getModifiedAt() {
        return this.modifiedAt;
    }

    public final UserModel getModifiedBy() {
        return this.modifiedBy;
    }
}
