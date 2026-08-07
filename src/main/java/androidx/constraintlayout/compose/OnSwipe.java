package androidx.constraintlayout.compose;

import com.box.android.observability.DiagnosisParams;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: TransitionScope.kt */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0011\b\u0007\u0018\u00002\u00020\u0001B]\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\t\u0012\b\b\u0002\u0010\n\u001a\u00020\t\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\r\u001a\u00020\u000e\u0012\b\b\u0002\u0010\u000f\u001a\u00020\u0010¢\u0006\u0002\u0010\u0011R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0013\u0010\u000b\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0013R\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u0011\u0010\n\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0018R\u0013\u0010\f\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0013R\u0011\u0010\u000f\u001a\u00020\u0010¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001cR\u0011\u0010\r\u001a\u00020\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001eR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010 ¨\u0006!"}, d2 = {"Landroidx/constraintlayout/compose/OnSwipe;", "", "anchor", "Landroidx/constraintlayout/compose/ConstrainedLayoutReference;", "side", "Landroidx/constraintlayout/compose/SwipeSide;", "direction", "Landroidx/constraintlayout/compose/SwipeDirection;", "dragScale", "", "dragThreshold", "dragAround", "limitBoundsTo", "onTouchUp", "Landroidx/constraintlayout/compose/SwipeTouchUp;", DiagnosisParams.DIAGNOSIS_MODE, "Landroidx/constraintlayout/compose/SwipeMode;", "(Landroidx/constraintlayout/compose/ConstrainedLayoutReference;Landroidx/constraintlayout/compose/SwipeSide;Landroidx/constraintlayout/compose/SwipeDirection;FFLandroidx/constraintlayout/compose/ConstrainedLayoutReference;Landroidx/constraintlayout/compose/ConstrainedLayoutReference;Landroidx/constraintlayout/compose/SwipeTouchUp;Landroidx/constraintlayout/compose/SwipeMode;)V", "getAnchor", "()Landroidx/constraintlayout/compose/ConstrainedLayoutReference;", "getDirection", "()Landroidx/constraintlayout/compose/SwipeDirection;", "getDragAround", "getDragScale", "()F", "getDragThreshold", "getLimitBoundsTo", "getMode", "()Landroidx/constraintlayout/compose/SwipeMode;", "getOnTouchUp", "()Landroidx/constraintlayout/compose/SwipeTouchUp;", "getSide", "()Landroidx/constraintlayout/compose/SwipeSide;", "constraintlayout-compose_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class OnSwipe {
    public static final int $stable = 0;
    private final ConstrainedLayoutReference anchor;
    private final SwipeDirection direction;
    private final ConstrainedLayoutReference dragAround;
    private final float dragScale;
    private final float dragThreshold;
    private final ConstrainedLayoutReference limitBoundsTo;
    private final SwipeMode mode;
    private final SwipeTouchUp onTouchUp;
    private final SwipeSide side;

    public OnSwipe(ConstrainedLayoutReference constrainedLayoutReference, SwipeSide swipeSide, SwipeDirection swipeDirection, float f, float f2, ConstrainedLayoutReference constrainedLayoutReference2, ConstrainedLayoutReference constrainedLayoutReference3, SwipeTouchUp swipeTouchUp, SwipeMode swipeMode) {
        this.anchor = constrainedLayoutReference;
        this.side = swipeSide;
        this.direction = swipeDirection;
        this.dragScale = f;
        this.dragThreshold = f2;
        this.dragAround = constrainedLayoutReference2;
        this.limitBoundsTo = constrainedLayoutReference3;
        this.onTouchUp = swipeTouchUp;
        this.mode = swipeMode;
    }

    public final ConstrainedLayoutReference getAnchor() {
        return this.anchor;
    }

    public final SwipeSide getSide() {
        return this.side;
    }

    public final SwipeDirection getDirection() {
        return this.direction;
    }

    public final float getDragScale() {
        return this.dragScale;
    }

    public final float getDragThreshold() {
        return this.dragThreshold;
    }

    public final ConstrainedLayoutReference getDragAround() {
        return this.dragAround;
    }

    public final ConstrainedLayoutReference getLimitBoundsTo() {
        return this.limitBoundsTo;
    }

    public /* synthetic */ OnSwipe(ConstrainedLayoutReference constrainedLayoutReference, SwipeSide swipeSide, SwipeDirection swipeDirection, float f, float f2, ConstrainedLayoutReference constrainedLayoutReference2, ConstrainedLayoutReference constrainedLayoutReference3, SwipeTouchUp swipeTouchUp, SwipeMode swipeMode, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(constrainedLayoutReference, swipeSide, swipeDirection, (i & 8) != 0 ? 1.0f : f, (i & 16) != 0 ? 10.0f : f2, (i & 32) != 0 ? null : constrainedLayoutReference2, (i & 64) != 0 ? null : constrainedLayoutReference3, (i & 128) != 0 ? SwipeTouchUp.INSTANCE.getAutoComplete() : swipeTouchUp, (i & 256) != 0 ? SwipeMode.Companion.velocity$default(SwipeMode.INSTANCE, 0.0f, 0.0f, 3, null) : swipeMode);
    }

    public final SwipeTouchUp getOnTouchUp() {
        return this.onTouchUp;
    }

    public final SwipeMode getMode() {
        return this.mode;
    }
}
