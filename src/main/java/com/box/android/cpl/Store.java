package com.box.android.cpl;

import android.os.Looper;
import com.box.android.utilities.CoroutineExtensionsKt;
import com.pspdfkit.analytics.Analytics;
import java.io.Closeable;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.reflect.KProperty1;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.FlowKt;
import kotlinx.coroutines.flow.MutableStateFlow;
import kotlinx.coroutines.flow.StateFlow;
import kotlinx.coroutines.flow.StateFlowKt;
import org.apache.hc.core5.http.HeaderElements;

/* JADX INFO: compiled from: Store.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000\u008a\u0001\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0000\n\u0002\u0010%\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0010\b\n\u0002\b\u0004\b\u0007\u0018\u0000*\u0004\b\u0000\u0010\u0001*\u0004\b\u0001\u0010\u00022\u00020\u0003B=\u0012\u0006\u0010\u0004\u001a\u00028\u0000\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006\u0012\u0012\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\b\u0012\u0006\u0010\t\u001a\u00020\n\u0012\b\b\u0002\u0010\u000b\u001a\u00020\f¢\u0006\u0002\u0010\rJ\b\u0010 \u001a\u00020!H\u0016JH\u0010\"\u001a\u000e\u0012\u0004\u0012\u0002H#\u0012\u0004\u0012\u0002H$0\u0000\"\u0004\b\u0002\u0010#\"\u0004\b\u0003\u0010$2\u0014\u0010%\u001a\u0010\u0012\u0004\u0012\u00028\u0000\u0012\u0006\u0012\u0004\u0018\u0001H#0&2\u0012\u0010'\u001a\u000e\u0012\u0004\u0012\u0002H$\u0012\u0004\u0012\u00028\u00010(JV\u0010)\u001a\u000e\u0012\u0004\u0012\u0002H#\u0012\u0004\u0012\u0002H$0\u0000\"\u0004\b\u0002\u0010#\"\u0004\b\u0003\u0010$2\u0006\u0010\u0005\u001a\u00020\u00062\u001a\u0010*\u001a\u0016\u0012\u0004\u0012\u00028\u0000\u0012\f\u0012\n\u0012\u0004\u0012\u0002H#\u0018\u00010+0(2\u0012\u0010'\u001a\u000e\u0012\u0004\u0012\u0002H$\u0012\u0004\u0012\u00028\u00010(J,\u0010)\u001a\u000e\u0012\u0004\u0012\u0002H#\u0012\u0004\u0012\u00028\u00010\u0000\"\u0004\b\u0002\u0010#2\u0012\u0010%\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u0002H#0&JF\u0010)\u001a\u000e\u0012\u0004\u0012\u0002H#\u0012\u0004\u0012\u0002H$0\u0000\"\u0004\b\u0002\u0010#\"\u0004\b\u0003\u0010$2\u0012\u0010%\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u0002H#0&2\u0012\u0010'\u001a\u000e\u0012\u0004\u0012\u0002H$\u0012\u0004\u0012\u00028\u00010(Jy\u0010)\u001a\u000e\u0012\u0004\u0012\u0002H#\u0012\u0004\u0012\u0002H$0\u0000\"\b\b\u0002\u0010,*\u00020-\"\u000e\b\u0003\u0010#*\b\u0012\u0004\u0012\u0002H,0.\"\u0004\b\u0004\u0010$2\u001e\u0010%\u001a\u001a\u0012\u0004\u0012\u00028\u0000\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u0002H,\u0012\u0004\u0012\u0002H#0/0&2\u0006\u00100\u001a\u0002H,2\u0018\u0010'\u001a\u0014\u0012\u0004\u0012\u0002H,\u0012\u0004\u0012\u0002H$\u0012\u0004\u0012\u00028\u000101¢\u0006\u0002\u00102JZ\u0010)\u001a\u000e\u0012\u0004\u0012\u0002H#\u0012\u0004\u0012\u0002H$0\u0000\"\u0004\b\u0002\u0010#\"\u0004\b\u0003\u0010$2\u0018\u0010%\u001a\u0014\u0012\u0004\u0012\u00028\u0000\u0012\n\u0012\b\u0012\u0004\u0012\u0002H#030&2\u0006\u00100\u001a\u0002042\u0018\u0010'\u001a\u0014\u0012\u0004\u0012\u000204\u0012\u0004\u0012\u0002H$\u0012\u0004\u0012\u00028\u000101J\u0013\u00105\u001a\u00020!2\u0006\u00106\u001a\u00028\u0001¢\u0006\u0002\u00107R\u0014\u0010\u000e\u001a\b\u0012\u0004\u0012\u00028\u00000\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0010\u001a\b\u0012\u0004\u0012\u00028\u00010\u0011X\u0082\u0004¢\u0006\u0002\n\u0000R \u0010\u0012\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\n0\u0013X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0013\u0010\t\u001a\u00020\n8\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u000e\u0010\u0018\u001a\u00020\u0019X\u0082\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u001bR\u001a\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\u001c\u001a\b\u0012\u0004\u0012\u00028\u00000\u001d¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001f¨\u00068"}, d2 = {"Lcom/box/android/cpl/Store;", "State", "Action", "Ljava/io/Closeable;", "initialState", "key", "", "reducable", "Lcom/box/android/cpl/Reducable;", "coroutineScope", "Lkotlinx/coroutines/CoroutineScope;", "sendQueueLooper", "Landroid/os/Looper;", "(Ljava/lang/Object;Ljava/lang/String;Lcom/box/android/cpl/Reducable;Lkotlinx/coroutines/CoroutineScope;Landroid/os/Looper;)V", "_state", "Lkotlinx/coroutines/flow/MutableStateFlow;", "bufferedActions", "", "coroutineObservers", "", "getCoroutineObservers$cpl_core_release", "()Ljava/util/Map;", "getCoroutineScope", "()Lkotlinx/coroutines/CoroutineScope;", "isSending", "", "getKey", "()Ljava/lang/String;", "state", "Lkotlinx/coroutines/flow/StateFlow;", "getState", "()Lkotlinx/coroutines/flow/StateFlow;", HeaderElements.CLOSE, "", "ifScope", "LocalState", "LocalAction", "item", "Lkotlin/reflect/KProperty1;", "fromLocalAction", "Lkotlin/Function1;", "scope", "toLocalState", "Lcom/box/android/cpl/Wrapped;", "ID", "", "Lcom/box/android/cpl/Identifiable;", "Lcom/box/android/cpl/IdentifiedList;", "id", "Lkotlin/Function2;", "(Lkotlin/reflect/KProperty1;Ljava/lang/Object;Lkotlin/jvm/functions/Function2;)Lcom/box/android/cpl/Store;", "", "", "send", Analytics.Data.ACTION, "(Ljava/lang/Object;)V", "cpl-core_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class Store<State, Action> implements Closeable {
    private final MutableStateFlow<State> _state;
    private final List<Action> bufferedActions;
    private final Map<String, CoroutineScope> coroutineObservers;
    private final CoroutineScope coroutineScope;
    private boolean isSending;
    private final String key;
    private final Reducable<State, Action> reducable;
    private final Looper sendQueueLooper;
    private final StateFlow<State> state;

    public Store(State state, String key, Reducable<State, Action> reducable, CoroutineScope coroutineScope, Looper sendQueueLooper) {
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(reducable, "reducable");
        Intrinsics.checkNotNullParameter(coroutineScope, "coroutineScope");
        Intrinsics.checkNotNullParameter(sendQueueLooper, "sendQueueLooper");
        this.key = key;
        this.reducable = reducable;
        this.coroutineScope = coroutineScope;
        this.sendQueueLooper = sendQueueLooper;
        MutableStateFlow<State> MutableStateFlow = StateFlowKt.MutableStateFlow(state);
        this._state = MutableStateFlow;
        this.bufferedActions = new ArrayList();
        this.coroutineObservers = new LinkedHashMap();
        this.state = MutableStateFlow;
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public /* synthetic */ Store(Object obj, String str, Reducable reducable, CoroutineScope coroutineScope, Looper looper, int i, DefaultConstructorMarker defaultConstructorMarker) {
        if ((i & 2) != 0) {
            str = UUID.randomUUID().toString();
            Intrinsics.checkNotNullExpressionValue(str, "toString(...)");
        }
        String str2 = str;
        if ((i & 16) != 0) {
            looper = Looper.getMainLooper();
            Intrinsics.checkNotNullExpressionValue(looper, "getMainLooper(...)");
        }
        this(obj, str2, reducable, coroutineScope, looper);
    }

    public final String getKey() {
        return this.key;
    }

    public final CoroutineScope getCoroutineScope() {
        return this.coroutineScope;
    }

    public final Map<String, CoroutineScope> getCoroutineObservers$cpl_core_release() {
        return this.coroutineObservers;
    }

    public final StateFlow<State> getState() {
        return this.state;
    }

    public final void send(Action action) {
        this.sendQueueLooper.isCurrentThread();
        this.bufferedActions.add(action);
        if (this.isSending) {
            return;
        }
        this.isSending = true;
        State value = this._state.getValue();
        while (!this.bufferedActions.isEmpty()) {
            ReducerResult<State, Action> reducerResultReduce = this.reducable.reduce(value, (Action) CollectionsKt.removeFirst(this.bufferedActions));
            State state = reducerResultReduce.getState();
            CoroutineScope childScope = CoroutineExtensionsKt.getChildScope(this.coroutineScope);
            FlowKt.launchIn(FlowKt.onCompletion(FlowKt.onEach(reducerResultReduce.getEffect(), new C10541(this, null)), new C10552(childScope, null)), childScope);
            value = state;
        }
        this.isSending = false;
        this._state.setValue(value);
    }

    /* JADX INFO: renamed from: com.box.android.cpl.Store$send$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: Store.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u00032\u0006\u0010\u0004\u001a\u0002H\u0003H\u008a@"}, d2 = {"<anonymous>", "", "State", "Action", "effectAction"}, k = 3, mv = {1, 9, 0}, xi = 48)
    @DebugMetadata(c = "com.box.android.cpl.Store$send$1", f = "Store.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    static final class C10541 extends SuspendLambda implements Function2<Action, Continuation<? super Unit>, Object> {
        /* synthetic */ Object L$0;
        int label;
        final /* synthetic */ Store<State, Action> this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C10541(Store<State, Action> store, Continuation<? super C10541> continuation) {
            super(2, continuation);
            this.this$0 = store;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            C10541 c10541 = new C10541(this.this$0, continuation);
            c10541.L$0 = obj;
            return c10541;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(Action action, Continuation<? super Unit> continuation) {
            return ((C10541) create(action, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            this.this$0.send((Action) this.L$0);
            return Unit.INSTANCE;
        }
    }

    /* JADX INFO: renamed from: com.box.android.cpl.Store$send$2, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: Store.kt */
    @Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0003\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u0003*\b\u0012\u0004\u0012\u0002H\u00030\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006H\u008a@"}, d2 = {"<anonymous>", "", "State", "Action", "Lkotlinx/coroutines/flow/FlowCollector;", "it", ""}, k = 3, mv = {1, 9, 0}, xi = 48)
    @DebugMetadata(c = "com.box.android.cpl.Store$send$2", f = "Store.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    static final class C10552 extends SuspendLambda implements Function3<FlowCollector<? super Action>, Throwable, Continuation<? super Unit>, Object> {
        final /* synthetic */ CoroutineScope $childScope;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C10552(CoroutineScope coroutineScope, Continuation<? super C10552> continuation) {
            super(3, continuation);
            this.$childScope = coroutineScope;
        }

        @Override // kotlin.jvm.functions.Function3
        public final Object invoke(FlowCollector<? super Action> flowCollector, Throwable th, Continuation<? super Unit> continuation) {
            return new C10552(this.$childScope, continuation).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            CoroutineScopeKt.cancel$default(this.$childScope, null, 1, null);
            return Unit.INSTANCE;
        }
    }

    public final <LocalState, LocalAction> Store<LocalState, LocalAction> scope(String key, final Function1<? super State, Wrapped<LocalState>> toLocalState, final Function1<? super LocalAction, ? extends Action> fromLocalAction) {
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(toLocalState, "toLocalState");
        Intrinsics.checkNotNullParameter(fromLocalAction, "fromLocalAction");
        final String strCreateKey = ScopesStore.INSTANCE.createKey(this.key, key);
        Object obj = ScopesStore.INSTANCE.get(strCreateKey);
        if (obj != null) {
            return (Store) obj;
        }
        final Ref.BooleanRef booleanRef = new Ref.BooleanRef();
        final CoroutineScope childScope = CoroutineExtensionsKt.getChildScope(this.coroutineScope);
        Wrapped<LocalState> wrappedInvoke = toLocalState.invoke(this._state.getValue());
        Intrinsics.checkNotNull(wrappedInvoke);
        Store<LocalState, LocalAction> store = new Store<>(wrappedInvoke.getValue(), strCreateKey, new Reduce(new Function2<LocalState, LocalAction, ReducerResult<LocalState, LocalAction>>() { // from class: com.box.android.cpl.Store$scope$localStore$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(2);
            }

            /* JADX WARN: Type inference incomplete: some casts might be missing */
            @Override // kotlin.jvm.functions.Function2
            public final ReducerResult<LocalState, LocalAction> invoke(LocalState localstate, LocalAction localaction) {
                booleanRef.element = true;
                try {
                    this.send((Action) fromLocalAction.invoke(localaction));
                    Wrapped<LocalState> wrappedInvoke2 = toLocalState.invoke((State) ((Store) this)._state.getValue());
                    if (wrappedInvoke2 == null) {
                        CoroutineScopeKt.cancel$default(childScope, null, 1, null);
                        ScopesStore.INSTANCE.clear(strCreateKey);
                        return new ReducerResult<>(localstate, null, 2, null);
                    }
                    return new ReducerResult<>(wrappedInvoke2.getValue(), null, 2, null);
                } finally {
                    booleanRef.element = false;
                }
            }
        }), childScope, this.sendQueueLooper);
        ScopesStore.INSTANCE.set(this.key, strCreateKey, store);
        FlowKt.launchIn(FlowKt.onCompletion(FlowKt.onEach(FlowKt.drop(this.state, 1), new AnonymousClass2(booleanRef, toLocalState, store, strCreateKey, null)), new AnonymousClass3(strCreateKey, null)), store.coroutineScope);
        return store;
    }

    /* JADX INFO: renamed from: com.box.android.cpl.Store$scope$2, reason: invalid class name */
    /* JADX INFO: compiled from: Store.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u0003\"\u0004\b\u0002\u0010\u0004\"\u0004\b\u0003\u0010\u00052\u0006\u0010\u0006\u001a\u0002H\u0004H\u008a@"}, d2 = {"<anonymous>", "", "LocalState", "LocalAction", "State", "Action", "it"}, k = 3, mv = {1, 9, 0}, xi = 48)
    @DebugMetadata(c = "com.box.android.cpl.Store$scope$2", f = "Store.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    static final class AnonymousClass2 extends SuspendLambda implements Function2<State, Continuation<? super Unit>, Object> {
        final /* synthetic */ Ref.BooleanRef $isSending;
        final /* synthetic */ Store<LocalState, LocalAction> $localStore;
        final /* synthetic */ String $storeKey;
        final /* synthetic */ Function1<State, Wrapped<LocalState>> $toLocalState;
        /* synthetic */ Object L$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        AnonymousClass2(Ref.BooleanRef booleanRef, Function1<? super State, Wrapped<LocalState>> function1, Store<LocalState, LocalAction> store, String str, Continuation<? super AnonymousClass2> continuation) {
            super(2, continuation);
            this.$isSending = booleanRef;
            this.$toLocalState = function1;
            this.$localStore = store;
            this.$storeKey = str;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            AnonymousClass2 anonymousClass2 = new AnonymousClass2(this.$isSending, this.$toLocalState, this.$localStore, this.$storeKey, continuation);
            anonymousClass2.L$0 = obj;
            return anonymousClass2;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(State state, Continuation<? super Unit> continuation) {
            return ((AnonymousClass2) create(state, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Type inference incomplete: some casts might be missing */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            Object obj2 = this.L$0;
            if (!this.$isSending.element) {
                Wrapped wrapped = (Wrapped) this.$toLocalState.invoke((State) obj2);
                if (wrapped != null) {
                    ((Store) this.$localStore)._state.setValue(wrapped.getValue());
                } else {
                    this.$localStore.close();
                    ScopesStore.INSTANCE.clear(this.$storeKey);
                }
            }
            return Unit.INSTANCE;
        }
    }

    /* JADX INFO: renamed from: com.box.android.cpl.Store$scope$3, reason: invalid class name */
    /* JADX INFO: compiled from: Store.kt */
    @Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0003\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u0003\"\u0004\b\u0002\u0010\u0004\"\u0004\b\u0003\u0010\u0005*\b\u0012\u0004\u0012\u0002H\u00040\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\bH\u008a@"}, d2 = {"<anonymous>", "", "LocalState", "LocalAction", "State", "Action", "Lkotlinx/coroutines/flow/FlowCollector;", "it", ""}, k = 3, mv = {1, 9, 0}, xi = 48)
    @DebugMetadata(c = "com.box.android.cpl.Store$scope$3", f = "Store.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    static final class AnonymousClass3 extends SuspendLambda implements Function3<FlowCollector<? super State>, Throwable, Continuation<? super Unit>, Object> {
        final /* synthetic */ String $storeKey;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass3(String str, Continuation<? super AnonymousClass3> continuation) {
            super(3, continuation);
            this.$storeKey = str;
        }

        @Override // kotlin.jvm.functions.Function3
        public final Object invoke(FlowCollector<? super State> flowCollector, Throwable th, Continuation<? super Unit> continuation) {
            return new AnonymousClass3(this.$storeKey, continuation).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            ScopesStore.INSTANCE.clear(this.$storeKey);
            return Unit.INSTANCE;
        }
    }

    public final <ID, LocalState extends Identifiable<ID>, LocalAction> Store<LocalState, LocalAction> scope(final KProperty1<State, IdentifiedList<ID, LocalState>> item, final ID id, final Function2<? super ID, ? super LocalAction, ? extends Action> fromLocalAction) {
        Intrinsics.checkNotNullParameter(item, "item");
        Intrinsics.checkNotNullParameter(id, "id");
        Intrinsics.checkNotNullParameter(fromLocalAction, "fromLocalAction");
        return (Store<LocalState, LocalAction>) scope(item.getName() + id.hashCode(), (Function1) new Function1<State, Wrapped<LocalState>>() { // from class: com.box.android.cpl.Store.scope.4
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Wrapped<LocalState> invoke(State state) {
                Identifiable byId = ((IdentifiedList) item.get(state)).getById(id);
                if (byId != null) {
                    return StoreKt.wrap(byId);
                }
                return null;
            }
        }, new Function1<LocalAction, Action>() { // from class: com.box.android.cpl.Store.scope.5
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(1);
            }

            /* JADX WARN: Type inference fix 'apply assigned field type' failed
            java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
            	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
            	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
            	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
            	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
            	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
            	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
            	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
             */
            @Override // kotlin.jvm.functions.Function1
            public final Action invoke(LocalAction localaction) {
                return fromLocalAction.invoke(id, localaction);
            }
        });
    }

    public final <LocalState, LocalAction> Store<LocalState, LocalAction> scope(final KProperty1<State, ? extends List<? extends LocalState>> item, final int id, final Function2<? super Integer, ? super LocalAction, ? extends Action> fromLocalAction) {
        Intrinsics.checkNotNullParameter(item, "item");
        Intrinsics.checkNotNullParameter(fromLocalAction, "fromLocalAction");
        return scope(item.getName() + Integer.hashCode(id), new Function1<State, Wrapped<LocalState>>() { // from class: com.box.android.cpl.Store.scope.6
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Wrapped<LocalState> invoke(State state) {
                Object orNull = CollectionsKt.getOrNull(item.get(state), id);
                if (orNull != null) {
                    return StoreKt.wrap(orNull);
                }
                return null;
            }
        }, new Function1<LocalAction, Action>() { // from class: com.box.android.cpl.Store.scope.7
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Action invoke(LocalAction localaction) {
                return fromLocalAction.invoke(Integer.valueOf(id), localaction);
            }
        });
    }

    public final <LocalState, LocalAction> Store<LocalState, LocalAction> scope(final KProperty1<State, ? extends LocalState> item, Function1<? super LocalAction, ? extends Action> fromLocalAction) {
        Intrinsics.checkNotNullParameter(item, "item");
        Intrinsics.checkNotNullParameter(fromLocalAction, "fromLocalAction");
        return scope(item.getName(), new Function1<State, Wrapped<LocalState>>() { // from class: com.box.android.cpl.Store.scope.8
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Wrapped<LocalState> invoke(State state) {
                return StoreKt.wrap(item.get(state));
            }
        }, fromLocalAction);
    }

    public final <LocalState> Store<LocalState, Action> scope(final KProperty1<State, ? extends LocalState> item) {
        Intrinsics.checkNotNullParameter(item, "item");
        return (Store<LocalState, Action>) scope(item.getName(), new Function1<State, Wrapped<LocalState>>() { // from class: com.box.android.cpl.Store.scope.9
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Wrapped<LocalState> invoke(State state) {
                return StoreKt.wrap(item.get(state));
            }
        }, new Function1<Action, Action>() { // from class: com.box.android.cpl.Store.scope.10
            @Override // kotlin.jvm.functions.Function1
            public final Action invoke(Action action) {
                return action;
            }
        });
    }

    public final <LocalState, LocalAction> Store<LocalState, LocalAction> ifScope(final KProperty1<State, ? extends LocalState> item, Function1<? super LocalAction, ? extends Action> fromLocalAction) {
        Intrinsics.checkNotNullParameter(item, "item");
        Intrinsics.checkNotNullParameter(fromLocalAction, "fromLocalAction");
        return scope(item.getName(), new Function1<State, Wrapped<LocalState>>() { // from class: com.box.android.cpl.Store.ifScope.1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Wrapped<LocalState> invoke(State state) {
                LocalState localstate = item.get(state);
                if (localstate != null) {
                    return StoreKt.wrap(localstate);
                }
                return null;
            }
        }, fromLocalAction);
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        try {
            CoroutineScopeKt.cancel$default(this.coroutineScope, null, 1, null);
            ScopesStore.INSTANCE.clear(this.key);
        } catch (Exception unused) {
        }
    }
}
