package com.box.android.cpl;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.KClass;
import kotlin.reflect.jvm.KClassesJvm;

/* JADX INFO: Add missing generic type declarations: [ConcreteState] */
/* JADX INFO: compiled from: Store.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0005\u0010\u0000\u001a\u00020\u0001\"\b\b\u0000\u0010\u0002*\u00020\u0003\"\u0004\b\u0001\u0010\u0004\"\n\b\u0002\u0010\u0005\u0018\u0001*\u0002H\u0002\"\u0004\b\u0003\u0010\u00062\u0006\u0010\u0007\u001a\u0002H\u0005H\u008a@¨\u0006\b"}, d2 = {"<anonymous>", "", "GlobalState", "", "Action", "ConcreteState", "LocalAction", "it", "com/box/android/cpl/StoreKt$switchScope$3"}, k = 3, mv = {1, 9, 0}, xi = 176)
@DebugMetadata(c = "com.box.android.cpl.StoreKt$switchScope$$inlined$switchScope$3", f = "Store.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class StoreKt$switchScope$$inlined$switchScope$3<ConcreteState> extends SuspendLambda implements Function2<ConcreteState, Continuation<? super Unit>, Object> {
    final /* synthetic */ Function1 $execute;
    final /* synthetic */ Function1 $fromLocalAction;
    final /* synthetic */ KClass $switchCase;
    final /* synthetic */ Store $this_switchScope;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public StoreKt$switchScope$$inlined$switchScope$3(Function1 function1, Store store, KClass kClass, Function1 function2, Continuation continuation) {
        super(2, continuation);
        this.$execute = function1;
        this.$this_switchScope = store;
        this.$switchCase = kClass;
        this.$fromLocalAction = function2;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new StoreKt$switchScope$$inlined$switchScope$3(this.$execute, this.$this_switchScope, this.$switchCase, this.$fromLocalAction, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(ConcreteState concretestate, Continuation<? super Unit> continuation) {
        return ((StoreKt$switchScope$$inlined$switchScope$3) create(concretestate, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        ResultKt.throwOnFailure(obj);
        Function1 function1 = this.$execute;
        Store store = this.$this_switchScope;
        String jvmName = KClassesJvm.getJvmName(this.$switchCase);
        Intrinsics.needClassReification();
        function1.invoke(store.scope(jvmName, AnonymousClass1.INSTANCE, this.$fromLocalAction));
        return Unit.INSTANCE;
    }

    public final Object invokeSuspend$$forInline(Object obj) {
        Function1 function1 = this.$execute;
        Store store = this.$this_switchScope;
        String jvmName = KClassesJvm.getJvmName(this.$switchCase);
        Intrinsics.needClassReification();
        function1.invoke(store.scope(jvmName, AnonymousClass1.INSTANCE, this.$fromLocalAction));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Add missing generic type declarations: [GlobalState] */
    /* JADX INFO: renamed from: com.box.android.cpl.StoreKt$switchScope$$inlined$switchScope$3$1, reason: invalid class name */
    /* JADX INFO: compiled from: Store.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0006\u0010\u0000\u001a\n\u0012\u0004\u0012\u0002H\u0002\u0018\u00010\u0001\"\b\b\u0000\u0010\u0003*\u00020\u0004\"\u0004\b\u0001\u0010\u0005\"\n\b\u0002\u0010\u0002\u0018\u0001*\u0002H\u0003\"\u0004\b\u0003\u0010\u00062\u0006\u0010\u0007\u001a\u0002H\u0003H\n¢\u0006\u0004\b\b\u0010\t¨\u0006\n"}, d2 = {"<anonymous>", "Lcom/box/android/cpl/Wrapped;", "ConcreteState", "GlobalState", "", "Action", "LocalAction", "globalState", "invoke", "(Ljava/lang/Object;)Lcom/box/android/cpl/Wrapped;", "com/box/android/cpl/StoreKt$switchScope$3$1"}, k = 3, mv = {1, 9, 0}, xi = 176)
    public static final class AnonymousClass1<GlobalState> extends Lambda implements Function1<GlobalState, Wrapped<ConcreteState>> {
        public static final AnonymousClass1 INSTANCE = new AnonymousClass1();

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
