package androidx.constraintlayout.compose;

import androidx.constraintlayout.core.parser.CLObject;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: DslConstraintSet.kt */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0007\n\u0000\b\u0001\u0018\u00002\u00020\u0001B*\u0012\u0017\u0010\u0002\u001a\u0013\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003¢\u0006\u0002\b\u0006\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\u0002\u0010\tJ\u0010\u0010\u0011\u001a\u00020\u00052\u0006\u0010\u0012\u001a\u00020\u0013H\u0016J\u0013\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017H\u0096\u0002J\b\u0010\u0018\u001a\u00020\u0019H\u0016J\u0018\u0010\u001a\u001a\u00020\b2\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u001eH\u0016R\"\u0010\u0002\u001a\u0013\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003¢\u0006\u0002\b\u0006¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0016\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0014\u0010\u000e\u001a\u00020\u0004X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010¨\u0006\u001f"}, d2 = {"Landroidx/constraintlayout/compose/DslConstraintSet;", "Landroidx/constraintlayout/compose/DerivedConstraintSet;", "description", "Lkotlin/Function1;", "Landroidx/constraintlayout/compose/ConstraintSetScope;", "", "Lkotlin/ExtensionFunctionType;", "extendFrom", "Landroidx/constraintlayout/compose/ConstraintSet;", "(Lkotlin/jvm/functions/Function1;Landroidx/constraintlayout/compose/ConstraintSet;)V", "getDescription", "()Lkotlin/jvm/functions/Function1;", "getExtendFrom", "()Landroidx/constraintlayout/compose/ConstraintSet;", "scope", "getScope$constraintlayout_compose_release", "()Landroidx/constraintlayout/compose/ConstraintSetScope;", "applyToState", "state", "Landroidx/constraintlayout/compose/State;", "equals", "", "other", "", "hashCode", "", "override", "name", "", "value", "", "constraintlayout-compose_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class DslConstraintSet implements DerivedConstraintSet {
    public static final int $stable = 0;
    private final Function1<ConstraintSetScope, Unit> description;
    private final ConstraintSet extendFrom;
    private final ConstraintSetScope scope;

    /* JADX WARN: Multi-variable type inference failed */
    public DslConstraintSet(Function1<? super ConstraintSetScope, Unit> function1, ConstraintSet constraintSet) {
        ConstraintSetScope constraintSetScope;
        this.description = function1;
        CLObject containerObject = null;
        DslConstraintSet dslConstraintSet = constraintSet instanceof DslConstraintSet ? (DslConstraintSet) constraintSet : null;
        if (dslConstraintSet != null && (constraintSetScope = dslConstraintSet.scope) != null) {
            containerObject = constraintSetScope.getContainerObject();
        }
        ConstraintSetScope constraintSetScope2 = new ConstraintSetScope(containerObject);
        function1.invoke(constraintSetScope2);
        this.scope = constraintSetScope2;
    }

    public /* synthetic */ DslConstraintSet(Function1 function1, ConstraintSet constraintSet, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(function1, (i & 2) != 0 ? null : constraintSet);
    }

    public final Function1<ConstraintSetScope, Unit> getDescription() {
        return this.description;
    }

    /* JADX INFO: renamed from: getScope$constraintlayout_compose_release, reason: from getter */
    public final ConstraintSetScope getScope() {
        return this.scope;
    }

    @Override // androidx.constraintlayout.compose.DerivedConstraintSet
    public ConstraintSet getExtendFrom() {
        return this.extendFrom;
    }

    @Override // androidx.constraintlayout.compose.DerivedConstraintSet
    public void applyToState(State state) {
        this.scope.applyTo(state);
    }

    @Override // androidx.constraintlayout.compose.ConstraintSet
    public ConstraintSet override(String name, float value) {
        return this;
    }

    public boolean equals(Object other) {
        if (other instanceof DslConstraintSet) {
            return Intrinsics.areEqual(this.scope, ((DslConstraintSet) other).scope);
        }
        return false;
    }

    public int hashCode() {
        return this.scope.hashCode();
    }
}
