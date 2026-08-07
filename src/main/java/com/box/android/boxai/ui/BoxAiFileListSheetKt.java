package com.box.android.boxai.ui;

import androidx.activity.compose.BackHandlerKt;
import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.ColumnKt;
import androidx.compose.foundation.layout.ColumnScope;
import androidx.compose.foundation.layout.ColumnScopeInstance;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.foundation.layout.WindowInsets;
import androidx.compose.foundation.layout.WindowInsetsKt;
import androidx.compose.foundation.layout.WindowInsetsPaddingKt;
import androidx.compose.foundation.layout.WindowInsetsSides;
import androidx.compose.foundation.layout.WindowInsets_androidKt;
import androidx.compose.foundation.lazy.LazyDslKt;
import androidx.compose.foundation.lazy.LazyItemScope;
import androidx.compose.foundation.lazy.LazyListScope;
import androidx.compose.material3.ModalBottomSheetKt;
import androidx.compose.material3.SheetState;
import androidx.compose.material3.TextKt;
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
import androidx.compose.ui.unit.TextUnitKt;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.compose.FlowExtKt;
import com.box.android.base.compose.BoxModalBottomSheetKt;
import com.box.android.base.compose.BoxTheme;
import com.box.android.base.compose.BoxThemeKt;
import com.box.android.base.compose.ComposePreviewMocks;
import com.box.android.base.compose.ComposePreviewUtilsKt;
import com.box.android.boxai.R;
import com.box.android.boxai.qa.BoxAiQaReducer;
import com.box.android.cpl.Store;
import com.box.android.domain.models.boxai.AiUnavailabilityReason;
import com.box.android.domain.models.item.FileModel;
import com.box.android.domain.models.item.FolderModel;
import com.box.android.domain.models.item.ItemModel;
import external.sdk.pendo.io.mozilla.javascript.Token;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: compiled from: BoxAiFileListSheet.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u00008\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\u001a!\u0010\u0000\u001a\u00020\u00012\u0012\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003H\u0007¢\u0006\u0002\u0010\u0006\u001a=\u0010\u0007\u001a\u00020\u00012\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\t2\u0018\u0010\u000b\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u000e0\f0\t2\u0006\u0010\u000f\u001a\u00020\u0010H\u0007¢\u0006\u0002\u0010\u0011\u001a\r\u0010\u0012\u001a\u00020\u0001H\u0003¢\u0006\u0002\u0010\u0013\u001a\r\u0010\u0014\u001a\u00020\u0001H\u0003¢\u0006\u0002\u0010\u0013¨\u0006\u0015²\u0006\n\u0010\u0016\u001a\u00020\u0004X\u008a\u0084\u0002"}, d2 = {"BoxAiFileListSheet", "", "store", "Lcom/box/android/cpl/Store;", "Lcom/box/android/boxai/qa/BoxAiQaReducer$State;", "Lcom/box/android/boxai/qa/BoxAiQaReducer$Action;", "(Lcom/box/android/cpl/Store;Landroidx/compose/runtime/Composer;I)V", "BoxAiFileListSheetContent", "fileModels", "", "Lcom/box/android/domain/models/item/FileModel;", "unsupportedItems", "Lkotlin/Pair;", "Lcom/box/android/domain/models/item/ItemModel;", "Lcom/box/android/domain/models/boxai/AiUnavailabilityReason;", "totalFileCount", "", "(Ljava/util/List;Ljava/util/List;ILandroidx/compose/runtime/Composer;I)V", "BoxAiFileListSheetContentPreview", "(Landroidx/compose/runtime/Composer;I)V", "BoxAiFileListSheetPreview", "boxai_generalProdRelease", "state"}, k = 2, mv = {2, 2, 0}, xi = 48)
public final class BoxAiFileListSheetKt {
    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit BoxAiFileListSheet$lambda$1(Store store, int i, Composer composer, int i2) {
        BoxAiFileListSheet(store, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit BoxAiFileListSheet$lambda$4(Store store, int i, Composer composer, int i2) {
        BoxAiFileListSheet(store, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit BoxAiFileListSheetContent$lambda$1(List list, List list2, int i, int i2, Composer composer, int i3) {
        BoxAiFileListSheetContent(list, list2, i, composer, RecomposeScopeImplKt.updateChangedFlags(i2 | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit BoxAiFileListSheetContentPreview$lambda$1(int i, Composer composer, int i2) {
        BoxAiFileListSheetContentPreview(composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit BoxAiFileListSheetPreview$lambda$1(int i, Composer composer, int i2) {
        BoxAiFileListSheetPreview(composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    public static final void BoxAiFileListSheet(final Store<BoxAiQaReducer.State, BoxAiQaReducer.Action> store, Composer composer, final int i) {
        int i2;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        Function2<? super Composer, ? super Integer, Unit> function2;
        Intrinsics.checkNotNullParameter(store, "store");
        Composer composerStartRestartGroup = composer.startRestartGroup(-784954327);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(BoxAiFileListSheet)N(store)46@2132L29,48@2184L59,49@2269L24,58@2622L10,63@2841L50,64@2898L411,53@2341L968:BoxAiFileListSheet.kt#bwxcym");
        if ((i & 6) == 0) {
            i2 = (composerStartRestartGroup.changed(store) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if (!composerStartRestartGroup.shouldExecute((i2 & 3) != 2, i2 & 1)) {
            composerStartRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-784954327, i2, -1, "com.box.android.boxai.ui.BoxAiFileListSheet (BoxAiFileListSheet.kt:45)");
            }
            final State stateCollectAsStateWithLifecycle = FlowExtKt.collectAsStateWithLifecycle(store.getState(), (LifecycleOwner) null, (Lifecycle.State) null, (CoroutineContext) null, composerStartRestartGroup, 0, 7);
            final SheetState sheetStateRememberModalBottomSheetState = ModalBottomSheetKt.rememberModalBottomSheetState(true, null, composerStartRestartGroup, 6, 2);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 773894976, "CC(rememberCoroutineScope)N(getContext)600@27430L68:Effects.kt#9igjgp");
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 683736516, "CC(remember):Effects.kt#9igjgp");
            Object objRememberedValue = composerStartRestartGroup.rememberedValue();
            if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                objRememberedValue = EffectsKt.createCompositionCoroutineScope(EmptyCoroutineContext.INSTANCE, composerStartRestartGroup);
                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
            }
            final CoroutineScope coroutineScope = (CoroutineScope) objRememberedValue;
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            if (BoxAiFileListSheet$lambda$0(stateCollectAsStateWithLifecycle).getShowFileListSheet()) {
                Modifier modifierM1222paddingqDBjuR0$default = PaddingKt.m1222paddingqDBjuR0$default(WindowInsetsPaddingKt.windowInsetsPadding(TestTagKt.testTag(Modifier.INSTANCE, "BoxAi:FileListSheet"), WindowInsetsKt.m1294onlybOOhFvg(WindowInsets_androidKt.getSystemBars(WindowInsets.INSTANCE, composerStartRestartGroup, 6), WindowInsetsSides.m1311plusgK_yJZ4(WindowInsetsSides.INSTANCE.m1321getHorizontalJoeWqyM(), WindowInsetsSides.INSTANCE.m1325getTopJoeWqyM()))), 0.0f, Dp.m9687constructorimpl(20), 0.0f, 0.0f, 13, null);
                float fM9707getUnspecifiedD9Ej5fM = Dp.INSTANCE.m9707getUnspecifiedD9Ej5fM();
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1573162203, "CC(remember):BoxAiFileListSheet.kt#9igjgp");
                boolean z = (i2 & 14) == 4;
                Object objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                if (z || objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue2 = new Function0() { // from class: com.box.android.boxai.ui.BoxAiFileListSheetKt$$ExternalSyntheticLambda4
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            return BoxAiFileListSheetKt.BoxAiFileListSheet$lambda$2$0(store);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                }
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                BoxModalBottomSheetKt.m11602BoxModalBottomSheet4erKP6g((Function0) objRememberedValue2, modifierM1222paddingqDBjuR0$default, sheetStateRememberModalBottomSheetState, fM9707getUnspecifiedD9Ej5fM, 0L, 0L, 0L, ComposableLambdaKt.rememberComposableLambda(-147310535, true, new Function3() { // from class: com.box.android.boxai.ui.BoxAiFileListSheetKt$$ExternalSyntheticLambda5
                    @Override // kotlin.jvm.functions.Function3
                    public final Object invoke(Object obj, Object obj2, Object obj3) {
                        return BoxAiFileListSheetKt.BoxAiFileListSheet$lambda$3(sheetStateRememberModalBottomSheetState, coroutineScope, store, stateCollectAsStateWithLifecycle, (ColumnScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                    }
                }, composerStartRestartGroup, 54), composerStartRestartGroup, 12585984, 112);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
            } else {
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup == null) {
                    return;
                } else {
                    function2 = new Function2() { // from class: com.box.android.boxai.ui.BoxAiFileListSheetKt$$ExternalSyntheticLambda3
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return BoxAiFileListSheetKt.BoxAiFileListSheet$lambda$1(store, i, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    };
                }
            }
            scopeUpdateScopeEndRestartGroup.updateScope(function2);
        }
        scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            function2 = new Function2() { // from class: com.box.android.boxai.ui.BoxAiFileListSheetKt$$ExternalSyntheticLambda6
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return BoxAiFileListSheetKt.BoxAiFileListSheet$lambda$4(store, i, (Composer) obj, ((Integer) obj2).intValue());
                }
            };
            scopeUpdateScopeEndRestartGroup.updateScope(function2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit BoxAiFileListSheet$lambda$2$0(Store store) {
        store.send(BoxAiQaReducer.Action.HideFileList.INSTANCE);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit BoxAiFileListSheet$lambda$3(final SheetState sheetState, final CoroutineScope coroutineScope, final Store store, State state, ColumnScope BoxModalBottomSheet, Composer composer, int i) {
        Intrinsics.checkNotNullParameter(BoxModalBottomSheet, "$this$BoxModalBottomSheet");
        ComposerKt.sourceInformation(composer, "C65@2908L184,70@3145L158,70@3101L202:BoxAiFileListSheet.kt#bwxcym");
        if (!composer.shouldExecute((i & 17) != 16, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-147310535, i, -1, "com.box.android.boxai.ui.BoxAiFileListSheet.<anonymous> (BoxAiFileListSheet.kt:65)");
            }
            BoxAiFileListSheetContent(BoxAiFileListSheet$lambda$0(state).getFileModels(), BoxAiFileListSheet$lambda$0(state).getUnsupportedItems(), BoxAiFileListSheet$lambda$0(state).getTotalFileCount(), composer, 0);
            boolean zIsVisible = sheetState.isVisible();
            ComposerKt.sourceInformationMarkerStart(composer, 168504695, "CC(remember):BoxAiFileListSheet.kt#9igjgp");
            boolean zChangedInstance = composer.changedInstance(coroutineScope) | composer.changed(sheetState) | composer.changed(store);
            Object objRememberedValue = composer.rememberedValue();
            if (zChangedInstance || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                objRememberedValue = new Function0() { // from class: com.box.android.boxai.ui.BoxAiFileListSheetKt$$ExternalSyntheticLambda7
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return BoxAiFileListSheetKt.BoxAiFileListSheet$lambda$3$0$0(coroutineScope, sheetState, store);
                    }
                };
                composer.updateRememberedValue(objRememberedValue);
            }
            ComposerKt.sourceInformationMarkerEnd(composer);
            BackHandlerKt.BackHandler(zIsVisible, (Function0) objRememberedValue, composer, 0, 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit BoxAiFileListSheet$lambda$3$0$0(CoroutineScope coroutineScope, SheetState sheetState, Store store) {
        BuildersKt__Builders_commonKt.launch$default(coroutineScope, null, null, new BoxAiFileListSheetKt$BoxAiFileListSheet$3$1$1$1(sheetState, store, null), 3, null);
        return Unit.INSTANCE;
    }

    public static final void BoxAiFileListSheetContent(final List<FileModel> fileModels, final List<? extends Pair<? extends ItemModel, ? extends AiUnavailabilityReason>> unsupportedItems, final int i, Composer composer, final int i2) {
        int i3;
        Composer composer2;
        Intrinsics.checkNotNullParameter(fileModels, "fileModels");
        Intrinsics.checkNotNullParameter(unsupportedItems, "unsupportedItems");
        Composer composerStartRestartGroup = composer.startRestartGroup(1436285538);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(BoxAiFileListSheetContent)N(fileModels,unsupportedItems,totalFileCount)85@3490L857:BoxAiFileListSheet.kt#bwxcym");
        if ((i2 & 6) == 0) {
            i3 = (composerStartRestartGroup.changedInstance(fileModels) ? 4 : 2) | i2;
        } else {
            i3 = i2;
        }
        if ((i2 & 48) == 0) {
            i3 |= composerStartRestartGroup.changedInstance(unsupportedItems) ? 32 : 16;
        }
        if ((i2 & 384) == 0) {
            i3 |= composerStartRestartGroup.changed(i) ? 256 : 128;
        }
        if (!composerStartRestartGroup.shouldExecute((i3 & Token.DOTQUERY) != 146, i3 & 1)) {
            composer2 = composerStartRestartGroup;
            composer2.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1436285538, i3, -1, "com.box.android.boxai.ui.BoxAiFileListSheetContent (BoxAiFileListSheet.kt:84)");
            }
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1341605231, "CC(Column)N(modifier,verticalArrangement,horizontalAlignment,content)87@4443L61,88@4509L134:Column.kt#2w3rfo");
            Modifier.Companion companion = Modifier.INSTANCE;
            MeasurePolicy measurePolicyColumnMeasurePolicy = ColumnKt.columnMeasurePolicy(Arrangement.INSTANCE.getTop(), Alignment.INSTANCE.getStart(), composerStartRestartGroup, 0);
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
            Updater.m6070setimpl(composerM6062constructorimpl, measurePolicyColumnMeasurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
            Updater.m6070setimpl(composerM6062constructorimpl, currentCompositionLocalMap, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
            Updater.m6066initimpl(composerM6062constructorimpl, Integer.valueOf(iHashCode), ComposeUiNode.INSTANCE.getSetCompositeKeyHash());
            Updater.m6068reconcileimpl(composerM6062constructorimpl, ComposeUiNode.INSTANCE.getApplyOnDeactivatedNodeAssertion());
            Updater.m6070setimpl(composerM6062constructorimpl, modifierMaterializeModifier, ComposeUiNode.INSTANCE.getSetModifier());
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2093002350, "C89@4557L9:Column.kt#2w3rfo");
            ColumnScopeInstance columnScopeInstance = ColumnScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1294125547, "C87@3532L80,89@3696L6,86@3507L327,96@3926L415,94@3844L497:BoxAiFileListSheet.kt#bwxcym");
            TextKt.m4494TextNvy7gAk(StringResources_androidKt.pluralStringResource(R.plurals.box_ai_num_files, i, new Object[]{Integer.valueOf(i)}, composerStartRestartGroup, (i3 >> 3) & 112), PaddingKt.m1219paddingVpY3zN4(Modifier.INSTANCE, Dp.m9687constructorimpl(24), Dp.m9687constructorimpl(16)), BoxTheme.INSTANCE.getColors(composerStartRestartGroup, BoxTheme.$stable).m11500getAppPrimary0d7_KjU(), null, 0L, null, null, null, 0L, null, null, TextUnitKt.getSp(28), 0, false, 0, 0, null, BoxTheme.INSTANCE.getTypography().getBoxNormal22(), composerStartRestartGroup, 48, 48, 129016);
            PaddingValues paddingValuesM1213PaddingValuesYgX7TsA$default = PaddingKt.m1213PaddingValuesYgX7TsA$default(0.0f, Dp.m9687constructorimpl(8), 1, null);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -595922325, "CC(remember):BoxAiFileListSheet.kt#9igjgp");
            boolean zChangedInstance = composerStartRestartGroup.changedInstance(fileModels) | composerStartRestartGroup.changedInstance(unsupportedItems);
            Object objRememberedValue = composerStartRestartGroup.rememberedValue();
            if (zChangedInstance || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                objRememberedValue = new Function1() { // from class: com.box.android.boxai.ui.BoxAiFileListSheetKt$$ExternalSyntheticLambda8
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return BoxAiFileListSheetKt.BoxAiFileListSheetContent$lambda$0$0$0(fileModels, unsupportedItems, (LazyListScope) obj);
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
            }
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            LazyDslKt.LazyColumn(null, null, paddingValuesM1213PaddingValuesYgX7TsA$default, false, null, null, null, false, null, (Function1) objRememberedValue, composerStartRestartGroup, 384, 507);
            composer2 = composerStartRestartGroup;
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
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.box.android.boxai.ui.BoxAiFileListSheetKt$$ExternalSyntheticLambda9
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return BoxAiFileListSheetKt.BoxAiFileListSheetContent$lambda$1(fileModels, unsupportedItems, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    private static final void BoxAiFileListSheetContentPreview(Composer composer, final int i) {
        Composer composerStartRestartGroup = composer.startRestartGroup(1482140841);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(BoxAiFileListSheetContentPreview)127@4884L273,127@4875L282:BoxAiFileListSheet.kt#bwxcym");
        if (!composerStartRestartGroup.shouldExecute(i != 0, i & 1)) {
            composerStartRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1482140841, i, -1, "com.box.android.boxai.ui.BoxAiFileListSheetContentPreview (BoxAiFileListSheet.kt:118)");
            }
            final List listListOf = CollectionsKt.listOf((Object[]) new FileModel[]{FileModel.copy$default(ComposePreviewMocks.INSTANCE.getEMPTY_FILE_MODEL(), null, "ACME_Report_2023.doc", false, false, null, null, null, null, null, null, null, false, 0L, null, null, null, null, null, null, null, null, null, null, null, null, null, null, 134217725, null), FileModel.copy$default(ComposePreviewMocks.INSTANCE.getEMPTY_FILE_MODEL(), null, "ACME_Invoice_Sullivan.pdf", false, false, null, null, null, null, null, null, null, false, 0L, null, null, null, null, null, null, null, null, null, null, null, null, null, null, 134217725, null)});
            final List listListOf2 = CollectionsKt.listOf(TuplesKt.to(FileModel.copy$default(ComposePreviewMocks.INSTANCE.getEMPTY_FILE_MODEL(), null, "Unsupported.exe", false, false, null, null, null, null, null, null, null, false, 0L, null, null, null, null, null, null, null, null, null, null, null, null, null, null, 134217725, null), AiUnavailabilityReason.NOT_SUPPORTED));
            BoxThemeKt.BoxTheme(ComposableLambdaKt.rememberComposableLambda(-1597186434, true, new Function2() { // from class: com.box.android.boxai.ui.BoxAiFileListSheetKt$$ExternalSyntheticLambda10
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return BoxAiFileListSheetKt.BoxAiFileListSheetContentPreview$lambda$0(listListOf, listListOf2, (Composer) obj, ((Integer) obj2).intValue());
                }
            }, composerStartRestartGroup, 54), composerStartRestartGroup, 6);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.box.android.boxai.ui.BoxAiFileListSheetKt$$ExternalSyntheticLambda1
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return BoxAiFileListSheetKt.BoxAiFileListSheetContentPreview$lambda$1(i, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit BoxAiFileListSheetContentPreview$lambda$0(List list, List list2, Composer composer, int i) {
        ComposerKt.sourceInformation(composer, "C128@4929L6,128@4894L257:BoxAiFileListSheet.kt#bwxcym");
        if (!composer.shouldExecute((i & 3) != 2, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1597186434, i, -1, "com.box.android.boxai.ui.BoxAiFileListSheetContentPreview.<anonymous> (BoxAiFileListSheet.kt:128)");
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
            ComposerKt.sourceInformationMarkerStart(composer, 1179693058, "C129@4972L169:BoxAiFileListSheet.kt#bwxcym");
            BoxAiFileListSheetContent(list, list2, 3, composer, 384);
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

    private static final void BoxAiFileListSheetPreview(Composer composer, final int i) {
        Composer composerStartRestartGroup = composer.startRestartGroup(421987746);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(BoxAiFileListSheetPreview)159@6056L184,159@6047L193:BoxAiFileListSheet.kt#bwxcym");
        if (!composerStartRestartGroup.shouldExecute(i != 0, i & 1)) {
            composerStartRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(421987746, i, -1, "com.box.android.boxai.ui.BoxAiFileListSheetPreview (BoxAiFileListSheet.kt:141)");
            }
            final BoxAiQaReducer.State state = new BoxAiQaReducer.State(CollectionsKt.listOf((Object[]) new FileModel[]{FileModel.copy$default(ComposePreviewMocks.INSTANCE.getEMPTY_FILE_MODEL(), null, "ACME_Report_2023.doc", false, false, null, null, null, null, null, null, null, false, 0L, null, null, null, null, null, null, null, null, null, null, null, null, null, null, 134217725, null), FileModel.copy$default(ComposePreviewMocks.INSTANCE.getEMPTY_FILE_MODEL(), null, "ACME_Invoice_Sullivan.pdf", false, false, null, null, null, null, null, null, null, false, 0L, null, null, null, null, null, null, null, null, null, null, null, null, null, null, 134217725, null)}), CollectionsKt.listOf((Object[]) new Pair[]{TuplesKt.to(FileModel.copy$default(ComposePreviewMocks.INSTANCE.getEMPTY_FILE_MODEL(), null, "Unsupported.exe", false, false, null, null, null, null, null, null, null, false, 0L, null, null, null, null, null, null, null, null, null, null, null, null, null, null, 134217725, null), AiUnavailabilityReason.NOT_SUPPORTED), TuplesKt.to(FileModel.copy$default(ComposePreviewMocks.INSTANCE.getEMPTY_FILE_MODEL(), null, "image.jpg", false, false, null, null, null, null, null, null, null, false, 0L, null, null, null, null, null, null, null, null, null, null, null, null, null, null, 134217725, null), AiUnavailabilityReason.FILE_TYPE_MIXING_NOT_ALLOWED), TuplesKt.to(FolderModel.copy$default(ComposePreviewMocks.INSTANCE.getEMPTY_FOLDER_MODEL(), null, "New folder", false, false, null, null, null, null, null, null, null, false, null, null, null, null, null, null, null, 524285, null), AiUnavailabilityReason.NOT_SUPPORTED)}), "", false, false, null, null, null, null, null, null, null, false, true, false, 24568, null);
            BoxThemeKt.BoxTheme(ComposableLambdaKt.rememberComposableLambda(533137773, true, new Function2() { // from class: com.box.android.boxai.ui.BoxAiFileListSheetKt$$ExternalSyntheticLambda0
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return BoxAiFileListSheetKt.BoxAiFileListSheetPreview$lambda$0(state, (Composer) obj, ((Integer) obj2).intValue());
                }
            }, composerStartRestartGroup, 54), composerStartRestartGroup, 6);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.box.android.boxai.ui.BoxAiFileListSheetKt$$ExternalSyntheticLambda2
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return BoxAiFileListSheetKt.BoxAiFileListSheetPreview$lambda$1(i, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit BoxAiFileListSheetPreview$lambda$0(BoxAiQaReducer.State state, Composer composer, int i) {
        ComposerKt.sourceInformation(composer, "C160@6101L6,160@6066L168:BoxAiFileListSheet.kt#bwxcym");
        if (!composer.shouldExecute((i & 3) != 2, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(533137773, i, -1, "com.box.android.boxai.ui.BoxAiFileListSheetPreview.<anonymous> (BoxAiFileListSheet.kt:160)");
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
            ComposerKt.sourceInformationMarkerStart(composer, -1530015328, "C161@6144L80:BoxAiFileListSheet.kt#bwxcym");
            BoxAiFileListSheet(ComposePreviewUtilsKt.createMockStore(state), composer, 0);
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

    private static final BoxAiQaReducer.State BoxAiFileListSheet$lambda$0(State<BoxAiQaReducer.State> state) {
        return state.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit BoxAiFileListSheetContent$lambda$0$0$0(final List list, final List list2, LazyListScope LazyColumn) {
        Intrinsics.checkNotNullParameter(LazyColumn, "$this$LazyColumn");
        final BoxAiFileListSheetKt$BoxAiFileListSheetContent$lambda$0$0$0$$inlined$items$default$1 boxAiFileListSheetKt$BoxAiFileListSheetContent$lambda$0$0$0$$inlined$items$default$1 = new Function1() { // from class: com.box.android.boxai.ui.BoxAiFileListSheetKt$BoxAiFileListSheetContent$lambda$0$0$0$$inlined$items$default$1
            @Override // kotlin.jvm.functions.Function1
            public final Void invoke(FileModel fileModel) {
                return null;
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                return invoke((FileModel) obj);
            }
        };
        LazyColumn.items(list.size(), null, new Function1<Integer, Object>() { // from class: com.box.android.boxai.ui.BoxAiFileListSheetKt$BoxAiFileListSheetContent$lambda$0$0$0$$inlined$items$default$3
            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Object invoke(Integer num) {
                return invoke(num.intValue());
            }

            public final Object invoke(int i) {
                return boxAiFileListSheetKt$BoxAiFileListSheetContent$lambda$0$0$0$$inlined$items$default$1.invoke(list.get(i));
            }
        }, ComposableLambdaKt.composableLambdaInstance(802480018, true, new Function4<LazyItemScope, Integer, Composer, Integer, Unit>() { // from class: com.box.android.boxai.ui.BoxAiFileListSheetKt$BoxAiFileListSheetContent$lambda$0$0$0$$inlined$items$default$4
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
                FileModel fileModel = (FileModel) list.get(i);
                composer.startReplaceGroup(417917081);
                ComposerKt.sourceInformation(composer, "CN(file)*98@3984L122:BoxAiFileListSheet.kt#bwxcym");
                BoxAiFileListItemKt.BoxAiFileListItem(fileModel, null, null, composer, 384, 2);
                composer.endReplaceGroup();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
            }
        }));
        final BoxAiFileListSheetKt$BoxAiFileListSheetContent$lambda$0$0$0$$inlined$items$default$5 boxAiFileListSheetKt$BoxAiFileListSheetContent$lambda$0$0$0$$inlined$items$default$5 = new Function1() { // from class: com.box.android.boxai.ui.BoxAiFileListSheetKt$BoxAiFileListSheetContent$lambda$0$0$0$$inlined$items$default$5
            @Override // kotlin.jvm.functions.Function1
            public final Void invoke(Pair<? extends ItemModel, ? extends AiUnavailabilityReason> pair) {
                return null;
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                return invoke((Pair<? extends ItemModel, ? extends AiUnavailabilityReason>) obj);
            }
        };
        LazyColumn.items(list2.size(), null, new Function1<Integer, Object>() { // from class: com.box.android.boxai.ui.BoxAiFileListSheetKt$BoxAiFileListSheetContent$lambda$0$0$0$$inlined$items$default$7
            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Object invoke(Integer num) {
                return invoke(num.intValue());
            }

            public final Object invoke(int i) {
                return boxAiFileListSheetKt$BoxAiFileListSheetContent$lambda$0$0$0$$inlined$items$default$5.invoke(list2.get(i));
            }
        }, ComposableLambdaKt.composableLambdaInstance(802480018, true, new Function4<LazyItemScope, Integer, Composer, Integer, Unit>() { // from class: com.box.android.boxai.ui.BoxAiFileListSheetKt$BoxAiFileListSheetContent$lambda$0$0$0$$inlined$items$default$8
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
                Pair pair = (Pair) list2.get(i);
                composer.startReplaceGroup(680412883);
                ComposerKt.sourceInformation(composer, "C*104@4193L124:BoxAiFileListSheet.kt#bwxcym");
                BoxAiFileListItemKt.BoxAiFileListItem((ItemModel) pair.component1(), null, (AiUnavailabilityReason) pair.component2(), composer, 0, 2);
                composer.endReplaceGroup();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
            }
        }));
        return Unit.INSTANCE;
    }
}
