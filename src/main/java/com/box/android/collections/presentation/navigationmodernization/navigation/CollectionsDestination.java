package com.box.android.collections.presentation.navigationmodernization.navigation;

import com.box.android.base.presentation.fragments.models.BottomSheetAttributes;
import com.box.android.domain.analytics.BoxAmplitudeAnalytics;
import com.box.android.domain.models.CollectionModel;
import com.box.android.domain.models.item.ItemModel;
import com.box.android.domain.models.preview.PreviewSource;
import com.box.androidsdk.content.models.BoxCollection;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: CollectionsDestination.kt */
/* JADX INFO: loaded from: classes10.dex */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b7\u0018\u0000 \u00062\u00020\u0001:\u0003\u0004\u0005\u0006B\t\b\u0004¢\u0006\u0004\b\u0002\u0010\u0003\u0082\u0001\u0002\u0007\b¨\u0006\t"}, d2 = {"Lcom/box/android/collections/presentation/navigationmodernization/navigation/CollectionsDestination;", "", "<init>", "()V", "InnerDestination", "OuterDestination", "Companion", "Lcom/box/android/collections/presentation/navigationmodernization/navigation/CollectionsDestination$InnerDestination;", "Lcom/box/android/collections/presentation/navigationmodernization/navigation/CollectionsDestination$OuterDestination;", "collections_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public abstract class CollectionsDestination {
    public static final int $stable = 0;

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    public /* synthetic */ CollectionsDestination(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    private CollectionsDestination() {
    }

    /* JADX INFO: compiled from: CollectionsDestination.kt */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b7\u0018\u00002\u00020\u0001:\u0002\u0004\u0005B\t\b\u0004¢\u0006\u0004\b\u0002\u0010\u0003\u0082\u0001\u0002\u0006\u0007¨\u0006\b"}, d2 = {"Lcom/box/android/collections/presentation/navigationmodernization/navigation/CollectionsDestination$InnerDestination;", "Lcom/box/android/collections/presentation/navigationmodernization/navigation/CollectionsDestination;", "<init>", "()V", "Collections", "CollectionItemsList", "Lcom/box/android/collections/presentation/navigationmodernization/navigation/CollectionsDestination$InnerDestination$CollectionItemsList;", "Lcom/box/android/collections/presentation/navigationmodernization/navigation/CollectionsDestination$InnerDestination$Collections;", "collections_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static abstract class InnerDestination extends CollectionsDestination {
        public static final int $stable = 0;

        public /* synthetic */ InnerDestination(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* JADX INFO: compiled from: CollectionsDestination.kt */
        @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÇ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÖ\u0003J\t\u0010\b\u001a\u00020\tHÖ\u0001J\t\u0010\n\u001a\u00020\u000bHÖ\u0001¨\u0006\f"}, d2 = {"Lcom/box/android/collections/presentation/navigationmodernization/navigation/CollectionsDestination$InnerDestination$Collections;", "Lcom/box/android/collections/presentation/navigationmodernization/navigation/CollectionsDestination$InnerDestination;", "<init>", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "collections_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
        public static final /* data */ class Collections extends InnerDestination {
            public static final int $stable = 0;
            public static final Collections INSTANCE = new Collections();

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof Collections)) {
                    return false;
                }
                return true;
            }

            public int hashCode() {
                return -1319097149;
            }

            public String toString() {
                return "Collections";
            }

            private Collections() {
                super(null);
            }
        }

        private InnerDestination() {
            super(null);
        }

        /* JADX INFO: compiled from: CollectionsDestination.kt */
        @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0087\b\u0018\u0000 \u00122\u00020\u0001:\u0001\u0012B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0003J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0013"}, d2 = {"Lcom/box/android/collections/presentation/navigationmodernization/navigation/CollectionsDestination$InnerDestination$CollectionItemsList;", "Lcom/box/android/collections/presentation/navigationmodernization/navigation/CollectionsDestination$InnerDestination;", BoxCollection.TYPE, "Lcom/box/android/domain/models/CollectionModel;", "<init>", "(Lcom/box/android/domain/models/CollectionModel;)V", "getCollection", "()Lcom/box/android/domain/models/CollectionModel;", "component1", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "", "other", "", "hashCode", "", "toString", "", "Companion", "collections_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
        public static final /* data */ class CollectionItemsList extends InnerDestination {
            private final CollectionModel collection;

            /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
            public static final Companion INSTANCE = new Companion(null);
            public static final int $stable = 8;

            public static /* synthetic */ CollectionItemsList copy$default(CollectionItemsList collectionItemsList, CollectionModel collectionModel, int i, Object obj) {
                if ((i & 1) != 0) {
                    collectionModel = collectionItemsList.collection;
                }
                return collectionItemsList.copy(collectionModel);
            }

            /* JADX INFO: renamed from: component1, reason: from getter */
            public final CollectionModel getCollection() {
                return this.collection;
            }

            public final CollectionItemsList copy(CollectionModel collection) {
                Intrinsics.checkNotNullParameter(collection, "collection");
                return new CollectionItemsList(collection);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                return (other instanceof CollectionItemsList) && Intrinsics.areEqual(this.collection, ((CollectionItemsList) other).collection);
            }

            public int hashCode() {
                return this.collection.hashCode();
            }

            public String toString() {
                return "CollectionItemsList(collection=" + this.collection + ")";
            }

            /* JADX INFO: compiled from: CollectionsDestination.kt */
            @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/box/android/collections/presentation/navigationmodernization/navigation/CollectionsDestination$InnerDestination$CollectionItemsList$Companion;", "", "<init>", "()V", "collections_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
            public static final class Companion {
                public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                    this();
                }

                private Companion() {
                }
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public CollectionItemsList(CollectionModel collection) {
                super(null);
                Intrinsics.checkNotNullParameter(collection, "collection");
                this.collection = collection;
            }

            public final CollectionModel getCollection() {
                return this.collection;
            }
        }
    }

    /* JADX INFO: compiled from: CollectionsDestination.kt */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b7\u0018\u00002\u00020\u0001:\u0002\u0004\u0005B\t\b\u0004¢\u0006\u0004\b\u0002\u0010\u0003\u0082\u0001\u0002\u0006\u0007¨\u0006\b"}, d2 = {"Lcom/box/android/collections/presentation/navigationmodernization/navigation/CollectionsDestination$OuterDestination;", "Lcom/box/android/collections/presentation/navigationmodernization/navigation/CollectionsDestination;", "<init>", "()V", "Item", "ItemMoreActionsMenu", "Lcom/box/android/collections/presentation/navigationmodernization/navigation/CollectionsDestination$OuterDestination$Item;", "Lcom/box/android/collections/presentation/navigationmodernization/navigation/CollectionsDestination$OuterDestination$ItemMoreActionsMenu;", "collections_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static abstract class OuterDestination extends CollectionsDestination {
        public static final int $stable = 0;

        public /* synthetic */ OuterDestination(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* JADX INFO: compiled from: CollectionsDestination.kt */
        @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012HÖ\u0003J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001J\t\u0010\u0015\u001a\u00020\u0016HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0017"}, d2 = {"Lcom/box/android/collections/presentation/navigationmodernization/navigation/CollectionsDestination$OuterDestination$Item;", "Lcom/box/android/collections/presentation/navigationmodernization/navigation/CollectionsDestination$OuterDestination;", "itemModel", "Lcom/box/android/domain/models/item/ItemModel;", "previewSource", "Lcom/box/android/domain/models/preview/PreviewSource;", "<init>", "(Lcom/box/android/domain/models/item/ItemModel;Lcom/box/android/domain/models/preview/PreviewSource;)V", "getItemModel", "()Lcom/box/android/domain/models/item/ItemModel;", "getPreviewSource", "()Lcom/box/android/domain/models/preview/PreviewSource;", "component1", "component2", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "", "other", "", "hashCode", "", "toString", "", "collections_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
        public static final /* data */ class Item extends OuterDestination {
            public static final int $stable = 8;
            private final ItemModel itemModel;
            private final PreviewSource previewSource;

            public static /* synthetic */ Item copy$default(Item item, ItemModel itemModel, PreviewSource previewSource, int i, Object obj) {
                if ((i & 1) != 0) {
                    itemModel = item.itemModel;
                }
                if ((i & 2) != 0) {
                    previewSource = item.previewSource;
                }
                return item.copy(itemModel, previewSource);
            }

            /* JADX INFO: renamed from: component1, reason: from getter */
            public final ItemModel getItemModel() {
                return this.itemModel;
            }

            /* JADX INFO: renamed from: component2, reason: from getter */
            public final PreviewSource getPreviewSource() {
                return this.previewSource;
            }

            public final Item copy(ItemModel itemModel, PreviewSource previewSource) {
                Intrinsics.checkNotNullParameter(itemModel, "itemModel");
                Intrinsics.checkNotNullParameter(previewSource, "previewSource");
                return new Item(itemModel, previewSource);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof Item)) {
                    return false;
                }
                Item item = (Item) other;
                return Intrinsics.areEqual(this.itemModel, item.itemModel) && Intrinsics.areEqual(this.previewSource, item.previewSource);
            }

            public int hashCode() {
                return (this.itemModel.hashCode() * 31) + this.previewSource.hashCode();
            }

            public String toString() {
                return "Item(itemModel=" + this.itemModel + ", previewSource=" + this.previewSource + ")";
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public Item(ItemModel itemModel, PreviewSource previewSource) {
                super(null);
                Intrinsics.checkNotNullParameter(itemModel, "itemModel");
                Intrinsics.checkNotNullParameter(previewSource, "previewSource");
                this.itemModel = itemModel;
                this.previewSource = previewSource;
            }

            public final ItemModel getItemModel() {
                return this.itemModel;
            }

            public final PreviewSource getPreviewSource() {
                return this.previewSource;
            }
        }

        private OuterDestination() {
            super(null);
        }

        /* JADX INFO: compiled from: CollectionsDestination.kt */
        @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012HÖ\u0003J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001J\t\u0010\u0015\u001a\u00020\u0016HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0017"}, d2 = {"Lcom/box/android/collections/presentation/navigationmodernization/navigation/CollectionsDestination$OuterDestination$ItemMoreActionsMenu;", "Lcom/box/android/collections/presentation/navigationmodernization/navigation/CollectionsDestination$OuterDestination;", "itemModel", "Lcom/box/android/domain/models/item/ItemModel;", "bottomSheetMenuType", "Lcom/box/android/base/presentation/fragments/models/BottomSheetAttributes$BottomSheetMenuType;", "<init>", "(Lcom/box/android/domain/models/item/ItemModel;Lcom/box/android/base/presentation/fragments/models/BottomSheetAttributes$BottomSheetMenuType;)V", "getItemModel", "()Lcom/box/android/domain/models/item/ItemModel;", "getBottomSheetMenuType", "()Lcom/box/android/base/presentation/fragments/models/BottomSheetAttributes$BottomSheetMenuType;", "component1", "component2", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "", "other", "", "hashCode", "", "toString", "", "collections_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
        public static final /* data */ class ItemMoreActionsMenu extends OuterDestination {
            public static final int $stable = 8;
            private final BottomSheetAttributes.BottomSheetMenuType bottomSheetMenuType;
            private final ItemModel itemModel;

            public static /* synthetic */ ItemMoreActionsMenu copy$default(ItemMoreActionsMenu itemMoreActionsMenu, ItemModel itemModel, BottomSheetAttributes.BottomSheetMenuType bottomSheetMenuType, int i, Object obj) {
                if ((i & 1) != 0) {
                    itemModel = itemMoreActionsMenu.itemModel;
                }
                if ((i & 2) != 0) {
                    bottomSheetMenuType = itemMoreActionsMenu.bottomSheetMenuType;
                }
                return itemMoreActionsMenu.copy(itemModel, bottomSheetMenuType);
            }

            /* JADX INFO: renamed from: component1, reason: from getter */
            public final ItemModel getItemModel() {
                return this.itemModel;
            }

            /* JADX INFO: renamed from: component2, reason: from getter */
            public final BottomSheetAttributes.BottomSheetMenuType getBottomSheetMenuType() {
                return this.bottomSheetMenuType;
            }

            public final ItemMoreActionsMenu copy(ItemModel itemModel, BottomSheetAttributes.BottomSheetMenuType bottomSheetMenuType) {
                Intrinsics.checkNotNullParameter(itemModel, "itemModel");
                Intrinsics.checkNotNullParameter(bottomSheetMenuType, "bottomSheetMenuType");
                return new ItemMoreActionsMenu(itemModel, bottomSheetMenuType);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof ItemMoreActionsMenu)) {
                    return false;
                }
                ItemMoreActionsMenu itemMoreActionsMenu = (ItemMoreActionsMenu) other;
                return Intrinsics.areEqual(this.itemModel, itemMoreActionsMenu.itemModel) && Intrinsics.areEqual(this.bottomSheetMenuType, itemMoreActionsMenu.bottomSheetMenuType);
            }

            public int hashCode() {
                return (this.itemModel.hashCode() * 31) + this.bottomSheetMenuType.hashCode();
            }

            public String toString() {
                return "ItemMoreActionsMenu(itemModel=" + this.itemModel + ", bottomSheetMenuType=" + this.bottomSheetMenuType + ")";
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public ItemMoreActionsMenu(ItemModel itemModel, BottomSheetAttributes.BottomSheetMenuType bottomSheetMenuType) {
                super(null);
                Intrinsics.checkNotNullParameter(itemModel, "itemModel");
                Intrinsics.checkNotNullParameter(bottomSheetMenuType, "bottomSheetMenuType");
                this.itemModel = itemModel;
                this.bottomSheetMenuType = bottomSheetMenuType;
            }

            public final BottomSheetAttributes.BottomSheetMenuType getBottomSheetMenuType() {
                return this.bottomSheetMenuType;
            }

            public final ItemModel getItemModel() {
                return this.itemModel;
            }
        }
    }

    /* JADX INFO: compiled from: CollectionsDestination.kt */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/box/android/collections/presentation/navigationmodernization/navigation/CollectionsDestination$Companion;", "", "<init>", "()V", "collections_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }
}
