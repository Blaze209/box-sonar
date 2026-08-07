package com.box.android.boxai.ui;

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
import com.box.android.base.compose.ComposePreviewMocks;
import com.box.android.boxai.qa.BoxAiQaReducer;
import com.box.android.domain.models.boxai.AiUnavailabilityReason;
import com.box.android.domain.models.item.FileModel;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;

/* JADX INFO: compiled from: BoxAiDialogueHeader.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
public final class ComposableSingletons$BoxAiDialogueHeaderKt {
    public static final ComposableSingletons$BoxAiDialogueHeaderKt INSTANCE = new ComposableSingletons$BoxAiDialogueHeaderKt();

    /* JADX INFO: renamed from: lambda$-1974561623, reason: not valid java name */
    private static Function2<Composer, Integer, Unit> f202lambda$1974561623 = ComposableLambdaKt.composableLambdaInstance(-1974561623, false, new Function2() { // from class: com.box.android.boxai.ui.ComposableSingletons$BoxAiDialogueHeaderKt$$ExternalSyntheticLambda0
        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(Object obj, Object obj2) {
            return ComposableSingletons$BoxAiDialogueHeaderKt.lambda__1974561623$lambda$0((Composer) obj, ((Integer) obj2).intValue());
        }
    });
    private static Function2<Composer, Integer, Unit> lambda$1224318523 = ComposableLambdaKt.composableLambdaInstance(1224318523, false, new Function2() { // from class: com.box.android.boxai.ui.ComposableSingletons$BoxAiDialogueHeaderKt$$ExternalSyntheticLambda1
        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(Object obj, Object obj2) {
            return ComposableSingletons$BoxAiDialogueHeaderKt.lambda_1224318523$lambda$0((Composer) obj, ((Integer) obj2).intValue());
        }
    });

    /* JADX INFO: renamed from: lambda$-332538156, reason: not valid java name */
    private static Function2<Composer, Integer, Unit> f203lambda$332538156 = ComposableLambdaKt.composableLambdaInstance(-332538156, false, new Function2() { // from class: com.box.android.boxai.ui.ComposableSingletons$BoxAiDialogueHeaderKt$$ExternalSyntheticLambda2
        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(Object obj, Object obj2) {
            return ComposableSingletons$BoxAiDialogueHeaderKt.lambda__332538156$lambda$0((Composer) obj, ((Integer) obj2).intValue());
        }
    });

    /* JADX INFO: renamed from: getLambda$-1974561623$boxai_generalProdRelease, reason: not valid java name */
    public final Function2<Composer, Integer, Unit> m12093getLambda$1974561623$boxai_generalProdRelease() {
        return f202lambda$1974561623;
    }

    /* JADX INFO: renamed from: getLambda$-332538156$boxai_generalProdRelease, reason: not valid java name */
    public final Function2<Composer, Integer, Unit> m12094getLambda$332538156$boxai_generalProdRelease() {
        return f203lambda$332538156;
    }

    public final Function2<Composer, Integer, Unit> getLambda$1224318523$boxai_generalProdRelease() {
        return lambda$1224318523;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit lambda__1974561623$lambda$0(Composer composer, int i) {
        ComposerKt.sourceInformation(composer, "C:BoxAiDialogueHeader.kt#bwxcym");
        if (composer.shouldExecute((i & 3) != 2, i & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1974561623, i, -1, "com.box.android.boxai.ui.ComposableSingletons$BoxAiDialogueHeaderKt.lambda$-1974561623.<anonymous> (BoxAiDialogueHeader.kt:27)");
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composer.skipToGroupEnd();
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit lambda_1224318523$lambda$0(Composer composer, int i) {
        ComposerKt.sourceInformation(composer, "C72@2703L6,72@2668L343:BoxAiDialogueHeader.kt#bwxcym");
        if (!composer.shouldExecute((i & 3) != 2, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1224318523, i, -1, "com.box.android.boxai.ui.ComposableSingletons$BoxAiDialogueHeaderKt.lambda$1224318523.<anonymous> (BoxAiDialogueHeader.kt:72)");
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
            ComposerKt.sourceInformationMarkerStart(composer, -912592829, "C78@2985L2,73@2746L255:BoxAiDialogueHeader.kt#bwxcym");
            BoxAiQaReducer.State state = new BoxAiQaReducer.State(CollectionsKt.listOf(ComposePreviewMocks.INSTANCE.getEMPTY_FILE_MODEL()), null, "", false, false, null, null, null, null, null, null, null, false, false, false, 32762, null);
            ComposerKt.sourceInformationMarkerStart(composer, -1691999069, "CC(remember):BoxAiDialogueHeader.kt#9igjgp");
            Object objRememberedValue = composer.rememberedValue();
            if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                objRememberedValue = new Function0() { // from class: com.box.android.boxai.ui.ComposableSingletons$BoxAiDialogueHeaderKt$$ExternalSyntheticLambda3
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return Unit.INSTANCE;
                    }
                };
                composer.updateRememberedValue(objRememberedValue);
            }
            ComposerKt.sourceInformationMarkerEnd(composer);
            BoxAiDialogueHeaderKt.BoxAiDialogueHeader(state, (Function0) objRememberedValue, composer, 48);
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
    public static final Unit lambda__332538156$lambda$0(Composer composer, int i) {
        ComposerKt.sourceInformation(composer, "C89@3192L6,89@3157L724:BoxAiDialogueHeader.kt#bwxcym");
        if (!composer.shouldExecute((i & 3) != 2, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-332538156, i, -1, "com.box.android.boxai.ui.ComposableSingletons$BoxAiDialogueHeaderKt.lambda$-332538156.<anonymous> (BoxAiDialogueHeader.kt:89)");
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
            ComposerKt.sourceInformationMarkerStart(composer, 416094841, "C101@3855L2,90@3235L636:BoxAiDialogueHeader.kt#bwxcym");
            BoxAiQaReducer.State state = new BoxAiQaReducer.State(CollectionsKt.listOf((Object[]) new FileModel[]{FileModel.copy$default(ComposePreviewMocks.INSTANCE.getEMPTY_FILE_MODEL(), FileModel.INSTANCE.createItemId("file-id1"), null, false, false, null, null, null, null, null, null, null, false, 0L, null, null, null, null, null, null, null, null, null, null, null, null, null, null, 134217726, null), FileModel.copy$default(ComposePreviewMocks.INSTANCE.getEMPTY_FILE_MODEL(), FileModel.INSTANCE.createItemId("file-id2"), null, false, false, null, null, null, null, null, null, null, false, 0L, null, null, null, null, null, null, null, null, null, null, null, null, null, null, 134217726, null)}), CollectionsKt.listOf(TuplesKt.to(ComposePreviewMocks.INSTANCE.getEMPTY_FOLDER_MODEL(), AiUnavailabilityReason.NOT_SUPPORTED)), "", false, false, null, null, null, null, null, null, null, false, false, false, 32760, null);
            ComposerKt.sourceInformationMarkerStart(composer, -125105712, "CC(remember):BoxAiDialogueHeader.kt#9igjgp");
            Object objRememberedValue = composer.rememberedValue();
            if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                objRememberedValue = new Function0() { // from class: com.box.android.boxai.ui.ComposableSingletons$BoxAiDialogueHeaderKt$$ExternalSyntheticLambda4
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return Unit.INSTANCE;
                    }
                };
                composer.updateRememberedValue(objRememberedValue);
            }
            ComposerKt.sourceInformationMarkerEnd(composer);
            BoxAiDialogueHeaderKt.BoxAiDialogueHeader(state, (Function0) objRememberedValue, composer, 48);
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
