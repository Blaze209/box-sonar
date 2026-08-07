package com.box.android.boxai.qa;

import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.ColumnKt;
import androidx.compose.foundation.layout.ColumnScope;
import androidx.compose.foundation.layout.ColumnScopeInstance;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.lazy.LazyDslKt;
import androidx.compose.foundation.lazy.LazyItemScope;
import androidx.compose.foundation.lazy.LazyListScope;
import androidx.compose.foundation.lazy.LazyListState;
import androidx.compose.foundation.lazy.LazyListStateKt;
import androidx.compose.material3.SnackbarHostState;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.State;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.platform.TestTagKt;
import androidx.compose.ui.res.StringResources_androidKt;
import androidx.compose.ui.unit.Dp;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.compose.FlowExtKt;
import androidx.window.core.layout.WindowSizeClass;
import com.box.android.base.compose.BoxSizes;
import com.box.android.base.compose.BoxThemeKt;
import com.box.android.base.compose.SwipeableSnackbarHostKt;
import com.box.android.base.presentation.components.CopyTextReducer;
import com.box.android.boxai.R;
import com.box.android.boxai.citations.BoxAiCitationsModalKt;
import com.box.android.boxai.citations.BoxAiCitationsReducer;
import com.box.android.boxai.clearchat.BoxAiClearChatConfirmationDialogKt;
import com.box.android.boxai.clearchat.BoxAiClearChatReducer;
import com.box.android.boxai.prompt.BoxAiPromptInputBoxKt;
import com.box.android.boxai.prompt.BoxAiPromptReducer;
import com.box.android.boxai.ui.BoxAITheme;
import com.box.android.boxai.ui.BoxAiDialogueHeaderKt;
import com.box.android.boxai.ui.BoxAiDialogueItemKt;
import com.box.android.boxai.ui.BoxAiFileListSheetKt;
import com.box.android.boxai.ui.BoxAiWelcomeMessageKt;
import com.box.android.cpl.Store;
import com.box.android.domain.models.boxai.AiCitationModel;
import com.box.android.domain.models.item.FileModel;
import dev.chrisbanes.haze.HazeKt;
import dev.chrisbanes.haze.HazeState;
import external.sdk.pendo.io.mozilla.javascript.Token;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.reflect.KFunction;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: compiled from: BoxAiQaScreen.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u00002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0006\u001a+\u0010\u0005\u001a\u00020\u00062\u0012\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\n0\b2\b\u0010\u000b\u001a\u0004\u0018\u00010\fH\u0007¢\u0006\u0002\u0010\r\u001a9\u0010\u000e\u001a\u00020\u00062\u0012\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\n0\b2\b\u0010\u000b\u001a\u0004\u0018\u00010\f2\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00110\u0010H\u0003¢\u0006\u0002\u0010\u0012\u001a\r\u0010\u0013\u001a\u00020\u0006H\u0003¢\u0006\u0002\u0010\u0014\u001a\r\u0010\u0015\u001a\u00020\u0006H\u0003¢\u0006\u0002\u0010\u0014\"\u0013\u0010\u0000\u001a\u00020\u0001¢\u0006\n\n\u0002\u0010\u0004\u001a\u0004\b\u0002\u0010\u0003¨\u0006\u0016²\u0006\n\u0010\u0017\u001a\u00020\tX\u008a\u0084\u0002²\u0006\n\u0010\u0017\u001a\u00020\tX\u008a\u0084\u0002"}, d2 = {"SMALL_SHEET_QA_SCREEN_SIZE", "Landroidx/compose/ui/unit/Dp;", "getSMALL_SHEET_QA_SCREEN_SIZE", "()F", "F", "BoxAiQaScreen", "", "store", "Lcom/box/android/cpl/Store;", "Lcom/box/android/boxai/qa/BoxAiQaReducer$State;", "Lcom/box/android/boxai/qa/BoxAiQaReducer$Action;", "hazeState", "Ldev/chrisbanes/haze/HazeState;", "(Lcom/box/android/cpl/Store;Ldev/chrisbanes/haze/HazeState;Landroidx/compose/runtime/Composer;I)V", "BoxAiDialogueHistory", "dialogueHistory", "", "Lcom/box/android/boxai/qa/BoxAiQaReducer$DialogueItem;", "(Lcom/box/android/cpl/Store;Ldev/chrisbanes/haze/HazeState;Ljava/util/List;Landroidx/compose/runtime/Composer;I)V", "BoxAiQADialogueScreenPreview", "(Landroidx/compose/runtime/Composer;I)V", "BoxAiQAEmptyScreenPreview", "boxai_generalProdRelease", "state"}, k = 2, mv = {2, 2, 0}, xi = 48)
public final class BoxAiQaScreenKt {
    private static final float SMALL_SHEET_QA_SCREEN_SIZE = Dp.m9687constructorimpl(Dp.m9687constructorimpl(420) + BoxSizes.INSTANCE.m11614getTopBarHeightD9Ej5fM());

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit BoxAiDialogueHistory$lambda$4(Store store, HazeState hazeState, List list, int i, Composer composer, int i2) {
        BoxAiDialogueHistory(store, hazeState, list, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit BoxAiQADialogueScreenPreview$lambda$0(int i, Composer composer, int i2) {
        BoxAiQADialogueScreenPreview(composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit BoxAiQAEmptyScreenPreview$lambda$0(int i, Composer composer, int i2) {
        BoxAiQAEmptyScreenPreview(composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit BoxAiQaScreen$lambda$9(Store store, HazeState hazeState, int i, Composer composer, int i2) {
        BoxAiQaScreen(store, hazeState, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    public static final float getSMALL_SHEET_QA_SCREEN_SIZE() {
        return SMALL_SHEET_QA_SCREEN_SIZE;
    }

    public static final void BoxAiQaScreen(Store<BoxAiQaReducer.State, BoxAiQaReducer.Action> store, final HazeState hazeState, Composer composer, final int i) {
        int i2;
        SnackbarHostState snackbarHostState;
        boolean z;
        final Store<BoxAiQaReducer.State, BoxAiQaReducer.Action> store2 = store;
        Intrinsics.checkNotNullParameter(store2, "store");
        Composer composerStartRestartGroup = composer.startRestartGroup(-35156254);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(BoxAiQaScreen)N(store,hazeState)56@2660L29,58@2719L49,61@2890L44,76@3277L1873,135@5698L37,137@5803L57,134@5611L255,140@5872L33:BoxAiQaScreen.kt#bwxcuy");
        if ((i & 6) == 0) {
            i2 = (composerStartRestartGroup.changed(store2) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 48) == 0) {
            i2 |= composerStartRestartGroup.changed(hazeState) ? 32 : 16;
        }
        if (!composerStartRestartGroup.shouldExecute((i2 & 19) != 18, i2 & 1)) {
            composerStartRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-35156254, i2, -1, "com.box.android.boxai.qa.BoxAiQaScreen (BoxAiQaScreen.kt:55)");
            }
            State stateCollectAsStateWithLifecycle = FlowExtKt.collectAsStateWithLifecycle(store2.getState(), (LifecycleOwner) null, (Lifecycle.State) null, (CoroutineContext) null, composerStartRestartGroup, 0, 7);
            String strStringResource = StringResources_androidKt.stringResource(R.string.box_ai_voice_input_error, composerStartRestartGroup, 0);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 574589870, "CC(remember):BoxAiQaScreen.kt#9igjgp");
            Object objRememberedValue = composerStartRestartGroup.rememberedValue();
            if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                objRememberedValue = new SnackbarHostState();
                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
            }
            SnackbarHostState snackbarHostState2 = (SnackbarHostState) objRememberedValue;
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            List<BoxAiQaReducer.DialogueItem> dialogueHistory = BoxAiQaScreen$lambda$0(stateCollectAsStateWithLifecycle).getDialogueHistory();
            Modifier modifierThen = Modifier.INSTANCE.then(dialogueHistory.isEmpty() ? SizeKt.m1252height3ABfNKs(Modifier.INSTANCE, SMALL_SHEET_QA_SCREEN_SIZE) : Modifier.INSTANCE);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1341605231, "CC(Column)N(modifier,verticalArrangement,horizontalAlignment,content)87@4443L61,88@4509L134:Column.kt#2w3rfo");
            MeasurePolicy measurePolicyColumnMeasurePolicy = ColumnKt.columnMeasurePolicy(Arrangement.INSTANCE.getTop(), Alignment.INSTANCE.getStart(), composerStartRestartGroup, 0);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
            int iHashCode = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
            CompositionLocalMap currentCompositionLocalMap = composerStartRestartGroup.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierThen);
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
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 438100821, "C77@3394L1340,116@4938L81,119@5093L40,112@4743L401:BoxAiQaScreen.kt#bwxcuy");
            Modifier modifierWeight$default = ColumnScope.weight$default(columnScopeInstance, SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null), 1.0f, false, 2, null);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1042775818, "CC(Box)N(modifier,contentAlignment,propagateMinConstraints,content)71@3424L131:Box.kt#2w3rfo");
            MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), false);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
            int iHashCode2 = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
            CompositionLocalMap currentCompositionLocalMap2 = composerStartRestartGroup.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier2 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierWeight$default);
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
            Updater.m6070setimpl(composerM6062constructorimpl2, measurePolicyMaybeCachedBoxMeasurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
            Updater.m6070setimpl(composerM6062constructorimpl2, currentCompositionLocalMap2, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
            Updater.m6066initimpl(composerM6062constructorimpl2, Integer.valueOf(iHashCode2), ComposeUiNode.INSTANCE.getSetCompositeKeyHash());
            Updater.m6068reconcileimpl(composerM6062constructorimpl2, ComposeUiNode.INSTANCE.getApplyOnDeactivatedNodeAssertion());
            Updater.m6070setimpl(composerM6062constructorimpl2, modifierMaterializeModifier2, ComposeUiNode.INSTANCE.getSetModifier());
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1833054614, "C72@3469L9:Box.kt#2w3rfo");
            BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 62621409, "C82@3504L155,88@3673L157:BoxAiQaScreen.kt#bwxcuy");
            int i3 = i2 & 14;
            BoxAiDialogueHistory(store2, hazeState, dialogueHistory, composerStartRestartGroup, i2 & 126);
            SwipeableSnackbarHostKt.SwipeableSnackbarHost(snackbarHostState2, boxScopeInstance.align(Modifier.INSTANCE, Alignment.INSTANCE.getBottomCenter()), composerStartRestartGroup, 6, 0);
            if (!BoxAiQaScreen$lambda$0(stateCollectAsStateWithLifecycle).getCopyTextState().getShowCopyNotification()) {
                snackbarHostState = snackbarHostState2;
                z = true;
                composerStartRestartGroup.startReplaceGroup(59106628);
            } else {
                composerStartRestartGroup.startReplaceGroup(62974436);
                ComposerKt.sourceInformation(composerStartRestartGroup, "94@3908L224");
                z = true;
                snackbarHostState = snackbarHostState2;
                BoxAiQaScreen$ShowSnackbar(store2, snackbarHostState, R.string.copied_to_clipboard, new BoxAiQaReducer.Action.CopyTextAction(CopyTextReducer.Action.CopiedToClipboardNotificationShown.INSTANCE), composerStartRestartGroup, CopyTextReducer.Action.$stable << 3);
            }
            composerStartRestartGroup.endReplaceGroup();
            if (!BoxAiQaScreen$lambda$0(stateCollectAsStateWithLifecycle).getClearChatState().getShouldShowChatClearedInfo()) {
                composerStartRestartGroup.startReplaceGroup(59106628);
            } else {
                composerStartRestartGroup.startReplaceGroup(63292651);
                ComposerKt.sourceInformation(composerStartRestartGroup, "100@4229L217");
                BoxAiQaScreen$ShowSnackbar(store, snackbarHostState, R.string.box_ai_chat_cleared, new BoxAiQaReducer.Action.ClearChatAction(BoxAiClearChatReducer.Action.ChatClearedInfoShown.INSTANCE), composerStartRestartGroup, 0);
            }
            composerStartRestartGroup.endReplaceGroup();
            if (!BoxAiQaScreen$lambda$0(stateCollectAsStateWithLifecycle).getShouldShowFeedbackSubmitted()) {
                store2 = store;
                composerStartRestartGroup.startReplaceGroup(59106628);
            } else {
                composerStartRestartGroup.startReplaceGroup(63590096);
                ComposerKt.sourceInformation(composerStartRestartGroup, "106@4530L180");
                store2 = store;
                BoxAiQaScreen$ShowSnackbar(store2, snackbarHostState, R.string.box_ai_thanks_for_feedback, BoxAiQaReducer.Action.FeedbackSubmittedShown.INSTANCE, composerStartRestartGroup, 48);
            }
            composerStartRestartGroup.endReplaceGroup();
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            composerStartRestartGroup.endNode();
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            BoxAiPromptReducer.State promptInputState = BoxAiQaScreen$lambda$0(stateCollectAsStateWithLifecycle).getPromptInputState();
            boolean z2 = !BoxAiQaScreen$lambda$0(stateCollectAsStateWithLifecycle).getHasRequestInProgress();
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1676748009, "CC(remember):BoxAiQaScreen.kt#9igjgp");
            boolean zChanged = composerStartRestartGroup.changed(strStringResource);
            BoxAiQaScreenKt$BoxAiQaScreen$2$2$1 boxAiQaScreenKt$BoxAiQaScreen$2$2$1RememberedValue = composerStartRestartGroup.rememberedValue();
            if (zChanged || boxAiQaScreenKt$BoxAiQaScreen$2$2$1RememberedValue == Composer.INSTANCE.getEmpty()) {
                boxAiQaScreenKt$BoxAiQaScreen$2$2$1RememberedValue = new BoxAiQaScreenKt$BoxAiQaScreen$2$2$1(snackbarHostState, strStringResource, null);
                composerStartRestartGroup.updateRememberedValue(boxAiQaScreenKt$BoxAiQaScreen$2$2$1RememberedValue);
            }
            Function1 function1 = (Function1) boxAiQaScreenKt$BoxAiQaScreen$2$2$1RememberedValue;
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            BoxAiQaScreenKt$BoxAiQaScreen$2$3 boxAiQaScreenKt$BoxAiQaScreen$2$3 = new PropertyReference1Impl() { // from class: com.box.android.boxai.qa.BoxAiQaScreenKt$BoxAiQaScreen$2$3
                @Override // kotlin.jvm.internal.PropertyReference1Impl, kotlin.reflect.KProperty1
                public Object get(Object obj) {
                    return ((BoxAiQaReducer.State) obj).getPromptInputState();
                }
            };
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1676752928, "CC(remember):BoxAiQaScreen.kt#9igjgp");
            BoxAiQaScreenKt$BoxAiQaScreen$2$4$1 boxAiQaScreenKt$BoxAiQaScreen$2$4$1RememberedValue = composerStartRestartGroup.rememberedValue();
            if (boxAiQaScreenKt$BoxAiQaScreen$2$4$1RememberedValue == Composer.INSTANCE.getEmpty()) {
                boxAiQaScreenKt$BoxAiQaScreen$2$4$1RememberedValue = BoxAiQaScreenKt$BoxAiQaScreen$2$4$1.INSTANCE;
                composerStartRestartGroup.updateRememberedValue(boxAiQaScreenKt$BoxAiQaScreen$2$4$1RememberedValue);
            }
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            BoxAiPromptInputBoxKt.BoxAiPromptInputBox(promptInputState, true, z2, function1, store2.scope(boxAiQaScreenKt$BoxAiQaScreen$2$3, (Function1) ((KFunction) boxAiQaScreenKt$BoxAiQaScreen$2$4$1RememberedValue)), composerStartRestartGroup, 48);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            composerStartRestartGroup.endNode();
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            if (!BoxAiQaScreen$lambda$0(stateCollectAsStateWithLifecycle).getClearChatState().getShouldShowConfirmationDialog()) {
                composerStartRestartGroup.startReplaceGroup(629547552);
            } else {
                composerStartRestartGroup.startReplaceGroup(634730070);
                ComposerKt.sourceInformation(composerStartRestartGroup, "125@5291L130,128@5459L130,124@5221L378");
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 574666788, "CC(remember):BoxAiQaScreen.kt#9igjgp");
                boolean z3 = i3 == 4 ? z : false;
                Object objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                if (z3 || objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue2 = new Function0() { // from class: com.box.android.boxai.qa.BoxAiQaScreenKt$$ExternalSyntheticLambda8
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            return BoxAiQaScreenKt.BoxAiQaScreen$lambda$5$0(store2);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                }
                Function0 function0 = (Function0) objRememberedValue2;
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 574672164, "CC(remember):BoxAiQaScreen.kt#9igjgp");
                boolean z4 = i3 == 4 ? z : false;
                Object objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                if (z4 || objRememberedValue3 == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue3 = new Function0() { // from class: com.box.android.boxai.qa.BoxAiQaScreenKt$$ExternalSyntheticLambda9
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            return BoxAiQaScreenKt.BoxAiQaScreen$lambda$6$0(store2);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                }
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                BoxAiClearChatConfirmationDialogKt.BoxAiClearChatConfirmationDialog(function0, (Function0) objRememberedValue3, composerStartRestartGroup, 0);
            }
            composerStartRestartGroup.endReplaceGroup();
            AnonymousClass5 anonymousClass5 = new PropertyReference1Impl() { // from class: com.box.android.boxai.qa.BoxAiQaScreenKt.BoxAiQaScreen.5
                @Override // kotlin.jvm.internal.PropertyReference1Impl, kotlin.reflect.KProperty1
                public Object get(Object obj) {
                    return ((BoxAiQaReducer.State) obj).getCitationsState();
                }
            };
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 574679719, "CC(remember):BoxAiQaScreen.kt#9igjgp");
            BoxAiQaScreenKt$BoxAiQaScreen$6$1 boxAiQaScreenKt$BoxAiQaScreen$6$1RememberedValue = composerStartRestartGroup.rememberedValue();
            if (boxAiQaScreenKt$BoxAiQaScreen$6$1RememberedValue == Composer.INSTANCE.getEmpty()) {
                boxAiQaScreenKt$BoxAiQaScreen$6$1RememberedValue = BoxAiQaScreenKt$BoxAiQaScreen$6$1.INSTANCE;
                composerStartRestartGroup.updateRememberedValue(boxAiQaScreenKt$BoxAiQaScreen$6$1RememberedValue);
            }
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            Store<LocalState, LocalAction> storeScope = store2.scope(anonymousClass5, (Function1) ((KFunction) boxAiQaScreenKt$BoxAiQaScreen$6$1RememberedValue));
            List<FileModel> fileModels = BoxAiQaScreen$lambda$0(stateCollectAsStateWithLifecycle).getFileModels();
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 574683099, "CC(remember):BoxAiQaScreen.kt#9igjgp");
            boolean z5 = i3 == 4 ? z : false;
            Object objRememberedValue4 = composerStartRestartGroup.rememberedValue();
            if (z5 || objRememberedValue4 == Composer.INSTANCE.getEmpty()) {
                objRememberedValue4 = new Function1() { // from class: com.box.android.boxai.qa.BoxAiQaScreenKt$$ExternalSyntheticLambda10
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return BoxAiQaScreenKt.BoxAiQaScreen$lambda$8$0(store2, (AiCitationModel) obj);
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue4);
            }
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            BoxAiCitationsModalKt.BoxAiCitationsModal(storeScope, fileModels, (Function1) objRememberedValue4, composerStartRestartGroup, 0);
            BoxAiFileListSheetKt.BoxAiFileListSheet(store2, composerStartRestartGroup, i3);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.box.android.boxai.qa.BoxAiQaScreenKt$$ExternalSyntheticLambda11
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return BoxAiQaScreenKt.BoxAiQaScreen$lambda$9(store2, hazeState, i, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    private static final void BoxAiQaScreen$ShowSnackbar(Store<BoxAiQaReducer.State, BoxAiQaReducer.Action> store, SnackbarHostState snackbarHostState, int i, BoxAiQaReducer.Action action, Composer composer, int i2) {
        ComposerKt.sourceInformationMarkerStart(composer, -2109911787, "C(ShowSnackbar)N(messageRes,shownAction)69@3110L26,70@3166L99,70@3145L120:BoxAiQaScreen.kt#bwxcuy");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-2109911787, i2, -1, "com.box.android.boxai.qa.BoxAiQaScreen.ShowSnackbar (BoxAiQaScreen.kt:68)");
        }
        String strStringResource = StringResources_androidKt.stringResource(i, composer, i2 & 14);
        Unit unit = Unit.INSTANCE;
        ComposerKt.sourceInformationMarkerStart(composer, -400658344, "CC(remember):BoxAiQaScreen.kt#9igjgp");
        boolean zChanged = ((((i2 & 112) ^ 48) > 32 && composer.changed(action)) || (i2 & 48) == 32) | composer.changed(strStringResource) | composer.changed(store);
        Object objRememberedValue = composer.rememberedValue();
        if (zChanged || objRememberedValue == Composer.INSTANCE.getEmpty()) {
            objRememberedValue = (Function2) new BoxAiQaScreenKt$BoxAiQaScreen$ShowSnackbar$1$1(snackbarHostState, strStringResource, store, action, null);
            composer.updateRememberedValue(objRememberedValue);
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        EffectsKt.LaunchedEffect(unit, (Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object>) objRememberedValue, composer, 6);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit BoxAiQaScreen$lambda$5$0(Store store) {
        store.send(new BoxAiQaReducer.Action.ClearChatAction(BoxAiClearChatReducer.Action.ClearChatConfirmed.INSTANCE));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit BoxAiQaScreen$lambda$6$0(Store store) {
        store.send(new BoxAiQaReducer.Action.ClearChatAction(BoxAiClearChatReducer.Action.ClearChatCancelled.INSTANCE));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit BoxAiQaScreen$lambda$8$0(Store store, AiCitationModel it) {
        Intrinsics.checkNotNullParameter(it, "it");
        store.send(new BoxAiQaReducer.Action.CitationClicked(it));
        return Unit.INSTANCE;
    }

    /* JADX WARN: Code duplicated, block: B:51:0x0149  */
    /* JADX WARN: Code duplicated, block: B:52:0x014b  */
    /* JADX WARN: Code duplicated, block: B:57:0x0161  */
    /* JADX WARN: Code duplicated, block: B:60:0x018d  */
    private static final void BoxAiDialogueHistory(final Store<BoxAiQaReducer.State, BoxAiQaReducer.Action> store, final HazeState hazeState, final List<BoxAiQaReducer.DialogueItem> list, Composer composer, final int i) {
        int i2;
        LazyListState lazyListState;
        boolean z;
        boolean z2;
        int i3;
        int i4;
        Modifier.Companion companionHazeSource$default;
        boolean z3;
        boolean zChanged;
        Object objRememberedValue;
        Composer composerStartRestartGroup = composer.startRestartGroup(-883011936);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(BoxAiDialogueHistory)N(store,hazeState,dialogueHistory)149@6128L23,150@6181L29,152@6293L45,152@6216L122,165@6834L6,171@7142L1590,161@6699L2033:BoxAiQaScreen.kt#bwxcuy");
        if ((i & 6) == 0) {
            i2 = (composerStartRestartGroup.changed(store) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 48) == 0) {
            i2 |= composerStartRestartGroup.changed(hazeState) ? 32 : 16;
        }
        if ((i & 384) == 0) {
            i2 |= composerStartRestartGroup.changedInstance(list) ? 256 : 128;
        }
        if (!composerStartRestartGroup.shouldExecute((i2 & Token.DOTQUERY) != 146, i2 & 1)) {
            composerStartRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-883011936, i2, -1, "com.box.android.boxai.qa.BoxAiDialogueHistory (BoxAiQaScreen.kt:148)");
            }
            LazyListState lazyListStateRememberLazyListState = LazyListStateKt.rememberLazyListState(0, 0, composerStartRestartGroup, 0, 3);
            int i5 = i2;
            final State stateCollectAsStateWithLifecycle = FlowExtKt.collectAsStateWithLifecycle(store.getState(), (LifecycleOwner) null, (Lifecycle.State) null, (CoroutineContext) null, composerStartRestartGroup, 0, 7);
            Integer numValueOf = Integer.valueOf(list.size());
            BoxAiQaReducer.DialogueItem dialogueItem = (BoxAiQaReducer.DialogueItem) CollectionsKt.lastOrNull((List) list);
            BoxAiQaReducer.AiResponse response = dialogueItem != null ? dialogueItem.getResponse() : null;
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1829065805, "CC(remember):BoxAiQaScreen.kt#9igjgp");
            boolean zChanged2 = composerStartRestartGroup.changed(lazyListStateRememberLazyListState);
            BoxAiQaScreenKt$BoxAiDialogueHistory$1$1 boxAiQaScreenKt$BoxAiDialogueHistory$1$1RememberedValue = composerStartRestartGroup.rememberedValue();
            if (zChanged2 || boxAiQaScreenKt$BoxAiDialogueHistory$1$1RememberedValue == Composer.INSTANCE.getEmpty()) {
                boxAiQaScreenKt$BoxAiDialogueHistory$1$1RememberedValue = new BoxAiQaScreenKt$BoxAiDialogueHistory$1$1(lazyListStateRememberLazyListState, null);
                composerStartRestartGroup.updateRememberedValue(boxAiQaScreenKt$BoxAiDialogueHistory$1$1RememberedValue);
            }
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            EffectsKt.LaunchedEffect(numValueOf, response, (Function2) boxAiQaScreenKt$BoxAiDialogueHistory$1$1RememberedValue, composerStartRestartGroup, 0);
            Modifier modifierM589backgroundbw27NRU$default = BackgroundKt.m589backgroundbw27NRU$default(SizeKt.fillMaxSize$default(TestTagKt.testTag(Modifier.INSTANCE, "BoxAi:QA"), 0.0f, 1, null), BoxAITheme.INSTANCE.getColors(composerStartRestartGroup, 6).m12054getContainerBackground0d7_KjU(), null, 2, null);
            if (hazeState != null) {
                i3 = 16;
                lazyListState = lazyListStateRememberLazyListState;
                z = false;
                z2 = true;
                i4 = 4;
                companionHazeSource$default = HazeKt.hazeSource$default(Modifier.INSTANCE, hazeState, 0.0f, null, 6, null);
                if (companionHazeSource$default == null) {
                }
                Modifier modifierThen = modifierM589backgroundbw27NRU$default.then(companionHazeSource$default);
                PaddingValues paddingValuesM1215PaddingValuesa9UjIt4$default = PaddingKt.m1215PaddingValuesa9UjIt4$default(0.0f, Dp.m9687constructorimpl(Dp.m9687constructorimpl(i3) + BoxSizes.INSTANCE.m11614getTopBarHeightD9Ej5fM()), 0.0f, Dp.m9687constructorimpl(8), 5, null);
                Arrangement.Vertical top = Arrangement.INSTANCE.getTop();
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1829094518, "CC(remember):BoxAiQaScreen.kt#9igjgp");
                boolean zChangedInstance = composerStartRestartGroup.changedInstance(list);
                if ((i5 & 14) == i4) {
                    z3 = z2;
                } else {
                    z3 = z;
                }
                zChanged = zChangedInstance | z3 | composerStartRestartGroup.changed(stateCollectAsStateWithLifecycle);
                objRememberedValue = composerStartRestartGroup.rememberedValue();
                if (!zChanged || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue = new Function1() { // from class: com.box.android.boxai.qa.BoxAiQaScreenKt$$ExternalSyntheticLambda3
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            return BoxAiQaScreenKt.BoxAiDialogueHistory$lambda$3$0(list, store, stateCollectAsStateWithLifecycle, (LazyListScope) obj);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                }
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                LazyDslKt.LazyColumn(modifierThen, lazyListState, paddingValuesM1215PaddingValuesa9UjIt4$default, true, top, null, null, false, null, (Function1) objRememberedValue, composerStartRestartGroup, 27648, WindowSizeClass.HEIGHT_DP_MEDIUM_LOWER_BOUND);
                composerStartRestartGroup = composerStartRestartGroup;
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
            } else {
                lazyListState = lazyListStateRememberLazyListState;
                z = false;
                z2 = true;
                i3 = 16;
                i4 = 4;
            }
            companionHazeSource$default = Modifier.INSTANCE;
            Modifier modifierThen2 = modifierM589backgroundbw27NRU$default.then(companionHazeSource$default);
            PaddingValues paddingValuesM1215PaddingValuesa9UjIt4$default2 = PaddingKt.m1215PaddingValuesa9UjIt4$default(0.0f, Dp.m9687constructorimpl(Dp.m9687constructorimpl(i3) + BoxSizes.INSTANCE.m11614getTopBarHeightD9Ej5fM()), 0.0f, Dp.m9687constructorimpl(8), 5, null);
            Arrangement.Vertical top2 = Arrangement.INSTANCE.getTop();
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1829094518, "CC(remember):BoxAiQaScreen.kt#9igjgp");
            boolean zChangedInstance2 = composerStartRestartGroup.changedInstance(list);
            if ((i5 & 14) == i4) {
                z3 = z2;
            } else {
                z3 = z;
            }
            zChanged = zChangedInstance2 | z3 | composerStartRestartGroup.changed(stateCollectAsStateWithLifecycle);
            objRememberedValue = composerStartRestartGroup.rememberedValue();
            if (!zChanged) {
                objRememberedValue = new Function1() { // from class: com.box.android.boxai.qa.BoxAiQaScreenKt$$ExternalSyntheticLambda3
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return BoxAiQaScreenKt.BoxAiDialogueHistory$lambda$3$0(list, store, stateCollectAsStateWithLifecycle, (LazyListScope) obj);
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
            } else {
                objRememberedValue = new Function1() { // from class: com.box.android.boxai.qa.BoxAiQaScreenKt$$ExternalSyntheticLambda3
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return BoxAiQaScreenKt.BoxAiDialogueHistory$lambda$3$0(list, store, stateCollectAsStateWithLifecycle, (LazyListScope) obj);
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
            }
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            LazyDslKt.LazyColumn(modifierThen2, lazyListState, paddingValuesM1215PaddingValuesa9UjIt4$default2, true, top2, null, null, false, null, (Function1) objRememberedValue, composerStartRestartGroup, 27648, WindowSizeClass.HEIGHT_DP_MEDIUM_LOWER_BOUND);
            composerStartRestartGroup = composerStartRestartGroup;
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.box.android.boxai.qa.BoxAiQaScreenKt$$ExternalSyntheticLambda4
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return BoxAiQaScreenKt.BoxAiDialogueHistory$lambda$4(store, hazeState, list, i, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit BoxAiDialogueHistory$lambda$3$0(final List list, final Store store, final State state, LazyListScope LazyColumn) {
        Intrinsics.checkNotNullParameter(LazyColumn, "$this$LazyColumn");
        final List listAsReversed = CollectionsKt.asReversed(list);
        final Function1 function1 = new Function1() { // from class: com.box.android.boxai.qa.BoxAiQaScreenKt$$ExternalSyntheticLambda12
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return BoxAiQaScreenKt.BoxAiDialogueHistory$lambda$3$0$0((BoxAiQaReducer.DialogueItem) obj);
            }
        };
        final BoxAiQaScreenKt$BoxAiDialogueHistory$lambda$3$0$$inlined$items$default$1 boxAiQaScreenKt$BoxAiDialogueHistory$lambda$3$0$$inlined$items$default$1 = new Function1() { // from class: com.box.android.boxai.qa.BoxAiQaScreenKt$BoxAiDialogueHistory$lambda$3$0$$inlined$items$default$1
            @Override // kotlin.jvm.functions.Function1
            public final Void invoke(BoxAiQaReducer.DialogueItem dialogueItem) {
                return null;
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                return invoke((BoxAiQaReducer.DialogueItem) obj);
            }
        };
        LazyColumn.items(listAsReversed.size(), new Function1<Integer, Object>() { // from class: com.box.android.boxai.qa.BoxAiQaScreenKt$BoxAiDialogueHistory$lambda$3$0$$inlined$items$default$2
            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Object invoke(Integer num) {
                return invoke(num.intValue());
            }

            public final Object invoke(int i) {
                return function1.invoke(listAsReversed.get(i));
            }
        }, new Function1<Integer, Object>() { // from class: com.box.android.boxai.qa.BoxAiQaScreenKt$BoxAiDialogueHistory$lambda$3$0$$inlined$items$default$3
            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Object invoke(Integer num) {
                return invoke(num.intValue());
            }

            public final Object invoke(int i) {
                return boxAiQaScreenKt$BoxAiDialogueHistory$lambda$3$0$$inlined$items$default$1.invoke(listAsReversed.get(i));
            }
        }, ComposableLambdaKt.composableLambdaInstance(802480018, true, new Function4<LazyItemScope, Integer, Composer, Integer, Unit>() { // from class: com.box.android.boxai.qa.BoxAiQaScreenKt$BoxAiDialogueHistory$lambda$3$0$$inlined$items$default$4
            @Override // kotlin.jvm.functions.Function4
            public /* bridge */ /* synthetic */ Unit invoke(LazyItemScope lazyItemScope, Integer num, Composer composer, Integer num2) {
                invoke(lazyItemScope, num.intValue(), composer, num2.intValue());
                return Unit.INSTANCE;
            }

            public final void invoke(LazyItemScope lazyItemScope, int i, Composer composer, int i2) {
                int i3;
                ComposerKt.sourceInformation(composer, "CN(it)178@8834L22:LazyDsl.kt#428nma");
                if ((i2 & 6) == 0) {
                    i3 = (composer.changed(lazyItemScope) ? 4 : 2) | i2;
                } else {
                    i3 = i2;
                }
                if ((i2 & 48) == 0) {
                    i3 |= composer.changed(i) ? 32 : 16;
                }
                if (!composer.shouldExecute((i3 & Token.DOTQUERY) != 146, i3 & 1)) {
                    composer.skipToGroupEnd();
                    return;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(802480018, i3, -1, "androidx.compose.foundation.lazy.items.<anonymous> (LazyDsl.kt:178)");
                }
                final BoxAiQaReducer.DialogueItem dialogueItem = (BoxAiQaReducer.DialogueItem) listAsReversed.get(i);
                composer.startReplaceGroup(212736165);
                ComposerKt.sourceInformation(composer, "CN(item)*176@7390L129,179@7564L125,182@7728L136,185@7899L94,173@7227L780:BoxAiQaScreen.kt#bwxcuy");
                boolean zAreEqual = Intrinsics.areEqual(dialogueItem.getPromptId(), ((BoxAiQaReducer.DialogueItem) CollectionsKt.last(list)).getPromptId());
                ComposerKt.sourceInformationMarkerStart(composer, 1253793011, "CC(remember):BoxAiQaScreen.kt#9igjgp");
                boolean zChanged = composer.changed(store) | composer.changed(dialogueItem);
                Object objRememberedValue = composer.rememberedValue();
                if (zChanged || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                    final Store store2 = store;
                    objRememberedValue = (Function1) new Function1<BoxAiQaReducer.AnswerFeedback, Unit>() { // from class: com.box.android.boxai.qa.BoxAiQaScreenKt$BoxAiDialogueHistory$3$1$2$1$1
                        @Override // kotlin.jvm.functions.Function1
                        public /* bridge */ /* synthetic */ Unit invoke(BoxAiQaReducer.AnswerFeedback answerFeedback) {
                            invoke2(answerFeedback);
                            return Unit.INSTANCE;
                        }

                        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                        public final void invoke2(BoxAiQaReducer.AnswerFeedback it) {
                            Intrinsics.checkNotNullParameter(it, "it");
                            store2.send(new BoxAiQaReducer.Action.SubmitFeedback(dialogueItem.getPromptId(), it));
                        }
                    };
                    composer.updateRememberedValue(objRememberedValue);
                }
                Function1 function2 = (Function1) objRememberedValue;
                ComposerKt.sourceInformationMarkerEnd(composer);
                ComposerKt.sourceInformationMarkerStart(composer, 1253798575, "CC(remember):BoxAiQaScreen.kt#9igjgp");
                boolean zChanged2 = composer.changed(store);
                Object objRememberedValue2 = composer.rememberedValue();
                if (zChanged2 || objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                    final Store store3 = store;
                    objRememberedValue2 = (Function1) new Function1<String, Unit>() { // from class: com.box.android.boxai.qa.BoxAiQaScreenKt$BoxAiDialogueHistory$3$1$2$2$1
                        @Override // kotlin.jvm.functions.Function1
                        public /* bridge */ /* synthetic */ Unit invoke(String str) {
                            invoke2(str);
                            return Unit.INSTANCE;
                        }

                        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                        public final void invoke2(String it) {
                            Intrinsics.checkNotNullParameter(it, "it");
                            store3.send(new BoxAiQaReducer.Action.CopyTextAction(new CopyTextReducer.Action.CopyText(it)));
                        }
                    };
                    composer.updateRememberedValue(objRememberedValue2);
                }
                Function1 function3 = (Function1) objRememberedValue2;
                ComposerKt.sourceInformationMarkerEnd(composer);
                ComposerKt.sourceInformationMarkerStart(composer, 1253803834, "CC(remember):BoxAiQaScreen.kt#9igjgp");
                boolean zChanged3 = composer.changed(store);
                Object objRememberedValue3 = composer.rememberedValue();
                if (zChanged3 || objRememberedValue3 == Composer.INSTANCE.getEmpty()) {
                    final Store store4 = store;
                    objRememberedValue3 = (Function1) new Function1<List<? extends AiCitationModel>, Unit>() { // from class: com.box.android.boxai.qa.BoxAiQaScreenKt$BoxAiDialogueHistory$3$1$2$3$1
                        @Override // kotlin.jvm.functions.Function1
                        public /* bridge */ /* synthetic */ Unit invoke(List<? extends AiCitationModel> list2) {
                            invoke2((List<AiCitationModel>) list2);
                            return Unit.INSTANCE;
                        }

                        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                        public final void invoke2(List<AiCitationModel> it) {
                            Intrinsics.checkNotNullParameter(it, "it");
                            store4.send(new BoxAiQaReducer.Action.CitationAction(new BoxAiCitationsReducer.Action.ShowCitations(it)));
                        }
                    };
                    composer.updateRememberedValue(objRememberedValue3);
                }
                Function1 function4 = (Function1) objRememberedValue3;
                ComposerKt.sourceInformationMarkerEnd(composer);
                ComposerKt.sourceInformationMarkerStart(composer, 1253809264, "CC(remember):BoxAiQaScreen.kt#9igjgp");
                boolean zChanged4 = composer.changed(store) | composer.changed(dialogueItem);
                Object objRememberedValue4 = composer.rememberedValue();
                if (zChanged4 || objRememberedValue4 == Composer.INSTANCE.getEmpty()) {
                    final Store store5 = store;
                    objRememberedValue4 = (Function0) new Function0<Unit>() { // from class: com.box.android.boxai.qa.BoxAiQaScreenKt$BoxAiDialogueHistory$3$1$2$4$1
                        @Override // kotlin.jvm.functions.Function0
                        public /* bridge */ /* synthetic */ Unit invoke() {
                            invoke2();
                            return Unit.INSTANCE;
                        }

                        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                        public final void invoke2() {
                            store5.send(new BoxAiQaReducer.Action.Retry(dialogueItem.getPromptId()));
                        }
                    };
                    composer.updateRememberedValue(objRememberedValue4);
                }
                ComposerKt.sourceInformationMarkerEnd(composer);
                BoxAiDialogueItemKt.BoxAiDialogueItem(dialogueItem, zAreEqual, function2, function3, function4, (Function0) objRememberedValue4, composer, 0);
                composer.endReplaceGroup();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
            }
        }));
        LazyListScope.item$default(LazyColumn, "IntroductoryBoxAiMessage", null, ComposableLambdaKt.composableLambdaInstance(1891460725, true, new Function3() { // from class: com.box.android.boxai.qa.BoxAiQaScreenKt$$ExternalSyntheticLambda13
            @Override // kotlin.jvm.functions.Function3
            public final Object invoke(Object obj, Object obj2, Object obj3) {
                return BoxAiQaScreenKt.BoxAiDialogueHistory$lambda$3$0$2(store, state, (LazyItemScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
            }
        }), 2, null);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Object BoxAiDialogueHistory$lambda$3$0$0(BoxAiQaReducer.DialogueItem it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return it.getPromptId();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit BoxAiDialogueHistory$lambda$3$0$2(final Store store, State state, LazyItemScope item, Composer composer, int i) {
        Intrinsics.checkNotNullParameter(item, "$this$item");
        ComposerKt.sourceInformation(composer, "C:BoxAiQaScreen.kt#bwxcuy");
        if (!composer.shouldExecute((i & 17) != 16, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1891460725, i, -1, "com.box.android.boxai.qa.BoxAiDialogueHistory.<anonymous>.<anonymous>.<anonymous> (BoxAiQaScreen.kt:191)");
            }
            if (BoxAiDialogueHistory$lambda$0(state).getHasChatHistory()) {
                composer.startReplaceGroup(-1464419256);
                ComposerKt.sourceInformation(composer, "194@8214L50,192@8117L165");
                BoxAiQaReducer.State stateBoxAiDialogueHistory$lambda$0 = BoxAiDialogueHistory$lambda$0(state);
                ComposerKt.sourceInformationMarkerStart(composer, 922595527, "CC(remember):BoxAiQaScreen.kt#9igjgp");
                boolean zChanged = composer.changed(store);
                Object objRememberedValue = composer.rememberedValue();
                if (zChanged || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue = new Function0() { // from class: com.box.android.boxai.qa.BoxAiQaScreenKt$$ExternalSyntheticLambda0
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            return BoxAiQaScreenKt.BoxAiDialogueHistory$lambda$3$0$2$0$0(store);
                        }
                    };
                    composer.updateRememberedValue(objRememberedValue);
                }
                ComposerKt.sourceInformationMarkerEnd(composer);
                BoxAiDialogueHeaderKt.BoxAiDialogueHeader(stateBoxAiDialogueHistory$lambda$0, (Function0) objRememberedValue, composer, 0);
                composer.endReplaceGroup();
            } else {
                composer.startReplaceGroup(-1464211153);
                ComposerKt.sourceInformation(composer, "199@8417L50,200@8515L65,201@8630L54,197@8320L382");
                BoxAiQaReducer.State stateBoxAiDialogueHistory$lambda$1 = BoxAiDialogueHistory$lambda$0(state);
                ComposerKt.sourceInformationMarkerStart(composer, 922602023, "CC(remember):BoxAiQaScreen.kt#9igjgp");
                boolean zChanged2 = composer.changed(store);
                Object objRememberedValue2 = composer.rememberedValue();
                if (zChanged2 || objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue2 = new Function0() { // from class: com.box.android.boxai.qa.BoxAiQaScreenKt$$ExternalSyntheticLambda5
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            return BoxAiQaScreenKt.BoxAiDialogueHistory$lambda$3$0$2$1$0(store);
                        }
                    };
                    composer.updateRememberedValue(objRememberedValue2);
                }
                Function0 function0 = (Function0) objRememberedValue2;
                ComposerKt.sourceInformationMarkerEnd(composer);
                ComposerKt.sourceInformationMarkerStart(composer, 922605174, "CC(remember):BoxAiQaScreen.kt#9igjgp");
                boolean zChanged3 = composer.changed(store);
                Object objRememberedValue3 = composer.rememberedValue();
                if (zChanged3 || objRememberedValue3 == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue3 = new Function1() { // from class: com.box.android.boxai.qa.BoxAiQaScreenKt$$ExternalSyntheticLambda6
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            return BoxAiQaScreenKt.BoxAiDialogueHistory$lambda$3$0$2$2$0(store, (String) obj);
                        }
                    };
                    composer.updateRememberedValue(objRememberedValue3);
                }
                Function1 function1 = (Function1) objRememberedValue3;
                ComposerKt.sourceInformationMarkerEnd(composer);
                ComposerKt.sourceInformationMarkerStart(composer, 922608843, "CC(remember):BoxAiQaScreen.kt#9igjgp");
                boolean zChanged4 = composer.changed(store);
                Object objRememberedValue4 = composer.rememberedValue();
                if (zChanged4 || objRememberedValue4 == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue4 = new Function1() { // from class: com.box.android.boxai.qa.BoxAiQaScreenKt$$ExternalSyntheticLambda7
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            return BoxAiQaScreenKt.BoxAiDialogueHistory$lambda$3$0$2$3$0(store, (String) obj);
                        }
                    };
                    composer.updateRememberedValue(objRememberedValue4);
                }
                ComposerKt.sourceInformationMarkerEnd(composer);
                BoxAiWelcomeMessageKt.BoxAiWelcomeMessage(stateBoxAiDialogueHistory$lambda$1, function0, function1, (Function1) objRememberedValue4, composer, 0, 0);
                composer.endReplaceGroup();
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit BoxAiDialogueHistory$lambda$3$0$2$0$0(Store store) {
        store.send(BoxAiQaReducer.Action.ShowFileList.INSTANCE);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit BoxAiDialogueHistory$lambda$3$0$2$1$0(Store store) {
        store.send(BoxAiQaReducer.Action.ShowFileList.INSTANCE);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit BoxAiDialogueHistory$lambda$3$0$2$2$0(Store store, String it) {
        Intrinsics.checkNotNullParameter(it, "it");
        store.send(new BoxAiQaReducer.Action.SubmitSuggestedQuestion(it));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit BoxAiDialogueHistory$lambda$3$0$2$3$0(Store store, String it) {
        Intrinsics.checkNotNullParameter(it, "it");
        store.send(new BoxAiQaReducer.Action.SubmitPrompt(it));
        return Unit.INSTANCE;
    }

    private static final void BoxAiQADialogueScreenPreview(Composer composer, final int i) {
        Composer composerStartRestartGroup = composer.startRestartGroup(671161760);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(BoxAiQADialogueScreenPreview)214@8895L2142:BoxAiQaScreen.kt#bwxcuy");
        if (!composerStartRestartGroup.shouldExecute(i != 0, i & 1)) {
            composerStartRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(671161760, i, -1, "com.box.android.boxai.qa.BoxAiQADialogueScreenPreview (BoxAiQaScreen.kt:213)");
            }
            BoxThemeKt.BoxTheme(ComposableSingletons$BoxAiQaScreenKt.INSTANCE.getLambda$1372952619$boxai_generalProdRelease(), composerStartRestartGroup, 6);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.box.android.boxai.qa.BoxAiQaScreenKt$$ExternalSyntheticLambda2
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return BoxAiQaScreenKt.BoxAiQADialogueScreenPreview$lambda$0(i, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    private static final void BoxAiQAEmptyScreenPreview(Composer composer, final int i) {
        Composer composerStartRestartGroup = composer.startRestartGroup(1503947339);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(BoxAiQAEmptyScreenPreview)262@11144L651:BoxAiQaScreen.kt#bwxcuy");
        if (!composerStartRestartGroup.shouldExecute(i != 0, i & 1)) {
            composerStartRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1503947339, i, -1, "com.box.android.boxai.qa.BoxAiQAEmptyScreenPreview (BoxAiQaScreen.kt:261)");
            }
            BoxThemeKt.BoxTheme(ComposableSingletons$BoxAiQaScreenKt.INSTANCE.getLambda$2141057952$boxai_generalProdRelease(), composerStartRestartGroup, 6);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.box.android.boxai.qa.BoxAiQaScreenKt$$ExternalSyntheticLambda1
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return BoxAiQaScreenKt.BoxAiQAEmptyScreenPreview$lambda$0(i, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    private static final BoxAiQaReducer.State BoxAiQaScreen$lambda$0(State<BoxAiQaReducer.State> state) {
        return state.getValue();
    }

    private static final BoxAiQaReducer.State BoxAiDialogueHistory$lambda$0(State<BoxAiQaReducer.State> state) {
        return state.getValue();
    }
}
