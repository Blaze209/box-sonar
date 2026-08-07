package androidx.compose.ui.platform;

import android.os.Build;
import androidx.compose.ui.FrameRateCategory;
import androidx.compose.ui.geometry.MutableRect;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.SizeKt;
import androidx.compose.ui.graphics.Canvas;
import androidx.compose.ui.graphics.CompositingStrategy;
import androidx.compose.ui.graphics.Fields;
import androidx.compose.ui.graphics.GraphicsContext;
import androidx.compose.ui.graphics.Matrix;
import androidx.compose.ui.graphics.MatrixKt;
import androidx.compose.ui.graphics.Outline;
import androidx.compose.ui.graphics.ReusableGraphicsLayerScope;
import androidx.compose.ui.graphics.TransformOrigin;
import androidx.compose.ui.graphics.drawscope.CanvasDrawScope;
import androidx.compose.ui.graphics.drawscope.DrawContext;
import androidx.compose.ui.graphics.drawscope.DrawScope;
import androidx.compose.ui.graphics.layer.GraphicsLayer;
import androidx.compose.ui.graphics.layer.GraphicsLayerKt;
import androidx.compose.ui.internal.InlineClassHelperKt;
import androidx.compose.ui.layout.GraphicLayerInfo;
import androidx.compose.ui.node.OwnedLayer;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.DensityKt;
import androidx.compose.ui.unit.IntSize;
import androidx.compose.ui.unit.IntSizeKt;
import androidx.compose.ui.unit.LayoutDirection;
import com.box.android.domain.analytics.BoxAmplitudeAnalytics;
import com.facebook.react.uimanager.ViewProps;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: GraphicsLayerOwnerLayer.android.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(d1 = {"\u0000º\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0007\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\t\n\u0002\b\r\b\u0001\u0018\u00002\u00020\u00012\u00020\u0002Bi\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u00128\u0010\t\u001a4\u0012\u0013\u0012\u00110\u000b¢\u0006\f\b\f\u0012\b\b\r\u0012\u0004\b\b(\u000e\u0012\u0015\u0012\u0013\u0018\u00010\u0004¢\u0006\f\b\f\u0012\b\b\r\u0012\u0004\b\b(\u000f\u0012\u0004\u0012\u00020\u00100\n\u0012\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00100\u0012¢\u0006\u0004\b\u0013\u0010\u0014J\u0010\u0010:\u001a\u00020\u00102\u0006\u0010&\u001a\u00020;H\u0016J\b\u0010<\u001a\u00020\u0010H\u0002J\b\u0010=\u001a\u00020\u0010H\u0002J\u0017\u0010>\u001a\u00020\u00192\u0006\u0010?\u001a\u00020@H\u0016¢\u0006\u0004\bA\u0010BJ\u0017\u0010C\u001a\u00020\u00102\u0006\u0010?\u001a\u00020DH\u0016¢\u0006\u0004\bE\u0010FJ\u0017\u0010G\u001a\u00020\u00102\u0006\u0010\u0015\u001a\u00020\u0016H\u0016¢\u0006\u0004\bH\u0010FJ\u001a\u0010J\u001a\u00020\u00102\u0006\u0010\u000e\u001a\u00020\u000b2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0004H\u0016J\b\u0010K\u001a\u00020\u0010H\u0016J\b\u0010P\u001a\u00020\u0010H\u0016J\b\u0010Q\u001a\u00020\u0010H\u0016J\u001f\u0010R\u001a\u00020@2\u0006\u0010S\u001a\u00020@2\u0006\u0010T\u001a\u00020\u0019H\u0016¢\u0006\u0004\bU\u0010VJ\u0018\u0010W\u001a\u00020\u00102\u0006\u0010X\u001a\u00020Y2\u0006\u0010T\u001a\u00020\u0019H\u0016JP\u0010Z\u001a\u00020\u001028\u0010\t\u001a4\u0012\u0013\u0012\u00110\u000b¢\u0006\f\b\f\u0012\b\b\r\u0012\u0004\b\b(\u000e\u0012\u0015\u0012\u0013\u0018\u00010\u0004¢\u0006\f\b\f\u0012\b\b\r\u0012\u0004\b\b(\u000f\u0012\u0004\u0012\u00020\u00100\n2\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00100\u0012H\u0016J\u0017\u0010[\u001a\u00020\u00102\u0006\u0010\\\u001a\u00020\u001bH\u0016¢\u0006\u0004\b]\u0010^J\u0017\u0010_\u001a\u00020\u00102\u0006\u0010\\\u001a\u00020\u001bH\u0016¢\u0006\u0004\b`\u0010^J\u000f\u0010g\u001a\u00020\u001bH\u0002¢\u0006\u0004\bh\u0010iJ\u0011\u0010l\u001a\u0004\u0018\u00010\u001bH\u0002¢\u0006\u0004\bm\u0010iJ\b\u0010n\u001a\u00020\u0010H\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000RB\u0010\t\u001a6\u0012\u0013\u0012\u00110\u000b¢\u0006\f\b\f\u0012\b\b\r\u0012\u0004\b\b(\u000e\u0012\u0015\u0012\u0013\u0018\u00010\u0004¢\u0006\f\b\f\u0012\b\b\r\u0012\u0004\b\b(\u000f\u0012\u0004\u0012\u00020\u0010\u0018\u00010\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\u0011\u001a\n\u0012\u0004\u0012\u00020\u0010\u0018\u00010\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0015\u001a\u00020\u0016X\u0082\u000e¢\u0006\u0004\n\u0002\u0010\u0017R\u000e\u0010\u0018\u001a\u00020\u0019X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001a\u001a\u00020\u001bX\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u001cR\u0012\u0010\u001d\u001a\u0004\u0018\u00010\u001bX\u0082\u000e¢\u0006\u0004\n\u0002\u0010\u001cR\u001e\u0010\u001f\u001a\u00020\u00192\u0006\u0010\u001e\u001a\u00020\u0019@BX\u0082\u000e¢\u0006\b\n\u0000\"\u0004\b \u0010!R\u000e\u0010\"\u001a\u00020#X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010$\u001a\u00020%X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010&\u001a\u00020'X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010(\u001a\u00020)X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010*\u001a\u00020+X\u0082\u000e¢\u0006\u0004\n\u0002\u0010\u0017R\u0010\u0010,\u001a\u0004\u0018\u00010-X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010.\u001a\u00020\u0019X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010/\u001a\u00020\u0019X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u00100\u001a\u00020\u0019X\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u00101\u001a\u000202X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b3\u00104\"\u0004\b5\u00106R\u001a\u00107\u001a\u00020\u0019X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b7\u00108\"\u0004\b9\u0010!R\u000e\u0010I\u001a\u00020\u0019X\u0082\u000e¢\u0006\u0002\n\u0000R\u001f\u0010L\u001a\u0013\u0012\u0004\u0012\u00020N\u0012\u0004\u0012\u00020\u00100M¢\u0006\u0002\bOX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010a\u001a\u00020b8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\bc\u0010dR\u0014\u0010e\u001a\u00020b8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\bf\u0010dR\u0014\u0010j\u001a\u00020\u001b8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\bk\u0010i¨\u0006o"}, d2 = {"Landroidx/compose/ui/platform/GraphicsLayerOwnerLayer;", "Landroidx/compose/ui/node/OwnedLayer;", "Landroidx/compose/ui/layout/GraphicLayerInfo;", "graphicsLayer", "Landroidx/compose/ui/graphics/layer/GraphicsLayer;", "context", "Landroidx/compose/ui/graphics/GraphicsContext;", "ownerView", "Landroidx/compose/ui/platform/AndroidComposeView;", "drawBlock", "Lkotlin/Function2;", "Landroidx/compose/ui/graphics/Canvas;", "Lkotlin/ParameterName;", "name", "canvas", "parentLayer", "", "invalidateParentLayer", "Lkotlin/Function0;", "<init>", "(Landroidx/compose/ui/graphics/layer/GraphicsLayer;Landroidx/compose/ui/graphics/GraphicsContext;Landroidx/compose/ui/platform/AndroidComposeView;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function0;)V", "size", "Landroidx/compose/ui/unit/IntSize;", "J", "isDestroyed", "", "matrixCache", "Landroidx/compose/ui/graphics/Matrix;", "[F", "inverseMatrixCache", "value", "isDirty", "setDirty", "(Z)V", "density", "Landroidx/compose/ui/unit/Density;", ViewProps.LAYOUT_DIRECTION, "Landroidx/compose/ui/unit/LayoutDirection;", "scope", "Landroidx/compose/ui/graphics/drawscope/CanvasDrawScope;", "mutatedFields", "", ViewProps.TRANSFORM_ORIGIN, "Landroidx/compose/ui/graphics/TransformOrigin;", "outline", "Landroidx/compose/ui/graphics/Outline;", "isMatrixDirty", "isInverseMatrixDirty", "isIdentity", "frameRate", "", "getFrameRate", "()F", "setFrameRate", "(F)V", "isFrameRateFromParent", "()Z", "setFrameRateFromParent", "updateLayerProperties", "Landroidx/compose/ui/graphics/ReusableGraphicsLayerScope;", "triggerRepaint", "updateOutline", "isInLayer", ViewProps.POSITION, "Landroidx/compose/ui/geometry/Offset;", "isInLayer-k-4lQ0M", "(J)Z", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_MOVE_JOB, "Landroidx/compose/ui/unit/IntOffset;", "move--gyyYBs", "(J)V", "resize", "resize-ozmzZPI", "drawnWithEnabledZ", "drawLayer", "updateDisplayList", "recordLambda", "Lkotlin/Function1;", "Landroidx/compose/ui/graphics/drawscope/DrawScope;", "Lkotlin/ExtensionFunctionType;", "invalidate", "destroy", "mapOffset", "point", "inverse", "mapOffset-8S9VItk", "(JZ)J", "mapBounds", "rect", "Landroidx/compose/ui/geometry/MutableRect;", "reuseLayer", ViewProps.TRANSFORM, "matrix", "transform-58bKbWc", "([F)V", "inverseTransform", "inverseTransform-58bKbWc", "layerId", "", "getLayerId", "()J", "ownerViewId", "getOwnerViewId", "getMatrix", "getMatrix-sQKQjiQ", "()[F", "underlyingMatrix", "getUnderlyingMatrix-sQKQjiQ", "getInverseMatrix", "getInverseMatrix-3i98HWw", "updateMatrix", "ui"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class GraphicsLayerOwnerLayer implements OwnedLayer, GraphicLayerInfo {
    public static final int $stable = 8;
    private final GraphicsContext context;
    private Function2<? super Canvas, ? super GraphicsLayer, Unit> drawBlock;
    private boolean drawnWithEnabledZ;
    private float frameRate;
    private GraphicsLayer graphicsLayer;
    private Function0<Unit> invalidateParentLayer;
    private float[] inverseMatrixCache;
    private boolean isDestroyed;
    private boolean isDirty;
    private boolean isFrameRateFromParent;
    private boolean isInverseMatrixDirty;
    private boolean isMatrixDirty;
    private int mutatedFields;
    private Outline outline;
    private final AndroidComposeView ownerView;
    private long size;
    private final float[] matrixCache = Matrix.m7060constructorimpl$default(null, 1, null);
    private Density density = DensityKt.Density$default(1.0f, 0.0f, 2, null);
    private LayoutDirection layoutDirection = LayoutDirection.Ltr;
    private final CanvasDrawScope scope = new CanvasDrawScope();
    private long transformOrigin = TransformOrigin.INSTANCE.m7229getCenterSzJe1aQ();
    private boolean isIdentity = true;
    private final Function1<DrawScope, Unit> recordLambda = new Function1<DrawScope, Unit>() { // from class: androidx.compose.ui.platform.GraphicsLayerOwnerLayer$recordLambda$1
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
            GraphicsLayerOwnerLayer graphicsLayerOwnerLayer = this.this$0;
            Canvas canvas = drawScope.getDrawContext().getCanvas();
            Function2 function2 = graphicsLayerOwnerLayer.drawBlock;
            if (function2 != null) {
                function2.invoke(canvas, drawScope.getDrawContext().getGraphicsLayer());
            }
        }
    };

    public GraphicsLayerOwnerLayer(GraphicsLayer graphicsLayer, GraphicsContext graphicsContext, AndroidComposeView androidComposeView, Function2<? super Canvas, ? super GraphicsLayer, Unit> function2, Function0<Unit> function0) {
        this.graphicsLayer = graphicsLayer;
        this.context = graphicsContext;
        this.ownerView = androidComposeView;
        this.drawBlock = function2;
        this.invalidateParentLayer = function0;
        long j = Integer.MAX_VALUE;
        this.size = IntSize.m9853constructorimpl((j & 4294967295L) | (j << 32));
    }

    private final void setDirty(boolean z) {
        if (z != this.isDirty) {
            this.isDirty = z;
            this.ownerView.notifyLayerIsDirty$ui(this, z);
        }
    }

    @Override // androidx.compose.ui.node.OwnedLayer
    public float getFrameRate() {
        return this.frameRate;
    }

    @Override // androidx.compose.ui.node.OwnedLayer
    public void setFrameRate(float f) {
        this.frameRate = f;
    }

    @Override // androidx.compose.ui.node.OwnedLayer
    /* JADX INFO: renamed from: isFrameRateFromParent, reason: from getter */
    public boolean getIsFrameRateFromParent() {
        return this.isFrameRateFromParent;
    }

    @Override // androidx.compose.ui.node.OwnedLayer
    public void setFrameRateFromParent(boolean z) {
        this.isFrameRateFromParent = z;
    }

    @Override // androidx.compose.ui.node.OwnedLayer
    public void updateLayerProperties(ReusableGraphicsLayerScope scope) {
        int iM7476getModulateAlphake2Ky5w;
        Function0<Unit> function0;
        int mutatedFields = scope.getMutatedFields() | this.mutatedFields;
        this.layoutDirection = scope.getLayoutDirection();
        this.density = scope.getGraphicsDensity();
        int i = mutatedFields & 4096;
        if (i != 0) {
            this.transformOrigin = scope.getTransformOrigin();
        }
        if ((mutatedFields & 1) != 0) {
            this.graphicsLayer.setScaleX(scope.getScaleX());
        }
        if ((mutatedFields & 2) != 0) {
            this.graphicsLayer.setScaleY(scope.getScaleY());
        }
        if ((mutatedFields & 4) != 0) {
            this.graphicsLayer.setAlpha(scope.getAlpha());
        }
        if ((mutatedFields & 8) != 0) {
            this.graphicsLayer.setTranslationX(scope.getTranslationX());
        }
        if ((mutatedFields & 16) != 0) {
            this.graphicsLayer.setTranslationY(scope.getTranslationY());
        }
        if ((mutatedFields & 32) != 0) {
            this.graphicsLayer.setShadowElevation(scope.getShadowElevation());
            if (scope.getShadowElevation() > 0.0f && !this.drawnWithEnabledZ && (function0 = this.invalidateParentLayer) != null) {
                function0.invoke();
            }
        }
        if ((mutatedFields & 64) != 0) {
            this.graphicsLayer.m7490setAmbientShadowColor8_81llA(scope.getAmbientShadowColor());
        }
        if ((mutatedFields & 128) != 0) {
            this.graphicsLayer.m7496setSpotShadowColor8_81llA(scope.getSpotShadowColor());
        }
        if ((mutatedFields & 1024) != 0) {
            this.graphicsLayer.setRotationZ(scope.getRotationZ());
        }
        if ((mutatedFields & 256) != 0) {
            this.graphicsLayer.setRotationX(scope.getRotationX());
        }
        if ((mutatedFields & 512) != 0) {
            this.graphicsLayer.setRotationY(scope.getRotationY());
        }
        if ((mutatedFields & 2048) != 0) {
            this.graphicsLayer.setCameraDistance(scope.getCameraDistance());
        }
        if (i != 0) {
            if (TransformOrigin.m7223equalsimpl0(this.transformOrigin, TransformOrigin.INSTANCE.m7229getCenterSzJe1aQ())) {
                this.graphicsLayer.m7493setPivotOffsetk4lQ0M(Offset.INSTANCE.m6584getUnspecifiedF1C5BW0());
            } else {
                this.graphicsLayer.m7493setPivotOffsetk4lQ0M(Offset.m6561constructorimpl((((long) Float.floatToRawIntBits(TransformOrigin.m7225getPivotFractionYimpl(this.transformOrigin) * ((int) (this.size & 4294967295L)))) & 4294967295L) | (((long) Float.floatToRawIntBits(TransformOrigin.m7224getPivotFractionXimpl(this.transformOrigin) * ((int) (this.size >> 32)))) << 32)));
            }
        }
        if ((mutatedFields & 16384) != 0) {
            this.graphicsLayer.setClip(scope.getClip());
        }
        if ((131072 & mutatedFields) != 0) {
            this.graphicsLayer.setRenderEffect(scope.getRenderEffect());
        }
        if ((262144 & mutatedFields) != 0) {
            this.graphicsLayer.setColorFilter(scope.getColorFilter());
        }
        if ((524288 & mutatedFields) != 0) {
            this.graphicsLayer.m7491setBlendModes9anfk8(scope.getBlendMode());
        }
        if ((32768 & mutatedFields) != 0) {
            GraphicsLayer graphicsLayer = this.graphicsLayer;
            int compositingStrategy = scope.getCompositingStrategy();
            if (CompositingStrategy.m6901equalsimpl0(compositingStrategy, CompositingStrategy.INSTANCE.m6905getAutoNrFUSI())) {
                iM7476getModulateAlphake2Ky5w = androidx.compose.ui.graphics.layer.CompositingStrategy.INSTANCE.m7475getAutoke2Ky5w();
            } else if (CompositingStrategy.m6901equalsimpl0(compositingStrategy, CompositingStrategy.INSTANCE.m6907getOffscreenNrFUSI())) {
                iM7476getModulateAlphake2Ky5w = androidx.compose.ui.graphics.layer.CompositingStrategy.INSTANCE.m7477getOffscreenke2Ky5w();
            } else {
                if (!CompositingStrategy.m6901equalsimpl0(compositingStrategy, CompositingStrategy.INSTANCE.m6906getModulateAlphaNrFUSI())) {
                    throw new IllegalStateException("Not supported composition strategy");
                }
                iM7476getModulateAlphake2Ky5w = androidx.compose.ui.graphics.layer.CompositingStrategy.INSTANCE.m7476getModulateAlphake2Ky5w();
            }
            graphicsLayer.m7492setCompositingStrategyWpw9cng(iM7476getModulateAlphake2Ky5w);
        }
        boolean z = true;
        if ((mutatedFields & Fields.MatrixAffectingFields) != 0) {
            this.isMatrixDirty = true;
            this.isInverseMatrixDirty = true;
        }
        if (Intrinsics.areEqual(this.outline, scope.getOutline())) {
            z = false;
        } else {
            this.outline = scope.getOutline();
            updateOutline();
        }
        this.mutatedFields = scope.getMutatedFields();
        if (mutatedFields != 0 || z) {
            triggerRepaint();
            if (this.ownerView.getIsArrEnabled()) {
                this.ownerView.voteFrameRate(getFrameRate());
            }
        }
    }

    private final void triggerRepaint() {
        WrapperRenderNodeLayerHelperMethods.INSTANCE.onDescendantInvalidated(this.ownerView);
    }

    private final void updateOutline() {
        Function0<Unit> function0;
        Outline outline = this.outline;
        if (outline == null) {
            return;
        }
        GraphicsLayerKt.setOutline(this.graphicsLayer, outline);
        if (!(outline instanceof Outline.Generic) || Build.VERSION.SDK_INT >= 33 || (function0 = this.invalidateParentLayer) == null) {
            return;
        }
        function0.invoke();
    }

    @Override // androidx.compose.ui.node.OwnedLayer
    /* JADX INFO: renamed from: move--gyyYBs */
    public void mo8646movegyyYBs(long position) {
        if (this.ownerView.getIsArrEnabled()) {
            this.ownerView.voteFrameRate(FrameRateCategory.INSTANCE.m6297getHighNSsRyOo());
        }
        this.graphicsLayer.m7497setTopLeftgyyYBs(position);
        triggerRepaint();
    }

    @Override // androidx.compose.ui.node.OwnedLayer
    /* JADX INFO: renamed from: resize-ozmzZPI */
    public void mo8647resizeozmzZPI(long size) {
        if (IntSize.m9856equalsimpl0(size, this.size)) {
            return;
        }
        if (this.ownerView.getIsArrEnabled()) {
            this.ownerView.voteFrameRate(FrameRateCategory.INSTANCE.m6297getHighNSsRyOo());
        }
        this.size = size;
        invalidate();
    }

    @Override // androidx.compose.ui.node.OwnedLayer
    public void drawLayer(Canvas canvas, GraphicsLayer parentLayer) {
        updateDisplayList();
        this.drawnWithEnabledZ = this.graphicsLayer.getShadowElevation() > 0.0f;
        DrawContext drawContext = this.scope.getDrawContext();
        drawContext.setCanvas(canvas);
        drawContext.setGraphicsLayer(parentLayer);
        GraphicsLayerKt.drawLayer(this.scope, this.graphicsLayer);
    }

    @Override // androidx.compose.ui.node.OwnedLayer
    public void updateDisplayList() {
        if (this.ownerView.getIsArrEnabled() && getFrameRate() != 0.0f) {
            this.ownerView.voteFrameRate(getFrameRate());
        }
        if (this.isDirty) {
            if (!TransformOrigin.m7223equalsimpl0(this.transformOrigin, TransformOrigin.INSTANCE.m7229getCenterSzJe1aQ()) && !IntSize.m9856equalsimpl0(this.graphicsLayer.getSize(), this.size)) {
                GraphicsLayer graphicsLayer = this.graphicsLayer;
                float fM7224getPivotFractionXimpl = TransformOrigin.m7224getPivotFractionXimpl(this.transformOrigin) * ((int) (this.size >> 32));
                graphicsLayer.m7493setPivotOffsetk4lQ0M(Offset.m6561constructorimpl((((long) Float.floatToRawIntBits(TransformOrigin.m7225getPivotFractionYimpl(this.transformOrigin) * ((int) (this.size & 4294967295L)))) & 4294967295L) | (Float.floatToRawIntBits(fM7224getPivotFractionXimpl) << 32)));
            }
            this.graphicsLayer.m7489recordmLhObY(this.density, this.layoutDirection, this.size, this.recordLambda);
            setDirty(false);
        }
    }

    @Override // androidx.compose.ui.node.OwnedLayer
    public void invalidate() {
        if (this.isDirty || this.isDestroyed) {
            return;
        }
        this.ownerView.invalidate();
        setDirty(true);
    }

    @Override // androidx.compose.ui.node.OwnedLayer
    public void destroy() {
        setFrameRate(0.0f);
        setFrameRateFromParent(false);
        this.drawBlock = null;
        this.invalidateParentLayer = null;
        this.isDestroyed = true;
        setDirty(false);
        GraphicsContext graphicsContext = this.context;
        if (graphicsContext != null) {
            graphicsContext.releaseGraphicsLayer(this.graphicsLayer);
            this.ownerView.recycle$ui(this);
        }
    }

    @Override // androidx.compose.ui.node.OwnedLayer
    /* JADX INFO: renamed from: mapOffset-8S9VItk */
    public long mo8645mapOffset8S9VItk(long point, boolean inverse) {
        float[] fArrM8767getMatrixsQKQjiQ;
        if (inverse) {
            fArrM8767getMatrixsQKQjiQ = m8766getInverseMatrix3i98HWw();
            if (fArrM8767getMatrixsQKQjiQ == null) {
                return Offset.INSTANCE.m6583getInfiniteF1C5BW0();
            }
        } else {
            fArrM8767getMatrixsQKQjiQ = m8767getMatrixsQKQjiQ();
        }
        return this.isIdentity ? point : Matrix.m7066mapMKHz9U(fArrM8767getMatrixsQKQjiQ, point);
    }

    @Override // androidx.compose.ui.node.OwnedLayer
    public void mapBounds(MutableRect rect, boolean inverse) {
        float[] fArrM8766getInverseMatrix3i98HWw = inverse ? m8766getInverseMatrix3i98HWw() : m8767getMatrixsQKQjiQ();
        if (this.isIdentity) {
            return;
        }
        if (fArrM8766getInverseMatrix3i98HWw == null) {
            rect.set(0.0f, 0.0f, 0.0f, 0.0f);
        } else {
            Matrix.m7068mapimpl(fArrM8766getInverseMatrix3i98HWw, rect);
        }
    }

    @Override // androidx.compose.ui.node.OwnedLayer
    public void reuseLayer(Function2<? super Canvas, ? super GraphicsLayer, Unit> drawBlock, Function0<Unit> invalidateParentLayer) {
        GraphicsContext graphicsContext = this.context;
        if (graphicsContext != null) {
            if (!this.graphicsLayer.getIsReleased()) {
                InlineClassHelperKt.throwIllegalArgumentException("layer should have been released before reuse");
            }
            this.graphicsLayer = graphicsContext.createGraphicsLayer();
            this.isDestroyed = false;
            this.drawBlock = drawBlock;
            this.invalidateParentLayer = invalidateParentLayer;
            this.isMatrixDirty = false;
            this.isInverseMatrixDirty = false;
            this.isIdentity = true;
            Matrix.m7069resetimpl(this.matrixCache);
            float[] fArr = this.inverseMatrixCache;
            if (fArr != null) {
                Matrix.m7069resetimpl(fArr);
            }
            this.transformOrigin = TransformOrigin.INSTANCE.m7229getCenterSzJe1aQ();
            this.drawnWithEnabledZ = false;
            long j = Integer.MAX_VALUE;
            this.size = IntSize.m9853constructorimpl((j & 4294967295L) | (j << 32));
            this.outline = null;
            this.mutatedFields = 0;
            return;
        }
        InlineClassHelperKt.throwIllegalStateExceptionForNullCheck("currently reuse is only supported when we manage the layer lifecycle");
        throw new KotlinNothingValueException();
    }

    @Override // androidx.compose.ui.node.OwnedLayer
    /* JADX INFO: renamed from: transform-58bKbWc */
    public void mo8648transform58bKbWc(float[] matrix) {
        Matrix.m7079timesAssign58bKbWc(matrix, m8767getMatrixsQKQjiQ());
    }

    @Override // androidx.compose.ui.node.OwnedLayer
    /* JADX INFO: renamed from: inverseTransform-58bKbWc */
    public void mo8643inverseTransform58bKbWc(float[] matrix) {
        float[] fArrM8766getInverseMatrix3i98HWw = m8766getInverseMatrix3i98HWw();
        if (fArrM8766getInverseMatrix3i98HWw != null) {
            Matrix.m7079timesAssign58bKbWc(matrix, fArrM8766getInverseMatrix3i98HWw);
        }
    }

    @Override // androidx.compose.ui.layout.GraphicLayerInfo
    public long getLayerId() {
        return this.graphicsLayer.getLayerId();
    }

    @Override // androidx.compose.ui.layout.GraphicLayerInfo
    public long getOwnerViewId() {
        return this.graphicsLayer.getOwnerViewId();
    }

    /* JADX INFO: renamed from: getMatrix-sQKQjiQ, reason: not valid java name */
    private final float[] m8767getMatrixsQKQjiQ() {
        updateMatrix();
        return this.matrixCache;
    }

    @Override // androidx.compose.ui.node.OwnedLayer
    /* JADX INFO: renamed from: getUnderlyingMatrix-sQKQjiQ */
    public float[] mo8642getUnderlyingMatrixsQKQjiQ() {
        return m8767getMatrixsQKQjiQ();
    }

    /* JADX INFO: renamed from: getInverseMatrix-3i98HWw, reason: not valid java name */
    private final float[] m8766getInverseMatrix3i98HWw() {
        float[] fArrM7060constructorimpl$default = this.inverseMatrixCache;
        if (fArrM7060constructorimpl$default == null) {
            fArrM7060constructorimpl$default = Matrix.m7060constructorimpl$default(null, 1, null);
            this.inverseMatrixCache = fArrM7060constructorimpl$default;
        }
        if (!this.isInverseMatrixDirty) {
            if (Float.isNaN(fArrM7060constructorimpl$default[0])) {
                return null;
            }
        } else {
            this.isInverseMatrixDirty = false;
            float[] fArrM8767getMatrixsQKQjiQ = m8767getMatrixsQKQjiQ();
            if (this.isIdentity) {
                return fArrM8767getMatrixsQKQjiQ;
            }
            if (!InvertMatrixKt.m8770invertToJiSxe2E(fArrM8767getMatrixsQKQjiQ, fArrM7060constructorimpl$default)) {
                fArrM7060constructorimpl$default[0] = Float.NaN;
                return null;
            }
        }
        return fArrM7060constructorimpl$default;
    }

    private final void updateMatrix() {
        long pivotOffset;
        if (this.isMatrixDirty) {
            GraphicsLayer graphicsLayer = this.graphicsLayer;
            if ((graphicsLayer.getPivotOffset() & 9223372034707292159L) == androidx.compose.ui.geometry.InlineClassHelperKt.UnspecifiedPackedFloats) {
                pivotOffset = SizeKt.m6648getCenteruvyYCjk(IntSizeKt.m9870toSizeozmzZPI(this.size));
            } else {
                pivotOffset = graphicsLayer.getPivotOffset();
            }
            Matrix.m7071resetToPivotedTransformimpl$default(this.matrixCache, Float.intBitsToFloat((int) (pivotOffset >> 32)), Float.intBitsToFloat((int) (pivotOffset & 4294967295L)), graphicsLayer.getTranslationX(), graphicsLayer.getTranslationY(), 0.0f, graphicsLayer.getRotationX(), graphicsLayer.getRotationY(), graphicsLayer.getRotationZ(), graphicsLayer.getScaleX(), graphicsLayer.getScaleY(), 0.0f, 1040, null);
            this.isMatrixDirty = false;
            this.isIdentity = MatrixKt.m7085isIdentity58bKbWc(this.matrixCache);
        }
    }

    @Override // androidx.compose.ui.node.OwnedLayer
    /* JADX INFO: renamed from: isInLayer-k-4lQ0M */
    public boolean mo8644isInLayerk4lQ0M(long position) {
        float fIntBitsToFloat = Float.intBitsToFloat((int) (position >> 32));
        float fIntBitsToFloat2 = Float.intBitsToFloat((int) (position & 4294967295L));
        if (this.graphicsLayer.getClip()) {
            return ShapeContainingUtilKt.isInOutline$default(this.graphicsLayer.getOutline(), fIntBitsToFloat, fIntBitsToFloat2, null, null, 24, null);
        }
        return true;
    }
}
