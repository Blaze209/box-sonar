package androidx.compose.material3;

import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.material3.internal.Icons;
import androidx.compose.material3.internal.Strings;
import androidx.compose.material3.internal.Strings_androidKt;
import androidx.compose.material3.tokens.DialogTokens;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.graphics.vector.ImageVector;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.unit.Dp;
import com.pspdfkit.internal.jni.NativeProcessorConfiguration;
import external.sdk.pendo.io.mozilla.javascript.Token;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;

/* JADX INFO: compiled from: TimePickerDialog.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J/\u0010\u0011\u001a\u00020\u00122\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00120\u00142\u0006\u0010\u0015\u001a\u00020\u00162\b\b\u0002\u0010\u0017\u001a\u00020\u0018H\u0007¢\u0006\u0004\b\u0019\u0010\u001aJ!\u0010\u001b\u001a\u00020\u00122\u0006\u0010\u0015\u001a\u00020\u00162\b\b\u0002\u0010\u0017\u001a\u00020\u0018H\u0007¢\u0006\u0004\b\u001c\u0010\u001dR\u0011\u0010\u0004\u001a\u00020\u00058G¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007R\u0011\u0010\b\u001a\u00020\t8G¢\u0006\u0006\u001a\u0004\b\n\u0010\u000bR\u0013\u0010\f\u001a\u00020\r¢\u0006\n\n\u0002\u0010\u0010\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u001e"}, d2 = {"Landroidx/compose/material3/TimePickerDialogDefaults;", "", "<init>", "()V", "containerColor", "Landroidx/compose/ui/graphics/Color;", "getContainerColor", "(Landroidx/compose/runtime/Composer;I)J", "shape", "Landroidx/compose/ui/graphics/Shape;", "getShape", "(Landroidx/compose/runtime/Composer;I)Landroidx/compose/ui/graphics/Shape;", "MinHeightForTimePicker", "Landroidx/compose/ui/unit/Dp;", "getMinHeightForTimePicker-D9Ej5fM", "()F", "F", "DisplayModeToggle", "", "onDisplayModeChange", "Lkotlin/Function0;", "displayMode", "Landroidx/compose/material3/TimePickerDisplayMode;", "modifier", "Landroidx/compose/ui/Modifier;", "DisplayModeToggle-S7Bxtbk", "(Lkotlin/jvm/functions/Function0;ILandroidx/compose/ui/Modifier;Landroidx/compose/runtime/Composer;II)V", NativeProcessorConfiguration.METADATA_TITLE, "Title-pK_nZyw", "(ILandroidx/compose/ui/Modifier;Landroidx/compose/runtime/Composer;II)V", "material3"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class TimePickerDialogDefaults {
    public static final int $stable = 0;
    public static final TimePickerDialogDefaults INSTANCE = new TimePickerDialogDefaults();
    private static final float MinHeightForTimePicker = Dp.m9687constructorimpl(300);

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit DisplayModeToggle_S7Bxtbk$lambda$2(TimePickerDialogDefaults timePickerDialogDefaults, Function0 function0, int i, Modifier modifier, int i2, int i3, Composer composer, int i4) {
        timePickerDialogDefaults.m4521DisplayModeToggleS7Bxtbk(function0, i, modifier, composer, RecomposeScopeImplKt.updateChangedFlags(i2 | 1), i3);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit Title_pK_nZyw$lambda$0(TimePickerDialogDefaults timePickerDialogDefaults, int i, Modifier modifier, int i2, int i3, Composer composer, int i4) {
        timePickerDialogDefaults.m4522TitlepK_nZyw(i, modifier, composer, RecomposeScopeImplKt.updateChangedFlags(i2 | 1), i3);
        return Unit.INSTANCE;
    }

    private TimePickerDialogDefaults() {
    }

    public final long getContainerColor(Composer composer, int i) {
        ComposerKt.sourceInformationMarkerStart(composer, -443775449, "C(<get-containerColor>)245@10341L5:TimePickerDialog.kt#uh7d8r");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-443775449, i, -1, "androidx.compose.material3.TimePickerDialogDefaults.<get-containerColor> (TimePickerDialog.kt:245)");
        }
        long value = ColorSchemeKt.getValue(DialogTokens.INSTANCE.getContainerColor(), composer, 6);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return value;
    }

    public final Shape getShape(Composer composer, int i) {
        ComposerKt.sourceInformationMarkerStart(composer, 1241096723, "C(<get-shape>)249@10464L5:TimePickerDialog.kt#uh7d8r");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1241096723, i, -1, "androidx.compose.material3.TimePickerDialogDefaults.<get-shape> (TimePickerDialog.kt:249)");
        }
        Shape value = ShapesKt.getValue(DialogTokens.INSTANCE.getContainerShape(), composer, 6);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return value;
    }

    /* JADX INFO: renamed from: getMinHeightForTimePicker-D9Ej5fM, reason: not valid java name */
    public final float m4523getMinHeightForTimePickerD9Ej5fM() {
        return MinHeightForTimePicker;
    }

    /* JADX WARN: Code duplicated, block: B:30:0x0058  */
    /* JADX WARN: Code duplicated, block: B:31:0x005a  */
    /* JADX WARN: Code duplicated, block: B:34:0x0063 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:35:0x0065  */
    /* JADX WARN: Code duplicated, block: B:36:0x006a  */
    /* JADX WARN: Code duplicated, block: B:39:0x0071  */
    /* JADX WARN: Code duplicated, block: B:42:0x0083  */
    /* JADX WARN: Code duplicated, block: B:43:0x008c  */
    /* JADX WARN: Code duplicated, block: B:46:0x00e8  */
    /* JADX WARN: Code duplicated, block: B:47:0x00ec  */
    /* JADX WARN: Code duplicated, block: B:50:0x00f6  */
    /* JADX WARN: Code duplicated, block: B:52:? A[RETURN, SYNTHETIC] */
    /* JADX INFO: renamed from: DisplayModeToggle-S7Bxtbk, reason: not valid java name */
    public final void m4521DisplayModeToggleS7Bxtbk(final Function0<Unit> function0, final int i, Modifier modifier, Composer composer, final int i2, final int i3) {
        int i4;
        Modifier modifier2;
        boolean z;
        final Modifier.Companion companion;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        int iM5002constructorimpl;
        Composer composerStartRestartGroup = composer.startRestartGroup(-1283607635);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(DisplayModeToggle)N(onDisplayModeChange,displayMode:c#material3.TimePickerDisplayMode,modifier)270@11234L237,279@11555L60,280@11639L45,281@11706L22,282@11740L429,277@11480L689:TimePickerDialog.kt#uh7d8r");
        if ((i2 & 6) == 0) {
            i4 = (composerStartRestartGroup.changedInstance(function0) ? 4 : 2) | i2;
        } else {
            i4 = i2;
        }
        if ((i2 & 48) == 0) {
            i4 |= composerStartRestartGroup.changed(i) ? 32 : 16;
        }
        int i5 = i3 & 4;
        if (i5 == 0) {
            if ((i2 & 384) == 0) {
                modifier2 = modifier;
                i4 |= composerStartRestartGroup.changed(modifier2) ? 256 : 128;
            }
            if ((i4 & Token.DOTQUERY) != 146) {
                z = true;
            } else {
                z = false;
            }
            if (composerStartRestartGroup.shouldExecute(z, i4 & 1)) {
                composerStartRestartGroup.skipToGroupEnd();
                companion = modifier2;
            } else {
                if (i5 != 0) {
                    companion = Modifier.INSTANCE;
                } else {
                    companion = modifier2;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-1283607635, i4, -1, "androidx.compose.material3.TimePickerDialogDefaults.DisplayModeToggle (TimePickerDialog.kt:268)");
                }
                if (TimePickerDisplayMode.m4531equalsimpl0(i, TimePickerDisplayMode.INSTANCE.m4536getPickerONbchU())) {
                    Strings.Companion companion2 = Strings.INSTANCE;
                    iM5002constructorimpl = Strings.m5002constructorimpl(R.string.m3c_time_picker_toggle_keyboard);
                } else {
                    Strings.Companion companion3 = Strings.INSTANCE;
                    iM5002constructorimpl = Strings.m5002constructorimpl(R.string.m3c_time_picker_toggle_touch);
                }
                final String strM5086getString2EP1pXo = Strings_androidKt.m5086getString2EP1pXo(iM5002constructorimpl, composerStartRestartGroup, 0);
                TooltipKt.TooltipBox(TooltipDefaults.INSTANCE.m4738rememberTooltipPositionProviderHu5FAss(TooltipAnchorPosition.INSTANCE.m4725getAbovelOKsHw4(), 0.0f, composerStartRestartGroup, 390, 2), ComposableLambdaKt.rememberComposableLambda(1379364888, true, new Function3() { // from class: androidx.compose.material3.TimePickerDialogDefaults$$ExternalSyntheticLambda2
                    @Override // kotlin.jvm.functions.Function3
                    public final Object invoke(Object obj, Object obj2, Object obj3) {
                        return TimePickerDialogDefaults.DisplayModeToggle_S7Bxtbk$lambda$0(strM5086getString2EP1pXo, (TooltipScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                    }
                }, composerStartRestartGroup, 54), TooltipKt.rememberTooltipState(false, false, null, composerStartRestartGroup, 0, 7), null, null, false, false, false, ComposableLambdaKt.rememberComposableLambda(1686719024, true, new Function2() { // from class: androidx.compose.material3.TimePickerDialogDefaults$$ExternalSyntheticLambda3
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return TimePickerDialogDefaults.DisplayModeToggle_S7Bxtbk$lambda$1(function0, companion, i, strM5086getString2EP1pXo, (Composer) obj, ((Integer) obj2).intValue());
                    }
                }, composerStartRestartGroup, 54), composerStartRestartGroup, 100663344, 248);
                composerStartRestartGroup = composerStartRestartGroup;
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
            }
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.TimePickerDialogDefaults$$ExternalSyntheticLambda4
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return TimePickerDialogDefaults.DisplayModeToggle_S7Bxtbk$lambda$2(this.f$0, function0, i, companion, i2, i3, (Composer) obj, ((Integer) obj2).intValue());
                    }
                });
            }
        }
        i4 |= 384;
        modifier2 = modifier;
        if ((i4 & Token.DOTQUERY) != 146) {
            z = true;
        } else {
            z = false;
        }
        if (composerStartRestartGroup.shouldExecute(z, i4 & 1)) {
            composerStartRestartGroup.skipToGroupEnd();
            companion = modifier2;
        } else {
            if (i5 != 0) {
                companion = Modifier.INSTANCE;
            } else {
                companion = modifier2;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1283607635, i4, -1, "androidx.compose.material3.TimePickerDialogDefaults.DisplayModeToggle (TimePickerDialog.kt:268)");
            }
            if (TimePickerDisplayMode.m4531equalsimpl0(i, TimePickerDisplayMode.INSTANCE.m4536getPickerONbchU())) {
                Strings.Companion companion4 = Strings.INSTANCE;
                iM5002constructorimpl = Strings.m5002constructorimpl(R.string.m3c_time_picker_toggle_keyboard);
            } else {
                Strings.Companion companion5 = Strings.INSTANCE;
                iM5002constructorimpl = Strings.m5002constructorimpl(R.string.m3c_time_picker_toggle_touch);
            }
            final String strM5086getString2EP1pXo2 = Strings_androidKt.m5086getString2EP1pXo(iM5002constructorimpl, composerStartRestartGroup, 0);
            TooltipKt.TooltipBox(TooltipDefaults.INSTANCE.m4738rememberTooltipPositionProviderHu5FAss(TooltipAnchorPosition.INSTANCE.m4725getAbovelOKsHw4(), 0.0f, composerStartRestartGroup, 390, 2), ComposableLambdaKt.rememberComposableLambda(1379364888, true, new Function3() { // from class: androidx.compose.material3.TimePickerDialogDefaults$$ExternalSyntheticLambda2
                @Override // kotlin.jvm.functions.Function3
                public final Object invoke(Object obj, Object obj2, Object obj3) {
                    return TimePickerDialogDefaults.DisplayModeToggle_S7Bxtbk$lambda$0(strM5086getString2EP1pXo2, (TooltipScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                }
            }, composerStartRestartGroup, 54), TooltipKt.rememberTooltipState(false, false, null, composerStartRestartGroup, 0, 7), null, null, false, false, false, ComposableLambdaKt.rememberComposableLambda(1686719024, true, new Function2() { // from class: androidx.compose.material3.TimePickerDialogDefaults$$ExternalSyntheticLambda3
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return TimePickerDialogDefaults.DisplayModeToggle_S7Bxtbk$lambda$1(function0, companion, i, strM5086getString2EP1pXo2, (Composer) obj, ((Integer) obj2).intValue());
                }
            }, composerStartRestartGroup, 54), composerStartRestartGroup, 100663344, 248);
            composerStartRestartGroup = composerStartRestartGroup;
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.TimePickerDialogDefaults$$ExternalSyntheticLambda4
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return TimePickerDialogDefaults.DisplayModeToggle_S7Bxtbk$lambda$2(this.f$0, function0, i, companion, i2, i3, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit DisplayModeToggle_S7Bxtbk$lambda$0(final String str, TooltipScope tooltipScope, Composer composer, int i) {
        int i2;
        ComposerKt.sourceInformation(composer, "C280@11654L28,280@11641L41:TimePickerDialog.kt#uh7d8r");
        if ((i & 6) == 0) {
            i2 = i | ((i & 8) == 0 ? composer.changed(tooltipScope) : composer.changedInstance(tooltipScope) ? 4 : 2);
        } else {
            i2 = i;
        }
        if (composer.shouldExecute((i2 & 19) != 18, i2 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1379364888, i2, -1, "androidx.compose.material3.TimePickerDialogDefaults.DisplayModeToggle.<anonymous> (TimePickerDialog.kt:280)");
            }
            TooltipKt.m4746PlainTooltipgv3ox5I(tooltipScope, null, null, 0.0f, null, 0L, 0L, 0.0f, 0.0f, ComposableLambdaKt.rememberComposableLambda(-1569697914, true, new Function2() { // from class: androidx.compose.material3.TimePickerDialogDefaults$$ExternalSyntheticLambda5
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return TimePickerDialogDefaults.DisplayModeToggle_S7Bxtbk$lambda$0$0(str, (Composer) obj, ((Integer) obj2).intValue());
                }
            }, composer, 54), composer, (i2 & 14) | 805306368, 255);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composer.skipToGroupEnd();
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit DisplayModeToggle_S7Bxtbk$lambda$0$0(String str, Composer composer, int i) {
        ComposerKt.sourceInformation(composer, "C280@11656L24:TimePickerDialog.kt#uh7d8r");
        if (composer.shouldExecute((i & 3) != 2, i & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1569697914, i, -1, "androidx.compose.material3.TimePickerDialogDefaults.DisplayModeToggle.<anonymous>.<anonymous> (TimePickerDialog.kt:280)");
            }
            TextKt.m4494TextNvy7gAk(str, null, 0L, null, 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, null, composer, 0, 0, 262142);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composer.skipToGroupEnd();
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit DisplayModeToggle_S7Bxtbk$lambda$1(Function0 function0, Modifier modifier, final int i, final String str, Composer composer, int i2) {
        ComposerKt.sourceInformation(composer, "C283@11817L342,283@11754L405:TimePickerDialog.kt#uh7d8r");
        if (!composer.shouldExecute((i2 & 3) != 2, i2 & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1686719024, i2, -1, "androidx.compose.material3.TimePickerDialogDefaults.DisplayModeToggle.<anonymous> (TimePickerDialog.kt:283)");
            }
            IconButtonKt.IconButton((Function0<Unit>) function0, modifier, false, (IconButtonColors) null, (MutableInteractionSource) null, (Shape) null, (Function2<? super Composer, ? super Integer, Unit>) ComposableLambdaKt.rememberComposableLambda(-174906670, true, new Function2() { // from class: androidx.compose.material3.TimePickerDialogDefaults$$ExternalSyntheticLambda1
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return TimePickerDialogDefaults.DisplayModeToggle_S7Bxtbk$lambda$1$0(i, str, (Composer) obj, ((Integer) obj2).intValue());
                }
            }, composer, 54), composer, 1572864, 60);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit DisplayModeToggle_S7Bxtbk$lambda$1$0(int i, String str, Composer composer, int i2) {
        ImageVector schedule;
        ComposerKt.sourceInformation(composer, "C290@12080L65:TimePickerDialog.kt#uh7d8r");
        if (!composer.shouldExecute((i2 & 3) != 2, i2 & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-174906670, i2, -1, "androidx.compose.material3.TimePickerDialogDefaults.DisplayModeToggle.<anonymous>.<anonymous> (TimePickerDialog.kt:284)");
            }
            if (TimePickerDisplayMode.m4531equalsimpl0(i, TimePickerDisplayMode.INSTANCE.m4536getPickerONbchU())) {
                schedule = Icons.Outlined.INSTANCE.getKeyboard();
            } else {
                schedule = Icons.Outlined.INSTANCE.getSchedule();
            }
            IconKt.m3576Iconww6aTOc(schedule, str, (Modifier) null, 0L, composer, 0, 12);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX WARN: Code duplicated, block: B:23:0x0045  */
    /* JADX WARN: Code duplicated, block: B:24:0x0047  */
    /* JADX WARN: Code duplicated, block: B:27:0x0050 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:28:0x0052  */
    /* JADX WARN: Code duplicated, block: B:29:0x0058  */
    /* JADX WARN: Code duplicated, block: B:32:0x005f  */
    /* JADX WARN: Code duplicated, block: B:35:0x008d  */
    /* JADX WARN: Code duplicated, block: B:36:0x0096  */
    /* JADX WARN: Code duplicated, block: B:39:0x00cd  */
    /* JADX WARN: Code duplicated, block: B:41:0x00d2  */
    /* JADX WARN: Code duplicated, block: B:44:0x00de  */
    /* JADX WARN: Code duplicated, block: B:46:? A[RETURN, SYNTHETIC] */
    /* JADX INFO: renamed from: Title-pK_nZyw, reason: not valid java name */
    public final void m4522TitlepK_nZyw(final int i, Modifier modifier, Composer composer, final int i2, final int i3) {
        int i4;
        Modifier modifier2;
        boolean z;
        Composer composer2;
        final Modifier modifier3;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        Modifier modifier4;
        int iM5002constructorimpl;
        Composer composerStartRestartGroup = composer.startRestartGroup(1546564986);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(Title)N(displayMode:c#material3.TimePickerDisplayMode,modifier)305@12584L10,307@12643L257,303@12487L424:TimePickerDialog.kt#uh7d8r");
        if ((i2 & 6) == 0) {
            i4 = i2 | (composerStartRestartGroup.changed(i) ? 4 : 2);
        } else {
            i4 = i2;
        }
        int i5 = i3 & 2;
        if (i5 == 0) {
            if ((i2 & 48) == 0) {
                modifier2 = modifier;
                i4 |= composerStartRestartGroup.changed(modifier2) ? 32 : 16;
            }
            if ((i4 & 19) != 18) {
                z = true;
            } else {
                z = false;
            }
            if (composerStartRestartGroup.shouldExecute(z, i4 & 1)) {
                composer2 = composerStartRestartGroup;
                composer2.skipToGroupEnd();
                modifier3 = modifier2;
            } else {
                if (i5 != 0) {
                    modifier4 = Modifier.INSTANCE;
                } else {
                    modifier4 = modifier2;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(1546564986, i4, -1, "androidx.compose.material3.TimePickerDialogDefaults.Title (TimePickerDialog.kt:302)");
                }
                Modifier modifierM1222paddingqDBjuR0$default = PaddingKt.m1222paddingqDBjuR0$default(modifier4, 0.0f, 0.0f, 0.0f, Dp.m9687constructorimpl(20), 7, null);
                Modifier modifier5 = modifier4;
                TextStyle labelMedium = MaterialTheme.INSTANCE.getTypography(composerStartRestartGroup, 6).getLabelMedium();
                if (TimePickerDisplayMode.m4531equalsimpl0(i, TimePickerDisplayMode.INSTANCE.m4536getPickerONbchU())) {
                    Strings.Companion companion = Strings.INSTANCE;
                    iM5002constructorimpl = Strings.m5002constructorimpl(R.string.m3c_time_picker_dialog_title);
                } else {
                    Strings.Companion companion2 = Strings.INSTANCE;
                    iM5002constructorimpl = Strings.m5002constructorimpl(R.string.m3c_time_input_dialog_title);
                }
                composer2 = composerStartRestartGroup;
                TextKt.m4494TextNvy7gAk(Strings_androidKt.m5086getString2EP1pXo(iM5002constructorimpl, composerStartRestartGroup, 0), modifierM1222paddingqDBjuR0$default, 0L, null, 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, labelMedium, composer2, 0, 0, 131068);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                modifier3 = modifier5;
            }
            scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.TimePickerDialogDefaults$$ExternalSyntheticLambda0
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return TimePickerDialogDefaults.Title_pK_nZyw$lambda$0(this.f$0, i, modifier3, i2, i3, (Composer) obj, ((Integer) obj2).intValue());
                    }
                });
            }
        }
        i4 |= 48;
        modifier2 = modifier;
        if ((i4 & 19) != 18) {
            z = true;
        } else {
            z = false;
        }
        if (composerStartRestartGroup.shouldExecute(z, i4 & 1)) {
            composer2 = composerStartRestartGroup;
            composer2.skipToGroupEnd();
            modifier3 = modifier2;
        } else {
            if (i5 != 0) {
                modifier4 = Modifier.INSTANCE;
            } else {
                modifier4 = modifier2;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1546564986, i4, -1, "androidx.compose.material3.TimePickerDialogDefaults.Title (TimePickerDialog.kt:302)");
            }
            Modifier modifierM1222paddingqDBjuR0$default2 = PaddingKt.m1222paddingqDBjuR0$default(modifier4, 0.0f, 0.0f, 0.0f, Dp.m9687constructorimpl(20), 7, null);
            Modifier modifier6 = modifier4;
            TextStyle labelMedium2 = MaterialTheme.INSTANCE.getTypography(composerStartRestartGroup, 6).getLabelMedium();
            if (TimePickerDisplayMode.m4531equalsimpl0(i, TimePickerDisplayMode.INSTANCE.m4536getPickerONbchU())) {
                Strings.Companion companion3 = Strings.INSTANCE;
                iM5002constructorimpl = Strings.m5002constructorimpl(R.string.m3c_time_picker_dialog_title);
            } else {
                Strings.Companion companion4 = Strings.INSTANCE;
                iM5002constructorimpl = Strings.m5002constructorimpl(R.string.m3c_time_input_dialog_title);
            }
            composer2 = composerStartRestartGroup;
            TextKt.m4494TextNvy7gAk(Strings_androidKt.m5086getString2EP1pXo(iM5002constructorimpl, composerStartRestartGroup, 0), modifierM1222paddingqDBjuR0$default2, 0L, null, 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, labelMedium2, composer2, 0, 0, 131068);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            modifier3 = modifier6;
        }
        scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.TimePickerDialogDefaults$$ExternalSyntheticLambda0
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return TimePickerDialogDefaults.Title_pK_nZyw$lambda$0(this.f$0, i, modifier3, i2, i3, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }
}
