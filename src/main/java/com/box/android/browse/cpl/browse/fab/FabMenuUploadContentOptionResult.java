package com.box.android.browse.cpl.browse.fab;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: FabManager.kt */
/* JADX INFO: loaded from: classes10.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b7\u0018\u00002\u00020\u0001:\u0004\u0004\u0005\u0006\u0007B\t\b\u0004¢\u0006\u0004\b\u0002\u0010\u0003\u0082\u0001\u0004\b\t\n\u000b¨\u0006\f"}, d2 = {"Lcom/box/android/browse/cpl/browse/fab/FabMenuUploadContentOptionResult;", "", "<init>", "()V", "MAMBlocked", "PermissionDenied", "StorageAccessNeeded", "Success", "Lcom/box/android/browse/cpl/browse/fab/FabMenuUploadContentOptionResult$MAMBlocked;", "Lcom/box/android/browse/cpl/browse/fab/FabMenuUploadContentOptionResult$PermissionDenied;", "Lcom/box/android/browse/cpl/browse/fab/FabMenuUploadContentOptionResult$StorageAccessNeeded;", "Lcom/box/android/browse/cpl/browse/fab/FabMenuUploadContentOptionResult$Success;", "browse_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public abstract class FabMenuUploadContentOptionResult {
    public static final int $stable = 0;

    public /* synthetic */ FabMenuUploadContentOptionResult(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    /* JADX INFO: compiled from: FabManager.kt */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÇ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÖ\u0003J\t\u0010\b\u001a\u00020\tHÖ\u0001J\t\u0010\n\u001a\u00020\u000bHÖ\u0001¨\u0006\f"}, d2 = {"Lcom/box/android/browse/cpl/browse/fab/FabMenuUploadContentOptionResult$MAMBlocked;", "Lcom/box/android/browse/cpl/browse/fab/FabMenuUploadContentOptionResult;", "<init>", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "browse_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final /* data */ class MAMBlocked extends FabMenuUploadContentOptionResult {
        public static final int $stable = 0;
        public static final MAMBlocked INSTANCE = new MAMBlocked();

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof MAMBlocked)) {
                return false;
            }
            return true;
        }

        public int hashCode() {
            return 1080626710;
        }

        public String toString() {
            return "MAMBlocked";
        }

        private MAMBlocked() {
            super(null);
        }
    }

    private FabMenuUploadContentOptionResult() {
    }

    /* JADX INFO: compiled from: FabManager.kt */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÇ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÖ\u0003J\t\u0010\b\u001a\u00020\tHÖ\u0001J\t\u0010\n\u001a\u00020\u000bHÖ\u0001¨\u0006\f"}, d2 = {"Lcom/box/android/browse/cpl/browse/fab/FabMenuUploadContentOptionResult$PermissionDenied;", "Lcom/box/android/browse/cpl/browse/fab/FabMenuUploadContentOptionResult;", "<init>", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "browse_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final /* data */ class PermissionDenied extends FabMenuUploadContentOptionResult {
        public static final int $stable = 0;
        public static final PermissionDenied INSTANCE = new PermissionDenied();

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof PermissionDenied)) {
                return false;
            }
            return true;
        }

        public int hashCode() {
            return -1619856435;
        }

        public String toString() {
            return "PermissionDenied";
        }

        private PermissionDenied() {
            super(null);
        }
    }

    /* JADX INFO: compiled from: FabManager.kt */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÇ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÖ\u0003J\t\u0010\b\u001a\u00020\tHÖ\u0001J\t\u0010\n\u001a\u00020\u000bHÖ\u0001¨\u0006\f"}, d2 = {"Lcom/box/android/browse/cpl/browse/fab/FabMenuUploadContentOptionResult$StorageAccessNeeded;", "Lcom/box/android/browse/cpl/browse/fab/FabMenuUploadContentOptionResult;", "<init>", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "browse_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final /* data */ class StorageAccessNeeded extends FabMenuUploadContentOptionResult {
        public static final int $stable = 0;
        public static final StorageAccessNeeded INSTANCE = new StorageAccessNeeded();

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof StorageAccessNeeded)) {
                return false;
            }
            return true;
        }

        public int hashCode() {
            return 755782641;
        }

        public String toString() {
            return "StorageAccessNeeded";
        }

        private StorageAccessNeeded() {
            super(null);
        }
    }

    /* JADX INFO: compiled from: FabManager.kt */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÇ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÖ\u0003J\t\u0010\b\u001a\u00020\tHÖ\u0001J\t\u0010\n\u001a\u00020\u000bHÖ\u0001¨\u0006\f"}, d2 = {"Lcom/box/android/browse/cpl/browse/fab/FabMenuUploadContentOptionResult$Success;", "Lcom/box/android/browse/cpl/browse/fab/FabMenuUploadContentOptionResult;", "<init>", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "browse_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final /* data */ class Success extends FabMenuUploadContentOptionResult {
        public static final int $stable = 0;
        public static final Success INSTANCE = new Success();

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Success)) {
                return false;
            }
            return true;
        }

        public int hashCode() {
            return 125686560;
        }

        public String toString() {
            return "Success";
        }

        private Success() {
            super(null);
        }
    }
}
