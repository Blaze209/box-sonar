package com.box.android.routers;

import androidx.exifinterface.media.ExifInterface;
import androidx.lifecycle.LifecycleCoroutineScope;
import androidx.lifecycle.LifecycleOwnerKt;
import com.box.android.browse.cpl.offlined.OfflinedReducer;
import com.box.android.cpl.Store;
import com.box.android.cpl.StoreKt;
import com.box.android.utilities.CoroutineExtensionsKt;
import com.box.android.utilities.DataClassUtilsKt;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;
import kotlin.reflect.jvm.KClassesJvm;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.FlowKt;

/* JADX INFO: compiled from: NavigationRouter.kt */
/* JADX INFO: loaded from: classes12.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "com.box.android.routers.NavigationRouter$initOfflinedNavigation$2$5", f = "NavigationRouter.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {}, v = 1)
final class NavigationRouter$initOfflinedNavigation$2$5 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Store<OfflinedReducer.State, OfflinedReducer.Action> $store;
    final /* synthetic */ Store<OfflinedReducer.Route, OfflinedReducer.Action> $this_apply;
    int label;
    final /* synthetic */ NavigationRouter this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    NavigationRouter$initOfflinedNavigation$2$5(Store<OfflinedReducer.Route, OfflinedReducer.Action> store, NavigationRouter navigationRouter, Store<OfflinedReducer.State, OfflinedReducer.Action> store2, Continuation<? super NavigationRouter$initOfflinedNavigation$2$5> continuation) {
        super(2, continuation);
        this.$this_apply = store;
        this.this$0 = navigationRouter;
        this.$store = store2;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new NavigationRouter$initOfflinedNavigation$2$5(this.$this_apply, this.this$0, this.$store, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((NavigationRouter$initOfflinedNavigation$2$5) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        ResultKt.throwOnFailure(obj);
        Store<OfflinedReducer.Route, OfflinedReducer.Action> store = this.$this_apply;
        KClass orCreateKotlinClass = Reflection.getOrCreateKotlinClass(OfflinedReducer.Route.ItemAction.class);
        AnonymousClass1 anonymousClass1 = AnonymousClass1.INSTANCE;
        LifecycleCoroutineScope lifecycleScope = LifecycleOwnerKt.getLifecycleScope(this.this$0.activity);
        NavigationRouter navigationRouter = this.this$0;
        Store<OfflinedReducer.State, OfflinedReducer.Action> store2 = this.$store;
        final Flow flowDistinctUntilChanged = FlowKt.distinctUntilChanged(store.getState(), new Function2<OfflinedReducer.Route, OfflinedReducer.Route, Boolean>() { // from class: com.box.android.routers.NavigationRouter$initOfflinedNavigation$2$5$invokeSuspend$$inlined$switchScope$1
            @Override // kotlin.jvm.functions.Function2
            public final Boolean invoke(OfflinedReducer.Route old, OfflinedReducer.Route route) {
                Intrinsics.checkNotNullParameter(old, "old");
                Intrinsics.checkNotNullParameter(route, "new");
                return Boolean.valueOf((old instanceof OfflinedReducer.Route.ItemAction) && (route instanceof OfflinedReducer.Route.ItemAction));
            }
        });
        FlowKt.launchIn(FlowKt.onEach(new Flow<OfflinedReducer.Route.ItemAction>() { // from class: com.box.android.routers.NavigationRouter$initOfflinedNavigation$2$5$invokeSuspend$$inlined$switchScope$2
            @Override // kotlinx.coroutines.flow.Flow
            public Object collect(FlowCollector<? super OfflinedReducer.Route.ItemAction> flowCollector, Continuation continuation) {
                Object objCollect = flowDistinctUntilChanged.collect(new AnonymousClass2(flowCollector), continuation);
                return objCollect == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objCollect : Unit.INSTANCE;
            }

            /* JADX INFO: renamed from: com.box.android.routers.NavigationRouter$initOfflinedNavigation$2$5$invokeSuspend$$inlined$switchScope$2$2, reason: invalid class name */
            /* JADX INFO: compiled from: Emitters.kt */
            @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\b\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u00032\u0006\u0010\u0004\u001a\u0002H\u0002H\u008a@¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\t"}, d2 = {"<anonymous>", "", ExifInterface.GPS_DIRECTION_TRUE, "R", "value", "emit", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "kotlinx/coroutines/flow/FlowKt__EmittersKt$unsafeTransform$1$1", "kotlinx/coroutines/flow/FlowKt__TransformKt$mapNotNull$$inlined$unsafeTransform$1$2", "com/box/android/cpl/StoreKt$switchScope$$inlined$mapNotNull$1$2"}, k = 3, mv = {2, 2, 0}, xi = 48)
            public static final class AnonymousClass2<T> implements FlowCollector {
                final /* synthetic */ FlowCollector $this_unsafeFlow;

                /* JADX INFO: renamed from: com.box.android.routers.NavigationRouter$initOfflinedNavigation$2$5$invokeSuspend$$inlined$switchScope$2$2$1, reason: invalid class name */
                /* JADX INFO: compiled from: Emitters.kt */
                @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
                @DebugMetadata(c = "com.box.android.routers.NavigationRouter$initOfflinedNavigation$2$5$invokeSuspend$$inlined$switchScope$2$2", f = "NavigationRouter.kt", i = {0, 0, 0, 0, 0, 0}, l = {221}, m = "emit", n = {"value", "$completion", "value", "$this$mapNotNull_u24lambda_u246", "transformed", "$i$a$-unsafeTransform-FlowKt__TransformKt$mapNotNull$1"}, s = {"L$0", "L$1", "L$2", "L$3", "L$4", "I$0"}, v = 1)
                public static final class AnonymousClass1 extends ContinuationImpl {
                    int I$0;
                    Object L$0;
                    Object L$1;
                    Object L$2;
                    Object L$3;
                    Object L$4;
                    int label;
                    /* synthetic */ Object result;

                    public AnonymousClass1(Continuation continuation) {
                        super(continuation);
                    }

                    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                    public final Object invokeSuspend(Object obj) {
                        this.result = obj;
                        this.label |= Integer.MIN_VALUE;
                        return AnonymousClass2.this.emit(null, this);
                    }
                }

                public AnonymousClass2(FlowCollector flowCollector) {
                    this.$this_unsafeFlow = flowCollector;
                }

                /* JADX WARN: Code duplicated, block: B:7:0x0014  */
                @Override // kotlinx.coroutines.flow.FlowCollector
                public final Object emit(Object obj, Continuation continuation) {
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
                    Object obj2 = anonymousClass1.result;
                    Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                    int i = anonymousClass1.label;
                    if (i == 0) {
                        ResultKt.throwOnFailure(obj2);
                        FlowCollector flowCollector = this.$this_unsafeFlow;
                        OfflinedReducer.Route.ItemAction itemAction = (OfflinedReducer.Route.ItemAction) (!(obj instanceof OfflinedReducer.Route.ItemAction) ? null : obj);
                        if (itemAction != null) {
                            anonymousClass1.L$0 = SpillingKt.nullOutSpilledVariable(obj);
                            anonymousClass1.L$1 = SpillingKt.nullOutSpilledVariable(anonymousClass1);
                            anonymousClass1.L$2 = SpillingKt.nullOutSpilledVariable(obj);
                            anonymousClass1.L$3 = SpillingKt.nullOutSpilledVariable(flowCollector);
                            anonymousClass1.L$4 = SpillingKt.nullOutSpilledVariable(itemAction);
                            anonymousClass1.I$0 = 0;
                            anonymousClass1.label = 1;
                            if (flowCollector.emit(itemAction, anonymousClass1) == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                        }
                    } else {
                        if (i != 1) {
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                        int i2 = anonymousClass1.I$0;
                        Object obj3 = anonymousClass1.L$2;
                        Object obj4 = anonymousClass1.L$0;
                        ResultKt.throwOnFailure(obj2);
                    }
                    return Unit.INSTANCE;
                }
            }
        }, new NavigationRouter$initOfflinedNavigation$2$5$invokeSuspend$$inlined$switchScope$3(store, orCreateKotlinClass, anonymousClass1, null, navigationRouter, store2)), StoreKt.registerCoroutineScope(store, CoroutineExtensionsKt.getChildScope(lifecycleScope), KClassesJvm.getJvmName(orCreateKotlinClass)));
        return Unit.INSTANCE;
    }

    /* JADX INFO: renamed from: com.box.android.routers.NavigationRouter$initOfflinedNavigation$2$5$1, reason: invalid class name */
    /* JADX INFO: compiled from: NavigationRouter.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    static final /* synthetic */ class AnonymousClass1 extends FunctionReferenceImpl implements Function1<OfflinedReducer.Action, OfflinedReducer.Action> {
        public static final AnonymousClass1 INSTANCE = new AnonymousClass1();

        AnonymousClass1() {
            super(1, DataClassUtilsKt.class, "self", "self(Ljava/lang/Object;)Ljava/lang/Object;", 1);
        }

        @Override // kotlin.jvm.functions.Function1
        public final OfflinedReducer.Action invoke(OfflinedReducer.Action p0) {
            Intrinsics.checkNotNullParameter(p0, "p0");
            return (OfflinedReducer.Action) DataClassUtilsKt.self(p0);
        }
    }
}
