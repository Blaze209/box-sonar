package com.box.android.browse.cpl.itemsList;

import android.app.Activity;
import android.content.Context;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.ProvidableCompositionLocal;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.State;
import androidx.compose.ui.platform.AndroidCompositionLocals_androidKt;
import androidx.core.app.NotificationCompat;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.compose.FlowExtKt;
import com.box.android.base.R;
import com.box.android.base.compose.button.model.ButtonItem;
import com.box.android.base.compose.dialog.BoxAlertDialogKt;
import com.box.android.base.presentation.components.fileactions.FileActionsError;
import com.box.android.base.presentation.components.fileactions.OfflineFilesReducer;
import com.box.android.base.presentation.components.fileactions.OfflineLargeFileErrorDialogKt;
import com.box.android.cpl.Store;
import com.microsoft.intune.mam.client.app.ui.MAMUIHelper;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.reflect.KFunction;

/* JADX INFO: compiled from: ActionableItemsListMessages.kt */
/* JADX INFO: loaded from: classes10.dex */
@Metadata(d1 = {"\u0000 \n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\u001a!\u0010\u0000\u001a\u00020\u00012\u0012\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003H\u0007¢\u0006\u0002\u0010\u0006\u001a+\u0010\u0007\u001a\u00020\u00012\b\b\u0001\u0010\b\u001a\u00020\t2\u0012\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003H\u0003¢\u0006\u0002\u0010\n¨\u0006\u000b²\u0006\n\u0010\f\u001a\u00020\u0004X\u008a\u0084\u0002"}, d2 = {"ActionableItemsListDialogs", "", "store", "Lcom/box/android/cpl/Store;", "Lcom/box/android/browse/cpl/itemsList/ActionableItemsListReducer$State;", "Lcom/box/android/browse/cpl/itemsList/ActionableItemsListReducer$Action;", "(Lcom/box/android/cpl/Store;Landroidx/compose/runtime/Composer;I)V", "FeatureDisabledDialog", NotificationCompat.CATEGORY_MESSAGE, "", "(ILcom/box/android/cpl/Store;Landroidx/compose/runtime/Composer;I)V", "browse_generalProdRelease", "state"}, k = 2, mv = {2, 2, 0}, xi = 48)
public final class ActionableItemsListMessagesKt {

    /* JADX INFO: compiled from: ActionableItemsListMessages.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    public static final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[FileActionsError.values().length];
            try {
                iArr[FileActionsError.LARGE_FILE_SIZE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[FileActionsError.ENCRYPTED_DEVICE_REQUIRED.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[FileActionsError.FEATURE_DISABLED.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[FileActionsError.SAVE_TO_LOCATION_NOT_ALLOWED.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ActionableItemsListDialogs$lambda$2(Store store, int i, Composer composer, int i2) {
        ActionableItemsListDialogs(store, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit FeatureDisabledDialog$lambda$1(int i, Store store, int i2, Composer composer, int i3) {
        FeatureDisabledDialog(i, store, composer, RecomposeScopeImplKt.updateChangedFlags(i2 | 1));
        return Unit.INSTANCE;
    }

    public static final void ActionableItemsListDialogs(final Store<ActionableItemsListReducer.State, ActionableItemsListReducer.Action> store, Composer composer, final int i) {
        int i2;
        Intrinsics.checkNotNullParameter(store, "store");
        Composer composerStartRestartGroup = composer.startRestartGroup(1290543808);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(ActionableItemsListDialogs)N(store)20@992L29:ActionableItemsListMessages.kt#j5t2uy");
        if ((i & 6) == 0) {
            i2 = (composerStartRestartGroup.changed(store) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if (!composerStartRestartGroup.shouldExecute((i2 & 3) != 2, i2 & 1)) {
            composerStartRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1290543808, i2, -1, "com.box.android.browse.cpl.itemsList.ActionableItemsListDialogs (ActionableItemsListMessages.kt:19)");
            }
            FileActionsError error = ActionableItemsListDialogs$lambda$0(FlowExtKt.collectAsStateWithLifecycle(store.getState(), (LifecycleOwner) null, (Lifecycle.State) null, (CoroutineContext) null, composerStartRestartGroup, 0, 7)).getError();
            int i3 = error != null ? WhenMappings.$EnumSwitchMapping$0[error.ordinal()] : -1;
            if (i3 == 1) {
                composerStartRestartGroup.startReplaceGroup(-1956399244);
                ComposerKt.sourceInformation(composerStartRestartGroup, "26@1266L53,23@1105L246");
                AnonymousClass1 anonymousClass1 = new PropertyReference1Impl() { // from class: com.box.android.browse.cpl.itemsList.ActionableItemsListMessagesKt.ActionableItemsListDialogs.1
                    @Override // kotlin.jvm.internal.PropertyReference1Impl, kotlin.reflect.KProperty1
                    public Object get(Object obj) {
                        return ((ActionableItemsListReducer.State) obj).getOfflineFilesState();
                    }
                };
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1032935595, "CC(remember):ActionableItemsListMessages.kt#9igjgp");
                ActionableItemsListMessagesKt$ActionableItemsListDialogs$2$1 actionableItemsListMessagesKt$ActionableItemsListDialogs$2$1RememberedValue = composerStartRestartGroup.rememberedValue();
                if (actionableItemsListMessagesKt$ActionableItemsListDialogs$2$1RememberedValue == Composer.INSTANCE.getEmpty()) {
                    actionableItemsListMessagesKt$ActionableItemsListDialogs$2$1RememberedValue = ActionableItemsListMessagesKt$ActionableItemsListDialogs$2$1.INSTANCE;
                    composerStartRestartGroup.updateRememberedValue(actionableItemsListMessagesKt$ActionableItemsListDialogs$2$1RememberedValue);
                }
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                OfflineLargeFileErrorDialogKt.OfflineLargeFileErrorDialog(store.ifScope(anonymousClass1, (Function1) ((KFunction) actionableItemsListMessagesKt$ActionableItemsListDialogs$2$1RememberedValue)), composerStartRestartGroup, 0);
                composerStartRestartGroup.endReplaceGroup();
            } else if (i3 == 2) {
                composerStartRestartGroup.startReplaceGroup(-1956080998);
                ComposerKt.sourceInformation(composerStartRestartGroup, "32@1431L80");
                FeatureDisabledDialog(R.string.Encrypted_device_requird_for_this_feature, store, composerStartRestartGroup, (i2 << 3) & 112);
                composerStartRestartGroup.endReplaceGroup();
            } else if (i3 == 3) {
                composerStartRestartGroup.startReplaceGroup(-1955930617);
                ComposerKt.sourceInformation(composerStartRestartGroup, "36@1582L99");
                FeatureDisabledDialog(R.string.This_feature_has_been_disabled_by_your_or_your_administrator, store, composerStartRestartGroup, (i2 << 3) & 112);
                composerStartRestartGroup.endReplaceGroup();
            } else if (i3 == 4) {
                composerStartRestartGroup.startReplaceGroup(-1955750972);
                ComposerKt.sourceInformation(composerStartRestartGroup, "40@1814L7");
                ProvidableCompositionLocal<Context> localContext = AndroidCompositionLocals_androidKt.getLocalContext();
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
                Object objConsume = composerStartRestartGroup.consume(localContext);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                Intrinsics.checkNotNull(objConsume, "null cannot be cast to non-null type android.app.Activity");
                MAMUIHelper.showSharingBlockedDialog((Activity) objConsume);
                composerStartRestartGroup.endReplaceGroup();
            } else {
                composerStartRestartGroup.startReplaceGroup(-1032916572);
                composerStartRestartGroup.endReplaceGroup();
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.box.android.browse.cpl.itemsList.ActionableItemsListMessagesKt$$ExternalSyntheticLambda2
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return ActionableItemsListMessagesKt.ActionableItemsListDialogs$lambda$2(store, i, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    private static final void FeatureDisabledDialog(final int i, final Store<ActionableItemsListReducer.State, ActionableItemsListReducer.Action> store, Composer composer, final int i2) {
        int i3;
        Composer composerStartRestartGroup = composer.startRestartGroup(-655518524);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(FeatureDisabledDialog)N(msg,store)53@2185L103,49@2032L314:ActionableItemsListMessages.kt#j5t2uy");
        if ((i2 & 6) == 0) {
            i3 = (composerStartRestartGroup.changed(i) ? 4 : 2) | i2;
        } else {
            i3 = i2;
        }
        if ((i2 & 48) == 0) {
            i3 |= composerStartRestartGroup.changed(store) ? 32 : 16;
        }
        if (!composerStartRestartGroup.shouldExecute((i3 & 19) != 18, i3 & 1)) {
            composerStartRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-655518524, i3, -1, "com.box.android.browse.cpl.itemsList.FeatureDisabledDialog (ActionableItemsListMessages.kt:48)");
            }
            int i4 = R.string.Feature_disabled;
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1406900299, "CC(remember):ActionableItemsListMessages.kt#9igjgp");
            boolean z = (i3 & 112) == 32;
            Object objRememberedValue = composerStartRestartGroup.rememberedValue();
            if (z || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                objRememberedValue = new Function0() { // from class: com.box.android.browse.cpl.itemsList.ActionableItemsListMessagesKt$$ExternalSyntheticLambda0
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return ActionableItemsListMessagesKt.FeatureDisabledDialog$lambda$0$0(store);
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
            }
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            BoxAlertDialogKt.m11705BoxAlertDialogSxpAMN0(i4, i, new ButtonItem.TextButtonItem(false, (Function0) objRememberedValue, R.string.button_ok, 1, null), null, null, null, 0L, 0L, composerStartRestartGroup, (i3 << 3) & 112, 248);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.box.android.browse.cpl.itemsList.ActionableItemsListMessagesKt$$ExternalSyntheticLambda1
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return ActionableItemsListMessagesKt.FeatureDisabledDialog$lambda$1(i, store, i2, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit FeatureDisabledDialog$lambda$0$0(Store store) {
        store.send(new ActionableItemsListReducer.Action.OfflineFilesAction(OfflineFilesReducer.Action.Finish.INSTANCE));
        return Unit.INSTANCE;
    }

    private static final ActionableItemsListReducer.State ActionableItemsListDialogs$lambda$0(State<ActionableItemsListReducer.State> state) {
        return state.getValue();
    }
}
