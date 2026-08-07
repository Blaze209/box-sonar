package com.box.android.base.compose.textfield;

import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.ColumnKt;
import androidx.compose.foundation.layout.ColumnScopeInstance;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.layout.SpacerKt;
import androidx.compose.material.icons.Icons;
import androidx.compose.material.icons.outlined.CancelKt;
import androidx.compose.material3.IconKt;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.res.StringResources_androidKt;
import androidx.compose.ui.unit.Dp;
import com.box.android.base.R;
import com.box.android.base.compose.BoxTheme;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: BoxTextField.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
public final class ComposableSingletons$BoxTextFieldKt {
    public static final ComposableSingletons$BoxTextFieldKt INSTANCE = new ComposableSingletons$BoxTextFieldKt();
    private static Function2<Composer, Integer, Unit> lambda$841442392 = ComposableLambdaKt.composableLambdaInstance(841442392, false, new Function2() { // from class: com.box.android.base.compose.textfield.ComposableSingletons$BoxTextFieldKt$$ExternalSyntheticLambda6
        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(Object obj, Object obj2) {
            return ComposableSingletons$BoxTextFieldKt.lambda_841442392$lambda$0((Composer) obj, ((Integer) obj2).intValue());
        }
    });
    private static Function2<Composer, Integer, Unit> lambda$130184680 = ComposableLambdaKt.composableLambdaInstance(130184680, false, new Function2() { // from class: com.box.android.base.compose.textfield.ComposableSingletons$BoxTextFieldKt$$ExternalSyntheticLambda7
        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(Object obj, Object obj2) {
            return ComposableSingletons$BoxTextFieldKt.lambda_130184680$lambda$0((Composer) obj, ((Integer) obj2).intValue());
        }
    });

    public final Function2<Composer, Integer, Unit> getLambda$130184680$base_generalProdRelease() {
        return lambda$130184680;
    }

    public final Function2<Composer, Integer, Unit> getLambda$841442392$base_generalProdRelease() {
        return lambda$841442392;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit lambda_841442392$lambda$0(Composer composer, int i) {
        ComposerKt.sourceInformation(composer, "C211@8038L47,212@8119L6,209@7942L214:BoxTextField.kt#fjpkir");
        if (!composer.shouldExecute((i & 3) != 2, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(841442392, i, -1, "com.box.android.base.compose.textfield.ComposableSingletons$BoxTextFieldKt.lambda$841442392.<anonymous> (BoxTextField.kt:209)");
            }
            IconKt.m3576Iconww6aTOc(CancelKt.getCancel(Icons.Outlined.INSTANCE), StringResources_androidKt.stringResource(R.string.clear_text_field_label, composer, 0), (Modifier) null, BoxTheme.INSTANCE.getColors(composer, 6).m11513getContentSecondary0d7_KjU(), composer, 0, 4);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit lambda_130184680$lambda$0(Composer composer, int i) {
        ComposerKt.sourceInformation(composer, "C260@10235L2402:BoxTextField.kt#fjpkir");
        if (!composer.shouldExecute((i & 3) != 2, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(130184680, i, -1, "com.box.android.base.compose.textfield.ComposableSingletons$BoxTextFieldKt.lambda$130184680.<anonymous> (BoxTextField.kt:260)");
            }
            float f = 16;
            Modifier modifierM1218padding3ABfNKs = PaddingKt.m1218padding3ABfNKs(SizeKt.fillMaxSize$default(Modifier.INSTANCE, 0.0f, 1, null), Dp.m9687constructorimpl(f));
            ComposerKt.sourceInformationMarkerStart(composer, 1341605231, "CC(Column)N(modifier,verticalArrangement,horizontalAlignment,content)87@4443L61,88@4509L134:Column.kt#2w3rfo");
            MeasurePolicy measurePolicyColumnMeasurePolicy = ColumnKt.columnMeasurePolicy(Arrangement.INSTANCE.getTop(), Alignment.INSTANCE.getStart(), composer, 0);
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
            Updater.m6070setimpl(composerM6062constructorimpl, measurePolicyColumnMeasurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
            Updater.m6070setimpl(composerM6062constructorimpl, currentCompositionLocalMap, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
            Updater.m6066initimpl(composerM6062constructorimpl, Integer.valueOf(iHashCode), ComposeUiNode.INSTANCE.getSetCompositeKeyHash());
            Updater.m6068reconcileimpl(composerM6062constructorimpl, ComposeUiNode.INSTANCE.getApplyOnDeactivatedNodeAssertion());
            Updater.m6070setimpl(composerM6062constructorimpl, modifierMaterializeModifier, ComposeUiNode.INSTANCE.getSetModifier());
            ComposerKt.sourceInformationMarkerStart(composer, 2093002350, "C89@4557L9:Column.kt#2w3rfo");
            ColumnScopeInstance columnScopeInstance = ColumnScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart(composer, 1902400236, "C272@10657L3,265@10362L312,274@10687L28,282@11053L3,275@10728L379,285@11120L28,293@11492L3,286@11161L348,295@11522L28,303@11867L3,296@11563L321,305@11897L28,313@12237L3,306@11938L316,315@12267L28,323@12610L3,316@12308L319:BoxTextField.kt#fjpkir");
            ComposerKt.sourceInformationMarkerStart(composer, 1723942913, "CC(remember):BoxTextField.kt#9igjgp");
            Object objRememberedValue = composer.rememberedValue();
            if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                objRememberedValue = new Function1() { // from class: com.box.android.base.compose.textfield.ComposableSingletons$BoxTextFieldKt$$ExternalSyntheticLambda0
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return ComposableSingletons$BoxTextFieldKt.lambda_130184680$lambda$0$0$0$0((String) obj);
                    }
                };
                composer.updateRememberedValue(objRememberedValue);
            }
            ComposerKt.sourceInformationMarkerEnd(composer);
            BoxTextFieldKt.BoxTextField("Default State", (Function1) objRememberedValue, null, true, false, "Default State Label", "Default State Hint", null, false, 0, 0, null, null, composer, 14380086, 0, 7940);
            SpacerKt.Spacer(SizeKt.m1266size3ABfNKs(Modifier.INSTANCE, Dp.m9687constructorimpl(f)), composer, 6);
            ComposerKt.sourceInformationMarkerStart(composer, 1723955585, "CC(remember):BoxTextField.kt#9igjgp");
            Object objRememberedValue2 = composer.rememberedValue();
            if (objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                objRememberedValue2 = new Function1() { // from class: com.box.android.base.compose.textfield.ComposableSingletons$BoxTextFieldKt$$ExternalSyntheticLambda1
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return ComposableSingletons$BoxTextFieldKt.lambda_130184680$lambda$0$0$1$0((String) obj);
                    }
                };
                composer.updateRememberedValue(objRememberedValue2);
            }
            ComposerKt.sourceInformationMarkerEnd(composer);
            BoxTextFieldKt.BoxTextField("Focused with Text State", (Function1) objRememberedValue2, null, true, false, "Focused with Text State Label", "Focused with Text State Hint", null, true, 0, 0, null, null, composer, 115043382, 0, 7684);
            SpacerKt.Spacer(SizeKt.m1266size3ABfNKs(Modifier.INSTANCE, Dp.m9687constructorimpl(f)), composer, 6);
            ComposerKt.sourceInformationMarkerStart(composer, 1723969633, "CC(remember):BoxTextField.kt#9igjgp");
            Object objRememberedValue3 = composer.rememberedValue();
            if (objRememberedValue3 == Composer.INSTANCE.getEmpty()) {
                objRememberedValue3 = new Function1() { // from class: com.box.android.base.compose.textfield.ComposableSingletons$BoxTextFieldKt$$ExternalSyntheticLambda2
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return ComposableSingletons$BoxTextFieldKt.lambda_130184680$lambda$0$0$2$0((String) obj);
                    }
                };
                composer.updateRememberedValue(objRememberedValue3);
            }
            ComposerKt.sourceInformationMarkerEnd(composer);
            BoxTextFieldKt.BoxTextField("Request in Progress State", (Function1) objRememberedValue3, null, false, true, "Request in Progress State Label", "Request in Progress State Hint", null, false, 0, 0, null, null, composer, 14380086, 0, 7940);
            SpacerKt.Spacer(SizeKt.m1266size3ABfNKs(Modifier.INSTANCE, Dp.m9687constructorimpl(f)), composer, 6);
            ComposerKt.sourceInformationMarkerStart(composer, 1723981633, "CC(remember):BoxTextField.kt#9igjgp");
            Object objRememberedValue4 = composer.rememberedValue();
            if (objRememberedValue4 == Composer.INSTANCE.getEmpty()) {
                objRememberedValue4 = new Function1() { // from class: com.box.android.base.compose.textfield.ComposableSingletons$BoxTextFieldKt$$ExternalSyntheticLambda3
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return ComposableSingletons$BoxTextFieldKt.lambda_130184680$lambda$0$0$3$0((String) obj);
                    }
                };
                composer.updateRememberedValue(objRememberedValue4);
            }
            ComposerKt.sourceInformationMarkerEnd(composer);
            BoxTextFieldKt.BoxTextField("Error State", (Function1) objRememberedValue4, null, true, false, "Error State Label", "Error State Hint", "There is an Error", false, 0, 0, null, null, composer, 14380086, 0, 7940);
            SpacerKt.Spacer(SizeKt.m1266size3ABfNKs(Modifier.INSTANCE, Dp.m9687constructorimpl(f)), composer, 6);
            ComposerKt.sourceInformationMarkerStart(composer, 1723993473, "CC(remember):BoxTextField.kt#9igjgp");
            Object objRememberedValue5 = composer.rememberedValue();
            if (objRememberedValue5 == Composer.INSTANCE.getEmpty()) {
                objRememberedValue5 = new Function1() { // from class: com.box.android.base.compose.textfield.ComposableSingletons$BoxTextFieldKt$$ExternalSyntheticLambda4
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return ComposableSingletons$BoxTextFieldKt.lambda_130184680$lambda$0$0$4$0((String) obj);
                    }
                };
                composer.updateRememberedValue(objRememberedValue5);
            }
            ComposerKt.sourceInformationMarkerEnd(composer);
            BoxTextFieldKt.BoxTextField("Disabled State", (Function1) objRememberedValue5, null, false, false, "Disabled State Label", "Disabled State Hint", null, false, 0, 0, null, null, composer, 14380086, 0, 7940);
            SpacerKt.Spacer(SizeKt.m1266size3ABfNKs(Modifier.INSTANCE, Dp.m9687constructorimpl(f)), composer, 6);
            ComposerKt.sourceInformationMarkerStart(composer, 1724005409, "CC(remember):BoxTextField.kt#9igjgp");
            Object objRememberedValue6 = composer.rememberedValue();
            if (objRememberedValue6 == Composer.INSTANCE.getEmpty()) {
                objRememberedValue6 = new Function1() { // from class: com.box.android.base.compose.textfield.ComposableSingletons$BoxTextFieldKt$$ExternalSyntheticLambda5
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return ComposableSingletons$BoxTextFieldKt.lambda_130184680$lambda$0$0$5$0((String) obj);
                    }
                };
                composer.updateRememberedValue(objRememberedValue6);
            }
            ComposerKt.sourceInformationMarkerEnd(composer);
            BoxTextFieldKt.BoxTextField("", (Function1) objRememberedValue6, null, true, false, "Unfocused No Text State Label", "Unfocused No Text State Hint", null, false, 0, 0, null, null, composer, 14380086, 0, 7940);
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

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit lambda_130184680$lambda$0$0$0$0(String it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit lambda_130184680$lambda$0$0$1$0(String it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit lambda_130184680$lambda$0$0$2$0(String it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit lambda_130184680$lambda$0$0$3$0(String it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit lambda_130184680$lambda$0$0$4$0(String it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit lambda_130184680$lambda$0$0$5$0(String it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return Unit.INSTANCE;
    }
}
