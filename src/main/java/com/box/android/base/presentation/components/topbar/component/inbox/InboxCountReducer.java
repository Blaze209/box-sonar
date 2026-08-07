package com.box.android.base.presentation.components.topbar.component.inbox;

import androidx.lifecycle.FlowLiveDataConversions;
import com.box.android.cpl.Effect;
import com.box.android.cpl.EffectKt;
import com.box.android.cpl.Reducable;
import com.box.android.cpl.Reduce;
import com.box.android.cpl.ReducerResult;
import com.box.android.domain.analytics.BoxAmplitudeAnalytics;
import com.box.androidsdk.content.requests.BoxResponse;
import com.box.boxandroidlibv2private.model.BoxTaskBadge;
import com.pspdfkit.analytics.Analytics;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowKt;

/* JADX INFO: compiled from: InboxCountReducer.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0007\u0018\u0000 \u00132\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0003\u0011\u0012\u0013B\u000f\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J$\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\f2\u0006\u0010\r\u001a\u00020\u00022\u0006\u0010\u000e\u001a\u00020\u0003H\u0002J\u000e\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00030\u0010H\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R \u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u0014"}, d2 = {"Lcom/box/android/base/presentation/components/topbar/component/inbox/InboxCountReducer;", "Lcom/box/android/cpl/Reducable;", "Lcom/box/android/base/presentation/components/topbar/component/inbox/InboxCountReducer$State;", "Lcom/box/android/base/presentation/components/topbar/component/inbox/InboxCountReducer$Action;", "environment", "Lcom/box/android/base/presentation/components/topbar/component/inbox/InboxCountEnvironment;", "<init>", "(Lcom/box/android/base/presentation/components/topbar/component/inbox/InboxCountEnvironment;)V", "build", "getBuild", "()Lcom/box/android/cpl/Reducable;", "reduceInboxCount", "Lcom/box/android/cpl/ReducerResult;", "state", Analytics.Data.ACTION, "observeInboxBadgeFlow", "Lkotlinx/coroutines/flow/Flow;", "State", "Action", "Companion", "base_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class InboxCountReducer implements Reducable<State, Action> {
    private static final String OBSERVE_INBOX_BADGE_COUNT_ID = "observe_inbox_badge_count_id";
    private final Reducable<State, Action> build;
    private final InboxCountEnvironment environment;
    public static final int $stable = 8;

    public InboxCountReducer(InboxCountEnvironment environment) {
        Intrinsics.checkNotNullParameter(environment, "environment");
        this.environment = environment;
        this.build = new Reduce(new InboxCountReducer$build$1(this));
    }

    @Override // com.box.android.cpl.Reducable
    public /* bridge */ ReducerResult<State, Action> reduce(State state, Action action) {
        return Reducable.DefaultImpls.reduce(this, state, action);
    }

    /* JADX INFO: compiled from: InboxCountReducer.kt */
    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u0013\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\t\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u0007J\u001a\u0010\n\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003HÆ\u0001¢\u0006\u0002\u0010\u000bJ\u0013\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u000f\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001R\u0015\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0012"}, d2 = {"Lcom/box/android/base/presentation/components/topbar/component/inbox/InboxCountReducer$State;", "", "inboxBadgeCount", "", "<init>", "(Ljava/lang/Integer;)V", "getInboxBadgeCount", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "component1", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "(Ljava/lang/Integer;)Lcom/box/android/base/presentation/components/topbar/component/inbox/InboxCountReducer$State;", "equals", "", "other", "hashCode", "toString", "", "base_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final /* data */ class State {
        public static final int $stable = 0;
        private final Integer inboxBadgeCount;

        /* JADX WARN: Multi-variable type inference failed */
        public State() {
            this(null, 1, 0 == true ? 1 : 0);
        }

        public static /* synthetic */ State copy$default(State state, Integer num, int i, Object obj) {
            if ((i & 1) != 0) {
                num = state.inboxBadgeCount;
            }
            return state.copy(num);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final Integer getInboxBadgeCount() {
            return this.inboxBadgeCount;
        }

        public final State copy(Integer inboxBadgeCount) {
            return new State(inboxBadgeCount);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            return (other instanceof State) && Intrinsics.areEqual(this.inboxBadgeCount, ((State) other).inboxBadgeCount);
        }

        public int hashCode() {
            Integer num = this.inboxBadgeCount;
            if (num == null) {
                return 0;
            }
            return num.hashCode();
        }

        public String toString() {
            return "State(inboxBadgeCount=" + this.inboxBadgeCount + ")";
        }

        public State(Integer num) {
            this.inboxBadgeCount = num;
        }

        public /* synthetic */ State(Integer num, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? null : num);
        }

        public final Integer getInboxBadgeCount() {
            return this.inboxBadgeCount;
        }
    }

    /* JADX INFO: compiled from: InboxCountReducer.kt */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b7\u0018\u00002\u00020\u0001:\u0002\u0004\u0005B\t\b\u0004¢\u0006\u0004\b\u0002\u0010\u0003\u0082\u0001\u0002\u0006\u0007¨\u0006\b"}, d2 = {"Lcom/box/android/base/presentation/components/topbar/component/inbox/InboxCountReducer$Action;", "", "<init>", "()V", "Initialize", "InboxBadgeCountChanged", "Lcom/box/android/base/presentation/components/topbar/component/inbox/InboxCountReducer$Action$InboxBadgeCountChanged;", "Lcom/box/android/base/presentation/components/topbar/component/inbox/InboxCountReducer$Action$Initialize;", "base_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static abstract class Action {
        public static final int $stable = 0;

        public /* synthetic */ Action(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* JADX INFO: compiled from: InboxCountReducer.kt */
        @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÇ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÖ\u0003J\t\u0010\b\u001a\u00020\tHÖ\u0001J\t\u0010\n\u001a\u00020\u000bHÖ\u0001¨\u0006\f"}, d2 = {"Lcom/box/android/base/presentation/components/topbar/component/inbox/InboxCountReducer$Action$Initialize;", "Lcom/box/android/base/presentation/components/topbar/component/inbox/InboxCountReducer$Action;", "<init>", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "base_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
        public static final /* data */ class Initialize extends Action {
            public static final int $stable = 0;
            public static final Initialize INSTANCE = new Initialize();

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof Initialize)) {
                    return false;
                }
                return true;
            }

            public int hashCode() {
                return 1947857830;
            }

            public String toString() {
                return "Initialize";
            }

            private Initialize() {
                super(null);
            }
        }

        private Action() {
        }

        /* JADX INFO: compiled from: InboxCountReducer.kt */
        @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0003J\t\u0010\u000e\u001a\u00020\u0003HÖ\u0001J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0011"}, d2 = {"Lcom/box/android/base/presentation/components/topbar/component/inbox/InboxCountReducer$Action$InboxBadgeCountChanged;", "Lcom/box/android/base/presentation/components/topbar/component/inbox/InboxCountReducer$Action;", "count", "", "<init>", "(I)V", "getCount", "()I", "component1", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "", "other", "", "hashCode", "toString", "", "base_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
        public static final /* data */ class InboxBadgeCountChanged extends Action {
            public static final int $stable = 0;
            private final int count;

            public static /* synthetic */ InboxBadgeCountChanged copy$default(InboxBadgeCountChanged inboxBadgeCountChanged, int i, int i2, Object obj) {
                if ((i2 & 1) != 0) {
                    i = inboxBadgeCountChanged.count;
                }
                return inboxBadgeCountChanged.copy(i);
            }

            /* JADX INFO: renamed from: component1, reason: from getter */
            public final int getCount() {
                return this.count;
            }

            public final InboxBadgeCountChanged copy(int count) {
                return new InboxBadgeCountChanged(count);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                return (other instanceof InboxBadgeCountChanged) && this.count == ((InboxBadgeCountChanged) other).count;
            }

            public int hashCode() {
                return Integer.hashCode(this.count);
            }

            public String toString() {
                return "InboxBadgeCountChanged(count=" + this.count + ")";
            }

            public InboxBadgeCountChanged(int i) {
                super(null);
                this.count = i;
            }

            public final int getCount() {
                return this.count;
            }
        }
    }

    @Override // com.box.android.cpl.Reducable
    public Reducable<State, Action> getBuild() {
        return this.build;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public final ReducerResult<State, Action> reduceInboxCount(State state, Action action) {
        int i = 2;
        Effect effect = null;
        Object[] objArr = 0;
        if (action instanceof Action.Initialize) {
            return new ReducerResult<>(state, Effect.INSTANCE.merge(Effect.INSTANCE.fireAndForget(new C09261(null)), EffectKt.toEffect(observeInboxBadgeFlow()).cancellable(OBSERVE_INBOX_BADGE_COUNT_ID, true)));
        }
        if (!(action instanceof Action.InboxBadgeCountChanged)) {
            throw new NoWhenBranchMatchedException();
        }
        return new ReducerResult<>(state.copy(Integer.valueOf(((Action.InboxBadgeCountChanged) action).getCount())), effect, i, objArr == true ? 1 : 0);
    }

    /* JADX INFO: renamed from: com.box.android.base.presentation.components.topbar.component.inbox.InboxCountReducer$reduceInboxCount$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: InboxCountReducer.kt */
    @Metadata(d1 = {"\u0000\u0006\n\u0000\n\u0002\u0010\u0002\u0010\u0000\u001a\u00020\u0001H\n"}, d2 = {"<anonymous>", ""}, k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.box.android.base.presentation.components.topbar.component.inbox.InboxCountReducer$reduceInboxCount$1", f = "InboxCountReducer.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {}, v = 1)
    static final class C09261 extends SuspendLambda implements Function1<Continuation<? super Unit>, Object> {
        int label;

        C09261(Continuation<? super C09261> continuation) {
            super(1, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Continuation<?> continuation) {
            return InboxCountReducer.this.new C09261(continuation);
        }

        @Override // kotlin.jvm.functions.Function1
        public final Object invoke(Continuation<? super Unit> continuation) {
            return ((C09261) create(continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label == 0) {
                ResultKt.throwOnFailure(obj);
                InboxCountReducer.this.environment.getInboxBadgeRepository().updateBothBadgeCounts();
                return Unit.INSTANCE;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    private final Flow<Action> observeInboxBadgeFlow() {
        return FlowKt.combine(FlowLiveDataConversions.asFlow(this.environment.getInboxBadgeRepository().getNotificationBadgeCount()), FlowLiveDataConversions.asFlow(this.environment.getInboxBadgeRepository().getTaskBadge()), new AnonymousClass1(null));
    }

    /* JADX INFO: renamed from: com.box.android.base.presentation.components.topbar.component.inbox.InboxCountReducer$observeInboxBadgeFlow$1, reason: invalid class name */
    /* JADX INFO: compiled from: InboxCountReducer.kt */
    @Metadata(d1 = {"\u0000\u0016\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u00032\u000e\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005H\n"}, d2 = {"<anonymous>", "Lcom/box/android/base/presentation/components/topbar/component/inbox/InboxCountReducer$Action$InboxBadgeCountChanged;", "notificationCount", "", "taskBadgeResponse", "Lcom/box/androidsdk/content/requests/BoxResponse;", "Lcom/box/boxandroidlibv2private/model/BoxTaskBadge;"}, k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.box.android.base.presentation.components.topbar.component.inbox.InboxCountReducer$observeInboxBadgeFlow$1", f = "InboxCountReducer.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {}, v = 1)
    static final class AnonymousClass1 extends SuspendLambda implements Function3<Integer, BoxResponse<BoxTaskBadge>, Continuation<? super Action.InboxBadgeCountChanged>, Object> {
        /* synthetic */ Object L$0;
        /* synthetic */ Object L$1;
        int label;

        AnonymousClass1(Continuation<? super AnonymousClass1> continuation) {
            super(3, continuation);
        }

        @Override // kotlin.jvm.functions.Function3
        public final Object invoke(Integer num, BoxResponse<BoxTaskBadge> boxResponse, Continuation<? super Action.InboxBadgeCountChanged> continuation) {
            AnonymousClass1 anonymousClass1 = new AnonymousClass1(continuation);
            anonymousClass1.L$0 = num;
            anonymousClass1.L$1 = boxResponse;
            return anonymousClass1.invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Code duplicated, block: B:21:0x0068  */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Integer numBoxInt;
            Integer num = (Integer) this.L$0;
            BoxResponse boxResponse = (BoxResponse) this.L$1;
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            int iIntValue = num != null ? num.intValue() : 0;
            if (boxResponse == null || !boxResponse.isSuccess()) {
                numBoxInt = Boxing.boxInt(0);
            } else {
                BoxTaskBadge boxTaskBadge = (BoxTaskBadge) boxResponse.getResult();
                if ((boxTaskBadge != null ? boxTaskBadge.getCount() : null) == null) {
                    numBoxInt = Boxing.boxInt(0);
                } else {
                    numBoxInt = Intrinsics.areEqual(((BoxTaskBadge) boxResponse.getResult()).hasMore(), Boxing.boxBoolean(true)) ? Boxing.boxInt(((BoxTaskBadge) boxResponse.getResult()).getCount().intValue() + 1) : ((BoxTaskBadge) boxResponse.getResult()).getCount();
                }
            }
            Intrinsics.checkNotNull(numBoxInt);
            return new Action.InboxBadgeCountChanged(iIntValue + numBoxInt.intValue());
        }
    }
}
