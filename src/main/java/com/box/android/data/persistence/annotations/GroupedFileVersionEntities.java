package com.box.android.data.persistence.annotations;

import com.box.android.domain.analytics.BoxAmplitudeAnalytics;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: FileActivityEntity.kt */
/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005¢\u0006\u0004\b\u0007\u0010\bJ\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000f\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0005HÆ\u0003J'\u0010\u0011\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0015\u001a\u00020\u0016HÖ\u0001J\t\u0010\u0017\u001a\u00020\u0018HÖ\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0016\u0010\u0004\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0016\u0010\u0006\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\f¨\u0006\u0019"}, d2 = {"Lcom/box/android/data/persistence/annotations/GroupedFileVersionEntities;", "", "groupedFileVersionsEntity", "Lcom/box/android/data/persistence/annotations/GroupedFileVersionsEntity;", "startVersion", "Lcom/box/android/data/persistence/annotations/FileVersionEntity;", "endVersion", "<init>", "(Lcom/box/android/data/persistence/annotations/GroupedFileVersionsEntity;Lcom/box/android/data/persistence/annotations/FileVersionEntity;Lcom/box/android/data/persistence/annotations/FileVersionEntity;)V", "getGroupedFileVersionsEntity", "()Lcom/box/android/data/persistence/annotations/GroupedFileVersionsEntity;", "getStartVersion", "()Lcom/box/android/data/persistence/annotations/FileVersionEntity;", "getEndVersion", "component1", "component2", "component3", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "", "other", "hashCode", "", "toString", "", "data_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final /* data */ class GroupedFileVersionEntities {
    private final FileVersionEntity endVersion;
    private final GroupedFileVersionsEntity groupedFileVersionsEntity;
    private final FileVersionEntity startVersion;

    public static /* synthetic */ GroupedFileVersionEntities copy$default(GroupedFileVersionEntities groupedFileVersionEntities, GroupedFileVersionsEntity groupedFileVersionsEntity, FileVersionEntity fileVersionEntity, FileVersionEntity fileVersionEntity2, int i, Object obj) {
        if ((i & 1) != 0) {
            groupedFileVersionsEntity = groupedFileVersionEntities.groupedFileVersionsEntity;
        }
        if ((i & 2) != 0) {
            fileVersionEntity = groupedFileVersionEntities.startVersion;
        }
        if ((i & 4) != 0) {
            fileVersionEntity2 = groupedFileVersionEntities.endVersion;
        }
        return groupedFileVersionEntities.copy(groupedFileVersionsEntity, fileVersionEntity, fileVersionEntity2);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final GroupedFileVersionsEntity getGroupedFileVersionsEntity() {
        return this.groupedFileVersionsEntity;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final FileVersionEntity getStartVersion() {
        return this.startVersion;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final FileVersionEntity getEndVersion() {
        return this.endVersion;
    }

    public final GroupedFileVersionEntities copy(GroupedFileVersionsEntity groupedFileVersionsEntity, FileVersionEntity startVersion, FileVersionEntity endVersion) {
        Intrinsics.checkNotNullParameter(groupedFileVersionsEntity, "groupedFileVersionsEntity");
        Intrinsics.checkNotNullParameter(startVersion, "startVersion");
        Intrinsics.checkNotNullParameter(endVersion, "endVersion");
        return new GroupedFileVersionEntities(groupedFileVersionsEntity, startVersion, endVersion);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof GroupedFileVersionEntities)) {
            return false;
        }
        GroupedFileVersionEntities groupedFileVersionEntities = (GroupedFileVersionEntities) other;
        return Intrinsics.areEqual(this.groupedFileVersionsEntity, groupedFileVersionEntities.groupedFileVersionsEntity) && Intrinsics.areEqual(this.startVersion, groupedFileVersionEntities.startVersion) && Intrinsics.areEqual(this.endVersion, groupedFileVersionEntities.endVersion);
    }

    public int hashCode() {
        return (((this.groupedFileVersionsEntity.hashCode() * 31) + this.startVersion.hashCode()) * 31) + this.endVersion.hashCode();
    }

    public String toString() {
        return "GroupedFileVersionEntities(groupedFileVersionsEntity=" + this.groupedFileVersionsEntity + ", startVersion=" + this.startVersion + ", endVersion=" + this.endVersion + ")";
    }

    public GroupedFileVersionEntities(GroupedFileVersionsEntity groupedFileVersionsEntity, FileVersionEntity startVersion, FileVersionEntity endVersion) {
        Intrinsics.checkNotNullParameter(groupedFileVersionsEntity, "groupedFileVersionsEntity");
        Intrinsics.checkNotNullParameter(startVersion, "startVersion");
        Intrinsics.checkNotNullParameter(endVersion, "endVersion");
        this.groupedFileVersionsEntity = groupedFileVersionsEntity;
        this.startVersion = startVersion;
        this.endVersion = endVersion;
    }

    public final GroupedFileVersionsEntity getGroupedFileVersionsEntity() {
        return this.groupedFileVersionsEntity;
    }

    public final FileVersionEntity getStartVersion() {
        return this.startVersion;
    }

    public final FileVersionEntity getEndVersion() {
        return this.endVersion;
    }
}
