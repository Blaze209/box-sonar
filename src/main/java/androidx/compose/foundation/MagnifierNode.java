package androidx.compose.foundation;

import android.view.View;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.geometry.InlineClassHelperKt;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.graphics.drawscope.ContentDrawScope;
import androidx.compose.ui.layout.LayoutCoordinates;
import androidx.compose.ui.layout.LayoutCoordinatesKt;
import androidx.compose.ui.node.DelegatableNodeKt;
import androidx.compose.ui.node.DelegatableNode_androidKt;
import androidx.compose.ui.node.DrawModifierNode;
import androidx.compose.ui.node.GlobalPositionAwareModifierNode;
import androidx.compose.ui.node.ObserverModifierNode;
import androidx.compose.ui.node.ObserverModifierNodeKt;
import androidx.compose.ui.node.SemanticsModifierNode;
import androidx.compose.ui.semantics.SemanticsPropertyReceiver;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.DpSize;
import androidx.compose.ui.unit.IntSize;
import androidx.compose.ui.unit.IntSizeKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.channels.Channel;
import kotlinx.coroutines.channels.ChannelKt;
import kotlinx.coroutines.channels.ChannelResult;

/* JADX INFO: compiled from: Magnifier.android.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\u0090\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b#\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\b\u0001\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u00042\u00020\u0005B\u009b\u0001\u0012\u0017\u0010\u0006\u001a\u0013\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t0\u0007¢\u0006\u0002\b\n\u0012\u001b\b\u0002\u0010\u000b\u001a\u0015\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t\u0018\u00010\u0007¢\u0006\u0002\b\n\u0012\u0016\b\u0002\u0010\f\u001a\u0010\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u000e\u0018\u00010\u0007\u0012\b\b\u0002\u0010\u000f\u001a\u00020\u0010\u0012\b\b\u0002\u0010\u0011\u001a\u00020\u0012\u0012\b\b\u0002\u0010\u0013\u001a\u00020\r\u0012\b\b\u0002\u0010\u0014\u001a\u00020\u0015\u0012\b\b\u0002\u0010\u0016\u001a\u00020\u0015\u0012\b\b\u0002\u0010\u0017\u001a\u00020\u0012\u0012\b\b\u0002\u0010\u0018\u001a\u00020\u0019¢\u0006\u0004\b\u001a\u0010\u001bJ\u008f\u0001\u0010S\u001a\u00020\u000e2\u0017\u0010\u0006\u001a\u0013\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t0\u0007¢\u0006\u0002\b\n2\u0019\u0010\u000b\u001a\u0015\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t\u0018\u00010\u0007¢\u0006\u0002\b\n2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\r2\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0017\u001a\u00020\u00122\u0014\u0010\f\u001a\u0010\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u000e\u0018\u00010\u00072\u0006\u0010\u0018\u001a\u00020\u0019¢\u0006\u0004\bT\u0010UJ\b\u0010V\u001a\u00020\u000eH\u0016J\b\u0010W\u001a\u00020\u000eH\u0016J\b\u0010X\u001a\u00020\u000eH\u0016J\b\u0010Y\u001a\u00020\u000eH\u0002J\b\u0010Z\u001a\u00020\u000eH\u0002J\b\u0010[\u001a\u00020\u000eH\u0002J\f\u0010\\\u001a\u00020\u000e*\u00020]H\u0016J\u0010\u0010^\u001a\u00020\u000e2\u0006\u0010_\u001a\u00020BH\u0016J\f\u0010`\u001a\u00020\u000e*\u00020aH\u0016R+\u0010\u0006\u001a\u0013\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t0\u0007¢\u0006\u0002\b\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001fR-\u0010\u000b\u001a\u0015\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t\u0018\u00010\u0007¢\u0006\u0002\b\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b \u0010\u001d\"\u0004\b!\u0010\u001fR(\u0010\f\u001a\u0010\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u000e\u0018\u00010\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010\u001d\"\u0004\b#\u0010\u001fR\u001a\u0010\u000f\u001a\u00020\u0010X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b$\u0010%\"\u0004\b&\u0010'R\u001a\u0010\u0011\u001a\u00020\u0012X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b(\u0010)\"\u0004\b*\u0010+R\u001c\u0010\u0013\u001a\u00020\rX\u0086\u000e¢\u0006\u0010\n\u0002\u00100\u001a\u0004\b,\u0010-\"\u0004\b.\u0010/R\u001c\u0010\u0014\u001a\u00020\u0015X\u0086\u000e¢\u0006\u0010\n\u0002\u00103\u001a\u0004\b1\u0010%\"\u0004\b2\u0010'R\u001c\u0010\u0016\u001a\u00020\u0015X\u0086\u000e¢\u0006\u0010\n\u0002\u00103\u001a\u0004\b4\u0010%\"\u0004\b5\u0010'R\u001a\u0010\u0017\u001a\u00020\u0012X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b6\u0010)\"\u0004\b7\u0010+R\u001a\u0010\u0018\u001a\u00020\u0019X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b8\u00109\"\u0004\b:\u0010;R\u0010\u0010<\u001a\u0004\u0018\u00010=X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010>\u001a\u0004\u0018\u00010\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010?\u001a\u0004\u0018\u00010@X\u0082\u000e¢\u0006\u0002\n\u0000R/\u0010C\u001a\u0004\u0018\u00010B2\b\u0010A\u001a\u0004\u0018\u00010B8B@BX\u0082\u008e\u0002¢\u0006\u0012\n\u0004\bH\u0010I\u001a\u0004\bD\u0010E\"\u0004\bF\u0010GR\u0016\u0010J\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010KX\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010L\u001a\u00020\t8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\bM\u0010-R\u0010\u0010N\u001a\u00020\tX\u0082\u000e¢\u0006\u0004\n\u0002\u00100R\u0010\u0010O\u001a\u0004\u0018\u00010PX\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010Q\u001a\n\u0012\u0004\u0012\u00020\u000e\u0018\u00010RX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006b"}, d2 = {"Landroidx/compose/foundation/MagnifierNode;", "Landroidx/compose/ui/Modifier$Node;", "Landroidx/compose/ui/node/GlobalPositionAwareModifierNode;", "Landroidx/compose/ui/node/DrawModifierNode;", "Landroidx/compose/ui/node/SemanticsModifierNode;", "Landroidx/compose/ui/node/ObserverModifierNode;", "sourceCenter", "Lkotlin/Function1;", "Landroidx/compose/ui/unit/Density;", "Landroidx/compose/ui/geometry/Offset;", "Lkotlin/ExtensionFunctionType;", "magnifierCenter", "onSizeChanged", "Landroidx/compose/ui/unit/DpSize;", "", "zoom", "", "useTextDefault", "", "size", "cornerRadius", "Landroidx/compose/ui/unit/Dp;", "elevation", "clippingEnabled", "platformMagnifierFactory", "Landroidx/compose/foundation/PlatformMagnifierFactory;", "<init>", "(Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;FZJFFZLandroidx/compose/foundation/PlatformMagnifierFactory;Lkotlin/jvm/internal/DefaultConstructorMarker;)V", "getSourceCenter", "()Lkotlin/jvm/functions/Function1;", "setSourceCenter", "(Lkotlin/jvm/functions/Function1;)V", "getMagnifierCenter", "setMagnifierCenter", "getOnSizeChanged", "setOnSizeChanged", "getZoom", "()F", "setZoom", "(F)V", "getUseTextDefault", "()Z", "setUseTextDefault", "(Z)V", "getSize-MYxV2XQ", "()J", "setSize-EaSLcWc", "(J)V", "J", "getCornerRadius-D9Ej5fM", "setCornerRadius-0680j_4", "F", "getElevation-D9Ej5fM", "setElevation-0680j_4", "getClippingEnabled", "setClippingEnabled", "getPlatformMagnifierFactory", "()Landroidx/compose/foundation/PlatformMagnifierFactory;", "setPlatformMagnifierFactory", "(Landroidx/compose/foundation/PlatformMagnifierFactory;)V", "view", "Landroid/view/View;", "density", "magnifier", "Landroidx/compose/foundation/PlatformMagnifier;", "<set-?>", "Landroidx/compose/ui/layout/LayoutCoordinates;", "layoutCoordinates", "getLayoutCoordinates", "()Landroidx/compose/ui/layout/LayoutCoordinates;", "setLayoutCoordinates", "(Landroidx/compose/ui/layout/LayoutCoordinates;)V", "layoutCoordinates$delegate", "Landroidx/compose/runtime/MutableState;", "anchorPositionInRootState", "Landroidx/compose/runtime/State;", "anchorPositionInRoot", "getAnchorPositionInRoot-F1C5BW0", "sourceCenterInRoot", "previousSize", "Landroidx/compose/ui/unit/IntSize;", "drawSignalChannel", "Lkotlinx/coroutines/channels/Channel;", "update", "update-5F03MCQ", "(Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;FZJFFZLkotlin/jvm/functions/Function1;Landroidx/compose/foundation/PlatformMagnifierFactory;)V", "onAttach", "onDetach", "onObservedReadsChanged", "recreateMagnifier", "updateMagnifier", "updateSizeIfNecessary", "draw", "Landroidx/compose/ui/graphics/drawscope/ContentDrawScope;", "onGloballyPositioned", "coordinates", "applySemantics", "Landroidx/compose/ui/semantics/SemanticsPropertyReceiver;", "foundation"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class MagnifierNode extends Modifier.Node implements GlobalPositionAwareModifierNode, DrawModifierNode, SemanticsModifierNode, ObserverModifierNode {
    public static final int $stable = 8;
    private State<Offset> anchorPositionInRootState;
    private boolean clippingEnabled;
    private float cornerRadius;
    private Density density;
    private Channel<Unit> drawSignalChannel;
    private float elevation;

    /* JADX INFO: renamed from: layoutCoordinates$delegate, reason: from kotlin metadata */
    private final MutableState layoutCoordinates;
    private PlatformMagnifier magnifier;
    private Function1<? super Density, Offset> magnifierCenter;
    private Function1<? super DpSize, Unit> onSizeChanged;
    private PlatformMagnifierFactory platformMagnifierFactory;
    private IntSize previousSize;
    private long size;
    private Function1<? super Density, Offset> sourceCenter;
    private long sourceCenterInRoot;
    private boolean useTextDefault;
    private View view;
    private float zoom;

    public /* synthetic */ MagnifierNode(Function1 function1, Function1 function2, Function1 function3, float f, boolean z, long j, float f2, float f3, boolean z2, PlatformMagnifierFactory platformMagnifierFactory, DefaultConstructorMarker defaultConstructorMarker) {
        this(function1, function2, function3, f, z, j, f2, f3, z2, platformMagnifierFactory);
    }

    private MagnifierNode(Function1<? super Density, Offset> function1, Function1<? super Density, Offset> function2, Function1<? super DpSize, Unit> function3, float f, boolean z, long j, float f2, float f3, boolean z2, PlatformMagnifierFactory platformMagnifierFactory) {
        this.sourceCenter = function1;
        this.magnifierCenter = function2;
        this.onSizeChanged = function3;
        this.zoom = f;
        this.useTextDefault = z;
        this.size = j;
        this.cornerRadius = f2;
        this.elevation = f3;
        this.clippingEnabled = z2;
        this.platformMagnifierFactory = platformMagnifierFactory;
        this.layoutCoordinates = SnapshotStateKt.mutableStateOf(null, SnapshotStateKt.neverEqualPolicy());
        this.sourceCenterInRoot = Offset.INSTANCE.m6584getUnspecifiedF1C5BW0();
    }

    public final Function1<Density, Offset> getSourceCenter() {
        return this.sourceCenter;
    }

    public final void setSourceCenter(Function1<? super Density, Offset> function1) {
        this.sourceCenter = function1;
    }

    public final Function1<Density, Offset> getMagnifierCenter() {
        return this.magnifierCenter;
    }

    public final void setMagnifierCenter(Function1<? super Density, Offset> function1) {
        this.magnifierCenter = function1;
    }

    public final Function1<DpSize, Unit> getOnSizeChanged() {
        return this.onSizeChanged;
    }

    public final void setOnSizeChanged(Function1<? super DpSize, Unit> function1) {
        this.onSizeChanged = function1;
    }

    public final float getZoom() {
        return this.zoom;
    }

    public final void setZoom(float f) {
        this.zoom = f;
    }

    public final boolean getUseTextDefault() {
        return this.useTextDefault;
    }

    public final void setUseTextDefault(boolean z) {
        this.useTextDefault = z;
    }

    public /* synthetic */ MagnifierNode(Function1 function1, Function1 function2, Function1 function3, float f, boolean z, long j, float f2, float f3, boolean z2, PlatformMagnifierFactory platformMagnifierFactory, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(function1, (i & 2) != 0 ? null : function2, (i & 4) != 0 ? null : function3, (i & 8) != 0 ? Float.NaN : f, (i & 16) != 0 ? false : z, (i & 32) != 0 ? DpSize.INSTANCE.m9794getUnspecifiedMYxV2XQ() : j, (i & 64) != 0 ? Dp.INSTANCE.m9707getUnspecifiedD9Ej5fM() : f2, (i & 128) != 0 ? Dp.INSTANCE.m9707getUnspecifiedD9Ej5fM() : f3, (i & 256) != 0 ? true : z2, (i & 512) != 0 ? PlatformMagnifierFactory.INSTANCE.getForCurrentPlatform() : platformMagnifierFactory, null);
    }

    /* JADX INFO: renamed from: getSize-MYxV2XQ, reason: not valid java name and from getter */
    public final long getSize() {
        return this.size;
    }

    /* JADX INFO: renamed from: setSize-EaSLcWc, reason: not valid java name */
    public final void m666setSizeEaSLcWc(long j) {
        this.size = j;
    }

    /* JADX INFO: renamed from: getCornerRadius-D9Ej5fM, reason: not valid java name and from getter */
    public final float getCornerRadius() {
        return this.cornerRadius;
    }

    /* JADX INFO: renamed from: setCornerRadius-0680j_4, reason: not valid java name */
    public final void m664setCornerRadius0680j_4(float f) {
        this.cornerRadius = f;
    }

    /* JADX INFO: renamed from: getElevation-D9Ej5fM, reason: not valid java name and from getter */
    public final float getElevation() {
        return this.elevation;
    }

    /* JADX INFO: renamed from: setElevation-0680j_4, reason: not valid java name */
    public final void m665setElevation0680j_4(float f) {
        this.elevation = f;
    }

    public final boolean getClippingEnabled() {
        return this.clippingEnabled;
    }

    public final void setClippingEnabled(boolean z) {
        this.clippingEnabled = z;
    }

    public final PlatformMagnifierFactory getPlatformMagnifierFactory() {
        return this.platformMagnifierFactory;
    }

    public final void setPlatformMagnifierFactory(PlatformMagnifierFactory platformMagnifierFactory) {
        this.platformMagnifierFactory = platformMagnifierFactory;
    }

    private final LayoutCoordinates getLayoutCoordinates() {
        return (LayoutCoordinates) this.layoutCoordinates.getValue();
    }

    private final void setLayoutCoordinates(LayoutCoordinates layoutCoordinates) {
        this.layoutCoordinates.setValue(layoutCoordinates);
    }

    /* JADX INFO: renamed from: getAnchorPositionInRoot-F1C5BW0, reason: not valid java name */
    private final long m660getAnchorPositionInRootF1C5BW0() {
        if (this.anchorPositionInRootState == null) {
            this.anchorPositionInRootState = SnapshotStateKt.derivedStateOf(new Function0() { // from class: androidx.compose.foundation.MagnifierNode$$ExternalSyntheticLambda2
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    return MagnifierNode.getAnchorPositionInRoot_F1C5BW0$lambda$0(this.f$0);
                }
            });
        }
        State<Offset> state = this.anchorPositionInRootState;
        return state != null ? state.getValue().m6579unboximpl() : Offset.INSTANCE.m6584getUnspecifiedF1C5BW0();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Offset getAnchorPositionInRoot_F1C5BW0$lambda$0(MagnifierNode magnifierNode) {
        LayoutCoordinates layoutCoordinates = magnifierNode.getLayoutCoordinates();
        return Offset.m6558boximpl(layoutCoordinates != null ? LayoutCoordinatesKt.positionInRoot(layoutCoordinates) : Offset.INSTANCE.m6584getUnspecifiedF1C5BW0());
    }

    /* JADX INFO: renamed from: update-5F03MCQ, reason: not valid java name */
    public final void m667update5F03MCQ(Function1<? super Density, Offset> sourceCenter, Function1<? super Density, Offset> magnifierCenter, float zoom, boolean useTextDefault, long size, float cornerRadius, float elevation, boolean clippingEnabled, Function1<? super DpSize, Unit> onSizeChanged, PlatformMagnifierFactory platformMagnifierFactory) {
        float f = this.zoom;
        long j = this.size;
        float f2 = this.cornerRadius;
        boolean z = this.useTextDefault;
        float f3 = this.elevation;
        boolean z2 = this.clippingEnabled;
        PlatformMagnifierFactory platformMagnifierFactory2 = this.platformMagnifierFactory;
        View view = this.view;
        Density density = this.density;
        this.sourceCenter = sourceCenter;
        this.magnifierCenter = magnifierCenter;
        this.zoom = zoom;
        this.useTextDefault = useTextDefault;
        this.size = size;
        this.cornerRadius = cornerRadius;
        this.elevation = elevation;
        this.clippingEnabled = clippingEnabled;
        this.onSizeChanged = onSizeChanged;
        this.platformMagnifierFactory = platformMagnifierFactory;
        MagnifierNode magnifierNode = this;
        View viewRequireView = DelegatableNode_androidKt.requireView(magnifierNode);
        Density densityRequireDensity = DelegatableNodeKt.requireDensity(magnifierNode);
        if (this.magnifier != null && ((!Magnifier_androidKt.equalsIncludingNaN(zoom, f) && !platformMagnifierFactory.getCanUpdateZoom()) || !DpSize.m9782equalsimpl0(size, j) || !Dp.m9692equalsimpl0(cornerRadius, f2) || !Dp.m9692equalsimpl0(elevation, f3) || useTextDefault != z || clippingEnabled != z2 || !Intrinsics.areEqual(platformMagnifierFactory, platformMagnifierFactory2) || !Intrinsics.areEqual(viewRequireView, view) || !Intrinsics.areEqual(densityRequireDensity, density))) {
            recreateMagnifier();
        }
        updateMagnifier();
    }

    @Override // androidx.compose.ui.Modifier.Node
    public void onAttach() {
        onObservedReadsChanged();
        this.drawSignalChannel = ChannelKt.Channel$default(0, null, null, 7, null);
        BuildersKt__Builders_commonKt.launch$default(getCoroutineScope(), null, CoroutineStart.UNDISPATCHED, new AnonymousClass1(null), 1, null);
    }

    /* JADX INFO: renamed from: androidx.compose.foundation.MagnifierNode$onAttach$1, reason: invalid class name */
    /* JADX INFO: compiled from: Magnifier.android.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
    @DebugMetadata(c = "androidx.compose.foundation.MagnifierNode$onAttach$1", f = "Magnifier.android.kt", i = {}, l = {382, 386}, m = "invokeSuspend", n = {}, s = {}, v = 1)
    static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;

        AnonymousClass1(Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return MagnifierNode.this.new AnonymousClass1(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Code duplicated, block: B:11:0x0021  */
        /* JADX WARN: Code duplicated, block: B:13:0x0029  */
        /* JADX WARN: Code duplicated, block: B:16:0x0035  */
        /* JADX WARN: Code duplicated, block: B:18:0x003d  */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:17:0x003b -> B:11:0x0021). Please report as a decompilation issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:19:0x004b -> B:21:0x004e). Please report as a decompilation issue!!! */
        /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
            jadx.core.utils.exceptions.JadxOverflowException: Regions stack size limit reached
            	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
            	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
            	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
            */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final java.lang.Object invokeSuspend(java.lang.Object r5) {
            /*
                r4 = this;
                java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
                int r1 = r4.label
                r2 = 2
                r3 = 1
                if (r1 == 0) goto L1e
                if (r1 == r3) goto L1a
                if (r1 != r2) goto L12
                kotlin.ResultKt.throwOnFailure(r5)
                goto L4e
            L12:
                java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
                java.lang.String r5 = "call to 'resume' before 'invoke' with coroutine"
                r4.<init>(r5)
                throw r4
            L1a:
                kotlin.ResultKt.throwOnFailure(r5)
                goto L35
            L1e:
                kotlin.ResultKt.throwOnFailure(r5)
            L21:
                androidx.compose.foundation.MagnifierNode r5 = androidx.compose.foundation.MagnifierNode.this
                kotlinx.coroutines.channels.Channel r5 = androidx.compose.foundation.MagnifierNode.access$getDrawSignalChannel$p(r5)
                if (r5 == 0) goto L35
                r1 = r4
                kotlin.coroutines.Continuation r1 = (kotlin.coroutines.Continuation) r1
                r4.label = r3
                java.lang.Object r5 = r5.receive(r1)
                if (r5 != r0) goto L35
                goto L4d
            L35:
                androidx.compose.foundation.MagnifierNode r5 = androidx.compose.foundation.MagnifierNode.this
                androidx.compose.foundation.PlatformMagnifier r5 = androidx.compose.foundation.MagnifierNode.access$getMagnifier$p(r5)
                if (r5 == 0) goto L21
                androidx.compose.foundation.MagnifierNode$onAttach$1$$ExternalSyntheticLambda0 r5 = new androidx.compose.foundation.MagnifierNode$onAttach$1$$ExternalSyntheticLambda0
                r5.<init>()
                r1 = r4
                kotlin.coroutines.Continuation r1 = (kotlin.coroutines.Continuation) r1
                r4.label = r2
                java.lang.Object r5 = androidx.compose.runtime.MonotonicFrameClockKt.withFrameMillis(r5, r1)
                if (r5 != r0) goto L4e
            L4d:
                return r0
            L4e:
                androidx.compose.foundation.MagnifierNode r5 = androidx.compose.foundation.MagnifierNode.this
                androidx.compose.foundation.PlatformMagnifier r5 = androidx.compose.foundation.MagnifierNode.access$getMagnifier$p(r5)
                if (r5 == 0) goto L21
                r5.updateContent()
                goto L21
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.MagnifierNode.AnonymousClass1.invokeSuspend(java.lang.Object):java.lang.Object");
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final Unit invokeSuspend$lambda$0(long j) {
            return Unit.INSTANCE;
        }
    }

    @Override // androidx.compose.ui.Modifier.Node
    public void onDetach() {
        PlatformMagnifier platformMagnifier = this.magnifier;
        if (platformMagnifier != null) {
            platformMagnifier.dismiss();
        }
        this.magnifier = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit onObservedReadsChanged$lambda$0(MagnifierNode magnifierNode) {
        magnifierNode.updateMagnifier();
        return Unit.INSTANCE;
    }

    @Override // androidx.compose.ui.node.ObserverModifierNode
    public void onObservedReadsChanged() {
        ObserverModifierNodeKt.observeReads(this, new Function0() { // from class: androidx.compose.foundation.MagnifierNode$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return MagnifierNode.onObservedReadsChanged$lambda$0(this.f$0);
            }
        });
    }

    private final void recreateMagnifier() {
        PlatformMagnifier platformMagnifier = this.magnifier;
        if (platformMagnifier != null) {
            platformMagnifier.dismiss();
        }
        View viewRequireView = this.view;
        if (viewRequireView == null) {
            viewRequireView = DelegatableNode_androidKt.requireView(this);
        }
        View view = viewRequireView;
        this.view = view;
        Density densityRequireDensity = this.density;
        if (densityRequireDensity == null) {
            densityRequireDensity = DelegatableNodeKt.requireDensity(this);
        }
        Density density = densityRequireDensity;
        this.density = density;
        this.magnifier = this.platformMagnifierFactory.mo695createnHHXs2Y(view, this.useTextDefault, this.size, this.cornerRadius, this.elevation, this.clippingEnabled, density, this.zoom);
        updateSizeIfNecessary();
    }

    /* JADX WARN: Code duplicated, block: B:17:0x0068  */
    private final void updateMagnifier() {
        long jM6584getUnspecifiedF1C5BW0;
        Density densityRequireDensity = this.density;
        if (densityRequireDensity == null) {
            densityRequireDensity = DelegatableNodeKt.requireDensity(this);
            this.density = densityRequireDensity;
        }
        long jM6579unboximpl = this.sourceCenter.invoke(densityRequireDensity).m6579unboximpl();
        if ((jM6579unboximpl & 9223372034707292159L) != InlineClassHelperKt.UnspecifiedPackedFloats && (m660getAnchorPositionInRootF1C5BW0() & 9223372034707292159L) != InlineClassHelperKt.UnspecifiedPackedFloats) {
            this.sourceCenterInRoot = Offset.m6574plusMKHz9U(m660getAnchorPositionInRootF1C5BW0(), jM6579unboximpl);
            Function1<? super Density, Offset> function1 = this.magnifierCenter;
            if (function1 != null) {
                Offset offsetM6558boximpl = Offset.m6558boximpl(function1.invoke(densityRequireDensity).m6579unboximpl());
                if ((offsetM6558boximpl.m6579unboximpl() & 9223372034707292159L) == InlineClassHelperKt.UnspecifiedPackedFloats) {
                    offsetM6558boximpl = null;
                }
                if (offsetM6558boximpl != null) {
                    jM6584getUnspecifiedF1C5BW0 = Offset.m6574plusMKHz9U(m660getAnchorPositionInRootF1C5BW0(), offsetM6558boximpl.m6579unboximpl());
                } else {
                    jM6584getUnspecifiedF1C5BW0 = Offset.INSTANCE.m6584getUnspecifiedF1C5BW0();
                }
            } else {
                jM6584getUnspecifiedF1C5BW0 = Offset.INSTANCE.m6584getUnspecifiedF1C5BW0();
            }
            long j = jM6584getUnspecifiedF1C5BW0;
            if (this.magnifier == null) {
                recreateMagnifier();
            }
            PlatformMagnifier platformMagnifier = this.magnifier;
            if (platformMagnifier != null) {
                platformMagnifier.mo694updateWko1d7g(this.sourceCenterInRoot, j, this.zoom);
            }
            updateSizeIfNecessary();
            return;
        }
        this.sourceCenterInRoot = Offset.INSTANCE.m6584getUnspecifiedF1C5BW0();
        PlatformMagnifier platformMagnifier2 = this.magnifier;
        if (platformMagnifier2 != null) {
            platformMagnifier2.dismiss();
        }
    }

    private final void updateSizeIfNecessary() {
        Density density;
        PlatformMagnifier platformMagnifier = this.magnifier;
        if (platformMagnifier == null || (density = this.density) == null || IntSize.m9855equalsimpl(platformMagnifier.mo693getSizeYbymL2g(), this.previousSize)) {
            return;
        }
        Function1<? super DpSize, Unit> function1 = this.onSizeChanged;
        if (function1 != null) {
            function1.invoke(DpSize.m9773boximpl(density.mo752toDpSizekrfVVM(IntSizeKt.m9870toSizeozmzZPI(platformMagnifier.mo693getSizeYbymL2g()))));
        }
        this.previousSize = IntSize.m9850boximpl(platformMagnifier.mo693getSizeYbymL2g());
    }

    @Override // androidx.compose.ui.node.DrawModifierNode
    public void draw(ContentDrawScope contentDrawScope) {
        contentDrawScope.drawContent();
        Channel<Unit> channel = this.drawSignalChannel;
        if (channel != null) {
            ChannelResult.m16334boximpl(channel.mo11206trySendJP2dKIU(Unit.INSTANCE));
        }
    }

    @Override // androidx.compose.ui.node.GlobalPositionAwareModifierNode
    public void onGloballyPositioned(LayoutCoordinates coordinates) {
        setLayoutCoordinates(coordinates);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Offset applySemantics$lambda$0(MagnifierNode magnifierNode) {
        return Offset.m6558boximpl(magnifierNode.sourceCenterInRoot);
    }

    @Override // androidx.compose.ui.node.SemanticsModifierNode
    public void applySemantics(SemanticsPropertyReceiver semanticsPropertyReceiver) {
        semanticsPropertyReceiver.set(Magnifier_androidKt.getMagnifierPositionInRoot(), new Function0() { // from class: androidx.compose.foundation.MagnifierNode$$ExternalSyntheticLambda1
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return MagnifierNode.applySemantics$lambda$0(this.f$0);
            }
        });
    }
}
