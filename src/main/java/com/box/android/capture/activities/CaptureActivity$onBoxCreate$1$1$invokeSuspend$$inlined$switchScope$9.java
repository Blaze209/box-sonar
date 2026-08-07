package com.box.android.capture.activities;

import com.box.android.capture.audiorecording.cpl.AudioCaptureReducer;
import com.box.android.capture.audiorecording.presentation.integrated.AudioRecordingHostFragment;
import com.box.android.capture.cpl.CaptureModeState;
import com.box.android.cpl.Store;
import com.box.android.cpl.StoreKt;
import com.box.android.cpl.Wrapped;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KClass;
import kotlin.reflect.jvm.KClassesJvm;

/* JADX INFO: compiled from: Store.kt */
/* JADX INFO: loaded from: classes10.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0005\u0010\u0000\u001a\u00020\u0001\"\b\b\u0000\u0010\u0002*\u00020\u0003\"\u0004\b\u0001\u0010\u0004\"\n\b\u0002\u0010\u0005\u0018\u0001*\u0002H\u0002\"\u0004\b\u0003\u0010\u00062\u0006\u0010\u0007\u001a\u0002H\u0005H\u008a@¨\u0006\b"}, d2 = {"<anonymous>", "", "GlobalState", "", "Action", "ConcreteState", "LocalAction", "it", "com/box/android/cpl/StoreKt$switchScope$3"}, k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "com.box.android.capture.activities.CaptureActivity$onBoxCreate$1$1$invokeSuspend$$inlined$switchScope$9", f = "CaptureActivity.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {}, v = 1)
public final class CaptureActivity$onBoxCreate$1$1$invokeSuspend$$inlined$switchScope$9 extends SuspendLambda implements Function2<AudioCaptureReducer.State, Continuation<? super Unit>, Object> {
    final /* synthetic */ Function1 $fromLocalAction;
    final /* synthetic */ KClass $switchCase;
    final /* synthetic */ Store $this_switchScope;
    int label;
    final /* synthetic */ CaptureActivity this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CaptureActivity$onBoxCreate$1$1$invokeSuspend$$inlined$switchScope$9(Store store, KClass kClass, Function1 function1, Continuation continuation, CaptureActivity captureActivity) {
        super(2, continuation);
        this.$this_switchScope = store;
        this.$switchCase = kClass;
        this.$fromLocalAction = function1;
        this.this$0 = captureActivity;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new CaptureActivity$onBoxCreate$1$1$invokeSuspend$$inlined$switchScope$9(this.$this_switchScope, this.$switchCase, this.$fromLocalAction, continuation, this.this$0);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(AudioCaptureReducer.State state, Continuation<? super Unit> continuation) {
        return ((CaptureActivity$onBoxCreate$1$1$invokeSuspend$$inlined$switchScope$9) create(state, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        ResultKt.throwOnFailure(obj);
        CaptureActivity.replaceFragment$default(this.this$0, new AudioRecordingHostFragment(this.$this_switchScope.scope(KClassesJvm.getJvmName(this.$switchCase), new Function1<CaptureModeState, Wrapped<AudioCaptureReducer.State>>() { // from class: com.box.android.capture.activities.CaptureActivity$onBoxCreate$1$1$invokeSuspend$$inlined$switchScope$9.1
            @Override // kotlin.jvm.functions.Function1
            public final Wrapped<AudioCaptureReducer.State> invoke(CaptureModeState globalState) {
                Intrinsics.checkNotNullParameter(globalState, "globalState");
                if (!(globalState instanceof AudioCaptureReducer.State)) {
                    globalState = null;
                }
                AudioCaptureReducer.State state = (AudioCaptureReducer.State) globalState;
                if (state != null) {
                    return StoreKt.wrap(state);
                }
                return null;
            }
        }, this.$fromLocalAction)), false, 2, null);
        return Unit.INSTANCE;
    }
}
