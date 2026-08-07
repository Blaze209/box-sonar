package expo.modules.nativeelementsexpo.keyboardavoidingview;

import android.util.Log;
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

/* JADX INFO: compiled from: NativeKeyboardAvoidingView.kt */
/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "expo.modules.nativeelementsexpo.keyboardavoidingview.NativeKeyboardAvoidingView$ImeInsetObserver$1$1", f = "NativeKeyboardAvoidingView.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
final class NativeKeyboardAvoidingView$ImeInsetObserver$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ int $imeBottomPx;
    final /* synthetic */ Function1<Integer, Unit> $onImeChanged;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    NativeKeyboardAvoidingView$ImeInsetObserver$1$1(int i, Function1<? super Integer, Unit> function1, Continuation<? super NativeKeyboardAvoidingView$ImeInsetObserver$1$1> continuation) {
        super(2, continuation);
        this.$imeBottomPx = i;
        this.$onImeChanged = function1;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new NativeKeyboardAvoidingView$ImeInsetObserver$1$1(this.$imeBottomPx, this.$onImeChanged, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((NativeKeyboardAvoidingView$ImeInsetObserver$1$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        ResultKt.throwOnFailure(obj);
        Log.d("NativeKeyboardAvoidingView", "Ime changed: " + this.$imeBottomPx);
        this.$onImeChanged.invoke(Boxing.boxInt(this.$imeBottomPx));
        return Unit.INSTANCE;
    }
}
