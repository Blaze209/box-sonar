package com.box.android.fileactivity.presentation;

import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.ColumnKt;
import androidx.compose.foundation.layout.ColumnScopeInstance;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.layout.WindowInsetsPadding_androidKt;
import androidx.compose.material3.TextKt;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.State;
import androidx.compose.runtime.Updater;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.res.StringResources_androidKt;
import androidx.compose.ui.text.style.TextAlign;
import androidx.compose.ui.unit.Dp;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.compose.FlowExtKt;
import com.box.android.base.compose.BoxTheme;
import com.box.android.base.compose.DefaultAvatarControllerWrapper;
import com.box.android.base.compose.divider.BoxHorizontalDividerKt;
import com.box.android.base.presentation.components.commentbar.CommentBarKt;
import com.box.android.base.presentation.components.commentbar.CommentWithMentionsReducer;
import com.box.android.cpl.Store;
import com.box.android.fileactivity.model.UserUIModel;
import external.sdk.pendo.io.mozilla.javascript.Token;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: FileActivitiesScreenBottomBar.kt */
/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000,\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a1\u0010\u0000\u001a\u00020\u00012\u0012\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u00032\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0007¢\u0006\u0002\u0010\n\u001a\u0015\u0010\u000b\u001a\u00020\u00012\u0006\u0010\f\u001a\u00020\rH\u0007¢\u0006\u0002\u0010\u000e¨\u0006\u000f²\u0006\n\u0010\u0010\u001a\u00020\u0004X\u008a\u0084\u0002"}, d2 = {"BottomBar", "", "store", "Lcom/box/android/cpl/Store;", "Lcom/box/android/base/presentation/components/commentbar/CommentWithMentionsReducer$State;", "Lcom/box/android/base/presentation/components/commentbar/CommentWithMentionsReducer$Action;", "userUIModel", "Lcom/box/android/fileactivity/model/UserUIModel;", "avatarControllerWrapper", "Lcom/box/android/base/compose/DefaultAvatarControllerWrapper;", "(Lcom/box/android/cpl/Store;Lcom/box/android/fileactivity/model/UserUIModel;Lcom/box/android/base/compose/DefaultAvatarControllerWrapper;Landroidx/compose/runtime/Composer;I)V", "ResolutionBottomBar", "errorBoxState", "Lcom/box/android/base/presentation/components/commentbar/CommentWithMentionsReducer$InputBoxState$ErrorMessage;", "(Lcom/box/android/base/presentation/components/commentbar/CommentWithMentionsReducer$InputBoxState$ErrorMessage;Landroidx/compose/runtime/Composer;I)V", "file-activity_generalProdRelease", "state"}, k = 2, mv = {2, 2, 0}, xi = 48)
public final class FileActivitiesScreenBottomBarKt {
    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit BottomBar$lambda$1(Store store, UserUIModel userUIModel, DefaultAvatarControllerWrapper defaultAvatarControllerWrapper, int i, Composer composer, int i2) {
        BottomBar(store, userUIModel, defaultAvatarControllerWrapper, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ResolutionBottomBar$lambda$1(CommentWithMentionsReducer.InputBoxState.ErrorMessage errorMessage, int i, Composer composer, int i2) {
        ResolutionBottomBar(errorMessage, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    public static final void BottomBar(Store<CommentWithMentionsReducer.State, CommentWithMentionsReducer.Action> store, final UserUIModel userUIModel, DefaultAvatarControllerWrapper avatarControllerWrapper, Composer composer, final int i) {
        int i2;
        final Store<CommentWithMentionsReducer.State, CommentWithMentionsReducer.Action> store2;
        final DefaultAvatarControllerWrapper defaultAvatarControllerWrapper;
        Intrinsics.checkNotNullParameter(store, "store");
        Intrinsics.checkNotNullParameter(userUIModel, "userUIModel");
        Intrinsics.checkNotNullParameter(avatarControllerWrapper, "avatarControllerWrapper");
        Composer composerStartRestartGroup = composer.startRestartGroup(-1206492647);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(BottomBar)N(store,userUIModel,avatarControllerWrapper)30@1350L29:FileActivitiesScreenBottomBar.kt#dcyg9a");
        if ((i & 6) == 0) {
            i2 = (composerStartRestartGroup.changed(store) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 48) == 0) {
            i2 |= composerStartRestartGroup.changedInstance(userUIModel) ? 32 : 16;
        }
        if ((i & 384) == 0) {
            i2 |= composerStartRestartGroup.changed(avatarControllerWrapper) ? 256 : 128;
        }
        if (!composerStartRestartGroup.shouldExecute((i2 & Token.DOTQUERY) != 146, i2 & 1)) {
            store2 = store;
            defaultAvatarControllerWrapper = avatarControllerWrapper;
            composerStartRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1206492647, i2, -1, "com.box.android.fileactivity.presentation.BottomBar (FileActivitiesScreenBottomBar.kt:29)");
            }
            CommentWithMentionsReducer.InputBoxState inputBoxState = BottomBar$lambda$0(FlowExtKt.collectAsStateWithLifecycle(store.getState(), (LifecycleOwner) null, (Lifecycle.State) null, (CoroutineContext) null, composerStartRestartGroup, 0, 7)).getInputBoxState();
            if (inputBoxState instanceof CommentWithMentionsReducer.InputBoxState.Shown) {
                composerStartRestartGroup.startReplaceGroup(1959227929);
                ComposerKt.sourceInformation(composerStartRestartGroup, "34@1509L216");
                store2 = store;
                defaultAvatarControllerWrapper = avatarControllerWrapper;
                CommentBarKt.CommentBar(store2, userUIModel.getUserId(), userUIModel.getUserName(), defaultAvatarControllerWrapper, null, null, composerStartRestartGroup, (i2 & 14) | ((i2 << 3) & 7168), 48);
                composerStartRestartGroup = composerStartRestartGroup;
                composerStartRestartGroup.endReplaceGroup();
            } else {
                store2 = store;
                defaultAvatarControllerWrapper = avatarControllerWrapper;
                if (inputBoxState instanceof CommentWithMentionsReducer.InputBoxState.ErrorMessage) {
                    composerStartRestartGroup.startReplaceGroup(1959530303);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "43@1819L50");
                    ResolutionBottomBar((CommentWithMentionsReducer.InputBoxState.ErrorMessage) inputBoxState, composerStartRestartGroup, CommentWithMentionsReducer.InputBoxState.$stable);
                    composerStartRestartGroup.endReplaceGroup();
                } else {
                    composerStartRestartGroup.startReplaceGroup(1959621319);
                    composerStartRestartGroup.endReplaceGroup();
                }
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.box.android.fileactivity.presentation.FileActivitiesScreenBottomBarKt$$ExternalSyntheticLambda1
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return FileActivitiesScreenBottomBarKt.BottomBar$lambda$1(store2, userUIModel, defaultAvatarControllerWrapper, i, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    public static final void ResolutionBottomBar(final CommentWithMentionsReducer.InputBoxState.ErrorMessage errorBoxState, Composer composer, final int i) {
        int i2;
        Intrinsics.checkNotNullParameter(errorBoxState, "errorBoxState");
        Composer composerStartRestartGroup = composer.startRestartGroup(99488152);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(ResolutionBottomBar)N(errorBoxState)54@2085L582:FileActivitiesScreenBottomBar.kt#dcyg9a");
        if ((i & 6) == 0) {
            i2 = ((i & 8) == 0 ? composerStartRestartGroup.changed(errorBoxState) : composerStartRestartGroup.changedInstance(errorBoxState) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if (!composerStartRestartGroup.shouldExecute((i2 & 3) != 2, i2 & 1)) {
            composerStartRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(99488152, i2, -1, "com.box.android.fileactivity.presentation.ResolutionBottomBar (FileActivitiesScreenBottomBar.kt:53)");
            }
            Modifier modifierM1254heightInVpY3zN4$default = SizeKt.m1254heightInVpY3zN4$default(WindowInsetsPadding_androidKt.navigationBarsPadding(Modifier.INSTANCE), BoxTheme.INSTANCE.getSizes().m11609getBottomBarHeightD9Ej5fM(), 0.0f, 2, null);
            Alignment.Horizontal centerHorizontally = Alignment.INSTANCE.getCenterHorizontally();
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1341605231, "CC(Column)N(modifier,verticalArrangement,horizontalAlignment,content)87@4443L61,88@4509L134:Column.kt#2w3rfo");
            MeasurePolicy measurePolicyColumnMeasurePolicy = ColumnKt.columnMeasurePolicy(Arrangement.INSTANCE.getTop(), centerHorizontally, composerStartRestartGroup, 48);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
            int iHashCode = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
            CompositionLocalMap currentCompositionLocalMap = composerStartRestartGroup.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierM1254heightInVpY3zN4$default);
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
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 964237414, "C60@2294L64,62@2392L41,66@2628L6,61@2367L294:FileActivitiesScreenBottomBar.kt#dcyg9a");
            float f = 8;
            BoxHorizontalDividerKt.m11724BoxHorizontalDivider9IZ8Weo(PaddingKt.m1222paddingqDBjuR0$default(Modifier.INSTANCE, 0.0f, 0.0f, 0.0f, Dp.m9687constructorimpl(f), 7, null), 0.0f, 0L, composerStartRestartGroup, 6, 6);
            TextKt.m4494TextNvy7gAk(StringResources_androidKt.stringResource(errorBoxState.getStrRes(), composerStartRestartGroup, 0), PaddingKt.m1222paddingqDBjuR0$default(Modifier.INSTANCE, 0.0f, Dp.m9687constructorimpl(f), 0.0f, Dp.m9687constructorimpl(16), 5, null), BoxTheme.INSTANCE.getColors(composerStartRestartGroup, BoxTheme.$stable).m11513getContentSecondary0d7_KjU(), null, 0L, null, null, null, 0L, null, TextAlign.m9519boximpl(TextAlign.INSTANCE.m9526getCentere0LSkKk()), 0L, 0, false, 0, 0, null, BoxTheme.INSTANCE.getTypography().getBoxNormal14(), composerStartRestartGroup, 48, 0, 130040);
            composerStartRestartGroup = composerStartRestartGroup;
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
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.box.android.fileactivity.presentation.FileActivitiesScreenBottomBarKt$$ExternalSyntheticLambda0
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return FileActivitiesScreenBottomBarKt.ResolutionBottomBar$lambda$1(errorBoxState, i, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    private static final CommentWithMentionsReducer.State BottomBar$lambda$0(State<CommentWithMentionsReducer.State> state) {
        return state.getValue();
    }
}
