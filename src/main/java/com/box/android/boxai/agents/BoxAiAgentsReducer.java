package com.box.android.boxai.agents;

import com.box.android.boxai.BoxAiEnvironment;
import com.box.android.cpl.EffectKt;
import com.box.android.cpl.Reducable;
import com.box.android.cpl.Reduce;
import com.box.android.cpl.ReducerResult;
import com.box.android.domain.analytics.BoxAmplitudeAnalytics;
import com.box.android.domain.models.boxai.AiAgentModel;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.FlowKt;

/* JADX INFO: compiled from: BoxAiAgentsReducer.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0007\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0002\u000f\u0010B\u000f\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u001c\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\r2\u0006\u0010\u000e\u001a\u00020\u0002H\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R \u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\tX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0011"}, d2 = {"Lcom/box/android/boxai/agents/BoxAiAgentsReducer;", "Lcom/box/android/cpl/Reducable;", "Lcom/box/android/boxai/agents/BoxAiAgentsReducer$State;", "Lcom/box/android/boxai/agents/BoxAiAgentsReducer$Action;", "environment", "Lcom/box/android/boxai/BoxAiEnvironment;", "<init>", "(Lcom/box/android/boxai/BoxAiEnvironment;)V", "build", "Lcom/box/android/cpl/Reduce;", "getBuild", "()Lcom/box/android/cpl/Reduce;", "handleGetAgents", "Lcom/box/android/cpl/ReducerResult;", "state", "State", "Action", "boxai_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class BoxAiAgentsReducer implements Reducable<State, Action> {
    public static final int $stable = 8;
    private final Reduce<State, Action> build;
    private final BoxAiEnvironment environment;

    public BoxAiAgentsReducer(BoxAiEnvironment environment) {
        Intrinsics.checkNotNullParameter(environment, "environment");
        this.environment = environment;
        this.build = new Reduce<>(new Function2() { // from class: com.box.android.boxai.agents.BoxAiAgentsReducer$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(Object obj, Object obj2) {
                return BoxAiAgentsReducer.build$lambda$0(this.f$0, (BoxAiAgentsReducer.State) obj, (BoxAiAgentsReducer.Action) obj2);
            }
        });
    }

    @Override // com.box.android.cpl.Reducable
    public /* bridge */ ReducerResult<State, Action> reduce(State state, Action action) {
        return Reducable.DefaultImpls.reduce(this, state, action);
    }

    /* JADX INFO: compiled from: BoxAiAgentsReducer.kt */
    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B#\u0012\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\u000f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003J\u000b\u0010\r\u001a\u0004\u0018\u00010\u0004HÆ\u0003J%\u0010\u000e\u001a\u00020\u00002\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0015HÖ\u0001R\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0016"}, d2 = {"Lcom/box/android/boxai/agents/BoxAiAgentsReducer$State;", "", "agents", "", "Lcom/box/android/domain/models/boxai/AiAgentModel;", "selectedAgent", "<init>", "(Ljava/util/List;Lcom/box/android/domain/models/boxai/AiAgentModel;)V", "getAgents", "()Ljava/util/List;", "getSelectedAgent", "()Lcom/box/android/domain/models/boxai/AiAgentModel;", "component1", "component2", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "", "other", "hashCode", "", "toString", "", "boxai_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final /* data */ class State {
        public static final int $stable = 8;
        private final List<AiAgentModel> agents;
        private final AiAgentModel selectedAgent;

        /* JADX WARN: Multi-variable type inference failed */
        public State() {
            this(null, 0 == true ? 1 : 0, 3, 0 == true ? 1 : 0);
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ State copy$default(State state, List list, AiAgentModel aiAgentModel, int i, Object obj) {
            if ((i & 1) != 0) {
                list = state.agents;
            }
            if ((i & 2) != 0) {
                aiAgentModel = state.selectedAgent;
            }
            return state.copy(list, aiAgentModel);
        }

        public final List<AiAgentModel> component1() {
            return this.agents;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final AiAgentModel getSelectedAgent() {
            return this.selectedAgent;
        }

        public final State copy(List<AiAgentModel> agents, AiAgentModel selectedAgent) {
            Intrinsics.checkNotNullParameter(agents, "agents");
            return new State(agents, selectedAgent);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof State)) {
                return false;
            }
            State state = (State) other;
            return Intrinsics.areEqual(this.agents, state.agents) && Intrinsics.areEqual(this.selectedAgent, state.selectedAgent);
        }

        public int hashCode() {
            int iHashCode = this.agents.hashCode() * 31;
            AiAgentModel aiAgentModel = this.selectedAgent;
            return iHashCode + (aiAgentModel == null ? 0 : aiAgentModel.hashCode());
        }

        public String toString() {
            return "State(agents=" + this.agents + ", selectedAgent=" + this.selectedAgent + ")";
        }

        public State(List<AiAgentModel> agents, AiAgentModel aiAgentModel) {
            Intrinsics.checkNotNullParameter(agents, "agents");
            this.agents = agents;
            this.selectedAgent = aiAgentModel;
        }

        public /* synthetic */ State(List list, AiAgentModel aiAgentModel, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? CollectionsKt.emptyList() : list, (i & 2) != 0 ? null : aiAgentModel);
        }

        public final List<AiAgentModel> getAgents() {
            return this.agents;
        }

        public final AiAgentModel getSelectedAgent() {
            return this.selectedAgent;
        }
    }

    /* JADX INFO: compiled from: BoxAiAgentsReducer.kt */
    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b7\u0018\u00002\u00020\u0001:\u0004\u0004\u0005\u0006\u0007B\t\b\u0004¢\u0006\u0004\b\u0002\u0010\u0003\u0082\u0001\u0004\b\t\n\u000b¨\u0006\f"}, d2 = {"Lcom/box/android/boxai/agents/BoxAiAgentsReducer$Action;", "", "<init>", "()V", "LoadAgents", "AgentsLoaded", "SelectAgent", "Error", "Lcom/box/android/boxai/agents/BoxAiAgentsReducer$Action$AgentsLoaded;", "Lcom/box/android/boxai/agents/BoxAiAgentsReducer$Action$Error;", "Lcom/box/android/boxai/agents/BoxAiAgentsReducer$Action$LoadAgents;", "Lcom/box/android/boxai/agents/BoxAiAgentsReducer$Action$SelectAgent;", "boxai_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static abstract class Action {
        public static final int $stable = 0;

        public /* synthetic */ Action(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* JADX INFO: compiled from: BoxAiAgentsReducer.kt */
        @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/box/android/boxai/agents/BoxAiAgentsReducer$Action$LoadAgents;", "Lcom/box/android/boxai/agents/BoxAiAgentsReducer$Action;", "<init>", "()V", "boxai_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
        public static final class LoadAgents extends Action {
            public static final int $stable = 0;
            public static final LoadAgents INSTANCE = new LoadAgents();

            private LoadAgents() {
                super(null);
            }
        }

        private Action() {
        }

        /* JADX INFO: compiled from: BoxAiAgentsReducer.kt */
        @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u0015\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003J\u0019\u0010\n\u001a\u00020\u00002\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0001J\u0013\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000eHÖ\u0003J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001R\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\u0013"}, d2 = {"Lcom/box/android/boxai/agents/BoxAiAgentsReducer$Action$AgentsLoaded;", "Lcom/box/android/boxai/agents/BoxAiAgentsReducer$Action;", "agents", "", "Lcom/box/android/domain/models/boxai/AiAgentModel;", "<init>", "(Ljava/util/List;)V", "getAgents", "()Ljava/util/List;", "component1", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "", "other", "", "hashCode", "", "toString", "", "boxai_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
        public static final /* data */ class AgentsLoaded extends Action {
            public static final int $stable = 8;
            private final List<AiAgentModel> agents;

            /* JADX WARN: Multi-variable type inference failed */
            public static /* synthetic */ AgentsLoaded copy$default(AgentsLoaded agentsLoaded, List list, int i, Object obj) {
                if ((i & 1) != 0) {
                    list = agentsLoaded.agents;
                }
                return agentsLoaded.copy(list);
            }

            public final List<AiAgentModel> component1() {
                return this.agents;
            }

            public final AgentsLoaded copy(List<AiAgentModel> agents) {
                Intrinsics.checkNotNullParameter(agents, "agents");
                return new AgentsLoaded(agents);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                return (other instanceof AgentsLoaded) && Intrinsics.areEqual(this.agents, ((AgentsLoaded) other).agents);
            }

            public int hashCode() {
                return this.agents.hashCode();
            }

            public String toString() {
                return "AgentsLoaded(agents=" + this.agents + ")";
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public AgentsLoaded(List<AiAgentModel> agents) {
                super(null);
                Intrinsics.checkNotNullParameter(agents, "agents");
                this.agents = agents;
            }

            public final List<AiAgentModel> getAgents() {
                return this.agents;
            }
        }

        /* JADX INFO: compiled from: BoxAiAgentsReducer.kt */
        @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0003J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0012"}, d2 = {"Lcom/box/android/boxai/agents/BoxAiAgentsReducer$Action$SelectAgent;", "Lcom/box/android/boxai/agents/BoxAiAgentsReducer$Action;", "agent", "Lcom/box/android/domain/models/boxai/AiAgentModel;", "<init>", "(Lcom/box/android/domain/models/boxai/AiAgentModel;)V", "getAgent", "()Lcom/box/android/domain/models/boxai/AiAgentModel;", "component1", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "", "other", "", "hashCode", "", "toString", "", "boxai_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
        public static final /* data */ class SelectAgent extends Action {
            public static final int $stable = 8;
            private final AiAgentModel agent;

            public static /* synthetic */ SelectAgent copy$default(SelectAgent selectAgent, AiAgentModel aiAgentModel, int i, Object obj) {
                if ((i & 1) != 0) {
                    aiAgentModel = selectAgent.agent;
                }
                return selectAgent.copy(aiAgentModel);
            }

            /* JADX INFO: renamed from: component1, reason: from getter */
            public final AiAgentModel getAgent() {
                return this.agent;
            }

            public final SelectAgent copy(AiAgentModel agent) {
                Intrinsics.checkNotNullParameter(agent, "agent");
                return new SelectAgent(agent);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                return (other instanceof SelectAgent) && Intrinsics.areEqual(this.agent, ((SelectAgent) other).agent);
            }

            public int hashCode() {
                return this.agent.hashCode();
            }

            public String toString() {
                return "SelectAgent(agent=" + this.agent + ")";
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public SelectAgent(AiAgentModel agent) {
                super(null);
                Intrinsics.checkNotNullParameter(agent, "agent");
                this.agent = agent;
            }

            public final AiAgentModel getAgent() {
                return this.agent;
            }
        }

        /* JADX INFO: compiled from: BoxAiAgentsReducer.kt */
        @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/box/android/boxai/agents/BoxAiAgentsReducer$Action$Error;", "Lcom/box/android/boxai/agents/BoxAiAgentsReducer$Action;", "<init>", "()V", "boxai_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
        public static final class Error extends Action {
            public static final int $stable = 0;
            public static final Error INSTANCE = new Error();

            private Error() {
                super(null);
            }
        }
    }

    @Override // com.box.android.cpl.Reducable
    public Reducable<State, Action> getBuild() {
        return this.build;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ReducerResult build$lambda$0(BoxAiAgentsReducer boxAiAgentsReducer, State state, Action action) {
        Object next;
        Intrinsics.checkNotNullParameter(state, "state");
        Intrinsics.checkNotNullParameter(action, "action");
        if (action instanceof Action.LoadAgents) {
            return boxAiAgentsReducer.handleGetAgents(state);
        }
        if (action instanceof Action.AgentsLoaded) {
            Action.AgentsLoaded agentsLoaded = (Action.AgentsLoaded) action;
            List<AiAgentModel> agents = agentsLoaded.getAgents();
            Iterator<T> it = agentsLoaded.getAgents().iterator();
            do {
                if (!it.hasNext()) {
                    next = null;
                    break;
                }
                next = it.next();
            } while (!((AiAgentModel) next).isDefault());
            AiAgentModel aiAgentModel = (AiAgentModel) next;
            if (aiAgentModel == null) {
                aiAgentModel = (AiAgentModel) CollectionsKt.firstOrNull((List) agentsLoaded.getAgents());
            }
            return new ReducerResult(state.copy(agents, aiAgentModel), null, 2, null);
        }
        if (action instanceof Action.SelectAgent) {
            return new ReducerResult(State.copy$default(state, null, ((Action.SelectAgent) action).getAgent(), 1, null), null, 2, null);
        }
        if (!(action instanceof Action.Error)) {
            throw new NoWhenBranchMatchedException();
        }
        return new ReducerResult(state.copy(CollectionsKt.emptyList(), null), null, 2, null);
    }

    private final ReducerResult<State, Action> handleGetAgents(State state) {
        return new ReducerResult<>(state, EffectKt.toEffect(FlowKt.flow(new AnonymousClass1(null))));
    }

    /* JADX INFO: renamed from: com.box.android.boxai.agents.BoxAiAgentsReducer$handleGetAgents$1, reason: invalid class name */
    /* JADX INFO: compiled from: BoxAiAgentsReducer.kt */
    @Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\b\u0012\u0004\u0012\u00020\u00030\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/flow/FlowCollector;", "Lcom/box/android/boxai/agents/BoxAiAgentsReducer$Action;"}, k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.box.android.boxai.agents.BoxAiAgentsReducer$handleGetAgents$1", f = "BoxAiAgentsReducer.kt", i = {0, 1, 1, 1, 1, 1, 2, 2, 2, 2, 2}, l = {56, 57, 59}, m = "invokeSuspend", n = {"$this$flow", "$this$flow", "$this$onSuccess$iv", "it", "$i$f$onSuccess", "$i$a$-onSuccess-BoxAiAgentsReducer$handleGetAgents$1$1", "$this$flow", "$this$onError$iv", "it", "$i$f$onError", "$i$a$-onError-BoxAiAgentsReducer$handleGetAgents$1$2"}, s = {"L$0", "L$0", "L$1", "L$2", "I$0", "I$1", "L$0", "L$1", "L$2", "I$0", "I$1"}, v = 1)
    static final class AnonymousClass1 extends SuspendLambda implements Function2<FlowCollector<? super Action>, Continuation<? super Unit>, Object> {
        int I$0;
        int I$1;
        private /* synthetic */ Object L$0;
        Object L$1;
        Object L$2;
        int label;

        AnonymousClass1(Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            AnonymousClass1 anonymousClass1 = BoxAiAgentsReducer.this.new AnonymousClass1(continuation);
            anonymousClass1.L$0 = obj;
            return anonymousClass1;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(FlowCollector<? super Action> flowCollector, Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(flowCollector, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Code duplicated, block: B:24:0x008a  */
        /* JADX WARN: Code duplicated, block: B:26:0x008e  */
        /* JADX WARN: Code duplicated, block: B:29:0x00b4  */
        /* JADX WARN: Code restructure failed: missing block: B:27:0x00b1, code lost:
        
            if (r0.emit(r4, r7) == r1) goto L28;
         */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final java.lang.Object invokeSuspend(java.lang.Object r8) {
            /*
                r7 = this;
                java.lang.Object r0 = r7.L$0
                kotlinx.coroutines.flow.FlowCollector r0 = (kotlinx.coroutines.flow.FlowCollector) r0
                java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
                int r2 = r7.label
                r3 = 3
                r4 = 2
                r5 = 1
                r6 = 0
                if (r2 == 0) goto L3b
                if (r2 == r5) goto L37
                if (r2 == r4) goto L2b
                if (r2 != r3) goto L23
                java.lang.Object r0 = r7.L$2
                com.box.android.domain.models.DomainError r0 = (com.box.android.domain.models.DomainError) r0
                java.lang.Object r7 = r7.L$1
                com.box.android.domain.utils.result.Result r7 = (com.box.android.domain.utils.result.Result) r7
                kotlin.ResultKt.throwOnFailure(r8)
                goto Lba
            L23:
                java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
                java.lang.String r8 = "call to 'resume' before 'invoke' with coroutine"
                r7.<init>(r8)
                throw r7
            L2b:
                java.lang.Object r2 = r7.L$2
                java.util.List r2 = (java.util.List) r2
                java.lang.Object r2 = r7.L$1
                com.box.android.domain.utils.result.Result r2 = (com.box.android.domain.utils.result.Result) r2
                kotlin.ResultKt.throwOnFailure(r8)
                goto L86
            L37:
                kotlin.ResultKt.throwOnFailure(r8)
                goto L56
            L3b:
                kotlin.ResultKt.throwOnFailure(r8)
                com.box.android.boxai.agents.BoxAiAgentsReducer r8 = com.box.android.boxai.agents.BoxAiAgentsReducer.this
                com.box.android.boxai.BoxAiEnvironment r8 = com.box.android.boxai.agents.BoxAiAgentsReducer.access$getEnvironment$p(r8)
                com.box.android.domain.services.IBoxAiService r8 = r8.getBoxAiService()
                r2 = r7
                kotlin.coroutines.Continuation r2 = (kotlin.coroutines.Continuation) r2
                r7.L$0 = r0
                r7.label = r5
                java.lang.Object r8 = r8.getAgents(r2)
                if (r8 != r1) goto L56
                goto Lb3
            L56:
                r2 = r8
                com.box.android.domain.utils.result.Result r2 = (com.box.android.domain.utils.result.Result) r2
                boolean r8 = r2 instanceof com.box.android.domain.utils.result.Result.Success
                if (r8 == 0) goto L82
                r8 = r2
                com.box.android.domain.utils.result.Result$Success r8 = (com.box.android.domain.utils.result.Result.Success) r8
                java.lang.Object r8 = r8.getValue()
                java.util.List r8 = (java.util.List) r8
                com.box.android.boxai.agents.BoxAiAgentsReducer$Action$AgentsLoaded r5 = new com.box.android.boxai.agents.BoxAiAgentsReducer$Action$AgentsLoaded
                r5.<init>(r8)
                r7.L$0 = r0
                r7.L$1 = r2
                java.lang.Object r8 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r8)
                r7.L$2 = r8
                r7.I$0 = r6
                r7.I$1 = r6
                r7.label = r4
                java.lang.Object r8 = r0.emit(r5, r7)
                if (r8 != r1) goto L86
                goto Lb3
            L82:
                boolean r8 = r2 instanceof com.box.android.domain.utils.result.Result.Error
                if (r8 == 0) goto Lbd
            L86:
                boolean r8 = r2 instanceof com.box.android.domain.utils.result.Result.Success
                if (r8 != 0) goto Lba
                boolean r8 = r2 instanceof com.box.android.domain.utils.result.Result.Error
                if (r8 == 0) goto Lb4
                r8 = r2
                com.box.android.domain.utils.result.Result$Error r8 = (com.box.android.domain.utils.result.Result.Error) r8
                java.lang.Object r8 = r8.getValue()
                com.box.android.domain.models.DomainError r8 = (com.box.android.domain.models.DomainError) r8
                com.box.android.boxai.agents.BoxAiAgentsReducer$Action$Error r4 = com.box.android.boxai.agents.BoxAiAgentsReducer.Action.Error.INSTANCE
                java.lang.Object r5 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r0)
                r7.L$0 = r5
                r7.L$1 = r2
                java.lang.Object r8 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r8)
                r7.L$2 = r8
                r7.I$0 = r6
                r7.I$1 = r6
                r7.label = r3
                java.lang.Object r7 = r0.emit(r4, r7)
                if (r7 != r1) goto Lba
            Lb3:
                return r1
            Lb4:
                kotlin.NoWhenBranchMatchedException r7 = new kotlin.NoWhenBranchMatchedException
                r7.<init>()
                throw r7
            Lba:
                kotlin.Unit r7 = kotlin.Unit.INSTANCE
                return r7
            Lbd:
                kotlin.NoWhenBranchMatchedException r7 = new kotlin.NoWhenBranchMatchedException
                r7.<init>()
                throw r7
            */
            throw new UnsupportedOperationException("Method not decompiled: com.box.android.boxai.agents.BoxAiAgentsReducer.AnonymousClass1.invokeSuspend(java.lang.Object):java.lang.Object");
        }
    }
}
