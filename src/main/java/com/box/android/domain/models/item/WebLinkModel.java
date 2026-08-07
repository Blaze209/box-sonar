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

/* JADX INFO: compiled from: WebLinkModel.kt */
/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u001d\n\u0002\u0010\t\n\u0002\b\u0018\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0087\b\u0018\u0000 _2\u00020\u0001:\u0001_BÅ\u0001\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\u0007\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\f\u0012\b\u0010\r\u001a\u0004\u0018\u00010\f\u0012\b\u0010\u000e\u001a\u0004\u0018\u00010\u000f\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u000f\u0012\b\u0010\u0011\u001a\u0004\u0018\u00010\u000f\u0012\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u000f\u0012\u0006\u0010\u0013\u001a\u00020\u0007\u0012\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015\u0012\u000e\u0010\u0016\u001a\n\u0012\u0004\u0012\u00020\u0018\u0018\u00010\u0017\u0012\b\u0010\u0019\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u001a\u001a\u0004\u0018\u00010\u001b\u0012\u000e\u0010\u001c\u001a\n\u0012\u0004\u0012\u00020\u001d\u0018\u00010\u0017\u0012\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u001f\u0010 J\t\u0010@\u001a\u00020\u0003HÆ\u0003J\t\u0010A\u001a\u00020\u0005HÆ\u0003J\t\u0010B\u001a\u00020\u0007HÆ\u0003J\t\u0010C\u001a\u00020\u0007HÆ\u0003J\u000b\u0010D\u001a\u0004\u0018\u00010\nHÆ\u0003J\u000b\u0010E\u001a\u0004\u0018\u00010\fHÆ\u0003J\u000b\u0010F\u001a\u0004\u0018\u00010\fHÆ\u0003J\u000b\u0010G\u001a\u0004\u0018\u00010\u000fHÆ\u0003J\u000b\u0010H\u001a\u0004\u0018\u00010\u000fHÆ\u0003J\u000b\u0010I\u001a\u0004\u0018\u00010\u000fHÆ\u0003J\u000b\u0010J\u001a\u0004\u0018\u00010\u000fHÆ\u0003J\t\u0010K\u001a\u00020\u0007HÆ\u0003J\u000b\u0010L\u001a\u0004\u0018\u00010\u0015HÆ\u0003J\u0011\u0010M\u001a\n\u0012\u0004\u0012\u00020\u0018\u0018\u00010\u0017HÆ\u0003J\u000b\u0010N\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010O\u001a\u0004\u0018\u00010\u001bHÆ\u0003J\u0011\u0010P\u001a\n\u0012\u0004\u0012\u00020\u001d\u0018\u00010\u0017HÆ\u0003J\u000b\u0010Q\u001a\u0004\u0018\u00010\u0005HÆ\u0003Jã\u0001\u0010R\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\u00072\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\f2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\f2\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u000f2\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u000f2\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u000f2\b\b\u0002\u0010\u0013\u001a\u00020\u00072\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u00152\u0010\b\u0002\u0010\u0016\u001a\n\u0012\u0004\u0012\u00020\u0018\u0018\u00010\u00172\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u001b2\u0010\b\u0002\u0010\u001c\u001a\n\u0012\u0004\u0012\u00020\u001d\u0018\u00010\u00172\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\u0005HÆ\u0001J\u0006\u0010S\u001a\u00020TJ\u0013\u0010U\u001a\u00020\u00072\b\u0010V\u001a\u0004\u0018\u00010WHÖ\u0003J\t\u0010X\u001a\u00020THÖ\u0001J\t\u0010Y\u001a\u00020\u0005HÖ\u0001J\u0016\u0010Z\u001a\u00020[2\u0006\u0010\\\u001a\u00020]2\u0006\u0010^\u001a\u00020TR\u0014\u0010\u0002\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\"R\u0014\u0010\u0004\u001a\u00020\u0005X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b#\u0010$R\u0014\u0010\u0006\u001a\u00020\u0007X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b%\u0010&R\u0014\u0010\b\u001a\u00020\u0007X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010&R\u0016\u0010\t\u001a\u0004\u0018\u00010\nX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b'\u0010(R\u0016\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b)\u0010*R\u0016\u0010\r\u001a\u0004\u0018\u00010\fX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b+\u0010*R\u0016\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b,\u0010-R\u0016\u0010\u0010\u001a\u0004\u0018\u00010\u000fX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b.\u0010-R\u0016\u0010\u0011\u001a\u0004\u0018\u00010\u000fX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b/\u0010-R\u0016\u0010\u0012\u001a\u0004\u0018\u00010\u000fX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b0\u0010-R\u0014\u0010\u0013\u001a\u00020\u0007X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010&R\u0016\u0010\u0014\u001a\u0004\u0018\u00010\u0015X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b1\u00102R\u001c\u0010\u0016\u001a\n\u0012\u0004\u0012\u00020\u0018\u0018\u00010\u0017X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b3\u00104R\u0013\u0010\u0019\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b5\u0010$R\u0016\u0010\u001a\u001a\u0004\u0018\u00010\u001bX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b6\u00107R\u001c\u0010\u001c\u001a\n\u0012\u0004\u0012\u00020\u001d\u0018\u00010\u0017X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b8\u00104R\u0016\u0010\u001e\u001a\u0004\u0018\u00010\u0005X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b9\u0010$R\u001a\u0010:\u001a\u00020;X\u0096D¢\u0006\u000e\n\u0000\u0012\u0004\b<\u0010=\u001a\u0004\b>\u0010?¨\u0006`"}, d2 = {"Lcom/box/android/domain/models/item/WebLinkModel;", "Lcom/box/android/domain/models/item/ItemModel;", "itemId", "Lcom/box/android/domain/models/ItemId;", "name", "", "hasCollaborations", "", "isExternallyOwned", "parentFolder", "Lcom/box/android/domain/models/item/FolderModel;", "owner", "Lcom/box/android/domain/models/item/UserModel;", "updatedBy", "createdDate", "Ljava/util/Date;", "contentCreatedDate", "modifiedDate", "contentModifiedDate", "isRooted", "permissions", "Lcom/box/android/domain/models/item/PermissionsModel;", "pathCollection", "", "Lcom/box/android/domain/models/item/PathCollectionEntry;", "url", BoxNoteConstants.NOTES_BUILDER_SHARED_LINK, "Lcom/box/android/domain/models/item/SharedLinkModel;", BoxItem.FIELD_COLLECTIONS, "Lcom/box/android/domain/models/CollectionModel;", "description", "<init>", "(Lcom/box/android/domain/models/ItemId;Ljava/lang/String;ZZLcom/box/android/domain/models/item/FolderModel;Lcom/box/android/domain/models/item/UserModel;Lcom/box/android/domain/models/item/UserModel;Ljava/util/Date;Ljava/util/Date;Ljava/util/Date;Ljava/util/Date;ZLcom/box/android/domain/models/item/PermissionsModel;Ljava/util/List;Ljava/lang/String;Lcom/box/android/domain/models/item/SharedLinkModel;Ljava/util/List;Ljava/lang/String;)V", "getItemId", "()Lcom/box/android/domain/models/ItemId;", "getName", "()Ljava/lang/String;", "getHasCollaborations", "()Z", "getParentFolder", "()Lcom/box/android/domain/models/item/FolderModel;", "getOwner", "()Lcom/box/android/domain/models/item/UserModel;", "getUpdatedBy", "getCreatedDate", "()Ljava/util/Date;", "getContentCreatedDate", "getModifiedDate", "getContentModifiedDate", "getPermissions", "()Lcom/box/android/domain/models/item/PermissionsModel;", "getPathCollection", "()Ljava/util/List;", "getUrl", "getSharedLink", "()Lcom/box/android/domain/models/item/SharedLinkModel;", "getCollections", "getDescription", "size", "", "getSize$annotations", "()V", "getSize", "()Ljava/lang/Long;", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "component17", "component18", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "describeContents", "", "equals", "other", "", "hashCode", "toString", "writeToParcel", "", "dest", "Landroid/os/Parcel;", "flags", "Companion", "domain_prodRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final /* data */ class WebLinkModel extends ItemModel {
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
    private final String url;

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public static final Parcelable.Creator<WebLinkModel> CREATOR = new Creator();

    /* JADX INFO: compiled from: WebLinkModel.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    public static final class Creator implements Parcelable.Creator<WebLinkModel> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final WebLinkModel createFromParcel(Parcel parcel) {
            ArrayList arrayList;
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            ItemId itemId = (ItemId) parcel.readParcelable(WebLinkModel.class.getClassLoader());
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
            ArrayList arrayList2 = arrayList;
            boolean z4 = z3;
            ArrayList arrayList3 = null;
            String string2 = parcel.readString();
            SharedLinkModel sharedLinkModelCreateFromParcel = parcel.readInt() == 0 ? null : SharedLinkModel.CREATOR.createFromParcel(parcel);
            if (parcel.readInt() != 0) {
                int i3 = parcel.readInt();
                ArrayList arrayList4 = new ArrayList(i3);
                int i4 = 0;
                while (i4 != i3) {
                    arrayList4.add(CollectionModel.CREATOR.createFromParcel(parcel));
                    i4++;
                    i3 = i3;
                }
                arrayList3 = arrayList4;
            }
            return new WebLinkModel(itemId, string, z, z2, folderModelCreateFromParcel, userModelCreateFromParcel, userModelCreateFromParcel2, date, date2, date3, date4, z4, permissionsModelCreateFromParcel, arrayList2, string2, sharedLinkModelCreateFromParcel, arrayList3, parcel.readString());
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final WebLinkModel[] newArray(int i) {
            return new WebLinkModel[i];
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ WebLinkModel copy$default(WebLinkModel webLinkModel, ItemId itemId, String str, boolean z, boolean z2, FolderModel folderModel, UserModel userModel, UserModel userModel2, Date date, Date date2, Date date3, Date date4, boolean z3, PermissionsModel permissionsModel, List list, String str2, SharedLinkModel sharedLinkModel, List list2, String str3, int i, Object obj) {
        String str4;
        List list3;
        ItemId itemId2 = (i & 1) != 0 ? webLinkModel.itemId : itemId;
        String str5 = (i & 2) != 0 ? webLinkModel.name : str;
        boolean z4 = (i & 4) != 0 ? webLinkModel.hasCollaborations : z;
        boolean z5 = (i & 8) != 0 ? webLinkModel.isExternallyOwned : z2;
        FolderModel folderModel2 = (i & 16) != 0 ? webLinkModel.parentFolder : folderModel;
        UserModel userModel3 = (i & 32) != 0 ? webLinkModel.owner : userModel;
        UserModel userModel4 = (i & 64) != 0 ? webLinkModel.updatedBy : userModel2;
        Date date5 = (i & 128) != 0 ? webLinkModel.createdDate : date;
        Date date6 = (i & 256) != 0 ? webLinkModel.contentCreatedDate : date2;
        Date date7 = (i & 512) != 0 ? webLinkModel.modifiedDate : date3;
        Date date8 = (i & 1024) != 0 ? webLinkModel.contentModifiedDate : date4;
        boolean z6 = (i & 2048) != 0 ? webLinkModel.isRooted : z3;
        PermissionsModel permissionsModel2 = (i & 4096) != 0 ? webLinkModel.permissions : permissionsModel;
        List list4 = (i & 8192) != 0 ? webLinkModel.pathCollection : list;
        ItemId itemId3 = itemId2;
        String str6 = (i & 16384) != 0 ? webLinkModel.url : str2;
        SharedLinkModel sharedLinkModel2 = (i & 32768) != 0 ? webLinkModel.sharedLink : sharedLinkModel;
        List list5 = (i & 65536) != 0 ? webLinkModel.collections : list2;
        if ((i & 131072) != 0) {
            list3 = list5;
            str4 = webLinkModel.description;
        } else {
            str4 = str3;
            list3 = list5;
        }
        return webLinkModel.copy(itemId3, str5, z4, z5, folderModel2, userModel3, userModel4, date5, date6, date7, date8, z6, permissionsModel2, list4, str6, sharedLinkModel2, list3, str4);
    }

    public static /* synthetic */ void getSize$annotations() {
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
    public final PermissionsModel getPermissions() {
        return this.permissions;
    }

    public final List<PathCollectionEntry> component14() {
        return this.pathCollection;
    }

    /* JADX INFO: renamed from: component15, reason: from getter */
    public final String getUrl() {
        return this.url;
    }

    /* JADX INFO: renamed from: component16, reason: from getter */
    public final SharedLinkModel getSharedLink() {
        return this.sharedLink;
    }

    public final List<CollectionModel> component17() {
        return this.collections;
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
    public final boolean getHasCollaborations() {
        return this.hasCollaborations;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final boolean getIsExternallyOwned() {
        return this.isExternallyOwned;
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

    public final WebLinkModel copy(ItemId itemId, String name, boolean hasCollaborations, boolean isExternallyOwned, FolderModel parentFolder, UserModel owner, UserModel updatedBy, Date createdDate, Date contentCreatedDate, Date modifiedDate, Date contentModifiedDate, boolean isRooted, PermissionsModel permissions, List<PathCollectionEntry> pathCollection, String url, SharedLinkModel sharedLink, List<CollectionModel> collections, String description) {
        Intrinsics.checkNotNullParameter(itemId, "itemId");
        Intrinsics.checkNotNullParameter(name, "name");
        return new WebLinkModel(itemId, name, hasCollaborations, isExternallyOwned, parentFolder, owner, updatedBy, createdDate, contentCreatedDate, modifiedDate, contentModifiedDate, isRooted, permissions, pathCollection, url, sharedLink, collections, description);
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof WebLinkModel)) {
            return false;
        }
        WebLinkModel webLinkModel = (WebLinkModel) other;
        return Intrinsics.areEqual(this.itemId, webLinkModel.itemId) && Intrinsics.areEqual(this.name, webLinkModel.name) && this.hasCollaborations == webLinkModel.hasCollaborations && this.isExternallyOwned == webLinkModel.isExternallyOwned && Intrinsics.areEqual(this.parentFolder, webLinkModel.parentFolder) && Intrinsics.areEqual(this.owner, webLinkModel.owner) && Intrinsics.areEqual(this.updatedBy, webLinkModel.updatedBy) && Intrinsics.areEqual(this.createdDate, webLinkModel.createdDate) && Intrinsics.areEqual(this.contentCreatedDate, webLinkModel.contentCreatedDate) && Intrinsics.areEqual(this.modifiedDate, webLinkModel.modifiedDate) && Intrinsics.areEqual(this.contentModifiedDate, webLinkModel.contentModifiedDate) && this.isRooted == webLinkModel.isRooted && Intrinsics.areEqual(this.permissions, webLinkModel.permissions) && Intrinsics.areEqual(this.pathCollection, webLinkModel.pathCollection) && Intrinsics.areEqual(this.url, webLinkModel.url) && Intrinsics.areEqual(this.sharedLink, webLinkModel.sharedLink) && Intrinsics.areEqual(this.collections, webLinkModel.collections) && Intrinsics.areEqual(this.description, webLinkModel.description);
    }

    public int hashCode() {
        int iHashCode = ((((((this.itemId.hashCode() * 31) + this.name.hashCode()) * 31) + Boolean.hashCode(this.hasCollaborations)) * 31) + Boolean.hashCode(this.isExternallyOwned)) * 31;
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
        int iHashCode8 = (((iHashCode7 + (date4 == null ? 0 : date4.hashCode())) * 31) + Boolean.hashCode(this.isRooted)) * 31;
        PermissionsModel permissionsModel = this.permissions;
        int iHashCode9 = (iHashCode8 + (permissionsModel == null ? 0 : permissionsModel.hashCode())) * 31;
        List<PathCollectionEntry> list = this.pathCollection;
        int iHashCode10 = (iHashCode9 + (list == null ? 0 : list.hashCode())) * 31;
        String str = this.url;
        int iHashCode11 = (iHashCode10 + (str == null ? 0 : str.hashCode())) * 31;
        SharedLinkModel sharedLinkModel = this.sharedLink;
        int iHashCode12 = (iHashCode11 + (sharedLinkModel == null ? 0 : sharedLinkModel.hashCode())) * 31;
        List<CollectionModel> list2 = this.collections;
        int iHashCode13 = (iHashCode12 + (list2 == null ? 0 : list2.hashCode())) * 31;
        String str2 = this.description;
        return iHashCode13 + (str2 != null ? str2.hashCode() : 0);
    }

    public String toString() {
        return "WebLinkModel(itemId=" + this.itemId + ", name=" + this.name + ", hasCollaborations=" + this.hasCollaborations + ", isExternallyOwned=" + this.isExternallyOwned + ", parentFolder=" + this.parentFolder + ", owner=" + this.owner + ", updatedBy=" + this.updatedBy + ", createdDate=" + this.createdDate + ", contentCreatedDate=" + this.contentCreatedDate + ", modifiedDate=" + this.modifiedDate + ", contentModifiedDate=" + this.contentModifiedDate + ", isRooted=" + this.isRooted + ", permissions=" + this.permissions + ", pathCollection=" + this.pathCollection + ", url=" + this.url + ", sharedLink=" + this.sharedLink + ", collections=" + this.collections + ", description=" + this.description + ")";
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel dest, int flags) {
        Intrinsics.checkNotNullParameter(dest, "dest");
        dest.writeParcelable(this.itemId, flags);
        dest.writeString(this.name);
        dest.writeInt(this.hasCollaborations ? 1 : 0);
        dest.writeInt(this.isExternallyOwned ? 1 : 0);
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
        dest.writeString(this.url);
        SharedLinkModel sharedLinkModel = this.sharedLink;
        if (sharedLinkModel == null) {
            dest.writeInt(0);
        } else {
            dest.writeInt(1);
            sharedLinkModel.writeToParcel(dest, flags);
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
        dest.writeString(this.description);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WebLinkModel(ItemId itemId, String name, boolean z, boolean z2, FolderModel folderModel, UserModel userModel, UserModel userModel2, Date date, Date date2, Date date3, Date date4, boolean z3, PermissionsModel permissionsModel, List<PathCollectionEntry> list, String str, SharedLinkModel sharedLinkModel, List<CollectionModel> list2, String str2) {
        super(null);
        Intrinsics.checkNotNullParameter(itemId, "itemId");
        Intrinsics.checkNotNullParameter(name, "name");
        this.itemId = itemId;
        this.name = name;
        this.hasCollaborations = z;
        this.isExternallyOwned = z2;
        this.parentFolder = folderModel;
        this.owner = userModel;
        this.updatedBy = userModel2;
        this.createdDate = date;
        this.contentCreatedDate = date2;
        this.modifiedDate = date3;
        this.contentModifiedDate = date4;
        this.isRooted = z3;
        this.permissions = permissionsModel;
        this.pathCollection = list;
        this.url = str;
        this.sharedLink = sharedLinkModel;
        this.collections = list2;
        this.description = str2;
    }

    public /* synthetic */ WebLinkModel(ItemId itemId, String str, boolean z, boolean z2, FolderModel folderModel, UserModel userModel, UserModel userModel2, Date date, Date date2, Date date3, Date date4, boolean z3, PermissionsModel permissionsModel, List list, String str2, SharedLinkModel sharedLinkModel, List list2, String str3, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(itemId, str, z, z2, (i & 16) != 0 ? null : folderModel, userModel, userModel2, date, (i & 256) != 0 ? null : date2, date3, (i & 1024) != 0 ? null : date4, z3, permissionsModel, list, str2, sharedLinkModel, list2, (i & 131072) != 0 ? null : str3);
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
    public boolean getHasCollaborations() {
        return this.hasCollaborations;
    }

    @Override // com.box.android.domain.models.item.ItemModel
    public boolean isExternallyOwned() {
        return this.isExternallyOwned;
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
    public PermissionsModel getPermissions() {
        return this.permissions;
    }

    @Override // com.box.android.domain.models.item.ItemModel
    public List<PathCollectionEntry> getPathCollection() {
        return this.pathCollection;
    }

    public final String getUrl() {
        return this.url;
    }

    @Override // com.box.android.domain.models.item.ItemModel
    public SharedLinkModel getSharedLink() {
        return this.sharedLink;
    }

    @Override // com.box.android.domain.models.item.ItemModel
    public List<CollectionModel> getCollections() {
        return this.collections;
    }

    @Override // com.box.android.domain.models.item.ItemModel
    public String getDescription() {
        return this.description;
    }

    /* JADX INFO: compiled from: WebLinkModel.kt */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007¨\u0006\b"}, d2 = {"Lcom/box/android/domain/models/item/WebLinkModel$Companion;", "", "<init>", "()V", "createItemId", "Lcom/box/android/domain/models/ItemId;", "id", "", "domain_prodRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final ItemId createItemId(String id) {
            Intrinsics.checkNotNullParameter(id, "id");
            try {
                return ItemId.INSTANCE.create(id);
            } catch (Exception unused) {
                return new ItemId.Remote(id, ItemType.WEBLINK);
            }
        }
    }

    @Override // com.box.android.domain.models.item.ItemModel
    public Long getSize() {
        return Long.valueOf(this.size);
    }
}
