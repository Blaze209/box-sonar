package androidx.compose.material;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.ui.graphics.Color;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: Chip.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\b\u0003\u0018\u00002\u00020\u0001BO\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\u0006\u0010\b\u001a\u00020\u0003\u0012\u0006\u0010\t\u001a\u00020\u0003\u0012\u0006\u0010\n\u001a\u00020\u0003\u0012\u0006\u0010\u000b\u001a\u00020\u0003¢\u0006\u0004\b\f\u0010\rJ#\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00030\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0011H\u0017¢\u0006\u0002\u0010\u0013J#\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0011H\u0017¢\u0006\u0002\u0010\u0013J#\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00030\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0011H\u0017¢\u0006\u0002\u0010\u0013J\u0013\u0010\u0014\u001a\u00020\u00112\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016H\u0096\u0002J\b\u0010\u0017\u001a\u00020\u0018H\u0016R\u0010\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u000eR\u0010\u0010\u0004\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u000eR\u0010\u0010\u0005\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u000eR\u0010\u0010\u0006\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u000eR\u0010\u0010\u0007\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u000eR\u0010\u0010\b\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u000eR\u0010\u0010\t\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u000eR\u0010\u0010\n\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u000eR\u0010\u0010\u000b\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u000e¨\u0006\u0019"}, d2 = {"Landroidx/compose/material/DefaultSelectableChipColors;", "Landroidx/compose/material/SelectableChipColors;", "backgroundColor", "Landroidx/compose/ui/graphics/Color;", "contentColor", "leadingIconColor", "disabledBackgroundColor", "disabledContentColor", "disabledLeadingIconColor", "selectedBackgroundColor", "selectedContentColor", "selectedLeadingIconColor", "<init>", "(JJJJJJJJJLkotlin/jvm/internal/DefaultConstructorMarker;)V", "J", "Landroidx/compose/runtime/State;", "enabled", "", "selected", "(ZZLandroidx/compose/runtime/Composer;I)Landroidx/compose/runtime/State;", "equals", "other", "", "hashCode", "", "material"}, k = 1, mv = {2, 0, 0}, xi = 48)
final class DefaultSelectableChipColors implements SelectableChipColors {
    private final long backgroundColor;
    private final long contentColor;
    private final long disabledBackgroundColor;
    private final long disabledContentColor;
    private final long disabledLeadingIconColor;
    private final long leadingIconColor;
    private final long selectedBackgroundColor;
    private final long selectedContentColor;
    private final long selectedLeadingIconColor;

    public /* synthetic */ DefaultSelectableChipColors(long j, long j2, long j3, long j4, long j5, long j6, long j7, long j8, long j9, DefaultConstructorMarker defaultConstructorMarker) {
        this(j, j2, j3, j4, j5, j6, j7, j8, j9);
    }

    private DefaultSelectableChipColors(long j, long j2, long j3, long j4, long j5, long j6, long j7, long j8, long j9) {
        this.backgroundColor = j;
        this.contentColor = j2;
        this.leadingIconColor = j3;
        this.disabledBackgroundColor = j4;
        this.disabledContentColor = j5;
        this.disabledLeadingIconColor = j6;
        this.selectedBackgroundColor = j7;
        this.selectedContentColor = j8;
        this.selectedLeadingIconColor = j9;
    }

    @Override // androidx.compose.material.SelectableChipColors
    public State<Color> backgroundColor(boolean z, boolean z2, Composer composer, int i) {
        long j;
        composer.startReplaceGroup(-403836585);
        ComposerKt.sourceInformation(composer, "C(backgroundColor)N(enabled,selected)643@29521L28:Chip.kt#jmzs0o");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-403836585, i, -1, "androidx.compose.material.DefaultSelectableChipColors.backgroundColor (Chip.kt:636)");
        }
        if (!z) {
            j = this.disabledBackgroundColor;
        } else if (!z2) {
            j = this.backgroundColor;
        } else {
            j = this.selectedBackgroundColor;
        }
        State<Color> stateRememberUpdatedState = SnapshotStateKt.rememberUpdatedState(Color.m6804boximpl(j), composer, 0);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceGroup();
        return stateRememberUpdatedState;
    }

    @Override // androidx.compose.material.SelectableChipColors
    public State<Color> contentColor(boolean z, boolean z2, Composer composer, int i) {
        long j;
        composer.startReplaceGroup(2025240134);
        ComposerKt.sourceInformation(composer, "C(contentColor)N(enabled,selected)654@29861L28:Chip.kt#jmzs0o");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(2025240134, i, -1, "androidx.compose.material.DefaultSelectableChipColors.contentColor (Chip.kt:647)");
        }
        if (!z) {
            j = this.disabledContentColor;
        } else if (!z2) {
            j = this.contentColor;
        } else {
            j = this.selectedContentColor;
        }
        State<Color> stateRememberUpdatedState = SnapshotStateKt.rememberUpdatedState(Color.m6804boximpl(j), composer, 0);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceGroup();
        return stateRememberUpdatedState;
    }

    @Override // androidx.compose.material.SelectableChipColors
    public State<Color> leadingIconColor(boolean z, boolean z2, Composer composer, int i) {
        long j;
        composer.startReplaceGroup(189838188);
        ComposerKt.sourceInformation(composer, "C(leadingIconColor)N(enabled,selected)665@30217L28:Chip.kt#jmzs0o");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(189838188, i, -1, "androidx.compose.material.DefaultSelectableChipColors.leadingIconColor (Chip.kt:658)");
        }
        if (!z) {
            j = this.disabledLeadingIconColor;
        } else if (!z2) {
            j = this.leadingIconColor;
        } else {
            j = this.selectedLeadingIconColor;
        }
        State<Color> stateRememberUpdatedState = SnapshotStateKt.rememberUpdatedState(Color.m6804boximpl(j), composer, 0);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceGroup();
        return stateRememberUpdatedState;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (other == null || getClass() != other.getClass()) {
            return false;
        }
        DefaultSelectableChipColors defaultSelectableChipColors = (DefaultSelectableChipColors) other;
        return Color.m6815equalsimpl0(this.backgroundColor, defaultSelectableChipColors.backgroundColor) && Color.m6815equalsimpl0(this.contentColor, defaultSelectableChipColors.contentColor) && Color.m6815equalsimpl0(this.leadingIconColor, defaultSelectableChipColors.leadingIconColor) && Color.m6815equalsimpl0(this.disabledBackgroundColor, defaultSelectableChipColors.disabledBackgroundColor) && Color.m6815equalsimpl0(this.disabledContentColor, defaultSelectableChipColors.disabledContentColor) && Color.m6815equalsimpl0(this.disabledLeadingIconColor, defaultSelectableChipColors.disabledLeadingIconColor) && Color.m6815equalsimpl0(this.selectedBackgroundColor, defaultSelectableChipColors.selectedBackgroundColor) && Color.m6815equalsimpl0(this.selectedContentColor, defaultSelectableChipColors.selectedContentColor) && Color.m6815equalsimpl0(this.selectedLeadingIconColor, defaultSelectableChipColors.selectedLeadingIconColor);
    }

    public int hashCode() {
        return (((((((((((((((Color.m6821hashCodeimpl(this.backgroundColor) * 31) + Color.m6821hashCodeimpl(this.contentColor)) * 31) + Color.m6821hashCodeimpl(this.leadingIconColor)) * 31) + Color.m6821hashCodeimpl(this.disabledBackgroundColor)) * 31) + Color.m6821hashCodeimpl(this.disabledContentColor)) * 31) + Color.m6821hashCodeimpl(this.disabledLeadingIconColor)) * 31) + Color.m6821hashCodeimpl(this.selectedBackgroundColor)) * 31) + Color.m6821hashCodeimpl(this.selectedContentColor)) * 31) + Color.m6821hashCodeimpl(this.selectedLeadingIconColor);
    }
}
