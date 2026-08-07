package com.box.android.base.presentation.components.permission;

import com.box.android.cpl.Effect;
import com.box.android.cpl.Reducable;
import com.box.android.cpl.ReducerResult;
import com.box.android.domain.analytics.BoxAmplitudeAnalytics;
import com.pspdfkit.analytics.Analytics;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: PermissionReducer.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0007\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0003\n\u000b\fB\u0007¢\u0006\u0004\b\u0004\u0010\u0005J$\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u00072\u0006\u0010\b\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\u0003H\u0016¨\u0006\r"}, d2 = {"Lcom/box/android/base/presentation/components/permission/PermissionReducer;", "Lcom/box/android/cpl/Reducable;", "Lcom/box/android/base/presentation/components/permission/PermissionReducer$State;", "Lcom/box/android/base/presentation/components/permission/PermissionReducer$Action;", "<init>", "()V", "reduce", "Lcom/box/android/cpl/ReducerResult;", "state", Analytics.Data.ACTION, "State", "PermissionRequest", "Action", "base_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class PermissionReducer implements Reducable<State, Action> {
    public static final int $stable = 0;

    /* JADX INFO: compiled from: PermissionReducer.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    public static final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[Action.PermissionRequestResult.Status.values().length];
            try {
                iArr[Action.PermissionRequestResult.Status.GRANTED.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[Action.PermissionRequestResult.Status.DENIED.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[Action.PermissionRequestResult.Status.PERMANENTLY_DENIED.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    @Override // com.box.android.cpl.Reducable
    public /* bridge */ Reducable<State, Action> getBuild() {
        return Reducable.DefaultImpls.getBuild(this);
    }

    /* JADX INFO: compiled from: PermissionReducer.kt */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\f\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u001d\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u000b\u0010\f\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0005HÆ\u0003J\u001f\u0010\u000e\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00052\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0015"}, d2 = {"Lcom/box/android/base/presentation/components/permission/PermissionReducer$State;", "", "permissionRequest", "Lcom/box/android/base/presentation/components/permission/PermissionReducer$PermissionRequest;", "shouldShowPermanentDenialDialog", "", "<init>", "(Lcom/box/android/base/presentation/components/permission/PermissionReducer$PermissionRequest;Z)V", "getPermissionRequest", "()Lcom/box/android/base/presentation/components/permission/PermissionReducer$PermissionRequest;", "getShouldShowPermanentDenialDialog", "()Z", "component1", "component2", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "other", "hashCode", "", "toString", "", "base_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final /* data */ class State {
        public static final int $stable = 0;
        private final PermissionRequest permissionRequest;
        private final boolean shouldShowPermanentDenialDialog;

        /* JADX WARN: Multi-variable type inference failed */
        public State() {
            this(null, false, 3, 0 == true ? 1 : 0);
        }

        public static /* synthetic */ State copy$default(State state, PermissionRequest permissionRequest, boolean z, int i, Object obj) {
            if ((i & 1) != 0) {
                permissionRequest = state.permissionRequest;
            }
            if ((i & 2) != 0) {
                z = state.shouldShowPermanentDenialDialog;
            }
            return state.copy(permissionRequest, z);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final PermissionRequest getPermissionRequest() {
            return this.permissionRequest;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final boolean getShouldShowPermanentDenialDialog() {
            return this.shouldShowPermanentDenialDialog;
        }

        public final State copy(PermissionRequest permissionRequest, boolean shouldShowPermanentDenialDialog) {
            return new State(permissionRequest, shouldShowPermanentDenialDialog);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof State)) {
                return false;
            }
            State state = (State) other;
            return Intrinsics.areEqual(this.permissionRequest, state.permissionRequest) && this.shouldShowPermanentDenialDialog == state.shouldShowPermanentDenialDialog;
        }

        public int hashCode() {
            PermissionRequest permissionRequest = this.permissionRequest;
            return ((permissionRequest == null ? 0 : permissionRequest.hashCode()) * 31) + Boolean.hashCode(this.shouldShowPermanentDenialDialog);
        }

        public String toString() {
            return "State(permissionRequest=" + this.permissionRequest + ", shouldShowPermanentDenialDialog=" + this.shouldShowPermanentDenialDialog + ")";
        }

        public State(PermissionRequest permissionRequest, boolean z) {
            this.permissionRequest = permissionRequest;
            this.shouldShowPermanentDenialDialog = z;
        }

        public /* synthetic */ State(PermissionRequest permissionRequest, boolean z, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? null : permissionRequest, (i & 2) != 0 ? false : z);
        }

        public final PermissionRequest getPermissionRequest() {
            return this.permissionRequest;
        }

        public final boolean getShouldShowPermanentDenialDialog() {
            return this.shouldShowPermanentDenialDialog;
        }
    }

    /* JADX INFO: compiled from: PermissionReducer.kt */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0010"}, d2 = {"Lcom/box/android/base/presentation/components/permission/PermissionReducer$PermissionRequest;", "", "permission", "", "<init>", "(Ljava/lang/String;)V", "getPermission", "()Ljava/lang/String;", "component1", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "", "other", "hashCode", "", "toString", "base_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final /* data */ class PermissionRequest {
        public static final int $stable = 0;
        private final String permission;

        public static /* synthetic */ PermissionRequest copy$default(PermissionRequest permissionRequest, String str, int i, Object obj) {
            if ((i & 1) != 0) {
                str = permissionRequest.permission;
            }
            return permissionRequest.copy(str);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final String getPermission() {
            return this.permission;
        }

        public final PermissionRequest copy(String permission) {
            Intrinsics.checkNotNullParameter(permission, "permission");
            return new PermissionRequest(permission);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            return (other instanceof PermissionRequest) && Intrinsics.areEqual(this.permission, ((PermissionRequest) other).permission);
        }

        public int hashCode() {
            return this.permission.hashCode();
        }

        public String toString() {
            return "PermissionRequest(permission=" + this.permission + ")";
        }

        public PermissionRequest(String permission) {
            Intrinsics.checkNotNullParameter(permission, "permission");
            this.permission = permission;
        }

        public final String getPermission() {
            return this.permission;
        }
    }

    /* JADX INFO: compiled from: PermissionReducer.kt */
    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b7\u0018\u00002\u00020\u0001:\u0004\u0004\u0005\u0006\u0007B\t\b\u0004¢\u0006\u0004\b\u0002\u0010\u0003\u0082\u0001\u0004\b\t\n\u000b¨\u0006\f"}, d2 = {"Lcom/box/android/base/presentation/components/permission/PermissionReducer$Action;", "", "<init>", "()V", "RequestPermission", "PermissionRequestResult", "PermissionGranted", "DismissPermanentDenialDialog", "Lcom/box/android/base/presentation/components/permission/PermissionReducer$Action$DismissPermanentDenialDialog;", "Lcom/box/android/base/presentation/components/permission/PermissionReducer$Action$PermissionGranted;", "Lcom/box/android/base/presentation/components/permission/PermissionReducer$Action$PermissionRequestResult;", "Lcom/box/android/base/presentation/components/permission/PermissionReducer$Action$RequestPermission;", "base_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static abstract class Action {
        public static final int $stable = 0;

        public /* synthetic */ Action(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* JADX INFO: compiled from: PermissionReducer.kt */
        @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0003J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\t\u0010\u0010\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0011"}, d2 = {"Lcom/box/android/base/presentation/components/permission/PermissionReducer$Action$RequestPermission;", "Lcom/box/android/base/presentation/components/permission/PermissionReducer$Action;", "permission", "", "<init>", "(Ljava/lang/String;)V", "getPermission", "()Ljava/lang/String;", "component1", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "", "other", "", "hashCode", "", "toString", "base_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
        public static final /* data */ class RequestPermission extends Action {
            public static final int $stable = 0;
            private final String permission;

            public static /* synthetic */ RequestPermission copy$default(RequestPermission requestPermission, String str, int i, Object obj) {
                if ((i & 1) != 0) {
                    str = requestPermission.permission;
                }
                return requestPermission.copy(str);
            }

            /* JADX INFO: renamed from: component1, reason: from getter */
            public final String getPermission() {
                return this.permission;
            }

            public final RequestPermission copy(String permission) {
                Intrinsics.checkNotNullParameter(permission, "permission");
                return new RequestPermission(permission);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                return (other instanceof RequestPermission) && Intrinsics.areEqual(this.permission, ((RequestPermission) other).permission);
            }

            public int hashCode() {
                return this.permission.hashCode();
            }

            public String toString() {
                return "RequestPermission(permission=" + this.permission + ")";
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public RequestPermission(String permission) {
                super(null);
                Intrinsics.checkNotNullParameter(permission, "permission");
                this.permission = permission;
            }

            public final String getPermission() {
                return this.permission;
            }
        }

        private Action() {
        }

        /* JADX INFO: compiled from: PermissionReducer.kt */
        @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001:\u0001\u0012B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0003J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0013"}, d2 = {"Lcom/box/android/base/presentation/components/permission/PermissionReducer$Action$PermissionRequestResult;", "Lcom/box/android/base/presentation/components/permission/PermissionReducer$Action;", "status", "Lcom/box/android/base/presentation/components/permission/PermissionReducer$Action$PermissionRequestResult$Status;", "<init>", "(Lcom/box/android/base/presentation/components/permission/PermissionReducer$Action$PermissionRequestResult$Status;)V", "getStatus", "()Lcom/box/android/base/presentation/components/permission/PermissionReducer$Action$PermissionRequestResult$Status;", "component1", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "", "other", "", "hashCode", "", "toString", "", "Status", "base_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
        public static final /* data */ class PermissionRequestResult extends Action {
            public static final int $stable = 0;
            private final Status status;

            /* JADX INFO: compiled from: PermissionReducer.kt */
            @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/box/android/base/presentation/components/permission/PermissionReducer$Action$PermissionRequestResult$Status;", "", "<init>", "(Ljava/lang/String;I)V", "GRANTED", "DENIED", "PERMANENTLY_DENIED", "base_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
            public enum Status {
                GRANTED,
                DENIED,
                PERMANENTLY_DENIED;

                private static final /* synthetic */ EnumEntries $ENTRIES = EnumEntriesKt.enumEntries(values());

                public static EnumEntries<Status> getEntries() {
                    return $ENTRIES;
                }
            }

            public static /* synthetic */ PermissionRequestResult copy$default(PermissionRequestResult permissionRequestResult, Status status, int i, Object obj) {
                if ((i & 1) != 0) {
                    status = permissionRequestResult.status;
                }
                return permissionRequestResult.copy(status);
            }

            /* JADX INFO: renamed from: component1, reason: from getter */
            public final Status getStatus() {
                return this.status;
            }

            public final PermissionRequestResult copy(Status status) {
                Intrinsics.checkNotNullParameter(status, "status");
                return new PermissionRequestResult(status);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                return (other instanceof PermissionRequestResult) && this.status == ((PermissionRequestResult) other).status;
            }

            public int hashCode() {
                return this.status.hashCode();
            }

            public String toString() {
                return "PermissionRequestResult(status=" + this.status + ")";
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public PermissionRequestResult(Status status) {
                super(null);
                Intrinsics.checkNotNullParameter(status, "status");
                this.status = status;
            }

            public final Status getStatus() {
                return this.status;
            }
        }

        /* JADX INFO: compiled from: PermissionReducer.kt */
        @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0003J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\t\u0010\u0010\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0011"}, d2 = {"Lcom/box/android/base/presentation/components/permission/PermissionReducer$Action$PermissionGranted;", "Lcom/box/android/base/presentation/components/permission/PermissionReducer$Action;", "permission", "", "<init>", "(Ljava/lang/String;)V", "getPermission", "()Ljava/lang/String;", "component1", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "", "other", "", "hashCode", "", "toString", "base_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
        public static final /* data */ class PermissionGranted extends Action {
            public static final int $stable = 0;
            private final String permission;

            public static /* synthetic */ PermissionGranted copy$default(PermissionGranted permissionGranted, String str, int i, Object obj) {
                if ((i & 1) != 0) {
                    str = permissionGranted.permission;
                }
                return permissionGranted.copy(str);
            }

            /* JADX INFO: renamed from: component1, reason: from getter */
            public final String getPermission() {
                return this.permission;
            }

            public final PermissionGranted copy(String permission) {
                Intrinsics.checkNotNullParameter(permission, "permission");
                return new PermissionGranted(permission);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                return (other instanceof PermissionGranted) && Intrinsics.areEqual(this.permission, ((PermissionGranted) other).permission);
            }

            public int hashCode() {
                return this.permission.hashCode();
            }

            public String toString() {
                return "PermissionGranted(permission=" + this.permission + ")";
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public PermissionGranted(String permission) {
                super(null);
                Intrinsics.checkNotNullParameter(permission, "permission");
                this.permission = permission;
            }

            public final String getPermission() {
                return this.permission;
            }
        }

        /* JADX INFO: compiled from: PermissionReducer.kt */
        @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÇ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÖ\u0003J\t\u0010\b\u001a\u00020\tHÖ\u0001J\t\u0010\n\u001a\u00020\u000bHÖ\u0001¨\u0006\f"}, d2 = {"Lcom/box/android/base/presentation/components/permission/PermissionReducer$Action$DismissPermanentDenialDialog;", "Lcom/box/android/base/presentation/components/permission/PermissionReducer$Action;", "<init>", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "base_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
        public static final /* data */ class DismissPermanentDenialDialog extends Action {
            public static final int $stable = 0;
            public static final DismissPermanentDenialDialog INSTANCE = new DismissPermanentDenialDialog();

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof DismissPermanentDenialDialog)) {
                    return false;
                }
                return true;
            }

            public int hashCode() {
                return 1367916589;
            }

            public String toString() {
                return "DismissPermanentDenialDialog";
            }

            private DismissPermanentDenialDialog() {
                super(null);
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.box.android.cpl.Reducable
    public ReducerResult<State, Action> reduce(State state, Action action) {
        Intrinsics.checkNotNullParameter(state, "state");
        Intrinsics.checkNotNullParameter(action, "action");
        int i = 2;
        Effect effect = null;
        Object[] objArr = 0;
        Object[] objArr2 = 0;
        Object[] objArr3 = 0;
        Object[] objArr4 = 0;
        Object[] objArr5 = 0;
        Object[] objArr6 = 0;
        Object[] objArr7 = 0;
        Object[] objArr8 = 0;
        Object[] objArr9 = 0;
        Object[] objArr10 = 0;
        Object[] objArr11 = 0;
        if (action instanceof Action.RequestPermission) {
            return new ReducerResult<>(State.copy$default(state, new PermissionRequest(((Action.RequestPermission) action).getPermission()), false, 2, null), effect, i, objArr11 == true ? 1 : 0);
        }
        if (action instanceof Action.PermissionRequestResult) {
            if (state.getPermissionRequest() != null) {
                int i2 = WhenMappings.$EnumSwitchMapping$0[((Action.PermissionRequestResult) action).getStatus().ordinal()];
                if (i2 == 1) {
                    return new ReducerResult<>(State.copy$default(state, null, false, 2, null), new Effect(new Action.PermissionGranted(state.getPermissionRequest().getPermission())));
                }
                if (i2 == 2) {
                    return new ReducerResult<>(State.copy$default(state, null, false, 2, null), objArr8 == true ? 1 : 0, i, objArr7 == true ? 1 : 0);
                }
                if (i2 != 3) {
                    throw new NoWhenBranchMatchedException();
                }
                return new ReducerResult<>(state.copy(null, true), objArr10 == true ? 1 : 0, i, objArr9 == true ? 1 : 0);
            }
            return new ReducerResult<>(state, objArr6 == true ? 1 : 0, i, objArr5 == true ? 1 : 0);
        }
        if (action instanceof Action.PermissionGranted) {
            return new ReducerResult<>(state, objArr4 == true ? 1 : 0, i, objArr3 == true ? 1 : 0);
        }
        if (!(action instanceof Action.DismissPermanentDenialDialog)) {
            throw new NoWhenBranchMatchedException();
        }
        return new ReducerResult<>(State.copy$default(state, null, false, 1, null), objArr2 == true ? 1 : 0, i, objArr == true ? 1 : 0);
    }
}
