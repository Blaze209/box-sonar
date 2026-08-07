package com.box.android.contentpicker.multitabitempicker;

import androidx.compose.foundation.ScrollState;
import androidx.compose.runtime.SnapshotStateKt;
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
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.FlowKt;

/* JADX INFO: compiled from: MultiTabItemPickerTopBar.kt */
/* JADX INFO: loaded from: classes10.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "com.box.android.contentpicker.multitabitempicker.MultiTabItemPickerTopBarKt$FolderBreadcrumbSubtitle$1$1", f = "MultiTabItemPickerTopBar.kt", i = {}, l = {114}, m = "invokeSuspend", n = {}, s = {}, v = 1)
final class MultiTabItemPickerTopBarKt$FolderBreadcrumbSubtitle$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ ScrollState $scrollState;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    MultiTabItemPickerTopBarKt$FolderBreadcrumbSubtitle$1$1(ScrollState scrollState, Continuation<? super MultiTabItemPickerTopBarKt$FolderBreadcrumbSubtitle$1$1> continuation) {
        super(2, continuation);
        this.$scrollState = scrollState;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new MultiTabItemPickerTopBarKt$FolderBreadcrumbSubtitle$1$1(this.$scrollState, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((MultiTabItemPickerTopBarKt$FolderBreadcrumbSubtitle$1$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            final ScrollState scrollState = this.$scrollState;
            Flow flowDistinctUntilChanged = FlowKt.distinctUntilChanged(SnapshotStateKt.snapshotFlow(new Function0() { // from class: com.box.android.contentpicker.multitabitempicker.MultiTabItemPickerTopBarKt$FolderBreadcrumbSubtitle$1$1$$ExternalSyntheticLambda0
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    return Integer.valueOf(scrollState.getMaxValue());
                }
            }));
            final ScrollState scrollState2 = this.$scrollState;
            this.label = 1;
            if (flowDistinctUntilChanged.collect(new FlowCollector() { // from class: com.box.android.contentpicker.multitabitempicker.MultiTabItemPickerTopBarKt$FolderBreadcrumbSubtitle$1$1.2
                @Override // kotlinx.coroutines.flow.FlowCollector
                public /* bridge */ /* synthetic */ Object emit(Object obj2, Continuation continuation) {
                    return emit(((Number) obj2).intValue(), (Continuation<? super Unit>) continuation);
                }

                public final Object emit(int i2, Continuation<? super Unit> continuation) {
                    if (i2 > 0) {
                        Object objScrollTo = scrollState2.scrollTo(i2, continuation);
                        return objScrollTo == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objScrollTo : Unit.INSTANCE;
                    }
                    return Unit.INSTANCE;
                }
            }, this) == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
        }
        return Unit.INSTANCE;
    }
}
