package androidx.compose.material3;

import androidx.compose.animation.core.DecayAnimationSpec;
import androidx.compose.animation.core.DecayAnimationSpecKt;
import androidx.compose.animation.core.FiniteAnimationSpec;
import androidx.compose.foundation.gestures.FlingBehavior;
import androidx.compose.foundation.gestures.TargetedFlingBehavior;
import androidx.compose.foundation.gestures.snapping.LazyListSnapLayoutInfoProviderKt;
import androidx.compose.foundation.gestures.snapping.SnapFlingBehaviorKt;
import androidx.compose.foundation.gestures.snapping.SnapLayoutInfoProvider;
import androidx.compose.foundation.lazy.LazyListState;
import androidx.compose.material3.internal.Strings;
import androidx.compose.material3.internal.Strings_androidKt;
import androidx.compose.material3.tokens.DatePickerModalTokens;
import androidx.compose.material3.tokens.DividerTokens;
import androidx.compose.material3.tokens.ElevationTokens;
import androidx.compose.material3.tokens.MotionSchemeKeyTokens;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.semantics.LiveRegionMode;
import androidx.compose.ui.semantics.SemanticsModifierKt;
import androidx.compose.ui.semantics.SemanticsPropertiesKt;
import androidx.compose.ui.semantics.SemanticsPropertyReceiver;
import java.util.Arrays;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntRange;

/* JADX INFO: compiled from: DatePicker.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(d1 = {"\u0000\u008e\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0018\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\r\u0010\u0004\u001a\u00020\u0005H\u0007¢\u0006\u0002\u0010\u0006J\u008b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\b2\b\b\u0002\u0010\n\u001a\u00020\b2\b\b\u0002\u0010\u000b\u001a\u00020\b2\b\b\u0002\u0010\f\u001a\u00020\b2\b\b\u0002\u0010\r\u001a\u00020\b2\b\b\u0002\u0010\u000e\u001a\u00020\b2\b\b\u0002\u0010\u000f\u001a\u00020\b2\b\b\u0002\u0010\u0010\u001a\u00020\b2\b\b\u0002\u0010\u0011\u001a\u00020\b2\b\b\u0002\u0010\u0012\u001a\u00020\b2\b\b\u0002\u0010\u0013\u001a\u00020\b2\b\b\u0002\u0010\u0014\u001a\u00020\b2\b\b\u0002\u0010\u0015\u001a\u00020\b2\b\b\u0002\u0010\u0016\u001a\u00020\b2\b\b\u0002\u0010\u0017\u001a\u00020\b2\b\b\u0002\u0010\u0018\u001a\u00020\b2\b\b\u0002\u0010\u0019\u001a\u00020\b2\b\b\u0002\u0010\u001a\u001a\u00020\b2\b\b\u0002\u0010\u001b\u001a\u00020\b2\b\b\u0002\u0010\u001c\u001a\u00020\b2\b\b\u0002\u0010\u001d\u001a\u00020\b2\b\b\u0002\u0010\u001e\u001a\u00020\b2\b\b\u0002\u0010\u001f\u001a\u00020\b2\n\b\u0002\u0010 \u001a\u0004\u0018\u00010!H\u0007¢\u0006\u0004\b\"\u0010#J$\u0010(\u001a\u00020)2\b\b\u0002\u0010*\u001a\u00020+2\b\b\u0002\u0010,\u001a\u00020+2\b\b\u0002\u0010-\u001a\u00020+J+\u0010.\u001a\u00020/2\u0006\u00100\u001a\u0002012\b\b\u0002\u00102\u001a\u0002032\b\b\u0002\u00104\u001a\u00020\bH\u0007¢\u0006\u0004\b5\u00106J=\u00107\u001a\u00020/2\b\u00108\u001a\u0004\u0018\u0001092\u0006\u00100\u001a\u0002012\u0006\u0010(\u001a\u00020)2\b\b\u0002\u00102\u001a\u0002032\b\b\u0002\u00104\u001a\u00020\bH\u0007¢\u0006\u0004\b:\u0010;J'\u0010<\u001a\u00020=2\u0006\u0010>\u001a\u00020?2\u000e\b\u0002\u0010@\u001a\b\u0012\u0004\u0012\u00020B0AH\u0001¢\u0006\u0004\bC\u0010DR\u0018\u0010$\u001a\u00020\u0005*\u00020%8AX\u0080\u0004¢\u0006\u0006\u001a\u0004\b&\u0010'R\u0011\u0010E\u001a\u00020F¢\u0006\b\n\u0000\u001a\u0004\bG\u0010HR\u0013\u0010I\u001a\u00020J¢\u0006\n\n\u0002\u0010M\u001a\u0004\bK\u0010LR\u0011\u0010N\u001a\u00020O8G¢\u0006\u0006\u001a\u0004\bP\u0010QR\u0011\u0010R\u001a\u00020S¢\u0006\b\n\u0000\u001a\u0004\bT\u0010UR\u000e\u0010V\u001a\u00020+X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010W\u001a\u00020+X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010X\u001a\u00020+X\u0086T¢\u0006\u0002\n\u0000¨\u0006Y"}, d2 = {"Landroidx/compose/material3/DatePickerDefaults;", "", "<init>", "()V", "colors", "Landroidx/compose/material3/DatePickerColors;", "(Landroidx/compose/runtime/Composer;I)Landroidx/compose/material3/DatePickerColors;", "containerColor", "Landroidx/compose/ui/graphics/Color;", "titleContentColor", "headlineContentColor", "weekdayContentColor", "subheadContentColor", "navigationContentColor", "yearContentColor", "disabledYearContentColor", "currentYearContentColor", "selectedYearContentColor", "disabledSelectedYearContentColor", "selectedYearContainerColor", "disabledSelectedYearContainerColor", "dayContentColor", "disabledDayContentColor", "selectedDayContentColor", "disabledSelectedDayContentColor", "selectedDayContainerColor", "disabledSelectedDayContainerColor", "todayContentColor", "todayDateBorderColor", "dayInSelectionRangeContentColor", "dayInSelectionRangeContainerColor", "dividerColor", "dateTextFieldColors", "Landroidx/compose/material3/TextFieldColors;", "colors-bSRYm20", "(JJJJJJJJJJJJJJJJJJJJJJJJLandroidx/compose/material3/TextFieldColors;Landroidx/compose/runtime/Composer;IIII)Landroidx/compose/material3/DatePickerColors;", "defaultDatePickerColors", "Landroidx/compose/material3/ColorScheme;", "getDefaultDatePickerColors", "(Landroidx/compose/material3/ColorScheme;Landroidx/compose/runtime/Composer;I)Landroidx/compose/material3/DatePickerColors;", "dateFormatter", "Landroidx/compose/material3/DatePickerFormatter;", "yearSelectionSkeleton", "", "selectedDateSkeleton", "selectedDateDescriptionSkeleton", "DatePickerTitle", "", "displayMode", "Landroidx/compose/material3/DisplayMode;", "modifier", "Landroidx/compose/ui/Modifier;", "contentColor", "DatePickerTitle-FNtVw6o", "(ILandroidx/compose/ui/Modifier;JLandroidx/compose/runtime/Composer;II)V", "DatePickerHeadline", "selectedDateMillis", "", "DatePickerHeadline-ISIPfiY", "(Ljava/lang/Long;ILandroidx/compose/material3/DatePickerFormatter;Landroidx/compose/ui/Modifier;JLandroidx/compose/runtime/Composer;II)V", "rememberSnapFlingBehavior", "Landroidx/compose/foundation/gestures/FlingBehavior;", "lazyListState", "Landroidx/compose/foundation/lazy/LazyListState;", "decayAnimationSpec", "Landroidx/compose/animation/core/DecayAnimationSpec;", "", "rememberSnapFlingBehavior$material3", "(Landroidx/compose/foundation/lazy/LazyListState;Landroidx/compose/animation/core/DecayAnimationSpec;Landroidx/compose/runtime/Composer;II)Landroidx/compose/foundation/gestures/FlingBehavior;", "YearRange", "Lkotlin/ranges/IntRange;", "getYearRange", "()Lkotlin/ranges/IntRange;", "TonalElevation", "Landroidx/compose/ui/unit/Dp;", "getTonalElevation-D9Ej5fM", "()F", "F", "shape", "Landroidx/compose/ui/graphics/Shape;", "getShape", "(Landroidx/compose/runtime/Composer;I)Landroidx/compose/ui/graphics/Shape;", "AllDates", "Landroidx/compose/material3/SelectableDates;", "getAllDates", "()Landroidx/compose/material3/SelectableDates;", "YearMonthSkeleton", "YearAbbrMonthDaySkeleton", "YearMonthWeekdayDaySkeleton", "material3"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class DatePickerDefaults {
    public static final int $stable = 0;
    public static final String YearAbbrMonthDaySkeleton = "yMMMd";
    public static final String YearMonthSkeleton = "yMMMM";
    public static final String YearMonthWeekdayDaySkeleton = "yMMMMEEEEd";
    public static final DatePickerDefaults INSTANCE = new DatePickerDefaults();
    private static final IntRange YearRange = new IntRange(1900, 2100);
    private static final float TonalElevation = ElevationTokens.INSTANCE.m5363getLevel0D9Ej5fM();
    private static final SelectableDates AllDates = new SelectableDates() { // from class: androidx.compose.material3.DatePickerDefaults$AllDates$1
    };

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit DatePickerHeadline_ISIPfiY$lambda$1(DatePickerDefaults datePickerDefaults, Long l, int i, DatePickerFormatter datePickerFormatter, Modifier modifier, long j, int i2, int i3, Composer composer, int i4) {
        datePickerDefaults.m3150DatePickerHeadlineISIPfiY(l, i, datePickerFormatter, modifier, j, composer, RecomposeScopeImplKt.updateChangedFlags(i2 | 1), i3);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit DatePickerTitle_FNtVw6o$lambda$0(DatePickerDefaults datePickerDefaults, int i, Modifier modifier, long j, int i2, int i3, Composer composer, int i4) {
        datePickerDefaults.m3151DatePickerTitleFNtVw6o(i, modifier, j, composer, RecomposeScopeImplKt.updateChangedFlags(i2 | 1), i3);
        return Unit.INSTANCE;
    }

    private DatePickerDefaults() {
    }

    public final DatePickerColors colors(Composer composer, int i) {
        ComposerKt.sourceInformationMarkerStart(composer, -275219611, "C(colors)462@20477L11,462@20489L23:DatePicker.kt#uh7d8r");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-275219611, i, -1, "androidx.compose.material3.DatePickerDefaults.colors (DatePicker.kt:462)");
        }
        DatePickerColors defaultDatePickerColors = getDefaultDatePickerColors(MaterialTheme.INSTANCE.getColorScheme(composer, 6), composer, (i << 3) & 112);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return defaultDatePickerColors;
    }

    /* JADX INFO: renamed from: colors-bSRYm20, reason: not valid java name */
    public final DatePickerColors m3152colorsbSRYm20(long j, long j2, long j3, long j4, long j5, long j6, long j7, long j8, long j9, long j10, long j11, long j12, long j13, long j14, long j15, long j16, long j17, long j18, long j19, long j20, long j21, long j22, long j23, long j24, TextFieldColors textFieldColors, Composer composer, int i, int i2, int i3, int i4) {
        ComposerKt.sourceInformationMarkerStart(composer, 1991626358, "C(colors)N(containerColor:c#ui.graphics.Color,titleContentColor:c#ui.graphics.Color,headlineContentColor:c#ui.graphics.Color,weekdayContentColor:c#ui.graphics.Color,subheadContentColor:c#ui.graphics.Color,navigationContentColor:c#ui.graphics.Color,yearContentColor:c#ui.graphics.Color,disabledYearContentColor:c#ui.graphics.Color,currentYearContentColor:c#ui.graphics.Color,selectedYearContentColor:c#ui.graphics.Color,disabledSelectedYearContentColor:c#ui.graphics.Color,selectedYearContainerColor:c#ui.graphics.Color,disabledSelectedYearContainerColor:c#ui.graphics.Color,dayContentColor:c#ui.graphics.Color,disabledDayContentColor:c#ui.graphics.Color,selectedDayContentColor:c#ui.graphics.Color,disabledSelectedDayContentColor:c#ui.graphics.Color,selectedDayContainerColor:c#ui.graphics.Color,disabledSelectedDayContainerColor:c#ui.graphics.Color,todayContentColor:c#ui.graphics.Color,todayDateBorderColor:c#ui.graphics.Color,dayInSelectionRangeContentColor:c#ui.graphics.Color,dayInSelectionRangeContainerColor:c#ui.graphics.Color,dividerColor:c#ui.graphics.Color,dateTextFieldColors)531@24774L11,531@24786L23:DatePicker.kt#uh7d8r");
        long jM6850getUnspecified0d7_KjU = (i4 & 1) != 0 ? Color.INSTANCE.m6850getUnspecified0d7_KjU() : j;
        long jM6850getUnspecified0d7_KjU2 = (i4 & 2) != 0 ? Color.INSTANCE.m6850getUnspecified0d7_KjU() : j2;
        long jM6850getUnspecified0d7_KjU3 = (i4 & 4) != 0 ? Color.INSTANCE.m6850getUnspecified0d7_KjU() : j3;
        long jM6850getUnspecified0d7_KjU4 = (i4 & 8) != 0 ? Color.INSTANCE.m6850getUnspecified0d7_KjU() : j4;
        long jM6850getUnspecified0d7_KjU5 = (i4 & 16) != 0 ? Color.INSTANCE.m6850getUnspecified0d7_KjU() : j5;
        long jM6850getUnspecified0d7_KjU6 = (i4 & 32) != 0 ? Color.INSTANCE.m6850getUnspecified0d7_KjU() : j6;
        long jM6850getUnspecified0d7_KjU7 = (i4 & 64) != 0 ? Color.INSTANCE.m6850getUnspecified0d7_KjU() : j7;
        long jM6850getUnspecified0d7_KjU8 = (i4 & 128) != 0 ? Color.INSTANCE.m6850getUnspecified0d7_KjU() : j8;
        long jM6850getUnspecified0d7_KjU9 = (i4 & 256) != 0 ? Color.INSTANCE.m6850getUnspecified0d7_KjU() : j9;
        long jM6850getUnspecified0d7_KjU10 = (i4 & 512) != 0 ? Color.INSTANCE.m6850getUnspecified0d7_KjU() : j10;
        long jM6850getUnspecified0d7_KjU11 = (i4 & 1024) != 0 ? Color.INSTANCE.m6850getUnspecified0d7_KjU() : j11;
        long jM6850getUnspecified0d7_KjU12 = (i4 & 2048) != 0 ? Color.INSTANCE.m6850getUnspecified0d7_KjU() : j12;
        long jM6850getUnspecified0d7_KjU13 = (i4 & 4096) != 0 ? Color.INSTANCE.m6850getUnspecified0d7_KjU() : j13;
        long jM6850getUnspecified0d7_KjU14 = (i4 & 8192) != 0 ? Color.INSTANCE.m6850getUnspecified0d7_KjU() : j14;
        long jM6850getUnspecified0d7_KjU15 = (i4 & 16384) != 0 ? Color.INSTANCE.m6850getUnspecified0d7_KjU() : j15;
        long jM6850getUnspecified0d7_KjU16 = (32768 & i4) != 0 ? Color.INSTANCE.m6850getUnspecified0d7_KjU() : j16;
        long jM6850getUnspecified0d7_KjU17 = (65536 & i4) != 0 ? Color.INSTANCE.m6850getUnspecified0d7_KjU() : j17;
        long jM6850getUnspecified0d7_KjU18 = (131072 & i4) != 0 ? Color.INSTANCE.m6850getUnspecified0d7_KjU() : j18;
        long jM6850getUnspecified0d7_KjU19 = (262144 & i4) != 0 ? Color.INSTANCE.m6850getUnspecified0d7_KjU() : j19;
        long jM6850getUnspecified0d7_KjU20 = (524288 & i4) != 0 ? Color.INSTANCE.m6850getUnspecified0d7_KjU() : j20;
        long jM6850getUnspecified0d7_KjU21 = (1048576 & i4) != 0 ? Color.INSTANCE.m6850getUnspecified0d7_KjU() : j21;
        long jM6850getUnspecified0d7_KjU22 = (2097152 & i4) != 0 ? Color.INSTANCE.m6850getUnspecified0d7_KjU() : j22;
        long jM6850getUnspecified0d7_KjU23 = (4194304 & i4) != 0 ? Color.INSTANCE.m6850getUnspecified0d7_KjU() : j23;
        long jM6850getUnspecified0d7_KjU24 = (8388608 & i4) != 0 ? Color.INSTANCE.m6850getUnspecified0d7_KjU() : j24;
        TextFieldColors textFieldColors2 = (i4 & 16777216) != 0 ? null : textFieldColors;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1991626358, i, i2, "androidx.compose.material3.DatePickerDefaults.colors (DatePicker.kt:531)");
        }
        DatePickerColors datePickerColorsM3124copytNwlRmA = getDefaultDatePickerColors(MaterialTheme.INSTANCE.getColorScheme(composer, 6), composer, (i3 >> 12) & 112).m3124copytNwlRmA(jM6850getUnspecified0d7_KjU, jM6850getUnspecified0d7_KjU2, jM6850getUnspecified0d7_KjU3, jM6850getUnspecified0d7_KjU4, jM6850getUnspecified0d7_KjU5, jM6850getUnspecified0d7_KjU6, jM6850getUnspecified0d7_KjU7, jM6850getUnspecified0d7_KjU8, jM6850getUnspecified0d7_KjU9, jM6850getUnspecified0d7_KjU10, jM6850getUnspecified0d7_KjU11, jM6850getUnspecified0d7_KjU12, jM6850getUnspecified0d7_KjU13, jM6850getUnspecified0d7_KjU14, jM6850getUnspecified0d7_KjU15, jM6850getUnspecified0d7_KjU16, jM6850getUnspecified0d7_KjU17, jM6850getUnspecified0d7_KjU18, jM6850getUnspecified0d7_KjU19, jM6850getUnspecified0d7_KjU20, jM6850getUnspecified0d7_KjU21, jM6850getUnspecified0d7_KjU23, jM6850getUnspecified0d7_KjU22, jM6850getUnspecified0d7_KjU24, textFieldColors2);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return datePickerColorsM3124copytNwlRmA;
    }

    public final DatePickerColors getDefaultDatePickerColors(ColorScheme colorScheme, Composer composer, int i) {
        ComposerKt.sourceInformationMarkerStart(composer, 1180555308, "C(<get-defaultDatePickerColors>):DatePicker.kt#uh7d8r");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1180555308, i, -1, "androidx.compose.material3.DatePickerDefaults.<get-defaultDatePickerColors> (DatePicker.kt:561)");
        }
        DatePickerColors defaultDatePickerColorsCached = colorScheme.getDefaultDatePickerColorsCached();
        if (defaultDatePickerColorsCached != null) {
            composer.startReplaceGroup(642290457);
            composer.endReplaceGroup();
        } else {
            composer.startReplaceGroup(642416503);
            ComposerKt.sourceInformation(composer, "619@30513L30");
            DatePickerColors datePickerColors = new DatePickerColors(ColorSchemeKt.fromToken(colorScheme, DatePickerModalTokens.INSTANCE.getContainerColor()), ColorSchemeKt.fromToken(colorScheme, DatePickerModalTokens.INSTANCE.getHeaderSupportingTextColor()), ColorSchemeKt.fromToken(colorScheme, DatePickerModalTokens.INSTANCE.getHeaderHeadlineColor()), ColorSchemeKt.fromToken(colorScheme, DatePickerModalTokens.INSTANCE.getWeekdaysLabelTextColor()), ColorSchemeKt.fromToken(colorScheme, DatePickerModalTokens.INSTANCE.getRangeSelectionMonthSubheadColor()), colorScheme.getOnSurfaceVariant(), ColorSchemeKt.fromToken(colorScheme, DatePickerModalTokens.INSTANCE.getSelectionYearUnselectedLabelTextColor()), Color.m6813copywmQWz5c$default(ColorSchemeKt.fromToken(colorScheme, DatePickerModalTokens.INSTANCE.getSelectionYearUnselectedLabelTextColor()), 0.38f, 0.0f, 0.0f, 0.0f, 14, null), ColorSchemeKt.fromToken(colorScheme, DatePickerModalTokens.INSTANCE.getDateTodayLabelTextColor()), ColorSchemeKt.fromToken(colorScheme, DatePickerModalTokens.INSTANCE.getSelectionYearSelectedLabelTextColor()), Color.m6813copywmQWz5c$default(ColorSchemeKt.fromToken(colorScheme, DatePickerModalTokens.INSTANCE.getSelectionYearSelectedLabelTextColor()), 0.38f, 0.0f, 0.0f, 0.0f, 14, null), ColorSchemeKt.fromToken(colorScheme, DatePickerModalTokens.INSTANCE.getSelectionYearSelectedContainerColor()), Color.m6813copywmQWz5c$default(ColorSchemeKt.fromToken(colorScheme, DatePickerModalTokens.INSTANCE.getSelectionYearSelectedContainerColor()), 0.38f, 0.0f, 0.0f, 0.0f, 14, null), ColorSchemeKt.fromToken(colorScheme, DatePickerModalTokens.INSTANCE.getDateUnselectedLabelTextColor()), Color.m6813copywmQWz5c$default(ColorSchemeKt.fromToken(colorScheme, DatePickerModalTokens.INSTANCE.getDateUnselectedLabelTextColor()), 0.38f, 0.0f, 0.0f, 0.0f, 14, null), ColorSchemeKt.fromToken(colorScheme, DatePickerModalTokens.INSTANCE.getDateSelectedLabelTextColor()), Color.m6813copywmQWz5c$default(ColorSchemeKt.fromToken(colorScheme, DatePickerModalTokens.INSTANCE.getDateSelectedLabelTextColor()), 0.38f, 0.0f, 0.0f, 0.0f, 14, null), ColorSchemeKt.fromToken(colorScheme, DatePickerModalTokens.INSTANCE.getDateSelectedContainerColor()), Color.m6813copywmQWz5c$default(ColorSchemeKt.fromToken(colorScheme, DatePickerModalTokens.INSTANCE.getDateSelectedContainerColor()), 0.38f, 0.0f, 0.0f, 0.0f, 14, null), ColorSchemeKt.fromToken(colorScheme, DatePickerModalTokens.INSTANCE.getDateTodayLabelTextColor()), ColorSchemeKt.fromToken(colorScheme, DatePickerModalTokens.INSTANCE.getDateTodayContainerOutlineColor()), ColorSchemeKt.fromToken(colorScheme, DatePickerModalTokens.INSTANCE.getRangeSelectionActiveIndicatorContainerColor()), ColorSchemeKt.fromToken(colorScheme, DatePickerModalTokens.INSTANCE.getSelectionDateInRangeLabelTextColor()), ColorSchemeKt.fromToken(colorScheme, DividerTokens.INSTANCE.getColor()), OutlinedTextFieldDefaults.INSTANCE.getDefaultOutlinedTextFieldColors(colorScheme, composer, (i & 14) | 48), null);
            colorScheme.setDefaultDatePickerColorsCached$material3(datePickerColors);
            composer.endReplaceGroup();
            defaultDatePickerColorsCached = datePickerColors;
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return defaultDatePickerColorsCached;
    }

    public static /* synthetic */ DatePickerFormatter dateFormatter$default(DatePickerDefaults datePickerDefaults, String str, String str2, String str3, int i, Object obj) {
        if ((i & 1) != 0) {
            str = YearMonthSkeleton;
        }
        if ((i & 2) != 0) {
            str2 = YearAbbrMonthDaySkeleton;
        }
        if ((i & 4) != 0) {
            str3 = YearMonthWeekdayDaySkeleton;
        }
        return datePickerDefaults.dateFormatter(str, str2, str3);
    }

    public final DatePickerFormatter dateFormatter(String yearSelectionSkeleton, String selectedDateSkeleton, String selectedDateDescriptionSkeleton) {
        return new DatePickerFormatterImpl(yearSelectionSkeleton, selectedDateSkeleton, selectedDateDescriptionSkeleton);
    }

    /* JADX WARN: Code duplicated, block: B:23:0x0044  */
    /* JADX WARN: Code duplicated, block: B:25:0x0048  */
    /* JADX WARN: Code duplicated, block: B:27:0x0050  */
    /* JADX WARN: Code duplicated, block: B:28:0x0053  */
    /* JADX WARN: Code duplicated, block: B:31:0x0059  */
    /* JADX WARN: Code duplicated, block: B:34:0x005f  */
    /* JADX WARN: Code duplicated, block: B:36:0x0065  */
    /* JADX WARN: Code duplicated, block: B:37:0x0068  */
    /* JADX WARN: Code duplicated, block: B:41:0x0072  */
    /* JADX WARN: Code duplicated, block: B:42:0x0074  */
    /* JADX WARN: Code duplicated, block: B:45:0x007d  */
    /* JADX WARN: Code duplicated, block: B:54:0x009c A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:55:0x009e  */
    /* JADX WARN: Code duplicated, block: B:56:0x00a3  */
    /* JADX WARN: Code duplicated, block: B:59:0x00a8  */
    /* JADX WARN: Code duplicated, block: B:60:0x00b8  */
    /* JADX WARN: Code duplicated, block: B:64:0x00c3  */
    /* JADX WARN: Code duplicated, block: B:67:0x00d5  */
    /* JADX WARN: Code duplicated, block: B:68:0x011b  */
    /* JADX WARN: Code duplicated, block: B:70:0x0128  */
    /* JADX WARN: Code duplicated, block: B:71:0x0169  */
    /* JADX WARN: Code duplicated, block: B:75:0x0178  */
    /* JADX WARN: Code duplicated, block: B:77:0x017e  */
    /* JADX WARN: Code duplicated, block: B:80:0x018a  */
    /* JADX WARN: Code duplicated, block: B:82:? A[RETURN, SYNTHETIC] */
    /* JADX INFO: renamed from: DatePickerTitle-FNtVw6o, reason: not valid java name */
    public final void m3151DatePickerTitleFNtVw6o(final int i, Modifier modifier, long j, Composer composer, final int i2, final int i3) {
        int i4;
        Modifier modifier2;
        long j2;
        boolean z;
        Composer composer2;
        final Modifier modifier3;
        final long j3;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        Modifier.Companion companion;
        long j4;
        Modifier modifier4;
        int i5;
        Composer composerStartRestartGroup = composer.startRestartGroup(-390880814);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(DatePickerTitle)N(displayMode:c#material3.DisplayMode,modifier,contentColor:c#ui.graphics.Color):DatePicker.kt#uh7d8r");
        if ((i2 & 6) == 0) {
            i4 = (composerStartRestartGroup.changed(i) ? 4 : 2) | i2;
        } else {
            i4 = i2;
        }
        int i6 = i3 & 2;
        if (i6 == 0) {
            if ((i2 & 48) == 0) {
                modifier2 = modifier;
                i4 |= composerStartRestartGroup.changed(modifier2) ? 32 : 16;
            }
            if ((i2 & 384) == 0) {
                if ((i3 & 4) == 0) {
                    j2 = j;
                    int i7 = composerStartRestartGroup.changed(j2) ? 256 : 128;
                    i4 |= i7;
                } else {
                    j2 = j;
                }
                i4 |= i7;
            } else {
                j2 = j;
            }
            if ((i2 & 3072) == 0) {
                if (composerStartRestartGroup.changed(this)) {
                    i5 = 2048;
                } else {
                    i5 = 1024;
                }
                i4 |= i5;
            }
            if ((i4 & 1171) != 1170) {
                z = true;
            } else {
                z = false;
            }
            if (composerStartRestartGroup.shouldExecute(z, i4 & 1)) {
                composerStartRestartGroup.startDefaults();
                ComposerKt.sourceInformation(composerStartRestartGroup, "663@32511L8");
                if ((i2 & 1) != 0 || composerStartRestartGroup.getDefaultsInvalid()) {
                    if (i6 != 0) {
                        companion = Modifier.INSTANCE;
                    } else {
                        companion = modifier2;
                    }
                    if ((i3 & 4) != 0) {
                        long titleContentColor = colors(composerStartRestartGroup, (i4 >> 9) & 14).getTitleContentColor();
                        i4 &= -897;
                        j4 = titleContentColor;
                    } else {
                        j4 = j2;
                    }
                    modifier4 = companion;
                } else {
                    composerStartRestartGroup.skipToGroupEnd();
                    if ((i3 & 4) != 0) {
                        i4 &= -897;
                    }
                    j4 = j2;
                    modifier4 = modifier2;
                }
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-390880814, i4, -1, "androidx.compose.material3.DatePickerDefaults.DatePickerTitle (DatePicker.kt:664)");
                }
                if (DisplayMode.m3272equalsimpl0(i, DisplayMode.INSTANCE.m3277getPickerjFl4v0())) {
                    composerStartRestartGroup.startReplaceGroup(-1974299676);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "668@32659L43,667@32626L178");
                    Strings.Companion companion2 = Strings.INSTANCE;
                    TextKt.m4494TextNvy7gAk(Strings_androidKt.m5086getString2EP1pXo(Strings.m5002constructorimpl(R.string.m3c_date_picker_title), composerStartRestartGroup, 0), modifier4, j4, null, 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, null, composerStartRestartGroup, i4 & 1008, 0, 262136);
                    composer2 = composerStartRestartGroup;
                    composer2.endReplaceGroup();
                } else {
                    composer2 = composerStartRestartGroup;
                    if (DisplayMode.m3272equalsimpl0(i, DisplayMode.INSTANCE.m3276getInputjFl4v0())) {
                        composer2.startReplaceGroup(-1974292381);
                        ComposerKt.sourceInformation(composer2, "674@32887L42,673@32854L177");
                        Strings.Companion companion3 = Strings.INSTANCE;
                        TextKt.m4494TextNvy7gAk(Strings_androidKt.m5086getString2EP1pXo(Strings.m5002constructorimpl(R.string.m3c_date_input_title), composer2, 0), modifier4, j4, null, 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, null, composer2, i4 & 1008, 0, 262136);
                    } else {
                        composer2.startReplaceGroup(-1106119312);
                    }
                    composer2.endReplaceGroup();
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                modifier3 = modifier4;
                j3 = j4;
            } else {
                composer2 = composerStartRestartGroup;
                composer2.skipToGroupEnd();
                modifier3 = modifier2;
                j3 = j2;
            }
            scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.DatePickerDefaults$$ExternalSyntheticLambda2
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return DatePickerDefaults.DatePickerTitle_FNtVw6o$lambda$0(this.f$0, i, modifier3, j3, i2, i3, (Composer) obj, ((Integer) obj2).intValue());
                    }
                });
            }
        }
        i4 |= 48;
        modifier2 = modifier;
        if ((i2 & 384) == 0) {
            if ((i3 & 4) == 0) {
                j2 = j;
                if (composerStartRestartGroup.changed(j2)) {
                }
                i4 |= i7;
            } else {
                j2 = j;
            }
            i4 |= i7;
        } else {
            j2 = j;
        }
        if ((i2 & 3072) == 0) {
            if (composerStartRestartGroup.changed(this)) {
                i5 = 2048;
            } else {
                i5 = 1024;
            }
            i4 |= i5;
        }
        if ((i4 & 1171) != 1170) {
            z = true;
        } else {
            z = false;
        }
        if (composerStartRestartGroup.shouldExecute(z, i4 & 1)) {
            composerStartRestartGroup.startDefaults();
            ComposerKt.sourceInformation(composerStartRestartGroup, "663@32511L8");
            if ((i2 & 1) != 0) {
                if (i6 != 0) {
                    companion = Modifier.INSTANCE;
                } else {
                    companion = modifier2;
                }
                if ((i3 & 4) != 0) {
                    long titleContentColor2 = colors(composerStartRestartGroup, (i4 >> 9) & 14).getTitleContentColor();
                    i4 &= -897;
                    j4 = titleContentColor2;
                } else {
                    j4 = j2;
                }
                modifier4 = companion;
            } else {
                if (i6 != 0) {
                    companion = Modifier.INSTANCE;
                } else {
                    companion = modifier2;
                }
                if ((i3 & 4) != 0) {
                    long titleContentColor3 = colors(composerStartRestartGroup, (i4 >> 9) & 14).getTitleContentColor();
                    i4 &= -897;
                    j4 = titleContentColor3;
                } else {
                    j4 = j2;
                }
                modifier4 = companion;
            }
            composerStartRestartGroup.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-390880814, i4, -1, "androidx.compose.material3.DatePickerDefaults.DatePickerTitle (DatePicker.kt:664)");
            }
            if (DisplayMode.m3272equalsimpl0(i, DisplayMode.INSTANCE.m3277getPickerjFl4v0())) {
                composerStartRestartGroup.startReplaceGroup(-1974299676);
                ComposerKt.sourceInformation(composerStartRestartGroup, "668@32659L43,667@32626L178");
                Strings.Companion companion4 = Strings.INSTANCE;
                TextKt.m4494TextNvy7gAk(Strings_androidKt.m5086getString2EP1pXo(Strings.m5002constructorimpl(R.string.m3c_date_picker_title), composerStartRestartGroup, 0), modifier4, j4, null, 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, null, composerStartRestartGroup, i4 & 1008, 0, 262136);
                composer2 = composerStartRestartGroup;
                composer2.endReplaceGroup();
            } else {
                composer2 = composerStartRestartGroup;
                if (DisplayMode.m3272equalsimpl0(i, DisplayMode.INSTANCE.m3276getInputjFl4v0())) {
                    composer2.startReplaceGroup(-1974292381);
                    ComposerKt.sourceInformation(composer2, "674@32887L42,673@32854L177");
                    Strings.Companion companion5 = Strings.INSTANCE;
                    TextKt.m4494TextNvy7gAk(Strings_androidKt.m5086getString2EP1pXo(Strings.m5002constructorimpl(R.string.m3c_date_input_title), composer2, 0), modifier4, j4, null, 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, null, composer2, i4 & 1008, 0, 262136);
                } else {
                    composer2.startReplaceGroup(-1106119312);
                }
                composer2.endReplaceGroup();
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            modifier3 = modifier4;
            j3 = j4;
        } else {
            composer2 = composerStartRestartGroup;
            composer2.skipToGroupEnd();
            modifier3 = modifier2;
            j3 = j2;
        }
        scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.DatePickerDefaults$$ExternalSyntheticLambda2
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return DatePickerDefaults.DatePickerTitle_FNtVw6o$lambda$0(this.f$0, i, modifier3, j3, i2, i3, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX WARN: Code duplicated, block: B:101:0x01ed  */
    /* JADX WARN: Code duplicated, block: B:104:0x0202  */
    /* JADX WARN: Code duplicated, block: B:105:0x021d  */
    /* JADX WARN: Code duplicated, block: B:107:0x0229  */
    /* JADX WARN: Code duplicated, block: B:108:0x0244  */
    /* JADX WARN: Code duplicated, block: B:113:0x0279  */
    /* JADX WARN: Code duplicated, block: B:116:0x02c1  */
    /* JADX WARN: Code duplicated, block: B:118:0x02c7  */
    /* JADX WARN: Code duplicated, block: B:121:0x02d4  */
    /* JADX WARN: Code duplicated, block: B:123:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:40:0x0071  */
    /* JADX WARN: Code duplicated, block: B:42:0x0075  */
    /* JADX WARN: Code duplicated, block: B:44:0x007d  */
    /* JADX WARN: Code duplicated, block: B:45:0x0080  */
    /* JADX WARN: Code duplicated, block: B:48:0x0086  */
    /* JADX WARN: Code duplicated, block: B:51:0x008d  */
    /* JADX WARN: Code duplicated, block: B:53:0x0093  */
    /* JADX WARN: Code duplicated, block: B:54:0x0096  */
    /* JADX WARN: Code duplicated, block: B:58:0x00a4  */
    /* JADX WARN: Code duplicated, block: B:59:0x00a6  */
    /* JADX WARN: Code duplicated, block: B:62:0x00af  */
    /* JADX WARN: Code duplicated, block: B:71:0x00d1 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:72:0x00d3  */
    /* JADX WARN: Code duplicated, block: B:73:0x00d8  */
    /* JADX WARN: Code duplicated, block: B:76:0x00dd  */
    /* JADX WARN: Code duplicated, block: B:80:0x00f6  */
    /* JADX WARN: Code duplicated, block: B:83:0x0118  */
    /* JADX WARN: Code duplicated, block: B:85:0x012d  */
    /* JADX WARN: Code duplicated, block: B:86:0x0148  */
    /* JADX WARN: Code duplicated, block: B:88:0x0154  */
    /* JADX WARN: Code duplicated, block: B:89:0x016f  */
    /* JADX WARN: Code duplicated, block: B:91:0x017d  */
    /* JADX WARN: Code duplicated, block: B:93:0x0188  */
    /* JADX WARN: Code duplicated, block: B:95:0x019d  */
    /* JADX WARN: Code duplicated, block: B:96:0x01b8  */
    /* JADX WARN: Code duplicated, block: B:98:0x01c4  */
    /* JADX WARN: Code duplicated, block: B:99:0x01df  */
    /* JADX INFO: renamed from: DatePickerHeadline-ISIPfiY, reason: not valid java name */
    public final void m3150DatePickerHeadlineISIPfiY(Long l, final int i, DatePickerFormatter datePickerFormatter, Modifier modifier, long j, Composer composer, final int i2, final int i3) {
        int i4;
        Modifier modifier2;
        long headlineContentColor;
        boolean z;
        Composer composer2;
        final Modifier modifier3;
        final long j2;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        Modifier.Companion companion;
        int i5;
        long j3;
        Modifier modifier4;
        String date$default;
        String date;
        String strM5086getString2EP1pXo;
        final String str;
        boolean zChanged;
        Object objRememberedValue;
        int i6;
        final Long l2 = l;
        final DatePickerFormatter datePickerFormatter2 = datePickerFormatter;
        Composer composerStartRestartGroup = composer.startRestartGroup(1913724796);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(DatePickerHeadline)N(selectedDateMillis,displayMode:c#material3.DisplayMode,dateFormatter,modifier,contentColor:c#ui.graphics.Color)700@33927L15,736@35348L135,733@35251L303:DatePicker.kt#uh7d8r");
        if ((i2 & 6) == 0) {
            i4 = (composerStartRestartGroup.changed(l2) ? 4 : 2) | i2;
        } else {
            i4 = i2;
        }
        if ((i2 & 48) == 0) {
            i4 |= composerStartRestartGroup.changed(i) ? 32 : 16;
        }
        if ((i2 & 384) == 0) {
            i4 |= (i2 & 512) == 0 ? composerStartRestartGroup.changed(datePickerFormatter2) : composerStartRestartGroup.changedInstance(datePickerFormatter2) ? 256 : 128;
        }
        int i7 = i3 & 8;
        if (i7 == 0) {
            if ((i2 & 3072) == 0) {
                modifier2 = modifier;
                i4 |= composerStartRestartGroup.changed(modifier2) ? 2048 : 1024;
            }
            if ((i2 & 24576) == 0) {
                if ((i3 & 16) == 0) {
                    headlineContentColor = j;
                    int i8 = composerStartRestartGroup.changed(headlineContentColor) ? 16384 : 8192;
                    i4 |= i8;
                } else {
                    headlineContentColor = j;
                }
                i4 |= i8;
            } else {
                headlineContentColor = j;
            }
            if ((196608 & i2) == 0) {
                if (composerStartRestartGroup.changed(this)) {
                    i6 = 131072;
                } else {
                    i6 = 65536;
                }
                i4 |= i6;
            }
            if ((74899 & i4) != 74898) {
                z = true;
            } else {
                z = false;
            }
            if (composerStartRestartGroup.shouldExecute(z, i4 & 1)) {
                composerStartRestartGroup.startDefaults();
                ComposerKt.sourceInformation(composerStartRestartGroup, "698@33867L8");
                if ((i2 & 1) != 0 || composerStartRestartGroup.getDefaultsInvalid()) {
                    if (i7 != 0) {
                        companion = Modifier.INSTANCE;
                    } else {
                        companion = modifier2;
                    }
                    if ((i3 & 16) != 0) {
                        headlineContentColor = colors(composerStartRestartGroup, (i4 >> 15) & 14).getHeadlineContentColor();
                        i4 &= -57345;
                    }
                    i5 = i4;
                    j3 = headlineContentColor;
                    modifier4 = companion;
                } else {
                    composerStartRestartGroup.skipToGroupEnd();
                    if ((i3 & 16) != 0) {
                        i4 &= -57345;
                    }
                    i5 = i4;
                    j3 = headlineContentColor;
                    modifier4 = modifier2;
                }
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(1913724796, i5, -1, "androidx.compose.material3.DatePickerDefaults.DatePickerHeadline (DatePicker.kt:699)");
                }
                Locale localeDefaultLocale = CalendarLocale_androidKt.defaultLocale(composerStartRestartGroup, 0);
                date$default = DatePickerFormatter.formatDate$default(datePickerFormatter, l2, localeDefaultLocale, false, 4, null);
                datePickerFormatter2 = datePickerFormatter;
                l2 = l2;
                date = datePickerFormatter2.formatDate(l2, localeDefaultLocale, true);
                strM5086getString2EP1pXo = "";
                if (date == null) {
                    composerStartRestartGroup.startReplaceGroup(843541746);
                    composerStartRestartGroup.endReplaceGroup();
                } else {
                    composerStartRestartGroup.startReplaceGroup(380170059);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "");
                    if (DisplayMode.m3272equalsimpl0(i, DisplayMode.INSTANCE.m3277getPickerjFl4v0())) {
                        composerStartRestartGroup.startReplaceGroup(843549359);
                        ComposerKt.sourceInformation(composerStartRestartGroup, "710@34357L51");
                        Strings.Companion companion2 = Strings.INSTANCE;
                        date = Strings_androidKt.m5086getString2EP1pXo(Strings.m5002constructorimpl(R.string.m3c_date_picker_no_selection_description), composerStartRestartGroup, 0);
                        composerStartRestartGroup.endReplaceGroup();
                    } else if (DisplayMode.m3272equalsimpl0(i, DisplayMode.INSTANCE.m3276getInputjFl4v0())) {
                        composerStartRestartGroup.startReplaceGroup(843552330);
                        ComposerKt.sourceInformation(composerStartRestartGroup, "711@34450L46");
                        Strings.Companion companion3 = Strings.INSTANCE;
                        date = Strings_androidKt.m5086getString2EP1pXo(Strings.m5002constructorimpl(R.string.m3c_date_input_no_input_description), composerStartRestartGroup, 0);
                        composerStartRestartGroup.endReplaceGroup();
                    } else {
                        composerStartRestartGroup.startReplaceGroup(380391490);
                        composerStartRestartGroup.endReplaceGroup();
                        date = "";
                    }
                    composerStartRestartGroup.endReplaceGroup();
                }
                if (date$default == null) {
                    composerStartRestartGroup.startReplaceGroup(843556896);
                    composerStartRestartGroup.endReplaceGroup();
                } else {
                    composerStartRestartGroup.startReplaceGroup(380491715);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "");
                    if (DisplayMode.m3272equalsimpl0(i, DisplayMode.INSTANCE.m3277getPickerjFl4v0())) {
                        composerStartRestartGroup.startReplaceGroup(843559745);
                        ComposerKt.sourceInformation(composerStartRestartGroup, "718@34682L37");
                        Strings.Companion companion4 = Strings.INSTANCE;
                        date$default = Strings_androidKt.m5086getString2EP1pXo(Strings.m5002constructorimpl(R.string.m3c_date_picker_headline), composerStartRestartGroup, 0);
                        composerStartRestartGroup.endReplaceGroup();
                    } else if (DisplayMode.m3272equalsimpl0(i, DisplayMode.INSTANCE.m3276getInputjFl4v0())) {
                        composerStartRestartGroup.startReplaceGroup(843562272);
                        ComposerKt.sourceInformation(composerStartRestartGroup, "719@34761L36");
                        Strings.Companion companion5 = Strings.INSTANCE;
                        date$default = Strings_androidKt.m5086getString2EP1pXo(Strings.m5002constructorimpl(R.string.m3c_date_input_headline), composerStartRestartGroup, 0);
                        composerStartRestartGroup.endReplaceGroup();
                    } else {
                        composerStartRestartGroup.startReplaceGroup(380690082);
                        composerStartRestartGroup.endReplaceGroup();
                        date$default = "";
                    }
                    composerStartRestartGroup.endReplaceGroup();
                }
                if (DisplayMode.m3272equalsimpl0(i, DisplayMode.INSTANCE.m3277getPickerjFl4v0())) {
                    composerStartRestartGroup.startReplaceGroup(843569932);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "726@35000L48");
                    Strings.Companion companion6 = Strings.INSTANCE;
                    strM5086getString2EP1pXo = Strings_androidKt.m5086getString2EP1pXo(Strings.m5002constructorimpl(R.string.m3c_date_picker_headline_description), composerStartRestartGroup, 0);
                    composerStartRestartGroup.endReplaceGroup();
                } else if (DisplayMode.m3272equalsimpl0(i, DisplayMode.INSTANCE.m3276getInputjFl4v0())) {
                    composerStartRestartGroup.startReplaceGroup(843572811);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "727@35090L47");
                    Strings.Companion companion7 = Strings.INSTANCE;
                    strM5086getString2EP1pXo = Strings_androidKt.m5086getString2EP1pXo(Strings.m5002constructorimpl(R.string.m3c_date_input_headline_description), composerStartRestartGroup, 0);
                    composerStartRestartGroup.endReplaceGroup();
                } else {
                    composerStartRestartGroup.startReplaceGroup(381027362);
                    composerStartRestartGroup.endReplaceGroup();
                }
                str = String.format(strM5086getString2EP1pXo, Arrays.copyOf(new Object[]{date}, 1));
                Intrinsics.checkNotNullExpressionValue(str, "format(...)");
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 843581155, "CC(remember):DatePicker.kt#9igjgp");
                zChanged = composerStartRestartGroup.changed(str);
                objRememberedValue = composerStartRestartGroup.rememberedValue();
                if (!zChanged || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue = new Function1() { // from class: androidx.compose.material3.DatePickerDefaults$$ExternalSyntheticLambda0
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            return DatePickerDefaults.DatePickerHeadline_ISIPfiY$lambda$0$0(str, (SemanticsPropertyReceiver) obj);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                }
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                composer2 = composerStartRestartGroup;
                Modifier modifier5 = modifier4;
                TextKt.m4494TextNvy7gAk(date$default, SemanticsModifierKt.semantics$default(modifier4, false, (Function1) objRememberedValue, 1, null), j3, null, 0L, null, null, null, 0L, null, null, 0L, 0, false, 1, 0, null, null, composer2, (i5 >> 6) & 896, 24576, 245752);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                modifier3 = modifier5;
                j2 = j3;
            } else {
                composer2 = composerStartRestartGroup;
                composer2.skipToGroupEnd();
                modifier3 = modifier2;
                j2 = headlineContentColor;
            }
            scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.DatePickerDefaults$$ExternalSyntheticLambda1
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return DatePickerDefaults.DatePickerHeadline_ISIPfiY$lambda$1(this.f$0, l2, i, datePickerFormatter2, modifier3, j2, i2, i3, (Composer) obj, ((Integer) obj2).intValue());
                    }
                });
            }
        }
        i4 |= 3072;
        modifier2 = modifier;
        if ((i2 & 24576) == 0) {
            if ((i3 & 16) == 0) {
                headlineContentColor = j;
                if (composerStartRestartGroup.changed(headlineContentColor)) {
                }
                i4 |= i8;
            } else {
                headlineContentColor = j;
            }
            i4 |= i8;
        } else {
            headlineContentColor = j;
        }
        if ((196608 & i2) == 0) {
            if (composerStartRestartGroup.changed(this)) {
                i6 = 131072;
            } else {
                i6 = 65536;
            }
            i4 |= i6;
        }
        if ((74899 & i4) != 74898) {
            z = true;
        } else {
            z = false;
        }
        if (composerStartRestartGroup.shouldExecute(z, i4 & 1)) {
            composerStartRestartGroup.startDefaults();
            ComposerKt.sourceInformation(composerStartRestartGroup, "698@33867L8");
            if ((i2 & 1) != 0) {
                if (i7 != 0) {
                    companion = Modifier.INSTANCE;
                } else {
                    companion = modifier2;
                }
                if ((i3 & 16) != 0) {
                    headlineContentColor = colors(composerStartRestartGroup, (i4 >> 15) & 14).getHeadlineContentColor();
                    i4 &= -57345;
                }
                i5 = i4;
                j3 = headlineContentColor;
                modifier4 = companion;
            } else {
                if (i7 != 0) {
                    companion = Modifier.INSTANCE;
                } else {
                    companion = modifier2;
                }
                if ((i3 & 16) != 0) {
                    headlineContentColor = colors(composerStartRestartGroup, (i4 >> 15) & 14).getHeadlineContentColor();
                    i4 &= -57345;
                }
                i5 = i4;
                j3 = headlineContentColor;
                modifier4 = companion;
            }
            composerStartRestartGroup.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1913724796, i5, -1, "androidx.compose.material3.DatePickerDefaults.DatePickerHeadline (DatePicker.kt:699)");
            }
            Locale localeDefaultLocale2 = CalendarLocale_androidKt.defaultLocale(composerStartRestartGroup, 0);
            date$default = DatePickerFormatter.formatDate$default(datePickerFormatter, l2, localeDefaultLocale2, false, 4, null);
            datePickerFormatter2 = datePickerFormatter;
            l2 = l2;
            date = datePickerFormatter2.formatDate(l2, localeDefaultLocale2, true);
            strM5086getString2EP1pXo = "";
            if (date == null) {
                composerStartRestartGroup.startReplaceGroup(843541746);
                composerStartRestartGroup.endReplaceGroup();
            } else {
                composerStartRestartGroup.startReplaceGroup(380170059);
                ComposerKt.sourceInformation(composerStartRestartGroup, "");
                if (DisplayMode.m3272equalsimpl0(i, DisplayMode.INSTANCE.m3277getPickerjFl4v0())) {
                    composerStartRestartGroup.startReplaceGroup(843549359);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "710@34357L51");
                    Strings.Companion companion8 = Strings.INSTANCE;
                    date = Strings_androidKt.m5086getString2EP1pXo(Strings.m5002constructorimpl(R.string.m3c_date_picker_no_selection_description), composerStartRestartGroup, 0);
                    composerStartRestartGroup.endReplaceGroup();
                } else if (DisplayMode.m3272equalsimpl0(i, DisplayMode.INSTANCE.m3276getInputjFl4v0())) {
                    composerStartRestartGroup.startReplaceGroup(843552330);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "711@34450L46");
                    Strings.Companion companion9 = Strings.INSTANCE;
                    date = Strings_androidKt.m5086getString2EP1pXo(Strings.m5002constructorimpl(R.string.m3c_date_input_no_input_description), composerStartRestartGroup, 0);
                    composerStartRestartGroup.endReplaceGroup();
                } else {
                    composerStartRestartGroup.startReplaceGroup(380391490);
                    composerStartRestartGroup.endReplaceGroup();
                    date = "";
                }
                composerStartRestartGroup.endReplaceGroup();
            }
            if (date$default == null) {
                composerStartRestartGroup.startReplaceGroup(843556896);
                composerStartRestartGroup.endReplaceGroup();
            } else {
                composerStartRestartGroup.startReplaceGroup(380491715);
                ComposerKt.sourceInformation(composerStartRestartGroup, "");
                if (DisplayMode.m3272equalsimpl0(i, DisplayMode.INSTANCE.m3277getPickerjFl4v0())) {
                    composerStartRestartGroup.startReplaceGroup(843559745);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "718@34682L37");
                    Strings.Companion companion10 = Strings.INSTANCE;
                    date$default = Strings_androidKt.m5086getString2EP1pXo(Strings.m5002constructorimpl(R.string.m3c_date_picker_headline), composerStartRestartGroup, 0);
                    composerStartRestartGroup.endReplaceGroup();
                } else if (DisplayMode.m3272equalsimpl0(i, DisplayMode.INSTANCE.m3276getInputjFl4v0())) {
                    composerStartRestartGroup.startReplaceGroup(843562272);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "719@34761L36");
                    Strings.Companion companion11 = Strings.INSTANCE;
                    date$default = Strings_androidKt.m5086getString2EP1pXo(Strings.m5002constructorimpl(R.string.m3c_date_input_headline), composerStartRestartGroup, 0);
                    composerStartRestartGroup.endReplaceGroup();
                } else {
                    composerStartRestartGroup.startReplaceGroup(380690082);
                    composerStartRestartGroup.endReplaceGroup();
                    date$default = "";
                }
                composerStartRestartGroup.endReplaceGroup();
            }
            if (DisplayMode.m3272equalsimpl0(i, DisplayMode.INSTANCE.m3277getPickerjFl4v0())) {
                composerStartRestartGroup.startReplaceGroup(843569932);
                ComposerKt.sourceInformation(composerStartRestartGroup, "726@35000L48");
                Strings.Companion companion12 = Strings.INSTANCE;
                strM5086getString2EP1pXo = Strings_androidKt.m5086getString2EP1pXo(Strings.m5002constructorimpl(R.string.m3c_date_picker_headline_description), composerStartRestartGroup, 0);
                composerStartRestartGroup.endReplaceGroup();
            } else if (DisplayMode.m3272equalsimpl0(i, DisplayMode.INSTANCE.m3276getInputjFl4v0())) {
                composerStartRestartGroup.startReplaceGroup(843572811);
                ComposerKt.sourceInformation(composerStartRestartGroup, "727@35090L47");
                Strings.Companion companion13 = Strings.INSTANCE;
                strM5086getString2EP1pXo = Strings_androidKt.m5086getString2EP1pXo(Strings.m5002constructorimpl(R.string.m3c_date_input_headline_description), composerStartRestartGroup, 0);
                composerStartRestartGroup.endReplaceGroup();
            } else {
                composerStartRestartGroup.startReplaceGroup(381027362);
                composerStartRestartGroup.endReplaceGroup();
            }
            str = String.format(strM5086getString2EP1pXo, Arrays.copyOf(new Object[]{date}, 1));
            Intrinsics.checkNotNullExpressionValue(str, "format(...)");
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 843581155, "CC(remember):DatePicker.kt#9igjgp");
            zChanged = composerStartRestartGroup.changed(str);
            objRememberedValue = composerStartRestartGroup.rememberedValue();
            if (!zChanged) {
                objRememberedValue = new Function1() { // from class: androidx.compose.material3.DatePickerDefaults$$ExternalSyntheticLambda0
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return DatePickerDefaults.DatePickerHeadline_ISIPfiY$lambda$0$0(str, (SemanticsPropertyReceiver) obj);
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
            } else {
                objRememberedValue = new Function1() { // from class: androidx.compose.material3.DatePickerDefaults$$ExternalSyntheticLambda0
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return DatePickerDefaults.DatePickerHeadline_ISIPfiY$lambda$0$0(str, (SemanticsPropertyReceiver) obj);
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
            }
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            composer2 = composerStartRestartGroup;
            Modifier modifier6 = modifier4;
            TextKt.m4494TextNvy7gAk(date$default, SemanticsModifierKt.semantics$default(modifier4, false, (Function1) objRememberedValue, 1, null), j3, null, 0L, null, null, null, 0L, null, null, 0L, 0, false, 1, 0, null, null, composer2, (i5 >> 6) & 896, 24576, 245752);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            modifier3 = modifier6;
            j2 = j3;
        } else {
            composer2 = composerStartRestartGroup;
            composer2.skipToGroupEnd();
            modifier3 = modifier2;
            j2 = headlineContentColor;
        }
        scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.DatePickerDefaults$$ExternalSyntheticLambda1
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return DatePickerDefaults.DatePickerHeadline_ISIPfiY$lambda$1(this.f$0, l2, i, datePickerFormatter2, modifier3, j2, i2, i3, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit DatePickerHeadline_ISIPfiY$lambda$0$0(String str, SemanticsPropertyReceiver semanticsPropertyReceiver) {
        SemanticsPropertiesKt.m8850setLiveRegionhR3wRGc(semanticsPropertyReceiver, LiveRegionMode.INSTANCE.m8824getPolite0phEisY());
        SemanticsPropertiesKt.setContentDescription(semanticsPropertyReceiver, str);
        return Unit.INSTANCE;
    }

    public final FlingBehavior rememberSnapFlingBehavior$material3(LazyListState lazyListState, DecayAnimationSpec<Float> decayAnimationSpec, Composer composer, int i, int i2) {
        ComposerKt.sourceInformationMarkerStart(composer, -2036003494, "C(rememberSnapFlingBehavior)N(lazyListState,decayAnimationSpec)758@36197L7,759@36220L639:DatePicker.kt#uh7d8r");
        if ((i2 & 2) != 0) {
            decayAnimationSpec = DecayAnimationSpecKt.exponentialDecay$default(0.0f, 0.0f, 3, null);
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-2036003494, i, -1, "androidx.compose.material3.DatePickerDefaults.rememberSnapFlingBehavior (DatePicker.kt:756)");
        }
        FiniteAnimationSpec finiteAnimationSpecValue = MotionSchemeKt.value(MotionSchemeKeyTokens.DefaultEffects, composer, 6);
        ComposerKt.sourceInformationMarkerStart(composer, 1905741401, "CC(remember):DatePicker.kt#9igjgp");
        boolean zChanged = ((((i & 14) ^ 6) > 4 && composer.changed(lazyListState)) || (i & 6) == 4) | composer.changed(decayAnimationSpec);
        Object objRememberedValue = composer.rememberedValue();
        if (zChanged || objRememberedValue == Composer.INSTANCE.getEmpty()) {
            final SnapLayoutInfoProvider snapLayoutInfoProviderSnapLayoutInfoProvider$default = LazyListSnapLayoutInfoProviderKt.SnapLayoutInfoProvider$default(lazyListState, null, 2, null);
            objRememberedValue = SnapFlingBehaviorKt.snapFlingBehavior(new SnapLayoutInfoProvider() { // from class: androidx.compose.material3.DatePickerDefaults$rememberSnapFlingBehavior$1$snapLayoutInfoProvider$1
                @Override // androidx.compose.foundation.gestures.snapping.SnapLayoutInfoProvider
                public float calculateApproachOffset(float velocity, float decayOffset) {
                    return 0.0f;
                }

                @Override // androidx.compose.foundation.gestures.snapping.SnapLayoutInfoProvider
                public float calculateSnapOffset(float velocity) {
                    return snapLayoutInfoProviderSnapLayoutInfoProvider$default.calculateSnapOffset(velocity);
                }
            }, decayAnimationSpec, finiteAnimationSpecValue);
            composer.updateRememberedValue(objRememberedValue);
        }
        TargetedFlingBehavior targetedFlingBehavior = (TargetedFlingBehavior) objRememberedValue;
        ComposerKt.sourceInformationMarkerEnd(composer);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return targetedFlingBehavior;
    }

    public final IntRange getYearRange() {
        return YearRange;
    }

    /* JADX INFO: renamed from: getTonalElevation-D9Ej5fM, reason: not valid java name */
    public final float m3153getTonalElevationD9Ej5fM() {
        return TonalElevation;
    }

    public final Shape getShape(Composer composer, int i) {
        ComposerKt.sourceInformationMarkerStart(composer, 700927667, "C(<get-shape>)785@37239L5:DatePicker.kt#uh7d8r");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(700927667, i, -1, "androidx.compose.material3.DatePickerDefaults.<get-shape> (DatePicker.kt:785)");
        }
        Shape value = ShapesKt.getValue(DatePickerModalTokens.INSTANCE.getContainerShape(), composer, 6);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return value;
    }

    public final SelectableDates getAllDates() {
        return AllDates;
    }
}
