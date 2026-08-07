package com.box.android.browse.cpl.itemsList;

import android.app.Activity;
import androidx.activity.ComponentActivity;
import androidx.activity.compose.ActivityResultRegistryKt;
import androidx.activity.compose.LocalActivityKt;
import androidx.activity.compose.ManagedActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.ProvidableCompositionLocal;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import com.box.android.cpl.Store;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: compiled from: MultiselectActionModeCompose.kt */
/* JADX INFO: loaded from: classes10.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a!\u0010\u0000\u001a\u00020\u00012\u0012\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003H\u0007¢\u0006\u0002\u0010\u0006¨\u0006\u0007"}, d2 = {"MultiSelectActionModeCompose", "", "actionableItemsListStore", "Lcom/box/android/cpl/Store;", "Lcom/box/android/browse/cpl/itemsList/ActionableItemsListReducer$State;", "Lcom/box/android/browse/cpl/itemsList/ActionableItemsListReducer$Action;", "(Lcom/box/android/cpl/Store;Landroidx/compose/runtime/Composer;I)V", "browse_generalProdRelease"}, k = 2, mv = {2, 2, 0}, xi = 48)
public final class MultiselectActionModeComposeKt {
    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit MultiSelectActionModeCompose$lambda$0(Store store, int i, Composer composer, int i2) {
        MultiSelectActionModeCompose(store, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit MultiSelectActionModeCompose$lambda$3(Store store, int i, Composer composer, int i2) {
        MultiSelectActionModeCompose(store, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    public static final void MultiSelectActionModeCompose(final Store<ActionableItemsListReducer.State, ActionableItemsListReducer.Action> actionableItemsListStore, Composer composer, final int i) {
        int i2;
        final Store<ActionableItemsListReducer.State, ActionableItemsListReducer.Action> store;
        Intrinsics.checkNotNullParameter(actionableItemsListStore, "actionableItemsListStore");
        Composer composerStartRestartGroup = composer.startRestartGroup(547582217);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(MultiSelectActionModeCompose)N(actionableItemsListStore)14@661L7,15@726L24,19@874L129,17@781L222,23@1030L249,23@1009L270:MultiselectActionModeCompose.kt#j5t2uy");
        if ((i & 6) == 0) {
            i2 = (composerStartRestartGroup.changed(actionableItemsListStore) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if (!composerStartRestartGroup.shouldExecute((i2 & 3) != 2, i2 & 1)) {
            store = actionableItemsListStore;
            composerStartRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(547582217, i2, -1, "com.box.android.browse.cpl.itemsList.MultiSelectActionModeCompose (MultiselectActionModeCompose.kt:13)");
            }
            ProvidableCompositionLocal<Activity> localActivity = LocalActivityKt.getLocalActivity();
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
            Object objConsume = composerStartRestartGroup.consume(localActivity);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComponentActivity componentActivity = objConsume instanceof ComponentActivity ? (ComponentActivity) objConsume : null;
            if (componentActivity == null) {
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.box.android.browse.cpl.itemsList.MultiselectActionModeComposeKt$$ExternalSyntheticLambda0
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return MultiselectActionModeComposeKt.MultiSelectActionModeCompose$lambda$0(actionableItemsListStore, i, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    });
                    return;
                }
                return;
            }
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
            ActivityResultContracts.RequestPermission requestPermission = new ActivityResultContracts.RequestPermission();
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -2054454486, "CC(remember):MultiselectActionModeCompose.kt#9igjgp");
            int i3 = i2 & 14;
            boolean z = i3 == 4;
            Object objRememberedValue2 = composerStartRestartGroup.rememberedValue();
            if (z || objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                objRememberedValue2 = new Function1() { // from class: com.box.android.browse.cpl.itemsList.MultiselectActionModeComposeKt$$ExternalSyntheticLambda1
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return MultiselectActionModeComposeKt.MultiSelectActionModeCompose$lambda$1$0(actionableItemsListStore, ((Boolean) obj).booleanValue());
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
            }
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ManagedActivityResultLauncher managedActivityResultLauncherRememberLauncherForActivityResult = ActivityResultRegistryKt.rememberLauncherForActivityResult(requestPermission, (Function1) objRememberedValue2, composerStartRestartGroup, 0);
            Unit unit = Unit.INSTANCE;
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -2054449374, "CC(remember):MultiselectActionModeCompose.kt#9igjgp");
            boolean zChangedInstance = composerStartRestartGroup.changedInstance(componentActivity) | composerStartRestartGroup.changedInstance(managedActivityResultLauncherRememberLauncherForActivityResult) | (i3 == 4) | composerStartRestartGroup.changedInstance(coroutineScope);
            MultiselectActionModeComposeKt$MultiSelectActionModeCompose$1$1 multiselectActionModeComposeKt$MultiSelectActionModeCompose$1$1RememberedValue = composerStartRestartGroup.rememberedValue();
            if (zChangedInstance || multiselectActionModeComposeKt$MultiSelectActionModeCompose$1$1RememberedValue == Composer.INSTANCE.getEmpty()) {
                store = actionableItemsListStore;
                multiselectActionModeComposeKt$MultiSelectActionModeCompose$1$1RememberedValue = new MultiselectActionModeComposeKt$MultiSelectActionModeCompose$1$1(componentActivity, managedActivityResultLauncherRememberLauncherForActivityResult, store, coroutineScope, null);
                composerStartRestartGroup.updateRememberedValue(multiselectActionModeComposeKt$MultiSelectActionModeCompose$1$1RememberedValue);
            } else {
                store = actionableItemsListStore;
            }
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            EffectsKt.LaunchedEffect(unit, (Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object>) multiselectActionModeComposeKt$MultiSelectActionModeCompose$1$1RememberedValue, composerStartRestartGroup, 6);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup2 = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup2 != null) {
            scopeUpdateScopeEndRestartGroup2.updateScope(new Function2() { // from class: com.box.android.browse.cpl.itemsList.MultiselectActionModeComposeKt$$ExternalSyntheticLambda2
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return MultiselectActionModeComposeKt.MultiSelectActionModeCompose$lambda$3(store, i, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit MultiSelectActionModeCompose$lambda$1$0(Store store, boolean z) {
        store.send(new ActionableItemsListReducer.Action.PermissionResultReceived(z));
        return Unit.INSTANCE;
    }
}
