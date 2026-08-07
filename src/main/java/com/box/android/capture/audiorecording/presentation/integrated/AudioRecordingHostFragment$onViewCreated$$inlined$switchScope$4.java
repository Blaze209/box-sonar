package com.box.android.capture.audiorecording.presentation.integrated;

import com.box.android.capture.CaptureErrorFragment;
import com.box.android.capture.audiorecording.cpl.AudioCaptureReducer;
import com.box.android.cpl.Store;
import com.box.android.cpl.StoreKt;
import com.box.android.cpl.Wrapped;
import com.box.android.domain.models.capture.CaptureMode;
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
@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0006\u0010\u0000\u001a\u00020\u0001\"\b\b\u0000\u0010\u0002*\u00020\u0003\"\u0004\b\u0001\u0010\u0004\"\n\b\u0002\u0010\u0005\u0018\u0001*\u0002H\u0002\"\u0004\b\u0003\u0010\u00062\u0006\u0010\u0007\u001a\u0002H\u0005H\u008a@¨\u0006\t"}, d2 = {"<anonymous>", "", "GlobalState", "", "Action", "ConcreteState", "LocalAction", "it", "com/box/android/cpl/StoreKt$switchScope$3", "com/box/android/cpl/StoreKt$switchScope$$inlined$switchScope$3"}, k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "com.box.android.capture.audiorecording.presentation.integrated.AudioRecordingHostFragment$onViewCreated$$inlined$switchScope$4", f = "AudioRecordingHostFragment.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {}, v = 1)
public final class AudioRecordingHostFragment$onViewCreated$$inlined$switchScope$4 extends SuspendLambda implements Function2<AudioCaptureReducer.State.PermissionRequired, Continuation<? super Unit>, Object> {
    final /* synthetic */ Function1 $fromLocalAction;
    final /* synthetic */ KClass $switchCase;
    final /* synthetic */ Store $this_switchScope;
    int label;
    final /* synthetic */ AudioRecordingHostFragment this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AudioRecordingHostFragment$onViewCreated$$inlined$switchScope$4(Store store, KClass kClass, Function1 function1, Continuation continuation, AudioRecordingHostFragment audioRecordingHostFragment) {
        super(2, continuation);
        this.$this_switchScope = store;
        this.$switchCase = kClass;
        this.$fromLocalAction = function1;
        this.this$0 = audioRecordingHostFragment;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new AudioRecordingHostFragment$onViewCreated$$inlined$switchScope$4(this.$this_switchScope, this.$switchCase, this.$fromLocalAction, continuation, this.this$0);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(AudioCaptureReducer.State.PermissionRequired permissionRequired, Continuation<? super Unit> continuation) {
        return ((AudioRecordingHostFragment$onViewCreated$$inlined$switchScope$4) create(permissionRequired, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        ResultKt.throwOnFailure(obj);
        this.$this_switchScope.scope(KClassesJvm.getJvmName(this.$switchCase), new Function1<AudioCaptureReducer.State, Wrapped<AudioCaptureReducer.State.PermissionRequired>>() { // from class: com.box.android.capture.audiorecording.presentation.integrated.AudioRecordingHostFragment$onViewCreated$$inlined$switchScope$4.1
            @Override // kotlin.jvm.functions.Function1
            public final Wrapped<AudioCaptureReducer.State.PermissionRequired> invoke(AudioCaptureReducer.State globalState) {
                Intrinsics.checkNotNullParameter(globalState, "globalState");
                if (!(globalState instanceof AudioCaptureReducer.State.PermissionRequired)) {
                    globalState = null;
                }
                AudioCaptureReducer.State.PermissionRequired permissionRequired = (AudioCaptureReducer.State.PermissionRequired) globalState;
                if (permissionRequired != null) {
                    return StoreKt.wrap(permissionRequired);
                }
                return null;
            }
        }, this.$fromLocalAction);
        this.this$0.replaceFragment(CaptureErrorFragment.INSTANCE.newInstance(CaptureMode.AUDIO));
        return Unit.INSTANCE;
    }
}
