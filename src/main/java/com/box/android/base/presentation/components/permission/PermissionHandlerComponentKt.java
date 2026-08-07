package com.box.android.base.presentation.components.permission;

import android.content.Context;
import androidx.activity.compose.ActivityResultRegistryKt;
import androidx.activity.compose.ManagedActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.ProvidableCompositionLocal;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.State;
import androidx.compose.ui.platform.AndroidCompositionLocals_androidKt;
import androidx.core.app.ActivityCompat;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.compose.FlowExtKt;
import com.box.android.base.R;
import com.box.android.base.compose.button.model.ButtonItem;
import com.box.android.base.compose.dialog.BoxAlertDialogKt;
import com.box.android.common.extensions.ContextExtensionsKt;
import com.box.android.common.utilities.IntentUtils;
import com.box.android.cpl.Store;
import external.sdk.pendo.io.mozilla.javascript.Token;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: compiled from: PermissionHandlerComponent.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000,\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a3\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\b\b\u0001\u0010\u0004\u001a\u00020\u00052\u0012\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t0\u0007H\u0007¢\u0006\u0002\u0010\n\u001a3\u0010\u000b\u001a\u00020\u00012\u0006\u0010\f\u001a\u00020\r2\b\b\u0001\u0010\u0004\u001a\u00020\u00052\u0012\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t0\u0007H\u0003¢\u0006\u0002\u0010\u000e¨\u0006\u000f²\u0006\n\u0010\u0010\u001a\u00020\bX\u008a\u0084\u0002"}, d2 = {"PermissionHandlerComponent", "", "permission", "", "permanentDenialMessage", "", "store", "Lcom/box/android/cpl/Store;", "Lcom/box/android/base/presentation/components/permission/PermissionReducer$State;", "Lcom/box/android/base/presentation/components/permission/PermissionReducer$Action;", "(Ljava/lang/String;ILcom/box/android/cpl/Store;Landroidx/compose/runtime/Composer;I)V", "PermissionDenialDialog", "context", "Landroid/content/Context;", "(Landroid/content/Context;ILcom/box/android/cpl/Store;Landroidx/compose/runtime/Composer;I)V", "base_generalProdRelease", "state"}, k = 2, mv = {2, 2, 0}, xi = 48)
public final class PermissionHandlerComponentKt {
    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit PermissionDenialDialog$lambda$2(Context context, int i, Store store, int i2, Composer composer, int i3) {
        PermissionDenialDialog(context, i, store, composer, RecomposeScopeImplKt.updateChangedFlags(i2 | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit PermissionHandlerComponent$lambda$3(String str, int i, Store store, int i2, Composer composer, int i3) {
        PermissionHandlerComponent(str, i, store, composer, RecomposeScopeImplKt.updateChangedFlags(i2 | 1));
        return Unit.INSTANCE;
    }

    public static final void PermissionHandlerComponent(final String permission, final int i, final Store<PermissionReducer.State, PermissionReducer.Action> store, Composer composer, final int i2) {
        int i3;
        Intrinsics.checkNotNullParameter(permission, "permission");
        Intrinsics.checkNotNullParameter(store, "store");
        Composer composerStartRestartGroup = composer.startRestartGroup(-913795338);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(PermissionHandlerComponent)N(permission,permanentDenialMessage,store)25@1053L7,26@1090L29,28@1236L645,28@1157L724,42@1927L121,42@1887L161:PermissionHandlerComponent.kt#ym0xvl");
        if ((i2 & 6) == 0) {
            i3 = (composerStartRestartGroup.changed(permission) ? 4 : 2) | i2;
        } else {
            i3 = i2;
        }
        if ((i2 & 48) == 0) {
            i3 |= composerStartRestartGroup.changed(i) ? 32 : 16;
        }
        if ((i2 & 384) == 0) {
            i3 |= composerStartRestartGroup.changed(store) ? 256 : 128;
        }
        int i4 = i3;
        if (!composerStartRestartGroup.shouldExecute((i4 & Token.DOTQUERY) != 146, i4 & 1)) {
            composerStartRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-913795338, i4, -1, "com.box.android.base.presentation.components.permission.PermissionHandlerComponent (PermissionHandlerComponent.kt:24)");
            }
            ProvidableCompositionLocal<Context> localContext = AndroidCompositionLocals_androidKt.getLocalContext();
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
            Object objConsume = composerStartRestartGroup.consume(localContext);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            final Context context = (Context) objConsume;
            State stateCollectAsStateWithLifecycle = FlowExtKt.collectAsStateWithLifecycle(store.getState(), (LifecycleOwner) null, (Lifecycle.State) null, (CoroutineContext) null, composerStartRestartGroup, 0, 7);
            ActivityResultContracts.RequestPermission requestPermission = new ActivityResultContracts.RequestPermission();
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1983978437, "CC(remember):PermissionHandlerComponent.kt#9igjgp");
            int i5 = i4 & 14;
            boolean zChangedInstance = composerStartRestartGroup.changedInstance(context) | (i5 == 4) | ((i4 & 896) == 256);
            Object objRememberedValue = composerStartRestartGroup.rememberedValue();
            if (zChangedInstance || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                objRememberedValue = new Function1() { // from class: com.box.android.base.presentation.components.permission.PermissionHandlerComponentKt$$ExternalSyntheticLambda3
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return PermissionHandlerComponentKt.PermissionHandlerComponent$lambda$1$0(context, permission, store, ((Boolean) obj).booleanValue());
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
            }
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ManagedActivityResultLauncher managedActivityResultLauncherRememberLauncherForActivityResult = ActivityResultRegistryKt.rememberLauncherForActivityResult(requestPermission, (Function1) objRememberedValue, composerStartRestartGroup, 0);
            PermissionReducer.PermissionRequest permissionRequest = PermissionHandlerComponent$lambda$0(stateCollectAsStateWithLifecycle).getPermissionRequest();
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1983956849, "CC(remember):PermissionHandlerComponent.kt#9igjgp");
            boolean zChanged = composerStartRestartGroup.changed(stateCollectAsStateWithLifecycle) | composerStartRestartGroup.changedInstance(managedActivityResultLauncherRememberLauncherForActivityResult) | (i5 == 4);
            PermissionHandlerComponentKt$PermissionHandlerComponent$1$1 permissionHandlerComponentKt$PermissionHandlerComponent$1$1RememberedValue = composerStartRestartGroup.rememberedValue();
            if (zChanged || permissionHandlerComponentKt$PermissionHandlerComponent$1$1RememberedValue == Composer.INSTANCE.getEmpty()) {
                permissionHandlerComponentKt$PermissionHandlerComponent$1$1RememberedValue = new PermissionHandlerComponentKt$PermissionHandlerComponent$1$1(managedActivityResultLauncherRememberLauncherForActivityResult, permission, stateCollectAsStateWithLifecycle, null);
                composerStartRestartGroup.updateRememberedValue(permissionHandlerComponentKt$PermissionHandlerComponent$1$1RememberedValue);
            }
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            EffectsKt.LaunchedEffect(permissionRequest, (Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object>) permissionHandlerComponentKt$PermissionHandlerComponent$1$1RememberedValue, composerStartRestartGroup, 0);
            if (!PermissionHandlerComponent$lambda$0(stateCollectAsStateWithLifecycle).getShouldShowPermanentDenialDialog()) {
                composerStartRestartGroup.startReplaceGroup(-1375036500);
            } else {
                composerStartRestartGroup.startReplaceGroup(-1372951533);
                ComposerKt.sourceInformation(composerStartRestartGroup, "49@2107L105");
                PermissionDenialDialog(context, i, store, composerStartRestartGroup, i4 & 1008);
            }
            composerStartRestartGroup.endReplaceGroup();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.box.android.base.presentation.components.permission.PermissionHandlerComponentKt$$ExternalSyntheticLambda4
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return PermissionHandlerComponentKt.PermissionHandlerComponent$lambda$3(permission, i, store, i2, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit PermissionHandlerComponent$lambda$1$0(Context context, String str, Store store, boolean z) {
        PermissionReducer.Action.PermissionRequestResult.Status status;
        boolean z2 = (z || ActivityCompat.shouldShowRequestPermissionRationale(ContextExtensionsKt.requireActivity(context), str)) ? false : true;
        if (z) {
            status = PermissionReducer.Action.PermissionRequestResult.Status.GRANTED;
        } else if (z2) {
            status = PermissionReducer.Action.PermissionRequestResult.Status.PERMANENTLY_DENIED;
        } else {
            status = PermissionReducer.Action.PermissionRequestResult.Status.DENIED;
        }
        store.send(new PermissionReducer.Action.PermissionRequestResult(status));
        return Unit.INSTANCE;
    }

    private static final void PermissionDenialDialog(final Context context, final int i, final Store<PermissionReducer.State, PermissionReducer.Action> store, Composer composer, final int i2) {
        int i3;
        Composer composerStartRestartGroup = composer.startRestartGroup(1623869024);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(PermissionDenialDialog)N(context,permanentDenialMessage,store)63@2598L186,70@2919L97,59@2412L704:PermissionHandlerComponent.kt#ym0xvl");
        if ((i2 & 6) == 0) {
            i3 = (composerStartRestartGroup.changedInstance(context) ? 4 : 2) | i2;
        } else {
            i3 = i2;
        }
        if ((i2 & 48) == 0) {
            i3 |= composerStartRestartGroup.changed(i) ? 32 : 16;
        }
        if ((i2 & 384) == 0) {
            i3 |= composerStartRestartGroup.changed(store) ? 256 : 128;
        }
        if (!composerStartRestartGroup.shouldExecute((i3 & Token.DOTQUERY) != 146, i3 & 1)) {
            composerStartRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1623869024, i3, -1, "com.box.android.base.presentation.components.permission.PermissionDenialDialog (PermissionHandlerComponent.kt:58)");
            }
            int i4 = R.string.job_item_error_type_permission;
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1465015194, "CC(remember):PermissionHandlerComponent.kt#9igjgp");
            int i5 = i3 & 896;
            boolean zChangedInstance = (i5 == 256) | composerStartRestartGroup.changedInstance(context);
            Object objRememberedValue = composerStartRestartGroup.rememberedValue();
            if (zChangedInstance || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                objRememberedValue = new Function0() { // from class: com.box.android.base.presentation.components.permission.PermissionHandlerComponentKt$$ExternalSyntheticLambda0
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return PermissionHandlerComponentKt.PermissionDenialDialog$lambda$0$0(store, context);
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
            }
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ButtonItem.TextButtonItem textButtonItem = new ButtonItem.TextButtonItem(false, (Function0) objRememberedValue, R.string.account_settings, 1, null);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1465025377, "CC(remember):PermissionHandlerComponent.kt#9igjgp");
            boolean z = i5 == 256;
            Object objRememberedValue2 = composerStartRestartGroup.rememberedValue();
            if (z || objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                objRememberedValue2 = new Function0() { // from class: com.box.android.base.presentation.components.permission.PermissionHandlerComponentKt$$ExternalSyntheticLambda1
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return PermissionHandlerComponentKt.PermissionDenialDialog$lambda$1$0(store);
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
            }
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            BoxAlertDialogKt.m11705BoxAlertDialogSxpAMN0(i4, i, textButtonItem, new ButtonItem.TextButtonItem(false, (Function0) objRememberedValue2, R.string.dismiss, 1, null), "PermissionDenialDialog", null, 0L, 0L, composerStartRestartGroup, (i3 & 112) | 24576, 224);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.box.android.base.presentation.components.permission.PermissionHandlerComponentKt$$ExternalSyntheticLambda2
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return PermissionHandlerComponentKt.PermissionDenialDialog$lambda$2(context, i, store, i2, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit PermissionDenialDialog$lambda$0$0(Store store, Context context) {
        store.send(PermissionReducer.Action.DismissPermanentDenialDialog.INSTANCE);
        context.startActivity(IntentUtils.INSTANCE.getApplicationSettingsIntent(context));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit PermissionDenialDialog$lambda$1$0(Store store) {
        store.send(PermissionReducer.Action.DismissPermanentDenialDialog.INSTANCE);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final PermissionReducer.State PermissionHandlerComponent$lambda$0(State<PermissionReducer.State> state) {
        return state.getValue();
    }
}
