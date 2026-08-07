package com.box.android.boxai.ui;

import androidx.compose.foundation.ClickableKt;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.foundation.layout.RowKt;
import androidx.compose.foundation.layout.RowScope;
import androidx.compose.foundation.layout.RowScopeInstance;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.layout.SpacerKt;
import androidx.compose.material.icons.Icons;
import androidx.compose.material.icons.automirrored.outlined.ArrowForwardIosKt;
import androidx.compose.material.icons.filled.ContentCopyKt;
import androidx.compose.material.icons.filled.ThumbDownKt;
import androidx.compose.material.icons.filled.ThumbUpKt;
import androidx.compose.material3.ContentColorKt;
import androidx.compose.material3.IconButtonColors;
import androidx.compose.material3.IconButtonKt;
import androidx.compose.material3.IconKt;
import androidx.compose.material3.TextKt;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.ProvidedValue;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.graphics.vector.ImageVector;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.platform.TestTagKt;
import androidx.compose.ui.res.StringResources_androidKt;
import androidx.compose.ui.unit.Dp;
import com.box.android.base.compose.BoxTheme;
import com.box.android.base.compose.BoxThemeKt;
import com.box.android.base.compose.popup.BoxPopupMenuKt;
import com.box.android.base.compose.popup.model.PopupMenuItem;
import com.box.android.boxai.R;
import com.box.android.boxai.qa.BoxAiQaReducer;
import com.box.android.domain.models.boxai.AiCitationModel;
import com.facebook.react.uimanager.ViewProps;
import com.swmansion.rnscreens.gamma.stack.screen.event.StackScreenDismissEvent;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: BoxAiAnswerActions.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000H\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0007\u001aO\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\u0012\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u00010\n2\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00010\fH\u0007¢\u0006\u0002\u0010\r\u001a+\u0010\u000e\u001a\u00020\u00012\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\u0012\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u00010\nH\u0007¢\u0006\u0002\u0010\u000f\u001a)\u0010\u0010\u001a\u00020\u00012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00010\fH\u0003¢\u0006\u0002\u0010\u0012\u001a?\u0010\u0013\u001a\u00020\u00012\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00172\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00010\f2\b\b\u0002\u0010\u0018\u001a\u00020\u00192\b\b\u0002\u0010\u001a\u001a\u00020\u0003H\u0003¢\u0006\u0002\u0010\u001b\u001aa\u0010\u001c\u001a\u00020\u00012\u0006\u0010\u001d\u001a\u00020\u00032\f\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u00010\f2\u0006\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020\u00032\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\f\u0010\"\u001a\b\u0012\u0004\u0012\u00020\u00010\f2\u0012\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u00010\nH\u0007¢\u0006\u0004\b#\u0010$\u001a\r\u0010%\u001a\u00020\u0001H\u0003¢\u0006\u0002\u0010&¨\u0006'"}, d2 = {"BoxAiAnswerActionsBar", "", "isLastResponse", "", "citations", "", "Lcom/box/android/domain/models/boxai/AiCitationModel;", "feedback", "Lcom/box/android/boxai/qa/BoxAiQaReducer$AnswerFeedback;", "onFeedbackClicked", "Lkotlin/Function1;", "onCitationsClicked", "Lkotlin/Function0;", "(ZLjava/util/List;Lcom/box/android/boxai/qa/BoxAiQaReducer$AnswerFeedback;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function0;Landroidx/compose/runtime/Composer;I)V", "AnswerFeedbackButtons", "(Lcom/box/android/boxai/qa/BoxAiQaReducer$AnswerFeedback;Lkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;I)V", "AnswerCitations", ViewProps.ON_CLICK, "(Ljava/util/List;Lkotlin/jvm/functions/Function0;Landroidx/compose/runtime/Composer;I)V", "AnswerIconButton", "imageVector", "Landroidx/compose/ui/graphics/vector/ImageVector;", "contentDescription", "", "modifier", "Landroidx/compose/ui/Modifier;", "isEnabled", "(Landroidx/compose/ui/graphics/vector/ImageVector;Ljava/lang/String;Lkotlin/jvm/functions/Function0;Landroidx/compose/ui/Modifier;ZLandroidx/compose/runtime/Composer;II)V", "AnswerDropdownMenu", "isExpanded", StackScreenDismissEvent.EVENT_REGISTRATION_NAME, "offset", "Landroidx/compose/ui/unit/DpOffset;", "showFeedbackItems", "onCopyToClipboardClicked", "AnswerDropdownMenu-SaJeTKs", "(ZLkotlin/jvm/functions/Function0;JZLcom/box/android/boxai/qa/BoxAiQaReducer$AnswerFeedback;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;I)V", "BoxAiAnswerActionsBarPreview", "(Landroidx/compose/runtime/Composer;I)V", "boxai_generalProdRelease"}, k = 2, mv = {2, 2, 0}, xi = 48)
public final class BoxAiAnswerActionsKt {

    /* JADX INFO: compiled from: BoxAiAnswerActions.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    public static final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[BoxAiQaReducer.AnswerFeedback.values().length];
            try {
                iArr[BoxAiQaReducer.AnswerFeedback.POSITIVE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[BoxAiQaReducer.AnswerFeedback.NEGATIVE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit AnswerCitations$lambda$2(List list, Function0 function0, int i, Composer composer, int i2) {
        AnswerCitations(list, function0, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit AnswerDropdownMenu_SaJeTKs$lambda$1(boolean z, Function0 function0, long j, boolean z2, BoxAiQaReducer.AnswerFeedback answerFeedback, Function0 function1, Function1 function2, int i, Composer composer, int i2) {
        m12070AnswerDropdownMenuSaJeTKs(z, function0, j, z2, answerFeedback, function1, function2, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit AnswerFeedbackButtons$lambda$1(BoxAiQaReducer.AnswerFeedback answerFeedback, Function1 function1, int i, Composer composer, int i2) {
        AnswerFeedbackButtons(answerFeedback, function1, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit AnswerIconButton$lambda$1(ImageVector imageVector, String str, Function0 function0, Modifier modifier, boolean z, int i, int i2, Composer composer, int i3) {
        AnswerIconButton(imageVector, str, function0, modifier, z, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit BoxAiAnswerActionsBar$lambda$1(boolean z, List list, BoxAiQaReducer.AnswerFeedback answerFeedback, Function1 function1, Function0 function0, int i, Composer composer, int i2) {
        BoxAiAnswerActionsBar(z, list, answerFeedback, function1, function0, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit BoxAiAnswerActionsBarPreview$lambda$0(int i, Composer composer, int i2) {
        BoxAiAnswerActionsBarPreview(composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    public static final void BoxAiAnswerActionsBar(final boolean z, final List<AiCitationModel> citations, final BoxAiQaReducer.AnswerFeedback answerFeedback, final Function1<? super BoxAiQaReducer.AnswerFeedback, Unit> onFeedbackClicked, final Function0<Unit> onCitationsClicked, Composer composer, final int i) {
        int i2;
        Intrinsics.checkNotNullParameter(citations, "citations");
        Intrinsics.checkNotNullParameter(onFeedbackClicked, "onFeedbackClicked");
        Intrinsics.checkNotNullParameter(onCitationsClicked, "onCitationsClicked");
        Composer composerStartRestartGroup = composer.startRestartGroup(1487848593);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(BoxAiAnswerActionsBar)N(isLastResponse,citations,feedback,onFeedbackClicked,onCitationsClicked)49@2138L393:BoxAiAnswerActions.kt#bwxcym");
        if ((i & 6) == 0) {
            i2 = (composerStartRestartGroup.changed(z) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 48) == 0) {
            i2 |= composerStartRestartGroup.changedInstance(citations) ? 32 : 16;
        }
        if ((i & 384) == 0) {
            i2 |= composerStartRestartGroup.changed(answerFeedback == null ? -1 : answerFeedback.ordinal()) ? 256 : 128;
        }
        if ((i & 3072) == 0) {
            i2 |= composerStartRestartGroup.changedInstance(onFeedbackClicked) ? 2048 : 1024;
        }
        if ((i & 24576) == 0) {
            i2 |= composerStartRestartGroup.changedInstance(onCitationsClicked) ? 16384 : 8192;
        }
        if (!composerStartRestartGroup.shouldExecute((i2 & 9363) != 9362, i2 & 1)) {
            composerStartRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1487848593, i2, -1, "com.box.android.boxai.ui.BoxAiAnswerActionsBar (BoxAiAnswerActions.kt:48)");
            }
            Alignment.Vertical centerVertically = Alignment.INSTANCE.getCenterVertically();
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 844473419, "CC(Row)N(modifier,horizontalArrangement,verticalAlignment,content)99@5125L58,100@5188L131:Row.kt#2w3rfo");
            Modifier.Companion companion = Modifier.INSTANCE;
            MeasurePolicy measurePolicyRowMeasurePolicy = RowKt.rowMeasurePolicy(Arrangement.INSTANCE.getStart(), centerVertically, composerStartRestartGroup, 48);
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
            Updater.m6070setimpl(composerM6062constructorimpl, measurePolicyRowMeasurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
            Updater.m6070setimpl(composerM6062constructorimpl, currentCompositionLocalMap, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
            Updater.m6066initimpl(composerM6062constructorimpl, Integer.valueOf(iHashCode), ComposeUiNode.INSTANCE.getSetCompositeKeyHash());
            Updater.m6068reconcileimpl(composerM6062constructorimpl, ComposeUiNode.INSTANCE.getApplyOnDeactivatedNodeAssertion());
            Updater.m6070setimpl(composerM6062constructorimpl, modifierMaterializeModifier, ComposeUiNode.INSTANCE.getSetModifier());
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1456264949, "C101@5233L9:Row.kt#2w3rfo");
            RowScopeInstance rowScopeInstance = RowScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -606657455, "C53@2307L38:BoxAiAnswerActions.kt#bwxcym");
            if (citations.isEmpty()) {
                composerStartRestartGroup.startReplaceGroup(-608850923);
            } else {
                composerStartRestartGroup.startReplaceGroup(-606637585);
                ComposerKt.sourceInformation(composerStartRestartGroup, "51@2242L46");
                AnswerCitations(citations, onCitationsClicked, composerStartRestartGroup, ((i2 >> 3) & 14) | ((i2 >> 9) & 112));
            }
            composerStartRestartGroup.endReplaceGroup();
            SpacerKt.Spacer(RowScope.weight$default(rowScopeInstance, Modifier.INSTANCE, 1.0f, false, 2, null), composerStartRestartGroup, 0);
            if (z) {
                composerStartRestartGroup.startReplaceGroup(-606490242);
                ComposerKt.sourceInformation(composerStartRestartGroup, "55@2388L127");
                AnswerFeedbackButtons(answerFeedback, onFeedbackClicked, composerStartRestartGroup, (i2 >> 6) & 126);
            } else {
                composerStartRestartGroup.startReplaceGroup(-608850923);
            }
            composerStartRestartGroup.endReplaceGroup();
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
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.box.android.boxai.ui.BoxAiAnswerActionsKt$$ExternalSyntheticLambda11
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return BoxAiAnswerActionsKt.BoxAiAnswerActionsBar$lambda$1(z, citations, answerFeedback, onFeedbackClicked, onCitationsClicked, i, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    public static final void AnswerFeedbackButtons(final BoxAiQaReducer.AnswerFeedback answerFeedback, final Function1<? super BoxAiQaReducer.AnswerFeedback, Unit> onFeedbackClicked, Composer composer, final int i) {
        int i2;
        ImageVector thumbUp;
        String strStringResource;
        ImageVector thumbDown;
        String strStringResource2;
        Intrinsics.checkNotNullParameter(onFeedbackClicked, "onFeedbackClicked");
        Composer composerStartRestartGroup = composer.startRestartGroup(1611817440);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(AnswerFeedbackButtons)N(feedback,onFeedbackClicked)65@2681L1593:BoxAiAnswerActions.kt#bwxcym");
        if ((i & 6) == 0) {
            i2 = (composerStartRestartGroup.changed(answerFeedback == null ? -1 : answerFeedback.ordinal()) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 48) == 0) {
            i2 |= composerStartRestartGroup.changedInstance(onFeedbackClicked) ? 32 : 16;
        }
        if (!composerStartRestartGroup.shouldExecute((i2 & 19) != 18, i2 & 1)) {
            composerStartRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1611817440, i2, -1, "com.box.android.boxai.ui.AnswerFeedbackButtons (BoxAiAnswerActions.kt:64)");
            }
            Alignment.Vertical centerVertically = Alignment.INSTANCE.getCenterVertically();
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 844473419, "CC(Row)N(modifier,horizontalArrangement,verticalAlignment,content)99@5125L58,100@5188L131:Row.kt#2w3rfo");
            Modifier.Companion companion = Modifier.INSTANCE;
            MeasurePolicy measurePolicyRowMeasurePolicy = RowKt.rowMeasurePolicy(Arrangement.INSTANCE.getStart(), centerVertically, composerStartRestartGroup, 48);
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
            Updater.m6070setimpl(composerM6062constructorimpl, measurePolicyRowMeasurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
            Updater.m6070setimpl(composerM6062constructorimpl, currentCompositionLocalMap, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
            Updater.m6066initimpl(composerM6062constructorimpl, Integer.valueOf(iHashCode), ComposeUiNode.INSTANCE.getSetCompositeKeyHash());
            Updater.m6068reconcileimpl(composerM6062constructorimpl, ComposeUiNode.INSTANCE.getApplyOnDeactivatedNodeAssertion());
            Updater.m6070setimpl(composerM6062constructorimpl, modifierMaterializeModifier, ComposeUiNode.INSTANCE.getSetModifier());
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1456264949, "C101@5233L9:Row.kt#2w3rfo");
            RowScopeInstance rowScopeInstance = RowScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 412098552, "C79@3410L61,68@2757L724,81@3490L39,93@4197L61,82@3538L730:BoxAiAnswerActions.kt#bwxcym");
            Modifier modifierTestTag = TestTagKt.testTag(Modifier.INSTANCE, "BoxAi:QA:AnswerThumbsUp");
            if ((answerFeedback == null ? -1 : WhenMappings.$EnumSwitchMapping$0[answerFeedback.ordinal()]) == 1) {
                thumbUp = ThumbUpKt.getThumbUp(Icons.Filled.INSTANCE);
            } else {
                thumbUp = androidx.compose.material.icons.outlined.ThumbUpKt.getThumbUp(Icons.Outlined.INSTANCE);
            }
            if ((answerFeedback == null ? -1 : WhenMappings.$EnumSwitchMapping$0[answerFeedback.ordinal()]) == 1) {
                composerStartRestartGroup.startReplaceGroup(1537324874);
                ComposerKt.sourceInformation(composerStartRestartGroup, "75@3137L70");
                strStringResource = StringResources_androidKt.stringResource(R.string.box_ai_feedback_positive_given_talkback_label, composerStartRestartGroup, 0);
                composerStartRestartGroup.endReplaceGroup();
            } else {
                composerStartRestartGroup.startReplaceGroup(1537327908);
                ComposerKt.sourceInformation(composerStartRestartGroup, "76@3232L64");
                strStringResource = StringResources_androidKt.stringResource(R.string.box_ai_feedback_positive_talkback_label, composerStartRestartGroup, 0);
                composerStartRestartGroup.endReplaceGroup();
            }
            boolean z = answerFeedback != BoxAiQaReducer.AnswerFeedback.NEGATIVE;
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1537333601, "CC(remember):BoxAiAnswerActions.kt#9igjgp");
            int i3 = i2 & 112;
            boolean z2 = i3 == 32;
            Object objRememberedValue = composerStartRestartGroup.rememberedValue();
            if (z2 || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                objRememberedValue = new Function0() { // from class: com.box.android.boxai.ui.BoxAiAnswerActionsKt$$ExternalSyntheticLambda8
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return BoxAiAnswerActionsKt.AnswerFeedbackButtons$lambda$0$0$0(onFeedbackClicked);
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
            }
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            AnswerIconButton(thumbUp, strStringResource, (Function0) objRememberedValue, modifierTestTag, z, composerStartRestartGroup, 3072, 0);
            SpacerKt.Spacer(SizeKt.m1271width3ABfNKs(Modifier.INSTANCE, Dp.m9687constructorimpl(8)), composerStartRestartGroup, 6);
            Modifier modifierTestTag2 = TestTagKt.testTag(Modifier.INSTANCE, "BoxAi:QA:AnswerThumbsDown");
            if ((answerFeedback == null ? -1 : WhenMappings.$EnumSwitchMapping$0[answerFeedback.ordinal()]) == 2) {
                thumbDown = ThumbDownKt.getThumbDown(Icons.Filled.INSTANCE);
            } else {
                thumbDown = androidx.compose.material.icons.outlined.ThumbDownKt.getThumbDown(Icons.Outlined.INSTANCE);
            }
            if ((answerFeedback == null ? -1 : WhenMappings.$EnumSwitchMapping$0[answerFeedback.ordinal()]) == 2) {
                composerStartRestartGroup.startReplaceGroup(1537350058);
                ComposerKt.sourceInformation(composerStartRestartGroup, "89@3924L70");
                strStringResource2 = StringResources_androidKt.stringResource(R.string.box_ai_feedback_negative_given_talkback_label, composerStartRestartGroup, 0);
                composerStartRestartGroup.endReplaceGroup();
            } else {
                composerStartRestartGroup.startReplaceGroup(1537353092);
                ComposerKt.sourceInformation(composerStartRestartGroup, "90@4019L64");
                strStringResource2 = StringResources_androidKt.stringResource(R.string.box_ai_feedback_negative_talkback_label, composerStartRestartGroup, 0);
                composerStartRestartGroup.endReplaceGroup();
            }
            boolean z3 = answerFeedback != BoxAiQaReducer.AnswerFeedback.POSITIVE;
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1537358785, "CC(remember):BoxAiAnswerActions.kt#9igjgp");
            boolean z4 = i3 == 32;
            Object objRememberedValue2 = composerStartRestartGroup.rememberedValue();
            if (z4 || objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                objRememberedValue2 = new Function0() { // from class: com.box.android.boxai.ui.BoxAiAnswerActionsKt$$ExternalSyntheticLambda9
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return BoxAiAnswerActionsKt.AnswerFeedbackButtons$lambda$0$1$0(onFeedbackClicked);
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
            }
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            AnswerIconButton(thumbDown, strStringResource2, (Function0) objRememberedValue2, modifierTestTag2, z3, composerStartRestartGroup, 3072, 0);
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
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.box.android.boxai.ui.BoxAiAnswerActionsKt$$ExternalSyntheticLambda10
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return BoxAiAnswerActionsKt.AnswerFeedbackButtons$lambda$1(answerFeedback, onFeedbackClicked, i, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit AnswerFeedbackButtons$lambda$0$0$0(Function1 function1) {
        function1.invoke(BoxAiQaReducer.AnswerFeedback.POSITIVE);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit AnswerFeedbackButtons$lambda$0$1$0(Function1 function1) {
        function1.invoke(BoxAiQaReducer.AnswerFeedback.NEGATIVE);
        return Unit.INSTANCE;
    }

    private static final void AnswerCitations(final List<AiCitationModel> list, final Function0<Unit> function0, Composer composer, final int i) {
        int i2;
        Composer composerStartRestartGroup = composer.startRestartGroup(-674252330);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(AnswerCitations)N(citations,onClick)103@4491L13,100@4379L746:BoxAiAnswerActions.kt#bwxcym");
        if ((i & 6) == 0) {
            i2 = (composerStartRestartGroup.changedInstance(list) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 48) == 0) {
            i2 |= composerStartRestartGroup.changedInstance(function0) ? 32 : 16;
        }
        if (!composerStartRestartGroup.shouldExecute((i2 & 19) != 18, i2 & 1)) {
            composerStartRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-674252330, i2, -1, "com.box.android.boxai.ui.AnswerCitations (BoxAiAnswerActions.kt:99)");
            }
            Alignment.Vertical centerVertically = Alignment.INSTANCE.getCenterVertically();
            Modifier.Companion companion = Modifier.INSTANCE;
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 583578755, "CC(remember):BoxAiAnswerActions.kt#9igjgp");
            boolean z = (i2 & 112) == 32;
            Object objRememberedValue = composerStartRestartGroup.rememberedValue();
            if (z || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                objRememberedValue = new Function0() { // from class: com.box.android.boxai.ui.BoxAiAnswerActionsKt$$ExternalSyntheticLambda3
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return BoxAiAnswerActionsKt.AnswerCitations$lambda$0$0(function0);
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
            }
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            Modifier modifierM632clickableoSLSa3U$default = ClickableKt.m632clickableoSLSa3U$default(companion, false, null, null, null, (Function0) objRememberedValue, 15, null);
            float f = 8;
            Modifier modifierTestTag = TestTagKt.testTag(PaddingKt.m1220paddingVpY3zN4$default(modifierM632clickableoSLSa3U$default, 0.0f, Dp.m9687constructorimpl(f), 1, null), "BoxAi:QA:CitationsButton");
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 844473419, "CC(Row)N(modifier,horizontalArrangement,verticalAlignment,content)99@5125L58,100@5188L131:Row.kt#2w3rfo");
            MeasurePolicy measurePolicyRowMeasurePolicy = RowKt.rowMeasurePolicy(Arrangement.INSTANCE.getStart(), centerVertically, composerStartRestartGroup, 48);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
            int iHashCode = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
            CompositionLocalMap currentCompositionLocalMap = composerStartRestartGroup.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierTestTag);
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
            Updater.m6070setimpl(composerM6062constructorimpl, measurePolicyRowMeasurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
            Updater.m6070setimpl(composerM6062constructorimpl, currentCompositionLocalMap, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
            Updater.m6066initimpl(composerM6062constructorimpl, Integer.valueOf(iHashCode), ComposeUiNode.INSTANCE.getSetCompositeKeyHash());
            Updater.m6068reconcileimpl(composerM6062constructorimpl, ComposeUiNode.INSTANCE.getApplyOnDeactivatedNodeAssertion());
            Updater.m6070setimpl(composerM6062constructorimpl, modifierMaterializeModifier, ComposeUiNode.INSTANCE.getSetModifier());
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1456264949, "C101@5233L9:Row.kt#2w3rfo");
            RowScopeInstance rowScopeInstance = RowScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 342522666, "C109@4696L6,110@4747L78,107@4608L227,112@4844L38,116@5040L6,113@4891L228:BoxAiAnswerActions.kt#bwxcym");
            TextKt.m4494TextNvy7gAk(StringResources_androidKt.pluralStringResource(R.plurals.num_references, list.size(), new Object[]{Integer.valueOf(list.size())}, composerStartRestartGroup, 0), null, BoxTheme.INSTANCE.getColors(composerStartRestartGroup, BoxTheme.$stable).m11571getTextFieldSupportingText0d7_KjU(), null, 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, BoxTheme.INSTANCE.getTypography().getBoxNormal14(), composerStartRestartGroup, 0, 0, 131066);
            composerStartRestartGroup = composerStartRestartGroup;
            SpacerKt.Spacer(SizeKt.m1266size3ABfNKs(Modifier.INSTANCE, Dp.m9687constructorimpl(5)), composerStartRestartGroup, 6);
            IconKt.m3576Iconww6aTOc(ArrowForwardIosKt.getArrowForwardIos(Icons.AutoMirrored.Outlined.INSTANCE), (String) null, SizeKt.m1266size3ABfNKs(Modifier.INSTANCE, Dp.m9687constructorimpl(f)), BoxTheme.INSTANCE.getColors(composerStartRestartGroup, BoxTheme.$stable).m11571getTextFieldSupportingText0d7_KjU(), composerStartRestartGroup, 432, 0);
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
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.box.android.boxai.ui.BoxAiAnswerActionsKt$$ExternalSyntheticLambda4
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return BoxAiAnswerActionsKt.AnswerCitations$lambda$2(list, function0, i, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit AnswerCitations$lambda$0$0(Function0 function0) {
        function0.invoke();
        return Unit.INSTANCE;
    }

    /* JADX WARN: Code duplicated, block: B:37:0x0062  */
    /* JADX WARN: Code duplicated, block: B:38:0x0065  */
    /* JADX WARN: Code duplicated, block: B:40:0x0069  */
    /* JADX WARN: Code duplicated, block: B:42:0x0071  */
    /* JADX WARN: Code duplicated, block: B:43:0x0074  */
    /* JADX WARN: Code duplicated, block: B:48:0x0081  */
    /* JADX WARN: Code duplicated, block: B:49:0x0083  */
    /* JADX WARN: Code duplicated, block: B:52:0x008c A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:53:0x008e  */
    /* JADX WARN: Code duplicated, block: B:54:0x0094  */
    /* JADX WARN: Code duplicated, block: B:56:0x0097  */
    /* JADX WARN: Code duplicated, block: B:57:0x0099  */
    /* JADX WARN: Code duplicated, block: B:60:0x00a0  */
    /* JADX WARN: Code duplicated, block: B:63:0x00dd  */
    /* JADX WARN: Code duplicated, block: B:65:0x00e3  */
    /* JADX WARN: Code duplicated, block: B:68:0x00ed  */
    /* JADX WARN: Code duplicated, block: B:70:? A[RETURN, SYNTHETIC] */
    private static final void AnswerIconButton(final ImageVector imageVector, final String str, final Function0<Unit> function0, Modifier modifier, boolean z, Composer composer, final int i, final int i2) {
        int i3;
        final Modifier modifier2;
        int i4;
        boolean z2;
        int i5;
        boolean z3;
        final boolean z4;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        final Modifier modifier3;
        final boolean z5;
        Composer composerStartRestartGroup = composer.startRestartGroup(-835688955);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(AnswerIconButton)N(imageVector,contentDescription,onClick,modifier,isEnabled)130@5392L6,130@5411L337,130@5331L417:BoxAiAnswerActions.kt#bwxcym");
        if ((i & 6) == 0) {
            i3 = (composerStartRestartGroup.changed(imageVector) ? 4 : 2) | i;
        } else {
            i3 = i;
        }
        if ((i & 48) == 0) {
            i3 |= composerStartRestartGroup.changed(str) ? 32 : 16;
        }
        if ((i & 384) == 0) {
            i3 |= composerStartRestartGroup.changedInstance(function0) ? 256 : 128;
        }
        int i6 = i2 & 8;
        if (i6 == 0) {
            if ((i & 3072) == 0) {
                modifier2 = modifier;
                i3 |= composerStartRestartGroup.changed(modifier2) ? 2048 : 1024;
            }
            i4 = i2 & 16;
            if (i4 != 0) {
                if ((i & 24576) == 0) {
                    z2 = z;
                    if (composerStartRestartGroup.changed(z2)) {
                        i5 = 16384;
                    } else {
                        i5 = 8192;
                    }
                    i3 |= i5;
                }
                if ((i3 & 9363) != 9362) {
                    z3 = true;
                } else {
                    z3 = false;
                }
                if (composerStartRestartGroup.shouldExecute(z3, i3 & 1)) {
                    composerStartRestartGroup.skipToGroupEnd();
                    z4 = z2;
                } else {
                    if (i6 != 0) {
                        modifier3 = Modifier.INSTANCE;
                    } else {
                        modifier3 = modifier2;
                    }
                    if (i4 != 0) {
                        z5 = true;
                    } else {
                        z5 = z2;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-835688955, i3, -1, "com.box.android.boxai.ui.AnswerIconButton (BoxAiAnswerActions.kt:129)");
                    }
                    CompositionLocalKt.CompositionLocalProvider(ContentColorKt.getLocalContentColor().provides(Color.m6804boximpl(BoxTheme.INSTANCE.getColors(composerStartRestartGroup, BoxTheme.$stable).m11500getAppPrimary0d7_KjU())), ComposableLambdaKt.rememberComposableLambda(1686555333, true, new Function2() { // from class: com.box.android.boxai.ui.BoxAiAnswerActionsKt$$ExternalSyntheticLambda13
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return BoxAiAnswerActionsKt.AnswerIconButton$lambda$0(modifier3, function0, z5, imageVector, str, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    }, composerStartRestartGroup, 54), composerStartRestartGroup, ProvidedValue.$stable | 48);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    modifier2 = modifier3;
                    z4 = z5;
                }
                scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.box.android.boxai.ui.BoxAiAnswerActionsKt$$ExternalSyntheticLambda1
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return BoxAiAnswerActionsKt.AnswerIconButton$lambda$1(imageVector, str, function0, modifier2, z4, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    });
                }
            }
            i3 |= 24576;
            z2 = z;
            if ((i3 & 9363) != 9362) {
                z3 = true;
            } else {
                z3 = false;
            }
            if (composerStartRestartGroup.shouldExecute(z3, i3 & 1)) {
                composerStartRestartGroup.skipToGroupEnd();
                z4 = z2;
            } else {
                if (i6 != 0) {
                    modifier3 = Modifier.INSTANCE;
                } else {
                    modifier3 = modifier2;
                }
                if (i4 != 0) {
                    z5 = true;
                } else {
                    z5 = z2;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-835688955, i3, -1, "com.box.android.boxai.ui.AnswerIconButton (BoxAiAnswerActions.kt:129)");
                }
                CompositionLocalKt.CompositionLocalProvider(ContentColorKt.getLocalContentColor().provides(Color.m6804boximpl(BoxTheme.INSTANCE.getColors(composerStartRestartGroup, BoxTheme.$stable).m11500getAppPrimary0d7_KjU())), ComposableLambdaKt.rememberComposableLambda(1686555333, true, new Function2() { // from class: com.box.android.boxai.ui.BoxAiAnswerActionsKt$$ExternalSyntheticLambda13
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return BoxAiAnswerActionsKt.AnswerIconButton$lambda$0(modifier3, function0, z5, imageVector, str, (Composer) obj, ((Integer) obj2).intValue());
                    }
                }, composerStartRestartGroup, 54), composerStartRestartGroup, ProvidedValue.$stable | 48);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                modifier2 = modifier3;
                z4 = z5;
            }
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.box.android.boxai.ui.BoxAiAnswerActionsKt$$ExternalSyntheticLambda1
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return BoxAiAnswerActionsKt.AnswerIconButton$lambda$1(imageVector, str, function0, modifier2, z4, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                    }
                });
            }
        }
        i3 |= 3072;
        modifier2 = modifier;
        i4 = i2 & 16;
        if (i4 != 0) {
            if ((i & 24576) == 0) {
                z2 = z;
                if (composerStartRestartGroup.changed(z2)) {
                    i5 = 16384;
                } else {
                    i5 = 8192;
                }
                i3 |= i5;
            }
            if ((i3 & 9363) != 9362) {
                z3 = true;
            } else {
                z3 = false;
            }
            if (composerStartRestartGroup.shouldExecute(z3, i3 & 1)) {
                composerStartRestartGroup.skipToGroupEnd();
                z4 = z2;
            } else {
                if (i6 != 0) {
                    modifier3 = Modifier.INSTANCE;
                } else {
                    modifier3 = modifier2;
                }
                if (i4 != 0) {
                    z5 = true;
                } else {
                    z5 = z2;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-835688955, i3, -1, "com.box.android.boxai.ui.AnswerIconButton (BoxAiAnswerActions.kt:129)");
                }
                CompositionLocalKt.CompositionLocalProvider(ContentColorKt.getLocalContentColor().provides(Color.m6804boximpl(BoxTheme.INSTANCE.getColors(composerStartRestartGroup, BoxTheme.$stable).m11500getAppPrimary0d7_KjU())), ComposableLambdaKt.rememberComposableLambda(1686555333, true, new Function2() { // from class: com.box.android.boxai.ui.BoxAiAnswerActionsKt$$ExternalSyntheticLambda13
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return BoxAiAnswerActionsKt.AnswerIconButton$lambda$0(modifier3, function0, z5, imageVector, str, (Composer) obj, ((Integer) obj2).intValue());
                    }
                }, composerStartRestartGroup, 54), composerStartRestartGroup, ProvidedValue.$stable | 48);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                modifier2 = modifier3;
                z4 = z5;
            }
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.box.android.boxai.ui.BoxAiAnswerActionsKt$$ExternalSyntheticLambda1
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return BoxAiAnswerActionsKt.AnswerIconButton$lambda$1(imageVector, str, function0, modifier2, z4, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                    }
                });
            }
        }
        i3 |= 24576;
        z2 = z;
        if ((i3 & 9363) != 9362) {
            z3 = true;
        } else {
            z3 = false;
        }
        if (composerStartRestartGroup.shouldExecute(z3, i3 & 1)) {
            composerStartRestartGroup.skipToGroupEnd();
            z4 = z2;
        } else {
            if (i6 != 0) {
                modifier3 = Modifier.INSTANCE;
            } else {
                modifier3 = modifier2;
            }
            if (i4 != 0) {
                z5 = true;
            } else {
                z5 = z2;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-835688955, i3, -1, "com.box.android.boxai.ui.AnswerIconButton (BoxAiAnswerActions.kt:129)");
            }
            CompositionLocalKt.CompositionLocalProvider(ContentColorKt.getLocalContentColor().provides(Color.m6804boximpl(BoxTheme.INSTANCE.getColors(composerStartRestartGroup, BoxTheme.$stable).m11500getAppPrimary0d7_KjU())), ComposableLambdaKt.rememberComposableLambda(1686555333, true, new Function2() { // from class: com.box.android.boxai.ui.BoxAiAnswerActionsKt$$ExternalSyntheticLambda13
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return BoxAiAnswerActionsKt.AnswerIconButton$lambda$0(modifier3, function0, z5, imageVector, str, (Composer) obj, ((Integer) obj2).intValue());
                }
            }, composerStartRestartGroup, 54), composerStartRestartGroup, ProvidedValue.$stable | 48);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            modifier2 = modifier3;
            z4 = z5;
        }
        scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.box.android.boxai.ui.BoxAiAnswerActionsKt$$ExternalSyntheticLambda1
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return BoxAiAnswerActionsKt.AnswerIconButton$lambda$1(imageVector, str, function0, modifier2, z4, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit AnswerIconButton$lambda$0$0(ImageVector imageVector, String str, Composer composer, int i) {
        ComposerKt.sourceInformation(composer, "C136@5565L167:BoxAiAnswerActions.kt#bwxcym");
        if (!composer.shouldExecute((i & 3) != 2, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1946129123, i, -1, "com.box.android.boxai.ui.AnswerIconButton.<anonymous>.<anonymous> (BoxAiAnswerActions.kt:136)");
            }
            IconKt.m3576Iconww6aTOc(imageVector, str, SizeKt.m1266size3ABfNKs(Modifier.INSTANCE, Dp.m9687constructorimpl(16)), 0L, composer, 384, 8);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: renamed from: AnswerDropdownMenu-SaJeTKs, reason: not valid java name */
    public static final void m12070AnswerDropdownMenuSaJeTKs(final boolean z, final Function0<Unit> onDismiss, final long j, final boolean z2, final BoxAiQaReducer.AnswerFeedback answerFeedback, final Function0<Unit> onCopyToClipboardClicked, final Function1<? super BoxAiQaReducer.AnswerFeedback, Unit> onFeedbackClicked, Composer composer, final int i) {
        int i2;
        ImageVector thumbUp;
        ImageVector thumbDown;
        Intrinsics.checkNotNullParameter(onDismiss, "onDismiss");
        Intrinsics.checkNotNullParameter(onCopyToClipboardClicked, "onCopyToClipboardClicked");
        Intrinsics.checkNotNullParameter(onFeedbackClicked, "onFeedbackClicked");
        Composer composerStartRestartGroup = composer.startRestartGroup(1970564031);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(AnswerDropdownMenu)N(isExpanded,onDismiss,offset:c#ui.unit.DpOffset,showFeedbackItems,feedback,onCopyToClipboardClicked,onFeedbackClicked)155@6053L1933:BoxAiAnswerActions.kt#bwxcym");
        if ((i & 6) == 0) {
            i2 = (composerStartRestartGroup.changed(z) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 48) == 0) {
            i2 |= composerStartRestartGroup.changedInstance(onDismiss) ? 32 : 16;
        }
        if ((i & 384) == 0) {
            i2 |= composerStartRestartGroup.changed(j) ? 256 : 128;
        }
        if ((i & 3072) == 0) {
            i2 |= composerStartRestartGroup.changed(z2) ? 2048 : 1024;
        }
        if ((i & 24576) == 0) {
            i2 |= composerStartRestartGroup.changed(answerFeedback == null ? -1 : answerFeedback.ordinal()) ? 16384 : 8192;
        }
        if ((196608 & i) == 0) {
            i2 |= composerStartRestartGroup.changedInstance(onCopyToClipboardClicked) ? 131072 : 65536;
        }
        if ((1572864 & i) == 0) {
            i2 |= composerStartRestartGroup.changedInstance(onFeedbackClicked) ? 1048576 : 524288;
        }
        if (!composerStartRestartGroup.shouldExecute((599187 & i2) != 599186, i2 & 1)) {
            composerStartRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1970564031, i2, -1, "com.box.android.boxai.ui.AnswerDropdownMenu (BoxAiAnswerActions.kt:154)");
            }
            Modifier modifierTestTag = TestTagKt.testTag(Modifier.INSTANCE, "BoxAi:QA:AnswerContextMenu");
            composerStartRestartGroup.startReplaceGroup(-368526742);
            ComposerKt.sourceInformation(composerStartRestartGroup, "*164@6397L110");
            List listCreateListBuilder = CollectionsKt.createListBuilder();
            int i3 = R.string.box_ai_dropdown_copy_text;
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 252916731, "CC(remember):BoxAiAnswerActions.kt#9igjgp");
            int i4 = i2 & 112;
            boolean z3 = (i4 == 32) | ((i2 & 458752) == 131072);
            Object objRememberedValue = composerStartRestartGroup.rememberedValue();
            if (z3 || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                objRememberedValue = new Function0() { // from class: com.box.android.boxai.ui.BoxAiAnswerActionsKt$$ExternalSyntheticLambda0
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return BoxAiAnswerActionsKt.AnswerDropdownMenu_SaJeTKs$lambda$0$0$0(onDismiss, onCopyToClipboardClicked);
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
            }
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            listCreateListBuilder.add(new PopupMenuItem(i3, (Function0) objRememberedValue, ContentCopyKt.getContentCopy(Icons.Filled.INSTANCE), (ImageVector) null, (PaddingValues) null, false, 56, (DefaultConstructorMarker) null));
            if (z2) {
                composerStartRestartGroup.startReplaceGroup(-749236092);
                ComposerKt.sourceInformation(composerStartRestartGroup, "175@6811L153,189@7466L153");
                int i5 = R.string.box_ai_dropdown_positive_feedback;
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 252930022, "CC(remember):BoxAiAnswerActions.kt#9igjgp");
                int i6 = 3670016 & i2;
                boolean z4 = (i6 == 1048576) | (i4 == 32);
                Object objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                if (z4 || objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue2 = new Function0() { // from class: com.box.android.boxai.ui.BoxAiAnswerActionsKt$$ExternalSyntheticLambda5
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            return BoxAiAnswerActionsKt.AnswerDropdownMenu_SaJeTKs$lambda$0$1$0(onDismiss, onFeedbackClicked);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                }
                Function0 function0 = (Function0) objRememberedValue2;
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                if ((answerFeedback == null ? -1 : WhenMappings.$EnumSwitchMapping$0[answerFeedback.ordinal()]) == 1) {
                    thumbUp = ThumbUpKt.getThumbUp(Icons.Filled.INSTANCE);
                } else {
                    thumbUp = androidx.compose.material.icons.outlined.ThumbUpKt.getThumbUp(Icons.Outlined.INSTANCE);
                }
                listCreateListBuilder.add(new PopupMenuItem(i5, function0, thumbUp, (ImageVector) null, (PaddingValues) null, answerFeedback == null, 24, (DefaultConstructorMarker) null));
                int i7 = R.string.box_ai_dropdown_negative_feedback;
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 252950982, "CC(remember):BoxAiAnswerActions.kt#9igjgp");
                boolean z5 = (i4 == 32) | (i6 == 1048576);
                Object objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                if (z5 || objRememberedValue3 == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue3 = new Function0() { // from class: com.box.android.boxai.ui.BoxAiAnswerActionsKt$$ExternalSyntheticLambda6
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            return BoxAiAnswerActionsKt.AnswerDropdownMenu_SaJeTKs$lambda$0$2$0(onDismiss, onFeedbackClicked);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                }
                Function0 function1 = (Function0) objRememberedValue3;
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                if ((answerFeedback == null ? -1 : WhenMappings.$EnumSwitchMapping$0[answerFeedback.ordinal()]) == 2) {
                    thumbDown = ThumbDownKt.getThumbDown(Icons.Filled.INSTANCE);
                } else {
                    thumbDown = androidx.compose.material.icons.outlined.ThumbDownKt.getThumbDown(Icons.Outlined.INSTANCE);
                }
                listCreateListBuilder.add(new PopupMenuItem(i7, function1, thumbDown, (ImageVector) null, (PaddingValues) null, answerFeedback == null, 24, (DefaultConstructorMarker) null));
            } else {
                composerStartRestartGroup.startReplaceGroup(-755866155);
            }
            composerStartRestartGroup.endReplaceGroup();
            List listBuild = CollectionsKt.build(listCreateListBuilder);
            composerStartRestartGroup.endReplaceGroup();
            BoxPopupMenuKt.m11733BoxPopupMenuUTokNlU(z, onDismiss, listBuild, modifierTestTag, null, j, composerStartRestartGroup, (i2 & 14) | 3072 | i4 | ((i2 << 9) & 458752), 16);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.box.android.boxai.ui.BoxAiAnswerActionsKt$$ExternalSyntheticLambda7
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return BoxAiAnswerActionsKt.AnswerDropdownMenu_SaJeTKs$lambda$1(z, onDismiss, j, z2, answerFeedback, onCopyToClipboardClicked, onFeedbackClicked, i, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit AnswerDropdownMenu_SaJeTKs$lambda$0$0$0(Function0 function0, Function0 function1) {
        function0.invoke();
        function1.invoke();
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit AnswerDropdownMenu_SaJeTKs$lambda$0$1$0(Function0 function0, Function1 function1) {
        function0.invoke();
        function1.invoke(BoxAiQaReducer.AnswerFeedback.POSITIVE);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit AnswerDropdownMenu_SaJeTKs$lambda$0$2$0(Function0 function0, Function1 function1) {
        function0.invoke();
        function1.invoke(BoxAiQaReducer.AnswerFeedback.NEGATIVE);
        return Unit.INSTANCE;
    }

    private static final void BoxAiAnswerActionsBarPreview(Composer composer, final int i) {
        Composer composerStartRestartGroup = composer.startRestartGroup(-894505713);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(BoxAiAnswerActionsBarPreview)211@8149L411:BoxAiAnswerActions.kt#bwxcym");
        if (!composerStartRestartGroup.shouldExecute(i != 0, i & 1)) {
            composerStartRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-894505713, i, -1, "com.box.android.boxai.ui.BoxAiAnswerActionsBarPreview (BoxAiAnswerActions.kt:210)");
            }
            BoxThemeKt.BoxTheme(ComposableSingletons$BoxAiAnswerActionsKt.INSTANCE.m12090getLambda$1043836572$boxai_generalProdRelease(), composerStartRestartGroup, 6);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.box.android.boxai.ui.BoxAiAnswerActionsKt$$ExternalSyntheticLambda12
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return BoxAiAnswerActionsKt.BoxAiAnswerActionsBarPreview$lambda$0(i, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit AnswerIconButton$lambda$0(Modifier modifier, Function0 function0, boolean z, final ImageVector imageVector, final String str, Composer composer, int i) {
        ComposerKt.sourceInformation(composer, "C135@5551L191,131@5421L321:BoxAiAnswerActions.kt#bwxcym");
        if (!composer.shouldExecute((i & 3) != 2, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1686555333, i, -1, "com.box.android.boxai.ui.AnswerIconButton.<anonymous> (BoxAiAnswerActions.kt:131)");
            }
            IconButtonKt.IconButton((Function0<Unit>) function0, SizeKt.m1266size3ABfNKs(modifier, Dp.m9687constructorimpl(32)), z, (IconButtonColors) null, (MutableInteractionSource) null, (Shape) null, ComposableLambdaKt.rememberComposableLambda(1946129123, true, new Function2() { // from class: com.box.android.boxai.ui.BoxAiAnswerActionsKt$$ExternalSyntheticLambda2
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return BoxAiAnswerActionsKt.AnswerIconButton$lambda$0$0(imageVector, str, (Composer) obj, ((Integer) obj2).intValue());
                }
            }, composer, 54), composer, 1572864, 56);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }
}
