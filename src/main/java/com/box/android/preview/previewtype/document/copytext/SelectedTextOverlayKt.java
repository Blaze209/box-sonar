package com.box.android.preview.previewtype.document.copytext;

import android.graphics.PointF;
import android.graphics.RectF;
import androidx.compose.foundation.layout.RowScope;
import androidx.compose.material3.SnackbarHostState;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.State;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.platform.TestTagKt;
import androidx.compose.ui.res.StringResources_androidKt;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.compose.FlowExtKt;
import com.box.android.base.compose.SnackbarMessageKt;
import com.box.android.base.presentation.components.CopyTextReducer;
import com.box.android.cpl.Store;
import com.box.android.preview.R;
import com.box.android.preview.document.copytext.CopySelectedTextReducer;
import com.box.android.preview.preview.PreviewPopupKt;
import com.facebook.react.uimanager.ViewProps;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: compiled from: SelectedTextOverlay.kt */
/* JADX INFO: loaded from: classes12.dex */
@Metadata(d1 = {"\u00002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a;\u0010\u0000\u001a\u00020\u00012\u0012\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u00032\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u000bH\u0007¢\u0006\u0002\u0010\f\u001a\u001b\u0010\r\u001a\u00020\u00012\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00010\u000fH\u0007¢\u0006\u0002\u0010\u0010¨\u0006\u0011²\u0006\n\u0010\u0012\u001a\u00020\u0004X\u008a\u0084\u0002"}, d2 = {"SelectedTextOverlay", "", "store", "Lcom/box/android/cpl/Store;", "Lcom/box/android/preview/document/copytext/CopySelectedTextReducer$State;", "Lcom/box/android/preview/document/copytext/CopySelectedTextReducer$Action;", "documentViewHeight", "", "snackbarHostState", "Landroidx/compose/material3/SnackbarHostState;", "selectedTextViewBoundingBox", "Landroid/graphics/RectF;", "(Lcom/box/android/cpl/Store;FLandroidx/compose/material3/SnackbarHostState;Landroid/graphics/RectF;Landroidx/compose/runtime/Composer;I)V", "SelectedTextPopupContent", ViewProps.ON_CLICK, "Lkotlin/Function0;", "(Lkotlin/jvm/functions/Function0;Landroidx/compose/runtime/Composer;I)V", "preview_generalProdRelease", "state"}, k = 2, mv = {2, 2, 0}, xi = 48)
public final class SelectedTextOverlayKt {
    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit SelectedTextOverlay$lambda$4(Store store, float f, SnackbarHostState snackbarHostState, RectF rectF, int i, Composer composer, int i2) {
        SelectedTextOverlay(store, f, snackbarHostState, rectF, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit SelectedTextPopupContent$lambda$0(Function0 function0, int i, Composer composer, int i2) {
        SelectedTextPopupContent(function0, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    public static final void SelectedTextOverlay(final Store<CopySelectedTextReducer.State, CopySelectedTextReducer.Action> store, final float f, final SnackbarHostState snackbarHostState, final RectF rectF, Composer composer, final int i) {
        int i2;
        Intrinsics.checkNotNullParameter(store, "store");
        Intrinsics.checkNotNullParameter(snackbarHostState, "snackbarHostState");
        Composer composerStartRestartGroup = composer.startRestartGroup(-1851633903);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(SelectedTextOverlay)N(store,documentViewHeight,snackbarHostState,selectedTextViewBoundingBox)34@1456L29,57@2314L24,59@2378L49,64@2594L132,58@2343L383:SelectedTextOverlay.kt#afh64s");
        if ((i & 6) == 0) {
            i2 = (composerStartRestartGroup.changed(store) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 48) == 0) {
            i2 |= composerStartRestartGroup.changed(f) ? 32 : 16;
        }
        if ((i & 384) == 0) {
            i2 |= composerStartRestartGroup.changed(snackbarHostState) ? 256 : 128;
        }
        if ((i & 3072) == 0) {
            i2 |= composerStartRestartGroup.changedInstance(rectF) ? 2048 : 1024;
        }
        int i3 = i2;
        if (!composerStartRestartGroup.shouldExecute((i3 & 1171) != 1170, i3 & 1)) {
            composerStartRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1851633903, i3, -1, "com.box.android.preview.previewtype.document.copytext.SelectedTextOverlay (SelectedTextOverlay.kt:33)");
            }
            State stateCollectAsStateWithLifecycle = FlowExtKt.collectAsStateWithLifecycle(store.getState(), (LifecycleOwner) null, (Lifecycle.State) null, (CoroutineContext) null, composerStartRestartGroup, 0, 7);
            if (SelectedTextOverlay$lambda$0(stateCollectAsStateWithLifecycle).getShowSelectedTextPopup()) {
                composerStartRestartGroup.startReplaceGroup(-1303708343);
                ComposerKt.sourceInformation(composerStartRestartGroup, "");
                if (SelectedTextOverlay$lambda$0(stateCollectAsStateWithLifecycle).getSelectedText() == null) {
                    composerStartRestartGroup.startReplaceGroup(-1760252968);
                } else {
                    composerStartRestartGroup.startReplaceGroup(-1760252967);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "");
                    if (rectF == null) {
                        composerStartRestartGroup.startReplaceGroup(240273942);
                        composerStartRestartGroup.endReplaceGroup();
                    } else {
                        composerStartRestartGroup.startReplaceGroup(240273943);
                        ComposerKt.sourceInformation(composerStartRestartGroup, "*46@2031L226,40@1787L470");
                        PreviewPopupKt.PreviewPopup(Alignment.INSTANCE.getBottomStart(), new PointF(rectF.centerX(), -((f - rectF.top) + 15)), null, ComposableLambdaKt.rememberComposableLambda(944203779, true, new Function3() { // from class: com.box.android.preview.previewtype.document.copytext.SelectedTextOverlayKt$$ExternalSyntheticLambda0
                            @Override // kotlin.jvm.functions.Function3
                            public final Object invoke(Object obj, Object obj2, Object obj3) {
                                return SelectedTextOverlayKt.SelectedTextOverlay$lambda$1$0$0(store, (RowScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                            }
                        }, composerStartRestartGroup, 54), composerStartRestartGroup, 3078, 4);
                        composerStartRestartGroup.endReplaceGroup();
                        Unit unit = Unit.INSTANCE;
                    }
                }
                composerStartRestartGroup.endReplaceGroup();
            } else {
                composerStartRestartGroup.startReplaceGroup(-1761817103);
            }
            composerStartRestartGroup.endReplaceGroup();
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 773894976, "CC(rememberCoroutineScope)N(getContext)600@27430L68:Effects.kt#9igjgp");
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 683736516, "CC(remember):Effects.kt#9igjgp");
            Object objRememberedValue = composerStartRestartGroup.rememberedValue();
            if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                objRememberedValue = EffectsKt.createCompositionCoroutineScope(EmptyCoroutineContext.INSTANCE, composerStartRestartGroup);
                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
            }
            CoroutineScope coroutineScope = (CoroutineScope) objRememberedValue;
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            String strStringResource = StringResources_androidKt.stringResource(R.string.text_copied_to_clipboard, composerStartRestartGroup, 0);
            if (!SelectedTextOverlay$lambda$0(stateCollectAsStateWithLifecycle).getCopyTextState().getShowCopyNotification()) {
                strStringResource = null;
            }
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1303675627, "CC(remember):SelectedTextOverlay.kt#9igjgp");
            boolean z = (i3 & 14) == 4;
            Object objRememberedValue2 = composerStartRestartGroup.rememberedValue();
            if (z || objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                objRememberedValue2 = new Function0() { // from class: com.box.android.preview.previewtype.document.copytext.SelectedTextOverlayKt$$ExternalSyntheticLambda1
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return SelectedTextOverlayKt.SelectedTextOverlay$lambda$3$0(store);
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
            }
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            SnackbarMessageKt.SnackbarMessage(strStringResource, null, snackbarHostState, coroutineScope, null, (Function0) objRememberedValue2, composerStartRestartGroup, i3 & 896, 18);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.box.android.preview.previewtype.document.copytext.SelectedTextOverlayKt$$ExternalSyntheticLambda2
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return SelectedTextOverlayKt.SelectedTextOverlay$lambda$4(store, f, snackbarHostState, rectF, i, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit SelectedTextOverlay$lambda$1$0$0(final Store store, RowScope PreviewPopup, Composer composer, int i) {
        Intrinsics.checkNotNullParameter(PreviewPopup, "$this$PreviewPopup");
        ComposerKt.sourceInformation(composer, "C47@2078L161,47@2053L186:SelectedTextOverlay.kt#afh64s");
        if (!composer.shouldExecute((i & 17) != 16, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(944203779, i, -1, "com.box.android.preview.previewtype.document.copytext.SelectedTextOverlay.<anonymous>.<anonymous>.<anonymous> (SelectedTextOverlay.kt:47)");
            }
            ComposerKt.sourceInformationMarkerStart(composer, 1141733828, "CC(remember):SelectedTextOverlay.kt#9igjgp");
            boolean zChanged = composer.changed(store);
            Object objRememberedValue = composer.rememberedValue();
            if (zChanged || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                objRememberedValue = new Function0() { // from class: com.box.android.preview.previewtype.document.copytext.SelectedTextOverlayKt$$ExternalSyntheticLambda3
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return SelectedTextOverlayKt.SelectedTextOverlay$lambda$1$0$0$0$0(store);
                    }
                };
                composer.updateRememberedValue(objRememberedValue);
            }
            ComposerKt.sourceInformationMarkerEnd(composer);
            SelectedTextPopupContent((Function0) objRememberedValue, composer, 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit SelectedTextOverlay$lambda$1$0$0$0$0(Store store) {
        store.send(CopySelectedTextReducer.Action.CopySelectedText.INSTANCE);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit SelectedTextOverlay$lambda$3$0(Store store) {
        store.send(new CopySelectedTextReducer.Action.CopyTextAction(CopyTextReducer.Action.CopiedToClipboardNotificationShown.INSTANCE));
        return Unit.INSTANCE;
    }

    public static final void SelectedTextPopupContent(Function0<Unit> onClick, Composer composer, final int i) {
        int i2;
        final Function0<Unit> function0;
        Intrinsics.checkNotNullParameter(onClick, "onClick");
        Composer composerStartRestartGroup = composer.startRestartGroup(919784815);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(SelectedTextPopupContent)N(onClick)71@2798L323:SelectedTextOverlay.kt#afh64s");
        if ((i & 6) == 0) {
            i2 = (composerStartRestartGroup.changedInstance(onClick) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if (!composerStartRestartGroup.shouldExecute((i2 & 3) != 2, i2 & 1)) {
            function0 = onClick;
            composerStartRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(919784815, i2, -1, "com.box.android.preview.previewtype.document.copytext.SelectedTextPopupContent (SelectedTextOverlay.kt:70)");
            }
            function0 = onClick;
            PreviewPopupKt.PreviewPopupButton(function0, TestTagKt.testTag(Modifier.INSTANCE, "Preview:CopySelectedTextButton"), ComposableSingletons$SelectedTextOverlayKt.INSTANCE.getLambda$1481805436$preview_generalProdRelease(), composerStartRestartGroup, (i2 & 14) | 432, 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.box.android.preview.previewtype.document.copytext.SelectedTextOverlayKt$$ExternalSyntheticLambda4
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return SelectedTextOverlayKt.SelectedTextPopupContent$lambda$0(function0, i, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    private static final CopySelectedTextReducer.State SelectedTextOverlay$lambda$0(State<CopySelectedTextReducer.State> state) {
        return state.getValue();
    }
}
