package androidx.compose.material.pullrefresh;

import androidx.compose.animation.core.EasingKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.draw.DrawModifierKt;
import androidx.compose.ui.graphics.ClipOp;
import androidx.compose.ui.graphics.GraphicsLayerModifierKt;
import androidx.compose.ui.graphics.GraphicsLayerScope;
import androidx.compose.ui.graphics.drawscope.ContentDrawScope;
import androidx.compose.ui.graphics.drawscope.DrawContext;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: PullRefreshIndicatorTransform.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\u001a\u001e\u0010\u0000\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005H\u0007¨\u0006\u0006"}, d2 = {"pullRefreshIndicatorTransform", "Landroidx/compose/ui/Modifier;", "state", "Landroidx/compose/material/pullrefresh/PullRefreshState;", "scale", "", "material"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class PullRefreshIndicatorTransformKt {
    public static /* synthetic */ Modifier pullRefreshIndicatorTransform$default(Modifier modifier, PullRefreshState pullRefreshState, boolean z, int i, Object obj) {
        if ((i & 2) != 0) {
            z = false;
        }
        return pullRefreshIndicatorTransform(modifier, pullRefreshState, z);
    }

    public static final Modifier pullRefreshIndicatorTransform(Modifier modifier, final PullRefreshState pullRefreshState, final boolean z) {
        return GraphicsLayerModifierKt.graphicsLayer(DrawModifierKt.drawWithContent(modifier, new Function1() { // from class: androidx.compose.material.pullrefresh.PullRefreshIndicatorTransformKt$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return PullRefreshIndicatorTransformKt.pullRefreshIndicatorTransform$lambda$0((ContentDrawScope) obj);
            }
        }), new Function1() { // from class: androidx.compose.material.pullrefresh.PullRefreshIndicatorTransformKt$$ExternalSyntheticLambda1
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return PullRefreshIndicatorTransformKt.pullRefreshIndicatorTransform$lambda$1(pullRefreshState, z, (GraphicsLayerScope) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit pullRefreshIndicatorTransform$lambda$0(ContentDrawScope contentDrawScope) {
        int iM6803getIntersectrtfAjoo = ClipOp.INSTANCE.m6803getIntersectrtfAjoo();
        DrawContext drawContext = contentDrawScope.getDrawContext();
        long jMo7316getSizeNHjbRc = drawContext.mo7316getSizeNHjbRc();
        drawContext.getCanvas().save();
        try {
            drawContext.getTransform().mo7319clipRectN_I0leg(-3.4028235E38f, 0.0f, Float.MAX_VALUE, Float.MAX_VALUE, iM6803getIntersectrtfAjoo);
            contentDrawScope.drawContent();
            return Unit.INSTANCE;
        } finally {
            drawContext.getCanvas().restore();
            drawContext.mo7317setSizeuvyYCjk(jMo7316getSizeNHjbRc);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit pullRefreshIndicatorTransform$lambda$1(PullRefreshState pullRefreshState, boolean z, GraphicsLayerScope graphicsLayerScope) {
        graphicsLayerScope.setTranslationY(pullRefreshState.getPosition$material() - Float.intBitsToFloat((int) (graphicsLayerScope.getSize() & 4294967295L)));
        if (z && !pullRefreshState.getRefreshing$material()) {
            float fTransform = EasingKt.getLinearOutSlowInEasing().transform(pullRefreshState.getPosition$material() / pullRefreshState.getThreshold$material());
            if (fTransform < 0.0f) {
                fTransform = 0.0f;
            }
            if (fTransform > 1.0f) {
                fTransform = 1.0f;
            }
            graphicsLayerScope.setScaleX(fTransform);
            graphicsLayerScope.setScaleY(fTransform);
        }
        return Unit.INSTANCE;
    }
}
