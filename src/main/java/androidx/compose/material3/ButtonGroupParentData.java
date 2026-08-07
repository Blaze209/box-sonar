package androidx.compose.material3;

import androidx.compose.animation.core.Animatable;
import androidx.compose.animation.core.AnimatableKt;
import androidx.compose.animation.core.AnimationVector1D;
import androidx.compose.ui.Alignment;
import com.box.android.domain.analytics.BoxAmplitudeAnalytics;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: ButtonGroup.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0013\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0081\b\u0018\u00002\u00020\u0001B3\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\u0014\b\u0002\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00060\u0005\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\u0004\b\t\u0010\nJ\t\u0010\u0017\u001a\u00020\u0003HÆ\u0003J\u0015\u0010\u0018\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00060\u0005HÆ\u0003J\u000b\u0010\u0019\u001a\u0004\u0018\u00010\bHÆ\u0003J5\u0010\u001a\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u0014\b\u0002\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00060\u00052\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\bHÆ\u0001J\u0013\u0010\u001b\u001a\u00020\u001c2\b\u0010\u001d\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001e\u001a\u00020\u001fHÖ\u0001J\t\u0010 \u001a\u00020!HÖ\u0001R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR&\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00060\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u001c\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016¨\u0006\""}, d2 = {"Landroidx/compose/material3/ButtonGroupParentData;", "", "weight", "", "pressedAnimatable", "Landroidx/compose/animation/core/Animatable;", "Landroidx/compose/animation/core/AnimationVector1D;", "alignment", "Landroidx/compose/ui/Alignment$Vertical;", "<init>", "(FLandroidx/compose/animation/core/Animatable;Landroidx/compose/ui/Alignment$Vertical;)V", "getWeight", "()F", "setWeight", "(F)V", "getPressedAnimatable", "()Landroidx/compose/animation/core/Animatable;", "setPressedAnimatable", "(Landroidx/compose/animation/core/Animatable;)V", "getAlignment", "()Landroidx/compose/ui/Alignment$Vertical;", "setAlignment", "(Landroidx/compose/ui/Alignment$Vertical;)V", "component1", "component2", "component3", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "", "other", "hashCode", "", "toString", "", "material3"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final /* data */ class ButtonGroupParentData {
    public static final int $stable = 8;
    private Alignment.Vertical alignment;
    private Animatable<Float, AnimationVector1D> pressedAnimatable;
    private float weight;

    public ButtonGroupParentData() {
        this(0.0f, null, null, 7, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ ButtonGroupParentData copy$default(ButtonGroupParentData buttonGroupParentData, float f, Animatable animatable, Alignment.Vertical vertical, int i, Object obj) {
        if ((i & 1) != 0) {
            f = buttonGroupParentData.weight;
        }
        if ((i & 2) != 0) {
            animatable = buttonGroupParentData.pressedAnimatable;
        }
        if ((i & 4) != 0) {
            vertical = buttonGroupParentData.alignment;
        }
        return buttonGroupParentData.copy(f, animatable, vertical);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final float getWeight() {
        return this.weight;
    }

    public final Animatable<Float, AnimationVector1D> component2() {
        return this.pressedAnimatable;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final Alignment.Vertical getAlignment() {
        return this.alignment;
    }

    public final ButtonGroupParentData copy(float weight, Animatable<Float, AnimationVector1D> pressedAnimatable, Alignment.Vertical alignment) {
        return new ButtonGroupParentData(weight, pressedAnimatable, alignment);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ButtonGroupParentData)) {
            return false;
        }
        ButtonGroupParentData buttonGroupParentData = (ButtonGroupParentData) other;
        return Float.compare(this.weight, buttonGroupParentData.weight) == 0 && Intrinsics.areEqual(this.pressedAnimatable, buttonGroupParentData.pressedAnimatable) && Intrinsics.areEqual(this.alignment, buttonGroupParentData.alignment);
    }

    public int hashCode() {
        int iHashCode = ((Float.hashCode(this.weight) * 31) + this.pressedAnimatable.hashCode()) * 31;
        Alignment.Vertical vertical = this.alignment;
        return iHashCode + (vertical == null ? 0 : vertical.hashCode());
    }

    public String toString() {
        return "ButtonGroupParentData(weight=" + this.weight + ", pressedAnimatable=" + this.pressedAnimatable + ", alignment=" + this.alignment + ')';
    }

    public ButtonGroupParentData(float f, Animatable<Float, AnimationVector1D> animatable, Alignment.Vertical vertical) {
        this.weight = f;
        this.pressedAnimatable = animatable;
        this.alignment = vertical;
    }

    public final float getWeight() {
        return this.weight;
    }

    public final void setWeight(float f) {
        this.weight = f;
    }

    public /* synthetic */ ButtonGroupParentData(float f, Animatable animatable, Alignment.Vertical vertical, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? 0.0f : f, (i & 2) != 0 ? AnimatableKt.Animatable$default(0.0f, 0.0f, 2, null) : animatable, (i & 4) != 0 ? null : vertical);
    }

    public final Animatable<Float, AnimationVector1D> getPressedAnimatable() {
        return this.pressedAnimatable;
    }

    public final void setPressedAnimatable(Animatable<Float, AnimationVector1D> animatable) {
        this.pressedAnimatable = animatable;
    }

    public final Alignment.Vertical getAlignment() {
        return this.alignment;
    }

    public final void setAlignment(Alignment.Vertical vertical) {
        this.alignment = vertical;
    }
}
