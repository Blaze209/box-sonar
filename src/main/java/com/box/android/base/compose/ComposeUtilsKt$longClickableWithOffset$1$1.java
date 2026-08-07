package com.box.android.base.compose;

import androidx.compose.foundation.gestures.PressGestureScope;
import androidx.compose.foundation.gestures.TapGestureDetectorKt;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.hapticfeedback.HapticFeedback;
import androidx.compose.ui.hapticfeedback.HapticFeedbackType;
import androidx.compose.ui.input.pointer.PointerInputEventHandler;
import androidx.compose.ui.input.pointer.PointerInputScope;
import androidx.compose.ui.unit.DpOffset;
import external.sdk.pendo.io.mozilla.javascript.Token;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;

/* JADX INFO: compiled from: ComposeUtils.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
final class ComposeUtilsKt$longClickableWithOffset$1$1 implements PointerInputEventHandler {
    final /* synthetic */ HapticFeedback $hapticFeedback;
    final /* synthetic */ MutableInteractionSource $interactionSource;
    final /* synthetic */ Function1<DpOffset, Unit> $onLongClick;

    /* JADX WARN: Multi-variable type inference failed */
    ComposeUtilsKt$longClickableWithOffset$1$1(Function1<? super DpOffset, Unit> function1, HapticFeedback hapticFeedback, MutableInteractionSource mutableInteractionSource) {
        this.$onLongClick = function1;
        this.$hapticFeedback = hapticFeedback;
        this.$interactionSource = mutableInteractionSource;
    }

    @Override // androidx.compose.ui.input.pointer.PointerInputEventHandler
    public final Object invoke(final PointerInputScope pointerInputScope, Continuation<? super Unit> continuation) {
        final Function1<DpOffset, Unit> function1 = this.$onLongClick;
        final HapticFeedback hapticFeedback = this.$hapticFeedback;
        Object objDetectTapGestures$default = TapGestureDetectorKt.detectTapGestures$default(pointerInputScope, null, new Function1() { // from class: com.box.android.base.compose.ComposeUtilsKt$longClickableWithOffset$1$1$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return ComposeUtilsKt$longClickableWithOffset$1$1.invoke$lambda$0(function1, pointerInputScope, hapticFeedback, (Offset) obj);
            }
        }, new AnonymousClass2(this.$interactionSource, null), null, continuation, 9, null);
        return objDetectTapGestures$default == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objDetectTapGestures$default : Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit invoke$lambda$0(Function1 function1, PointerInputScope pointerInputScope, HapticFeedback hapticFeedback, Offset offset) {
        float f = pointerInputScope.mo750toDpu2uoSUM(Float.intBitsToFloat((int) (offset.m6579unboximpl() >> 32)));
        float f2 = pointerInputScope.mo750toDpu2uoSUM(Float.intBitsToFloat((int) (offset.m6579unboximpl() & 4294967295L)));
        function1.invoke(DpOffset.m9742boximpl(DpOffset.m9743constructorimpl((((long) Float.floatToRawIntBits(f)) << 32) | (((long) Float.floatToRawIntBits(f2)) & 4294967295L))));
        hapticFeedback.mo7590performHapticFeedbackCdsT49E(HapticFeedbackType.INSTANCE.m7603getLongPress5zf0vsI());
        return Unit.INSTANCE;
    }

    /* JADX INFO: renamed from: com.box.android.base.compose.ComposeUtilsKt$longClickableWithOffset$1$1$2, reason: invalid class name */
    /* JADX INFO: compiled from: ComposeUtils.kt */
    @Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0004H\n"}, d2 = {"<anonymous>", "", "Landroidx/compose/foundation/gestures/PressGestureScope;", "it", "Landroidx/compose/ui/geometry/Offset;"}, k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.box.android.base.compose.ComposeUtilsKt$longClickableWithOffset$1$1$2", f = "ComposeUtils.kt", i = {0, 0, 0, 1, 1, 1, 2, 2, 2}, l = {Token.DOTDOT, Token.COLONCOLON, Token.XML}, m = "invokeSuspend", n = {"$this$detectTapGestures", "press", "it", "$this$detectTapGestures", "press", "it", "$this$detectTapGestures", "press", "it"}, s = {"L$0", "L$1", "J$0", "L$0", "L$1", "J$0", "L$0", "L$1", "J$0"}, v = 1)
    static final class AnonymousClass2 extends SuspendLambda implements Function3<PressGestureScope, Offset, Continuation<? super Unit>, Object> {
        final /* synthetic */ MutableInteractionSource $interactionSource;
        /* synthetic */ long J$0;
        private /* synthetic */ Object L$0;
        Object L$1;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass2(MutableInteractionSource mutableInteractionSource, Continuation<? super AnonymousClass2> continuation) {
            super(3, continuation);
            this.$interactionSource = mutableInteractionSource;
        }

        @Override // kotlin.jvm.functions.Function3
        public /* bridge */ /* synthetic */ Object invoke(PressGestureScope pressGestureScope, Offset offset, Continuation<? super Unit> continuation) {
            return m11641invoked4ec7I(pressGestureScope, offset.m6579unboximpl(), continuation);
        }

        /* JADX INFO: renamed from: invoke-d-4ec7I, reason: not valid java name */
        public final Object m11641invoked4ec7I(PressGestureScope pressGestureScope, long j, Continuation<? super Unit> continuation) {
            AnonymousClass2 anonymousClass2 = new AnonymousClass2(this.$interactionSource, continuation);
            anonymousClass2.L$0 = pressGestureScope;
            anonymousClass2.J$0 = j;
            return anonymousClass2.invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Code restructure failed: missing block: B:20:0x008f, code lost:
        
            if (r10.$interactionSource.emit(new androidx.compose.foundation.interaction.PressInteraction.Release(r4), r10) == r3) goto L21;
         */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final java.lang.Object invokeSuspend(java.lang.Object r11) {
            /*
                r10 = this;
                java.lang.Object r0 = r10.L$0
                androidx.compose.foundation.gestures.PressGestureScope r0 = (androidx.compose.foundation.gestures.PressGestureScope) r0
                long r1 = r10.J$0
                java.lang.Object r3 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
                int r4 = r10.label
                r5 = 3
                r6 = 2
                r7 = 1
                if (r4 == 0) goto L38
                if (r4 == r7) goto L30
                if (r4 == r6) goto L28
                if (r4 != r5) goto L20
                java.lang.Object r10 = r10.L$1
                androidx.compose.foundation.interaction.PressInteraction$Press r10 = (androidx.compose.foundation.interaction.PressInteraction.Press) r10
                kotlin.ResultKt.throwOnFailure(r11)
                goto L92
            L20:
                java.lang.IllegalStateException r10 = new java.lang.IllegalStateException
                java.lang.String r11 = "call to 'resume' before 'invoke' with coroutine"
                r10.<init>(r11)
                throw r10
            L28:
                java.lang.Object r4 = r10.L$1
                androidx.compose.foundation.interaction.PressInteraction$Press r4 = (androidx.compose.foundation.interaction.PressInteraction.Press) r4
                kotlin.ResultKt.throwOnFailure(r11)
                goto L6f
            L30:
                java.lang.Object r4 = r10.L$1
                androidx.compose.foundation.interaction.PressInteraction$Press r4 = (androidx.compose.foundation.interaction.PressInteraction.Press) r4
                kotlin.ResultKt.throwOnFailure(r11)
                goto L59
            L38:
                kotlin.ResultKt.throwOnFailure(r11)
                androidx.compose.foundation.interaction.PressInteraction$Press r11 = new androidx.compose.foundation.interaction.PressInteraction$Press
                r4 = 0
                r11.<init>(r1, r4)
                androidx.compose.foundation.interaction.MutableInteractionSource r4 = r10.$interactionSource
                r8 = r11
                androidx.compose.foundation.interaction.Interaction r8 = (androidx.compose.foundation.interaction.Interaction) r8
                r9 = r10
                kotlin.coroutines.Continuation r9 = (kotlin.coroutines.Continuation) r9
                r10.L$0 = r0
                r10.L$1 = r11
                r10.J$0 = r1
                r10.label = r7
                java.lang.Object r4 = r4.emit(r8, r9)
                if (r4 != r3) goto L58
                goto L91
            L58:
                r4 = r11
            L59:
                r11 = r10
                kotlin.coroutines.Continuation r11 = (kotlin.coroutines.Continuation) r11
                java.lang.Object r7 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r0)
                r10.L$0 = r7
                r10.L$1 = r4
                r10.J$0 = r1
                r10.label = r6
                java.lang.Object r11 = r0.tryAwaitRelease(r11)
                if (r11 != r3) goto L6f
                goto L91
            L6f:
                androidx.compose.foundation.interaction.MutableInteractionSource r11 = r10.$interactionSource
                androidx.compose.foundation.interaction.PressInteraction$Release r6 = new androidx.compose.foundation.interaction.PressInteraction$Release
                r6.<init>(r4)
                androidx.compose.foundation.interaction.Interaction r6 = (androidx.compose.foundation.interaction.Interaction) r6
                r7 = r10
                kotlin.coroutines.Continuation r7 = (kotlin.coroutines.Continuation) r7
                java.lang.Object r0 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r0)
                r10.L$0 = r0
                java.lang.Object r0 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r4)
                r10.L$1 = r0
                r10.J$0 = r1
                r10.label = r5
                java.lang.Object r10 = r11.emit(r6, r7)
                if (r10 != r3) goto L92
            L91:
                return r3
            L92:
                kotlin.Unit r10 = kotlin.Unit.INSTANCE
                return r10
            */
            throw new UnsupportedOperationException("Method not decompiled: com.box.android.base.compose.ComposeUtilsKt$longClickableWithOffset$1$1.AnonymousClass2.invokeSuspend(java.lang.Object):java.lang.Object");
        }
    }
}
