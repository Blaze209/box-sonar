package com.box.android.domain.models;

import android.net.Uri;
import com.box.android.domain.analytics.BoxAmplitudeAnalytics;
import com.box.android.domain.mappers.FolderModelMapper;
import com.box.android.domain.mappers.ItemModelMapper;
import com.box.android.domain.models.item.FolderModel;
import com.box.android.domain.models.item.ItemModel;
import com.box.androidsdk.content.models.BoxFolder;
import com.box.androidsdk.content.utils.BoxItemUtility;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: LegacyJobModel.kt */
/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0002\u0011\u0012B\t\b\u0004¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005J\u0006\u0010\u0006\u001a\u00020\u0007J\b\u0010\b\u001a\u0004\u0018\u00010\tJ\r\u0010\n\u001a\u0004\u0018\u00010\u000b¢\u0006\u0002\u0010\fJ\u0006\u0010\r\u001a\u00020\u000eJ\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010\u0082\u0001\u0002\u0013\u0014¨\u0006\u0015"}, d2 = {"Lcom/box/android/domain/models/ItemDescriptor;", "", "<init>", "()V", "getItemModelOrNull", "Lcom/box/android/domain/models/item/ItemModel;", "getItemName", "", "getUriOrNull", "Landroid/net/Uri;", "getItemSize", "", "()Ljava/lang/Long;", "isFolder", "", "getParent", "Lcom/box/android/domain/models/item/FolderModel;", "ExternalItem", "ExistingBoxItem", "Lcom/box/android/domain/models/ItemDescriptor$ExistingBoxItem;", "Lcom/box/android/domain/models/ItemDescriptor$ExternalItem;", "domain_prodRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public abstract class ItemDescriptor {
    public /* synthetic */ ItemDescriptor(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    /* JADX INFO: compiled from: LegacyJobModel.kt */
    @Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0015\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B3\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\b\u0010\b\u001a\u0004\u0018\u00010\t\u0012\u0006\u0010\n\u001a\u00020\u000b¢\u0006\u0004\b\f\u0010\rJ\t\u0010\u0018\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0019\u001a\u00020\u0005HÆ\u0003J\u0010\u0010\u001a\u001a\u0004\u0018\u00010\u0007HÆ\u0003¢\u0006\u0002\u0010\u0012J\u000b\u0010\u001b\u001a\u0004\u0018\u00010\tHÆ\u0003J\t\u0010\u001c\u001a\u00020\u000bHÆ\u0003JD\u0010\u001d\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t2\b\b\u0002\u0010\n\u001a\u00020\u000bHÆ\u0001¢\u0006\u0002\u0010\u001eJ\u0013\u0010\u001f\u001a\u00020\u00052\b\u0010 \u001a\u0004\u0018\u00010!HÖ\u0003J\t\u0010\"\u001a\u00020#HÖ\u0001J\t\u0010$\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0004\u0010\u0010R\u0015\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\n\n\u0002\u0010\u0013\u001a\u0004\b\u0011\u0010\u0012R\u0013\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0011\u0010\n\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017¨\u0006%"}, d2 = {"Lcom/box/android/domain/models/ItemDescriptor$ExternalItem;", "Lcom/box/android/domain/models/ItemDescriptor;", "name", "", "isFolderItem", "", "size", "", "parentFolder", "Lcom/box/android/domain/models/item/FolderModel;", "uri", "Landroid/net/Uri;", "<init>", "(Ljava/lang/String;ZLjava/lang/Long;Lcom/box/android/domain/models/item/FolderModel;Landroid/net/Uri;)V", "getName", "()Ljava/lang/String;", "()Z", "getSize", "()Ljava/lang/Long;", "Ljava/lang/Long;", "getParentFolder", "()Lcom/box/android/domain/models/item/FolderModel;", "getUri", "()Landroid/net/Uri;", "component1", "component2", "component3", "component4", "component5", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "(Ljava/lang/String;ZLjava/lang/Long;Lcom/box/android/domain/models/item/FolderModel;Landroid/net/Uri;)Lcom/box/android/domain/models/ItemDescriptor$ExternalItem;", "equals", "other", "", "hashCode", "", "toString", "domain_prodRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final /* data */ class ExternalItem extends ItemDescriptor {
        private final boolean isFolderItem;
        private final String name;
        private final FolderModel parentFolder;
        private final Long size;
        private final Uri uri;

        public static /* synthetic */ ExternalItem copy$default(ExternalItem externalItem, String str, boolean z, Long l, FolderModel folderModel, Uri uri, int i, Object obj) {
            if ((i & 1) != 0) {
                str = externalItem.name;
            }
            if ((i & 2) != 0) {
                z = externalItem.isFolderItem;
            }
            if ((i & 4) != 0) {
                l = externalItem.size;
            }
            if ((i & 8) != 0) {
                folderModel = externalItem.parentFolder;
            }
            if ((i & 16) != 0) {
                uri = externalItem.uri;
            }
            Uri uri2 = uri;
            Long l2 = l;
            return externalItem.copy(str, z, l2, folderModel, uri2);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final String getName() {
            return this.name;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final boolean getIsFolderItem() {
            return this.isFolderItem;
        }

        /* JADX INFO: renamed from: component3, reason: from getter */
        public final Long getSize() {
            return this.size;
        }

        /* JADX INFO: renamed from: component4, reason: from getter */
        public final FolderModel getParentFolder() {
            return this.parentFolder;
        }

        /* JADX INFO: renamed from: component5, reason: from getter */
        public final Uri getUri() {
            return this.uri;
        }

        public final ExternalItem copy(String name, boolean isFolderItem, Long size, FolderModel parentFolder, Uri uri) {
            Intrinsics.checkNotNullParameter(name, "name");
            Intrinsics.checkNotNullParameter(uri, "uri");
            return new ExternalItem(name, isFolderItem, size, parentFolder, uri);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof ExternalItem)) {
                return false;
            }
            ExternalItem externalItem = (ExternalItem) other;
            return Intrinsics.areEqual(this.name, externalItem.name) && this.isFolderItem == externalItem.isFolderItem && Intrinsics.areEqual(this.size, externalItem.size) && Intrinsics.areEqual(this.parentFolder, externalItem.parentFolder) && Intrinsics.areEqual(this.uri, externalItem.uri);
        }

        public int hashCode() {
            int iHashCode = ((this.name.hashCode() * 31) + Boolean.hashCode(this.isFolderItem)) * 31;
            Long l = this.size;
            int iHashCode2 = (iHashCode + (l == null ? 0 : l.hashCode())) * 31;
            FolderModel folderModel = this.parentFolder;
            return ((iHashCode2 + (folderModel != null ? folderModel.hashCode() : 0)) * 31) + this.uri.hashCode();
        }

        public String toString() {
            return "ExternalItem(name=" + this.name + ", isFolderItem=" + this.isFolderItem + ", size=" + this.size + ", parentFolder=" + this.parentFolder + ", uri=" + this.uri + ")";
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public ExternalItem(String name, boolean z, Long l, FolderModel folderModel, Uri uri) {
            super(null);
            Intrinsics.checkNotNullParameter(name, "name");
            Intrinsics.checkNotNullParameter(uri, "uri");
            this.name = name;
            this.isFolderItem = z;
            this.size = l;
            this.parentFolder = folderModel;
            this.uri = uri;
        }

        public final String getName() {
            return this.name;
        }

        public final boolean isFolderItem() {
            return this.isFolderItem;
        }

        public final Long getSize() {
            return this.size;
        }

        public final FolderModel getParentFolder() {
            return this.parentFolder;
        }

        public final Uri getUri() {
            return this.uri;
        }
    }

    private ItemDescriptor() {
    }

    /* JADX INFO: compiled from: LegacyJobModel.kt */
    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0003J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0012"}, d2 = {"Lcom/box/android/domain/models/ItemDescriptor$ExistingBoxItem;", "Lcom/box/android/domain/models/ItemDescriptor;", "itemModel", "Lcom/box/android/domain/models/item/ItemModel;", "<init>", "(Lcom/box/android/domain/models/item/ItemModel;)V", "getItemModel", "()Lcom/box/android/domain/models/item/ItemModel;", "component1", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "", "other", "", "hashCode", "", "toString", "", "domain_prodRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final /* data */ class ExistingBoxItem extends ItemDescriptor {
        private final ItemModel itemModel;

        public static /* synthetic */ ExistingBoxItem copy$default(ExistingBoxItem existingBoxItem, ItemModel itemModel, int i, Object obj) {
            if ((i & 1) != 0) {
                itemModel = existingBoxItem.itemModel;
            }
            return existingBoxItem.copy(itemModel);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final ItemModel getItemModel() {
            return this.itemModel;
        }

        public final ExistingBoxItem copy(ItemModel itemModel) {
            Intrinsics.checkNotNullParameter(itemModel, "itemModel");
            return new ExistingBoxItem(itemModel);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            return (other instanceof ExistingBoxItem) && Intrinsics.areEqual(this.itemModel, ((ExistingBoxItem) other).itemModel);
        }

        public int hashCode() {
            return this.itemModel.hashCode();
        }

        public String toString() {
            return "ExistingBoxItem(itemModel=" + this.itemModel + ")";
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public ExistingBoxItem(ItemModel itemModel) {
            super(null);
            Intrinsics.checkNotNullParameter(itemModel, "itemModel");
            this.itemModel = itemModel;
        }

        public final ItemModel getItemModel() {
            return this.itemModel;
        }
    }

    public final ItemModel getItemModelOrNull() {
        ExistingBoxItem existingBoxItem = this instanceof ExistingBoxItem ? (ExistingBoxItem) this : null;
        if (existingBoxItem != null) {
            return existingBoxItem.getItemModel();
        }
        return null;
    }

    public final String getItemName() {
        if (this instanceof ExternalItem) {
            return ((ExternalItem) this).getName();
        }
        if (this instanceof ExistingBoxItem) {
            return ((ExistingBoxItem) this).getItemModel().getName();
        }
        throw new NoWhenBranchMatchedException();
    }

    public final Uri getUriOrNull() {
        ExternalItem externalItem = this instanceof ExternalItem ? (ExternalItem) this : null;
        if (externalItem != null) {
            return externalItem.getUri();
        }
        return null;
    }

    public final Long getItemSize() {
        if (this instanceof ExternalItem) {
            return ((ExternalItem) this).getSize();
        }
        if (this instanceof ExistingBoxItem) {
            return ((ExistingBoxItem) this).getItemModel().getSize();
        }
        throw new NoWhenBranchMatchedException();
    }

    public final boolean isFolder() {
        if (this instanceof ExternalItem) {
            return ((ExternalItem) this).isFolderItem();
        }
        if (this instanceof ExistingBoxItem) {
            return ((ExistingBoxItem) this).getItemModel() instanceof FolderModel;
        }
        throw new NoWhenBranchMatchedException();
    }

    public final FolderModel getParent() {
        if (this instanceof ExternalItem) {
            return ((ExternalItem) this).getParentFolder();
        }
        if (!(this instanceof ExistingBoxItem)) {
            throw new NoWhenBranchMatchedException();
        }
        BoxFolder itemParentFolder = BoxItemUtility.getItemParentFolder(ItemModelMapper.toBoxItem$default(ItemModelMapper.INSTANCE, ((ExistingBoxItem) this).getItemModel(), false, 1, null));
        if (itemParentFolder != null) {
            return FolderModelMapper.toFolderModel$default(FolderModelMapper.INSTANCE, itemParentFolder, false, 1, null);
        }
        return null;
    }
}
