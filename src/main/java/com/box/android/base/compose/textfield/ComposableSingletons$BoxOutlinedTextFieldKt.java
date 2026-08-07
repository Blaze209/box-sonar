package com.box.android.base.compose.textfield;

import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.ColumnKt;
import androidx.compose.foundation.layout.ColumnScopeInstance;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.layout.SpacerKt;
import androidx.compose.material3.TextKt;
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
import androidx.compose.ui.unit.Dp;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: BoxOutlinedTextField.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
public final class ComposableSingletons$BoxOutlinedTextFieldKt {
    public static final ComposableSingletons$BoxOutlinedTextFieldKt INSTANCE = new ComposableSingletons$BoxOutlinedTextFieldKt();
    private static Function2<Composer, Integer, Unit> lambda$1539362675 = ComposableLambdaKt.composableLambdaInstance(1539362675, false, new Function2() { // from class: com.box.android.base.compose.textfield.ComposableSingletons$BoxOutlinedTextFieldKt$$ExternalSyntheticLambda0
        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(Object obj, Object obj2) {
            return ComposableSingletons$BoxOutlinedTextFieldKt.lambda_1539362675$lambda$0((Composer) obj, ((Integer) obj2).intValue());
        }
    });

    /* JADX INFO: renamed from: lambda$-592302412, reason: not valid java name */
    private static Function2<Composer, Integer, Unit> f182lambda$592302412 = ComposableLambdaKt.composableLambdaInstance(-592302412, false, new Function2() { // from class: com.box.android.base.compose.textfield.ComposableSingletons$BoxOutlinedTextFieldKt$$ExternalSyntheticLambda1
        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(Object obj, Object obj2) {
            return ComposableSingletons$BoxOutlinedTextFieldKt.lambda__592302412$lambda$0((Composer) obj, ((Integer) obj2).intValue());
        }
    });
    private static Function2<Composer, Integer, Unit> lambda$802565162 = ComposableLambdaKt.composableLambdaInstance(802565162, false, new Function2() { // from class: com.box.android.base.compose.textfield.ComposableSingletons$BoxOutlinedTextFieldKt$$ExternalSyntheticLambda2
        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(Object obj, Object obj2) {
            return ComposableSingletons$BoxOutlinedTextFieldKt.lambda_802565162$lambda$0((Composer) obj, ((Integer) obj2).intValue());
        }
    });
    private static Function2<Composer, Integer, Unit> lambda$971816747 = ComposableLambdaKt.composableLambdaInstance(971816747, false, new Function2() { // from class: com.box.android.base.compose.textfield.ComposableSingletons$BoxOutlinedTextFieldKt$$ExternalSyntheticLambda3
        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(Object obj, Object obj2) {
            return ComposableSingletons$BoxOutlinedTextFieldKt.lambda_971816747$lambda$0((Composer) obj, ((Integer) obj2).intValue());
        }
    });
    private static Function2<Composer, Integer, Unit> lambda$234592939 = ComposableLambdaKt.composableLambdaInstance(234592939, false, new Function2() { // from class: com.box.android.base.compose.textfield.ComposableSingletons$BoxOutlinedTextFieldKt$$ExternalSyntheticLambda4
        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(Object obj, Object obj2) {
            return ComposableSingletons$BoxOutlinedTextFieldKt.lambda_234592939$lambda$0((Composer) obj, ((Integer) obj2).intValue());
        }
    });
    private static Function2<Composer, Integer, Unit> lambda$879265388 = ComposableLambdaKt.composableLambdaInstance(879265388, false, new Function2() { // from class: com.box.android.base.compose.textfield.ComposableSingletons$BoxOutlinedTextFieldKt$$ExternalSyntheticLambda5
        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(Object obj, Object obj2) {
            return ComposableSingletons$BoxOutlinedTextFieldKt.lambda_879265388$lambda$0((Composer) obj, ((Integer) obj2).intValue());
        }
    });

    /* JADX INFO: renamed from: getLambda$-592302412$base_generalProdRelease, reason: not valid java name */
    public final Function2<Composer, Integer, Unit> m11766getLambda$592302412$base_generalProdRelease() {
        return f182lambda$592302412;
    }

    public final Function2<Composer, Integer, Unit> getLambda$1539362675$base_generalProdRelease() {
        return lambda$1539362675;
    }

    public final Function2<Composer, Integer, Unit> getLambda$234592939$base_generalProdRelease() {
        return lambda$234592939;
    }

    public final Function2<Composer, Integer, Unit> getLambda$802565162$base_generalProdRelease() {
        return lambda$802565162;
    }

    public final Function2<Composer, Integer, Unit> getLambda$879265388$base_generalProdRelease() {
        return lambda$879265388;
    }

    public final Function2<Composer, Integer, Unit> getLambda$971816747$base_generalProdRelease() {
        return lambda$971816747;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit lambda_879265388$lambda$0(Composer composer, int i) {
        ComposerKt.sourceInformation(composer, "C114@5056L910:BoxOutlinedTextField.kt#fjpkir");
        if (!composer.shouldExecute((i & 3) != 2, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(879265388, i, -1, "com.box.android.base.compose.textfield.ComposableSingletons$BoxOutlinedTextFieldKt.lambda$879265388.<anonymous> (BoxOutlinedTextField.kt:114)");
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
            ComposerKt.sourceInformationMarkerStart(composer, -1339573444, "C123@5372L3,119@5183L206,125@5402L28,132@5695L3,126@5443L269,134@5725L28,139@5939L3,135@5766L190:BoxOutlinedTextField.kt#fjpkir");
            ComposerKt.sourceInformationMarkerStart(composer, 1757908549, "CC(remember):BoxOutlinedTextField.kt#9igjgp");
            Object objRememberedValue = composer.rememberedValue();
            if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                objRememberedValue = new Function1() { // from class: com.box.android.base.compose.textfield.ComposableSingletons$BoxOutlinedTextFieldKt$$ExternalSyntheticLambda6
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return ComposableSingletons$BoxOutlinedTextFieldKt.lambda_879265388$lambda$0$0$0$0((String) obj);
                    }
                };
                composer.updateRememberedValue(objRememberedValue);
            }
            ComposerKt.sourceInformationMarkerEnd(composer);
            BoxOutlinedTextFieldKt.m11739BoxOutlinedTextFieldhtLuCmU("Sample text", (Function1) objRememberedValue, null, false, lambda$1539362675, f182lambda$592302412, 0, 0, false, 0L, null, null, composer, 221238, 0, 4044);
            SpacerKt.Spacer(SizeKt.m1266size3ABfNKs(Modifier.INSTANCE, Dp.m9687constructorimpl(f)), composer, 6);
            ComposerKt.sourceInformationMarkerStart(composer, 1757918885, "CC(remember):BoxOutlinedTextField.kt#9igjgp");
            Object objRememberedValue2 = composer.rememberedValue();
            if (objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                objRememberedValue2 = new Function1() { // from class: com.box.android.base.compose.textfield.ComposableSingletons$BoxOutlinedTextFieldKt$$ExternalSyntheticLambda7
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return ComposableSingletons$BoxOutlinedTextFieldKt.lambda_879265388$lambda$0$0$1$0((String) obj);
                    }
                };
                composer.updateRememberedValue(objRememberedValue2);
            }
            ComposerKt.sourceInformationMarkerEnd(composer);
            BoxOutlinedTextFieldKt.m11739BoxOutlinedTextFieldhtLuCmU("", (Function1) objRememberedValue2, null, false, lambda$802565162, lambda$971816747, 2, 4, false, 0L, null, null, composer, 14377014, 0, 3852);
            SpacerKt.Spacer(SizeKt.m1266size3ABfNKs(Modifier.INSTANCE, Dp.m9687constructorimpl(f)), composer, 6);
            ComposerKt.sourceInformationMarkerStart(composer, 1757926693, "CC(remember):BoxOutlinedTextField.kt#9igjgp");
            Object objRememberedValue3 = composer.rememberedValue();
            if (objRememberedValue3 == Composer.INSTANCE.getEmpty()) {
                objRememberedValue3 = new Function1() { // from class: com.box.android.base.compose.textfield.ComposableSingletons$BoxOutlinedTextFieldKt$$ExternalSyntheticLambda8
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return ComposableSingletons$BoxOutlinedTextFieldKt.lambda_879265388$lambda$0$0$2$0((String) obj);
                    }
                };
                composer.updateRememberedValue(objRememberedValue3);
            }
            ComposerKt.sourceInformationMarkerEnd(composer);
            BoxOutlinedTextFieldKt.m11739BoxOutlinedTextFieldhtLuCmU("Disabled state", (Function1) objRememberedValue3, null, false, lambda$234592939, null, 0, 0, false, 0L, null, null, composer, 27702, 0, 4068);
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
    public static final Unit lambda_1539362675$lambda$0(Composer composer, int i) {
        ComposerKt.sourceInformation(composer, "C121@5269L13:BoxOutlinedTextField.kt#fjpkir");
        if (composer.shouldExecute((i & 3) != 2, i & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1539362675, i, -1, "com.box.android.base.compose.textfield.ComposableSingletons$BoxOutlinedTextFieldKt.lambda$1539362675.<anonymous> (BoxOutlinedTextField.kt:121)");
            }
            TextKt.m4494TextNvy7gAk("Label", null, 0L, null, 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, null, composer, 6, 0, 262142);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composer.skipToGroupEnd();
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit lambda__592302412$lambda$0(Composer composer, int i) {
        ComposerKt.sourceInformation(composer, "C122@5318L19:BoxOutlinedTextField.kt#fjpkir");
        if (composer.shouldExecute((i & 3) != 2, i & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-592302412, i, -1, "com.box.android.base.compose.textfield.ComposableSingletons$BoxOutlinedTextFieldKt.lambda$-592302412.<anonymous> (BoxOutlinedTextField.kt:122)");
            }
            TextKt.m4494TextNvy7gAk("Placeholder", null, 0L, null, 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, null, composer, 6, 0, 262142);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composer.skipToGroupEnd();
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit lambda_879265388$lambda$0$0$0$0(String it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit lambda_802565162$lambda$0(Composer composer, int i) {
        ComposerKt.sourceInformation(composer, "C128@5518L18:BoxOutlinedTextField.kt#fjpkir");
        if (composer.shouldExecute((i & 3) != 2, i & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(802565162, i, -1, "com.box.android.base.compose.textfield.ComposableSingletons$BoxOutlinedTextFieldKt.lambda$802565162.<anonymous> (BoxOutlinedTextField.kt:128)");
            }
            TextKt.m4494TextNvy7gAk("Multi-line", null, 0L, null, 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, null, composer, 6, 0, 262142);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composer.skipToGroupEnd();
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit lambda_971816747$lambda$0(Composer composer, int i) {
        ComposerKt.sourceInformation(composer, "C129@5572L28:BoxOutlinedTextField.kt#fjpkir");
        if (composer.shouldExecute((i & 3) != 2, i & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(971816747, i, -1, "com.box.android.base.compose.textfield.ComposableSingletons$BoxOutlinedTextFieldKt.lambda$971816747.<anonymous> (BoxOutlinedTextField.kt:129)");
            }
            TextKt.m4494TextNvy7gAk("Enter multiple lines", null, 0L, null, 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, null, composer, 6, 0, 262142);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composer.skipToGroupEnd();
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit lambda_879265388$lambda$0$0$1$0(String it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit lambda_234592939$lambda$0(Composer composer, int i) {
        ComposerKt.sourceInformation(composer, "C137@5855L16:BoxOutlinedTextField.kt#fjpkir");
        if (composer.shouldExecute((i & 3) != 2, i & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(234592939, i, -1, "com.box.android.base.compose.textfield.ComposableSingletons$BoxOutlinedTextFieldKt.lambda$234592939.<anonymous> (BoxOutlinedTextField.kt:137)");
            }
            TextKt.m4494TextNvy7gAk("Disabled", null, 0L, null, 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, null, composer, 6, 0, 262142);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composer.skipToGroupEnd();
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit lambda_879265388$lambda$0$0$2$0(String it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return Unit.INSTANCE;
    }
}
