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

/* JADX INFO: compiled from: Scrollable.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\u0093\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001:\b\u0001\u0018\u00002\u00020\u0001BO\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\u0006\u0010\f\u001a\u00020\r\u0012\u0006\u0010\u000e\u001a\u00020\u000f\u0012\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u000b0\u0011¢\u0006\u0004\b\u0012\u0010\u0013J\u0011\u0010\u001b\u001a\u00020\u001c*\u00020\u001d¢\u0006\u0004\b\u001e\u0010\u001fJ\u0011\u0010 \u001a\u00020\u001c*\u00020\u001c¢\u0006\u0004\b!\u0010\"J\u0011\u0010#\u001a\u00020\u001d*\u00020\u001c¢\u0006\u0004\b$\u0010%J\u0011\u0010&\u001a\u00020\u001d*\u00020\u001c¢\u0006\u0004\b'\u0010%J\u0011\u0010(\u001a\u00020)*\u00020\u001d¢\u0006\u0004\b*\u0010\u001fJ\u0013\u0010#\u001a\u00020\u001d*\u00020)H\u0002¢\u0006\u0004\b+\u0010%J\u0013\u0010,\u001a\u00020)*\u00020)H\u0002¢\u0006\u0004\b-\u0010\"J\u001b\u0010.\u001a\u00020)*\u00020)2\u0006\u0010/\u001a\u00020\u001dH\u0002¢\u0006\u0004\b0\u00101J\n\u00102\u001a\u00020\u001d*\u00020\u001dJ\u0011\u00102\u001a\u00020\u001c*\u00020\u001c¢\u0006\u0004\b3\u0010\"J#\u0010>\u001a\u00020\u001c*\u0002082\u0006\u0010?\u001a\u00020\u001c2\u0006\u0010@\u001a\u000205H\u0002¢\u0006\u0004\bA\u0010BJ\u0017\u0010E\u001a\u00020\u001c2\u0006\u0010F\u001a\u00020\u001cH\u0016¢\u0006\u0004\bG\u0010\"J\u0017\u0010H\u001a\u00020\u001c2\u0006\u0010F\u001a\u00020\u001cH\u0002¢\u0006\u0004\bI\u0010\"J \u0010J\u001a\u00020K2\u0006\u0010L\u001a\u00020)2\u0006\u0010M\u001a\u00020\u000bH\u0086@¢\u0006\u0004\bN\u0010OJ\u0018\u0010P\u001a\u00020)2\u0006\u0010Q\u001a\u00020)H\u0096@¢\u0006\u0004\bR\u0010SJ\u0006\u0010T\u001a\u00020\u000bJA\u0010F\u001a\u00020K2\b\b\u0002\u0010U\u001a\u00020V2'\u0010W\u001a#\b\u0001\u0012\u0004\u0012\u00020Y\u0012\n\u0012\b\u0012\u0004\u0012\u00020K0Z\u0012\u0006\u0012\u0004\u0018\u00010[0X¢\u0006\u0002\b\\H\u0086@¢\u0006\u0002\u0010]J8\u0010.\u001a\u00020\u000b2\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\t2\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\f\u001a\u00020\rJ\u0006\u0010^\u001a\u00020\u000bR\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u000b0\u0011X\u0082\u0004¢\u0006\u0002\n\u0000R\u001e\u0010\u0019\u001a\u00020\u000b2\u0006\u0010\u0018\u001a\u00020\u000b@RX\u0096\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001aR\u0010\u00104\u001a\u000205X\u0082\u000e¢\u0006\u0004\n\u0002\u00106R\u000e\u00107\u001a\u000208X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u00109\u001a\u00020:X\u0082\u0004¢\u0006\u0004\n\u0002\u0010;R\u001a\u0010<\u001a\u000e\u0012\u0004\u0012\u00020\u001c\u0012\u0004\u0012\u00020\u001c0=X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010C\u001a\u00020\u000b8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\bD\u0010\u001a¨\u0006_"}, d2 = {"Landroidx/compose/foundation/gestures/ScrollingLogic;", "Landroidx/compose/foundation/gestures/ScrollLogic;", "scrollableState", "Landroidx/compose/foundation/gestures/ScrollableState;", "overscrollEffect", "Landroidx/compose/foundation/OverscrollEffect;", "flingBehavior", "Landroidx/compose/foundation/gestures/FlingBehavior;", "orientation", "Landroidx/compose/foundation/gestures/Orientation;", "reverseDirection", "", "nestedScrollDispatcher", "Landroidx/compose/ui/input/nestedscroll/NestedScrollDispatcher;", "onScrollChangedDispatcher", "Landroidx/compose/foundation/gestures/OnScrollChangedDispatcher;", "isScrollableNodeAttached", "Lkotlin/Function0;", "<init>", "(Landroidx/compose/foundation/gestures/ScrollableState;Landroidx/compose/foundation/OverscrollEffect;Landroidx/compose/foundation/gestures/FlingBehavior;Landroidx/compose/foundation/gestures/Orientation;ZLandroidx/compose/ui/input/nestedscroll/NestedScrollDispatcher;Landroidx/compose/foundation/gestures/OnScrollChangedDispatcher;Lkotlin/jvm/functions/Function0;)V", "getScrollableState", "()Landroidx/compose/foundation/gestures/ScrollableState;", "setScrollableState", "(Landroidx/compose/foundation/gestures/ScrollableState;)V", "value", "isFlinging", "()Z", "toOffset", "Landroidx/compose/ui/geometry/Offset;", "", "toOffset-tuRUvjQ", "(F)J", "singleAxisOffset", "singleAxisOffset-MK-Hz9U", "(J)J", "toFloat", "toFloat-k-4lQ0M", "(J)F", "toSingleAxisDeltaFromAngle", "toSingleAxisDeltaFromAngle-k-4lQ0M", "toVelocity", "Landroidx/compose/ui/unit/Velocity;", "toVelocity-adjELrA", "toFloat-TH1AsA0", "singleAxisVelocity", "singleAxisVelocity-AH228Gc", "update", "newValue", "update-QWom1Mo", "(JF)J", "reverseIfNeeded", "reverseIfNeeded-MK-Hz9U", "latestScrollSource", "Landroidx/compose/ui/input/nestedscroll/NestedScrollSource;", "I", "outerStateScope", "Landroidx/compose/foundation/gestures/ScrollScope;", "nestedScrollScope", "androidx/compose/foundation/gestures/ScrollingLogic$nestedScrollScope$1", "Landroidx/compose/foundation/gestures/ScrollingLogic$nestedScrollScope$1;", "performScrollForOverscroll", "Lkotlin/Function1;", "performScroll", "delta", "source", "performScroll-3eAAhYA", "(Landroidx/compose/foundation/gestures/ScrollScope;JI)J", "shouldDispatchOverscroll", "getShouldDispatchOverscroll", "performRawScroll", ViewProps.SCROLL, "performRawScroll-MK-Hz9U", "dispatchRawDelta", "dispatchRawDelta-MK-Hz9U", "onScrollStopped", "", "initialVelocity", "isMouseWheel", "onScrollStopped-BMRW4eQ", "(JZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "doFlingAnimation", "available", "doFlingAnimation-QWom1Mo", "(JLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "shouldScrollImmediately", "scrollPriority", "Landroidx/compose/foundation/MutatePriority;", "block", "Lkotlin/Function2;", "Landroidx/compose/foundation/gestures/NestedScrollScope;", "Lkotlin/coroutines/Continuation;", "", "Lkotlin/ExtensionFunctionType;", "(Landroidx/compose/foundation/MutatePriority;Lkotlin/jvm/functions/Function2;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "isVertical", "foundation"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class ScrollingLogic implements ScrollLogic {
    public static final int $stable = 8;
    private FlingBehavior flingBehavior;
    private boolean isFlinging;
    private final Function0<Boolean> isScrollableNodeAttached;
    private NestedScrollDispatcher nestedScrollDispatcher;
    private OnScrollChangedDispatcher onScrollChangedDispatcher;
    private Orientation orientation;
    private OverscrollEffect overscrollEffect;
    private boolean reverseDirection;
    private ScrollableState scrollableState;
    private int latestScrollSource = NestedScrollSource.INSTANCE.m8014getUserInputWNlRxjI();
    private ScrollScope outerStateScope = ScrollableKt.NoOpScrollScope;
    private final ScrollingLogic$nestedScrollScope$1 nestedScrollScope = new NestedScrollScope() { // from class: androidx.compose.foundation.gestures.ScrollingLogic$nestedScrollScope$1
        @Override // androidx.compose.foundation.gestures.NestedScrollScope
        /* JADX INFO: renamed from: scrollBy-OzD1aCk */
        public long mo901scrollByOzD1aCk(long offset, int source) {
            return this.this$0.m955performScroll3eAAhYA(this.this$0.outerStateScope, offset, source);
        }

        @Override // androidx.compose.foundation.gestures.NestedScrollScope
        /* JADX INFO: renamed from: scrollByWithOverscroll-OzD1aCk */
        public long mo902scrollByWithOverscrollOzD1aCk(long offset, int source) {
            this.this$0.latestScrollSource = source;
            OverscrollEffect overscrollEffect = this.this$0.overscrollEffect;
            if (overscrollEffect == null || !this.this$0.getShouldDispatchOverscroll()) {
                return this.this$0.m955performScroll3eAAhYA(this.this$0.outerStateScope, offset, source);
            }
            return overscrollEffect.mo565applyToScrollRhakbz0(offset, this.this$0.latestScrollSource, this.this$0.performScrollForOverscroll);
        }
    };
    private final Function1<Offset, Offset> performScrollForOverscroll = new Function1() { // from class: androidx.compose.foundation.gestures.ScrollingLogic$$ExternalSyntheticLambda0
        @Override // kotlin.jvm.functions.Function1
        public final Object invoke(Object obj) {
            return ScrollingLogic.performScrollForOverscroll$lambda$0(this.f$0, (Offset) obj);
        }
    };

    /* JADX WARN: Type inference failed for: r1v4, types: [androidx.compose.foundation.gestures.ScrollingLogic$nestedScrollScope$1] */
    public ScrollingLogic(ScrollableState scrollableState, OverscrollEffect overscrollEffect, FlingBehavior flingBehavior, Orientation orientation, boolean z, NestedScrollDispatcher nestedScrollDispatcher, OnScrollChangedDispatcher onScrollChangedDispatcher, Function0<Boolean> function0) {
        this.scrollableState = scrollableState;
        this.overscrollEffect = overscrollEffect;
        this.flingBehavior = flingBehavior;
        this.orientation = orientation;
        this.reverseDirection = z;
        this.nestedScrollDispatcher = nestedScrollDispatcher;
        this.onScrollChangedDispatcher = onScrollChangedDispatcher;
        this.isScrollableNodeAttached = function0;
    }

    public final ScrollableState getScrollableState() {
        return this.scrollableState;
    }

    public final void setScrollableState(ScrollableState scrollableState) {
        this.scrollableState = scrollableState;
    }

    @Override // androidx.compose.foundation.gestures.ScrollLogic
    /* JADX INFO: renamed from: isFlinging, reason: from getter */
    public boolean getIsFlinging() {
        return this.isFlinging;
    }

    /* JADX INFO: renamed from: toOffset-tuRUvjQ, reason: not valid java name */
    public final long m963toOffsettuRUvjQ(float f) {
        if (f == 0.0f) {
            return Offset.INSTANCE.m6585getZeroF1C5BW0();
        }
        if (this.orientation == Orientation.Horizontal) {
            return Offset.m6561constructorimpl((((long) Float.floatToRawIntBits(f)) << 32) | (((long) Float.floatToRawIntBits(0.0f)) & 4294967295L));
        }
        return Offset.m6561constructorimpl((((long) Float.floatToRawIntBits(f)) & 4294967295L) | (Float.floatToRawIntBits(0.0f) << 32));
    }

    /* JADX INFO: renamed from: singleAxisOffset-MK-Hz9U, reason: not valid java name */
    public final long m961singleAxisOffsetMKHz9U(long j) {
        return this.orientation == Orientation.Horizontal ? Offset.m6563copydBAh8RU$default(j, 0.0f, 0.0f, 1, null) : Offset.m6563copydBAh8RU$default(j, 0.0f, 0.0f, 2, null);
    }

    /* JADX INFO: renamed from: toFloat-k-4lQ0M, reason: not valid java name */
    public final float m962toFloatk4lQ0M(long j) {
        return Float.intBitsToFloat((int) (this.orientation == Orientation.Horizontal ? j >> 32 : j & 4294967295L));
    }

    /* JADX INFO: renamed from: toVelocity-adjELrA, reason: not valid java name */
    public final long m965toVelocityadjELrA(float f) {
        if (f == 0.0f) {
            return Velocity.INSTANCE.m9936getZero9UxMQ8M();
        }
        return this.orientation == Orientation.Horizontal ? VelocityKt.Velocity(f, 0.0f) : VelocityKt.Velocity(0.0f, f);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: toFloat-TH1AsA0, reason: not valid java name */
    public final float m957toFloatTH1AsA0(long j) {
        return this.orientation == Orientation.Horizontal ? Velocity.m9925getXimpl(j) : Velocity.m9926getYimpl(j);
    }

    /* JADX INFO: renamed from: singleAxisVelocity-AH228Gc, reason: not valid java name */
    private final long m956singleAxisVelocityAH228Gc(long j) {
        return this.orientation == Orientation.Horizontal ? Velocity.m9921copyOhffZ5M$default(j, 0.0f, 0.0f, 1, null) : Velocity.m9921copyOhffZ5M$default(j, 0.0f, 0.0f, 2, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: update-QWom1Mo, reason: not valid java name */
    public final long m958updateQWom1Mo(long j, float f) {
        return this.orientation == Orientation.Horizontal ? Velocity.m9921copyOhffZ5M$default(j, f, 0.0f, 2, null) : Velocity.m9921copyOhffZ5M$default(j, 0.0f, f, 1, null);
    }

    public final float reverseIfNeeded(float f) {
        return this.reverseDirection ? f * (-1) : f;
    }

    /* JADX INFO: renamed from: reverseIfNeeded-MK-Hz9U, reason: not valid java name */
    public final long m960reverseIfNeededMKHz9U(long j) {
        return this.reverseDirection ? Offset.m6576timestuRUvjQ(j, -1.0f) : j;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Offset performScrollForOverscroll$lambda$0(ScrollingLogic scrollingLogic, Offset offset) {
        return Offset.m6558boximpl(scrollingLogic.m955performScroll3eAAhYA(scrollingLogic.outerStateScope, offset.m6579unboximpl(), scrollingLogic.latestScrollSource));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: performScroll-3eAAhYA, reason: not valid java name */
    public final long m955performScroll3eAAhYA(ScrollScope scrollScope, long j, int i) {
        long jM7998dispatchPreScrollOzD1aCk = this.nestedScrollDispatcher.m7998dispatchPreScrollOzD1aCk(j, i);
        long jM6573minusMKHz9U = Offset.m6573minusMKHz9U(j, jM7998dispatchPreScrollOzD1aCk);
        long jM960reverseIfNeededMKHz9U = m960reverseIfNeededMKHz9U(m963toOffsettuRUvjQ(scrollScope.scrollBy(m962toFloatk4lQ0M(m960reverseIfNeededMKHz9U(m961singleAxisOffsetMKHz9U(jM6573minusMKHz9U))))));
        this.onScrollChangedDispatcher.mo904dispatchScrollDeltaInfok4lQ0M(jM960reverseIfNeededMKHz9U);
        return Offset.m6574plusMKHz9U(Offset.m6574plusMKHz9U(jM7998dispatchPreScrollOzD1aCk, jM960reverseIfNeededMKHz9U), this.nestedScrollDispatcher.m7996dispatchPostScrollDzOQY0M(jM960reverseIfNeededMKHz9U, Offset.m6573minusMKHz9U(jM6573minusMKHz9U, jM960reverseIfNeededMKHz9U), i));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean getShouldDispatchOverscroll() {
        return this.scrollableState.getCanScrollForward() || this.scrollableState.getCanScrollBackward();
    }

    @Override // androidx.compose.foundation.gestures.ScrollLogic
    /* JADX INFO: renamed from: performRawScroll-MK-Hz9U */
    public long mo933performRawScrollMKHz9U(long scroll) {
        if (this.scrollableState.isScrollInProgress()) {
            return Offset.INSTANCE.m6585getZeroF1C5BW0();
        }
        return m954dispatchRawDeltaMKHz9U(scroll);
    }

    /* JADX INFO: renamed from: dispatchRawDelta-MK-Hz9U, reason: not valid java name */
    private final long m954dispatchRawDeltaMKHz9U(long scroll) {
        return m963toOffsettuRUvjQ(reverseIfNeeded(this.scrollableState.dispatchRawDelta(reverseIfNeeded(m962toFloatk4lQ0M(scroll)))));
    }

    /* JADX INFO: renamed from: onScrollStopped-BMRW4eQ, reason: not valid java name */
    public final Object m959onScrollStoppedBMRW4eQ(long j, boolean z, Continuation<? super Unit> continuation) {
        if (z && !ScrollableKt.getShouldBeTriggeredByMouseWheel(this.flingBehavior)) {
            return Unit.INSTANCE;
        }
        long jM956singleAxisVelocityAH228Gc = m956singleAxisVelocityAH228Gc(j);
        ScrollingLogic$onScrollStopped$performFling$1 scrollingLogic$onScrollStopped$performFling$1 = new ScrollingLogic$onScrollStopped$performFling$1(this, null);
        OverscrollEffect overscrollEffect = this.overscrollEffect;
        if (overscrollEffect != null && getShouldDispatchOverscroll()) {
            Object objMo564applyToFlingBMRW4eQ = overscrollEffect.mo564applyToFlingBMRW4eQ(jM956singleAxisVelocityAH228Gc, scrollingLogic$onScrollStopped$performFling$1, continuation);
            return objMo564applyToFlingBMRW4eQ == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objMo564applyToFlingBMRW4eQ : Unit.INSTANCE;
        }
        Object objInvoke = scrollingLogic$onScrollStopped$performFling$1.invoke(Velocity.m9916boximpl(jM956singleAxisVelocityAH228Gc), continuation);
        return objInvoke == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objInvoke : Unit.INSTANCE;
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    @Override // androidx.compose.foundation.gestures.ScrollLogic
    /* JADX INFO: renamed from: doFlingAnimation-QWom1Mo */
    public Object mo932doFlingAnimationQWom1Mo(long j, Continuation<? super Velocity> continuation) throws Throwable {
        ScrollingLogic$doFlingAnimation$1 scrollingLogic$doFlingAnimation$1;
        ScrollingLogic scrollingLogic;
        Throwable th;
        Ref.LongRef longRef;
        if (continuation instanceof ScrollingLogic$doFlingAnimation$1) {
            scrollingLogic$doFlingAnimation$1 = (ScrollingLogic$doFlingAnimation$1) continuation;
            if ((scrollingLogic$doFlingAnimation$1.label & Integer.MIN_VALUE) != 0) {
                scrollingLogic$doFlingAnimation$1.label -= Integer.MIN_VALUE;
            } else {
                scrollingLogic$doFlingAnimation$1 = new ScrollingLogic$doFlingAnimation$1(this, continuation);
            }
        } else {
            scrollingLogic$doFlingAnimation$1 = new ScrollingLogic$doFlingAnimation$1(this, continuation);
        }
        Object obj = scrollingLogic$doFlingAnimation$1.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = scrollingLogic$doFlingAnimation$1.label;
        if (i != 0) {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            longRef = (Ref.LongRef) scrollingLogic$doFlingAnimation$1.L$0;
            try {
                ResultKt.throwOnFailure(obj);
                scrollingLogic = this;
                scrollingLogic.isFlinging = false;
                return Velocity.m9916boximpl(longRef.element);
            } catch (Throwable th2) {
                th = th2;
                scrollingLogic = this;
                scrollingLogic.isFlinging = false;
                throw th;
            }
        }
        ResultKt.throwOnFailure(obj);
        Ref.LongRef longRef2 = new Ref.LongRef();
        longRef2.element = j;
        this.isFlinging = true;
        try {
            MutatePriority mutatePriority = MutatePriority.Default;
            scrollingLogic = this;
            try {
                ScrollingLogic$doFlingAnimation$2 scrollingLogic$doFlingAnimation$2 = new ScrollingLogic$doFlingAnimation$2(scrollingLogic, longRef2, j, null);
                scrollingLogic$doFlingAnimation$1.L$0 = longRef2;
                scrollingLogic$doFlingAnimation$1.label = 1;
                if (scrollingLogic.scroll(mutatePriority, scrollingLogic$doFlingAnimation$2, scrollingLogic$doFlingAnimation$1) == coroutine_suspended) {
                    return coroutine_suspended;
                }
                longRef = longRef2;
                scrollingLogic.isFlinging = false;
                return Velocity.m9916boximpl(longRef.element);
            } catch (Throwable th3) {
                th = th3;
                th = th;
                scrollingLogic.isFlinging = false;
                throw th;
            }
        } catch (Throwable th4) {
            th = th4;
            scrollingLogic = this;
        }
    }

    public final boolean shouldScrollImmediately() {
        if (this.scrollableState.isScrollInProgress()) {
            return true;
        }
        OverscrollEffect overscrollEffect = this.overscrollEffect;
        return overscrollEffect != null ? overscrollEffect.isInProgress() : false;
    }

    public static /* synthetic */ Object scroll$default(ScrollingLogic scrollingLogic, MutatePriority mutatePriority, Function2 function2, Continuation continuation, int i, Object obj) {
        if ((i & 1) != 0) {
            mutatePriority = MutatePriority.Default;
        }
        return scrollingLogic.scroll(mutatePriority, function2, continuation);
    }

    /* JADX INFO: renamed from: androidx.compose.foundation.gestures.ScrollingLogic$scroll$2, reason: invalid class name */
    /* JADX INFO: compiled from: Scrollable.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Landroidx/compose/foundation/gestures/ScrollScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
    @DebugMetadata(c = "androidx.compose.foundation.gestures.ScrollingLogic$scroll$2", f = "Scrollable.kt", i = {}, l = {914}, m = "invokeSuspend", n = {}, s = {}, v = 1)
    static final class AnonymousClass2 extends SuspendLambda implements Function2<ScrollScope, Continuation<? super Unit>, Object> {
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
            AnonymousClass2 anonymousClass2 = ScrollingLogic.this.new AnonymousClass2(this.$block, continuation);
            anonymousClass2.L$0 = obj;
            return anonymousClass2;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(ScrollScope scrollScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass2) create(scrollScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                ScrollingLogic.this.outerStateScope = (ScrollScope) this.L$0;
                Function2<NestedScrollScope, Continuation<? super Unit>, Object> function2 = this.$block;
                ScrollingLogic$nestedScrollScope$1 scrollingLogic$nestedScrollScope$1 = ScrollingLogic.this.nestedScrollScope;
                this.label = 1;
                if (function2.invoke(scrollingLogic$nestedScrollScope$1, this) == coroutine_suspended) {
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

    public final boolean update(ScrollableState scrollableState, Orientation orientation, OverscrollEffect overscrollEffect, boolean reverseDirection, FlingBehavior flingBehavior, NestedScrollDispatcher nestedScrollDispatcher) {
        boolean z;
        boolean z2 = true;
        if (Intrinsics.areEqual(this.scrollableState, scrollableState)) {
            z = false;
        } else {
            this.scrollableState = scrollableState;
            z = true;
        }
        this.overscrollEffect = overscrollEffect;
        if (this.orientation != orientation) {
            this.orientation = orientation;
            z = true;
        }
        if (this.reverseDirection != reverseDirection) {
            this.reverseDirection = reverseDirection;
        } else {
            z2 = z;
        }
        this.flingBehavior = flingBehavior;
        this.nestedScrollDispatcher = nestedScrollDispatcher;
        return z2;
    }

    public final boolean isVertical() {
        return this.orientation == Orientation.Vertical;
    }

    /* JADX INFO: renamed from: toSingleAxisDeltaFromAngle-k-4lQ0M, reason: not valid java name */
    public final float m964toSingleAxisDeltaFromAnglek4lQ0M(long j) {
        int i = (int) (4294967295L & j);
        int i2 = (int) (j >> 32);
        if (((float) Math.atan2(Math.abs(Float.intBitsToFloat(i)), Math.abs(Float.intBitsToFloat(i2)))) >= 0.7853981633974483d) {
            if (this.orientation == Orientation.Vertical) {
                return Float.intBitsToFloat(i);
            }
            return 0.0f;
        }
        if (this.orientation == Orientation.Horizontal) {
            return Float.intBitsToFloat(i2);
        }
        return 0.0f;
    }
}
