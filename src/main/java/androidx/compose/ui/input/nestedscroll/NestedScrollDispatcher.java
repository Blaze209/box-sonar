package androidx.compose.ui.input.nestedscroll;

import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.unit.Velocity;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function0;
import kotlinx.coroutines.CoroutineScope;
import sdk.pendo.io.actions.configurations.GuideCapping;

/* JADX INFO: compiled from: NestedScrollModifier.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u001d\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020 2\u0006\u0010\"\u001a\u00020#¢\u0006\u0004\b$\u0010%J%\u0010&\u001a\u00020 2\u0006\u0010'\u001a\u00020 2\u0006\u0010!\u001a\u00020 2\u0006\u0010\"\u001a\u00020#¢\u0006\u0004\b(\u0010)J\u0018\u0010*\u001a\u00020+2\u0006\u0010!\u001a\u00020+H\u0086@¢\u0006\u0004\b,\u0010-J \u0010.\u001a\u00020+2\u0006\u0010'\u001a\u00020+2\u0006\u0010!\u001a\u00020+H\u0086@¢\u0006\u0004\b/\u00100R\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001c\u0010\n\u001a\u0004\u0018\u00010\u0005X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\u0007\"\u0004\b\f\u0010\tR\"\u0010\r\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u000f0\u000eX\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u001c\u0010\u0014\u001a\u0004\u0018\u00010\u000fX\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\u0011\u0010\u0019\u001a\u00020\u000f8F¢\u0006\u0006\u001a\u0004\b\u001a\u0010\u0016R\u0016\u0010\u001b\u001a\u0004\u0018\u00010\u001c8@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b\u001d\u0010\u001e¨\u00061"}, d2 = {"Landroidx/compose/ui/input/nestedscroll/NestedScrollDispatcher;", "", "<init>", "()V", "nestedScrollNode", "Landroidx/compose/ui/input/nestedscroll/NestedScrollNode;", "getNestedScrollNode$ui", "()Landroidx/compose/ui/input/nestedscroll/NestedScrollNode;", "setNestedScrollNode$ui", "(Landroidx/compose/ui/input/nestedscroll/NestedScrollNode;)V", "lastKnownParentNode", "getLastKnownParentNode$ui", "setLastKnownParentNode$ui", "calculateNestedScrollScope", "Lkotlin/Function0;", "Lkotlinx/coroutines/CoroutineScope;", "getCalculateNestedScrollScope$ui", "()Lkotlin/jvm/functions/Function0;", "setCalculateNestedScrollScope$ui", "(Lkotlin/jvm/functions/Function0;)V", "scope", "getScope$ui", "()Lkotlinx/coroutines/CoroutineScope;", "setScope$ui", "(Lkotlinx/coroutines/CoroutineScope;)V", "coroutineScope", "getCoroutineScope", "parent", "Landroidx/compose/ui/input/nestedscroll/NestedScrollConnection;", "getParent$ui", "()Landroidx/compose/ui/input/nestedscroll/NestedScrollConnection;", "dispatchPreScroll", "Landroidx/compose/ui/geometry/Offset;", "available", "source", "Landroidx/compose/ui/input/nestedscroll/NestedScrollSource;", "dispatchPreScroll-OzD1aCk", "(JI)J", "dispatchPostScroll", GuideCapping.INSERT_CAPPING_CONSUMED, "dispatchPostScroll-DzOQY0M", "(JJI)J", "dispatchPreFling", "Landroidx/compose/ui/unit/Velocity;", "dispatchPreFling-QWom1Mo", "(JLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "dispatchPostFling", "dispatchPostFling-RZ2iAVY", "(JJLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "ui"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class NestedScrollDispatcher {
    public static final int $stable = 8;
    private Function0<? extends CoroutineScope> calculateNestedScrollScope = new Function0<CoroutineScope>() { // from class: androidx.compose.ui.input.nestedscroll.NestedScrollDispatcher$calculateNestedScrollScope$1
        {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public final CoroutineScope invoke() {
            return this.this$0.getScope();
        }
    };
    private NestedScrollNode lastKnownParentNode;
    private NestedScrollNode nestedScrollNode;
    private CoroutineScope scope;

    /* JADX INFO: renamed from: getNestedScrollNode$ui, reason: from getter */
    public final NestedScrollNode getNestedScrollNode() {
        return this.nestedScrollNode;
    }

    public final void setNestedScrollNode$ui(NestedScrollNode nestedScrollNode) {
        this.nestedScrollNode = nestedScrollNode;
    }

    /* JADX INFO: renamed from: getLastKnownParentNode$ui, reason: from getter */
    public final NestedScrollNode getLastKnownParentNode() {
        return this.lastKnownParentNode;
    }

    public final void setLastKnownParentNode$ui(NestedScrollNode nestedScrollNode) {
        this.lastKnownParentNode = nestedScrollNode;
    }

    public final Function0<CoroutineScope> getCalculateNestedScrollScope$ui() {
        return this.calculateNestedScrollScope;
    }

    public final void setCalculateNestedScrollScope$ui(Function0<? extends CoroutineScope> function0) {
        this.calculateNestedScrollScope = function0;
    }

    /* JADX INFO: renamed from: getScope$ui, reason: from getter */
    public final CoroutineScope getScope() {
        return this.scope;
    }

    public final void setScope$ui(CoroutineScope coroutineScope) {
        this.scope = coroutineScope;
    }

    public final CoroutineScope getCoroutineScope() {
        CoroutineScope coroutineScopeInvoke = this.calculateNestedScrollScope.invoke();
        if (coroutineScopeInvoke != null) {
            return coroutineScopeInvoke;
        }
        throw new IllegalStateException("in order to access nested coroutine scope you need to attach dispatcher to the `Modifier.nestedScroll` first.");
    }

    public final NestedScrollConnection getParent$ui() {
        NestedScrollNode nestedScrollNode = this.nestedScrollNode;
        return nestedScrollNode != null ? nestedScrollNode.getParentNestedScrollNode$ui() : null;
    }

    /* JADX INFO: renamed from: dispatchPreScroll-OzD1aCk, reason: not valid java name */
    public final long m7998dispatchPreScrollOzD1aCk(long available, int source) {
        NestedScrollConnection parent$ui = getParent$ui();
        return parent$ui != null ? parent$ui.mo1299onPreScrollOzD1aCk(available, source) : Offset.INSTANCE.m6585getZeroF1C5BW0();
    }

    /* JADX INFO: renamed from: dispatchPostScroll-DzOQY0M, reason: not valid java name */
    public final long m7996dispatchPostScrollDzOQY0M(long consumed, long available, int source) {
        NestedScrollConnection parent$ui = getParent$ui();
        return parent$ui != null ? parent$ui.mo946onPostScrollDzOQY0M(consumed, available, source) : Offset.INSTANCE.m6585getZeroF1C5BW0();
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    /* JADX INFO: renamed from: dispatchPreFling-QWom1Mo, reason: not valid java name */
    public final Object m7997dispatchPreFlingQWom1Mo(long j, Continuation<? super Velocity> continuation) {
        NestedScrollDispatcher$dispatchPreFling$1 nestedScrollDispatcher$dispatchPreFling$1;
        long jM9936getZero9UxMQ8M;
        if (continuation instanceof NestedScrollDispatcher$dispatchPreFling$1) {
            nestedScrollDispatcher$dispatchPreFling$1 = (NestedScrollDispatcher$dispatchPreFling$1) continuation;
            if ((nestedScrollDispatcher$dispatchPreFling$1.label & Integer.MIN_VALUE) != 0) {
                nestedScrollDispatcher$dispatchPreFling$1.label -= Integer.MIN_VALUE;
            } else {
                nestedScrollDispatcher$dispatchPreFling$1 = new NestedScrollDispatcher$dispatchPreFling$1(this, continuation);
            }
        } else {
            nestedScrollDispatcher$dispatchPreFling$1 = new NestedScrollDispatcher$dispatchPreFling$1(this, continuation);
        }
        Object objMo1298onPreFlingQWom1Mo = nestedScrollDispatcher$dispatchPreFling$1.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = nestedScrollDispatcher$dispatchPreFling$1.label;
        if (i == 0) {
            ResultKt.throwOnFailure(objMo1298onPreFlingQWom1Mo);
            NestedScrollConnection parent$ui = getParent$ui();
            if (parent$ui != null) {
                nestedScrollDispatcher$dispatchPreFling$1.label = 1;
                objMo1298onPreFlingQWom1Mo = parent$ui.mo1298onPreFlingQWom1Mo(j, nestedScrollDispatcher$dispatchPreFling$1);
                if (objMo1298onPreFlingQWom1Mo == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                jM9936getZero9UxMQ8M = Velocity.INSTANCE.m9936getZero9UxMQ8M();
            }
            return Velocity.m9916boximpl(jM9936getZero9UxMQ8M);
        }
        if (i != 1) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        ResultKt.throwOnFailure(objMo1298onPreFlingQWom1Mo);
        jM9936getZero9UxMQ8M = ((Velocity) objMo1298onPreFlingQWom1Mo).getPackedValue();
        return Velocity.m9916boximpl(jM9936getZero9UxMQ8M);
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x004e, code lost:
    
        if (r0 == r1) goto L29;
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x006b, code lost:
    
        if (r0 == r1) goto L29;
     */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x006d, code lost:
    
        return r1;
     */
    /* JADX INFO: renamed from: dispatchPostFling-RZ2iAVY, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object m7995dispatchPostFlingRZ2iAVY(long r6, long r8, kotlin.coroutines.Continuation<? super androidx.compose.ui.unit.Velocity> r10) {
        /*
            r5 = this;
            boolean r0 = r10 instanceof androidx.compose.ui.input.nestedscroll.NestedScrollDispatcher$dispatchPostFling$1
            if (r0 == 0) goto L14
            r0 = r10
            androidx.compose.ui.input.nestedscroll.NestedScrollDispatcher$dispatchPostFling$1 r0 = (androidx.compose.ui.input.nestedscroll.NestedScrollDispatcher$dispatchPostFling$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L14
            int r10 = r0.label
            int r10 = r10 - r2
            r0.label = r10
            goto L19
        L14:
            androidx.compose.ui.input.nestedscroll.NestedScrollDispatcher$dispatchPostFling$1 r0 = new androidx.compose.ui.input.nestedscroll.NestedScrollDispatcher$dispatchPostFling$1
            r0.<init>(r5, r10)
        L19:
            r10 = r0
            java.lang.Object r0 = r10.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r10.label
            r3 = 2
            r4 = 1
            if (r2 == 0) goto L3b
            if (r2 == r4) goto L37
            if (r2 != r3) goto L2e
            kotlin.ResultKt.throwOnFailure(r0)
            goto L6e
        L2e:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L37:
            kotlin.ResultKt.throwOnFailure(r0)
            goto L51
        L3b:
            kotlin.ResultKt.throwOnFailure(r0)
            androidx.compose.ui.input.nestedscroll.NestedScrollConnection r0 = r5.getParent$ui()
            if (r0 != 0) goto L5f
            androidx.compose.ui.input.nestedscroll.NestedScrollNode r5 = r5.lastKnownParentNode
            if (r5 == 0) goto L58
            r10.label = r4
            java.lang.Object r0 = r5.mo945onPostFlingRZ2iAVY(r6, r8, r10)
            if (r0 != r1) goto L51
            goto L6d
        L51:
            androidx.compose.ui.unit.Velocity r0 = (androidx.compose.ui.unit.Velocity) r0
            long r5 = r0.getPackedValue()
            goto L7b
        L58:
            androidx.compose.ui.unit.Velocity$Companion r5 = androidx.compose.ui.unit.Velocity.INSTANCE
            long r5 = r5.m9936getZero9UxMQ8M()
            goto L7b
        L5f:
            androidx.compose.ui.input.nestedscroll.NestedScrollConnection r5 = r5.getParent$ui()
            if (r5 == 0) goto L75
            r10.label = r3
            java.lang.Object r0 = r5.mo945onPostFlingRZ2iAVY(r6, r8, r10)
            if (r0 != r1) goto L6e
        L6d:
            return r1
        L6e:
            androidx.compose.ui.unit.Velocity r0 = (androidx.compose.ui.unit.Velocity) r0
            long r5 = r0.getPackedValue()
            goto L7b
        L75:
            androidx.compose.ui.unit.Velocity$Companion r5 = androidx.compose.ui.unit.Velocity.INSTANCE
            long r5 = r5.m9936getZero9UxMQ8M()
        L7b:
            androidx.compose.ui.unit.Velocity r5 = androidx.compose.ui.unit.Velocity.m9916boximpl(r5)
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.ui.input.nestedscroll.NestedScrollDispatcher.m7995dispatchPostFlingRZ2iAVY(long, long, kotlin.coroutines.Continuation):java.lang.Object");
    }
}
