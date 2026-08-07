package androidx.compose.material3;

import androidx.compose.animation.core.Animatable;
import androidx.compose.animation.core.AnimatableKt;
import androidx.compose.animation.core.AnimationSpec;
import androidx.compose.animation.core.AnimationVector1D;
import androidx.compose.foundation.interaction.InteractionSource;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.node.ParentDataModifierNode;
import androidx.compose.ui.unit.Density;
import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.Job;

/* JADX INFO: compiled from: ButtonGroup.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\b\u0001\u0018\u00002\u00020\u00012\u00020\u0002B\u001d\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006¢\u0006\u0004\b\b\u0010\tJ\b\u0010\u0017\u001a\u00020\u0018H\u0016J\b\u0010\u0019\u001a\u00020\u0018H\u0016J\r\u0010\u001a\u001a\u00020\u0018H\u0000¢\u0006\u0002\b\u001bJ\u0016\u0010\u001c\u001a\u00020\u001d*\u00020\u001e2\b\u0010\u001f\u001a\u0004\u0018\u00010 H\u0016R\u001a\u0010\u0003\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR \u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u001a\u0010\u0012\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00140\u0013X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0015\u001a\u0004\u0018\u00010\u0016X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006!"}, d2 = {"Landroidx/compose/material3/EnlargeOnPressNode;", "Landroidx/compose/ui/node/ParentDataModifierNode;", "Landroidx/compose/ui/Modifier$Node;", "interactionSource", "Landroidx/compose/foundation/interaction/InteractionSource;", "animationSpec", "Landroidx/compose/animation/core/AnimationSpec;", "", "<init>", "(Landroidx/compose/foundation/interaction/InteractionSource;Landroidx/compose/animation/core/AnimationSpec;)V", "getInteractionSource", "()Landroidx/compose/foundation/interaction/InteractionSource;", "setInteractionSource", "(Landroidx/compose/foundation/interaction/InteractionSource;)V", "getAnimationSpec", "()Landroidx/compose/animation/core/AnimationSpec;", "setAnimationSpec", "(Landroidx/compose/animation/core/AnimationSpec;)V", "pressedAnimatable", "Landroidx/compose/animation/core/Animatable;", "Landroidx/compose/animation/core/AnimationVector1D;", "collectionJob", "Lkotlinx/coroutines/Job;", "onAttach", "", "onDetach", "launchCollectionJob", "launchCollectionJob$material3", "modifyParentData", "Landroidx/compose/material3/ButtonGroupParentData;", "Landroidx/compose/ui/unit/Density;", "parentData", "", "material3"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class EnlargeOnPressNode extends Modifier.Node implements ParentDataModifierNode {
    public static final int $stable = 8;
    private AnimationSpec<Float> animationSpec;
    private Job collectionJob;
    private InteractionSource interactionSource;
    private final Animatable<Float, AnimationVector1D> pressedAnimatable = AnimatableKt.Animatable$default(0.0f, 0.0f, 2, null);

    public EnlargeOnPressNode(InteractionSource interactionSource, AnimationSpec<Float> animationSpec) {
        this.interactionSource = interactionSource;
        this.animationSpec = animationSpec;
    }

    public final InteractionSource getInteractionSource() {
        return this.interactionSource;
    }

    public final void setInteractionSource(InteractionSource interactionSource) {
        this.interactionSource = interactionSource;
    }

    public final AnimationSpec<Float> getAnimationSpec() {
        return this.animationSpec;
    }

    public final void setAnimationSpec(AnimationSpec<Float> animationSpec) {
        this.animationSpec = animationSpec;
    }

    @Override // androidx.compose.ui.Modifier.Node
    public void onAttach() {
        super.onAttach();
        launchCollectionJob$material3();
    }

    @Override // androidx.compose.ui.Modifier.Node
    public void onDetach() {
        super.onDetach();
        this.collectionJob = null;
    }

    public final void launchCollectionJob$material3() {
        Job job = this.collectionJob;
        if (job != null) {
            Job.DefaultImpls.cancel$default(job, (CancellationException) null, 1, (Object) null);
        }
        this.collectionJob = BuildersKt__Builders_commonKt.launch$default(getCoroutineScope(), null, null, new EnlargeOnPressNode$launchCollectionJob$1(this, null), 3, null);
    }

    @Override // androidx.compose.ui.node.ParentDataModifierNode
    public ButtonGroupParentData modifyParentData(Density density, Object obj) {
        ButtonGroupParentData buttonGroupParentData = obj instanceof ButtonGroupParentData ? (ButtonGroupParentData) obj : null;
        return new ButtonGroupParentData(ButtonGroupKt.getWeight(buttonGroupParentData), this.pressedAnimatable, buttonGroupParentData != null ? buttonGroupParentData.getAlignment() : null);
    }
}
