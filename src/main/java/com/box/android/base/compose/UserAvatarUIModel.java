package com.box.android.base.compose;

import com.box.androidsdk.content.auth.OAuthActivity;
import com.box.androidsdk.content.models.BoxCollaborator;
import java.util.Date;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: UserAvatar.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u0001B\u0019\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\n\u0010\n\u001a\u0004\u0018\u00010\u0003H\u0016J\n\u0010\u000b\u001a\u0004\u0018\u00010\fH\u0016J\n\u0010\r\u001a\u0004\u0018\u00010\fH\u0016J\b\u0010\u000e\u001a\u00020\u0003H\u0016R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\b¨\u0006\u000f"}, d2 = {"Lcom/box/android/base/compose/UserAvatarUIModel;", "Lcom/box/androidsdk/content/models/BoxCollaborator;", OAuthActivity.USER_ID, "", "userName", "<init>", "(Ljava/lang/String;Ljava/lang/String;)V", "getUserId", "()Ljava/lang/String;", "getUserName", "getName", "getCreatedAt", "Ljava/util/Date;", "getModifiedAt", "getId", "base_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class UserAvatarUIModel extends BoxCollaborator {
    public static final int $stable = 8;
    private final String userId;
    private final String userName;

    @Override // com.box.androidsdk.content.models.BoxCollaborator
    public Date getCreatedAt() {
        return null;
    }

    @Override // com.box.androidsdk.content.models.BoxCollaborator
    public Date getModifiedAt() {
        return null;
    }

    public UserAvatarUIModel(String userId, String str) {
        Intrinsics.checkNotNullParameter(userId, "userId");
        this.userId = userId;
        this.userName = str;
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

    @Override // com.box.androidsdk.content.models.BoxEntity
    /* JADX INFO: renamed from: getId, reason: from getter */
    public String getUserId() {
        return this.userId;
    }
}
