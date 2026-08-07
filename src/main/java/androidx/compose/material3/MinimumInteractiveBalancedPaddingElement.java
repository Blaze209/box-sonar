package androidx.compose.material3;

import androidx.compose.animation.core.AnimationSpec;
import androidx.compose.ui.node.ModifierNodeElement;
import androidx.compose.ui.platform.InspectorInfo;
import com.box.android.domain.analytics.BoxAmplitudeAnalytics;
import com.microsoft.identity.common.internal.providers.oauth2.PasskeyWebListener;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: FloatingToolbar.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\b\t\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0082\b\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B%\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007¢\u0006\u0004\b\t\u0010\nJ\b\u0010\u0010\u001a\u00020\u0002H\u0016J\u0010\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0002H\u0016J\f\u0010\u0014\u001a\u00020\u0012*\u00020\u0015H\u0016J\t\u0010\u0016\u001a\u00020\u0004HÆ\u0003J\t\u0010\u0017\u001a\u00020\u0004HÆ\u0003J\u000f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\b0\u0007HÆ\u0003J-\u0010\u0019\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00042\b\b\u0002\u0010\u0005\u001a\u00020\u00042\u000e\b\u0002\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007HÆ\u0001J\u0013\u0010\u001a\u001a\u00020\u00042\b\u0010\u001b\u001a\u0004\u0018\u00010\u001cHÖ\u0003J\t\u0010\u001d\u001a\u00020\u001eHÖ\u0001J\t\u0010\u001f\u001a\u00020 HÖ\u0001R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0005\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\fR\u0017\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000f¨\u0006!"}, d2 = {"Landroidx/compose/material3/MinimumInteractiveBalancedPaddingElement;", "Landroidx/compose/ui/node/ModifierNodeElement;", "Landroidx/compose/material3/MinimumInteractiveBalancedPaddingNode;", "hasVisibleLeadingContent", "", "hasVisibleTrailingContent", "animationSpec", "Landroidx/compose/animation/core/AnimationSpec;", "", "<init>", "(ZZLandroidx/compose/animation/core/AnimationSpec;)V", "getHasVisibleLeadingContent", "()Z", "getHasVisibleTrailingContent", "getAnimationSpec", "()Landroidx/compose/animation/core/AnimationSpec;", PasskeyWebListener.CREATE_UNIQUE_KEY, "update", "", "node", "inspectableProperties", "Landroidx/compose/ui/platform/InspectorInfo;", "component1", "component2", "component3", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "other", "", "hashCode", "", "toString", "", "material3"}, k = 1, mv = {2, 0, 0}, xi = 48)
final /* data */ class MinimumInteractiveBalancedPaddingElement extends ModifierNodeElement<MinimumInteractiveBalancedPaddingNode> {
    private final AnimationSpec<Float> animationSpec;
    private final boolean hasVisibleLeadingContent;
    private final boolean hasVisibleTrailingContent;

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ MinimumInteractiveBalancedPaddingElement copy$default(MinimumInteractiveBalancedPaddingElement minimumInteractiveBalancedPaddingElement, boolean z, boolean z2, AnimationSpec animationSpec, int i, Object obj) {
        if ((i & 1) != 0) {
            z = minimumInteractiveBalancedPaddingElement.hasVisibleLeadingContent;
        }
        if ((i & 2) != 0) {
            z2 = minimumInteractiveBalancedPaddingElement.hasVisibleTrailingContent;
        }
        if ((i & 4) != 0) {
            animationSpec = minimumInteractiveBalancedPaddingElement.animationSpec;
        }
        return minimumInteractiveBalancedPaddingElement.copy(z, z2, animationSpec);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final boolean getHasVisibleLeadingContent() {
        return this.hasVisibleLeadingContent;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final boolean getHasVisibleTrailingContent() {
        return this.hasVisibleTrailingContent;
    }

    public final AnimationSpec<Float> component3() {
        return this.animationSpec;
    }

    public final MinimumInteractiveBalancedPaddingElement copy(boolean hasVisibleLeadingContent, boolean hasVisibleTrailingContent, AnimationSpec<Float> animationSpec) {
        return new MinimumInteractiveBalancedPaddingElement(hasVisibleLeadingContent, hasVisibleTrailingContent, animationSpec);
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof MinimumInteractiveBalancedPaddingElement)) {
            return false;
        }
        MinimumInteractiveBalancedPaddingElement minimumInteractiveBalancedPaddingElement = (MinimumInteractiveBalancedPaddingElement) other;
        return this.hasVisibleLeadingContent == minimumInteractiveBalancedPaddingElement.hasVisibleLeadingContent && this.hasVisibleTrailingContent == minimumInteractiveBalancedPaddingElement.hasVisibleTrailingContent && Intrinsics.areEqual(this.animationSpec, minimumInteractiveBalancedPaddingElement.animationSpec);
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public int hashCode() {
        return (((Boolean.hashCode(this.hasVisibleLeadingContent) * 31) + Boolean.hashCode(this.hasVisibleTrailingContent)) * 31) + this.animationSpec.hashCode();
    }

    public String toString() {
        return "MinimumInteractiveBalancedPaddingElement(hasVisibleLeadingContent=" + this.hasVisibleLeadingContent + ", hasVisibleTrailingContent=" + this.hasVisibleTrailingContent + ", animationSpec=" + this.animationSpec + ')';
    }

    public MinimumInteractiveBalancedPaddingElement(boolean z, boolean z2, AnimationSpec<Float> animationSpec) {
        this.hasVisibleLeadingContent = z;
        this.hasVisibleTrailingContent = z2;
        this.animationSpec = animationSpec;
    }

    public final boolean getHasVisibleLeadingContent() {
        return this.hasVisibleLeadingContent;
    }

    public final boolean getHasVisibleTrailingContent() {
        return this.hasVisibleTrailingContent;
    }

    public final AnimationSpec<Float> getAnimationSpec() {
        return this.animationSpec;
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    /* JADX INFO: renamed from: create */
    public MinimumInteractiveBalancedPaddingNode getNode() {
        return new MinimumInteractiveBalancedPaddingNode(this.hasVisibleLeadingContent, this.hasVisibleTrailingContent, this.animationSpec);
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public void update(MinimumInteractiveBalancedPaddingNode node) {
        node.setHasVisibleLeadingContent(this.hasVisibleLeadingContent);
        node.setHasVisibleTrailingContent(this.hasVisibleTrailingContent);
        node.setAnimationSpec(this.animationSpec);
        node.updateAnimation();
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public void inspectableProperties(InspectorInfo inspectorInfo) {
        inspectorInfo.setName("minimumInteractiveBalancedPadding");
        inspectorInfo.getProperties().set("hasVisibleLeadingContent", Boolean.valueOf(this.hasVisibleLeadingContent));
        inspectorInfo.getProperties().set("hasVisibleTrailingContent", Boolean.valueOf(this.hasVisibleTrailingContent));
        inspectorInfo.getProperties().set("animationSpec", this.animationSpec);
    }
}
