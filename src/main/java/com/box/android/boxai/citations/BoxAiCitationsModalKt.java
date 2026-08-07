package com.box.android.boxai.citations;

import androidx.activity.compose.BackHandlerKt;
import androidx.compose.foundation.BorderStroke;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.ColumnKt;
import androidx.compose.foundation.layout.ColumnScope;
import androidx.compose.foundation.layout.ColumnScopeInstance;
import androidx.compose.foundation.layout.IntrinsicKt;
import androidx.compose.foundation.layout.IntrinsicSize;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.foundation.layout.RowKt;
import androidx.compose.foundation.layout.RowScope;
import androidx.compose.foundation.layout.RowScopeInstance;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.layout.SpacerKt;
import androidx.compose.foundation.layout.WindowInsets;
import androidx.compose.foundation.layout.WindowInsetsKt;
import androidx.compose.foundation.layout.WindowInsetsPaddingKt;
import androidx.compose.foundation.layout.WindowInsetsSides;
import androidx.compose.foundation.layout.WindowInsets_androidKt;
import androidx.compose.foundation.lazy.LazyDslKt;
import androidx.compose.foundation.lazy.LazyItemScope;
import androidx.compose.foundation.lazy.LazyListScope;
import androidx.compose.material3.ButtonColors;
import androidx.compose.material3.ButtonElevation;
import androidx.compose.material3.ButtonKt;
import androidx.compose.material3.DividerKt;
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
import androidx.compose.ui.draw.DrawModifierKt;
import androidx.compose.ui.geometry.Size;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.graphics.drawscope.DrawScope;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.platform.TestTagKt;
import androidx.compose.ui.res.StringResources_androidKt;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.unit.Dp;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.compose.FlowExtKt;
import com.box.android.base.compose.BoxModalBottomSheetKt;
import com.box.android.base.compose.BoxTheme;
import com.box.android.base.compose.BoxThemeKt;
import com.box.android.boxai.R;
import com.box.android.boxai.ui.BoxAITheme;
import com.box.android.cpl.Store;
import com.box.android.domain.models.boxai.AiCitationModel;
import com.box.android.domain.models.item.FileModel;
import com.facebook.react.uimanager.ViewProps;
import com.google.firebase.analytics.FirebaseAnalytics;
import external.sdk.pendo.io.mozilla.javascript.Token;
import java.util.List;
import kotlin.Metadata;
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

/* JADX INFO: compiled from: BoxAiCitationsModal.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000<\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\t\u001aC\u0010\u0000\u001a\u00020\u00012\u0012\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u00032\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u00072\u0012\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u00010\nH\u0007¢\u0006\u0002\u0010\f\u001aE\u0010\r\u001a\u00020\u00012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u00072\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u000b0\u00072\u0006\u0010\u000f\u001a\u00020\u00102\u0012\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u00010\nH\u0007¢\u0006\u0002\u0010\u0011\u001aA\u0010\u0012\u001a\u00020\u00012\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0015\u001a\u00020\u00102\u0006\u0010\u0016\u001a\u00020\u000b2\u0012\u0010\u0017\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u00010\nH\u0003¢\u0006\u0002\u0010\u0018\u001a\r\u0010\u0019\u001a\u00020\u0001H\u0003¢\u0006\u0002\u0010\u001a\u001a\r\u0010\u001b\u001a\u00020\u0001H\u0003¢\u0006\u0002\u0010\u001a¨\u0006\u001c²\u0006\n\u0010\u001d\u001a\u00020\u0004X\u008a\u0084\u0002"}, d2 = {"BoxAiCitationsModal", "", "store", "Lcom/box/android/cpl/Store;", "Lcom/box/android/boxai/citations/BoxAiCitationsReducer$State;", "Lcom/box/android/boxai/citations/BoxAiCitationsReducer$Action;", "fileModels", "", "Lcom/box/android/domain/models/item/FileModel;", "onCitationClick", "Lkotlin/Function1;", "Lcom/box/android/domain/models/boxai/AiCitationModel;", "(Lcom/box/android/cpl/Store;Ljava/util/List;Lkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;I)V", "BoxAiCitationsModalContent", "citations", "citationHighlightEnabled", "", "(Ljava/util/List;Ljava/util/List;ZLkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;I)V", "BoxAiCitationItem", FirebaseAnalytics.Param.INDEX, "", "showFileName", "citation", ViewProps.ON_CLICK, "(IZZLcom/box/android/domain/models/boxai/AiCitationModel;Lkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;I)V", "BoxAiCitationsModalContentSingleFilePreview", "(Landroidx/compose/runtime/Composer;I)V", "BoxAiCitationsModalContentMultipleFilesPreview", "boxai_generalProdRelease", "state"}, k = 2, mv = {2, 2, 0}, xi = 48)
public final class BoxAiCitationsModalKt {
    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit BoxAiCitationItem$lambda$1(int i, boolean z, boolean z2, AiCitationModel aiCitationModel, Function1 function1, int i2, Composer composer, int i3) {
        BoxAiCitationItem(i, z, z2, aiCitationModel, function1, composer, RecomposeScopeImplKt.updateChangedFlags(i2 | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit BoxAiCitationsModal$lambda$1(Store store, List list, Function1 function1, int i, Composer composer, int i2) {
        BoxAiCitationsModal(store, list, function1, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit BoxAiCitationsModal$lambda$4(Store store, List list, Function1 function1, int i, Composer composer, int i2) {
        BoxAiCitationsModal(store, list, function1, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit BoxAiCitationsModalContent$lambda$1(List list, List list2, boolean z, Function1 function1, int i, Composer composer, int i2) {
        BoxAiCitationsModalContent(list, list2, z, function1, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit BoxAiCitationsModalContentMultipleFilesPreview$lambda$0(int i, Composer composer, int i2) {
        BoxAiCitationsModalContentMultipleFilesPreview(composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit BoxAiCitationsModalContentSingleFilePreview$lambda$0(int i, Composer composer, int i2) {
        BoxAiCitationsModalContentSingleFilePreview(composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    public static final void BoxAiCitationsModal(final Store<BoxAiCitationsReducer.State, BoxAiCitationsReducer.Action> store, final List<FileModel> fileModels, final Function1<? super AiCitationModel, Unit> onCitationClick, Composer composer, final int i) {
        int i2;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        Function2<? super Composer, ? super Integer, Unit> function2;
        Intrinsics.checkNotNullParameter(store, "store");
        Intrinsics.checkNotNullParameter(fileModels, "fileModels");
        Intrinsics.checkNotNullParameter(onCitationClick, "onCitationClick");
        Composer composerStartRestartGroup = composer.startRestartGroup(1763654348);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(BoxAiCitationsModal)N(store,fileModels,onCitationClick)61@2788L29,63@2840L74,70@2988L24,77@3300L10,82@3519L58,83@3584L475,72@3018L1041:BoxAiCitationsModal.kt#odndpa");
        if ((i & 6) == 0) {
            i2 = (composerStartRestartGroup.changed(store) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 48) == 0) {
            i2 |= composerStartRestartGroup.changedInstance(fileModels) ? 32 : 16;
        }
        if ((i & 384) == 0) {
            i2 |= composerStartRestartGroup.changedInstance(onCitationClick) ? 256 : 128;
        }
        if (!composerStartRestartGroup.shouldExecute((i2 & Token.DOTQUERY) != 146, i2 & 1)) {
            composerStartRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1763654348, i2, -1, "com.box.android.boxai.citations.BoxAiCitationsModal (BoxAiCitationsModal.kt:60)");
            }
            final State stateCollectAsStateWithLifecycle = FlowExtKt.collectAsStateWithLifecycle(store.getState(), (LifecycleOwner) null, (Lifecycle.State) null, (CoroutineContext) null, composerStartRestartGroup, 0, 7);
            final SheetState sheetStateRememberModalBottomSheetState = ModalBottomSheetKt.rememberModalBottomSheetState(false, null, composerStartRestartGroup, 6, 2);
            if (!BoxAiCitationsModal$lambda$0(stateCollectAsStateWithLifecycle).getVisible()) {
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup == null) {
                    return;
                } else {
                    function2 = new Function2() { // from class: com.box.android.boxai.citations.BoxAiCitationsModalKt$$ExternalSyntheticLambda12
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return BoxAiCitationsModalKt.BoxAiCitationsModal$lambda$1(store, fileModels, onCitationClick, i, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    };
                }
            } else {
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
                Modifier modifierM1222paddingqDBjuR0$default = PaddingKt.m1222paddingqDBjuR0$default(WindowInsetsPaddingKt.windowInsetsPadding(TestTagKt.testTag(Modifier.INSTANCE, "BoxAi:CitationsSheet"), WindowInsetsKt.m1294onlybOOhFvg(WindowInsets_androidKt.getSystemBars(WindowInsets.INSTANCE, composerStartRestartGroup, 6), WindowInsetsSides.m1311plusgK_yJZ4(WindowInsetsSides.INSTANCE.m1321getHorizontalJoeWqyM(), WindowInsetsSides.INSTANCE.m1325getTopJoeWqyM()))), 0.0f, Dp.m9687constructorimpl(20), 0.0f, 0.0f, 13, null);
                float fM9707getUnspecifiedD9Ej5fM = Dp.INSTANCE.m9707getUnspecifiedD9Ej5fM();
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1640223162, "CC(remember):BoxAiCitationsModal.kt#9igjgp");
                boolean z = (i2 & 14) == 4;
                Object objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                if (z || objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue2 = new Function0() { // from class: com.box.android.boxai.citations.BoxAiCitationsModalKt$$ExternalSyntheticLambda1
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            return BoxAiCitationsModalKt.BoxAiCitationsModal$lambda$2$0(store);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                }
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                BoxModalBottomSheetKt.m11602BoxModalBottomSheet4erKP6g((Function0) objRememberedValue2, modifierM1222paddingqDBjuR0$default, sheetStateRememberModalBottomSheetState, fM9707getUnspecifiedD9Ej5fM, 0L, 0L, 0L, ComposableLambdaKt.rememberComposableLambda(-1830701348, true, new Function3() { // from class: com.box.android.boxai.citations.BoxAiCitationsModalKt$$ExternalSyntheticLambda2
                    @Override // kotlin.jvm.functions.Function3
                    public final Object invoke(Object obj, Object obj2, Object obj3) {
                        return BoxAiCitationsModalKt.BoxAiCitationsModal$lambda$3(fileModels, onCitationClick, sheetStateRememberModalBottomSheetState, coroutineScope, store, stateCollectAsStateWithLifecycle, (ColumnScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                    }
                }, composerStartRestartGroup, 54), composerStartRestartGroup, 12585984, 112);
                composerStartRestartGroup = composerStartRestartGroup;
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
            }
            scopeUpdateScopeEndRestartGroup.updateScope(function2);
        }
        scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            function2 = new Function2() { // from class: com.box.android.boxai.citations.BoxAiCitationsModalKt$$ExternalSyntheticLambda3
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return BoxAiCitationsModalKt.BoxAiCitationsModal$lambda$4(store, fileModels, onCitationClick, i, (Composer) obj, ((Integer) obj2).intValue());
                }
            };
            scopeUpdateScopeEndRestartGroup.updateScope(function2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit BoxAiCitationsModal$lambda$2$0(Store store) {
        store.send(BoxAiCitationsReducer.Action.HideCitations.INSTANCE);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit BoxAiCitationsModal$lambda$3(List list, final Function1 function1, final SheetState sheetState, final CoroutineScope coroutineScope, final Store store, State state, ColumnScope BoxModalBottomSheet, Composer composer, int i) {
        Intrinsics.checkNotNullParameter(BoxModalBottomSheet, "$this$BoxModalBottomSheet");
        ComposerKt.sourceInformation(composer, "C88@3801L23,84@3594L240,90@3887L166,90@3843L210:BoxAiCitationsModal.kt#odndpa");
        if (!composer.shouldExecute((i & 17) != 16, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1830701348, i, -1, "com.box.android.boxai.citations.BoxAiCitationsModal.<anonymous> (BoxAiCitationsModal.kt:84)");
            }
            List<AiCitationModel> citations = BoxAiCitationsModal$lambda$0(state).getCitations();
            boolean citationHighlightEnabled = BoxAiCitationsModal$lambda$0(state).getCitationHighlightEnabled();
            ComposerKt.sourceInformationMarkerStart(composer, 1632602899, "CC(remember):BoxAiCitationsModal.kt#9igjgp");
            boolean zChanged = composer.changed(function1);
            Object objRememberedValue = composer.rememberedValue();
            if (zChanged || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                objRememberedValue = new Function1() { // from class: com.box.android.boxai.citations.BoxAiCitationsModalKt$$ExternalSyntheticLambda10
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return BoxAiCitationsModalKt.BoxAiCitationsModal$lambda$3$0$0(function1, (AiCitationModel) obj);
                    }
                };
                composer.updateRememberedValue(objRememberedValue);
            }
            ComposerKt.sourceInformationMarkerEnd(composer);
            BoxAiCitationsModalContent(list, citations, citationHighlightEnabled, (Function1) objRememberedValue, composer, 0);
            boolean zIsVisible = sheetState.isVisible();
            ComposerKt.sourceInformationMarkerStart(composer, 1632605794, "CC(remember):BoxAiCitationsModal.kt#9igjgp");
            boolean zChangedInstance = composer.changedInstance(coroutineScope) | composer.changed(sheetState) | composer.changed(store);
            Object objRememberedValue2 = composer.rememberedValue();
            if (zChangedInstance || objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                objRememberedValue2 = new Function0() { // from class: com.box.android.boxai.citations.BoxAiCitationsModalKt$$ExternalSyntheticLambda11
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return BoxAiCitationsModalKt.BoxAiCitationsModal$lambda$3$1$0(coroutineScope, sheetState, store);
                    }
                };
                composer.updateRememberedValue(objRememberedValue2);
            }
            ComposerKt.sourceInformationMarkerEnd(composer);
            BackHandlerKt.BackHandler(zIsVisible, (Function0) objRememberedValue2, composer, 0, 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit BoxAiCitationsModal$lambda$3$0$0(Function1 function1, AiCitationModel it) {
        Intrinsics.checkNotNullParameter(it, "it");
        function1.invoke(it);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit BoxAiCitationsModal$lambda$3$1$0(CoroutineScope coroutineScope, SheetState sheetState, Store store) {
        BuildersKt__Builders_commonKt.launch$default(coroutineScope, null, null, new BoxAiCitationsModalKt$BoxAiCitationsModal$3$2$1$1(sheetState, store, null), 3, null);
        return Unit.INSTANCE;
    }

    public static final void BoxAiCitationsModalContent(final List<FileModel> fileModels, final List<AiCitationModel> citations, final boolean z, final Function1<? super AiCitationModel, Unit> onCitationClick, Composer composer, final int i) {
        int i2;
        Composer composer2;
        int i3;
        Intrinsics.checkNotNullParameter(fileModels, "fileModels");
        Intrinsics.checkNotNullParameter(citations, "citations");
        Intrinsics.checkNotNullParameter(onCitationClick, "onCitationClick");
        Composer composerStartRestartGroup = composer.startRestartGroup(1842896900);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(BoxAiCitationsModalContent)N(fileModels,citations,citationHighlightEnabled,onCitationClick)108@4330L1168:BoxAiCitationsModal.kt#odndpa");
        if ((i & 6) == 0) {
            i2 = (composerStartRestartGroup.changedInstance(fileModels) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 48) == 0) {
            i2 |= composerStartRestartGroup.changedInstance(citations) ? 32 : 16;
        }
        if ((i & 384) == 0) {
            i2 |= composerStartRestartGroup.changed(z) ? 256 : 128;
        }
        if ((i & 3072) == 0) {
            i2 |= composerStartRestartGroup.changedInstance(onCitationClick) ? 2048 : 1024;
        }
        if (!composerStartRestartGroup.shouldExecute((i2 & 1171) != 1170, i2 & 1)) {
            composer2 = composerStartRestartGroup;
            composer2.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1842896900, i2, -1, "com.box.android.boxai.citations.BoxAiCitationsModalContent (BoxAiCitationsModal.kt:105)");
            }
            FileModel fileModel = (FileModel) CollectionsKt.singleOrNull((List) fileModels);
            final String name = fileModel != null ? fileModel.getName() : null;
            Modifier modifierM1220paddingVpY3zN4$default = PaddingKt.m1220paddingVpY3zN4$default(Modifier.INSTANCE, Dp.m9687constructorimpl(24), 0.0f, 2, null);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1341605231, "CC(Column)N(modifier,verticalArrangement,horizontalAlignment,content)87@4443L61,88@4509L134:Column.kt#2w3rfo");
            MeasurePolicy measurePolicyColumnMeasurePolicy = ColumnKt.columnMeasurePolicy(Arrangement.INSTANCE.getTop(), Alignment.INSTANCE.getStart(), composerStartRestartGroup, 0);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
            int iHashCode = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
            CompositionLocalMap currentCompositionLocalMap = composerStartRestartGroup.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierM1220paddingVpY3zN4$default);
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
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 143994945, "C110@4421L47,112@4552L6,109@4396L241,123@4987L40,124@5047L445,124@5036L456:BoxAiCitationsModal.kt#odndpa");
            int i4 = i2;
            TextKt.m4494TextNvy7gAk(StringResources_androidKt.stringResource(R.string.box_ai_citations_title, composerStartRestartGroup, 0), PaddingKt.m1220paddingVpY3zN4$default(Modifier.INSTANCE, 0.0f, Dp.m9687constructorimpl(4), 1, null), BoxTheme.INSTANCE.getColors(composerStartRestartGroup, BoxTheme.$stable).m11500getAppPrimary0d7_KjU(), null, 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, BoxTheme.INSTANCE.getTypography().getBoxMedium16(), composerStartRestartGroup, 48, 0, 131064);
            Composer composer3 = composerStartRestartGroup;
            if (name != null) {
                composer3.startReplaceGroup(144259312);
                ComposerKt.sourceInformation(composer3, "117@4717L62,119@4873L6,116@4688L280");
                i3 = 6;
                TextKt.m4494TextNvy7gAk(StringResources_androidKt.stringResource(R.string.box_ai_citations_from, new Object[]{name}, composer3, 0), PaddingKt.m1222paddingqDBjuR0$default(Modifier.INSTANCE, 0.0f, 0.0f, 0.0f, Dp.m9687constructorimpl(16), 7, null), BoxAITheme.INSTANCE.getColors(composer3, 6).m12060getTextSecondary0d7_KjU(), null, 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, BoxTheme.INSTANCE.getTypography().getBoxNormal12(), composer3, 48, 0, 131064);
                composer3 = composer3;
            } else {
                i3 = 6;
                composer3.startReplaceGroup(139599144);
            }
            composer3.endReplaceGroup();
            SpacerKt.Spacer(SizeKt.m1252height3ABfNKs(Modifier.INSTANCE, Dp.m9687constructorimpl(8)), composer3, i3);
            ComposerKt.sourceInformationMarkerStart(composer3, -133882153, "CC(remember):BoxAiCitationsModal.kt#9igjgp");
            boolean zChangedInstance = composer3.changedInstance(citations) | composer3.changed(name) | ((i4 & 896) == 256) | ((i4 & 7168) == 2048);
            Object objRememberedValue = composer3.rememberedValue();
            if (zChangedInstance || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                objRememberedValue = new Function1() { // from class: com.box.android.boxai.citations.BoxAiCitationsModalKt$$ExternalSyntheticLambda8
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return BoxAiCitationsModalKt.BoxAiCitationsModalContent$lambda$0$0$0(citations, name, z, onCitationClick, (LazyListScope) obj);
                    }
                };
                composer3.updateRememberedValue(objRememberedValue);
            }
            ComposerKt.sourceInformationMarkerEnd(composer3);
            composer2 = composer3;
            LazyDslKt.LazyColumn(null, null, null, false, null, null, null, false, null, (Function1) objRememberedValue, composer2, 0, 511);
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
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.box.android.boxai.citations.BoxAiCitationsModalKt$$ExternalSyntheticLambda9
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return BoxAiCitationsModalKt.BoxAiCitationsModalContent$lambda$1(fileModels, citations, z, onCitationClick, i, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:74:0x0450  */
    /* JADX WARN: Code duplicated, block: B:77:0x045c  */
    /* JADX WARN: Code duplicated, block: B:78:0x0460  */
    /* JADX WARN: Code duplicated, block: B:81:0x04c1  */
    /* JADX WARN: Code duplicated, block: B:83:0x04f3  */
    /* JADX WARN: Code duplicated, block: B:84:0x04f5  */
    /* JADX WARN: Code duplicated, block: B:91:0x050f  */
    /* JADX WARN: Code duplicated, block: B:93:0x053b  */
    /* JADX WARN: Code duplicated, block: B:96:0x0572  */
    public static final void BoxAiCitationItem(final int i, final boolean z, final boolean z2, AiCitationModel aiCitationModel, Function1<? super AiCitationModel, Unit> function1, Composer composer, final int i2) {
        int i3;
        int i4;
        int i5;
        String str;
        final long j;
        String str2;
        String str3;
        Function0<ComposeUiNode> constructor;
        boolean z3;
        boolean zChangedInstance;
        Object objRememberedValue;
        final AiCitationModel aiCitationModel2 = aiCitationModel;
        final Function1<? super AiCitationModel, Unit> function2 = function1;
        Composer composerStartRestartGroup = composer.startRestartGroup(-469842549);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(BoxAiCitationItem)N(index,citationHighlightEnabled,showFileName,citation,onClick)148@5730L6,149@5760L2546:BoxAiCitationsModal.kt#odndpa");
        if ((i2 & 6) == 0) {
            i3 = (composerStartRestartGroup.changed(i) ? 4 : 2) | i2;
        } else {
            i3 = i2;
        }
        if ((i2 & 48) == 0) {
            i3 |= composerStartRestartGroup.changed(z) ? 32 : 16;
        }
        if ((i2 & 384) == 0) {
            i3 |= composerStartRestartGroup.changed(z2) ? 256 : 128;
        }
        if ((i2 & 3072) == 0) {
            i3 |= composerStartRestartGroup.changedInstance(aiCitationModel2) ? 2048 : 1024;
        }
        if ((i2 & 24576) == 0) {
            i3 |= composerStartRestartGroup.changedInstance(function2) ? 16384 : 8192;
        }
        if (!composerStartRestartGroup.shouldExecute((i3 & 9363) != 9362, i3 & 1)) {
            composerStartRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-469842549, i3, -1, "com.box.android.boxai.citations.BoxAiCitationItem (BoxAiCitationsModal.kt:147)");
            }
            long jM12053getCitationDecoration0d7_KjU = BoxAITheme.INSTANCE.getColors(composerStartRestartGroup, 6).m12053getCitationDecoration0d7_KjU();
            Modifier modifierM1222paddingqDBjuR0$default = PaddingKt.m1222paddingqDBjuR0$default(Modifier.INSTANCE, 0.0f, 0.0f, 0.0f, Dp.m9687constructorimpl(20), 7, null);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1341605231, "CC(Column)N(modifier,verticalArrangement,horizontalAlignment,content)87@4443L61,88@4509L134:Column.kt#2w3rfo");
            MeasurePolicy measurePolicyColumnMeasurePolicy = ColumnKt.columnMeasurePolicy(Arrangement.INSTANCE.getTop(), Alignment.INSTANCE.getStart(), composerStartRestartGroup, 0);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
            int iHashCode = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
            CompositionLocalMap currentCompositionLocalMap = composerStartRestartGroup.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierM1222paddingqDBjuR0$default);
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
            Composer composerM6062constructorimpl = Updater.m6062constructorimpl(composerStartRestartGroup);
            Updater.m6070setimpl(composerM6062constructorimpl, measurePolicyColumnMeasurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
            Updater.m6070setimpl(composerM6062constructorimpl, currentCompositionLocalMap, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
            Updater.m6066initimpl(composerM6062constructorimpl, Integer.valueOf(iHashCode), ComposeUiNode.INSTANCE.getSetCompositeKeyHash());
            Updater.m6068reconcileimpl(composerM6062constructorimpl, ComposeUiNode.INSTANCE.getApplyOnDeactivatedNodeAssertion());
            Updater.m6070setimpl(composerM6062constructorimpl, modifierMaterializeModifier, ComposeUiNode.INSTANCE.getSetModifier());
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2093002350, "C89@4557L9:Column.kt#2w3rfo");
            ColumnScopeInstance columnScopeInstance = ColumnScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -204956320, "C158@6155L956,183@7120L1180:BoxAiCitationsModal.kt#odndpa");
            if (z2) {
                composerStartRestartGroup.startReplaceGroup(-204992653);
                ComposerKt.sourceInformation(composerStartRestartGroup, "152@5883L64,154@6041L6,151@5854L282");
                i4 = i3;
                i5 = 0;
                j = jM12053getCitationDecoration0d7_KjU;
                str2 = "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh";
                str = "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp";
                TextKt.m4494TextNvy7gAk(StringResources_androidKt.stringResource(R.string.box_ai_citations_from, new Object[]{aiCitationModel2.getDocName()}, composerStartRestartGroup, 0), PaddingKt.m1222paddingqDBjuR0$default(Modifier.INSTANCE, 0.0f, 0.0f, 0.0f, Dp.m9687constructorimpl(16), 7, null), BoxAITheme.INSTANCE.getColors(composerStartRestartGroup, 6).m12060getTextSecondary0d7_KjU(), null, 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, BoxTheme.INSTANCE.getTypography().getBoxNormal12(), composerStartRestartGroup, 48, 0, 131064);
                composerStartRestartGroup = composerStartRestartGroup;
            } else {
                i4 = i3;
                i5 = 0;
                str = "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp";
                j = jM12053getCitationDecoration0d7_KjU;
                str2 = "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh";
                composerStartRestartGroup.startReplaceGroup(-210809555);
            }
            composerStartRestartGroup.endReplaceGroup();
            Modifier modifierHeight = IntrinsicKt.height(Modifier.INSTANCE, IntrinsicSize.Min);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 844473419, "CC(Row)N(modifier,horizontalArrangement,verticalAlignment,content)99@5125L58,100@5188L131:Row.kt#2w3rfo");
            MeasurePolicy measurePolicyRowMeasurePolicy = RowKt.rowMeasurePolicy(Arrangement.INSTANCE.getStart(), Alignment.INSTANCE.getTop(), composerStartRestartGroup, i5);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1159599143, str2);
            int iHashCode2 = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, i5));
            CompositionLocalMap currentCompositionLocalMap2 = composerStartRestartGroup.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier2 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierHeight);
            Function0<ComposeUiNode> constructor3 = ComposeUiNode.INSTANCE.getConstructor();
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -553112988, str);
            if (!(composerStartRestartGroup.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            composerStartRestartGroup.startReusableNode();
            if (composerStartRestartGroup.getInserting()) {
                composerStartRestartGroup.createNode(constructor3);
            } else {
                composerStartRestartGroup.useNode();
            }
            Composer composerM6062constructorimpl2 = Updater.m6062constructorimpl(composerStartRestartGroup);
            Updater.m6070setimpl(composerM6062constructorimpl2, measurePolicyRowMeasurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
            Updater.m6070setimpl(composerM6062constructorimpl2, currentCompositionLocalMap2, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
            Updater.m6066initimpl(composerM6062constructorimpl2, Integer.valueOf(iHashCode2), ComposeUiNode.INSTANCE.getSetCompositeKeyHash());
            Updater.m6068reconcileimpl(composerM6062constructorimpl2, ComposeUiNode.INSTANCE.getApplyOnDeactivatedNodeAssertion());
            Updater.m6070setimpl(composerM6062constructorimpl2, modifierMaterializeModifier2, ComposeUiNode.INSTANCE.getSetModifier());
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1456264949, "C101@5233L9:Row.kt#2w3rfo");
            RowScopeInstance rowScopeInstance = RowScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -685807391, "C162@6357L6,165@6511L195,159@6220L500,175@6884L6,172@6733L187,180@7070L6,177@6933L168:BoxAiCitationsModal.kt#odndpa");
            String strValueOf = String.valueOf(i);
            TextStyle boxNormal12 = BoxTheme.INSTANCE.getTypography().getBoxNormal12();
            long jM11500getAppPrimary0d7_KjU = BoxTheme.INSTANCE.getColors(composerStartRestartGroup, BoxTheme.$stable).m11500getAppPrimary0d7_KjU();
            float f = 4;
            float f2 = 2;
            Modifier modifierM1222paddingqDBjuR0$default2 = PaddingKt.m1222paddingqDBjuR0$default(Modifier.INSTANCE, Dp.m9687constructorimpl(f), Dp.m9687constructorimpl(f2), Dp.m9687constructorimpl(f), 0.0f, 8, null);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1224811796, "CC(remember):BoxAiCitationsModal.kt#9igjgp");
            boolean zChanged = composerStartRestartGroup.changed(j);
            Object objRememberedValue2 = composerStartRestartGroup.rememberedValue();
            if (zChanged) {
                str3 = strValueOf;
            } else {
                str3 = strValueOf;
                if (objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                }
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                Composer composer2 = composerStartRestartGroup;
                TextKt.m4494TextNvy7gAk(str3, DrawModifierKt.drawBehind(modifierM1222paddingqDBjuR0$default2, (Function1) objRememberedValue2), jM11500getAppPrimary0d7_KjU, null, 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, boxNormal12, composer2, 0, 0, 131064);
                DividerKt.m3285VerticalDivider9IZ8Weo(PaddingKt.m1220paddingVpY3zN4$default(Modifier.INSTANCE, Dp.m9687constructorimpl(12), 0.0f, 2, null), Dp.m9687constructorimpl(f2), BoxAITheme.INSTANCE.getColors(composer2, 6).m12063getVerticalDivider0d7_KjU(), composer2, 54, 0);
                TextKt.m4494TextNvy7gAk(aiCitationModel2.getContent(), null, BoxTheme.INSTANCE.getColors(composer2, BoxTheme.$stable).m11500getAppPrimary0d7_KjU(), null, 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, BoxTheme.INSTANCE.getTypography().getBoxNormal14(), composer2, 0, 0, 131066);
                composerStartRestartGroup = composer2;
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                composerStartRestartGroup.endNode();
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                Modifier modifierFillMaxWidth$default = SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null);
                Alignment.Vertical centerVertically = Alignment.INSTANCE.getCenterVertically();
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 844473419, "CC(Row)N(modifier,horizontalArrangement,verticalAlignment,content)99@5125L58,100@5188L131:Row.kt#2w3rfo");
                MeasurePolicy measurePolicyRowMeasurePolicy2 = RowKt.rowMeasurePolicy(Arrangement.INSTANCE.getStart(), centerVertically, composerStartRestartGroup, 48);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1159599143, str2);
                int iHashCode3 = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
                CompositionLocalMap currentCompositionLocalMap3 = composerStartRestartGroup.getCurrentCompositionLocalMap();
                Modifier modifierMaterializeModifier3 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierFillMaxWidth$default);
                constructor = ComposeUiNode.INSTANCE.getConstructor();
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -553112988, str);
                if (!(composerStartRestartGroup.getApplier() instanceof Applier)) {
                    ComposablesKt.invalidApplier();
                }
                composerStartRestartGroup.startReusableNode();
                if (composerStartRestartGroup.getInserting()) {
                    composerStartRestartGroup.createNode(constructor);
                } else {
                    composerStartRestartGroup.useNode();
                }
                Composer composerM6062constructorimpl3 = Updater.m6062constructorimpl(composerStartRestartGroup);
                Updater.m6070setimpl(composerM6062constructorimpl3, measurePolicyRowMeasurePolicy2, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                Updater.m6070setimpl(composerM6062constructorimpl3, currentCompositionLocalMap3, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                Updater.m6066initimpl(composerM6062constructorimpl3, Integer.valueOf(iHashCode3), ComposeUiNode.INSTANCE.getSetCompositeKeyHash());
                Updater.m6068reconcileimpl(composerM6062constructorimpl3, ComposeUiNode.INSTANCE.getApplyOnDeactivatedNodeAssertion());
                Updater.m6070setimpl(composerM6062constructorimpl3, modifierMaterializeModifier3, ComposeUiNode.INSTANCE.getSetModifier());
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1456264949, "C101@5233L9:Row.kt#2w3rfo");
                RowScopeInstance rowScopeInstance2 = RowScopeInstance.INSTANCE;
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1828206113, "C187@7256L38:BoxAiCitationsModal.kt#odndpa");
                SpacerKt.Spacer(RowScope.weight$default(rowScopeInstance2, Modifier.INSTANCE, 1.0f, false, 2, null), composerStartRestartGroup, 0);
                if (z) {
                    composerStartRestartGroup.startReplaceGroup(-1828111409);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "192@7523L21,189@7355L921");
                    Modifier modifierM1252height3ABfNKs = SizeKt.m1252height3ABfNKs(Modifier.INSTANCE, Dp.m9687constructorimpl(26));
                    PaddingValues paddingValuesM1213PaddingValuesYgX7TsA$default = PaddingKt.m1213PaddingValuesYgX7TsA$default(Dp.m9687constructorimpl(f), 0.0f, 2, null);
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1305892849, "CC(remember):BoxAiCitationsModal.kt#9igjgp");
                    if ((i4 & 57344) == 16384) {
                        z3 = true;
                    } else {
                        z3 = false;
                    }
                    aiCitationModel2 = aiCitationModel;
                    zChangedInstance = composerStartRestartGroup.changedInstance(aiCitationModel2) | z3;
                    objRememberedValue = composerStartRestartGroup.rememberedValue();
                    if (!zChangedInstance || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                        function2 = function1;
                        objRememberedValue = new Function0() { // from class: com.box.android.boxai.citations.BoxAiCitationsModalKt$$ExternalSyntheticLambda5
                            @Override // kotlin.jvm.functions.Function0
                            public final Object invoke() {
                                return BoxAiCitationsModalKt.BoxAiCitationItem$lambda$0$1$0$0(function2, aiCitationModel2);
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                    } else {
                        function2 = function1;
                    }
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    ButtonKt.TextButton((Function0<Unit>) objRememberedValue, modifierM1252height3ABfNKs, false, (Shape) null, (ButtonColors) null, (ButtonElevation) null, (BorderStroke) null, paddingValuesM1213PaddingValuesYgX7TsA$default, (MutableInteractionSource) null, (Function3<? super RowScope, ? super Composer, ? super Integer, Unit>) ComposableSingletons$BoxAiCitationsModalKt.INSTANCE.getLambda$773947138$boxai_generalProdRelease(), composerStartRestartGroup, 817889328, 380);
                    composerStartRestartGroup = composerStartRestartGroup;
                } else {
                    aiCitationModel2 = aiCitationModel;
                    function2 = function1;
                    composerStartRestartGroup.startReplaceGroup(-1835437112);
                }
                composerStartRestartGroup.endReplaceGroup();
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
            objRememberedValue2 = new Function1() { // from class: com.box.android.boxai.citations.BoxAiCitationsModalKt$$ExternalSyntheticLambda4
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    return BoxAiCitationsModalKt.BoxAiCitationItem$lambda$0$0$0$0(j, (DrawScope) obj);
                }
            };
            composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            Composer composer3 = composerStartRestartGroup;
            TextKt.m4494TextNvy7gAk(str3, DrawModifierKt.drawBehind(modifierM1222paddingqDBjuR0$default2, (Function1) objRememberedValue2), jM11500getAppPrimary0d7_KjU, null, 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, boxNormal12, composer3, 0, 0, 131064);
            DividerKt.m3285VerticalDivider9IZ8Weo(PaddingKt.m1220paddingVpY3zN4$default(Modifier.INSTANCE, Dp.m9687constructorimpl(12), 0.0f, 2, null), Dp.m9687constructorimpl(f2), BoxAITheme.INSTANCE.getColors(composer3, 6).m12063getVerticalDivider0d7_KjU(), composer3, 54, 0);
            TextKt.m4494TextNvy7gAk(aiCitationModel2.getContent(), null, BoxTheme.INSTANCE.getColors(composer3, BoxTheme.$stable).m11500getAppPrimary0d7_KjU(), null, 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, BoxTheme.INSTANCE.getTypography().getBoxNormal14(), composer3, 0, 0, 131066);
            composerStartRestartGroup = composer3;
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            composerStartRestartGroup.endNode();
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            Modifier modifierFillMaxWidth$default2 = SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null);
            Alignment.Vertical centerVertically2 = Alignment.INSTANCE.getCenterVertically();
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 844473419, "CC(Row)N(modifier,horizontalArrangement,verticalAlignment,content)99@5125L58,100@5188L131:Row.kt#2w3rfo");
            MeasurePolicy measurePolicyRowMeasurePolicy3 = RowKt.rowMeasurePolicy(Arrangement.INSTANCE.getStart(), centerVertically2, composerStartRestartGroup, 48);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1159599143, str2);
            int iHashCode4 = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
            CompositionLocalMap currentCompositionLocalMap4 = composerStartRestartGroup.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier4 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierFillMaxWidth$default2);
            constructor = ComposeUiNode.INSTANCE.getConstructor();
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -553112988, str);
            if (!(composerStartRestartGroup.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            composerStartRestartGroup.startReusableNode();
            if (composerStartRestartGroup.getInserting()) {
                composerStartRestartGroup.createNode(constructor);
            } else {
                composerStartRestartGroup.useNode();
            }
            Composer composerM6062constructorimpl4 = Updater.m6062constructorimpl(composerStartRestartGroup);
            Updater.m6070setimpl(composerM6062constructorimpl4, measurePolicyRowMeasurePolicy3, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
            Updater.m6070setimpl(composerM6062constructorimpl4, currentCompositionLocalMap4, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
            Updater.m6066initimpl(composerM6062constructorimpl4, Integer.valueOf(iHashCode4), ComposeUiNode.INSTANCE.getSetCompositeKeyHash());
            Updater.m6068reconcileimpl(composerM6062constructorimpl4, ComposeUiNode.INSTANCE.getApplyOnDeactivatedNodeAssertion());
            Updater.m6070setimpl(composerM6062constructorimpl4, modifierMaterializeModifier4, ComposeUiNode.INSTANCE.getSetModifier());
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1456264949, "C101@5233L9:Row.kt#2w3rfo");
            RowScopeInstance rowScopeInstance3 = RowScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1828206113, "C187@7256L38:BoxAiCitationsModal.kt#odndpa");
            SpacerKt.Spacer(RowScope.weight$default(rowScopeInstance3, Modifier.INSTANCE, 1.0f, false, 2, null), composerStartRestartGroup, 0);
            if (z) {
                composerStartRestartGroup.startReplaceGroup(-1828111409);
                ComposerKt.sourceInformation(composerStartRestartGroup, "192@7523L21,189@7355L921");
                Modifier modifierM1252height3ABfNKs2 = SizeKt.m1252height3ABfNKs(Modifier.INSTANCE, Dp.m9687constructorimpl(26));
                PaddingValues paddingValuesM1213PaddingValuesYgX7TsA$default2 = PaddingKt.m1213PaddingValuesYgX7TsA$default(Dp.m9687constructorimpl(f), 0.0f, 2, null);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1305892849, "CC(remember):BoxAiCitationsModal.kt#9igjgp");
                if ((i4 & 57344) == 16384) {
                    z3 = true;
                } else {
                    z3 = false;
                }
                aiCitationModel2 = aiCitationModel;
                zChangedInstance = composerStartRestartGroup.changedInstance(aiCitationModel2) | z3;
                objRememberedValue = composerStartRestartGroup.rememberedValue();
                if (zChangedInstance) {
                    function2 = function1;
                    objRememberedValue = new Function0() { // from class: com.box.android.boxai.citations.BoxAiCitationsModalKt$$ExternalSyntheticLambda5
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            return BoxAiCitationsModalKt.BoxAiCitationItem$lambda$0$1$0$0(function2, aiCitationModel2);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                } else {
                    function2 = function1;
                    objRememberedValue = new Function0() { // from class: com.box.android.boxai.citations.BoxAiCitationsModalKt$$ExternalSyntheticLambda5
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            return BoxAiCitationsModalKt.BoxAiCitationItem$lambda$0$1$0$0(function2, aiCitationModel2);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                }
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ButtonKt.TextButton((Function0<Unit>) objRememberedValue, modifierM1252height3ABfNKs2, false, (Shape) null, (ButtonColors) null, (ButtonElevation) null, (BorderStroke) null, paddingValuesM1213PaddingValuesYgX7TsA$default2, (MutableInteractionSource) null, (Function3<? super RowScope, ? super Composer, ? super Integer, Unit>) ComposableSingletons$BoxAiCitationsModalKt.INSTANCE.getLambda$773947138$boxai_generalProdRelease(), composerStartRestartGroup, 817889328, 380);
                composerStartRestartGroup = composerStartRestartGroup;
            } else {
                aiCitationModel2 = aiCitationModel;
                function2 = function1;
                composerStartRestartGroup.startReplaceGroup(-1835437112);
            }
            composerStartRestartGroup.endReplaceGroup();
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
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.box.android.boxai.citations.BoxAiCitationsModalKt$$ExternalSyntheticLambda6
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return BoxAiCitationsModalKt.BoxAiCitationItem$lambda$1(i, z, z2, aiCitationModel2, function2, i2, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit BoxAiCitationItem$lambda$0$0$0$0(long j, DrawScope drawBehind) {
        Intrinsics.checkNotNullParameter(drawBehind, "$this$drawBehind");
        DrawScope.m7376drawCircleVaOC9Bg$default(drawBehind, j, Size.m6637getMinDimensionimpl(drawBehind.mo7395getSizeNHjbRc()) + 6.0f, 0L, 0.0f, null, null, 0, 124, null);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit BoxAiCitationItem$lambda$0$1$0$0(Function1 function1, AiCitationModel aiCitationModel) {
        function1.invoke(aiCitationModel);
        return Unit.INSTANCE;
    }

    private static final void BoxAiCitationsModalContentSingleFilePreview(Composer composer, final int i) {
        Composer composerStartRestartGroup = composer.startRestartGroup(1570960333);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(BoxAiCitationsModalContentSingleFilePreview)220@8484L664:BoxAiCitationsModal.kt#odndpa");
        if (!composerStartRestartGroup.shouldExecute(i != 0, i & 1)) {
            composerStartRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1570960333, i, -1, "com.box.android.boxai.citations.BoxAiCitationsModalContentSingleFilePreview (BoxAiCitationsModal.kt:219)");
            }
            BoxThemeKt.BoxTheme(ComposableSingletons$BoxAiCitationsModalKt.INSTANCE.m11951getLambda$1027768360$boxai_generalProdRelease(), composerStartRestartGroup, 6);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.box.android.boxai.citations.BoxAiCitationsModalKt$$ExternalSyntheticLambda7
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return BoxAiCitationsModalKt.BoxAiCitationsModalContentSingleFilePreview$lambda$0(i, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    private static final void BoxAiCitationsModalContentMultipleFilesPreview(Composer composer, final int i) {
        Composer composerStartRestartGroup = composer.startRestartGroup(-281444720);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(BoxAiCitationsModalContentMultipleFilesPreview)240@9276L844:BoxAiCitationsModal.kt#odndpa");
        if (!composerStartRestartGroup.shouldExecute(i != 0, i & 1)) {
            composerStartRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-281444720, i, -1, "com.box.android.boxai.citations.BoxAiCitationsModalContentMultipleFilesPreview (BoxAiCitationsModal.kt:239)");
            }
            BoxThemeKt.BoxTheme(ComposableSingletons$BoxAiCitationsModalKt.INSTANCE.getLambda$2072539813$boxai_generalProdRelease(), composerStartRestartGroup, 6);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.box.android.boxai.citations.BoxAiCitationsModalKt$$ExternalSyntheticLambda0
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return BoxAiCitationsModalKt.BoxAiCitationsModalContentMultipleFilesPreview$lambda$0(i, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    private static final BoxAiCitationsReducer.State BoxAiCitationsModal$lambda$0(State<BoxAiCitationsReducer.State> state) {
        return state.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit BoxAiCitationsModalContent$lambda$0$0$0(final List list, final String str, final boolean z, final Function1 function1, LazyListScope LazyColumn) {
        Intrinsics.checkNotNullParameter(LazyColumn, "$this$LazyColumn");
        LazyColumn.items(list.size(), null, new Function1<Integer, Object>() { // from class: com.box.android.boxai.citations.BoxAiCitationsModalKt$BoxAiCitationsModalContent$lambda$0$0$0$$inlined$itemsIndexed$default$2
            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Object invoke(Integer num) {
                return invoke(num.intValue());
            }

            public final Object invoke(int i) {
                list.get(i);
                return null;
            }
        }, ComposableLambdaKt.composableLambdaInstance(2039820996, true, new Function4<LazyItemScope, Integer, Composer, Integer, Unit>() { // from class: com.box.android.boxai.citations.BoxAiCitationsModalKt$BoxAiCitationsModalContent$lambda$0$0$0$$inlined$itemsIndexed$default$3
            @Override // kotlin.jvm.functions.Function4
            public /* bridge */ /* synthetic */ Unit invoke(LazyItemScope lazyItemScope, Integer num, Composer composer, Integer num2) {
                invoke(lazyItemScope, num.intValue(), composer, num2.intValue());
                return Unit.INSTANCE;
            }

            public final void invoke(LazyItemScope lazyItemScope, int i, Composer composer, int i2) {
                int i3;
                ComposerKt.sourceInformation(composer, "CN(it)214@10668L26:LazyDsl.kt#428nma");
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
                    ComposerKt.traceEventStart(2039820996, i3, -1, "androidx.compose.foundation.lazy.itemsIndexed.<anonymous> (LazyDsl.kt:214)");
                }
                AiCitationModel aiCitationModel = (AiCitationModel) list.get(i);
                composer.startReplaceGroup(737299392);
                ComposerKt.sourceInformation(composer, "CN(index,citation)*131@5383L67,126@5122L346:BoxAiCitationsModal.kt#odndpa");
                int i4 = i + 1;
                boolean z2 = str == null;
                boolean z3 = z;
                ComposerKt.sourceInformationMarkerStart(composer, -253302740, "CC(remember):BoxAiCitationsModal.kt#9igjgp");
                boolean zChanged = composer.changed(function1);
                Object objRememberedValue = composer.rememberedValue();
                if (zChanged || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                    final Function1 function2 = function1;
                    objRememberedValue = (Function1) new Function1<AiCitationModel, Unit>() { // from class: com.box.android.boxai.citations.BoxAiCitationsModalKt$BoxAiCitationsModalContent$1$1$1$1$1$1
                        @Override // kotlin.jvm.functions.Function1
                        public /* bridge */ /* synthetic */ Unit invoke(AiCitationModel aiCitationModel2) {
                            invoke2(aiCitationModel2);
                            return Unit.INSTANCE;
                        }

                        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                        public final void invoke2(AiCitationModel it) {
                            Intrinsics.checkNotNullParameter(it, "it");
                            function2.invoke(it);
                        }
                    };
                    composer.updateRememberedValue(objRememberedValue);
                }
                ComposerKt.sourceInformationMarkerEnd(composer);
                BoxAiCitationsModalKt.BoxAiCitationItem(i4, z3, z2, aiCitationModel, (Function1) objRememberedValue, composer, 0);
                composer.endReplaceGroup();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
            }
        }));
        return Unit.INSTANCE;
    }
}
