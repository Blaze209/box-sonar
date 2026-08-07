package androidx.compose.foundation.layout;

import androidx.compose.ui.Modifier;
import androidx.compose.ui.layout.IntrinsicMeasurable;
import androidx.compose.ui.layout.IntrinsicMeasureScope;
import androidx.compose.ui.layout.Measurable;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.node.LayoutModifierNode;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.ConstraintsKt;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.Dp;
import com.facebook.react.uimanager.ViewProps;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: Size.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0002\u0018\u00002\u00020\u00012\u00020\u0002B7\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0004\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0004\b\n\u0010\u000bJ#\u0010 \u001a\u00020!*\u00020\"2\u0006\u0010#\u001a\u00020$2\u0006\u0010%\u001a\u00020\u001cH\u0016¢\u0006\u0004\b&\u0010'J\u001c\u0010(\u001a\u00020)*\u00020*2\u0006\u0010#\u001a\u00020+2\u0006\u0010,\u001a\u00020)H\u0016J\u001c\u0010-\u001a\u00020)*\u00020*2\u0006\u0010#\u001a\u00020+2\u0006\u0010.\u001a\u00020)H\u0016J\u001c\u0010/\u001a\u00020)*\u00020*2\u0006\u0010#\u001a\u00020+2\u0006\u0010,\u001a\u00020)H\u0016J\u001c\u00100\u001a\u00020)*\u00020*2\u0006\u0010#\u001a\u00020+2\u0006\u0010.\u001a\u00020)H\u0016R\u001c\u0010\u0003\u001a\u00020\u0004X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u0010\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001c\u0010\u0005\u001a\u00020\u0004X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u0010\u001a\u0004\b\u0011\u0010\r\"\u0004\b\u0012\u0010\u000fR\u001c\u0010\u0006\u001a\u00020\u0004X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u0010\u001a\u0004\b\u0013\u0010\r\"\u0004\b\u0014\u0010\u000fR\u001c\u0010\u0007\u001a\u00020\u0004X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u0010\u001a\u0004\b\u0015\u0010\r\"\u0004\b\u0016\u0010\u000fR\u001a\u0010\b\u001a\u00020\tX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR\u0018\u0010\u001b\u001a\u00020\u001c*\u00020\u001d8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u001e\u0010\u001f¨\u00061"}, d2 = {"Landroidx/compose/foundation/layout/SizeNode;", "Landroidx/compose/ui/node/LayoutModifierNode;", "Landroidx/compose/ui/Modifier$Node;", ViewProps.MIN_WIDTH, "Landroidx/compose/ui/unit/Dp;", ViewProps.MIN_HEIGHT, ViewProps.MAX_WIDTH, ViewProps.MAX_HEIGHT, "enforceIncoming", "", "<init>", "(FFFFZLkotlin/jvm/internal/DefaultConstructorMarker;)V", "getMinWidth-D9Ej5fM", "()F", "setMinWidth-0680j_4", "(F)V", "F", "getMinHeight-D9Ej5fM", "setMinHeight-0680j_4", "getMaxWidth-D9Ej5fM", "setMaxWidth-0680j_4", "getMaxHeight-D9Ej5fM", "setMaxHeight-0680j_4", "getEnforceIncoming", "()Z", "setEnforceIncoming", "(Z)V", "targetConstraints", "Landroidx/compose/ui/unit/Constraints;", "Landroidx/compose/ui/unit/Density;", "getTargetConstraints-OenEA2s", "(Landroidx/compose/ui/unit/Density;)J", "measure", "Landroidx/compose/ui/layout/MeasureResult;", "Landroidx/compose/ui/layout/MeasureScope;", "measurable", "Landroidx/compose/ui/layout/Measurable;", "constraints", "measure-3p2s80s", "(Landroidx/compose/ui/layout/MeasureScope;Landroidx/compose/ui/layout/Measurable;J)Landroidx/compose/ui/layout/MeasureResult;", "minIntrinsicWidth", "", "Landroidx/compose/ui/layout/IntrinsicMeasureScope;", "Landroidx/compose/ui/layout/IntrinsicMeasurable;", "height", "minIntrinsicHeight", "width", "maxIntrinsicWidth", "maxIntrinsicHeight", "foundation-layout"}, k = 1, mv = {2, 0, 0}, xi = 48)
final class SizeNode extends Modifier.Node implements LayoutModifierNode {
    private boolean enforceIncoming;
    private float maxHeight;
    private float maxWidth;
    private float minHeight;
    private float minWidth;

    public /* synthetic */ SizeNode(float f, float f2, float f3, float f4, boolean z, DefaultConstructorMarker defaultConstructorMarker) {
        this(f, f2, f3, f4, z);
    }

    private SizeNode(float f, float f2, float f3, float f4, boolean z) {
        this.minWidth = f;
        this.minHeight = f2;
        this.maxWidth = f3;
        this.maxHeight = f4;
        this.enforceIncoming = z;
    }

    public /* synthetic */ SizeNode(float f, float f2, float f3, float f4, boolean z, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? Dp.INSTANCE.m9707getUnspecifiedD9Ej5fM() : f, (i & 2) != 0 ? Dp.INSTANCE.m9707getUnspecifiedD9Ej5fM() : f2, (i & 4) != 0 ? Dp.INSTANCE.m9707getUnspecifiedD9Ej5fM() : f3, (i & 8) != 0 ? Dp.INSTANCE.m9707getUnspecifiedD9Ej5fM() : f4, z, null);
    }

    /* JADX INFO: renamed from: getMinWidth-D9Ej5fM, reason: not valid java name and from getter */
    public final float getMinWidth() {
        return this.minWidth;
    }

    /* JADX INFO: renamed from: setMinWidth-0680j_4, reason: not valid java name */
    public final void m1282setMinWidth0680j_4(float f) {
        this.minWidth = f;
    }

    /* JADX INFO: renamed from: getMinHeight-D9Ej5fM, reason: not valid java name and from getter */
    public final float getMinHeight() {
        return this.minHeight;
    }

    /* JADX INFO: renamed from: setMinHeight-0680j_4, reason: not valid java name */
    public final void m1281setMinHeight0680j_4(float f) {
        this.minHeight = f;
    }

    /* JADX INFO: renamed from: getMaxWidth-D9Ej5fM, reason: not valid java name and from getter */
    public final float getMaxWidth() {
        return this.maxWidth;
    }

    /* JADX INFO: renamed from: setMaxWidth-0680j_4, reason: not valid java name */
    public final void m1280setMaxWidth0680j_4(float f) {
        this.maxWidth = f;
    }

    /* JADX INFO: renamed from: getMaxHeight-D9Ej5fM, reason: not valid java name and from getter */
    public final float getMaxHeight() {
        return this.maxHeight;
    }

    /* JADX INFO: renamed from: setMaxHeight-0680j_4, reason: not valid java name */
    public final void m1279setMaxHeight0680j_4(float f) {
        this.maxHeight = f;
    }

    public final boolean getEnforceIncoming() {
        return this.enforceIncoming;
    }

    public final void setEnforceIncoming(boolean z) {
        this.enforceIncoming = z;
    }

    /* JADX WARN: Code duplicated, block: B:23:0x0041  */
    /* JADX INFO: renamed from: getTargetConstraints-OenEA2s, reason: not valid java name */
    private final long m1274getTargetConstraintsOenEA2s(Density density) {
        int iMo748roundToPx0680j_4;
        int iMo748roundToPx0680j_5;
        int iMo748roundToPx0680j_6;
        int i = 0;
        if (Float.isNaN(this.maxWidth)) {
            iMo748roundToPx0680j_4 = Integer.MAX_VALUE;
        } else {
            iMo748roundToPx0680j_4 = density.mo748roundToPx0680j_4(this.maxWidth);
            if (iMo748roundToPx0680j_4 < 0) {
                iMo748roundToPx0680j_4 = 0;
            }
        }
        if (Float.isNaN(this.maxHeight)) {
            iMo748roundToPx0680j_5 = Integer.MAX_VALUE;
        } else {
            iMo748roundToPx0680j_5 = density.mo748roundToPx0680j_4(this.maxHeight);
            if (iMo748roundToPx0680j_5 < 0) {
                iMo748roundToPx0680j_5 = 0;
            }
        }
        if (Float.isNaN(this.minWidth)) {
            iMo748roundToPx0680j_6 = 0;
        } else {
            iMo748roundToPx0680j_6 = density.mo748roundToPx0680j_4(this.minWidth);
            if (iMo748roundToPx0680j_6 < 0) {
                iMo748roundToPx0680j_6 = 0;
            }
            if (iMo748roundToPx0680j_6 > iMo748roundToPx0680j_4) {
                iMo748roundToPx0680j_6 = iMo748roundToPx0680j_4;
            }
            if (iMo748roundToPx0680j_6 == Integer.MAX_VALUE) {
                iMo748roundToPx0680j_6 = 0;
            }
        }
        if (!Float.isNaN(this.minHeight)) {
            int iMo748roundToPx0680j_7 = density.mo748roundToPx0680j_4(this.minHeight);
            if (iMo748roundToPx0680j_7 < 0) {
                iMo748roundToPx0680j_7 = 0;
            }
            if (iMo748roundToPx0680j_7 > iMo748roundToPx0680j_5) {
                iMo748roundToPx0680j_7 = iMo748roundToPx0680j_5;
            }
            if (iMo748roundToPx0680j_7 != Integer.MAX_VALUE) {
                i = iMo748roundToPx0680j_7;
            }
        }
        return ConstraintsKt.Constraints(iMo748roundToPx0680j_6, iMo748roundToPx0680j_4, i, iMo748roundToPx0680j_5);
    }

    @Override // androidx.compose.ui.node.LayoutModifierNode
    /* JADX INFO: renamed from: measure-3p2s80s */
    public MeasureResult mo372measure3p2s80s(MeasureScope measureScope, Measurable measurable, long j) {
        int iM9642getMinWidthimpl;
        int iM9640getMaxWidthimpl;
        int iM9641getMinHeightimpl;
        int iM9639getMaxHeightimpl;
        long jConstraints;
        long jM1274getTargetConstraintsOenEA2s = m1274getTargetConstraintsOenEA2s(measureScope);
        if (this.enforceIncoming) {
            jConstraints = ConstraintsKt.m9655constrainN9IONVI(j, jM1274getTargetConstraintsOenEA2s);
        } else {
            if (!Float.isNaN(this.minWidth)) {
                iM9642getMinWidthimpl = Constraints.m9642getMinWidthimpl(jM1274getTargetConstraintsOenEA2s);
            } else {
                iM9642getMinWidthimpl = Constraints.m9642getMinWidthimpl(j);
                int iM9640getMaxWidthimpl2 = Constraints.m9640getMaxWidthimpl(jM1274getTargetConstraintsOenEA2s);
                if (iM9642getMinWidthimpl > iM9640getMaxWidthimpl2) {
                    iM9642getMinWidthimpl = iM9640getMaxWidthimpl2;
                }
            }
            if (!Float.isNaN(this.maxWidth)) {
                iM9640getMaxWidthimpl = Constraints.m9640getMaxWidthimpl(jM1274getTargetConstraintsOenEA2s);
            } else {
                iM9640getMaxWidthimpl = Constraints.m9640getMaxWidthimpl(j);
                int iM9642getMinWidthimpl2 = Constraints.m9642getMinWidthimpl(jM1274getTargetConstraintsOenEA2s);
                if (iM9640getMaxWidthimpl < iM9642getMinWidthimpl2) {
                    iM9640getMaxWidthimpl = iM9642getMinWidthimpl2;
                }
            }
            if (!Float.isNaN(this.minHeight)) {
                iM9641getMinHeightimpl = Constraints.m9641getMinHeightimpl(jM1274getTargetConstraintsOenEA2s);
            } else {
                iM9641getMinHeightimpl = Constraints.m9641getMinHeightimpl(j);
                int iM9639getMaxHeightimpl2 = Constraints.m9639getMaxHeightimpl(jM1274getTargetConstraintsOenEA2s);
                if (iM9641getMinHeightimpl > iM9639getMaxHeightimpl2) {
                    iM9641getMinHeightimpl = iM9639getMaxHeightimpl2;
                }
            }
            if (!Float.isNaN(this.maxHeight)) {
                iM9639getMaxHeightimpl = Constraints.m9639getMaxHeightimpl(jM1274getTargetConstraintsOenEA2s);
            } else {
                iM9639getMaxHeightimpl = Constraints.m9639getMaxHeightimpl(j);
                int iM9641getMinHeightimpl2 = Constraints.m9641getMinHeightimpl(jM1274getTargetConstraintsOenEA2s);
                if (iM9639getMaxHeightimpl < iM9641getMinHeightimpl2) {
                    iM9639getMaxHeightimpl = iM9641getMinHeightimpl2;
                }
            }
            jConstraints = ConstraintsKt.Constraints(iM9642getMinWidthimpl, iM9640getMaxWidthimpl, iM9641getMinHeightimpl, iM9639getMaxHeightimpl);
        }
        final Placeable placeableMo8265measureBRTryo0 = measurable.mo8265measureBRTryo0(jConstraints);
        return MeasureScope.layout$default(measureScope, placeableMo8265measureBRTryo0.getWidth(), placeableMo8265measureBRTryo0.getHeight(), null, new Function1() { // from class: androidx.compose.foundation.layout.SizeNode$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return SizeNode.measure_3p2s80s$lambda$1(placeableMo8265measureBRTryo0, (Placeable.PlacementScope) obj);
            }
        }, 4, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit measure_3p2s80s$lambda$1(Placeable placeable, Placeable.PlacementScope placementScope) {
        Placeable.PlacementScope.placeRelative$default(placementScope, placeable, 0, 0, 0.0f, 4, null);
        return Unit.INSTANCE;
    }

    @Override // androidx.compose.ui.node.LayoutModifierNode
    public int minIntrinsicWidth(IntrinsicMeasureScope intrinsicMeasureScope, IntrinsicMeasurable intrinsicMeasurable, int i) {
        long jM1274getTargetConstraintsOenEA2s = m1274getTargetConstraintsOenEA2s(intrinsicMeasureScope);
        if (Constraints.m9638getHasFixedWidthimpl(jM1274getTargetConstraintsOenEA2s)) {
            return Constraints.m9640getMaxWidthimpl(jM1274getTargetConstraintsOenEA2s);
        }
        if (!this.enforceIncoming) {
            i = ConstraintsKt.m9656constrainHeightK40F9xA(jM1274getTargetConstraintsOenEA2s, i);
        }
        return ConstraintsKt.m9657constrainWidthK40F9xA(jM1274getTargetConstraintsOenEA2s, intrinsicMeasurable.minIntrinsicWidth(i));
    }

    @Override // androidx.compose.ui.node.LayoutModifierNode
    public int minIntrinsicHeight(IntrinsicMeasureScope intrinsicMeasureScope, IntrinsicMeasurable intrinsicMeasurable, int i) {
        long jM1274getTargetConstraintsOenEA2s = m1274getTargetConstraintsOenEA2s(intrinsicMeasureScope);
        if (Constraints.m9637getHasFixedHeightimpl(jM1274getTargetConstraintsOenEA2s)) {
            return Constraints.m9639getMaxHeightimpl(jM1274getTargetConstraintsOenEA2s);
        }
        if (!this.enforceIncoming) {
            i = ConstraintsKt.m9657constrainWidthK40F9xA(jM1274getTargetConstraintsOenEA2s, i);
        }
        return ConstraintsKt.m9656constrainHeightK40F9xA(jM1274getTargetConstraintsOenEA2s, intrinsicMeasurable.minIntrinsicHeight(i));
    }

    @Override // androidx.compose.ui.node.LayoutModifierNode
    public int maxIntrinsicWidth(IntrinsicMeasureScope intrinsicMeasureScope, IntrinsicMeasurable intrinsicMeasurable, int i) {
        long jM1274getTargetConstraintsOenEA2s = m1274getTargetConstraintsOenEA2s(intrinsicMeasureScope);
        if (Constraints.m9638getHasFixedWidthimpl(jM1274getTargetConstraintsOenEA2s)) {
            return Constraints.m9640getMaxWidthimpl(jM1274getTargetConstraintsOenEA2s);
        }
        if (!this.enforceIncoming) {
            i = ConstraintsKt.m9656constrainHeightK40F9xA(jM1274getTargetConstraintsOenEA2s, i);
        }
        return ConstraintsKt.m9657constrainWidthK40F9xA(jM1274getTargetConstraintsOenEA2s, intrinsicMeasurable.maxIntrinsicWidth(i));
    }

    @Override // androidx.compose.ui.node.LayoutModifierNode
    public int maxIntrinsicHeight(IntrinsicMeasureScope intrinsicMeasureScope, IntrinsicMeasurable intrinsicMeasurable, int i) {
        long jM1274getTargetConstraintsOenEA2s = m1274getTargetConstraintsOenEA2s(intrinsicMeasureScope);
        if (Constraints.m9637getHasFixedHeightimpl(jM1274getTargetConstraintsOenEA2s)) {
            return Constraints.m9639getMaxHeightimpl(jM1274getTargetConstraintsOenEA2s);
        }
        if (!this.enforceIncoming) {
            i = ConstraintsKt.m9657constrainWidthK40F9xA(jM1274getTargetConstraintsOenEA2s, i);
        }
        return ConstraintsKt.m9656constrainHeightK40F9xA(jM1274getTargetConstraintsOenEA2s, intrinsicMeasurable.maxIntrinsicHeight(i));
    }
}
