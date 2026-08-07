package com.box.android.boxai;

import android.app.Activity;
import android.content.Intent;
import androidx.activity.compose.ActivityResultRegistryKt;
import androidx.activity.compose.LocalActivityKt;
import androidx.activity.compose.ManagedActivityResultLauncher;
import androidx.activity.result.ActivityResult;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.ProvidableCompositionLocal;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.State;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.compose.FlowExtKt;
import com.box.android.base.presentation.activities.BoxFragmentActivity;
import com.box.android.cpl.Store;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: compiled from: AiCenterLauncher.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a!\u0010\u0000\u001a\u00020\u00012\u0012\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003H\u0007¢\u0006\u0002\u0010\u0006¨\u0006\u0007²\u0006\n\u0010\b\u001a\u00020\u0004X\u008a\u0084\u0002"}, d2 = {"AiCenterLauncher", "", "store", "Lcom/box/android/cpl/Store;", "Lcom/box/android/boxai/BoxAiCenterReducer$State;", "Lcom/box/android/boxai/BoxAiCenterReducer$Action;", "(Lcom/box/android/cpl/Store;Landroidx/compose/runtime/Composer;I)V", "boxai_generalProdRelease", "state"}, k = 2, mv = {2, 2, 0}, xi = 48)
public final class AiCenterLauncherKt {
    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit AiCenterLauncher$lambda$1(Store store, int i, Composer composer, int i2) {
        AiCenterLauncher(store, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit AiCenterLauncher$lambda$5(Store store, int i, Composer composer, int i2) {
        AiCenterLauncher(store, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    public static final void AiCenterLauncher(final Store<BoxAiCenterReducer.State, BoxAiCenterReducer.Action> store, Composer composer, final int i) {
        int i2;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        Function2<? super Composer, ? super Integer, Unit> function2;
        Intrinsics.checkNotNullParameter(store, "store");
        Composer composerStartRestartGroup = composer.startRestartGroup(-2014182405);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(AiCenterLauncher)N(store)17@772L29,19@836L7,20@882L98,26@1110L176,24@1001L285,30@1328L525,30@1291L562:AiCenterLauncher.kt#6z2y90");
        if ((i & 6) == 0) {
            i2 = (composerStartRestartGroup.changed(store) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if (!composerStartRestartGroup.shouldExecute((i2 & 3) != 2, i2 & 1)) {
            composerStartRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-2014182405, i2, -1, "com.box.android.boxai.AiCenterLauncher (AiCenterLauncher.kt:16)");
            }
            State stateCollectAsStateWithLifecycle = FlowExtKt.collectAsStateWithLifecycle(store.getState(), (LifecycleOwner) null, (Lifecycle.State) null, (CoroutineContext) null, composerStartRestartGroup, 0, 7);
            ProvidableCompositionLocal<Activity> localActivity = LocalActivityKt.getLocalActivity();
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
            Object objConsume = composerStartRestartGroup.consume(localActivity);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            Activity activity = (Activity) objConsume;
            if (activity != null) {
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1400966717, "CC(remember):AiCenterLauncher.kt#9igjgp");
                Object objRememberedValue = composerStartRestartGroup.rememberedValue();
                if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                    Intent intent = activity.getIntent();
                    objRememberedValue = intent != null ? intent.getStringExtra(BoxFragmentActivity.EXTRA_SHAREDLINK_URL) : null;
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                }
                String str = (String) objRememberedValue;
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ActivityResultContracts.StartActivityForResult startActivityForResult = new ActivityResultContracts.StartActivityForResult();
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1400974091, "CC(remember):AiCenterLauncher.kt#9igjgp");
                int i3 = i2 & 14;
                boolean z = i3 == 4;
                Object objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                if (z || objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue2 = new Function1() { // from class: com.box.android.boxai.AiCenterLauncherKt$$ExternalSyntheticLambda1
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            return AiCenterLauncherKt.AiCenterLauncher$lambda$3$0(store, (ActivityResult) obj);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                }
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ManagedActivityResultLauncher managedActivityResultLauncherRememberLauncherForActivityResult = ActivityResultRegistryKt.rememberLauncherForActivityResult(startActivityForResult, (Function1) objRememberedValue2, composerStartRestartGroup, 0);
                Boolean boolValueOf = Boolean.valueOf(AiCenterLauncher$lambda$0(stateCollectAsStateWithLifecycle).getShouldLaunchAx());
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1400981416, "CC(remember):AiCenterLauncher.kt#9igjgp");
                boolean zChanged = composerStartRestartGroup.changed(stateCollectAsStateWithLifecycle) | composerStartRestartGroup.changedInstance(managedActivityResultLauncherRememberLauncherForActivityResult) | composerStartRestartGroup.changedInstance(activity) | (i3 == 4);
                AiCenterLauncherKt$AiCenterLauncher$1$1 aiCenterLauncherKt$AiCenterLauncher$1$1RememberedValue = composerStartRestartGroup.rememberedValue();
                if (zChanged || aiCenterLauncherKt$AiCenterLauncher$1$1RememberedValue == Composer.INSTANCE.getEmpty()) {
                    aiCenterLauncherKt$AiCenterLauncher$1$1RememberedValue = new AiCenterLauncherKt$AiCenterLauncher$1$1(managedActivityResultLauncherRememberLauncherForActivityResult, activity, str, store, stateCollectAsStateWithLifecycle, null);
                    composerStartRestartGroup.updateRememberedValue(aiCenterLauncherKt$AiCenterLauncher$1$1RememberedValue);
                }
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                EffectsKt.LaunchedEffect(boolValueOf, (Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object>) aiCenterLauncherKt$AiCenterLauncher$1$1RememberedValue, composerStartRestartGroup, 0);
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
                    function2 = new Function2() { // from class: com.box.android.boxai.AiCenterLauncherKt$$ExternalSyntheticLambda0
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return AiCenterLauncherKt.AiCenterLauncher$lambda$1(store, i, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    };
                }
            }
            scopeUpdateScopeEndRestartGroup.updateScope(function2);
        }
        scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            function2 = new Function2() { // from class: com.box.android.boxai.AiCenterLauncherKt$$ExternalSyntheticLambda2
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return AiCenterLauncherKt.AiCenterLauncher$lambda$5(store, i, (Composer) obj, ((Integer) obj2).intValue());
                }
            };
            scopeUpdateScopeEndRestartGroup.updateScope(function2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit AiCenterLauncher$lambda$3$0(Store store, ActivityResult result) {
        Intrinsics.checkNotNullParameter(result, "result");
        Intent data = result.getData();
        store.send(new BoxAiCenterReducer.Action.UpdateSession(data != null ? data.getStringExtra(AiCenterActivity.RESULT_SESSION_ID) : null));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final BoxAiCenterReducer.State AiCenterLauncher$lambda$0(State<BoxAiCenterReducer.State> state) {
        return state.getValue();
    }
}
