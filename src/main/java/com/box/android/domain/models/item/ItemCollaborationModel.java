package com.box.android.domain.models.item;

import com.box.android.domain.analytics.BoxAmplitudeAnalytics;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: ItemCollaborationModel.kt */
/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B-\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\b\u0010\tJ\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u0011\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0012\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0013\u001a\u0004\u0018\u00010\u0007HÆ\u0003J7\u0010\u0014\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÆ\u0001J\u0013\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0018\u001a\u00020\u0019HÖ\u0001J\t\u0010\u001a\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u000bR\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000bR\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u001b"}, d2 = {"Lcom/box/android/domain/models/item/ItemCollaborationModel;", "", "id", "", "type", "inviteEmail", "accessibleBy", "Lcom/box/android/domain/models/item/UserModel;", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/box/android/domain/models/item/UserModel;)V", "getId", "()Ljava/lang/String;", "getType", "getInviteEmail", "getAccessibleBy", "()Lcom/box/android/domain/models/item/UserModel;", "component1", "component2", "component3", "component4", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "", "other", "hashCode", "", "toString", "domain_prodRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final /* data */ class ItemCollaborationModel {
    private final UserModel accessibleBy;
    private final String id;
    private final String inviteEmail;
    private final String type;

    public static /* synthetic */ ItemCollaborationModel copy$default(ItemCollaborationModel itemCollaborationModel, String str, String str2, String str3, UserModel userModel, int i, Object obj) {
        if ((i & 1) != 0) {
            str = itemCollaborationModel.id;
        }
        if ((i & 2) != 0) {
            str2 = itemCollaborationModel.type;
        }
        if ((i & 4) != 0) {
            str3 = itemCollaborationModel.inviteEmail;
        }
        if ((i & 8) != 0) {
            userModel = itemCollaborationModel.accessibleBy;
        }
        return itemCollaborationModel.copy(str, str2, str3, userModel);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getId() {
        return this.id;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getType() {
        return this.type;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final String getInviteEmail() {
        return this.inviteEmail;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final UserModel getAccessibleBy() {
        return this.accessibleBy;
    }

    public final ItemCollaborationModel copy(String id, String type, String inviteEmail, UserModel accessibleBy) {
        Intrinsics.checkNotNullParameter(id, "id");
        return new ItemCollaborationModel(id, type, inviteEmail, accessibleBy);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ItemCollaborationModel)) {
            return false;
        }
        ItemCollaborationModel itemCollaborationModel = (ItemCollaborationModel) other;
        return Intrinsics.areEqual(this.id, itemCollaborationModel.id) && Intrinsics.areEqual(this.type, itemCollaborationModel.type) && Intrinsics.areEqual(this.inviteEmail, itemCollaborationModel.inviteEmail) && Intrinsics.areEqual(this.accessibleBy, itemCollaborationModel.accessibleBy);
    }

    public int hashCode() {
        int iHashCode = this.id.hashCode() * 31;
        String str = this.type;
        int iHashCode2 = (iHashCode + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.inviteEmail;
        int iHashCode3 = (iHashCode2 + (str2 == null ? 0 : str2.hashCode())) * 31;
        UserModel userModel = this.accessibleBy;
        return iHashCode3 + (userModel != null ? userModel.hashCode() : 0);
    }

    public String toString() {
        return "ItemCollaborationModel(id=" + this.id + ", type=" + this.type + ", inviteEmail=" + this.inviteEmail + ", accessibleBy=" + this.accessibleBy + ")";
    }

    public ItemCollaborationModel(String id, String str, String str2, UserModel userModel) {
        Intrinsics.checkNotNullParameter(id, "id");
        this.id = id;
        this.type = str;
        this.inviteEmail = str2;
        this.accessibleBy = userModel;
    }

    public final String getId() {
        return this.id;
    }

    public final String getType() {
        return this.type;
    }

    public final String getInviteEmail() {
        return this.inviteEmail;
    }

    public final UserModel getAccessibleBy() {
        return this.accessibleBy;
    }
}
