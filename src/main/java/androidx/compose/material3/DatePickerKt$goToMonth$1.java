package androidx.compose.material3;

import androidx.compose.foundation.lazy.LazyListState;
import androidx.compose.ui.focus.FocusManager;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: compiled from: DatePicker.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "androidx.compose.material3.DatePickerKt$goToMonth$1", f = "DatePicker.kt", i = {}, l = {2146}, m = "invokeSuspend", n = {}, s = {}, v = 1)
final class DatePickerKt$goToMonth$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

    /* JADX INFO: renamed from: $$v$c$androidx-compose-ui-focus-FocusDirection$-focusDirection$0, reason: not valid java name */
    final /* synthetic */ int f110$$v$c$androidxcomposeuifocusFocusDirection$focusDirection$0;
    final /* synthetic */ FocusManager $focusManager;
    final /* synthetic */ int $month;
    final /* synthetic */ LazyListState $state;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    DatePickerKt$goToMonth$1(LazyListState lazyListState, int i, FocusManager focusManager, int i2, Continuation<? super DatePickerKt$goToMonth$1> continuation) {
        super(2, continuation);
        this.$state = lazyListState;
        this.$month = i;
        this.$focusManager = focusManager;
        this.f110$$v$c$androidxcomposeuifocusFocusDirection$focusDirection$0 = i2;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new DatePickerKt$goToMonth$1(this.$state, this.$month, this.$focusManager, this.f110$$v$c$androidxcomposeuifocusFocusDirection$focusDirection$0, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((DatePickerKt$goToMonth$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            LazyListState lazyListState = this.$state;
            this.label = 1;
            if (LazyListState.animateScrollToItem$default(lazyListState, lazyListState.getFirstVisibleItemIndex() + this.$month, 0, this, 2, null) == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
        }
        this.$focusManager.mo6458moveFocus3ESFkO8(this.f110$$v$c$androidxcomposeuifocusFocusDirection$focusDirection$0);
        return Unit.INSTANCE;
    }
}
