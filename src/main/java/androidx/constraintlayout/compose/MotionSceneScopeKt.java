package androidx.constraintlayout.compose;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: MotionSceneScope.kt */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(d1 = {"\u0000 \n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\u001a!\u0010\u0002\u001a\u00020\u00032\u0017\u0010\u0004\u001a\u0013\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0005¢\u0006\u0002\b\bH\u0007\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000¨\u0006\t"}, d2 = {"UNDEFINED_NAME_PREFIX", "", TypedValues.MotionScene.NAME, "Landroidx/constraintlayout/compose/MotionScene;", "motionSceneContent", "Lkotlin/Function1;", "Landroidx/constraintlayout/compose/MotionSceneScope;", "", "Lkotlin/ExtensionFunctionType;", "constraintlayout-compose_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class MotionSceneScopeKt {
    private static final String UNDEFINED_NAME_PREFIX = "androidx.constraintlayout";

    public static final MotionScene MotionScene(Function1<? super MotionSceneScope, Unit> function1) {
        MotionSceneScope motionSceneScope = new MotionSceneScope();
        function1.invoke(motionSceneScope);
        return new MotionSceneDslImpl(motionSceneScope.getConstraintSetsByName$constraintlayout_compose_release(), motionSceneScope.getTransitionsByName$constraintlayout_compose_release());
    }
}
