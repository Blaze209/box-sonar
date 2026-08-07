package androidx.constraintlayout.compose;

import com.facebook.react.uimanager.ViewProps;
import kotlin.Metadata;

/* JADX INFO: compiled from: ConstraintLayoutBaseScope.kt */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\b\u0007\u0018\u00002\u00020\u0001B\u000f\b\u0000\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u001c\u0010\u0005\u001a\u00020\u00068\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0007\u0010\b\u001a\u0004\b\t\u0010\nR\u001c\u0010\u000b\u001a\u00020\u00068\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\f\u0010\b\u001a\u0004\b\r\u0010\n¨\u0006\u000e"}, d2 = {"Landroidx/constraintlayout/compose/VerticalChainReference;", "Landroidx/constraintlayout/compose/LayoutReference;", "id", "", "(Ljava/lang/Object;)V", ViewProps.BOTTOM, "Landroidx/constraintlayout/compose/ConstraintLayoutBaseScope$HorizontalAnchor;", "getBottom$annotations", "()V", "getBottom", "()Landroidx/constraintlayout/compose/ConstraintLayoutBaseScope$HorizontalAnchor;", ViewProps.TOP, "getTop$annotations", "getTop", "constraintlayout-compose_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class VerticalChainReference extends LayoutReference {
    public static final int $stable = 0;
    private final ConstraintLayoutBaseScope.HorizontalAnchor bottom;
    private final ConstraintLayoutBaseScope.HorizontalAnchor top;

    public static /* synthetic */ void getBottom$annotations() {
    }

    public static /* synthetic */ void getTop$annotations() {
    }

    public VerticalChainReference(Object obj) {
        super(obj);
        VerticalChainReference verticalChainReference = this;
        this.top = new ConstraintLayoutBaseScope.HorizontalAnchor(obj, 0, verticalChainReference);
        this.bottom = new ConstraintLayoutBaseScope.HorizontalAnchor(obj, 1, verticalChainReference);
    }

    public final ConstraintLayoutBaseScope.HorizontalAnchor getTop() {
        return this.top;
    }

    public final ConstraintLayoutBaseScope.HorizontalAnchor getBottom() {
        return this.bottom;
    }
}
