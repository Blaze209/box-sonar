package com.pspdfkit.internal;

import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.material3.AppBarKt;
import androidx.compose.material3.IconButtonColors;
import androidx.compose.material3.IconButtonKt;
import androidx.compose.material3.TopAppBarColors;
import androidx.compose.material3.TopAppBarDefaults;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.Shape;
import com.pspdfkit.compose.theme.AiAssistantColorScheme;
import external.sdk.pendo.io.mozilla.javascript.Token;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;

/* JADX INFO: loaded from: classes3.dex */
public final class a0 {
    public static final Unit a(Function0 function0, Composer composer, int i) {
        if (composer.shouldExecute((i & 3) != 2, i & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1334261513, i, -1, "io.nutrient.internal.ui.ai.ui.AiAssistantTopBar.<anonymous> (AiAssistantTopBar.kt:46)");
            }
            IconButtonKt.IconButton((Function0<Unit>) function0, (Modifier) null, false, (IconButtonColors) null, (MutableInteractionSource) null, (Shape) null, (Function2<? super Composer, ? super Integer, Unit>) l9.b, composer, 1572864, 62);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composer.skipToGroupEnd();
        }
        return Unit.INSTANCE;
    }

    public static final Unit a(Modifier modifier, AiAssistantColorScheme aiAssistantColorScheme, Function0 function0, int i, int i2, Composer composer, int i3) {
        a(modifier, aiAssistantColorScheme, function0, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    public static final void a(Modifier modifier, final AiAssistantColorScheme aiAssistantColorScheme, final Function0<Unit> function0, Composer composer, final int i, final int i2) {
        Modifier modifier2;
        int i3;
        final Modifier modifier3;
        aiAssistantColorScheme.getClass();
        function0.getClass();
        Composer composerStartRestartGroup = composer.startRestartGroup(-2043675837);
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
            i3 |= composerStartRestartGroup.changed(aiAssistantColorScheme) ? 32 : 16;
        }
        if ((i & 384) == 0) {
            i3 |= composerStartRestartGroup.changedInstance(function0) ? 256 : 128;
        }
        if (composerStartRestartGroup.shouldExecute((i3 & Token.DOTQUERY) != 146, i3 & 1)) {
            Modifier modifier4 = i4 != 0 ? Modifier.INSTANCE : modifier2;
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-2043675837, i3, -1, "io.nutrient.internal.ui.ai.ui.AiAssistantTopBar (AiAssistantTopBar.kt:33)");
            }
            TopAppBarColors topAppBarColorsM4782topAppBarColors5tl4gsc = TopAppBarDefaults.INSTANCE.m4782topAppBarColors5tl4gsc(aiAssistantColorScheme.m13906getContainerColor0d7_KjU(), 0L, aiAssistantColorScheme.m13907getIconColor0d7_KjU(), aiAssistantColorScheme.m13918getToolbarTextColor0d7_KjU(), 0L, 0L, composerStartRestartGroup, TopAppBarDefaults.$stable << 18, 50);
            composerStartRestartGroup = composerStartRestartGroup;
            Modifier modifier5 = modifier4;
            AppBarKt.m2784TopAppBarGHTll3U(l9.a, modifier5, ComposableLambdaKt.rememberComposableLambda(1334261513, true, new Function2() { // from class: com.pspdfkit.internal.a0$$ExternalSyntheticLambda0
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return a0.a(function0, (Composer) obj, ((Integer) obj2).intValue());
                }
            }, composerStartRestartGroup, 54), null, 0.0f, null, topAppBarColorsM4782topAppBarColors5tl4gsc, null, composerStartRestartGroup, ((i3 << 3) & 112) | 390, 184);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            modifier3 = modifier5;
        } else {
            composerStartRestartGroup.skipToGroupEnd();
            modifier3 = modifier2;
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.pspdfkit.internal.a0$$ExternalSyntheticLambda1
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return a0.a(modifier3, aiAssistantColorScheme, function0, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }
}
