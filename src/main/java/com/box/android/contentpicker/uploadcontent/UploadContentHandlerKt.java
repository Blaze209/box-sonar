package com.box.android.contentpicker.uploadcontent;

import android.app.Activity;
import android.content.ClipData;
import android.content.Intent;
import android.net.Uri;
import androidx.activity.compose.ActivityResultRegistryKt;
import androidx.activity.compose.LocalActivityKt;
import androidx.activity.compose.ManagedActivityResultLauncher;
import androidx.activity.result.ActivityResult;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.ProvidableCompositionLocal;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.State;
import androidx.compose.runtime.Updater;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.platform.TestTagKt;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.compose.FlowExtKt;
import com.box.android.base.compose.button.model.ButtonItem;
import com.box.android.base.compose.dialog.BoxAlertDialogKt;
import com.box.android.common.utilities.OSPermissionUtils;
import com.box.android.coreservices.R;
import com.box.android.cpl.Store;
import com.box.brownfieldApi.featuresNavigator.activities.ReactNativeFeatureActivity;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: compiled from: UploadContentHandler.kt */
/* JADX INFO: loaded from: classes10.dex */
@Metadata(d1 = {"\u0000&\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a/\u0010\u0000\u001a\u00020\u00012\u0012\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u00032\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00010\u0007H\u0007¢\u0006\u0002\u0010\b\u001a\"\u0010\t\u001a\u00020\u00012\u0006\u0010\n\u001a\u00020\u000b2\u0012\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003¨\u0006\f²\u0006\n\u0010\r\u001a\u00020\u0004X\u008a\u0084\u0002"}, d2 = {"UploadContentHandler", "", "store", "Lcom/box/android/cpl/Store;", "Lcom/box/android/contentpicker/uploadcontent/UploadContentHandlerReducer$State;", "Lcom/box/android/contentpicker/uploadcontent/UploadContentHandlerReducer$Action;", "onCancel", "Lkotlin/Function0;", "(Lcom/box/android/cpl/Store;Lkotlin/jvm/functions/Function0;Landroidx/compose/runtime/Composer;I)V", "handleResult", ReactNativeFeatureActivity.RESULT_EXTRA_KEY, "Landroidx/activity/result/ActivityResult;", "content-picker_generalProdRelease", "state"}, k = 2, mv = {2, 2, 0}, xi = 48)
public final class UploadContentHandlerKt {
    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit UploadContentHandler$lambda$5(Store store, Function0 function0, int i, Composer composer, int i2) {
        UploadContentHandler(store, function0, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    public static final void UploadContentHandler(final Store<UploadContentHandlerReducer.State, UploadContentHandlerReducer.Action> store, final Function0<Unit> onCancel, Composer composer, final int i) {
        int i2;
        int i3;
        UploadContentHandlerReducer.ViewEffect viewEffect;
        int i4;
        UploadContentHandlerKt$UploadContentHandler$1$4$1 uploadContentHandlerKt$UploadContentHandler$1$4$1;
        Intrinsics.checkNotNullParameter(store, "store");
        Intrinsics.checkNotNullParameter(onCancel, "onCancel");
        Composer composerStartRestartGroup = composer.startRestartGroup(-1636051159);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(UploadContentHandler)N(store,onCancel)28@1349L7,29@1386L29,33@1547L100,31@1449L198,39@1776L53,37@1678L151,43@1835L2476,99@4338L58,99@4317L79:UploadContentHandler.kt#jqu1uq");
        if ((i & 6) == 0) {
            i2 = (composerStartRestartGroup.changed(store) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 48) == 0) {
            i2 |= composerStartRestartGroup.changedInstance(onCancel) ? 32 : 16;
        }
        if (!composerStartRestartGroup.shouldExecute((i2 & 19) != 18, i2 & 1)) {
            composerStartRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1636051159, i2, -1, "com.box.android.contentpicker.uploadcontent.UploadContentHandler (UploadContentHandler.kt:27)");
            }
            ProvidableCompositionLocal<Activity> localActivity = LocalActivityKt.getLocalActivity();
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
            Object objConsume = composerStartRestartGroup.consume(localActivity);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            Activity activity = (Activity) objConsume;
            State stateCollectAsStateWithLifecycle = FlowExtKt.collectAsStateWithLifecycle(store.getState(), (LifecycleOwner) null, (Lifecycle.State) null, (CoroutineContext) null, composerStartRestartGroup, 0, 7);
            ActivityResultContracts.StartActivityForResult startActivityForResult = new ActivityResultContracts.StartActivityForResult();
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -287122579, "CC(remember):UploadContentHandler.kt#9igjgp");
            int i5 = i2 & 14;
            boolean z = i5 == 4;
            Object objRememberedValue = composerStartRestartGroup.rememberedValue();
            if (z || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                objRememberedValue = new Function1() { // from class: com.box.android.contentpicker.uploadcontent.UploadContentHandlerKt$$ExternalSyntheticLambda0
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return UploadContentHandlerKt.UploadContentHandler$lambda$1$0(store, (ActivityResult) obj);
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
            }
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ManagedActivityResultLauncher managedActivityResultLauncherRememberLauncherForActivityResult = ActivityResultRegistryKt.rememberLauncherForActivityResult(startActivityForResult, (Function1) objRememberedValue, composerStartRestartGroup, 0);
            ActivityResultContracts.StartActivityForResult startActivityForResult2 = new ActivityResultContracts.StartActivityForResult();
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -287115298, "CC(remember):UploadContentHandler.kt#9igjgp");
            boolean z2 = i5 == 4;
            Object objRememberedValue2 = composerStartRestartGroup.rememberedValue();
            if (z2 || objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                objRememberedValue2 = new Function1() { // from class: com.box.android.contentpicker.uploadcontent.UploadContentHandlerKt$$ExternalSyntheticLambda1
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return UploadContentHandlerKt.UploadContentHandler$lambda$2$0(store, (ActivityResult) obj);
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
            }
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ManagedActivityResultLauncher managedActivityResultLauncherRememberLauncherForActivityResult2 = ActivityResultRegistryKt.rememberLauncherForActivityResult(startActivityForResult2, (Function1) objRememberedValue2, composerStartRestartGroup, 0);
            Modifier modifierTestTag = TestTagKt.testTag(Modifier.INSTANCE, "UploadContentHandler");
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1042775818, "CC(Box)N(modifier,contentAlignment,propagateMinConstraints,content)71@3424L131:Box.kt#2w3rfo");
            MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), false);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
            int iHashCode = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
            CompositionLocalMap currentCompositionLocalMap = composerStartRestartGroup.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierTestTag);
            Function0<ComposeUiNode> constructor = ComposeUiNode.INSTANCE.getConstructor();
            int i6 = i2;
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
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -788027395, "C62@2849L1456,62@2822L1483:UploadContentHandler.kt#jqu1uq");
            if (!UploadContentHandler$lambda$0(stateCollectAsStateWithLifecycle).getShowPermissionDialog()) {
                i3 = i5;
                composerStartRestartGroup.startReplaceGroup(-789989665);
            } else {
                composerStartRestartGroup.startReplaceGroup(-788044229);
                ComposerKt.sourceInformation(composerStartRestartGroup, "50@2316L54,54@2549L48,57@2698L48,45@1948L812");
                int i7 = R.string.job_item_error_type_permission;
                int i8 = com.box.android.base.R.string.Please_grant_permission_in_settings;
                int i9 = com.box.android.base.R.string.account_settings;
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 667327321, "CC(remember):UploadContentHandler.kt#9igjgp");
                boolean z3 = i5 == 4;
                Object objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                if (z3 || objRememberedValue3 == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue3 = new Function0() { // from class: com.box.android.contentpicker.uploadcontent.UploadContentHandlerKt$$ExternalSyntheticLambda2
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            return UploadContentHandlerKt.UploadContentHandler$lambda$3$0$0(store);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                }
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ButtonItem.TextButtonItem textButtonItem = new ButtonItem.TextButtonItem(false, (Function0) objRememberedValue3, i9, 1, null);
                int i10 = com.box.android.base.R.string.dismiss;
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 667334771, "CC(remember):UploadContentHandler.kt#9igjgp");
                boolean z4 = i5 == 4;
                Object objRememberedValue4 = composerStartRestartGroup.rememberedValue();
                if (z4 || objRememberedValue4 == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue4 = new Function0() { // from class: com.box.android.contentpicker.uploadcontent.UploadContentHandlerKt$$ExternalSyntheticLambda3
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            return UploadContentHandlerKt.UploadContentHandler$lambda$3$1$0(store);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue4);
                }
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ButtonItem.TextButtonItem textButtonItem2 = new ButtonItem.TextButtonItem(false, (Function0) objRememberedValue4, i10, 1, null);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 667339539, "CC(remember):UploadContentHandler.kt#9igjgp");
                boolean z5 = i5 == 4;
                Object objRememberedValue5 = composerStartRestartGroup.rememberedValue();
                if (z5 || objRememberedValue5 == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue5 = new Function0() { // from class: com.box.android.contentpicker.uploadcontent.UploadContentHandlerKt$$ExternalSyntheticLambda4
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            return UploadContentHandlerKt.UploadContentHandler$lambda$3$2$0(store);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue5);
                }
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                i3 = i5;
                BoxAlertDialogKt.m11705BoxAlertDialogSxpAMN0(i7, i8, textButtonItem, textButtonItem2, "StoragePermissionDialog", (Function0) objRememberedValue5, 0L, 0L, composerStartRestartGroup, 24576, 192);
                composerStartRestartGroup = composerStartRestartGroup;
            }
            composerStartRestartGroup.endReplaceGroup();
            UploadContentHandlerReducer.ViewEffect viewEffect2 = UploadContentHandler$lambda$0(stateCollectAsStateWithLifecycle).getViewEffect();
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 667345779, r11);
            boolean zChanged = composerStartRestartGroup.changed(viewEffect2) | composerStartRestartGroup.changedInstance(managedActivityResultLauncherRememberLauncherForActivityResult2) | (i3 == 4) | composerStartRestartGroup.changedInstance(activity) | composerStartRestartGroup.changedInstance(managedActivityResultLauncherRememberLauncherForActivityResult) | ((i6 & 112) == 32);
            Object objRememberedValue6 = composerStartRestartGroup.rememberedValue();
            if (zChanged || objRememberedValue6 == Composer.INSTANCE.getEmpty()) {
                viewEffect = viewEffect2;
                i4 = 0;
                uploadContentHandlerKt$UploadContentHandler$1$4$1 = new UploadContentHandlerKt$UploadContentHandler$1$4$1(viewEffect, managedActivityResultLauncherRememberLauncherForActivityResult2, store, managedActivityResultLauncherRememberLauncherForActivityResult, activity, onCancel, null);
                composerStartRestartGroup.updateRememberedValue(uploadContentHandlerKt$UploadContentHandler$1$4$1);
            } else {
                uploadContentHandlerKt$UploadContentHandler$1$4$1 = objRememberedValue6;
                i4 = 0;
                viewEffect = viewEffect2;
            }
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            EffectsKt.LaunchedEffect(viewEffect, (Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object>) uploadContentHandlerKt$UploadContentHandler$1$4$1, composerStartRestartGroup, i4);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            composerStartRestartGroup.endNode();
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            Unit unit = Unit.INSTANCE;
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -287033309, "CC(remember):UploadContentHandler.kt#9igjgp");
            int i11 = i3 != 4 ? i4 : 1;
            UploadContentHandlerKt$UploadContentHandler$2$1 uploadContentHandlerKt$UploadContentHandler$2$1RememberedValue = composerStartRestartGroup.rememberedValue();
            if (i11 != 0 || uploadContentHandlerKt$UploadContentHandler$2$1RememberedValue == Composer.INSTANCE.getEmpty()) {
                uploadContentHandlerKt$UploadContentHandler$2$1RememberedValue = new UploadContentHandlerKt$UploadContentHandler$2$1(store, null);
                composerStartRestartGroup.updateRememberedValue(uploadContentHandlerKt$UploadContentHandler$2$1RememberedValue);
            }
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            EffectsKt.LaunchedEffect(unit, (Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object>) uploadContentHandlerKt$UploadContentHandler$2$1RememberedValue, composerStartRestartGroup, 6);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.box.android.contentpicker.uploadcontent.UploadContentHandlerKt$$ExternalSyntheticLambda5
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return UploadContentHandlerKt.UploadContentHandler$lambda$5(store, onCancel, i, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit UploadContentHandler$lambda$1$0(Store store, ActivityResult it) {
        Intrinsics.checkNotNullParameter(it, "it");
        store.send(new UploadContentHandlerReducer.Action.StorageAccessResult(OSPermissionUtils.INSTANCE.hasStoragePermission(true)));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit UploadContentHandler$lambda$2$0(Store store, ActivityResult result) {
        Intrinsics.checkNotNullParameter(result, "result");
        handleResult(result, store);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit UploadContentHandler$lambda$3$0$0(Store store) {
        store.send(UploadContentHandlerReducer.Action.PermissionDialogPositiveClicked.INSTANCE);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit UploadContentHandler$lambda$3$1$0(Store store) {
        store.send(UploadContentHandlerReducer.Action.PermissionDialogDismissed.INSTANCE);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit UploadContentHandler$lambda$3$2$0(Store store) {
        store.send(UploadContentHandlerReducer.Action.PermissionDialogDismissed.INSTANCE);
        return Unit.INSTANCE;
    }

    public static final void handleResult(ActivityResult result, Store<UploadContentHandlerReducer.State, UploadContentHandlerReducer.Action> store) {
        Intrinsics.checkNotNullParameter(result, "result");
        Intrinsics.checkNotNullParameter(store, "store");
        Intent data = result.getData();
        if (data != null) {
            ArrayList arrayList = new ArrayList();
            ClipData clipData = data.getClipData();
            if (clipData != null) {
                int itemCount = clipData.getItemCount();
                for (int i = 0; i < itemCount; i++) {
                    Uri uri = clipData.getItemAt(i).getUri();
                    Intrinsics.checkNotNullExpressionValue(uri, "getUri(...)");
                    arrayList.add(uri);
                }
            } else {
                Uri data2 = data.getData();
                if (data2 != null) {
                    arrayList.add(data2);
                }
            }
            store.send(new UploadContentHandlerReducer.Action.FilesSelected(arrayList));
            return;
        }
        store.send(UploadContentHandlerReducer.Action.FileSelectionCancelled.INSTANCE);
    }

    private static final UploadContentHandlerReducer.State UploadContentHandler$lambda$0(State<UploadContentHandlerReducer.State> state) {
        return state.getValue();
    }
}
