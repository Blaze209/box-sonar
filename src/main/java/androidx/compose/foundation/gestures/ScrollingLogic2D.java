package androidx.compose.foundation.gestures;

import androidx.compose.foundation.MutatePriority;
import androidx.compose.foundation.OverscrollEffect;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.input.nestedscroll.NestedScrollDispatcher;
import androidx.compose.ui.input.nestedscroll.NestedScrollSource;
import androidx.compose.ui.unit.Velocity;
import androidx.compose.ui.unit.VelocityKt;
import com.facebook.react.uimanager.ViewProps;
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
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;

/* JADX INFO: compiled from: Scrollable2D.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000}\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u001c\b\u0002\u0018\u00002\u00020\u0001B7\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000b¢\u0006\u0004\b\r\u0010\u000eJ#\u0010!\u001a\u00020 *\u00020\u001a2\u0006\u0010\"\u001a\u00020 2\u0006\u0010#\u001a\u00020\u0017H\u0002¢\u0006\u0004\b$\u0010%J\u0015\u0010&\u001a\u00020\f2\u0006\u0010'\u001a\u00020 ¢\u0006\u0004\b(\u0010)J\u0015\u0010&\u001a\u00020\f2\u0006\u0010*\u001a\u00020+¢\u0006\u0004\b,\u0010)J\u0017\u0010-\u001a\u00020 2\u0006\u0010.\u001a\u00020 H\u0016¢\u0006\u0004\b/\u00100J\u0017\u00101\u001a\u00020 2\u0006\u0010.\u001a\u00020 H\u0002¢\u0006\u0004\b2\u00100J\u0018\u00103\u001a\u0002042\u0006\u00105\u001a\u00020+H\u0086@¢\u0006\u0004\b6\u00107J\u0018\u00108\u001a\u00020+2\u0006\u00109\u001a\u00020+H\u0096@¢\u0006\u0004\b:\u00107J\u0006\u0010;\u001a\u00020\fJA\u0010.\u001a\u0002042\b\b\u0002\u0010<\u001a\u00020=2'\u0010>\u001a#\b\u0001\u0012\u0004\u0012\u00020@\u0012\n\u0012\b\u0012\u0004\u0012\u0002040A\u0012\u0006\u0012\u0004\u0018\u00010B0?¢\u0006\u0002\bCH\u0086@¢\u0006\u0002\u0010DJ(\u0010E\u001a\u00020\f2\u0006\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tR\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u001e\u0010\u0014\u001a\u00020\f2\u0006\u0010\u0013\u001a\u00020\f@RX\u0096\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0010\u0010\u0016\u001a\u00020\u0017X\u0082\u000e¢\u0006\u0004\n\u0002\u0010\u0018R\u000e\u0010\u0019\u001a\u00020\u001aX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001b\u001a\u00020\u001cX\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u001dR\u001a\u0010\u001e\u001a\u000e\u0012\u0004\u0012\u00020 \u0012\u0004\u0012\u00020 0\u001fX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006F"}, d2 = {"Landroidx/compose/foundation/gestures/ScrollingLogic2D;", "Landroidx/compose/foundation/gestures/ScrollLogic;", "scrollableState", "Landroidx/compose/foundation/gestures/Scrollable2DState;", "overscrollEffect", "Landroidx/compose/foundation/OverscrollEffect;", "flingBehavior", "Landroidx/compose/foundation/gestures/FlingBehavior;", "nestedScrollDispatcher", "Landroidx/compose/ui/input/nestedscroll/NestedScrollDispatcher;", "isScrollableNodeAttached", "Lkotlin/Function0;", "", "<init>", "(Landroidx/compose/foundation/gestures/Scrollable2DState;Landroidx/compose/foundation/OverscrollEffect;Landroidx/compose/foundation/gestures/FlingBehavior;Landroidx/compose/ui/input/nestedscroll/NestedScrollDispatcher;Lkotlin/jvm/functions/Function0;)V", "getScrollableState", "()Landroidx/compose/foundation/gestures/Scrollable2DState;", "setScrollableState", "(Landroidx/compose/foundation/gestures/Scrollable2DState;)V", "value", "isFlinging", "()Z", "latestScrollSource", "Landroidx/compose/ui/input/nestedscroll/NestedScrollSource;", "I", "outerStateScope", "Landroidx/compose/foundation/gestures/Scroll2DScope;", "nestedScrollScope", "androidx/compose/foundation/gestures/ScrollingLogic2D$nestedScrollScope$1", "Landroidx/compose/foundation/gestures/ScrollingLogic2D$nestedScrollScope$1;", "performScrollForOverscroll", "Lkotlin/Function1;", "Landroidx/compose/ui/geometry/Offset;", "performScroll", "delta", "source", "performScroll-3eAAhYA", "(Landroidx/compose/foundation/gestures/Scroll2DScope;JI)J", "shouldDispatchOverscroll", "offset", "shouldDispatchOverscroll-k-4lQ0M", "(J)Z", "velocity", "Landroidx/compose/ui/unit/Velocity;", "shouldDispatchOverscroll-TH1AsA0", "performRawScroll", ViewProps.SCROLL, "performRawScroll-MK-Hz9U", "(J)J", "dispatchRawDelta", "dispatchRawDelta-MK-Hz9U", "onScrollStopped", "", "initialVelocity", "onScrollStopped-sF-c-tU", "(JLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "doFlingAnimation", "available", "doFlingAnimation-QWom1Mo", "shouldScrollImmediately", "scrollPriority", "Landroidx/compose/foundation/MutatePriority;", "block", "Lkotlin/Function2;", "Landroidx/compose/foundation/gestures/NestedScrollScope;", "Lkotlin/coroutines/Continuation;", "", "Lkotlin/ExtensionFunctionType;", "(Landroidx/compose/foundation/MutatePriority;Lkotlin/jvm/functions/Function2;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "update", "foundation"}, k = 1, mv = {2, 0, 0}, xi = 48)
final class ScrollingLogic2D implements ScrollLogic {
    private FlingBehavior flingBehavior;
    private boolean isFlinging;
    private final Function0<Boolean> isScrollableNodeAttached;
    private NestedScrollDispatcher nestedScrollDispatcher;
    private OverscrollEffect overscrollEffect;
    private Scrollable2DState scrollableState;
    private int latestScrollSource = NestedScrollSource.INSTANCE.m8014getUserInputWNlRxjI();
    private Scroll2DScope outerStateScope = Scrollable2DKt.NoOpScrollScope;
    private final ScrollingLogic2D$nestedScrollScope$1 nestedScrollScope = new NestedScrollScope() { // from class: androidx.compose.foundation.gestures.ScrollingLogic2D$nestedScrollScope$1
        @Override // androidx.compose.foundation.gestures.NestedScrollScope
        /* JADX INFO: renamed from: scrollBy-OzD1aCk */
        public long mo901scrollByOzD1aCk(long offset, int source) {
            return this.this$0.m970performScroll3eAAhYA(this.this$0.outerStateScope, offset, source);
        }

        @Override // androidx.compose.foundation.gestures.NestedScrollScope
        /* JADX INFO: renamed from: scrollByWithOverscroll-OzD1aCk */
        public long mo902scrollByWithOverscrollOzD1aCk(long offset, int source) {
            this.this$0.latestScrollSource = source;
            OverscrollEffect overscrollEffect = this.this$0.overscrollEffect;
            if (overscrollEffect == null || !this.this$0.m973shouldDispatchOverscrollk4lQ0M(offset)) {
                return this.this$0.m970performScroll3eAAhYA(this.this$0.outerStateScope, offset, source);
            }
            return overscrollEffect.mo565applyToScrollRhakbz0(offset, this.this$0.latestScrollSource, this.this$0.performScrollForOverscroll);
        }
    };
    private final Function1<Offset, Offset> performScrollForOverscroll = new Function1() { // from class: androidx.compose.foundation.gestures.ScrollingLogic2D$$ExternalSyntheticLambda0
        @Override // kotlin.jvm.functions.Function1
        public final Object invoke(Object obj) {
            return ScrollingLogic2D.performScrollForOverscroll$lambda$0(this.f$0, (Offset) obj);
        }
    };

    /* JADX WARN: Type inference failed for: r1v4, types: [androidx.compose.foundation.gestures.ScrollingLogic2D$nestedScrollScope$1] */
    public ScrollingLogic2D(Scrollable2DState scrollable2DState, OverscrollEffect overscrollEffect, FlingBehavior flingBehavior, NestedScrollDispatcher nestedScrollDispatcher, Function0<Boolean> function0) {
        this.scrollableState = scrollable2DState;
        this.overscrollEffect = overscrollEffect;
        this.flingBehavior = flingBehavior;
        this.nestedScrollDispatcher = nestedScrollDispatcher;
        this.isScrollableNodeAttached = function0;
    }

    public final Scrollable2DState getScrollableState() {
        return this.scrollableState;
    }

    public final void setScrollableState(Scrollable2DState scrollable2DState) {
        this.scrollableState = scrollable2DState;
    }

    @Override // androidx.compose.foundation.gestures.ScrollLogic
    /* JADX INFO: renamed from: isFlinging, reason: from getter */
    public boolean getIsFlinging() {
        return this.isFlinging;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Offset performScrollForOverscroll$lambda$0(ScrollingLogic2D scrollingLogic2D, Offset offset) {
        return Offset.m6558boximpl(scrollingLogic2D.m970performScroll3eAAhYA(scrollingLogic2D.outerStateScope, offset.m6579unboximpl(), scrollingLogic2D.latestScrollSource));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: performScroll-3eAAhYA, reason: not valid java name */
    public final long m970performScroll3eAAhYA(Scroll2DScope scroll2DScope, long j, int i) {
        long jM7998dispatchPreScrollOzD1aCk = this.nestedScrollDispatcher.m7998dispatchPreScrollOzD1aCk(j, i);
        long jM6573minusMKHz9U = Offset.m6573minusMKHz9U(j, jM7998dispatchPreScrollOzD1aCk);
        long jMo805scrollByMKHz9U = scroll2DScope.mo805scrollByMKHz9U(jM6573minusMKHz9U);
        return Offset.m6574plusMKHz9U(Offset.m6574plusMKHz9U(jM7998dispatchPreScrollOzD1aCk, jMo805scrollByMKHz9U), this.nestedScrollDispatcher.m7996dispatchPostScrollDzOQY0M(jMo805scrollByMKHz9U, Offset.m6573minusMKHz9U(jM6573minusMKHz9U, jMo805scrollByMKHz9U), i));
    }

    /* JADX INFO: renamed from: shouldDispatchOverscroll-k-4lQ0M, reason: not valid java name */
    public final boolean m973shouldDispatchOverscrollk4lQ0M(long offset) {
        return this.scrollableState.mo803canScrollk4lQ0M(offset);
    }

    /* JADX INFO: renamed from: shouldDispatchOverscroll-TH1AsA0, reason: not valid java name */
    public final boolean m972shouldDispatchOverscrollTH1AsA0(long velocity) {
        Scrollable2DState scrollable2DState = this.scrollableState;
        float fM9925getXimpl = Velocity.m9925getXimpl(velocity);
        return scrollable2DState.mo803canScrollk4lQ0M(Offset.m6561constructorimpl((((long) Float.floatToRawIntBits(Velocity.m9926getYimpl(velocity))) & 4294967295L) | (Float.floatToRawIntBits(fM9925getXimpl) << 32)));
    }

    @Override // androidx.compose.foundation.gestures.ScrollLogic
    /* JADX INFO: renamed from: performRawScroll-MK-Hz9U */
    public long mo933performRawScrollMKHz9U(long scroll) {
        if (this.scrollableState.isScrollInProgress()) {
            return Offset.INSTANCE.m6585getZeroF1C5BW0();
        }
        return m969dispatchRawDeltaMKHz9U(scroll);
    }

    /* JADX INFO: renamed from: dispatchRawDelta-MK-Hz9U, reason: not valid java name */
    private final long m969dispatchRawDeltaMKHz9U(long scroll) {
        return this.scrollableState.mo804dispatchRawDeltaMKHz9U(scroll);
    }

    /* JADX INFO: renamed from: onScrollStopped-sF-c-tU, reason: not valid java name */
    public final Object m971onScrollStoppedsFctU(long j, Continuation<? super Unit> continuation) {
        ScrollingLogic2D$onScrollStopped$performFling$1 scrollingLogic2D$onScrollStopped$performFling$1 = new ScrollingLogic2D$onScrollStopped$performFling$1(this, null);
        OverscrollEffect overscrollEffect = this.overscrollEffect;
        if (overscrollEffect != null && m972shouldDispatchOverscrollTH1AsA0(j)) {
            Object objMo564applyToFlingBMRW4eQ = overscrollEffect.mo564applyToFlingBMRW4eQ(j, scrollingLogic2D$onScrollStopped$performFling$1, continuation);
            return objMo564applyToFlingBMRW4eQ == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objMo564applyToFlingBMRW4eQ : Unit.INSTANCE;
        }
        Object objInvoke = scrollingLogic2D$onScrollStopped$performFling$1.invoke(Velocity.m9916boximpl(j), continuation);
        return objInvoke == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objInvoke : Unit.INSTANCE;
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    @Override // androidx.compose.foundation.gestures.ScrollLogic
    /* JADX INFO: renamed from: doFlingAnimation-QWom1Mo */
    public Object mo932doFlingAnimationQWom1Mo(long j, Continuation<? super Velocity> continuation) throws Throwable {
        ScrollingLogic2D$doFlingAnimation$1 scrollingLogic2D$doFlingAnimation$1;
        ScrollingLogic2D scrollingLogic2D;
        Throwable th;
        Ref.LongRef longRef;
        if (continuation instanceof ScrollingLogic2D$doFlingAnimation$1) {
            scrollingLogic2D$doFlingAnimation$1 = (ScrollingLogic2D$doFlingAnimation$1) continuation;
            if ((scrollingLogic2D$doFlingAnimation$1.label & Integer.MIN_VALUE) != 0) {
                scrollingLogic2D$doFlingAnimation$1.label -= Integer.MIN_VALUE;
            } else {
                scrollingLogic2D$doFlingAnimation$1 = new ScrollingLogic2D$doFlingAnimation$1(this, continuation);
            }
        } else {
            scrollingLogic2D$doFlingAnimation$1 = new ScrollingLogic2D$doFlingAnimation$1(this, continuation);
        }
        Object obj = scrollingLogic2D$doFlingAnimation$1.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = scrollingLogic2D$doFlingAnimation$1.label;
        if (i != 0) {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            longRef = (Ref.LongRef) scrollingLogic2D$doFlingAnimation$1.L$0;
            try {
                ResultKt.throwOnFailure(obj);
                scrollingLogic2D = this;
                scrollingLogic2D.isFlinging = false;
                return Velocity.m9916boximpl(longRef.element);
            } catch (Throwable th2) {
                th = th2;
                scrollingLogic2D = this;
                scrollingLogic2D.isFlinging = false;
                throw th;
            }
        }
        ResultKt.throwOnFailure(obj);
        Ref.LongRef longRef2 = new Ref.LongRef();
        longRef2.element = j;
        this.isFlinging = true;
        try {
            MutatePriority mutatePriority = MutatePriority.Default;
            scrollingLogic2D = this;
            try {
                ScrollingLogic2D$doFlingAnimation$2 scrollingLogic2D$doFlingAnimation$2 = new ScrollingLogic2D$doFlingAnimation$2(scrollingLogic2D, j, longRef2, null);
                scrollingLogic2D$doFlingAnimation$1.L$0 = longRef2;
                scrollingLogic2D$doFlingAnimation$1.label = 1;
                if (scrollingLogic2D.scroll(mutatePriority, scrollingLogic2D$doFlingAnimation$2, scrollingLogic2D$doFlingAnimation$1) == coroutine_suspended) {
                    return coroutine_suspended;
                }
                longRef = longRef2;
                scrollingLogic2D.isFlinging = false;
                return Velocity.m9916boximpl(longRef.element);
            } catch (Throwable th3) {
                th = th3;
                th = th;
                scrollingLogic2D.isFlinging = false;
                throw th;
            }
        } catch (Throwable th4) {
            th = th4;
            scrollingLogic2D = this;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final long doFlingAnimation_QWom1Mo$toDecomposedOffset(float f, long j) {
        if (!Float.isNaN(Scrollable2DKt.m937getAngleTH1AsA0(j))) {
            return Offset.m6561constructorimpl((((long) Float.floatToRawIntBits(Math.abs(((float) Math.cos(Scrollable2DKt.m937getAngleTH1AsA0(j))) * f) * Math.signum(Velocity.m9925getXimpl(j)))) << 32) | (((long) Float.floatToRawIntBits(Math.abs(((float) Math.sin(Scrollable2DKt.m937getAngleTH1AsA0(j))) * f) * Math.signum(Velocity.m9926getYimpl(j)))) & 4294967295L));
        }
        return Offset.m6561constructorimpl((((long) Float.floatToRawIntBits(0.0f)) << 32) | (((long) Float.floatToRawIntBits(f)) & 4294967295L));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final long doFlingAnimation_QWom1Mo$toDecomposedVelocity(float f, long j) {
        if (Float.isNaN(Scrollable2DKt.m937getAngleTH1AsA0(j))) {
            return VelocityKt.Velocity(0.0f, f);
        }
        return VelocityKt.Velocity(Math.abs(((float) Math.cos(Scrollable2DKt.m937getAngleTH1AsA0(j))) * f) * Math.signum(Velocity.m9925getXimpl(j)), Math.abs(((float) Math.sin(Scrollable2DKt.m937getAngleTH1AsA0(j))) * f) * Math.signum(Velocity.m9926getYimpl(j)));
    }

    public final boolean shouldScrollImmediately() {
        if (this.scrollableState.isScrollInProgress()) {
            return true;
        }
        OverscrollEffect overscrollEffect = this.overscrollEffect;
        return overscrollEffect != null ? overscrollEffect.isInProgress() : false;
    }

    public static /* synthetic */ Object scroll$default(ScrollingLogic2D scrollingLogic2D, MutatePriority mutatePriority, Function2 function2, Continuation continuation, int i, Object obj) {
        if ((i & 1) != 0) {
            mutatePriority = MutatePriority.Default;
        }
        return scrollingLogic2D.scroll(mutatePriority, function2, continuation);
    }

    /* JADX INFO: renamed from: androidx.compose.foundation.gestures.ScrollingLogic2D$scroll$2, reason: invalid class name */
    /* JADX INFO: compiled from: Scrollable2D.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Landroidx/compose/foundation/gestures/Scroll2DScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
    @DebugMetadata(c = "androidx.compose.foundation.gestures.ScrollingLogic2D$scroll$2", f = "Scrollable2D.kt", i = {}, l = {479}, m = "invokeSuspend", n = {}, s = {}, v = 1)
    static final class AnonymousClass2 extends SuspendLambda implements Function2<Scroll2DScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ Function2<NestedScrollScope, Continuation<? super Unit>, Object> $block;
        private /* synthetic */ Object L$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        AnonymousClass2(Function2<? super NestedScrollScope, ? super Continuation<? super Unit>, ? extends Object> function2, Continuation<? super AnonymousClass2> continuation) {
            super(2, continuation);
            this.$block = function2;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            AnonymousClass2 anonymousClass2 = ScrollingLogic2D.this.new AnonymousClass2(this.$block, continuation);
            anonymousClass2.L$0 = obj;
            return anonymousClass2;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(Scroll2DScope scroll2DScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass2) create(scroll2DScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                ScrollingLogic2D.this.outerStateScope = (Scroll2DScope) this.L$0;
                Function2<NestedScrollScope, Continuation<? super Unit>, Object> function2 = this.$block;
                ScrollingLogic2D$nestedScrollScope$1 scrollingLogic2D$nestedScrollScope$1 = ScrollingLogic2D.this.nestedScrollScope;
                this.label = 1;
                if (function2.invoke(scrollingLogic2D$nestedScrollScope$1, this) == coroutine_suspended) {
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
    }

    public final Object scroll(MutatePriority mutatePriority, Function2<? super NestedScrollScope, ? super Continuation<? super Unit>, ? extends Object> function2, Continuation<? super Unit> continuation) {
        Object objScroll = this.scrollableState.scroll(mutatePriority, new AnonymousClass2(function2, null), continuation);
        return objScroll == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objScroll : Unit.INSTANCE;
    }

    public final boolean update(Scrollable2DState scrollableState, OverscrollEffect overscrollEffect, FlingBehavior flingBehavior, NestedScrollDispatcher nestedScrollDispatcher) {
        boolean z;
        if (Intrinsics.areEqual(this.scrollableState, scrollableState)) {
            z = false;
        } else {
            this.scrollableState = scrollableState;
            z = true;
        }
        this.overscrollEffect = overscrollEffect;
        this.flingBehavior = flingBehavior;
        this.nestedScrollDispatcher = nestedScrollDispatcher;
        return z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final float doFlingAnimation_QWom1Mo$toMagnitudeFloat(long j) {
        double d = 2;
        return (float) Math.sqrt(((float) Math.pow(Float.intBitsToFloat((int) (j >> 32)), d)) + ((float) Math.pow(Float.intBitsToFloat((int) (j & 4294967295L)), d)));
    }
}
