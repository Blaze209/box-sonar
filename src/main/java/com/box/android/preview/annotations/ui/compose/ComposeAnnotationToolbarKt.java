package com.box.android.preview.annotations.ui.compose;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.layout.WindowInsetsPadding_androidKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.DisposableEffectResult;
import androidx.compose.runtime.DisposableEffectScope;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.ProvidableCompositionLocal;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.State;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.platform.AndroidCompositionLocals_androidKt;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.compose.FlowExtKt;
import com.box.android.base.compose.BoxSizes;
import com.box.android.base.compose.BoxTheme;
import com.box.android.base.compose.ComposeUtilsKt;
import com.box.android.cpl.Store;
import com.box.android.preview.R;
import com.box.android.preview.annotations.cpl.CreateAnnotationReducer;
import com.box.android.preview.annotations.managers.AnnotationsToolbarManager;
import com.box.android.preview.annotations.managers.BoxAnnotationMarkupType;
import com.box.android.preview.annotations.managers.BoxAnnotationTool;
import com.box.android.preview.annotations.managers.MarkupState;
import com.box.android.preview.annotations.ui.views.AnnotationToolbarView;
import com.box.android.preview.preview.PreviewUIDependencyProvider;
import external.sdk.pendo.io.mozilla.javascript.Token;
import java.util.Map;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: compiled from: ComposeAnnotationToolbar.kt */
/* JADX INFO: loaded from: classes12.dex */
@Metadata(d1 = {"\u0000$\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a3\u0010\u0000\u001a\u00020\u00012\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u00052\u0006\u0010\b\u001a\u00020\tH\u0007¢\u0006\u0002\u0010\n¨\u0006\u000b²\u0006\n\u0010\f\u001a\u00020\u0006X\u008a\u0084\u0002"}, d2 = {"ComposeAnnotationToolbar", "", "isVisible", "", "store", "Lcom/box/android/cpl/Store;", "Lcom/box/android/preview/annotations/cpl/CreateAnnotationReducer$State;", "Lcom/box/android/preview/annotations/cpl/CreateAnnotationReducer$Action;", "dependencyProvider", "Lcom/box/android/preview/preview/PreviewUIDependencyProvider;", "(ZLcom/box/android/cpl/Store;Lcom/box/android/preview/preview/PreviewUIDependencyProvider;Landroidx/compose/runtime/Composer;II)V", "preview_generalProdRelease", "state"}, k = 2, mv = {2, 2, 0}, xi = 48)
public final class ComposeAnnotationToolbarKt {

    /* JADX INFO: compiled from: ComposeAnnotationToolbar.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    public static final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[MarkupState.values().length];
            try {
                iArr[MarkupState.ACTIVE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[MarkupState.SWITCHING.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[MarkupState.EXITING.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[MarkupState.INACTIVE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ComposeAnnotationToolbar$lambda$5(boolean z, Store store, PreviewUIDependencyProvider previewUIDependencyProvider, int i, int i2, Composer composer, int i3) {
        ComposeAnnotationToolbar(z, store, previewUIDependencyProvider, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    public static final void ComposeAnnotationToolbar(boolean z, final Store<CreateAnnotationReducer.State, CreateAnnotationReducer.Action> store, final PreviewUIDependencyProvider dependencyProvider, Composer composer, final int i, final int i2) {
        boolean z2;
        int i3;
        final boolean z3;
        Object obj;
        final State state;
        Intrinsics.checkNotNullParameter(store, "store");
        Intrinsics.checkNotNullParameter(dependencyProvider, "dependencyProvider");
        Composer composerStartRestartGroup = composer.startRestartGroup(-391005480);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(ComposeAnnotationToolbar)N(isVisible,store,dependencyProvider)37@1673L7,38@1706L40,39@1776L29,40@1837L7,55@2349L1859,55@2326L1882,105@4240L147,105@4214L173,114@4508L264,114@4466L306:ComposeAnnotationToolbar.kt#sozp7t");
        int i4 = i2 & 1;
        if (i4 != 0) {
            i3 = i | 6;
            z2 = z;
        } else if ((i & 6) == 0) {
            z2 = z;
            i3 = (composerStartRestartGroup.changed(z2) ? 4 : 2) | i;
        } else {
            z2 = z;
            i3 = i;
        }
        if ((i & 48) == 0) {
            i3 |= composerStartRestartGroup.changed(store) ? 32 : 16;
        }
        if ((i & 384) == 0) {
            i3 |= composerStartRestartGroup.changed(dependencyProvider) ? 256 : 128;
        }
        if (!composerStartRestartGroup.shouldExecute((i3 & Token.DOTQUERY) != 146, i3 & 1)) {
            composerStartRestartGroup.skipToGroupEnd();
            z3 = z2;
        } else {
            if (i4 != 0) {
                z2 = true;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-391005480, i3, -1, "com.box.android.preview.annotations.ui.compose.ComposeAnnotationToolbar (ComposeAnnotationToolbar.kt:36)");
            }
            ProvidableCompositionLocal<LifecycleOwner> localLifecycleOwner = AndroidCompositionLocals_androidKt.getLocalLifecycleOwner();
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
            Object objConsume = composerStartRestartGroup.consume(localLifecycleOwner);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            final LifecycleOwner lifecycleOwner = (LifecycleOwner) objConsume;
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -2094102816, "CC(remember):ComposeAnnotationToolbar.kt#9igjgp");
            Object objRememberedValue = composerStartRestartGroup.rememberedValue();
            if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                objRememberedValue = new AnnotationsToolbarManager();
                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
            }
            final AnnotationsToolbarManager annotationsToolbarManager = (AnnotationsToolbarManager) objRememberedValue;
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            boolean z4 = true;
            State stateCollectAsStateWithLifecycle = FlowExtKt.collectAsStateWithLifecycle(store.getState(), (LifecycleOwner) null, (Lifecycle.State) null, (CoroutineContext) null, composerStartRestartGroup, 0, 7);
            ProvidableCompositionLocal<Context> localContext = AndroidCompositionLocals_androidKt.getLocalContext();
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
            Object objConsume2 = composerStartRestartGroup.consume(localContext);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            final Context context = (Context) objConsume2;
            if (z2) {
                composerStartRestartGroup.startReplaceGroup(-492423096);
                ComposerKt.sourceInformation(composerStartRestartGroup, "46@2028L6,50@2214L6,44@1965L274");
                BoxKt.Box(ComposeUtilsKt.m11640topBorderHht5A8o$default(SizeKt.fillMaxWidth$default(SizeKt.m1252height3ABfNKs(WindowInsetsPadding_androidKt.navigationBarsPadding(BackgroundKt.m589backgroundbw27NRU$default(Modifier.INSTANCE, BoxTheme.INSTANCE.getColors(composerStartRestartGroup, BoxTheme.$stable).m11581getTopLayerBackground0d7_KjU(), null, 2, null)), BoxSizes.INSTANCE.m11609getBottomBarHeightD9Ej5fM()), 0.0f, 1, null), BoxTheme.INSTANCE.getColors(composerStartRestartGroup, BoxTheme.$stable).m11517getDivider0d7_KjU(), 0.0f, 2, null), composerStartRestartGroup, 0);
            } else {
                composerStartRestartGroup.startReplaceGroup(-494372438);
            }
            composerStartRestartGroup.endReplaceGroup();
            Unit unit = Unit.INSTANCE;
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -2094080421, "CC(remember):ComposeAnnotationToolbar.kt#9igjgp");
            boolean zChangedInstance = composerStartRestartGroup.changedInstance(context) | composerStartRestartGroup.changedInstance(annotationsToolbarManager) | composerStartRestartGroup.changed(stateCollectAsStateWithLifecycle) | ((i3 & 896) == 256) | composerStartRestartGroup.changedInstance(lifecycleOwner) | ((i3 & 112) == 32);
            Object objRememberedValue2 = composerStartRestartGroup.rememberedValue();
            if (zChangedInstance || objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                state = stateCollectAsStateWithLifecycle;
                obj = new Function1() { // from class: com.box.android.preview.annotations.ui.compose.ComposeAnnotationToolbarKt$$ExternalSyntheticLambda3
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj2) {
                        return ComposeAnnotationToolbarKt.ComposeAnnotationToolbar$lambda$2$0(context, annotationsToolbarManager, dependencyProvider, lifecycleOwner, state, store, (DisposableEffectScope) obj2);
                    }
                };
                composerStartRestartGroup.updateRememberedValue(obj);
            } else {
                state = stateCollectAsStateWithLifecycle;
                obj = objRememberedValue2;
            }
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            EffectsKt.DisposableEffect(unit, (Function1<? super DisposableEffectScope, ? extends DisposableEffectResult>) obj, composerStartRestartGroup, 6);
            Boolean boolValueOf = Boolean.valueOf(z2);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -2094021621, "CC(remember):ComposeAnnotationToolbar.kt#9igjgp");
            int i5 = i3 & 14;
            if (i5 != 4) {
                z4 = false;
            }
            boolean zChangedInstance2 = composerStartRestartGroup.changedInstance(annotationsToolbarManager) | z4;
            ComposeAnnotationToolbarKt$ComposeAnnotationToolbar$2$1 composeAnnotationToolbarKt$ComposeAnnotationToolbar$2$1RememberedValue = composerStartRestartGroup.rememberedValue();
            if (zChangedInstance2 || composeAnnotationToolbarKt$ComposeAnnotationToolbar$2$1RememberedValue == Composer.INSTANCE.getEmpty()) {
                composeAnnotationToolbarKt$ComposeAnnotationToolbar$2$1RememberedValue = new ComposeAnnotationToolbarKt$ComposeAnnotationToolbar$2$1(z2, annotationsToolbarManager, null);
                composerStartRestartGroup.updateRememberedValue(composeAnnotationToolbarKt$ComposeAnnotationToolbar$2$1RememberedValue);
            }
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            EffectsKt.LaunchedEffect(boolValueOf, (Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object>) composeAnnotationToolbarKt$ComposeAnnotationToolbar$2$1RememberedValue, composerStartRestartGroup, i5);
            CreateAnnotationReducer.SwitchingMarkupTypeState switchingMarkupType = ComposeAnnotationToolbar$lambda$1(state).getSwitchingMarkupType();
            Boolean boolValueOf2 = switchingMarkupType != null ? Boolean.valueOf(switchingMarkupType.getConfirmed()) : null;
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -2094012928, "CC(remember):ComposeAnnotationToolbar.kt#9igjgp");
            boolean zChanged = composerStartRestartGroup.changed(boolValueOf2) | composerStartRestartGroup.changedInstance(annotationsToolbarManager) | composerStartRestartGroup.changed(state);
            ComposeAnnotationToolbarKt$ComposeAnnotationToolbar$3$1 composeAnnotationToolbarKt$ComposeAnnotationToolbar$3$1RememberedValue = composerStartRestartGroup.rememberedValue();
            if (zChanged || composeAnnotationToolbarKt$ComposeAnnotationToolbar$3$1RememberedValue == Composer.INSTANCE.getEmpty()) {
                composeAnnotationToolbarKt$ComposeAnnotationToolbar$3$1RememberedValue = new ComposeAnnotationToolbarKt$ComposeAnnotationToolbar$3$1(boolValueOf2, annotationsToolbarManager, state, null);
                composerStartRestartGroup.updateRememberedValue(composeAnnotationToolbarKt$ComposeAnnotationToolbar$3$1RememberedValue);
            }
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            EffectsKt.LaunchedEffect(boolValueOf2, (Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object>) composeAnnotationToolbarKt$ComposeAnnotationToolbar$3$1RememberedValue, composerStartRestartGroup, 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            z3 = z2;
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.box.android.preview.annotations.ui.compose.ComposeAnnotationToolbarKt$$ExternalSyntheticLambda4
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj2, Object obj3) {
                    return ComposeAnnotationToolbarKt.ComposeAnnotationToolbar$lambda$5(z3, store, dependencyProvider, i, i2, (Composer) obj2, ((Integer) obj3).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final DisposableEffectResult ComposeAnnotationToolbar$lambda$2$0(Context context, final AnnotationsToolbarManager annotationsToolbarManager, PreviewUIDependencyProvider previewUIDependencyProvider, LifecycleOwner lifecycleOwner, State state, final Store store, DisposableEffectScope DisposableEffect) {
        Intrinsics.checkNotNullParameter(DisposableEffect, "$this$DisposableEffect");
        FrameLayout frameLayout = new FrameLayout(context);
        View viewInflate = LayoutInflater.from(context).inflate(R.layout.annotation_toolbar_draw, (ViewGroup) frameLayout, false);
        View viewFindViewById = viewInflate.findViewById(R.id.visible_toolbar);
        if (viewFindViewById != null) {
            viewFindViewById.setBackground(null);
        }
        Intrinsics.checkNotNull(viewInflate);
        annotationsToolbarManager.setAnnotationToolbar(new AnnotationToolbarView(viewInflate, ComposeAnnotationToolbar$lambda$1(state).getAdditionalMarkups()));
        annotationsToolbarManager.setParent(frameLayout);
        for (Map.Entry<BoxAnnotationTool, Integer> entry : previewUIDependencyProvider.getCreateAnnotationManager(ComposeAnnotationToolbar$lambda$1(state).getItemId()).getColorHolderMap().entrySet()) {
            BoxAnnotationTool key = entry.getKey();
            int iIntValue = entry.getValue().intValue();
            AnnotationToolbarView annotationToolbar = annotationsToolbarManager.getAnnotationToolbar();
            if (annotationToolbar != null) {
                annotationToolbar.setColor(iIntValue, key);
            }
        }
        annotationsToolbarManager.getSelectedToolLiveData().observe(lifecycleOwner, new ComposeAnnotationToolbarKt$sam$androidx_lifecycle_Observer$0(new Function1() { // from class: com.box.android.preview.annotations.ui.compose.ComposeAnnotationToolbarKt$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return ComposeAnnotationToolbarKt.ComposeAnnotationToolbar$lambda$2$0$1(store, (BoxAnnotationTool) obj);
            }
        }));
        annotationsToolbarManager.getSelectedColorLiveData().observe(lifecycleOwner, new ComposeAnnotationToolbarKt$sam$androidx_lifecycle_Observer$0(new Function1() { // from class: com.box.android.preview.annotations.ui.compose.ComposeAnnotationToolbarKt$$ExternalSyntheticLambda1
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return ComposeAnnotationToolbarKt.ComposeAnnotationToolbar$lambda$2$0$2(store, (Pair) obj);
            }
        }));
        annotationsToolbarManager.getMarkupTypeLiveData().observe(lifecycleOwner, new ComposeAnnotationToolbarKt$sam$androidx_lifecycle_Observer$0(new Function1() { // from class: com.box.android.preview.annotations.ui.compose.ComposeAnnotationToolbarKt$$ExternalSyntheticLambda2
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return ComposeAnnotationToolbarKt.ComposeAnnotationToolbar$lambda$2$0$3(store, (Pair) obj);
            }
        }));
        annotationsToolbarManager.displayAnnotationToolbar();
        return new DisposableEffectResult() { // from class: com.box.android.preview.annotations.ui.compose.ComposeAnnotationToolbarKt$ComposeAnnotationToolbar$lambda$2$0$$inlined$onDispose$1
            @Override // androidx.compose.runtime.DisposableEffectResult
            public void dispose() {
                annotationsToolbarManager.exitCreationMode();
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ComposeAnnotationToolbar$lambda$2$0$1(Store store, BoxAnnotationTool boxAnnotationTool) {
        Intrinsics.checkNotNull(boxAnnotationTool);
        store.send(new CreateAnnotationReducer.Action.UpdateTool(boxAnnotationTool));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ComposeAnnotationToolbar$lambda$2$0$2(Store store, Pair pair) {
        store.send(new CreateAnnotationReducer.Action.UpdateColor(((Number) pair.getFirst()).intValue()));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ComposeAnnotationToolbar$lambda$2$0$3(Store store, Pair pair) {
        int i = WhenMappings.$EnumSwitchMapping$0[((MarkupState) pair.getFirst()).ordinal()];
        if (i == 1) {
            store.send(new CreateAnnotationReducer.Action.UpdateMarkUpType((BoxAnnotationMarkupType) pair.getSecond()));
        } else if (i == 2) {
            store.send(new CreateAnnotationReducer.Action.NewMarkupTypeSelected((BoxAnnotationMarkupType) pair.getSecond()));
        } else {
            if (i != 3 && i != 4) {
                throw new NoWhenBranchMatchedException();
            }
            store.send(CreateAnnotationReducer.Action.ExitSelected.INSTANCE);
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final CreateAnnotationReducer.State ComposeAnnotationToolbar$lambda$1(State<CreateAnnotationReducer.State> state) {
        return state.getValue();
    }
}
