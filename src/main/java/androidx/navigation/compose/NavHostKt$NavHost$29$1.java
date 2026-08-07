package androidx.navigation.compose;

import androidx.compose.animation.core.SeekableTransitionState;
import androidx.compose.animation.core.Transition;
import androidx.navigation.NavBackStackEntry;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: compiled from: NavHost.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "androidx.navigation.compose.NavHostKt$NavHost$29$1", f = "NavHost.kt", i = {}, l = {644, 651}, m = "invokeSuspend", n = {}, s = {})
final class NavHostKt$NavHost$29$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ NavBackStackEntry $backStackEntry;
    final /* synthetic */ Transition<NavBackStackEntry> $transition;
    final /* synthetic */ SeekableTransitionState<NavBackStackEntry> $transitionState;
    private /* synthetic */ Object L$0;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    NavHostKt$NavHost$29$1(SeekableTransitionState<NavBackStackEntry> seekableTransitionState, NavBackStackEntry navBackStackEntry, Transition<NavBackStackEntry> transition, Continuation<? super NavHostKt$NavHost$29$1> continuation) {
        super(2, continuation);
        this.$transitionState = seekableTransitionState;
        this.$backStackEntry = navBackStackEntry;
        this.$transition = transition;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        NavHostKt$NavHost$29$1 navHostKt$NavHost$29$1 = new NavHostKt$NavHost$29$1(this.$transitionState, this.$backStackEntry, this.$transition, continuation);
        navHostKt$NavHost$29$1.L$0 = obj;
        return navHostKt$NavHost$29$1;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((NavHostKt$NavHost$29$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Code restructure failed: missing block: B:13:0x0040, code lost:
    
        if (androidx.compose.animation.core.SeekableTransitionState.animateTo$default(r13.$transitionState, r13.$backStackEntry, null, r13, 2, null) == r0) goto L17;
     */
    /* JADX WARN: Code restructure failed: missing block: B:16:0x007d, code lost:
    
        if (androidx.compose.animation.core.SuspendAnimationKt.animate$default(r5, 0.0f, 0.0f, r8, new androidx.navigation.compose.NavHostKt$NavHost$29$1$$ExternalSyntheticLambda0(r14, r1, r3), r13, 4, null) == r0) goto L17;
     */
    /* JADX WARN: Code restructure failed: missing block: B:17:0x007f, code lost:
    
        return r0;
     */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r14) {
        /*
            r13 = this;
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r1 = r13.label
            r2 = 2
            r3 = 1
            if (r1 == 0) goto L1b
            if (r1 == r3) goto L17
            if (r1 != r2) goto Lf
            goto L17
        Lf:
            java.lang.IllegalStateException r13 = new java.lang.IllegalStateException
            java.lang.String r14 = "call to 'resume' before 'invoke' with coroutine"
            r13.<init>(r14)
            throw r13
        L17:
            kotlin.ResultKt.throwOnFailure(r14)
            goto L80
        L1b:
            kotlin.ResultKt.throwOnFailure(r14)
            java.lang.Object r14 = r13.L$0
            kotlinx.coroutines.CoroutineScope r14 = (kotlinx.coroutines.CoroutineScope) r14
            androidx.compose.animation.core.SeekableTransitionState<androidx.navigation.NavBackStackEntry> r1 = r13.$transitionState
            java.lang.Object r1 = r1.getCurrentState()
            androidx.navigation.NavBackStackEntry r4 = r13.$backStackEntry
            boolean r1 = kotlin.jvm.internal.Intrinsics.areEqual(r1, r4)
            if (r1 != 0) goto L43
            androidx.compose.animation.core.SeekableTransitionState<androidx.navigation.NavBackStackEntry> r4 = r13.$transitionState
            androidx.navigation.NavBackStackEntry r5 = r13.$backStackEntry
            r7 = r13
            kotlin.coroutines.Continuation r7 = (kotlin.coroutines.Continuation) r7
            r13.label = r3
            r6 = 0
            r8 = 2
            r9 = 0
            java.lang.Object r13 = androidx.compose.animation.core.SeekableTransitionState.animateTo$default(r4, r5, r6, r7, r8, r9)
            if (r13 != r0) goto L80
            goto L7f
        L43:
            androidx.compose.animation.core.Transition<androidx.navigation.NavBackStackEntry> r1 = r13.$transition
            long r3 = r1.getTotalDurationNanos()
            r1 = 1000000(0xf4240, float:1.401298E-39)
            long r5 = (long) r1
            long r3 = r3 / r5
            androidx.compose.animation.core.SeekableTransitionState<androidx.navigation.NavBackStackEntry> r1 = r13.$transitionState
            float r5 = r1.getFraction()
            androidx.compose.animation.core.SeekableTransitionState<androidx.navigation.NavBackStackEntry> r1 = r13.$transitionState
            float r1 = r1.getFraction()
            float r3 = (float) r3
            float r1 = r1 * r3
            int r1 = (int) r1
            r3 = 0
            r4 = 6
            r6 = 0
            androidx.compose.animation.core.TweenSpec r1 = androidx.compose.animation.core.AnimationSpecKt.tween$default(r1, r3, r6, r4, r6)
            r8 = r1
            androidx.compose.animation.core.AnimationSpec r8 = (androidx.compose.animation.core.AnimationSpec) r8
            androidx.compose.animation.core.SeekableTransitionState<androidx.navigation.NavBackStackEntry> r1 = r13.$transitionState
            androidx.navigation.NavBackStackEntry r3 = r13.$backStackEntry
            androidx.navigation.compose.NavHostKt$NavHost$29$1$$ExternalSyntheticLambda0 r9 = new androidx.navigation.compose.NavHostKt$NavHost$29$1$$ExternalSyntheticLambda0
            r9.<init>()
            r10 = r13
            kotlin.coroutines.Continuation r10 = (kotlin.coroutines.Continuation) r10
            r13.label = r2
            r6 = 0
            r7 = 0
            r11 = 4
            r12 = 0
            java.lang.Object r13 = androidx.compose.animation.core.SuspendAnimationKt.animate$default(r5, r6, r7, r8, r9, r10, r11, r12)
            if (r13 != r0) goto L80
        L7f:
            return r0
        L80:
            kotlin.Unit r13 = kotlin.Unit.INSTANCE
            return r13
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.navigation.compose.NavHostKt$NavHost$29$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit invokeSuspend$lambda$0(CoroutineScope coroutineScope, SeekableTransitionState seekableTransitionState, NavBackStackEntry navBackStackEntry, float f, float f2) {
        BuildersKt__Builders_commonKt.launch$default(coroutineScope, null, null, new NavHostKt$NavHost$29$1$1$1(f, seekableTransitionState, navBackStackEntry, null), 3, null);
        return Unit.INSTANCE;
    }
}
