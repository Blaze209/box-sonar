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

/* JADX INFO: compiled from: Transition.kt */
/* JADX INFO: loaded from: classes13.dex */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001:\u0001\u0016J\u0011\u0010\u0010\u001a\u00020\tH¦@ø\u0001\u0000¢\u0006\u0002\u0010\u0011J\u001f\u0010\u0012\u001a\u00020\t2\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\t0\u0014H¦@ø\u0001\u0000¢\u0006\u0002\u0010\u0015RD\u0010\u0002\u001a1\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0007\u0012\u0006\u0012\u0004\u0018\u00010\b\u0012\u0004\u0012\u00020\t0\u0003j\u0002`\n¢\u0006\u0002\b\u000bX¦\u0004ø\u0001\u0000¢\u0006\u0006\u001a\u0004\b\f\u0010\rRH\u0010\u000e\u001a5\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0007\u0012\u0006\u0012\u0004\u0018\u00010\b\u0012\u0004\u0012\u00020\t\u0018\u00010\u0003j\u0004\u0018\u0001`\n¢\u0006\u0002\b\u000bX¦\u0004ø\u0001\u0000¢\u0006\u0006\u001a\u0004\b\u000f\u0010\r\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u0017"}, d2 = {"Lcom/bumptech/glide/integration/compose/Transition;", "", "drawCurrent", "Lkotlin/Function5;", "Landroidx/compose/ui/graphics/drawscope/DrawScope;", "Landroidx/compose/ui/graphics/painter/Painter;", "Landroidx/compose/ui/geometry/Size;", "", "Landroidx/compose/ui/graphics/ColorFilter;", "", "Lcom/bumptech/glide/integration/compose/DrawPainter;", "Lkotlin/ExtensionFunctionType;", "getDrawCurrent", "()Lkotlin/jvm/functions/Function5;", "drawPlaceholder", "getDrawPlaceholder", "stop", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "transition", "invalidate", "Lkotlin/Function0;", "(Lkotlin/jvm/functions/Function0;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Factory", "compose_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public interface Transition {

    /* JADX INFO: compiled from: Transition.kt */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&¨\u0006\u0004"}, d2 = {"Lcom/bumptech/glide/integration/compose/Transition$Factory;", "", "build", "Lcom/bumptech/glide/integration/compose/Transition;", "compose_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public interface Factory {
        Transition build();
    }

    Function5<DrawScope, Painter, Size, Float, ColorFilter, Unit> getDrawCurrent();

    Function5<DrawScope, Painter, Size, Float, ColorFilter, Unit> getDrawPlaceholder();

    Object stop(Continuation<? super Unit> continuation);

    Object transition(Function0<Unit> function0, Continuation<? super Unit> continuation);
}
