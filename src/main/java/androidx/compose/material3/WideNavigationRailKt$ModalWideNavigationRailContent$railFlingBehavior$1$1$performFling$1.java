package androidx.compose.material3;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: compiled from: WideNavigationRail.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "androidx.compose.material3.WideNavigationRailKt$ModalWideNavigationRailContent$railFlingBehavior$1$1", f = "WideNavigationRail.kt", i = {1}, l = {1202, 1204, 1204}, m = "performFling", n = {"remainingVelocity"}, s = {"F$0"}, v = 1)
final class WideNavigationRailKt$ModalWideNavigationRailContent$railFlingBehavior$1$1$performFling$1 extends ContinuationImpl {
    float F$0;
    Object L$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ WideNavigationRailKt$ModalWideNavigationRailContent$railFlingBehavior$1$1 this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    WideNavigationRailKt$ModalWideNavigationRailContent$railFlingBehavior$1$1$performFling$1(WideNavigationRailKt$ModalWideNavigationRailContent$railFlingBehavior$1$1 wideNavigationRailKt$ModalWideNavigationRailContent$railFlingBehavior$1$1, Continuation<? super WideNavigationRailKt$ModalWideNavigationRailContent$railFlingBehavior$1$1$performFling$1> continuation) {
        super(continuation);
        this.this$0 = wideNavigationRailKt$ModalWideNavigationRailContent$railFlingBehavior$1$1;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.performFling(null, 0.0f, this);
    }
}
