package com.box.android.fileactivity.model;

import com.box.android.domain.analytics.BoxAmplitudeAnalytics;
import com.box.android.domain.models.annotations.FileActivityIdModel;
import com.box.android.domain.models.annotations.FileActivityPermissionsModel;
import com.box.android.domain.models.annotations.FileActivityType;
import java.util.Date;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: FileActivityUIModelsV2.kt */
/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b \n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001Bm\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0003\u0012\u000e\b\u0002\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00000\n\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\f\u001a\u00020\r\u0012\u0006\u0010\u000e\u001a\u00020\r\u0012\u0006\u0010\u000f\u001a\u00020\u0010\u0012\u0006\u0010\u0011\u001a\u00020\u0012¢\u0006\u0004\b\u0013\u0010\u0014J\t\u0010%\u001a\u00020\u0003HÆ\u0003J\t\u0010&\u001a\u00020\u0005HÆ\u0003J\t\u0010'\u001a\u00020\u0003HÆ\u0003J\u000b\u0010(\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010)\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000f\u0010*\u001a\b\u0012\u0004\u0012\u00020\u00000\nHÆ\u0003J\u000b\u0010+\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010,\u001a\u00020\rHÆ\u0003J\t\u0010-\u001a\u00020\rHÆ\u0003J\t\u0010.\u001a\u00020\u0010HÆ\u0003J\t\u0010/\u001a\u00020\u0012HÆ\u0003J\u0083\u0001\u00100\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00032\u000e\b\u0002\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00000\n2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\f\u001a\u00020\r2\b\b\u0002\u0010\u000e\u001a\u00020\r2\b\b\u0002\u0010\u000f\u001a\u00020\u00102\b\b\u0002\u0010\u0011\u001a\u00020\u0012HÆ\u0001J\u0013\u00101\u001a\u00020\u00102\b\u00102\u001a\u0004\u0018\u000103HÖ\u0003J\t\u00104\u001a\u000205HÖ\u0001J\t\u00106\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0016R\u0013\u0010\u0007\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0016R\u0013\u0010\b\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u0016R\u0017\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00000\n¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001dR\u0013\u0010\u000b\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u0016R\u0011\u0010\f\u001a\u00020\r¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010 R\u0011\u0010\u000e\u001a\u00020\r¢\u0006\b\n\u0000\u001a\u0004\b!\u0010 R\u0011\u0010\u000f\u001a\u00020\u0010¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\"R\u0011\u0010\u0011\u001a\u00020\u0012¢\u0006\b\n\u0000\u001a\u0004\b#\u0010$¨\u00067"}, d2 = {"Lcom/box/android/fileactivity/model/CommentUIModelV2;", "Lcom/box/android/fileactivity/model/FileActivityUIModelV2;", "activityId", "", "message", "Lcom/box/android/fileactivity/model/TaggedMessageV2;", "createdByUserId", "createdByUserName", "createdByUserLogin", "replies", "", "replyCountMessage", "createdAt", "Ljava/util/Date;", "modifiedAt", "isResolved", "", "permissions", "Lcom/box/android/domain/models/annotations/FileActivityPermissionsModel;", "<init>", "(Ljava/lang/String;Lcom/box/android/fileactivity/model/TaggedMessageV2;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Ljava/lang/String;Ljava/util/Date;Ljava/util/Date;ZLcom/box/android/domain/models/annotations/FileActivityPermissionsModel;)V", "getActivityId", "()Ljava/lang/String;", "getMessage", "()Lcom/box/android/fileactivity/model/TaggedMessageV2;", "getCreatedByUserId", "getCreatedByUserName", "getCreatedByUserLogin", "getReplies", "()Ljava/util/List;", "getReplyCountMessage", "getCreatedAt", "()Ljava/util/Date;", "getModifiedAt", "()Z", "getPermissions", "()Lcom/box/android/domain/models/annotations/FileActivityPermissionsModel;", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "other", "", "hashCode", "", "toString", "file-activity_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final /* data */ class CommentUIModelV2 extends FileActivityUIModelV2 {
    public static final int $stable = 8;
    private final String activityId;
    private final Date createdAt;
    private final String createdByUserId;
    private final String createdByUserLogin;
    private final String createdByUserName;
    private final boolean isResolved;
    private final TaggedMessageV2 message;
    private final Date modifiedAt;
    private final FileActivityPermissionsModel permissions;
    private final List<CommentUIModelV2> replies;
    private final String replyCountMessage;

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ CommentUIModelV2 copy$default(CommentUIModelV2 commentUIModelV2, String str, TaggedMessageV2 taggedMessageV2, String str2, String str3, String str4, List list, String str5, Date date, Date date2, boolean z, FileActivityPermissionsModel fileActivityPermissionsModel, int i, Object obj) {
        if ((i & 1) != 0) {
            str = commentUIModelV2.activityId;
        }
        if ((i & 2) != 0) {
            taggedMessageV2 = commentUIModelV2.message;
        }
        if ((i & 4) != 0) {
            str2 = commentUIModelV2.createdByUserId;
        }
        if ((i & 8) != 0) {
            str3 = commentUIModelV2.createdByUserName;
        }
        if ((i & 16) != 0) {
            str4 = commentUIModelV2.createdByUserLogin;
        }
        if ((i & 32) != 0) {
            list = commentUIModelV2.replies;
        }
        if ((i & 64) != 0) {
            str5 = commentUIModelV2.replyCountMessage;
        }
        if ((i & 128) != 0) {
            date = commentUIModelV2.createdAt;
        }
        if ((i & 256) != 0) {
            date2 = commentUIModelV2.modifiedAt;
        }
        if ((i & 512) != 0) {
            z = commentUIModelV2.isResolved;
        }
        if ((i & 1024) != 0) {
            fileActivityPermissionsModel = commentUIModelV2.permissions;
        }
        boolean z2 = z;
        FileActivityPermissionsModel fileActivityPermissionsModel2 = fileActivityPermissionsModel;
        Date date3 = date;
        Date date4 = date2;
        List list2 = list;
        String str6 = str5;
        String str7 = str4;
        String str8 = str2;
        return commentUIModelV2.copy(str, taggedMessageV2, str8, str3, str7, list2, str6, date3, date4, z2, fileActivityPermissionsModel2);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getActivityId() {
        return this.activityId;
    }

    /* JADX INFO: renamed from: component10, reason: from getter */
    public final boolean getIsResolved() {
        return this.isResolved;
    }

    /* JADX INFO: renamed from: component11, reason: from getter */
    public final FileActivityPermissionsModel getPermissions() {
        return this.permissions;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final TaggedMessageV2 getMessage() {
        return this.message;
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

    public final CommentUIModelV2 copy(String activityId, TaggedMessageV2 message, String createdByUserId, String createdByUserName, String createdByUserLogin, List<CommentUIModelV2> replies, String replyCountMessage, Date createdAt, Date modifiedAt, boolean isResolved, FileActivityPermissionsModel permissions) {
        Intrinsics.checkNotNullParameter(activityId, "activityId");
        Intrinsics.checkNotNullParameter(message, "message");
        Intrinsics.checkNotNullParameter(createdByUserId, "createdByUserId");
        Intrinsics.checkNotNullParameter(replies, "replies");
        Intrinsics.checkNotNullParameter(createdAt, "createdAt");
        Intrinsics.checkNotNullParameter(modifiedAt, "modifiedAt");
        Intrinsics.checkNotNullParameter(permissions, "permissions");
        return new CommentUIModelV2(activityId, message, createdByUserId, createdByUserName, createdByUserLogin, replies, replyCountMessage, createdAt, modifiedAt, isResolved, permissions);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof CommentUIModelV2)) {
            return false;
        }
        CommentUIModelV2 commentUIModelV2 = (CommentUIModelV2) other;
        return Intrinsics.areEqual(this.activityId, commentUIModelV2.activityId) && Intrinsics.areEqual(this.message, commentUIModelV2.message) && Intrinsics.areEqual(this.createdByUserId, commentUIModelV2.createdByUserId) && Intrinsics.areEqual(this.createdByUserName, commentUIModelV2.createdByUserName) && Intrinsics.areEqual(this.createdByUserLogin, commentUIModelV2.createdByUserLogin) && Intrinsics.areEqual(this.replies, commentUIModelV2.replies) && Intrinsics.areEqual(this.replyCountMessage, commentUIModelV2.replyCountMessage) && Intrinsics.areEqual(this.createdAt, commentUIModelV2.createdAt) && Intrinsics.areEqual(this.modifiedAt, commentUIModelV2.modifiedAt) && this.isResolved == commentUIModelV2.isResolved && Intrinsics.areEqual(this.permissions, commentUIModelV2.permissions);
    }

    public int hashCode() {
        int iHashCode = ((((this.activityId.hashCode() * 31) + this.message.hashCode()) * 31) + this.createdByUserId.hashCode()) * 31;
        String str = this.createdByUserName;
        int iHashCode2 = (iHashCode + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.createdByUserLogin;
        int iHashCode3 = (((iHashCode2 + (str2 == null ? 0 : str2.hashCode())) * 31) + this.replies.hashCode()) * 31;
        String str3 = this.replyCountMessage;
        return ((((((((iHashCode3 + (str3 != null ? str3.hashCode() : 0)) * 31) + this.createdAt.hashCode()) * 31) + this.modifiedAt.hashCode()) * 31) + Boolean.hashCode(this.isResolved)) * 31) + this.permissions.hashCode();
    }

    public String toString() {
        return "CommentUIModelV2(activityId=" + this.activityId + ", message=" + this.message + ", createdByUserId=" + this.createdByUserId + ", createdByUserName=" + this.createdByUserName + ", createdByUserLogin=" + this.createdByUserLogin + ", replies=" + this.replies + ", replyCountMessage=" + this.replyCountMessage + ", createdAt=" + this.createdAt + ", modifiedAt=" + this.modifiedAt + ", isResolved=" + this.isResolved + ", permissions=" + this.permissions + ")";
    }

    public final String getActivityId() {
        return this.activityId;
    }

    public final TaggedMessageV2 getMessage() {
        return this.message;
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

    public /* synthetic */ CommentUIModelV2(String str, TaggedMessageV2 taggedMessageV2, String str2, String str3, String str4, List list, String str5, Date date, Date date2, boolean z, FileActivityPermissionsModel fileActivityPermissionsModel, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, taggedMessageV2, str2, str3, str4, (i & 32) != 0 ? CollectionsKt.emptyList() : list, str5, date, date2, z, fileActivityPermissionsModel);
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

    public final boolean isResolved() {
        return this.isResolved;
    }

    public final FileActivityPermissionsModel getPermissions() {
        return this.permissions;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CommentUIModelV2(String activityId, TaggedMessageV2 message, String createdByUserId, String str, String str2, List<CommentUIModelV2> replies, String str3, Date createdAt, Date modifiedAt, boolean z, FileActivityPermissionsModel permissions) {
        super(new FileActivityIdModel(activityId, FileActivityType.COMMENT), null);
        Intrinsics.checkNotNullParameter(activityId, "activityId");
        Intrinsics.checkNotNullParameter(message, "message");
        Intrinsics.checkNotNullParameter(createdByUserId, "createdByUserId");
        Intrinsics.checkNotNullParameter(replies, "replies");
        Intrinsics.checkNotNullParameter(createdAt, "createdAt");
        Intrinsics.checkNotNullParameter(modifiedAt, "modifiedAt");
        Intrinsics.checkNotNullParameter(permissions, "permissions");
        this.activityId = activityId;
        this.message = message;
        this.createdByUserId = createdByUserId;
        this.createdByUserName = str;
        this.createdByUserLogin = str2;
        this.replies = replies;
        this.replyCountMessage = str3;
        this.createdAt = createdAt;
        this.modifiedAt = modifiedAt;
        this.isResolved = z;
        this.permissions = permissions;
    }
}
