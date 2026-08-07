package com.box.android.capture.widget;

import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.State;
import com.box.android.capture.cpl.CaptureReducer;
import com.box.android.domain.models.capture.CaptureMode;
import external.sdk.pendo.io.mozilla.javascript.Token;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;

/* JADX INFO: compiled from: CaptureModeSwitcher.kt */
/* JADX INFO: loaded from: classes10.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "com.box.android.capture.widget.CaptureModeSwitcherKt$ChangeCaptureModeEffect$1$1", f = "CaptureModeSwitcher.kt", i = {}, l = {Token.DOTDOT}, m = "invokeSuspend", n = {}, s = {}, v = 1)
final class CaptureModeSwitcherKt$ChangeCaptureModeEffect$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Function1<CaptureMode, Unit> $onModeChange;
    final /* synthetic */ State<CaptureReducer.State> $state$delegate;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    CaptureModeSwitcherKt$ChangeCaptureModeEffect$1$1(State<CaptureReducer.State> state, Function1<? super CaptureMode, Unit> function1, Continuation<? super CaptureModeSwitcherKt$ChangeCaptureModeEffect$1$1> continuation) {
        super(2, continuation);
        this.$state$delegate = state;
        this.$onModeChange = function1;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new CaptureModeSwitcherKt$ChangeCaptureModeEffect$1$1(this.$state$delegate, this.$onModeChange, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((CaptureModeSwitcherKt$ChangeCaptureModeEffect$1$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            final State<CaptureReducer.State> state = this.$state$delegate;
            Flow flowSnapshotFlow = SnapshotStateKt.snapshotFlow(new Function0() { // from class: com.box.android.capture.widget.CaptureModeSwitcherKt$ChangeCaptureModeEffect$1$1$$ExternalSyntheticLambda0
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    return CaptureModeSwitcherKt$ChangeCaptureModeEffect$1$1.invokeSuspend$lambda$0(state);
                }
            });
            final Function1<CaptureMode, Unit> function1 = this.$onModeChange;
            this.label = 1;
            if (flowSnapshotFlow.collect(new FlowCollector() { // from class: com.box.android.capture.widget.CaptureModeSwitcherKt$ChangeCaptureModeEffect$1$1.2
                @Override // kotlinx.coroutines.flow.FlowCollector
                public /* bridge */ /* synthetic */ Object emit(Object obj2, Continuation continuation) {
                    return emit((CaptureMode) obj2, (Continuation<? super Unit>) continuation);
                }

                public final Object emit(CaptureMode captureMode, Continuation<? super Unit> continuation) {
                    function1.invoke(captureMode);
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

    /* JADX INFO: Access modifiers changed from: private */
    public static final CaptureMode invokeSuspend$lambda$0(State state) {
        return CaptureModeSwitcherKt.ChangeCaptureModeEffect$lambda$0(state).getCaptureMode();
    }
}
