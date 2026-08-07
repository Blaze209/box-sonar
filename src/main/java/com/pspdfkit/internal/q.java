package com.pspdfkit.internal;

import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.RowKt;
import androidx.compose.foundation.layout.RowScope;
import androidx.compose.foundation.layout.RowScopeInstance;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.layout.WindowInsetsPadding_androidKt;
import androidx.compose.foundation.shape.RoundedCornerShape;
import androidx.compose.foundation.shape.RoundedCornerShapeKt;
import androidx.compose.foundation.text.KeyboardActions;
import androidx.compose.foundation.text.KeyboardOptions;
import androidx.compose.material3.IconButtonColors;
import androidx.compose.material3.IconButtonKt;
import androidx.compose.material3.IconKt;
import androidx.compose.material3.MaterialTheme;
import androidx.compose.material3.TextFieldDefaults;
import androidx.compose.material3.TextFieldKt;
import androidx.compose.material3.TextKt;
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
import androidx.compose.ui.draw.ClipKt;
import androidx.compose.ui.focus.FocusRequester;
import androidx.compose.ui.focus.FocusRequesterModifierKt;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.graphics.painter.Painter;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.res.PainterResources_androidKt;
import androidx.compose.ui.res.StringResources_androidKt;
import androidx.compose.ui.text.TextRange;
import androidx.compose.ui.text.TextRangeKt;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.text.input.TextFieldValue;
import androidx.compose.ui.text.input.VisualTransformation;
import androidx.compose.ui.unit.Dp;
import com.pspdfkit.R;
import com.pspdfkit.compose.theme.AiAssistantColorScheme;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: classes3.dex */
public final class q {
    public static final Unit a(Modifier modifier, f0.a aVar, boolean z, AiAssistantColorScheme aiAssistantColorScheme, FocusRequester focusRequester, Function1 function1, Function0 function0, int i, int i2, Composer composer, int i3) {
        a(modifier, aVar, z, aiAssistantColorScheme, focusRequester, function1, function0, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX WARN: Code duplicated, block: B:108:0x03ad  */
    public static final void a(Modifier modifier, final f0.a aVar, final boolean z, final AiAssistantColorScheme aiAssistantColorScheme, final FocusRequester focusRequester, final Function1<? super TextFieldValue, Unit> function1, final Function0<Unit> function0, Composer composer, final int i, final int i2) {
        Modifier modifier2;
        int i3;
        Composer composer2;
        final Modifier modifier3;
        final boolean z2;
        aVar.getClass();
        aiAssistantColorScheme.getClass();
        focusRequester.getClass();
        function1.getClass();
        function0.getClass();
        Composer composerStartRestartGroup = composer.startRestartGroup(997682189);
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
        if ((i & 48) == 0) {
            i3 |= (i & 64) == 0 ? composerStartRestartGroup.changed(aVar) : composerStartRestartGroup.changedInstance(aVar) ? 32 : 16;
        }
        if ((i & 384) == 0) {
            i3 |= composerStartRestartGroup.changed(z) ? 256 : 128;
        }
        if ((i & 3072) == 0) {
            i3 |= composerStartRestartGroup.changed(aiAssistantColorScheme) ? 2048 : 1024;
        }
        if ((i & 24576) == 0) {
            i3 |= composerStartRestartGroup.changed(focusRequester) ? 16384 : 8192;
        }
        if ((196608 & i) == 0) {
            i3 |= composerStartRestartGroup.changedInstance(function1) ? 131072 : 65536;
        }
        if ((i & 1572864) == 0) {
            i3 |= composerStartRestartGroup.changedInstance(function0) ? 1048576 : 524288;
        }
        if (composerStartRestartGroup.shouldExecute((599187 & i3) != 599186, i3 & 1)) {
            Modifier modifier4 = i4 != 0 ? Modifier.INSTANCE : modifier2;
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(997682189, i3, -1, "io.nutrient.internal.ui.ai.ui.AiAssistantBottomBar (AiAssistantBottomBar.kt:62)");
            }
            boolean z3 = (i3 & 112) == 32 || ((i3 & 64) != 0 && composerStartRestartGroup.changed(aVar));
            Object objRememberedValue = composerStartRestartGroup.rememberedValue();
            if (z3 || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                TextFieldValue textFieldValue = new TextFieldValue(aVar.a, TextRangeKt.TextRange(aVar.b), (TextRange) null, 4, (DefaultConstructorMarker) null);
                composerStartRestartGroup.updateRememberedValue(textFieldValue);
                objRememberedValue = textFieldValue;
            }
            TextFieldValue textFieldValue2 = (TextFieldValue) objRememberedValue;
            float f = 12;
            Modifier modifierM1218padding3ABfNKs = PaddingKt.m1218padding3ABfNKs(WindowInsetsPadding_androidKt.imePadding(BackgroundKt.m589backgroundbw27NRU$default(ClipKt.clip(SizeKt.fillMaxWidth$default(modifier4, 0.0f, 1, null), RoundedCornerShapeKt.m1575RoundedCornerShapea9UjIt4$default(Dp.m9687constructorimpl(f), Dp.m9687constructorimpl(f), 0.0f, 0.0f, 12, null)), aiAssistantColorScheme.m13905getChatBackground0d7_KjU(), null, 2, null)), Dp.m9687constructorimpl(10));
            Arrangement.HorizontalOrVertical spaceAround = Arrangement.INSTANCE.getSpaceAround();
            Alignment.Companion companion = Alignment.INSTANCE;
            MeasurePolicy measurePolicyRowMeasurePolicy = RowKt.rowMeasurePolicy(spaceAround, companion.getTop(), composerStartRestartGroup, 6);
            int iHashCode = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
            CompositionLocalMap currentCompositionLocalMap = composerStartRestartGroup.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierM1218padding3ABfNKs);
            ComposeUiNode.Companion companion2 = ComposeUiNode.INSTANCE;
            Function0<ComposeUiNode> constructor = companion2.getConstructor();
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
            f2.a(companion2, composerM6062constructorimpl, measurePolicyRowMeasurePolicy, composerM6062constructorimpl, currentCompositionLocalMap);
            Updater.m6070setimpl(composerM6062constructorimpl, modifierMaterializeModifier, (Function2<? super T, ? super Modifier, Unit>) e2.a(companion2, composerM6062constructorimpl, Integer.valueOf(iHashCode), composerM6062constructorimpl));
            RowScopeInstance rowScopeInstance = RowScopeInstance.INSTANCE;
            Modifier.Companion companion3 = Modifier.INSTANCE;
            Modifier modifierFocusRequester = FocusRequesterModifierKt.focusRequester(RowScope.weight$default(rowScopeInstance, companion3, 1.0f, false, 2, null), focusRequester);
            TextStyle bodyLarge = MaterialTheme.INSTANCE.getTypography(composerStartRestartGroup, MaterialTheme.$stable).getBodyLarge();
            RoundedCornerShape roundedCornerShapeM1573RoundedCornerShape0680j_4 = RoundedCornerShapeKt.m1573RoundedCornerShape0680j_4(Dp.m9687constructorimpl(28));
            TextFieldDefaults textFieldDefaults = TextFieldDefaults.INSTANCE;
            long jM13915getTextFieldBackgroundColor0d7_KjU = aiAssistantColorScheme.m13915getTextFieldBackgroundColor0d7_KjU();
            long jM13915getTextFieldBackgroundColor0d7_KjU2 = aiAssistantColorScheme.m13915getTextFieldBackgroundColor0d7_KjU();
            long jM13915getTextFieldBackgroundColor0d7_KjU3 = aiAssistantColorScheme.m13915getTextFieldBackgroundColor0d7_KjU();
            int i5 = i3;
            long jM13917getTextFieldTextColor0d7_KjU = aiAssistantColorScheme.m13917getTextFieldTextColor0d7_KjU();
            long jM13917getTextFieldTextColor0d7_KjU2 = aiAssistantColorScheme.m13917getTextFieldTextColor0d7_KjU();
            long jM13917getTextFieldTextColor0d7_KjU3 = aiAssistantColorScheme.m13917getTextFieldTextColor0d7_KjU();
            Color.Companion companion4 = Color.INSTANCE;
            TextFieldKt.TextField(textFieldValue2, function1, modifierFocusRequester, false, false, bodyLarge, (Function2<? super Composer, ? super Integer, Unit>) null, (Function2<? super Composer, ? super Integer, Unit>) ComposableLambdaKt.rememberComposableLambda(942272940, true, new Function2() { // from class: com.pspdfkit.internal.q$$ExternalSyntheticLambda0
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return q.a(aiAssistantColorScheme, (Composer) obj, ((Integer) obj2).intValue());
                }
            }, composerStartRestartGroup, 54), (Function2<? super Composer, ? super Integer, Unit>) null, (Function2<? super Composer, ? super Integer, Unit>) null, (Function2<? super Composer, ? super Integer, Unit>) null, (Function2<? super Composer, ? super Integer, Unit>) null, (Function2<? super Composer, ? super Integer, Unit>) null, false, (VisualTransformation) null, (KeyboardOptions) null, (KeyboardActions) null, false, 0, 0, (MutableInteractionSource) null, (Shape) roundedCornerShapeM1573RoundedCornerShape0680j_4, textFieldDefaults.m4466colors0hiis_0(jM13917getTextFieldTextColor0d7_KjU, jM13917getTextFieldTextColor0d7_KjU3, jM13917getTextFieldTextColor0d7_KjU2, 0L, jM13915getTextFieldBackgroundColor0d7_KjU, jM13915getTextFieldBackgroundColor0d7_KjU3, jM13915getTextFieldBackgroundColor0d7_KjU2, 0L, 0L, 0L, null, companion4.m6849getTransparent0d7_KjU(), companion4.m6849getTransparent0d7_KjU(), companion4.m6849getTransparent0d7_KjU(), 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 0, 3504, 0, 0, 3072, 2147469192, 4095), composerStartRestartGroup, ((i5 >> 12) & 112) | 12582912, 0, 0, 2096984);
            Modifier modifierAlign = rowScopeInstance.align(companion3, companion.getBottom());
            MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(companion.getTopStart(), false);
            int iHashCode2 = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
            CompositionLocalMap currentCompositionLocalMap2 = composerStartRestartGroup.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier2 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierAlign);
            Function0<ComposeUiNode> constructor2 = companion2.getConstructor();
            if (!(composerStartRestartGroup.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            composerStartRestartGroup.startReusableNode();
            if (composerStartRestartGroup.getInserting()) {
                composerStartRestartGroup.createNode(constructor2);
            } else {
                composerStartRestartGroup.useNode();
            }
            Composer composerM6062constructorimpl2 = Updater.m6062constructorimpl(composerStartRestartGroup);
            f2.a(companion2, composerM6062constructorimpl2, measurePolicyMaybeCachedBoxMeasurePolicy, composerM6062constructorimpl2, currentCompositionLocalMap2);
            Updater.m6070setimpl(composerM6062constructorimpl2, modifierMaterializeModifier2, (Function2<? super T, ? super Modifier, Unit>) e2.a(companion2, composerM6062constructorimpl2, Integer.valueOf(iHashCode2), composerM6062constructorimpl2));
            BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
            if (z) {
                if (textFieldValue2.getText().length() > 0) {
                    z2 = true;
                } else {
                    z2 = false;
                }
            } else {
                z2 = false;
            }
            IconButtonKt.IconButton(function0, BackgroundKt.m588backgroundbw27NRU(PaddingKt.m1222paddingqDBjuR0$default(companion3, Dp.m9687constructorimpl(8), 0.0f, 0.0f, Dp.m9687constructorimpl(4), 6, null), z2 ? aiAssistantColorScheme.m13913getSubmitButtonEnabledColor0d7_KjU() : aiAssistantColorScheme.m13915getTextFieldBackgroundColor0d7_KjU(), RoundedCornerShapeKt.getCircleShape()), z2, (IconButtonColors) null, (MutableInteractionSource) null, (Shape) null, ComposableLambdaKt.rememberComposableLambda(429097493, true, new Function2() { // from class: com.pspdfkit.internal.q$$ExternalSyntheticLambda1
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return q.a(z2, aiAssistantColorScheme, (Composer) obj, ((Integer) obj2).intValue());
                }
            }, composerStartRestartGroup, 54), composerStartRestartGroup, ((i5 >> 18) & 14) | 1572864, 56);
            composer2 = composerStartRestartGroup;
            composer2.endNode();
            composer2.endNode();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            modifier3 = modifier4;
        } else {
            composer2 = composerStartRestartGroup;
            composer2.skipToGroupEnd();
            modifier3 = modifier2;
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.pspdfkit.internal.q$$ExternalSyntheticLambda2
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return q.a(modifier3, aVar, z, aiAssistantColorScheme, focusRequester, function1, function0, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    public static final Unit a(AiAssistantColorScheme aiAssistantColorScheme, Composer composer, int i) {
        if (composer.shouldExecute((i & 3) != 2, i & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(942272940, i, -1, "io.nutrient.internal.ui.ai.ui.AiAssistantBottomBar.<anonymous>.<anonymous> (AiAssistantBottomBar.kt:88)");
            }
            TextKt.m4494TextNvy7gAk(StringResources_androidKt.stringResource(R.string.pspdf__ai_assistant_type_something, composer, 0), null, aiAssistantColorScheme.m13916getTextFieldHintColor0d7_KjU(), null, 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, null, composer, 0, 0, 262138);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composer.skipToGroupEnd();
        }
        return Unit.INSTANCE;
    }

    public static final Unit a(boolean z, AiAssistantColorScheme aiAssistantColorScheme, Composer composer, int i) {
        long jM13916getTextFieldHintColor0d7_KjU;
        if (composer.shouldExecute((i & 3) != 2, i & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(429097493, i, -1, "io.nutrient.internal.ui.ai.ui.AiAssistantBottomBar.<anonymous>.<anonymous>.<anonymous> (AiAssistantBottomBar.kt:124)");
            }
            if (z) {
                jM13916getTextFieldHintColor0d7_KjU = aiAssistantColorScheme.m13909getInnerChatTextColor0d7_KjU();
            } else {
                jM13916getTextFieldHintColor0d7_KjU = aiAssistantColorScheme.m13916getTextFieldHintColor0d7_KjU();
            }
            IconKt.m3575Iconww6aTOc(PainterResources_androidKt.painterResource(R.drawable.pspdf__up_arrow, composer, 0), "Send message", (Modifier) null, jM13916getTextFieldHintColor0d7_KjU, composer, Painter.$stable | 48, 4);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composer.skipToGroupEnd();
        }
        return Unit.INSTANCE;
    }
}
