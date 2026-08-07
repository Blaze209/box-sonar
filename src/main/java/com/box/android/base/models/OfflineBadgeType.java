package com.box.android.base.models;

import kotlin.Metadata;

/* JADX INFO: compiled from: BoxListViewItemModels.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bv\u0018\u00002\u00020\u0001:\u0004\u0002\u0003\u0004\u0005\u0082\u0001\u0004\u0006\u0007\b\t¨\u0006\nÀ\u0006\u0003"}, d2 = {"Lcom/box/android/base/models/OfflineBadgeType;", "", "UpToDate", "Pending", "OutOfDate", "None", "Lcom/box/android/base/models/OfflineBadgeType$None;", "Lcom/box/android/base/models/OfflineBadgeType$OutOfDate;", "Lcom/box/android/base/models/OfflineBadgeType$Pending;", "Lcom/box/android/base/models/OfflineBadgeType$UpToDate;", "base_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public interface OfflineBadgeType {

    /* JADX INFO: compiled from: BoxListViewItemModels.kt */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÇ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÖ\u0003J\t\u0010\b\u001a\u00020\tHÖ\u0001J\t\u0010\n\u001a\u00020\u000bHÖ\u0001¨\u0006\f"}, d2 = {"Lcom/box/android/base/models/OfflineBadgeType$UpToDate;", "Lcom/box/android/base/models/OfflineBadgeType;", "<init>", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "base_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final /* data */ class UpToDate implements OfflineBadgeType {
        public static final int $stable = 0;
        public static final UpToDate INSTANCE = new UpToDate();

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof UpToDate)) {
                return false;
            }
            return true;
        }

        public int hashCode() {
            return -454040958;
        }

        public String toString() {
            return "UpToDate";
        }

        private UpToDate() {
        }
    }

    /* JADX INFO: compiled from: BoxListViewItemModels.kt */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÇ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÖ\u0003J\t\u0010\b\u001a\u00020\tHÖ\u0001J\t\u0010\n\u001a\u00020\u000bHÖ\u0001¨\u0006\f"}, d2 = {"Lcom/box/android/base/models/OfflineBadgeType$Pending;", "Lcom/box/android/base/models/OfflineBadgeType;", "<init>", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "base_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final /* data */ class Pending implements OfflineBadgeType {
        public static final int $stable = 0;
        public static final Pending INSTANCE = new Pending();

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Pending)) {
                return false;
            }
            return true;
        }

        public int hashCode() {
            return 382885529;
        }

        public String toString() {
            return "Pending";
        }

        private Pending() {
        }
    }

    /* JADX INFO: compiled from: BoxListViewItemModels.kt */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÇ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÖ\u0003J\t\u0010\b\u001a\u00020\tHÖ\u0001J\t\u0010\n\u001a\u00020\u000bHÖ\u0001¨\u0006\f"}, d2 = {"Lcom/box/android/base/models/OfflineBadgeType$OutOfDate;", "Lcom/box/android/base/models/OfflineBadgeType;", "<init>", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "base_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final /* data */ class OutOfDate implements OfflineBadgeType {
        public static final int $stable = 0;
        public static final OutOfDate INSTANCE = new OutOfDate();

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof OutOfDate)) {
                return false;
            }
            return true;
        }

        public int hashCode() {
            return -1361726571;
        }

        public String toString() {
            return "OutOfDate";
        }

        private OutOfDate() {
        }
    }

    /* JADX INFO: compiled from: BoxListViewItemModels.kt */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÇ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÖ\u0003J\t\u0010\b\u001a\u00020\tHÖ\u0001J\t\u0010\n\u001a\u00020\u000bHÖ\u0001¨\u0006\f"}, d2 = {"Lcom/box/android/base/models/OfflineBadgeType$None;", "Lcom/box/android/base/models/OfflineBadgeType;", "<init>", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "base_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final /* data */ class None implements OfflineBadgeType {
        public static final int $stable = 0;
        public static final None INSTANCE = new None();

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof None)) {
                return false;
            }
            return true;
        }

        public int hashCode() {
            return -1793078922;
        }

        public String toString() {
            return "None";
        }

        private None() {
        }
    }
}
