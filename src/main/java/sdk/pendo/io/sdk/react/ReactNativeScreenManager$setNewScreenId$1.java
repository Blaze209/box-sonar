package sdk.pendo.io.sdk.react;

import external.sdk.pendo.io.mozilla.javascript.Token;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "sdk.pendo.io.sdk.react.ReactNativeScreenManager", f = "ReactNativeScreenManager.kt", i = {0, 1}, l = {139, Token.SETELEM_OP}, m = "setNewScreenId$pendoIO_release", n = {"this", "this"}, s = {"L$0", "L$0"})
final class ReactNativeScreenManager$setNewScreenId$1 extends ContinuationImpl {
    Object L$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ ReactNativeScreenManager this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    ReactNativeScreenManager$setNewScreenId$1(ReactNativeScreenManager reactNativeScreenManager, Continuation<? super ReactNativeScreenManager$setNewScreenId$1> continuation) {
        super(continuation);
        this.this$0 = reactNativeScreenManager;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.setNewScreenId$pendoIO_release(null, false, this);
    }
}
