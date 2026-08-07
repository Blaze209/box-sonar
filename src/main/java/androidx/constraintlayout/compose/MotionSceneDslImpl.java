package androidx.constraintlayout.compose;

import com.google.firebase.analytics.FirebaseAnalytics;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: MotionSceneScope.kt */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010\u0002\n\u0002\b\u0006\b\u0001\u0018\u00002\u00020\u0001B-\u0012\u0012\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003\u0012\u0012\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00070\u0003¢\u0006\u0002\u0010\bJ\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fH\u0096\u0002J\u0010\u0010\r\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\u000fH\u0016J\u0012\u0010\r\u001a\u00020\u00042\b\u0010\u0010\u001a\u0004\u0018\u00010\u0004H\u0016J\u0012\u0010\u0011\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0012\u001a\u00020\u0004H\u0016J\u0012\u0010\u0013\u001a\u00020\u00042\b\u0010\u0014\u001a\u0004\u0018\u00010\u0004H\u0016J\u0012\u0010\u0015\u001a\u0004\u0018\u00010\u00072\u0006\u0010\u0012\u001a\u00020\u0004H\u0016J\b\u0010\u0016\u001a\u00020\u000fH\u0016J\u001c\u0010\u0017\u001a\u00020\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u00042\b\u0010\u001a\u001a\u0004\u0018\u00010\u0004H\u0016J\u0012\u0010\u001b\u001a\u00020\u00182\b\u0010\u0012\u001a\u0004\u0018\u00010\u0004H\u0016J\u001c\u0010\u001c\u001a\u00020\u00182\b\u0010\u001d\u001a\u0004\u0018\u00010\u00042\b\u0010\u001a\u001a\u0004\u0018\u00010\u0004H\u0016R\u001a\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00070\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001e"}, d2 = {"Landroidx/constraintlayout/compose/MotionSceneDslImpl;", "Landroidx/constraintlayout/compose/MotionScene;", "constraintSetsByName", "", "", "Landroidx/constraintlayout/compose/ConstraintSet;", "transitionsByName", "Landroidx/constraintlayout/compose/Transition;", "(Ljava/util/Map;Ljava/util/Map;)V", "equals", "", "other", "", "getConstraintSet", FirebaseAnalytics.Param.INDEX, "", "ext", "getConstraintSetInstance", "name", "getTransition", "str", "getTransitionInstance", "hashCode", "setConstraintSetContent", "", "csName", "toJSON", "setDebugName", "setTransitionContent", "elementName", "constraintlayout-compose_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class MotionSceneDslImpl implements MotionScene {
    public static final int $stable = 0;
    private final Map<String, ConstraintSet> constraintSetsByName;
    private final Map<String, Transition> transitionsByName;

    @Override // androidx.constraintlayout.core.state.CoreMotionScene
    public void setConstraintSetContent(String csName, String toJSON) {
    }

    @Override // androidx.constraintlayout.core.state.CoreMotionScene
    public void setDebugName(String name) {
    }

    @Override // androidx.constraintlayout.core.state.CoreMotionScene
    public void setTransitionContent(String elementName, String toJSON) {
    }

    /* JADX WARN: Multi-variable type inference failed */
    public MotionSceneDslImpl(Map<String, ? extends ConstraintSet> map, Map<String, ? extends Transition> map2) {
        this.constraintSetsByName = map;
        this.transitionsByName = map2;
    }

    @Override // androidx.constraintlayout.core.state.CoreMotionScene
    public String getConstraintSet(String ext) {
        return "";
    }

    @Override // androidx.constraintlayout.core.state.CoreMotionScene
    public String getTransition(String str) {
        return "";
    }

    @Override // androidx.constraintlayout.core.state.CoreMotionScene
    public String getConstraintSet(int index) {
        return "";
    }

    @Override // androidx.constraintlayout.compose.MotionScene
    public ConstraintSet getConstraintSetInstance(String name) {
        return this.constraintSetsByName.get(name);
    }

    @Override // androidx.constraintlayout.compose.MotionScene
    public Transition getTransitionInstance(String name) {
        return this.transitionsByName.get(name);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!Intrinsics.areEqual(getClass(), other != null ? other.getClass() : null)) {
            return false;
        }
        Intrinsics.checkNotNull(other, "null cannot be cast to non-null type androidx.constraintlayout.compose.MotionSceneDslImpl");
        MotionSceneDslImpl motionSceneDslImpl = (MotionSceneDslImpl) other;
        return Intrinsics.areEqual(this.constraintSetsByName, motionSceneDslImpl.constraintSetsByName) && Intrinsics.areEqual(this.transitionsByName, motionSceneDslImpl.transitionsByName);
    }

    public int hashCode() {
        return (this.constraintSetsByName.hashCode() * 31) + this.transitionsByName.hashCode();
    }
}
