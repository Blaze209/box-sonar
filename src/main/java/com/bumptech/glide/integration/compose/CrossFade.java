package com.bumptech.glide.integration.compose;

import androidx.compose.animation.core.AnimationSpec;
import androidx.compose.animation.core.AnimationSpecKt;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: Transition.kt */
/* JADX INFO: loaded from: classes13.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0007\u0018\u0000 \u000e2\u00020\u0001:\u0001\u000eB\u0013\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0002\u0010\u0005J\b\u0010\u0006\u001a\u00020\u0007H\u0016J\u0013\u0010\b\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u000bH\u0096\u0002J\b\u0010\f\u001a\u00020\rH\u0016R\u0014\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000f"}, d2 = {"Lcom/bumptech/glide/integration/compose/CrossFade;", "Lcom/bumptech/glide/integration/compose/Transition$Factory;", "animationSpec", "Landroidx/compose/animation/core/AnimationSpec;", "", "(Landroidx/compose/animation/core/AnimationSpec;)V", "build", "Lcom/bumptech/glide/integration/compose/Transition;", "equals", "", "other", "", "hashCode", "", "Companion", "compose_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class CrossFade implements Transition.Factory {
    private final AnimationSpec<Float> animationSpec;

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public static final int $stable = 8;

    public CrossFade(AnimationSpec<Float> animationSpec) {
        Intrinsics.checkNotNullParameter(animationSpec, "animationSpec");
        this.animationSpec = animationSpec;
    }

    @Override // com.bumptech.glide.integration.compose.Transition.Factory
    public Transition build() {
        return new CrossFadeImpl(this.animationSpec);
    }

    /* JADX INFO: compiled from: Transition.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0016¨\u0006\u0005"}, d2 = {"Lcom/bumptech/glide/integration/compose/CrossFade$Companion;", "Lcom/bumptech/glide/integration/compose/Transition$Factory;", "()V", "build", "Lcom/bumptech/glide/integration/compose/Transition;", "compose_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion implements Transition.Factory {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @Override // com.bumptech.glide.integration.compose.Transition.Factory
        public Transition build() {
            return new CrossFadeImpl(AnimationSpecKt.tween$default(250, 0, null, 6, null));
        }
    }

    public boolean equals(Object other) {
        if (other instanceof CrossFade) {
            return Intrinsics.areEqual(this.animationSpec, ((CrossFade) other).animationSpec);
        }
        return false;
    }

    public int hashCode() {
        return this.animationSpec.hashCode();
    }
}
