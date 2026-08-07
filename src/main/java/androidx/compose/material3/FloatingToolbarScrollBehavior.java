package androidx.compose.material3;

import androidx.compose.animation.core.AnimationSpec;
import androidx.compose.animation.core.DecayAnimationSpec;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.input.nestedscroll.NestedScrollConnection;
import kotlin.Metadata;

/* JADX INFO: compiled from: FloatingToolbar.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bw\u0018\u00002\u00020\u0001J\f\u0010\u0013\u001a\u00020\u0014*\u00020\u0014H&R\u0012\u0010\u0002\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005R\u0012\u0010\u0006\u001a\u00020\u0007X¦\u0004¢\u0006\u0006\u001a\u0004\b\b\u0010\tR\u0018\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000bX¦\u0004¢\u0006\u0006\u001a\u0004\b\r\u0010\u000eR\u0018\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\f0\u0010X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0011\u0010\u0012\u0082\u0001\u0001\u0015ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\u0016À\u0006\u0001"}, d2 = {"Landroidx/compose/material3/FloatingToolbarScrollBehavior;", "Landroidx/compose/ui/input/nestedscroll/NestedScrollConnection;", "exitDirection", "Landroidx/compose/material3/FloatingToolbarExitDirection;", "getExitDirection-8LIK8-E", "()I", "state", "Landroidx/compose/material3/FloatingToolbarState;", "getState", "()Landroidx/compose/material3/FloatingToolbarState;", "snapAnimationSpec", "Landroidx/compose/animation/core/AnimationSpec;", "", "getSnapAnimationSpec", "()Landroidx/compose/animation/core/AnimationSpec;", "flingAnimationSpec", "Landroidx/compose/animation/core/DecayAnimationSpec;", "getFlingAnimationSpec", "()Landroidx/compose/animation/core/DecayAnimationSpec;", "floatingScrollBehavior", "Landroidx/compose/ui/Modifier;", "Landroidx/compose/material3/ExitAlwaysFloatingToolbarScrollBehavior;", "material3"}, k = 1, mv = {2, 0, 0}, xi = 48)
public interface FloatingToolbarScrollBehavior extends NestedScrollConnection {
    Modifier floatingScrollBehavior(Modifier modifier);

    /* JADX INFO: renamed from: getExitDirection-8LIK8-E */
    int mo3314getExitDirection8LIK8E();

    DecayAnimationSpec<Float> getFlingAnimationSpec();

    AnimationSpec<Float> getSnapAnimationSpec();

    FloatingToolbarState getState();
}
