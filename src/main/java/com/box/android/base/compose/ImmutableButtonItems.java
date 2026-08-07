package com.box.android.base.compose;

import com.box.android.base.compose.button.model.ButtonItem;
import com.box.android.domain.analytics.BoxAmplitudeAnalytics;
import com.facebook.react.modules.dialog.AlertFragment;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: ButtonBar.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u0015\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003J\u0019\u0010\n\u001a\u00020\u00002\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0001J\u0013\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001R\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\u0012"}, d2 = {"Lcom/box/android/base/compose/ImmutableButtonItems;", "", AlertFragment.ARG_ITEMS, "", "Lcom/box/android/base/compose/button/model/ButtonItem$TextButtonItem;", "<init>", "(Ljava/util/List;)V", "getItems", "()Ljava/util/List;", "component1", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "", "other", "hashCode", "", "toString", "", "base_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final /* data */ class ImmutableButtonItems {
    public static final int $stable = 0;
    private final List<ButtonItem.TextButtonItem> items;

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ ImmutableButtonItems copy$default(ImmutableButtonItems immutableButtonItems, List list, int i, Object obj) {
        if ((i & 1) != 0) {
            list = immutableButtonItems.items;
        }
        return immutableButtonItems.copy(list);
    }

    public final List<ButtonItem.TextButtonItem> component1() {
        return this.items;
    }

    public final ImmutableButtonItems copy(List<ButtonItem.TextButtonItem> items) {
        Intrinsics.checkNotNullParameter(items, "items");
        return new ImmutableButtonItems(items);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        return (other instanceof ImmutableButtonItems) && Intrinsics.areEqual(this.items, ((ImmutableButtonItems) other).items);
    }

    public int hashCode() {
        return this.items.hashCode();
    }

    public String toString() {
        return "ImmutableButtonItems(items=" + this.items + ")";
    }

    public ImmutableButtonItems(List<ButtonItem.TextButtonItem> items) {
        Intrinsics.checkNotNullParameter(items, "items");
        this.items = items;
    }

    public final List<ButtonItem.TextButtonItem> getItems() {
        return this.items;
    }
}
