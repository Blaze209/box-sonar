package expo.modules.ui;

import android.content.res.Configuration;
import androidx.compose.material3.DatePickerColors;
import androidx.compose.material3.DatePickerDefaults;
import androidx.compose.material3.DatePickerKt;
import androidx.compose.material3.DatePickerState;
import androidx.compose.material3.TimePickerColors;
import androidx.compose.material3.TimePickerDefaults;
import androidx.compose.material3.TimePickerKt;
import androidx.compose.material3.TimePickerLayoutType;
import androidx.compose.material3.TimePickerState;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.ProvidableCompositionLocal;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.platform.AndroidCompositionLocals_androidKt;
import expo.modules.kotlin.AppContext;
import expo.modules.kotlin.views.ComposableScope;
import expo.modules.kotlin.views.FunctionalComposableScope;
import external.sdk.pendo.io.mozilla.javascript.Token;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: compiled from: DatePickerView.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000&\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a-\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00042\u0012\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00010\u0006H\u0007¢\u0006\u0002\u0010\b\u001a3\u0010\t\u001a\u00020\u00012\b\b\u0002\u0010\n\u001a\u00020\u000b2\u0006\u0010\u0003\u001a\u00020\u00042\u0012\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00010\u0006H\u0007¢\u0006\u0002\u0010\f\u001a3\u0010\r\u001a\u00020\u00012\b\b\u0002\u0010\n\u001a\u00020\u000b2\u0006\u0010\u0003\u001a\u00020\u00042\u0012\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00010\u0006H\u0007¢\u0006\u0002\u0010\f¨\u0006\u000e"}, d2 = {"DateTimePickerContent", "", "Lexpo/modules/kotlin/views/FunctionalComposableScope;", "props", "Lexpo/modules/ui/DateTimePickerProps;", "onDateSelected", "Lkotlin/Function1;", "Lexpo/modules/ui/DatePickerResult;", "(Lexpo/modules/kotlin/views/FunctionalComposableScope;Lexpo/modules/ui/DateTimePickerProps;Lkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;I)V", "ExpoDatePicker", "modifier", "Landroidx/compose/ui/Modifier;", "(Landroidx/compose/ui/Modifier;Lexpo/modules/ui/DateTimePickerProps;Lkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;II)V", "ExpoTimePicker", "expo-ui_release"}, k = 2, mv = {2, 1, 0}, xi = 48)
public final class DatePickerViewKt {
    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit DateTimePickerContent$lambda$4(FunctionalComposableScope functionalComposableScope, DateTimePickerProps dateTimePickerProps, Function1 function1, int i, Composer composer, int i2) {
        DateTimePickerContent(functionalComposableScope, dateTimePickerProps, function1, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ExpoDatePicker$lambda$7(Modifier modifier, DateTimePickerProps dateTimePickerProps, Function1 function1, int i, int i2, Composer composer, int i3) {
        ExpoDatePicker(modifier, dateTimePickerProps, function1, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ExpoTimePicker$lambda$10(Modifier modifier, DateTimePickerProps dateTimePickerProps, Function1 function1, int i, int i2, Composer composer, int i3) {
        ExpoTimePicker(modifier, dateTimePickerProps, function1, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    public static final void DateTimePickerContent(final FunctionalComposableScope functionalComposableScope, DateTimePickerProps dateTimePickerProps, final Function1<? super DatePickerResult, Unit> onDateSelected, Composer composer, final int i) {
        int i2;
        boolean z;
        final DateTimePickerProps props = dateTimePickerProps;
        Intrinsics.checkNotNullParameter(functionalComposableScope, "<this>");
        Intrinsics.checkNotNullParameter(props, "props");
        Intrinsics.checkNotNullParameter(onDateSelected, "onDateSelected");
        Composer composerStartRestartGroup = composer.startRestartGroup(2052567908);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(DateTimePickerContent)P(1):DatePickerView.kt#v15e7d");
        if ((i & 6) == 0) {
            i2 = ((i & 8) == 0 ? composerStartRestartGroup.changed(functionalComposableScope) : composerStartRestartGroup.changedInstance(functionalComposableScope) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 48) == 0) {
            i2 |= composerStartRestartGroup.changedInstance(props) ? 32 : 16;
        }
        if ((i & 384) == 0) {
            i2 |= composerStartRestartGroup.changedInstance(onDateSelected) ? 256 : 128;
        }
        if ((i2 & Token.DOTQUERY) != 146 || !composerStartRestartGroup.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(2052567908, i2, -1, "expo.modules.ui.DateTimePickerContent (DatePickerView.kt:62)");
            }
            if (props.getDisplayedComponents() == DisplayedComponents.HOUR_AND_MINUTE) {
                composerStartRestartGroup.startReplaceGroup(601407813);
                ComposerKt.sourceInformation(composerStartRestartGroup, "64@2217L83,64@2302L32,64@2159L175");
                Modifier modifierApplyModifiers = ModifierRegistry.INSTANCE.applyModifiers(props.getModifiers(), functionalComposableScope.getAppContext(), functionalComposableScope.getComposableScope(), functionalComposableScope.getGlobalEventDispatcher(), composerStartRestartGroup, (AppContext.$stable << 3) | (ComposableScope.$stable << 6));
                composerStartRestartGroup.startReplaceGroup(5004770);
                ComposerKt.sourceInformation(composerStartRestartGroup, "CC(remember):DatePickerView.kt#9igjgp");
                z = (i2 & 896) == 256;
                Object objRememberedValue = composerStartRestartGroup.rememberedValue();
                if (z || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue = new Function1() { // from class: expo.modules.ui.DatePickerViewKt$$ExternalSyntheticLambda0
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            return DatePickerViewKt.DateTimePickerContent$lambda$1$lambda$0(onDateSelected, (DatePickerResult) obj);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                }
                composerStartRestartGroup.endReplaceGroup();
                ExpoTimePicker(modifierApplyModifiers, props, (Function1) objRememberedValue, composerStartRestartGroup, i2 & 112, 0);
                composerStartRestartGroup.endReplaceGroup();
                props = dateTimePickerProps;
            } else {
                composerStartRestartGroup.startReplaceGroup(601597285);
                ComposerKt.sourceInformation(composerStartRestartGroup, "68@2408L83,68@2493L32,68@2350L175");
                Modifier modifierApplyModifiers2 = ModifierRegistry.INSTANCE.applyModifiers(dateTimePickerProps.getModifiers(), functionalComposableScope.getAppContext(), functionalComposableScope.getComposableScope(), functionalComposableScope.getGlobalEventDispatcher(), composerStartRestartGroup, (ComposableScope.$stable << 6) | (AppContext.$stable << 3));
                composerStartRestartGroup.startReplaceGroup(5004770);
                ComposerKt.sourceInformation(composerStartRestartGroup, "CC(remember):DatePickerView.kt#9igjgp");
                z = (i2 & 896) == 256;
                Object objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                if (z || objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue2 = new Function1() { // from class: expo.modules.ui.DatePickerViewKt$$ExternalSyntheticLambda1
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            return DatePickerViewKt.DateTimePickerContent$lambda$3$lambda$2(onDateSelected, (DatePickerResult) obj);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                }
                composerStartRestartGroup.endReplaceGroup();
                props = dateTimePickerProps;
                ExpoDatePicker(modifierApplyModifiers2, props, (Function1) objRememberedValue2, composerStartRestartGroup, i2 & 112, 0);
                composerStartRestartGroup.endReplaceGroup();
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composerStartRestartGroup.skipToGroupEnd();
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: expo.modules.ui.DatePickerViewKt$$ExternalSyntheticLambda2
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return DatePickerViewKt.DateTimePickerContent$lambda$4(functionalComposableScope, props, onDateSelected, i, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit DateTimePickerContent$lambda$1$lambda$0(Function1 function1, DatePickerResult it) {
        Intrinsics.checkNotNullParameter(it, "it");
        function1.invoke(it);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit DateTimePickerContent$lambda$3$lambda$2(Function1 function1, DatePickerResult it) {
        Intrinsics.checkNotNullParameter(it, "it");
        function1.invoke(it);
        return Unit.INSTANCE;
    }

    public static final void ExpoDatePicker(Modifier modifier, final DateTimePickerProps props, final Function1<? super DatePickerResult, Unit> onDateSelected, Composer composer, final int i, final int i2) {
        Modifier modifier2;
        int i3;
        final Modifier modifier3;
        Intrinsics.checkNotNullParameter(props, "props");
        Intrinsics.checkNotNullParameter(onDateSelected, "onDateSelected");
        Composer composerStartRestartGroup = composer.startRestartGroup(73851819);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(ExpoDatePicker)P(!1,2)77@2743L7,81@2861L348,92@3254L75,92@3213L116,100@3467L8,96@3333L411:DatePickerView.kt#v15e7d");
        int i4 = i2 & 1;
        if (i4 != 0) {
            i3 = i | 6;
            modifier2 = modifier;
        } else if ((i & 6) == 0) {
            modifier2 = modifier;
            i3 = (composerStartRestartGroup.changed(modifier2) ? 4 : 2) | i;
        } else {
            modifier2 = modifier;
            i3 = i;
        }
        if ((i2 & 2) != 0) {
            i3 |= 48;
        } else if ((i & 48) == 0) {
            i3 |= composerStartRestartGroup.changedInstance(props) ? 32 : 16;
        }
        if ((i2 & 4) != 0) {
            i3 |= 384;
        } else if ((i & 384) == 0) {
            i3 |= composerStartRestartGroup.changedInstance(onDateSelected) ? 256 : 128;
        }
        if ((i3 & Token.DOTQUERY) != 146 || !composerStartRestartGroup.getSkipping()) {
            Modifier.Companion companion = i4 != 0 ? Modifier.INSTANCE : modifier2;
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(73851819, i3, -1, "expo.modules.ui.ExpoDatePicker (DatePickerView.kt:76)");
            }
            ProvidableCompositionLocal<Configuration> localConfiguration = AndroidCompositionLocals_androidKt.getLocalConfiguration();
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
            Object objConsume = composerStartRestartGroup.consume(localConfiguration);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            Locale locale = ((Configuration) objConsume).getLocales().get(0);
            int iM14681toDisplayModejFl4v0 = props.getVariant().m14681toDisplayModejFl4v0();
            Long initialDate = props.getInitialDate();
            composerStartRestartGroup.startReplaceGroup(-1633490746);
            ComposerKt.sourceInformation(composerStartRestartGroup, "CC(remember):DatePickerView.kt#9igjgp");
            boolean zChanged = composerStartRestartGroup.changed(iM14681toDisplayModejFl4v0) | composerStartRestartGroup.changed(initialDate);
            Object objRememberedValue = composerStartRestartGroup.rememberedValue();
            if (zChanged || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                Intrinsics.checkNotNull(locale);
                objRememberedValue = DatePickerKt.m3179DatePickerStatesHin3Bw(locale, Long.valueOf(initialDate != null ? initialDate.longValue() : new Date().getTime()), Long.valueOf(initialDate != null ? initialDate.longValue() : new Date().getTime()), DatePickerDefaults.INSTANCE.getYearRange(), iM14681toDisplayModejFl4v0, DatePickerDefaults.INSTANCE.getAllDates());
                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
            }
            DatePickerState datePickerState = (DatePickerState) objRememberedValue;
            composerStartRestartGroup.endReplaceGroup();
            Long selectedDateMillis = datePickerState.getSelectedDateMillis();
            composerStartRestartGroup.startReplaceGroup(-1633490746);
            ComposerKt.sourceInformation(composerStartRestartGroup, "CC(remember):DatePickerView.kt#9igjgp");
            boolean zChanged2 = ((i3 & 896) == 256) | composerStartRestartGroup.changed(datePickerState);
            DatePickerViewKt$ExpoDatePicker$1$1 datePickerViewKt$ExpoDatePicker$1$1RememberedValue = composerStartRestartGroup.rememberedValue();
            if (zChanged2 || datePickerViewKt$ExpoDatePicker$1$1RememberedValue == Composer.INSTANCE.getEmpty()) {
                datePickerViewKt$ExpoDatePicker$1$1RememberedValue = new DatePickerViewKt$ExpoDatePicker$1$1(onDateSelected, datePickerState, null);
                composerStartRestartGroup.updateRememberedValue(datePickerViewKt$ExpoDatePicker$1$1RememberedValue);
            }
            composerStartRestartGroup.endReplaceGroup();
            EffectsKt.LaunchedEffect(selectedDateMillis, (Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object>) datePickerViewKt$ExpoDatePicker$1$1RememberedValue, composerStartRestartGroup, 0);
            boolean showVariantToggle = props.getShowVariantToggle();
            DatePickerColors datePickerColorsColors = DatePickerDefaults.INSTANCE.colors(composerStartRestartGroup, 6);
            DatePickerColors datePickerColorsM3124copytNwlRmA = datePickerColorsColors.m3124copytNwlRmA((32374777 & 1) != 0 ? datePickerColorsColors.containerColor : 0L, (32374777 & 2) != 0 ? datePickerColorsColors.titleContentColor : UtilsKt.colorToComposeColor(props.getColor()), (32374777 & 4) != 0 ? datePickerColorsColors.headlineContentColor : UtilsKt.colorToComposeColor(props.getColor()), (32374777 & 8) != 0 ? datePickerColorsColors.weekdayContentColor : 0L, (32374777 & 16) != 0 ? datePickerColorsColors.subheadContentColor : 0L, (32374777 & 32) != 0 ? datePickerColorsColors.navigationContentColor : 0L, (32374777 & 64) != 0 ? datePickerColorsColors.yearContentColor : 0L, (32374777 & 128) != 0 ? datePickerColorsColors.disabledYearContentColor : 0L, (32374777 & 256) != 0 ? datePickerColorsColors.currentYearContentColor : 0L, (32374777 & 512) != 0 ? datePickerColorsColors.selectedYearContentColor : 0L, (32374777 & 1024) != 0 ? datePickerColorsColors.disabledSelectedYearContentColor : 0L, (32374777 & 2048) != 0 ? datePickerColorsColors.selectedYearContainerColor : 0L, (32374777 & 4096) != 0 ? datePickerColorsColors.disabledSelectedYearContainerColor : 0L, (32374777 & 8192) != 0 ? datePickerColorsColors.dayContentColor : 0L, (32374777 & 16384) != 0 ? datePickerColorsColors.disabledDayContentColor : 0L, (32374777 & 32768) != 0 ? datePickerColorsColors.selectedDayContentColor : 0L, (32374777 & 65536) != 0 ? datePickerColorsColors.disabledSelectedDayContentColor : 0L, (32374777 & 131072) != 0 ? datePickerColorsColors.selectedDayContainerColor : UtilsKt.colorToComposeColor(props.getColor()), (32374777 & 262144) != 0 ? datePickerColorsColors.disabledSelectedDayContainerColor : 0L, (32374777 & 524288) != 0 ? datePickerColorsColors.todayContentColor : 0L, (32374777 & 1048576) != 0 ? datePickerColorsColors.todayDateBorderColor : UtilsKt.colorToComposeColor(props.getColor()), (32374777 & 2097152) != 0 ? datePickerColorsColors.dayInSelectionRangeContainerColor : 0L, (32374777 & 4194304) != 0 ? datePickerColorsColors.dayInSelectionRangeContentColor : 0L, (32374777 & 8388608) != 0 ? datePickerColorsColors.dividerColor : 0L, (32374777 & 16777216) != 0 ? datePickerColorsColors.dateTextFieldColors : null);
            int i5 = (i3 << 3) & 112;
            Modifier modifier4 = companion;
            DatePickerKt.DatePicker(datePickerState, modifier4, null, datePickerColorsM3124copytNwlRmA, null, null, showVariantToggle, null, composerStartRestartGroup, i5, 180);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            modifier3 = modifier4;
        } else {
            composerStartRestartGroup.skipToGroupEnd();
            modifier3 = modifier2;
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: expo.modules.ui.DatePickerViewKt$$ExternalSyntheticLambda4
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return DatePickerViewKt.ExpoDatePicker$lambda$7(modifier3, props, onDateSelected, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    public static final void ExpoTimePicker(Modifier modifier, final DateTimePickerProps props, final Function1<? super DatePickerResult, Unit> onDateSelected, Composer composer, final int i, final int i2) {
        Modifier modifier2;
        int i3;
        final Modifier modifier3;
        Intrinsics.checkNotNullParameter(props, "props");
        Intrinsics.checkNotNullParameter(onDateSelected, "onDateSelected");
        Composer composerStartRestartGroup = composer.startRestartGroup(-369319700);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(ExpoTimePicker)P(!1,2)114@3974L403,131@4422L180,131@4381L221,143@4742L8,139@4606L368:DatePickerView.kt#v15e7d");
        int i4 = i2 & 1;
        if (i4 != 0) {
            i3 = i | 6;
            modifier2 = modifier;
        } else if ((i & 6) == 0) {
            modifier2 = modifier;
            i3 = (composerStartRestartGroup.changed(modifier2) ? 4 : 2) | i;
        } else {
            modifier2 = modifier;
            i3 = i;
        }
        if ((i2 & 2) != 0) {
            i3 |= 48;
        } else if ((i & 48) == 0) {
            i3 |= composerStartRestartGroup.changedInstance(props) ? 32 : 16;
        }
        if ((i2 & 4) != 0) {
            i3 |= 384;
        } else if ((i & 384) == 0) {
            i3 |= composerStartRestartGroup.changedInstance(onDateSelected) ? 256 : 128;
        }
        if ((i3 & Token.DOTQUERY) != 146 || !composerStartRestartGroup.getSkipping()) {
            Modifier.Companion companion = i4 != 0 ? Modifier.INSTANCE : modifier2;
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-369319700, i3, -1, "expo.modules.ui.ExpoTimePicker (DatePickerView.kt:111)");
            }
            Calendar calendar = Calendar.getInstance();
            Long initialDate = props.getInitialDate();
            boolean zIs24Hour = props.is24Hour();
            composerStartRestartGroup.startReplaceGroup(-1633490746);
            ComposerKt.sourceInformation(composerStartRestartGroup, "CC(remember):DatePickerView.kt#9igjgp");
            boolean zChanged = composerStartRestartGroup.changed(initialDate) | composerStartRestartGroup.changed(zIs24Hour);
            Object objRememberedValue = composerStartRestartGroup.rememberedValue();
            if (zChanged || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                Long initialDate2 = props.getInitialDate();
                if (initialDate2 != null) {
                    calendar.setTimeInMillis(initialDate2.longValue());
                } else {
                    calendar.setTime(new Date());
                }
                objRememberedValue = TimePickerKt.TimePickerState(calendar.get(11), calendar.get(12), props.is24Hour());
                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
            }
            TimePickerState timePickerState = (TimePickerState) objRememberedValue;
            composerStartRestartGroup.endReplaceGroup();
            Integer numValueOf = Integer.valueOf(timePickerState.getHour());
            Integer numValueOf2 = Integer.valueOf(timePickerState.getMinute());
            composerStartRestartGroup.startReplaceGroup(-1746271574);
            ComposerKt.sourceInformation(composerStartRestartGroup, "CC(remember):DatePickerView.kt#9igjgp");
            boolean zChangedInstance = ((i3 & 896) == 256) | composerStartRestartGroup.changedInstance(calendar) | composerStartRestartGroup.changedInstance(timePickerState);
            DatePickerViewKt$ExpoTimePicker$1$1 datePickerViewKt$ExpoTimePicker$1$1RememberedValue = composerStartRestartGroup.rememberedValue();
            if (zChangedInstance || datePickerViewKt$ExpoTimePicker$1$1RememberedValue == Composer.INSTANCE.getEmpty()) {
                datePickerViewKt$ExpoTimePicker$1$1RememberedValue = new DatePickerViewKt$ExpoTimePicker$1$1(calendar, timePickerState, onDateSelected, null);
                composerStartRestartGroup.updateRememberedValue(datePickerViewKt$ExpoTimePicker$1$1RememberedValue);
            }
            composerStartRestartGroup.endReplaceGroup();
            EffectsKt.LaunchedEffect(numValueOf, numValueOf2, (Function2) datePickerViewKt$ExpoTimePicker$1$1RememberedValue, composerStartRestartGroup, 0);
            int iM4582getVerticalQJTpgSE = TimePickerLayoutType.INSTANCE.m4582getVerticalQJTpgSE();
            int i5 = (i3 << 3) & 112;
            Modifier modifier4 = companion;
            TimePickerKt.m4557TimePickermT9BvqQ(timePickerState, modifier4, TimePickerColors.m4498copydVHXu7A$default(TimePickerDefaults.INSTANCE.colors(composerStartRestartGroup, 6), Color.m6813copywmQWz5c$default(UtilsKt.colorToComposeColor(props.getColor()), 0.3f, 0.0f, 0.0f, 0.0f, 14, null), UtilsKt.colorToComposeColor(props.getColor()), 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, UtilsKt.colorToComposeColor(props.getColor()), 0L, 0L, 0L, 15356, null), iM4582getVerticalQJTpgSE, composerStartRestartGroup, i5, 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            modifier3 = modifier4;
        } else {
            composerStartRestartGroup.skipToGroupEnd();
            modifier3 = modifier2;
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: expo.modules.ui.DatePickerViewKt$$ExternalSyntheticLambda3
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return DatePickerViewKt.ExpoTimePicker$lambda$10(modifier3, props, onDateSelected, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }
}
