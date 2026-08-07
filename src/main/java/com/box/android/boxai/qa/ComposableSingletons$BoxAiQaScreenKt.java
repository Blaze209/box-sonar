package com.box.android.boxai.qa;

import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScopeInstance;
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
import androidx.exifinterface.media.ExifInterface;
import com.box.android.base.compose.ComposePreviewMocks;
import com.box.android.base.compose.ComposePreviewUtilsKt;
import com.box.android.base.presentation.components.CopyTextReducer;
import com.box.android.boxai.prompt.BoxAiPromptReducer;
import com.box.android.boxai.ui.BoxAITheme;
import com.box.android.domain.models.boxai.AiCitationModel;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;

/* JADX INFO: compiled from: BoxAiQaScreen.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
public final class ComposableSingletons$BoxAiQaScreenKt {
    public static final ComposableSingletons$BoxAiQaScreenKt INSTANCE = new ComposableSingletons$BoxAiQaScreenKt();
    private static Function2<Composer, Integer, Unit> lambda$1372952619 = ComposableLambdaKt.composableLambdaInstance(1372952619, false, new Function2() { // from class: com.box.android.boxai.qa.ComposableSingletons$BoxAiQaScreenKt$$ExternalSyntheticLambda0
        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(Object obj, Object obj2) {
            return ComposableSingletons$BoxAiQaScreenKt.lambda_1372952619$lambda$0((Composer) obj, ((Integer) obj2).intValue());
        }
    });
    private static Function2<Composer, Integer, Unit> lambda$2141057952 = ComposableLambdaKt.composableLambdaInstance(2141057952, false, new Function2() { // from class: com.box.android.boxai.qa.ComposableSingletons$BoxAiQaScreenKt$$ExternalSyntheticLambda1
        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(Object obj, Object obj2) {
            return ComposableSingletons$BoxAiQaScreenKt.lambda_2141057952$lambda$0((Composer) obj, ((Integer) obj2).intValue());
        }
    });

    public final Function2<Composer, Integer, Unit> getLambda$1372952619$boxai_generalProdRelease() {
        return lambda$1372952619;
    }

    public final Function2<Composer, Integer, Unit> getLambda$2141057952$boxai_generalProdRelease() {
        return lambda$2141057952;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit lambda_1372952619$lambda$0(Composer composer, int i) {
        ComposerKt.sourceInformation(composer, "C215@8949L6,215@8914L2117:BoxAiQaScreen.kt#bwxcuy");
        if (!composer.shouldExecute((i & 3) != 2, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1372952619, i, -1, "com.box.android.boxai.qa.ComposableSingletons$BoxAiQaScreenKt.lambda$1372952619.<anonymous> (BoxAiQaScreen.kt:215)");
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
            ComposerKt.sourceInformationMarkerStart(composer, 1317934245, "C216@8992L2029:BoxAiQaScreen.kt#bwxcuy");
            BoxAiQaScreenKt.BoxAiQaScreen(ComposePreviewUtilsKt.createMockStore(new BoxAiQaReducer.State(CollectionsKt.listOf(ComposePreviewMocks.INSTANCE.getEMPTY_FILE_MODEL()), null, "session-id", false, false, null, new BoxAiPromptReducer.State(true, null, null, null, 14, null), new CopyTextReducer.State(false, false, 3, null), CollectionsKt.listOf((Object[]) new BoxAiQaReducer.DialogueItem[]{new BoxAiQaReducer.DialogueItem("What is Box?", new BoxAiQaReducer.AiResponse.Answer("Box is a cloud content management and file sharing service for businesses.", null, 2, null), "1", true, null, null, 48, null), new BoxAiQaReducer.DialogueItem("Give me examples", new BoxAiQaReducer.AiResponse.Answer("Here is one", CollectionsKt.listOf(new AiCitationModel(null, "content", "1", "name"))), "2", true, null, null, 48, null), new BoxAiQaReducer.DialogueItem("Could you elaborate?", new BoxAiQaReducer.AiResponse.Answer("This is going to be a long response that is still being sent", null, 2, null), ExifInterface.GPS_MEASUREMENT_3D, false, null, null, 48, null)}), null, null, null, false, false, false, 32314, null)), null, composer, 48);
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
    public static final Unit lambda_2141057952$lambda$0(Composer composer, int i) {
        ComposerKt.sourceInformation(composer, "C263@11198L6,263@11163L626:BoxAiQaScreen.kt#bwxcuy");
        if (!composer.shouldExecute((i & 3) != 2, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(2141057952, i, -1, "com.box.android.boxai.qa.ComposableSingletons$BoxAiQaScreenKt.lambda$2141057952.<anonymous> (BoxAiQaScreen.kt:263)");
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
            ComposerKt.sourceInformationMarkerStart(composer, 1031615823, "C264@11241L538:BoxAiQaScreen.kt#bwxcuy");
            BoxAiQaScreenKt.BoxAiQaScreen(ComposePreviewUtilsKt.createMockStore(new BoxAiQaReducer.State(CollectionsKt.listOf(ComposePreviewMocks.INSTANCE.getEMPTY_FILE_MODEL()), null, "session-id", false, false, null, new BoxAiPromptReducer.State(true, null, null, null, 14, null), new CopyTextReducer.State(false, false, 3, null), CollectionsKt.emptyList(), null, null, null, false, false, false, 32314, null)), null, composer, 48);
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
