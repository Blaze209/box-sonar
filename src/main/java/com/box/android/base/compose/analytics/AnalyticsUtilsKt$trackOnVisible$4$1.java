package com.box.android.base.compose.analytics;

import androidx.compose.runtime.MutableState;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: compiled from: AnalyticsUtils.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "com.box.android.base.compose.analytics.AnalyticsUtilsKt$trackOnVisible$4$1", f = "AnalyticsUtils.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {}, v = 1)
final class AnalyticsUtilsKt$trackOnVisible$4$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ boolean $canTrackNow;
    final /* synthetic */ MutableState<Boolean> $hasEventTracked$delegate;
    final /* synthetic */ MutableState<Boolean> $isVisible$delegate;
    final /* synthetic */ Function0<Unit> $onTrack;
    final /* synthetic */ Function0<Boolean> $shouldTrack;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    AnalyticsUtilsKt$trackOnVisible$4$1(boolean z, MutableState<Boolean> mutableState, Function0<Boolean> function0, Function0<Unit> function1, MutableState<Boolean> mutableState2, Continuation<? super AnalyticsUtilsKt$trackOnVisible$4$1> continuation) {
        super(2, continuation);
        this.$canTrackNow = z;
        this.$isVisible$delegate = mutableState;
        this.$shouldTrack = function0;
        this.$onTrack = function1;
        this.$hasEventTracked$delegate = mutableState2;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new AnalyticsUtilsKt$trackOnVisible$4$1(this.$canTrackNow, this.$isVisible$delegate, this.$shouldTrack, this.$onTrack, this.$hasEventTracked$delegate, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((AnalyticsUtilsKt$trackOnVisible$4$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            if (AnalyticsUtilsKt.trackOnVisible$lambda$2(this.$isVisible$delegate) && this.$canTrackNow) {
                AnalyticsUtilsKt.trackOnVisible$tryTrackEvent(this.$shouldTrack, this.$onTrack, this.$isVisible$delegate, this.$hasEventTracked$delegate);
            }
            return Unit.INSTANCE;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
