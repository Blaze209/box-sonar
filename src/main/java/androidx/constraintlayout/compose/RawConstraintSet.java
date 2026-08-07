package androidx.constraintlayout.compose;

import androidx.compose.ui.layout.Measurable;
import androidx.constraintlayout.core.parser.CLObject;
import androidx.constraintlayout.core.parser.CLParsingException;
import androidx.constraintlayout.core.state.ConstraintSetParser;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: ConstraintSet.kt */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\b\u0001\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u001e\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\r0\fH\u0016J\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011H\u0096\u0002J\b\u0010\u0012\u001a\u00020\u0013H\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0014"}, d2 = {"Landroidx/constraintlayout/compose/RawConstraintSet;", "Landroidx/constraintlayout/compose/ConstraintSet;", "clObject", "Landroidx/constraintlayout/core/parser/CLObject;", "(Landroidx/constraintlayout/core/parser/CLObject;)V", "layoutVariables", "Landroidx/constraintlayout/core/state/ConstraintSetParser$LayoutVariables;", "applyTo", "", "state", "Landroidx/constraintlayout/compose/State;", "measurables", "", "Landroidx/compose/ui/layout/Measurable;", "equals", "", "other", "", "hashCode", "", "constraintlayout-compose_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class RawConstraintSet implements ConstraintSet {
    public static final int $stable = 0;
    private final CLObject clObject;
    private final ConstraintSetParser.LayoutVariables layoutVariables = new ConstraintSetParser.LayoutVariables();

    public RawConstraintSet(CLObject cLObject) {
        this.clObject = cLObject;
    }

    @Override // androidx.constraintlayout.compose.ConstraintSet
    public void applyTo(State state, List<? extends Measurable> measurables) throws CLParsingException {
        ConstraintSetParser.populateState(this.clObject, state, this.layoutVariables);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!Intrinsics.areEqual(getClass(), other != null ? other.getClass() : null)) {
            return false;
        }
        Intrinsics.checkNotNull(other, "null cannot be cast to non-null type androidx.constraintlayout.compose.RawConstraintSet");
        return Intrinsics.areEqual(this.clObject, ((RawConstraintSet) other).clObject);
    }

    public int hashCode() {
        return this.clObject.hashCode();
    }
}
