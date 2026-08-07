package androidx.compose.material3;

import androidx.compose.animation.core.AnimationScope;
import androidx.compose.animation.core.AnimationSpec;
import androidx.compose.animation.core.AnimationState;
import androidx.compose.animation.core.AnimationStateKt;
import androidx.compose.animation.core.DecayAnimationSpec;
import androidx.compose.animation.core.SuspendAnimationKt;
import androidx.compose.foundation.gestures.DraggableKt;
import androidx.compose.foundation.gestures.Orientation;
import androidx.compose.runtime.MutableFloatState;
import androidx.compose.runtime.PrimitiveSnapshotStateKt;
import androidx.compose.runtime.saveable.ListSaverKt;
import androidx.compose.runtime.saveable.Saver;
import androidx.compose.runtime.saveable.SaverScope;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.draw.ClipKt;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.input.nestedscroll.NestedScrollConnection;
import androidx.compose.ui.layout.LayoutModifierKt;
import androidx.compose.ui.layout.Measurable;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.layout.OnRemeasuredModifierKt;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.IntSize;
import androidx.compose.ui.unit.Velocity;
import androidx.compose.ui.unit.VelocityKt;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.math.MathKt;
import kotlin.ranges.RangesKt;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: compiled from: SearchBar.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b%\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0003\u0018\u0000 =2\u00020\u0001:\u0001=BQ\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007\u0012\u0006\u0010\t\u001a\u00020\b\u0012\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00030\u000b\u0012\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00030\r¢\u0006\u0004\b\u000e\u0010\u000fJ\f\u00102\u001a\u000203*\u000203H\u0016J\u0018\u00108\u001a\u0002092\u0006\u0010:\u001a\u00020\u0003H\u0082@¢\u0006\u0004\b;\u0010<R\u0017\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\t\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0017\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00030\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0017\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00030\r¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R+\u0010\u0019\u001a\u00020\u00032\u0006\u0010\u0018\u001a\u00020\u00038B@BX\u0082\u008e\u0002¢\u0006\u0012\n\u0004\b\u001e\u0010\u001f\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR+\u0010 \u001a\u00020\u00032\u0006\u0010\u0018\u001a\u00020\u00038B@BX\u0082\u008e\u0002¢\u0006\u0012\n\u0004\b#\u0010\u001f\u001a\u0004\b!\u0010\u001b\"\u0004\b\"\u0010\u001dR+\u0010$\u001a\u00020\u00032\u0006\u0010\u0018\u001a\u00020\u00038B@BX\u0082\u008e\u0002¢\u0006\u0012\n\u0004\b'\u0010\u001f\u001a\u0004\b%\u0010\u001b\"\u0004\b&\u0010\u001dR$\u0010)\u001a\u00020\u00032\u0006\u0010(\u001a\u00020\u00038W@VX\u0096\u000e¢\u0006\f\u001a\u0004\b*\u0010\u001b\"\u0004\b+\u0010\u001dR$\u0010,\u001a\u00020\u00032\u0006\u0010(\u001a\u00020\u00038V@VX\u0096\u000e¢\u0006\f\u001a\u0004\b-\u0010\u001b\"\u0004\b.\u0010\u001dR$\u0010/\u001a\u00020\u00032\u0006\u0010(\u001a\u00020\u00038W@VX\u0096\u000e¢\u0006\f\u001a\u0004\b0\u0010\u001b\"\u0004\b1\u0010\u001dR\u0014\u00104\u001a\u000205X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b6\u00107¨\u0006>"}, d2 = {"Landroidx/compose/material3/EnterAlwaysSearchBarScrollBehavior;", "Landroidx/compose/material3/SearchBarScrollBehavior;", "initialOffset", "", "initialOffsetLimit", "initialContentOffset", "canScroll", "Lkotlin/Function0;", "", "reverseLayout", "snapAnimationSpec", "Landroidx/compose/animation/core/AnimationSpec;", "flingAnimationSpec", "Landroidx/compose/animation/core/DecayAnimationSpec;", "<init>", "(FFFLkotlin/jvm/functions/Function0;ZLandroidx/compose/animation/core/AnimationSpec;Landroidx/compose/animation/core/DecayAnimationSpec;)V", "getCanScroll", "()Lkotlin/jvm/functions/Function0;", "getReverseLayout", "()Z", "getSnapAnimationSpec", "()Landroidx/compose/animation/core/AnimationSpec;", "getFlingAnimationSpec", "()Landroidx/compose/animation/core/DecayAnimationSpec;", "<set-?>", "_scrollOffset", "get_scrollOffset", "()F", "set_scrollOffset", "(F)V", "_scrollOffset$delegate", "Landroidx/compose/runtime/MutableFloatState;", "_scrollOffsetLimit", "get_scrollOffsetLimit", "set_scrollOffsetLimit", "_scrollOffsetLimit$delegate", "_contentOffset", "get_contentOffset", "set_contentOffset", "_contentOffset$delegate", "newOffset", "scrollOffset", "getScrollOffset", "setScrollOffset", "scrollOffsetLimit", "getScrollOffsetLimit", "setScrollOffsetLimit", "contentOffset", "getContentOffset", "setContentOffset", "searchBarScrollBehavior", "Landroidx/compose/ui/Modifier;", "nestedScrollConnection", "Landroidx/compose/ui/input/nestedscroll/NestedScrollConnection;", "getNestedScrollConnection", "()Landroidx/compose/ui/input/nestedscroll/NestedScrollConnection;", "settleSearchBar", "Landroidx/compose/ui/unit/Velocity;", "velocity", "settleSearchBar-OhffZ5M", "(FLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Companion", "material3"}, k = 1, mv = {2, 0, 0}, xi = 48)
final class EnterAlwaysSearchBarScrollBehavior implements SearchBarScrollBehavior {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* JADX INFO: renamed from: _contentOffset$delegate, reason: from kotlin metadata */
    private final MutableFloatState _contentOffset;

    /* JADX INFO: renamed from: _scrollOffset$delegate, reason: from kotlin metadata */
    private final MutableFloatState _scrollOffset;

    /* JADX INFO: renamed from: _scrollOffsetLimit$delegate, reason: from kotlin metadata */
    private final MutableFloatState _scrollOffsetLimit;
    private final Function0<Boolean> canScroll;
    private final DecayAnimationSpec<Float> flingAnimationSpec;
    private final NestedScrollConnection nestedScrollConnection = new NestedScrollConnection() { // from class: androidx.compose.material3.EnterAlwaysSearchBarScrollBehavior$nestedScrollConnection$1
        @Override // androidx.compose.ui.input.nestedscroll.NestedScrollConnection
        /* JADX INFO: renamed from: onPreScroll-OzD1aCk */
        public long mo1299onPreScrollOzD1aCk(long available, int source) {
            if (!this.this$0.getCanScroll().invoke().booleanValue()) {
                return Offset.INSTANCE.m6585getZeroF1C5BW0();
            }
            float scrollOffset = this.this$0.getScrollOffset();
            EnterAlwaysSearchBarScrollBehavior enterAlwaysSearchBarScrollBehavior = this.this$0;
            enterAlwaysSearchBarScrollBehavior.setScrollOffset(enterAlwaysSearchBarScrollBehavior.getScrollOffset() + Float.intBitsToFloat((int) (4294967295L & available)));
            if (!this.this$0.getReverseLayout() && scrollOffset != this.this$0.getScrollOffset()) {
                return Offset.m6563copydBAh8RU$default(available, 0.0f, 0.0f, 2, null);
            }
            return Offset.INSTANCE.m6585getZeroF1C5BW0();
        }

        @Override // androidx.compose.ui.input.nestedscroll.NestedScrollConnection
        /* JADX INFO: renamed from: onPostScroll-DzOQY0M */
        public long mo946onPostScrollDzOQY0M(long consumed, long available, int source) {
            if (!this.this$0.getCanScroll().invoke().booleanValue()) {
                return Offset.INSTANCE.m6585getZeroF1C5BW0();
            }
            if (this.this$0.getReverseLayout()) {
                int i = (int) (available & 4294967295L);
                if (Float.intBitsToFloat(i) > 0.0f) {
                    EnterAlwaysSearchBarScrollBehavior enterAlwaysSearchBarScrollBehavior = this.this$0;
                    enterAlwaysSearchBarScrollBehavior.setScrollOffset(enterAlwaysSearchBarScrollBehavior.getScrollOffset() + Float.intBitsToFloat(i));
                    EnterAlwaysSearchBarScrollBehavior enterAlwaysSearchBarScrollBehavior2 = this.this$0;
                    enterAlwaysSearchBarScrollBehavior2.setContentOffset(enterAlwaysSearchBarScrollBehavior2.getContentOffset() + Float.intBitsToFloat(i));
                    return Offset.m6563copydBAh8RU$default(available, 0.0f, 0.0f, 2, null);
                }
            }
            if (!this.this$0.getReverseLayout()) {
                EnterAlwaysSearchBarScrollBehavior enterAlwaysSearchBarScrollBehavior3 = this.this$0;
                int i2 = (int) (consumed & 4294967295L);
                enterAlwaysSearchBarScrollBehavior3.setScrollOffset(enterAlwaysSearchBarScrollBehavior3.getScrollOffset() + Float.intBitsToFloat(i2));
                EnterAlwaysSearchBarScrollBehavior enterAlwaysSearchBarScrollBehavior4 = this.this$0;
                enterAlwaysSearchBarScrollBehavior4.setContentOffset(enterAlwaysSearchBarScrollBehavior4.getContentOffset() + Float.intBitsToFloat(i2));
            }
            return Offset.INSTANCE.m6585getZeroF1C5BW0();
        }

        @Override // androidx.compose.ui.input.nestedscroll.NestedScrollConnection
        /* JADX INFO: renamed from: onPostFling-RZ2iAVY */
        public Object mo945onPostFlingRZ2iAVY(long j, long j2, Continuation<? super Velocity> continuation) {
            return !this.this$0.getCanScroll().invoke().booleanValue() ? Velocity.m9916boximpl(Velocity.INSTANCE.m9936getZero9UxMQ8M()) : this.this$0.m3311settleSearchBarOhffZ5M(Velocity.m9926getYimpl(j2), continuation);
        }
    };
    private final boolean reverseLayout;
    private final AnimationSpec<Float> snapAnimationSpec;

    public EnterAlwaysSearchBarScrollBehavior(float f, float f2, float f3, Function0<Boolean> function0, boolean z, AnimationSpec<Float> animationSpec, DecayAnimationSpec<Float> decayAnimationSpec) {
        this.canScroll = function0;
        this.reverseLayout = z;
        this.snapAnimationSpec = animationSpec;
        this.flingAnimationSpec = decayAnimationSpec;
        this._scrollOffset = PrimitiveSnapshotStateKt.mutableFloatStateOf(f);
        this._scrollOffsetLimit = PrimitiveSnapshotStateKt.mutableFloatStateOf(f2);
        this._contentOffset = PrimitiveSnapshotStateKt.mutableFloatStateOf(f3);
    }

    public final Function0<Boolean> getCanScroll() {
        return this.canScroll;
    }

    public final boolean getReverseLayout() {
        return this.reverseLayout;
    }

    public final AnimationSpec<Float> getSnapAnimationSpec() {
        return this.snapAnimationSpec;
    }

    public final DecayAnimationSpec<Float> getFlingAnimationSpec() {
        return this.flingAnimationSpec;
    }

    private final float get_scrollOffset() {
        return this._scrollOffset.getFloatValue();
    }

    private final void set_scrollOffset(float f) {
        this._scrollOffset.setFloatValue(f);
    }

    private final float get_scrollOffsetLimit() {
        return this._scrollOffsetLimit.getFloatValue();
    }

    private final void set_scrollOffsetLimit(float f) {
        this._scrollOffsetLimit.setFloatValue(f);
    }

    private final float get_contentOffset() {
        return this._contentOffset.getFloatValue();
    }

    private final void set_contentOffset(float f) {
        this._contentOffset.setFloatValue(f);
    }

    @Override // androidx.compose.material3.SearchBarScrollBehavior
    public float getScrollOffset() {
        return get_scrollOffset();
    }

    @Override // androidx.compose.material3.SearchBarScrollBehavior
    public void setScrollOffset(float f) {
        set_scrollOffset(RangesKt.coerceIn(f, getScrollOffsetLimit(), 0.0f));
    }

    @Override // androidx.compose.material3.SearchBarScrollBehavior
    public float getScrollOffsetLimit() {
        return get_scrollOffsetLimit();
    }

    @Override // androidx.compose.material3.SearchBarScrollBehavior
    public void setScrollOffsetLimit(float f) {
        set_scrollOffsetLimit(f);
    }

    @Override // androidx.compose.material3.SearchBarScrollBehavior
    public float getContentOffset() {
        return get_contentOffset();
    }

    @Override // androidx.compose.material3.SearchBarScrollBehavior
    public void setContentOffset(float f) {
        set_contentOffset(f);
    }

    @Override // androidx.compose.material3.SearchBarScrollBehavior
    public Modifier searchBarScrollBehavior(Modifier modifier) {
        return OnRemeasuredModifierKt.onSizeChanged(LayoutModifierKt.layout(ClipKt.clipToBounds(DraggableKt.draggable$default(modifier, DraggableKt.DraggableState(new Function1() { // from class: androidx.compose.material3.EnterAlwaysSearchBarScrollBehavior$$ExternalSyntheticLambda3
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return EnterAlwaysSearchBarScrollBehavior.searchBarScrollBehavior$lambda$0(this.f$0, ((Float) obj).floatValue());
            }
        }), Orientation.Vertical, this.canScroll.invoke().booleanValue(), null, false, null, new AnonymousClass2(null), false, 184, null)), new Function3() { // from class: androidx.compose.material3.EnterAlwaysSearchBarScrollBehavior$$ExternalSyntheticLambda4
            @Override // kotlin.jvm.functions.Function3
            public final Object invoke(Object obj, Object obj2, Object obj3) {
                return EnterAlwaysSearchBarScrollBehavior.searchBarScrollBehavior$lambda$1(this.f$0, (MeasureScope) obj, (Measurable) obj2, (Constraints) obj3);
            }
        }), new Function1() { // from class: androidx.compose.material3.EnterAlwaysSearchBarScrollBehavior$$ExternalSyntheticLambda5
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return EnterAlwaysSearchBarScrollBehavior.searchBarScrollBehavior$lambda$2(this.f$0, (IntSize) obj);
            }
        });
    }

    /* JADX INFO: renamed from: androidx.compose.material3.EnterAlwaysSearchBarScrollBehavior$searchBarScrollBehavior$2, reason: invalid class name */
    /* JADX INFO: compiled from: SearchBar.kt */
    @Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0004H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;", "velocity", ""}, k = 3, mv = {2, 0, 0}, xi = 48)
    @DebugMetadata(c = "androidx.compose.material3.EnterAlwaysSearchBarScrollBehavior$searchBarScrollBehavior$2", f = "SearchBar.kt", i = {}, l = {1425}, m = "invokeSuspend", n = {}, s = {}, v = 1)
    static final class AnonymousClass2 extends SuspendLambda implements Function3<CoroutineScope, Float, Continuation<? super Unit>, Object> {
        /* synthetic */ float F$0;
        int label;

        AnonymousClass2(Continuation<? super AnonymousClass2> continuation) {
            super(3, continuation);
        }

        @Override // kotlin.jvm.functions.Function3
        public /* bridge */ /* synthetic */ Object invoke(CoroutineScope coroutineScope, Float f, Continuation<? super Unit> continuation) {
            return invoke(coroutineScope, f.floatValue(), continuation);
        }

        public final Object invoke(CoroutineScope coroutineScope, float f, Continuation<? super Unit> continuation) {
            AnonymousClass2 anonymousClass2 = EnterAlwaysSearchBarScrollBehavior.this.new AnonymousClass2(continuation);
            anonymousClass2.F$0 = f;
            return anonymousClass2.invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                float f = this.F$0;
                this.label = 1;
                if (EnterAlwaysSearchBarScrollBehavior.this.m3311settleSearchBarOhffZ5M(f, this) == coroutine_suspended) {
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

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit searchBarScrollBehavior$lambda$0(EnterAlwaysSearchBarScrollBehavior enterAlwaysSearchBarScrollBehavior, float f) {
        enterAlwaysSearchBarScrollBehavior.setScrollOffset(enterAlwaysSearchBarScrollBehavior.getScrollOffset() + f);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final MeasureResult searchBarScrollBehavior$lambda$1(EnterAlwaysSearchBarScrollBehavior enterAlwaysSearchBarScrollBehavior, MeasureScope measureScope, Measurable measurable, Constraints constraints) {
        final Placeable placeableMo8265measureBRTryo0 = measurable.mo8265measureBRTryo0(constraints.getValue());
        final int iRoundToInt = MathKt.roundToInt(enterAlwaysSearchBarScrollBehavior.getScrollOffset());
        return MeasureScope.layout$default(measureScope, placeableMo8265measureBRTryo0.getWidth(), RangesKt.coerceAtLeast(placeableMo8265measureBRTryo0.getHeight() + iRoundToInt, 0), null, new Function1() { // from class: androidx.compose.material3.EnterAlwaysSearchBarScrollBehavior$$ExternalSyntheticLambda2
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return EnterAlwaysSearchBarScrollBehavior.searchBarScrollBehavior$lambda$1$0(placeableMo8265measureBRTryo0, iRoundToInt, (Placeable.PlacementScope) obj);
            }
        }, 4, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit searchBarScrollBehavior$lambda$1$0(Placeable placeable, int i, Placeable.PlacementScope placementScope) {
        Placeable.PlacementScope.placeWithLayer$default(placementScope, placeable, 0, i, 0.0f, (Function1) null, 12, (Object) null);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit searchBarScrollBehavior$lambda$2(EnterAlwaysSearchBarScrollBehavior enterAlwaysSearchBarScrollBehavior, IntSize intSize) {
        enterAlwaysSearchBarScrollBehavior.setScrollOffsetLimit(-((int) (intSize.m9862unboximpl() & 4294967295L)));
        return Unit.INSTANCE;
    }

    @Override // androidx.compose.material3.SearchBarScrollBehavior
    public NestedScrollConnection getNestedScrollConnection() {
        return this.nestedScrollConnection;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:38:0x00e1  */
    /* JADX WARN: Code duplicated, block: B:39:0x00e3  */
    /* JADX WARN: Code duplicated, block: B:43:0x0102  */
    /* JADX WARN: Code duplicated, block: B:7:0x0018  */
    /* JADX INFO: renamed from: settleSearchBar-OhffZ5M, reason: not valid java name */
    public final Object m3311settleSearchBarOhffZ5M(float f, Continuation<? super Velocity> continuation) {
        EnterAlwaysSearchBarScrollBehavior$settleSearchBar$1 enterAlwaysSearchBarScrollBehavior$settleSearchBar$1;
        float scrollOffset;
        final Ref.FloatRef floatRef;
        float f2;
        Ref.FloatRef floatRef2;
        AnimationState animationStateAnimationState$default;
        float scrollOffsetLimit;
        Float fBoxFloat;
        AnimationSpec<Float> animationSpec;
        Function1 function1;
        Ref.FloatRef floatRef3;
        if (continuation instanceof EnterAlwaysSearchBarScrollBehavior$settleSearchBar$1) {
            enterAlwaysSearchBarScrollBehavior$settleSearchBar$1 = (EnterAlwaysSearchBarScrollBehavior$settleSearchBar$1) continuation;
            if ((enterAlwaysSearchBarScrollBehavior$settleSearchBar$1.label & Integer.MIN_VALUE) != 0) {
                enterAlwaysSearchBarScrollBehavior$settleSearchBar$1.label -= Integer.MIN_VALUE;
            } else {
                enterAlwaysSearchBarScrollBehavior$settleSearchBar$1 = new EnterAlwaysSearchBarScrollBehavior$settleSearchBar$1(this, continuation);
            }
        } else {
            enterAlwaysSearchBarScrollBehavior$settleSearchBar$1 = new EnterAlwaysSearchBarScrollBehavior$settleSearchBar$1(this, continuation);
        }
        EnterAlwaysSearchBarScrollBehavior$settleSearchBar$1 enterAlwaysSearchBarScrollBehavior$settleSearchBar$2 = enterAlwaysSearchBarScrollBehavior$settleSearchBar$1;
        Object obj = enterAlwaysSearchBarScrollBehavior$settleSearchBar$2.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = enterAlwaysSearchBarScrollBehavior$settleSearchBar$2.label;
        if (i != 0) {
            if (i == 1) {
                f2 = enterAlwaysSearchBarScrollBehavior$settleSearchBar$2.F$0;
                floatRef2 = (Ref.FloatRef) enterAlwaysSearchBarScrollBehavior$settleSearchBar$2.L$0;
                ResultKt.throwOnFailure(obj);
            } else {
                if (i != 2) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                floatRef3 = (Ref.FloatRef) enterAlwaysSearchBarScrollBehavior$settleSearchBar$2.L$0;
                ResultKt.throwOnFailure(obj);
            }
            floatRef = floatRef3;
            return Velocity.m9916boximpl(VelocityKt.Velocity(0.0f, floatRef.element));
        }
        ResultKt.throwOnFailure(obj);
        scrollOffset = getScrollOffsetLimit() == 0.0f ? 0.0f : getScrollOffset() / getScrollOffsetLimit();
        if (scrollOffset < 0.01f || scrollOffset == 1.0f) {
            return Velocity.m9916boximpl(Velocity.INSTANCE.m9936getZero9UxMQ8M());
        }
        floatRef = new Ref.FloatRef();
        floatRef.element = f;
        if (Math.abs(f) > 1.0f) {
            final Ref.FloatRef floatRef4 = new Ref.FloatRef();
            AnimationState animationStateAnimationState$default2 = AnimationStateKt.AnimationState$default(0.0f, f, 0L, 0L, false, 28, null);
            DecayAnimationSpec<Float> decayAnimationSpec = this.flingAnimationSpec;
            Function1 function2 = new Function1() { // from class: androidx.compose.material3.EnterAlwaysSearchBarScrollBehavior$$ExternalSyntheticLambda0
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj2) {
                    return EnterAlwaysSearchBarScrollBehavior.settleSearchBar_OhffZ5M$lambda$0(floatRef4, this, floatRef, (AnimationScope) obj2);
                }
            };
            enterAlwaysSearchBarScrollBehavior$settleSearchBar$2.L$0 = floatRef;
            enterAlwaysSearchBarScrollBehavior$settleSearchBar$2.F$0 = scrollOffset;
            enterAlwaysSearchBarScrollBehavior$settleSearchBar$2.label = 1;
            if (SuspendAnimationKt.animateDecay$default(animationStateAnimationState$default2, decayAnimationSpec, false, function2, enterAlwaysSearchBarScrollBehavior$settleSearchBar$2, 2, null) != coroutine_suspended) {
                f2 = scrollOffset;
                floatRef2 = floatRef;
            }
        } else {
            if (getScrollOffsetLimit() < getScrollOffset() && getScrollOffset() < 0.0f) {
                animationStateAnimationState$default = AnimationStateKt.AnimationState$default(getScrollOffset(), 0.0f, 0L, 0L, false, 30, null);
                if (scrollOffset < 0.5f) {
                    scrollOffsetLimit = 0.0f;
                } else {
                    scrollOffsetLimit = getScrollOffsetLimit();
                }
                fBoxFloat = Boxing.boxFloat(scrollOffsetLimit);
                animationSpec = this.snapAnimationSpec;
                function1 = new Function1() { // from class: androidx.compose.material3.EnterAlwaysSearchBarScrollBehavior$$ExternalSyntheticLambda1
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj2) {
                        return EnterAlwaysSearchBarScrollBehavior.settleSearchBar_OhffZ5M$lambda$1(this.f$0, (AnimationScope) obj2);
                    }
                };
                enterAlwaysSearchBarScrollBehavior$settleSearchBar$2.L$0 = floatRef;
                enterAlwaysSearchBarScrollBehavior$settleSearchBar$2.label = 2;
                if (SuspendAnimationKt.animateTo$default(animationStateAnimationState$default, fBoxFloat, animationSpec, false, function1, enterAlwaysSearchBarScrollBehavior$settleSearchBar$2, 4, null) != coroutine_suspended) {
                    floatRef3 = floatRef;
                    floatRef = floatRef3;
                }
            }
            return Velocity.m9916boximpl(VelocityKt.Velocity(0.0f, floatRef.element));
        }
        return coroutine_suspended;
        scrollOffset = f2;
        floatRef = floatRef2;
        if (getScrollOffsetLimit() < getScrollOffset()) {
            animationStateAnimationState$default = AnimationStateKt.AnimationState$default(getScrollOffset(), 0.0f, 0L, 0L, false, 30, null);
            if (scrollOffset < 0.5f) {
                scrollOffsetLimit = 0.0f;
            } else {
                scrollOffsetLimit = getScrollOffsetLimit();
            }
            fBoxFloat = Boxing.boxFloat(scrollOffsetLimit);
            animationSpec = this.snapAnimationSpec;
            function1 = new Function1() { // from class: androidx.compose.material3.EnterAlwaysSearchBarScrollBehavior$$ExternalSyntheticLambda1
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj2) {
                    return EnterAlwaysSearchBarScrollBehavior.settleSearchBar_OhffZ5M$lambda$1(this.f$0, (AnimationScope) obj2);
                }
            };
            enterAlwaysSearchBarScrollBehavior$settleSearchBar$2.L$0 = floatRef;
            enterAlwaysSearchBarScrollBehavior$settleSearchBar$2.label = 2;
            if (SuspendAnimationKt.animateTo$default(animationStateAnimationState$default, fBoxFloat, animationSpec, false, function1, enterAlwaysSearchBarScrollBehavior$settleSearchBar$2, 4, null) != coroutine_suspended) {
                floatRef3 = floatRef;
                floatRef = floatRef3;
            }
            return coroutine_suspended;
        }
        return Velocity.m9916boximpl(VelocityKt.Velocity(0.0f, floatRef.element));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit settleSearchBar_OhffZ5M$lambda$0(Ref.FloatRef floatRef, EnterAlwaysSearchBarScrollBehavior enterAlwaysSearchBarScrollBehavior, Ref.FloatRef floatRef2, AnimationScope animationScope) {
        float fFloatValue = ((Number) animationScope.getValue()).floatValue() - floatRef.element;
        float scrollOffset = enterAlwaysSearchBarScrollBehavior.getScrollOffset();
        enterAlwaysSearchBarScrollBehavior.setScrollOffset(scrollOffset + fFloatValue);
        float fAbs = Math.abs(scrollOffset - enterAlwaysSearchBarScrollBehavior.getScrollOffset());
        floatRef.element = ((Number) animationScope.getValue()).floatValue();
        floatRef2.element = ((Number) animationScope.getVelocity()).floatValue();
        if (Math.abs(fFloatValue - fAbs) > 0.5f) {
            animationScope.cancelAnimation();
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit settleSearchBar_OhffZ5M$lambda$1(EnterAlwaysSearchBarScrollBehavior enterAlwaysSearchBarScrollBehavior, AnimationScope animationScope) {
        enterAlwaysSearchBarScrollBehavior.setScrollOffset(((Number) animationScope.getValue()).floatValue());
        return Unit.INSTANCE;
    }

    /* JADX INFO: compiled from: SearchBar.kt */
    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J:\u0010\u0004\u001a\f\u0012\u0004\u0012\u00020\u0006\u0012\u0002\b\u00030\u00052\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\b2\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000b2\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\f0\u000e¨\u0006\u000f"}, d2 = {"Landroidx/compose/material3/EnterAlwaysSearchBarScrollBehavior$Companion;", "", "<init>", "()V", "Saver", "Landroidx/compose/runtime/saveable/Saver;", "Landroidx/compose/material3/EnterAlwaysSearchBarScrollBehavior;", "canScroll", "Lkotlin/Function0;", "", "snapAnimationSpec", "Landroidx/compose/animation/core/AnimationSpec;", "", "flingAnimationSpec", "Landroidx/compose/animation/core/DecayAnimationSpec;", "material3"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final Saver<EnterAlwaysSearchBarScrollBehavior, ?> Saver(final Function0<Boolean> canScroll, final AnimationSpec<Float> snapAnimationSpec, final DecayAnimationSpec<Float> flingAnimationSpec) {
            return ListSaverKt.listSaver(new Function2() { // from class: androidx.compose.material3.EnterAlwaysSearchBarScrollBehavior$Companion$$ExternalSyntheticLambda0
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return EnterAlwaysSearchBarScrollBehavior.Companion.Saver$lambda$0((SaverScope) obj, (EnterAlwaysSearchBarScrollBehavior) obj2);
                }
            }, new Function1() { // from class: androidx.compose.material3.EnterAlwaysSearchBarScrollBehavior$Companion$$ExternalSyntheticLambda1
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    return EnterAlwaysSearchBarScrollBehavior.Companion.Saver$lambda$1(canScroll, snapAnimationSpec, flingAnimationSpec, (List) obj);
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final List Saver$lambda$0(SaverScope saverScope, EnterAlwaysSearchBarScrollBehavior enterAlwaysSearchBarScrollBehavior) {
            return CollectionsKt.listOf(Float.valueOf(enterAlwaysSearchBarScrollBehavior.getScrollOffset()), Float.valueOf(enterAlwaysSearchBarScrollBehavior.getScrollOffsetLimit()), Float.valueOf(enterAlwaysSearchBarScrollBehavior.getContentOffset()), Boolean.valueOf(enterAlwaysSearchBarScrollBehavior.getReverseLayout()));
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final EnterAlwaysSearchBarScrollBehavior Saver$lambda$1(Function0 function0, AnimationSpec animationSpec, DecayAnimationSpec decayAnimationSpec, List list) {
            Object obj = list.get(0);
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.Float");
            float fFloatValue = ((Float) obj).floatValue();
            Object obj2 = list.get(1);
            Intrinsics.checkNotNull(obj2, "null cannot be cast to non-null type kotlin.Float");
            float fFloatValue2 = ((Float) obj2).floatValue();
            Object obj3 = list.get(2);
            Intrinsics.checkNotNull(obj3, "null cannot be cast to non-null type kotlin.Float");
            float fFloatValue3 = ((Float) obj3).floatValue();
            Object obj4 = list.get(3);
            Intrinsics.checkNotNull(obj4, "null cannot be cast to non-null type kotlin.Boolean");
            return new EnterAlwaysSearchBarScrollBehavior(fFloatValue, fFloatValue2, fFloatValue3, function0, ((Boolean) obj4).booleanValue(), animationSpec, decayAnimationSpec);
        }
    }
}
