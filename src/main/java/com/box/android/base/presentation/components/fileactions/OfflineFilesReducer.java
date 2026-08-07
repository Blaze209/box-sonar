package com.box.android.base.presentation.components.fileactions;

import com.box.android.cpl.Effect;
import com.box.android.cpl.Reducable;
import com.box.android.cpl.Reduce;
import com.box.android.cpl.ReducerResult;
import com.box.android.domain.analytics.BoxAmplitudeAnalytics;
import com.box.android.domain.models.AdminSettingsDomainError;
import com.box.android.domain.models.item.ItemModel;
import com.box.android.domain.models.item.PermissionsModel;
import com.box.android.domain.services.IOfflineService;
import com.box.android.domain.usecases.jobs.JobTags;
import com.box.android.domain.utils.result.Result;
import com.facebook.react.modules.dialog.AlertFragment;
import com.pspdfkit.analytics.Analytics;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: OfflineFilesReducer.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0007\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0002\u0012\u0013B\u000f\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J$\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u000f2\u0006\u0010\u0010\u001a\u00020\u00022\u0006\u0010\u0011\u001a\u00020\u0003H\u0002R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR \u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u000bX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\r¨\u0006\u0014"}, d2 = {"Lcom/box/android/base/presentation/components/fileactions/OfflineFilesReducer;", "Lcom/box/android/cpl/Reducable;", "Lcom/box/android/base/presentation/components/fileactions/OfflineFilesReducer$State;", "Lcom/box/android/base/presentation/components/fileactions/OfflineFilesReducer$Action;", "environment", "Lcom/box/android/base/presentation/components/fileactions/OfflineFilesEnvironment;", "<init>", "(Lcom/box/android/base/presentation/components/fileactions/OfflineFilesEnvironment;)V", "getEnvironment", "()Lcom/box/android/base/presentation/components/fileactions/OfflineFilesEnvironment;", "build", "Lcom/box/android/cpl/Reduce;", "getBuild", "()Lcom/box/android/cpl/Reduce;", "reduceOffline", "Lcom/box/android/cpl/ReducerResult;", "state", Analytics.Data.ACTION, "Action", "State", "base_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class OfflineFilesReducer implements Reducable<State, Action> {
    public static final int $stable = 8;
    private final Reduce<State, Action> build;
    private final OfflineFilesEnvironment environment;

    public OfflineFilesReducer(OfflineFilesEnvironment environment) {
        Intrinsics.checkNotNullParameter(environment, "environment");
        this.environment = environment;
        this.build = new Reduce<>(new OfflineFilesReducer$build$1(this));
    }

    public final OfflineFilesEnvironment getEnvironment() {
        return this.environment;
    }

    @Override // com.box.android.cpl.Reducable
    public /* bridge */ ReducerResult<State, Action> reduce(State state, Action action) {
        return Reducable.DefaultImpls.reduce(this, state, action);
    }

    /* JADX INFO: compiled from: OfflineFilesReducer.kt */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b7\u0018\u00002\u00020\u0001:\u0005\u0004\u0005\u0006\u0007\bB\t\b\u0004¢\u0006\u0004\b\u0002\u0010\u0003\u0082\u0001\u0005\t\n\u000b\f\r¨\u0006\u000e"}, d2 = {"Lcom/box/android/base/presentation/components/fileactions/OfflineFilesReducer$Action;", "", "<init>", "()V", "StartMakeAvailableOffline", "MakeAvailableOffline", "StartRemoveFromOffline", "AdminSettingsErrorOccurred", "Finish", "Lcom/box/android/base/presentation/components/fileactions/OfflineFilesReducer$Action$AdminSettingsErrorOccurred;", "Lcom/box/android/base/presentation/components/fileactions/OfflineFilesReducer$Action$Finish;", "Lcom/box/android/base/presentation/components/fileactions/OfflineFilesReducer$Action$MakeAvailableOffline;", "Lcom/box/android/base/presentation/components/fileactions/OfflineFilesReducer$Action$StartMakeAvailableOffline;", "Lcom/box/android/base/presentation/components/fileactions/OfflineFilesReducer$Action$StartRemoveFromOffline;", "base_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static abstract class Action {
        public static final int $stable = 0;

        public /* synthetic */ Action(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* JADX INFO: compiled from: OfflineFilesReducer.kt */
        @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÇ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÖ\u0003J\t\u0010\b\u001a\u00020\tHÖ\u0001J\t\u0010\n\u001a\u00020\u000bHÖ\u0001¨\u0006\f"}, d2 = {"Lcom/box/android/base/presentation/components/fileactions/OfflineFilesReducer$Action$StartMakeAvailableOffline;", "Lcom/box/android/base/presentation/components/fileactions/OfflineFilesReducer$Action;", "<init>", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "base_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
        public static final /* data */ class StartMakeAvailableOffline extends Action {
            public static final int $stable = 0;
            public static final StartMakeAvailableOffline INSTANCE = new StartMakeAvailableOffline();

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof StartMakeAvailableOffline)) {
                    return false;
                }
                return true;
            }

            public int hashCode() {
                return 972222759;
            }

            public String toString() {
                return "StartMakeAvailableOffline";
            }

            private StartMakeAvailableOffline() {
                super(null);
            }
        }

        private Action() {
        }

        /* JADX INFO: compiled from: OfflineFilesReducer.kt */
        @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u00032\b\u0010\u000b\u001a\u0004\u0018\u00010\fHÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0011"}, d2 = {"Lcom/box/android/base/presentation/components/fileactions/OfflineFilesReducer$Action$MakeAvailableOffline;", "Lcom/box/android/base/presentation/components/fileactions/OfflineFilesReducer$Action;", "shouldSaveOriginal", "", "<init>", "(Z)V", "getShouldSaveOriginal", "()Z", "component1", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "other", "", "hashCode", "", "toString", "", "base_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
        public static final /* data */ class MakeAvailableOffline extends Action {
            public static final int $stable = 0;
            private final boolean shouldSaveOriginal;

            public static /* synthetic */ MakeAvailableOffline copy$default(MakeAvailableOffline makeAvailableOffline, boolean z, int i, Object obj) {
                if ((i & 1) != 0) {
                    z = makeAvailableOffline.shouldSaveOriginal;
                }
                return makeAvailableOffline.copy(z);
            }

            /* JADX INFO: renamed from: component1, reason: from getter */
            public final boolean getShouldSaveOriginal() {
                return this.shouldSaveOriginal;
            }

            public final MakeAvailableOffline copy(boolean shouldSaveOriginal) {
                return new MakeAvailableOffline(shouldSaveOriginal);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                return (other instanceof MakeAvailableOffline) && this.shouldSaveOriginal == ((MakeAvailableOffline) other).shouldSaveOriginal;
            }

            public int hashCode() {
                return Boolean.hashCode(this.shouldSaveOriginal);
            }

            public String toString() {
                return "MakeAvailableOffline(shouldSaveOriginal=" + this.shouldSaveOriginal + ")";
            }

            public MakeAvailableOffline(boolean z) {
                super(null);
                this.shouldSaveOriginal = z;
            }

            public final boolean getShouldSaveOriginal() {
                return this.shouldSaveOriginal;
            }
        }

        /* JADX INFO: compiled from: OfflineFilesReducer.kt */
        @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÇ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÖ\u0003J\t\u0010\b\u001a\u00020\tHÖ\u0001J\t\u0010\n\u001a\u00020\u000bHÖ\u0001¨\u0006\f"}, d2 = {"Lcom/box/android/base/presentation/components/fileactions/OfflineFilesReducer$Action$StartRemoveFromOffline;", "Lcom/box/android/base/presentation/components/fileactions/OfflineFilesReducer$Action;", "<init>", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "base_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
        public static final /* data */ class StartRemoveFromOffline extends Action {
            public static final int $stable = 0;
            public static final StartRemoveFromOffline INSTANCE = new StartRemoveFromOffline();

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof StartRemoveFromOffline)) {
                    return false;
                }
                return true;
            }

            public int hashCode() {
                return 1495450582;
            }

            public String toString() {
                return "StartRemoveFromOffline";
            }

            private StartRemoveFromOffline() {
                super(null);
            }
        }

        /* JADX INFO: compiled from: OfflineFilesReducer.kt */
        @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0003J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0012"}, d2 = {"Lcom/box/android/base/presentation/components/fileactions/OfflineFilesReducer$Action$AdminSettingsErrorOccurred;", "Lcom/box/android/base/presentation/components/fileactions/OfflineFilesReducer$Action;", "adminError", "Lcom/box/android/domain/models/AdminSettingsDomainError;", "<init>", "(Lcom/box/android/domain/models/AdminSettingsDomainError;)V", "getAdminError", "()Lcom/box/android/domain/models/AdminSettingsDomainError;", "component1", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "", "other", "", "hashCode", "", "toString", "", "base_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
        public static final /* data */ class AdminSettingsErrorOccurred extends Action {
            public static final int $stable = 8;
            private final AdminSettingsDomainError adminError;

            public static /* synthetic */ AdminSettingsErrorOccurred copy$default(AdminSettingsErrorOccurred adminSettingsErrorOccurred, AdminSettingsDomainError adminSettingsDomainError, int i, Object obj) {
                if ((i & 1) != 0) {
                    adminSettingsDomainError = adminSettingsErrorOccurred.adminError;
                }
                return adminSettingsErrorOccurred.copy(adminSettingsDomainError);
            }

            /* JADX INFO: renamed from: component1, reason: from getter */
            public final AdminSettingsDomainError getAdminError() {
                return this.adminError;
            }

            public final AdminSettingsErrorOccurred copy(AdminSettingsDomainError adminError) {
                Intrinsics.checkNotNullParameter(adminError, "adminError");
                return new AdminSettingsErrorOccurred(adminError);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                return (other instanceof AdminSettingsErrorOccurred) && Intrinsics.areEqual(this.adminError, ((AdminSettingsErrorOccurred) other).adminError);
            }

            public int hashCode() {
                return this.adminError.hashCode();
            }

            public String toString() {
                return "AdminSettingsErrorOccurred(adminError=" + this.adminError + ")";
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public AdminSettingsErrorOccurred(AdminSettingsDomainError adminError) {
                super(null);
                Intrinsics.checkNotNullParameter(adminError, "adminError");
                this.adminError = adminError;
            }

            public final AdminSettingsDomainError getAdminError() {
                return this.adminError;
            }
        }

        /* JADX INFO: compiled from: OfflineFilesReducer.kt */
        @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÇ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÖ\u0003J\t\u0010\b\u001a\u00020\tHÖ\u0001J\t\u0010\n\u001a\u00020\u000bHÖ\u0001¨\u0006\f"}, d2 = {"Lcom/box/android/base/presentation/components/fileactions/OfflineFilesReducer$Action$Finish;", "Lcom/box/android/base/presentation/components/fileactions/OfflineFilesReducer$Action;", "<init>", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "base_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
        public static final /* data */ class Finish extends Action {
            public static final int $stable = 0;
            public static final Finish INSTANCE = new Finish();

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof Finish)) {
                    return false;
                }
                return true;
            }

            public int hashCode() {
                return -89294090;
            }

            public String toString() {
                return "Finish";
            }

            private Finish() {
                super(null);
            }
        }
    }

    /* JADX INFO: compiled from: OfflineFilesReducer.kt */
    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B!\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003J\u000b\u0010\u000e\u001a\u0004\u0018\u00010\u0006HÆ\u0003J%\u0010\u000f\u001a\u00020\u00002\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006HÆ\u0001J\u0013\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001J\t\u0010\u0015\u001a\u00020\u0016HÖ\u0001R\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f¨\u0006\u0017"}, d2 = {"Lcom/box/android/base/presentation/components/fileactions/OfflineFilesReducer$State;", "", AlertFragment.ARG_ITEMS, "", "Lcom/box/android/domain/models/item/ItemModel;", "error", "Lcom/box/android/base/presentation/components/fileactions/FileActionsError;", "<init>", "(Ljava/util/List;Lcom/box/android/base/presentation/components/fileactions/FileActionsError;)V", "getItems", "()Ljava/util/List;", "getError", "()Lcom/box/android/base/presentation/components/fileactions/FileActionsError;", "component1", "component2", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "", "other", "hashCode", "", "toString", "", "base_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final /* data */ class State {
        public static final int $stable = 8;
        private final FileActionsError error;
        private final List<ItemModel> items;

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ State copy$default(State state, List list, FileActionsError fileActionsError, int i, Object obj) {
            if ((i & 1) != 0) {
                list = state.items;
            }
            if ((i & 2) != 0) {
                fileActionsError = state.error;
            }
            return state.copy(list, fileActionsError);
        }

        public final List<ItemModel> component1() {
            return this.items;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final FileActionsError getError() {
            return this.error;
        }

        public final State copy(List<? extends ItemModel> items, FileActionsError error) {
            Intrinsics.checkNotNullParameter(items, "items");
            return new State(items, error);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof State)) {
                return false;
            }
            State state = (State) other;
            return Intrinsics.areEqual(this.items, state.items) && this.error == state.error;
        }

        public int hashCode() {
            int iHashCode = this.items.hashCode() * 31;
            FileActionsError fileActionsError = this.error;
            return iHashCode + (fileActionsError == null ? 0 : fileActionsError.hashCode());
        }

        public String toString() {
            return "State(items=" + this.items + ", error=" + this.error + ")";
        }

        /* JADX WARN: Multi-variable type inference failed */
        public State(List<? extends ItemModel> items, FileActionsError fileActionsError) {
            Intrinsics.checkNotNullParameter(items, "items");
            this.items = items;
            this.error = fileActionsError;
        }

        public /* synthetic */ State(List list, FileActionsError fileActionsError, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this(list, (i & 2) != 0 ? null : fileActionsError);
        }

        public final FileActionsError getError() {
            return this.error;
        }

        public final List<ItemModel> getItems() {
            return this.items;
        }
    }

    @Override // com.box.android.cpl.Reducable
    public Reducable<State, Action> getBuild() {
        return this.build;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final ReducerResult<State, Action> reduceOffline(State state, Action action) {
        boolean z;
        if (action instanceof Action.StartMakeAvailableOffline) {
            List<ItemModel> items = state.getItems();
            if ((items instanceof Collection) && items.isEmpty()) {
                z = true;
            } else {
                Iterator<T> it = items.iterator();
                while (true) {
                    if (it.hasNext()) {
                        PermissionsModel permissions = ((ItemModel) it.next()).getPermissions();
                        if (permissions == null || !permissions.getCanDownload()) {
                            z = false;
                        }
                    } else {
                        z = true;
                    }
                }
            }
            Result<Unit, AdminSettingsDomainError> resultCheckOfflineActionAdminSettings = this.environment.getFileActionsManager().checkOfflineActionAdminSettings();
            if (resultCheckOfflineActionAdminSettings instanceof Result.Error) {
                Result.Error error = (Result.Error) resultCheckOfflineActionAdminSettings;
                return new ReducerResult<>(State.copy$default(state, null, ((AdminSettingsDomainError) error.getValue()) instanceof AdminSettingsDomainError.EncryptedDeviceRequired ? FileActionsError.ENCRYPTED_DEVICE_REQUIRED : FileActionsError.FEATURE_DISABLED, 1, null), new Effect(new Action.AdminSettingsErrorOccurred((AdminSettingsDomainError) error.getValue())));
            }
            if (!(resultCheckOfflineActionAdminSettings instanceof Result.Success)) {
                throw new NoWhenBranchMatchedException();
            }
            if (z) {
                IOfflineService offlineService = this.environment.getOfflineService();
                ItemModel[] itemModelArr = (ItemModel[]) state.getItems().toArray(new ItemModel[0]);
                if (offlineService.isSizeBigEnoughToSaveOnlyPreviews((ItemModel[]) Arrays.copyOf(itemModelArr, itemModelArr.length))) {
                    return new ReducerResult<>(State.copy$default(state, null, FileActionsError.LARGE_FILE_SIZE, 1, null), null, 2, null);
                }
            }
            return new ReducerResult<>(state, new Effect(new Action.MakeAvailableOffline(z)));
        }
        if (action instanceof Action.MakeAvailableOffline) {
            return new ReducerResult<>(State.copy$default(state, null, null, 1, null), Effect.INSTANCE.merge(Effect.INSTANCE.fireAndForget(new AnonymousClass1(state, action, null)), new Effect(Action.Finish.INSTANCE)));
        }
        if (action instanceof Action.StartRemoveFromOffline) {
            return new ReducerResult<>(state, Effect.INSTANCE.merge(Effect.INSTANCE.fireAndForget(new AnonymousClass2(state, null)), new Effect(Action.Finish.INSTANCE)));
        }
        if (action instanceof Action.Finish) {
            return new ReducerResult<>(State.copy$default(state, null, null, 1, null), null, 2, null);
        }
        if (action instanceof Action.AdminSettingsErrorOccurred) {
            return new ReducerResult<>(state, null, 2, null);
        }
        throw new NoWhenBranchMatchedException();
    }

    /* JADX INFO: renamed from: com.box.android.base.presentation.components.fileactions.OfflineFilesReducer$reduceOffline$1, reason: invalid class name */
    /* JADX INFO: compiled from: OfflineFilesReducer.kt */
    @Metadata(d1 = {"\u0000\u0006\n\u0000\n\u0002\u0010\u0002\u0010\u0000\u001a\u00020\u0001H\n"}, d2 = {"<anonymous>", ""}, k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.box.android.base.presentation.components.fileactions.OfflineFilesReducer$reduceOffline$1", f = "OfflineFilesReducer.kt", i = {}, l = {58}, m = "invokeSuspend", n = {}, s = {}, v = 1)
    static final class AnonymousClass1 extends SuspendLambda implements Function1<Continuation<? super Unit>, Object> {
        final /* synthetic */ Action $action;
        final /* synthetic */ State $state;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(State state, Action action, Continuation<? super AnonymousClass1> continuation) {
            super(1, continuation);
            this.$state = state;
            this.$action = action;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Continuation<?> continuation) {
            return OfflineFilesReducer.this.new AnonymousClass1(this.$state, this.$action, continuation);
        }

        @Override // kotlin.jvm.functions.Function1
        public final Object invoke(Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                this.label = 1;
                if (OfflineFilesReducer.this.getEnvironment().getOfflineService().makeAvailableOffline(this.$state.getItems(), ((Action.MakeAvailableOffline) this.$action).getShouldSaveOriginal(), JobTags.JobSource.OFFLINE_SAVE_PREVIEW, this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
            return Unit.INSTANCE;
        }
    }

    /* JADX INFO: renamed from: com.box.android.base.presentation.components.fileactions.OfflineFilesReducer$reduceOffline$2, reason: invalid class name */
    /* JADX INFO: compiled from: OfflineFilesReducer.kt */
    @Metadata(d1 = {"\u0000\u0006\n\u0000\n\u0002\u0010\u0002\u0010\u0000\u001a\u00020\u0001H\n"}, d2 = {"<anonymous>", ""}, k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.box.android.base.presentation.components.fileactions.OfflineFilesReducer$reduceOffline$2", f = "OfflineFilesReducer.kt", i = {}, l = {74}, m = "invokeSuspend", n = {}, s = {}, v = 1)
    static final class AnonymousClass2 extends SuspendLambda implements Function1<Continuation<? super Unit>, Object> {
        final /* synthetic */ State $state;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass2(State state, Continuation<? super AnonymousClass2> continuation) {
            super(1, continuation);
            this.$state = state;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Continuation<?> continuation) {
            return OfflineFilesReducer.this.new AnonymousClass2(this.$state, continuation);
        }

        @Override // kotlin.jvm.functions.Function1
        public final Object invoke(Continuation<? super Unit> continuation) {
            return ((AnonymousClass2) create(continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                this.label = 1;
                if (OfflineFilesReducer.this.getEnvironment().getOfflineService().removeFromOffline(this.$state.getItems(), this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
            return Unit.INSTANCE;
        }
    }
}
