package com.box.android.domain.configuration;

import com.box.android.common.utilities.BuildConfigProvider;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: compiled from: IFeatureFlip.kt */
/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "com.box.android.domain.configuration.FeatureFlip$enabled$1", f = "IFeatureFlip.kt", i = {0}, l = {53}, m = "invokeSuspend", n = {"isPreRelease"}, s = {"I$0"}, v = 1)
final class FeatureFlip$enabled$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Boolean>, Object> {
    int I$0;
    int label;
    final /* synthetic */ FeatureFlip this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    FeatureFlip$enabled$1(FeatureFlip featureFlip, Continuation<? super FeatureFlip$enabled$1> continuation) {
        super(2, continuation);
        this.this$0 = featureFlip;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new FeatureFlip$enabled$1(this.this$0, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Boolean> continuation) {
        return ((FeatureFlip$enabled$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        boolean zBooleanValue;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            int i2 = (BuildConfigProvider.INSTANCE.isDebugBuild() || BuildConfigProvider.INSTANCE.isBetaTrack()) ? 1 : 0;
            if (i2 != 0 && this.this$0.getDebugOverridePrefs().contains(this.this$0.getName())) {
                zBooleanValue = this.this$0.getDebugOverridePrefs().getBoolean(this.this$0.getName(), false);
            } else {
                this.I$0 = i2;
                this.label = 1;
                obj = this.this$0.getEvaluator().evaluate(this.this$0.getRule(), this);
                if (obj == coroutine_suspended) {
                    return coroutine_suspended;
                }
            }
            return Boxing.boxBoolean(zBooleanValue);
        }
        if (i != 1) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        ResultKt.throwOnFailure(obj);
        zBooleanValue = ((Boolean) obj).booleanValue();
        return Boxing.boxBoolean(zBooleanValue);
    }
}
