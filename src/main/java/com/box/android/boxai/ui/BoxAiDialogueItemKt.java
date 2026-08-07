package com.box.android.boxai.ui;

import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.ColumnKt;
import androidx.compose.foundation.layout.ColumnScopeInstance;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.RowKt;
import androidx.compose.foundation.layout.RowScopeInstance;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.layout.SpacerKt;
import androidx.compose.foundation.shape.RoundedCornerShapeKt;
import androidx.compose.material3.TextKt;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.platform.TestTagKt;
import androidx.compose.ui.res.StringResources_androidKt;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.DpOffset;
import androidx.compose.ui.unit.TextUnitKt;
import com.box.android.base.compose.BoxTheme;
import com.box.android.base.compose.BoxThemeKt;
import com.box.android.base.compose.ComposeUtilsKt;
import com.box.android.boxai.R;
import com.box.android.boxai.markdown.MarkdownViewKt;
import com.box.android.boxai.qa.BoxAiQaReducer;
import com.box.android.domain.models.boxai.AiCitationModel;
import com.microsoft.identity.common.adal.internal.AuthenticationConstants;
import java.util.List;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: BoxAiDialogueItem.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000J\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\u001am\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0012\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u00010\u00072\u0012\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u00010\u00072\u0018\u0010\u000b\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\r0\f\u0012\u0004\u0012\u00020\u00010\u00072\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00010\u000fH\u0007¢\u0006\u0002\u0010\u0010\u001a\u001f\u0010\u0011\u001a\u00020\u00012\u0006\u0010\u0012\u001a\u00020\n2\b\b\u0002\u0010\u0013\u001a\u00020\u0014H\u0003¢\u0006\u0002\u0010\u0015\u001a_\u0010\u0016\u001a\u00020\u00012\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u00052\u0006\u0010\u001a\u001a\u00020\u00052\b\u0010\u001b\u001a\u0004\u0018\u00010\b2\u0012\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u00010\u00072\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00010\u000f2\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00010\u000fH\u0003¢\u0006\u0002\u0010\u001c\u001a'\u0010\u001d\u001a\u00020\u00012\u000e\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u000f2\b\b\u0002\u0010\u0013\u001a\u00020\u0014H\u0003¢\u0006\u0002\u0010\u001e\u001a\r\u0010\u001f\u001a\u00020\u0001H\u0003¢\u0006\u0002\u0010 \u001a\r\u0010!\u001a\u00020\u0001H\u0003¢\u0006\u0002\u0010 \u001a\r\u0010\"\u001a\u00020\u0001H\u0003¢\u0006\u0002\u0010 \u001a\r\u0010#\u001a\u00020\u0001H\u0003¢\u0006\u0002\u0010 \u001a\r\u0010$\u001a\u00020\u0001H\u0003¢\u0006\u0002\u0010 ¨\u0006%²\u0006\n\u0010&\u001a\u00020\u0005X\u008a\u008e\u0002²\u0006\n\u0010'\u001a\u00020(X\u008a\u008e\u0002²\u0006\f\u0010\u001b\u001a\u0004\u0018\u00010\bX\u008a\u008e\u0002"}, d2 = {"BoxAiDialogueItem", "", "item", "Lcom/box/android/boxai/qa/BoxAiQaReducer$DialogueItem;", "isLastItem", "", "onFeedbackClicked", "Lkotlin/Function1;", "Lcom/box/android/boxai/qa/BoxAiQaReducer$AnswerFeedback;", "onCopyToClipboardClicked", "", "onCitationsClicked", "", "Lcom/box/android/domain/models/boxai/AiCitationModel;", "onRetryClicked", "Lkotlin/Function0;", "(Lcom/box/android/boxai/qa/BoxAiQaReducer$DialogueItem;ZLkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function0;Landroidx/compose/runtime/Composer;I)V", "BoxAiUserPromptWrapper", AuthenticationConstants.AAD.QUERY_PROMPT, "modifier", "Landroidx/compose/ui/Modifier;", "(Ljava/lang/String;Landroidx/compose/ui/Modifier;Landroidx/compose/runtime/Composer;II)V", "BoxAiAnswerResponse", "response", "Lcom/box/android/boxai/qa/BoxAiQaReducer$AiResponse$Answer;", "isResponseFinished", "isLastResponse", "feedback", "(Lcom/box/android/boxai/qa/BoxAiQaReducer$AiResponse$Answer;ZZLcom/box/android/boxai/qa/BoxAiQaReducer$AnswerFeedback;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;Landroidx/compose/runtime/Composer;I)V", "BoxAiErrorResponse", "(Lkotlin/jvm/functions/Function0;Landroidx/compose/ui/Modifier;Landroidx/compose/runtime/Composer;II)V", "BoxAiDialogueItemAnswerPreview", "(Landroidx/compose/runtime/Composer;I)V", "BoxAiDialogueItemAnswerWithFeedbackInContextMenuButtonsPreview", "BoxAiDialogueItemAnswerWithContextMenuAndMarkdownPreview", "BoxAiDialogueItemLoadingPreview", "BoxAiDialogueItemErrorPreview", "boxai_generalProdRelease", "isContextMenuVisible", "contextMenuOffset", "Landroidx/compose/ui/unit/DpOffset;"}, k = 2, mv = {2, 2, 0}, xi = 48)
public final class BoxAiDialogueItemKt {
    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit BoxAiAnswerResponse$lambda$7(BoxAiQaReducer.AiResponse.Answer answer, boolean z, boolean z2, BoxAiQaReducer.AnswerFeedback answerFeedback, Function1 function1, Function0 function0, Function0 function2, int i, Composer composer, int i2) {
        BoxAiAnswerResponse(answer, z, z2, answerFeedback, function1, function0, function2, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit BoxAiDialogueItem$lambda$1(BoxAiQaReducer.DialogueItem dialogueItem, boolean z, Function1 function1, Function1 function2, Function1 function3, Function0 function0, int i, Composer composer, int i2) {
        BoxAiDialogueItem(dialogueItem, z, function1, function2, function3, function0, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit BoxAiDialogueItemAnswerPreview$lambda$0(int i, Composer composer, int i2) {
        BoxAiDialogueItemAnswerPreview(composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit BoxAiDialogueItemAnswerWithContextMenuAndMarkdownPreview$lambda$0(int i, Composer composer, int i2) {
        BoxAiDialogueItemAnswerWithContextMenuAndMarkdownPreview(composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit BoxAiDialogueItemAnswerWithFeedbackInContextMenuButtonsPreview$lambda$4(int i, Composer composer, int i2) {
        BoxAiDialogueItemAnswerWithFeedbackInContextMenuButtonsPreview(composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit BoxAiDialogueItemErrorPreview$lambda$0(int i, Composer composer, int i2) {
        BoxAiDialogueItemErrorPreview(composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit BoxAiDialogueItemLoadingPreview$lambda$0(int i, Composer composer, int i2) {
        BoxAiDialogueItemLoadingPreview(composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit BoxAiErrorResponse$lambda$1(Function0 function0, Modifier modifier, int i, int i2, Composer composer, int i3) {
        BoxAiErrorResponse(function0, modifier, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit BoxAiUserPromptWrapper$lambda$1(String str, Modifier modifier, int i, int i2, Composer composer, int i3) {
        BoxAiUserPromptWrapper(str, modifier, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    public static final void BoxAiDialogueItem(final BoxAiQaReducer.DialogueItem item, final boolean z, final Function1<? super BoxAiQaReducer.AnswerFeedback, Unit> onFeedbackClicked, final Function1<? super String, Unit> onCopyToClipboardClicked, final Function1<? super List<AiCitationModel>, Unit> onCitationsClicked, final Function0<Unit> onRetryClicked, Composer composer, final int i) {
        int i2;
        Intrinsics.checkNotNullParameter(item, "item");
        Intrinsics.checkNotNullParameter(onFeedbackClicked, "onFeedbackClicked");
        Intrinsics.checkNotNullParameter(onCopyToClipboardClicked, "onCopyToClipboardClicked");
        Intrinsics.checkNotNullParameter(onCitationsClicked, "onCitationsClicked");
        Intrinsics.checkNotNullParameter(onRetryClicked, "onRetryClicked");
        Composer composerStartRestartGroup = composer.startRestartGroup(-825864914);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(BoxAiDialogueItem)N(item,isLastItem,onFeedbackClicked,onCopyToClipboardClicked,onCitationsClicked,onRetryClicked)44@1820L1263:BoxAiDialogueItem.kt#bwxcym");
        if ((i & 6) == 0) {
            i2 = (composerStartRestartGroup.changed(item) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 48) == 0) {
            i2 |= composerStartRestartGroup.changed(z) ? 32 : 16;
        }
        if ((i & 384) == 0) {
            i2 |= composerStartRestartGroup.changedInstance(onFeedbackClicked) ? 256 : 128;
        }
        if ((i & 3072) == 0) {
            i2 |= composerStartRestartGroup.changedInstance(onCopyToClipboardClicked) ? 2048 : 1024;
        }
        if ((i & 24576) == 0) {
            i2 |= composerStartRestartGroup.changedInstance(onCitationsClicked) ? 16384 : 8192;
        }
        if ((196608 & i) == 0) {
            i2 |= composerStartRestartGroup.changedInstance(onRetryClicked) ? 131072 : 65536;
        }
        if (!composerStartRestartGroup.shouldExecute((74899 & i2) != 74898, i2 & 1)) {
            composerStartRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-825864914, i2, -1, "com.box.android.boxai.ui.BoxAiDialogueItem (BoxAiDialogueItem.kt:43)");
            }
            Modifier modifierFillMaxWidth$default = SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1341605231, "CC(Column)N(modifier,verticalArrangement,horizontalAlignment,content)87@4443L61,88@4509L134:Column.kt#2w3rfo");
            MeasurePolicy measurePolicyColumnMeasurePolicy = ColumnKt.columnMeasurePolicy(Arrangement.INSTANCE.getTop(), Alignment.INSTANCE.getStart(), composerStartRestartGroup, 0);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
            int iHashCode = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
            CompositionLocalMap currentCompositionLocalMap = composerStartRestartGroup.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierFillMaxWidth$default);
            Function0<ComposeUiNode> constructor = ComposeUiNode.INSTANCE.getConstructor();
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
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
            Updater.m6070setimpl(composerM6062constructorimpl, measurePolicyColumnMeasurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
            Updater.m6070setimpl(composerM6062constructorimpl, currentCompositionLocalMap, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
            Updater.m6066initimpl(composerM6062constructorimpl, Integer.valueOf(iHashCode), ComposeUiNode.INSTANCE.getSetCompositeKeyHash());
            Updater.m6068reconcileimpl(composerM6062constructorimpl, ComposeUiNode.INSTANCE.getApplyOnDeactivatedNodeAssertion());
            Updater.m6070setimpl(composerM6062constructorimpl, modifierMaterializeModifier, ComposeUiNode.INSTANCE.getSetModifier());
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2093002350, "C89@4557L9:Column.kt#2w3rfo");
            ColumnScopeInstance columnScopeInstance = ColumnScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1114970772, "C45@1862L144:BoxAiDialogueItem.kt#bwxcym");
            float f = 24;
            float f2 = 8;
            BoxAiUserPromptWrapper(item.getPrompt(), PaddingKt.m1219paddingVpY3zN4(Modifier.INSTANCE, Dp.m9687constructorimpl(f), Dp.m9687constructorimpl(f2)), composerStartRestartGroup, 48, 0);
            BoxAiQaReducer.AiResponse response = item.getResponse();
            if (response instanceof BoxAiQaReducer.AiResponse.Answer) {
                composerStartRestartGroup.startReplaceGroup(-1114766080);
                ComposerKt.sourceInformation(composerStartRestartGroup, "58@2440L50,59@2533L47,52@2108L490");
                BoxAiQaReducer.AiResponse.Answer answer = (BoxAiQaReducer.AiResponse.Answer) item.getResponse();
                boolean responseFinished = item.getResponseFinished();
                BoxAiQaReducer.AnswerFeedback feedback = item.getFeedback();
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1975612118, "CC(remember):BoxAiDialogueItem.kt#9igjgp");
                int i3 = i2 & 14;
                boolean z2 = ((i2 & 7168) == 2048) | (i3 == 4);
                Object objRememberedValue = composerStartRestartGroup.rememberedValue();
                if (z2 || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue = new Function0() { // from class: com.box.android.boxai.ui.BoxAiDialogueItemKt$$ExternalSyntheticLambda0
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            return BoxAiDialogueItemKt.BoxAiDialogueItem$lambda$0$0$0(onCopyToClipboardClicked, item);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                }
                Function0 function0 = (Function0) objRememberedValue;
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1975609145, "CC(remember):BoxAiDialogueItem.kt#9igjgp");
                boolean z3 = ((i2 & 57344) == 16384) | (i3 == 4);
                Object objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                if (z3 || objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue2 = new Function0() { // from class: com.box.android.boxai.ui.BoxAiDialogueItemKt$$ExternalSyntheticLambda9
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            return BoxAiDialogueItemKt.BoxAiDialogueItem$lambda$0$1$0(onCitationsClicked, item);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                }
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                BoxAiAnswerResponse(answer, responseFinished, z, feedback, onFeedbackClicked, function0, (Function0) objRememberedValue2, composerStartRestartGroup, ((i2 << 3) & 896) | ((i2 << 6) & 57344));
                composerStartRestartGroup.endReplaceGroup();
            } else if (response instanceof BoxAiQaReducer.AiResponse.Error) {
                composerStartRestartGroup.startReplaceGroup(-1114188891);
                ComposerKt.sourceInformation(composerStartRestartGroup, "64@2682L197");
                BoxAiErrorResponse(z ? onRetryClicked : null, PaddingKt.m1219paddingVpY3zN4(Modifier.INSTANCE, Dp.m9687constructorimpl(f), Dp.m9687constructorimpl(f2)), composerStartRestartGroup, 48, 0);
                composerStartRestartGroup.endReplaceGroup();
            } else {
                if (response != null) {
                    composerStartRestartGroup.startReplaceGroup(-1975624675);
                    composerStartRestartGroup.endReplaceGroup();
                    throw new NoWhenBranchMatchedException();
                }
                composerStartRestartGroup.startReplaceGroup(-1113959150);
                ComposerKt.sourceInformation(composerStartRestartGroup, "71@2933L120");
                BoxAiProgressBarKt.m12079BoxAiProgressBarrAjV9yQ(PaddingKt.m1219paddingVpY3zN4(Modifier.INSTANCE, Dp.m9687constructorimpl(f), Dp.m9687constructorimpl(f2)), 0.0f, composerStartRestartGroup, 6, 2);
                composerStartRestartGroup.endReplaceGroup();
            }
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            composerStartRestartGroup.endNode();
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.box.android.boxai.ui.BoxAiDialogueItemKt$$ExternalSyntheticLambda10
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return BoxAiDialogueItemKt.BoxAiDialogueItem$lambda$1(item, z, onFeedbackClicked, onCopyToClipboardClicked, onCitationsClicked, onRetryClicked, i, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit BoxAiDialogueItem$lambda$0$0$0(Function1 function1, BoxAiQaReducer.DialogueItem dialogueItem) {
        function1.invoke(((BoxAiQaReducer.AiResponse.Answer) dialogueItem.getResponse()).getAnswer());
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit BoxAiDialogueItem$lambda$0$1$0(Function1 function1, BoxAiQaReducer.DialogueItem dialogueItem) {
        function1.invoke(((BoxAiQaReducer.AiResponse.Answer) dialogueItem.getResponse()).getCitations());
        return Unit.INSTANCE;
    }

    /* JADX WARN: Code duplicated, block: B:23:0x0047  */
    /* JADX WARN: Code duplicated, block: B:24:0x0049  */
    /* JADX WARN: Code duplicated, block: B:27:0x0052 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:28:0x0054  */
    /* JADX WARN: Code duplicated, block: B:29:0x0059  */
    /* JADX WARN: Code duplicated, block: B:32:0x0060  */
    /* JADX WARN: Code duplicated, block: B:35:0x00b3  */
    /* JADX WARN: Code duplicated, block: B:38:0x00bf  */
    /* JADX WARN: Code duplicated, block: B:39:0x00c3  */
    /* JADX WARN: Code duplicated, block: B:42:0x01e8  */
    /* JADX WARN: Code duplicated, block: B:44:0x01ee  */
    /* JADX WARN: Code duplicated, block: B:47:0x01f9  */
    /* JADX WARN: Code duplicated, block: B:49:? A[RETURN, SYNTHETIC] */
    private static final void BoxAiUserPromptWrapper(final String str, Modifier modifier, Composer composer, final int i, final int i2) {
        int i3;
        final Modifier modifier2;
        boolean z;
        Composer composer2;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        Modifier.Companion companion;
        Function0<ComposeUiNode> constructor;
        Composer composerStartRestartGroup = composer.startRestartGroup(2084089829);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(BoxAiUserPromptWrapper)N(prompt,modifier)81@3187L545:BoxAiDialogueItem.kt#bwxcym");
        if ((i & 6) == 0) {
            i3 = i | (composerStartRestartGroup.changed(str) ? 4 : 2);
        } else {
            i3 = i;
        }
        int i4 = i2 & 2;
        if (i4 == 0) {
            if ((i & 48) == 0) {
                modifier2 = modifier;
                i3 |= composerStartRestartGroup.changed(modifier2) ? 32 : 16;
            }
            if ((i3 & 19) != 18) {
                z = true;
            } else {
                z = false;
            }
            if (composerStartRestartGroup.shouldExecute(z, i3 & 1)) {
                composer2 = composerStartRestartGroup;
                composer2.skipToGroupEnd();
            } else {
                if (i4 != 0) {
                    companion = Modifier.INSTANCE;
                } else {
                    companion = modifier2;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(2084089829, i3, -1, "com.box.android.boxai.ui.BoxAiUserPromptWrapper (BoxAiDialogueItem.kt:80)");
                }
                Modifier modifierFillMaxWidth$default = SizeKt.fillMaxWidth$default(companion, 0.0f, 1, null);
                Arrangement.Horizontal end = Arrangement.INSTANCE.getEnd();
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 844473419, "CC(Row)N(modifier,horizontalArrangement,verticalAlignment,content)99@5125L58,100@5188L131:Row.kt#2w3rfo");
                MeasurePolicy measurePolicyRowMeasurePolicy = RowKt.rowMeasurePolicy(end, Alignment.INSTANCE.getTop(), composerStartRestartGroup, 6);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
                int iHashCode = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
                CompositionLocalMap currentCompositionLocalMap = composerStartRestartGroup.getCurrentCompositionLocalMap();
                Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierFillMaxWidth$default);
                constructor = ComposeUiNode.INSTANCE.getConstructor();
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
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
                Updater.m6070setimpl(composerM6062constructorimpl, measurePolicyRowMeasurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                Updater.m6070setimpl(composerM6062constructorimpl, currentCompositionLocalMap, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                Updater.m6066initimpl(composerM6062constructorimpl, Integer.valueOf(iHashCode), ComposeUiNode.INSTANCE.getSetCompositeKeyHash());
                Updater.m6068reconcileimpl(composerM6062constructorimpl, ComposeUiNode.INSTANCE.getApplyOnDeactivatedNodeAssertion());
                Updater.m6070setimpl(composerM6062constructorimpl, modifierMaterializeModifier, ComposeUiNode.INSTANCE.getSetModifier());
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1456264949, "C101@5233L9:Row.kt#2w3rfo");
                RowScopeInstance rowScopeInstance = RowScopeInstance.INSTANCE;
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 627188920, "C85@3300L46,88@3432L6,93@3699L6,86@3355L371:BoxAiDialogueItem.kt#bwxcym");
                SpacerKt.Spacer(SizeKt.fillMaxWidth(Modifier.INSTANCE, 0.2f), composerStartRestartGroup, 6);
                int i5 = i3 & 14;
                Modifier modifier3 = companion;
                composer2 = composerStartRestartGroup;
                TextKt.m4494TextNvy7gAk(str, TestTagKt.testTag(PaddingKt.m1218padding3ABfNKs(BackgroundKt.m588backgroundbw27NRU(Modifier.INSTANCE, BoxAITheme.INSTANCE.getColors(composerStartRestartGroup, 6).m12062getUserPromptBackground0d7_KjU(), RoundedCornerShapeKt.m1573RoundedCornerShape0680j_4(Dp.m9687constructorimpl(24))), Dp.m9687constructorimpl(16)), "BoxAi:QA:Prompt"), BoxTheme.INSTANCE.getColors(composerStartRestartGroup, BoxTheme.$stable).m11500getAppPrimary0d7_KjU(), null, 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, TextStyle.m9104copyp1EtxEg$default(BoxTheme.INSTANCE.getTypography().getBoxNormal14(), 0L, 0L, null, null, null, null, null, 0L, null, null, null, 0L, null, null, null, 0, 0, TextUnitKt.getSp(20), null, null, null, 0, 0, null, 16646143, null), composer2, i5, 0, 131064);
                ComposerKt.sourceInformationMarkerEnd(composer2);
                ComposerKt.sourceInformationMarkerEnd(composer2);
                composer2.endNode();
                ComposerKt.sourceInformationMarkerEnd(composer2);
                ComposerKt.sourceInformationMarkerEnd(composer2);
                ComposerKt.sourceInformationMarkerEnd(composer2);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                modifier2 = modifier3;
            }
            scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.box.android.boxai.ui.BoxAiDialogueItemKt$$ExternalSyntheticLambda3
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return BoxAiDialogueItemKt.BoxAiUserPromptWrapper$lambda$1(str, modifier2, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                    }
                });
            }
        }
        i3 |= 48;
        modifier2 = modifier;
        if ((i3 & 19) != 18) {
            z = true;
        } else {
            z = false;
        }
        if (composerStartRestartGroup.shouldExecute(z, i3 & 1)) {
            composer2 = composerStartRestartGroup;
            composer2.skipToGroupEnd();
        } else {
            if (i4 != 0) {
                companion = Modifier.INSTANCE;
            } else {
                companion = modifier2;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(2084089829, i3, -1, "com.box.android.boxai.ui.BoxAiUserPromptWrapper (BoxAiDialogueItem.kt:80)");
            }
            Modifier modifierFillMaxWidth$default2 = SizeKt.fillMaxWidth$default(companion, 0.0f, 1, null);
            Arrangement.Horizontal end2 = Arrangement.INSTANCE.getEnd();
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 844473419, "CC(Row)N(modifier,horizontalArrangement,verticalAlignment,content)99@5125L58,100@5188L131:Row.kt#2w3rfo");
            MeasurePolicy measurePolicyRowMeasurePolicy2 = RowKt.rowMeasurePolicy(end2, Alignment.INSTANCE.getTop(), composerStartRestartGroup, 6);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
            int iHashCode2 = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
            CompositionLocalMap currentCompositionLocalMap2 = composerStartRestartGroup.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier2 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierFillMaxWidth$default2);
            constructor = ComposeUiNode.INSTANCE.getConstructor();
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
            if (!(composerStartRestartGroup.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            composerStartRestartGroup.startReusableNode();
            if (composerStartRestartGroup.getInserting()) {
                composerStartRestartGroup.createNode(constructor);
            } else {
                composerStartRestartGroup.useNode();
            }
            Composer composerM6062constructorimpl2 = Updater.m6062constructorimpl(composerStartRestartGroup);
            Updater.m6070setimpl(composerM6062constructorimpl2, measurePolicyRowMeasurePolicy2, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
            Updater.m6070setimpl(composerM6062constructorimpl2, currentCompositionLocalMap2, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
            Updater.m6066initimpl(composerM6062constructorimpl2, Integer.valueOf(iHashCode2), ComposeUiNode.INSTANCE.getSetCompositeKeyHash());
            Updater.m6068reconcileimpl(composerM6062constructorimpl2, ComposeUiNode.INSTANCE.getApplyOnDeactivatedNodeAssertion());
            Updater.m6070setimpl(composerM6062constructorimpl2, modifierMaterializeModifier2, ComposeUiNode.INSTANCE.getSetModifier());
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1456264949, "C101@5233L9:Row.kt#2w3rfo");
            RowScopeInstance rowScopeInstance2 = RowScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 627188920, "C85@3300L46,88@3432L6,93@3699L6,86@3355L371:BoxAiDialogueItem.kt#bwxcym");
            SpacerKt.Spacer(SizeKt.fillMaxWidth(Modifier.INSTANCE, 0.2f), composerStartRestartGroup, 6);
            int i6 = i3 & 14;
            Modifier modifier4 = companion;
            composer2 = composerStartRestartGroup;
            TextKt.m4494TextNvy7gAk(str, TestTagKt.testTag(PaddingKt.m1218padding3ABfNKs(BackgroundKt.m588backgroundbw27NRU(Modifier.INSTANCE, BoxAITheme.INSTANCE.getColors(composerStartRestartGroup, 6).m12062getUserPromptBackground0d7_KjU(), RoundedCornerShapeKt.m1573RoundedCornerShape0680j_4(Dp.m9687constructorimpl(24))), Dp.m9687constructorimpl(16)), "BoxAi:QA:Prompt"), BoxTheme.INSTANCE.getColors(composerStartRestartGroup, BoxTheme.$stable).m11500getAppPrimary0d7_KjU(), null, 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, TextStyle.m9104copyp1EtxEg$default(BoxTheme.INSTANCE.getTypography().getBoxNormal14(), 0L, 0L, null, null, null, null, null, 0L, null, null, null, 0L, null, null, null, 0, 0, TextUnitKt.getSp(20), null, null, null, 0, 0, null, 16646143, null), composer2, i6, 0, 131064);
            ComposerKt.sourceInformationMarkerEnd(composer2);
            ComposerKt.sourceInformationMarkerEnd(composer2);
            composer2.endNode();
            ComposerKt.sourceInformationMarkerEnd(composer2);
            ComposerKt.sourceInformationMarkerEnd(composer2);
            ComposerKt.sourceInformationMarkerEnd(composer2);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            modifier2 = modifier4;
        }
        scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.box.android.boxai.ui.BoxAiDialogueItemKt$$ExternalSyntheticLambda3
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return BoxAiDialogueItemKt.BoxAiUserPromptWrapper$lambda$1(str, modifier2, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    private static final void BoxAiAnswerResponse(final BoxAiQaReducer.AiResponse.Answer answer, final boolean z, final boolean z2, final BoxAiQaReducer.AnswerFeedback answerFeedback, final Function1<? super BoxAiQaReducer.AnswerFeedback, Unit> function1, final Function0<Unit> function0, final Function0<Unit> function2, Composer composer, final int i) {
        int i2;
        Composer composerStartRestartGroup = composer.startRestartGroup(607301974);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(BoxAiAnswerResponse)N(response,isResponseFinished,isLastResponse,feedback,onFeedbackClicked,onCopyToClipboardClicked,onCitationsClicked)108@4114L34,109@4178L42,111@4226L1553:BoxAiDialogueItem.kt#bwxcym");
        if ((i & 6) == 0) {
            i2 = (composerStartRestartGroup.changedInstance(answer) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 48) == 0) {
            i2 |= composerStartRestartGroup.changed(z) ? 32 : 16;
        }
        if ((i & 384) == 0) {
            i2 |= composerStartRestartGroup.changed(z2) ? 256 : 128;
        }
        if ((i & 3072) == 0) {
            i2 |= composerStartRestartGroup.changed(answerFeedback == null ? -1 : answerFeedback.ordinal()) ? 2048 : 1024;
        }
        if ((i & 24576) == 0) {
            i2 |= composerStartRestartGroup.changedInstance(function1) ? 16384 : 8192;
        }
        if ((196608 & i) == 0) {
            i2 |= composerStartRestartGroup.changedInstance(function0) ? 131072 : 65536;
        }
        if ((1572864 & i) == 0) {
            i2 |= composerStartRestartGroup.changedInstance(function2) ? 1048576 : 524288;
        }
        int i3 = i2;
        if (!composerStartRestartGroup.shouldExecute((599187 & i3) != 599186, i3 & 1)) {
            composerStartRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(607301974, i3, -1, "com.box.android.boxai.ui.BoxAiAnswerResponse (BoxAiDialogueItem.kt:107)");
            }
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -498343752, "CC(remember):BoxAiDialogueItem.kt#9igjgp");
            Object objRememberedValue = composerStartRestartGroup.rememberedValue();
            if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                objRememberedValue = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(false, null, 2, null);
                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
            }
            final MutableState mutableState = (MutableState) objRememberedValue;
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -498341696, "CC(remember):BoxAiDialogueItem.kt#9igjgp");
            Object objRememberedValue2 = composerStartRestartGroup.rememberedValue();
            if (objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                objRememberedValue2 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(DpOffset.m9742boximpl(DpOffset.INSTANCE.m9758getZeroRKDOV3M()), null, 2, null);
                composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
            }
            final MutableState mutableState2 = (MutableState) objRememberedValue2;
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1042775818, "CC(Box)N(modifier,contentAlignment,propagateMinConstraints,content)71@3424L131:Box.kt#2w3rfo");
            Modifier.Companion companion = Modifier.INSTANCE;
            MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), false);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
            int iHashCode = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
            CompositionLocalMap currentCompositionLocalMap = composerStartRestartGroup.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composerStartRestartGroup, companion);
            Function0<ComposeUiNode> constructor = ComposeUiNode.INSTANCE.getConstructor();
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
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
            Updater.m6070setimpl(composerM6062constructorimpl, measurePolicyMaybeCachedBoxMeasurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
            Updater.m6070setimpl(composerM6062constructorimpl, currentCompositionLocalMap, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
            Updater.m6066initimpl(composerM6062constructorimpl, Integer.valueOf(iHashCode), ComposeUiNode.INSTANCE.getSetCompositeKeyHash());
            Updater.m6068reconcileimpl(composerM6062constructorimpl, ComposeUiNode.INSTANCE.getApplyOnDeactivatedNodeAssertion());
            Updater.m6070setimpl(composerM6062constructorimpl, modifierMaterializeModifier, ComposeUiNode.INSTANCE.getSetModifier());
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1833054614, "C72@3469L9:Box.kt#2w3rfo");
            BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -2094925046, "C114@4347L200,114@4297L250,112@4240L1093,140@5342L431:BoxAiDialogueItem.kt#bwxcym");
            Modifier.Companion companion2 = Modifier.INSTANCE;
            Boolean boolValueOf = Boolean.valueOf(z);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 348065860, "CC(remember):BoxAiDialogueItem.kt#9igjgp");
            int i4 = i3 & 112;
            boolean z3 = i4 == 32;
            Object objRememberedValue3 = composerStartRestartGroup.rememberedValue();
            if (z3 || objRememberedValue3 == Composer.INSTANCE.getEmpty()) {
                objRememberedValue3 = new Function1() { // from class: com.box.android.boxai.ui.BoxAiDialogueItemKt$$ExternalSyntheticLambda11
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return BoxAiDialogueItemKt.BoxAiAnswerResponse$lambda$6$0$0(z, mutableState, mutableState2, (DpOffset) obj);
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
            }
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            Modifier modifierM1219paddingVpY3zN4 = PaddingKt.m1219paddingVpY3zN4(TestTagKt.testTag(ComposeUtilsKt.longClickableWithOffset(companion2, boolValueOf, (Function1) objRememberedValue3, composerStartRestartGroup, i4 | 6, 0), "BoxAi:QA:Answer"), Dp.m9687constructorimpl(24), Dp.m9687constructorimpl(8));
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1341605231, "CC(Column)N(modifier,verticalArrangement,horizontalAlignment,content)87@4443L61,88@4509L134:Column.kt#2w3rfo");
            MeasurePolicy measurePolicyColumnMeasurePolicy = ColumnKt.columnMeasurePolicy(Arrangement.INSTANCE.getTop(), Alignment.INSTANCE.getStart(), composerStartRestartGroup, 0);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
            int iHashCode2 = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
            CompositionLocalMap currentCompositionLocalMap2 = composerStartRestartGroup.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier2 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierM1219paddingVpY3zN4);
            Function0<ComposeUiNode> constructor2 = ComposeUiNode.INSTANCE.getConstructor();
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
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
            Updater.m6070setimpl(composerM6062constructorimpl2, measurePolicyColumnMeasurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
            Updater.m6070setimpl(composerM6062constructorimpl2, currentCompositionLocalMap2, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
            Updater.m6066initimpl(composerM6062constructorimpl2, Integer.valueOf(iHashCode2), ComposeUiNode.INSTANCE.getSetCompositeKeyHash());
            Updater.m6068reconcileimpl(composerM6062constructorimpl2, ComposeUiNode.INSTANCE.getApplyOnDeactivatedNodeAssertion());
            Updater.m6070setimpl(composerM6062constructorimpl2, modifierMaterializeModifier2, ComposeUiNode.INSTANCE.getSetModifier());
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2093002350, "C89@4557L9:Column.kt#2w3rfo");
            ColumnScopeInstance columnScopeInstance = ColumnScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1016611532, "C123@4678L218,129@4909L40:BoxAiDialogueItem.kt#bwxcym");
            MarkdownViewKt.MarkdownView(answer.getAnswer(), TestTagKt.testTag(SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null), "BoxAi:QA:AnswerText:" + answer.getAnswer()), null, composerStartRestartGroup, 0, 4);
            SpacerKt.Spacer(SizeKt.m1252height3ABfNKs(Modifier.INSTANCE, Dp.m9687constructorimpl(6)), composerStartRestartGroup, 6);
            if (z) {
                composerStartRestartGroup.startReplaceGroup(1016907519);
                ComposerKt.sourceInformation(composerStartRestartGroup, "131@5004L305");
                int i5 = i3 >> 6;
                int i6 = i3 >> 3;
                BoxAiAnswerActionsKt.BoxAiAnswerActionsBar(z2, answer.getCitations(), answerFeedback, function1, function2, composerStartRestartGroup, (i5 & 14) | (i6 & 896) | (i6 & 7168) | (i5 & 57344));
                composerStartRestartGroup = composerStartRestartGroup;
            } else {
                composerStartRestartGroup.startReplaceGroup(1011949968);
            }
            composerStartRestartGroup.endReplaceGroup();
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            composerStartRestartGroup.endNode();
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1042775818, "CC(Box)N(modifier,contentAlignment,propagateMinConstraints,content)71@3424L131:Box.kt#2w3rfo");
            Modifier.Companion companion3 = Modifier.INSTANCE;
            MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy2 = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), false);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
            int iHashCode3 = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
            CompositionLocalMap currentCompositionLocalMap3 = composerStartRestartGroup.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier3 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, companion3);
            Function0<ComposeUiNode> constructor3 = ComposeUiNode.INSTANCE.getConstructor();
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
            if (!(composerStartRestartGroup.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            composerStartRestartGroup.startReusableNode();
            if (composerStartRestartGroup.getInserting()) {
                composerStartRestartGroup.createNode(constructor3);
            } else {
                composerStartRestartGroup.useNode();
            }
            Composer composerM6062constructorimpl3 = Updater.m6062constructorimpl(composerStartRestartGroup);
            Updater.m6070setimpl(composerM6062constructorimpl3, measurePolicyMaybeCachedBoxMeasurePolicy2, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
            Updater.m6070setimpl(composerM6062constructorimpl3, currentCompositionLocalMap3, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
            Updater.m6066initimpl(composerM6062constructorimpl3, Integer.valueOf(iHashCode3), ComposeUiNode.INSTANCE.getSetCompositeKeyHash());
            Updater.m6068reconcileimpl(composerM6062constructorimpl3, ComposeUiNode.INSTANCE.getApplyOnDeactivatedNodeAssertion());
            Updater.m6070setimpl(composerM6062constructorimpl3, modifierMaterializeModifier3, ComposeUiNode.INSTANCE.getSetModifier());
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1833054614, "C72@3469L9:Box.kt#2w3rfo");
            BoxScopeInstance boxScopeInstance2 = BoxScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 364797934, "C143@5459L32,141@5360L403:BoxAiDialogueItem.kt#bwxcym");
            boolean zBoxAiAnswerResponse$lambda$1 = BoxAiAnswerResponse$lambda$1(mutableState);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1951433122, "CC(remember):BoxAiDialogueItem.kt#9igjgp");
            Object objRememberedValue4 = composerStartRestartGroup.rememberedValue();
            if (objRememberedValue4 == Composer.INSTANCE.getEmpty()) {
                objRememberedValue4 = new Function0() { // from class: com.box.android.boxai.ui.BoxAiDialogueItemKt$$ExternalSyntheticLambda12
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return BoxAiDialogueItemKt.BoxAiAnswerResponse$lambda$6$2$0$0(mutableState);
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue4);
            }
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            Composer composer2 = composerStartRestartGroup;
            BoxAiAnswerActionsKt.m12070AnswerDropdownMenuSaJeTKs(zBoxAiAnswerResponse$lambda$1, (Function0) objRememberedValue4, BoxAiAnswerResponse$lambda$4(mutableState2), !z2, answerFeedback, function0, function1, composer2, ((i3 << 3) & 57344) | 48 | (458752 & i3) | (3670016 & (i3 << 6)));
            composerStartRestartGroup = composer2;
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            composerStartRestartGroup.endNode();
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            composerStartRestartGroup.endNode();
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.box.android.boxai.ui.BoxAiDialogueItemKt$$ExternalSyntheticLambda13
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return BoxAiDialogueItemKt.BoxAiAnswerResponse$lambda$7(answer, z, z2, answerFeedback, function1, function0, function2, i, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    private static final boolean BoxAiAnswerResponse$lambda$1(MutableState<Boolean> mutableState) {
        return mutableState.getValue().booleanValue();
    }

    private static final void BoxAiAnswerResponse$lambda$2(MutableState<Boolean> mutableState, boolean z) {
        mutableState.setValue(Boolean.valueOf(z));
    }

    private static final long BoxAiAnswerResponse$lambda$4(MutableState<DpOffset> mutableState) {
        return mutableState.getValue().m9756unboximpl();
    }

    private static final void BoxAiAnswerResponse$lambda$5(MutableState<DpOffset> mutableState, long j) {
        mutableState.setValue(DpOffset.m9742boximpl(j));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit BoxAiAnswerResponse$lambda$6$0$0(boolean z, MutableState mutableState, MutableState mutableState2, DpOffset dpOffset) {
        if (z) {
            BoxAiAnswerResponse$lambda$2(mutableState, true);
            BoxAiAnswerResponse$lambda$5(mutableState2, dpOffset.m9756unboximpl());
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit BoxAiAnswerResponse$lambda$6$2$0$0(MutableState mutableState) {
        BoxAiAnswerResponse$lambda$2(mutableState, false);
        return Unit.INSTANCE;
    }

    /* JADX WARN: Code duplicated, block: B:23:0x0047  */
    /* JADX WARN: Code duplicated, block: B:24:0x0049  */
    /* JADX WARN: Code duplicated, block: B:27:0x0052 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:28:0x0054  */
    /* JADX WARN: Code duplicated, block: B:29:0x0059  */
    /* JADX WARN: Code duplicated, block: B:32:0x0060  */
    /* JADX WARN: Code duplicated, block: B:35:0x00ac  */
    /* JADX WARN: Code duplicated, block: B:38:0x00b8  */
    /* JADX WARN: Code duplicated, block: B:39:0x00bc  */
    /* JADX WARN: Code duplicated, block: B:42:0x0153  */
    /* JADX WARN: Code duplicated, block: B:43:0x015e  */
    /* JADX WARN: Code duplicated, block: B:46:0x01a6  */
    /* JADX WARN: Code duplicated, block: B:48:0x01ab  */
    /* JADX WARN: Code duplicated, block: B:51:0x01b4  */
    /* JADX WARN: Code duplicated, block: B:53:? A[RETURN, SYNTHETIC] */
    private static final void BoxAiErrorResponse(final Function0<Unit> function0, Modifier modifier, Composer composer, final int i, final int i2) {
        int i3;
        final Modifier modifier2;
        boolean z;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        Modifier.Companion companion;
        Function0<ComposeUiNode> constructor;
        Modifier modifier3;
        Composer composerStartRestartGroup = composer.startRestartGroup(-476166165);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(BoxAiErrorResponse)N(onRetryClicked,modifier)156@5894L412:BoxAiDialogueItem.kt#bwxcym");
        if ((i & 6) == 0) {
            i3 = (composerStartRestartGroup.changedInstance(function0) ? 4 : 2) | i;
        } else {
            i3 = i;
        }
        int i4 = i2 & 2;
        if (i4 == 0) {
            if ((i & 48) == 0) {
                modifier2 = modifier;
                i3 |= composerStartRestartGroup.changed(modifier2) ? 32 : 16;
            }
            if ((i3 & 19) != 18) {
                z = true;
            } else {
                z = false;
            }
            if (composerStartRestartGroup.shouldExecute(z, i3 & 1)) {
                composerStartRestartGroup.skipToGroupEnd();
            } else {
                if (i4 != 0) {
                    companion = Modifier.INSTANCE;
                } else {
                    companion = modifier2;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-476166165, i3, -1, "com.box.android.boxai.ui.BoxAiErrorResponse (BoxAiDialogueItem.kt:155)");
                }
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1341605231, "CC(Column)N(modifier,verticalArrangement,horizontalAlignment,content)87@4443L61,88@4509L134:Column.kt#2w3rfo");
                MeasurePolicy measurePolicyColumnMeasurePolicy = ColumnKt.columnMeasurePolicy(Arrangement.INSTANCE.getTop(), Alignment.INSTANCE.getStart(), composerStartRestartGroup, 0);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
                int iHashCode = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
                CompositionLocalMap currentCompositionLocalMap = composerStartRestartGroup.getCurrentCompositionLocalMap();
                Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composerStartRestartGroup, companion);
                constructor = ComposeUiNode.INSTANCE.getConstructor();
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
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
                Updater.m6070setimpl(composerM6062constructorimpl, measurePolicyColumnMeasurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                Updater.m6070setimpl(composerM6062constructorimpl, currentCompositionLocalMap, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                Updater.m6066initimpl(composerM6062constructorimpl, Integer.valueOf(iHashCode), ComposeUiNode.INSTANCE.getSetCompositeKeyHash());
                Updater.m6068reconcileimpl(composerM6062constructorimpl, ComposeUiNode.INSTANCE.getApplyOnDeactivatedNodeAssertion());
                Updater.m6070setimpl(composerM6062constructorimpl, modifierMaterializeModifier, ComposeUiNode.INSTANCE.getSetModifier());
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2093002350, "C89@4557L9:Column.kt#2w3rfo");
                ColumnScopeInstance columnScopeInstance = ColumnScopeInstance.INSTANCE;
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1698751662, "C158@5957L53,160@6094L6,157@5932L221:BoxAiDialogueItem.kt#bwxcym");
                TextKt.m4494TextNvy7gAk(StringResources_androidKt.stringResource(R.string.box_ai_prompt_response_error, composerStartRestartGroup, 0), null, BoxTheme.INSTANCE.getColors(composerStartRestartGroup, BoxTheme.$stable).m11500getAppPrimary0d7_KjU(), null, 0L, null, null, null, 0L, null, null, TextUnitKt.getSp(20), 0, false, 0, 0, null, BoxTheme.INSTANCE.getTypography().getBoxNormal14(), composerStartRestartGroup, 0, 48, 129018);
                if (function0 == null) {
                    composerStartRestartGroup.startReplaceGroup(-1698515258);
                    composerStartRestartGroup.endReplaceGroup();
                    modifier3 = companion;
                } else {
                    composerStartRestartGroup.startReplaceGroup(-1698515257);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "*164@6196L30,165@6255L30,165@6239L51");
                    SpacerKt.Spacer(SizeKt.m1252height3ABfNKs(Modifier.INSTANCE, Dp.m9687constructorimpl(12)), composerStartRestartGroup, 6);
                    modifier3 = companion;
                    BoxAiTextButtonKt.BoxAiTextButton(StringResources_androidKt.stringResource(R.string.retry, composerStartRestartGroup, 0), function0, null, composerStartRestartGroup, 0, 4);
                    composerStartRestartGroup.endReplaceGroup();
                }
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                composerStartRestartGroup.endNode();
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                modifier2 = modifier3;
            }
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.box.android.boxai.ui.BoxAiDialogueItemKt$$ExternalSyntheticLambda6
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return BoxAiDialogueItemKt.BoxAiErrorResponse$lambda$1(function0, modifier2, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                    }
                });
            }
        }
        i3 |= 48;
        modifier2 = modifier;
        if ((i3 & 19) != 18) {
            z = true;
        } else {
            z = false;
        }
        if (composerStartRestartGroup.shouldExecute(z, i3 & 1)) {
            composerStartRestartGroup.skipToGroupEnd();
        } else {
            if (i4 != 0) {
                companion = Modifier.INSTANCE;
            } else {
                companion = modifier2;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-476166165, i3, -1, "com.box.android.boxai.ui.BoxAiErrorResponse (BoxAiDialogueItem.kt:155)");
            }
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1341605231, "CC(Column)N(modifier,verticalArrangement,horizontalAlignment,content)87@4443L61,88@4509L134:Column.kt#2w3rfo");
            MeasurePolicy measurePolicyColumnMeasurePolicy2 = ColumnKt.columnMeasurePolicy(Arrangement.INSTANCE.getTop(), Alignment.INSTANCE.getStart(), composerStartRestartGroup, 0);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
            int iHashCode2 = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
            CompositionLocalMap currentCompositionLocalMap2 = composerStartRestartGroup.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier2 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, companion);
            constructor = ComposeUiNode.INSTANCE.getConstructor();
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
            if (!(composerStartRestartGroup.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            composerStartRestartGroup.startReusableNode();
            if (composerStartRestartGroup.getInserting()) {
                composerStartRestartGroup.createNode(constructor);
            } else {
                composerStartRestartGroup.useNode();
            }
            Composer composerM6062constructorimpl2 = Updater.m6062constructorimpl(composerStartRestartGroup);
            Updater.m6070setimpl(composerM6062constructorimpl2, measurePolicyColumnMeasurePolicy2, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
            Updater.m6070setimpl(composerM6062constructorimpl2, currentCompositionLocalMap2, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
            Updater.m6066initimpl(composerM6062constructorimpl2, Integer.valueOf(iHashCode2), ComposeUiNode.INSTANCE.getSetCompositeKeyHash());
            Updater.m6068reconcileimpl(composerM6062constructorimpl2, ComposeUiNode.INSTANCE.getApplyOnDeactivatedNodeAssertion());
            Updater.m6070setimpl(composerM6062constructorimpl2, modifierMaterializeModifier2, ComposeUiNode.INSTANCE.getSetModifier());
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2093002350, "C89@4557L9:Column.kt#2w3rfo");
            ColumnScopeInstance columnScopeInstance2 = ColumnScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1698751662, "C158@5957L53,160@6094L6,157@5932L221:BoxAiDialogueItem.kt#bwxcym");
            TextKt.m4494TextNvy7gAk(StringResources_androidKt.stringResource(R.string.box_ai_prompt_response_error, composerStartRestartGroup, 0), null, BoxTheme.INSTANCE.getColors(composerStartRestartGroup, BoxTheme.$stable).m11500getAppPrimary0d7_KjU(), null, 0L, null, null, null, 0L, null, null, TextUnitKt.getSp(20), 0, false, 0, 0, null, BoxTheme.INSTANCE.getTypography().getBoxNormal14(), composerStartRestartGroup, 0, 48, 129018);
            if (function0 == null) {
                composerStartRestartGroup.startReplaceGroup(-1698515258);
                composerStartRestartGroup.endReplaceGroup();
                modifier3 = companion;
            } else {
                composerStartRestartGroup.startReplaceGroup(-1698515257);
                ComposerKt.sourceInformation(composerStartRestartGroup, "*164@6196L30,165@6255L30,165@6239L51");
                SpacerKt.Spacer(SizeKt.m1252height3ABfNKs(Modifier.INSTANCE, Dp.m9687constructorimpl(12)), composerStartRestartGroup, 6);
                modifier3 = companion;
                BoxAiTextButtonKt.BoxAiTextButton(StringResources_androidKt.stringResource(R.string.retry, composerStartRestartGroup, 0), function0, null, composerStartRestartGroup, 0, 4);
                composerStartRestartGroup.endReplaceGroup();
            }
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            composerStartRestartGroup.endNode();
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            modifier2 = modifier3;
        }
        scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.box.android.boxai.ui.BoxAiDialogueItemKt$$ExternalSyntheticLambda6
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return BoxAiDialogueItemKt.BoxAiErrorResponse$lambda$1(function0, modifier2, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    private static final void BoxAiDialogueItemAnswerPreview(Composer composer, final int i) {
        Composer composerStartRestartGroup = composer.startRestartGroup(-526512054);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(BoxAiDialogueItemAnswerPreview)176@6471L965:BoxAiDialogueItem.kt#bwxcym");
        if (!composerStartRestartGroup.shouldExecute(i != 0, i & 1)) {
            composerStartRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-526512054, i, -1, "com.box.android.boxai.ui.BoxAiDialogueItemAnswerPreview (BoxAiDialogueItem.kt:175)");
            }
            BoxThemeKt.BoxTheme(ComposableSingletons$BoxAiDialogueItemKt.INSTANCE.m12104getLambda$860801387$boxai_generalProdRelease(), composerStartRestartGroup, 6);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.box.android.boxai.ui.BoxAiDialogueItemKt$$ExternalSyntheticLambda8
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return BoxAiDialogueItemKt.BoxAiDialogueItemAnswerPreview$lambda$0(i, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    private static final void BoxAiDialogueItemAnswerWithFeedbackInContextMenuButtonsPreview(Composer composer, final int i) {
        Composer composerStartRestartGroup = composer.startRestartGroup(-1930823699);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(BoxAiDialogueItemAnswerWithFeedbackInContextMenuButtonsPreview)207@7628L33,209@7676L671,209@7667L680:BoxAiDialogueItem.kt#bwxcym");
        if (!composerStartRestartGroup.shouldExecute(i != 0, i & 1)) {
            composerStartRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1930823699, i, -1, "com.box.android.boxai.ui.BoxAiDialogueItemAnswerWithFeedbackInContextMenuButtonsPreview (BoxAiDialogueItem.kt:206)");
            }
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -95698898, "CC(remember):BoxAiDialogueItem.kt#9igjgp");
            Object objRememberedValue = composerStartRestartGroup.rememberedValue();
            if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                objRememberedValue = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(null, null, 2, null);
                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
            }
            final MutableState mutableState = (MutableState) objRememberedValue;
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            BoxThemeKt.BoxTheme(ComposableLambdaKt.rememberComposableLambda(1360605752, true, new Function2() { // from class: com.box.android.boxai.ui.BoxAiDialogueItemKt$$ExternalSyntheticLambda4
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return BoxAiDialogueItemKt.BoxAiDialogueItemAnswerWithFeedbackInContextMenuButtonsPreview$lambda$3(mutableState, (Composer) obj, ((Integer) obj2).intValue());
                }
            }, composerStartRestartGroup, 54), composerStartRestartGroup, 6);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.box.android.boxai.ui.BoxAiDialogueItemKt$$ExternalSyntheticLambda5
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return BoxAiDialogueItemKt.BoxAiDialogueItemAnswerWithFeedbackInContextMenuButtonsPreview$lambda$4(i, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    private static final BoxAiQaReducer.AnswerFeedback BoxAiDialogueItemAnswerWithFeedbackInContextMenuButtonsPreview$lambda$1(MutableState<BoxAiQaReducer.AnswerFeedback> mutableState) {
        return mutableState.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit BoxAiDialogueItemAnswerWithFeedbackInContextMenuButtonsPreview$lambda$3(final MutableState mutableState, Composer composer, int i) {
        ComposerKt.sourceInformation(composer, "C211@7745L6,210@7686L655:BoxAiDialogueItem.kt#bwxcym");
        if (!composer.shouldExecute((i & 3) != 2, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1360605752, i, -1, "com.box.android.boxai.ui.BoxAiDialogueItemAnswerWithFeedbackInContextMenuButtonsPreview.<anonymous> (BoxAiDialogueItem.kt:210)");
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
            ComposerKt.sourceInformationMarkerStart(composer, 2030965487, "C221@8175L17,222@8237L2,223@8278L2,224@8315L2,213@7797L534:BoxAiDialogueItem.kt#bwxcym");
            BoxAiQaReducer.DialogueItem dialogueItem = new BoxAiQaReducer.DialogueItem("Ipsem lorum", new BoxAiQaReducer.AiResponse.Answer("dolor sit", null, 2, null), null, true, null, BoxAiDialogueItemAnswerWithFeedbackInContextMenuButtonsPreview$lambda$1(mutableState), 20, null);
            ComposerKt.sourceInformationMarkerStart(composer, 481168591, "CC(remember):BoxAiDialogueItem.kt#9igjgp");
            Object objRememberedValue = composer.rememberedValue();
            if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                objRememberedValue = new Function1() { // from class: com.box.android.boxai.ui.BoxAiDialogueItemKt$$ExternalSyntheticLambda14
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return BoxAiDialogueItemKt.BoxAiDialogueItemAnswerWithFeedbackInContextMenuButtonsPreview$lambda$3$0$0$0(mutableState, (BoxAiQaReducer.AnswerFeedback) obj);
                    }
                };
                composer.updateRememberedValue(objRememberedValue);
            }
            Function1 function1 = (Function1) objRememberedValue;
            ComposerKt.sourceInformationMarkerEnd(composer);
            ComposerKt.sourceInformationMarkerStart(composer, 481170560, "CC(remember):BoxAiDialogueItem.kt#9igjgp");
            Object objRememberedValue2 = composer.rememberedValue();
            if (objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                objRememberedValue2 = new Function1() { // from class: com.box.android.boxai.ui.BoxAiDialogueItemKt$$ExternalSyntheticLambda15
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return BoxAiDialogueItemKt.BoxAiDialogueItemAnswerWithFeedbackInContextMenuButtonsPreview$lambda$3$0$1$0((String) obj);
                    }
                };
                composer.updateRememberedValue(objRememberedValue2);
            }
            Function1 function2 = (Function1) objRememberedValue2;
            ComposerKt.sourceInformationMarkerEnd(composer);
            ComposerKt.sourceInformationMarkerStart(composer, 481171872, "CC(remember):BoxAiDialogueItem.kt#9igjgp");
            Object objRememberedValue3 = composer.rememberedValue();
            if (objRememberedValue3 == Composer.INSTANCE.getEmpty()) {
                objRememberedValue3 = new Function1() { // from class: com.box.android.boxai.ui.BoxAiDialogueItemKt$$ExternalSyntheticLambda16
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return BoxAiDialogueItemKt.BoxAiDialogueItemAnswerWithFeedbackInContextMenuButtonsPreview$lambda$3$0$2$0((List) obj);
                    }
                };
                composer.updateRememberedValue(objRememberedValue3);
            }
            Function1 function3 = (Function1) objRememberedValue3;
            ComposerKt.sourceInformationMarkerEnd(composer);
            ComposerKt.sourceInformationMarkerStart(composer, 481173056, "CC(remember):BoxAiDialogueItem.kt#9igjgp");
            Object objRememberedValue4 = composer.rememberedValue();
            if (objRememberedValue4 == Composer.INSTANCE.getEmpty()) {
                objRememberedValue4 = new Function0() { // from class: com.box.android.boxai.ui.BoxAiDialogueItemKt$$ExternalSyntheticLambda17
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return Unit.INSTANCE;
                    }
                };
                composer.updateRememberedValue(objRememberedValue4);
            }
            ComposerKt.sourceInformationMarkerEnd(composer);
            BoxAiDialogueItem(dialogueItem, false, function1, function2, function3, (Function0) objRememberedValue4, composer, 224688);
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
    public static final Unit BoxAiDialogueItemAnswerWithFeedbackInContextMenuButtonsPreview$lambda$3$0$0$0(MutableState mutableState, BoxAiQaReducer.AnswerFeedback it) {
        Intrinsics.checkNotNullParameter(it, "it");
        mutableState.setValue(it);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit BoxAiDialogueItemAnswerWithFeedbackInContextMenuButtonsPreview$lambda$3$0$1$0(String it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit BoxAiDialogueItemAnswerWithFeedbackInContextMenuButtonsPreview$lambda$3$0$2$0(List it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return Unit.INSTANCE;
    }

    private static final void BoxAiDialogueItemAnswerWithContextMenuAndMarkdownPreview(Composer composer, final int i) {
        Composer composerStartRestartGroup = composer.startRestartGroup(-201603160);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(BoxAiDialogueItemAnswerWithContextMenuAndMarkdownPreview)234@8485L1485:BoxAiDialogueItem.kt#bwxcym");
        if (!composerStartRestartGroup.shouldExecute(i != 0, i & 1)) {
            composerStartRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-201603160, i, -1, "com.box.android.boxai.ui.BoxAiDialogueItemAnswerWithContextMenuAndMarkdownPreview (BoxAiDialogueItem.kt:233)");
            }
            BoxThemeKt.BoxTheme(ComposableSingletons$BoxAiDialogueItemKt.INSTANCE.m12103getLambda$242526669$boxai_generalProdRelease(), composerStartRestartGroup, 6);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.box.android.boxai.ui.BoxAiDialogueItemKt$$ExternalSyntheticLambda7
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return BoxAiDialogueItemKt.BoxAiDialogueItemAnswerWithContextMenuAndMarkdownPreview$lambda$0(i, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    private static final void BoxAiDialogueItemLoadingPreview(Composer composer, final int i) {
        Composer composerStartRestartGroup = composer.startRestartGroup(256440936);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(BoxAiDialogueItemLoadingPreview)274@10083L528:BoxAiDialogueItem.kt#bwxcym");
        if (!composerStartRestartGroup.shouldExecute(i != 0, i & 1)) {
            composerStartRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(256440936, i, -1, "com.box.android.boxai.ui.BoxAiDialogueItemLoadingPreview (BoxAiDialogueItem.kt:273)");
            }
            BoxThemeKt.BoxTheme(ComposableSingletons$BoxAiDialogueItemKt.INSTANCE.m12102getLambda$1516593795$boxai_generalProdRelease(), composerStartRestartGroup, 6);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.box.android.boxai.ui.BoxAiDialogueItemKt$$ExternalSyntheticLambda2
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return BoxAiDialogueItemKt.BoxAiDialogueItemLoadingPreview$lambda$0(i, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    private static final void BoxAiDialogueItemErrorPreview(Composer composer, final int i) {
        Composer composerStartRestartGroup = composer.startRestartGroup(1769388340);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(BoxAiDialogueItemErrorPreview)297@10722L630:BoxAiDialogueItem.kt#bwxcym");
        if (!composerStartRestartGroup.shouldExecute(i != 0, i & 1)) {
            composerStartRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1769388340, i, -1, "com.box.android.boxai.ui.BoxAiDialogueItemErrorPreview (BoxAiDialogueItem.kt:296)");
            }
            BoxThemeKt.BoxTheme(ComposableSingletons$BoxAiDialogueItemKt.INSTANCE.getLambda$1620057481$boxai_generalProdRelease(), composerStartRestartGroup, 6);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.box.android.boxai.ui.BoxAiDialogueItemKt$$ExternalSyntheticLambda1
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return BoxAiDialogueItemKt.BoxAiDialogueItemErrorPreview$lambda$0(i, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }
}
