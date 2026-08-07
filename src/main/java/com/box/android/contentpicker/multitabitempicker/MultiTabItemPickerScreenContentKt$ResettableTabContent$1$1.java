package com.box.android.contentpicker.multitabitempicker;

import androidx.compose.runtime.MutableIntState;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: compiled from: MultiTabItemPickerScreenContent.kt */
/* JADX INFO: loaded from: classes10.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "com.box.android.contentpicker.multitabitempicker.MultiTabItemPickerScreenContentKt$ResettableTabContent$1$1", f = "MultiTabItemPickerScreenContent.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {}, v = 1)
final class MultiTabItemPickerScreenContentKt$ResettableTabContent$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ boolean $isCurrentTab;
    final /* synthetic */ MutableIntState $resetKey$delegate;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    MultiTabItemPickerScreenContentKt$ResettableTabContent$1$1(boolean z, MutableIntState mutableIntState, Continuation<? super MultiTabItemPickerScreenContentKt$ResettableTabContent$1$1> continuation) {
        super(2, continuation);
        this.$isCurrentTab = z;
        this.$resetKey$delegate = mutableIntState;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new MultiTabItemPickerScreenContentKt$ResettableTabContent$1$1(this.$isCurrentTab, this.$resetKey$delegate, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((MultiTabItemPickerScreenContentKt$ResettableTabContent$1$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        ResultKt.throwOnFailure(obj);
        if (!this.$isCurrentTab) {
            this.$resetKey$delegate.setIntValue(MultiTabItemPickerScreenContentKt.ResettableTabContent$lambda$1(this.$resetKey$delegate) + 1);
        }
        return Unit.INSTANCE;
    }
}
