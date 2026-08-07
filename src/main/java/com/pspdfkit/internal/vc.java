package com.pspdfkit.internal;

import androidx.compose.foundation.ClickableKt;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.RowKt;
import androidx.compose.foundation.layout.RowScope;
import androidx.compose.foundation.layout.RowScopeInstance;
import androidx.compose.foundation.shape.RoundedCornerShapeKt;
import androidx.compose.material3.IconKt;
import androidx.compose.material3.TextKt;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambda;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.draw.ClipKt;
import androidx.compose.ui.graphics.painter.Painter;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.platform.TestTagKt;
import androidx.compose.ui.res.PainterResources_androidKt;
import androidx.compose.ui.text.TextStyle;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;

/* JADX INFO: loaded from: classes3.dex */
public final class vc {
    public static final Unit a(String str, TextStyle textStyle, Modifier modifier, int i, long j, boolean z, Function0 function0, Modifier modifier2, Modifier modifier3, int i2, Composer composer, int i3) {
        a(str, textStyle, modifier, i, j, z, function0, modifier2, modifier3, composer, RecomposeScopeImplKt.updateChangedFlags(i2 | 1));
        return Unit.INSTANCE;
    }

    public static final void a(final String str, final TextStyle textStyle, final Modifier modifier, final int i, final long j, final boolean z, final Function0<Unit> function0, final Modifier modifier2, final Modifier modifier3, Composer composer, final int i2) {
        int i3;
        TextStyle textStyle2;
        long j2;
        Function0<Unit> function1;
        Modifier modifier4;
        Modifier modifier5;
        str.getClass();
        textStyle.getClass();
        modifier.getClass();
        function0.getClass();
        modifier2.getClass();
        modifier3.getClass();
        Composer composerStartRestartGroup = composer.startRestartGroup(-1759482508);
        if ((i2 & 6) == 0) {
            i3 = (composerStartRestartGroup.changed(str) ? 4 : 2) | i2;
        } else {
            i3 = i2;
        }
        if ((i2 & 48) == 0) {
            textStyle2 = textStyle;
            i3 |= composerStartRestartGroup.changed(textStyle2) ? 32 : 16;
        } else {
            textStyle2 = textStyle;
        }
        if ((i2 & 384) == 0) {
            i3 |= composerStartRestartGroup.changed(modifier) ? 256 : 128;
        }
        if ((i2 & 3072) == 0) {
            i3 |= composerStartRestartGroup.changed(i) ? 2048 : 1024;
        }
        if ((i2 & 24576) == 0) {
            j2 = j;
            i3 |= composerStartRestartGroup.changed(j2) ? 16384 : 8192;
        } else {
            j2 = j;
        }
        if ((196608 & i2) == 0) {
            i3 |= composerStartRestartGroup.changed(z) ? 131072 : 65536;
        }
        if ((1572864 & i2) == 0) {
            function1 = function0;
            i3 |= composerStartRestartGroup.changedInstance(function1) ? 1048576 : 524288;
        } else {
            function1 = function0;
        }
        if ((12582912 & i2) == 0) {
            modifier4 = modifier2;
            i3 |= composerStartRestartGroup.changed(modifier4) ? 8388608 : 4194304;
        } else {
            modifier4 = modifier2;
        }
        if ((100663296 & i2) == 0) {
            modifier5 = modifier3;
            i3 |= composerStartRestartGroup.changed(modifier5) ? 67108864 : 33554432;
        } else {
            modifier5 = modifier3;
        }
        if (composerStartRestartGroup.shouldExecute((38347923 & i3) != 38347922, i3 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1759482508, i3, -1, "com.pspdfkit.internal.ui.dialog.signatures.composables.DialogTitleBar (DialogTitleBar.kt:37)");
            }
            final long j3 = j2;
            final Function0<Unit> function2 = function1;
            final Modifier modifier6 = modifier4;
            ComposableLambda composableLambdaRememberComposableLambda = ComposableLambdaKt.rememberComposableLambda(-1975920601, true, new Function2() { // from class: com.pspdfkit.internal.vc$$ExternalSyntheticLambda0
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return vc.a(i, modifier6, function2, j3, (Composer) obj, ((Integer) obj2).intValue());
                }
            }, composerStartRestartGroup, 54);
            MeasurePolicy measurePolicyRowMeasurePolicy = RowKt.rowMeasurePolicy(Arrangement.INSTANCE.getStart(), Alignment.INSTANCE.getCenterVertically(), composerStartRestartGroup, 48);
            int iHashCode = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
            CompositionLocalMap currentCompositionLocalMap = composerStartRestartGroup.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifier);
            ComposeUiNode.Companion companion = ComposeUiNode.INSTANCE;
            Function0<ComposeUiNode> constructor = companion.getConstructor();
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
            f2.a(companion, composerM6062constructorimpl, measurePolicyRowMeasurePolicy, composerM6062constructorimpl, currentCompositionLocalMap);
            Updater.m6070setimpl(composerM6062constructorimpl, modifierMaterializeModifier, (Function2<? super T, ? super Modifier, Unit>) e2.a(companion, composerM6062constructorimpl, Integer.valueOf(iHashCode), composerM6062constructorimpl));
            RowScopeInstance rowScopeInstance = RowScopeInstance.INSTANCE;
            if (z) {
                composerStartRestartGroup.startReplaceGroup(781366860);
                composableLambdaRememberComposableLambda.invoke(composerStartRestartGroup, 6);
                composerStartRestartGroup.endReplaceGroup();
            } else {
                composerStartRestartGroup.startReplaceGroup(781395690);
                composerStartRestartGroup.endReplaceGroup();
            }
            TextKt.m4494TextNvy7gAk(str, RowScope.weight$default(rowScopeInstance, modifier5, 1.0f, false, 2, null), 0L, null, 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, textStyle2, composerStartRestartGroup, i3 & 14, (i3 << 18) & 29360128, 131068);
            if (z) {
                composerStartRestartGroup.startReplaceGroup(781546474);
                composerStartRestartGroup.endReplaceGroup();
            } else {
                composerStartRestartGroup.startReplaceGroup(781517644);
                composableLambdaRememberComposableLambda.invoke(composerStartRestartGroup, 6);
                composerStartRestartGroup.endReplaceGroup();
            }
            composerStartRestartGroup.endNode();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composerStartRestartGroup.skipToGroupEnd();
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.pspdfkit.internal.vc$$ExternalSyntheticLambda1
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return vc.a(str, textStyle, modifier, i, j, z, function0, modifier2, modifier3, i2, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    public static final Unit a(int i, Modifier modifier, final Function0 function0, long j, Composer composer, int i2) {
        if (composer.shouldExecute((i2 & 3) != 2, i2 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1975920601, i2, -1, "com.pspdfkit.internal.ui.dialog.signatures.composables.DialogTitleBar.<anonymous> (DialogTitleBar.kt:39)");
            }
            Painter painterPainterResource = PainterResources_androidKt.painterResource(i, composer, 0);
            Modifier modifierClip = ClipKt.clip(modifier, RoundedCornerShapeKt.getCircleShape());
            boolean zChanged = composer.changed(function0);
            Object objRememberedValue = composer.rememberedValue();
            if (zChanged || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                objRememberedValue = new Function0() { // from class: com.pspdfkit.internal.vc$$ExternalSyntheticLambda2
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return vc.a(function0);
                    }
                };
                composer.updateRememberedValue(objRememberedValue);
            }
            IconKt.m3575Iconww6aTOc(painterPainterResource, "", TestTagKt.testTag(ClickableKt.m632clickableoSLSa3U$default(modifierClip, false, null, null, null, (Function0) objRememberedValue, 15, null), "PSPDF_DIALOG_TITLE_BACK_CLOSE"), j, composer, Painter.$stable | 48, 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composer.skipToGroupEnd();
        }
        return Unit.INSTANCE;
    }

    public static final Unit a(Function0 function0) {
        function0.invoke();
        return Unit.INSTANCE;
    }
}
