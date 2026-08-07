package com.box.android.fileactivity.model;

import com.box.android.domain.analytics.BoxAmplitudeAnalytics;
import com.box.android.domain.models.annotations.AnnotationFileVersionModel;
import com.box.android.domain.models.annotations.FileActivityIdModel;
import com.box.android.domain.models.annotations.FileActivityPermissionsModel;
import com.box.android.domain.models.annotations.FileActivityType;
import com.google.firebase.analytics.FirebaseAnalytics;
import java.util.Date;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: FileActivityUIModelsV2.kt */
/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b'\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\u0085\u0001\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0003\u0012\u000e\b\u0002\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\n\u0012\b\u0010\f\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\r\u001a\u00020\u000e\u0012\u0006\u0010\u000f\u001a\u00020\u000e\u0012\u0006\u0010\u0010\u001a\u00020\u0011\u0012\u0006\u0010\u0012\u001a\u00020\u0013\u0012\u0006\u0010\u0014\u001a\u00020\u0015\u0012\u0006\u0010\u0016\u001a\u00020\u0015\u0012\u0006\u0010\u0017\u001a\u00020\u0018¢\u0006\u0004\b\u0019\u0010\u001aJ\t\u0010/\u001a\u00020\u0003HÆ\u0003J\t\u00100\u001a\u00020\u0005HÆ\u0003J\t\u00101\u001a\u00020\u0003HÆ\u0003J\u000b\u00102\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u00103\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000f\u00104\u001a\b\u0012\u0004\u0012\u00020\u000b0\nHÆ\u0003J\u000b\u00105\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u00106\u001a\u00020\u000eHÆ\u0003J\t\u00107\u001a\u00020\u000eHÆ\u0003J\t\u00108\u001a\u00020\u0011HÆ\u0003J\t\u00109\u001a\u00020\u0013HÆ\u0003J\t\u0010:\u001a\u00020\u0015HÆ\u0003J\t\u0010;\u001a\u00020\u0015HÆ\u0003J\t\u0010<\u001a\u00020\u0018HÆ\u0003J¡\u0001\u0010=\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00032\u000e\b\u0002\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\n2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\r\u001a\u00020\u000e2\b\b\u0002\u0010\u000f\u001a\u00020\u000e2\b\b\u0002\u0010\u0010\u001a\u00020\u00112\b\b\u0002\u0010\u0012\u001a\u00020\u00132\b\b\u0002\u0010\u0014\u001a\u00020\u00152\b\b\u0002\u0010\u0016\u001a\u00020\u00152\b\b\u0002\u0010\u0017\u001a\u00020\u0018HÆ\u0001J\u0013\u0010>\u001a\u00020\u00152\b\u0010?\u001a\u0004\u0018\u00010@HÖ\u0003J\t\u0010A\u001a\u00020BHÖ\u0001J\t\u0010C\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001cR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001eR\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010\u001cR\u0013\u0010\u0007\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b \u0010\u001cR\u0013\u0010\b\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\u001cR\u0017\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\n¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010#R\u0013\u0010\f\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b$\u0010\u001cR\u0011\u0010\r\u001a\u00020\u000e¢\u0006\b\n\u0000\u001a\u0004\b%\u0010&R\u0011\u0010\u000f\u001a\u00020\u000e¢\u0006\b\n\u0000\u001a\u0004\b'\u0010&R\u0011\u0010\u0010\u001a\u00020\u0011¢\u0006\b\n\u0000\u001a\u0004\b(\u0010)R\u0011\u0010\u0012\u001a\u00020\u0013¢\u0006\b\n\u0000\u001a\u0004\b*\u0010+R\u0011\u0010\u0014\u001a\u00020\u0015¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010,R\u0011\u0010\u0016\u001a\u00020\u0015¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010,R\u0011\u0010\u0017\u001a\u00020\u0018¢\u0006\b\n\u0000\u001a\u0004\b-\u0010.¨\u0006D"}, d2 = {"Lcom/box/android/fileactivity/model/AnnotationUIModelV2;", "Lcom/box/android/fileactivity/model/FileActivityUIModelV2;", "activityId", "", "description", "Lcom/box/android/fileactivity/model/TaggedMessageV2;", "createdByUserId", "createdByUserName", "createdByUserLogin", "replies", "", "Lcom/box/android/fileactivity/model/CommentUIModelV2;", "replyCountMessage", "createdAt", "Ljava/util/Date;", "modifiedAt", FirebaseAnalytics.Param.LOCATION, "Lcom/box/android/fileactivity/model/AnnotationLocationUIModel;", "version", "Lcom/box/android/domain/models/annotations/AnnotationFileVersionModel;", "isResolved", "", "isOnLatestVersion", "permissions", "Lcom/box/android/domain/models/annotations/FileActivityPermissionsModel;", "<init>", "(Ljava/lang/String;Lcom/box/android/fileactivity/model/TaggedMessageV2;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Ljava/lang/String;Ljava/util/Date;Ljava/util/Date;Lcom/box/android/fileactivity/model/AnnotationLocationUIModel;Lcom/box/android/domain/models/annotations/AnnotationFileVersionModel;ZZLcom/box/android/domain/models/annotations/FileActivityPermissionsModel;)V", "getActivityId", "()Ljava/lang/String;", "getDescription", "()Lcom/box/android/fileactivity/model/TaggedMessageV2;", "getCreatedByUserId", "getCreatedByUserName", "getCreatedByUserLogin", "getReplies", "()Ljava/util/List;", "getReplyCountMessage", "getCreatedAt", "()Ljava/util/Date;", "getModifiedAt", "getLocation", "()Lcom/box/android/fileactivity/model/AnnotationLocationUIModel;", "getVersion", "()Lcom/box/android/domain/models/annotations/AnnotationFileVersionModel;", "()Z", "getPermissions", "()Lcom/box/android/domain/models/annotations/FileActivityPermissionsModel;", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "component12", "component13", "component14", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "other", "", "hashCode", "", "toString", "file-activity_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final /* data */ class AnnotationUIModelV2 extends FileActivityUIModelV2 {
    public static final int $stable = 8;
    private final String activityId;
    private final Date createdAt;
    private final String createdByUserId;
    private final String createdByUserLogin;
    private final String createdByUserName;
    private final TaggedMessageV2 description;
    private final boolean isOnLatestVersion;
    private final boolean isResolved;
    private final AnnotationLocationUIModel location;
    private final Date modifiedAt;
    private final FileActivityPermissionsModel permissions;
    private final List<CommentUIModelV2> replies;
    private final String replyCountMessage;
    private final AnnotationFileVersionModel version;

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getActivityId() {
        return this.activityId;
    }

    /* JADX INFO: renamed from: component10, reason: from getter */
    public final AnnotationLocationUIModel getLocation() {
        return this.location;
    }

    /* JADX INFO: renamed from: component11, reason: from getter */
    public final AnnotationFileVersionModel getVersion() {
        return this.version;
    }

    /* JADX INFO: renamed from: component12, reason: from getter */
    public final boolean getIsResolved() {
        return this.isResolved;
    }

    /* JADX INFO: renamed from: component13, reason: from getter */
    public final boolean getIsOnLatestVersion() {
        return this.isOnLatestVersion;
    }

    /* JADX INFO: renamed from: component14, reason: from getter */
    public final FileActivityPermissionsModel getPermissions() {
        return this.permissions;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final TaggedMessageV2 getDescription() {
        return this.description;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final String getCreatedByUserId() {
        return this.createdByUserId;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final String getCreatedByUserName() {
        return this.createdByUserName;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final String getCreatedByUserLogin() {
        return this.createdByUserLogin;
    }

    public final List<CommentUIModelV2> component6() {
        return this.replies;
    }

    /* JADX INFO: renamed from: component7, reason: from getter */
    public final String getReplyCountMessage() {
        return this.replyCountMessage;
    }

    /* JADX INFO: renamed from: component8, reason: from getter */
    public final Date getCreatedAt() {
        return this.createdAt;
    }

    /* JADX INFO: renamed from: component9, reason: from getter */
    public final Date getModifiedAt() {
        return this.modifiedAt;
    }

    public final AnnotationUIModelV2 copy(String activityId, TaggedMessageV2 description, String createdByUserId, String createdByUserName, String createdByUserLogin, List<CommentUIModelV2> replies, String replyCountMessage, Date createdAt, Date modifiedAt, AnnotationLocationUIModel location, AnnotationFileVersionModel version, boolean isResolved, boolean isOnLatestVersion, FileActivityPermissionsModel permissions) {
        Intrinsics.checkNotNullParameter(activityId, "activityId");
        Intrinsics.checkNotNullParameter(description, "description");
        Intrinsics.checkNotNullParameter(createdByUserId, "createdByUserId");
        Intrinsics.checkNotNullParameter(replies, "replies");
        Intrinsics.checkNotNullParameter(createdAt, "createdAt");
        Intrinsics.checkNotNullParameter(modifiedAt, "modifiedAt");
        Intrinsics.checkNotNullParameter(location, "location");
        Intrinsics.checkNotNullParameter(version, "version");
        Intrinsics.checkNotNullParameter(permissions, "permissions");
        return new AnnotationUIModelV2(activityId, description, createdByUserId, createdByUserName, createdByUserLogin, replies, replyCountMessage, createdAt, modifiedAt, location, version, isResolved, isOnLatestVersion, permissions);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof AnnotationUIModelV2)) {
            return false;
        }
        AnnotationUIModelV2 annotationUIModelV2 = (AnnotationUIModelV2) other;
        return Intrinsics.areEqual(this.activityId, annotationUIModelV2.activityId) && Intrinsics.areEqual(this.description, annotationUIModelV2.description) && Intrinsics.areEqual(this.createdByUserId, annotationUIModelV2.createdByUserId) && Intrinsics.areEqual(this.createdByUserName, annotationUIModelV2.createdByUserName) && Intrinsics.areEqual(this.createdByUserLogin, annotationUIModelV2.createdByUserLogin) && Intrinsics.areEqual(this.replies, annotationUIModelV2.replies) && Intrinsics.areEqual(this.replyCountMessage, annotationUIModelV2.replyCountMessage) && Intrinsics.areEqual(this.createdAt, annotationUIModelV2.createdAt) && Intrinsics.areEqual(this.modifiedAt, annotationUIModelV2.modifiedAt) && Intrinsics.areEqual(this.location, annotationUIModelV2.location) && Intrinsics.areEqual(this.version, annotationUIModelV2.version) && this.isResolved == annotationUIModelV2.isResolved && this.isOnLatestVersion == annotationUIModelV2.isOnLatestVersion && Intrinsics.areEqual(this.permissions, annotationUIModelV2.permissions);
    }

    public int hashCode() {
        int iHashCode = ((((this.activityId.hashCode() * 31) + this.description.hashCode()) * 31) + this.createdByUserId.hashCode()) * 31;
        String str = this.createdByUserName;
        int iHashCode2 = (iHashCode + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.createdByUserLogin;
        int iHashCode3 = (((iHashCode2 + (str2 == null ? 0 : str2.hashCode())) * 31) + this.replies.hashCode()) * 31;
        String str3 = this.replyCountMessage;
        return ((((((((((((((iHashCode3 + (str3 != null ? str3.hashCode() : 0)) * 31) + this.createdAt.hashCode()) * 31) + this.modifiedAt.hashCode()) * 31) + this.location.hashCode()) * 31) + this.version.hashCode()) * 31) + Boolean.hashCode(this.isResolved)) * 31) + Boolean.hashCode(this.isOnLatestVersion)) * 31) + this.permissions.hashCode();
    }

    public String toString() {
        return "AnnotationUIModelV2(activityId=" + this.activityId + ", description=" + this.description + ", createdByUserId=" + this.createdByUserId + ", createdByUserName=" + this.createdByUserName + ", createdByUserLogin=" + this.createdByUserLogin + ", replies=" + this.replies + ", replyCountMessage=" + this.replyCountMessage + ", createdAt=" + this.createdAt + ", modifiedAt=" + this.modifiedAt + ", location=" + this.location + ", version=" + this.version + ", isResolved=" + this.isResolved + ", isOnLatestVersion=" + this.isOnLatestVersion + ", permissions=" + this.permissions + ")";
    }

    public final String getActivityId() {
        return this.activityId;
    }

    public final TaggedMessageV2 getDescription() {
        return this.description;
    }

    public final String getCreatedByUserId() {
        return this.createdByUserId;
    }

    public final String getCreatedByUserName() {
        return this.createdByUserName;
    }

    public final String getCreatedByUserLogin() {
        return this.createdByUserLogin;
    }

    public /* synthetic */ AnnotationUIModelV2(String str, TaggedMessageV2 taggedMessageV2, String str2, String str3, String str4, List list, String str5, Date date, Date date2, AnnotationLocationUIModel annotationLocationUIModel, AnnotationFileVersionModel annotationFileVersionModel, boolean z, boolean z2, FileActivityPermissionsModel fileActivityPermissionsModel, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, taggedMessageV2, str2, str3, str4, (i & 32) != 0 ? CollectionsKt.emptyList() : list, str5, date, date2, annotationLocationUIModel, annotationFileVersionModel, z, z2, fileActivityPermissionsModel);
    }

    public final List<CommentUIModelV2> getReplies() {
        return this.replies;
    }

    public final String getReplyCountMessage() {
        return this.replyCountMessage;
    }

    public final Date getCreatedAt() {
        return this.createdAt;
    }

    public final Date getModifiedAt() {
        return this.modifiedAt;
    }

    public final AnnotationLocationUIModel getLocation() {
        return this.location;
    }

    public final AnnotationFileVersionModel getVersion() {
        return this.version;
    }

    public final boolean isResolved() {
        return this.isResolved;
    }

    public final boolean isOnLatestVersion() {
        return this.isOnLatestVersion;
    }

    public final FileActivityPermissionsModel getPermissions() {
        return this.permissions;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AnnotationUIModelV2(String activityId, TaggedMessageV2 description, String createdByUserId, String str, String str2, List<CommentUIModelV2> replies, String str3, Date createdAt, Date modifiedAt, AnnotationLocationUIModel location, AnnotationFileVersionModel version, boolean z, boolean z2, FileActivityPermissionsModel permissions) {
        super(new FileActivityIdModel(activityId, FileActivityType.ANNOTATION), null);
        Intrinsics.checkNotNullParameter(activityId, "activityId");
        Intrinsics.checkNotNullParameter(description, "description");
        Intrinsics.checkNotNullParameter(createdByUserId, "createdByUserId");
        Intrinsics.checkNotNullParameter(replies, "replies");
        Intrinsics.checkNotNullParameter(createdAt, "createdAt");
        Intrinsics.checkNotNullParameter(modifiedAt, "modifiedAt");
        Intrinsics.checkNotNullParameter(location, "location");
        Intrinsics.checkNotNullParameter(version, "version");
        Intrinsics.checkNotNullParameter(permissions, "permissions");
        this.activityId = activityId;
        this.description = description;
        this.createdByUserId = createdByUserId;
        this.createdByUserName = str;
        this.createdByUserLogin = str2;
        this.replies = replies;
        this.replyCountMessage = str3;
        this.createdAt = createdAt;
        this.modifiedAt = modifiedAt;
        this.location = location;
        this.version = version;
        this.isResolved = z;
        this.isOnLatestVersion = z2;
        this.permissions = permissions;
    }
}
