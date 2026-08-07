package androidx.compose.material3;

import androidx.compose.animation.core.AnimationSpec;
import androidx.compose.foundation.interaction.InteractionSource;
import androidx.compose.ui.node.ModifierNodeElement;
import androidx.compose.ui.platform.InspectorInfo;
import com.microsoft.identity.common.internal.providers.oauth2.PasskeyWebListener;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: ButtonGroup.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\b\b\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u001d\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006¢\u0006\u0004\b\b\u0010\tJ\b\u0010\u000e\u001a\u00020\u0002H\u0016J\u0010\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0002H\u0016J\f\u0010\u0012\u001a\u00020\u0010*\u00020\u0013H\u0016J\b\u0010\u0014\u001a\u00020\u0015H\u0016J\u0013\u0010\u0016\u001a\u00020\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019H\u0096\u0002R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0017\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\r¨\u0006\u001a"}, d2 = {"Landroidx/compose/material3/EnlargeOnPressElement;", "Landroidx/compose/ui/node/ModifierNodeElement;", "Landroidx/compose/material3/EnlargeOnPressNode;", "interactionSource", "Landroidx/compose/foundation/interaction/InteractionSource;", "animationSpec", "Landroidx/compose/animation/core/AnimationSpec;", "", "<init>", "(Landroidx/compose/foundation/interaction/InteractionSource;Landroidx/compose/animation/core/AnimationSpec;)V", "getInteractionSource", "()Landroidx/compose/foundation/interaction/InteractionSource;", "getAnimationSpec", "()Landroidx/compose/animation/core/AnimationSpec;", PasskeyWebListener.CREATE_UNIQUE_KEY, "update", "", "node", "inspectableProperties", "Landroidx/compose/ui/platform/InspectorInfo;", "hashCode", "", "equals", "", "other", "", "material3"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class EnlargeOnPressElement extends ModifierNodeElement<EnlargeOnPressNode> {
    public static final int $stable = 0;
    private final AnimationSpec<Float> animationSpec;
    private final InteractionSource interactionSource;

    public EnlargeOnPressElement(InteractionSource interactionSource, AnimationSpec<Float> animationSpec) {
        this.interactionSource = interactionSource;
        this.animationSpec = animationSpec;
    }

    public final InteractionSource getInteractionSource() {
        return this.interactionSource;
    }

    public final AnimationSpec<Float> getAnimationSpec() {
        return this.animationSpec;
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    /* JADX INFO: renamed from: create */
    public EnlargeOnPressNode getNode() {
        return new EnlargeOnPressNode(this.interactionSource, this.animationSpec);
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public void update(EnlargeOnPressNode node) {
        if (!Intrinsics.areEqual(node.getInteractionSource(), this.interactionSource)) {
            node.setInteractionSource(this.interactionSource);
            node.launchCollectionJob$material3();
        }
        node.setAnimationSpec(this.animationSpec);
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public void inspectableProperties(InspectorInfo inspectorInfo) {
        inspectorInfo.setName("EnlargeOnPressElement");
        inspectorInfo.getProperties().set("interactionSource", this.interactionSource);
        inspectorInfo.getProperties().set("animationSpec", this.animationSpec);
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public int hashCode() {
        return (this.interactionSource.hashCode() * 31) + this.animationSpec.hashCode();
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        EnlargeOnPressNode enlargeOnPressNode = other instanceof EnlargeOnPressNode ? (EnlargeOnPressNode) other : null;
        return enlargeOnPressNode != null && Intrinsics.areEqual(this.interactionSource, enlargeOnPressNode.getInteractionSource()) && Intrinsics.areEqual(this.animationSpec, enlargeOnPressNode.getAnimationSpec());
    }
}
