package androidx.compose.material.pullrefresh;

import androidx.compose.animation.core.SuspendAnimationKt;
import androidx.compose.foundation.MutatorMutex;
import androidx.compose.runtime.MutableFloatState;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.PrimitiveSnapshotStateKt;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import androidx.compose.runtime.State;
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
import kotlin.ranges.RangesKt;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Job;

/* JADX INFO: compiled from: PullRefreshState.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b/\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u0001B5\b\u0000\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0012\u0010\u0004\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u00060\u0005\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\t¢\u0006\u0004\b\u000b\u0010\fJ\u0015\u00104\u001a\u00020\t2\u0006\u00105\u001a\u00020\tH\u0000¢\u0006\u0002\b6J\u0015\u00107\u001a\u00020\t2\u0006\u00108\u001a\u00020\tH\u0000¢\u0006\u0002\b9J\u0015\u0010:\u001a\u00020\u00072\u0006\u0010\u0010\u001a\u00020\u0011H\u0000¢\u0006\u0002\b;J\u0015\u0010<\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\tH\u0000¢\u0006\u0002\b=J\u0015\u0010>\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0000¢\u0006\u0002\b?J\u0010\u0010B\u001a\u00020C2\u0006\u0010D\u001a\u00020\tH\u0002J\b\u0010E\u001a\u00020\tH\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0004\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u00060\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\r\u001a\u00020\t8F¢\u0006\u0006\u001a\u0004\b\u000e\u0010\u000fR\u0014\u0010\u0010\u001a\u00020\u00118@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b\u0012\u0010\u0013R\u0014\u0010\u0014\u001a\u00020\t8@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b\u0015\u0010\u000fR\u0014\u0010\n\u001a\u00020\t8@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b\u0016\u0010\u000fR\u001b\u0010\u0017\u001a\u00020\t8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u0018\u0010\u000fR+\u0010\u001c\u001a\u00020\u00112\u0006\u0010\u001b\u001a\u00020\u00118B@BX\u0082\u008e\u0002¢\u0006\u0012\n\u0004\b \u0010!\u001a\u0004\b\u001d\u0010\u0013\"\u0004\b\u001e\u0010\u001fR+\u0010\"\u001a\u00020\t2\u0006\u0010\u001b\u001a\u00020\t8B@BX\u0082\u008e\u0002¢\u0006\u0012\n\u0004\b&\u0010'\u001a\u0004\b#\u0010\u000f\"\u0004\b$\u0010%R+\u0010(\u001a\u00020\t2\u0006\u0010\u001b\u001a\u00020\t8B@BX\u0082\u008e\u0002¢\u0006\u0012\n\u0004\b+\u0010'\u001a\u0004\b)\u0010\u000f\"\u0004\b*\u0010%R+\u0010,\u001a\u00020\t2\u0006\u0010\u001b\u001a\u00020\t8B@BX\u0082\u008e\u0002¢\u0006\u0012\n\u0004\b/\u0010'\u001a\u0004\b-\u0010\u000f\"\u0004\b.\u0010%R+\u00100\u001a\u00020\t2\u0006\u0010\u001b\u001a\u00020\t8B@BX\u0082\u008e\u0002¢\u0006\u0012\n\u0004\b3\u0010'\u001a\u0004\b1\u0010\u000f\"\u0004\b2\u0010%R\u000e\u0010@\u001a\u00020AX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006F"}, d2 = {"Landroidx/compose/material/pullrefresh/PullRefreshState;", "", "animationScope", "Lkotlinx/coroutines/CoroutineScope;", "onRefreshState", "Landroidx/compose/runtime/State;", "Lkotlin/Function0;", "", "refreshingOffset", "", "threshold", "<init>", "(Lkotlinx/coroutines/CoroutineScope;Landroidx/compose/runtime/State;FF)V", "progress", "getProgress", "()F", "refreshing", "", "getRefreshing$material", "()Z", ViewProps.POSITION, "getPosition$material", "getThreshold$material", "adjustedDistancePulled", "getAdjustedDistancePulled", "adjustedDistancePulled$delegate", "Landroidx/compose/runtime/State;", "<set-?>", "_refreshing", "get_refreshing", "set_refreshing", "(Z)V", "_refreshing$delegate", "Landroidx/compose/runtime/MutableState;", "_position", "get_position", "set_position", "(F)V", "_position$delegate", "Landroidx/compose/runtime/MutableFloatState;", "distancePulled", "getDistancePulled", "setDistancePulled", "distancePulled$delegate", "_threshold", "get_threshold", "set_threshold", "_threshold$delegate", "_refreshingOffset", "get_refreshingOffset", "set_refreshingOffset", "_refreshingOffset$delegate", "onPull", "pullDelta", "onPull$material", "onRelease", "velocity", "onRelease$material", "setRefreshing", "setRefreshing$material", "setThreshold", "setThreshold$material", "setRefreshingOffset", "setRefreshingOffset$material", "mutatorMutex", "Landroidx/compose/foundation/MutatorMutex;", "animateIndicatorTo", "Lkotlinx/coroutines/Job;", "offset", "calculateIndicatorPosition", "material"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class PullRefreshState {
    public static final int $stable = 8;

    /* JADX INFO: renamed from: _refreshingOffset$delegate, reason: from kotlin metadata */
    private final MutableFloatState _refreshingOffset;

    /* JADX INFO: renamed from: _threshold$delegate, reason: from kotlin metadata */
    private final MutableFloatState _threshold;
    private final CoroutineScope animationScope;
    private final State<Function0<Unit>> onRefreshState;

    /* JADX INFO: renamed from: adjustedDistancePulled$delegate, reason: from kotlin metadata */
    private final State adjustedDistancePulled = SnapshotStateKt.derivedStateOf(new Function0() { // from class: androidx.compose.material.pullrefresh.PullRefreshState$$ExternalSyntheticLambda0
        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() {
            return Float.valueOf(PullRefreshState.adjustedDistancePulled_delegate$lambda$0(this.f$0));
        }
    });

    /* JADX INFO: renamed from: _refreshing$delegate, reason: from kotlin metadata */
    private final MutableState _refreshing = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(false, null, 2, null);

    /* JADX INFO: renamed from: _position$delegate, reason: from kotlin metadata */
    private final MutableFloatState _position = PrimitiveSnapshotStateKt.mutableFloatStateOf(0.0f);

    /* JADX INFO: renamed from: distancePulled$delegate, reason: from kotlin metadata */
    private final MutableFloatState distancePulled = PrimitiveSnapshotStateKt.mutableFloatStateOf(0.0f);
    private final MutatorMutex mutatorMutex = new MutatorMutex();

    /* JADX WARN: Multi-variable type inference failed */
    public PullRefreshState(CoroutineScope coroutineScope, State<? extends Function0<Unit>> state, float f, float f2) {
        this.animationScope = coroutineScope;
        this.onRefreshState = state;
        this._threshold = PrimitiveSnapshotStateKt.mutableFloatStateOf(f2);
        this._refreshingOffset = PrimitiveSnapshotStateKt.mutableFloatStateOf(f);
    }

    public final float getProgress() {
        return getAdjustedDistancePulled() / getThreshold$material();
    }

    public final boolean getRefreshing$material() {
        return get_refreshing();
    }

    public final float getPosition$material() {
        return get_position();
    }

    public final float getThreshold$material() {
        return get_threshold();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final float adjustedDistancePulled_delegate$lambda$0(PullRefreshState pullRefreshState) {
        return pullRefreshState.getDistancePulled() * 0.5f;
    }

    private final float getAdjustedDistancePulled() {
        return ((Number) this.adjustedDistancePulled.getValue()).floatValue();
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final boolean get_refreshing() {
        return ((Boolean) this._refreshing.getValue()).booleanValue();
    }

    private final void set_refreshing(boolean z) {
        this._refreshing.setValue(Boolean.valueOf(z));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final float get_position() {
        return this._position.getFloatValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void set_position(float f) {
        this._position.setFloatValue(f);
    }

    private final float getDistancePulled() {
        return this.distancePulled.getFloatValue();
    }

    private final void setDistancePulled(float f) {
        this.distancePulled.setFloatValue(f);
    }

    private final float get_threshold() {
        return this._threshold.getFloatValue();
    }

    private final void set_threshold(float f) {
        this._threshold.setFloatValue(f);
    }

    private final float get_refreshingOffset() {
        return this._refreshingOffset.getFloatValue();
    }

    private final void set_refreshingOffset(float f) {
        this._refreshingOffset.setFloatValue(f);
    }

    public final float onPull$material(float pullDelta) {
        if (get_refreshing()) {
            return 0.0f;
        }
        float fCoerceAtLeast = RangesKt.coerceAtLeast(getDistancePulled() + pullDelta, 0.0f);
        float distancePulled = fCoerceAtLeast - getDistancePulled();
        setDistancePulled(fCoerceAtLeast);
        set_position(calculateIndicatorPosition());
        return distancePulled;
    }

    public final float onRelease$material(float velocity) {
        if (getRefreshing$material()) {
            return 0.0f;
        }
        if (getAdjustedDistancePulled() > getThreshold$material()) {
            this.onRefreshState.getValue().invoke();
        }
        animateIndicatorTo(0.0f);
        if (getDistancePulled() == 0.0f || velocity < 0.0f) {
            velocity = 0.0f;
        }
        setDistancePulled(0.0f);
        return velocity;
    }

    public final void setRefreshing$material(boolean refreshing) {
        if (get_refreshing() != refreshing) {
            set_refreshing(refreshing);
            setDistancePulled(0.0f);
            animateIndicatorTo(refreshing ? get_refreshingOffset() : 0.0f);
        }
    }

    public final void setThreshold$material(float threshold) {
        set_threshold(threshold);
    }

    public final void setRefreshingOffset$material(float refreshingOffset) {
        if (get_refreshingOffset() == refreshingOffset) {
            return;
        }
        set_refreshingOffset(refreshingOffset);
        if (getRefreshing$material()) {
            animateIndicatorTo(refreshingOffset);
        }
    }

    /* JADX INFO: renamed from: androidx.compose.material.pullrefresh.PullRefreshState$animateIndicatorTo$1, reason: invalid class name */
    /* JADX INFO: compiled from: PullRefreshState.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
    @DebugMetadata(c = "androidx.compose.material.pullrefresh.PullRefreshState$animateIndicatorTo$1", f = "PullRefreshState.kt", i = {}, l = {196}, m = "invokeSuspend", n = {}, s = {}, v = 1)
    static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ float $offset;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(float f, Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
            this.$offset = f;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return PullRefreshState.this.new AnonymousClass1(this.$offset, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX INFO: renamed from: androidx.compose.material.pullrefresh.PullRefreshState$animateIndicatorTo$1$1, reason: invalid class name and collision with other inner class name */
        /* JADX INFO: compiled from: PullRefreshState.kt */
        @Metadata(d1 = {"\u0000\u0006\n\u0000\n\u0002\u0010\u0002\u0010\u0000\u001a\u00020\u0001H\n"}, d2 = {"<anonymous>", ""}, k = 3, mv = {2, 0, 0}, xi = 48)
        @DebugMetadata(c = "androidx.compose.material.pullrefresh.PullRefreshState$animateIndicatorTo$1$1", f = "PullRefreshState.kt", i = {}, l = {197}, m = "invokeSuspend", n = {}, s = {}, v = 1)
        static final class C00521 extends SuspendLambda implements Function1<Continuation<? super Unit>, Object> {
            final /* synthetic */ float $offset;
            int label;
            final /* synthetic */ PullRefreshState this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            C00521(PullRefreshState pullRefreshState, float f, Continuation<? super C00521> continuation) {
                super(1, continuation);
                this.this$0 = pullRefreshState;
                this.$offset = f;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation<Unit> create(Continuation<?> continuation) {
                return new C00521(this.this$0, this.$offset, continuation);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Continuation<? super Unit> continuation) {
                return ((C00521) create(continuation)).invokeSuspend(Unit.INSTANCE);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object obj) {
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                int i = this.label;
                if (i == 0) {
                    ResultKt.throwOnFailure(obj);
                    float f = this.this$0.get_position();
                    float f2 = this.$offset;
                    final PullRefreshState pullRefreshState = this.this$0;
                    this.label = 1;
                    if (SuspendAnimationKt.animate$default(f, f2, 0.0f, null, new Function2() { // from class: androidx.compose.material.pullrefresh.PullRefreshState$animateIndicatorTo$1$1$$ExternalSyntheticLambda0
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj2, Object obj3) {
                            return PullRefreshState.AnonymousClass1.C00521.invokeSuspend$lambda$0(pullRefreshState, ((Float) obj2).floatValue(), ((Float) obj3).floatValue());
                        }
                    }, this, 12, null) == coroutine_suspended) {
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

            /* JADX INFO: Access modifiers changed from: private */
            public static final Unit invokeSuspend$lambda$0(PullRefreshState pullRefreshState, float f, float f2) {
                pullRefreshState.set_position(f);
                return Unit.INSTANCE;
            }
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                this.label = 1;
                if (MutatorMutex.mutate$default(PullRefreshState.this.mutatorMutex, null, new C00521(PullRefreshState.this, this.$offset, null), this, 1, null) == coroutine_suspended) {
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

    private final Job animateIndicatorTo(float offset) {
        return BuildersKt__Builders_commonKt.launch$default(this.animationScope, null, null, new AnonymousClass1(offset, null), 3, null);
    }

    private final float calculateIndicatorPosition() {
        if (getAdjustedDistancePulled() <= getThreshold$material()) {
            return getAdjustedDistancePulled();
        }
        float fAbs = Math.abs(getProgress()) - 1.0f;
        if (fAbs < 0.0f) {
            fAbs = 0.0f;
        }
        if (fAbs > 2.0f) {
            fAbs = 2.0f;
        }
        return getThreshold$material() + (getThreshold$material() * (fAbs - (((float) Math.pow(fAbs, 2)) / 4)));
    }
}
