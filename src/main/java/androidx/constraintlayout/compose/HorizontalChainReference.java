package androidx.constraintlayout.compose;

import kotlin.Metadata;

/* JADX INFO: compiled from: ConstraintLayoutBaseScope.kt */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000e\b\u0007\u0018\u00002\u00020\u0001B\u000f\b\u0000\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u001c\u0010\u0005\u001a\u00020\u00068\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0007\u0010\b\u001a\u0004\b\t\u0010\nR\u001c\u0010\u000b\u001a\u00020\u00068\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\f\u0010\b\u001a\u0004\b\r\u0010\nR\u001c\u0010\u000e\u001a\u00020\u00068\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u000f\u0010\b\u001a\u0004\b\u0010\u0010\nR\u001c\u0010\u0011\u001a\u00020\u00068\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0012\u0010\b\u001a\u0004\b\u0013\u0010\n¨\u0006\u0014"}, d2 = {"Landroidx/constraintlayout/compose/HorizontalChainReference;", "Landroidx/constraintlayout/compose/LayoutReference;", "id", "", "(Ljava/lang/Object;)V", "absoluteLeft", "Landroidx/constraintlayout/compose/ConstraintLayoutBaseScope$VerticalAnchor;", "getAbsoluteLeft$annotations", "()V", "getAbsoluteLeft", "()Landroidx/constraintlayout/compose/ConstraintLayoutBaseScope$VerticalAnchor;", "absoluteRight", "getAbsoluteRight$annotations", "getAbsoluteRight", "end", "getEnd$annotations", "getEnd", "start", "getStart$annotations", "getStart", "constraintlayout-compose_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class HorizontalChainReference extends LayoutReference {
    public static final int $stable = 0;
    private final ConstraintLayoutBaseScope.VerticalAnchor absoluteLeft;
    private final ConstraintLayoutBaseScope.VerticalAnchor absoluteRight;
    private final ConstraintLayoutBaseScope.VerticalAnchor end;
    private final ConstraintLayoutBaseScope.VerticalAnchor start;

    public static /* synthetic */ void getAbsoluteLeft$annotations() {
    }

    public static /* synthetic */ void getAbsoluteRight$annotations() {
    }

    public static /* synthetic */ void getEnd$annotations() {
    }

    public static /* synthetic */ void getStart$annotations() {
    }

    public HorizontalChainReference(Object obj) {
        super(obj);
        HorizontalChainReference horizontalChainReference = this;
        this.start = new ConstraintLayoutBaseScope.VerticalAnchor(obj, -2, horizontalChainReference);
        this.absoluteLeft = new ConstraintLayoutBaseScope.VerticalAnchor(obj, 0, horizontalChainReference);
        this.end = new ConstraintLayoutBaseScope.VerticalAnchor(obj, -1, horizontalChainReference);
        this.absoluteRight = new ConstraintLayoutBaseScope.VerticalAnchor(obj, 1, horizontalChainReference);
    }

    public final ConstraintLayoutBaseScope.VerticalAnchor getStart() {
        return this.start;
    }

    public final ConstraintLayoutBaseScope.VerticalAnchor getAbsoluteLeft() {
        return this.absoluteLeft;
    }

    public final ConstraintLayoutBaseScope.VerticalAnchor getEnd() {
        return this.end;
    }

    public final ConstraintLayoutBaseScope.VerticalAnchor getAbsoluteRight() {
        return this.absoluteRight;
    }
}
