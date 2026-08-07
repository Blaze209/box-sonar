package com.box.android.boxai.ui;

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
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.res.StringResources_androidKt;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.TextUnitKt;
import com.box.android.base.compose.BoxTheme;
import com.box.android.base.compose.BoxThemeKt;
import com.box.android.boxai.R;
import com.box.android.boxai.qa.BoxAiQaReducer;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: BoxAiDialogueHeader.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u001a#\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00010\u0005H\u0007¢\u0006\u0002\u0010\u0006\u001a \u0010\u0000\u001a\u00020\u00012\u0011\u0010\u0007\u001a\r\u0012\u0004\u0012\u00020\u00010\u0005¢\u0006\u0002\b\bH\u0003¢\u0006\u0002\u0010\t\u001a\r\u0010\n\u001a\u00020\u0001H\u0003¢\u0006\u0002\u0010\u000b\u001a\r\u0010\f\u001a\u00020\u0001H\u0003¢\u0006\u0002\u0010\u000b¨\u0006\r"}, d2 = {"BoxAiDialogueHeader", "", "state", "Lcom/box/android/boxai/qa/BoxAiQaReducer$State;", "onFileCountClicked", "Lkotlin/Function0;", "(Lcom/box/android/boxai/qa/BoxAiQaReducer$State;Lkotlin/jvm/functions/Function0;Landroidx/compose/runtime/Composer;I)V", "fileIndicatorContent", "Landroidx/compose/runtime/Composable;", "(Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;I)V", "BoxAiDialogueHeaderSingleFilePreview", "(Landroidx/compose/runtime/Composer;I)V", "BoxAiDialogueHeaderMultipleFilesPreview", "boxai_generalProdRelease"}, k = 2, mv = {2, 2, 0}, xi = 48)
public final class BoxAiDialogueHeaderKt {
    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit BoxAiDialogueHeader$lambda$1(BoxAiQaReducer.State state, Function0 function0, int i, Composer composer, int i2) {
        BoxAiDialogueHeader(state, function0, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit BoxAiDialogueHeader$lambda$3(Function2 function2, int i, Composer composer, int i2) {
        BoxAiDialogueHeader(function2, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit BoxAiDialogueHeaderMultipleFilesPreview$lambda$0(int i, Composer composer, int i2) {
        BoxAiDialogueHeaderMultipleFilesPreview(composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit BoxAiDialogueHeaderSingleFilePreview$lambda$0(int i, Composer composer, int i2) {
        BoxAiDialogueHeaderSingleFilePreview(composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    public static final void BoxAiDialogueHeader(final BoxAiQaReducer.State state, final Function0<Unit> onFileCountClicked, Composer composer, final int i) {
        int i2;
        Intrinsics.checkNotNullParameter(state, "state");
        Intrinsics.checkNotNullParameter(onFileCountClicked, "onFileCountClicked");
        Composer composerStartRestartGroup = composer.startRestartGroup(-2043762495);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(BoxAiDialogueHeader)N(state,onFileCountClicked):BoxAiDialogueHeader.kt#bwxcym");
        if ((i & 6) == 0) {
            i2 = (composerStartRestartGroup.changedInstance(state) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 48) == 0) {
            i2 |= composerStartRestartGroup.changedInstance(onFileCountClicked) ? 32 : 16;
        }
        if (!composerStartRestartGroup.shouldExecute((i2 & 19) != 18, i2 & 1)) {
            composerStartRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-2043762495, i2, -1, "com.box.android.boxai.ui.BoxAiDialogueHeader (BoxAiDialogueHeader.kt:25)");
            }
            if (state.getTotalFileCount() == 1 && !state.getHasUnsupportedFiles()) {
                composerStartRestartGroup.startReplaceGroup(-271947741);
                ComposerKt.sourceInformation(composerStartRestartGroup, "27@1172L46");
                BoxAiDialogueHeader(ComposableSingletons$BoxAiDialogueHeaderKt.INSTANCE.m12093getLambda$1974561623$boxai_generalProdRelease(), composerStartRestartGroup, 6);
                composerStartRestartGroup.endReplaceGroup();
            } else {
                composerStartRestartGroup.startReplaceGroup(-271872318);
                ComposerKt.sourceInformation(composerStartRestartGroup, "30@1296L237,29@1240L303");
                BoxAiDialogueHeader(ComposableLambdaKt.rememberComposableLambda(1526962738, true, new Function2() { // from class: com.box.android.boxai.ui.BoxAiDialogueHeaderKt$$ExternalSyntheticLambda0
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return BoxAiDialogueHeaderKt.BoxAiDialogueHeader$lambda$0(state, onFileCountClicked, (Composer) obj, ((Integer) obj2).intValue());
                    }
                }, composerStartRestartGroup, 54), composerStartRestartGroup, 6);
                composerStartRestartGroup.endReplaceGroup();
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.box.android.boxai.ui.BoxAiDialogueHeaderKt$$ExternalSyntheticLambda1
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return BoxAiDialogueHeaderKt.BoxAiDialogueHeader$lambda$1(state, onFileCountClicked, i, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit BoxAiDialogueHeader$lambda$0(BoxAiQaReducer.State state, Function0 function0, Composer composer, int i) {
        ComposerKt.sourceInformation(composer, "C31@1314L205:BoxAiDialogueHeader.kt#bwxcym");
        if (!composer.shouldExecute((i & 3) != 2, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1526962738, i, -1, "com.box.android.boxai.ui.BoxAiDialogueHeader.<anonymous> (BoxAiDialogueHeader.kt:31)");
            }
            BoxAiFileCountKt.BoxAiFileCount(state.getTotalFileCount(), state.getHasUnsupportedFiles(), function0, null, composer, 0, 8);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    private static final void BoxAiDialogueHeader(final Function2<? super Composer, ? super Integer, Unit> function2, Composer composer, final int i) {
        int i2;
        Composer composer2;
        Composer composerStartRestartGroup = composer.startRestartGroup(1831205935);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(BoxAiDialogueHeader)N(fileIndicatorContent)43@1649L829:BoxAiDialogueHeader.kt#bwxcym");
        if ((i & 6) == 0) {
            i2 = (composerStartRestartGroup.changedInstance(function2) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if (!composerStartRestartGroup.shouldExecute((i2 & 3) != 2, i2 & 1)) {
            composer2 = composerStartRestartGroup;
            composer2.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1831205935, i2, -1, "com.box.android.boxai.ui.BoxAiDialogueHeader (BoxAiDialogueHeader.kt:42)");
            }
            float f = 8;
            Modifier modifierM1222paddingqDBjuR0$default = PaddingKt.m1222paddingqDBjuR0$default(Modifier.INSTANCE, Dp.m9687constructorimpl(16), 0.0f, Dp.m9687constructorimpl(24), Dp.m9687constructorimpl(f), 2, null);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1341605231, "CC(Column)N(modifier,verticalArrangement,horizontalAlignment,content)87@4443L61,88@4509L134:Column.kt#2w3rfo");
            MeasurePolicy measurePolicyColumnMeasurePolicy = ColumnKt.columnMeasurePolicy(Arrangement.INSTANCE.getTop(), Alignment.INSTANCE.getStart(), composerStartRestartGroup, 0);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
            int iHashCode = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
            CompositionLocalMap currentCompositionLocalMap = composerStartRestartGroup.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierM1222paddingqDBjuR0$default);
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
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -2019358752, "C46@1818L49,48@1951L6,44@1738L272,51@2019L40,52@2068L22,53@2099L40,56@2228L57,58@2371L6,54@2148L324:BoxAiDialogueHeader.kt#bwxcym");
            composer2 = composerStartRestartGroup;
            TextKt.m4494TextNvy7gAk(StringResources_androidKt.stringResource(R.string.box_ai_welcome_to_box_ai, composerStartRestartGroup, 0), PaddingKt.m1222paddingqDBjuR0$default(Modifier.INSTANCE, Dp.m9687constructorimpl(f), 0.0f, 0.0f, 0.0f, 14, null), BoxTheme.INSTANCE.getColors(composerStartRestartGroup, BoxTheme.$stable).m11500getAppPrimary0d7_KjU(), null, 0L, null, null, null, 0L, null, null, TextUnitKt.getSp(22), 0, false, 0, 0, null, BoxTheme.INSTANCE.getTypography().getBoxMedium17(), composer2, 48, 48, 129016);
            float f2 = 4;
            SpacerKt.Spacer(SizeKt.m1252height3ABfNKs(Modifier.INSTANCE, Dp.m9687constructorimpl(f2)), composer2, 6);
            function2.invoke(composer2, Integer.valueOf(i2 & 14));
            SpacerKt.Spacer(SizeKt.m1252height3ABfNKs(Modifier.INSTANCE, Dp.m9687constructorimpl(f2)), composer2, 6);
            TextKt.m4494TextNvy7gAk(StringResources_androidKt.stringResource(R.string.box_ai_welcome_message_secondary, composer2, 0), PaddingKt.m1222paddingqDBjuR0$default(Modifier.INSTANCE, Dp.m9687constructorimpl(f), 0.0f, 0.0f, 0.0f, 14, null), BoxAITheme.INSTANCE.getColors(composer2, 6).m12055getContentSecondary0d7_KjU(), null, 0L, null, null, null, TextUnitKt.getSp(0.1d), null, null, TextUnitKt.getSp(20), 0, false, 0, 0, null, BoxTheme.INSTANCE.getTypography().getBoxMedium14(), composer2, 100663344, 48, 128760);
            ComposerKt.sourceInformationMarkerEnd(composer2);
            ComposerKt.sourceInformationMarkerEnd(composer2);
            composer2.endNode();
            ComposerKt.sourceInformationMarkerEnd(composer2);
            ComposerKt.sourceInformationMarkerEnd(composer2);
            ComposerKt.sourceInformationMarkerEnd(composer2);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.box.android.boxai.ui.BoxAiDialogueHeaderKt$$ExternalSyntheticLambda2
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return BoxAiDialogueHeaderKt.BoxAiDialogueHeader$lambda$3(function2, i, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    private static final void BoxAiDialogueHeaderSingleFilePreview(Composer composer, final int i) {
        Composer composerStartRestartGroup = composer.startRestartGroup(-2023755024);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(BoxAiDialogueHeaderSingleFilePreview)71@2649L368:BoxAiDialogueHeader.kt#bwxcym");
        if (!composerStartRestartGroup.shouldExecute(i != 0, i & 1)) {
            composerStartRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-2023755024, i, -1, "com.box.android.boxai.ui.BoxAiDialogueHeaderSingleFilePreview (BoxAiDialogueHeader.kt:70)");
            }
            BoxThemeKt.BoxTheme(ComposableSingletons$BoxAiDialogueHeaderKt.INSTANCE.getLambda$1224318523$boxai_generalProdRelease(), composerStartRestartGroup, 6);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.box.android.boxai.ui.BoxAiDialogueHeaderKt$$ExternalSyntheticLambda3
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return BoxAiDialogueHeaderKt.BoxAiDialogueHeaderSingleFilePreview$lambda$0(i, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    private static final void BoxAiDialogueHeaderMultipleFilesPreview(Composer composer, final int i) {
        Composer composerStartRestartGroup = composer.startRestartGroup(1921602047);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(BoxAiDialogueHeaderMultipleFilesPreview)88@3138L749:BoxAiDialogueHeader.kt#bwxcym");
        if (!composerStartRestartGroup.shouldExecute(i != 0, i & 1)) {
            composerStartRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1921602047, i, -1, "com.box.android.boxai.ui.BoxAiDialogueHeaderMultipleFilesPreview (BoxAiDialogueHeader.kt:87)");
            }
            BoxThemeKt.BoxTheme(ComposableSingletons$BoxAiDialogueHeaderKt.INSTANCE.m12094getLambda$332538156$boxai_generalProdRelease(), composerStartRestartGroup, 6);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.box.android.boxai.ui.BoxAiDialogueHeaderKt$$ExternalSyntheticLambda4
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return BoxAiDialogueHeaderKt.BoxAiDialogueHeaderMultipleFilesPreview$lambda$0(i, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }
}
