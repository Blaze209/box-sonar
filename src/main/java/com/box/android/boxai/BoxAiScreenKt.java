package com.box.android.boxai;

import android.os.Build;
import androidx.compose.animation.core.EasingFunctionsKt;
import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.BorderStroke;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.ColumnKt;
import androidx.compose.foundation.layout.ColumnScope;
import androidx.compose.foundation.layout.ColumnScopeInstance;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.foundation.layout.RowScope;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.layout.SpacerKt;
import androidx.compose.foundation.layout.WindowInsets;
import androidx.compose.foundation.layout.WindowInsetsKt;
import androidx.compose.foundation.layout.WindowInsetsPaddingKt;
import androidx.compose.foundation.layout.WindowInsetsSides;
import androidx.compose.foundation.layout.WindowInsets_androidKt;
import androidx.compose.foundation.shape.RoundedCornerShapeKt;
import androidx.compose.material3.ButtonDefaults;
import androidx.compose.material3.ButtonElevation;
import androidx.compose.material3.ButtonKt;
import androidx.compose.material3.ModalBottomSheetKt;
import androidx.compose.material3.SheetState;
import androidx.compose.material3.SheetValue;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.MutableFloatState;
import androidx.compose.runtime.PrimitiveSnapshotStateKt;
import androidx.compose.runtime.ProvidableCompositionLocal;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.State;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.layout.LayoutCoordinates;
import androidx.compose.ui.layout.LayoutCoordinatesKt;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.layout.OnGloballyPositionedModifierKt;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.platform.TestTagKt;
import androidx.compose.ui.platform.WindowInfo;
import androidx.compose.ui.res.StringResources_androidKt;
import androidx.compose.ui.unit.Dp;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.compose.FlowExtKt;
import com.box.android.base.compose.BoxModalBottomSheetKt;
import com.box.android.base.compose.BoxSizes;
import com.box.android.base.compose.BoxTheme;
import com.box.android.base.compose.BoxThemeKt;
import com.box.android.base.compose.ComposePreviewMocks;
import com.box.android.base.compose.ComposePreviewUtilsKt;
import com.box.android.base.compose.ComposeUtilsKt;
import com.box.android.base.compose.ItemStateScreensKt;
import com.box.android.base.compose.ItemsStateConfig;
import com.box.android.base.compose.button.model.ButtonItem;
import com.box.android.base.compose.dialog.BoxAlertDialogKt;
import com.box.android.boxai.agents.BoxAiAgentsReducer;
import com.box.android.boxai.clearchat.BoxAiClearChatReducer;
import com.box.android.boxai.prompt.BoxAiPromptInputBoxKt;
import com.box.android.boxai.qa.BoxAiQaReducer;
import com.box.android.boxai.qa.BoxAiQaScreenKt;
import com.box.android.boxai.ui.BoxAITheme;
import com.box.android.boxai.ui.BoxAiProgressBarKt;
import com.box.android.boxai.ui.BoxAiTopBarKt;
import com.box.android.cpl.Store;
import com.box.android.cpl.StoreKt;
import com.box.android.cpl.Wrapped;
import com.box.android.domain.models.boxai.AiAgentModel;
import com.box.android.domain.models.item.FileModel;
import dev.chrisbanes.haze.HazeChildKt;
import dev.chrisbanes.haze.HazeDefaults;
import dev.chrisbanes.haze.HazeEffectScope;
import dev.chrisbanes.haze.HazeProgressive;
import dev.chrisbanes.haze.HazeState;
import dev.chrisbanes.haze.HazeStyle;
import dev.chrisbanes.haze.HazeTint;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;
import kotlin.reflect.KFunction;
import kotlin.reflect.jvm.KClassesJvm;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: compiled from: BoxAiScreen.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u00000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0012\u001a!\u0010\u0000\u001a\u00020\u00012\u0012\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003H\u0007¢\u0006\u0002\u0010\u0006\u001aU\u0010\u0007\u001a\u00020\u00012\u0012\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u00032\u0006\u0010\b\u001a\u00020\u00042\b\u0010\t\u001a\u0004\u0018\u00010\n2\u0012\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u00010\f2\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00010\u000fH\u0003¢\u0006\u0002\u0010\u0010\u001a\r\u0010\u0011\u001a\u00020\u0001H\u0007¢\u0006\u0002\u0010\u0012\u001a\u001b\u0010\u0013\u001a\u00020\u00012\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00010\u000fH\u0007¢\u0006\u0002\u0010\u0015\u001a\r\u0010\u0016\u001a\u00020\u0001H\u0007¢\u0006\u0002\u0010\u0012\u001a)\u0010\u0017\u001a\u00020\u00012\f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00010\u000f2\f\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00010\u000fH\u0007¢\u0006\u0002\u0010\u001a\u001a\r\u0010\u001b\u001a\u00020\u0001H\u0003¢\u0006\u0002\u0010\u0012\u001a\r\u0010\u001c\u001a\u00020\u0001H\u0003¢\u0006\u0002\u0010\u0012\u001a\r\u0010\u001d\u001a\u00020\u0001H\u0003¢\u0006\u0002\u0010\u0012\u001a\r\u0010\u001e\u001a\u00020\u0001H\u0003¢\u0006\u0002\u0010\u0012\u001a\r\u0010\u001f\u001a\u00020\u0001H\u0003¢\u0006\u0002\u0010\u0012¨\u0006 ²\u0006\n\u0010\b\u001a\u00020\u0004X\u008a\u0084\u0002²\u0006\n\u0010!\u001a\u00020\rX\u008a\u008e\u0002"}, d2 = {"BoxAiBottomSheet", "", "store", "Lcom/box/android/cpl/Store;", "Lcom/box/android/boxai/BoxAiReducer$State;", "Lcom/box/android/boxai/BoxAiReducer$Action;", "(Lcom/box/android/cpl/Store;Landroidx/compose/runtime/Composer;I)V", "BoxAiBottomSheetContent", "state", "hazeState", "Ldev/chrisbanes/haze/HazeState;", "onTopBarPositionUpdate", "Lkotlin/Function1;", "", "onCloseClicked", "Lkotlin/Function0;", "(Lcom/box/android/cpl/Store;Lcom/box/android/boxai/BoxAiReducer$State;Ldev/chrisbanes/haze/HazeState;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function0;Landroidx/compose/runtime/Composer;I)V", "BoxAiLoadingScreen", "(Landroidx/compose/runtime/Composer;I)V", "BoxAiDocumentContentTooLarge", "resolveDocumentContentTooLarge", "(Lkotlin/jvm/functions/Function0;Landroidx/compose/runtime/Composer;I)V", "BoxAiErrorScreen", "UpdateToUseBoxAiAlert", "onClickPositiveButton", "onClickNegativeButton", "(Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;Landroidx/compose/runtime/Composer;I)V", "BoxAiBottomSheetContentQaPreview", "BoxAiLoadingScreenPreview", "BoxAiErrorScreenPreview", "BoxAiDocumentContentTooLargePreview", "UpdateToUseBoxAiAlertPreview", "boxai_generalProdRelease", "topBarPosition"}, k = 2, mv = {2, 2, 0}, xi = 48)
public final class BoxAiScreenKt {
    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit BoxAiBottomSheet$lambda$12(Store store, int i, Composer composer, int i2) {
        BoxAiBottomSheet(store, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit BoxAiBottomSheet$lambda$8(Store store, int i, Composer composer, int i2) {
        BoxAiBottomSheet(store, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit BoxAiBottomSheet$lambda$9(Store store, int i, Composer composer, int i2) {
        BoxAiBottomSheet(store, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit BoxAiBottomSheetContent$lambda$1(Store store, BoxAiReducer.State state, HazeState hazeState, Function1 function1, Function0 function0, int i, Composer composer, int i2) {
        BoxAiBottomSheetContent(store, state, hazeState, function1, function0, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit BoxAiBottomSheetContentQaPreview$lambda$1(int i, Composer composer, int i2) {
        BoxAiBottomSheetContentQaPreview(composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit BoxAiDocumentContentTooLarge$lambda$1(Function0 function0, int i, Composer composer, int i2) {
        BoxAiDocumentContentTooLarge(function0, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit BoxAiDocumentContentTooLargePreview$lambda$0(int i, Composer composer, int i2) {
        BoxAiDocumentContentTooLargePreview(composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit BoxAiErrorScreen$lambda$1(int i, Composer composer, int i2) {
        BoxAiErrorScreen(composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit BoxAiErrorScreenPreview$lambda$0(int i, Composer composer, int i2) {
        BoxAiErrorScreenPreview(composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit BoxAiLoadingScreen$lambda$1(int i, Composer composer, int i2) {
        BoxAiLoadingScreen(composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit BoxAiLoadingScreenPreview$lambda$0(int i, Composer composer, int i2) {
        BoxAiLoadingScreenPreview(composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit UpdateToUseBoxAiAlert$lambda$0(Function0 function0, Function0 function1, int i, Composer composer, int i2) {
        UpdateToUseBoxAiAlert(function0, function1, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit UpdateToUseBoxAiAlertPreview$lambda$0(int i, Composer composer, int i2) {
        UpdateToUseBoxAiAlertPreview(composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    public static final void BoxAiBottomSheet(final Store<BoxAiReducer.State, BoxAiReducer.Action> store, Composer composer, final int i) {
        int i2;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        Function2<? super Composer, ? super Integer, Unit> function2;
        Intrinsics.checkNotNullParameter(store, "store");
        Composer composerStartRestartGroup = composer.startRestartGroup(-568144813);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(BoxAiBottomSheet)N(store)79@3686L29,80@3747L55,80@3736L66,84@3830L48,89@4107L7,92@4262L166,90@4164L270,97@4460L24,115@4934L150,115@4900L184,131@5426L14,132@5481L10,138@5730L374,127@5197L907:BoxAiScreen.kt#6z2y90");
        if ((i & 6) == 0) {
            i2 = (composerStartRestartGroup.changed(store) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if (!composerStartRestartGroup.shouldExecute((i2 & 3) != 2, i2 & 1)) {
            composerStartRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-568144813, i2, -1, "com.box.android.boxai.BoxAiBottomSheet (BoxAiScreen.kt:78)");
            }
            final State stateCollectAsStateWithLifecycle = FlowExtKt.collectAsStateWithLifecycle(store.getState(), (LifecycleOwner) null, (Lifecycle.State) null, (CoroutineContext) null, composerStartRestartGroup, 0, 7);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -526313270, "CC(remember):BoxAiScreen.kt#9igjgp");
            int i3 = i2 & 14;
            boolean z = i3 == 4;
            Object objRememberedValue = composerStartRestartGroup.rememberedValue();
            if (z || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                objRememberedValue = new Function0() { // from class: com.box.android.boxai.BoxAiScreenKt$$ExternalSyntheticLambda8
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return BoxAiScreenKt.BoxAiBottomSheet$lambda$1$0(store);
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
            }
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            final Function0 function0Remembered = ComposeUtilsKt.remembered((Function0) objRememberedValue, composerStartRestartGroup, 0);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -526310621, "CC(remember):BoxAiScreen.kt#9igjgp");
            Object objRememberedValue2 = composerStartRestartGroup.rememberedValue();
            if (objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                objRememberedValue2 = PrimitiveSnapshotStateKt.mutableFloatStateOf(0.0f);
                composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
            }
            final MutableFloatState mutableFloatState = (MutableFloatState) objRememberedValue2;
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ProvidableCompositionLocal<WindowInfo> localWindowInfo = CompositionLocalsKt.getLocalWindowInfo();
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
            Object objConsume = composerStartRestartGroup.consume(localWindowInfo);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            final float fMo8777getContainerSizeYbymL2g = ((int) (((WindowInfo) objConsume).mo8777getContainerSizeYbymL2g() & 4294967295L)) * 0.4f;
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -526296679, "CC(remember):BoxAiScreen.kt#9igjgp");
            boolean zChanged = composerStartRestartGroup.changed(fMo8777getContainerSizeYbymL2g);
            Object objRememberedValue3 = composerStartRestartGroup.rememberedValue();
            if (zChanged || objRememberedValue3 == Composer.INSTANCE.getEmpty()) {
                objRememberedValue3 = new Function1() { // from class: com.box.android.boxai.BoxAiScreenKt$$ExternalSyntheticLambda9
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return Boolean.valueOf(BoxAiScreenKt.BoxAiBottomSheet$lambda$5$0(fMo8777getContainerSizeYbymL2g, mutableFloatState, (SheetValue) obj));
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
            }
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            final SheetState sheetStateRememberModalBottomSheetState = ModalBottomSheetKt.rememberModalBottomSheetState(true, (Function1) objRememberedValue3, composerStartRestartGroup, 6, 0);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 773894976, "CC(rememberCoroutineScope)N(getContext)600@27430L68:Effects.kt#9igjgp");
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 683736516, "CC(remember):Effects.kt#9igjgp");
            Object objRememberedValue4 = composerStartRestartGroup.rememberedValue();
            if (objRememberedValue4 == Composer.INSTANCE.getEmpty()) {
                objRememberedValue4 = EffectsKt.createCompositionCoroutineScope(EmptyCoroutineContext.INSTANCE, composerStartRestartGroup);
                composerStartRestartGroup.updateRememberedValue(objRememberedValue4);
            }
            final CoroutineScope coroutineScope = (CoroutineScope) objRememberedValue4;
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            if (BoxAiBottomSheet$lambda$0(stateCollectAsStateWithLifecycle).getNeedToShowUpdateAppAlert()) {
                composerStartRestartGroup.startReplaceGroup(864938613);
                ComposerKt.sourceInformation(composerStartRestartGroup, "101@4595L86,104@4719L90,100@4536L283");
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -526286103, "CC(remember):BoxAiScreen.kt#9igjgp");
                boolean z2 = i3 == 4;
                Object objRememberedValue5 = composerStartRestartGroup.rememberedValue();
                if (z2 || objRememberedValue5 == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue5 = new Function0() { // from class: com.box.android.boxai.BoxAiScreenKt$$ExternalSyntheticLambda10
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            return BoxAiScreenKt.BoxAiBottomSheet$lambda$6$0(store);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue5);
                }
                Function0 function0 = (Function0) objRememberedValue5;
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -526282131, "CC(remember):BoxAiScreen.kt#9igjgp");
                boolean z3 = i3 == 4;
                Object objRememberedValue6 = composerStartRestartGroup.rememberedValue();
                if (z3 || objRememberedValue6 == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue6 = new Function0() { // from class: com.box.android.boxai.BoxAiScreenKt$$ExternalSyntheticLambda12
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            return BoxAiScreenKt.BoxAiBottomSheet$lambda$7$0(store);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue6);
                }
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                UpdateToUseBoxAiAlert(function0, (Function0) objRememberedValue6, composerStartRestartGroup, 0);
                composerStartRestartGroup.endReplaceGroup();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup == null) {
                    return;
                } else {
                    function2 = new Function2() { // from class: com.box.android.boxai.BoxAiScreenKt$$ExternalSyntheticLambda13
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return BoxAiScreenKt.BoxAiBottomSheet$lambda$8(store, i, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    };
                }
            } else {
                composerStartRestartGroup.startReplaceGroup(860438095);
                composerStartRestartGroup.endReplaceGroup();
                if (BoxAiBottomSheet$lambda$0(stateCollectAsStateWithLifecycle).getShouldBeShown()) {
                    BoxAiReducer.ScreenState screenState = BoxAiBottomSheet$lambda$0(stateCollectAsStateWithLifecycle).getScreenState();
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -526275191, "CC(remember):BoxAiScreen.kt#9igjgp");
                    boolean zChanged2 = (i3 == 4) | composerStartRestartGroup.changed(stateCollectAsStateWithLifecycle);
                    BoxAiScreenKt$BoxAiBottomSheet$5$1 boxAiScreenKt$BoxAiBottomSheet$5$1RememberedValue = composerStartRestartGroup.rememberedValue();
                    if (zChanged2 || boxAiScreenKt$BoxAiBottomSheet$5$1RememberedValue == Composer.INSTANCE.getEmpty()) {
                        boxAiScreenKt$BoxAiBottomSheet$5$1RememberedValue = new BoxAiScreenKt$BoxAiBottomSheet$5$1(store, stateCollectAsStateWithLifecycle, null);
                        composerStartRestartGroup.updateRememberedValue(boxAiScreenKt$BoxAiBottomSheet$5$1RememberedValue);
                    }
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    EffectsKt.LaunchedEffect(screenState, (Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object>) boxAiScreenKt$BoxAiBottomSheet$5$1RememberedValue, composerStartRestartGroup, 0);
                    final HazeState hazeState = HazeDefaults.INSTANCE.blurEnabled() ? new HazeState() : null;
                    BoxModalBottomSheetKt.m11602BoxModalBottomSheet4erKP6g(function0Remembered, TestTagKt.testTag(WindowInsetsPaddingKt.windowInsetsPadding(Modifier.INSTANCE, WindowInsetsKt.m1294onlybOOhFvg(WindowInsetsKt.union(WindowInsets_androidKt.getNavigationBars(WindowInsets.INSTANCE, composerStartRestartGroup, 6), WindowInsets_androidKt.getStatusBars(WindowInsets.INSTANCE, composerStartRestartGroup, 6)), WindowInsetsSides.m1311plusgK_yJZ4(WindowInsetsSides.INSTANCE.m1321getHorizontalJoeWqyM(), WindowInsetsSides.INSTANCE.m1325getTopJoeWqyM()))), "NativeAiScreen"), sheetStateRememberModalBottomSheetState, Dp.INSTANCE.m9707getUnspecifiedD9Ej5fM(), 0L, 0L, 0L, ComposableLambdaKt.rememberComposableLambda(2025459811, true, new Function3() { // from class: com.box.android.boxai.BoxAiScreenKt$$ExternalSyntheticLambda15
                        @Override // kotlin.jvm.functions.Function3
                        public final Object invoke(Object obj, Object obj2, Object obj3) {
                            return BoxAiScreenKt.BoxAiBottomSheet$lambda$11(store, hazeState, coroutineScope, sheetStateRememberModalBottomSheetState, function0Remembered, stateCollectAsStateWithLifecycle, mutableFloatState, (ColumnScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                        }
                    }, composerStartRestartGroup, 54), composerStartRestartGroup, 12585984, 112);
                    composerStartRestartGroup = composerStartRestartGroup;
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
                        function2 = new Function2() { // from class: com.box.android.boxai.BoxAiScreenKt$$ExternalSyntheticLambda14
                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj, Object obj2) {
                                return BoxAiScreenKt.BoxAiBottomSheet$lambda$9(store, i, (Composer) obj, ((Integer) obj2).intValue());
                            }
                        };
                    }
                }
            }
            scopeUpdateScopeEndRestartGroup.updateScope(function2);
        }
        scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            function2 = new Function2() { // from class: com.box.android.boxai.BoxAiScreenKt$$ExternalSyntheticLambda16
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return BoxAiScreenKt.BoxAiBottomSheet$lambda$12(store, i, (Composer) obj, ((Integer) obj2).intValue());
                }
            };
            scopeUpdateScopeEndRestartGroup.updateScope(function2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit BoxAiBottomSheet$lambda$1$0(Store store) {
        store.send(BoxAiReducer.Action.Dismiss.INSTANCE);
        return Unit.INSTANCE;
    }

    private static final float BoxAiBottomSheet$lambda$3(MutableFloatState mutableFloatState) {
        return mutableFloatState.getFloatValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean BoxAiBottomSheet$lambda$5$0(float f, MutableFloatState mutableFloatState, SheetValue it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return (BoxAiBottomSheet$lambda$3(mutableFloatState) > f && it == SheetValue.Hidden) || it != SheetValue.Hidden;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit BoxAiBottomSheet$lambda$6$0(Store store) {
        store.send(BoxAiReducer.Action.UpdateAppAlertAccepted.INSTANCE);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit BoxAiBottomSheet$lambda$7$0(Store store) {
        store.send(BoxAiReducer.Action.UpdateAppAlertAcknowledged.INSTANCE);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit BoxAiBottomSheet$lambda$11(Store store, HazeState hazeState, final CoroutineScope coroutineScope, final SheetState sheetState, final Function0 function0, State state, final MutableFloatState mutableFloatState, ColumnScope BoxModalBottomSheet, Composer composer, int i) {
        Intrinsics.checkNotNullParameter(BoxModalBottomSheet, "$this$BoxModalBottomSheet");
        ComposerKt.sourceInformation(composer, "C143@5891L23,144@5945L143,139@5740L358:BoxAiScreen.kt#6z2y90");
        if (!composer.shouldExecute((i & 17) != 16, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(2025459811, i, -1, "com.box.android.boxai.BoxAiBottomSheet.<anonymous> (BoxAiScreen.kt:139)");
            }
            BoxAiReducer.State stateBoxAiBottomSheet$lambda$0 = BoxAiBottomSheet$lambda$0(state);
            ComposerKt.sourceInformationMarkerStart(composer, 846698458, "CC(remember):BoxAiScreen.kt#9igjgp");
            Object objRememberedValue = composer.rememberedValue();
            if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                objRememberedValue = new Function1() { // from class: com.box.android.boxai.BoxAiScreenKt$$ExternalSyntheticLambda26
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return BoxAiScreenKt.BoxAiBottomSheet$lambda$11$0$0(mutableFloatState, ((Float) obj).floatValue());
                    }
                };
                composer.updateRememberedValue(objRememberedValue);
            }
            Function1 function1 = (Function1) objRememberedValue;
            ComposerKt.sourceInformationMarkerEnd(composer);
            ComposerKt.sourceInformationMarkerStart(composer, 846700306, "CC(remember):BoxAiScreen.kt#9igjgp");
            boolean zChangedInstance = composer.changedInstance(coroutineScope) | composer.changed(sheetState) | composer.changed(function0);
            Object objRememberedValue2 = composer.rememberedValue();
            if (zChangedInstance || objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                objRememberedValue2 = new Function0() { // from class: com.box.android.boxai.BoxAiScreenKt$$ExternalSyntheticLambda27
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return BoxAiScreenKt.BoxAiBottomSheet$lambda$11$1$0(coroutineScope, sheetState, function0);
                    }
                };
                composer.updateRememberedValue(objRememberedValue2);
            }
            ComposerKt.sourceInformationMarkerEnd(composer);
            BoxAiBottomSheetContent(store, stateBoxAiBottomSheet$lambda$0, hazeState, function1, (Function0) objRememberedValue2, composer, 3072);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit BoxAiBottomSheet$lambda$11$0$0(MutableFloatState mutableFloatState, float f) {
        mutableFloatState.setFloatValue(f);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit BoxAiBottomSheet$lambda$11$1$0(CoroutineScope coroutineScope, SheetState sheetState, Function0 function0) {
        BuildersKt__Builders_commonKt.launch$default(coroutineScope, null, null, new BoxAiScreenKt$BoxAiBottomSheet$6$2$1$1(sheetState, function0, null), 3, null);
        return Unit.INSTANCE;
    }

    /* JADX WARN: Code duplicated, block: B:129:0x036e  */
    /* JADX WARN: Code duplicated, block: B:130:0x0370  */
    /* JADX WARN: Code duplicated, block: B:135:0x037f  */
    /* JADX WARN: Code duplicated, block: B:139:0x0395  */
    /* JADX WARN: Code duplicated, block: B:142:0x039f  */
    /* JADX WARN: Code duplicated, block: B:147:0x03ae  */
    /* JADX WARN: Code duplicated, block: B:150:0x03df  */
    private static final void BoxAiBottomSheetContent(final Store<BoxAiReducer.State, BoxAiReducer.Action> store, final BoxAiReducer.State state, final HazeState hazeState, final Function1<? super Float, Unit> function1, final Function0<Unit> function0, Composer composer, final int i) {
        int i2;
        BoxAiReducer.State state2;
        Function0<Unit> function2;
        boolean z;
        Modifier modifierHazeEffect;
        boolean z2;
        boolean z3;
        int i3;
        boolean z4;
        Object objRememberedValue;
        Function0 function3;
        Object objRememberedValue2;
        BoxAiQaReducer.State state3;
        Composer composerStartRestartGroup = composer.startRestartGroup(1877811033);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(BoxAiBottomSheetContent)N(store,state,hazeState,onTopBarPositionUpdate,onCloseClicked)162@6385L11,164@6441L2917:BoxAiScreen.kt#6z2y90");
        if ((i & 6) == 0) {
            i2 = (composerStartRestartGroup.changed(store) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 48) == 0) {
            state2 = state;
            i2 |= composerStartRestartGroup.changedInstance(state2) ? 32 : 16;
        } else {
            state2 = state;
        }
        if ((i & 384) == 0) {
            i2 |= composerStartRestartGroup.changed(hazeState) ? 256 : 128;
        }
        if ((i & 3072) == 0) {
            i2 |= composerStartRestartGroup.changedInstance(function1) ? 2048 : 1024;
        }
        if ((i & 24576) == 0) {
            function2 = function0;
            i2 |= composerStartRestartGroup.changedInstance(function2) ? 16384 : 8192;
        } else {
            function2 = function0;
        }
        if (!composerStartRestartGroup.shouldExecute((i2 & 9363) != 9362, i2 & 1)) {
            composerStartRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1877811033, i2, -1, "com.box.android.boxai.BoxAiBottomSheetContent (BoxAiScreen.kt:161)");
            }
            boolean zIsDarkTheme = BoxTheme.INSTANCE.isDarkTheme(composerStartRestartGroup, BoxTheme.$stable);
            BoxAiReducer.ScreenState screenState = state2.getScreenState();
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
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -188205281, "C196@7552L79,224@9077L198,222@8910L91,195@7486L1866:BoxAiScreen.kt#6z2y90");
            if (screenState instanceof BoxAiReducer.ScreenState.QaSession) {
                composerStartRestartGroup.startReplaceGroup(-188209994);
                ComposerKt.sourceInformation(composerStartRestartGroup, "172@6778L31,167@6547L345");
                Store<LocalState, BoxAiReducer.Action> storeScope = store.scope(new PropertyReference1Impl() { // from class: com.box.android.boxai.BoxAiScreenKt$BoxAiBottomSheetContent$1$1
                    @Override // kotlin.jvm.internal.PropertyReference1Impl, kotlin.reflect.KProperty1
                    public Object get(Object obj) {
                        return ((BoxAiReducer.State) obj).getScreenState();
                    }
                });
                KClass orCreateKotlinClass = Reflection.getOrCreateKotlinClass(BoxAiReducer.ScreenState.QaSession.class);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1945726318, "CC(remember):BoxAiScreen.kt#9igjgp");
                BoxAiScreenKt$BoxAiBottomSheetContent$1$2$1 boxAiScreenKt$BoxAiBottomSheetContent$1$2$1RememberedValue = composerStartRestartGroup.rememberedValue();
                if (boxAiScreenKt$BoxAiBottomSheetContent$1$2$1RememberedValue == Composer.INSTANCE.getEmpty()) {
                    boxAiScreenKt$BoxAiBottomSheetContent$1$2$1RememberedValue = BoxAiScreenKt$BoxAiBottomSheetContent$1$2$1.INSTANCE;
                    composerStartRestartGroup.updateRememberedValue(boxAiScreenKt$BoxAiBottomSheetContent$1$2$1RememberedValue);
                }
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                Function1 function4 = (Function1) ((KFunction) boxAiScreenKt$BoxAiBottomSheetContent$1$2$1RememberedValue);
                Object value = storeScope.getState().getValue();
                if (!(value instanceof BoxAiReducer.ScreenState.QaSession)) {
                    value = null;
                }
                Store storeScope2 = ((BoxAiReducer.ScreenState.QaSession) value) != null ? storeScope.scope(KClassesJvm.getJvmName(orCreateKotlinClass), new Function1<BoxAiReducer.ScreenState, Wrapped<BoxAiQaReducer.State>>() { // from class: com.box.android.boxai.BoxAiScreenKt$BoxAiBottomSheetContent$lambda$0$$inlined$case$1
                    @Override // kotlin.jvm.functions.Function1
                    public final Wrapped<BoxAiQaReducer.State> invoke(BoxAiReducer.ScreenState globalState) {
                        BoxAiQaReducer.State action;
                        Intrinsics.checkNotNullParameter(globalState, "globalState");
                        if (!(globalState instanceof BoxAiReducer.ScreenState.QaSession)) {
                            globalState = null;
                        }
                        BoxAiReducer.ScreenState.QaSession qaSession = (BoxAiReducer.ScreenState.QaSession) globalState;
                        if (qaSession == null || (action = qaSession.getAction()) == null) {
                            return null;
                        }
                        return StoreKt.wrap(action);
                    }
                }, (Function1<? super LocalAction, ? extends BoxAiReducer.Action>) function4) : null;
                Intrinsics.checkNotNull(storeScope2);
                BoxAiQaScreenKt.BoxAiQaScreen(storeScope2, hazeState, composerStartRestartGroup, (i2 >> 3) & 112);
                composerStartRestartGroup.endReplaceGroup();
            } else if (screenState instanceof BoxAiReducer.ScreenState.DocumentContentTooLarge) {
                composerStartRestartGroup.startReplaceGroup(-187771716);
                ComposerKt.sourceInformation(composerStartRestartGroup, "180@7076L110,179@6993L211");
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1945716703, "CC(remember):BoxAiScreen.kt#9igjgp");
                boolean z5 = (i2 & 14) == 4;
                Object objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                if (z5 || objRememberedValue3 == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue3 = new Function0() { // from class: com.box.android.boxai.BoxAiScreenKt$$ExternalSyntheticLambda1
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            return BoxAiScreenKt.BoxAiBottomSheetContent$lambda$0$1$0(store);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                }
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                BoxAiDocumentContentTooLarge((Function0) objRememberedValue3, composerStartRestartGroup, 0);
                composerStartRestartGroup.endReplaceGroup();
            } else if (screenState instanceof BoxAiReducer.ScreenState.Error) {
                composerStartRestartGroup.startReplaceGroup(-187486051);
                ComposerKt.sourceInformation(composerStartRestartGroup, "187@7287L18");
                BoxAiErrorScreen(composerStartRestartGroup, 0);
                composerStartRestartGroup.endReplaceGroup();
            } else {
                if (!Intrinsics.areEqual(screenState, BoxAiReducer.ScreenState.Uninitialized.INSTANCE) && !Intrinsics.areEqual(screenState, BoxAiReducer.ScreenState.Initializing.INSTANCE)) {
                    composerStartRestartGroup.startReplaceGroup(-1945735664);
                    composerStartRestartGroup.endReplaceGroup();
                    throw new NoWhenBranchMatchedException();
                }
                composerStartRestartGroup.startReplaceGroup(-187342149);
                ComposerKt.sourceInformation(composerStartRestartGroup, "191@7432L20");
                BoxAiLoadingScreen(composerStartRestartGroup, 0);
                composerStartRestartGroup.endReplaceGroup();
            }
            Modifier.Companion companion2 = Modifier.INSTANCE;
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1945701502, "CC(remember):BoxAiScreen.kt#9igjgp");
            boolean z6 = (i2 & 7168) == 2048;
            Object objRememberedValue4 = composerStartRestartGroup.rememberedValue();
            if (z6 || objRememberedValue4 == Composer.INSTANCE.getEmpty()) {
                objRememberedValue4 = new Function1() { // from class: com.box.android.boxai.BoxAiScreenKt$$ExternalSyntheticLambda2
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return BoxAiScreenKt.BoxAiBottomSheetContent$lambda$0$2$0(function1, (LayoutCoordinates) obj);
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue4);
            }
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            Modifier modifierOnGloballyPositioned = OnGloballyPositionedModifierKt.onGloballyPositioned(companion2, (Function1) objRememberedValue4);
            if (hazeState == null) {
                composerStartRestartGroup.startReplaceGroup(-187064762);
                composerStartRestartGroup.endReplaceGroup();
                modifierHazeEffect = null;
                z = false;
            } else {
                composerStartRestartGroup.startReplaceGroup(-187064761);
                ComposerKt.sourceInformation(composerStartRestartGroup, "*204@7911L6,207@8092L523");
                Modifier.Companion companion3 = Modifier.INSTANCE;
                z = false;
                HazeStyle hazeStyle = new HazeStyle(Color.INSTANCE.m6849getTransparent0d7_KjU(), CollectionsKt.listOf((Object[]) new HazeTint[]{new HazeTint(BoxAITheme.INSTANCE.getColors(composerStartRestartGroup, 6).m12054getContainerBackground0d7_KjU(), 0, 2, null), new HazeTint(Color.INSTANCE.m6849getTransparent0d7_KjU(), 0, 2, null)}), zIsDarkTheme ? Dp.m9687constructorimpl(0) : Dp.m9687constructorimpl(4), 0.0f, (HazeTint) null, 24, (DefaultConstructorMarker) null);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 289145669, "CC(remember):BoxAiScreen.kt#9igjgp");
                Object objRememberedValue5 = composerStartRestartGroup.rememberedValue();
                if (objRememberedValue5 == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue5 = new Function1() { // from class: com.box.android.boxai.BoxAiScreenKt$$ExternalSyntheticLambda3
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            return BoxAiScreenKt.BoxAiBottomSheetContent$lambda$0$3$0$0((HazeEffectScope) obj);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue5);
                }
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                modifierHazeEffect = HazeChildKt.hazeEffect(companion3, hazeState, hazeStyle, (Function1) objRememberedValue5);
                composerStartRestartGroup.endReplaceGroup();
            }
            if (modifierHazeEffect != null) {
                composerStartRestartGroup.startReplaceGroup(-1945697276);
                composerStartRestartGroup.endReplaceGroup();
            } else {
                composerStartRestartGroup.startReplaceGroup(-1945666524);
                ComposerKt.sourceInformation(composerStartRestartGroup, "218@8668L6");
                modifierHazeEffect = BackgroundKt.m589backgroundbw27NRU$default(Modifier.INSTANCE, BoxAITheme.INSTANCE.getColors(composerStartRestartGroup, 6).m12054getContainerBackground0d7_KjU(), null, 2, null);
                composerStartRestartGroup.endReplaceGroup();
            }
            Modifier modifierThen = modifierOnGloballyPositioned.then(modifierHazeEffect);
            BoxAiReducer.ScreenState screenState2 = state2.getScreenState();
            BoxAiReducer.ScreenState.QaSession qaSession = screenState2 instanceof BoxAiReducer.ScreenState.QaSession ? (BoxAiReducer.ScreenState.QaSession) screenState2 : null;
            if (qaSession == null || (state3 = qaSession.getState()) == null) {
                z2 = true;
            } else {
                z2 = true;
                if (state3.getHasChatHistory()) {
                    z3 = true;
                }
                BoxAiAgentsReducer.State agentsState = state2.getAgentsState();
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1945652583, "CC(remember):BoxAiScreen.kt#9igjgp");
                i3 = i2 & 14;
                if (i3 == 4) {
                    z4 = z2;
                } else {
                    z4 = z;
                }
                objRememberedValue = composerStartRestartGroup.rememberedValue();
                if (!z4 || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue = new Function0() { // from class: com.box.android.boxai.BoxAiScreenKt$$ExternalSyntheticLambda4
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            return BoxAiScreenKt.BoxAiBottomSheetContent$lambda$0$4$0(store);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                }
                function3 = (Function0) objRememberedValue;
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                if (!(state2.getScreenState() instanceof BoxAiReducer.ScreenState.QaSession)) {
                    function3 = null;
                }
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1945658034, "CC(remember):BoxAiScreen.kt#9igjgp");
                if (i3 == 4) {
                    z = true;
                }
                objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                if (!z || objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue2 = new Function1() { // from class: com.box.android.boxai.BoxAiScreenKt$$ExternalSyntheticLambda5
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            return BoxAiScreenKt.BoxAiBottomSheetContent$lambda$0$6$0(store, (AiAgentModel) obj);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                }
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                BoxAiTopBarKt.BoxAiTopBar(z3, function2, function3, (Function1) objRememberedValue2, agentsState, modifierThen, composerStartRestartGroup, (i2 >> 9) & 112, 0);
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
            z3 = z;
            BoxAiAgentsReducer.State agentsState2 = state2.getAgentsState();
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1945652583, "CC(remember):BoxAiScreen.kt#9igjgp");
            i3 = i2 & 14;
            if (i3 == 4) {
                z4 = z2;
            } else {
                z4 = z;
            }
            objRememberedValue = composerStartRestartGroup.rememberedValue();
            if (!z4) {
                objRememberedValue = new Function0() { // from class: com.box.android.boxai.BoxAiScreenKt$$ExternalSyntheticLambda4
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return BoxAiScreenKt.BoxAiBottomSheetContent$lambda$0$4$0(store);
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
            } else {
                objRememberedValue = new Function0() { // from class: com.box.android.boxai.BoxAiScreenKt$$ExternalSyntheticLambda4
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return BoxAiScreenKt.BoxAiBottomSheetContent$lambda$0$4$0(store);
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
            }
            function3 = (Function0) objRememberedValue;
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            if (!(state2.getScreenState() instanceof BoxAiReducer.ScreenState.QaSession)) {
                function3 = null;
            }
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1945658034, "CC(remember):BoxAiScreen.kt#9igjgp");
            if (i3 == 4) {
                z = true;
            }
            objRememberedValue2 = composerStartRestartGroup.rememberedValue();
            if (!z) {
                objRememberedValue2 = new Function1() { // from class: com.box.android.boxai.BoxAiScreenKt$$ExternalSyntheticLambda5
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return BoxAiScreenKt.BoxAiBottomSheetContent$lambda$0$6$0(store, (AiAgentModel) obj);
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
            } else {
                objRememberedValue2 = new Function1() { // from class: com.box.android.boxai.BoxAiScreenKt$$ExternalSyntheticLambda5
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return BoxAiScreenKt.BoxAiBottomSheetContent$lambda$0$6$0(store, (AiAgentModel) obj);
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
            }
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            BoxAiTopBarKt.BoxAiTopBar(z3, function2, function3, (Function1) objRememberedValue2, agentsState2, modifierThen, composerStartRestartGroup, (i2 >> 9) & 112, 0);
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
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.box.android.boxai.BoxAiScreenKt$$ExternalSyntheticLambda6
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return BoxAiScreenKt.BoxAiBottomSheetContent$lambda$1(store, state, hazeState, function1, function0, i, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit BoxAiBottomSheetContent$lambda$0$1$0(Store store) {
        store.send(BoxAiReducer.Action.ResolveDocumentContentTooLarge.INSTANCE);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit BoxAiBottomSheetContent$lambda$0$2$0(Function1 function1, LayoutCoordinates it) {
        Intrinsics.checkNotNullParameter(it, "it");
        function1.invoke(Float.valueOf(Float.intBitsToFloat((int) (LayoutCoordinatesKt.positionOnScreen(it) & 4294967295L))));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit BoxAiBottomSheetContent$lambda$0$3$0$0(HazeEffectScope hazeEffect) {
        Intrinsics.checkNotNullParameter(hazeEffect, "$this$hazeEffect");
        hazeEffect.setProgressive(HazeProgressive.INSTANCE.verticalGradient(EasingFunctionsKt.getEaseOutCubic(), Float.POSITIVE_INFINITY, 0.0f, 0.0f, 1.0f, Build.VERSION.SDK_INT == 32));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit BoxAiBottomSheetContent$lambda$0$6$0(Store store, AiAgentModel it) {
        Intrinsics.checkNotNullParameter(it, "it");
        store.send(new BoxAiReducer.Action.AgentsAction(new BoxAiAgentsReducer.Action.SelectAgent(it)));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit BoxAiBottomSheetContent$lambda$0$4$0(Store store) {
        store.send(new BoxAiReducer.Action.QaAiAction(new BoxAiQaReducer.Action.ClearChatAction(BoxAiClearChatReducer.Action.ClearChatClicked.INSTANCE)));
        return Unit.INSTANCE;
    }

    public static final void BoxAiLoadingScreen(Composer composer, final int i) {
        Composer composerStartRestartGroup = composer.startRestartGroup(-618337866);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(BoxAiLoadingScreen)237@9473L6,235@9405L315:BoxAiScreen.kt#6z2y90");
        if (!composerStartRestartGroup.shouldExecute(i != 0, i & 1)) {
            composerStartRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-618337866, i, -1, "com.box.android.boxai.BoxAiLoadingScreen (BoxAiScreen.kt:234)");
            }
            Modifier modifierTestTag = TestTagKt.testTag(SizeKt.m1252height3ABfNKs(SizeKt.fillMaxWidth$default(BackgroundKt.m589backgroundbw27NRU$default(Modifier.INSTANCE, BoxAITheme.INSTANCE.getColors(composerStartRestartGroup, 6).m12054getContainerBackground0d7_KjU(), null, 2, null), 0.0f, 1, null), BoxAiQaScreenKt.getSMALL_SHEET_QA_SCREEN_SIZE()), "BoxAi:Loading");
            Alignment center = Alignment.INSTANCE.getCenter();
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1042775818, "CC(Box)N(modifier,contentAlignment,propagateMinConstraints,content)71@3424L131:Box.kt#2w3rfo");
            MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(center, false);
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
            Updater.m6070setimpl(composerM6062constructorimpl, measurePolicyMaybeCachedBoxMeasurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
            Updater.m6070setimpl(composerM6062constructorimpl, currentCompositionLocalMap, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
            Updater.m6066initimpl(composerM6062constructorimpl, Integer.valueOf(iHashCode), ComposeUiNode.INSTANCE.getSetCompositeKeyHash());
            Updater.m6068reconcileimpl(composerM6062constructorimpl, ComposeUiNode.INSTANCE.getApplyOnDeactivatedNodeAssertion());
            Updater.m6070setimpl(composerM6062constructorimpl, modifierMaterializeModifier, ComposeUiNode.INSTANCE.getSetModifier());
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1833054614, "C72@3469L9:Box.kt#2w3rfo");
            BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1194767341, "C243@9676L38:BoxAiScreen.kt#6z2y90");
            BoxAiProgressBarKt.m12079BoxAiProgressBarrAjV9yQ(null, Dp.m9687constructorimpl(24), composerStartRestartGroup, 48, 1);
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
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.box.android.boxai.BoxAiScreenKt$$ExternalSyntheticLambda23
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return BoxAiScreenKt.BoxAiLoadingScreen$lambda$1(i, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    public static final void BoxAiDocumentContentTooLarge(final Function0<Unit> resolveDocumentContentTooLarge, Composer composer, final int i) {
        int i2;
        Intrinsics.checkNotNullParameter(resolveDocumentContentTooLarge, "resolveDocumentContentTooLarge");
        Composer composerStartRestartGroup = composer.startRestartGroup(-1464960821);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(BoxAiDocumentContentTooLarge)N(resolveDocumentContentTooLarge)249@9819L1129:BoxAiScreen.kt#6z2y90");
        if ((i & 6) == 0) {
            i2 = (composerStartRestartGroup.changedInstance(resolveDocumentContentTooLarge) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if (!composerStartRestartGroup.shouldExecute((i2 & 3) != 2, i2 & 1)) {
            composerStartRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1464960821, i2, -1, "com.box.android.boxai.BoxAiDocumentContentTooLarge (BoxAiScreen.kt:248)");
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
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1900248624, "C250@9836L46,253@9980L6,256@10146L54,257@10228L62,251@9891L512,266@10629L6,265@10573L94,262@10412L530:BoxAiScreen.kt#6z2y90");
            SpacerKt.Spacer(SizeKt.m1252height3ABfNKs(Modifier.INSTANCE, BoxSizes.INSTANCE.m11614getTopBarHeightD9Ej5fM()), composerStartRestartGroup, 0);
            ItemStateScreensKt.m11654ItemsStateScreenV9fs2A(new ItemsStateConfig(R.drawable.ic_errorstate404140, StringResources_androidKt.stringResource(R.string.box_ai_text_content_too_large, composerStartRestartGroup, 0), StringResources_androidKt.stringResource(R.string.box_ai_text_content_too_large_subtext, composerStartRestartGroup, 0), null, 8, null), "BoxAi:DocumentContentTooLarge", BackgroundKt.m589backgroundbw27NRU$default(Modifier.INSTANCE, BoxAITheme.INSTANCE.getColors(composerStartRestartGroup, 6).m12054getContainerBackground0d7_KjU(), null, 2, null), false, false, 0L, composerStartRestartGroup, 3120, 48);
            ButtonKt.Button(resolveDocumentContentTooLarge, PaddingKt.m1218padding3ABfNKs(SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null), Dp.m9687constructorimpl(16)), false, (Shape) RoundedCornerShapeKt.m1573RoundedCornerShape0680j_4(Dp.m9687constructorimpl(18)), ButtonDefaults.INSTANCE.m2850buttonColorsro_MJ88(BoxTheme.INSTANCE.getColors(composerStartRestartGroup, BoxTheme.$stable).m11533getMainActiveControl0d7_KjU(), 0L, 0L, 0L, composerStartRestartGroup, ButtonDefaults.$stable << 12, 14), (ButtonElevation) null, (BorderStroke) null, (PaddingValues) null, (MutableInteractionSource) null, (Function3<? super RowScope, ? super Composer, ? super Integer, Unit>) ComposableSingletons$BoxAiScreenKt.INSTANCE.getLambda$1258442545$boxai_generalProdRelease(), composerStartRestartGroup, (i2 & 14) | 805306416, 484);
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
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.box.android.boxai.BoxAiScreenKt$$ExternalSyntheticLambda19
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return BoxAiScreenKt.BoxAiDocumentContentTooLarge$lambda$1(resolveDocumentContentTooLarge, i, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    public static final void BoxAiErrorScreen(Composer composer, final int i) {
        Composer composerStartRestartGroup = composer.startRestartGroup(-407433662);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(BoxAiErrorScreen)281@10993L619:BoxAiScreen.kt#6z2y90");
        if (!composerStartRestartGroup.shouldExecute(i != 0, i & 1)) {
            composerStartRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-407433662, i, -1, "com.box.android.boxai.BoxAiErrorScreen (BoxAiScreen.kt:280)");
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
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1427657059, "C282@11010L46,285@11154L6,288@11316L43,289@11387L51,283@11065L503,295@11577L29:BoxAiScreen.kt#6z2y90");
            SpacerKt.Spacer(SizeKt.m1252height3ABfNKs(Modifier.INSTANCE, BoxSizes.INSTANCE.m11614getTopBarHeightD9Ej5fM()), composerStartRestartGroup, 0);
            ItemStateScreensKt.m11654ItemsStateScreenV9fs2A(new ItemsStateConfig(R.drawable.ic_unplugged140, StringResources_androidKt.stringResource(R.string.box_ai_unavailable, composerStartRestartGroup, 0), StringResources_androidKt.stringResource(R.string.box_ai_unavailable_subtext, composerStartRestartGroup, 0), null), "BoxAi:Error", BackgroundKt.m589backgroundbw27NRU$default(Modifier.INSTANCE, BoxAITheme.INSTANCE.getColors(composerStartRestartGroup, 6).m12054getContainerBackground0d7_KjU(), null, 2, null), false, false, 0L, composerStartRestartGroup, 3120, 48);
            BoxAiPromptInputBoxKt.DisabledBoxAiPromptInputBox(composerStartRestartGroup, 0);
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
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.box.android.boxai.BoxAiScreenKt$$ExternalSyntheticLambda0
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return BoxAiScreenKt.BoxAiErrorScreen$lambda$1(i, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    public static final void UpdateToUseBoxAiAlert(Function0<Unit> onClickPositiveButton, Function0<Unit> onClickNegativeButton, Composer composer, final int i) {
        int i2;
        final Function0<Unit> function0;
        final Function0<Unit> function1;
        Composer composer2;
        Intrinsics.checkNotNullParameter(onClickPositiveButton, "onClickPositiveButton");
        Intrinsics.checkNotNullParameter(onClickNegativeButton, "onClickNegativeButton");
        Composer composerStartRestartGroup = composer.startRestartGroup(-330859231);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(UpdateToUseBoxAiAlert)N(onClickPositiveButton,onClickNegativeButton)301@11730L456:BoxAiScreen.kt#6z2y90");
        if ((i & 6) == 0) {
            i2 = (composerStartRestartGroup.changedInstance(onClickPositiveButton) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 48) == 0) {
            i2 |= composerStartRestartGroup.changedInstance(onClickNegativeButton) ? 32 : 16;
        }
        if (!composerStartRestartGroup.shouldExecute((i2 & 19) != 18, i2 & 1)) {
            function0 = onClickPositiveButton;
            function1 = onClickNegativeButton;
            composer2 = composerStartRestartGroup;
            composer2.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-330859231, i2, -1, "com.box.android.boxai.UpdateToUseBoxAiAlert (BoxAiScreen.kt:300)");
            }
            composer2 = composerStartRestartGroup;
            function1 = onClickNegativeButton;
            function0 = onClickPositiveButton;
            BoxAlertDialogKt.m11705BoxAlertDialogSxpAMN0(R.string.Feature_disabled, R.string.box_ai_update_app_message, new ButtonItem.TextButtonItem(false, onClickPositiveButton, R.string.Get_Update, 1, null), new ButtonItem.TextButtonItem(false, function1, R.string.button_ok, 1, null), "BoxAi:UpdateAppDialog", null, 0L, 0L, composer2, 24576, 224);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.box.android.boxai.BoxAiScreenKt$$ExternalSyntheticLambda17
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return BoxAiScreenKt.UpdateToUseBoxAiAlert$lambda$0(function0, function1, i, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    private static final void BoxAiBottomSheetContentQaPreview(Composer composer, final int i) {
        Composer composerStartRestartGroup = composer.startRestartGroup(1953369953);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(BoxAiBottomSheetContentQaPreview)339@13042L343,339@13033L352:BoxAiScreen.kt#6z2y90");
        if (!composerStartRestartGroup.shouldExecute(i != 0, i & 1)) {
            composerStartRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1953369953, i, -1, "com.box.android.boxai.BoxAiBottomSheetContentQaPreview (BoxAiScreen.kt:321)");
            }
            final BoxAiReducer.State state = new BoxAiReducer.State(CollectionsKt.listOf((Object[]) new FileModel[]{ComposePreviewMocks.INSTANCE.getEMPTY_FILE_MODEL(), ComposePreviewMocks.INSTANCE.getEMPTY_FILE_MODEL()}), CollectionsKt.emptyList(), false, new BoxAiReducer.ScreenState.QaSession(new BoxAiQaReducer.State(CollectionsKt.listOf((Object[]) new FileModel[]{ComposePreviewMocks.INSTANCE.getEMPTY_FILE_MODEL(), ComposePreviewMocks.INSTANCE.getEMPTY_FILE_MODEL()}), null, "", false, false, null, null, null, null, null, null, null, false, false, false, 32762, null)), false, true, false, new BoxAiAgentsReducer.State(CollectionsKt.listOf((Object[]) new AiAgentModel[]{new AiAgentModel("1", "Agent 1", false, null, null, 28, null), new AiAgentModel("2", "Agent 2", false, null, null, 28, null)}), null, 2, null), 84, null);
            BoxThemeKt.BoxTheme(ComposableLambdaKt.rememberComposableLambda(36345718, true, new Function2() { // from class: com.box.android.boxai.BoxAiScreenKt$$ExternalSyntheticLambda21
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return BoxAiScreenKt.BoxAiBottomSheetContentQaPreview$lambda$0(state, (Composer) obj, ((Integer) obj2).intValue());
                }
            }, composerStartRestartGroup, 54), composerStartRestartGroup, 6);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.box.android.boxai.BoxAiScreenKt$$ExternalSyntheticLambda22
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return BoxAiScreenKt.BoxAiBottomSheetContentQaPreview$lambda$1(i, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit BoxAiBottomSheetContentQaPreview$lambda$0(BoxAiReducer.State state, Composer composer, int i) {
        ComposerKt.sourceInformation(composer, "C340@13087L6,340@13052L327:BoxAiScreen.kt#6z2y90");
        if (!composer.shouldExecute((i & 3) != 2, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(36345718, i, -1, "com.box.android.boxai.BoxAiBottomSheetContentQaPreview.<anonymous> (BoxAiScreen.kt:340)");
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
            ComposerKt.sourceInformationMarkerStart(composer, 1988856836, "C345@13316L2,346@13353L2,341@13130L239:BoxAiScreen.kt#6z2y90");
            Store storeCreateMockStore = ComposePreviewUtilsKt.createMockStore(state);
            HazeState hazeState = new HazeState();
            ComposerKt.sourceInformationMarkerStart(composer, -1044216270, "CC(remember):BoxAiScreen.kt#9igjgp");
            Object objRememberedValue = composer.rememberedValue();
            if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                objRememberedValue = new Function1() { // from class: com.box.android.boxai.BoxAiScreenKt$$ExternalSyntheticLambda24
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return BoxAiScreenKt.BoxAiBottomSheetContentQaPreview$lambda$0$0$0$0(((Float) obj).floatValue());
                    }
                };
                composer.updateRememberedValue(objRememberedValue);
            }
            Function1 function1 = (Function1) objRememberedValue;
            ComposerKt.sourceInformationMarkerEnd(composer);
            ComposerKt.sourceInformationMarkerStart(composer, -1044215086, "CC(remember):BoxAiScreen.kt#9igjgp");
            Object objRememberedValue2 = composer.rememberedValue();
            if (objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                objRememberedValue2 = new Function0() { // from class: com.box.android.boxai.BoxAiScreenKt$$ExternalSyntheticLambda25
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return Unit.INSTANCE;
                    }
                };
                composer.updateRememberedValue(objRememberedValue2);
            }
            ComposerKt.sourceInformationMarkerEnd(composer);
            BoxAiBottomSheetContent(storeCreateMockStore, state, hazeState, function1, (Function0) objRememberedValue2, composer, 27648);
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
    public static final Unit BoxAiBottomSheetContentQaPreview$lambda$0$0$0$0(float f) {
        return Unit.INSTANCE;
    }

    private static final void BoxAiLoadingScreenPreview(Composer composer, final int i) {
        Composer composerStartRestartGroup = composer.startRestartGroup(371823672);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(BoxAiLoadingScreenPreview)356@13492L133:BoxAiScreen.kt#6z2y90");
        if (!composerStartRestartGroup.shouldExecute(i != 0, i & 1)) {
            composerStartRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(371823672, i, -1, "com.box.android.boxai.BoxAiLoadingScreenPreview (BoxAiScreen.kt:355)");
            }
            BoxThemeKt.BoxTheme(ComposableSingletons$BoxAiScreenKt.INSTANCE.m11940getLambda$723859005$boxai_generalProdRelease(), composerStartRestartGroup, 6);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.box.android.boxai.BoxAiScreenKt$$ExternalSyntheticLambda20
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return BoxAiScreenKt.BoxAiLoadingScreenPreview$lambda$0(i, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    private static final void BoxAiErrorScreenPreview(Composer composer, final int i) {
        Composer composerStartRestartGroup = composer.startRestartGroup(-1697940948);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(BoxAiErrorScreenPreview)367@13730L131:BoxAiScreen.kt#6z2y90");
        if (!composerStartRestartGroup.shouldExecute(i != 0, i & 1)) {
            composerStartRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1697940948, i, -1, "com.box.android.boxai.BoxAiErrorScreenPreview (BoxAiScreen.kt:366)");
            }
            BoxThemeKt.BoxTheme(ComposableSingletons$BoxAiScreenKt.INSTANCE.getLambda$1053988471$boxai_generalProdRelease(), composerStartRestartGroup, 6);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.box.android.boxai.BoxAiScreenKt$$ExternalSyntheticLambda11
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return BoxAiScreenKt.BoxAiErrorScreenPreview$lambda$0(i, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    private static final void BoxAiDocumentContentTooLargePreview(Composer composer, final int i) {
        Composer composerStartRestartGroup = composer.startRestartGroup(2075866459);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(BoxAiDocumentContentTooLargePreview)378@13978L208:BoxAiScreen.kt#6z2y90");
        if (!composerStartRestartGroup.shouldExecute(i != 0, i & 1)) {
            composerStartRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(2075866459, i, -1, "com.box.android.boxai.BoxAiDocumentContentTooLargePreview (BoxAiScreen.kt:377)");
            }
            BoxThemeKt.BoxTheme(ComposableSingletons$BoxAiScreenKt.INSTANCE.m11939getLambda$2107950810$boxai_generalProdRelease(), composerStartRestartGroup, 6);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.box.android.boxai.BoxAiScreenKt$$ExternalSyntheticLambda18
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return BoxAiScreenKt.BoxAiDocumentContentTooLargePreview$lambda$0(i, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    private static final void UpdateToUseBoxAiAlertPreview(Composer composer, final int i) {
        Composer composerStartRestartGroup = composer.startRestartGroup(-2056295235);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(UpdateToUseBoxAiAlertPreview)391@14296L236:BoxAiScreen.kt#6z2y90");
        if (!composerStartRestartGroup.shouldExecute(i != 0, i & 1)) {
            composerStartRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-2056295235, i, -1, "com.box.android.boxai.UpdateToUseBoxAiAlertPreview (BoxAiScreen.kt:390)");
            }
            BoxThemeKt.BoxTheme(ComposableSingletons$BoxAiScreenKt.INSTANCE.m11938getLambda$1787476142$boxai_generalProdRelease(), composerStartRestartGroup, 6);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.box.android.boxai.BoxAiScreenKt$$ExternalSyntheticLambda7
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return BoxAiScreenKt.UpdateToUseBoxAiAlertPreview$lambda$0(i, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final BoxAiReducer.State BoxAiBottomSheet$lambda$0(State<BoxAiReducer.State> state) {
        return state.getValue();
    }
}
