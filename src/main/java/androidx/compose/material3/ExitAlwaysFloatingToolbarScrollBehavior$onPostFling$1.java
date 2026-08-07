package androidx.compose.material3;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: compiled from: FloatingToolbar.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "androidx.compose.material3.ExitAlwaysFloatingToolbarScrollBehavior", f = "FloatingToolbar.kt", i = {0}, l = {664, 666}, m = "onPostFling-RZ2iAVY", n = {"$v$c$androidx-compose-ui-unit-Velocity$-available$0"}, s = {"J$0"}, v = 1)
final class ExitAlwaysFloatingToolbarScrollBehavior$onPostFling$1 extends ContinuationImpl {
    long J$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ ExitAlwaysFloatingToolbarScrollBehavior this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    ExitAlwaysFloatingToolbarScrollBehavior$onPostFling$1(ExitAlwaysFloatingToolbarScrollBehavior exitAlwaysFloatingToolbarScrollBehavior, Continuation<? super ExitAlwaysFloatingToolbarScrollBehavior$onPostFling$1> continuation) {
        super(continuation);
        this.this$0 = exitAlwaysFloatingToolbarScrollBehavior;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.mo945onPostFlingRZ2iAVY(0L, 0L, this);
    }
}
