package com.box.android.domain.models.item;

import android.os.Parcel;
import android.os.Parcelable;
import com.box.android.domain.analytics.BoxAmplitudeAnalytics;
import com.box.android.domain.models.CollectionModel;
import com.box.android.domain.models.ItemId;
import com.box.android.preview.previewtype.boxnote.BoxNoteConstants;
import com.box.androidsdk.content.models.BoxItem;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: UnknownItemModel.kt */
/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000v\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b1\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B½\u0001\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\u0007\u0012\b\u0010\t\u001a\u0004\u0018\u00010\n\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\f\u0012\b\u0010\r\u001a\u0004\u0018\u00010\f\u0012\b\u0010\u000e\u001a\u0004\u0018\u00010\u000f\u0012\b\u0010\u0010\u001a\u0004\u0018\u00010\u000f\u0012\b\u0010\u0011\u001a\u0004\u0018\u00010\u000f\u0012\b\u0010\u0012\u001a\u0004\u0018\u00010\u000f\u0012\u0006\u0010\u0013\u001a\u00020\u0007\u0012\u0006\u0010\u0014\u001a\u00020\u0015\u0012\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017\u0012\u000e\u0010\u0018\u001a\n\u0012\u0004\u0012\u00020\u001a\u0018\u00010\u0019\u0012\u000e\u0010\u001b\u001a\n\u0012\u0004\u0012\u00020\u001c\u0018\u00010\u0019\u0012\b\u0010\u001d\u001a\u0004\u0018\u00010\u001e\u0012\n\b\u0002\u0010\u001f\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b \u0010!J\t\u0010<\u001a\u00020\u0003HÆ\u0003J\t\u0010=\u001a\u00020\u0005HÆ\u0003J\t\u0010>\u001a\u00020\u0007HÆ\u0003J\t\u0010?\u001a\u00020\u0007HÆ\u0003J\u000b\u0010@\u001a\u0004\u0018\u00010\nHÆ\u0003J\u000b\u0010A\u001a\u0004\u0018\u00010\fHÆ\u0003J\u000b\u0010B\u001a\u0004\u0018\u00010\fHÆ\u0003J\u000b\u0010C\u001a\u0004\u0018\u00010\u000fHÆ\u0003J\u000b\u0010D\u001a\u0004\u0018\u00010\u000fHÆ\u0003J\u000b\u0010E\u001a\u0004\u0018\u00010\u000fHÆ\u0003J\u000b\u0010F\u001a\u0004\u0018\u00010\u000fHÆ\u0003J\t\u0010G\u001a\u00020\u0007HÆ\u0003J\t\u0010H\u001a\u00020\u0015HÆ\u0003J\u000b\u0010I\u001a\u0004\u0018\u00010\u0017HÆ\u0003J\u0011\u0010J\u001a\n\u0012\u0004\u0012\u00020\u001a\u0018\u00010\u0019HÆ\u0003J\u0011\u0010K\u001a\n\u0012\u0004\u0012\u00020\u001c\u0018\u00010\u0019HÆ\u0003J\u000b\u0010L\u001a\u0004\u0018\u00010\u001eHÆ\u0003J\u000b\u0010M\u001a\u0004\u0018\u00010\u0005HÆ\u0003Já\u0001\u0010N\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\u00072\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\f2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\f2\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u000f2\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u000f2\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u000f2\b\b\u0002\u0010\u0013\u001a\u00020\u00072\b\b\u0002\u0010\u0014\u001a\u00020\u00152\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u00172\u0010\b\u0002\u0010\u0018\u001a\n\u0012\u0004\u0012\u00020\u001a\u0018\u00010\u00192\u0010\b\u0002\u0010\u001b\u001a\n\u0012\u0004\u0012\u00020\u001c\u0018\u00010\u00192\n\b\u0002\u0010\u001d\u001a\u0004\u0018\u00010\u001e2\n\b\u0002\u0010\u001f\u001a\u0004\u0018\u00010\u0005HÆ\u0001J\u0006\u0010O\u001a\u00020PJ\u0013\u0010Q\u001a\u00020\u00072\b\u0010R\u001a\u0004\u0018\u00010SHÖ\u0003J\t\u0010T\u001a\u00020PHÖ\u0001J\t\u0010U\u001a\u00020\u0005HÖ\u0001J\u0016\u0010V\u001a\u00020W2\u0006\u0010X\u001a\u00020Y2\u0006\u0010Z\u001a\u00020PR\u0014\u0010\u0002\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010#R\u0014\u0010\u0004\u001a\u00020\u0005X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b$\u0010%R\u0014\u0010\u0006\u001a\u00020\u0007X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010&R\u0014\u0010\b\u001a\u00020\u0007X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b'\u0010&R\u0016\u0010\t\u001a\u0004\u0018\u00010\nX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b(\u0010)R\u0016\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b*\u0010+R\u0016\u0010\r\u001a\u0004\u0018\u00010\fX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b,\u0010+R\u0016\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b-\u0010.R\u0016\u0010\u0010\u001a\u0004\u0018\u00010\u000fX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b/\u0010.R\u0016\u0010\u0011\u001a\u0004\u0018\u00010\u000fX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b0\u0010.R\u0016\u0010\u0012\u001a\u0004\u0018\u00010\u000fX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b1\u0010.R\u0014\u0010\u0013\u001a\u00020\u0007X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010&R\u0014\u0010\u0014\u001a\u00020\u0015X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b2\u00103R\u0016\u0010\u0016\u001a\u0004\u0018\u00010\u0017X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b4\u00105R\u001c\u0010\u0018\u001a\n\u0012\u0004\u0012\u00020\u001a\u0018\u00010\u0019X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b6\u00107R\u001c\u0010\u001b\u001a\n\u0012\u0004\u0012\u00020\u001c\u0018\u00010\u0019X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b8\u00107R\u0016\u0010\u001d\u001a\u0004\u0018\u00010\u001eX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b9\u0010:R\u0016\u0010\u001f\u001a\u0004\u0018\u00010\u0005X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b;\u0010%¨\u0006["}, d2 = {"Lcom/box/android/domain/models/item/UnknownItemModel;", "Lcom/box/android/domain/models/item/ItemModel;", "itemId", "Lcom/box/android/domain/models/ItemId;", "name", "", "isExternallyOwned", "", "hasCollaborations", "parentFolder", "Lcom/box/android/domain/models/item/FolderModel;", "owner", "Lcom/box/android/domain/models/item/UserModel;", "updatedBy", "createdDate", "Ljava/util/Date;", "contentCreatedDate", "modifiedDate", "contentModifiedDate", "isRooted", "size", "", "permissions", "Lcom/box/android/domain/models/item/PermissionsModel;", "pathCollection", "", "Lcom/box/android/domain/models/item/PathCollectionEntry;", BoxItem.FIELD_COLLECTIONS, "Lcom/box/android/domain/models/CollectionModel;", BoxNoteConstants.NOTES_BUILDER_SHARED_LINK, "Lcom/box/android/domain/models/item/SharedLinkModel;", "description", "<init>", "(Lcom/box/android/domain/models/ItemId;Ljava/lang/String;ZZLcom/box/android/domain/models/item/FolderModel;Lcom/box/android/domain/models/item/UserModel;Lcom/box/android/domain/models/item/UserModel;Ljava/util/Date;Ljava/util/Date;Ljava/util/Date;Ljava/util/Date;ZJLcom/box/android/domain/models/item/PermissionsModel;Ljava/util/List;Ljava/util/List;Lcom/box/android/domain/models/item/SharedLinkModel;Ljava/lang/String;)V", "getItemId", "()Lcom/box/android/domain/models/ItemId;", "getName", "()Ljava/lang/String;", "()Z", "getHasCollaborations", "getParentFolder", "()Lcom/box/android/domain/models/item/FolderModel;", "getOwner", "()Lcom/box/android/domain/models/item/UserModel;", "getUpdatedBy", "getCreatedDate", "()Ljava/util/Date;", "getContentCreatedDate", "getModifiedDate", "getContentModifiedDate", "getSize", "()Ljava/lang/Long;", "getPermissions", "()Lcom/box/android/domain/models/item/PermissionsModel;", "getPathCollection", "()Ljava/util/List;", "getCollections", "getSharedLink", "()Lcom/box/android/domain/models/item/SharedLinkModel;", "getDescription", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "component17", "component18", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "describeContents", "", "equals", "other", "", "hashCode", "toString", "writeToParcel", "", "dest", "Landroid/os/Parcel;", "flags", "domain_prodRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final /* data */ class UnknownItemModel extends ItemModel {
    public static final Parcelable.Creator<UnknownItemModel> CREATOR = new Creator();
    private final List<CollectionModel> collections;
    private final Date contentCreatedDate;
    private final Date contentModifiedDate;
    private final Date createdDate;
    private final String description;
    private final boolean hasCollaborations;
    private final boolean isExternallyOwned;
    private final boolean isRooted;
    private final ItemId itemId;
    private final Date modifiedDate;
    private final String name;
    private final UserModel owner;
    private final FolderModel parentFolder;
    private final List<PathCollectionEntry> pathCollection;
    private final PermissionsModel permissions;
    private final SharedLinkModel sharedLink;
    private final long size;
    private final UserModel updatedBy;

    /* JADX INFO: compiled from: UnknownItemModel.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    public static final class Creator implements Parcelable.Creator<UnknownItemModel> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final UnknownItemModel createFromParcel(Parcel parcel) {
            ArrayList arrayList;
            ArrayList arrayList2;
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            ItemId itemId = (ItemId) parcel.readParcelable(UnknownItemModel.class.getClassLoader());
            String string = parcel.readString();
            boolean z = false;
            if (parcel.readInt() != 0) {
                z = true;
            }
            boolean z2 = parcel.readInt() != 0 ? true : z;
            FolderModel folderModelCreateFromParcel = parcel.readInt() == 0 ? null : FolderModel.CREATOR.createFromParcel(parcel);
            UserModel userModelCreateFromParcel = parcel.readInt() == 0 ? null : UserModel.CREATOR.createFromParcel(parcel);
            UserModel userModelCreateFromParcel2 = parcel.readInt() == 0 ? null : UserModel.CREATOR.createFromParcel(parcel);
            Date date = (Date) parcel.readSerializable();
            Date date2 = (Date) parcel.readSerializable();
            Date date3 = (Date) parcel.readSerializable();
            Date date4 = (Date) parcel.readSerializable();
            boolean z3 = parcel.readInt() != 0;
            long j = parcel.readLong();
            PermissionsModel permissionsModelCreateFromParcel = parcel.readInt() == 0 ? null : PermissionsModel.CREATOR.createFromParcel(parcel);
            if (parcel.readInt() == 0) {
                arrayList = null;
            } else {
                int i = parcel.readInt();
                arrayList = new ArrayList(i);
                int i2 = 0;
                while (i2 != i) {
                    arrayList.add(PathCollectionEntry.CREATOR.createFromParcel(parcel));
                    i2++;
                    i = i;
                }
            }
            ArrayList arrayList3 = arrayList;
            if (parcel.readInt() == 0) {
                arrayList2 = null;
            } else {
                int i3 = parcel.readInt();
                arrayList2 = new ArrayList(i3);
                int i4 = 0;
                while (i4 != i3) {
                    arrayList2.add(CollectionModel.CREATOR.createFromParcel(parcel));
                    i4++;
                    i3 = i3;
                }
            }
            return new UnknownItemModel(itemId, string, z, z2, folderModelCreateFromParcel, userModelCreateFromParcel, userModelCreateFromParcel2, date, date2, date3, date4, z3, j, permissionsModelCreateFromParcel, arrayList3, arrayList2, parcel.readInt() == 0 ? null : SharedLinkModel.CREATOR.createFromParcel(parcel), parcel.readString());
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final UnknownItemModel[] newArray(int i) {
            return new UnknownItemModel[i];
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ UnknownItemModel copy$default(UnknownItemModel unknownItemModel, ItemId itemId, String str, boolean z, boolean z2, FolderModel folderModel, UserModel userModel, UserModel userModel2, Date date, Date date2, Date date3, Date date4, boolean z3, long j, PermissionsModel permissionsModel, List list, List list2, SharedLinkModel sharedLinkModel, String str2, int i, Object obj) {
        String str3;
        SharedLinkModel sharedLinkModel2;
        ItemId itemId2 = (i & 1) != 0 ? unknownItemModel.itemId : itemId;
        String str4 = (i & 2) != 0 ? unknownItemModel.name : str;
        boolean z4 = (i & 4) != 0 ? unknownItemModel.isExternallyOwned : z;
        boolean z5 = (i & 8) != 0 ? unknownItemModel.hasCollaborations : z2;
        FolderModel folderModel2 = (i & 16) != 0 ? unknownItemModel.parentFolder : folderModel;
        UserModel userModel3 = (i & 32) != 0 ? unknownItemModel.owner : userModel;
        UserModel userModel4 = (i & 64) != 0 ? unknownItemModel.updatedBy : userModel2;
        Date date5 = (i & 128) != 0 ? unknownItemModel.createdDate : date;
        Date date6 = (i & 256) != 0 ? unknownItemModel.contentCreatedDate : date2;
        Date date7 = (i & 512) != 0 ? unknownItemModel.modifiedDate : date3;
        Date date8 = (i & 1024) != 0 ? unknownItemModel.contentModifiedDate : date4;
        boolean z6 = (i & 2048) != 0 ? unknownItemModel.isRooted : z3;
        long j2 = (i & 4096) != 0 ? unknownItemModel.size : j;
        ItemId itemId3 = itemId2;
        PermissionsModel permissionsModel2 = (i & 8192) != 0 ? unknownItemModel.permissions : permissionsModel;
        List list3 = (i & 16384) != 0 ? unknownItemModel.pathCollection : list;
        List list4 = (i & 32768) != 0 ? unknownItemModel.collections : list2;
        SharedLinkModel sharedLinkModel3 = (i & 65536) != 0 ? unknownItemModel.sharedLink : sharedLinkModel;
        if ((i & 131072) != 0) {
            sharedLinkModel2 = sharedLinkModel3;
            str3 = unknownItemModel.description;
        } else {
            str3 = str2;
            sharedLinkModel2 = sharedLinkModel3;
        }
        return unknownItemModel.copy(itemId3, str4, z4, z5, folderModel2, userModel3, userModel4, date5, date6, date7, date8, z6, j2, permissionsModel2, list3, list4, sharedLinkModel2, str3);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final ItemId getItemId() {
        return this.itemId;
    }

    /* JADX INFO: renamed from: component10, reason: from getter */
    public final Date getModifiedDate() {
        return this.modifiedDate;
    }

    /* JADX INFO: renamed from: component11, reason: from getter */
    public final Date getContentModifiedDate() {
        return this.contentModifiedDate;
    }

    /* JADX INFO: renamed from: component12, reason: from getter */
    public final boolean getIsRooted() {
        return this.isRooted;
    }

    /* JADX INFO: renamed from: component13, reason: from getter */
    public final long getSize() {
        return this.size;
    }

    /* JADX INFO: renamed from: component14, reason: from getter */
    public final PermissionsModel getPermissions() {
        return this.permissions;
    }

    public final List<PathCollectionEntry> component15() {
        return this.pathCollection;
    }

    public final List<CollectionModel> component16() {
        return this.collections;
    }

    /* JADX INFO: renamed from: component17, reason: from getter */
    public final SharedLinkModel getSharedLink() {
        return this.sharedLink;
    }

    /* JADX INFO: renamed from: component18, reason: from getter */
    public final String getDescription() {
        return this.description;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getName() {
        return this.name;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final boolean getIsExternallyOwned() {
        return this.isExternallyOwned;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final boolean getHasCollaborations() {
        return this.hasCollaborations;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final FolderModel getParentFolder() {
        return this.parentFolder;
    }

    /* JADX INFO: renamed from: component6, reason: from getter */
    public final UserModel getOwner() {
        return this.owner;
    }

    /* JADX INFO: renamed from: component7, reason: from getter */
    public final UserModel getUpdatedBy() {
        return this.updatedBy;
    }

    /* JADX INFO: renamed from: component8, reason: from getter */
    public final Date getCreatedDate() {
        return this.createdDate;
    }

    /* JADX INFO: renamed from: component9, reason: from getter */
    public final Date getContentCreatedDate() {
        return this.contentCreatedDate;
    }

    public final UnknownItemModel copy(ItemId itemId, String name, boolean isExternallyOwned, boolean hasCollaborations, FolderModel parentFolder, UserModel owner, UserModel updatedBy, Date createdDate, Date contentCreatedDate, Date modifiedDate, Date contentModifiedDate, boolean isRooted, long size, PermissionsModel permissions, List<PathCollectionEntry> pathCollection, List<CollectionModel> collections, SharedLinkModel sharedLink, String description) {
        Intrinsics.checkNotNullParameter(itemId, "itemId");
        Intrinsics.checkNotNullParameter(name, "name");
        return new UnknownItemModel(itemId, name, isExternallyOwned, hasCollaborations, parentFolder, owner, updatedBy, createdDate, contentCreatedDate, modifiedDate, contentModifiedDate, isRooted, size, permissions, pathCollection, collections, sharedLink, description);
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof UnknownItemModel)) {
            return false;
        }
        UnknownItemModel unknownItemModel = (UnknownItemModel) other;
        return Intrinsics.areEqual(this.itemId, unknownItemModel.itemId) && Intrinsics.areEqual(this.name, unknownItemModel.name) && this.isExternallyOwned == unknownItemModel.isExternallyOwned && this.hasCollaborations == unknownItemModel.hasCollaborations && Intrinsics.areEqual(this.parentFolder, unknownItemModel.parentFolder) && Intrinsics.areEqual(this.owner, unknownItemModel.owner) && Intrinsics.areEqual(this.updatedBy, unknownItemModel.updatedBy) && Intrinsics.areEqual(this.createdDate, unknownItemModel.createdDate) && Intrinsics.areEqual(this.contentCreatedDate, unknownItemModel.contentCreatedDate) && Intrinsics.areEqual(this.modifiedDate, unknownItemModel.modifiedDate) && Intrinsics.areEqual(this.contentModifiedDate, unknownItemModel.contentModifiedDate) && this.isRooted == unknownItemModel.isRooted && this.size == unknownItemModel.size && Intrinsics.areEqual(this.permissions, unknownItemModel.permissions) && Intrinsics.areEqual(this.pathCollection, unknownItemModel.pathCollection) && Intrinsics.areEqual(this.collections, unknownItemModel.collections) && Intrinsics.areEqual(this.sharedLink, unknownItemModel.sharedLink) && Intrinsics.areEqual(this.description, unknownItemModel.description);
    }

    public int hashCode() {
        int iHashCode = ((((((this.itemId.hashCode() * 31) + this.name.hashCode()) * 31) + Boolean.hashCode(this.isExternallyOwned)) * 31) + Boolean.hashCode(this.hasCollaborations)) * 31;
        FolderModel folderModel = this.parentFolder;
        int iHashCode2 = (iHashCode + (folderModel == null ? 0 : folderModel.hashCode())) * 31;
        UserModel userModel = this.owner;
        int iHashCode3 = (iHashCode2 + (userModel == null ? 0 : userModel.hashCode())) * 31;
        UserModel userModel2 = this.updatedBy;
        int iHashCode4 = (iHashCode3 + (userModel2 == null ? 0 : userModel2.hashCode())) * 31;
        Date date = this.createdDate;
        int iHashCode5 = (iHashCode4 + (date == null ? 0 : date.hashCode())) * 31;
        Date date2 = this.contentCreatedDate;
        int iHashCode6 = (iHashCode5 + (date2 == null ? 0 : date2.hashCode())) * 31;
        Date date3 = this.modifiedDate;
        int iHashCode7 = (iHashCode6 + (date3 == null ? 0 : date3.hashCode())) * 31;
        Date date4 = this.contentModifiedDate;
        int iHashCode8 = (((((iHashCode7 + (date4 == null ? 0 : date4.hashCode())) * 31) + Boolean.hashCode(this.isRooted)) * 31) + Long.hashCode(this.size)) * 31;
        PermissionsModel permissionsModel = this.permissions;
        int iHashCode9 = (iHashCode8 + (permissionsModel == null ? 0 : permissionsModel.hashCode())) * 31;
        List<PathCollectionEntry> list = this.pathCollection;
        int iHashCode10 = (iHashCode9 + (list == null ? 0 : list.hashCode())) * 31;
        List<CollectionModel> list2 = this.collections;
        int iHashCode11 = (iHashCode10 + (list2 == null ? 0 : list2.hashCode())) * 31;
        SharedLinkModel sharedLinkModel = this.sharedLink;
        int iHashCode12 = (iHashCode11 + (sharedLinkModel == null ? 0 : sharedLinkModel.hashCode())) * 31;
        String str = this.description;
        return iHashCode12 + (str != null ? str.hashCode() : 0);
    }

    public String toString() {
        return "UnknownItemModel(itemId=" + this.itemId + ", name=" + this.name + ", isExternallyOwned=" + this.isExternallyOwned + ", hasCollaborations=" + this.hasCollaborations + ", parentFolder=" + this.parentFolder + ", owner=" + this.owner + ", updatedBy=" + this.updatedBy + ", createdDate=" + this.createdDate + ", contentCreatedDate=" + this.contentCreatedDate + ", modifiedDate=" + this.modifiedDate + ", contentModifiedDate=" + this.contentModifiedDate + ", isRooted=" + this.isRooted + ", size=" + this.size + ", permissions=" + this.permissions + ", pathCollection=" + this.pathCollection + ", collections=" + this.collections + ", sharedLink=" + this.sharedLink + ", description=" + this.description + ")";
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel dest, int flags) {
        Intrinsics.checkNotNullParameter(dest, "dest");
        dest.writeParcelable(this.itemId, flags);
        dest.writeString(this.name);
        dest.writeInt(this.isExternallyOwned ? 1 : 0);
        dest.writeInt(this.hasCollaborations ? 1 : 0);
        FolderModel folderModel = this.parentFolder;
        if (folderModel == null) {
            dest.writeInt(0);
        } else {
            dest.writeInt(1);
            folderModel.writeToParcel(dest, flags);
        }
        UserModel userModel = this.owner;
        if (userModel == null) {
            dest.writeInt(0);
        } else {
            dest.writeInt(1);
            userModel.writeToParcel(dest, flags);
        }
        UserModel userModel2 = this.updatedBy;
        if (userModel2 == null) {
            dest.writeInt(0);
        } else {
            dest.writeInt(1);
            userModel2.writeToParcel(dest, flags);
        }
        dest.writeSerializable(this.createdDate);
        dest.writeSerializable(this.contentCreatedDate);
        dest.writeSerializable(this.modifiedDate);
        dest.writeSerializable(this.contentModifiedDate);
        dest.writeInt(this.isRooted ? 1 : 0);
        dest.writeLong(this.size);
        PermissionsModel permissionsModel = this.permissions;
        if (permissionsModel == null) {
            dest.writeInt(0);
        } else {
            dest.writeInt(1);
            permissionsModel.writeToParcel(dest, flags);
        }
        List<PathCollectionEntry> list = this.pathCollection;
        if (list == null) {
            dest.writeInt(0);
        } else {
            dest.writeInt(1);
            dest.writeInt(list.size());
            Iterator<PathCollectionEntry> it = list.iterator();
            while (it.hasNext()) {
                it.next().writeToParcel(dest, flags);
            }
        }
        List<CollectionModel> list2 = this.collections;
        if (list2 == null) {
            dest.writeInt(0);
        } else {
            dest.writeInt(1);
            dest.writeInt(list2.size());
            Iterator<CollectionModel> it2 = list2.iterator();
            while (it2.hasNext()) {
                it2.next().writeToParcel(dest, flags);
            }
        }
        SharedLinkModel sharedLinkModel = this.sharedLink;
        if (sharedLinkModel == null) {
            dest.writeInt(0);
        } else {
            dest.writeInt(1);
            sharedLinkModel.writeToParcel(dest, flags);
        }
        dest.writeString(this.description);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public UnknownItemModel(ItemId itemId, String name, boolean z, boolean z2, FolderModel folderModel, UserModel userModel, UserModel userModel2, Date date, Date date2, Date date3, Date date4, boolean z3, long j, PermissionsModel permissionsModel, List<PathCollectionEntry> list, List<CollectionModel> list2, SharedLinkModel sharedLinkModel, String str) {
        super(null);
        Intrinsics.checkNotNullParameter(itemId, "itemId");
        Intrinsics.checkNotNullParameter(name, "name");
        this.itemId = itemId;
        this.name = name;
        this.isExternallyOwned = z;
        this.hasCollaborations = z2;
        this.parentFolder = folderModel;
        this.owner = userModel;
        this.updatedBy = userModel2;
        this.createdDate = date;
        this.contentCreatedDate = date2;
        this.modifiedDate = date3;
        this.contentModifiedDate = date4;
        this.isRooted = z3;
        this.size = j;
        this.permissions = permissionsModel;
        this.pathCollection = list;
        this.collections = list2;
        this.sharedLink = sharedLinkModel;
        this.description = str;
    }

    public /* synthetic */ UnknownItemModel(ItemId itemId, String str, boolean z, boolean z2, FolderModel folderModel, UserModel userModel, UserModel userModel2, Date date, Date date2, Date date3, Date date4, boolean z3, long j, PermissionsModel permissionsModel, List list, List list2, SharedLinkModel sharedLinkModel, String str2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(itemId, str, z, z2, folderModel, userModel, userModel2, date, date2, date3, date4, z3, j, permissionsModel, list, list2, sharedLinkModel, (i & 131072) != 0 ? null : str2);
    }

    @Override // com.box.android.domain.models.item.ItemModel
    public ItemId getItemId() {
        return this.itemId;
    }

    @Override // com.box.android.domain.models.item.ItemModel
    public String getName() {
        return this.name;
    }

    @Override // com.box.android.domain.models.item.ItemModel
    public boolean isExternallyOwned() {
        return this.isExternallyOwned;
    }

    @Override // com.box.android.domain.models.item.ItemModel
    public boolean getHasCollaborations() {
        return this.hasCollaborations;
    }

    @Override // com.box.android.domain.models.item.ItemModel
    public FolderModel getParentFolder() {
        return this.parentFolder;
    }

    @Override // com.box.android.domain.models.item.ItemModel
    public UserModel getOwner() {
        return this.owner;
    }

    @Override // com.box.android.domain.models.item.ItemModel
    public UserModel getUpdatedBy() {
        return this.updatedBy;
    }

    @Override // com.box.android.domain.models.item.ItemModel
    public Date getCreatedDate() {
        return this.createdDate;
    }

    @Override // com.box.android.domain.models.item.ItemModel
    public Date getContentCreatedDate() {
        return this.contentCreatedDate;
    }

    @Override // com.box.android.domain.models.item.ItemModel
    public Date getModifiedDate() {
        return this.modifiedDate;
    }

    @Override // com.box.android.domain.models.item.ItemModel
    public Date getContentModifiedDate() {
        return this.contentModifiedDate;
    }

    @Override // com.box.android.domain.models.item.ItemModel
    public boolean isRooted() {
        return this.isRooted;
    }

    @Override // com.box.android.domain.models.item.ItemModel
    public Long getSize() {
        return Long.valueOf(this.size);
    }

    @Override // com.box.android.domain.models.item.ItemModel
    public PermissionsModel getPermissions() {
        return this.permissions;
    }

    @Override // com.box.android.domain.models.item.ItemModel
    public List<PathCollectionEntry> getPathCollection() {
        return this.pathCollection;
    }

    @Override // com.box.android.domain.models.item.ItemModel
    public List<CollectionModel> getCollections() {
        return this.collections;
    }

    @Override // com.box.android.domain.models.item.ItemModel
    public SharedLinkModel getSharedLink() {
        return this.sharedLink;
    }

    @Override // com.box.android.domain.models.item.ItemModel
    public String getDescription() {
        return this.description;
    }
}
