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
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: FolderModel.kt */
/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000~\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b&\n\u0002\u0018\u0002\n\u0002\b\u001a\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0087\b\u0018\u0000 l2\u00020\u0001:\u0001lBÏ\u0001\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\u0007\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0000\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u000b\u0012\b\u0010\f\u001a\u0004\u0018\u00010\u000b\u0012\b\u0010\r\u001a\u0004\u0018\u00010\u000e\u0012\b\u0010\u000f\u001a\u0004\u0018\u00010\u000e\u0012\b\u0010\u0010\u001a\u0004\u0018\u00010\u000e\u0012\b\u0010\u0011\u001a\u0004\u0018\u00010\u000e\u0012\u0006\u0010\u0012\u001a\u00020\u0007\u0012\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u0014\u0012\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016\u0012\u000e\u0010\u0017\u001a\n\u0012\u0004\u0012\u00020\u0019\u0018\u00010\u0018\u0012\u000e\u0010\u001a\u001a\n\u0012\u0004\u0012\u00020\u001b\u0018\u00010\u0018\u0012\b\u0010\u001c\u001a\u0004\u0018\u00010\u001d\u0012\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\u001f\u0012\n\b\u0002\u0010 \u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b!\u0010\"J\t\u0010K\u001a\u00020\u0003HÆ\u0003J\t\u0010L\u001a\u00020\u0005HÆ\u0003J\t\u0010M\u001a\u00020\u0007HÆ\u0003J\t\u0010N\u001a\u00020\u0007HÆ\u0003J\u000b\u0010O\u001a\u0004\u0018\u00010\u0000HÆ\u0003J\u000b\u0010P\u001a\u0004\u0018\u00010\u000bHÆ\u0003J\u000b\u0010Q\u001a\u0004\u0018\u00010\u000bHÆ\u0003J\u000b\u0010R\u001a\u0004\u0018\u00010\u000eHÆ\u0003J\u000b\u0010S\u001a\u0004\u0018\u00010\u000eHÆ\u0003J\u000b\u0010T\u001a\u0004\u0018\u00010\u000eHÆ\u0003J\u000b\u0010U\u001a\u0004\u0018\u00010\u000eHÆ\u0003J\t\u0010V\u001a\u00020\u0007HÆ\u0003J\u0010\u0010W\u001a\u0004\u0018\u00010\u0014HÆ\u0003¢\u0006\u0002\u00104J\u000b\u0010X\u001a\u0004\u0018\u00010\u0016HÆ\u0003J\u0011\u0010Y\u001a\n\u0012\u0004\u0012\u00020\u0019\u0018\u00010\u0018HÆ\u0003J\u0011\u0010Z\u001a\n\u0012\u0004\u0012\u00020\u001b\u0018\u00010\u0018HÆ\u0003J\u000b\u0010[\u001a\u0004\u0018\u00010\u001dHÆ\u0003J\u000b\u0010\\\u001a\u0004\u0018\u00010\u001fHÆ\u0003J\u000b\u0010]\u001a\u0004\u0018\u00010\u0005HÆ\u0003Jô\u0001\u0010^\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\u00072\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00002\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u000b2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000e2\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u000e2\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u000e2\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u000e2\b\b\u0002\u0010\u0012\u001a\u00020\u00072\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u00142\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u00162\u0010\b\u0002\u0010\u0017\u001a\n\u0012\u0004\u0012\u00020\u0019\u0018\u00010\u00182\u0010\b\u0002\u0010\u001a\u001a\n\u0012\u0004\u0012\u00020\u001b\u0018\u00010\u00182\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\u001d2\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\u001f2\n\b\u0002\u0010 \u001a\u0004\u0018\u00010\u0005HÆ\u0001¢\u0006\u0002\u0010_J\u0006\u0010`\u001a\u00020aJ\u0013\u0010b\u001a\u00020\u00072\b\u0010c\u001a\u0004\u0018\u00010dHÖ\u0003J\t\u0010e\u001a\u00020aHÖ\u0001J\t\u0010f\u001a\u00020\u0005HÖ\u0001J\u0016\u0010g\u001a\u00020h2\u0006\u0010i\u001a\u00020j2\u0006\u0010k\u001a\u00020aR\u0014\u0010\u0002\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b#\u0010$R\u0014\u0010\u0004\u001a\u00020\u0005X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b%\u0010&R\u0014\u0010\u0006\u001a\u00020\u0007X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b'\u0010(R\u0014\u0010\b\u001a\u00020\u0007X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010(R\u0016\u0010\t\u001a\u0004\u0018\u00010\u0000X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b)\u0010*R\u0016\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b+\u0010,R\u0016\u0010\f\u001a\u0004\u0018\u00010\u000bX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b-\u0010,R\u0016\u0010\r\u001a\u0004\u0018\u00010\u000eX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b.\u0010/R\u0016\u0010\u000f\u001a\u0004\u0018\u00010\u000eX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b0\u0010/R\u0016\u0010\u0010\u001a\u0004\u0018\u00010\u000eX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b1\u0010/R\u0016\u0010\u0011\u001a\u0004\u0018\u00010\u000eX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b2\u0010/R\u0014\u0010\u0012\u001a\u00020\u0007X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010(R\u0018\u0010\u0013\u001a\u0004\u0018\u00010\u0014X\u0096\u0004¢\u0006\n\n\u0002\u00105\u001a\u0004\b3\u00104R\u0016\u0010\u0015\u001a\u0004\u0018\u00010\u0016X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b6\u00107R\u001c\u0010\u0017\u001a\n\u0012\u0004\u0012\u00020\u0019\u0018\u00010\u0018X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b8\u00109R\u001c\u0010\u001a\u001a\n\u0012\u0004\u0012\u00020\u001b\u0018\u00010\u0018X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b:\u00109R\u0016\u0010\u001c\u001a\u0004\u0018\u00010\u001dX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b;\u0010<R\u0013\u0010\u001e\u001a\u0004\u0018\u00010\u001f¢\u0006\b\n\u0000\u001a\u0004\b=\u0010>R\u0016\u0010 \u001a\u0004\u0018\u00010\u0005X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b?\u0010&R!\u0010@\u001a\u00020\u00078FX\u0086\u0084\u0002¢\u0006\u0012\n\u0004\bC\u0010D\u0012\u0004\bA\u0010B\u001a\u0004\b@\u0010(R!\u0010E\u001a\u00020F8FX\u0086\u0084\u0002¢\u0006\u0012\n\u0004\bJ\u0010D\u0012\u0004\bG\u0010B\u001a\u0004\bH\u0010I¨\u0006m"}, d2 = {"Lcom/box/android/domain/models/item/FolderModel;", "Lcom/box/android/domain/models/item/ItemModel;", "itemId", "Lcom/box/android/domain/models/ItemId;", "name", "", "hasCollaborations", "", "isExternallyOwned", "parentFolder", "owner", "Lcom/box/android/domain/models/item/UserModel;", "updatedBy", "createdDate", "Ljava/util/Date;", "contentCreatedDate", "modifiedDate", "contentModifiedDate", "isRooted", "size", "", "permissions", "Lcom/box/android/domain/models/item/PermissionsModel;", "pathCollection", "", "Lcom/box/android/domain/models/item/PathCollectionEntry;", BoxItem.FIELD_COLLECTIONS, "Lcom/box/android/domain/models/CollectionModel;", BoxNoteConstants.NOTES_BUILDER_SHARED_LINK, "Lcom/box/android/domain/models/item/SharedLinkModel;", "watermark", "Lcom/box/android/domain/models/item/WatermarkModel;", "description", "<init>", "(Lcom/box/android/domain/models/ItemId;Ljava/lang/String;ZZLcom/box/android/domain/models/item/FolderModel;Lcom/box/android/domain/models/item/UserModel;Lcom/box/android/domain/models/item/UserModel;Ljava/util/Date;Ljava/util/Date;Ljava/util/Date;Ljava/util/Date;ZLjava/lang/Long;Lcom/box/android/domain/models/item/PermissionsModel;Ljava/util/List;Ljava/util/List;Lcom/box/android/domain/models/item/SharedLinkModel;Lcom/box/android/domain/models/item/WatermarkModel;Ljava/lang/String;)V", "getItemId", "()Lcom/box/android/domain/models/ItemId;", "getName", "()Ljava/lang/String;", "getHasCollaborations", "()Z", "getParentFolder", "()Lcom/box/android/domain/models/item/FolderModel;", "getOwner", "()Lcom/box/android/domain/models/item/UserModel;", "getUpdatedBy", "getCreatedDate", "()Ljava/util/Date;", "getContentCreatedDate", "getModifiedDate", "getContentModifiedDate", "getSize", "()Ljava/lang/Long;", "Ljava/lang/Long;", "getPermissions", "()Lcom/box/android/domain/models/item/PermissionsModel;", "getPathCollection", "()Ljava/util/List;", "getCollections", "getSharedLink", "()Lcom/box/android/domain/models/item/SharedLinkModel;", "getWatermark", "()Lcom/box/android/domain/models/item/WatermarkModel;", "getDescription", "isRoot", "isRoot$annotations", "()V", "isRoot$delegate", "Lkotlin/Lazy;", "folderType", "Lcom/box/android/domain/models/item/FolderType;", "getFolderType$annotations", "getFolderType", "()Lcom/box/android/domain/models/item/FolderType;", "folderType$delegate", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "component17", "component18", "component19", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "(Lcom/box/android/domain/models/ItemId;Ljava/lang/String;ZZLcom/box/android/domain/models/item/FolderModel;Lcom/box/android/domain/models/item/UserModel;Lcom/box/android/domain/models/item/UserModel;Ljava/util/Date;Ljava/util/Date;Ljava/util/Date;Ljava/util/Date;ZLjava/lang/Long;Lcom/box/android/domain/models/item/PermissionsModel;Ljava/util/List;Ljava/util/List;Lcom/box/android/domain/models/item/SharedLinkModel;Lcom/box/android/domain/models/item/WatermarkModel;Ljava/lang/String;)Lcom/box/android/domain/models/item/FolderModel;", "describeContents", "", "equals", "other", "", "hashCode", "toString", "writeToParcel", "", "dest", "Landroid/os/Parcel;", "flags", "Companion", "domain_prodRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final /* data */ class FolderModel extends ItemModel {
    private final List<CollectionModel> collections;
    private final Date contentCreatedDate;
    private final Date contentModifiedDate;
    private final Date createdDate;
    private final String description;

    /* JADX INFO: renamed from: folderType$delegate, reason: from kotlin metadata */
    private final Lazy folderType;
    private final boolean hasCollaborations;
    private final boolean isExternallyOwned;

    /* JADX INFO: renamed from: isRoot$delegate, reason: from kotlin metadata */
    private final Lazy isRoot;
    private final boolean isRooted;
    private final ItemId itemId;
    private final Date modifiedDate;
    private final String name;
    private final UserModel owner;
    private final FolderModel parentFolder;
    private final List<PathCollectionEntry> pathCollection;
    private final PermissionsModel permissions;
    private final SharedLinkModel sharedLink;
    private final Long size;
    private final UserModel updatedBy;
    private final WatermarkModel watermark;

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public static final Parcelable.Creator<FolderModel> CREATOR = new Creator();

    /* JADX INFO: compiled from: FolderModel.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    public static final class Creator implements Parcelable.Creator<FolderModel> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final FolderModel createFromParcel(Parcel parcel) {
            ArrayList arrayList;
            ArrayList arrayList2;
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            ItemId itemId = (ItemId) parcel.readParcelable(FolderModel.class.getClassLoader());
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
            Long lValueOf = parcel.readInt() == 0 ? null : Long.valueOf(parcel.readLong());
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
            return new FolderModel(itemId, string, z, z2, folderModelCreateFromParcel, userModelCreateFromParcel, userModelCreateFromParcel2, date, date2, date3, date4, z3, lValueOf, permissionsModelCreateFromParcel, arrayList3, arrayList2, parcel.readInt() == 0 ? null : SharedLinkModel.CREATOR.createFromParcel(parcel), parcel.readInt() == 0 ? null : WatermarkModel.CREATOR.createFromParcel(parcel), parcel.readString());
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final FolderModel[] newArray(int i) {
            return new FolderModel[i];
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ FolderModel copy$default(FolderModel folderModel, ItemId itemId, String str, boolean z, boolean z2, FolderModel folderModel2, UserModel userModel, UserModel userModel2, Date date, Date date2, Date date3, Date date4, boolean z3, Long l, PermissionsModel permissionsModel, List list, List list2, SharedLinkModel sharedLinkModel, WatermarkModel watermarkModel, String str2, int i, Object obj) {
        String str3;
        WatermarkModel watermarkModel2;
        ItemId itemId2 = (i & 1) != 0 ? folderModel.itemId : itemId;
        String str4 = (i & 2) != 0 ? folderModel.name : str;
        boolean z4 = (i & 4) != 0 ? folderModel.hasCollaborations : z;
        boolean z5 = (i & 8) != 0 ? folderModel.isExternallyOwned : z2;
        FolderModel folderModel3 = (i & 16) != 0 ? folderModel.parentFolder : folderModel2;
        UserModel userModel3 = (i & 32) != 0 ? folderModel.owner : userModel;
        UserModel userModel4 = (i & 64) != 0 ? folderModel.updatedBy : userModel2;
        Date date5 = (i & 128) != 0 ? folderModel.createdDate : date;
        Date date6 = (i & 256) != 0 ? folderModel.contentCreatedDate : date2;
        Date date7 = (i & 512) != 0 ? folderModel.modifiedDate : date3;
        Date date8 = (i & 1024) != 0 ? folderModel.contentModifiedDate : date4;
        boolean z6 = (i & 2048) != 0 ? folderModel.isRooted : z3;
        Long l2 = (i & 4096) != 0 ? folderModel.size : l;
        PermissionsModel permissionsModel2 = (i & 8192) != 0 ? folderModel.permissions : permissionsModel;
        ItemId itemId3 = itemId2;
        List list3 = (i & 16384) != 0 ? folderModel.pathCollection : list;
        List list4 = (i & 32768) != 0 ? folderModel.collections : list2;
        SharedLinkModel sharedLinkModel2 = (i & 65536) != 0 ? folderModel.sharedLink : sharedLinkModel;
        WatermarkModel watermarkModel3 = (i & 131072) != 0 ? folderModel.watermark : watermarkModel;
        if ((i & 262144) != 0) {
            watermarkModel2 = watermarkModel3;
            str3 = folderModel.description;
        } else {
            str3 = str2;
            watermarkModel2 = watermarkModel3;
        }
        return folderModel.copy(itemId3, str4, z4, z5, folderModel3, userModel3, userModel4, date5, date6, date7, date8, z6, l2, permissionsModel2, list3, list4, sharedLinkModel2, watermarkModel2, str3);
    }

    public static /* synthetic */ void getFolderType$annotations() {
    }

    public static /* synthetic */ void isRoot$annotations() {
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
    public final Long getSize() {
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
    public final WatermarkModel getWatermark() {
        return this.watermark;
    }

    /* JADX INFO: renamed from: component19, reason: from getter */
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

    public final FolderModel copy(ItemId itemId, String name, boolean hasCollaborations, boolean isExternallyOwned, FolderModel parentFolder, UserModel owner, UserModel updatedBy, Date createdDate, Date contentCreatedDate, Date modifiedDate, Date contentModifiedDate, boolean isRooted, Long size, PermissionsModel permissions, List<PathCollectionEntry> pathCollection, List<CollectionModel> collections, SharedLinkModel sharedLink, WatermarkModel watermark, String description) {
        Intrinsics.checkNotNullParameter(itemId, "itemId");
        Intrinsics.checkNotNullParameter(name, "name");
        return new FolderModel(itemId, name, hasCollaborations, isExternallyOwned, parentFolder, owner, updatedBy, createdDate, contentCreatedDate, modifiedDate, contentModifiedDate, isRooted, size, permissions, pathCollection, collections, sharedLink, watermark, description);
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof FolderModel)) {
            return false;
        }
        FolderModel folderModel = (FolderModel) other;
        return Intrinsics.areEqual(this.itemId, folderModel.itemId) && Intrinsics.areEqual(this.name, folderModel.name) && this.hasCollaborations == folderModel.hasCollaborations && this.isExternallyOwned == folderModel.isExternallyOwned && Intrinsics.areEqual(this.parentFolder, folderModel.parentFolder) && Intrinsics.areEqual(this.owner, folderModel.owner) && Intrinsics.areEqual(this.updatedBy, folderModel.updatedBy) && Intrinsics.areEqual(this.createdDate, folderModel.createdDate) && Intrinsics.areEqual(this.contentCreatedDate, folderModel.contentCreatedDate) && Intrinsics.areEqual(this.modifiedDate, folderModel.modifiedDate) && Intrinsics.areEqual(this.contentModifiedDate, folderModel.contentModifiedDate) && this.isRooted == folderModel.isRooted && Intrinsics.areEqual(this.size, folderModel.size) && Intrinsics.areEqual(this.permissions, folderModel.permissions) && Intrinsics.areEqual(this.pathCollection, folderModel.pathCollection) && Intrinsics.areEqual(this.collections, folderModel.collections) && Intrinsics.areEqual(this.sharedLink, folderModel.sharedLink) && Intrinsics.areEqual(this.watermark, folderModel.watermark) && Intrinsics.areEqual(this.description, folderModel.description);
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
        Long l = this.size;
        int iHashCode9 = (iHashCode8 + (l == null ? 0 : l.hashCode())) * 31;
        PermissionsModel permissionsModel = this.permissions;
        int iHashCode10 = (iHashCode9 + (permissionsModel == null ? 0 : permissionsModel.hashCode())) * 31;
        List<PathCollectionEntry> list = this.pathCollection;
        int iHashCode11 = (iHashCode10 + (list == null ? 0 : list.hashCode())) * 31;
        List<CollectionModel> list2 = this.collections;
        int iHashCode12 = (iHashCode11 + (list2 == null ? 0 : list2.hashCode())) * 31;
        SharedLinkModel sharedLinkModel = this.sharedLink;
        int iHashCode13 = (iHashCode12 + (sharedLinkModel == null ? 0 : sharedLinkModel.hashCode())) * 31;
        WatermarkModel watermarkModel = this.watermark;
        int iHashCode14 = (iHashCode13 + (watermarkModel == null ? 0 : watermarkModel.hashCode())) * 31;
        String str = this.description;
        return iHashCode14 + (str != null ? str.hashCode() : 0);
    }

    public String toString() {
        return "FolderModel(itemId=" + this.itemId + ", name=" + this.name + ", hasCollaborations=" + this.hasCollaborations + ", isExternallyOwned=" + this.isExternallyOwned + ", parentFolder=" + this.parentFolder + ", owner=" + this.owner + ", updatedBy=" + this.updatedBy + ", createdDate=" + this.createdDate + ", contentCreatedDate=" + this.contentCreatedDate + ", modifiedDate=" + this.modifiedDate + ", contentModifiedDate=" + this.contentModifiedDate + ", isRooted=" + this.isRooted + ", size=" + this.size + ", permissions=" + this.permissions + ", pathCollection=" + this.pathCollection + ", collections=" + this.collections + ", sharedLink=" + this.sharedLink + ", watermark=" + this.watermark + ", description=" + this.description + ")";
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
        Long l = this.size;
        if (l == null) {
            dest.writeInt(0);
        } else {
            dest.writeInt(1);
            dest.writeLong(l.longValue());
        }
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
        WatermarkModel watermarkModel = this.watermark;
        if (watermarkModel == null) {
            dest.writeInt(0);
        } else {
            dest.writeInt(1);
            watermarkModel.writeToParcel(dest, flags);
        }
        dest.writeString(this.description);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FolderModel(ItemId itemId, String name, boolean z, boolean z2, FolderModel folderModel, UserModel userModel, UserModel userModel2, Date date, Date date2, Date date3, Date date4, boolean z3, Long l, PermissionsModel permissionsModel, List<PathCollectionEntry> list, List<CollectionModel> list2, SharedLinkModel sharedLinkModel, WatermarkModel watermarkModel, String str) {
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
        this.size = l;
        this.permissions = permissionsModel;
        this.pathCollection = list;
        this.collections = list2;
        this.sharedLink = sharedLinkModel;
        this.watermark = watermarkModel;
        this.description = str;
        this.isRoot = LazyKt.lazy(new Function0() { // from class: com.box.android.domain.models.item.FolderModel$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return Boolean.valueOf(FolderModel.isRoot_delegate$lambda$0(this.f$0));
            }
        });
        this.folderType = LazyKt.lazy(new Function0() { // from class: com.box.android.domain.models.item.FolderModel$$ExternalSyntheticLambda1
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return FolderModel.folderType_delegate$lambda$0(this.f$0);
            }
        });
    }

    public /* synthetic */ FolderModel(ItemId itemId, String str, boolean z, boolean z2, FolderModel folderModel, UserModel userModel, UserModel userModel2, Date date, Date date2, Date date3, Date date4, boolean z3, Long l, PermissionsModel permissionsModel, List list, List list2, SharedLinkModel sharedLinkModel, WatermarkModel watermarkModel, String str2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(itemId, str, z, z2, (i & 16) != 0 ? null : folderModel, userModel, userModel2, date, date2, date3, date4, z3, (i & 4096) != 0 ? null : l, permissionsModel, list, list2, sharedLinkModel, (131072 & i) != 0 ? null : watermarkModel, (i & 262144) != 0 ? null : str2);
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
    public Long getSize() {
        return this.size;
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

    public final WatermarkModel getWatermark() {
        return this.watermark;
    }

    @Override // com.box.android.domain.models.item.ItemModel
    public String getDescription() {
        return this.description;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean isRoot_delegate$lambda$0(FolderModel folderModel) {
        return Intrinsics.areEqual(folderModel.getItemId(), ItemId.INSTANCE.getROOT_ITEM_ID());
    }

    public final boolean isRoot() {
        return ((Boolean) this.isRoot.getValue()).booleanValue();
    }

    public final FolderType getFolderType() {
        return (FolderType) this.folderType.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final FolderType folderType_delegate$lambda$0(FolderModel folderModel) {
        if (folderModel.isExternallyOwned()) {
            return FolderType.EXTERNAL;
        }
        return folderModel.getHasCollaborations() ? FolderType.COLLABORATED : FolderType.PERSONAL;
    }

    /* JADX INFO: compiled from: FolderModel.kt */
    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007J\u0018\u0010\b\u001a\u00020\t2\u0006\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\n\u001a\u00020\u0007¨\u0006\u000b"}, d2 = {"Lcom/box/android/domain/models/item/FolderModel$Companion;", "", "<init>", "()V", "createItemId", "Lcom/box/android/domain/models/ItemId;", "id", "", "createFromId", "Lcom/box/android/domain/models/item/FolderModel;", "name", "domain_prodRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
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
                return new ItemId.Remote(id, ItemType.FOLDER);
            }
        }

        public static /* synthetic */ FolderModel createFromId$default(Companion companion, String str, String str2, int i, Object obj) {
            if ((i & 2) != 0) {
                str2 = "";
            }
            return companion.createFromId(str, str2);
        }

        public final FolderModel createFromId(String id, String name) {
            Intrinsics.checkNotNullParameter(id, "id");
            Intrinsics.checkNotNullParameter(name, "name");
            return new FolderModel(createItemId(id), name, false, false, null, null, null, null, null, null, null, false, null, null, null, null, null, null, null, 131072, null);
        }
    }
}
