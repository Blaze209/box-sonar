package com.box.android.base.presentation.adapters.listitem;

import androidx.exifinterface.media.ExifInterface;
import com.pspdfkit.analytics.Analytics;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: AdapterItem.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b7\u0018\u0000 \r*\u0006\b\u0000\u0010\u0001 \u00012\u00020\u0002:\u0004\n\u000b\f\rB\t\b\u0004¢\u0006\u0004\b\u0003\u0010\u0004J\u0013\u0010\u0005\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\u0002H\u0096\u0002J\b\u0010\b\u001a\u00020\tH\u0016\u0082\u0001\u0003\u000e\u000f\u0010¨\u0006\u0011"}, d2 = {"Lcom/box/android/base/presentation/adapters/listitem/AdapterItem;", ExifInterface.GPS_DIRECTION_TRUE, "", "<init>", "()V", "equals", "", "other", "hashCode", "", "DataItem", "HeaderItem", "ActionableHeaderItem", "Companion", "Lcom/box/android/base/presentation/adapters/listitem/AdapterItem$ActionableHeaderItem;", "Lcom/box/android/base/presentation/adapters/listitem/AdapterItem$DataItem;", "Lcom/box/android/base/presentation/adapters/listitem/AdapterItem$HeaderItem;", "base_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public abstract class AdapterItem<T> {
    public static final int $stable = 0;
    public static final int ACTIONABLE_HEADER_VIEW_TYPE = 2;
    public static final int HEADER_VIEW_TYPE = 1;
    public static final int ITEM_VIEW_TYPE = 0;

    public /* synthetic */ AdapterItem(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    /* JADX INFO: compiled from: AdapterItem.kt */
    @Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0007\u0018\u0000*\u0006\b\u0001\u0010\u0001 \u00012\b\u0012\u0004\u0012\u0002H\u00010\u0002B\u000f\u0012\u0006\u0010\u0003\u001a\u00028\u0001¢\u0006\u0004\b\u0004\u0010\u0005R\u0013\u0010\u0003\u001a\u00028\u0001¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\u0006\u0010\u0007¨\u0006\t"}, d2 = {"Lcom/box/android/base/presentation/adapters/listitem/AdapterItem$DataItem;", ExifInterface.GPS_DIRECTION_TRUE, "Lcom/box/android/base/presentation/adapters/listitem/AdapterItem;", "value", "<init>", "(Ljava/lang/Object;)V", "getValue", "()Ljava/lang/Object;", "Ljava/lang/Object;", "base_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class DataItem<T> extends AdapterItem<T> {
        public static final int $stable = 0;
        private final T value;

        public DataItem(T t) {
            super(null);
            this.value = t;
        }

        public final T getValue() {
            return this.value;
        }
    }

    private AdapterItem() {
    }

    /* JADX INFO: compiled from: AdapterItem.kt */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0001\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"Lcom/box/android/base/presentation/adapters/listitem/AdapterItem$HeaderItem;", "Lcom/box/android/base/presentation/adapters/listitem/AdapterItem;", "", "value", "", "<init>", "(Ljava/lang/String;)V", "getValue", "()Ljava/lang/String;", "base_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class HeaderItem extends AdapterItem {
        public static final int $stable = 0;
        private final String value;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public HeaderItem(String value) {
            super(null);
            Intrinsics.checkNotNullParameter(value, "value");
            this.value = value;
        }

        public final String getValue() {
            return this.value;
        }
    }

    /* JADX INFO: compiled from: AdapterItem.kt */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0001\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0005\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\t¨\u0006\u000b"}, d2 = {"Lcom/box/android/base/presentation/adapters/listitem/AdapterItem$ActionableHeaderItem;", "Lcom/box/android/base/presentation/adapters/listitem/AdapterItem;", "", "title", "", Analytics.Data.ACTION, "<init>", "(Ljava/lang/String;Ljava/lang/String;)V", "getTitle", "()Ljava/lang/String;", "getAction", "base_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class ActionableHeaderItem extends AdapterItem {
        public static final int $stable = 0;
        private final String action;
        private final String title;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public ActionableHeaderItem(String title, String action) {
            super(null);
            Intrinsics.checkNotNullParameter(title, "title");
            Intrinsics.checkNotNullParameter(action, "action");
            this.title = title;
            this.action = action;
        }

        public final String getAction() {
            return this.action;
        }

        public final String getTitle() {
            return this.title;
        }
    }

    public boolean equals(Object other) {
        if ((other instanceof DataItem) && (this instanceof DataItem)) {
            return Intrinsics.areEqual(((DataItem) other).getValue(), ((DataItem) this).getValue());
        }
        if ((other instanceof HeaderItem) && (this instanceof HeaderItem)) {
            return Intrinsics.areEqual(((HeaderItem) other).getValue(), ((HeaderItem) this).getValue());
        }
        if ((other instanceof ActionableHeaderItem) && (this instanceof ActionableHeaderItem)) {
            ActionableHeaderItem actionableHeaderItem = (ActionableHeaderItem) other;
            ActionableHeaderItem actionableHeaderItem2 = (ActionableHeaderItem) this;
            if (Intrinsics.areEqual(actionableHeaderItem.getTitle(), actionableHeaderItem2.getTitle()) && Intrinsics.areEqual(actionableHeaderItem.getAction(), actionableHeaderItem2.getAction())) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        if (this instanceof HeaderItem) {
            return ((HeaderItem) this).getValue().hashCode();
        }
        if (this instanceof ActionableHeaderItem) {
            ActionableHeaderItem actionableHeaderItem = (ActionableHeaderItem) this;
            return actionableHeaderItem.getTitle().hashCode() + actionableHeaderItem.getAction().hashCode();
        }
        if (!(this instanceof DataItem)) {
            throw new NoWhenBranchMatchedException();
        }
        Object value = ((DataItem) this).getValue();
        if (value != null) {
            return value.hashCode();
        }
        return 0;
    }
}
