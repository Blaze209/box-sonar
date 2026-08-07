package com.box.android.base.cpl;

import com.box.android.domain.analytics.BoxAmplitudeAnalytics;
import com.box.android.domain.models.hubs.HubAssetModel;
import com.box.android.domain.models.item.ItemModel;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: ItemThumbnailReducer.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b7\u0018\u00002\u00020\u0001:\u0002\u0004\u0005B\t\b\u0004¢\u0006\u0004\b\u0002\u0010\u0003\u0082\u0001\u0002\u0006\u0007¨\u0006\b"}, d2 = {"Lcom/box/android/base/cpl/ThumbnailSource;", "", "<init>", "()V", "Item", "HubAsset", "Lcom/box/android/base/cpl/ThumbnailSource$HubAsset;", "Lcom/box/android/base/cpl/ThumbnailSource$Item;", "base_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public abstract class ThumbnailSource {
    public static final int $stable = 0;

    public /* synthetic */ ThumbnailSource(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    /* JADX INFO: compiled from: ItemThumbnailReducer.kt */
    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\n\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u0019\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\t\u0010\f\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\r\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000e\u001a\u00020\u00052\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010HÖ\u0003J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0004\u0010\n¨\u0006\u0015"}, d2 = {"Lcom/box/android/base/cpl/ThumbnailSource$Item;", "Lcom/box/android/base/cpl/ThumbnailSource;", "itemModel", "Lcom/box/android/domain/models/item/ItemModel;", "isBigThumbnailNeeded", "", "<init>", "(Lcom/box/android/domain/models/item/ItemModel;Z)V", "getItemModel", "()Lcom/box/android/domain/models/item/ItemModel;", "()Z", "component1", "component2", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "other", "", "hashCode", "", "toString", "", "base_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final /* data */ class Item extends ThumbnailSource {
        public static final int $stable = 8;
        private final boolean isBigThumbnailNeeded;
        private final ItemModel itemModel;

        public static /* synthetic */ Item copy$default(Item item, ItemModel itemModel, boolean z, int i, Object obj) {
            if ((i & 1) != 0) {
                itemModel = item.itemModel;
            }
            if ((i & 2) != 0) {
                z = item.isBigThumbnailNeeded;
            }
            return item.copy(itemModel, z);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final ItemModel getItemModel() {
            return this.itemModel;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final boolean getIsBigThumbnailNeeded() {
            return this.isBigThumbnailNeeded;
        }

        public final Item copy(ItemModel itemModel, boolean isBigThumbnailNeeded) {
            Intrinsics.checkNotNullParameter(itemModel, "itemModel");
            return new Item(itemModel, isBigThumbnailNeeded);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Item)) {
                return false;
            }
            Item item = (Item) other;
            return Intrinsics.areEqual(this.itemModel, item.itemModel) && this.isBigThumbnailNeeded == item.isBigThumbnailNeeded;
        }

        public int hashCode() {
            return (this.itemModel.hashCode() * 31) + Boolean.hashCode(this.isBigThumbnailNeeded);
        }

        public String toString() {
            return "Item(itemModel=" + this.itemModel + ", isBigThumbnailNeeded=" + this.isBigThumbnailNeeded + ")";
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public Item(ItemModel itemModel, boolean z) {
            super(null);
            Intrinsics.checkNotNullParameter(itemModel, "itemModel");
            this.itemModel = itemModel;
            this.isBigThumbnailNeeded = z;
        }

        public /* synthetic */ Item(ItemModel itemModel, boolean z, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this(itemModel, (i & 2) != 0 ? false : z);
        }

        public final ItemModel getItemModel() {
            return this.itemModel;
        }

        public final boolean isBigThumbnailNeeded() {
            return this.isBigThumbnailNeeded;
        }
    }

    private ThumbnailSource() {
    }

    /* JADX INFO: compiled from: ItemThumbnailReducer.kt */
    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0003J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0012"}, d2 = {"Lcom/box/android/base/cpl/ThumbnailSource$HubAsset;", "Lcom/box/android/base/cpl/ThumbnailSource;", "hubAssetModel", "Lcom/box/android/domain/models/hubs/HubAssetModel;", "<init>", "(Lcom/box/android/domain/models/hubs/HubAssetModel;)V", "getHubAssetModel", "()Lcom/box/android/domain/models/hubs/HubAssetModel;", "component1", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "", "other", "", "hashCode", "", "toString", "", "base_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final /* data */ class HubAsset extends ThumbnailSource {
        public static final int $stable = 8;
        private final HubAssetModel hubAssetModel;

        public static /* synthetic */ HubAsset copy$default(HubAsset hubAsset, HubAssetModel hubAssetModel, int i, Object obj) {
            if ((i & 1) != 0) {
                hubAssetModel = hubAsset.hubAssetModel;
            }
            return hubAsset.copy(hubAssetModel);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final HubAssetModel getHubAssetModel() {
            return this.hubAssetModel;
        }

        public final HubAsset copy(HubAssetModel hubAssetModel) {
            Intrinsics.checkNotNullParameter(hubAssetModel, "hubAssetModel");
            return new HubAsset(hubAssetModel);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            return (other instanceof HubAsset) && Intrinsics.areEqual(this.hubAssetModel, ((HubAsset) other).hubAssetModel);
        }

        public int hashCode() {
            return this.hubAssetModel.hashCode();
        }

        public String toString() {
            return "HubAsset(hubAssetModel=" + this.hubAssetModel + ")";
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public HubAsset(HubAssetModel hubAssetModel) {
            super(null);
            Intrinsics.checkNotNullParameter(hubAssetModel, "hubAssetModel");
            this.hubAssetModel = hubAssetModel;
        }

        public final HubAssetModel getHubAssetModel() {
            return this.hubAssetModel;
        }
    }
}
