package com.box.android.jobsui;

import com.box.android.common.utilities.CommonBoxUtil;
import com.box.android.coreservices.jobmanager.jobs.DeleteBoxJob;
import com.box.android.cpl.Effect;
import com.box.android.cpl.EffectKt;
import com.box.android.cpl.EmbeddedItem;
import com.box.android.cpl.Identifiable;
import com.box.android.cpl.IdentifiedList;
import com.box.android.cpl.IdentifiedListKt;
import com.box.android.cpl.Reducable;
import com.box.android.cpl.Reduce;
import com.box.android.cpl.ReducerResult;
import com.box.android.cpl.reducers.ForEachReducer;
import com.box.android.domain.analytics.BoxAmplitudeAnalytics;
import com.box.android.domain.jobs.JobId;
import com.box.android.domain.models.DomainError;
import com.box.android.domain.models.JobInfo;
import com.box.android.domain.services.IJobManagerBridgeService;
import com.box.android.domain.services.IJobService;
import com.box.android.domain.utils.result.Result;
import com.pspdfkit.analytics.Analytics;
import java.io.InvalidObjectException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Ref;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KFunction;
import kotlin.reflect.KParameter;
import kotlin.reflect.KProperty1;
import kotlin.reflect.full.KCallables;
import kotlin.reflect.full.KClasses;
import kotlinx.coroutines.BuildersKt__BuildersKt;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.FlowKt;
import kotlinx.coroutines.flow.StateFlow;

/* JADX INFO: compiled from: JobsReducer.kt */
/* JADX INFO: loaded from: classes12.dex */
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0007\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0003\u001a\u001b\u001cB\u0011\b\u0007\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J$\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\t2\u0006\u0010\n\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\fH\u0002J\"\u0010\r\u001a\u000e\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u00100\u000e2\u0006\u0010\u0011\u001a\u00020\u0012H\u0082@¢\u0006\u0002\u0010\u0013J\u0012\u0010\u0014\u001a\u0004\u0018\u00010\u00102\u0006\u0010\n\u001a\u00020\u0002H\u0002J$\u0010\u0015\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\t2\u0006\u0010\n\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\u0016H\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R \u0010\u0017\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019¨\u0006\u001d"}, d2 = {"Lcom/box/android/jobsui/JobsReducer;", "Lcom/box/android/cpl/Reducable;", "Lcom/box/android/jobsui/JobsReducer$State;", "Lcom/box/android/jobsui/JobsReducer$Action;", "environment", "Lcom/box/android/jobsui/JobsUIEnvironment;", "<init>", "(Lcom/box/android/jobsui/JobsUIEnvironment;)V", "handleLoad", "Lcom/box/android/cpl/ReducerResult;", "state", Analytics.Data.ACTION, "Lcom/box/android/jobsui/JobsReducer$Action$Load;", DeleteBoxJob.TYPE, "Lcom/box/android/domain/utils/result/Result;", "", "Lcom/box/android/domain/models/DomainError;", "jobState", "Lcom/box/android/jobsui/JobItemReducer$State;", "(Lcom/box/android/jobsui/JobItemReducer$State;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "deleteSelectedJobs", "handleJobItemAction", "Lcom/box/android/jobsui/JobsReducer$Action$JobItemAction;", "build", "getBuild", "()Lcom/box/android/cpl/Reducable;", "State", "JobsLoadingState", "Action", "jobsui_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class JobsReducer implements Reducable<State, Action> {
    public static final int $stable = 8;
    private final Reducable<State, Action> build;
    private final JobsUIEnvironment environment;

    /* JADX INFO: renamed from: com.box.android.jobsui.JobsReducer$deleteJob$1, reason: invalid class name */
    /* JADX INFO: compiled from: JobsReducer.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.box.android.jobsui.JobsReducer", f = "JobsReducer.kt", i = {0, 1, 1, 2, 2}, l = {121, 127, 129}, m = DeleteBoxJob.TYPE, n = {"jobState", "jobState", "id", "jobState", "id"}, s = {"L$0", "L$0", "L$1", "L$0", "L$1"}, v = 1)
    static final class AnonymousClass1 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        int label;
        /* synthetic */ Object result;

        AnonymousClass1(Continuation<? super AnonymousClass1> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return JobsReducer.this.deleteJob(null, this);
        }
    }

    /* JADX INFO: compiled from: JobsReducer.kt */
    @Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010 \n\u0002\b\r\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001BS\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\u0014\b\u0002\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t0\u0007\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\f\u0012\b\b\u0002\u0010\r\u001a\u00020\u0003¢\u0006\u0004\b\u000e\u0010\u000fJ\t\u0010\u001e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001f\u001a\u00020\u0005HÆ\u0003J\u0015\u0010 \u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t0\u0007HÆ\u0003J\u000b\u0010!\u001a\u0004\u0018\u00010\bHÆ\u0003J\u000b\u0010\"\u001a\u0004\u0018\u00010\fHÆ\u0003J\t\u0010#\u001a\u00020\u0003HÆ\u0003JU\u0010$\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\u0014\b\u0002\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t0\u00072\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\f2\b\b\u0002\u0010\r\u001a\u00020\u0003HÆ\u0001J\u0013\u0010%\u001a\u00020\u00032\b\u0010&\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010'\u001a\u00020(HÖ\u0001J\t\u0010)\u001a\u00020\bHÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0002\u0010\u0010R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u001d\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t0\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0013\u0010\n\u001a\u0004\u0018\u00010\b¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0013\u0010\u000b\u001a\u0004\u0018\u00010\f¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u0011\u0010\r\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u0010R\u0017\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\b0\u001a8F¢\u0006\u0006\u001a\u0004\b\u001b\u0010\u001cR\u0011\u0010\u001d\u001a\u00020\u00038F¢\u0006\u0006\u001a\u0004\b\u001d\u0010\u0010¨\u0006*"}, d2 = {"Lcom/box/android/jobsui/JobsReducer$State;", "", "isClosing", "", "jobsLoadingState", "Lcom/box/android/jobsui/JobsReducer$JobsLoadingState;", "jobsList", "Lcom/box/android/cpl/IdentifiedList;", "", "Lcom/box/android/jobsui/JobItemReducer$State;", "errorText", "previewingJobItem", "Lcom/box/android/jobsui/JobPreview;", "isDeleting", "<init>", "(ZLcom/box/android/jobsui/JobsReducer$JobsLoadingState;Lcom/box/android/cpl/IdentifiedList;Ljava/lang/String;Lcom/box/android/jobsui/JobPreview;Z)V", "()Z", "getJobsLoadingState", "()Lcom/box/android/jobsui/JobsReducer$JobsLoadingState;", "getJobsList", "()Lcom/box/android/cpl/IdentifiedList;", "getErrorText", "()Ljava/lang/String;", "getPreviewingJobItem", "()Lcom/box/android/jobsui/JobPreview;", "selectedItems", "", "getSelectedItems", "()Ljava/util/List;", "isActionMode", "component1", "component2", "component3", "component4", "component5", "component6", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "other", "hashCode", "", "toString", "jobsui_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final /* data */ class State {
        public static final int $stable = 8;
        private final String errorText;
        private final boolean isClosing;
        private final boolean isDeleting;
        private final IdentifiedList<String, JobItemReducer.State> jobsList;
        private final JobsLoadingState jobsLoadingState;
        private final JobPreview previewingJobItem;

        public State() {
            this(false, null, null, null, null, false, 63, null);
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ State copy$default(State state, boolean z, JobsLoadingState jobsLoadingState, IdentifiedList identifiedList, String str, JobPreview jobPreview, boolean z2, int i, Object obj) {
            if ((i & 1) != 0) {
                z = state.isClosing;
            }
            if ((i & 2) != 0) {
                jobsLoadingState = state.jobsLoadingState;
            }
            if ((i & 4) != 0) {
                identifiedList = state.jobsList;
            }
            if ((i & 8) != 0) {
                str = state.errorText;
            }
            if ((i & 16) != 0) {
                jobPreview = state.previewingJobItem;
            }
            if ((i & 32) != 0) {
                z2 = state.isDeleting;
            }
            JobPreview jobPreview2 = jobPreview;
            boolean z3 = z2;
            return state.copy(z, jobsLoadingState, identifiedList, str, jobPreview2, z3);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final boolean getIsClosing() {
            return this.isClosing;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final JobsLoadingState getJobsLoadingState() {
            return this.jobsLoadingState;
        }

        public final IdentifiedList<String, JobItemReducer.State> component3() {
            return this.jobsList;
        }

        /* JADX INFO: renamed from: component4, reason: from getter */
        public final String getErrorText() {
            return this.errorText;
        }

        /* JADX INFO: renamed from: component5, reason: from getter */
        public final JobPreview getPreviewingJobItem() {
            return this.previewingJobItem;
        }

        /* JADX INFO: renamed from: component6, reason: from getter */
        public final boolean getIsDeleting() {
            return this.isDeleting;
        }

        public final State copy(boolean isClosing, JobsLoadingState jobsLoadingState, IdentifiedList<String, JobItemReducer.State> jobsList, String errorText, JobPreview previewingJobItem, boolean isDeleting) {
            Intrinsics.checkNotNullParameter(jobsLoadingState, "jobsLoadingState");
            Intrinsics.checkNotNullParameter(jobsList, "jobsList");
            return new State(isClosing, jobsLoadingState, jobsList, errorText, previewingJobItem, isDeleting);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof State)) {
                return false;
            }
            State state = (State) other;
            return this.isClosing == state.isClosing && Intrinsics.areEqual(this.jobsLoadingState, state.jobsLoadingState) && Intrinsics.areEqual(this.jobsList, state.jobsList) && Intrinsics.areEqual(this.errorText, state.errorText) && Intrinsics.areEqual(this.previewingJobItem, state.previewingJobItem) && this.isDeleting == state.isDeleting;
        }

        public int hashCode() {
            int iHashCode = ((((Boolean.hashCode(this.isClosing) * 31) + this.jobsLoadingState.hashCode()) * 31) + this.jobsList.hashCode()) * 31;
            String str = this.errorText;
            int iHashCode2 = (iHashCode + (str == null ? 0 : str.hashCode())) * 31;
            JobPreview jobPreview = this.previewingJobItem;
            return ((iHashCode2 + (jobPreview != null ? jobPreview.hashCode() : 0)) * 31) + Boolean.hashCode(this.isDeleting);
        }

        public String toString() {
            return "State(isClosing=" + this.isClosing + ", jobsLoadingState=" + this.jobsLoadingState + ", jobsList=" + this.jobsList + ", errorText=" + this.errorText + ", previewingJobItem=" + this.previewingJobItem + ", isDeleting=" + this.isDeleting + ")";
        }

        public State(boolean z, JobsLoadingState jobsLoadingState, IdentifiedList<String, JobItemReducer.State> jobsList, String str, JobPreview jobPreview, boolean z2) {
            Intrinsics.checkNotNullParameter(jobsLoadingState, "jobsLoadingState");
            Intrinsics.checkNotNullParameter(jobsList, "jobsList");
            this.isClosing = z;
            this.jobsLoadingState = jobsLoadingState;
            this.jobsList = jobsList;
            this.errorText = str;
            this.previewingJobItem = jobPreview;
            this.isDeleting = z2;
        }

        public final boolean isClosing() {
            return this.isClosing;
        }

        public /* synthetic */ State(boolean z, JobsLoadingState.Loading loading, IdentifiedList identifiedList, String str, JobPreview jobPreview, boolean z2, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? false : z, (i & 2) != 0 ? JobsLoadingState.Loading.INSTANCE : loading, (i & 4) != 0 ? IdentifiedListKt.emptyIdentifiedList() : identifiedList, (i & 8) != 0 ? null : str, (i & 16) != 0 ? null : jobPreview, (i & 32) != 0 ? false : z2);
        }

        public final JobsLoadingState getJobsLoadingState() {
            return this.jobsLoadingState;
        }

        public final IdentifiedList<String, JobItemReducer.State> getJobsList() {
            return this.jobsList;
        }

        public final String getErrorText() {
            return this.errorText;
        }

        public final JobPreview getPreviewingJobItem() {
            return this.previewingJobItem;
        }

        public final boolean isDeleting() {
            return this.isDeleting;
        }

        public final List<String> getSelectedItems() {
            IdentifiedList<String, JobItemReducer.State> identifiedList = this.jobsList;
            ArrayList arrayList = new ArrayList();
            for (JobItemReducer.State state : identifiedList) {
                if (state.isSelected()) {
                    arrayList.add(state);
                }
            }
            ArrayList arrayList2 = arrayList;
            ArrayList arrayList3 = new ArrayList(CollectionsKt.collectionSizeOrDefault(arrayList2, 10));
            Iterator it = arrayList2.iterator();
            while (it.hasNext()) {
                arrayList3.add(((JobItemReducer.State) it.next()).getJobItemId().getIdentifier());
            }
            return arrayList3;
        }

        public final boolean isActionMode() {
            return !getSelectedItems().isEmpty();
        }
    }

    @Inject
    public JobsReducer(JobsUIEnvironment environment) {
        Intrinsics.checkNotNullParameter(environment, "environment");
        this.environment = environment;
        Reduce reduce = new Reduce(new Function2() { // from class: com.box.android.jobsui.JobsReducer$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(Object obj, Object obj2) {
                return JobsReducer.build$lambda$0(this.f$0, (JobsReducer.State) obj, (JobsReducer.Action) obj2);
            }
        });
        final JobsReducer$build$2 jobsReducer$build$2 = new PropertyReference1Impl() { // from class: com.box.android.jobsui.JobsReducer$build$2
            @Override // kotlin.jvm.internal.PropertyReference1Impl, kotlin.reflect.KProperty1
            public Object get(Object obj) {
                return ((JobsReducer.State) obj).getJobsList();
            }
        };
        final JobsReducer$build$3 jobsReducer$build$3 = JobsReducer$build$3.INSTANCE;
        this.build = new ForEachReducer(reduce, new JobItemReducer(environment), jobsReducer$build$2, new Function1<Action, EmbeddedItem<String, JobItemReducer.Action>>() { // from class: com.box.android.jobsui.JobsReducer$special$$inlined$forEach$1
            @Override // kotlin.jvm.functions.Function1
            public final EmbeddedItem<String, JobItemReducer.Action> invoke(JobsReducer.Action action) {
                if (!(action instanceof JobsReducer.Action.JobItemAction)) {
                    action = null;
                }
                return (JobsReducer.Action.JobItemAction) action;
            }
        }, new Function2<State, JobItemReducer.State, State>() { // from class: com.box.android.jobsui.JobsReducer$special$$inlined$forEach$2
            {
                super(2);
            }

            /* JADX WARN: Multi-variable type inference failed */
            @Override // kotlin.jvm.functions.Function2
            public final JobsReducer.State invoke(JobsReducer.State parentState, JobItemReducer.State childState) throws InvalidObjectException {
                Object next;
                Intrinsics.checkNotNullParameter(parentState, "parentState");
                Intrinsics.checkNotNullParameter(childState, "childState");
                IdentifiedList identifiedListListByReplacingElement = ((IdentifiedList) jobsReducer$build$2.get(parentState)).listByReplacingElement(childState);
                KProperty1 kProperty1 = jobsReducer$build$2;
                Iterator<T> it = KClasses.getMemberFunctions(Reflection.getOrCreateKotlinClass(JobsReducer.State.class)).iterator();
                do {
                    if (!it.hasNext()) {
                        next = null;
                        break;
                    }
                    next = it.next();
                } while (!Intrinsics.areEqual(((KFunction) next).getName(), BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB));
                KFunction kFunction = (KFunction) next;
                if (kFunction == null) {
                    throw new InvalidObjectException("Copy method not found. Make sure that you work on data class!");
                }
                KParameter instanceParameter = KCallables.getInstanceParameter(kFunction);
                Intrinsics.checkNotNull(instanceParameter);
                for (KParameter kParameter : kFunction.getParameters()) {
                    if (Intrinsics.areEqual(kParameter.getName(), kProperty1.getName())) {
                        R rCallBy = kFunction.callBy(MapsKt.mapOf(TuplesKt.to(instanceParameter, parentState), TuplesKt.to(kParameter, identifiedListListByReplacingElement)));
                        if (rCallBy != 0) {
                            return (JobsReducer.State) rCallBy;
                        }
                        throw new NullPointerException("null cannot be cast to non-null type com.box.android.jobsui.JobsReducer.State");
                    }
                }
                throw new NoSuchElementException("Collection contains no element matching the predicate.");
            }
        }, new Function2<String, JobItemReducer.Action, Action>() { // from class: com.box.android.jobsui.JobsReducer$special$$inlined$forEach$3
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public final JobsReducer.Action invoke(String id, JobItemReducer.Action action) {
                Intrinsics.checkNotNullParameter(id, "id");
                Object objInvoke = jobsReducer$build$3.invoke(id, action);
                if (objInvoke != null) {
                    return (JobsReducer.Action) objInvoke;
                }
                throw new NullPointerException("null cannot be cast to non-null type com.box.android.jobsui.JobsReducer.Action");
            }
        });
    }

    @Override // com.box.android.cpl.Reducable
    public /* bridge */ ReducerResult<State, Action> reduce(State state, Action action) {
        return Reducable.DefaultImpls.reduce(this, state, action);
    }

    /* JADX INFO: compiled from: JobsReducer.kt */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b7\u0018\u00002\u00020\u0001:\u0002\u0004\u0005B\t\b\u0004¢\u0006\u0004\b\u0002\u0010\u0003\u0082\u0001\u0002\u0006\u0007¨\u0006\b"}, d2 = {"Lcom/box/android/jobsui/JobsReducer$JobsLoadingState;", "", "<init>", "()V", "Loading", "Loaded", "Lcom/box/android/jobsui/JobsReducer$JobsLoadingState$Loaded;", "Lcom/box/android/jobsui/JobsReducer$JobsLoadingState$Loading;", "jobsui_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static abstract class JobsLoadingState {
        public static final int $stable = 0;

        public /* synthetic */ JobsLoadingState(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* JADX INFO: compiled from: JobsReducer.kt */
        @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÇ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÖ\u0003J\t\u0010\b\u001a\u00020\tHÖ\u0001J\t\u0010\n\u001a\u00020\u000bHÖ\u0001¨\u0006\f"}, d2 = {"Lcom/box/android/jobsui/JobsReducer$JobsLoadingState$Loading;", "Lcom/box/android/jobsui/JobsReducer$JobsLoadingState;", "<init>", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "jobsui_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
        public static final /* data */ class Loading extends JobsLoadingState {
            public static final int $stable = 0;
            public static final Loading INSTANCE = new Loading();

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof Loading)) {
                    return false;
                }
                return true;
            }

            public int hashCode() {
                return 1390867942;
            }

            public String toString() {
                return "Loading";
            }

            private Loading() {
                super(null);
            }
        }

        private JobsLoadingState() {
        }

        /* JADX INFO: compiled from: JobsReducer.kt */
        @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÇ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÖ\u0003J\t\u0010\b\u001a\u00020\tHÖ\u0001J\t\u0010\n\u001a\u00020\u000bHÖ\u0001¨\u0006\f"}, d2 = {"Lcom/box/android/jobsui/JobsReducer$JobsLoadingState$Loaded;", "Lcom/box/android/jobsui/JobsReducer$JobsLoadingState;", "<init>", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "jobsui_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
        public static final /* data */ class Loaded extends JobsLoadingState {
            public static final int $stable = 0;
            public static final Loaded INSTANCE = new Loaded();

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof Loaded)) {
                    return false;
                }
                return true;
            }

            public int hashCode() {
                return 599055899;
            }

            public String toString() {
                return "Loaded";
            }

            private Loaded() {
                super(null);
            }
        }
    }

    /* JADX INFO: compiled from: JobsReducer.kt */
    @Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b7\u0018\u00002\u00020\u0001:\u000b\u0004\u0005\u0006\u0007\b\t\n\u000b\f\r\u000eB\t\b\u0004¢\u0006\u0004\b\u0002\u0010\u0003\u0082\u0001\u000b\u000f\u0010\u0011\u0012\u0013\u0014\u0015\u0016\u0017\u0018\u0019¨\u0006\u001a"}, d2 = {"Lcom/box/android/jobsui/JobsReducer$Action;", "", "<init>", "()V", "InitProgressIndication", "TriggerDelete", "DeleteJobs", "ExitActionMode", "CloseScreen", "Load", "PreviewHandled", "HandledError", "ActionFailed", "JobsLoaded", "JobItemAction", "Lcom/box/android/jobsui/JobsReducer$Action$ActionFailed;", "Lcom/box/android/jobsui/JobsReducer$Action$CloseScreen;", "Lcom/box/android/jobsui/JobsReducer$Action$DeleteJobs;", "Lcom/box/android/jobsui/JobsReducer$Action$ExitActionMode;", "Lcom/box/android/jobsui/JobsReducer$Action$HandledError;", "Lcom/box/android/jobsui/JobsReducer$Action$InitProgressIndication;", "Lcom/box/android/jobsui/JobsReducer$Action$JobItemAction;", "Lcom/box/android/jobsui/JobsReducer$Action$JobsLoaded;", "Lcom/box/android/jobsui/JobsReducer$Action$Load;", "Lcom/box/android/jobsui/JobsReducer$Action$PreviewHandled;", "Lcom/box/android/jobsui/JobsReducer$Action$TriggerDelete;", "jobsui_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static abstract class Action {
        public static final int $stable = 0;

        public /* synthetic */ Action(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* JADX INFO: compiled from: JobsReducer.kt */
        @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÇ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÖ\u0003J\t\u0010\b\u001a\u00020\tHÖ\u0001J\t\u0010\n\u001a\u00020\u000bHÖ\u0001¨\u0006\f"}, d2 = {"Lcom/box/android/jobsui/JobsReducer$Action$InitProgressIndication;", "Lcom/box/android/jobsui/JobsReducer$Action;", "<init>", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "jobsui_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
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
                return -1999753212;
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

        /* JADX INFO: compiled from: JobsReducer.kt */
        @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÇ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÖ\u0003J\t\u0010\b\u001a\u00020\tHÖ\u0001J\t\u0010\n\u001a\u00020\u000bHÖ\u0001¨\u0006\f"}, d2 = {"Lcom/box/android/jobsui/JobsReducer$Action$TriggerDelete;", "Lcom/box/android/jobsui/JobsReducer$Action;", "<init>", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "jobsui_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
        public static final /* data */ class TriggerDelete extends Action {
            public static final int $stable = 0;
            public static final TriggerDelete INSTANCE = new TriggerDelete();

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof TriggerDelete)) {
                    return false;
                }
                return true;
            }

            public int hashCode() {
                return 95767992;
            }

            public String toString() {
                return "TriggerDelete";
            }

            private TriggerDelete() {
                super(null);
            }
        }

        /* JADX INFO: compiled from: JobsReducer.kt */
        @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÇ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÖ\u0003J\t\u0010\b\u001a\u00020\tHÖ\u0001J\t\u0010\n\u001a\u00020\u000bHÖ\u0001¨\u0006\f"}, d2 = {"Lcom/box/android/jobsui/JobsReducer$Action$DeleteJobs;", "Lcom/box/android/jobsui/JobsReducer$Action;", "<init>", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "jobsui_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
        public static final /* data */ class DeleteJobs extends Action {
            public static final int $stable = 0;
            public static final DeleteJobs INSTANCE = new DeleteJobs();

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof DeleteJobs)) {
                    return false;
                }
                return true;
            }

            public int hashCode() {
                return -874951540;
            }

            public String toString() {
                return "DeleteJobs";
            }

            private DeleteJobs() {
                super(null);
            }
        }

        /* JADX INFO: compiled from: JobsReducer.kt */
        @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÇ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÖ\u0003J\t\u0010\b\u001a\u00020\tHÖ\u0001J\t\u0010\n\u001a\u00020\u000bHÖ\u0001¨\u0006\f"}, d2 = {"Lcom/box/android/jobsui/JobsReducer$Action$ExitActionMode;", "Lcom/box/android/jobsui/JobsReducer$Action;", "<init>", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "jobsui_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
        public static final /* data */ class ExitActionMode extends Action {
            public static final int $stable = 0;
            public static final ExitActionMode INSTANCE = new ExitActionMode();

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof ExitActionMode)) {
                    return false;
                }
                return true;
            }

            public int hashCode() {
                return -1235239134;
            }

            public String toString() {
                return "ExitActionMode";
            }

            private ExitActionMode() {
                super(null);
            }
        }

        /* JADX INFO: compiled from: JobsReducer.kt */
        @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÇ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÖ\u0003J\t\u0010\b\u001a\u00020\tHÖ\u0001J\t\u0010\n\u001a\u00020\u000bHÖ\u0001¨\u0006\f"}, d2 = {"Lcom/box/android/jobsui/JobsReducer$Action$CloseScreen;", "Lcom/box/android/jobsui/JobsReducer$Action;", "<init>", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "jobsui_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
        public static final /* data */ class CloseScreen extends Action {
            public static final int $stable = 0;
            public static final CloseScreen INSTANCE = new CloseScreen();

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof CloseScreen)) {
                    return false;
                }
                return true;
            }

            public int hashCode() {
                return -55023111;
            }

            public String toString() {
                return "CloseScreen";
            }

            private CloseScreen() {
                super(null);
            }
        }

        /* JADX INFO: compiled from: JobsReducer.kt */
        @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u0011\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u00032\b\u0010\u000b\u001a\u0004\u0018\u00010\fHÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0011"}, d2 = {"Lcom/box/android/jobsui/JobsReducer$Action$Load;", "Lcom/box/android/jobsui/JobsReducer$Action;", "removeSuccessfulJobs", "", "<init>", "(Z)V", "getRemoveSuccessfulJobs", "()Z", "component1", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "other", "", "hashCode", "", "toString", "", "jobsui_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
        public static final /* data */ class Load extends Action {
            public static final int $stable = 0;
            private final boolean removeSuccessfulJobs;

            public Load() {
                this(false, 1, null);
            }

            public static /* synthetic */ Load copy$default(Load load, boolean z, int i, Object obj) {
                if ((i & 1) != 0) {
                    z = load.removeSuccessfulJobs;
                }
                return load.copy(z);
            }

            /* JADX INFO: renamed from: component1, reason: from getter */
            public final boolean getRemoveSuccessfulJobs() {
                return this.removeSuccessfulJobs;
            }

            public final Load copy(boolean removeSuccessfulJobs) {
                return new Load(removeSuccessfulJobs);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                return (other instanceof Load) && this.removeSuccessfulJobs == ((Load) other).removeSuccessfulJobs;
            }

            public int hashCode() {
                return Boolean.hashCode(this.removeSuccessfulJobs);
            }

            public String toString() {
                return "Load(removeSuccessfulJobs=" + this.removeSuccessfulJobs + ")";
            }

            public Load(boolean z) {
                super(null);
                this.removeSuccessfulJobs = z;
            }

            public /* synthetic */ Load(boolean z, int i, DefaultConstructorMarker defaultConstructorMarker) {
                this((i & 1) != 0 ? false : z);
            }

            public final boolean getRemoveSuccessfulJobs() {
                return this.removeSuccessfulJobs;
            }
        }

        /* JADX INFO: compiled from: JobsReducer.kt */
        @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÇ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÖ\u0003J\t\u0010\b\u001a\u00020\tHÖ\u0001J\t\u0010\n\u001a\u00020\u000bHÖ\u0001¨\u0006\f"}, d2 = {"Lcom/box/android/jobsui/JobsReducer$Action$PreviewHandled;", "Lcom/box/android/jobsui/JobsReducer$Action;", "<init>", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "jobsui_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
        public static final /* data */ class PreviewHandled extends Action {
            public static final int $stable = 0;
            public static final PreviewHandled INSTANCE = new PreviewHandled();

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof PreviewHandled)) {
                    return false;
                }
                return true;
            }

            public int hashCode() {
                return -2131291969;
            }

            public String toString() {
                return "PreviewHandled";
            }

            private PreviewHandled() {
                super(null);
            }
        }

        /* JADX INFO: compiled from: JobsReducer.kt */
        @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÇ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÖ\u0003J\t\u0010\b\u001a\u00020\tHÖ\u0001J\t\u0010\n\u001a\u00020\u000bHÖ\u0001¨\u0006\f"}, d2 = {"Lcom/box/android/jobsui/JobsReducer$Action$HandledError;", "Lcom/box/android/jobsui/JobsReducer$Action;", "<init>", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "jobsui_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
        public static final /* data */ class HandledError extends Action {
            public static final int $stable = 0;
            public static final HandledError INSTANCE = new HandledError();

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof HandledError)) {
                    return false;
                }
                return true;
            }

            public int hashCode() {
                return 1162257751;
            }

            public String toString() {
                return "HandledError";
            }

            private HandledError() {
                super(null);
            }
        }

        /* JADX INFO: compiled from: JobsReducer.kt */
        @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0003J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0012"}, d2 = {"Lcom/box/android/jobsui/JobsReducer$Action$ActionFailed;", "Lcom/box/android/jobsui/JobsReducer$Action;", "error", "Lcom/box/android/domain/models/DomainError;", "<init>", "(Lcom/box/android/domain/models/DomainError;)V", "getError", "()Lcom/box/android/domain/models/DomainError;", "component1", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "", "other", "", "hashCode", "", "toString", "", "jobsui_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
        public static final /* data */ class ActionFailed extends Action {
            public static final int $stable = 8;
            private final DomainError error;

            public static /* synthetic */ ActionFailed copy$default(ActionFailed actionFailed, DomainError domainError, int i, Object obj) {
                if ((i & 1) != 0) {
                    domainError = actionFailed.error;
                }
                return actionFailed.copy(domainError);
            }

            /* JADX INFO: renamed from: component1, reason: from getter */
            public final DomainError getError() {
                return this.error;
            }

            public final ActionFailed copy(DomainError error) {
                Intrinsics.checkNotNullParameter(error, "error");
                return new ActionFailed(error);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                return (other instanceof ActionFailed) && Intrinsics.areEqual(this.error, ((ActionFailed) other).error);
            }

            public int hashCode() {
                return this.error.hashCode();
            }

            public String toString() {
                return "ActionFailed(error=" + this.error + ")";
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public ActionFailed(DomainError error) {
                super(null);
                Intrinsics.checkNotNullParameter(error, "error");
                this.error = error;
            }

            public final DomainError getError() {
                return this.error;
            }
        }

        /* JADX INFO: compiled from: JobsReducer.kt */
        @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\n\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B!\u0012\u000e\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006¢\u0006\u0004\b\u0007\u0010\bJ\u0011\u0010\f\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0006HÆ\u0003J%\u0010\u000e\u001a\u00020\u00002\u0010\b\u0002\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0006HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00062\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0015HÖ\u0001R\u0019\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u000b¨\u0006\u0016"}, d2 = {"Lcom/box/android/jobsui/JobsReducer$Action$JobsLoaded;", "Lcom/box/android/jobsui/JobsReducer$Action;", "jobListState", "", "Lcom/box/android/jobsui/JobItemReducer$State;", "isSuccess", "", "<init>", "(Ljava/util/List;Z)V", "getJobListState", "()Ljava/util/List;", "()Z", "component1", "component2", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "other", "", "hashCode", "", "toString", "", "jobsui_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
        public static final /* data */ class JobsLoaded extends Action {
            public static final int $stable = 8;
            private final boolean isSuccess;
            private final List<JobItemReducer.State> jobListState;

            /* JADX WARN: Multi-variable type inference failed */
            public static /* synthetic */ JobsLoaded copy$default(JobsLoaded jobsLoaded, List list, boolean z, int i, Object obj) {
                if ((i & 1) != 0) {
                    list = jobsLoaded.jobListState;
                }
                if ((i & 2) != 0) {
                    z = jobsLoaded.isSuccess;
                }
                return jobsLoaded.copy(list, z);
            }

            public final List<JobItemReducer.State> component1() {
                return this.jobListState;
            }

            /* JADX INFO: renamed from: component2, reason: from getter */
            public final boolean getIsSuccess() {
                return this.isSuccess;
            }

            public final JobsLoaded copy(List<JobItemReducer.State> jobListState, boolean isSuccess) {
                return new JobsLoaded(jobListState, isSuccess);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof JobsLoaded)) {
                    return false;
                }
                JobsLoaded jobsLoaded = (JobsLoaded) other;
                return Intrinsics.areEqual(this.jobListState, jobsLoaded.jobListState) && this.isSuccess == jobsLoaded.isSuccess;
            }

            public int hashCode() {
                List<JobItemReducer.State> list = this.jobListState;
                return ((list == null ? 0 : list.hashCode()) * 31) + Boolean.hashCode(this.isSuccess);
            }

            public String toString() {
                return "JobsLoaded(jobListState=" + this.jobListState + ", isSuccess=" + this.isSuccess + ")";
            }

            public JobsLoaded(List<JobItemReducer.State> list, boolean z) {
                super(null);
                this.jobListState = list;
                this.isSuccess = z;
            }

            public /* synthetic */ JobsLoaded(List list, boolean z, int i, DefaultConstructorMarker defaultConstructorMarker) {
                this(list, (i & 2) != 0 ? true : z);
            }

            public final List<JobItemReducer.State> getJobListState() {
                return this.jobListState;
            }

            public final boolean isSuccess() {
                return this.isSuccess;
            }
        }

        /* JADX INFO: compiled from: JobsReducer.kt */
        @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u00012\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u0002B\u0017\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0004¢\u0006\u0004\b\u0007\u0010\bJ\t\u0010\r\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000e\u001a\u00020\u0004HÆ\u0003J\u001d\u0010\u000f\u001a\u00020\u00002\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u0004HÆ\u0001J\u0013\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013HÖ\u0003J\t\u0010\u0014\u001a\u00020\u0015HÖ\u0001J\t\u0010\u0016\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0006\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f¨\u0006\u0017"}, d2 = {"Lcom/box/android/jobsui/JobsReducer$Action$JobItemAction;", "Lcom/box/android/jobsui/JobsReducer$Action;", "Lcom/box/android/cpl/EmbeddedItem;", "", "Lcom/box/android/jobsui/JobItemReducer$Action;", "id", Analytics.Data.ACTION, "<init>", "(Ljava/lang/String;Lcom/box/android/jobsui/JobItemReducer$Action;)V", "getId", "()Ljava/lang/String;", "getAction", "()Lcom/box/android/jobsui/JobItemReducer$Action;", "component1", "component2", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "", "other", "", "hashCode", "", "toString", "jobsui_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
        public static final /* data */ class JobItemAction extends Action implements EmbeddedItem<String, JobItemReducer.Action> {
            public static final int $stable = 0;
            private final JobItemReducer.Action action;
            private final String id;

            public static /* synthetic */ JobItemAction copy$default(JobItemAction jobItemAction, String str, JobItemReducer.Action action, int i, Object obj) {
                if ((i & 1) != 0) {
                    str = jobItemAction.id;
                }
                if ((i & 2) != 0) {
                    action = jobItemAction.action;
                }
                return jobItemAction.copy(str, action);
            }

            @Override // com.box.android.cpl.EmbeddedItem
            /* JADX INFO: renamed from: component1, reason: avoid collision after fix types in other method and from getter */
            public final String getItemId() {
                return this.id;
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.box.android.cpl.EmbeddedItem
            /* JADX INFO: renamed from: component2, reason: from getter */
            public final JobItemReducer.Action getAction() {
                return this.action;
            }

            public final JobItemAction copy(String id, JobItemReducer.Action action) {
                Intrinsics.checkNotNullParameter(id, "id");
                Intrinsics.checkNotNullParameter(action, "action");
                return new JobItemAction(id, action);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof JobItemAction)) {
                    return false;
                }
                JobItemAction jobItemAction = (JobItemAction) other;
                return Intrinsics.areEqual(this.id, jobItemAction.id) && Intrinsics.areEqual(this.action, jobItemAction.action);
            }

            public int hashCode() {
                return (this.id.hashCode() * 31) + this.action.hashCode();
            }

            public String toString() {
                return "JobItemAction(id=" + this.id + ", action=" + this.action + ")";
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public JobItemAction(String id, JobItemReducer.Action action) {
                super(null);
                Intrinsics.checkNotNullParameter(id, "id");
                Intrinsics.checkNotNullParameter(action, "action");
                this.id = id;
                this.action = action;
            }

            public final JobItemReducer.Action getAction() {
                return this.action;
            }

            public final String getId() {
                return this.id;
            }
        }
    }

    private final ReducerResult<State, Action> handleLoad(State state, Action.Load action) {
        return new ReducerResult<>(state, EffectKt.toEffect(FlowKt.flow(new C16551(state, this, action, null))));
    }

    /* JADX INFO: renamed from: com.box.android.jobsui.JobsReducer$handleLoad$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: JobsReducer.kt */
    @Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\b\u0012\u0004\u0012\u00020\u00030\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/flow/FlowCollector;", "Lcom/box/android/jobsui/JobsReducer$Action$JobsLoaded;"}, k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.box.android.jobsui.JobsReducer$handleLoad$1", f = "JobsReducer.kt", i = {0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 3, 3, 3, 3, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 5, 5, 5, 5, 5, 5}, l = {66, 70, 77, 86, 92, 110}, m = "invokeSuspend", n = {"$this$flow", "$this$filter$iv", "$this$filterTo$iv$iv", "destination$iv$iv", "element$iv$iv", "it", "$i$f$filter", "$i$f$filterTo", "$i$a$-filter-JobsReducer$handleLoad$1$oldSuccessfulJobs$1", "$this$flow", "oldSuccessfulJobs", "jobList", "$this$flow", "oldSuccessfulJobs", "jobList", "legacyJobs", "$this$forEach$iv", "element$iv", "groupId", "jobs", "$this$forEach$iv", "element$iv", "it", "currThumbnailFlow", "$i$f$forEach", "$i$a$-forEach-JobsReducer$handleLoad$1$1", "$i$f$forEach", "$i$a$-forEach-JobsReducer$handleLoad$1$1$1", "$this$flow", "oldSuccessfulJobs", "jobList", "legacyJobs", "$this$flow", "oldSuccessfulJobs", "jobList", "legacyJobs", "$this$onSuccess$iv", "it", "$this$map$iv", "$this$mapTo$iv$iv", "destination$iv$iv", "item$iv$iv", "jobInfo", "currThumbnailFlow", "$i$f$onSuccess", "$i$a$-onSuccess-JobsReducer$handleLoad$1$2", "$i$f$map", "$i$f$mapTo", "$i$a$-map-JobsReducer$handleLoad$1$2$2", "$this$flow", "oldSuccessfulJobs", "jobList", "legacyJobs", "joinedJobList", "itemToIndex"}, s = {"L$0", "L$1", "L$2", "L$3", "L$5", "L$6", "I$0", "I$1", "I$2", "L$0", "L$1", "L$2", "L$0", "L$1", "L$2", "L$3", "L$4", "L$8", "L$9", "L$10", "L$11", "L$13", "L$14", "L$15", "I$0", "I$1", "I$2", "I$3", "L$0", "L$1", "L$2", "L$3", "L$0", "L$1", "L$2", "L$3", "L$4", "L$7", "L$8", "L$9", "L$10", "L$12", "L$13", "L$15", "I$0", "I$1", "I$2", "I$3", "I$4", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5"}, v = 1)
    static final class C16551 extends SuspendLambda implements Function2<FlowCollector<? super Action.JobsLoaded>, Continuation<? super Unit>, Object> {
        final /* synthetic */ Action.Load $action;
        final /* synthetic */ State $state;
        int I$0;
        int I$1;
        int I$2;
        int I$3;
        int I$4;
        private /* synthetic */ Object L$0;
        Object L$1;
        Object L$10;
        Object L$11;
        Object L$12;
        Object L$13;
        Object L$14;
        Object L$15;
        Object L$16;
        Object L$2;
        Object L$3;
        Object L$4;
        Object L$5;
        Object L$6;
        Object L$7;
        Object L$8;
        Object L$9;
        int label;
        final /* synthetic */ JobsReducer this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C16551(State state, JobsReducer jobsReducer, Action.Load load, Continuation<? super C16551> continuation) {
            super(2, continuation);
            this.$state = state;
            this.this$0 = jobsReducer;
            this.$action = load;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            C16551 c16551 = new C16551(this.$state, this.this$0, this.$action, continuation);
            c16551.L$0 = obj;
            return c16551;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(FlowCollector<? super Action.JobsLoaded> flowCollector, Continuation<? super Unit> continuation) {
            return ((C16551) create(flowCollector, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Code duplicated, block: B:15:0x0161  */
        /* JADX WARN: Code duplicated, block: B:21:0x01a8  */
        /* JADX WARN: Code duplicated, block: B:30:0x0223  */
        /* JADX WARN: Code duplicated, block: B:32:0x0247  */
        /* JADX WARN: Code duplicated, block: B:33:0x024c  */
        /* JADX WARN: Code duplicated, block: B:37:0x02c2  */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:16:0x0196 -> B:18:0x019a). Please report as a decompilation issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:27:0x01f5 -> B:28:0x021d). Please report as a decompilation issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:37:0x02c2 -> B:38:0x02cc). Please report as a decompilation issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:61:0x041e -> B:62:0x0428). Please report as a decompilation issue!!! */
        /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
            jadx.core.utils.exceptions.JadxOverflowException: Regions stack size limit reached
            	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
            	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
            	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
            */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final java.lang.Object invokeSuspend(java.lang.Object r24) {
            /*
                Method dump skipped, instruction units count: 1370
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: com.box.android.jobsui.JobsReducer.C16551.invokeSuspend(java.lang.Object):java.lang.Object");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    public final Object deleteJob(JobItemReducer.State state, Continuation<? super Result<Unit, ? extends DomainError>> continuation) {
        AnonymousClass1 anonymousClass1;
        if (continuation instanceof AnonymousClass1) {
            anonymousClass1 = (AnonymousClass1) continuation;
            if ((anonymousClass1.label & Integer.MIN_VALUE) != 0) {
                anonymousClass1.label -= Integer.MIN_VALUE;
            } else {
                anonymousClass1 = new AnonymousClass1(continuation);
            }
        } else {
            anonymousClass1 = new AnonymousClass1(continuation);
        }
        AnonymousClass1 anonymousClass2 = anonymousClass1;
        Object objFirst = anonymousClass2.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = anonymousClass2.label;
        if (i == 0) {
            ResultKt.throwOnFailure(objFirst);
            StateFlow<JobStatusUIState> progress = state.getProgress();
            anonymousClass2.L$0 = state;
            anonymousClass2.label = 1;
            objFirst = FlowKt.first(progress, anonymousClass2);
            if (objFirst != coroutine_suspended) {
            }
            return coroutine_suspended;
        }
        if (i != 1) {
            if (i != 2 && i != 3) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(objFirst);
            return objFirst;
        }
        state = (JobItemReducer.State) anonymousClass2.L$0;
        ResultKt.throwOnFailure(objFirst);
        if (((JobStatusUIState) objFirst).getJobStatus() instanceof JobInfo.Status.Running) {
            this.environment.getJobsUICoreHelper().logRunningJobDeleted();
        }
        JobItemId jobItemId = state.getJobItemId();
        if (jobItemId.isLegacy()) {
            IJobManagerBridgeService jobManagerBridgeService = this.environment.getJobManagerBridgeService();
            String identifier = jobItemId.getIdentifier();
            String groupId = jobItemId.getGroupId();
            anonymousClass2.L$0 = SpillingKt.nullOutSpilledVariable(state);
            anonymousClass2.L$1 = SpillingKt.nullOutSpilledVariable(jobItemId);
            anonymousClass2.label = 2;
            Object objCancelJob = jobManagerBridgeService.cancelJob(identifier, groupId, anonymousClass2);
            if (objCancelJob != coroutine_suspended) {
                return objCancelJob;
            }
        } else {
            IJobService jobService = this.environment.getJobService();
            JobId jobId = new JobId(jobItemId.getIdentifier());
            anonymousClass2.L$0 = SpillingKt.nullOutSpilledVariable(state);
            anonymousClass2.L$1 = SpillingKt.nullOutSpilledVariable(jobItemId);
            anonymousClass2.label = 3;
            Object objDequeue$default = IJobService.dequeue$default(jobService, jobId, false, anonymousClass2, 2, null);
            if (objDequeue$default != coroutine_suspended) {
                return objDequeue$default;
            }
        }
        return coroutine_suspended;
    }

    /* JADX INFO: renamed from: com.box.android.jobsui.JobsReducer$deleteSelectedJobs$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: JobsReducer.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.box.android.jobsui.JobsReducer$deleteSelectedJobs$1", f = "JobsReducer.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {}, v = 1)
    static final class C16541 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ Ref.ObjectRef<DomainError> $domainError;
        final /* synthetic */ State $state;
        private /* synthetic */ Object L$0;
        int label;
        final /* synthetic */ JobsReducer this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C16541(State state, JobsReducer jobsReducer, Ref.ObjectRef<DomainError> objectRef, Continuation<? super C16541> continuation) {
            super(2, continuation);
            this.$state = state;
            this.this$0 = jobsReducer;
            this.$domainError = objectRef;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            C16541 c16541 = new C16541(this.$state, this.this$0, this.$domainError, continuation);
            c16541.L$0 = obj;
            return c16541;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C16541) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            CoroutineScope coroutineScope = (CoroutineScope) this.L$0;
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            List<String> selectedItems = this.$state.getSelectedItems();
            JobsReducer jobsReducer = this.this$0;
            State state = this.$state;
            Ref.ObjectRef<DomainError> objectRef = this.$domainError;
            Iterator<T> it = selectedItems.iterator();
            while (it.hasNext()) {
                BuildersKt__Builders_commonKt.launch$default(coroutineScope, null, null, new JobsReducer$deleteSelectedJobs$1$1$1(jobsReducer, state, (String) it.next(), objectRef, null), 3, null);
                jobsReducer = jobsReducer;
                state = state;
                objectRef = objectRef;
            }
            return Unit.INSTANCE;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public final DomainError deleteSelectedJobs(State state) throws InterruptedException {
        Ref.ObjectRef objectRef = new Ref.ObjectRef();
        BuildersKt__BuildersKt.runBlocking$default(null, new C16541(state, this, objectRef, null), 1, null);
        return (DomainError) objectRef.element;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final ReducerResult<State, Action> handleJobItemAction(State state, Action.JobItemAction action) {
        int i = 2;
        Effect effect = null;
        Object[] objArr = 0;
        Object[] objArr2 = 0;
        Object[] objArr3 = 0;
        Object[] objArr4 = 0;
        Object[] objArr5 = 0;
        if (Intrinsics.areEqual(action.getAction(), JobItemReducer.Action.PrimaryAction.INSTANCE)) {
            JobPreview.Companion companion = JobPreview.INSTANCE;
            Identifiable byId = state.getJobsList().getById(action.getId());
            Intrinsics.checkNotNull(byId);
            JobPreview jobPreviewFromJobState = companion.fromJobState((JobItemReducer.State) byId);
            if (jobPreviewFromJobState != null) {
                return new ReducerResult<>(State.copy$default(state, false, null, null, null, jobPreviewFromJobState, false, 47, null), effect, i, objArr5 == true ? 1 : 0);
            }
            return new ReducerResult<>(state, objArr4 == true ? 1 : 0, i, objArr3 == true ? 1 : 0);
        }
        return new ReducerResult<>(state, objArr2 == true ? 1 : 0, i, objArr == true ? 1 : 0);
    }

    @Override // com.box.android.cpl.Reducable
    public Reducable<State, Action> getBuild() {
        return this.build;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public static final ReducerResult build$lambda$0(JobsReducer jobsReducer, State state, Action action) {
        Intrinsics.checkNotNullParameter(state, "state");
        Intrinsics.checkNotNullParameter(action, "action");
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
        if (action instanceof Action.InitProgressIndication) {
            return new ReducerResult(state, EffectKt.toEffect(FlowKt.flow(new JobsReducer$build$1$1(jobsReducer, null))).cancellable("InitProgressIndication", true));
        }
        if (action instanceof Action.CloseScreen) {
            return new ReducerResult(State.copy$default(state, true, null, null, null, null, false, 62, null), Effect.INSTANCE.fireAndForget(new JobsReducer$build$1$2(jobsReducer, state, null)));
        }
        int i = 2;
        if (action instanceof Action.TriggerDelete) {
            return new ReducerResult(State.copy$default(state, false, null, null, null, null, true, 31, null), effect, i, objArr11 == true ? 1 : 0);
        }
        if (action instanceof Action.HandledError) {
            return new ReducerResult(State.copy$default(state, false, null, null, null, null, false, 55, null), objArr10 == true ? 1 : 0, i, objArr9 == true ? 1 : 0);
        }
        if (action instanceof Action.DeleteJobs) {
            return new ReducerResult(state, Effect.INSTANCE.merge(EffectKt.toEffect(FlowKt.flow(new JobsReducer$build$1$3(jobsReducer, state, null))), new Effect(Action.ExitActionMode.INSTANCE)));
        }
        if (action instanceof Action.PreviewHandled) {
            return new ReducerResult(State.copy$default(state, false, null, null, null, null, false, 47, null), objArr8 == true ? 1 : 0, i, objArr7 == true ? 1 : 0);
        }
        if (action instanceof Action.ActionFailed) {
            return new ReducerResult(State.copy$default(state, false, null, null, CommonBoxUtil.LS(R.string.box_sharesdk_generic_error), null, false, 55, null), objArr6 == true ? 1 : 0, i, objArr5 == true ? 1 : 0);
        }
        if (action instanceof Action.ExitActionMode) {
            IdentifiedList<String, JobItemReducer.State> jobsList = state.getJobsList();
            ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(jobsList, 10));
            Iterator<JobItemReducer.State> it = jobsList.iterator();
            while (it.hasNext()) {
                arrayList.add(JobItemReducer.State.copy$default(it.next(), null, null, null, null, null, 0, null, false, null, 383, null));
            }
            return new ReducerResult(State.copy$default(state, false, null, new IdentifiedList((Identifiable[]) arrayList.toArray(new JobItemReducer.State[0])), null, null, false, 27, null), objArr4 == true ? 1 : 0, i, objArr3 == true ? 1 : 0);
        }
        if (action instanceof Action.Load) {
            return jobsReducer.handleLoad(state, (Action.Load) action);
        }
        if (action instanceof Action.JobItemAction) {
            return jobsReducer.handleJobItemAction(state, (Action.JobItemAction) action);
        }
        if (!(action instanceof Action.JobsLoaded)) {
            throw new NoWhenBranchMatchedException();
        }
        JobsLoadingState.Loaded loaded = JobsLoadingState.Loaded.INSTANCE;
        List<JobItemReducer.State> jobListState = ((Action.JobsLoaded) action).getJobListState();
        Intrinsics.checkNotNull(jobListState);
        return new ReducerResult(State.copy$default(state, false, loaded, new IdentifiedList((Identifiable[]) jobListState.toArray(new JobItemReducer.State[0])), null, null, false, 57, null), objArr2 == true ? 1 : 0, i, objArr == true ? 1 : 0);
    }
}
