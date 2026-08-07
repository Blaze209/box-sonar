package com.pspdfkit.internal;

import android.content.Context;
import android.view.View;
import androidx.compose.animation.AnimatedVisibilityKt;
import androidx.compose.animation.AnimatedVisibilityScope;
import androidx.compose.animation.EnterTransition;
import androidx.compose.animation.ExitTransition;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScopeInstance;
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
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.viewinterop.AndroidView_androidKt;
import androidx.profileinstaller.ProfileVerifier;
import com.pspdfkit.R;
import com.pspdfkit.internal.ui.dialog.signatures.SaveSignatureChip;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;

/* JADX INFO: loaded from: classes3.dex */
public final class b00 {
    public static final Unit a(boolean z, boolean z2, Function1 function1, Modifier modifier, int i, Composer composer, int i2) {
        a(z, z2, function1, modifier, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    public static final void a(boolean z, final boolean z2, final Function1<? super Boolean, Unit> function1, Modifier modifier, Composer composer, final int i) {
        int i2;
        boolean z3;
        final Modifier modifier2;
        function1.getClass();
        modifier.getClass();
        Composer composerStartRestartGroup = composer.startRestartGroup(-2104872988);
        if ((i & 6) == 0) {
            i2 = (composerStartRestartGroup.changed(z) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 48) == 0) {
            i2 |= composerStartRestartGroup.changed(z2) ? 32 : 16;
        }
        if ((i & 384) == 0) {
            i2 |= composerStartRestartGroup.changedInstance(function1) ? 256 : 128;
        }
        if ((i & 3072) == 0) {
            i2 |= composerStartRestartGroup.changed(modifier) ? 2048 : 1024;
        }
        if (composerStartRestartGroup.shouldExecute((i2 & 1171) != 1170, i2 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-2104872988, i2, -1, "com.pspdfkit.internal.ui.dialog.signatures.composables.SaveSignature (SaveSignature.kt:25)");
            }
            z3 = z;
            AnimatedVisibilityKt.AnimatedVisibility(z3, modifier, (EnterTransition) null, (ExitTransition) null, (String) null, ComposableLambdaKt.rememberComposableLambda(-460521972, true, new Function3() { // from class: com.pspdfkit.internal.b00$$ExternalSyntheticLambda1
                @Override // kotlin.jvm.functions.Function3
                public final Object invoke(Object obj, Object obj2, Object obj3) {
                    return b00.a(z2, function1, (AnimatedVisibilityScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                }
            }, composerStartRestartGroup, 54), composerStartRestartGroup, (i2 & 14) | ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE | ((i2 >> 6) & 112), 28);
            modifier2 = modifier;
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            z3 = z;
            modifier2 = modifier;
            composerStartRestartGroup.skipToGroupEnd();
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            final boolean z4 = z3;
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.pspdfkit.internal.b00$$ExternalSyntheticLambda2
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return b00.a(z4, z2, function1, modifier2, i, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    public static final Unit a(final boolean z, final Function1 function1, AnimatedVisibilityScope animatedVisibilityScope, Composer composer, int i) {
        animatedVisibilityScope.getClass();
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-460521972, i, -1, "com.pspdfkit.internal.ui.dialog.signatures.composables.SaveSignature.<anonymous> (SaveSignature.kt:30)");
        }
        Modifier.Companion companion = Modifier.INSTANCE;
        MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), false);
        int iHashCode = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composer, 0));
        CompositionLocalMap currentCompositionLocalMap = composer.getCurrentCompositionLocalMap();
        Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composer, companion);
        ComposeUiNode.Companion companion2 = ComposeUiNode.INSTANCE;
        Function0<ComposeUiNode> constructor = companion2.getConstructor();
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
        f2.a(companion2, composerM6062constructorimpl, measurePolicyMaybeCachedBoxMeasurePolicy, composerM6062constructorimpl, currentCompositionLocalMap);
        Updater.m6070setimpl(composerM6062constructorimpl, modifierMaterializeModifier, (Function2<? super T, ? super Modifier, Unit>) e2.a(companion2, composerM6062constructorimpl, Integer.valueOf(iHashCode), composerM6062constructorimpl));
        BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
        boolean zChanged = composer.changed(z) | composer.changed(function1);
        Object objRememberedValue = composer.rememberedValue();
        if (zChanged || objRememberedValue == Composer.INSTANCE.getEmpty()) {
            objRememberedValue = new Function1() { // from class: com.pspdfkit.internal.b00$$ExternalSyntheticLambda3
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    return b00.a(z, function1, (Context) obj);
                }
            };
            composer.updateRememberedValue(objRememberedValue);
        }
        AndroidView_androidKt.AndroidView((Function1) objRememberedValue, null, null, composer, 0, 6);
        composer.endNode();
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        return Unit.INSTANCE;
    }

    public static final SaveSignatureChip a(boolean z, final Function1 function1, Context context) {
        context.getClass();
        final SaveSignatureChip saveSignatureChip = new SaveSignatureChip(context);
        saveSignatureChip.setText(context.getString(R.string.pspdf__electronic_signature_save_signature));
        saveSignatureChip.setSelected(z);
        saveSignatureChip.setOnClickListener(new View.OnClickListener() { // from class: com.pspdfkit.internal.b00$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                b00.a(saveSignatureChip, function1, view);
            }
        });
        return saveSignatureChip;
    }

    public static final void a(SaveSignatureChip saveSignatureChip, Function1 function1, View view) {
        saveSignatureChip.setSelected(!saveSignatureChip.isSelected());
        function1.invoke(Boolean.valueOf(saveSignatureChip.isSelected()));
    }
}
