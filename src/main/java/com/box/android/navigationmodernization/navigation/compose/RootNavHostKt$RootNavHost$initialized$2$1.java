package com.box.android.navigationmodernization.navigation.compose;

import androidx.compose.runtime.ProduceStateScope;
import com.box.android.navigationmodernization.navigation.configuration.RootNavigationConfigurator;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;

/* JADX INFO: compiled from: RootNavHost.kt */
/* JADX INFO: loaded from: classes12.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\u0010\u0000\u001a\u00020\u0001*\b\u0012\u0004\u0012\u00020\u00030\u0002H\n"}, d2 = {"<anonymous>", "", "Landroidx/compose/runtime/ProduceStateScope;", ""}, k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "com.box.android.navigationmodernization.navigation.compose.RootNavHostKt$RootNavHost$initialized$2$1", f = "RootNavHost.kt", i = {0}, l = {70}, m = "invokeSuspend", n = {"$this$produceState"}, s = {"L$0"}, v = 1)
final class RootNavHostKt$RootNavHost$initialized$2$1 extends SuspendLambda implements Function2<ProduceStateScope<Boolean>, Continuation<? super Unit>, Object> {
    final /* synthetic */ RootNavigationConfigurator $rootConfigurator;
    private /* synthetic */ Object L$0;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    RootNavHostKt$RootNavHost$initialized$2$1(RootNavigationConfigurator rootNavigationConfigurator, Continuation<? super RootNavHostKt$RootNavHost$initialized$2$1> continuation) {
        super(2, continuation);
        this.$rootConfigurator = rootNavigationConfigurator;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        RootNavHostKt$RootNavHost$initialized$2$1 rootNavHostKt$RootNavHost$initialized$2$1 = new RootNavHostKt$RootNavHost$initialized$2$1(this.$rootConfigurator, continuation);
        rootNavHostKt$RootNavHost$initialized$2$1.L$0 = obj;
        return rootNavHostKt$RootNavHost$initialized$2$1;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(ProduceStateScope<Boolean> produceStateScope, Continuation<? super Unit> continuation) {
        return ((RootNavHostKt$RootNavHost$initialized$2$1) create(produceStateScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        ProduceStateScope produceStateScope = (ProduceStateScope) this.L$0;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            this.L$0 = produceStateScope;
            this.label = 1;
            if (this.$rootConfigurator.initialize(this) == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
        }
        produceStateScope.setValue(Boxing.boxBoolean(true));
        return Unit.INSTANCE;
    }
}
