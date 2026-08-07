package com.box.android.base.compose.datepicker;

import androidx.compose.material3.DatePickerState;
import androidx.compose.runtime.SnapshotStateKt;
import com.box.android.common.extensions.DateExtensionsKt;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.FlowKt;

/* JADX INFO: compiled from: BoxInlineDatePicker.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "com.box.android.base.compose.datepicker.BoxInlineDatePickerKt$BoxInlineDatePicker$1$1", f = "BoxInlineDatePicker.kt", i = {}, l = {89}, m = "invokeSuspend", n = {}, s = {}, v = 1)
final class BoxInlineDatePickerKt$BoxInlineDatePicker$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ DatePickerState $datePickerState;
    final /* synthetic */ Function1<Date, Unit> $onDateSelected;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    BoxInlineDatePickerKt$BoxInlineDatePicker$1$1(DatePickerState datePickerState, Function1<? super Date, Unit> function1, Continuation<? super BoxInlineDatePickerKt$BoxInlineDatePicker$1$1> continuation) {
        super(2, continuation);
        this.$datePickerState = datePickerState;
        this.$onDateSelected = function1;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new BoxInlineDatePickerKt$BoxInlineDatePicker$1$1(this.$datePickerState, this.$onDateSelected, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((BoxInlineDatePickerKt$BoxInlineDatePicker$1$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            final DatePickerState datePickerState = this.$datePickerState;
            final Flow flowFilterNotNull = FlowKt.filterNotNull(FlowKt.drop(SnapshotStateKt.snapshotFlow(new Function0() { // from class: com.box.android.base.compose.datepicker.BoxInlineDatePickerKt$BoxInlineDatePicker$1$1$$ExternalSyntheticLambda0
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    return datePickerState.getSelectedDateMillis();
                }
            }), 1));
            Flow<Date> flow = new Flow<Date>() { // from class: com.box.android.base.compose.datepicker.BoxInlineDatePickerKt$BoxInlineDatePicker$1$1$invokeSuspend$$inlined$map$1

                /* JADX INFO: renamed from: com.box.android.base.compose.datepicker.BoxInlineDatePickerKt$BoxInlineDatePicker$1$1$invokeSuspend$$inlined$map$1$2, reason: invalid class name */
                /* JADX INFO: compiled from: Emitters.kt */
                @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
                public static final class AnonymousClass2<T> implements FlowCollector {
                    final /* synthetic */ FlowCollector $this_unsafeFlow;

                    /* JADX INFO: renamed from: com.box.android.base.compose.datepicker.BoxInlineDatePickerKt$BoxInlineDatePicker$1$1$invokeSuspend$$inlined$map$1$2$1, reason: invalid class name */
                    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
                    @DebugMetadata(c = "com.box.android.base.compose.datepicker.BoxInlineDatePickerKt$BoxInlineDatePicker$1$1$invokeSuspend$$inlined$map$1$2", f = "BoxInlineDatePicker.kt", i = {0, 0, 0, 0, 0}, l = {50}, m = "emit", n = {"value", "$completion", "value", "$this$map_u24lambda_u245", "$i$a$-unsafeTransform-FlowKt__TransformKt$map$1"}, s = {"L$0", "L$1", "L$2", "L$3", "I$0"}, v = 1)
                    public static final class AnonymousClass1 extends ContinuationImpl {
                        int I$0;
                        Object L$0;
                        Object L$1;
                        Object L$2;
                        Object L$3;
                        int label;
                        /* synthetic */ Object result;

                        public AnonymousClass1(Continuation continuation) {
                            super(continuation);
                        }

                        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                        public final Object invokeSuspend(Object obj) {
                            this.result = obj;
                            this.label |= Integer.MIN_VALUE;
                            return AnonymousClass2.this.emit(null, this);
                        }
                    }

                    public AnonymousClass2(FlowCollector flowCollector) {
                        this.$this_unsafeFlow = flowCollector;
                    }

                    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
                    @Override // kotlinx.coroutines.flow.FlowCollector
                    public final Object emit(Object obj, Continuation continuation) {
                        AnonymousClass1 anonymousClass1;
                        if (continuation instanceof AnonymousClass1) {
                            anonymousClass1 = (AnonymousClass1) continuation;
                            if ((anonymousClass1.label & Integer.MIN_VALUE) != 0) {
                                anonymousClass1.label -= Integer.MIN_VALUE;
                            } else {
                                anonymousClass1 = new AnonymousClass1(continuation);
                            }
                        } else {
                            anonymousClass1 = new AnonymousClass1(continuation);
                        }
                        Object obj2 = anonymousClass1.result;
                        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                        int i = anonymousClass1.label;
                        if (i == 0) {
                            ResultKt.throwOnFailure(obj2);
                            FlowCollector flowCollector = this.$this_unsafeFlow;
                            long jLongValue = ((Number) obj).longValue();
                            Calendar calendar = Calendar.getInstance(TimeZone.getTimeZone("UTC"));
                            calendar.setTimeInMillis(jLongValue);
                            Date time = calendar.getTime();
                            Intrinsics.checkNotNullExpressionValue(time, "getTime(...)");
                            Date endOfDay = DateExtensionsKt.toEndOfDay(time);
                            anonymousClass1.L$0 = SpillingKt.nullOutSpilledVariable(obj);
                            anonymousClass1.L$1 = SpillingKt.nullOutSpilledVariable(anonymousClass1);
                            anonymousClass1.L$2 = SpillingKt.nullOutSpilledVariable(obj);
                            anonymousClass1.L$3 = SpillingKt.nullOutSpilledVariable(flowCollector);
                            anonymousClass1.I$0 = 0;
                            anonymousClass1.label = 1;
                            if (flowCollector.emit(endOfDay, anonymousClass1) == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                        } else {
                            if (i != 1) {
                                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                            }
                            int i2 = anonymousClass1.I$0;
                            Object obj3 = anonymousClass1.L$2;
                            Object obj4 = anonymousClass1.L$0;
                            ResultKt.throwOnFailure(obj2);
                        }
                        return Unit.INSTANCE;
                    }
                }

                @Override // kotlinx.coroutines.flow.Flow
                public Object collect(FlowCollector<? super Date> flowCollector, Continuation continuation) {
                    Object objCollect = flowFilterNotNull.collect(new AnonymousClass2(flowCollector), continuation);
                    return objCollect == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objCollect : Unit.INSTANCE;
                }
            };
            final Function1<Date, Unit> function1 = this.$onDateSelected;
            this.label = 1;
            if (flow.collect(new FlowCollector() { // from class: com.box.android.base.compose.datepicker.BoxInlineDatePickerKt$BoxInlineDatePicker$1$1.3
                @Override // kotlinx.coroutines.flow.FlowCollector
                public /* bridge */ /* synthetic */ Object emit(Object obj2, Continuation continuation) {
                    return emit((Date) obj2, (Continuation<? super Unit>) continuation);
                }

                public final Object emit(Date date, Continuation<? super Unit> continuation) {
                    function1.invoke(date);
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
