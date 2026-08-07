package com.box.android.contentpicker.uploadcontent;

import android.app.Activity;
import androidx.activity.compose.ActivityResultRegistryKt;
import androidx.activity.compose.LocalActivityKt;
import androidx.activity.compose.ManagedActivityResultLauncher;
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
import com.box.android.base.R;
import com.box.android.base.presentation.components.permission.PermissionHandlerComponentKt;
import com.box.android.cpl.Store;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.reflect.KFunction;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: compiled from: CaptureMediaHandler.kt */
/* JADX INFO: loaded from: classes10.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a/\u0010\u0000\u001a\u00020\u00012\u0012\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u00032\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00010\u0007H\u0007¢\u0006\u0002\u0010\b¨\u0006\t²\u0006\n\u0010\n\u001a\u00020\u0004X\u008a\u0084\u0002"}, d2 = {"CaptureMediaHandler", "", "store", "Lcom/box/android/cpl/Store;", "Lcom/box/android/contentpicker/uploadcontent/CaptureMediaHandlerReducer$State;", "Lcom/box/android/contentpicker/uploadcontent/CaptureMediaHandlerReducer$Action;", "onCancel", "Lkotlin/Function0;", "(Lcom/box/android/cpl/Store;Lkotlin/jvm/functions/Function0;Landroidx/compose/runtime/Composer;I)V", "content-picker_generalProdRelease", "state"}, k = 2, mv = {2, 2, 0}, xi = 48)
public final class CaptureMediaHandlerKt {
    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit CaptureMediaHandler$lambda$2(Store store, Function0 function0, int i, Composer composer, int i2) {
        CaptureMediaHandler(store, function0, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    public static final void CaptureMediaHandler(final Store<CaptureMediaHandlerReducer.State, CaptureMediaHandlerReducer.Action> store, final Function0<Unit> onCancel, Composer composer, final int i) {
        int i2;
        int i3;
        CaptureMediaHandlerReducer.ViewEffect viewEffect;
        Intrinsics.checkNotNullParameter(store, "store");
        Intrinsics.checkNotNullParameter(onCancel, "onCancel");
        Composer composerStartRestartGroup = composer.startRestartGroup(-59271607);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(CaptureMediaHandler)N(store,onCancel)24@1221L7,25@1258L29,27@1293L1837:CaptureMediaHandler.kt#jqu1uq");
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
                ComposerKt.traceEventStart(-59271607, i2, -1, "com.box.android.contentpicker.uploadcontent.CaptureMediaHandler (CaptureMediaHandler.kt:23)");
            }
            ProvidableCompositionLocal<Activity> localActivity = LocalActivityKt.getLocalActivity();
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
            Object objConsume = composerStartRestartGroup.consume(localActivity);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            Activity activity = (Activity) objConsume;
            State stateCollectAsStateWithLifecycle = FlowExtKt.collectAsStateWithLifecycle(store.getState(), (LifecycleOwner) null, (Lifecycle.State) null, (CoroutineContext) null, composerStartRestartGroup, 0, 7);
            Modifier modifierTestTag = TestTagKt.testTag(Modifier.INSTANCE, "CaptureMediaHandler");
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1042775818, "CC(Box)N(modifier,contentAlignment,propagateMinConstraints,content)71@3424L131:Box.kt#2w3rfo");
            MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), false);
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
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -636579557, "C30@1480L76,28@1385L171,37@1835L24,34@1566L304,41@1949L1175,41@1922L1202:CaptureMediaHandler.kt#jqu1uq");
            ActivityResultContracts.TakePicture takePicture = new ActivityResultContracts.TakePicture();
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 533656687, "CC(remember):CaptureMediaHandler.kt#9igjgp");
            int i4 = i2 & 14;
            boolean z = i4 == 4;
            Object objRememberedValue = composerStartRestartGroup.rememberedValue();
            if (z || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                objRememberedValue = new Function1() { // from class: com.box.android.contentpicker.uploadcontent.CaptureMediaHandlerKt$$ExternalSyntheticLambda0
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return CaptureMediaHandlerKt.CaptureMediaHandler$lambda$1$0$0(store, ((Boolean) obj).booleanValue());
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
            }
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ManagedActivityResultLauncher managedActivityResultLauncherRememberLauncherForActivityResult = ActivityResultRegistryKt.rememberLauncherForActivityResult(takePicture, (Function1) objRememberedValue, composerStartRestartGroup, 0);
            int i5 = R.string.camera_permission_permanently_denied;
            CaptureMediaHandlerKt$CaptureMediaHandler$1$1 captureMediaHandlerKt$CaptureMediaHandler$1$1 = new PropertyReference1Impl() { // from class: com.box.android.contentpicker.uploadcontent.CaptureMediaHandlerKt$CaptureMediaHandler$1$1
                @Override // kotlin.jvm.internal.PropertyReference1Impl, kotlin.reflect.KProperty1
                public Object get(Object obj) {
                    return ((CaptureMediaHandlerReducer.State) obj).getPermissionState();
                }
            };
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 533667995, "CC(remember):CaptureMediaHandler.kt#9igjgp");
            CaptureMediaHandlerKt$CaptureMediaHandler$1$2$1 captureMediaHandlerKt$CaptureMediaHandler$1$2$1RememberedValue = composerStartRestartGroup.rememberedValue();
            if (captureMediaHandlerKt$CaptureMediaHandler$1$2$1RememberedValue == Composer.INSTANCE.getEmpty()) {
                captureMediaHandlerKt$CaptureMediaHandler$1$2$1RememberedValue = CaptureMediaHandlerKt$CaptureMediaHandler$1$2$1.INSTANCE;
                composerStartRestartGroup.updateRememberedValue(captureMediaHandlerKt$CaptureMediaHandler$1$2$1RememberedValue);
            }
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            PermissionHandlerComponentKt.PermissionHandlerComponent("android.permission.CAMERA", i5, store.scope(captureMediaHandlerKt$CaptureMediaHandler$1$1, (Function1) ((KFunction) captureMediaHandlerKt$CaptureMediaHandler$1$2$1RememberedValue)), composerStartRestartGroup, 6);
            CaptureMediaHandlerReducer.ViewEffect viewEffect2 = CaptureMediaHandler$lambda$0(stateCollectAsStateWithLifecycle).getViewEffect();
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 533672794, "CC(remember):CaptureMediaHandler.kt#9igjgp");
            boolean zChanged = composerStartRestartGroup.changed(viewEffect2) | composerStartRestartGroup.changedInstance(managedActivityResultLauncherRememberLauncherForActivityResult) | (i4 == 4) | composerStartRestartGroup.changedInstance(activity) | ((i2 & 112) == 32);
            CaptureMediaHandlerKt$CaptureMediaHandler$1$3$1 captureMediaHandlerKt$CaptureMediaHandler$1$3$1RememberedValue = composerStartRestartGroup.rememberedValue();
            if (zChanged || captureMediaHandlerKt$CaptureMediaHandler$1$3$1RememberedValue == Composer.INSTANCE.getEmpty()) {
                i3 = 0;
                viewEffect = viewEffect2;
                captureMediaHandlerKt$CaptureMediaHandler$1$3$1RememberedValue = new CaptureMediaHandlerKt$CaptureMediaHandler$1$3$1(viewEffect, managedActivityResultLauncherRememberLauncherForActivityResult, store, activity, onCancel, null);
                composerStartRestartGroup.updateRememberedValue(captureMediaHandlerKt$CaptureMediaHandler$1$3$1RememberedValue);
            } else {
                viewEffect = viewEffect2;
                i3 = 0;
            }
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            EffectsKt.LaunchedEffect(viewEffect, (Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object>) captureMediaHandlerKt$CaptureMediaHandler$1$3$1RememberedValue, composerStartRestartGroup, i3);
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
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.box.android.contentpicker.uploadcontent.CaptureMediaHandlerKt$$ExternalSyntheticLambda1
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return CaptureMediaHandlerKt.CaptureMediaHandler$lambda$2(store, onCancel, i, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit CaptureMediaHandler$lambda$1$0$0(Store store, boolean z) {
        store.send(new CaptureMediaHandlerReducer.Action.PhotoCaptured(z));
        return Unit.INSTANCE;
    }

    private static final CaptureMediaHandlerReducer.State CaptureMediaHandler$lambda$0(State<CaptureMediaHandlerReducer.State> state) {
        return state.getValue();
    }
}
