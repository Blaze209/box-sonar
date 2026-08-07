package com.box.android.base.compose;

import android.content.res.Configuration;
import androidx.compose.runtime.MutableIntState;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: compiled from: OrientationAware.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "com.box.android.base.compose.OrientationAwareKt$OrientationAware$2$1", f = "OrientationAware.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {}, v = 1)
final class OrientationAwareKt$OrientationAware$2$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Configuration $configuration;
    final /* synthetic */ MutableIntState $currentOrientation$delegate;
    final /* synthetic */ Function1<Boolean, Unit> $onOrientationChange;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    OrientationAwareKt$OrientationAware$2$1(Configuration configuration, Function1<? super Boolean, Unit> function1, MutableIntState mutableIntState, Continuation<? super OrientationAwareKt$OrientationAware$2$1> continuation) {
        super(2, continuation);
        this.$configuration = configuration;
        this.$onOrientationChange = function1;
        this.$currentOrientation$delegate = mutableIntState;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new OrientationAwareKt$OrientationAware$2$1(this.$configuration, this.$onOrientationChange, this.$currentOrientation$delegate, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((OrientationAwareKt$OrientationAware$2$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            if (OrientationAwareKt.OrientationAware$lambda$2(this.$currentOrientation$delegate) != this.$configuration.orientation) {
                this.$currentOrientation$delegate.setIntValue(this.$configuration.orientation);
                this.$onOrientationChange.invoke(Boxing.boxBoolean(this.$configuration.orientation == 1));
            }
            return Unit.INSTANCE;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
