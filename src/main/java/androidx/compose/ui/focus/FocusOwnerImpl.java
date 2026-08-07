package androidx.compose.ui.focus;

import android.view.KeyEvent;
import androidx.collection.MutableLongSet;
import androidx.collection.MutableObjectList;
import androidx.compose.runtime.collection.MutableVector;
import androidx.compose.ui.ComposeUiFlags;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.input.key.KeyEventType;
import androidx.compose.ui.input.key.KeyEvent_androidKt;
import androidx.compose.ui.internal.InlineClassHelperKt;
import androidx.compose.ui.node.DelegatableNode;
import androidx.compose.ui.node.DelegatableNodeKt;
import androidx.compose.ui.node.DelegatingNode;
import androidx.compose.ui.node.LayoutNode;
import androidx.compose.ui.node.ModifierNodeElement;
import androidx.compose.ui.node.NodeChain;
import androidx.compose.ui.node.NodeKind;
import androidx.compose.ui.node.Owner;
import androidx.compose.ui.platform.InspectorInfo;
import androidx.exifinterface.media.ExifInterface;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;

/* JADX INFO: compiled from: FocusOwnerImpl.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(d1 = {"\u0000°\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0012\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0000\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0001\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J!\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019H\u0016¢\u0006\u0002\b\u001aJ!\u0010\u001d\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019H\u0016¢\u0006\u0004\b\u001e\u0010\u001fJ\b\u0010 \u001a\u00020!H\u0016J\b\u0010\"\u001a\u00020!H\u0016J\u0010\u0010#\u001a\u00020!2\u0006\u0010$\u001a\u00020\u0015H\u0016J/\u0010#\u001a\u00020\u00152\u0006\u0010$\u001a\u00020\u00152\u0006\u0010%\u001a\u00020\u00152\u0006\u0010\"\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0017H\u0016¢\u0006\u0004\b&\u0010'J\u0017\u0010(\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0017H\u0016¢\u0006\u0004\b)\u0010*J\u001a\u0010#\u001a\u00020\u00152\b\b\u0002\u0010+\u001a\u00020\u00152\u0006\u0010%\u001a\u00020\u0015H\u0002J\u0017\u0010,\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0017H\u0016¢\u0006\u0004\b-\u0010*J\u001f\u0010,\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010.\u001a\u00020\u0015H\u0016¢\u0006\u0004\b/\u00100J7\u00101\u001a\u0004\u0018\u00010\u00152\u0006\u0010\u0016\u001a\u00020\u00172\b\u00102\u001a\u0004\u0018\u00010\u00192\u0012\u00103\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u001504H\u0016¢\u0006\u0004\b5\u00106J%\u00107\u001a\u00020\u00152\u0006\u00108\u001a\u0002092\f\u0010:\u001a\b\u0012\u0004\u0012\u00020\u00150;H\u0016¢\u0006\u0004\b<\u0010=J\u0017\u0010>\u001a\u00020\u00152\u0006\u00108\u001a\u000209H\u0016¢\u0006\u0004\b?\u0010@J\u001e\u0010A\u001a\u00020\u00152\u0006\u0010B\u001a\u00020C2\f\u0010:\u001a\b\u0012\u0004\u0012\u00020\u00150;H\u0016J\u0010\u0010D\u001a\u00020\u00152\u0006\u0010B\u001a\u00020EH\u0016J\b\u0010F\u001a\u00020!H\u0016J\b\u0010G\u001a\u00020!H\u0016J\u0010\u0010H\u001a\u00020!2\u0006\u0010I\u001a\u00020\tH\u0016J\u0010\u0010H\u001a\u00020!2\u0006\u0010I\u001a\u00020JH\u0016J\b\u0010K\u001a\u00020!H\u0016Jd\u0010L\u001a\u00020!\"\n\b\u0000\u0010M\u0018\u0001*\u00020N*\u00020N2\f\u0010O\u001a\b\u0012\u0004\u0012\u0002HM0P2\u0012\u0010Q\u001a\u000e\u0012\u0004\u0012\u0002HM\u0012\u0004\u0012\u00020!042\f\u0010R\u001a\b\u0012\u0004\u0012\u00020!0;2\u0012\u0010S\u001a\u000e\u0012\u0004\u0012\u0002HM\u0012\u0004\u0012\u00020!04H\u0082\b¢\u0006\u0004\bT\u0010UJ0\u0010V\u001a\u0004\u0018\u0001HM\"\n\b\u0000\u0010M\u0018\u0001*\u00020W*\u00020N2\f\u0010O\u001a\b\u0012\u0004\u0012\u0002HM0PH\u0082\b¢\u0006\u0004\bX\u0010YJ\n\u0010Z\u001a\u0004\u0018\u00010\u0019H\u0016J\b\u0010[\u001a\u00020\u0015H\u0016J\b\u0010\\\u001a\u00020\u0015H\u0016J\n\u0010]\u001a\u0004\u0018\u00010\tH\u0002J\u000e\u0010o\u001a\u0004\u0018\u00010p*\u00020NH\u0002J\u0017\u0010q\u001a\u00020\u00152\u0006\u00108\u001a\u000209H\u0002¢\u0006\u0004\br\u0010@R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\b\u001a\u00020\tX\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0010\u001a\u00020\u0011X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0010\u0010\u001b\u001a\u0004\u0018\u00010\u001cX\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010^\u001a\u00020_8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b`\u0010aR\u001a\u0010b\u001a\b\u0012\u0004\u0012\u00020d0cX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\be\u0010fR*\u0010h\u001a\u0004\u0018\u00010\t2\b\u0010g\u001a\u0004\u0018\u00010\t8V@VX\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bi\u0010\u000b\"\u0004\bj\u0010\rR$\u0010k\u001a\u00020\u00152\u0006\u0010g\u001a\u00020\u0015@VX\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bk\u0010l\"\u0004\bm\u0010n¨\u0006s"}, d2 = {"Landroidx/compose/ui/focus/FocusOwnerImpl;", "Landroidx/compose/ui/focus/FocusOwner;", "platformFocusOwner", "Landroidx/compose/ui/focus/PlatformFocusOwner;", "owner", "Landroidx/compose/ui/node/Owner;", "<init>", "(Landroidx/compose/ui/focus/PlatformFocusOwner;Landroidx/compose/ui/node/Owner;)V", "rootFocusNode", "Landroidx/compose/ui/focus/FocusTargetNode;", "getRootFocusNode$ui", "()Landroidx/compose/ui/focus/FocusTargetNode;", "setRootFocusNode$ui", "(Landroidx/compose/ui/focus/FocusTargetNode;)V", "focusInvalidationManager", "Landroidx/compose/ui/focus/FocusInvalidationManager;", "modifier", "Landroidx/compose/ui/Modifier;", "getModifier", "()Landroidx/compose/ui/Modifier;", "requestOwnerFocus", "", "focusDirection", "Landroidx/compose/ui/focus/FocusDirection;", "previouslyFocusedRect", "Landroidx/compose/ui/geometry/Rect;", "requestOwnerFocus-7o62pno", "keysCurrentlyDown", "Landroidx/collection/MutableLongSet;", "takeFocus", "takeFocus-aToIllA", "(ILandroidx/compose/ui/geometry/Rect;)Z", "releaseFocus", "", "clearOwnerFocus", "clearFocus", "force", "refreshFocusEvents", "clearFocus-I7lrPNg", "(ZZZI)Z", "resetFocus", "resetFocus-3ESFkO8", "(I)Z", "forced", "moveFocus", "moveFocus-3ESFkO8", "wrapAroundForOneDimensionalFocus", "moveFocus-aToIllA", "(IZ)Z", "focusSearch", "focusedRect", "onFound", "Lkotlin/Function1;", "focusSearch-ULY8qGw", "(ILandroidx/compose/ui/geometry/Rect;Lkotlin/jvm/functions/Function1;)Ljava/lang/Boolean;", "dispatchKeyEvent", "keyEvent", "Landroidx/compose/ui/input/key/KeyEvent;", "onFocusedItem", "Lkotlin/Function0;", "dispatchKeyEvent-YhN2O0w", "(Landroid/view/KeyEvent;Lkotlin/jvm/functions/Function0;)Z", "dispatchInterceptedSoftKeyboardEvent", "dispatchInterceptedSoftKeyboardEvent-ZmokQxo", "(Landroid/view/KeyEvent;)Z", "dispatchRotaryEvent", "event", "Landroidx/compose/ui/input/rotary/RotaryScrollEvent;", "dispatchIndirectPointerEvent", "Landroidx/compose/ui/input/indirect/IndirectPointerEvent;", "dispatchIndirectPointerCancel", "focusTargetAvailable", "scheduleInvalidation", "node", "Landroidx/compose/ui/focus/FocusEventModifierNode;", "scheduleInvalidationForOwner", "traverseAncestorsIncludingSelf", ExifInterface.GPS_DIRECTION_TRUE, "Landroidx/compose/ui/node/DelegatableNode;", "type", "Landroidx/compose/ui/node/NodeKind;", "onPreVisit", "onVisit", "onPostVisit", "traverseAncestorsIncludingSelf-QFhIj7k", "(Landroidx/compose/ui/node/DelegatableNode;ILkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function1;)V", "nearestAncestorIncludingSelf", "", "nearestAncestorIncludingSelf-64DMado", "(Landroidx/compose/ui/node/DelegatableNode;I)Ljava/lang/Object;", "getFocusRect", "hasFocusableContent", "hasNonInteropFocusableContent", "findFocusTargetNode", "rootState", "Landroidx/compose/ui/focus/FocusState;", "getRootState", "()Landroidx/compose/ui/focus/FocusState;", "listeners", "Landroidx/collection/MutableObjectList;", "Landroidx/compose/ui/focus/FocusListener;", "getListeners", "()Landroidx/collection/MutableObjectList;", "value", "activeFocusTargetNode", "getActiveFocusTargetNode", "setActiveFocusTargetNode", "isFocusCaptured", "()Z", "setFocusCaptured", "(Z)V", "lastLocalKeyInputNode", "Landroidx/compose/ui/Modifier$Node;", "validateKeyEvent", "validateKeyEvent-ZmokQxo", "ui"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class FocusOwnerImpl implements FocusOwner {
    public static final int $stable = 8;
    private FocusTargetNode activeFocusTargetNode;
    private final FocusInvalidationManager focusInvalidationManager;
    private boolean isFocusCaptured;
    private MutableLongSet keysCurrentlyDown;
    private final Owner owner;
    private final PlatformFocusOwner platformFocusOwner;
    private FocusTargetNode rootFocusNode = new FocusTargetNode(Focusability.INSTANCE.m6504getNeverLCbbffg(), false, null, null, 14, null);
    private final Modifier modifier = new ModifierNodeElement<FocusTargetNode>() { // from class: androidx.compose.ui.focus.FocusOwnerImpl$modifier$1
        @Override // androidx.compose.ui.node.ModifierNodeElement
        public boolean equals(Object other) {
            return other == this;
        }

        @Override // androidx.compose.ui.node.ModifierNodeElement
        public void update(FocusTargetNode node) {
        }

        @Override // androidx.compose.ui.node.ModifierNodeElement
        /* JADX INFO: renamed from: create */
        public FocusTargetNode getNode() {
            return this.this$0.getRootFocusNode();
        }

        @Override // androidx.compose.ui.node.ModifierNodeElement
        public void inspectableProperties(InspectorInfo inspectorInfo) {
            inspectorInfo.setName("RootFocusTarget");
        }

        @Override // androidx.compose.ui.node.ModifierNodeElement
        public int hashCode() {
            return this.this$0.getRootFocusNode().hashCode();
        }
    };
    private final MutableObjectList<FocusListener> listeners = new MutableObjectList<>(1);

    /* JADX INFO: compiled from: FocusOwnerImpl.kt */
    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    public static final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[CustomDestinationResult.values().length];
            try {
                iArr[CustomDestinationResult.Redirected.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[CustomDestinationResult.Cancelled.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[CustomDestinationResult.RedirectCancelled.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[CustomDestinationResult.None.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public FocusOwnerImpl(PlatformFocusOwner platformFocusOwner, Owner owner) {
        this.platformFocusOwner = platformFocusOwner;
        this.owner = owner;
        this.focusInvalidationManager = new FocusInvalidationManager(this, owner);
    }

    /* JADX INFO: renamed from: getRootFocusNode$ui, reason: from getter */
    public final FocusTargetNode getRootFocusNode() {
        return this.rootFocusNode;
    }

    public final void setRootFocusNode$ui(FocusTargetNode focusTargetNode) {
        this.rootFocusNode = focusTargetNode;
    }

    @Override // androidx.compose.ui.focus.FocusOwner
    public Modifier getModifier() {
        return this.modifier;
    }

    @Override // androidx.compose.ui.focus.FocusOwner
    /* JADX INFO: renamed from: requestOwnerFocus-7o62pno */
    public boolean mo6465requestOwnerFocus7o62pno(FocusDirection focusDirection, Rect previouslyFocusedRect) {
        return this.platformFocusOwner.mo6511requestOwnerFocus7o62pno(focusDirection, previouslyFocusedRect);
    }

    @Override // androidx.compose.ui.focus.FocusOwner
    /* JADX INFO: renamed from: takeFocus-aToIllA */
    public boolean mo6467takeFocusaToIllA(final int focusDirection, Rect previouslyFocusedRect) {
        Boolean boolMo6463focusSearchULY8qGw = mo6463focusSearchULY8qGw(focusDirection, previouslyFocusedRect, new Function1<FocusTargetNode, Boolean>() { // from class: androidx.compose.ui.focus.FocusOwnerImpl$takeFocus$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Boolean invoke(FocusTargetNode focusTargetNode) {
                return Boolean.valueOf(focusTargetNode.mo6478requestFocus3ESFkO8(focusDirection));
            }
        });
        if (boolMo6463focusSearchULY8qGw != null) {
            return boolMo6463focusSearchULY8qGw.booleanValue();
        }
        return false;
    }

    @Override // androidx.compose.ui.focus.FocusOwner
    public void releaseFocus() {
        FocusTransactionsKt.clearFocus(this.rootFocusNode, true, true);
        if (!ComposeUiFlags.isOptimizedFocusEventDispatchEnabled || getActiveFocusTargetNode() == null) {
            return;
        }
        FocusTargetNode activeFocusTargetNode = getActiveFocusTargetNode();
        setActiveFocusTargetNode(null);
        if (activeFocusTargetNode != null) {
            activeFocusTargetNode.dispatchFocusCallbacks$ui(FocusStateImpl.Active, FocusStateImpl.Inactive);
        }
    }

    @Override // androidx.compose.ui.focus.FocusOwner
    public void clearOwnerFocus() {
        this.platformFocusOwner.clearOwnerFocus();
    }

    @Override // androidx.compose.ui.focus.FocusManager
    public void clearFocus(boolean force) {
        mo6460clearFocusI7lrPNg(force, true, true, FocusDirection.INSTANCE.m6450getExitdhqQ8s());
    }

    @Override // androidx.compose.ui.focus.FocusOwner
    /* JADX INFO: renamed from: clearFocus-I7lrPNg */
    public boolean mo6460clearFocusI7lrPNg(boolean force, boolean refreshFocusEvents, boolean clearOwnerFocus, int focusDirection) {
        boolean zClearFocus;
        if (!force) {
            int i = WhenMappings.$EnumSwitchMapping$0[FocusTransactionsKt.m6487performCustomClearFocusMxy_nc0(this.rootFocusNode, focusDirection).ordinal()];
            if (i == 1 || i == 2 || i == 3) {
                zClearFocus = false;
            } else {
                if (i != 4) {
                    throw new NoWhenBranchMatchedException();
                }
                zClearFocus = clearFocus(force, refreshFocusEvents);
            }
        } else {
            zClearFocus = clearFocus(force, refreshFocusEvents);
        }
        if (zClearFocus && clearOwnerFocus) {
            clearOwnerFocus();
        }
        return zClearFocus;
    }

    @Override // androidx.compose.ui.focus.FocusOwner
    /* JADX INFO: renamed from: resetFocus-3ESFkO8 */
    public boolean mo6466resetFocus3ESFkO8(final int focusDirection) {
        if (!mo6460clearFocusI7lrPNg(false, true, false, focusDirection)) {
            return false;
        }
        Boolean boolMo6463focusSearchULY8qGw = mo6463focusSearchULY8qGw(focusDirection, null, new Function1<FocusTargetNode, Boolean>() { // from class: androidx.compose.ui.focus.FocusOwnerImpl$resetFocus$successfulReset$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Boolean invoke(FocusTargetNode focusTargetNode) {
                return Boolean.valueOf(focusTargetNode.mo6478requestFocus3ESFkO8(focusDirection));
            }
        });
        boolean zBooleanValue = boolMo6463focusSearchULY8qGw != null ? boolMo6463focusSearchULY8qGw.booleanValue() : false;
        if (!zBooleanValue) {
            clearOwnerFocus();
        }
        return zBooleanValue;
    }

    static /* synthetic */ boolean clearFocus$default(FocusOwnerImpl focusOwnerImpl, boolean z, boolean z2, int i, Object obj) {
        if ((i & 1) != 0) {
            z = false;
        }
        return focusOwnerImpl.clearFocus(z, z2);
    }

    private final boolean clearFocus(boolean forced, boolean refreshFocusEvents) {
        NodeChain nodes;
        if (getActiveFocusTargetNode() == null) {
            return true;
        }
        if (getIsFocusCaptured() && !forced) {
            return false;
        }
        FocusTargetNode activeFocusTargetNode = getActiveFocusTargetNode();
        setActiveFocusTargetNode(null);
        if (refreshFocusEvents && activeFocusTargetNode != null) {
            activeFocusTargetNode.dispatchFocusCallbacks$ui(getIsFocusCaptured() ? FocusStateImpl.Captured : FocusStateImpl.Active, FocusStateImpl.Inactive);
            FocusTargetNode focusTargetNode = activeFocusTargetNode;
            int iM8585constructorimpl = NodeKind.m8585constructorimpl(1024);
            if (!focusTargetNode.getNode().getIsAttached()) {
                InlineClassHelperKt.throwIllegalStateException("visitAncestors called on an unattached node");
            }
            Modifier.Node parent = focusTargetNode.getNode().getParent();
            LayoutNode layoutNodeRequireLayoutNode = DelegatableNodeKt.requireLayoutNode(focusTargetNode);
            while (layoutNodeRequireLayoutNode != null) {
                if ((layoutNodeRequireLayoutNode.getNodes().getHead().getAggregateChildKindSet() & iM8585constructorimpl) != 0) {
                    while (parent != null) {
                        if ((parent.getKindSet() & iM8585constructorimpl) != 0) {
                            Modifier.Node nodePop = parent;
                            MutableVector mutableVector = null;
                            while (nodePop != null) {
                                if (nodePop instanceof FocusTargetNode) {
                                    ((FocusTargetNode) nodePop).dispatchFocusCallbacks$ui(FocusStateImpl.ActiveParent, FocusStateImpl.Inactive);
                                } else if ((nodePop.getKindSet() & iM8585constructorimpl) != 0 && (nodePop instanceof DelegatingNode)) {
                                    int i = 0;
                                    for (Modifier.Node delegate = ((DelegatingNode) nodePop).getDelegate(); delegate != null; delegate = delegate.getChild()) {
                                        if ((delegate.getKindSet() & iM8585constructorimpl) != 0) {
                                            i++;
                                            if (i == 1) {
                                                nodePop = delegate;
                                            } else {
                                                if (mutableVector == null) {
                                                    mutableVector = new MutableVector(new Modifier.Node[16], 0);
                                                }
                                                if (nodePop != null) {
                                                    if (mutableVector != null) {
                                                        mutableVector.add(nodePop);
                                                    }
                                                    nodePop = null;
                                                }
                                                if (mutableVector != null) {
                                                    mutableVector.add(delegate);
                                                }
                                            }
                                        }
                                    }
                                    if (i == 1) {
                                    }
                                }
                                nodePop = DelegatableNodeKt.pop(mutableVector);
                            }
                        }
                        parent = parent.getParent();
                    }
                }
                layoutNodeRequireLayoutNode = layoutNodeRequireLayoutNode.getParent$ui();
                parent = (layoutNodeRequireLayoutNode == null || (nodes = layoutNodeRequireLayoutNode.getNodes()) == null) ? null : nodes.getTail();
            }
        }
        return true;
    }

    @Override // androidx.compose.ui.focus.FocusManager
    /* JADX INFO: renamed from: moveFocus-3ESFkO8 */
    public boolean mo6458moveFocus3ESFkO8(int focusDirection) {
        return mo6464moveFocusaToIllA(focusDirection, true);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r3v0, types: [T, java.lang.Boolean] */
    @Override // androidx.compose.ui.focus.FocusOwner
    /* JADX INFO: renamed from: moveFocus-aToIllA */
    public boolean mo6464moveFocusaToIllA(final int focusDirection, boolean wrapAroundForOneDimensionalFocus) {
        FocusTargetNode activeFocusTargetNode;
        if ((ComposeUiFlags.isViewFocusFixEnabled || (ComposeUiFlags.isBypassUnfocusableComposeViewEnabled && (activeFocusTargetNode = getActiveFocusTargetNode()) != null && activeFocusTargetNode.getIsInteropViewHost())) && this.platformFocusOwner.mo6510moveFocusInChildren3ESFkO8(focusDirection)) {
            return true;
        }
        final Ref.ObjectRef objectRef = new Ref.ObjectRef();
        objectRef.element = false;
        FocusTargetNode activeFocusTargetNode2 = getActiveFocusTargetNode();
        Boolean boolMo6463focusSearchULY8qGw = mo6463focusSearchULY8qGw(focusDirection, this.platformFocusOwner.getEmbeddedViewFocusRect(), new Function1<FocusTargetNode, Boolean>() { // from class: androidx.compose.ui.focus.FocusOwnerImpl$moveFocus$focusSearchSuccess$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            /* JADX WARN: Type inference failed for: r3v2, types: [T, java.lang.Boolean] */
            @Override // kotlin.jvm.functions.Function1
            public final Boolean invoke(FocusTargetNode focusTargetNode) {
                objectRef.element = Boolean.valueOf(focusTargetNode.mo6478requestFocus3ESFkO8(focusDirection));
                return objectRef.element;
            }
        });
        if (Intrinsics.areEqual((Object) boolMo6463focusSearchULY8qGw, (Object) true) && activeFocusTargetNode2 != getActiveFocusTargetNode()) {
            return true;
        }
        if (boolMo6463focusSearchULY8qGw != null && objectRef.element != 0) {
            if (boolMo6463focusSearchULY8qGw.booleanValue() && ((Boolean) objectRef.element).booleanValue()) {
                return true;
            }
            if (FocusOwnerImplKt.m6471is1dFocusSearch3ESFkO8(focusDirection) && wrapAroundForOneDimensionalFocus) {
                return mo6460clearFocusI7lrPNg(false, true, false, focusDirection) && mo6467takeFocusaToIllA(focusDirection, null);
            }
            if (!ComposeUiFlags.isViewFocusFixEnabled && !ComposeUiFlags.isBypassUnfocusableComposeViewEnabled) {
                return this.platformFocusOwner.mo6510moveFocusInChildren3ESFkO8(focusDirection);
            }
        }
        return false;
    }

    @Override // androidx.compose.ui.focus.FocusOwner
    /* JADX INFO: renamed from: focusSearch-ULY8qGw */
    public Boolean mo6463focusSearchULY8qGw(int focusDirection, Rect focusedRect, final Function1<? super FocusTargetNode, Boolean> onFound) {
        final FocusTargetNode focusTargetNodeFindFocusTargetNode = findFocusTargetNode();
        if (focusTargetNodeFindFocusTargetNode != null) {
            FocusRequester focusRequesterM6493customFocusSearchOMvw8 = FocusTraversalKt.m6493customFocusSearchOMvw8(focusTargetNodeFindFocusTargetNode, focusDirection, this.owner.getLayoutDirection());
            if (Intrinsics.areEqual(focusRequesterM6493customFocusSearchOMvw8, FocusRequester.INSTANCE.getCancel())) {
                return null;
            }
            if (Intrinsics.areEqual(focusRequesterM6493customFocusSearchOMvw8, FocusRequester.INSTANCE.getRedirect$ui())) {
                FocusTargetNode focusTargetNodeFindFocusTargetNode2 = findFocusTargetNode();
                if (focusTargetNodeFindFocusTargetNode2 != null) {
                    return onFound.invoke(focusTargetNodeFindFocusTargetNode2);
                }
                return null;
            }
            if (!Intrinsics.areEqual(focusRequesterM6493customFocusSearchOMvw8, FocusRequester.INSTANCE.getDefault())) {
                if (!ComposeUiFlags.isRequestFocusOnNonFocusableFocusTargetEnabled) {
                    return Boolean.valueOf(focusRequesterM6493customFocusSearchOMvw8.findFocusTargetNode$ui(onFound));
                }
                if (focusRequesterM6493customFocusSearchOMvw8 == FocusRequester.INSTANCE.getDefault()) {
                    throw new IllegalStateException("\n    Please check whether the focusRequester is FocusRequester.Cancel or FocusRequester.Default\n    before invoking any functions on the focusRequester.\n".toString());
                }
                if (focusRequesterM6493customFocusSearchOMvw8 == FocusRequester.INSTANCE.getCancel()) {
                    throw new IllegalStateException("\n    Please check whether the focusRequester is FocusRequester.Cancel or FocusRequester.Default\n    before invoking any functions on the focusRequester.\n".toString());
                }
                boolean z = false;
                if (focusRequesterM6493customFocusSearchOMvw8.getFocusRequesterNodes$ui().getSize() == 0) {
                    System.out.println((Object) "FocusRelatedWarning: \n   FocusRequester is not initialized. Here are some possible fixes:\n\n   1. Remember the FocusRequester: val focusRequester = remember { FocusRequester() }\n   2. Did you forget to add a Modifier.focusRequester() ?\n   3. Are you attempting to request focus during composition? Focus requests should be made in\n   response to some event. Eg Modifier.clickable { focusRequester.requestFocus() }\n");
                } else {
                    MutableVector<FocusRequesterModifierNode> focusRequesterNodes$ui = focusRequesterM6493customFocusSearchOMvw8.getFocusRequesterNodes$ui();
                    FocusRequesterModifierNode[] focusRequesterModifierNodeArr = focusRequesterNodes$ui.content;
                    int size = focusRequesterNodes$ui.getSize();
                    boolean z2 = false;
                    for (int i = 0; i < size; i++) {
                        FocusRequesterModifierNode focusRequesterModifierNode = focusRequesterModifierNodeArr[i];
                        int iM8585constructorimpl = NodeKind.m8585constructorimpl(1024);
                        if (!focusRequesterModifierNode.getNode().getIsAttached()) {
                            InlineClassHelperKt.throwIllegalStateException("visitChildren called on an unattached node");
                        }
                        MutableVector mutableVector = new MutableVector(new Modifier.Node[16], 0);
                        Modifier.Node child = focusRequesterModifierNode.getNode().getChild();
                        if (child == null) {
                            DelegatableNodeKt.addLayoutNodeChildren(mutableVector, focusRequesterModifierNode.getNode(), false);
                        } else {
                            mutableVector.add(child);
                        }
                        while (mutableVector.getSize() != 0) {
                            Modifier.Node nodePop = (Modifier.Node) mutableVector.removeAt(mutableVector.getSize() - 1);
                            if ((nodePop.getAggregateChildKindSet() & iM8585constructorimpl) == 0) {
                                DelegatableNodeKt.addLayoutNodeChildren(mutableVector, nodePop, false);
                            } else {
                                while (nodePop != null) {
                                    if ((nodePop.getKindSet() & iM8585constructorimpl) != 0) {
                                        MutableVector mutableVector2 = null;
                                        while (nodePop != null) {
                                            if (nodePop instanceof FocusTargetNode) {
                                                if (onFound.invoke((FocusTargetNode) nodePop).booleanValue()) {
                                                    z2 = true;
                                                    break;
                                                }
                                            } else if ((nodePop.getKindSet() & iM8585constructorimpl) != 0 && (nodePop instanceof DelegatingNode)) {
                                                int i2 = 0;
                                                for (Modifier.Node delegate = ((DelegatingNode) nodePop).getDelegate(); delegate != null; delegate = delegate.getChild()) {
                                                    if ((delegate.getKindSet() & iM8585constructorimpl) != 0) {
                                                        i2++;
                                                        if (i2 == 1) {
                                                            nodePop = delegate;
                                                        } else {
                                                            if (mutableVector2 == null) {
                                                                mutableVector2 = new MutableVector(new Modifier.Node[16], 0);
                                                            }
                                                            if (nodePop != null) {
                                                                if (mutableVector2 != null) {
                                                                    mutableVector2.add(nodePop);
                                                                }
                                                                nodePop = null;
                                                            }
                                                            if (mutableVector2 != null) {
                                                                mutableVector2.add(delegate);
                                                            }
                                                        }
                                                    }
                                                }
                                                if (i2 == 1) {
                                                }
                                            }
                                            nodePop = DelegatableNodeKt.pop(mutableVector2);
                                        }
                                        break;
                                    }
                                    nodePop = nodePop.getChild();
                                }
                            }
                        }
                    }
                    z = z2;
                }
                return Boolean.valueOf(z);
            }
        } else {
            focusTargetNodeFindFocusTargetNode = null;
        }
        return FocusTraversalKt.m6494focusSearch0X8WOeE(this.rootFocusNode, focusDirection, this.owner.getLayoutDirection(), focusedRect, new Function1<FocusTargetNode, Boolean>() { // from class: androidx.compose.ui.focus.FocusOwnerImpl$focusSearch$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Boolean invoke(FocusTargetNode focusTargetNode) {
                boolean zBooleanValue;
                if (Intrinsics.areEqual(focusTargetNode, focusTargetNodeFindFocusTargetNode)) {
                    zBooleanValue = false;
                } else {
                    if (Intrinsics.areEqual(focusTargetNode, this.getRootFocusNode())) {
                        throw new IllegalStateException("Focus search landed at the root.".toString());
                    }
                    zBooleanValue = onFound.invoke(focusTargetNode).booleanValue();
                }
                return Boolean.valueOf(zBooleanValue);
            }
        });
    }

    /* JADX WARN: Code duplicated, block: B:115:0x01a7 A[Catch: all -> 0x0390, TryCatch #0 {all -> 0x0390, blocks: (B:3:0x0009, B:5:0x0012, B:8:0x001d, B:12:0x0027, B:15:0x0036, B:118:0x01af, B:120:0x01bf, B:121:0x01c2, B:123:0x01d1, B:126:0x01e2, B:130:0x01ed, B:133:0x01f3, B:134:0x01fa, B:157:0x0248, B:135:0x01fe, B:137:0x0205, B:139:0x0209, B:141:0x0213, B:143:0x021a, B:145:0x021e, B:147:0x0224, B:150:0x022f, B:153:0x0239, B:154:0x0240, B:158:0x024d, B:159:0x0252, B:161:0x0258, B:163:0x025e, B:166:0x0269, B:168:0x0274, B:175:0x028b, B:176:0x028d, B:178:0x0294, B:180:0x0298, B:206:0x02ee, B:184:0x02a4, B:186:0x02ab, B:188:0x02af, B:190:0x02b9, B:192:0x02c0, B:194:0x02c4, B:196:0x02ca, B:199:0x02d5, B:202:0x02df, B:203:0x02e6, B:207:0x02f3, B:211:0x0303, B:213:0x030a, B:215:0x030e, B:241:0x0364, B:219:0x031a, B:221:0x0321, B:223:0x0325, B:225:0x032f, B:227:0x0336, B:229:0x033a, B:231:0x0340, B:234:0x034b, B:237:0x0355, B:238:0x035c, B:243:0x036b, B:245:0x0375, B:250:0x0388, B:251:0x038a, B:18:0x0041, B:20:0x0051, B:21:0x0054, B:23:0x005e, B:26:0x006f, B:30:0x007a, B:64:0x00ea, B:66:0x00ee, B:33:0x0080, B:35:0x0087, B:37:0x008b, B:39:0x0095, B:41:0x009c, B:43:0x00a0, B:45:0x00a6, B:48:0x00b1, B:51:0x00bb, B:52:0x00c2, B:55:0x00ca, B:56:0x00cf, B:57:0x00d4, B:59:0x00da, B:61:0x00e0, B:67:0x00f4, B:69:0x0106, B:70:0x0109, B:72:0x0117, B:75:0x0128, B:79:0x0133, B:113:0x01a3, B:115:0x01a7, B:82:0x0139, B:84:0x0140, B:86:0x0144, B:88:0x014e, B:90:0x0155, B:92:0x0159, B:94:0x015f, B:97:0x016a, B:100:0x0174, B:101:0x017b, B:104:0x0183, B:105:0x0188, B:106:0x018d, B:108:0x0193, B:110:0x0199), top: B:257:0x0009 }] */
    /* JADX WARN: Code duplicated, block: B:116:0x01ac  */
    /* JADX WARN: Code duplicated, block: B:338:0x01a2 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:339:0x0137 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:347:0x0188 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:67:0x00f4 A[Catch: all -> 0x0390, TryCatch #0 {all -> 0x0390, blocks: (B:3:0x0009, B:5:0x0012, B:8:0x001d, B:12:0x0027, B:15:0x0036, B:118:0x01af, B:120:0x01bf, B:121:0x01c2, B:123:0x01d1, B:126:0x01e2, B:130:0x01ed, B:133:0x01f3, B:134:0x01fa, B:157:0x0248, B:135:0x01fe, B:137:0x0205, B:139:0x0209, B:141:0x0213, B:143:0x021a, B:145:0x021e, B:147:0x0224, B:150:0x022f, B:153:0x0239, B:154:0x0240, B:158:0x024d, B:159:0x0252, B:161:0x0258, B:163:0x025e, B:166:0x0269, B:168:0x0274, B:175:0x028b, B:176:0x028d, B:178:0x0294, B:180:0x0298, B:206:0x02ee, B:184:0x02a4, B:186:0x02ab, B:188:0x02af, B:190:0x02b9, B:192:0x02c0, B:194:0x02c4, B:196:0x02ca, B:199:0x02d5, B:202:0x02df, B:203:0x02e6, B:207:0x02f3, B:211:0x0303, B:213:0x030a, B:215:0x030e, B:241:0x0364, B:219:0x031a, B:221:0x0321, B:223:0x0325, B:225:0x032f, B:227:0x0336, B:229:0x033a, B:231:0x0340, B:234:0x034b, B:237:0x0355, B:238:0x035c, B:243:0x036b, B:245:0x0375, B:250:0x0388, B:251:0x038a, B:18:0x0041, B:20:0x0051, B:21:0x0054, B:23:0x005e, B:26:0x006f, B:30:0x007a, B:64:0x00ea, B:66:0x00ee, B:33:0x0080, B:35:0x0087, B:37:0x008b, B:39:0x0095, B:41:0x009c, B:43:0x00a0, B:45:0x00a6, B:48:0x00b1, B:51:0x00bb, B:52:0x00c2, B:55:0x00ca, B:56:0x00cf, B:57:0x00d4, B:59:0x00da, B:61:0x00e0, B:67:0x00f4, B:69:0x0106, B:70:0x0109, B:72:0x0117, B:75:0x0128, B:79:0x0133, B:113:0x01a3, B:115:0x01a7, B:82:0x0139, B:84:0x0140, B:86:0x0144, B:88:0x014e, B:90:0x0155, B:92:0x0159, B:94:0x015f, B:97:0x016a, B:100:0x0174, B:101:0x017b, B:104:0x0183, B:105:0x0188, B:106:0x018d, B:108:0x0193, B:110:0x0199), top: B:257:0x0009 }] */
    /* JADX WARN: Code duplicated, block: B:69:0x0106 A[Catch: all -> 0x0390, TryCatch #0 {all -> 0x0390, blocks: (B:3:0x0009, B:5:0x0012, B:8:0x001d, B:12:0x0027, B:15:0x0036, B:118:0x01af, B:120:0x01bf, B:121:0x01c2, B:123:0x01d1, B:126:0x01e2, B:130:0x01ed, B:133:0x01f3, B:134:0x01fa, B:157:0x0248, B:135:0x01fe, B:137:0x0205, B:139:0x0209, B:141:0x0213, B:143:0x021a, B:145:0x021e, B:147:0x0224, B:150:0x022f, B:153:0x0239, B:154:0x0240, B:158:0x024d, B:159:0x0252, B:161:0x0258, B:163:0x025e, B:166:0x0269, B:168:0x0274, B:175:0x028b, B:176:0x028d, B:178:0x0294, B:180:0x0298, B:206:0x02ee, B:184:0x02a4, B:186:0x02ab, B:188:0x02af, B:190:0x02b9, B:192:0x02c0, B:194:0x02c4, B:196:0x02ca, B:199:0x02d5, B:202:0x02df, B:203:0x02e6, B:207:0x02f3, B:211:0x0303, B:213:0x030a, B:215:0x030e, B:241:0x0364, B:219:0x031a, B:221:0x0321, B:223:0x0325, B:225:0x032f, B:227:0x0336, B:229:0x033a, B:231:0x0340, B:234:0x034b, B:237:0x0355, B:238:0x035c, B:243:0x036b, B:245:0x0375, B:250:0x0388, B:251:0x038a, B:18:0x0041, B:20:0x0051, B:21:0x0054, B:23:0x005e, B:26:0x006f, B:30:0x007a, B:64:0x00ea, B:66:0x00ee, B:33:0x0080, B:35:0x0087, B:37:0x008b, B:39:0x0095, B:41:0x009c, B:43:0x00a0, B:45:0x00a6, B:48:0x00b1, B:51:0x00bb, B:52:0x00c2, B:55:0x00ca, B:56:0x00cf, B:57:0x00d4, B:59:0x00da, B:61:0x00e0, B:67:0x00f4, B:69:0x0106, B:70:0x0109, B:72:0x0117, B:75:0x0128, B:79:0x0133, B:113:0x01a3, B:115:0x01a7, B:82:0x0139, B:84:0x0140, B:86:0x0144, B:88:0x014e, B:90:0x0155, B:92:0x0159, B:94:0x015f, B:97:0x016a, B:100:0x0174, B:101:0x017b, B:104:0x0183, B:105:0x0188, B:106:0x018d, B:108:0x0193, B:110:0x0199), top: B:257:0x0009 }] */
    /* JADX WARN: Code duplicated, block: B:72:0x0117 A[Catch: all -> 0x0390, TryCatch #0 {all -> 0x0390, blocks: (B:3:0x0009, B:5:0x0012, B:8:0x001d, B:12:0x0027, B:15:0x0036, B:118:0x01af, B:120:0x01bf, B:121:0x01c2, B:123:0x01d1, B:126:0x01e2, B:130:0x01ed, B:133:0x01f3, B:134:0x01fa, B:157:0x0248, B:135:0x01fe, B:137:0x0205, B:139:0x0209, B:141:0x0213, B:143:0x021a, B:145:0x021e, B:147:0x0224, B:150:0x022f, B:153:0x0239, B:154:0x0240, B:158:0x024d, B:159:0x0252, B:161:0x0258, B:163:0x025e, B:166:0x0269, B:168:0x0274, B:175:0x028b, B:176:0x028d, B:178:0x0294, B:180:0x0298, B:206:0x02ee, B:184:0x02a4, B:186:0x02ab, B:188:0x02af, B:190:0x02b9, B:192:0x02c0, B:194:0x02c4, B:196:0x02ca, B:199:0x02d5, B:202:0x02df, B:203:0x02e6, B:207:0x02f3, B:211:0x0303, B:213:0x030a, B:215:0x030e, B:241:0x0364, B:219:0x031a, B:221:0x0321, B:223:0x0325, B:225:0x032f, B:227:0x0336, B:229:0x033a, B:231:0x0340, B:234:0x034b, B:237:0x0355, B:238:0x035c, B:243:0x036b, B:245:0x0375, B:250:0x0388, B:251:0x038a, B:18:0x0041, B:20:0x0051, B:21:0x0054, B:23:0x005e, B:26:0x006f, B:30:0x007a, B:64:0x00ea, B:66:0x00ee, B:33:0x0080, B:35:0x0087, B:37:0x008b, B:39:0x0095, B:41:0x009c, B:43:0x00a0, B:45:0x00a6, B:48:0x00b1, B:51:0x00bb, B:52:0x00c2, B:55:0x00ca, B:56:0x00cf, B:57:0x00d4, B:59:0x00da, B:61:0x00e0, B:67:0x00f4, B:69:0x0106, B:70:0x0109, B:72:0x0117, B:75:0x0128, B:79:0x0133, B:113:0x01a3, B:115:0x01a7, B:82:0x0139, B:84:0x0140, B:86:0x0144, B:88:0x014e, B:90:0x0155, B:92:0x0159, B:94:0x015f, B:97:0x016a, B:100:0x0174, B:101:0x017b, B:104:0x0183, B:105:0x0188, B:106:0x018d, B:108:0x0193, B:110:0x0199), top: B:257:0x0009 }] */
    /* JADX WARN: Code duplicated, block: B:74:0x0126 A[ADDED_TO_REGION, LOOP:15: B:74:0x0126->B:105:0x0188, LOOP_START, PHI: r9
      0x0126: PHI (r9v11 androidx.compose.ui.Modifier$Node) = (r9v4 androidx.compose.ui.Modifier$Node), (r9v12 androidx.compose.ui.Modifier$Node) binds: [B:73:0x0124, B:105:0x0188] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:75:0x0128 A[Catch: all -> 0x0390, TryCatch #0 {all -> 0x0390, blocks: (B:3:0x0009, B:5:0x0012, B:8:0x001d, B:12:0x0027, B:15:0x0036, B:118:0x01af, B:120:0x01bf, B:121:0x01c2, B:123:0x01d1, B:126:0x01e2, B:130:0x01ed, B:133:0x01f3, B:134:0x01fa, B:157:0x0248, B:135:0x01fe, B:137:0x0205, B:139:0x0209, B:141:0x0213, B:143:0x021a, B:145:0x021e, B:147:0x0224, B:150:0x022f, B:153:0x0239, B:154:0x0240, B:158:0x024d, B:159:0x0252, B:161:0x0258, B:163:0x025e, B:166:0x0269, B:168:0x0274, B:175:0x028b, B:176:0x028d, B:178:0x0294, B:180:0x0298, B:206:0x02ee, B:184:0x02a4, B:186:0x02ab, B:188:0x02af, B:190:0x02b9, B:192:0x02c0, B:194:0x02c4, B:196:0x02ca, B:199:0x02d5, B:202:0x02df, B:203:0x02e6, B:207:0x02f3, B:211:0x0303, B:213:0x030a, B:215:0x030e, B:241:0x0364, B:219:0x031a, B:221:0x0321, B:223:0x0325, B:225:0x032f, B:227:0x0336, B:229:0x033a, B:231:0x0340, B:234:0x034b, B:237:0x0355, B:238:0x035c, B:243:0x036b, B:245:0x0375, B:250:0x0388, B:251:0x038a, B:18:0x0041, B:20:0x0051, B:21:0x0054, B:23:0x005e, B:26:0x006f, B:30:0x007a, B:64:0x00ea, B:66:0x00ee, B:33:0x0080, B:35:0x0087, B:37:0x008b, B:39:0x0095, B:41:0x009c, B:43:0x00a0, B:45:0x00a6, B:48:0x00b1, B:51:0x00bb, B:52:0x00c2, B:55:0x00ca, B:56:0x00cf, B:57:0x00d4, B:59:0x00da, B:61:0x00e0, B:67:0x00f4, B:69:0x0106, B:70:0x0109, B:72:0x0117, B:75:0x0128, B:79:0x0133, B:113:0x01a3, B:115:0x01a7, B:82:0x0139, B:84:0x0140, B:86:0x0144, B:88:0x014e, B:90:0x0155, B:92:0x0159, B:94:0x015f, B:97:0x016a, B:100:0x0174, B:101:0x017b, B:104:0x0183, B:105:0x0188, B:106:0x018d, B:108:0x0193, B:110:0x0199), top: B:257:0x0009 }] */
    /* JADX WARN: Code duplicated, block: B:77:0x012f  */
    /* JADX WARN: Code duplicated, block: B:79:0x0133 A[Catch: all -> 0x0390, TryCatch #0 {all -> 0x0390, blocks: (B:3:0x0009, B:5:0x0012, B:8:0x001d, B:12:0x0027, B:15:0x0036, B:118:0x01af, B:120:0x01bf, B:121:0x01c2, B:123:0x01d1, B:126:0x01e2, B:130:0x01ed, B:133:0x01f3, B:134:0x01fa, B:157:0x0248, B:135:0x01fe, B:137:0x0205, B:139:0x0209, B:141:0x0213, B:143:0x021a, B:145:0x021e, B:147:0x0224, B:150:0x022f, B:153:0x0239, B:154:0x0240, B:158:0x024d, B:159:0x0252, B:161:0x0258, B:163:0x025e, B:166:0x0269, B:168:0x0274, B:175:0x028b, B:176:0x028d, B:178:0x0294, B:180:0x0298, B:206:0x02ee, B:184:0x02a4, B:186:0x02ab, B:188:0x02af, B:190:0x02b9, B:192:0x02c0, B:194:0x02c4, B:196:0x02ca, B:199:0x02d5, B:202:0x02df, B:203:0x02e6, B:207:0x02f3, B:211:0x0303, B:213:0x030a, B:215:0x030e, B:241:0x0364, B:219:0x031a, B:221:0x0321, B:223:0x0325, B:225:0x032f, B:227:0x0336, B:229:0x033a, B:231:0x0340, B:234:0x034b, B:237:0x0355, B:238:0x035c, B:243:0x036b, B:245:0x0375, B:250:0x0388, B:251:0x038a, B:18:0x0041, B:20:0x0051, B:21:0x0054, B:23:0x005e, B:26:0x006f, B:30:0x007a, B:64:0x00ea, B:66:0x00ee, B:33:0x0080, B:35:0x0087, B:37:0x008b, B:39:0x0095, B:41:0x009c, B:43:0x00a0, B:45:0x00a6, B:48:0x00b1, B:51:0x00bb, B:52:0x00c2, B:55:0x00ca, B:56:0x00cf, B:57:0x00d4, B:59:0x00da, B:61:0x00e0, B:67:0x00f4, B:69:0x0106, B:70:0x0109, B:72:0x0117, B:75:0x0128, B:79:0x0133, B:113:0x01a3, B:115:0x01a7, B:82:0x0139, B:84:0x0140, B:86:0x0144, B:88:0x014e, B:90:0x0155, B:92:0x0159, B:94:0x015f, B:97:0x016a, B:100:0x0174, B:101:0x017b, B:104:0x0183, B:105:0x0188, B:106:0x018d, B:108:0x0193, B:110:0x0199), top: B:257:0x0009 }] */
    /* JADX WARN: Code duplicated, block: B:82:0x0139 A[Catch: all -> 0x0390, TryCatch #0 {all -> 0x0390, blocks: (B:3:0x0009, B:5:0x0012, B:8:0x001d, B:12:0x0027, B:15:0x0036, B:118:0x01af, B:120:0x01bf, B:121:0x01c2, B:123:0x01d1, B:126:0x01e2, B:130:0x01ed, B:133:0x01f3, B:134:0x01fa, B:157:0x0248, B:135:0x01fe, B:137:0x0205, B:139:0x0209, B:141:0x0213, B:143:0x021a, B:145:0x021e, B:147:0x0224, B:150:0x022f, B:153:0x0239, B:154:0x0240, B:158:0x024d, B:159:0x0252, B:161:0x0258, B:163:0x025e, B:166:0x0269, B:168:0x0274, B:175:0x028b, B:176:0x028d, B:178:0x0294, B:180:0x0298, B:206:0x02ee, B:184:0x02a4, B:186:0x02ab, B:188:0x02af, B:190:0x02b9, B:192:0x02c0, B:194:0x02c4, B:196:0x02ca, B:199:0x02d5, B:202:0x02df, B:203:0x02e6, B:207:0x02f3, B:211:0x0303, B:213:0x030a, B:215:0x030e, B:241:0x0364, B:219:0x031a, B:221:0x0321, B:223:0x0325, B:225:0x032f, B:227:0x0336, B:229:0x033a, B:231:0x0340, B:234:0x034b, B:237:0x0355, B:238:0x035c, B:243:0x036b, B:245:0x0375, B:250:0x0388, B:251:0x038a, B:18:0x0041, B:20:0x0051, B:21:0x0054, B:23:0x005e, B:26:0x006f, B:30:0x007a, B:64:0x00ea, B:66:0x00ee, B:33:0x0080, B:35:0x0087, B:37:0x008b, B:39:0x0095, B:41:0x009c, B:43:0x00a0, B:45:0x00a6, B:48:0x00b1, B:51:0x00bb, B:52:0x00c2, B:55:0x00ca, B:56:0x00cf, B:57:0x00d4, B:59:0x00da, B:61:0x00e0, B:67:0x00f4, B:69:0x0106, B:70:0x0109, B:72:0x0117, B:75:0x0128, B:79:0x0133, B:113:0x01a3, B:115:0x01a7, B:82:0x0139, B:84:0x0140, B:86:0x0144, B:88:0x014e, B:90:0x0155, B:92:0x0159, B:94:0x015f, B:97:0x016a, B:100:0x0174, B:101:0x017b, B:104:0x0183, B:105:0x0188, B:106:0x018d, B:108:0x0193, B:110:0x0199), top: B:257:0x0009 }] */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v30 */
    /* JADX WARN: Type inference failed for: r2v41 */
    /*  JADX ERROR: NullPointerException in pass: PrepareForCodeGen
        java.lang.NullPointerException
        */
    @Override // androidx.compose.ui.focus.FocusOwner
    /* JADX INFO: renamed from: dispatchKeyEvent-YhN2O0w */
    public boolean mo6462dispatchKeyEventYhN2O0w(android.view.KeyEvent r17, kotlin.jvm.functions.Function0<java.lang.Boolean> r18) {
        /*
            Method dump skipped, instruction units count: 917
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.ui.focus.FocusOwnerImpl.mo6462dispatchKeyEventYhN2O0w(android.view.KeyEvent, kotlin.jvm.functions.Function0):boolean");
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v15 */
    /* JADX WARN: Type inference failed for: r0v16, types: [androidx.compose.ui.Modifier$Node] */
    /* JADX WARN: Type inference failed for: r0v17, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r0v18 */
    /* JADX WARN: Type inference failed for: r0v19 */
    /* JADX WARN: Type inference failed for: r0v20 */
    /* JADX WARN: Type inference failed for: r0v21 */
    /* JADX WARN: Type inference failed for: r0v24 */
    /* JADX WARN: Type inference failed for: r0v25, types: [androidx.compose.ui.Modifier$Node] */
    /* JADX WARN: Type inference failed for: r0v26, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r0v27 */
    /* JADX WARN: Type inference failed for: r0v28 */
    /* JADX WARN: Type inference failed for: r0v29 */
    /* JADX WARN: Type inference failed for: r0v30 */
    /* JADX WARN: Type inference failed for: r0v46 */
    /* JADX WARN: Type inference failed for: r0v47 */
    /* JADX WARN: Type inference failed for: r0v48 */
    /* JADX WARN: Type inference failed for: r0v49 */
    /* JADX WARN: Type inference failed for: r0v6, types: [androidx.compose.ui.Modifier$Node] */
    /* JADX WARN: Type inference failed for: r0v7, types: [androidx.compose.ui.Modifier$Node] */
    /* JADX WARN: Type inference failed for: r0v8, types: [androidx.compose.ui.Modifier$Node] */
    /* JADX WARN: Type inference failed for: r0v9, types: [androidx.compose.ui.Modifier$Node] */
    /* JADX WARN: Type inference failed for: r10v16 */
    /* JADX WARN: Type inference failed for: r7v13 */
    /* JADX WARN: Type inference failed for: r7v4 */
    /* JADX WARN: Type inference failed for: r8v16 */
    /* JADX WARN: Type inference failed for: r8v17, types: [androidx.compose.ui.Modifier$Node] */
    /* JADX WARN: Type inference failed for: r8v18 */
    /* JADX WARN: Type inference failed for: r8v19, types: [androidx.compose.ui.Modifier$Node] */
    /* JADX WARN: Type inference failed for: r8v20, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r8v21 */
    /* JADX WARN: Type inference failed for: r8v22 */
    /* JADX WARN: Type inference failed for: r8v23 */
    /* JADX WARN: Type inference failed for: r8v24 */
    /* JADX WARN: Type inference failed for: r8v25 */
    /* JADX WARN: Type inference failed for: r8v26 */
    /* JADX WARN: Type inference failed for: r8v7 */
    /* JADX WARN: Type inference failed for: r8v8 */
    /*  JADX ERROR: NullPointerException in pass: PrepareForCodeGen
        java.lang.NullPointerException
        */
    @Override // androidx.compose.ui.focus.FocusOwner
    /* JADX INFO: renamed from: dispatchInterceptedSoftKeyboardEvent-ZmokQxo */
    public boolean mo6461dispatchInterceptedSoftKeyboardEventZmokQxo(android.view.KeyEvent r14) {
        /*
            Method dump skipped, instruction units count: 612
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.ui.focus.FocusOwnerImpl.mo6461dispatchInterceptedSoftKeyboardEventZmokQxo(android.view.KeyEvent):boolean");
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v21 */
    /* JADX WARN: Type inference failed for: r0v22, types: [androidx.compose.ui.Modifier$Node] */
    /* JADX WARN: Type inference failed for: r0v23, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r0v24 */
    /* JADX WARN: Type inference failed for: r0v25 */
    /* JADX WARN: Type inference failed for: r0v26 */
    /* JADX WARN: Type inference failed for: r0v27 */
    /* JADX WARN: Type inference failed for: r0v43 */
    /* JADX WARN: Type inference failed for: r0v44 */
    /* JADX WARN: Type inference failed for: r0v6, types: [androidx.compose.ui.Modifier$Node] */
    /* JADX WARN: Type inference failed for: r0v7, types: [androidx.compose.ui.Modifier$Node] */
    /* JADX WARN: Type inference failed for: r10v16 */
    /* JADX WARN: Type inference failed for: r15v11 */
    /* JADX WARN: Type inference failed for: r15v12, types: [androidx.compose.ui.Modifier$Node] */
    /* JADX WARN: Type inference failed for: r15v13, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r15v14 */
    /* JADX WARN: Type inference failed for: r15v15 */
    /* JADX WARN: Type inference failed for: r15v16 */
    /* JADX WARN: Type inference failed for: r15v17 */
    /* JADX WARN: Type inference failed for: r15v18 */
    /* JADX WARN: Type inference failed for: r15v19 */
    /* JADX WARN: Type inference failed for: r15v4, types: [androidx.compose.ui.Modifier$Node] */
    /* JADX WARN: Type inference failed for: r15v5, types: [androidx.compose.ui.Modifier$Node] */
    /* JADX WARN: Type inference failed for: r2v11 */
    /* JADX WARN: Type inference failed for: r7v8 */
    /* JADX WARN: Type inference failed for: r8v15 */
    /* JADX WARN: Type inference failed for: r8v16, types: [androidx.compose.ui.Modifier$Node] */
    /* JADX WARN: Type inference failed for: r8v17 */
    /* JADX WARN: Type inference failed for: r8v18, types: [androidx.compose.ui.Modifier$Node] */
    /* JADX WARN: Type inference failed for: r8v19, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r8v20 */
    /* JADX WARN: Type inference failed for: r8v21 */
    /* JADX WARN: Type inference failed for: r8v22 */
    /* JADX WARN: Type inference failed for: r8v23 */
    /* JADX WARN: Type inference failed for: r8v24 */
    /* JADX WARN: Type inference failed for: r8v25 */
    /* JADX WARN: Type inference failed for: r8v6 */
    /* JADX WARN: Type inference failed for: r8v7 */
    /*  JADX ERROR: NullPointerException in pass: PrepareForCodeGen
        java.lang.NullPointerException
        */
    @Override // androidx.compose.ui.focus.FocusOwner
    public boolean dispatchRotaryEvent(androidx.compose.ui.input.rotary.RotaryScrollEvent r14, kotlin.jvm.functions.Function0<java.lang.Boolean> r15) {
        /*
            Method dump skipped, instruction units count: 623
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.ui.focus.FocusOwnerImpl.dispatchRotaryEvent(androidx.compose.ui.input.rotary.RotaryScrollEvent, kotlin.jvm.functions.Function0):boolean");
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r10v13 */
    /* JADX WARN: Type inference failed for: r8v11 */
    /* JADX WARN: Type inference failed for: r8v12, types: [androidx.compose.ui.Modifier$Node] */
    /* JADX WARN: Type inference failed for: r8v13 */
    /* JADX WARN: Type inference failed for: r8v14, types: [androidx.compose.ui.Modifier$Node] */
    /* JADX WARN: Type inference failed for: r8v15, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r8v16 */
    /* JADX WARN: Type inference failed for: r8v17 */
    /* JADX WARN: Type inference failed for: r8v18 */
    /* JADX WARN: Type inference failed for: r8v19 */
    /* JADX WARN: Type inference failed for: r8v2 */
    /* JADX WARN: Type inference failed for: r8v20 */
    /* JADX WARN: Type inference failed for: r8v21 */
    /* JADX WARN: Type inference failed for: r8v3 */
    /*  JADX ERROR: NullPointerException in pass: PrepareForCodeGen
        java.lang.NullPointerException
        */
    @Override // androidx.compose.ui.focus.FocusOwner
    public boolean dispatchIndirectPointerEvent(androidx.compose.ui.input.indirect.IndirectPointerEvent r14) {
        /*
            Method dump skipped, instruction units count: 505
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.ui.focus.FocusOwnerImpl.dispatchIndirectPointerEvent(androidx.compose.ui.input.indirect.IndirectPointerEvent):boolean");
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r10v13 */
    /* JADX WARN: Type inference failed for: r8v11 */
    /* JADX WARN: Type inference failed for: r8v12, types: [androidx.compose.ui.Modifier$Node] */
    /* JADX WARN: Type inference failed for: r8v13 */
    /* JADX WARN: Type inference failed for: r8v14, types: [androidx.compose.ui.Modifier$Node] */
    /* JADX WARN: Type inference failed for: r8v15, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r8v16 */
    /* JADX WARN: Type inference failed for: r8v17 */
    /* JADX WARN: Type inference failed for: r8v18 */
    /* JADX WARN: Type inference failed for: r8v19 */
    /* JADX WARN: Type inference failed for: r8v2 */
    /* JADX WARN: Type inference failed for: r8v20 */
    /* JADX WARN: Type inference failed for: r8v21 */
    /* JADX WARN: Type inference failed for: r8v3 */
    /*  JADX ERROR: NullPointerException in pass: PrepareForCodeGen
        java.lang.NullPointerException
        */
    @Override // androidx.compose.ui.focus.FocusOwner
    public void dispatchIndirectPointerCancel() {
        /*
            Method dump skipped, instruction units count: 382
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.ui.focus.FocusOwnerImpl.dispatchIndirectPointerCancel():void");
    }

    @Override // androidx.compose.ui.focus.FocusOwner
    public void focusTargetAvailable() {
        this.platformFocusOwner.focusTargetAvailable();
    }

    @Override // androidx.compose.ui.focus.FocusOwner
    public void scheduleInvalidation(FocusTargetNode node) {
        this.focusInvalidationManager.scheduleInvalidation(node);
    }

    @Override // androidx.compose.ui.focus.FocusOwner
    public void scheduleInvalidation(FocusEventModifierNode node) {
        this.focusInvalidationManager.scheduleInvalidation(node);
    }

    @Override // androidx.compose.ui.focus.FocusOwner
    public void scheduleInvalidationForOwner() {
        this.focusInvalidationManager.scheduleInvalidation();
    }

    @Override // androidx.compose.ui.focus.FocusOwner
    public Rect getFocusRect() {
        FocusTargetNode focusTargetNodeFindFocusTargetNode = findFocusTargetNode();
        if (focusTargetNodeFindFocusTargetNode != null) {
            return FocusTraversalKt.focusRect(focusTargetNodeFindFocusTargetNode);
        }
        return null;
    }

    @Override // androidx.compose.ui.focus.FocusOwner
    public boolean hasFocusableContent() {
        if (!this.rootFocusNode.getIsAttached()) {
            return false;
        }
        FocusTargetNode focusTargetNode = this.rootFocusNode;
        int iM8585constructorimpl = NodeKind.m8585constructorimpl(1024);
        if (!focusTargetNode.getNode().getIsAttached()) {
            InlineClassHelperKt.throwIllegalStateException("visitSubtreeIf called on an unattached node");
        }
        MutableVector mutableVector = new MutableVector(new Modifier.Node[16], 0);
        Modifier.Node child = focusTargetNode.getNode().getChild();
        if (child == null) {
            DelegatableNodeKt.addLayoutNodeChildren(mutableVector, focusTargetNode.getNode(), false);
        } else {
            mutableVector.add(child);
        }
        while (mutableVector.getSize() != 0) {
            Modifier.Node node = (Modifier.Node) mutableVector.removeAt(mutableVector.getSize() - 1);
            if ((node.getAggregateChildKindSet() & iM8585constructorimpl) != 0) {
                for (Modifier.Node child2 = node; child2 != null && child2.getIsAttached(); child2 = child2.getChild()) {
                    if ((child2.getKindSet() & iM8585constructorimpl) != 0) {
                        Modifier.Node nodePop = child2;
                        MutableVector mutableVector2 = null;
                        while (nodePop != null) {
                            if (nodePop instanceof FocusTargetNode) {
                                FocusTargetNode focusTargetNode2 = (FocusTargetNode) nodePop;
                                if (focusTargetNode2.getIsAttached() && focusTargetNode2.fetchFocusProperties$ui().getCanFocus()) {
                                    return true;
                                }
                            } else if ((nodePop.getKindSet() & iM8585constructorimpl) != 0 && (nodePop instanceof DelegatingNode)) {
                                int i = 0;
                                for (Modifier.Node delegate = ((DelegatingNode) nodePop).getDelegate(); delegate != null; delegate = delegate.getChild()) {
                                    if ((delegate.getKindSet() & iM8585constructorimpl) != 0) {
                                        i++;
                                        if (i == 1) {
                                            nodePop = delegate;
                                        } else {
                                            if (mutableVector2 == null) {
                                                mutableVector2 = new MutableVector(new Modifier.Node[16], 0);
                                            }
                                            if (nodePop != null) {
                                                if (mutableVector2 != null) {
                                                    mutableVector2.add(nodePop);
                                                }
                                                nodePop = null;
                                            }
                                            if (mutableVector2 != null) {
                                                mutableVector2.add(delegate);
                                            }
                                        }
                                    }
                                }
                                if (i == 1) {
                                }
                            }
                            nodePop = DelegatableNodeKt.pop(mutableVector2);
                        }
                    }
                }
            }
            DelegatableNodeKt.addLayoutNodeChildren(mutableVector, node, false);
        }
        return false;
    }

    @Override // androidx.compose.ui.focus.FocusOwner
    public boolean hasNonInteropFocusableContent() {
        if (!this.rootFocusNode.getIsAttached()) {
            return false;
        }
        FocusTargetNode focusTargetNode = this.rootFocusNode;
        int iM8585constructorimpl = NodeKind.m8585constructorimpl(1024);
        if (!focusTargetNode.getNode().getIsAttached()) {
            InlineClassHelperKt.throwIllegalStateException("visitSubtreeIf called on an unattached node");
        }
        MutableVector mutableVector = new MutableVector(new Modifier.Node[16], 0);
        Modifier.Node child = focusTargetNode.getNode().getChild();
        if (child == null) {
            DelegatableNodeKt.addLayoutNodeChildren(mutableVector, focusTargetNode.getNode(), false);
        } else {
            mutableVector.add(child);
        }
        while (mutableVector.getSize() != 0) {
            Modifier.Node node = (Modifier.Node) mutableVector.removeAt(mutableVector.getSize() - 1);
            if ((node.getAggregateChildKindSet() & iM8585constructorimpl) != 0) {
                for (Modifier.Node child2 = node; child2 != null && child2.getIsAttached(); child2 = child2.getChild()) {
                    if ((child2.getKindSet() & iM8585constructorimpl) != 0) {
                        Modifier.Node nodePop = child2;
                        MutableVector mutableVector2 = null;
                        while (nodePop != null) {
                            if (nodePop instanceof FocusTargetNode) {
                                FocusTargetNode focusTargetNode2 = (FocusTargetNode) nodePop;
                                if (focusTargetNode2.getIsAttached()) {
                                    FocusProperties focusPropertiesFetchFocusProperties$ui = focusTargetNode2.fetchFocusProperties$ui();
                                    if (focusTargetNode2.getIsAttached() && !focusTargetNode2.getIsInteropViewHost() && focusPropertiesFetchFocusProperties$ui.getCanFocus()) {
                                        return true;
                                    }
                                }
                            } else if ((nodePop.getKindSet() & iM8585constructorimpl) != 0 && (nodePop instanceof DelegatingNode)) {
                                int i = 0;
                                for (Modifier.Node delegate = ((DelegatingNode) nodePop).getDelegate(); delegate != null; delegate = delegate.getChild()) {
                                    if ((delegate.getKindSet() & iM8585constructorimpl) != 0) {
                                        i++;
                                        if (i == 1) {
                                            nodePop = delegate;
                                        } else {
                                            if (mutableVector2 == null) {
                                                mutableVector2 = new MutableVector(new Modifier.Node[16], 0);
                                            }
                                            if (nodePop != null) {
                                                if (mutableVector2 != null) {
                                                    mutableVector2.add(nodePop);
                                                }
                                                nodePop = null;
                                            }
                                            if (mutableVector2 != null) {
                                                mutableVector2.add(delegate);
                                            }
                                        }
                                    }
                                }
                                if (i == 1) {
                                }
                            }
                            nodePop = DelegatableNodeKt.pop(mutableVector2);
                        }
                    }
                }
            }
            DelegatableNodeKt.addLayoutNodeChildren(mutableVector, node, false);
        }
        return false;
    }

    private final FocusTargetNode findFocusTargetNode() {
        return FocusTraversalKt.findActiveFocusNode(this.rootFocusNode);
    }

    @Override // androidx.compose.ui.focus.FocusOwner
    public FocusState getRootState() {
        return this.rootFocusNode.getFocusState();
    }

    @Override // androidx.compose.ui.focus.FocusOwner
    public MutableObjectList<FocusListener> getListeners() {
        return this.listeners;
    }

    @Override // androidx.compose.ui.focus.FocusOwner
    public FocusTargetNode getActiveFocusTargetNode() {
        FocusTargetNode focusTargetNode = this.activeFocusTargetNode;
        if (focusTargetNode == null || !focusTargetNode.getIsAttached()) {
            return null;
        }
        return this.activeFocusTargetNode;
    }

    @Override // androidx.compose.ui.focus.FocusOwner
    public void setActiveFocusTargetNode(FocusTargetNode focusTargetNode) {
        FocusTargetNode focusTargetNode2 = this.activeFocusTargetNode;
        this.activeFocusTargetNode = focusTargetNode;
        if (focusTargetNode == null || focusTargetNode2 != focusTargetNode) {
            setFocusCaptured(false);
        }
        if (ComposeUiFlags.isSemanticAutofillEnabled) {
            MutableObjectList<FocusListener> listeners = getListeners();
            Object[] objArr = listeners.content;
            int i = listeners._size;
            for (int i2 = 0; i2 < i; i2++) {
                ((FocusListener) objArr[i2]).onFocusChanged(focusTargetNode2, focusTargetNode);
            }
        }
    }

    @Override // androidx.compose.ui.focus.FocusOwner
    /* JADX INFO: renamed from: isFocusCaptured, reason: from getter */
    public boolean getIsFocusCaptured() {
        return this.isFocusCaptured;
    }

    @Override // androidx.compose.ui.focus.FocusOwner
    public void setFocusCaptured(boolean z) {
        if (!((z && getActiveFocusTargetNode() == null) ? false : true)) {
            InlineClassHelperKt.throwIllegalArgumentException("Cannot capture focus when the active focus target node is unset");
        }
        this.isFocusCaptured = z;
    }

    /* JADX INFO: renamed from: validateKeyEvent-ZmokQxo, reason: not valid java name */
    private final boolean m6470validateKeyEventZmokQxo(KeyEvent keyEvent) {
        long jM7977getKeyZmokQxo = KeyEvent_androidKt.m7977getKeyZmokQxo(keyEvent);
        int iM7978getTypeZmokQxo = KeyEvent_androidKt.m7978getTypeZmokQxo(keyEvent);
        if (KeyEventType.m7970equalsimpl0(iM7978getTypeZmokQxo, KeyEventType.INSTANCE.m7974getKeyDownCS__XNY())) {
            MutableLongSet mutableLongSet = this.keysCurrentlyDown;
            if (mutableLongSet == null) {
                mutableLongSet = new MutableLongSet(3);
                this.keysCurrentlyDown = mutableLongSet;
            }
            mutableLongSet.plusAssign(jM7977getKeyZmokQxo);
        } else if (KeyEventType.m7970equalsimpl0(iM7978getTypeZmokQxo, KeyEventType.INSTANCE.m7975getKeyUpCS__XNY())) {
            MutableLongSet mutableLongSet2 = this.keysCurrentlyDown;
            if (mutableLongSet2 == null || !mutableLongSet2.contains(jM7977getKeyZmokQxo)) {
                return false;
            }
            MutableLongSet mutableLongSet3 = this.keysCurrentlyDown;
            if (mutableLongSet3 != null) {
                mutableLongSet3.remove(jM7977getKeyZmokQxo);
            }
        }
        return true;
    }

    /* JADX INFO: renamed from: traverseAncestorsIncludingSelf-QFhIj7k, reason: not valid java name */
    private final /* synthetic */ <T extends DelegatableNode> void m6469traverseAncestorsIncludingSelfQFhIj7k(DelegatableNode delegatableNode, int i, Function1<? super T, Unit> function1, Function0<Unit> function0, Function1<? super T, Unit> function2) {
        int i2;
        int size;
        NodeChain nodes;
        if (!delegatableNode.getNode().getIsAttached()) {
            InlineClassHelperKt.throwIllegalStateException("visitAncestors called on an unattached node");
        }
        Modifier.Node parent = delegatableNode.getNode().getParent();
        LayoutNode layoutNodeRequireLayoutNode = DelegatableNodeKt.requireLayoutNode(delegatableNode);
        ArrayList arrayList = null;
        while (true) {
            if (layoutNodeRequireLayoutNode == null) {
                break;
            }
            if ((layoutNodeRequireLayoutNode.getNodes().getHead().getAggregateChildKindSet() & i) != 0) {
                while (parent != null) {
                    if ((parent.getKindSet() & i) != 0) {
                        Modifier.Node nodePop = parent;
                        MutableVector mutableVector = null;
                        while (nodePop != null) {
                            Intrinsics.reifiedOperationMarker(3, ExifInterface.GPS_DIRECTION_TRUE);
                            if (nodePop instanceof Object) {
                                if (arrayList == null) {
                                    arrayList = new ArrayList();
                                }
                                arrayList.add(nodePop);
                            } else if ((nodePop.getKindSet() & i) != 0 && (nodePop instanceof DelegatingNode)) {
                                int i3 = 0;
                                for (Modifier.Node delegate = ((DelegatingNode) nodePop).getDelegate(); delegate != null; delegate = delegate.getChild()) {
                                    if ((delegate.getKindSet() & i) != 0) {
                                        i3++;
                                        if (i3 == 1) {
                                            nodePop = delegate;
                                        } else {
                                            if (mutableVector == null) {
                                                mutableVector = new MutableVector(new Modifier.Node[16], 0);
                                            }
                                            if (nodePop != null) {
                                                if (mutableVector != null) {
                                                    mutableVector.add(nodePop);
                                                }
                                                nodePop = null;
                                            }
                                            if (mutableVector != null) {
                                                mutableVector.add(delegate);
                                            }
                                        }
                                    }
                                }
                                if (i3 == 1) {
                                }
                            }
                            nodePop = DelegatableNodeKt.pop(mutableVector);
                        }
                    }
                    parent = parent.getParent();
                }
            }
            layoutNodeRequireLayoutNode = layoutNodeRequireLayoutNode.getParent$ui();
            parent = (layoutNodeRequireLayoutNode == null || (nodes = layoutNodeRequireLayoutNode.getNodes()) == null) ? null : nodes.getTail();
        }
        if (arrayList != null && (size = arrayList.size() - 1) >= 0) {
            while (true) {
                int i4 = size - 1;
                function1.invoke((Object) arrayList.get(size));
                if (i4 < 0) {
                    break;
                } else {
                    size = i4;
                }
            }
        }
        Modifier.Node node = delegatableNode.getNode();
        MutableVector mutableVector2 = null;
        while (node != null) {
            Intrinsics.reifiedOperationMarker(3, ExifInterface.GPS_DIRECTION_TRUE);
            if (node instanceof Object) {
                function1.invoke(node);
            } else if ((node.getKindSet() & i) != 0 && (node instanceof DelegatingNode)) {
                int i5 = 0;
                for (Modifier.Node delegate2 = ((DelegatingNode) node).getDelegate(); delegate2 != null; delegate2 = delegate2.getChild()) {
                    if ((delegate2.getKindSet() & i) != 0) {
                        i5++;
                        if (i5 == 1) {
                            node = delegate2;
                        } else {
                            if (mutableVector2 == null) {
                                mutableVector2 = new MutableVector(new Modifier.Node[16], 0);
                            }
                            if (node != null) {
                                if (mutableVector2 != null) {
                                    mutableVector2.add(node);
                                }
                                node = null;
                            }
                            if (mutableVector2 != null) {
                                mutableVector2.add(delegate2);
                            }
                        }
                    }
                }
                if (i5 == 1) {
                }
            }
            node = DelegatableNodeKt.pop(mutableVector2);
        }
        function0.invoke();
        Modifier.Node node2 = delegatableNode.getNode();
        MutableVector mutableVector3 = null;
        while (node2 != null) {
            Intrinsics.reifiedOperationMarker(3, ExifInterface.GPS_DIRECTION_TRUE);
            if (node2 instanceof Object) {
                function2.invoke(node2);
            } else if ((node2.getKindSet() & i) != 0 && (node2 instanceof DelegatingNode)) {
                int i6 = 0;
                for (Modifier.Node delegate3 = ((DelegatingNode) node2).getDelegate(); delegate3 != null; delegate3 = delegate3.getChild()) {
                    if ((delegate3.getKindSet() & i) != 0) {
                        i6++;
                        if (i6 == 1) {
                            node2 = delegate3;
                        } else {
                            if (mutableVector3 == null) {
                                mutableVector3 = new MutableVector(new Modifier.Node[16], 0);
                            }
                            if (node2 != null) {
                                if (mutableVector3 != null) {
                                    mutableVector3.add(node2);
                                }
                                node2 = null;
                            }
                            if (mutableVector3 != null) {
                                mutableVector3.add(delegate3);
                            }
                        }
                    }
                }
                if (i6 == 1) {
                }
            }
            node2 = DelegatableNodeKt.pop(mutableVector3);
        }
        if (arrayList != null) {
            int size2 = arrayList.size();
            for (i2 = 0; i2 < size2; i2++) {
                function2.invoke((Object) arrayList.get(i2));
            }
        }
    }

    /* JADX INFO: renamed from: nearestAncestorIncludingSelf-64DMado, reason: not valid java name */
    private final /* synthetic */ <T> T m6468nearestAncestorIncludingSelf64DMado(DelegatableNode delegatableNode, int i) {
        NodeChain nodes;
        if (!delegatableNode.getNode().getIsAttached()) {
            InlineClassHelperKt.throwIllegalStateException("visitAncestors called on an unattached node");
        }
        Modifier.Node node = delegatableNode.getNode();
        LayoutNode layoutNodeRequireLayoutNode = DelegatableNodeKt.requireLayoutNode(delegatableNode);
        while (layoutNodeRequireLayoutNode != null) {
            if ((layoutNodeRequireLayoutNode.getNodes().getHead().getAggregateChildKindSet() & i) != 0) {
                while (node != null) {
                    if ((node.getKindSet() & i) != 0) {
                        Object obj = (T) node;
                        MutableVector mutableVector = null;
                        while (obj != null) {
                            Intrinsics.reifiedOperationMarker(3, ExifInterface.GPS_DIRECTION_TRUE);
                            if (obj instanceof Object) {
                                return (T) obj;
                            }
                            if ((((Modifier.Node) obj).getKindSet() & i) != 0 && (obj instanceof DelegatingNode)) {
                                int i2 = 0;
                                for (Modifier.Node delegate = obj.getDelegate(); delegate != null; delegate = delegate.getChild()) {
                                    if ((delegate.getKindSet() & i) != 0) {
                                        i2++;
                                        if (i2 == 1) {
                                            obj = (T) delegate;
                                        } else {
                                            if (mutableVector == null) {
                                                mutableVector = new MutableVector(new Modifier.Node[16], 0);
                                            }
                                            if (obj != null) {
                                                if (mutableVector != null) {
                                                    mutableVector.add(obj);
                                                }
                                                obj = (T) null;
                                            }
                                            if (mutableVector != null) {
                                                mutableVector.add(delegate);
                                            }
                                        }
                                    }
                                }
                                if (i2 == 1) {
                                }
                            }
                            obj = (T) DelegatableNodeKt.pop(mutableVector);
                        }
                    }
                    node = node.getParent();
                }
            }
            layoutNodeRequireLayoutNode = layoutNodeRequireLayoutNode.getParent$ui();
            node = (layoutNodeRequireLayoutNode == null || (nodes = layoutNodeRequireLayoutNode.getNodes()) == null) ? null : nodes.getTail();
        }
        return null;
    }

    private final Modifier.Node lastLocalKeyInputNode(DelegatableNode delegatableNode) {
        int iM8585constructorimpl = NodeKind.m8585constructorimpl(1024) | NodeKind.m8585constructorimpl(8192);
        if (!delegatableNode.getNode().getIsAttached()) {
            InlineClassHelperKt.throwIllegalStateException("visitLocalDescendants called on an unattached node");
        }
        Modifier.Node node = delegatableNode.getNode();
        Modifier.Node node2 = null;
        if ((node.getAggregateChildKindSet() & iM8585constructorimpl) != 0) {
            for (Modifier.Node child = node.getChild(); child != null; child = child.getChild()) {
                if ((child.getKindSet() & iM8585constructorimpl) != 0) {
                    if ((NodeKind.m8585constructorimpl(1024) & child.getKindSet()) != 0) {
                        return node2;
                    }
                    node2 = child;
                }
            }
        }
        return node2;
    }
}
