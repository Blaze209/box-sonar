package com.box.android.fileactivity.model;

import com.box.androidsdk.content.auth.OAuthActivity;
import com.box.androidsdk.content.models.BoxCollaborator;
import java.util.Date;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: ActivityUIModel.kt */
/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\b\u0007\u0018\u00002\u00020\u0001B-\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006¢\u0006\u0004\b\b\u0010\tJ\n\u0010\r\u001a\u0004\u0018\u00010\u0003H\u0016J\n\u0010\u000e\u001a\u0004\u0018\u00010\u0006H\u0016J\n\u0010\u000f\u001a\u0004\u0018\u00010\u0006H\u0016J\b\u0010\u0010\u001a\u00020\u0003H\u0016R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u000bR\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\u0006X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0011"}, d2 = {"Lcom/box/android/fileactivity/model/UserUIModel;", "Lcom/box/androidsdk/content/models/BoxCollaborator;", OAuthActivity.USER_ID, "", "userName", "userCreatedAt", "Ljava/util/Date;", "userModifiedAtDate", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/util/Date;Ljava/util/Date;)V", "getUserId", "()Ljava/lang/String;", "getUserName", "getName", "getCreatedAt", "getModifiedAt", "getId", "file-activity_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class UserUIModel extends BoxCollaborator {
    public static final int $stable = 8;
    private final Date userCreatedAt;
    private final String userId;
    private final Date userModifiedAtDate;
    private final String userName;

    public UserUIModel(String userId, String str, Date date, Date date2) {
        Intrinsics.checkNotNullParameter(userId, "userId");
        this.userId = userId;
        this.userName = str;
        this.userCreatedAt = date;
        this.userModifiedAtDate = date2;
    }

    public final String getUserId() {
        return this.userId;
    }

    public final String getUserName() {
        return this.userName;
    }

    @Override // com.box.androidsdk.content.models.BoxCollaborator
    /* JADX INFO: renamed from: getName, reason: from getter */
    public String getUserName() {
        return this.userName;
    }

    @Override // com.box.androidsdk.content.models.BoxCollaborator
    /* JADX INFO: renamed from: getCreatedAt, reason: from getter */
    public Date getUserCreatedAt() {
        return this.userCreatedAt;
    }

    @Override // com.box.androidsdk.content.models.BoxCollaborator
    /* JADX INFO: renamed from: getModifiedAt, reason: from getter */
    public Date getUserModifiedAtDate() {
        return this.userModifiedAtDate;
    }

    @Override // com.box.androidsdk.content.models.BoxEntity
    /* JADX INFO: renamed from: getId, reason: from getter */
    public String getUserId() {
        return this.userId;
    }
}
