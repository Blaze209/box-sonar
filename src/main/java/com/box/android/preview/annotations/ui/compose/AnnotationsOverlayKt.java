package com.box.android.preview.annotations.ui.compose;

import android.graphics.PointF;
import androidx.compose.foundation.layout.RowScope;
import androidx.compose.material3.SnackbarHostState;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.res.StringResources_androidKt;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.compose.FlowExtKt;
import com.box.android.base.compose.SnackbarMessageKt;
import com.box.android.base.compose.button.model.ButtonItem;
import com.box.android.base.compose.dialog.BoxAlertDialogKt;
import com.box.android.base.compose.dialog.BoxProgressDialogKt;
import com.box.android.cpl.Store;
import com.box.android.preview.R;
import com.box.android.preview.annotations.cpl.AnnotationsReducer;
import com.box.android.preview.annotations.model.AnnotationWithLocation;
import com.box.android.preview.preview.PreviewPopupKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: compiled from: AnnotationsOverlay.kt */
/* JADX INFO: loaded from: classes12.dex */
@Metadata(d1 = {"\u00002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a-\u0010\u0000\u001a\u00020\u00012\u0014\u0010\u0002\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0012\u0004\u0012\u00020\u00050\u00032\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0007¢\u0006\u0002\u0010\b\u001a+\u0010\t\u001a\u00020\u00012\u0014\u0010\u0002\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0012\u0004\u0012\u00020\u00050\u00032\u0006\u0010\n\u001a\u00020\u000bH\u0007¢\u0006\u0002\u0010\f\u001a\u0013\u0010\r\u001a\u0004\u0018\u00010\u000e*\u00020\u000fH\u0003¢\u0006\u0002\u0010\u0010¨\u0006\u0011"}, d2 = {"AnnotationsOverlay", "", "store", "Lcom/box/android/cpl/Store;", "Lcom/box/android/preview/annotations/cpl/AnnotationsReducer$State;", "Lcom/box/android/preview/annotations/cpl/AnnotationsReducer$Action;", "popupViewLocation", "Landroid/graphics/PointF;", "(Lcom/box/android/cpl/Store;Landroid/graphics/PointF;Landroidx/compose/runtime/Composer;I)V", "AnnotationMessaging", "snackbarHostState", "Landroidx/compose/material3/SnackbarHostState;", "(Lcom/box/android/cpl/Store;Landroidx/compose/material3/SnackbarHostState;Landroidx/compose/runtime/Composer;I)V", "getSnackbarMessage", "", "Lcom/box/android/preview/annotations/cpl/AnnotationsReducer$DeleteAnnotationState;", "(Lcom/box/android/preview/annotations/cpl/AnnotationsReducer$DeleteAnnotationState;Landroidx/compose/runtime/Composer;I)Ljava/lang/String;", "preview_generalProdRelease"}, k = 2, mv = {2, 2, 0}, xi = 48)
public final class AnnotationsOverlayKt {

    /* JADX INFO: compiled from: AnnotationsOverlay.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    public static final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[AnnotationsReducer.DeleteAnnotationState.values().length];
            try {
                iArr[AnnotationsReducer.DeleteAnnotationState.ConfirmationRequired.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[AnnotationsReducer.DeleteAnnotationState.InProgress.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[AnnotationsReducer.DeleteAnnotationState.Error.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[AnnotationsReducer.DeleteAnnotationState.Success.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit AnnotationMessaging$lambda$0(Store store, SnackbarHostState snackbarHostState, int i, Composer composer, int i2) {
        AnnotationMessaging(store, snackbarHostState, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit AnnotationMessaging$lambda$2(Store store, SnackbarHostState snackbarHostState, int i, Composer composer, int i2) {
        AnnotationMessaging(store, snackbarHostState, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit AnnotationsOverlay$lambda$0(Store store, PointF pointF, int i, Composer composer, int i2) {
        AnnotationsOverlay(store, pointF, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit AnnotationsOverlay$lambda$2(Store store, PointF pointF, int i, Composer composer, int i2) {
        AnnotationsOverlay(store, pointF, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    public static final void AnnotationsOverlay(final Store<AnnotationsReducer.State, AnnotationsReducer.Action> store, final PointF pointF, Composer composer, final int i) {
        int i2;
        final PointF pointF2;
        Intrinsics.checkNotNullParameter(store, "store");
        Composer composerStartRestartGroup = composer.startRestartGroup(902976672);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(AnnotationsOverlay)N(store,popupViewLocation)20@945L29:AnnotationsOverlay.kt#sozp7t");
        if ((i & 6) == 0) {
            i2 = (composerStartRestartGroup.changed(store) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 48) == 0) {
            i2 |= composerStartRestartGroup.changedInstance(pointF) ? 32 : 16;
        }
        if (!composerStartRestartGroup.shouldExecute((i2 & 19) != 18, i2 & 1)) {
            pointF2 = pointF;
            composerStartRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(902976672, i2, -1, "com.box.android.preview.annotations.ui.compose.AnnotationsOverlay (AnnotationsOverlay.kt:19)");
            }
            final AnnotationsReducer.State state = (AnnotationsReducer.State) FlowExtKt.collectAsStateWithLifecycle(store.getState(), (LifecycleOwner) null, (Lifecycle.State) null, (CoroutineContext) null, composerStartRestartGroup, 0, 7).getValue();
            if (state != null) {
                final AnnotationWithLocation selectedAnnotation = state.getSelectedAnnotation();
                if (selectedAnnotation == null) {
                    composerStartRestartGroup.startReplaceGroup(1198113200);
                    composerStartRestartGroup.endReplaceGroup();
                    pointF2 = pointF;
                } else {
                    composerStartRestartGroup.startReplaceGroup(1198113201);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "");
                    if (pointF == null) {
                        composerStartRestartGroup.startReplaceGroup(524826764);
                        composerStartRestartGroup.endReplaceGroup();
                        pointF2 = pointF;
                    } else {
                        composerStartRestartGroup.startReplaceGroup(524826765);
                        ComposerKt.sourceInformation(composerStartRestartGroup, "*26@1187L66,27@1268L651,24@1099L820");
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -2043671026, "CC(remember):AnnotationsOverlay.kt#9igjgp");
                        boolean z = (i2 & 14) == 4;
                        Object objRememberedValue = composerStartRestartGroup.rememberedValue();
                        if (z || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                            objRememberedValue = new Function0() { // from class: com.box.android.preview.annotations.ui.compose.AnnotationsOverlayKt$$ExternalSyntheticLambda4
                                @Override // kotlin.jvm.functions.Function0
                                public final Object invoke() {
                                    return AnnotationsOverlayKt.AnnotationsOverlay$lambda$1$0$0$0(store);
                                }
                            };
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                        }
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        pointF2 = pointF;
                        PreviewPopupKt.PreviewPopup(null, pointF2, (Function0) objRememberedValue, ComposableLambdaKt.rememberComposableLambda(1003935056, true, new Function3() { // from class: com.box.android.preview.annotations.ui.compose.AnnotationsOverlayKt$$ExternalSyntheticLambda5
                            @Override // kotlin.jvm.functions.Function3
                            public final Object invoke(Object obj, Object obj2, Object obj3) {
                                return AnnotationsOverlayKt.AnnotationsOverlay$lambda$1$0$1(selectedAnnotation, state, store, (RowScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                            }
                        }, composerStartRestartGroup, 54), composerStartRestartGroup, (i2 & 112) | 3072, 1);
                        composerStartRestartGroup.endReplaceGroup();
                        Unit unit = Unit.INSTANCE;
                    }
                    composerStartRestartGroup.endReplaceGroup();
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
            } else {
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.box.android.preview.annotations.ui.compose.AnnotationsOverlayKt$$ExternalSyntheticLambda3
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return AnnotationsOverlayKt.AnnotationsOverlay$lambda$0(store, pointF, i, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    });
                    return;
                }
                return;
            }
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup2 = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup2 != null) {
            scopeUpdateScopeEndRestartGroup2.updateScope(new Function2() { // from class: com.box.android.preview.annotations.ui.compose.AnnotationsOverlayKt$$ExternalSyntheticLambda6
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return AnnotationsOverlayKt.AnnotationsOverlay$lambda$2(store, pointF2, i, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit AnnotationsOverlay$lambda$1$0$0$0(Store store) {
        store.send(AnnotationsReducer.Action.AnnotationPopUpDismissed.INSTANCE);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit AnnotationsOverlay$lambda$1$0$1(final AnnotationWithLocation annotationWithLocation, AnnotationsReducer.State state, final Store store, RowScope PreviewPopup, Composer composer, int i) {
        Intrinsics.checkNotNullParameter(PreviewPopup, "$this$PreviewPopup");
        ComposerKt.sourceInformation(composer, "C30@1471L262,37@1771L116,28@1286L619:AnnotationsOverlay.kt#sozp7t");
        if (!composer.shouldExecute((i & 17) != 16, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1003935056, i, -1, "com.box.android.preview.annotations.ui.compose.AnnotationsOverlay.<anonymous>.<anonymous>.<anonymous> (AnnotationsOverlay.kt:28)");
            }
            boolean z = annotationWithLocation.getCanDeletePermission() && state.getDeleteAnnotationsEnabled();
            ComposerKt.sourceInformationMarkerStart(composer, -1586046026, "CC(remember):AnnotationsOverlay.kt#9igjgp");
            boolean zChanged = composer.changed(store) | composer.changedInstance(annotationWithLocation);
            Object objRememberedValue = composer.rememberedValue();
            if (zChanged || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                objRememberedValue = new Function0() { // from class: com.box.android.preview.annotations.ui.compose.AnnotationsOverlayKt$$ExternalSyntheticLambda0
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return AnnotationsOverlayKt.AnnotationsOverlay$lambda$1$0$1$0$0(store, annotationWithLocation);
                    }
                };
                composer.updateRememberedValue(objRememberedValue);
            }
            Function0 function0 = (Function0) objRememberedValue;
            ComposerKt.sourceInformationMarkerEnd(composer);
            ComposerKt.sourceInformationMarkerStart(composer, -1586036572, "CC(remember):AnnotationsOverlay.kt#9igjgp");
            boolean zChanged2 = composer.changed(store);
            Object objRememberedValue2 = composer.rememberedValue();
            if (zChanged2 || objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                objRememberedValue2 = new Function0() { // from class: com.box.android.preview.annotations.ui.compose.AnnotationsOverlayKt$$ExternalSyntheticLambda2
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return AnnotationsOverlayKt.AnnotationsOverlay$lambda$1$0$1$1$0(store);
                    }
                };
                composer.updateRememberedValue(objRememberedValue2);
            }
            ComposerKt.sourceInformationMarkerEnd(composer);
            AnnotationPopUpKt.AnnotationPopupContent(z, function0, (Function0) objRememberedValue2, composer, 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit AnnotationsOverlay$lambda$1$0$1$0$0(Store store, AnnotationWithLocation annotationWithLocation) {
        store.send(new AnnotationsReducer.Action.ViewComments(annotationWithLocation.getAnnotation().getAnnotationId()));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit AnnotationsOverlay$lambda$1$0$1$1$0(Store store) {
        store.send(AnnotationsReducer.Action.ShowDeletionConfirmationDialog.INSTANCE);
        return Unit.INSTANCE;
    }

    public static final void AnnotationMessaging(final Store<AnnotationsReducer.State, AnnotationsReducer.Action> store, final SnackbarHostState snackbarHostState, Composer composer, final int i) {
        int i2;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        Function2<? super Composer, ? super Integer, Unit> function2;
        boolean z;
        Intrinsics.checkNotNullParameter(store, "store");
        Intrinsics.checkNotNullParameter(snackbarHostState, "snackbarHostState");
        Composer composerStartRestartGroup = composer.startRestartGroup(581105623);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(AnnotationMessaging)N(store,snackbarHostState)48@2111L29,49@2182L24:AnnotationsOverlay.kt#sozp7t");
        if ((i & 6) == 0) {
            i2 = (composerStartRestartGroup.changed(store) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 48) == 0) {
            i2 |= composerStartRestartGroup.changed(snackbarHostState) ? 32 : 16;
        }
        if (!composerStartRestartGroup.shouldExecute((i2 & 19) != 18, i2 & 1)) {
            composerStartRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(581105623, i2, -1, "com.box.android.preview.annotations.ui.compose.AnnotationMessaging (AnnotationsOverlay.kt:47)");
            }
            AnnotationsReducer.State state = (AnnotationsReducer.State) FlowExtKt.collectAsStateWithLifecycle(store.getState(), (LifecycleOwner) null, (Lifecycle.State) null, (CoroutineContext) null, composerStartRestartGroup, 0, 7).getValue();
            if (state == null) {
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup == null) {
                    return;
                } else {
                    function2 = new Function2() { // from class: com.box.android.preview.annotations.ui.compose.AnnotationsOverlayKt$$ExternalSyntheticLambda7
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return AnnotationsOverlayKt.AnnotationMessaging$lambda$0(store, snackbarHostState, i, (Composer) obj, ((Integer) obj2).intValue());
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
                CoroutineScope coroutineScope = (CoroutineScope) objRememberedValue;
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                AnnotationsReducer.DeleteAnnotationState deleteAnnotationState = state.getDeleteAnnotationState();
                if (deleteAnnotationState == null) {
                    composerStartRestartGroup.startReplaceGroup(-1295221202);
                } else {
                    composerStartRestartGroup.startReplaceGroup(-1295221201);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "");
                    int i3 = WhenMappings.$EnumSwitchMapping$0[deleteAnnotationState.ordinal()];
                    if (i3 == 1) {
                        composerStartRestartGroup.startReplaceGroup(-177626465);
                        ComposerKt.sourceInformation(composerStartRestartGroup, "58@2639L72,62@2891L68,54@2406L734");
                        int i4 = R.string.delete_markup;
                        int i5 = R.string.delete_markup_confirm_message;
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1102656109, "CC(remember):AnnotationsOverlay.kt#9igjgp");
                        int i6 = i2 & 14;
                        boolean z2 = i6 == 4;
                        Object objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                        if (z2 || objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                            objRememberedValue2 = new Function0() { // from class: com.box.android.preview.annotations.ui.compose.AnnotationsOverlayKt$$ExternalSyntheticLambda8
                                @Override // kotlin.jvm.functions.Function0
                                public final Object invoke() {
                                    return AnnotationsOverlayKt.AnnotationMessaging$lambda$1$0$0(store);
                                }
                            };
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                        }
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        ButtonItem.TextButtonItem textButtonItem = new ButtonItem.TextButtonItem(false, (Function0) objRememberedValue2, R.string.pspdf__delete, 1, null);
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1102664169, "CC(remember):AnnotationsOverlay.kt#9igjgp");
                        z = i6 == 4;
                        Object objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                        if (z || objRememberedValue3 == Composer.INSTANCE.getEmpty()) {
                            objRememberedValue3 = new Function0() { // from class: com.box.android.preview.annotations.ui.compose.AnnotationsOverlayKt$$ExternalSyntheticLambda9
                                @Override // kotlin.jvm.functions.Function0
                                public final Object invoke() {
                                    return AnnotationsOverlayKt.AnnotationMessaging$lambda$1$1$0(store);
                                }
                            };
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                        }
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        BoxAlertDialogKt.m11705BoxAlertDialogSxpAMN0(i4, i5, textButtonItem, new ButtonItem.TextButtonItem(false, (Function0) objRememberedValue3, R.string.boxsdk_alert_dialog_cancel, 1, null), "AnnotationDeletionConfirmationDialog", null, 0L, 0L, composerStartRestartGroup, 24576, 224);
                        composerStartRestartGroup = composerStartRestartGroup;
                        composerStartRestartGroup.endReplaceGroup();
                    } else if (i3 == 2) {
                        composerStartRestartGroup.startReplaceGroup(-176817086);
                        ComposerKt.sourceInformation(composerStartRestartGroup, "71@3290L56,70@3241L123");
                        BoxProgressDialogKt.BoxProgressDialog(StringResources_androidKt.stringResource(R.string.annotation_deletion_in_progress, composerStartRestartGroup, 0), composerStartRestartGroup, 0);
                        composerStartRestartGroup.endReplaceGroup();
                    } else {
                        composerStartRestartGroup.startReplaceGroup(-176635271);
                        ComposerKt.sourceInformation(composerStartRestartGroup, "77@3487L20,80@3638L104,76@3418L324");
                        String snackbarMessage = getSnackbarMessage(deleteAnnotationState, composerStartRestartGroup, 0);
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1102688109, "CC(remember):AnnotationsOverlay.kt#9igjgp");
                        z = (i2 & 14) == 4;
                        Object objRememberedValue4 = composerStartRestartGroup.rememberedValue();
                        if (z || objRememberedValue4 == Composer.INSTANCE.getEmpty()) {
                            objRememberedValue4 = new Function0() { // from class: com.box.android.preview.annotations.ui.compose.AnnotationsOverlayKt$$ExternalSyntheticLambda10
                                @Override // kotlin.jvm.functions.Function0
                                public final Object invoke() {
                                    return AnnotationsOverlayKt.AnnotationMessaging$lambda$1$2$0(store);
                                }
                            };
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue4);
                        }
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        SnackbarMessageKt.SnackbarMessage(snackbarMessage, null, snackbarHostState, coroutineScope, null, (Function0) objRememberedValue4, composerStartRestartGroup, (i2 << 3) & 896, 18);
                        composerStartRestartGroup.endReplaceGroup();
                    }
                }
                composerStartRestartGroup.endReplaceGroup();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
            }
            scopeUpdateScopeEndRestartGroup.updateScope(function2);
        }
        scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            function2 = new Function2() { // from class: com.box.android.preview.annotations.ui.compose.AnnotationsOverlayKt$$ExternalSyntheticLambda1
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return AnnotationsOverlayKt.AnnotationMessaging$lambda$2(store, snackbarHostState, i, (Composer) obj, ((Integer) obj2).intValue());
                }
            };
            scopeUpdateScopeEndRestartGroup.updateScope(function2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit AnnotationMessaging$lambda$1$0$0(Store store) {
        store.send(AnnotationsReducer.Action.AnnotationDeletedUserConfirmed.INSTANCE);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit AnnotationMessaging$lambda$1$1$0(Store store) {
        store.send(AnnotationsReducer.Action.ResetDeleteAnnotationState.INSTANCE);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit AnnotationMessaging$lambda$1$2$0(Store store) {
        store.send(AnnotationsReducer.Action.ResetDeleteAnnotationState.INSTANCE);
        return Unit.INSTANCE;
    }

    private static final String getSnackbarMessage(AnnotationsReducer.DeleteAnnotationState deleteAnnotationState, Composer composer, int i) {
        Integer numValueOf;
        ComposerKt.sourceInformationMarkerStart(composer, 482056965, "C(getSnackbarMessage):AnnotationsOverlay.kt#sozp7t");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(482056965, i, -1, "com.box.android.preview.annotations.ui.compose.getSnackbarMessage (AnnotationsOverlay.kt:90)");
        }
        int i2 = WhenMappings.$EnumSwitchMapping$0[deleteAnnotationState.ordinal()];
        String strStringResource = null;
        if (i2 == 3) {
            numValueOf = Integer.valueOf(R.string.delete_annotation_error);
        } else {
            numValueOf = i2 != 4 ? null : Integer.valueOf(R.string.annotation_deleted_toast_text);
        }
        if (numValueOf == null) {
            composer.startReplaceGroup(-1411302046);
        } else {
            composer.startReplaceGroup(-1411302045);
            ComposerKt.sourceInformation(composer, "*94@4116L18");
            strStringResource = StringResources_androidKt.stringResource(numValueOf.intValue(), composer, 0);
        }
        composer.endReplaceGroup();
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return strStringResource;
    }
}
