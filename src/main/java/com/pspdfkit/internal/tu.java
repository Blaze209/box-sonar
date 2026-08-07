package com.pspdfkit.internal;

import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.ProvidedValue;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;

/* JADX INFO: loaded from: classes3.dex */
public final class tu {
    public static final Unit a(int i, m40 m40Var, int i2, az azVar, Function1 function1, az azVar2, Function1 function2, int i3, Composer composer, int i4) {
        a(i, m40Var, i2, azVar, function1, azVar2, function2, composer, RecomposeScopeImplKt.updateChangedFlags(i3 | 1));
        return Unit.INSTANCE;
    }

    public static final void a(final int i, final m40 m40Var, final int i2, final az azVar, final Function1<? super az, Unit> function1, final az azVar2, final Function1<? super az, Unit> function2, Composer composer, final int i3) {
        int i4;
        az azVar3;
        Function1<? super az, Unit> function3;
        m40Var.getClass();
        azVar.getClass();
        function1.getClass();
        azVar2.getClass();
        function2.getClass();
        Composer composerStartRestartGroup = composer.startRestartGroup(457060291);
        if ((i3 & 6) == 0) {
            i4 = (composerStartRestartGroup.changed(i) ? 4 : 2) | i3;
        } else {
            i4 = i3;
        }
        if ((i3 & 48) == 0) {
            i4 |= composerStartRestartGroup.changed(m40Var) ? 32 : 16;
        }
        if ((i3 & 384) == 0) {
            i4 |= composerStartRestartGroup.changed(i2) ? 256 : 128;
        }
        if ((i3 & 3072) == 0) {
            i4 |= composerStartRestartGroup.changed(azVar) ? 2048 : 1024;
        }
        if ((i3 & 24576) == 0) {
            i4 |= composerStartRestartGroup.changedInstance(function1) ? 16384 : 8192;
        }
        if ((196608 & i3) == 0) {
            azVar3 = azVar2;
            i4 |= composerStartRestartGroup.changed(azVar3) ? 131072 : 65536;
        } else {
            azVar3 = azVar2;
        }
        if ((1572864 & i3) == 0) {
            function3 = function2;
            i4 |= composerStartRestartGroup.changedInstance(function3) ? 1048576 : 524288;
        } else {
            function3 = function2;
        }
        if (composerStartRestartGroup.shouldExecute((599187 & i4) != 599186, i4 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(457060291, i4, -1, "com.pspdfkit.internal.views.page.pageview.ui.PageViewContainer (PageViewContainer.kt:30)");
            }
            final az azVar4 = azVar3;
            final Function1<? super az, Unit> function4 = function3;
            CompositionLocalKt.CompositionLocalProvider(ko.a.provides(new uu(i, m40Var, i2)), ComposableLambdaKt.rememberComposableLambda(1650656387, true, new Function2() { // from class: com.pspdfkit.internal.tu$$ExternalSyntheticLambda0
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return tu.a(azVar4, function4, m40Var, azVar, function1, (Composer) obj, ((Integer) obj2).intValue());
                }
            }, composerStartRestartGroup, 54), composerStartRestartGroup, ProvidedValue.$stable | 48);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composerStartRestartGroup.skipToGroupEnd();
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.pspdfkit.internal.tu$$ExternalSyntheticLambda1
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return tu.a(i, m40Var, i2, azVar, function1, azVar2, function2, i3, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    public static final Unit a(az azVar, Function1 function1, m40 m40Var, az azVar2, Function1 function2, Composer composer, int i) {
        if (composer.shouldExecute((i & 3) != 2, i & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1650656387, i, -1, "com.pspdfkit.internal.views.page.pageview.ui.PageViewContainer.<anonymous> (PageViewContainer.kt:32)");
            }
            Modifier modifierFillMaxSize$default = SizeKt.fillMaxSize$default(Modifier.INSTANCE, 0.0f, 1, null);
            MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), false);
            int iHashCode = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composer, 0));
            CompositionLocalMap currentCompositionLocalMap = composer.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composer, modifierFillMaxSize$default);
            ComposeUiNode.Companion companion = ComposeUiNode.INSTANCE;
            Function0<ComposeUiNode> constructor = companion.getConstructor();
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
            f2.a(companion, composerM6062constructorimpl, measurePolicyMaybeCachedBoxMeasurePolicy, composerM6062constructorimpl, currentCompositionLocalMap);
            Updater.m6070setimpl(composerM6062constructorimpl, modifierMaterializeModifier, (Function2<? super T, ? super Modifier, Unit>) e2.a(companion, composerM6062constructorimpl, Integer.valueOf(iHashCode), composerM6062constructorimpl));
            BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
            oo.a(azVar, function1, composer, 0);
            if (m40Var.d) {
                composer.startReplaceGroup(-246580731);
                oj.a(azVar2, (Function1<? super az, Unit>) function2, composer, 0);
                composer.endReplaceGroup();
            } else {
                composer.startReplaceGroup(-246438503);
                composer.endReplaceGroup();
            }
            composer.endNode();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composer.skipToGroupEnd();
        }
        return Unit.INSTANCE;
    }
}
