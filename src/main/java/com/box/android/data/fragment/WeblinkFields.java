package com.box.android.data.fragment;

import com.apollographql.apollo3.api.Fragment;
import com.box.android.data.type.ItemType;
import com.box.android.domain.analytics.BoxAmplitudeAnalytics;
import com.box.android.preview.previewtype.boxnote.BoxNoteConstants;
import java.util.Date;
import java.util.List;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: WeblinkFields.kt */
/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b.\n\u0002\u0010\b\n\u0002\b\n\b\u0086\b\u0018\u00002\u00020\u0001:\bJKLMNOPQB\u0085\u0001\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\b\u0010\t\u001a\u0004\u0018\u00010\b\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u000b\u0012\b\u0010\f\u001a\u0004\u0018\u00010\r\u0012\b\u0010\u000e\u001a\u0004\u0018\u00010\u000f\u0012\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011\u0012\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013\u0012\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015\u0012\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017\u0012\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019¢\u0006\u0004\b\u001a\u0010\u001bJ\t\u00106\u001a\u00020\u0003HÆ\u0003J\u000b\u00107\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u00108\u001a\u00020\u0006HÆ\u0003J\u000b\u00109\u001a\u0004\u0018\u00010\bHÆ\u0003J\u000b\u0010:\u001a\u0004\u0018\u00010\bHÆ\u0003J\u0010\u0010;\u001a\u0004\u0018\u00010\u000bHÆ\u0003¢\u0006\u0002\u0010$J\u000b\u0010<\u001a\u0004\u0018\u00010\rHÆ\u0003J\u000b\u0010=\u001a\u0004\u0018\u00010\u000fHÆ\u0003J\u000b\u0010>\u001a\u0004\u0018\u00010\u0011HÆ\u0003J\u000b\u0010?\u001a\u0004\u0018\u00010\u0013HÆ\u0003J\u000b\u0010@\u001a\u0004\u0018\u00010\u0015HÆ\u0003J\u000b\u0010A\u001a\u0004\u0018\u00010\u0017HÆ\u0003J\u000b\u0010B\u001a\u0004\u0018\u00010\u0019HÆ\u0003J¦\u0001\u0010C\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\r2\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u00112\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u00132\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u00152\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u00172\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u0019HÆ\u0001¢\u0006\u0002\u0010DJ\u0013\u0010E\u001a\u00020\u000b2\b\u0010F\u001a\u0004\u0018\u00010\u0015HÖ\u0003J\t\u0010G\u001a\u00020HHÖ\u0001J\t\u0010I\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001dR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001dR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010 R\u0013\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\"R\u0013\u0010\t\u001a\u0004\u0018\u00010\b¢\u0006\b\n\u0000\u001a\u0004\b#\u0010\"R\u0015\u0010\n\u001a\u0004\u0018\u00010\u000b¢\u0006\n\n\u0002\u0010%\u001a\u0004\b\n\u0010$R\u0013\u0010\f\u001a\u0004\u0018\u00010\r¢\u0006\b\n\u0000\u001a\u0004\b&\u0010'R\u0013\u0010\u000e\u001a\u0004\u0018\u00010\u000f¢\u0006\b\n\u0000\u001a\u0004\b(\u0010)R\u0013\u0010\u0010\u001a\u0004\u0018\u00010\u0011¢\u0006\b\n\u0000\u001a\u0004\b*\u0010+R\u001e\u0010\u0012\u001a\u0004\u0018\u00010\u00138\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b,\u0010-\u001a\u0004\b.\u0010/R\u0013\u0010\u0014\u001a\u0004\u0018\u00010\u0015¢\u0006\b\n\u0000\u001a\u0004\b0\u00101R\u0013\u0010\u0016\u001a\u0004\u0018\u00010\u0017¢\u0006\b\n\u0000\u001a\u0004\b2\u00103R\u0013\u0010\u0018\u001a\u0004\u0018\u00010\u0019¢\u0006\b\n\u0000\u001a\u0004\b4\u00105¨\u0006R"}, d2 = {"Lcom/box/android/data/fragment/WeblinkFields;", "Lcom/apollographql/apollo3/api/Fragment$Data;", "id", "", "name", "type", "Lcom/box/android/data/type/ItemType;", "createdAt", "Ljava/util/Date;", "updatedAt", "isRooted", "", "ownedBy", "Lcom/box/android/data/fragment/WeblinkFields$OwnedBy;", "updatedBy", "Lcom/box/android/data/fragment/WeblinkFields$UpdatedBy;", "parent", "Lcom/box/android/data/fragment/WeblinkFields$Parent;", "itemCollectionConnection", "Lcom/box/android/data/fragment/WeblinkFields$ItemCollectionConnection;", "url", "", "permissionsV2Api", "Lcom/box/android/data/fragment/WeblinkFields$PermissionsV2Api;", BoxNoteConstants.NOTES_BUILDER_SHARED_LINK, "Lcom/box/android/data/fragment/WeblinkFields$SharedLink;", "<init>", "(Ljava/lang/String;Ljava/lang/String;Lcom/box/android/data/type/ItemType;Ljava/util/Date;Ljava/util/Date;Ljava/lang/Boolean;Lcom/box/android/data/fragment/WeblinkFields$OwnedBy;Lcom/box/android/data/fragment/WeblinkFields$UpdatedBy;Lcom/box/android/data/fragment/WeblinkFields$Parent;Lcom/box/android/data/fragment/WeblinkFields$ItemCollectionConnection;Ljava/lang/Object;Lcom/box/android/data/fragment/WeblinkFields$PermissionsV2Api;Lcom/box/android/data/fragment/WeblinkFields$SharedLink;)V", "getId", "()Ljava/lang/String;", "getName", "getType", "()Lcom/box/android/data/type/ItemType;", "getCreatedAt", "()Ljava/util/Date;", "getUpdatedAt", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "getOwnedBy", "()Lcom/box/android/data/fragment/WeblinkFields$OwnedBy;", "getUpdatedBy", "()Lcom/box/android/data/fragment/WeblinkFields$UpdatedBy;", "getParent", "()Lcom/box/android/data/fragment/WeblinkFields$Parent;", "getItemCollectionConnection$annotations", "()V", "getItemCollectionConnection", "()Lcom/box/android/data/fragment/WeblinkFields$ItemCollectionConnection;", "getUrl", "()Ljava/lang/Object;", "getPermissionsV2Api", "()Lcom/box/android/data/fragment/WeblinkFields$PermissionsV2Api;", "getSharedLink", "()Lcom/box/android/data/fragment/WeblinkFields$SharedLink;", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "component12", "component13", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "(Ljava/lang/String;Ljava/lang/String;Lcom/box/android/data/type/ItemType;Ljava/util/Date;Ljava/util/Date;Ljava/lang/Boolean;Lcom/box/android/data/fragment/WeblinkFields$OwnedBy;Lcom/box/android/data/fragment/WeblinkFields$UpdatedBy;Lcom/box/android/data/fragment/WeblinkFields$Parent;Lcom/box/android/data/fragment/WeblinkFields$ItemCollectionConnection;Ljava/lang/Object;Lcom/box/android/data/fragment/WeblinkFields$PermissionsV2Api;Lcom/box/android/data/fragment/WeblinkFields$SharedLink;)Lcom/box/android/data/fragment/WeblinkFields;", "equals", "other", "hashCode", "", "toString", "OwnedBy", "UpdatedBy", "Parent", "ItemCollectionConnection", "PermissionsV2Api", "SharedLink", "Edge", "Node", "data_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final /* data */ class WeblinkFields implements Fragment.Data {
    private final Date createdAt;
    private final String id;
    private final Boolean isRooted;
    private final ItemCollectionConnection itemCollectionConnection;
    private final String name;
    private final OwnedBy ownedBy;
    private final Parent parent;
    private final PermissionsV2Api permissionsV2Api;
    private final SharedLink sharedLink;
    private final ItemType type;
    private final Date updatedAt;
    private final UpdatedBy updatedBy;
    private final Object url;

    public static /* synthetic */ WeblinkFields copy$default(WeblinkFields weblinkFields, String str, String str2, ItemType itemType, Date date, Date date2, Boolean bool, OwnedBy ownedBy, UpdatedBy updatedBy, Parent parent, ItemCollectionConnection itemCollectionConnection, Object obj, PermissionsV2Api permissionsV2Api, SharedLink sharedLink, int i, Object obj2) {
        if ((i & 1) != 0) {
            str = weblinkFields.id;
        }
        return weblinkFields.copy(str, (i & 2) != 0 ? weblinkFields.name : str2, (i & 4) != 0 ? weblinkFields.type : itemType, (i & 8) != 0 ? weblinkFields.createdAt : date, (i & 16) != 0 ? weblinkFields.updatedAt : date2, (i & 32) != 0 ? weblinkFields.isRooted : bool, (i & 64) != 0 ? weblinkFields.ownedBy : ownedBy, (i & 128) != 0 ? weblinkFields.updatedBy : updatedBy, (i & 256) != 0 ? weblinkFields.parent : parent, (i & 512) != 0 ? weblinkFields.itemCollectionConnection : itemCollectionConnection, (i & 1024) != 0 ? weblinkFields.url : obj, (i & 2048) != 0 ? weblinkFields.permissionsV2Api : permissionsV2Api, (i & 4096) != 0 ? weblinkFields.sharedLink : sharedLink);
    }

    @Deprecated(message = "use collectionConnection query")
    public static /* synthetic */ void getItemCollectionConnection$annotations() {
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getId() {
        return this.id;
    }

    /* JADX INFO: renamed from: component10, reason: from getter */
    public final ItemCollectionConnection getItemCollectionConnection() {
        return this.itemCollectionConnection;
    }

    /* JADX INFO: renamed from: component11, reason: from getter */
    public final Object getUrl() {
        return this.url;
    }

    /* JADX INFO: renamed from: component12, reason: from getter */
    public final PermissionsV2Api getPermissionsV2Api() {
        return this.permissionsV2Api;
    }

    /* JADX INFO: renamed from: component13, reason: from getter */
    public final SharedLink getSharedLink() {
        return this.sharedLink;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getName() {
        return this.name;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final ItemType getType() {
        return this.type;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final Date getCreatedAt() {
        return this.createdAt;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final Date getUpdatedAt() {
        return this.updatedAt;
    }

    /* JADX INFO: renamed from: component6, reason: from getter */
    public final Boolean getIsRooted() {
        return this.isRooted;
    }

    /* JADX INFO: renamed from: component7, reason: from getter */
    public final OwnedBy getOwnedBy() {
        return this.ownedBy;
    }

    /* JADX INFO: renamed from: component8, reason: from getter */
    public final UpdatedBy getUpdatedBy() {
        return this.updatedBy;
    }

    /* JADX INFO: renamed from: component9, reason: from getter */
    public final Parent getParent() {
        return this.parent;
    }

    public final WeblinkFields copy(String id, String name, ItemType type, Date createdAt, Date updatedAt, Boolean isRooted, OwnedBy ownedBy, UpdatedBy updatedBy, Parent parent, ItemCollectionConnection itemCollectionConnection, Object url, PermissionsV2Api permissionsV2Api, SharedLink sharedLink) {
        Intrinsics.checkNotNullParameter(id, "id");
        Intrinsics.checkNotNullParameter(type, "type");
        return new WeblinkFields(id, name, type, createdAt, updatedAt, isRooted, ownedBy, updatedBy, parent, itemCollectionConnection, url, permissionsV2Api, sharedLink);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof WeblinkFields)) {
            return false;
        }
        WeblinkFields weblinkFields = (WeblinkFields) other;
        return Intrinsics.areEqual(this.id, weblinkFields.id) && Intrinsics.areEqual(this.name, weblinkFields.name) && this.type == weblinkFields.type && Intrinsics.areEqual(this.createdAt, weblinkFields.createdAt) && Intrinsics.areEqual(this.updatedAt, weblinkFields.updatedAt) && Intrinsics.areEqual(this.isRooted, weblinkFields.isRooted) && Intrinsics.areEqual(this.ownedBy, weblinkFields.ownedBy) && Intrinsics.areEqual(this.updatedBy, weblinkFields.updatedBy) && Intrinsics.areEqual(this.parent, weblinkFields.parent) && Intrinsics.areEqual(this.itemCollectionConnection, weblinkFields.itemCollectionConnection) && Intrinsics.areEqual(this.url, weblinkFields.url) && Intrinsics.areEqual(this.permissionsV2Api, weblinkFields.permissionsV2Api) && Intrinsics.areEqual(this.sharedLink, weblinkFields.sharedLink);
    }

    public int hashCode() {
        int iHashCode = this.id.hashCode() * 31;
        String str = this.name;
        int iHashCode2 = (((iHashCode + (str == null ? 0 : str.hashCode())) * 31) + this.type.hashCode()) * 31;
        Date date = this.createdAt;
        int iHashCode3 = (iHashCode2 + (date == null ? 0 : date.hashCode())) * 31;
        Date date2 = this.updatedAt;
        int iHashCode4 = (iHashCode3 + (date2 == null ? 0 : date2.hashCode())) * 31;
        Boolean bool = this.isRooted;
        int iHashCode5 = (iHashCode4 + (bool == null ? 0 : bool.hashCode())) * 31;
        OwnedBy ownedBy = this.ownedBy;
        int iHashCode6 = (iHashCode5 + (ownedBy == null ? 0 : ownedBy.hashCode())) * 31;
        UpdatedBy updatedBy = this.updatedBy;
        int iHashCode7 = (iHashCode6 + (updatedBy == null ? 0 : updatedBy.hashCode())) * 31;
        Parent parent = this.parent;
        int iHashCode8 = (iHashCode7 + (parent == null ? 0 : parent.hashCode())) * 31;
        ItemCollectionConnection itemCollectionConnection = this.itemCollectionConnection;
        int iHashCode9 = (iHashCode8 + (itemCollectionConnection == null ? 0 : itemCollectionConnection.hashCode())) * 31;
        Object obj = this.url;
        int iHashCode10 = (iHashCode9 + (obj == null ? 0 : obj.hashCode())) * 31;
        PermissionsV2Api permissionsV2Api = this.permissionsV2Api;
        int iHashCode11 = (iHashCode10 + (permissionsV2Api == null ? 0 : permissionsV2Api.hashCode())) * 31;
        SharedLink sharedLink = this.sharedLink;
        return iHashCode11 + (sharedLink != null ? sharedLink.hashCode() : 0);
    }

    public String toString() {
        return "WeblinkFields(id=" + this.id + ", name=" + this.name + ", type=" + this.type + ", createdAt=" + this.createdAt + ", updatedAt=" + this.updatedAt + ", isRooted=" + this.isRooted + ", ownedBy=" + this.ownedBy + ", updatedBy=" + this.updatedBy + ", parent=" + this.parent + ", itemCollectionConnection=" + this.itemCollectionConnection + ", url=" + this.url + ", permissionsV2Api=" + this.permissionsV2Api + ", sharedLink=" + this.sharedLink + ")";
    }

    public WeblinkFields(String id, String str, ItemType type, Date date, Date date2, Boolean bool, OwnedBy ownedBy, UpdatedBy updatedBy, Parent parent, ItemCollectionConnection itemCollectionConnection, Object obj, PermissionsV2Api permissionsV2Api, SharedLink sharedLink) {
        Intrinsics.checkNotNullParameter(id, "id");
        Intrinsics.checkNotNullParameter(type, "type");
        this.id = id;
        this.name = str;
        this.type = type;
        this.createdAt = date;
        this.updatedAt = date2;
        this.isRooted = bool;
        this.ownedBy = ownedBy;
        this.updatedBy = updatedBy;
        this.parent = parent;
        this.itemCollectionConnection = itemCollectionConnection;
        this.url = obj;
        this.permissionsV2Api = permissionsV2Api;
        this.sharedLink = sharedLink;
    }

    public final String getId() {
        return this.id;
    }

    public final String getName() {
        return this.name;
    }

    public final ItemType getType() {
        return this.type;
    }

    public final Date getCreatedAt() {
        return this.createdAt;
    }

    public final Date getUpdatedAt() {
        return this.updatedAt;
    }

    public final Boolean isRooted() {
        return this.isRooted;
    }

    public final OwnedBy getOwnedBy() {
        return this.ownedBy;
    }

    public final UpdatedBy getUpdatedBy() {
        return this.updatedBy;
    }

    public final Parent getParent() {
        return this.parent;
    }

    public final ItemCollectionConnection getItemCollectionConnection() {
        return this.itemCollectionConnection;
    }

    public final Object getUrl() {
        return this.url;
    }

    public final PermissionsV2Api getPermissionsV2Api() {
        return this.permissionsV2Api;
    }

    public final SharedLink getSharedLink() {
        return this.sharedLink;
    }

    /* JADX INFO: compiled from: WeblinkFields.kt */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u0019\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\t\u0010\n\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u000b\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u001f\u0010\f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001J\t\u0010\u0012\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\b¨\u0006\u0013"}, d2 = {"Lcom/box/android/data/fragment/WeblinkFields$OwnedBy;", "", "id", "", "name", "<init>", "(Ljava/lang/String;Ljava/lang/String;)V", "getId", "()Ljava/lang/String;", "getName", "component1", "component2", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "", "other", "hashCode", "", "toString", "data_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final /* data */ class OwnedBy {
        private final String id;
        private final String name;

        public static /* synthetic */ OwnedBy copy$default(OwnedBy ownedBy, String str, String str2, int i, Object obj) {
            if ((i & 1) != 0) {
                str = ownedBy.id;
            }
            if ((i & 2) != 0) {
                str2 = ownedBy.name;
            }
            return ownedBy.copy(str, str2);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final String getId() {
            return this.id;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final String getName() {
            return this.name;
        }

        public final OwnedBy copy(String id, String name) {
            Intrinsics.checkNotNullParameter(id, "id");
            return new OwnedBy(id, name);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof OwnedBy)) {
                return false;
            }
            OwnedBy ownedBy = (OwnedBy) other;
            return Intrinsics.areEqual(this.id, ownedBy.id) && Intrinsics.areEqual(this.name, ownedBy.name);
        }

        public int hashCode() {
            int iHashCode = this.id.hashCode() * 31;
            String str = this.name;
            return iHashCode + (str == null ? 0 : str.hashCode());
        }

        public String toString() {
            return "OwnedBy(id=" + this.id + ", name=" + this.name + ")";
        }

        public OwnedBy(String id, String str) {
            Intrinsics.checkNotNullParameter(id, "id");
            this.id = id;
            this.name = str;
        }

        public final String getId() {
            return this.id;
        }

        public final String getName() {
            return this.name;
        }
    }

    /* JADX INFO: compiled from: WeblinkFields.kt */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u0019\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\t\u0010\n\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u000b\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u001f\u0010\f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001J\t\u0010\u0012\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\b¨\u0006\u0013"}, d2 = {"Lcom/box/android/data/fragment/WeblinkFields$UpdatedBy;", "", "id", "", "name", "<init>", "(Ljava/lang/String;Ljava/lang/String;)V", "getId", "()Ljava/lang/String;", "getName", "component1", "component2", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "", "other", "hashCode", "", "toString", "data_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final /* data */ class UpdatedBy {
        private final String id;
        private final String name;

        public static /* synthetic */ UpdatedBy copy$default(UpdatedBy updatedBy, String str, String str2, int i, Object obj) {
            if ((i & 1) != 0) {
                str = updatedBy.id;
            }
            if ((i & 2) != 0) {
                str2 = updatedBy.name;
            }
            return updatedBy.copy(str, str2);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final String getId() {
            return this.id;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final String getName() {
            return this.name;
        }

        public final UpdatedBy copy(String id, String name) {
            Intrinsics.checkNotNullParameter(id, "id");
            return new UpdatedBy(id, name);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof UpdatedBy)) {
                return false;
            }
            UpdatedBy updatedBy = (UpdatedBy) other;
            return Intrinsics.areEqual(this.id, updatedBy.id) && Intrinsics.areEqual(this.name, updatedBy.name);
        }

        public int hashCode() {
            int iHashCode = this.id.hashCode() * 31;
            String str = this.name;
            return iHashCode + (str == null ? 0 : str.hashCode());
        }

        public String toString() {
            return "UpdatedBy(id=" + this.id + ", name=" + this.name + ")";
        }

        public UpdatedBy(String id, String str) {
            Intrinsics.checkNotNullParameter(id, "id");
            this.id = id;
            this.name = str;
        }

        public final String getId() {
            return this.id;
        }

        public final String getName() {
            return this.name;
        }
    }

    /* JADX INFO: compiled from: WeblinkFields.kt */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u0019\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\t\u0010\n\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u000b\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u001f\u0010\f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001J\t\u0010\u0012\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\b¨\u0006\u0013"}, d2 = {"Lcom/box/android/data/fragment/WeblinkFields$Parent;", "", "id", "", "name", "<init>", "(Ljava/lang/String;Ljava/lang/String;)V", "getId", "()Ljava/lang/String;", "getName", "component1", "component2", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "", "other", "hashCode", "", "toString", "data_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final /* data */ class Parent {
        private final String id;
        private final String name;

        public static /* synthetic */ Parent copy$default(Parent parent, String str, String str2, int i, Object obj) {
            if ((i & 1) != 0) {
                str = parent.id;
            }
            if ((i & 2) != 0) {
                str2 = parent.name;
            }
            return parent.copy(str, str2);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final String getId() {
            return this.id;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final String getName() {
            return this.name;
        }

        public final Parent copy(String id, String name) {
            Intrinsics.checkNotNullParameter(id, "id");
            return new Parent(id, name);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Parent)) {
                return false;
            }
            Parent parent = (Parent) other;
            return Intrinsics.areEqual(this.id, parent.id) && Intrinsics.areEqual(this.name, parent.name);
        }

        public int hashCode() {
            int iHashCode = this.id.hashCode() * 31;
            String str = this.name;
            return iHashCode + (str == null ? 0 : str.hashCode());
        }

        public String toString() {
            return "Parent(id=" + this.id + ", name=" + this.name + ")";
        }

        public Parent(String id, String str) {
            Intrinsics.checkNotNullParameter(id, "id");
            this.id = id;
            this.name = str;
        }

        public final String getId() {
            return this.id;
        }

        public final String getName() {
            return this.name;
        }
    }

    /* JADX INFO: compiled from: WeblinkFields.kt */
    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u0015\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003J\u0019\u0010\n\u001a\u00020\u00002\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0001J\u0013\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001R\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\u0012"}, d2 = {"Lcom/box/android/data/fragment/WeblinkFields$ItemCollectionConnection;", "", "edges", "", "Lcom/box/android/data/fragment/WeblinkFields$Edge;", "<init>", "(Ljava/util/List;)V", "getEdges", "()Ljava/util/List;", "component1", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "", "other", "hashCode", "", "toString", "", "data_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final /* data */ class ItemCollectionConnection {
        private final List<Edge> edges;

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ ItemCollectionConnection copy$default(ItemCollectionConnection itemCollectionConnection, List list, int i, Object obj) {
            if ((i & 1) != 0) {
                list = itemCollectionConnection.edges;
            }
            return itemCollectionConnection.copy(list);
        }

        public final List<Edge> component1() {
            return this.edges;
        }

        public final ItemCollectionConnection copy(List<Edge> edges) {
            Intrinsics.checkNotNullParameter(edges, "edges");
            return new ItemCollectionConnection(edges);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            return (other instanceof ItemCollectionConnection) && Intrinsics.areEqual(this.edges, ((ItemCollectionConnection) other).edges);
        }

        public int hashCode() {
            return this.edges.hashCode();
        }

        public String toString() {
            return "ItemCollectionConnection(edges=" + this.edges + ")";
        }

        public ItemCollectionConnection(List<Edge> edges) {
            Intrinsics.checkNotNullParameter(edges, "edges");
            this.edges = edges;
        }

        public final List<Edge> getEdges() {
            return this.edges;
        }
    }

    /* JADX INFO: compiled from: WeblinkFields.kt */
    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0017\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B9\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\b\u0010\tJ\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u000bJ\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u000bJ\u0010\u0010\u0013\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u000bJ\u0010\u0010\u0014\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u000bJ\u0010\u0010\u0015\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u000bJJ\u0010\u0016\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0003HÆ\u0001¢\u0006\u0002\u0010\u0017J\u0013\u0010\u0018\u001a\u00020\u00032\b\u0010\u0019\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001a\u001a\u00020\u001bHÖ\u0001J\t\u0010\u001c\u001a\u00020\u001dHÖ\u0001R\u0015\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\f\u001a\u0004\b\n\u0010\u000bR\u0015\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\f\u001a\u0004\b\r\u0010\u000bR\u0015\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\f\u001a\u0004\b\u000e\u0010\u000bR\u0015\u0010\u0006\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\f\u001a\u0004\b\u000f\u0010\u000bR\u0015\u0010\u0007\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\f\u001a\u0004\b\u0010\u0010\u000b¨\u0006\u001e"}, d2 = {"Lcom/box/android/data/fragment/WeblinkFields$PermissionsV2Api;", "", "canComment", "", "canDelete", "canRename", "canSetShareAccess", "canShare", "<init>", "(Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;)V", "getCanComment", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "getCanDelete", "getCanRename", "getCanSetShareAccess", "getCanShare", "component1", "component2", "component3", "component4", "component5", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "(Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;)Lcom/box/android/data/fragment/WeblinkFields$PermissionsV2Api;", "equals", "other", "hashCode", "", "toString", "", "data_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final /* data */ class PermissionsV2Api {
        private final Boolean canComment;
        private final Boolean canDelete;
        private final Boolean canRename;
        private final Boolean canSetShareAccess;
        private final Boolean canShare;

        public static /* synthetic */ PermissionsV2Api copy$default(PermissionsV2Api permissionsV2Api, Boolean bool, Boolean bool2, Boolean bool3, Boolean bool4, Boolean bool5, int i, Object obj) {
            if ((i & 1) != 0) {
                bool = permissionsV2Api.canComment;
            }
            if ((i & 2) != 0) {
                bool2 = permissionsV2Api.canDelete;
            }
            if ((i & 4) != 0) {
                bool3 = permissionsV2Api.canRename;
            }
            if ((i & 8) != 0) {
                bool4 = permissionsV2Api.canSetShareAccess;
            }
            if ((i & 16) != 0) {
                bool5 = permissionsV2Api.canShare;
            }
            Boolean bool6 = bool5;
            Boolean bool7 = bool3;
            return permissionsV2Api.copy(bool, bool2, bool7, bool4, bool6);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final Boolean getCanComment() {
            return this.canComment;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final Boolean getCanDelete() {
            return this.canDelete;
        }

        /* JADX INFO: renamed from: component3, reason: from getter */
        public final Boolean getCanRename() {
            return this.canRename;
        }

        /* JADX INFO: renamed from: component4, reason: from getter */
        public final Boolean getCanSetShareAccess() {
            return this.canSetShareAccess;
        }

        /* JADX INFO: renamed from: component5, reason: from getter */
        public final Boolean getCanShare() {
            return this.canShare;
        }

        public final PermissionsV2Api copy(Boolean canComment, Boolean canDelete, Boolean canRename, Boolean canSetShareAccess, Boolean canShare) {
            return new PermissionsV2Api(canComment, canDelete, canRename, canSetShareAccess, canShare);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof PermissionsV2Api)) {
                return false;
            }
            PermissionsV2Api permissionsV2Api = (PermissionsV2Api) other;
            return Intrinsics.areEqual(this.canComment, permissionsV2Api.canComment) && Intrinsics.areEqual(this.canDelete, permissionsV2Api.canDelete) && Intrinsics.areEqual(this.canRename, permissionsV2Api.canRename) && Intrinsics.areEqual(this.canSetShareAccess, permissionsV2Api.canSetShareAccess) && Intrinsics.areEqual(this.canShare, permissionsV2Api.canShare);
        }

        public int hashCode() {
            Boolean bool = this.canComment;
            int iHashCode = (bool == null ? 0 : bool.hashCode()) * 31;
            Boolean bool2 = this.canDelete;
            int iHashCode2 = (iHashCode + (bool2 == null ? 0 : bool2.hashCode())) * 31;
            Boolean bool3 = this.canRename;
            int iHashCode3 = (iHashCode2 + (bool3 == null ? 0 : bool3.hashCode())) * 31;
            Boolean bool4 = this.canSetShareAccess;
            int iHashCode4 = (iHashCode3 + (bool4 == null ? 0 : bool4.hashCode())) * 31;
            Boolean bool5 = this.canShare;
            return iHashCode4 + (bool5 != null ? bool5.hashCode() : 0);
        }

        public String toString() {
            return "PermissionsV2Api(canComment=" + this.canComment + ", canDelete=" + this.canDelete + ", canRename=" + this.canRename + ", canSetShareAccess=" + this.canSetShareAccess + ", canShare=" + this.canShare + ")";
        }

        public PermissionsV2Api(Boolean bool, Boolean bool2, Boolean bool3, Boolean bool4, Boolean bool5) {
            this.canComment = bool;
            this.canDelete = bool2;
            this.canRename = bool3;
            this.canSetShareAccess = bool4;
            this.canShare = bool5;
        }

        public final Boolean getCanComment() {
            return this.canComment;
        }

        public final Boolean getCanDelete() {
            return this.canDelete;
        }

        public final Boolean getCanRename() {
            return this.canRename;
        }

        public final Boolean getCanSetShareAccess() {
            return this.canSetShareAccess;
        }

        public final Boolean getCanShare() {
            return this.canShare;
        }
    }

    /* JADX INFO: compiled from: WeblinkFields.kt */
    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0017\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001BC\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\b\u0010\b\u001a\u0004\u0018\u00010\t\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\u000b\u0010\fJ\u000b\u0010\u0016\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0017\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0018\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010\u0019\u001a\u0004\u0018\u00010\u0007HÆ\u0003¢\u0006\u0002\u0010\u0011J\u000b\u0010\u001a\u001a\u0004\u0018\u00010\tHÆ\u0003J\u0010\u0010\u001b\u001a\u0004\u0018\u00010\u0007HÆ\u0003¢\u0006\u0002\u0010\u0011JV\u0010\u001c\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0007HÆ\u0001¢\u0006\u0002\u0010\u001dJ\u0013\u0010\u001e\u001a\u00020\u00072\b\u0010\u001f\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010 \u001a\u00020!HÖ\u0001J\t\u0010\"\u001a\u00020\u0003HÖ\u0001R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000eR\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000eR\u0015\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\n\n\u0002\u0010\u0012\u001a\u0004\b\u0006\u0010\u0011R\u0013\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0015\u0010\n\u001a\u0004\u0018\u00010\u0007¢\u0006\n\n\u0002\u0010\u0012\u001a\u0004\b\u0015\u0010\u0011¨\u0006#"}, d2 = {"Lcom/box/android/data/fragment/WeblinkFields$SharedLink;", "", "url", "", "effectiveAccess", "effectivePermission", "isPasswordEnabled", "", "unsharedAt", "Ljava/util/Date;", "canDownload", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;Ljava/util/Date;Ljava/lang/Boolean;)V", "getUrl", "()Ljava/lang/String;", "getEffectiveAccess", "getEffectivePermission", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "getUnsharedAt", "()Ljava/util/Date;", "getCanDownload", "component1", "component2", "component3", "component4", "component5", "component6", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;Ljava/util/Date;Ljava/lang/Boolean;)Lcom/box/android/data/fragment/WeblinkFields$SharedLink;", "equals", "other", "hashCode", "", "toString", "data_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final /* data */ class SharedLink {
        private final Boolean canDownload;
        private final String effectiveAccess;
        private final String effectivePermission;
        private final Boolean isPasswordEnabled;
        private final Date unsharedAt;
        private final String url;

        public static /* synthetic */ SharedLink copy$default(SharedLink sharedLink, String str, String str2, String str3, Boolean bool, Date date, Boolean bool2, int i, Object obj) {
            if ((i & 1) != 0) {
                str = sharedLink.url;
            }
            if ((i & 2) != 0) {
                str2 = sharedLink.effectiveAccess;
            }
            if ((i & 4) != 0) {
                str3 = sharedLink.effectivePermission;
            }
            if ((i & 8) != 0) {
                bool = sharedLink.isPasswordEnabled;
            }
            if ((i & 16) != 0) {
                date = sharedLink.unsharedAt;
            }
            if ((i & 32) != 0) {
                bool2 = sharedLink.canDownload;
            }
            Date date2 = date;
            Boolean bool3 = bool2;
            return sharedLink.copy(str, str2, str3, bool, date2, bool3);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final String getUrl() {
            return this.url;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final String getEffectiveAccess() {
            return this.effectiveAccess;
        }

        /* JADX INFO: renamed from: component3, reason: from getter */
        public final String getEffectivePermission() {
            return this.effectivePermission;
        }

        /* JADX INFO: renamed from: component4, reason: from getter */
        public final Boolean getIsPasswordEnabled() {
            return this.isPasswordEnabled;
        }

        /* JADX INFO: renamed from: component5, reason: from getter */
        public final Date getUnsharedAt() {
            return this.unsharedAt;
        }

        /* JADX INFO: renamed from: component6, reason: from getter */
        public final Boolean getCanDownload() {
            return this.canDownload;
        }

        public final SharedLink copy(String url, String effectiveAccess, String effectivePermission, Boolean isPasswordEnabled, Date unsharedAt, Boolean canDownload) {
            return new SharedLink(url, effectiveAccess, effectivePermission, isPasswordEnabled, unsharedAt, canDownload);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof SharedLink)) {
                return false;
            }
            SharedLink sharedLink = (SharedLink) other;
            return Intrinsics.areEqual(this.url, sharedLink.url) && Intrinsics.areEqual(this.effectiveAccess, sharedLink.effectiveAccess) && Intrinsics.areEqual(this.effectivePermission, sharedLink.effectivePermission) && Intrinsics.areEqual(this.isPasswordEnabled, sharedLink.isPasswordEnabled) && Intrinsics.areEqual(this.unsharedAt, sharedLink.unsharedAt) && Intrinsics.areEqual(this.canDownload, sharedLink.canDownload);
        }

        public int hashCode() {
            String str = this.url;
            int iHashCode = (str == null ? 0 : str.hashCode()) * 31;
            String str2 = this.effectiveAccess;
            int iHashCode2 = (iHashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
            String str3 = this.effectivePermission;
            int iHashCode3 = (iHashCode2 + (str3 == null ? 0 : str3.hashCode())) * 31;
            Boolean bool = this.isPasswordEnabled;
            int iHashCode4 = (iHashCode3 + (bool == null ? 0 : bool.hashCode())) * 31;
            Date date = this.unsharedAt;
            int iHashCode5 = (iHashCode4 + (date == null ? 0 : date.hashCode())) * 31;
            Boolean bool2 = this.canDownload;
            return iHashCode5 + (bool2 != null ? bool2.hashCode() : 0);
        }

        public String toString() {
            return "SharedLink(url=" + this.url + ", effectiveAccess=" + this.effectiveAccess + ", effectivePermission=" + this.effectivePermission + ", isPasswordEnabled=" + this.isPasswordEnabled + ", unsharedAt=" + this.unsharedAt + ", canDownload=" + this.canDownload + ")";
        }

        public SharedLink(String str, String str2, String str3, Boolean bool, Date date, Boolean bool2) {
            this.url = str;
            this.effectiveAccess = str2;
            this.effectivePermission = str3;
            this.isPasswordEnabled = bool;
            this.unsharedAt = date;
            this.canDownload = bool2;
        }

        public final String getUrl() {
            return this.url;
        }

        public final String getEffectiveAccess() {
            return this.effectiveAccess;
        }

        public final String getEffectivePermission() {
            return this.effectivePermission;
        }

        public final Boolean isPasswordEnabled() {
            return this.isPasswordEnabled;
        }

        public final Date getUnsharedAt() {
            return this.unsharedAt;
        }

        public final Boolean getCanDownload() {
            return this.canDownload;
        }
    }

    /* JADX INFO: compiled from: WeblinkFields.kt */
    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u0019\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u000b\u0010\f\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0005HÆ\u0003J\u001f\u0010\u000e\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0003HÖ\u0001R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0015"}, d2 = {"Lcom/box/android/data/fragment/WeblinkFields$Edge;", "", "id", "", "node", "Lcom/box/android/data/fragment/WeblinkFields$Node;", "<init>", "(Ljava/lang/String;Lcom/box/android/data/fragment/WeblinkFields$Node;)V", "getId", "()Ljava/lang/String;", "getNode", "()Lcom/box/android/data/fragment/WeblinkFields$Node;", "component1", "component2", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "", "other", "hashCode", "", "toString", "data_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final /* data */ class Edge {
        private final String id;
        private final Node node;

        public static /* synthetic */ Edge copy$default(Edge edge, String str, Node node, int i, Object obj) {
            if ((i & 1) != 0) {
                str = edge.id;
            }
            if ((i & 2) != 0) {
                node = edge.node;
            }
            return edge.copy(str, node);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final String getId() {
            return this.id;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final Node getNode() {
            return this.node;
        }

        public final Edge copy(String id, Node node) {
            Intrinsics.checkNotNullParameter(node, "node");
            return new Edge(id, node);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Edge)) {
                return false;
            }
            Edge edge = (Edge) other;
            return Intrinsics.areEqual(this.id, edge.id) && Intrinsics.areEqual(this.node, edge.node);
        }

        public int hashCode() {
            String str = this.id;
            return ((str == null ? 0 : str.hashCode()) * 31) + this.node.hashCode();
        }

        public String toString() {
            return "Edge(id=" + this.id + ", node=" + this.node + ")";
        }

        public Edge(String str, Node node) {
            Intrinsics.checkNotNullParameter(node, "node");
            this.id = str;
            this.node = node;
        }

        public final String getId() {
            return this.id;
        }

        public final Node getNode() {
            return this.node;
        }
    }

    /* JADX INFO: compiled from: WeblinkFields.kt */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B#\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\r\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u000e\u001a\u0004\u0018\u00010\u0003HÆ\u0003J+\u0010\u000f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001J\t\u0010\u0015\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\tR\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\t¨\u0006\u0016"}, d2 = {"Lcom/box/android/data/fragment/WeblinkFields$Node;", "", "id", "", "name", "collectionType", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getId", "()Ljava/lang/String;", "getName", "getCollectionType", "component1", "component2", "component3", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "", "other", "hashCode", "", "toString", "data_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final /* data */ class Node {
        private final String collectionType;
        private final String id;
        private final String name;

        public static /* synthetic */ Node copy$default(Node node, String str, String str2, String str3, int i, Object obj) {
            if ((i & 1) != 0) {
                str = node.id;
            }
            if ((i & 2) != 0) {
                str2 = node.name;
            }
            if ((i & 4) != 0) {
                str3 = node.collectionType;
            }
            return node.copy(str, str2, str3);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final String getId() {
            return this.id;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final String getName() {
            return this.name;
        }

        /* JADX INFO: renamed from: component3, reason: from getter */
        public final String getCollectionType() {
            return this.collectionType;
        }

        public final Node copy(String id, String name, String collectionType) {
            Intrinsics.checkNotNullParameter(id, "id");
            return new Node(id, name, collectionType);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Node)) {
                return false;
            }
            Node node = (Node) other;
            return Intrinsics.areEqual(this.id, node.id) && Intrinsics.areEqual(this.name, node.name) && Intrinsics.areEqual(this.collectionType, node.collectionType);
        }

        public int hashCode() {
            int iHashCode = this.id.hashCode() * 31;
            String str = this.name;
            int iHashCode2 = (iHashCode + (str == null ? 0 : str.hashCode())) * 31;
            String str2 = this.collectionType;
            return iHashCode2 + (str2 != null ? str2.hashCode() : 0);
        }

        public String toString() {
            return "Node(id=" + this.id + ", name=" + this.name + ", collectionType=" + this.collectionType + ")";
        }

        public Node(String id, String str, String str2) {
            Intrinsics.checkNotNullParameter(id, "id");
            this.id = id;
            this.name = str;
            this.collectionType = str2;
        }

        public final String getId() {
            return this.id;
        }

        public final String getName() {
            return this.name;
        }

        public final String getCollectionType() {
            return this.collectionType;
        }
    }
}
