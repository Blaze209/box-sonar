package androidx.constraintlayout.compose;

import android.util.Log;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.constraintlayout.core.parser.CLObject;
import androidx.constraintlayout.core.parser.CLParsingException;
import androidx.constraintlayout.core.state.TransitionParser;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: Transition.kt */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0001\u0018\u0000 \u00132\u00020\u0001:\u0001\u0013B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u000e\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bJ\u000e\u0010\t\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bJ\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rH\u0096\u0002J\b\u0010\u000e\u001a\u00020\u000fH\u0016J\b\u0010\u0010\u001a\u00020\u000fH\u0016J\b\u0010\u0011\u001a\u00020\u0012H\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0014"}, d2 = {"Landroidx/constraintlayout/compose/TransitionImpl;", "Landroidx/constraintlayout/compose/Transition;", "parsedTransition", "Landroidx/constraintlayout/core/parser/CLObject;", "(Landroidx/constraintlayout/core/parser/CLObject;)V", "applyAllTo", "", "transition", "Landroidx/constraintlayout/core/state/Transition;", "applyKeyFramesTo", "equals", "", "other", "", "getEndConstraintSetId", "", "getStartConstraintSetId", "hashCode", "", "Companion", "constraintlayout-compose_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class TransitionImpl implements Transition {
    public static final int $stable = 0;

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final TransitionImpl EMPTY = new TransitionImpl(new CLObject(new char[0]));
    private final CLObject parsedTransition;

    public TransitionImpl(CLObject cLObject) {
        this.parsedTransition = cLObject;
    }

    public final void applyAllTo(androidx.constraintlayout.core.state.Transition transition) {
        try {
            TransitionParser.parse(this.parsedTransition, transition);
        } catch (CLParsingException e) {
            Log.e("CML", "Error parsing JSON " + e);
        }
    }

    public final void applyKeyFramesTo(androidx.constraintlayout.core.state.Transition transition) {
        try {
            TransitionParser.parseKeyFrames(this.parsedTransition, transition);
        } catch (CLParsingException e) {
            Log.e("CML", "Error parsing JSON " + e);
        }
    }

    @Override // androidx.constraintlayout.compose.Transition
    public String getStartConstraintSetId() {
        String stringOrNull = this.parsedTransition.getStringOrNull(TypedValues.TransitionType.S_FROM);
        return stringOrNull == null ? "start" : stringOrNull;
    }

    @Override // androidx.constraintlayout.compose.Transition
    public String getEndConstraintSetId() {
        String stringOrNull = this.parsedTransition.getStringOrNull(TypedValues.TransitionType.S_TO);
        return stringOrNull == null ? "end" : stringOrNull;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!Intrinsics.areEqual(getClass(), other != null ? other.getClass() : null)) {
            return false;
        }
        Intrinsics.checkNotNull(other, "null cannot be cast to non-null type androidx.constraintlayout.compose.TransitionImpl");
        return Intrinsics.areEqual(this.parsedTransition, ((TransitionImpl) other).parsedTransition);
    }

    public int hashCode() {
        return this.parsedTransition.hashCode();
    }

    /* JADX INFO: compiled from: Transition.kt */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0080\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0014\u0010\u0003\u001a\u00020\u0004X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Landroidx/constraintlayout/compose/TransitionImpl$Companion;", "", "()V", "EMPTY", "Landroidx/constraintlayout/compose/TransitionImpl;", "getEMPTY$constraintlayout_compose_release", "()Landroidx/constraintlayout/compose/TransitionImpl;", "constraintlayout-compose_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final TransitionImpl getEMPTY$constraintlayout_compose_release() {
            return TransitionImpl.EMPTY;
        }
    }
}
