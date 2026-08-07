package androidx.constraintlayout.compose;

import androidx.compose.foundation.gestures.ForEachGestureKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.MutableFloatState;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.input.pointer.AwaitPointerEventScope;
import androidx.compose.ui.input.pointer.PointerInputChange;
import androidx.compose.ui.input.pointer.PointerInputScope;
import androidx.compose.ui.input.pointer.SuspendPointerInputElement;
import androidx.compose.ui.input.pointer.SuspendingPointerInputFilterKt$sam$androidx_compose_ui_input_pointer_PointerInputEventHandler$0;
import androidx.compose.ui.platform.InspectableValueKt;
import androidx.compose.ui.platform.InspectorInfo;
import androidx.constraintlayout.motion.widget.Key;
import external.sdk.pendo.io.mozilla.javascript.Token;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.RestrictedSuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.channels.Channel;
import kotlinx.coroutines.channels.ChannelKt;

/* JADX INFO: compiled from: MotionDragHandler.kt */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(d1 = {"\u0000L\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a\u008e\u0001\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0012\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u00042\u0012\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00010\u00042\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00010\t2\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00010\t26\u0010\u000b\u001a2\u0012\u0013\u0012\u00110\r¢\u0006\f\b\u000e\u0012\b\b\u000f\u0012\u0004\b\b(\u0010\u0012\u0013\u0012\u00110\u0005¢\u0006\f\b\u000e\u0012\b\b\u000f\u0012\u0004\b\b(\u0011\u0012\u0004\u0012\u00020\u00010\fH\u0082@¢\u0006\u0002\u0010\u0012\u001a$\u0010\u0013\u001a\u00020\u0014*\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001aH\u0001¨\u0006\u001b"}, d2 = {"detectDragGesturesWhenNeeded", "", "Landroidx/compose/ui/input/pointer/PointerInputScope;", "onAcceptFirstDown", "Lkotlin/Function1;", "Landroidx/compose/ui/geometry/Offset;", "", "onDragStart", "onDragEnd", "Lkotlin/Function0;", "onDragCancel", "onDrag", "Lkotlin/Function2;", "Landroidx/compose/ui/input/pointer/PointerInputChange;", "Lkotlin/ParameterName;", "name", "change", "dragAmount", "(Landroidx/compose/ui/input/pointer/PointerInputScope;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function2;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "motionPointerInput", "Landroidx/compose/ui/Modifier;", "key", "", Key.MOTIONPROGRESS, "Landroidx/compose/runtime/MutableFloatState;", "measurer", "Landroidx/constraintlayout/compose/MotionMeasurer;", "constraintlayout-compose_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class MotionDragHandlerKt {

    /* JADX INFO: renamed from: androidx.constraintlayout.compose.MotionDragHandlerKt$detectDragGesturesWhenNeeded$2, reason: invalid class name */
    /* JADX INFO: compiled from: MotionDragHandler.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Landroidx/compose/ui/input/pointer/AwaitPointerEventScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
    @DebugMetadata(c = "androidx.constraintlayout.compose.MotionDragHandlerKt$detectDragGesturesWhenNeeded$2", f = "MotionDragHandler.kt", i = {0, 1, 1, 1}, l = {Token.YIELD_STAR, 174, 183}, m = "invokeSuspend", n = {"$this$awaitEachGesture", "$this$awaitEachGesture", "down", "overSlop"}, s = {"L$0", "L$0", "L$1", "L$2"})
    static final class AnonymousClass2 extends RestrictedSuspendLambda implements Function2<AwaitPointerEventScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ Function1<Offset, Boolean> $onAcceptFirstDown;
        final /* synthetic */ Function2<PointerInputChange, Offset, Unit> $onDrag;
        final /* synthetic */ Function0<Unit> $onDragCancel;
        final /* synthetic */ Function0<Unit> $onDragEnd;
        final /* synthetic */ Function1<Offset, Unit> $onDragStart;
        private /* synthetic */ Object L$0;
        Object L$1;
        Object L$2;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        AnonymousClass2(Function1<? super Offset, Boolean> function1, Function1<? super Offset, Unit> function2, Function2<? super PointerInputChange, ? super Offset, Unit> function3, Function0<Unit> function0, Function0<Unit> function4, Continuation<? super AnonymousClass2> continuation) {
            super(2, continuation);
            this.$onAcceptFirstDown = function1;
            this.$onDragStart = function2;
            this.$onDrag = function3;
            this.$onDragCancel = function0;
            this.$onDragEnd = function4;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            AnonymousClass2 anonymousClass2 = new AnonymousClass2(this.$onAcceptFirstDown, this.$onDragStart, this.$onDrag, this.$onDragCancel, this.$onDragEnd, continuation);
            anonymousClass2.L$0 = obj;
            return anonymousClass2;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(AwaitPointerEventScope awaitPointerEventScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass2) create(awaitPointerEventScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Code duplicated, block: B:24:0x009a A[PHI: r1 r4 r5 r12
          0x009a: PHI (r1v5 kotlin.jvm.internal.Ref$LongRef) = (r1v4 kotlin.jvm.internal.Ref$LongRef), (r1v13 kotlin.jvm.internal.Ref$LongRef) binds: [B:22:0x0097, B:10:0x001e] A[DONT_GENERATE, DONT_INLINE]
          0x009a: PHI (r4v8 androidx.compose.ui.input.pointer.PointerInputChange) = 
          (r4v7 androidx.compose.ui.input.pointer.PointerInputChange)
          (r4v11 androidx.compose.ui.input.pointer.PointerInputChange)
         binds: [B:22:0x0097, B:10:0x001e] A[DONT_GENERATE, DONT_INLINE]
          0x009a: PHI (r5v8 androidx.compose.ui.input.pointer.AwaitPointerEventScope) = 
          (r5v7 androidx.compose.ui.input.pointer.AwaitPointerEventScope)
          (r5v10 androidx.compose.ui.input.pointer.AwaitPointerEventScope)
         binds: [B:22:0x0097, B:10:0x001e] A[DONT_GENERATE, DONT_INLINE]
          0x009a: PHI (r12v8 java.lang.Object) = (r12v7 java.lang.Object), (r12v0 java.lang.Object) binds: [B:22:0x0097, B:10:0x001e] A[DONT_GENERATE, DONT_INLINE]] */
        /* JADX WARN: Code duplicated, block: B:26:0x009e  */
        /* JADX WARN: Code duplicated, block: B:29:0x00a6  */
        /* JADX WARN: Code restructure failed: missing block: B:30:0x00db, code lost:
        
            if (r12 == r0) goto L31;
         */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:22:0x0097 -> B:24:0x009a). Please report as a decompilation issue!!! */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final java.lang.Object invokeSuspend(java.lang.Object r12) {
            /*
                Method dump skipped, instruction units count: 244
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.compose.MotionDragHandlerKt.AnonymousClass2.invokeSuspend(java.lang.Object):java.lang.Object");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Object detectDragGesturesWhenNeeded(PointerInputScope pointerInputScope, Function1<? super Offset, Boolean> function1, Function1<? super Offset, Unit> function2, Function0<Unit> function0, Function0<Unit> function3, Function2<? super PointerInputChange, ? super Offset, Unit> function4, Continuation<? super Unit> continuation) {
        Object objAwaitEachGesture = ForEachGestureKt.awaitEachGesture(pointerInputScope, new AnonymousClass2(function1, function2, function4, function3, function0, null), continuation);
        return objAwaitEachGesture == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objAwaitEachGesture : Unit.INSTANCE;
    }

    public static final Modifier motionPointerInput(Modifier modifier, final Object obj, final MutableFloatState mutableFloatState, final MotionMeasurer motionMeasurer) {
        return ComposedModifierKt.composed(modifier, InspectableValueKt.isDebugInspectorInfoEnabled() ? new Function1<InspectorInfo, Unit>() { // from class: androidx.constraintlayout.compose.MotionDragHandlerKt$motionPointerInput$$inlined$debugInspectorInfo$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(InspectorInfo inspectorInfo) {
                invoke2(inspectorInfo);
                return Unit.INSTANCE;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(InspectorInfo inspectorInfo) {
                inspectorInfo.setName("motionPointerInput");
                inspectorInfo.getProperties().set("key", obj);
                inspectorInfo.getProperties().set(Key.MOTIONPROGRESS, mutableFloatState);
                inspectorInfo.getProperties().set("measurer", motionMeasurer);
            }
        } : InspectableValueKt.getNoInspectorInfo(), new Function3<Modifier, Composer, Integer, Modifier>() { // from class: androidx.constraintlayout.compose.MotionDragHandlerKt.motionPointerInput.2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(3);
            }

            @Override // kotlin.jvm.functions.Function3
            public /* bridge */ /* synthetic */ Modifier invoke(Modifier modifier2, Composer composer, Integer num) {
                return invoke(modifier2, composer, num.intValue());
            }

            public final Modifier invoke(Modifier modifier2, Composer composer, int i) {
                composer.startReplaceGroup(146198586);
                ComposerKt.sourceInformation(composer, "C65@2451L123,68@2601L61,70@2711L1716,70@2672L1755,107@4475L1202:MotionDragHandler.kt#fysre8");
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(146198586, i, -1, "androidx.constraintlayout.compose.motionPointerInput.<anonymous> (MotionDragHandler.kt:61)");
                }
                if (!motionMeasurer.getTransition().hasOnSwipe()) {
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    composer.endReplaceGroup();
                    return modifier2;
                }
                ComposerKt.sourceInformationMarkerStart(composer, -1723183141, "CC(remember):MotionDragHandler.kt#9igjgp");
                boolean zChanged = composer.changed(obj);
                MotionMeasurer motionMeasurer2 = motionMeasurer;
                MutableFloatState mutableFloatState2 = mutableFloatState;
                Object objRememberedValue = composer.rememberedValue();
                if (zChanged || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue = new TransitionHandler(motionMeasurer2, mutableFloatState2);
                    composer.updateRememberedValue(objRememberedValue);
                }
                TransitionHandler transitionHandler = (TransitionHandler) objRememberedValue;
                ComposerKt.sourceInformationMarkerEnd(composer);
                ComposerKt.sourceInformationMarkerStart(composer, -1723178403, "CC(remember):MotionDragHandler.kt#9igjgp");
                boolean zChanged2 = composer.changed(obj);
                Object objRememberedValue2 = composer.rememberedValue();
                if (zChanged2 || objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue2 = ChannelKt.Channel$default(-1, null, null, 6, null);
                    composer.updateRememberedValue(objRememberedValue2);
                }
                Channel channel = (Channel) objRememberedValue2;
                ComposerKt.sourceInformationMarkerEnd(composer);
                Object obj2 = obj;
                ComposerKt.sourceInformationMarkerStart(composer, -1723173228, "CC(remember):MotionDragHandler.kt#9igjgp");
                boolean zChangedInstance = composer.changedInstance(transitionHandler) | composer.changedInstance(channel);
                Object objRememberedValue3 = composer.rememberedValue();
                if (zChangedInstance || objRememberedValue3 == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue3 = (Function2) new MotionDragHandlerKt$motionPointerInput$2$1$1(transitionHandler, channel, null);
                    composer.updateRememberedValue(objRememberedValue3);
                }
                ComposerKt.sourceInformationMarkerEnd(composer);
                EffectsKt.LaunchedEffect(obj2, (Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object>) objRememberedValue3, composer, 0);
                Object obj3 = obj;
                ComposerKt.sourceInformationMarkerStart(composer, -1723117294, "CC(remember):MotionDragHandler.kt#9igjgp");
                boolean zChangedInstance2 = composer.changedInstance(transitionHandler) | composer.changedInstance(channel);
                Object objRememberedValue4 = composer.rememberedValue();
                if (zChangedInstance2 || objRememberedValue4 == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue4 = (Function2) new MotionDragHandlerKt$motionPointerInput$2$2$1(transitionHandler, channel, null);
                    composer.updateRememberedValue(objRememberedValue4);
                }
                ComposerKt.sourceInformationMarkerEnd(composer);
                Modifier modifierThen = modifier2.then(new SuspendPointerInputElement(obj3, null, null, new SuspendingPointerInputFilterKt$sam$androidx_compose_ui_input_pointer_PointerInputEventHandler$0((Function2) objRememberedValue4), 6, null));
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                composer.endReplaceGroup();
                return modifierThen;
            }
        });
    }
}
