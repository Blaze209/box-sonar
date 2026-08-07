package androidx.constraintlayout.compose;

import androidx.compose.foundation.layout.LayoutScopeMarker;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.constraintlayout.core.parser.CLArray;
import androidx.constraintlayout.core.parser.CLObject;
import com.box.android.observability.DiagnosisParams;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: TransitionScope.kt */
/* JADX INFO: loaded from: classes8.dex */
@LayoutScopeMarker
@Metadata(d1 = {"\u0000n\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0007\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u0001B\u0017\b\u0000\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0002\u0010\u0005J\b\u0010 \u001a\u00020!H\u0002J\b\u0010\"\u001a\u00020!H\u0002J\b\u0010#\u001a\u00020!H\u0002J\u000e\u0010$\u001a\u00020%2\u0006\u0010&\u001a\u00020\u0001J\r\u0010'\u001a\u00020\u0007H\u0000¢\u0006\u0002\b(J8\u0010)\u001a\u00020!2\u0012\u0010*\u001a\n\u0012\u0006\b\u0001\u0012\u00020%0+\"\u00020%2\u0017\u0010,\u001a\u0013\u0012\u0004\u0012\u00020.\u0012\u0004\u0012\u00020!0-¢\u0006\u0002\b/¢\u0006\u0002\u00100J8\u00101\u001a\u00020!2\u0012\u0010*\u001a\n\u0012\u0006\b\u0001\u0012\u00020%0+\"\u00020%2\u0017\u00102\u001a\u0013\u0012\u0004\u0012\u000203\u0012\u0004\u0012\u00020!0-¢\u0006\u0002\b/¢\u0006\u0002\u00100J8\u00104\u001a\u00020!2\u0012\u0010*\u001a\n\u0012\u0006\b\u0001\u0012\u00020%0+\"\u00020%2\u0017\u00105\u001a\u0013\u0012\u0004\u0012\u000206\u0012\u0004\u0012\u00020!0-¢\u0006\u0002\b/¢\u0006\u0002\u00100J\r\u00107\u001a\u00020!H\u0000¢\u0006\u0002\b8R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u001e\u0010\r\u001a\u00020\u000e8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u001a\u0010\u0013\u001a\u00020\u0014X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\u001c\u0010\u0019\u001a\u0004\u0018\u00010\u001aX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001eR\u000e\u0010\u001f\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u00069"}, d2 = {"Landroidx/constraintlayout/compose/TransitionScope;", "", TypedValues.TransitionType.S_FROM, "", TypedValues.TransitionType.S_TO, "(Ljava/lang/String;Ljava/lang/String;)V", "containerObject", "Landroidx/constraintlayout/core/parser/CLObject;", "keyAttributesArray", "Landroidx/constraintlayout/core/parser/CLArray;", "keyCyclesArray", "keyFramesObject", "keyPositionsArray", "maxStaggerDelay", "", "getMaxStaggerDelay", "()F", "setMaxStaggerDelay", "(F)V", "motionArc", "Landroidx/constraintlayout/compose/Arc;", "getMotionArc", "()Landroidx/constraintlayout/compose/Arc;", "setMotionArc", "(Landroidx/constraintlayout/compose/Arc;)V", "onSwipe", "Landroidx/constraintlayout/compose/OnSwipe;", "getOnSwipe", "()Landroidx/constraintlayout/compose/OnSwipe;", "setOnSwipe", "(Landroidx/constraintlayout/compose/OnSwipe;)V", "onSwipeObject", "addKeyAttributesIfMissing", "", "addKeyCyclesIfMissing", "addKeyPositionsIfMissing", "createRefFor", "Landroidx/constraintlayout/compose/ConstrainedLayoutReference;", "id", "getObject", "getObject$constraintlayout_compose_release", "keyAttributes", "targets", "", "keyAttributesContent", "Lkotlin/Function1;", "Landroidx/constraintlayout/compose/KeyAttributesScope;", "Lkotlin/ExtensionFunctionType;", "([Landroidx/constraintlayout/compose/ConstrainedLayoutReference;Lkotlin/jvm/functions/Function1;)V", "keyCycles", "keyCyclesContent", "Landroidx/constraintlayout/compose/KeyCyclesScope;", "keyPositions", "keyPositionsContent", "Landroidx/constraintlayout/compose/KeyPositionsScope;", "reset", "reset$constraintlayout_compose_release", "constraintlayout-compose_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class TransitionScope {
    public static final int $stable = 8;
    private final String from;
    private float maxStaggerDelay;
    private OnSwipe onSwipe;
    private final String to;
    private final CLObject containerObject = new CLObject(new char[0]);
    private final CLObject keyFramesObject = new CLObject(new char[0]);
    private final CLArray keyAttributesArray = new CLArray(new char[0]);
    private final CLArray keyPositionsArray = new CLArray(new char[0]);
    private final CLArray keyCyclesArray = new CLArray(new char[0]);
    private final CLObject onSwipeObject = new CLObject(new char[0]);
    private Arc motionArc = Arc.INSTANCE.getNone();

    public TransitionScope(String str, String str2) {
        this.from = str;
        this.to = str2;
    }

    public final void reset$constraintlayout_compose_release() {
        this.containerObject.clear();
        this.keyFramesObject.clear();
        this.keyAttributesArray.clear();
        this.onSwipeObject.clear();
    }

    private final void addKeyAttributesIfMissing() {
        this.containerObject.put("KeyFrames", this.keyFramesObject);
        this.keyFramesObject.put(TypedValues.AttributesType.NAME, this.keyAttributesArray);
    }

    private final void addKeyPositionsIfMissing() {
        this.containerObject.put("KeyFrames", this.keyFramesObject);
        this.keyFramesObject.put("KeyPositions", this.keyPositionsArray);
    }

    private final void addKeyCyclesIfMissing() {
        this.containerObject.put("KeyFrames", this.keyFramesObject);
        this.keyFramesObject.put("KeyCycles", this.keyCyclesArray);
    }

    public final Arc getMotionArc() {
        return this.motionArc;
    }

    public final void setMotionArc(Arc arc) {
        this.motionArc = arc;
    }

    public final OnSwipe getOnSwipe() {
        return this.onSwipe;
    }

    public final void setOnSwipe(OnSwipe onSwipe) {
        this.onSwipe = onSwipe;
    }

    public final float getMaxStaggerDelay() {
        return this.maxStaggerDelay;
    }

    public final void setMaxStaggerDelay(float f) {
        this.maxStaggerDelay = f;
    }

    public final void keyAttributes(ConstrainedLayoutReference[] targets, Function1<? super KeyAttributesScope, Unit> keyAttributesContent) {
        KeyAttributesScope keyAttributesScope = new KeyAttributesScope((ConstrainedLayoutReference[]) Arrays.copyOf(targets, targets.length));
        keyAttributesContent.invoke(keyAttributesScope);
        addKeyAttributesIfMissing();
        this.keyAttributesArray.add(keyAttributesScope.getKeyFramePropsObject());
    }

    public final void keyPositions(ConstrainedLayoutReference[] targets, Function1<? super KeyPositionsScope, Unit> keyPositionsContent) {
        KeyPositionsScope keyPositionsScope = new KeyPositionsScope((ConstrainedLayoutReference[]) Arrays.copyOf(targets, targets.length));
        keyPositionsContent.invoke(keyPositionsScope);
        addKeyPositionsIfMissing();
        this.keyPositionsArray.add(keyPositionsScope.getKeyFramePropsObject());
    }

    public final void keyCycles(ConstrainedLayoutReference[] targets, Function1<? super KeyCyclesScope, Unit> keyCyclesContent) {
        KeyCyclesScope keyCyclesScope = new KeyCyclesScope((ConstrainedLayoutReference[]) Arrays.copyOf(targets, targets.length));
        keyCyclesContent.invoke(keyCyclesScope);
        addKeyCyclesIfMissing();
        this.keyCyclesArray.add(keyCyclesScope.getKeyFramePropsObject());
    }

    public final ConstrainedLayoutReference createRefFor(Object id) {
        return new ConstrainedLayoutReference(id);
    }

    public final CLObject getObject$constraintlayout_compose_release() {
        Object id;
        Object id2;
        this.containerObject.putString(TypedValues.TransitionType.S_PATH_MOTION_ARC, this.motionArc.getName());
        this.containerObject.putString(TypedValues.TransitionType.S_FROM, this.from);
        this.containerObject.putString(TypedValues.TransitionType.S_TO, this.to);
        this.containerObject.putNumber(TypedValues.TransitionType.S_STAGGERED, this.maxStaggerDelay);
        OnSwipe onSwipe = this.onSwipe;
        if (onSwipe != null) {
            this.containerObject.put("onSwipe", this.onSwipeObject);
            this.onSwipeObject.putString("direction", onSwipe.getDirection().getName());
            this.onSwipeObject.putNumber("scale", onSwipe.getDragScale());
            ConstrainedLayoutReference dragAround = onSwipe.getDragAround();
            if (dragAround != null && (id2 = dragAround.getId()) != null) {
                this.onSwipeObject.putString("around", id2.toString());
            }
            ConstrainedLayoutReference limitBoundsTo = onSwipe.getLimitBoundsTo();
            if (limitBoundsTo != null && (id = limitBoundsTo.getId()) != null) {
                this.onSwipeObject.putString("limitBounds", id.toString());
            }
            this.onSwipeObject.putNumber("threshold", onSwipe.getDragThreshold());
            this.onSwipeObject.putString("anchor", onSwipe.getAnchor().getId().toString());
            this.onSwipeObject.putString("side", onSwipe.getSide().getName());
            this.onSwipeObject.putString("touchUp", onSwipe.getOnTouchUp().getName());
            this.onSwipeObject.putString(DiagnosisParams.DIAGNOSIS_MODE, onSwipe.getMode().getName());
            this.onSwipeObject.putNumber("maxVelocity", onSwipe.getMode().getMaxVelocity());
            this.onSwipeObject.putNumber("maxAccel", onSwipe.getMode().getMaxAcceleration());
            this.onSwipeObject.putNumber("springMass", onSwipe.getMode().getSpringMass());
            this.onSwipeObject.putNumber("springStiffness", onSwipe.getMode().getSpringStiffness());
            this.onSwipeObject.putNumber("springDamping", onSwipe.getMode().getSpringDamping());
            this.onSwipeObject.putNumber("stopThreshold", onSwipe.getMode().getSpringThreshold());
            this.onSwipeObject.putString("springBoundary", onSwipe.getMode().getSpringBoundary().getName());
        }
        return this.containerObject;
    }
}
