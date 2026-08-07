package com.box.android.preview.routing;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: CloseSource.kt */
/* JADX INFO: loaded from: classes12.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b7\u0018\u00002\u00020\u0001:\u0003\u0004\u0005\u0006B\t\b\u0004¢\u0006\u0004\b\u0002\u0010\u0003\u0082\u0001\u0003\u0007\b\t¨\u0006\n"}, d2 = {"Lcom/box/android/preview/routing/CloseSource;", "", "<init>", "()V", "AppButton", "SystemBack", "Delete", "Lcom/box/android/preview/routing/CloseSource$AppButton;", "Lcom/box/android/preview/routing/CloseSource$Delete;", "Lcom/box/android/preview/routing/CloseSource$SystemBack;", "preview_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public abstract class CloseSource {
    public static final int $stable = 0;

    public /* synthetic */ CloseSource(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    /* JADX INFO: compiled from: CloseSource.kt */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÇ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÖ\u0003J\t\u0010\b\u001a\u00020\tHÖ\u0001J\t\u0010\n\u001a\u00020\u000bHÖ\u0001¨\u0006\f"}, d2 = {"Lcom/box/android/preview/routing/CloseSource$AppButton;", "Lcom/box/android/preview/routing/CloseSource;", "<init>", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "preview_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final /* data */ class AppButton extends CloseSource {
        public static final int $stable = 0;
        public static final AppButton INSTANCE = new AppButton();

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof AppButton)) {
                return false;
            }
            return true;
        }

        public int hashCode() {
            return -1287392421;
        }

        public String toString() {
            return "AppButton";
        }

        private AppButton() {
            super(null);
        }
    }

    private CloseSource() {
    }

    /* JADX INFO: compiled from: CloseSource.kt */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÇ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÖ\u0003J\t\u0010\b\u001a\u00020\tHÖ\u0001J\t\u0010\n\u001a\u00020\u000bHÖ\u0001¨\u0006\f"}, d2 = {"Lcom/box/android/preview/routing/CloseSource$SystemBack;", "Lcom/box/android/preview/routing/CloseSource;", "<init>", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "preview_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final /* data */ class SystemBack extends CloseSource {
        public static final int $stable = 0;
        public static final SystemBack INSTANCE = new SystemBack();

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof SystemBack)) {
                return false;
            }
            return true;
        }

        public int hashCode() {
            return -1985982962;
        }

        public String toString() {
            return "SystemBack";
        }

        private SystemBack() {
            super(null);
        }
    }

    /* JADX INFO: compiled from: CloseSource.kt */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÇ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÖ\u0003J\t\u0010\b\u001a\u00020\tHÖ\u0001J\t\u0010\n\u001a\u00020\u000bHÖ\u0001¨\u0006\f"}, d2 = {"Lcom/box/android/preview/routing/CloseSource$Delete;", "Lcom/box/android/preview/routing/CloseSource;", "<init>", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "preview_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final /* data */ class Delete extends CloseSource {
        public static final int $stable = 0;
        public static final Delete INSTANCE = new Delete();

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Delete)) {
                return false;
            }
            return true;
        }

        public int hashCode() {
            return -1307278333;
        }

        public String toString() {
            return "Delete";
        }

        private Delete() {
            super(null);
        }
    }
}
