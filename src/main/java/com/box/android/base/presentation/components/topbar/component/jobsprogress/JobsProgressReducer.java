package com.box.android.base.presentation.components.topbar.component.jobsprogress;

import androidx.exifinterface.media.ExifInterface;
import com.box.android.cpl.Effect;
import com.box.android.cpl.EffectKt;
import com.box.android.cpl.Reducable;
import com.box.android.cpl.Reduce;
import com.box.android.cpl.ReducerResult;
import com.box.android.domain.analytics.BoxAmplitudeAnalytics;
import com.box.android.domain.models.JobInfo;
import com.box.android.domain.models.JobInfoKt;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.FlowKt;
import kotlinx.coroutines.flow.internal.CombineKt;

/* JADX INFO: compiled from: JobsProgressReducer.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0007\u0018\u0000 \u00162\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0005\u0012\u0013\u0014\u0015\u0016B\u0011\b\u0007\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u001b\u0010\f\u001a\u00020\r2\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00100\u000fH\u0002¢\u0006\u0002\u0010\u0011R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R \u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\tX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0017"}, d2 = {"Lcom/box/android/base/presentation/components/topbar/component/jobsprogress/JobsProgressReducer;", "Lcom/box/android/cpl/Reducable;", "Lcom/box/android/base/presentation/components/topbar/component/jobsprogress/JobsProgressReducer$State;", "Lcom/box/android/base/presentation/components/topbar/component/jobsprogress/JobsProgressReducer$Action;", "environment", "Lcom/box/android/base/presentation/components/topbar/component/jobsprogress/JobsProgressEnvironment;", "<init>", "(Lcom/box/android/base/presentation/components/topbar/component/jobsprogress/JobsProgressEnvironment;)V", "build", "Lcom/box/android/cpl/Reduce;", "getBuild", "()Lcom/box/android/cpl/Reduce;", "calculateProgressStatus", "Lcom/box/android/base/presentation/components/topbar/component/jobsprogress/JobsProgressReducer$StatusIndicationState;", "statuses", "", "Lcom/box/android/domain/models/JobInfo$Status;", "([Lcom/box/android/domain/models/JobInfo$Status;)Lcom/box/android/base/presentation/components/topbar/component/jobsprogress/JobsProgressReducer$StatusIndicationState;", "State", "StatusIndicationState", "JobsCollectiveStatus", "Action", "Companion", "base_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class JobsProgressReducer implements Reducable<State, Action> {
    private static final String STATUS_SUBSCRIPTION_ID = "StatusSubscription";
    private final Reduce<State, Action> build;
    private final JobsProgressEnvironment environment;
    public static final int $stable = 8;

    /* JADX INFO: compiled from: JobsProgressReducer.kt */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/box/android/base/presentation/components/topbar/component/jobsprogress/JobsProgressReducer$JobsCollectiveStatus;", "", "<init>", "(Ljava/lang/String;I)V", "ERROR", "DONE", "IN_PROGRESS", "base_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public enum JobsCollectiveStatus {
        ERROR,
        DONE,
        IN_PROGRESS;

        private static final /* synthetic */ EnumEntries $ENTRIES = EnumEntriesKt.enumEntries(values());

        public static EnumEntries<JobsCollectiveStatus> getEntries() {
            return $ENTRIES;
        }
    }

    @Inject
    public JobsProgressReducer(JobsProgressEnvironment environment) {
        Intrinsics.checkNotNullParameter(environment, "environment");
        this.environment = environment;
        this.build = new Reduce<>(new Function2() { // from class: com.box.android.base.presentation.components.topbar.component.jobsprogress.JobsProgressReducer$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(Object obj, Object obj2) {
                return JobsProgressReducer.build$lambda$0(this.f$0, (JobsProgressReducer.State) obj, (JobsProgressReducer.Action) obj2);
            }
        });
    }

    @Override // com.box.android.cpl.Reducable
    public /* bridge */ ReducerResult<State, Action> reduce(State state, Action action) {
        return Reducable.DefaultImpls.reduce(this, state, action);
    }

    /* JADX INFO: compiled from: JobsProgressReducer.kt */
    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u0013\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u000b\u0010\b\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0015\u0010\t\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0011"}, d2 = {"Lcom/box/android/base/presentation/components/topbar/component/jobsprogress/JobsProgressReducer$State;", "", "status", "Lcom/box/android/base/presentation/components/topbar/component/jobsprogress/JobsProgressReducer$StatusIndicationState;", "<init>", "(Lcom/box/android/base/presentation/components/topbar/component/jobsprogress/JobsProgressReducer$StatusIndicationState;)V", "getStatus", "()Lcom/box/android/base/presentation/components/topbar/component/jobsprogress/JobsProgressReducer$StatusIndicationState;", "component1", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "", "other", "hashCode", "", "toString", "", "base_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final /* data */ class State {
        public static final int $stable = 0;
        private final StatusIndicationState status;

        /* JADX WARN: Multi-variable type inference failed */
        public State() {
            this(null, 1, 0 == true ? 1 : 0);
        }

        public static /* synthetic */ State copy$default(State state, StatusIndicationState statusIndicationState, int i, Object obj) {
            if ((i & 1) != 0) {
                statusIndicationState = state.status;
            }
            return state.copy(statusIndicationState);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final StatusIndicationState getStatus() {
            return this.status;
        }

        public final State copy(StatusIndicationState status) {
            return new State(status);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            return (other instanceof State) && Intrinsics.areEqual(this.status, ((State) other).status);
        }

        public int hashCode() {
            StatusIndicationState statusIndicationState = this.status;
            if (statusIndicationState == null) {
                return 0;
            }
            return statusIndicationState.hashCode();
        }

        public String toString() {
            return "State(status=" + this.status + ")";
        }

        public State(StatusIndicationState statusIndicationState) {
            this.status = statusIndicationState;
        }

        public /* synthetic */ State(StatusIndicationState statusIndicationState, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? null : statusIndicationState);
        }

        public final StatusIndicationState getStatus() {
            return this.status;
        }
    }

    /* JADX INFO: compiled from: JobsProgressReducer.kt */
    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0015HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0016"}, d2 = {"Lcom/box/android/base/presentation/components/topbar/component/jobsprogress/JobsProgressReducer$StatusIndicationState;", "", "collectiveJobsProgress", "", "collectiveJobsStatus", "Lcom/box/android/base/presentation/components/topbar/component/jobsprogress/JobsProgressReducer$JobsCollectiveStatus;", "<init>", "(FLcom/box/android/base/presentation/components/topbar/component/jobsprogress/JobsProgressReducer$JobsCollectiveStatus;)V", "getCollectiveJobsProgress", "()F", "getCollectiveJobsStatus", "()Lcom/box/android/base/presentation/components/topbar/component/jobsprogress/JobsProgressReducer$JobsCollectiveStatus;", "component1", "component2", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "", "other", "hashCode", "", "toString", "", "base_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final /* data */ class StatusIndicationState {
        public static final int $stable = 0;
        private final float collectiveJobsProgress;
        private final JobsCollectiveStatus collectiveJobsStatus;

        public static /* synthetic */ StatusIndicationState copy$default(StatusIndicationState statusIndicationState, float f, JobsCollectiveStatus jobsCollectiveStatus, int i, Object obj) {
            if ((i & 1) != 0) {
                f = statusIndicationState.collectiveJobsProgress;
            }
            if ((i & 2) != 0) {
                jobsCollectiveStatus = statusIndicationState.collectiveJobsStatus;
            }
            return statusIndicationState.copy(f, jobsCollectiveStatus);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final float getCollectiveJobsProgress() {
            return this.collectiveJobsProgress;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final JobsCollectiveStatus getCollectiveJobsStatus() {
            return this.collectiveJobsStatus;
        }

        public final StatusIndicationState copy(float collectiveJobsProgress, JobsCollectiveStatus collectiveJobsStatus) {
            Intrinsics.checkNotNullParameter(collectiveJobsStatus, "collectiveJobsStatus");
            return new StatusIndicationState(collectiveJobsProgress, collectiveJobsStatus);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof StatusIndicationState)) {
                return false;
            }
            StatusIndicationState statusIndicationState = (StatusIndicationState) other;
            return Float.compare(this.collectiveJobsProgress, statusIndicationState.collectiveJobsProgress) == 0 && this.collectiveJobsStatus == statusIndicationState.collectiveJobsStatus;
        }

        public int hashCode() {
            return (Float.hashCode(this.collectiveJobsProgress) * 31) + this.collectiveJobsStatus.hashCode();
        }

        public String toString() {
            return "StatusIndicationState(collectiveJobsProgress=" + this.collectiveJobsProgress + ", collectiveJobsStatus=" + this.collectiveJobsStatus + ")";
        }

        public StatusIndicationState(float f, JobsCollectiveStatus collectiveJobsStatus) {
            Intrinsics.checkNotNullParameter(collectiveJobsStatus, "collectiveJobsStatus");
            this.collectiveJobsProgress = f;
            this.collectiveJobsStatus = collectiveJobsStatus;
        }

        public final float getCollectiveJobsProgress() {
            return this.collectiveJobsProgress;
        }

        public final JobsCollectiveStatus getCollectiveJobsStatus() {
            return this.collectiveJobsStatus;
        }
    }

    /* JADX INFO: compiled from: JobsProgressReducer.kt */
    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b7\u0018\u00002\u00020\u0001:\u0004\u0004\u0005\u0006\u0007B\t\b\u0004¢\u0006\u0004\b\u0002\u0010\u0003\u0082\u0001\u0004\b\t\n\u000b¨\u0006\f"}, d2 = {"Lcom/box/android/base/presentation/components/topbar/component/jobsprogress/JobsProgressReducer$Action;", "", "<init>", "()V", "InitProgressIndication", "Load", "SubscribeToStatuses", "UpdateProgress", "Lcom/box/android/base/presentation/components/topbar/component/jobsprogress/JobsProgressReducer$Action$InitProgressIndication;", "Lcom/box/android/base/presentation/components/topbar/component/jobsprogress/JobsProgressReducer$Action$Load;", "Lcom/box/android/base/presentation/components/topbar/component/jobsprogress/JobsProgressReducer$Action$SubscribeToStatuses;", "Lcom/box/android/base/presentation/components/topbar/component/jobsprogress/JobsProgressReducer$Action$UpdateProgress;", "base_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static abstract class Action {
        public static final int $stable = 0;

        public /* synthetic */ Action(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* JADX INFO: compiled from: JobsProgressReducer.kt */
        @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÇ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÖ\u0003J\t\u0010\b\u001a\u00020\tHÖ\u0001J\t\u0010\n\u001a\u00020\u000bHÖ\u0001¨\u0006\f"}, d2 = {"Lcom/box/android/base/presentation/components/topbar/component/jobsprogress/JobsProgressReducer$Action$InitProgressIndication;", "Lcom/box/android/base/presentation/components/topbar/component/jobsprogress/JobsProgressReducer$Action;", "<init>", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "base_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
        public static final /* data */ class InitProgressIndication extends Action {
            public static final int $stable = 0;
            public static final InitProgressIndication INSTANCE = new InitProgressIndication();

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof InitProgressIndication)) {
                    return false;
                }
                return true;
            }

            public int hashCode() {
                return 611050736;
            }

            public String toString() {
                return "InitProgressIndication";
            }

            private InitProgressIndication() {
                super(null);
            }
        }

        private Action() {
        }

        /* JADX INFO: compiled from: JobsProgressReducer.kt */
        @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÇ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÖ\u0003J\t\u0010\b\u001a\u00020\tHÖ\u0001J\t\u0010\n\u001a\u00020\u000bHÖ\u0001¨\u0006\f"}, d2 = {"Lcom/box/android/base/presentation/components/topbar/component/jobsprogress/JobsProgressReducer$Action$Load;", "Lcom/box/android/base/presentation/components/topbar/component/jobsprogress/JobsProgressReducer$Action;", "<init>", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "base_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
        public static final /* data */ class Load extends Action {
            public static final int $stable = 0;
            public static final Load INSTANCE = new Load();

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof Load)) {
                    return false;
                }
                return true;
            }

            public int hashCode() {
                return 130444541;
            }

            public String toString() {
                return "Load";
            }

            private Load() {
                super(null);
            }
        }

        /* JADX INFO: compiled from: JobsProgressReducer.kt */
        @Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u001b\u0012\u0012\u0010\u0002\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u00040\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u0015\u0010\n\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u00040\u0003HÆ\u0003J\u001f\u0010\u000b\u001a\u00020\u00002\u0014\b\u0002\u0010\u0002\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u00040\u0003HÆ\u0001J\u0013\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fHÖ\u0003J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001R\u001d\u0010\u0002\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\t¨\u0006\u0014"}, d2 = {"Lcom/box/android/base/presentation/components/topbar/component/jobsprogress/JobsProgressReducer$Action$SubscribeToStatuses;", "Lcom/box/android/base/presentation/components/topbar/component/jobsprogress/JobsProgressReducer$Action;", "statusFlows", "", "Lkotlinx/coroutines/flow/Flow;", "Lcom/box/android/domain/models/JobInfo$Status;", "<init>", "(Ljava/util/List;)V", "getStatusFlows", "()Ljava/util/List;", "component1", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "", "other", "", "hashCode", "", "toString", "", "base_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
        public static final /* data */ class SubscribeToStatuses extends Action {
            public static final int $stable = 8;
            private final List<Flow<JobInfo.Status>> statusFlows;

            /* JADX WARN: Multi-variable type inference failed */
            public static /* synthetic */ SubscribeToStatuses copy$default(SubscribeToStatuses subscribeToStatuses, List list, int i, Object obj) {
                if ((i & 1) != 0) {
                    list = subscribeToStatuses.statusFlows;
                }
                return subscribeToStatuses.copy(list);
            }

            public final List<Flow<JobInfo.Status>> component1() {
                return this.statusFlows;
            }

            public final SubscribeToStatuses copy(List<? extends Flow<? extends JobInfo.Status>> statusFlows) {
                Intrinsics.checkNotNullParameter(statusFlows, "statusFlows");
                return new SubscribeToStatuses(statusFlows);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                return (other instanceof SubscribeToStatuses) && Intrinsics.areEqual(this.statusFlows, ((SubscribeToStatuses) other).statusFlows);
            }

            public int hashCode() {
                return this.statusFlows.hashCode();
            }

            public String toString() {
                return "SubscribeToStatuses(statusFlows=" + this.statusFlows + ")";
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            public SubscribeToStatuses(List<? extends Flow<? extends JobInfo.Status>> statusFlows) {
                super(null);
                Intrinsics.checkNotNullParameter(statusFlows, "statusFlows");
                this.statusFlows = statusFlows;
            }

            public final List<Flow<JobInfo.Status>> getStatusFlows() {
                return this.statusFlows;
            }
        }

        /* JADX INFO: compiled from: JobsProgressReducer.kt */
        @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0003J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0012"}, d2 = {"Lcom/box/android/base/presentation/components/topbar/component/jobsprogress/JobsProgressReducer$Action$UpdateProgress;", "Lcom/box/android/base/presentation/components/topbar/component/jobsprogress/JobsProgressReducer$Action;", "newStatus", "Lcom/box/android/base/presentation/components/topbar/component/jobsprogress/JobsProgressReducer$StatusIndicationState;", "<init>", "(Lcom/box/android/base/presentation/components/topbar/component/jobsprogress/JobsProgressReducer$StatusIndicationState;)V", "getNewStatus", "()Lcom/box/android/base/presentation/components/topbar/component/jobsprogress/JobsProgressReducer$StatusIndicationState;", "component1", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "", "other", "", "hashCode", "", "toString", "", "base_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
        public static final /* data */ class UpdateProgress extends Action {
            public static final int $stable = 0;
            private final StatusIndicationState newStatus;

            public static /* synthetic */ UpdateProgress copy$default(UpdateProgress updateProgress, StatusIndicationState statusIndicationState, int i, Object obj) {
                if ((i & 1) != 0) {
                    statusIndicationState = updateProgress.newStatus;
                }
                return updateProgress.copy(statusIndicationState);
            }

            /* JADX INFO: renamed from: component1, reason: from getter */
            public final StatusIndicationState getNewStatus() {
                return this.newStatus;
            }

            public final UpdateProgress copy(StatusIndicationState newStatus) {
                Intrinsics.checkNotNullParameter(newStatus, "newStatus");
                return new UpdateProgress(newStatus);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                return (other instanceof UpdateProgress) && Intrinsics.areEqual(this.newStatus, ((UpdateProgress) other).newStatus);
            }

            public int hashCode() {
                return this.newStatus.hashCode();
            }

            public String toString() {
                return "UpdateProgress(newStatus=" + this.newStatus + ")";
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public UpdateProgress(StatusIndicationState newStatus) {
                super(null);
                Intrinsics.checkNotNullParameter(newStatus, "newStatus");
                this.newStatus = newStatus;
            }

            public final StatusIndicationState getNewStatus() {
                return this.newStatus;
            }
        }
    }

    @Override // com.box.android.cpl.Reducable
    public Reducable<State, Action> getBuild() {
        return this.build;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public static final ReducerResult build$lambda$0(final JobsProgressReducer jobsProgressReducer, State state, Action action) {
        Intrinsics.checkNotNullParameter(state, "state");
        Intrinsics.checkNotNullParameter(action, "action");
        Effect effect = null;
        Object[] objArr = 0;
        if (Intrinsics.areEqual(action, Action.InitProgressIndication.INSTANCE)) {
            return new ReducerResult(state, EffectKt.toEffect(FlowKt.flow(new JobsProgressReducer$build$1$1(jobsProgressReducer, null))).cancellable("InitProgressIndication", true));
        }
        if (Intrinsics.areEqual(action, Action.Load.INSTANCE)) {
            return new ReducerResult(state, EffectKt.toEffect(FlowKt.flow(new JobsProgressReducer$build$1$2(jobsProgressReducer, null))));
        }
        if (action instanceof Action.SubscribeToStatuses) {
            List<Flow<JobInfo.Status>> statusFlows = ((Action.SubscribeToStatuses) action).getStatusFlows();
            if (statusFlows.isEmpty()) {
                return new ReducerResult(state.copy(null), Effect.INSTANCE.cancel(STATUS_SUBSCRIPTION_ID));
            }
            final Flow[] flowArr = (Flow[]) CollectionsKt.toList(statusFlows).toArray(new Flow[0]);
            return new ReducerResult(state, EffectKt.toEffect(new Flow<Action.UpdateProgress>() { // from class: com.box.android.base.presentation.components.topbar.component.jobsprogress.JobsProgressReducer$build$lambda$0$$inlined$combine$1

                /* JADX INFO: renamed from: com.box.android.base.presentation.components.topbar.component.jobsprogress.JobsProgressReducer$build$lambda$0$$inlined$combine$1$3, reason: invalid class name */
                /* JADX INFO: compiled from: Zip.kt */
                @Metadata(d1 = {"\u0000\u0016\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0000\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002\"\u0006\b\u0001\u0010\u0003\u0018\u0001*\b\u0012\u0004\u0012\u0002H\u00020\u00042\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u0002H\u00030\u0006H\n¨\u0006\u0007"}, d2 = {"<anonymous>", "", "R", ExifInterface.GPS_DIRECTION_TRUE, "Lkotlinx/coroutines/flow/FlowCollector;", "it", "", "kotlinx/coroutines/flow/FlowKt__ZipKt$combine$6$2"}, k = 3, mv = {2, 2, 0}, xi = 48)
                @DebugMetadata(c = "com.box.android.base.presentation.components.topbar.component.jobsprogress.JobsProgressReducer$build$lambda$0$$inlined$combine$1$3", f = "JobsProgressReducer.kt", i = {0, 0}, l = {288}, m = "invokeSuspend", n = {"$this$combineInternal", "it"}, s = {"L$0", "L$1"}, v = 1)
                public static final class AnonymousClass3 extends SuspendLambda implements Function3<FlowCollector<? super JobsProgressReducer.Action.UpdateProgress>, JobInfo.Status[], Continuation<? super Unit>, Object> {
                    private /* synthetic */ Object L$0;
                    /* synthetic */ Object L$1;
                    int label;
                    final /* synthetic */ JobsProgressReducer this$0;

                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    public AnonymousClass3(Continuation continuation, JobsProgressReducer jobsProgressReducer) {
                        super(3, continuation);
                        this.this$0 = jobsProgressReducer;
                    }

                    @Override // kotlin.jvm.functions.Function3
                    public final Object invoke(FlowCollector<? super JobsProgressReducer.Action.UpdateProgress> flowCollector, JobInfo.Status[] statusArr, Continuation<? super Unit> continuation) {
                        AnonymousClass3 anonymousClass3 = new AnonymousClass3(continuation, this.this$0);
                        anonymousClass3.L$0 = flowCollector;
                        anonymousClass3.L$1 = statusArr;
                        return anonymousClass3.invokeSuspend(Unit.INSTANCE);
                    }

                    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                    public final Object invokeSuspend(Object obj) {
                        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                        int i = this.label;
                        if (i == 0) {
                            ResultKt.throwOnFailure(obj);
                            FlowCollector flowCollector = (FlowCollector) this.L$0;
                            Object[] objArr = (Object[]) this.L$1;
                            JobsProgressReducer.Action.UpdateProgress updateProgress = new JobsProgressReducer.Action.UpdateProgress(this.this$0.calculateProgressStatus((JobInfo.Status[]) objArr));
                            this.L$0 = SpillingKt.nullOutSpilledVariable(flowCollector);
                            this.L$1 = SpillingKt.nullOutSpilledVariable(objArr);
                            this.label = 1;
                            if (flowCollector.emit(updateProgress, this) == coroutine_suspended) {
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

                @Override // kotlinx.coroutines.flow.Flow
                public Object collect(FlowCollector<? super JobsProgressReducer.Action.UpdateProgress> flowCollector, Continuation continuation) {
                    Flow[] flowArr2 = flowArr;
                    final Flow[] flowArr3 = flowArr;
                    Object objCombineInternal = CombineKt.combineInternal(flowCollector, flowArr2, new Function0<JobInfo.Status[]>() { // from class: com.box.android.base.presentation.components.topbar.component.jobsprogress.JobsProgressReducer$build$lambda$0$$inlined$combine$1.2
                        @Override // kotlin.jvm.functions.Function0
                        public final JobInfo.Status[] invoke() {
                            return new JobInfo.Status[flowArr3.length];
                        }
                    }, new AnonymousClass3(null, jobsProgressReducer), continuation);
                    return objCombineInternal == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objCombineInternal : Unit.INSTANCE;
                }
            }).cancellable(STATUS_SUBSCRIPTION_ID, true));
        }
        if (!(action instanceof Action.UpdateProgress)) {
            throw new NoWhenBranchMatchedException();
        }
        return new ReducerResult(state.copy(((Action.UpdateProgress) action).getNewStatus()), effect, 2, objArr == true ? 1 : 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final StatusIndicationState calculateProgressStatus(JobInfo.Status[] statuses) {
        JobsCollectiveStatus jobsCollectiveStatus;
        ArrayList<Float> arrayList = new ArrayList(statuses.length);
        int length = statuses.length;
        int i = 0;
        while (true) {
            if (i >= length) {
                break;
            }
            JobInfo.Status status = statuses[i];
            Float fValueOf = null;
            if (status instanceof JobInfo.Status.Running) {
                JobInfo.Progress progress = ((JobInfo.Status.Running) status).getProgress();
                if (progress != null) {
                    fValueOf = Float.valueOf(JobInfoKt.progressInPercents(progress));
                }
            } else if (status instanceof JobInfo.Status.Paused) {
                JobInfo.Progress progress2 = ((JobInfo.Status.Paused) status).getProgress();
                if (progress2 != null) {
                    fValueOf = Float.valueOf(JobInfoKt.progressInPercents(progress2));
                }
            } else if (status instanceof JobInfo.Status.Failed) {
                fValueOf = Float.valueOf(1.0f);
            } else {
                fValueOf = status instanceof JobInfo.Status.Succeeded ? Float.valueOf(1.0f) : Float.valueOf(0.0f);
            }
            arrayList.add(fValueOf);
            i++;
        }
        ArrayList arrayList2 = new ArrayList();
        for (Float f : arrayList) {
            if (f != null) {
                arrayList2.add(f);
            }
        }
        ArrayList arrayList3 = arrayList2;
        float fSumOfFloat = arrayList3.isEmpty() ? 0.0f : (CollectionsKt.sumOfFloat(arrayList3) / arrayList3.size()) * 100;
        for (JobInfo.Status status2 : statuses) {
            if (status2 instanceof JobInfo.Status.Failed) {
                jobsCollectiveStatus = JobsCollectiveStatus.ERROR;
                return new StatusIndicationState(fSumOfFloat, jobsCollectiveStatus);
            }
        }
        for (JobInfo.Status status3 : statuses) {
            if (!(status3 instanceof JobInfo.Status.Succeeded)) {
                jobsCollectiveStatus = JobsCollectiveStatus.IN_PROGRESS;
                return new StatusIndicationState(fSumOfFloat, jobsCollectiveStatus);
            }
        }
        jobsCollectiveStatus = JobsCollectiveStatus.DONE;
        return new StatusIndicationState(fSumOfFloat, jobsCollectiveStatus);
    }
}
