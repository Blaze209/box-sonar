package androidx.compose.foundation.gestures;

import androidx.compose.foundation.ComposeFoundationFlags;
import androidx.compose.foundation.interaction.DragInteraction;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.ui.geometry.InlineClassHelperKt;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.input.indirect.IndirectPointerEvent;
import androidx.compose.ui.input.indirect.IndirectPointerInputModifierNode;
import androidx.compose.ui.input.pointer.PointerEvent;
import androidx.compose.ui.input.pointer.PointerEventKt;
import androidx.compose.ui.input.pointer.PointerEventPass;
import androidx.compose.ui.input.pointer.PointerId;
import androidx.compose.ui.input.pointer.PointerInputChange;
import androidx.compose.ui.input.pointer.PointerInputEventHandler;
import androidx.compose.ui.input.pointer.PointerInputScope;
import androidx.compose.ui.input.pointer.PointerType;
import androidx.compose.ui.input.pointer.SuspendingPointerInputFilterKt;
import androidx.compose.ui.input.pointer.SuspendingPointerInputModifierNode;
import androidx.compose.ui.input.pointer.util.VelocityTracker;
import androidx.compose.ui.input.pointer.util.VelocityTrackerKt;
import androidx.compose.ui.layout.LayoutCoordinatesKt;
import androidx.compose.ui.node.CompositionLocalConsumerModifierNode;
import androidx.compose.ui.node.CompositionLocalConsumerModifierNodeKt;
import androidx.compose.ui.node.DelegatableNodeKt;
import androidx.compose.ui.node.DelegatingNode;
import androidx.compose.ui.node.PointerInputModifierNode;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.platform.ViewConfiguration;
import androidx.compose.ui.unit.Velocity;
import androidx.compose.ui.unit.VelocityKt;
import java.util.List;
import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.channels.Channel;
import kotlinx.coroutines.channels.ChannelKt;
import kotlinx.coroutines.channels.ChannelResult;

/* JADX INFO: compiled from: Draggable.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000ì\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u001e\b!\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u0004B7\u0012\u0012\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u0006\u0012\u0006\u0010\t\u001a\u00020\b\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u000b\u0012\b\u0010\f\u001a\u0004\u0018\u00010\r¢\u0006\u0004\b\u000e\u0010\u000fJM\u0010H\u001a\u00020I2=\u0010J\u001a9\b\u0001\u0012\u001f\u0012\u001d\u0012\u0013\u0012\u00110L¢\u0006\f\bM\u0012\b\bN\u0012\u0004\b\b(O\u0012\u0004\u0012\u00020I0\u0006\u0012\n\u0012\b\u0012\u0004\u0012\u00020I0P\u0012\u0006\u0012\u0004\u0018\u00010Q0KH¦@¢\u0006\u0002\u0010RJ\u0017\u0010S\u001a\u00020I2\u0006\u0010T\u001a\u00020AH&¢\u0006\u0004\bU\u0010VJ\u0010\u0010W\u001a\u00020I2\u0006\u0010X\u001a\u00020YH&J\b\u0010Z\u001a\u00020\bH&J\b\u0010[\u001a\u00020?H\u0002J\u000e\u0010\\\u001a\b\u0012\u0004\u0012\u00020\u001e0\u001dH\u0002J\b\u0010]\u001a\u00020DH\u0002J\b\u0010^\u001a\u00020IH\u0002J\b\u0010a\u001a\u00020IH\u0016J'\u0010b\u001a\u00020I2\u0006\u0010c\u001a\u00020d2\u0006\u0010e\u001a\u00020f2\u0006\u0010g\u001a\u00020hH\u0016¢\u0006\u0004\bi\u0010jJ\u0018\u0010k\u001a\u00020I2\u0006\u0010X\u001a\u00020l2\u0006\u0010e\u001a\u00020fH\u0016J\b\u0010m\u001a\u00020IH\u0016J\b\u0010n\u001a\u00020`H\u0002J\b\u0010o\u001a\u00020IH\u0016J\u0016\u0010p\u001a\u00020I2\u0006\u0010X\u001a\u00020qH\u0082@¢\u0006\u0002\u0010rJ\u0016\u0010s\u001a\u00020I2\u0006\u0010X\u001a\u00020YH\u0082@¢\u0006\u0002\u0010tJ\u000e\u0010u\u001a\u00020IH\u0082@¢\u0006\u0002\u0010vJ\u0006\u0010w\u001a\u00020IJH\u0010x\u001a\u00020I2\u0014\b\u0002\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u00062\b\b\u0002\u0010\t\u001a\u00020\b2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\r2\b\b\u0002\u0010y\u001a\u00020\bJ\u0018\u0010z\u001a\u00020I2\u0006\u0010c\u001a\u00020d2\u0006\u0010e\u001a\u00020fH\u0002J\b\u0010{\u001a\u00020IH\u0002J8\u0010|\u001a\u00020I2\u0006\u0010}\u001a\u00020~2\u0007\u0010\u007f\u001a\u00030\u0080\u00012\t\b\u0002\u0010\u0081\u0001\u001a\u00020A2\t\b\u0002\u0010\u0082\u0001\u001a\u00020\bH\u0002¢\u0006\u0006\b\u0083\u0001\u0010\u0084\u0001J\u001a\u0010\u0085\u0001\u001a\u00020I2\u0007\u0010\u007f\u001a\u00030\u0080\u0001H\u0002¢\u0006\u0005\b\u0086\u0001\u0010VJ\t\u0010\u0087\u0001\u001a\u00020IH\u0002J+\u0010\u0088\u0001\u001a\u00020I2\u0006\u0010}\u001a\u00020~2\u0007\u0010\u007f\u001a\u00030\u0080\u00012\u0006\u0010C\u001a\u00020DH\u0002¢\u0006\u0006\b\u0089\u0001\u0010\u008a\u0001J\"\u0010\u008b\u0001\u001a\u00020I2\u0006\u0010c\u001a\u00020d2\u0006\u0010e\u001a\u00020f2\u0007\u0010\u008c\u0001\u001a\u00020)H\u0002J\"\u0010\u008d\u0001\u001a\u00020I2\u0006\u0010c\u001a\u00020d2\u0006\u0010e\u001a\u00020f2\u0007\u0010\u008c\u0001\u001a\u000203H\u0002J\"\u0010\u008e\u0001\u001a\u00020I2\u0006\u0010c\u001a\u00020d2\u0006\u0010e\u001a\u00020f2\u0007\u0010\u008c\u0001\u001a\u000208H\u0002J\"\u0010\u008f\u0001\u001a\u00020I2\u0006\u0010c\u001a\u00020d2\u0006\u0010e\u001a\u00020f2\u0007\u0010\u008c\u0001\u001a\u00020.H\u0002J-\u0010\u0090\u0001\u001a\u00020I2\u0007\u0010\u0091\u0001\u001a\u00020~2\u0007\u0010\u0092\u0001\u001a\u00020~2\u0007\u0010\u0093\u0001\u001a\u00020AH\u0002¢\u0006\u0006\b\u0094\u0001\u0010\u0095\u0001J$\u0010\u0096\u0001\u001a\u00020I2\u0007\u0010\u0097\u0001\u001a\u00020~2\u0007\u0010\u0098\u0001\u001a\u00020AH\u0002¢\u0006\u0006\b\u0099\u0001\u0010\u009a\u0001J\u0012\u0010\u009b\u0001\u001a\u00020I2\u0007\u0010\u0097\u0001\u001a\u00020~H\u0002J\t\u0010\u009c\u0001\u001a\u00020IH\u0002J\u000f\u0010\u009d\u0001\u001a\u00020I2\u0006\u0010X\u001a\u00020\u001eR\u001c\u0010\f\u001a\u0004\u0018\u00010\rX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R6\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u00062\u0012\u0010\u0014\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u0006@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u001e\u0010\t\u001a\u00020\b2\u0006\u0010\u0014\u001a\u00020\b@BX\u0084\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\"\u0010\n\u001a\u0004\u0018\u00010\u000b2\b\u0010\u0014\u001a\u0004\u0018\u00010\u000b@BX\u0084\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001aR\u001a\u0010\u001b\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u001c\u001a\n\u0012\u0004\u0012\u00020\u001e\u0018\u00010\u001dX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001f\u001a\u0004\u0018\u00010 X\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010!\u001a\u00020\bX\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010\u0018\"\u0004\b#\u0010$R\u001a\u0010%\u001a\u00020\bX\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b&\u0010\u0018\"\u0004\b'\u0010$R\u0010\u0010(\u001a\u0004\u0018\u00010)X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010*\u001a\u00020)8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b+\u0010,R\u0010\u0010-\u001a\u0004\u0018\u00010.X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010/\u001a\u00020.8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b0\u00101R\u0010\u00102\u001a\u0004\u0018\u000103X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u00104\u001a\u0002038BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b5\u00106R\u0010\u00107\u001a\u0004\u0018\u000108X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u00109\u001a\u0002088BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b:\u0010;R\u0010\u0010<\u001a\u0004\u0018\u00010=X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010>\u001a\u0004\u0018\u00010?X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010@\u001a\u00020AX\u0082\u000e¢\u0006\u0004\n\u0002\u0010BR\u0010\u0010C\u001a\u0004\u0018\u00010DX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010E\u001a\u0004\u0018\u00010FX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010G\u001a\u00020AX\u0082\u000e¢\u0006\u0004\n\u0002\u0010BR\u0010\u0010_\u001a\u0004\u0018\u00010`X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u009e\u0001"}, d2 = {"Landroidx/compose/foundation/gestures/DragGestureNode;", "Landroidx/compose/ui/node/DelegatingNode;", "Landroidx/compose/ui/node/PointerInputModifierNode;", "Landroidx/compose/ui/input/indirect/IndirectPointerInputModifierNode;", "Landroidx/compose/ui/node/CompositionLocalConsumerModifierNode;", "canDrag", "Lkotlin/Function1;", "Landroidx/compose/ui/input/pointer/PointerType;", "", "enabled", "interactionSource", "Landroidx/compose/foundation/interaction/MutableInteractionSource;", "orientationLock", "Landroidx/compose/foundation/gestures/Orientation;", "<init>", "(Lkotlin/jvm/functions/Function1;ZLandroidx/compose/foundation/interaction/MutableInteractionSource;Landroidx/compose/foundation/gestures/Orientation;)V", "getOrientationLock", "()Landroidx/compose/foundation/gestures/Orientation;", "setOrientationLock", "(Landroidx/compose/foundation/gestures/Orientation;)V", "value", "getCanDrag", "()Lkotlin/jvm/functions/Function1;", "getEnabled", "()Z", "getInteractionSource", "()Landroidx/compose/foundation/interaction/MutableInteractionSource;", "_canDrag", "channel", "Lkotlinx/coroutines/channels/Channel;", "Landroidx/compose/foundation/gestures/DragEvent;", "dragInteraction", "Landroidx/compose/foundation/interaction/DragInteraction$Start;", "isListeningForEvents", "isListeningForEvents$foundation", "setListeningForEvents$foundation", "(Z)V", "isListeningForPointerInputEvents", "isListeningForPointerInputEvents$foundation", "setListeningForPointerInputEvents$foundation", "_awaitDownState", "Landroidx/compose/foundation/gestures/DragDetectionState$AwaitDown;", "awaitDownState", "getAwaitDownState", "()Landroidx/compose/foundation/gestures/DragDetectionState$AwaitDown;", "_draggingState", "Landroidx/compose/foundation/gestures/DragDetectionState$Dragging;", "draggingState", "getDraggingState", "()Landroidx/compose/foundation/gestures/DragDetectionState$Dragging;", "_awaitTouchSlopState", "Landroidx/compose/foundation/gestures/DragDetectionState$AwaitTouchSlop;", "awaitTouchSlopState", "getAwaitTouchSlopState", "()Landroidx/compose/foundation/gestures/DragDetectionState$AwaitTouchSlop;", "_awaitGesturePickupState", "Landroidx/compose/foundation/gestures/DragDetectionState$AwaitGesturePickup;", "awaitGesturePickupState", "getAwaitGesturePickupState", "()Landroidx/compose/foundation/gestures/DragDetectionState$AwaitGesturePickup;", "currentDragState", "Landroidx/compose/foundation/gestures/DragDetectionState;", "velocityTracker", "Landroidx/compose/ui/input/pointer/util/VelocityTracker;", "previousPositionOnScreen", "Landroidx/compose/ui/geometry/Offset;", "J", "touchSlopDetector", "Landroidx/compose/foundation/gestures/TouchSlopDetector;", "indirectPointerInputDragCycleDetector", "Landroidx/compose/foundation/gestures/IndirectPointerInputDragCycleDetector;", "nodeOffset", "drag", "", "forEachDelta", "Lkotlin/Function2;", "Landroidx/compose/foundation/gestures/DragEvent$DragDelta;", "Lkotlin/ParameterName;", "name", "dragDelta", "Lkotlin/coroutines/Continuation;", "", "(Lkotlin/jvm/functions/Function2;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "onDragStarted", "startedPosition", "onDragStarted-k-4lQ0M", "(J)V", "onDragStopped", "event", "Landroidx/compose/foundation/gestures/DragEvent$DragStopped;", "startDragImmediately", "requireVelocityTracker", "requireChannel", "requireTouchSlopDetector", "startListeningForEvents", "pointerInputNode", "Landroidx/compose/ui/input/pointer/SuspendingPointerInputModifierNode;", "onDetach", "onPointerEvent", "pointerEvent", "Landroidx/compose/ui/input/pointer/PointerEvent;", "pass", "Landroidx/compose/ui/input/pointer/PointerEventPass;", "bounds", "Landroidx/compose/ui/unit/IntSize;", "onPointerEvent-H0pRuoY", "(Landroidx/compose/ui/input/pointer/PointerEvent;Landroidx/compose/ui/input/pointer/PointerEventPass;J)V", "onIndirectPointerEvent", "Landroidx/compose/ui/input/indirect/IndirectPointerEvent;", "onCancelIndirectPointerInput", "initializePointerInputNode", "onCancelPointerInput", "processDragStart", "Landroidx/compose/foundation/gestures/DragEvent$DragStarted;", "(Landroidx/compose/foundation/gestures/DragEvent$DragStarted;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "processDragStop", "(Landroidx/compose/foundation/gestures/DragEvent$DragStopped;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "processDragCancel", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "disposeInteractionSource", "update", "shouldResetPointerInputHandling", "processRawPointerEvent", "resetDragDetectionState", "moveToAwaitTouchSlopState", "initialDown", "Landroidx/compose/ui/input/pointer/PointerInputChange;", "pointerId", "Landroidx/compose/ui/input/pointer/PointerId;", "initialTouchSlopPositionChange", "verifyConsumptionInFinalPass", "moveToAwaitTouchSlopState-aWI9W7U", "(Landroidx/compose/ui/input/pointer/PointerInputChange;JJZ)V", "moveToDraggingState", "moveToDraggingState-0FcD4WY", "moveToAwaitDownState", "moveToAwaitGesturePickupState", "moveToAwaitGesturePickupState-rnUCldI", "(Landroidx/compose/ui/input/pointer/PointerInputChange;JLandroidx/compose/foundation/gestures/TouchSlopDetector;)V", "processInitialDownState", "state", "processAwaitTouchSlop", "processAwaitGesturePickup", "processDraggingState", "sendDragStart", "down", "slopTriggerChange", "overSlopOffset", "sendDragStart-0AR0LA0", "(Landroidx/compose/ui/input/pointer/PointerInputChange;Landroidx/compose/ui/input/pointer/PointerInputChange;J)V", "sendDragEvent", "change", "dragAmount", "sendDragEvent-Uv8p0NA", "(Landroidx/compose/ui/input/pointer/PointerInputChange;J)V", "sendDragStopped", "sendDragCancelled", "onDragEvent", "foundation"}, k = 1, mv = {2, 0, 0}, xi = 48)
public abstract class DragGestureNode extends DelegatingNode implements PointerInputModifierNode, IndirectPointerInputModifierNode, CompositionLocalConsumerModifierNode {
    public static final int $stable = 8;
    private DragDetectionState.AwaitDown _awaitDownState;
    private DragDetectionState.AwaitGesturePickup _awaitGesturePickupState;
    private DragDetectionState.AwaitTouchSlop _awaitTouchSlopState;
    private DragDetectionState.Dragging _draggingState;
    private Function1<? super PointerType, Boolean> canDrag;
    private Channel<DragEvent> channel;
    private DragDetectionState currentDragState;
    private DragInteraction.Start dragInteraction;
    private boolean enabled;
    private IndirectPointerInputDragCycleDetector indirectPointerInputDragCycleDetector;
    private MutableInteractionSource interactionSource;
    private boolean isListeningForEvents;
    private boolean isListeningForPointerInputEvents;
    private Orientation orientationLock;
    private SuspendingPointerInputModifierNode pointerInputNode;
    private TouchSlopDetector touchSlopDetector;
    private VelocityTracker velocityTracker;
    private final Function1<PointerType, Boolean> _canDrag = new Function1() { // from class: androidx.compose.foundation.gestures.DragGestureNode$$ExternalSyntheticLambda0
        @Override // kotlin.jvm.functions.Function1
        public final Object invoke(Object obj) {
            return Boolean.valueOf(DragGestureNode._canDrag$lambda$0(this.f$0, (PointerType) obj));
        }
    };
    private long previousPositionOnScreen = Offset.INSTANCE.m6584getUnspecifiedF1C5BW0();
    private long nodeOffset = Offset.INSTANCE.m6585getZeroF1C5BW0();

    /* JADX INFO: compiled from: Draggable.kt */
    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    public static final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[DragDetectionState.AwaitDown.AwaitTouchSlop.values().length];
            try {
                iArr[DragDetectionState.AwaitDown.AwaitTouchSlop.NotInitialized.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    /* JADX INFO: renamed from: androidx.compose.foundation.gestures.DragGestureNode$processDragCancel$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: Draggable.kt */
    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    @DebugMetadata(c = "androidx.compose.foundation.gestures.DragGestureNode", f = "Draggable.kt", i = {}, l = {667}, m = "processDragCancel", n = {}, s = {}, v = 1)
    static final class C06081 extends ContinuationImpl {
        int label;
        /* synthetic */ Object result;

        C06081(Continuation<? super C06081> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return DragGestureNode.this.processDragCancel(this);
        }
    }

    /* JADX INFO: renamed from: androidx.compose.foundation.gestures.DragGestureNode$processDragStart$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: Draggable.kt */
    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    @DebugMetadata(c = "androidx.compose.foundation.gestures.DragGestureNode", f = "Draggable.kt", i = {0, 1, 1}, l = {649, 652}, m = "processDragStart", n = {"event", "event", "interaction"}, s = {"L$0", "L$0", "L$1"}, v = 1)
    static final class C06091 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        int label;
        /* synthetic */ Object result;

        C06091(Continuation<? super C06091> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return DragGestureNode.this.processDragStart(null, this);
        }
    }

    /* JADX INFO: renamed from: androidx.compose.foundation.gestures.DragGestureNode$processDragStop$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: Draggable.kt */
    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    @DebugMetadata(c = "androidx.compose.foundation.gestures.DragGestureNode", f = "Draggable.kt", i = {0}, l = {659}, m = "processDragStop", n = {"event"}, s = {"L$0"}, v = 1)
    static final class C06101 extends ContinuationImpl {
        Object L$0;
        int label;
        /* synthetic */ Object result;

        C06101(Continuation<? super C06101> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return DragGestureNode.this.processDragStop(null, this);
        }
    }

    public abstract Object drag(Function2<? super Function1<? super DragEvent.DragDelta, Unit>, ? super Continuation<? super Unit>, ? extends Object> function2, Continuation<? super Unit> continuation);

    /* JADX INFO: renamed from: onDragStarted-k-4lQ0M */
    public abstract void mo775onDragStartedk4lQ0M(long startedPosition);

    public abstract void onDragStopped(DragEvent.DragStopped event);

    /* JADX INFO: renamed from: startDragImmediately */
    public abstract boolean getStartDragImmediately();

    public DragGestureNode(Function1<? super PointerType, Boolean> function1, boolean z, MutableInteractionSource mutableInteractionSource, Orientation orientation) {
        this.orientationLock = orientation;
        this.canDrag = function1;
        this.enabled = z;
        this.interactionSource = mutableInteractionSource;
    }

    public final Orientation getOrientationLock() {
        return this.orientationLock;
    }

    public final void setOrientationLock(Orientation orientation) {
        this.orientationLock = orientation;
    }

    public final Function1<PointerType, Boolean> getCanDrag() {
        return this.canDrag;
    }

    protected final boolean getEnabled() {
        return this.enabled;
    }

    protected final MutableInteractionSource getInteractionSource() {
        return this.interactionSource;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean _canDrag$lambda$0(DragGestureNode dragGestureNode, PointerType pointerType) {
        return dragGestureNode.canDrag.invoke(pointerType).booleanValue();
    }

    /* JADX INFO: renamed from: isListeningForEvents$foundation, reason: from getter */
    public final boolean getIsListeningForEvents() {
        return this.isListeningForEvents;
    }

    public final void setListeningForEvents$foundation(boolean z) {
        this.isListeningForEvents = z;
    }

    /* JADX INFO: renamed from: isListeningForPointerInputEvents$foundation, reason: from getter */
    public final boolean getIsListeningForPointerInputEvents() {
        return this.isListeningForPointerInputEvents;
    }

    public final void setListeningForPointerInputEvents$foundation(boolean z) {
        this.isListeningForPointerInputEvents = z;
    }

    private final DragDetectionState.AwaitDown getAwaitDownState() {
        DragDetectionState.AwaitDown awaitDown = this._awaitDownState;
        if (awaitDown != null) {
            return awaitDown;
        }
        DragDetectionState.AwaitDown awaitDown2 = new DragDetectionState.AwaitDown(null, false, 3, null);
        this._awaitDownState = awaitDown2;
        return awaitDown2;
    }

    private final DragDetectionState.Dragging getDraggingState() {
        DragDetectionState.Dragging dragging = this._draggingState;
        if (dragging != null) {
            return dragging;
        }
        DragDetectionState.Dragging dragging2 = new DragDetectionState.Dragging(0L, 1, null);
        this._draggingState = dragging2;
        return dragging2;
    }

    private final DragDetectionState.AwaitTouchSlop getAwaitTouchSlopState() {
        DragDetectionState.AwaitTouchSlop awaitTouchSlop = this._awaitTouchSlopState;
        if (awaitTouchSlop != null) {
            return awaitTouchSlop;
        }
        DragDetectionState.AwaitTouchSlop awaitTouchSlop2 = new DragDetectionState.AwaitTouchSlop(null, 0L, false, 7, null);
        this._awaitTouchSlopState = awaitTouchSlop2;
        return awaitTouchSlop2;
    }

    private final DragDetectionState.AwaitGesturePickup getAwaitGesturePickupState() {
        DragDetectionState.AwaitGesturePickup awaitGesturePickup = this._awaitGesturePickupState;
        if (awaitGesturePickup != null) {
            return awaitGesturePickup;
        }
        DragDetectionState.AwaitGesturePickup awaitGesturePickup2 = new DragDetectionState.AwaitGesturePickup(null, 0L, null, 7, null);
        this._awaitGesturePickupState = awaitGesturePickup2;
        return awaitGesturePickup2;
    }

    private final VelocityTracker requireVelocityTracker() {
        VelocityTracker velocityTracker = this.velocityTracker;
        if (velocityTracker != null) {
            return velocityTracker;
        }
        throw new IllegalArgumentException("Velocity Tracker not initialized.".toString());
    }

    private final Channel<DragEvent> requireChannel() {
        Channel<DragEvent> channel = this.channel;
        if (channel != null) {
            return channel;
        }
        throw new IllegalArgumentException("Events channel not initialized.".toString());
    }

    private final TouchSlopDetector requireTouchSlopDetector() {
        TouchSlopDetector touchSlopDetector = this.touchSlopDetector;
        if (touchSlopDetector != null) {
            return touchSlopDetector;
        }
        throw new IllegalArgumentException("Touch slop detector not initialized.".toString());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void startListeningForEvents() {
        this.isListeningForEvents = true;
        if (this.channel == null) {
            this.channel = ChannelKt.Channel$default(Integer.MAX_VALUE, null, null, 6, null);
        }
        BuildersKt__Builders_commonKt.launch$default(getCoroutineScope(), null, null, new C06111(null), 3, null);
    }

    /* JADX INFO: renamed from: androidx.compose.foundation.gestures.DragGestureNode$startListeningForEvents$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: Draggable.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
    @DebugMetadata(c = "androidx.compose.foundation.gestures.DragGestureNode$startListeningForEvents$1", f = "Draggable.kt", i = {0, 0, 1, 1, 2, 2, 3, 4, 5}, l = {499, 501, 503, 510, 512, 515}, m = "invokeSuspend", n = {"$this$launch", "event", "$this$launch", "event", "$this$launch", "event", "$this$launch", "$this$launch", "$this$launch"}, s = {"L$0", "L$1", "L$0", "L$1", "L$0", "L$1", "L$0", "L$0", "L$0"}, v = 1)
    static final class C06111 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        private /* synthetic */ Object L$0;
        Object L$1;
        Object L$2;
        int label;

        C06111(Continuation<? super C06111> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            C06111 c06111 = DragGestureNode.this.new C06111(continuation);
            c06111.L$0 = obj;
            return c06111;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C06111) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Code duplicated, block: B:14:0x0034 A[PHI: r1 r3
          0x0034: PHI (r1v14 kotlin.jvm.internal.Ref$ObjectRef) = (r1v6 kotlin.jvm.internal.Ref$ObjectRef), (r1v20 kotlin.jvm.internal.Ref$ObjectRef) binds: [B:13:0x0031, B:36:0x00c9] A[DONT_GENERATE, DONT_INLINE]
          0x0034: PHI (r3v9 kotlinx.coroutines.CoroutineScope) = (r3v5 kotlinx.coroutines.CoroutineScope), (r3v14 kotlinx.coroutines.CoroutineScope) binds: [B:13:0x0031, B:36:0x00c9] A[DONT_GENERATE, DONT_INLINE]] */
        /* JADX WARN: Code duplicated, block: B:19:0x005f A[PHI: r4
          0x005f: PHI (r4v9 kotlinx.coroutines.CoroutineScope) = 
          (r4v0 kotlinx.coroutines.CoroutineScope)
          (r4v4 kotlinx.coroutines.CoroutineScope)
          (r4v4 kotlinx.coroutines.CoroutineScope)
          (r4v4 kotlinx.coroutines.CoroutineScope)
          (r4v7 kotlinx.coroutines.CoroutineScope)
          (r4v10 kotlinx.coroutines.CoroutineScope)
         binds: [B:18:0x0057, B:44:0x00f3, B:46:0x0105, B:41:0x00ec, B:30:0x0092, B:11:0x0027] A[DONT_GENERATE, DONT_INLINE]] */
        /* JADX WARN: Code duplicated, block: B:21:0x0065  */
        /* JADX WARN: Code duplicated, block: B:23:0x0072  */
        /* JADX WARN: Code duplicated, block: B:26:0x0086  */
        /* JADX WARN: Code duplicated, block: B:31:0x0094  */
        /* JADX WARN: Code duplicated, block: B:34:0x00ae  */
        /* JADX WARN: Code duplicated, block: B:43:0x00ef A[Catch: CancellationException -> 0x0108, TryCatch #1 {CancellationException -> 0x0108, blocks: (B:38:0x00cc, B:40:0x00d2, B:43:0x00ef, B:45:0x00f5), top: B:57:0x00cc }] */
        /* JADX WARN: Code duplicated, block: B:45:0x00f5 A[Catch: CancellationException -> 0x0108, TRY_LEAVE, TryCatch #1 {CancellationException -> 0x0108, blocks: (B:38:0x00cc, B:40:0x00d2, B:43:0x00ef, B:45:0x00f5), top: B:57:0x00cc }] */
        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:30:0x0092 -> B:19:0x005f). Please report as a decompilation issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:41:0x00ec -> B:19:0x005f). Please report as a decompilation issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:44:0x00f3 -> B:19:0x005f). Please report as a decompilation issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:46:0x0105 -> B:19:0x005f). Please report as a decompilation issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:50:0x0119 -> B:11:0x0027). Please report as a decompilation issue!!! */
        /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
            jadx.core.utils.exceptions.JadxOverflowException: Regions stack size limit reached
            	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
            	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
            	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
            */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final java.lang.Object invokeSuspend(java.lang.Object r8) {
            /*
                Method dump skipped, instruction units count: 306
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.gestures.DragGestureNode.C06111.invokeSuspend(java.lang.Object):java.lang.Object");
        }

        /* JADX INFO: renamed from: androidx.compose.foundation.gestures.DragGestureNode$startListeningForEvents$1$1, reason: invalid class name and collision with other inner class name */
        /* JADX INFO: compiled from: Draggable.kt */
        @Metadata(d1 = {"\u0000\u0018\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012!\u0010\u0002\u001a\u001d\u0012\u0013\u0012\u00110\u0004¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0007\u0012\u0004\u0012\u00020\u00010\u0003H\n"}, d2 = {"<anonymous>", "", "processDelta", "Lkotlin/Function1;", "Landroidx/compose/foundation/gestures/DragEvent$DragDelta;", "Lkotlin/ParameterName;", "name", "dragDelta"}, k = 3, mv = {2, 0, 0}, xi = 48)
        @DebugMetadata(c = "androidx.compose.foundation.gestures.DragGestureNode$startListeningForEvents$1$1", f = "Draggable.kt", i = {0}, l = {506}, m = "invokeSuspend", n = {"processDelta"}, s = {"L$0"}, v = 1)
        static final class C00191 extends SuspendLambda implements Function2<Function1<? super DragEvent.DragDelta, ? extends Unit>, Continuation<? super Unit>, Object> {
            final /* synthetic */ Ref.ObjectRef<DragEvent> $event;
            /* synthetic */ Object L$0;
            Object L$1;
            int label;
            final /* synthetic */ DragGestureNode this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            C00191(Ref.ObjectRef<DragEvent> objectRef, DragGestureNode dragGestureNode, Continuation<? super C00191> continuation) {
                super(2, continuation);
                this.$event = objectRef;
                this.this$0 = dragGestureNode;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                C00191 c00191 = new C00191(this.$event, this.this$0, continuation);
                c00191.L$0 = obj;
                return c00191;
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Object invoke(Function1<? super DragEvent.DragDelta, ? extends Unit> function1, Continuation<? super Unit> continuation) {
                return invoke2((Function1<? super DragEvent.DragDelta, Unit>) function1, continuation);
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final Object invoke2(Function1<? super DragEvent.DragDelta, Unit> function1, Continuation<? super Unit> continuation) {
                return ((C00191) create(function1, continuation)).invokeSuspend(Unit.INSTANCE);
            }

            /* JADX WARN: Code duplicated, block: B:11:0x002f  */
            /* JADX WARN: Multi-variable type inference failed */
            /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:20:0x0051 -> B:25:0x0066). Please report as a decompilation issue!!! */
            /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:22:0x0060 -> B:24:0x0063). Please report as a decompilation issue!!! */
            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object obj) {
                Function1 function1;
                T t;
                Ref.ObjectRef<DragEvent> objectRef;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                int i = this.label;
                if (i == 0) {
                    ResultKt.throwOnFailure(obj);
                    function1 = (Function1) this.L$0;
                    if ((this.$event.element instanceof DragEvent.DragStopped) && !(this.$event.element instanceof DragEvent.DragCancelled)) {
                        DragEvent dragEvent = this.$event.element;
                        t = 0;
                        DragEvent.DragDelta dragDelta = dragEvent instanceof DragEvent.DragDelta ? (DragEvent.DragDelta) dragEvent : null;
                        if (dragDelta != null) {
                            function1.invoke(dragDelta);
                        }
                        objectRef = this.$event;
                        Channel channel = this.this$0.channel;
                        if (channel != null) {
                            this.L$0 = function1;
                            this.L$1 = objectRef;
                            this.label = 1;
                            obj = channel.receive(this);
                            if (obj == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                        }
                        objectRef.element = t;
                        if (this.$event.element instanceof DragEvent.DragStopped) {
                        }
                        return Unit.INSTANCE;
                    }
                    return Unit.INSTANCE;
                }
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                objectRef = (Ref.ObjectRef) this.L$1;
                function1 = (Function1) this.L$0;
                ResultKt.throwOnFailure(obj);
                t = (DragEvent) obj;
                objectRef.element = t;
                if (this.$event.element instanceof DragEvent.DragStopped) {
                }
                return Unit.INSTANCE;
            }
        }
    }

    @Override // androidx.compose.ui.Modifier.Node
    public void onDetach() {
        this.isListeningForEvents = false;
        disposeInteractionSource();
        this.nodeOffset = Offset.INSTANCE.m6585getZeroF1C5BW0();
    }

    @Override // androidx.compose.ui.node.PointerInputModifierNode
    /* JADX INFO: renamed from: onPointerEvent-H0pRuoY */
    public void mo556onPointerEventH0pRuoY(PointerEvent pointerEvent, PointerEventPass pass, long bounds) {
        this.isListeningForPointerInputEvents = true;
        if (ComposeFoundationFlags.isNonSuspendingPointerInputInDraggableEnabled) {
            if (this.enabled) {
                if (this.currentDragState == null) {
                    this.currentDragState = getAwaitDownState();
                }
                processRawPointerEvent(pointerEvent, pass);
                return;
            }
            return;
        }
        if (this.enabled && this.pointerInputNode == null) {
            this.pointerInputNode = (SuspendingPointerInputModifierNode) delegate(initializePointerInputNode());
        }
        SuspendingPointerInputModifierNode suspendingPointerInputModifierNode = this.pointerInputNode;
        if (suspendingPointerInputModifierNode != null) {
            suspendingPointerInputModifierNode.mo556onPointerEventH0pRuoY(pointerEvent, pass, bounds);
        }
    }

    @Override // androidx.compose.ui.input.indirect.IndirectPointerInputModifierNode
    public void onIndirectPointerEvent(IndirectPointerEvent event, PointerEventPass pass) {
        if (this.enabled) {
            if (this.indirectPointerInputDragCycleDetector == null) {
                this.indirectPointerInputDragCycleDetector = new IndirectPointerInputDragCycleDetector(this);
            }
            IndirectPointerInputDragCycleDetector indirectPointerInputDragCycleDetector = this.indirectPointerInputDragCycleDetector;
            if (indirectPointerInputDragCycleDetector != null) {
                indirectPointerInputDragCycleDetector.processIndirectPointerInputEvent(event, pass);
            }
        }
    }

    @Override // androidx.compose.ui.input.indirect.IndirectPointerInputModifierNode
    public void onCancelIndirectPointerInput() {
        IndirectPointerInputDragCycleDetector indirectPointerInputDragCycleDetector = this.indirectPointerInputDragCycleDetector;
        if (indirectPointerInputDragCycleDetector != null) {
            indirectPointerInputDragCycleDetector.resetDragDetectionState();
        }
    }

    private final SuspendingPointerInputModifierNode initializePointerInputNode() {
        return SuspendingPointerInputFilterKt.SuspendingPointerInputModifierNode(new AnonymousClass1());
    }

    /* JADX INFO: renamed from: androidx.compose.foundation.gestures.DragGestureNode$initializePointerInputNode$1, reason: invalid class name */
    /* JADX INFO: compiled from: Draggable.kt */
    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    static final class AnonymousClass1 implements PointerInputEventHandler {
        AnonymousClass1() {
        }

        @Override // androidx.compose.ui.input.pointer.PointerInputEventHandler
        public final Object invoke(final PointerInputScope pointerInputScope, Continuation<? super Unit> continuation) {
            final VelocityTracker velocityTracker = new VelocityTracker();
            final Ref.LongRef longRef = new Ref.LongRef();
            longRef.element = LayoutCoordinatesKt.positionOnScreen(DelegatableNodeKt.requireLayoutCoordinates(DragGestureNode.this));
            final DragGestureNode dragGestureNode = DragGestureNode.this;
            Function3 function3 = new Function3() { // from class: androidx.compose.foundation.gestures.DragGestureNode$initializePointerInputNode$1$$ExternalSyntheticLambda0
                @Override // kotlin.jvm.functions.Function3
                public final Object invoke(Object obj, Object obj2, Object obj3) {
                    return DragGestureNode.AnonymousClass1.invoke$lambda$0(dragGestureNode, velocityTracker, (PointerInputChange) obj, (PointerInputChange) obj2, (Offset) obj3);
                }
            };
            final DragGestureNode dragGestureNode2 = DragGestureNode.this;
            Function1 function1 = new Function1() { // from class: androidx.compose.foundation.gestures.DragGestureNode$initializePointerInputNode$1$$ExternalSyntheticLambda1
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    return DragGestureNode.AnonymousClass1.invoke$lambda$1(velocityTracker, pointerInputScope, dragGestureNode2, (PointerInputChange) obj);
                }
            };
            final DragGestureNode dragGestureNode3 = DragGestureNode.this;
            Function0 function0 = new Function0() { // from class: androidx.compose.foundation.gestures.DragGestureNode$initializePointerInputNode$1$$ExternalSyntheticLambda2
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    return DragGestureNode.AnonymousClass1.invoke$lambda$2(dragGestureNode3);
                }
            };
            final DragGestureNode dragGestureNode4 = DragGestureNode.this;
            Function0 function2 = new Function0() { // from class: androidx.compose.foundation.gestures.DragGestureNode$initializePointerInputNode$1$$ExternalSyntheticLambda3
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    return Boolean.valueOf(DragGestureNode.AnonymousClass1.invoke$lambda$3(dragGestureNode4));
                }
            };
            final DragGestureNode dragGestureNode5 = DragGestureNode.this;
            Object objCoroutineScope = CoroutineScopeKt.coroutineScope(new C00181(pointerInputScope, DragGestureNode.this, function3, function1, function0, function2, new Function2() { // from class: androidx.compose.foundation.gestures.DragGestureNode$initializePointerInputNode$1$$ExternalSyntheticLambda4
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return DragGestureNode.AnonymousClass1.invoke$lambda$4(dragGestureNode5, longRef, velocityTracker, (PointerInputChange) obj, (Offset) obj2);
                }
            }, null), continuation);
            return objCoroutineScope == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objCoroutineScope : Unit.INSTANCE;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final Unit invoke$lambda$0(DragGestureNode dragGestureNode, VelocityTracker velocityTracker, PointerInputChange pointerInputChange, PointerInputChange pointerInputChange2, Offset offset) {
            dragGestureNode.nodeOffset = Offset.INSTANCE.m6585getZeroF1C5BW0();
            if (dragGestureNode.getCanDrag().invoke(PointerType.m8202boximpl(pointerInputChange.getType())).booleanValue()) {
                if (!dragGestureNode.getIsListeningForEvents()) {
                    dragGestureNode.startListeningForEvents();
                }
                VelocityTrackerKt.addPointerInputChange(velocityTracker, pointerInputChange);
                long jM6573minusMKHz9U = Offset.m6573minusMKHz9U(pointerInputChange2.getPosition(), offset.m6579unboximpl());
                Channel channel = dragGestureNode.channel;
                if (channel != null) {
                    ChannelResult.m16334boximpl(channel.mo11206trySendJP2dKIU(new DragEvent.DragStarted(jM6573minusMKHz9U, null)));
                }
            }
            return Unit.INSTANCE;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final Unit invoke$lambda$1(VelocityTracker velocityTracker, PointerInputScope pointerInputScope, DragGestureNode dragGestureNode, PointerInputChange pointerInputChange) {
            VelocityTrackerKt.addPointerInputChange(velocityTracker, pointerInputChange);
            float maximumFlingVelocity = pointerInputScope.getViewConfiguration().getMaximumFlingVelocity();
            long jM8240calculateVelocityAH228Gc = velocityTracker.m8240calculateVelocityAH228Gc(VelocityKt.Velocity(maximumFlingVelocity, maximumFlingVelocity));
            velocityTracker.resetTracking();
            Channel channel = dragGestureNode.channel;
            if (channel != null) {
                ChannelResult.m16334boximpl(channel.mo11206trySendJP2dKIU(new DragEvent.DragStopped(DraggableKt.m858toValidVelocityTH1AsA0(jM8240calculateVelocityAH228Gc), false, null)));
            }
            return Unit.INSTANCE;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final Unit invoke$lambda$2(DragGestureNode dragGestureNode) {
            Channel channel = dragGestureNode.channel;
            if (channel != null) {
                ChannelResult.m16334boximpl(channel.mo11206trySendJP2dKIU(DragEvent.DragCancelled.INSTANCE));
            }
            return Unit.INSTANCE;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final boolean invoke$lambda$3(DragGestureNode dragGestureNode) {
            return !dragGestureNode.getStartDragImmediately();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final Unit invoke$lambda$4(DragGestureNode dragGestureNode, Ref.LongRef longRef, VelocityTracker velocityTracker, PointerInputChange pointerInputChange, Offset offset) {
            long jPositionOnScreen = LayoutCoordinatesKt.positionOnScreen(DelegatableNodeKt.requireLayoutCoordinates(dragGestureNode));
            if (!Offset.m6566equalsimpl0(jPositionOnScreen, longRef.element)) {
                dragGestureNode.nodeOffset = Offset.m6574plusMKHz9U(dragGestureNode.nodeOffset, Offset.m6573minusMKHz9U(jPositionOnScreen, longRef.element));
            }
            longRef.element = jPositionOnScreen;
            VelocityTrackerKt.m8241addPointerInputChange0AR0LA0(velocityTracker, pointerInputChange, dragGestureNode.nodeOffset);
            Channel channel = dragGestureNode.channel;
            if (channel != null) {
                ChannelResult.m16334boximpl(channel.mo11206trySendJP2dKIU(new DragEvent.DragDelta(offset.m6579unboximpl(), false, null)));
            }
            return Unit.INSTANCE;
        }

        /* JADX INFO: renamed from: androidx.compose.foundation.gestures.DragGestureNode$initializePointerInputNode$1$1, reason: invalid class name and collision with other inner class name */
        /* JADX INFO: compiled from: Draggable.kt */
        @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
        @DebugMetadata(c = "androidx.compose.foundation.gestures.DragGestureNode$initializePointerInputNode$1$1", f = "Draggable.kt", i = {0}, l = {624}, m = "invokeSuspend", n = {"$this$coroutineScope"}, s = {"L$0"}, v = 1)
        static final class C00181 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
            final /* synthetic */ Function2<PointerInputChange, Offset, Unit> $onDrag;
            final /* synthetic */ Function0<Unit> $onDragCancel;
            final /* synthetic */ Function1<PointerInputChange, Unit> $onDragEnd;
            final /* synthetic */ Function3<PointerInputChange, PointerInputChange, Offset, Unit> $onDragStart;
            final /* synthetic */ Function0<Boolean> $shouldAwaitTouchSlop;
            final /* synthetic */ PointerInputScope $this_SuspendingPointerInputModifierNode;
            private /* synthetic */ Object L$0;
            int label;
            final /* synthetic */ DragGestureNode this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            C00181(PointerInputScope pointerInputScope, DragGestureNode dragGestureNode, Function3<? super PointerInputChange, ? super PointerInputChange, ? super Offset, Unit> function3, Function1<? super PointerInputChange, Unit> function1, Function0<Unit> function0, Function0<Boolean> function2, Function2<? super PointerInputChange, ? super Offset, Unit> function4, Continuation<? super C00181> continuation) {
                super(2, continuation);
                this.$this_SuspendingPointerInputModifierNode = pointerInputScope;
                this.this$0 = dragGestureNode;
                this.$onDragStart = function3;
                this.$onDragEnd = function1;
                this.$onDragCancel = function0;
                this.$shouldAwaitTouchSlop = function2;
                this.$onDrag = function4;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                C00181 c00181 = new C00181(this.$this_SuspendingPointerInputModifierNode, this.this$0, this.$onDragStart, this.$onDragEnd, this.$onDragCancel, this.$shouldAwaitTouchSlop, this.$onDrag, continuation);
                c00181.L$0 = obj;
                return c00181;
            }

            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                return ((C00181) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
            }

            /* JADX WARN: Multi-variable type inference failed */
            /* JADX WARN: Type inference failed for: r11v0, types: [androidx.compose.foundation.gestures.DragGestureNode$initializePointerInputNode$1$1] */
            /* JADX WARN: Type inference failed for: r11v1, types: [androidx.compose.foundation.gestures.DragGestureNode$initializePointerInputNode$1$1] */
            /* JADX WARN: Type inference failed for: r11v10 */
            /* JADX WARN: Type inference failed for: r11v11 */
            /* JADX WARN: Type inference failed for: r11v8 */
            /* JADX WARN: Type inference failed for: r1v0, types: [int] */
            /* JADX WARN: Type inference failed for: r1v1, types: [kotlinx.coroutines.CoroutineScope] */
            /* JADX WARN: Type inference failed for: r1v4 */
            /* JADX WARN: Type inference failed for: r1v7 */
            /* JADX WARN: Type inference failed for: r1v8 */
            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object obj) {
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                ?? r1 = this.label;
                try {
                    if (r1 == 0) {
                        ResultKt.throwOnFailure(obj);
                        CoroutineScope coroutineScope = (CoroutineScope) this.L$0;
                        this.L$0 = coroutineScope;
                        this.label = 1;
                        Object objDetectDragGestures = DragGestureDetectorKt.detectDragGestures(this.$this_SuspendingPointerInputModifierNode, this.this$0.getOrientationLock(), this.$onDragStart, this.$onDragEnd, this.$onDragCancel, this.$shouldAwaitTouchSlop, this.$onDrag, (Continuation) this);
                        r1 = coroutineScope;
                        this = objDetectDragGestures;
                        if (objDetectDragGestures == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                    } else {
                        if (r1 != 1) {
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                        CoroutineScope coroutineScope2 = (CoroutineScope) this.L$0;
                        ResultKt.throwOnFailure(obj);
                        r1 = coroutineScope2;
                        this = this;
                    }
                } catch (CancellationException e) {
                    Channel channel = this.this$0.channel;
                    if (channel != null) {
                        ChannelResult.m16334boximpl(channel.mo11206trySendJP2dKIU(DragEvent.DragCancelled.INSTANCE));
                    }
                    if (!CoroutineScopeKt.isActive(r1)) {
                        throw e;
                    }
                }
                return Unit.INSTANCE;
            }
        }
    }

    @Override // androidx.compose.ui.node.PointerInputModifierNode
    public void onCancelPointerInput() {
        SuspendingPointerInputModifierNode suspendingPointerInputModifierNode = this.pointerInputNode;
        if (suspendingPointerInputModifierNode != null) {
            suspendingPointerInputModifierNode.onCancelPointerInput();
        }
        if (ComposeFoundationFlags.isNonSuspendingPointerInputInDraggableEnabled && this.isListeningForPointerInputEvents) {
            resetDragDetectionState();
        }
        this.isListeningForPointerInputEvents = false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    public final Object processDragStart(DragEvent.DragStarted dragStarted, Continuation<? super Unit> continuation) {
        C06091 c06091;
        MutableInteractionSource mutableInteractionSource;
        DragInteraction.Start start;
        DragEvent.DragStarted dragStarted2;
        DragInteraction.Start start2;
        if (continuation instanceof C06091) {
            c06091 = (C06091) continuation;
            if ((c06091.label & Integer.MIN_VALUE) != 0) {
                c06091.label -= Integer.MIN_VALUE;
            } else {
                c06091 = new C06091(continuation);
            }
        } else {
            c06091 = new C06091(continuation);
        }
        Object obj = c06091.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = c06091.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            DragInteraction.Start start3 = this.dragInteraction;
            if (start3 != null && (mutableInteractionSource = this.interactionSource) != null) {
                DragInteraction.Cancel cancel = new DragInteraction.Cancel(start3);
                c06091.L$0 = dragStarted;
                c06091.label = 1;
                if (mutableInteractionSource.emit(cancel, c06091) != coroutine_suspended) {
                }
                return coroutine_suspended;
            }
            this.dragInteraction = start;
            mo775onDragStartedk4lQ0M(dragStarted.getStartPoint());
            return Unit.INSTANCE;
        }
        if (i == 1) {
            dragStarted = (DragEvent.DragStarted) c06091.L$0;
            ResultKt.throwOnFailure(obj);
        } else {
            if (i != 2) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            start2 = (DragInteraction.Start) c06091.L$1;
            dragStarted2 = (DragEvent.DragStarted) c06091.L$0;
            ResultKt.throwOnFailure(obj);
        }
        start = start2;
        dragStarted = dragStarted2;
        this.dragInteraction = start;
        mo775onDragStartedk4lQ0M(dragStarted.getStartPoint());
        return Unit.INSTANCE;
        start = new DragInteraction.Start();
        MutableInteractionSource mutableInteractionSource2 = this.interactionSource;
        if (mutableInteractionSource2 != null) {
            c06091.L$0 = dragStarted;
            c06091.L$1 = start;
            c06091.label = 2;
            if (mutableInteractionSource2.emit(start, c06091) != coroutine_suspended) {
                dragStarted2 = dragStarted;
                start2 = start;
                start = start2;
                dragStarted = dragStarted2;
            }
            return coroutine_suspended;
        }
        this.dragInteraction = start;
        mo775onDragStartedk4lQ0M(dragStarted.getStartPoint());
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    public final Object processDragStop(DragEvent.DragStopped dragStopped, Continuation<? super Unit> continuation) {
        C06101 c06101;
        if (continuation instanceof C06101) {
            c06101 = (C06101) continuation;
            if ((c06101.label & Integer.MIN_VALUE) != 0) {
                c06101.label -= Integer.MIN_VALUE;
            } else {
                c06101 = new C06101(continuation);
            }
        } else {
            c06101 = new C06101(continuation);
        }
        Object obj = c06101.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = c06101.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            DragInteraction.Start start = this.dragInteraction;
            if (start != null) {
                MutableInteractionSource mutableInteractionSource = this.interactionSource;
                if (mutableInteractionSource != null) {
                    DragInteraction.Stop stop = new DragInteraction.Stop(start);
                    c06101.L$0 = dragStopped;
                    c06101.label = 1;
                    if (mutableInteractionSource.emit(stop, c06101) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                }
            }
            onDragStopped(dragStopped);
            return Unit.INSTANCE;
        }
        if (i != 1) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        dragStopped = (DragEvent.DragStopped) c06101.L$0;
        ResultKt.throwOnFailure(obj);
        this.dragInteraction = null;
        onDragStopped(dragStopped);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    public final Object processDragCancel(Continuation<? super Unit> continuation) {
        C06081 c06081;
        if (continuation instanceof C06081) {
            c06081 = (C06081) continuation;
            if ((c06081.label & Integer.MIN_VALUE) != 0) {
                c06081.label -= Integer.MIN_VALUE;
            } else {
                c06081 = new C06081(continuation);
            }
        } else {
            c06081 = new C06081(continuation);
        }
        Object obj = c06081.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = c06081.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            DragInteraction.Start start = this.dragInteraction;
            if (start != null) {
                MutableInteractionSource mutableInteractionSource = this.interactionSource;
                if (mutableInteractionSource != null) {
                    DragInteraction.Cancel cancel = new DragInteraction.Cancel(start);
                    c06081.label = 1;
                    if (mutableInteractionSource.emit(cancel, c06081) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                }
            }
            onDragStopped(new DragEvent.DragStopped(Velocity.INSTANCE.m9936getZero9UxMQ8M(), false, null));
            return Unit.INSTANCE;
        }
        if (i != 1) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        ResultKt.throwOnFailure(obj);
        this.dragInteraction = null;
        onDragStopped(new DragEvent.DragStopped(Velocity.INSTANCE.m9936getZero9UxMQ8M(), false, null));
        return Unit.INSTANCE;
    }

    public final void disposeInteractionSource() {
        DragInteraction.Start start = this.dragInteraction;
        if (start != null) {
            MutableInteractionSource mutableInteractionSource = this.interactionSource;
            if (mutableInteractionSource != null) {
                mutableInteractionSource.tryEmit(new DragInteraction.Cancel(start));
            }
            this.dragInteraction = null;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void update$default(DragGestureNode dragGestureNode, Function1 function1, boolean z, MutableInteractionSource mutableInteractionSource, Orientation orientation, boolean z2, int i, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: update");
        }
        if ((i & 1) != 0) {
            function1 = dragGestureNode.canDrag;
        }
        if ((i & 2) != 0) {
            z = dragGestureNode.enabled;
        }
        if ((i & 4) != 0) {
            mutableInteractionSource = dragGestureNode.interactionSource;
        }
        if ((i & 8) != 0) {
            orientation = dragGestureNode.orientationLock;
        }
        if ((i & 16) != 0) {
            z2 = false;
        }
        boolean z3 = z2;
        MutableInteractionSource mutableInteractionSource2 = mutableInteractionSource;
        Function1 function2 = function1;
        dragGestureNode.update(function2, z, mutableInteractionSource2, orientation, z3);
    }

    public final void update(Function1<? super PointerType, Boolean> canDrag, boolean enabled, MutableInteractionSource interactionSource, Orientation orientationLock, boolean shouldResetPointerInputHandling) {
        this.canDrag = canDrag;
        boolean z = true;
        if (this.enabled != enabled) {
            this.enabled = enabled;
            if (!enabled) {
                disposeInteractionSource();
                SuspendingPointerInputModifierNode suspendingPointerInputModifierNode = this.pointerInputNode;
                if (suspendingPointerInputModifierNode != null) {
                    undelegate(suspendingPointerInputModifierNode);
                }
                this.pointerInputNode = null;
                this.indirectPointerInputDragCycleDetector = null;
            }
            shouldResetPointerInputHandling = true;
        }
        if (!Intrinsics.areEqual(this.interactionSource, interactionSource)) {
            disposeInteractionSource();
            this.interactionSource = interactionSource;
        }
        if (this.orientationLock != orientationLock) {
            this.orientationLock = orientationLock;
        } else {
            z = shouldResetPointerInputHandling;
        }
        if (z) {
            if (ComposeFoundationFlags.isNonSuspendingPointerInputInDraggableEnabled && this.isListeningForPointerInputEvents) {
                resetDragDetectionState();
            }
            IndirectPointerInputDragCycleDetector indirectPointerInputDragCycleDetector = this.indirectPointerInputDragCycleDetector;
            if (indirectPointerInputDragCycleDetector != null) {
                indirectPointerInputDragCycleDetector.resetDragDetectionState();
            }
            SuspendingPointerInputModifierNode suspendingPointerInputModifierNode2 = this.pointerInputNode;
            if (suspendingPointerInputModifierNode2 != null) {
                suspendingPointerInputModifierNode2.resetPointerInputHandler();
            }
        }
    }

    private final void processRawPointerEvent(PointerEvent pointerEvent, PointerEventPass pass) {
        DragDetectionState dragDetectionState = this.currentDragState;
        if (dragDetectionState == null) {
            throw new IllegalArgumentException("currentDragState should not be null".toString());
        }
        if (dragDetectionState instanceof DragDetectionState.AwaitDown) {
            processInitialDownState(pointerEvent, pass, (DragDetectionState.AwaitDown) dragDetectionState);
            return;
        }
        if (dragDetectionState instanceof DragDetectionState.AwaitTouchSlop) {
            processAwaitTouchSlop(pointerEvent, pass, (DragDetectionState.AwaitTouchSlop) dragDetectionState);
        } else if (dragDetectionState instanceof DragDetectionState.AwaitGesturePickup) {
            processAwaitGesturePickup(pointerEvent, pass, (DragDetectionState.AwaitGesturePickup) dragDetectionState);
        } else {
            if (!(dragDetectionState instanceof DragDetectionState.Dragging)) {
                throw new NoWhenBranchMatchedException();
            }
            processDraggingState(pointerEvent, pass, (DragDetectionState.Dragging) dragDetectionState);
        }
    }

    private final void resetDragDetectionState() {
        moveToAwaitDownState();
        if (this.isListeningForEvents) {
            sendDragCancelled();
        }
        this.velocityTracker = null;
    }

    /* JADX INFO: renamed from: moveToAwaitTouchSlopState-aWI9W7U$default, reason: not valid java name */
    static /* synthetic */ void m846moveToAwaitTouchSlopStateaWI9W7U$default(DragGestureNode dragGestureNode, PointerInputChange pointerInputChange, long j, long j2, boolean z, int i, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: moveToAwaitTouchSlopState-aWI9W7U");
        }
        if ((i & 4) != 0) {
            j2 = Offset.INSTANCE.m6585getZeroF1C5BW0();
        }
        long j3 = j2;
        if ((i & 8) != 0) {
            z = false;
        }
        dragGestureNode.m845moveToAwaitTouchSlopStateaWI9W7U(pointerInputChange, j, j3, z);
    }

    /* JADX INFO: renamed from: moveToAwaitTouchSlopState-aWI9W7U, reason: not valid java name */
    private final void m845moveToAwaitTouchSlopStateaWI9W7U(PointerInputChange initialDown, long pointerId, long initialTouchSlopPositionChange, boolean verifyConsumptionInFinalPass) {
        DragDetectionState.AwaitTouchSlop awaitTouchSlopState = getAwaitTouchSlopState();
        awaitTouchSlopState.setInitialDown(initialDown);
        awaitTouchSlopState.m810setPointerId0FcD4WY(pointerId);
        TouchSlopDetector touchSlopDetector = this.touchSlopDetector;
        if (touchSlopDetector == null) {
            this.touchSlopDetector = new TouchSlopDetector(this.orientationLock, 0L, 2, null);
        } else {
            if (touchSlopDetector != null) {
                touchSlopDetector.setOrientation(this.orientationLock);
            }
            TouchSlopDetector touchSlopDetector2 = this.touchSlopDetector;
            if (touchSlopDetector2 != null) {
                touchSlopDetector2.m982resetk4lQ0M(initialTouchSlopPositionChange);
            }
        }
        awaitTouchSlopState.setVerifyConsumptionInFinalPass(verifyConsumptionInFinalPass);
        this.currentDragState = awaitTouchSlopState;
    }

    /* JADX INFO: renamed from: moveToDraggingState-0FcD4WY, reason: not valid java name */
    private final void m847moveToDraggingState0FcD4WY(long pointerId) {
        DragDetectionState.Dragging draggingState = getDraggingState();
        draggingState.m812setPointerId0FcD4WY(pointerId);
        this.currentDragState = draggingState;
    }

    private final void moveToAwaitDownState() {
        DragDetectionState.AwaitDown awaitDownState = getAwaitDownState();
        awaitDownState.setAwaitTouchSlop(DragDetectionState.AwaitDown.AwaitTouchSlop.NotInitialized);
        awaitDownState.setConsumedOnInitial(false);
        this.currentDragState = awaitDownState;
    }

    /* JADX INFO: renamed from: moveToAwaitGesturePickupState-rnUCldI, reason: not valid java name */
    private final void m844moveToAwaitGesturePickupStaternUCldI(PointerInputChange initialDown, long pointerId, TouchSlopDetector touchSlopDetector) {
        DragDetectionState.AwaitGesturePickup awaitGesturePickupState = getAwaitGesturePickupState();
        awaitGesturePickupState.setInitialDown(initialDown);
        awaitGesturePickupState.m808setPointerId0FcD4WY(pointerId);
        TouchSlopDetector.m978resetk4lQ0M$default(touchSlopDetector, 0L, 1, null);
        awaitGesturePickupState.setTouchSlopDetector(touchSlopDetector);
        this.currentDragState = awaitGesturePickupState;
    }

    private final void processInitialDownState(PointerEvent pointerEvent, PointerEventPass pass, DragDetectionState.AwaitDown state) {
        DragDetectionState.AwaitDown.AwaitTouchSlop awaitTouchSlop;
        if (!pointerEvent.getChanges().isEmpty() && TapGestureDetectorKt.isChangedToDown$default(pointerEvent, false, false, 2, null)) {
            PointerInputChange pointerInputChange = (PointerInputChange) CollectionsKt.first((List) pointerEvent.getChanges());
            if (WhenMappings.$EnumSwitchMapping$0[state.getAwaitTouchSlop().ordinal()] == 1) {
                if (!getStartDragImmediately()) {
                    awaitTouchSlop = DragDetectionState.AwaitDown.AwaitTouchSlop.Yes;
                } else {
                    awaitTouchSlop = DragDetectionState.AwaitDown.AwaitTouchSlop.No;
                }
            } else {
                awaitTouchSlop = state.getAwaitTouchSlop();
            }
            state.setAwaitTouchSlop(awaitTouchSlop);
            if (pass == PointerEventPass.Initial && awaitTouchSlop == DragDetectionState.AwaitDown.AwaitTouchSlop.No) {
                pointerInputChange.consume();
                state.setConsumedOnInitial(true);
            }
            if (pass == PointerEventPass.Main) {
                if (awaitTouchSlop == DragDetectionState.AwaitDown.AwaitTouchSlop.Yes) {
                    m846moveToAwaitTouchSlopStateaWI9W7U$default(this, pointerInputChange, pointerInputChange.getId(), 0L, false, 12, null);
                } else if (state.getConsumedOnInitial()) {
                    m849sendDragStart0AR0LA0(pointerInputChange, pointerInputChange, Offset.INSTANCE.m6585getZeroF1C5BW0());
                    m848sendDragEventUv8p0NA(pointerInputChange, Offset.INSTANCE.m6585getZeroF1C5BW0());
                    m847moveToDraggingState0FcD4WY(pointerInputChange.getId());
                }
            }
        }
    }

    private final void processAwaitTouchSlop(PointerEvent pointerEvent, PointerEventPass pass, DragDetectionState.AwaitTouchSlop state) {
        PointerInputChange pointerInputChange;
        PointerInputChange pointerInputChange2;
        PointerInputChange pointerInputChange3;
        if (pass == PointerEventPass.Initial) {
            return;
        }
        List<PointerInputChange> changes = pointerEvent.getChanges();
        int size = changes.size();
        int i = 0;
        while (true) {
            pointerInputChange = null;
            if (i >= size) {
                pointerInputChange2 = null;
                break;
            }
            pointerInputChange2 = changes.get(i);
            if (PointerId.m8116equalsimpl0(pointerInputChange2.getId(), state.getPointerId())) {
                break;
            } else {
                i++;
            }
        }
        PointerInputChange pointerInputChange4 = pointerInputChange2;
        if (pointerInputChange4 == null) {
            List<PointerInputChange> changes2 = pointerEvent.getChanges();
            int size2 = changes2.size();
            int i2 = 0;
            while (true) {
                if (i2 >= size2) {
                    pointerInputChange3 = null;
                    break;
                }
                pointerInputChange3 = changes2.get(i2);
                if (pointerInputChange3.getPressed()) {
                    break;
                } else {
                    i2++;
                }
            }
            pointerInputChange4 = pointerInputChange3;
            if (pointerInputChange4 == null) {
                moveToAwaitDownState();
                return;
            }
            state.m810setPointerId0FcD4WY(pointerInputChange4.getId());
        }
        if (pass == PointerEventPass.Main) {
            if (!pointerInputChange4.isConsumed()) {
                if (PointerEventKt.changedToUpIgnoreConsumed(pointerInputChange4)) {
                    List<PointerInputChange> changes3 = pointerEvent.getChanges();
                    int size3 = changes3.size();
                    for (int i3 = 0; i3 < size3; i3++) {
                        PointerInputChange pointerInputChange5 = changes3.get(i3);
                        if (pointerInputChange5.getPressed()) {
                            pointerInputChange = pointerInputChange5;
                            break;
                        }
                    }
                    PointerInputChange pointerInputChange6 = pointerInputChange;
                    if (pointerInputChange6 == null) {
                        moveToAwaitDownState();
                    } else {
                        state.m810setPointerId0FcD4WY(pointerInputChange6.getId());
                    }
                } else {
                    long jM979addPositionsakrDWew = requireTouchSlopDetector().m979addPositionsakrDWew(pointerInputChange4.getPosition(), pointerInputChange4.getPreviousPosition(), DragGestureDetectorKt.m840pointerSlopE8SPZFQ((ViewConfiguration) CompositionLocalConsumerModifierNodeKt.currentValueOf(this, CompositionLocalsKt.getLocalViewConfiguration()), pointerInputChange4.getType()));
                    if ((9223372034707292159L & jM979addPositionsakrDWew) != InlineClassHelperKt.UnspecifiedPackedFloats) {
                        pointerInputChange4.consume();
                        PointerInputChange initialDown = state.getInitialDown();
                        Intrinsics.checkNotNull(initialDown);
                        m849sendDragStart0AR0LA0(initialDown, pointerInputChange4, jM979addPositionsakrDWew);
                        m848sendDragEventUv8p0NA(pointerInputChange4, jM979addPositionsakrDWew);
                        m847moveToDraggingState0FcD4WY(pointerInputChange4.getId());
                    } else {
                        state.setVerifyConsumptionInFinalPass(true);
                    }
                }
            } else {
                PointerInputChange initialDown2 = state.getInitialDown();
                if (initialDown2 == null) {
                    throw new IllegalArgumentException("AwaitTouchSlop.initialDown was not initialized".toString());
                }
                long pointerId = state.getPointerId();
                TouchSlopDetector touchSlopDetector = this.touchSlopDetector;
                if (touchSlopDetector != null) {
                    m844moveToAwaitGesturePickupStaternUCldI(initialDown2, pointerId, touchSlopDetector);
                } else {
                    throw new IllegalArgumentException("AwaitTouchSlop.touchSlopDetector was not initialized".toString());
                }
            }
        }
        if (pass == PointerEventPass.Final && state.getVerifyConsumptionInFinalPass()) {
            if (pointerInputChange4.isConsumed()) {
                PointerInputChange initialDown3 = state.getInitialDown();
                if (initialDown3 == null) {
                    throw new IllegalArgumentException("AwaitTouchSlop.initialDown was not initialized".toString());
                }
                long pointerId2 = state.getPointerId();
                TouchSlopDetector touchSlopDetector2 = this.touchSlopDetector;
                if (touchSlopDetector2 != null) {
                    m844moveToAwaitGesturePickupStaternUCldI(initialDown3, pointerId2, touchSlopDetector2);
                    return;
                }
                throw new IllegalArgumentException("AwaitTouchSlop.touchSlopDetector was not initialized".toString());
            }
            state.setVerifyConsumptionInFinalPass(false);
        }
    }

    private final void processAwaitGesturePickup(PointerEvent pointerEvent, PointerEventPass pass, DragDetectionState.AwaitGesturePickup state) {
        boolean z;
        if (pass != PointerEventPass.Final) {
            return;
        }
        List<PointerInputChange> changes = pointerEvent.getChanges();
        int size = changes.size();
        int i = 0;
        while (true) {
            if (i >= size) {
                z = true;
                break;
            } else {
                if (changes.get(i).isConsumed()) {
                    z = false;
                    break;
                }
                i++;
            }
        }
        List<PointerInputChange> changes2 = pointerEvent.getChanges();
        int size2 = changes2.size();
        for (int i2 = 0; i2 < size2; i2++) {
            if (changes2.get(i2).getPressed()) {
                if (pointerEvent.getChanges().isEmpty()) {
                    break;
                }
                if (z) {
                    long position = ((PointerInputChange) CollectionsKt.first((List) pointerEvent.getChanges())).getPosition();
                    PointerInputChange initialDown = state.getInitialDown();
                    Intrinsics.checkNotNull(initialDown);
                    long jM6573minusMKHz9U = Offset.m6573minusMKHz9U(position, initialDown.getPosition());
                    PointerInputChange initialDown2 = state.getInitialDown();
                    if (initialDown2 != null) {
                        m846moveToAwaitTouchSlopStateaWI9W7U$default(this, initialDown2, state.getPointerId(), jM6573minusMKHz9U, false, 8, null);
                        return;
                    }
                    throw new IllegalArgumentException("AwaitGesturePickup.initialDown was not initialized.".toString());
                }
                return;
            }
        }
        moveToAwaitDownState();
    }

    private final void processDraggingState(PointerEvent pointerEvent, PointerEventPass pass, DragDetectionState.Dragging state) {
        PointerInputChange pointerInputChange;
        PointerInputChange pointerInputChange2;
        if (pass != PointerEventPass.Main) {
            return;
        }
        long pointerId = state.getPointerId();
        List<PointerInputChange> changes = pointerEvent.getChanges();
        int size = changes.size();
        int i = 0;
        while (true) {
            pointerInputChange = null;
            if (i >= size) {
                pointerInputChange2 = null;
                break;
            }
            pointerInputChange2 = changes.get(i);
            if (PointerId.m8116equalsimpl0(pointerInputChange2.getId(), pointerId)) {
                break;
            } else {
                i++;
            }
        }
        PointerInputChange pointerInputChange3 = pointerInputChange2;
        if (pointerInputChange3 == null) {
            return;
        }
        if (PointerEventKt.changedToUpIgnoreConsumed(pointerInputChange3)) {
            List<PointerInputChange> changes2 = pointerEvent.getChanges();
            int size2 = changes2.size();
            for (int i2 = 0; i2 < size2; i2++) {
                PointerInputChange pointerInputChange4 = changes2.get(i2);
                if (pointerInputChange4.getPressed()) {
                    pointerInputChange = pointerInputChange4;
                    break;
                }
            }
            PointerInputChange pointerInputChange5 = pointerInputChange;
            if (pointerInputChange5 == null) {
                if (!pointerInputChange3.isConsumed() && PointerEventKt.changedToUpIgnoreConsumed(pointerInputChange3)) {
                    sendDragStopped(pointerInputChange3);
                } else {
                    sendDragCancelled();
                }
                moveToAwaitDownState();
                return;
            }
            state.m812setPointerId0FcD4WY(pointerInputChange5.getId());
            return;
        }
        if (pointerInputChange3.isConsumed()) {
            sendDragCancelled();
        } else {
            if (Offset.m6567getDistanceimpl(PointerEventKt.positionChangeIgnoreConsumed(pointerInputChange3)) == 0.0f) {
                return;
            }
            m848sendDragEventUv8p0NA(pointerInputChange3, PointerEventKt.positionChange(pointerInputChange3));
            pointerInputChange3.consume();
        }
    }

    /* JADX INFO: renamed from: sendDragStart-0AR0LA0, reason: not valid java name */
    private final void m849sendDragStart0AR0LA0(PointerInputChange down, PointerInputChange slopTriggerChange, long overSlopOffset) {
        if (this.velocityTracker == null) {
            this.velocityTracker = new VelocityTracker();
        }
        VelocityTrackerKt.addPointerInputChange(requireVelocityTracker(), down);
        long jM6573minusMKHz9U = Offset.m6573minusMKHz9U(slopTriggerChange.getPosition(), overSlopOffset);
        this.nodeOffset = Offset.INSTANCE.m6585getZeroF1C5BW0();
        if (this.canDrag.invoke(PointerType.m8202boximpl(down.getType())).booleanValue()) {
            if (!this.isListeningForEvents) {
                if (this.channel == null) {
                    this.channel = ChannelKt.Channel$default(Integer.MAX_VALUE, null, null, 6, null);
                }
                startListeningForEvents();
            }
            this.previousPositionOnScreen = LayoutCoordinatesKt.positionOnScreen(DelegatableNodeKt.requireLayoutCoordinates(this));
            requireChannel().mo11206trySendJP2dKIU(new DragEvent.DragStarted(jM6573minusMKHz9U, null));
        }
    }

    /* JADX INFO: renamed from: sendDragEvent-Uv8p0NA, reason: not valid java name */
    private final void m848sendDragEventUv8p0NA(PointerInputChange change, long dragAmount) {
        long jPositionOnScreen = LayoutCoordinatesKt.positionOnScreen(DelegatableNodeKt.requireLayoutCoordinates(getNode()));
        if (!Offset.m6566equalsimpl0(this.previousPositionOnScreen, Offset.INSTANCE.m6584getUnspecifiedF1C5BW0()) && !Offset.m6566equalsimpl0(jPositionOnScreen, this.previousPositionOnScreen)) {
            this.nodeOffset = Offset.m6574plusMKHz9U(this.nodeOffset, Offset.m6573minusMKHz9U(jPositionOnScreen, this.previousPositionOnScreen));
        }
        this.previousPositionOnScreen = jPositionOnScreen;
        VelocityTrackerKt.m8241addPointerInputChange0AR0LA0(requireVelocityTracker(), change, this.nodeOffset);
        requireChannel().mo11206trySendJP2dKIU(new DragEvent.DragDelta(dragAmount, false, null));
    }

    private final void sendDragStopped(PointerInputChange change) {
        VelocityTrackerKt.addPointerInputChange(requireVelocityTracker(), change);
        float maximumFlingVelocity = ((ViewConfiguration) CompositionLocalConsumerModifierNodeKt.currentValueOf(this, CompositionLocalsKt.getLocalViewConfiguration())).getMaximumFlingVelocity();
        long jM8240calculateVelocityAH228Gc = requireVelocityTracker().m8240calculateVelocityAH228Gc(VelocityKt.Velocity(maximumFlingVelocity, maximumFlingVelocity));
        requireVelocityTracker().resetTracking();
        requireChannel().mo11206trySendJP2dKIU(new DragEvent.DragStopped(DraggableKt.m858toValidVelocityTH1AsA0(jM8240calculateVelocityAH228Gc), false, null));
        this.isListeningForPointerInputEvents = false;
    }

    private final void sendDragCancelled() {
        requireChannel().mo11206trySendJP2dKIU(DragEvent.DragCancelled.INSTANCE);
    }

    public final void onDragEvent(DragEvent event) {
        if ((event instanceof DragEvent.DragStarted) && !this.isListeningForEvents) {
            this.isListeningForEvents = true;
            startListeningForEvents();
        }
        requireChannel().mo11206trySendJP2dKIU(event);
    }
}
