package com.pspdfkit.internal;

import androidx.compose.animation.SingleValueAnimationKt;
import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.material3.IconKt;
import androidx.compose.material3.SwipeToDismissBoxValue;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.Updater;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.ColorKt;
import androidx.compose.ui.graphics.painter.Painter;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.res.PainterResources_androidKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;

/* JADX INFO: loaded from: classes3.dex */
public final class c50 {
    public static final Unit a(SwipeToDismissBoxValue swipeToDismissBoxValue, int i, int i2, d50 d50Var, Modifier modifier, int i3, Composer composer, int i4) {
        a(swipeToDismissBoxValue, i, i2, d50Var, modifier, composer, RecomposeScopeImplKt.updateChangedFlags(i3 | 1));
        return Unit.INSTANCE;
    }

    public static final void a(final SwipeToDismissBoxValue swipeToDismissBoxValue, final int i, final int i2, final d50 d50Var, final Modifier modifier, Composer composer, final int i3) {
        int i4;
        d50Var.getClass();
        modifier.getClass();
        Composer composerStartRestartGroup = composer.startRestartGroup(-607114819);
        if ((i3 & 6) == 0) {
            i4 = (composerStartRestartGroup.changed(swipeToDismissBoxValue == null ? -1 : swipeToDismissBoxValue.ordinal()) ? 4 : 2) | i3;
        } else {
            i4 = i3;
        }
        if ((i3 & 48) == 0) {
            i4 |= composerStartRestartGroup.changed(i) ? 32 : 16;
        }
        if ((i3 & 384) == 0) {
            i4 |= composerStartRestartGroup.changed(i2) ? 256 : 128;
        }
        if ((i3 & 3072) == 0) {
            i4 |= composerStartRestartGroup.changed(d50Var) ? 2048 : 1024;
        }
        if ((i3 & 24576) == 0) {
            i4 |= composerStartRestartGroup.changed(modifier) ? 16384 : 8192;
        }
        if (composerStartRestartGroup.shouldExecute((i4 & 9363) != 9362, i4 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-607114819, i4, -1, "io.nutrient.internal.ui.utils.touch.SwipeDeleteBackground (SwipeDeleteBackground.kt:43)");
            }
            Modifier modifierM589backgroundbw27NRU$default = BackgroundKt.m589backgroundbw27NRU$default(SizeKt.fillMaxWidth$default(modifier, 0.0f, 1, null), SingleValueAnimationKt.m437animateColorAsStateeuL9pac(swipeToDismissBoxValue == SwipeToDismissBoxValue.EndToStart ? ColorKt.Color(i) : Color.INSTANCE.m6851getWhite0d7_KjU(), null, "swipe_to_delete_background", null, composerStartRestartGroup, 384, 10).getValue().m6824unboximpl(), null, 2, null);
            float f = d50Var.a;
            float f2 = d50Var.b;
            Modifier modifierM1221paddingqDBjuR0 = PaddingKt.m1221paddingqDBjuR0(modifierM589backgroundbw27NRU$default, f, f2, f, f2);
            MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.INSTANCE.getCenterEnd(), false);
            int iHashCode = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
            CompositionLocalMap currentCompositionLocalMap = composerStartRestartGroup.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierM1221paddingqDBjuR0);
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
            f2.a(companion, composerM6062constructorimpl, measurePolicyMaybeCachedBoxMeasurePolicy, composerM6062constructorimpl, currentCompositionLocalMap);
            Updater.m6070setimpl(composerM6062constructorimpl, modifierMaterializeModifier, (Function2<? super T, ? super Modifier, Unit>) e2.a(companion, composerM6062constructorimpl, Integer.valueOf(iHashCode), composerM6062constructorimpl));
            BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
            IconKt.m3575Iconww6aTOc(PainterResources_androidKt.painterResource(i2, composerStartRestartGroup, (i4 >> 6) & 14), (String) null, (Modifier) null, Color.INSTANCE.m6851getWhite0d7_KjU(), composerStartRestartGroup, Painter.$stable | 3120, 4);
            composerStartRestartGroup.endNode();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composerStartRestartGroup.skipToGroupEnd();
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.pspdfkit.internal.c50$$ExternalSyntheticLambda0
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return c50.a(swipeToDismissBoxValue, i, i2, d50Var, modifier, i3, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }
}
