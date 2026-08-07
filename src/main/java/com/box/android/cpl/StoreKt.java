package com.box.android.cpl;

import androidx.exifinterface.media.ExifInterface;
import com.box.android.utilities.CoroutineExtensionsKt;
import com.box.android.utilities.FlowExtensionsKt;
import com.facebook.hermes.intl.Constants;
import java.util.UUID;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.Ref;
import kotlin.reflect.KClass;
import kotlin.reflect.KProperty1;
import kotlin.reflect.jvm.KClassesJvm;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowKt;
import kotlinx.coroutines.flow.StateFlow;

/* JADX INFO: compiled from: Store.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000Z\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\u001az\u0010\u0000\u001a\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u0001\"\b\b\u0000\u0010\u0004*\u00020\u0005\"\u0004\b\u0001\u0010\u0006\"\u0004\b\u0002\u0010\u0002\"\u0004\b\u0003\u0010\u0003\"\u0010\b\u0004\u0010\u0007\u0018\u0001*\b\u0012\u0004\u0012\u0002H\u00020\b*\u000e\u0012\u0004\u0012\u0002H\u0004\u0012\u0004\u0012\u0002H\u00060\u00012\f\u0010\t\u001a\b\u0012\u0004\u0012\u0002H\u00070\n2\u0014\b\b\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u0002H\u0003\u0012\u0004\u0012\u0002H\u00060\fH\u0086\bø\u0001\u0000\u001a|\u0010\r\u001a\u0010\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u0003\u0018\u00010\u0001\"\b\b\u0000\u0010\u0004*\u00020\u0005\"\u0004\b\u0001\u0010\u0006\"\u0004\b\u0002\u0010\u0002\"\u0004\b\u0003\u0010\u0003\"\u0010\b\u0004\u0010\u0007\u0018\u0001*\b\u0012\u0004\u0012\u0002H\u00020\b*\u000e\u0012\u0004\u0012\u0002H\u0004\u0012\u0004\u0012\u0002H\u00060\u00012\f\u0010\t\u001a\b\u0012\u0004\u0012\u0002H\u00070\n2\u0014\b\b\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u0002H\u0003\u0012\u0004\u0012\u0002H\u00060\fH\u0086\bø\u0001\u0000\u001a^\u0010\u000e\u001a\u00020\u000f\"\u0004\b\u0000\u0010\u0010\"\u0004\b\u0001\u0010\u0011*\u0010\u0012\u0006\u0012\u0004\u0018\u0001H\u0010\u0012\u0004\u0012\u0002H\u00110\u00012\u001e\u0010\u0012\u001a\u001a\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u0002H\u0010\u0012\u0004\u0012\u0002H\u00110\u0001\u0012\u0004\u0012\u00020\u000f0\f2\u000e\u0010\u0013\u001a\n\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u00142\b\b\u0002\u0010\u0015\u001a\u00020\u0016\u001aZ\u0010\u0017\u001a\u00020\u0018\"\u0004\b\u0000\u0010\u0010\"\u0004\b\u0001\u0010\u0019\"\u0004\b\u0002\u0010\u0011*\u000e\u0012\u0004\u0012\u0002H\u0010\u0012\u0004\u0012\u0002H\u00110\u00012\u0012\u0010\u001a\u001a\u000e\u0012\u0004\u0012\u0002H\u0010\u0012\u0004\u0012\u0002H\u00190\u001b2\b\b\u0002\u0010\u0015\u001a\u00020\u00162\u0012\u0010\u001c\u001a\u000e\u0012\u0004\u0012\u0002H\u0019\u0012\u0004\u0012\u00020\u000f0\f\u001aZ\u0010\u001d\u001a\u00020\u000f\"\u0004\b\u0000\u0010\u0010\"\u0004\b\u0001\u0010\u0019\"\u0004\b\u0002\u0010\u0011*\u000e\u0012\u0004\u0012\u0002H\u0010\u0012\u0004\u0012\u0002H\u00110\u00012\u0012\u0010\u001a\u001a\u000e\u0012\u0004\u0012\u0002H\u0010\u0012\u0004\u0012\u0002H\u00190\u001b2\b\b\u0002\u0010\u0015\u001a\u00020\u00162\u0012\u0010\u001c\u001a\u000e\u0012\u0004\u0012\u0002H\u0010\u0012\u0004\u0012\u00020\u000f0\f\u001a\"\u0010\u001e\u001a\u00020\u0016*\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u00012\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u001f\u001a\u00020 \u001a'\u0010!\u001a\u0002H\u0010\"\u0004\b\u0000\u0010\u0010\"\u0004\b\u0001\u0010\u0011*\u000e\u0012\u0004\u0012\u0002H\u0010\u0012\u0004\u0012\u0002H\u00110\u0001¢\u0006\u0002\u0010\"\u001a\u009a\u0001\u0010#\u001a\u00020\u000f\"\b\b\u0000\u0010\u0004*\u00020\u0005\"\u0004\b\u0001\u0010\u0011\"\u0010\b\u0002\u0010\u0007\u0018\u0001*\b\u0012\u0004\u0012\u0002H\u00020\b\"\u0004\b\u0003\u0010\u0003\"\u0004\b\u0004\u0010\u0002*\u000e\u0012\u0004\u0012\u0002H\u0004\u0012\u0004\u0012\u0002H\u00110\u00012\f\u0010\t\u001a\b\u0012\u0004\u0012\u0002H\u00070\n2\u0014\b\b\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u0002H\u0003\u0012\u0004\u0012\u0002H\u00110\f2\b\b\u0002\u0010\u0015\u001a\u00020\u00162 \b\u0004\u0010$\u001a\u001a\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u0001\u0012\u0004\u0012\u00020\u000f0\fH\u0086\bø\u0001\u0000\u001a\u008e\u0001\u0010%\u001a\u00020\u000f\"\b\b\u0000\u0010\u0004*\u00020\u0005\"\u0004\b\u0001\u0010\u0011\"\n\b\u0002\u0010\u0007\u0018\u0001*\u0002H\u0004\"\u0004\b\u0003\u0010\u0003*\u000e\u0012\u0004\u0012\u0002H\u0004\u0012\u0004\u0012\u0002H\u00110\u00012\f\u0010\t\u001a\b\u0012\u0004\u0012\u0002H\u00070\n2\u0014\b\b\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u0002H\u0003\u0012\u0004\u0012\u0002H\u00110\f2\b\b\u0002\u0010\u0015\u001a\u00020\u00162 \b\u0004\u0010$\u001a\u001a\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u0002H\u0007\u0012\u0004\u0012\u0002H\u00030\u0001\u0012\u0004\u0012\u00020\u000f0\fH\u0086\bø\u0001\u0000\u001ar\u0010%\u001a\u00020\u000f\"\b\b\u0000\u0010\u0004*\u00020\u0005\"\u0004\b\u0001\u0010\u0011\"\n\b\u0002\u0010\u0007\u0018\u0001*\u0002H\u0004*\u000e\u0012\u0004\u0012\u0002H\u0004\u0012\u0004\u0012\u0002H\u00110\u00012\f\u0010\t\u001a\b\u0012\u0004\u0012\u0002H\u00070\n2\b\b\u0002\u0010\u0015\u001a\u00020\u00162 \b\u0004\u0010$\u001a\u001a\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u0002H\u0007\u0012\u0004\u0012\u0002H\u00110\u0001\u0012\u0004\u0012\u00020\u000f0\fH\u0086\bø\u0001\u0000\u001a\u001b\u0010&\u001a\b\u0012\u0004\u0012\u0002H(0'\"\u0004\b\u0000\u0010(*\u0002H(¢\u0006\u0002\u0010)\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006*"}, d2 = {Constants.SENSITIVITY_CASE, "Lcom/box/android/cpl/Store;", "LocalState", "LocalAction", "GlobalState", "", "GlobalAction", "ConcreteState", "Lcom/box/android/cpl/Embedded;", "switchCase", "Lkotlin/reflect/KClass;", "fromLocalAction", "Lkotlin/Function1;", "caseLet", "ifLet", "", "State", "Action", "then", "else", "Lkotlin/Function0;", "scope", "Lkotlinx/coroutines/CoroutineScope;", "observe", "Lkotlinx/coroutines/Job;", "TOut", "property", "Lkotlin/reflect/KProperty1;", "onchange", "observeAndReturnState", "registerCoroutineScope", "name", "", "stateValue", "(Lcom/box/android/cpl/Store;)Ljava/lang/Object;", "switchEmbeddedScope", "execute", "switchScope", "wrap", "Lcom/box/android/cpl/Wrapped;", ExifInterface.GPS_DIRECTION_TRUE, "(Ljava/lang/Object;)Lcom/box/android/cpl/Wrapped;", "cpl-core_release"}, k = 2, mv = {1, 9, 0}, xi = 48)
public final class StoreKt {

    /* JADX INFO: Add missing generic type declarations: [Action] */
    /* JADX INFO: renamed from: com.box.android.cpl.StoreKt$switchScope$4, reason: invalid class name */
    /* JADX INFO: compiled from: Store.kt */
    @Metadata(d1 = {"\u0000\f\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0002\b\u0004\u0010\u0000\u001a\u0002H\u0001\"\b\b\u0000\u0010\u0002*\u00020\u0003\"\u0004\b\u0001\u0010\u0001\"\n\b\u0002\u0010\u0004\u0018\u0001*\u0002H\u00022\u0006\u0010\u0005\u001a\u0002H\u0001H\n¢\u0006\u0004\b\u0006\u0010\u0007"}, d2 = {"<anonymous>", "Action", "GlobalState", "", "ConcreteState", "localAction", "invoke", "(Ljava/lang/Object;)Ljava/lang/Object;"}, k = 3, mv = {1, 9, 0}, xi = 176)
    public static final class AnonymousClass4<Action> extends Lambda implements Function1<Action, Action> {
        public static final AnonymousClass4 INSTANCE = new AnonymousClass4();

        public AnonymousClass4() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public final Action invoke(Action action) {
            return action;
        }
    }

    public static final <T> Wrapped<T> wrap(T t) {
        return new Wrapped<>(t);
    }

    public static /* synthetic */ void ifLet$default(Store store, Function1 function1, Function0 function0, CoroutineScope coroutineScope, int i, Object obj) {
        if ((i & 4) != 0) {
            coroutineScope = CoroutineExtensionsKt.getChildScope(store.getCoroutineScope());
        }
        ifLet(store, function1, function0, coroutineScope);
    }

    public static final <State, Action> void ifLet(Store<State, Action> store, Function1<? super Store<State, Action>, Unit> then, Function0<Unit> function0, CoroutineScope scope) {
        Intrinsics.checkNotNullParameter(store, "<this>");
        Intrinsics.checkNotNullParameter(then, "then");
        Intrinsics.checkNotNullParameter(scope, "scope");
        FlowKt.launchIn(FlowKt.onEach(store.getState(), new AnonymousClass1(new Ref.ObjectRef(), then, function0, store, null)), scope);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final <State, Action> Store<State, Action> ifLet$createNewStore(Store<State, Action> store) {
        String string = UUID.randomUUID().toString();
        Intrinsics.checkNotNullExpressionValue(string, "toString(...)");
        return (Store<State, Action>) store.scope(string, new Function1<State, Wrapped<State>>() { // from class: com.box.android.cpl.StoreKt$ifLet$createNewStore$1
            @Override // kotlin.jvm.functions.Function1
            public final Wrapped<State> invoke(State state) {
                if (state != null) {
                    return StoreKt.wrap(state);
                }
                return null;
            }
        }, new Function1<Action, Action>() { // from class: com.box.android.cpl.StoreKt$ifLet$createNewStore$2
            @Override // kotlin.jvm.functions.Function1
            public final Action invoke(Action action) {
                return action;
            }
        });
    }

    /* JADX INFO: Add missing generic type declarations: [State] */
    /* JADX INFO: renamed from: com.box.android.cpl.StoreKt$ifLet$1, reason: invalid class name */
    /* JADX INFO: compiled from: Store.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u00032\b\u0010\u0004\u001a\u0004\u0018\u0001H\u0002H\u008a@"}, d2 = {"<anonymous>", "", "State", "Action", "it"}, k = 3, mv = {1, 9, 0}, xi = 48)
    @DebugMetadata(c = "com.box.android.cpl.StoreKt$ifLet$1", f = "Store.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    static final class AnonymousClass1<State> extends SuspendLambda implements Function2<State, Continuation<? super Unit>, Object> {
        final /* synthetic */ Ref.ObjectRef<Store<State, Action>> $currentStore;
        final /* synthetic */ Function0<Unit> $else;
        final /* synthetic */ Function1<Store<State, Action>, Unit> $then;
        final /* synthetic */ Store<State, Action> $this_ifLet;
        /* synthetic */ Object L$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        AnonymousClass1(Ref.ObjectRef<Store<State, Action>> objectRef, Function1<? super Store<State, Action>, Unit> function1, Function0<Unit> function0, Store<State, Action> store, Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
            this.$currentStore = objectRef;
            this.$then = function1;
            this.$else = function0;
            this.$this_ifLet = store;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            AnonymousClass1 anonymousClass1 = new AnonymousClass1(this.$currentStore, this.$then, this.$else, this.$this_ifLet, continuation);
            anonymousClass1.L$0 = obj;
            return anonymousClass1;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(State state, Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(state, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r0v3, types: [T, com.box.android.cpl.Store] */
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
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            if (this.L$0 != null) {
                if (this.$currentStore.element == 0) {
                    this.$currentStore.element = StoreKt.ifLet$createNewStore(this.$this_ifLet);
                    Function1<Store<State, Action>, Unit> function1 = this.$then;
                    T t = this.$currentStore.element;
                    Intrinsics.checkNotNull(t);
                    function1.invoke(t);
                }
            } else {
                this.$currentStore.element = null;
                Function0<Unit> function0 = this.$else;
                if (function0 != null) {
                    function0.invoke();
                }
            }
            return Unit.INSTANCE;
        }
    }

    public static /* synthetic */ void switchScope$default(Store store, KClass switchCase, Function1 fromLocalAction, CoroutineScope scope, Function1 execute, int i, Object obj) {
        if ((i & 4) != 0) {
            scope = store.getCoroutineScope();
        }
        Intrinsics.checkNotNullParameter(store, "<this>");
        Intrinsics.checkNotNullParameter(switchCase, "switchCase");
        Intrinsics.checkNotNullParameter(fromLocalAction, "fromLocalAction");
        Intrinsics.checkNotNullParameter(scope, "scope");
        Intrinsics.checkNotNullParameter(execute, "execute");
        StateFlow state = store.getState();
        Intrinsics.needClassReification();
        Flow flowDistinctUntilChanged = FlowKt.distinctUntilChanged(state, C10591.INSTANCE);
        Intrinsics.needClassReification();
        StoreKt$switchScope$$inlined$mapNotNull$1 storeKt$switchScope$$inlined$mapNotNull$1 = new StoreKt$switchScope$$inlined$mapNotNull$1(flowDistinctUntilChanged);
        Intrinsics.needClassReification();
        FlowKt.launchIn(FlowKt.onEach(storeKt$switchScope$$inlined$mapNotNull$1, new C10603(execute, store, switchCase, fromLocalAction, null)), registerCoroutineScope(store, CoroutineExtensionsKt.getChildScope(scope), KClassesJvm.getJvmName(switchCase)));
    }

    public static final /* synthetic */ <GlobalState, Action, ConcreteState extends GlobalState, LocalAction> void switchScope(Store<GlobalState, Action> store, KClass<ConcreteState> switchCase, Function1<? super LocalAction, ? extends Action> fromLocalAction, CoroutineScope scope, Function1<? super Store<ConcreteState, LocalAction>, Unit> execute) {
        Intrinsics.checkNotNullParameter(store, "<this>");
        Intrinsics.checkNotNullParameter(switchCase, "switchCase");
        Intrinsics.checkNotNullParameter(fromLocalAction, "fromLocalAction");
        Intrinsics.checkNotNullParameter(scope, "scope");
        Intrinsics.checkNotNullParameter(execute, "execute");
        StateFlow<GlobalState> state = store.getState();
        Intrinsics.needClassReification();
        Flow flowDistinctUntilChanged = FlowKt.distinctUntilChanged(state, C10591.INSTANCE);
        Intrinsics.needClassReification();
        StoreKt$switchScope$$inlined$mapNotNull$1 storeKt$switchScope$$inlined$mapNotNull$1 = new StoreKt$switchScope$$inlined$mapNotNull$1(flowDistinctUntilChanged);
        Intrinsics.needClassReification();
        FlowKt.launchIn(FlowKt.onEach(storeKt$switchScope$$inlined$mapNotNull$1, new C10603(execute, store, switchCase, fromLocalAction, null)), registerCoroutineScope(store, CoroutineExtensionsKt.getChildScope(scope), KClassesJvm.getJvmName(switchCase)));
    }

    /* JADX INFO: Add missing generic type declarations: [GlobalState] */
    /* JADX INFO: renamed from: com.box.android.cpl.StoreKt$switchScope$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: Store.kt */
    @Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0007\u0010\u0000\u001a\u00020\u0001\"\b\b\u0000\u0010\u0002*\u00020\u0003\"\u0004\b\u0001\u0010\u0004\"\n\b\u0002\u0010\u0005\u0018\u0001*\u0002H\u0002\"\u0004\b\u0003\u0010\u00062\u0006\u0010\u0007\u001a\u0002H\u00022\u0006\u0010\b\u001a\u0002H\u0002H\n¢\u0006\u0004\b\t\u0010\n"}, d2 = {"<anonymous>", "", "GlobalState", "", "Action", "ConcreteState", "LocalAction", "old", "new", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Boolean;"}, k = 3, mv = {1, 9, 0}, xi = 176)
    public static final class C10591<GlobalState> extends Lambda implements Function2<GlobalState, GlobalState, Boolean> {
        public static final C10591 INSTANCE = new C10591();

        public C10591() {
            super(2);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        /* JADX WARN: Code duplicated, block: B:7:0x001d  */
        @Override // kotlin.jvm.functions.Function2
        public final Boolean invoke(GlobalState old, GlobalState globalstate) {
            boolean z;
            Intrinsics.checkNotNullParameter(old, "old");
            Intrinsics.checkNotNullParameter(globalstate, "new");
            Intrinsics.reifiedOperationMarker(3, "ConcreteState");
            if (old instanceof Object) {
                Intrinsics.reifiedOperationMarker(3, "ConcreteState");
                if (globalstate instanceof Object) {
                    z = true;
                } else {
                    z = false;
                }
            } else {
                z = false;
            }
            return Boolean.valueOf(z);
        }
    }

    /* JADX INFO: Add missing generic type declarations: [ConcreteState] */
    /* JADX INFO: renamed from: com.box.android.cpl.StoreKt$switchScope$3, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: Store.kt */
    @Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0004\u0010\u0000\u001a\u00020\u0001\"\b\b\u0000\u0010\u0002*\u00020\u0003\"\u0004\b\u0001\u0010\u0004\"\n\b\u0002\u0010\u0005\u0018\u0001*\u0002H\u0002\"\u0004\b\u0003\u0010\u00062\u0006\u0010\u0007\u001a\u0002H\u0005H\u008a@"}, d2 = {"<anonymous>", "", "GlobalState", "", "Action", "ConcreteState", "LocalAction", "it"}, k = 3, mv = {1, 9, 0}, xi = 176)
    @DebugMetadata(c = "com.box.android.cpl.StoreKt$switchScope$3", f = "Store.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    public static final class C10603<ConcreteState> extends SuspendLambda implements Function2<ConcreteState, Continuation<? super Unit>, Object> {
        final /* synthetic */ Function1<Store<ConcreteState, LocalAction>, Unit> $execute;
        final /* synthetic */ Function1<LocalAction, Action> $fromLocalAction;
        final /* synthetic */ KClass<ConcreteState> $switchCase;
        final /* synthetic */ Store<GlobalState, Action> $this_switchScope;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        public C10603(Function1<? super Store<ConcreteState, LocalAction>, Unit> function1, Store<GlobalState, Action> store, KClass<ConcreteState> kClass, Function1<? super LocalAction, ? extends Action> function2, Continuation<? super C10603> continuation) {
            super(2, continuation);
            this.$execute = function1;
            this.$this_switchScope = store;
            this.$switchCase = kClass;
            this.$fromLocalAction = function2;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            Intrinsics.needClassReification();
            return new C10603(this.$execute, this.$this_switchScope, this.$switchCase, this.$fromLocalAction, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(ConcreteState concretestate, Continuation<? super Unit> continuation) {
            return ((C10603) create(concretestate, continuation)).invokeSuspend(Unit.INSTANCE);
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
        /*  JADX ERROR: JadxRuntimeException in pass: FinishTypeInference
            jadx.core.utils.exceptions.JadxRuntimeException: Code variable not set in r3v5 boolean
            	at jadx.core.dex.instructions.args.SSAVar.getCodeVar(SSAVar.java:236)
            	at jadx.core.dex.visitors.typeinference.FinishTypeInference.lambda$visit$0(FinishTypeInference.java:27)
            	at java.base/java.util.ArrayList.forEach(ArrayList.java:1612)
            	at jadx.core.dex.visitors.typeinference.FinishTypeInference.visit(FinishTypeInference.java:22)
            */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final java.lang.Object invokeSuspend(java.lang.Object r4) {
            /*
                r3 = this;
                kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
                int r0 = r3.label
                if (r0 != 0) goto L27
                kotlin.ResultKt.throwOnFailure(r4)
                kotlin.jvm.functions.Function1<com.box.android.cpl.Store<ConcreteState, LocalAction>, kotlin.Unit> r4 = r3.$execute
                com.box.android.cpl.Store<GlobalState, Action> r0 = r3.$this_switchScope
                kotlin.reflect.KClass<ConcreteState> r1 = r3.$switchCase
                java.lang.String r1 = kotlin.reflect.jvm.KClassesJvm.getJvmName(r1)
                kotlin.jvm.internal.Intrinsics.needClassReification()
                com.box.android.cpl.StoreKt$switchScope$3$1 r2 = com.box.android.cpl.StoreKt.C10603.AnonymousClass1.INSTANCE
                kotlin.jvm.functions.Function1 r2 = (kotlin.jvm.functions.Function1) r2
                kotlin.jvm.functions.Function1<LocalAction, Action> r3 = r3.$fromLocalAction
                com.box.android.cpl.Store r3 = r0.scope(r1, r2, r3)
                r4.invoke(r3)
                kotlin.Unit r3 = kotlin.Unit.INSTANCE
                return r3
            L27:
                java.lang.IllegalStateException r3 = new java.lang.IllegalStateException
                java.lang.String r4 = "call to 'resume' before 'invoke' with coroutine"
                r3.<init>(r4)
                throw r3
            */
            throw new UnsupportedOperationException("Method not decompiled: com.box.android.cpl.StoreKt.C10603.invokeSuspend(java.lang.Object):java.lang.Object");
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
        /*  JADX ERROR: JadxRuntimeException in pass: FinishTypeInference
            jadx.core.utils.exceptions.JadxRuntimeException: Code variable not set in r3v4 boolean
            	at jadx.core.dex.instructions.args.SSAVar.getCodeVar(SSAVar.java:236)
            	at jadx.core.dex.visitors.typeinference.FinishTypeInference.lambda$visit$0(FinishTypeInference.java:27)
            	at java.base/java.util.ArrayList.forEach(ArrayList.java:1612)
            	at jadx.core.dex.visitors.typeinference.FinishTypeInference.visit(FinishTypeInference.java:22)
            */
        public final java.lang.Object invokeSuspend$$forInline(java.lang.Object r4) {
            /*
                r3 = this;
                kotlin.jvm.functions.Function1<com.box.android.cpl.Store<ConcreteState, LocalAction>, kotlin.Unit> r4 = r3.$execute
                com.box.android.cpl.Store<GlobalState, Action> r0 = r3.$this_switchScope
                kotlin.reflect.KClass<ConcreteState> r1 = r3.$switchCase
                java.lang.String r1 = kotlin.reflect.jvm.KClassesJvm.getJvmName(r1)
                kotlin.jvm.internal.Intrinsics.needClassReification()
                com.box.android.cpl.StoreKt$switchScope$3$1 r2 = com.box.android.cpl.StoreKt.C10603.AnonymousClass1.INSTANCE
                kotlin.jvm.functions.Function1 r2 = (kotlin.jvm.functions.Function1) r2
                kotlin.jvm.functions.Function1<LocalAction, Action> r3 = r3.$fromLocalAction
                com.box.android.cpl.Store r3 = r0.scope(r1, r2, r3)
                r4.invoke(r3)
                kotlin.Unit r3 = kotlin.Unit.INSTANCE
                return r3
            */
            throw new UnsupportedOperationException("Method not decompiled: com.box.android.cpl.StoreKt.C10603.invokeSuspend$$forInline(java.lang.Object):java.lang.Object");
        }

        /* JADX INFO: Add missing generic type declarations: [GlobalState] */
        /* JADX INFO: renamed from: com.box.android.cpl.StoreKt$switchScope$3$1, reason: invalid class name */
        /* JADX INFO: compiled from: Store.kt */
        @Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0005\u0010\u0000\u001a\n\u0012\u0004\u0012\u0002H\u0002\u0018\u00010\u0001\"\b\b\u0000\u0010\u0003*\u00020\u0004\"\u0004\b\u0001\u0010\u0005\"\n\b\u0002\u0010\u0002\u0018\u0001*\u0002H\u0003\"\u0004\b\u0003\u0010\u00062\u0006\u0010\u0007\u001a\u0002H\u0003H\n¢\u0006\u0004\b\b\u0010\t"}, d2 = {"<anonymous>", "Lcom/box/android/cpl/Wrapped;", "ConcreteState", "GlobalState", "", "Action", "LocalAction", "globalState", "invoke", "(Ljava/lang/Object;)Lcom/box/android/cpl/Wrapped;"}, k = 3, mv = {1, 9, 0}, xi = 176)
        public static final class AnonymousClass1<GlobalState> extends Lambda implements Function1<GlobalState, Wrapped<ConcreteState>> {
            public static final AnonymousClass1 INSTANCE;

            static {
                Intrinsics.needClassReification();
                INSTANCE = new AnonymousClass1();
            }

            public AnonymousClass1() {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Wrapped<ConcreteState> invoke(GlobalState globalState) {
                Intrinsics.checkNotNullParameter(globalState, "globalState");
                Intrinsics.reifiedOperationMarker(2, "ConcreteState");
                if (globalState != null) {
                    return StoreKt.wrap(globalState);
                }
                return null;
            }
        }
    }

    public static final /* synthetic */ <GlobalState, GlobalAction, LocalState, LocalAction, ConcreteState extends Embedded<LocalState>> Store<LocalState, LocalAction> caseLet(Store<GlobalState, GlobalAction> store, KClass<ConcreteState> switchCase, Function1<? super LocalAction, ? extends GlobalAction> fromLocalAction) {
        Intrinsics.checkNotNullParameter(store, "<this>");
        Intrinsics.checkNotNullParameter(switchCase, "switchCase");
        Intrinsics.checkNotNullParameter(fromLocalAction, "fromLocalAction");
        GlobalState value = store.getState().getValue();
        Intrinsics.reifiedOperationMarker(2, "ConcreteState");
        if (((Embedded) value) == null) {
            return null;
        }
        String jvmName = KClassesJvm.getJvmName(switchCase);
        Intrinsics.needClassReification();
        Intrinsics.needClassReification();
        return store.scope(jvmName, new Function1<GlobalState, Wrapped<LocalState>>() { // from class: com.box.android.cpl.StoreKt$caseLet$$inlined$let$lambda$1
            @Override // kotlin.jvm.functions.Function1
            public final Wrapped<LocalState> invoke(GlobalState globalState) {
                Object action;
                Intrinsics.checkNotNullParameter(globalState, "globalState");
                Intrinsics.reifiedOperationMarker(2, "ConcreteState");
                Embedded embedded = (Embedded) globalState;
                if (embedded == null || (action = embedded.getAction()) == null) {
                    return null;
                }
                return StoreKt.wrap(action);
            }
        }, fromLocalAction);
    }

    public static final CoroutineScope registerCoroutineScope(Store<?, ?> store, CoroutineScope scope, String name) {
        Intrinsics.checkNotNullParameter(store, "<this>");
        Intrinsics.checkNotNullParameter(scope, "scope");
        Intrinsics.checkNotNullParameter(name, "name");
        CoroutineScope coroutineScope = store.getCoroutineObservers$cpl_core_release().get(name);
        if (coroutineScope != null) {
            CoroutineScopeKt.cancel$default(coroutineScope, null, 1, null);
        }
        store.getCoroutineObservers$cpl_core_release().put(name, scope);
        return scope;
    }

    public static /* synthetic */ void switchScope$default(Store store, KClass switchCase, CoroutineScope scope, Function1 execute, int i, Object obj) {
        if ((i & 2) != 0) {
            scope = store.getCoroutineScope();
        }
        Intrinsics.checkNotNullParameter(store, "<this>");
        Intrinsics.checkNotNullParameter(switchCase, "switchCase");
        Intrinsics.checkNotNullParameter(scope, "scope");
        Intrinsics.checkNotNullParameter(execute, "execute");
        AnonymousClass4 anonymousClass4 = AnonymousClass4.INSTANCE;
        StateFlow state = store.getState();
        Intrinsics.needClassReification();
        Flow flowDistinctUntilChanged = FlowKt.distinctUntilChanged(state, StoreKt$switchScope$$inlined$switchScope$1.INSTANCE);
        Intrinsics.needClassReification();
        StoreKt$switchScope$$inlined$switchScope$2 storeKt$switchScope$$inlined$switchScope$2 = new StoreKt$switchScope$$inlined$switchScope$2(flowDistinctUntilChanged);
        Intrinsics.needClassReification();
        FlowKt.launchIn(FlowKt.onEach(storeKt$switchScope$$inlined$switchScope$2, new StoreKt$switchScope$$inlined$switchScope$3(execute, store, switchCase, anonymousClass4, null)), registerCoroutineScope(store, CoroutineExtensionsKt.getChildScope(scope), KClassesJvm.getJvmName(switchCase)));
    }

    public static final /* synthetic */ <GlobalState, Action, ConcreteState extends GlobalState> void switchScope(Store<GlobalState, Action> store, KClass<ConcreteState> switchCase, CoroutineScope scope, Function1<? super Store<ConcreteState, Action>, Unit> execute) {
        Intrinsics.checkNotNullParameter(store, "<this>");
        Intrinsics.checkNotNullParameter(switchCase, "switchCase");
        Intrinsics.checkNotNullParameter(scope, "scope");
        Intrinsics.checkNotNullParameter(execute, "execute");
        AnonymousClass4 anonymousClass4 = AnonymousClass4.INSTANCE;
        StateFlow<GlobalState> state = store.getState();
        Intrinsics.needClassReification();
        Flow flowDistinctUntilChanged = FlowKt.distinctUntilChanged(state, StoreKt$switchScope$$inlined$switchScope$1.INSTANCE);
        Intrinsics.needClassReification();
        StoreKt$switchScope$$inlined$switchScope$2 storeKt$switchScope$$inlined$switchScope$2 = new StoreKt$switchScope$$inlined$switchScope$2(flowDistinctUntilChanged);
        Intrinsics.needClassReification();
        FlowKt.launchIn(FlowKt.onEach(storeKt$switchScope$$inlined$switchScope$2, new StoreKt$switchScope$$inlined$switchScope$3(execute, store, switchCase, anonymousClass4, null)), registerCoroutineScope(store, CoroutineExtensionsKt.getChildScope(scope), KClassesJvm.getJvmName(switchCase)));
    }

    public static /* synthetic */ void switchEmbeddedScope$default(Store store, KClass switchCase, Function1 fromLocalAction, CoroutineScope scope, Function1 execute, int i, Object obj) {
        if ((i & 4) != 0) {
            scope = store.getCoroutineScope();
        }
        Intrinsics.checkNotNullParameter(store, "<this>");
        Intrinsics.checkNotNullParameter(switchCase, "switchCase");
        Intrinsics.checkNotNullParameter(fromLocalAction, "fromLocalAction");
        Intrinsics.checkNotNullParameter(scope, "scope");
        Intrinsics.checkNotNullParameter(execute, "execute");
        StateFlow state = store.getState();
        Intrinsics.needClassReification();
        Flow flowDistinctUntilChanged = FlowKt.distinctUntilChanged(state, C10581.INSTANCE);
        Intrinsics.needClassReification();
        StoreKt$switchEmbeddedScope$$inlined$mapNotNull$1 storeKt$switchEmbeddedScope$$inlined$mapNotNull$1 = new StoreKt$switchEmbeddedScope$$inlined$mapNotNull$1(flowDistinctUntilChanged);
        Intrinsics.needClassReification();
        FlowKt.launchIn(FlowKt.onEach(storeKt$switchEmbeddedScope$$inlined$mapNotNull$1, new AnonymousClass3(execute, store, switchCase, fromLocalAction, null)), registerCoroutineScope(store, CoroutineExtensionsKt.getChildScope(scope), KClassesJvm.getJvmName(switchCase)));
    }

    public static final /* synthetic */ <GlobalState, Action, ConcreteState extends Embedded<LocalState>, LocalAction, LocalState> void switchEmbeddedScope(Store<GlobalState, Action> store, KClass<ConcreteState> switchCase, Function1<? super LocalAction, ? extends Action> fromLocalAction, CoroutineScope scope, Function1<? super Store<LocalState, LocalAction>, Unit> execute) {
        Intrinsics.checkNotNullParameter(store, "<this>");
        Intrinsics.checkNotNullParameter(switchCase, "switchCase");
        Intrinsics.checkNotNullParameter(fromLocalAction, "fromLocalAction");
        Intrinsics.checkNotNullParameter(scope, "scope");
        Intrinsics.checkNotNullParameter(execute, "execute");
        StateFlow<GlobalState> state = store.getState();
        Intrinsics.needClassReification();
        Flow flowDistinctUntilChanged = FlowKt.distinctUntilChanged(state, C10581.INSTANCE);
        Intrinsics.needClassReification();
        StoreKt$switchEmbeddedScope$$inlined$mapNotNull$1 storeKt$switchEmbeddedScope$$inlined$mapNotNull$1 = new StoreKt$switchEmbeddedScope$$inlined$mapNotNull$1(flowDistinctUntilChanged);
        Intrinsics.needClassReification();
        FlowKt.launchIn(FlowKt.onEach(storeKt$switchEmbeddedScope$$inlined$mapNotNull$1, new AnonymousClass3(execute, store, switchCase, fromLocalAction, null)), registerCoroutineScope(store, CoroutineExtensionsKt.getChildScope(scope), KClassesJvm.getJvmName(switchCase)));
    }

    /* JADX INFO: Add missing generic type declarations: [GlobalState] */
    /* JADX INFO: renamed from: com.box.android.cpl.StoreKt$switchEmbeddedScope$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: Store.kt */
    @Metadata(d1 = {"\u0000\u0018\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0010\u0000\u001a\u00020\u0001\"\b\b\u0000\u0010\u0002*\u00020\u0003\"\u0004\b\u0001\u0010\u0004\"\u0010\b\u0002\u0010\u0005\u0018\u0001*\b\u0012\u0004\u0012\u0002H\u00070\u0006\"\u0004\b\u0003\u0010\b\"\u0004\b\u0004\u0010\u00072\u0006\u0010\t\u001a\u0002H\u00022\u0006\u0010\n\u001a\u0002H\u0002H\n¢\u0006\u0004\b\u000b\u0010\f"}, d2 = {"<anonymous>", "", "GlobalState", "", "Action", "ConcreteState", "Lcom/box/android/cpl/Embedded;", "LocalState", "LocalAction", "old", "new", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Boolean;"}, k = 3, mv = {1, 9, 0}, xi = 176)
    public static final class C10581<GlobalState> extends Lambda implements Function2<GlobalState, GlobalState, Boolean> {
        public static final C10581 INSTANCE = new C10581();

        public C10581() {
            super(2);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        /* JADX WARN: Code duplicated, block: B:7:0x001d  */
        @Override // kotlin.jvm.functions.Function2
        public final Boolean invoke(GlobalState old, GlobalState globalstate) {
            boolean z;
            Intrinsics.checkNotNullParameter(old, "old");
            Intrinsics.checkNotNullParameter(globalstate, "new");
            Intrinsics.reifiedOperationMarker(3, "ConcreteState");
            if (old instanceof Embedded) {
                Intrinsics.reifiedOperationMarker(3, "ConcreteState");
                if (globalstate instanceof Embedded) {
                    z = true;
                } else {
                    z = false;
                }
            } else {
                z = false;
            }
            return Boolean.valueOf(z);
        }
    }

    /* JADX INFO: Add missing generic type declarations: [ConcreteState] */
    /* JADX INFO: renamed from: com.box.android.cpl.StoreKt$switchEmbeddedScope$3, reason: invalid class name */
    /* JADX INFO: compiled from: Store.kt */
    @Metadata(d1 = {"\u0000\u0018\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0000\u001a\u00020\u0001\"\b\b\u0000\u0010\u0002*\u00020\u0003\"\u0004\b\u0001\u0010\u0004\"\u0010\b\u0002\u0010\u0005\u0018\u0001*\b\u0012\u0004\u0012\u0002H\u00070\u0006\"\u0004\b\u0003\u0010\b\"\u0004\b\u0004\u0010\u00072\u0006\u0010\t\u001a\u0002H\u0005H\u008a@"}, d2 = {"<anonymous>", "", "GlobalState", "", "Action", "ConcreteState", "Lcom/box/android/cpl/Embedded;", "LocalState", "LocalAction", "it"}, k = 3, mv = {1, 9, 0}, xi = 176)
    @DebugMetadata(c = "com.box.android.cpl.StoreKt$switchEmbeddedScope$3", f = "Store.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass3<ConcreteState> extends SuspendLambda implements Function2<ConcreteState, Continuation<? super Unit>, Object> {
        final /* synthetic */ Function1<Store<LocalState, LocalAction>, Unit> $execute;
        final /* synthetic */ Function1<LocalAction, Action> $fromLocalAction;
        final /* synthetic */ KClass<ConcreteState> $switchCase;
        final /* synthetic */ Store<GlobalState, Action> $this_switchEmbeddedScope;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        public AnonymousClass3(Function1<? super Store<LocalState, LocalAction>, Unit> function1, Store<GlobalState, Action> store, KClass<ConcreteState> kClass, Function1<? super LocalAction, ? extends Action> function2, Continuation<? super AnonymousClass3> continuation) {
            super(2, continuation);
            this.$execute = function1;
            this.$this_switchEmbeddedScope = store;
            this.$switchCase = kClass;
            this.$fromLocalAction = function2;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            Intrinsics.needClassReification();
            return new AnonymousClass3(this.$execute, this.$this_switchEmbeddedScope, this.$switchCase, this.$fromLocalAction, continuation);
        }

        /* JADX WARN: Incorrect types in method signature: (TConcreteState;Lkotlin/coroutines/Continuation<-Lkotlin/Unit;>;)Ljava/lang/Object; */
        public final Object invoke(Embedded embedded, Continuation continuation) {
            return ((AnonymousClass3) create(embedded, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Object invoke(Object obj, Continuation<? super Unit> continuation) {
            return invoke((Embedded) obj, (Continuation) continuation);
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
        /*  JADX ERROR: JadxRuntimeException in pass: FinishTypeInference
            jadx.core.utils.exceptions.JadxRuntimeException: Code variable not set in r3v5 boolean
            	at jadx.core.dex.instructions.args.SSAVar.getCodeVar(SSAVar.java:236)
            	at jadx.core.dex.visitors.typeinference.FinishTypeInference.lambda$visit$0(FinishTypeInference.java:27)
            	at java.base/java.util.ArrayList.forEach(ArrayList.java:1612)
            	at jadx.core.dex.visitors.typeinference.FinishTypeInference.visit(FinishTypeInference.java:22)
            */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final java.lang.Object invokeSuspend(java.lang.Object r4) {
            /*
                r3 = this;
                kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
                int r0 = r3.label
                if (r0 != 0) goto L27
                kotlin.ResultKt.throwOnFailure(r4)
                kotlin.jvm.functions.Function1<com.box.android.cpl.Store<LocalState, LocalAction>, kotlin.Unit> r4 = r3.$execute
                com.box.android.cpl.Store<GlobalState, Action> r0 = r3.$this_switchEmbeddedScope
                kotlin.reflect.KClass<ConcreteState> r1 = r3.$switchCase
                java.lang.String r1 = kotlin.reflect.jvm.KClassesJvm.getJvmName(r1)
                kotlin.jvm.internal.Intrinsics.needClassReification()
                com.box.android.cpl.StoreKt$switchEmbeddedScope$3$1 r2 = com.box.android.cpl.StoreKt.AnonymousClass3.AnonymousClass1.INSTANCE
                kotlin.jvm.functions.Function1 r2 = (kotlin.jvm.functions.Function1) r2
                kotlin.jvm.functions.Function1<LocalAction, Action> r3 = r3.$fromLocalAction
                com.box.android.cpl.Store r3 = r0.scope(r1, r2, r3)
                r4.invoke(r3)
                kotlin.Unit r3 = kotlin.Unit.INSTANCE
                return r3
            L27:
                java.lang.IllegalStateException r3 = new java.lang.IllegalStateException
                java.lang.String r4 = "call to 'resume' before 'invoke' with coroutine"
                r3.<init>(r4)
                throw r3
            */
            throw new UnsupportedOperationException("Method not decompiled: com.box.android.cpl.StoreKt.AnonymousClass3.invokeSuspend(java.lang.Object):java.lang.Object");
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
        /*  JADX ERROR: JadxRuntimeException in pass: FinishTypeInference
            jadx.core.utils.exceptions.JadxRuntimeException: Code variable not set in r3v4 boolean
            	at jadx.core.dex.instructions.args.SSAVar.getCodeVar(SSAVar.java:236)
            	at jadx.core.dex.visitors.typeinference.FinishTypeInference.lambda$visit$0(FinishTypeInference.java:27)
            	at java.base/java.util.ArrayList.forEach(ArrayList.java:1612)
            	at jadx.core.dex.visitors.typeinference.FinishTypeInference.visit(FinishTypeInference.java:22)
            */
        public final java.lang.Object invokeSuspend$$forInline(java.lang.Object r4) {
            /*
                r3 = this;
                kotlin.jvm.functions.Function1<com.box.android.cpl.Store<LocalState, LocalAction>, kotlin.Unit> r4 = r3.$execute
                com.box.android.cpl.Store<GlobalState, Action> r0 = r3.$this_switchEmbeddedScope
                kotlin.reflect.KClass<ConcreteState> r1 = r3.$switchCase
                java.lang.String r1 = kotlin.reflect.jvm.KClassesJvm.getJvmName(r1)
                kotlin.jvm.internal.Intrinsics.needClassReification()
                com.box.android.cpl.StoreKt$switchEmbeddedScope$3$1 r2 = com.box.android.cpl.StoreKt.AnonymousClass3.AnonymousClass1.INSTANCE
                kotlin.jvm.functions.Function1 r2 = (kotlin.jvm.functions.Function1) r2
                kotlin.jvm.functions.Function1<LocalAction, Action> r3 = r3.$fromLocalAction
                com.box.android.cpl.Store r3 = r0.scope(r1, r2, r3)
                r4.invoke(r3)
                kotlin.Unit r3 = kotlin.Unit.INSTANCE
                return r3
            */
            throw new UnsupportedOperationException("Method not decompiled: com.box.android.cpl.StoreKt.AnonymousClass3.invokeSuspend$$forInline(java.lang.Object):java.lang.Object");
        }

        /* JADX INFO: Add missing generic type declarations: [GlobalState, LocalState] */
        /* JADX INFO: renamed from: com.box.android.cpl.StoreKt$switchEmbeddedScope$3$1, reason: invalid class name */
        /* JADX INFO: compiled from: Store.kt */
        @Metadata(d1 = {"\u0000\u001a\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0010\u0000\u001a\n\u0012\u0004\u0012\u0002H\u0002\u0018\u00010\u0001\"\b\b\u0000\u0010\u0003*\u00020\u0004\"\u0004\b\u0001\u0010\u0005\"\u0010\b\u0002\u0010\u0006\u0018\u0001*\b\u0012\u0004\u0012\u0002H\u00020\u0007\"\u0004\b\u0003\u0010\b\"\u0004\b\u0004\u0010\u00022\u0006\u0010\t\u001a\u0002H\u0003H\n¢\u0006\u0004\b\n\u0010\u000b"}, d2 = {"<anonymous>", "Lcom/box/android/cpl/Wrapped;", "LocalState", "GlobalState", "", "Action", "ConcreteState", "Lcom/box/android/cpl/Embedded;", "LocalAction", "globalState", "invoke", "(Ljava/lang/Object;)Lcom/box/android/cpl/Wrapped;"}, k = 3, mv = {1, 9, 0}, xi = 176)
        public static final class AnonymousClass1<GlobalState, LocalState> extends Lambda implements Function1<GlobalState, Wrapped<LocalState>> {
            public static final AnonymousClass1 INSTANCE = new AnonymousClass1();

            public AnonymousClass1() {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Wrapped<LocalState> invoke(GlobalState globalState) {
                Object webLink;
                Intrinsics.checkNotNullParameter(globalState, "globalState");
                Intrinsics.reifiedOperationMarker(2, "ConcreteState");
                Embedded embedded = (Embedded) globalState;
                if (embedded == null || (webLink = embedded.getAction()) == null) {
                    return null;
                }
                return StoreKt.wrap(webLink);
            }
        }
    }

    public static /* synthetic */ Job observe$default(Store store, KProperty1 kProperty1, CoroutineScope coroutineScope, Function1 function1, int i, Object obj) {
        if ((i & 2) != 0) {
            coroutineScope = store.getCoroutineScope();
        }
        return observe(store, kProperty1, coroutineScope, function1);
    }

    /* JADX INFO: Add missing generic type declarations: [TOut] */
    /* JADX INFO: renamed from: com.box.android.cpl.StoreKt$observe$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: Store.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u0003\"\u0004\b\u0002\u0010\u00042\u0006\u0010\u0005\u001a\u0002H\u0003H\u008a@"}, d2 = {"<anonymous>", "", "State", "TOut", "Action", "it"}, k = 3, mv = {1, 9, 0}, xi = 48)
    @DebugMetadata(c = "com.box.android.cpl.StoreKt$observe$1", f = "Store.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    static final class C10561<TOut> extends SuspendLambda implements Function2<TOut, Continuation<? super Unit>, Object> {
        final /* synthetic */ Function1<TOut, Unit> $onchange;
        /* synthetic */ Object L$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        C10561(Function1<? super TOut, Unit> function1, Continuation<? super C10561> continuation) {
            super(2, continuation);
            this.$onchange = function1;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            C10561 c10561 = new C10561(this.$onchange, continuation);
            c10561.L$0 = obj;
            return c10561;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(TOut tout, Continuation<? super Unit> continuation) {
            return ((C10561) create(tout, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            this.$onchange.invoke((TOut) this.L$0);
            return Unit.INSTANCE;
        }
    }

    public static final <State, TOut, Action> Job observe(Store<State, Action> store, KProperty1<State, ? extends TOut> property, CoroutineScope scope, Function1<? super TOut, Unit> onchange) {
        Intrinsics.checkNotNullParameter(store, "<this>");
        Intrinsics.checkNotNullParameter(property, "property");
        Intrinsics.checkNotNullParameter(scope, "scope");
        Intrinsics.checkNotNullParameter(onchange, "onchange");
        return FlowKt.launchIn(FlowKt.onEach(FlowExtensionsKt.observe(store.getState(), property), new C10561(onchange, null)), scope);
    }

    public static /* synthetic */ void observeAndReturnState$default(Store store, KProperty1 kProperty1, CoroutineScope coroutineScope, Function1 function1, int i, Object obj) {
        if ((i & 2) != 0) {
            coroutineScope = store.getCoroutineScope();
        }
        observeAndReturnState(store, kProperty1, coroutineScope, function1);
    }

    /* JADX INFO: Add missing generic type declarations: [State] */
    /* JADX INFO: renamed from: com.box.android.cpl.StoreKt$observeAndReturnState$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: Store.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u0003\"\u0004\b\u0002\u0010\u00042\u0006\u0010\u0005\u001a\u0002H\u0002H\u008a@"}, d2 = {"<anonymous>", "", "State", "TOut", "Action", "it"}, k = 3, mv = {1, 9, 0}, xi = 48)
    @DebugMetadata(c = "com.box.android.cpl.StoreKt$observeAndReturnState$1", f = "Store.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    static final class C10571<State> extends SuspendLambda implements Function2<State, Continuation<? super Unit>, Object> {
        final /* synthetic */ Function1<State, Unit> $onchange;
        /* synthetic */ Object L$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        C10571(Function1<? super State, Unit> function1, Continuation<? super C10571> continuation) {
            super(2, continuation);
            this.$onchange = function1;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            C10571 c10571 = new C10571(this.$onchange, continuation);
            c10571.L$0 = obj;
            return c10571;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(State state, Continuation<? super Unit> continuation) {
            return ((C10571) create(state, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            this.$onchange.invoke((State) this.L$0);
            return Unit.INSTANCE;
        }
    }

    public static final <State, TOut, Action> void observeAndReturnState(Store<State, Action> store, KProperty1<State, ? extends TOut> property, CoroutineScope scope, Function1<? super State, Unit> onchange) {
        Intrinsics.checkNotNullParameter(store, "<this>");
        Intrinsics.checkNotNullParameter(property, "property");
        Intrinsics.checkNotNullParameter(scope, "scope");
        Intrinsics.checkNotNullParameter(onchange, "onchange");
        FlowKt.launchIn(FlowKt.onEach(FlowExtensionsKt.observeAndReturnState(store.getState(), property), new C10571(onchange, null)), scope);
    }

    public static final <State, Action> State stateValue(Store<State, Action> store) {
        Intrinsics.checkNotNullParameter(store, "<this>");
        return store.getState().getValue();
    }

    /* JADX INFO: renamed from: case, reason: not valid java name */
    public static final /* synthetic */ <GlobalState, GlobalAction, LocalState, LocalAction, ConcreteState extends Embedded<LocalState>> Store<LocalState, LocalAction> m12486case(Store<GlobalState, GlobalAction> store, KClass<ConcreteState> switchCase, Function1<? super LocalAction, ? extends GlobalAction> fromLocalAction) {
        Store<LocalState, LocalAction> storeScope;
        Intrinsics.checkNotNullParameter(store, "<this>");
        Intrinsics.checkNotNullParameter(switchCase, "switchCase");
        Intrinsics.checkNotNullParameter(fromLocalAction, "fromLocalAction");
        GlobalState value = store.getState().getValue();
        Intrinsics.reifiedOperationMarker(2, "ConcreteState");
        if (((Embedded) value) != null) {
            String jvmName = KClassesJvm.getJvmName(switchCase);
            Intrinsics.needClassReification();
            storeScope = store.scope(jvmName, new Function1<GlobalState, Wrapped<LocalState>>() { // from class: com.box.android.cpl.StoreKt$case$$inlined$caseLet$1
                @Override // kotlin.jvm.functions.Function1
                public final Wrapped<LocalState> invoke(GlobalState globalState) {
                    Object action;
                    Intrinsics.checkNotNullParameter(globalState, "globalState");
                    Intrinsics.reifiedOperationMarker(2, "ConcreteState");
                    Embedded embedded = (Embedded) globalState;
                    if (embedded == null || (action = embedded.getAction()) == null) {
                        return null;
                    }
                    return StoreKt.wrap(action);
                }
            }, fromLocalAction);
        } else {
            storeScope = null;
        }
        Intrinsics.checkNotNull(storeScope);
        return storeScope;
    }
}
