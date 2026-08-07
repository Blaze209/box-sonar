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
import com.box.android.boxai.qa.BoxAiQaReducer;
import com.box.android.domain.models.boxai.AiCitationModel;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: BoxAiAnswerActions.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
public final class ComposableSingletons$BoxAiAnswerActionsKt {
    public static final ComposableSingletons$BoxAiAnswerActionsKt INSTANCE = new ComposableSingletons$BoxAiAnswerActionsKt();

    /* JADX INFO: renamed from: lambda$-1043836572, reason: not valid java name */
    private static Function2<Composer, Integer, Unit> f201lambda$1043836572 = ComposableLambdaKt.composableLambdaInstance(-1043836572, false, new Function2() { // from class: com.box.android.boxai.ui.ComposableSingletons$BoxAiAnswerActionsKt$$ExternalSyntheticLambda2
        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(Object obj, Object obj2) {
            return ComposableSingletons$BoxAiAnswerActionsKt.lambda__1043836572$lambda$0((Composer) obj, ((Integer) obj2).intValue());
        }
    });

    /* JADX INFO: renamed from: getLambda$-1043836572$boxai_generalProdRelease, reason: not valid java name */
    public final Function2<Composer, Integer, Unit> m12090getLambda$1043836572$boxai_generalProdRelease() {
        return f201lambda$1043836572;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit lambda__1043836572$lambda$0(Composer composer, int i) {
        ComposerKt.sourceInformation(composer, "C212@8203L6,212@8168L386:BoxAiAnswerActions.kt#bwxcym");
        if (!composer.shouldExecute((i & 3) != 2, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1043836572, i, -1, "com.box.android.boxai.ui.ComposableSingletons$BoxAiAnswerActionsKt.lambda$-1043836572.<anonymous> (BoxAiAnswerActions.kt:212)");
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
            ComposerKt.sourceInformationMarkerStart(composer, 1876938235, "C217@8487L2,218@8528L2,213@8246L298:BoxAiAnswerActions.kt#bwxcym");
            List listListOf = CollectionsKt.listOf(new AiCitationModel(1, "abc", "id", "doc"));
            BoxAiQaReducer.AnswerFeedback answerFeedback = BoxAiQaReducer.AnswerFeedback.POSITIVE;
            ComposerKt.sourceInformationMarkerStart(composer, 1584574464, "CC(remember):BoxAiAnswerActions.kt#9igjgp");
            Object objRememberedValue = composer.rememberedValue();
            if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                objRememberedValue = new Function1() { // from class: com.box.android.boxai.ui.ComposableSingletons$BoxAiAnswerActionsKt$$ExternalSyntheticLambda0
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return ComposableSingletons$BoxAiAnswerActionsKt.lambda__1043836572$lambda$0$0$0$0((BoxAiQaReducer.AnswerFeedback) obj);
                    }
                };
                composer.updateRememberedValue(objRememberedValue);
            }
            Function1 function1 = (Function1) objRememberedValue;
            ComposerKt.sourceInformationMarkerEnd(composer);
            ComposerKt.sourceInformationMarkerStart(composer, 1584575776, "CC(remember):BoxAiAnswerActions.kt#9igjgp");
            Object objRememberedValue2 = composer.rememberedValue();
            if (objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                objRememberedValue2 = new Function0() { // from class: com.box.android.boxai.ui.ComposableSingletons$BoxAiAnswerActionsKt$$ExternalSyntheticLambda1
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return Unit.INSTANCE;
                    }
                };
                composer.updateRememberedValue(objRememberedValue2);
            }
            ComposerKt.sourceInformationMarkerEnd(composer);
            BoxAiAnswerActionsKt.BoxAiAnswerActionsBar(true, listListOf, answerFeedback, function1, (Function0) objRememberedValue2, composer, 28038);
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
    public static final Unit lambda__1043836572$lambda$0$0$0$0(BoxAiQaReducer.AnswerFeedback it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return Unit.INSTANCE;
    }
}
