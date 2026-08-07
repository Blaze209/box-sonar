package com.box.android.browse.cpl.browse.fab;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: FabManager.kt */
/* JADX INFO: loaded from: classes10.dex */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b7\u0018\u00002\u00020\u0001:\u0002\u0004\u0005B\t\b\u0004¢\u0006\u0004\b\u0002\u0010\u0003\u0082\u0001\u0002\u0006\u0007¨\u0006\b"}, d2 = {"Lcom/box/android/browse/cpl/browse/fab/FabMenuOptionResult;", "", "<init>", "()V", "PermissionDenied", "Success", "Lcom/box/android/browse/cpl/browse/fab/FabMenuOptionResult$PermissionDenied;", "Lcom/box/android/browse/cpl/browse/fab/FabMenuOptionResult$Success;", "browse_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public abstract class FabMenuOptionResult {
    public static final int $stable = 0;

    public /* synthetic */ FabMenuOptionResult(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    /* JADX INFO: compiled from: FabManager.kt */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÇ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÖ\u0003J\t\u0010\b\u001a\u00020\tHÖ\u0001J\t\u0010\n\u001a\u00020\u000bHÖ\u0001¨\u0006\f"}, d2 = {"Lcom/box/android/browse/cpl/browse/fab/FabMenuOptionResult$PermissionDenied;", "Lcom/box/android/browse/cpl/browse/fab/FabMenuOptionResult;", "<init>", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "browse_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final /* data */ class PermissionDenied extends FabMenuOptionResult {
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
            return -480665273;
        }

        public String toString() {
            return "PermissionDenied";
        }

        private PermissionDenied() {
            super(null);
        }
    }

    private FabMenuOptionResult() {
    }

    /* JADX INFO: compiled from: FabManager.kt */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÇ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÖ\u0003J\t\u0010\b\u001a\u00020\tHÖ\u0001J\t\u0010\n\u001a\u00020\u000bHÖ\u0001¨\u0006\f"}, d2 = {"Lcom/box/android/browse/cpl/browse/fab/FabMenuOptionResult$Success;", "Lcom/box/android/browse/cpl/browse/fab/FabMenuOptionResult;", "<init>", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "browse_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final /* data */ class Success extends FabMenuOptionResult {
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
            return 736703590;
        }

        public String toString() {
            return "Success";
        }

        private Success() {
            super(null);
        }
    }
}
