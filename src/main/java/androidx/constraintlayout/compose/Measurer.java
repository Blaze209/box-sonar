package androidx.constraintlayout.compose;

import android.util.Log;
import androidx.collection.IntIntPair;
import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.CanvasKt;
import androidx.compose.foundation.ImageKt;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScope;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.shape.RoundedCornerShapeKt;
import androidx.compose.foundation.text.BasicTextFieldKt;
import androidx.compose.foundation.text.BasicTextKt;
import androidx.compose.foundation.text.KeyboardActions;
import androidx.compose.foundation.text.KeyboardOptions;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.Updater;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.draw.ClipKt;
import androidx.compose.ui.geometry.OffsetKt;
import androidx.compose.ui.geometry.Size;
import androidx.compose.ui.graphics.Brush;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.ColorFilter;
import androidx.compose.ui.graphics.ColorKt;
import androidx.compose.ui.graphics.ColorProducer;
import androidx.compose.ui.graphics.Shadow;
import androidx.compose.ui.graphics.drawscope.DrawScope;
import androidx.compose.ui.graphics.drawscope.DrawStyle;
import androidx.compose.ui.layout.AlignmentLineKt;
import androidx.compose.ui.layout.ContentScale;
import androidx.compose.ui.layout.LayoutIdKt;
import androidx.compose.ui.layout.Measurable;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.res.PainterResources_androidKt;
import androidx.compose.ui.text.PlatformTextStyle;
import androidx.compose.ui.text.TextLayoutResult;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.text.font.FontFamily;
import androidx.compose.ui.text.font.FontStyle;
import androidx.compose.ui.text.font.FontSynthesis;
import androidx.compose.ui.text.font.FontWeight;
import androidx.compose.ui.text.input.VisualTransformation;
import androidx.compose.ui.text.intl.LocaleList;
import androidx.compose.ui.text.style.BaselineShift;
import androidx.compose.ui.text.style.LineHeightStyle;
import androidx.compose.ui.text.style.TextDecoration;
import androidx.compose.ui.text.style.TextGeometricTransform;
import androidx.compose.ui.text.style.TextIndent;
import androidx.compose.ui.text.style.TextMotion;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.ConstraintsKt;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.IntSizeKt;
import androidx.compose.ui.unit.LayoutDirection;
import androidx.compose.ui.unit.TextUnit;
import androidx.compose.ui.unit.TextUnitKt;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.constraintlayout.core.state.ConstraintSetParser;
import androidx.constraintlayout.core.state.WidgetFrame;
import androidx.constraintlayout.core.widgets.ConstraintWidget;
import androidx.constraintlayout.core.widgets.ConstraintWidgetContainer;
import androidx.constraintlayout.core.widgets.Guideline;
import androidx.constraintlayout.core.widgets.VirtualLayout;
import androidx.constraintlayout.core.widgets.analyzer.BasicMeasure;
import com.box.android.preview.wopi.WopiService;
import com.facebook.react.uimanager.ViewProps;
import com.microsoft.identity.common.internal.broker.SerializedNames;
import com.pspdfkit.contentediting.models.serializer.ColorSerializer;
import external.sdk.pendo.io.mozilla.javascript.Token;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlin.text.StringsKt;

/* JADX INFO: compiled from: ConstraintLayout.kt */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(d1 = {"\u0000ê\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0005\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0015\n\u0000\n\u0002\u0010\u0011\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0011\u0018\u00002\u00020\u00012\u00020\u0002B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\u0010\u00104\u001a\u0002052\b\u00106\u001a\u0004\u0018\u00010#J\u001a\u00107\u001a\u0002052\u0006\u00108\u001a\u000209H\u0004ø\u0001\u0000¢\u0006\u0004\b:\u0010;J\b\u0010<\u001a\u000205H\u0016J\r\u0010=\u001a\u000205H\u0007¢\u0006\u0002\u0010>J\b\u0010?\u001a\u000205H\u0016J&\u0010@\u001a\u00020A2\b\u0010B\u001a\u0004\u0018\u00010\u00072\b\b\u0002\u0010C\u001a\u00020AH\u0002ø\u0001\u0000¢\u0006\u0004\bD\u0010EJ \u0010F\u001a\u00020\u00072\u0006\u0010G\u001a\u00020\u001c2\u0006\u0010H\u001a\u00020\u001c2\u0006\u0010I\u001a\u00020\u0007H\u0016J,\u0010J\u001a\u00020K2\"\u0010L\u001a\u001e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00070Mj\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u0007`NH\u0002J\u0018\u0010O\u001a\u0002052\u0006\u0010P\u001a\u00020Q2\u0006\u0010O\u001a\u00020RH\u0016J\"\u0010S\u001a\u00020T2\u0006\u0010P\u001a\u00020Q2\u0006\u00108\u001a\u000209H\u0002ø\u0001\u0000¢\u0006\u0004\bU\u0010VJH\u0010W\u001a\u00020X2\u0006\u0010Y\u001a\u00020Z2\u0006\u0010[\u001a\u00020\u001c2\u0006\u0010\\\u001a\u00020\u001c2\u0006\u0010]\u001a\u00020\u001c2\u0006\u0010^\u001a\u00020X2\u0006\u0010_\u001a\u00020X2\u0006\u0010`\u001a\u00020\u001c2\u0006\u0010a\u001a\u00020\u0019H\u0002J\u000e\u0010b\u001a\u0002052\u0006\u0010c\u001a\u00020dJ>\u0010e\u001a\u00020f2\u0006\u00108\u001a\u0002092\u0006\u0010g\u001a\u00020h2\u0006\u0010c\u001a\u00020d2\f\u0010i\u001a\b\u0012\u0004\u0012\u00020\u00140j2\u0006\u0010k\u001a\u00020\u001cø\u0001\u0000¢\u0006\u0004\bl\u0010mJ\r\u0010n\u001a\u000205H\u0000¢\u0006\u0002\boJ\u001f\u0010p\u001a\u000205*\b\u0012\u0004\u0012\u00020\u001c0\u001b2\u0006\u0010O\u001a\u00020RH\u0002¢\u0006\u0002\u0010qJ\u0019\u0010r\u001a\u000205*\u00020s2\u0006\u0010\f\u001a\u00020\rH\u0007¢\u0006\u0002\u0010tJ\u0012\u0010r\u001a\u000205*\u00020u2\u0006\u0010\f\u001a\u00020\rJ\u0018\u0010v\u001a\u000205*\u00020w2\f\u0010i\u001a\b\u0012\u0004\u0012\u00020\u00140jR\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u001e\u0010\b\u001a\u0012\u0012\u0004\u0012\u00020\n0\tj\b\u0012\u0004\u0012\u00020\n`\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\f\u001a\u00020\rX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R \u0010\u0012\u001a\u000e\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u00150\u0013X\u0084\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u000e\u0010\u0018\u001a\u00020\u0019X\u0082\u0004¢\u0006\u0002\n\u0000R \u0010\u001a\u001a\u0014\u0012\u0004\u0012\u00020\u0007\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001c0\u001b0\u0013X\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u001d\u001a\u00020\u001c8F¢\u0006\u0006\u001a\u0004\b\u001e\u0010\u001fR\u0011\u0010 \u001a\u00020\u001c8F¢\u0006\u0006\u001a\u0004\b!\u0010\u001fR\u001c\u0010\"\u001a\u0004\u0018\u00010#X\u0084\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b$\u0010%\"\u0004\b&\u0010'R \u0010(\u001a\u000e\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020)0\u0013X\u0084\u0004¢\u0006\b\n\u0000\u001a\u0004\b*\u0010\u0017R\u0014\u0010+\u001a\u00020,X\u0084\u0004¢\u0006\b\n\u0000\u001a\u0004\b-\u0010.R\u0014\u0010/\u001a\u000200X\u0084\u0004¢\u0006\b\n\u0000\u001a\u0004\b1\u00102R\u000e\u00103\u001a\u00020\u0019X\u0082\u0004¢\u0006\u0002\n\u0000\u0082\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006x"}, d2 = {"Landroidx/constraintlayout/compose/Measurer;", "Landroidx/constraintlayout/core/widgets/analyzer/BasicMeasure$Measurer;", "Landroidx/constraintlayout/compose/DesignInfoProvider;", "density", "Landroidx/compose/ui/unit/Density;", "(Landroidx/compose/ui/unit/Density;)V", "computedLayoutResult", "", "designElements", "Ljava/util/ArrayList;", "Landroidx/constraintlayout/core/state/ConstraintSetParser$DesignElement;", "Lkotlin/collections/ArrayList;", "forcedScaleFactor", "", "getForcedScaleFactor", "()F", "setForcedScaleFactor", "(F)V", "frameCache", "", "Landroidx/compose/ui/layout/Measurable;", "Landroidx/constraintlayout/core/state/WidgetFrame;", "getFrameCache", "()Ljava/util/Map;", "heightConstraintsHolder", "", "lastMeasures", "", "", "layoutCurrentHeight", "getLayoutCurrentHeight", "()I", "layoutCurrentWidth", "getLayoutCurrentWidth", "layoutInformationReceiver", "Landroidx/constraintlayout/compose/LayoutInformationReceiver;", "getLayoutInformationReceiver", "()Landroidx/constraintlayout/compose/LayoutInformationReceiver;", "setLayoutInformationReceiver", "(Landroidx/constraintlayout/compose/LayoutInformationReceiver;)V", "placeables", "Landroidx/compose/ui/layout/Placeable;", "getPlaceables", "root", "Landroidx/constraintlayout/core/widgets/ConstraintWidgetContainer;", "getRoot", "()Landroidx/constraintlayout/core/widgets/ConstraintWidgetContainer;", "state", "Landroidx/constraintlayout/compose/State;", "getState", "()Landroidx/constraintlayout/compose/State;", "widthConstraintsHolder", "addLayoutInformationReceiver", "", "layoutReceiver", "applyRootSize", "constraints", "Landroidx/compose/ui/unit/Constraints;", "applyRootSize-BRTryo0", "(J)V", "computeLayoutResult", "createDesignElements", "(Landroidx/compose/runtime/Composer;I)V", "didMeasures", "getColor", "Landroidx/compose/ui/graphics/Color;", "str", "defaultColor", "getColor-wrIjXm8", "(Ljava/lang/String;J)J", "getDesignInfo", "startX", "startY", "args", "getTextStyle", "Landroidx/compose/ui/text/TextStyle;", SerializedNames.PARAMS, "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "measure", "constraintWidget", "Landroidx/constraintlayout/core/widgets/ConstraintWidget;", "Landroidx/constraintlayout/core/widgets/analyzer/BasicMeasure$Measure;", "measureWidget", "Landroidx/collection/IntIntPair;", "measureWidget-yQShABA", "(Landroidx/constraintlayout/core/widgets/ConstraintWidget;J)J", "obtainConstraints", "", "dimensionBehaviour", "Landroidx/constraintlayout/core/widgets/ConstraintWidget$DimensionBehaviour;", TypedValues.Custom.S_DIMENSION, "matchConstraintDefaultDimension", "measureStrategy", "otherDimensionResolved", "currentDimensionResolved", "rootMaxConstraint", "outConstraints", "parseDesignElements", "constraintSet", "Landroidx/constraintlayout/compose/ConstraintSet;", "performMeasure", "Landroidx/compose/ui/unit/IntSize;", ViewProps.LAYOUT_DIRECTION, "Landroidx/compose/ui/unit/LayoutDirection;", "measurables", "", "optimizationLevel", "performMeasure-2eBlSMk", "(JLandroidx/compose/ui/unit/LayoutDirection;Landroidx/constraintlayout/compose/ConstraintSet;Ljava/util/List;I)J", "resetMeasureState", "resetMeasureState$constraintlayout_compose_release", "copyFrom", "([Ljava/lang/Integer;Landroidx/constraintlayout/core/widgets/analyzer/BasicMeasure$Measure;)V", "drawDebugBounds", "Landroidx/compose/foundation/layout/BoxScope;", "(Landroidx/compose/foundation/layout/BoxScope;FLandroidx/compose/runtime/Composer;I)V", "Landroidx/compose/ui/graphics/drawscope/DrawScope;", "performLayout", "Landroidx/compose/ui/layout/Placeable$PlacementScope;", "constraintlayout-compose_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public class Measurer implements BasicMeasure.Measurer, DesignInfoProvider {
    public static final int $stable = 8;
    private String computedLayoutResult = "";
    private ArrayList<ConstraintSetParser.DesignElement> designElements;
    private float forcedScaleFactor;
    private final Map<Measurable, WidgetFrame> frameCache;
    private final int[] heightConstraintsHolder;
    private final Map<String, Integer[]> lastMeasures;
    private LayoutInformationReceiver layoutInformationReceiver;
    private final Map<Measurable, Placeable> placeables;
    private final ConstraintWidgetContainer root;
    private final State state;
    private final int[] widthConstraintsHolder;

    /* JADX INFO: compiled from: ConstraintLayout.kt */
    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[ConstraintWidget.DimensionBehaviour.values().length];
            try {
                iArr[ConstraintWidget.DimensionBehaviour.FIXED.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[ConstraintWidget.DimensionBehaviour.WRAP_CONTENT.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[ConstraintWidget.DimensionBehaviour.MATCH_PARENT.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    @Override // androidx.constraintlayout.core.widgets.analyzer.BasicMeasure.Measurer
    public void didMeasures() {
    }

    public Measurer(Density density) {
        ConstraintWidgetContainer constraintWidgetContainer = new ConstraintWidgetContainer(0, 0);
        constraintWidgetContainer.setMeasurer(this);
        this.root = constraintWidgetContainer;
        this.placeables = new LinkedHashMap();
        this.lastMeasures = new LinkedHashMap();
        this.frameCache = new LinkedHashMap();
        this.state = new State(density);
        this.widthConstraintsHolder = new int[2];
        this.heightConstraintsHolder = new int[2];
        this.forcedScaleFactor = Float.NaN;
        this.designElements = new ArrayList<>();
    }

    protected final LayoutInformationReceiver getLayoutInformationReceiver() {
        return this.layoutInformationReceiver;
    }

    protected final void setLayoutInformationReceiver(LayoutInformationReceiver layoutInformationReceiver) {
        this.layoutInformationReceiver = layoutInformationReceiver;
    }

    protected final ConstraintWidgetContainer getRoot() {
        return this.root;
    }

    protected final Map<Measurable, Placeable> getPlaceables() {
        return this.placeables;
    }

    protected final Map<Measurable, WidgetFrame> getFrameCache() {
        return this.frameCache;
    }

    protected final State getState() {
        return this.state;
    }

    public final float getForcedScaleFactor() {
        return this.forcedScaleFactor;
    }

    public final void setForcedScaleFactor(float f) {
        this.forcedScaleFactor = f;
    }

    public final int getLayoutCurrentWidth() {
        return this.root.getWidth();
    }

    public final int getLayoutCurrentHeight() {
        return this.root.getHeight();
    }

    @Override // androidx.constraintlayout.compose.DesignInfoProvider
    public String getDesignInfo(int startX, int startY, String args) {
        return ToolingUtilsKt.parseConstraintsToJson(this.root, this.state, startX, startY, args);
    }

    @Override // androidx.constraintlayout.core.widgets.analyzer.BasicMeasure.Measurer
    public void measure(ConstraintWidget constraintWidget, BasicMeasure.Measure measure) {
        boolean z;
        String str = constraintWidget.stringId;
        if (ConstraintLayoutKt.DEBUG) {
            Log.d("CCL", "Measuring " + str + " with: " + ConstraintLayoutKt.toDebugString(constraintWidget) + '\n');
        }
        Integer[] numArr = this.lastMeasures.get(str);
        ConstraintWidget.DimensionBehaviour dimensionBehaviour = measure.horizontalBehavior;
        int i = measure.horizontalDimension;
        int i2 = constraintWidget.mMatchConstraintDefaultWidth;
        int i3 = measure.measureStrategy;
        boolean z2 = false;
        if ((numArr != null ? numArr[1].intValue() : 0) == constraintWidget.getHeight()) {
            z2 = true;
        }
        boolean z3 = false;
        obtainConstraints(dimensionBehaviour, i, i2, i3, z2, constraintWidget.isResolvedHorizontally(), Constraints.m9640getMaxWidthimpl(this.state.getRootIncomingConstraints()), this.widthConstraintsHolder);
        obtainConstraints(measure.verticalBehavior, measure.verticalDimension, constraintWidget.mMatchConstraintDefaultHeight, measure.measureStrategy, (numArr != null ? numArr[0].intValue() : 0) == constraintWidget.getWidth(), constraintWidget.isResolvedVertically(), Constraints.m9639getMaxHeightimpl(this.state.getRootIncomingConstraints()), this.heightConstraintsHolder);
        int[] iArr = this.widthConstraintsHolder;
        int i4 = iArr[0];
        int i5 = iArr[1];
        int[] iArr2 = this.heightConstraintsHolder;
        long jConstraints = ConstraintsKt.Constraints(i4, i5, iArr2[0], iArr2[1]);
        if (measure.measureStrategy == BasicMeasure.Measure.TRY_GIVEN_DIMENSIONS || measure.measureStrategy == BasicMeasure.Measure.USE_GIVEN_DIMENSIONS || measure.horizontalBehavior != ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT || constraintWidget.mMatchConstraintDefaultWidth != 0 || measure.verticalBehavior != ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT || constraintWidget.mMatchConstraintDefaultHeight != 0) {
            if (ConstraintLayoutKt.DEBUG) {
                Log.d("CCL", "Measuring " + str + " with " + ((Object) Constraints.m9645toStringimpl(jConstraints)));
            }
            long jM10085measureWidgetyQShABA = m10085measureWidgetyQShABA(constraintWidget, jConstraints);
            constraintWidget.setMeasureRequested(false);
            if (ConstraintLayoutKt.DEBUG) {
                Log.d("CCL", str + " is size " + IntIntPair.m331getFirstimpl(jM10085measureWidgetyQShABA) + ' ' + IntIntPair.m332getSecondimpl(jM10085measureWidgetyQShABA));
            }
            Integer numValueOf = Integer.valueOf(IntIntPair.m331getFirstimpl(jM10085measureWidgetyQShABA));
            Integer numValueOf2 = Integer.valueOf(constraintWidget.mMatchConstraintMinWidth);
            if (numValueOf2.intValue() <= 0) {
                numValueOf2 = null;
            }
            Integer num = numValueOf2;
            Integer numValueOf3 = Integer.valueOf(constraintWidget.mMatchConstraintMaxWidth);
            if (numValueOf3.intValue() <= 0) {
                numValueOf3 = null;
            }
            int iIntValue = ((Number) RangesKt.coerceIn(numValueOf, num, numValueOf3)).intValue();
            Integer numValueOf4 = Integer.valueOf(IntIntPair.m332getSecondimpl(jM10085measureWidgetyQShABA));
            Integer numValueOf5 = Integer.valueOf(constraintWidget.mMatchConstraintMinHeight);
            if (numValueOf5.intValue() <= 0) {
                numValueOf5 = null;
            }
            Integer num2 = numValueOf5;
            Integer numValueOf6 = Integer.valueOf(constraintWidget.mMatchConstraintMaxHeight);
            int iIntValue2 = ((Number) RangesKt.coerceIn(numValueOf4, num2, numValueOf6.intValue() > 0 ? numValueOf6 : null)).intValue();
            if (iIntValue != IntIntPair.m331getFirstimpl(jM10085measureWidgetyQShABA)) {
                jConstraints = ConstraintsKt.Constraints(iIntValue, iIntValue, Constraints.m9641getMinHeightimpl(jConstraints), Constraints.m9639getMaxHeightimpl(jConstraints));
                z = true;
            } else {
                z = false;
            }
            if (iIntValue2 != IntIntPair.m332getSecondimpl(jM10085measureWidgetyQShABA)) {
                jConstraints = ConstraintsKt.Constraints(Constraints.m9642getMinWidthimpl(jConstraints), Constraints.m9640getMaxWidthimpl(jConstraints), iIntValue2, iIntValue2);
                z = true;
            }
            if (z) {
                if (ConstraintLayoutKt.DEBUG) {
                    Log.d("CCL", "Remeasuring coerced " + str + " with " + ((Object) Constraints.m9645toStringimpl(jConstraints)));
                }
                m10085measureWidgetyQShABA(constraintWidget, jConstraints);
                constraintWidget.setMeasureRequested(false);
            }
        }
        Placeable placeable = this.placeables.get(constraintWidget.getCompanionWidget());
        measure.measuredWidth = placeable != null ? placeable.getWidth() : constraintWidget.getWidth();
        measure.measuredHeight = placeable != null ? placeable.getHeight() : constraintWidget.getHeight();
        int i6 = (placeable == null || !this.state.isBaselineNeeded(constraintWidget)) ? Integer.MIN_VALUE : placeable.get(AlignmentLineKt.getFirstBaseline());
        measure.measuredHasBaseline = i6 != Integer.MIN_VALUE;
        measure.measuredBaseline = i6;
        Map<String, Integer[]> map = this.lastMeasures;
        Integer[] numArr2 = map.get(str);
        if (numArr2 == null) {
            numArr2 = new Integer[]{0, 0, Integer.MIN_VALUE};
            map.put(str, numArr2);
        }
        copyFrom(numArr2, measure);
        if (measure.measuredWidth != measure.horizontalDimension || measure.measuredHeight != measure.verticalDimension) {
            z3 = true;
        }
        measure.measuredNeedsSolverPass = z3;
    }

    public final void addLayoutInformationReceiver(LayoutInformationReceiver layoutReceiver) {
        this.layoutInformationReceiver = layoutReceiver;
        if (layoutReceiver != null) {
            layoutReceiver.setLayoutInformation(this.computedLayoutResult);
        }
    }

    public void computeLayoutResult() {
        ConstraintWidget constraintWidget;
        StringBuilder sb = new StringBuilder();
        sb.append("{   root: {interpolated: { left:  0,  top:  0,");
        sb.append("  right:   " + this.root.getWidth() + " ,");
        sb.append("  bottom:  " + this.root.getHeight() + " ,");
        sb.append(" } }");
        for (ConstraintWidget constraintWidget2 : this.root.getChildren()) {
            Object companionWidget = constraintWidget2.getCompanionWidget();
            if (companionWidget instanceof Measurable) {
                WidgetFrame widgetFrame = null;
                if (constraintWidget2.stringId == null) {
                    Measurable measurable = (Measurable) companionWidget;
                    Object layoutId = LayoutIdKt.getLayoutId(measurable);
                    if (layoutId == null) {
                        layoutId = ConstraintLayoutTagKt.getConstraintLayoutId(measurable);
                    }
                    constraintWidget2.stringId = layoutId != null ? layoutId.toString() : null;
                }
                WidgetFrame widgetFrame2 = this.frameCache.get(companionWidget);
                if (widgetFrame2 != null && (constraintWidget = widgetFrame2.widget) != null) {
                    widgetFrame = constraintWidget.frame;
                }
                if (widgetFrame != null) {
                    sb.append(" " + constraintWidget2.stringId + ": {");
                    sb.append(" interpolated : ");
                    widgetFrame.serialize(sb, true);
                    sb.append("}, ");
                }
            } else if (constraintWidget2 instanceof Guideline) {
                sb.append(" " + constraintWidget2.stringId + ": {");
                Guideline guideline = (Guideline) constraintWidget2;
                if (guideline.getOrientation() == 0) {
                    sb.append(" type: 'hGuideline', ");
                } else {
                    sb.append(" type: 'vGuideline', ");
                }
                sb.append(" interpolated: ");
                sb.append(" { left: " + guideline.getX() + ", top: " + guideline.getY() + ", right: " + (guideline.getX() + guideline.getWidth()) + ", bottom: " + (guideline.getY() + guideline.getHeight()) + " }");
                sb.append("}, ");
            }
        }
        sb.append(" }");
        String string = sb.toString();
        this.computedLayoutResult = string;
        LayoutInformationReceiver layoutInformationReceiver = this.layoutInformationReceiver;
        if (layoutInformationReceiver != null) {
            layoutInformationReceiver.setLayoutInformation(string);
        }
    }

    private final boolean obtainConstraints(ConstraintWidget.DimensionBehaviour dimensionBehaviour, int dimension, int matchConstraintDefaultDimension, int measureStrategy, boolean otherDimensionResolved, boolean currentDimensionResolved, int rootMaxConstraint, int[] outConstraints) {
        int i = WhenMappings.$EnumSwitchMapping$0[dimensionBehaviour.ordinal()];
        if (i == 1) {
            outConstraints[0] = dimension;
            outConstraints[1] = dimension;
            return false;
        }
        if (i == 2) {
            outConstraints[0] = 0;
            outConstraints[1] = rootMaxConstraint;
            return true;
        }
        if (i != 3) {
            if (i == 4) {
                outConstraints[0] = rootMaxConstraint;
                outConstraints[1] = rootMaxConstraint;
                return false;
            }
            throw new IllegalStateException((dimensionBehaviour + " is not supported").toString());
        }
        if (ConstraintLayoutKt.DEBUG) {
            Log.d("CCL", "Measure strategy " + measureStrategy);
            Log.d("CCL", "DW " + matchConstraintDefaultDimension);
            Log.d("CCL", "ODR " + otherDimensionResolved);
            Log.d("CCL", "IRH " + currentDimensionResolved);
        }
        boolean z = currentDimensionResolved || ((measureStrategy == BasicMeasure.Measure.TRY_GIVEN_DIMENSIONS || measureStrategy == BasicMeasure.Measure.USE_GIVEN_DIMENSIONS) && (measureStrategy == BasicMeasure.Measure.USE_GIVEN_DIMENSIONS || matchConstraintDefaultDimension != 1 || otherDimensionResolved));
        if (ConstraintLayoutKt.DEBUG) {
            Log.d("CCL", "UD " + z);
        }
        outConstraints[0] = z ? dimension : 0;
        if (!z) {
            dimension = rootMaxConstraint;
        }
        outConstraints[1] = dimension;
        return !z;
    }

    private final void copyFrom(Integer[] numArr, BasicMeasure.Measure measure) {
        numArr[0] = Integer.valueOf(measure.measuredWidth);
        numArr[1] = Integer.valueOf(measure.measuredHeight);
        numArr[2] = Integer.valueOf(measure.measuredBaseline);
    }

    /* JADX INFO: renamed from: performMeasure-2eBlSMk, reason: not valid java name */
    public final long m10087performMeasure2eBlSMk(long constraints, LayoutDirection layoutDirection, ConstraintSet constraintSet, List<? extends Measurable> measurables, int optimizationLevel) {
        androidx.constraintlayout.core.state.Dimension dimensionMin;
        androidx.constraintlayout.core.state.Dimension dimensionMin2;
        String string;
        Object layoutId;
        if (measurables.isEmpty()) {
            return IntSizeKt.IntSize(Constraints.m9642getMinWidthimpl(constraints), Constraints.m9641getMinHeightimpl(constraints));
        }
        State state = this.state;
        if (Constraints.m9638getHasFixedWidthimpl(constraints)) {
            dimensionMin = androidx.constraintlayout.core.state.Dimension.createFixed(Constraints.m9640getMaxWidthimpl(constraints));
        } else {
            dimensionMin = androidx.constraintlayout.core.state.Dimension.createWrap().min(Constraints.m9642getMinWidthimpl(constraints));
        }
        state.width(dimensionMin);
        State state2 = this.state;
        if (Constraints.m9637getHasFixedHeightimpl(constraints)) {
            dimensionMin2 = androidx.constraintlayout.core.state.Dimension.createFixed(Constraints.m9639getMaxHeightimpl(constraints));
        } else {
            dimensionMin2 = androidx.constraintlayout.core.state.Dimension.createWrap().min(Constraints.m9641getMinHeightimpl(constraints));
        }
        state2.height(dimensionMin2);
        this.state.mParent.getWidth().apply(this.state, this.root, 0);
        this.state.mParent.getHeight().apply(this.state, this.root, 1);
        this.state.m10155setRootIncomingConstraintsBRTryo0(constraints);
        this.state.setRtl(layoutDirection == LayoutDirection.Rtl);
        resetMeasureState$constraintlayout_compose_release();
        if (constraintSet.isDirty(measurables)) {
            this.state.reset();
            constraintSet.applyTo(this.state, measurables);
            ConstraintLayoutKt.buildMapping(this.state, measurables);
            this.state.apply(this.root);
        } else {
            ConstraintLayoutKt.buildMapping(this.state, measurables);
        }
        m10086applyRootSizeBRTryo0(constraints);
        this.root.updateHierarchy();
        if (ConstraintLayoutKt.DEBUG) {
            this.root.setDebugName("ConstraintLayout");
            ArrayList<ConstraintWidget> children = this.root.getChildren();
            int size = children.size();
            for (int i = 0; i < size; i++) {
                ConstraintWidget constraintWidget = children.get(i);
                Object companionWidget = constraintWidget.getCompanionWidget();
                Measurable measurable = companionWidget instanceof Measurable ? (Measurable) companionWidget : null;
                if (measurable == null || (layoutId = LayoutIdKt.getLayoutId(measurable)) == null || (string = layoutId.toString()) == null) {
                    string = "NOTAG";
                }
                constraintWidget.setDebugName(string);
            }
            Log.d("CCL", "ConstraintLayout is asked to measure with " + ((Object) Constraints.m9645toStringimpl(constraints)));
            Log.d("CCL", ConstraintLayoutKt.toDebugString(this.root));
            ArrayList<ConstraintWidget> children2 = this.root.getChildren();
            int size2 = children2.size();
            for (int i2 = 0; i2 < size2; i2++) {
                Log.d("CCL", ConstraintLayoutKt.toDebugString(children2.get(i2)));
            }
        }
        this.root.setOptimizationLevel(optimizationLevel);
        ConstraintWidgetContainer constraintWidgetContainer = this.root;
        constraintWidgetContainer.measure(constraintWidgetContainer.getOptimizationLevel(), 0, 0, 0, 0, 0, 0, 0, 0);
        if (ConstraintLayoutKt.DEBUG) {
            Log.d("CCL", "ConstraintLayout is at the end " + this.root.getWidth() + ' ' + this.root.getHeight());
        }
        return IntSizeKt.IntSize(this.root.getWidth(), this.root.getHeight());
    }

    public final void resetMeasureState$constraintlayout_compose_release() {
        this.placeables.clear();
        this.lastMeasures.clear();
        this.frameCache.clear();
    }

    /* JADX INFO: renamed from: applyRootSize-BRTryo0, reason: not valid java name */
    protected final void m10086applyRootSizeBRTryo0(long constraints) {
        this.root.setWidth(Constraints.m9640getMaxWidthimpl(constraints));
        this.root.setHeight(Constraints.m9639getMaxHeightimpl(constraints));
        this.forcedScaleFactor = Float.NaN;
        LayoutInformationReceiver layoutInformationReceiver = this.layoutInformationReceiver;
        if (layoutInformationReceiver != null && (layoutInformationReceiver == null || layoutInformationReceiver.getForcedWidth() != Integer.MIN_VALUE)) {
            LayoutInformationReceiver layoutInformationReceiver2 = this.layoutInformationReceiver;
            Intrinsics.checkNotNull(layoutInformationReceiver2);
            int forcedWidth = layoutInformationReceiver2.getForcedWidth();
            if (forcedWidth > this.root.getWidth()) {
                this.forcedScaleFactor = this.root.getWidth() / forcedWidth;
            } else {
                this.forcedScaleFactor = 1.0f;
            }
            this.root.setWidth(forcedWidth);
        }
        LayoutInformationReceiver layoutInformationReceiver3 = this.layoutInformationReceiver;
        if (layoutInformationReceiver3 != null) {
            if (layoutInformationReceiver3 == null || layoutInformationReceiver3.getForcedHeight() != Integer.MIN_VALUE) {
                LayoutInformationReceiver layoutInformationReceiver4 = this.layoutInformationReceiver;
                Intrinsics.checkNotNull(layoutInformationReceiver4);
                int forcedHeight = layoutInformationReceiver4.getForcedHeight();
                if (Float.isNaN(this.forcedScaleFactor)) {
                    this.forcedScaleFactor = 1.0f;
                }
                float height = forcedHeight > this.root.getHeight() ? this.root.getHeight() / forcedHeight : 1.0f;
                if (height < this.forcedScaleFactor) {
                    this.forcedScaleFactor = height;
                }
                this.root.setHeight(forcedHeight);
            }
        }
    }

    public final void performLayout(Placeable.PlacementScope placementScope, List<? extends Measurable> list) {
        Measurable measurable;
        Placeable placeable;
        Placeable.PlacementScope placementScope2;
        int i = 0;
        if (this.frameCache.isEmpty()) {
            ArrayList<ConstraintWidget> children = this.root.getChildren();
            int size = children.size();
            for (int i2 = 0; i2 < size; i2++) {
                ConstraintWidget constraintWidget = children.get(i2);
                Object companionWidget = constraintWidget.getCompanionWidget();
                if (companionWidget instanceof Measurable) {
                    this.frameCache.put((Measurable) companionWidget, new WidgetFrame(constraintWidget.frame.update()));
                }
            }
        }
        int size2 = list.size();
        while (true) {
            Object obj = null;
            if (i >= size2) {
                LayoutInformationReceiver layoutInformationReceiver = this.layoutInformationReceiver;
                if ((layoutInformationReceiver != null ? layoutInformationReceiver.getLayoutInformationMode() : null) == LayoutInfoFlags.BOUNDS) {
                    computeLayoutResult();
                    return;
                }
                return;
            }
            Measurable measurable2 = list.get(i);
            if (this.frameCache.containsKey(measurable2)) {
                measurable = measurable2;
            } else {
                for (Object obj2 : this.frameCache.keySet()) {
                    Measurable measurable3 = (Measurable) obj2;
                    if (LayoutIdKt.getLayoutId(measurable3) != null && Intrinsics.areEqual(LayoutIdKt.getLayoutId(measurable3), LayoutIdKt.getLayoutId(measurable2))) {
                        obj = obj2;
                        break;
                    }
                }
                measurable = (Measurable) obj;
                if (measurable == null) {
                    placementScope2 = placementScope;
                }
                i++;
                placementScope = placementScope2;
            }
            WidgetFrame widgetFrame = this.frameCache.get(measurable);
            if (widgetFrame == null || (placeable = this.placeables.get(measurable)) == null) {
                return;
            }
            if (!this.frameCache.containsKey(measurable2)) {
                placementScope2 = placementScope;
                ConstraintLayoutKt.m10031placeWithFrameTransformKtjjmr4$default(placementScope2, measurable2.mo8265measureBRTryo0(Constraints.INSTANCE.m9650fixedJhjzzOo(placeable.getWidth(), placeable.getHeight())), widgetFrame, 0L, 4, null);
            } else {
                placementScope2 = placementScope;
                ConstraintLayoutKt.m10031placeWithFrameTransformKtjjmr4$default(placementScope2, placeable, widgetFrame, 0L, 4, null);
            }
            i++;
            placementScope = placementScope2;
        }
    }

    /* JADX INFO: renamed from: measureWidget-yQShABA, reason: not valid java name */
    private final long m10085measureWidgetyQShABA(ConstraintWidget constraintWidget, long constraints) {
        int i;
        Object companionWidget = constraintWidget.getCompanionWidget();
        String str = constraintWidget.stringId;
        int i2 = 0;
        if (constraintWidget instanceof VirtualLayout) {
            if (Constraints.m9638getHasFixedWidthimpl(constraints)) {
                i = 1073741824;
            } else {
                i = Constraints.m9636getHasBoundedWidthimpl(constraints) ? Integer.MIN_VALUE : 0;
            }
            if (Constraints.m9637getHasFixedHeightimpl(constraints)) {
                i2 = 1073741824;
            } else if (Constraints.m9635getHasBoundedHeightimpl(constraints)) {
                i2 = Integer.MIN_VALUE;
            }
            VirtualLayout virtualLayout = (VirtualLayout) constraintWidget;
            virtualLayout.measure(i, Constraints.m9640getMaxWidthimpl(constraints), i2, Constraints.m9639getMaxHeightimpl(constraints));
            return IntIntPair.m327constructorimpl(virtualLayout.getMeasuredWidth(), virtualLayout.getMeasuredHeight());
        }
        if (companionWidget instanceof Measurable) {
            Placeable placeableMo8265measureBRTryo0 = ((Measurable) companionWidget).mo8265measureBRTryo0(constraints);
            this.placeables.put((Measurable) companionWidget, placeableMo8265measureBRTryo0);
            return IntIntPair.m327constructorimpl(placeableMo8265measureBRTryo0.getWidth(), placeableMo8265measureBRTryo0.getHeight());
        }
        Log.w("CCL", "Nothing to measure for widget: " + str);
        return IntIntPair.m327constructorimpl(0, 0);
    }

    public final void drawDebugBounds(final BoxScope boxScope, final float f, Composer composer, final int i) {
        int i2;
        Composer composerStartRestartGroup = composer.startRestartGroup(2126574786);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(drawDebugBounds)2070@81916L38,2070@81870L84:ConstraintLayout.kt#fysre8");
        if ((i & 6) == 0) {
            i2 = (composerStartRestartGroup.changed(boxScope) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 48) == 0) {
            i2 |= composerStartRestartGroup.changed(f) ? 32 : 16;
        }
        if ((i & 384) == 0) {
            i2 |= composerStartRestartGroup.changedInstance(this) ? 256 : 128;
        }
        if ((i2 & Token.DOTQUERY) != 146 || !composerStartRestartGroup.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(2126574786, i2, -1, "androidx.constraintlayout.compose.Measurer.drawDebugBounds (ConstraintLayout.kt:2069)");
            }
            Modifier modifierMatchParentSize = boxScope.matchParentSize(Modifier.INSTANCE);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1991031410, "CC(remember):ConstraintLayout.kt#9igjgp");
            boolean zChangedInstance = ((i2 & 112) == 32) | composerStartRestartGroup.changedInstance(this);
            Object objRememberedValue = composerStartRestartGroup.rememberedValue();
            if (zChangedInstance || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                objRememberedValue = (Function1) new Function1<DrawScope, Unit>() { // from class: androidx.constraintlayout.compose.Measurer$drawDebugBounds$1$1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(DrawScope drawScope) {
                        invoke2(drawScope);
                        return Unit.INSTANCE;
                    }

                    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(DrawScope drawScope) {
                        this.this$0.drawDebugBounds(drawScope, f);
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
            }
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            CanvasKt.Canvas(modifierMatchParentSize, (Function1) objRememberedValue, composerStartRestartGroup, 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composerStartRestartGroup.skipToGroupEnd();
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.constraintlayout.compose.Measurer.drawDebugBounds.2
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                    invoke(composer2, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(Composer composer2, int i3) {
                    Measurer.this.drawDebugBounds(boxScope, f, composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1));
                }
            });
        }
    }

    public final void drawDebugBounds(DrawScope drawScope, float f) {
        float layoutCurrentWidth = getLayoutCurrentWidth() * f;
        float layoutCurrentHeight = getLayoutCurrentHeight() * f;
        float fM6638getWidthimpl = (Size.m6638getWidthimpl(drawScope.mo7395getSizeNHjbRc()) - layoutCurrentWidth) / 2.0f;
        float fM6635getHeightimpl = (Size.m6635getHeightimpl(drawScope.mo7395getSizeNHjbRc()) - layoutCurrentHeight) / 2.0f;
        long jM6851getWhite0d7_KjU = Color.INSTANCE.m6851getWhite0d7_KjU();
        float f2 = fM6638getWidthimpl + layoutCurrentWidth;
        DrawScope.m7381drawLineNGM6Ib0$default(drawScope, jM6851getWhite0d7_KjU, OffsetKt.Offset(fM6638getWidthimpl, fM6635getHeightimpl), OffsetKt.Offset(f2, fM6635getHeightimpl), 0.0f, 0, null, 0.0f, null, 0, 504, null);
        float f3 = fM6635getHeightimpl + layoutCurrentHeight;
        DrawScope.m7381drawLineNGM6Ib0$default(drawScope, jM6851getWhite0d7_KjU, OffsetKt.Offset(f2, fM6635getHeightimpl), OffsetKt.Offset(f2, f3), 0.0f, 0, null, 0.0f, null, 0, 504, null);
        DrawScope.m7381drawLineNGM6Ib0$default(drawScope, jM6851getWhite0d7_KjU, OffsetKt.Offset(f2, f3), OffsetKt.Offset(fM6638getWidthimpl, f3), 0.0f, 0, null, 0.0f, null, 0, 504, null);
        DrawScope.m7381drawLineNGM6Ib0$default(drawScope, jM6851getWhite0d7_KjU, OffsetKt.Offset(fM6638getWidthimpl, f3), OffsetKt.Offset(fM6638getWidthimpl, fM6635getHeightimpl), 0.0f, 0, null, 0.0f, null, 0, 504, null);
        float f4 = 1;
        float f5 = fM6638getWidthimpl + f4;
        float f6 = fM6635getHeightimpl + f4;
        long jM6840getBlack0d7_KjU = Color.INSTANCE.m6840getBlack0d7_KjU();
        float f7 = f5 + layoutCurrentWidth;
        DrawScope.m7381drawLineNGM6Ib0$default(drawScope, jM6840getBlack0d7_KjU, OffsetKt.Offset(f5, f6), OffsetKt.Offset(f7, f6), 0.0f, 0, null, 0.0f, null, 0, 504, null);
        float f8 = layoutCurrentHeight + f6;
        DrawScope.m7381drawLineNGM6Ib0$default(drawScope, jM6840getBlack0d7_KjU, OffsetKt.Offset(f7, f6), OffsetKt.Offset(f7, f8), 0.0f, 0, null, 0.0f, null, 0, 504, null);
        DrawScope.m7381drawLineNGM6Ib0$default(drawScope, jM6840getBlack0d7_KjU, OffsetKt.Offset(f7, f8), OffsetKt.Offset(f5, f8), 0.0f, 0, null, 0.0f, null, 0, 504, null);
        DrawScope.m7381drawLineNGM6Ib0$default(drawScope, jM6840getBlack0d7_KjU, OffsetKt.Offset(f5, f8), OffsetKt.Offset(f5, f6), 0.0f, 0, null, 0.0f, null, 0, 504, null);
    }

    /* JADX INFO: renamed from: getColor-wrIjXm8$default, reason: not valid java name */
    static /* synthetic */ long m10084getColorwrIjXm8$default(Measurer measurer, String str, long j, int i, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: getColor-wrIjXm8");
        }
        if ((i & 2) != 0) {
            j = Color.INSTANCE.m6840getBlack0d7_KjU();
        }
        return measurer.m10083getColorwrIjXm8(str, j);
    }

    /* JADX INFO: renamed from: getColor-wrIjXm8, reason: not valid java name */
    private final long m10083getColorwrIjXm8(String str, long defaultColor) {
        if (str != null && StringsKt.startsWith$default((CharSequence) str, ColorSerializer.PREFIX, false, 2, (Object) null)) {
            String strSubstring = str.substring(1);
            Intrinsics.checkNotNullExpressionValue(strSubstring, "this as java.lang.String).substring(startIndex)");
            if (strSubstring.length() == 6) {
                strSubstring = "FF" + strSubstring;
            }
            try {
                return ColorKt.Color((int) Long.parseLong(strSubstring, 16));
            } catch (Exception unused) {
            }
        }
        return defaultColor;
    }

    private final TextStyle getTextStyle(HashMap<String, String> params) {
        String str = params.get("size");
        long jM9892getUnspecifiedXSAIIZE = TextUnit.INSTANCE.m9892getUnspecifiedXSAIIZE();
        if (str != null) {
            jM9892getUnspecifiedXSAIIZE = TextUnitKt.getSp(Float.parseFloat(str));
        }
        return new TextStyle(m10084getColorwrIjXm8$default(this, params.get("color"), 0L, 2, null), jM9892getUnspecifiedXSAIIZE, (FontWeight) null, (FontStyle) null, (FontSynthesis) null, (FontFamily) null, (String) null, 0L, (BaselineShift) null, (TextGeometricTransform) null, (LocaleList) null, 0L, (TextDecoration) null, (Shadow) null, (DrawStyle) null, 0, 0, 0L, (TextIndent) null, (PlatformTextStyle) null, (LineHeightStyle) null, 0, 0, (TextMotion) null, 16777212, (DefaultConstructorMarker) null);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code duplicated, block: B:77:0x035e  */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r13v0 */
    /* JADX WARN: Type inference failed for: r13v1, types: [int] */
    /* JADX WARN: Type inference failed for: r13v8 */
    /* JADX WARN: Type inference failed for: r15v11 */
    /* JADX WARN: Type inference failed for: r15v12 */
    /* JADX WARN: Type inference failed for: r15v13 */
    /* JADX WARN: Type inference failed for: r15v2 */
    /* JADX WARN: Type inference failed for: r15v4 */
    /* JADX WARN: Type inference failed for: r15v5, types: [boolean] */
    /* JADX WARN: Type inference failed for: r15v6 */
    /* JADX WARN: Type inference failed for: r15v7 */
    /* JADX WARN: Type inference failed for: r25v0 */
    /* JADX WARN: Type inference failed for: r25v1 */
    /* JADX WARN: Type inference failed for: r25v10 */
    /* JADX WARN: Type inference failed for: r25v11 */
    /* JADX WARN: Type inference failed for: r25v12 */
    /* JADX WARN: Type inference failed for: r25v2 */
    /* JADX WARN: Type inference failed for: r25v3 */
    /* JADX WARN: Type inference failed for: r25v4 */
    /* JADX WARN: Type inference failed for: r25v5 */
    /* JADX WARN: Type inference failed for: r25v6 */
    /* JADX WARN: Type inference failed for: r25v7 */
    /* JADX WARN: Type inference failed for: r25v8 */
    /* JADX WARN: Type inference failed for: r25v9 */
    /* JADX WARN: Type inference failed for: r3v19 */
    public final void createDesignElements(Composer composer, final int i) {
        ?? r25;
        int i2;
        int i3;
        ?? r26;
        int i4;
        ?? r15;
        ?? r16;
        Composer composerStartRestartGroup = composer.startRestartGroup(1750959258);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(createDesignElements):ConstraintLayout.kt#fysre8");
        int i5 = (i & 6) == 0 ? (composerStartRestartGroup.changedInstance(this) ? 4 : 2) | i : i;
        if ((i5 & 3) == 2 && composerStartRestartGroup.getSkipping()) {
            composerStartRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1750959258, i5, -1, "androidx.constraintlayout.compose.Measurer.createDesignElements (ConstraintLayout.kt:2120)");
            }
            ArrayList<ConstraintSetParser.DesignElement> arrayList = this.designElements;
            int size = arrayList.size();
            ?? r13 = 0;
            int i6 = 0;
            while (i6 < size) {
                ConstraintSetParser.DesignElement designElement = arrayList.get(i6);
                String id = designElement.getId();
                Function4<String, HashMap<String, String>, Composer, Integer, Unit> function4 = DesignElements.INSTANCE.getMap().get(designElement.getType());
                if (function4 != null) {
                    composerStartRestartGroup.startReplaceGroup(-209368134);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "2125@84012L28");
                    function4.invoke(id, designElement.getParams(), composerStartRestartGroup, Integer.valueOf((int) r13));
                    composerStartRestartGroup.endReplaceGroup();
                    r26 = r13;
                    i2 = i6;
                    i3 = size;
                } else {
                    composerStartRestartGroup.startReplaceGroup(-209229285);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "");
                    String type = designElement.getType();
                    if (type != null) {
                        switch (type.hashCode()) {
                            case -1377687758:
                                ?? r27 = r13;
                                i2 = i6;
                                i3 = size;
                                r25 = r27;
                                if (!type.equals("button")) {
                                    composerStartRestartGroup.startReplaceGroup(-206910826);
                                    composerStartRestartGroup.endReplaceGroup();
                                    r26 = r25;
                                } else {
                                    composerStartRestartGroup.startReplaceGroup(-209212359);
                                    ComposerKt.sourceInformation(composerStartRestartGroup, "2132@84361L418");
                                    String str = designElement.getParams().get("text");
                                    BasicTextKt.m1612BasicTextVhcvRP8(str != null ? str : "text", PaddingKt.m1218padding3ABfNKs(BackgroundKt.m589backgroundbw27NRU$default(ClipKt.clip(LayoutIdKt.layoutId(Modifier.INSTANCE, id), RoundedCornerShapeKt.RoundedCornerShape(20)), m10083getColorwrIjXm8(designElement.getParams().get("backgroundColor"), Color.INSTANCE.m6846getLightGray0d7_KjU()), null, 2, null), Dp.m9687constructorimpl(8)), getTextStyle(designElement.getParams()), (Function1) null, 0, false, 0, 0, (ColorProducer) null, composerStartRestartGroup, 0, 504);
                                    composerStartRestartGroup.endReplaceGroup();
                                    r26 = r27;
                                }
                                break;
                            case -1031434259:
                                i2 = i6;
                                i4 = size;
                                ?? r17 = r13;
                                r15 = r17;
                                if (!type.equals("textfield")) {
                                    i3 = i4;
                                    r25 = r15;
                                    composerStartRestartGroup.startReplaceGroup(-206910826);
                                    composerStartRestartGroup.endReplaceGroup();
                                    r26 = r25;
                                } else {
                                    composerStartRestartGroup.startReplaceGroup(-207560958);
                                    ComposerKt.sourceInformation(composerStartRestartGroup, "2164@85902L192");
                                    String str2 = designElement.getParams().get("text");
                                    if (str2 == null) {
                                        str2 = "text";
                                    }
                                    Modifier modifierLayoutId = LayoutIdKt.layoutId(Modifier.INSTANCE, id);
                                    Measurer$createDesignElements$1$2 measurer$createDesignElements$1$2 = new Function1<String, Unit>() { // from class: androidx.constraintlayout.compose.Measurer$createDesignElements$1$2
                                        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                                        public final void invoke2(String str3) {
                                        }

                                        @Override // kotlin.jvm.functions.Function1
                                        public /* bridge */ /* synthetic */ Unit invoke(String str3) {
                                            invoke2(str3);
                                            return Unit.INSTANCE;
                                        }
                                    };
                                    Composer composer2 = composerStartRestartGroup;
                                    r26 = r17 == true ? 1 : 0;
                                    i3 = i4;
                                    BasicTextFieldKt.BasicTextField(str2, (Function1<? super String, Unit>) measurer$createDesignElements$1$2, modifierLayoutId, false, false, (TextStyle) null, (KeyboardOptions) null, (KeyboardActions) null, false, 0, 0, (VisualTransformation) null, (Function1<? super TextLayoutResult, Unit>) null, (MutableInteractionSource) null, (Brush) null, (Function3<? super Function2<? super Composer, ? super Integer, Unit>, ? super Composer, ? super Integer, Unit>) null, composer2, 48, 0, 65528);
                                    composerStartRestartGroup = composer2;
                                    composerStartRestartGroup.endReplaceGroup();
                                }
                                break;
                            case 97739:
                                i2 = i6;
                                i4 = size;
                                ?? r18 = r13;
                                r15 = r18;
                                if (type.equals(WopiService.BOX)) {
                                    composerStartRestartGroup.startReplaceGroup(-208521400);
                                    ComposerKt.sourceInformation(composerStartRestartGroup, "2146@85056L343");
                                    String str3 = designElement.getParams().get("text");
                                    String str4 = str3 != null ? str3 : "";
                                    Modifier modifierM589backgroundbw27NRU$default = BackgroundKt.m589backgroundbw27NRU$default(LayoutIdKt.layoutId(Modifier.INSTANCE, id), m10083getColorwrIjXm8(designElement.getParams().get("backgroundColor"), Color.INSTANCE.m6846getLightGray0d7_KjU()), null, 2, null);
                                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 733328855, "CC(Box)P(2,1,3)72@3384L130:Box.kt#2w3rfo");
                                    MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), r18);
                                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1323940314, "CC(Layout)P(!1,2)79@3208L23,82@3359L411:Layout.kt#80mrfh");
                                    int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, r18 == true ? 1 : 0);
                                    CompositionLocalMap currentCompositionLocalMap = composerStartRestartGroup.getCurrentCompositionLocalMap();
                                    Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierM589backgroundbw27NRU$default);
                                    Function0<ComposeUiNode> constructor = ComposeUiNode.INSTANCE.getConstructor();
                                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -692256719, "CC(ReusableComposeNode)P(1,2)376@14062L9:Composables.kt#9igjgp");
                                    if (!(composerStartRestartGroup.getApplier() instanceof Applier)) {
                                        ComposablesKt.invalidApplier();
                                    }
                                    composerStartRestartGroup.startReusableNode();
                                    if (composerStartRestartGroup.getInserting()) {
                                        composerStartRestartGroup.createNode(constructor);
                                    } else {
                                        composerStartRestartGroup.useNode();
                                    }
                                    Composer composerM6062constructorimpl = Updater.m6062constructorimpl(composerStartRestartGroup);
                                    Updater.m6070setimpl(composerM6062constructorimpl, measurePolicyMaybeCachedBoxMeasurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                                    Updater.m6070setimpl(composerM6062constructorimpl, currentCompositionLocalMap, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                                    Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                                    if (composerM6062constructorimpl.getInserting() || !Intrinsics.areEqual(composerM6062constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                                        composerM6062constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                                        composerM6062constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                                    }
                                    Updater.m6070setimpl(composerM6062constructorimpl, modifierMaterializeModifier, ComposeUiNode.INSTANCE.getSetModifier());
                                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -2146769399, "C73@3429L9:Box.kt#2w3rfo");
                                    BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
                                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1239419301, "C2147@85152L221:ConstraintLayout.kt#fysre8");
                                    BasicTextKt.m1612BasicTextVhcvRP8(str4, PaddingKt.m1218padding3ABfNKs(Modifier.INSTANCE, Dp.m9687constructorimpl(8)), getTextStyle(designElement.getParams()), (Function1) null, 0, false, 0, 0, (ColorProducer) null, composerStartRestartGroup, 48, 504);
                                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                                    composerStartRestartGroup.endNode();
                                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                                    composerStartRestartGroup.endReplaceGroup();
                                    r16 = r18;
                                    i3 = i4;
                                    r26 = r16;
                                }
                                i3 = i4;
                                r25 = r15;
                                composerStartRestartGroup.startReplaceGroup(-206910826);
                                composerStartRestartGroup.endReplaceGroup();
                                r26 = r25;
                                break;
                            case 3556653:
                                if (type.equals("text")) {
                                    composerStartRestartGroup.startReplaceGroup(-207913738);
                                    ComposerKt.sourceInformation(composerStartRestartGroup, "2156@85546L204");
                                    String str5 = designElement.getParams().get("text");
                                    String str6 = str5 != null ? str5 : "text";
                                    Modifier modifierLayoutId2 = LayoutIdKt.layoutId(Modifier.INSTANCE, id);
                                    TextStyle textStyle = getTextStyle(designElement.getParams());
                                    i4 = size;
                                    r16 = r13 == true ? 1 : 0;
                                    i2 = i6;
                                    BasicTextKt.m1612BasicTextVhcvRP8(str6, modifierLayoutId2, textStyle, (Function1) null, 0, false, 0, 0, (ColorProducer) null, composerStartRestartGroup, 0, 504);
                                    composerStartRestartGroup.endReplaceGroup();
                                    i3 = i4;
                                    r26 = r16;
                                }
                                r25 = r13;
                                i2 = i6;
                                i3 = size;
                                composerStartRestartGroup.startReplaceGroup(-206910826);
                                composerStartRestartGroup.endReplaceGroup();
                                r26 = r25;
                                break;
                            case 100313435:
                                if (!type.equals("image")) {
                                    r25 = r13;
                                    i2 = i6;
                                    i3 = size;
                                    composerStartRestartGroup.startReplaceGroup(-206910826);
                                    composerStartRestartGroup.endReplaceGroup();
                                    r26 = r25;
                                } else {
                                    composerStartRestartGroup.startReplaceGroup(-207223709);
                                    ComposerKt.sourceInformation(composerStartRestartGroup, "2173@86281L56,2171@86174L259");
                                    Composer composer3 = composerStartRestartGroup;
                                    ImageKt.Image(PainterResources_androidKt.painterResource(android.R.drawable.ic_menu_gallery, composerStartRestartGroup, 6), "Placeholder Image", LayoutIdKt.layoutId(Modifier.INSTANCE, id), (Alignment) null, (ContentScale) null, 0.0f, (ColorFilter) null, composer3, 48, 120);
                                    composerStartRestartGroup = composer3;
                                    composerStartRestartGroup.endReplaceGroup();
                                    r26 = r13;
                                    i2 = i6;
                                    i3 = size;
                                }
                                break;
                            default:
                                r25 = r13;
                                i2 = i6;
                                i3 = size;
                                composerStartRestartGroup.startReplaceGroup(-206910826);
                                composerStartRestartGroup.endReplaceGroup();
                                r26 = r25;
                                break;
                        }
                    } else {
                        r25 = r13;
                        i2 = i6;
                        i3 = size;
                        composerStartRestartGroup.startReplaceGroup(-206910826);
                        composerStartRestartGroup.endReplaceGroup();
                        r26 = r25;
                    }
                    composerStartRestartGroup.endReplaceGroup();
                }
                i6 = i2 + 1;
                size = i3;
                r13 = r26;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.constraintlayout.compose.Measurer.createDesignElements.2
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Composer composer4, Integer num) {
                    invoke(composer4, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(Composer composer4, int i7) {
                    Measurer.this.createDesignElements(composer4, RecomposeScopeImplKt.updateChangedFlags(i | 1));
                }
            });
        }
    }

    public final void parseDesignElements(ConstraintSet constraintSet) {
        if (constraintSet instanceof JSONConstraintSet) {
            ((JSONConstraintSet) constraintSet).emitDesignElements(this.designElements);
        }
    }
}
