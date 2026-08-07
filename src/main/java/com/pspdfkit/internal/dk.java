package com.pspdfkit.internal;

import android.content.Context;
import androidx.compose.animation.AnimatedVisibilityKt;
import androidx.compose.animation.AnimatedVisibilityScope;
import androidx.compose.animation.EnterTransition;
import androidx.compose.animation.ExitTransition;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.ColumnKt;
import androidx.compose.foundation.layout.ColumnScope;
import androidx.compose.foundation.layout.ColumnScopeInstance;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.material3.DividerKt;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.MutableIntState;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SnapshotIntStateKt;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.runtime.saveable.RememberSaveableKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.ColorKt;
import androidx.compose.ui.layout.LayoutCoordinates;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.layout.OnGloballyPositionedModifierKt;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.platform.AndroidCompositionLocals_androidKt;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.platform.TestTagKt;
import androidx.compose.ui.res.PrimitiveResources_androidKt;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.viewinterop.AndroidView_androidKt;
import androidx.core.content.ContextCompat;
import androidx.media3.common.C;
import androidx.media3.exoplayer.analytics.AnalyticsListener;
import androidx.profileinstaller.ProfileVerifier;
import com.pspdfkit.R;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;

/* JADX INFO: loaded from: classes3.dex */
public final class dk {
    public static final Unit a(ak akVar, com.pspdfkit.internal.ui.dialog.signatures.e.b bVar, yl.c cVar, Function0 function0, boolean z, boolean z2, boolean z3, Function1 function1, boolean z4, boolean z5, g20 g20Var, Modifier modifier, int i, int i2, int i3, Composer composer, int i4) {
        a(akVar, bVar, cVar, function0, z, z2, z3, function1, z4, z5, g20Var, modifier, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), RecomposeScopeImplKt.updateChangedFlags(i2), i3);
        return Unit.INSTANCE;
    }

    public static final MutableIntState b() {
        return SnapshotIntStateKt.mutableIntStateOf(0);
    }

    public static final Unit a(g20 g20Var, Function0 function0, AnimatedVisibilityScope animatedVisibilityScope, Composer composer, int i) {
        animatedVisibilityScope.getClass();
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1254275165, i, -1, "com.pspdfkit.internal.ui.dialog.signatures.composables.ImageElectronicSignatureScreen.<anonymous>.<anonymous>.<anonymous> (ImageElectronicSignatureScreen.kt:115)");
        }
        l20.a(TestTagKt.testTag(PaddingKt.m1222paddingqDBjuR0$default(Modifier.INSTANCE, 0.0f, 0.0f, PrimitiveResources_androidKt.dimensionResource(R.dimen.pspdf__signatures_fab_margin, composer, 0), PrimitiveResources_androidKt.dimensionResource(R.dimen.pspdf__signatures_fab_margin, composer, 0), 3, null), "PSPDF_PICKER_ADD_SIGNATURE_FAB"), g20Var.a, ColorKt.Color(g20Var.b), ColorKt.Color(g20Var.c), PrimitiveResources_androidKt.dimensionResource(R.dimen.pspdf__signatures_fab_elevation, composer, 0), null, function0, composer, 0, 32);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        return Unit.INSTANCE;
    }

    public static final void a(final ak akVar, final com.pspdfkit.internal.ui.dialog.signatures.e.b bVar, final yl.c cVar, final Function0<Unit> function0, final boolean z, final boolean z2, final boolean z3, final Function1<? super Boolean, Unit> function1, final boolean z4, final boolean z5, final g20 g20Var, Modifier modifier, Composer composer, final int i, final int i2, final int i3) {
        int i4;
        int i5;
        Modifier modifier2;
        final Modifier modifier3;
        akVar.getClass();
        bVar.getClass();
        cVar.getClass();
        function0.getClass();
        function1.getClass();
        g20Var.getClass();
        Composer composerStartRestartGroup = composer.startRestartGroup(787931145);
        if ((i & 6) == 0) {
            i4 = (composerStartRestartGroup.changedInstance(akVar) ? 4 : 2) | i;
        } else {
            i4 = i;
        }
        if ((i & 48) == 0) {
            i4 |= composerStartRestartGroup.changedInstance(bVar) ? 32 : 16;
        }
        if ((i & 384) == 0) {
            i4 |= (i & 512) == 0 ? composerStartRestartGroup.changed(cVar) : composerStartRestartGroup.changedInstance(cVar) ? 256 : 128;
        }
        if ((i & 3072) == 0) {
            i4 |= composerStartRestartGroup.changedInstance(function0) ? 2048 : 1024;
        }
        if ((i & 24576) == 0) {
            i4 |= composerStartRestartGroup.changed(z) ? 16384 : 8192;
        }
        if ((i & ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE) == 0) {
            i4 |= composerStartRestartGroup.changed(z2) ? 131072 : 65536;
        }
        if ((i & 1572864) == 0) {
            i4 |= composerStartRestartGroup.changed(z3) ? 1048576 : 524288;
        }
        if ((i & 12582912) == 0) {
            i4 |= composerStartRestartGroup.changedInstance(function1) ? 8388608 : 4194304;
        }
        if ((i & 100663296) == 0) {
            i4 |= composerStartRestartGroup.changed(z4) ? 67108864 : 33554432;
        }
        if ((i & 805306368) == 0) {
            i4 |= composerStartRestartGroup.changed(z5) ? C.BUFFER_FLAG_LAST_SAMPLE : 268435456;
        }
        if ((i2 & 6) == 0) {
            i5 = i2 | (composerStartRestartGroup.changed(g20Var) ? 4 : 2);
        } else {
            i5 = i2;
        }
        int i6 = i3 & 2048;
        if (i6 != 0) {
            i5 |= 48;
            modifier2 = modifier;
        } else {
            modifier2 = modifier;
            if ((i2 & 48) == 0) {
                i5 |= composerStartRestartGroup.changed(modifier2) ? 32 : 16;
            }
        }
        int i7 = i5;
        if (composerStartRestartGroup.shouldExecute(((i4 & 306783379) == 306783378 && (i7 & 19) == 18) ? false : true, i4 & 1)) {
            Modifier modifier4 = i6 != 0 ? Modifier.INSTANCE : modifier2;
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(787931145, i4, i7, "com.pspdfkit.internal.ui.dialog.signatures.composables.ImageElectronicSignatureScreen (ImageElectronicSignatureScreen.kt:52)");
            }
            final Context context = (Context) composerStartRestartGroup.consume(AndroidCompositionLocals_androidKt.getLocalContext());
            boolean z6 = z5 || z4;
            Density density = (Density) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalDensity());
            Object[] objArr = new Object[0];
            Object objRememberedValue = composerStartRestartGroup.rememberedValue();
            Composer.Companion companion = Composer.INSTANCE;
            boolean z7 = z6;
            if (objRememberedValue == companion.getEmpty()) {
                objRememberedValue = new Function0() { // from class: com.pspdfkit.internal.dk$$ExternalSyntheticLambda0
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return dk.a();
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
            }
            final MutableIntState mutableIntState = (MutableIntState) RememberSaveableKt.rememberSaveable(objArr, (Function0) objRememberedValue, composerStartRestartGroup, 48);
            Object[] objArr2 = new Object[0];
            Object objRememberedValue2 = composerStartRestartGroup.rememberedValue();
            if (objRememberedValue2 == companion.getEmpty()) {
                objRememberedValue2 = new Function0() { // from class: com.pspdfkit.internal.dk$$ExternalSyntheticLambda1
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return dk.b();
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
            }
            final MutableIntState mutableIntState2 = (MutableIntState) RememberSaveableKt.rememberSaveable(objArr2, (Function0) objRememberedValue2, composerStartRestartGroup, 48);
            int intValue = mutableIntState.getIntValue();
            boolean zChanged = composerStartRestartGroup.changed(mutableIntState2);
            Object objRememberedValue3 = composerStartRestartGroup.rememberedValue();
            if (zChanged || objRememberedValue3 == companion.getEmpty()) {
                objRememberedValue3 = new Function1() { // from class: com.pspdfkit.internal.dk$$ExternalSyntheticLambda2
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return dk.a(mutableIntState2, ((Integer) obj).intValue());
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
            }
            ze.a(z5, intValue, (Function1<? super Integer, Unit>) objRememberedValue3, composerStartRestartGroup, (i4 >> 27) & 14);
            Arrangement.Vertical top = Arrangement.INSTANCE.getTop();
            Alignment.Companion companion2 = Alignment.INSTANCE;
            MeasurePolicy measurePolicyColumnMeasurePolicy = ColumnKt.columnMeasurePolicy(top, companion2.getStart(), composerStartRestartGroup, 0);
            int iHashCode = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
            CompositionLocalMap currentCompositionLocalMap = composerStartRestartGroup.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifier4);
            Modifier modifier5 = modifier4;
            ComposeUiNode.Companion companion3 = ComposeUiNode.INSTANCE;
            Function0<ComposeUiNode> constructor = companion3.getConstructor();
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
            f2.a(companion3, composerM6062constructorimpl, measurePolicyColumnMeasurePolicy, composerM6062constructorimpl, currentCompositionLocalMap);
            Updater.m6070setimpl(composerM6062constructorimpl, modifierMaterializeModifier, (Function2<? super T, ? super Modifier, Unit>) e2.a(companion3, composerM6062constructorimpl, Integer.valueOf(iHashCode), composerM6062constructorimpl));
            ColumnScopeInstance columnScopeInstance = ColumnScopeInstance.INSTANCE;
            boolean zChangedInstance = composerStartRestartGroup.changedInstance(akVar) | composerStartRestartGroup.changedInstance(context) | composerStartRestartGroup.changedInstance(bVar) | ((i4 & 896) == 256 || ((i4 & 512) != 0 && composerStartRestartGroup.changedInstance(cVar)));
            Object objRememberedValue4 = composerStartRestartGroup.rememberedValue();
            if (zChangedInstance || objRememberedValue4 == companion.getEmpty()) {
                objRememberedValue4 = new Function1() { // from class: com.pspdfkit.internal.dk$$ExternalSyntheticLambda3
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return dk.a(akVar, context, bVar, cVar, (Context) obj);
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue4);
            }
            Function1 function2 = (Function1) objRememberedValue4;
            Modifier.Companion companion4 = Modifier.INSTANCE;
            Modifier modifierFillMaxSize$default = SizeKt.fillMaxSize$default(companion4, 0.0f, 1, null);
            boolean zChanged2 = composerStartRestartGroup.changed(mutableIntState);
            Object objRememberedValue5 = composerStartRestartGroup.rememberedValue();
            if (zChanged2 || objRememberedValue5 == companion.getEmpty()) {
                objRememberedValue5 = new Function1() { // from class: com.pspdfkit.internal.dk$$ExternalSyntheticLambda4
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return dk.a(mutableIntState, (LayoutCoordinates) obj);
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue5);
            }
            AndroidView_androidKt.AndroidView(function2, PaddingKt.m1220paddingVpY3zN4$default(ColumnScope.weight$default(columnScopeInstance, OnGloballyPositionedModifierKt.onGloballyPositioned(modifierFillMaxSize$default, (Function1) objRememberedValue5), 1.0f, false, 2, null), 0.0f, density.mo751toDpu2uoSUM(mutableIntState2.getIntValue()), 1, null), null, composerStartRestartGroup, 0, 4);
            if (z7) {
                composerStartRestartGroup.startReplaceGroup(1229822193);
                DividerKt.m3284HorizontalDivider9IZ8Weo(null, PrimitiveResources_androidKt.dimensionResource(R.dimen.pspdf__signatures_divider_height, composerStartRestartGroup, 0), ColorKt.Color(4289309099L), composerStartRestartGroup, 384, 1);
                composerStartRestartGroup.endReplaceGroup();
            } else {
                composerStartRestartGroup.startReplaceGroup(1229962499);
                composerStartRestartGroup.endReplaceGroup();
            }
            Modifier modifierFillMaxWidth$default = SizeKt.fillMaxWidth$default(companion4, 0.0f, 1, null);
            MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(companion2.getTopStart(), false);
            int iHashCode2 = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
            CompositionLocalMap currentCompositionLocalMap2 = composerStartRestartGroup.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier2 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierFillMaxWidth$default);
            Function0<ComposeUiNode> constructor2 = companion3.getConstructor();
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
            f2.a(companion3, composerM6062constructorimpl2, measurePolicyMaybeCachedBoxMeasurePolicy, composerM6062constructorimpl2, currentCompositionLocalMap2);
            Updater.m6070setimpl(composerM6062constructorimpl2, modifierMaterializeModifier2, (Function2<? super T, ? super Modifier, Unit>) e2.a(companion3, composerM6062constructorimpl2, Integer.valueOf(iHashCode2), composerM6062constructorimpl2));
            BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
            b00.a(z2, z3, function1, boxScopeInstance.align(PaddingKt.m1218padding3ABfNKs(companion4, PrimitiveResources_androidKt.dimensionResource(R.dimen.pspdf__electronic_signature_save_signature_chip_padding, composerStartRestartGroup, 0)), z7 ? companion2.getCenter() : companion2.getBottomStart()), composerStartRestartGroup, (i4 >> 15) & AnalyticsListener.EVENT_DRM_SESSION_ACQUIRED);
            AnimatedVisibilityKt.AnimatedVisibility(z, boxScopeInstance.align(PaddingKt.m1218padding3ABfNKs(companion4, PrimitiveResources_androidKt.dimensionResource(R.dimen.pspdf__signatures_fab_margin, composerStartRestartGroup, 0)), z7 ? companion2.getCenterEnd() : companion2.getBottomEnd()), (EnterTransition) null, (ExitTransition) null, (String) null, ComposableLambdaKt.rememberComposableLambda(1254275165, true, new Function3() { // from class: com.pspdfkit.internal.dk$$ExternalSyntheticLambda5
                @Override // kotlin.jvm.functions.Function3
                public final Object invoke(Object obj, Object obj2, Object obj3) {
                    return dk.a(g20Var, function0, (AnimatedVisibilityScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                }
            }, composerStartRestartGroup, 54), composerStartRestartGroup, ((i4 >> 12) & 14) | ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE, 28);
            composerStartRestartGroup.endNode();
            composerStartRestartGroup.endNode();
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
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.pspdfkit.internal.dk$$ExternalSyntheticLambda6
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return dk.a(akVar, bVar, cVar, function0, z, z2, z3, function1, z4, z5, g20Var, modifier3, i, i2, i3, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    public static final MutableIntState a() {
        return SnapshotIntStateKt.mutableIntStateOf(0);
    }

    public static final ak a(ak akVar, Context context, com.pspdfkit.internal.ui.dialog.signatures.e.b bVar, yl.c cVar, Context context2) {
        context2.getClass();
        akVar.setBackgroundColor(ContextCompat.getColor(context, R.color.pspdf__onPrimaryLight));
        akVar.setListener(bVar);
        akVar.setOnImagePickedListener(cVar);
        return akVar;
    }

    public static final Unit a(MutableIntState mutableIntState, LayoutCoordinates layoutCoordinates) {
        layoutCoordinates.getClass();
        mutableIntState.setIntValue((int) (layoutCoordinates.mo8273getSizeYbymL2g() & 4294967295L));
        return Unit.INSTANCE;
    }

    public static final Unit a(MutableIntState mutableIntState, int i) {
        mutableIntState.setIntValue(i);
        return Unit.INSTANCE;
    }
}
