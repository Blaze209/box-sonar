package expo.modules.ui;

import androidx.compose.material3.TimePickerState;
import java.util.Calendar;
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

/* JADX INFO: compiled from: DatePickerView.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "expo.modules.ui.DatePickerViewKt$ExpoTimePicker$1$1", f = "DatePickerView.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
final class DatePickerViewKt$ExpoTimePicker$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Calendar $cal;
    final /* synthetic */ Function1<DatePickerResult, Unit> $onDateSelected;
    final /* synthetic */ TimePickerState $state;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    DatePickerViewKt$ExpoTimePicker$1$1(Calendar calendar, TimePickerState timePickerState, Function1<? super DatePickerResult, Unit> function1, Continuation<? super DatePickerViewKt$ExpoTimePicker$1$1> continuation) {
        super(2, continuation);
        this.$cal = calendar;
        this.$state = timePickerState;
        this.$onDateSelected = function1;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new DatePickerViewKt$ExpoTimePicker$1$1(this.$cal, this.$state, this.$onDateSelected, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((DatePickerViewKt$ExpoTimePicker$1$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        ResultKt.throwOnFailure(obj);
        this.$cal.set(11, this.$state.getHour());
        this.$cal.set(12, this.$state.getMinute());
        this.$cal.setLenient(false);
        this.$onDateSelected.invoke(new DatePickerResult(Boxing.boxLong(this.$cal.getTime().getTime())));
        return Unit.INSTANCE;
    }
}
