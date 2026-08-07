package com.box.android.data.persistence.annotations;

import com.box.android.domain.analytics.BoxAmplitudeAnalytics;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import sdk.pendo.io.network.responses.KillSwitchModel;

/* JADX INFO: compiled from: FileActivityEntity.kt */
/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B-\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\b\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\u0004\b\n\u0010\u000bJ\t\u0010\u0014\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u0015\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\u0016\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\u000b\u0010\u0017\u001a\u0004\u0018\u00010\tHÆ\u0003J7\u0010\u0018\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\tHÆ\u0001J\u0013\u0010\u0019\u001a\u00020\u001a2\b\u0010\u001b\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001c\u001a\u00020\u001dHÖ\u0001J\t\u0010\u001e\u001a\u00020\u001fHÖ\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0018\u0010\b\u001a\u0004\u0018\u00010\t8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013¨\u0006 "}, d2 = {"Lcom/box/android/data/persistence/annotations/FileActivityEntities;", "", "fileActivityEntity", "Lcom/box/android/data/persistence/annotations/FileActivityEntity;", "commentEntity", "Lcom/box/android/data/persistence/annotations/CommentEntity;", "annotationEntity", "Lcom/box/android/data/persistence/annotations/AnnotationEntity;", KillSwitchModel.KILL_SWITCH_VERSIONS, "Lcom/box/android/data/persistence/annotations/GroupedFileVersionEntities;", "<init>", "(Lcom/box/android/data/persistence/annotations/FileActivityEntity;Lcom/box/android/data/persistence/annotations/CommentEntity;Lcom/box/android/data/persistence/annotations/AnnotationEntity;Lcom/box/android/data/persistence/annotations/GroupedFileVersionEntities;)V", "getFileActivityEntity", "()Lcom/box/android/data/persistence/annotations/FileActivityEntity;", "getCommentEntity", "()Lcom/box/android/data/persistence/annotations/CommentEntity;", "getAnnotationEntity", "()Lcom/box/android/data/persistence/annotations/AnnotationEntity;", "getVersions", "()Lcom/box/android/data/persistence/annotations/GroupedFileVersionEntities;", "component1", "component2", "component3", "component4", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "", "other", "hashCode", "", "toString", "", "data_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final /* data */ class FileActivityEntities {
    private final AnnotationEntity annotationEntity;
    private final CommentEntity commentEntity;
    private final FileActivityEntity fileActivityEntity;
    private final GroupedFileVersionEntities versions;

    public static /* synthetic */ FileActivityEntities copy$default(FileActivityEntities fileActivityEntities, FileActivityEntity fileActivityEntity, CommentEntity commentEntity, AnnotationEntity annotationEntity, GroupedFileVersionEntities groupedFileVersionEntities, int i, Object obj) {
        if ((i & 1) != 0) {
            fileActivityEntity = fileActivityEntities.fileActivityEntity;
        }
        if ((i & 2) != 0) {
            commentEntity = fileActivityEntities.commentEntity;
        }
        if ((i & 4) != 0) {
            annotationEntity = fileActivityEntities.annotationEntity;
        }
        if ((i & 8) != 0) {
            groupedFileVersionEntities = fileActivityEntities.versions;
        }
        return fileActivityEntities.copy(fileActivityEntity, commentEntity, annotationEntity, groupedFileVersionEntities);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final FileActivityEntity getFileActivityEntity() {
        return this.fileActivityEntity;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final CommentEntity getCommentEntity() {
        return this.commentEntity;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final AnnotationEntity getAnnotationEntity() {
        return this.annotationEntity;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final GroupedFileVersionEntities getVersions() {
        return this.versions;
    }

    public final FileActivityEntities copy(FileActivityEntity fileActivityEntity, CommentEntity commentEntity, AnnotationEntity annotationEntity, GroupedFileVersionEntities versions) {
        Intrinsics.checkNotNullParameter(fileActivityEntity, "fileActivityEntity");
        return new FileActivityEntities(fileActivityEntity, commentEntity, annotationEntity, versions);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof FileActivityEntities)) {
            return false;
        }
        FileActivityEntities fileActivityEntities = (FileActivityEntities) other;
        return Intrinsics.areEqual(this.fileActivityEntity, fileActivityEntities.fileActivityEntity) && Intrinsics.areEqual(this.commentEntity, fileActivityEntities.commentEntity) && Intrinsics.areEqual(this.annotationEntity, fileActivityEntities.annotationEntity) && Intrinsics.areEqual(this.versions, fileActivityEntities.versions);
    }

    public int hashCode() {
        int iHashCode = this.fileActivityEntity.hashCode() * 31;
        CommentEntity commentEntity = this.commentEntity;
        int iHashCode2 = (iHashCode + (commentEntity == null ? 0 : commentEntity.hashCode())) * 31;
        AnnotationEntity annotationEntity = this.annotationEntity;
        int iHashCode3 = (iHashCode2 + (annotationEntity == null ? 0 : annotationEntity.hashCode())) * 31;
        GroupedFileVersionEntities groupedFileVersionEntities = this.versions;
        return iHashCode3 + (groupedFileVersionEntities != null ? groupedFileVersionEntities.hashCode() : 0);
    }

    public String toString() {
        return "FileActivityEntities(fileActivityEntity=" + this.fileActivityEntity + ", commentEntity=" + this.commentEntity + ", annotationEntity=" + this.annotationEntity + ", versions=" + this.versions + ")";
    }

    public FileActivityEntities(FileActivityEntity fileActivityEntity, CommentEntity commentEntity, AnnotationEntity annotationEntity, GroupedFileVersionEntities groupedFileVersionEntities) {
        Intrinsics.checkNotNullParameter(fileActivityEntity, "fileActivityEntity");
        this.fileActivityEntity = fileActivityEntity;
        this.commentEntity = commentEntity;
        this.annotationEntity = annotationEntity;
        this.versions = groupedFileVersionEntities;
    }

    public final FileActivityEntity getFileActivityEntity() {
        return this.fileActivityEntity;
    }

    public final CommentEntity getCommentEntity() {
        return this.commentEntity;
    }

    public final AnnotationEntity getAnnotationEntity() {
        return this.annotationEntity;
    }

    public final GroupedFileVersionEntities getVersions() {
        return this.versions;
    }
}
