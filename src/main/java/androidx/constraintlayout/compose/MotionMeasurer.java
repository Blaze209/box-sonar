package androidx.constraintlayout.compose;

import android.graphics.Matrix;
import androidx.compose.ui.geometry.OffsetKt;
import androidx.compose.ui.geometry.Size;
import androidx.compose.ui.geometry.SizeKt;
import androidx.compose.ui.graphics.AndroidCanvas_androidKt;
import androidx.compose.ui.graphics.AndroidPath_androidKt;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.ColorKt;
import androidx.compose.ui.graphics.Path;
import androidx.compose.ui.graphics.PathEffect;
import androidx.compose.ui.graphics.drawscope.DrawScope;
import androidx.compose.ui.graphics.drawscope.Stroke;
import androidx.compose.ui.layout.LayoutIdKt;
import androidx.compose.ui.layout.Measurable;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.IntSizeKt;
import androidx.compose.ui.unit.LayoutDirection;
import androidx.constraintlayout.core.state.CorePixelDp;
import androidx.constraintlayout.core.state.WidgetFrame;
import androidx.constraintlayout.core.widgets.ConstraintWidget;
import com.facebook.react.uimanager.ViewProps;
import com.google.firebase.analytics.FirebaseAnalytics;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;

/* JADX INFO: compiled from: MotionMeasurer.kt */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(d1 = {"\u0000®\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0014\n\u0000\n\u0002\u0010\u0015\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\b\u0001\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0006\u0010\u000f\u001a\u00020\u0010J\b\u0010\u0011\u001a\u00020\u0010H\u0016J4\u0010\u0012\u001a\u00020\u00102\n\u0010\u0013\u001a\u00060\u0014j\u0002`\u00152\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u00192\u0006\u0010\u001b\u001a\u00020\u001cH\u0002J\u0012\u0010\u001d\u001a\u00020\u00102\n\u0010\u0013\u001a\u00060\u0014j\u0002`\u0015J+\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020!2\u0006\u0010\"\u001a\u00020!2\u0006\u0010\u001a\u001a\u00020\bø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b#\u0010$J\u001e\u0010%\u001a\u00020\b2\u0006\u0010 \u001a\u00020!2\u0006\u0010\"\u001a\u00020!2\u0006\u0010\u001a\u001a\u00020\bJ.\u0010&\u001a\u00020\u00102\u0006\u0010'\u001a\u00020(2\u0006\u0010)\u001a\u00020(2\u0006\u0010*\u001a\u00020+2\u0006\u0010\u000b\u001a\u00020,2\u0006\u0010\u001a\u001a\u00020\bJ8\u0010-\u001a\u00020\u00102\u0006\u0010.\u001a\u00020\u001c2\u0006\u0010/\u001a\u00020(2\f\u00100\u001a\b\u0012\u0004\u0012\u000202012\u0006\u00103\u001a\u00020\nH\u0002ø\u0001\u0000¢\u0006\u0004\b4\u00105J,\u00106\u001a\u00020\u00062\u0006\u00103\u001a\u00020\n2\u0006\u00107\u001a\u0002082\b\u00109\u001a\u0004\u0018\u00010:H\u0002ø\u0001\u0000¢\u0006\u0004\b;\u0010<Jh\u0010=\u001a\u00020>2\u0006\u00103\u001a\u00020\n2\u0006\u0010*\u001a\u00020+2\u0006\u0010?\u001a\u00020(2\u0006\u0010@\u001a\u00020(2\u0006\u0010\u000b\u001a\u00020,2\f\u00100\u001a\b\u0012\u0004\u0012\u000202012\u0006\u0010.\u001a\u00020\u001c2\u0006\u0010\u001a\u001a\u00020\b2\u0006\u0010A\u001a\u0002082\b\u00109\u001a\u0004\u0018\u00010:ø\u0001\u0000¢\u0006\u0004\bB\u0010CJb\u0010D\u001a\u00020\u00102\u0006\u00103\u001a\u00020\n2\u0006\u0010*\u001a\u00020+2\u0006\u0010?\u001a\u00020(2\u0006\u0010@\u001a\u00020(2\b\u0010\u000b\u001a\u0004\u0018\u00010,2\f\u00100\u001a\b\u0012\u0004\u0012\u000202012\u0006\u0010.\u001a\u00020\u001c2\u0006\u0010\u001a\u001a\u00020\b2\u0006\u0010E\u001a\u00020\u0006H\u0002ø\u0001\u0000¢\u0006\u0004\bF\u0010GJ(\u0010H\u001a\u00020\u0010*\u00020I2\b\b\u0002\u0010J\u001a\u00020\u00062\b\b\u0002\u0010K\u001a\u00020\u00062\b\b\u0002\u0010L\u001a\u00020\u0006J.\u0010M\u001a\u00020\u0010*\u00020I2\u0006\u0010N\u001a\u00020O2\u0006\u0010P\u001a\u00020Q2\u0006\u0010R\u001a\u00020\u001fH\u0002ø\u0001\u0000¢\u0006\u0004\bS\u0010TJF\u0010U\u001a\u00020\u0010*\u00020I2\u0006\u0010V\u001a\u00020\b2\u0006\u0010W\u001a\u00020\b2\u0006\u0010X\u001a\u00020O2\u0006\u0010Y\u001a\u00020O2\u0006\u0010P\u001a\u00020Q2\u0006\u0010R\u001a\u00020\u001fH\u0002ø\u0001\u0000¢\u0006\u0004\bZ\u0010[J4\u0010K\u001a\u00020\u0010*\u00020I2\u0006\u0010V\u001a\u00020\b2\u0006\u0010W\u001a\u00020\b2\u0006\u0010X\u001a\u00020O2\u0006\u0010\\\u001a\u00020\u00062\u0006\u0010L\u001a\u00020\u0006H\u0002R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\t\u001a\u0004\u0018\u00010\nX\u0082\u000eø\u0001\u0000ø\u0001\u0001¢\u0006\u0002\n\u0000R\u0011\u0010\u000b\u001a\u00020\f¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000e\u0082\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006]"}, d2 = {"Landroidx/constraintlayout/compose/MotionMeasurer;", "Landroidx/constraintlayout/compose/Measurer;", "density", "Landroidx/compose/ui/unit/Density;", "(Landroidx/compose/ui/unit/Density;)V", "DEBUG", "", "lastProgressInInterpolation", "", "oldConstraints", "Landroidx/compose/ui/unit/Constraints;", "transition", "Landroidx/constraintlayout/core/state/Transition;", "getTransition", "()Landroidx/constraintlayout/core/state/Transition;", "clearConstraintSets", "", "computeLayoutResult", "encodeKeyFrames", "json", "Ljava/lang/StringBuilder;", "Lkotlin/text/StringBuilder;", FirebaseAnalytics.Param.LOCATION, "", "types", "", "progress", "count", "", "encodeRoot", "getCustomColor", "Landroidx/compose/ui/graphics/Color;", "id", "", "name", "getCustomColor-XeAY9LY", "(Ljava/lang/String;Ljava/lang/String;F)J", "getCustomFloat", "initWith", "start", "Landroidx/constraintlayout/compose/ConstraintSet;", "end", ViewProps.LAYOUT_DIRECTION, "Landroidx/compose/ui/unit/LayoutDirection;", "Landroidx/constraintlayout/compose/TransitionImpl;", "measureConstraintSet", "optimizationLevel", "constraintSet", "measurables", "", "Landroidx/compose/ui/layout/Measurable;", "constraints", "measureConstraintSet--hBUhpc", "(ILandroidx/constraintlayout/compose/ConstraintSet;Ljava/util/List;J)V", "needsRemeasure", "source", "Landroidx/constraintlayout/compose/CompositionSource;", "invalidateOnConstraintsCallback", "Landroidx/constraintlayout/compose/ShouldInvalidateCallback;", "needsRemeasure-NN6Ew-U", "(JLandroidx/constraintlayout/compose/CompositionSource;Landroidx/constraintlayout/compose/ShouldInvalidateCallback;)Z", "performInterpolationMeasure", "Landroidx/compose/ui/unit/IntSize;", "constraintSetStart", "constraintSetEnd", "compositionSource", "performInterpolationMeasure-lUsXzhU", "(JLandroidx/compose/ui/unit/LayoutDirection;Landroidx/constraintlayout/compose/ConstraintSet;Landroidx/constraintlayout/compose/ConstraintSet;Landroidx/constraintlayout/compose/TransitionImpl;Ljava/util/List;IFLandroidx/constraintlayout/compose/CompositionSource;Landroidx/constraintlayout/compose/ShouldInvalidateCallback;)J", "recalculateInterpolation", "remeasure", "recalculateInterpolation-36Wf7g4", "(JLandroidx/compose/ui/unit/LayoutDirection;Landroidx/constraintlayout/compose/ConstraintSet;Landroidx/constraintlayout/compose/ConstraintSet;Landroidx/constraintlayout/compose/TransitionImpl;Ljava/util/List;IFZ)V", "drawDebug", "Landroidx/compose/ui/graphics/drawscope/DrawScope;", "drawBounds", "drawPaths", "drawKeyPositions", "drawFrame", "frame", "Landroidx/constraintlayout/core/state/WidgetFrame;", "pathEffect", "Landroidx/compose/ui/graphics/PathEffect;", "color", "drawFrame-g2O1Hgs", "(Landroidx/compose/ui/graphics/drawscope/DrawScope;Landroidx/constraintlayout/core/state/WidgetFrame;Landroidx/compose/ui/graphics/PathEffect;J)V", "drawFrameDebug", "parentWidth", "parentHeight", "startFrame", "endFrame", "drawFrameDebug-PE3pjmc", "(Landroidx/compose/ui/graphics/drawscope/DrawScope;FFLandroidx/constraintlayout/core/state/WidgetFrame;Landroidx/constraintlayout/core/state/WidgetFrame;Landroidx/compose/ui/graphics/PathEffect;J)V", "drawPath", "constraintlayout-compose_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class MotionMeasurer extends Measurer {
    public static final int $stable = 8;
    private final boolean DEBUG;
    private float lastProgressInInterpolation;
    private Constraints oldConstraints;
    private final androidx.constraintlayout.core.state.Transition transition;

    public MotionMeasurer(final Density density) {
        super(density);
        this.transition = new androidx.constraintlayout.core.state.Transition(new CorePixelDp() { // from class: androidx.constraintlayout.compose.MotionMeasurer$$ExternalSyntheticLambda0
            @Override // androidx.constraintlayout.core.state.CorePixelDp
            public final float toPixels(float f) {
                return MotionMeasurer.transition$lambda$1(density, f);
            }
        });
    }

    public final androidx.constraintlayout.core.state.Transition getTransition() {
        return this.transition;
    }

    /* JADX INFO: renamed from: measureConstraintSet--hBUhpc, reason: not valid java name */
    private final void m10124measureConstraintSethBUhpc(int optimizationLevel, ConstraintSet constraintSet, List<? extends Measurable> measurables, long constraints) {
        String string;
        Object layoutId;
        getState().reset();
        constraintSet.applyTo(getState(), measurables);
        ConstraintLayoutKt.buildMapping(getState(), measurables);
        getState().apply(getRoot());
        ArrayList<ConstraintWidget> children = getRoot().getChildren();
        int size = children.size();
        for (int i = 0; i < size; i++) {
            children.get(i).setAnimated(true);
        }
        m10086applyRootSizeBRTryo0(constraints);
        getRoot().updateHierarchy();
        if (this.DEBUG) {
            getRoot().setDebugName("ConstraintLayout");
            ArrayList<ConstraintWidget> children2 = getRoot().getChildren();
            int size2 = children2.size();
            for (int i2 = 0; i2 < size2; i2++) {
                ConstraintWidget constraintWidget = children2.get(i2);
                Object companionWidget = constraintWidget.getCompanionWidget();
                Measurable measurable = companionWidget instanceof Measurable ? (Measurable) companionWidget : null;
                if (measurable == null || (layoutId = LayoutIdKt.getLayoutId(measurable)) == null || (string = layoutId.toString()) == null) {
                    string = "NOTAG";
                }
                constraintWidget.setDebugName(string);
            }
        }
        getRoot().setOptimizationLevel(optimizationLevel);
        getRoot().measure(0, 0, 0, 0, 0, 0, 0, 0, 0);
    }

    /* JADX INFO: renamed from: performInterpolationMeasure-lUsXzhU, reason: not valid java name */
    public final long m10128performInterpolationMeasurelUsXzhU(long constraints, LayoutDirection layoutDirection, ConstraintSet constraintSetStart, ConstraintSet constraintSetEnd, TransitionImpl transition, List<? extends Measurable> measurables, int optimizationLevel, float progress, CompositionSource compositionSource, ShouldInvalidateCallback invalidateOnConstraintsCallback) {
        LayoutInformationReceiver layoutInformationReceiver;
        LayoutInformationReceiver layoutInformationReceiver2;
        boolean zM10125needsRemeasureNN6EwU = m10125needsRemeasureNN6EwU(constraints, compositionSource, invalidateOnConstraintsCallback);
        if (this.lastProgressInInterpolation != progress || ((((layoutInformationReceiver = getLayoutInformationReceiver()) == null || layoutInformationReceiver.getForcedWidth() != Integer.MIN_VALUE) && ((layoutInformationReceiver2 = getLayoutInformationReceiver()) == null || layoutInformationReceiver2.getForcedHeight() != Integer.MIN_VALUE)) || zM10125needsRemeasureNN6EwU)) {
            m10126recalculateInterpolation36Wf7g4(constraints, layoutDirection, constraintSetStart, constraintSetEnd, transition, measurables, optimizationLevel, progress, zM10125needsRemeasureNN6EwU);
        }
        this.oldConstraints = Constraints.m9627boximpl(constraints);
        return IntSizeKt.IntSize(getRoot().getWidth(), getRoot().getHeight());
    }

    /* JADX INFO: renamed from: needsRemeasure-NN6Ew-U, reason: not valid java name */
    private final boolean m10125needsRemeasureNN6EwU(long constraints, CompositionSource source, ShouldInvalidateCallback invalidateOnConstraintsCallback) {
        if (this.transition.isEmpty() || getFrameCache().isEmpty()) {
            return true;
        }
        Constraints constraints2 = this.oldConstraints;
        if (constraints2 != null && invalidateOnConstraintsCallback != null) {
            Intrinsics.checkNotNull(constraints2);
            if (invalidateOnConstraintsCallback.mo10068invokeN9IONVI(constraints2.getValue(), constraints)) {
                return true;
            }
        } else if ((Constraints.m9637getHasFixedHeightimpl(constraints) && !getState().sameFixedHeight(Constraints.m9639getMaxHeightimpl(constraints))) || (Constraints.m9638getHasFixedWidthimpl(constraints) && !getState().sameFixedWidth(Constraints.m9640getMaxWidthimpl(constraints)))) {
            return true;
        }
        return source == CompositionSource.Content;
    }

    /* JADX INFO: renamed from: recalculateInterpolation-36Wf7g4, reason: not valid java name */
    private final void m10126recalculateInterpolation36Wf7g4(long constraints, LayoutDirection layoutDirection, ConstraintSet constraintSetStart, ConstraintSet constraintSetEnd, TransitionImpl transition, List<? extends Measurable> measurables, int optimizationLevel, float progress, boolean remeasure) {
        WidgetFrame interpolated;
        androidx.constraintlayout.core.state.Dimension dimensionMin;
        androidx.constraintlayout.core.state.Dimension dimensionMin2;
        this.lastProgressInInterpolation = progress;
        int i = 0;
        if (remeasure) {
            this.transition.clear();
            resetMeasureState$constraintlayout_compose_release();
            State state = getState();
            if (Constraints.m9638getHasFixedWidthimpl(constraints)) {
                dimensionMin = androidx.constraintlayout.core.state.Dimension.createFixed(Constraints.m9640getMaxWidthimpl(constraints));
            } else {
                dimensionMin = androidx.constraintlayout.core.state.Dimension.createWrap().min(Constraints.m9642getMinWidthimpl(constraints));
            }
            state.width(dimensionMin);
            State state2 = getState();
            if (Constraints.m9637getHasFixedHeightimpl(constraints)) {
                dimensionMin2 = androidx.constraintlayout.core.state.Dimension.createFixed(Constraints.m9639getMaxHeightimpl(constraints));
            } else {
                dimensionMin2 = androidx.constraintlayout.core.state.Dimension.createWrap().min(Constraints.m9641getMinHeightimpl(constraints));
            }
            state2.height(dimensionMin2);
            getState().m10155setRootIncomingConstraintsBRTryo0(constraints);
            getState().setRtl(layoutDirection == LayoutDirection.Rtl);
            m10124measureConstraintSethBUhpc(optimizationLevel, constraintSetStart, measurables, constraints);
            this.transition.updateFrom(getRoot(), 0);
            m10124measureConstraintSethBUhpc(optimizationLevel, constraintSetEnd, measurables, constraints);
            this.transition.updateFrom(getRoot(), 1);
            if (transition != null) {
                transition.applyKeyFramesTo(this.transition);
            }
        } else {
            ConstraintLayoutKt.buildMapping(getState(), measurables);
        }
        this.transition.interpolate(getRoot().getWidth(), getRoot().getHeight(), progress);
        getRoot().setWidth(this.transition.getInterpolatedWidth());
        getRoot().setHeight(this.transition.getInterpolatedHeight());
        ArrayList<ConstraintWidget> children = getRoot().getChildren();
        int size = children.size();
        while (true) {
            if (i >= size) {
                break;
            }
            ConstraintWidget constraintWidget = children.get(i);
            Object companionWidget = constraintWidget.getCompanionWidget();
            Measurable measurable = companionWidget instanceof Measurable ? (Measurable) companionWidget : null;
            if (measurable != null && (interpolated = this.transition.getInterpolated(constraintWidget)) != null) {
                getPlaceables().put(measurable, measurable.mo8265measureBRTryo0(Constraints.INSTANCE.m9650fixedJhjzzOo(interpolated.width(), interpolated.height())));
                getFrameCache().put(measurable, interpolated);
            }
            i++;
        }
        LayoutInformationReceiver layoutInformationReceiver = getLayoutInformationReceiver();
        if ((layoutInformationReceiver != null ? layoutInformationReceiver.getLayoutInformationMode() : null) == LayoutInfoFlags.BOUNDS) {
            computeLayoutResult();
        }
    }

    private final void encodeKeyFrames(StringBuilder json, float[] location, int[] types, int[] progress, int count) {
        if (count == 0) {
            return;
        }
        json.append("keyTypes : [");
        for (int i = 0; i < count; i++) {
            json.append(" " + types[i] + AbstractJsonLexerKt.COMMA);
        }
        json.append("],\n");
        json.append("keyPos : [");
        int i2 = count * 2;
        for (int i3 = 0; i3 < i2; i3++) {
            json.append(" " + location[i3] + AbstractJsonLexerKt.COMMA);
        }
        json.append("],\n ");
        json.append("keyFrames : [");
        for (int i4 = 0; i4 < count; i4++) {
            json.append(" " + progress[i4] + AbstractJsonLexerKt.COMMA);
        }
        json.append("],\n ");
    }

    public final void encodeRoot(StringBuilder json) {
        json.append("  root: {");
        json.append("interpolated: { left:  0,");
        json.append("  top:  0,");
        json.append("  right:   " + getRoot().getWidth() + " ,");
        json.append("  bottom:  " + getRoot().getHeight() + " ,");
        json.append(" } }");
    }

    @Override // androidx.constraintlayout.compose.Measurer
    public void computeLayoutResult() {
        MotionMeasurer motionMeasurer = this;
        StringBuilder sb = new StringBuilder();
        sb.append("{ ");
        motionMeasurer.encodeRoot(sb);
        int[] iArr = new int[50];
        int[] iArr2 = new int[50];
        float[] fArr = new float[100];
        ArrayList<ConstraintWidget> children = motionMeasurer.getRoot().getChildren();
        int size = children.size();
        int i = 0;
        while (i < size) {
            ConstraintWidget constraintWidget = children.get(i);
            WidgetFrame start = motionMeasurer.transition.getStart(constraintWidget.stringId);
            WidgetFrame end = motionMeasurer.transition.getEnd(constraintWidget.stringId);
            WidgetFrame interpolated = motionMeasurer.transition.getInterpolated(constraintWidget.stringId);
            float[] path = motionMeasurer.transition.getPath(constraintWidget.stringId);
            int keyFrames = motionMeasurer.transition.getKeyFrames(constraintWidget.stringId, fArr, iArr, iArr2);
            sb.append(" " + constraintWidget.stringId + ": {");
            sb.append(" interpolated : ");
            interpolated.serialize(sb, true);
            sb.append(", start : ");
            start.serialize(sb);
            sb.append(", end : ");
            end.serialize(sb);
            motionMeasurer.encodeKeyFrames(sb, fArr, iArr, iArr2, keyFrames);
            sb.append(" path : [");
            for (float f : path) {
                sb.append(" " + f + " ,");
            }
            sb.append(" ] ");
            sb.append("}, ");
            i++;
            motionMeasurer = this;
        }
        sb.append(" }");
        LayoutInformationReceiver layoutInformationReceiver = getLayoutInformationReceiver();
        if (layoutInformationReceiver != null) {
            layoutInformationReceiver.setLayoutInformation(sb.toString());
        }
    }

    public static /* synthetic */ void drawDebug$default(MotionMeasurer motionMeasurer, DrawScope drawScope, boolean z, boolean z2, boolean z3, int i, Object obj) {
        if ((i & 1) != 0) {
            z = true;
        }
        if ((i & 2) != 0) {
            z2 = true;
        }
        if ((i & 4) != 0) {
            z3 = true;
        }
        motionMeasurer.drawDebug(drawScope, z, z2, z3);
    }

    public final void drawDebug(DrawScope drawScope, boolean z, boolean z2, boolean z3) {
        WidgetFrame widgetFrame;
        PathEffect pathEffectDashPathEffect = PathEffect.INSTANCE.dashPathEffect(new float[]{10.0f, 10.0f}, 0.0f);
        ArrayList<ConstraintWidget> children = getRoot().getChildren();
        int size = children.size();
        int i = 0;
        while (i < size) {
            ConstraintWidget constraintWidget = children.get(i);
            WidgetFrame start = this.transition.getStart(constraintWidget);
            WidgetFrame end = this.transition.getEnd(constraintWidget);
            if (z) {
                m10122drawFrameg2O1Hgs(drawScope, start, pathEffectDashPathEffect, Color.INSTANCE.m6841getBlue0d7_KjU());
                m10122drawFrameg2O1Hgs(drawScope, end, pathEffectDashPathEffect, Color.INSTANCE.m6841getBlue0d7_KjU());
                drawScope.getDrawContext().getTransform().translate(2.0f, 2.0f);
                try {
                    m10122drawFrameg2O1Hgs(drawScope, start, pathEffectDashPathEffect, Color.INSTANCE.m6851getWhite0d7_KjU());
                    widgetFrame = start;
                    m10122drawFrameg2O1Hgs(drawScope, end, pathEffectDashPathEffect, Color.INSTANCE.m6851getWhite0d7_KjU());
                    drawScope.getDrawContext().getTransform().translate(-2.0f, -2.0f);
                } catch (Throwable th) {
                    drawScope.getDrawContext().getTransform().translate(-2.0f, -2.0f);
                    throw th;
                }
            } else {
                widgetFrame = start;
            }
            drawPaths(drawScope, Size.m6638getWidthimpl(drawScope.mo7395getSizeNHjbRc()), Size.m6635getHeightimpl(drawScope.mo7395getSizeNHjbRc()), widgetFrame, z2, z3);
            i++;
            pathEffectDashPathEffect = pathEffectDashPathEffect;
        }
    }

    private final void drawPaths(DrawScope drawScope, float f, float f2, WidgetFrame widgetFrame, boolean z, boolean z2) {
        new MotionRenderDebug(23.0f).basicDraw(AndroidCanvas_androidKt.getNativeCanvas(drawScope.getDrawContext().getCanvas()), this.transition.getMotion(widgetFrame.widget.stringId), 1000, (int) f, (int) f2, z, z2);
    }

    /* JADX INFO: renamed from: drawFrameDebug-PE3pjmc, reason: not valid java name */
    private final void m10123drawFrameDebugPE3pjmc(DrawScope drawScope, float f, float f2, WidgetFrame widgetFrame, WidgetFrame widgetFrame2, PathEffect pathEffect, long j) {
        m10122drawFrameg2O1Hgs(drawScope, widgetFrame, pathEffect, j);
        m10122drawFrameg2O1Hgs(drawScope, widgetFrame2, pathEffect, j);
        int numberKeyPositions = this.transition.getNumberKeyPositions(widgetFrame);
        new MotionRenderDebug(23.0f).draw(AndroidCanvas_androidKt.getNativeCanvas(drawScope.getDrawContext().getCanvas()), this.transition.getMotion(widgetFrame.widget.stringId), 1000, 1, (int) f, (int) f2);
        if (numberKeyPositions == 0) {
            return;
        }
        float[] fArr = new float[numberKeyPositions];
        float[] fArr2 = new float[numberKeyPositions];
        float[] fArr3 = new float[numberKeyPositions];
        this.transition.fillKeyPositions(widgetFrame, fArr, fArr2, fArr3);
        int i = numberKeyPositions - 1;
        if (i < 0) {
            return;
        }
        int i2 = 0;
        while (true) {
            float f3 = fArr3[i2] / 100.0f;
            float f4 = 1 - f3;
            float fWidth = (widgetFrame.width() * f4) + (widgetFrame2.width() * f3);
            float fHeight = (f4 * widgetFrame.height()) + (f3 * widgetFrame2.height());
            float f5 = (fArr[i2] * f) + (fWidth / 2.0f);
            float f6 = (fArr2[i2] * f2) + (fHeight / 2.0f);
            Path Path = AndroidPath_androidKt.Path();
            Path.moveTo(f5 - 20.0f, f6);
            Path.lineTo(f5, f6 + 20.0f);
            Path.lineTo(f5 + 20.0f, f6);
            Path.lineTo(f5, f6 - 20.0f);
            Path.close();
            DrawScope.m7385drawPathLG529CI$default(drawScope, Path, j, 1.0f, new Stroke(3.0f, 0.0f, 0, 0, null, 30, null), null, 0, 48, null);
            if (i2 == i) {
                return;
            } else {
                i2++;
            }
        }
    }

    /* JADX INFO: renamed from: drawFrame-g2O1Hgs, reason: not valid java name */
    private final void m10122drawFrameg2O1Hgs(DrawScope drawScope, WidgetFrame widgetFrame, PathEffect pathEffect, long j) {
        if (widgetFrame.isDefaultTransform()) {
            DrawScope.m7389drawRectnJ9OG0$default(drawScope, j, OffsetKt.Offset(widgetFrame.left, widgetFrame.top), SizeKt.Size(widgetFrame.width(), widgetFrame.height()), 0.0f, new Stroke(3.0f, 0.0f, 0, 0, pathEffect, 14, null), null, 0, 104, null);
            return;
        }
        Matrix matrix = new Matrix();
        if (!Float.isNaN(widgetFrame.rotationZ)) {
            matrix.preRotate(widgetFrame.rotationZ, widgetFrame.centerX(), widgetFrame.centerY());
        }
        matrix.preScale(Float.isNaN(widgetFrame.scaleX) ? 1.0f : widgetFrame.scaleX, Float.isNaN(widgetFrame.scaleY) ? 1.0f : widgetFrame.scaleY, widgetFrame.centerX(), widgetFrame.centerY());
        float[] fArr = {widgetFrame.left, widgetFrame.top, widgetFrame.right, widgetFrame.top, widgetFrame.right, widgetFrame.bottom, widgetFrame.left, widgetFrame.bottom};
        matrix.mapPoints(fArr);
        DrawScope.m7381drawLineNGM6Ib0$default(drawScope, j, OffsetKt.Offset(fArr[0], fArr[1]), OffsetKt.Offset(fArr[2], fArr[3]), 3.0f, 0, pathEffect, 0.0f, null, 0, 464, null);
        DrawScope.m7381drawLineNGM6Ib0$default(drawScope, j, OffsetKt.Offset(fArr[2], fArr[3]), OffsetKt.Offset(fArr[4], fArr[5]), 3.0f, 0, pathEffect, 0.0f, null, 0, 464, null);
        DrawScope.m7381drawLineNGM6Ib0$default(drawScope, j, OffsetKt.Offset(fArr[4], fArr[5]), OffsetKt.Offset(fArr[6], fArr[7]), 3.0f, 0, pathEffect, 0.0f, null, 0, 464, null);
        DrawScope.m7381drawLineNGM6Ib0$default(drawScope, j, OffsetKt.Offset(fArr[6], fArr[7]), OffsetKt.Offset(fArr[0], fArr[1]), 3.0f, 0, pathEffect, 0.0f, null, 0, 464, null);
    }

    /* JADX INFO: renamed from: getCustomColor-XeAY9LY, reason: not valid java name */
    public final long m10127getCustomColorXeAY9LY(String id, String name, float progress) {
        if (!this.transition.contains(id)) {
            return Color.INSTANCE.m6850getUnspecified0d7_KjU();
        }
        this.transition.interpolate(getRoot().getWidth(), getRoot().getHeight(), progress);
        WidgetFrame interpolated = this.transition.getInterpolated(id);
        if (!interpolated.containsCustom(name)) {
            return Color.INSTANCE.m6850getUnspecified0d7_KjU();
        }
        return ColorKt.Color(interpolated.getCustomColor(name));
    }

    public final float getCustomFloat(String id, String name, float progress) {
        if (!this.transition.contains(id)) {
            return Float.NaN;
        }
        this.transition.interpolate(getRoot().getWidth(), getRoot().getHeight(), progress);
        return this.transition.getInterpolated(id).getCustomFloat(name);
    }

    public final void clearConstraintSets() {
        this.transition.clear();
        getFrameCache().clear();
    }

    public final void initWith(ConstraintSet start, ConstraintSet end, LayoutDirection layoutDirection, TransitionImpl transition, float progress) {
        clearConstraintSets();
        getState().setRtl(layoutDirection == LayoutDirection.Rtl);
        start.applyTo(getState(), CollectionsKt.emptyList());
        start.applyTo(this.transition, 0);
        getState().apply(getRoot());
        this.transition.updateFrom(getRoot(), 0);
        start.applyTo(getState(), CollectionsKt.emptyList());
        end.applyTo(this.transition, 1);
        getState().apply(getRoot());
        this.transition.updateFrom(getRoot(), 1);
        this.transition.interpolate(0, 0, progress);
        transition.applyAllTo(this.transition);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final float transition$lambda$1(Density density, float f) {
        return density.mo754toPx0680j_4(Dp.m9687constructorimpl(f));
    }
}
