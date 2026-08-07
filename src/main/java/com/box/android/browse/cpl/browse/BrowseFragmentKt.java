package com.box.android.browse.cpl.browse;

import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.layout.WindowInsetsPadding_androidKt;
import androidx.compose.material3.SnackbarHostState;
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
import androidx.compose.ui.input.nestedscroll.NestedScrollModifierKt;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.compose.FlowExtKt;
import com.box.android.activities.addcontent.CreateDocumentTaskActivity;
import com.box.android.base.compose.SwipeableSnackbarHostKt;
import com.box.android.base.compose.button.fab.ScrollAwareFabVisibility;
import com.box.android.base.compose.button.fab.ScrollAwareFabVisibilityKt;
import com.box.android.browse.cpl.browse.fab.FilesFabComponentKt;
import com.box.android.browse.cpl.browse.fab.FilesFabReducer;
import com.box.android.cpl.Store;
import com.box.android.domain.models.item.FolderModel;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.reflect.KFunction;

/* JADX INFO: compiled from: BrowseFragment.kt */
/* JADX INFO: loaded from: classes10.dex */
@Metadata(d1 = {"\u00006\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\u001ai\u0010\u0000\u001a\u00020\u00012\u0012\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u00032\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u000726\u0010\t\u001a2\u0012\u0013\u0012\u00110\u000b¢\u0006\f\b\f\u0012\b\b\r\u0012\u0004\b\b(\u000e\u0012\u0013\u0012\u00110\u000f¢\u0006\f\b\f\u0012\b\b\r\u0012\u0004\b\b(\u0010\u0012\u0004\u0012\u00020\u00010\nH\u0007¢\u0006\u0002\u0010\u0011¨\u0006\u0012²\u0006\n\u0010\u0013\u001a\u00020\u0004X\u008a\u0084\u0002"}, d2 = {"BrowseFragmentContent", "", "store", "Lcom/box/android/cpl/Store;", "Lcom/box/android/browse/cpl/browse/BrowseReducer$State;", "Lcom/box/android/browse/cpl/browse/BrowseReducer$Action;", "isRedesignedVersion", "", "shouldUseAiCenter", "onCreateNewDocumentClicked", "Lkotlin/Function2;", "Lcom/box/android/domain/models/item/FolderModel;", "Lkotlin/ParameterName;", "name", "folderModel", "", CreateDocumentTaskActivity.EXTRA_ASSET_NAME, "(Lcom/box/android/cpl/Store;ZZLkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;I)V", "browse_generalProdRelease", "state"}, k = 2, mv = {2, 2, 0}, xi = 48)
public final class BrowseFragmentKt {
    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit BrowseFragmentContent$lambda$1(Store store, boolean z, boolean z2, Function2 function2, int i, Composer composer, int i2) {
        BrowseFragmentContent(store, z, z2, function2, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    public static final void BrowseFragmentContent(final Store<BrowseReducer.State, BrowseReducer.Action> store, final boolean z, final boolean z2, final Function2<? super FolderModel, ? super String, Unit> onCreateNewDocumentClicked, Composer composer, final int i) {
        int i2;
        boolean z3;
        Composer composer2;
        Intrinsics.checkNotNullParameter(store, "store");
        Intrinsics.checkNotNullParameter(onCreateNewDocumentClicked, "onCreateNewDocumentClicked");
        Composer composerStartRestartGroup = composer.startRestartGroup(1384545856);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(BrowseFragmentContent)N(store,isRedesignedVersion,shouldUseAiCenter,onCreateNewDocumentClicked)261@10184L34,263@10224L1427:BrowseFragment.kt#89mwni");
        if ((i & 6) == 0) {
            i2 = (composerStartRestartGroup.changed(store) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 48) == 0) {
            i2 |= composerStartRestartGroup.changed(z) ? 32 : 16;
        }
        if ((i & 384) == 0) {
            z3 = z2;
            i2 |= composerStartRestartGroup.changed(z3) ? 256 : 128;
        } else {
            z3 = z2;
        }
        if ((i & 3072) == 0) {
            i2 |= composerStartRestartGroup.changedInstance(onCreateNewDocumentClicked) ? 2048 : 1024;
        }
        int i3 = i2;
        if (!composerStartRestartGroup.shouldExecute((i3 & 1171) != 1170, i3 & 1)) {
            composer2 = composerStartRestartGroup;
            composer2.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1384545856, i3, -1, "com.box.android.browse.cpl.browse.BrowseFragmentContent (BrowseFragment.kt:260)");
            }
            ScrollAwareFabVisibility scrollAwareFabVisibilityRememberScrollAwareFabVisibility = ScrollAwareFabVisibilityKt.rememberScrollAwareFabVisibility(composerStartRestartGroup, 0);
            Modifier modifierNestedScroll$default = NestedScrollModifierKt.nestedScroll$default(SizeKt.fillMaxSize$default(Modifier.INSTANCE, 0.0f, 1, null), scrollAwareFabVisibilityRememberScrollAwareFabVisibility, null, 2, null);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1042775818, "CC(Box)N(modifier,contentAlignment,propagateMinConstraints,content)71@3424L131:Box.kt#2w3rfo");
            MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), false);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
            int iHashCode = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
            CompositionLocalMap currentCompositionLocalMap = composerStartRestartGroup.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierNestedScroll$default);
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
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 535425533, "C264@10301L156:BrowseFragment.kt#89mwni");
            int i4 = i3 << 6;
            int i5 = (i3 & 14) | (i4 & 7168) | (i4 & 57344);
            boolean z4 = z3;
            composer2 = composerStartRestartGroup;
            BrowseContentKt.BrowseContent(store, null, null, z, z4, composer2, i5, 6);
            if (z) {
                composer2.startReplaceGroup(535608122);
                ComposerKt.sourceInformation(composer2, "270@10530L29,271@10596L32,273@10642L993");
                composer2 = composer2;
                State stateCollectAsStateWithLifecycle = FlowExtKt.collectAsStateWithLifecycle(store.getState(), (LifecycleOwner) null, (Lifecycle.State) null, (CoroutineContext) null, composer2, 0, 7);
                ComposerKt.sourceInformationMarkerStart(composer2, -1368193402, "CC(remember):BrowseFragment.kt#9igjgp");
                Object objRememberedValue = composer2.rememberedValue();
                if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue = new SnackbarHostState();
                    composer2.updateRememberedValue(objRememberedValue);
                }
                SnackbarHostState snackbarHostState = (SnackbarHostState) objRememberedValue;
                ComposerKt.sourceInformationMarkerEnd(composer2);
                Modifier modifierNavigationBarsPadding = WindowInsetsPadding_androidKt.navigationBarsPadding(Modifier.INSTANCE);
                ComposerKt.sourceInformationMarkerStart(composer2, 1042775818, "CC(Box)N(modifier,contentAlignment,propagateMinConstraints,content)71@3424L131:Box.kt#2w3rfo");
                MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy2 = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), false);
                ComposerKt.sourceInformationMarkerStart(composer2, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
                int iHashCode2 = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composer2, 0));
                CompositionLocalMap currentCompositionLocalMap2 = composer2.getCurrentCompositionLocalMap();
                Modifier modifierMaterializeModifier2 = ComposedModifierKt.materializeModifier(composer2, modifierNavigationBarsPadding);
                Function0<ComposeUiNode> constructor2 = ComposeUiNode.INSTANCE.getConstructor();
                ComposerKt.sourceInformationMarkerStart(composer2, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
                if (!(composer2.getApplier() instanceof Applier)) {
                    ComposablesKt.invalidApplier();
                }
                composer2.startReusableNode();
                if (composer2.getInserting()) {
                    composer2.createNode(constructor2);
                } else {
                    composer2.useNode();
                }
                Composer composerM6062constructorimpl2 = Updater.m6062constructorimpl(composer2);
                Updater.m6070setimpl(composerM6062constructorimpl2, measurePolicyMaybeCachedBoxMeasurePolicy2, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                Updater.m6070setimpl(composerM6062constructorimpl2, currentCompositionLocalMap2, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                Updater.m6066initimpl(composerM6062constructorimpl2, Integer.valueOf(iHashCode2), ComposeUiNode.INSTANCE.getSetCompositeKeyHash());
                Updater.m6068reconcileimpl(composerM6062constructorimpl2, ComposeUiNode.INSTANCE.getApplyOnDeactivatedNodeAssertion());
                Updater.m6070setimpl(composerM6062constructorimpl2, modifierMaterializeModifier2, ComposeUiNode.INSTANCE.getSetModifier());
                ComposerKt.sourceInformationMarkerStart(composer2, 1833054614, "C72@3469L9:Box.kt#2w3rfo");
                BoxScopeInstance boxScopeInstance2 = BoxScopeInstance.INSTANCE;
                ComposerKt.sourceInformationMarkerStart(composer2, 1436584620, "C287@11452L169:BrowseFragment.kt#89mwni");
                final FilesFabReducer.State fabMenuState = BrowseFragmentContent$lambda$0$0(stateCollectAsStateWithLifecycle).getFabMenuState();
                if (fabMenuState == null) {
                    composer2.startReplaceGroup(1436598072);
                    composer2.endReplaceGroup();
                    composer2 = composer2;
                } else {
                    composer2.startReplaceGroup(1436598073);
                    ComposerKt.sourceInformation(composer2, "*278@10953L40,281@11137L150,275@10771L646");
                    BrowseFragmentKt$BrowseFragmentContent$1$1$1$1 browseFragmentKt$BrowseFragmentContent$1$1$1$1 = new PropertyReference1Impl() { // from class: com.box.android.browse.cpl.browse.BrowseFragmentKt$BrowseFragmentContent$1$1$1$1
                        @Override // kotlin.jvm.internal.PropertyReference1Impl, kotlin.reflect.KProperty1
                        public Object get(Object obj) {
                            return ((BrowseReducer.State) obj).getFabMenuState();
                        }
                    };
                    ComposerKt.sourceInformationMarkerStart(composer2, -737590213, "CC(remember):BrowseFragment.kt#9igjgp");
                    BrowseFragmentKt$BrowseFragmentContent$1$1$1$2$1 browseFragmentKt$BrowseFragmentContent$1$1$1$2$1RememberedValue = composer2.rememberedValue();
                    if (browseFragmentKt$BrowseFragmentContent$1$1$1$2$1RememberedValue == Composer.INSTANCE.getEmpty()) {
                        browseFragmentKt$BrowseFragmentContent$1$1$1$2$1RememberedValue = BrowseFragmentKt$BrowseFragmentContent$1$1$1$2$1.INSTANCE;
                        composer2.updateRememberedValue(browseFragmentKt$BrowseFragmentContent$1$1$1$2$1RememberedValue);
                    }
                    ComposerKt.sourceInformationMarkerEnd(composer2);
                    Store<LocalState, LocalAction> storeIfScope = store.ifScope(browseFragmentKt$BrowseFragmentContent$1$1$1$1, (Function1) ((KFunction) browseFragmentKt$BrowseFragmentContent$1$1$1$2$1RememberedValue));
                    ComposerKt.sourceInformationMarkerStart(composer2, -737584215, "CC(remember):BrowseFragment.kt#9igjgp");
                    boolean zChangedInstance = composer2.changedInstance(fabMenuState) | ((i3 & 7168) == 2048);
                    Object objRememberedValue2 = composer2.rememberedValue();
                    if (zChangedInstance || objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                        objRememberedValue2 = new Function1() { // from class: com.box.android.browse.cpl.browse.BrowseFragmentKt$$ExternalSyntheticLambda0
                            @Override // kotlin.jvm.functions.Function1
                            public final Object invoke(Object obj) {
                                return BrowseFragmentKt.BrowseFragmentContent$lambda$0$2$0$1$0(onCreateNewDocumentClicked, fabMenuState, (String) obj);
                            }
                        };
                        composer2.updateRememberedValue(objRememberedValue2);
                    }
                    Function1 function1 = (Function1) objRememberedValue2;
                    ComposerKt.sourceInformationMarkerEnd(composer2);
                    FilesFabComponentKt.FilesFabComponent(storeIfScope, snackbarHostState, function1, null, !BrowseFragmentContent$lambda$0$0(stateCollectAsStateWithLifecycle).getActionableItemsListState().getIsSelecting() && scrollAwareFabVisibilityRememberScrollAwareFabVisibility.isVisible(), composer2, 48, 8);
                    composer2.endReplaceGroup();
                }
                SwipeableSnackbarHostKt.SwipeableSnackbarHost(snackbarHostState, boxScopeInstance2.align(Modifier.INSTANCE, Alignment.INSTANCE.getBottomCenter()), composer2, 6, 0);
                ComposerKt.sourceInformationMarkerEnd(composer2);
                ComposerKt.sourceInformationMarkerEnd(composer2);
                composer2.endNode();
                ComposerKt.sourceInformationMarkerEnd(composer2);
                ComposerKt.sourceInformationMarkerEnd(composer2);
                ComposerKt.sourceInformationMarkerEnd(composer2);
            } else {
                composer2.startReplaceGroup(525164284);
            }
            composer2.endReplaceGroup();
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
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.box.android.browse.cpl.browse.BrowseFragmentKt$$ExternalSyntheticLambda1
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return BrowseFragmentKt.BrowseFragmentContent$lambda$1(store, z, z2, onCreateNewDocumentClicked, i, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit BrowseFragmentContent$lambda$0$2$0$1$0(Function2 function2, FilesFabReducer.State state, String fileTypeAssetName) {
        Intrinsics.checkNotNullParameter(fileTypeAssetName, "fileTypeAssetName");
        function2.invoke(state.getCurrentFolder(), fileTypeAssetName);
        return Unit.INSTANCE;
    }

    private static final BrowseReducer.State BrowseFragmentContent$lambda$0$0(State<BrowseReducer.State> state) {
        return state.getValue();
    }
}
