package androidx.lifecycle.testing;

import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LifecycleRegistry;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.MainCoroutineDispatcher;

/* JADX INFO: compiled from: TestLifecycleOwner.kt */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\b\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u001d\b\u0007\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u000e\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010J\u0016\u0010\u0015\u001a\u00020\u000e2\u0006\u0010\u0017\u001a\u00020\u0003H\u0086@¢\u0006\u0002\u0010\u0018R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\n\u001a\u00020\t8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u000b\u0010\fR$\u0010\u0012\u001a\u00020\u00032\u0006\u0010\u0011\u001a\u00020\u00038F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\u0011\u0010\u0019\u001a\u00020\u001a8F¢\u0006\u0006\u001a\u0004\b\u001b\u0010\u001c¨\u0006\u001d"}, d2 = {"Landroidx/lifecycle/testing/TestLifecycleOwner;", "Landroidx/lifecycle/LifecycleOwner;", "initialState", "Landroidx/lifecycle/Lifecycle$State;", "coroutineDispatcher", "Lkotlinx/coroutines/CoroutineDispatcher;", "<init>", "(Landroidx/lifecycle/Lifecycle$State;Lkotlinx/coroutines/CoroutineDispatcher;)V", "lifecycleRegistry", "Landroidx/lifecycle/LifecycleRegistry;", "lifecycle", "getLifecycle", "()Landroidx/lifecycle/LifecycleRegistry;", "handleLifecycleEvent", "", "event", "Landroidx/lifecycle/Lifecycle$Event;", "value", "currentState", "getCurrentState", "()Landroidx/lifecycle/Lifecycle$State;", "setCurrentState", "(Landroidx/lifecycle/Lifecycle$State;)V", "state", "(Landroidx/lifecycle/Lifecycle$State;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "observerCount", "", "getObserverCount", "()I", "lifecycle-runtime-testing"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class TestLifecycleOwner implements LifecycleOwner {
    private final CoroutineDispatcher coroutineDispatcher;
    private final LifecycleRegistry lifecycleRegistry;

    /* JADX WARN: Multi-variable type inference failed */
    public TestLifecycleOwner() {
        this(null, 0 == true ? 1 : 0, 3, 0 == true ? 1 : 0);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public TestLifecycleOwner(Lifecycle.State initialState) {
        this(initialState, null, 2, 0 == true ? 1 : 0);
        Intrinsics.checkNotNullParameter(initialState, "initialState");
    }

    public TestLifecycleOwner(Lifecycle.State initialState, CoroutineDispatcher coroutineDispatcher) {
        Intrinsics.checkNotNullParameter(initialState, "initialState");
        Intrinsics.checkNotNullParameter(coroutineDispatcher, "coroutineDispatcher");
        this.coroutineDispatcher = coroutineDispatcher;
        LifecycleRegistry lifecycleRegistryCreateUnsafe = LifecycleRegistry.INSTANCE.createUnsafe(this);
        lifecycleRegistryCreateUnsafe.setCurrentState(initialState);
        this.lifecycleRegistry = lifecycleRegistryCreateUnsafe;
    }

    public /* synthetic */ TestLifecycleOwner(Lifecycle.State state, MainCoroutineDispatcher mainCoroutineDispatcher, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? Lifecycle.State.STARTED : state, (i & 2) != 0 ? Dispatchers.getMain().getImmediate() : mainCoroutineDispatcher);
    }

    @Override // androidx.lifecycle.LifecycleOwner
    /* JADX INFO: renamed from: getLifecycle, reason: from getter */
    public LifecycleRegistry getLifecycleRegistry() {
        return this.lifecycleRegistry;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit handleLifecycleEvent$lambda$0(TestLifecycleOwner testLifecycleOwner, Lifecycle.Event event) {
        testLifecycleOwner.lifecycleRegistry.handleLifecycleEvent(event);
        return Unit.INSTANCE;
    }

    public final void handleLifecycleEvent(final Lifecycle.Event event) {
        Intrinsics.checkNotNullParameter(event, "event");
        TestLifecycleOwner_androidKt.runBlockingIfPossible(this.coroutineDispatcher, new Function0() { // from class: androidx.lifecycle.testing.TestLifecycleOwner$$ExternalSyntheticLambda1
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return TestLifecycleOwner.handleLifecycleEvent$lambda$0(this.f$0, event);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Lifecycle.State _get_currentState_$lambda$0(TestLifecycleOwner testLifecycleOwner) {
        return testLifecycleOwner.lifecycleRegistry.getState();
    }

    public final Lifecycle.State getCurrentState() {
        return (Lifecycle.State) TestLifecycleOwner_androidKt.runBlockingIfPossible(this.coroutineDispatcher, new Function0() { // from class: androidx.lifecycle.testing.TestLifecycleOwner$$ExternalSyntheticLambda2
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return TestLifecycleOwner._get_currentState_$lambda$0(this.f$0);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit _set_currentState_$lambda$0(TestLifecycleOwner testLifecycleOwner, Lifecycle.State state) {
        testLifecycleOwner.lifecycleRegistry.setCurrentState(state);
        return Unit.INSTANCE;
    }

    public final void setCurrentState(final Lifecycle.State value) {
        Intrinsics.checkNotNullParameter(value, "value");
        TestLifecycleOwner_androidKt.runBlockingIfPossible(this.coroutineDispatcher, new Function0() { // from class: androidx.lifecycle.testing.TestLifecycleOwner$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return TestLifecycleOwner._set_currentState_$lambda$0(this.f$0, value);
            }
        });
    }

    /* JADX INFO: renamed from: androidx.lifecycle.testing.TestLifecycleOwner$setCurrentState$2, reason: invalid class name */
    /* JADX INFO: compiled from: TestLifecycleOwner.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
    @DebugMetadata(c = "androidx.lifecycle.testing.TestLifecycleOwner$setCurrentState$2", f = "TestLifecycleOwner.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {}, v = 1)
    static final class AnonymousClass2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ Lifecycle.State $state;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass2(Lifecycle.State state, Continuation<? super AnonymousClass2> continuation) {
            super(2, continuation);
            this.$state = state;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return TestLifecycleOwner.this.new AnonymousClass2(this.$state, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            TestLifecycleOwner.this.lifecycleRegistry.setCurrentState(this.$state);
            return Unit.INSTANCE;
        }
    }

    public final Object setCurrentState(Lifecycle.State state, Continuation<? super Unit> continuation) {
        Object objWithContext = BuildersKt.withContext(this.coroutineDispatcher, new AnonymousClass2(state, null), continuation);
        return objWithContext == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objWithContext : Unit.INSTANCE;
    }

    public final int getObserverCount() {
        return this.lifecycleRegistry.getObserverCount();
    }
}
