package com.box.android.browse.cpl.itempicker;

import com.box.android.domain.analytics.BoxAmplitudeAnalytics;
import com.box.android.domain.models.item.ItemModel;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: ItemPickerReducer.kt */
/* JADX INFO: loaded from: classes10.dex */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b7\u0018\u00002\u00020\u0001:\u0002\u0004\u0005B\t\b\u0004¢\u0006\u0004\b\u0002\u0010\u0003\u0082\u0001\u0002\u0006\u0007¨\u0006\b"}, d2 = {"Lcom/box/android/browse/cpl/itempicker/ItemPickerMode;", "", "<init>", "()V", "Single", "Multi", "Lcom/box/android/browse/cpl/itempicker/ItemPickerMode$Multi;", "Lcom/box/android/browse/cpl/itempicker/ItemPickerMode$Single;", "browse_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public abstract class ItemPickerMode {
    public static final int $stable = 0;

    public /* synthetic */ ItemPickerMode(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    /* JADX INFO: compiled from: ItemPickerReducer.kt */
    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u0013\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u000b\u0010\b\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0015\u0010\t\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0003J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0012"}, d2 = {"Lcom/box/android/browse/cpl/itempicker/ItemPickerMode$Single;", "Lcom/box/android/browse/cpl/itempicker/ItemPickerMode;", "selectedItem", "Lcom/box/android/domain/models/item/ItemModel;", "<init>", "(Lcom/box/android/domain/models/item/ItemModel;)V", "getSelectedItem", "()Lcom/box/android/domain/models/item/ItemModel;", "component1", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "", "other", "", "hashCode", "", "toString", "", "browse_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final /* data */ class Single extends ItemPickerMode {
        public static final int $stable = 8;
        private final ItemModel selectedItem;

        /* JADX WARN: Multi-variable type inference failed */
        public Single() {
            this(null, 1, 0 == true ? 1 : 0);
        }

        public static /* synthetic */ Single copy$default(Single single, ItemModel itemModel, int i, Object obj) {
            if ((i & 1) != 0) {
                itemModel = single.selectedItem;
            }
            return single.copy(itemModel);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final ItemModel getSelectedItem() {
            return this.selectedItem;
        }

        public final Single copy(ItemModel selectedItem) {
            return new Single(selectedItem);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            return (other instanceof Single) && Intrinsics.areEqual(this.selectedItem, ((Single) other).selectedItem);
        }

        public int hashCode() {
            ItemModel itemModel = this.selectedItem;
            if (itemModel == null) {
                return 0;
            }
            return itemModel.hashCode();
        }

        public String toString() {
            return "Single(selectedItem=" + this.selectedItem + ")";
        }

        public Single(ItemModel itemModel) {
            super(null);
            this.selectedItem = itemModel;
        }

        public /* synthetic */ Single(ItemModel itemModel, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? null : itemModel);
        }

        public final ItemModel getSelectedItem() {
            return this.selectedItem;
        }
    }

    private ItemPickerMode() {
    }

    /* JADX INFO: compiled from: ItemPickerReducer.kt */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÇ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÖ\u0003J\t\u0010\b\u001a\u00020\tHÖ\u0001J\t\u0010\n\u001a\u00020\u000bHÖ\u0001¨\u0006\f"}, d2 = {"Lcom/box/android/browse/cpl/itempicker/ItemPickerMode$Multi;", "Lcom/box/android/browse/cpl/itempicker/ItemPickerMode;", "<init>", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "browse_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final /* data */ class Multi extends ItemPickerMode {
        public static final int $stable = 0;
        public static final Multi INSTANCE = new Multi();

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Multi)) {
                return false;
            }
            return true;
        }

        public int hashCode() {
            return -140309704;
        }

        public String toString() {
            return "Multi";
        }

        private Multi() {
            super(null);
        }
    }
}
