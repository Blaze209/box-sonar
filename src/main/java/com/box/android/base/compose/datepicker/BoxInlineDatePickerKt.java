package com.box.android.base.compose.datepicker;

import androidx.compose.foundation.DarkThemeKt;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.material3.DatePickerColors;
import androidx.compose.material3.DatePickerDefaults;
import androidx.compose.material3.DatePickerKt;
import androidx.compose.material3.DatePickerState;
import androidx.compose.material3.SelectableDates;
import androidx.compose.material3.TextFieldDefaults;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.GraphicsLayerScope;
import androidx.compose.ui.layout.LayoutModifierKt;
import androidx.compose.ui.layout.Measurable;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.platform.TestTagKt;
import androidx.compose.ui.unit.Constraints;
import androidx.profileinstaller.ProfileVerifier;
import com.box.android.base.compose.BoxColorPalette;
import com.box.android.base.compose.BoxTheme;
import com.box.android.base.compose.BoxThemeKt;
import com.box.android.common.extensions.DateExtensionsKt;
import external.sdk.pendo.io.mozilla.javascript.Token;
import java.util.Date;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: compiled from: BoxInlineDatePicker.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000:\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u001aU\u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u00032\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00010\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u000b\u001a\u00020\fH\u0007¢\u0006\u0002\u0010\r\u001a\u001a\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0002\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u0010\u001a\u00020\u000fH\u0000\u001a\r\u0010\u0011\u001a\u00020\u0012H\u0003¢\u0006\u0002\u0010\u0013\u001a\r\u0010\u0014\u001a\u00020\u0001H\u0003¢\u0006\u0002\u0010\u0015\u001a\r\u0010\u0016\u001a\u00020\u0001H\u0003¢\u0006\u0002\u0010\u0015\u001a\r\u0010\u0017\u001a\u00020\u0001H\u0003¢\u0006\u0002\u0010\u0015¨\u0006\u0018"}, d2 = {"BoxInlineDatePicker", "", "initialDate", "Ljava/util/Date;", "onDateSelected", "Lkotlin/Function1;", "modifier", "Landroidx/compose/ui/Modifier;", "pickerScale", "", "selectableDatesStart", "showModeToggle", "", "(Ljava/util/Date;Lkotlin/jvm/functions/Function1;Landroidx/compose/ui/Modifier;FLjava/util/Date;ZLandroidx/compose/runtime/Composer;II)V", "resolveInitialSelectedDateMillis", "", "startDateMidnightMillis", "boxInlineDatePickerColors", "Landroidx/compose/material3/DatePickerColors;", "(Landroidx/compose/runtime/Composer;I)Landroidx/compose/material3/DatePickerColors;", "BoxInlineDatePickerPreview", "(Landroidx/compose/runtime/Composer;I)V", "BoxInlineDatePickerWithDatePreview", "BoxInlineDatePickerWithCustomStartDatePreview", "base_generalProdRelease"}, k = 2, mv = {2, 2, 0}, xi = 48)
public final class BoxInlineDatePickerKt {
    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit BoxInlineDatePicker$lambda$4(Date date, Function1 function1, Modifier modifier, float f, Date date2, boolean z, int i, int i2, Composer composer, int i3) {
        BoxInlineDatePicker(date, function1, modifier, f, date2, z, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit BoxInlineDatePickerPreview$lambda$0(int i, Composer composer, int i2) {
        BoxInlineDatePickerPreview(composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit BoxInlineDatePickerWithCustomStartDatePreview$lambda$0(int i, Composer composer, int i2) {
        BoxInlineDatePickerWithCustomStartDatePreview(composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit BoxInlineDatePickerWithDatePreview$lambda$0(int i, Composer composer, int i2) {
        BoxInlineDatePickerWithDatePreview(composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX WARN: Code duplicated, block: B:101:0x018c  */
    /* JADX WARN: Code duplicated, block: B:104:0x01aa  */
    /* JADX WARN: Code duplicated, block: B:106:0x01cc  */
    /* JADX WARN: Code duplicated, block: B:107:0x01ce  */
    /* JADX WARN: Code duplicated, block: B:110:0x01d5  */
    /* JADX WARN: Code duplicated, block: B:112:0x01dd  */
    /* JADX WARN: Code duplicated, block: B:114:0x01f2  */
    /* JADX WARN: Code duplicated, block: B:117:0x0225  */
    /* JADX WARN: Code duplicated, block: B:119:0x022e  */
    /* JADX WARN: Code duplicated, block: B:122:0x023c  */
    /* JADX WARN: Code duplicated, block: B:124:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:30:0x0059  */
    /* JADX WARN: Code duplicated, block: B:31:0x005c  */
    /* JADX WARN: Code duplicated, block: B:33:0x0060  */
    /* JADX WARN: Code duplicated, block: B:35:0x0068  */
    /* JADX WARN: Code duplicated, block: B:36:0x006b  */
    /* JADX WARN: Code duplicated, block: B:41:0x0075  */
    /* JADX WARN: Code duplicated, block: B:42:0x0078  */
    /* JADX WARN: Code duplicated, block: B:44:0x007c  */
    /* JADX WARN: Code duplicated, block: B:46:0x0084  */
    /* JADX WARN: Code duplicated, block: B:47:0x0087  */
    /* JADX WARN: Code duplicated, block: B:52:0x0093  */
    /* JADX WARN: Code duplicated, block: B:53:0x0095  */
    /* JADX WARN: Code duplicated, block: B:55:0x0098  */
    /* JADX WARN: Code duplicated, block: B:57:0x00a0  */
    /* JADX WARN: Code duplicated, block: B:58:0x00a3  */
    /* JADX WARN: Code duplicated, block: B:63:0x00b5  */
    /* JADX WARN: Code duplicated, block: B:64:0x00b7  */
    /* JADX WARN: Code duplicated, block: B:67:0x00c0 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:68:0x00c2  */
    /* JADX WARN: Code duplicated, block: B:69:0x00c7  */
    /* JADX WARN: Code duplicated, block: B:71:0x00ca  */
    /* JADX WARN: Code duplicated, block: B:72:0x00cc  */
    /* JADX WARN: Code duplicated, block: B:75:0x00d1  */
    /* JADX WARN: Code duplicated, block: B:76:0x00d3  */
    /* JADX WARN: Code duplicated, block: B:78:0x00d6  */
    /* JADX WARN: Code duplicated, block: B:79:0x00d9  */
    /* JADX WARN: Code duplicated, block: B:82:0x00e1  */
    /* JADX WARN: Code duplicated, block: B:85:0x00f9  */
    /* JADX WARN: Code duplicated, block: B:87:0x0101  */
    /* JADX WARN: Code duplicated, block: B:90:0x012a  */
    /* JADX WARN: Code duplicated, block: B:92:0x0132  */
    /* JADX WARN: Code duplicated, block: B:95:0x017a  */
    /* JADX WARN: Code duplicated, block: B:96:0x017c  */
    /* JADX WARN: Code duplicated, block: B:99:0x0184  */
    public static final void BoxInlineDatePicker(final Date date, final Function1<? super Date, Unit> onDateSelected, Modifier modifier, float f, Date date2, boolean z, Composer composer, final int i, final int i2) {
        int i3;
        Modifier modifier2;
        int i4;
        int i5;
        int i6;
        Date date3;
        int i7;
        int i8;
        boolean z2;
        int i9;
        boolean z3;
        final float f2;
        final Modifier modifier3;
        final Date date4;
        final boolean z4;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        Modifier.Companion companion;
        final float f3;
        Date date5;
        boolean z5;
        boolean zChanged;
        Object objRememberedValue;
        final long jLongValue;
        boolean zChanged2;
        Object objRememberedValue2;
        DatePickerState datePickerStateM3195rememberDatePickerStateEU0dCGE;
        boolean z6;
        boolean z7;
        BoxInlineDatePickerKt$BoxInlineDatePicker$1$1 boxInlineDatePickerKt$BoxInlineDatePicker$1$1RememberedValue;
        Modifier modifierFillMaxWidth$default;
        boolean z8;
        Object objRememberedValue3;
        Intrinsics.checkNotNullParameter(onDateSelected, "onDateSelected");
        Composer composerStartRestartGroup = composer.startRestartGroup(2008889128);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(BoxInlineDatePicker)N(initialDate,onDateSelected,modifier,pickerScale,selectableDatesStart,showModeToggle)64@3059L86,68@3183L133,72@3344L271,79@3653L366,79@3621L398,91@4044L27,93@4077L1356:BoxInlineDatePicker.kt#wc5a62");
        if ((i & 6) == 0) {
            i3 = (composerStartRestartGroup.changedInstance(date) ? 4 : 2) | i;
        } else {
            i3 = i;
        }
        if ((i & 48) == 0) {
            i3 |= composerStartRestartGroup.changedInstance(onDateSelected) ? 32 : 16;
        }
        int i10 = i2 & 4;
        if (i10 == 0) {
            if ((i & 384) == 0) {
                modifier2 = modifier;
                i3 |= composerStartRestartGroup.changed(modifier2) ? 256 : 128;
            }
            i4 = i2 & 8;
            if (i4 != 0) {
                if ((i & 3072) == 0) {
                    if (composerStartRestartGroup.changed(f)) {
                        i5 = 2048;
                    } else {
                        i5 = 1024;
                    }
                    i3 |= i5;
                }
                i6 = i2 & 16;
                if (i6 != 0) {
                    if ((i & 24576) == 0) {
                        date3 = date2;
                        if (composerStartRestartGroup.changedInstance(date3)) {
                            i7 = 16384;
                        } else {
                            i7 = 8192;
                        }
                        i3 |= i7;
                    }
                    i8 = i2 & 32;
                    if (i8 != 0) {
                        if ((196608 & i) == 0) {
                            z2 = z;
                            if (composerStartRestartGroup.changed(z2)) {
                                i9 = 131072;
                            } else {
                                i9 = 65536;
                            }
                            i3 |= i9;
                        }
                        if ((i3 & 74899) != 74898) {
                            z3 = true;
                        } else {
                            z3 = false;
                        }
                        if (composerStartRestartGroup.shouldExecute(z3, i3 & 1)) {
                            composerStartRestartGroup.skipToGroupEnd();
                            f2 = f;
                            modifier3 = modifier2;
                            date4 = date3;
                            z4 = z2;
                        } else {
                            if (i10 != 0) {
                                companion = Modifier.INSTANCE;
                            } else {
                                companion = modifier2;
                            }
                            if (i4 != 0) {
                                f3 = 0.0f;
                            } else {
                                f3 = f;
                            }
                            if (i6 != 0) {
                                date5 = null;
                            } else {
                                date5 = date3;
                            }
                            if (i8 != 0) {
                                z5 = false;
                            } else {
                                z5 = z2;
                            }
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(2008889128, i3, -1, "com.box.android.base.compose.datepicker.BoxInlineDatePicker (BoxInlineDatePicker.kt:63)");
                            }
                            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2102144606, "CC(remember):BoxInlineDatePicker.kt#9igjgp");
                            zChanged = composerStartRestartGroup.changed(date5);
                            objRememberedValue = composerStartRestartGroup.rememberedValue();
                            if (!zChanged || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                                objRememberedValue = Long.valueOf(DateExtensionsKt.toMidnightMillis$default(date5, null, 1, null));
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                            }
                            jLongValue = ((Number) objRememberedValue).longValue();
                            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2102148621, "CC(remember):BoxInlineDatePicker.kt#9igjgp");
                            zChanged2 = composerStartRestartGroup.changed(date) | composerStartRestartGroup.changed(jLongValue);
                            objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                            if (!zChanged2 || objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                                objRememberedValue2 = Long.valueOf(resolveInitialSelectedDateMillis(date, jLongValue));
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                            }
                            long jLongValue2 = ((Number) objRememberedValue2).longValue();
                            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                            Date date6 = date5;
                            datePickerStateM3195rememberDatePickerStateEU0dCGE = DatePickerKt.m3195rememberDatePickerStateEU0dCGE(Long.valueOf(jLongValue2), null, null, 0, new SelectableDates() { // from class: com.box.android.base.compose.datepicker.BoxInlineDatePickerKt$BoxInlineDatePicker$datePickerState$1
                                @Override // androidx.compose.material3.SelectableDates
                                public /* bridge */ boolean isSelectableYear(int i11) {
                                    return super.isSelectableYear(i11);
                                }

                                @Override // androidx.compose.material3.SelectableDates
                                public boolean isSelectableDate(long utcTimeMillis) {
                                    return utcTimeMillis >= jLongValue;
                                }
                            }, composerStartRestartGroup, 0, 14);
                            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2102163894, "CC(remember):BoxInlineDatePicker.kt#9igjgp");
                            boolean zChanged3 = composerStartRestartGroup.changed(datePickerStateM3195rememberDatePickerStateEU0dCGE);
                            if ((i3 & 112) == 32) {
                                z6 = true;
                            } else {
                                z6 = false;
                            }
                            z7 = zChanged3 | z6;
                            boxInlineDatePickerKt$BoxInlineDatePicker$1$1RememberedValue = composerStartRestartGroup.rememberedValue();
                            if (!z7 || boxInlineDatePickerKt$BoxInlineDatePicker$1$1RememberedValue == Composer.INSTANCE.getEmpty()) {
                                boxInlineDatePickerKt$BoxInlineDatePicker$1$1RememberedValue = new BoxInlineDatePickerKt$BoxInlineDatePicker$1$1(datePickerStateM3195rememberDatePickerStateEU0dCGE, onDateSelected, null);
                                composerStartRestartGroup.updateRememberedValue(boxInlineDatePickerKt$BoxInlineDatePicker$1$1RememberedValue);
                            }
                            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                            EffectsKt.LaunchedEffect(datePickerStateM3195rememberDatePickerStateEU0dCGE, (Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object>) boxInlineDatePickerKt$BoxInlineDatePicker$1$1RememberedValue, composerStartRestartGroup, 0);
                            DatePickerColors datePickerColorsBoxInlineDatePickerColors = boxInlineDatePickerColors(composerStartRestartGroup, 0);
                            if (f3 > 0.0f) {
                                composerStartRestartGroup.startReplaceGroup(743215735);
                                ComposerKt.sourceInformation(composerStartRestartGroup, "104@4514L785");
                                Modifier modifierFillMaxWidth$default2 = SizeKt.fillMaxWidth$default(TestTagKt.testTag(companion, "BoxInlineDatePicker"), 0.0f, 1, null);
                                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2102191865, "CC(remember):BoxInlineDatePicker.kt#9igjgp");
                                if ((i3 & 7168) == 2048) {
                                    z8 = true;
                                } else {
                                    z8 = false;
                                }
                                objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                                if (!z8 || objRememberedValue3 == Composer.INSTANCE.getEmpty()) {
                                    objRememberedValue3 = new Function3() { // from class: com.box.android.base.compose.datepicker.BoxInlineDatePickerKt$$ExternalSyntheticLambda0
                                        @Override // kotlin.jvm.functions.Function3
                                        public final Object invoke(Object obj, Object obj2, Object obj3) {
                                            return BoxInlineDatePickerKt.BoxInlineDatePicker$lambda$3$0(f3, (MeasureScope) obj, (Measurable) obj2, (Constraints) obj3);
                                        }
                                    };
                                    composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                                }
                                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                                modifierFillMaxWidth$default = LayoutModifierKt.layout(modifierFillMaxWidth$default2, (Function3) objRememberedValue3);
                                composerStartRestartGroup.endReplaceGroup();
                            } else {
                                composerStartRestartGroup.startReplaceGroup(744212106);
                                composerStartRestartGroup.endReplaceGroup();
                                modifierFillMaxWidth$default = SizeKt.fillMaxWidth$default(TestTagKt.testTag(companion, "BoxInlineDatePicker"), 0.0f, 1, null);
                            }
                            boolean z9 = z5;
                            DatePickerKt.DatePicker(datePickerStateM3195rememberDatePickerStateEU0dCGE, modifierFillMaxWidth$default, null, datePickerColorsBoxInlineDatePickerColors, null, null, z9, null, composerStartRestartGroup, ((i3 << 3) & 3670016) | 221184, Token.TARGET);
                            composerStartRestartGroup = composerStartRestartGroup;
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                            modifier3 = companion;
                            f2 = f3;
                            z4 = z9;
                            date4 = date6;
                        }
                        scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                        if (scopeUpdateScopeEndRestartGroup != null) {
                            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.box.android.base.compose.datepicker.BoxInlineDatePickerKt$$ExternalSyntheticLambda1
                                @Override // kotlin.jvm.functions.Function2
                                public final Object invoke(Object obj, Object obj2) {
                                    return BoxInlineDatePickerKt.BoxInlineDatePicker$lambda$4(date, onDateSelected, modifier3, f2, date4, z4, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                                }
                            });
                        }
                    }
                    i3 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
                    z2 = z;
                    if ((i3 & 74899) != 74898) {
                        z3 = true;
                    } else {
                        z3 = false;
                    }
                    if (composerStartRestartGroup.shouldExecute(z3, i3 & 1)) {
                        composerStartRestartGroup.skipToGroupEnd();
                        f2 = f;
                        modifier3 = modifier2;
                        date4 = date3;
                        z4 = z2;
                    } else {
                        if (i10 != 0) {
                            companion = Modifier.INSTANCE;
                        } else {
                            companion = modifier2;
                        }
                        if (i4 != 0) {
                            f3 = 0.0f;
                        } else {
                            f3 = f;
                        }
                        if (i6 != 0) {
                            date5 = null;
                        } else {
                            date5 = date3;
                        }
                        if (i8 != 0) {
                            z5 = false;
                        } else {
                            z5 = z2;
                        }
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(2008889128, i3, -1, "com.box.android.base.compose.datepicker.BoxInlineDatePicker (BoxInlineDatePicker.kt:63)");
                        }
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2102144606, "CC(remember):BoxInlineDatePicker.kt#9igjgp");
                        zChanged = composerStartRestartGroup.changed(date5);
                        objRememberedValue = composerStartRestartGroup.rememberedValue();
                        if (!zChanged) {
                            objRememberedValue = Long.valueOf(DateExtensionsKt.toMidnightMillis$default(date5, null, 1, null));
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                        } else {
                            objRememberedValue = Long.valueOf(DateExtensionsKt.toMidnightMillis$default(date5, null, 1, null));
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                        }
                        jLongValue = ((Number) objRememberedValue).longValue();
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2102148621, "CC(remember):BoxInlineDatePicker.kt#9igjgp");
                        zChanged2 = composerStartRestartGroup.changed(date) | composerStartRestartGroup.changed(jLongValue);
                        objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                        if (!zChanged2) {
                            objRememberedValue2 = Long.valueOf(resolveInitialSelectedDateMillis(date, jLongValue));
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                        } else {
                            objRememberedValue2 = Long.valueOf(resolveInitialSelectedDateMillis(date, jLongValue));
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                        }
                        long jLongValue3 = ((Number) objRememberedValue2).longValue();
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        Date date7 = date5;
                        datePickerStateM3195rememberDatePickerStateEU0dCGE = DatePickerKt.m3195rememberDatePickerStateEU0dCGE(Long.valueOf(jLongValue3), null, null, 0, new SelectableDates() { // from class: com.box.android.base.compose.datepicker.BoxInlineDatePickerKt$BoxInlineDatePicker$datePickerState$1
                            @Override // androidx.compose.material3.SelectableDates
                            public /* bridge */ boolean isSelectableYear(int i11) {
                                return super.isSelectableYear(i11);
                            }

                            @Override // androidx.compose.material3.SelectableDates
                            public boolean isSelectableDate(long utcTimeMillis) {
                                return utcTimeMillis >= jLongValue;
                            }
                        }, composerStartRestartGroup, 0, 14);
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2102163894, "CC(remember):BoxInlineDatePicker.kt#9igjgp");
                        boolean zChanged4 = composerStartRestartGroup.changed(datePickerStateM3195rememberDatePickerStateEU0dCGE);
                        if ((i3 & 112) == 32) {
                            z6 = true;
                        } else {
                            z6 = false;
                        }
                        z7 = zChanged4 | z6;
                        boxInlineDatePickerKt$BoxInlineDatePicker$1$1RememberedValue = composerStartRestartGroup.rememberedValue();
                        if (!z7) {
                            boxInlineDatePickerKt$BoxInlineDatePicker$1$1RememberedValue = new BoxInlineDatePickerKt$BoxInlineDatePicker$1$1(datePickerStateM3195rememberDatePickerStateEU0dCGE, onDateSelected, null);
                            composerStartRestartGroup.updateRememberedValue(boxInlineDatePickerKt$BoxInlineDatePicker$1$1RememberedValue);
                        } else {
                            boxInlineDatePickerKt$BoxInlineDatePicker$1$1RememberedValue = new BoxInlineDatePickerKt$BoxInlineDatePicker$1$1(datePickerStateM3195rememberDatePickerStateEU0dCGE, onDateSelected, null);
                            composerStartRestartGroup.updateRememberedValue(boxInlineDatePickerKt$BoxInlineDatePicker$1$1RememberedValue);
                        }
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        EffectsKt.LaunchedEffect(datePickerStateM3195rememberDatePickerStateEU0dCGE, (Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object>) boxInlineDatePickerKt$BoxInlineDatePicker$1$1RememberedValue, composerStartRestartGroup, 0);
                        DatePickerColors datePickerColorsBoxInlineDatePickerColors2 = boxInlineDatePickerColors(composerStartRestartGroup, 0);
                        if (f3 > 0.0f) {
                            composerStartRestartGroup.startReplaceGroup(743215735);
                            ComposerKt.sourceInformation(composerStartRestartGroup, "104@4514L785");
                            Modifier modifierFillMaxWidth$default3 = SizeKt.fillMaxWidth$default(TestTagKt.testTag(companion, "BoxInlineDatePicker"), 0.0f, 1, null);
                            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2102191865, "CC(remember):BoxInlineDatePicker.kt#9igjgp");
                            if ((i3 & 7168) == 2048) {
                                z8 = true;
                            } else {
                                z8 = false;
                            }
                            objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                            if (!z8) {
                                objRememberedValue3 = new Function3() { // from class: com.box.android.base.compose.datepicker.BoxInlineDatePickerKt$$ExternalSyntheticLambda0
                                    @Override // kotlin.jvm.functions.Function3
                                    public final Object invoke(Object obj, Object obj2, Object obj3) {
                                        return BoxInlineDatePickerKt.BoxInlineDatePicker$lambda$3$0(f3, (MeasureScope) obj, (Measurable) obj2, (Constraints) obj3);
                                    }
                                };
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                            } else {
                                objRememberedValue3 = new Function3() { // from class: com.box.android.base.compose.datepicker.BoxInlineDatePickerKt$$ExternalSyntheticLambda0
                                    @Override // kotlin.jvm.functions.Function3
                                    public final Object invoke(Object obj, Object obj2, Object obj3) {
                                        return BoxInlineDatePickerKt.BoxInlineDatePicker$lambda$3$0(f3, (MeasureScope) obj, (Measurable) obj2, (Constraints) obj3);
                                    }
                                };
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                            }
                            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                            modifierFillMaxWidth$default = LayoutModifierKt.layout(modifierFillMaxWidth$default3, (Function3) objRememberedValue3);
                            composerStartRestartGroup.endReplaceGroup();
                        } else {
                            composerStartRestartGroup.startReplaceGroup(744212106);
                            composerStartRestartGroup.endReplaceGroup();
                            modifierFillMaxWidth$default = SizeKt.fillMaxWidth$default(TestTagKt.testTag(companion, "BoxInlineDatePicker"), 0.0f, 1, null);
                        }
                        boolean z10 = z5;
                        DatePickerKt.DatePicker(datePickerStateM3195rememberDatePickerStateEU0dCGE, modifierFillMaxWidth$default, null, datePickerColorsBoxInlineDatePickerColors2, null, null, z10, null, composerStartRestartGroup, ((i3 << 3) & 3670016) | 221184, Token.TARGET);
                        composerStartRestartGroup = composerStartRestartGroup;
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        modifier3 = companion;
                        f2 = f3;
                        z4 = z10;
                        date4 = date7;
                    }
                    scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup != null) {
                        scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.box.android.base.compose.datepicker.BoxInlineDatePickerKt$$ExternalSyntheticLambda1
                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj, Object obj2) {
                                return BoxInlineDatePickerKt.BoxInlineDatePicker$lambda$4(date, onDateSelected, modifier3, f2, date4, z4, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                            }
                        });
                    }
                }
                i3 |= 24576;
                date3 = date2;
                i8 = i2 & 32;
                if (i8 != 0) {
                    if ((196608 & i) == 0) {
                        z2 = z;
                        if (composerStartRestartGroup.changed(z2)) {
                            i9 = 131072;
                        } else {
                            i9 = 65536;
                        }
                        i3 |= i9;
                    }
                    if ((i3 & 74899) != 74898) {
                        z3 = true;
                    } else {
                        z3 = false;
                    }
                    if (composerStartRestartGroup.shouldExecute(z3, i3 & 1)) {
                        composerStartRestartGroup.skipToGroupEnd();
                        f2 = f;
                        modifier3 = modifier2;
                        date4 = date3;
                        z4 = z2;
                    } else {
                        if (i10 != 0) {
                            companion = Modifier.INSTANCE;
                        } else {
                            companion = modifier2;
                        }
                        if (i4 != 0) {
                            f3 = 0.0f;
                        } else {
                            f3 = f;
                        }
                        if (i6 != 0) {
                            date5 = null;
                        } else {
                            date5 = date3;
                        }
                        if (i8 != 0) {
                            z5 = false;
                        } else {
                            z5 = z2;
                        }
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(2008889128, i3, -1, "com.box.android.base.compose.datepicker.BoxInlineDatePicker (BoxInlineDatePicker.kt:63)");
                        }
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2102144606, "CC(remember):BoxInlineDatePicker.kt#9igjgp");
                        zChanged = composerStartRestartGroup.changed(date5);
                        objRememberedValue = composerStartRestartGroup.rememberedValue();
                        if (!zChanged) {
                            objRememberedValue = Long.valueOf(DateExtensionsKt.toMidnightMillis$default(date5, null, 1, null));
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                        } else {
                            objRememberedValue = Long.valueOf(DateExtensionsKt.toMidnightMillis$default(date5, null, 1, null));
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                        }
                        jLongValue = ((Number) objRememberedValue).longValue();
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2102148621, "CC(remember):BoxInlineDatePicker.kt#9igjgp");
                        zChanged2 = composerStartRestartGroup.changed(date) | composerStartRestartGroup.changed(jLongValue);
                        objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                        if (!zChanged2) {
                            objRememberedValue2 = Long.valueOf(resolveInitialSelectedDateMillis(date, jLongValue));
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                        } else {
                            objRememberedValue2 = Long.valueOf(resolveInitialSelectedDateMillis(date, jLongValue));
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                        }
                        long jLongValue4 = ((Number) objRememberedValue2).longValue();
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        Date date8 = date5;
                        datePickerStateM3195rememberDatePickerStateEU0dCGE = DatePickerKt.m3195rememberDatePickerStateEU0dCGE(Long.valueOf(jLongValue4), null, null, 0, new SelectableDates() { // from class: com.box.android.base.compose.datepicker.BoxInlineDatePickerKt$BoxInlineDatePicker$datePickerState$1
                            @Override // androidx.compose.material3.SelectableDates
                            public /* bridge */ boolean isSelectableYear(int i11) {
                                return super.isSelectableYear(i11);
                            }

                            @Override // androidx.compose.material3.SelectableDates
                            public boolean isSelectableDate(long utcTimeMillis) {
                                return utcTimeMillis >= jLongValue;
                            }
                        }, composerStartRestartGroup, 0, 14);
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2102163894, "CC(remember):BoxInlineDatePicker.kt#9igjgp");
                        boolean zChanged5 = composerStartRestartGroup.changed(datePickerStateM3195rememberDatePickerStateEU0dCGE);
                        if ((i3 & 112) == 32) {
                            z6 = true;
                        } else {
                            z6 = false;
                        }
                        z7 = zChanged5 | z6;
                        boxInlineDatePickerKt$BoxInlineDatePicker$1$1RememberedValue = composerStartRestartGroup.rememberedValue();
                        if (!z7) {
                            boxInlineDatePickerKt$BoxInlineDatePicker$1$1RememberedValue = new BoxInlineDatePickerKt$BoxInlineDatePicker$1$1(datePickerStateM3195rememberDatePickerStateEU0dCGE, onDateSelected, null);
                            composerStartRestartGroup.updateRememberedValue(boxInlineDatePickerKt$BoxInlineDatePicker$1$1RememberedValue);
                        } else {
                            boxInlineDatePickerKt$BoxInlineDatePicker$1$1RememberedValue = new BoxInlineDatePickerKt$BoxInlineDatePicker$1$1(datePickerStateM3195rememberDatePickerStateEU0dCGE, onDateSelected, null);
                            composerStartRestartGroup.updateRememberedValue(boxInlineDatePickerKt$BoxInlineDatePicker$1$1RememberedValue);
                        }
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        EffectsKt.LaunchedEffect(datePickerStateM3195rememberDatePickerStateEU0dCGE, (Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object>) boxInlineDatePickerKt$BoxInlineDatePicker$1$1RememberedValue, composerStartRestartGroup, 0);
                        DatePickerColors datePickerColorsBoxInlineDatePickerColors3 = boxInlineDatePickerColors(composerStartRestartGroup, 0);
                        if (f3 > 0.0f) {
                            composerStartRestartGroup.startReplaceGroup(743215735);
                            ComposerKt.sourceInformation(composerStartRestartGroup, "104@4514L785");
                            Modifier modifierFillMaxWidth$default4 = SizeKt.fillMaxWidth$default(TestTagKt.testTag(companion, "BoxInlineDatePicker"), 0.0f, 1, null);
                            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2102191865, "CC(remember):BoxInlineDatePicker.kt#9igjgp");
                            if ((i3 & 7168) == 2048) {
                                z8 = true;
                            } else {
                                z8 = false;
                            }
                            objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                            if (!z8) {
                                objRememberedValue3 = new Function3() { // from class: com.box.android.base.compose.datepicker.BoxInlineDatePickerKt$$ExternalSyntheticLambda0
                                    @Override // kotlin.jvm.functions.Function3
                                    public final Object invoke(Object obj, Object obj2, Object obj3) {
                                        return BoxInlineDatePickerKt.BoxInlineDatePicker$lambda$3$0(f3, (MeasureScope) obj, (Measurable) obj2, (Constraints) obj3);
                                    }
                                };
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                            } else {
                                objRememberedValue3 = new Function3() { // from class: com.box.android.base.compose.datepicker.BoxInlineDatePickerKt$$ExternalSyntheticLambda0
                                    @Override // kotlin.jvm.functions.Function3
                                    public final Object invoke(Object obj, Object obj2, Object obj3) {
                                        return BoxInlineDatePickerKt.BoxInlineDatePicker$lambda$3$0(f3, (MeasureScope) obj, (Measurable) obj2, (Constraints) obj3);
                                    }
                                };
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                            }
                            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                            modifierFillMaxWidth$default = LayoutModifierKt.layout(modifierFillMaxWidth$default4, (Function3) objRememberedValue3);
                            composerStartRestartGroup.endReplaceGroup();
                        } else {
                            composerStartRestartGroup.startReplaceGroup(744212106);
                            composerStartRestartGroup.endReplaceGroup();
                            modifierFillMaxWidth$default = SizeKt.fillMaxWidth$default(TestTagKt.testTag(companion, "BoxInlineDatePicker"), 0.0f, 1, null);
                        }
                        boolean z11 = z5;
                        DatePickerKt.DatePicker(datePickerStateM3195rememberDatePickerStateEU0dCGE, modifierFillMaxWidth$default, null, datePickerColorsBoxInlineDatePickerColors3, null, null, z11, null, composerStartRestartGroup, ((i3 << 3) & 3670016) | 221184, Token.TARGET);
                        composerStartRestartGroup = composerStartRestartGroup;
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        modifier3 = companion;
                        f2 = f3;
                        z4 = z11;
                        date4 = date8;
                    }
                    scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup != null) {
                        scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.box.android.base.compose.datepicker.BoxInlineDatePickerKt$$ExternalSyntheticLambda1
                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj, Object obj2) {
                                return BoxInlineDatePickerKt.BoxInlineDatePicker$lambda$4(date, onDateSelected, modifier3, f2, date4, z4, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                            }
                        });
                    }
                }
                i3 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
                z2 = z;
                if ((i3 & 74899) != 74898) {
                    z3 = true;
                } else {
                    z3 = false;
                }
                if (composerStartRestartGroup.shouldExecute(z3, i3 & 1)) {
                    composerStartRestartGroup.skipToGroupEnd();
                    f2 = f;
                    modifier3 = modifier2;
                    date4 = date3;
                    z4 = z2;
                } else {
                    if (i10 != 0) {
                        companion = Modifier.INSTANCE;
                    } else {
                        companion = modifier2;
                    }
                    if (i4 != 0) {
                        f3 = 0.0f;
                    } else {
                        f3 = f;
                    }
                    if (i6 != 0) {
                        date5 = null;
                    } else {
                        date5 = date3;
                    }
                    if (i8 != 0) {
                        z5 = false;
                    } else {
                        z5 = z2;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(2008889128, i3, -1, "com.box.android.base.compose.datepicker.BoxInlineDatePicker (BoxInlineDatePicker.kt:63)");
                    }
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2102144606, "CC(remember):BoxInlineDatePicker.kt#9igjgp");
                    zChanged = composerStartRestartGroup.changed(date5);
                    objRememberedValue = composerStartRestartGroup.rememberedValue();
                    if (!zChanged) {
                        objRememberedValue = Long.valueOf(DateExtensionsKt.toMidnightMillis$default(date5, null, 1, null));
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                    } else {
                        objRememberedValue = Long.valueOf(DateExtensionsKt.toMidnightMillis$default(date5, null, 1, null));
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                    }
                    jLongValue = ((Number) objRememberedValue).longValue();
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2102148621, "CC(remember):BoxInlineDatePicker.kt#9igjgp");
                    zChanged2 = composerStartRestartGroup.changed(date) | composerStartRestartGroup.changed(jLongValue);
                    objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                    if (!zChanged2) {
                        objRememberedValue2 = Long.valueOf(resolveInitialSelectedDateMillis(date, jLongValue));
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                    } else {
                        objRememberedValue2 = Long.valueOf(resolveInitialSelectedDateMillis(date, jLongValue));
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                    }
                    long jLongValue5 = ((Number) objRememberedValue2).longValue();
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    Date date9 = date5;
                    datePickerStateM3195rememberDatePickerStateEU0dCGE = DatePickerKt.m3195rememberDatePickerStateEU0dCGE(Long.valueOf(jLongValue5), null, null, 0, new SelectableDates() { // from class: com.box.android.base.compose.datepicker.BoxInlineDatePickerKt$BoxInlineDatePicker$datePickerState$1
                        @Override // androidx.compose.material3.SelectableDates
                        public /* bridge */ boolean isSelectableYear(int i11) {
                            return super.isSelectableYear(i11);
                        }

                        @Override // androidx.compose.material3.SelectableDates
                        public boolean isSelectableDate(long utcTimeMillis) {
                            return utcTimeMillis >= jLongValue;
                        }
                    }, composerStartRestartGroup, 0, 14);
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2102163894, "CC(remember):BoxInlineDatePicker.kt#9igjgp");
                    boolean zChanged6 = composerStartRestartGroup.changed(datePickerStateM3195rememberDatePickerStateEU0dCGE);
                    if ((i3 & 112) == 32) {
                        z6 = true;
                    } else {
                        z6 = false;
                    }
                    z7 = zChanged6 | z6;
                    boxInlineDatePickerKt$BoxInlineDatePicker$1$1RememberedValue = composerStartRestartGroup.rememberedValue();
                    if (!z7) {
                        boxInlineDatePickerKt$BoxInlineDatePicker$1$1RememberedValue = new BoxInlineDatePickerKt$BoxInlineDatePicker$1$1(datePickerStateM3195rememberDatePickerStateEU0dCGE, onDateSelected, null);
                        composerStartRestartGroup.updateRememberedValue(boxInlineDatePickerKt$BoxInlineDatePicker$1$1RememberedValue);
                    } else {
                        boxInlineDatePickerKt$BoxInlineDatePicker$1$1RememberedValue = new BoxInlineDatePickerKt$BoxInlineDatePicker$1$1(datePickerStateM3195rememberDatePickerStateEU0dCGE, onDateSelected, null);
                        composerStartRestartGroup.updateRememberedValue(boxInlineDatePickerKt$BoxInlineDatePicker$1$1RememberedValue);
                    }
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    EffectsKt.LaunchedEffect(datePickerStateM3195rememberDatePickerStateEU0dCGE, (Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object>) boxInlineDatePickerKt$BoxInlineDatePicker$1$1RememberedValue, composerStartRestartGroup, 0);
                    DatePickerColors datePickerColorsBoxInlineDatePickerColors4 = boxInlineDatePickerColors(composerStartRestartGroup, 0);
                    if (f3 > 0.0f) {
                        composerStartRestartGroup.startReplaceGroup(743215735);
                        ComposerKt.sourceInformation(composerStartRestartGroup, "104@4514L785");
                        Modifier modifierFillMaxWidth$default5 = SizeKt.fillMaxWidth$default(TestTagKt.testTag(companion, "BoxInlineDatePicker"), 0.0f, 1, null);
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2102191865, "CC(remember):BoxInlineDatePicker.kt#9igjgp");
                        if ((i3 & 7168) == 2048) {
                            z8 = true;
                        } else {
                            z8 = false;
                        }
                        objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                        if (!z8) {
                            objRememberedValue3 = new Function3() { // from class: com.box.android.base.compose.datepicker.BoxInlineDatePickerKt$$ExternalSyntheticLambda0
                                @Override // kotlin.jvm.functions.Function3
                                public final Object invoke(Object obj, Object obj2, Object obj3) {
                                    return BoxInlineDatePickerKt.BoxInlineDatePicker$lambda$3$0(f3, (MeasureScope) obj, (Measurable) obj2, (Constraints) obj3);
                                }
                            };
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                        } else {
                            objRememberedValue3 = new Function3() { // from class: com.box.android.base.compose.datepicker.BoxInlineDatePickerKt$$ExternalSyntheticLambda0
                                @Override // kotlin.jvm.functions.Function3
                                public final Object invoke(Object obj, Object obj2, Object obj3) {
                                    return BoxInlineDatePickerKt.BoxInlineDatePicker$lambda$3$0(f3, (MeasureScope) obj, (Measurable) obj2, (Constraints) obj3);
                                }
                            };
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                        }
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        modifierFillMaxWidth$default = LayoutModifierKt.layout(modifierFillMaxWidth$default5, (Function3) objRememberedValue3);
                        composerStartRestartGroup.endReplaceGroup();
                    } else {
                        composerStartRestartGroup.startReplaceGroup(744212106);
                        composerStartRestartGroup.endReplaceGroup();
                        modifierFillMaxWidth$default = SizeKt.fillMaxWidth$default(TestTagKt.testTag(companion, "BoxInlineDatePicker"), 0.0f, 1, null);
                    }
                    boolean z12 = z5;
                    DatePickerKt.DatePicker(datePickerStateM3195rememberDatePickerStateEU0dCGE, modifierFillMaxWidth$default, null, datePickerColorsBoxInlineDatePickerColors4, null, null, z12, null, composerStartRestartGroup, ((i3 << 3) & 3670016) | 221184, Token.TARGET);
                    composerStartRestartGroup = composerStartRestartGroup;
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    modifier3 = companion;
                    f2 = f3;
                    z4 = z12;
                    date4 = date9;
                }
                scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.box.android.base.compose.datepicker.BoxInlineDatePickerKt$$ExternalSyntheticLambda1
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return BoxInlineDatePickerKt.BoxInlineDatePicker$lambda$4(date, onDateSelected, modifier3, f2, date4, z4, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    });
                }
            }
            i3 |= 3072;
            i6 = i2 & 16;
            if (i6 != 0) {
                if ((i & 24576) == 0) {
                    date3 = date2;
                    if (composerStartRestartGroup.changedInstance(date3)) {
                        i7 = 16384;
                    } else {
                        i7 = 8192;
                    }
                    i3 |= i7;
                }
                i8 = i2 & 32;
                if (i8 != 0) {
                    if ((196608 & i) == 0) {
                        z2 = z;
                        if (composerStartRestartGroup.changed(z2)) {
                            i9 = 131072;
                        } else {
                            i9 = 65536;
                        }
                        i3 |= i9;
                    }
                    if ((i3 & 74899) != 74898) {
                        z3 = true;
                    } else {
                        z3 = false;
                    }
                    if (composerStartRestartGroup.shouldExecute(z3, i3 & 1)) {
                        composerStartRestartGroup.skipToGroupEnd();
                        f2 = f;
                        modifier3 = modifier2;
                        date4 = date3;
                        z4 = z2;
                    } else {
                        if (i10 != 0) {
                            companion = Modifier.INSTANCE;
                        } else {
                            companion = modifier2;
                        }
                        if (i4 != 0) {
                            f3 = 0.0f;
                        } else {
                            f3 = f;
                        }
                        if (i6 != 0) {
                            date5 = null;
                        } else {
                            date5 = date3;
                        }
                        if (i8 != 0) {
                            z5 = false;
                        } else {
                            z5 = z2;
                        }
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(2008889128, i3, -1, "com.box.android.base.compose.datepicker.BoxInlineDatePicker (BoxInlineDatePicker.kt:63)");
                        }
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2102144606, "CC(remember):BoxInlineDatePicker.kt#9igjgp");
                        zChanged = composerStartRestartGroup.changed(date5);
                        objRememberedValue = composerStartRestartGroup.rememberedValue();
                        if (!zChanged) {
                            objRememberedValue = Long.valueOf(DateExtensionsKt.toMidnightMillis$default(date5, null, 1, null));
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                        } else {
                            objRememberedValue = Long.valueOf(DateExtensionsKt.toMidnightMillis$default(date5, null, 1, null));
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                        }
                        jLongValue = ((Number) objRememberedValue).longValue();
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2102148621, "CC(remember):BoxInlineDatePicker.kt#9igjgp");
                        zChanged2 = composerStartRestartGroup.changed(date) | composerStartRestartGroup.changed(jLongValue);
                        objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                        if (!zChanged2) {
                            objRememberedValue2 = Long.valueOf(resolveInitialSelectedDateMillis(date, jLongValue));
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                        } else {
                            objRememberedValue2 = Long.valueOf(resolveInitialSelectedDateMillis(date, jLongValue));
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                        }
                        long jLongValue6 = ((Number) objRememberedValue2).longValue();
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        Date date10 = date5;
                        datePickerStateM3195rememberDatePickerStateEU0dCGE = DatePickerKt.m3195rememberDatePickerStateEU0dCGE(Long.valueOf(jLongValue6), null, null, 0, new SelectableDates() { // from class: com.box.android.base.compose.datepicker.BoxInlineDatePickerKt$BoxInlineDatePicker$datePickerState$1
                            @Override // androidx.compose.material3.SelectableDates
                            public /* bridge */ boolean isSelectableYear(int i11) {
                                return super.isSelectableYear(i11);
                            }

                            @Override // androidx.compose.material3.SelectableDates
                            public boolean isSelectableDate(long utcTimeMillis) {
                                return utcTimeMillis >= jLongValue;
                            }
                        }, composerStartRestartGroup, 0, 14);
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2102163894, "CC(remember):BoxInlineDatePicker.kt#9igjgp");
                        boolean zChanged7 = composerStartRestartGroup.changed(datePickerStateM3195rememberDatePickerStateEU0dCGE);
                        if ((i3 & 112) == 32) {
                            z6 = true;
                        } else {
                            z6 = false;
                        }
                        z7 = zChanged7 | z6;
                        boxInlineDatePickerKt$BoxInlineDatePicker$1$1RememberedValue = composerStartRestartGroup.rememberedValue();
                        if (!z7) {
                            boxInlineDatePickerKt$BoxInlineDatePicker$1$1RememberedValue = new BoxInlineDatePickerKt$BoxInlineDatePicker$1$1(datePickerStateM3195rememberDatePickerStateEU0dCGE, onDateSelected, null);
                            composerStartRestartGroup.updateRememberedValue(boxInlineDatePickerKt$BoxInlineDatePicker$1$1RememberedValue);
                        } else {
                            boxInlineDatePickerKt$BoxInlineDatePicker$1$1RememberedValue = new BoxInlineDatePickerKt$BoxInlineDatePicker$1$1(datePickerStateM3195rememberDatePickerStateEU0dCGE, onDateSelected, null);
                            composerStartRestartGroup.updateRememberedValue(boxInlineDatePickerKt$BoxInlineDatePicker$1$1RememberedValue);
                        }
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        EffectsKt.LaunchedEffect(datePickerStateM3195rememberDatePickerStateEU0dCGE, (Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object>) boxInlineDatePickerKt$BoxInlineDatePicker$1$1RememberedValue, composerStartRestartGroup, 0);
                        DatePickerColors datePickerColorsBoxInlineDatePickerColors5 = boxInlineDatePickerColors(composerStartRestartGroup, 0);
                        if (f3 > 0.0f) {
                            composerStartRestartGroup.startReplaceGroup(743215735);
                            ComposerKt.sourceInformation(composerStartRestartGroup, "104@4514L785");
                            Modifier modifierFillMaxWidth$default6 = SizeKt.fillMaxWidth$default(TestTagKt.testTag(companion, "BoxInlineDatePicker"), 0.0f, 1, null);
                            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2102191865, "CC(remember):BoxInlineDatePicker.kt#9igjgp");
                            if ((i3 & 7168) == 2048) {
                                z8 = true;
                            } else {
                                z8 = false;
                            }
                            objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                            if (!z8) {
                                objRememberedValue3 = new Function3() { // from class: com.box.android.base.compose.datepicker.BoxInlineDatePickerKt$$ExternalSyntheticLambda0
                                    @Override // kotlin.jvm.functions.Function3
                                    public final Object invoke(Object obj, Object obj2, Object obj3) {
                                        return BoxInlineDatePickerKt.BoxInlineDatePicker$lambda$3$0(f3, (MeasureScope) obj, (Measurable) obj2, (Constraints) obj3);
                                    }
                                };
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                            } else {
                                objRememberedValue3 = new Function3() { // from class: com.box.android.base.compose.datepicker.BoxInlineDatePickerKt$$ExternalSyntheticLambda0
                                    @Override // kotlin.jvm.functions.Function3
                                    public final Object invoke(Object obj, Object obj2, Object obj3) {
                                        return BoxInlineDatePickerKt.BoxInlineDatePicker$lambda$3$0(f3, (MeasureScope) obj, (Measurable) obj2, (Constraints) obj3);
                                    }
                                };
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                            }
                            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                            modifierFillMaxWidth$default = LayoutModifierKt.layout(modifierFillMaxWidth$default6, (Function3) objRememberedValue3);
                            composerStartRestartGroup.endReplaceGroup();
                        } else {
                            composerStartRestartGroup.startReplaceGroup(744212106);
                            composerStartRestartGroup.endReplaceGroup();
                            modifierFillMaxWidth$default = SizeKt.fillMaxWidth$default(TestTagKt.testTag(companion, "BoxInlineDatePicker"), 0.0f, 1, null);
                        }
                        boolean z13 = z5;
                        DatePickerKt.DatePicker(datePickerStateM3195rememberDatePickerStateEU0dCGE, modifierFillMaxWidth$default, null, datePickerColorsBoxInlineDatePickerColors5, null, null, z13, null, composerStartRestartGroup, ((i3 << 3) & 3670016) | 221184, Token.TARGET);
                        composerStartRestartGroup = composerStartRestartGroup;
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        modifier3 = companion;
                        f2 = f3;
                        z4 = z13;
                        date4 = date10;
                    }
                    scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup != null) {
                        scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.box.android.base.compose.datepicker.BoxInlineDatePickerKt$$ExternalSyntheticLambda1
                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj, Object obj2) {
                                return BoxInlineDatePickerKt.BoxInlineDatePicker$lambda$4(date, onDateSelected, modifier3, f2, date4, z4, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                            }
                        });
                    }
                }
                i3 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
                z2 = z;
                if ((i3 & 74899) != 74898) {
                    z3 = true;
                } else {
                    z3 = false;
                }
                if (composerStartRestartGroup.shouldExecute(z3, i3 & 1)) {
                    composerStartRestartGroup.skipToGroupEnd();
                    f2 = f;
                    modifier3 = modifier2;
                    date4 = date3;
                    z4 = z2;
                } else {
                    if (i10 != 0) {
                        companion = Modifier.INSTANCE;
                    } else {
                        companion = modifier2;
                    }
                    if (i4 != 0) {
                        f3 = 0.0f;
                    } else {
                        f3 = f;
                    }
                    if (i6 != 0) {
                        date5 = null;
                    } else {
                        date5 = date3;
                    }
                    if (i8 != 0) {
                        z5 = false;
                    } else {
                        z5 = z2;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(2008889128, i3, -1, "com.box.android.base.compose.datepicker.BoxInlineDatePicker (BoxInlineDatePicker.kt:63)");
                    }
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2102144606, "CC(remember):BoxInlineDatePicker.kt#9igjgp");
                    zChanged = composerStartRestartGroup.changed(date5);
                    objRememberedValue = composerStartRestartGroup.rememberedValue();
                    if (!zChanged) {
                        objRememberedValue = Long.valueOf(DateExtensionsKt.toMidnightMillis$default(date5, null, 1, null));
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                    } else {
                        objRememberedValue = Long.valueOf(DateExtensionsKt.toMidnightMillis$default(date5, null, 1, null));
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                    }
                    jLongValue = ((Number) objRememberedValue).longValue();
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2102148621, "CC(remember):BoxInlineDatePicker.kt#9igjgp");
                    zChanged2 = composerStartRestartGroup.changed(date) | composerStartRestartGroup.changed(jLongValue);
                    objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                    if (!zChanged2) {
                        objRememberedValue2 = Long.valueOf(resolveInitialSelectedDateMillis(date, jLongValue));
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                    } else {
                        objRememberedValue2 = Long.valueOf(resolveInitialSelectedDateMillis(date, jLongValue));
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                    }
                    long jLongValue7 = ((Number) objRememberedValue2).longValue();
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    Date date11 = date5;
                    datePickerStateM3195rememberDatePickerStateEU0dCGE = DatePickerKt.m3195rememberDatePickerStateEU0dCGE(Long.valueOf(jLongValue7), null, null, 0, new SelectableDates() { // from class: com.box.android.base.compose.datepicker.BoxInlineDatePickerKt$BoxInlineDatePicker$datePickerState$1
                        @Override // androidx.compose.material3.SelectableDates
                        public /* bridge */ boolean isSelectableYear(int i11) {
                            return super.isSelectableYear(i11);
                        }

                        @Override // androidx.compose.material3.SelectableDates
                        public boolean isSelectableDate(long utcTimeMillis) {
                            return utcTimeMillis >= jLongValue;
                        }
                    }, composerStartRestartGroup, 0, 14);
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2102163894, "CC(remember):BoxInlineDatePicker.kt#9igjgp");
                    boolean zChanged8 = composerStartRestartGroup.changed(datePickerStateM3195rememberDatePickerStateEU0dCGE);
                    if ((i3 & 112) == 32) {
                        z6 = true;
                    } else {
                        z6 = false;
                    }
                    z7 = zChanged8 | z6;
                    boxInlineDatePickerKt$BoxInlineDatePicker$1$1RememberedValue = composerStartRestartGroup.rememberedValue();
                    if (!z7) {
                        boxInlineDatePickerKt$BoxInlineDatePicker$1$1RememberedValue = new BoxInlineDatePickerKt$BoxInlineDatePicker$1$1(datePickerStateM3195rememberDatePickerStateEU0dCGE, onDateSelected, null);
                        composerStartRestartGroup.updateRememberedValue(boxInlineDatePickerKt$BoxInlineDatePicker$1$1RememberedValue);
                    } else {
                        boxInlineDatePickerKt$BoxInlineDatePicker$1$1RememberedValue = new BoxInlineDatePickerKt$BoxInlineDatePicker$1$1(datePickerStateM3195rememberDatePickerStateEU0dCGE, onDateSelected, null);
                        composerStartRestartGroup.updateRememberedValue(boxInlineDatePickerKt$BoxInlineDatePicker$1$1RememberedValue);
                    }
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    EffectsKt.LaunchedEffect(datePickerStateM3195rememberDatePickerStateEU0dCGE, (Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object>) boxInlineDatePickerKt$BoxInlineDatePicker$1$1RememberedValue, composerStartRestartGroup, 0);
                    DatePickerColors datePickerColorsBoxInlineDatePickerColors6 = boxInlineDatePickerColors(composerStartRestartGroup, 0);
                    if (f3 > 0.0f) {
                        composerStartRestartGroup.startReplaceGroup(743215735);
                        ComposerKt.sourceInformation(composerStartRestartGroup, "104@4514L785");
                        Modifier modifierFillMaxWidth$default7 = SizeKt.fillMaxWidth$default(TestTagKt.testTag(companion, "BoxInlineDatePicker"), 0.0f, 1, null);
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2102191865, "CC(remember):BoxInlineDatePicker.kt#9igjgp");
                        if ((i3 & 7168) == 2048) {
                            z8 = true;
                        } else {
                            z8 = false;
                        }
                        objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                        if (!z8) {
                            objRememberedValue3 = new Function3() { // from class: com.box.android.base.compose.datepicker.BoxInlineDatePickerKt$$ExternalSyntheticLambda0
                                @Override // kotlin.jvm.functions.Function3
                                public final Object invoke(Object obj, Object obj2, Object obj3) {
                                    return BoxInlineDatePickerKt.BoxInlineDatePicker$lambda$3$0(f3, (MeasureScope) obj, (Measurable) obj2, (Constraints) obj3);
                                }
                            };
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                        } else {
                            objRememberedValue3 = new Function3() { // from class: com.box.android.base.compose.datepicker.BoxInlineDatePickerKt$$ExternalSyntheticLambda0
                                @Override // kotlin.jvm.functions.Function3
                                public final Object invoke(Object obj, Object obj2, Object obj3) {
                                    return BoxInlineDatePickerKt.BoxInlineDatePicker$lambda$3$0(f3, (MeasureScope) obj, (Measurable) obj2, (Constraints) obj3);
                                }
                            };
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                        }
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        modifierFillMaxWidth$default = LayoutModifierKt.layout(modifierFillMaxWidth$default7, (Function3) objRememberedValue3);
                        composerStartRestartGroup.endReplaceGroup();
                    } else {
                        composerStartRestartGroup.startReplaceGroup(744212106);
                        composerStartRestartGroup.endReplaceGroup();
                        modifierFillMaxWidth$default = SizeKt.fillMaxWidth$default(TestTagKt.testTag(companion, "BoxInlineDatePicker"), 0.0f, 1, null);
                    }
                    boolean z14 = z5;
                    DatePickerKt.DatePicker(datePickerStateM3195rememberDatePickerStateEU0dCGE, modifierFillMaxWidth$default, null, datePickerColorsBoxInlineDatePickerColors6, null, null, z14, null, composerStartRestartGroup, ((i3 << 3) & 3670016) | 221184, Token.TARGET);
                    composerStartRestartGroup = composerStartRestartGroup;
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    modifier3 = companion;
                    f2 = f3;
                    z4 = z14;
                    date4 = date11;
                }
                scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.box.android.base.compose.datepicker.BoxInlineDatePickerKt$$ExternalSyntheticLambda1
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return BoxInlineDatePickerKt.BoxInlineDatePicker$lambda$4(date, onDateSelected, modifier3, f2, date4, z4, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    });
                }
            }
            i3 |= 24576;
            date3 = date2;
            i8 = i2 & 32;
            if (i8 != 0) {
                if ((196608 & i) == 0) {
                    z2 = z;
                    if (composerStartRestartGroup.changed(z2)) {
                        i9 = 131072;
                    } else {
                        i9 = 65536;
                    }
                    i3 |= i9;
                }
                if ((i3 & 74899) != 74898) {
                    z3 = true;
                } else {
                    z3 = false;
                }
                if (composerStartRestartGroup.shouldExecute(z3, i3 & 1)) {
                    composerStartRestartGroup.skipToGroupEnd();
                    f2 = f;
                    modifier3 = modifier2;
                    date4 = date3;
                    z4 = z2;
                } else {
                    if (i10 != 0) {
                        companion = Modifier.INSTANCE;
                    } else {
                        companion = modifier2;
                    }
                    if (i4 != 0) {
                        f3 = 0.0f;
                    } else {
                        f3 = f;
                    }
                    if (i6 != 0) {
                        date5 = null;
                    } else {
                        date5 = date3;
                    }
                    if (i8 != 0) {
                        z5 = false;
                    } else {
                        z5 = z2;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(2008889128, i3, -1, "com.box.android.base.compose.datepicker.BoxInlineDatePicker (BoxInlineDatePicker.kt:63)");
                    }
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2102144606, "CC(remember):BoxInlineDatePicker.kt#9igjgp");
                    zChanged = composerStartRestartGroup.changed(date5);
                    objRememberedValue = composerStartRestartGroup.rememberedValue();
                    if (!zChanged) {
                        objRememberedValue = Long.valueOf(DateExtensionsKt.toMidnightMillis$default(date5, null, 1, null));
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                    } else {
                        objRememberedValue = Long.valueOf(DateExtensionsKt.toMidnightMillis$default(date5, null, 1, null));
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                    }
                    jLongValue = ((Number) objRememberedValue).longValue();
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2102148621, "CC(remember):BoxInlineDatePicker.kt#9igjgp");
                    zChanged2 = composerStartRestartGroup.changed(date) | composerStartRestartGroup.changed(jLongValue);
                    objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                    if (!zChanged2) {
                        objRememberedValue2 = Long.valueOf(resolveInitialSelectedDateMillis(date, jLongValue));
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                    } else {
                        objRememberedValue2 = Long.valueOf(resolveInitialSelectedDateMillis(date, jLongValue));
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                    }
                    long jLongValue8 = ((Number) objRememberedValue2).longValue();
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    Date date12 = date5;
                    datePickerStateM3195rememberDatePickerStateEU0dCGE = DatePickerKt.m3195rememberDatePickerStateEU0dCGE(Long.valueOf(jLongValue8), null, null, 0, new SelectableDates() { // from class: com.box.android.base.compose.datepicker.BoxInlineDatePickerKt$BoxInlineDatePicker$datePickerState$1
                        @Override // androidx.compose.material3.SelectableDates
                        public /* bridge */ boolean isSelectableYear(int i11) {
                            return super.isSelectableYear(i11);
                        }

                        @Override // androidx.compose.material3.SelectableDates
                        public boolean isSelectableDate(long utcTimeMillis) {
                            return utcTimeMillis >= jLongValue;
                        }
                    }, composerStartRestartGroup, 0, 14);
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2102163894, "CC(remember):BoxInlineDatePicker.kt#9igjgp");
                    boolean zChanged9 = composerStartRestartGroup.changed(datePickerStateM3195rememberDatePickerStateEU0dCGE);
                    if ((i3 & 112) == 32) {
                        z6 = true;
                    } else {
                        z6 = false;
                    }
                    z7 = zChanged9 | z6;
                    boxInlineDatePickerKt$BoxInlineDatePicker$1$1RememberedValue = composerStartRestartGroup.rememberedValue();
                    if (!z7) {
                        boxInlineDatePickerKt$BoxInlineDatePicker$1$1RememberedValue = new BoxInlineDatePickerKt$BoxInlineDatePicker$1$1(datePickerStateM3195rememberDatePickerStateEU0dCGE, onDateSelected, null);
                        composerStartRestartGroup.updateRememberedValue(boxInlineDatePickerKt$BoxInlineDatePicker$1$1RememberedValue);
                    } else {
                        boxInlineDatePickerKt$BoxInlineDatePicker$1$1RememberedValue = new BoxInlineDatePickerKt$BoxInlineDatePicker$1$1(datePickerStateM3195rememberDatePickerStateEU0dCGE, onDateSelected, null);
                        composerStartRestartGroup.updateRememberedValue(boxInlineDatePickerKt$BoxInlineDatePicker$1$1RememberedValue);
                    }
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    EffectsKt.LaunchedEffect(datePickerStateM3195rememberDatePickerStateEU0dCGE, (Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object>) boxInlineDatePickerKt$BoxInlineDatePicker$1$1RememberedValue, composerStartRestartGroup, 0);
                    DatePickerColors datePickerColorsBoxInlineDatePickerColors7 = boxInlineDatePickerColors(composerStartRestartGroup, 0);
                    if (f3 > 0.0f) {
                        composerStartRestartGroup.startReplaceGroup(743215735);
                        ComposerKt.sourceInformation(composerStartRestartGroup, "104@4514L785");
                        Modifier modifierFillMaxWidth$default8 = SizeKt.fillMaxWidth$default(TestTagKt.testTag(companion, "BoxInlineDatePicker"), 0.0f, 1, null);
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2102191865, "CC(remember):BoxInlineDatePicker.kt#9igjgp");
                        if ((i3 & 7168) == 2048) {
                            z8 = true;
                        } else {
                            z8 = false;
                        }
                        objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                        if (!z8) {
                            objRememberedValue3 = new Function3() { // from class: com.box.android.base.compose.datepicker.BoxInlineDatePickerKt$$ExternalSyntheticLambda0
                                @Override // kotlin.jvm.functions.Function3
                                public final Object invoke(Object obj, Object obj2, Object obj3) {
                                    return BoxInlineDatePickerKt.BoxInlineDatePicker$lambda$3$0(f3, (MeasureScope) obj, (Measurable) obj2, (Constraints) obj3);
                                }
                            };
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                        } else {
                            objRememberedValue3 = new Function3() { // from class: com.box.android.base.compose.datepicker.BoxInlineDatePickerKt$$ExternalSyntheticLambda0
                                @Override // kotlin.jvm.functions.Function3
                                public final Object invoke(Object obj, Object obj2, Object obj3) {
                                    return BoxInlineDatePickerKt.BoxInlineDatePicker$lambda$3$0(f3, (MeasureScope) obj, (Measurable) obj2, (Constraints) obj3);
                                }
                            };
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                        }
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        modifierFillMaxWidth$default = LayoutModifierKt.layout(modifierFillMaxWidth$default8, (Function3) objRememberedValue3);
                        composerStartRestartGroup.endReplaceGroup();
                    } else {
                        composerStartRestartGroup.startReplaceGroup(744212106);
                        composerStartRestartGroup.endReplaceGroup();
                        modifierFillMaxWidth$default = SizeKt.fillMaxWidth$default(TestTagKt.testTag(companion, "BoxInlineDatePicker"), 0.0f, 1, null);
                    }
                    boolean z15 = z5;
                    DatePickerKt.DatePicker(datePickerStateM3195rememberDatePickerStateEU0dCGE, modifierFillMaxWidth$default, null, datePickerColorsBoxInlineDatePickerColors7, null, null, z15, null, composerStartRestartGroup, ((i3 << 3) & 3670016) | 221184, Token.TARGET);
                    composerStartRestartGroup = composerStartRestartGroup;
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    modifier3 = companion;
                    f2 = f3;
                    z4 = z15;
                    date4 = date12;
                }
                scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.box.android.base.compose.datepicker.BoxInlineDatePickerKt$$ExternalSyntheticLambda1
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return BoxInlineDatePickerKt.BoxInlineDatePicker$lambda$4(date, onDateSelected, modifier3, f2, date4, z4, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    });
                }
            }
            i3 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
            z2 = z;
            if ((i3 & 74899) != 74898) {
                z3 = true;
            } else {
                z3 = false;
            }
            if (composerStartRestartGroup.shouldExecute(z3, i3 & 1)) {
                composerStartRestartGroup.skipToGroupEnd();
                f2 = f;
                modifier3 = modifier2;
                date4 = date3;
                z4 = z2;
            } else {
                if (i10 != 0) {
                    companion = Modifier.INSTANCE;
                } else {
                    companion = modifier2;
                }
                if (i4 != 0) {
                    f3 = 0.0f;
                } else {
                    f3 = f;
                }
                if (i6 != 0) {
                    date5 = null;
                } else {
                    date5 = date3;
                }
                if (i8 != 0) {
                    z5 = false;
                } else {
                    z5 = z2;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(2008889128, i3, -1, "com.box.android.base.compose.datepicker.BoxInlineDatePicker (BoxInlineDatePicker.kt:63)");
                }
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2102144606, "CC(remember):BoxInlineDatePicker.kt#9igjgp");
                zChanged = composerStartRestartGroup.changed(date5);
                objRememberedValue = composerStartRestartGroup.rememberedValue();
                if (!zChanged) {
                    objRememberedValue = Long.valueOf(DateExtensionsKt.toMidnightMillis$default(date5, null, 1, null));
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                } else {
                    objRememberedValue = Long.valueOf(DateExtensionsKt.toMidnightMillis$default(date5, null, 1, null));
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                }
                jLongValue = ((Number) objRememberedValue).longValue();
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2102148621, "CC(remember):BoxInlineDatePicker.kt#9igjgp");
                zChanged2 = composerStartRestartGroup.changed(date) | composerStartRestartGroup.changed(jLongValue);
                objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                if (!zChanged2) {
                    objRememberedValue2 = Long.valueOf(resolveInitialSelectedDateMillis(date, jLongValue));
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                } else {
                    objRememberedValue2 = Long.valueOf(resolveInitialSelectedDateMillis(date, jLongValue));
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                }
                long jLongValue9 = ((Number) objRememberedValue2).longValue();
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                Date date13 = date5;
                datePickerStateM3195rememberDatePickerStateEU0dCGE = DatePickerKt.m3195rememberDatePickerStateEU0dCGE(Long.valueOf(jLongValue9), null, null, 0, new SelectableDates() { // from class: com.box.android.base.compose.datepicker.BoxInlineDatePickerKt$BoxInlineDatePicker$datePickerState$1
                    @Override // androidx.compose.material3.SelectableDates
                    public /* bridge */ boolean isSelectableYear(int i11) {
                        return super.isSelectableYear(i11);
                    }

                    @Override // androidx.compose.material3.SelectableDates
                    public boolean isSelectableDate(long utcTimeMillis) {
                        return utcTimeMillis >= jLongValue;
                    }
                }, composerStartRestartGroup, 0, 14);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2102163894, "CC(remember):BoxInlineDatePicker.kt#9igjgp");
                boolean zChanged10 = composerStartRestartGroup.changed(datePickerStateM3195rememberDatePickerStateEU0dCGE);
                if ((i3 & 112) == 32) {
                    z6 = true;
                } else {
                    z6 = false;
                }
                z7 = zChanged10 | z6;
                boxInlineDatePickerKt$BoxInlineDatePicker$1$1RememberedValue = composerStartRestartGroup.rememberedValue();
                if (!z7) {
                    boxInlineDatePickerKt$BoxInlineDatePicker$1$1RememberedValue = new BoxInlineDatePickerKt$BoxInlineDatePicker$1$1(datePickerStateM3195rememberDatePickerStateEU0dCGE, onDateSelected, null);
                    composerStartRestartGroup.updateRememberedValue(boxInlineDatePickerKt$BoxInlineDatePicker$1$1RememberedValue);
                } else {
                    boxInlineDatePickerKt$BoxInlineDatePicker$1$1RememberedValue = new BoxInlineDatePickerKt$BoxInlineDatePicker$1$1(datePickerStateM3195rememberDatePickerStateEU0dCGE, onDateSelected, null);
                    composerStartRestartGroup.updateRememberedValue(boxInlineDatePickerKt$BoxInlineDatePicker$1$1RememberedValue);
                }
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                EffectsKt.LaunchedEffect(datePickerStateM3195rememberDatePickerStateEU0dCGE, (Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object>) boxInlineDatePickerKt$BoxInlineDatePicker$1$1RememberedValue, composerStartRestartGroup, 0);
                DatePickerColors datePickerColorsBoxInlineDatePickerColors8 = boxInlineDatePickerColors(composerStartRestartGroup, 0);
                if (f3 > 0.0f) {
                    composerStartRestartGroup.startReplaceGroup(743215735);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "104@4514L785");
                    Modifier modifierFillMaxWidth$default9 = SizeKt.fillMaxWidth$default(TestTagKt.testTag(companion, "BoxInlineDatePicker"), 0.0f, 1, null);
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2102191865, "CC(remember):BoxInlineDatePicker.kt#9igjgp");
                    if ((i3 & 7168) == 2048) {
                        z8 = true;
                    } else {
                        z8 = false;
                    }
                    objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                    if (!z8) {
                        objRememberedValue3 = new Function3() { // from class: com.box.android.base.compose.datepicker.BoxInlineDatePickerKt$$ExternalSyntheticLambda0
                            @Override // kotlin.jvm.functions.Function3
                            public final Object invoke(Object obj, Object obj2, Object obj3) {
                                return BoxInlineDatePickerKt.BoxInlineDatePicker$lambda$3$0(f3, (MeasureScope) obj, (Measurable) obj2, (Constraints) obj3);
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                    } else {
                        objRememberedValue3 = new Function3() { // from class: com.box.android.base.compose.datepicker.BoxInlineDatePickerKt$$ExternalSyntheticLambda0
                            @Override // kotlin.jvm.functions.Function3
                            public final Object invoke(Object obj, Object obj2, Object obj3) {
                                return BoxInlineDatePickerKt.BoxInlineDatePicker$lambda$3$0(f3, (MeasureScope) obj, (Measurable) obj2, (Constraints) obj3);
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                    }
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    modifierFillMaxWidth$default = LayoutModifierKt.layout(modifierFillMaxWidth$default9, (Function3) objRememberedValue3);
                    composerStartRestartGroup.endReplaceGroup();
                } else {
                    composerStartRestartGroup.startReplaceGroup(744212106);
                    composerStartRestartGroup.endReplaceGroup();
                    modifierFillMaxWidth$default = SizeKt.fillMaxWidth$default(TestTagKt.testTag(companion, "BoxInlineDatePicker"), 0.0f, 1, null);
                }
                boolean z16 = z5;
                DatePickerKt.DatePicker(datePickerStateM3195rememberDatePickerStateEU0dCGE, modifierFillMaxWidth$default, null, datePickerColorsBoxInlineDatePickerColors8, null, null, z16, null, composerStartRestartGroup, ((i3 << 3) & 3670016) | 221184, Token.TARGET);
                composerStartRestartGroup = composerStartRestartGroup;
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                modifier3 = companion;
                f2 = f3;
                z4 = z16;
                date4 = date13;
            }
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.box.android.base.compose.datepicker.BoxInlineDatePickerKt$$ExternalSyntheticLambda1
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return BoxInlineDatePickerKt.BoxInlineDatePicker$lambda$4(date, onDateSelected, modifier3, f2, date4, z4, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                    }
                });
            }
        }
        i3 |= 384;
        modifier2 = modifier;
        i4 = i2 & 8;
        if (i4 != 0) {
            if ((i & 3072) == 0) {
                if (composerStartRestartGroup.changed(f)) {
                    i5 = 2048;
                } else {
                    i5 = 1024;
                }
                i3 |= i5;
            }
            i6 = i2 & 16;
            if (i6 != 0) {
                if ((i & 24576) == 0) {
                    date3 = date2;
                    if (composerStartRestartGroup.changedInstance(date3)) {
                        i7 = 16384;
                    } else {
                        i7 = 8192;
                    }
                    i3 |= i7;
                }
                i8 = i2 & 32;
                if (i8 != 0) {
                    if ((196608 & i) == 0) {
                        z2 = z;
                        if (composerStartRestartGroup.changed(z2)) {
                            i9 = 131072;
                        } else {
                            i9 = 65536;
                        }
                        i3 |= i9;
                    }
                    if ((i3 & 74899) != 74898) {
                        z3 = true;
                    } else {
                        z3 = false;
                    }
                    if (composerStartRestartGroup.shouldExecute(z3, i3 & 1)) {
                        composerStartRestartGroup.skipToGroupEnd();
                        f2 = f;
                        modifier3 = modifier2;
                        date4 = date3;
                        z4 = z2;
                    } else {
                        if (i10 != 0) {
                            companion = Modifier.INSTANCE;
                        } else {
                            companion = modifier2;
                        }
                        if (i4 != 0) {
                            f3 = 0.0f;
                        } else {
                            f3 = f;
                        }
                        if (i6 != 0) {
                            date5 = null;
                        } else {
                            date5 = date3;
                        }
                        if (i8 != 0) {
                            z5 = false;
                        } else {
                            z5 = z2;
                        }
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(2008889128, i3, -1, "com.box.android.base.compose.datepicker.BoxInlineDatePicker (BoxInlineDatePicker.kt:63)");
                        }
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2102144606, "CC(remember):BoxInlineDatePicker.kt#9igjgp");
                        zChanged = composerStartRestartGroup.changed(date5);
                        objRememberedValue = composerStartRestartGroup.rememberedValue();
                        if (!zChanged) {
                            objRememberedValue = Long.valueOf(DateExtensionsKt.toMidnightMillis$default(date5, null, 1, null));
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                        } else {
                            objRememberedValue = Long.valueOf(DateExtensionsKt.toMidnightMillis$default(date5, null, 1, null));
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                        }
                        jLongValue = ((Number) objRememberedValue).longValue();
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2102148621, "CC(remember):BoxInlineDatePicker.kt#9igjgp");
                        zChanged2 = composerStartRestartGroup.changed(date) | composerStartRestartGroup.changed(jLongValue);
                        objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                        if (!zChanged2) {
                            objRememberedValue2 = Long.valueOf(resolveInitialSelectedDateMillis(date, jLongValue));
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                        } else {
                            objRememberedValue2 = Long.valueOf(resolveInitialSelectedDateMillis(date, jLongValue));
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                        }
                        long jLongValue10 = ((Number) objRememberedValue2).longValue();
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        Date date14 = date5;
                        datePickerStateM3195rememberDatePickerStateEU0dCGE = DatePickerKt.m3195rememberDatePickerStateEU0dCGE(Long.valueOf(jLongValue10), null, null, 0, new SelectableDates() { // from class: com.box.android.base.compose.datepicker.BoxInlineDatePickerKt$BoxInlineDatePicker$datePickerState$1
                            @Override // androidx.compose.material3.SelectableDates
                            public /* bridge */ boolean isSelectableYear(int i11) {
                                return super.isSelectableYear(i11);
                            }

                            @Override // androidx.compose.material3.SelectableDates
                            public boolean isSelectableDate(long utcTimeMillis) {
                                return utcTimeMillis >= jLongValue;
                            }
                        }, composerStartRestartGroup, 0, 14);
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2102163894, "CC(remember):BoxInlineDatePicker.kt#9igjgp");
                        boolean zChanged11 = composerStartRestartGroup.changed(datePickerStateM3195rememberDatePickerStateEU0dCGE);
                        if ((i3 & 112) == 32) {
                            z6 = true;
                        } else {
                            z6 = false;
                        }
                        z7 = zChanged11 | z6;
                        boxInlineDatePickerKt$BoxInlineDatePicker$1$1RememberedValue = composerStartRestartGroup.rememberedValue();
                        if (!z7) {
                            boxInlineDatePickerKt$BoxInlineDatePicker$1$1RememberedValue = new BoxInlineDatePickerKt$BoxInlineDatePicker$1$1(datePickerStateM3195rememberDatePickerStateEU0dCGE, onDateSelected, null);
                            composerStartRestartGroup.updateRememberedValue(boxInlineDatePickerKt$BoxInlineDatePicker$1$1RememberedValue);
                        } else {
                            boxInlineDatePickerKt$BoxInlineDatePicker$1$1RememberedValue = new BoxInlineDatePickerKt$BoxInlineDatePicker$1$1(datePickerStateM3195rememberDatePickerStateEU0dCGE, onDateSelected, null);
                            composerStartRestartGroup.updateRememberedValue(boxInlineDatePickerKt$BoxInlineDatePicker$1$1RememberedValue);
                        }
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        EffectsKt.LaunchedEffect(datePickerStateM3195rememberDatePickerStateEU0dCGE, (Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object>) boxInlineDatePickerKt$BoxInlineDatePicker$1$1RememberedValue, composerStartRestartGroup, 0);
                        DatePickerColors datePickerColorsBoxInlineDatePickerColors9 = boxInlineDatePickerColors(composerStartRestartGroup, 0);
                        if (f3 > 0.0f) {
                            composerStartRestartGroup.startReplaceGroup(743215735);
                            ComposerKt.sourceInformation(composerStartRestartGroup, "104@4514L785");
                            Modifier modifierFillMaxWidth$default10 = SizeKt.fillMaxWidth$default(TestTagKt.testTag(companion, "BoxInlineDatePicker"), 0.0f, 1, null);
                            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2102191865, "CC(remember):BoxInlineDatePicker.kt#9igjgp");
                            if ((i3 & 7168) == 2048) {
                                z8 = true;
                            } else {
                                z8 = false;
                            }
                            objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                            if (!z8) {
                                objRememberedValue3 = new Function3() { // from class: com.box.android.base.compose.datepicker.BoxInlineDatePickerKt$$ExternalSyntheticLambda0
                                    @Override // kotlin.jvm.functions.Function3
                                    public final Object invoke(Object obj, Object obj2, Object obj3) {
                                        return BoxInlineDatePickerKt.BoxInlineDatePicker$lambda$3$0(f3, (MeasureScope) obj, (Measurable) obj2, (Constraints) obj3);
                                    }
                                };
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                            } else {
                                objRememberedValue3 = new Function3() { // from class: com.box.android.base.compose.datepicker.BoxInlineDatePickerKt$$ExternalSyntheticLambda0
                                    @Override // kotlin.jvm.functions.Function3
                                    public final Object invoke(Object obj, Object obj2, Object obj3) {
                                        return BoxInlineDatePickerKt.BoxInlineDatePicker$lambda$3$0(f3, (MeasureScope) obj, (Measurable) obj2, (Constraints) obj3);
                                    }
                                };
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                            }
                            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                            modifierFillMaxWidth$default = LayoutModifierKt.layout(modifierFillMaxWidth$default10, (Function3) objRememberedValue3);
                            composerStartRestartGroup.endReplaceGroup();
                        } else {
                            composerStartRestartGroup.startReplaceGroup(744212106);
                            composerStartRestartGroup.endReplaceGroup();
                            modifierFillMaxWidth$default = SizeKt.fillMaxWidth$default(TestTagKt.testTag(companion, "BoxInlineDatePicker"), 0.0f, 1, null);
                        }
                        boolean z17 = z5;
                        DatePickerKt.DatePicker(datePickerStateM3195rememberDatePickerStateEU0dCGE, modifierFillMaxWidth$default, null, datePickerColorsBoxInlineDatePickerColors9, null, null, z17, null, composerStartRestartGroup, ((i3 << 3) & 3670016) | 221184, Token.TARGET);
                        composerStartRestartGroup = composerStartRestartGroup;
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        modifier3 = companion;
                        f2 = f3;
                        z4 = z17;
                        date4 = date14;
                    }
                    scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup != null) {
                        scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.box.android.base.compose.datepicker.BoxInlineDatePickerKt$$ExternalSyntheticLambda1
                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj, Object obj2) {
                                return BoxInlineDatePickerKt.BoxInlineDatePicker$lambda$4(date, onDateSelected, modifier3, f2, date4, z4, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                            }
                        });
                    }
                }
                i3 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
                z2 = z;
                if ((i3 & 74899) != 74898) {
                    z3 = true;
                } else {
                    z3 = false;
                }
                if (composerStartRestartGroup.shouldExecute(z3, i3 & 1)) {
                    composerStartRestartGroup.skipToGroupEnd();
                    f2 = f;
                    modifier3 = modifier2;
                    date4 = date3;
                    z4 = z2;
                } else {
                    if (i10 != 0) {
                        companion = Modifier.INSTANCE;
                    } else {
                        companion = modifier2;
                    }
                    if (i4 != 0) {
                        f3 = 0.0f;
                    } else {
                        f3 = f;
                    }
                    if (i6 != 0) {
                        date5 = null;
                    } else {
                        date5 = date3;
                    }
                    if (i8 != 0) {
                        z5 = false;
                    } else {
                        z5 = z2;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(2008889128, i3, -1, "com.box.android.base.compose.datepicker.BoxInlineDatePicker (BoxInlineDatePicker.kt:63)");
                    }
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2102144606, "CC(remember):BoxInlineDatePicker.kt#9igjgp");
                    zChanged = composerStartRestartGroup.changed(date5);
                    objRememberedValue = composerStartRestartGroup.rememberedValue();
                    if (!zChanged) {
                        objRememberedValue = Long.valueOf(DateExtensionsKt.toMidnightMillis$default(date5, null, 1, null));
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                    } else {
                        objRememberedValue = Long.valueOf(DateExtensionsKt.toMidnightMillis$default(date5, null, 1, null));
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                    }
                    jLongValue = ((Number) objRememberedValue).longValue();
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2102148621, "CC(remember):BoxInlineDatePicker.kt#9igjgp");
                    zChanged2 = composerStartRestartGroup.changed(date) | composerStartRestartGroup.changed(jLongValue);
                    objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                    if (!zChanged2) {
                        objRememberedValue2 = Long.valueOf(resolveInitialSelectedDateMillis(date, jLongValue));
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                    } else {
                        objRememberedValue2 = Long.valueOf(resolveInitialSelectedDateMillis(date, jLongValue));
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                    }
                    long jLongValue11 = ((Number) objRememberedValue2).longValue();
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    Date date15 = date5;
                    datePickerStateM3195rememberDatePickerStateEU0dCGE = DatePickerKt.m3195rememberDatePickerStateEU0dCGE(Long.valueOf(jLongValue11), null, null, 0, new SelectableDates() { // from class: com.box.android.base.compose.datepicker.BoxInlineDatePickerKt$BoxInlineDatePicker$datePickerState$1
                        @Override // androidx.compose.material3.SelectableDates
                        public /* bridge */ boolean isSelectableYear(int i11) {
                            return super.isSelectableYear(i11);
                        }

                        @Override // androidx.compose.material3.SelectableDates
                        public boolean isSelectableDate(long utcTimeMillis) {
                            return utcTimeMillis >= jLongValue;
                        }
                    }, composerStartRestartGroup, 0, 14);
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2102163894, "CC(remember):BoxInlineDatePicker.kt#9igjgp");
                    boolean zChanged12 = composerStartRestartGroup.changed(datePickerStateM3195rememberDatePickerStateEU0dCGE);
                    if ((i3 & 112) == 32) {
                        z6 = true;
                    } else {
                        z6 = false;
                    }
                    z7 = zChanged12 | z6;
                    boxInlineDatePickerKt$BoxInlineDatePicker$1$1RememberedValue = composerStartRestartGroup.rememberedValue();
                    if (!z7) {
                        boxInlineDatePickerKt$BoxInlineDatePicker$1$1RememberedValue = new BoxInlineDatePickerKt$BoxInlineDatePicker$1$1(datePickerStateM3195rememberDatePickerStateEU0dCGE, onDateSelected, null);
                        composerStartRestartGroup.updateRememberedValue(boxInlineDatePickerKt$BoxInlineDatePicker$1$1RememberedValue);
                    } else {
                        boxInlineDatePickerKt$BoxInlineDatePicker$1$1RememberedValue = new BoxInlineDatePickerKt$BoxInlineDatePicker$1$1(datePickerStateM3195rememberDatePickerStateEU0dCGE, onDateSelected, null);
                        composerStartRestartGroup.updateRememberedValue(boxInlineDatePickerKt$BoxInlineDatePicker$1$1RememberedValue);
                    }
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    EffectsKt.LaunchedEffect(datePickerStateM3195rememberDatePickerStateEU0dCGE, (Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object>) boxInlineDatePickerKt$BoxInlineDatePicker$1$1RememberedValue, composerStartRestartGroup, 0);
                    DatePickerColors datePickerColorsBoxInlineDatePickerColors10 = boxInlineDatePickerColors(composerStartRestartGroup, 0);
                    if (f3 > 0.0f) {
                        composerStartRestartGroup.startReplaceGroup(743215735);
                        ComposerKt.sourceInformation(composerStartRestartGroup, "104@4514L785");
                        Modifier modifierFillMaxWidth$default11 = SizeKt.fillMaxWidth$default(TestTagKt.testTag(companion, "BoxInlineDatePicker"), 0.0f, 1, null);
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2102191865, "CC(remember):BoxInlineDatePicker.kt#9igjgp");
                        if ((i3 & 7168) == 2048) {
                            z8 = true;
                        } else {
                            z8 = false;
                        }
                        objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                        if (!z8) {
                            objRememberedValue3 = new Function3() { // from class: com.box.android.base.compose.datepicker.BoxInlineDatePickerKt$$ExternalSyntheticLambda0
                                @Override // kotlin.jvm.functions.Function3
                                public final Object invoke(Object obj, Object obj2, Object obj3) {
                                    return BoxInlineDatePickerKt.BoxInlineDatePicker$lambda$3$0(f3, (MeasureScope) obj, (Measurable) obj2, (Constraints) obj3);
                                }
                            };
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                        } else {
                            objRememberedValue3 = new Function3() { // from class: com.box.android.base.compose.datepicker.BoxInlineDatePickerKt$$ExternalSyntheticLambda0
                                @Override // kotlin.jvm.functions.Function3
                                public final Object invoke(Object obj, Object obj2, Object obj3) {
                                    return BoxInlineDatePickerKt.BoxInlineDatePicker$lambda$3$0(f3, (MeasureScope) obj, (Measurable) obj2, (Constraints) obj3);
                                }
                            };
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                        }
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        modifierFillMaxWidth$default = LayoutModifierKt.layout(modifierFillMaxWidth$default11, (Function3) objRememberedValue3);
                        composerStartRestartGroup.endReplaceGroup();
                    } else {
                        composerStartRestartGroup.startReplaceGroup(744212106);
                        composerStartRestartGroup.endReplaceGroup();
                        modifierFillMaxWidth$default = SizeKt.fillMaxWidth$default(TestTagKt.testTag(companion, "BoxInlineDatePicker"), 0.0f, 1, null);
                    }
                    boolean z18 = z5;
                    DatePickerKt.DatePicker(datePickerStateM3195rememberDatePickerStateEU0dCGE, modifierFillMaxWidth$default, null, datePickerColorsBoxInlineDatePickerColors10, null, null, z18, null, composerStartRestartGroup, ((i3 << 3) & 3670016) | 221184, Token.TARGET);
                    composerStartRestartGroup = composerStartRestartGroup;
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    modifier3 = companion;
                    f2 = f3;
                    z4 = z18;
                    date4 = date15;
                }
                scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.box.android.base.compose.datepicker.BoxInlineDatePickerKt$$ExternalSyntheticLambda1
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return BoxInlineDatePickerKt.BoxInlineDatePicker$lambda$4(date, onDateSelected, modifier3, f2, date4, z4, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    });
                }
            }
            i3 |= 24576;
            date3 = date2;
            i8 = i2 & 32;
            if (i8 != 0) {
                if ((196608 & i) == 0) {
                    z2 = z;
                    if (composerStartRestartGroup.changed(z2)) {
                        i9 = 131072;
                    } else {
                        i9 = 65536;
                    }
                    i3 |= i9;
                }
                if ((i3 & 74899) != 74898) {
                    z3 = true;
                } else {
                    z3 = false;
                }
                if (composerStartRestartGroup.shouldExecute(z3, i3 & 1)) {
                    composerStartRestartGroup.skipToGroupEnd();
                    f2 = f;
                    modifier3 = modifier2;
                    date4 = date3;
                    z4 = z2;
                } else {
                    if (i10 != 0) {
                        companion = Modifier.INSTANCE;
                    } else {
                        companion = modifier2;
                    }
                    if (i4 != 0) {
                        f3 = 0.0f;
                    } else {
                        f3 = f;
                    }
                    if (i6 != 0) {
                        date5 = null;
                    } else {
                        date5 = date3;
                    }
                    if (i8 != 0) {
                        z5 = false;
                    } else {
                        z5 = z2;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(2008889128, i3, -1, "com.box.android.base.compose.datepicker.BoxInlineDatePicker (BoxInlineDatePicker.kt:63)");
                    }
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2102144606, "CC(remember):BoxInlineDatePicker.kt#9igjgp");
                    zChanged = composerStartRestartGroup.changed(date5);
                    objRememberedValue = composerStartRestartGroup.rememberedValue();
                    if (!zChanged) {
                        objRememberedValue = Long.valueOf(DateExtensionsKt.toMidnightMillis$default(date5, null, 1, null));
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                    } else {
                        objRememberedValue = Long.valueOf(DateExtensionsKt.toMidnightMillis$default(date5, null, 1, null));
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                    }
                    jLongValue = ((Number) objRememberedValue).longValue();
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2102148621, "CC(remember):BoxInlineDatePicker.kt#9igjgp");
                    zChanged2 = composerStartRestartGroup.changed(date) | composerStartRestartGroup.changed(jLongValue);
                    objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                    if (!zChanged2) {
                        objRememberedValue2 = Long.valueOf(resolveInitialSelectedDateMillis(date, jLongValue));
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                    } else {
                        objRememberedValue2 = Long.valueOf(resolveInitialSelectedDateMillis(date, jLongValue));
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                    }
                    long jLongValue12 = ((Number) objRememberedValue2).longValue();
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    Date date16 = date5;
                    datePickerStateM3195rememberDatePickerStateEU0dCGE = DatePickerKt.m3195rememberDatePickerStateEU0dCGE(Long.valueOf(jLongValue12), null, null, 0, new SelectableDates() { // from class: com.box.android.base.compose.datepicker.BoxInlineDatePickerKt$BoxInlineDatePicker$datePickerState$1
                        @Override // androidx.compose.material3.SelectableDates
                        public /* bridge */ boolean isSelectableYear(int i11) {
                            return super.isSelectableYear(i11);
                        }

                        @Override // androidx.compose.material3.SelectableDates
                        public boolean isSelectableDate(long utcTimeMillis) {
                            return utcTimeMillis >= jLongValue;
                        }
                    }, composerStartRestartGroup, 0, 14);
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2102163894, "CC(remember):BoxInlineDatePicker.kt#9igjgp");
                    boolean zChanged13 = composerStartRestartGroup.changed(datePickerStateM3195rememberDatePickerStateEU0dCGE);
                    if ((i3 & 112) == 32) {
                        z6 = true;
                    } else {
                        z6 = false;
                    }
                    z7 = zChanged13 | z6;
                    boxInlineDatePickerKt$BoxInlineDatePicker$1$1RememberedValue = composerStartRestartGroup.rememberedValue();
                    if (!z7) {
                        boxInlineDatePickerKt$BoxInlineDatePicker$1$1RememberedValue = new BoxInlineDatePickerKt$BoxInlineDatePicker$1$1(datePickerStateM3195rememberDatePickerStateEU0dCGE, onDateSelected, null);
                        composerStartRestartGroup.updateRememberedValue(boxInlineDatePickerKt$BoxInlineDatePicker$1$1RememberedValue);
                    } else {
                        boxInlineDatePickerKt$BoxInlineDatePicker$1$1RememberedValue = new BoxInlineDatePickerKt$BoxInlineDatePicker$1$1(datePickerStateM3195rememberDatePickerStateEU0dCGE, onDateSelected, null);
                        composerStartRestartGroup.updateRememberedValue(boxInlineDatePickerKt$BoxInlineDatePicker$1$1RememberedValue);
                    }
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    EffectsKt.LaunchedEffect(datePickerStateM3195rememberDatePickerStateEU0dCGE, (Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object>) boxInlineDatePickerKt$BoxInlineDatePicker$1$1RememberedValue, composerStartRestartGroup, 0);
                    DatePickerColors datePickerColorsBoxInlineDatePickerColors11 = boxInlineDatePickerColors(composerStartRestartGroup, 0);
                    if (f3 > 0.0f) {
                        composerStartRestartGroup.startReplaceGroup(743215735);
                        ComposerKt.sourceInformation(composerStartRestartGroup, "104@4514L785");
                        Modifier modifierFillMaxWidth$default12 = SizeKt.fillMaxWidth$default(TestTagKt.testTag(companion, "BoxInlineDatePicker"), 0.0f, 1, null);
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2102191865, "CC(remember):BoxInlineDatePicker.kt#9igjgp");
                        if ((i3 & 7168) == 2048) {
                            z8 = true;
                        } else {
                            z8 = false;
                        }
                        objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                        if (!z8) {
                            objRememberedValue3 = new Function3() { // from class: com.box.android.base.compose.datepicker.BoxInlineDatePickerKt$$ExternalSyntheticLambda0
                                @Override // kotlin.jvm.functions.Function3
                                public final Object invoke(Object obj, Object obj2, Object obj3) {
                                    return BoxInlineDatePickerKt.BoxInlineDatePicker$lambda$3$0(f3, (MeasureScope) obj, (Measurable) obj2, (Constraints) obj3);
                                }
                            };
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                        } else {
                            objRememberedValue3 = new Function3() { // from class: com.box.android.base.compose.datepicker.BoxInlineDatePickerKt$$ExternalSyntheticLambda0
                                @Override // kotlin.jvm.functions.Function3
                                public final Object invoke(Object obj, Object obj2, Object obj3) {
                                    return BoxInlineDatePickerKt.BoxInlineDatePicker$lambda$3$0(f3, (MeasureScope) obj, (Measurable) obj2, (Constraints) obj3);
                                }
                            };
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                        }
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        modifierFillMaxWidth$default = LayoutModifierKt.layout(modifierFillMaxWidth$default12, (Function3) objRememberedValue3);
                        composerStartRestartGroup.endReplaceGroup();
                    } else {
                        composerStartRestartGroup.startReplaceGroup(744212106);
                        composerStartRestartGroup.endReplaceGroup();
                        modifierFillMaxWidth$default = SizeKt.fillMaxWidth$default(TestTagKt.testTag(companion, "BoxInlineDatePicker"), 0.0f, 1, null);
                    }
                    boolean z19 = z5;
                    DatePickerKt.DatePicker(datePickerStateM3195rememberDatePickerStateEU0dCGE, modifierFillMaxWidth$default, null, datePickerColorsBoxInlineDatePickerColors11, null, null, z19, null, composerStartRestartGroup, ((i3 << 3) & 3670016) | 221184, Token.TARGET);
                    composerStartRestartGroup = composerStartRestartGroup;
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    modifier3 = companion;
                    f2 = f3;
                    z4 = z19;
                    date4 = date16;
                }
                scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.box.android.base.compose.datepicker.BoxInlineDatePickerKt$$ExternalSyntheticLambda1
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return BoxInlineDatePickerKt.BoxInlineDatePicker$lambda$4(date, onDateSelected, modifier3, f2, date4, z4, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    });
                }
            }
            i3 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
            z2 = z;
            if ((i3 & 74899) != 74898) {
                z3 = true;
            } else {
                z3 = false;
            }
            if (composerStartRestartGroup.shouldExecute(z3, i3 & 1)) {
                composerStartRestartGroup.skipToGroupEnd();
                f2 = f;
                modifier3 = modifier2;
                date4 = date3;
                z4 = z2;
            } else {
                if (i10 != 0) {
                    companion = Modifier.INSTANCE;
                } else {
                    companion = modifier2;
                }
                if (i4 != 0) {
                    f3 = 0.0f;
                } else {
                    f3 = f;
                }
                if (i6 != 0) {
                    date5 = null;
                } else {
                    date5 = date3;
                }
                if (i8 != 0) {
                    z5 = false;
                } else {
                    z5 = z2;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(2008889128, i3, -1, "com.box.android.base.compose.datepicker.BoxInlineDatePicker (BoxInlineDatePicker.kt:63)");
                }
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2102144606, "CC(remember):BoxInlineDatePicker.kt#9igjgp");
                zChanged = composerStartRestartGroup.changed(date5);
                objRememberedValue = composerStartRestartGroup.rememberedValue();
                if (!zChanged) {
                    objRememberedValue = Long.valueOf(DateExtensionsKt.toMidnightMillis$default(date5, null, 1, null));
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                } else {
                    objRememberedValue = Long.valueOf(DateExtensionsKt.toMidnightMillis$default(date5, null, 1, null));
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                }
                jLongValue = ((Number) objRememberedValue).longValue();
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2102148621, "CC(remember):BoxInlineDatePicker.kt#9igjgp");
                zChanged2 = composerStartRestartGroup.changed(date) | composerStartRestartGroup.changed(jLongValue);
                objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                if (!zChanged2) {
                    objRememberedValue2 = Long.valueOf(resolveInitialSelectedDateMillis(date, jLongValue));
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                } else {
                    objRememberedValue2 = Long.valueOf(resolveInitialSelectedDateMillis(date, jLongValue));
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                }
                long jLongValue13 = ((Number) objRememberedValue2).longValue();
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                Date date17 = date5;
                datePickerStateM3195rememberDatePickerStateEU0dCGE = DatePickerKt.m3195rememberDatePickerStateEU0dCGE(Long.valueOf(jLongValue13), null, null, 0, new SelectableDates() { // from class: com.box.android.base.compose.datepicker.BoxInlineDatePickerKt$BoxInlineDatePicker$datePickerState$1
                    @Override // androidx.compose.material3.SelectableDates
                    public /* bridge */ boolean isSelectableYear(int i11) {
                        return super.isSelectableYear(i11);
                    }

                    @Override // androidx.compose.material3.SelectableDates
                    public boolean isSelectableDate(long utcTimeMillis) {
                        return utcTimeMillis >= jLongValue;
                    }
                }, composerStartRestartGroup, 0, 14);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2102163894, "CC(remember):BoxInlineDatePicker.kt#9igjgp");
                boolean zChanged14 = composerStartRestartGroup.changed(datePickerStateM3195rememberDatePickerStateEU0dCGE);
                if ((i3 & 112) == 32) {
                    z6 = true;
                } else {
                    z6 = false;
                }
                z7 = zChanged14 | z6;
                boxInlineDatePickerKt$BoxInlineDatePicker$1$1RememberedValue = composerStartRestartGroup.rememberedValue();
                if (!z7) {
                    boxInlineDatePickerKt$BoxInlineDatePicker$1$1RememberedValue = new BoxInlineDatePickerKt$BoxInlineDatePicker$1$1(datePickerStateM3195rememberDatePickerStateEU0dCGE, onDateSelected, null);
                    composerStartRestartGroup.updateRememberedValue(boxInlineDatePickerKt$BoxInlineDatePicker$1$1RememberedValue);
                } else {
                    boxInlineDatePickerKt$BoxInlineDatePicker$1$1RememberedValue = new BoxInlineDatePickerKt$BoxInlineDatePicker$1$1(datePickerStateM3195rememberDatePickerStateEU0dCGE, onDateSelected, null);
                    composerStartRestartGroup.updateRememberedValue(boxInlineDatePickerKt$BoxInlineDatePicker$1$1RememberedValue);
                }
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                EffectsKt.LaunchedEffect(datePickerStateM3195rememberDatePickerStateEU0dCGE, (Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object>) boxInlineDatePickerKt$BoxInlineDatePicker$1$1RememberedValue, composerStartRestartGroup, 0);
                DatePickerColors datePickerColorsBoxInlineDatePickerColors12 = boxInlineDatePickerColors(composerStartRestartGroup, 0);
                if (f3 > 0.0f) {
                    composerStartRestartGroup.startReplaceGroup(743215735);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "104@4514L785");
                    Modifier modifierFillMaxWidth$default13 = SizeKt.fillMaxWidth$default(TestTagKt.testTag(companion, "BoxInlineDatePicker"), 0.0f, 1, null);
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2102191865, "CC(remember):BoxInlineDatePicker.kt#9igjgp");
                    if ((i3 & 7168) == 2048) {
                        z8 = true;
                    } else {
                        z8 = false;
                    }
                    objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                    if (!z8) {
                        objRememberedValue3 = new Function3() { // from class: com.box.android.base.compose.datepicker.BoxInlineDatePickerKt$$ExternalSyntheticLambda0
                            @Override // kotlin.jvm.functions.Function3
                            public final Object invoke(Object obj, Object obj2, Object obj3) {
                                return BoxInlineDatePickerKt.BoxInlineDatePicker$lambda$3$0(f3, (MeasureScope) obj, (Measurable) obj2, (Constraints) obj3);
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                    } else {
                        objRememberedValue3 = new Function3() { // from class: com.box.android.base.compose.datepicker.BoxInlineDatePickerKt$$ExternalSyntheticLambda0
                            @Override // kotlin.jvm.functions.Function3
                            public final Object invoke(Object obj, Object obj2, Object obj3) {
                                return BoxInlineDatePickerKt.BoxInlineDatePicker$lambda$3$0(f3, (MeasureScope) obj, (Measurable) obj2, (Constraints) obj3);
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                    }
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    modifierFillMaxWidth$default = LayoutModifierKt.layout(modifierFillMaxWidth$default13, (Function3) objRememberedValue3);
                    composerStartRestartGroup.endReplaceGroup();
                } else {
                    composerStartRestartGroup.startReplaceGroup(744212106);
                    composerStartRestartGroup.endReplaceGroup();
                    modifierFillMaxWidth$default = SizeKt.fillMaxWidth$default(TestTagKt.testTag(companion, "BoxInlineDatePicker"), 0.0f, 1, null);
                }
                boolean z110 = z5;
                DatePickerKt.DatePicker(datePickerStateM3195rememberDatePickerStateEU0dCGE, modifierFillMaxWidth$default, null, datePickerColorsBoxInlineDatePickerColors12, null, null, z110, null, composerStartRestartGroup, ((i3 << 3) & 3670016) | 221184, Token.TARGET);
                composerStartRestartGroup = composerStartRestartGroup;
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                modifier3 = companion;
                f2 = f3;
                z4 = z110;
                date4 = date17;
            }
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.box.android.base.compose.datepicker.BoxInlineDatePickerKt$$ExternalSyntheticLambda1
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return BoxInlineDatePickerKt.BoxInlineDatePicker$lambda$4(date, onDateSelected, modifier3, f2, date4, z4, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                    }
                });
            }
        }
        i3 |= 3072;
        i6 = i2 & 16;
        if (i6 != 0) {
            if ((i & 24576) == 0) {
                date3 = date2;
                if (composerStartRestartGroup.changedInstance(date3)) {
                    i7 = 16384;
                } else {
                    i7 = 8192;
                }
                i3 |= i7;
            }
            i8 = i2 & 32;
            if (i8 != 0) {
                if ((196608 & i) == 0) {
                    z2 = z;
                    if (composerStartRestartGroup.changed(z2)) {
                        i9 = 131072;
                    } else {
                        i9 = 65536;
                    }
                    i3 |= i9;
                }
                if ((i3 & 74899) != 74898) {
                    z3 = true;
                } else {
                    z3 = false;
                }
                if (composerStartRestartGroup.shouldExecute(z3, i3 & 1)) {
                    composerStartRestartGroup.skipToGroupEnd();
                    f2 = f;
                    modifier3 = modifier2;
                    date4 = date3;
                    z4 = z2;
                } else {
                    if (i10 != 0) {
                        companion = Modifier.INSTANCE;
                    } else {
                        companion = modifier2;
                    }
                    if (i4 != 0) {
                        f3 = 0.0f;
                    } else {
                        f3 = f;
                    }
                    if (i6 != 0) {
                        date5 = null;
                    } else {
                        date5 = date3;
                    }
                    if (i8 != 0) {
                        z5 = false;
                    } else {
                        z5 = z2;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(2008889128, i3, -1, "com.box.android.base.compose.datepicker.BoxInlineDatePicker (BoxInlineDatePicker.kt:63)");
                    }
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2102144606, "CC(remember):BoxInlineDatePicker.kt#9igjgp");
                    zChanged = composerStartRestartGroup.changed(date5);
                    objRememberedValue = composerStartRestartGroup.rememberedValue();
                    if (!zChanged) {
                        objRememberedValue = Long.valueOf(DateExtensionsKt.toMidnightMillis$default(date5, null, 1, null));
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                    } else {
                        objRememberedValue = Long.valueOf(DateExtensionsKt.toMidnightMillis$default(date5, null, 1, null));
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                    }
                    jLongValue = ((Number) objRememberedValue).longValue();
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2102148621, "CC(remember):BoxInlineDatePicker.kt#9igjgp");
                    zChanged2 = composerStartRestartGroup.changed(date) | composerStartRestartGroup.changed(jLongValue);
                    objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                    if (!zChanged2) {
                        objRememberedValue2 = Long.valueOf(resolveInitialSelectedDateMillis(date, jLongValue));
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                    } else {
                        objRememberedValue2 = Long.valueOf(resolveInitialSelectedDateMillis(date, jLongValue));
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                    }
                    long jLongValue14 = ((Number) objRememberedValue2).longValue();
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    Date date18 = date5;
                    datePickerStateM3195rememberDatePickerStateEU0dCGE = DatePickerKt.m3195rememberDatePickerStateEU0dCGE(Long.valueOf(jLongValue14), null, null, 0, new SelectableDates() { // from class: com.box.android.base.compose.datepicker.BoxInlineDatePickerKt$BoxInlineDatePicker$datePickerState$1
                        @Override // androidx.compose.material3.SelectableDates
                        public /* bridge */ boolean isSelectableYear(int i11) {
                            return super.isSelectableYear(i11);
                        }

                        @Override // androidx.compose.material3.SelectableDates
                        public boolean isSelectableDate(long utcTimeMillis) {
                            return utcTimeMillis >= jLongValue;
                        }
                    }, composerStartRestartGroup, 0, 14);
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2102163894, "CC(remember):BoxInlineDatePicker.kt#9igjgp");
                    boolean zChanged15 = composerStartRestartGroup.changed(datePickerStateM3195rememberDatePickerStateEU0dCGE);
                    if ((i3 & 112) == 32) {
                        z6 = true;
                    } else {
                        z6 = false;
                    }
                    z7 = zChanged15 | z6;
                    boxInlineDatePickerKt$BoxInlineDatePicker$1$1RememberedValue = composerStartRestartGroup.rememberedValue();
                    if (!z7) {
                        boxInlineDatePickerKt$BoxInlineDatePicker$1$1RememberedValue = new BoxInlineDatePickerKt$BoxInlineDatePicker$1$1(datePickerStateM3195rememberDatePickerStateEU0dCGE, onDateSelected, null);
                        composerStartRestartGroup.updateRememberedValue(boxInlineDatePickerKt$BoxInlineDatePicker$1$1RememberedValue);
                    } else {
                        boxInlineDatePickerKt$BoxInlineDatePicker$1$1RememberedValue = new BoxInlineDatePickerKt$BoxInlineDatePicker$1$1(datePickerStateM3195rememberDatePickerStateEU0dCGE, onDateSelected, null);
                        composerStartRestartGroup.updateRememberedValue(boxInlineDatePickerKt$BoxInlineDatePicker$1$1RememberedValue);
                    }
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    EffectsKt.LaunchedEffect(datePickerStateM3195rememberDatePickerStateEU0dCGE, (Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object>) boxInlineDatePickerKt$BoxInlineDatePicker$1$1RememberedValue, composerStartRestartGroup, 0);
                    DatePickerColors datePickerColorsBoxInlineDatePickerColors13 = boxInlineDatePickerColors(composerStartRestartGroup, 0);
                    if (f3 > 0.0f) {
                        composerStartRestartGroup.startReplaceGroup(743215735);
                        ComposerKt.sourceInformation(composerStartRestartGroup, "104@4514L785");
                        Modifier modifierFillMaxWidth$default14 = SizeKt.fillMaxWidth$default(TestTagKt.testTag(companion, "BoxInlineDatePicker"), 0.0f, 1, null);
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2102191865, "CC(remember):BoxInlineDatePicker.kt#9igjgp");
                        if ((i3 & 7168) == 2048) {
                            z8 = true;
                        } else {
                            z8 = false;
                        }
                        objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                        if (!z8) {
                            objRememberedValue3 = new Function3() { // from class: com.box.android.base.compose.datepicker.BoxInlineDatePickerKt$$ExternalSyntheticLambda0
                                @Override // kotlin.jvm.functions.Function3
                                public final Object invoke(Object obj, Object obj2, Object obj3) {
                                    return BoxInlineDatePickerKt.BoxInlineDatePicker$lambda$3$0(f3, (MeasureScope) obj, (Measurable) obj2, (Constraints) obj3);
                                }
                            };
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                        } else {
                            objRememberedValue3 = new Function3() { // from class: com.box.android.base.compose.datepicker.BoxInlineDatePickerKt$$ExternalSyntheticLambda0
                                @Override // kotlin.jvm.functions.Function3
                                public final Object invoke(Object obj, Object obj2, Object obj3) {
                                    return BoxInlineDatePickerKt.BoxInlineDatePicker$lambda$3$0(f3, (MeasureScope) obj, (Measurable) obj2, (Constraints) obj3);
                                }
                            };
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                        }
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        modifierFillMaxWidth$default = LayoutModifierKt.layout(modifierFillMaxWidth$default14, (Function3) objRememberedValue3);
                        composerStartRestartGroup.endReplaceGroup();
                    } else {
                        composerStartRestartGroup.startReplaceGroup(744212106);
                        composerStartRestartGroup.endReplaceGroup();
                        modifierFillMaxWidth$default = SizeKt.fillMaxWidth$default(TestTagKt.testTag(companion, "BoxInlineDatePicker"), 0.0f, 1, null);
                    }
                    boolean z111 = z5;
                    DatePickerKt.DatePicker(datePickerStateM3195rememberDatePickerStateEU0dCGE, modifierFillMaxWidth$default, null, datePickerColorsBoxInlineDatePickerColors13, null, null, z111, null, composerStartRestartGroup, ((i3 << 3) & 3670016) | 221184, Token.TARGET);
                    composerStartRestartGroup = composerStartRestartGroup;
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    modifier3 = companion;
                    f2 = f3;
                    z4 = z111;
                    date4 = date18;
                }
                scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.box.android.base.compose.datepicker.BoxInlineDatePickerKt$$ExternalSyntheticLambda1
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return BoxInlineDatePickerKt.BoxInlineDatePicker$lambda$4(date, onDateSelected, modifier3, f2, date4, z4, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    });
                }
            }
            i3 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
            z2 = z;
            if ((i3 & 74899) != 74898) {
                z3 = true;
            } else {
                z3 = false;
            }
            if (composerStartRestartGroup.shouldExecute(z3, i3 & 1)) {
                composerStartRestartGroup.skipToGroupEnd();
                f2 = f;
                modifier3 = modifier2;
                date4 = date3;
                z4 = z2;
            } else {
                if (i10 != 0) {
                    companion = Modifier.INSTANCE;
                } else {
                    companion = modifier2;
                }
                if (i4 != 0) {
                    f3 = 0.0f;
                } else {
                    f3 = f;
                }
                if (i6 != 0) {
                    date5 = null;
                } else {
                    date5 = date3;
                }
                if (i8 != 0) {
                    z5 = false;
                } else {
                    z5 = z2;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(2008889128, i3, -1, "com.box.android.base.compose.datepicker.BoxInlineDatePicker (BoxInlineDatePicker.kt:63)");
                }
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2102144606, "CC(remember):BoxInlineDatePicker.kt#9igjgp");
                zChanged = composerStartRestartGroup.changed(date5);
                objRememberedValue = composerStartRestartGroup.rememberedValue();
                if (!zChanged) {
                    objRememberedValue = Long.valueOf(DateExtensionsKt.toMidnightMillis$default(date5, null, 1, null));
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                } else {
                    objRememberedValue = Long.valueOf(DateExtensionsKt.toMidnightMillis$default(date5, null, 1, null));
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                }
                jLongValue = ((Number) objRememberedValue).longValue();
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2102148621, "CC(remember):BoxInlineDatePicker.kt#9igjgp");
                zChanged2 = composerStartRestartGroup.changed(date) | composerStartRestartGroup.changed(jLongValue);
                objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                if (!zChanged2) {
                    objRememberedValue2 = Long.valueOf(resolveInitialSelectedDateMillis(date, jLongValue));
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                } else {
                    objRememberedValue2 = Long.valueOf(resolveInitialSelectedDateMillis(date, jLongValue));
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                }
                long jLongValue15 = ((Number) objRememberedValue2).longValue();
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                Date date19 = date5;
                datePickerStateM3195rememberDatePickerStateEU0dCGE = DatePickerKt.m3195rememberDatePickerStateEU0dCGE(Long.valueOf(jLongValue15), null, null, 0, new SelectableDates() { // from class: com.box.android.base.compose.datepicker.BoxInlineDatePickerKt$BoxInlineDatePicker$datePickerState$1
                    @Override // androidx.compose.material3.SelectableDates
                    public /* bridge */ boolean isSelectableYear(int i11) {
                        return super.isSelectableYear(i11);
                    }

                    @Override // androidx.compose.material3.SelectableDates
                    public boolean isSelectableDate(long utcTimeMillis) {
                        return utcTimeMillis >= jLongValue;
                    }
                }, composerStartRestartGroup, 0, 14);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2102163894, "CC(remember):BoxInlineDatePicker.kt#9igjgp");
                boolean zChanged16 = composerStartRestartGroup.changed(datePickerStateM3195rememberDatePickerStateEU0dCGE);
                if ((i3 & 112) == 32) {
                    z6 = true;
                } else {
                    z6 = false;
                }
                z7 = zChanged16 | z6;
                boxInlineDatePickerKt$BoxInlineDatePicker$1$1RememberedValue = composerStartRestartGroup.rememberedValue();
                if (!z7) {
                    boxInlineDatePickerKt$BoxInlineDatePicker$1$1RememberedValue = new BoxInlineDatePickerKt$BoxInlineDatePicker$1$1(datePickerStateM3195rememberDatePickerStateEU0dCGE, onDateSelected, null);
                    composerStartRestartGroup.updateRememberedValue(boxInlineDatePickerKt$BoxInlineDatePicker$1$1RememberedValue);
                } else {
                    boxInlineDatePickerKt$BoxInlineDatePicker$1$1RememberedValue = new BoxInlineDatePickerKt$BoxInlineDatePicker$1$1(datePickerStateM3195rememberDatePickerStateEU0dCGE, onDateSelected, null);
                    composerStartRestartGroup.updateRememberedValue(boxInlineDatePickerKt$BoxInlineDatePicker$1$1RememberedValue);
                }
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                EffectsKt.LaunchedEffect(datePickerStateM3195rememberDatePickerStateEU0dCGE, (Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object>) boxInlineDatePickerKt$BoxInlineDatePicker$1$1RememberedValue, composerStartRestartGroup, 0);
                DatePickerColors datePickerColorsBoxInlineDatePickerColors14 = boxInlineDatePickerColors(composerStartRestartGroup, 0);
                if (f3 > 0.0f) {
                    composerStartRestartGroup.startReplaceGroup(743215735);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "104@4514L785");
                    Modifier modifierFillMaxWidth$default15 = SizeKt.fillMaxWidth$default(TestTagKt.testTag(companion, "BoxInlineDatePicker"), 0.0f, 1, null);
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2102191865, "CC(remember):BoxInlineDatePicker.kt#9igjgp");
                    if ((i3 & 7168) == 2048) {
                        z8 = true;
                    } else {
                        z8 = false;
                    }
                    objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                    if (!z8) {
                        objRememberedValue3 = new Function3() { // from class: com.box.android.base.compose.datepicker.BoxInlineDatePickerKt$$ExternalSyntheticLambda0
                            @Override // kotlin.jvm.functions.Function3
                            public final Object invoke(Object obj, Object obj2, Object obj3) {
                                return BoxInlineDatePickerKt.BoxInlineDatePicker$lambda$3$0(f3, (MeasureScope) obj, (Measurable) obj2, (Constraints) obj3);
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                    } else {
                        objRememberedValue3 = new Function3() { // from class: com.box.android.base.compose.datepicker.BoxInlineDatePickerKt$$ExternalSyntheticLambda0
                            @Override // kotlin.jvm.functions.Function3
                            public final Object invoke(Object obj, Object obj2, Object obj3) {
                                return BoxInlineDatePickerKt.BoxInlineDatePicker$lambda$3$0(f3, (MeasureScope) obj, (Measurable) obj2, (Constraints) obj3);
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                    }
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    modifierFillMaxWidth$default = LayoutModifierKt.layout(modifierFillMaxWidth$default15, (Function3) objRememberedValue3);
                    composerStartRestartGroup.endReplaceGroup();
                } else {
                    composerStartRestartGroup.startReplaceGroup(744212106);
                    composerStartRestartGroup.endReplaceGroup();
                    modifierFillMaxWidth$default = SizeKt.fillMaxWidth$default(TestTagKt.testTag(companion, "BoxInlineDatePicker"), 0.0f, 1, null);
                }
                boolean z112 = z5;
                DatePickerKt.DatePicker(datePickerStateM3195rememberDatePickerStateEU0dCGE, modifierFillMaxWidth$default, null, datePickerColorsBoxInlineDatePickerColors14, null, null, z112, null, composerStartRestartGroup, ((i3 << 3) & 3670016) | 221184, Token.TARGET);
                composerStartRestartGroup = composerStartRestartGroup;
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                modifier3 = companion;
                f2 = f3;
                z4 = z112;
                date4 = date19;
            }
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.box.android.base.compose.datepicker.BoxInlineDatePickerKt$$ExternalSyntheticLambda1
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return BoxInlineDatePickerKt.BoxInlineDatePicker$lambda$4(date, onDateSelected, modifier3, f2, date4, z4, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                    }
                });
            }
        }
        i3 |= 24576;
        date3 = date2;
        i8 = i2 & 32;
        if (i8 != 0) {
            if ((196608 & i) == 0) {
                z2 = z;
                if (composerStartRestartGroup.changed(z2)) {
                    i9 = 131072;
                } else {
                    i9 = 65536;
                }
                i3 |= i9;
            }
            if ((i3 & 74899) != 74898) {
                z3 = true;
            } else {
                z3 = false;
            }
            if (composerStartRestartGroup.shouldExecute(z3, i3 & 1)) {
                composerStartRestartGroup.skipToGroupEnd();
                f2 = f;
                modifier3 = modifier2;
                date4 = date3;
                z4 = z2;
            } else {
                if (i10 != 0) {
                    companion = Modifier.INSTANCE;
                } else {
                    companion = modifier2;
                }
                if (i4 != 0) {
                    f3 = 0.0f;
                } else {
                    f3 = f;
                }
                if (i6 != 0) {
                    date5 = null;
                } else {
                    date5 = date3;
                }
                if (i8 != 0) {
                    z5 = false;
                } else {
                    z5 = z2;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(2008889128, i3, -1, "com.box.android.base.compose.datepicker.BoxInlineDatePicker (BoxInlineDatePicker.kt:63)");
                }
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2102144606, "CC(remember):BoxInlineDatePicker.kt#9igjgp");
                zChanged = composerStartRestartGroup.changed(date5);
                objRememberedValue = composerStartRestartGroup.rememberedValue();
                if (!zChanged) {
                    objRememberedValue = Long.valueOf(DateExtensionsKt.toMidnightMillis$default(date5, null, 1, null));
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                } else {
                    objRememberedValue = Long.valueOf(DateExtensionsKt.toMidnightMillis$default(date5, null, 1, null));
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                }
                jLongValue = ((Number) objRememberedValue).longValue();
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2102148621, "CC(remember):BoxInlineDatePicker.kt#9igjgp");
                zChanged2 = composerStartRestartGroup.changed(date) | composerStartRestartGroup.changed(jLongValue);
                objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                if (!zChanged2) {
                    objRememberedValue2 = Long.valueOf(resolveInitialSelectedDateMillis(date, jLongValue));
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                } else {
                    objRememberedValue2 = Long.valueOf(resolveInitialSelectedDateMillis(date, jLongValue));
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                }
                long jLongValue16 = ((Number) objRememberedValue2).longValue();
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                Date date110 = date5;
                datePickerStateM3195rememberDatePickerStateEU0dCGE = DatePickerKt.m3195rememberDatePickerStateEU0dCGE(Long.valueOf(jLongValue16), null, null, 0, new SelectableDates() { // from class: com.box.android.base.compose.datepicker.BoxInlineDatePickerKt$BoxInlineDatePicker$datePickerState$1
                    @Override // androidx.compose.material3.SelectableDates
                    public /* bridge */ boolean isSelectableYear(int i11) {
                        return super.isSelectableYear(i11);
                    }

                    @Override // androidx.compose.material3.SelectableDates
                    public boolean isSelectableDate(long utcTimeMillis) {
                        return utcTimeMillis >= jLongValue;
                    }
                }, composerStartRestartGroup, 0, 14);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2102163894, "CC(remember):BoxInlineDatePicker.kt#9igjgp");
                boolean zChanged17 = composerStartRestartGroup.changed(datePickerStateM3195rememberDatePickerStateEU0dCGE);
                if ((i3 & 112) == 32) {
                    z6 = true;
                } else {
                    z6 = false;
                }
                z7 = zChanged17 | z6;
                boxInlineDatePickerKt$BoxInlineDatePicker$1$1RememberedValue = composerStartRestartGroup.rememberedValue();
                if (!z7) {
                    boxInlineDatePickerKt$BoxInlineDatePicker$1$1RememberedValue = new BoxInlineDatePickerKt$BoxInlineDatePicker$1$1(datePickerStateM3195rememberDatePickerStateEU0dCGE, onDateSelected, null);
                    composerStartRestartGroup.updateRememberedValue(boxInlineDatePickerKt$BoxInlineDatePicker$1$1RememberedValue);
                } else {
                    boxInlineDatePickerKt$BoxInlineDatePicker$1$1RememberedValue = new BoxInlineDatePickerKt$BoxInlineDatePicker$1$1(datePickerStateM3195rememberDatePickerStateEU0dCGE, onDateSelected, null);
                    composerStartRestartGroup.updateRememberedValue(boxInlineDatePickerKt$BoxInlineDatePicker$1$1RememberedValue);
                }
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                EffectsKt.LaunchedEffect(datePickerStateM3195rememberDatePickerStateEU0dCGE, (Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object>) boxInlineDatePickerKt$BoxInlineDatePicker$1$1RememberedValue, composerStartRestartGroup, 0);
                DatePickerColors datePickerColorsBoxInlineDatePickerColors15 = boxInlineDatePickerColors(composerStartRestartGroup, 0);
                if (f3 > 0.0f) {
                    composerStartRestartGroup.startReplaceGroup(743215735);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "104@4514L785");
                    Modifier modifierFillMaxWidth$default16 = SizeKt.fillMaxWidth$default(TestTagKt.testTag(companion, "BoxInlineDatePicker"), 0.0f, 1, null);
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2102191865, "CC(remember):BoxInlineDatePicker.kt#9igjgp");
                    if ((i3 & 7168) == 2048) {
                        z8 = true;
                    } else {
                        z8 = false;
                    }
                    objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                    if (!z8) {
                        objRememberedValue3 = new Function3() { // from class: com.box.android.base.compose.datepicker.BoxInlineDatePickerKt$$ExternalSyntheticLambda0
                            @Override // kotlin.jvm.functions.Function3
                            public final Object invoke(Object obj, Object obj2, Object obj3) {
                                return BoxInlineDatePickerKt.BoxInlineDatePicker$lambda$3$0(f3, (MeasureScope) obj, (Measurable) obj2, (Constraints) obj3);
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                    } else {
                        objRememberedValue3 = new Function3() { // from class: com.box.android.base.compose.datepicker.BoxInlineDatePickerKt$$ExternalSyntheticLambda0
                            @Override // kotlin.jvm.functions.Function3
                            public final Object invoke(Object obj, Object obj2, Object obj3) {
                                return BoxInlineDatePickerKt.BoxInlineDatePicker$lambda$3$0(f3, (MeasureScope) obj, (Measurable) obj2, (Constraints) obj3);
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                    }
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    modifierFillMaxWidth$default = LayoutModifierKt.layout(modifierFillMaxWidth$default16, (Function3) objRememberedValue3);
                    composerStartRestartGroup.endReplaceGroup();
                } else {
                    composerStartRestartGroup.startReplaceGroup(744212106);
                    composerStartRestartGroup.endReplaceGroup();
                    modifierFillMaxWidth$default = SizeKt.fillMaxWidth$default(TestTagKt.testTag(companion, "BoxInlineDatePicker"), 0.0f, 1, null);
                }
                boolean z113 = z5;
                DatePickerKt.DatePicker(datePickerStateM3195rememberDatePickerStateEU0dCGE, modifierFillMaxWidth$default, null, datePickerColorsBoxInlineDatePickerColors15, null, null, z113, null, composerStartRestartGroup, ((i3 << 3) & 3670016) | 221184, Token.TARGET);
                composerStartRestartGroup = composerStartRestartGroup;
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                modifier3 = companion;
                f2 = f3;
                z4 = z113;
                date4 = date110;
            }
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.box.android.base.compose.datepicker.BoxInlineDatePickerKt$$ExternalSyntheticLambda1
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return BoxInlineDatePickerKt.BoxInlineDatePicker$lambda$4(date, onDateSelected, modifier3, f2, date4, z4, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                    }
                });
            }
        }
        i3 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
        z2 = z;
        if ((i3 & 74899) != 74898) {
            z3 = true;
        } else {
            z3 = false;
        }
        if (composerStartRestartGroup.shouldExecute(z3, i3 & 1)) {
            composerStartRestartGroup.skipToGroupEnd();
            f2 = f;
            modifier3 = modifier2;
            date4 = date3;
            z4 = z2;
        } else {
            if (i10 != 0) {
                companion = Modifier.INSTANCE;
            } else {
                companion = modifier2;
            }
            if (i4 != 0) {
                f3 = 0.0f;
            } else {
                f3 = f;
            }
            if (i6 != 0) {
                date5 = null;
            } else {
                date5 = date3;
            }
            if (i8 != 0) {
                z5 = false;
            } else {
                z5 = z2;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(2008889128, i3, -1, "com.box.android.base.compose.datepicker.BoxInlineDatePicker (BoxInlineDatePicker.kt:63)");
            }
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2102144606, "CC(remember):BoxInlineDatePicker.kt#9igjgp");
            zChanged = composerStartRestartGroup.changed(date5);
            objRememberedValue = composerStartRestartGroup.rememberedValue();
            if (!zChanged) {
                objRememberedValue = Long.valueOf(DateExtensionsKt.toMidnightMillis$default(date5, null, 1, null));
                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
            } else {
                objRememberedValue = Long.valueOf(DateExtensionsKt.toMidnightMillis$default(date5, null, 1, null));
                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
            }
            jLongValue = ((Number) objRememberedValue).longValue();
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2102148621, "CC(remember):BoxInlineDatePicker.kt#9igjgp");
            zChanged2 = composerStartRestartGroup.changed(date) | composerStartRestartGroup.changed(jLongValue);
            objRememberedValue2 = composerStartRestartGroup.rememberedValue();
            if (!zChanged2) {
                objRememberedValue2 = Long.valueOf(resolveInitialSelectedDateMillis(date, jLongValue));
                composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
            } else {
                objRememberedValue2 = Long.valueOf(resolveInitialSelectedDateMillis(date, jLongValue));
                composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
            }
            long jLongValue17 = ((Number) objRememberedValue2).longValue();
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            Date date111 = date5;
            datePickerStateM3195rememberDatePickerStateEU0dCGE = DatePickerKt.m3195rememberDatePickerStateEU0dCGE(Long.valueOf(jLongValue17), null, null, 0, new SelectableDates() { // from class: com.box.android.base.compose.datepicker.BoxInlineDatePickerKt$BoxInlineDatePicker$datePickerState$1
                @Override // androidx.compose.material3.SelectableDates
                public /* bridge */ boolean isSelectableYear(int i11) {
                    return super.isSelectableYear(i11);
                }

                @Override // androidx.compose.material3.SelectableDates
                public boolean isSelectableDate(long utcTimeMillis) {
                    return utcTimeMillis >= jLongValue;
                }
            }, composerStartRestartGroup, 0, 14);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2102163894, "CC(remember):BoxInlineDatePicker.kt#9igjgp");
            boolean zChanged18 = composerStartRestartGroup.changed(datePickerStateM3195rememberDatePickerStateEU0dCGE);
            if ((i3 & 112) == 32) {
                z6 = true;
            } else {
                z6 = false;
            }
            z7 = zChanged18 | z6;
            boxInlineDatePickerKt$BoxInlineDatePicker$1$1RememberedValue = composerStartRestartGroup.rememberedValue();
            if (!z7) {
                boxInlineDatePickerKt$BoxInlineDatePicker$1$1RememberedValue = new BoxInlineDatePickerKt$BoxInlineDatePicker$1$1(datePickerStateM3195rememberDatePickerStateEU0dCGE, onDateSelected, null);
                composerStartRestartGroup.updateRememberedValue(boxInlineDatePickerKt$BoxInlineDatePicker$1$1RememberedValue);
            } else {
                boxInlineDatePickerKt$BoxInlineDatePicker$1$1RememberedValue = new BoxInlineDatePickerKt$BoxInlineDatePicker$1$1(datePickerStateM3195rememberDatePickerStateEU0dCGE, onDateSelected, null);
                composerStartRestartGroup.updateRememberedValue(boxInlineDatePickerKt$BoxInlineDatePicker$1$1RememberedValue);
            }
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            EffectsKt.LaunchedEffect(datePickerStateM3195rememberDatePickerStateEU0dCGE, (Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object>) boxInlineDatePickerKt$BoxInlineDatePicker$1$1RememberedValue, composerStartRestartGroup, 0);
            DatePickerColors datePickerColorsBoxInlineDatePickerColors16 = boxInlineDatePickerColors(composerStartRestartGroup, 0);
            if (f3 > 0.0f) {
                composerStartRestartGroup.startReplaceGroup(743215735);
                ComposerKt.sourceInformation(composerStartRestartGroup, "104@4514L785");
                Modifier modifierFillMaxWidth$default17 = SizeKt.fillMaxWidth$default(TestTagKt.testTag(companion, "BoxInlineDatePicker"), 0.0f, 1, null);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2102191865, "CC(remember):BoxInlineDatePicker.kt#9igjgp");
                if ((i3 & 7168) == 2048) {
                    z8 = true;
                } else {
                    z8 = false;
                }
                objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                if (!z8) {
                    objRememberedValue3 = new Function3() { // from class: com.box.android.base.compose.datepicker.BoxInlineDatePickerKt$$ExternalSyntheticLambda0
                        @Override // kotlin.jvm.functions.Function3
                        public final Object invoke(Object obj, Object obj2, Object obj3) {
                            return BoxInlineDatePickerKt.BoxInlineDatePicker$lambda$3$0(f3, (MeasureScope) obj, (Measurable) obj2, (Constraints) obj3);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                } else {
                    objRememberedValue3 = new Function3() { // from class: com.box.android.base.compose.datepicker.BoxInlineDatePickerKt$$ExternalSyntheticLambda0
                        @Override // kotlin.jvm.functions.Function3
                        public final Object invoke(Object obj, Object obj2, Object obj3) {
                            return BoxInlineDatePickerKt.BoxInlineDatePicker$lambda$3$0(f3, (MeasureScope) obj, (Measurable) obj2, (Constraints) obj3);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                }
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                modifierFillMaxWidth$default = LayoutModifierKt.layout(modifierFillMaxWidth$default17, (Function3) objRememberedValue3);
                composerStartRestartGroup.endReplaceGroup();
            } else {
                composerStartRestartGroup.startReplaceGroup(744212106);
                composerStartRestartGroup.endReplaceGroup();
                modifierFillMaxWidth$default = SizeKt.fillMaxWidth$default(TestTagKt.testTag(companion, "BoxInlineDatePicker"), 0.0f, 1, null);
            }
            boolean z114 = z5;
            DatePickerKt.DatePicker(datePickerStateM3195rememberDatePickerStateEU0dCGE, modifierFillMaxWidth$default, null, datePickerColorsBoxInlineDatePickerColors16, null, null, z114, null, composerStartRestartGroup, ((i3 << 3) & 3670016) | 221184, Token.TARGET);
            composerStartRestartGroup = composerStartRestartGroup;
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            modifier3 = companion;
            f2 = f3;
            z4 = z114;
            date4 = date111;
        }
        scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.box.android.base.compose.datepicker.BoxInlineDatePickerKt$$ExternalSyntheticLambda1
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return BoxInlineDatePickerKt.BoxInlineDatePicker$lambda$4(date, onDateSelected, modifier3, f2, date4, z4, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final MeasureResult BoxInlineDatePicker$lambda$3$0(final float f, MeasureScope layout, Measurable measurable, Constraints constraints) {
        Intrinsics.checkNotNullParameter(layout, "$this$layout");
        Intrinsics.checkNotNullParameter(measurable, "measurable");
        final Placeable placeableMo8265measureBRTryo0 = measurable.mo8265measureBRTryo0(constraints.getValue());
        final int height = (int) (placeableMo8265measureBRTryo0.getHeight() * f);
        return MeasureScope.layout$default(layout, placeableMo8265measureBRTryo0.getWidth(), height, null, new Function1() { // from class: com.box.android.base.compose.datepicker.BoxInlineDatePickerKt$$ExternalSyntheticLambda3
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return BoxInlineDatePickerKt.BoxInlineDatePicker$lambda$3$0$0(placeableMo8265measureBRTryo0, height, f, (Placeable.PlacementScope) obj);
            }
        }, 4, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit BoxInlineDatePicker$lambda$3$0$0(Placeable placeable, int i, final float f, Placeable.PlacementScope layout) {
        Intrinsics.checkNotNullParameter(layout, "$this$layout");
        Placeable.PlacementScope.placeRelativeWithLayer$default(layout, placeable, 0, -((placeable.getHeight() - i) / 2), 0.0f, new Function1() { // from class: com.box.android.base.compose.datepicker.BoxInlineDatePickerKt$$ExternalSyntheticLambda4
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return BoxInlineDatePickerKt.BoxInlineDatePicker$lambda$3$0$0$0(f, (GraphicsLayerScope) obj);
            }
        }, 4, (Object) null);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit BoxInlineDatePicker$lambda$3$0$0$0(float f, GraphicsLayerScope placeRelativeWithLayer) {
        Intrinsics.checkNotNullParameter(placeRelativeWithLayer, "$this$placeRelativeWithLayer");
        placeRelativeWithLayer.setScaleX(f);
        placeRelativeWithLayer.setScaleY(f);
        return Unit.INSTANCE;
    }

    public static final long resolveInitialSelectedDateMillis(Date date, long j) {
        Long lValueOf = date != null ? Long.valueOf(DateExtensionsKt.toMidnightMillis$default(date, null, 1, null)) : null;
        return Math.max(lValueOf != null ? lValueOf.longValue() : j, j);
    }

    private static final DatePickerColors boxInlineDatePickerColors(Composer composer, int i) {
        ComposerKt.sourceInformationMarkerStart(composer, -2131216738, "C(boxInlineDatePickerColors)140@6019L6,141@6076L6,142@6131L6,143@6192L6,144@6255L6,145@6306L6,146@6364L6,147@6430L6,148@6505L6,149@6562L6,150@6620L6,151@6717L6,152@6779L6,153@6839L21,154@6950L6,155@7004L6,157@7108L6,158@7168L6,159@7227L6,160@7328L6,161@7391L6,162@7461L6,163@7530L6,164@7633L6,165@7698L6,166@7768L6,167@7837L6,168@7946L6,169@8008L6,170@8069L6,171@8180L6,172@8254L6,173@8327L6,174@8440L6,175@8498L6,156@7064L1461,139@5981L2546:BoxInlineDatePicker.kt#wc5a62");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-2131216738, i, -1, "com.box.android.base.compose.datepicker.boxInlineDatePickerColors (BoxInlineDatePicker.kt:139)");
        }
        DatePickerColors datePickerColorsM3152colorsbSRYm20 = DatePickerDefaults.INSTANCE.m3152colorsbSRYm20(BoxTheme.INSTANCE.getColors(composer, 6).m11516getDialogContainer0d7_KjU(), BoxTheme.INSTANCE.getColors(composer, 6).m11500getAppPrimary0d7_KjU(), BoxTheme.INSTANCE.getColors(composer, 6).m11533getMainActiveControl0d7_KjU(), BoxTheme.INSTANCE.getColors(composer, 6).m11513getContentSecondary0d7_KjU(), 0L, BoxTheme.INSTANCE.getColors(composer, 6).m11500getAppPrimary0d7_KjU(), BoxTheme.INSTANCE.getColors(composer, 6).m11500getAppPrimary0d7_KjU(), 0L, BoxTheme.INSTANCE.getColors(composer, 6).m11533getMainActiveControl0d7_KjU(), BoxTheme.INSTANCE.getColors(composer, 6).m11535getMainActiveControlContent0d7_KjU(), 0L, BoxTheme.INSTANCE.getColors(composer, 6).m11533getMainActiveControl0d7_KjU(), 0L, BoxTheme.INSTANCE.getColors(composer, 6).m11500getAppPrimary0d7_KjU(), Color.m6813copywmQWz5c$default(BoxTheme.INSTANCE.getColors(composer, 6).m11500getAppPrimary0d7_KjU(), 0.4f, 0.0f, 0.0f, 0.0f, 14, null), DarkThemeKt.isSystemInDarkTheme(composer, 0) ? BoxColorPalette.INSTANCE.m11364getBOX_GRAY_1000d7_KjU() : Color.INSTANCE.m6851getWhite0d7_KjU(), 0L, BoxTheme.INSTANCE.getColors(composer, 6).m11533getMainActiveControl0d7_KjU(), 0L, BoxTheme.INSTANCE.getColors(composer, 6).m11533getMainActiveControl0d7_KjU(), BoxTheme.INSTANCE.getColors(composer, 6).m11533getMainActiveControl0d7_KjU(), 0L, 0L, BoxTheme.INSTANCE.getColors(composer, 6).m11517getDivider0d7_KjU(), TextFieldDefaults.INSTANCE.m4466colors0hiis_0(BoxTheme.INSTANCE.getColors(composer, 6).m11572getTextFieldText0d7_KjU(), BoxTheme.INSTANCE.getColors(composer, 6).m11572getTextFieldText0d7_KjU(), Color.m6813copywmQWz5c$default(BoxTheme.INSTANCE.getColors(composer, 6).m11572getTextFieldText0d7_KjU(), 0.4f, 0.0f, 0.0f, 0.0f, 14, null), BoxTheme.INSTANCE.getColors(composer, 6).m11572getTextFieldText0d7_KjU(), BoxTheme.INSTANCE.getColors(composer, 6).m11561getTextFieldContainer0d7_KjU(), BoxTheme.INSTANCE.getColors(composer, 6).m11561getTextFieldContainer0d7_KjU(), Color.m6813copywmQWz5c$default(BoxTheme.INSTANCE.getColors(composer, 6).m11561getTextFieldContainer0d7_KjU(), 0.4f, 0.0f, 0.0f, 0.0f, 14, null), 0L, BoxTheme.INSTANCE.getColors(composer, 6).m11562getTextFieldCursor0d7_KjU(), 0L, null, BoxTheme.INSTANCE.getColors(composer, 6).m11564getTextFieldIndicator0d7_KjU(), BoxTheme.INSTANCE.getColors(composer, 6).m11564getTextFieldIndicator0d7_KjU(), Color.m6813copywmQWz5c$default(BoxTheme.INSTANCE.getColors(composer, 6).m11564getTextFieldIndicator0d7_KjU(), 0.4f, 0.0f, 0.0f, 0.0f, 14, null), BoxTheme.INSTANCE.getColors(composer, 6).m11563getTextFieldError0d7_KjU(), 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, BoxTheme.INSTANCE.getColors(composer, 6).m11565getTextFieldLabel0d7_KjU(), BoxTheme.INSTANCE.getColors(composer, 6).m11565getTextFieldLabel0d7_KjU(), Color.m6813copywmQWz5c$default(BoxTheme.INSTANCE.getColors(composer, 6).m11565getTextFieldLabel0d7_KjU(), 0.4f, 0.0f, 0.0f, 0.0f, 14, null), BoxTheme.INSTANCE.getColors(composer, 6).m11563getTextFieldError0d7_KjU(), BoxTheme.INSTANCE.getColors(composer, 6).m11566getTextFieldPlaceholder0d7_KjU(), BoxTheme.INSTANCE.getColors(composer, 6).m11566getTextFieldPlaceholder0d7_KjU(), Color.m6813copywmQWz5c$default(BoxTheme.INSTANCE.getColors(composer, 6).m11566getTextFieldPlaceholder0d7_KjU(), 0.4f, 0.0f, 0.0f, 0.0f, 14, null), 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composer, 0, 0, 0, 0, 3072, 1082099328, 4095), composer, 0, 0, ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE, 6624400);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return datePickerColorsM3152colorsbSRYm20;
    }

    private static final void BoxInlineDatePickerPreview(Composer composer, final int i) {
        Composer composerStartRestartGroup = composer.startRestartGroup(896580298);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(BoxInlineDatePickerPreview)183@8629L185:BoxInlineDatePicker.kt#wc5a62");
        if (!composerStartRestartGroup.shouldExecute(i != 0, i & 1)) {
            composerStartRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(896580298, i, -1, "com.box.android.base.compose.datepicker.BoxInlineDatePickerPreview (BoxInlineDatePicker.kt:182)");
            }
            BoxThemeKt.BoxTheme(ComposableSingletons$BoxInlineDatePickerKt.INSTANCE.m11699getLambda$668637601$base_generalProdRelease(), composerStartRestartGroup, 6);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.box.android.base.compose.datepicker.BoxInlineDatePickerKt$$ExternalSyntheticLambda5
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return BoxInlineDatePickerKt.BoxInlineDatePickerPreview$lambda$0(i, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    private static final void BoxInlineDatePickerWithDatePreview(Composer composer, final int i) {
        Composer composerStartRestartGroup = composer.startRestartGroup(-1043546218);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(BoxInlineDatePickerWithDatePreview)196@8894L283:BoxInlineDatePicker.kt#wc5a62");
        if (!composerStartRestartGroup.shouldExecute(i != 0, i & 1)) {
            composerStartRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1043546218, i, -1, "com.box.android.base.compose.datepicker.BoxInlineDatePickerWithDatePreview (BoxInlineDatePicker.kt:195)");
            }
            BoxThemeKt.BoxTheme(ComposableSingletons$BoxInlineDatePickerKt.INSTANCE.getLambda$1920665131$base_generalProdRelease(), composerStartRestartGroup, 6);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.box.android.base.compose.datepicker.BoxInlineDatePickerKt$$ExternalSyntheticLambda2
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return BoxInlineDatePickerKt.BoxInlineDatePickerWithDatePreview$lambda$0(i, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    private static final void BoxInlineDatePickerWithCustomStartDatePreview(Composer composer, final int i) {
        Composer composerStartRestartGroup = composer.startRestartGroup(291434965);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(BoxInlineDatePickerWithCustomStartDatePreview)211@9268L329:BoxInlineDatePicker.kt#wc5a62");
        if (!composerStartRestartGroup.shouldExecute(i != 0, i & 1)) {
            composerStartRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(291434965, i, -1, "com.box.android.base.compose.datepicker.BoxInlineDatePickerWithCustomStartDatePreview (BoxInlineDatePicker.kt:210)");
            }
            BoxThemeKt.BoxTheme(ComposableSingletons$BoxInlineDatePickerKt.INSTANCE.m11700getLambda$712102880$base_generalProdRelease(), composerStartRestartGroup, 6);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.box.android.base.compose.datepicker.BoxInlineDatePickerKt$$ExternalSyntheticLambda6
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return BoxInlineDatePickerKt.BoxInlineDatePickerWithCustomStartDatePreview$lambda$0(i, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }
}
