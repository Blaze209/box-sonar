package androidx.compose.material;

import androidx.compose.animation.SingleValueAnimationKt;
import androidx.compose.animation.core.AnimationSpecKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.ui.graphics.Color;
import com.box.android.preview.annotations.ui.views.ColorPickerFragment;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: RadioButton.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003¢\u0006\u0004\b\u0006\u0010\u0007J#\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00030\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\fH\u0017¢\u0006\u0002\u0010\u000eJ\u0013\u0010\u000f\u001a\u00020\f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011H\u0096\u0002J\b\u0010\u0012\u001a\u00020\u0013H\u0016R\u0010\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\bR\u0010\u0010\u0004\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\bR\u0010\u0010\u0005\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\b¨\u0006\u0014"}, d2 = {"Landroidx/compose/material/DefaultRadioButtonColors;", "Landroidx/compose/material/RadioButtonColors;", ColorPickerFragment.EXTRA_SELECTED_COLOR, "Landroidx/compose/ui/graphics/Color;", "unselectedColor", "disabledColor", "<init>", "(JJJLkotlin/jvm/internal/DefaultConstructorMarker;)V", "J", "radioColor", "Landroidx/compose/runtime/State;", "enabled", "", "selected", "(ZZLandroidx/compose/runtime/Composer;I)Landroidx/compose/runtime/State;", "equals", "other", "", "hashCode", "", "material"}, k = 1, mv = {2, 0, 0}, xi = 48)
final class DefaultRadioButtonColors implements RadioButtonColors {
    private final long disabledColor;
    private final long selectedColor;
    private final long unselectedColor;

    public /* synthetic */ DefaultRadioButtonColors(long j, long j2, long j3, DefaultConstructorMarker defaultConstructorMarker) {
        this(j, j2, j3);
    }

    private DefaultRadioButtonColors(long j, long j2, long j3) {
        this.selectedColor = j;
        this.unselectedColor = j2;
        this.disabledColor = j3;
    }

    @Override // androidx.compose.material.RadioButtonColors
    public State<Color> radioColor(boolean z, boolean z2, Composer composer, int i) {
        long j;
        Composer composer2;
        State<Color> stateRememberUpdatedState;
        composer.startReplaceGroup(1243421834);
        ComposerKt.sourceInformation(composer, "C(radioColor)N(enabled,selected):RadioButton.kt#jmzs0o");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1243421834, i, -1, "androidx.compose.material.DefaultRadioButtonColors.radioColor (RadioButton.kt:176)");
        }
        if (!z) {
            j = this.disabledColor;
        } else if (!z2) {
            j = this.unselectedColor;
        } else {
            j = this.selectedColor;
        }
        long j2 = j;
        if (z) {
            composer.startReplaceGroup(-1312667467);
            ComposerKt.sourceInformation(composer, "187@7522L75");
            composer2 = composer;
            stateRememberUpdatedState = SingleValueAnimationKt.m437animateColorAsStateeuL9pac(j2, AnimationSpecKt.tween$default(100, 0, null, 6, null), null, null, composer2, 48, 12);
            composer2.endReplaceGroup();
        } else {
            composer2 = composer;
            composer2.startReplaceGroup(-1312564764);
            ComposerKt.sourceInformation(composer2, "189@7627L28");
            stateRememberUpdatedState = SnapshotStateKt.rememberUpdatedState(Color.m6804boximpl(j2), composer2, 0);
            composer2.endReplaceGroup();
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer2.endReplaceGroup();
        return stateRememberUpdatedState;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (other == null || getClass() != other.getClass()) {
            return false;
        }
        DefaultRadioButtonColors defaultRadioButtonColors = (DefaultRadioButtonColors) other;
        return Color.m6815equalsimpl0(this.selectedColor, defaultRadioButtonColors.selectedColor) && Color.m6815equalsimpl0(this.unselectedColor, defaultRadioButtonColors.unselectedColor) && Color.m6815equalsimpl0(this.disabledColor, defaultRadioButtonColors.disabledColor);
    }

    public int hashCode() {
        return (((Color.m6821hashCodeimpl(this.selectedColor) * 31) + Color.m6821hashCodeimpl(this.unselectedColor)) * 31) + Color.m6821hashCodeimpl(this.disabledColor);
    }
}
