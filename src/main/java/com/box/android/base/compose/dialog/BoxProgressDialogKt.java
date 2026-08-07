package com.box.android.base.compose.dialog;

import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.RowKt;
import androidx.compose.foundation.layout.RowScopeInstance;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.layout.SpacerKt;
import androidx.compose.material3.AlertDialogDefaults;
import androidx.compose.material3.AlertDialogKt;
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
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.unit.Dp;
import com.box.android.base.compose.BoxTheme;
import com.box.android.base.compose.ComposeUtilsKt;
import com.box.android.base.compose.progressbar.BoxCircularProgressBarKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: BoxProgressDialog.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\u001a\u0015\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\u0007¢\u0006\u0002\u0010\u0004¨\u0006\u0005"}, d2 = {"BoxProgressDialog", "", "message", "", "(Ljava/lang/String;Landroidx/compose/runtime/Composer;I)V", "base_generalProdRelease"}, k = 2, mv = {2, 2, 0}, xi = 48)
public final class BoxProgressDialogKt {
    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit BoxProgressDialog$lambda$2(String str, int i, Composer composer, int i2) {
        BoxProgressDialog(str, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    public static final void BoxProgressDialog(final String message, Composer composer, final int i) {
        int i2;
        Intrinsics.checkNotNullParameter(message, "message");
        Composer composerStartRestartGroup = composer.startRestartGroup(-1847247231);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(BoxProgressDialog)N(message)24@1027L3,24@1032L653,24@991L694:BoxProgressDialog.kt#fwd9q");
        if ((i & 6) == 0) {
            i2 = (composerStartRestartGroup.changed(message) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if (!composerStartRestartGroup.shouldExecute((i2 & 3) != 2, i2 & 1)) {
            composerStartRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1847247231, i2, -1, "com.box.android.base.compose.dialog.BoxProgressDialog (BoxProgressDialog.kt:23)");
            }
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1383093148, "CC(remember):BoxProgressDialog.kt#9igjgp");
            Object objRememberedValue = composerStartRestartGroup.rememberedValue();
            if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                objRememberedValue = new Function0() { // from class: com.box.android.base.compose.dialog.BoxProgressDialogKt$$ExternalSyntheticLambda0
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return Unit.INSTANCE;
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
            }
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            AlertDialogKt.BasicAlertDialog((Function0) objRememberedValue, null, null, ComposableLambdaKt.rememberComposableLambda(-854755449, true, new Function2() { // from class: com.box.android.base.compose.dialog.BoxProgressDialogKt$$ExternalSyntheticLambda1
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return BoxProgressDialogKt.BoxProgressDialog$lambda$1(message, (Composer) obj, ((Integer) obj2).intValue());
                }
            }, composerStartRestartGroup, 54), composerStartRestartGroup, 3078, 6);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.box.android.base.compose.dialog.BoxProgressDialogKt$$ExternalSyntheticLambda2
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return BoxProgressDialogKt.BoxProgressDialog$lambda$2(message, i, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit BoxProgressDialog$lambda$1(String str, Composer composer, int i) {
        ComposerKt.sourceInformation(composer, "C31@1279L6,32@1351L5,25@1042L637:BoxProgressDialog.kt#fwd9q");
        if (!composer.shouldExecute((i & 3) != 2, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-854755449, i, -1, "com.box.android.base.compose.dialog.BoxProgressDialog.<anonymous> (BoxProgressDialog.kt:25)");
            }
            Alignment.Vertical centerVertically = Alignment.INSTANCE.getCenterVertically();
            Modifier modifierM1218padding3ABfNKs = PaddingKt.m1218padding3ABfNKs(BackgroundKt.m588backgroundbw27NRU(SizeKt.fillMaxWidth$default(ComposeUtilsKt.dialogSemantics(Modifier.INSTANCE, str), 0.0f, 1, null), BoxTheme.INSTANCE.getColors(composer, 6).m11516getDialogContainer0d7_KjU(), AlertDialogDefaults.INSTANCE.getShape(composer, AlertDialogDefaults.$stable)), Dp.m9687constructorimpl(24));
            ComposerKt.sourceInformationMarkerStart(composer, 844473419, "CC(Row)N(modifier,horizontalArrangement,verticalAlignment,content)99@5125L58,100@5188L131:Row.kt#2w3rfo");
            MeasurePolicy measurePolicyRowMeasurePolicy = RowKt.rowMeasurePolicy(Arrangement.INSTANCE.getStart(), centerVertically, composer, 48);
            ComposerKt.sourceInformationMarkerStart(composer, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
            int iHashCode = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composer, 0));
            CompositionLocalMap currentCompositionLocalMap = composer.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composer, modifierM1218padding3ABfNKs);
            Function0<ComposeUiNode> constructor = ComposeUiNode.INSTANCE.getConstructor();
            ComposerKt.sourceInformationMarkerStart(composer, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
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
            Updater.m6070setimpl(composerM6062constructorimpl, measurePolicyRowMeasurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
            Updater.m6070setimpl(composerM6062constructorimpl, currentCompositionLocalMap, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
            Updater.m6066initimpl(composerM6062constructorimpl, Integer.valueOf(iHashCode), ComposeUiNode.INSTANCE.getSetCompositeKeyHash());
            Updater.m6068reconcileimpl(composerM6062constructorimpl, ComposeUiNode.INSTANCE.getApplyOnDeactivatedNodeAssertion());
            Updater.m6070setimpl(composerM6062constructorimpl, modifierMaterializeModifier, ComposeUiNode.INSTANCE.getSetModifier());
            ComposerKt.sourceInformationMarkerStart(composer, 1456264949, "C101@5233L9:Row.kt#2w3rfo");
            RowScopeInstance rowScopeInstance = RowScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart(composer, -1785506486, "C36@1431L24,37@1468L29,41@1638L6,38@1510L159:BoxProgressDialog.kt#fwd9q");
            BoxCircularProgressBarKt.m11734BoxCircularProgressBarO8KfPlw(null, null, 0L, 0L, 0.0f, 0, null, composer, 0, 127);
            SpacerKt.Spacer(SizeKt.m1271width3ABfNKs(Modifier.INSTANCE, Dp.m9687constructorimpl(16)), composer, 6);
            TextKt.m4494TextNvy7gAk(str, null, BoxTheme.INSTANCE.getColors(composer, 6).m11500getAppPrimary0d7_KjU(), null, 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, BoxTheme.INSTANCE.getTypography().getBoxNormal16(), composer, 0, 12582912, 131066);
            ComposerKt.sourceInformationMarkerEnd(composer);
            ComposerKt.sourceInformationMarkerEnd(composer);
            composer.endNode();
            ComposerKt.sourceInformationMarkerEnd(composer);
            ComposerKt.sourceInformationMarkerEnd(composer);
            ComposerKt.sourceInformationMarkerEnd(composer);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }
}
