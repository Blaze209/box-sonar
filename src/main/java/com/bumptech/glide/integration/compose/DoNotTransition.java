package com.bumptech.glide.integration.compose;

import androidx.compose.ui.geometry.Size;
import androidx.compose.ui.graphics.ColorFilter;
import androidx.compose.ui.graphics.drawscope.DrawScope;
import androidx.compose.ui.graphics.painter.Painter;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function5;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: Transition.kt */
/* JADX INFO: loaded from: classes13.dex */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\bÀ\u0002\u0018\u00002\u00020\u0001:\u0001\u0017B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0011\u0010\u0011\u001a\u00020\nH\u0096@ø\u0001\u0000¢\u0006\u0002\u0010\u0012J\u001f\u0010\u0013\u001a\u00020\n2\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\n0\u0015H\u0096@ø\u0001\u0000¢\u0006\u0002\u0010\u0016RF\u0010\u0003\u001a1\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b\u0012\u0006\u0012\u0004\u0018\u00010\t\u0012\u0004\u0012\u00020\n0\u0004j\u0002`\u000b¢\u0006\u0002\b\fX\u0096\u0004ø\u0001\u0000¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eRF\u0010\u000f\u001a1\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b\u0012\u0006\u0012\u0004\u0018\u00010\t\u0012\u0004\u0012\u00020\n0\u0004j\u0002`\u000b¢\u0006\u0002\b\fX\u0096\u0004ø\u0001\u0000¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000e\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u0018"}, d2 = {"Lcom/bumptech/glide/integration/compose/DoNotTransition;", "Lcom/bumptech/glide/integration/compose/Transition;", "()V", "drawCurrent", "Lkotlin/Function5;", "Landroidx/compose/ui/graphics/drawscope/DrawScope;", "Landroidx/compose/ui/graphics/painter/Painter;", "Landroidx/compose/ui/geometry/Size;", "", "Landroidx/compose/ui/graphics/ColorFilter;", "", "Lcom/bumptech/glide/integration/compose/DrawPainter;", "Lkotlin/ExtensionFunctionType;", "getDrawCurrent", "()Lkotlin/jvm/functions/Function5;", "drawPlaceholder", "getDrawPlaceholder", "stop", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "transition", "invalidate", "Lkotlin/Function0;", "(Lkotlin/jvm/functions/Function0;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Factory", "compose_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class DoNotTransition implements Transition {
    public static final DoNotTransition INSTANCE = new DoNotTransition();
    private static final Function5<DrawScope, Painter, Size, Float, ColorFilter, Unit> drawPlaceholder = new Function5<DrawScope, Painter, Size, Float, ColorFilter, Unit>() { // from class: com.bumptech.glide.integration.compose.DoNotTransition$drawPlaceholder$1
        /* JADX INFO: renamed from: invoke-QfoU1oo, reason: not valid java name */
        public final void m13148invokeQfoU1oo(DrawScope drawScope, Painter painter, long j, float f, ColorFilter colorFilter) {
            Intrinsics.checkNotNullParameter(drawScope, "$this$null");
            Intrinsics.checkNotNullParameter(painter, "<anonymous parameter 0>");
        }

        @Override // kotlin.jvm.functions.Function5
        public /* bridge */ /* synthetic */ Unit invoke(DrawScope drawScope, Painter painter, Size size, Float f, ColorFilter colorFilter) {
            m13148invokeQfoU1oo(drawScope, painter, size.m6643unboximpl(), f.floatValue(), colorFilter);
            return Unit.INSTANCE;
        }
    };
    private static final Function5<DrawScope, Painter, Size, Float, ColorFilter, Unit> drawCurrent = new Function5<DrawScope, Painter, Size, Float, ColorFilter, Unit>() { // from class: com.bumptech.glide.integration.compose.DoNotTransition$drawCurrent$1
        @Override // kotlin.jvm.functions.Function5
        public /* bridge */ /* synthetic */ Unit invoke(DrawScope drawScope, Painter painter, Size size, Float f, ColorFilter colorFilter) {
            m13147invokeQfoU1oo(drawScope, painter, size.m6643unboximpl(), f.floatValue(), colorFilter);
            return Unit.INSTANCE;
        }

        /* JADX INFO: renamed from: invoke-QfoU1oo, reason: not valid java name */
        public final void m13147invokeQfoU1oo(DrawScope drawScope, Painter painter, long j, float f, ColorFilter colorFilter) {
            Intrinsics.checkNotNullParameter(drawScope, "$this$null");
            Intrinsics.checkNotNullParameter(painter, "painter");
            painter.m7521drawx_KDEd0(drawScope, j, f, colorFilter);
        }
    };

    /* JADX INFO: compiled from: Transition.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0016¨\u0006\u0005"}, d2 = {"Lcom/bumptech/glide/integration/compose/DoNotTransition$Factory;", "Lcom/bumptech/glide/integration/compose/Transition$Factory;", "()V", "build", "Lcom/bumptech/glide/integration/compose/DoNotTransition;", "compose_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Factory implements Transition.Factory {
        public static final int $stable = 0;
        public static final Factory INSTANCE = new Factory();

        private Factory() {
        }

        @Override // com.bumptech.glide.integration.compose.Transition.Factory
        public DoNotTransition build() {
            return DoNotTransition.INSTANCE;
        }
    }

    private DoNotTransition() {
    }

    @Override // com.bumptech.glide.integration.compose.Transition
    public Object transition(Function0<Unit> function0, Continuation<? super Unit> continuation) {
        return Unit.INSTANCE;
    }

    @Override // com.bumptech.glide.integration.compose.Transition
    public Object stop(Continuation<? super Unit> continuation) {
        return Unit.INSTANCE;
    }

    @Override // com.bumptech.glide.integration.compose.Transition
    public Function5<DrawScope, Painter, Size, Float, ColorFilter, Unit> getDrawPlaceholder() {
        return drawPlaceholder;
    }

    @Override // com.bumptech.glide.integration.compose.Transition
    public Function5<DrawScope, Painter, Size, Float, ColorFilter, Unit> getDrawCurrent() {
        return drawCurrent;
    }
}
