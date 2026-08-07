package androidx.compose.foundation.gestures;

import androidx.compose.foundation.ComposeFoundationFlags;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.input.pointer.AwaitPointerEventScope;
import androidx.compose.ui.input.pointer.PointerEvent;
import androidx.compose.ui.input.pointer.PointerEventKt;
import androidx.compose.ui.input.pointer.PointerEventPass;
import androidx.compose.ui.input.pointer.PointerEventTimeoutCancellationException;
import androidx.compose.ui.input.pointer.PointerEvent_androidKt;
import androidx.compose.ui.input.pointer.PointerInputChange;
import androidx.compose.ui.input.pointer.PointerInputScope;
import androidx.compose.ui.input.pointer.PointerType;
import com.box.brownfieldApi.featuresNavigator.activities.ReactNativeFeatureActivity;
import external.sdk.pendo.io.mozilla.javascript.Token;
import java.util.List;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.ReplaceWith;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.RestrictedSuspendLambda;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Job;

/* JADX INFO: compiled from: TapGestureDetector.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000|\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u008b\u0001\u0010\t\u001a\u00020\u0005*\u00020\n2\u0016\b\u0002\u0010\u000b\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0005\u0018\u00010\f2\u0016\b\u0002\u0010\r\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0005\u0018\u00010\f2/\b\u0002\u0010\u000e\u001a)\b\u0001\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0003\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u0001¢\u0006\u0002\b\u00072\u0016\b\u0002\u0010\u000f\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0005\u0018\u00010\fH\u0086@¢\u0006\u0002\u0010\u0010\u001a\u0012\u0010\u0011\u001a\u00020\u0005*\u00020\u0012H\u0082@¢\u0006\u0002\u0010\u0013\u001a\u001c\u0010\u0014\u001a\u0004\u0018\u00010\u0015*\u00020\u00122\u0006\u0010\u0016\u001a\u00020\u0015H\u0082@¢\u0006\u0002\u0010\u0017\u001a[\u0010\u0018\u001a\u00020\u0005*\u00020\n2/\b\u0002\u0010\u000e\u001a)\b\u0001\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0003\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u0001¢\u0006\u0002\b\u00072\u0016\b\u0002\u0010\u000f\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0005\u0018\u00010\fH\u0080@¢\u0006\u0002\u0010\u0019\u001a\u001c\u0010\u001a\u001a\u00020\u0015*\u00020\u00122\b\b\u0002\u0010\u001b\u001a\u00020\u001cH\u0087@¢\u0006\u0002\u0010\u001d\u001a&\u0010\u001a\u001a\u00020\u0015*\u00020\u00122\b\b\u0002\u0010\u001b\u001a\u00020\u001c2\b\b\u0002\u0010\u001e\u001a\u00020\u001fH\u0086@¢\u0006\u0002\u0010 \u001a&\u0010!\u001a\u00020\u0015*\u00020\u00122\b\b\u0002\u0010\u001b\u001a\u00020\u001c2\b\b\u0002\u0010\u001e\u001a\u00020\u001fH\u0080@¢\u0006\u0002\u0010 \u001a\u001e\u0010\"\u001a\u00020\u001c*\u00020#2\u0006\u0010\u001b\u001a\u00020\u001c2\b\b\u0002\u0010$\u001a\u00020\u001cH\u0000\u001a\u0014\u0010%\u001a\u0004\u0018\u00010\u0015*\u00020\u0012H\u0087@¢\u0006\u0002\u0010\u0013\u001a\u001e\u0010%\u001a\u0004\u0018\u00010\u0015*\u00020\u00122\b\b\u0002\u0010\u001e\u001a\u00020\u001fH\u0086@¢\u0006\u0002\u0010&\u001a\u001c\u0010'\u001a\u00020(*\u00020\u00122\b\b\u0002\u0010\u001e\u001a\u00020\u001fH\u0080@¢\u0006\u0002\u0010&\u001aL\u00106\u001a\u000207*\u0002082\u0006\u00109\u001a\u0002072\b\b\u0002\u0010:\u001a\u0002022'\u0010;\u001a#\b\u0001\u0012\u0004\u0012\u000208\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u00060<¢\u0006\u0002\b\u0007H\u0002¢\u0006\u0002\u0010=\"7\u0010\u0000\u001a)\b\u0001\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0003\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u0001¢\u0006\u0002\b\u0007X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\b\"*\u0010*\u001a\u00020\u001c2\u0006\u0010)\u001a\u00020\u001c8F@FX\u0087\u000e¢\u0006\u0012\u0012\u0004\b+\u0010,\u001a\u0004\b-\u0010.\"\u0004\b/\u00100\"\u001a\u00101\u001a\u0002028BX\u0082\u0004¢\u0006\f\u0012\u0004\b3\u0010,\u001a\u0004\b4\u00105¨\u0006>"}, d2 = {"NoPressGesture", "Lkotlin/Function3;", "Landroidx/compose/foundation/gestures/PressGestureScope;", "Landroidx/compose/ui/geometry/Offset;", "Lkotlin/coroutines/Continuation;", "", "", "Lkotlin/ExtensionFunctionType;", "Lkotlin/jvm/functions/Function3;", "detectTapGestures", "Landroidx/compose/ui/input/pointer/PointerInputScope;", "onDoubleTap", "Lkotlin/Function1;", "onLongPress", "onPress", "onTap", "(Landroidx/compose/ui/input/pointer/PointerInputScope;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function3;Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "consumeUntilUp", "Landroidx/compose/ui/input/pointer/AwaitPointerEventScope;", "(Landroidx/compose/ui/input/pointer/AwaitPointerEventScope;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "awaitSecondDown", "Landroidx/compose/ui/input/pointer/PointerInputChange;", "firstUp", "(Landroidx/compose/ui/input/pointer/AwaitPointerEventScope;Landroidx/compose/ui/input/pointer/PointerInputChange;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "detectTapAndPress", "(Landroidx/compose/ui/input/pointer/PointerInputScope;Lkotlin/jvm/functions/Function3;Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "awaitFirstDown", "requireUnconsumed", "", "(Landroidx/compose/ui/input/pointer/AwaitPointerEventScope;ZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "pass", "Landroidx/compose/ui/input/pointer/PointerEventPass;", "(Landroidx/compose/ui/input/pointer/AwaitPointerEventScope;ZLandroidx/compose/ui/input/pointer/PointerEventPass;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "awaitPrimaryFirstDown", "isChangedToDown", "Landroidx/compose/ui/input/pointer/PointerEvent;", "onlyPrimaryMouseButton", "waitForUpOrCancellation", "(Landroidx/compose/ui/input/pointer/AwaitPointerEventScope;Landroidx/compose/ui/input/pointer/PointerEventPass;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "waitForLongPress", "Landroidx/compose/foundation/gestures/LongPressResult;", "value", "DetectTapGesturesEnableNewDispatchingBehavior", "getDetectTapGesturesEnableNewDispatchingBehavior$annotations", "()V", "getDetectTapGesturesEnableNewDispatchingBehavior", "()Z", "setDetectTapGesturesEnableNewDispatchingBehavior", "(Z)V", "coroutineStartForCurrentDispatchBehavior", "Lkotlinx/coroutines/CoroutineStart;", "getCoroutineStartForCurrentDispatchBehavior$annotations", "getCoroutineStartForCurrentDispatchBehavior", "()Lkotlinx/coroutines/CoroutineStart;", "launchAwaitingReset", "Lkotlinx/coroutines/Job;", "Lkotlinx/coroutines/CoroutineScope;", "resetJob", "start", "block", "Lkotlin/Function2;", "(Lkotlinx/coroutines/CoroutineScope;Lkotlinx/coroutines/Job;Lkotlinx/coroutines/CoroutineStart;Lkotlin/jvm/functions/Function2;)Lkotlinx/coroutines/Job;", "foundation"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class TapGestureDetectorKt {
    private static final Function3<PressGestureScope, Offset, Continuation<? super Unit>, Object> NoPressGesture = new TapGestureDetectorKt$NoPressGesture$1(null);

    /* JADX INFO: renamed from: androidx.compose.foundation.gestures.TapGestureDetectorKt$awaitFirstDown$2, reason: invalid class name */
    /* JADX INFO: compiled from: TapGestureDetector.kt */
    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    @DebugMetadata(c = "androidx.compose.foundation.gestures.TapGestureDetectorKt", f = "TapGestureDetector.kt", i = {0, 0, 0}, l = {291}, m = "awaitFirstDown", n = {"$this$awaitFirstDown", "pass", "requireUnconsumed"}, s = {"L$0", "L$1", "Z$0"}, v = 1)
    static final class AnonymousClass2 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        boolean Z$0;
        int label;
        /* synthetic */ Object result;

        AnonymousClass2(Continuation<? super AnonymousClass2> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return TapGestureDetectorKt.awaitFirstDown(null, false, null, this);
        }
    }

    /* JADX INFO: renamed from: androidx.compose.foundation.gestures.TapGestureDetectorKt$awaitPrimaryFirstDown$1, reason: invalid class name */
    /* JADX INFO: compiled from: TapGestureDetector.kt */
    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    @DebugMetadata(c = "androidx.compose.foundation.gestures.TapGestureDetectorKt", f = "TapGestureDetector.kt", i = {0, 0, 0}, l = {304}, m = "awaitPrimaryFirstDown", n = {"$this$awaitPrimaryFirstDown", "pass", "requireUnconsumed"}, s = {"L$0", "L$1", "Z$0"}, v = 1)
    static final class AnonymousClass1 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        boolean Z$0;
        int label;
        /* synthetic */ Object result;

        AnonymousClass1(Continuation<? super AnonymousClass1> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return TapGestureDetectorKt.awaitPrimaryFirstDown(null, false, null, this);
        }
    }

    /* JADX INFO: renamed from: androidx.compose.foundation.gestures.TapGestureDetectorKt$consumeUntilUp$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: TapGestureDetector.kt */
    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    @DebugMetadata(c = "androidx.compose.foundation.gestures.TapGestureDetectorKt", f = "TapGestureDetector.kt", i = {0}, l = {209}, m = "consumeUntilUp", n = {"$this$consumeUntilUp"}, s = {"L$0"}, v = 1)
    static final class C06271 extends ContinuationImpl {
        Object L$0;
        int label;
        /* synthetic */ Object result;

        C06271(Continuation<? super C06271> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return TapGestureDetectorKt.consumeUntilUp(null, this);
        }
    }

    /* JADX INFO: renamed from: androidx.compose.foundation.gestures.TapGestureDetectorKt$waitForLongPress$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: TapGestureDetector.kt */
    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    @DebugMetadata(c = "androidx.compose.foundation.gestures.TapGestureDetectorKt", f = "TapGestureDetector.kt", i = {0}, l = {384}, m = "waitForLongPress", n = {ReactNativeFeatureActivity.RESULT_EXTRA_KEY}, s = {"L$0"}, v = 1)
    static final class C06311 extends ContinuationImpl {
        Object L$0;
        int label;
        /* synthetic */ Object result;

        C06311(Continuation<? super C06311> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return TapGestureDetectorKt.waitForLongPress(null, null, this);
        }
    }

    /* JADX INFO: renamed from: androidx.compose.foundation.gestures.TapGestureDetectorKt$waitForUpOrCancellation$2, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: TapGestureDetector.kt */
    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    @DebugMetadata(c = "androidx.compose.foundation.gestures.TapGestureDetectorKt", f = "TapGestureDetector.kt", i = {0, 0, 1, 1}, l = {352, 366}, m = "waitForUpOrCancellation", n = {"$this$waitForUpOrCancellation", "pass", "$this$waitForUpOrCancellation", "pass"}, s = {"L$0", "L$1", "L$0", "L$1"}, v = 1)
    static final class C06332 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        int label;
        /* synthetic */ Object result;

        C06332(Continuation<? super C06332> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return TapGestureDetectorKt.waitForUpOrCancellation(null, null, this);
        }
    }

    private static /* synthetic */ void getCoroutineStartForCurrentDispatchBehavior$annotations() {
    }

    @Deprecated(message = "This flag has been moved to ComposeFoundationFlags and renamed to isDetectTapGesturesImmediateCoroutineDispatchEnabled. For compatibility,  DetectTapGesturesEnableNewDispatchingBehavior controls the new flag (isDetectTapGesturesImmediateCoroutineDispatchEnabled). Please use  isDetectTapGesturesImmediateCoroutineDispatchEnabled instead.", replaceWith = @ReplaceWith(expression = "isDetectTapGesturesImmediateCoroutineDispatchEnabled", imports = {"androidx.compose.foundation.ComposeFoundationFlags.isDetectTapGesturesImmediateCoroutineDispatchEnabled"}))
    public static /* synthetic */ void getDetectTapGesturesEnableNewDispatchingBehavior$annotations() {
    }

    public static /* synthetic */ Object detectTapGestures$default(PointerInputScope pointerInputScope, Function1 function1, Function1 function2, Function3 function3, Function1 function4, Continuation continuation, int i, Object obj) {
        if ((i & 1) != 0) {
            function1 = null;
        }
        if ((i & 2) != 0) {
            function2 = null;
        }
        if ((i & 4) != 0) {
            function3 = NoPressGesture;
        }
        if ((i & 8) != 0) {
            function4 = null;
        }
        return detectTapGestures(pointerInputScope, function1, function2, function3, function4, continuation);
    }

    /* JADX INFO: renamed from: androidx.compose.foundation.gestures.TapGestureDetectorKt$detectTapGestures$2, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: TapGestureDetector.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
    @DebugMetadata(c = "androidx.compose.foundation.gestures.TapGestureDetectorKt$detectTapGestures$2", f = "TapGestureDetector.kt", i = {}, l = {104}, m = "invokeSuspend", n = {}, s = {}, v = 1)
    static final class C06292 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ Function1<Offset, Unit> $onDoubleTap;
        final /* synthetic */ Function1<Offset, Unit> $onLongPress;
        final /* synthetic */ Function3<PressGestureScope, Offset, Continuation<? super Unit>, Object> $onPress;
        final /* synthetic */ Function1<Offset, Unit> $onTap;
        final /* synthetic */ PointerInputScope $this_detectTapGestures;
        private /* synthetic */ Object L$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        C06292(PointerInputScope pointerInputScope, Function3<? super PressGestureScope, ? super Offset, ? super Continuation<? super Unit>, ? extends Object> function3, Function1<? super Offset, Unit> function1, Function1<? super Offset, Unit> function2, Function1<? super Offset, Unit> function4, Continuation<? super C06292> continuation) {
            super(2, continuation);
            this.$this_detectTapGestures = pointerInputScope;
            this.$onPress = function3;
            this.$onLongPress = function1;
            this.$onDoubleTap = function2;
            this.$onTap = function4;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            C06292 c06292 = new C06292(this.$this_detectTapGestures, this.$onPress, this.$onLongPress, this.$onDoubleTap, this.$onTap, continuation);
            c06292.L$0 = obj;
            return c06292;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C06292) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                CoroutineScope coroutineScope = (CoroutineScope) this.L$0;
                PressGestureScopeImpl pressGestureScopeImpl = new PressGestureScopeImpl(this.$this_detectTapGestures);
                this.label = 1;
                if (ForEachGestureKt.awaitEachGesture(this.$this_detectTapGestures, new AnonymousClass1(coroutineScope, this.$onPress, this.$onLongPress, this.$onDoubleTap, this.$onTap, pressGestureScopeImpl, null), this) == coroutine_suspended) {
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

        /* JADX INFO: renamed from: androidx.compose.foundation.gestures.TapGestureDetectorKt$detectTapGestures$2$1, reason: invalid class name */
        /* JADX INFO: compiled from: TapGestureDetector.kt */
        @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Landroidx/compose/ui/input/pointer/AwaitPointerEventScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
        @DebugMetadata(c = "androidx.compose.foundation.gestures.TapGestureDetectorKt$detectTapGestures$2$1", f = "TapGestureDetector.kt", i = {0, 1, 1, 2, 2, 2, 3, 4, 4, 4, 5, 5, 6, 6, 6, 6, 7}, l = {105, 116, 119, 122, Token.XMLEND, Token.LAST_TOKEN, 169, 180}, m = "invokeSuspend", n = {"$this$awaitEachGesture", "$this$awaitEachGesture", "resetJob", "$this$awaitEachGesture", "down", "resetJob", "resetJob", "$this$awaitEachGesture", "upOrCancel", "cancelOrReleaseJob", "resetJob", "upOrCancel", "$this$awaitEachGesture", "resetJob", "upOrCancel", "secondDown", "resetJob"}, s = {"L$0", "L$0", "L$1", "L$0", "L$1", "L$2", "L$0", "L$0", "L$1", "L$2", "L$0", "L$1", "L$0", "L$1", "L$2", "L$3", "L$0"}, v = 1)
        static final class AnonymousClass1 extends RestrictedSuspendLambda implements Function2<AwaitPointerEventScope, Continuation<? super Unit>, Object> {
            final /* synthetic */ CoroutineScope $$this$coroutineScope;
            final /* synthetic */ Function1<Offset, Unit> $onDoubleTap;
            final /* synthetic */ Function1<Offset, Unit> $onLongPress;
            final /* synthetic */ Function3<PressGestureScope, Offset, Continuation<? super Unit>, Object> $onPress;
            final /* synthetic */ Function1<Offset, Unit> $onTap;
            final /* synthetic */ PressGestureScopeImpl $pressScope;
            private /* synthetic */ Object L$0;
            Object L$1;
            Object L$2;
            Object L$3;
            int label;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            AnonymousClass1(CoroutineScope coroutineScope, Function3<? super PressGestureScope, ? super Offset, ? super Continuation<? super Unit>, ? extends Object> function3, Function1<? super Offset, Unit> function1, Function1<? super Offset, Unit> function2, Function1<? super Offset, Unit> function4, PressGestureScopeImpl pressGestureScopeImpl, Continuation<? super AnonymousClass1> continuation) {
                super(2, continuation);
                this.$$this$coroutineScope = coroutineScope;
                this.$onPress = function3;
                this.$onLongPress = function1;
                this.$onDoubleTap = function2;
                this.$onTap = function4;
                this.$pressScope = pressGestureScopeImpl;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                AnonymousClass1 anonymousClass1 = new AnonymousClass1(this.$$this$coroutineScope, this.$onPress, this.$onLongPress, this.$onDoubleTap, this.$onTap, this.$pressScope, continuation);
                anonymousClass1.L$0 = obj;
                return anonymousClass1;
            }

            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(AwaitPointerEventScope awaitPointerEventScope, Continuation<? super Unit> continuation) {
                return ((AnonymousClass1) create(awaitPointerEventScope, continuation)).invokeSuspend(Unit.INSTANCE);
            }

            /* JADX WARN: Code duplicated, block: B:103:0x02f0  */
            /* JADX WARN: Code duplicated, block: B:20:0x00d5  */
            /* JADX WARN: Code duplicated, block: B:23:0x00f0  */
            /* JADX WARN: Code duplicated, block: B:26:0x0102  */
            /* JADX WARN: Code duplicated, block: B:29:0x0107  */
            /* JADX WARN: Code duplicated, block: B:32:0x011b A[PHI: r2 r5 r6 r14
              0x011b: PHI (r2v24 java.lang.Object) = (r2v9 java.lang.Object), (r2v37 java.lang.Object) binds: [B:30:0x0117, B:11:0x0065] A[DONT_GENERATE, DONT_INLINE]
              0x011b: PHI (r5v11 androidx.compose.ui.input.pointer.PointerInputChange) = 
              (r5v3 androidx.compose.ui.input.pointer.PointerInputChange)
              (r5v15 androidx.compose.ui.input.pointer.PointerInputChange)
             binds: [B:30:0x0117, B:11:0x0065] A[DONT_GENERATE, DONT_INLINE]
              0x011b: PHI (r6v10 androidx.compose.ui.input.pointer.AwaitPointerEventScope) = 
              (r6v2 androidx.compose.ui.input.pointer.AwaitPointerEventScope)
              (r6v13 androidx.compose.ui.input.pointer.AwaitPointerEventScope)
             binds: [B:30:0x0117, B:11:0x0065] A[DONT_GENERATE, DONT_INLINE]
              0x011b: PHI (r14v4 kotlinx.coroutines.Job) = (r14v0 kotlinx.coroutines.Job), (r14v5 kotlinx.coroutines.Job) binds: [B:30:0x0117, B:11:0x0065] A[DONT_GENERATE, DONT_INLINE]] */
            /* JADX WARN: Code duplicated, block: B:34:0x0125  */
            /* JADX WARN: Code duplicated, block: B:37:0x0146  */
            /* JADX WARN: Code duplicated, block: B:40:0x015c  */
            /* JADX WARN: Code duplicated, block: B:42:0x0160  */
            /* JADX WARN: Code duplicated, block: B:43:0x0167  */
            /* JADX WARN: Code duplicated, block: B:45:0x016b  */
            /* JADX WARN: Code duplicated, block: B:48:0x0170  */
            /* JADX WARN: Code duplicated, block: B:49:0x0184  */
            /* JADX WARN: Code duplicated, block: B:51:0x019c  */
            /* JADX WARN: Code duplicated, block: B:53:0x01a0  */
            /* JADX WARN: Code duplicated, block: B:55:0x01a4  */
            /* JADX WARN: Code duplicated, block: B:56:0x01b1  */
            /* JADX WARN: Code duplicated, block: B:59:0x01c5  */
            /* JADX WARN: Code duplicated, block: B:62:0x01cf  */
            /* JADX WARN: Code duplicated, block: B:64:0x01d3  */
            /* JADX WARN: Code duplicated, block: B:65:0x01e0  */
            /* JADX WARN: Code duplicated, block: B:67:0x01ff  */
            /* JADX WARN: Code duplicated, block: B:70:0x021b  */
            /* JADX WARN: Code duplicated, block: B:73:0x022e  */
            /* JADX WARN: Code duplicated, block: B:76:0x0234  */
            /* JADX WARN: Code duplicated, block: B:79:0x0249  */
            /* JADX WARN: Code duplicated, block: B:82:0x0254  */
            /* JADX WARN: Code duplicated, block: B:85:0x0277  */
            /* JADX WARN: Code duplicated, block: B:88:0x028d  */
            /* JADX WARN: Code duplicated, block: B:90:0x0291  */
            /* JADX WARN: Code duplicated, block: B:91:0x0299  */
            /* JADX WARN: Code duplicated, block: B:93:0x029d  */
            /* JADX WARN: Code duplicated, block: B:95:0x02a2  */
            /* JADX WARN: Code duplicated, block: B:96:0x02c5  */
            /* JADX WARN: Code duplicated, block: B:98:0x02db  */
            /* JADX WARN: Code duplicated, block: B:99:0x02e7  */
            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object obj) {
                Object objAwaitFirstDown$default;
                AwaitPointerEventScope awaitPointerEventScope;
                PointerInputChange pointerInputChange;
                Job jobLaunch$default;
                Object objWaitForLongPress$default;
                Object objWaitForUpOrCancellation$default;
                AwaitPointerEventScope awaitPointerEventScope2;
                PointerInputChange finalUpChange;
                Job job;
                Job jobLaunchAwaitingReset$default;
                Object objAwaitSecondDown;
                PointerInputChange pointerInputChange2;
                Job job2;
                AwaitPointerEventScope awaitPointerEventScope3;
                Function1<Offset, Unit> function1;
                LongPressResult longPressResult;
                Job job3;
                PointerInputChange pointerInputChange3;
                Job jobLaunch$default2;
                Object objWaitForLongPress$default2;
                PointerInputChange pointerInputChange4;
                Object objWaitForUpOrCancellation$default2;
                PointerInputChange pointerInputChange5;
                Function1<Offset, Unit> function2;
                PointerInputChange finalUpChange2;
                Job job4;
                Function1<Offset, Unit> function3;
                LongPressResult longPressResult2;
                Job job5;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                switch (this.label) {
                    case 0:
                        ResultKt.throwOnFailure(obj);
                        AwaitPointerEventScope awaitPointerEventScope4 = (AwaitPointerEventScope) this.L$0;
                        this.L$0 = awaitPointerEventScope4;
                        this.label = 1;
                        objAwaitFirstDown$default = TapGestureDetectorKt.awaitFirstDown$default(awaitPointerEventScope4, false, null, this, 3, null);
                        if (objAwaitFirstDown$default != coroutine_suspended) {
                            awaitPointerEventScope = awaitPointerEventScope4;
                            pointerInputChange = (PointerInputChange) objAwaitFirstDown$default;
                            pointerInputChange.consume();
                            jobLaunch$default = BuildersKt__Builders_commonKt.launch$default(this.$$this$coroutineScope, null, TapGestureDetectorKt.getCoroutineStartForCurrentDispatchBehavior(), new TapGestureDetectorKt$detectTapGestures$2$1$resetJob$1(this.$pressScope, null), 1, null);
                            if (this.$onPress != TapGestureDetectorKt.NoPressGesture) {
                                TapGestureDetectorKt.launchAwaitingReset$default(this.$$this$coroutineScope, jobLaunch$default, null, new C00221(this.$onPress, this.$pressScope, pointerInputChange, null), 2, null);
                            }
                            if (this.$onLongPress == null) {
                                this.L$0 = awaitPointerEventScope;
                                this.L$1 = jobLaunch$default;
                                this.label = 2;
                                objWaitForUpOrCancellation$default = TapGestureDetectorKt.waitForUpOrCancellation$default(awaitPointerEventScope, null, this, 1, null);
                                if (objWaitForUpOrCancellation$default != coroutine_suspended) {
                                    awaitPointerEventScope2 = awaitPointerEventScope;
                                    finalUpChange = (PointerInputChange) objWaitForUpOrCancellation$default;
                                    job = jobLaunch$default;
                                    if (finalUpChange == null) {
                                        jobLaunchAwaitingReset$default = TapGestureDetectorKt.launchAwaitingReset$default(this.$$this$coroutineScope, job, null, new AnonymousClass3(this.$pressScope, null), 2, null);
                                    } else {
                                        finalUpChange.consume();
                                        jobLaunchAwaitingReset$default = TapGestureDetectorKt.launchAwaitingReset$default(this.$$this$coroutineScope, job, null, new AnonymousClass4(this.$pressScope, null), 2, null);
                                    }
                                    if (finalUpChange != null) {
                                        if (this.$onDoubleTap != null) {
                                            function1 = this.$onTap;
                                            if (function1 != null) {
                                                function1.invoke(Offset.m6558boximpl(finalUpChange.getPosition()));
                                            }
                                        } else {
                                            this.L$0 = awaitPointerEventScope2;
                                            this.L$1 = finalUpChange;
                                            this.L$2 = jobLaunchAwaitingReset$default;
                                            this.label = 5;
                                            objAwaitSecondDown = TapGestureDetectorKt.awaitSecondDown(awaitPointerEventScope2, finalUpChange, this);
                                            if (objAwaitSecondDown != coroutine_suspended) {
                                                AwaitPointerEventScope awaitPointerEventScope5 = awaitPointerEventScope2;
                                                pointerInputChange2 = finalUpChange;
                                                job2 = jobLaunchAwaitingReset$default;
                                                awaitPointerEventScope3 = awaitPointerEventScope5;
                                                pointerInputChange3 = (PointerInputChange) objAwaitSecondDown;
                                                if (pointerInputChange3 != null) {
                                                    function2 = this.$onTap;
                                                    if (function2 != null) {
                                                        function2.invoke(Offset.m6558boximpl(pointerInputChange2.getPosition()));
                                                    }
                                                } else {
                                                    jobLaunch$default2 = BuildersKt__Builders_commonKt.launch$default(this.$$this$coroutineScope, null, TapGestureDetectorKt.getCoroutineStartForCurrentDispatchBehavior(), new AnonymousClass5(job2, this.$pressScope, null), 1, null);
                                                    if (this.$onPress != TapGestureDetectorKt.NoPressGesture) {
                                                        TapGestureDetectorKt.launchAwaitingReset$default(this.$$this$coroutineScope, jobLaunch$default2, null, new AnonymousClass6(this.$onPress, this.$pressScope, pointerInputChange3, null), 2, null);
                                                    }
                                                    if (this.$onLongPress == null) {
                                                        this.L$0 = jobLaunch$default2;
                                                        this.L$1 = pointerInputChange2;
                                                        this.L$2 = null;
                                                        this.label = 6;
                                                        objWaitForUpOrCancellation$default2 = TapGestureDetectorKt.waitForUpOrCancellation$default(awaitPointerEventScope3, null, this, 1, null);
                                                        if (objWaitForUpOrCancellation$default2 != coroutine_suspended) {
                                                            pointerInputChange5 = pointerInputChange2;
                                                            finalUpChange2 = (PointerInputChange) objWaitForUpOrCancellation$default2;
                                                            job4 = jobLaunch$default2;
                                                            if (finalUpChange2 != null) {
                                                                finalUpChange2.consume();
                                                                TapGestureDetectorKt.launchAwaitingReset$default(this.$$this$coroutineScope, job4, null, new AnonymousClass7(this.$pressScope, null), 2, null);
                                                                this.$onDoubleTap.invoke(Offset.m6558boximpl(finalUpChange2.getPosition()));
                                                            } else {
                                                                TapGestureDetectorKt.launchAwaitingReset$default(this.$$this$coroutineScope, job4, null, new AnonymousClass8(this.$pressScope, null), 2, null);
                                                                function3 = this.$onTap;
                                                                if (function3 != null) {
                                                                    function3.invoke(Offset.m6558boximpl(pointerInputChange5.getPosition()));
                                                                }
                                                            }
                                                        }
                                                    } else {
                                                        this.L$0 = awaitPointerEventScope3;
                                                        this.L$1 = jobLaunch$default2;
                                                        this.L$2 = pointerInputChange2;
                                                        this.L$3 = pointerInputChange3;
                                                        this.label = 7;
                                                        objWaitForLongPress$default2 = TapGestureDetectorKt.waitForLongPress$default(awaitPointerEventScope3, null, this, 1, null);
                                                        if (objWaitForLongPress$default2 != coroutine_suspended) {
                                                            pointerInputChange4 = pointerInputChange2;
                                                            longPressResult2 = (LongPressResult) objWaitForLongPress$default2;
                                                            if (Intrinsics.areEqual(longPressResult2, LongPressResult.Success.INSTANCE)) {
                                                                this.$onLongPress.invoke(Offset.m6558boximpl(pointerInputChange3.getPosition()));
                                                                this.L$0 = jobLaunch$default2;
                                                                this.L$1 = null;
                                                                this.L$2 = null;
                                                                this.L$3 = null;
                                                                this.label = 8;
                                                                if (TapGestureDetectorKt.consumeUntilUp(awaitPointerEventScope3, this) != coroutine_suspended) {
                                                                    job5 = jobLaunch$default2;
                                                                    TapGestureDetectorKt.launchAwaitingReset$default(this.$$this$coroutineScope, job5, null, new TapGestureDetectorKt$detectTapGestures$2$1$secondUp$1(this.$pressScope, null), 2, null);
                                                                    return Unit.INSTANCE;
                                                                }
                                                            } else {
                                                                if (longPressResult2 instanceof LongPressResult.Released) {
                                                                    finalUpChange2 = ((LongPressResult.Released) longPressResult2).getFinalUpChange();
                                                                    pointerInputChange5 = pointerInputChange4;
                                                                } else {
                                                                    if (longPressResult2 instanceof LongPressResult.Canceled) {
                                                                        throw new NoWhenBranchMatchedException();
                                                                    }
                                                                    pointerInputChange5 = pointerInputChange4;
                                                                    finalUpChange2 = null;
                                                                }
                                                                job4 = jobLaunch$default2;
                                                                if (finalUpChange2 != null) {
                                                                    finalUpChange2.consume();
                                                                    TapGestureDetectorKt.launchAwaitingReset$default(this.$$this$coroutineScope, job4, null, new AnonymousClass7(this.$pressScope, null), 2, null);
                                                                    this.$onDoubleTap.invoke(Offset.m6558boximpl(finalUpChange2.getPosition()));
                                                                } else {
                                                                    TapGestureDetectorKt.launchAwaitingReset$default(this.$$this$coroutineScope, job4, null, new AnonymousClass8(this.$pressScope, null), 2, null);
                                                                    function3 = this.$onTap;
                                                                    if (function3 != null) {
                                                                        function3.invoke(Offset.m6558boximpl(pointerInputChange5.getPosition()));
                                                                    }
                                                                }
                                                            }
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                    }
                                    return Unit.INSTANCE;
                                }
                            } else {
                                this.L$0 = awaitPointerEventScope;
                                this.L$1 = pointerInputChange;
                                this.L$2 = jobLaunch$default;
                                this.label = 3;
                                objWaitForLongPress$default = TapGestureDetectorKt.waitForLongPress$default(awaitPointerEventScope, null, this, 1, null);
                                if (objWaitForLongPress$default != coroutine_suspended) {
                                    longPressResult = (LongPressResult) objWaitForLongPress$default;
                                    if (!Intrinsics.areEqual(longPressResult, LongPressResult.Success.INSTANCE)) {
                                        if (longPressResult instanceof LongPressResult.Released) {
                                            finalUpChange = ((LongPressResult.Released) longPressResult).getFinalUpChange();
                                        } else {
                                            if (!(longPressResult instanceof LongPressResult.Canceled)) {
                                                throw new NoWhenBranchMatchedException();
                                            }
                                            finalUpChange = null;
                                        }
                                        awaitPointerEventScope2 = awaitPointerEventScope;
                                        job = jobLaunch$default;
                                        if (finalUpChange == null) {
                                            jobLaunchAwaitingReset$default = TapGestureDetectorKt.launchAwaitingReset$default(this.$$this$coroutineScope, job, null, new AnonymousClass3(this.$pressScope, null), 2, null);
                                        } else {
                                            finalUpChange.consume();
                                            jobLaunchAwaitingReset$default = TapGestureDetectorKt.launchAwaitingReset$default(this.$$this$coroutineScope, job, null, new AnonymousClass4(this.$pressScope, null), 2, null);
                                        }
                                        if (finalUpChange != null) {
                                            if (this.$onDoubleTap != null) {
                                                function1 = this.$onTap;
                                                if (function1 != null) {
                                                    function1.invoke(Offset.m6558boximpl(finalUpChange.getPosition()));
                                                }
                                            } else {
                                                this.L$0 = awaitPointerEventScope2;
                                                this.L$1 = finalUpChange;
                                                this.L$2 = jobLaunchAwaitingReset$default;
                                                this.label = 5;
                                                objAwaitSecondDown = TapGestureDetectorKt.awaitSecondDown(awaitPointerEventScope2, finalUpChange, this);
                                                if (objAwaitSecondDown != coroutine_suspended) {
                                                    AwaitPointerEventScope awaitPointerEventScope6 = awaitPointerEventScope2;
                                                    pointerInputChange2 = finalUpChange;
                                                    job2 = jobLaunchAwaitingReset$default;
                                                    awaitPointerEventScope3 = awaitPointerEventScope6;
                                                    pointerInputChange3 = (PointerInputChange) objAwaitSecondDown;
                                                    if (pointerInputChange3 != null) {
                                                        function2 = this.$onTap;
                                                        if (function2 != null) {
                                                            function2.invoke(Offset.m6558boximpl(pointerInputChange2.getPosition()));
                                                        }
                                                    } else {
                                                        jobLaunch$default2 = BuildersKt__Builders_commonKt.launch$default(this.$$this$coroutineScope, null, TapGestureDetectorKt.getCoroutineStartForCurrentDispatchBehavior(), new AnonymousClass5(job2, this.$pressScope, null), 1, null);
                                                        if (this.$onPress != TapGestureDetectorKt.NoPressGesture) {
                                                            TapGestureDetectorKt.launchAwaitingReset$default(this.$$this$coroutineScope, jobLaunch$default2, null, new AnonymousClass6(this.$onPress, this.$pressScope, pointerInputChange3, null), 2, null);
                                                        }
                                                        if (this.$onLongPress == null) {
                                                            this.L$0 = jobLaunch$default2;
                                                            this.L$1 = pointerInputChange2;
                                                            this.L$2 = null;
                                                            this.label = 6;
                                                            objWaitForUpOrCancellation$default2 = TapGestureDetectorKt.waitForUpOrCancellation$default(awaitPointerEventScope3, null, this, 1, null);
                                                            if (objWaitForUpOrCancellation$default2 != coroutine_suspended) {
                                                                pointerInputChange5 = pointerInputChange2;
                                                                finalUpChange2 = (PointerInputChange) objWaitForUpOrCancellation$default2;
                                                                job4 = jobLaunch$default2;
                                                                if (finalUpChange2 != null) {
                                                                    finalUpChange2.consume();
                                                                    TapGestureDetectorKt.launchAwaitingReset$default(this.$$this$coroutineScope, job4, null, new AnonymousClass7(this.$pressScope, null), 2, null);
                                                                    this.$onDoubleTap.invoke(Offset.m6558boximpl(finalUpChange2.getPosition()));
                                                                } else {
                                                                    TapGestureDetectorKt.launchAwaitingReset$default(this.$$this$coroutineScope, job4, null, new AnonymousClass8(this.$pressScope, null), 2, null);
                                                                    function3 = this.$onTap;
                                                                    if (function3 != null) {
                                                                        function3.invoke(Offset.m6558boximpl(pointerInputChange5.getPosition()));
                                                                    }
                                                                }
                                                            }
                                                        } else {
                                                            this.L$0 = awaitPointerEventScope3;
                                                            this.L$1 = jobLaunch$default2;
                                                            this.L$2 = pointerInputChange2;
                                                            this.L$3 = pointerInputChange3;
                                                            this.label = 7;
                                                            objWaitForLongPress$default2 = TapGestureDetectorKt.waitForLongPress$default(awaitPointerEventScope3, null, this, 1, null);
                                                            if (objWaitForLongPress$default2 != coroutine_suspended) {
                                                                pointerInputChange4 = pointerInputChange2;
                                                                longPressResult2 = (LongPressResult) objWaitForLongPress$default2;
                                                                if (Intrinsics.areEqual(longPressResult2, LongPressResult.Success.INSTANCE)) {
                                                                    this.$onLongPress.invoke(Offset.m6558boximpl(pointerInputChange3.getPosition()));
                                                                    this.L$0 = jobLaunch$default2;
                                                                    this.L$1 = null;
                                                                    this.L$2 = null;
                                                                    this.L$3 = null;
                                                                    this.label = 8;
                                                                    if (TapGestureDetectorKt.consumeUntilUp(awaitPointerEventScope3, this) != coroutine_suspended) {
                                                                        job5 = jobLaunch$default2;
                                                                        TapGestureDetectorKt.launchAwaitingReset$default(this.$$this$coroutineScope, job5, null, new TapGestureDetectorKt$detectTapGestures$2$1$secondUp$1(this.$pressScope, null), 2, null);
                                                                        return Unit.INSTANCE;
                                                                    }
                                                                } else {
                                                                    if (longPressResult2 instanceof LongPressResult.Released) {
                                                                        finalUpChange2 = ((LongPressResult.Released) longPressResult2).getFinalUpChange();
                                                                        pointerInputChange5 = pointerInputChange4;
                                                                    } else {
                                                                        if (longPressResult2 instanceof LongPressResult.Canceled) {
                                                                            throw new NoWhenBranchMatchedException();
                                                                        }
                                                                        pointerInputChange5 = pointerInputChange4;
                                                                        finalUpChange2 = null;
                                                                    }
                                                                    job4 = jobLaunch$default2;
                                                                    if (finalUpChange2 != null) {
                                                                        finalUpChange2.consume();
                                                                        TapGestureDetectorKt.launchAwaitingReset$default(this.$$this$coroutineScope, job4, null, new AnonymousClass7(this.$pressScope, null), 2, null);
                                                                        this.$onDoubleTap.invoke(Offset.m6558boximpl(finalUpChange2.getPosition()));
                                                                    } else {
                                                                        TapGestureDetectorKt.launchAwaitingReset$default(this.$$this$coroutineScope, job4, null, new AnonymousClass8(this.$pressScope, null), 2, null);
                                                                        function3 = this.$onTap;
                                                                        if (function3 != null) {
                                                                            function3.invoke(Offset.m6558boximpl(pointerInputChange5.getPosition()));
                                                                        }
                                                                    }
                                                                }
                                                            }
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                        return Unit.INSTANCE;
                                    }
                                    this.$onLongPress.invoke(Offset.m6558boximpl(pointerInputChange.getPosition()));
                                    this.L$0 = jobLaunch$default;
                                    this.L$1 = null;
                                    this.L$2 = null;
                                    this.label = 4;
                                    if (TapGestureDetectorKt.consumeUntilUp(awaitPointerEventScope, this) != coroutine_suspended) {
                                        job3 = jobLaunch$default;
                                        TapGestureDetectorKt.launchAwaitingReset$default(this.$$this$coroutineScope, job3, null, new C00232(this.$pressScope, null), 2, null);
                                        return Unit.INSTANCE;
                                    }
                                }
                            }
                        }
                        return coroutine_suspended;
                    case 1:
                        AwaitPointerEventScope awaitPointerEventScope7 = (AwaitPointerEventScope) this.L$0;
                        ResultKt.throwOnFailure(obj);
                        awaitPointerEventScope = awaitPointerEventScope7;
                        objAwaitFirstDown$default = obj;
                        pointerInputChange = (PointerInputChange) objAwaitFirstDown$default;
                        pointerInputChange.consume();
                        jobLaunch$default = BuildersKt__Builders_commonKt.launch$default(this.$$this$coroutineScope, null, TapGestureDetectorKt.getCoroutineStartForCurrentDispatchBehavior(), new TapGestureDetectorKt$detectTapGestures$2$1$resetJob$1(this.$pressScope, null), 1, null);
                        if (this.$onPress != TapGestureDetectorKt.NoPressGesture) {
                            TapGestureDetectorKt.launchAwaitingReset$default(this.$$this$coroutineScope, jobLaunch$default, null, new C00221(this.$onPress, this.$pressScope, pointerInputChange, null), 2, null);
                        }
                        if (this.$onLongPress == null) {
                            this.L$0 = awaitPointerEventScope;
                            this.L$1 = jobLaunch$default;
                            this.label = 2;
                            objWaitForUpOrCancellation$default = TapGestureDetectorKt.waitForUpOrCancellation$default(awaitPointerEventScope, null, this, 1, null);
                            if (objWaitForUpOrCancellation$default != coroutine_suspended) {
                                awaitPointerEventScope2 = awaitPointerEventScope;
                                finalUpChange = (PointerInputChange) objWaitForUpOrCancellation$default;
                                job = jobLaunch$default;
                                if (finalUpChange == null) {
                                    jobLaunchAwaitingReset$default = TapGestureDetectorKt.launchAwaitingReset$default(this.$$this$coroutineScope, job, null, new AnonymousClass3(this.$pressScope, null), 2, null);
                                } else {
                                    finalUpChange.consume();
                                    jobLaunchAwaitingReset$default = TapGestureDetectorKt.launchAwaitingReset$default(this.$$this$coroutineScope, job, null, new AnonymousClass4(this.$pressScope, null), 2, null);
                                }
                                if (finalUpChange != null) {
                                    if (this.$onDoubleTap != null) {
                                        function1 = this.$onTap;
                                        if (function1 != null) {
                                            function1.invoke(Offset.m6558boximpl(finalUpChange.getPosition()));
                                        }
                                    } else {
                                        this.L$0 = awaitPointerEventScope2;
                                        this.L$1 = finalUpChange;
                                        this.L$2 = jobLaunchAwaitingReset$default;
                                        this.label = 5;
                                        objAwaitSecondDown = TapGestureDetectorKt.awaitSecondDown(awaitPointerEventScope2, finalUpChange, this);
                                        if (objAwaitSecondDown != coroutine_suspended) {
                                            AwaitPointerEventScope awaitPointerEventScope8 = awaitPointerEventScope2;
                                            pointerInputChange2 = finalUpChange;
                                            job2 = jobLaunchAwaitingReset$default;
                                            awaitPointerEventScope3 = awaitPointerEventScope8;
                                            pointerInputChange3 = (PointerInputChange) objAwaitSecondDown;
                                            if (pointerInputChange3 != null) {
                                                function2 = this.$onTap;
                                                if (function2 != null) {
                                                    function2.invoke(Offset.m6558boximpl(pointerInputChange2.getPosition()));
                                                }
                                            } else {
                                                jobLaunch$default2 = BuildersKt__Builders_commonKt.launch$default(this.$$this$coroutineScope, null, TapGestureDetectorKt.getCoroutineStartForCurrentDispatchBehavior(), new AnonymousClass5(job2, this.$pressScope, null), 1, null);
                                                if (this.$onPress != TapGestureDetectorKt.NoPressGesture) {
                                                    TapGestureDetectorKt.launchAwaitingReset$default(this.$$this$coroutineScope, jobLaunch$default2, null, new AnonymousClass6(this.$onPress, this.$pressScope, pointerInputChange3, null), 2, null);
                                                }
                                                if (this.$onLongPress == null) {
                                                    this.L$0 = jobLaunch$default2;
                                                    this.L$1 = pointerInputChange2;
                                                    this.L$2 = null;
                                                    this.label = 6;
                                                    objWaitForUpOrCancellation$default2 = TapGestureDetectorKt.waitForUpOrCancellation$default(awaitPointerEventScope3, null, this, 1, null);
                                                    if (objWaitForUpOrCancellation$default2 != coroutine_suspended) {
                                                        pointerInputChange5 = pointerInputChange2;
                                                        finalUpChange2 = (PointerInputChange) objWaitForUpOrCancellation$default2;
                                                        job4 = jobLaunch$default2;
                                                        if (finalUpChange2 != null) {
                                                            finalUpChange2.consume();
                                                            TapGestureDetectorKt.launchAwaitingReset$default(this.$$this$coroutineScope, job4, null, new AnonymousClass7(this.$pressScope, null), 2, null);
                                                            this.$onDoubleTap.invoke(Offset.m6558boximpl(finalUpChange2.getPosition()));
                                                        } else {
                                                            TapGestureDetectorKt.launchAwaitingReset$default(this.$$this$coroutineScope, job4, null, new AnonymousClass8(this.$pressScope, null), 2, null);
                                                            function3 = this.$onTap;
                                                            if (function3 != null) {
                                                                function3.invoke(Offset.m6558boximpl(pointerInputChange5.getPosition()));
                                                            }
                                                        }
                                                    }
                                                } else {
                                                    this.L$0 = awaitPointerEventScope3;
                                                    this.L$1 = jobLaunch$default2;
                                                    this.L$2 = pointerInputChange2;
                                                    this.L$3 = pointerInputChange3;
                                                    this.label = 7;
                                                    objWaitForLongPress$default2 = TapGestureDetectorKt.waitForLongPress$default(awaitPointerEventScope3, null, this, 1, null);
                                                    if (objWaitForLongPress$default2 != coroutine_suspended) {
                                                        pointerInputChange4 = pointerInputChange2;
                                                        longPressResult2 = (LongPressResult) objWaitForLongPress$default2;
                                                        if (Intrinsics.areEqual(longPressResult2, LongPressResult.Success.INSTANCE)) {
                                                            this.$onLongPress.invoke(Offset.m6558boximpl(pointerInputChange3.getPosition()));
                                                            this.L$0 = jobLaunch$default2;
                                                            this.L$1 = null;
                                                            this.L$2 = null;
                                                            this.L$3 = null;
                                                            this.label = 8;
                                                            if (TapGestureDetectorKt.consumeUntilUp(awaitPointerEventScope3, this) != coroutine_suspended) {
                                                                job5 = jobLaunch$default2;
                                                                TapGestureDetectorKt.launchAwaitingReset$default(this.$$this$coroutineScope, job5, null, new TapGestureDetectorKt$detectTapGestures$2$1$secondUp$1(this.$pressScope, null), 2, null);
                                                                return Unit.INSTANCE;
                                                            }
                                                        } else {
                                                            if (longPressResult2 instanceof LongPressResult.Released) {
                                                                finalUpChange2 = ((LongPressResult.Released) longPressResult2).getFinalUpChange();
                                                                pointerInputChange5 = pointerInputChange4;
                                                            } else {
                                                                if (longPressResult2 instanceof LongPressResult.Canceled) {
                                                                    throw new NoWhenBranchMatchedException();
                                                                }
                                                                pointerInputChange5 = pointerInputChange4;
                                                                finalUpChange2 = null;
                                                            }
                                                            job4 = jobLaunch$default2;
                                                            if (finalUpChange2 != null) {
                                                                finalUpChange2.consume();
                                                                TapGestureDetectorKt.launchAwaitingReset$default(this.$$this$coroutineScope, job4, null, new AnonymousClass7(this.$pressScope, null), 2, null);
                                                                this.$onDoubleTap.invoke(Offset.m6558boximpl(finalUpChange2.getPosition()));
                                                            } else {
                                                                TapGestureDetectorKt.launchAwaitingReset$default(this.$$this$coroutineScope, job4, null, new AnonymousClass8(this.$pressScope, null), 2, null);
                                                                function3 = this.$onTap;
                                                                if (function3 != null) {
                                                                    function3.invoke(Offset.m6558boximpl(pointerInputChange5.getPosition()));
                                                                }
                                                            }
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                                return Unit.INSTANCE;
                            }
                        } else {
                            this.L$0 = awaitPointerEventScope;
                            this.L$1 = pointerInputChange;
                            this.L$2 = jobLaunch$default;
                            this.label = 3;
                            objWaitForLongPress$default = TapGestureDetectorKt.waitForLongPress$default(awaitPointerEventScope, null, this, 1, null);
                            if (objWaitForLongPress$default != coroutine_suspended) {
                                longPressResult = (LongPressResult) objWaitForLongPress$default;
                                if (!Intrinsics.areEqual(longPressResult, LongPressResult.Success.INSTANCE)) {
                                    if (longPressResult instanceof LongPressResult.Released) {
                                        finalUpChange = ((LongPressResult.Released) longPressResult).getFinalUpChange();
                                    } else {
                                        if (!(longPressResult instanceof LongPressResult.Canceled)) {
                                            throw new NoWhenBranchMatchedException();
                                        }
                                        finalUpChange = null;
                                    }
                                    awaitPointerEventScope2 = awaitPointerEventScope;
                                    job = jobLaunch$default;
                                    if (finalUpChange == null) {
                                        jobLaunchAwaitingReset$default = TapGestureDetectorKt.launchAwaitingReset$default(this.$$this$coroutineScope, job, null, new AnonymousClass3(this.$pressScope, null), 2, null);
                                    } else {
                                        finalUpChange.consume();
                                        jobLaunchAwaitingReset$default = TapGestureDetectorKt.launchAwaitingReset$default(this.$$this$coroutineScope, job, null, new AnonymousClass4(this.$pressScope, null), 2, null);
                                    }
                                    if (finalUpChange != null) {
                                        if (this.$onDoubleTap != null) {
                                            function1 = this.$onTap;
                                            if (function1 != null) {
                                                function1.invoke(Offset.m6558boximpl(finalUpChange.getPosition()));
                                            }
                                        } else {
                                            this.L$0 = awaitPointerEventScope2;
                                            this.L$1 = finalUpChange;
                                            this.L$2 = jobLaunchAwaitingReset$default;
                                            this.label = 5;
                                            objAwaitSecondDown = TapGestureDetectorKt.awaitSecondDown(awaitPointerEventScope2, finalUpChange, this);
                                            if (objAwaitSecondDown != coroutine_suspended) {
                                                AwaitPointerEventScope awaitPointerEventScope9 = awaitPointerEventScope2;
                                                pointerInputChange2 = finalUpChange;
                                                job2 = jobLaunchAwaitingReset$default;
                                                awaitPointerEventScope3 = awaitPointerEventScope9;
                                                pointerInputChange3 = (PointerInputChange) objAwaitSecondDown;
                                                if (pointerInputChange3 != null) {
                                                    function2 = this.$onTap;
                                                    if (function2 != null) {
                                                        function2.invoke(Offset.m6558boximpl(pointerInputChange2.getPosition()));
                                                    }
                                                } else {
                                                    jobLaunch$default2 = BuildersKt__Builders_commonKt.launch$default(this.$$this$coroutineScope, null, TapGestureDetectorKt.getCoroutineStartForCurrentDispatchBehavior(), new AnonymousClass5(job2, this.$pressScope, null), 1, null);
                                                    if (this.$onPress != TapGestureDetectorKt.NoPressGesture) {
                                                        TapGestureDetectorKt.launchAwaitingReset$default(this.$$this$coroutineScope, jobLaunch$default2, null, new AnonymousClass6(this.$onPress, this.$pressScope, pointerInputChange3, null), 2, null);
                                                    }
                                                    if (this.$onLongPress == null) {
                                                        this.L$0 = jobLaunch$default2;
                                                        this.L$1 = pointerInputChange2;
                                                        this.L$2 = null;
                                                        this.label = 6;
                                                        objWaitForUpOrCancellation$default2 = TapGestureDetectorKt.waitForUpOrCancellation$default(awaitPointerEventScope3, null, this, 1, null);
                                                        if (objWaitForUpOrCancellation$default2 != coroutine_suspended) {
                                                            pointerInputChange5 = pointerInputChange2;
                                                            finalUpChange2 = (PointerInputChange) objWaitForUpOrCancellation$default2;
                                                            job4 = jobLaunch$default2;
                                                            if (finalUpChange2 != null) {
                                                                finalUpChange2.consume();
                                                                TapGestureDetectorKt.launchAwaitingReset$default(this.$$this$coroutineScope, job4, null, new AnonymousClass7(this.$pressScope, null), 2, null);
                                                                this.$onDoubleTap.invoke(Offset.m6558boximpl(finalUpChange2.getPosition()));
                                                            } else {
                                                                TapGestureDetectorKt.launchAwaitingReset$default(this.$$this$coroutineScope, job4, null, new AnonymousClass8(this.$pressScope, null), 2, null);
                                                                function3 = this.$onTap;
                                                                if (function3 != null) {
                                                                    function3.invoke(Offset.m6558boximpl(pointerInputChange5.getPosition()));
                                                                }
                                                            }
                                                        }
                                                    } else {
                                                        this.L$0 = awaitPointerEventScope3;
                                                        this.L$1 = jobLaunch$default2;
                                                        this.L$2 = pointerInputChange2;
                                                        this.L$3 = pointerInputChange3;
                                                        this.label = 7;
                                                        objWaitForLongPress$default2 = TapGestureDetectorKt.waitForLongPress$default(awaitPointerEventScope3, null, this, 1, null);
                                                        if (objWaitForLongPress$default2 != coroutine_suspended) {
                                                            pointerInputChange4 = pointerInputChange2;
                                                            longPressResult2 = (LongPressResult) objWaitForLongPress$default2;
                                                            if (Intrinsics.areEqual(longPressResult2, LongPressResult.Success.INSTANCE)) {
                                                                this.$onLongPress.invoke(Offset.m6558boximpl(pointerInputChange3.getPosition()));
                                                                this.L$0 = jobLaunch$default2;
                                                                this.L$1 = null;
                                                                this.L$2 = null;
                                                                this.L$3 = null;
                                                                this.label = 8;
                                                                if (TapGestureDetectorKt.consumeUntilUp(awaitPointerEventScope3, this) != coroutine_suspended) {
                                                                    job5 = jobLaunch$default2;
                                                                    TapGestureDetectorKt.launchAwaitingReset$default(this.$$this$coroutineScope, job5, null, new TapGestureDetectorKt$detectTapGestures$2$1$secondUp$1(this.$pressScope, null), 2, null);
                                                                    return Unit.INSTANCE;
                                                                }
                                                            } else {
                                                                if (longPressResult2 instanceof LongPressResult.Released) {
                                                                    finalUpChange2 = ((LongPressResult.Released) longPressResult2).getFinalUpChange();
                                                                    pointerInputChange5 = pointerInputChange4;
                                                                } else {
                                                                    if (longPressResult2 instanceof LongPressResult.Canceled) {
                                                                        throw new NoWhenBranchMatchedException();
                                                                    }
                                                                    pointerInputChange5 = pointerInputChange4;
                                                                    finalUpChange2 = null;
                                                                }
                                                                job4 = jobLaunch$default2;
                                                                if (finalUpChange2 != null) {
                                                                    finalUpChange2.consume();
                                                                    TapGestureDetectorKt.launchAwaitingReset$default(this.$$this$coroutineScope, job4, null, new AnonymousClass7(this.$pressScope, null), 2, null);
                                                                    this.$onDoubleTap.invoke(Offset.m6558boximpl(finalUpChange2.getPosition()));
                                                                } else {
                                                                    TapGestureDetectorKt.launchAwaitingReset$default(this.$$this$coroutineScope, job4, null, new AnonymousClass8(this.$pressScope, null), 2, null);
                                                                    function3 = this.$onTap;
                                                                    if (function3 != null) {
                                                                        function3.invoke(Offset.m6558boximpl(pointerInputChange5.getPosition()));
                                                                    }
                                                                }
                                                            }
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                    }
                                    return Unit.INSTANCE;
                                }
                                this.$onLongPress.invoke(Offset.m6558boximpl(pointerInputChange.getPosition()));
                                this.L$0 = jobLaunch$default;
                                this.L$1 = null;
                                this.L$2 = null;
                                this.label = 4;
                                if (TapGestureDetectorKt.consumeUntilUp(awaitPointerEventScope, this) != coroutine_suspended) {
                                    job3 = jobLaunch$default;
                                    TapGestureDetectorKt.launchAwaitingReset$default(this.$$this$coroutineScope, job3, null, new C00232(this.$pressScope, null), 2, null);
                                    return Unit.INSTANCE;
                                }
                            }
                        }
                        return coroutine_suspended;
                    case 2:
                        Job job6 = (Job) this.L$1;
                        awaitPointerEventScope2 = (AwaitPointerEventScope) this.L$0;
                        ResultKt.throwOnFailure(obj);
                        jobLaunch$default = job6;
                        objWaitForUpOrCancellation$default = obj;
                        finalUpChange = (PointerInputChange) objWaitForUpOrCancellation$default;
                        job = jobLaunch$default;
                        if (finalUpChange == null) {
                            jobLaunchAwaitingReset$default = TapGestureDetectorKt.launchAwaitingReset$default(this.$$this$coroutineScope, job, null, new AnonymousClass3(this.$pressScope, null), 2, null);
                        } else {
                            finalUpChange.consume();
                            jobLaunchAwaitingReset$default = TapGestureDetectorKt.launchAwaitingReset$default(this.$$this$coroutineScope, job, null, new AnonymousClass4(this.$pressScope, null), 2, null);
                        }
                        if (finalUpChange != null) {
                            if (this.$onDoubleTap != null) {
                                this.L$0 = awaitPointerEventScope2;
                                this.L$1 = finalUpChange;
                                this.L$2 = jobLaunchAwaitingReset$default;
                                this.label = 5;
                                objAwaitSecondDown = TapGestureDetectorKt.awaitSecondDown(awaitPointerEventScope2, finalUpChange, this);
                                if (objAwaitSecondDown != coroutine_suspended) {
                                    AwaitPointerEventScope awaitPointerEventScope10 = awaitPointerEventScope2;
                                    pointerInputChange2 = finalUpChange;
                                    job2 = jobLaunchAwaitingReset$default;
                                    awaitPointerEventScope3 = awaitPointerEventScope10;
                                    pointerInputChange3 = (PointerInputChange) objAwaitSecondDown;
                                    if (pointerInputChange3 != null) {
                                        function2 = this.$onTap;
                                        if (function2 != null) {
                                            function2.invoke(Offset.m6558boximpl(pointerInputChange2.getPosition()));
                                        }
                                    } else {
                                        jobLaunch$default2 = BuildersKt__Builders_commonKt.launch$default(this.$$this$coroutineScope, null, TapGestureDetectorKt.getCoroutineStartForCurrentDispatchBehavior(), new AnonymousClass5(job2, this.$pressScope, null), 1, null);
                                        if (this.$onPress != TapGestureDetectorKt.NoPressGesture) {
                                            TapGestureDetectorKt.launchAwaitingReset$default(this.$$this$coroutineScope, jobLaunch$default2, null, new AnonymousClass6(this.$onPress, this.$pressScope, pointerInputChange3, null), 2, null);
                                        }
                                        if (this.$onLongPress == null) {
                                            this.L$0 = jobLaunch$default2;
                                            this.L$1 = pointerInputChange2;
                                            this.L$2 = null;
                                            this.label = 6;
                                            objWaitForUpOrCancellation$default2 = TapGestureDetectorKt.waitForUpOrCancellation$default(awaitPointerEventScope3, null, this, 1, null);
                                            if (objWaitForUpOrCancellation$default2 != coroutine_suspended) {
                                                pointerInputChange5 = pointerInputChange2;
                                                finalUpChange2 = (PointerInputChange) objWaitForUpOrCancellation$default2;
                                                job4 = jobLaunch$default2;
                                                if (finalUpChange2 != null) {
                                                    finalUpChange2.consume();
                                                    TapGestureDetectorKt.launchAwaitingReset$default(this.$$this$coroutineScope, job4, null, new AnonymousClass7(this.$pressScope, null), 2, null);
                                                    this.$onDoubleTap.invoke(Offset.m6558boximpl(finalUpChange2.getPosition()));
                                                } else {
                                                    TapGestureDetectorKt.launchAwaitingReset$default(this.$$this$coroutineScope, job4, null, new AnonymousClass8(this.$pressScope, null), 2, null);
                                                    function3 = this.$onTap;
                                                    if (function3 != null) {
                                                        function3.invoke(Offset.m6558boximpl(pointerInputChange5.getPosition()));
                                                    }
                                                }
                                            }
                                        } else {
                                            this.L$0 = awaitPointerEventScope3;
                                            this.L$1 = jobLaunch$default2;
                                            this.L$2 = pointerInputChange2;
                                            this.L$3 = pointerInputChange3;
                                            this.label = 7;
                                            objWaitForLongPress$default2 = TapGestureDetectorKt.waitForLongPress$default(awaitPointerEventScope3, null, this, 1, null);
                                            if (objWaitForLongPress$default2 != coroutine_suspended) {
                                                pointerInputChange4 = pointerInputChange2;
                                                longPressResult2 = (LongPressResult) objWaitForLongPress$default2;
                                                if (Intrinsics.areEqual(longPressResult2, LongPressResult.Success.INSTANCE)) {
                                                    this.$onLongPress.invoke(Offset.m6558boximpl(pointerInputChange3.getPosition()));
                                                    this.L$0 = jobLaunch$default2;
                                                    this.L$1 = null;
                                                    this.L$2 = null;
                                                    this.L$3 = null;
                                                    this.label = 8;
                                                    if (TapGestureDetectorKt.consumeUntilUp(awaitPointerEventScope3, this) != coroutine_suspended) {
                                                        job5 = jobLaunch$default2;
                                                        TapGestureDetectorKt.launchAwaitingReset$default(this.$$this$coroutineScope, job5, null, new TapGestureDetectorKt$detectTapGestures$2$1$secondUp$1(this.$pressScope, null), 2, null);
                                                        return Unit.INSTANCE;
                                                    }
                                                } else {
                                                    if (longPressResult2 instanceof LongPressResult.Released) {
                                                        finalUpChange2 = ((LongPressResult.Released) longPressResult2).getFinalUpChange();
                                                        pointerInputChange5 = pointerInputChange4;
                                                    } else {
                                                        if (longPressResult2 instanceof LongPressResult.Canceled) {
                                                            throw new NoWhenBranchMatchedException();
                                                        }
                                                        pointerInputChange5 = pointerInputChange4;
                                                        finalUpChange2 = null;
                                                    }
                                                    job4 = jobLaunch$default2;
                                                    if (finalUpChange2 != null) {
                                                        finalUpChange2.consume();
                                                        TapGestureDetectorKt.launchAwaitingReset$default(this.$$this$coroutineScope, job4, null, new AnonymousClass7(this.$pressScope, null), 2, null);
                                                        this.$onDoubleTap.invoke(Offset.m6558boximpl(finalUpChange2.getPosition()));
                                                    } else {
                                                        TapGestureDetectorKt.launchAwaitingReset$default(this.$$this$coroutineScope, job4, null, new AnonymousClass8(this.$pressScope, null), 2, null);
                                                        function3 = this.$onTap;
                                                        if (function3 != null) {
                                                            function3.invoke(Offset.m6558boximpl(pointerInputChange5.getPosition()));
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                                return coroutine_suspended;
                            }
                            function1 = this.$onTap;
                            if (function1 != null) {
                                function1.invoke(Offset.m6558boximpl(finalUpChange.getPosition()));
                            }
                        }
                        return Unit.INSTANCE;
                    case 3:
                        Job job7 = (Job) this.L$2;
                        pointerInputChange = (PointerInputChange) this.L$1;
                        awaitPointerEventScope = (AwaitPointerEventScope) this.L$0;
                        ResultKt.throwOnFailure(obj);
                        jobLaunch$default = job7;
                        objWaitForLongPress$default = obj;
                        longPressResult = (LongPressResult) objWaitForLongPress$default;
                        if (!Intrinsics.areEqual(longPressResult, LongPressResult.Success.INSTANCE)) {
                            if (longPressResult instanceof LongPressResult.Released) {
                                finalUpChange = ((LongPressResult.Released) longPressResult).getFinalUpChange();
                            } else {
                                if (!(longPressResult instanceof LongPressResult.Canceled)) {
                                    throw new NoWhenBranchMatchedException();
                                }
                                finalUpChange = null;
                            }
                            awaitPointerEventScope2 = awaitPointerEventScope;
                            job = jobLaunch$default;
                            if (finalUpChange == null) {
                                jobLaunchAwaitingReset$default = TapGestureDetectorKt.launchAwaitingReset$default(this.$$this$coroutineScope, job, null, new AnonymousClass3(this.$pressScope, null), 2, null);
                            } else {
                                finalUpChange.consume();
                                jobLaunchAwaitingReset$default = TapGestureDetectorKt.launchAwaitingReset$default(this.$$this$coroutineScope, job, null, new AnonymousClass4(this.$pressScope, null), 2, null);
                            }
                            if (finalUpChange != null) {
                                if (this.$onDoubleTap != null) {
                                    function1 = this.$onTap;
                                    if (function1 != null) {
                                        function1.invoke(Offset.m6558boximpl(finalUpChange.getPosition()));
                                    }
                                } else {
                                    this.L$0 = awaitPointerEventScope2;
                                    this.L$1 = finalUpChange;
                                    this.L$2 = jobLaunchAwaitingReset$default;
                                    this.label = 5;
                                    objAwaitSecondDown = TapGestureDetectorKt.awaitSecondDown(awaitPointerEventScope2, finalUpChange, this);
                                    if (objAwaitSecondDown != coroutine_suspended) {
                                        AwaitPointerEventScope awaitPointerEventScope11 = awaitPointerEventScope2;
                                        pointerInputChange2 = finalUpChange;
                                        job2 = jobLaunchAwaitingReset$default;
                                        awaitPointerEventScope3 = awaitPointerEventScope11;
                                        pointerInputChange3 = (PointerInputChange) objAwaitSecondDown;
                                        if (pointerInputChange3 != null) {
                                            function2 = this.$onTap;
                                            if (function2 != null) {
                                                function2.invoke(Offset.m6558boximpl(pointerInputChange2.getPosition()));
                                            }
                                        } else {
                                            jobLaunch$default2 = BuildersKt__Builders_commonKt.launch$default(this.$$this$coroutineScope, null, TapGestureDetectorKt.getCoroutineStartForCurrentDispatchBehavior(), new AnonymousClass5(job2, this.$pressScope, null), 1, null);
                                            if (this.$onPress != TapGestureDetectorKt.NoPressGesture) {
                                                TapGestureDetectorKt.launchAwaitingReset$default(this.$$this$coroutineScope, jobLaunch$default2, null, new AnonymousClass6(this.$onPress, this.$pressScope, pointerInputChange3, null), 2, null);
                                            }
                                            if (this.$onLongPress == null) {
                                                this.L$0 = jobLaunch$default2;
                                                this.L$1 = pointerInputChange2;
                                                this.L$2 = null;
                                                this.label = 6;
                                                objWaitForUpOrCancellation$default2 = TapGestureDetectorKt.waitForUpOrCancellation$default(awaitPointerEventScope3, null, this, 1, null);
                                                if (objWaitForUpOrCancellation$default2 != coroutine_suspended) {
                                                    pointerInputChange5 = pointerInputChange2;
                                                    finalUpChange2 = (PointerInputChange) objWaitForUpOrCancellation$default2;
                                                    job4 = jobLaunch$default2;
                                                    if (finalUpChange2 != null) {
                                                        finalUpChange2.consume();
                                                        TapGestureDetectorKt.launchAwaitingReset$default(this.$$this$coroutineScope, job4, null, new AnonymousClass7(this.$pressScope, null), 2, null);
                                                        this.$onDoubleTap.invoke(Offset.m6558boximpl(finalUpChange2.getPosition()));
                                                    } else {
                                                        TapGestureDetectorKt.launchAwaitingReset$default(this.$$this$coroutineScope, job4, null, new AnonymousClass8(this.$pressScope, null), 2, null);
                                                        function3 = this.$onTap;
                                                        if (function3 != null) {
                                                            function3.invoke(Offset.m6558boximpl(pointerInputChange5.getPosition()));
                                                        }
                                                    }
                                                }
                                            } else {
                                                this.L$0 = awaitPointerEventScope3;
                                                this.L$1 = jobLaunch$default2;
                                                this.L$2 = pointerInputChange2;
                                                this.L$3 = pointerInputChange3;
                                                this.label = 7;
                                                objWaitForLongPress$default2 = TapGestureDetectorKt.waitForLongPress$default(awaitPointerEventScope3, null, this, 1, null);
                                                if (objWaitForLongPress$default2 != coroutine_suspended) {
                                                    pointerInputChange4 = pointerInputChange2;
                                                    longPressResult2 = (LongPressResult) objWaitForLongPress$default2;
                                                    if (Intrinsics.areEqual(longPressResult2, LongPressResult.Success.INSTANCE)) {
                                                        this.$onLongPress.invoke(Offset.m6558boximpl(pointerInputChange3.getPosition()));
                                                        this.L$0 = jobLaunch$default2;
                                                        this.L$1 = null;
                                                        this.L$2 = null;
                                                        this.L$3 = null;
                                                        this.label = 8;
                                                        if (TapGestureDetectorKt.consumeUntilUp(awaitPointerEventScope3, this) != coroutine_suspended) {
                                                            job5 = jobLaunch$default2;
                                                            TapGestureDetectorKt.launchAwaitingReset$default(this.$$this$coroutineScope, job5, null, new TapGestureDetectorKt$detectTapGestures$2$1$secondUp$1(this.$pressScope, null), 2, null);
                                                            return Unit.INSTANCE;
                                                        }
                                                    } else {
                                                        if (longPressResult2 instanceof LongPressResult.Released) {
                                                            finalUpChange2 = ((LongPressResult.Released) longPressResult2).getFinalUpChange();
                                                            pointerInputChange5 = pointerInputChange4;
                                                        } else {
                                                            if (longPressResult2 instanceof LongPressResult.Canceled) {
                                                                throw new NoWhenBranchMatchedException();
                                                            }
                                                            pointerInputChange5 = pointerInputChange4;
                                                            finalUpChange2 = null;
                                                        }
                                                        job4 = jobLaunch$default2;
                                                        if (finalUpChange2 != null) {
                                                            finalUpChange2.consume();
                                                            TapGestureDetectorKt.launchAwaitingReset$default(this.$$this$coroutineScope, job4, null, new AnonymousClass7(this.$pressScope, null), 2, null);
                                                            this.$onDoubleTap.invoke(Offset.m6558boximpl(finalUpChange2.getPosition()));
                                                        } else {
                                                            TapGestureDetectorKt.launchAwaitingReset$default(this.$$this$coroutineScope, job4, null, new AnonymousClass8(this.$pressScope, null), 2, null);
                                                            function3 = this.$onTap;
                                                            if (function3 != null) {
                                                                function3.invoke(Offset.m6558boximpl(pointerInputChange5.getPosition()));
                                                            }
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                            return Unit.INSTANCE;
                        }
                        this.$onLongPress.invoke(Offset.m6558boximpl(pointerInputChange.getPosition()));
                        this.L$0 = jobLaunch$default;
                        this.L$1 = null;
                        this.L$2 = null;
                        this.label = 4;
                        if (TapGestureDetectorKt.consumeUntilUp(awaitPointerEventScope, this) != coroutine_suspended) {
                            job3 = jobLaunch$default;
                            TapGestureDetectorKt.launchAwaitingReset$default(this.$$this$coroutineScope, job3, null, new C00232(this.$pressScope, null), 2, null);
                            return Unit.INSTANCE;
                        }
                        return coroutine_suspended;
                    case 4:
                        Job job8 = (Job) this.L$0;
                        ResultKt.throwOnFailure(obj);
                        job3 = job8;
                        TapGestureDetectorKt.launchAwaitingReset$default(this.$$this$coroutineScope, job3, null, new C00232(this.$pressScope, null), 2, null);
                        return Unit.INSTANCE;
                    case 5:
                        job2 = (Job) this.L$2;
                        pointerInputChange2 = (PointerInputChange) this.L$1;
                        awaitPointerEventScope3 = (AwaitPointerEventScope) this.L$0;
                        ResultKt.throwOnFailure(obj);
                        objAwaitSecondDown = obj;
                        pointerInputChange3 = (PointerInputChange) objAwaitSecondDown;
                        if (pointerInputChange3 != null) {
                            jobLaunch$default2 = BuildersKt__Builders_commonKt.launch$default(this.$$this$coroutineScope, null, TapGestureDetectorKt.getCoroutineStartForCurrentDispatchBehavior(), new AnonymousClass5(job2, this.$pressScope, null), 1, null);
                            if (this.$onPress != TapGestureDetectorKt.NoPressGesture) {
                                TapGestureDetectorKt.launchAwaitingReset$default(this.$$this$coroutineScope, jobLaunch$default2, null, new AnonymousClass6(this.$onPress, this.$pressScope, pointerInputChange3, null), 2, null);
                            }
                            if (this.$onLongPress == null) {
                                this.L$0 = jobLaunch$default2;
                                this.L$1 = pointerInputChange2;
                                this.L$2 = null;
                                this.label = 6;
                                objWaitForUpOrCancellation$default2 = TapGestureDetectorKt.waitForUpOrCancellation$default(awaitPointerEventScope3, null, this, 1, null);
                                if (objWaitForUpOrCancellation$default2 != coroutine_suspended) {
                                    pointerInputChange5 = pointerInputChange2;
                                    finalUpChange2 = (PointerInputChange) objWaitForUpOrCancellation$default2;
                                    job4 = jobLaunch$default2;
                                    if (finalUpChange2 != null) {
                                        finalUpChange2.consume();
                                        TapGestureDetectorKt.launchAwaitingReset$default(this.$$this$coroutineScope, job4, null, new AnonymousClass7(this.$pressScope, null), 2, null);
                                        this.$onDoubleTap.invoke(Offset.m6558boximpl(finalUpChange2.getPosition()));
                                    } else {
                                        TapGestureDetectorKt.launchAwaitingReset$default(this.$$this$coroutineScope, job4, null, new AnonymousClass8(this.$pressScope, null), 2, null);
                                        function3 = this.$onTap;
                                        if (function3 != null) {
                                            function3.invoke(Offset.m6558boximpl(pointerInputChange5.getPosition()));
                                        }
                                    }
                                }
                            } else {
                                this.L$0 = awaitPointerEventScope3;
                                this.L$1 = jobLaunch$default2;
                                this.L$2 = pointerInputChange2;
                                this.L$3 = pointerInputChange3;
                                this.label = 7;
                                objWaitForLongPress$default2 = TapGestureDetectorKt.waitForLongPress$default(awaitPointerEventScope3, null, this, 1, null);
                                if (objWaitForLongPress$default2 != coroutine_suspended) {
                                    pointerInputChange4 = pointerInputChange2;
                                    longPressResult2 = (LongPressResult) objWaitForLongPress$default2;
                                    if (Intrinsics.areEqual(longPressResult2, LongPressResult.Success.INSTANCE)) {
                                        this.$onLongPress.invoke(Offset.m6558boximpl(pointerInputChange3.getPosition()));
                                        this.L$0 = jobLaunch$default2;
                                        this.L$1 = null;
                                        this.L$2 = null;
                                        this.L$3 = null;
                                        this.label = 8;
                                        if (TapGestureDetectorKt.consumeUntilUp(awaitPointerEventScope3, this) != coroutine_suspended) {
                                            job5 = jobLaunch$default2;
                                            TapGestureDetectorKt.launchAwaitingReset$default(this.$$this$coroutineScope, job5, null, new TapGestureDetectorKt$detectTapGestures$2$1$secondUp$1(this.$pressScope, null), 2, null);
                                            return Unit.INSTANCE;
                                        }
                                    } else {
                                        if (longPressResult2 instanceof LongPressResult.Released) {
                                            finalUpChange2 = ((LongPressResult.Released) longPressResult2).getFinalUpChange();
                                            pointerInputChange5 = pointerInputChange4;
                                        } else {
                                            if (longPressResult2 instanceof LongPressResult.Canceled) {
                                                throw new NoWhenBranchMatchedException();
                                            }
                                            pointerInputChange5 = pointerInputChange4;
                                            finalUpChange2 = null;
                                        }
                                        job4 = jobLaunch$default2;
                                        if (finalUpChange2 != null) {
                                            finalUpChange2.consume();
                                            TapGestureDetectorKt.launchAwaitingReset$default(this.$$this$coroutineScope, job4, null, new AnonymousClass7(this.$pressScope, null), 2, null);
                                            this.$onDoubleTap.invoke(Offset.m6558boximpl(finalUpChange2.getPosition()));
                                        } else {
                                            TapGestureDetectorKt.launchAwaitingReset$default(this.$$this$coroutineScope, job4, null, new AnonymousClass8(this.$pressScope, null), 2, null);
                                            function3 = this.$onTap;
                                            if (function3 != null) {
                                                function3.invoke(Offset.m6558boximpl(pointerInputChange5.getPosition()));
                                            }
                                        }
                                    }
                                }
                            }
                            return coroutine_suspended;
                        }
                        function2 = this.$onTap;
                        if (function2 != null) {
                            function2.invoke(Offset.m6558boximpl(pointerInputChange2.getPosition()));
                        }
                        return Unit.INSTANCE;
                    case 6:
                        pointerInputChange5 = (PointerInputChange) this.L$1;
                        Job job9 = (Job) this.L$0;
                        ResultKt.throwOnFailure(obj);
                        jobLaunch$default2 = job9;
                        objWaitForUpOrCancellation$default2 = obj;
                        finalUpChange2 = (PointerInputChange) objWaitForUpOrCancellation$default2;
                        job4 = jobLaunch$default2;
                        if (finalUpChange2 != null) {
                            finalUpChange2.consume();
                            TapGestureDetectorKt.launchAwaitingReset$default(this.$$this$coroutineScope, job4, null, new AnonymousClass7(this.$pressScope, null), 2, null);
                            this.$onDoubleTap.invoke(Offset.m6558boximpl(finalUpChange2.getPosition()));
                        } else {
                            TapGestureDetectorKt.launchAwaitingReset$default(this.$$this$coroutineScope, job4, null, new AnonymousClass8(this.$pressScope, null), 2, null);
                            function3 = this.$onTap;
                            if (function3 != null) {
                                function3.invoke(Offset.m6558boximpl(pointerInputChange5.getPosition()));
                            }
                        }
                        return Unit.INSTANCE;
                    case 7:
                        PointerInputChange pointerInputChange6 = (PointerInputChange) this.L$3;
                        pointerInputChange4 = (PointerInputChange) this.L$2;
                        Job job10 = (Job) this.L$1;
                        awaitPointerEventScope3 = (AwaitPointerEventScope) this.L$0;
                        ResultKt.throwOnFailure(obj);
                        pointerInputChange3 = pointerInputChange6;
                        jobLaunch$default2 = job10;
                        objWaitForLongPress$default2 = obj;
                        longPressResult2 = (LongPressResult) objWaitForLongPress$default2;
                        if (Intrinsics.areEqual(longPressResult2, LongPressResult.Success.INSTANCE)) {
                            this.$onLongPress.invoke(Offset.m6558boximpl(pointerInputChange3.getPosition()));
                            this.L$0 = jobLaunch$default2;
                            this.L$1 = null;
                            this.L$2 = null;
                            this.L$3 = null;
                            this.label = 8;
                            if (TapGestureDetectorKt.consumeUntilUp(awaitPointerEventScope3, this) != coroutine_suspended) {
                                job5 = jobLaunch$default2;
                                TapGestureDetectorKt.launchAwaitingReset$default(this.$$this$coroutineScope, job5, null, new TapGestureDetectorKt$detectTapGestures$2$1$secondUp$1(this.$pressScope, null), 2, null);
                                return Unit.INSTANCE;
                            }
                            return coroutine_suspended;
                        }
                        if (longPressResult2 instanceof LongPressResult.Released) {
                            finalUpChange2 = ((LongPressResult.Released) longPressResult2).getFinalUpChange();
                            pointerInputChange5 = pointerInputChange4;
                        } else {
                            if (longPressResult2 instanceof LongPressResult.Canceled) {
                                throw new NoWhenBranchMatchedException();
                            }
                            pointerInputChange5 = pointerInputChange4;
                            finalUpChange2 = null;
                        }
                        job4 = jobLaunch$default2;
                        if (finalUpChange2 != null) {
                            finalUpChange2.consume();
                            TapGestureDetectorKt.launchAwaitingReset$default(this.$$this$coroutineScope, job4, null, new AnonymousClass7(this.$pressScope, null), 2, null);
                            this.$onDoubleTap.invoke(Offset.m6558boximpl(finalUpChange2.getPosition()));
                        } else {
                            TapGestureDetectorKt.launchAwaitingReset$default(this.$$this$coroutineScope, job4, null, new AnonymousClass8(this.$pressScope, null), 2, null);
                            function3 = this.$onTap;
                            if (function3 != null) {
                                function3.invoke(Offset.m6558boximpl(pointerInputChange5.getPosition()));
                            }
                        }
                        return Unit.INSTANCE;
                    case 8:
                        Job job11 = (Job) this.L$0;
                        ResultKt.throwOnFailure(obj);
                        job5 = job11;
                        TapGestureDetectorKt.launchAwaitingReset$default(this.$$this$coroutineScope, job5, null, new TapGestureDetectorKt$detectTapGestures$2$1$secondUp$1(this.$pressScope, null), 2, null);
                        return Unit.INSTANCE;
                    default:
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
            }

            /* JADX INFO: renamed from: androidx.compose.foundation.gestures.TapGestureDetectorKt$detectTapGestures$2$1$1, reason: invalid class name and collision with other inner class name */
            /* JADX INFO: compiled from: TapGestureDetector.kt */
            @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
            @DebugMetadata(c = "androidx.compose.foundation.gestures.TapGestureDetectorKt$detectTapGestures$2$1$1", f = "TapGestureDetector.kt", i = {}, l = {110}, m = "invokeSuspend", n = {}, s = {}, v = 1)
            static final class C00221 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
                final /* synthetic */ PointerInputChange $down;
                final /* synthetic */ Function3<PressGestureScope, Offset, Continuation<? super Unit>, Object> $onPress;
                final /* synthetic */ PressGestureScopeImpl $pressScope;
                int label;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                C00221(Function3<? super PressGestureScope, ? super Offset, ? super Continuation<? super Unit>, ? extends Object> function3, PressGestureScopeImpl pressGestureScopeImpl, PointerInputChange pointerInputChange, Continuation<? super C00221> continuation) {
                    super(2, continuation);
                    this.$onPress = function3;
                    this.$pressScope = pressGestureScopeImpl;
                    this.$down = pointerInputChange;
                }

                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                    return new C00221(this.$onPress, this.$pressScope, this.$down, continuation);
                }

                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                    return ((C00221) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
                }

                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                public final Object invokeSuspend(Object obj) {
                    Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                    int i = this.label;
                    if (i == 0) {
                        ResultKt.throwOnFailure(obj);
                        Function3<PressGestureScope, Offset, Continuation<? super Unit>, Object> function3 = this.$onPress;
                        PressGestureScopeImpl pressGestureScopeImpl = this.$pressScope;
                        Offset offsetM6558boximpl = Offset.m6558boximpl(this.$down.getPosition());
                        this.label = 1;
                        if (function3.invoke(pressGestureScopeImpl, offsetM6558boximpl, this) == coroutine_suspended) {
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

            /* JADX INFO: renamed from: androidx.compose.foundation.gestures.TapGestureDetectorKt$detectTapGestures$2$1$2, reason: invalid class name and collision with other inner class name */
            /* JADX INFO: compiled from: TapGestureDetector.kt */
            @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
            @DebugMetadata(c = "androidx.compose.foundation.gestures.TapGestureDetectorKt$detectTapGestures$2$1$2", f = "TapGestureDetector.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {}, v = 1)
            static final class C00232 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
                final /* synthetic */ PressGestureScopeImpl $pressScope;
                int label;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                C00232(PressGestureScopeImpl pressGestureScopeImpl, Continuation<? super C00232> continuation) {
                    super(2, continuation);
                    this.$pressScope = pressGestureScopeImpl;
                }

                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                    return new C00232(this.$pressScope, continuation);
                }

                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                    return ((C00232) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
                }

                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                public final Object invokeSuspend(Object obj) {
                    IntrinsicsKt.getCOROUTINE_SUSPENDED();
                    if (this.label != 0) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    ResultKt.throwOnFailure(obj);
                    this.$pressScope.release();
                    return Unit.INSTANCE;
                }
            }

            /* JADX INFO: renamed from: androidx.compose.foundation.gestures.TapGestureDetectorKt$detectTapGestures$2$1$3, reason: invalid class name */
            /* JADX INFO: compiled from: TapGestureDetector.kt */
            @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
            @DebugMetadata(c = "androidx.compose.foundation.gestures.TapGestureDetectorKt$detectTapGestures$2$1$3", f = "TapGestureDetector.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {}, v = 1)
            static final class AnonymousClass3 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
                final /* synthetic */ PressGestureScopeImpl $pressScope;
                int label;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                AnonymousClass3(PressGestureScopeImpl pressGestureScopeImpl, Continuation<? super AnonymousClass3> continuation) {
                    super(2, continuation);
                    this.$pressScope = pressGestureScopeImpl;
                }

                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                    return new AnonymousClass3(this.$pressScope, continuation);
                }

                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                    return ((AnonymousClass3) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
                }

                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                public final Object invokeSuspend(Object obj) {
                    IntrinsicsKt.getCOROUTINE_SUSPENDED();
                    if (this.label != 0) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    ResultKt.throwOnFailure(obj);
                    this.$pressScope.cancel();
                    return Unit.INSTANCE;
                }
            }

            /* JADX INFO: renamed from: androidx.compose.foundation.gestures.TapGestureDetectorKt$detectTapGestures$2$1$4, reason: invalid class name */
            /* JADX INFO: compiled from: TapGestureDetector.kt */
            @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
            @DebugMetadata(c = "androidx.compose.foundation.gestures.TapGestureDetectorKt$detectTapGestures$2$1$4", f = "TapGestureDetector.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {}, v = 1)
            static final class AnonymousClass4 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
                final /* synthetic */ PressGestureScopeImpl $pressScope;
                int label;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                AnonymousClass4(PressGestureScopeImpl pressGestureScopeImpl, Continuation<? super AnonymousClass4> continuation) {
                    super(2, continuation);
                    this.$pressScope = pressGestureScopeImpl;
                }

                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                    return new AnonymousClass4(this.$pressScope, continuation);
                }

                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                    return ((AnonymousClass4) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
                }

                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                public final Object invokeSuspend(Object obj) {
                    IntrinsicsKt.getCOROUTINE_SUSPENDED();
                    if (this.label != 0) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    ResultKt.throwOnFailure(obj);
                    this.$pressScope.release();
                    return Unit.INSTANCE;
                }
            }

            /* JADX INFO: renamed from: androidx.compose.foundation.gestures.TapGestureDetectorKt$detectTapGestures$2$1$5, reason: invalid class name */
            /* JADX INFO: compiled from: TapGestureDetector.kt */
            @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
            @DebugMetadata(c = "androidx.compose.foundation.gestures.TapGestureDetectorKt$detectTapGestures$2$1$5", f = "TapGestureDetector.kt", i = {}, l = {Token.SETCONSTVAR, Token.ARRAYCOMP}, m = "invokeSuspend", n = {}, s = {}, v = 1)
            static final class AnonymousClass5 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
                final /* synthetic */ Job $cancelOrReleaseJob;
                final /* synthetic */ PressGestureScopeImpl $pressScope;
                int label;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                AnonymousClass5(Job job, PressGestureScopeImpl pressGestureScopeImpl, Continuation<? super AnonymousClass5> continuation) {
                    super(2, continuation);
                    this.$cancelOrReleaseJob = job;
                    this.$pressScope = pressGestureScopeImpl;
                }

                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                    return new AnonymousClass5(this.$cancelOrReleaseJob, this.$pressScope, continuation);
                }

                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                    return ((AnonymousClass5) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
                }

                /* JADX WARN: Code restructure failed: missing block: B:14:0x003a, code lost:
                
                    if (r4.$pressScope.reset(r4) == r0) goto L15;
                 */
                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                    To view partially-correct add '--show-bad-code' argument
                */
                public final java.lang.Object invokeSuspend(java.lang.Object r5) {
                    /*
                        r4 = this;
                        java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
                        int r1 = r4.label
                        r2 = 2
                        r3 = 1
                        if (r1 == 0) goto L1e
                        if (r1 == r3) goto L1a
                        if (r1 != r2) goto L12
                        kotlin.ResultKt.throwOnFailure(r5)
                        goto L3d
                    L12:
                        java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
                        java.lang.String r5 = "call to 'resume' before 'invoke' with coroutine"
                        r4.<init>(r5)
                        throw r4
                    L1a:
                        kotlin.ResultKt.throwOnFailure(r5)
                        goto L2f
                    L1e:
                        kotlin.ResultKt.throwOnFailure(r5)
                        kotlinx.coroutines.Job r5 = r4.$cancelOrReleaseJob
                        r1 = r4
                        kotlin.coroutines.Continuation r1 = (kotlin.coroutines.Continuation) r1
                        r4.label = r3
                        java.lang.Object r5 = r5.join(r1)
                        if (r5 != r0) goto L2f
                        goto L3c
                    L2f:
                        androidx.compose.foundation.gestures.PressGestureScopeImpl r5 = r4.$pressScope
                        r1 = r4
                        kotlin.coroutines.Continuation r1 = (kotlin.coroutines.Continuation) r1
                        r4.label = r2
                        java.lang.Object r4 = r5.reset(r1)
                        if (r4 != r0) goto L3d
                    L3c:
                        return r0
                    L3d:
                        kotlin.Unit r4 = kotlin.Unit.INSTANCE
                        return r4
                    */
                    throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.gestures.TapGestureDetectorKt.C06292.AnonymousClass1.AnonymousClass5.invokeSuspend(java.lang.Object):java.lang.Object");
                }
            }

            /* JADX INFO: renamed from: androidx.compose.foundation.gestures.TapGestureDetectorKt$detectTapGestures$2$1$6, reason: invalid class name */
            /* JADX INFO: compiled from: TapGestureDetector.kt */
            @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
            @DebugMetadata(c = "androidx.compose.foundation.gestures.TapGestureDetectorKt$detectTapGestures$2$1$6", f = "TapGestureDetector.kt", i = {}, l = {Token.DEBUGGER}, m = "invokeSuspend", n = {}, s = {}, v = 1)
            static final class AnonymousClass6 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
                final /* synthetic */ Function3<PressGestureScope, Offset, Continuation<? super Unit>, Object> $onPress;
                final /* synthetic */ PressGestureScopeImpl $pressScope;
                final /* synthetic */ PointerInputChange $secondDown;
                int label;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                AnonymousClass6(Function3<? super PressGestureScope, ? super Offset, ? super Continuation<? super Unit>, ? extends Object> function3, PressGestureScopeImpl pressGestureScopeImpl, PointerInputChange pointerInputChange, Continuation<? super AnonymousClass6> continuation) {
                    super(2, continuation);
                    this.$onPress = function3;
                    this.$pressScope = pressGestureScopeImpl;
                    this.$secondDown = pointerInputChange;
                }

                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                    return new AnonymousClass6(this.$onPress, this.$pressScope, this.$secondDown, continuation);
                }

                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                    return ((AnonymousClass6) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
                }

                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                public final Object invokeSuspend(Object obj) {
                    Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                    int i = this.label;
                    if (i == 0) {
                        ResultKt.throwOnFailure(obj);
                        Function3<PressGestureScope, Offset, Continuation<? super Unit>, Object> function3 = this.$onPress;
                        PressGestureScopeImpl pressGestureScopeImpl = this.$pressScope;
                        Offset offsetM6558boximpl = Offset.m6558boximpl(this.$secondDown.getPosition());
                        this.label = 1;
                        if (function3.invoke(pressGestureScopeImpl, offsetM6558boximpl, this) == coroutine_suspended) {
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

            /* JADX INFO: renamed from: androidx.compose.foundation.gestures.TapGestureDetectorKt$detectTapGestures$2$1$7, reason: invalid class name */
            /* JADX INFO: compiled from: TapGestureDetector.kt */
            @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
            @DebugMetadata(c = "androidx.compose.foundation.gestures.TapGestureDetectorKt$detectTapGestures$2$1$7", f = "TapGestureDetector.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {}, v = 1)
            static final class AnonymousClass7 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
                final /* synthetic */ PressGestureScopeImpl $pressScope;
                int label;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                AnonymousClass7(PressGestureScopeImpl pressGestureScopeImpl, Continuation<? super AnonymousClass7> continuation) {
                    super(2, continuation);
                    this.$pressScope = pressGestureScopeImpl;
                }

                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                    return new AnonymousClass7(this.$pressScope, continuation);
                }

                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                    return ((AnonymousClass7) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
                }

                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                public final Object invokeSuspend(Object obj) {
                    IntrinsicsKt.getCOROUTINE_SUSPENDED();
                    if (this.label != 0) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    ResultKt.throwOnFailure(obj);
                    this.$pressScope.release();
                    return Unit.INSTANCE;
                }
            }

            /* JADX INFO: renamed from: androidx.compose.foundation.gestures.TapGestureDetectorKt$detectTapGestures$2$1$8, reason: invalid class name */
            /* JADX INFO: compiled from: TapGestureDetector.kt */
            @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
            @DebugMetadata(c = "androidx.compose.foundation.gestures.TapGestureDetectorKt$detectTapGestures$2$1$8", f = "TapGestureDetector.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {}, v = 1)
            static final class AnonymousClass8 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
                final /* synthetic */ PressGestureScopeImpl $pressScope;
                int label;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                AnonymousClass8(PressGestureScopeImpl pressGestureScopeImpl, Continuation<? super AnonymousClass8> continuation) {
                    super(2, continuation);
                    this.$pressScope = pressGestureScopeImpl;
                }

                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                    return new AnonymousClass8(this.$pressScope, continuation);
                }

                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                    return ((AnonymousClass8) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
                }

                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                public final Object invokeSuspend(Object obj) {
                    IntrinsicsKt.getCOROUTINE_SUSPENDED();
                    if (this.label != 0) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    ResultKt.throwOnFailure(obj);
                    this.$pressScope.cancel();
                    return Unit.INSTANCE;
                }
            }
        }
    }

    public static final Object detectTapGestures(PointerInputScope pointerInputScope, Function1<? super Offset, Unit> function1, Function1<? super Offset, Unit> function2, Function3<? super PressGestureScope, ? super Offset, ? super Continuation<? super Unit>, ? extends Object> function3, Function1<? super Offset, Unit> function4, Continuation<? super Unit> continuation) {
        Object objCoroutineScope = CoroutineScopeKt.coroutineScope(new C06292(pointerInputScope, function3, function2, function1, function4, null), continuation);
        return objCoroutineScope == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objCoroutineScope : Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:17:0x0044 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:20:0x0056 A[LOOP:0: B:19:0x0054->B:20:0x0056, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:23:0x006f  */
    /* JADX WARN: Code duplicated, block: B:26:0x007c A[LOOP:1: B:22:0x006d->B:26:0x007c, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:31:0x0039 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:16:0x0042 -> B:18:0x0045). Please report as a decompilation issue!!! */
    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions count limit reached at block B:23:0x006f
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        */
    public static final java.lang.Object consumeUntilUp(androidx.compose.ui.input.pointer.AwaitPointerEventScope r8, kotlin.coroutines.Continuation<? super kotlin.Unit> r9) {
        /*
            boolean r0 = r9 instanceof androidx.compose.foundation.gestures.TapGestureDetectorKt.C06271
            if (r0 == 0) goto L14
            r0 = r9
            androidx.compose.foundation.gestures.TapGestureDetectorKt$consumeUntilUp$1 r0 = (androidx.compose.foundation.gestures.TapGestureDetectorKt.C06271) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L14
            int r9 = r0.label
            int r9 = r9 - r2
            r0.label = r9
            goto L19
        L14:
            androidx.compose.foundation.gestures.TapGestureDetectorKt$consumeUntilUp$1 r0 = new androidx.compose.foundation.gestures.TapGestureDetectorKt$consumeUntilUp$1
            r0.<init>(r9)
        L19:
            java.lang.Object r9 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L36
            if (r2 != r3) goto L2e
            java.lang.Object r8 = r0.L$0
            androidx.compose.ui.input.pointer.AwaitPointerEventScope r8 = (androidx.compose.ui.input.pointer.AwaitPointerEventScope) r8
            kotlin.ResultKt.throwOnFailure(r9)
            goto L45
        L2e:
            java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
            java.lang.String r9 = "call to 'resume' before 'invoke' with coroutine"
            r8.<init>(r9)
            throw r8
        L36:
            kotlin.ResultKt.throwOnFailure(r9)
        L39:
            r0.L$0 = r8
            r0.label = r3
            r9 = 0
            java.lang.Object r9 = androidx.compose.ui.input.pointer.AwaitPointerEventScope.awaitPointerEvent$default(r8, r9, r0, r3, r9)
            if (r9 != r1) goto L45
            return r1
        L45:
            androidx.compose.ui.input.pointer.PointerEvent r9 = (androidx.compose.ui.input.pointer.PointerEvent) r9
            java.util.List r2 = r9.getChanges()
            r4 = r2
            java.util.Collection r4 = (java.util.Collection) r4
            int r4 = r4.size()
            r5 = 0
            r6 = r5
        L54:
            if (r6 >= r4) goto L62
            java.lang.Object r7 = r2.get(r6)
            androidx.compose.ui.input.pointer.PointerInputChange r7 = (androidx.compose.ui.input.pointer.PointerInputChange) r7
            r7.consume()
            int r6 = r6 + 1
            goto L54
        L62:
            java.util.List r9 = r9.getChanges()
            r2 = r9
            java.util.Collection r2 = (java.util.Collection) r2
            int r2 = r2.size()
        L6d:
            if (r5 >= r2) goto L7f
            java.lang.Object r4 = r9.get(r5)
            androidx.compose.ui.input.pointer.PointerInputChange r4 = (androidx.compose.ui.input.pointer.PointerInputChange) r4
            boolean r4 = r4.getPressed()
            if (r4 == 0) goto L7c
            goto L39
        L7c:
            int r5 = r5 + 1
            goto L6d
        L7f:
            kotlin.Unit r8 = kotlin.Unit.INSTANCE
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.gestures.TapGestureDetectorKt.consumeUntilUp(androidx.compose.ui.input.pointer.AwaitPointerEventScope, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX INFO: renamed from: androidx.compose.foundation.gestures.TapGestureDetectorKt$awaitSecondDown$2, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: TapGestureDetector.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "Landroidx/compose/ui/input/pointer/PointerInputChange;", "Landroidx/compose/ui/input/pointer/AwaitPointerEventScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
    @DebugMetadata(c = "androidx.compose.foundation.gestures.TapGestureDetectorKt$awaitSecondDown$2", f = "TapGestureDetector.kt", i = {0, 0}, l = {227}, m = "invokeSuspend", n = {"$this$withTimeoutOrNull", "minUptime"}, s = {"L$0", "J$0"}, v = 1)
    static final class C06262 extends RestrictedSuspendLambda implements Function2<AwaitPointerEventScope, Continuation<? super PointerInputChange>, Object> {
        final /* synthetic */ PointerInputChange $firstUp;
        long J$0;
        private /* synthetic */ Object L$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C06262(PointerInputChange pointerInputChange, Continuation<? super C06262> continuation) {
            super(2, continuation);
            this.$firstUp = pointerInputChange;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            C06262 c06262 = new C06262(this.$firstUp, continuation);
            c06262.L$0 = obj;
            return c06262;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(AwaitPointerEventScope awaitPointerEventScope, Continuation<? super PointerInputChange> continuation) {
            return ((C06262) create(awaitPointerEventScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Code duplicated, block: B:11:0x0048 A[RETURN] */
        /* JADX WARN: Code duplicated, block: B:14:0x0053 A[RETURN] */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:10:0x0046 -> B:12:0x0049). Please report as a decompilation issue!!! */
        /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
            jadx.core.utils.exceptions.JadxOverflowException: Regions count limit reached at block B:0:?
            	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
            	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
            	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
            */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final java.lang.Object invokeSuspend(java.lang.Object r12) {
            /*
                r11 = this;
                java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
                int r1 = r11.label
                r2 = 1
                if (r1 == 0) goto L1e
                if (r1 != r2) goto L16
                long r3 = r11.J$0
                java.lang.Object r1 = r11.L$0
                androidx.compose.ui.input.pointer.AwaitPointerEventScope r1 = (androidx.compose.ui.input.pointer.AwaitPointerEventScope) r1
                kotlin.ResultKt.throwOnFailure(r12)
                r5 = r1
                goto L49
            L16:
                java.lang.IllegalStateException r11 = new java.lang.IllegalStateException
                java.lang.String r12 = "call to 'resume' before 'invoke' with coroutine"
                r11.<init>(r12)
                throw r11
            L1e:
                kotlin.ResultKt.throwOnFailure(r12)
                java.lang.Object r12 = r11.L$0
                androidx.compose.ui.input.pointer.AwaitPointerEventScope r12 = (androidx.compose.ui.input.pointer.AwaitPointerEventScope) r12
                androidx.compose.ui.input.pointer.PointerInputChange r1 = r11.$firstUp
                long r3 = r1.getUptimeMillis()
                androidx.compose.ui.platform.ViewConfiguration r1 = r12.getViewConfiguration()
                long r5 = r1.getDoubleTapMinTimeMillis()
                long r3 = r3 + r5
                r5 = r12
            L35:
                r8 = r11
                kotlin.coroutines.Continuation r8 = (kotlin.coroutines.Continuation) r8
                r11.L$0 = r5
                r11.J$0 = r3
                r11.label = r2
                r6 = 0
                r7 = 0
                r9 = 3
                r10 = 0
                java.lang.Object r12 = androidx.compose.foundation.gestures.TapGestureDetectorKt.awaitFirstDown$default(r5, r6, r7, r8, r9, r10)
                if (r12 != r0) goto L49
                return r0
            L49:
                androidx.compose.ui.input.pointer.PointerInputChange r12 = (androidx.compose.ui.input.pointer.PointerInputChange) r12
                long r6 = r12.getUptimeMillis()
                int r1 = (r6 > r3 ? 1 : (r6 == r3 ? 0 : -1))
                if (r1 < 0) goto L35
                return r12
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.gestures.TapGestureDetectorKt.C06262.invokeSuspend(java.lang.Object):java.lang.Object");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Object awaitSecondDown(AwaitPointerEventScope awaitPointerEventScope, PointerInputChange pointerInputChange, Continuation<? super PointerInputChange> continuation) {
        return awaitPointerEventScope.withTimeoutOrNull(awaitPointerEventScope.getViewConfiguration().getDoubleTapTimeoutMillis(), new C06262(pointerInputChange, null), continuation);
    }

    public static /* synthetic */ Object detectTapAndPress$default(PointerInputScope pointerInputScope, Function3 function3, Function1 function1, Continuation continuation, int i, Object obj) {
        if ((i & 1) != 0) {
            function3 = NoPressGesture;
        }
        if ((i & 2) != 0) {
            function1 = null;
        }
        return detectTapAndPress(pointerInputScope, function3, function1, continuation);
    }

    /* JADX INFO: renamed from: androidx.compose.foundation.gestures.TapGestureDetectorKt$detectTapAndPress$2, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: TapGestureDetector.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
    @DebugMetadata(c = "androidx.compose.foundation.gestures.TapGestureDetectorKt$detectTapAndPress$2", f = "TapGestureDetector.kt", i = {}, l = {247}, m = "invokeSuspend", n = {}, s = {}, v = 1)
    static final class C06282 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ Function3<PressGestureScope, Offset, Continuation<? super Unit>, Object> $onPress;
        final /* synthetic */ Function1<Offset, Unit> $onTap;
        final /* synthetic */ PressGestureScopeImpl $pressScope;
        final /* synthetic */ PointerInputScope $this_detectTapAndPress;
        private /* synthetic */ Object L$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        C06282(PointerInputScope pointerInputScope, Function3<? super PressGestureScope, ? super Offset, ? super Continuation<? super Unit>, ? extends Object> function3, Function1<? super Offset, Unit> function1, PressGestureScopeImpl pressGestureScopeImpl, Continuation<? super C06282> continuation) {
            super(2, continuation);
            this.$this_detectTapAndPress = pointerInputScope;
            this.$onPress = function3;
            this.$onTap = function1;
            this.$pressScope = pressGestureScopeImpl;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            C06282 c06282 = new C06282(this.$this_detectTapAndPress, this.$onPress, this.$onTap, this.$pressScope, continuation);
            c06282.L$0 = obj;
            return c06282;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C06282) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX INFO: renamed from: androidx.compose.foundation.gestures.TapGestureDetectorKt$detectTapAndPress$2$1, reason: invalid class name */
        /* JADX INFO: compiled from: TapGestureDetector.kt */
        @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Landroidx/compose/ui/input/pointer/AwaitPointerEventScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
        @DebugMetadata(c = "androidx.compose.foundation.gestures.TapGestureDetectorKt$detectTapAndPress$2$1", f = "TapGestureDetector.kt", i = {0, 0, 1}, l = {251, 257}, m = "invokeSuspend", n = {"$this$awaitEachGesture", "resetJob", "resetJob"}, s = {"L$0", "L$1", "L$0"}, v = 1)
        static final class AnonymousClass1 extends RestrictedSuspendLambda implements Function2<AwaitPointerEventScope, Continuation<? super Unit>, Object> {
            final /* synthetic */ CoroutineScope $$this$coroutineScope;
            final /* synthetic */ Function3<PressGestureScope, Offset, Continuation<? super Unit>, Object> $onPress;
            final /* synthetic */ Function1<Offset, Unit> $onTap;
            final /* synthetic */ PressGestureScopeImpl $pressScope;
            private /* synthetic */ Object L$0;
            Object L$1;
            int label;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            AnonymousClass1(CoroutineScope coroutineScope, Function3<? super PressGestureScope, ? super Offset, ? super Continuation<? super Unit>, ? extends Object> function3, Function1<? super Offset, Unit> function1, PressGestureScopeImpl pressGestureScopeImpl, Continuation<? super AnonymousClass1> continuation) {
                super(2, continuation);
                this.$$this$coroutineScope = coroutineScope;
                this.$onPress = function3;
                this.$onTap = function1;
                this.$pressScope = pressGestureScopeImpl;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                AnonymousClass1 anonymousClass1 = new AnonymousClass1(this.$$this$coroutineScope, this.$onPress, this.$onTap, this.$pressScope, continuation);
                anonymousClass1.L$0 = obj;
                return anonymousClass1;
            }

            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(AwaitPointerEventScope awaitPointerEventScope, Continuation<? super Unit> continuation) {
                return ((AnonymousClass1) create(awaitPointerEventScope, continuation)).invokeSuspend(Unit.INSTANCE);
            }

            /* JADX WARN: Code restructure failed: missing block: B:17:0x008f, code lost:
            
                if (r13 == r0) goto L18;
             */
            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct add '--show-bad-code' argument
            */
            public final java.lang.Object invokeSuspend(java.lang.Object r13) {
                /*
                    Method dump skipped, instruction units count: 208
                    To view this dump add '--comments-level debug' option
                */
                throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.gestures.TapGestureDetectorKt.C06282.AnonymousClass1.invokeSuspend(java.lang.Object):java.lang.Object");
            }

            /* JADX INFO: renamed from: androidx.compose.foundation.gestures.TapGestureDetectorKt$detectTapAndPress$2$1$1, reason: invalid class name and collision with other inner class name */
            /* JADX INFO: compiled from: TapGestureDetector.kt */
            @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
            @DebugMetadata(c = "androidx.compose.foundation.gestures.TapGestureDetectorKt$detectTapAndPress$2$1$1", f = "TapGestureDetector.kt", i = {}, l = {254}, m = "invokeSuspend", n = {}, s = {}, v = 1)
            static final class C00201 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
                final /* synthetic */ PointerInputChange $down;
                final /* synthetic */ Function3<PressGestureScope, Offset, Continuation<? super Unit>, Object> $onPress;
                final /* synthetic */ PressGestureScopeImpl $pressScope;
                int label;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                C00201(Function3<? super PressGestureScope, ? super Offset, ? super Continuation<? super Unit>, ? extends Object> function3, PressGestureScopeImpl pressGestureScopeImpl, PointerInputChange pointerInputChange, Continuation<? super C00201> continuation) {
                    super(2, continuation);
                    this.$onPress = function3;
                    this.$pressScope = pressGestureScopeImpl;
                    this.$down = pointerInputChange;
                }

                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                    return new C00201(this.$onPress, this.$pressScope, this.$down, continuation);
                }

                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                    return ((C00201) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
                }

                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                public final Object invokeSuspend(Object obj) {
                    Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                    int i = this.label;
                    if (i == 0) {
                        ResultKt.throwOnFailure(obj);
                        Function3<PressGestureScope, Offset, Continuation<? super Unit>, Object> function3 = this.$onPress;
                        PressGestureScopeImpl pressGestureScopeImpl = this.$pressScope;
                        Offset offsetM6558boximpl = Offset.m6558boximpl(this.$down.getPosition());
                        this.label = 1;
                        if (function3.invoke(pressGestureScopeImpl, offsetM6558boximpl, this) == coroutine_suspended) {
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

            /* JADX INFO: renamed from: androidx.compose.foundation.gestures.TapGestureDetectorKt$detectTapAndPress$2$1$2, reason: invalid class name and collision with other inner class name */
            /* JADX INFO: compiled from: TapGestureDetector.kt */
            @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
            @DebugMetadata(c = "androidx.compose.foundation.gestures.TapGestureDetectorKt$detectTapAndPress$2$1$2", f = "TapGestureDetector.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {}, v = 1)
            static final class C00212 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
                final /* synthetic */ PressGestureScopeImpl $pressScope;
                int label;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                C00212(PressGestureScopeImpl pressGestureScopeImpl, Continuation<? super C00212> continuation) {
                    super(2, continuation);
                    this.$pressScope = pressGestureScopeImpl;
                }

                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                    return new C00212(this.$pressScope, continuation);
                }

                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                    return ((C00212) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
                }

                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                public final Object invokeSuspend(Object obj) {
                    IntrinsicsKt.getCOROUTINE_SUSPENDED();
                    if (this.label != 0) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    ResultKt.throwOnFailure(obj);
                    this.$pressScope.cancel();
                    return Unit.INSTANCE;
                }
            }

            /* JADX INFO: renamed from: androidx.compose.foundation.gestures.TapGestureDetectorKt$detectTapAndPress$2$1$3, reason: invalid class name */
            /* JADX INFO: compiled from: TapGestureDetector.kt */
            @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
            @DebugMetadata(c = "androidx.compose.foundation.gestures.TapGestureDetectorKt$detectTapAndPress$2$1$3", f = "TapGestureDetector.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {}, v = 1)
            static final class AnonymousClass3 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
                final /* synthetic */ PressGestureScopeImpl $pressScope;
                int label;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                AnonymousClass3(PressGestureScopeImpl pressGestureScopeImpl, Continuation<? super AnonymousClass3> continuation) {
                    super(2, continuation);
                    this.$pressScope = pressGestureScopeImpl;
                }

                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                    return new AnonymousClass3(this.$pressScope, continuation);
                }

                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                    return ((AnonymousClass3) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
                }

                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                public final Object invokeSuspend(Object obj) {
                    IntrinsicsKt.getCOROUTINE_SUSPENDED();
                    if (this.label != 0) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    ResultKt.throwOnFailure(obj);
                    this.$pressScope.release();
                    return Unit.INSTANCE;
                }
            }
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                CoroutineScope coroutineScope = (CoroutineScope) this.L$0;
                this.label = 1;
                if (ForEachGestureKt.awaitEachGesture(this.$this_detectTapAndPress, new AnonymousClass1(coroutineScope, this.$onPress, this.$onTap, this.$pressScope, null), this) == coroutine_suspended) {
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

    public static final Object detectTapAndPress(PointerInputScope pointerInputScope, Function3<? super PressGestureScope, ? super Offset, ? super Continuation<? super Unit>, ? extends Object> function3, Function1<? super Offset, Unit> function1, Continuation<? super Unit> continuation) {
        Object objCoroutineScope = CoroutineScopeKt.coroutineScope(new C06282(pointerInputScope, function3, function1, new PressGestureScopeImpl(pointerInputScope), null), continuation);
        return objCoroutineScope == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objCoroutineScope : Unit.INSTANCE;
    }

    public static /* synthetic */ Object awaitFirstDown$default(AwaitPointerEventScope awaitPointerEventScope, boolean z, Continuation continuation, int i, Object obj) {
        if ((i & 1) != 0) {
            z = true;
        }
        return awaitFirstDown(awaitPointerEventScope, z, continuation);
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Maintained for binary compatibility. Use version with PointerEventPass instead.")
    public static final /* synthetic */ Object awaitFirstDown(AwaitPointerEventScope awaitPointerEventScope, boolean z, Continuation continuation) {
        return awaitFirstDown(awaitPointerEventScope, z, PointerEventPass.Main, continuation);
    }

    /* JADX WARN: Code duplicated, block: B:17:0x0051 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:20:0x005d  */
    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:16:0x004f -> B:18:0x0052). Please report as a decompilation issue!!! */
    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions count limit reached at block B:0:?
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        */
    public static final java.lang.Object awaitFirstDown(androidx.compose.ui.input.pointer.AwaitPointerEventScope r7, boolean r8, androidx.compose.ui.input.pointer.PointerEventPass r9, kotlin.coroutines.Continuation<? super androidx.compose.ui.input.pointer.PointerInputChange> r10) {
        /*
            boolean r0 = r10 instanceof androidx.compose.foundation.gestures.TapGestureDetectorKt.AnonymousClass2
            if (r0 == 0) goto L14
            r0 = r10
            androidx.compose.foundation.gestures.TapGestureDetectorKt$awaitFirstDown$2 r0 = (androidx.compose.foundation.gestures.TapGestureDetectorKt.AnonymousClass2) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L14
            int r10 = r0.label
            int r10 = r10 - r2
            r0.label = r10
            goto L19
        L14:
            androidx.compose.foundation.gestures.TapGestureDetectorKt$awaitFirstDown$2 r0 = new androidx.compose.foundation.gestures.TapGestureDetectorKt$awaitFirstDown$2
            r0.<init>(r10)
        L19:
            java.lang.Object r10 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L40
            if (r2 != r3) goto L38
            boolean r7 = r0.Z$0
            java.lang.Object r8 = r0.L$1
            androidx.compose.ui.input.pointer.PointerEventPass r8 = (androidx.compose.ui.input.pointer.PointerEventPass) r8
            java.lang.Object r9 = r0.L$0
            androidx.compose.ui.input.pointer.AwaitPointerEventScope r9 = (androidx.compose.ui.input.pointer.AwaitPointerEventScope) r9
            kotlin.ResultKt.throwOnFailure(r10)
            r6 = r8
            r8 = r7
            r7 = r9
            r9 = r6
            goto L52
        L38:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.String r8 = "call to 'resume' before 'invoke' with coroutine"
            r7.<init>(r8)
            throw r7
        L40:
            kotlin.ResultKt.throwOnFailure(r10)
        L43:
            r0.L$0 = r7
            r0.L$1 = r9
            r0.Z$0 = r8
            r0.label = r3
            java.lang.Object r10 = r7.awaitPointerEvent(r9, r0)
            if (r10 != r1) goto L52
            return r1
        L52:
            androidx.compose.ui.input.pointer.PointerEvent r10 = (androidx.compose.ui.input.pointer.PointerEvent) r10
            r2 = 2
            r4 = 0
            r5 = 0
            boolean r2 = isChangedToDown$default(r10, r8, r5, r2, r4)
            if (r2 == 0) goto L43
            java.util.List r7 = r10.getChanges()
            java.lang.Object r7 = r7.get(r5)
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.gestures.TapGestureDetectorKt.awaitFirstDown(androidx.compose.ui.input.pointer.AwaitPointerEventScope, boolean, androidx.compose.ui.input.pointer.PointerEventPass, kotlin.coroutines.Continuation):java.lang.Object");
    }

    public static /* synthetic */ Object awaitFirstDown$default(AwaitPointerEventScope awaitPointerEventScope, boolean z, PointerEventPass pointerEventPass, Continuation continuation, int i, Object obj) {
        if ((i & 1) != 0) {
            z = true;
        }
        if ((i & 2) != 0) {
            pointerEventPass = PointerEventPass.Main;
        }
        return awaitFirstDown(awaitPointerEventScope, z, pointerEventPass, continuation);
    }

    /* JADX WARN: Code duplicated, block: B:17:0x0051 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:20:0x005a  */
    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:16:0x004f -> B:18:0x0052). Please report as a decompilation issue!!! */
    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions count limit reached at block B:0:?
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        */
    public static final java.lang.Object awaitPrimaryFirstDown(androidx.compose.ui.input.pointer.AwaitPointerEventScope r5, boolean r6, androidx.compose.ui.input.pointer.PointerEventPass r7, kotlin.coroutines.Continuation<? super androidx.compose.ui.input.pointer.PointerInputChange> r8) {
        /*
            boolean r0 = r8 instanceof androidx.compose.foundation.gestures.TapGestureDetectorKt.AnonymousClass1
            if (r0 == 0) goto L14
            r0 = r8
            androidx.compose.foundation.gestures.TapGestureDetectorKt$awaitPrimaryFirstDown$1 r0 = (androidx.compose.foundation.gestures.TapGestureDetectorKt.AnonymousClass1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L14
            int r8 = r0.label
            int r8 = r8 - r2
            r0.label = r8
            goto L19
        L14:
            androidx.compose.foundation.gestures.TapGestureDetectorKt$awaitPrimaryFirstDown$1 r0 = new androidx.compose.foundation.gestures.TapGestureDetectorKt$awaitPrimaryFirstDown$1
            r0.<init>(r8)
        L19:
            java.lang.Object r8 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L40
            if (r2 != r3) goto L38
            boolean r5 = r0.Z$0
            java.lang.Object r6 = r0.L$1
            androidx.compose.ui.input.pointer.PointerEventPass r6 = (androidx.compose.ui.input.pointer.PointerEventPass) r6
            java.lang.Object r7 = r0.L$0
            androidx.compose.ui.input.pointer.AwaitPointerEventScope r7 = (androidx.compose.ui.input.pointer.AwaitPointerEventScope) r7
            kotlin.ResultKt.throwOnFailure(r8)
            r4 = r6
            r6 = r5
            r5 = r7
            r7 = r4
            goto L52
        L38:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L40:
            kotlin.ResultKt.throwOnFailure(r8)
        L43:
            r0.L$0 = r5
            r0.L$1 = r7
            r0.Z$0 = r6
            r0.label = r3
            java.lang.Object r8 = r5.awaitPointerEvent(r7, r0)
            if (r8 != r1) goto L52
            return r1
        L52:
            androidx.compose.ui.input.pointer.PointerEvent r8 = (androidx.compose.ui.input.pointer.PointerEvent) r8
            boolean r2 = isChangedToDown(r8, r6, r3)
            if (r2 == 0) goto L43
            java.util.List r5 = r8.getChanges()
            r6 = 0
            java.lang.Object r5 = r5.get(r6)
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.gestures.TapGestureDetectorKt.awaitPrimaryFirstDown(androidx.compose.ui.input.pointer.AwaitPointerEventScope, boolean, androidx.compose.ui.input.pointer.PointerEventPass, kotlin.coroutines.Continuation):java.lang.Object");
    }

    public static /* synthetic */ Object awaitPrimaryFirstDown$default(AwaitPointerEventScope awaitPointerEventScope, boolean z, PointerEventPass pointerEventPass, Continuation continuation, int i, Object obj) {
        if ((i & 1) != 0) {
            z = true;
        }
        if ((i & 2) != 0) {
            pointerEventPass = PointerEventPass.Main;
        }
        return awaitPrimaryFirstDown(awaitPointerEventScope, z, pointerEventPass, continuation);
    }

    public static /* synthetic */ boolean isChangedToDown$default(PointerEvent pointerEvent, boolean z, boolean z2, int i, Object obj) {
        if ((i & 2) != 0) {
            z2 = TapGestureDetector_androidKt.firstDownRefersToPrimaryMouseButtonOnly();
        }
        return isChangedToDown(pointerEvent, z, z2);
    }

    public static final boolean isChangedToDown(PointerEvent pointerEvent, boolean z, boolean z2) {
        if (z2) {
            List<PointerInputChange> changes = pointerEvent.getChanges();
            int size = changes.size();
            int i = 0;
            while (true) {
                if (i < size) {
                    if (!PointerType.m8205equalsimpl0(changes.get(i).getType(), PointerType.INSTANCE.m8210getMouseT8wyACA())) {
                        break;
                    }
                    i++;
                } else {
                    if (PointerEvent_androidKt.m8107isPrimaryPressedaHzCxE(pointerEvent.getButtons())) {
                        break;
                    }
                    return false;
                }
            }
        }
        List<PointerInputChange> changes2 = pointerEvent.getChanges();
        int size2 = changes2.size();
        for (int i2 = 0; i2 < size2; i2++) {
            PointerInputChange pointerInputChange = changes2.get(i2);
            if (!(z ? PointerEventKt.changedToDown(pointerInputChange) : PointerEventKt.changedToDownIgnoreConsumed(pointerInputChange))) {
                return false;
            }
        }
        return true;
    }

    /* JADX WARN: Code duplicated, block: B:24:0x0082  */
    /* JADX WARN: Code duplicated, block: B:28:0x009c  */
    /* JADX WARN: Code duplicated, block: B:30:0x00a8  */
    /* JADX WARN: Code duplicated, block: B:45:0x00ed A[LOOP:1: B:23:0x0080->B:45:0x00ed, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:51:0x008e A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:53:0x00ba A[ADDED_TO_REGION, REMOVE, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:7:0x0016  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:36:0x00c7 -> B:13:0x0038). Please report as a decompilation issue!!! */
    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions stack size limit reached
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        */
    public static final java.lang.Object waitForUpOrCancellation(androidx.compose.ui.input.pointer.AwaitPointerEventScope r17, androidx.compose.ui.input.pointer.PointerEventPass r18, kotlin.coroutines.Continuation<? super androidx.compose.ui.input.pointer.PointerInputChange> r19) {
        /*
            Method dump skipped, instruction units count: 249
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.gestures.TapGestureDetectorKt.waitForUpOrCancellation(androidx.compose.ui.input.pointer.AwaitPointerEventScope, androidx.compose.ui.input.pointer.PointerEventPass, kotlin.coroutines.Continuation):java.lang.Object");
    }

    public static /* synthetic */ Object waitForUpOrCancellation$default(AwaitPointerEventScope awaitPointerEventScope, PointerEventPass pointerEventPass, Continuation continuation, int i, Object obj) {
        if ((i & 1) != 0) {
            pointerEventPass = PointerEventPass.Main;
        }
        return waitForUpOrCancellation(awaitPointerEventScope, pointerEventPass, continuation);
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    /* JADX WARN: Type inference failed for: r2v1, types: [T, androidx.compose.foundation.gestures.LongPressResult$Canceled] */
    public static final Object waitForLongPress(AwaitPointerEventScope awaitPointerEventScope, PointerEventPass pointerEventPass, Continuation<? super LongPressResult> continuation) {
        C06311 c06311;
        Ref.ObjectRef objectRef;
        if (continuation instanceof C06311) {
            c06311 = (C06311) continuation;
            if ((c06311.label & Integer.MIN_VALUE) != 0) {
                c06311.label -= Integer.MIN_VALUE;
            } else {
                c06311 = new C06311(continuation);
            }
        } else {
            c06311 = new C06311(continuation);
        }
        Object obj = c06311.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = c06311.label;
        try {
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                Ref.ObjectRef objectRef2 = new Ref.ObjectRef();
                objectRef2.element = LongPressResult.Canceled.INSTANCE;
                long longPressTimeoutMillis = awaitPointerEventScope.getViewConfiguration().getLongPressTimeoutMillis();
                C06322 c06322 = new C06322(pointerEventPass, objectRef2, null);
                c06311.L$0 = objectRef2;
                c06311.label = 1;
                if (awaitPointerEventScope.withTimeout(longPressTimeoutMillis, c06322, c06311) == coroutine_suspended) {
                    return coroutine_suspended;
                }
                objectRef = objectRef2;
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                objectRef = (Ref.ObjectRef) c06311.L$0;
                ResultKt.throwOnFailure(obj);
            }
            return objectRef.element;
        } catch (PointerEventTimeoutCancellationException unused) {
            return LongPressResult.Success.INSTANCE;
        }
    }

    public static /* synthetic */ Object waitForLongPress$default(AwaitPointerEventScope awaitPointerEventScope, PointerEventPass pointerEventPass, Continuation continuation, int i, Object obj) {
        if ((i & 1) != 0) {
            pointerEventPass = PointerEventPass.Main;
        }
        return waitForLongPress(awaitPointerEventScope, pointerEventPass, continuation);
    }

    /* JADX INFO: renamed from: androidx.compose.foundation.gestures.TapGestureDetectorKt$waitForLongPress$2, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: TapGestureDetector.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Landroidx/compose/ui/input/pointer/AwaitPointerEventScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
    @DebugMetadata(c = "androidx.compose.foundation.gestures.TapGestureDetectorKt$waitForLongPress$2", f = "TapGestureDetector.kt", i = {0, 1}, l = {386, 409}, m = "invokeSuspend", n = {"$this$withTimeout", "$this$withTimeout"}, s = {"L$0", "L$0"}, v = 1)
    static final class C06322 extends RestrictedSuspendLambda implements Function2<AwaitPointerEventScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ PointerEventPass $pass;
        final /* synthetic */ Ref.ObjectRef<LongPressResult> $result;
        private /* synthetic */ Object L$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C06322(PointerEventPass pointerEventPass, Ref.ObjectRef<LongPressResult> objectRef, Continuation<? super C06322> continuation) {
            super(2, continuation);
            this.$pass = pointerEventPass;
            this.$result = objectRef;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            C06322 c06322 = new C06322(this.$pass, this.$result, continuation);
            c06322.L$0 = obj;
            return c06322;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(AwaitPointerEventScope awaitPointerEventScope, Continuation<? super Unit> continuation) {
            return ((C06322) create(awaitPointerEventScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Code duplicated, block: B:17:0x0053  */
        /* JADX WARN: Code duplicated, block: B:21:0x0065  */
        /* JADX WARN: Code duplicated, block: B:22:0x006d  */
        /* JADX WARN: Code duplicated, block: B:26:0x0087  */
        /* JADX WARN: Code duplicated, block: B:41:0x00d9 A[LOOP:1: B:16:0x0051->B:41:0x00d9, LOOP_END] */
        /* JADX WARN: Code duplicated, block: B:47:0x00dd A[SYNTHETIC] */
        /* JADX WARN: Code duplicated, block: B:48:0x005f A[SYNTHETIC] */
        /* JADX WARN: Code duplicated, block: B:50:0x0099 A[ADDED_TO_REGION, REMOVE, SYNTHETIC] */
        /* JADX WARN: Type inference failed for: r0v1, types: [T, androidx.compose.foundation.gestures.LongPressResult$Released] */
        /* JADX WARN: Type inference failed for: r14v11, types: [T, androidx.compose.foundation.gestures.LongPressResult$Canceled] */
        /* JADX WARN: Type inference failed for: r14v12, types: [T, androidx.compose.foundation.gestures.LongPressResult$Success] */
        /* JADX WARN: Type inference failed for: r14v19, types: [T, androidx.compose.foundation.gestures.LongPressResult$Canceled] */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:32:0x00ad -> B:34:0x00b0). Please report as a decompilation issue!!! */
        /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
            jadx.core.utils.exceptions.JadxOverflowException: Regions stack size limit reached
            	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
            	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
            	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
            */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final java.lang.Object invokeSuspend(java.lang.Object r14) {
            /*
                Method dump skipped, instruction units count: 243
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.gestures.TapGestureDetectorKt.C06322.invokeSuspend(java.lang.Object):java.lang.Object");
        }
    }

    public static final void setDetectTapGesturesEnableNewDispatchingBehavior(boolean z) {
        ComposeFoundationFlags composeFoundationFlags = ComposeFoundationFlags.INSTANCE;
        ComposeFoundationFlags.isDetectTapGesturesImmediateCoroutineDispatchEnabled = z;
    }

    public static final boolean getDetectTapGesturesEnableNewDispatchingBehavior() {
        return ComposeFoundationFlags.isDetectTapGesturesImmediateCoroutineDispatchEnabled;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final CoroutineStart getCoroutineStartForCurrentDispatchBehavior() {
        if (ComposeFoundationFlags.isDetectTapGesturesImmediateCoroutineDispatchEnabled) {
            return CoroutineStart.UNDISPATCHED;
        }
        return CoroutineStart.DEFAULT;
    }

    static /* synthetic */ Job launchAwaitingReset$default(CoroutineScope coroutineScope, Job job, CoroutineStart coroutineStart, Function2 function2, int i, Object obj) {
        if ((i & 2) != 0) {
            coroutineStart = getCoroutineStartForCurrentDispatchBehavior();
        }
        return launchAwaitingReset(coroutineScope, job, coroutineStart, function2);
    }

    /* JADX INFO: renamed from: androidx.compose.foundation.gestures.TapGestureDetectorKt$launchAwaitingReset$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: TapGestureDetector.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
    @DebugMetadata(c = "androidx.compose.foundation.gestures.TapGestureDetectorKt$launchAwaitingReset$1", f = "TapGestureDetector.kt", i = {0}, l = {498, 500}, m = "invokeSuspend", n = {"$this$launch"}, s = {"L$0"}, v = 1)
    static final class C06301 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ Function2<CoroutineScope, Continuation<? super Unit>, Object> $block;
        final /* synthetic */ Job $resetJob;
        private /* synthetic */ Object L$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        C06301(Job job, Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object> function2, Continuation<? super C06301> continuation) {
            super(2, continuation);
            this.$resetJob = job;
            this.$block = function2;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            C06301 c06301 = new C06301(this.$resetJob, this.$block, continuation);
            c06301.L$0 = obj;
            return c06301;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C06301) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Code restructure failed: missing block: B:16:0x0049, code lost:
        
            if (r6.invoke(r1, r5) == r0) goto L17;
         */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final java.lang.Object invokeSuspend(java.lang.Object r6) {
            /*
                r5 = this;
                java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
                int r1 = r5.label
                r2 = 2
                r3 = 1
                if (r1 == 0) goto L22
                if (r1 == r3) goto L1a
                if (r1 != r2) goto L12
                kotlin.ResultKt.throwOnFailure(r6)
                goto L4c
            L12:
                java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
                java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
                r5.<init>(r6)
                throw r5
            L1a:
                java.lang.Object r1 = r5.L$0
                kotlinx.coroutines.CoroutineScope r1 = (kotlinx.coroutines.CoroutineScope) r1
                kotlin.ResultKt.throwOnFailure(r6)
                goto L3e
            L22:
                kotlin.ResultKt.throwOnFailure(r6)
                java.lang.Object r6 = r5.L$0
                r1 = r6
                kotlinx.coroutines.CoroutineScope r1 = (kotlinx.coroutines.CoroutineScope) r1
                boolean r6 = androidx.compose.foundation.ComposeFoundationFlags.isDetectTapGesturesImmediateCoroutineDispatchEnabled
                if (r6 == 0) goto L3e
                kotlinx.coroutines.Job r6 = r5.$resetJob
                r4 = r5
                kotlin.coroutines.Continuation r4 = (kotlin.coroutines.Continuation) r4
                r5.L$0 = r1
                r5.label = r3
                java.lang.Object r6 = r6.join(r4)
                if (r6 != r0) goto L3e
                goto L4b
            L3e:
                kotlin.jvm.functions.Function2<kotlinx.coroutines.CoroutineScope, kotlin.coroutines.Continuation<? super kotlin.Unit>, java.lang.Object> r6 = r5.$block
                r3 = 0
                r5.L$0 = r3
                r5.label = r2
                java.lang.Object r5 = r6.invoke(r1, r5)
                if (r5 != r0) goto L4c
            L4b:
                return r0
            L4c:
                kotlin.Unit r5 = kotlin.Unit.INSTANCE
                return r5
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.gestures.TapGestureDetectorKt.C06301.invokeSuspend(java.lang.Object):java.lang.Object");
        }
    }

    private static final Job launchAwaitingReset(CoroutineScope coroutineScope, Job job, CoroutineStart coroutineStart, Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object> function2) {
        return BuildersKt__Builders_commonKt.launch$default(coroutineScope, null, coroutineStart, new C06301(job, function2, null), 1, null);
    }
}
