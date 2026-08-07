package androidx.compose.material3;

import androidx.collection.IntList;
import androidx.compose.animation.core.Animatable;
import androidx.compose.animation.core.AnimatableKt;
import androidx.compose.animation.core.AnimationResult;
import androidx.compose.animation.core.AnimationSpec;
import androidx.compose.animation.core.AnimationVector1D;
import androidx.compose.foundation.MutatePriority;
import androidx.compose.foundation.MutatorMutex;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.RememberObserver;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import androidx.compose.ui.node.Ref;
import androidx.compose.ui.unit.Dp;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: TimePicker.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(d1 = {"\u0000f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0001\u0018\u00002\u00020\u00012\u00020\u0002B\u001f\u0012\u0006\u0010\u0003\u001a\u00020\u0001\u0012\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\u0004\b\u0007\u0010\bJ\u001c\u0010\u001b\u001a\u00020\u001c2\f\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u00170\u001eH\u0086@¢\u0006\u0002\u0010\u001fJ\b\u0010 \u001a\u00020\u0006H\u0002J\u0010\u0010%\u001a\u00020\u00172\u0006\u0010&\u001a\u00020\u0017H\u0002J\u001c\u0010*\u001a\u00020\u001c2\f\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u00170\u001eH\u0086@¢\u0006\u0002\u0010\u001fJ.\u0010+\u001a\u00020\u001c2\u0006\u0010,\u001a\u00020\u00172\f\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u00170\u001e2\b\b\u0002\u0010-\u001a\u00020\u0006H\u0086@¢\u0006\u0002\u0010.J\f\u00109\u001a\u00020\u0017*\u00020\u0017H\u0002J\f\u0010<\u001a\u000200*\u00020\u0017H\u0002J\f\u0010=\u001a\u000200*\u00020\u0017H\u0002J\u0010\u0010>\u001a\u00020\u00172\u0006\u0010,\u001a\u00020\u0017H\u0002J\b\u0010?\u001a\u00020\u001cH\u0016J\b\u0010@\u001a\u00020\u001cH\u0016J\b\u0010A\u001a\u00020\u001cH\u0016R\u0011\u0010\u0003\u001a\u00020\u0001¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0017\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR+\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\r\u001a\u00020\u000e8F@FX\u0086\u008e\u0002¢\u0006\u0012\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u0011\u0010\u0016\u001a\u00020\u00178F¢\u0006\u0006\u001a\u0004\b\u0018\u0010\u0011R\u000e\u0010\u0019\u001a\u00020\u0017X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u0017X\u0082\u000e¢\u0006\u0002\n\u0000R\u0011\u0010!\u001a\u00020\"8F¢\u0006\u0006\u001a\u0004\b#\u0010$R\u001a\u0010'\u001a\u000e\u0012\u0004\u0012\u00020\u0017\u0012\u0004\u0012\u00020)0(X\u0082\u000e¢\u0006\u0002\n\u0000R$\u00101\u001a\u0002002\u0006\u0010/\u001a\u0002008V@VX\u0096\u000e¢\u0006\f\u001a\u0004\b2\u00103\"\u0004\b4\u00105R$\u00106\u001a\u0002002\u0006\u0010/\u001a\u0002008V@VX\u0096\u000e¢\u0006\f\u001a\u0004\b7\u00103\"\u0004\b8\u00105R\u000e\u0010:\u001a\u00020;X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010B\u001a\u0002008\u0017X\u0096\u000f¢\u0006\f\u001a\u0004\bC\u00103\"\u0004\bD\u00105R\u0018\u0010E\u001a\u00020\u0006X\u0096\u000f¢\u0006\f\u001a\u0004\bE\u0010F\"\u0004\bG\u0010HR\u001a\u0010I\u001a\u0002008\u0017X\u0096\u000f¢\u0006\f\u001a\u0004\bJ\u00103\"\u0004\bK\u00105R\u0018\u0010L\u001a\u00020MX\u0096\u000f¢\u0006\f\u001a\u0004\bN\u00103\"\u0004\bO\u00105¨\u0006P"}, d2 = {"Landroidx/compose/material3/AnalogTimePickerState;", "Landroidx/compose/material3/TimePickerState;", "Landroidx/compose/runtime/RememberObserver;", "state", "userOverride", "Landroidx/compose/ui/node/Ref;", "", "<init>", "(Landroidx/compose/material3/TimePickerState;Landroidx/compose/ui/node/Ref;)V", "getState", "()Landroidx/compose/material3/TimePickerState;", "getUserOverride", "()Landroidx/compose/ui/node/Ref;", "<set-?>", "Landroidx/compose/ui/unit/Dp;", "currentDiameter", "getCurrentDiameter-D9Ej5fM", "()F", "setCurrentDiameter-0680j_4", "(F)V", "currentDiameter$delegate", "Landroidx/compose/runtime/MutableState;", "currentAngle", "", "getCurrentAngle", "hourAngle", "minuteAngle", "animateToCurrent", "", "animationSpec", "Landroidx/compose/animation/core/AnimationSpec;", "(Landroidx/compose/animation/core/AnimationSpec;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "isUpdated", "clockFaceValues", "Landroidx/collection/IntList;", "getClockFaceValues", "()Landroidx/collection/IntList;", "endValueForAnimation", "new", "anim", "Landroidx/compose/animation/core/Animatable;", "Landroidx/compose/animation/core/AnimationVector1D;", "onGestureEnd", "rotateTo", "angle", "animate", "(FLandroidx/compose/animation/core/AnimationSpec;ZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "value", "", "minuteInput", "getMinuteInput", "()I", "setMinuteInput", "(I)V", "hourInput", "getHourInput", "setHourInput", "normalize", "mutex", "Landroidx/compose/foundation/MutatorMutex;", "toHour", "toMinute", "offsetAngle", "onRemembered", "onForgotten", "onAbandoned", "hour", "getHour", "setHour", "is24hour", "()Z", "set24hour", "(Z)V", "minute", "getMinute", "setMinute", "selection", "Landroidx/compose/material3/TimePickerSelectionMode;", "getSelection-yecRtBI", "setSelection-6_8s6DQ", "material3"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class AnalogTimePickerState implements TimePickerState, RememberObserver {
    public static final int $stable = 8;
    private Animatable<Float, AnimationVector1D> anim;

    /* JADX INFO: renamed from: currentDiameter$delegate, reason: from kotlin metadata */
    private final MutableState currentDiameter;
    private float hourAngle;
    private float minuteAngle;
    private final MutatorMutex mutex;
    private final TimePickerState state;
    private final Ref<Boolean> userOverride;

    private final float normalize(float f) {
        double d = ((double) f) % 6.283185307179586d;
        if (d < 0.0d) {
            d += 6.283185307179586d;
        }
        return (float) d;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final float offsetAngle(float angle) {
        float f = angle + 1.5707964f;
        return f < 0.0f ? f + 6.2831855f : f;
    }

    @Override // androidx.compose.material3.TimePickerState
    public int getHour() {
        return this.state.getHour();
    }

    @Override // androidx.compose.material3.TimePickerState
    public int getMinute() {
        return this.state.getMinute();
    }

    @Override // androidx.compose.material3.TimePickerState
    /* JADX INFO: renamed from: getSelection-yecRtBI, reason: not valid java name */
    public int mo2728getSelectionyecRtBI() {
        return this.state.mo2728getSelectionyecRtBI();
    }

    @Override // androidx.compose.material3.TimePickerState
    public boolean is24hour() {
        return this.state.is24hour();
    }

    @Override // androidx.compose.runtime.RememberObserver
    public void onAbandoned() {
    }

    @Override // androidx.compose.runtime.RememberObserver
    public void onForgotten() {
    }

    @Override // androidx.compose.material3.TimePickerState
    public void set24hour(boolean z) {
        this.state.set24hour(z);
    }

    @Override // androidx.compose.material3.TimePickerState
    public void setHour(int i) {
        this.state.setHour(i);
    }

    @Override // androidx.compose.material3.TimePickerState
    public void setMinute(int i) {
        this.state.setMinute(i);
    }

    @Override // androidx.compose.material3.TimePickerState
    /* JADX INFO: renamed from: setSelection-6_8s6DQ, reason: not valid java name */
    public void mo2730setSelection6_8s6DQ(int i) {
        this.state.mo2730setSelection6_8s6DQ(i);
    }

    public AnalogTimePickerState(TimePickerState timePickerState, Ref<Boolean> ref) {
        this.state = timePickerState;
        this.userOverride = ref;
        this.currentDiameter = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(Dp.m9685boximpl(Dp.m9687constructorimpl(0)), null, 2, null);
        this.hourAngle = ((timePickerState.getHour() % 12) * 0.5235988f) - 1.5707964f;
        this.minuteAngle = (timePickerState.getMinute() * 0.10471976f) - 1.5707964f;
        this.anim = AnimatableKt.Animatable$default(this.hourAngle, 0.0f, 2, null);
        this.mutex = new MutatorMutex();
    }

    public final TimePickerState getState() {
        return this.state;
    }

    public /* synthetic */ AnalogTimePickerState(TimePickerState timePickerState, Ref ref, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(timePickerState, (i & 2) != 0 ? new Ref() : ref);
    }

    public final Ref<Boolean> getUserOverride() {
        return this.userOverride;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX INFO: renamed from: getCurrentDiameter-D9Ej5fM, reason: not valid java name */
    public final float m2727getCurrentDiameterD9Ej5fM() {
        return ((Dp) this.currentDiameter.getValue()).m9701unboximpl();
    }

    /* JADX INFO: renamed from: setCurrentDiameter-0680j_4, reason: not valid java name */
    public final void m2729setCurrentDiameter0680j_4(float f) {
        this.currentDiameter.setValue(Dp.m9685boximpl(f));
    }

    public final float getCurrentAngle() {
        return this.anim.getValue().floatValue();
    }

    public final Object animateToCurrent(AnimationSpec<Float> animationSpec, Continuation<? super Unit> continuation) {
        float fEndValueForAnimation;
        if (!isUpdated()) {
            return Unit.INSTANCE;
        }
        if (TimePickerSelectionMode.m4586equalsimpl0(mo2728getSelectionyecRtBI(), TimePickerSelectionMode.INSTANCE.m4590getHouryecRtBI())) {
            fEndValueForAnimation = endValueForAnimation(this.hourAngle);
        } else {
            fEndValueForAnimation = endValueForAnimation(this.minuteAngle);
        }
        Object objMutate = this.mutex.mutate(MutatePriority.PreventUserInput, new AnonymousClass2(fEndValueForAnimation, animationSpec, null), continuation);
        return objMutate == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objMutate : Unit.INSTANCE;
    }

    /* JADX INFO: renamed from: androidx.compose.material3.AnalogTimePickerState$animateToCurrent$2, reason: invalid class name */
    /* JADX INFO: compiled from: TimePicker.kt */
    @Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\u0018\u0002\u0010\u0000\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001H\n"}, d2 = {"<anonymous>", "Landroidx/compose/animation/core/AnimationResult;", "", "Landroidx/compose/animation/core/AnimationVector1D;"}, k = 3, mv = {2, 0, 0}, xi = 48)
    @DebugMetadata(c = "androidx.compose.material3.AnalogTimePickerState$animateToCurrent$2", f = "TimePicker.kt", i = {}, l = {833}, m = "invokeSuspend", n = {}, s = {}, v = 1)
    static final class AnonymousClass2 extends SuspendLambda implements Function1<Continuation<? super AnimationResult<Float, AnimationVector1D>>, Object> {
        final /* synthetic */ AnimationSpec<Float> $animationSpec;
        final /* synthetic */ float $end;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass2(float f, AnimationSpec<Float> animationSpec, Continuation<? super AnonymousClass2> continuation) {
            super(1, continuation);
            this.$end = f;
            this.$animationSpec = animationSpec;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Continuation<?> continuation) {
            return AnalogTimePickerState.this.new AnonymousClass2(this.$end, this.$animationSpec, continuation);
        }

        @Override // kotlin.jvm.functions.Function1
        public final Object invoke(Continuation<? super AnimationResult<Float, AnimationVector1D>> continuation) {
            return ((AnonymousClass2) create(continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i != 0) {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
                return obj;
            }
            ResultKt.throwOnFailure(obj);
            this.label = 1;
            Object objAnimateTo$default = Animatable.animateTo$default(AnalogTimePickerState.this.anim, Boxing.boxFloat(this.$end), this.$animationSpec, null, null, this, 12, null);
            return objAnimateTo$default == coroutine_suspended ? coroutine_suspended : objAnimateTo$default;
        }
    }

    private final boolean isUpdated() {
        if (TimePickerSelectionMode.m4586equalsimpl0(mo2728getSelectionyecRtBI(), TimePickerSelectionMode.INSTANCE.m4590getHouryecRtBI()) && normalize(this.anim.getTargetValue().floatValue()) == normalize(this.hourAngle)) {
            return false;
        }
        return (TimePickerSelectionMode.m4586equalsimpl0(mo2728getSelectionyecRtBI(), TimePickerSelectionMode.INSTANCE.m4591getMinuteyecRtBI()) && normalize(this.anim.getTargetValue().floatValue()) == normalize(this.minuteAngle)) ? false : true;
    }

    public final IntList getClockFaceValues() {
        return TimePickerSelectionMode.m4586equalsimpl0(mo2728getSelectionyecRtBI(), TimePickerSelectionMode.INSTANCE.m4591getMinuteyecRtBI()) ? TimePickerKt.Minutes : TimePickerKt.Hours;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final float endValueForAnimation(float f) {
        float fFloatValue = this.anim.getValue().floatValue() - f;
        while (fFloatValue > 3.1415927f) {
            fFloatValue -= 6.2831855f;
        }
        while (fFloatValue <= -3.1415927f) {
            fFloatValue += 6.2831855f;
        }
        return this.anim.getValue().floatValue() - fFloatValue;
    }

    public final Object onGestureEnd(AnimationSpec<Float> animationSpec, Continuation<? super Unit> continuation) {
        float f;
        if (TimePickerSelectionMode.m4586equalsimpl0(mo2728getSelectionyecRtBI(), TimePickerSelectionMode.INSTANCE.m4590getHouryecRtBI())) {
            f = this.hourAngle;
        } else {
            f = this.minuteAngle;
        }
        Object objMutate = this.mutex.mutate(MutatePriority.PreventUserInput, new C07162(endValueForAnimation(f), animationSpec, null), continuation);
        return objMutate == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objMutate : Unit.INSTANCE;
    }

    /* JADX INFO: renamed from: androidx.compose.material3.AnalogTimePickerState$onGestureEnd$2, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: TimePicker.kt */
    @Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\u0018\u0002\u0010\u0000\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001H\n"}, d2 = {"<anonymous>", "Landroidx/compose/animation/core/AnimationResult;", "", "Landroidx/compose/animation/core/AnimationVector1D;"}, k = 3, mv = {2, 0, 0}, xi = 48)
    @DebugMetadata(c = "androidx.compose.material3.AnalogTimePickerState$onGestureEnd$2", f = "TimePicker.kt", i = {}, l = {883}, m = "invokeSuspend", n = {}, s = {}, v = 1)
    static final class C07162 extends SuspendLambda implements Function1<Continuation<? super AnimationResult<Float, AnimationVector1D>>, Object> {
        final /* synthetic */ AnimationSpec<Float> $animationSpec;
        final /* synthetic */ float $end;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C07162(float f, AnimationSpec<Float> animationSpec, Continuation<? super C07162> continuation) {
            super(1, continuation);
            this.$end = f;
            this.$animationSpec = animationSpec;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Continuation<?> continuation) {
            return AnalogTimePickerState.this.new C07162(this.$end, this.$animationSpec, continuation);
        }

        @Override // kotlin.jvm.functions.Function1
        public final Object invoke(Continuation<? super AnimationResult<Float, AnimationVector1D>> continuation) {
            return ((C07162) create(continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i != 0) {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
                return obj;
            }
            ResultKt.throwOnFailure(obj);
            this.label = 1;
            Object objAnimateTo$default = Animatable.animateTo$default(AnalogTimePickerState.this.anim, Boxing.boxFloat(this.$end), this.$animationSpec, null, null, this, 12, null);
            return objAnimateTo$default == coroutine_suspended ? coroutine_suspended : objAnimateTo$default;
        }
    }

    public static /* synthetic */ Object rotateTo$default(AnalogTimePickerState analogTimePickerState, float f, AnimationSpec animationSpec, boolean z, Continuation continuation, int i, Object obj) {
        if ((i & 4) != 0) {
            z = false;
        }
        return analogTimePickerState.rotateTo(f, animationSpec, z, continuation);
    }

    /* JADX INFO: renamed from: androidx.compose.material3.AnalogTimePickerState$rotateTo$2, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: TimePicker.kt */
    @Metadata(d1 = {"\u0000\u0006\n\u0000\n\u0002\u0010\u0000\u0010\u0000\u001a\u00020\u0001H\n"}, d2 = {"<anonymous>", ""}, k = 3, mv = {2, 0, 0}, xi = 48)
    @DebugMetadata(c = "androidx.compose.material3.AnalogTimePickerState$rotateTo$2", f = "TimePicker.kt", i = {}, l = {TypedValues.Custom.TYPE_COLOR, TypedValues.Custom.TYPE_DIMENSION}, m = "invokeSuspend", n = {}, s = {}, v = 1)
    static final class C07172 extends SuspendLambda implements Function1<Continuation<? super Object>, Object> {
        final /* synthetic */ float $angle;
        final /* synthetic */ boolean $animate;
        final /* synthetic */ AnimationSpec<Float> $animationSpec;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C07172(float f, boolean z, AnimationSpec<Float> animationSpec, Continuation<? super C07172> continuation) {
            super(1, continuation);
            this.$angle = f;
            this.$animate = z;
            this.$animationSpec = animationSpec;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Continuation<?> continuation) {
            return AnalogTimePickerState.this.new C07172(this.$angle, this.$animate, this.$animationSpec, continuation);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Object invoke(Continuation<? super Object> continuation) {
            return invoke2((Continuation<Object>) continuation);
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(Continuation<Object> continuation) {
            return ((C07172) create(continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Code restructure failed: missing block: B:22:0x00ac, code lost:
        
            if (r11.this$0.anim.snapTo(kotlin.coroutines.jvm.internal.Boxing.boxFloat(r11.this$0.offsetAngle(r11.$angle)), r11) == r0) goto L28;
         */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final java.lang.Object invokeSuspend(java.lang.Object r12) {
            /*
                Method dump skipped, instruction units count: 220
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.AnalogTimePickerState.C07172.invokeSuspend(java.lang.Object):java.lang.Object");
        }
    }

    public final Object rotateTo(float f, AnimationSpec<Float> animationSpec, boolean z, Continuation<? super Unit> continuation) {
        this.userOverride.setValue(Boxing.boxBoolean(false));
        Object objMutate = this.mutex.mutate(MutatePriority.UserInput, new C07172(f, z, animationSpec, null), continuation);
        return objMutate == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objMutate : Unit.INSTANCE;
    }

    @Override // androidx.compose.material3.TimePickerState
    public int getMinuteInput() {
        return this.state.getMinute();
    }

    @Override // androidx.compose.material3.TimePickerState
    public void setMinuteInput(int i) {
        this.minuteAngle = (i * 0.10471976f) - 1.5707964f;
        this.state.setMinute(i);
        if (TimePickerSelectionMode.m4586equalsimpl0(mo2728getSelectionyecRtBI(), TimePickerSelectionMode.INSTANCE.m4591getMinuteyecRtBI())) {
            this.anim = AnimatableKt.Animatable$default(this.minuteAngle, 0.0f, 2, null);
        }
    }

    @Override // androidx.compose.material3.TimePickerState
    public int getHourInput() {
        return this.state.getHour();
    }

    @Override // androidx.compose.material3.TimePickerState
    public void setHourInput(int i) {
        this.hourAngle = ((i % 12) * 0.5235988f) - 1.5707964f;
        this.state.setHour(i);
        if (TimePickerSelectionMode.m4586equalsimpl0(mo2728getSelectionyecRtBI(), TimePickerSelectionMode.INSTANCE.m4590getHouryecRtBI())) {
            this.anim = AnimatableKt.Animatable$default(this.hourAngle, 0.0f, 2, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final int toHour(float f) {
        return ((int) ((((double) f) + (((double) 0.2617994f) + 1.5707963267948966d)) / ((double) 0.5235988f))) % 12;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final int toMinute(float f) {
        return ((int) ((((double) f) + (((double) 0.05235988f) + 1.5707963267948966d)) / ((double) 0.10471976f))) % 60;
    }

    @Override // androidx.compose.runtime.RememberObserver
    public void onRemembered() {
        this.hourAngle = ((this.state.getHour() % 12) * 0.5235988f) - 1.5707964f;
        this.minuteAngle = (this.state.getMinute() * 0.10471976f) - 1.5707964f;
        this.anim = AnimatableKt.Animatable$default(TimePickerSelectionMode.m4586equalsimpl0(this.state.mo2728getSelectionyecRtBI(), TimePickerSelectionMode.INSTANCE.m4590getHouryecRtBI()) ? this.hourAngle : this.minuteAngle, 0.0f, 2, null);
    }
}
