package dev.chrisbanes.haze;

import androidx.compose.runtime.snapshots.Snapshot;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.geometry.InlineClassHelperKt;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.OffsetKt;
import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.geometry.RectKt;
import androidx.compose.ui.geometry.Size;
import androidx.compose.ui.geometry.SizeKt;
import androidx.compose.ui.graphics.AndroidPaint_androidKt;
import androidx.compose.ui.graphics.Brush;
import androidx.compose.ui.graphics.Canvas;
import androidx.compose.ui.graphics.ClipOp;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.ColorFilter;
import androidx.compose.ui.graphics.GraphicsContext;
import androidx.compose.ui.graphics.Paint;
import androidx.compose.ui.graphics.RenderEffect;
import androidx.compose.ui.graphics.drawscope.ContentDrawScope;
import androidx.compose.ui.graphics.drawscope.DrawContext;
import androidx.compose.ui.graphics.drawscope.DrawScope;
import androidx.compose.ui.graphics.layer.GraphicsLayer;
import androidx.compose.ui.graphics.layer.GraphicsLayerKt;
import androidx.compose.ui.layout.LayoutCoordinates;
import androidx.compose.ui.modifier.ModifierLocalModifierNode;
import androidx.compose.ui.node.CompositionLocalConsumerModifierNode;
import androidx.compose.ui.node.CompositionLocalConsumerModifierNodeKt;
import androidx.compose.ui.node.DrawModifierNode;
import androidx.compose.ui.node.DrawModifierNodeKt;
import androidx.compose.ui.node.GlobalPositionAwareModifierNode;
import androidx.compose.ui.node.LayoutAwareModifierNode;
import androidx.compose.ui.node.ObserverModifierNode;
import androidx.compose.ui.node.ObserverModifierNodeKt;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.IntSize;
import androidx.compose.ui.unit.IntSizeKt;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.comparisons.ComparisonsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlin.sequences.SequencesKt;

/* JADX INFO: compiled from: HazeEffectNode.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000Ö\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0013\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0007\u0018\u0000 \u0092\u00012\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u00042\u00020\u00052\u00020\u00062\u00020\u00072\u00020\b:\u0002\u0092\u0001B6\u0012\u0006\u0010\t\u001a\u00020\n\u0012\b\b\u0002\u0010\u000b\u001a\u00020\f\u0012\u001b\b\u0002\u0010\r\u001a\u0015\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u000e¢\u0006\u0002\b\u0010¢\u0006\u0004\b\u0011\u0010\u0012J\u001c\u0010{\u001a\u00020\u000f2\b\u0010|\u001a\u0004\u0018\u00010\f2\b\u0010}\u001a\u0004\u0018\u00010\fH\u0002J\r\u0010~\u001a\u00020\u000fH\u0000¢\u0006\u0002\b\u007fJ\t\u0010\u0080\u0001\u001a\u00020\u000fH\u0016J\t\u0010\u0081\u0001\u001a\u00020\u000fH\u0016J\u0013\u0010\u0082\u0001\u001a\u00020\u000f2\b\u0010\u0083\u0001\u001a\u00030\u0084\u0001H\u0016J\u0013\u0010\u0085\u0001\u001a\u00020\u000f2\b\u0010\u0083\u0001\u001a\u00030\u0084\u0001H\u0016J\u001d\u0010\u0086\u0001\u001a\u00020\u000f2\b\u0010\u0083\u0001\u001a\u00030\u0084\u00012\b\u0010\u0087\u0001\u001a\u00030\u0088\u0001H\u0002J\u000e\u0010\u0089\u0001\u001a\u00020\u000f*\u00030\u008a\u0001H\u0016J\t\u0010\u008b\u0001\u001a\u00020\u000fH\u0002J\u000e\u0010\u008c\u0001\u001a\u00020\u000f*\u00030\u008d\u0001H\u0002J\u000e\u0010\u008e\u0001\u001a\u00020\u000f*\u00030\u008d\u0001H\u0002J\t\u0010\u008f\u0001\u001a\u00020\u000fH\u0002J\t\u0010\u0090\u0001\u001a\u00020\u000fH\u0002J\t\u0010\u0091\u0001\u001a\u00020\u000fH\u0002R\u001a\u0010\t\u001a\u00020\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R-\u0010\r\u001a\u0015\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u000e¢\u0006\u0002\b\u0010X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR\u0014\u0010\u001b\u001a\u00020\u001cX\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001eR\u001b\u0010\u001f\u001a\u00020 8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b#\u0010$\u001a\u0004\b!\u0010\"R\u0010\u0010%\u001a\u0004\u0018\u00010&X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010'\u001a\u00020(X\u0082\u000e¢\u0006\u0004\n\u0002\u0010)R$\u0010+\u001a\u00020\u001c2\u0006\u0010*\u001a\u00020\u001c@VX\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b,\u0010\u001e\"\u0004\b-\u0010.R$\u00100\u001a\u00020/2\u0006\u0010*\u001a\u00020/@VX\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b1\u00102\"\u0004\b3\u00104R$\u00105\u001a\u00020\f2\u0006\u0010*\u001a\u00020\f@@X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b6\u00107\"\u0004\b8\u00109R$\u0010\u000b\u001a\u00020\f2\u0006\u0010*\u001a\u00020\f@VX\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b:\u00107\"\u0004\b;\u00109R \u0010=\u001a\u00020<2\u0006\u0010*\u001a\u00020<@BX\u0082\u000e¢\u0006\n\n\u0002\u0010@\"\u0004\b>\u0010?R6\u0010C\u001a\u000e\u0012\u0004\u0012\u00020B\u0012\u0004\u0012\u00020<0A2\u0012\u0010*\u001a\u000e\u0012\u0004\u0012\u00020B\u0012\u0004\u0012\u00020<0A@BX\u0082\u000e¢\u0006\b\n\u0000\"\u0004\bD\u0010ER\u0014\u0010F\u001a\u00020\u001c8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\bF\u0010\u001eR&\u0010H\u001a\u00020G2\u0006\u0010*\u001a\u00020G@@X\u0080\u000e¢\u0006\u0010\n\u0002\u0010@\u001a\u0004\bI\u0010J\"\u0004\bK\u0010?R&\u0010M\u001a\u00020L2\u0006\u0010*\u001a\u00020L@VX\u0096\u000e¢\u0006\u0010\n\u0002\u0010R\u001a\u0004\bN\u0010O\"\u0004\bP\u0010QR$\u0010T\u001a\u00020S2\u0006\u0010*\u001a\u00020S@VX\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bU\u0010O\"\u0004\bV\u0010QR(\u0010X\u001a\u0004\u0018\u00010W2\b\u0010*\u001a\u0004\u0018\u00010W@VX\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bY\u0010Z\"\u0004\b[\u0010\\R&\u0010^\u001a\u00020]2\u0006\u0010*\u001a\u00020]@VX\u0096\u000e¢\u0006\u0010\n\u0002\u0010@\u001a\u0004\b_\u0010J\"\u0004\b`\u0010?R0\u0010c\u001a\b\u0012\u0004\u0012\u00020b0a2\f\u0010*\u001a\b\u0012\u0004\u0012\u00020b0a@VX\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bd\u0010e\"\u0004\bf\u0010gR$\u0010h\u001a\u00020b2\u0006\u0010*\u001a\u00020b@VX\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bi\u0010j\"\u0004\bk\u0010lR$\u0010m\u001a\u00020S2\u0006\u0010*\u001a\u00020S@VX\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bn\u0010O\"\u0004\bo\u0010QR(\u0010q\u001a\u0004\u0018\u00010p2\b\u0010*\u001a\u0004\u0018\u00010p@VX\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\br\u0010s\"\u0004\bt\u0010uR*\u0010v\u001a\b\u0012\u0004\u0012\u00020B0a2\f\u0010*\u001a\b\u0012\u0004\u0012\u00020B0a@BX\u0082\u000e¢\u0006\b\n\u0000\"\u0004\bw\u0010gR@\u0010x\u001a\u0010\u0012\u0004\u0012\u00020B\u0012\u0004\u0012\u00020\u001c\u0018\u00010\u000e2\u0014\u0010*\u001a\u0010\u0012\u0004\u0012\u00020B\u0012\u0004\u0012\u00020\u001c\u0018\u00010\u000e@VX\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\by\u0010\u0018\"\u0004\bz\u0010\u001a¨\u0006\u0093\u0001"}, d2 = {"Ldev/chrisbanes/haze/HazeEffectNode;", "Landroidx/compose/ui/Modifier$Node;", "Landroidx/compose/ui/node/CompositionLocalConsumerModifierNode;", "Landroidx/compose/ui/node/GlobalPositionAwareModifierNode;", "Landroidx/compose/ui/node/LayoutAwareModifierNode;", "Landroidx/compose/ui/node/ObserverModifierNode;", "Landroidx/compose/ui/node/DrawModifierNode;", "Landroidx/compose/ui/modifier/ModifierLocalModifierNode;", "Ldev/chrisbanes/haze/HazeEffectScope;", "state", "Ldev/chrisbanes/haze/HazeState;", "style", "Ldev/chrisbanes/haze/HazeStyle;", "block", "Lkotlin/Function1;", "", "Lkotlin/ExtensionFunctionType;", "<init>", "(Ldev/chrisbanes/haze/HazeState;Ldev/chrisbanes/haze/HazeStyle;Lkotlin/jvm/functions/Function1;)V", "getState", "()Ldev/chrisbanes/haze/HazeState;", "setState", "(Ldev/chrisbanes/haze/HazeState;)V", "getBlock", "()Lkotlin/jvm/functions/Function1;", "setBlock", "(Lkotlin/jvm/functions/Function1;)V", "shouldAutoInvalidate", "", "getShouldAutoInvalidate", "()Z", "paint", "Landroidx/compose/ui/graphics/Paint;", "getPaint", "()Landroidx/compose/ui/graphics/Paint;", "paint$delegate", "Lkotlin/Lazy;", "renderEffect", "Landroidx/compose/ui/graphics/RenderEffect;", "dirtyTracker", "Ldev/chrisbanes/haze/Bitmask;", "I", "value", "blurEnabled", "getBlurEnabled", "setBlurEnabled", "(Z)V", "Ldev/chrisbanes/haze/HazeInputScale;", "inputScale", "getInputScale", "()Ldev/chrisbanes/haze/HazeInputScale;", "setInputScale", "(Ldev/chrisbanes/haze/HazeInputScale;)V", "compositionLocalStyle", "getCompositionLocalStyle$haze_release", "()Ldev/chrisbanes/haze/HazeStyle;", "setCompositionLocalStyle$haze_release", "(Ldev/chrisbanes/haze/HazeStyle;)V", "getStyle", "setStyle", "Landroidx/compose/ui/geometry/Offset;", "positionOnScreen", "setPositionOnScreen-k-4lQ0M", "(J)V", "J", "", "Ldev/chrisbanes/haze/HazeArea;", "areaOffsets", "setAreaOffsets", "(Ljava/util/Map;)V", "isValid", "Landroidx/compose/ui/geometry/Size;", "size", "getSize-NH-jbRc$haze_release", "()J", "setSize-uvyYCjk$haze_release", "Landroidx/compose/ui/unit/Dp;", "blurRadius", "getBlurRadius-D9Ej5fM", "()F", "setBlurRadius-0680j_4", "(F)V", "F", "", "noiseFactor", "getNoiseFactor", "setNoiseFactor", "Landroidx/compose/ui/graphics/Brush;", "mask", "getMask", "()Landroidx/compose/ui/graphics/Brush;", "setMask", "(Landroidx/compose/ui/graphics/Brush;)V", "Landroidx/compose/ui/graphics/Color;", "backgroundColor", "getBackgroundColor-0d7_KjU", "setBackgroundColor-8_81llA", "", "Ldev/chrisbanes/haze/HazeTint;", "tints", "getTints", "()Ljava/util/List;", "setTints", "(Ljava/util/List;)V", "fallbackTint", "getFallbackTint", "()Ldev/chrisbanes/haze/HazeTint;", "setFallbackTint", "(Ldev/chrisbanes/haze/HazeTint;)V", "alpha", "getAlpha", "setAlpha", "Ldev/chrisbanes/haze/HazeProgressive;", "progressive", "getProgressive", "()Ldev/chrisbanes/haze/HazeProgressive;", "setProgressive", "(Ldev/chrisbanes/haze/HazeProgressive;)V", "areas", "setAreas", "canDrawArea", "getCanDrawArea", "setCanDrawArea", "onStyleChanged", "old", "new", "update", "update$haze_release", "onAttach", "onObservedReadsChanged", "onPlaced", "coordinates", "Landroidx/compose/ui/layout/LayoutCoordinates;", "onGloballyPositioned", "onPositioned", "source", "", "draw", "Landroidx/compose/ui/graphics/drawscope/ContentDrawScope;", "updateEffect", "drawEffectWithGraphicsLayer", "Landroidx/compose/ui/graphics/drawscope/DrawScope;", "drawEffectWithScrim", "updateRenderEffectIfDirty", "onPostDraw", "invalidateIfNeeded", "Companion", "haze_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
@ExperimentalHazeApi
public final class HazeEffectNode extends Modifier.Node implements CompositionLocalConsumerModifierNode, GlobalPositionAwareModifierNode, LayoutAwareModifierNode, ObserverModifierNode, DrawModifierNode, ModifierLocalModifierNode, HazeEffectScope {
    public static final String TAG = "HazeEffect";
    private float alpha;
    private Map<HazeArea, Offset> areaOffsets;
    private List<HazeArea> areas;
    private long backgroundColor;
    private Function1<? super HazeEffectScope, Unit> block;
    private boolean blurEnabled;
    private float blurRadius;
    private Function1<? super HazeArea, Boolean> canDrawArea;
    private HazeStyle compositionLocalStyle;
    private int dirtyTracker;
    private HazeTint fallbackTint;
    private HazeInputScale inputScale;
    private Brush mask;
    private float noiseFactor;

    /* JADX INFO: renamed from: paint$delegate, reason: from kotlin metadata */
    private final Lazy paint;
    private long positionOnScreen;
    private HazeProgressive progressive;
    private RenderEffect renderEffect;
    private final boolean shouldAutoInvalidate;
    private long size;
    private HazeState state;
    private HazeStyle style;
    private List<HazeTint> tints;
    public static final int $stable = 8;

    public final HazeState getState() {
        return this.state;
    }

    public final void setState(HazeState hazeState) {
        Intrinsics.checkNotNullParameter(hazeState, "<set-?>");
        this.state = hazeState;
    }

    public /* synthetic */ HazeEffectNode(HazeState hazeState, HazeStyle hazeStyle, Function1 function1, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(hazeState, (i & 2) != 0 ? HazeStyle.INSTANCE.getUnspecified() : hazeStyle, (i & 4) != 0 ? null : function1);
    }

    public final Function1<HazeEffectScope, Unit> getBlock() {
        return this.block;
    }

    public final void setBlock(Function1<? super HazeEffectScope, Unit> function1) {
        this.block = function1;
    }

    public HazeEffectNode(HazeState state, HazeStyle style, Function1<? super HazeEffectScope, Unit> function1) {
        Intrinsics.checkNotNullParameter(state, "state");
        Intrinsics.checkNotNullParameter(style, "style");
        this.state = state;
        this.block = function1;
        this.paint = LazyKt.lazy(LazyThreadSafetyMode.NONE, new Function0() { // from class: dev.chrisbanes.haze.HazeEffectNode$$ExternalSyntheticLambda1
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return AndroidPaint_androidKt.Paint();
            }
        });
        this.dirtyTracker = Bitmask.m14434constructorimpl$default(0, 1, null);
        this.blurEnabled = HazeDefaults.INSTANCE.blurEnabled();
        this.inputScale = HazeInputScale.INSTANCE.getDefault();
        this.compositionLocalStyle = HazeStyle.INSTANCE.getUnspecified();
        this.style = style;
        this.positionOnScreen = Offset.INSTANCE.m6584getUnspecifiedF1C5BW0();
        this.areaOffsets = MapsKt.emptyMap();
        this.size = Size.INSTANCE.m6646getUnspecifiedNHjbRc();
        this.blurRadius = Dp.INSTANCE.m9707getUnspecifiedD9Ej5fM();
        this.noiseFactor = -1.0f;
        this.backgroundColor = Color.INSTANCE.m6850getUnspecified0d7_KjU();
        this.tints = CollectionsKt.emptyList();
        this.fallbackTint = HazeTint.INSTANCE.getUnspecified();
        this.alpha = 1.0f;
        this.areas = CollectionsKt.emptyList();
    }

    @Override // androidx.compose.ui.Modifier.Node
    public boolean getShouldAutoInvalidate() {
        return this.shouldAutoInvalidate;
    }

    private final Paint getPaint() {
        return (Paint) this.paint.getValue();
    }

    @Override // dev.chrisbanes.haze.HazeEffectScope
    public boolean getBlurEnabled() {
        return this.blurEnabled;
    }

    @Override // dev.chrisbanes.haze.HazeEffectScope
    public void setBlurEnabled(final boolean z) {
        if (z != this.blurEnabled) {
            Log_androidKt.log(TAG, new Function0() { // from class: dev.chrisbanes.haze.HazeEffectNode$$ExternalSyntheticLambda14
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    return HazeEffectNode._set_blurEnabled_$lambda$1(this.f$0, z);
                }
            });
            this.blurEnabled = z;
            this.dirtyTracker = Bitmask.m14441plusHWHKK88(this.dirtyTracker, 1);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String _set_blurEnabled_$lambda$1(HazeEffectNode hazeEffectNode, boolean z) {
        return "blurEnabled changed. Current: " + hazeEffectNode.blurEnabled + ". New: " + z;
    }

    @Override // dev.chrisbanes.haze.HazeEffectScope
    public HazeInputScale getInputScale() {
        return this.inputScale;
    }

    @Override // dev.chrisbanes.haze.HazeEffectScope
    public void setInputScale(final HazeInputScale value) {
        Intrinsics.checkNotNullParameter(value, "value");
        if (Intrinsics.areEqual(value, this.inputScale)) {
            return;
        }
        Log_androidKt.log(TAG, new Function0() { // from class: dev.chrisbanes.haze.HazeEffectNode$$ExternalSyntheticLambda2
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return HazeEffectNode._set_inputScale_$lambda$2(this.f$0, value);
            }
        });
        this.inputScale = value;
        this.dirtyTracker = Bitmask.m14441plusHWHKK88(this.dirtyTracker, 2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String _set_inputScale_$lambda$2(HazeEffectNode hazeEffectNode, HazeInputScale hazeInputScale) {
        return "inputScale changed. Current: " + hazeEffectNode.inputScale + ". New: " + hazeInputScale;
    }

    /* JADX INFO: renamed from: getCompositionLocalStyle$haze_release, reason: from getter */
    public final HazeStyle getCompositionLocalStyle() {
        return this.compositionLocalStyle;
    }

    public final void setCompositionLocalStyle$haze_release(final HazeStyle value) {
        Intrinsics.checkNotNullParameter(value, "value");
        if (Intrinsics.areEqual(this.compositionLocalStyle, value)) {
            return;
        }
        Log_androidKt.log(TAG, new Function0() { // from class: dev.chrisbanes.haze.HazeEffectNode$$ExternalSyntheticLambda4
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return HazeEffectNode._set_compositionLocalStyle_$lambda$3(this.f$0, value);
            }
        });
        onStyleChanged(this.compositionLocalStyle, value);
        this.compositionLocalStyle = value;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String _set_compositionLocalStyle_$lambda$3(HazeEffectNode hazeEffectNode, HazeStyle hazeStyle) {
        return "LocalHazeStyle changed. Current: " + hazeEffectNode.compositionLocalStyle + ". New: " + hazeStyle;
    }

    @Override // dev.chrisbanes.haze.HazeEffectScope
    public HazeStyle getStyle() {
        return this.style;
    }

    @Override // dev.chrisbanes.haze.HazeEffectScope
    public void setStyle(final HazeStyle value) {
        Intrinsics.checkNotNullParameter(value, "value");
        if (Intrinsics.areEqual(this.style, value)) {
            return;
        }
        Log_androidKt.log(TAG, new Function0() { // from class: dev.chrisbanes.haze.HazeEffectNode$$ExternalSyntheticLambda12
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return HazeEffectNode._set_style_$lambda$4(this.f$0, value);
            }
        });
        onStyleChanged(this.style, value);
        this.style = value;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String _set_style_$lambda$4(HazeEffectNode hazeEffectNode, HazeStyle hazeStyle) {
        return "style changed. Current: " + hazeEffectNode.style + ". New: " + hazeStyle;
    }

    /* JADX INFO: renamed from: setPositionOnScreen-k-4lQ0M, reason: not valid java name */
    private final void m14462setPositionOnScreenk4lQ0M(final long j) {
        if (Offset.m6566equalsimpl0(j, this.positionOnScreen)) {
            return;
        }
        Log_androidKt.log(TAG, new Function0() { // from class: dev.chrisbanes.haze.HazeEffectNode$$ExternalSyntheticLambda28
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return HazeEffectNode.setPositionOnScreen_k_4lQ0M$lambda$5(this.f$0, j);
            }
        });
        this.dirtyTracker = Bitmask.m14441plusHWHKK88(this.dirtyTracker, 4);
        this.positionOnScreen = j;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String setPositionOnScreen_k_4lQ0M$lambda$5(HazeEffectNode hazeEffectNode, long j) {
        return "positionOnScreen changed. Current: " + Offset.m6577toStringimpl(hazeEffectNode.positionOnScreen) + ". New: " + Offset.m6577toStringimpl(j);
    }

    private final void setAreaOffsets(final Map<HazeArea, Offset> map) {
        if (Intrinsics.areEqual(map, this.areaOffsets)) {
            return;
        }
        Log_androidKt.log(TAG, new Function0() { // from class: dev.chrisbanes.haze.HazeEffectNode$$ExternalSyntheticLambda11
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return HazeEffectNode._set_areaOffsets_$lambda$6(this.f$0, map);
            }
        });
        this.dirtyTracker = Bitmask.m14441plusHWHKK88(this.dirtyTracker, 8);
        this.areaOffsets = map;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String _set_areaOffsets_$lambda$6(HazeEffectNode hazeEffectNode, Map map) {
        return "areaOffsets changed. Current: " + hazeEffectNode.areaOffsets + ". New: " + map;
    }

    private final boolean isValid() {
        return (this.size == InlineClassHelperKt.UnspecifiedPackedFloats || !OffsetKt.m6588isSpecifiedk4lQ0M(this.positionOnScreen) || this.areas.isEmpty()) ? false : true;
    }

    /* JADX INFO: renamed from: getSize-NH-jbRc$haze_release, reason: not valid java name and from getter */
    public final long getSize() {
        return this.size;
    }

    /* JADX INFO: renamed from: setSize-uvyYCjk$haze_release, reason: not valid java name */
    public final void m14468setSizeuvyYCjk$haze_release(final long j) {
        if (Size.m6634equalsimpl0(j, this.size)) {
            return;
        }
        Log_androidKt.log(TAG, new Function0() { // from class: dev.chrisbanes.haze.HazeEffectNode$$ExternalSyntheticLambda15
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return HazeEffectNode.setSize_uvyYCjk$lambda$7(this.f$0, j);
            }
        });
        this.dirtyTracker = Bitmask.m14441plusHWHKK88(this.dirtyTracker, 16);
        this.size = j;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String setSize_uvyYCjk$lambda$7(HazeEffectNode hazeEffectNode, long j) {
        return "size changed. Current: " + Size.m6642toStringimpl(hazeEffectNode.size) + ". New: " + Size.m6642toStringimpl(j);
    }

    @Override // dev.chrisbanes.haze.HazeEffectScope
    /* JADX INFO: renamed from: getBlurRadius-D9Ej5fM, reason: not valid java name and from getter */
    public float getBlurRadius() {
        return this.blurRadius;
    }

    @Override // dev.chrisbanes.haze.HazeEffectScope
    /* JADX INFO: renamed from: setBlurRadius-0680j_4, reason: not valid java name */
    public void mo14467setBlurRadius0680j_4(final float f) {
        if (Dp.m9692equalsimpl0(f, this.blurRadius)) {
            return;
        }
        Log_androidKt.log(TAG, new Function0() { // from class: dev.chrisbanes.haze.HazeEffectNode$$ExternalSyntheticLambda7
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return HazeEffectNode.setBlurRadius_0680j_4$lambda$8(this.f$0, f);
            }
        });
        this.dirtyTracker = Bitmask.m14441plusHWHKK88(this.dirtyTracker, 32);
        this.blurRadius = f;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String setBlurRadius_0680j_4$lambda$8(HazeEffectNode hazeEffectNode, float f) {
        return "blurRadius changed. Current: " + Dp.m9698toStringimpl(hazeEffectNode.blurRadius) + ". New: " + Dp.m9698toStringimpl(f);
    }

    @Override // dev.chrisbanes.haze.HazeEffectScope
    public float getNoiseFactor() {
        return this.noiseFactor;
    }

    @Override // dev.chrisbanes.haze.HazeEffectScope
    public void setNoiseFactor(final float f) {
        if (f == this.noiseFactor) {
            return;
        }
        Log_androidKt.log(TAG, new Function0() { // from class: dev.chrisbanes.haze.HazeEffectNode$$ExternalSyntheticLambda3
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return HazeEffectNode._set_noiseFactor_$lambda$9(this.f$0, f);
            }
        });
        this.dirtyTracker = Bitmask.m14441plusHWHKK88(this.dirtyTracker, 64);
        this.noiseFactor = f;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String _set_noiseFactor_$lambda$9(HazeEffectNode hazeEffectNode, float f) {
        return "noiseFactor changed. Current: " + hazeEffectNode.noiseFactor + ". New: " + f;
    }

    @Override // dev.chrisbanes.haze.HazeEffectScope
    public Brush getMask() {
        return this.mask;
    }

    @Override // dev.chrisbanes.haze.HazeEffectScope
    public void setMask(final Brush brush) {
        if (Intrinsics.areEqual(brush, this.mask)) {
            return;
        }
        Log_androidKt.log(TAG, new Function0() { // from class: dev.chrisbanes.haze.HazeEffectNode$$ExternalSyntheticLambda20
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return HazeEffectNode._set_mask_$lambda$10(this.f$0, brush);
            }
        });
        this.dirtyTracker = Bitmask.m14441plusHWHKK88(this.dirtyTracker, 128);
        this.mask = brush;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String _set_mask_$lambda$10(HazeEffectNode hazeEffectNode, Brush brush) {
        return "mask changed. Current: " + hazeEffectNode.mask + ". New: " + brush;
    }

    @Override // dev.chrisbanes.haze.HazeEffectScope
    /* JADX INFO: renamed from: getBackgroundColor-0d7_KjU, reason: not valid java name and from getter */
    public long getBackgroundColor() {
        return this.backgroundColor;
    }

    @Override // dev.chrisbanes.haze.HazeEffectScope
    /* JADX INFO: renamed from: setBackgroundColor-8_81llA, reason: not valid java name */
    public void mo14466setBackgroundColor8_81llA(final long j) {
        if (Color.m6815equalsimpl0(j, this.backgroundColor)) {
            return;
        }
        Log_androidKt.log(TAG, new Function0() { // from class: dev.chrisbanes.haze.HazeEffectNode$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return HazeEffectNode.setBackgroundColor_8_81llA$lambda$11(this.f$0, j);
            }
        });
        this.dirtyTracker = Bitmask.m14441plusHWHKK88(this.dirtyTracker, 256);
        this.backgroundColor = j;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String setBackgroundColor_8_81llA$lambda$11(HazeEffectNode hazeEffectNode, long j) {
        return "backgroundColor changed. Current: " + Color.m6822toStringimpl(hazeEffectNode.backgroundColor) + ". New: " + Color.m6822toStringimpl(j);
    }

    @Override // dev.chrisbanes.haze.HazeEffectScope
    public List<HazeTint> getTints() {
        return this.tints;
    }

    @Override // dev.chrisbanes.haze.HazeEffectScope
    public void setTints(final List<HazeTint> value) {
        Intrinsics.checkNotNullParameter(value, "value");
        if (Intrinsics.areEqual(value, this.tints)) {
            return;
        }
        Log_androidKt.log(TAG, new Function0() { // from class: dev.chrisbanes.haze.HazeEffectNode$$ExternalSyntheticLambda5
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return HazeEffectNode._set_tints_$lambda$12(this.f$0, value);
            }
        });
        this.dirtyTracker = Bitmask.m14441plusHWHKK88(this.dirtyTracker, 512);
        this.tints = value;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String _set_tints_$lambda$12(HazeEffectNode hazeEffectNode, List list) {
        return "tints changed. Current: " + hazeEffectNode.tints + ". New: " + list;
    }

    @Override // dev.chrisbanes.haze.HazeEffectScope
    public HazeTint getFallbackTint() {
        return this.fallbackTint;
    }

    @Override // dev.chrisbanes.haze.HazeEffectScope
    public void setFallbackTint(final HazeTint value) {
        Intrinsics.checkNotNullParameter(value, "value");
        if (Intrinsics.areEqual(value, this.fallbackTint)) {
            return;
        }
        Log_androidKt.log(TAG, new Function0() { // from class: dev.chrisbanes.haze.HazeEffectNode$$ExternalSyntheticLambda25
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return HazeEffectNode._set_fallbackTint_$lambda$13(this.f$0, value);
            }
        });
        this.dirtyTracker = Bitmask.m14441plusHWHKK88(this.dirtyTracker, 1024);
        this.fallbackTint = value;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String _set_fallbackTint_$lambda$13(HazeEffectNode hazeEffectNode, HazeTint hazeTint) {
        return "fallbackTint changed. Current: " + hazeEffectNode.fallbackTint + ". New: " + hazeTint;
    }

    @Override // dev.chrisbanes.haze.HazeEffectScope
    public float getAlpha() {
        return this.alpha;
    }

    @Override // dev.chrisbanes.haze.HazeEffectScope
    public void setAlpha(final float f) {
        if (f == this.alpha) {
            return;
        }
        Log_androidKt.log(TAG, new Function0() { // from class: dev.chrisbanes.haze.HazeEffectNode$$ExternalSyntheticLambda21
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return HazeEffectNode._set_alpha_$lambda$14(this.f$0, f);
            }
        });
        this.dirtyTracker = Bitmask.m14441plusHWHKK88(this.dirtyTracker, 2048);
        this.alpha = f;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String _set_alpha_$lambda$14(HazeEffectNode hazeEffectNode, float f) {
        return "alpha changed. Current " + hazeEffectNode.alpha + ". New: " + f;
    }

    @Override // dev.chrisbanes.haze.HazeEffectScope
    public HazeProgressive getProgressive() {
        return this.progressive;
    }

    @Override // dev.chrisbanes.haze.HazeEffectScope
    public void setProgressive(final HazeProgressive hazeProgressive) {
        if (Intrinsics.areEqual(hazeProgressive, this.progressive)) {
            return;
        }
        Log_androidKt.log(TAG, new Function0() { // from class: dev.chrisbanes.haze.HazeEffectNode$$ExternalSyntheticLambda22
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return HazeEffectNode._set_progressive_$lambda$15(this.f$0, hazeProgressive);
            }
        });
        this.dirtyTracker = Bitmask.m14441plusHWHKK88(this.dirtyTracker, 4096);
        this.progressive = hazeProgressive;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String _set_progressive_$lambda$15(HazeEffectNode hazeEffectNode, HazeProgressive hazeProgressive) {
        return "progressive changed. Current " + hazeEffectNode.progressive + ". New: " + hazeProgressive;
    }

    private final void setAreas(final List<HazeArea> list) {
        if (Intrinsics.areEqual(list, this.areas)) {
            return;
        }
        Log_androidKt.log(TAG, new Function0() { // from class: dev.chrisbanes.haze.HazeEffectNode$$ExternalSyntheticLambda6
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return HazeEffectNode._set_areas_$lambda$16(this.f$0, list);
            }
        });
        this.dirtyTracker = Bitmask.m14441plusHWHKK88(this.dirtyTracker, 8192);
        this.areas = list;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String _set_areas_$lambda$16(HazeEffectNode hazeEffectNode, List list) {
        return "backgroundAreas changed. Current " + hazeEffectNode.areas + ". New: " + list;
    }

    @Override // dev.chrisbanes.haze.HazeEffectScope
    public Function1<HazeArea, Boolean> getCanDrawArea() {
        return this.canDrawArea;
    }

    @Override // dev.chrisbanes.haze.HazeEffectScope
    public void setCanDrawArea(final Function1<? super HazeArea, Boolean> function1) {
        if (Intrinsics.areEqual(function1, this.canDrawArea)) {
            return;
        }
        Log_androidKt.log(TAG, new Function0() { // from class: dev.chrisbanes.haze.HazeEffectNode$$ExternalSyntheticLambda13
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return HazeEffectNode._set_canDrawArea_$lambda$17(this.f$0, function1);
            }
        });
        this.canDrawArea = function1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String _set_canDrawArea_$lambda$17(HazeEffectNode hazeEffectNode, Function1 function1) {
        return "canDrawArea changed. Current " + hazeEffectNode.canDrawArea + ". New: " + function1;
    }

    private final void onStyleChanged(HazeStyle old, HazeStyle hazeStyle) {
        if (!Intrinsics.areEqual(old != null ? old.getTints() : null, hazeStyle != null ? hazeStyle.getTints() : null)) {
            this.dirtyTracker = Bitmask.m14441plusHWHKK88(this.dirtyTracker, 512);
        }
        if (!Intrinsics.areEqual(old != null ? old.getFallbackTint() : null, hazeStyle != null ? hazeStyle.getFallbackTint() : null)) {
            this.dirtyTracker = Bitmask.m14441plusHWHKK88(this.dirtyTracker, 512);
        }
        if (!Intrinsics.areEqual(old != null ? Color.m6804boximpl(old.m14500getBackgroundColor0d7_KjU()) : null, hazeStyle != null ? Color.m6804boximpl(hazeStyle.m14500getBackgroundColor0d7_KjU()) : null)) {
            this.dirtyTracker = Bitmask.m14441plusHWHKK88(this.dirtyTracker, 256);
        }
        if (!Intrinsics.areEqual(old != null ? Float.valueOf(old.getNoiseFactor()) : null, hazeStyle != null ? Float.valueOf(hazeStyle.getNoiseFactor()) : null)) {
            this.dirtyTracker = Bitmask.m14441plusHWHKK88(this.dirtyTracker, 64);
        }
        if (Intrinsics.areEqual(old != null ? Dp.m9685boximpl(old.m14501getBlurRadiusD9Ej5fM()) : null, hazeStyle != null ? Dp.m9685boximpl(hazeStyle.m14501getBlurRadiusD9Ej5fM()) : null)) {
            return;
        }
        this.dirtyTracker = Bitmask.m14441plusHWHKK88(this.dirtyTracker, 32);
    }

    public final void update$haze_release() {
        onObservedReadsChanged();
    }

    @Override // androidx.compose.ui.Modifier.Node
    public void onAttach() {
        update$haze_release();
    }

    /* JADX INFO: renamed from: dev.chrisbanes.haze.HazeEffectNode$onObservedReadsChanged$1, reason: invalid class name */
    /* JADX INFO: compiled from: HazeEffectNode.kt */
    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    /* synthetic */ class AnonymousClass1 extends FunctionReferenceImpl implements Function0<Unit> {
        AnonymousClass1(Object obj) {
            super(0, obj, HazeEffectNode.class, "updateEffect", "updateEffect()V", 0);
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.INSTANCE;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            ((HazeEffectNode) this.receiver).updateEffect();
        }
    }

    @Override // androidx.compose.ui.node.ObserverModifierNode
    public void onObservedReadsChanged() {
        ObserverModifierNodeKt.observeReads(this, new AnonymousClass1(this));
    }

    @Override // androidx.compose.ui.node.LayoutAwareModifierNode
    public void onPlaced(LayoutCoordinates coordinates) {
        Intrinsics.checkNotNullParameter(coordinates, "coordinates");
        if (OffsetKt.m6590isUnspecifiedk4lQ0M(this.positionOnScreen)) {
            onPositioned(coordinates, "onPlaced");
        }
    }

    @Override // androidx.compose.ui.node.GlobalPositionAwareModifierNode
    public void onGloballyPositioned(LayoutCoordinates coordinates) {
        Intrinsics.checkNotNullParameter(coordinates, "coordinates");
        onPositioned(coordinates, "onGloballyPositioned");
    }

    private final void onPositioned(LayoutCoordinates coordinates, final String source) {
        m14462setPositionOnScreenk4lQ0M(UtilsKt.positionOnScreenCatching(coordinates));
        m14468setSizeuvyYCjk$haze_release(IntSizeKt.m9870toSizeozmzZPI(coordinates.mo8273getSizeYbymL2g()));
        Log_androidKt.log(TAG, new Function0() { // from class: dev.chrisbanes.haze.HazeEffectNode$$ExternalSyntheticLambda16
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return HazeEffectNode.onPositioned$lambda$18(source, this);
            }
        });
        updateEffect();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String onPositioned$lambda$18(String str, HazeEffectNode hazeEffectNode) {
        return str + ": positionOnScreen=" + Offset.m6577toStringimpl(hazeEffectNode.positionOnScreen) + ", size=" + Size.m6642toStringimpl(hazeEffectNode.size);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String draw$lambda$19() {
        return "-> HazeChild. start draw()";
    }

    /* JADX WARN: Code duplicated, block: B:9:0x0028  */
    @Override // androidx.compose.ui.node.DrawModifierNode
    public void draw(ContentDrawScope contentDrawScope) throws Throwable {
        Intrinsics.checkNotNullParameter(contentDrawScope, "<this>");
        Log_androidKt.log(TAG, new Function0() { // from class: dev.chrisbanes.haze.HazeEffectNode$$ExternalSyntheticLambda8
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return HazeEffectNode.draw$lambda$19();
            }
        });
        if (isValid()) {
            if (getBlurEnabled()) {
                ContentDrawScope contentDrawScope2 = contentDrawScope;
                if (RenderEffect_androidKt.canUseGraphicLayers(contentDrawScope2)) {
                    drawEffectWithGraphicsLayer(contentDrawScope2);
                } else {
                    drawEffectWithScrim(contentDrawScope);
                }
            } else {
                drawEffectWithScrim(contentDrawScope);
            }
        } else {
            Log_androidKt.log(TAG, new Function0() { // from class: dev.chrisbanes.haze.HazeEffectNode$$ExternalSyntheticLambda9
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    return HazeEffectNode.draw$lambda$20();
                }
            });
        }
        contentDrawScope.drawContent();
        onPostDraw();
        Log_androidKt.log(TAG, new Function0() { // from class: dev.chrisbanes.haze.HazeEffectNode$$ExternalSyntheticLambda10
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return HazeEffectNode.draw$lambda$21();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String draw$lambda$20() {
        return "-> HazeChild. Draw. State not valid, so no need to draw effect.";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String draw$lambda$21() {
        return "-> HazeChild. end draw()";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void updateEffect() {
        setCompositionLocalStyle$haze_release((HazeStyle) CompositionLocalConsumerModifierNodeKt.currentValueOf(this, HazeStyleKt.getLocalHazeStyle()));
        Function1<? super HazeEffectScope, Unit> function1 = this.block;
        if (function1 != null) {
            function1.invoke(this);
        }
        final Float f = (Float) getCurrent(HazeEffectNodeKt.getModifierLocalCurrentHazeZIndex());
        final List<HazeArea> areas = this.state.getAreas();
        Log_androidKt.log(TAG, new Function0() { // from class: dev.chrisbanes.haze.HazeEffectNode$$ExternalSyntheticLambda17
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return HazeEffectNode.updateEffect$lambda$23$lambda$22(areas);
            }
        });
        List<HazeArea> mutableList = SequencesKt.toMutableList(SequencesKt.filter(CollectionsKt.asSequence(areas), new Function1() { // from class: dev.chrisbanes.haze.HazeEffectNode$$ExternalSyntheticLambda18
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return Boolean.valueOf(HazeEffectNode.updateEffect$lambda$26(this.f$0, f, (HazeArea) obj));
            }
        }));
        if (mutableList.size() > 1) {
            CollectionsKt.sortWith(mutableList, new Comparator() { // from class: dev.chrisbanes.haze.HazeEffectNode$updateEffect$lambda$27$$inlined$sortBy$1
                /* JADX WARN: Multi-variable type inference failed */
                @Override // java.util.Comparator
                public final int compare(T t, T t2) {
                    return ComparisonsKt.compareValues(Float.valueOf(((HazeArea) t).getZIndex()), Float.valueOf(((HazeArea) t2).getZIndex()));
                }
            });
        }
        setAreas(mutableList);
        List<HazeArea> list = this.areas;
        LinkedHashMap linkedHashMap = new LinkedHashMap(RangesKt.coerceAtLeast(MapsKt.mapCapacity(CollectionsKt.collectionSizeOrDefault(list, 10)), 16));
        for (Object obj : list) {
            linkedHashMap.put(obj, Offset.m6558boximpl(Offset.m6573minusMKHz9U(this.positionOnScreen, ((HazeArea) obj).m14447getPositionOnScreenF1C5BW0())));
        }
        setAreaOffsets(linkedHashMap);
        invalidateIfNeeded();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String updateEffect$lambda$23$lambda$22(List list) {
        return "Background Areas observing: " + list;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean updateEffect$lambda$26(HazeEffectNode hazeEffectNode, Float f, final HazeArea area) {
        final boolean zBooleanValue;
        Intrinsics.checkNotNullParameter(area, "area");
        Function1<HazeArea, Boolean> canDrawArea = hazeEffectNode.getCanDrawArea();
        if (canDrawArea != null) {
            zBooleanValue = canDrawArea.invoke(area).booleanValue();
        } else {
            zBooleanValue = true;
            if (f != null && area.getZIndex() >= f.floatValue()) {
                zBooleanValue = false;
            }
        }
        Log_androidKt.log(TAG, new Function0() { // from class: dev.chrisbanes.haze.HazeEffectNode$$ExternalSyntheticLambda27
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return HazeEffectNode.updateEffect$lambda$26$lambda$25$lambda$24(area, zBooleanValue);
            }
        });
        return zBooleanValue;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String updateEffect$lambda$26$lambda$25$lambda$24(HazeArea hazeArea, boolean z) {
        return "Background Area: " + hazeArea + ". Included=" + z;
    }

    private final void drawEffectWithGraphicsLayer(DrawScope drawScope) throws Throwable {
        long j;
        GraphicsContext graphicsContext = (GraphicsContext) CompositionLocalConsumerModifierNodeKt.currentValueOf(this, CompositionLocalsKt.getLocalGraphicsContext());
        GraphicsLayer graphicsLayerCreateGraphicsLayer = graphicsContext.createGraphicsLayer();
        final float fM14473calculateInputScaleFactor3ABfNKs$default = HazeEffectNodeKt.m14473calculateInputScaleFactor3ABfNKs$default(this, 0.0f, 1, null);
        long jM6641times7Ah8Wj8 = Size.m6641times7Ah8Wj8(drawScope.mo7395getSizeNHjbRc(), fM14473calculateInputScaleFactor3ABfNKs$default);
        final long jResolveBackgroundColor = HazeEffectNodeKt.resolveBackgroundColor(this);
        if (jResolveBackgroundColor == 16) {
            throw new IllegalArgumentException("backgroundColor not specified. Please provide a color.".toString());
        }
        final Rect rectM6609Recttz77jQw = RectKt.m6609Recttz77jQw(this.positionOnScreen, drawScope.mo7395getSizeNHjbRc());
        drawScope.mo7396recordJVtK1S4(graphicsLayerCreateGraphicsLayer, IntSizeKt.m9866roundToIntSizeuvyYCjk(jM6641times7Ah8Wj8), new Function1() { // from class: dev.chrisbanes.haze.HazeEffectNode$$ExternalSyntheticLambda26
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return HazeEffectNode.drawEffectWithGraphicsLayer$lambda$42(jResolveBackgroundColor, fM14473calculateInputScaleFactor3ABfNKs$default, this, rectM6609Recttz77jQw, (DrawScope) obj);
            }
        });
        float fM6638getWidthimpl = Size.m6638getWidthimpl(drawScope.mo7395getSizeNHjbRc());
        float fM6635getHeightimpl = Size.m6635getHeightimpl(drawScope.mo7395getSizeNHjbRc());
        int iM6803getIntersectrtfAjoo = ClipOp.INSTANCE.m6803getIntersectrtfAjoo();
        DrawContext drawContext = drawScope.getDrawContext();
        long jMo7316getSizeNHjbRc = drawContext.mo7316getSizeNHjbRc();
        drawContext.getCanvas().save();
        try {
            j = jMo7316getSizeNHjbRc;
            try {
                drawContext.getTransform().mo7319clipRectN_I0leg(0.0f, 0.0f, fM6638getWidthimpl, fM6635getHeightimpl, iM6803getIntersectrtfAjoo);
                float f = 1.0f / fM14473calculateInputScaleFactor3ABfNKs$default;
                long jM6585getZeroF1C5BW0 = Offset.INSTANCE.m6585getZeroF1C5BW0();
                DrawContext drawContext2 = drawScope.getDrawContext();
                long jMo7316getSizeNHjbRc2 = drawContext2.mo7316getSizeNHjbRc();
                drawContext2.getCanvas().save();
                try {
                    drawContext2.getTransform().mo7323scale0AR0LA0(f, f, jM6585getZeroF1C5BW0);
                    HazeProgressive progressive = getProgressive();
                    if (progressive instanceof HazeProgressive.LinearGradient) {
                        HazeChildNode_androidKt.drawLinearGradientProgressiveEffect(this, drawScope, (HazeProgressive.LinearGradient) progressive, graphicsLayerCreateGraphicsLayer);
                    } else {
                        updateRenderEffectIfDirty();
                        graphicsLayerCreateGraphicsLayer.setRenderEffect(this.renderEffect);
                        graphicsLayerCreateGraphicsLayer.setAlpha(getAlpha());
                        GraphicsLayerKt.drawLayer(drawScope, graphicsLayerCreateGraphicsLayer);
                    }
                    drawContext2.getCanvas().restore();
                    drawContext2.mo7317setSizeuvyYCjk(jMo7316getSizeNHjbRc2);
                    drawContext.getCanvas().restore();
                    drawContext.mo7317setSizeuvyYCjk(j);
                    graphicsContext.releaseGraphicsLayer(graphicsLayerCreateGraphicsLayer);
                } catch (Throwable th) {
                    drawContext2.getCanvas().restore();
                    drawContext2.mo7317setSizeuvyYCjk(jMo7316getSizeNHjbRc2);
                    throw th;
                }
            } catch (Throwable th2) {
                th = th2;
                drawContext.getCanvas().restore();
                drawContext.mo7317setSizeuvyYCjk(j);
                throw th;
            }
        } catch (Throwable th3) {
            th = th3;
            j = jMo7316getSizeNHjbRc;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:102:0x021d A[Catch: all -> 0x0374, TryCatch #8 {all -> 0x0374, blocks: (B:98:0x0208, B:99:0x0215, B:94:0x01f4, B:102:0x021d, B:103:0x0229, B:105:0x022f, B:107:0x023b, B:109:0x0243, B:111:0x0249, B:113:0x0251, B:115:0x0256, B:118:0x025e, B:120:0x0266, B:122:0x026c, B:127:0x0281, B:129:0x028a, B:131:0x0296, B:146:0x02df, B:148:0x02ef, B:149:0x02fc, B:150:0x02fd, B:152:0x0303, B:157:0x030d, B:159:0x0317, B:163:0x0324, B:165:0x0336, B:166:0x0339, B:167:0x033a, B:169:0x0345, B:170:0x0348, B:171:0x0349, B:172:0x0352, B:112:0x024d, B:132:0x02a9, B:134:0x02af, B:139:0x02b9, B:141:0x02c3, B:145:0x02d0, B:123:0x0270, B:126:0x027b), top: B:205:0x0075, inners: #1, #4, #9 }] */
    /* JADX WARN: Code duplicated, block: B:105:0x022f A[Catch: all -> 0x0374, TryCatch #8 {all -> 0x0374, blocks: (B:98:0x0208, B:99:0x0215, B:94:0x01f4, B:102:0x021d, B:103:0x0229, B:105:0x022f, B:107:0x023b, B:109:0x0243, B:111:0x0249, B:113:0x0251, B:115:0x0256, B:118:0x025e, B:120:0x0266, B:122:0x026c, B:127:0x0281, B:129:0x028a, B:131:0x0296, B:146:0x02df, B:148:0x02ef, B:149:0x02fc, B:150:0x02fd, B:152:0x0303, B:157:0x030d, B:159:0x0317, B:163:0x0324, B:165:0x0336, B:166:0x0339, B:167:0x033a, B:169:0x0345, B:170:0x0348, B:171:0x0349, B:172:0x0352, B:112:0x024d, B:132:0x02a9, B:134:0x02af, B:139:0x02b9, B:141:0x02c3, B:145:0x02d0, B:123:0x0270, B:126:0x027b), top: B:205:0x0075, inners: #1, #4, #9 }] */
    /* JADX WARN: Code duplicated, block: B:107:0x023b A[Catch: all -> 0x0374, TryCatch #8 {all -> 0x0374, blocks: (B:98:0x0208, B:99:0x0215, B:94:0x01f4, B:102:0x021d, B:103:0x0229, B:105:0x022f, B:107:0x023b, B:109:0x0243, B:111:0x0249, B:113:0x0251, B:115:0x0256, B:118:0x025e, B:120:0x0266, B:122:0x026c, B:127:0x0281, B:129:0x028a, B:131:0x0296, B:146:0x02df, B:148:0x02ef, B:149:0x02fc, B:150:0x02fd, B:152:0x0303, B:157:0x030d, B:159:0x0317, B:163:0x0324, B:165:0x0336, B:166:0x0339, B:167:0x033a, B:169:0x0345, B:170:0x0348, B:171:0x0349, B:172:0x0352, B:112:0x024d, B:132:0x02a9, B:134:0x02af, B:139:0x02b9, B:141:0x02c3, B:145:0x02d0, B:123:0x0270, B:126:0x027b), top: B:205:0x0075, inners: #1, #4, #9 }] */
    /* JADX WARN: Code duplicated, block: B:109:0x0243 A[Catch: all -> 0x0374, TryCatch #8 {all -> 0x0374, blocks: (B:98:0x0208, B:99:0x0215, B:94:0x01f4, B:102:0x021d, B:103:0x0229, B:105:0x022f, B:107:0x023b, B:109:0x0243, B:111:0x0249, B:113:0x0251, B:115:0x0256, B:118:0x025e, B:120:0x0266, B:122:0x026c, B:127:0x0281, B:129:0x028a, B:131:0x0296, B:146:0x02df, B:148:0x02ef, B:149:0x02fc, B:150:0x02fd, B:152:0x0303, B:157:0x030d, B:159:0x0317, B:163:0x0324, B:165:0x0336, B:166:0x0339, B:167:0x033a, B:169:0x0345, B:170:0x0348, B:171:0x0349, B:172:0x0352, B:112:0x024d, B:132:0x02a9, B:134:0x02af, B:139:0x02b9, B:141:0x02c3, B:145:0x02d0, B:123:0x0270, B:126:0x027b), top: B:205:0x0075, inners: #1, #4, #9 }] */
    /* JADX WARN: Code duplicated, block: B:110:0x0248  */
    /* JADX WARN: Code duplicated, block: B:220:0x0349 A[SYNTHETIC] */
    public static final Unit drawEffectWithGraphicsLayer$lambda$42(long j, float f, HazeEffectNode hazeEffectNode, Rect rect, DrawScope record) throws Throwable {
        DrawContext drawContext;
        long j2;
        long j3;
        DrawContext drawContext2;
        long j4;
        Snapshot.Companion companion;
        Snapshot currentThreadSnapshot;
        Function1<Object, Unit> readObserver;
        Snapshot snapshotMakeCurrentNonObservable;
        Rect bounds$haze_release;
        Intrinsics.checkNotNullParameter(record, "$this$record");
        DrawScope.m7389drawRectnJ9OG0$default(record, j, 0L, 0L, 0.0f, null, null, 0, 126, null);
        float fM6638getWidthimpl = Size.m6638getWidthimpl(record.mo7395getSizeNHjbRc());
        float fM6635getHeightimpl = Size.m6635getHeightimpl(record.mo7395getSizeNHjbRc());
        int iM6803getIntersectrtfAjoo = ClipOp.INSTANCE.m6803getIntersectrtfAjoo();
        DrawContext drawContext3 = record.getDrawContext();
        long jMo7316getSizeNHjbRc = drawContext3.mo7316getSizeNHjbRc();
        drawContext3.getCanvas().save();
        try {
            drawContext3.getTransform().mo7319clipRectN_I0leg(0.0f, 0.0f, fM6638getWidthimpl, fM6635getHeightimpl, iM6803getIntersectrtfAjoo);
            long jM6585getZeroF1C5BW0 = Offset.INSTANCE.m6585getZeroF1C5BW0();
            DrawContext drawContext4 = record.getDrawContext();
            long jMo7316getSizeNHjbRc2 = drawContext4.mo7316getSizeNHjbRc();
            drawContext4.getCanvas().save();
            try {
                drawContext4.getTransform().mo7323scale0AR0LA0(f, f, jM6585getZeroF1C5BW0);
                long jM6578unaryMinusF1C5BW0 = Offset.m6578unaryMinusF1C5BW0(hazeEffectNode.positionOnScreen);
                String str = "Modifier.haze nodes can not draw Modifier.hazeChild nodes. This should not happen if you are providing correct values for zIndex on Modifier.haze. Alternatively you can use can `canDrawArea` to to filter out parent areas.";
                try {
                    if (!OffsetKt.m6586isFinitek4lQ0M(jM6578unaryMinusF1C5BW0)) {
                        drawContext2 = drawContext3;
                        j3 = jMo7316getSizeNHjbRc;
                        while (r0.hasNext()) {
                            if (!hazeArea.getContentDrawing()) {
                                throw new IllegalArgumentException("Modifier.haze nodes can not draw Modifier.hazeChild nodes. This should not happen if you are providing correct values for zIndex on Modifier.haze. Alternatively you can use can `canDrawArea` to to filter out parent areas.".toString());
                            }
                            companion = Snapshot.INSTANCE;
                            currentThreadSnapshot = companion.getCurrentThreadSnapshot();
                            if (currentThreadSnapshot != null) {
                                readObserver = currentThreadSnapshot.getReadObserver();
                            } else {
                                readObserver = null;
                            }
                            snapshotMakeCurrentNonObservable = companion.makeCurrentNonObservable(currentThreadSnapshot);
                            bounds$haze_release = hazeArea.getBounds$haze_release();
                            companion.restoreNonObservable(currentThreadSnapshot, snapshotMakeCurrentNonObservable, readObserver);
                            if (bounds$haze_release == null) {
                            }
                            Log_androidKt.log(TAG, new Function0() { // from class: dev.chrisbanes.haze.HazeEffectNode$$ExternalSyntheticLambda23
                                @Override // kotlin.jvm.functions.Function0
                                public final Object invoke() {
                                    return HazeEffectNode.drawEffectWithGraphicsLayer$lambda$42$lambda$41$lambda$40$lambda$39$lambda$32(hazeArea);
                                }
                            });
                        }
                        drawContext4.getCanvas().restore();
                        drawContext4.mo7317setSizeuvyYCjk(jMo7316getSizeNHjbRc2);
                        drawContext2.getCanvas().restore();
                        drawContext2.mo7317setSizeuvyYCjk(j3);
                        return Unit.INSTANCE;
                    }
                    try {
                        if (Offset.m6566equalsimpl0(jM6578unaryMinusF1C5BW0, Offset.INSTANCE.m6585getZeroF1C5BW0())) {
                            drawContext2 = drawContext3;
                            j3 = jMo7316getSizeNHjbRc;
                            for (final HazeArea hazeArea : hazeEffectNode.areas) {
                                if (!hazeArea.getContentDrawing()) {
                                    throw new IllegalArgumentException("Modifier.haze nodes can not draw Modifier.hazeChild nodes. This should not happen if you are providing correct values for zIndex on Modifier.haze. Alternatively you can use can `canDrawArea` to to filter out parent areas.".toString());
                                }
                                companion = Snapshot.INSTANCE;
                                currentThreadSnapshot = companion.getCurrentThreadSnapshot();
                                if (currentThreadSnapshot != null) {
                                    readObserver = currentThreadSnapshot.getReadObserver();
                                } else {
                                    readObserver = null;
                                }
                                snapshotMakeCurrentNonObservable = companion.makeCurrentNonObservable(currentThreadSnapshot);
                                try {
                                    bounds$haze_release = hazeArea.getBounds$haze_release();
                                    companion.restoreNonObservable(currentThreadSnapshot, snapshotMakeCurrentNonObservable, readObserver);
                                    if (bounds$haze_release == null && rect.overlaps(bounds$haze_release)) {
                                        Snapshot.Companion companion2 = Snapshot.INSTANCE;
                                        Snapshot currentThreadSnapshot2 = companion2.getCurrentThreadSnapshot();
                                        Function1<Object, Unit> readObserver2 = currentThreadSnapshot2 != null ? currentThreadSnapshot2.getReadObserver() : null;
                                        Snapshot snapshotMakeCurrentNonObservable2 = companion2.makeCurrentNonObservable(currentThreadSnapshot2);
                                        try {
                                            long jM14447getPositionOnScreenF1C5BW0 = hazeArea.m14447getPositionOnScreenF1C5BW0();
                                            if (!OffsetKt.m6588isSpecifiedk4lQ0M(jM14447getPositionOnScreenF1C5BW0)) {
                                                jM14447getPositionOnScreenF1C5BW0 = Offset.INSTANCE.m6585getZeroF1C5BW0();
                                            }
                                            companion2.restoreNonObservable(currentThreadSnapshot2, snapshotMakeCurrentNonObservable2, readObserver2);
                                            if (!OffsetKt.m6586isFinitek4lQ0M(jM14447getPositionOnScreenF1C5BW0) || Offset.m6566equalsimpl0(jM14447getPositionOnScreenF1C5BW0, Offset.INSTANCE.m6585getZeroF1C5BW0())) {
                                                final GraphicsLayer contentLayer = hazeArea.getContentLayer();
                                                if (contentLayer != null) {
                                                    if (contentLayer.getIsReleased()) {
                                                        contentLayer = null;
                                                    }
                                                    if (contentLayer != null) {
                                                        if (IntSize.m9858getWidthimpl(contentLayer.getSize()) <= 0 || IntSize.m9857getHeightimpl(contentLayer.getSize()) <= 0) {
                                                            contentLayer = null;
                                                        }
                                                        if (contentLayer != null) {
                                                            Log_androidKt.log(TAG, new Function0() { // from class: dev.chrisbanes.haze.HazeEffectNode$$ExternalSyntheticLambda24
                                                                @Override // kotlin.jvm.functions.Function0
                                                                public final Object invoke() {
                                                                    return HazeEffectNode.drawEffectWithGraphicsLayer$lambda$42$lambda$41$lambda$40$lambda$39$lambda$38$lambda$37$lambda$36(contentLayer);
                                                                }
                                                            });
                                                            GraphicsLayerKt.drawLayer(record, contentLayer);
                                                            Unit unit = Unit.INSTANCE;
                                                            Unit unit2 = Unit.INSTANCE;
                                                        }
                                                    }
                                                }
                                            } else {
                                                float fM6569getXimpl = Offset.m6569getXimpl(jM14447getPositionOnScreenF1C5BW0);
                                                float fM6570getYimpl = Offset.m6570getYimpl(jM14447getPositionOnScreenF1C5BW0);
                                                record.getDrawContext().getTransform().translate(fM6569getXimpl, fM6570getYimpl);
                                                try {
                                                    final GraphicsLayer contentLayer2 = hazeArea.getContentLayer();
                                                    if (contentLayer2 != null) {
                                                        if (contentLayer2.getIsReleased()) {
                                                            contentLayer2 = null;
                                                        }
                                                        if (contentLayer2 != null) {
                                                            if (IntSize.m9858getWidthimpl(contentLayer2.getSize()) <= 0 || IntSize.m9857getHeightimpl(contentLayer2.getSize()) <= 0) {
                                                                contentLayer2 = null;
                                                            }
                                                            if (contentLayer2 != null) {
                                                                Log_androidKt.log(TAG, new Function0() { // from class: dev.chrisbanes.haze.HazeEffectNode$$ExternalSyntheticLambda24
                                                                    @Override // kotlin.jvm.functions.Function0
                                                                    public final Object invoke() {
                                                                        return HazeEffectNode.drawEffectWithGraphicsLayer$lambda$42$lambda$41$lambda$40$lambda$39$lambda$38$lambda$37$lambda$36(contentLayer2);
                                                                    }
                                                                });
                                                                GraphicsLayerKt.drawLayer(record, contentLayer2);
                                                                Unit unit3 = Unit.INSTANCE;
                                                                Unit unit4 = Unit.INSTANCE;
                                                            }
                                                        }
                                                    }
                                                    record.getDrawContext().getTransform().translate(-fM6569getXimpl, -fM6570getYimpl);
                                                } catch (Throwable th) {
                                                    record.getDrawContext().getTransform().translate(-fM6569getXimpl, -fM6570getYimpl);
                                                    throw th;
                                                }
                                            }
                                        } catch (Throwable th2) {
                                            companion2.restoreNonObservable(currentThreadSnapshot2, snapshotMakeCurrentNonObservable2, readObserver2);
                                            throw th2;
                                        }
                                    } else {
                                        Log_androidKt.log(TAG, new Function0() { // from class: dev.chrisbanes.haze.HazeEffectNode$$ExternalSyntheticLambda23
                                            @Override // kotlin.jvm.functions.Function0
                                            public final Object invoke() {
                                                return HazeEffectNode.drawEffectWithGraphicsLayer$lambda$42$lambda$41$lambda$40$lambda$39$lambda$32(hazeArea);
                                            }
                                        });
                                    }
                                } catch (Throwable th3) {
                                    companion.restoreNonObservable(currentThreadSnapshot, snapshotMakeCurrentNonObservable, readObserver);
                                    throw th3;
                                }
                            }
                        } else {
                            float fM6569getXimpl2 = Offset.m6569getXimpl(jM6578unaryMinusF1C5BW0);
                            float fM6570getYimpl2 = Offset.m6570getYimpl(jM6578unaryMinusF1C5BW0);
                            record.getDrawContext().getTransform().translate(fM6569getXimpl2, fM6570getYimpl2);
                            try {
                                Iterator<HazeArea> it = hazeEffectNode.areas.iterator();
                                while (it.hasNext()) {
                                    final HazeArea next = it.next();
                                    if (next.getContentDrawing()) {
                                        throw new IllegalArgumentException(str.toString());
                                    }
                                    Snapshot.Companion companion3 = Snapshot.INSTANCE;
                                    Snapshot currentThreadSnapshot3 = companion3.getCurrentThreadSnapshot();
                                    Function1<Object, Unit> readObserver3 = currentThreadSnapshot3 != null ? currentThreadSnapshot3.getReadObserver() : null;
                                    DrawContext drawContext5 = drawContext3;
                                    try {
                                        Snapshot snapshotMakeCurrentNonObservable3 = companion3.makeCurrentNonObservable(currentThreadSnapshot3);
                                        Iterator<HazeArea> it2 = it;
                                        try {
                                            Rect bounds$haze_release2 = next.getBounds$haze_release();
                                            companion3.restoreNonObservable(currentThreadSnapshot3, snapshotMakeCurrentNonObservable3, readObserver3);
                                            if (bounds$haze_release2 == null || !rect.overlaps(bounds$haze_release2)) {
                                                j4 = jMo7316getSizeNHjbRc;
                                                Log_androidKt.log(TAG, new Function0() { // from class: dev.chrisbanes.haze.HazeEffectNode$$ExternalSyntheticLambda23
                                                    @Override // kotlin.jvm.functions.Function0
                                                    public final Object invoke() {
                                                        return HazeEffectNode.drawEffectWithGraphicsLayer$lambda$42$lambda$41$lambda$40$lambda$39$lambda$32(next);
                                                    }
                                                });
                                            } else {
                                                Snapshot.Companion companion4 = Snapshot.INSTANCE;
                                                Snapshot currentThreadSnapshot4 = companion4.getCurrentThreadSnapshot();
                                                Function1<Object, Unit> readObserver4 = currentThreadSnapshot4 != null ? currentThreadSnapshot4.getReadObserver() : null;
                                                Snapshot snapshotMakeCurrentNonObservable4 = companion4.makeCurrentNonObservable(currentThreadSnapshot4);
                                                try {
                                                    long jM14447getPositionOnScreenF1C5BW1 = next.m14447getPositionOnScreenF1C5BW0();
                                                    if (!OffsetKt.m6588isSpecifiedk4lQ0M(jM14447getPositionOnScreenF1C5BW1)) {
                                                        jM14447getPositionOnScreenF1C5BW1 = Offset.INSTANCE.m6585getZeroF1C5BW0();
                                                    }
                                                    long j5 = jM14447getPositionOnScreenF1C5BW1;
                                                    companion4.restoreNonObservable(currentThreadSnapshot4, snapshotMakeCurrentNonObservable4, readObserver4);
                                                    if (OffsetKt.m6586isFinitek4lQ0M(j5)) {
                                                        j4 = jMo7316getSizeNHjbRc;
                                                        try {
                                                            if (!Offset.m6566equalsimpl0(j5, Offset.INSTANCE.m6585getZeroF1C5BW0())) {
                                                                float fM6569getXimpl3 = Offset.m6569getXimpl(j5);
                                                                float fM6570getYimpl3 = Offset.m6570getYimpl(j5);
                                                                record.getDrawContext().getTransform().translate(fM6569getXimpl3, fM6570getYimpl3);
                                                                try {
                                                                    final GraphicsLayer contentLayer3 = next.getContentLayer();
                                                                    if (contentLayer3 != null) {
                                                                        if (contentLayer3.getIsReleased()) {
                                                                            contentLayer3 = null;
                                                                        }
                                                                        if (contentLayer3 != null) {
                                                                            if (IntSize.m9858getWidthimpl(contentLayer3.getSize()) <= 0 || IntSize.m9857getHeightimpl(contentLayer3.getSize()) <= 0) {
                                                                                contentLayer3 = null;
                                                                            }
                                                                            if (contentLayer3 != null) {
                                                                                Log_androidKt.log(TAG, new Function0() { // from class: dev.chrisbanes.haze.HazeEffectNode$$ExternalSyntheticLambda24
                                                                                    @Override // kotlin.jvm.functions.Function0
                                                                                    public final Object invoke() {
                                                                                        return HazeEffectNode.drawEffectWithGraphicsLayer$lambda$42$lambda$41$lambda$40$lambda$39$lambda$38$lambda$37$lambda$36(contentLayer3);
                                                                                    }
                                                                                });
                                                                                GraphicsLayerKt.drawLayer(record, contentLayer3);
                                                                                Unit unit5 = Unit.INSTANCE;
                                                                                Unit unit6 = Unit.INSTANCE;
                                                                            }
                                                                        }
                                                                    }
                                                                    record.getDrawContext().getTransform().translate(-fM6569getXimpl3, -fM6570getYimpl3);
                                                                } catch (Throwable th4) {
                                                                    record.getDrawContext().getTransform().translate(-fM6569getXimpl3, -fM6570getYimpl3);
                                                                    throw th4;
                                                                }
                                                            }
                                                        } catch (Throwable th5) {
                                                            th = th5;
                                                        }
                                                    } else {
                                                        j4 = jMo7316getSizeNHjbRc;
                                                    }
                                                    final GraphicsLayer contentLayer4 = next.getContentLayer();
                                                    if (contentLayer4 != null) {
                                                        if (contentLayer4.getIsReleased()) {
                                                            contentLayer4 = null;
                                                        }
                                                        if (contentLayer4 != null) {
                                                            if (IntSize.m9858getWidthimpl(contentLayer4.getSize()) <= 0 || IntSize.m9857getHeightimpl(contentLayer4.getSize()) <= 0) {
                                                                contentLayer4 = null;
                                                            }
                                                            if (contentLayer4 != null) {
                                                                Log_androidKt.log(TAG, new Function0() { // from class: dev.chrisbanes.haze.HazeEffectNode$$ExternalSyntheticLambda24
                                                                    @Override // kotlin.jvm.functions.Function0
                                                                    public final Object invoke() {
                                                                        return HazeEffectNode.drawEffectWithGraphicsLayer$lambda$42$lambda$41$lambda$40$lambda$39$lambda$38$lambda$37$lambda$36(contentLayer4);
                                                                    }
                                                                });
                                                                GraphicsLayerKt.drawLayer(record, contentLayer4);
                                                                Unit unit7 = Unit.INSTANCE;
                                                                Unit unit8 = Unit.INSTANCE;
                                                            }
                                                        }
                                                    }
                                                } catch (Throwable th6) {
                                                    companion4.restoreNonObservable(currentThreadSnapshot4, snapshotMakeCurrentNonObservable4, readObserver4);
                                                    throw th6;
                                                }
                                            }
                                            str = str;
                                            it = it2;
                                            drawContext3 = drawContext5;
                                            jMo7316getSizeNHjbRc = j4;
                                        } catch (Throwable th7) {
                                            companion3.restoreNonObservable(currentThreadSnapshot3, snapshotMakeCurrentNonObservable3, readObserver3);
                                            throw th7;
                                        }
                                    } catch (Throwable th8) {
                                        th = th8;
                                    }
                                    record.getDrawContext().getTransform().translate(-fM6569getXimpl2, -fM6570getYimpl2);
                                    throw th;
                                }
                                drawContext2 = drawContext3;
                                j3 = jMo7316getSizeNHjbRc;
                                record.getDrawContext().getTransform().translate(-fM6569getXimpl2, -fM6570getYimpl2);
                            } catch (Throwable th9) {
                                th = th9;
                            }
                        }
                        try {
                            drawContext4.getCanvas().restore();
                            drawContext4.mo7317setSizeuvyYCjk(jMo7316getSizeNHjbRc2);
                            drawContext2.getCanvas().restore();
                            drawContext2.mo7317setSizeuvyYCjk(j3);
                            return Unit.INSTANCE;
                        } catch (Throwable th10) {
                            th = th10;
                            drawContext = drawContext2;
                            j2 = j3;
                        }
                    } catch (Throwable th11) {
                        th = th11;
                        drawContext2 = drawContext3;
                        j3 = jMo7316getSizeNHjbRc;
                        drawContext = drawContext2;
                        j2 = j3;
                        try {
                            drawContext4.getCanvas().restore();
                            drawContext4.mo7317setSizeuvyYCjk(jMo7316getSizeNHjbRc2);
                            throw th;
                        } catch (Throwable th12) {
                            th = th12;
                        }
                    }
                } catch (Throwable th13) {
                    th = th13;
                    drawContext = drawContext2;
                    j2 = j3;
                    drawContext4.getCanvas().restore();
                    drawContext4.mo7317setSizeuvyYCjk(jMo7316getSizeNHjbRc2);
                    throw th;
                }
            } catch (Throwable th14) {
                th = th14;
                drawContext = drawContext3;
                j2 = jMo7316getSizeNHjbRc;
            }
        } catch (Throwable th15) {
            th = th15;
            drawContext = drawContext3;
            j2 = jMo7316getSizeNHjbRc;
        }
        drawContext.getCanvas().restore();
        drawContext.mo7317setSizeuvyYCjk(j2);
        throw th;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String drawEffectWithGraphicsLayer$lambda$42$lambda$41$lambda$40$lambda$39$lambda$32(HazeArea hazeArea) {
        return "Area does not overlap us. Skipping... " + hazeArea;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String drawEffectWithGraphicsLayer$lambda$42$lambda$41$lambda$40$lambda$39$lambda$38$lambda$37$lambda$36(GraphicsLayer graphicsLayer) {
        return "Drawing HazeArea GraphicsLayer: " + graphicsLayer;
    }

    private final void drawEffectWithScrim(DrawScope drawScope) {
        HazeTint hazeTintResolveFallbackTint = HazeEffectNodeKt.resolveFallbackTint(this);
        HazeTint hazeTintM14492boostForFallback3ABfNKs = null;
        if (!hazeTintResolveFallbackTint.isSpecified()) {
            hazeTintResolveFallbackTint = null;
        }
        if (hazeTintResolveFallbackTint == null) {
            HazeTint hazeTint = (HazeTint) CollectionsKt.firstOrNull((List) HazeEffectNodeKt.resolveTints(this));
            if (hazeTint != null) {
                float fResolveBlurRadius = HazeEffectNodeKt.resolveBlurRadius(this);
                if (Float.isNaN(fResolveBlurRadius)) {
                    fResolveBlurRadius = Dp.m9687constructorimpl(0);
                }
                hazeTintM14492boostForFallback3ABfNKs = HazeSourceNodeKt.m14492boostForFallback3ABfNKs(hazeTint, fResolveBlurRadius);
            }
            if (hazeTintM14492boostForFallback3ABfNKs == null) {
                return;
            } else {
                hazeTintResolveFallbackTint = hazeTintM14492boostForFallback3ABfNKs;
            }
        }
        if (getAlpha() != 1.0f) {
            getPaint().setAlpha(getAlpha());
            Canvas canvas = drawScope.getDrawContext().getCanvas();
            try {
                canvas.saveLayer(SizeKt.m6659toRectuvyYCjk(drawScope.mo7395getSizeNHjbRc()), getPaint());
                drawEffectWithScrim$scrim(this, drawScope, hazeTintResolveFallbackTint);
                return;
            } finally {
                canvas.restore();
            }
        }
        drawEffectWithScrim$scrim(this, drawScope, hazeTintResolveFallbackTint);
    }

    private static final void drawEffectWithScrim$scrim(HazeEffectNode hazeEffectNode, DrawScope drawScope, HazeTint hazeTint) {
        Brush mask = hazeEffectNode.getMask();
        HazeProgressive progressive = hazeEffectNode.getProgressive();
        if (mask != null) {
            DrawScope.m7388drawRectAsUm42w$default(drawScope, mask, 0L, 0L, 0.0f, null, ColorFilter.Companion.m6855tintxETnrds$default(ColorFilter.INSTANCE, hazeTint.m14508getColor0d7_KjU(), 0, 2, null), 0, 94, null);
        } else if (progressive instanceof HazeProgressive.LinearGradient) {
            DrawScope.m7388drawRectAsUm42w$default(drawScope, GradientKt.asBrush$default((HazeProgressive.LinearGradient) progressive, 0, 1, null), 0L, 0L, 0.0f, null, ColorFilter.Companion.m6855tintxETnrds$default(ColorFilter.INSTANCE, hazeTint.m14508getColor0d7_KjU(), 0, 2, null), 0, 94, null);
        } else {
            DrawScope.m7389drawRectnJ9OG0$default(drawScope, hazeTint.m14508getColor0d7_KjU(), 0L, 0L, 0.0f, null, null, hazeTint.m14507getBlendMode0nO6VwU(), 62, null);
        }
    }

    private final void updateRenderEffectIfDirty() {
        if (this.renderEffect == null || Bitmask.m14431anyimpl(this.dirtyTracker, DirtyFields.RenderEffectAffectingFlags)) {
            this.renderEffect = HazeEffectNodeKt.m14475getOrCreateRenderEffectQ3IRXdk$default(this, 0.0f, 0.0f, 0.0f, null, 0.0f, 0L, null, null, 255, null);
        }
    }

    private final void onPostDraw() {
        this.dirtyTracker = Bitmask.m14434constructorimpl$default(0, 1, null);
    }

    private final void invalidateIfNeeded() {
        final boolean zM14431anyimpl = Bitmask.m14431anyimpl(this.dirtyTracker, DirtyFields.InvalidateFlags);
        Log_androidKt.log(TAG, new Function0() { // from class: dev.chrisbanes.haze.HazeEffectNode$$ExternalSyntheticLambda19
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return HazeEffectNode.invalidateIfNeeded$lambda$48(zM14431anyimpl, this);
            }
        });
        if (zM14431anyimpl) {
            DrawModifierNodeKt.invalidateDraw(this);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String invalidateIfNeeded$lambda$48(boolean z, HazeEffectNode hazeEffectNode) {
        return "invalidateRequired=" + z + ". Dirty params=" + DirtyFields.INSTANCE.m14446stringifyAI7STRk(hazeEffectNode.dirtyTracker);
    }
}
