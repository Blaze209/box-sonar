package com.box.android.browse.cpl.browse.fab;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: FabManager.kt */
/* JADX INFO: loaded from: classes10.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b7\u0018\u00002\u00020\u0001:\u0003\u0004\u0005\u0006B\t\b\u0004¢\u0006\u0004\b\u0002\u0010\u0003\u0082\u0001\u0003\u0007\b\t¨\u0006\n"}, d2 = {"Lcom/box/android/browse/cpl/browse/fab/FabMenuCaptureMediaOptionResult;", "", "<init>", "()V", "PermissionDenied", "StorageAccessNeeded", "Success", "Lcom/box/android/browse/cpl/browse/fab/FabMenuCaptureMediaOptionResult$PermissionDenied;", "Lcom/box/android/browse/cpl/browse/fab/FabMenuCaptureMediaOptionResult$StorageAccessNeeded;", "Lcom/box/android/browse/cpl/browse/fab/FabMenuCaptureMediaOptionResult$Success;", "browse_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public abstract class FabMenuCaptureMediaOptionResult {
    public static final int $stable = 0;

    public /* synthetic */ FabMenuCaptureMediaOptionResult(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    /* JADX INFO: compiled from: FabManager.kt */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÇ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÖ\u0003J\t\u0010\b\u001a\u00020\tHÖ\u0001J\t\u0010\n\u001a\u00020\u000bHÖ\u0001¨\u0006\f"}, d2 = {"Lcom/box/android/browse/cpl/browse/fab/FabMenuCaptureMediaOptionResult$PermissionDenied;", "Lcom/box/android/browse/cpl/browse/fab/FabMenuCaptureMediaOptionResult;", "<init>", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "browse_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final /* data */ class PermissionDenied extends FabMenuCaptureMediaOptionResult {
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
            return -185678807;
        }

        public String toString() {
            return "PermissionDenied";
        }

        private PermissionDenied() {
            super(null);
        }
    }

    private FabMenuCaptureMediaOptionResult() {
    }

    /* JADX INFO: compiled from: FabManager.kt */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÇ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÖ\u0003J\t\u0010\b\u001a\u00020\tHÖ\u0001J\t\u0010\n\u001a\u00020\u000bHÖ\u0001¨\u0006\f"}, d2 = {"Lcom/box/android/browse/cpl/browse/fab/FabMenuCaptureMediaOptionResult$StorageAccessNeeded;", "Lcom/box/android/browse/cpl/browse/fab/FabMenuCaptureMediaOptionResult;", "<init>", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "browse_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final /* data */ class StorageAccessNeeded extends FabMenuCaptureMediaOptionResult {
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
            return 6837781;
        }

        public String toString() {
            return "StorageAccessNeeded";
        }

        private StorageAccessNeeded() {
            super(null);
        }
    }

    /* JADX INFO: compiled from: FabManager.kt */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÇ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÖ\u0003J\t\u0010\b\u001a\u00020\tHÖ\u0001J\t\u0010\n\u001a\u00020\u000bHÖ\u0001¨\u0006\f"}, d2 = {"Lcom/box/android/browse/cpl/browse/fab/FabMenuCaptureMediaOptionResult$Success;", "Lcom/box/android/browse/cpl/browse/fab/FabMenuCaptureMediaOptionResult;", "<init>", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "browse_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final /* data */ class Success extends FabMenuCaptureMediaOptionResult {
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
            return -1403983036;
        }

        public String toString() {
            return "Success";
        }

        private Success() {
            super(null);
        }
    }
}
