package com.box.android.base.presentation.adapters.listitem;

import androidx.exifinterface.media.ExifInterface;
import androidx.recyclerview.widget.DiffUtil;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: AdapterItem.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0004\b'\u0018\u0000*\u0004\b\u0000\u0010\u00012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00010\u00030\u0002B\u0007¢\u0006\u0004\b\u0004\u0010\u0005J\u0015\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00028\u0000H&¢\u0006\u0002\u0010\tJ$\u0010\n\u001a\u00020\u000b2\f\u0010\f\u001a\b\u0012\u0004\u0012\u00028\u00000\u00032\f\u0010\r\u001a\b\u0012\u0004\u0012\u00028\u00000\u0003H\u0016J$\u0010\u000e\u001a\u00020\u000b2\f\u0010\f\u001a\b\u0012\u0004\u0012\u00028\u00000\u00032\f\u0010\r\u001a\b\u0012\u0004\u0012\u00028\u00000\u0003H\u0016¨\u0006\u000f"}, d2 = {"Lcom/box/android/base/presentation/adapters/listitem/AdapterItemDiffCallback;", ExifInterface.GPS_DIRECTION_TRUE, "Landroidx/recyclerview/widget/DiffUtil$ItemCallback;", "Lcom/box/android/base/presentation/adapters/listitem/AdapterItem;", "<init>", "()V", "getId", "", "item", "(Ljava/lang/Object;)Ljava/lang/String;", "areItemsTheSame", "", "oldItem", "newItem", "areContentsTheSame", "base_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public abstract class AdapterItemDiffCallback<T> extends DiffUtil.ItemCallback<AdapterItem<? extends T>> {
    public static final int $stable = 8;

    public abstract String getId(T item);

    /* JADX WARN: Multi-variable type inference failed */
    @Override // androidx.recyclerview.widget.DiffUtil.ItemCallback
    public boolean areItemsTheSame(AdapterItem<? extends T> oldItem, AdapterItem<? extends T> newItem) {
        Intrinsics.checkNotNullParameter(oldItem, "oldItem");
        Intrinsics.checkNotNullParameter(newItem, "newItem");
        if ((oldItem instanceof AdapterItem.DataItem) && (newItem instanceof AdapterItem.DataItem)) {
            return Intrinsics.areEqual(getId(((AdapterItem.DataItem) oldItem).getValue()), getId(((AdapterItem.DataItem) newItem).getValue()));
        }
        if ((oldItem instanceof AdapterItem.HeaderItem) && (newItem instanceof AdapterItem.HeaderItem)) {
            return Intrinsics.areEqual(((AdapterItem.HeaderItem) oldItem).getValue(), ((AdapterItem.HeaderItem) newItem).getValue());
        }
        if ((oldItem instanceof AdapterItem.ActionableHeaderItem) && (newItem instanceof AdapterItem.ActionableHeaderItem)) {
            AdapterItem.ActionableHeaderItem actionableHeaderItem = (AdapterItem.ActionableHeaderItem) oldItem;
            AdapterItem.ActionableHeaderItem actionableHeaderItem2 = (AdapterItem.ActionableHeaderItem) newItem;
            if (Intrinsics.areEqual(actionableHeaderItem.getTitle(), actionableHeaderItem2.getTitle()) && Intrinsics.areEqual(actionableHeaderItem.getAction(), actionableHeaderItem2.getAction())) {
                return true;
            }
        }
        return false;
    }

    @Override // androidx.recyclerview.widget.DiffUtil.ItemCallback
    public boolean areContentsTheSame(AdapterItem<? extends T> oldItem, AdapterItem<? extends T> newItem) {
        Intrinsics.checkNotNullParameter(oldItem, "oldItem");
        Intrinsics.checkNotNullParameter(newItem, "newItem");
        return Intrinsics.areEqual(oldItem, newItem);
    }
}
