package androidx.constraintlayout.compose;

import androidx.compose.foundation.layout.LayoutScopeMarker;
import androidx.constraintlayout.core.parser.CLObject;
import kotlin.Metadata;

/* JADX INFO: compiled from: ChainConstrainScope.kt */
/* JADX INFO: loaded from: classes8.dex */
@LayoutScopeMarker
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0007\u0018\u00002\u00020\u0001B\u0017\b\u0000\u0012\u0006\u0010\u0002\u001a\u00020\u0001\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\n\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\tR\u0011\u0010\f\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\tR\u0014\u0010\u0002\u001a\u00020\u0001X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0010\u001a\u00020\u0011¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0011\u0010\u0014\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\t¨\u0006\u0016"}, d2 = {"Landroidx/constraintlayout/compose/HorizontalChainScope;", "", "id", "containerObject", "Landroidx/constraintlayout/core/parser/CLObject;", "(Ljava/lang/Object;Landroidx/constraintlayout/core/parser/CLObject;)V", "absoluteLeft", "Landroidx/constraintlayout/compose/VerticalAnchorable;", "getAbsoluteLeft", "()Landroidx/constraintlayout/compose/VerticalAnchorable;", "absoluteRight", "getAbsoluteRight", "end", "getEnd", "getId$constraintlayout_compose_release", "()Ljava/lang/Object;", "parent", "Landroidx/constraintlayout/compose/ConstrainedLayoutReference;", "getParent", "()Landroidx/constraintlayout/compose/ConstrainedLayoutReference;", "start", "getStart", "constraintlayout-compose_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class HorizontalChainScope {
    public static final int $stable = 0;
    private final VerticalAnchorable absoluteLeft;
    private final VerticalAnchorable absoluteRight;
    private final VerticalAnchorable end;
    private final Object id;
    private final ConstrainedLayoutReference parent = new ConstrainedLayoutReference("parent");
    private final VerticalAnchorable start;

    public HorizontalChainScope(Object obj, CLObject cLObject) {
        this.id = obj;
        this.start = new ChainVerticalAnchorable(cLObject, -2);
        this.absoluteLeft = new ChainVerticalAnchorable(cLObject, 0);
        this.end = new ChainVerticalAnchorable(cLObject, -1);
        this.absoluteRight = new ChainVerticalAnchorable(cLObject, 1);
    }

    /* JADX INFO: renamed from: getId$constraintlayout_compose_release, reason: from getter */
    public final Object getId() {
        return this.id;
    }

    public final ConstrainedLayoutReference getParent() {
        return this.parent;
    }

    public final VerticalAnchorable getStart() {
        return this.start;
    }

    public final VerticalAnchorable getAbsoluteLeft() {
        return this.absoluteLeft;
    }

    public final VerticalAnchorable getEnd() {
        return this.end;
    }

    public final VerticalAnchorable getAbsoluteRight() {
        return this.absoluteRight;
    }
}
