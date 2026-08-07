package com.box.android.boxai.citations;

import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.RowScope;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.material.icons.Icons;
import androidx.compose.material.icons.outlined.ArrowOutwardKt;
import androidx.compose.material3.IconKt;
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
import androidx.compose.ui.res.StringResources_androidKt;
import androidx.compose.ui.tooling.preview.datasource.LoremIpsum;
import androidx.compose.ui.unit.Dp;
import com.box.android.base.compose.BoxTheme;
import com.box.android.base.compose.ComposePreviewMocks;
import com.box.android.boxai.R;
import com.box.android.boxai.ui.BoxAITheme;
import com.box.android.domain.models.boxai.AiCitationModel;
import com.box.android.domain.models.item.FileModel;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.sequences.SequencesKt;

/* JADX INFO: compiled from: BoxAiCitationsModal.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
public final class ComposableSingletons$BoxAiCitationsModalKt {
    public static final ComposableSingletons$BoxAiCitationsModalKt INSTANCE = new ComposableSingletons$BoxAiCitationsModalKt();
    private static Function3<RowScope, Composer, Integer, Unit> lambda$773947138 = ComposableLambdaKt.composableLambdaInstance(773947138, false, new Function3() { // from class: com.box.android.boxai.citations.ComposableSingletons$BoxAiCitationsModalKt$$ExternalSyntheticLambda0
        @Override // kotlin.jvm.functions.Function3
        public final Object invoke(Object obj, Object obj2, Object obj3) {
            return ComposableSingletons$BoxAiCitationsModalKt.lambda_773947138$lambda$0((RowScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
        }
    });

    /* JADX INFO: renamed from: lambda$-1027768360, reason: not valid java name */
    private static Function2<Composer, Integer, Unit> f198lambda$1027768360 = ComposableLambdaKt.composableLambdaInstance(-1027768360, false, new Function2() { // from class: com.box.android.boxai.citations.ComposableSingletons$BoxAiCitationsModalKt$$ExternalSyntheticLambda1
        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(Object obj, Object obj2) {
            return ComposableSingletons$BoxAiCitationsModalKt.lambda__1027768360$lambda$0((Composer) obj, ((Integer) obj2).intValue());
        }
    });
    private static Function2<Composer, Integer, Unit> lambda$2072539813 = ComposableLambdaKt.composableLambdaInstance(2072539813, false, new Function2() { // from class: com.box.android.boxai.citations.ComposableSingletons$BoxAiCitationsModalKt$$ExternalSyntheticLambda2
        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(Object obj, Object obj2) {
            return ComposableSingletons$BoxAiCitationsModalKt.lambda_2072539813$lambda$0((Composer) obj, ((Integer) obj2).intValue());
        }
    });

    /* JADX INFO: renamed from: getLambda$-1027768360$boxai_generalProdRelease, reason: not valid java name */
    public final Function2<Composer, Integer, Unit> m11951getLambda$1027768360$boxai_generalProdRelease() {
        return f198lambda$1027768360;
    }

    public final Function2<Composer, Integer, Unit> getLambda$2072539813$boxai_generalProdRelease() {
        return lambda$2072539813;
    }

    public final Function3<RowScope, Composer, Integer, Unit> getLambda$773947138$boxai_generalProdRelease() {
        return lambda$773947138;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit lambda_773947138$lambda$0(RowScope TextButton, Composer composer, int i) {
        Intrinsics.checkNotNullParameter(TextButton, "$this$TextButton");
        ComposerKt.sourceInformation(composer, "C195@7622L46,197@7778L6,194@7585L300,205@8165L6,200@7906L352:BoxAiCitationsModal.kt#odndpa");
        if (!composer.shouldExecute((i & 17) != 16, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(773947138, i, -1, "com.box.android.boxai.citations.ComposableSingletons$BoxAiCitationsModalKt.lambda$773947138.<anonymous> (BoxAiCitationsModal.kt:194)");
            }
            TextKt.m4494TextNvy7gAk(StringResources_androidKt.stringResource(R.string.box_ai_citations_link, composer, 0), PaddingKt.m1222paddingqDBjuR0$default(Modifier.INSTANCE, 0.0f, 0.0f, Dp.m9687constructorimpl(4), 0.0f, 11, null), BoxAITheme.INSTANCE.getColors(composer, 6).m12060getTextSecondary0d7_KjU(), null, 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, BoxTheme.INSTANCE.getTypography().getBoxNormal14(), composer, 48, 0, 131064);
            IconKt.m3576Iconww6aTOc(ArrowOutwardKt.getArrowOutward(Icons.Outlined.INSTANCE), (String) null, PaddingKt.m1220paddingVpY3zN4$default(SizeKt.fillMaxHeight$default(Modifier.INSTANCE, 0.0f, 1, null), 0.0f, Dp.m9687constructorimpl(8), 1, null), BoxAITheme.INSTANCE.getColors(composer, 6).m12060getTextSecondary0d7_KjU(), composer, 432, 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit lambda__1027768360$lambda$0(Composer composer, int i) {
        ComposerKt.sourceInformation(composer, "C221@8538L6,221@8503L639:BoxAiCitationsModal.kt#odndpa");
        if (!composer.shouldExecute((i & 3) != 2, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1027768360, i, -1, "com.box.android.boxai.citations.ComposableSingletons$BoxAiCitationsModalKt.lambda$-1027768360.<anonymous> (BoxAiCitationsModal.kt:221)");
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
            ComposerKt.sourceInformationMarkerStart(composer, -773012514, "C230@9116L2,222@8581L551:BoxAiCitationsModal.kt#odndpa");
            List listListOf = CollectionsKt.listOf(FileModel.copy$default(ComposePreviewMocks.INSTANCE.getEMPTY_FILE_MODEL(), null, "doc1.doc", false, false, null, null, null, null, null, null, null, false, 0L, null, null, null, null, null, null, null, null, null, null, null, null, null, null, 134217725, null));
            List listListOf2 = CollectionsKt.listOf((Object[]) new AiCitationModel[]{new AiCitationModel(20, (String) SequencesKt.first(new LoremIpsum(10).getValues()), "id", "doc1.doc"), new AiCitationModel(40, (String) SequencesKt.first(new LoremIpsum(30).getValues()), "id", "doc1.doc"), new AiCitationModel(60, (String) SequencesKt.first(new LoremIpsum(20).getValues()), "id", "doc1.doc")});
            ComposerKt.sourceInformationMarkerStart(composer, 667817344, "CC(remember):BoxAiCitationsModal.kt#9igjgp");
            Object objRememberedValue = composer.rememberedValue();
            if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                objRememberedValue = new Function1() { // from class: com.box.android.boxai.citations.ComposableSingletons$BoxAiCitationsModalKt$$ExternalSyntheticLambda3
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return ComposableSingletons$BoxAiCitationsModalKt.lambda__1027768360$lambda$0$0$0$0((AiCitationModel) obj);
                    }
                };
                composer.updateRememberedValue(objRememberedValue);
            }
            ComposerKt.sourceInformationMarkerEnd(composer);
            BoxAiCitationsModalKt.BoxAiCitationsModalContent(listListOf, listListOf2, false, (Function1) objRememberedValue, composer, 3456);
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
    public static final Unit lambda__1027768360$lambda$0$0$0$0(AiCitationModel it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit lambda_2072539813$lambda$0(Composer composer, int i) {
        ComposerKt.sourceInformation(composer, "C241@9330L6,241@9295L819:BoxAiCitationsModal.kt#odndpa");
        if (!composer.shouldExecute((i & 3) != 2, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(2072539813, i, -1, "com.box.android.boxai.citations.ComposableSingletons$BoxAiCitationsModalKt.lambda$2072539813.<anonymous> (BoxAiCitationsModal.kt:241)");
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
            ComposerKt.sourceInformationMarkerStart(composer, -913321463, "C254@10088L2,242@9373L731:BoxAiCitationsModal.kt#odndpa");
            List listListOf = CollectionsKt.listOf((Object[]) new FileModel[]{FileModel.copy$default(ComposePreviewMocks.INSTANCE.getEMPTY_FILE_MODEL(), null, "doc1", false, false, null, null, null, null, null, null, null, false, 0L, null, null, null, null, null, null, null, null, null, null, null, null, null, null, 134217725, null), FileModel.copy$default(ComposePreviewMocks.INSTANCE.getEMPTY_FILE_MODEL(), null, "doc2", false, false, null, null, null, null, null, null, null, false, 0L, null, null, null, null, null, null, null, null, null, null, null, null, null, null, 134217725, null), FileModel.copy$default(ComposePreviewMocks.INSTANCE.getEMPTY_FILE_MODEL(), null, "doc3", false, false, null, null, null, null, null, null, null, false, 0L, null, null, null, null, null, null, null, null, null, null, null, null, null, null, 134217725, null)});
            List listListOf2 = CollectionsKt.listOf((Object[]) new AiCitationModel[]{new AiCitationModel(20, (String) SequencesKt.first(new LoremIpsum(10).getValues()), "id1", "doc1"), new AiCitationModel(40, (String) SequencesKt.first(new LoremIpsum(30).getValues()), "id2", "doc2"), new AiCitationModel(60, (String) SequencesKt.first(new LoremIpsum(20).getValues()), "id3", "doc3")});
            ComposerKt.sourceInformationMarkerStart(composer, 801844161, "CC(remember):BoxAiCitationsModal.kt#9igjgp");
            Object objRememberedValue = composer.rememberedValue();
            if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                objRememberedValue = new Function1() { // from class: com.box.android.boxai.citations.ComposableSingletons$BoxAiCitationsModalKt$$ExternalSyntheticLambda4
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return ComposableSingletons$BoxAiCitationsModalKt.lambda_2072539813$lambda$0$0$0$0((AiCitationModel) obj);
                    }
                };
                composer.updateRememberedValue(objRememberedValue);
            }
            ComposerKt.sourceInformationMarkerEnd(composer);
            BoxAiCitationsModalKt.BoxAiCitationsModalContent(listListOf, listListOf2, true, (Function1) objRememberedValue, composer, 3456);
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
    public static final Unit lambda_2072539813$lambda$0$0$0$0(AiCitationModel it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return Unit.INSTANCE;
    }
}
