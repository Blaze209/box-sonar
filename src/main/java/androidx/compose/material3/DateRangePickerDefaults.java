package androidx.compose.material3;

import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.RowKt;
import androidx.compose.foundation.layout.RowScopeInstance;
import androidx.compose.material3.internal.Strings;
import androidx.compose.material3.internal.Strings_androidKt;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.semantics.LiveRegionMode;
import androidx.compose.ui.semantics.SemanticsModifierKt;
import androidx.compose.ui.semantics.SemanticsPropertiesKt;
import androidx.compose.ui.semantics.SemanticsPropertyReceiver;
import androidx.compose.ui.unit.Dp;
import androidx.media3.common.C;
import com.microsoft.identity.common.java.cache.CacheKeyValueDelegate;
import external.sdk.pendo.io.mozilla.javascript.Token;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: DateRangePicker.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J+\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u000bH\u0007¢\u0006\u0004\b\f\u0010\rJG\u0010\u000e\u001a\u00020\u00052\b\u0010\u000f\u001a\u0004\u0018\u00010\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u00102\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u0012\u001a\u00020\u00132\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u000bH\u0007¢\u0006\u0004\b\u0014\u0010\u0015J\u0098\u0001\u0010\u000e\u001a\u00020\u00052\b\u0010\u000f\u001a\u0004\u0018\u00010\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u00102\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00172\u0011\u0010\u0019\u001a\r\u0012\u0004\u0012\u00020\u00050\u001a¢\u0006\u0002\b\u001b2\u0011\u0010\u001c\u001a\r\u0012\u0004\u0012\u00020\u00050\u001a¢\u0006\u0002\b\u001b2\u0011\u0010\u001d\u001a\r\u0012\u0004\u0012\u00020\u00050\u001a¢\u0006\u0002\b\u001b2\n\u0010\u001e\u001a\u00060\u001fj\u0002` H\u0003¢\u0006\u0004\b!\u0010\"¨\u0006#"}, d2 = {"Landroidx/compose/material3/DateRangePickerDefaults;", "", "<init>", "()V", "DateRangePickerTitle", "", "displayMode", "Landroidx/compose/material3/DisplayMode;", "modifier", "Landroidx/compose/ui/Modifier;", "contentColor", "Landroidx/compose/ui/graphics/Color;", "DateRangePickerTitle-FNtVw6o", "(ILandroidx/compose/ui/Modifier;JLandroidx/compose/runtime/Composer;II)V", "DateRangePickerHeadline", "selectedStartDateMillis", "", "selectedEndDateMillis", "dateFormatter", "Landroidx/compose/material3/DatePickerFormatter;", "DateRangePickerHeadline-qS89cEg", "(Ljava/lang/Long;Ljava/lang/Long;ILandroidx/compose/material3/DatePickerFormatter;Landroidx/compose/ui/Modifier;JLandroidx/compose/runtime/Composer;II)V", "startDateText", "", "endDateText", "startDatePlaceholder", "Lkotlin/Function0;", "Landroidx/compose/runtime/Composable;", "endDatePlaceholder", "datesDelimiter", "locale", "Ljava/util/Locale;", "Landroidx/compose/material3/CalendarLocale;", "DateRangePickerHeadline-nZrIstQ", "(Ljava/lang/Long;Ljava/lang/Long;ILandroidx/compose/material3/DatePickerFormatter;Landroidx/compose/ui/Modifier;JLjava/lang/String;Ljava/lang/String;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Ljava/util/Locale;Landroidx/compose/runtime/Composer;II)V", "material3"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class DateRangePickerDefaults {
    public static final int $stable = 0;
    public static final DateRangePickerDefaults INSTANCE = new DateRangePickerDefaults();

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit DateRangePickerHeadline_nZrIstQ$lambda$2(DateRangePickerDefaults dateRangePickerDefaults, Long l, Long l2, int i, DatePickerFormatter datePickerFormatter, Modifier modifier, long j, String str, String str2, Function2 function2, Function2 function3, Function2 function4, Locale locale, int i2, int i3, Composer composer, int i4) {
        dateRangePickerDefaults.m3218DateRangePickerHeadlinenZrIstQ(l, l2, i, datePickerFormatter, modifier, j, str, str2, function2, function3, function4, locale, composer, RecomposeScopeImplKt.updateChangedFlags(i2 | 1), RecomposeScopeImplKt.updateChangedFlags(i3));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit DateRangePickerHeadline_qS89cEg$lambda$3(DateRangePickerDefaults dateRangePickerDefaults, Long l, Long l2, int i, DatePickerFormatter datePickerFormatter, Modifier modifier, long j, int i2, int i3, Composer composer, int i4) {
        dateRangePickerDefaults.m3219DateRangePickerHeadlineqS89cEg(l, l2, i, datePickerFormatter, modifier, j, composer, RecomposeScopeImplKt.updateChangedFlags(i2 | 1), i3);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit DateRangePickerTitle_FNtVw6o$lambda$0(DateRangePickerDefaults dateRangePickerDefaults, int i, Modifier modifier, long j, int i2, int i3, Composer composer, int i4) {
        dateRangePickerDefaults.m3220DateRangePickerTitleFNtVw6o(i, modifier, j, composer, RecomposeScopeImplKt.updateChangedFlags(i2 | 1), i3);
        return Unit.INSTANCE;
    }

    private DateRangePickerDefaults() {
    }

    /* JADX WARN: Code duplicated, block: B:23:0x0042  */
    /* JADX WARN: Code duplicated, block: B:25:0x0046  */
    /* JADX WARN: Code duplicated, block: B:27:0x004e  */
    /* JADX WARN: Code duplicated, block: B:28:0x0051  */
    /* JADX WARN: Code duplicated, block: B:31:0x0057  */
    /* JADX WARN: Code duplicated, block: B:34:0x0060  */
    /* JADX WARN: Code duplicated, block: B:35:0x0062  */
    /* JADX WARN: Code duplicated, block: B:38:0x006b  */
    /* JADX WARN: Code duplicated, block: B:47:0x008a A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:48:0x008c  */
    /* JADX WARN: Code duplicated, block: B:49:0x0091  */
    /* JADX WARN: Code duplicated, block: B:52:0x0096  */
    /* JADX WARN: Code duplicated, block: B:56:0x00ae  */
    /* JADX WARN: Code duplicated, block: B:59:0x00c0  */
    /* JADX WARN: Code duplicated, block: B:60:0x0106  */
    /* JADX WARN: Code duplicated, block: B:62:0x0113  */
    /* JADX WARN: Code duplicated, block: B:63:0x0154  */
    /* JADX WARN: Code duplicated, block: B:67:0x0163  */
    /* JADX WARN: Code duplicated, block: B:69:0x0169  */
    /* JADX WARN: Code duplicated, block: B:72:0x0175  */
    /* JADX WARN: Code duplicated, block: B:74:? A[RETURN, SYNTHETIC] */
    /* JADX INFO: renamed from: DateRangePickerTitle-FNtVw6o, reason: not valid java name */
    public final void m3220DateRangePickerTitleFNtVw6o(final int i, Modifier modifier, long j, Composer composer, final int i2, final int i3) {
        int i4;
        Modifier modifier2;
        long titleContentColor;
        boolean z;
        Composer composer2;
        final Modifier modifier3;
        final long j2;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        Modifier.Companion companion;
        long j3;
        Modifier modifier4;
        Composer composerStartRestartGroup = composer.startRestartGroup(694693107);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(DateRangePickerTitle)N(displayMode:c#material3.DisplayMode,modifier,contentColor:c#ui.graphics.Color):DateRangePicker.kt#uh7d8r");
        if ((i2 & 6) == 0) {
            i4 = (composerStartRestartGroup.changed(i) ? 4 : 2) | i2;
        } else {
            i4 = i2;
        }
        int i5 = i3 & 2;
        if (i5 == 0) {
            if ((i2 & 48) == 0) {
                modifier2 = modifier;
                i4 |= composerStartRestartGroup.changed(modifier2) ? 32 : 16;
            }
            if ((i2 & 384) == 0) {
                if ((i3 & 4) == 0) {
                    titleContentColor = j;
                    int i6 = composerStartRestartGroup.changed(titleContentColor) ? 256 : 128;
                    i4 |= i6;
                } else {
                    titleContentColor = j;
                }
                i4 |= i6;
            } else {
                titleContentColor = j;
            }
            if ((i4 & Token.DOTQUERY) != 146) {
                z = true;
            } else {
                z = false;
            }
            if (composerStartRestartGroup.shouldExecute(z, i4 & 1)) {
                composerStartRestartGroup.startDefaults();
                ComposerKt.sourceInformation(composerStartRestartGroup, "370@17337L8");
                if ((i2 & 1) != 0 || composerStartRestartGroup.getDefaultsInvalid()) {
                    if (i5 != 0) {
                        companion = Modifier.INSTANCE;
                    } else {
                        companion = modifier2;
                    }
                    if ((i3 & 4) != 0) {
                        titleContentColor = DatePickerDefaults.INSTANCE.colors(composerStartRestartGroup, 6).getTitleContentColor();
                        i4 &= -897;
                    }
                    j3 = titleContentColor;
                    modifier4 = companion;
                } else {
                    composerStartRestartGroup.skipToGroupEnd();
                    if ((i3 & 4) != 0) {
                        i4 &= -897;
                    }
                    j3 = titleContentColor;
                    modifier4 = modifier2;
                }
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(694693107, i4, -1, "androidx.compose.material3.DateRangePickerDefaults.DateRangePickerTitle (DateRangePicker.kt:371)");
                }
                if (DisplayMode.m3272equalsimpl0(i, DisplayMode.INSTANCE.m3277getPickerjFl4v0())) {
                    composerStartRestartGroup.startReplaceGroup(1880153539);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "375@17478L48,374@17452L176");
                    Strings.Companion companion2 = Strings.INSTANCE;
                    TextKt.m4494TextNvy7gAk(Strings_androidKt.m5086getString2EP1pXo(Strings.m5002constructorimpl(R.string.m3c_date_range_picker_title), composerStartRestartGroup, 0), modifier4, j3, null, 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, null, composerStartRestartGroup, i4 & 1008, 0, 262136);
                    composer2 = composerStartRestartGroup;
                    composer2.endReplaceGroup();
                } else {
                    composer2 = composerStartRestartGroup;
                    if (DisplayMode.m3272equalsimpl0(i, DisplayMode.INSTANCE.m3276getInputjFl4v0())) {
                        composer2.startReplaceGroup(1880160770);
                        ComposerKt.sourceInformation(composer2, "381@17704L47,380@17678L175");
                        Strings.Companion companion3 = Strings.INSTANCE;
                        TextKt.m4494TextNvy7gAk(Strings_androidKt.m5086getString2EP1pXo(Strings.m5002constructorimpl(R.string.m3c_date_range_input_title), composer2, 0), modifier4, j3, null, 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, null, composer2, i4 & 1008, 0, 262136);
                    } else {
                        composer2.startReplaceGroup(-1862101265);
                    }
                    composer2.endReplaceGroup();
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                modifier3 = modifier4;
                j2 = j3;
            } else {
                composer2 = composerStartRestartGroup;
                composer2.skipToGroupEnd();
                modifier3 = modifier2;
                j2 = titleContentColor;
            }
            scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.DateRangePickerDefaults$$ExternalSyntheticLambda2
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return DateRangePickerDefaults.DateRangePickerTitle_FNtVw6o$lambda$0(this.f$0, i, modifier3, j2, i2, i3, (Composer) obj, ((Integer) obj2).intValue());
                    }
                });
            }
        }
        i4 |= 48;
        modifier2 = modifier;
        if ((i2 & 384) == 0) {
            if ((i3 & 4) == 0) {
                titleContentColor = j;
                if (composerStartRestartGroup.changed(titleContentColor)) {
                }
                i4 |= i6;
            } else {
                titleContentColor = j;
            }
            i4 |= i6;
        } else {
            titleContentColor = j;
        }
        if ((i4 & Token.DOTQUERY) != 146) {
            z = true;
        } else {
            z = false;
        }
        if (composerStartRestartGroup.shouldExecute(z, i4 & 1)) {
            composerStartRestartGroup.startDefaults();
            ComposerKt.sourceInformation(composerStartRestartGroup, "370@17337L8");
            if ((i2 & 1) != 0) {
                if (i5 != 0) {
                    companion = Modifier.INSTANCE;
                } else {
                    companion = modifier2;
                }
                if ((i3 & 4) != 0) {
                    titleContentColor = DatePickerDefaults.INSTANCE.colors(composerStartRestartGroup, 6).getTitleContentColor();
                    i4 &= -897;
                }
                j3 = titleContentColor;
                modifier4 = companion;
            } else {
                if (i5 != 0) {
                    companion = Modifier.INSTANCE;
                } else {
                    companion = modifier2;
                }
                if ((i3 & 4) != 0) {
                    titleContentColor = DatePickerDefaults.INSTANCE.colors(composerStartRestartGroup, 6).getTitleContentColor();
                    i4 &= -897;
                }
                j3 = titleContentColor;
                modifier4 = companion;
            }
            composerStartRestartGroup.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(694693107, i4, -1, "androidx.compose.material3.DateRangePickerDefaults.DateRangePickerTitle (DateRangePicker.kt:371)");
            }
            if (DisplayMode.m3272equalsimpl0(i, DisplayMode.INSTANCE.m3277getPickerjFl4v0())) {
                composerStartRestartGroup.startReplaceGroup(1880153539);
                ComposerKt.sourceInformation(composerStartRestartGroup, "375@17478L48,374@17452L176");
                Strings.Companion companion4 = Strings.INSTANCE;
                TextKt.m4494TextNvy7gAk(Strings_androidKt.m5086getString2EP1pXo(Strings.m5002constructorimpl(R.string.m3c_date_range_picker_title), composerStartRestartGroup, 0), modifier4, j3, null, 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, null, composerStartRestartGroup, i4 & 1008, 0, 262136);
                composer2 = composerStartRestartGroup;
                composer2.endReplaceGroup();
            } else {
                composer2 = composerStartRestartGroup;
                if (DisplayMode.m3272equalsimpl0(i, DisplayMode.INSTANCE.m3276getInputjFl4v0())) {
                    composer2.startReplaceGroup(1880160770);
                    ComposerKt.sourceInformation(composer2, "381@17704L47,380@17678L175");
                    Strings.Companion companion5 = Strings.INSTANCE;
                    TextKt.m4494TextNvy7gAk(Strings_androidKt.m5086getString2EP1pXo(Strings.m5002constructorimpl(R.string.m3c_date_range_input_title), composer2, 0), modifier4, j3, null, 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, null, composer2, i4 & 1008, 0, 262136);
                } else {
                    composer2.startReplaceGroup(-1862101265);
                }
                composer2.endReplaceGroup();
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            modifier3 = modifier4;
            j2 = j3;
        } else {
            composer2 = composerStartRestartGroup;
            composer2.skipToGroupEnd();
            modifier3 = modifier2;
            j2 = titleContentColor;
        }
        scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.DateRangePickerDefaults$$ExternalSyntheticLambda2
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return DateRangePickerDefaults.DateRangePickerTitle_FNtVw6o$lambda$0(this.f$0, i, modifier3, j2, i2, i3, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX WARN: Code duplicated, block: B:49:0x008a  */
    /* JADX WARN: Code duplicated, block: B:51:0x008e  */
    /* JADX WARN: Code duplicated, block: B:53:0x0096  */
    /* JADX WARN: Code duplicated, block: B:54:0x0099  */
    /* JADX WARN: Code duplicated, block: B:57:0x009f  */
    /* JADX WARN: Code duplicated, block: B:60:0x00a6  */
    /* JADX WARN: Code duplicated, block: B:62:0x00ae  */
    /* JADX WARN: Code duplicated, block: B:63:0x00b1  */
    /* JADX WARN: Code duplicated, block: B:65:0x00b5  */
    /* JADX WARN: Code duplicated, block: B:68:0x00c1  */
    /* JADX WARN: Code duplicated, block: B:69:0x00c3  */
    /* JADX WARN: Code duplicated, block: B:72:0x00cc  */
    /* JADX WARN: Code duplicated, block: B:81:0x00ee A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:82:0x00f0  */
    /* JADX WARN: Code duplicated, block: B:83:0x00f5  */
    /* JADX WARN: Code duplicated, block: B:86:0x00fa  */
    /* JADX WARN: Code duplicated, block: B:89:0x0110  */
    /* JADX WARN: Code duplicated, block: B:92:0x019a  */
    /* JADX WARN: Code duplicated, block: B:94:0x01a0  */
    /* JADX WARN: Code duplicated, block: B:97:0x01ab  */
    /* JADX WARN: Code duplicated, block: B:99:? A[RETURN, SYNTHETIC] */
    /* JADX INFO: renamed from: DateRangePickerHeadline-qS89cEg, reason: not valid java name */
    public final void m3219DateRangePickerHeadlineqS89cEg(final Long l, final Long l2, final int i, final DatePickerFormatter datePickerFormatter, Modifier modifier, long j, Composer composer, final int i2, final int i3) {
        Long l3;
        int i4;
        Long l4;
        int i5;
        Modifier modifier2;
        final long headlineContentColor;
        DateRangePickerDefaults dateRangePickerDefaults;
        boolean z;
        final Modifier modifier3;
        final long j2;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        Modifier.Companion companion;
        int i6;
        Composer composerStartRestartGroup = composer.startRestartGroup(1655228151);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(DateRangePickerHeadline)N(selectedStartDateMillis,selectedEndDateMillis,displayMode:c#material3.DisplayMode,dateFormatter,modifier,contentColor:c#ui.graphics.Color)410@19016L47,411@19090L45,421@19564L52,422@19651L50,423@19732L42,424@19797L15,412@19144L679:DateRangePicker.kt#uh7d8r");
        if ((i2 & 6) == 0) {
            l3 = l;
            i4 = (composerStartRestartGroup.changed(l3) ? 4 : 2) | i2;
        } else {
            l3 = l;
            i4 = i2;
        }
        if ((i2 & 48) == 0) {
            l4 = l2;
            i4 |= composerStartRestartGroup.changed(l4) ? 32 : 16;
        } else {
            l4 = l2;
        }
        if ((i2 & 384) == 0) {
            i5 = i;
            i4 |= composerStartRestartGroup.changed(i5) ? 256 : 128;
        } else {
            i5 = i;
        }
        if ((i2 & 3072) == 0) {
            i4 |= (i2 & 4096) == 0 ? composerStartRestartGroup.changed(datePickerFormatter) : composerStartRestartGroup.changedInstance(datePickerFormatter) ? 2048 : 1024;
        }
        int i7 = i3 & 16;
        if (i7 == 0) {
            if ((i2 & 24576) == 0) {
                modifier2 = modifier;
                i4 |= composerStartRestartGroup.changed(modifier2) ? 16384 : 8192;
            }
            if ((196608 & i2) == 0) {
                if ((i3 & 32) == 0) {
                    headlineContentColor = j;
                    int i8 = composerStartRestartGroup.changed(headlineContentColor) ? 131072 : 65536;
                    i4 |= i8;
                } else {
                    headlineContentColor = j;
                }
                i4 |= i8;
            } else {
                headlineContentColor = j;
            }
            if ((1572864 & i2) == 0) {
                dateRangePickerDefaults = this;
                if (composerStartRestartGroup.changed(dateRangePickerDefaults)) {
                    i6 = 1048576;
                } else {
                    i6 = 524288;
                }
                i4 |= i6;
            } else {
                dateRangePickerDefaults = this;
            }
            if ((599187 & i4) != 599186) {
                z = true;
            } else {
                z = false;
            }
            if (composerStartRestartGroup.shouldExecute(z, i4 & 1)) {
                composerStartRestartGroup.startDefaults();
                ComposerKt.sourceInformation(composerStartRestartGroup, "408@18949L8");
                if ((i2 & 1) != 0 || composerStartRestartGroup.getDefaultsInvalid()) {
                    if (i7 != 0) {
                        companion = Modifier.INSTANCE;
                    } else {
                        companion = modifier2;
                    }
                    if ((i3 & 32) != 0) {
                        i4 &= -458753;
                        headlineContentColor = DatePickerDefaults.INSTANCE.colors(composerStartRestartGroup, 6).getHeadlineContentColor();
                    }
                } else {
                    composerStartRestartGroup.skipToGroupEnd();
                    if ((i3 & 32) != 0) {
                        i4 &= -458753;
                    }
                    companion = modifier2;
                }
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(1655228151, i4, -1, "androidx.compose.material3.DateRangePickerDefaults.DateRangePickerHeadline (DateRangePicker.kt:409)");
                }
                Strings.Companion companion2 = Strings.INSTANCE;
                final String strM5086getString2EP1pXo = Strings_androidKt.m5086getString2EP1pXo(Strings.m5002constructorimpl(R.string.m3c_date_range_picker_start_headline), composerStartRestartGroup, 0);
                Strings.Companion companion3 = Strings.INSTANCE;
                final String strM5086getString2EP1pXo2 = Strings_androidKt.m5086getString2EP1pXo(Strings.m5002constructorimpl(R.string.m3c_date_range_picker_end_headline), composerStartRestartGroup, 0);
                int i9 = (458752 & i4) | (i4 & 14) | 905969664 | (i4 & 112) | (i4 & 896) | (i4 & 7168) | (57344 & i4);
                int i10 = ((i4 >> 12) & 896) | 6;
                int i11 = i5;
                Modifier modifier4 = companion;
                long j3 = headlineContentColor;
                dateRangePickerDefaults.m3218DateRangePickerHeadlinenZrIstQ(l3, l4, i11, datePickerFormatter, modifier4, j3, strM5086getString2EP1pXo, strM5086getString2EP1pXo2, ComposableLambdaKt.rememberComposableLambda(850203865, true, new Function2() { // from class: androidx.compose.material3.DateRangePickerDefaults$$ExternalSyntheticLambda3
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return DateRangePickerDefaults.DateRangePickerHeadline_qS89cEg$lambda$0(strM5086getString2EP1pXo, headlineContentColor, (Composer) obj, ((Integer) obj2).intValue());
                    }
                }, composerStartRestartGroup, 54), ComposableLambdaKt.rememberComposableLambda(282231642, true, new Function2() { // from class: androidx.compose.material3.DateRangePickerDefaults$$ExternalSyntheticLambda4
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return DateRangePickerDefaults.DateRangePickerHeadline_qS89cEg$lambda$1(strM5086getString2EP1pXo2, headlineContentColor, (Composer) obj, ((Integer) obj2).intValue());
                    }
                }, composerStartRestartGroup, 54), ComposableLambdaKt.rememberComposableLambda(-320655704, true, new Function2() { // from class: androidx.compose.material3.DateRangePickerDefaults$$ExternalSyntheticLambda5
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return DateRangePickerDefaults.DateRangePickerHeadline_qS89cEg$lambda$2(headlineContentColor, (Composer) obj, ((Integer) obj2).intValue());
                    }
                }, composerStartRestartGroup, 54), CalendarLocale_androidKt.defaultLocale(composerStartRestartGroup, 0), composerStartRestartGroup, i9, i10);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                j2 = j3;
                modifier3 = modifier4;
            } else {
                composerStartRestartGroup.skipToGroupEnd();
                modifier3 = modifier2;
                j2 = headlineContentColor;
            }
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.DateRangePickerDefaults$$ExternalSyntheticLambda6
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return DateRangePickerDefaults.DateRangePickerHeadline_qS89cEg$lambda$3(this.f$0, l, l2, i, datePickerFormatter, modifier3, j2, i2, i3, (Composer) obj, ((Integer) obj2).intValue());
                    }
                });
            }
        }
        i4 |= 24576;
        modifier2 = modifier;
        if ((196608 & i2) == 0) {
            if ((i3 & 32) == 0) {
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
        if ((1572864 & i2) == 0) {
            dateRangePickerDefaults = this;
            if (composerStartRestartGroup.changed(dateRangePickerDefaults)) {
                i6 = 1048576;
            } else {
                i6 = 524288;
            }
            i4 |= i6;
        } else {
            dateRangePickerDefaults = this;
        }
        if ((599187 & i4) != 599186) {
            z = true;
        } else {
            z = false;
        }
        if (composerStartRestartGroup.shouldExecute(z, i4 & 1)) {
            composerStartRestartGroup.startDefaults();
            ComposerKt.sourceInformation(composerStartRestartGroup, "408@18949L8");
            if ((i2 & 1) != 0) {
                if (i7 != 0) {
                    companion = Modifier.INSTANCE;
                } else {
                    companion = modifier2;
                }
                if ((i3 & 32) != 0) {
                    i4 &= -458753;
                    headlineContentColor = DatePickerDefaults.INSTANCE.colors(composerStartRestartGroup, 6).getHeadlineContentColor();
                }
            } else {
                if (i7 != 0) {
                    companion = Modifier.INSTANCE;
                } else {
                    companion = modifier2;
                }
                if ((i3 & 32) != 0) {
                    i4 &= -458753;
                    headlineContentColor = DatePickerDefaults.INSTANCE.colors(composerStartRestartGroup, 6).getHeadlineContentColor();
                }
            }
            composerStartRestartGroup.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1655228151, i4, -1, "androidx.compose.material3.DateRangePickerDefaults.DateRangePickerHeadline (DateRangePicker.kt:409)");
            }
            Strings.Companion companion4 = Strings.INSTANCE;
            final String strM5086getString2EP1pXo3 = Strings_androidKt.m5086getString2EP1pXo(Strings.m5002constructorimpl(R.string.m3c_date_range_picker_start_headline), composerStartRestartGroup, 0);
            Strings.Companion companion5 = Strings.INSTANCE;
            final String strM5086getString2EP1pXo4 = Strings_androidKt.m5086getString2EP1pXo(Strings.m5002constructorimpl(R.string.m3c_date_range_picker_end_headline), composerStartRestartGroup, 0);
            int i12 = (458752 & i4) | (i4 & 14) | 905969664 | (i4 & 112) | (i4 & 896) | (i4 & 7168) | (57344 & i4);
            int i13 = ((i4 >> 12) & 896) | 6;
            int i14 = i5;
            Modifier modifier5 = companion;
            long j4 = headlineContentColor;
            dateRangePickerDefaults.m3218DateRangePickerHeadlinenZrIstQ(l3, l4, i14, datePickerFormatter, modifier5, j4, strM5086getString2EP1pXo3, strM5086getString2EP1pXo4, ComposableLambdaKt.rememberComposableLambda(850203865, true, new Function2() { // from class: androidx.compose.material3.DateRangePickerDefaults$$ExternalSyntheticLambda3
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return DateRangePickerDefaults.DateRangePickerHeadline_qS89cEg$lambda$0(strM5086getString2EP1pXo3, headlineContentColor, (Composer) obj, ((Integer) obj2).intValue());
                }
            }, composerStartRestartGroup, 54), ComposableLambdaKt.rememberComposableLambda(282231642, true, new Function2() { // from class: androidx.compose.material3.DateRangePickerDefaults$$ExternalSyntheticLambda4
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return DateRangePickerDefaults.DateRangePickerHeadline_qS89cEg$lambda$1(strM5086getString2EP1pXo4, headlineContentColor, (Composer) obj, ((Integer) obj2).intValue());
                }
            }, composerStartRestartGroup, 54), ComposableLambdaKt.rememberComposableLambda(-320655704, true, new Function2() { // from class: androidx.compose.material3.DateRangePickerDefaults$$ExternalSyntheticLambda5
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return DateRangePickerDefaults.DateRangePickerHeadline_qS89cEg$lambda$2(headlineContentColor, (Composer) obj, ((Integer) obj2).intValue());
                }
            }, composerStartRestartGroup, 54), CalendarLocale_androidKt.defaultLocale(composerStartRestartGroup, 0), composerStartRestartGroup, i12, i13);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            j2 = j4;
            modifier3 = modifier5;
        } else {
            composerStartRestartGroup.skipToGroupEnd();
            modifier3 = modifier2;
            j2 = headlineContentColor;
        }
        scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.DateRangePickerDefaults$$ExternalSyntheticLambda6
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return DateRangePickerDefaults.DateRangePickerHeadline_qS89cEg$lambda$3(this.f$0, l, l2, i, datePickerFormatter, modifier3, j2, i2, i3, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit DateRangePickerHeadline_qS89cEg$lambda$0(String str, long j, Composer composer, int i) {
        ComposerKt.sourceInformation(composer, "C421@19566L48:DateRangePicker.kt#uh7d8r");
        if (composer.shouldExecute((i & 3) != 2, i & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(850203865, i, -1, "androidx.compose.material3.DateRangePickerDefaults.DateRangePickerHeadline.<anonymous> (DateRangePicker.kt:421)");
            }
            TextKt.m4494TextNvy7gAk(str, null, j, null, 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, null, composer, 0, 0, 262138);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composer.skipToGroupEnd();
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit DateRangePickerHeadline_qS89cEg$lambda$1(String str, long j, Composer composer, int i) {
        ComposerKt.sourceInformation(composer, "C422@19653L46:DateRangePicker.kt#uh7d8r");
        if (composer.shouldExecute((i & 3) != 2, i & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(282231642, i, -1, "androidx.compose.material3.DateRangePickerDefaults.DateRangePickerHeadline.<anonymous> (DateRangePicker.kt:422)");
            }
            TextKt.m4494TextNvy7gAk(str, null, j, null, 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, null, composer, 0, 0, 262138);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composer.skipToGroupEnd();
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit DateRangePickerHeadline_qS89cEg$lambda$2(long j, Composer composer, int i) {
        ComposerKt.sourceInformation(composer, "C423@19734L38:DateRangePicker.kt#uh7d8r");
        if (composer.shouldExecute((i & 3) != 2, i & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-320655704, i, -1, "androidx.compose.material3.DateRangePickerDefaults.DateRangePickerHeadline.<anonymous> (DateRangePicker.kt:423)");
            }
            TextKt.m4494TextNvy7gAk(CacheKeyValueDelegate.CACHE_VALUE_SEPARATOR, null, j, null, 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, null, composer, 6, 0, 262138);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composer.skipToGroupEnd();
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: renamed from: DateRangePickerHeadline-nZrIstQ, reason: not valid java name */
    private final void m3218DateRangePickerHeadlinenZrIstQ(Long l, final Long l2, final int i, final DatePickerFormatter datePickerFormatter, final Modifier modifier, final long j, final String str, final String str2, final Function2<? super Composer, ? super Integer, Unit> function2, final Function2<? super Composer, ? super Integer, Unit> function3, final Function2<? super Composer, ? super Integer, Unit> function4, final Locale locale, Composer composer, final int i2, final int i3) {
        int i4;
        int i5;
        Long l3;
        Composer composer2;
        String str3;
        String strM5086getString2EP1pXo;
        Composer composerStartRestartGroup = composer.startRestartGroup(1381313200);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(DateRangePickerHeadline)N(selectedStartDateMillis,selectedEndDateMillis,displayMode:c#material3.DisplayMode,dateFormatter,modifier,contentColor:c#ui.graphics.Color,startDateText,endDateText,startDatePlaceholder,endDatePlaceholder,datesDelimiter,locale)504@23527L168,502@23453L792:DateRangePicker.kt#uh7d8r");
        if ((i2 & 6) == 0) {
            i4 = i2 | (composerStartRestartGroup.changed(l) ? 4 : 2);
        } else {
            i4 = i2;
        }
        if ((i2 & 48) == 0) {
            i4 |= composerStartRestartGroup.changed(l2) ? 32 : 16;
        }
        if ((i2 & 384) == 0) {
            i4 |= composerStartRestartGroup.changed(i) ? 256 : 128;
        }
        if ((i2 & 3072) == 0) {
            i4 |= (i2 & 4096) == 0 ? composerStartRestartGroup.changed(datePickerFormatter) : composerStartRestartGroup.changedInstance(datePickerFormatter) ? 2048 : 1024;
        }
        if ((i2 & 24576) == 0) {
            i4 |= composerStartRestartGroup.changed(modifier) ? 16384 : 8192;
        }
        if ((196608 & i2) == 0) {
            i4 |= composerStartRestartGroup.changed(j) ? 131072 : 65536;
        }
        if ((i2 & 1572864) == 0) {
            i4 |= composerStartRestartGroup.changed(str) ? 1048576 : 524288;
        }
        if ((i2 & 12582912) == 0) {
            i4 |= composerStartRestartGroup.changed(str2) ? 8388608 : 4194304;
        }
        if ((i2 & 100663296) == 0) {
            i4 |= composerStartRestartGroup.changedInstance(function2) ? 67108864 : 33554432;
        }
        if ((i2 & 805306368) == 0) {
            i4 |= composerStartRestartGroup.changedInstance(function3) ? C.BUFFER_FLAG_LAST_SAMPLE : 268435456;
        }
        int i6 = i4;
        if ((i3 & 6) == 0) {
            i5 = i3 | (composerStartRestartGroup.changedInstance(function4) ? 4 : 2);
        } else {
            i5 = i3;
        }
        if ((i3 & 48) == 0) {
            i5 |= composerStartRestartGroup.changedInstance(locale) ? 32 : 16;
        }
        if (!composerStartRestartGroup.shouldExecute(((i6 & 306783379) == 306783378 && (i5 & 19) == 18) ? false : true, i6 & 1)) {
            l3 = l;
            composer2 = composerStartRestartGroup;
            composer2.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1381313200, i6, i5, "androidx.compose.material3.DateRangePickerDefaults.DateRangePickerHeadline (DateRangePicker.kt:468)");
            }
            int i7 = i5;
            String date$default = DatePickerFormatter.formatDate$default(datePickerFormatter, l, locale, false, 4, null);
            l3 = l;
            String date$default2 = DatePickerFormatter.formatDate$default(datePickerFormatter, l2, locale, false, 4, null);
            String date = datePickerFormatter.formatDate(l3, locale, true);
            String str4 = "";
            if (date != null) {
                str3 = date$default2;
                composerStartRestartGroup.startReplaceGroup(297116715);
                composerStartRestartGroup.endReplaceGroup();
            } else {
                composerStartRestartGroup.startReplaceGroup(620868087);
                ComposerKt.sourceInformation(composerStartRestartGroup, "");
                if (DisplayMode.m3272equalsimpl0(i, DisplayMode.INSTANCE.m3277getPickerjFl4v0())) {
                    composerStartRestartGroup.startReplaceGroup(297124483);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "482@22593L51");
                    Strings.Companion companion = Strings.INSTANCE;
                    str3 = date$default2;
                    date = Strings_androidKt.m5086getString2EP1pXo(Strings.m5002constructorimpl(R.string.m3c_date_picker_no_selection_description), composerStartRestartGroup, 0);
                    composerStartRestartGroup.endReplaceGroup();
                } else {
                    str3 = date$default2;
                    if (DisplayMode.m3272equalsimpl0(i, DisplayMode.INSTANCE.m3276getInputjFl4v0())) {
                        composerStartRestartGroup.startReplaceGroup(297127454);
                        ComposerKt.sourceInformation(composerStartRestartGroup, "483@22686L46");
                        Strings.Companion companion2 = Strings.INSTANCE;
                        String strM5086getString2EP1pXo2 = Strings_androidKt.m5086getString2EP1pXo(Strings.m5002constructorimpl(R.string.m3c_date_input_no_input_description), composerStartRestartGroup, 0);
                        composerStartRestartGroup.endReplaceGroup();
                        date = strM5086getString2EP1pXo2;
                    } else {
                        composerStartRestartGroup.startReplaceGroup(621089518);
                        composerStartRestartGroup.endReplaceGroup();
                        date = "";
                    }
                }
                composerStartRestartGroup.endReplaceGroup();
            }
            String date2 = datePickerFormatter.formatDate(l2, locale, true);
            if (date2 != null) {
                composerStartRestartGroup.startReplaceGroup(297132617);
                composerStartRestartGroup.endReplaceGroup();
            } else {
                composerStartRestartGroup.startReplaceGroup(621359127);
                ComposerKt.sourceInformation(composerStartRestartGroup, "");
                if (DisplayMode.m3272equalsimpl0(i, DisplayMode.INSTANCE.m3277getPickerjFl4v0())) {
                    composerStartRestartGroup.startReplaceGroup(297140323);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "494@23088L51");
                    Strings.Companion companion3 = Strings.INSTANCE;
                    strM5086getString2EP1pXo = Strings_androidKt.m5086getString2EP1pXo(Strings.m5002constructorimpl(R.string.m3c_date_picker_no_selection_description), composerStartRestartGroup, 0);
                    composerStartRestartGroup.endReplaceGroup();
                } else {
                    if (DisplayMode.m3272equalsimpl0(i, DisplayMode.INSTANCE.m3276getInputjFl4v0())) {
                        composerStartRestartGroup.startReplaceGroup(297143294);
                        ComposerKt.sourceInformation(composerStartRestartGroup, "495@23181L46");
                        Strings.Companion companion4 = Strings.INSTANCE;
                        strM5086getString2EP1pXo = Strings_androidKt.m5086getString2EP1pXo(Strings.m5002constructorimpl(R.string.m3c_date_input_no_input_description), composerStartRestartGroup, 0);
                        composerStartRestartGroup.endReplaceGroup();
                    } else {
                        composerStartRestartGroup.startReplaceGroup(621580558);
                        composerStartRestartGroup.endReplaceGroup();
                    }
                    composerStartRestartGroup.endReplaceGroup();
                    date2 = str4;
                }
                str4 = strM5086getString2EP1pXo;
                composerStartRestartGroup.endReplaceGroup();
                date2 = str4;
            }
            final String str5 = str + ": " + date;
            final String str6 = str2 + ": " + date2;
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 297154488, "CC(remember):DateRangePicker.kt#9igjgp");
            boolean zChanged = composerStartRestartGroup.changed(str5) | composerStartRestartGroup.changed(str6);
            Object objRememberedValue = composerStartRestartGroup.rememberedValue();
            if (zChanged || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                objRememberedValue = new Function1() { // from class: androidx.compose.material3.DateRangePickerDefaults$$ExternalSyntheticLambda0
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return DateRangePickerDefaults.DateRangePickerHeadline_nZrIstQ$lambda$0$0(str5, str6, (SemanticsPropertyReceiver) obj);
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
            }
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            Modifier modifierClearAndSetSemantics = SemanticsModifierKt.clearAndSetSemantics(modifier, (Function1) objRememberedValue);
            Alignment.Vertical centerVertically = Alignment.INSTANCE.getCenterVertically();
            Arrangement.HorizontalOrVertical horizontalOrVerticalM1073spacedBy0680j_4 = Arrangement.INSTANCE.m1073spacedBy0680j_4(Dp.m9687constructorimpl(4));
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 693286680, "CC(Row)P(2,1,3)99@5124L58,100@5187L130:Row.kt#2w3rfo");
            MeasurePolicy measurePolicyRowMeasurePolicy = RowKt.rowMeasurePolicy(horizontalOrVerticalM1073spacedBy0680j_4, centerVertically, composerStartRestartGroup, 54);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1323940314, "CC(Layout)P(!1,2)79@3206L23,82@3357L359:Layout.kt#80mrfh");
            int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, 0);
            CompositionLocalMap currentCompositionLocalMap = composerStartRestartGroup.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierClearAndSetSemantics);
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
            Updater.m6070setimpl(composerM6062constructorimpl, measurePolicyRowMeasurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
            Updater.m6070setimpl(composerM6062constructorimpl, currentCompositionLocalMap, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
            if (composerM6062constructorimpl.getInserting() || !Intrinsics.areEqual(composerM6062constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                composerM6062constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                composerM6062constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
            }
            Updater.m6070setimpl(composerM6062constructorimpl, modifierMaterializeModifier, ComposeUiNode.INSTANCE.getSetModifier());
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -407735110, "C101@5232L9:Row.kt#2w3rfo");
            RowScopeInstance rowScopeInstance = RowScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -177408791, "C516@24035L16:DateRangePicker.kt#uh7d8r");
            if (date$default != null) {
                composerStartRestartGroup.startReplaceGroup(-177386503);
                ComposerKt.sourceInformation(composerStartRestartGroup, "512@23895L53");
                TextKt.m4494TextNvy7gAk(date$default, null, j, null, 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, null, composerStartRestartGroup, (i6 >> 9) & 896, 0, 262138);
                composer2 = composerStartRestartGroup;
                composer2.endReplaceGroup();
            } else {
                composer2 = composerStartRestartGroup;
                composer2.startReplaceGroup(-177297192);
                ComposerKt.sourceInformation(composer2, "514@23986L22");
                function2.invoke(composer2, Integer.valueOf((i6 >> 24) & 14));
                composer2.endReplaceGroup();
            }
            function4.invoke(composer2, Integer.valueOf(i7 & 14));
            if (str3 != null) {
                composer2.startReplaceGroup(-177171301);
                ComposerKt.sourceInformation(composer2, "518@24112L51");
                TextKt.m4494TextNvy7gAk(str3, null, j, null, 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, null, composer2, (i6 >> 9) & 896, 0, 262138);
                composer2.endReplaceGroup();
            } else {
                composer2.startReplaceGroup(-177083974);
                ComposerKt.sourceInformation(composer2, "520@24201L20");
                function3.invoke(composer2, Integer.valueOf((i6 >> 27) & 14));
                composer2.endReplaceGroup();
            }
            ComposerKt.sourceInformationMarkerEnd(composer2);
            ComposerKt.sourceInformationMarkerEnd(composer2);
            composer2.endNode();
            ComposerKt.sourceInformationMarkerEnd(composer2);
            ComposerKt.sourceInformationMarkerEnd(composer2);
            ComposerKt.sourceInformationMarkerEnd(composer2);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            final Long l4 = l3;
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.DateRangePickerDefaults$$ExternalSyntheticLambda1
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return DateRangePickerDefaults.DateRangePickerHeadline_nZrIstQ$lambda$2(this.f$0, l4, l2, i, datePickerFormatter, modifier, j, str, str2, function2, function3, function4, locale, i2, i3, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit DateRangePickerHeadline_nZrIstQ$lambda$0$0(String str, String str2, SemanticsPropertyReceiver semanticsPropertyReceiver) {
        SemanticsPropertiesKt.m8850setLiveRegionhR3wRGc(semanticsPropertyReceiver, LiveRegionMode.INSTANCE.m8824getPolite0phEisY());
        SemanticsPropertiesKt.setContentDescription(semanticsPropertyReceiver, str + ", " + str2);
        return Unit.INSTANCE;
    }
}
