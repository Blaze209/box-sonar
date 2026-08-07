package androidx.constraintlayout.compose;

import androidx.compose.ui.layout.Measurable;
import java.util.List;
import kotlin.Metadata;

/* JADX INFO: compiled from: ConstraintSet.kt */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\ba\u0018\u00002\u00020\u0001J\u001e\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\nH\u0016J\u0010\u0010\f\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH&R\u0014\u0010\u0002\u001a\u0004\u0018\u00010\u0001X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0003\u0010\u0004ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\rÀ\u0006\u0003"}, d2 = {"Landroidx/constraintlayout/compose/DerivedConstraintSet;", "Landroidx/constraintlayout/compose/ConstraintSet;", "extendFrom", "getExtendFrom", "()Landroidx/constraintlayout/compose/ConstraintSet;", "applyTo", "", "state", "Landroidx/constraintlayout/compose/State;", "measurables", "", "Landroidx/compose/ui/layout/Measurable;", "applyToState", "constraintlayout-compose_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public interface DerivedConstraintSet extends ConstraintSet {
    void applyToState(State state);

    ConstraintSet getExtendFrom();

    /* JADX INFO: compiled from: ConstraintSet.kt */
    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    public static final class DefaultImpls {
        @Deprecated
        public static void applyTo(DerivedConstraintSet derivedConstraintSet, androidx.constraintlayout.core.state.Transition transition, int i) {
            DerivedConstraintSet.super.applyTo(transition, i);
        }

        @Deprecated
        public static boolean isDirty(DerivedConstraintSet derivedConstraintSet, List<? extends Measurable> list) {
            return DerivedConstraintSet.super.isDirty(list);
        }

        @Deprecated
        public static ConstraintSet override(DerivedConstraintSet derivedConstraintSet, String str, float f) {
            return DerivedConstraintSet.super.override(str, f);
        }

        @Deprecated
        public static void applyTo(DerivedConstraintSet derivedConstraintSet, State state, List<? extends Measurable> list) {
            DerivedConstraintSet.super.applyTo(state, list);
        }
    }

    @Override // androidx.constraintlayout.compose.ConstraintSet
    default void applyTo(State state, List<? extends Measurable> measurables) {
        ConstraintSet extendFrom = getExtendFrom();
        if (extendFrom != null) {
            extendFrom.applyTo(state, measurables);
        }
        applyToState(state);
    }
}
