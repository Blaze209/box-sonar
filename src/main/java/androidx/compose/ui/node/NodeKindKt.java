package androidx.compose.ui.node;

import androidx.collection.MutableObjectIntMap;
import androidx.collection.ObjectIntMapKt;
import androidx.compose.ui.Actual_jvmKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.draw.DrawModifier;
import androidx.compose.ui.focus.FocusEventModifier;
import androidx.compose.ui.focus.FocusEventModifierNode;
import androidx.compose.ui.focus.FocusEventModifierNodeKt;
import androidx.compose.ui.focus.FocusOrderModifier;
import androidx.compose.ui.focus.FocusPropertiesModifierNode;
import androidx.compose.ui.focus.FocusPropertiesModifierNodeKt;
import androidx.compose.ui.focus.FocusTargetNode;
import androidx.compose.ui.input.indirect.IndirectPointerInputModifierNode;
import androidx.compose.ui.input.key.KeyInputModifierNode;
import androidx.compose.ui.input.key.SoftKeyboardInterceptionModifierNode;
import androidx.compose.ui.input.pointer.PointerInputModifier;
import androidx.compose.ui.input.rotary.RotaryInputModifierNode;
import androidx.compose.ui.internal.InlineClassHelperKt;
import androidx.compose.ui.layout.ApproachLayoutModifierNode;
import androidx.compose.ui.layout.BeyondBoundsLayoutProviderModifierNode;
import androidx.compose.ui.layout.LayoutModifier;
import androidx.compose.ui.layout.OnGloballyPositionedModifier;
import androidx.compose.ui.layout.OnPlacedModifier;
import androidx.compose.ui.layout.OnPlacedNode;
import androidx.compose.ui.layout.OnRemeasuredModifier;
import androidx.compose.ui.layout.OnSizeChangedNode;
import androidx.compose.ui.layout.ParentDataModifier;
import androidx.compose.ui.modifier.ModifierLocalConsumer;
import androidx.compose.ui.modifier.ModifierLocalModifierNode;
import androidx.compose.ui.modifier.ModifierLocalProvider;
import androidx.compose.ui.relocation.BringIntoViewModifierNode;
import androidx.compose.ui.semantics.SemanticsModifier;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import kotlin.Metadata;

/* JADX INFO: compiled from: NodeKind.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(d1 = {"\u0000@\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a \u0010\u0000\u001a\u00020\u0001*\u00020\u00012\n\u0010\u0002\u001a\u0006\u0012\u0002\b\u00030\u0003H\u0080\f¢\u0006\u0004\b\u0004\u0010\u0005\u001a \u0010\u0006\u001a\u00020\u0007*\u00020\u00012\n\u0010\b\u001a\u0006\u0012\u0002\b\u00030\u0003H\u0080\n¢\u0006\u0004\b\t\u0010\n\u001a\u0010\u0010\u000e\u001a\u00020\u00012\u0006\u0010\u000f\u001a\u00020\u0010H\u0000\u001a\u0010\u0010\u000e\u001a\u00020\u00012\u0006\u0010\u0014\u001a\u00020\u0015H\u0000\u001a\u0010\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u0014\u001a\u00020\u0015H\u0000\u001a\u0010\u0010\u001f\u001a\u00020\u001e2\u0006\u0010\u0014\u001a\u00020\u0015H\u0000\u001a\u0010\u0010 \u001a\u00020\u001e2\u0006\u0010\u0014\u001a\u00020\u0015H\u0000\u001a \u0010!\u001a\u00020\u001e2\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\"\u001a\u00020\u00012\u0006\u0010#\u001a\u00020\u0001H\u0000\u001a \u0010$\u001a\u00020\u001e2\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010%\u001a\u00020\u00012\u0006\u0010#\u001a\u00020\u0001H\u0002\u001a\f\u0010&\u001a\u00020\u0007*\u00020'H\u0002\u001a\u0010\u0010(\u001a\u00020\u00012\u0006\u0010\u0014\u001a\u00020\u0015H\u0000\"\u001c\u0010\u000b\u001a\u00020\u0007*\u0006\u0012\u0002\b\u00030\u00038@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b\f\u0010\r\"\u0014\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00130\u0012X\u0082\u0004¢\u0006\u0002\n\u0000\"\u0014\u0010\u0016\u001a\u00020\u0001X\u0082T¢\u0006\b\n\u0000\u0012\u0004\b\u0017\u0010\u0018\"\u0014\u0010\u0019\u001a\u00020\u0001X\u0082T¢\u0006\b\n\u0000\u0012\u0004\b\u001a\u0010\u0018\"\u0014\u0010\u001b\u001a\u00020\u0001X\u0082T¢\u0006\b\n\u0000\u0012\u0004\b\u001c\u0010\u0018¨\u0006)"}, d2 = {"or", "", "other", "Landroidx/compose/ui/node/NodeKind;", "or-64DMado", "(II)I", "contains", "", "value", "contains-64DMado", "(II)Z", "includeSelfInTraversal", "getIncludeSelfInTraversal-H91voCI", "(I)Z", "calculateNodeKindSetFrom", "element", "Landroidx/compose/ui/Modifier$Element;", "classToKindSetMap", "Landroidx/collection/MutableObjectIntMap;", "", "node", "Landroidx/compose/ui/Modifier$Node;", "Updated", "getUpdated$annotations", "()V", "Inserted", "getInserted$annotations", "Removed", "getRemoved$annotations", "autoInvalidateRemovedNode", "", "autoInvalidateInsertedNode", "autoInvalidateUpdatedNode", "autoInvalidateNodeIncludingDelegates", "remainingSet", TypedValues.CycleType.S_WAVE_PHASE, "autoInvalidateNodeSelf", "selfKindSet", "specifiesCanFocusProperty", "Landroidx/compose/ui/focus/FocusPropertiesModifierNode;", "calculateNodeKindSetFromIncludingDelegates", "ui"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class NodeKindKt {
    private static final int Inserted = 1;
    private static final int Removed = 2;
    private static final int Updated = 0;
    private static final MutableObjectIntMap<Object> classToKindSetMap = ObjectIntMapKt.mutableObjectIntMapOf();

    /* JADX INFO: renamed from: contains-64DMado, reason: not valid java name */
    public static final boolean m8593contains64DMado(int i, int i2) {
        return (i & i2) != 0;
    }

    private static /* synthetic */ void getInserted$annotations() {
    }

    private static /* synthetic */ void getRemoved$annotations() {
    }

    private static /* synthetic */ void getUpdated$annotations() {
    }

    /* JADX INFO: renamed from: or-64DMado, reason: not valid java name */
    public static final int m8595or64DMado(int i, int i2) {
        return i | i2;
    }

    /* JADX WARN: Code duplicated, block: B:40:0x008a  */
    /* JADX WARN: Code duplicated, block: B:43:0x0095  */
    /* JADX WARN: Code duplicated, block: B:46:0x00a0  */
    /* JADX WARN: Code duplicated, block: B:49:0x00ab  */
    /* JADX WARN: Code duplicated, block: B:52:0x00b6  */
    /* JADX WARN: Code duplicated, block: B:55:0x00c1  */
    /* JADX WARN: Code duplicated, block: B:58:0x00cc  */
    /* JADX WARN: Code duplicated, block: B:61:0x00d7  */
    /* JADX WARN: Code duplicated, block: B:64:0x00e3  */
    /* JADX WARN: Code duplicated, block: B:67:0x00ee  */
    /* JADX WARN: Code duplicated, block: B:70:0x00f9  */
    /* JADX WARN: Code duplicated, block: B:73:0x0104  */
    /* JADX WARN: Code duplicated, block: B:76:0x010f  */
    /* JADX WARN: Code duplicated, block: B:79:0x011a  */
    public static final int calculateNodeKindSetFrom(Modifier.Node node) {
        int iM8585constructorimpl;
        if (node.getKindSet() != 0) {
            return node.getKindSet();
        }
        MutableObjectIntMap<Object> mutableObjectIntMap = classToKindSetMap;
        Object objClassKeyForObject = Actual_jvmKt.classKeyForObject(node);
        int iFindKeyIndex = mutableObjectIntMap.findKeyIndex(objClassKeyForObject);
        if (iFindKeyIndex >= 0) {
            return mutableObjectIntMap.values[iFindKeyIndex];
        }
        int iM8585constructorimpl2 = NodeKind.m8585constructorimpl(1);
        if (node instanceof LayoutModifierNode) {
            iM8585constructorimpl2 |= NodeKind.m8585constructorimpl(2);
        }
        if (node instanceof DrawModifierNode) {
            iM8585constructorimpl2 |= NodeKind.m8585constructorimpl(4);
        }
        if (node instanceof SemanticsModifierNode) {
            iM8585constructorimpl2 |= NodeKind.m8585constructorimpl(8);
        }
        if (node instanceof PointerInputModifierNode) {
            iM8585constructorimpl2 |= NodeKind.m8585constructorimpl(16);
        }
        if (node instanceof ModifierLocalModifierNode) {
            iM8585constructorimpl2 |= NodeKind.m8585constructorimpl(32);
        }
        if (node instanceof ParentDataModifierNode) {
            iM8585constructorimpl2 |= NodeKind.m8585constructorimpl(64);
        }
        if (!(node instanceof OnPlacedNode)) {
            if (!(node instanceof OnSizeChangedNode)) {
                if (node instanceof LayoutAwareModifierNode) {
                    iM8585constructorimpl2 |= NodeKind.m8585constructorimpl(128);
                    iM8585constructorimpl = NodeKind.m8585constructorimpl(4194304);
                }
                if (node instanceof GlobalPositionAwareModifierNode) {
                    iM8585constructorimpl2 |= NodeKind.m8585constructorimpl(256);
                }
                if (node instanceof ApproachLayoutModifierNode) {
                    iM8585constructorimpl2 |= NodeKind.m8585constructorimpl(512);
                }
                if (node instanceof FocusTargetNode) {
                    iM8585constructorimpl2 |= NodeKind.m8585constructorimpl(1024);
                }
                if (node instanceof FocusPropertiesModifierNode) {
                    iM8585constructorimpl2 |= NodeKind.m8585constructorimpl(2048);
                }
                if (node instanceof FocusEventModifierNode) {
                    iM8585constructorimpl2 |= NodeKind.m8585constructorimpl(4096);
                }
                if (node instanceof KeyInputModifierNode) {
                    iM8585constructorimpl2 |= NodeKind.m8585constructorimpl(8192);
                }
                if (node instanceof RotaryInputModifierNode) {
                    iM8585constructorimpl2 |= NodeKind.m8585constructorimpl(16384);
                }
                if (node instanceof CompositionLocalConsumerModifierNode) {
                    iM8585constructorimpl2 |= NodeKind.m8585constructorimpl(32768);
                }
                if (node instanceof SoftKeyboardInterceptionModifierNode) {
                    iM8585constructorimpl2 |= NodeKind.m8585constructorimpl(131072);
                }
                if (node instanceof TraversableNode) {
                    iM8585constructorimpl2 |= NodeKind.m8585constructorimpl(262144);
                }
                if (node instanceof BringIntoViewModifierNode) {
                    iM8585constructorimpl2 |= NodeKind.m8585constructorimpl(524288);
                }
                if (node instanceof UnplacedAwareModifierNode) {
                    iM8585constructorimpl2 |= NodeKind.m8585constructorimpl(1048576);
                }
                if (node instanceof IndirectPointerInputModifierNode) {
                    iM8585constructorimpl2 |= NodeKind.m8585constructorimpl(2097152);
                }
                if (node instanceof BeyondBoundsLayoutProviderModifierNode) {
                    iM8585constructorimpl2 |= NodeKind.m8585constructorimpl(8388608);
                }
                mutableObjectIntMap.set(objClassKeyForObject, iM8585constructorimpl2);
                return iM8585constructorimpl2;
            }
            iM8585constructorimpl = NodeKind.m8585constructorimpl(128);
        } else {
            iM8585constructorimpl = NodeKind.m8585constructorimpl(4194304);
        }
        iM8585constructorimpl2 |= iM8585constructorimpl;
        if (node instanceof GlobalPositionAwareModifierNode) {
            iM8585constructorimpl2 |= NodeKind.m8585constructorimpl(256);
        }
        if (node instanceof ApproachLayoutModifierNode) {
            iM8585constructorimpl2 |= NodeKind.m8585constructorimpl(512);
        }
        if (node instanceof FocusTargetNode) {
            iM8585constructorimpl2 |= NodeKind.m8585constructorimpl(1024);
        }
        if (node instanceof FocusPropertiesModifierNode) {
            iM8585constructorimpl2 |= NodeKind.m8585constructorimpl(2048);
        }
        if (node instanceof FocusEventModifierNode) {
            iM8585constructorimpl2 |= NodeKind.m8585constructorimpl(4096);
        }
        if (node instanceof KeyInputModifierNode) {
            iM8585constructorimpl2 |= NodeKind.m8585constructorimpl(8192);
        }
        if (node instanceof RotaryInputModifierNode) {
            iM8585constructorimpl2 |= NodeKind.m8585constructorimpl(16384);
        }
        if (node instanceof CompositionLocalConsumerModifierNode) {
            iM8585constructorimpl2 |= NodeKind.m8585constructorimpl(32768);
        }
        if (node instanceof SoftKeyboardInterceptionModifierNode) {
            iM8585constructorimpl2 |= NodeKind.m8585constructorimpl(131072);
        }
        if (node instanceof TraversableNode) {
            iM8585constructorimpl2 |= NodeKind.m8585constructorimpl(262144);
        }
        if (node instanceof BringIntoViewModifierNode) {
            iM8585constructorimpl2 |= NodeKind.m8585constructorimpl(524288);
        }
        if (node instanceof UnplacedAwareModifierNode) {
            iM8585constructorimpl2 |= NodeKind.m8585constructorimpl(1048576);
        }
        if (node instanceof IndirectPointerInputModifierNode) {
            iM8585constructorimpl2 |= NodeKind.m8585constructorimpl(2097152);
        }
        if (node instanceof BeyondBoundsLayoutProviderModifierNode) {
            iM8585constructorimpl2 |= NodeKind.m8585constructorimpl(8388608);
        }
        mutableObjectIntMap.set(objClassKeyForObject, iM8585constructorimpl2);
        return iM8585constructorimpl2;
    }

    public static final void autoInvalidateRemovedNode(Modifier.Node node) {
        if (!node.getIsAttached()) {
            InlineClassHelperKt.throwIllegalStateException("autoInvalidateRemovedNode called on unattached node");
        }
        autoInvalidateNodeIncludingDelegates(node, -1, 2);
    }

    public static final void autoInvalidateInsertedNode(Modifier.Node node) {
        if (!node.getIsAttached()) {
            InlineClassHelperKt.throwIllegalStateException("autoInvalidateInsertedNode called on unattached node");
        }
        autoInvalidateNodeIncludingDelegates(node, -1, 1);
    }

    public static final void autoInvalidateUpdatedNode(Modifier.Node node) {
        if (!node.getIsAttached()) {
            InlineClassHelperKt.throwIllegalStateException("autoInvalidateUpdatedNode called on unattached node");
        }
        autoInvalidateNodeIncludingDelegates(node, -1, 0);
    }

    public static final void autoInvalidateNodeIncludingDelegates(Modifier.Node node, int i, int i2) {
        if (node instanceof DelegatingNode) {
            DelegatingNode delegatingNode = (DelegatingNode) node;
            autoInvalidateNodeSelf(node, delegatingNode.getSelfKindSet() & i, i2);
            int i3 = (~delegatingNode.getSelfKindSet()) & i;
            for (Modifier.Node delegate$ui = delegatingNode.getDelegate(); delegate$ui != null; delegate$ui = delegate$ui.getChild()) {
                autoInvalidateNodeIncludingDelegates(delegate$ui, i3, i2);
            }
            return;
        }
        autoInvalidateNodeSelf(node, i & node.getKindSet(), i2);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private static final void autoInvalidateNodeSelf(Modifier.Node node, int i, int i2) {
        if (i2 != 0 || node.getShouldAutoInvalidate()) {
            if ((NodeKind.m8585constructorimpl(2) & i) != 0 && (node instanceof LayoutModifierNode)) {
                LayoutModifierNodeKt.invalidateMeasurement((LayoutModifierNode) node);
                if (i2 == 2) {
                    DelegatableNodeKt.m8436requireCoordinator64DMado(node, NodeKind.m8585constructorimpl(2)).onRelease();
                }
            }
            if ((NodeKind.m8585constructorimpl(128) & i) != 0 && i2 != 2) {
                DelegatableNodeKt.requireLayoutNode(node).invalidateMeasurements$ui();
            }
            if ((NodeKind.m8585constructorimpl(4194304) & i) != 0 && i2 != 2) {
                LayoutNode.requestRelayout$ui$default(DelegatableNodeKt.requireLayoutNode(node), false, 1, null);
            }
            if ((NodeKind.m8585constructorimpl(256) & i) != 0 && (node instanceof GlobalPositionAwareModifierNode)) {
                if (i2 == 1) {
                    LayoutNode layoutNodeRequireLayoutNode = DelegatableNodeKt.requireLayoutNode(node);
                    layoutNodeRequireLayoutNode.setGloballyPositionedObservers(layoutNodeRequireLayoutNode.getGloballyPositionedObservers() + 1);
                } else if (i2 == 2) {
                    LayoutNode layoutNodeRequireLayoutNode2 = DelegatableNodeKt.requireLayoutNode(node);
                    layoutNodeRequireLayoutNode2.setGloballyPositionedObservers(layoutNodeRequireLayoutNode2.getGloballyPositionedObservers() - 1);
                }
                if (i2 != 2) {
                    DelegatableNodeKt.requireLayoutNode(node).invalidateOnPositioned$ui();
                }
            }
            if ((NodeKind.m8585constructorimpl(4) & i) != 0 && (node instanceof DrawModifierNode)) {
                DrawModifierNodeKt.invalidateDraw((DrawModifierNode) node);
            }
            if ((NodeKind.m8585constructorimpl(8) & i) != 0 && (node instanceof SemanticsModifierNode)) {
                DelegatableNodeKt.requireLayoutNode(node).setSemanticsInvalidated$ui(true);
            }
            if ((NodeKind.m8585constructorimpl(64) & i) != 0 && (node instanceof ParentDataModifierNode)) {
                ParentDataModifierNodeKt.invalidateParentData((ParentDataModifierNode) node);
            }
            if ((NodeKind.m8585constructorimpl(2048) & i) != 0 && (node instanceof FocusPropertiesModifierNode)) {
                FocusPropertiesModifierNode focusPropertiesModifierNode = (FocusPropertiesModifierNode) node;
                if (specifiesCanFocusProperty(focusPropertiesModifierNode)) {
                    FocusPropertiesModifierNodeKt.invalidateFocusProperties(focusPropertiesModifierNode);
                }
            }
            if ((i & NodeKind.m8585constructorimpl(4096)) == 0 || !(node instanceof FocusEventModifierNode)) {
                return;
            }
            FocusEventModifierNodeKt.invalidateFocusEvent((FocusEventModifierNode) node);
        }
    }

    private static final boolean specifiesCanFocusProperty(FocusPropertiesModifierNode focusPropertiesModifierNode) {
        CanFocusChecker.INSTANCE.reset();
        focusPropertiesModifierNode.applyFocusProperties(CanFocusChecker.INSTANCE);
        return CanFocusChecker.INSTANCE.isCanFocusSet();
    }

    public static final int calculateNodeKindSetFromIncludingDelegates(Modifier.Node node) {
        if (node instanceof DelegatingNode) {
            DelegatingNode delegatingNode = (DelegatingNode) node;
            int selfKindSet$ui = delegatingNode.getSelfKindSet();
            for (Modifier.Node delegate$ui = delegatingNode.getDelegate(); delegate$ui != null; delegate$ui = delegate$ui.getChild()) {
                selfKindSet$ui |= calculateNodeKindSetFromIncludingDelegates(delegate$ui);
            }
            return selfKindSet$ui;
        }
        return calculateNodeKindSetFrom(node);
    }

    /* JADX INFO: renamed from: getIncludeSelfInTraversal-H91voCI, reason: not valid java name */
    public static final boolean m8594getIncludeSelfInTraversalH91voCI(int i) {
        return ((NodeKind.m8585constructorimpl(128) & i) != 0) | ((i & NodeKind.m8585constructorimpl(4194304)) != 0);
    }

    public static final int calculateNodeKindSetFrom(Modifier.Element element) {
        int iM8585constructorimpl = NodeKind.m8585constructorimpl(1);
        if (element instanceof LayoutModifier) {
            iM8585constructorimpl |= NodeKind.m8585constructorimpl(2);
        }
        if (element instanceof DrawModifier) {
            iM8585constructorimpl |= NodeKind.m8585constructorimpl(4);
        }
        if (element instanceof SemanticsModifier) {
            iM8585constructorimpl |= NodeKind.m8585constructorimpl(8);
        }
        if (element instanceof PointerInputModifier) {
            iM8585constructorimpl |= NodeKind.m8585constructorimpl(16);
        }
        if ((element instanceof ModifierLocalConsumer) || (element instanceof ModifierLocalProvider)) {
            iM8585constructorimpl |= NodeKind.m8585constructorimpl(32);
        }
        if (element instanceof FocusEventModifier) {
            iM8585constructorimpl |= NodeKind.m8585constructorimpl(4096);
        }
        if (element instanceof FocusOrderModifier) {
            iM8585constructorimpl |= NodeKind.m8585constructorimpl(2048);
        }
        if (element instanceof OnGloballyPositionedModifier) {
            iM8585constructorimpl |= NodeKind.m8585constructorimpl(256);
        }
        if (element instanceof ParentDataModifier) {
            iM8585constructorimpl |= NodeKind.m8585constructorimpl(64);
        }
        if (element instanceof OnPlacedModifier) {
            iM8585constructorimpl |= NodeKind.m8585constructorimpl(4194304);
        }
        if (element instanceof OnRemeasuredModifier) {
            iM8585constructorimpl |= NodeKind.m8585constructorimpl(128);
        }
        return element instanceof BringIntoViewModifierNode ? NodeKind.m8585constructorimpl(524288) | iM8585constructorimpl : iM8585constructorimpl;
    }
}
