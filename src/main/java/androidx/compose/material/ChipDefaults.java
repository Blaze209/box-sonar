package androidx.compose.material;

import androidx.compose.foundation.BorderStroke;
import androidx.compose.foundation.BorderStrokeKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.ColorKt;
import androidx.compose.ui.unit.Dp;
import kotlin.Metadata;

/* JADX INFO: compiled from: Chip.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\t\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003JK\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010\r\u001a\u00020\f2\b\b\u0002\u0010\u000e\u001a\u00020\f2\b\b\u0002\u0010\u000f\u001a\u00020\f2\b\b\u0002\u0010\u0010\u001a\u00020\f2\b\b\u0002\u0010\u0011\u001a\u00020\fH\u0007¢\u0006\u0004\b\u0012\u0010\u0013JK\u0010\u0014\u001a\u00020\n2\b\b\u0002\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010\r\u001a\u00020\f2\b\b\u0002\u0010\u000e\u001a\u00020\f2\b\b\u0002\u0010\u000f\u001a\u00020\f2\b\b\u0002\u0010\u0010\u001a\u00020\f2\b\b\u0002\u0010\u0011\u001a\u00020\fH\u0007¢\u0006\u0004\b\u0015\u0010\u0013Ji\u0010\u0016\u001a\u00020\u00172\b\b\u0002\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010\r\u001a\u00020\f2\b\b\u0002\u0010\u0018\u001a\u00020\f2\b\b\u0002\u0010\u000f\u001a\u00020\f2\b\b\u0002\u0010\u0010\u001a\u00020\f2\b\b\u0002\u0010\u0019\u001a\u00020\f2\b\b\u0002\u0010\u001a\u001a\u00020\f2\b\b\u0002\u0010\u001b\u001a\u00020\f2\b\b\u0002\u0010\u001c\u001a\u00020\fH\u0007¢\u0006\u0004\b\u001d\u0010\u001eJi\u0010\u001f\u001a\u00020\u00172\b\b\u0002\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010\r\u001a\u00020\f2\b\b\u0002\u0010\u0018\u001a\u00020\f2\b\b\u0002\u0010\u000f\u001a\u00020\f2\b\b\u0002\u0010\u0010\u001a\u00020\f2\b\b\u0002\u0010\u0019\u001a\u00020\f2\b\b\u0002\u0010\u001a\u001a\u00020\f2\b\b\u0002\u0010\u001b\u001a\u00020\f2\b\b\u0002\u0010\u001c\u001a\u00020\fH\u0007¢\u0006\u0004\b \u0010\u001eR\u0013\u0010\u0004\u001a\u00020\u0005¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\u0006\u0010\u0007R\u0011\u0010!\u001a\u00020\"8G¢\u0006\u0006\u001a\u0004\b#\u0010$R\u000e\u0010%\u001a\u00020&X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010'\u001a\u00020&X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010(\u001a\u00020&X\u0086T¢\u0006\u0002\n\u0000R\u0013\u0010)\u001a\u00020\u0005¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b*\u0010\u0007R\u0013\u0010+\u001a\u00020\u0005¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b,\u0010\u0007R\u0013\u0010-\u001a\u00020\u0005¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b.\u0010\u0007¨\u0006/"}, d2 = {"Landroidx/compose/material/ChipDefaults;", "", "<init>", "()V", "MinHeight", "Landroidx/compose/ui/unit/Dp;", "getMinHeight-D9Ej5fM", "()F", "F", "chipColors", "Landroidx/compose/material/ChipColors;", "backgroundColor", "Landroidx/compose/ui/graphics/Color;", "contentColor", "leadingIconContentColor", "disabledBackgroundColor", "disabledContentColor", "disabledLeadingIconContentColor", "chipColors-5tl4gsc", "(JJJJJJLandroidx/compose/runtime/Composer;II)Landroidx/compose/material/ChipColors;", "outlinedChipColors", "outlinedChipColors-5tl4gsc", "filterChipColors", "Landroidx/compose/material/SelectableChipColors;", "leadingIconColor", "disabledLeadingIconColor", "selectedBackgroundColor", "selectedContentColor", "selectedLeadingIconColor", "filterChipColors-J08w3-E", "(JJJJJJJJJLandroidx/compose/runtime/Composer;II)Landroidx/compose/material/SelectableChipColors;", "outlinedFilterChipColors", "outlinedFilterChipColors-J08w3-E", "outlinedBorder", "Landroidx/compose/foundation/BorderStroke;", "getOutlinedBorder", "(Landroidx/compose/runtime/Composer;I)Landroidx/compose/foundation/BorderStroke;", "LeadingIconOpacity", "", "ContentOpacity", "OutlinedBorderOpacity", "OutlinedBorderSize", "getOutlinedBorderSize-D9Ej5fM", "LeadingIconSize", "getLeadingIconSize-D9Ej5fM", "SelectedIconSize", "getSelectedIconSize-D9Ej5fM", "material"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class ChipDefaults {
    public static final int $stable = 0;
    public static final float ContentOpacity = 0.87f;
    public static final float LeadingIconOpacity = 0.54f;
    public static final float OutlinedBorderOpacity = 0.12f;
    public static final ChipDefaults INSTANCE = new ChipDefaults();
    private static final float MinHeight = Dp.m9687constructorimpl(32);
    private static final float OutlinedBorderSize = Dp.m9687constructorimpl(1);
    private static final float LeadingIconSize = Dp.m9687constructorimpl(20);
    private static final float SelectedIconSize = Dp.m9687constructorimpl(18);

    private ChipDefaults() {
    }

    /* JADX INFO: renamed from: getMinHeight-D9Ej5fM, reason: not valid java name */
    public final float m2322getMinHeightD9Ej5fM() {
        return MinHeight;
    }

    /* JADX INFO: renamed from: chipColors-5tl4gsc, reason: not valid java name */
    public final ChipColors m2319chipColors5tl4gsc(long j, long j2, long j3, long j4, long j5, long j6, Composer composer, int i, int i2) {
        long jM6813copywmQWz5c$default;
        long jM6813copywmQWz5c$default2;
        ComposerKt.sourceInformationMarkerStart(composer, 1838505436, "C(chipColors)N(backgroundColor:c#ui.graphics.Color,contentColor:c#ui.graphics.Color,leadingIconContentColor:c#ui.graphics.Color,disabledBackgroundColor:c#ui.graphics.Color,disabledContentColor:c#ui.graphics.Color,disabledLeadingIconContentColor:c#ui.graphics.Color)375@16985L6,377@17100L6,378@17161L6,381@17363L6,382@17423L8,383@17502L6,385@17608L8,387@17747L8:Chip.kt#jmzs0o");
        long jM6859compositeOverOWjLjI = (i2 & 1) != 0 ? ColorKt.m6859compositeOverOWjLjI(Color.m6813copywmQWz5c$default(MaterialTheme.INSTANCE.getColors(composer, 6).m2341getOnSurface0d7_KjU(), 0.12f, 0.0f, 0.0f, 0.0f, 14, null), MaterialTheme.INSTANCE.getColors(composer, 6).m2346getSurface0d7_KjU()) : j;
        long jM6813copywmQWz5c$default3 = (i2 & 2) != 0 ? Color.m6813copywmQWz5c$default(MaterialTheme.INSTANCE.getColors(composer, 6).m2341getOnSurface0d7_KjU(), 0.87f, 0.0f, 0.0f, 0.0f, 14, null) : j2;
        long jM6813copywmQWz5c$default4 = (i2 & 4) != 0 ? Color.m6813copywmQWz5c$default(jM6813copywmQWz5c$default3, 0.54f, 0.0f, 0.0f, 0.0f, 14, null) : j3;
        long jM6859compositeOverOWjLjI2 = (i2 & 8) != 0 ? ColorKt.m6859compositeOverOWjLjI(Color.m6813copywmQWz5c$default(MaterialTheme.INSTANCE.getColors(composer, 6).m2341getOnSurface0d7_KjU(), ContentAlpha.INSTANCE.getDisabled(composer, 6) * 0.12f, 0.0f, 0.0f, 0.0f, 14, null), MaterialTheme.INSTANCE.getColors(composer, 6).m2346getSurface0d7_KjU()) : j4;
        if ((i2 & 16) != 0) {
            jM6813copywmQWz5c$default = Color.m6813copywmQWz5c$default(jM6813copywmQWz5c$default3, ContentAlpha.INSTANCE.getDisabled(composer, 6) * 0.87f, 0.0f, 0.0f, 0.0f, 14, null);
        } else {
            jM6813copywmQWz5c$default = j5;
        }
        if ((i2 & 32) != 0) {
            jM6813copywmQWz5c$default2 = Color.m6813copywmQWz5c$default(jM6813copywmQWz5c$default4, ContentAlpha.INSTANCE.getDisabled(composer, 6) * 0.54f, 0.0f, 0.0f, 0.0f, 14, null);
        } else {
            jM6813copywmQWz5c$default2 = j6;
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1838505436, i, -1, "androidx.compose.material.ChipDefaults.chipColors (Chip.kt:389)");
        }
        DefaultChipColors defaultChipColors = new DefaultChipColors(jM6859compositeOverOWjLjI, jM6813copywmQWz5c$default3, jM6813copywmQWz5c$default4, jM6859compositeOverOWjLjI2, jM6813copywmQWz5c$default, jM6813copywmQWz5c$default2, null);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return defaultChipColors;
    }

    /* JADX INFO: renamed from: outlinedChipColors-5tl4gsc, reason: not valid java name */
    public final ChipColors m2325outlinedChipColors5tl4gsc(long j, long j2, long j3, long j4, long j5, long j6, Composer composer, int i, int i2) {
        long jM6813copywmQWz5c$default;
        long j7;
        long jM6813copywmQWz5c$default2;
        ComposerKt.sourceInformationMarkerStart(composer, -1763922662, "C(outlinedChipColors)N(backgroundColor:c#ui.graphics.Color,contentColor:c#ui.graphics.Color,leadingIconContentColor:c#ui.graphics.Color,disabledBackgroundColor:c#ui.graphics.Color,disabledContentColor:c#ui.graphics.Color,disabledLeadingIconContentColor:c#ui.graphics.Color)413@19076L6,414@19136L6,418@19418L8,420@19557L8,422@19617L371:Chip.kt#jmzs0o");
        long jM2346getSurface0d7_KjU = (i2 & 1) != 0 ? MaterialTheme.INSTANCE.getColors(composer, 6).m2346getSurface0d7_KjU() : j;
        long jM6813copywmQWz5c$default3 = (i2 & 2) != 0 ? Color.m6813copywmQWz5c$default(MaterialTheme.INSTANCE.getColors(composer, 6).m2341getOnSurface0d7_KjU(), 0.87f, 0.0f, 0.0f, 0.0f, 14, null) : j2;
        long jM6813copywmQWz5c$default4 = (i2 & 4) != 0 ? Color.m6813copywmQWz5c$default(jM6813copywmQWz5c$default3, 0.54f, 0.0f, 0.0f, 0.0f, 14, null) : j3;
        long j8 = (i2 & 8) != 0 ? jM2346getSurface0d7_KjU : j4;
        if ((i2 & 16) != 0) {
            jM6813copywmQWz5c$default = Color.m6813copywmQWz5c$default(jM6813copywmQWz5c$default3, ContentAlpha.INSTANCE.getDisabled(composer, 6) * 0.87f, 0.0f, 0.0f, 0.0f, 14, null);
        } else {
            jM6813copywmQWz5c$default = j5;
        }
        if ((i2 & 32) != 0) {
            long j9 = jM6813copywmQWz5c$default4;
            jM6813copywmQWz5c$default2 = Color.m6813copywmQWz5c$default(j9, ContentAlpha.INSTANCE.getDisabled(composer, 6) * 0.54f, 0.0f, 0.0f, 0.0f, 14, null);
            j7 = j9;
        } else {
            j7 = jM6813copywmQWz5c$default4;
            jM6813copywmQWz5c$default2 = j6;
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1763922662, i, -1, "androidx.compose.material.ChipDefaults.outlinedChipColors (Chip.kt:422)");
        }
        ChipColors chipColorsM2319chipColors5tl4gsc = m2319chipColors5tl4gsc(jM2346getSurface0d7_KjU, jM6813copywmQWz5c$default3, j7, j8, jM6813copywmQWz5c$default, jM6813copywmQWz5c$default2, composer, i & 4194302, 0);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return chipColorsM2319chipColors5tl4gsc;
    }

    /* JADX INFO: renamed from: filterChipColors-J08w3-E, reason: not valid java name */
    public final SelectableChipColors m2320filterChipColorsJ08w3E(long j, long j2, long j3, long j4, long j5, long j6, long j7, long j8, long j9, Composer composer, int i, int i2) {
        long jM6813copywmQWz5c$default;
        long jM6813copywmQWz5c$default2;
        ComposerKt.sourceInformationMarkerStart(composer, 830140629, "C(filterChipColors)N(backgroundColor:c#ui.graphics.Color,contentColor:c#ui.graphics.Color,leadingIconColor:c#ui.graphics.Color,disabledBackgroundColor:c#ui.graphics.Color,disabledContentColor:c#ui.graphics.Color,disabledLeadingIconColor:c#ui.graphics.Color,selectedBackgroundColor:c#ui.graphics.Color,selectedContentColor:c#ui.graphics.Color,selectedLeadingIconColor:c#ui.graphics.Color)448@20997L6,450@21112L6,451@21173L6,454@21360L6,455@21420L8,456@21499L6,458@21605L8,460@21730L8,462@21829L6,466@22012L6,470@22197L6:Chip.kt#jmzs0o");
        long jM6859compositeOverOWjLjI = (i2 & 1) != 0 ? ColorKt.m6859compositeOverOWjLjI(Color.m6813copywmQWz5c$default(MaterialTheme.INSTANCE.getColors(composer, 6).m2341getOnSurface0d7_KjU(), 0.12f, 0.0f, 0.0f, 0.0f, 14, null), MaterialTheme.INSTANCE.getColors(composer, 6).m2346getSurface0d7_KjU()) : j;
        long jM6813copywmQWz5c$default3 = (i2 & 2) != 0 ? Color.m6813copywmQWz5c$default(MaterialTheme.INSTANCE.getColors(composer, 6).m2341getOnSurface0d7_KjU(), 0.87f, 0.0f, 0.0f, 0.0f, 14, null) : j2;
        long jM6813copywmQWz5c$default4 = (i2 & 4) != 0 ? Color.m6813copywmQWz5c$default(jM6813copywmQWz5c$default3, 0.54f, 0.0f, 0.0f, 0.0f, 14, null) : j3;
        long jM6859compositeOverOWjLjI2 = (i2 & 8) != 0 ? ColorKt.m6859compositeOverOWjLjI(Color.m6813copywmQWz5c$default(MaterialTheme.INSTANCE.getColors(composer, 6).m2341getOnSurface0d7_KjU(), ContentAlpha.INSTANCE.getDisabled(composer, 6) * 0.12f, 0.0f, 0.0f, 0.0f, 14, null), MaterialTheme.INSTANCE.getColors(composer, 6).m2346getSurface0d7_KjU()) : j4;
        if ((i2 & 16) != 0) {
            jM6813copywmQWz5c$default = Color.m6813copywmQWz5c$default(jM6813copywmQWz5c$default3, ContentAlpha.INSTANCE.getDisabled(composer, 6) * 0.87f, 0.0f, 0.0f, 0.0f, 14, null);
        } else {
            jM6813copywmQWz5c$default = j5;
        }
        if ((i2 & 32) != 0) {
            jM6813copywmQWz5c$default2 = Color.m6813copywmQWz5c$default(jM6813copywmQWz5c$default4, ContentAlpha.INSTANCE.getDisabled(composer, 6) * 0.54f, 0.0f, 0.0f, 0.0f, 14, null);
        } else {
            jM6813copywmQWz5c$default2 = j6;
        }
        long jM6859compositeOverOWjLjI3 = (i2 & 64) != 0 ? ColorKt.m6859compositeOverOWjLjI(Color.m6813copywmQWz5c$default(MaterialTheme.INSTANCE.getColors(composer, 6).m2341getOnSurface0d7_KjU(), 0.12f, 0.0f, 0.0f, 0.0f, 14, null), jM6859compositeOverOWjLjI) : j7;
        long jM6859compositeOverOWjLjI4 = (i2 & 128) != 0 ? ColorKt.m6859compositeOverOWjLjI(Color.m6813copywmQWz5c$default(MaterialTheme.INSTANCE.getColors(composer, 6).m2341getOnSurface0d7_KjU(), 0.16f, 0.0f, 0.0f, 0.0f, 14, null), jM6813copywmQWz5c$default3) : j8;
        long jM6859compositeOverOWjLjI5 = (i2 & 256) != 0 ? ColorKt.m6859compositeOverOWjLjI(Color.m6813copywmQWz5c$default(MaterialTheme.INSTANCE.getColors(composer, 6).m2341getOnSurface0d7_KjU(), 0.16f, 0.0f, 0.0f, 0.0f, 14, null), jM6813copywmQWz5c$default4) : j9;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(830140629, i, -1, "androidx.compose.material.ChipDefaults.filterChipColors (Chip.kt:474)");
        }
        DefaultSelectableChipColors defaultSelectableChipColors = new DefaultSelectableChipColors(jM6859compositeOverOWjLjI, jM6813copywmQWz5c$default3, jM6813copywmQWz5c$default4, jM6859compositeOverOWjLjI2, jM6813copywmQWz5c$default, jM6813copywmQWz5c$default2, jM6859compositeOverOWjLjI3, jM6859compositeOverOWjLjI4, jM6859compositeOverOWjLjI5, null);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return defaultSelectableChipColors;
    }

    /* JADX INFO: renamed from: outlinedFilterChipColors-J08w3-E, reason: not valid java name */
    public final SelectableChipColors m2326outlinedFilterChipColorsJ08w3E(long j, long j2, long j3, long j4, long j5, long j6, long j7, long j8, long j9, Composer composer, int i, int i2) {
        long jM6813copywmQWz5c$default;
        long jM6813copywmQWz5c$default2;
        ComposerKt.sourceInformationMarkerStart(composer, 346878099, "C(outlinedFilterChipColors)N(backgroundColor:c#ui.graphics.Color,contentColor:c#ui.graphics.Color,leadingIconColor:c#ui.graphics.Color,disabledBackgroundColor:c#ui.graphics.Color,disabledContentColor:c#ui.graphics.Color,disabledLeadingIconColor:c#ui.graphics.Color,selectedBackgroundColor:c#ui.graphics.Color,selectedContentColor:c#ui.graphics.Color,selectedLeadingIconColor:c#ui.graphics.Color)502@23909L6,503@23969L6,507@24228L8,509@24353L8,511@24452L6,515@24636L6,519@24821L6:Chip.kt#jmzs0o");
        long jM2346getSurface0d7_KjU = (i2 & 1) != 0 ? MaterialTheme.INSTANCE.getColors(composer, 6).m2346getSurface0d7_KjU() : j;
        long jM6813copywmQWz5c$default3 = (i2 & 2) != 0 ? Color.m6813copywmQWz5c$default(MaterialTheme.INSTANCE.getColors(composer, 6).m2341getOnSurface0d7_KjU(), 0.87f, 0.0f, 0.0f, 0.0f, 14, null) : j2;
        long jM6813copywmQWz5c$default4 = (i2 & 4) != 0 ? Color.m6813copywmQWz5c$default(jM6813copywmQWz5c$default3, 0.54f, 0.0f, 0.0f, 0.0f, 14, null) : j3;
        long j10 = (i2 & 8) != 0 ? jM2346getSurface0d7_KjU : j4;
        if ((i2 & 16) != 0) {
            jM6813copywmQWz5c$default = Color.m6813copywmQWz5c$default(jM6813copywmQWz5c$default3, ContentAlpha.INSTANCE.getDisabled(composer, 6) * 0.87f, 0.0f, 0.0f, 0.0f, 14, null);
        } else {
            jM6813copywmQWz5c$default = j5;
        }
        if ((i2 & 32) != 0) {
            jM6813copywmQWz5c$default2 = Color.m6813copywmQWz5c$default(jM6813copywmQWz5c$default4, ContentAlpha.INSTANCE.getDisabled(composer, 6) * 0.54f, 0.0f, 0.0f, 0.0f, 14, null);
        } else {
            jM6813copywmQWz5c$default2 = j6;
        }
        long jM6859compositeOverOWjLjI = (i2 & 64) != 0 ? ColorKt.m6859compositeOverOWjLjI(Color.m6813copywmQWz5c$default(MaterialTheme.INSTANCE.getColors(composer, 6).m2341getOnSurface0d7_KjU(), 0.16f, 0.0f, 0.0f, 0.0f, 14, null), jM2346getSurface0d7_KjU) : j7;
        long jM6859compositeOverOWjLjI2 = (i2 & 128) != 0 ? ColorKt.m6859compositeOverOWjLjI(Color.m6813copywmQWz5c$default(MaterialTheme.INSTANCE.getColors(composer, 6).m2341getOnSurface0d7_KjU(), 0.16f, 0.0f, 0.0f, 0.0f, 14, null), jM6813copywmQWz5c$default3) : j8;
        long jM6859compositeOverOWjLjI3 = (i2 & 256) != 0 ? ColorKt.m6859compositeOverOWjLjI(Color.m6813copywmQWz5c$default(MaterialTheme.INSTANCE.getColors(composer, 6).m2341getOnSurface0d7_KjU(), 0.16f, 0.0f, 0.0f, 0.0f, 14, null), jM6813copywmQWz5c$default4) : j9;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(346878099, i, -1, "androidx.compose.material.ChipDefaults.outlinedFilterChipColors (Chip.kt:523)");
        }
        DefaultSelectableChipColors defaultSelectableChipColors = new DefaultSelectableChipColors(jM2346getSurface0d7_KjU, jM6813copywmQWz5c$default3, jM6813copywmQWz5c$default4, j10, jM6813copywmQWz5c$default, jM6813copywmQWz5c$default2, jM6859compositeOverOWjLjI, jM6859compositeOverOWjLjI2, jM6859compositeOverOWjLjI3, null);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return defaultSelectableChipColors;
    }

    public final BorderStroke getOutlinedBorder(Composer composer, int i) {
        ComposerKt.sourceInformationMarkerStart(composer, -1650225597, "C(<get-outlinedBorder>)541@25750L6:Chip.kt#jmzs0o");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1650225597, i, -1, "androidx.compose.material.ChipDefaults.<get-outlinedBorder> (Chip.kt:539)");
        }
        BorderStroke borderStrokeM622BorderStrokecXLIe8U = BorderStrokeKt.m622BorderStrokecXLIe8U(OutlinedBorderSize, Color.m6813copywmQWz5c$default(MaterialTheme.INSTANCE.getColors(composer, 6).m2341getOnSurface0d7_KjU(), 0.12f, 0.0f, 0.0f, 0.0f, 14, null));
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return borderStrokeM622BorderStrokecXLIe8U;
    }

    /* JADX INFO: renamed from: getOutlinedBorderSize-D9Ej5fM, reason: not valid java name */
    public final float m2323getOutlinedBorderSizeD9Ej5fM() {
        return OutlinedBorderSize;
    }

    /* JADX INFO: renamed from: getLeadingIconSize-D9Ej5fM, reason: not valid java name */
    public final float m2321getLeadingIconSizeD9Ej5fM() {
        return LeadingIconSize;
    }

    /* JADX INFO: renamed from: getSelectedIconSize-D9Ej5fM, reason: not valid java name */
    public final float m2324getSelectedIconSizeD9Ej5fM() {
        return SelectedIconSize;
    }
}
