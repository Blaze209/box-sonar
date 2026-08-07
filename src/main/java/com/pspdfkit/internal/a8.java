package com.pspdfkit.internal;

import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.RowKt;
import androidx.compose.foundation.layout.RowScopeInstance;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.material3.IconButtonColors;
import androidx.compose.material3.IconButtonKt;
import androidx.compose.material3.IconKt;
import androidx.compose.material3.ProgressIndicatorKt;
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
import androidx.compose.ui.draw.ShadowKt;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.ColorKt;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.graphics.painter.Painter;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.res.PainterResources_androidKt;
import androidx.compose.ui.res.StringResources_androidKt;
import androidx.compose.ui.unit.Dp;
import androidx.media3.common.C;
import com.pspdfkit.R;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;

/* JADX INFO: loaded from: classes3.dex */
public final class a8 {
    public static final Unit a(b8 b8Var, Function0 function0, Function0 function1, boolean z, boolean z2, boolean z3, boolean z4, boolean z5, g8 g8Var, Modifier modifier, int i, Composer composer, int i2) {
        a(b8Var, function0, function1, z, z2, z3, z4, z5, g8Var, modifier, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    public static final Unit b(b8 b8Var, Function0 function0, Function0 function1, boolean z, boolean z2, boolean z3, boolean z4, boolean z5, g8 g8Var, Modifier modifier, int i, Composer composer, int i2) {
        a(b8Var, function0, function1, z, z2, z3, z4, z5, g8Var, modifier, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    public static final void a(final b8 b8Var, final Function0<Unit> function0, final Function0<Unit> function1, final boolean z, final boolean z2, final boolean z3, final boolean z4, final boolean z5, final g8 g8Var, final Modifier modifier, Composer composer, final int i) {
        int i2;
        Function0<Unit> function2;
        Function0<Unit> function3;
        final b8 b8Var2;
        Composer composer2;
        g8 g8Var2;
        boolean z6;
        b8Var.getClass();
        function0.getClass();
        function1.getClass();
        g8Var.getClass();
        modifier.getClass();
        Composer composerStartRestartGroup = composer.startRestartGroup(-2018359690);
        if ((i & 6) == 0) {
            i2 = (composerStartRestartGroup.changed(b8Var) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 48) == 0) {
            function2 = function0;
            i2 |= composerStartRestartGroup.changedInstance(function2) ? 32 : 16;
        } else {
            function2 = function0;
        }
        if ((i & 384) == 0) {
            function3 = function1;
            i2 |= composerStartRestartGroup.changedInstance(function3) ? 256 : 128;
        } else {
            function3 = function1;
        }
        if ((i & 3072) == 0) {
            i2 |= composerStartRestartGroup.changed(z) ? 2048 : 1024;
        }
        if ((i & 24576) == 0) {
            i2 |= composerStartRestartGroup.changed(z2) ? 16384 : 8192;
        }
        if ((196608 & i) == 0) {
            i2 |= composerStartRestartGroup.changed(z3) ? 131072 : 65536;
        }
        if ((i & 1572864) == 0) {
            i2 |= composerStartRestartGroup.changed(z4) ? 1048576 : 524288;
        }
        if ((12582912 & i) == 0) {
            i2 |= composerStartRestartGroup.changed(z5) ? 8388608 : 4194304;
        }
        if ((100663296 & i) == 0) {
            i2 |= composerStartRestartGroup.changed(g8Var) ? 67108864 : 33554432;
        }
        if ((805306368 & i) == 0) {
            i2 |= composerStartRestartGroup.changed(modifier) ? C.BUFFER_FLAG_LAST_SAMPLE : 268435456;
        }
        int i3 = i2;
        if (composerStartRestartGroup.shouldExecute((306783379 & i3) != 306783378, i3 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-2018359690, i3, -1, "io.nutrient.internal.ui.bookmarks.BookmarkListBottomBar (BookmarkListBottomBar.kt:55)");
            }
            if (!z2 && !z4) {
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                    final Function0<Unit> function4 = function2;
                    final Function0<Unit> function5 = function3;
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.pspdfkit.internal.a8$$ExternalSyntheticLambda0
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return a8.a(b8Var, function4, function5, z, z2, z3, z4, z5, g8Var, modifier, i, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    });
                    return;
                }
                return;
            }
            b8Var2 = b8Var;
            g8Var2 = g8Var;
            Modifier modifierM1252height3ABfNKs = SizeKt.m1252height3ABfNKs(BackgroundKt.m589backgroundbw27NRU$default(ShadowKt.m6412shadows4CzXII$default(modifier, g8Var2.d, null, false, 0L, 0L, 30, null), ColorKt.Color(b8Var2.a), null, 2, null), g8Var2.c);
            MeasurePolicy measurePolicyRowMeasurePolicy = RowKt.rowMeasurePolicy(Arrangement.INSTANCE.getSpaceBetween(), Alignment.INSTANCE.getCenterVertically(), composerStartRestartGroup, 54);
            int iHashCode = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
            CompositionLocalMap currentCompositionLocalMap = composerStartRestartGroup.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierM1252height3ABfNKs);
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
            if (z2) {
                composerStartRestartGroup.startReplaceGroup(60815809);
                Modifier.Companion companion2 = Modifier.INSTANCE;
                companion2.getClass();
                int i4 = i3 >> 3;
                composer2 = composerStartRestartGroup;
                z6 = true;
                IconButtonKt.IconButton(function0, companion2, z, (IconButtonColors) null, (MutableInteractionSource) null, (Shape) null, ComposableLambdaKt.rememberComposableLambda(698712019, true, new Function2() { // from class: com.pspdfkit.internal.a8$$ExternalSyntheticLambda1
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return a8.a(z5, b8Var2, z, (Composer) obj, ((Integer) obj2).intValue());
                    }
                }, composerStartRestartGroup, 54), composer2, (i4 & 14) | 1572864 | (i4 & 896), 56);
                composer2.endReplaceGroup();
            } else {
                composer2 = composerStartRestartGroup;
                z6 = true;
                composer2.startReplaceGroup(61724264);
                composer2.endReplaceGroup();
            }
            if (z4) {
                composer2.startReplaceGroup(61786388);
                Modifier.Companion companion3 = Modifier.INSTANCE;
                companion3.getClass();
                IconButtonKt.IconButton(function1, companion3, z3, (IconButtonColors) null, (MutableInteractionSource) null, (Shape) null, ComposableLambdaKt.rememberComposableLambda(2010681290, z6, new Function2() { // from class: com.pspdfkit.internal.a8$$ExternalSyntheticLambda2
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return a8.a(b8Var2, z3, (Composer) obj, ((Integer) obj2).intValue());
                    }
                }, composer2, 54), composer2, ((i3 >> 6) & 14) | 1572864 | ((i3 >> 9) & 896), 56);
                composer2.endReplaceGroup();
            } else {
                composer2.startReplaceGroup(62369064);
                composer2.endReplaceGroup();
            }
            composer2.endNode();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            b8Var2 = b8Var;
            composer2 = composerStartRestartGroup;
            g8Var2 = g8Var;
            composer2.skipToGroupEnd();
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup2 = composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup2 != null) {
            final b8 b8Var3 = b8Var2;
            final g8 g8Var3 = g8Var2;
            scopeUpdateScopeEndRestartGroup2.updateScope(new Function2() { // from class: com.pspdfkit.internal.a8$$ExternalSyntheticLambda3
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return a8.b(b8Var3, function0, function1, z, z2, z3, z4, z5, g8Var3, modifier, i, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    public static final Unit a(boolean z, b8 b8Var, boolean z2, Composer composer, int i) {
        if (composer.shouldExecute((i & 3) != 2, i & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(698712019, i, -1, "io.nutrient.internal.ui.bookmarks.BookmarkListBottomBar.<anonymous>.<anonymous> (BookmarkListBottomBar.kt:74)");
            }
            if (z) {
                composer.startReplaceGroup(1918288952);
                ProgressIndicatorKt.m3993CircularProgressIndicator4lLiAd8(SizeKt.m1266size3ABfNKs(Modifier.INSTANCE, Dp.m9687constructorimpl(24)), ColorKt.Color(b8Var.d), Dp.m9687constructorimpl(2), 0L, 0, 0.0f, composer, 390, 56);
                composer.endReplaceGroup();
            } else {
                composer.startReplaceGroup(1918545973);
                IconKt.m3575Iconww6aTOc(PainterResources_androidKt.painterResource(b8Var.b, composer, 0), StringResources_androidKt.stringResource(R.string.pspdf__add_bookmark, composer, 0), (Modifier) null, Color.m6813copywmQWz5c$default(ColorKt.Color(b8Var.d), z2 ? 1.0f : 0.5f, 0.0f, 0.0f, 0.0f, 14, null), composer, Painter.$stable, 4);
                composer.endReplaceGroup();
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composer.skipToGroupEnd();
        }
        return Unit.INSTANCE;
    }

    public static final Unit a(b8 b8Var, boolean z, Composer composer, int i) {
        if (composer.shouldExecute((i & 3) != 2, i & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(2010681290, i, -1, "io.nutrient.internal.ui.bookmarks.BookmarkListBottomBar.<anonymous>.<anonymous> (BookmarkListBottomBar.kt:98)");
            }
            IconKt.m3575Iconww6aTOc(PainterResources_androidKt.painterResource(b8Var.c, composer, 0), StringResources_androidKt.stringResource(R.string.pspdf__edit, composer, 0), (Modifier) null, Color.m6813copywmQWz5c$default(ColorKt.Color(b8Var.d), z ? 1.0f : 0.5f, 0.0f, 0.0f, 0.0f, 14, null), composer, Painter.$stable, 4);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composer.skipToGroupEnd();
        }
        return Unit.INSTANCE;
    }
}
