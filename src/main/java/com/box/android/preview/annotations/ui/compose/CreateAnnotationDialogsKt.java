package com.box.android.preview.annotations.ui.compose;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.State;
import androidx.compose.ui.res.StringResources_androidKt;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.compose.FlowExtKt;
import com.box.android.base.compose.dialog.BoxProgressDialogKt;
import com.box.android.cpl.Store;
import com.box.android.preview.R;
import com.box.android.preview.annotations.cpl.CreateAnnotationReducer;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;

/* JADX INFO: compiled from: CreateAnnotationDialogs.kt */
/* JADX INFO: loaded from: classes12.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a#\u0010\u0000\u001a\u00020\u00012\u0014\u0010\u0002\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0003H\u0007¢\u0006\u0002\u0010\u0006¨\u0006\u0007²\u0006\n\u0010\b\u001a\u00020\u0004X\u008a\u0084\u0002"}, d2 = {"CreateAnnotationDialogs", "", "store", "Lcom/box/android/cpl/Store;", "Lcom/box/android/preview/annotations/cpl/CreateAnnotationReducer$State;", "Lcom/box/android/preview/annotations/cpl/CreateAnnotationReducer$Action;", "(Lcom/box/android/cpl/Store;Landroidx/compose/runtime/Composer;I)V", "preview_generalProdRelease", "state"}, k = 2, mv = {2, 2, 0}, xi = 48)
public final class CreateAnnotationDialogsKt {
    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit CreateAnnotationDialogs$lambda$0(Store store, int i, Composer composer, int i2) {
        CreateAnnotationDialogs(store, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit CreateAnnotationDialogs$lambda$4(Store store, int i, Composer composer, int i2) {
        CreateAnnotationDialogs(store, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    public static final void CreateAnnotationDialogs(final Store<CreateAnnotationReducer.State, CreateAnnotationReducer.Action> store, Composer composer, final int i) {
        int i2;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        Function2<? super Composer, ? super Integer, Unit> function2;
        Composer composerStartRestartGroup = composer.startRestartGroup(2053649278);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(CreateAnnotationDialogs)N(store)18@679L29:CreateAnnotationDialogs.kt#sozp7t");
        if ((i & 6) == 0) {
            i2 = (composerStartRestartGroup.changed(store) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if (composerStartRestartGroup.shouldExecute((i2 & 3) != 2, i2 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(2053649278, i2, -1, "com.box.android.preview.annotations.ui.compose.CreateAnnotationDialogs (CreateAnnotationDialogs.kt:13)");
            }
            if (store == null) {
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup == null) {
                    return;
                } else {
                    function2 = new Function2() { // from class: com.box.android.preview.annotations.ui.compose.CreateAnnotationDialogsKt$$ExternalSyntheticLambda0
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return CreateAnnotationDialogsKt.CreateAnnotationDialogs$lambda$0(store, i, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    };
                }
            } else {
                State stateCollectAsStateWithLifecycle = FlowExtKt.collectAsStateWithLifecycle(store.getState(), (LifecycleOwner) null, (Lifecycle.State) null, (CoroutineContext) null, composerStartRestartGroup, 0, 7);
                if (!CreateAnnotationDialogs$lambda$1(stateCollectAsStateWithLifecycle).getShowPendingAnnotationWarning()) {
                    composerStartRestartGroup.startReplaceGroup(-1544030268);
                } else {
                    composerStartRestartGroup.startReplaceGroup(-1543272256);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "22@829L83,25@947L83,21@764L276");
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -2127990767, "CC(remember):CreateAnnotationDialogs.kt#9igjgp");
                    int i3 = i2 & 14;
                    boolean z = i3 == 4;
                    Object objRememberedValue = composerStartRestartGroup.rememberedValue();
                    if (z || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                        objRememberedValue = new Function0() { // from class: com.box.android.preview.annotations.ui.compose.CreateAnnotationDialogsKt$$ExternalSyntheticLambda1
                            @Override // kotlin.jvm.functions.Function0
                            public final Object invoke() {
                                return CreateAnnotationDialogsKt.CreateAnnotationDialogs$lambda$2$0(store);
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                    }
                    Function0 function0 = (Function0) objRememberedValue;
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -2127986991, "CC(remember):CreateAnnotationDialogs.kt#9igjgp");
                    boolean z2 = i3 == 4;
                    Object objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                    if (z2 || objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                        objRememberedValue2 = new Function0() { // from class: com.box.android.preview.annotations.ui.compose.CreateAnnotationDialogsKt$$ExternalSyntheticLambda2
                            @Override // kotlin.jvm.functions.Function0
                            public final Object invoke() {
                                return CreateAnnotationDialogsKt.CreateAnnotationDialogs$lambda$3$0(store);
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                    }
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    PendingAnnotationsConfirmationDialogKt.PendingAnnotationsConfirmationDialog(function0, (Function0) objRememberedValue2, composerStartRestartGroup, 0);
                }
                composerStartRestartGroup.endReplaceGroup();
                if (!CreateAnnotationDialogs$lambda$1(stateCollectAsStateWithLifecycle).isSavingInProcess()) {
                    composerStartRestartGroup.startReplaceGroup(-1544030268);
                } else {
                    composerStartRestartGroup.startReplaceGroup(-1542955622);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "31@1108L39,31@1090L58");
                    BoxProgressDialogKt.BoxProgressDialog(StringResources_androidKt.stringResource(R.string.saving_comment, composerStartRestartGroup, 0), composerStartRestartGroup, 0);
                }
                composerStartRestartGroup.endReplaceGroup();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
            }
            scopeUpdateScopeEndRestartGroup.updateScope(function2);
        }
        composerStartRestartGroup.skipToGroupEnd();
        scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            function2 = new Function2() { // from class: com.box.android.preview.annotations.ui.compose.CreateAnnotationDialogsKt$$ExternalSyntheticLambda3
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return CreateAnnotationDialogsKt.CreateAnnotationDialogs$lambda$4(store, i, (Composer) obj, ((Integer) obj2).intValue());
                }
            };
            scopeUpdateScopeEndRestartGroup.updateScope(function2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit CreateAnnotationDialogs$lambda$2$0(Store store) {
        store.send(CreateAnnotationReducer.Action.RemovePendingAnnotationConfirmed.INSTANCE);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit CreateAnnotationDialogs$lambda$3$0(Store store) {
        store.send(CreateAnnotationReducer.Action.RemovePendingAnnotationCancelled.INSTANCE);
        return Unit.INSTANCE;
    }

    private static final CreateAnnotationReducer.State CreateAnnotationDialogs$lambda$1(State<CreateAnnotationReducer.State> state) {
        return state.getValue();
    }
}
