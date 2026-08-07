package dev.chrisbanes.haze;

import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.OffsetKt;
import androidx.compose.ui.graphics.drawscope.DrawScope;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: Canvas.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a8\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00042\u0017\u0010\u0005\u001a\u0013\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00010\u0006¢\u0006\u0002\b\u0007H\u0080\bø\u0001\u0000¢\u0006\u0004\b\b\u0010\t\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006\n"}, d2 = {"translate", "", "Landroidx/compose/ui/graphics/drawscope/DrawScope;", "offset", "Landroidx/compose/ui/geometry/Offset;", "block", "Lkotlin/Function1;", "Lkotlin/ExtensionFunctionType;", "translate-d-4ec7I", "(Landroidx/compose/ui/graphics/drawscope/DrawScope;JLkotlin/jvm/functions/Function1;)V", "haze_release"}, k = 2, mv = {2, 1, 0}, xi = 48)
public final class CanvasKt {
    /* JADX INFO: renamed from: translate-d-4ec7I, reason: not valid java name */
    public static final void m14445translated4ec7I(DrawScope translate, long j, Function1<? super DrawScope, Unit> block) {
        Intrinsics.checkNotNullParameter(translate, "$this$translate");
        Intrinsics.checkNotNullParameter(block, "block");
        if (OffsetKt.m6586isFinitek4lQ0M(j) && !Offset.m6566equalsimpl0(j, Offset.INSTANCE.m6585getZeroF1C5BW0())) {
            float fM6569getXimpl = Offset.m6569getXimpl(j);
            float fM6570getYimpl = Offset.m6570getYimpl(j);
            translate.getDrawContext().getTransform().translate(fM6569getXimpl, fM6570getYimpl);
            try {
                block.invoke(translate);
                return;
            } finally {
                translate.getDrawContext().getTransform().translate(-fM6569getXimpl, -fM6570getYimpl);
            }
        }
        block.invoke(translate);
    }
}
