package com.box.android.base.models;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: BoxListViewItemModels.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b7\u0018\u00002\u00020\u0001:\u0003\u0004\u0005\u0006B\t\b\u0004¢\u0006\u0004\b\u0002\u0010\u0003\u0082\u0001\u0003\u0007\b\t¨\u0006\n"}, d2 = {"Lcom/box/android/base/models/SecondaryActionType;", "", "<init>", "()V", "Checkbox", "BottomSheetMenu", "None", "Lcom/box/android/base/models/SecondaryActionType$BottomSheetMenu;", "Lcom/box/android/base/models/SecondaryActionType$Checkbox;", "Lcom/box/android/base/models/SecondaryActionType$None;", "base_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public abstract class SecondaryActionType {
    public static final int $stable = 0;

    public /* synthetic */ SecondaryActionType(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    /* JADX INFO: compiled from: BoxListViewItemModels.kt */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/box/android/base/models/SecondaryActionType$Checkbox;", "Lcom/box/android/base/models/SecondaryActionType;", "<init>", "()V", "base_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class Checkbox extends SecondaryActionType {
        public static final int $stable = 0;
        public static final Checkbox INSTANCE = new Checkbox();

        private Checkbox() {
            super(null);
        }
    }

    private SecondaryActionType() {
    }

    /* JADX INFO: compiled from: BoxListViewItemModels.kt */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/box/android/base/models/SecondaryActionType$BottomSheetMenu;", "Lcom/box/android/base/models/SecondaryActionType;", "<init>", "()V", "base_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class BottomSheetMenu extends SecondaryActionType {
        public static final int $stable = 0;
        public static final BottomSheetMenu INSTANCE = new BottomSheetMenu();

        private BottomSheetMenu() {
            super(null);
        }
    }

    /* JADX INFO: compiled from: BoxListViewItemModels.kt */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/box/android/base/models/SecondaryActionType$None;", "Lcom/box/android/base/models/SecondaryActionType;", "<init>", "()V", "base_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class None extends SecondaryActionType {
        public static final int $stable = 0;
        public static final None INSTANCE = new None();

        private None() {
            super(null);
        }
    }
}
