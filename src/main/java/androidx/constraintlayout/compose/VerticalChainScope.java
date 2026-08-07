package androidx.constraintlayout.compose;

import androidx.compose.foundation.layout.LayoutScopeMarker;
import androidx.constraintlayout.core.parser.CLObject;
import com.facebook.react.uimanager.ViewProps;
import kotlin.Metadata;

/* JADX INFO: compiled from: ChainConstrainScope.kt */
/* JADX INFO: loaded from: classes8.dex */
@LayoutScopeMarker
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0007\u0018\u00002\u00020\u0001B\u0017\b\u0000\u0012\u0006\u0010\u0002\u001a\u00020\u0001\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0014\u0010\u0002\u001a\u00020\u0001X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\f\u001a\u00020\r¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0010\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\t¨\u0006\u0012"}, d2 = {"Landroidx/constraintlayout/compose/VerticalChainScope;", "", "id", "containerObject", "Landroidx/constraintlayout/core/parser/CLObject;", "(Ljava/lang/Object;Landroidx/constraintlayout/core/parser/CLObject;)V", ViewProps.BOTTOM, "Landroidx/constraintlayout/compose/HorizontalAnchorable;", "getBottom", "()Landroidx/constraintlayout/compose/HorizontalAnchorable;", "getId$constraintlayout_compose_release", "()Ljava/lang/Object;", "parent", "Landroidx/constraintlayout/compose/ConstrainedLayoutReference;", "getParent", "()Landroidx/constraintlayout/compose/ConstrainedLayoutReference;", ViewProps.TOP, "getTop", "constraintlayout-compose_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class VerticalChainScope {
    public static final int $stable = 0;
    private final HorizontalAnchorable bottom;
    private final Object id;
    private final ConstrainedLayoutReference parent = new ConstrainedLayoutReference("parent");
    private final HorizontalAnchorable top;

    public VerticalChainScope(Object obj, CLObject cLObject) {
        this.id = obj;
        this.top = new ChainHorizontalAnchorable(cLObject, 0);
        this.bottom = new ChainHorizontalAnchorable(cLObject, 1);
    }

    /* JADX INFO: renamed from: getId$constraintlayout_compose_release, reason: from getter */
    public final Object getId() {
        return this.id;
    }

    public final ConstrainedLayoutReference getParent() {
        return this.parent;
    }

    public final HorizontalAnchorable getTop() {
        return this.top;
    }

    public final HorizontalAnchorable getBottom() {
        return this.bottom;
    }
}
