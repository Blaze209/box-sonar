package androidx.compose.material3;

import androidx.compose.animation.CrossfadeKt;
import androidx.compose.animation.core.FiniteAnimationSpec;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.ColumnKt;
import androidx.compose.foundation.layout.ColumnScopeInstance;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.foundation.lazy.LazyDslKt;
import androidx.compose.foundation.lazy.LazyItemScope;
import androidx.compose.foundation.lazy.LazyListScope;
import androidx.compose.foundation.lazy.LazyListState;
import androidx.compose.foundation.lazy.LazyListStateKt;
import androidx.compose.material3.internal.CalendarDate;
import androidx.compose.material3.internal.CalendarModel;
import androidx.compose.material3.internal.CalendarModel_androidKt;
import androidx.compose.material3.internal.CalendarMonth;
import androidx.compose.material3.internal.Strings;
import androidx.compose.material3.internal.Strings_androidKt;
import androidx.compose.material3.tokens.DatePickerModalTokens;
import androidx.compose.material3.tokens.MotionSchemeKeyTokens;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambda;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.runtime.saveable.RememberSaveableKt;
import androidx.compose.runtime.saveable.Saver;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.focus.FocusRequester;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.Size;
import androidx.compose.ui.graphics.drawscope.ContentDrawScope;
import androidx.compose.ui.graphics.drawscope.DrawScope;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.semantics.CustomAccessibilityAction;
import androidx.compose.ui.semantics.ScrollAxisRange;
import androidx.compose.ui.semantics.SemanticsModifierKt;
import androidx.compose.ui.semantics.SemanticsPropertiesKt;
import androidx.compose.ui.semantics.SemanticsPropertyReceiver;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.IntOffset;
import androidx.compose.ui.unit.LayoutDirection;
import androidx.media3.common.C;
import androidx.profileinstaller.ProfileVerifier;
import com.microsoft.identity.common.java.cache.CacheKeyValueDelegate;
import external.sdk.pendo.io.mozilla.javascript.Token;
import java.util.List;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntRange;
import kotlin.ranges.RangesKt;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: compiled from: DateRangePicker.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(d1 = {"\u0000Â\u0001\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\u001aw\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\u0015\b\u0002\u0010\n\u001a\u000f\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u000b¢\u0006\u0002\b\f2\u0015\b\u0002\u0010\r\u001a\u000f\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u000b¢\u0006\u0002\b\f2\b\b\u0002\u0010\u000e\u001a\u00020\u000f2\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u0011H\u0007¢\u0006\u0002\u0010\u0012\u001aQ\u0010\u0013\u001a\u00020\u00032\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u00152\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u00152\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u00152\b\b\u0002\u0010\u0018\u001a\u00020\u00192\b\b\u0002\u0010\u001a\u001a\u00020\u001b2\b\b\u0002\u0010\u001c\u001a\u00020\u001dH\u0007¢\u0006\u0004\b\u001e\u0010\u001f\u001a[\u0010 \u001a\u00020\u00032\n\u0010!\u001a\u00060\"j\u0002`#2\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u00152\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u00152\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u00152\b\b\u0002\u0010\u0018\u001a\u00020\u00192\b\b\u0002\u0010\u001a\u001a\u00020\u001b2\b\b\u0002\u0010\u001c\u001a\u00020\u001d¢\u0006\u0004\b$\u0010%\u001aÄ\u0001\u0010&\u001a\u00020\u00012\b\u0010'\u001a\u0004\u0018\u00010\u00152\b\u0010(\u001a\u0004\u0018\u00010\u00152\u0006\u0010)\u001a\u00020\u00152\u0006\u0010*\u001a\u00020\u001b2:\u0010+\u001a6\u0012\u0015\u0012\u0013\u0018\u00010\u0015¢\u0006\f\b-\u0012\b\b.\u0012\u0004\b\b(/\u0012\u0015\u0012\u0013\u0018\u00010\u0015¢\u0006\f\b-\u0012\b\b.\u0012\u0004\b\b(0\u0012\u0004\u0012\u00020\u00010,2!\u00101\u001a\u001d\u0012\u0013\u0012\u00110\u0015¢\u0006\f\b-\u0012\b\b.\u0012\u0004\b\b(3\u0012\u0004\u0012\u00020\u0001022\u0006\u00104\u001a\u0002052\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\b\u001a\u00020\t2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011H\u0003¢\u0006\u0004\b6\u00107\u001a°\u0001\u00108\u001a\u00020\u00012\b\u0010'\u001a\u0004\u0018\u00010\u00152\b\u0010(\u001a\u0004\u0018\u00010\u00152\u0006\u0010)\u001a\u00020\u00152:\u0010+\u001a6\u0012\u0015\u0012\u0013\u0018\u00010\u0015¢\u0006\f\b-\u0012\b\b.\u0012\u0004\b\b(/\u0012\u0015\u0012\u0013\u0018\u00010\u0015¢\u0006\f\b-\u0012\b\b.\u0012\u0004\b\b(0\u0012\u0004\u0012\u00020\u00010,2!\u00101\u001a\u001d\u0012\u0013\u0012\u00110\u0015¢\u0006\f\b-\u0012\b\b.\u0012\u0004\b\b(3\u0012\u0004\u0012\u00020\u0001022\u0006\u00104\u001a\u0002052\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\b\u001a\u00020\tH\u0003¢\u0006\u0002\u00109\u001a°\u0001\u0010:\u001a\u00020\u00012\u0006\u0010;\u001a\u00020<2\b\u0010'\u001a\u0004\u0018\u00010\u00152\b\u0010(\u001a\u0004\u0018\u00010\u00152:\u0010+\u001a6\u0012\u0015\u0012\u0013\u0018\u00010\u0015¢\u0006\f\b-\u0012\b\b.\u0012\u0004\b\b(/\u0012\u0015\u0012\u0013\u0018\u00010\u0015¢\u0006\f\b-\u0012\b\b.\u0012\u0004\b\b(0\u0012\u0004\u0012\u00020\u00010,2!\u00101\u001a\u001d\u0012\u0013\u0012\u00110\u0015¢\u0006\f\b-\u0012\b\b.\u0012\u0004\b\b(3\u0012\u0004\u0012\u00020\u0001022\u0006\u00104\u001a\u0002052\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\b\u001a\u00020\tH\u0003¢\u0006\u0002\u0010=\u001ae\u0010>\u001a\u00020\u00012\u0006\u0010?\u001a\u00020\u00152\b\u0010@\u001a\u0004\u0018\u00010\u00152\b\u0010A\u001a\u0004\u0018\u00010\u00152:\u0010+\u001a6\u0012\u0015\u0012\u0013\u0018\u00010\u0015¢\u0006\f\b-\u0012\b\b.\u0012\u0004\b\b(/\u0012\u0015\u0012\u0013\u0018\u00010\u0015¢\u0006\f\b-\u0012\b\b.\u0012\u0004\b\b(0\u0012\u0004\u0012\u00020\u00010,H\u0002¢\u0006\u0002\u0010B\u001a#\u0010G\u001a\u00020\u0001*\u00020H2\u0006\u0010I\u001a\u00020J2\u0006\u0010K\u001a\u00020LH\u0000¢\u0006\u0004\bM\u0010N\u001a.\u0010O\u001a\b\u0012\u0004\u0012\u00020Q0P2\u0006\u0010\u0002\u001a\u00020<2\u0006\u0010R\u001a\u00020S2\u0006\u0010T\u001a\u00020U2\u0006\u0010V\u001a\u00020UH\u0002\"\u0014\u0010C\u001a\u00020DX\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\bE\u0010F\"\u000e\u0010W\u001a\u00020DX\u0082\u0004¢\u0006\u0002\n\u0000\"\u000e\u0010X\u001a\u00020DX\u0082\u0004¢\u0006\u0002\n\u0000\"\u0010\u0010Y\u001a\u00020ZX\u0082\u0004¢\u0006\u0004\n\u0002\u0010[¨\u0006\\"}, d2 = {"DateRangePicker", "", "state", "Landroidx/compose/material3/DateRangePickerState;", "modifier", "Landroidx/compose/ui/Modifier;", "dateFormatter", "Landroidx/compose/material3/DatePickerFormatter;", "colors", "Landroidx/compose/material3/DatePickerColors;", "title", "Lkotlin/Function0;", "Landroidx/compose/runtime/Composable;", "headline", "showModeToggle", "", "focusRequester", "Landroidx/compose/ui/focus/FocusRequester;", "(Landroidx/compose/material3/DateRangePickerState;Landroidx/compose/ui/Modifier;Landroidx/compose/material3/DatePickerFormatter;Landroidx/compose/material3/DatePickerColors;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;ZLandroidx/compose/ui/focus/FocusRequester;Landroidx/compose/runtime/Composer;II)V", "rememberDateRangePickerState", "initialSelectedStartDateMillis", "", "initialSelectedEndDateMillis", "initialDisplayedMonthMillis", "yearRange", "Lkotlin/ranges/IntRange;", "initialDisplayMode", "Landroidx/compose/material3/DisplayMode;", "selectableDates", "Landroidx/compose/material3/SelectableDates;", "rememberDateRangePickerState-IlFM19s", "(Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/Long;Lkotlin/ranges/IntRange;ILandroidx/compose/material3/SelectableDates;Landroidx/compose/runtime/Composer;II)Landroidx/compose/material3/DateRangePickerState;", "DateRangePickerState", "locale", "Ljava/util/Locale;", "Landroidx/compose/material3/CalendarLocale;", "DateRangePickerState-HVP43zI", "(Ljava/util/Locale;Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/Long;Lkotlin/ranges/IntRange;ILandroidx/compose/material3/SelectableDates;)Landroidx/compose/material3/DateRangePickerState;", "SwitchableDateEntryContent", "selectedStartDateMillis", "selectedEndDateMillis", "displayedMonthMillis", "displayMode", "onDatesSelectionChange", "Lkotlin/Function2;", "Lkotlin/ParameterName;", "name", "startDateMillis", "endDateMillis", "onDisplayedMonthChange", "Lkotlin/Function1;", "monthInMillis", "calendarModel", "Landroidx/compose/material3/internal/CalendarModel;", "SwitchableDateEntryContent-eVtQiho", "(Ljava/lang/Long;Ljava/lang/Long;JILkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function1;Landroidx/compose/material3/internal/CalendarModel;Lkotlin/ranges/IntRange;Landroidx/compose/material3/DatePickerFormatter;Landroidx/compose/material3/SelectableDates;Landroidx/compose/material3/DatePickerColors;Landroidx/compose/ui/focus/FocusRequester;Landroidx/compose/runtime/Composer;II)V", "DateRangePickerContent", "(Ljava/lang/Long;Ljava/lang/Long;JLkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function1;Landroidx/compose/material3/internal/CalendarModel;Lkotlin/ranges/IntRange;Landroidx/compose/material3/DatePickerFormatter;Landroidx/compose/material3/SelectableDates;Landroidx/compose/material3/DatePickerColors;Landroidx/compose/runtime/Composer;I)V", "VerticalMonthsList", "lazyListState", "Landroidx/compose/foundation/lazy/LazyListState;", "(Landroidx/compose/foundation/lazy/LazyListState;Ljava/lang/Long;Ljava/lang/Long;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function1;Landroidx/compose/material3/internal/CalendarModel;Lkotlin/ranges/IntRange;Landroidx/compose/material3/DatePickerFormatter;Landroidx/compose/material3/SelectableDates;Landroidx/compose/material3/DatePickerColors;Landroidx/compose/runtime/Composer;I)V", "updateDateSelection", "dateInMillis", "currentStartDateMillis", "currentEndDateMillis", "(JLjava/lang/Long;Ljava/lang/Long;Lkotlin/jvm/functions/Function2;)V", "CalendarMonthSubheadPadding", "Landroidx/compose/foundation/layout/PaddingValues;", "getCalendarMonthSubheadPadding", "()Landroidx/compose/foundation/layout/PaddingValues;", "drawRangeBackground", "Landroidx/compose/ui/graphics/drawscope/ContentDrawScope;", "selectedRangeInfo", "Landroidx/compose/material3/SelectedRangeInfo;", "color", "Landroidx/compose/ui/graphics/Color;", "drawRangeBackground-mxwnekA", "(Landroidx/compose/ui/graphics/drawscope/ContentDrawScope;Landroidx/compose/material3/SelectedRangeInfo;J)V", "customScrollActions", "", "Landroidx/compose/ui/semantics/CustomAccessibilityAction;", "coroutineScope", "Lkotlinx/coroutines/CoroutineScope;", "scrollUpLabel", "", "scrollDownLabel", "DateRangePickerTitlePadding", "DateRangePickerHeadlinePadding", "HeaderHeightOffset", "Landroidx/compose/ui/unit/Dp;", "F", "material3"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class DateRangePickerKt {
    private static final PaddingValues DateRangePickerHeadlinePadding;
    private static final PaddingValues DateRangePickerTitlePadding;
    private static final PaddingValues CalendarMonthSubheadPadding = PaddingKt.m1215PaddingValuesa9UjIt4$default(Dp.m9687constructorimpl(24), Dp.m9687constructorimpl(20), 0.0f, Dp.m9687constructorimpl(8), 4, null);
    private static final float HeaderHeightOffset = Dp.m9687constructorimpl(60);

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit DateRangePicker$lambda$7(DateRangePickerState dateRangePickerState, Modifier modifier, DatePickerFormatter datePickerFormatter, DatePickerColors datePickerColors, Function2 function2, Function2 function3, boolean z, FocusRequester focusRequester, int i, int i2, Composer composer, int i3) {
        DateRangePicker(dateRangePickerState, modifier, datePickerFormatter, datePickerColors, function2, function3, z, focusRequester, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit DateRangePickerContent$lambda$2(Long l, Long l2, long j, Function2 function2, Function1 function1, CalendarModel calendarModel, IntRange intRange, DatePickerFormatter datePickerFormatter, SelectableDates selectableDates, DatePickerColors datePickerColors, int i, Composer composer, int i2) {
        DateRangePickerContent(l, l2, j, function2, function1, calendarModel, intRange, datePickerFormatter, selectableDates, datePickerColors, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit SwitchableDateEntryContent_eVtQiho$lambda$2(Long l, Long l2, long j, int i, Function2 function2, Function1 function1, CalendarModel calendarModel, IntRange intRange, DatePickerFormatter datePickerFormatter, SelectableDates selectableDates, DatePickerColors datePickerColors, FocusRequester focusRequester, int i2, int i3, Composer composer, int i4) {
        m3229SwitchableDateEntryContenteVtQiho(l, l2, j, i, function2, function1, calendarModel, intRange, datePickerFormatter, selectableDates, datePickerColors, focusRequester, composer, RecomposeScopeImplKt.updateChangedFlags(i2 | 1), RecomposeScopeImplKt.updateChangedFlags(i3));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final float VerticalMonthsList$lambda$1$1$0$0() {
        return 0.0f;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final float VerticalMonthsList$lambda$1$1$0$1() {
        return 0.0f;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit VerticalMonthsList$lambda$3(LazyListState lazyListState, Long l, Long l2, Function2 function2, Function1 function1, CalendarModel calendarModel, IntRange intRange, DatePickerFormatter datePickerFormatter, SelectableDates selectableDates, DatePickerColors datePickerColors, int i, Composer composer, int i2) {
        VerticalMonthsList(lazyListState, l, l2, function2, function1, calendarModel, intRange, datePickerFormatter, selectableDates, datePickerColors, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit DateRangePicker$lambda$1(DateRangePickerState dateRangePickerState, DatePickerColors datePickerColors, Composer composer, int i) {
        ComposerKt.sourceInformation(composer, "C105@5060L199:DateRangePicker.kt#uh7d8r");
        if (!composer.shouldExecute((i & 3) != 2, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-803011924, i, -1, "androidx.compose.material3.DateRangePicker.<anonymous> (DateRangePicker.kt:105)");
            }
            DateRangePickerDefaults.INSTANCE.m3220DateRangePickerTitleFNtVw6o(dateRangePickerState.mo3232getDisplayModejFl4v0(), PaddingKt.padding(Modifier.INSTANCE, DateRangePickerTitlePadding), datePickerColors.getTitleContentColor(), composer, 3120, 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit DateRangePicker$lambda$2(DateRangePickerState dateRangePickerState, DatePickerFormatter datePickerFormatter, DatePickerColors datePickerColors, Composer composer, int i) {
        ComposerKt.sourceInformation(composer, "C112@5343L369:DateRangePicker.kt#uh7d8r");
        if (!composer.shouldExecute((i & 3) != 2, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-331385278, i, -1, "androidx.compose.material3.DateRangePicker.<anonymous> (DateRangePicker.kt:112)");
            }
            DateRangePickerDefaults.INSTANCE.m3219DateRangePickerHeadlineqS89cEg(dateRangePickerState.getSelectedStartDateMillis(), dateRangePickerState.getSelectedEndDateMillis(), dateRangePickerState.mo3232getDisplayModejFl4v0(), datePickerFormatter, PaddingKt.padding(Modifier.INSTANCE, DateRangePickerHeadlinePadding), datePickerColors.getHeadlineContentColor(), composer, 1597440, 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX WARN: Code duplicated, block: B:105:0x0135 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:106:0x0137  */
    /* JADX WARN: Code duplicated, block: B:109:0x0140  */
    /* JADX WARN: Code duplicated, block: B:111:0x0152  */
    /* JADX WARN: Code duplicated, block: B:113:0x016d  */
    /* JADX WARN: Code duplicated, block: B:116:0x0173  */
    /* JADX WARN: Code duplicated, block: B:117:0x017d  */
    /* JADX WARN: Code duplicated, block: B:119:0x0180  */
    /* JADX WARN: Code duplicated, block: B:120:0x0199  */
    /* JADX WARN: Code duplicated, block: B:122:0x01a0  */
    /* JADX WARN: Code duplicated, block: B:124:0x01b2  */
    /* JADX WARN: Code duplicated, block: B:126:0x01b5  */
    /* JADX WARN: Code duplicated, block: B:128:0x01c7  */
    /* JADX WARN: Code duplicated, block: B:130:0x01dd  */
    /* JADX WARN: Code duplicated, block: B:133:0x01ee  */
    /* JADX WARN: Code duplicated, block: B:136:0x020b  */
    /* JADX WARN: Code duplicated, block: B:138:0x0213  */
    /* JADX WARN: Code duplicated, block: B:140:0x0217  */
    /* JADX WARN: Code duplicated, block: B:141:0x021f  */
    /* JADX WARN: Code duplicated, block: B:145:0x0232  */
    /* JADX WARN: Code duplicated, block: B:146:0x0254  */
    /* JADX WARN: Code duplicated, block: B:149:0x02be  */
    /* JADX WARN: Code duplicated, block: B:151:0x02c8  */
    /* JADX WARN: Code duplicated, block: B:154:0x02dc  */
    /* JADX WARN: Code duplicated, block: B:156:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:23:0x0046  */
    /* JADX WARN: Code duplicated, block: B:25:0x004a  */
    /* JADX WARN: Code duplicated, block: B:27:0x004e  */
    /* JADX WARN: Code duplicated, block: B:28:0x0053  */
    /* JADX WARN: Code duplicated, block: B:30:0x0059  */
    /* JADX WARN: Code duplicated, block: B:31:0x005c  */
    /* JADX WARN: Code duplicated, block: B:35:0x0063  */
    /* JADX WARN: Code duplicated, block: B:37:0x0067  */
    /* JADX WARN: Code duplicated, block: B:39:0x006f  */
    /* JADX WARN: Code duplicated, block: B:40:0x0072  */
    /* JADX WARN: Code duplicated, block: B:43:0x0078  */
    /* JADX WARN: Code duplicated, block: B:46:0x007e  */
    /* JADX WARN: Code duplicated, block: B:47:0x0081  */
    /* JADX WARN: Code duplicated, block: B:49:0x0085  */
    /* JADX WARN: Code duplicated, block: B:51:0x008d  */
    /* JADX WARN: Code duplicated, block: B:52:0x0090  */
    /* JADX WARN: Code duplicated, block: B:57:0x009c  */
    /* JADX WARN: Code duplicated, block: B:58:0x009e  */
    /* JADX WARN: Code duplicated, block: B:60:0x00a1  */
    /* JADX WARN: Code duplicated, block: B:62:0x00a9  */
    /* JADX WARN: Code duplicated, block: B:63:0x00ac  */
    /* JADX WARN: Code duplicated, block: B:68:0x00b8  */
    /* JADX WARN: Code duplicated, block: B:69:0x00ba  */
    /* JADX WARN: Code duplicated, block: B:71:0x00bd  */
    /* JADX WARN: Code duplicated, block: B:73:0x00c5  */
    /* JADX WARN: Code duplicated, block: B:74:0x00c8  */
    /* JADX WARN: Code duplicated, block: B:79:0x00d5  */
    /* JADX WARN: Code duplicated, block: B:80:0x00da  */
    /* JADX WARN: Code duplicated, block: B:82:0x00e0  */
    /* JADX WARN: Code duplicated, block: B:84:0x00e6  */
    /* JADX WARN: Code duplicated, block: B:85:0x00e9  */
    /* JADX WARN: Code duplicated, block: B:89:0x00fb  */
    /* JADX WARN: Code duplicated, block: B:90:0x00fd  */
    /* JADX WARN: Code duplicated, block: B:93:0x0106  */
    /* JADX WARN: Code duplicated, block: B:95:0x0114  */
    /* JADX WARN: Multi-variable type inference failed */
    public static final void DateRangePicker(final DateRangePickerState dateRangePickerState, Modifier modifier, DatePickerFormatter datePickerFormatter, DatePickerColors datePickerColors, Function2<? super Composer, ? super Integer, Unit> function2, Function2<? super Composer, ? super Integer, Unit> function3, boolean z, FocusRequester focusRequester, Composer composer, final int i, final int i2) {
        int i3;
        Modifier modifier2;
        DatePickerColors datePickerColors2;
        int i4;
        Function2<? super Composer, ? super Integer, Unit> function2RememberComposableLambda;
        int i5;
        int i6;
        Function2<? super Composer, ? super Integer, Unit> function2RememberComposableLambda2;
        int i7;
        int i8;
        boolean z2;
        int i9;
        int i10;
        int i11;
        boolean z3;
        Composer composer2;
        final DatePickerFormatter datePickerFormatter2;
        final FocusRequester focusRequester2;
        final Modifier modifier3;
        final DatePickerColors datePickerColors3;
        final Function2<? super Composer, ? super Integer, Unit> function4;
        final boolean z4;
        final Function2<? super Composer, ? super Integer, Unit> function5;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        final DatePickerFormatter datePickerFormatter3;
        final DatePickerColors datePickerColorsColors;
        boolean z5;
        int i12;
        Function2<? super Composer, ? super Integer, Unit> function6;
        boolean z6;
        final DatePickerColors datePickerColors4;
        Modifier modifier4;
        int i13;
        FocusRequester focusRequester3;
        Object objRememberedValue;
        Object objRememberedValue2;
        boolean zChanged;
        Object objRememberedValue3;
        CalendarModel calendarModelCreateCalendarModel;
        ComposableLambda composableLambdaRememberComposableLambda;
        int i14;
        boolean zChangedInstance;
        Composer composerStartRestartGroup = composer.startRestartGroup(1969726368);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(DateRangePicker)N(state,modifier,dateFormatter,colors,title,headline,showModeToggle,focusRequester)125@5861L207,149@6756L5,153@6912L1186,132@6073L2025:DateRangePicker.kt#uh7d8r");
        if ((i & 6) == 0) {
            i3 = (composerStartRestartGroup.changed(dateRangePickerState) ? 4 : 2) | i;
        } else {
            i3 = i;
        }
        int i15 = i2 & 2;
        if (i15 == 0) {
            if ((i & 48) == 0) {
                modifier2 = modifier;
                i3 |= composerStartRestartGroup.changed(modifier2) ? 32 : 16;
            }
            if ((i & 384) == 0) {
                if ((i2 & 4) != 0) {
                    i14 = 128;
                } else {
                    if ((i & 512) == 0) {
                        zChangedInstance = composerStartRestartGroup.changed(datePickerFormatter);
                    } else {
                        zChangedInstance = composerStartRestartGroup.changedInstance(datePickerFormatter);
                    }
                    if (zChangedInstance) {
                        i14 = 256;
                    } else {
                        i14 = 128;
                    }
                }
                i3 |= i14;
            }
            if ((i & 3072) == 0) {
                if ((i2 & 8) == 0) {
                    datePickerColors2 = datePickerColors;
                    int i16 = composerStartRestartGroup.changed(datePickerColors2) ? 2048 : 1024;
                    i3 |= i16;
                } else {
                    datePickerColors2 = datePickerColors;
                }
                i3 |= i16;
            } else {
                datePickerColors2 = datePickerColors;
            }
            i4 = i2 & 16;
            if (i4 != 0) {
                if ((i & 24576) == 0) {
                    function2RememberComposableLambda = function2;
                    if (composerStartRestartGroup.changedInstance(function2RememberComposableLambda)) {
                        i5 = 16384;
                    } else {
                        i5 = 8192;
                    }
                    i3 |= i5;
                }
                i6 = i2 & 32;
                if (i6 != 0) {
                    if ((196608 & i) == 0) {
                        function2RememberComposableLambda2 = function3;
                        if (composerStartRestartGroup.changedInstance(function2RememberComposableLambda2)) {
                            i7 = 131072;
                        } else {
                            i7 = 65536;
                        }
                        i3 |= i7;
                    }
                    i8 = i2 & 64;
                    if (i8 != 0) {
                        if ((1572864 & i) == 0) {
                            z2 = z;
                            if (composerStartRestartGroup.changed(z2)) {
                                i9 = 1048576;
                            } else {
                                i9 = 524288;
                            }
                            i3 |= i9;
                        }
                        i10 = i2 & 128;
                        if (i10 != 0) {
                            i3 |= 12582912;
                        } else if ((i & 12582912) == 0) {
                            if (composerStartRestartGroup.changed(focusRequester)) {
                                i11 = 8388608;
                            } else {
                                i11 = 4194304;
                            }
                            i3 |= i11;
                        }
                        if ((i3 & 4793491) != 4793490) {
                            z3 = true;
                        } else {
                            z3 = false;
                        }
                        if (composerStartRestartGroup.shouldExecute(z3, i3 & 1)) {
                            composerStartRestartGroup.startDefaults();
                            ComposerKt.sourceInformation(composerStartRestartGroup, "102@4878L47,103@4977L8,104@5026L239,111@5309L409,122@5794L29");
                            if ((i & 1) != 0 || composerStartRestartGroup.getDefaultsInvalid()) {
                                if (i15 != 0) {
                                    modifier2 = Modifier.INSTANCE;
                                }
                                if ((i2 & 4) != 0) {
                                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1173533681, "CC(remember):DateRangePicker.kt#9igjgp");
                                    objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                                    if (objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                                        objRememberedValue2 = DatePickerDefaults.dateFormatter$default(DatePickerDefaults.INSTANCE, null, null, null, 7, null);
                                        composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                                    }
                                    datePickerFormatter3 = (DatePickerFormatter) objRememberedValue2;
                                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                                    i3 &= -897;
                                } else {
                                    datePickerFormatter3 = datePickerFormatter;
                                }
                                if ((i2 & 8) != 0) {
                                    datePickerColorsColors = DatePickerDefaults.INSTANCE.colors(composerStartRestartGroup, 6);
                                    i3 &= -7169;
                                } else {
                                    datePickerColorsColors = datePickerColors2;
                                }
                                if (i4 != 0) {
                                    z5 = true;
                                    function2RememberComposableLambda = ComposableLambdaKt.rememberComposableLambda(-803011924, true, new Function2() { // from class: androidx.compose.material3.DateRangePickerKt$$ExternalSyntheticLambda13
                                        @Override // kotlin.jvm.functions.Function2
                                        public final Object invoke(Object obj, Object obj2) {
                                            return DateRangePickerKt.DateRangePicker$lambda$1(dateRangePickerState, datePickerColorsColors, (Composer) obj, ((Integer) obj2).intValue());
                                        }
                                    }, composerStartRestartGroup, 54);
                                    i12 = 54;
                                } else {
                                    z5 = true;
                                    i12 = 54;
                                }
                                if (i6 != 0) {
                                    function2RememberComposableLambda2 = ComposableLambdaKt.rememberComposableLambda(-331385278, z5, new Function2() { // from class: androidx.compose.material3.DateRangePickerKt$$ExternalSyntheticLambda14
                                        @Override // kotlin.jvm.functions.Function2
                                        public final Object invoke(Object obj, Object obj2) {
                                            return DateRangePickerKt.DateRangePicker$lambda$2(dateRangePickerState, datePickerFormatter3, datePickerColorsColors, (Composer) obj, ((Integer) obj2).intValue());
                                        }
                                    }, composerStartRestartGroup, i12);
                                }
                                if (i8 != 0) {
                                    z2 = true;
                                }
                                if (i10 != 0) {
                                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1173504387, "CC(remember):DateRangePicker.kt#9igjgp");
                                    objRememberedValue = composerStartRestartGroup.rememberedValue();
                                    if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                                        objRememberedValue = new FocusRequester();
                                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                                    }
                                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                                    DatePickerColors datePickerColors5 = datePickerColorsColors;
                                    focusRequester3 = (FocusRequester) objRememberedValue;
                                    z6 = z2;
                                    datePickerColors4 = datePickerColors5;
                                    function6 = function2RememberComposableLambda;
                                    modifier4 = modifier2;
                                    i13 = i3;
                                } else {
                                    function6 = function2RememberComposableLambda;
                                    z6 = z2;
                                    datePickerColors4 = datePickerColorsColors;
                                    modifier4 = modifier2;
                                    i13 = i3;
                                    focusRequester3 = focusRequester;
                                }
                            } else {
                                composerStartRestartGroup.skipToGroupEnd();
                                if ((i2 & 4) != 0) {
                                    i3 &= -897;
                                }
                                if ((i2 & 8) != 0) {
                                    i3 &= -7169;
                                }
                                datePickerFormatter3 = datePickerFormatter;
                                focusRequester3 = focusRequester;
                                function6 = function2RememberComposableLambda;
                                modifier4 = modifier2;
                                i13 = i3;
                                z6 = z2;
                                datePickerColors4 = datePickerColors2;
                            }
                            composerStartRestartGroup.endDefaults();
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(1969726368, i13, -1, "androidx.compose.material3.DateRangePicker (DateRangePicker.kt:123)");
                            }
                            Locale locale = dateRangePickerState.getLocale();
                            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1173502065, "CC(remember):DateRangePicker.kt#9igjgp");
                            zChanged = composerStartRestartGroup.changed(locale);
                            objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                            if (!zChanged || objRememberedValue3 == Composer.INSTANCE.getEmpty()) {
                                if (dateRangePickerState instanceof BaseDatePickerStateImpl) {
                                    calendarModelCreateCalendarModel = ((BaseDatePickerStateImpl) dateRangePickerState).getCalendarModel();
                                } else {
                                    calendarModelCreateCalendarModel = CalendarModel_androidKt.createCalendarModel(dateRangePickerState.getLocale());
                                }
                                objRememberedValue3 = calendarModelCreateCalendarModel;
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                            }
                            final CalendarModel calendarModel = (CalendarModel) objRememberedValue3;
                            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                            if (z6) {
                                composerStartRestartGroup.startReplaceGroup(-2018450762);
                                ComposerKt.sourceInformation(composerStartRestartGroup, "138@6251L364");
                                composableLambdaRememberComposableLambda = ComposableLambdaKt.rememberComposableLambda(1343236786, true, new Function2() { // from class: androidx.compose.material3.DateRangePickerKt$$ExternalSyntheticLambda15
                                    @Override // kotlin.jvm.functions.Function2
                                    public final Object invoke(Object obj, Object obj2) {
                                        return DateRangePickerKt.DateRangePicker$lambda$5(dateRangePickerState, datePickerColors4, (Composer) obj, ((Integer) obj2).intValue());
                                    }
                                }, composerStartRestartGroup, 54);
                                composerStartRestartGroup.endReplaceGroup();
                            } else {
                                composerStartRestartGroup.startReplaceGroup(-2018063138);
                                composerStartRestartGroup.endReplaceGroup();
                                composableLambdaRememberComposableLambda = null;
                            }
                            TextStyle value = TypographyKt.getValue(DatePickerModalTokens.INSTANCE.getRangeSelectionHeaderHeadlineFont(), composerStartRestartGroup, 6);
                            float fM9687constructorimpl = Dp.m9687constructorimpl(DatePickerModalTokens.INSTANCE.m5328getRangeSelectionHeaderContainerHeightD9Ej5fM() - HeaderHeightOffset);
                            final FocusRequester focusRequester4 = focusRequester3;
                            final DatePickerColors datePickerColors6 = datePickerColors4;
                            Function2 function7 = new Function2() { // from class: androidx.compose.material3.DateRangePickerKt$$ExternalSyntheticLambda16
                                @Override // kotlin.jvm.functions.Function2
                                public final Object invoke(Object obj, Object obj2) {
                                    return DateRangePickerKt.DateRangePicker$lambda$6(dateRangePickerState, calendarModel, datePickerFormatter3, datePickerColors6, focusRequester4, (Composer) obj, ((Integer) obj2).intValue());
                                }
                            };
                            DatePickerFormatter datePickerFormatter4 = datePickerFormatter3;
                            int i17 = i13 >> 9;
                            composer2 = composerStartRestartGroup;
                            DatePickerKt.m3177DateEntryContainerau3_HiA(modifier4, function6, function2RememberComposableLambda2, composableLambdaRememberComposableLambda, datePickerColors4, value, fM9687constructorimpl, ComposableLambdaKt.rememberComposableLambda(684885105, true, function7, composerStartRestartGroup, 54), composer2, ((i13 >> 3) & 14) | 14155776 | (i17 & 112) | (i17 & 896) | (57344 & (i13 << 3)));
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                            datePickerFormatter2 = datePickerFormatter4;
                            focusRequester2 = focusRequester4;
                            z4 = z6;
                            modifier3 = modifier4;
                            function4 = function6;
                            datePickerColors3 = datePickerColors4;
                        } else {
                            composer2 = composerStartRestartGroup;
                            composer2.skipToGroupEnd();
                            datePickerFormatter2 = datePickerFormatter;
                            focusRequester2 = focusRequester;
                            modifier3 = modifier2;
                            datePickerColors3 = datePickerColors2;
                            function4 = function2RememberComposableLambda;
                            z4 = z2;
                        }
                        function5 = function2RememberComposableLambda2;
                        scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                        if (scopeUpdateScopeEndRestartGroup != null) {
                            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.DateRangePickerKt$$ExternalSyntheticLambda17
                                @Override // kotlin.jvm.functions.Function2
                                public final Object invoke(Object obj, Object obj2) {
                                    return DateRangePickerKt.DateRangePicker$lambda$7(dateRangePickerState, modifier3, datePickerFormatter2, datePickerColors3, function4, function5, z4, focusRequester2, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                                }
                            });
                        }
                    }
                    i3 |= 1572864;
                    z2 = z;
                    i10 = i2 & 128;
                    if (i10 != 0) {
                        i3 |= 12582912;
                    } else if ((i & 12582912) == 0) {
                        if (composerStartRestartGroup.changed(focusRequester)) {
                            i11 = 8388608;
                        } else {
                            i11 = 4194304;
                        }
                        i3 |= i11;
                    }
                    if ((i3 & 4793491) != 4793490) {
                        z3 = true;
                    } else {
                        z3 = false;
                    }
                    if (composerStartRestartGroup.shouldExecute(z3, i3 & 1)) {
                        composerStartRestartGroup.startDefaults();
                        ComposerKt.sourceInformation(composerStartRestartGroup, "102@4878L47,103@4977L8,104@5026L239,111@5309L409,122@5794L29");
                        if ((i & 1) != 0) {
                            if (i15 != 0) {
                                modifier2 = Modifier.INSTANCE;
                            }
                            if ((i2 & 4) != 0) {
                                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1173533681, "CC(remember):DateRangePicker.kt#9igjgp");
                                objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                                if (objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                                    objRememberedValue2 = DatePickerDefaults.dateFormatter$default(DatePickerDefaults.INSTANCE, null, null, null, 7, null);
                                    composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                                }
                                datePickerFormatter3 = (DatePickerFormatter) objRememberedValue2;
                                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                                i3 &= -897;
                            } else {
                                datePickerFormatter3 = datePickerFormatter;
                            }
                            if ((i2 & 8) != 0) {
                                datePickerColorsColors = DatePickerDefaults.INSTANCE.colors(composerStartRestartGroup, 6);
                                i3 &= -7169;
                            } else {
                                datePickerColorsColors = datePickerColors2;
                            }
                            if (i4 != 0) {
                                z5 = true;
                                function2RememberComposableLambda = ComposableLambdaKt.rememberComposableLambda(-803011924, true, new Function2() { // from class: androidx.compose.material3.DateRangePickerKt$$ExternalSyntheticLambda13
                                    @Override // kotlin.jvm.functions.Function2
                                    public final Object invoke(Object obj, Object obj2) {
                                        return DateRangePickerKt.DateRangePicker$lambda$1(dateRangePickerState, datePickerColorsColors, (Composer) obj, ((Integer) obj2).intValue());
                                    }
                                }, composerStartRestartGroup, 54);
                                i12 = 54;
                            } else {
                                z5 = true;
                                i12 = 54;
                            }
                            if (i6 != 0) {
                                function2RememberComposableLambda2 = ComposableLambdaKt.rememberComposableLambda(-331385278, z5, new Function2() { // from class: androidx.compose.material3.DateRangePickerKt$$ExternalSyntheticLambda14
                                    @Override // kotlin.jvm.functions.Function2
                                    public final Object invoke(Object obj, Object obj2) {
                                        return DateRangePickerKt.DateRangePicker$lambda$2(dateRangePickerState, datePickerFormatter3, datePickerColorsColors, (Composer) obj, ((Integer) obj2).intValue());
                                    }
                                }, composerStartRestartGroup, i12);
                            }
                            if (i8 != 0) {
                                z2 = true;
                            }
                            if (i10 != 0) {
                                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1173504387, "CC(remember):DateRangePicker.kt#9igjgp");
                                objRememberedValue = composerStartRestartGroup.rememberedValue();
                                if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                                    objRememberedValue = new FocusRequester();
                                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                                }
                                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                                DatePickerColors datePickerColors7 = datePickerColorsColors;
                                focusRequester3 = (FocusRequester) objRememberedValue;
                                z6 = z2;
                                datePickerColors4 = datePickerColors7;
                                function6 = function2RememberComposableLambda;
                                modifier4 = modifier2;
                                i13 = i3;
                            } else {
                                function6 = function2RememberComposableLambda;
                                z6 = z2;
                                datePickerColors4 = datePickerColorsColors;
                                modifier4 = modifier2;
                                i13 = i3;
                                focusRequester3 = focusRequester;
                            }
                        } else {
                            if (i15 != 0) {
                                modifier2 = Modifier.INSTANCE;
                            }
                            if ((i2 & 4) != 0) {
                                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1173533681, "CC(remember):DateRangePicker.kt#9igjgp");
                                objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                                if (objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                                    objRememberedValue2 = DatePickerDefaults.dateFormatter$default(DatePickerDefaults.INSTANCE, null, null, null, 7, null);
                                    composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                                }
                                datePickerFormatter3 = (DatePickerFormatter) objRememberedValue2;
                                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                                i3 &= -897;
                            } else {
                                datePickerFormatter3 = datePickerFormatter;
                            }
                            if ((i2 & 8) != 0) {
                                datePickerColorsColors = DatePickerDefaults.INSTANCE.colors(composerStartRestartGroup, 6);
                                i3 &= -7169;
                            } else {
                                datePickerColorsColors = datePickerColors2;
                            }
                            if (i4 != 0) {
                                z5 = true;
                                function2RememberComposableLambda = ComposableLambdaKt.rememberComposableLambda(-803011924, true, new Function2() { // from class: androidx.compose.material3.DateRangePickerKt$$ExternalSyntheticLambda13
                                    @Override // kotlin.jvm.functions.Function2
                                    public final Object invoke(Object obj, Object obj2) {
                                        return DateRangePickerKt.DateRangePicker$lambda$1(dateRangePickerState, datePickerColorsColors, (Composer) obj, ((Integer) obj2).intValue());
                                    }
                                }, composerStartRestartGroup, 54);
                                i12 = 54;
                            } else {
                                z5 = true;
                                i12 = 54;
                            }
                            if (i6 != 0) {
                                function2RememberComposableLambda2 = ComposableLambdaKt.rememberComposableLambda(-331385278, z5, new Function2() { // from class: androidx.compose.material3.DateRangePickerKt$$ExternalSyntheticLambda14
                                    @Override // kotlin.jvm.functions.Function2
                                    public final Object invoke(Object obj, Object obj2) {
                                        return DateRangePickerKt.DateRangePicker$lambda$2(dateRangePickerState, datePickerFormatter3, datePickerColorsColors, (Composer) obj, ((Integer) obj2).intValue());
                                    }
                                }, composerStartRestartGroup, i12);
                            }
                            if (i8 != 0) {
                                z2 = true;
                            }
                            if (i10 != 0) {
                                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1173504387, "CC(remember):DateRangePicker.kt#9igjgp");
                                objRememberedValue = composerStartRestartGroup.rememberedValue();
                                if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                                    objRememberedValue = new FocusRequester();
                                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                                }
                                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                                DatePickerColors datePickerColors8 = datePickerColorsColors;
                                focusRequester3 = (FocusRequester) objRememberedValue;
                                z6 = z2;
                                datePickerColors4 = datePickerColors8;
                                function6 = function2RememberComposableLambda;
                                modifier4 = modifier2;
                                i13 = i3;
                            } else {
                                function6 = function2RememberComposableLambda;
                                z6 = z2;
                                datePickerColors4 = datePickerColorsColors;
                                modifier4 = modifier2;
                                i13 = i3;
                                focusRequester3 = focusRequester;
                            }
                        }
                        composerStartRestartGroup.endDefaults();
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(1969726368, i13, -1, "androidx.compose.material3.DateRangePicker (DateRangePicker.kt:123)");
                        }
                        Locale locale2 = dateRangePickerState.getLocale();
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1173502065, "CC(remember):DateRangePicker.kt#9igjgp");
                        zChanged = composerStartRestartGroup.changed(locale2);
                        objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                        if (!zChanged) {
                            if (dateRangePickerState instanceof BaseDatePickerStateImpl) {
                                calendarModelCreateCalendarModel = ((BaseDatePickerStateImpl) dateRangePickerState).getCalendarModel();
                            } else {
                                calendarModelCreateCalendarModel = CalendarModel_androidKt.createCalendarModel(dateRangePickerState.getLocale());
                            }
                            objRememberedValue3 = calendarModelCreateCalendarModel;
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                        } else {
                            if (dateRangePickerState instanceof BaseDatePickerStateImpl) {
                                calendarModelCreateCalendarModel = ((BaseDatePickerStateImpl) dateRangePickerState).getCalendarModel();
                            } else {
                                calendarModelCreateCalendarModel = CalendarModel_androidKt.createCalendarModel(dateRangePickerState.getLocale());
                            }
                            objRememberedValue3 = calendarModelCreateCalendarModel;
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                        }
                        final CalendarModel calendarModel2 = (CalendarModel) objRememberedValue3;
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        if (z6) {
                            composerStartRestartGroup.startReplaceGroup(-2018450762);
                            ComposerKt.sourceInformation(composerStartRestartGroup, "138@6251L364");
                            composableLambdaRememberComposableLambda = ComposableLambdaKt.rememberComposableLambda(1343236786, true, new Function2() { // from class: androidx.compose.material3.DateRangePickerKt$$ExternalSyntheticLambda15
                                @Override // kotlin.jvm.functions.Function2
                                public final Object invoke(Object obj, Object obj2) {
                                    return DateRangePickerKt.DateRangePicker$lambda$5(dateRangePickerState, datePickerColors4, (Composer) obj, ((Integer) obj2).intValue());
                                }
                            }, composerStartRestartGroup, 54);
                            composerStartRestartGroup.endReplaceGroup();
                        } else {
                            composerStartRestartGroup.startReplaceGroup(-2018063138);
                            composerStartRestartGroup.endReplaceGroup();
                            composableLambdaRememberComposableLambda = null;
                        }
                        TextStyle value2 = TypographyKt.getValue(DatePickerModalTokens.INSTANCE.getRangeSelectionHeaderHeadlineFont(), composerStartRestartGroup, 6);
                        float fM9687constructorimpl2 = Dp.m9687constructorimpl(DatePickerModalTokens.INSTANCE.m5328getRangeSelectionHeaderContainerHeightD9Ej5fM() - HeaderHeightOffset);
                        final FocusRequester focusRequester5 = focusRequester3;
                        final DatePickerColors datePickerColors9 = datePickerColors4;
                        Function2 function8 = new Function2() { // from class: androidx.compose.material3.DateRangePickerKt$$ExternalSyntheticLambda16
                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj, Object obj2) {
                                return DateRangePickerKt.DateRangePicker$lambda$6(dateRangePickerState, calendarModel2, datePickerFormatter3, datePickerColors9, focusRequester5, (Composer) obj, ((Integer) obj2).intValue());
                            }
                        };
                        DatePickerFormatter datePickerFormatter5 = datePickerFormatter3;
                        int i18 = i13 >> 9;
                        composer2 = composerStartRestartGroup;
                        DatePickerKt.m3177DateEntryContainerau3_HiA(modifier4, function6, function2RememberComposableLambda2, composableLambdaRememberComposableLambda, datePickerColors4, value2, fM9687constructorimpl2, ComposableLambdaKt.rememberComposableLambda(684885105, true, function8, composerStartRestartGroup, 54), composer2, ((i13 >> 3) & 14) | 14155776 | (i18 & 112) | (i18 & 896) | (57344 & (i13 << 3)));
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        datePickerFormatter2 = datePickerFormatter5;
                        focusRequester2 = focusRequester5;
                        z4 = z6;
                        modifier3 = modifier4;
                        function4 = function6;
                        datePickerColors3 = datePickerColors4;
                    } else {
                        composer2 = composerStartRestartGroup;
                        composer2.skipToGroupEnd();
                        datePickerFormatter2 = datePickerFormatter;
                        focusRequester2 = focusRequester;
                        modifier3 = modifier2;
                        datePickerColors3 = datePickerColors2;
                        function4 = function2RememberComposableLambda;
                        z4 = z2;
                    }
                    function5 = function2RememberComposableLambda2;
                    scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup != null) {
                        scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.DateRangePickerKt$$ExternalSyntheticLambda17
                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj, Object obj2) {
                                return DateRangePickerKt.DateRangePicker$lambda$7(dateRangePickerState, modifier3, datePickerFormatter2, datePickerColors3, function4, function5, z4, focusRequester2, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                            }
                        });
                    }
                }
                i3 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
                function2RememberComposableLambda2 = function3;
                i8 = i2 & 64;
                if (i8 != 0) {
                    if ((1572864 & i) == 0) {
                        z2 = z;
                        if (composerStartRestartGroup.changed(z2)) {
                            i9 = 1048576;
                        } else {
                            i9 = 524288;
                        }
                        i3 |= i9;
                    }
                    i10 = i2 & 128;
                    if (i10 != 0) {
                        i3 |= 12582912;
                    } else if ((i & 12582912) == 0) {
                        if (composerStartRestartGroup.changed(focusRequester)) {
                            i11 = 8388608;
                        } else {
                            i11 = 4194304;
                        }
                        i3 |= i11;
                    }
                    if ((i3 & 4793491) != 4793490) {
                        z3 = true;
                    } else {
                        z3 = false;
                    }
                    if (composerStartRestartGroup.shouldExecute(z3, i3 & 1)) {
                        composerStartRestartGroup.startDefaults();
                        ComposerKt.sourceInformation(composerStartRestartGroup, "102@4878L47,103@4977L8,104@5026L239,111@5309L409,122@5794L29");
                        if ((i & 1) != 0) {
                            if (i15 != 0) {
                                modifier2 = Modifier.INSTANCE;
                            }
                            if ((i2 & 4) != 0) {
                                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1173533681, "CC(remember):DateRangePicker.kt#9igjgp");
                                objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                                if (objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                                    objRememberedValue2 = DatePickerDefaults.dateFormatter$default(DatePickerDefaults.INSTANCE, null, null, null, 7, null);
                                    composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                                }
                                datePickerFormatter3 = (DatePickerFormatter) objRememberedValue2;
                                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                                i3 &= -897;
                            } else {
                                datePickerFormatter3 = datePickerFormatter;
                            }
                            if ((i2 & 8) != 0) {
                                datePickerColorsColors = DatePickerDefaults.INSTANCE.colors(composerStartRestartGroup, 6);
                                i3 &= -7169;
                            } else {
                                datePickerColorsColors = datePickerColors2;
                            }
                            if (i4 != 0) {
                                z5 = true;
                                function2RememberComposableLambda = ComposableLambdaKt.rememberComposableLambda(-803011924, true, new Function2() { // from class: androidx.compose.material3.DateRangePickerKt$$ExternalSyntheticLambda13
                                    @Override // kotlin.jvm.functions.Function2
                                    public final Object invoke(Object obj, Object obj2) {
                                        return DateRangePickerKt.DateRangePicker$lambda$1(dateRangePickerState, datePickerColorsColors, (Composer) obj, ((Integer) obj2).intValue());
                                    }
                                }, composerStartRestartGroup, 54);
                                i12 = 54;
                            } else {
                                z5 = true;
                                i12 = 54;
                            }
                            if (i6 != 0) {
                                function2RememberComposableLambda2 = ComposableLambdaKt.rememberComposableLambda(-331385278, z5, new Function2() { // from class: androidx.compose.material3.DateRangePickerKt$$ExternalSyntheticLambda14
                                    @Override // kotlin.jvm.functions.Function2
                                    public final Object invoke(Object obj, Object obj2) {
                                        return DateRangePickerKt.DateRangePicker$lambda$2(dateRangePickerState, datePickerFormatter3, datePickerColorsColors, (Composer) obj, ((Integer) obj2).intValue());
                                    }
                                }, composerStartRestartGroup, i12);
                            }
                            if (i8 != 0) {
                                z2 = true;
                            }
                            if (i10 != 0) {
                                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1173504387, "CC(remember):DateRangePicker.kt#9igjgp");
                                objRememberedValue = composerStartRestartGroup.rememberedValue();
                                if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                                    objRememberedValue = new FocusRequester();
                                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                                }
                                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                                DatePickerColors datePickerColors10 = datePickerColorsColors;
                                focusRequester3 = (FocusRequester) objRememberedValue;
                                z6 = z2;
                                datePickerColors4 = datePickerColors10;
                                function6 = function2RememberComposableLambda;
                                modifier4 = modifier2;
                                i13 = i3;
                            } else {
                                function6 = function2RememberComposableLambda;
                                z6 = z2;
                                datePickerColors4 = datePickerColorsColors;
                                modifier4 = modifier2;
                                i13 = i3;
                                focusRequester3 = focusRequester;
                            }
                        } else {
                            if (i15 != 0) {
                                modifier2 = Modifier.INSTANCE;
                            }
                            if ((i2 & 4) != 0) {
                                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1173533681, "CC(remember):DateRangePicker.kt#9igjgp");
                                objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                                if (objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                                    objRememberedValue2 = DatePickerDefaults.dateFormatter$default(DatePickerDefaults.INSTANCE, null, null, null, 7, null);
                                    composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                                }
                                datePickerFormatter3 = (DatePickerFormatter) objRememberedValue2;
                                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                                i3 &= -897;
                            } else {
                                datePickerFormatter3 = datePickerFormatter;
                            }
                            if ((i2 & 8) != 0) {
                                datePickerColorsColors = DatePickerDefaults.INSTANCE.colors(composerStartRestartGroup, 6);
                                i3 &= -7169;
                            } else {
                                datePickerColorsColors = datePickerColors2;
                            }
                            if (i4 != 0) {
                                z5 = true;
                                function2RememberComposableLambda = ComposableLambdaKt.rememberComposableLambda(-803011924, true, new Function2() { // from class: androidx.compose.material3.DateRangePickerKt$$ExternalSyntheticLambda13
                                    @Override // kotlin.jvm.functions.Function2
                                    public final Object invoke(Object obj, Object obj2) {
                                        return DateRangePickerKt.DateRangePicker$lambda$1(dateRangePickerState, datePickerColorsColors, (Composer) obj, ((Integer) obj2).intValue());
                                    }
                                }, composerStartRestartGroup, 54);
                                i12 = 54;
                            } else {
                                z5 = true;
                                i12 = 54;
                            }
                            if (i6 != 0) {
                                function2RememberComposableLambda2 = ComposableLambdaKt.rememberComposableLambda(-331385278, z5, new Function2() { // from class: androidx.compose.material3.DateRangePickerKt$$ExternalSyntheticLambda14
                                    @Override // kotlin.jvm.functions.Function2
                                    public final Object invoke(Object obj, Object obj2) {
                                        return DateRangePickerKt.DateRangePicker$lambda$2(dateRangePickerState, datePickerFormatter3, datePickerColorsColors, (Composer) obj, ((Integer) obj2).intValue());
                                    }
                                }, composerStartRestartGroup, i12);
                            }
                            if (i8 != 0) {
                                z2 = true;
                            }
                            if (i10 != 0) {
                                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1173504387, "CC(remember):DateRangePicker.kt#9igjgp");
                                objRememberedValue = composerStartRestartGroup.rememberedValue();
                                if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                                    objRememberedValue = new FocusRequester();
                                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                                }
                                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                                DatePickerColors datePickerColors11 = datePickerColorsColors;
                                focusRequester3 = (FocusRequester) objRememberedValue;
                                z6 = z2;
                                datePickerColors4 = datePickerColors11;
                                function6 = function2RememberComposableLambda;
                                modifier4 = modifier2;
                                i13 = i3;
                            } else {
                                function6 = function2RememberComposableLambda;
                                z6 = z2;
                                datePickerColors4 = datePickerColorsColors;
                                modifier4 = modifier2;
                                i13 = i3;
                                focusRequester3 = focusRequester;
                            }
                        }
                        composerStartRestartGroup.endDefaults();
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(1969726368, i13, -1, "androidx.compose.material3.DateRangePicker (DateRangePicker.kt:123)");
                        }
                        Locale locale3 = dateRangePickerState.getLocale();
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1173502065, "CC(remember):DateRangePicker.kt#9igjgp");
                        zChanged = composerStartRestartGroup.changed(locale3);
                        objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                        if (!zChanged) {
                            if (dateRangePickerState instanceof BaseDatePickerStateImpl) {
                                calendarModelCreateCalendarModel = ((BaseDatePickerStateImpl) dateRangePickerState).getCalendarModel();
                            } else {
                                calendarModelCreateCalendarModel = CalendarModel_androidKt.createCalendarModel(dateRangePickerState.getLocale());
                            }
                            objRememberedValue3 = calendarModelCreateCalendarModel;
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                        } else {
                            if (dateRangePickerState instanceof BaseDatePickerStateImpl) {
                                calendarModelCreateCalendarModel = ((BaseDatePickerStateImpl) dateRangePickerState).getCalendarModel();
                            } else {
                                calendarModelCreateCalendarModel = CalendarModel_androidKt.createCalendarModel(dateRangePickerState.getLocale());
                            }
                            objRememberedValue3 = calendarModelCreateCalendarModel;
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                        }
                        final CalendarModel calendarModel3 = (CalendarModel) objRememberedValue3;
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        if (z6) {
                            composerStartRestartGroup.startReplaceGroup(-2018450762);
                            ComposerKt.sourceInformation(composerStartRestartGroup, "138@6251L364");
                            composableLambdaRememberComposableLambda = ComposableLambdaKt.rememberComposableLambda(1343236786, true, new Function2() { // from class: androidx.compose.material3.DateRangePickerKt$$ExternalSyntheticLambda15
                                @Override // kotlin.jvm.functions.Function2
                                public final Object invoke(Object obj, Object obj2) {
                                    return DateRangePickerKt.DateRangePicker$lambda$5(dateRangePickerState, datePickerColors4, (Composer) obj, ((Integer) obj2).intValue());
                                }
                            }, composerStartRestartGroup, 54);
                            composerStartRestartGroup.endReplaceGroup();
                        } else {
                            composerStartRestartGroup.startReplaceGroup(-2018063138);
                            composerStartRestartGroup.endReplaceGroup();
                            composableLambdaRememberComposableLambda = null;
                        }
                        TextStyle value3 = TypographyKt.getValue(DatePickerModalTokens.INSTANCE.getRangeSelectionHeaderHeadlineFont(), composerStartRestartGroup, 6);
                        float fM9687constructorimpl3 = Dp.m9687constructorimpl(DatePickerModalTokens.INSTANCE.m5328getRangeSelectionHeaderContainerHeightD9Ej5fM() - HeaderHeightOffset);
                        final FocusRequester focusRequester6 = focusRequester3;
                        final DatePickerColors datePickerColors12 = datePickerColors4;
                        Function2 function9 = new Function2() { // from class: androidx.compose.material3.DateRangePickerKt$$ExternalSyntheticLambda16
                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj, Object obj2) {
                                return DateRangePickerKt.DateRangePicker$lambda$6(dateRangePickerState, calendarModel3, datePickerFormatter3, datePickerColors12, focusRequester6, (Composer) obj, ((Integer) obj2).intValue());
                            }
                        };
                        DatePickerFormatter datePickerFormatter6 = datePickerFormatter3;
                        int i19 = i13 >> 9;
                        composer2 = composerStartRestartGroup;
                        DatePickerKt.m3177DateEntryContainerau3_HiA(modifier4, function6, function2RememberComposableLambda2, composableLambdaRememberComposableLambda, datePickerColors4, value3, fM9687constructorimpl3, ComposableLambdaKt.rememberComposableLambda(684885105, true, function9, composerStartRestartGroup, 54), composer2, ((i13 >> 3) & 14) | 14155776 | (i19 & 112) | (i19 & 896) | (57344 & (i13 << 3)));
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        datePickerFormatter2 = datePickerFormatter6;
                        focusRequester2 = focusRequester6;
                        z4 = z6;
                        modifier3 = modifier4;
                        function4 = function6;
                        datePickerColors3 = datePickerColors4;
                    } else {
                        composer2 = composerStartRestartGroup;
                        composer2.skipToGroupEnd();
                        datePickerFormatter2 = datePickerFormatter;
                        focusRequester2 = focusRequester;
                        modifier3 = modifier2;
                        datePickerColors3 = datePickerColors2;
                        function4 = function2RememberComposableLambda;
                        z4 = z2;
                    }
                    function5 = function2RememberComposableLambda2;
                    scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup != null) {
                        scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.DateRangePickerKt$$ExternalSyntheticLambda17
                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj, Object obj2) {
                                return DateRangePickerKt.DateRangePicker$lambda$7(dateRangePickerState, modifier3, datePickerFormatter2, datePickerColors3, function4, function5, z4, focusRequester2, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                            }
                        });
                    }
                }
                i3 |= 1572864;
                z2 = z;
                i10 = i2 & 128;
                if (i10 != 0) {
                    i3 |= 12582912;
                } else if ((i & 12582912) == 0) {
                    if (composerStartRestartGroup.changed(focusRequester)) {
                        i11 = 8388608;
                    } else {
                        i11 = 4194304;
                    }
                    i3 |= i11;
                }
                if ((i3 & 4793491) != 4793490) {
                    z3 = true;
                } else {
                    z3 = false;
                }
                if (composerStartRestartGroup.shouldExecute(z3, i3 & 1)) {
                    composerStartRestartGroup.startDefaults();
                    ComposerKt.sourceInformation(composerStartRestartGroup, "102@4878L47,103@4977L8,104@5026L239,111@5309L409,122@5794L29");
                    if ((i & 1) != 0) {
                        if (i15 != 0) {
                            modifier2 = Modifier.INSTANCE;
                        }
                        if ((i2 & 4) != 0) {
                            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1173533681, "CC(remember):DateRangePicker.kt#9igjgp");
                            objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                            if (objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                                objRememberedValue2 = DatePickerDefaults.dateFormatter$default(DatePickerDefaults.INSTANCE, null, null, null, 7, null);
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                            }
                            datePickerFormatter3 = (DatePickerFormatter) objRememberedValue2;
                            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                            i3 &= -897;
                        } else {
                            datePickerFormatter3 = datePickerFormatter;
                        }
                        if ((i2 & 8) != 0) {
                            datePickerColorsColors = DatePickerDefaults.INSTANCE.colors(composerStartRestartGroup, 6);
                            i3 &= -7169;
                        } else {
                            datePickerColorsColors = datePickerColors2;
                        }
                        if (i4 != 0) {
                            z5 = true;
                            function2RememberComposableLambda = ComposableLambdaKt.rememberComposableLambda(-803011924, true, new Function2() { // from class: androidx.compose.material3.DateRangePickerKt$$ExternalSyntheticLambda13
                                @Override // kotlin.jvm.functions.Function2
                                public final Object invoke(Object obj, Object obj2) {
                                    return DateRangePickerKt.DateRangePicker$lambda$1(dateRangePickerState, datePickerColorsColors, (Composer) obj, ((Integer) obj2).intValue());
                                }
                            }, composerStartRestartGroup, 54);
                            i12 = 54;
                        } else {
                            z5 = true;
                            i12 = 54;
                        }
                        if (i6 != 0) {
                            function2RememberComposableLambda2 = ComposableLambdaKt.rememberComposableLambda(-331385278, z5, new Function2() { // from class: androidx.compose.material3.DateRangePickerKt$$ExternalSyntheticLambda14
                                @Override // kotlin.jvm.functions.Function2
                                public final Object invoke(Object obj, Object obj2) {
                                    return DateRangePickerKt.DateRangePicker$lambda$2(dateRangePickerState, datePickerFormatter3, datePickerColorsColors, (Composer) obj, ((Integer) obj2).intValue());
                                }
                            }, composerStartRestartGroup, i12);
                        }
                        if (i8 != 0) {
                            z2 = true;
                        }
                        if (i10 != 0) {
                            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1173504387, "CC(remember):DateRangePicker.kt#9igjgp");
                            objRememberedValue = composerStartRestartGroup.rememberedValue();
                            if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                                objRememberedValue = new FocusRequester();
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                            }
                            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                            DatePickerColors datePickerColors13 = datePickerColorsColors;
                            focusRequester3 = (FocusRequester) objRememberedValue;
                            z6 = z2;
                            datePickerColors4 = datePickerColors13;
                            function6 = function2RememberComposableLambda;
                            modifier4 = modifier2;
                            i13 = i3;
                        } else {
                            function6 = function2RememberComposableLambda;
                            z6 = z2;
                            datePickerColors4 = datePickerColorsColors;
                            modifier4 = modifier2;
                            i13 = i3;
                            focusRequester3 = focusRequester;
                        }
                    } else {
                        if (i15 != 0) {
                            modifier2 = Modifier.INSTANCE;
                        }
                        if ((i2 & 4) != 0) {
                            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1173533681, "CC(remember):DateRangePicker.kt#9igjgp");
                            objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                            if (objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                                objRememberedValue2 = DatePickerDefaults.dateFormatter$default(DatePickerDefaults.INSTANCE, null, null, null, 7, null);
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                            }
                            datePickerFormatter3 = (DatePickerFormatter) objRememberedValue2;
                            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                            i3 &= -897;
                        } else {
                            datePickerFormatter3 = datePickerFormatter;
                        }
                        if ((i2 & 8) != 0) {
                            datePickerColorsColors = DatePickerDefaults.INSTANCE.colors(composerStartRestartGroup, 6);
                            i3 &= -7169;
                        } else {
                            datePickerColorsColors = datePickerColors2;
                        }
                        if (i4 != 0) {
                            z5 = true;
                            function2RememberComposableLambda = ComposableLambdaKt.rememberComposableLambda(-803011924, true, new Function2() { // from class: androidx.compose.material3.DateRangePickerKt$$ExternalSyntheticLambda13
                                @Override // kotlin.jvm.functions.Function2
                                public final Object invoke(Object obj, Object obj2) {
                                    return DateRangePickerKt.DateRangePicker$lambda$1(dateRangePickerState, datePickerColorsColors, (Composer) obj, ((Integer) obj2).intValue());
                                }
                            }, composerStartRestartGroup, 54);
                            i12 = 54;
                        } else {
                            z5 = true;
                            i12 = 54;
                        }
                        if (i6 != 0) {
                            function2RememberComposableLambda2 = ComposableLambdaKt.rememberComposableLambda(-331385278, z5, new Function2() { // from class: androidx.compose.material3.DateRangePickerKt$$ExternalSyntheticLambda14
                                @Override // kotlin.jvm.functions.Function2
                                public final Object invoke(Object obj, Object obj2) {
                                    return DateRangePickerKt.DateRangePicker$lambda$2(dateRangePickerState, datePickerFormatter3, datePickerColorsColors, (Composer) obj, ((Integer) obj2).intValue());
                                }
                            }, composerStartRestartGroup, i12);
                        }
                        if (i8 != 0) {
                            z2 = true;
                        }
                        if (i10 != 0) {
                            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1173504387, "CC(remember):DateRangePicker.kt#9igjgp");
                            objRememberedValue = composerStartRestartGroup.rememberedValue();
                            if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                                objRememberedValue = new FocusRequester();
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                            }
                            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                            DatePickerColors datePickerColors14 = datePickerColorsColors;
                            focusRequester3 = (FocusRequester) objRememberedValue;
                            z6 = z2;
                            datePickerColors4 = datePickerColors14;
                            function6 = function2RememberComposableLambda;
                            modifier4 = modifier2;
                            i13 = i3;
                        } else {
                            function6 = function2RememberComposableLambda;
                            z6 = z2;
                            datePickerColors4 = datePickerColorsColors;
                            modifier4 = modifier2;
                            i13 = i3;
                            focusRequester3 = focusRequester;
                        }
                    }
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(1969726368, i13, -1, "androidx.compose.material3.DateRangePicker (DateRangePicker.kt:123)");
                    }
                    Locale locale4 = dateRangePickerState.getLocale();
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1173502065, "CC(remember):DateRangePicker.kt#9igjgp");
                    zChanged = composerStartRestartGroup.changed(locale4);
                    objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                    if (!zChanged) {
                        if (dateRangePickerState instanceof BaseDatePickerStateImpl) {
                            calendarModelCreateCalendarModel = ((BaseDatePickerStateImpl) dateRangePickerState).getCalendarModel();
                        } else {
                            calendarModelCreateCalendarModel = CalendarModel_androidKt.createCalendarModel(dateRangePickerState.getLocale());
                        }
                        objRememberedValue3 = calendarModelCreateCalendarModel;
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                    } else {
                        if (dateRangePickerState instanceof BaseDatePickerStateImpl) {
                            calendarModelCreateCalendarModel = ((BaseDatePickerStateImpl) dateRangePickerState).getCalendarModel();
                        } else {
                            calendarModelCreateCalendarModel = CalendarModel_androidKt.createCalendarModel(dateRangePickerState.getLocale());
                        }
                        objRememberedValue3 = calendarModelCreateCalendarModel;
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                    }
                    final CalendarModel calendarModel4 = (CalendarModel) objRememberedValue3;
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    if (z6) {
                        composerStartRestartGroup.startReplaceGroup(-2018450762);
                        ComposerKt.sourceInformation(composerStartRestartGroup, "138@6251L364");
                        composableLambdaRememberComposableLambda = ComposableLambdaKt.rememberComposableLambda(1343236786, true, new Function2() { // from class: androidx.compose.material3.DateRangePickerKt$$ExternalSyntheticLambda15
                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj, Object obj2) {
                                return DateRangePickerKt.DateRangePicker$lambda$5(dateRangePickerState, datePickerColors4, (Composer) obj, ((Integer) obj2).intValue());
                            }
                        }, composerStartRestartGroup, 54);
                        composerStartRestartGroup.endReplaceGroup();
                    } else {
                        composerStartRestartGroup.startReplaceGroup(-2018063138);
                        composerStartRestartGroup.endReplaceGroup();
                        composableLambdaRememberComposableLambda = null;
                    }
                    TextStyle value4 = TypographyKt.getValue(DatePickerModalTokens.INSTANCE.getRangeSelectionHeaderHeadlineFont(), composerStartRestartGroup, 6);
                    float fM9687constructorimpl4 = Dp.m9687constructorimpl(DatePickerModalTokens.INSTANCE.m5328getRangeSelectionHeaderContainerHeightD9Ej5fM() - HeaderHeightOffset);
                    final FocusRequester focusRequester7 = focusRequester3;
                    final DatePickerColors datePickerColors15 = datePickerColors4;
                    Function2 function10 = new Function2() { // from class: androidx.compose.material3.DateRangePickerKt$$ExternalSyntheticLambda16
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return DateRangePickerKt.DateRangePicker$lambda$6(dateRangePickerState, calendarModel4, datePickerFormatter3, datePickerColors15, focusRequester7, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    };
                    DatePickerFormatter datePickerFormatter7 = datePickerFormatter3;
                    int i110 = i13 >> 9;
                    composer2 = composerStartRestartGroup;
                    DatePickerKt.m3177DateEntryContainerau3_HiA(modifier4, function6, function2RememberComposableLambda2, composableLambdaRememberComposableLambda, datePickerColors4, value4, fM9687constructorimpl4, ComposableLambdaKt.rememberComposableLambda(684885105, true, function10, composerStartRestartGroup, 54), composer2, ((i13 >> 3) & 14) | 14155776 | (i110 & 112) | (i110 & 896) | (57344 & (i13 << 3)));
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    datePickerFormatter2 = datePickerFormatter7;
                    focusRequester2 = focusRequester7;
                    z4 = z6;
                    modifier3 = modifier4;
                    function4 = function6;
                    datePickerColors3 = datePickerColors4;
                } else {
                    composer2 = composerStartRestartGroup;
                    composer2.skipToGroupEnd();
                    datePickerFormatter2 = datePickerFormatter;
                    focusRequester2 = focusRequester;
                    modifier3 = modifier2;
                    datePickerColors3 = datePickerColors2;
                    function4 = function2RememberComposableLambda;
                    z4 = z2;
                }
                function5 = function2RememberComposableLambda2;
                scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.DateRangePickerKt$$ExternalSyntheticLambda17
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return DateRangePickerKt.DateRangePicker$lambda$7(dateRangePickerState, modifier3, datePickerFormatter2, datePickerColors3, function4, function5, z4, focusRequester2, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    });
                }
            }
            i3 |= 24576;
            function2RememberComposableLambda = function2;
            i6 = i2 & 32;
            if (i6 != 0) {
                if ((196608 & i) == 0) {
                    function2RememberComposableLambda2 = function3;
                    if (composerStartRestartGroup.changedInstance(function2RememberComposableLambda2)) {
                        i7 = 131072;
                    } else {
                        i7 = 65536;
                    }
                    i3 |= i7;
                }
                i8 = i2 & 64;
                if (i8 != 0) {
                    if ((1572864 & i) == 0) {
                        z2 = z;
                        if (composerStartRestartGroup.changed(z2)) {
                            i9 = 1048576;
                        } else {
                            i9 = 524288;
                        }
                        i3 |= i9;
                    }
                    i10 = i2 & 128;
                    if (i10 != 0) {
                        i3 |= 12582912;
                    } else if ((i & 12582912) == 0) {
                        if (composerStartRestartGroup.changed(focusRequester)) {
                            i11 = 8388608;
                        } else {
                            i11 = 4194304;
                        }
                        i3 |= i11;
                    }
                    if ((i3 & 4793491) != 4793490) {
                        z3 = true;
                    } else {
                        z3 = false;
                    }
                    if (composerStartRestartGroup.shouldExecute(z3, i3 & 1)) {
                        composerStartRestartGroup.startDefaults();
                        ComposerKt.sourceInformation(composerStartRestartGroup, "102@4878L47,103@4977L8,104@5026L239,111@5309L409,122@5794L29");
                        if ((i & 1) != 0) {
                            if (i15 != 0) {
                                modifier2 = Modifier.INSTANCE;
                            }
                            if ((i2 & 4) != 0) {
                                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1173533681, "CC(remember):DateRangePicker.kt#9igjgp");
                                objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                                if (objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                                    objRememberedValue2 = DatePickerDefaults.dateFormatter$default(DatePickerDefaults.INSTANCE, null, null, null, 7, null);
                                    composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                                }
                                datePickerFormatter3 = (DatePickerFormatter) objRememberedValue2;
                                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                                i3 &= -897;
                            } else {
                                datePickerFormatter3 = datePickerFormatter;
                            }
                            if ((i2 & 8) != 0) {
                                datePickerColorsColors = DatePickerDefaults.INSTANCE.colors(composerStartRestartGroup, 6);
                                i3 &= -7169;
                            } else {
                                datePickerColorsColors = datePickerColors2;
                            }
                            if (i4 != 0) {
                                z5 = true;
                                function2RememberComposableLambda = ComposableLambdaKt.rememberComposableLambda(-803011924, true, new Function2() { // from class: androidx.compose.material3.DateRangePickerKt$$ExternalSyntheticLambda13
                                    @Override // kotlin.jvm.functions.Function2
                                    public final Object invoke(Object obj, Object obj2) {
                                        return DateRangePickerKt.DateRangePicker$lambda$1(dateRangePickerState, datePickerColorsColors, (Composer) obj, ((Integer) obj2).intValue());
                                    }
                                }, composerStartRestartGroup, 54);
                                i12 = 54;
                            } else {
                                z5 = true;
                                i12 = 54;
                            }
                            if (i6 != 0) {
                                function2RememberComposableLambda2 = ComposableLambdaKt.rememberComposableLambda(-331385278, z5, new Function2() { // from class: androidx.compose.material3.DateRangePickerKt$$ExternalSyntheticLambda14
                                    @Override // kotlin.jvm.functions.Function2
                                    public final Object invoke(Object obj, Object obj2) {
                                        return DateRangePickerKt.DateRangePicker$lambda$2(dateRangePickerState, datePickerFormatter3, datePickerColorsColors, (Composer) obj, ((Integer) obj2).intValue());
                                    }
                                }, composerStartRestartGroup, i12);
                            }
                            if (i8 != 0) {
                                z2 = true;
                            }
                            if (i10 != 0) {
                                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1173504387, "CC(remember):DateRangePicker.kt#9igjgp");
                                objRememberedValue = composerStartRestartGroup.rememberedValue();
                                if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                                    objRememberedValue = new FocusRequester();
                                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                                }
                                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                                DatePickerColors datePickerColors16 = datePickerColorsColors;
                                focusRequester3 = (FocusRequester) objRememberedValue;
                                z6 = z2;
                                datePickerColors4 = datePickerColors16;
                                function6 = function2RememberComposableLambda;
                                modifier4 = modifier2;
                                i13 = i3;
                            } else {
                                function6 = function2RememberComposableLambda;
                                z6 = z2;
                                datePickerColors4 = datePickerColorsColors;
                                modifier4 = modifier2;
                                i13 = i3;
                                focusRequester3 = focusRequester;
                            }
                        } else {
                            if (i15 != 0) {
                                modifier2 = Modifier.INSTANCE;
                            }
                            if ((i2 & 4) != 0) {
                                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1173533681, "CC(remember):DateRangePicker.kt#9igjgp");
                                objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                                if (objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                                    objRememberedValue2 = DatePickerDefaults.dateFormatter$default(DatePickerDefaults.INSTANCE, null, null, null, 7, null);
                                    composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                                }
                                datePickerFormatter3 = (DatePickerFormatter) objRememberedValue2;
                                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                                i3 &= -897;
                            } else {
                                datePickerFormatter3 = datePickerFormatter;
                            }
                            if ((i2 & 8) != 0) {
                                datePickerColorsColors = DatePickerDefaults.INSTANCE.colors(composerStartRestartGroup, 6);
                                i3 &= -7169;
                            } else {
                                datePickerColorsColors = datePickerColors2;
                            }
                            if (i4 != 0) {
                                z5 = true;
                                function2RememberComposableLambda = ComposableLambdaKt.rememberComposableLambda(-803011924, true, new Function2() { // from class: androidx.compose.material3.DateRangePickerKt$$ExternalSyntheticLambda13
                                    @Override // kotlin.jvm.functions.Function2
                                    public final Object invoke(Object obj, Object obj2) {
                                        return DateRangePickerKt.DateRangePicker$lambda$1(dateRangePickerState, datePickerColorsColors, (Composer) obj, ((Integer) obj2).intValue());
                                    }
                                }, composerStartRestartGroup, 54);
                                i12 = 54;
                            } else {
                                z5 = true;
                                i12 = 54;
                            }
                            if (i6 != 0) {
                                function2RememberComposableLambda2 = ComposableLambdaKt.rememberComposableLambda(-331385278, z5, new Function2() { // from class: androidx.compose.material3.DateRangePickerKt$$ExternalSyntheticLambda14
                                    @Override // kotlin.jvm.functions.Function2
                                    public final Object invoke(Object obj, Object obj2) {
                                        return DateRangePickerKt.DateRangePicker$lambda$2(dateRangePickerState, datePickerFormatter3, datePickerColorsColors, (Composer) obj, ((Integer) obj2).intValue());
                                    }
                                }, composerStartRestartGroup, i12);
                            }
                            if (i8 != 0) {
                                z2 = true;
                            }
                            if (i10 != 0) {
                                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1173504387, "CC(remember):DateRangePicker.kt#9igjgp");
                                objRememberedValue = composerStartRestartGroup.rememberedValue();
                                if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                                    objRememberedValue = new FocusRequester();
                                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                                }
                                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                                DatePickerColors datePickerColors17 = datePickerColorsColors;
                                focusRequester3 = (FocusRequester) objRememberedValue;
                                z6 = z2;
                                datePickerColors4 = datePickerColors17;
                                function6 = function2RememberComposableLambda;
                                modifier4 = modifier2;
                                i13 = i3;
                            } else {
                                function6 = function2RememberComposableLambda;
                                z6 = z2;
                                datePickerColors4 = datePickerColorsColors;
                                modifier4 = modifier2;
                                i13 = i3;
                                focusRequester3 = focusRequester;
                            }
                        }
                        composerStartRestartGroup.endDefaults();
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(1969726368, i13, -1, "androidx.compose.material3.DateRangePicker (DateRangePicker.kt:123)");
                        }
                        Locale locale5 = dateRangePickerState.getLocale();
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1173502065, "CC(remember):DateRangePicker.kt#9igjgp");
                        zChanged = composerStartRestartGroup.changed(locale5);
                        objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                        if (!zChanged) {
                            if (dateRangePickerState instanceof BaseDatePickerStateImpl) {
                                calendarModelCreateCalendarModel = ((BaseDatePickerStateImpl) dateRangePickerState).getCalendarModel();
                            } else {
                                calendarModelCreateCalendarModel = CalendarModel_androidKt.createCalendarModel(dateRangePickerState.getLocale());
                            }
                            objRememberedValue3 = calendarModelCreateCalendarModel;
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                        } else {
                            if (dateRangePickerState instanceof BaseDatePickerStateImpl) {
                                calendarModelCreateCalendarModel = ((BaseDatePickerStateImpl) dateRangePickerState).getCalendarModel();
                            } else {
                                calendarModelCreateCalendarModel = CalendarModel_androidKt.createCalendarModel(dateRangePickerState.getLocale());
                            }
                            objRememberedValue3 = calendarModelCreateCalendarModel;
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                        }
                        final CalendarModel calendarModel5 = (CalendarModel) objRememberedValue3;
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        if (z6) {
                            composerStartRestartGroup.startReplaceGroup(-2018450762);
                            ComposerKt.sourceInformation(composerStartRestartGroup, "138@6251L364");
                            composableLambdaRememberComposableLambda = ComposableLambdaKt.rememberComposableLambda(1343236786, true, new Function2() { // from class: androidx.compose.material3.DateRangePickerKt$$ExternalSyntheticLambda15
                                @Override // kotlin.jvm.functions.Function2
                                public final Object invoke(Object obj, Object obj2) {
                                    return DateRangePickerKt.DateRangePicker$lambda$5(dateRangePickerState, datePickerColors4, (Composer) obj, ((Integer) obj2).intValue());
                                }
                            }, composerStartRestartGroup, 54);
                            composerStartRestartGroup.endReplaceGroup();
                        } else {
                            composerStartRestartGroup.startReplaceGroup(-2018063138);
                            composerStartRestartGroup.endReplaceGroup();
                            composableLambdaRememberComposableLambda = null;
                        }
                        TextStyle value5 = TypographyKt.getValue(DatePickerModalTokens.INSTANCE.getRangeSelectionHeaderHeadlineFont(), composerStartRestartGroup, 6);
                        float fM9687constructorimpl5 = Dp.m9687constructorimpl(DatePickerModalTokens.INSTANCE.m5328getRangeSelectionHeaderContainerHeightD9Ej5fM() - HeaderHeightOffset);
                        final FocusRequester focusRequester8 = focusRequester3;
                        final DatePickerColors datePickerColors18 = datePickerColors4;
                        Function2 function11 = new Function2() { // from class: androidx.compose.material3.DateRangePickerKt$$ExternalSyntheticLambda16
                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj, Object obj2) {
                                return DateRangePickerKt.DateRangePicker$lambda$6(dateRangePickerState, calendarModel5, datePickerFormatter3, datePickerColors18, focusRequester8, (Composer) obj, ((Integer) obj2).intValue());
                            }
                        };
                        DatePickerFormatter datePickerFormatter8 = datePickerFormatter3;
                        int i111 = i13 >> 9;
                        composer2 = composerStartRestartGroup;
                        DatePickerKt.m3177DateEntryContainerau3_HiA(modifier4, function6, function2RememberComposableLambda2, composableLambdaRememberComposableLambda, datePickerColors4, value5, fM9687constructorimpl5, ComposableLambdaKt.rememberComposableLambda(684885105, true, function11, composerStartRestartGroup, 54), composer2, ((i13 >> 3) & 14) | 14155776 | (i111 & 112) | (i111 & 896) | (57344 & (i13 << 3)));
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        datePickerFormatter2 = datePickerFormatter8;
                        focusRequester2 = focusRequester8;
                        z4 = z6;
                        modifier3 = modifier4;
                        function4 = function6;
                        datePickerColors3 = datePickerColors4;
                    } else {
                        composer2 = composerStartRestartGroup;
                        composer2.skipToGroupEnd();
                        datePickerFormatter2 = datePickerFormatter;
                        focusRequester2 = focusRequester;
                        modifier3 = modifier2;
                        datePickerColors3 = datePickerColors2;
                        function4 = function2RememberComposableLambda;
                        z4 = z2;
                    }
                    function5 = function2RememberComposableLambda2;
                    scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup != null) {
                        scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.DateRangePickerKt$$ExternalSyntheticLambda17
                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj, Object obj2) {
                                return DateRangePickerKt.DateRangePicker$lambda$7(dateRangePickerState, modifier3, datePickerFormatter2, datePickerColors3, function4, function5, z4, focusRequester2, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                            }
                        });
                    }
                }
                i3 |= 1572864;
                z2 = z;
                i10 = i2 & 128;
                if (i10 != 0) {
                    i3 |= 12582912;
                } else if ((i & 12582912) == 0) {
                    if (composerStartRestartGroup.changed(focusRequester)) {
                        i11 = 8388608;
                    } else {
                        i11 = 4194304;
                    }
                    i3 |= i11;
                }
                if ((i3 & 4793491) != 4793490) {
                    z3 = true;
                } else {
                    z3 = false;
                }
                if (composerStartRestartGroup.shouldExecute(z3, i3 & 1)) {
                    composerStartRestartGroup.startDefaults();
                    ComposerKt.sourceInformation(composerStartRestartGroup, "102@4878L47,103@4977L8,104@5026L239,111@5309L409,122@5794L29");
                    if ((i & 1) != 0) {
                        if (i15 != 0) {
                            modifier2 = Modifier.INSTANCE;
                        }
                        if ((i2 & 4) != 0) {
                            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1173533681, "CC(remember):DateRangePicker.kt#9igjgp");
                            objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                            if (objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                                objRememberedValue2 = DatePickerDefaults.dateFormatter$default(DatePickerDefaults.INSTANCE, null, null, null, 7, null);
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                            }
                            datePickerFormatter3 = (DatePickerFormatter) objRememberedValue2;
                            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                            i3 &= -897;
                        } else {
                            datePickerFormatter3 = datePickerFormatter;
                        }
                        if ((i2 & 8) != 0) {
                            datePickerColorsColors = DatePickerDefaults.INSTANCE.colors(composerStartRestartGroup, 6);
                            i3 &= -7169;
                        } else {
                            datePickerColorsColors = datePickerColors2;
                        }
                        if (i4 != 0) {
                            z5 = true;
                            function2RememberComposableLambda = ComposableLambdaKt.rememberComposableLambda(-803011924, true, new Function2() { // from class: androidx.compose.material3.DateRangePickerKt$$ExternalSyntheticLambda13
                                @Override // kotlin.jvm.functions.Function2
                                public final Object invoke(Object obj, Object obj2) {
                                    return DateRangePickerKt.DateRangePicker$lambda$1(dateRangePickerState, datePickerColorsColors, (Composer) obj, ((Integer) obj2).intValue());
                                }
                            }, composerStartRestartGroup, 54);
                            i12 = 54;
                        } else {
                            z5 = true;
                            i12 = 54;
                        }
                        if (i6 != 0) {
                            function2RememberComposableLambda2 = ComposableLambdaKt.rememberComposableLambda(-331385278, z5, new Function2() { // from class: androidx.compose.material3.DateRangePickerKt$$ExternalSyntheticLambda14
                                @Override // kotlin.jvm.functions.Function2
                                public final Object invoke(Object obj, Object obj2) {
                                    return DateRangePickerKt.DateRangePicker$lambda$2(dateRangePickerState, datePickerFormatter3, datePickerColorsColors, (Composer) obj, ((Integer) obj2).intValue());
                                }
                            }, composerStartRestartGroup, i12);
                        }
                        if (i8 != 0) {
                            z2 = true;
                        }
                        if (i10 != 0) {
                            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1173504387, "CC(remember):DateRangePicker.kt#9igjgp");
                            objRememberedValue = composerStartRestartGroup.rememberedValue();
                            if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                                objRememberedValue = new FocusRequester();
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                            }
                            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                            DatePickerColors datePickerColors19 = datePickerColorsColors;
                            focusRequester3 = (FocusRequester) objRememberedValue;
                            z6 = z2;
                            datePickerColors4 = datePickerColors19;
                            function6 = function2RememberComposableLambda;
                            modifier4 = modifier2;
                            i13 = i3;
                        } else {
                            function6 = function2RememberComposableLambda;
                            z6 = z2;
                            datePickerColors4 = datePickerColorsColors;
                            modifier4 = modifier2;
                            i13 = i3;
                            focusRequester3 = focusRequester;
                        }
                    } else {
                        if (i15 != 0) {
                            modifier2 = Modifier.INSTANCE;
                        }
                        if ((i2 & 4) != 0) {
                            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1173533681, "CC(remember):DateRangePicker.kt#9igjgp");
                            objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                            if (objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                                objRememberedValue2 = DatePickerDefaults.dateFormatter$default(DatePickerDefaults.INSTANCE, null, null, null, 7, null);
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                            }
                            datePickerFormatter3 = (DatePickerFormatter) objRememberedValue2;
                            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                            i3 &= -897;
                        } else {
                            datePickerFormatter3 = datePickerFormatter;
                        }
                        if ((i2 & 8) != 0) {
                            datePickerColorsColors = DatePickerDefaults.INSTANCE.colors(composerStartRestartGroup, 6);
                            i3 &= -7169;
                        } else {
                            datePickerColorsColors = datePickerColors2;
                        }
                        if (i4 != 0) {
                            z5 = true;
                            function2RememberComposableLambda = ComposableLambdaKt.rememberComposableLambda(-803011924, true, new Function2() { // from class: androidx.compose.material3.DateRangePickerKt$$ExternalSyntheticLambda13
                                @Override // kotlin.jvm.functions.Function2
                                public final Object invoke(Object obj, Object obj2) {
                                    return DateRangePickerKt.DateRangePicker$lambda$1(dateRangePickerState, datePickerColorsColors, (Composer) obj, ((Integer) obj2).intValue());
                                }
                            }, composerStartRestartGroup, 54);
                            i12 = 54;
                        } else {
                            z5 = true;
                            i12 = 54;
                        }
                        if (i6 != 0) {
                            function2RememberComposableLambda2 = ComposableLambdaKt.rememberComposableLambda(-331385278, z5, new Function2() { // from class: androidx.compose.material3.DateRangePickerKt$$ExternalSyntheticLambda14
                                @Override // kotlin.jvm.functions.Function2
                                public final Object invoke(Object obj, Object obj2) {
                                    return DateRangePickerKt.DateRangePicker$lambda$2(dateRangePickerState, datePickerFormatter3, datePickerColorsColors, (Composer) obj, ((Integer) obj2).intValue());
                                }
                            }, composerStartRestartGroup, i12);
                        }
                        if (i8 != 0) {
                            z2 = true;
                        }
                        if (i10 != 0) {
                            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1173504387, "CC(remember):DateRangePicker.kt#9igjgp");
                            objRememberedValue = composerStartRestartGroup.rememberedValue();
                            if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                                objRememberedValue = new FocusRequester();
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                            }
                            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                            DatePickerColors datePickerColors110 = datePickerColorsColors;
                            focusRequester3 = (FocusRequester) objRememberedValue;
                            z6 = z2;
                            datePickerColors4 = datePickerColors110;
                            function6 = function2RememberComposableLambda;
                            modifier4 = modifier2;
                            i13 = i3;
                        } else {
                            function6 = function2RememberComposableLambda;
                            z6 = z2;
                            datePickerColors4 = datePickerColorsColors;
                            modifier4 = modifier2;
                            i13 = i3;
                            focusRequester3 = focusRequester;
                        }
                    }
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(1969726368, i13, -1, "androidx.compose.material3.DateRangePicker (DateRangePicker.kt:123)");
                    }
                    Locale locale6 = dateRangePickerState.getLocale();
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1173502065, "CC(remember):DateRangePicker.kt#9igjgp");
                    zChanged = composerStartRestartGroup.changed(locale6);
                    objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                    if (!zChanged) {
                        if (dateRangePickerState instanceof BaseDatePickerStateImpl) {
                            calendarModelCreateCalendarModel = ((BaseDatePickerStateImpl) dateRangePickerState).getCalendarModel();
                        } else {
                            calendarModelCreateCalendarModel = CalendarModel_androidKt.createCalendarModel(dateRangePickerState.getLocale());
                        }
                        objRememberedValue3 = calendarModelCreateCalendarModel;
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                    } else {
                        if (dateRangePickerState instanceof BaseDatePickerStateImpl) {
                            calendarModelCreateCalendarModel = ((BaseDatePickerStateImpl) dateRangePickerState).getCalendarModel();
                        } else {
                            calendarModelCreateCalendarModel = CalendarModel_androidKt.createCalendarModel(dateRangePickerState.getLocale());
                        }
                        objRememberedValue3 = calendarModelCreateCalendarModel;
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                    }
                    final CalendarModel calendarModel6 = (CalendarModel) objRememberedValue3;
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    if (z6) {
                        composerStartRestartGroup.startReplaceGroup(-2018450762);
                        ComposerKt.sourceInformation(composerStartRestartGroup, "138@6251L364");
                        composableLambdaRememberComposableLambda = ComposableLambdaKt.rememberComposableLambda(1343236786, true, new Function2() { // from class: androidx.compose.material3.DateRangePickerKt$$ExternalSyntheticLambda15
                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj, Object obj2) {
                                return DateRangePickerKt.DateRangePicker$lambda$5(dateRangePickerState, datePickerColors4, (Composer) obj, ((Integer) obj2).intValue());
                            }
                        }, composerStartRestartGroup, 54);
                        composerStartRestartGroup.endReplaceGroup();
                    } else {
                        composerStartRestartGroup.startReplaceGroup(-2018063138);
                        composerStartRestartGroup.endReplaceGroup();
                        composableLambdaRememberComposableLambda = null;
                    }
                    TextStyle value6 = TypographyKt.getValue(DatePickerModalTokens.INSTANCE.getRangeSelectionHeaderHeadlineFont(), composerStartRestartGroup, 6);
                    float fM9687constructorimpl6 = Dp.m9687constructorimpl(DatePickerModalTokens.INSTANCE.m5328getRangeSelectionHeaderContainerHeightD9Ej5fM() - HeaderHeightOffset);
                    final FocusRequester focusRequester9 = focusRequester3;
                    final DatePickerColors datePickerColors111 = datePickerColors4;
                    Function2 function12 = new Function2() { // from class: androidx.compose.material3.DateRangePickerKt$$ExternalSyntheticLambda16
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return DateRangePickerKt.DateRangePicker$lambda$6(dateRangePickerState, calendarModel6, datePickerFormatter3, datePickerColors111, focusRequester9, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    };
                    DatePickerFormatter datePickerFormatter9 = datePickerFormatter3;
                    int i112 = i13 >> 9;
                    composer2 = composerStartRestartGroup;
                    DatePickerKt.m3177DateEntryContainerau3_HiA(modifier4, function6, function2RememberComposableLambda2, composableLambdaRememberComposableLambda, datePickerColors4, value6, fM9687constructorimpl6, ComposableLambdaKt.rememberComposableLambda(684885105, true, function12, composerStartRestartGroup, 54), composer2, ((i13 >> 3) & 14) | 14155776 | (i112 & 112) | (i112 & 896) | (57344 & (i13 << 3)));
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    datePickerFormatter2 = datePickerFormatter9;
                    focusRequester2 = focusRequester9;
                    z4 = z6;
                    modifier3 = modifier4;
                    function4 = function6;
                    datePickerColors3 = datePickerColors4;
                } else {
                    composer2 = composerStartRestartGroup;
                    composer2.skipToGroupEnd();
                    datePickerFormatter2 = datePickerFormatter;
                    focusRequester2 = focusRequester;
                    modifier3 = modifier2;
                    datePickerColors3 = datePickerColors2;
                    function4 = function2RememberComposableLambda;
                    z4 = z2;
                }
                function5 = function2RememberComposableLambda2;
                scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.DateRangePickerKt$$ExternalSyntheticLambda17
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return DateRangePickerKt.DateRangePicker$lambda$7(dateRangePickerState, modifier3, datePickerFormatter2, datePickerColors3, function4, function5, z4, focusRequester2, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    });
                }
            }
            i3 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
            function2RememberComposableLambda2 = function3;
            i8 = i2 & 64;
            if (i8 != 0) {
                if ((1572864 & i) == 0) {
                    z2 = z;
                    if (composerStartRestartGroup.changed(z2)) {
                        i9 = 1048576;
                    } else {
                        i9 = 524288;
                    }
                    i3 |= i9;
                }
                i10 = i2 & 128;
                if (i10 != 0) {
                    i3 |= 12582912;
                } else if ((i & 12582912) == 0) {
                    if (composerStartRestartGroup.changed(focusRequester)) {
                        i11 = 8388608;
                    } else {
                        i11 = 4194304;
                    }
                    i3 |= i11;
                }
                if ((i3 & 4793491) != 4793490) {
                    z3 = true;
                } else {
                    z3 = false;
                }
                if (composerStartRestartGroup.shouldExecute(z3, i3 & 1)) {
                    composerStartRestartGroup.startDefaults();
                    ComposerKt.sourceInformation(composerStartRestartGroup, "102@4878L47,103@4977L8,104@5026L239,111@5309L409,122@5794L29");
                    if ((i & 1) != 0) {
                        if (i15 != 0) {
                            modifier2 = Modifier.INSTANCE;
                        }
                        if ((i2 & 4) != 0) {
                            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1173533681, "CC(remember):DateRangePicker.kt#9igjgp");
                            objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                            if (objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                                objRememberedValue2 = DatePickerDefaults.dateFormatter$default(DatePickerDefaults.INSTANCE, null, null, null, 7, null);
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                            }
                            datePickerFormatter3 = (DatePickerFormatter) objRememberedValue2;
                            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                            i3 &= -897;
                        } else {
                            datePickerFormatter3 = datePickerFormatter;
                        }
                        if ((i2 & 8) != 0) {
                            datePickerColorsColors = DatePickerDefaults.INSTANCE.colors(composerStartRestartGroup, 6);
                            i3 &= -7169;
                        } else {
                            datePickerColorsColors = datePickerColors2;
                        }
                        if (i4 != 0) {
                            z5 = true;
                            function2RememberComposableLambda = ComposableLambdaKt.rememberComposableLambda(-803011924, true, new Function2() { // from class: androidx.compose.material3.DateRangePickerKt$$ExternalSyntheticLambda13
                                @Override // kotlin.jvm.functions.Function2
                                public final Object invoke(Object obj, Object obj2) {
                                    return DateRangePickerKt.DateRangePicker$lambda$1(dateRangePickerState, datePickerColorsColors, (Composer) obj, ((Integer) obj2).intValue());
                                }
                            }, composerStartRestartGroup, 54);
                            i12 = 54;
                        } else {
                            z5 = true;
                            i12 = 54;
                        }
                        if (i6 != 0) {
                            function2RememberComposableLambda2 = ComposableLambdaKt.rememberComposableLambda(-331385278, z5, new Function2() { // from class: androidx.compose.material3.DateRangePickerKt$$ExternalSyntheticLambda14
                                @Override // kotlin.jvm.functions.Function2
                                public final Object invoke(Object obj, Object obj2) {
                                    return DateRangePickerKt.DateRangePicker$lambda$2(dateRangePickerState, datePickerFormatter3, datePickerColorsColors, (Composer) obj, ((Integer) obj2).intValue());
                                }
                            }, composerStartRestartGroup, i12);
                        }
                        if (i8 != 0) {
                            z2 = true;
                        }
                        if (i10 != 0) {
                            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1173504387, "CC(remember):DateRangePicker.kt#9igjgp");
                            objRememberedValue = composerStartRestartGroup.rememberedValue();
                            if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                                objRememberedValue = new FocusRequester();
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                            }
                            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                            DatePickerColors datePickerColors112 = datePickerColorsColors;
                            focusRequester3 = (FocusRequester) objRememberedValue;
                            z6 = z2;
                            datePickerColors4 = datePickerColors112;
                            function6 = function2RememberComposableLambda;
                            modifier4 = modifier2;
                            i13 = i3;
                        } else {
                            function6 = function2RememberComposableLambda;
                            z6 = z2;
                            datePickerColors4 = datePickerColorsColors;
                            modifier4 = modifier2;
                            i13 = i3;
                            focusRequester3 = focusRequester;
                        }
                    } else {
                        if (i15 != 0) {
                            modifier2 = Modifier.INSTANCE;
                        }
                        if ((i2 & 4) != 0) {
                            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1173533681, "CC(remember):DateRangePicker.kt#9igjgp");
                            objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                            if (objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                                objRememberedValue2 = DatePickerDefaults.dateFormatter$default(DatePickerDefaults.INSTANCE, null, null, null, 7, null);
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                            }
                            datePickerFormatter3 = (DatePickerFormatter) objRememberedValue2;
                            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                            i3 &= -897;
                        } else {
                            datePickerFormatter3 = datePickerFormatter;
                        }
                        if ((i2 & 8) != 0) {
                            datePickerColorsColors = DatePickerDefaults.INSTANCE.colors(composerStartRestartGroup, 6);
                            i3 &= -7169;
                        } else {
                            datePickerColorsColors = datePickerColors2;
                        }
                        if (i4 != 0) {
                            z5 = true;
                            function2RememberComposableLambda = ComposableLambdaKt.rememberComposableLambda(-803011924, true, new Function2() { // from class: androidx.compose.material3.DateRangePickerKt$$ExternalSyntheticLambda13
                                @Override // kotlin.jvm.functions.Function2
                                public final Object invoke(Object obj, Object obj2) {
                                    return DateRangePickerKt.DateRangePicker$lambda$1(dateRangePickerState, datePickerColorsColors, (Composer) obj, ((Integer) obj2).intValue());
                                }
                            }, composerStartRestartGroup, 54);
                            i12 = 54;
                        } else {
                            z5 = true;
                            i12 = 54;
                        }
                        if (i6 != 0) {
                            function2RememberComposableLambda2 = ComposableLambdaKt.rememberComposableLambda(-331385278, z5, new Function2() { // from class: androidx.compose.material3.DateRangePickerKt$$ExternalSyntheticLambda14
                                @Override // kotlin.jvm.functions.Function2
                                public final Object invoke(Object obj, Object obj2) {
                                    return DateRangePickerKt.DateRangePicker$lambda$2(dateRangePickerState, datePickerFormatter3, datePickerColorsColors, (Composer) obj, ((Integer) obj2).intValue());
                                }
                            }, composerStartRestartGroup, i12);
                        }
                        if (i8 != 0) {
                            z2 = true;
                        }
                        if (i10 != 0) {
                            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1173504387, "CC(remember):DateRangePicker.kt#9igjgp");
                            objRememberedValue = composerStartRestartGroup.rememberedValue();
                            if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                                objRememberedValue = new FocusRequester();
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                            }
                            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                            DatePickerColors datePickerColors113 = datePickerColorsColors;
                            focusRequester3 = (FocusRequester) objRememberedValue;
                            z6 = z2;
                            datePickerColors4 = datePickerColors113;
                            function6 = function2RememberComposableLambda;
                            modifier4 = modifier2;
                            i13 = i3;
                        } else {
                            function6 = function2RememberComposableLambda;
                            z6 = z2;
                            datePickerColors4 = datePickerColorsColors;
                            modifier4 = modifier2;
                            i13 = i3;
                            focusRequester3 = focusRequester;
                        }
                    }
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(1969726368, i13, -1, "androidx.compose.material3.DateRangePicker (DateRangePicker.kt:123)");
                    }
                    Locale locale7 = dateRangePickerState.getLocale();
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1173502065, "CC(remember):DateRangePicker.kt#9igjgp");
                    zChanged = composerStartRestartGroup.changed(locale7);
                    objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                    if (!zChanged) {
                        if (dateRangePickerState instanceof BaseDatePickerStateImpl) {
                            calendarModelCreateCalendarModel = ((BaseDatePickerStateImpl) dateRangePickerState).getCalendarModel();
                        } else {
                            calendarModelCreateCalendarModel = CalendarModel_androidKt.createCalendarModel(dateRangePickerState.getLocale());
                        }
                        objRememberedValue3 = calendarModelCreateCalendarModel;
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                    } else {
                        if (dateRangePickerState instanceof BaseDatePickerStateImpl) {
                            calendarModelCreateCalendarModel = ((BaseDatePickerStateImpl) dateRangePickerState).getCalendarModel();
                        } else {
                            calendarModelCreateCalendarModel = CalendarModel_androidKt.createCalendarModel(dateRangePickerState.getLocale());
                        }
                        objRememberedValue3 = calendarModelCreateCalendarModel;
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                    }
                    final CalendarModel calendarModel7 = (CalendarModel) objRememberedValue3;
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    if (z6) {
                        composerStartRestartGroup.startReplaceGroup(-2018450762);
                        ComposerKt.sourceInformation(composerStartRestartGroup, "138@6251L364");
                        composableLambdaRememberComposableLambda = ComposableLambdaKt.rememberComposableLambda(1343236786, true, new Function2() { // from class: androidx.compose.material3.DateRangePickerKt$$ExternalSyntheticLambda15
                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj, Object obj2) {
                                return DateRangePickerKt.DateRangePicker$lambda$5(dateRangePickerState, datePickerColors4, (Composer) obj, ((Integer) obj2).intValue());
                            }
                        }, composerStartRestartGroup, 54);
                        composerStartRestartGroup.endReplaceGroup();
                    } else {
                        composerStartRestartGroup.startReplaceGroup(-2018063138);
                        composerStartRestartGroup.endReplaceGroup();
                        composableLambdaRememberComposableLambda = null;
                    }
                    TextStyle value7 = TypographyKt.getValue(DatePickerModalTokens.INSTANCE.getRangeSelectionHeaderHeadlineFont(), composerStartRestartGroup, 6);
                    float fM9687constructorimpl7 = Dp.m9687constructorimpl(DatePickerModalTokens.INSTANCE.m5328getRangeSelectionHeaderContainerHeightD9Ej5fM() - HeaderHeightOffset);
                    final FocusRequester focusRequester10 = focusRequester3;
                    final DatePickerColors datePickerColors114 = datePickerColors4;
                    Function2 function13 = new Function2() { // from class: androidx.compose.material3.DateRangePickerKt$$ExternalSyntheticLambda16
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return DateRangePickerKt.DateRangePicker$lambda$6(dateRangePickerState, calendarModel7, datePickerFormatter3, datePickerColors114, focusRequester10, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    };
                    DatePickerFormatter datePickerFormatter10 = datePickerFormatter3;
                    int i113 = i13 >> 9;
                    composer2 = composerStartRestartGroup;
                    DatePickerKt.m3177DateEntryContainerau3_HiA(modifier4, function6, function2RememberComposableLambda2, composableLambdaRememberComposableLambda, datePickerColors4, value7, fM9687constructorimpl7, ComposableLambdaKt.rememberComposableLambda(684885105, true, function13, composerStartRestartGroup, 54), composer2, ((i13 >> 3) & 14) | 14155776 | (i113 & 112) | (i113 & 896) | (57344 & (i13 << 3)));
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    datePickerFormatter2 = datePickerFormatter10;
                    focusRequester2 = focusRequester10;
                    z4 = z6;
                    modifier3 = modifier4;
                    function4 = function6;
                    datePickerColors3 = datePickerColors4;
                } else {
                    composer2 = composerStartRestartGroup;
                    composer2.skipToGroupEnd();
                    datePickerFormatter2 = datePickerFormatter;
                    focusRequester2 = focusRequester;
                    modifier3 = modifier2;
                    datePickerColors3 = datePickerColors2;
                    function4 = function2RememberComposableLambda;
                    z4 = z2;
                }
                function5 = function2RememberComposableLambda2;
                scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.DateRangePickerKt$$ExternalSyntheticLambda17
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return DateRangePickerKt.DateRangePicker$lambda$7(dateRangePickerState, modifier3, datePickerFormatter2, datePickerColors3, function4, function5, z4, focusRequester2, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    });
                }
            }
            i3 |= 1572864;
            z2 = z;
            i10 = i2 & 128;
            if (i10 != 0) {
                i3 |= 12582912;
            } else if ((i & 12582912) == 0) {
                if (composerStartRestartGroup.changed(focusRequester)) {
                    i11 = 8388608;
                } else {
                    i11 = 4194304;
                }
                i3 |= i11;
            }
            if ((i3 & 4793491) != 4793490) {
                z3 = true;
            } else {
                z3 = false;
            }
            if (composerStartRestartGroup.shouldExecute(z3, i3 & 1)) {
                composerStartRestartGroup.startDefaults();
                ComposerKt.sourceInformation(composerStartRestartGroup, "102@4878L47,103@4977L8,104@5026L239,111@5309L409,122@5794L29");
                if ((i & 1) != 0) {
                    if (i15 != 0) {
                        modifier2 = Modifier.INSTANCE;
                    }
                    if ((i2 & 4) != 0) {
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1173533681, "CC(remember):DateRangePicker.kt#9igjgp");
                        objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                        if (objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                            objRememberedValue2 = DatePickerDefaults.dateFormatter$default(DatePickerDefaults.INSTANCE, null, null, null, 7, null);
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                        }
                        datePickerFormatter3 = (DatePickerFormatter) objRememberedValue2;
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        i3 &= -897;
                    } else {
                        datePickerFormatter3 = datePickerFormatter;
                    }
                    if ((i2 & 8) != 0) {
                        datePickerColorsColors = DatePickerDefaults.INSTANCE.colors(composerStartRestartGroup, 6);
                        i3 &= -7169;
                    } else {
                        datePickerColorsColors = datePickerColors2;
                    }
                    if (i4 != 0) {
                        z5 = true;
                        function2RememberComposableLambda = ComposableLambdaKt.rememberComposableLambda(-803011924, true, new Function2() { // from class: androidx.compose.material3.DateRangePickerKt$$ExternalSyntheticLambda13
                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj, Object obj2) {
                                return DateRangePickerKt.DateRangePicker$lambda$1(dateRangePickerState, datePickerColorsColors, (Composer) obj, ((Integer) obj2).intValue());
                            }
                        }, composerStartRestartGroup, 54);
                        i12 = 54;
                    } else {
                        z5 = true;
                        i12 = 54;
                    }
                    if (i6 != 0) {
                        function2RememberComposableLambda2 = ComposableLambdaKt.rememberComposableLambda(-331385278, z5, new Function2() { // from class: androidx.compose.material3.DateRangePickerKt$$ExternalSyntheticLambda14
                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj, Object obj2) {
                                return DateRangePickerKt.DateRangePicker$lambda$2(dateRangePickerState, datePickerFormatter3, datePickerColorsColors, (Composer) obj, ((Integer) obj2).intValue());
                            }
                        }, composerStartRestartGroup, i12);
                    }
                    if (i8 != 0) {
                        z2 = true;
                    }
                    if (i10 != 0) {
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1173504387, "CC(remember):DateRangePicker.kt#9igjgp");
                        objRememberedValue = composerStartRestartGroup.rememberedValue();
                        if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                            objRememberedValue = new FocusRequester();
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                        }
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        DatePickerColors datePickerColors115 = datePickerColorsColors;
                        focusRequester3 = (FocusRequester) objRememberedValue;
                        z6 = z2;
                        datePickerColors4 = datePickerColors115;
                        function6 = function2RememberComposableLambda;
                        modifier4 = modifier2;
                        i13 = i3;
                    } else {
                        function6 = function2RememberComposableLambda;
                        z6 = z2;
                        datePickerColors4 = datePickerColorsColors;
                        modifier4 = modifier2;
                        i13 = i3;
                        focusRequester3 = focusRequester;
                    }
                } else {
                    if (i15 != 0) {
                        modifier2 = Modifier.INSTANCE;
                    }
                    if ((i2 & 4) != 0) {
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1173533681, "CC(remember):DateRangePicker.kt#9igjgp");
                        objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                        if (objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                            objRememberedValue2 = DatePickerDefaults.dateFormatter$default(DatePickerDefaults.INSTANCE, null, null, null, 7, null);
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                        }
                        datePickerFormatter3 = (DatePickerFormatter) objRememberedValue2;
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        i3 &= -897;
                    } else {
                        datePickerFormatter3 = datePickerFormatter;
                    }
                    if ((i2 & 8) != 0) {
                        datePickerColorsColors = DatePickerDefaults.INSTANCE.colors(composerStartRestartGroup, 6);
                        i3 &= -7169;
                    } else {
                        datePickerColorsColors = datePickerColors2;
                    }
                    if (i4 != 0) {
                        z5 = true;
                        function2RememberComposableLambda = ComposableLambdaKt.rememberComposableLambda(-803011924, true, new Function2() { // from class: androidx.compose.material3.DateRangePickerKt$$ExternalSyntheticLambda13
                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj, Object obj2) {
                                return DateRangePickerKt.DateRangePicker$lambda$1(dateRangePickerState, datePickerColorsColors, (Composer) obj, ((Integer) obj2).intValue());
                            }
                        }, composerStartRestartGroup, 54);
                        i12 = 54;
                    } else {
                        z5 = true;
                        i12 = 54;
                    }
                    if (i6 != 0) {
                        function2RememberComposableLambda2 = ComposableLambdaKt.rememberComposableLambda(-331385278, z5, new Function2() { // from class: androidx.compose.material3.DateRangePickerKt$$ExternalSyntheticLambda14
                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj, Object obj2) {
                                return DateRangePickerKt.DateRangePicker$lambda$2(dateRangePickerState, datePickerFormatter3, datePickerColorsColors, (Composer) obj, ((Integer) obj2).intValue());
                            }
                        }, composerStartRestartGroup, i12);
                    }
                    if (i8 != 0) {
                        z2 = true;
                    }
                    if (i10 != 0) {
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1173504387, "CC(remember):DateRangePicker.kt#9igjgp");
                        objRememberedValue = composerStartRestartGroup.rememberedValue();
                        if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                            objRememberedValue = new FocusRequester();
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                        }
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        DatePickerColors datePickerColors116 = datePickerColorsColors;
                        focusRequester3 = (FocusRequester) objRememberedValue;
                        z6 = z2;
                        datePickerColors4 = datePickerColors116;
                        function6 = function2RememberComposableLambda;
                        modifier4 = modifier2;
                        i13 = i3;
                    } else {
                        function6 = function2RememberComposableLambda;
                        z6 = z2;
                        datePickerColors4 = datePickerColorsColors;
                        modifier4 = modifier2;
                        i13 = i3;
                        focusRequester3 = focusRequester;
                    }
                }
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(1969726368, i13, -1, "androidx.compose.material3.DateRangePicker (DateRangePicker.kt:123)");
                }
                Locale locale8 = dateRangePickerState.getLocale();
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1173502065, "CC(remember):DateRangePicker.kt#9igjgp");
                zChanged = composerStartRestartGroup.changed(locale8);
                objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                if (!zChanged) {
                    if (dateRangePickerState instanceof BaseDatePickerStateImpl) {
                        calendarModelCreateCalendarModel = ((BaseDatePickerStateImpl) dateRangePickerState).getCalendarModel();
                    } else {
                        calendarModelCreateCalendarModel = CalendarModel_androidKt.createCalendarModel(dateRangePickerState.getLocale());
                    }
                    objRememberedValue3 = calendarModelCreateCalendarModel;
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                } else {
                    if (dateRangePickerState instanceof BaseDatePickerStateImpl) {
                        calendarModelCreateCalendarModel = ((BaseDatePickerStateImpl) dateRangePickerState).getCalendarModel();
                    } else {
                        calendarModelCreateCalendarModel = CalendarModel_androidKt.createCalendarModel(dateRangePickerState.getLocale());
                    }
                    objRememberedValue3 = calendarModelCreateCalendarModel;
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                }
                final CalendarModel calendarModel8 = (CalendarModel) objRememberedValue3;
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                if (z6) {
                    composerStartRestartGroup.startReplaceGroup(-2018450762);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "138@6251L364");
                    composableLambdaRememberComposableLambda = ComposableLambdaKt.rememberComposableLambda(1343236786, true, new Function2() { // from class: androidx.compose.material3.DateRangePickerKt$$ExternalSyntheticLambda15
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return DateRangePickerKt.DateRangePicker$lambda$5(dateRangePickerState, datePickerColors4, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    }, composerStartRestartGroup, 54);
                    composerStartRestartGroup.endReplaceGroup();
                } else {
                    composerStartRestartGroup.startReplaceGroup(-2018063138);
                    composerStartRestartGroup.endReplaceGroup();
                    composableLambdaRememberComposableLambda = null;
                }
                TextStyle value8 = TypographyKt.getValue(DatePickerModalTokens.INSTANCE.getRangeSelectionHeaderHeadlineFont(), composerStartRestartGroup, 6);
                float fM9687constructorimpl8 = Dp.m9687constructorimpl(DatePickerModalTokens.INSTANCE.m5328getRangeSelectionHeaderContainerHeightD9Ej5fM() - HeaderHeightOffset);
                final FocusRequester focusRequester11 = focusRequester3;
                final DatePickerColors datePickerColors117 = datePickerColors4;
                Function2 function14 = new Function2() { // from class: androidx.compose.material3.DateRangePickerKt$$ExternalSyntheticLambda16
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return DateRangePickerKt.DateRangePicker$lambda$6(dateRangePickerState, calendarModel8, datePickerFormatter3, datePickerColors117, focusRequester11, (Composer) obj, ((Integer) obj2).intValue());
                    }
                };
                DatePickerFormatter datePickerFormatter11 = datePickerFormatter3;
                int i114 = i13 >> 9;
                composer2 = composerStartRestartGroup;
                DatePickerKt.m3177DateEntryContainerau3_HiA(modifier4, function6, function2RememberComposableLambda2, composableLambdaRememberComposableLambda, datePickerColors4, value8, fM9687constructorimpl8, ComposableLambdaKt.rememberComposableLambda(684885105, true, function14, composerStartRestartGroup, 54), composer2, ((i13 >> 3) & 14) | 14155776 | (i114 & 112) | (i114 & 896) | (57344 & (i13 << 3)));
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                datePickerFormatter2 = datePickerFormatter11;
                focusRequester2 = focusRequester11;
                z4 = z6;
                modifier3 = modifier4;
                function4 = function6;
                datePickerColors3 = datePickerColors4;
            } else {
                composer2 = composerStartRestartGroup;
                composer2.skipToGroupEnd();
                datePickerFormatter2 = datePickerFormatter;
                focusRequester2 = focusRequester;
                modifier3 = modifier2;
                datePickerColors3 = datePickerColors2;
                function4 = function2RememberComposableLambda;
                z4 = z2;
            }
            function5 = function2RememberComposableLambda2;
            scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.DateRangePickerKt$$ExternalSyntheticLambda17
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return DateRangePickerKt.DateRangePicker$lambda$7(dateRangePickerState, modifier3, datePickerFormatter2, datePickerColors3, function4, function5, z4, focusRequester2, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                    }
                });
            }
        }
        i3 |= 48;
        modifier2 = modifier;
        if ((i & 384) == 0) {
            if ((i2 & 4) != 0) {
                i14 = 128;
            } else {
                if ((i & 512) == 0) {
                    zChangedInstance = composerStartRestartGroup.changed(datePickerFormatter);
                } else {
                    zChangedInstance = composerStartRestartGroup.changedInstance(datePickerFormatter);
                }
                if (zChangedInstance) {
                    i14 = 256;
                } else {
                    i14 = 128;
                }
            }
            i3 |= i14;
        }
        if ((i & 3072) == 0) {
            if ((i2 & 8) == 0) {
                datePickerColors2 = datePickerColors;
                if (composerStartRestartGroup.changed(datePickerColors2)) {
                }
                i3 |= i16;
            } else {
                datePickerColors2 = datePickerColors;
            }
            i3 |= i16;
        } else {
            datePickerColors2 = datePickerColors;
        }
        i4 = i2 & 16;
        if (i4 != 0) {
            if ((i & 24576) == 0) {
                function2RememberComposableLambda = function2;
                if (composerStartRestartGroup.changedInstance(function2RememberComposableLambda)) {
                    i5 = 16384;
                } else {
                    i5 = 8192;
                }
                i3 |= i5;
            }
            i6 = i2 & 32;
            if (i6 != 0) {
                if ((196608 & i) == 0) {
                    function2RememberComposableLambda2 = function3;
                    if (composerStartRestartGroup.changedInstance(function2RememberComposableLambda2)) {
                        i7 = 131072;
                    } else {
                        i7 = 65536;
                    }
                    i3 |= i7;
                }
                i8 = i2 & 64;
                if (i8 != 0) {
                    if ((1572864 & i) == 0) {
                        z2 = z;
                        if (composerStartRestartGroup.changed(z2)) {
                            i9 = 1048576;
                        } else {
                            i9 = 524288;
                        }
                        i3 |= i9;
                    }
                    i10 = i2 & 128;
                    if (i10 != 0) {
                        i3 |= 12582912;
                    } else if ((i & 12582912) == 0) {
                        if (composerStartRestartGroup.changed(focusRequester)) {
                            i11 = 8388608;
                        } else {
                            i11 = 4194304;
                        }
                        i3 |= i11;
                    }
                    if ((i3 & 4793491) != 4793490) {
                        z3 = true;
                    } else {
                        z3 = false;
                    }
                    if (composerStartRestartGroup.shouldExecute(z3, i3 & 1)) {
                        composerStartRestartGroup.startDefaults();
                        ComposerKt.sourceInformation(composerStartRestartGroup, "102@4878L47,103@4977L8,104@5026L239,111@5309L409,122@5794L29");
                        if ((i & 1) != 0) {
                            if (i15 != 0) {
                                modifier2 = Modifier.INSTANCE;
                            }
                            if ((i2 & 4) != 0) {
                                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1173533681, "CC(remember):DateRangePicker.kt#9igjgp");
                                objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                                if (objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                                    objRememberedValue2 = DatePickerDefaults.dateFormatter$default(DatePickerDefaults.INSTANCE, null, null, null, 7, null);
                                    composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                                }
                                datePickerFormatter3 = (DatePickerFormatter) objRememberedValue2;
                                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                                i3 &= -897;
                            } else {
                                datePickerFormatter3 = datePickerFormatter;
                            }
                            if ((i2 & 8) != 0) {
                                datePickerColorsColors = DatePickerDefaults.INSTANCE.colors(composerStartRestartGroup, 6);
                                i3 &= -7169;
                            } else {
                                datePickerColorsColors = datePickerColors2;
                            }
                            if (i4 != 0) {
                                z5 = true;
                                function2RememberComposableLambda = ComposableLambdaKt.rememberComposableLambda(-803011924, true, new Function2() { // from class: androidx.compose.material3.DateRangePickerKt$$ExternalSyntheticLambda13
                                    @Override // kotlin.jvm.functions.Function2
                                    public final Object invoke(Object obj, Object obj2) {
                                        return DateRangePickerKt.DateRangePicker$lambda$1(dateRangePickerState, datePickerColorsColors, (Composer) obj, ((Integer) obj2).intValue());
                                    }
                                }, composerStartRestartGroup, 54);
                                i12 = 54;
                            } else {
                                z5 = true;
                                i12 = 54;
                            }
                            if (i6 != 0) {
                                function2RememberComposableLambda2 = ComposableLambdaKt.rememberComposableLambda(-331385278, z5, new Function2() { // from class: androidx.compose.material3.DateRangePickerKt$$ExternalSyntheticLambda14
                                    @Override // kotlin.jvm.functions.Function2
                                    public final Object invoke(Object obj, Object obj2) {
                                        return DateRangePickerKt.DateRangePicker$lambda$2(dateRangePickerState, datePickerFormatter3, datePickerColorsColors, (Composer) obj, ((Integer) obj2).intValue());
                                    }
                                }, composerStartRestartGroup, i12);
                            }
                            if (i8 != 0) {
                                z2 = true;
                            }
                            if (i10 != 0) {
                                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1173504387, "CC(remember):DateRangePicker.kt#9igjgp");
                                objRememberedValue = composerStartRestartGroup.rememberedValue();
                                if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                                    objRememberedValue = new FocusRequester();
                                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                                }
                                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                                DatePickerColors datePickerColors118 = datePickerColorsColors;
                                focusRequester3 = (FocusRequester) objRememberedValue;
                                z6 = z2;
                                datePickerColors4 = datePickerColors118;
                                function6 = function2RememberComposableLambda;
                                modifier4 = modifier2;
                                i13 = i3;
                            } else {
                                function6 = function2RememberComposableLambda;
                                z6 = z2;
                                datePickerColors4 = datePickerColorsColors;
                                modifier4 = modifier2;
                                i13 = i3;
                                focusRequester3 = focusRequester;
                            }
                        } else {
                            if (i15 != 0) {
                                modifier2 = Modifier.INSTANCE;
                            }
                            if ((i2 & 4) != 0) {
                                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1173533681, "CC(remember):DateRangePicker.kt#9igjgp");
                                objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                                if (objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                                    objRememberedValue2 = DatePickerDefaults.dateFormatter$default(DatePickerDefaults.INSTANCE, null, null, null, 7, null);
                                    composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                                }
                                datePickerFormatter3 = (DatePickerFormatter) objRememberedValue2;
                                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                                i3 &= -897;
                            } else {
                                datePickerFormatter3 = datePickerFormatter;
                            }
                            if ((i2 & 8) != 0) {
                                datePickerColorsColors = DatePickerDefaults.INSTANCE.colors(composerStartRestartGroup, 6);
                                i3 &= -7169;
                            } else {
                                datePickerColorsColors = datePickerColors2;
                            }
                            if (i4 != 0) {
                                z5 = true;
                                function2RememberComposableLambda = ComposableLambdaKt.rememberComposableLambda(-803011924, true, new Function2() { // from class: androidx.compose.material3.DateRangePickerKt$$ExternalSyntheticLambda13
                                    @Override // kotlin.jvm.functions.Function2
                                    public final Object invoke(Object obj, Object obj2) {
                                        return DateRangePickerKt.DateRangePicker$lambda$1(dateRangePickerState, datePickerColorsColors, (Composer) obj, ((Integer) obj2).intValue());
                                    }
                                }, composerStartRestartGroup, 54);
                                i12 = 54;
                            } else {
                                z5 = true;
                                i12 = 54;
                            }
                            if (i6 != 0) {
                                function2RememberComposableLambda2 = ComposableLambdaKt.rememberComposableLambda(-331385278, z5, new Function2() { // from class: androidx.compose.material3.DateRangePickerKt$$ExternalSyntheticLambda14
                                    @Override // kotlin.jvm.functions.Function2
                                    public final Object invoke(Object obj, Object obj2) {
                                        return DateRangePickerKt.DateRangePicker$lambda$2(dateRangePickerState, datePickerFormatter3, datePickerColorsColors, (Composer) obj, ((Integer) obj2).intValue());
                                    }
                                }, composerStartRestartGroup, i12);
                            }
                            if (i8 != 0) {
                                z2 = true;
                            }
                            if (i10 != 0) {
                                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1173504387, "CC(remember):DateRangePicker.kt#9igjgp");
                                objRememberedValue = composerStartRestartGroup.rememberedValue();
                                if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                                    objRememberedValue = new FocusRequester();
                                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                                }
                                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                                DatePickerColors datePickerColors119 = datePickerColorsColors;
                                focusRequester3 = (FocusRequester) objRememberedValue;
                                z6 = z2;
                                datePickerColors4 = datePickerColors119;
                                function6 = function2RememberComposableLambda;
                                modifier4 = modifier2;
                                i13 = i3;
                            } else {
                                function6 = function2RememberComposableLambda;
                                z6 = z2;
                                datePickerColors4 = datePickerColorsColors;
                                modifier4 = modifier2;
                                i13 = i3;
                                focusRequester3 = focusRequester;
                            }
                        }
                        composerStartRestartGroup.endDefaults();
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(1969726368, i13, -1, "androidx.compose.material3.DateRangePicker (DateRangePicker.kt:123)");
                        }
                        Locale locale9 = dateRangePickerState.getLocale();
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1173502065, "CC(remember):DateRangePicker.kt#9igjgp");
                        zChanged = composerStartRestartGroup.changed(locale9);
                        objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                        if (!zChanged) {
                            if (dateRangePickerState instanceof BaseDatePickerStateImpl) {
                                calendarModelCreateCalendarModel = ((BaseDatePickerStateImpl) dateRangePickerState).getCalendarModel();
                            } else {
                                calendarModelCreateCalendarModel = CalendarModel_androidKt.createCalendarModel(dateRangePickerState.getLocale());
                            }
                            objRememberedValue3 = calendarModelCreateCalendarModel;
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                        } else {
                            if (dateRangePickerState instanceof BaseDatePickerStateImpl) {
                                calendarModelCreateCalendarModel = ((BaseDatePickerStateImpl) dateRangePickerState).getCalendarModel();
                            } else {
                                calendarModelCreateCalendarModel = CalendarModel_androidKt.createCalendarModel(dateRangePickerState.getLocale());
                            }
                            objRememberedValue3 = calendarModelCreateCalendarModel;
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                        }
                        final CalendarModel calendarModel9 = (CalendarModel) objRememberedValue3;
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        if (z6) {
                            composerStartRestartGroup.startReplaceGroup(-2018450762);
                            ComposerKt.sourceInformation(composerStartRestartGroup, "138@6251L364");
                            composableLambdaRememberComposableLambda = ComposableLambdaKt.rememberComposableLambda(1343236786, true, new Function2() { // from class: androidx.compose.material3.DateRangePickerKt$$ExternalSyntheticLambda15
                                @Override // kotlin.jvm.functions.Function2
                                public final Object invoke(Object obj, Object obj2) {
                                    return DateRangePickerKt.DateRangePicker$lambda$5(dateRangePickerState, datePickerColors4, (Composer) obj, ((Integer) obj2).intValue());
                                }
                            }, composerStartRestartGroup, 54);
                            composerStartRestartGroup.endReplaceGroup();
                        } else {
                            composerStartRestartGroup.startReplaceGroup(-2018063138);
                            composerStartRestartGroup.endReplaceGroup();
                            composableLambdaRememberComposableLambda = null;
                        }
                        TextStyle value9 = TypographyKt.getValue(DatePickerModalTokens.INSTANCE.getRangeSelectionHeaderHeadlineFont(), composerStartRestartGroup, 6);
                        float fM9687constructorimpl9 = Dp.m9687constructorimpl(DatePickerModalTokens.INSTANCE.m5328getRangeSelectionHeaderContainerHeightD9Ej5fM() - HeaderHeightOffset);
                        final FocusRequester focusRequester12 = focusRequester3;
                        final DatePickerColors datePickerColors1110 = datePickerColors4;
                        Function2 function15 = new Function2() { // from class: androidx.compose.material3.DateRangePickerKt$$ExternalSyntheticLambda16
                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj, Object obj2) {
                                return DateRangePickerKt.DateRangePicker$lambda$6(dateRangePickerState, calendarModel9, datePickerFormatter3, datePickerColors1110, focusRequester12, (Composer) obj, ((Integer) obj2).intValue());
                            }
                        };
                        DatePickerFormatter datePickerFormatter12 = datePickerFormatter3;
                        int i115 = i13 >> 9;
                        composer2 = composerStartRestartGroup;
                        DatePickerKt.m3177DateEntryContainerau3_HiA(modifier4, function6, function2RememberComposableLambda2, composableLambdaRememberComposableLambda, datePickerColors4, value9, fM9687constructorimpl9, ComposableLambdaKt.rememberComposableLambda(684885105, true, function15, composerStartRestartGroup, 54), composer2, ((i13 >> 3) & 14) | 14155776 | (i115 & 112) | (i115 & 896) | (57344 & (i13 << 3)));
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        datePickerFormatter2 = datePickerFormatter12;
                        focusRequester2 = focusRequester12;
                        z4 = z6;
                        modifier3 = modifier4;
                        function4 = function6;
                        datePickerColors3 = datePickerColors4;
                    } else {
                        composer2 = composerStartRestartGroup;
                        composer2.skipToGroupEnd();
                        datePickerFormatter2 = datePickerFormatter;
                        focusRequester2 = focusRequester;
                        modifier3 = modifier2;
                        datePickerColors3 = datePickerColors2;
                        function4 = function2RememberComposableLambda;
                        z4 = z2;
                    }
                    function5 = function2RememberComposableLambda2;
                    scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup != null) {
                        scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.DateRangePickerKt$$ExternalSyntheticLambda17
                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj, Object obj2) {
                                return DateRangePickerKt.DateRangePicker$lambda$7(dateRangePickerState, modifier3, datePickerFormatter2, datePickerColors3, function4, function5, z4, focusRequester2, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                            }
                        });
                    }
                }
                i3 |= 1572864;
                z2 = z;
                i10 = i2 & 128;
                if (i10 != 0) {
                    i3 |= 12582912;
                } else if ((i & 12582912) == 0) {
                    if (composerStartRestartGroup.changed(focusRequester)) {
                        i11 = 8388608;
                    } else {
                        i11 = 4194304;
                    }
                    i3 |= i11;
                }
                if ((i3 & 4793491) != 4793490) {
                    z3 = true;
                } else {
                    z3 = false;
                }
                if (composerStartRestartGroup.shouldExecute(z3, i3 & 1)) {
                    composerStartRestartGroup.startDefaults();
                    ComposerKt.sourceInformation(composerStartRestartGroup, "102@4878L47,103@4977L8,104@5026L239,111@5309L409,122@5794L29");
                    if ((i & 1) != 0) {
                        if (i15 != 0) {
                            modifier2 = Modifier.INSTANCE;
                        }
                        if ((i2 & 4) != 0) {
                            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1173533681, "CC(remember):DateRangePicker.kt#9igjgp");
                            objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                            if (objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                                objRememberedValue2 = DatePickerDefaults.dateFormatter$default(DatePickerDefaults.INSTANCE, null, null, null, 7, null);
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                            }
                            datePickerFormatter3 = (DatePickerFormatter) objRememberedValue2;
                            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                            i3 &= -897;
                        } else {
                            datePickerFormatter3 = datePickerFormatter;
                        }
                        if ((i2 & 8) != 0) {
                            datePickerColorsColors = DatePickerDefaults.INSTANCE.colors(composerStartRestartGroup, 6);
                            i3 &= -7169;
                        } else {
                            datePickerColorsColors = datePickerColors2;
                        }
                        if (i4 != 0) {
                            z5 = true;
                            function2RememberComposableLambda = ComposableLambdaKt.rememberComposableLambda(-803011924, true, new Function2() { // from class: androidx.compose.material3.DateRangePickerKt$$ExternalSyntheticLambda13
                                @Override // kotlin.jvm.functions.Function2
                                public final Object invoke(Object obj, Object obj2) {
                                    return DateRangePickerKt.DateRangePicker$lambda$1(dateRangePickerState, datePickerColorsColors, (Composer) obj, ((Integer) obj2).intValue());
                                }
                            }, composerStartRestartGroup, 54);
                            i12 = 54;
                        } else {
                            z5 = true;
                            i12 = 54;
                        }
                        if (i6 != 0) {
                            function2RememberComposableLambda2 = ComposableLambdaKt.rememberComposableLambda(-331385278, z5, new Function2() { // from class: androidx.compose.material3.DateRangePickerKt$$ExternalSyntheticLambda14
                                @Override // kotlin.jvm.functions.Function2
                                public final Object invoke(Object obj, Object obj2) {
                                    return DateRangePickerKt.DateRangePicker$lambda$2(dateRangePickerState, datePickerFormatter3, datePickerColorsColors, (Composer) obj, ((Integer) obj2).intValue());
                                }
                            }, composerStartRestartGroup, i12);
                        }
                        if (i8 != 0) {
                            z2 = true;
                        }
                        if (i10 != 0) {
                            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1173504387, "CC(remember):DateRangePicker.kt#9igjgp");
                            objRememberedValue = composerStartRestartGroup.rememberedValue();
                            if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                                objRememberedValue = new FocusRequester();
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                            }
                            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                            DatePickerColors datePickerColors1111 = datePickerColorsColors;
                            focusRequester3 = (FocusRequester) objRememberedValue;
                            z6 = z2;
                            datePickerColors4 = datePickerColors1111;
                            function6 = function2RememberComposableLambda;
                            modifier4 = modifier2;
                            i13 = i3;
                        } else {
                            function6 = function2RememberComposableLambda;
                            z6 = z2;
                            datePickerColors4 = datePickerColorsColors;
                            modifier4 = modifier2;
                            i13 = i3;
                            focusRequester3 = focusRequester;
                        }
                    } else {
                        if (i15 != 0) {
                            modifier2 = Modifier.INSTANCE;
                        }
                        if ((i2 & 4) != 0) {
                            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1173533681, "CC(remember):DateRangePicker.kt#9igjgp");
                            objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                            if (objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                                objRememberedValue2 = DatePickerDefaults.dateFormatter$default(DatePickerDefaults.INSTANCE, null, null, null, 7, null);
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                            }
                            datePickerFormatter3 = (DatePickerFormatter) objRememberedValue2;
                            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                            i3 &= -897;
                        } else {
                            datePickerFormatter3 = datePickerFormatter;
                        }
                        if ((i2 & 8) != 0) {
                            datePickerColorsColors = DatePickerDefaults.INSTANCE.colors(composerStartRestartGroup, 6);
                            i3 &= -7169;
                        } else {
                            datePickerColorsColors = datePickerColors2;
                        }
                        if (i4 != 0) {
                            z5 = true;
                            function2RememberComposableLambda = ComposableLambdaKt.rememberComposableLambda(-803011924, true, new Function2() { // from class: androidx.compose.material3.DateRangePickerKt$$ExternalSyntheticLambda13
                                @Override // kotlin.jvm.functions.Function2
                                public final Object invoke(Object obj, Object obj2) {
                                    return DateRangePickerKt.DateRangePicker$lambda$1(dateRangePickerState, datePickerColorsColors, (Composer) obj, ((Integer) obj2).intValue());
                                }
                            }, composerStartRestartGroup, 54);
                            i12 = 54;
                        } else {
                            z5 = true;
                            i12 = 54;
                        }
                        if (i6 != 0) {
                            function2RememberComposableLambda2 = ComposableLambdaKt.rememberComposableLambda(-331385278, z5, new Function2() { // from class: androidx.compose.material3.DateRangePickerKt$$ExternalSyntheticLambda14
                                @Override // kotlin.jvm.functions.Function2
                                public final Object invoke(Object obj, Object obj2) {
                                    return DateRangePickerKt.DateRangePicker$lambda$2(dateRangePickerState, datePickerFormatter3, datePickerColorsColors, (Composer) obj, ((Integer) obj2).intValue());
                                }
                            }, composerStartRestartGroup, i12);
                        }
                        if (i8 != 0) {
                            z2 = true;
                        }
                        if (i10 != 0) {
                            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1173504387, "CC(remember):DateRangePicker.kt#9igjgp");
                            objRememberedValue = composerStartRestartGroup.rememberedValue();
                            if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                                objRememberedValue = new FocusRequester();
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                            }
                            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                            DatePickerColors datePickerColors1112 = datePickerColorsColors;
                            focusRequester3 = (FocusRequester) objRememberedValue;
                            z6 = z2;
                            datePickerColors4 = datePickerColors1112;
                            function6 = function2RememberComposableLambda;
                            modifier4 = modifier2;
                            i13 = i3;
                        } else {
                            function6 = function2RememberComposableLambda;
                            z6 = z2;
                            datePickerColors4 = datePickerColorsColors;
                            modifier4 = modifier2;
                            i13 = i3;
                            focusRequester3 = focusRequester;
                        }
                    }
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(1969726368, i13, -1, "androidx.compose.material3.DateRangePicker (DateRangePicker.kt:123)");
                    }
                    Locale locale10 = dateRangePickerState.getLocale();
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1173502065, "CC(remember):DateRangePicker.kt#9igjgp");
                    zChanged = composerStartRestartGroup.changed(locale10);
                    objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                    if (!zChanged) {
                        if (dateRangePickerState instanceof BaseDatePickerStateImpl) {
                            calendarModelCreateCalendarModel = ((BaseDatePickerStateImpl) dateRangePickerState).getCalendarModel();
                        } else {
                            calendarModelCreateCalendarModel = CalendarModel_androidKt.createCalendarModel(dateRangePickerState.getLocale());
                        }
                        objRememberedValue3 = calendarModelCreateCalendarModel;
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                    } else {
                        if (dateRangePickerState instanceof BaseDatePickerStateImpl) {
                            calendarModelCreateCalendarModel = ((BaseDatePickerStateImpl) dateRangePickerState).getCalendarModel();
                        } else {
                            calendarModelCreateCalendarModel = CalendarModel_androidKt.createCalendarModel(dateRangePickerState.getLocale());
                        }
                        objRememberedValue3 = calendarModelCreateCalendarModel;
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                    }
                    final CalendarModel calendarModel10 = (CalendarModel) objRememberedValue3;
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    if (z6) {
                        composerStartRestartGroup.startReplaceGroup(-2018450762);
                        ComposerKt.sourceInformation(composerStartRestartGroup, "138@6251L364");
                        composableLambdaRememberComposableLambda = ComposableLambdaKt.rememberComposableLambda(1343236786, true, new Function2() { // from class: androidx.compose.material3.DateRangePickerKt$$ExternalSyntheticLambda15
                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj, Object obj2) {
                                return DateRangePickerKt.DateRangePicker$lambda$5(dateRangePickerState, datePickerColors4, (Composer) obj, ((Integer) obj2).intValue());
                            }
                        }, composerStartRestartGroup, 54);
                        composerStartRestartGroup.endReplaceGroup();
                    } else {
                        composerStartRestartGroup.startReplaceGroup(-2018063138);
                        composerStartRestartGroup.endReplaceGroup();
                        composableLambdaRememberComposableLambda = null;
                    }
                    TextStyle value10 = TypographyKt.getValue(DatePickerModalTokens.INSTANCE.getRangeSelectionHeaderHeadlineFont(), composerStartRestartGroup, 6);
                    float fM9687constructorimpl10 = Dp.m9687constructorimpl(DatePickerModalTokens.INSTANCE.m5328getRangeSelectionHeaderContainerHeightD9Ej5fM() - HeaderHeightOffset);
                    final FocusRequester focusRequester13 = focusRequester3;
                    final DatePickerColors datePickerColors1113 = datePickerColors4;
                    Function2 function16 = new Function2() { // from class: androidx.compose.material3.DateRangePickerKt$$ExternalSyntheticLambda16
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return DateRangePickerKt.DateRangePicker$lambda$6(dateRangePickerState, calendarModel10, datePickerFormatter3, datePickerColors1113, focusRequester13, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    };
                    DatePickerFormatter datePickerFormatter13 = datePickerFormatter3;
                    int i116 = i13 >> 9;
                    composer2 = composerStartRestartGroup;
                    DatePickerKt.m3177DateEntryContainerau3_HiA(modifier4, function6, function2RememberComposableLambda2, composableLambdaRememberComposableLambda, datePickerColors4, value10, fM9687constructorimpl10, ComposableLambdaKt.rememberComposableLambda(684885105, true, function16, composerStartRestartGroup, 54), composer2, ((i13 >> 3) & 14) | 14155776 | (i116 & 112) | (i116 & 896) | (57344 & (i13 << 3)));
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    datePickerFormatter2 = datePickerFormatter13;
                    focusRequester2 = focusRequester13;
                    z4 = z6;
                    modifier3 = modifier4;
                    function4 = function6;
                    datePickerColors3 = datePickerColors4;
                } else {
                    composer2 = composerStartRestartGroup;
                    composer2.skipToGroupEnd();
                    datePickerFormatter2 = datePickerFormatter;
                    focusRequester2 = focusRequester;
                    modifier3 = modifier2;
                    datePickerColors3 = datePickerColors2;
                    function4 = function2RememberComposableLambda;
                    z4 = z2;
                }
                function5 = function2RememberComposableLambda2;
                scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.DateRangePickerKt$$ExternalSyntheticLambda17
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return DateRangePickerKt.DateRangePicker$lambda$7(dateRangePickerState, modifier3, datePickerFormatter2, datePickerColors3, function4, function5, z4, focusRequester2, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    });
                }
            }
            i3 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
            function2RememberComposableLambda2 = function3;
            i8 = i2 & 64;
            if (i8 != 0) {
                if ((1572864 & i) == 0) {
                    z2 = z;
                    if (composerStartRestartGroup.changed(z2)) {
                        i9 = 1048576;
                    } else {
                        i9 = 524288;
                    }
                    i3 |= i9;
                }
                i10 = i2 & 128;
                if (i10 != 0) {
                    i3 |= 12582912;
                } else if ((i & 12582912) == 0) {
                    if (composerStartRestartGroup.changed(focusRequester)) {
                        i11 = 8388608;
                    } else {
                        i11 = 4194304;
                    }
                    i3 |= i11;
                }
                if ((i3 & 4793491) != 4793490) {
                    z3 = true;
                } else {
                    z3 = false;
                }
                if (composerStartRestartGroup.shouldExecute(z3, i3 & 1)) {
                    composerStartRestartGroup.startDefaults();
                    ComposerKt.sourceInformation(composerStartRestartGroup, "102@4878L47,103@4977L8,104@5026L239,111@5309L409,122@5794L29");
                    if ((i & 1) != 0) {
                        if (i15 != 0) {
                            modifier2 = Modifier.INSTANCE;
                        }
                        if ((i2 & 4) != 0) {
                            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1173533681, "CC(remember):DateRangePicker.kt#9igjgp");
                            objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                            if (objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                                objRememberedValue2 = DatePickerDefaults.dateFormatter$default(DatePickerDefaults.INSTANCE, null, null, null, 7, null);
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                            }
                            datePickerFormatter3 = (DatePickerFormatter) objRememberedValue2;
                            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                            i3 &= -897;
                        } else {
                            datePickerFormatter3 = datePickerFormatter;
                        }
                        if ((i2 & 8) != 0) {
                            datePickerColorsColors = DatePickerDefaults.INSTANCE.colors(composerStartRestartGroup, 6);
                            i3 &= -7169;
                        } else {
                            datePickerColorsColors = datePickerColors2;
                        }
                        if (i4 != 0) {
                            z5 = true;
                            function2RememberComposableLambda = ComposableLambdaKt.rememberComposableLambda(-803011924, true, new Function2() { // from class: androidx.compose.material3.DateRangePickerKt$$ExternalSyntheticLambda13
                                @Override // kotlin.jvm.functions.Function2
                                public final Object invoke(Object obj, Object obj2) {
                                    return DateRangePickerKt.DateRangePicker$lambda$1(dateRangePickerState, datePickerColorsColors, (Composer) obj, ((Integer) obj2).intValue());
                                }
                            }, composerStartRestartGroup, 54);
                            i12 = 54;
                        } else {
                            z5 = true;
                            i12 = 54;
                        }
                        if (i6 != 0) {
                            function2RememberComposableLambda2 = ComposableLambdaKt.rememberComposableLambda(-331385278, z5, new Function2() { // from class: androidx.compose.material3.DateRangePickerKt$$ExternalSyntheticLambda14
                                @Override // kotlin.jvm.functions.Function2
                                public final Object invoke(Object obj, Object obj2) {
                                    return DateRangePickerKt.DateRangePicker$lambda$2(dateRangePickerState, datePickerFormatter3, datePickerColorsColors, (Composer) obj, ((Integer) obj2).intValue());
                                }
                            }, composerStartRestartGroup, i12);
                        }
                        if (i8 != 0) {
                            z2 = true;
                        }
                        if (i10 != 0) {
                            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1173504387, "CC(remember):DateRangePicker.kt#9igjgp");
                            objRememberedValue = composerStartRestartGroup.rememberedValue();
                            if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                                objRememberedValue = new FocusRequester();
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                            }
                            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                            DatePickerColors datePickerColors1114 = datePickerColorsColors;
                            focusRequester3 = (FocusRequester) objRememberedValue;
                            z6 = z2;
                            datePickerColors4 = datePickerColors1114;
                            function6 = function2RememberComposableLambda;
                            modifier4 = modifier2;
                            i13 = i3;
                        } else {
                            function6 = function2RememberComposableLambda;
                            z6 = z2;
                            datePickerColors4 = datePickerColorsColors;
                            modifier4 = modifier2;
                            i13 = i3;
                            focusRequester3 = focusRequester;
                        }
                    } else {
                        if (i15 != 0) {
                            modifier2 = Modifier.INSTANCE;
                        }
                        if ((i2 & 4) != 0) {
                            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1173533681, "CC(remember):DateRangePicker.kt#9igjgp");
                            objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                            if (objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                                objRememberedValue2 = DatePickerDefaults.dateFormatter$default(DatePickerDefaults.INSTANCE, null, null, null, 7, null);
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                            }
                            datePickerFormatter3 = (DatePickerFormatter) objRememberedValue2;
                            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                            i3 &= -897;
                        } else {
                            datePickerFormatter3 = datePickerFormatter;
                        }
                        if ((i2 & 8) != 0) {
                            datePickerColorsColors = DatePickerDefaults.INSTANCE.colors(composerStartRestartGroup, 6);
                            i3 &= -7169;
                        } else {
                            datePickerColorsColors = datePickerColors2;
                        }
                        if (i4 != 0) {
                            z5 = true;
                            function2RememberComposableLambda = ComposableLambdaKt.rememberComposableLambda(-803011924, true, new Function2() { // from class: androidx.compose.material3.DateRangePickerKt$$ExternalSyntheticLambda13
                                @Override // kotlin.jvm.functions.Function2
                                public final Object invoke(Object obj, Object obj2) {
                                    return DateRangePickerKt.DateRangePicker$lambda$1(dateRangePickerState, datePickerColorsColors, (Composer) obj, ((Integer) obj2).intValue());
                                }
                            }, composerStartRestartGroup, 54);
                            i12 = 54;
                        } else {
                            z5 = true;
                            i12 = 54;
                        }
                        if (i6 != 0) {
                            function2RememberComposableLambda2 = ComposableLambdaKt.rememberComposableLambda(-331385278, z5, new Function2() { // from class: androidx.compose.material3.DateRangePickerKt$$ExternalSyntheticLambda14
                                @Override // kotlin.jvm.functions.Function2
                                public final Object invoke(Object obj, Object obj2) {
                                    return DateRangePickerKt.DateRangePicker$lambda$2(dateRangePickerState, datePickerFormatter3, datePickerColorsColors, (Composer) obj, ((Integer) obj2).intValue());
                                }
                            }, composerStartRestartGroup, i12);
                        }
                        if (i8 != 0) {
                            z2 = true;
                        }
                        if (i10 != 0) {
                            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1173504387, "CC(remember):DateRangePicker.kt#9igjgp");
                            objRememberedValue = composerStartRestartGroup.rememberedValue();
                            if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                                objRememberedValue = new FocusRequester();
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                            }
                            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                            DatePickerColors datePickerColors1115 = datePickerColorsColors;
                            focusRequester3 = (FocusRequester) objRememberedValue;
                            z6 = z2;
                            datePickerColors4 = datePickerColors1115;
                            function6 = function2RememberComposableLambda;
                            modifier4 = modifier2;
                            i13 = i3;
                        } else {
                            function6 = function2RememberComposableLambda;
                            z6 = z2;
                            datePickerColors4 = datePickerColorsColors;
                            modifier4 = modifier2;
                            i13 = i3;
                            focusRequester3 = focusRequester;
                        }
                    }
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(1969726368, i13, -1, "androidx.compose.material3.DateRangePicker (DateRangePicker.kt:123)");
                    }
                    Locale locale11 = dateRangePickerState.getLocale();
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1173502065, "CC(remember):DateRangePicker.kt#9igjgp");
                    zChanged = composerStartRestartGroup.changed(locale11);
                    objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                    if (!zChanged) {
                        if (dateRangePickerState instanceof BaseDatePickerStateImpl) {
                            calendarModelCreateCalendarModel = ((BaseDatePickerStateImpl) dateRangePickerState).getCalendarModel();
                        } else {
                            calendarModelCreateCalendarModel = CalendarModel_androidKt.createCalendarModel(dateRangePickerState.getLocale());
                        }
                        objRememberedValue3 = calendarModelCreateCalendarModel;
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                    } else {
                        if (dateRangePickerState instanceof BaseDatePickerStateImpl) {
                            calendarModelCreateCalendarModel = ((BaseDatePickerStateImpl) dateRangePickerState).getCalendarModel();
                        } else {
                            calendarModelCreateCalendarModel = CalendarModel_androidKt.createCalendarModel(dateRangePickerState.getLocale());
                        }
                        objRememberedValue3 = calendarModelCreateCalendarModel;
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                    }
                    final CalendarModel calendarModel11 = (CalendarModel) objRememberedValue3;
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    if (z6) {
                        composerStartRestartGroup.startReplaceGroup(-2018450762);
                        ComposerKt.sourceInformation(composerStartRestartGroup, "138@6251L364");
                        composableLambdaRememberComposableLambda = ComposableLambdaKt.rememberComposableLambda(1343236786, true, new Function2() { // from class: androidx.compose.material3.DateRangePickerKt$$ExternalSyntheticLambda15
                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj, Object obj2) {
                                return DateRangePickerKt.DateRangePicker$lambda$5(dateRangePickerState, datePickerColors4, (Composer) obj, ((Integer) obj2).intValue());
                            }
                        }, composerStartRestartGroup, 54);
                        composerStartRestartGroup.endReplaceGroup();
                    } else {
                        composerStartRestartGroup.startReplaceGroup(-2018063138);
                        composerStartRestartGroup.endReplaceGroup();
                        composableLambdaRememberComposableLambda = null;
                    }
                    TextStyle value11 = TypographyKt.getValue(DatePickerModalTokens.INSTANCE.getRangeSelectionHeaderHeadlineFont(), composerStartRestartGroup, 6);
                    float fM9687constructorimpl11 = Dp.m9687constructorimpl(DatePickerModalTokens.INSTANCE.m5328getRangeSelectionHeaderContainerHeightD9Ej5fM() - HeaderHeightOffset);
                    final FocusRequester focusRequester14 = focusRequester3;
                    final DatePickerColors datePickerColors1116 = datePickerColors4;
                    Function2 function17 = new Function2() { // from class: androidx.compose.material3.DateRangePickerKt$$ExternalSyntheticLambda16
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return DateRangePickerKt.DateRangePicker$lambda$6(dateRangePickerState, calendarModel11, datePickerFormatter3, datePickerColors1116, focusRequester14, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    };
                    DatePickerFormatter datePickerFormatter14 = datePickerFormatter3;
                    int i117 = i13 >> 9;
                    composer2 = composerStartRestartGroup;
                    DatePickerKt.m3177DateEntryContainerau3_HiA(modifier4, function6, function2RememberComposableLambda2, composableLambdaRememberComposableLambda, datePickerColors4, value11, fM9687constructorimpl11, ComposableLambdaKt.rememberComposableLambda(684885105, true, function17, composerStartRestartGroup, 54), composer2, ((i13 >> 3) & 14) | 14155776 | (i117 & 112) | (i117 & 896) | (57344 & (i13 << 3)));
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    datePickerFormatter2 = datePickerFormatter14;
                    focusRequester2 = focusRequester14;
                    z4 = z6;
                    modifier3 = modifier4;
                    function4 = function6;
                    datePickerColors3 = datePickerColors4;
                } else {
                    composer2 = composerStartRestartGroup;
                    composer2.skipToGroupEnd();
                    datePickerFormatter2 = datePickerFormatter;
                    focusRequester2 = focusRequester;
                    modifier3 = modifier2;
                    datePickerColors3 = datePickerColors2;
                    function4 = function2RememberComposableLambda;
                    z4 = z2;
                }
                function5 = function2RememberComposableLambda2;
                scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.DateRangePickerKt$$ExternalSyntheticLambda17
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return DateRangePickerKt.DateRangePicker$lambda$7(dateRangePickerState, modifier3, datePickerFormatter2, datePickerColors3, function4, function5, z4, focusRequester2, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    });
                }
            }
            i3 |= 1572864;
            z2 = z;
            i10 = i2 & 128;
            if (i10 != 0) {
                i3 |= 12582912;
            } else if ((i & 12582912) == 0) {
                if (composerStartRestartGroup.changed(focusRequester)) {
                    i11 = 8388608;
                } else {
                    i11 = 4194304;
                }
                i3 |= i11;
            }
            if ((i3 & 4793491) != 4793490) {
                z3 = true;
            } else {
                z3 = false;
            }
            if (composerStartRestartGroup.shouldExecute(z3, i3 & 1)) {
                composerStartRestartGroup.startDefaults();
                ComposerKt.sourceInformation(composerStartRestartGroup, "102@4878L47,103@4977L8,104@5026L239,111@5309L409,122@5794L29");
                if ((i & 1) != 0) {
                    if (i15 != 0) {
                        modifier2 = Modifier.INSTANCE;
                    }
                    if ((i2 & 4) != 0) {
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1173533681, "CC(remember):DateRangePicker.kt#9igjgp");
                        objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                        if (objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                            objRememberedValue2 = DatePickerDefaults.dateFormatter$default(DatePickerDefaults.INSTANCE, null, null, null, 7, null);
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                        }
                        datePickerFormatter3 = (DatePickerFormatter) objRememberedValue2;
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        i3 &= -897;
                    } else {
                        datePickerFormatter3 = datePickerFormatter;
                    }
                    if ((i2 & 8) != 0) {
                        datePickerColorsColors = DatePickerDefaults.INSTANCE.colors(composerStartRestartGroup, 6);
                        i3 &= -7169;
                    } else {
                        datePickerColorsColors = datePickerColors2;
                    }
                    if (i4 != 0) {
                        z5 = true;
                        function2RememberComposableLambda = ComposableLambdaKt.rememberComposableLambda(-803011924, true, new Function2() { // from class: androidx.compose.material3.DateRangePickerKt$$ExternalSyntheticLambda13
                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj, Object obj2) {
                                return DateRangePickerKt.DateRangePicker$lambda$1(dateRangePickerState, datePickerColorsColors, (Composer) obj, ((Integer) obj2).intValue());
                            }
                        }, composerStartRestartGroup, 54);
                        i12 = 54;
                    } else {
                        z5 = true;
                        i12 = 54;
                    }
                    if (i6 != 0) {
                        function2RememberComposableLambda2 = ComposableLambdaKt.rememberComposableLambda(-331385278, z5, new Function2() { // from class: androidx.compose.material3.DateRangePickerKt$$ExternalSyntheticLambda14
                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj, Object obj2) {
                                return DateRangePickerKt.DateRangePicker$lambda$2(dateRangePickerState, datePickerFormatter3, datePickerColorsColors, (Composer) obj, ((Integer) obj2).intValue());
                            }
                        }, composerStartRestartGroup, i12);
                    }
                    if (i8 != 0) {
                        z2 = true;
                    }
                    if (i10 != 0) {
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1173504387, "CC(remember):DateRangePicker.kt#9igjgp");
                        objRememberedValue = composerStartRestartGroup.rememberedValue();
                        if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                            objRememberedValue = new FocusRequester();
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                        }
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        DatePickerColors datePickerColors1117 = datePickerColorsColors;
                        focusRequester3 = (FocusRequester) objRememberedValue;
                        z6 = z2;
                        datePickerColors4 = datePickerColors1117;
                        function6 = function2RememberComposableLambda;
                        modifier4 = modifier2;
                        i13 = i3;
                    } else {
                        function6 = function2RememberComposableLambda;
                        z6 = z2;
                        datePickerColors4 = datePickerColorsColors;
                        modifier4 = modifier2;
                        i13 = i3;
                        focusRequester3 = focusRequester;
                    }
                } else {
                    if (i15 != 0) {
                        modifier2 = Modifier.INSTANCE;
                    }
                    if ((i2 & 4) != 0) {
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1173533681, "CC(remember):DateRangePicker.kt#9igjgp");
                        objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                        if (objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                            objRememberedValue2 = DatePickerDefaults.dateFormatter$default(DatePickerDefaults.INSTANCE, null, null, null, 7, null);
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                        }
                        datePickerFormatter3 = (DatePickerFormatter) objRememberedValue2;
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        i3 &= -897;
                    } else {
                        datePickerFormatter3 = datePickerFormatter;
                    }
                    if ((i2 & 8) != 0) {
                        datePickerColorsColors = DatePickerDefaults.INSTANCE.colors(composerStartRestartGroup, 6);
                        i3 &= -7169;
                    } else {
                        datePickerColorsColors = datePickerColors2;
                    }
                    if (i4 != 0) {
                        z5 = true;
                        function2RememberComposableLambda = ComposableLambdaKt.rememberComposableLambda(-803011924, true, new Function2() { // from class: androidx.compose.material3.DateRangePickerKt$$ExternalSyntheticLambda13
                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj, Object obj2) {
                                return DateRangePickerKt.DateRangePicker$lambda$1(dateRangePickerState, datePickerColorsColors, (Composer) obj, ((Integer) obj2).intValue());
                            }
                        }, composerStartRestartGroup, 54);
                        i12 = 54;
                    } else {
                        z5 = true;
                        i12 = 54;
                    }
                    if (i6 != 0) {
                        function2RememberComposableLambda2 = ComposableLambdaKt.rememberComposableLambda(-331385278, z5, new Function2() { // from class: androidx.compose.material3.DateRangePickerKt$$ExternalSyntheticLambda14
                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj, Object obj2) {
                                return DateRangePickerKt.DateRangePicker$lambda$2(dateRangePickerState, datePickerFormatter3, datePickerColorsColors, (Composer) obj, ((Integer) obj2).intValue());
                            }
                        }, composerStartRestartGroup, i12);
                    }
                    if (i8 != 0) {
                        z2 = true;
                    }
                    if (i10 != 0) {
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1173504387, "CC(remember):DateRangePicker.kt#9igjgp");
                        objRememberedValue = composerStartRestartGroup.rememberedValue();
                        if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                            objRememberedValue = new FocusRequester();
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                        }
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        DatePickerColors datePickerColors1118 = datePickerColorsColors;
                        focusRequester3 = (FocusRequester) objRememberedValue;
                        z6 = z2;
                        datePickerColors4 = datePickerColors1118;
                        function6 = function2RememberComposableLambda;
                        modifier4 = modifier2;
                        i13 = i3;
                    } else {
                        function6 = function2RememberComposableLambda;
                        z6 = z2;
                        datePickerColors4 = datePickerColorsColors;
                        modifier4 = modifier2;
                        i13 = i3;
                        focusRequester3 = focusRequester;
                    }
                }
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(1969726368, i13, -1, "androidx.compose.material3.DateRangePicker (DateRangePicker.kt:123)");
                }
                Locale locale12 = dateRangePickerState.getLocale();
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1173502065, "CC(remember):DateRangePicker.kt#9igjgp");
                zChanged = composerStartRestartGroup.changed(locale12);
                objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                if (!zChanged) {
                    if (dateRangePickerState instanceof BaseDatePickerStateImpl) {
                        calendarModelCreateCalendarModel = ((BaseDatePickerStateImpl) dateRangePickerState).getCalendarModel();
                    } else {
                        calendarModelCreateCalendarModel = CalendarModel_androidKt.createCalendarModel(dateRangePickerState.getLocale());
                    }
                    objRememberedValue3 = calendarModelCreateCalendarModel;
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                } else {
                    if (dateRangePickerState instanceof BaseDatePickerStateImpl) {
                        calendarModelCreateCalendarModel = ((BaseDatePickerStateImpl) dateRangePickerState).getCalendarModel();
                    } else {
                        calendarModelCreateCalendarModel = CalendarModel_androidKt.createCalendarModel(dateRangePickerState.getLocale());
                    }
                    objRememberedValue3 = calendarModelCreateCalendarModel;
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                }
                final CalendarModel calendarModel12 = (CalendarModel) objRememberedValue3;
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                if (z6) {
                    composerStartRestartGroup.startReplaceGroup(-2018450762);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "138@6251L364");
                    composableLambdaRememberComposableLambda = ComposableLambdaKt.rememberComposableLambda(1343236786, true, new Function2() { // from class: androidx.compose.material3.DateRangePickerKt$$ExternalSyntheticLambda15
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return DateRangePickerKt.DateRangePicker$lambda$5(dateRangePickerState, datePickerColors4, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    }, composerStartRestartGroup, 54);
                    composerStartRestartGroup.endReplaceGroup();
                } else {
                    composerStartRestartGroup.startReplaceGroup(-2018063138);
                    composerStartRestartGroup.endReplaceGroup();
                    composableLambdaRememberComposableLambda = null;
                }
                TextStyle value12 = TypographyKt.getValue(DatePickerModalTokens.INSTANCE.getRangeSelectionHeaderHeadlineFont(), composerStartRestartGroup, 6);
                float fM9687constructorimpl12 = Dp.m9687constructorimpl(DatePickerModalTokens.INSTANCE.m5328getRangeSelectionHeaderContainerHeightD9Ej5fM() - HeaderHeightOffset);
                final FocusRequester focusRequester15 = focusRequester3;
                final DatePickerColors datePickerColors1119 = datePickerColors4;
                Function2 function18 = new Function2() { // from class: androidx.compose.material3.DateRangePickerKt$$ExternalSyntheticLambda16
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return DateRangePickerKt.DateRangePicker$lambda$6(dateRangePickerState, calendarModel12, datePickerFormatter3, datePickerColors1119, focusRequester15, (Composer) obj, ((Integer) obj2).intValue());
                    }
                };
                DatePickerFormatter datePickerFormatter15 = datePickerFormatter3;
                int i118 = i13 >> 9;
                composer2 = composerStartRestartGroup;
                DatePickerKt.m3177DateEntryContainerau3_HiA(modifier4, function6, function2RememberComposableLambda2, composableLambdaRememberComposableLambda, datePickerColors4, value12, fM9687constructorimpl12, ComposableLambdaKt.rememberComposableLambda(684885105, true, function18, composerStartRestartGroup, 54), composer2, ((i13 >> 3) & 14) | 14155776 | (i118 & 112) | (i118 & 896) | (57344 & (i13 << 3)));
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                datePickerFormatter2 = datePickerFormatter15;
                focusRequester2 = focusRequester15;
                z4 = z6;
                modifier3 = modifier4;
                function4 = function6;
                datePickerColors3 = datePickerColors4;
            } else {
                composer2 = composerStartRestartGroup;
                composer2.skipToGroupEnd();
                datePickerFormatter2 = datePickerFormatter;
                focusRequester2 = focusRequester;
                modifier3 = modifier2;
                datePickerColors3 = datePickerColors2;
                function4 = function2RememberComposableLambda;
                z4 = z2;
            }
            function5 = function2RememberComposableLambda2;
            scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.DateRangePickerKt$$ExternalSyntheticLambda17
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return DateRangePickerKt.DateRangePicker$lambda$7(dateRangePickerState, modifier3, datePickerFormatter2, datePickerColors3, function4, function5, z4, focusRequester2, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                    }
                });
            }
        }
        i3 |= 24576;
        function2RememberComposableLambda = function2;
        i6 = i2 & 32;
        if (i6 != 0) {
            if ((196608 & i) == 0) {
                function2RememberComposableLambda2 = function3;
                if (composerStartRestartGroup.changedInstance(function2RememberComposableLambda2)) {
                    i7 = 131072;
                } else {
                    i7 = 65536;
                }
                i3 |= i7;
            }
            i8 = i2 & 64;
            if (i8 != 0) {
                if ((1572864 & i) == 0) {
                    z2 = z;
                    if (composerStartRestartGroup.changed(z2)) {
                        i9 = 1048576;
                    } else {
                        i9 = 524288;
                    }
                    i3 |= i9;
                }
                i10 = i2 & 128;
                if (i10 != 0) {
                    i3 |= 12582912;
                } else if ((i & 12582912) == 0) {
                    if (composerStartRestartGroup.changed(focusRequester)) {
                        i11 = 8388608;
                    } else {
                        i11 = 4194304;
                    }
                    i3 |= i11;
                }
                if ((i3 & 4793491) != 4793490) {
                    z3 = true;
                } else {
                    z3 = false;
                }
                if (composerStartRestartGroup.shouldExecute(z3, i3 & 1)) {
                    composerStartRestartGroup.startDefaults();
                    ComposerKt.sourceInformation(composerStartRestartGroup, "102@4878L47,103@4977L8,104@5026L239,111@5309L409,122@5794L29");
                    if ((i & 1) != 0) {
                        if (i15 != 0) {
                            modifier2 = Modifier.INSTANCE;
                        }
                        if ((i2 & 4) != 0) {
                            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1173533681, "CC(remember):DateRangePicker.kt#9igjgp");
                            objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                            if (objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                                objRememberedValue2 = DatePickerDefaults.dateFormatter$default(DatePickerDefaults.INSTANCE, null, null, null, 7, null);
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                            }
                            datePickerFormatter3 = (DatePickerFormatter) objRememberedValue2;
                            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                            i3 &= -897;
                        } else {
                            datePickerFormatter3 = datePickerFormatter;
                        }
                        if ((i2 & 8) != 0) {
                            datePickerColorsColors = DatePickerDefaults.INSTANCE.colors(composerStartRestartGroup, 6);
                            i3 &= -7169;
                        } else {
                            datePickerColorsColors = datePickerColors2;
                        }
                        if (i4 != 0) {
                            z5 = true;
                            function2RememberComposableLambda = ComposableLambdaKt.rememberComposableLambda(-803011924, true, new Function2() { // from class: androidx.compose.material3.DateRangePickerKt$$ExternalSyntheticLambda13
                                @Override // kotlin.jvm.functions.Function2
                                public final Object invoke(Object obj, Object obj2) {
                                    return DateRangePickerKt.DateRangePicker$lambda$1(dateRangePickerState, datePickerColorsColors, (Composer) obj, ((Integer) obj2).intValue());
                                }
                            }, composerStartRestartGroup, 54);
                            i12 = 54;
                        } else {
                            z5 = true;
                            i12 = 54;
                        }
                        if (i6 != 0) {
                            function2RememberComposableLambda2 = ComposableLambdaKt.rememberComposableLambda(-331385278, z5, new Function2() { // from class: androidx.compose.material3.DateRangePickerKt$$ExternalSyntheticLambda14
                                @Override // kotlin.jvm.functions.Function2
                                public final Object invoke(Object obj, Object obj2) {
                                    return DateRangePickerKt.DateRangePicker$lambda$2(dateRangePickerState, datePickerFormatter3, datePickerColorsColors, (Composer) obj, ((Integer) obj2).intValue());
                                }
                            }, composerStartRestartGroup, i12);
                        }
                        if (i8 != 0) {
                            z2 = true;
                        }
                        if (i10 != 0) {
                            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1173504387, "CC(remember):DateRangePicker.kt#9igjgp");
                            objRememberedValue = composerStartRestartGroup.rememberedValue();
                            if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                                objRememberedValue = new FocusRequester();
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                            }
                            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                            DatePickerColors datePickerColors11110 = datePickerColorsColors;
                            focusRequester3 = (FocusRequester) objRememberedValue;
                            z6 = z2;
                            datePickerColors4 = datePickerColors11110;
                            function6 = function2RememberComposableLambda;
                            modifier4 = modifier2;
                            i13 = i3;
                        } else {
                            function6 = function2RememberComposableLambda;
                            z6 = z2;
                            datePickerColors4 = datePickerColorsColors;
                            modifier4 = modifier2;
                            i13 = i3;
                            focusRequester3 = focusRequester;
                        }
                    } else {
                        if (i15 != 0) {
                            modifier2 = Modifier.INSTANCE;
                        }
                        if ((i2 & 4) != 0) {
                            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1173533681, "CC(remember):DateRangePicker.kt#9igjgp");
                            objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                            if (objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                                objRememberedValue2 = DatePickerDefaults.dateFormatter$default(DatePickerDefaults.INSTANCE, null, null, null, 7, null);
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                            }
                            datePickerFormatter3 = (DatePickerFormatter) objRememberedValue2;
                            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                            i3 &= -897;
                        } else {
                            datePickerFormatter3 = datePickerFormatter;
                        }
                        if ((i2 & 8) != 0) {
                            datePickerColorsColors = DatePickerDefaults.INSTANCE.colors(composerStartRestartGroup, 6);
                            i3 &= -7169;
                        } else {
                            datePickerColorsColors = datePickerColors2;
                        }
                        if (i4 != 0) {
                            z5 = true;
                            function2RememberComposableLambda = ComposableLambdaKt.rememberComposableLambda(-803011924, true, new Function2() { // from class: androidx.compose.material3.DateRangePickerKt$$ExternalSyntheticLambda13
                                @Override // kotlin.jvm.functions.Function2
                                public final Object invoke(Object obj, Object obj2) {
                                    return DateRangePickerKt.DateRangePicker$lambda$1(dateRangePickerState, datePickerColorsColors, (Composer) obj, ((Integer) obj2).intValue());
                                }
                            }, composerStartRestartGroup, 54);
                            i12 = 54;
                        } else {
                            z5 = true;
                            i12 = 54;
                        }
                        if (i6 != 0) {
                            function2RememberComposableLambda2 = ComposableLambdaKt.rememberComposableLambda(-331385278, z5, new Function2() { // from class: androidx.compose.material3.DateRangePickerKt$$ExternalSyntheticLambda14
                                @Override // kotlin.jvm.functions.Function2
                                public final Object invoke(Object obj, Object obj2) {
                                    return DateRangePickerKt.DateRangePicker$lambda$2(dateRangePickerState, datePickerFormatter3, datePickerColorsColors, (Composer) obj, ((Integer) obj2).intValue());
                                }
                            }, composerStartRestartGroup, i12);
                        }
                        if (i8 != 0) {
                            z2 = true;
                        }
                        if (i10 != 0) {
                            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1173504387, "CC(remember):DateRangePicker.kt#9igjgp");
                            objRememberedValue = composerStartRestartGroup.rememberedValue();
                            if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                                objRememberedValue = new FocusRequester();
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                            }
                            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                            DatePickerColors datePickerColors11111 = datePickerColorsColors;
                            focusRequester3 = (FocusRequester) objRememberedValue;
                            z6 = z2;
                            datePickerColors4 = datePickerColors11111;
                            function6 = function2RememberComposableLambda;
                            modifier4 = modifier2;
                            i13 = i3;
                        } else {
                            function6 = function2RememberComposableLambda;
                            z6 = z2;
                            datePickerColors4 = datePickerColorsColors;
                            modifier4 = modifier2;
                            i13 = i3;
                            focusRequester3 = focusRequester;
                        }
                    }
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(1969726368, i13, -1, "androidx.compose.material3.DateRangePicker (DateRangePicker.kt:123)");
                    }
                    Locale locale13 = dateRangePickerState.getLocale();
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1173502065, "CC(remember):DateRangePicker.kt#9igjgp");
                    zChanged = composerStartRestartGroup.changed(locale13);
                    objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                    if (!zChanged) {
                        if (dateRangePickerState instanceof BaseDatePickerStateImpl) {
                            calendarModelCreateCalendarModel = ((BaseDatePickerStateImpl) dateRangePickerState).getCalendarModel();
                        } else {
                            calendarModelCreateCalendarModel = CalendarModel_androidKt.createCalendarModel(dateRangePickerState.getLocale());
                        }
                        objRememberedValue3 = calendarModelCreateCalendarModel;
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                    } else {
                        if (dateRangePickerState instanceof BaseDatePickerStateImpl) {
                            calendarModelCreateCalendarModel = ((BaseDatePickerStateImpl) dateRangePickerState).getCalendarModel();
                        } else {
                            calendarModelCreateCalendarModel = CalendarModel_androidKt.createCalendarModel(dateRangePickerState.getLocale());
                        }
                        objRememberedValue3 = calendarModelCreateCalendarModel;
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                    }
                    final CalendarModel calendarModel13 = (CalendarModel) objRememberedValue3;
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    if (z6) {
                        composerStartRestartGroup.startReplaceGroup(-2018450762);
                        ComposerKt.sourceInformation(composerStartRestartGroup, "138@6251L364");
                        composableLambdaRememberComposableLambda = ComposableLambdaKt.rememberComposableLambda(1343236786, true, new Function2() { // from class: androidx.compose.material3.DateRangePickerKt$$ExternalSyntheticLambda15
                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj, Object obj2) {
                                return DateRangePickerKt.DateRangePicker$lambda$5(dateRangePickerState, datePickerColors4, (Composer) obj, ((Integer) obj2).intValue());
                            }
                        }, composerStartRestartGroup, 54);
                        composerStartRestartGroup.endReplaceGroup();
                    } else {
                        composerStartRestartGroup.startReplaceGroup(-2018063138);
                        composerStartRestartGroup.endReplaceGroup();
                        composableLambdaRememberComposableLambda = null;
                    }
                    TextStyle value13 = TypographyKt.getValue(DatePickerModalTokens.INSTANCE.getRangeSelectionHeaderHeadlineFont(), composerStartRestartGroup, 6);
                    float fM9687constructorimpl13 = Dp.m9687constructorimpl(DatePickerModalTokens.INSTANCE.m5328getRangeSelectionHeaderContainerHeightD9Ej5fM() - HeaderHeightOffset);
                    final FocusRequester focusRequester16 = focusRequester3;
                    final DatePickerColors datePickerColors11112 = datePickerColors4;
                    Function2 function19 = new Function2() { // from class: androidx.compose.material3.DateRangePickerKt$$ExternalSyntheticLambda16
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return DateRangePickerKt.DateRangePicker$lambda$6(dateRangePickerState, calendarModel13, datePickerFormatter3, datePickerColors11112, focusRequester16, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    };
                    DatePickerFormatter datePickerFormatter16 = datePickerFormatter3;
                    int i119 = i13 >> 9;
                    composer2 = composerStartRestartGroup;
                    DatePickerKt.m3177DateEntryContainerau3_HiA(modifier4, function6, function2RememberComposableLambda2, composableLambdaRememberComposableLambda, datePickerColors4, value13, fM9687constructorimpl13, ComposableLambdaKt.rememberComposableLambda(684885105, true, function19, composerStartRestartGroup, 54), composer2, ((i13 >> 3) & 14) | 14155776 | (i119 & 112) | (i119 & 896) | (57344 & (i13 << 3)));
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    datePickerFormatter2 = datePickerFormatter16;
                    focusRequester2 = focusRequester16;
                    z4 = z6;
                    modifier3 = modifier4;
                    function4 = function6;
                    datePickerColors3 = datePickerColors4;
                } else {
                    composer2 = composerStartRestartGroup;
                    composer2.skipToGroupEnd();
                    datePickerFormatter2 = datePickerFormatter;
                    focusRequester2 = focusRequester;
                    modifier3 = modifier2;
                    datePickerColors3 = datePickerColors2;
                    function4 = function2RememberComposableLambda;
                    z4 = z2;
                }
                function5 = function2RememberComposableLambda2;
                scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.DateRangePickerKt$$ExternalSyntheticLambda17
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return DateRangePickerKt.DateRangePicker$lambda$7(dateRangePickerState, modifier3, datePickerFormatter2, datePickerColors3, function4, function5, z4, focusRequester2, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    });
                }
            }
            i3 |= 1572864;
            z2 = z;
            i10 = i2 & 128;
            if (i10 != 0) {
                i3 |= 12582912;
            } else if ((i & 12582912) == 0) {
                if (composerStartRestartGroup.changed(focusRequester)) {
                    i11 = 8388608;
                } else {
                    i11 = 4194304;
                }
                i3 |= i11;
            }
            if ((i3 & 4793491) != 4793490) {
                z3 = true;
            } else {
                z3 = false;
            }
            if (composerStartRestartGroup.shouldExecute(z3, i3 & 1)) {
                composerStartRestartGroup.startDefaults();
                ComposerKt.sourceInformation(composerStartRestartGroup, "102@4878L47,103@4977L8,104@5026L239,111@5309L409,122@5794L29");
                if ((i & 1) != 0) {
                    if (i15 != 0) {
                        modifier2 = Modifier.INSTANCE;
                    }
                    if ((i2 & 4) != 0) {
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1173533681, "CC(remember):DateRangePicker.kt#9igjgp");
                        objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                        if (objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                            objRememberedValue2 = DatePickerDefaults.dateFormatter$default(DatePickerDefaults.INSTANCE, null, null, null, 7, null);
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                        }
                        datePickerFormatter3 = (DatePickerFormatter) objRememberedValue2;
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        i3 &= -897;
                    } else {
                        datePickerFormatter3 = datePickerFormatter;
                    }
                    if ((i2 & 8) != 0) {
                        datePickerColorsColors = DatePickerDefaults.INSTANCE.colors(composerStartRestartGroup, 6);
                        i3 &= -7169;
                    } else {
                        datePickerColorsColors = datePickerColors2;
                    }
                    if (i4 != 0) {
                        z5 = true;
                        function2RememberComposableLambda = ComposableLambdaKt.rememberComposableLambda(-803011924, true, new Function2() { // from class: androidx.compose.material3.DateRangePickerKt$$ExternalSyntheticLambda13
                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj, Object obj2) {
                                return DateRangePickerKt.DateRangePicker$lambda$1(dateRangePickerState, datePickerColorsColors, (Composer) obj, ((Integer) obj2).intValue());
                            }
                        }, composerStartRestartGroup, 54);
                        i12 = 54;
                    } else {
                        z5 = true;
                        i12 = 54;
                    }
                    if (i6 != 0) {
                        function2RememberComposableLambda2 = ComposableLambdaKt.rememberComposableLambda(-331385278, z5, new Function2() { // from class: androidx.compose.material3.DateRangePickerKt$$ExternalSyntheticLambda14
                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj, Object obj2) {
                                return DateRangePickerKt.DateRangePicker$lambda$2(dateRangePickerState, datePickerFormatter3, datePickerColorsColors, (Composer) obj, ((Integer) obj2).intValue());
                            }
                        }, composerStartRestartGroup, i12);
                    }
                    if (i8 != 0) {
                        z2 = true;
                    }
                    if (i10 != 0) {
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1173504387, "CC(remember):DateRangePicker.kt#9igjgp");
                        objRememberedValue = composerStartRestartGroup.rememberedValue();
                        if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                            objRememberedValue = new FocusRequester();
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                        }
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        DatePickerColors datePickerColors11113 = datePickerColorsColors;
                        focusRequester3 = (FocusRequester) objRememberedValue;
                        z6 = z2;
                        datePickerColors4 = datePickerColors11113;
                        function6 = function2RememberComposableLambda;
                        modifier4 = modifier2;
                        i13 = i3;
                    } else {
                        function6 = function2RememberComposableLambda;
                        z6 = z2;
                        datePickerColors4 = datePickerColorsColors;
                        modifier4 = modifier2;
                        i13 = i3;
                        focusRequester3 = focusRequester;
                    }
                } else {
                    if (i15 != 0) {
                        modifier2 = Modifier.INSTANCE;
                    }
                    if ((i2 & 4) != 0) {
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1173533681, "CC(remember):DateRangePicker.kt#9igjgp");
                        objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                        if (objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                            objRememberedValue2 = DatePickerDefaults.dateFormatter$default(DatePickerDefaults.INSTANCE, null, null, null, 7, null);
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                        }
                        datePickerFormatter3 = (DatePickerFormatter) objRememberedValue2;
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        i3 &= -897;
                    } else {
                        datePickerFormatter3 = datePickerFormatter;
                    }
                    if ((i2 & 8) != 0) {
                        datePickerColorsColors = DatePickerDefaults.INSTANCE.colors(composerStartRestartGroup, 6);
                        i3 &= -7169;
                    } else {
                        datePickerColorsColors = datePickerColors2;
                    }
                    if (i4 != 0) {
                        z5 = true;
                        function2RememberComposableLambda = ComposableLambdaKt.rememberComposableLambda(-803011924, true, new Function2() { // from class: androidx.compose.material3.DateRangePickerKt$$ExternalSyntheticLambda13
                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj, Object obj2) {
                                return DateRangePickerKt.DateRangePicker$lambda$1(dateRangePickerState, datePickerColorsColors, (Composer) obj, ((Integer) obj2).intValue());
                            }
                        }, composerStartRestartGroup, 54);
                        i12 = 54;
                    } else {
                        z5 = true;
                        i12 = 54;
                    }
                    if (i6 != 0) {
                        function2RememberComposableLambda2 = ComposableLambdaKt.rememberComposableLambda(-331385278, z5, new Function2() { // from class: androidx.compose.material3.DateRangePickerKt$$ExternalSyntheticLambda14
                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj, Object obj2) {
                                return DateRangePickerKt.DateRangePicker$lambda$2(dateRangePickerState, datePickerFormatter3, datePickerColorsColors, (Composer) obj, ((Integer) obj2).intValue());
                            }
                        }, composerStartRestartGroup, i12);
                    }
                    if (i8 != 0) {
                        z2 = true;
                    }
                    if (i10 != 0) {
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1173504387, "CC(remember):DateRangePicker.kt#9igjgp");
                        objRememberedValue = composerStartRestartGroup.rememberedValue();
                        if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                            objRememberedValue = new FocusRequester();
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                        }
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        DatePickerColors datePickerColors11114 = datePickerColorsColors;
                        focusRequester3 = (FocusRequester) objRememberedValue;
                        z6 = z2;
                        datePickerColors4 = datePickerColors11114;
                        function6 = function2RememberComposableLambda;
                        modifier4 = modifier2;
                        i13 = i3;
                    } else {
                        function6 = function2RememberComposableLambda;
                        z6 = z2;
                        datePickerColors4 = datePickerColorsColors;
                        modifier4 = modifier2;
                        i13 = i3;
                        focusRequester3 = focusRequester;
                    }
                }
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(1969726368, i13, -1, "androidx.compose.material3.DateRangePicker (DateRangePicker.kt:123)");
                }
                Locale locale14 = dateRangePickerState.getLocale();
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1173502065, "CC(remember):DateRangePicker.kt#9igjgp");
                zChanged = composerStartRestartGroup.changed(locale14);
                objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                if (!zChanged) {
                    if (dateRangePickerState instanceof BaseDatePickerStateImpl) {
                        calendarModelCreateCalendarModel = ((BaseDatePickerStateImpl) dateRangePickerState).getCalendarModel();
                    } else {
                        calendarModelCreateCalendarModel = CalendarModel_androidKt.createCalendarModel(dateRangePickerState.getLocale());
                    }
                    objRememberedValue3 = calendarModelCreateCalendarModel;
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                } else {
                    if (dateRangePickerState instanceof BaseDatePickerStateImpl) {
                        calendarModelCreateCalendarModel = ((BaseDatePickerStateImpl) dateRangePickerState).getCalendarModel();
                    } else {
                        calendarModelCreateCalendarModel = CalendarModel_androidKt.createCalendarModel(dateRangePickerState.getLocale());
                    }
                    objRememberedValue3 = calendarModelCreateCalendarModel;
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                }
                final CalendarModel calendarModel14 = (CalendarModel) objRememberedValue3;
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                if (z6) {
                    composerStartRestartGroup.startReplaceGroup(-2018450762);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "138@6251L364");
                    composableLambdaRememberComposableLambda = ComposableLambdaKt.rememberComposableLambda(1343236786, true, new Function2() { // from class: androidx.compose.material3.DateRangePickerKt$$ExternalSyntheticLambda15
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return DateRangePickerKt.DateRangePicker$lambda$5(dateRangePickerState, datePickerColors4, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    }, composerStartRestartGroup, 54);
                    composerStartRestartGroup.endReplaceGroup();
                } else {
                    composerStartRestartGroup.startReplaceGroup(-2018063138);
                    composerStartRestartGroup.endReplaceGroup();
                    composableLambdaRememberComposableLambda = null;
                }
                TextStyle value14 = TypographyKt.getValue(DatePickerModalTokens.INSTANCE.getRangeSelectionHeaderHeadlineFont(), composerStartRestartGroup, 6);
                float fM9687constructorimpl14 = Dp.m9687constructorimpl(DatePickerModalTokens.INSTANCE.m5328getRangeSelectionHeaderContainerHeightD9Ej5fM() - HeaderHeightOffset);
                final FocusRequester focusRequester17 = focusRequester3;
                final DatePickerColors datePickerColors11115 = datePickerColors4;
                Function2 function110 = new Function2() { // from class: androidx.compose.material3.DateRangePickerKt$$ExternalSyntheticLambda16
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return DateRangePickerKt.DateRangePicker$lambda$6(dateRangePickerState, calendarModel14, datePickerFormatter3, datePickerColors11115, focusRequester17, (Composer) obj, ((Integer) obj2).intValue());
                    }
                };
                DatePickerFormatter datePickerFormatter17 = datePickerFormatter3;
                int i1110 = i13 >> 9;
                composer2 = composerStartRestartGroup;
                DatePickerKt.m3177DateEntryContainerau3_HiA(modifier4, function6, function2RememberComposableLambda2, composableLambdaRememberComposableLambda, datePickerColors4, value14, fM9687constructorimpl14, ComposableLambdaKt.rememberComposableLambda(684885105, true, function110, composerStartRestartGroup, 54), composer2, ((i13 >> 3) & 14) | 14155776 | (i1110 & 112) | (i1110 & 896) | (57344 & (i13 << 3)));
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                datePickerFormatter2 = datePickerFormatter17;
                focusRequester2 = focusRequester17;
                z4 = z6;
                modifier3 = modifier4;
                function4 = function6;
                datePickerColors3 = datePickerColors4;
            } else {
                composer2 = composerStartRestartGroup;
                composer2.skipToGroupEnd();
                datePickerFormatter2 = datePickerFormatter;
                focusRequester2 = focusRequester;
                modifier3 = modifier2;
                datePickerColors3 = datePickerColors2;
                function4 = function2RememberComposableLambda;
                z4 = z2;
            }
            function5 = function2RememberComposableLambda2;
            scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.DateRangePickerKt$$ExternalSyntheticLambda17
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return DateRangePickerKt.DateRangePicker$lambda$7(dateRangePickerState, modifier3, datePickerFormatter2, datePickerColors3, function4, function5, z4, focusRequester2, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                    }
                });
            }
        }
        i3 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
        function2RememberComposableLambda2 = function3;
        i8 = i2 & 64;
        if (i8 != 0) {
            if ((1572864 & i) == 0) {
                z2 = z;
                if (composerStartRestartGroup.changed(z2)) {
                    i9 = 1048576;
                } else {
                    i9 = 524288;
                }
                i3 |= i9;
            }
            i10 = i2 & 128;
            if (i10 != 0) {
                i3 |= 12582912;
            } else if ((i & 12582912) == 0) {
                if (composerStartRestartGroup.changed(focusRequester)) {
                    i11 = 8388608;
                } else {
                    i11 = 4194304;
                }
                i3 |= i11;
            }
            if ((i3 & 4793491) != 4793490) {
                z3 = true;
            } else {
                z3 = false;
            }
            if (composerStartRestartGroup.shouldExecute(z3, i3 & 1)) {
                composerStartRestartGroup.startDefaults();
                ComposerKt.sourceInformation(composerStartRestartGroup, "102@4878L47,103@4977L8,104@5026L239,111@5309L409,122@5794L29");
                if ((i & 1) != 0) {
                    if (i15 != 0) {
                        modifier2 = Modifier.INSTANCE;
                    }
                    if ((i2 & 4) != 0) {
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1173533681, "CC(remember):DateRangePicker.kt#9igjgp");
                        objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                        if (objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                            objRememberedValue2 = DatePickerDefaults.dateFormatter$default(DatePickerDefaults.INSTANCE, null, null, null, 7, null);
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                        }
                        datePickerFormatter3 = (DatePickerFormatter) objRememberedValue2;
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        i3 &= -897;
                    } else {
                        datePickerFormatter3 = datePickerFormatter;
                    }
                    if ((i2 & 8) != 0) {
                        datePickerColorsColors = DatePickerDefaults.INSTANCE.colors(composerStartRestartGroup, 6);
                        i3 &= -7169;
                    } else {
                        datePickerColorsColors = datePickerColors2;
                    }
                    if (i4 != 0) {
                        z5 = true;
                        function2RememberComposableLambda = ComposableLambdaKt.rememberComposableLambda(-803011924, true, new Function2() { // from class: androidx.compose.material3.DateRangePickerKt$$ExternalSyntheticLambda13
                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj, Object obj2) {
                                return DateRangePickerKt.DateRangePicker$lambda$1(dateRangePickerState, datePickerColorsColors, (Composer) obj, ((Integer) obj2).intValue());
                            }
                        }, composerStartRestartGroup, 54);
                        i12 = 54;
                    } else {
                        z5 = true;
                        i12 = 54;
                    }
                    if (i6 != 0) {
                        function2RememberComposableLambda2 = ComposableLambdaKt.rememberComposableLambda(-331385278, z5, new Function2() { // from class: androidx.compose.material3.DateRangePickerKt$$ExternalSyntheticLambda14
                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj, Object obj2) {
                                return DateRangePickerKt.DateRangePicker$lambda$2(dateRangePickerState, datePickerFormatter3, datePickerColorsColors, (Composer) obj, ((Integer) obj2).intValue());
                            }
                        }, composerStartRestartGroup, i12);
                    }
                    if (i8 != 0) {
                        z2 = true;
                    }
                    if (i10 != 0) {
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1173504387, "CC(remember):DateRangePicker.kt#9igjgp");
                        objRememberedValue = composerStartRestartGroup.rememberedValue();
                        if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                            objRememberedValue = new FocusRequester();
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                        }
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        DatePickerColors datePickerColors11116 = datePickerColorsColors;
                        focusRequester3 = (FocusRequester) objRememberedValue;
                        z6 = z2;
                        datePickerColors4 = datePickerColors11116;
                        function6 = function2RememberComposableLambda;
                        modifier4 = modifier2;
                        i13 = i3;
                    } else {
                        function6 = function2RememberComposableLambda;
                        z6 = z2;
                        datePickerColors4 = datePickerColorsColors;
                        modifier4 = modifier2;
                        i13 = i3;
                        focusRequester3 = focusRequester;
                    }
                } else {
                    if (i15 != 0) {
                        modifier2 = Modifier.INSTANCE;
                    }
                    if ((i2 & 4) != 0) {
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1173533681, "CC(remember):DateRangePicker.kt#9igjgp");
                        objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                        if (objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                            objRememberedValue2 = DatePickerDefaults.dateFormatter$default(DatePickerDefaults.INSTANCE, null, null, null, 7, null);
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                        }
                        datePickerFormatter3 = (DatePickerFormatter) objRememberedValue2;
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        i3 &= -897;
                    } else {
                        datePickerFormatter3 = datePickerFormatter;
                    }
                    if ((i2 & 8) != 0) {
                        datePickerColorsColors = DatePickerDefaults.INSTANCE.colors(composerStartRestartGroup, 6);
                        i3 &= -7169;
                    } else {
                        datePickerColorsColors = datePickerColors2;
                    }
                    if (i4 != 0) {
                        z5 = true;
                        function2RememberComposableLambda = ComposableLambdaKt.rememberComposableLambda(-803011924, true, new Function2() { // from class: androidx.compose.material3.DateRangePickerKt$$ExternalSyntheticLambda13
                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj, Object obj2) {
                                return DateRangePickerKt.DateRangePicker$lambda$1(dateRangePickerState, datePickerColorsColors, (Composer) obj, ((Integer) obj2).intValue());
                            }
                        }, composerStartRestartGroup, 54);
                        i12 = 54;
                    } else {
                        z5 = true;
                        i12 = 54;
                    }
                    if (i6 != 0) {
                        function2RememberComposableLambda2 = ComposableLambdaKt.rememberComposableLambda(-331385278, z5, new Function2() { // from class: androidx.compose.material3.DateRangePickerKt$$ExternalSyntheticLambda14
                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj, Object obj2) {
                                return DateRangePickerKt.DateRangePicker$lambda$2(dateRangePickerState, datePickerFormatter3, datePickerColorsColors, (Composer) obj, ((Integer) obj2).intValue());
                            }
                        }, composerStartRestartGroup, i12);
                    }
                    if (i8 != 0) {
                        z2 = true;
                    }
                    if (i10 != 0) {
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1173504387, "CC(remember):DateRangePicker.kt#9igjgp");
                        objRememberedValue = composerStartRestartGroup.rememberedValue();
                        if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                            objRememberedValue = new FocusRequester();
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                        }
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        DatePickerColors datePickerColors11117 = datePickerColorsColors;
                        focusRequester3 = (FocusRequester) objRememberedValue;
                        z6 = z2;
                        datePickerColors4 = datePickerColors11117;
                        function6 = function2RememberComposableLambda;
                        modifier4 = modifier2;
                        i13 = i3;
                    } else {
                        function6 = function2RememberComposableLambda;
                        z6 = z2;
                        datePickerColors4 = datePickerColorsColors;
                        modifier4 = modifier2;
                        i13 = i3;
                        focusRequester3 = focusRequester;
                    }
                }
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(1969726368, i13, -1, "androidx.compose.material3.DateRangePicker (DateRangePicker.kt:123)");
                }
                Locale locale15 = dateRangePickerState.getLocale();
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1173502065, "CC(remember):DateRangePicker.kt#9igjgp");
                zChanged = composerStartRestartGroup.changed(locale15);
                objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                if (!zChanged) {
                    if (dateRangePickerState instanceof BaseDatePickerStateImpl) {
                        calendarModelCreateCalendarModel = ((BaseDatePickerStateImpl) dateRangePickerState).getCalendarModel();
                    } else {
                        calendarModelCreateCalendarModel = CalendarModel_androidKt.createCalendarModel(dateRangePickerState.getLocale());
                    }
                    objRememberedValue3 = calendarModelCreateCalendarModel;
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                } else {
                    if (dateRangePickerState instanceof BaseDatePickerStateImpl) {
                        calendarModelCreateCalendarModel = ((BaseDatePickerStateImpl) dateRangePickerState).getCalendarModel();
                    } else {
                        calendarModelCreateCalendarModel = CalendarModel_androidKt.createCalendarModel(dateRangePickerState.getLocale());
                    }
                    objRememberedValue3 = calendarModelCreateCalendarModel;
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                }
                final CalendarModel calendarModel15 = (CalendarModel) objRememberedValue3;
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                if (z6) {
                    composerStartRestartGroup.startReplaceGroup(-2018450762);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "138@6251L364");
                    composableLambdaRememberComposableLambda = ComposableLambdaKt.rememberComposableLambda(1343236786, true, new Function2() { // from class: androidx.compose.material3.DateRangePickerKt$$ExternalSyntheticLambda15
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return DateRangePickerKt.DateRangePicker$lambda$5(dateRangePickerState, datePickerColors4, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    }, composerStartRestartGroup, 54);
                    composerStartRestartGroup.endReplaceGroup();
                } else {
                    composerStartRestartGroup.startReplaceGroup(-2018063138);
                    composerStartRestartGroup.endReplaceGroup();
                    composableLambdaRememberComposableLambda = null;
                }
                TextStyle value15 = TypographyKt.getValue(DatePickerModalTokens.INSTANCE.getRangeSelectionHeaderHeadlineFont(), composerStartRestartGroup, 6);
                float fM9687constructorimpl15 = Dp.m9687constructorimpl(DatePickerModalTokens.INSTANCE.m5328getRangeSelectionHeaderContainerHeightD9Ej5fM() - HeaderHeightOffset);
                final FocusRequester focusRequester18 = focusRequester3;
                final DatePickerColors datePickerColors11118 = datePickerColors4;
                Function2 function111 = new Function2() { // from class: androidx.compose.material3.DateRangePickerKt$$ExternalSyntheticLambda16
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return DateRangePickerKt.DateRangePicker$lambda$6(dateRangePickerState, calendarModel15, datePickerFormatter3, datePickerColors11118, focusRequester18, (Composer) obj, ((Integer) obj2).intValue());
                    }
                };
                DatePickerFormatter datePickerFormatter18 = datePickerFormatter3;
                int i1111 = i13 >> 9;
                composer2 = composerStartRestartGroup;
                DatePickerKt.m3177DateEntryContainerau3_HiA(modifier4, function6, function2RememberComposableLambda2, composableLambdaRememberComposableLambda, datePickerColors4, value15, fM9687constructorimpl15, ComposableLambdaKt.rememberComposableLambda(684885105, true, function111, composerStartRestartGroup, 54), composer2, ((i13 >> 3) & 14) | 14155776 | (i1111 & 112) | (i1111 & 896) | (57344 & (i13 << 3)));
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                datePickerFormatter2 = datePickerFormatter18;
                focusRequester2 = focusRequester18;
                z4 = z6;
                modifier3 = modifier4;
                function4 = function6;
                datePickerColors3 = datePickerColors4;
            } else {
                composer2 = composerStartRestartGroup;
                composer2.skipToGroupEnd();
                datePickerFormatter2 = datePickerFormatter;
                focusRequester2 = focusRequester;
                modifier3 = modifier2;
                datePickerColors3 = datePickerColors2;
                function4 = function2RememberComposableLambda;
                z4 = z2;
            }
            function5 = function2RememberComposableLambda2;
            scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.DateRangePickerKt$$ExternalSyntheticLambda17
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return DateRangePickerKt.DateRangePicker$lambda$7(dateRangePickerState, modifier3, datePickerFormatter2, datePickerColors3, function4, function5, z4, focusRequester2, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                    }
                });
            }
        }
        i3 |= 1572864;
        z2 = z;
        i10 = i2 & 128;
        if (i10 != 0) {
            i3 |= 12582912;
        } else if ((i & 12582912) == 0) {
            if (composerStartRestartGroup.changed(focusRequester)) {
                i11 = 8388608;
            } else {
                i11 = 4194304;
            }
            i3 |= i11;
        }
        if ((i3 & 4793491) != 4793490) {
            z3 = true;
        } else {
            z3 = false;
        }
        if (composerStartRestartGroup.shouldExecute(z3, i3 & 1)) {
            composerStartRestartGroup.startDefaults();
            ComposerKt.sourceInformation(composerStartRestartGroup, "102@4878L47,103@4977L8,104@5026L239,111@5309L409,122@5794L29");
            if ((i & 1) != 0) {
                if (i15 != 0) {
                    modifier2 = Modifier.INSTANCE;
                }
                if ((i2 & 4) != 0) {
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1173533681, "CC(remember):DateRangePicker.kt#9igjgp");
                    objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                    if (objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                        objRememberedValue2 = DatePickerDefaults.dateFormatter$default(DatePickerDefaults.INSTANCE, null, null, null, 7, null);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                    }
                    datePickerFormatter3 = (DatePickerFormatter) objRememberedValue2;
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    i3 &= -897;
                } else {
                    datePickerFormatter3 = datePickerFormatter;
                }
                if ((i2 & 8) != 0) {
                    datePickerColorsColors = DatePickerDefaults.INSTANCE.colors(composerStartRestartGroup, 6);
                    i3 &= -7169;
                } else {
                    datePickerColorsColors = datePickerColors2;
                }
                if (i4 != 0) {
                    z5 = true;
                    function2RememberComposableLambda = ComposableLambdaKt.rememberComposableLambda(-803011924, true, new Function2() { // from class: androidx.compose.material3.DateRangePickerKt$$ExternalSyntheticLambda13
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return DateRangePickerKt.DateRangePicker$lambda$1(dateRangePickerState, datePickerColorsColors, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    }, composerStartRestartGroup, 54);
                    i12 = 54;
                } else {
                    z5 = true;
                    i12 = 54;
                }
                if (i6 != 0) {
                    function2RememberComposableLambda2 = ComposableLambdaKt.rememberComposableLambda(-331385278, z5, new Function2() { // from class: androidx.compose.material3.DateRangePickerKt$$ExternalSyntheticLambda14
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return DateRangePickerKt.DateRangePicker$lambda$2(dateRangePickerState, datePickerFormatter3, datePickerColorsColors, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    }, composerStartRestartGroup, i12);
                }
                if (i8 != 0) {
                    z2 = true;
                }
                if (i10 != 0) {
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1173504387, "CC(remember):DateRangePicker.kt#9igjgp");
                    objRememberedValue = composerStartRestartGroup.rememberedValue();
                    if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                        objRememberedValue = new FocusRequester();
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                    }
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    DatePickerColors datePickerColors11119 = datePickerColorsColors;
                    focusRequester3 = (FocusRequester) objRememberedValue;
                    z6 = z2;
                    datePickerColors4 = datePickerColors11119;
                    function6 = function2RememberComposableLambda;
                    modifier4 = modifier2;
                    i13 = i3;
                } else {
                    function6 = function2RememberComposableLambda;
                    z6 = z2;
                    datePickerColors4 = datePickerColorsColors;
                    modifier4 = modifier2;
                    i13 = i3;
                    focusRequester3 = focusRequester;
                }
            } else {
                if (i15 != 0) {
                    modifier2 = Modifier.INSTANCE;
                }
                if ((i2 & 4) != 0) {
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1173533681, "CC(remember):DateRangePicker.kt#9igjgp");
                    objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                    if (objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                        objRememberedValue2 = DatePickerDefaults.dateFormatter$default(DatePickerDefaults.INSTANCE, null, null, null, 7, null);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                    }
                    datePickerFormatter3 = (DatePickerFormatter) objRememberedValue2;
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    i3 &= -897;
                } else {
                    datePickerFormatter3 = datePickerFormatter;
                }
                if ((i2 & 8) != 0) {
                    datePickerColorsColors = DatePickerDefaults.INSTANCE.colors(composerStartRestartGroup, 6);
                    i3 &= -7169;
                } else {
                    datePickerColorsColors = datePickerColors2;
                }
                if (i4 != 0) {
                    z5 = true;
                    function2RememberComposableLambda = ComposableLambdaKt.rememberComposableLambda(-803011924, true, new Function2() { // from class: androidx.compose.material3.DateRangePickerKt$$ExternalSyntheticLambda13
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return DateRangePickerKt.DateRangePicker$lambda$1(dateRangePickerState, datePickerColorsColors, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    }, composerStartRestartGroup, 54);
                    i12 = 54;
                } else {
                    z5 = true;
                    i12 = 54;
                }
                if (i6 != 0) {
                    function2RememberComposableLambda2 = ComposableLambdaKt.rememberComposableLambda(-331385278, z5, new Function2() { // from class: androidx.compose.material3.DateRangePickerKt$$ExternalSyntheticLambda14
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return DateRangePickerKt.DateRangePicker$lambda$2(dateRangePickerState, datePickerFormatter3, datePickerColorsColors, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    }, composerStartRestartGroup, i12);
                }
                if (i8 != 0) {
                    z2 = true;
                }
                if (i10 != 0) {
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1173504387, "CC(remember):DateRangePicker.kt#9igjgp");
                    objRememberedValue = composerStartRestartGroup.rememberedValue();
                    if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                        objRememberedValue = new FocusRequester();
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                    }
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    DatePickerColors datePickerColors111110 = datePickerColorsColors;
                    focusRequester3 = (FocusRequester) objRememberedValue;
                    z6 = z2;
                    datePickerColors4 = datePickerColors111110;
                    function6 = function2RememberComposableLambda;
                    modifier4 = modifier2;
                    i13 = i3;
                } else {
                    function6 = function2RememberComposableLambda;
                    z6 = z2;
                    datePickerColors4 = datePickerColorsColors;
                    modifier4 = modifier2;
                    i13 = i3;
                    focusRequester3 = focusRequester;
                }
            }
            composerStartRestartGroup.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1969726368, i13, -1, "androidx.compose.material3.DateRangePicker (DateRangePicker.kt:123)");
            }
            Locale locale16 = dateRangePickerState.getLocale();
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1173502065, "CC(remember):DateRangePicker.kt#9igjgp");
            zChanged = composerStartRestartGroup.changed(locale16);
            objRememberedValue3 = composerStartRestartGroup.rememberedValue();
            if (!zChanged) {
                if (dateRangePickerState instanceof BaseDatePickerStateImpl) {
                    calendarModelCreateCalendarModel = ((BaseDatePickerStateImpl) dateRangePickerState).getCalendarModel();
                } else {
                    calendarModelCreateCalendarModel = CalendarModel_androidKt.createCalendarModel(dateRangePickerState.getLocale());
                }
                objRememberedValue3 = calendarModelCreateCalendarModel;
                composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
            } else {
                if (dateRangePickerState instanceof BaseDatePickerStateImpl) {
                    calendarModelCreateCalendarModel = ((BaseDatePickerStateImpl) dateRangePickerState).getCalendarModel();
                } else {
                    calendarModelCreateCalendarModel = CalendarModel_androidKt.createCalendarModel(dateRangePickerState.getLocale());
                }
                objRememberedValue3 = calendarModelCreateCalendarModel;
                composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
            }
            final CalendarModel calendarModel16 = (CalendarModel) objRememberedValue3;
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            if (z6) {
                composerStartRestartGroup.startReplaceGroup(-2018450762);
                ComposerKt.sourceInformation(composerStartRestartGroup, "138@6251L364");
                composableLambdaRememberComposableLambda = ComposableLambdaKt.rememberComposableLambda(1343236786, true, new Function2() { // from class: androidx.compose.material3.DateRangePickerKt$$ExternalSyntheticLambda15
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return DateRangePickerKt.DateRangePicker$lambda$5(dateRangePickerState, datePickerColors4, (Composer) obj, ((Integer) obj2).intValue());
                    }
                }, composerStartRestartGroup, 54);
                composerStartRestartGroup.endReplaceGroup();
            } else {
                composerStartRestartGroup.startReplaceGroup(-2018063138);
                composerStartRestartGroup.endReplaceGroup();
                composableLambdaRememberComposableLambda = null;
            }
            TextStyle value16 = TypographyKt.getValue(DatePickerModalTokens.INSTANCE.getRangeSelectionHeaderHeadlineFont(), composerStartRestartGroup, 6);
            float fM9687constructorimpl16 = Dp.m9687constructorimpl(DatePickerModalTokens.INSTANCE.m5328getRangeSelectionHeaderContainerHeightD9Ej5fM() - HeaderHeightOffset);
            final FocusRequester focusRequester19 = focusRequester3;
            final DatePickerColors datePickerColors111111 = datePickerColors4;
            Function2 function112 = new Function2() { // from class: androidx.compose.material3.DateRangePickerKt$$ExternalSyntheticLambda16
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return DateRangePickerKt.DateRangePicker$lambda$6(dateRangePickerState, calendarModel16, datePickerFormatter3, datePickerColors111111, focusRequester19, (Composer) obj, ((Integer) obj2).intValue());
                }
            };
            DatePickerFormatter datePickerFormatter19 = datePickerFormatter3;
            int i1112 = i13 >> 9;
            composer2 = composerStartRestartGroup;
            DatePickerKt.m3177DateEntryContainerau3_HiA(modifier4, function6, function2RememberComposableLambda2, composableLambdaRememberComposableLambda, datePickerColors4, value16, fM9687constructorimpl16, ComposableLambdaKt.rememberComposableLambda(684885105, true, function112, composerStartRestartGroup, 54), composer2, ((i13 >> 3) & 14) | 14155776 | (i1112 & 112) | (i1112 & 896) | (57344 & (i13 << 3)));
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            datePickerFormatter2 = datePickerFormatter19;
            focusRequester2 = focusRequester19;
            z4 = z6;
            modifier3 = modifier4;
            function4 = function6;
            datePickerColors3 = datePickerColors4;
        } else {
            composer2 = composerStartRestartGroup;
            composer2.skipToGroupEnd();
            datePickerFormatter2 = datePickerFormatter;
            focusRequester2 = focusRequester;
            modifier3 = modifier2;
            datePickerColors3 = datePickerColors2;
            function4 = function2RememberComposableLambda;
            z4 = z2;
        }
        function5 = function2RememberComposableLambda2;
        scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.DateRangePickerKt$$ExternalSyntheticLambda17
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return DateRangePickerKt.DateRangePicker$lambda$7(dateRangePickerState, modifier3, datePickerFormatter2, datePickerColors3, function4, function5, z4, focusRequester2, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit DateRangePicker$lambda$5(final DateRangePickerState dateRangePickerState, DatePickerColors datePickerColors, Composer composer, int i) {
        ComposerKt.sourceInformation(composer, "C142@6483L50,139@6273L324:DateRangePicker.kt#uh7d8r");
        if (!composer.shouldExecute((i & 3) != 2, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1343236786, i, -1, "androidx.compose.material3.DateRangePicker.<anonymous> (DateRangePicker.kt:139)");
            }
            Modifier modifierPadding = PaddingKt.padding(Modifier.INSTANCE, DatePickerKt.getDatePickerModeTogglePadding());
            int iMo3232getDisplayModejFl4v0 = dateRangePickerState.mo3232getDisplayModejFl4v0();
            ComposerKt.sourceInformationMarkerStart(composer, -1934597276, "CC(remember):DateRangePicker.kt#9igjgp");
            boolean zChanged = composer.changed(dateRangePickerState);
            Object objRememberedValue = composer.rememberedValue();
            if (zChanged || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                objRememberedValue = new Function1() { // from class: androidx.compose.material3.DateRangePickerKt$$ExternalSyntheticLambda8
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return DateRangePickerKt.DateRangePicker$lambda$5$0$0(dateRangePickerState, (DisplayMode) obj);
                    }
                };
                composer.updateRememberedValue(objRememberedValue);
            }
            ComposerKt.sourceInformationMarkerEnd(composer);
            DatePickerKt.m3181DisplayModeToggleButtoniUJLfQg(modifierPadding, iMo3232getDisplayModejFl4v0, (Function1) objRememberedValue, datePickerColors, composer, 6);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit DateRangePicker$lambda$5$0$0(DateRangePickerState dateRangePickerState, DisplayMode displayMode) {
        dateRangePickerState.mo3233setDisplayModevCnGnXg(displayMode.getValue());
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit DateRangePicker$lambda$6(final DateRangePickerState dateRangePickerState, CalendarModel calendarModel, DatePickerFormatter datePickerFormatter, DatePickerColors datePickerColors, FocusRequester focusRequester, Composer composer, int i) {
        ComposerKt.sourceInformation(composer, "C159@7229L468,170@7736L91,154@6922L1170:DateRangePicker.kt#uh7d8r");
        if (!composer.shouldExecute((i & 3) != 2, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(684885105, i, -1, "androidx.compose.material3.DateRangePicker.<anonymous> (DateRangePicker.kt:154)");
            }
            Long selectedStartDateMillis = dateRangePickerState.getSelectedStartDateMillis();
            Long selectedEndDateMillis = dateRangePickerState.getSelectedEndDateMillis();
            long displayedMonthMillis = dateRangePickerState.getDisplayedMonthMillis();
            int iMo3232getDisplayModejFl4v0 = dateRangePickerState.mo3232getDisplayModejFl4v0();
            ComposerKt.sourceInformationMarkerStart(composer, 1044600229, "CC(remember):DateRangePicker.kt#9igjgp");
            boolean zChanged = composer.changed(dateRangePickerState);
            Object objRememberedValue = composer.rememberedValue();
            if (zChanged || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                objRememberedValue = new Function2() { // from class: androidx.compose.material3.DateRangePickerKt$$ExternalSyntheticLambda20
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return DateRangePickerKt.DateRangePicker$lambda$6$0$0(dateRangePickerState, (Long) obj, (Long) obj2);
                    }
                };
                composer.updateRememberedValue(objRememberedValue);
            }
            Function2 function2 = (Function2) objRememberedValue;
            ComposerKt.sourceInformationMarkerEnd(composer);
            ComposerKt.sourceInformationMarkerStart(composer, 1044616076, "CC(remember):DateRangePicker.kt#9igjgp");
            boolean zChanged2 = composer.changed(dateRangePickerState);
            Object objRememberedValue2 = composer.rememberedValue();
            if (zChanged2 || objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                objRememberedValue2 = new Function1() { // from class: androidx.compose.material3.DateRangePickerKt$$ExternalSyntheticLambda21
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return DateRangePickerKt.DateRangePicker$lambda$6$1$0(dateRangePickerState, ((Long) obj).longValue());
                    }
                };
                composer.updateRememberedValue(objRememberedValue2);
            }
            ComposerKt.sourceInformationMarkerEnd(composer);
            m3229SwitchableDateEntryContenteVtQiho(selectedStartDateMillis, selectedEndDateMillis, displayedMonthMillis, iMo3232getDisplayModejFl4v0, function2, (Function1) objRememberedValue2, calendarModel, dateRangePickerState.getYearRange(), datePickerFormatter, dateRangePickerState.getSelectableDates(), datePickerColors, focusRequester, composer, 0, 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit DateRangePicker$lambda$6$0$0(DateRangePickerState dateRangePickerState, Long l, Long l2) {
        try {
            dateRangePickerState.setSelection(l, l2);
        } catch (IllegalArgumentException unused) {
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit DateRangePicker$lambda$6$1$0(DateRangePickerState dateRangePickerState, long j) {
        dateRangePickerState.setDisplayedMonthMillis(j);
        return Unit.INSTANCE;
    }

    /* JADX INFO: renamed from: rememberDateRangePickerState-IlFM19s, reason: not valid java name */
    public static final DateRangePickerState m3231rememberDateRangePickerStateIlFM19s(Long l, Long l2, Long l3, IntRange intRange, int i, SelectableDates selectableDates, Composer composer, int i2, int i3) {
        ComposerKt.sourceInformationMarkerStart(composer, -2012087461, "C(rememberDateRangePickerState)N(initialSelectedStartDateMillis,initialSelectedEndDateMillis,initialDisplayedMonthMillis,yearRange,initialDisplayMode:c#material3.DisplayMode,selectableDates)284@12718L15,285@12827L476,285@12745L558:DateRangePicker.kt#uh7d8r");
        final Long l4 = (i3 & 1) != 0 ? null : l;
        final Long l5 = (i3 & 2) != 0 ? null : l2;
        final Long l6 = (i3 & 4) != 0 ? l4 : l3;
        final IntRange yearRange = (i3 & 8) != 0 ? DatePickerDefaults.INSTANCE.getYearRange() : intRange;
        final int iM3277getPickerjFl4v0 = (i3 & 16) != 0 ? DisplayMode.INSTANCE.m3277getPickerjFl4v0() : i;
        final SelectableDates allDates = (i3 & 32) != 0 ? DatePickerDefaults.INSTANCE.getAllDates() : selectableDates;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-2012087461, i2, -1, "androidx.compose.material3.rememberDateRangePickerState (DateRangePicker.kt:283)");
        }
        final Locale localeDefaultLocale = CalendarLocale_androidKt.defaultLocale(composer, 0);
        Object[] objArr = new Object[0];
        Saver<DateRangePickerStateImpl, Object> Saver = DateRangePickerStateImpl.INSTANCE.Saver(allDates, localeDefaultLocale);
        ComposerKt.sourceInformationMarkerStart(composer, -880746793, "CC(remember):DateRangePicker.kt#9igjgp");
        boolean z = true;
        boolean zChangedInstance = ((((i2 & 112) ^ 48) > 32 && composer.changed(l5)) || (i2 & 48) == 32) | ((((i2 & 14) ^ 6) > 4 && composer.changed(l4)) || (i2 & 6) == 4) | ((((i2 & 896) ^ 384) > 256 && composer.changed(l6)) || (i2 & 384) == 256) | composer.changedInstance(yearRange) | ((((57344 & i2) ^ 24576) > 16384 && composer.changed(iM3277getPickerjFl4v0)) || (i2 & 24576) == 16384);
        if ((((458752 & i2) ^ ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE) <= 131072 || !composer.changed(allDates)) && (i2 & ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE) != 131072) {
            z = false;
        }
        boolean zChangedInstance2 = zChangedInstance | z | composer.changedInstance(localeDefaultLocale);
        Object objRememberedValue = composer.rememberedValue();
        if (zChangedInstance2 || objRememberedValue == Composer.INSTANCE.getEmpty()) {
            Object obj = new Function0() { // from class: androidx.compose.material3.DateRangePickerKt$$ExternalSyntheticLambda2
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    return DateRangePickerKt.rememberDateRangePickerState_IlFM19s$lambda$0$0(l4, l5, l6, yearRange, iM3277getPickerjFl4v0, allDates, localeDefaultLocale);
                }
            };
            composer.updateRememberedValue(obj);
            objRememberedValue = obj;
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        DateRangePickerStateImpl dateRangePickerStateImpl = (DateRangePickerStateImpl) RememberSaveableKt.m6247rememberSaveable(objArr, (Saver) Saver, (Function0) objRememberedValue, composer, 0);
        dateRangePickerStateImpl.setSelectableDates(allDates);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return dateRangePickerStateImpl;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final DateRangePickerStateImpl rememberDateRangePickerState_IlFM19s$lambda$0$0(Long l, Long l2, Long l3, IntRange intRange, int i, SelectableDates selectableDates, Locale locale) {
        return new DateRangePickerStateImpl(l, l2, l3, intRange, i, selectableDates, locale, null);
    }

    /* JADX INFO: renamed from: DateRangePickerState-HVP43zI$default, reason: not valid java name */
    public static /* synthetic */ DateRangePickerState m3228DateRangePickerStateHVP43zI$default(Locale locale, Long l, Long l2, Long l3, IntRange intRange, int i, SelectableDates selectableDates, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            l = null;
        }
        if ((i2 & 4) != 0) {
            l2 = null;
        }
        if ((i2 & 8) != 0) {
            l3 = l;
        }
        if ((i2 & 16) != 0) {
            intRange = DatePickerDefaults.INSTANCE.getYearRange();
        }
        if ((i2 & 32) != 0) {
            i = DisplayMode.INSTANCE.m3277getPickerjFl4v0();
        }
        if ((i2 & 64) != 0) {
            selectableDates = DatePickerDefaults.INSTANCE.getAllDates();
        }
        return m3227DateRangePickerStateHVP43zI(locale, l, l2, l3, intRange, i, selectableDates);
    }

    /* JADX INFO: renamed from: DateRangePickerState-HVP43zI, reason: not valid java name */
    public static final DateRangePickerState m3227DateRangePickerStateHVP43zI(Locale locale, Long l, Long l2, Long l3, IntRange intRange, int i, SelectableDates selectableDates) {
        return new DateRangePickerStateImpl(l, l2, l3, intRange, i, selectableDates, locale, null);
    }

    /* JADX INFO: renamed from: SwitchableDateEntryContent-eVtQiho, reason: not valid java name */
    private static final void m3229SwitchableDateEntryContenteVtQiho(final Long l, final Long l2, final long j, final int i, final Function2<? super Long, ? super Long, Unit> function2, final Function1<? super Long, Unit> function1, final CalendarModel calendarModel, final IntRange intRange, final DatePickerFormatter datePickerFormatter, final SelectableDates selectableDates, final DatePickerColors datePickerColors, final FocusRequester focusRequester, Composer composer, final int i2, final int i3) {
        int i4;
        Long l3;
        Function2<? super Long, ? super Long, Unit> function3;
        Function1<? super Long, Unit> function4;
        int i5;
        Composer composer2;
        Composer composerStartRestartGroup = composer.startRestartGroup(621028059);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(SwitchableDateEntryContent)N(selectedStartDateMillis,selectedEndDateMillis,displayedMonthMillis,displayMode:c#material3.DisplayMode,onDatesSelectionChange,onDisplayedMonthChange,calendarModel,yearRange,dateFormatter,selectableDates,colors,focusRequester)714@32363L7,716@32422L91,720@32521L1304,712@32259L1566:DateRangePicker.kt#uh7d8r");
        if ((i2 & 6) == 0) {
            i4 = (composerStartRestartGroup.changed(l) ? 4 : 2) | i2;
        } else {
            i4 = i2;
        }
        if ((i2 & 48) == 0) {
            l3 = l2;
            i4 |= composerStartRestartGroup.changed(l3) ? 32 : 16;
        } else {
            l3 = l2;
        }
        if ((i2 & 384) == 0) {
            i4 |= composerStartRestartGroup.changed(j) ? 256 : 128;
        }
        if ((i2 & 3072) == 0) {
            i4 |= composerStartRestartGroup.changed(i) ? 2048 : 1024;
        }
        if ((i2 & 24576) == 0) {
            function3 = function2;
            i4 |= composerStartRestartGroup.changedInstance(function3) ? 16384 : 8192;
        } else {
            function3 = function2;
        }
        if ((196608 & i2) == 0) {
            function4 = function1;
            i4 |= composerStartRestartGroup.changedInstance(function4) ? 131072 : 65536;
        } else {
            function4 = function1;
        }
        if ((i2 & 1572864) == 0) {
            i4 |= composerStartRestartGroup.changedInstance(calendarModel) ? 1048576 : 524288;
        }
        if ((i2 & 12582912) == 0) {
            i4 |= composerStartRestartGroup.changedInstance(intRange) ? 8388608 : 4194304;
        }
        if ((i2 & 100663296) == 0) {
            i4 |= (i2 & C.BUFFER_FLAG_FIRST_SAMPLE) == 0 ? composerStartRestartGroup.changed(datePickerFormatter) : composerStartRestartGroup.changedInstance(datePickerFormatter) ? 67108864 : 33554432;
        }
        if ((i2 & 805306368) == 0) {
            i4 |= composerStartRestartGroup.changed(selectableDates) ? C.BUFFER_FLAG_LAST_SAMPLE : 268435456;
        }
        if ((i3 & 6) == 0) {
            i5 = i3 | (composerStartRestartGroup.changed(datePickerColors) ? 4 : 2);
        } else {
            i5 = i3;
        }
        if ((i3 & 48) == 0) {
            i5 |= composerStartRestartGroup.changed(focusRequester) ? 32 : 16;
        }
        int i6 = i5;
        if (!composerStartRestartGroup.shouldExecute(((i4 & 306783379) == 306783378 && (i6 & 19) == 18) ? false : true, i4 & 1)) {
            composer2 = composerStartRestartGroup;
            composer2.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(621028059, i4, i6, "androidx.compose.material3.SwitchableDateEntryContent (DateRangePicker.kt:708)");
            }
            FiniteAnimationSpec finiteAnimationSpecValue = MotionSchemeKt.value(MotionSchemeKeyTokens.FastEffects, composerStartRestartGroup, 6);
            Modifier.Companion companion = Modifier.INSTANCE;
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -192460170, "CC(remember):DateRangePicker.kt#9igjgp");
            Object objRememberedValue = composerStartRestartGroup.rememberedValue();
            if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                objRememberedValue = new Function1() { // from class: androidx.compose.material3.DateRangePickerKt$$ExternalSyntheticLambda0
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return DateRangePickerKt.SwitchableDateEntryContent_eVtQiho$lambda$0$0((SemanticsPropertyReceiver) obj);
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
            }
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            final Long l4 = l3;
            final Function2<? super Long, ? super Long, Unit> function5 = function3;
            final Function1<? super Long, Unit> function6 = function4;
            composer2 = composerStartRestartGroup;
            CrossfadeKt.Crossfade(DisplayMode.m3269boximpl(i), SemanticsModifierKt.semantics$default(companion, false, (Function1) objRememberedValue, 1, null), (FiniteAnimationSpec<Float>) finiteAnimationSpecValue, (String) null, ComposableLambdaKt.rememberComposableLambda(-773828161, true, new Function3() { // from class: androidx.compose.material3.DateRangePickerKt$$ExternalSyntheticLambda11
                @Override // kotlin.jvm.functions.Function3
                public final Object invoke(Object obj, Object obj2, Object obj3) {
                    return DateRangePickerKt.SwitchableDateEntryContent_eVtQiho$lambda$1(l, l4, j, function5, function6, calendarModel, intRange, datePickerFormatter, selectableDates, datePickerColors, focusRequester, (DisplayMode) obj, (Composer) obj2, ((Integer) obj3).intValue());
                }
            }, composerStartRestartGroup, 54), composer2, ((i4 >> 9) & 14) | 24576, 8);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.DateRangePickerKt$$ExternalSyntheticLambda18
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return DateRangePickerKt.SwitchableDateEntryContent_eVtQiho$lambda$2(l, l2, j, i, function2, function1, calendarModel, intRange, datePickerFormatter, selectableDates, datePickerColors, focusRequester, i2, i3, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit SwitchableDateEntryContent_eVtQiho$lambda$0$0(SemanticsPropertyReceiver semanticsPropertyReceiver) {
        SemanticsPropertiesKt.setContainer(semanticsPropertyReceiver, true);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit SwitchableDateEntryContent_eVtQiho$lambda$1(Long l, Long l2, long j, Function2 function2, Function1 function1, CalendarModel calendarModel, IntRange intRange, DatePickerFormatter datePickerFormatter, SelectableDates selectableDates, DatePickerColors datePickerColors, FocusRequester focusRequester, DisplayMode displayMode, Composer composer, int i) {
        int i2;
        ComposerKt.sourceInformation(composer, "CN(mode:c#material3.DisplayMode):DateRangePicker.kt#uh7d8r");
        if ((i & 6) == 0) {
            i2 = i | (composer.changed(displayMode.getValue()) ? 4 : 2);
        } else {
            i2 = i;
        }
        if (!composer.shouldExecute((i2 & 19) != 18, i2 & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-773828161, i2, -1, "androidx.compose.material3.SwitchableDateEntryContent.<anonymous> (DateRangePicker.kt:721)");
            }
            int value = displayMode.getValue();
            if (DisplayMode.m3272equalsimpl0(value, DisplayMode.INSTANCE.m3277getPickerjFl4v0())) {
                composer.startReplaceGroup(-619517270);
                ComposerKt.sourceInformation(composer, "723@32603L619");
                DateRangePickerContent(l, l2, j, function2, function1, calendarModel, intRange, datePickerFormatter, selectableDates, datePickerColors, composer, 0);
                composer.endReplaceGroup();
            } else {
                if (DisplayMode.m3272equalsimpl0(value, DisplayMode.INSTANCE.m3276getInputjFl4v0())) {
                    composer.startReplaceGroup(-619495944);
                    ComposerKt.sourceInformation(composer, "736@33272L537");
                    DateRangeInputKt.DateRangeInputContent(l, l2, function2, calendarModel, intRange, datePickerFormatter, selectableDates, datePickerColors, focusRequester, composer, 0);
                } else {
                    composer.startReplaceGroup(-2057528541);
                }
                composer.endReplaceGroup();
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    private static final void DateRangePickerContent(final Long l, final Long l2, final long j, final Function2<? super Long, ? super Long, Unit> function2, final Function1<? super Long, Unit> function1, final CalendarModel calendarModel, final IntRange intRange, final DatePickerFormatter datePickerFormatter, final SelectableDates selectableDates, final DatePickerColors datePickerColors, Composer composer, final int i) {
        int i2;
        Long l3;
        Function2<? super Long, ? super Long, Unit> function3;
        Function1<? super Long, Unit> function4;
        SelectableDates selectableDates2;
        Object obj;
        DateRangePickerKt$DateRangePickerContent$1$1 dateRangePickerKt$DateRangePickerContent$1$1;
        Composer composerStartRestartGroup = composer.startRestartGroup(-787063721);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(DateRangePickerContent)N(selectedStartDateMillis,selectedEndDateMillis,displayedMonthMillis,onDatesSelectionChange,onDisplayedMonthChange,calendarModel,yearRange,dateFormatter,selectableDates,colors)767@34501L64,770@34655L309,770@34628L336,778@34970L649:DateRangePicker.kt#uh7d8r");
        if ((i & 6) == 0) {
            i2 = (composerStartRestartGroup.changed(l) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 48) == 0) {
            l3 = l2;
            i2 |= composerStartRestartGroup.changed(l3) ? 32 : 16;
        } else {
            l3 = l2;
        }
        if ((i & 384) == 0) {
            i2 |= composerStartRestartGroup.changed(j) ? 256 : 128;
        }
        if ((i & 3072) == 0) {
            function3 = function2;
            i2 |= composerStartRestartGroup.changedInstance(function3) ? 2048 : 1024;
        } else {
            function3 = function2;
        }
        if ((i & 24576) == 0) {
            function4 = function1;
            i2 |= composerStartRestartGroup.changedInstance(function4) ? 16384 : 8192;
        } else {
            function4 = function1;
        }
        if ((196608 & i) == 0) {
            i2 |= composerStartRestartGroup.changedInstance(calendarModel) ? 131072 : 65536;
        }
        if ((1572864 & i) == 0) {
            i2 |= composerStartRestartGroup.changedInstance(intRange) ? 1048576 : 524288;
        }
        if ((12582912 & i) == 0) {
            i2 |= (16777216 & i) == 0 ? composerStartRestartGroup.changed(datePickerFormatter) : composerStartRestartGroup.changedInstance(datePickerFormatter) ? 8388608 : 4194304;
        }
        if ((100663296 & i) == 0) {
            selectableDates2 = selectableDates;
            i2 |= composerStartRestartGroup.changed(selectableDates2) ? 67108864 : 33554432;
        } else {
            selectableDates2 = selectableDates;
        }
        if ((i & 805306368) == 0) {
            i2 |= composerStartRestartGroup.changed(datePickerColors) ? C.BUFFER_FLAG_LAST_SAMPLE : 268435456;
        }
        if (!composerStartRestartGroup.shouldExecute((i2 & 306783379) != 306783378, i2 & 1)) {
            composerStartRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-787063721, i2, -1, "androidx.compose.material3.DateRangePickerContent (DateRangePicker.kt:764)");
            }
            int iCoerceAtLeast = RangesKt.coerceAtLeast(calendarModel.getMonth(j).indexIn(intRange), 0);
            LazyListState lazyListStateRememberLazyListState = LazyListStateKt.rememberLazyListState(iCoerceAtLeast, 0, composerStartRestartGroup, 0, 2);
            Integer numValueOf = Integer.valueOf(iCoerceAtLeast);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -453966964, "CC(remember):DateRangePicker.kt#9igjgp");
            boolean zChanged = composerStartRestartGroup.changed(lazyListStateRememberLazyListState) | composerStartRestartGroup.changed(iCoerceAtLeast);
            Object objRememberedValue = composerStartRestartGroup.rememberedValue();
            if (zChanged || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                obj = null;
                dateRangePickerKt$DateRangePickerContent$1$1 = new DateRangePickerKt$DateRangePickerContent$1$1(lazyListStateRememberLazyListState, iCoerceAtLeast, null);
                composerStartRestartGroup.updateRememberedValue(dateRangePickerKt$DateRangePickerContent$1$1);
            } else {
                dateRangePickerKt$DateRangePickerContent$1$1 = objRememberedValue;
                obj = null;
            }
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            EffectsKt.LaunchedEffect(numValueOf, (Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object>) dateRangePickerKt$DateRangePickerContent$1$1, composerStartRestartGroup, 0);
            Modifier modifierM1220paddingVpY3zN4$default = PaddingKt.m1220paddingVpY3zN4$default(Modifier.INSTANCE, DatePickerKt.getDatePickerHorizontalPadding(), 0.0f, 2, obj);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -483455358, "CC(Column)P(2,3,1)87@4442L61,88@4508L133:Column.kt#2w3rfo");
            MeasurePolicy measurePolicyColumnMeasurePolicy = ColumnKt.columnMeasurePolicy(Arrangement.INSTANCE.getTop(), Alignment.INSTANCE.getStart(), composerStartRestartGroup, 0);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1323940314, "CC(Layout)P(!1,2)79@3206L23,82@3357L359:Layout.kt#80mrfh");
            int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, 0);
            CompositionLocalMap currentCompositionLocalMap = composerStartRestartGroup.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierM1220paddingVpY3zN4$default);
            Function0<ComposeUiNode> constructor = ComposeUiNode.INSTANCE.getConstructor();
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -692256719, "CC(ReusableComposeNode)P(1,2)355@14017L9:Composables.kt#9igjgp");
            if (!(composerStartRestartGroup.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            composerStartRestartGroup.startReusableNode();
            if (composerStartRestartGroup.getInserting()) {
                composerStartRestartGroup.createNode(constructor);
            } else {
                composerStartRestartGroup.useNode();
            }
            Composer composerM6062constructorimpl = Updater.m6062constructorimpl(composerStartRestartGroup);
            Updater.m6070setimpl(composerM6062constructorimpl, measurePolicyColumnMeasurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
            Updater.m6070setimpl(composerM6062constructorimpl, currentCompositionLocalMap, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
            if (composerM6062constructorimpl.getInserting() || !Intrinsics.areEqual(composerM6062constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                composerM6062constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                composerM6062constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
            }
            Updater.m6070setimpl(composerM6062constructorimpl, modifierMaterializeModifier, ComposeUiNode.INSTANCE.getSetModifier());
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -384672921, "C89@4556L9:Column.kt#2w3rfo");
            ColumnScopeInstance columnScopeInstance = ColumnScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1922743819, "C779@35058L31,780@35098L515:DateRangePicker.kt#uh7d8r");
            DatePickerKt.WeekDays(datePickerColors, calendarModel, composerStartRestartGroup, ((i2 >> 27) & 14) | ((i2 >> 12) & 112));
            VerticalMonthsList(lazyListStateRememberLazyListState, l, l3, function3, function4, calendarModel, intRange, datePickerFormatter, selectableDates2, datePickerColors, composerStartRestartGroup, ((i2 << 3) & 1008) | (i2 & 7168) | (57344 & i2) | (458752 & i2) | (3670016 & i2) | (29360128 & i2) | (234881024 & i2) | (1879048192 & i2));
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            composerStartRestartGroup.endNode();
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.DateRangePickerKt$$ExternalSyntheticLambda9
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj2, Object obj3) {
                    return DateRangePickerKt.DateRangePickerContent$lambda$2(l, l2, j, function2, function1, calendarModel, intRange, datePickerFormatter, selectableDates, datePickerColors, i, (Composer) obj2, ((Integer) obj3).intValue());
                }
            });
        }
    }

    private static final void VerticalMonthsList(LazyListState lazyListState, final Long l, final Long l2, final Function2<? super Long, ? super Long, Unit> function2, final Function1<? super Long, Unit> function1, final CalendarModel calendarModel, final IntRange intRange, final DatePickerFormatter datePickerFormatter, final SelectableDates selectableDates, final DatePickerColors datePickerColors, Composer composer, final int i) {
        int i2;
        Long l3;
        Long l4;
        Function2<? super Long, ? super Long, Unit> function3;
        Object month;
        DateRangePickerKt$VerticalMonthsList$2$1 dateRangePickerKt$VerticalMonthsList$2$1;
        final LazyListState lazyListState2 = lazyListState;
        Composer composerStartRestartGroup = composer.startRestartGroup(1257365001);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(VerticalMonthsList)N(lazyListState,selectedStartDateMillis,selectedEndDateMillis,onDatesSelectionChange,onDisplayedMonthChange,calendarModel,yearRange,dateFormatter,selectableDates,colors)815@36348L159,821@36569L5,821@36576L3982,821@36512L4046,902@40593L229,902@40563L259:DateRangePicker.kt#uh7d8r");
        if ((i & 6) == 0) {
            i2 = (composerStartRestartGroup.changed(lazyListState2) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 48) == 0) {
            l3 = l;
            i2 |= composerStartRestartGroup.changed(l3) ? 32 : 16;
        } else {
            l3 = l;
        }
        if ((i & 384) == 0) {
            l4 = l2;
            i2 |= composerStartRestartGroup.changed(l4) ? 256 : 128;
        } else {
            l4 = l2;
        }
        if ((i & 3072) == 0) {
            function3 = function2;
            i2 |= composerStartRestartGroup.changedInstance(function3) ? 2048 : 1024;
        } else {
            function3 = function2;
        }
        if ((i & 24576) == 0) {
            i2 |= composerStartRestartGroup.changedInstance(function1) ? 16384 : 8192;
        }
        if ((196608 & i) == 0) {
            i2 |= composerStartRestartGroup.changedInstance(calendarModel) ? 131072 : 65536;
        }
        if ((1572864 & i) == 0) {
            i2 |= composerStartRestartGroup.changedInstance(intRange) ? 1048576 : 524288;
        }
        if ((12582912 & i) == 0) {
            i2 |= (16777216 & i) == 0 ? composerStartRestartGroup.changed(datePickerFormatter) : composerStartRestartGroup.changedInstance(datePickerFormatter) ? 8388608 : 4194304;
        }
        if ((100663296 & i) == 0) {
            i2 |= composerStartRestartGroup.changed(selectableDates) ? 67108864 : 33554432;
        }
        if ((805306368 & i) == 0) {
            i2 |= composerStartRestartGroup.changed(datePickerColors) ? C.BUFFER_FLAG_LAST_SAMPLE : 268435456;
        }
        if (!composerStartRestartGroup.shouldExecute((i2 & 306783379) != 306783378, i2 & 1)) {
            composerStartRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1257365001, i2, -1, "androidx.compose.material3.VerticalMonthsList (DateRangePicker.kt:812)");
            }
            final CalendarDate today = calendarModel.getToday();
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1441972168, "CC(remember):DateRangePicker.kt#9igjgp");
            boolean zChanged = composerStartRestartGroup.changed(intRange);
            Object objRememberedValue = composerStartRestartGroup.rememberedValue();
            if (zChanged || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                month = calendarModel.getMonth(intRange.getFirst(), 1);
                composerStartRestartGroup.updateRememberedValue(month);
            } else {
                month = objRememberedValue;
            }
            final CalendarMonth calendarMonth = (CalendarMonth) month;
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            final Long l5 = l3;
            final Function2<? super Long, ? super Long, Unit> function4 = function3;
            int i3 = i2;
            final Long l6 = l4;
            TextKt.ProvideTextStyle(TypographyKt.getValue(DatePickerModalTokens.INSTANCE.getDateLabelTextFont(), composerStartRestartGroup, 6), ComposableLambdaKt.rememberComposableLambda(1090773432, true, new Function2() { // from class: androidx.compose.material3.DateRangePickerKt$$ExternalSyntheticLambda10
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return DateRangePickerKt.VerticalMonthsList$lambda$1(l5, l6, function4, lazyListState2, intRange, calendarModel, calendarMonth, datePickerFormatter, datePickerColors, today, selectableDates, (Composer) obj, ((Integer) obj2).intValue());
                }
            }, composerStartRestartGroup, 54), composerStartRestartGroup, 48);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1442108078, "CC(remember):DateRangePicker.kt#9igjgp");
            int i4 = i3 & 14;
            boolean zChangedInstance = (i4 == 4) | ((i3 & 57344) == 16384) | composerStartRestartGroup.changedInstance(calendarModel) | composerStartRestartGroup.changedInstance(intRange);
            Object objRememberedValue2 = composerStartRestartGroup.rememberedValue();
            if (zChangedInstance || objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                lazyListState2 = lazyListState;
                dateRangePickerKt$VerticalMonthsList$2$1 = new DateRangePickerKt$VerticalMonthsList$2$1(lazyListState2, function1, calendarModel, intRange, null);
                composerStartRestartGroup.updateRememberedValue(dateRangePickerKt$VerticalMonthsList$2$1);
            } else {
                dateRangePickerKt$VerticalMonthsList$2$1 = objRememberedValue2;
                lazyListState2 = lazyListState;
            }
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            EffectsKt.LaunchedEffect(lazyListState2, (Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object>) dateRangePickerKt$VerticalMonthsList$2$1, composerStartRestartGroup, i4);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.DateRangePickerKt$$ExternalSyntheticLambda12
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return DateRangePickerKt.VerticalMonthsList$lambda$3(lazyListState2, l, l2, function2, function1, calendarModel, intRange, datePickerFormatter, selectableDates, datePickerColors, i, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit VerticalMonthsList$lambda$1(final Long l, final Long l2, final Function2 function2, final LazyListState lazyListState, final IntRange intRange, final CalendarModel calendarModel, final CalendarMonth calendarMonth, final DatePickerFormatter datePickerFormatter, final DatePickerColors datePickerColors, final CalendarDate calendarDate, final SelectableDates selectableDates, Composer composer, int i) {
        ComposerKt.sourceInformation(composer, "C822@36607L24,823@36673L59,824@36770L55,828@37006L318,849@37841L116,853@38004L2548,845@37628L2924:DateRangePicker.kt#uh7d8r");
        if (!composer.shouldExecute((i & 3) != 2, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1090773432, i, -1, "androidx.compose.material3.VerticalMonthsList.<anonymous> (DateRangePicker.kt:822)");
            }
            ComposerKt.sourceInformationMarkerStart(composer, 773894976, "CC(rememberCoroutineScope)N(getContext)608@27648L68:Effects.kt#9igjgp");
            ComposerKt.sourceInformationMarkerStart(composer, 683737348, "CC(remember):Effects.kt#9igjgp");
            Object objRememberedValue = composer.rememberedValue();
            if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                objRememberedValue = EffectsKt.createCompositionCoroutineScope(EmptyCoroutineContext.INSTANCE, composer);
                composer.updateRememberedValue(objRememberedValue);
            }
            CoroutineScope coroutineScope = (CoroutineScope) objRememberedValue;
            ComposerKt.sourceInformationMarkerEnd(composer);
            ComposerKt.sourceInformationMarkerEnd(composer);
            Strings.Companion companion = Strings.INSTANCE;
            String strM5086getString2EP1pXo = Strings_androidKt.m5086getString2EP1pXo(Strings.m5002constructorimpl(R.string.m3c_date_range_picker_scroll_to_previous_month), composer, 0);
            Strings.Companion companion2 = Strings.INSTANCE;
            String strM5086getString2EP1pXo2 = Strings_androidKt.m5086getString2EP1pXo(Strings.m5002constructorimpl(R.string.m3c_date_range_picker_scroll_to_next_month), composer, 0);
            ComposerKt.sourceInformationMarkerStart(composer, 261262006, "CC(remember):DateRangePicker.kt#9igjgp");
            boolean zChanged = composer.changed(l) | composer.changed(l2) | composer.changed(function2);
            Object objRememberedValue2 = composer.rememberedValue();
            if (zChanged || objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                objRememberedValue2 = new Function1() { // from class: androidx.compose.material3.DateRangePickerKt$$ExternalSyntheticLambda5
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return DateRangePickerKt.VerticalMonthsList$lambda$1$0$0(l, l2, function2, ((Long) obj).longValue());
                    }
                };
                composer.updateRememberedValue(objRememberedValue2);
            }
            final Function1 function1 = (Function1) objRememberedValue2;
            ComposerKt.sourceInformationMarkerEnd(composer);
            final List<CustomAccessibilityAction> listCustomScrollActions = customScrollActions(lazyListState, coroutineScope, strM5086getString2EP1pXo, strM5086getString2EP1pXo2);
            Modifier.Companion companion3 = Modifier.INSTANCE;
            ComposerKt.sourceInformationMarkerStart(composer, 261288524, "CC(remember):DateRangePicker.kt#9igjgp");
            Object objRememberedValue3 = composer.rememberedValue();
            if (objRememberedValue3 == Composer.INSTANCE.getEmpty()) {
                objRememberedValue3 = new Function1() { // from class: androidx.compose.material3.DateRangePickerKt$$ExternalSyntheticLambda6
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return DateRangePickerKt.VerticalMonthsList$lambda$1$1$0((SemanticsPropertyReceiver) obj);
                    }
                };
                composer.updateRememberedValue(objRememberedValue3);
            }
            ComposerKt.sourceInformationMarkerEnd(composer);
            Modifier modifierSemantics$default = SemanticsModifierKt.semantics$default(companion3, false, (Function1) objRememberedValue3, 1, null);
            ComposerKt.sourceInformationMarkerStart(composer, 261296172, "CC(remember):DateRangePicker.kt#9igjgp");
            boolean zChangedInstance = composer.changedInstance(intRange) | composer.changedInstance(calendarModel) | composer.changed(calendarMonth) | composer.changedInstance(datePickerFormatter) | composer.changedInstance(listCustomScrollActions) | composer.changed(datePickerColors) | composer.changed(l) | composer.changed(l2) | composer.changed(function1) | composer.changed(calendarDate) | composer.changed(selectableDates) | composer.changed(lazyListState);
            Object objRememberedValue4 = composer.rememberedValue();
            if (zChangedInstance || objRememberedValue4 == Composer.INSTANCE.getEmpty()) {
                Object obj = new Function1() { // from class: androidx.compose.material3.DateRangePickerKt$$ExternalSyntheticLambda7
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj2) {
                        return DateRangePickerKt.VerticalMonthsList$lambda$1$2$0(intRange, calendarModel, calendarMonth, l, l2, function1, calendarDate, datePickerFormatter, selectableDates, datePickerColors, lazyListState, listCustomScrollActions, (LazyListScope) obj2);
                    }
                };
                composer.updateRememberedValue(obj);
                objRememberedValue4 = obj;
            }
            ComposerKt.sourceInformationMarkerEnd(composer);
            LazyDslKt.LazyColumn(modifierSemantics$default, lazyListState, null, false, null, null, null, false, null, (Function1) objRememberedValue4, composer, 0, 508);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit VerticalMonthsList$lambda$1$0$0(Long l, Long l2, Function2 function2, long j) {
        updateDateSelection(j, l, l2, function2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit VerticalMonthsList$lambda$1$1$0(SemanticsPropertyReceiver semanticsPropertyReceiver) {
        SemanticsPropertiesKt.setVerticalScrollAxisRange(semanticsPropertyReceiver, new ScrollAxisRange(new Function0() { // from class: androidx.compose.material3.DateRangePickerKt$$ExternalSyntheticLambda3
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return Float.valueOf(DateRangePickerKt.VerticalMonthsList$lambda$1$1$0$0());
            }
        }, new Function0() { // from class: androidx.compose.material3.DateRangePickerKt$$ExternalSyntheticLambda4
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return Float.valueOf(DateRangePickerKt.VerticalMonthsList$lambda$1$1$0$1());
            }
        }, false, 4, null));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit VerticalMonthsList$lambda$1$2$0(IntRange intRange, final CalendarModel calendarModel, final CalendarMonth calendarMonth, final Long l, final Long l2, final Function1 function1, final CalendarDate calendarDate, final DatePickerFormatter datePickerFormatter, final SelectableDates selectableDates, final DatePickerColors datePickerColors, final LazyListState lazyListState, final List list, LazyListScope lazyListScope) {
        LazyListScope.items$default(lazyListScope, DatePickerKt.numberOfMonthsInRange(intRange), null, null, ComposableLambdaKt.composableLambdaInstance(682334170, true, new Function4() { // from class: androidx.compose.material3.DateRangePickerKt$$ExternalSyntheticLambda24
            @Override // kotlin.jvm.functions.Function4
            public final Object invoke(Object obj, Object obj2, Object obj3, Object obj4) {
                return DateRangePickerKt.VerticalMonthsList$lambda$1$2$0$0(calendarModel, calendarMonth, l, l2, function1, calendarDate, datePickerFormatter, selectableDates, datePickerColors, lazyListState, list, (LazyItemScope) obj, ((Integer) obj2).intValue(), (Composer) obj3, ((Integer) obj4).intValue());
            }
        }), 6, null);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit VerticalMonthsList$lambda$1$2$0$0(final CalendarModel calendarModel, CalendarMonth calendarMonth, Long l, Long l2, Function1 function1, CalendarDate calendarDate, final DatePickerFormatter datePickerFormatter, SelectableDates selectableDates, final DatePickerColors datePickerColors, LazyListState lazyListState, final List list, LazyItemScope lazyItemScope, int i, Composer composer, int i2) {
        int i3;
        ComposerKt.sourceInformation(composer, "CN(it)856@38171L2357:DateRangePicker.kt#uh7d8r");
        if ((i2 & 6) == 0) {
            i3 = i2 | (composer.changed(lazyItemScope) ? 4 : 2);
        } else {
            i3 = i2;
        }
        if ((i2 & 48) == 0) {
            i3 |= composer.changed(i) ? 32 : 16;
        }
        if (!composer.shouldExecute((i3 & Token.DOTQUERY) != 146, i3 & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(682334170, i3, -1, "androidx.compose.material3.VerticalMonthsList.<anonymous>.<anonymous>.<anonymous>.<anonymous> (DateRangePicker.kt:855)");
            }
            final CalendarMonth calendarMonthPlusMonths = calendarModel.plusMonths(calendarMonth, i);
            SelectedRangeInfo selectedRangeInfo = null;
            Modifier modifierFillParentMaxWidth$default = LazyItemScope.fillParentMaxWidth$default(lazyItemScope, Modifier.INSTANCE, 0.0f, 1, null);
            ComposerKt.sourceInformationMarkerStart(composer, -483455358, "CC(Column)P(2,3,1)87@4442L61,88@4508L133:Column.kt#2w3rfo");
            MeasurePolicy measurePolicyColumnMeasurePolicy = ColumnKt.columnMeasurePolicy(Arrangement.INSTANCE.getTop(), Alignment.INSTANCE.getStart(), composer, 0);
            ComposerKt.sourceInformationMarkerStart(composer, -1323940314, "CC(Layout)P(!1,2)79@3206L23,82@3357L359:Layout.kt#80mrfh");
            int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composer, 0);
            CompositionLocalMap currentCompositionLocalMap = composer.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composer, modifierFillParentMaxWidth$default);
            Function0<ComposeUiNode> constructor = ComposeUiNode.INSTANCE.getConstructor();
            ComposerKt.sourceInformationMarkerStart(composer, -692256719, "CC(ReusableComposeNode)P(1,2)355@14017L9:Composables.kt#9igjgp");
            if (!(composer.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            composer.startReusableNode();
            if (composer.getInserting()) {
                composer.createNode(constructor);
            } else {
                composer.useNode();
            }
            Composer composerM6062constructorimpl = Updater.m6062constructorimpl(composer);
            Updater.m6070setimpl(composerM6062constructorimpl, measurePolicyColumnMeasurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
            Updater.m6070setimpl(composerM6062constructorimpl, currentCompositionLocalMap, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
            if (composerM6062constructorimpl.getInserting() || !Intrinsics.areEqual(composerM6062constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                composerM6062constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                composerM6062constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
            }
            Updater.m6070setimpl(composerM6062constructorimpl, modifierMaterializeModifier, ComposeUiNode.INSTANCE.getSetModifier());
            ComposerKt.sourceInformationMarkerStart(composer, -384672921, "C89@4556L9:Column.kt#2w3rfo");
            ColumnScopeInstance columnScopeInstance = ColumnScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart(composer, 185127235, "C857@38312L5,857@38319L653,857@38242L730,896@40485L2,883@39764L746:DateRangePicker.kt#uh7d8r");
            TextKt.ProvideTextStyle(TypographyKt.getValue(DatePickerModalTokens.INSTANCE.getRangeSelectionMonthSubheadFont(), composer, 6), ComposableLambdaKt.rememberComposableLambda(-577031469, true, new Function2() { // from class: androidx.compose.material3.DateRangePickerKt$$ExternalSyntheticLambda25
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return DateRangePickerKt.VerticalMonthsList$lambda$1$2$0$0$0$0(datePickerFormatter, calendarMonthPlusMonths, calendarModel, list, datePickerColors, (Composer) obj, ((Integer) obj2).intValue());
                }
            }, composer, 54), composer, 48);
            if (l != null && l2 != null) {
                composer.startReplaceGroup(185956701);
                ComposerKt.sourceInformation(composer, "872@39162L489");
                long jLongValue = l.longValue();
                long jLongValue2 = l2.longValue();
                ComposerKt.sourceInformationMarkerStart(composer, 1945662157, "CC(remember):DateRangePicker.kt#9igjgp");
                boolean zChanged = composer.changed(jLongValue) | composer.changed(jLongValue2);
                Object objRememberedValue = composer.rememberedValue();
                if (zChanged || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue = SelectedRangeInfo.INSTANCE.calculateRangeInfo(calendarMonthPlusMonths, calendarModel.getCanonicalDate(l.longValue()), calendarModel.getCanonicalDate(l2.longValue()));
                    composer.updateRememberedValue(objRememberedValue);
                }
                selectedRangeInfo = (SelectedRangeInfo) objRememberedValue;
                ComposerKt.sourceInformationMarkerEnd(composer);
                composer.endReplaceGroup();
            } else {
                composer.startReplaceGroup(186488258);
                composer.endReplaceGroup();
            }
            SelectedRangeInfo selectedRangeInfo2 = selectedRangeInfo;
            long utcTimeMillis = calendarDate.getUtcTimeMillis();
            Locale locale = calendarModel.getLocale();
            ComposerKt.sourceInformationMarkerStart(composer, 1945704006, "CC(remember):DateRangePicker.kt#9igjgp");
            Object objRememberedValue2 = composer.rememberedValue();
            if (objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                objRememberedValue2 = new Function0() { // from class: androidx.compose.material3.DateRangePickerKt$$ExternalSyntheticLambda1
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return Unit.INSTANCE;
                    }
                };
                composer.updateRememberedValue(objRememberedValue2);
            }
            ComposerKt.sourceInformationMarkerEnd(composer);
            DatePickerKt.Month(calendarMonthPlusMonths, function1, utcTimeMillis, l, l2, selectedRangeInfo2, datePickerFormatter, selectableDates, datePickerColors, locale, lazyListState, null, (Function0) objRememberedValue2, composer, 0, 432);
            ComposerKt.sourceInformationMarkerEnd(composer);
            ComposerKt.sourceInformationMarkerEnd(composer);
            composer.endNode();
            ComposerKt.sourceInformationMarkerEnd(composer);
            ComposerKt.sourceInformationMarkerEnd(composer);
            ComposerKt.sourceInformationMarkerEnd(composer);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit VerticalMonthsList$lambda$1$2$0$0$0$0(DatePickerFormatter datePickerFormatter, CalendarMonth calendarMonth, CalendarModel calendarModel, final List list, DatePickerColors datePickerColors, Composer composer, int i) {
        ComposerKt.sourceInformation(composer, "C866@38814L45,858@38345L605:DateRangePicker.kt#uh7d8r");
        if (!composer.shouldExecute((i & 3) != 2, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-577031469, i, -1, "androidx.compose.material3.VerticalMonthsList.<anonymous>.<anonymous>.<anonymous>.<anonymous>.<anonymous>.<anonymous> (DateRangePicker.kt:858)");
            }
            String monthYear = datePickerFormatter.formatMonthYear(Long.valueOf(calendarMonth.getStartUtcTimeMillis()), calendarModel.getLocale());
            if (monthYear == null) {
                monthYear = CacheKeyValueDelegate.CACHE_VALUE_SEPARATOR;
            }
            Modifier modifierPadding = PaddingKt.padding(Modifier.INSTANCE, CalendarMonthSubheadPadding);
            ComposerKt.sourceInformationMarkerStart(composer, -476444640, "CC(remember):DateRangePicker.kt#9igjgp");
            boolean zChangedInstance = composer.changedInstance(list);
            Object objRememberedValue = composer.rememberedValue();
            if (zChangedInstance || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                objRememberedValue = new Function1() { // from class: androidx.compose.material3.DateRangePickerKt$$ExternalSyntheticLambda19
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return DateRangePickerKt.VerticalMonthsList$lambda$1$2$0$0$0$0$0$0(list, (SemanticsPropertyReceiver) obj);
                    }
                };
                composer.updateRememberedValue(objRememberedValue);
            }
            ComposerKt.sourceInformationMarkerEnd(composer);
            TextKt.m4494TextNvy7gAk(monthYear, SemanticsModifierKt.semantics$default(modifierPadding, false, (Function1) objRememberedValue, 1, null), datePickerColors.getSubheadContentColor(), null, 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, null, composer, 0, 0, 262136);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit VerticalMonthsList$lambda$1$2$0$0$0$0$0$0(List list, SemanticsPropertyReceiver semanticsPropertyReceiver) {
        SemanticsPropertiesKt.setCustomActions(semanticsPropertyReceiver, list);
        return Unit.INSTANCE;
    }

    private static final void updateDateSelection(long j, Long l, Long l2, Function2<? super Long, ? super Long, Unit> function2) {
        if ((l == null && l2 == null) || (l != null && l2 != null)) {
            function2.invoke(Long.valueOf(j), null);
        } else if (l != null && j >= l.longValue()) {
            function2.invoke(l, Long.valueOf(j));
        } else {
            function2.invoke(Long.valueOf(j), null);
        }
    }

    public static final PaddingValues getCalendarMonthSubheadPadding() {
        return CalendarMonthSubheadPadding;
    }

    /* JADX INFO: renamed from: drawRangeBackground-mxwnekA, reason: not valid java name */
    public static final void m3230drawRangeBackgroundmxwnekA(ContentDrawScope contentDrawScope, SelectedRangeInfo selectedRangeInfo, long j) {
        float fIntBitsToFloat;
        float f = contentDrawScope.mo754toPx0680j_4(DatePickerKt.getRecommendedSizeForAccessibility());
        float f2 = contentDrawScope.mo754toPx0680j_4(DatePickerKt.getRecommendedSizeForAccessibility());
        float f3 = contentDrawScope.mo754toPx0680j_4(DatePickerModalTokens.INSTANCE.m5321getDateStateLayerHeightD9Ej5fM());
        float f4 = 2;
        float f5 = (f2 - f3) / f4;
        char c = ' ';
        float f6 = 7;
        float fIntBitsToFloat2 = (Float.intBitsToFloat((int) (contentDrawScope.mo7395getSizeNHjbRc() >> 32)) - (f6 * f)) / f6;
        long gridStartCoordinates = selectedRangeInfo.getGridStartCoordinates();
        int iM9815getXimpl = IntOffset.m9815getXimpl(gridStartCoordinates);
        int iM9816getYimpl = IntOffset.m9816getYimpl(gridStartCoordinates);
        long gridEndCoordinates = selectedRangeInfo.getGridEndCoordinates();
        int iM9815getXimpl2 = IntOffset.m9815getXimpl(gridEndCoordinates);
        int iM9816getYimpl2 = IntOffset.m9816getYimpl(gridEndCoordinates);
        float f7 = f + fIntBitsToFloat2;
        float f8 = fIntBitsToFloat2 / f4;
        float fIntBitsToFloat3 = (iM9815getXimpl * f7) + (selectedRangeInfo.getFirstIsSelectionStart() ? f / f4 : 0.0f) + f8;
        float f9 = (iM9816getYimpl * f2) + f5;
        float f10 = iM9815getXimpl2 * f7;
        if (selectedRangeInfo.getLastIsSelectionEnd()) {
            f /= f4;
        }
        float fIntBitsToFloat4 = f10 + f + f8;
        float f11 = (iM9816getYimpl2 * f2) + f5;
        boolean z = contentDrawScope.getLayoutDirection() == LayoutDirection.Rtl;
        if (z) {
            fIntBitsToFloat3 = Float.intBitsToFloat((int) (contentDrawScope.mo7395getSizeNHjbRc() >> 32)) - fIntBitsToFloat3;
            fIntBitsToFloat4 = Float.intBitsToFloat((int) (contentDrawScope.mo7395getSizeNHjbRc() >> 32)) - fIntBitsToFloat4;
        }
        ContentDrawScope contentDrawScope2 = contentDrawScope;
        long jM6561constructorimpl = Offset.m6561constructorimpl((((long) Float.floatToRawIntBits(fIntBitsToFloat3)) << 32) | (((long) Float.floatToRawIntBits(f9)) & 4294967295L));
        if (iM9816getYimpl == iM9816getYimpl2) {
            fIntBitsToFloat = fIntBitsToFloat4 - fIntBitsToFloat3;
        } else {
            fIntBitsToFloat = z ? -fIntBitsToFloat3 : Float.intBitsToFloat((int) (contentDrawScope.mo7395getSizeNHjbRc() >> 32)) - fIntBitsToFloat3;
        }
        DrawScope.m7389drawRectnJ9OG0$default(contentDrawScope2, j, jM6561constructorimpl, Size.m6629constructorimpl((((long) Float.floatToRawIntBits(fIntBitsToFloat)) << 32) | (((long) Float.floatToRawIntBits(f3)) & 4294967295L)), 0.0f, null, null, 0, 120, null);
        if (iM9816getYimpl != iM9816getYimpl2) {
            int i = (iM9816getYimpl2 - iM9816getYimpl) - 1;
            while (i > 0) {
                char c2 = c;
                DrawScope.m7389drawRectnJ9OG0$default(contentDrawScope2, j, Offset.m6561constructorimpl((((long) Float.floatToRawIntBits(0.0f)) << c2) | (((long) Float.floatToRawIntBits((i * f2) + f9)) & 4294967295L)), Size.m6629constructorimpl((((long) Float.floatToRawIntBits(Float.intBitsToFloat((int) (contentDrawScope.mo7395getSizeNHjbRc() >> c2)))) << c2) | (((long) Float.floatToRawIntBits(f3)) & 4294967295L)), 0.0f, null, null, 0, 120, null);
                i--;
                c = c2;
            }
            char c3 = c;
            long jM6561constructorimpl2 = Offset.m6561constructorimpl((((long) Float.floatToRawIntBits(f11)) & 4294967295L) | (((long) Float.floatToRawIntBits(contentDrawScope.getLayoutDirection() == LayoutDirection.Ltr ? 0.0f : Float.intBitsToFloat((int) (contentDrawScope.mo7395getSizeNHjbRc() >> c3)))) << c3));
            if (z) {
                fIntBitsToFloat4 -= Float.intBitsToFloat((int) (contentDrawScope.mo7395getSizeNHjbRc() >> c3));
            }
            DrawScope.m7389drawRectnJ9OG0$default(contentDrawScope2, j, jM6561constructorimpl2, Size.m6629constructorimpl((((long) Float.floatToRawIntBits(fIntBitsToFloat4)) << c3) | (((long) Float.floatToRawIntBits(f3)) & 4294967295L)), 0.0f, null, null, 0, 120, null);
        }
    }

    private static final List<CustomAccessibilityAction> customScrollActions(final LazyListState lazyListState, final CoroutineScope coroutineScope, String str, String str2) {
        return CollectionsKt.listOf((Object[]) new CustomAccessibilityAction[]{new CustomAccessibilityAction(str, new Function0() { // from class: androidx.compose.material3.DateRangePickerKt$$ExternalSyntheticLambda22
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return Boolean.valueOf(DateRangePickerKt.customScrollActions$lambda$0(lazyListState, coroutineScope));
            }
        }), new CustomAccessibilityAction(str2, new Function0() { // from class: androidx.compose.material3.DateRangePickerKt$$ExternalSyntheticLambda23
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return Boolean.valueOf(DateRangePickerKt.customScrollActions$lambda$1(lazyListState, coroutineScope));
            }
        })});
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean customScrollActions$lambda$0(LazyListState lazyListState, CoroutineScope coroutineScope) {
        if (!lazyListState.getCanScrollBackward()) {
            return false;
        }
        BuildersKt__Builders_commonKt.launch$default(coroutineScope, null, null, new DateRangePickerKt$customScrollActions$scrollUpAction$1$1(lazyListState, null), 3, null);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean customScrollActions$lambda$1(LazyListState lazyListState, CoroutineScope coroutineScope) {
        if (!lazyListState.getCanScrollForward()) {
            return false;
        }
        BuildersKt__Builders_commonKt.launch$default(coroutineScope, null, null, new DateRangePickerKt$customScrollActions$scrollDownAction$1$1(lazyListState, null), 3, null);
        return true;
    }

    static {
        float f = 64;
        float f2 = 12;
        DateRangePickerTitlePadding = PaddingKt.m1215PaddingValuesa9UjIt4$default(Dp.m9687constructorimpl(f), 0.0f, Dp.m9687constructorimpl(f2), 0.0f, 10, null);
        DateRangePickerHeadlinePadding = PaddingKt.m1215PaddingValuesa9UjIt4$default(Dp.m9687constructorimpl(f), 0.0f, Dp.m9687constructorimpl(f2), Dp.m9687constructorimpl(f2), 2, null);
    }
}
