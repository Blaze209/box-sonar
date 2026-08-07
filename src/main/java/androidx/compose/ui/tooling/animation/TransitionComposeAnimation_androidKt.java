package androidx.compose.ui.tooling.animation;

import androidx.compose.animation.core.Transition;
import java.util.Set;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.Reflection;

/* JADX INFO: compiled from: TransitionComposeAnimation.android.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u001a\u0016\u0010\u0000\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u0001*\u0006\u0012\u0002\b\u00030\u0002H\u0000¨\u0006\u0003"}, d2 = {"parse", "Landroidx/compose/ui/tooling/animation/TransitionComposeAnimation;", "Landroidx/compose/animation/core/Transition;", "ui-tooling"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class TransitionComposeAnimation_androidKt {
    public static final TransitionComposeAnimation<?> parse(Transition<?> transition) {
        Set of;
        Object currentState = transition.getCurrentState();
        if (currentState == null) {
            return null;
        }
        Object[] enumConstants = currentState.getClass().getEnumConstants();
        if (enumConstants == null || (of = ArraysKt.toSet(enumConstants)) == null) {
            of = SetsKt.setOf(currentState);
        }
        String label = transition.getLabel();
        if (label == null) {
            label = Reflection.getOrCreateKotlinClass(currentState.getClass()).getSimpleName();
        }
        return new TransitionComposeAnimation<>(transition, of, label);
    }
}
