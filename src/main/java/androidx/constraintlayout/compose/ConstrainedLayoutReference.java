package androidx.constraintlayout.compose;

import com.facebook.react.uimanager.ViewProps;
import kotlin.Metadata;

/* JADX INFO: compiled from: ConstraintLayoutBaseScope.kt */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u000f\b\u0007\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u001c\u0010\u0005\u001a\u00020\u00068\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0007\u0010\b\u001a\u0004\b\t\u0010\nR\u001c\u0010\u000b\u001a\u00020\u00068\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\f\u0010\b\u001a\u0004\b\r\u0010\nR\u001c\u0010\u000e\u001a\u00020\u000f8\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0010\u0010\b\u001a\u0004\b\u0011\u0010\u0012R\u001c\u0010\u0013\u001a\u00020\u00148\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0015\u0010\b\u001a\u0004\b\u0016\u0010\u0017R\u001c\u0010\u0018\u001a\u00020\u00068\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0019\u0010\b\u001a\u0004\b\u001a\u0010\nR\u0014\u0010\u0002\u001a\u00020\u0003X\u0090\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001cR\u001c\u0010\u001d\u001a\u00020\u00068\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u001e\u0010\b\u001a\u0004\b\u001f\u0010\nR\u001c\u0010 \u001a\u00020\u00148\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b!\u0010\b\u001a\u0004\b\"\u0010\u0017¨\u0006#"}, d2 = {"Landroidx/constraintlayout/compose/ConstrainedLayoutReference;", "Landroidx/constraintlayout/compose/LayoutReference;", "id", "", "(Ljava/lang/Object;)V", "absoluteLeft", "Landroidx/constraintlayout/compose/ConstraintLayoutBaseScope$VerticalAnchor;", "getAbsoluteLeft$annotations", "()V", "getAbsoluteLeft", "()Landroidx/constraintlayout/compose/ConstraintLayoutBaseScope$VerticalAnchor;", "absoluteRight", "getAbsoluteRight$annotations", "getAbsoluteRight", "baseline", "Landroidx/constraintlayout/compose/ConstraintLayoutBaseScope$BaselineAnchor;", "getBaseline$annotations", "getBaseline", "()Landroidx/constraintlayout/compose/ConstraintLayoutBaseScope$BaselineAnchor;", ViewProps.BOTTOM, "Landroidx/constraintlayout/compose/ConstraintLayoutBaseScope$HorizontalAnchor;", "getBottom$annotations", "getBottom", "()Landroidx/constraintlayout/compose/ConstraintLayoutBaseScope$HorizontalAnchor;", "end", "getEnd$annotations", "getEnd", "getId$constraintlayout_compose_release", "()Ljava/lang/Object;", "start", "getStart$annotations", "getStart", ViewProps.TOP, "getTop$annotations", "getTop", "constraintlayout-compose_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class ConstrainedLayoutReference extends LayoutReference {
    public static final int $stable = 0;
    private final ConstraintLayoutBaseScope.VerticalAnchor absoluteLeft;
    private final ConstraintLayoutBaseScope.VerticalAnchor absoluteRight;
    private final ConstraintLayoutBaseScope.BaselineAnchor baseline;
    private final ConstraintLayoutBaseScope.HorizontalAnchor bottom;
    private final ConstraintLayoutBaseScope.VerticalAnchor end;
    private final Object id;
    private final ConstraintLayoutBaseScope.VerticalAnchor start;
    private final ConstraintLayoutBaseScope.HorizontalAnchor top;

    public static /* synthetic */ void getAbsoluteLeft$annotations() {
    }

    public static /* synthetic */ void getAbsoluteRight$annotations() {
    }

    public static /* synthetic */ void getBaseline$annotations() {
    }

    public static /* synthetic */ void getBottom$annotations() {
    }

    public static /* synthetic */ void getEnd$annotations() {
    }

    public static /* synthetic */ void getStart$annotations() {
    }

    public static /* synthetic */ void getTop$annotations() {
    }

    public ConstrainedLayoutReference(Object obj) {
        super(obj);
        this.id = obj;
        ConstrainedLayoutReference constrainedLayoutReference = this;
        this.start = new ConstraintLayoutBaseScope.VerticalAnchor(getId(), -2, constrainedLayoutReference);
        this.absoluteLeft = new ConstraintLayoutBaseScope.VerticalAnchor(getId(), 0, constrainedLayoutReference);
        this.top = new ConstraintLayoutBaseScope.HorizontalAnchor(getId(), 0, constrainedLayoutReference);
        this.end = new ConstraintLayoutBaseScope.VerticalAnchor(getId(), -1, constrainedLayoutReference);
        this.absoluteRight = new ConstraintLayoutBaseScope.VerticalAnchor(getId(), 1, constrainedLayoutReference);
        this.bottom = new ConstraintLayoutBaseScope.HorizontalAnchor(getId(), 1, constrainedLayoutReference);
        this.baseline = new ConstraintLayoutBaseScope.BaselineAnchor(getId(), constrainedLayoutReference);
    }

    @Override // androidx.constraintlayout.compose.LayoutReference
    /* JADX INFO: renamed from: getId$constraintlayout_compose_release, reason: from getter */
    public Object getId() {
        return this.id;
    }

    public final ConstraintLayoutBaseScope.VerticalAnchor getStart() {
        return this.start;
    }

    public final ConstraintLayoutBaseScope.VerticalAnchor getAbsoluteLeft() {
        return this.absoluteLeft;
    }

    public final ConstraintLayoutBaseScope.HorizontalAnchor getTop() {
        return this.top;
    }

    public final ConstraintLayoutBaseScope.VerticalAnchor getEnd() {
        return this.end;
    }

    public final ConstraintLayoutBaseScope.VerticalAnchor getAbsoluteRight() {
        return this.absoluteRight;
    }

    public final ConstraintLayoutBaseScope.HorizontalAnchor getBottom() {
        return this.bottom;
    }

    public final ConstraintLayoutBaseScope.BaselineAnchor getBaseline() {
        return this.baseline;
    }
}
