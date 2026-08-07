package com.pspdfkit.internal;

import androidx.compose.material3.FloatingActionButtonDefaults;
import androidx.compose.material3.FloatingActionButtonKt;
import androidx.compose.material3.IconKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.graphics.painter.Painter;
import androidx.compose.ui.res.PainterResources_androidKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;

/* JADX INFO: loaded from: classes3.dex */
public final class l20 {
    public static final Unit a(Modifier modifier, int i, long j, long j2, float f, Shape shape, Function0 function0, int i2, int i3, Composer composer, int i4) {
        a(modifier, i, j, j2, f, shape, function0, composer, RecomposeScopeImplKt.updateChangedFlags(i2 | 1), i3);
        return Unit.INSTANCE;
    }

    /* JADX WARN: Code duplicated, block: B:85:0x00f7  */
    /* JADX WARN: Code duplicated, block: B:88:0x014e  */
    public static final void a(Modifier modifier, final int i, final long j, final long j2, final float f, Shape shape, final Function0<Unit> function0, Composer composer, final int i2, final int i3) {
        Modifier modifier2;
        int i4;
        long j3;
        Shape shape2;
        Composer composer2;
        final Modifier modifier3;
        final Shape shape3;
        Modifier modifier4;
        Shape shape4;
        function0.getClass();
        Composer composerStartRestartGroup = composer.startRestartGroup(-235601331);
        int i5 = i3 & 1;
        if (i5 != 0) {
            i4 = i2 | 6;
            modifier2 = modifier;
        } else if ((i2 & 6) == 0) {
            modifier2 = modifier;
            i4 = (composerStartRestartGroup.changed(modifier2) ? 4 : 2) | i2;
        } else {
            modifier2 = modifier;
            i4 = i2;
        }
        if ((i2 & 48) == 0) {
            i4 |= composerStartRestartGroup.changed(i) ? 32 : 16;
        }
        if ((i2 & 384) == 0) {
            i4 |= composerStartRestartGroup.changed(j) ? 256 : 128;
        }
        if ((i2 & 3072) == 0) {
            j3 = j2;
            i4 |= composerStartRestartGroup.changed(j3) ? 2048 : 1024;
        } else {
            j3 = j2;
        }
        if ((i2 & 24576) == 0) {
            i4 |= composerStartRestartGroup.changed(f) ? 16384 : 8192;
        }
        if ((196608 & i2) == 0) {
            if ((i3 & 32) == 0) {
                shape2 = shape;
                int i6 = composerStartRestartGroup.changed(shape2) ? 131072 : 65536;
                i4 |= i6;
            } else {
                shape2 = shape;
            }
            i4 |= i6;
        } else {
            shape2 = shape;
        }
        if ((1572864 & i2) == 0) {
            i4 |= composerStartRestartGroup.changedInstance(function0) ? 1048576 : 524288;
        }
        if (composerStartRestartGroup.shouldExecute((599187 & i4) != 599186, i4 & 1)) {
            composerStartRestartGroup.startDefaults();
            if ((i2 & 1) == 0 || composerStartRestartGroup.getDefaultsInvalid()) {
                modifier4 = i5 != 0 ? Modifier.INSTANCE : modifier2;
                if ((i3 & 32) != 0) {
                    shape4 = FloatingActionButtonDefaults.INSTANCE.getShape(composerStartRestartGroup, FloatingActionButtonDefaults.$stable);
                    i4 &= -458753;
                }
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-235601331, i4, -1, "com.pspdfkit.internal.ui.dialog.signatures.composables.SignaturesFab (SignaturesFab.kt:31)");
                }
                composer2 = composerStartRestartGroup;
                Modifier modifier5 = modifier4;
                Shape shape5 = shape4;
                FloatingActionButtonKt.m3394FloatingActionButtonXz6DiA(function0, modifier5, shape5, j3, 0L, FloatingActionButtonDefaults.INSTANCE.m3374elevationxZ9QkE(f, 0.0f, 0.0f, 0.0f, composerStartRestartGroup, ((i4 >> 12) & 14) | (FloatingActionButtonDefaults.$stable << 12), 14), null, ComposableLambdaKt.rememberComposableLambda(-399947697, true, new Function2() { // from class: com.pspdfkit.internal.l20$$ExternalSyntheticLambda0
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return l20.a(i, j, (Composer) obj, ((Integer) obj2).intValue());
                    }
                }, composerStartRestartGroup, 54), composer2, ((i4 >> 18) & 14) | 12582912 | ((i4 << 3) & 112) | ((i4 >> 9) & 896) | (i4 & 7168), 80);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                modifier3 = modifier5;
                shape3 = shape5;
            } else {
                composerStartRestartGroup.skipToGroupEnd();
                if ((i3 & 32) != 0) {
                    i4 &= -458753;
                }
                modifier4 = modifier2;
            }
            shape4 = shape2;
            composerStartRestartGroup.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-235601331, i4, -1, "com.pspdfkit.internal.ui.dialog.signatures.composables.SignaturesFab (SignaturesFab.kt:31)");
            }
            composer2 = composerStartRestartGroup;
            Modifier modifier6 = modifier4;
            Shape shape6 = shape4;
            FloatingActionButtonKt.m3394FloatingActionButtonXz6DiA(function0, modifier6, shape6, j3, 0L, FloatingActionButtonDefaults.INSTANCE.m3374elevationxZ9QkE(f, 0.0f, 0.0f, 0.0f, composerStartRestartGroup, ((i4 >> 12) & 14) | (FloatingActionButtonDefaults.$stable << 12), 14), null, ComposableLambdaKt.rememberComposableLambda(-399947697, true, new Function2() { // from class: com.pspdfkit.internal.l20$$ExternalSyntheticLambda0
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return l20.a(i, j, (Composer) obj, ((Integer) obj2).intValue());
                }
            }, composerStartRestartGroup, 54), composer2, ((i4 >> 18) & 14) | 12582912 | ((i4 << 3) & 112) | ((i4 >> 9) & 896) | (i4 & 7168), 80);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            modifier3 = modifier6;
            shape3 = shape6;
        } else {
            composer2 = composerStartRestartGroup;
            composer2.skipToGroupEnd();
            modifier3 = modifier2;
            shape3 = shape2;
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.pspdfkit.internal.l20$$ExternalSyntheticLambda1
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return l20.a(modifier3, i, j, j2, f, shape3, function0, i2, i3, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    public static final Unit a(int i, long j, Composer composer, int i2) {
        if (composer.shouldExecute((i2 & 3) != 2, i2 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-399947697, i2, -1, "com.pspdfkit.internal.ui.dialog.signatures.composables.SignaturesFab.<anonymous> (SignaturesFab.kt:39)");
            }
            IconKt.m3575Iconww6aTOc(PainterResources_androidKt.painterResource(i, composer, 0), "", (Modifier) null, j, composer, Painter.$stable | 48, 4);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composer.skipToGroupEnd();
        }
        return Unit.INSTANCE;
    }
}
