package com.box.android.capture.widget;

import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.ClickableKt;
import androidx.compose.foundation.gestures.FlingBehavior;
import androidx.compose.foundation.gestures.snapping.LazyListSnapLayoutInfoProviderKt;
import androidx.compose.foundation.gestures.snapping.SnapPosition;
import androidx.compose.foundation.interaction.InteractionSourceKt;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.BoxWithConstraintsKt;
import androidx.compose.foundation.layout.BoxWithConstraintsScope;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.layout.WindowInsets;
import androidx.compose.foundation.layout.WindowInsetsKt;
import androidx.compose.foundation.layout.WindowInsets_androidKt;
import androidx.compose.foundation.lazy.LazyDslKt;
import androidx.compose.foundation.lazy.LazyItemScope;
import androidx.compose.foundation.lazy.LazyListScope;
import androidx.compose.foundation.lazy.LazyListState;
import androidx.compose.foundation.lazy.LazyListStateKt;
import androidx.compose.foundation.shape.RoundedCornerShapeKt;
import androidx.compose.material3.TextKt;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.MutableIntState;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SnapshotIntStateKt;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.runtime.saveable.RememberSaveableKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.platform.TestTagKt;
import androidx.compose.ui.res.StringResources_androidKt;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.Dp;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.compose.FlowExtKt;
import com.box.android.base.compose.BoxColorPalette;
import com.box.android.base.compose.BoxTypography;
import com.box.android.base.compose.ComposeUtilsKt;
import com.box.android.capture.R;
import com.box.android.capture.cpl.CaptureReducer;
import com.box.android.capture.cpl.UninitializedCaptureModeState;
import com.box.android.cpl.EmptyReducer;
import com.box.android.cpl.Store;
import com.box.android.domain.models.capture.CaptureMode;
import com.facebook.react.uimanager.ViewProps;
import com.google.android.material.internal.ViewUtils;
import external.sdk.pendo.io.mozilla.javascript.Token;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Job;

/* JADX INFO: compiled from: CaptureModeSwitcher.kt */
/* JADX INFO: loaded from: classes10.dex */
@Metadata(d1 = {"\u0000P\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\u001a!\u0010\u0004\u001a\u00020\u00052\u0012\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t0\u0007H\u0007¢\u0006\u0002\u0010\n\u001a5\u0010\u000b\u001a\u00020\u00052\u0012\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t0\u00072\u0012\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u00050\rH\u0003¢\u0006\u0002\u0010\u000f\u001a)\u0010\u0010\u001a\u00020\u00052\u0006\u0010\u0011\u001a\u00020\u00122\u0012\u0010\u0013\u001a\u000e\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u00050\rH\u0003¢\u0006\u0002\u0010\u0015\u001a\r\u0010\u0016\u001a\u00020\u0005H\u0003¢\u0006\u0002\u0010\u0017\u001a#\u0010\u0018\u001a\u00020\u00052\u0006\u0010\u0019\u001a\u00020\u000e2\f\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00050\u001bH\u0003¢\u0006\u0002\u0010\u001c\u001a\u0011\u0010\u001d\u001a\u00020\u001e*\u00020\u000eH\u0003¢\u0006\u0002\u0010\u001f\u001a\r\u0010 \u001a\u00020\u0005H\u0003¢\u0006\u0002\u0010\u0017\"\u0010\u0010\u0000\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0002\"\u0010\u0010\u0003\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0002¨\u0006!²\u0006\n\u0010\"\u001a\u00020\u0014X\u008a\u008e\u0002²\u0006\f\u0010#\u001a\u0004\u0018\u00010$X\u008a\u008e\u0002²\u0006\n\u0010%\u001a\u00020\bX\u008a\u0084\u0002"}, d2 = {"CaptureModeItemWidth", "Landroidx/compose/ui/unit/Dp;", "F", "CaptureModeItemHeight", "CaptureModeSwitcher", "", "store", "Lcom/box/android/cpl/Store;", "Lcom/box/android/capture/cpl/CaptureReducer$State;", "Lcom/box/android/capture/cpl/CaptureReducer$Action;", "(Lcom/box/android/cpl/Store;Landroidx/compose/runtime/Composer;I)V", "ChangeCaptureModeEffect", "onModeChange", "Lkotlin/Function1;", "Lcom/box/android/domain/models/capture/CaptureMode;", "(Lcom/box/android/cpl/Store;Lkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;I)V", "ChangeCenteredItemIndexEffect", "listState", "Landroidx/compose/foundation/lazy/LazyListState;", "onIndexChange", "", "(Landroidx/compose/foundation/lazy/LazyListState;Lkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;I)V", "CaptureModeHighlight", "(Landroidx/compose/runtime/Composer;I)V", "CaptureModeItem", "item", ViewProps.ON_CLICK, "Lkotlin/Function0;", "(Lcom/box/android/domain/models/capture/CaptureMode;Lkotlin/jvm/functions/Function0;Landroidx/compose/runtime/Composer;I)V", "label", "", "(Lcom/box/android/domain/models/capture/CaptureMode;Landroidx/compose/runtime/Composer;I)Ljava/lang/String;", "CaptureModeSwitcherPreview", "capture_generalProdRelease", "itemIndex", "scrollToItemJob", "Lkotlinx/coroutines/Job;", "state"}, k = 2, mv = {2, 2, 0}, xi = 48)
public final class CaptureModeSwitcherKt {
    private static final float CaptureModeItemWidth = Dp.m9687constructorimpl(60);
    private static final float CaptureModeItemHeight = Dp.m9687constructorimpl(24);

    /* JADX INFO: compiled from: CaptureModeSwitcher.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    public static final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[CaptureMode.values().length];
            try {
                iArr[CaptureMode.VIDEO.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[CaptureMode.PHOTO.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[CaptureMode.SCAN.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[CaptureMode.AUDIO.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit CaptureModeHighlight$lambda$0(int i, Composer composer, int i2) {
        CaptureModeHighlight(composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit CaptureModeItem$lambda$2(CaptureMode captureMode, Function0 function0, int i, Composer composer, int i2) {
        CaptureModeItem(captureMode, function0, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit CaptureModeSwitcher$lambda$9(Store store, int i, Composer composer, int i2) {
        CaptureModeSwitcher(store, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit CaptureModeSwitcherPreview$lambda$1(int i, Composer composer, int i2) {
        CaptureModeSwitcherPreview(composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ChangeCaptureModeEffect$lambda$2(Store store, Function1 function1, int i, Composer composer, int i2) {
        ChangeCaptureModeEffect(store, function1, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ChangeCenteredItemIndexEffect$lambda$1(LazyListState lazyListState, Function1 function1, int i, Composer composer, int i2) {
        ChangeCenteredItemIndexEffect(lazyListState, function1, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    public static final void CaptureModeSwitcher(final Store<CaptureReducer.State, CaptureReducer.Action> store, Composer composer, final int i) {
        int i2;
        Intrinsics.checkNotNullParameter(store, "store");
        Composer composerStartRestartGroup = composer.startRestartGroup(1076451074);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(CaptureModeSwitcher)N(store)71@3354L101,71@3337L118,76@3476L32,79@3620L129,79@3589L160,87@3878L161,87@3837L202,95@4066L24,96@4118L51,99@4214L14,99@4229L17,106@4506L1045,100@4276L1275:CaptureModeSwitcher.kt#3i2u6z");
        if ((i & 6) == 0) {
            i2 = (composerStartRestartGroup.changed(store) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if (!composerStartRestartGroup.shouldExecute((i2 & 3) != 2, i2 & 1)) {
            composerStartRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1076451074, i2, -1, "com.box.android.capture.widget.CaptureModeSwitcher (CaptureModeSwitcher.kt:69)");
            }
            final List list = CollectionsKt.toList(CaptureMode.getEntries());
            Object[] objArr = new Object[0];
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -617630745, "CC(remember):CaptureModeSwitcher.kt#9igjgp");
            int i3 = i2 & 14;
            boolean zChangedInstance = composerStartRestartGroup.changedInstance(list) | (i3 == 4);
            Object objRememberedValue = composerStartRestartGroup.rememberedValue();
            if (zChangedInstance || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                objRememberedValue = new Function0() { // from class: com.box.android.capture.widget.CaptureModeSwitcherKt$$ExternalSyntheticLambda5
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return CaptureModeSwitcherKt.CaptureModeSwitcher$lambda$0$0(list, store);
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
            }
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            final MutableIntState mutableIntState = (MutableIntState) RememberSaveableKt.rememberSaveable(objArr, (Function0) objRememberedValue, composerStartRestartGroup, 0);
            final LazyListState lazyListStateRememberLazyListState = LazyListStateKt.rememberLazyListState(CaptureModeSwitcher$lambda$1(mutableIntState), 0, composerStartRestartGroup, 0, 2);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -617622205, "CC(remember):CaptureModeSwitcher.kt#9igjgp");
            boolean zChangedInstance2 = composerStartRestartGroup.changedInstance(list) | composerStartRestartGroup.changed(mutableIntState);
            Object objRememberedValue2 = composerStartRestartGroup.rememberedValue();
            if (zChangedInstance2 || objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                objRememberedValue2 = new Function1() { // from class: com.box.android.capture.widget.CaptureModeSwitcherKt$$ExternalSyntheticLambda6
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return CaptureModeSwitcherKt.CaptureModeSwitcher$lambda$3$0(list, mutableIntState, (CaptureMode) obj);
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
            }
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ChangeCaptureModeEffect(store, (Function1) objRememberedValue2, composerStartRestartGroup, i3);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -617613917, "CC(remember):CaptureModeSwitcher.kt#9igjgp");
            boolean zChanged = (i3 == 4) | composerStartRestartGroup.changed(mutableIntState) | composerStartRestartGroup.changedInstance(list);
            Object objRememberedValue3 = composerStartRestartGroup.rememberedValue();
            if (zChanged || objRememberedValue3 == Composer.INSTANCE.getEmpty()) {
                objRememberedValue3 = new Function1() { // from class: com.box.android.capture.widget.CaptureModeSwitcherKt$$ExternalSyntheticLambda7
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return CaptureModeSwitcherKt.CaptureModeSwitcher$lambda$4$0(store, list, mutableIntState, ((Integer) obj).intValue());
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
            }
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ChangeCenteredItemIndexEffect(lazyListStateRememberLazyListState, (Function1) objRememberedValue3, composerStartRestartGroup, 0);
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
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -617606347, "CC(remember):CaptureModeSwitcher.kt#9igjgp");
            Object objRememberedValue5 = composerStartRestartGroup.rememberedValue();
            if (objRememberedValue5 == Composer.INSTANCE.getEmpty()) {
                objRememberedValue5 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(null, null, 2, null);
                composerStartRestartGroup.updateRememberedValue(objRememberedValue5);
            }
            final MutableState mutableState = (MutableState) objRememberedValue5;
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            BoxWithConstraintsKt.BoxWithConstraints(SizeKt.m1252height3ABfNKs(SizeKt.fillMaxWidth$default(PaddingKt.m1222paddingqDBjuR0$default(Modifier.INSTANCE, 0.0f, 0.0f, 0.0f, Dp.m9687constructorimpl(Dp.m9687constructorimpl(16) + WindowInsetsKt.asPaddingValues(WindowInsets_androidKt.getNavigationBars(WindowInsets.INSTANCE, composerStartRestartGroup, 6), composerStartRestartGroup, 0).getBottom()), 7, null), 0.0f, 1, null), CaptureModeItemHeight), Alignment.INSTANCE.getCenter(), false, ComposableLambdaKt.rememberComposableLambda(-1597902760, true, new Function3() { // from class: com.box.android.capture.widget.CaptureModeSwitcherKt$$ExternalSyntheticLambda8
                @Override // kotlin.jvm.functions.Function3
                public final Object invoke(Object obj, Object obj2, Object obj3) {
                    return CaptureModeSwitcherKt.CaptureModeSwitcher$lambda$8(lazyListStateRememberLazyListState, list, coroutineScope, mutableState, (BoxWithConstraintsScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                }
            }, composerStartRestartGroup, 54), composerStartRestartGroup, 3120, 4);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.box.android.capture.widget.CaptureModeSwitcherKt$$ExternalSyntheticLambda9
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return CaptureModeSwitcherKt.CaptureModeSwitcher$lambda$9(store, i, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    private static final int CaptureModeSwitcher$lambda$1(MutableIntState mutableIntState) {
        return mutableIntState.getIntValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final MutableIntState CaptureModeSwitcher$lambda$0$0(List list, Store store) {
        return SnapshotIntStateKt.mutableIntStateOf(list.indexOf(((CaptureReducer.State) store.getState().getValue()).getCaptureMode()));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit CaptureModeSwitcher$lambda$3$0(List list, MutableIntState mutableIntState, CaptureMode mode) {
        Intrinsics.checkNotNullParameter(mode, "mode");
        int iIndexOf = list.indexOf(mode);
        if (CaptureModeSwitcher$lambda$1(mutableIntState) != iIndexOf) {
            mutableIntState.setIntValue(iIndexOf);
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit CaptureModeSwitcher$lambda$4$0(Store store, List list, MutableIntState mutableIntState, int i) {
        if (i != CaptureModeSwitcher$lambda$1(mutableIntState)) {
            store.send(new CaptureReducer.Action.SwitchMode((CaptureMode) list.get(i)));
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Job CaptureModeSwitcher$lambda$6(MutableState<Job> mutableState) {
        return mutableState.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit CaptureModeSwitcher$lambda$8(final LazyListState lazyListState, final List list, final CoroutineScope coroutineScope, final MutableState mutableState, BoxWithConstraintsScope BoxWithConstraints, Composer composer, int i) {
        int i2;
        Intrinsics.checkNotNullParameter(BoxWithConstraints, "$this$BoxWithConstraints");
        ComposerKt.sourceInformation(composer, "C107@4516L22,109@4599L6,116@4981L134,120@5126L419,110@4642L903:CaptureModeSwitcher.kt#3i2u6z");
        if ((i & 6) == 0) {
            i2 = i | (composer.changed(BoxWithConstraints) ? 4 : 2);
        } else {
            i2 = i;
        }
        if (!composer.shouldExecute((i2 & 19) != 18, i2 & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1597902760, i2, -1, "com.box.android.capture.widget.CaptureModeSwitcher.<anonymous> (CaptureModeSwitcher.kt:107)");
            }
            CaptureModeHighlight(composer, 0);
            float fM9687constructorimpl = Dp.m9687constructorimpl(Dp.m9687constructorimpl(ComposeUtilsKt.toDp(Constraints.m9640getMaxWidthimpl(BoxWithConstraints.mo1099getConstraintsmsEJaDk()), composer, 0) - CaptureModeItemWidth) / 2);
            Modifier modifierTestTag = TestTagKt.testTag(Modifier.INSTANCE, "CaptureModeSwitcherLazyRow");
            PaddingValues paddingValuesM1213PaddingValuesYgX7TsA$default = PaddingKt.m1213PaddingValuesYgX7TsA$default(fM9687constructorimpl, 0.0f, 2, null);
            Arrangement.HorizontalOrVertical horizontalOrVerticalM1073spacedBy0680j_4 = Arrangement.INSTANCE.m1073spacedBy0680j_4(Dp.m9687constructorimpl(4));
            Alignment.Vertical centerVertically = Alignment.INSTANCE.getCenterVertically();
            FlingBehavior flingBehaviorRememberSnapFlingBehavior = LazyListSnapLayoutInfoProviderKt.rememberSnapFlingBehavior(lazyListState, SnapPosition.Center.INSTANCE, composer, 48, 0);
            ComposerKt.sourceInformationMarkerStart(composer, 2013759867, "CC(remember):CaptureModeSwitcher.kt#9igjgp");
            boolean zChangedInstance = composer.changedInstance(list) | composer.changedInstance(coroutineScope) | composer.changed(lazyListState);
            Object objRememberedValue = composer.rememberedValue();
            if (zChangedInstance || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                objRememberedValue = new Function1() { // from class: com.box.android.capture.widget.CaptureModeSwitcherKt$$ExternalSyntheticLambda3
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return CaptureModeSwitcherKt.CaptureModeSwitcher$lambda$8$0$0(list, coroutineScope, lazyListState, mutableState, (LazyListScope) obj);
                    }
                };
                composer.updateRememberedValue(objRememberedValue);
            }
            ComposerKt.sourceInformationMarkerEnd(composer);
            LazyDslKt.LazyRow(modifierTestTag, lazyListState, paddingValuesM1213PaddingValuesYgX7TsA$default, false, horizontalOrVerticalM1073spacedBy0680j_4, centerVertically, flingBehaviorRememberSnapFlingBehavior, false, null, (Function1) objRememberedValue, composer, 221190, 392);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    private static final void ChangeCaptureModeEffect(final Store<CaptureReducer.State, CaptureReducer.Action> store, final Function1<? super CaptureMode, Unit> function1, Composer composer, final int i) {
        int i2;
        Composer composerStartRestartGroup = composer.startRestartGroup(-1998152465);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(ChangeCaptureModeEffect)N(store,onModeChange)138@5730L29,139@5786L251,139@5764L273:CaptureModeSwitcher.kt#3i2u6z");
        if ((i & 6) == 0) {
            i2 = (composerStartRestartGroup.changed(store) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 48) == 0) {
            i2 |= composerStartRestartGroup.changedInstance(function1) ? 32 : 16;
        }
        if (!composerStartRestartGroup.shouldExecute((i2 & 19) != 18, i2 & 1)) {
            composerStartRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1998152465, i2, -1, "com.box.android.capture.widget.ChangeCaptureModeEffect (CaptureModeSwitcher.kt:137)");
            }
            State stateCollectAsStateWithLifecycle = FlowExtKt.collectAsStateWithLifecycle(store.getState(), (LifecycleOwner) null, (Lifecycle.State) null, (CoroutineContext) null, composerStartRestartGroup, 0, 7);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -374130550, "CC(remember):CaptureModeSwitcher.kt#9igjgp");
            boolean zChanged = composerStartRestartGroup.changed(stateCollectAsStateWithLifecycle) | ((i2 & 112) == 32);
            CaptureModeSwitcherKt$ChangeCaptureModeEffect$1$1 captureModeSwitcherKt$ChangeCaptureModeEffect$1$1RememberedValue = composerStartRestartGroup.rememberedValue();
            if (zChanged || captureModeSwitcherKt$ChangeCaptureModeEffect$1$1RememberedValue == Composer.INSTANCE.getEmpty()) {
                captureModeSwitcherKt$ChangeCaptureModeEffect$1$1RememberedValue = new CaptureModeSwitcherKt$ChangeCaptureModeEffect$1$1(stateCollectAsStateWithLifecycle, function1, null);
                composerStartRestartGroup.updateRememberedValue(captureModeSwitcherKt$ChangeCaptureModeEffect$1$1RememberedValue);
            }
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            EffectsKt.LaunchedEffect(store, (Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object>) captureModeSwitcherKt$ChangeCaptureModeEffect$1$1RememberedValue, composerStartRestartGroup, i2 & 14);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.box.android.capture.widget.CaptureModeSwitcherKt$$ExternalSyntheticLambda1
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return CaptureModeSwitcherKt.ChangeCaptureModeEffect$lambda$2(store, function1, i, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    private static final void ChangeCenteredItemIndexEffect(final LazyListState lazyListState, final Function1<? super Integer, Unit> function1, Composer composer, final int i) {
        int i2;
        Composer composerStartRestartGroup = composer.startRestartGroup(467085615);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(ChangeCenteredItemIndexEffect)N(listState,onIndexChange)151@6183L647,151@6157L673:CaptureModeSwitcher.kt#3i2u6z");
        if ((i & 6) == 0) {
            i2 = (composerStartRestartGroup.changed(lazyListState) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 48) == 0) {
            i2 |= composerStartRestartGroup.changedInstance(function1) ? 32 : 16;
        }
        if (!composerStartRestartGroup.shouldExecute((i2 & 19) != 18, i2 & 1)) {
            composerStartRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(467085615, i2, -1, "com.box.android.capture.widget.ChangeCenteredItemIndexEffect (CaptureModeSwitcher.kt:150)");
            }
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -2102285514, "CC(remember):CaptureModeSwitcher.kt#9igjgp");
            int i3 = i2 & 14;
            boolean z = (i3 == 4) | ((i2 & 112) == 32);
            CaptureModeSwitcherKt$ChangeCenteredItemIndexEffect$1$1 captureModeSwitcherKt$ChangeCenteredItemIndexEffect$1$1RememberedValue = composerStartRestartGroup.rememberedValue();
            if (z || captureModeSwitcherKt$ChangeCenteredItemIndexEffect$1$1RememberedValue == Composer.INSTANCE.getEmpty()) {
                captureModeSwitcherKt$ChangeCenteredItemIndexEffect$1$1RememberedValue = new CaptureModeSwitcherKt$ChangeCenteredItemIndexEffect$1$1(lazyListState, function1, null);
                composerStartRestartGroup.updateRememberedValue(captureModeSwitcherKt$ChangeCenteredItemIndexEffect$1$1RememberedValue);
            }
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            EffectsKt.LaunchedEffect(lazyListState, (Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object>) captureModeSwitcherKt$ChangeCenteredItemIndexEffect$1$1RememberedValue, composerStartRestartGroup, i3);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.box.android.capture.widget.CaptureModeSwitcherKt$$ExternalSyntheticLambda0
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return CaptureModeSwitcherKt.ChangeCenteredItemIndexEffect$lambda$1(lazyListState, function1, i, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    private static final void CaptureModeHighlight(Composer composer, final int i) {
        Composer composerStartRestartGroup = composer.startRestartGroup(-506536516);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(CaptureModeHighlight)174@6887L301:CaptureModeSwitcher.kt#3i2u6z");
        if (!composerStartRestartGroup.shouldExecute(i != 0, i & 1)) {
            composerStartRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-506536516, i, -1, "com.box.android.capture.widget.CaptureModeHighlight (CaptureModeSwitcher.kt:173)");
            }
            BoxKt.Box(BackgroundKt.m588backgroundbw27NRU(SizeKt.m1268sizeVpY3zN4(Modifier.INSTANCE, CaptureModeItemWidth, CaptureModeItemHeight), BoxColorPalette.INSTANCE.m11388getORANGE0d7_KjU(), RoundedCornerShapeKt.m1573RoundedCornerShape0680j_4(Dp.m9687constructorimpl(12))), composerStartRestartGroup, 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.box.android.capture.widget.CaptureModeSwitcherKt$$ExternalSyntheticLambda4
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return CaptureModeSwitcherKt.CaptureModeHighlight$lambda$0(i, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void CaptureModeItem(final CaptureMode captureMode, final Function0<Unit> function0, Composer composer, final int i) {
        int i2;
        Composer composer2;
        Composer composerStartRestartGroup = composer.startRestartGroup(-1759994200);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(CaptureModeItem)N(item,onClick)196@7497L39,189@7278L537:CaptureModeSwitcher.kt#3i2u6z");
        if ((i & 6) == 0) {
            i2 = (composerStartRestartGroup.changed(captureMode.ordinal()) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 48) == 0) {
            i2 |= composerStartRestartGroup.changedInstance(function0) ? 32 : 16;
        }
        int i3 = i2;
        if (!composerStartRestartGroup.shouldExecute((i3 & 19) != 18, i3 & 1)) {
            composer2 = composerStartRestartGroup;
            composer2.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1759994200, i3, -1, "com.box.android.capture.widget.CaptureModeItem (CaptureModeSwitcher.kt:188)");
            }
            Modifier modifierM1268sizeVpY3zN4 = SizeKt.m1268sizeVpY3zN4(Modifier.INSTANCE, CaptureModeItemWidth, CaptureModeItemHeight);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 862697583, "CC(remember):CaptureModeSwitcher.kt#9igjgp");
            Object objRememberedValue = composerStartRestartGroup.rememberedValue();
            if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
            }
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            Modifier modifierM628clickableO2vRcR0$default = ClickableKt.m628clickableO2vRcR0$default(modifierM1268sizeVpY3zN4, (MutableInteractionSource) objRememberedValue, null, false, null, null, function0, 28, null);
            Alignment center = Alignment.INSTANCE.getCenter();
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1042775818, "CC(Box)N(modifier,contentAlignment,propagateMinConstraints,content)71@3424L131:Box.kt#2w3rfo");
            MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(center, false);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
            int iHashCode = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
            CompositionLocalMap currentCompositionLocalMap = composerStartRestartGroup.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierM628clickableO2vRcR0$default);
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
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1219850934, "C203@7712L7,202@7682L127:CaptureModeSwitcher.kt#3i2u6z");
            composer2 = composerStartRestartGroup;
            TextKt.m4494TextNvy7gAk(label(captureMode, composerStartRestartGroup, i3 & 14), null, Color.INSTANCE.m6851getWhite0d7_KjU(), null, 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, BoxTypography.INSTANCE.getBoxNormal13(), composer2, 384, 0, 131066);
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
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.box.android.capture.widget.CaptureModeSwitcherKt$$ExternalSyntheticLambda2
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return CaptureModeSwitcherKt.CaptureModeItem$lambda$2(captureMode, function0, i, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    private static final String label(CaptureMode captureMode, Composer composer, int i) {
        int i2;
        ComposerKt.sourceInformationMarkerStart(composer, 1663664519, "C(label)211@7873L287:CaptureModeSwitcher.kt#3i2u6z");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1663664519, i, -1, "com.box.android.capture.widget.label (CaptureModeSwitcher.kt:211)");
        }
        int i3 = WhenMappings.$EnumSwitchMapping$0[captureMode.ordinal()];
        if (i3 == 1) {
            i2 = R.string.box_capture_video_label;
        } else if (i3 == 2) {
            i2 = R.string.box_capture_photo_label;
        } else if (i3 == 3) {
            i2 = R.string.box_capture_scan_label;
        } else {
            if (i3 != 4) {
                throw new NoWhenBranchMatchedException();
            }
            i2 = R.string.box_capture_audio_label;
        }
        String upperCase = StringResources_androidKt.stringResource(i2, composer, 0).toUpperCase(Locale.ROOT);
        Intrinsics.checkNotNullExpressionValue(upperCase, "toUpperCase(...)");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return upperCase;
    }

    private static final void CaptureModeSwitcherPreview(Composer composer, final int i) {
        Composer composerStartRestartGroup = composer.startRestartGroup(-185273239);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(CaptureModeSwitcherPreview)235@8649L369:CaptureModeSwitcher.kt#3i2u6z");
        if (!composerStartRestartGroup.shouldExecute(i != 0, i & 1)) {
            composerStartRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-185273239, i, -1, "com.box.android.capture.widget.CaptureModeSwitcherPreview (CaptureModeSwitcher.kt:224)");
            }
            CaptureReducer.State state = new CaptureReducer.State(CaptureMode.PHOTO, null, null, null, false, false, false, UninitializedCaptureModeState.INSTANCE, false, null, ViewUtils.EDGE_TO_EDGE_FLAGS, null);
            Modifier modifierM1220paddingVpY3zN4$default = PaddingKt.m1220paddingVpY3zN4$default(BackgroundKt.m589backgroundbw27NRU$default(SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null), Color.INSTANCE.m6840getBlack0d7_KjU(), null, 2, null), 0.0f, Dp.m9687constructorimpl(16), 1, null);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1042775818, "CC(Box)N(modifier,contentAlignment,propagateMinConstraints,content)71@3424L131:Box.kt#2w3rfo");
            MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), false);
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
            Updater.m6070setimpl(composerM6062constructorimpl, measurePolicyMaybeCachedBoxMeasurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
            Updater.m6070setimpl(composerM6062constructorimpl, currentCompositionLocalMap, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
            Updater.m6066initimpl(composerM6062constructorimpl, Integer.valueOf(iHashCode), ComposeUiNode.INSTANCE.getSetCompositeKeyHash());
            Updater.m6068reconcileimpl(composerM6062constructorimpl, ComposeUiNode.INSTANCE.getApplyOnDeactivatedNodeAssertion());
            Updater.m6070setimpl(composerM6062constructorimpl, modifierMaterializeModifier, ComposeUiNode.INSTANCE.getSetModifier());
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1833054614, "C72@3469L9:Box.kt#2w3rfo");
            BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -223484958, "C245@8964L24,241@8802L210:CaptureModeSwitcher.kt#3i2u6z");
            EmptyReducer emptyReducer = new EmptyReducer();
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 773894976, "CC(rememberCoroutineScope)N(getContext)600@27430L68:Effects.kt#9igjgp");
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 683736516, "CC(remember):Effects.kt#9igjgp");
            Object objRememberedValue = composerStartRestartGroup.rememberedValue();
            if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                objRememberedValue = EffectsKt.createCompositionCoroutineScope(EmptyCoroutineContext.INSTANCE, composerStartRestartGroup);
                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
            }
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            CaptureModeSwitcher(new Store(state, null, emptyReducer, (CoroutineScope) objRememberedValue, null, 18, null), composerStartRestartGroup, 0);
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
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.box.android.capture.widget.CaptureModeSwitcherKt$$ExternalSyntheticLambda10
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return CaptureModeSwitcherKt.CaptureModeSwitcherPreview$lambda$1(i, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit CaptureModeSwitcher$lambda$8$0$0(final List list, final CoroutineScope coroutineScope, final LazyListState lazyListState, final MutableState mutableState, LazyListScope LazyRow) {
        Intrinsics.checkNotNullParameter(LazyRow, "$this$LazyRow");
        LazyRow.items(list.size(), null, new Function1<Integer, Object>() { // from class: com.box.android.capture.widget.CaptureModeSwitcherKt$CaptureModeSwitcher$lambda$8$0$0$$inlined$itemsIndexed$default$2
            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Object invoke(Integer num) {
                return invoke(num.intValue());
            }

            public final Object invoke(int i) {
                list.get(i);
                return null;
            }
        }, ComposableLambdaKt.composableLambdaInstance(2039820996, true, new Function4<LazyItemScope, Integer, Composer, Integer, Unit>() { // from class: com.box.android.capture.widget.CaptureModeSwitcherKt$CaptureModeSwitcher$lambda$8$0$0$$inlined$itemsIndexed$default$3
            @Override // kotlin.jvm.functions.Function4
            public /* bridge */ /* synthetic */ Unit invoke(LazyItemScope lazyItemScope, Integer num, Composer composer, Integer num2) {
                invoke(lazyItemScope, num.intValue(), composer, num2.intValue());
                return Unit.INSTANCE;
            }

            public final void invoke(LazyItemScope lazyItemScope, final int i, Composer composer, int i2) {
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
                boolean z = true;
                if (!composer.shouldExecute((i3 & Token.DOTQUERY) != 146, i3 & 1)) {
                    composer.skipToGroupEnd();
                    return;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(2039820996, i3, -1, "androidx.compose.foundation.lazy.itemsIndexed.<anonymous> (LazyDsl.kt:214)");
                }
                CaptureMode captureMode = (CaptureMode) list.get(i);
                composer.startReplaceGroup(414404369);
                ComposerKt.sourceInformation(composer, "CN(index,item)*124@5273L230,122@5193L328:CaptureModeSwitcher.kt#3i2u6z");
                ComposerKt.sourceInformationMarkerStart(composer, -817913648, "CC(remember):CaptureModeSwitcher.kt#9igjgp");
                boolean zChangedInstance = composer.changedInstance(coroutineScope) | composer.changed(lazyListState);
                if ((((i3 & 112) ^ 48) <= 32 || !composer.changed(i)) && (i3 & 48) != 32) {
                    z = false;
                }
                boolean z2 = zChangedInstance | z;
                Object objRememberedValue = composer.rememberedValue();
                if (z2 || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                    final CoroutineScope coroutineScope2 = coroutineScope;
                    final MutableState mutableState2 = mutableState;
                    final LazyListState lazyListState2 = lazyListState;
                    objRememberedValue = (Function0) new Function0<Unit>() { // from class: com.box.android.capture.widget.CaptureModeSwitcherKt$CaptureModeSwitcher$3$1$1$1$1$1
                        @Override // kotlin.jvm.functions.Function0
                        public /* bridge */ /* synthetic */ Unit invoke() {
                            invoke2();
                            return Unit.INSTANCE;
                        }

                        /* JADX INFO: renamed from: com.box.android.capture.widget.CaptureModeSwitcherKt$CaptureModeSwitcher$3$1$1$1$1$1$1, reason: invalid class name */
                        /* JADX INFO: compiled from: CaptureModeSwitcher.kt */
                        @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
                        @DebugMetadata(c = "com.box.android.capture.widget.CaptureModeSwitcherKt$CaptureModeSwitcher$3$1$1$1$1$1$1", f = "CaptureModeSwitcher.kt", i = {}, l = {128}, m = "invokeSuspend", n = {}, s = {}, v = 1)
                        static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
                            final /* synthetic */ int $index;
                            final /* synthetic */ LazyListState $listState;
                            int label;

                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            AnonymousClass1(LazyListState lazyListState, int i, Continuation<? super AnonymousClass1> continuation) {
                                super(2, continuation);
                                this.$listState = lazyListState;
                                this.$index = i;
                            }

                            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                            public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                                return new AnonymousClass1(this.$listState, this.$index, continuation);
                            }

                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                                return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
                            }

                            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                            public final Object invokeSuspend(Object obj) {
                                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                                int i = this.label;
                                if (i == 0) {
                                    ResultKt.throwOnFailure(obj);
                                    this.label = 1;
                                    if (LazyListState.animateScrollToItem$default(this.$listState, this.$index, 0, this, 2, null) == coroutine_suspended) {
                                        return coroutine_suspended;
                                    }
                                } else {
                                    if (i != 1) {
                                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                                    }
                                    ResultKt.throwOnFailure(obj);
                                }
                                return Unit.INSTANCE;
                            }
                        }

                        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                        public final void invoke2() {
                            Job jobCaptureModeSwitcher$lambda$6 = CaptureModeSwitcherKt.CaptureModeSwitcher$lambda$6(mutableState2);
                            if (jobCaptureModeSwitcher$lambda$6 != null) {
                                Job.DefaultImpls.cancel$default(jobCaptureModeSwitcher$lambda$6, (CancellationException) null, 1, (Object) null);
                            }
                            mutableState2.setValue(BuildersKt__Builders_commonKt.launch$default(coroutineScope2, null, null, new AnonymousClass1(lazyListState2, i, null), 3, null));
                        }
                    };
                    composer.updateRememberedValue(objRememberedValue);
                }
                ComposerKt.sourceInformationMarkerEnd(composer);
                CaptureModeSwitcherKt.CaptureModeItem(captureMode, (Function0) objRememberedValue, composer, 0);
                composer.endReplaceGroup();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
            }
        }));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final CaptureReducer.State ChangeCaptureModeEffect$lambda$0(State<CaptureReducer.State> state) {
        return state.getValue();
    }
}
