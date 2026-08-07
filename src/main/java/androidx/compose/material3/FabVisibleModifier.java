package androidx.compose.material3;

import androidx.compose.animation.core.AnimationSpec;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.node.ModifierNodeElement;
import androidx.compose.ui.platform.InspectorInfo;
import com.box.android.domain.analytics.BoxAmplitudeAnalytics;
import com.facebook.react.uimanager.ViewProps;
import com.microsoft.identity.common.internal.providers.oauth2.PasskeyWebListener;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: FloatingActionButton.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0081\b\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001BC\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0010\b\u0002\u0010\t\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\n\u0012\u0010\b\u0002\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\n¢\u0006\u0004\b\f\u0010\rJ\b\u0010\u000e\u001a\u00020\u0002H\u0016J\u0010\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0002H\u0016J\f\u0010\u0012\u001a\u00020\u0010*\u00020\u0013H\u0016J\t\u0010\u0014\u001a\u00020\u0004HÂ\u0003J\t\u0010\u0015\u001a\u00020\u0006HÂ\u0003J\t\u0010\u0016\u001a\u00020\bHÂ\u0003J\u0011\u0010\u0017\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\nHÂ\u0003J\u0011\u0010\u0018\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\nHÂ\u0003JK\u0010\u0019\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00042\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\b2\u0010\b\u0002\u0010\t\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\n2\u0010\b\u0002\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\nHÆ\u0001J\u0013\u0010\u001a\u001a\u00020\u00042\b\u0010\u001b\u001a\u0004\u0018\u00010\u001cHÖ\u0003J\t\u0010\u001d\u001a\u00020\u001eHÖ\u0001J\t\u0010\u001f\u001a\u00020 HÖ\u0001R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\t\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\nX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006!"}, d2 = {"Landroidx/compose/material3/FabVisibleModifier;", "Landroidx/compose/ui/node/ModifierNodeElement;", "Landroidx/compose/material3/FabVisibleNode;", ViewProps.VISIBLE, "", "alignment", "Landroidx/compose/ui/Alignment;", "targetScale", "", "scaleAnimationSpec", "Landroidx/compose/animation/core/AnimationSpec;", "alphaAnimationSpec", "<init>", "(ZLandroidx/compose/ui/Alignment;FLandroidx/compose/animation/core/AnimationSpec;Landroidx/compose/animation/core/AnimationSpec;)V", PasskeyWebListener.CREATE_UNIQUE_KEY, "update", "", "node", "inspectableProperties", "Landroidx/compose/ui/platform/InspectorInfo;", "component1", "component2", "component3", "component4", "component5", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "other", "", "hashCode", "", "toString", "", "material3"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final /* data */ class FabVisibleModifier extends ModifierNodeElement<FabVisibleNode> {
    public static final int $stable = 0;
    private final Alignment alignment;
    private final AnimationSpec<Float> alphaAnimationSpec;
    private final AnimationSpec<Float> scaleAnimationSpec;
    private final float targetScale;
    private final boolean visible;

    /* JADX INFO: renamed from: component1, reason: from getter */
    private final boolean getVisible() {
        return this.visible;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    private final Alignment getAlignment() {
        return this.alignment;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    private final float getTargetScale() {
        return this.targetScale;
    }

    private final AnimationSpec<Float> component4() {
        return this.scaleAnimationSpec;
    }

    private final AnimationSpec<Float> component5() {
        return this.alphaAnimationSpec;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ FabVisibleModifier copy$default(FabVisibleModifier fabVisibleModifier, boolean z, Alignment alignment, float f, AnimationSpec animationSpec, AnimationSpec animationSpec2, int i, Object obj) {
        if ((i & 1) != 0) {
            z = fabVisibleModifier.visible;
        }
        if ((i & 2) != 0) {
            alignment = fabVisibleModifier.alignment;
        }
        if ((i & 4) != 0) {
            f = fabVisibleModifier.targetScale;
        }
        if ((i & 8) != 0) {
            animationSpec = fabVisibleModifier.scaleAnimationSpec;
        }
        if ((i & 16) != 0) {
            animationSpec2 = fabVisibleModifier.alphaAnimationSpec;
        }
        AnimationSpec animationSpec3 = animationSpec2;
        float f2 = f;
        return fabVisibleModifier.copy(z, alignment, f2, animationSpec, animationSpec3);
    }

    public final FabVisibleModifier copy(boolean visible, Alignment alignment, float targetScale, AnimationSpec<Float> scaleAnimationSpec, AnimationSpec<Float> alphaAnimationSpec) {
        return new FabVisibleModifier(visible, alignment, targetScale, scaleAnimationSpec, alphaAnimationSpec);
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof FabVisibleModifier)) {
            return false;
        }
        FabVisibleModifier fabVisibleModifier = (FabVisibleModifier) other;
        return this.visible == fabVisibleModifier.visible && Intrinsics.areEqual(this.alignment, fabVisibleModifier.alignment) && Float.compare(this.targetScale, fabVisibleModifier.targetScale) == 0 && Intrinsics.areEqual(this.scaleAnimationSpec, fabVisibleModifier.scaleAnimationSpec) && Intrinsics.areEqual(this.alphaAnimationSpec, fabVisibleModifier.alphaAnimationSpec);
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public int hashCode() {
        int iHashCode = ((((Boolean.hashCode(this.visible) * 31) + this.alignment.hashCode()) * 31) + Float.hashCode(this.targetScale)) * 31;
        AnimationSpec<Float> animationSpec = this.scaleAnimationSpec;
        int iHashCode2 = (iHashCode + (animationSpec == null ? 0 : animationSpec.hashCode())) * 31;
        AnimationSpec<Float> animationSpec2 = this.alphaAnimationSpec;
        return iHashCode2 + (animationSpec2 != null ? animationSpec2.hashCode() : 0);
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public void inspectableProperties(InspectorInfo inspectorInfo) {
    }

    public String toString() {
        return "FabVisibleModifier(visible=" + this.visible + ", alignment=" + this.alignment + ", targetScale=" + this.targetScale + ", scaleAnimationSpec=" + this.scaleAnimationSpec + ", alphaAnimationSpec=" + this.alphaAnimationSpec + ')';
    }

    public FabVisibleModifier(boolean z, Alignment alignment, float f, AnimationSpec<Float> animationSpec, AnimationSpec<Float> animationSpec2) {
        this.visible = z;
        this.alignment = alignment;
        this.targetScale = f;
        this.scaleAnimationSpec = animationSpec;
        this.alphaAnimationSpec = animationSpec2;
    }

    public /* synthetic */ FabVisibleModifier(boolean z, Alignment alignment, float f, AnimationSpec animationSpec, AnimationSpec animationSpec2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(z, alignment, f, (i & 8) != 0 ? null : animationSpec, (i & 16) != 0 ? null : animationSpec2);
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    /* JADX INFO: renamed from: create */
    public FabVisibleNode getNode() {
        return new FabVisibleNode(this.visible, this.alignment, this.targetScale, this.scaleAnimationSpec, this.alphaAnimationSpec);
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public void update(FabVisibleNode node) {
        node.updateNode(this.visible, this.alignment, this.targetScale, this.scaleAnimationSpec, this.alphaAnimationSpec);
    }
}
