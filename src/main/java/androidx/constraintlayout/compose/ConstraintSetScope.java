package androidx.constraintlayout.compose;

import androidx.compose.foundation.layout.LayoutScopeMarker;
import androidx.constraintlayout.core.parser.CLObject;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import sdk.pendo.io.events.TagsIdentifier;

/* JADX INFO: compiled from: ConstraintLayout.kt */
/* JADX INFO: loaded from: classes8.dex */
@LayoutScopeMarker
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001:\u0001\u0012B\u0011\b\u0000\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0004J\u000e\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nJ#\u0010\u000b\u001a\u00060\fR\u00020\u00002\u0012\u0010\r\u001a\n\u0012\u0006\b\u0001\u0012\u00020\n0\u000e\"\u00020\n¢\u0006\u0002\u0010\u000fJ\b\u0010\u0010\u001a\u00020\u0011H\u0002R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0013"}, d2 = {"Landroidx/constraintlayout/compose/ConstraintSetScope;", "Landroidx/constraintlayout/compose/ConstraintLayoutBaseScope;", "extendFrom", "Landroidx/constraintlayout/core/parser/CLObject;", "(Landroidx/constraintlayout/core/parser/CLObject;)V", "generatedCount", "", "createRefFor", "Landroidx/constraintlayout/compose/ConstrainedLayoutReference;", "id", "", "createRefsFor", "Landroidx/constraintlayout/compose/ConstraintSetScope$ConstrainedLayoutReferences;", TagsIdentifier.FIELD_IDS_ARRAY, "", "([Ljava/lang/Object;)Landroidx/constraintlayout/compose/ConstraintSetScope$ConstrainedLayoutReferences;", "nextId", "", "ConstrainedLayoutReferences", "constraintlayout-compose_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class ConstraintSetScope extends ConstraintLayoutBaseScope {
    public static final int $stable = 8;
    private int generatedCount;

    public ConstraintSetScope(CLObject cLObject) {
        super(cLObject);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final String nextId() {
        StringBuilder sb = new StringBuilder("androidx.constraintlayout.id");
        int i = this.generatedCount;
        this.generatedCount = i + 1;
        return sb.append(i).toString();
    }

    public final ConstrainedLayoutReference createRefFor(Object id) {
        return new ConstrainedLayoutReference(id);
    }

    public final ConstrainedLayoutReferences createRefsFor(Object... ids) {
        return new ConstrainedLayoutReferences(Arrays.copyOf(ids, ids.length));
    }

    /* JADX INFO: compiled from: ConstraintLayout.kt */
    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0010\b\u0086\u0004\u0018\u00002\u00020\u0001B\u0015\b\u0000\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00010\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0006\u001a\u00020\u0007H\u0086\u0002J\t\u0010\b\u001a\u00020\u0007H\u0086\u0002J\t\u0010\t\u001a\u00020\u0007H\u0086\u0002J\t\u0010\n\u001a\u00020\u0007H\u0086\u0002J\t\u0010\u000b\u001a\u00020\u0007H\u0086\u0002J\t\u0010\f\u001a\u00020\u0007H\u0086\u0002J\t\u0010\r\u001a\u00020\u0007H\u0086\u0002J\t\u0010\u000e\u001a\u00020\u0007H\u0086\u0002J\t\u0010\u000f\u001a\u00020\u0007H\u0086\u0002J\t\u0010\u0010\u001a\u00020\u0007H\u0086\u0002J\t\u0010\u0011\u001a\u00020\u0007H\u0086\u0002J\t\u0010\u0012\u001a\u00020\u0007H\u0086\u0002J\t\u0010\u0013\u001a\u00020\u0007H\u0086\u0002J\t\u0010\u0014\u001a\u00020\u0007H\u0086\u0002J\t\u0010\u0015\u001a\u00020\u0007H\u0086\u0002J\t\u0010\u0016\u001a\u00020\u0007H\u0086\u0002R\u0016\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00010\u0003X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0005¨\u0006\u0017"}, d2 = {"Landroidx/constraintlayout/compose/ConstraintSetScope$ConstrainedLayoutReferences;", "", TagsIdentifier.FIELD_IDS_ARRAY, "", "(Landroidx/constraintlayout/compose/ConstraintSetScope;[Ljava/lang/Object;)V", "[Ljava/lang/Object;", "component1", "Landroidx/constraintlayout/compose/ConstrainedLayoutReference;", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "constraintlayout-compose_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public final class ConstrainedLayoutReferences {
        private final Object[] ids;

        public ConstrainedLayoutReferences(Object[] objArr) {
            this.ids = objArr;
        }

        public final ConstrainedLayoutReference component1() {
            Object[] objArr = this.ids;
            return new ConstrainedLayoutReference(ArraysKt.getLastIndex(objArr) >= 0 ? objArr[0] : ConstraintSetScope.this.nextId());
        }

        public final ConstrainedLayoutReference component2() {
            ConstraintSetScope constraintSetScope = ConstraintSetScope.this;
            Object[] objArr = this.ids;
            return constraintSetScope.createRefFor(1 <= ArraysKt.getLastIndex(objArr) ? objArr[1] : constraintSetScope.nextId());
        }

        public final ConstrainedLayoutReference component3() {
            ConstraintSetScope constraintSetScope = ConstraintSetScope.this;
            Object[] objArr = this.ids;
            return constraintSetScope.createRefFor(2 <= ArraysKt.getLastIndex(objArr) ? objArr[2] : constraintSetScope.nextId());
        }

        public final ConstrainedLayoutReference component4() {
            ConstraintSetScope constraintSetScope = ConstraintSetScope.this;
            Object[] objArr = this.ids;
            return constraintSetScope.createRefFor(3 <= ArraysKt.getLastIndex(objArr) ? objArr[3] : constraintSetScope.nextId());
        }

        public final ConstrainedLayoutReference component5() {
            ConstraintSetScope constraintSetScope = ConstraintSetScope.this;
            Object[] objArr = this.ids;
            return constraintSetScope.createRefFor(4 <= ArraysKt.getLastIndex(objArr) ? objArr[4] : constraintSetScope.nextId());
        }

        public final ConstrainedLayoutReference component6() {
            ConstraintSetScope constraintSetScope = ConstraintSetScope.this;
            Object[] objArr = this.ids;
            return constraintSetScope.createRefFor(5 <= ArraysKt.getLastIndex(objArr) ? objArr[5] : constraintSetScope.nextId());
        }

        public final ConstrainedLayoutReference component7() {
            ConstraintSetScope constraintSetScope = ConstraintSetScope.this;
            Object[] objArr = this.ids;
            return constraintSetScope.createRefFor(6 <= ArraysKt.getLastIndex(objArr) ? objArr[6] : constraintSetScope.nextId());
        }

        public final ConstrainedLayoutReference component8() {
            ConstraintSetScope constraintSetScope = ConstraintSetScope.this;
            Object[] objArr = this.ids;
            return constraintSetScope.createRefFor(7 <= ArraysKt.getLastIndex(objArr) ? objArr[7] : constraintSetScope.nextId());
        }

        public final ConstrainedLayoutReference component9() {
            ConstraintSetScope constraintSetScope = ConstraintSetScope.this;
            Object[] objArr = this.ids;
            return constraintSetScope.createRefFor(8 <= ArraysKt.getLastIndex(objArr) ? objArr[8] : constraintSetScope.nextId());
        }

        public final ConstrainedLayoutReference component10() {
            ConstraintSetScope constraintSetScope = ConstraintSetScope.this;
            Object[] objArr = this.ids;
            return constraintSetScope.createRefFor(9 <= ArraysKt.getLastIndex(objArr) ? objArr[9] : constraintSetScope.nextId());
        }

        public final ConstrainedLayoutReference component11() {
            ConstraintSetScope constraintSetScope = ConstraintSetScope.this;
            Object[] objArr = this.ids;
            return constraintSetScope.createRefFor(10 <= ArraysKt.getLastIndex(objArr) ? objArr[10] : constraintSetScope.nextId());
        }

        public final ConstrainedLayoutReference component12() {
            ConstraintSetScope constraintSetScope = ConstraintSetScope.this;
            Object[] objArr = this.ids;
            return constraintSetScope.createRefFor(11 <= ArraysKt.getLastIndex(objArr) ? objArr[11] : constraintSetScope.nextId());
        }

        public final ConstrainedLayoutReference component13() {
            ConstraintSetScope constraintSetScope = ConstraintSetScope.this;
            Object[] objArr = this.ids;
            return constraintSetScope.createRefFor(12 <= ArraysKt.getLastIndex(objArr) ? objArr[12] : constraintSetScope.nextId());
        }

        public final ConstrainedLayoutReference component14() {
            ConstraintSetScope constraintSetScope = ConstraintSetScope.this;
            Object[] objArr = this.ids;
            return constraintSetScope.createRefFor(13 <= ArraysKt.getLastIndex(objArr) ? objArr[13] : constraintSetScope.nextId());
        }

        public final ConstrainedLayoutReference component15() {
            ConstraintSetScope constraintSetScope = ConstraintSetScope.this;
            Object[] objArr = this.ids;
            return constraintSetScope.createRefFor(14 <= ArraysKt.getLastIndex(objArr) ? objArr[14] : constraintSetScope.nextId());
        }

        public final ConstrainedLayoutReference component16() {
            ConstraintSetScope constraintSetScope = ConstraintSetScope.this;
            Object[] objArr = this.ids;
            return constraintSetScope.createRefFor(15 <= ArraysKt.getLastIndex(objArr) ? objArr[15] : constraintSetScope.nextId());
        }
    }
}
