package com.box.android.navigationmodernization.navigation.compose;

import androidx.compose.runtime.MutableState;
import com.box.android.domain.models.DomainError;
import com.box.android.navigationmodernization.navigation.configuration.RootNavigationConfigurator;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: compiled from: RootNavHost.kt */
/* JADX INFO: loaded from: classes12.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "com.box.android.navigationmodernization.navigation.compose.RootNavHostKt$MainNavigationTargetHandling$2$1", f = "RootNavHost.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {}, v = 1)
final class RootNavHostKt$MainNavigationTargetHandling$2$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ MutableState<DomainError> $navigationError$delegate;
    final /* synthetic */ RootNavigationConfigurator $rootConfigurator;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    RootNavHostKt$MainNavigationTargetHandling$2$1(RootNavigationConfigurator rootNavigationConfigurator, MutableState<DomainError> mutableState, Continuation<? super RootNavHostKt$MainNavigationTargetHandling$2$1> continuation) {
        super(2, continuation);
        this.$rootConfigurator = rootNavigationConfigurator;
        this.$navigationError$delegate = mutableState;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new RootNavHostKt$MainNavigationTargetHandling$2$1(this.$rootConfigurator, this.$navigationError$delegate, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((RootNavHostKt$MainNavigationTargetHandling$2$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        ResultKt.throwOnFailure(obj);
        this.$navigationError$delegate.setValue(this.$rootConfigurator.consumeNavigationError());
        return Unit.INSTANCE;
    }
}
