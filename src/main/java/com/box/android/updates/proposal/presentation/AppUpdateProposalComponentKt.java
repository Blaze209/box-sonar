package com.box.android.updates.proposal.presentation;

import android.app.Activity;
import androidx.activity.ComponentActivity;
import androidx.activity.compose.LocalActivityKt;
import androidx.appcompat.app.AppCompatActivity;
import androidx.compose.material3.SnackbarHostState;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.ProvidableCompositionLocal;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.State;
import androidx.compose.ui.res.StringResources_androidKt;
import androidx.hilt.navigation.compose.HiltViewModelKt;
import androidx.lifecycle.HasDefaultViewModelProviderFactory;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.compose.FlowExtKt;
import androidx.lifecycle.viewmodel.CreationExtras;
import androidx.lifecycle.viewmodel.compose.ViewModelKt;
import com.box.android.cpl.Store;
import com.box.android.updates.R;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: compiled from: AppUpdateProposalComponent.kt */
/* JADX INFO: loaded from: classes13.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\u001a\u001f\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005H\u0007¢\u0006\u0002\u0010\u0006¨\u0006\u0007²\u0006\n\u0010\b\u001a\u00020\tX\u008a\u0084\u0002"}, d2 = {"AppUpdateProposalComponent", "", "snackbarHostState", "Landroidx/compose/material3/SnackbarHostState;", "viewModel", "Lcom/box/android/updates/proposal/presentation/AppUpdateProposalViewModel;", "(Landroidx/compose/material3/SnackbarHostState;Lcom/box/android/updates/proposal/presentation/AppUpdateProposalViewModel;Landroidx/compose/runtime/Composer;II)V", "app-updates_generalProdRelease", "state", "Lcom/box/android/updates/proposal/presentation/AppUpdateProposalReducer$State;"}, k = 2, mv = {2, 2, 0}, xi = 48)
public final class AppUpdateProposalComponentKt {
    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit AppUpdateProposalComponent$lambda$1(SnackbarHostState snackbarHostState, AppUpdateProposalViewModel appUpdateProposalViewModel, int i, int i2, Composer composer, int i3) {
        AppUpdateProposalComponent(snackbarHostState, appUpdateProposalViewModel, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit AppUpdateProposalComponent$lambda$4(SnackbarHostState snackbarHostState, AppUpdateProposalViewModel appUpdateProposalViewModel, int i, int i2, Composer composer, int i3) {
        AppUpdateProposalComponent(snackbarHostState, appUpdateProposalViewModel, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX WARN: Code duplicated, block: B:42:0x00f6  */
    public static final void AppUpdateProposalComponent(final SnackbarHostState snackbarHostState, AppUpdateProposalViewModel appUpdateProposalViewModel, Composer composer, final int i, final int i2) {
        int i3;
        final AppUpdateProposalViewModel appUpdateProposalViewModel2;
        CreationExtras.Empty defaultViewModelCreationExtras;
        int i4;
        int i5;
        int i6;
        final AppUpdateProposalViewModel appUpdateProposalViewModel3;
        int i7;
        Intrinsics.checkNotNullParameter(snackbarHostState, "snackbarHostState");
        Composer composerStartRestartGroup = composer.startRestartGroup(713223645);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(AppUpdateProposalComponent)N(snackbarHostState,viewModel)27@1150L29,29@1217L64,30@1317L63,32@1428L70,35@1612L7,36@1677L80,36@1656L101,40@1796L990,40@1763L1023:AppUpdateProposalComponent.kt#jt10pp");
        if ((i & 6) == 0) {
            i3 = (composerStartRestartGroup.changed(snackbarHostState) ? 4 : 2) | i;
        } else {
            i3 = i;
        }
        if ((i & 48) == 0) {
            if ((i2 & 2) == 0) {
                appUpdateProposalViewModel2 = appUpdateProposalViewModel;
                int i8 = composerStartRestartGroup.changedInstance(appUpdateProposalViewModel2) ? 32 : 16;
                i3 |= i8;
            } else {
                appUpdateProposalViewModel2 = appUpdateProposalViewModel;
            }
            i3 |= i8;
        } else {
            appUpdateProposalViewModel2 = appUpdateProposalViewModel;
        }
        if (composerStartRestartGroup.shouldExecute((i3 & 19) != 18, i3 & 1)) {
            composerStartRestartGroup.startDefaults();
            ComposerKt.sourceInformation(composerStartRestartGroup, "24@1033L51");
            if ((i & 1) != 0 && !composerStartRestartGroup.getDefaultsInvalid()) {
                composerStartRestartGroup.skipToGroupEnd();
                if ((i2 & 2) != 0) {
                    AppUpdateProposalViewModel appUpdateProposalViewModel4 = appUpdateProposalViewModel2;
                    i6 = i3 & (-113);
                    appUpdateProposalViewModel3 = appUpdateProposalViewModel4;
                    i5 = 0;
                    i4 = 2023513938;
                } else {
                    i5 = 0;
                    i4 = 2023513938;
                    AppUpdateProposalViewModel appUpdateProposalViewModel5 = appUpdateProposalViewModel2;
                    i6 = i3;
                    appUpdateProposalViewModel3 = appUpdateProposalViewModel5;
                }
            } else if ((i2 & 2) != 0) {
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1447482489, "CC(hiltActivityViewModel)N(key)159@5773L7,160@5813L56:ComposeUtils.kt#vejmn0");
                ProvidableCompositionLocal<Activity> localActivity = LocalActivityKt.getLocalActivity();
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
                Object objConsume = composerStartRestartGroup.consume(localActivity);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                Intrinsics.checkNotNull(objConsume, "null cannot be cast to non-null type androidx.activity.ComponentActivity");
                ComponentActivity componentActivity = (ComponentActivity) objConsume;
                composerStartRestartGroup.startReplaceableGroup(1890788296);
                ComposerKt.sourceInformation(composerStartRestartGroup, "CC(hiltViewModel)P(1)*45@1969L7,50@2112L47,51@2171L54:HiltViewModel.kt#9mcars");
                ViewModelProvider.Factory factoryCreateHiltViewModelFactory = HiltViewModelKt.createHiltViewModelFactory(componentActivity, composerStartRestartGroup, 0);
                composerStartRestartGroup.startReplaceableGroup(1729797275);
                ComposerKt.sourceInformation(composerStartRestartGroup, "CC(viewModel)P(3,2,1)*80@3834L7,90@4209L68:ViewModel.kt#3tja67");
                if (componentActivity instanceof HasDefaultViewModelProviderFactory) {
                    defaultViewModelCreationExtras = componentActivity.getDefaultViewModelCreationExtras();
                } else {
                    defaultViewModelCreationExtras = CreationExtras.Empty.INSTANCE;
                }
                CreationExtras creationExtras = defaultViewModelCreationExtras;
                i4 = 2023513938;
                ViewModel viewModel = ViewModelKt.viewModel((Class<ViewModel>) AppUpdateProposalViewModel.class, componentActivity, (String) null, factoryCreateHiltViewModelFactory, creationExtras, composerStartRestartGroup, 36936, 0);
                composerStartRestartGroup = composerStartRestartGroup;
                composerStartRestartGroup.endReplaceableGroup();
                composerStartRestartGroup.endReplaceableGroup();
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                i5 = 0;
                i6 = i3 & (-113);
                appUpdateProposalViewModel3 = (AppUpdateProposalViewModel) viewModel;
            } else {
                i5 = 0;
                i4 = 2023513938;
                AppUpdateProposalViewModel appUpdateProposalViewModel6 = appUpdateProposalViewModel2;
                i6 = i3;
                appUpdateProposalViewModel3 = appUpdateProposalViewModel6;
            }
            composerStartRestartGroup.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(713223645, i6, -1, "com.box.android.updates.proposal.presentation.AppUpdateProposalComponent (AppUpdateProposalComponent.kt:25)");
            }
            Store<AppUpdateProposalReducer.State, AppUpdateProposalReducer.Action> store = appUpdateProposalViewModel3.getStore();
            int i9 = i5;
            State stateCollectAsStateWithLifecycle = FlowExtKt.collectAsStateWithLifecycle(store.getState(), (LifecycleOwner) null, (Lifecycle.State) null, (CoroutineContext) null, composerStartRestartGroup, 0, 7);
            String strStringResource = StringResources_androidKt.stringResource(R.string.app_update_proposal_downloading_message, composerStartRestartGroup, i9);
            String strStringResource2 = StringResources_androidKt.stringResource(R.string.app_update_proposal_downloaded_message, composerStartRestartGroup, i9);
            String strStringResource3 = StringResources_androidKt.stringResource(R.string.app_update_proposal_downloaded_restart_action, composerStartRestartGroup, i9);
            ProvidableCompositionLocal<Activity> localActivity2 = LocalActivityKt.getLocalActivity();
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, i4, "CC(<get-current>):CompositionLocal.kt#9igjgp");
            Object objConsume2 = composerStartRestartGroup.consume(localActivity2);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            AppCompatActivity appCompatActivity = objConsume2 instanceof AppCompatActivity ? (AppCompatActivity) objConsume2 : null;
            if (appCompatActivity != null) {
                Unit unit = Unit.INSTANCE;
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1786820051, "CC(remember):AppUpdateProposalComponent.kt#9igjgp");
                boolean zChanged = composerStartRestartGroup.changed(store) | composerStartRestartGroup.changedInstance(appCompatActivity);
                AppUpdateProposalComponentKt$AppUpdateProposalComponent$1$1 appUpdateProposalComponentKt$AppUpdateProposalComponent$1$1RememberedValue = composerStartRestartGroup.rememberedValue();
                if (zChanged || appUpdateProposalComponentKt$AppUpdateProposalComponent$1$1RememberedValue == Composer.INSTANCE.getEmpty()) {
                    appUpdateProposalComponentKt$AppUpdateProposalComponent$1$1RememberedValue = new AppUpdateProposalComponentKt$AppUpdateProposalComponent$1$1(store, appCompatActivity, null);
                    composerStartRestartGroup.updateRememberedValue(appUpdateProposalComponentKt$AppUpdateProposalComponent$1$1RememberedValue);
                }
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                EffectsKt.LaunchedEffect(unit, (Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object>) appUpdateProposalComponentKt$AppUpdateProposalComponent$1$1RememberedValue, composerStartRestartGroup, 6);
                AppUpdateProposalReducer.ViewEffect viewEffect = AppUpdateProposalComponent$lambda$0(stateCollectAsStateWithLifecycle).getViewEffect();
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1786815333, "CC(remember):AppUpdateProposalComponent.kt#9igjgp");
                boolean zChanged2 = composerStartRestartGroup.changed(stateCollectAsStateWithLifecycle) | ((i6 & 14) == 4) | composerStartRestartGroup.changed(strStringResource) | composerStartRestartGroup.changed(store) | composerStartRestartGroup.changed(strStringResource2) | composerStartRestartGroup.changed(strStringResource3);
                AppUpdateProposalComponentKt$AppUpdateProposalComponent$2$1 appUpdateProposalComponentKt$AppUpdateProposalComponent$2$1RememberedValue = composerStartRestartGroup.rememberedValue();
                if (zChanged2 || appUpdateProposalComponentKt$AppUpdateProposalComponent$2$1RememberedValue == Composer.INSTANCE.getEmpty()) {
                    i7 = 0;
                    appUpdateProposalComponentKt$AppUpdateProposalComponent$2$1RememberedValue = new AppUpdateProposalComponentKt$AppUpdateProposalComponent$2$1(snackbarHostState, strStringResource, store, strStringResource2, strStringResource3, stateCollectAsStateWithLifecycle, null);
                    composerStartRestartGroup.updateRememberedValue(appUpdateProposalComponentKt$AppUpdateProposalComponent$2$1RememberedValue);
                } else {
                    i7 = 0;
                }
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                EffectsKt.LaunchedEffect(viewEffect, (Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object>) appUpdateProposalComponentKt$AppUpdateProposalComponent$2$1RememberedValue, composerStartRestartGroup, i7);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                appUpdateProposalViewModel2 = appUpdateProposalViewModel3;
            } else {
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.box.android.updates.proposal.presentation.AppUpdateProposalComponentKt$$ExternalSyntheticLambda0
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return AppUpdateProposalComponentKt.AppUpdateProposalComponent$lambda$1(snackbarHostState, appUpdateProposalViewModel3, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    });
                    return;
                }
                return;
            }
        } else {
            composerStartRestartGroup.skipToGroupEnd();
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup2 = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup2 != null) {
            scopeUpdateScopeEndRestartGroup2.updateScope(new Function2() { // from class: com.box.android.updates.proposal.presentation.AppUpdateProposalComponentKt$$ExternalSyntheticLambda1
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return AppUpdateProposalComponentKt.AppUpdateProposalComponent$lambda$4(snackbarHostState, appUpdateProposalViewModel2, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final AppUpdateProposalReducer.State AppUpdateProposalComponent$lambda$0(State<AppUpdateProposalReducer.State> state) {
        return state.getValue();
    }
}
