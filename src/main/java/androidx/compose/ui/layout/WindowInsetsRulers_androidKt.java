package androidx.compose.ui.layout;

import android.graphics.Rect;
import androidx.collection.IntObjectMap;
import androidx.collection.MutableIntObjectMap;
import androidx.collection.MutableObjectList;
import androidx.collection.ScatterMap;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.collection.MutableVector;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.node.DelegatableNodeKt;
import androidx.compose.ui.node.DelegatingNode;
import androidx.compose.ui.node.NodeCoordinator;
import androidx.compose.ui.node.NodeKind;
import androidx.compose.ui.node.NodeKindKt;
import androidx.compose.ui.node.TraversableNode;
import androidx.core.view.WindowInsetsCompat;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.internal.ws.WebSocketProtocol;

/* JADX INFO: compiled from: WindowInsetsRulers.android.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(d1 = {"\u0000R\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0002\u001a\u0014\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0004H\u0000\u001a\u0016\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\u0006\u0010\b\u001a\u00020\tH\u0000\u001a\u0018\u0010\n\u001a\u00020\u000b2\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\rH\u0000\u001a3\u0010\u0010\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0011\u001a\u00020\u00072\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0015H\u0002¢\u0006\u0004\b\u0017\u0010\u0018\"\u000e\u0010\u000e\u001a\u00020\u000fX\u0080T¢\u0006\u0002\n\u0000\"\u0014\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\r0\u001aX\u0082\u0004¢\u0006\u0002\n\u0000\"\u0016\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\r0\u001cX\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u001d¨\u0006\u001e"}, d2 = {"provideWindowInsetsRulers", "", "Landroidx/compose/ui/layout/RulerScope;", "rulerProvider", "Landroidx/compose/ui/layout/WindowInsetsRulerProvider;", "findDisplayCutouts", "", "Landroidx/compose/ui/layout/RectRulers;", "placementScope", "Landroidx/compose/ui/layout/Placeable$PlacementScope;", "findInsetsAnimationProperties", "Landroidx/compose/ui/layout/WindowInsetsAnimation;", "windowInsetsRulers", "Landroidx/compose/ui/layout/WindowInsetsRulers;", "RulerKey", "", "provideInsetsValues", "rulers", "insets", "Landroidx/compose/ui/layout/ValueInsets;", "width", "", "height", "provideInsetsValues-cytEWk0", "(Landroidx/compose/ui/layout/RulerScope;Landroidx/compose/ui/layout/RectRulers;JII)V", "WindowInsetsTypeMap", "Landroidx/collection/IntObjectMap;", "AnimatableInsetsRulers", "", "[Landroidx/compose/ui/layout/WindowInsetsRulers;", "ui"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class WindowInsetsRulers_androidKt {
    private static final WindowInsetsRulers[] AnimatableInsetsRulers;
    public static final String RulerKey = "androidx.compose.ui.layout.WindowInsetsRulers";
    private static final IntObjectMap<WindowInsetsRulers> WindowInsetsTypeMap;

    public static final void provideWindowInsetsRulers(RulerScope rulerScope, WindowInsetsRulerProvider windowInsetsRulerProvider) {
        long jMo8273getSizeYbymL2g = rulerScope.getCoordinates().mo8273getSizeYbymL2g();
        ScatterMap<Object, WindowWindowInsetsAnimationValues> insetsValues = windowInsetsRulerProvider.getInsetsListener().getInsetsValues();
        int i = (int) (jMo8273getSizeYbymL2g >> 32);
        int i2 = (int) (jMo8273getSizeYbymL2g & 4294967295L);
        WindowInsetsRulers[] windowInsetsRulersArr = AnimatableInsetsRulers;
        int length = windowInsetsRulersArr.length;
        int i3 = 0;
        while (i3 < length) {
            WindowInsetsRulers windowInsetsRulers = windowInsetsRulersArr[i3];
            WindowWindowInsetsAnimationValues windowWindowInsetsAnimationValues = insetsValues.get(windowInsetsRulers);
            Intrinsics.checkNotNull(windowWindowInsetsAnimationValues);
            WindowWindowInsetsAnimationValues windowWindowInsetsAnimationValues2 = windowWindowInsetsAnimationValues;
            RulerScope rulerScope2 = rulerScope;
            m8409provideInsetsValuescytEWk0(rulerScope2, windowInsetsRulers.getCurrent(), windowWindowInsetsAnimationValues2.getCurrent(), i, i2);
            if (windowWindowInsetsAnimationValues2.isAnimating()) {
                m8409provideInsetsValuescytEWk0(rulerScope2, windowWindowInsetsAnimationValues2.getSource(), windowWindowInsetsAnimationValues2.getSourceValueInsets(), i, i2);
                m8409provideInsetsValuescytEWk0(rulerScope2, windowWindowInsetsAnimationValues2.getTarget(), windowWindowInsetsAnimationValues2.getTargetValueInsets(), i, i2);
            }
            m8409provideInsetsValuescytEWk0(rulerScope2, windowInsetsRulers.getMaximum(), windowWindowInsetsAnimationValues2.getMaximum(), i, i2);
            i3++;
            rulerScope = rulerScope2;
        }
        RulerScope rulerScope3 = rulerScope;
        MutableObjectList<MutableState<Rect>> cutoutRects = windowInsetsRulerProvider.getCutoutRects();
        if (cutoutRects.isNotEmpty()) {
            List<RectRulers> cutoutRulers = windowInsetsRulerProvider.getCutoutRulers();
            MutableObjectList<MutableState<Rect>> mutableObjectList = cutoutRects;
            Object[] objArr = mutableObjectList.content;
            int i4 = mutableObjectList._size;
            for (int i5 = 0; i5 < i4; i5++) {
                MutableState mutableState = (MutableState) objArr[i5];
                RectRulers rectRulers = cutoutRulers.get(i5);
                Rect rect = (Rect) mutableState.getValue();
                rulerScope3.provides(rectRulers.getLeft(), rect.left);
                rulerScope3.provides(rectRulers.getTop(), rect.top);
                rulerScope3.provides(rectRulers.getRight(), rect.right);
                rulerScope3.provides(rectRulers.getBottom(), rect.bottom);
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r4v11 */
    public static final List<RectRulers> findDisplayCutouts(Placeable.PlacementScope placementScope) {
        LayoutCoordinates coordinates = placementScope.getCoordinates();
        LayoutCoordinates layoutCoordinatesFindRootCoordinates = coordinates != null ? LayoutCoordinatesKt.findRootCoordinates(coordinates) : null;
        for (NodeCoordinator wrapped = layoutCoordinatesFindRootCoordinates instanceof NodeCoordinator ? (NodeCoordinator) layoutCoordinatesFindRootCoordinates : null; wrapped != null; wrapped = wrapped.getWrapped()) {
            int iM8585constructorimpl = NodeKind.m8585constructorimpl(262144);
            boolean zM8594getIncludeSelfInTraversalH91voCI = NodeKindKt.m8594getIncludeSelfInTraversalH91voCI(iM8585constructorimpl);
            Modifier.Node tail = wrapped.getTail();
            if (zM8594getIncludeSelfInTraversalH91voCI || (tail = tail.getParent()) != null) {
                for (Modifier.Node nodeHeadNode = wrapped.headNode(zM8594getIncludeSelfInTraversalH91voCI); nodeHeadNode != null && (nodeHeadNode.getAggregateChildKindSet() & iM8585constructorimpl) != 0; nodeHeadNode = nodeHeadNode.getChild()) {
                    if ((nodeHeadNode.getKindSet() & iM8585constructorimpl) != 0) {
                        MutableVector mutableVector = null;
                        Modifier.Node nodePop = nodeHeadNode;
                        while (nodePop != 0) {
                            if (nodePop instanceof TraversableNode) {
                                TraversableNode traversableNode = (TraversableNode) nodePop;
                                if (traversableNode.getTraverseKey() == RulerKey) {
                                    return ((WindowInsetsRulerProvider) traversableNode).getCutoutRulers();
                                }
                            } else if ((nodePop.getKindSet() & iM8585constructorimpl) != 0 && (nodePop instanceof DelegatingNode)) {
                                Modifier.Node delegate$ui = ((DelegatingNode) nodePop).getDelegate();
                                int i = 0;
                                nodePop = nodePop;
                                while (delegate$ui != null) {
                                    if ((delegate$ui.getKindSet() & iM8585constructorimpl) != 0) {
                                        i++;
                                        if (i == 1) {
                                            nodePop = delegate$ui;
                                        } else {
                                            if (mutableVector == null) {
                                                mutableVector = new MutableVector(new Modifier.Node[16], 0);
                                            }
                                            if (nodePop != 0) {
                                                if (mutableVector != null) {
                                                    mutableVector.add(nodePop);
                                                }
                                                nodePop = 0;
                                            }
                                            if (mutableVector != null) {
                                                mutableVector.add(delegate$ui);
                                            }
                                        }
                                    }
                                    delegate$ui = delegate$ui.getChild();
                                    nodePop = nodePop;
                                }
                                if (i == 1) {
                                }
                            }
                            nodePop = DelegatableNodeKt.pop(mutableVector);
                        }
                    }
                    if (nodeHeadNode == tail) {
                        break;
                    }
                }
            }
        }
        return CollectionsKt.emptyList();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r4v11 */
    public static final WindowInsetsAnimation findInsetsAnimationProperties(Placeable.PlacementScope placementScope, WindowInsetsRulers windowInsetsRulers) {
        LayoutCoordinates coordinates = placementScope.getCoordinates();
        LayoutCoordinates layoutCoordinatesFindRootCoordinates = coordinates != null ? LayoutCoordinatesKt.findRootCoordinates(coordinates) : null;
        for (NodeCoordinator wrapped = layoutCoordinatesFindRootCoordinates instanceof NodeCoordinator ? (NodeCoordinator) layoutCoordinatesFindRootCoordinates : null; wrapped != null; wrapped = wrapped.getWrapped()) {
            int iM8585constructorimpl = NodeKind.m8585constructorimpl(262144);
            boolean zM8594getIncludeSelfInTraversalH91voCI = NodeKindKt.m8594getIncludeSelfInTraversalH91voCI(iM8585constructorimpl);
            Modifier.Node tail = wrapped.getTail();
            if (zM8594getIncludeSelfInTraversalH91voCI || (tail = tail.getParent()) != null) {
                for (Modifier.Node nodeHeadNode = wrapped.headNode(zM8594getIncludeSelfInTraversalH91voCI); nodeHeadNode != null && (nodeHeadNode.getAggregateChildKindSet() & iM8585constructorimpl) != 0; nodeHeadNode = nodeHeadNode.getChild()) {
                    if ((nodeHeadNode.getKindSet() & iM8585constructorimpl) != 0) {
                        MutableVector mutableVector = null;
                        Modifier.Node nodePop = nodeHeadNode;
                        while (nodePop != 0) {
                            if (nodePop instanceof TraversableNode) {
                                TraversableNode traversableNode = (TraversableNode) nodePop;
                                if (traversableNode.getTraverseKey() == RulerKey) {
                                    WindowWindowInsetsAnimationValues windowWindowInsetsAnimationValues = ((WindowInsetsRulerProvider) traversableNode).getInsetsValues().get(windowInsetsRulers);
                                    return windowWindowInsetsAnimationValues != null ? windowWindowInsetsAnimationValues : NoWindowInsetsAnimation.INSTANCE;
                                }
                            } else if ((nodePop.getKindSet() & iM8585constructorimpl) != 0 && (nodePop instanceof DelegatingNode)) {
                                Modifier.Node delegate$ui = ((DelegatingNode) nodePop).getDelegate();
                                int i = 0;
                                nodePop = nodePop;
                                while (delegate$ui != null) {
                                    if ((delegate$ui.getKindSet() & iM8585constructorimpl) != 0) {
                                        i++;
                                        if (i == 1) {
                                            nodePop = delegate$ui;
                                        } else {
                                            if (mutableVector == null) {
                                                mutableVector = new MutableVector(new Modifier.Node[16], 0);
                                            }
                                            if (nodePop != 0) {
                                                if (mutableVector != null) {
                                                    mutableVector.add(nodePop);
                                                }
                                                nodePop = 0;
                                            }
                                            if (mutableVector != null) {
                                                mutableVector.add(delegate$ui);
                                            }
                                        }
                                    }
                                    delegate$ui = delegate$ui.getChild();
                                    nodePop = nodePop;
                                }
                                if (i == 1) {
                                }
                            }
                            nodePop = DelegatableNodeKt.pop(mutableVector);
                        }
                    }
                    if (nodeHeadNode == tail) {
                        break;
                    }
                }
            }
        }
        return NoWindowInsetsAnimation.INSTANCE;
    }

    /* JADX INFO: renamed from: provideInsetsValues-cytEWk0, reason: not valid java name */
    private static final void m8409provideInsetsValuescytEWk0(RulerScope rulerScope, RectRulers rectRulers, long j, int i, int i2) {
        if (ValueInsets.m8401equalsimpl0(j, ValueInsets_androidKt.getUnsetValueInsets())) {
            return;
        }
        float f = (int) ((j >>> 48) & WebSocketProtocol.PAYLOAD_SHORT_MAX);
        float f2 = (int) ((j >>> 32) & WebSocketProtocol.PAYLOAD_SHORT_MAX);
        float f3 = i - ((int) ((j >>> 16) & WebSocketProtocol.PAYLOAD_SHORT_MAX));
        float f4 = i2 - ((int) (j & WebSocketProtocol.PAYLOAD_SHORT_MAX));
        rulerScope.provides(rectRulers.getLeft(), f);
        rulerScope.provides(rectRulers.getTop(), f2);
        rulerScope.provides(rectRulers.getRight(), f3);
        rulerScope.provides(rectRulers.getBottom(), f4);
    }

    static {
        MutableIntObjectMap mutableIntObjectMap = new MutableIntObjectMap(8);
        mutableIntObjectMap.set(WindowInsetsCompat.Type.statusBars(), WindowInsetsRulers.INSTANCE.getStatusBars());
        mutableIntObjectMap.set(WindowInsetsCompat.Type.navigationBars(), WindowInsetsRulers.INSTANCE.getNavigationBars());
        mutableIntObjectMap.set(WindowInsetsCompat.Type.captionBar(), WindowInsetsRulers.INSTANCE.getCaptionBar());
        mutableIntObjectMap.set(WindowInsetsCompat.Type.ime(), WindowInsetsRulers.INSTANCE.getIme());
        mutableIntObjectMap.set(WindowInsetsCompat.Type.systemGestures(), WindowInsetsRulers.INSTANCE.getSystemGestures());
        mutableIntObjectMap.set(WindowInsetsCompat.Type.mandatorySystemGestures(), WindowInsetsRulers.INSTANCE.getMandatorySystemGestures());
        mutableIntObjectMap.set(WindowInsetsCompat.Type.tappableElement(), WindowInsetsRulers.INSTANCE.getTappableElement());
        mutableIntObjectMap.set(WindowInsetsCompat.Type.displayCutout(), WindowInsetsRulers.INSTANCE.getDisplayCutout());
        WindowInsetsTypeMap = mutableIntObjectMap;
        AnimatableInsetsRulers = new WindowInsetsRulers[]{WindowInsetsRulers.INSTANCE.getStatusBars(), WindowInsetsRulers.INSTANCE.getNavigationBars(), WindowInsetsRulers.INSTANCE.getCaptionBar(), WindowInsetsRulers.INSTANCE.getTappableElement(), WindowInsetsRulers.INSTANCE.getSystemGestures(), WindowInsetsRulers.INSTANCE.getMandatorySystemGestures(), WindowInsetsRulers.INSTANCE.getIme(), WindowInsetsRulers.INSTANCE.getWaterfall(), WindowInsetsRulers.INSTANCE.getDisplayCutout()};
    }
}
