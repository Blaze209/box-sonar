package com.box.android.preview.previewtype.document.search.ui;

import androidx.compose.animation.AnimatedContentKt;
import androidx.compose.animation.AnimatedContentScope;
import androidx.compose.animation.AnimatedVisibilityKt;
import androidx.compose.animation.AnimatedVisibilityScope;
import androidx.compose.animation.EnterExitTransitionKt;
import androidx.compose.animation.EnterTransition;
import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.RowKt;
import androidx.compose.foundation.layout.RowScopeInstance;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.layout.WindowInsetsPadding_androidKt;
import androidx.compose.foundation.shape.RoundedCornerShapeKt;
import androidx.compose.material.icons.Icons;
import androidx.compose.material.icons.outlined.KeyboardArrowDownKt;
import androidx.compose.material.icons.outlined.KeyboardArrowUpKt;
import androidx.compose.material3.TextKt;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.ProvidableCompositionLocal;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.State;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.draw.ClipKt;
import androidx.compose.ui.graphics.vector.ImageVector;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.platform.SoftwareKeyboardController;
import androidx.compose.ui.platform.TestTagKt;
import androidx.compose.ui.res.StringResources_androidKt;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.unit.Dp;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.compose.FlowExtKt;
import com.box.android.base.compose.BoxTheme;
import com.box.android.base.compose.ComposeUtilsKt;
import com.box.android.base.compose.button.BoxIconButtonKt;
import com.box.android.base.compose.button.model.ButtonItem;
import com.box.android.base.compose.button.model.ButtonItemIconResource;
import com.box.android.base.compose.progressbar.BoxCircularProgressBarKt;
import com.box.android.base.models.ButtonState;
import com.box.android.cpl.Store;
import com.box.android.preview.R;
import com.box.android.preview.previewtype.document.search.DocumentSearchReducer;
import com.facebook.react.uimanager.ViewProps;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.flow.StateFlow;

/* JADX INFO: compiled from: DocumentSearchBottomBar.kt */
/* JADX INFO: loaded from: classes12.dex */
@Metadata(d1 = {"\u0000@\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\u001a/\u0010\u0000\u001a\u00020\u00012\u0016\u0010\u0002\u001a\u0012\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u0007H\u0007¢\u0006\u0002\u0010\b\u001a\u001f\u0010\t\u001a\u00020\u00012\u0006\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\u0006\u001a\u00020\u0007H\u0003¢\u0006\u0002\u0010\f\u001a?\u0010\r\u001a\u00020\u00012\u0006\u0010\u000e\u001a\u00020\u000f2\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00010\u00112\u0006\u0010\u0012\u001a\u00020\u00132\b\b\u0001\u0010\u0014\u001a\u00020\u00152\b\b\u0002\u0010\u0006\u001a\u00020\u0007H\u0003¢\u0006\u0002\u0010\u0016¨\u0006\u0017"}, d2 = {"DocumentSearchBottomBar", "", "store", "Lcom/box/android/cpl/Store;", "Lcom/box/android/preview/previewtype/document/search/DocumentSearchReducer$State;", "Lcom/box/android/preview/previewtype/document/search/DocumentSearchReducer$Action;", "modifier", "Landroidx/compose/ui/Modifier;", "(Lcom/box/android/cpl/Store;Landroidx/compose/ui/Modifier;Landroidx/compose/runtime/Composer;II)V", "ResultsText", "resultsState", "Lcom/box/android/preview/previewtype/document/search/DocumentSearchReducer$SearchState;", "(Lcom/box/android/preview/previewtype/document/search/DocumentSearchReducer$SearchState;Landroidx/compose/ui/Modifier;Landroidx/compose/runtime/Composer;II)V", "NavigationButton", "imageVector", "Landroidx/compose/ui/graphics/vector/ImageVector;", ViewProps.ON_CLICK, "Lkotlin/Function0;", "isEnabled", "", "contentDescriptionId", "", "(Landroidx/compose/ui/graphics/vector/ImageVector;Lkotlin/jvm/functions/Function0;ZILandroidx/compose/ui/Modifier;Landroidx/compose/runtime/Composer;II)V", "preview_generalProdRelease"}, k = 2, mv = {2, 2, 0}, xi = 48)
public final class DocumentSearchBottomBarKt {
    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit DocumentSearchBottomBar$lambda$0(Store store, Modifier modifier, int i, int i2, Composer composer, int i3) {
        DocumentSearchBottomBar(store, modifier, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final int DocumentSearchBottomBar$lambda$1$0(int i) {
        return i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final int DocumentSearchBottomBar$lambda$2$0(int i) {
        return i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit DocumentSearchBottomBar$lambda$4(Store store, Modifier modifier, int i, int i2, Composer composer, int i3) {
        DocumentSearchBottomBar(store, modifier, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit NavigationButton$lambda$0(ImageVector imageVector, Function0 function0, boolean z, int i, Modifier modifier, int i2, int i3, Composer composer, int i4) {
        NavigationButton(imageVector, function0, z, i, modifier, composer, RecomposeScopeImplKt.updateChangedFlags(i2 | 1), i3);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ResultsText$lambda$1(DocumentSearchReducer.SearchState searchState, Modifier modifier, int i, int i2, Composer composer, int i3) {
        ResultsText(searchState, modifier, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    public static final void DocumentSearchBottomBar(final Store<DocumentSearchReducer.State, DocumentSearchReducer.Action> store, final Modifier modifier, Composer composer, final int i, final int i2) {
        int i3;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        Function2<? super Composer, ? super Integer, Unit> function2;
        State stateCollectAsStateWithLifecycle;
        final DocumentSearchReducer.State state;
        Composer composerStartRestartGroup = composer.startRestartGroup(-861728878);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(DocumentSearchBottomBar)N(store,modifier)54@2910L7,59@3083L20,60@3139L20,61@3166L2036,56@2923L2279:DocumentSearchBottomBar.kt#z0e3so");
        if ((i & 6) == 0) {
            i3 = (composerStartRestartGroup.changed(store) ? 4 : 2) | i;
        } else {
            i3 = i;
        }
        int i4 = i2 & 2;
        if (i4 != 0) {
            i3 |= 48;
        } else if ((i & 48) == 0) {
            i3 |= composerStartRestartGroup.changed(modifier) ? 32 : 16;
        }
        if (!composerStartRestartGroup.shouldExecute((i3 & 19) != 18, i3 & 1)) {
            composerStartRestartGroup.skipToGroupEnd();
        } else {
            if (i4 != 0) {
                modifier = Modifier.INSTANCE;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-861728878, i3, -1, "com.box.android.preview.previewtype.document.search.ui.DocumentSearchBottomBar (DocumentSearchBottomBar.kt:52)");
            }
            StateFlow<DocumentSearchReducer.State> state2 = store != null ? store.getState() : null;
            if (state2 == null) {
                composerStartRestartGroup.startReplaceGroup(-745310734);
                composerStartRestartGroup.endReplaceGroup();
                stateCollectAsStateWithLifecycle = null;
            } else {
                composerStartRestartGroup.startReplaceGroup(807241711);
                ComposerKt.sourceInformation(composerStartRestartGroup, "53@2802L29");
                stateCollectAsStateWithLifecycle = FlowExtKt.collectAsStateWithLifecycle(state2, (LifecycleOwner) null, (Lifecycle.State) null, (CoroutineContext) null, composerStartRestartGroup, 0, 7);
                composerStartRestartGroup.endReplaceGroup();
            }
            if (stateCollectAsStateWithLifecycle == null || (state = (DocumentSearchReducer.State) stateCollectAsStateWithLifecycle.getValue()) == null) {
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup == null) {
                    return;
                } else {
                    function2 = new Function2() { // from class: com.box.android.preview.previewtype.document.search.ui.DocumentSearchBottomBarKt$$ExternalSyntheticLambda4
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return DocumentSearchBottomBarKt.DocumentSearchBottomBar$lambda$0(store, modifier, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    };
                }
            } else {
                ProvidableCompositionLocal<SoftwareKeyboardController> localSoftwareKeyboardController = CompositionLocalsKt.getLocalSoftwareKeyboardController();
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
                Object objConsume = composerStartRestartGroup.consume(localSoftwareKeyboardController);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                final SoftwareKeyboardController softwareKeyboardController = (SoftwareKeyboardController) objConsume;
                Modifier modifierImePadding = WindowInsetsPadding_androidKt.imePadding(modifier);
                boolean z = !(state.getSearchState() instanceof DocumentSearchReducer.SearchState.NotStarted);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 807250694, "CC(remember):DocumentSearchBottomBar.kt#9igjgp");
                Object objRememberedValue = composerStartRestartGroup.rememberedValue();
                if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue = new Function1() { // from class: com.box.android.preview.previewtype.document.search.ui.DocumentSearchBottomBarKt$$ExternalSyntheticLambda5
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            return Integer.valueOf(DocumentSearchBottomBarKt.DocumentSearchBottomBar$lambda$1$0(((Integer) obj).intValue()));
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                }
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                EnterTransition enterTransitionSlideInVertically$default = EnterExitTransitionKt.slideInVertically$default(null, (Function1) objRememberedValue, 1, null);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 807252486, "CC(remember):DocumentSearchBottomBar.kt#9igjgp");
                Object objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                if (objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue2 = new Function1() { // from class: com.box.android.preview.previewtype.document.search.ui.DocumentSearchBottomBarKt$$ExternalSyntheticLambda6
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            return Integer.valueOf(DocumentSearchBottomBarKt.DocumentSearchBottomBar$lambda$2$0(((Integer) obj).intValue()));
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                }
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                AnimatedVisibilityKt.AnimatedVisibility(z, modifierImePadding, enterTransitionSlideInVertically$default, EnterExitTransitionKt.slideOutVertically$default(null, (Function1) objRememberedValue2, 1, null), (String) null, ComposableLambdaKt.rememberComposableLambda(782622138, true, new Function3() { // from class: com.box.android.preview.previewtype.document.search.ui.DocumentSearchBottomBarKt$$ExternalSyntheticLambda7
                    @Override // kotlin.jvm.functions.Function3
                    public final Object invoke(Object obj, Object obj2, Object obj3) {
                        return DocumentSearchBottomBarKt.DocumentSearchBottomBar$lambda$3(state, softwareKeyboardController, store, (AnimatedVisibilityScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                    }
                }, composerStartRestartGroup, 54), composerStartRestartGroup, 200064, 16);
                composerStartRestartGroup = composerStartRestartGroup;
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
            }
            scopeUpdateScopeEndRestartGroup.updateScope(function2);
        }
        scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            function2 = new Function2() { // from class: com.box.android.preview.previewtype.document.search.ui.DocumentSearchBottomBarKt$$ExternalSyntheticLambda8
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return DocumentSearchBottomBarKt.DocumentSearchBottomBar$lambda$4(store, modifier, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                }
            };
            scopeUpdateScopeEndRestartGroup.updateScope(function2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit DocumentSearchBottomBar$lambda$3(DocumentSearchReducer.State state, final SoftwareKeyboardController softwareKeyboardController, final Store store, AnimatedVisibilityScope AnimatedVisibility, Composer composer, int i) {
        Composer composer2 = composer;
        Intrinsics.checkNotNullParameter(AnimatedVisibility, "$this$AnimatedVisibility");
        ComposerKt.sourceInformation(composer2, "C64@3250L6,68@3454L6,62@3176L2020:DocumentSearchBottomBar.kt#z0e3so");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(782622138, i, -1, "com.box.android.preview.previewtype.document.search.ui.DocumentSearchBottomBar.<anonymous> (DocumentSearchBottomBar.kt:62)");
        }
        Modifier modifierTestTag = TestTagKt.testTag(ComposeUtilsKt.m11640topBorderHht5A8o$default(SizeKt.fillMaxWidth$default(SizeKt.m1252height3ABfNKs(WindowInsetsPadding_androidKt.navigationBarsPadding(BackgroundKt.m589backgroundbw27NRU$default(Modifier.INSTANCE, BoxTheme.INSTANCE.getColors(composer2, BoxTheme.$stable).m11511getContentBackground0d7_KjU(), null, 2, null)), BoxTheme.INSTANCE.getSizes().m11613getPreviewBottomSearchBarHeightD9Ej5fM()), 0.0f, 1, null), BoxTheme.INSTANCE.getColors(composer2, BoxTheme.$stable).m11517getDivider0d7_KjU(), 0.0f, 2, null), "Preview:SearchBottomBar");
        Arrangement.HorizontalOrVertical spaceBetween = Arrangement.INSTANCE.getSpaceBetween();
        Alignment.Vertical centerVertically = Alignment.INSTANCE.getCenterVertically();
        ComposerKt.sourceInformationMarkerStart(composer2, 844473419, "CC(Row)N(modifier,horizontalArrangement,verticalAlignment,content)99@5125L58,100@5188L131:Row.kt#2w3rfo");
        MeasurePolicy measurePolicyRowMeasurePolicy = RowKt.rowMeasurePolicy(spaceBetween, centerVertically, composer2, 54);
        ComposerKt.sourceInformationMarkerStart(composer2, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
        int iHashCode = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composer2, 0));
        CompositionLocalMap currentCompositionLocalMap = composer2.getCurrentCompositionLocalMap();
        Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composer2, modifierTestTag);
        Function0<ComposeUiNode> constructor = ComposeUiNode.INSTANCE.getConstructor();
        ComposerKt.sourceInformationMarkerStart(composer2, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
        if (!(composer2.getApplier() instanceof Applier)) {
            ComposablesKt.invalidApplier();
        }
        composer2.startReusableNode();
        if (composer2.getInserting()) {
            composer2.createNode(constructor);
        } else {
            composer2.useNode();
        }
        Composer composerM6062constructorimpl = Updater.m6062constructorimpl(composer2);
        Updater.m6070setimpl(composerM6062constructorimpl, measurePolicyRowMeasurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
        Updater.m6070setimpl(composerM6062constructorimpl, currentCompositionLocalMap, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
        Updater.m6066initimpl(composerM6062constructorimpl, Integer.valueOf(iHashCode), ComposeUiNode.INSTANCE.getSetCompositeKeyHash());
        Updater.m6068reconcileimpl(composerM6062constructorimpl, ComposeUiNode.INSTANCE.getApplyOnDeactivatedNodeAssertion());
        Updater.m6070setimpl(composerM6062constructorimpl, modifierMaterializeModifier, ComposeUiNode.INSTANCE.getSetModifier());
        ComposerKt.sourceInformationMarkerStart(composer2, 1456264949, "C101@5233L9:Row.kt#2w3rfo");
        RowScopeInstance rowScopeInstance = RowScopeInstance.INSTANCE;
        ComposerKt.sourceInformationMarkerStart(composer2, 1165379199, "C73@3668L135:DocumentSearchBottomBar.kt#z0e3so");
        ResultsText(state.getSearchState(), PaddingKt.m1222paddingqDBjuR0$default(Modifier.INSTANCE, Dp.m9687constructorimpl(24), 0.0f, 0.0f, 0.0f, 14, null), composer2, 48, 0);
        if (state.getNavigationButtonsState() == ButtonState.HIDDEN) {
            composer2.startReplaceGroup(1161692492);
        } else {
            composer2.startReplaceGroup(1165576203);
            ComposerKt.sourceInformation(composer2, "79@3891L1281");
            Modifier modifierM1222paddingqDBjuR0$default = PaddingKt.m1222paddingqDBjuR0$default(Modifier.INSTANCE, 0.0f, 0.0f, Dp.m9687constructorimpl(10), 0.0f, 11, null);
            ComposerKt.sourceInformationMarkerStart(composer2, 844473419, "CC(Row)N(modifier,horizontalArrangement,verticalAlignment,content)99@5125L58,100@5188L131:Row.kt#2w3rfo");
            MeasurePolicy measurePolicyRowMeasurePolicy2 = RowKt.rowMeasurePolicy(Arrangement.INSTANCE.getStart(), Alignment.INSTANCE.getTop(), composer2, 0);
            ComposerKt.sourceInformationMarkerStart(composer2, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
            int iHashCode2 = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composer2, 0));
            CompositionLocalMap currentCompositionLocalMap2 = composer2.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier2 = ComposedModifierKt.materializeModifier(composer2, modifierM1222paddingqDBjuR0$default);
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
            Updater.m6070setimpl(composerM6062constructorimpl2, measurePolicyRowMeasurePolicy2, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
            Updater.m6070setimpl(composerM6062constructorimpl2, currentCompositionLocalMap2, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
            Updater.m6066initimpl(composerM6062constructorimpl2, Integer.valueOf(iHashCode2), ComposeUiNode.INSTANCE.getSetCompositeKeyHash());
            Updater.m6068reconcileimpl(composerM6062constructorimpl2, ComposeUiNode.INSTANCE.getApplyOnDeactivatedNodeAssertion());
            Updater.m6070setimpl(composerM6062constructorimpl2, modifierMaterializeModifier2, ComposeUiNode.INSTANCE.getSetModifier());
            ComposerKt.sourceInformationMarkerStart(composer2, 1456264949, "C101@5233L9:Row.kt#2w3rfo");
            RowScopeInstance rowScopeInstance2 = RowScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart(composer2, -1424869945, "C84@4119L171,82@3997L567,94@4709L173,92@4585L569:DocumentSearchBottomBar.kt#z0e3so");
            ImageVector keyboardArrowUp = KeyboardArrowUpKt.getKeyboardArrowUp(Icons.Outlined.INSTANCE);
            ComposerKt.sourceInformationMarkerStart(composer2, -1431433950, "CC(remember):DocumentSearchBottomBar.kt#9igjgp");
            boolean zChanged = composer2.changed(softwareKeyboardController) | composer2.changed(store);
            Object objRememberedValue = composer2.rememberedValue();
            if (zChanged || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                objRememberedValue = new Function0() { // from class: com.box.android.preview.previewtype.document.search.ui.DocumentSearchBottomBarKt$$ExternalSyntheticLambda10
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return DocumentSearchBottomBarKt.DocumentSearchBottomBar$lambda$3$0$0$0$0(softwareKeyboardController, store);
                    }
                };
                composer2.updateRememberedValue(objRememberedValue);
            }
            ComposerKt.sourceInformationMarkerEnd(composer2);
            float f = 8;
            NavigationButton(keyboardArrowUp, (Function0) objRememberedValue, state.getNavigationButtonsState().isEnabled(), R.string.preview_search_navigate_previous_result_descritpion, PaddingKt.m1222paddingqDBjuR0$default(Modifier.INSTANCE, 0.0f, 0.0f, Dp.m9687constructorimpl(f), 0.0f, 11, null), composer, 24576, 0);
            composer2 = composer;
            ImageVector keyboardArrowDown = KeyboardArrowDownKt.getKeyboardArrowDown(Icons.Outlined.INSTANCE);
            ComposerKt.sourceInformationMarkerStart(composer2, -1431415068, "CC(remember):DocumentSearchBottomBar.kt#9igjgp");
            boolean zChanged2 = composer2.changed(softwareKeyboardController) | composer2.changed(store);
            Object objRememberedValue2 = composer2.rememberedValue();
            if (zChanged2 || objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                objRememberedValue2 = new Function0() { // from class: com.box.android.preview.previewtype.document.search.ui.DocumentSearchBottomBarKt$$ExternalSyntheticLambda1
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return DocumentSearchBottomBarKt.DocumentSearchBottomBar$lambda$3$0$0$1$0(softwareKeyboardController, store);
                    }
                };
                composer2.updateRememberedValue(objRememberedValue2);
            }
            ComposerKt.sourceInformationMarkerEnd(composer2);
            NavigationButton(keyboardArrowDown, (Function0) objRememberedValue2, state.getNavigationButtonsState().isEnabled(), R.string.preview_search_navigate_next_result_descritpion, PaddingKt.m1222paddingqDBjuR0$default(Modifier.INSTANCE, Dp.m9687constructorimpl(f), 0.0f, 0.0f, 0.0f, 14, null), composer2, 24576, 0);
            ComposerKt.sourceInformationMarkerEnd(composer2);
            ComposerKt.sourceInformationMarkerEnd(composer2);
            composer2.endNode();
            ComposerKt.sourceInformationMarkerEnd(composer2);
            ComposerKt.sourceInformationMarkerEnd(composer2);
            ComposerKt.sourceInformationMarkerEnd(composer2);
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
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit DocumentSearchBottomBar$lambda$3$0$0$0$0(SoftwareKeyboardController softwareKeyboardController, Store store) {
        if (softwareKeyboardController != null) {
            softwareKeyboardController.hide();
        }
        store.send(new DocumentSearchReducer.Action.NavigateClicked(DocumentSearchReducer.SearchResultsNavigationDirection.UP));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit DocumentSearchBottomBar$lambda$3$0$0$1$0(SoftwareKeyboardController softwareKeyboardController, Store store) {
        if (softwareKeyboardController != null) {
            softwareKeyboardController.hide();
        }
        store.send(new DocumentSearchReducer.Action.NavigateClicked(DocumentSearchReducer.SearchResultsNavigationDirection.DOWN));
        return Unit.INSTANCE;
    }

    /* JADX WARN: Code duplicated, block: B:23:0x0048  */
    /* JADX WARN: Code duplicated, block: B:24:0x004a  */
    /* JADX WARN: Code duplicated, block: B:27:0x0053 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:28:0x0055  */
    /* JADX WARN: Code duplicated, block: B:29:0x005b  */
    /* JADX WARN: Code duplicated, block: B:32:0x0062  */
    /* JADX WARN: Code duplicated, block: B:35:0x00f5  */
    /* JADX WARN: Code duplicated, block: B:38:0x0101  */
    /* JADX WARN: Code duplicated, block: B:39:0x0105  */
    /* JADX WARN: Code duplicated, block: B:42:0x01d1  */
    /* JADX WARN: Code duplicated, block: B:43:0x01d5  */
    /* JADX WARN: Code duplicated, block: B:46:0x01df  */
    /* JADX WARN: Code duplicated, block: B:48:? A[RETURN, SYNTHETIC] */
    private static final void ResultsText(final DocumentSearchReducer.SearchState searchState, Modifier modifier, Composer composer, final int i, final int i2) {
        int i3;
        Modifier modifier2;
        boolean z;
        final Modifier modifier3;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        Modifier modifier4;
        Function0<ComposeUiNode> constructor;
        Composer composerStartRestartGroup = composer.startRestartGroup(847496428);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(ResultsText)N(resultsState,modifier)111@5383L6,114@5418L1409:DocumentSearchBottomBar.kt#z0e3so");
        if ((i & 6) == 0) {
            i3 = (composerStartRestartGroup.changed(searchState) ? 4 : 2) | i;
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
                modifier3 = modifier2;
            } else {
                if (i4 != 0) {
                    modifier4 = Modifier.INSTANCE;
                } else {
                    modifier4 = modifier2;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(847496428, i3, -1, "com.box.android.preview.previewtype.document.search.ui.ResultsText (DocumentSearchBottomBar.kt:109)");
                }
                final TextStyle textStyleM9104copyp1EtxEg$default = TextStyle.m9104copyp1EtxEg$default(BoxTheme.INSTANCE.getTypography().getBoxBold14(), BoxTheme.INSTANCE.getColors(composerStartRestartGroup, BoxTheme.$stable).m11513getContentSecondary0d7_KjU(), 0L, null, null, null, null, null, 0L, null, null, null, 0L, null, null, null, 0, 0, 0L, null, null, null, 0, 0, null, 16777214, null);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1042775818, "CC(Box)N(modifier,contentAlignment,propagateMinConstraints,content)71@3424L131:Box.kt#2w3rfo");
                MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), false);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
                int iHashCode = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
                CompositionLocalMap currentCompositionLocalMap = composerStartRestartGroup.getCurrentCompositionLocalMap();
                Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifier4);
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
                Updater.m6070setimpl(composerM6062constructorimpl, measurePolicyMaybeCachedBoxMeasurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                Updater.m6070setimpl(composerM6062constructorimpl, currentCompositionLocalMap, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                Updater.m6066initimpl(composerM6062constructorimpl, Integer.valueOf(iHashCode), ComposeUiNode.INSTANCE.getSetCompositeKeyHash());
                Updater.m6068reconcileimpl(composerM6062constructorimpl, ComposeUiNode.INSTANCE.getApplyOnDeactivatedNodeAssertion());
                Updater.m6070setimpl(composerM6062constructorimpl, modifierMaterializeModifier, ComposeUiNode.INSTANCE.getSetModifier());
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1833054614, "C72@3469L9:Box.kt#2w3rfo");
                BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 931820165, "C118@5543L660,115@5453L750,145@6476L345,141@6303L518:DocumentSearchBottomBar.kt#z0e3so");
                AnimatedContentKt.AnimatedContent(searchState, null, null, null, "", null, ComposableLambdaKt.rememberComposableLambda(-689227902, true, new Function4() { // from class: com.box.android.preview.previewtype.document.search.ui.DocumentSearchBottomBarKt$$ExternalSyntheticLambda0
                    @Override // kotlin.jvm.functions.Function4
                    public final Object invoke(Object obj, Object obj2, Object obj3, Object obj4) {
                        return DocumentSearchBottomBarKt.ResultsText$lambda$0$0(textStyleM9104copyp1EtxEg$default, (AnimatedContentScope) obj, (DocumentSearchReducer.SearchState) obj2, (Composer) obj3, ((Integer) obj4).intValue());
                    }
                }, composerStartRestartGroup, 54), composerStartRestartGroup, (i3 & 14) | 1597440, 46);
                modifier3 = modifier4;
                AnimatedVisibilityKt.AnimatedVisibility(searchState instanceof DocumentSearchReducer.SearchState.Results, (Modifier) null, EnterExitTransitionKt.fadeIn$default(null, 0.0f, 3, null).plus(EnterExitTransitionKt.m389scaleInL8ZKhE$default(null, 0.0f, 0L, 7, null)), EnterExitTransitionKt.fadeOut$default(null, 0.0f, 3, null).plus(EnterExitTransitionKt.m391scaleOutL8ZKhE$default(null, 0.0f, 0L, 7, null)), (String) null, ComposableLambdaKt.rememberComposableLambda(1711744590, true, new Function3() { // from class: com.box.android.preview.previewtype.document.search.ui.DocumentSearchBottomBarKt$$ExternalSyntheticLambda2
                    @Override // kotlin.jvm.functions.Function3
                    public final Object invoke(Object obj, Object obj2, Object obj3) {
                        return DocumentSearchBottomBarKt.ResultsText$lambda$0$1(searchState, textStyleM9104copyp1EtxEg$default, (AnimatedVisibilityScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                    }
                }, composerStartRestartGroup, 54), composerStartRestartGroup, 200064, 18);
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
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.box.android.preview.previewtype.document.search.ui.DocumentSearchBottomBarKt$$ExternalSyntheticLambda3
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return DocumentSearchBottomBarKt.ResultsText$lambda$1(searchState, modifier3, i, i2, (Composer) obj, ((Integer) obj2).intValue());
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
            modifier3 = modifier2;
        } else {
            if (i4 != 0) {
                modifier4 = Modifier.INSTANCE;
            } else {
                modifier4 = modifier2;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(847496428, i3, -1, "com.box.android.preview.previewtype.document.search.ui.ResultsText (DocumentSearchBottomBar.kt:109)");
            }
            final TextStyle textStyleM9104copyp1EtxEg$default2 = TextStyle.m9104copyp1EtxEg$default(BoxTheme.INSTANCE.getTypography().getBoxBold14(), BoxTheme.INSTANCE.getColors(composerStartRestartGroup, BoxTheme.$stable).m11513getContentSecondary0d7_KjU(), 0L, null, null, null, null, null, 0L, null, null, null, 0L, null, null, null, 0, 0, 0L, null, null, null, 0, 0, null, 16777214, null);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1042775818, "CC(Box)N(modifier,contentAlignment,propagateMinConstraints,content)71@3424L131:Box.kt#2w3rfo");
            MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy2 = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), false);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
            int iHashCode2 = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
            CompositionLocalMap currentCompositionLocalMap2 = composerStartRestartGroup.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier2 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifier4);
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
            Updater.m6070setimpl(composerM6062constructorimpl2, measurePolicyMaybeCachedBoxMeasurePolicy2, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
            Updater.m6070setimpl(composerM6062constructorimpl2, currentCompositionLocalMap2, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
            Updater.m6066initimpl(composerM6062constructorimpl2, Integer.valueOf(iHashCode2), ComposeUiNode.INSTANCE.getSetCompositeKeyHash());
            Updater.m6068reconcileimpl(composerM6062constructorimpl2, ComposeUiNode.INSTANCE.getApplyOnDeactivatedNodeAssertion());
            Updater.m6070setimpl(composerM6062constructorimpl2, modifierMaterializeModifier2, ComposeUiNode.INSTANCE.getSetModifier());
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1833054614, "C72@3469L9:Box.kt#2w3rfo");
            BoxScopeInstance boxScopeInstance2 = BoxScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 931820165, "C118@5543L660,115@5453L750,145@6476L345,141@6303L518:DocumentSearchBottomBar.kt#z0e3so");
            AnimatedContentKt.AnimatedContent(searchState, null, null, null, "", null, ComposableLambdaKt.rememberComposableLambda(-689227902, true, new Function4() { // from class: com.box.android.preview.previewtype.document.search.ui.DocumentSearchBottomBarKt$$ExternalSyntheticLambda0
                @Override // kotlin.jvm.functions.Function4
                public final Object invoke(Object obj, Object obj2, Object obj3, Object obj4) {
                    return DocumentSearchBottomBarKt.ResultsText$lambda$0$0(textStyleM9104copyp1EtxEg$default2, (AnimatedContentScope) obj, (DocumentSearchReducer.SearchState) obj2, (Composer) obj3, ((Integer) obj4).intValue());
                }
            }, composerStartRestartGroup, 54), composerStartRestartGroup, (i3 & 14) | 1597440, 46);
            modifier3 = modifier4;
            AnimatedVisibilityKt.AnimatedVisibility(searchState instanceof DocumentSearchReducer.SearchState.Results, (Modifier) null, EnterExitTransitionKt.fadeIn$default(null, 0.0f, 3, null).plus(EnterExitTransitionKt.m389scaleInL8ZKhE$default(null, 0.0f, 0L, 7, null)), EnterExitTransitionKt.fadeOut$default(null, 0.0f, 3, null).plus(EnterExitTransitionKt.m391scaleOutL8ZKhE$default(null, 0.0f, 0L, 7, null)), (String) null, ComposableLambdaKt.rememberComposableLambda(1711744590, true, new Function3() { // from class: com.box.android.preview.previewtype.document.search.ui.DocumentSearchBottomBarKt$$ExternalSyntheticLambda2
                @Override // kotlin.jvm.functions.Function3
                public final Object invoke(Object obj, Object obj2, Object obj3) {
                    return DocumentSearchBottomBarKt.ResultsText$lambda$0$1(searchState, textStyleM9104copyp1EtxEg$default2, (AnimatedVisibilityScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                }
            }, composerStartRestartGroup, 54), composerStartRestartGroup, 200064, 18);
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
        scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.box.android.preview.previewtype.document.search.ui.DocumentSearchBottomBarKt$$ExternalSyntheticLambda3
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return DocumentSearchBottomBarKt.ResultsText$lambda$1(searchState, modifier3, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ResultsText$lambda$0$0(TextStyle textStyle, AnimatedContentScope AnimatedContent, DocumentSearchReducer.SearchState it, Composer composer, int i) {
        Intrinsics.checkNotNullParameter(AnimatedContent, "$this$AnimatedContent");
        Intrinsics.checkNotNullParameter(it, "it");
        ComposerKt.sourceInformation(composer, "CN(it):DocumentSearchBottomBar.kt#z0e3so");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-689227902, i, -1, "com.box.android.preview.previewtype.document.search.ui.ResultsText.<anonymous>.<anonymous> (DocumentSearchBottomBar.kt:119)");
        }
        if (it instanceof DocumentSearchReducer.SearchState.InProgress) {
            composer.startReplaceGroup(1450292808);
            ComposerKt.sourceInformation(composer, "121@5636L240");
            BoxCircularProgressBarKt.m11734BoxCircularProgressBarO8KfPlw(TestTagKt.testTag(SizeKt.m1266size3ABfNKs(Modifier.INSTANCE, Dp.m9687constructorimpl(24)), "Preview:SearchProgressBar"), null, 0L, 0L, Dp.m9687constructorimpl(2), 0, null, composer, 24582, 110);
            composer.endReplaceGroup();
        } else {
            if (!(it instanceof DocumentSearchReducer.SearchState.NothingFound)) {
                composer.startReplaceGroup(1450823466);
                composer.endReplaceGroup();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                return Unit.INSTANCE;
            }
            composer.startReplaceGroup(1450616324);
            ComposerKt.sourceInformation(composer, "131@6002L46,130@5965L148");
            TextKt.m4494TextNvy7gAk(StringResources_androidKt.stringResource(R.string.no_results_found, composer, 0), null, 0L, null, 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, textStyle, composer, 0, 0, 131070);
            composer.endReplaceGroup();
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ResultsText$lambda$0$1(DocumentSearchReducer.SearchState searchState, TextStyle textStyle, AnimatedVisibilityScope AnimatedVisibility, Composer composer, int i) {
        Intrinsics.checkNotNullParameter(AnimatedVisibility, "$this$AnimatedVisibility");
        ComposerKt.sourceInformation(composer, "C147@6582L229:DocumentSearchBottomBar.kt#z0e3so");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1711744590, i, -1, "com.box.android.preview.previewtype.document.search.ui.ResultsText.<anonymous>.<anonymous> (DocumentSearchBottomBar.kt:146)");
        }
        DocumentSearchReducer.SearchState.Results results = searchState instanceof DocumentSearchReducer.SearchState.Results ? (DocumentSearchReducer.SearchState.Results) searchState : null;
        if (results == null) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            return Unit.INSTANCE;
        }
        TextKt.m4494TextNvy7gAk((results.getSelectedResultIndex() + 1) + " / " + results.getResults().getValue().size(), TestTagKt.testTag(Modifier.INSTANCE, "Preview:SearchBottomBarResultsText"), 0L, null, 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, textStyle, composer, 48, 0, 131068);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        return Unit.INSTANCE;
    }

    /* JADX WARN: Code duplicated, block: B:45:0x007d  */
    /* JADX WARN: Code duplicated, block: B:46:0x007f  */
    /* JADX WARN: Code duplicated, block: B:49:0x0088 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:50:0x008a  */
    /* JADX WARN: Code duplicated, block: B:51:0x008f  */
    /* JADX WARN: Code duplicated, block: B:54:0x0096  */
    /* JADX WARN: Code duplicated, block: B:57:0x00f3  */
    /* JADX WARN: Code duplicated, block: B:58:0x00f7  */
    /* JADX WARN: Code duplicated, block: B:61:0x0101  */
    /* JADX WARN: Code duplicated, block: B:63:? A[RETURN, SYNTHETIC] */
    private static final void NavigationButton(final ImageVector imageVector, final Function0<Unit> function0, final boolean z, final int i, Modifier modifier, Composer composer, final int i2, final int i3) {
        int i4;
        Function0<Unit> function1;
        Modifier modifier2;
        boolean z2;
        final Modifier.Companion companion;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        Composer composerStartRestartGroup = composer.startRestartGroup(-1982029363);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(NavigationButton)N(imageVector,onClick,isEnabled,contentDescriptionId,modifier)169@7282L41,173@7427L6,164@7036L464:DocumentSearchBottomBar.kt#z0e3so");
        if ((i2 & 6) == 0) {
            i4 = (composerStartRestartGroup.changed(imageVector) ? 4 : 2) | i2;
        } else {
            i4 = i2;
        }
        if ((i2 & 48) == 0) {
            function1 = function0;
            i4 |= composerStartRestartGroup.changedInstance(function1) ? 32 : 16;
        } else {
            function1 = function0;
        }
        if ((i2 & 384) == 0) {
            i4 |= composerStartRestartGroup.changed(z) ? 256 : 128;
        }
        if ((i2 & 3072) == 0) {
            i4 |= composerStartRestartGroup.changed(i) ? 2048 : 1024;
        }
        int i5 = i3 & 16;
        if (i5 == 0) {
            if ((i2 & 24576) == 0) {
                modifier2 = modifier;
                i4 |= composerStartRestartGroup.changed(modifier2) ? 16384 : 8192;
            }
            if ((i4 & 9363) != 9362) {
                z2 = true;
            } else {
                z2 = false;
            }
            if (composerStartRestartGroup.shouldExecute(z2, i4 & 1)) {
                composerStartRestartGroup.skipToGroupEnd();
                companion = modifier2;
            } else {
                if (i5 != 0) {
                    companion = Modifier.INSTANCE;
                } else {
                    companion = modifier2;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-1982029363, i4, -1, "com.box.android.preview.previewtype.document.search.ui.NavigationButton (DocumentSearchBottomBar.kt:163)");
                }
                BoxIconButtonKt.m11681BoxIconButtonuDo3WH8(new ButtonItem.IconButtonItem(z, function1, StringResources_androidKt.stringResource(i, composerStartRestartGroup, (i4 >> 9) & 14), new ButtonItemIconResource.ImageVectorResource(imageVector), false, 16, null), SizeKt.m1266size3ABfNKs(BackgroundKt.m589backgroundbw27NRU$default(ClipKt.clip(companion, RoundedCornerShapeKt.getCircleShape()), BoxTheme.INSTANCE.getColors(composerStartRestartGroup, BoxTheme.$stable).m11512getContentBackgroundSelectedSecondary0d7_KjU(), null, 2, null), Dp.m9687constructorimpl(30)), null, 0L, 0.0f, composerStartRestartGroup, 0, 28);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
            }
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.box.android.preview.previewtype.document.search.ui.DocumentSearchBottomBarKt$$ExternalSyntheticLambda9
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return DocumentSearchBottomBarKt.NavigationButton$lambda$0(imageVector, function0, z, i, companion, i2, i3, (Composer) obj, ((Integer) obj2).intValue());
                    }
                });
            }
        }
        i4 |= 24576;
        modifier2 = modifier;
        if ((i4 & 9363) != 9362) {
            z2 = true;
        } else {
            z2 = false;
        }
        if (composerStartRestartGroup.shouldExecute(z2, i4 & 1)) {
            composerStartRestartGroup.skipToGroupEnd();
            companion = modifier2;
        } else {
            if (i5 != 0) {
                companion = Modifier.INSTANCE;
            } else {
                companion = modifier2;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1982029363, i4, -1, "com.box.android.preview.previewtype.document.search.ui.NavigationButton (DocumentSearchBottomBar.kt:163)");
            }
            BoxIconButtonKt.m11681BoxIconButtonuDo3WH8(new ButtonItem.IconButtonItem(z, function1, StringResources_androidKt.stringResource(i, composerStartRestartGroup, (i4 >> 9) & 14), new ButtonItemIconResource.ImageVectorResource(imageVector), false, 16, null), SizeKt.m1266size3ABfNKs(BackgroundKt.m589backgroundbw27NRU$default(ClipKt.clip(companion, RoundedCornerShapeKt.getCircleShape()), BoxTheme.INSTANCE.getColors(composerStartRestartGroup, BoxTheme.$stable).m11512getContentBackgroundSelectedSecondary0d7_KjU(), null, 2, null), Dp.m9687constructorimpl(30)), null, 0L, 0.0f, composerStartRestartGroup, 0, 28);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.box.android.preview.previewtype.document.search.ui.DocumentSearchBottomBarKt$$ExternalSyntheticLambda9
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return DocumentSearchBottomBarKt.NavigationButton$lambda$0(imageVector, function0, z, i, companion, i2, i3, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }
}
