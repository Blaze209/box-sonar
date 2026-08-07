package dev.chrisbanes.haze;

import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import androidx.compose.runtime.snapshots.Snapshot;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.OffsetKt;
import androidx.compose.ui.geometry.Size;
import androidx.compose.ui.graphics.GraphicsContext;
import androidx.compose.ui.graphics.drawscope.ContentDrawScope;
import androidx.compose.ui.graphics.drawscope.DrawScope;
import androidx.compose.ui.graphics.layer.GraphicsLayer;
import androidx.compose.ui.graphics.layer.GraphicsLayerKt;
import androidx.compose.ui.layout.LayoutCoordinates;
import androidx.compose.ui.modifier.ModifierLocalMap;
import androidx.compose.ui.modifier.ModifierLocalModifierNode;
import androidx.compose.ui.modifier.ModifierLocalModifierNodeKt;
import androidx.compose.ui.node.CompositionLocalConsumerModifierNode;
import androidx.compose.ui.node.CompositionLocalConsumerModifierNodeKt;
import androidx.compose.ui.node.DrawModifierNode;
import androidx.compose.ui.node.GlobalPositionAwareModifierNode;
import androidx.compose.ui.node.LayoutAwareModifierNode;
import androidx.compose.ui.node.ObserverModifierNode;
import androidx.compose.ui.node.ObserverModifierNodeKt;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.unit.IntSizeKt;
import com.facebook.react.uimanager.ViewProps;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: HazeSourceNode.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000l\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0007\u0018\u0000 :2\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u00042\u00020\u00052\u00020\u00062\u00020\u0007:\u0001:B%\u0012\u0006\u0010\b\u001a\u00020\t\u0012\b\b\u0002\u0010\n\u001a\u00020\u000b\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\r¢\u0006\u0004\b\u000e\u0010\u000fJ\b\u0010*\u001a\u00020+H\u0016J\b\u0010,\u001a\u00020+H\u0016J\b\u0010-\u001a\u00020+H\u0002J\u0010\u0010.\u001a\u00020+2\u0006\u0010/\u001a\u000200H\u0016J\u0010\u00101\u001a\u00020+2\u0006\u0010/\u001a\u000200H\u0016J\u0018\u00102\u001a\u00020+2\u0006\u0010/\u001a\u0002002\u0006\u00103\u001a\u000204H\u0002J\f\u00105\u001a\u00020+*\u000206H\u0016J\b\u00107\u001a\u00020+H\u0016J\b\u00108\u001a\u00020+H\u0016J\f\u00109\u001a\u00020+*\u00020\u0015H\u0002R\u0014\u0010\u0010\u001a\u00020\u0011X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u000e\u0010\u0014\u001a\u00020\u0015X\u0082\u0004¢\u0006\u0002\n\u0000R+\u0010\n\u001a\u00020\u000b2\u0006\u0010\u0016\u001a\u00020\u000b8F@FX\u0086\u008e\u0002¢\u0006\u0012\n\u0004\b\u001b\u0010\u001c\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR$\u0010\b\u001a\u00020\t2\u0006\u0010\u001d\u001a\u00020\t@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010!R(\u0010\f\u001a\u0004\u0018\u00010\r2\b\u0010\u001d\u001a\u0004\u0018\u00010\r8F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b\"\u0010#\"\u0004\b$\u0010%R\u0014\u0010&\u001a\u00020'X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b(\u0010)¨\u0006;"}, d2 = {"Ldev/chrisbanes/haze/HazeSourceNode;", "Landroidx/compose/ui/Modifier$Node;", "Landroidx/compose/ui/node/CompositionLocalConsumerModifierNode;", "Landroidx/compose/ui/node/GlobalPositionAwareModifierNode;", "Landroidx/compose/ui/node/LayoutAwareModifierNode;", "Landroidx/compose/ui/node/DrawModifierNode;", "Landroidx/compose/ui/node/ObserverModifierNode;", "Landroidx/compose/ui/modifier/ModifierLocalModifierNode;", "state", "Ldev/chrisbanes/haze/HazeState;", ViewProps.Z_INDEX, "", "key", "", "<init>", "(Ldev/chrisbanes/haze/HazeState;FLjava/lang/Object;)V", "providedValues", "Landroidx/compose/ui/modifier/ModifierLocalMap;", "getProvidedValues", "()Landroidx/compose/ui/modifier/ModifierLocalMap;", "area", "Ldev/chrisbanes/haze/HazeArea;", "<set-?>", "getZIndex", "()F", "setZIndex", "(F)V", "zIndex$delegate", "Landroidx/compose/runtime/MutableState;", "value", "getState", "()Ldev/chrisbanes/haze/HazeState;", "setState", "(Ldev/chrisbanes/haze/HazeState;)V", "getKey", "()Ljava/lang/Object;", "setKey", "(Ljava/lang/Object;)V", "shouldAutoInvalidate", "", "getShouldAutoInvalidate", "()Z", "onAttach", "", "onObservedReadsChanged", "updateCompoundZIndex", "onPlaced", "coordinates", "Landroidx/compose/ui/layout/LayoutCoordinates;", "onGloballyPositioned", "onPositioned", "source", "", "draw", "Landroidx/compose/ui/graphics/drawscope/ContentDrawScope;", "onDetach", "onReset", "reset", "Companion", "haze_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
@ExperimentalHazeApi
public final class HazeSourceNode extends Modifier.Node implements CompositionLocalConsumerModifierNode, GlobalPositionAwareModifierNode, LayoutAwareModifierNode, DrawModifierNode, ObserverModifierNode, ModifierLocalModifierNode {

    @Deprecated
    public static final String TAG = "HazeSource";
    private final HazeArea area;
    private final ModifierLocalMap providedValues;
    private final boolean shouldAutoInvalidate;
    private HazeState state;

    /* JADX INFO: renamed from: zIndex$delegate, reason: from kotlin metadata */
    private final MutableState zIndex;
    private static final Companion Companion = new Companion(null);
    public static final int $stable = 8;

    public /* synthetic */ HazeSourceNode(HazeState hazeState, float f, Object obj, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(hazeState, (i & 2) != 0 ? 0.0f : f, (i & 4) != 0 ? null : obj);
    }

    public HazeSourceNode(HazeState state, float f, Object obj) {
        Intrinsics.checkNotNullParameter(state, "state");
        this.providedValues = ModifierLocalModifierNodeKt.modifierLocalMapOf(TuplesKt.to(HazeEffectNodeKt.getModifierLocalCurrentHazeZIndex(), Float.valueOf(f)));
        this.area = new HazeArea();
        this.zIndex = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(Float.valueOf(f), null, 2, null);
        this.state = state;
        setKey(obj);
    }

    @Override // androidx.compose.ui.modifier.ModifierLocalModifierNode
    public ModifierLocalMap getProvidedValues() {
        return this.providedValues;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final float getZIndex() {
        return ((Number) this.zIndex.getValue()).floatValue();
    }

    public final void setZIndex(float f) {
        this.zIndex.setValue(Float.valueOf(f));
    }

    public final HazeState getState() {
        return this.state;
    }

    public final void setState(HazeState value) {
        Intrinsics.checkNotNullParameter(value, "value");
        boolean zContains = this.state.getAreas().contains(this.area);
        if (zContains) {
            this.state.removeArea$haze_release(this.area);
        }
        this.state = value;
        if (zContains) {
            value.addArea$haze_release(this.area);
        }
    }

    public final Object getKey() {
        return this.area.getKey();
    }

    public final void setKey(Object obj) {
        this.area.setKey$haze_release(obj);
    }

    @Override // androidx.compose.ui.Modifier.Node
    public boolean getShouldAutoInvalidate() {
        return this.shouldAutoInvalidate;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String onAttach$lambda$0(HazeSourceNode hazeSourceNode) {
        return "onAttach. Adding HazeArea: " + hazeSourceNode.area;
    }

    @Override // androidx.compose.ui.Modifier.Node
    public void onAttach() {
        Log_androidKt.log(TAG, new Function0() { // from class: dev.chrisbanes.haze.HazeSourceNode$$ExternalSyntheticLambda1
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return HazeSourceNode.onAttach$lambda$0(this.f$0);
            }
        });
        this.state.addArea$haze_release(this.area);
        onObservedReadsChanged();
    }

    @Override // androidx.compose.ui.node.ObserverModifierNode
    public void onObservedReadsChanged() {
        ObserverModifierNodeKt.observeReads(this, new Function0() { // from class: dev.chrisbanes.haze.HazeSourceNode$$ExternalSyntheticLambda5
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return HazeSourceNode.onObservedReadsChanged$lambda$1(this.f$0);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit onObservedReadsChanged$lambda$1(HazeSourceNode hazeSourceNode) {
        hazeSourceNode.updateCompoundZIndex();
        return Unit.INSTANCE;
    }

    private final void updateCompoundZIndex() {
        final Float f = (Float) getCurrent(HazeEffectNodeKt.getModifierLocalCurrentHazeZIndex());
        final float fFloatValue = (f != null ? f.floatValue() : 0.0f) + getZIndex();
        Log_androidKt.log(TAG, new Function0() { // from class: dev.chrisbanes.haze.HazeSourceNode$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return HazeSourceNode.updateCompoundZIndex$lambda$2(f, this, fFloatValue);
            }
        });
        provide(HazeEffectNodeKt.getModifierLocalCurrentHazeZIndex(), Float.valueOf(fFloatValue));
        this.area.setZIndex$haze_release(fFloatValue);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String updateCompoundZIndex$lambda$2(Float f, HazeSourceNode hazeSourceNode, float f2) {
        return "updateCompoundZIndex(). Upstream=" + f + ", zIndex=" + hazeSourceNode.getZIndex() + ". Resulting compound=" + f2;
    }

    @Override // androidx.compose.ui.node.LayoutAwareModifierNode
    public void onPlaced(LayoutCoordinates coordinates) {
        Intrinsics.checkNotNullParameter(coordinates, "coordinates");
        Snapshot.Companion companion = Snapshot.INSTANCE;
        Snapshot currentThreadSnapshot = companion.getCurrentThreadSnapshot();
        Function1<Object, Unit> readObserver = currentThreadSnapshot != null ? currentThreadSnapshot.getReadObserver() : null;
        Snapshot snapshotMakeCurrentNonObservable = companion.makeCurrentNonObservable(currentThreadSnapshot);
        try {
            if (OffsetKt.m6590isUnspecifiedk4lQ0M(this.area.m14447getPositionOnScreenF1C5BW0())) {
                onPositioned(coordinates, "onPlaced");
            }
            Unit unit = Unit.INSTANCE;
        } finally {
            companion.restoreNonObservable(currentThreadSnapshot, snapshotMakeCurrentNonObservable, readObserver);
        }
    }

    @Override // androidx.compose.ui.node.GlobalPositionAwareModifierNode
    public void onGloballyPositioned(LayoutCoordinates coordinates) {
        Intrinsics.checkNotNullParameter(coordinates, "coordinates");
        onPositioned(coordinates, "onGloballyPositioned");
    }

    private final void onPositioned(LayoutCoordinates coordinates, final String source) {
        this.area.m14449setPositionOnScreenk4lQ0M$haze_release(UtilsKt.positionOnScreenCatching(coordinates));
        this.area.m14450setSizeuvyYCjk$haze_release(IntSizeKt.m9870toSizeozmzZPI(coordinates.mo8273getSizeYbymL2g()));
        Log_androidKt.log(TAG, new Function0() { // from class: dev.chrisbanes.haze.HazeSourceNode$$ExternalSyntheticLambda4
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return HazeSourceNode.onPositioned$lambda$4(source, this);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String onPositioned$lambda$4(String str, HazeSourceNode hazeSourceNode) {
        return str + ": positionOnScreen=" + Offset.m6577toStringimpl(hazeSourceNode.area.m14447getPositionOnScreenF1C5BW0()) + ", size=" + Size.m6642toStringimpl(hazeSourceNode.area.m14448getSizeNHjbRc()) + ", positionOnScreens=" + Offset.m6577toStringimpl(hazeSourceNode.area.m14447getPositionOnScreenF1C5BW0());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String draw$lambda$5() {
        return "start draw()";
    }

    /* JADX WARN: Code duplicated, block: B:12:0x0040  */
    @Override // androidx.compose.ui.node.DrawModifierNode
    public void draw(final ContentDrawScope contentDrawScope) {
        Intrinsics.checkNotNullParameter(contentDrawScope, "<this>");
        Log_androidKt.log(TAG, new Function0() { // from class: dev.chrisbanes.haze.HazeSourceNode$$ExternalSyntheticLambda6
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return HazeSourceNode.draw$lambda$5();
            }
        });
        this.area.setContentDrawing$haze_release(true);
        ContentDrawScope contentDrawScope2 = contentDrawScope;
        if (RenderEffect_androidKt.canUseGraphicLayers(contentDrawScope2)) {
            GraphicsContext graphicsContext = (GraphicsContext) CompositionLocalConsumerModifierNodeKt.currentValueOf(this, CompositionLocalsKt.getLocalGraphicsContext());
            GraphicsLayer contentLayer = this.area.getContentLayer();
            if (contentLayer != null) {
                if (contentLayer.getIsReleased()) {
                    contentLayer = null;
                }
                if (contentLayer == null) {
                    contentLayer = graphicsContext.createGraphicsLayer();
                    this.area.setContentLayer$haze_release(contentLayer);
                }
            } else {
                contentLayer = graphicsContext.createGraphicsLayer();
                this.area.setContentLayer$haze_release(contentLayer);
            }
            GraphicsLayer graphicsLayer = contentLayer;
            DrawScope.m7393recordJVtK1S4$default(contentDrawScope2, graphicsLayer, 0L, new Function1() { // from class: dev.chrisbanes.haze.HazeSourceNode$$ExternalSyntheticLambda7
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    return HazeSourceNode.draw$lambda$8(contentDrawScope, (DrawScope) obj);
                }
            }, 1, null);
            GraphicsLayerKt.drawLayer(contentDrawScope2, graphicsLayer);
        } else {
            contentDrawScope.drawContent();
        }
        this.area.setContentDrawing$haze_release(false);
        Log_androidKt.log(TAG, new Function0() { // from class: dev.chrisbanes.haze.HazeSourceNode$$ExternalSyntheticLambda8
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return HazeSourceNode.draw$lambda$9();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit draw$lambda$8(ContentDrawScope contentDrawScope, DrawScope record) {
        Intrinsics.checkNotNullParameter(record, "$this$record");
        contentDrawScope.drawContent();
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String draw$lambda$9() {
        return "end draw()";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String onDetach$lambda$10(HazeSourceNode hazeSourceNode) {
        return "onDetach. Removing HazeArea: " + hazeSourceNode.area;
    }

    @Override // androidx.compose.ui.Modifier.Node
    public void onDetach() {
        Log_androidKt.log(TAG, new Function0() { // from class: dev.chrisbanes.haze.HazeSourceNode$$ExternalSyntheticLambda3
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return HazeSourceNode.onDetach$lambda$10(this.f$0);
            }
        });
        reset(this.area);
        this.state.removeArea$haze_release(this.area);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String onReset$lambda$11(HazeSourceNode hazeSourceNode) {
        return "onReset. Resetting HazeArea: " + hazeSourceNode.area;
    }

    @Override // androidx.compose.ui.Modifier.Node
    public void onReset() {
        Log_androidKt.log(TAG, new Function0() { // from class: dev.chrisbanes.haze.HazeSourceNode$$ExternalSyntheticLambda2
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return HazeSourceNode.onReset$lambda$11(this.f$0);
            }
        });
        reset(this.area);
    }

    private final void reset(HazeArea hazeArea) {
        hazeArea.m14449setPositionOnScreenk4lQ0M$haze_release(Offset.INSTANCE.m6584getUnspecifiedF1C5BW0());
        hazeArea.m14450setSizeuvyYCjk$haze_release(Size.INSTANCE.m6646getUnspecifiedNHjbRc());
        hazeArea.setContentDrawing$haze_release(false);
        GraphicsLayer contentLayer = hazeArea.getContentLayer();
        if (contentLayer != null) {
            ((GraphicsContext) CompositionLocalConsumerModifierNodeKt.currentValueOf(this, CompositionLocalsKt.getLocalGraphicsContext())).releaseGraphicsLayer(contentLayer);
        }
        hazeArea.setContentLayer$haze_release(null);
    }

    /* JADX INFO: compiled from: HazeSourceNode.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0082\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Ldev/chrisbanes/haze/HazeSourceNode$Companion;", "", "<init>", "()V", "TAG", "", "haze_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    private static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }
}
