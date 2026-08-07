package com.box.android.preview.previewtype.gif;

import androidx.compose.foundation.gestures.ForEachGestureKt;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.input.pointer.AwaitPointerEventScope;
import androidx.compose.ui.input.pointer.PointerEvent;
import androidx.compose.ui.input.pointer.PointerInputScope;
import androidx.exifinterface.media.ExifInterface;
import com.pspdfkit.analytics.Analytics;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.RestrictedSuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import sdk.pendo.io.events.IdentificationData;

/* JADX INFO: compiled from: PointerInputScopeExt.kt */
/* JADX INFO: loaded from: classes12.dex */
@Metadata(d1 = {"\u0000>\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a_\u0010\u0000\u001a\u00020\u0001*\u00020\u00022K\u0010\u0003\u001aG\u0012\u0013\u0012\u00110\u0005¢\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\b\u0012\u0013\u0012\u00110\t¢\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\n\u0012\u0013\u0012\u00110\u000b¢\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\f\u0012\u0004\u0012\u00020\u00010\u0004H\u0086@¢\u0006\u0002\u0010\r\u001a;\u0010\u000e\u001a\u00020\u000f\"\u0004\b\u0000\u0010\u0010*\b\u0012\u0004\u0012\u0002H\u00100\u00112\u0012\u0010\u0012\u001a\u000e\u0012\u0004\u0012\u0002H\u0010\u0012\u0004\u0012\u00020\u000f0\u0013H\u0086\bø\u0001\u0000\u0082\u0002\b\n\u0006\b\u0001\u0012\u0002\u0010\u0001\u001a;\u0010\u0014\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0010*\b\u0012\u0004\u0012\u0002H\u00100\u00112\u0012\u0010\u0015\u001a\u000e\u0012\u0004\u0012\u0002H\u0010\u0012\u0004\u0012\u00020\u00010\u0013H\u0086\bø\u0001\u0000\u0082\u0002\b\n\u0006\b\u0001\u0012\u0002\u0010\u0001\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006\u0016"}, d2 = {"detectPlainTransformGestures", "", "Landroidx/compose/ui/input/pointer/PointerInputScope;", "onGesture", "Lkotlin/Function3;", "Landroidx/compose/ui/geometry/Offset;", "Lkotlin/ParameterName;", "name", "pan", "", "zoom", "Landroidx/compose/ui/input/pointer/PointerEvent;", "event", "(Landroidx/compose/ui/input/pointer/PointerInputScope;Lkotlin/jvm/functions/Function3;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "fastAny", "", ExifInterface.GPS_DIRECTION_TRUE, "", IdentificationData.PREDICATE, "Lkotlin/Function1;", "fastForEach", Analytics.Data.ACTION, "preview_generalProdRelease"}, k = 2, mv = {2, 2, 0}, xi = 48)
public final class PointerInputScopeExtKt {

    /* JADX INFO: renamed from: com.box.android.preview.previewtype.gif.PointerInputScopeExtKt$detectPlainTransformGestures$2, reason: invalid class name */
    /* JADX INFO: compiled from: PointerInputScopeExt.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Landroidx/compose/ui/input/pointer/AwaitPointerEventScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.box.android.preview.previewtype.gif.PointerInputScopeExtKt$detectPlainTransformGestures$2", f = "PointerInputScopeExt.kt", i = {0, 0, 0, 0, 0, 1, 1, 1, 1, 1}, l = {32, 34}, m = "invokeSuspend", n = {"$this$awaitEachGesture", "zoom", "pan", "pastTouchSlop", "touchSlop", "$this$awaitEachGesture", "zoom", "pan", "pastTouchSlop", "touchSlop"}, s = {"L$0", "F$0", "J$0", "I$0", "F$1", "L$0", "F$0", "J$0", "I$0", "F$1"}, v = 1)
    static final class AnonymousClass2 extends RestrictedSuspendLambda implements Function2<AwaitPointerEventScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ Function3<Offset, Float, PointerEvent, Unit> $onGesture;
        float F$0;
        float F$1;
        int I$0;
        long J$0;
        private /* synthetic */ Object L$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        AnonymousClass2(Function3<? super Offset, ? super Float, ? super PointerEvent, Unit> function3, Continuation<? super AnonymousClass2> continuation) {
            super(2, continuation);
            this.$onGesture = function3;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            AnonymousClass2 anonymousClass2 = new AnonymousClass2(this.$onGesture, continuation);
            anonymousClass2.L$0 = obj;
            return anonymousClass2;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(AwaitPointerEventScope awaitPointerEventScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass2) create(awaitPointerEventScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Code duplicated, block: B:19:0x0090  */
        /* JADX WARN: Code duplicated, block: B:22:0x009e A[LOOP:0: B:18:0x008e->B:22:0x009e, LOOP_END] */
        /* JADX WARN: Code duplicated, block: B:51:0x00a1 A[SYNTHETIC] */
        /* JADX WARN: Code duplicated, block: B:52:0x009c A[SYNTHETIC] */
        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r13v2 */
        /* JADX WARN: Type inference failed for: r13v3 */
        /* JADX WARN: Type inference failed for: r13v4 */
        /* JADX WARN: Type inference failed for: r15v0 */
        /* JADX WARN: Type inference failed for: r15v1, types: [int] */
        /* JADX WARN: Type inference failed for: r15v6 */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:15:0x007d -> B:17:0x0080). Please report as a decompilation issue!!! */
        /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
            jadx.core.utils.exceptions.JadxOverflowException: Regions stack size limit reached
            	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
            	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
            	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
            */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final java.lang.Object invokeSuspend(java.lang.Object r19) {
            /*
                Method dump skipped, instruction units count: 288
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: com.box.android.preview.previewtype.gif.PointerInputScopeExtKt.AnonymousClass2.invokeSuspend(java.lang.Object):java.lang.Object");
        }
    }

    public static final Object detectPlainTransformGestures(PointerInputScope pointerInputScope, Function3<? super Offset, ? super Float, ? super PointerEvent, Unit> function3, Continuation<? super Unit> continuation) {
        Object objAwaitEachGesture = ForEachGestureKt.awaitEachGesture(pointerInputScope, new AnonymousClass2(function3, null), continuation);
        return objAwaitEachGesture == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objAwaitEachGesture : Unit.INSTANCE;
    }

    public static final <T> void fastForEach(List<? extends T> list, Function1<? super T, Unit> action) {
        Intrinsics.checkNotNullParameter(list, "<this>");
        Intrinsics.checkNotNullParameter(action, "action");
        int size = list.size();
        for (int i = 0; i < size; i++) {
            action.invoke(list.get(i));
        }
    }

    public static final <T> boolean fastAny(List<? extends T> list, Function1<? super T, Boolean> predicate) {
        Intrinsics.checkNotNullParameter(list, "<this>");
        Intrinsics.checkNotNullParameter(predicate, "predicate");
        int size = list.size();
        for (int i = 0; i < size; i++) {
            if (predicate.invoke(list.get(i)).booleanValue()) {
                return true;
            }
        }
        return false;
    }
}
