package com.box.android.contentpicker.multitabitempicker;

import androidx.compose.runtime.MutableState;
import com.box.android.contentpicker.ContentPickerReducer;
import com.box.android.cpl.Store;
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
@DebugMetadata(c = "com.box.android.contentpicker.multitabitempicker.MultiTabItemPickerScreenContentKt$MultiTabItemPickerScreenContent$2$1", f = "MultiTabItemPickerScreenContent.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {}, v = 1)
final class MultiTabItemPickerScreenContentKt$MultiTabItemPickerScreenContent$2$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ MutableState<ItemPickerTab> $currentTab$delegate;
    final /* synthetic */ Store<ContentPickerReducer.State, ContentPickerReducer.Action> $store;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    MultiTabItemPickerScreenContentKt$MultiTabItemPickerScreenContent$2$1(Store<ContentPickerReducer.State, ContentPickerReducer.Action> store, MutableState<ItemPickerTab> mutableState, Continuation<? super MultiTabItemPickerScreenContentKt$MultiTabItemPickerScreenContent$2$1> continuation) {
        super(2, continuation);
        this.$store = store;
        this.$currentTab$delegate = mutableState;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new MultiTabItemPickerScreenContentKt$MultiTabItemPickerScreenContent$2$1(this.$store, this.$currentTab$delegate, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((MultiTabItemPickerScreenContentKt$MultiTabItemPickerScreenContent$2$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            this.$store.send(new ContentPickerReducer.Action.ActiveSelectionScreenChanged(MultiTabItemPickerScreenContentKt.MultiTabItemPickerScreenContent$lambda$1(this.$currentTab$delegate).toScreenName()));
            return Unit.INSTANCE;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
