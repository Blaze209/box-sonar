package com.box.android.navigationmodernization.navigation.compose;

import androidx.compose.runtime.MutableState;
import com.box.android.domain.models.DomainError;
import com.box.android.domain.utils.result.Result;
import com.box.android.navigationmodernization.MainNavigationTarget;
import com.box.android.navigationmodernization.MainNavigationViewModel;
import com.box.android.navigationmodernization.navigation.MainNavigationTargetRequestHandler;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.FlowCollector;

/* JADX INFO: compiled from: RootNavHost.kt */
/* JADX INFO: loaded from: classes12.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "com.box.android.navigationmodernization.navigation.compose.RootNavHostKt$MainNavigationTargetHandling$3$1", f = "RootNavHost.kt", i = {}, l = {221}, m = "invokeSuspend", n = {}, s = {}, v = 1)
final class RootNavHostKt$MainNavigationTargetHandling$3$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ MainNavigationViewModel $mainNavigationViewModel;
    final /* synthetic */ MutableState<DomainError> $navigationError$delegate;
    final /* synthetic */ MainNavigationTargetRequestHandler $navigationRequestHandler;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    RootNavHostKt$MainNavigationTargetHandling$3$1(MainNavigationViewModel mainNavigationViewModel, MainNavigationTargetRequestHandler mainNavigationTargetRequestHandler, MutableState<DomainError> mutableState, Continuation<? super RootNavHostKt$MainNavigationTargetHandling$3$1> continuation) {
        super(2, continuation);
        this.$mainNavigationViewModel = mainNavigationViewModel;
        this.$navigationRequestHandler = mainNavigationTargetRequestHandler;
        this.$navigationError$delegate = mutableState;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new RootNavHostKt$MainNavigationTargetHandling$3$1(this.$mainNavigationViewModel, this.$navigationRequestHandler, this.$navigationError$delegate, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((RootNavHostKt$MainNavigationTargetHandling$3$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX INFO: renamed from: com.box.android.navigationmodernization.navigation.compose.RootNavHostKt$MainNavigationTargetHandling$3$1$1, reason: invalid class name */
    /* JADX INFO: compiled from: RootNavHost.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    static final class AnonymousClass1<T> implements FlowCollector {
        final /* synthetic */ MutableState<DomainError> $navigationError$delegate;
        final /* synthetic */ MainNavigationTargetRequestHandler $navigationRequestHandler;

        AnonymousClass1(MainNavigationTargetRequestHandler mainNavigationTargetRequestHandler, MutableState<DomainError> mutableState) {
            this.$navigationRequestHandler = mainNavigationTargetRequestHandler;
            this.$navigationError$delegate = mutableState;
        }

        /* JADX WARN: Code duplicated, block: B:7:0x0014  */
        public final Object emit(MainNavigationTarget mainNavigationTarget, Continuation<? super Unit> continuation) {
            RootNavHostKt$MainNavigationTargetHandling$3$1$1$emit$1 rootNavHostKt$MainNavigationTargetHandling$3$1$1$emit$1;
            if (continuation instanceof RootNavHostKt$MainNavigationTargetHandling$3$1$1$emit$1) {
                rootNavHostKt$MainNavigationTargetHandling$3$1$1$emit$1 = (RootNavHostKt$MainNavigationTargetHandling$3$1$1$emit$1) continuation;
                if ((rootNavHostKt$MainNavigationTargetHandling$3$1$1$emit$1.label & Integer.MIN_VALUE) != 0) {
                    rootNavHostKt$MainNavigationTargetHandling$3$1$1$emit$1.label -= Integer.MIN_VALUE;
                } else {
                    rootNavHostKt$MainNavigationTargetHandling$3$1$1$emit$1 = new RootNavHostKt$MainNavigationTargetHandling$3$1$1$emit$1(this, continuation);
                }
            } else {
                rootNavHostKt$MainNavigationTargetHandling$3$1$1$emit$1 = new RootNavHostKt$MainNavigationTargetHandling$3$1$1$emit$1(this, continuation);
            }
            Object objHandle = rootNavHostKt$MainNavigationTargetHandling$3$1$1$emit$1.result;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = rootNavHostKt$MainNavigationTargetHandling$3$1$1$emit$1.label;
            if (i == 0) {
                ResultKt.throwOnFailure(objHandle);
                MainNavigationTargetRequestHandler mainNavigationTargetRequestHandler = this.$navigationRequestHandler;
                rootNavHostKt$MainNavigationTargetHandling$3$1$1$emit$1.L$0 = SpillingKt.nullOutSpilledVariable(mainNavigationTarget);
                rootNavHostKt$MainNavigationTargetHandling$3$1$1$emit$1.label = 1;
                objHandle = mainNavigationTargetRequestHandler.handle(mainNavigationTarget, rootNavHostKt$MainNavigationTargetHandling$3$1$1$emit$1);
                if (objHandle == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(objHandle);
            }
            Result result = (Result) objHandle;
            if (result instanceof Result.Error) {
                this.$navigationError$delegate.setValue((DomainError) ((Result.Error) result).getValue());
            }
            return Unit.INSTANCE;
        }

        @Override // kotlinx.coroutines.flow.FlowCollector
        public /* bridge */ /* synthetic */ Object emit(Object obj, Continuation continuation) {
            return emit((MainNavigationTarget) obj, (Continuation<? super Unit>) continuation);
        }
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            this.label = 1;
            if (this.$mainNavigationViewModel.getRequestedTargets().collect(new AnonymousClass1(this.$navigationRequestHandler, this.$navigationError$delegate), this) == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
        }
        throw new KotlinNothingValueException();
    }
}
