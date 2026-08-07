package com.box.android.boxai.prompt;

import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.material.icons.Icons;
import androidx.compose.material.icons.filled.MicKt;
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
import androidx.compose.ui.graphics.vector.VectorPainter;
import androidx.compose.ui.graphics.vector.VectorPainterKt;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.res.StringResources_androidKt;
import androidx.compose.ui.unit.Dp;
import com.box.android.boxai.R;
import com.box.android.boxai.ui.BoxAITheme;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;

/* JADX INFO: compiled from: BoxAiPromptInputBox.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
public final class ComposableSingletons$BoxAiPromptInputBoxKt {
    public static final ComposableSingletons$BoxAiPromptInputBoxKt INSTANCE = new ComposableSingletons$BoxAiPromptInputBoxKt();
    private static Function2<Composer, Integer, Unit> lambda$2031708606 = ComposableLambdaKt.composableLambdaInstance(2031708606, false, new Function2() { // from class: com.box.android.boxai.prompt.ComposableSingletons$BoxAiPromptInputBoxKt$$ExternalSyntheticLambda0
        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(Object obj, Object obj2) {
            return ComposableSingletons$BoxAiPromptInputBoxKt.lambda_2031708606$lambda$0((Composer) obj, ((Integer) obj2).intValue());
        }
    });
    private static Function2<Composer, Integer, Unit> lambda$47092011 = ComposableLambdaKt.composableLambdaInstance(47092011, false, new Function2() { // from class: com.box.android.boxai.prompt.ComposableSingletons$BoxAiPromptInputBoxKt$$ExternalSyntheticLambda1
        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(Object obj, Object obj2) {
            return ComposableSingletons$BoxAiPromptInputBoxKt.lambda_47092011$lambda$0((Composer) obj, ((Integer) obj2).intValue());
        }
    });

    /* JADX INFO: renamed from: lambda$-1017646112, reason: not valid java name */
    private static Function2<Composer, Integer, Unit> f200lambda$1017646112 = ComposableLambdaKt.composableLambdaInstance(-1017646112, false, new Function2() { // from class: com.box.android.boxai.prompt.ComposableSingletons$BoxAiPromptInputBoxKt$$ExternalSyntheticLambda2
        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(Object obj, Object obj2) {
            return ComposableSingletons$BoxAiPromptInputBoxKt.lambda__1017646112$lambda$0((Composer) obj, ((Integer) obj2).intValue());
        }
    });

    /* JADX INFO: renamed from: getLambda$-1017646112$boxai_generalProdRelease, reason: not valid java name */
    public final Function2<Composer, Integer, Unit> m12017getLambda$1017646112$boxai_generalProdRelease() {
        return f200lambda$1017646112;
    }

    public final Function2<Composer, Integer, Unit> getLambda$2031708606$boxai_generalProdRelease() {
        return lambda$2031708606;
    }

    public final Function2<Composer, Integer, Unit> getLambda$47092011$boxai_generalProdRelease() {
        return lambda$47092011;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit lambda_2031708606$lambda$0(Composer composer, int i) {
        ComposerKt.sourceInformation(composer, "C148@6289L39,149@6383L58,146@6176L295:BoxAiPromptInputBox.kt#askcry");
        if (!composer.shouldExecute((i & 3) != 2, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(2031708606, i, -1, "com.box.android.boxai.prompt.ComposableSingletons$BoxAiPromptInputBoxKt.lambda$2031708606.<anonymous> (BoxAiPromptInputBox.kt:146)");
            }
            IconKt.m3575Iconww6aTOc(VectorPainterKt.rememberVectorPainter(MicKt.getMic(Icons.Filled.INSTANCE), composer, 0), StringResources_androidKt.stringResource(R.string.box_ai_voice_start_talkback_label, composer, 0), SizeKt.m1266size3ABfNKs(Modifier.INSTANCE, Dp.m9687constructorimpl(24)), 0L, composer, VectorPainter.$stable | 384, 8);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit lambda_47092011$lambda$0(Composer composer, int i) {
        ComposerKt.sourceInformation(composer, "C182@7594L6,182@7559L117:BoxAiPromptInputBox.kt#askcry");
        if (!composer.shouldExecute((i & 3) != 2, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(47092011, i, -1, "com.box.android.boxai.prompt.ComposableSingletons$BoxAiPromptInputBoxKt.lambda$47092011.<anonymous> (BoxAiPromptInputBox.kt:182)");
            }
            Modifier modifierM589backgroundbw27NRU$default = BackgroundKt.m589backgroundbw27NRU$default(Modifier.INSTANCE, BoxAITheme.INSTANCE.getColors(composer, 6).m12054getContainerBackground0d7_KjU(), null, 2, null);
            ComposerKt.sourceInformationMarkerStart(composer, 1042775818, "CC(Box)N(modifier,contentAlignment,propagateMinConstraints,content)71@3424L131:Box.kt#2w3rfo");
            MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), false);
            ComposerKt.sourceInformationMarkerStart(composer, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
            int iHashCode = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composer, 0));
            CompositionLocalMap currentCompositionLocalMap = composer.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composer, modifierM589backgroundbw27NRU$default);
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
            Updater.m6070setimpl(composerM6062constructorimpl, measurePolicyMaybeCachedBoxMeasurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
            Updater.m6070setimpl(composerM6062constructorimpl, currentCompositionLocalMap, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
            Updater.m6066initimpl(composerM6062constructorimpl, Integer.valueOf(iHashCode), ComposeUiNode.INSTANCE.getSetCompositeKeyHash());
            Updater.m6068reconcileimpl(composerM6062constructorimpl, ComposeUiNode.INSTANCE.getApplyOnDeactivatedNodeAssertion());
            Updater.m6070setimpl(composerM6062constructorimpl, modifierMaterializeModifier, ComposeUiNode.INSTANCE.getSetModifier());
            ComposerKt.sourceInformationMarkerStart(composer, 1833054614, "C72@3469L9:Box.kt#2w3rfo");
            BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart(composer, 80270709, "C183@7637L29:BoxAiPromptInputBox.kt#askcry");
            BoxAiPromptInputBoxKt.DisabledBoxAiPromptInputBox(composer, 0);
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
    public static final Unit lambda__1017646112$lambda$0(Composer composer, int i) {
        ComposerKt.sourceInformation(composer, "C192@7822L6,192@7787L354:BoxAiPromptInputBox.kt#askcry");
        if (!composer.shouldExecute((i & 3) != 2, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1017646112, i, -1, "com.box.android.boxai.prompt.ComposableSingletons$BoxAiPromptInputBoxKt.lambda$-1017646112.<anonymous> (BoxAiPromptInputBox.kt:192)");
            }
            Modifier modifierM589backgroundbw27NRU$default = BackgroundKt.m589backgroundbw27NRU$default(Modifier.INSTANCE, BoxAITheme.INSTANCE.getColors(composer, 6).m12054getContainerBackground0d7_KjU(), null, 2, null);
            ComposerKt.sourceInformationMarkerStart(composer, 1042775818, "CC(Box)N(modifier,contentAlignment,propagateMinConstraints,content)71@3424L131:Box.kt#2w3rfo");
            MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), false);
            ComposerKt.sourceInformationMarkerStart(composer, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
            int iHashCode = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composer, 0));
            CompositionLocalMap currentCompositionLocalMap = composer.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composer, modifierM589backgroundbw27NRU$default);
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
            Updater.m6070setimpl(composerM6062constructorimpl, measurePolicyMaybeCachedBoxMeasurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
            Updater.m6070setimpl(composerM6062constructorimpl, currentCompositionLocalMap, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
            Updater.m6066initimpl(composerM6062constructorimpl, Integer.valueOf(iHashCode), ComposeUiNode.INSTANCE.getSetCompositeKeyHash());
            Updater.m6068reconcileimpl(composerM6062constructorimpl, ComposeUiNode.INSTANCE.getApplyOnDeactivatedNodeAssertion());
            Updater.m6070setimpl(composerM6062constructorimpl, modifierMaterializeModifier, ComposeUiNode.INSTANCE.getSetModifier());
            ComposerKt.sourceInformationMarkerStart(composer, 1833054614, "C72@3469L9:Box.kt#2w3rfo");
            BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart(composer, 37773343, "C197@8085L2,193@7865L266:BoxAiPromptInputBox.kt#askcry");
            BoxAiPromptReducer.State state = new BoxAiPromptReducer.State(true, null, null, null, 14, null);
            ComposerKt.sourceInformationMarkerStart(composer, 1248151260, "CC(remember):BoxAiPromptInputBox.kt#9igjgp");
            ComposableSingletons$BoxAiPromptInputBoxKt$lambda$1017646112$1$1$1$1 composableSingletons$BoxAiPromptInputBoxKt$lambda$1017646112$1$1$1$1RememberedValue = composer.rememberedValue();
            if (composableSingletons$BoxAiPromptInputBoxKt$lambda$1017646112$1$1$1$1RememberedValue == Composer.INSTANCE.getEmpty()) {
                composableSingletons$BoxAiPromptInputBoxKt$lambda$1017646112$1$1$1$1RememberedValue = new ComposableSingletons$BoxAiPromptInputBoxKt$lambda$1017646112$1$1$1$1(null);
                composer.updateRememberedValue(composableSingletons$BoxAiPromptInputBoxKt$lambda$1017646112$1$1$1$1RememberedValue);
            }
            ComposerKt.sourceInformationMarkerEnd(composer);
            BoxAiPromptInputBoxKt.BoxAiPromptInputBox(state, true, true, (Function1) composableSingletons$BoxAiPromptInputBoxKt$lambda$1017646112$1$1$1$1RememberedValue, null, composer, 25008);
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
