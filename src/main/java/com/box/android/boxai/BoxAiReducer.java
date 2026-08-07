package com.box.android.boxai;

import com.box.android.base.presentation.components.CopyTextReducer;
import com.box.android.boxai.agents.BoxAiAgentsReducer;
import com.box.android.boxai.qa.BoxAiQaReducer;
import com.box.android.common.utilities.BoxCommonConstants;
import com.box.android.cpl.Effect;
import com.box.android.cpl.EffectKt;
import com.box.android.cpl.Embedded;
import com.box.android.cpl.Reducable;
import com.box.android.cpl.Reduce;
import com.box.android.cpl.ReducerResult;
import com.box.android.cpl.reducers.IfLetReducer;
import com.box.android.domain.analytics.BoxAmplitudeAnalytics;
import com.box.android.domain.models.boxai.AiCitationModel;
import com.box.android.domain.models.boxai.AiUnavailabilityReason;
import com.box.android.domain.models.item.FileModel;
import com.box.android.domain.models.item.ItemModel;
import com.facebook.imageutils.JfifUtil;
import com.pspdfkit.analytics.Analytics;
import java.io.InvalidObjectException;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KFunction;
import kotlin.reflect.KParameter;
import kotlin.reflect.KProperty1;
import kotlin.reflect.full.KCallables;
import kotlin.reflect.full.KClasses;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.FlowKt;

/* JADX INFO: compiled from: BoxAiReducer.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0007\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0003\u0011\u0012\u0013B\u000f\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J$\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\f2\u0006\u0010\r\u001a\u00020\u00022\u0006\u0010\u000e\u001a\u00020\u000fH\u0002J\u001c\u0010\u0010\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\f2\u0006\u0010\r\u001a\u00020\u0002H\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R \u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u0014"}, d2 = {"Lcom/box/android/boxai/BoxAiReducer;", "Lcom/box/android/cpl/Reducable;", "Lcom/box/android/boxai/BoxAiReducer$State;", "Lcom/box/android/boxai/BoxAiReducer$Action;", "environment", "Lcom/box/android/boxai/BoxAiEnvironment;", "<init>", "(Lcom/box/android/boxai/BoxAiEnvironment;)V", "build", "getBuild", "()Lcom/box/android/cpl/Reducable;", "handleLaunchWithFiles", "Lcom/box/android/cpl/ReducerResult;", "state", Analytics.Data.ACTION, "Lcom/box/android/boxai/BoxAiReducer$Action$LaunchWithFiles;", "handleCreateSession", "State", "ScreenState", "Action", "boxai_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class BoxAiReducer implements Reducable<State, Action> {
    public static final int $stable = 8;
    private final Reducable<State, Action> build;
    private final BoxAiEnvironment environment;

    public BoxAiReducer(BoxAiEnvironment environment) {
        Intrinsics.checkNotNullParameter(environment, "environment");
        this.environment = environment;
        Reduce reduce = new Reduce(new Function2() { // from class: com.box.android.boxai.BoxAiReducer$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(Object obj, Object obj2) {
                return BoxAiReducer.build$lambda$0(this.f$0, (BoxAiReducer.State) obj, (BoxAiReducer.Action) obj2);
            }
        });
        final BoxAiReducer$build$2 boxAiReducer$build$2 = new PropertyReference1Impl() { // from class: com.box.android.boxai.BoxAiReducer$build$2
            @Override // kotlin.jvm.internal.PropertyReference1Impl, kotlin.reflect.KProperty1
            public Object get(Object obj) {
                return ((BoxAiReducer.State) obj).getScreenState();
            }
        };
        final BoxAiReducer$build$3 boxAiReducer$build$3 = BoxAiReducer$build$3.INSTANCE;
        final BoxAiReducer$build$4 boxAiReducer$build$4 = BoxAiReducer$build$4.INSTANCE;
        IfLetReducer ifLetReducer = new IfLetReducer(reduce, new BoxAiQaReducer(environment), new Function1<State, BoxAiQaReducer.State>() { // from class: com.box.android.boxai.BoxAiReducer$special$$inlined$ifCaseScope$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final BoxAiQaReducer.State invoke(BoxAiReducer.State it) {
                Intrinsics.checkNotNullParameter(it, "it");
                Object objInvoke = boxAiReducer$build$2.invoke(it);
                if (!(objInvoke instanceof BoxAiReducer.ScreenState.QaSession)) {
                    objInvoke = null;
                }
                BoxAiReducer.ScreenState.QaSession qaSession = (BoxAiReducer.ScreenState.QaSession) objInvoke;
                if (qaSession != null) {
                    return qaSession.getAction();
                }
                return null;
            }
        }, new Function1<Action, BoxAiQaReducer.Action>() { // from class: com.box.android.boxai.BoxAiReducer$special$$inlined$ifCaseScope$2
            @Override // kotlin.jvm.functions.Function1
            public final BoxAiQaReducer.Action invoke(BoxAiReducer.Action action) {
                if (!(action instanceof BoxAiReducer.Action.QaAiAction)) {
                    action = null;
                }
                BoxAiReducer.Action.QaAiAction qaAiAction = (BoxAiReducer.Action.QaAiAction) action;
                if (qaAiAction != null) {
                    return qaAiAction.getAction();
                }
                return null;
            }
        }, new Function2<State, BoxAiQaReducer.State, State>() { // from class: com.box.android.boxai.BoxAiReducer$special$$inlined$ifCaseScope$3
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(2);
            }

            /* JADX WARN: Multi-variable type inference failed */
            @Override // kotlin.jvm.functions.Function2
            public final BoxAiReducer.State invoke(BoxAiReducer.State parentState, BoxAiQaReducer.State childState) throws InvalidObjectException {
                Object next;
                Intrinsics.checkNotNullParameter(parentState, "parentState");
                Intrinsics.checkNotNullParameter(childState, "childState");
                KProperty1 kProperty1 = boxAiReducer$build$2;
                Object objInvoke = boxAiReducer$build$3.invoke(childState);
                Iterator<T> it = KClasses.getMemberFunctions(Reflection.getOrCreateKotlinClass(BoxAiReducer.State.class)).iterator();
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
                        R rCallBy = kFunction.callBy(MapsKt.mapOf(TuplesKt.to(instanceParameter, parentState), TuplesKt.to(kParameter, objInvoke)));
                        if (rCallBy != 0) {
                            return (BoxAiReducer.State) rCallBy;
                        }
                        throw new NullPointerException("null cannot be cast to non-null type com.box.android.boxai.BoxAiReducer.State");
                    }
                }
                throw new NoSuchElementException("Collection contains no element matching the predicate.");
            }
        }, new Function1<BoxAiQaReducer.Action, Action>() { // from class: com.box.android.boxai.BoxAiReducer$special$$inlined$ifCaseScope$4
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final BoxAiReducer.Action invoke(BoxAiQaReducer.Action action) {
                Object objInvoke = boxAiReducer$build$4.invoke(action);
                if (objInvoke != null) {
                    return (BoxAiReducer.Action) objInvoke;
                }
                throw new NullPointerException("null cannot be cast to non-null type com.box.android.boxai.BoxAiReducer.Action");
            }
        });
        final BoxAiReducer$build$6 boxAiReducer$build$6 = new PropertyReference1Impl() { // from class: com.box.android.boxai.BoxAiReducer$build$6
            @Override // kotlin.jvm.internal.PropertyReference1Impl, kotlin.reflect.KProperty1
            public Object get(Object obj) {
                return ((BoxAiReducer.State) obj).getAgentsState();
            }
        };
        final BoxAiReducer$build$7 boxAiReducer$build$7 = BoxAiReducer$build$7.INSTANCE;
        this.build = new IfLetReducer(ifLetReducer, new BoxAiAgentsReducer(environment), new Function1<State, BoxAiAgentsReducer.State>() { // from class: com.box.android.boxai.BoxAiReducer$special$$inlined$scope$1
            {
                super(1);
            }

            /* JADX WARN: Type inference failed for: r1v2, types: [com.box.android.boxai.agents.BoxAiAgentsReducer$State, java.lang.Object] */
            @Override // kotlin.jvm.functions.Function1
            public final BoxAiAgentsReducer.State invoke(BoxAiReducer.State it) {
                Intrinsics.checkNotNullParameter(it, "it");
                return boxAiReducer$build$6.invoke(it);
            }
        }, new Function1<Action, BoxAiAgentsReducer.Action>() { // from class: com.box.android.boxai.BoxAiReducer$special$$inlined$scope$2
            @Override // kotlin.jvm.functions.Function1
            public final BoxAiAgentsReducer.Action invoke(BoxAiReducer.Action action) {
                if (!(action instanceof BoxAiReducer.Action.AgentsAction)) {
                    action = null;
                }
                BoxAiReducer.Action.AgentsAction agentsAction = (BoxAiReducer.Action.AgentsAction) action;
                if (agentsAction != null) {
                    return agentsAction.getAction();
                }
                return null;
            }
        }, new Function2<State, BoxAiAgentsReducer.State, State>() { // from class: com.box.android.boxai.BoxAiReducer$special$$inlined$scope$3
            {
                super(2);
            }

            /* JADX WARN: Multi-variable type inference failed */
            @Override // kotlin.jvm.functions.Function2
            public final BoxAiReducer.State invoke(BoxAiReducer.State parentState, BoxAiAgentsReducer.State state) throws InvalidObjectException {
                Object next;
                Intrinsics.checkNotNullParameter(parentState, "parentState");
                KProperty1 kProperty1 = boxAiReducer$build$6;
                Iterator<T> it = KClasses.getMemberFunctions(Reflection.getOrCreateKotlinClass(BoxAiReducer.State.class)).iterator();
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
                        R rCallBy = kFunction.callBy(MapsKt.mapOf(TuplesKt.to(instanceParameter, parentState), TuplesKt.to(kParameter, state)));
                        if (rCallBy != 0) {
                            return (BoxAiReducer.State) rCallBy;
                        }
                        throw new NullPointerException("null cannot be cast to non-null type com.box.android.boxai.BoxAiReducer.State");
                    }
                }
                throw new NoSuchElementException("Collection contains no element matching the predicate.");
            }
        }, new Function1<BoxAiAgentsReducer.Action, Action>() { // from class: com.box.android.boxai.BoxAiReducer$special$$inlined$scope$4
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final BoxAiReducer.Action invoke(BoxAiAgentsReducer.Action action) {
                Object objInvoke = boxAiReducer$build$7.invoke(action);
                if (objInvoke != null) {
                    return (BoxAiReducer.Action) objInvoke;
                }
                throw new NullPointerException("null cannot be cast to non-null type com.box.android.boxai.BoxAiReducer.Action");
            }
        });
    }

    @Override // com.box.android.cpl.Reducable
    public /* bridge */ ReducerResult<State, Action> reduce(State state, Action action) {
        return Reducable.DefaultImpls.reduce(this, state, action);
    }

    /* JADX INFO: compiled from: BoxAiReducer.kt */
    @Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001Bo\u0012\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\u001a\b\u0002\u0010\u0005\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u00060\u0003\u0012\b\b\u0002\u0010\t\u001a\u00020\n\u0012\b\b\u0002\u0010\u000b\u001a\u00020\f\u0012\b\b\u0002\u0010\r\u001a\u00020\n\u0012\b\b\u0002\u0010\u000e\u001a\u00020\n\u0012\b\b\u0002\u0010\u000f\u001a\u00020\n\u0012\b\b\u0002\u0010\u0010\u001a\u00020\u0011¢\u0006\u0004\b\u0012\u0010\u0013J\u0006\u0010\"\u001a\u00020\nJ\u000f\u0010#\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003J\u001b\u0010$\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u00060\u0003HÆ\u0003J\t\u0010%\u001a\u00020\nHÆ\u0003J\t\u0010&\u001a\u00020\fHÆ\u0003J\t\u0010'\u001a\u00020\nHÆ\u0003J\t\u0010(\u001a\u00020\nHÆ\u0003J\t\u0010)\u001a\u00020\nHÆ\u0003J\t\u0010*\u001a\u00020\u0011HÆ\u0003Jq\u0010+\u001a\u00020\u00002\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u001a\b\u0002\u0010\u0005\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u00060\u00032\b\b\u0002\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010\r\u001a\u00020\n2\b\b\u0002\u0010\u000e\u001a\u00020\n2\b\b\u0002\u0010\u000f\u001a\u00020\n2\b\b\u0002\u0010\u0010\u001a\u00020\u0011HÆ\u0001J\u0013\u0010,\u001a\u00020\n2\b\u0010-\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010.\u001a\u00020/HÖ\u0001J\t\u00100\u001a\u000201HÖ\u0001R\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R#\u0010\u0005\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u00060\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0015R\u0011\u0010\t\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\u0017R\u0011\u0010\u000b\u001a\u00020\f¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R\u0011\u0010\r\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u0017R\u0011\u0010\u000e\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0017R\u0011\u0010\u000f\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u0017R\u0011\u0010\u0010\u001a\u00020\u0011¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001dR\u0013\u0010\u001e\u001a\u0004\u0018\u00010\u001f¢\u0006\b\n\u0000\u001a\u0004\b \u0010!¨\u00062"}, d2 = {"Lcom/box/android/boxai/BoxAiReducer$State;", "", "fileModels", "", "Lcom/box/android/domain/models/item/FileModel;", "unsupportedItems", "Lkotlin/Pair;", "Lcom/box/android/domain/models/item/ItemModel;", "Lcom/box/android/domain/models/boxai/AiUnavailabilityReason;", "isMultidoc", "", "screenState", "Lcom/box/android/boxai/BoxAiReducer$ScreenState;", "isItemSearchable", "shouldBeShown", "needToShowUpdateAppAlert", "agentsState", "Lcom/box/android/boxai/agents/BoxAiAgentsReducer$State;", "<init>", "(Ljava/util/List;Ljava/util/List;ZLcom/box/android/boxai/BoxAiReducer$ScreenState;ZZZLcom/box/android/boxai/agents/BoxAiAgentsReducer$State;)V", "getFileModels", "()Ljava/util/List;", "getUnsupportedItems", "()Z", "getScreenState", "()Lcom/box/android/boxai/BoxAiReducer$ScreenState;", "getShouldBeShown", "getNeedToShowUpdateAppAlert", "getAgentsState", "()Lcom/box/android/boxai/agents/BoxAiAgentsReducer$State;", "copyTextState", "Lcom/box/android/base/presentation/components/CopyTextReducer$State;", "getCopyTextState", "()Lcom/box/android/base/presentation/components/CopyTextReducer$State;", "hasPrompts", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "other", "hashCode", "", "toString", "", "boxai_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final /* data */ class State {
        public static final int $stable = 8;
        private final BoxAiAgentsReducer.State agentsState;
        private final CopyTextReducer.State copyTextState;
        private final List<FileModel> fileModels;
        private final boolean isItemSearchable;
        private final boolean isMultidoc;
        private final boolean needToShowUpdateAppAlert;
        private final ScreenState screenState;
        private final boolean shouldBeShown;
        private final List<Pair<ItemModel, AiUnavailabilityReason>> unsupportedItems;

        public State() {
            this(null, null, false, null, false, false, false, null, 255, null);
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ State copy$default(State state, List list, List list2, boolean z, ScreenState screenState, boolean z2, boolean z3, boolean z4, BoxAiAgentsReducer.State state2, int i, Object obj) {
            if ((i & 1) != 0) {
                list = state.fileModels;
            }
            if ((i & 2) != 0) {
                list2 = state.unsupportedItems;
            }
            if ((i & 4) != 0) {
                z = state.isMultidoc;
            }
            if ((i & 8) != 0) {
                screenState = state.screenState;
            }
            if ((i & 16) != 0) {
                z2 = state.isItemSearchable;
            }
            if ((i & 32) != 0) {
                z3 = state.shouldBeShown;
            }
            if ((i & 64) != 0) {
                z4 = state.needToShowUpdateAppAlert;
            }
            if ((i & 128) != 0) {
                state2 = state.agentsState;
            }
            boolean z5 = z4;
            BoxAiAgentsReducer.State state3 = state2;
            boolean z6 = z2;
            boolean z7 = z3;
            return state.copy(list, list2, z, screenState, z6, z7, z5, state3);
        }

        public final List<FileModel> component1() {
            return this.fileModels;
        }

        public final List<Pair<ItemModel, AiUnavailabilityReason>> component2() {
            return this.unsupportedItems;
        }

        /* JADX INFO: renamed from: component3, reason: from getter */
        public final boolean getIsMultidoc() {
            return this.isMultidoc;
        }

        /* JADX INFO: renamed from: component4, reason: from getter */
        public final ScreenState getScreenState() {
            return this.screenState;
        }

        /* JADX INFO: renamed from: component5, reason: from getter */
        public final boolean getIsItemSearchable() {
            return this.isItemSearchable;
        }

        /* JADX INFO: renamed from: component6, reason: from getter */
        public final boolean getShouldBeShown() {
            return this.shouldBeShown;
        }

        /* JADX INFO: renamed from: component7, reason: from getter */
        public final boolean getNeedToShowUpdateAppAlert() {
            return this.needToShowUpdateAppAlert;
        }

        /* JADX INFO: renamed from: component8, reason: from getter */
        public final BoxAiAgentsReducer.State getAgentsState() {
            return this.agentsState;
        }

        public final State copy(List<FileModel> fileModels, List<? extends Pair<? extends ItemModel, ? extends AiUnavailabilityReason>> unsupportedItems, boolean isMultidoc, ScreenState screenState, boolean isItemSearchable, boolean shouldBeShown, boolean needToShowUpdateAppAlert, BoxAiAgentsReducer.State agentsState) {
            Intrinsics.checkNotNullParameter(fileModels, "fileModels");
            Intrinsics.checkNotNullParameter(unsupportedItems, "unsupportedItems");
            Intrinsics.checkNotNullParameter(screenState, "screenState");
            Intrinsics.checkNotNullParameter(agentsState, "agentsState");
            return new State(fileModels, unsupportedItems, isMultidoc, screenState, isItemSearchable, shouldBeShown, needToShowUpdateAppAlert, agentsState);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof State)) {
                return false;
            }
            State state = (State) other;
            return Intrinsics.areEqual(this.fileModels, state.fileModels) && Intrinsics.areEqual(this.unsupportedItems, state.unsupportedItems) && this.isMultidoc == state.isMultidoc && Intrinsics.areEqual(this.screenState, state.screenState) && this.isItemSearchable == state.isItemSearchable && this.shouldBeShown == state.shouldBeShown && this.needToShowUpdateAppAlert == state.needToShowUpdateAppAlert && Intrinsics.areEqual(this.agentsState, state.agentsState);
        }

        public int hashCode() {
            return (((((((((((((this.fileModels.hashCode() * 31) + this.unsupportedItems.hashCode()) * 31) + Boolean.hashCode(this.isMultidoc)) * 31) + this.screenState.hashCode()) * 31) + Boolean.hashCode(this.isItemSearchable)) * 31) + Boolean.hashCode(this.shouldBeShown)) * 31) + Boolean.hashCode(this.needToShowUpdateAppAlert)) * 31) + this.agentsState.hashCode();
        }

        public String toString() {
            return "State(fileModels=" + this.fileModels + ", unsupportedItems=" + this.unsupportedItems + ", isMultidoc=" + this.isMultidoc + ", screenState=" + this.screenState + ", isItemSearchable=" + this.isItemSearchable + ", shouldBeShown=" + this.shouldBeShown + ", needToShowUpdateAppAlert=" + this.needToShowUpdateAppAlert + ", agentsState=" + this.agentsState + ")";
        }

        /* JADX WARN: Multi-variable type inference failed */
        public State(List<FileModel> fileModels, List<? extends Pair<? extends ItemModel, ? extends AiUnavailabilityReason>> unsupportedItems, boolean z, ScreenState screenState, boolean z2, boolean z3, boolean z4, BoxAiAgentsReducer.State agentsState) {
            BoxAiQaReducer.State state;
            Intrinsics.checkNotNullParameter(fileModels, "fileModels");
            Intrinsics.checkNotNullParameter(unsupportedItems, "unsupportedItems");
            Intrinsics.checkNotNullParameter(screenState, "screenState");
            Intrinsics.checkNotNullParameter(agentsState, "agentsState");
            this.fileModels = fileModels;
            this.unsupportedItems = unsupportedItems;
            this.isMultidoc = z;
            this.screenState = screenState;
            this.isItemSearchable = z2;
            this.shouldBeShown = z3;
            this.needToShowUpdateAppAlert = z4;
            this.agentsState = agentsState;
            CopyTextReducer.State copyTextState = null;
            ScreenState.QaSession qaSession = screenState instanceof ScreenState.QaSession ? (ScreenState.QaSession) screenState : null;
            if (qaSession != null && (state = qaSession.getState()) != null) {
                copyTextState = state.getCopyTextState();
            }
            this.copyTextState = copyTextState;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public /* synthetic */ State(List list, List list2, boolean z, ScreenState.Uninitialized uninitialized, boolean z2, boolean z3, boolean z4, BoxAiAgentsReducer.State state, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? CollectionsKt.emptyList() : list, (i & 2) != 0 ? CollectionsKt.emptyList() : list2, (i & 4) != 0 ? false : z, (i & 8) != 0 ? ScreenState.Uninitialized.INSTANCE : uninitialized, (i & 16) != 0 ? false : z2, (i & 32) != 0 ? false : z3, (i & 64) != 0 ? false : z4, (i & 128) != 0 ? new BoxAiAgentsReducer.State(null, 0 == true ? 1 : 0, 3, 0 == true ? 1 : 0) : state);
        }

        public final List<FileModel> getFileModels() {
            return this.fileModels;
        }

        public final List<Pair<ItemModel, AiUnavailabilityReason>> getUnsupportedItems() {
            return this.unsupportedItems;
        }

        public final boolean isMultidoc() {
            return this.isMultidoc;
        }

        public final ScreenState getScreenState() {
            return this.screenState;
        }

        public final boolean isItemSearchable() {
            return this.isItemSearchable;
        }

        public final boolean getShouldBeShown() {
            return this.shouldBeShown;
        }

        public final boolean getNeedToShowUpdateAppAlert() {
            return this.needToShowUpdateAppAlert;
        }

        public final BoxAiAgentsReducer.State getAgentsState() {
            return this.agentsState;
        }

        public final CopyTextReducer.State getCopyTextState() {
            return this.copyTextState;
        }

        public final boolean hasPrompts() {
            return this.screenState.hasPrompts();
        }
    }

    /* JADX INFO: compiled from: BoxAiReducer.kt */
    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b7\u0018\u00002\u00020\u0001:\u0005\u0006\u0007\b\t\nB\t\b\u0004¢\u0006\u0004\b\u0002\u0010\u0003J\u0006\u0010\u0004\u001a\u00020\u0005\u0082\u0001\u0005\u000b\f\r\u000e\u000f¨\u0006\u0010"}, d2 = {"Lcom/box/android/boxai/BoxAiReducer$ScreenState;", "", "<init>", "()V", "hasPrompts", "", "Uninitialized", "Initializing", "DocumentContentTooLarge", "Error", "QaSession", "Lcom/box/android/boxai/BoxAiReducer$ScreenState$DocumentContentTooLarge;", "Lcom/box/android/boxai/BoxAiReducer$ScreenState$Error;", "Lcom/box/android/boxai/BoxAiReducer$ScreenState$Initializing;", "Lcom/box/android/boxai/BoxAiReducer$ScreenState$QaSession;", "Lcom/box/android/boxai/BoxAiReducer$ScreenState$Uninitialized;", "boxai_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static abstract class ScreenState {
        public static final int $stable = 0;

        public /* synthetic */ ScreenState(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* JADX INFO: compiled from: BoxAiReducer.kt */
        @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÇ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÖ\u0003J\t\u0010\b\u001a\u00020\tHÖ\u0001J\t\u0010\n\u001a\u00020\u000bHÖ\u0001¨\u0006\f"}, d2 = {"Lcom/box/android/boxai/BoxAiReducer$ScreenState$Uninitialized;", "Lcom/box/android/boxai/BoxAiReducer$ScreenState;", "<init>", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "boxai_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
        public static final /* data */ class Uninitialized extends ScreenState {
            public static final int $stable = 0;
            public static final Uninitialized INSTANCE = new Uninitialized();

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof Uninitialized)) {
                    return false;
                }
                return true;
            }

            public int hashCode() {
                return -286734489;
            }

            public String toString() {
                return "Uninitialized";
            }

            private Uninitialized() {
                super(null);
            }
        }

        private ScreenState() {
        }

        /* JADX INFO: compiled from: BoxAiReducer.kt */
        @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÇ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÖ\u0003J\t\u0010\b\u001a\u00020\tHÖ\u0001J\t\u0010\n\u001a\u00020\u000bHÖ\u0001¨\u0006\f"}, d2 = {"Lcom/box/android/boxai/BoxAiReducer$ScreenState$Initializing;", "Lcom/box/android/boxai/BoxAiReducer$ScreenState;", "<init>", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "boxai_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
        public static final /* data */ class Initializing extends ScreenState {
            public static final int $stable = 0;
            public static final Initializing INSTANCE = new Initializing();

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof Initializing)) {
                    return false;
                }
                return true;
            }

            public int hashCode() {
                return 754377217;
            }

            public String toString() {
                return "Initializing";
            }

            private Initializing() {
                super(null);
            }
        }

        /* JADX INFO: compiled from: BoxAiReducer.kt */
        @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0003J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\t\u0010\u0010\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0011"}, d2 = {"Lcom/box/android/boxai/BoxAiReducer$ScreenState$DocumentContentTooLarge;", "Lcom/box/android/boxai/BoxAiReducer$ScreenState;", "encodedSession", "", "<init>", "(Ljava/lang/String;)V", "getEncodedSession", "()Ljava/lang/String;", "component1", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "", "other", "", "hashCode", "", "toString", "boxai_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
        public static final /* data */ class DocumentContentTooLarge extends ScreenState {
            public static final int $stable = 0;
            private final String encodedSession;

            public static /* synthetic */ DocumentContentTooLarge copy$default(DocumentContentTooLarge documentContentTooLarge, String str, int i, Object obj) {
                if ((i & 1) != 0) {
                    str = documentContentTooLarge.encodedSession;
                }
                return documentContentTooLarge.copy(str);
            }

            /* JADX INFO: renamed from: component1, reason: from getter */
            public final String getEncodedSession() {
                return this.encodedSession;
            }

            public final DocumentContentTooLarge copy(String encodedSession) {
                Intrinsics.checkNotNullParameter(encodedSession, "encodedSession");
                return new DocumentContentTooLarge(encodedSession);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                return (other instanceof DocumentContentTooLarge) && Intrinsics.areEqual(this.encodedSession, ((DocumentContentTooLarge) other).encodedSession);
            }

            public int hashCode() {
                return this.encodedSession.hashCode();
            }

            public String toString() {
                return "DocumentContentTooLarge(encodedSession=" + this.encodedSession + ")";
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public DocumentContentTooLarge(String encodedSession) {
                super(null);
                Intrinsics.checkNotNullParameter(encodedSession, "encodedSession");
                this.encodedSession = encodedSession;
            }

            public final String getEncodedSession() {
                return this.encodedSession;
            }
        }

        /* JADX INFO: compiled from: BoxAiReducer.kt */
        @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÇ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÖ\u0003J\t\u0010\b\u001a\u00020\tHÖ\u0001J\t\u0010\n\u001a\u00020\u000bHÖ\u0001¨\u0006\f"}, d2 = {"Lcom/box/android/boxai/BoxAiReducer$ScreenState$Error;", "Lcom/box/android/boxai/BoxAiReducer$ScreenState;", "<init>", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "boxai_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
        public static final /* data */ class Error extends ScreenState {
            public static final int $stable = 0;
            public static final Error INSTANCE = new Error();

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof Error)) {
                    return false;
                }
                return true;
            }

            public int hashCode() {
                return 1279555284;
            }

            public String toString() {
                return "Error";
            }

            private Error() {
                super(null);
            }
        }

        /* JADX INFO: compiled from: BoxAiReducer.kt */
        @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u00012\b\u0012\u0004\u0012\u00020\u00030\u0002B\u000f\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\t\u0010\t\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\n\u001a\u00020\u00002\b\b\u0002\u0010\u0004\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000eHÖ\u0003J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\u0013"}, d2 = {"Lcom/box/android/boxai/BoxAiReducer$ScreenState$QaSession;", "Lcom/box/android/boxai/BoxAiReducer$ScreenState;", "Lcom/box/android/cpl/Embedded;", "Lcom/box/android/boxai/qa/BoxAiQaReducer$State;", "state", "<init>", "(Lcom/box/android/boxai/qa/BoxAiQaReducer$State;)V", "getState", "()Lcom/box/android/boxai/qa/BoxAiQaReducer$State;", "component1", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "", "other", "", "hashCode", "", "toString", "", "boxai_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
        public static final /* data */ class QaSession extends ScreenState implements Embedded<BoxAiQaReducer.State> {
            public static final int $stable = 8;
            private final BoxAiQaReducer.State state;

            public static /* synthetic */ QaSession copy$default(QaSession qaSession, BoxAiQaReducer.State state, int i, Object obj) {
                if ((i & 1) != 0) {
                    state = qaSession.state;
                }
                return qaSession.copy(state);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.box.android.cpl.Embedded
            /* JADX INFO: renamed from: component1, reason: from getter */
            public final BoxAiQaReducer.State getAction() {
                return this.state;
            }

            public final QaSession copy(BoxAiQaReducer.State state) {
                Intrinsics.checkNotNullParameter(state, "state");
                return new QaSession(state);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                return (other instanceof QaSession) && Intrinsics.areEqual(this.state, ((QaSession) other).state);
            }

            public int hashCode() {
                return this.state.hashCode();
            }

            public String toString() {
                return "QaSession(state=" + this.state + ")";
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public QaSession(BoxAiQaReducer.State state) {
                super(null);
                Intrinsics.checkNotNullParameter(state, "state");
                this.state = state;
            }

            public final BoxAiQaReducer.State getState() {
                return this.state;
            }
        }

        public final boolean hasPrompts() {
            return (this instanceof QaSession) && !((QaSession) this).getState().getDialogueHistory().isEmpty();
        }
    }

    /* JADX INFO: compiled from: BoxAiReducer.kt */
    @Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b7\u0018\u0000 \u00122\u00020\u0001:\u000f\u0004\u0005\u0006\u0007\b\t\n\u000b\f\r\u000e\u000f\u0010\u0011\u0012B\t\b\u0004¢\u0006\u0004\b\u0002\u0010\u0003\u0082\u0001\u000e\u0013\u0014\u0015\u0016\u0017\u0018\u0019\u001a\u001b\u001c\u001d\u001e\u001f ¨\u0006!"}, d2 = {"Lcom/box/android/boxai/BoxAiReducer$Action;", "", "<init>", "()V", "LaunchWithFiles", "ResetSession", "UpdateSearchableState", "CreateSession", "SessionCreated", "DocumentContentTooLarge", "ResolveDocumentContentTooLarge", "QaAiAction", "AgentsAction", "Error", "Dismiss", "UpdateAppAlertAccepted", "UpdateAppAlertAcknowledged", "HighlightCitation", "Companion", "Lcom/box/android/boxai/BoxAiReducer$Action$AgentsAction;", "Lcom/box/android/boxai/BoxAiReducer$Action$CreateSession;", "Lcom/box/android/boxai/BoxAiReducer$Action$Dismiss;", "Lcom/box/android/boxai/BoxAiReducer$Action$DocumentContentTooLarge;", "Lcom/box/android/boxai/BoxAiReducer$Action$Error;", "Lcom/box/android/boxai/BoxAiReducer$Action$HighlightCitation;", "Lcom/box/android/boxai/BoxAiReducer$Action$LaunchWithFiles;", "Lcom/box/android/boxai/BoxAiReducer$Action$QaAiAction;", "Lcom/box/android/boxai/BoxAiReducer$Action$ResetSession;", "Lcom/box/android/boxai/BoxAiReducer$Action$ResolveDocumentContentTooLarge;", "Lcom/box/android/boxai/BoxAiReducer$Action$SessionCreated;", "Lcom/box/android/boxai/BoxAiReducer$Action$UpdateAppAlertAccepted;", "Lcom/box/android/boxai/BoxAiReducer$Action$UpdateAppAlertAcknowledged;", "Lcom/box/android/boxai/BoxAiReducer$Action$UpdateSearchableState;", "boxai_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static abstract class Action {
        public static final int $stable = 0;

        /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
        public static final Companion INSTANCE = new Companion(null);

        public /* synthetic */ Action(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Action() {
        }

        /* JADX INFO: compiled from: BoxAiReducer.kt */
        @Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B1\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\u001a\b\u0002\u0010\u0005\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u00060\u0003¢\u0006\u0004\b\t\u0010\nJ\u000f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003J\u001b\u0010\u000f\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u00060\u0003HÆ\u0003J5\u0010\u0010\u001a\u00020\u00002\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u001a\b\u0002\u0010\u0005\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u00060\u0003HÆ\u0001J\u0013\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014HÖ\u0003J\t\u0010\u0015\u001a\u00020\u0016HÖ\u0001J\t\u0010\u0017\u001a\u00020\u0018HÖ\u0001R\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR#\u0010\u0005\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u00060\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\f¨\u0006\u0019"}, d2 = {"Lcom/box/android/boxai/BoxAiReducer$Action$LaunchWithFiles;", "Lcom/box/android/boxai/BoxAiReducer$Action;", "fileModels", "", "Lcom/box/android/domain/models/item/FileModel;", "unsupportedItems", "Lkotlin/Pair;", "Lcom/box/android/domain/models/item/ItemModel;", "Lcom/box/android/domain/models/boxai/AiUnavailabilityReason;", "<init>", "(Ljava/util/List;Ljava/util/List;)V", "getFileModels", "()Ljava/util/List;", "getUnsupportedItems", "component1", "component2", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "", "other", "", "hashCode", "", "toString", "", "boxai_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
        public static final /* data */ class LaunchWithFiles extends Action {
            public static final int $stable = 8;
            private final List<FileModel> fileModels;
            private final List<Pair<ItemModel, AiUnavailabilityReason>> unsupportedItems;

            /* JADX WARN: Multi-variable type inference failed */
            public static /* synthetic */ LaunchWithFiles copy$default(LaunchWithFiles launchWithFiles, List list, List list2, int i, Object obj) {
                if ((i & 1) != 0) {
                    list = launchWithFiles.fileModels;
                }
                if ((i & 2) != 0) {
                    list2 = launchWithFiles.unsupportedItems;
                }
                return launchWithFiles.copy(list, list2);
            }

            public final List<FileModel> component1() {
                return this.fileModels;
            }

            public final List<Pair<ItemModel, AiUnavailabilityReason>> component2() {
                return this.unsupportedItems;
            }

            public final LaunchWithFiles copy(List<FileModel> fileModels, List<? extends Pair<? extends ItemModel, ? extends AiUnavailabilityReason>> unsupportedItems) {
                Intrinsics.checkNotNullParameter(fileModels, "fileModels");
                Intrinsics.checkNotNullParameter(unsupportedItems, "unsupportedItems");
                return new LaunchWithFiles(fileModels, unsupportedItems);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof LaunchWithFiles)) {
                    return false;
                }
                LaunchWithFiles launchWithFiles = (LaunchWithFiles) other;
                return Intrinsics.areEqual(this.fileModels, launchWithFiles.fileModels) && Intrinsics.areEqual(this.unsupportedItems, launchWithFiles.unsupportedItems);
            }

            public int hashCode() {
                return (this.fileModels.hashCode() * 31) + this.unsupportedItems.hashCode();
            }

            public String toString() {
                return "LaunchWithFiles(fileModels=" + this.fileModels + ", unsupportedItems=" + this.unsupportedItems + ")";
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            public LaunchWithFiles(List<FileModel> fileModels, List<? extends Pair<? extends ItemModel, ? extends AiUnavailabilityReason>> unsupportedItems) {
                super(null);
                Intrinsics.checkNotNullParameter(fileModels, "fileModels");
                Intrinsics.checkNotNullParameter(unsupportedItems, "unsupportedItems");
                this.fileModels = fileModels;
                this.unsupportedItems = unsupportedItems;
            }

            public final List<FileModel> getFileModels() {
                return this.fileModels;
            }

            public /* synthetic */ LaunchWithFiles(List list, List list2, int i, DefaultConstructorMarker defaultConstructorMarker) {
                this(list, (i & 2) != 0 ? CollectionsKt.emptyList() : list2);
            }

            public final List<Pair<ItemModel, AiUnavailabilityReason>> getUnsupportedItems() {
                return this.unsupportedItems;
            }
        }

        /* JADX INFO: compiled from: BoxAiReducer.kt */
        @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÇ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÖ\u0003J\t\u0010\b\u001a\u00020\tHÖ\u0001J\t\u0010\n\u001a\u00020\u000bHÖ\u0001¨\u0006\f"}, d2 = {"Lcom/box/android/boxai/BoxAiReducer$Action$ResetSession;", "Lcom/box/android/boxai/BoxAiReducer$Action;", "<init>", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "boxai_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
        public static final /* data */ class ResetSession extends Action {
            public static final int $stable = 0;
            public static final ResetSession INSTANCE = new ResetSession();

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof ResetSession)) {
                    return false;
                }
                return true;
            }

            public int hashCode() {
                return -1744808332;
            }

            public String toString() {
                return "ResetSession";
            }

            private ResetSession() {
                super(null);
            }
        }

        /* JADX INFO: compiled from: BoxAiReducer.kt */
        @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u00032\b\u0010\u000b\u001a\u0004\u0018\u00010\fHÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0011"}, d2 = {"Lcom/box/android/boxai/BoxAiReducer$Action$UpdateSearchableState;", "Lcom/box/android/boxai/BoxAiReducer$Action;", "enabled", "", "<init>", "(Z)V", "getEnabled", "()Z", "component1", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "other", "", "hashCode", "", "toString", "", "boxai_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
        public static final /* data */ class UpdateSearchableState extends Action {
            public static final int $stable = 0;
            private final boolean enabled;

            public static /* synthetic */ UpdateSearchableState copy$default(UpdateSearchableState updateSearchableState, boolean z, int i, Object obj) {
                if ((i & 1) != 0) {
                    z = updateSearchableState.enabled;
                }
                return updateSearchableState.copy(z);
            }

            /* JADX INFO: renamed from: component1, reason: from getter */
            public final boolean getEnabled() {
                return this.enabled;
            }

            public final UpdateSearchableState copy(boolean enabled) {
                return new UpdateSearchableState(enabled);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                return (other instanceof UpdateSearchableState) && this.enabled == ((UpdateSearchableState) other).enabled;
            }

            public int hashCode() {
                return Boolean.hashCode(this.enabled);
            }

            public String toString() {
                return "UpdateSearchableState(enabled=" + this.enabled + ")";
            }

            public UpdateSearchableState(boolean z) {
                super(null);
                this.enabled = z;
            }

            public final boolean getEnabled() {
                return this.enabled;
            }
        }

        /* JADX INFO: compiled from: BoxAiReducer.kt */
        @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÇ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÖ\u0003J\t\u0010\b\u001a\u00020\tHÖ\u0001J\t\u0010\n\u001a\u00020\u000bHÖ\u0001¨\u0006\f"}, d2 = {"Lcom/box/android/boxai/BoxAiReducer$Action$CreateSession;", "Lcom/box/android/boxai/BoxAiReducer$Action;", "<init>", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "boxai_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
        public static final /* data */ class CreateSession extends Action {
            public static final int $stable = 0;
            public static final CreateSession INSTANCE = new CreateSession();

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof CreateSession)) {
                    return false;
                }
                return true;
            }

            public int hashCode() {
                return 1518373741;
            }

            public String toString() {
                return "CreateSession";
            }

            private CreateSession() {
                super(null);
            }
        }

        /* JADX INFO: compiled from: BoxAiReducer.kt */
        @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0003J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\t\u0010\u0010\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0011"}, d2 = {"Lcom/box/android/boxai/BoxAiReducer$Action$SessionCreated;", "Lcom/box/android/boxai/BoxAiReducer$Action;", "encodedSession", "", "<init>", "(Ljava/lang/String;)V", "getEncodedSession", "()Ljava/lang/String;", "component1", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "", "other", "", "hashCode", "", "toString", "boxai_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
        public static final /* data */ class SessionCreated extends Action {
            public static final int $stable = 0;
            private final String encodedSession;

            public static /* synthetic */ SessionCreated copy$default(SessionCreated sessionCreated, String str, int i, Object obj) {
                if ((i & 1) != 0) {
                    str = sessionCreated.encodedSession;
                }
                return sessionCreated.copy(str);
            }

            /* JADX INFO: renamed from: component1, reason: from getter */
            public final String getEncodedSession() {
                return this.encodedSession;
            }

            public final SessionCreated copy(String encodedSession) {
                Intrinsics.checkNotNullParameter(encodedSession, "encodedSession");
                return new SessionCreated(encodedSession);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                return (other instanceof SessionCreated) && Intrinsics.areEqual(this.encodedSession, ((SessionCreated) other).encodedSession);
            }

            public int hashCode() {
                return this.encodedSession.hashCode();
            }

            public String toString() {
                return "SessionCreated(encodedSession=" + this.encodedSession + ")";
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public SessionCreated(String encodedSession) {
                super(null);
                Intrinsics.checkNotNullParameter(encodedSession, "encodedSession");
                this.encodedSession = encodedSession;
            }

            public final String getEncodedSession() {
                return this.encodedSession;
            }
        }

        /* JADX INFO: compiled from: BoxAiReducer.kt */
        @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0003J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\t\u0010\u0010\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0011"}, d2 = {"Lcom/box/android/boxai/BoxAiReducer$Action$DocumentContentTooLarge;", "Lcom/box/android/boxai/BoxAiReducer$Action;", "encodedSession", "", "<init>", "(Ljava/lang/String;)V", "getEncodedSession", "()Ljava/lang/String;", "component1", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "", "other", "", "hashCode", "", "toString", "boxai_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
        public static final /* data */ class DocumentContentTooLarge extends Action {
            public static final int $stable = 0;
            private final String encodedSession;

            public static /* synthetic */ DocumentContentTooLarge copy$default(DocumentContentTooLarge documentContentTooLarge, String str, int i, Object obj) {
                if ((i & 1) != 0) {
                    str = documentContentTooLarge.encodedSession;
                }
                return documentContentTooLarge.copy(str);
            }

            /* JADX INFO: renamed from: component1, reason: from getter */
            public final String getEncodedSession() {
                return this.encodedSession;
            }

            public final DocumentContentTooLarge copy(String encodedSession) {
                Intrinsics.checkNotNullParameter(encodedSession, "encodedSession");
                return new DocumentContentTooLarge(encodedSession);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                return (other instanceof DocumentContentTooLarge) && Intrinsics.areEqual(this.encodedSession, ((DocumentContentTooLarge) other).encodedSession);
            }

            public int hashCode() {
                return this.encodedSession.hashCode();
            }

            public String toString() {
                return "DocumentContentTooLarge(encodedSession=" + this.encodedSession + ")";
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public DocumentContentTooLarge(String encodedSession) {
                super(null);
                Intrinsics.checkNotNullParameter(encodedSession, "encodedSession");
                this.encodedSession = encodedSession;
            }

            public final String getEncodedSession() {
                return this.encodedSession;
            }
        }

        /* JADX INFO: compiled from: BoxAiReducer.kt */
        @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÇ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÖ\u0003J\t\u0010\b\u001a\u00020\tHÖ\u0001J\t\u0010\n\u001a\u00020\u000bHÖ\u0001¨\u0006\f"}, d2 = {"Lcom/box/android/boxai/BoxAiReducer$Action$ResolveDocumentContentTooLarge;", "Lcom/box/android/boxai/BoxAiReducer$Action;", "<init>", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "boxai_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
        public static final /* data */ class ResolveDocumentContentTooLarge extends Action {
            public static final int $stable = 0;
            public static final ResolveDocumentContentTooLarge INSTANCE = new ResolveDocumentContentTooLarge();

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof ResolveDocumentContentTooLarge)) {
                    return false;
                }
                return true;
            }

            public int hashCode() {
                return 1739470502;
            }

            public String toString() {
                return "ResolveDocumentContentTooLarge";
            }

            private ResolveDocumentContentTooLarge() {
                super(null);
            }
        }

        /* JADX INFO: compiled from: BoxAiReducer.kt */
        @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u00012\b\u0012\u0004\u0012\u00020\u00030\u0002B\u000f\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\t\u0010\t\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\n\u001a\u00020\u00002\b\b\u0002\u0010\u0004\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000eHÖ\u0003J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\u0013"}, d2 = {"Lcom/box/android/boxai/BoxAiReducer$Action$QaAiAction;", "Lcom/box/android/boxai/BoxAiReducer$Action;", "Lcom/box/android/cpl/Embedded;", "Lcom/box/android/boxai/qa/BoxAiQaReducer$Action;", Analytics.Data.ACTION, "<init>", "(Lcom/box/android/boxai/qa/BoxAiQaReducer$Action;)V", "getAction", "()Lcom/box/android/boxai/qa/BoxAiQaReducer$Action;", "component1", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "", "other", "", "hashCode", "", "toString", "", "boxai_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
        public static final /* data */ class QaAiAction extends Action implements Embedded<BoxAiQaReducer.Action> {
            public static final int $stable = 0;
            private final BoxAiQaReducer.Action action;

            public static /* synthetic */ QaAiAction copy$default(QaAiAction qaAiAction, BoxAiQaReducer.Action action, int i, Object obj) {
                if ((i & 1) != 0) {
                    action = qaAiAction.action;
                }
                return qaAiAction.copy(action);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.box.android.cpl.Embedded
            /* JADX INFO: renamed from: component1, reason: from getter */
            public final BoxAiQaReducer.Action getAction() {
                return this.action;
            }

            public final QaAiAction copy(BoxAiQaReducer.Action action) {
                Intrinsics.checkNotNullParameter(action, "action");
                return new QaAiAction(action);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                return (other instanceof QaAiAction) && Intrinsics.areEqual(this.action, ((QaAiAction) other).action);
            }

            public int hashCode() {
                return this.action.hashCode();
            }

            public String toString() {
                return "QaAiAction(action=" + this.action + ")";
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public QaAiAction(BoxAiQaReducer.Action action) {
                super(null);
                Intrinsics.checkNotNullParameter(action, "action");
                this.action = action;
            }

            public final BoxAiQaReducer.Action getAction() {
                return this.action;
            }
        }

        /* JADX INFO: compiled from: BoxAiReducer.kt */
        @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u00012\b\u0012\u0004\u0012\u00020\u00030\u0002B\u000f\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\t\u0010\t\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\n\u001a\u00020\u00002\b\b\u0002\u0010\u0004\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000eHÖ\u0003J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\u0013"}, d2 = {"Lcom/box/android/boxai/BoxAiReducer$Action$AgentsAction;", "Lcom/box/android/boxai/BoxAiReducer$Action;", "Lcom/box/android/cpl/Embedded;", "Lcom/box/android/boxai/agents/BoxAiAgentsReducer$Action;", Analytics.Data.ACTION, "<init>", "(Lcom/box/android/boxai/agents/BoxAiAgentsReducer$Action;)V", "getAction", "()Lcom/box/android/boxai/agents/BoxAiAgentsReducer$Action;", "component1", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "", "other", "", "hashCode", "", "toString", "", "boxai_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
        public static final /* data */ class AgentsAction extends Action implements Embedded<BoxAiAgentsReducer.Action> {
            public static final int $stable = 0;
            private final BoxAiAgentsReducer.Action action;

            public static /* synthetic */ AgentsAction copy$default(AgentsAction agentsAction, BoxAiAgentsReducer.Action action, int i, Object obj) {
                if ((i & 1) != 0) {
                    action = agentsAction.action;
                }
                return agentsAction.copy(action);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.box.android.cpl.Embedded
            /* JADX INFO: renamed from: component1, reason: from getter */
            public final BoxAiAgentsReducer.Action getAction() {
                return this.action;
            }

            public final AgentsAction copy(BoxAiAgentsReducer.Action action) {
                Intrinsics.checkNotNullParameter(action, "action");
                return new AgentsAction(action);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                return (other instanceof AgentsAction) && Intrinsics.areEqual(this.action, ((AgentsAction) other).action);
            }

            public int hashCode() {
                return this.action.hashCode();
            }

            public String toString() {
                return "AgentsAction(action=" + this.action + ")";
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public AgentsAction(BoxAiAgentsReducer.Action action) {
                super(null);
                Intrinsics.checkNotNullParameter(action, "action");
                this.action = action;
            }

            public final BoxAiAgentsReducer.Action getAction() {
                return this.action;
            }
        }

        /* JADX INFO: compiled from: BoxAiReducer.kt */
        @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÇ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÖ\u0003J\t\u0010\b\u001a\u00020\tHÖ\u0001J\t\u0010\n\u001a\u00020\u000bHÖ\u0001¨\u0006\f"}, d2 = {"Lcom/box/android/boxai/BoxAiReducer$Action$Error;", "Lcom/box/android/boxai/BoxAiReducer$Action;", "<init>", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "boxai_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
        public static final /* data */ class Error extends Action {
            public static final int $stable = 0;
            public static final Error INSTANCE = new Error();

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof Error)) {
                    return false;
                }
                return true;
            }

            public int hashCode() {
                return 1758976635;
            }

            public String toString() {
                return "Error";
            }

            private Error() {
                super(null);
            }
        }

        /* JADX INFO: compiled from: BoxAiReducer.kt */
        @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÇ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÖ\u0003J\t\u0010\b\u001a\u00020\tHÖ\u0001J\t\u0010\n\u001a\u00020\u000bHÖ\u0001¨\u0006\f"}, d2 = {"Lcom/box/android/boxai/BoxAiReducer$Action$Dismiss;", "Lcom/box/android/boxai/BoxAiReducer$Action;", "<init>", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "boxai_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
        public static final /* data */ class Dismiss extends Action {
            public static final int $stable = 0;
            public static final Dismiss INSTANCE = new Dismiss();

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof Dismiss)) {
                    return false;
                }
                return true;
            }

            public int hashCode() {
                return 1310091837;
            }

            public String toString() {
                return "Dismiss";
            }

            private Dismiss() {
                super(null);
            }
        }

        /* JADX INFO: compiled from: BoxAiReducer.kt */
        @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÇ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÖ\u0003J\t\u0010\b\u001a\u00020\tHÖ\u0001J\t\u0010\n\u001a\u00020\u000bHÖ\u0001¨\u0006\f"}, d2 = {"Lcom/box/android/boxai/BoxAiReducer$Action$UpdateAppAlertAccepted;", "Lcom/box/android/boxai/BoxAiReducer$Action;", "<init>", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "boxai_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
        public static final /* data */ class UpdateAppAlertAccepted extends Action {
            public static final int $stable = 0;
            public static final UpdateAppAlertAccepted INSTANCE = new UpdateAppAlertAccepted();

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof UpdateAppAlertAccepted)) {
                    return false;
                }
                return true;
            }

            public int hashCode() {
                return 1559673688;
            }

            public String toString() {
                return "UpdateAppAlertAccepted";
            }

            private UpdateAppAlertAccepted() {
                super(null);
            }
        }

        /* JADX INFO: compiled from: BoxAiReducer.kt */
        @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÇ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÖ\u0003J\t\u0010\b\u001a\u00020\tHÖ\u0001J\t\u0010\n\u001a\u00020\u000bHÖ\u0001¨\u0006\f"}, d2 = {"Lcom/box/android/boxai/BoxAiReducer$Action$UpdateAppAlertAcknowledged;", "Lcom/box/android/boxai/BoxAiReducer$Action;", "<init>", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "boxai_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
        public static final /* data */ class UpdateAppAlertAcknowledged extends Action {
            public static final int $stable = 0;
            public static final UpdateAppAlertAcknowledged INSTANCE = new UpdateAppAlertAcknowledged();

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof UpdateAppAlertAcknowledged)) {
                    return false;
                }
                return true;
            }

            public int hashCode() {
                return 1571638393;
            }

            public String toString() {
                return "UpdateAppAlertAcknowledged";
            }

            private UpdateAppAlertAcknowledged() {
                super(null);
            }
        }

        /* JADX INFO: compiled from: BoxAiReducer.kt */
        @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0003J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0012"}, d2 = {"Lcom/box/android/boxai/BoxAiReducer$Action$HighlightCitation;", "Lcom/box/android/boxai/BoxAiReducer$Action;", "citation", "Lcom/box/android/domain/models/boxai/AiCitationModel;", "<init>", "(Lcom/box/android/domain/models/boxai/AiCitationModel;)V", "getCitation", "()Lcom/box/android/domain/models/boxai/AiCitationModel;", "component1", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "", "other", "", "hashCode", "", "toString", "", "boxai_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
        public static final /* data */ class HighlightCitation extends Action {
            public static final int $stable = 8;
            private final AiCitationModel citation;

            public static /* synthetic */ HighlightCitation copy$default(HighlightCitation highlightCitation, AiCitationModel aiCitationModel, int i, Object obj) {
                if ((i & 1) != 0) {
                    aiCitationModel = highlightCitation.citation;
                }
                return highlightCitation.copy(aiCitationModel);
            }

            /* JADX INFO: renamed from: component1, reason: from getter */
            public final AiCitationModel getCitation() {
                return this.citation;
            }

            public final HighlightCitation copy(AiCitationModel citation) {
                Intrinsics.checkNotNullParameter(citation, "citation");
                return new HighlightCitation(citation);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                return (other instanceof HighlightCitation) && Intrinsics.areEqual(this.citation, ((HighlightCitation) other).citation);
            }

            public int hashCode() {
                return this.citation.hashCode();
            }

            public String toString() {
                return "HighlightCitation(citation=" + this.citation + ")";
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public HighlightCitation(AiCitationModel citation) {
                super(null);
                Intrinsics.checkNotNullParameter(citation, "citation");
                this.citation = citation;
            }

            public final AiCitationModel getCitation() {
                return this.citation;
            }
        }

        /* JADX INFO: compiled from: BoxAiReducer.kt */
        @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/box/android/boxai/BoxAiReducer$Action$Companion;", "", "<init>", "()V", "boxai_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private Companion() {
            }
        }
    }

    @Override // com.box.android.cpl.Reducable
    public Reducable<State, Action> getBuild() {
        return this.build;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ReducerResult build$lambda$0(BoxAiReducer boxAiReducer, State state, Action action) {
        Intrinsics.checkNotNullParameter(state, "state");
        Intrinsics.checkNotNullParameter(action, "action");
        if (action instanceof Action.LaunchWithFiles) {
            return boxAiReducer.handleLaunchWithFiles(state, (Action.LaunchWithFiles) action);
        }
        if (action instanceof Action.ResetSession) {
            return new ReducerResult(State.copy$default(state, null, null, false, ScreenState.Uninitialized.INSTANCE, false, false, false, null, 247, null), null, 2, null);
        }
        if (action instanceof Action.UpdateSearchableState) {
            return new ReducerResult(State.copy$default(state, null, null, false, null, ((Action.UpdateSearchableState) action).getEnabled(), false, false, null, 239, null), null, 2, null);
        }
        if (action instanceof Action.CreateSession) {
            return boxAiReducer.handleCreateSession(state);
        }
        if (Intrinsics.areEqual(action, Action.UpdateAppAlertAcknowledged.INSTANCE) || Intrinsics.areEqual(action, Action.UpdateAppAlertAccepted.INSTANCE)) {
            return new ReducerResult(State.copy$default(state, null, null, false, null, false, false, false, null, 191, null), null, 2, null);
        }
        if (action instanceof Action.SessionCreated) {
            return new ReducerResult(State.copy$default(state, null, null, false, new ScreenState.QaSession(new BoxAiQaReducer.State(state.getFileModels(), state.getUnsupportedItems(), ((Action.SessionCreated) action).getEncodedSession(), state.isMultidoc(), state.isItemSearchable(), null, null, null, null, null, null, null, false, false, boxAiReducer.environment.getFeatureFlips().getPromptLibrary().getEnabled(), 16352, null)), false, false, false, null, 247, null), new Effect(new Action.QaAiAction(BoxAiQaReducer.Action.Initialize.INSTANCE)));
        }
        if (action instanceof Action.DocumentContentTooLarge) {
            return new ReducerResult(State.copy$default(state, null, null, false, new ScreenState.DocumentContentTooLarge(((Action.DocumentContentTooLarge) action).getEncodedSession()), false, false, false, null, 247, null), null, 2, null);
        }
        if (action instanceof Action.ResolveDocumentContentTooLarge) {
            ScreenState screenState = state.getScreenState();
            if (screenState instanceof ScreenState.DocumentContentTooLarge) {
                return new ReducerResult(state, new Effect(new Action.SessionCreated(((ScreenState.DocumentContentTooLarge) screenState).getEncodedSession())));
            }
            return new ReducerResult(state, null, 2, null);
        }
        if (action instanceof Action.Error) {
            return new ReducerResult(State.copy$default(state, null, null, false, ScreenState.Error.INSTANCE, false, false, false, null, 247, null), null, 2, null);
        }
        if (action instanceof Action.Dismiss) {
            return new ReducerResult(State.copy$default(state, null, null, false, null, false, false, false, null, 223, null), null, 2, null);
        }
        if (action instanceof Action.QaAiAction) {
            Action.QaAiAction qaAiAction = (Action.QaAiAction) action;
            if (qaAiAction.getAction() instanceof BoxAiQaReducer.Action.CitationClicked) {
                return new ReducerResult(State.copy$default(state, null, null, false, null, false, false, false, null, 223, null), new Effect(new Action.HighlightCitation(((BoxAiQaReducer.Action.CitationClicked) qaAiAction.getAction()).getCitation())));
            }
            return new ReducerResult(state, null, 2, null);
        }
        if (action instanceof Action.HighlightCitation) {
            return new ReducerResult(state, null, 2, null);
        }
        if (!(action instanceof Action.AgentsAction)) {
            throw new NoWhenBranchMatchedException();
        }
        Action.AgentsAction agentsAction = (Action.AgentsAction) action;
        if (agentsAction.getAction() instanceof BoxAiAgentsReducer.Action.SelectAgent) {
            return new ReducerResult(state, new Effect(new Action.QaAiAction(new BoxAiQaReducer.Action.SetAgent(((BoxAiAgentsReducer.Action.SelectAgent) agentsAction.getAction()).getAgent().getId()))));
        }
        return new ReducerResult(state, null, 2, null);
    }

    private final ReducerResult<State, Action> handleLaunchWithFiles(State state, Action.LaunchWithFiles action) {
        return this.environment.getFeatureFlips().getBoxAiApiChangesSafeguard().getEnabled() ? new ReducerResult<>(State.copy$default(state, null, null, false, null, false, false, true, null, 191, null), null, 2, null) : new ReducerResult<>(State.copy$default(state, action.getFileModels(), action.getUnsupportedItems(), false, null, false, true, false, null, 220, null), Effect.INSTANCE.merge(EffectKt.toEffect(FlowKt.flow(new C09381(state, null))), EffectKt.toEffect(FlowKt.flow(new AnonymousClass2(state, action, null)))));
    }

    /* JADX INFO: renamed from: com.box.android.boxai.BoxAiReducer$handleLaunchWithFiles$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: BoxAiReducer.kt */
    @Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\b\u0012\u0004\u0012\u00020\u00030\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/flow/FlowCollector;", "Lcom/box/android/boxai/BoxAiReducer$Action;"}, k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.box.android.boxai.BoxAiReducer$handleLaunchWithFiles$1", f = "BoxAiReducer.kt", i = {0, 1}, l = {209, BoxCommonConstants.REQUEST_OPTIONS}, m = "invokeSuspend", n = {"$this$flow", "$this$flow"}, s = {"L$0", "L$0"}, v = 1)
    static final class C09381 extends SuspendLambda implements Function2<FlowCollector<? super Action>, Continuation<? super Unit>, Object> {
        final /* synthetic */ State $state;
        private /* synthetic */ Object L$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C09381(State state, Continuation<? super C09381> continuation) {
            super(2, continuation);
            this.$state = state;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            C09381 c09381 = new C09381(this.$state, continuation);
            c09381.L$0 = obj;
            return c09381;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(FlowCollector<? super Action> flowCollector, Continuation<? super Unit> continuation) {
            return ((C09381) create(flowCollector, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Code restructure failed: missing block: B:16:0x0056, code lost:
        
            if (r0.emit(com.box.android.boxai.BoxAiReducerHelperKt.showKeyboard(com.box.android.boxai.BoxAiReducer.Action.INSTANCE), r6) == r1) goto L17;
         */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final java.lang.Object invokeSuspend(java.lang.Object r7) {
            /*
                r6 = this;
                java.lang.Object r0 = r6.L$0
                kotlinx.coroutines.flow.FlowCollector r0 = (kotlinx.coroutines.flow.FlowCollector) r0
                java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
                int r2 = r6.label
                r3 = 2
                r4 = 1
                if (r2 == 0) goto L22
                if (r2 == r4) goto L1e
                if (r2 != r3) goto L16
                kotlin.ResultKt.throwOnFailure(r7)
                goto L59
            L16:
                java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
                java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
                r6.<init>(r7)
                throw r6
            L1e:
                kotlin.ResultKt.throwOnFailure(r7)
                goto L41
            L22:
                kotlin.ResultKt.throwOnFailure(r7)
                com.box.android.boxai.BoxAiReducer$State r7 = r6.$state
                com.box.android.boxai.BoxAiReducer$ScreenState r7 = r7.getScreenState()
                boolean r7 = r7.hasPrompts()
                if (r7 == 0) goto L59
                r7 = r6
                kotlin.coroutines.Continuation r7 = (kotlin.coroutines.Continuation) r7
                r6.L$0 = r0
                r6.label = r4
                r4 = 300(0x12c, double:1.48E-321)
                java.lang.Object r7 = kotlinx.coroutines.DelayKt.delay(r4, r7)
                if (r7 != r1) goto L41
                goto L58
            L41:
                com.box.android.boxai.BoxAiReducer$Action$Companion r7 = com.box.android.boxai.BoxAiReducer.Action.INSTANCE
                com.box.android.boxai.BoxAiReducer$Action r7 = com.box.android.boxai.BoxAiReducerHelperKt.showKeyboard(r7)
                r2 = r6
                kotlin.coroutines.Continuation r2 = (kotlin.coroutines.Continuation) r2
                java.lang.Object r4 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r0)
                r6.L$0 = r4
                r6.label = r3
                java.lang.Object r6 = r0.emit(r7, r2)
                if (r6 != r1) goto L59
            L58:
                return r1
            L59:
                kotlin.Unit r6 = kotlin.Unit.INSTANCE
                return r6
            */
            throw new UnsupportedOperationException("Method not decompiled: com.box.android.boxai.BoxAiReducer.C09381.invokeSuspend(java.lang.Object):java.lang.Object");
        }
    }

    /* JADX INFO: renamed from: com.box.android.boxai.BoxAiReducer$handleLaunchWithFiles$2, reason: invalid class name */
    /* JADX INFO: compiled from: BoxAiReducer.kt */
    @Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\b\u0012\u0004\u0012\u00020\u00030\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/flow/FlowCollector;", "Lcom/box/android/boxai/BoxAiReducer$Action$QaAiAction;"}, k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.box.android.boxai.BoxAiReducer$handleLaunchWithFiles$2", f = "BoxAiReducer.kt", i = {0}, l = {JfifUtil.MARKER_RST7}, m = "invokeSuspend", n = {"$this$flow"}, s = {"L$0"}, v = 1)
    static final class AnonymousClass2 extends SuspendLambda implements Function2<FlowCollector<? super Action.QaAiAction>, Continuation<? super Unit>, Object> {
        final /* synthetic */ Action.LaunchWithFiles $action;
        final /* synthetic */ State $state;
        private /* synthetic */ Object L$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass2(State state, Action.LaunchWithFiles launchWithFiles, Continuation<? super AnonymousClass2> continuation) {
            super(2, continuation);
            this.$state = state;
            this.$action = launchWithFiles;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            AnonymousClass2 anonymousClass2 = new AnonymousClass2(this.$state, this.$action, continuation);
            anonymousClass2.L$0 = obj;
            return anonymousClass2;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(FlowCollector<? super Action.QaAiAction> flowCollector, Continuation<? super Unit> continuation) {
            return ((AnonymousClass2) create(flowCollector, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            FlowCollector flowCollector = (FlowCollector) this.L$0;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                if (this.$state.getScreenState() instanceof ScreenState.QaSession) {
                    this.L$0 = SpillingKt.nullOutSpilledVariable(flowCollector);
                    this.label = 1;
                    if (flowCollector.emit(new Action.QaAiAction(new BoxAiQaReducer.Action.UpdateFiles(this.$action.getFileModels(), this.$action.getUnsupportedItems())), this) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
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

    private final ReducerResult<State, Action> handleCreateSession(State state) {
        return new ReducerResult<>(state, EffectKt.toEffect(FlowKt.flow(new AnonymousClass1(state, null))));
    }

    /* JADX INFO: renamed from: com.box.android.boxai.BoxAiReducer$handleCreateSession$1, reason: invalid class name */
    /* JADX INFO: compiled from: BoxAiReducer.kt */
    @Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\b\u0012\u0004\u0012\u00020\u00030\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/flow/FlowCollector;", "Lcom/box/android/boxai/BoxAiReducer$Action;"}, k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.box.android.boxai.BoxAiReducer$handleCreateSession$1", f = "BoxAiReducer.kt", i = {0, 1, 2, 2, 2, 2, 2, 3, 3, 3, 3, 3, 4, 4, 4, 4, 4}, l = {233, 235, 237, 239, 250}, m = "invokeSuspend", n = {"$this$flow", "$this$flow", "$this$flow", "$this$onSuccess$iv", "it", "$i$f$onSuccess", "$i$a$-onSuccess-BoxAiReducer$handleCreateSession$1$2", "$this$flow", "$this$onSuccess$iv", "it", "$i$f$onSuccess", "$i$a$-onSuccess-BoxAiReducer$handleCreateSession$1$2", "$this$flow", "$this$onError$iv", "it", "$i$f$onError", "$i$a$-onError-BoxAiReducer$handleCreateSession$1$3"}, s = {"L$0", "L$0", "L$0", "L$1", "L$4", "I$0", "I$1", "L$0", "L$1", "L$4", "I$0", "I$1", "L$0", "L$1", "L$2", "I$0", "I$1"}, v = 1)
    static final class AnonymousClass1 extends SuspendLambda implements Function2<FlowCollector<? super Action>, Continuation<? super Unit>, Object> {
        final /* synthetic */ State $state;
        int I$0;
        int I$1;
        private /* synthetic */ Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        Object L$4;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(State state, Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
            this.$state = state;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            AnonymousClass1 anonymousClass1 = BoxAiReducer.this.new AnonymousClass1(this.$state, continuation);
            anonymousClass1.L$0 = obj;
            return anonymousClass1;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(FlowCollector<? super Action> flowCollector, Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(flowCollector, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Code duplicated, block: B:29:0x00d1  */
        /* JADX WARN: Code duplicated, block: B:31:0x00e0  */
        /* JADX WARN: Code duplicated, block: B:35:0x0105  */
        /* JADX WARN: Code duplicated, block: B:39:0x013c  */
        /* JADX WARN: Code duplicated, block: B:43:0x0148  */
        /* JADX WARN: Code duplicated, block: B:45:0x014c  */
        /* JADX WARN: Code duplicated, block: B:48:0x018a  */
        /* JADX WARN: Code duplicated, block: B:52:0x0193  */
        /* JADX WARN: Code restructure failed: missing block: B:32:0x00fd, code lost:
        
            if (r1.emit(r5, r16) == r2) goto L47;
         */
        /* JADX WARN: Code restructure failed: missing block: B:34:0x0101, code lost:
        
            r6 = r3;
            r5 = r8;
            r3 = r10;
         */
        /* JADX WARN: Code restructure failed: missing block: B:36:0x0122, code lost:
        
            if (r1.emit(r6, r16) == r2) goto L47;
         */
        /* JADX WARN: Code restructure failed: missing block: B:46:0x0187, code lost:
        
            if (r1.emit(r3, r16) == r2) goto L47;
         */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final java.lang.Object invokeSuspend(java.lang.Object r17) {
            /*
                Method dump skipped, instruction units count: 409
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: com.box.android.boxai.BoxAiReducer.AnonymousClass1.invokeSuspend(java.lang.Object):java.lang.Object");
        }
    }
}
