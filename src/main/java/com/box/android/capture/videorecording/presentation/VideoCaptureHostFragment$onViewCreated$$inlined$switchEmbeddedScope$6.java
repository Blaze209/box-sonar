package com.box.android.capture.videorecording.presentation;

import com.box.android.capture.videorecording.VideoCaptureReducer;
import com.box.android.capture.videorecording.VideoReviewReducer;
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
@Metadata(d1 = {"\u0000\u0018\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0010\u0000\u001a\u00020\u0001\"\b\b\u0000\u0010\u0002*\u00020\u0003\"\u0004\b\u0001\u0010\u0004\"\u0010\b\u0002\u0010\u0005\u0018\u0001*\b\u0012\u0004\u0012\u0002H\u00070\u0006\"\u0004\b\u0003\u0010\b\"\u0004\b\u0004\u0010\u00072\u0006\u0010\t\u001a\u0002H\u0005H\u008a@¨\u0006\n"}, d2 = {"<anonymous>", "", "GlobalState", "", "Action", "ConcreteState", "Lcom/box/android/cpl/Embedded;", "LocalState", "LocalAction", "it", "com/box/android/cpl/StoreKt$switchEmbeddedScope$3"}, k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "com.box.android.capture.videorecording.presentation.VideoCaptureHostFragment$onViewCreated$$inlined$switchEmbeddedScope$6", f = "VideoCaptureHostFragment.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {}, v = 1)
public final class VideoCaptureHostFragment$onViewCreated$$inlined$switchEmbeddedScope$6 extends SuspendLambda implements Function2<VideoCaptureReducer.State.Reviewing, Continuation<? super Unit>, Object> {
    final /* synthetic */ Function1 $fromLocalAction;
    final /* synthetic */ KClass $switchCase;
    final /* synthetic */ Store $this_switchEmbeddedScope;
    int label;
    final /* synthetic */ VideoCaptureHostFragment this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public VideoCaptureHostFragment$onViewCreated$$inlined$switchEmbeddedScope$6(Store store, KClass kClass, Function1 function1, Continuation continuation, VideoCaptureHostFragment videoCaptureHostFragment) {
        super(2, continuation);
        this.$this_switchEmbeddedScope = store;
        this.$switchCase = kClass;
        this.$fromLocalAction = function1;
        this.this$0 = videoCaptureHostFragment;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new VideoCaptureHostFragment$onViewCreated$$inlined$switchEmbeddedScope$6(this.$this_switchEmbeddedScope, this.$switchCase, this.$fromLocalAction, continuation, this.this$0);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(VideoCaptureReducer.State.Reviewing reviewing, Continuation<? super Unit> continuation) {
        return ((VideoCaptureHostFragment$onViewCreated$$inlined$switchEmbeddedScope$6) create(reviewing, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        ResultKt.throwOnFailure(obj);
        this.this$0.replaceFragment(new VideoReviewFragment(this.$this_switchEmbeddedScope.scope(KClassesJvm.getJvmName(this.$switchCase), new Function1<VideoCaptureReducer.State, Wrapped<VideoReviewReducer.State>>() { // from class: com.box.android.capture.videorecording.presentation.VideoCaptureHostFragment$onViewCreated$$inlined$switchEmbeddedScope$6.1
            @Override // kotlin.jvm.functions.Function1
            public final Wrapped<VideoReviewReducer.State> invoke(VideoCaptureReducer.State globalState) {
                VideoReviewReducer.State action;
                Intrinsics.checkNotNullParameter(globalState, "globalState");
                if (!(globalState instanceof VideoCaptureReducer.State.Reviewing)) {
                    globalState = null;
                }
                VideoCaptureReducer.State.Reviewing reviewing = (VideoCaptureReducer.State.Reviewing) globalState;
                if (reviewing == null || (action = reviewing.getAction()) == null) {
                    return null;
                }
                return StoreKt.wrap(action);
            }
        }, this.$fromLocalAction)));
        return Unit.INSTANCE;
    }
}
