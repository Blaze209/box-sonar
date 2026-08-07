package androidx.compose.material;

import androidx.compose.material.internal.Icons;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.ProvidableCompositionLocal;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.draw.RotateKt;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.semantics.SemanticsModifierKt;
import androidx.compose.ui.semantics.SemanticsPropertyReceiver;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;

/* JADX INFO: compiled from: ExposedDropdownMenu.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u001e\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J%\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u000e\b\u0002\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00050\tH\u0007¢\u0006\u0002\u0010\nJë\u0001\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010\r\u001a\u00020\u000e2\b\b\u0002\u0010\u000f\u001a\u00020\u000e2\b\b\u0002\u0010\u0010\u001a\u00020\u000e2\b\b\u0002\u0010\u0011\u001a\u00020\u000e2\b\b\u0002\u0010\u0012\u001a\u00020\u000e2\b\b\u0002\u0010\u0013\u001a\u00020\u000e2\b\b\u0002\u0010\u0014\u001a\u00020\u000e2\b\b\u0002\u0010\u0015\u001a\u00020\u000e2\b\b\u0002\u0010\u0016\u001a\u00020\u000e2\b\b\u0002\u0010\u0017\u001a\u00020\u000e2\b\b\u0002\u0010\u0018\u001a\u00020\u000e2\b\b\u0002\u0010\u0019\u001a\u00020\u000e2\b\b\u0002\u0010\u001a\u001a\u00020\u000e2\b\b\u0002\u0010\u001b\u001a\u00020\u000e2\b\b\u0002\u0010\u001c\u001a\u00020\u000e2\b\b\u0002\u0010\u001d\u001a\u00020\u000e2\b\b\u0002\u0010\u001e\u001a\u00020\u000e2\b\b\u0002\u0010\u001f\u001a\u00020\u000e2\b\b\u0002\u0010 \u001a\u00020\u000e2\b\b\u0002\u0010!\u001a\u00020\u000e2\b\b\u0002\u0010\"\u001a\u00020\u000e2\b\b\u0002\u0010#\u001a\u00020\u000eH\u0007¢\u0006\u0004\b$\u0010%Jë\u0001\u0010&\u001a\u00020\f2\b\b\u0002\u0010\r\u001a\u00020\u000e2\b\b\u0002\u0010\u000f\u001a\u00020\u000e2\b\b\u0002\u0010\u0010\u001a\u00020\u000e2\b\b\u0002\u0010\u0011\u001a\u00020\u000e2\b\b\u0002\u0010\u0012\u001a\u00020\u000e2\b\b\u0002\u0010'\u001a\u00020\u000e2\b\b\u0002\u0010(\u001a\u00020\u000e2\b\b\u0002\u0010)\u001a\u00020\u000e2\b\b\u0002\u0010*\u001a\u00020\u000e2\b\b\u0002\u0010\u0017\u001a\u00020\u000e2\b\b\u0002\u0010\u0018\u001a\u00020\u000e2\b\b\u0002\u0010\u0019\u001a\u00020\u000e2\b\b\u0002\u0010\u001a\u001a\u00020\u000e2\b\b\u0002\u0010\u001b\u001a\u00020\u000e2\b\b\u0002\u0010\u001c\u001a\u00020\u000e2\b\b\u0002\u0010\u001d\u001a\u00020\u000e2\b\b\u0002\u0010\u001e\u001a\u00020\u000e2\b\b\u0002\u0010\u001f\u001a\u00020\u000e2\b\b\u0002\u0010 \u001a\u00020\u000e2\b\b\u0002\u0010!\u001a\u00020\u000e2\b\b\u0002\u0010\"\u001a\u00020\u000e2\b\b\u0002\u0010#\u001a\u00020\u000eH\u0007¢\u0006\u0004\b+\u0010%¨\u0006,"}, d2 = {"Landroidx/compose/material/ExposedDropdownMenuDefaults;", "", "<init>", "()V", "TrailingIcon", "", "expanded", "", "onIconClick", "Lkotlin/Function0;", "(ZLkotlin/jvm/functions/Function0;Landroidx/compose/runtime/Composer;II)V", "textFieldColors", "Landroidx/compose/material/TextFieldColors;", "textColor", "Landroidx/compose/ui/graphics/Color;", "disabledTextColor", "backgroundColor", "cursorColor", "errorCursorColor", "focusedIndicatorColor", "unfocusedIndicatorColor", "disabledIndicatorColor", "errorIndicatorColor", "leadingIconColor", "disabledLeadingIconColor", "errorLeadingIconColor", "trailingIconColor", "focusedTrailingIconColor", "disabledTrailingIconColor", "errorTrailingIconColor", "focusedLabelColor", "unfocusedLabelColor", "disabledLabelColor", "errorLabelColor", "placeholderColor", "disabledPlaceholderColor", "textFieldColors-DlUQjxs", "(JJJJJJJJJJJJJJJJJJJJJJLandroidx/compose/runtime/Composer;IIII)Landroidx/compose/material/TextFieldColors;", "outlinedTextFieldColors", "focusedBorderColor", "unfocusedBorderColor", "disabledBorderColor", "errorBorderColor", "outlinedTextFieldColors-DlUQjxs", "material"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class ExposedDropdownMenuDefaults {
    public static final int $stable = 0;
    public static final ExposedDropdownMenuDefaults INSTANCE = new ExposedDropdownMenuDefaults();

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit TrailingIcon$lambda$3(ExposedDropdownMenuDefaults exposedDropdownMenuDefaults, boolean z, Function0 function0, int i, int i2, Composer composer, int i3) {
        exposedDropdownMenuDefaults.TrailingIcon(z, function0, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    private ExposedDropdownMenuDefaults() {
    }

    public final void TrailingIcon(final boolean z, Function0<Unit> function0, Composer composer, final int i, final int i2) {
        int i3;
        final Function0<Unit> function1;
        Composer composerStartRestartGroup = composer.startRestartGroup(876077373);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(TrailingIcon)N(expanded,onIconClick)235@9845L2,240@10231L2,240@10235L209,240@10156L288:ExposedDropdownMenu.kt#jmzs0o");
        if ((i & 6) == 0) {
            i3 = (composerStartRestartGroup.changed(z) ? 4 : 2) | i;
        } else {
            i3 = i;
        }
        int i4 = i2 & 2;
        if (i4 != 0) {
            i3 |= 48;
        } else if ((i & 48) == 0) {
            i3 |= composerStartRestartGroup.changedInstance(function0) ? 32 : 16;
        }
        if (!composerStartRestartGroup.shouldExecute((i3 & 19) != 18, i3 & 1)) {
            composerStartRestartGroup.skipToGroupEnd();
            function1 = function0;
        } else {
            if (i4 != 0) {
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 96767423, "CC(remember):ExposedDropdownMenu.kt#9igjgp");
                Object objRememberedValue = composerStartRestartGroup.rememberedValue();
                if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue = new Function0() { // from class: androidx.compose.material.ExposedDropdownMenuDefaults$$ExternalSyntheticLambda0
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            return Unit.INSTANCE;
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                }
                function1 = (Function0) objRememberedValue;
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            } else {
                function1 = function0;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(876077373, i3, -1, "androidx.compose.material.ExposedDropdownMenuDefaults.TrailingIcon (ExposedDropdownMenu.kt:235)");
            }
            Modifier.Companion companion = Modifier.INSTANCE;
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 96779775, "CC(remember):ExposedDropdownMenu.kt#9igjgp");
            Object objRememberedValue2 = composerStartRestartGroup.rememberedValue();
            if (objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                objRememberedValue2 = new Function1() { // from class: androidx.compose.material.ExposedDropdownMenuDefaults$$ExternalSyntheticLambda1
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return ExposedDropdownMenuDefaults.TrailingIcon$lambda$1$0((SemanticsPropertyReceiver) obj);
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
            }
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            IconButtonKt.IconButton(function1, SemanticsModifierKt.clearAndSetSemantics(companion, (Function1) objRememberedValue2), false, null, ComposableLambdaKt.rememberComposableLambda(726122713, true, new Function2() { // from class: androidx.compose.material.ExposedDropdownMenuDefaults$$ExternalSyntheticLambda2
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return ExposedDropdownMenuDefaults.TrailingIcon$lambda$2(z, (Composer) obj, ((Integer) obj2).intValue());
                }
            }, composerStartRestartGroup, 54), composerStartRestartGroup, ((i3 >> 3) & 14) | 24576, 12);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material.ExposedDropdownMenuDefaults$$ExternalSyntheticLambda3
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return ExposedDropdownMenuDefaults.TrailingIcon$lambda$3(this.f$0, z, function1, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit TrailingIcon$lambda$1$0(SemanticsPropertyReceiver semanticsPropertyReceiver) {
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit TrailingIcon$lambda$2(boolean z, Composer composer, int i) {
        ComposerKt.sourceInformation(composer, "C241@10249L185:ExposedDropdownMenu.kt#jmzs0o");
        if (!composer.shouldExecute((i & 3) != 2, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(726122713, i, -1, "androidx.compose.material.ExposedDropdownMenuDefaults.TrailingIcon.<anonymous> (ExposedDropdownMenu.kt:241)");
            }
            IconKt.m2440Iconww6aTOc(Icons.Filled.INSTANCE.getArrowDropDown$material(), "Trailing icon for exposed dropdown menu", RotateKt.rotate(Modifier.INSTANCE, z ? 180.0f : 360.0f), 0L, composer, 48, 8);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: renamed from: textFieldColors-DlUQjxs, reason: not valid java name */
    public final TextFieldColors m2411textFieldColorsDlUQjxs(long j, long j2, long j3, long j4, long j5, long j6, long j7, long j8, long j9, long j10, long j11, long j12, long j13, long j14, long j15, long j16, long j17, long j18, long j19, long j20, long j21, long j22, Composer composer, int i, int i2, int i3, int i4) {
        long jM6813copywmQWz5c$default;
        long j23;
        long jM6813copywmQWz5c$default2;
        long j24;
        long jM6813copywmQWz5c$default3;
        long j25;
        long jM6813copywmQWz5c$default4;
        long j26;
        long jM6813copywmQWz5c$default5;
        long jM6813copywmQWz5c$default6;
        ComposerKt.sourceInformationMarkerStart(composer, 1208167904, "C(textFieldColors)N(textColor:c#ui.graphics.Color,disabledTextColor:c#ui.graphics.Color,backgroundColor:c#ui.graphics.Color,cursorColor:c#ui.graphics.Color,errorCursorColor:c#ui.graphics.Color,focusedIndicatorColor:c#ui.graphics.Color,unfocusedIndicatorColor:c#ui.graphics.Color,disabledIndicatorColor:c#ui.graphics.Color,errorIndicatorColor:c#ui.graphics.Color,leadingIconColor:c#ui.graphics.Color,disabledLeadingIconColor:c#ui.graphics.Color,errorLeadingIconColor:c#ui.graphics.Color,trailingIconColor:c#ui.graphics.Color,focusedTrailingIconColor:c#ui.graphics.Color,disabledTrailingIconColor:c#ui.graphics.Color,errorTrailingIconColor:c#ui.graphics.Color,focusedLabelColor:c#ui.graphics.Color,unfocusedLabelColor:c#ui.graphics.Color,disabledLabelColor:c#ui.graphics.Color,errorLabelColor:c#ui.graphics.Color,placeholderColor:c#ui.graphics.Color,disabledPlaceholderColor:c#ui.graphics.Color)292@13137L7,292@13168L7,293@13241L8,295@13311L6,296@13422L6,297@13486L6,298@13553L6,298@13594L4,300@13668L6,303@13868L8,304@13930L6,306@14004L6,307@14151L8,310@14280L6,312@14410L6,312@14451L4,313@14545L8,314@14610L6,315@14673L6,315@14714L4,316@14772L6,316@14807L6,317@14890L8,318@14948L6,319@15010L6,319@15045L6,320@15131L8:ExposedDropdownMenu.kt#jmzs0o");
        if ((i4 & 1) != 0) {
            ProvidableCompositionLocal<Color> localContentColor = ContentColorKt.getLocalContentColor();
            ComposerKt.sourceInformationMarkerStart(composer, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
            Object objConsume = composer.consume(localContentColor);
            ComposerKt.sourceInformationMarkerEnd(composer);
            long jM6824unboximpl = ((Color) objConsume).m6824unboximpl();
            ProvidableCompositionLocal<Float> localContentAlpha = ContentAlphaKt.getLocalContentAlpha();
            ComposerKt.sourceInformationMarkerStart(composer, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
            Object objConsume2 = composer.consume(localContentAlpha);
            ComposerKt.sourceInformationMarkerEnd(composer);
            jM6813copywmQWz5c$default = Color.m6813copywmQWz5c$default(jM6824unboximpl, ((Number) objConsume2).floatValue(), 0.0f, 0.0f, 0.0f, 14, null);
        } else {
            jM6813copywmQWz5c$default = j;
        }
        long jM6813copywmQWz5c$default7 = (i4 & 2) != 0 ? Color.m6813copywmQWz5c$default(jM6813copywmQWz5c$default, ContentAlpha.INSTANCE.getDisabled(composer, 6), 0.0f, 0.0f, 0.0f, 14, null) : j2;
        long jM6813copywmQWz5c$default8 = (i4 & 4) != 0 ? Color.m6813copywmQWz5c$default(MaterialTheme.INSTANCE.getColors(composer, 6).m2341getOnSurface0d7_KjU(), 0.12f, 0.0f, 0.0f, 0.0f, 14, null) : j3;
        long jM2342getPrimary0d7_KjU = (i4 & 8) != 0 ? MaterialTheme.INSTANCE.getColors(composer, 6).m2342getPrimary0d7_KjU() : j4;
        long jM2336getError0d7_KjU = (i4 & 16) != 0 ? MaterialTheme.INSTANCE.getColors(composer, 6).m2336getError0d7_KjU() : j5;
        long jM6813copywmQWz5c$default9 = (i4 & 32) != 0 ? Color.m6813copywmQWz5c$default(MaterialTheme.INSTANCE.getColors(composer, 6).m2342getPrimary0d7_KjU(), ContentAlpha.INSTANCE.getHigh(composer, 6), 0.0f, 0.0f, 0.0f, 14, null) : j6;
        long jM6813copywmQWz5c$default10 = (i4 & 64) != 0 ? Color.m6813copywmQWz5c$default(MaterialTheme.INSTANCE.getColors(composer, 6).m2341getOnSurface0d7_KjU(), 0.42f, 0.0f, 0.0f, 0.0f, 14, null) : j7;
        if ((i4 & 128) != 0) {
            long j27 = jM6813copywmQWz5c$default10;
            j23 = j27;
            jM6813copywmQWz5c$default2 = Color.m6813copywmQWz5c$default(j27, ContentAlpha.INSTANCE.getDisabled(composer, 6), 0.0f, 0.0f, 0.0f, 14, null);
        } else {
            j23 = jM6813copywmQWz5c$default10;
            jM6813copywmQWz5c$default2 = j8;
        }
        long jM2336getError0d7_KjU2 = (i4 & 256) != 0 ? MaterialTheme.INSTANCE.getColors(composer, 6).m2336getError0d7_KjU() : j9;
        long jM6813copywmQWz5c$default11 = (i4 & 512) != 0 ? Color.m6813copywmQWz5c$default(MaterialTheme.INSTANCE.getColors(composer, 6).m2341getOnSurface0d7_KjU(), 0.54f, 0.0f, 0.0f, 0.0f, 14, null) : j10;
        if ((i4 & 1024) != 0) {
            long j28 = jM6813copywmQWz5c$default11;
            jM6813copywmQWz5c$default3 = Color.m6813copywmQWz5c$default(j28, ContentAlpha.INSTANCE.getDisabled(composer, 6), 0.0f, 0.0f, 0.0f, 14, null);
            j24 = j28;
        } else {
            j24 = jM6813copywmQWz5c$default11;
            jM6813copywmQWz5c$default3 = j11;
        }
        long j29 = (i4 & 2048) != 0 ? j24 : j12;
        long jM6813copywmQWz5c$default12 = (i4 & 4096) != 0 ? Color.m6813copywmQWz5c$default(MaterialTheme.INSTANCE.getColors(composer, 6).m2341getOnSurface0d7_KjU(), 0.54f, 0.0f, 0.0f, 0.0f, 14, null) : j13;
        long jM6813copywmQWz5c$default13 = (i4 & 8192) != 0 ? Color.m6813copywmQWz5c$default(MaterialTheme.INSTANCE.getColors(composer, 6).m2342getPrimary0d7_KjU(), ContentAlpha.INSTANCE.getHigh(composer, 6), 0.0f, 0.0f, 0.0f, 14, null) : j14;
        if ((i4 & 16384) != 0) {
            long j30 = jM6813copywmQWz5c$default12;
            jM6813copywmQWz5c$default4 = Color.m6813copywmQWz5c$default(j30, ContentAlpha.INSTANCE.getDisabled(composer, 6), 0.0f, 0.0f, 0.0f, 14, null);
            j25 = j30;
        } else {
            j25 = jM6813copywmQWz5c$default12;
            jM6813copywmQWz5c$default4 = j15;
        }
        long jM2336getError0d7_KjU3 = (32768 & i4) != 0 ? MaterialTheme.INSTANCE.getColors(composer, 6).m2336getError0d7_KjU() : j16;
        long jM6813copywmQWz5c$default14 = (65536 & i4) != 0 ? Color.m6813copywmQWz5c$default(MaterialTheme.INSTANCE.getColors(composer, 6).m2342getPrimary0d7_KjU(), ContentAlpha.INSTANCE.getHigh(composer, 6), 0.0f, 0.0f, 0.0f, 14, null) : j17;
        long jM6813copywmQWz5c$default15 = (131072 & i4) != 0 ? Color.m6813copywmQWz5c$default(MaterialTheme.INSTANCE.getColors(composer, 6).m2341getOnSurface0d7_KjU(), ContentAlpha.INSTANCE.getMedium(composer, 6), 0.0f, 0.0f, 0.0f, 14, null) : j18;
        if ((262144 & i4) != 0) {
            long j31 = jM6813copywmQWz5c$default15;
            jM6813copywmQWz5c$default5 = Color.m6813copywmQWz5c$default(j31, ContentAlpha.INSTANCE.getDisabled(composer, 6), 0.0f, 0.0f, 0.0f, 14, null);
            j26 = j31;
        } else {
            j26 = jM6813copywmQWz5c$default15;
            jM6813copywmQWz5c$default5 = j19;
        }
        long jM2336getError0d7_KjU4 = (524288 & i4) != 0 ? MaterialTheme.INSTANCE.getColors(composer, 6).m2336getError0d7_KjU() : j20;
        long jM6813copywmQWz5c$default16 = (1048576 & i4) != 0 ? Color.m6813copywmQWz5c$default(MaterialTheme.INSTANCE.getColors(composer, 6).m2341getOnSurface0d7_KjU(), ContentAlpha.INSTANCE.getMedium(composer, 6), 0.0f, 0.0f, 0.0f, 14, null) : j21;
        if ((i4 & 2097152) != 0) {
            jM6813copywmQWz5c$default6 = Color.m6813copywmQWz5c$default(jM6813copywmQWz5c$default16, ContentAlpha.INSTANCE.getDisabled(composer, 6), 0.0f, 0.0f, 0.0f, 14, null);
        } else {
            jM6813copywmQWz5c$default6 = j22;
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1208167904, i, i2, "androidx.compose.material.ExposedDropdownMenuDefaults.textFieldColors (ExposedDropdownMenu.kt:322)");
        }
        DefaultTextFieldForExposedDropdownMenusColors defaultTextFieldForExposedDropdownMenusColors = new DefaultTextFieldForExposedDropdownMenusColors(jM6813copywmQWz5c$default, jM6813copywmQWz5c$default7, jM2342getPrimary0d7_KjU, jM2336getError0d7_KjU, jM6813copywmQWz5c$default9, j23, jM2336getError0d7_KjU2, jM6813copywmQWz5c$default2, j24, jM6813copywmQWz5c$default3, j29, j25, jM6813copywmQWz5c$default13, jM6813copywmQWz5c$default4, jM2336getError0d7_KjU3, jM6813copywmQWz5c$default8, jM6813copywmQWz5c$default14, j26, jM6813copywmQWz5c$default5, jM2336getError0d7_KjU4, jM6813copywmQWz5c$default16, jM6813copywmQWz5c$default6, null);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return defaultTextFieldForExposedDropdownMenusColors;
    }

    /* JADX INFO: renamed from: outlinedTextFieldColors-DlUQjxs, reason: not valid java name */
    public final TextFieldColors m2410outlinedTextFieldColorsDlUQjxs(long j, long j2, long j3, long j4, long j5, long j6, long j7, long j8, long j9, long j10, long j11, long j12, long j13, long j14, long j15, long j16, long j17, long j18, long j19, long j20, long j21, long j22, Composer composer, int i, int i2, int i3, int i4) {
        long jM6813copywmQWz5c$default;
        long j23;
        long jM6813copywmQWz5c$default2;
        long j24;
        long jM6813copywmQWz5c$default3;
        long j25;
        long jM6813copywmQWz5c$default4;
        long j26;
        long jM6813copywmQWz5c$default5;
        long jM6813copywmQWz5c$default6;
        ComposerKt.sourceInformationMarkerStart(composer, 1162641182, "C(outlinedTextFieldColors)N(textColor:c#ui.graphics.Color,disabledTextColor:c#ui.graphics.Color,backgroundColor:c#ui.graphics.Color,cursorColor:c#ui.graphics.Color,errorCursorColor:c#ui.graphics.Color,focusedBorderColor:c#ui.graphics.Color,unfocusedBorderColor:c#ui.graphics.Color,disabledBorderColor:c#ui.graphics.Color,errorBorderColor:c#ui.graphics.Color,leadingIconColor:c#ui.graphics.Color,disabledLeadingIconColor:c#ui.graphics.Color,errorLeadingIconColor:c#ui.graphics.Color,trailingIconColor:c#ui.graphics.Color,focusedTrailingIconColor:c#ui.graphics.Color,disabledTrailingIconColor:c#ui.graphics.Color,errorTrailingIconColor:c#ui.graphics.Color,focusedLabelColor:c#ui.graphics.Color,unfocusedLabelColor:c#ui.graphics.Color,disabledLabelColor:c#ui.graphics.Color,errorLabelColor:c#ui.graphics.Color,placeholderColor:c#ui.graphics.Color,disabledPlaceholderColor:c#ui.graphics.Color)390@19105L7,390@19136L7,391@19209L8,393@19315L6,394@19379L6,395@19443L6,395@19484L4,397@19555L6,397@19598L8,398@19693L8,399@19752L6,401@19826L6,402@19973L8,405@20102L6,407@20232L6,407@20273L4,408@20367L8,409@20432L6,410@20495L6,410@20536L4,411@20594L6,411@20629L6,412@20712L8,413@20770L6,414@20832L6,414@20867L6,415@20953L8:ExposedDropdownMenu.kt#jmzs0o");
        if ((i4 & 1) != 0) {
            ProvidableCompositionLocal<Color> localContentColor = ContentColorKt.getLocalContentColor();
            ComposerKt.sourceInformationMarkerStart(composer, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
            Object objConsume = composer.consume(localContentColor);
            ComposerKt.sourceInformationMarkerEnd(composer);
            long jM6824unboximpl = ((Color) objConsume).m6824unboximpl();
            ProvidableCompositionLocal<Float> localContentAlpha = ContentAlphaKt.getLocalContentAlpha();
            ComposerKt.sourceInformationMarkerStart(composer, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
            Object objConsume2 = composer.consume(localContentAlpha);
            ComposerKt.sourceInformationMarkerEnd(composer);
            jM6813copywmQWz5c$default = Color.m6813copywmQWz5c$default(jM6824unboximpl, ((Number) objConsume2).floatValue(), 0.0f, 0.0f, 0.0f, 14, null);
        } else {
            jM6813copywmQWz5c$default = j;
        }
        long jM6813copywmQWz5c$default7 = (i4 & 2) != 0 ? Color.m6813copywmQWz5c$default(jM6813copywmQWz5c$default, ContentAlpha.INSTANCE.getDisabled(composer, 6), 0.0f, 0.0f, 0.0f, 14, null) : j2;
        long jM6849getTransparent0d7_KjU = (i4 & 4) != 0 ? Color.INSTANCE.m6849getTransparent0d7_KjU() : j3;
        long jM2342getPrimary0d7_KjU = (i4 & 8) != 0 ? MaterialTheme.INSTANCE.getColors(composer, 6).m2342getPrimary0d7_KjU() : j4;
        long jM2336getError0d7_KjU = (i4 & 16) != 0 ? MaterialTheme.INSTANCE.getColors(composer, 6).m2336getError0d7_KjU() : j5;
        long jM6813copywmQWz5c$default8 = (i4 & 32) != 0 ? Color.m6813copywmQWz5c$default(MaterialTheme.INSTANCE.getColors(composer, 6).m2342getPrimary0d7_KjU(), ContentAlpha.INSTANCE.getHigh(composer, 6), 0.0f, 0.0f, 0.0f, 14, null) : j6;
        long jM6813copywmQWz5c$default9 = (i4 & 64) != 0 ? Color.m6813copywmQWz5c$default(MaterialTheme.INSTANCE.getColors(composer, 6).m2341getOnSurface0d7_KjU(), ContentAlpha.INSTANCE.getDisabled(composer, 6), 0.0f, 0.0f, 0.0f, 14, null) : j7;
        if ((i4 & 128) != 0) {
            long j27 = jM6813copywmQWz5c$default9;
            j23 = j27;
            jM6813copywmQWz5c$default2 = Color.m6813copywmQWz5c$default(j27, ContentAlpha.INSTANCE.getDisabled(composer, 6), 0.0f, 0.0f, 0.0f, 14, null);
        } else {
            j23 = jM6813copywmQWz5c$default9;
            jM6813copywmQWz5c$default2 = j8;
        }
        long jM2336getError0d7_KjU2 = (i4 & 256) != 0 ? MaterialTheme.INSTANCE.getColors(composer, 6).m2336getError0d7_KjU() : j9;
        long jM6813copywmQWz5c$default10 = (i4 & 512) != 0 ? Color.m6813copywmQWz5c$default(MaterialTheme.INSTANCE.getColors(composer, 6).m2341getOnSurface0d7_KjU(), 0.54f, 0.0f, 0.0f, 0.0f, 14, null) : j10;
        if ((i4 & 1024) != 0) {
            long j28 = jM6813copywmQWz5c$default10;
            jM6813copywmQWz5c$default3 = Color.m6813copywmQWz5c$default(j28, ContentAlpha.INSTANCE.getDisabled(composer, 6), 0.0f, 0.0f, 0.0f, 14, null);
            j24 = j28;
        } else {
            j24 = jM6813copywmQWz5c$default10;
            jM6813copywmQWz5c$default3 = j11;
        }
        long j29 = (i4 & 2048) != 0 ? j24 : j12;
        long jM6813copywmQWz5c$default11 = (i4 & 4096) != 0 ? Color.m6813copywmQWz5c$default(MaterialTheme.INSTANCE.getColors(composer, 6).m2341getOnSurface0d7_KjU(), 0.54f, 0.0f, 0.0f, 0.0f, 14, null) : j13;
        long jM6813copywmQWz5c$default12 = (i4 & 8192) != 0 ? Color.m6813copywmQWz5c$default(MaterialTheme.INSTANCE.getColors(composer, 6).m2342getPrimary0d7_KjU(), ContentAlpha.INSTANCE.getHigh(composer, 6), 0.0f, 0.0f, 0.0f, 14, null) : j14;
        if ((i4 & 16384) != 0) {
            long j30 = jM6813copywmQWz5c$default11;
            jM6813copywmQWz5c$default4 = Color.m6813copywmQWz5c$default(j30, ContentAlpha.INSTANCE.getDisabled(composer, 6), 0.0f, 0.0f, 0.0f, 14, null);
            j25 = j30;
        } else {
            j25 = jM6813copywmQWz5c$default11;
            jM6813copywmQWz5c$default4 = j15;
        }
        long jM2336getError0d7_KjU3 = (32768 & i4) != 0 ? MaterialTheme.INSTANCE.getColors(composer, 6).m2336getError0d7_KjU() : j16;
        long jM6813copywmQWz5c$default13 = (65536 & i4) != 0 ? Color.m6813copywmQWz5c$default(MaterialTheme.INSTANCE.getColors(composer, 6).m2342getPrimary0d7_KjU(), ContentAlpha.INSTANCE.getHigh(composer, 6), 0.0f, 0.0f, 0.0f, 14, null) : j17;
        long jM6813copywmQWz5c$default14 = (131072 & i4) != 0 ? Color.m6813copywmQWz5c$default(MaterialTheme.INSTANCE.getColors(composer, 6).m2341getOnSurface0d7_KjU(), ContentAlpha.INSTANCE.getMedium(composer, 6), 0.0f, 0.0f, 0.0f, 14, null) : j18;
        if ((262144 & i4) != 0) {
            long j31 = jM6813copywmQWz5c$default14;
            jM6813copywmQWz5c$default5 = Color.m6813copywmQWz5c$default(j31, ContentAlpha.INSTANCE.getDisabled(composer, 6), 0.0f, 0.0f, 0.0f, 14, null);
            j26 = j31;
        } else {
            j26 = jM6813copywmQWz5c$default14;
            jM6813copywmQWz5c$default5 = j19;
        }
        long jM2336getError0d7_KjU4 = (524288 & i4) != 0 ? MaterialTheme.INSTANCE.getColors(composer, 6).m2336getError0d7_KjU() : j20;
        long jM6813copywmQWz5c$default15 = (1048576 & i4) != 0 ? Color.m6813copywmQWz5c$default(MaterialTheme.INSTANCE.getColors(composer, 6).m2341getOnSurface0d7_KjU(), ContentAlpha.INSTANCE.getMedium(composer, 6), 0.0f, 0.0f, 0.0f, 14, null) : j21;
        if ((i4 & 2097152) != 0) {
            jM6813copywmQWz5c$default6 = Color.m6813copywmQWz5c$default(jM6813copywmQWz5c$default15, ContentAlpha.INSTANCE.getDisabled(composer, 6), 0.0f, 0.0f, 0.0f, 14, null);
        } else {
            jM6813copywmQWz5c$default6 = j22;
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1162641182, i, i2, "androidx.compose.material.ExposedDropdownMenuDefaults.outlinedTextFieldColors (ExposedDropdownMenu.kt:417)");
        }
        DefaultTextFieldForExposedDropdownMenusColors defaultTextFieldForExposedDropdownMenusColors = new DefaultTextFieldForExposedDropdownMenusColors(jM6813copywmQWz5c$default, jM6813copywmQWz5c$default7, jM2342getPrimary0d7_KjU, jM2336getError0d7_KjU, jM6813copywmQWz5c$default8, j23, jM2336getError0d7_KjU2, jM6813copywmQWz5c$default2, j24, jM6813copywmQWz5c$default3, j29, j25, jM6813copywmQWz5c$default12, jM6813copywmQWz5c$default4, jM2336getError0d7_KjU3, jM6849getTransparent0d7_KjU, jM6813copywmQWz5c$default13, j26, jM6813copywmQWz5c$default5, jM2336getError0d7_KjU4, jM6813copywmQWz5c$default15, jM6813copywmQWz5c$default6, null);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return defaultTextFieldForExposedDropdownMenusColors;
    }
}
