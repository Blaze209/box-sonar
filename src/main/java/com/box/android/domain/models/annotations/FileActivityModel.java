package com.box.android.domain.models.annotations;

import com.box.android.domain.analytics.BoxAmplitudeAnalytics;
import com.box.android.domain.models.DomainModel;
import com.google.firebase.analytics.FirebaseAnalytics;
import java.util.Date;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: FileActivityModel.kt */
/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0004\u0004\u0005\u0006\u0007B\t\b\u0004¢\u0006\u0004\b\u0002\u0010\u0003\u0082\u0001\u0003\b\t\n¨\u0006\u000b"}, d2 = {"Lcom/box/android/domain/models/annotations/FileActivityModel;", "Lcom/box/android/domain/models/DomainModel;", "<init>", "()V", "AnnotationModel", "CommentModel", "Status", "GroupedFileVersionModel", "Lcom/box/android/domain/models/annotations/FileActivityModel$AnnotationModel;", "Lcom/box/android/domain/models/annotations/FileActivityModel$CommentModel;", "Lcom/box/android/domain/models/annotations/FileActivityModel$GroupedFileVersionModel;", "domain_prodRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public abstract class FileActivityModel implements DomainModel {

    /* JADX INFO: compiled from: FileActivityModel.kt */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/box/android/domain/models/annotations/FileActivityModel$Status;", "", "<init>", "(Ljava/lang/String;I)V", "OPEN", "RESOLVED", "DELETED", "domain_prodRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public enum Status {
        OPEN,
        RESOLVED,
        DELETED;

        private static final /* synthetic */ EnumEntries $ENTRIES = EnumEntriesKt.enumEntries(values());

        public static EnumEntries<Status> getEntries() {
            return $ENTRIES;
        }
    }

    public /* synthetic */ FileActivityModel(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    private FileActivityModel() {
    }

    /* JADX INFO: compiled from: FileActivityModel.kt */
    @Metadata(d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b%\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0086\b\u0018\u00002\u00020\u0001Bw\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u000e\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\u0006\u0010\f\u001a\u00020\u000b\u0012\u0006\u0010\r\u001a\u00020\u000e\u0012\u0006\u0010\u000f\u001a\u00020\u0010\u0012\u0006\u0010\u0011\u001a\u00020\u0012\u0012\u000e\b\u0002\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00140\u0006\u0012\u0006\u0010\u0015\u001a\u00020\u0016\u0012\u0006\u0010\u0017\u001a\u00020\u0018¢\u0006\u0004\b\u0019\u0010\u001aJ\t\u00100\u001a\u00020\u0003HÆ\u0003J\t\u00101\u001a\u00020\u0003HÆ\u0003J\u0011\u00102\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006HÆ\u0003J\t\u00103\u001a\u00020\tHÆ\u0003J\t\u00104\u001a\u00020\u000bHÆ\u0003J\t\u00105\u001a\u00020\u000bHÆ\u0003J\t\u00106\u001a\u00020\u000eHÆ\u0003J\t\u00107\u001a\u00020\u0010HÆ\u0003J\t\u00108\u001a\u00020\u0012HÆ\u0003J\u000f\u00109\u001a\b\u0012\u0004\u0012\u00020\u00140\u0006HÆ\u0003J\t\u0010:\u001a\u00020\u0016HÆ\u0003J\t\u0010;\u001a\u00020\u0018HÆ\u0003J\u008f\u0001\u0010<\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\u0010\b\u0002\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u00062\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\f\u001a\u00020\u000b2\b\b\u0002\u0010\r\u001a\u00020\u000e2\b\b\u0002\u0010\u000f\u001a\u00020\u00102\b\b\u0002\u0010\u0011\u001a\u00020\u00122\u000e\b\u0002\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00140\u00062\b\b\u0002\u0010\u0015\u001a\u00020\u00162\b\b\u0002\u0010\u0017\u001a\u00020\u0018HÆ\u0001J\u0013\u0010=\u001a\u00020>2\b\u0010?\u001a\u0004\u0018\u00010@HÖ\u0003J\t\u0010A\u001a\u00020\u0016HÖ\u0001J\t\u0010B\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001cR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001cR\u0019\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001fR\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b \u0010!R\u0011\u0010\n\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010#R\u0011\u0010\f\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b$\u0010#R\u0011\u0010\r\u001a\u00020\u000e¢\u0006\b\n\u0000\u001a\u0004\b%\u0010&R\u0011\u0010\u000f\u001a\u00020\u0010¢\u0006\b\n\u0000\u001a\u0004\b'\u0010(R\u0011\u0010\u0011\u001a\u00020\u0012¢\u0006\b\n\u0000\u001a\u0004\b)\u0010*R\u0017\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00140\u0006¢\u0006\b\n\u0000\u001a\u0004\b+\u0010\u001fR\u0011\u0010\u0015\u001a\u00020\u0016¢\u0006\b\n\u0000\u001a\u0004\b,\u0010-R\u0011\u0010\u0017\u001a\u00020\u0018¢\u0006\b\n\u0000\u001a\u0004\b.\u0010/¨\u0006C"}, d2 = {"Lcom/box/android/domain/models/annotations/FileActivityModel$AnnotationModel;", "Lcom/box/android/domain/models/annotations/FileActivityModel;", "id", "", "description", "mentions", "", "Lcom/box/android/domain/models/annotations/CommentMentionModel;", "fileVersion", "Lcom/box/android/domain/models/annotations/AnnotationFileVersionModel;", "created", "Lcom/box/android/domain/models/annotations/UserEventModel;", "modified", "target", "Lcom/box/android/domain/models/annotations/AnnotationTargetModel;", FirebaseAnalytics.Param.LOCATION, "Lcom/box/android/domain/models/annotations/AnnotationLocationModel;", "permissions", "Lcom/box/android/domain/models/annotations/FileActivityPermissionsModel;", "replies", "Lcom/box/android/domain/models/annotations/FileActivityModel$CommentModel;", "totalReplyCount", "", "status", "Lcom/box/android/domain/models/annotations/FileActivityModel$Status;", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Lcom/box/android/domain/models/annotations/AnnotationFileVersionModel;Lcom/box/android/domain/models/annotations/UserEventModel;Lcom/box/android/domain/models/annotations/UserEventModel;Lcom/box/android/domain/models/annotations/AnnotationTargetModel;Lcom/box/android/domain/models/annotations/AnnotationLocationModel;Lcom/box/android/domain/models/annotations/FileActivityPermissionsModel;Ljava/util/List;ILcom/box/android/domain/models/annotations/FileActivityModel$Status;)V", "getId", "()Ljava/lang/String;", "getDescription", "getMentions", "()Ljava/util/List;", "getFileVersion", "()Lcom/box/android/domain/models/annotations/AnnotationFileVersionModel;", "getCreated", "()Lcom/box/android/domain/models/annotations/UserEventModel;", "getModified", "getTarget", "()Lcom/box/android/domain/models/annotations/AnnotationTargetModel;", "getLocation", "()Lcom/box/android/domain/models/annotations/AnnotationLocationModel;", "getPermissions", "()Lcom/box/android/domain/models/annotations/FileActivityPermissionsModel;", "getReplies", "getTotalReplyCount", "()I", "getStatus", "()Lcom/box/android/domain/models/annotations/FileActivityModel$Status;", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "component12", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "", "other", "", "hashCode", "toString", "domain_prodRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final /* data */ class AnnotationModel extends FileActivityModel {
        private final UserEventModel created;
        private final String description;
        private final AnnotationFileVersionModel fileVersion;
        private final String id;
        private final AnnotationLocationModel location;
        private final List<CommentMentionModel> mentions;
        private final UserEventModel modified;
        private final FileActivityPermissionsModel permissions;
        private final List<CommentModel> replies;
        private final Status status;
        private final AnnotationTargetModel target;
        private final int totalReplyCount;

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ AnnotationModel copy$default(AnnotationModel annotationModel, String str, String str2, List list, AnnotationFileVersionModel annotationFileVersionModel, UserEventModel userEventModel, UserEventModel userEventModel2, AnnotationTargetModel annotationTargetModel, AnnotationLocationModel annotationLocationModel, FileActivityPermissionsModel fileActivityPermissionsModel, List list2, int i, Status status, int i2, Object obj) {
            if ((i2 & 1) != 0) {
                str = annotationModel.id;
            }
            if ((i2 & 2) != 0) {
                str2 = annotationModel.description;
            }
            if ((i2 & 4) != 0) {
                list = annotationModel.mentions;
            }
            if ((i2 & 8) != 0) {
                annotationFileVersionModel = annotationModel.fileVersion;
            }
            if ((i2 & 16) != 0) {
                userEventModel = annotationModel.created;
            }
            if ((i2 & 32) != 0) {
                userEventModel2 = annotationModel.modified;
            }
            if ((i2 & 64) != 0) {
                annotationTargetModel = annotationModel.target;
            }
            if ((i2 & 128) != 0) {
                annotationLocationModel = annotationModel.location;
            }
            if ((i2 & 256) != 0) {
                fileActivityPermissionsModel = annotationModel.permissions;
            }
            if ((i2 & 512) != 0) {
                list2 = annotationModel.replies;
            }
            if ((i2 & 1024) != 0) {
                i = annotationModel.totalReplyCount;
            }
            if ((i2 & 2048) != 0) {
                status = annotationModel.status;
            }
            int i3 = i;
            Status status2 = status;
            FileActivityPermissionsModel fileActivityPermissionsModel2 = fileActivityPermissionsModel;
            List list3 = list2;
            AnnotationTargetModel annotationTargetModel2 = annotationTargetModel;
            AnnotationLocationModel annotationLocationModel2 = annotationLocationModel;
            UserEventModel userEventModel3 = userEventModel;
            UserEventModel userEventModel4 = userEventModel2;
            return annotationModel.copy(str, str2, list, annotationFileVersionModel, userEventModel3, userEventModel4, annotationTargetModel2, annotationLocationModel2, fileActivityPermissionsModel2, list3, i3, status2);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final String getId() {
            return this.id;
        }

        public final List<CommentModel> component10() {
            return this.replies;
        }

        /* JADX INFO: renamed from: component11, reason: from getter */
        public final int getTotalReplyCount() {
            return this.totalReplyCount;
        }

        /* JADX INFO: renamed from: component12, reason: from getter */
        public final Status getStatus() {
            return this.status;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final String getDescription() {
            return this.description;
        }

        public final List<CommentMentionModel> component3() {
            return this.mentions;
        }

        /* JADX INFO: renamed from: component4, reason: from getter */
        public final AnnotationFileVersionModel getFileVersion() {
            return this.fileVersion;
        }

        /* JADX INFO: renamed from: component5, reason: from getter */
        public final UserEventModel getCreated() {
            return this.created;
        }

        /* JADX INFO: renamed from: component6, reason: from getter */
        public final UserEventModel getModified() {
            return this.modified;
        }

        /* JADX INFO: renamed from: component7, reason: from getter */
        public final AnnotationTargetModel getTarget() {
            return this.target;
        }

        /* JADX INFO: renamed from: component8, reason: from getter */
        public final AnnotationLocationModel getLocation() {
            return this.location;
        }

        /* JADX INFO: renamed from: component9, reason: from getter */
        public final FileActivityPermissionsModel getPermissions() {
            return this.permissions;
        }

        public final AnnotationModel copy(String id, String description, List<CommentMentionModel> mentions, AnnotationFileVersionModel fileVersion, UserEventModel created, UserEventModel modified, AnnotationTargetModel target, AnnotationLocationModel location, FileActivityPermissionsModel permissions, List<CommentModel> replies, int totalReplyCount, Status status) {
            Intrinsics.checkNotNullParameter(id, "id");
            Intrinsics.checkNotNullParameter(description, "description");
            Intrinsics.checkNotNullParameter(fileVersion, "fileVersion");
            Intrinsics.checkNotNullParameter(created, "created");
            Intrinsics.checkNotNullParameter(modified, "modified");
            Intrinsics.checkNotNullParameter(target, "target");
            Intrinsics.checkNotNullParameter(location, "location");
            Intrinsics.checkNotNullParameter(permissions, "permissions");
            Intrinsics.checkNotNullParameter(replies, "replies");
            Intrinsics.checkNotNullParameter(status, "status");
            return new AnnotationModel(id, description, mentions, fileVersion, created, modified, target, location, permissions, replies, totalReplyCount, status);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof AnnotationModel)) {
                return false;
            }
            AnnotationModel annotationModel = (AnnotationModel) other;
            return Intrinsics.areEqual(this.id, annotationModel.id) && Intrinsics.areEqual(this.description, annotationModel.description) && Intrinsics.areEqual(this.mentions, annotationModel.mentions) && Intrinsics.areEqual(this.fileVersion, annotationModel.fileVersion) && Intrinsics.areEqual(this.created, annotationModel.created) && Intrinsics.areEqual(this.modified, annotationModel.modified) && Intrinsics.areEqual(this.target, annotationModel.target) && Intrinsics.areEqual(this.location, annotationModel.location) && Intrinsics.areEqual(this.permissions, annotationModel.permissions) && Intrinsics.areEqual(this.replies, annotationModel.replies) && this.totalReplyCount == annotationModel.totalReplyCount && this.status == annotationModel.status;
        }

        public int hashCode() {
            int iHashCode = ((this.id.hashCode() * 31) + this.description.hashCode()) * 31;
            List<CommentMentionModel> list = this.mentions;
            return ((((((((((((((((((iHashCode + (list == null ? 0 : list.hashCode())) * 31) + this.fileVersion.hashCode()) * 31) + this.created.hashCode()) * 31) + this.modified.hashCode()) * 31) + this.target.hashCode()) * 31) + this.location.hashCode()) * 31) + this.permissions.hashCode()) * 31) + this.replies.hashCode()) * 31) + Integer.hashCode(this.totalReplyCount)) * 31) + this.status.hashCode();
        }

        public String toString() {
            return "AnnotationModel(id=" + this.id + ", description=" + this.description + ", mentions=" + this.mentions + ", fileVersion=" + this.fileVersion + ", created=" + this.created + ", modified=" + this.modified + ", target=" + this.target + ", location=" + this.location + ", permissions=" + this.permissions + ", replies=" + this.replies + ", totalReplyCount=" + this.totalReplyCount + ", status=" + this.status + ")";
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnnotationModel(String id, String description, List<CommentMentionModel> list, AnnotationFileVersionModel fileVersion, UserEventModel created, UserEventModel modified, AnnotationTargetModel target, AnnotationLocationModel location, FileActivityPermissionsModel permissions, List<CommentModel> replies, int i, Status status) {
            super(null);
            Intrinsics.checkNotNullParameter(id, "id");
            Intrinsics.checkNotNullParameter(description, "description");
            Intrinsics.checkNotNullParameter(fileVersion, "fileVersion");
            Intrinsics.checkNotNullParameter(created, "created");
            Intrinsics.checkNotNullParameter(modified, "modified");
            Intrinsics.checkNotNullParameter(target, "target");
            Intrinsics.checkNotNullParameter(location, "location");
            Intrinsics.checkNotNullParameter(permissions, "permissions");
            Intrinsics.checkNotNullParameter(replies, "replies");
            Intrinsics.checkNotNullParameter(status, "status");
            this.id = id;
            this.description = description;
            this.mentions = list;
            this.fileVersion = fileVersion;
            this.created = created;
            this.modified = modified;
            this.target = target;
            this.location = location;
            this.permissions = permissions;
            this.replies = replies;
            this.totalReplyCount = i;
            this.status = status;
        }

        public final String getId() {
            return this.id;
        }

        public final String getDescription() {
            return this.description;
        }

        public final List<CommentMentionModel> getMentions() {
            return this.mentions;
        }

        public final AnnotationFileVersionModel getFileVersion() {
            return this.fileVersion;
        }

        public final UserEventModel getCreated() {
            return this.created;
        }

        public final UserEventModel getModified() {
            return this.modified;
        }

        public final AnnotationTargetModel getTarget() {
            return this.target;
        }

        public final AnnotationLocationModel getLocation() {
            return this.location;
        }

        public final FileActivityPermissionsModel getPermissions() {
            return this.permissions;
        }

        public /* synthetic */ AnnotationModel(String str, String str2, List list, AnnotationFileVersionModel annotationFileVersionModel, UserEventModel userEventModel, UserEventModel userEventModel2, AnnotationTargetModel annotationTargetModel, AnnotationLocationModel annotationLocationModel, FileActivityPermissionsModel fileActivityPermissionsModel, List list2, int i, Status status, int i2, DefaultConstructorMarker defaultConstructorMarker) {
            this(str, str2, list, annotationFileVersionModel, userEventModel, userEventModel2, annotationTargetModel, annotationLocationModel, fileActivityPermissionsModel, (i2 & 512) != 0 ? CollectionsKt.emptyList() : list2, i, status);
        }

        public final List<CommentModel> getReplies() {
            return this.replies;
        }

        public final int getTotalReplyCount() {
            return this.totalReplyCount;
        }

        public final Status getStatus() {
            return this.status;
        }
    }

    /* JADX INFO: compiled from: FileActivityModel.kt */
    @Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b \n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0086\b\u0018\u00002\u00020\u0001Bm\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006\u0012\u0006\u0010\b\u001a\u00020\t\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u000b\u0012\u000e\b\u0002\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00000\u0006\u0012\b\b\u0002\u0010\r\u001a\u00020\u000e\u0012\b\b\u0002\u0010\u000f\u001a\u00020\u0010\u0012\u0006\u0010\u0011\u001a\u00020\u0012\u0012\b\u0010\u0013\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0014\u0010\u0015J\t\u0010'\u001a\u00020\u0003HÆ\u0003J\t\u0010(\u001a\u00020\u0003HÆ\u0003J\u000f\u0010)\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006HÆ\u0003J\t\u0010*\u001a\u00020\tHÆ\u0003J\u000b\u0010+\u001a\u0004\u0018\u00010\u000bHÆ\u0003J\u000f\u0010,\u001a\b\u0012\u0004\u0012\u00020\u00000\u0006HÆ\u0003J\t\u0010-\u001a\u00020\u000eHÆ\u0003J\t\u0010.\u001a\u00020\u0010HÆ\u0003J\t\u0010/\u001a\u00020\u0012HÆ\u0003J\u000b\u00100\u001a\u0004\u0018\u00010\u0003HÆ\u0003J}\u00101\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\u000e\b\u0002\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\b\b\u0002\u0010\b\u001a\u00020\t2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b2\u000e\b\u0002\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00000\u00062\b\b\u0002\u0010\r\u001a\u00020\u000e2\b\b\u0002\u0010\u000f\u001a\u00020\u00102\b\b\u0002\u0010\u0011\u001a\u00020\u00122\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u00102\u001a\u0002032\b\u00104\u001a\u0004\u0018\u000105HÖ\u0003J\t\u00106\u001a\u00020\u000eHÖ\u0001J\t\u00107\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0017R\u0017\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001aR\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001cR\u0013\u0010\n\u001a\u0004\u0018\u00010\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001eR\u0017\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00000\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010\u001aR\u0011\u0010\r\u001a\u00020\u000e¢\u0006\b\n\u0000\u001a\u0004\b \u0010!R\u0011\u0010\u000f\u001a\u00020\u0010¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010#R\u0011\u0010\u0011\u001a\u00020\u0012¢\u0006\b\n\u0000\u001a\u0004\b$\u0010%R\u0013\u0010\u0013\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b&\u0010\u0017¨\u00068"}, d2 = {"Lcom/box/android/domain/models/annotations/FileActivityModel$CommentModel;", "Lcom/box/android/domain/models/annotations/FileActivityModel;", "id", "", "message", "mentions", "", "Lcom/box/android/domain/models/annotations/CommentMentionModel;", "created", "Lcom/box/android/domain/models/annotations/UserEventModel;", "modifiedDate", "Ljava/util/Date;", "replies", "totalReplyCount", "", "status", "Lcom/box/android/domain/models/annotations/FileActivityModel$Status;", "permissions", "Lcom/box/android/domain/models/annotations/FileActivityPermissionsModel;", "parentFileActivityId", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Lcom/box/android/domain/models/annotations/UserEventModel;Ljava/util/Date;Ljava/util/List;ILcom/box/android/domain/models/annotations/FileActivityModel$Status;Lcom/box/android/domain/models/annotations/FileActivityPermissionsModel;Ljava/lang/String;)V", "getId", "()Ljava/lang/String;", "getMessage", "getMentions", "()Ljava/util/List;", "getCreated", "()Lcom/box/android/domain/models/annotations/UserEventModel;", "getModifiedDate", "()Ljava/util/Date;", "getReplies", "getTotalReplyCount", "()I", "getStatus", "()Lcom/box/android/domain/models/annotations/FileActivityModel$Status;", "getPermissions", "()Lcom/box/android/domain/models/annotations/FileActivityPermissionsModel;", "getParentFileActivityId", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "", "other", "", "hashCode", "toString", "domain_prodRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final /* data */ class CommentModel extends FileActivityModel {
        private final UserEventModel created;
        private final String id;
        private final List<CommentMentionModel> mentions;
        private final String message;
        private final Date modifiedDate;
        private final String parentFileActivityId;
        private final FileActivityPermissionsModel permissions;
        private final List<CommentModel> replies;
        private final Status status;
        private final int totalReplyCount;

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ CommentModel copy$default(CommentModel commentModel, String str, String str2, List list, UserEventModel userEventModel, Date date, List list2, int i, Status status, FileActivityPermissionsModel fileActivityPermissionsModel, String str3, int i2, Object obj) {
            if ((i2 & 1) != 0) {
                str = commentModel.id;
            }
            if ((i2 & 2) != 0) {
                str2 = commentModel.message;
            }
            if ((i2 & 4) != 0) {
                list = commentModel.mentions;
            }
            if ((i2 & 8) != 0) {
                userEventModel = commentModel.created;
            }
            if ((i2 & 16) != 0) {
                date = commentModel.modifiedDate;
            }
            if ((i2 & 32) != 0) {
                list2 = commentModel.replies;
            }
            if ((i2 & 64) != 0) {
                i = commentModel.totalReplyCount;
            }
            if ((i2 & 128) != 0) {
                status = commentModel.status;
            }
            if ((i2 & 256) != 0) {
                fileActivityPermissionsModel = commentModel.permissions;
            }
            if ((i2 & 512) != 0) {
                str3 = commentModel.parentFileActivityId;
            }
            FileActivityPermissionsModel fileActivityPermissionsModel2 = fileActivityPermissionsModel;
            String str4 = str3;
            int i3 = i;
            Status status2 = status;
            Date date2 = date;
            List list3 = list2;
            return commentModel.copy(str, str2, list, userEventModel, date2, list3, i3, status2, fileActivityPermissionsModel2, str4);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final String getId() {
            return this.id;
        }

        /* JADX INFO: renamed from: component10, reason: from getter */
        public final String getParentFileActivityId() {
            return this.parentFileActivityId;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final String getMessage() {
            return this.message;
        }

        public final List<CommentMentionModel> component3() {
            return this.mentions;
        }

        /* JADX INFO: renamed from: component4, reason: from getter */
        public final UserEventModel getCreated() {
            return this.created;
        }

        /* JADX INFO: renamed from: component5, reason: from getter */
        public final Date getModifiedDate() {
            return this.modifiedDate;
        }

        public final List<CommentModel> component6() {
            return this.replies;
        }

        /* JADX INFO: renamed from: component7, reason: from getter */
        public final int getTotalReplyCount() {
            return this.totalReplyCount;
        }

        /* JADX INFO: renamed from: component8, reason: from getter */
        public final Status getStatus() {
            return this.status;
        }

        /* JADX INFO: renamed from: component9, reason: from getter */
        public final FileActivityPermissionsModel getPermissions() {
            return this.permissions;
        }

        public final CommentModel copy(String id, String message, List<CommentMentionModel> mentions, UserEventModel created, Date modifiedDate, List<CommentModel> replies, int totalReplyCount, Status status, FileActivityPermissionsModel permissions, String parentFileActivityId) {
            Intrinsics.checkNotNullParameter(id, "id");
            Intrinsics.checkNotNullParameter(message, "message");
            Intrinsics.checkNotNullParameter(mentions, "mentions");
            Intrinsics.checkNotNullParameter(created, "created");
            Intrinsics.checkNotNullParameter(replies, "replies");
            Intrinsics.checkNotNullParameter(status, "status");
            Intrinsics.checkNotNullParameter(permissions, "permissions");
            return new CommentModel(id, message, mentions, created, modifiedDate, replies, totalReplyCount, status, permissions, parentFileActivityId);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof CommentModel)) {
                return false;
            }
            CommentModel commentModel = (CommentModel) other;
            return Intrinsics.areEqual(this.id, commentModel.id) && Intrinsics.areEqual(this.message, commentModel.message) && Intrinsics.areEqual(this.mentions, commentModel.mentions) && Intrinsics.areEqual(this.created, commentModel.created) && Intrinsics.areEqual(this.modifiedDate, commentModel.modifiedDate) && Intrinsics.areEqual(this.replies, commentModel.replies) && this.totalReplyCount == commentModel.totalReplyCount && this.status == commentModel.status && Intrinsics.areEqual(this.permissions, commentModel.permissions) && Intrinsics.areEqual(this.parentFileActivityId, commentModel.parentFileActivityId);
        }

        public int hashCode() {
            int iHashCode = ((((((this.id.hashCode() * 31) + this.message.hashCode()) * 31) + this.mentions.hashCode()) * 31) + this.created.hashCode()) * 31;
            Date date = this.modifiedDate;
            int iHashCode2 = (((((((((iHashCode + (date == null ? 0 : date.hashCode())) * 31) + this.replies.hashCode()) * 31) + Integer.hashCode(this.totalReplyCount)) * 31) + this.status.hashCode()) * 31) + this.permissions.hashCode()) * 31;
            String str = this.parentFileActivityId;
            return iHashCode2 + (str != null ? str.hashCode() : 0);
        }

        public String toString() {
            return "CommentModel(id=" + this.id + ", message=" + this.message + ", mentions=" + this.mentions + ", created=" + this.created + ", modifiedDate=" + this.modifiedDate + ", replies=" + this.replies + ", totalReplyCount=" + this.totalReplyCount + ", status=" + this.status + ", permissions=" + this.permissions + ", parentFileActivityId=" + this.parentFileActivityId + ")";
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public CommentModel(String id, String message, List<CommentMentionModel> mentions, UserEventModel created, Date date, List<CommentModel> replies, int i, Status status, FileActivityPermissionsModel permissions, String str) {
            super(null);
            Intrinsics.checkNotNullParameter(id, "id");
            Intrinsics.checkNotNullParameter(message, "message");
            Intrinsics.checkNotNullParameter(mentions, "mentions");
            Intrinsics.checkNotNullParameter(created, "created");
            Intrinsics.checkNotNullParameter(replies, "replies");
            Intrinsics.checkNotNullParameter(status, "status");
            Intrinsics.checkNotNullParameter(permissions, "permissions");
            this.id = id;
            this.message = message;
            this.mentions = mentions;
            this.created = created;
            this.modifiedDate = date;
            this.replies = replies;
            this.totalReplyCount = i;
            this.status = status;
            this.permissions = permissions;
            this.parentFileActivityId = str;
        }

        public final String getId() {
            return this.id;
        }

        public final String getMessage() {
            return this.message;
        }

        public final List<CommentMentionModel> getMentions() {
            return this.mentions;
        }

        public final UserEventModel getCreated() {
            return this.created;
        }

        public final Date getModifiedDate() {
            return this.modifiedDate;
        }

        public /* synthetic */ CommentModel(String str, String str2, List list, UserEventModel userEventModel, Date date, List list2, int i, Status status, FileActivityPermissionsModel fileActivityPermissionsModel, String str3, int i2, DefaultConstructorMarker defaultConstructorMarker) {
            this(str, str2, list, userEventModel, date, (i2 & 32) != 0 ? CollectionsKt.emptyList() : list2, (i2 & 64) != 0 ? 0 : i, (i2 & 128) != 0 ? Status.OPEN : status, fileActivityPermissionsModel, str3);
        }

        public final List<CommentModel> getReplies() {
            return this.replies;
        }

        public final int getTotalReplyCount() {
            return this.totalReplyCount;
        }

        public final Status getStatus() {
            return this.status;
        }

        public final FileActivityPermissionsModel getPermissions() {
            return this.permissions;
        }

        public final String getParentFileActivityId() {
            return this.parentFileActivityId;
        }
    }

    /* JADX INFO: compiled from: FileActivityModel.kt */
    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\f\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0086\b\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006¢\u0006\u0004\b\b\u0010\tJ\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\u000f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006HÆ\u0003J-\u0010\u0012\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\u000e\b\u0002\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006HÆ\u0001J\u0013\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016HÖ\u0003J\t\u0010\u0017\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0018\u001a\u00020\u0007HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u000bR\u0017\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000e¨\u0006\u0019"}, d2 = {"Lcom/box/android/domain/models/annotations/FileActivityModel$GroupedFileVersionModel;", "Lcom/box/android/domain/models/annotations/FileActivityModel;", "startNumber", "", "endNumber", "createdByNames", "", "", "<init>", "(IILjava/util/List;)V", "getStartNumber", "()I", "getEndNumber", "getCreatedByNames", "()Ljava/util/List;", "component1", "component2", "component3", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "", "other", "", "hashCode", "toString", "domain_prodRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final /* data */ class GroupedFileVersionModel extends FileActivityModel {
        private final List<String> createdByNames;
        private final int endNumber;
        private final int startNumber;

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ GroupedFileVersionModel copy$default(GroupedFileVersionModel groupedFileVersionModel, int i, int i2, List list, int i3, Object obj) {
            if ((i3 & 1) != 0) {
                i = groupedFileVersionModel.startNumber;
            }
            if ((i3 & 2) != 0) {
                i2 = groupedFileVersionModel.endNumber;
            }
            if ((i3 & 4) != 0) {
                list = groupedFileVersionModel.createdByNames;
            }
            return groupedFileVersionModel.copy(i, i2, list);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final int getStartNumber() {
            return this.startNumber;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final int getEndNumber() {
            return this.endNumber;
        }

        public final List<String> component3() {
            return this.createdByNames;
        }

        public final GroupedFileVersionModel copy(int startNumber, int endNumber, List<String> createdByNames) {
            Intrinsics.checkNotNullParameter(createdByNames, "createdByNames");
            return new GroupedFileVersionModel(startNumber, endNumber, createdByNames);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof GroupedFileVersionModel)) {
                return false;
            }
            GroupedFileVersionModel groupedFileVersionModel = (GroupedFileVersionModel) other;
            return this.startNumber == groupedFileVersionModel.startNumber && this.endNumber == groupedFileVersionModel.endNumber && Intrinsics.areEqual(this.createdByNames, groupedFileVersionModel.createdByNames);
        }

        public int hashCode() {
            return (((Integer.hashCode(this.startNumber) * 31) + Integer.hashCode(this.endNumber)) * 31) + this.createdByNames.hashCode();
        }

        public String toString() {
            return "GroupedFileVersionModel(startNumber=" + this.startNumber + ", endNumber=" + this.endNumber + ", createdByNames=" + this.createdByNames + ")";
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public GroupedFileVersionModel(int i, int i2, List<String> createdByNames) {
            super(null);
            Intrinsics.checkNotNullParameter(createdByNames, "createdByNames");
            this.startNumber = i;
            this.endNumber = i2;
            this.createdByNames = createdByNames;
        }

        public final List<String> getCreatedByNames() {
            return this.createdByNames;
        }

        public final int getEndNumber() {
            return this.endNumber;
        }

        public final int getStartNumber() {
            return this.startNumber;
        }
    }
}
