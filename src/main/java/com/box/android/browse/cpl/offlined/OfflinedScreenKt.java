package com.box.android.browse.cpl.offlined;

import android.app.Activity;
import androidx.activity.ComponentActivity;
import androidx.activity.compose.LocalActivityKt;
import androidx.compose.material3.SnackbarHostState;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.ProvidableCompositionLocal;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.State;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.layout.OnVisibilityChangedModifierKt;
import androidx.compose.ui.res.StringResources_androidKt;
import androidx.hilt.navigation.compose.HiltViewModelKt;
import androidx.lifecycle.HasDefaultViewModelProviderFactory;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.compose.FlowExtKt;
import androidx.lifecycle.compose.LifecycleEffectKt;
import androidx.lifecycle.viewmodel.CreationExtras;
import androidx.lifecycle.viewmodel.compose.ViewModelKt;
import androidx.profileinstaller.ProfileVerifier;
import com.box.android.base.presentation.message.BoxMessageDispatcher;
import com.box.android.base.presentation.message.BoxMessageListenerEffectKt;
import com.box.android.base.presentation.state.HomeScreenViewsVisibilityState;
import com.box.android.browse.R;
import com.box.android.browse.cpl.itemsList.ActionableItemsListReducer;
import com.box.android.browse.cpl.itemsList.ItemsListReducer;
import com.box.android.browse.cpl.message.OfflineScreenBoxMessageHandler;
import com.box.android.browse.cpl.navigationmodernization.BrowseNavigator;
import com.box.android.coreservices.modelcontroller.messages.BoxMessage;
import com.box.android.cpl.Store;
import external.sdk.pendo.io.mozilla.javascript.Token;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: compiled from: OfflinedScreen.kt */
/* JADX INFO: loaded from: classes10.dex */
@Metadata(d1 = {"\u0000J\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\u001aO\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b2\b\b\u0002\u0010\f\u001a\u00020\r2\b\b\u0002\u0010\u000e\u001a\u00020\u000fH\u0007¢\u0006\u0002\u0010\u0010\u001a1\u0010\u0011\u001a\u00020\u00012\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0002\u001a\u00020\u00032\u0012\u0010\u0014\u001a\u000e\u0012\u0004\u0012\u00020\u0016\u0012\u0004\u0012\u00020\u00170\u0015H\u0003¢\u0006\u0002\u0010\u0018\u001a\u001f\u0010\u0019\u001a\u00020\u00012\u0006\u0010\u001a\u001a\u00020\r2\b\u0010\n\u001a\u0004\u0018\u00010\u000bH\u0003¢\u0006\u0002\u0010\u001b\u001a1\u0010\u001c\u001a\u00020\u00012\u0006\u0010\u001d\u001a\u00020\u00162\u0012\u0010\u0014\u001a\u000e\u0012\u0004\u0012\u00020\u0016\u0012\u0004\u0012\u00020\u00170\u00152\u0006\u0010\u0006\u001a\u00020\u0007H\u0003¢\u0006\u0002\u0010\u001e¨\u0006\u001f²\u0006\n\u0010\u001d\u001a\u00020\u0016X\u008a\u0084\u0002"}, d2 = {"OfflinedScreen", "", "navigator", "Lcom/box/android/browse/cpl/navigationmodernization/BrowseNavigator;", "boxMessageDispatcher", "Lcom/box/android/base/presentation/message/BoxMessageDispatcher;", "snackbarHostState", "Landroidx/compose/material3/SnackbarHostState;", "modifier", "Landroidx/compose/ui/Modifier;", "homeScreenViewsVisibilityState", "Lcom/box/android/base/presentation/state/HomeScreenViewsVisibilityState;", "shouldUseAiCenter", "", "viewModel", "Lcom/box/android/browse/cpl/offlined/OfflinedViewModel;", "(Lcom/box/android/browse/cpl/navigationmodernization/BrowseNavigator;Lcom/box/android/base/presentation/message/BoxMessageDispatcher;Landroidx/compose/material3/SnackbarHostState;Landroidx/compose/ui/Modifier;Lcom/box/android/base/presentation/state/HomeScreenViewsVisibilityState;ZLcom/box/android/browse/cpl/offlined/OfflinedViewModel;Landroidx/compose/runtime/Composer;II)V", "NavigationRouteEffect", "route", "Lcom/box/android/browse/cpl/offlined/OfflinedReducer$Route;", "store", "Lcom/box/android/cpl/Store;", "Lcom/box/android/browse/cpl/offlined/OfflinedReducer$State;", "Lcom/box/android/browse/cpl/offlined/OfflinedReducer$Action;", "(Lcom/box/android/browse/cpl/offlined/OfflinedReducer$Route;Lcom/box/android/browse/cpl/navigationmodernization/BrowseNavigator;Lcom/box/android/cpl/Store;Landroidx/compose/runtime/Composer;I)V", "SelectionModeViewsVisibilityEffect", "isSelecting", "(ZLcom/box/android/base/presentation/state/HomeScreenViewsVisibilityState;Landroidx/compose/runtime/Composer;I)V", "UpdateItemsSnackbarEffect", "state", "(Lcom/box/android/browse/cpl/offlined/OfflinedReducer$State;Lcom/box/android/cpl/Store;Landroidx/compose/material3/SnackbarHostState;Landroidx/compose/runtime/Composer;I)V", "browse_generalProdRelease"}, k = 2, mv = {2, 2, 0}, xi = 48)
public final class OfflinedScreenKt {
    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit NavigationRouteEffect$lambda$1(OfflinedReducer.Route route, BrowseNavigator browseNavigator, Store store, int i, Composer composer, int i2) {
        NavigationRouteEffect(route, browseNavigator, store, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit OfflinedScreen$lambda$6(BrowseNavigator browseNavigator, BoxMessageDispatcher boxMessageDispatcher, SnackbarHostState snackbarHostState, Modifier modifier, HomeScreenViewsVisibilityState homeScreenViewsVisibilityState, boolean z, OfflinedViewModel offlinedViewModel, int i, int i2, Composer composer, int i3) {
        OfflinedScreen(browseNavigator, boxMessageDispatcher, snackbarHostState, modifier, homeScreenViewsVisibilityState, z, offlinedViewModel, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit SelectionModeViewsVisibilityEffect$lambda$0(boolean z, HomeScreenViewsVisibilityState homeScreenViewsVisibilityState, int i, Composer composer, int i2) {
        SelectionModeViewsVisibilityEffect(z, homeScreenViewsVisibilityState, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit SelectionModeViewsVisibilityEffect$lambda$2(boolean z, HomeScreenViewsVisibilityState homeScreenViewsVisibilityState, int i, Composer composer, int i2) {
        SelectionModeViewsVisibilityEffect(z, homeScreenViewsVisibilityState, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit UpdateItemsSnackbarEffect$lambda$1(OfflinedReducer.State state, Store store, SnackbarHostState snackbarHostState, int i, Composer composer, int i2) {
        UpdateItemsSnackbarEffect(state, store, snackbarHostState, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX WARN: Code duplicated, block: B:100:0x016e  */
    /* JADX WARN: Code duplicated, block: B:102:0x0192  */
    /* JADX WARN: Code duplicated, block: B:105:0x01a0  */
    /* JADX WARN: Code duplicated, block: B:108:0x01d8  */
    /* JADX WARN: Code duplicated, block: B:111:0x01fa  */
    /* JADX WARN: Code duplicated, block: B:113:0x0202  */
    /* JADX WARN: Code duplicated, block: B:116:0x022f  */
    /* JADX WARN: Code duplicated, block: B:118:0x0237  */
    /* JADX WARN: Code duplicated, block: B:121:0x02a2  */
    /* JADX WARN: Code duplicated, block: B:123:0x02aa  */
    /* JADX WARN: Code duplicated, block: B:126:0x02d1  */
    /* JADX WARN: Code duplicated, block: B:128:0x02d9  */
    /* JADX WARN: Code duplicated, block: B:131:0x02f6  */
    /* JADX WARN: Code duplicated, block: B:133:0x02fe  */
    /* JADX WARN: Code duplicated, block: B:136:0x030b  */
    /* JADX WARN: Code duplicated, block: B:138:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:40:0x007e  */
    /* JADX WARN: Code duplicated, block: B:41:0x0081  */
    /* JADX WARN: Code duplicated, block: B:43:0x0085  */
    /* JADX WARN: Code duplicated, block: B:45:0x008d  */
    /* JADX WARN: Code duplicated, block: B:46:0x0090  */
    /* JADX WARN: Code duplicated, block: B:51:0x009c  */
    /* JADX WARN: Code duplicated, block: B:52:0x009e  */
    /* JADX WARN: Code duplicated, block: B:54:0x00a1  */
    /* JADX WARN: Code duplicated, block: B:56:0x00a9  */
    /* JADX WARN: Code duplicated, block: B:57:0x00ac  */
    /* JADX WARN: Code duplicated, block: B:62:0x00b7  */
    /* JADX WARN: Code duplicated, block: B:64:0x00bb  */
    /* JADX WARN: Code duplicated, block: B:66:0x00c3  */
    /* JADX WARN: Code duplicated, block: B:67:0x00c6  */
    /* JADX WARN: Code duplicated, block: B:70:0x00cc  */
    /* JADX WARN: Code duplicated, block: B:73:0x00d8  */
    /* JADX WARN: Code duplicated, block: B:74:0x00da  */
    /* JADX WARN: Code duplicated, block: B:77:0x00e3  */
    /* JADX WARN: Code duplicated, block: B:79:0x00f3  */
    /* JADX WARN: Code duplicated, block: B:87:0x010c A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:88:0x010e  */
    /* JADX WARN: Code duplicated, block: B:90:0x0115  */
    /* JADX WARN: Code duplicated, block: B:91:0x0117  */
    /* JADX WARN: Code duplicated, block: B:93:0x011a  */
    /* JADX WARN: Code duplicated, block: B:94:0x011c  */
    /* JADX WARN: Code duplicated, block: B:97:0x0121  */
    /* JADX WARN: Code duplicated, block: B:99:0x0166  */
    public static final void OfflinedScreen(final BrowseNavigator navigator, final BoxMessageDispatcher boxMessageDispatcher, final SnackbarHostState snackbarHostState, Modifier modifier, HomeScreenViewsVisibilityState homeScreenViewsVisibilityState, boolean z, OfflinedViewModel offlinedViewModel, Composer composer, final int i, final int i2) {
        int i3;
        Modifier modifier2;
        int i4;
        HomeScreenViewsVisibilityState homeScreenViewsVisibilityState2;
        int i5;
        int i6;
        boolean z2;
        int i7;
        OfflinedViewModel offlinedViewModel2;
        boolean z3;
        final Modifier modifier3;
        final HomeScreenViewsVisibilityState homeScreenViewsVisibilityState3;
        final boolean z4;
        final OfflinedViewModel offlinedViewModel3;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        Continuation continuation;
        boolean z5;
        Modifier modifier4;
        ComponentActivity componentActivity;
        CreationExtras.Empty defaultViewModelCreationExtras;
        int i8;
        OfflinedViewModel offlinedViewModel4;
        final Store<OfflinedReducer.State, OfflinedReducer.Action> store;
        OfflinedScreenKt$OfflinedScreen$1$1 offlinedScreenKt$OfflinedScreen$1$1RememberedValue;
        boolean zChanged;
        Object objRememberedValue;
        boolean zChanged2;
        Object objRememberedValue2;
        boolean zChanged3;
        Object objRememberedValue3;
        boolean zChanged4;
        Object objRememberedValue4;
        Intrinsics.checkNotNullParameter(navigator, "navigator");
        Intrinsics.checkNotNullParameter(boxMessageDispatcher, "boxMessageDispatcher");
        Intrinsics.checkNotNullParameter(snackbarHostState, "snackbarHostState");
        Composer composerStartRestartGroup = composer.startRestartGroup(-523938171);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(OfflinedScreen)N(navigator,boxMessageDispatcher,snackbarHostState,modifier,homeScreenViewsVisibilityState,shouldUseAiCenter,viewModel)42@2045L29,46@2145L144,51@2424L145,56@2628L197,44@2080L787,64@2873L120,70@2999L179,75@3184L58,77@3295L131,77@3248L178,83@3480L261,83@3432L309:OfflinedScreen.kt#t6qdi3");
        if ((i & 6) == 0) {
            i3 = (composerStartRestartGroup.changedInstance(navigator) ? 4 : 2) | i;
        } else {
            i3 = i;
        }
        if ((i & 48) == 0) {
            i3 |= (i & 64) == 0 ? composerStartRestartGroup.changed(boxMessageDispatcher) : composerStartRestartGroup.changedInstance(boxMessageDispatcher) ? 32 : 16;
        }
        if ((i & 384) == 0) {
            i3 |= composerStartRestartGroup.changed(snackbarHostState) ? 256 : 128;
        }
        int i9 = i2 & 8;
        if (i9 == 0) {
            if ((i & 3072) == 0) {
                modifier2 = modifier;
                i3 |= composerStartRestartGroup.changed(modifier2) ? 2048 : 1024;
            }
            i4 = i2 & 16;
            if (i4 != 0) {
                if ((i & 24576) == 0) {
                    homeScreenViewsVisibilityState2 = homeScreenViewsVisibilityState;
                    if (composerStartRestartGroup.changed(homeScreenViewsVisibilityState2)) {
                        i5 = 16384;
                    } else {
                        i5 = 8192;
                    }
                    i3 |= i5;
                }
                i6 = i2 & 32;
                if (i6 != 0) {
                    if ((196608 & i) == 0) {
                        z2 = z;
                        if (composerStartRestartGroup.changed(z2)) {
                            i7 = 131072;
                        } else {
                            i7 = 65536;
                        }
                        i3 |= i7;
                    }
                    if ((1572864 & i) == 0) {
                        if ((i2 & 64) == 0) {
                            offlinedViewModel2 = offlinedViewModel;
                            int i10 = composerStartRestartGroup.changedInstance(offlinedViewModel2) ? 1048576 : 524288;
                            i3 |= i10;
                        } else {
                            offlinedViewModel2 = offlinedViewModel;
                        }
                        i3 |= i10;
                    } else {
                        offlinedViewModel2 = offlinedViewModel;
                    }
                    if ((599187 & i3) != 599186) {
                        z3 = true;
                    } else {
                        z3 = false;
                    }
                    if (composerStartRestartGroup.shouldExecute(z3, i3 & 1)) {
                        composerStartRestartGroup.startDefaults();
                        ComposerKt.sourceInformation(composerStartRestartGroup, "39@1956L23");
                        continuation = null;
                        if ((i & 1) != 0 || composerStartRestartGroup.getDefaultsInvalid()) {
                            if (i9 != 0) {
                                modifier2 = Modifier.INSTANCE;
                            }
                            if (i4 != 0) {
                                homeScreenViewsVisibilityState3 = null;
                            } else {
                                homeScreenViewsVisibilityState3 = homeScreenViewsVisibilityState2;
                            }
                            if (i6 != 0) {
                                z5 = false;
                            } else {
                                z5 = z2;
                            }
                            if ((i2 & 64) != 0) {
                                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1447482489, "CC(hiltActivityViewModel)N(key)159@5773L7,160@5813L56:ComposeUtils.kt#vejmn0");
                                ProvidableCompositionLocal<Activity> localActivity = LocalActivityKt.getLocalActivity();
                                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
                                Object objConsume = composerStartRestartGroup.consume(localActivity);
                                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                                Intrinsics.checkNotNull(objConsume, "null cannot be cast to non-null type androidx.activity.ComponentActivity");
                                componentActivity = (ComponentActivity) objConsume;
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
                                continuation = null;
                                ViewModel viewModel = ViewModelKt.viewModel((Class<ViewModel>) OfflinedViewModel.class, componentActivity, (String) null, factoryCreateHiltViewModelFactory, creationExtras, composerStartRestartGroup, 36936, 0);
                                composerStartRestartGroup.endReplaceableGroup();
                                composerStartRestartGroup.endReplaceableGroup();
                                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                                modifier4 = modifier2;
                                i8 = i3 & (-3670017);
                                offlinedViewModel4 = (OfflinedViewModel) viewModel;
                            } else {
                                modifier4 = modifier2;
                            }
                            composerStartRestartGroup.endDefaults();
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(-523938171, i8, -1, "com.box.android.browse.cpl.offlined.OfflinedScreen (OfflinedScreen.kt:40)");
                            }
                            store = offlinedViewModel4.getStore();
                            State stateCollectAsStateWithLifecycle = FlowExtKt.collectAsStateWithLifecycle(store.getState(), (LifecycleOwner) null, (Lifecycle.State) null, (CoroutineContext) null, composerStartRestartGroup, 0, 7);
                            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -993392011, "CC(remember):OfflinedScreen.kt#9igjgp");
                            offlinedScreenKt$OfflinedScreen$1$1RememberedValue = composerStartRestartGroup.rememberedValue();
                            if (offlinedScreenKt$OfflinedScreen$1$1RememberedValue == Composer.INSTANCE.getEmpty()) {
                                offlinedScreenKt$OfflinedScreen$1$1RememberedValue = new OfflinedScreenKt$OfflinedScreen$1$1(snackbarHostState, continuation);
                                composerStartRestartGroup.updateRememberedValue(offlinedScreenKt$OfflinedScreen$1$1RememberedValue);
                            }
                            Function4 function4 = (Function4) offlinedScreenKt$OfflinedScreen$1$1RememberedValue;
                            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -993383082, "CC(remember):OfflinedScreen.kt#9igjgp");
                            zChanged = composerStartRestartGroup.changed(store);
                            objRememberedValue = composerStartRestartGroup.rememberedValue();
                            if (!zChanged || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                                objRememberedValue = new Function1() { // from class: com.box.android.browse.cpl.offlined.OfflinedScreenKt$$ExternalSyntheticLambda4
                                    @Override // kotlin.jvm.functions.Function1
                                    public final Object invoke(Object obj) {
                                        return OfflinedScreenKt.OfflinedScreen$lambda$2$0(store, ((Boolean) obj).booleanValue());
                                    }
                                };
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                            }
                            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                            Modifier modifierOnVisibilityChanged$default = OnVisibilityChangedModifierKt.onVisibilityChanged$default(modifier4, 0L, 1.0f, null, (Function1) objRememberedValue, 5, null);
                            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -993376502, "CC(remember):OfflinedScreen.kt#9igjgp");
                            zChanged2 = composerStartRestartGroup.changed(store);
                            objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                            if (!zChanged2 || objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                                objRememberedValue2 = new Function1() { // from class: com.box.android.browse.cpl.offlined.OfflinedScreenKt$$ExternalSyntheticLambda5
                                    @Override // kotlin.jvm.functions.Function1
                                    public final Object invoke(Object obj) {
                                        return OfflinedScreenKt.OfflinedScreen$lambda$3$0(store, ((Boolean) obj).booleanValue());
                                    }
                                };
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                            }
                            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                            int i11 = i8 >> 3;
                            OfflinedContentKt.OfflinedContent(store, OnVisibilityChangedModifierKt.onVisibilityChanged$default(modifierOnVisibilityChanged$default, 0L, 0.0f, null, (Function1) objRememberedValue2, 5, null), function4, true, z5, composerStartRestartGroup, (i11 & 57344) | 3072, 0);
                            NavigationRouteEffect(OfflinedScreen$lambda$0(stateCollectAsStateWithLifecycle).getNavigationRoute(), navigator, store, composerStartRestartGroup, (i8 << 3) & 112);
                            SelectionModeViewsVisibilityEffect(OfflinedScreen$lambda$0(stateCollectAsStateWithLifecycle).getActionableItemsListState().getIsSelecting(), homeScreenViewsVisibilityState3, composerStartRestartGroup, (i8 >> 9) & 112);
                            UpdateItemsSnackbarEffect(OfflinedScreen$lambda$0(stateCollectAsStateWithLifecycle), store, snackbarHostState, composerStartRestartGroup, i8 & 896);
                            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -993355224, "CC(remember):OfflinedScreen.kt#9igjgp");
                            zChanged3 = composerStartRestartGroup.changed(store);
                            objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                            if (!zChanged3 || objRememberedValue3 == Composer.INSTANCE.getEmpty()) {
                                objRememberedValue3 = new Function1() { // from class: com.box.android.browse.cpl.offlined.OfflinedScreenKt$$ExternalSyntheticLambda6
                                    @Override // kotlin.jvm.functions.Function1
                                    public final Object invoke(Object obj) {
                                        return OfflinedScreenKt.OfflinedScreen$lambda$4$0(store, (BoxMessage) obj);
                                    }
                                };
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                            }
                            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                            BoxMessageListenerEffectKt.BoxMessageListenerEffect(boxMessageDispatcher, (Function1) objRememberedValue3, composerStartRestartGroup, BoxMessageDispatcher.$stable | (i11 & 14));
                            Lifecycle.Event event = Lifecycle.Event.ON_RESUME;
                            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -993349174, "CC(remember):OfflinedScreen.kt#9igjgp");
                            zChanged4 = composerStartRestartGroup.changed(store);
                            objRememberedValue4 = composerStartRestartGroup.rememberedValue();
                            if (!zChanged4 || objRememberedValue4 == Composer.INSTANCE.getEmpty()) {
                                objRememberedValue4 = new Function0() { // from class: com.box.android.browse.cpl.offlined.OfflinedScreenKt$$ExternalSyntheticLambda7
                                    @Override // kotlin.jvm.functions.Function0
                                    public final Object invoke() {
                                        return OfflinedScreenKt.OfflinedScreen$lambda$5$0(store);
                                    }
                                };
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue4);
                            }
                            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                            LifecycleEffectKt.LifecycleEventEffect(event, null, (Function0) objRememberedValue4, composerStartRestartGroup, 6, 2);
                            composerStartRestartGroup = composerStartRestartGroup;
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                            z4 = z5;
                            offlinedViewModel3 = offlinedViewModel4;
                            modifier3 = modifier4;
                        } else {
                            composerStartRestartGroup.skipToGroupEnd();
                            if ((i2 & 64) != 0) {
                                i3 &= -3670017;
                            }
                            modifier4 = modifier2;
                            homeScreenViewsVisibilityState3 = homeScreenViewsVisibilityState2;
                            z5 = z2;
                        }
                        i8 = i3;
                        offlinedViewModel4 = offlinedViewModel2;
                        composerStartRestartGroup.endDefaults();
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-523938171, i8, -1, "com.box.android.browse.cpl.offlined.OfflinedScreen (OfflinedScreen.kt:40)");
                        }
                        store = offlinedViewModel4.getStore();
                        State stateCollectAsStateWithLifecycle2 = FlowExtKt.collectAsStateWithLifecycle(store.getState(), (LifecycleOwner) null, (Lifecycle.State) null, (CoroutineContext) null, composerStartRestartGroup, 0, 7);
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -993392011, "CC(remember):OfflinedScreen.kt#9igjgp");
                        offlinedScreenKt$OfflinedScreen$1$1RememberedValue = composerStartRestartGroup.rememberedValue();
                        if (offlinedScreenKt$OfflinedScreen$1$1RememberedValue == Composer.INSTANCE.getEmpty()) {
                            offlinedScreenKt$OfflinedScreen$1$1RememberedValue = new OfflinedScreenKt$OfflinedScreen$1$1(snackbarHostState, continuation);
                            composerStartRestartGroup.updateRememberedValue(offlinedScreenKt$OfflinedScreen$1$1RememberedValue);
                        }
                        Function4 function5 = (Function4) offlinedScreenKt$OfflinedScreen$1$1RememberedValue;
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -993383082, "CC(remember):OfflinedScreen.kt#9igjgp");
                        zChanged = composerStartRestartGroup.changed(store);
                        objRememberedValue = composerStartRestartGroup.rememberedValue();
                        if (!zChanged) {
                            objRememberedValue = new Function1() { // from class: com.box.android.browse.cpl.offlined.OfflinedScreenKt$$ExternalSyntheticLambda4
                                @Override // kotlin.jvm.functions.Function1
                                public final Object invoke(Object obj) {
                                    return OfflinedScreenKt.OfflinedScreen$lambda$2$0(store, ((Boolean) obj).booleanValue());
                                }
                            };
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                        } else {
                            objRememberedValue = new Function1() { // from class: com.box.android.browse.cpl.offlined.OfflinedScreenKt$$ExternalSyntheticLambda4
                                @Override // kotlin.jvm.functions.Function1
                                public final Object invoke(Object obj) {
                                    return OfflinedScreenKt.OfflinedScreen$lambda$2$0(store, ((Boolean) obj).booleanValue());
                                }
                            };
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                        }
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        Modifier modifierOnVisibilityChanged$default2 = OnVisibilityChangedModifierKt.onVisibilityChanged$default(modifier4, 0L, 1.0f, null, (Function1) objRememberedValue, 5, null);
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -993376502, "CC(remember):OfflinedScreen.kt#9igjgp");
                        zChanged2 = composerStartRestartGroup.changed(store);
                        objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                        if (!zChanged2) {
                            objRememberedValue2 = new Function1() { // from class: com.box.android.browse.cpl.offlined.OfflinedScreenKt$$ExternalSyntheticLambda5
                                @Override // kotlin.jvm.functions.Function1
                                public final Object invoke(Object obj) {
                                    return OfflinedScreenKt.OfflinedScreen$lambda$3$0(store, ((Boolean) obj).booleanValue());
                                }
                            };
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                        } else {
                            objRememberedValue2 = new Function1() { // from class: com.box.android.browse.cpl.offlined.OfflinedScreenKt$$ExternalSyntheticLambda5
                                @Override // kotlin.jvm.functions.Function1
                                public final Object invoke(Object obj) {
                                    return OfflinedScreenKt.OfflinedScreen$lambda$3$0(store, ((Boolean) obj).booleanValue());
                                }
                            };
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                        }
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        int i12 = i8 >> 3;
                        OfflinedContentKt.OfflinedContent(store, OnVisibilityChangedModifierKt.onVisibilityChanged$default(modifierOnVisibilityChanged$default2, 0L, 0.0f, null, (Function1) objRememberedValue2, 5, null), function5, true, z5, composerStartRestartGroup, (i12 & 57344) | 3072, 0);
                        NavigationRouteEffect(OfflinedScreen$lambda$0(stateCollectAsStateWithLifecycle2).getNavigationRoute(), navigator, store, composerStartRestartGroup, (i8 << 3) & 112);
                        SelectionModeViewsVisibilityEffect(OfflinedScreen$lambda$0(stateCollectAsStateWithLifecycle2).getActionableItemsListState().getIsSelecting(), homeScreenViewsVisibilityState3, composerStartRestartGroup, (i8 >> 9) & 112);
                        UpdateItemsSnackbarEffect(OfflinedScreen$lambda$0(stateCollectAsStateWithLifecycle2), store, snackbarHostState, composerStartRestartGroup, i8 & 896);
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -993355224, "CC(remember):OfflinedScreen.kt#9igjgp");
                        zChanged3 = composerStartRestartGroup.changed(store);
                        objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                        if (!zChanged3) {
                            objRememberedValue3 = new Function1() { // from class: com.box.android.browse.cpl.offlined.OfflinedScreenKt$$ExternalSyntheticLambda6
                                @Override // kotlin.jvm.functions.Function1
                                public final Object invoke(Object obj) {
                                    return OfflinedScreenKt.OfflinedScreen$lambda$4$0(store, (BoxMessage) obj);
                                }
                            };
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                        } else {
                            objRememberedValue3 = new Function1() { // from class: com.box.android.browse.cpl.offlined.OfflinedScreenKt$$ExternalSyntheticLambda6
                                @Override // kotlin.jvm.functions.Function1
                                public final Object invoke(Object obj) {
                                    return OfflinedScreenKt.OfflinedScreen$lambda$4$0(store, (BoxMessage) obj);
                                }
                            };
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                        }
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        BoxMessageListenerEffectKt.BoxMessageListenerEffect(boxMessageDispatcher, (Function1) objRememberedValue3, composerStartRestartGroup, BoxMessageDispatcher.$stable | (i12 & 14));
                        Lifecycle.Event event2 = Lifecycle.Event.ON_RESUME;
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -993349174, "CC(remember):OfflinedScreen.kt#9igjgp");
                        zChanged4 = composerStartRestartGroup.changed(store);
                        objRememberedValue4 = composerStartRestartGroup.rememberedValue();
                        if (!zChanged4) {
                            objRememberedValue4 = new Function0() { // from class: com.box.android.browse.cpl.offlined.OfflinedScreenKt$$ExternalSyntheticLambda7
                                @Override // kotlin.jvm.functions.Function0
                                public final Object invoke() {
                                    return OfflinedScreenKt.OfflinedScreen$lambda$5$0(store);
                                }
                            };
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue4);
                        } else {
                            objRememberedValue4 = new Function0() { // from class: com.box.android.browse.cpl.offlined.OfflinedScreenKt$$ExternalSyntheticLambda7
                                @Override // kotlin.jvm.functions.Function0
                                public final Object invoke() {
                                    return OfflinedScreenKt.OfflinedScreen$lambda$5$0(store);
                                }
                            };
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue4);
                        }
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        LifecycleEffectKt.LifecycleEventEffect(event2, null, (Function0) objRememberedValue4, composerStartRestartGroup, 6, 2);
                        composerStartRestartGroup = composerStartRestartGroup;
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        z4 = z5;
                        offlinedViewModel3 = offlinedViewModel4;
                        modifier3 = modifier4;
                    } else {
                        composerStartRestartGroup.skipToGroupEnd();
                        modifier3 = modifier2;
                        homeScreenViewsVisibilityState3 = homeScreenViewsVisibilityState2;
                        z4 = z2;
                        offlinedViewModel3 = offlinedViewModel2;
                    }
                    scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup != null) {
                        scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.box.android.browse.cpl.offlined.OfflinedScreenKt$$ExternalSyntheticLambda8
                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj, Object obj2) {
                                return OfflinedScreenKt.OfflinedScreen$lambda$6(navigator, boxMessageDispatcher, snackbarHostState, modifier3, homeScreenViewsVisibilityState3, z4, offlinedViewModel3, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                            }
                        });
                    }
                }
                i3 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
                z2 = z;
                if ((1572864 & i) == 0) {
                    if ((i2 & 64) == 0) {
                        offlinedViewModel2 = offlinedViewModel;
                        if (composerStartRestartGroup.changedInstance(offlinedViewModel2)) {
                        }
                        i3 |= i10;
                    } else {
                        offlinedViewModel2 = offlinedViewModel;
                    }
                    i3 |= i10;
                } else {
                    offlinedViewModel2 = offlinedViewModel;
                }
                if ((599187 & i3) != 599186) {
                    z3 = true;
                } else {
                    z3 = false;
                }
                if (composerStartRestartGroup.shouldExecute(z3, i3 & 1)) {
                    composerStartRestartGroup.startDefaults();
                    ComposerKt.sourceInformation(composerStartRestartGroup, "39@1956L23");
                    continuation = null;
                    if ((i & 1) != 0) {
                        if (i9 != 0) {
                            modifier2 = Modifier.INSTANCE;
                        }
                        if (i4 != 0) {
                            homeScreenViewsVisibilityState3 = null;
                        } else {
                            homeScreenViewsVisibilityState3 = homeScreenViewsVisibilityState2;
                        }
                        if (i6 != 0) {
                            z5 = false;
                        } else {
                            z5 = z2;
                        }
                        if ((i2 & 64) != 0) {
                            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1447482489, "CC(hiltActivityViewModel)N(key)159@5773L7,160@5813L56:ComposeUtils.kt#vejmn0");
                            ProvidableCompositionLocal<Activity> localActivity2 = LocalActivityKt.getLocalActivity();
                            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
                            Object objConsume2 = composerStartRestartGroup.consume(localActivity2);
                            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                            Intrinsics.checkNotNull(objConsume2, "null cannot be cast to non-null type androidx.activity.ComponentActivity");
                            componentActivity = (ComponentActivity) objConsume2;
                            composerStartRestartGroup.startReplaceableGroup(1890788296);
                            ComposerKt.sourceInformation(composerStartRestartGroup, "CC(hiltViewModel)P(1)*45@1969L7,50@2112L47,51@2171L54:HiltViewModel.kt#9mcars");
                            ViewModelProvider.Factory factoryCreateHiltViewModelFactory2 = HiltViewModelKt.createHiltViewModelFactory(componentActivity, composerStartRestartGroup, 0);
                            composerStartRestartGroup.startReplaceableGroup(1729797275);
                            ComposerKt.sourceInformation(composerStartRestartGroup, "CC(viewModel)P(3,2,1)*80@3834L7,90@4209L68:ViewModel.kt#3tja67");
                            if (componentActivity instanceof HasDefaultViewModelProviderFactory) {
                                defaultViewModelCreationExtras = componentActivity.getDefaultViewModelCreationExtras();
                            } else {
                                defaultViewModelCreationExtras = CreationExtras.Empty.INSTANCE;
                            }
                            CreationExtras creationExtras2 = defaultViewModelCreationExtras;
                            continuation = null;
                            ViewModel viewModel2 = ViewModelKt.viewModel((Class<ViewModel>) OfflinedViewModel.class, componentActivity, (String) null, factoryCreateHiltViewModelFactory2, creationExtras2, composerStartRestartGroup, 36936, 0);
                            composerStartRestartGroup.endReplaceableGroup();
                            composerStartRestartGroup.endReplaceableGroup();
                            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                            modifier4 = modifier2;
                            i8 = i3 & (-3670017);
                            offlinedViewModel4 = (OfflinedViewModel) viewModel2;
                        } else {
                            modifier4 = modifier2;
                            i8 = i3;
                            offlinedViewModel4 = offlinedViewModel2;
                        }
                    } else {
                        if (i9 != 0) {
                            modifier2 = Modifier.INSTANCE;
                        }
                        if (i4 != 0) {
                            homeScreenViewsVisibilityState3 = null;
                        } else {
                            homeScreenViewsVisibilityState3 = homeScreenViewsVisibilityState2;
                        }
                        if (i6 != 0) {
                            z5 = false;
                        } else {
                            z5 = z2;
                        }
                        if ((i2 & 64) != 0) {
                            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1447482489, "CC(hiltActivityViewModel)N(key)159@5773L7,160@5813L56:ComposeUtils.kt#vejmn0");
                            ProvidableCompositionLocal<Activity> localActivity3 = LocalActivityKt.getLocalActivity();
                            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
                            Object objConsume3 = composerStartRestartGroup.consume(localActivity3);
                            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                            Intrinsics.checkNotNull(objConsume3, "null cannot be cast to non-null type androidx.activity.ComponentActivity");
                            componentActivity = (ComponentActivity) objConsume3;
                            composerStartRestartGroup.startReplaceableGroup(1890788296);
                            ComposerKt.sourceInformation(composerStartRestartGroup, "CC(hiltViewModel)P(1)*45@1969L7,50@2112L47,51@2171L54:HiltViewModel.kt#9mcars");
                            ViewModelProvider.Factory factoryCreateHiltViewModelFactory3 = HiltViewModelKt.createHiltViewModelFactory(componentActivity, composerStartRestartGroup, 0);
                            composerStartRestartGroup.startReplaceableGroup(1729797275);
                            ComposerKt.sourceInformation(composerStartRestartGroup, "CC(viewModel)P(3,2,1)*80@3834L7,90@4209L68:ViewModel.kt#3tja67");
                            if (componentActivity instanceof HasDefaultViewModelProviderFactory) {
                                defaultViewModelCreationExtras = componentActivity.getDefaultViewModelCreationExtras();
                            } else {
                                defaultViewModelCreationExtras = CreationExtras.Empty.INSTANCE;
                            }
                            CreationExtras creationExtras3 = defaultViewModelCreationExtras;
                            continuation = null;
                            ViewModel viewModel3 = ViewModelKt.viewModel((Class<ViewModel>) OfflinedViewModel.class, componentActivity, (String) null, factoryCreateHiltViewModelFactory3, creationExtras3, composerStartRestartGroup, 36936, 0);
                            composerStartRestartGroup.endReplaceableGroup();
                            composerStartRestartGroup.endReplaceableGroup();
                            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                            modifier4 = modifier2;
                            i8 = i3 & (-3670017);
                            offlinedViewModel4 = (OfflinedViewModel) viewModel3;
                        } else {
                            modifier4 = modifier2;
                            i8 = i3;
                            offlinedViewModel4 = offlinedViewModel2;
                        }
                    }
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-523938171, i8, -1, "com.box.android.browse.cpl.offlined.OfflinedScreen (OfflinedScreen.kt:40)");
                    }
                    store = offlinedViewModel4.getStore();
                    State stateCollectAsStateWithLifecycle3 = FlowExtKt.collectAsStateWithLifecycle(store.getState(), (LifecycleOwner) null, (Lifecycle.State) null, (CoroutineContext) null, composerStartRestartGroup, 0, 7);
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -993392011, "CC(remember):OfflinedScreen.kt#9igjgp");
                    offlinedScreenKt$OfflinedScreen$1$1RememberedValue = composerStartRestartGroup.rememberedValue();
                    if (offlinedScreenKt$OfflinedScreen$1$1RememberedValue == Composer.INSTANCE.getEmpty()) {
                        offlinedScreenKt$OfflinedScreen$1$1RememberedValue = new OfflinedScreenKt$OfflinedScreen$1$1(snackbarHostState, continuation);
                        composerStartRestartGroup.updateRememberedValue(offlinedScreenKt$OfflinedScreen$1$1RememberedValue);
                    }
                    Function4 function6 = (Function4) offlinedScreenKt$OfflinedScreen$1$1RememberedValue;
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -993383082, "CC(remember):OfflinedScreen.kt#9igjgp");
                    zChanged = composerStartRestartGroup.changed(store);
                    objRememberedValue = composerStartRestartGroup.rememberedValue();
                    if (!zChanged) {
                        objRememberedValue = new Function1() { // from class: com.box.android.browse.cpl.offlined.OfflinedScreenKt$$ExternalSyntheticLambda4
                            @Override // kotlin.jvm.functions.Function1
                            public final Object invoke(Object obj) {
                                return OfflinedScreenKt.OfflinedScreen$lambda$2$0(store, ((Boolean) obj).booleanValue());
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                    } else {
                        objRememberedValue = new Function1() { // from class: com.box.android.browse.cpl.offlined.OfflinedScreenKt$$ExternalSyntheticLambda4
                            @Override // kotlin.jvm.functions.Function1
                            public final Object invoke(Object obj) {
                                return OfflinedScreenKt.OfflinedScreen$lambda$2$0(store, ((Boolean) obj).booleanValue());
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                    }
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    Modifier modifierOnVisibilityChanged$default3 = OnVisibilityChangedModifierKt.onVisibilityChanged$default(modifier4, 0L, 1.0f, null, (Function1) objRememberedValue, 5, null);
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -993376502, "CC(remember):OfflinedScreen.kt#9igjgp");
                    zChanged2 = composerStartRestartGroup.changed(store);
                    objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                    if (!zChanged2) {
                        objRememberedValue2 = new Function1() { // from class: com.box.android.browse.cpl.offlined.OfflinedScreenKt$$ExternalSyntheticLambda5
                            @Override // kotlin.jvm.functions.Function1
                            public final Object invoke(Object obj) {
                                return OfflinedScreenKt.OfflinedScreen$lambda$3$0(store, ((Boolean) obj).booleanValue());
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                    } else {
                        objRememberedValue2 = new Function1() { // from class: com.box.android.browse.cpl.offlined.OfflinedScreenKt$$ExternalSyntheticLambda5
                            @Override // kotlin.jvm.functions.Function1
                            public final Object invoke(Object obj) {
                                return OfflinedScreenKt.OfflinedScreen$lambda$3$0(store, ((Boolean) obj).booleanValue());
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                    }
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    int i13 = i8 >> 3;
                    OfflinedContentKt.OfflinedContent(store, OnVisibilityChangedModifierKt.onVisibilityChanged$default(modifierOnVisibilityChanged$default3, 0L, 0.0f, null, (Function1) objRememberedValue2, 5, null), function6, true, z5, composerStartRestartGroup, (i13 & 57344) | 3072, 0);
                    NavigationRouteEffect(OfflinedScreen$lambda$0(stateCollectAsStateWithLifecycle3).getNavigationRoute(), navigator, store, composerStartRestartGroup, (i8 << 3) & 112);
                    SelectionModeViewsVisibilityEffect(OfflinedScreen$lambda$0(stateCollectAsStateWithLifecycle3).getActionableItemsListState().getIsSelecting(), homeScreenViewsVisibilityState3, composerStartRestartGroup, (i8 >> 9) & 112);
                    UpdateItemsSnackbarEffect(OfflinedScreen$lambda$0(stateCollectAsStateWithLifecycle3), store, snackbarHostState, composerStartRestartGroup, i8 & 896);
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -993355224, "CC(remember):OfflinedScreen.kt#9igjgp");
                    zChanged3 = composerStartRestartGroup.changed(store);
                    objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                    if (!zChanged3) {
                        objRememberedValue3 = new Function1() { // from class: com.box.android.browse.cpl.offlined.OfflinedScreenKt$$ExternalSyntheticLambda6
                            @Override // kotlin.jvm.functions.Function1
                            public final Object invoke(Object obj) {
                                return OfflinedScreenKt.OfflinedScreen$lambda$4$0(store, (BoxMessage) obj);
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                    } else {
                        objRememberedValue3 = new Function1() { // from class: com.box.android.browse.cpl.offlined.OfflinedScreenKt$$ExternalSyntheticLambda6
                            @Override // kotlin.jvm.functions.Function1
                            public final Object invoke(Object obj) {
                                return OfflinedScreenKt.OfflinedScreen$lambda$4$0(store, (BoxMessage) obj);
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                    }
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    BoxMessageListenerEffectKt.BoxMessageListenerEffect(boxMessageDispatcher, (Function1) objRememberedValue3, composerStartRestartGroup, BoxMessageDispatcher.$stable | (i13 & 14));
                    Lifecycle.Event event3 = Lifecycle.Event.ON_RESUME;
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -993349174, "CC(remember):OfflinedScreen.kt#9igjgp");
                    zChanged4 = composerStartRestartGroup.changed(store);
                    objRememberedValue4 = composerStartRestartGroup.rememberedValue();
                    if (!zChanged4) {
                        objRememberedValue4 = new Function0() { // from class: com.box.android.browse.cpl.offlined.OfflinedScreenKt$$ExternalSyntheticLambda7
                            @Override // kotlin.jvm.functions.Function0
                            public final Object invoke() {
                                return OfflinedScreenKt.OfflinedScreen$lambda$5$0(store);
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue4);
                    } else {
                        objRememberedValue4 = new Function0() { // from class: com.box.android.browse.cpl.offlined.OfflinedScreenKt$$ExternalSyntheticLambda7
                            @Override // kotlin.jvm.functions.Function0
                            public final Object invoke() {
                                return OfflinedScreenKt.OfflinedScreen$lambda$5$0(store);
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue4);
                    }
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    LifecycleEffectKt.LifecycleEventEffect(event3, null, (Function0) objRememberedValue4, composerStartRestartGroup, 6, 2);
                    composerStartRestartGroup = composerStartRestartGroup;
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    z4 = z5;
                    offlinedViewModel3 = offlinedViewModel4;
                    modifier3 = modifier4;
                } else {
                    composerStartRestartGroup.skipToGroupEnd();
                    modifier3 = modifier2;
                    homeScreenViewsVisibilityState3 = homeScreenViewsVisibilityState2;
                    z4 = z2;
                    offlinedViewModel3 = offlinedViewModel2;
                }
                scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.box.android.browse.cpl.offlined.OfflinedScreenKt$$ExternalSyntheticLambda8
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return OfflinedScreenKt.OfflinedScreen$lambda$6(navigator, boxMessageDispatcher, snackbarHostState, modifier3, homeScreenViewsVisibilityState3, z4, offlinedViewModel3, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    });
                }
            }
            i3 |= 24576;
            homeScreenViewsVisibilityState2 = homeScreenViewsVisibilityState;
            i6 = i2 & 32;
            if (i6 != 0) {
                if ((196608 & i) == 0) {
                    z2 = z;
                    if (composerStartRestartGroup.changed(z2)) {
                        i7 = 131072;
                    } else {
                        i7 = 65536;
                    }
                    i3 |= i7;
                }
                if ((1572864 & i) == 0) {
                    if ((i2 & 64) == 0) {
                        offlinedViewModel2 = offlinedViewModel;
                        if (composerStartRestartGroup.changedInstance(offlinedViewModel2)) {
                        }
                        i3 |= i10;
                    } else {
                        offlinedViewModel2 = offlinedViewModel;
                    }
                    i3 |= i10;
                } else {
                    offlinedViewModel2 = offlinedViewModel;
                }
                if ((599187 & i3) != 599186) {
                    z3 = true;
                } else {
                    z3 = false;
                }
                if (composerStartRestartGroup.shouldExecute(z3, i3 & 1)) {
                    composerStartRestartGroup.startDefaults();
                    ComposerKt.sourceInformation(composerStartRestartGroup, "39@1956L23");
                    continuation = null;
                    if ((i & 1) != 0) {
                        if (i9 != 0) {
                            modifier2 = Modifier.INSTANCE;
                        }
                        if (i4 != 0) {
                            homeScreenViewsVisibilityState3 = null;
                        } else {
                            homeScreenViewsVisibilityState3 = homeScreenViewsVisibilityState2;
                        }
                        if (i6 != 0) {
                            z5 = false;
                        } else {
                            z5 = z2;
                        }
                        if ((i2 & 64) != 0) {
                            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1447482489, "CC(hiltActivityViewModel)N(key)159@5773L7,160@5813L56:ComposeUtils.kt#vejmn0");
                            ProvidableCompositionLocal<Activity> localActivity4 = LocalActivityKt.getLocalActivity();
                            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
                            Object objConsume4 = composerStartRestartGroup.consume(localActivity4);
                            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                            Intrinsics.checkNotNull(objConsume4, "null cannot be cast to non-null type androidx.activity.ComponentActivity");
                            componentActivity = (ComponentActivity) objConsume4;
                            composerStartRestartGroup.startReplaceableGroup(1890788296);
                            ComposerKt.sourceInformation(composerStartRestartGroup, "CC(hiltViewModel)P(1)*45@1969L7,50@2112L47,51@2171L54:HiltViewModel.kt#9mcars");
                            ViewModelProvider.Factory factoryCreateHiltViewModelFactory4 = HiltViewModelKt.createHiltViewModelFactory(componentActivity, composerStartRestartGroup, 0);
                            composerStartRestartGroup.startReplaceableGroup(1729797275);
                            ComposerKt.sourceInformation(composerStartRestartGroup, "CC(viewModel)P(3,2,1)*80@3834L7,90@4209L68:ViewModel.kt#3tja67");
                            if (componentActivity instanceof HasDefaultViewModelProviderFactory) {
                                defaultViewModelCreationExtras = componentActivity.getDefaultViewModelCreationExtras();
                            } else {
                                defaultViewModelCreationExtras = CreationExtras.Empty.INSTANCE;
                            }
                            CreationExtras creationExtras4 = defaultViewModelCreationExtras;
                            continuation = null;
                            ViewModel viewModel4 = ViewModelKt.viewModel((Class<ViewModel>) OfflinedViewModel.class, componentActivity, (String) null, factoryCreateHiltViewModelFactory4, creationExtras4, composerStartRestartGroup, 36936, 0);
                            composerStartRestartGroup.endReplaceableGroup();
                            composerStartRestartGroup.endReplaceableGroup();
                            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                            modifier4 = modifier2;
                            i8 = i3 & (-3670017);
                            offlinedViewModel4 = (OfflinedViewModel) viewModel4;
                        } else {
                            modifier4 = modifier2;
                            i8 = i3;
                            offlinedViewModel4 = offlinedViewModel2;
                        }
                    } else {
                        if (i9 != 0) {
                            modifier2 = Modifier.INSTANCE;
                        }
                        if (i4 != 0) {
                            homeScreenViewsVisibilityState3 = null;
                        } else {
                            homeScreenViewsVisibilityState3 = homeScreenViewsVisibilityState2;
                        }
                        if (i6 != 0) {
                            z5 = false;
                        } else {
                            z5 = z2;
                        }
                        if ((i2 & 64) != 0) {
                            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1447482489, "CC(hiltActivityViewModel)N(key)159@5773L7,160@5813L56:ComposeUtils.kt#vejmn0");
                            ProvidableCompositionLocal<Activity> localActivity5 = LocalActivityKt.getLocalActivity();
                            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
                            Object objConsume5 = composerStartRestartGroup.consume(localActivity5);
                            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                            Intrinsics.checkNotNull(objConsume5, "null cannot be cast to non-null type androidx.activity.ComponentActivity");
                            componentActivity = (ComponentActivity) objConsume5;
                            composerStartRestartGroup.startReplaceableGroup(1890788296);
                            ComposerKt.sourceInformation(composerStartRestartGroup, "CC(hiltViewModel)P(1)*45@1969L7,50@2112L47,51@2171L54:HiltViewModel.kt#9mcars");
                            ViewModelProvider.Factory factoryCreateHiltViewModelFactory5 = HiltViewModelKt.createHiltViewModelFactory(componentActivity, composerStartRestartGroup, 0);
                            composerStartRestartGroup.startReplaceableGroup(1729797275);
                            ComposerKt.sourceInformation(composerStartRestartGroup, "CC(viewModel)P(3,2,1)*80@3834L7,90@4209L68:ViewModel.kt#3tja67");
                            if (componentActivity instanceof HasDefaultViewModelProviderFactory) {
                                defaultViewModelCreationExtras = componentActivity.getDefaultViewModelCreationExtras();
                            } else {
                                defaultViewModelCreationExtras = CreationExtras.Empty.INSTANCE;
                            }
                            CreationExtras creationExtras5 = defaultViewModelCreationExtras;
                            continuation = null;
                            ViewModel viewModel5 = ViewModelKt.viewModel((Class<ViewModel>) OfflinedViewModel.class, componentActivity, (String) null, factoryCreateHiltViewModelFactory5, creationExtras5, composerStartRestartGroup, 36936, 0);
                            composerStartRestartGroup.endReplaceableGroup();
                            composerStartRestartGroup.endReplaceableGroup();
                            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                            modifier4 = modifier2;
                            i8 = i3 & (-3670017);
                            offlinedViewModel4 = (OfflinedViewModel) viewModel5;
                        } else {
                            modifier4 = modifier2;
                            i8 = i3;
                            offlinedViewModel4 = offlinedViewModel2;
                        }
                    }
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-523938171, i8, -1, "com.box.android.browse.cpl.offlined.OfflinedScreen (OfflinedScreen.kt:40)");
                    }
                    store = offlinedViewModel4.getStore();
                    State stateCollectAsStateWithLifecycle4 = FlowExtKt.collectAsStateWithLifecycle(store.getState(), (LifecycleOwner) null, (Lifecycle.State) null, (CoroutineContext) null, composerStartRestartGroup, 0, 7);
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -993392011, "CC(remember):OfflinedScreen.kt#9igjgp");
                    offlinedScreenKt$OfflinedScreen$1$1RememberedValue = composerStartRestartGroup.rememberedValue();
                    if (offlinedScreenKt$OfflinedScreen$1$1RememberedValue == Composer.INSTANCE.getEmpty()) {
                        offlinedScreenKt$OfflinedScreen$1$1RememberedValue = new OfflinedScreenKt$OfflinedScreen$1$1(snackbarHostState, continuation);
                        composerStartRestartGroup.updateRememberedValue(offlinedScreenKt$OfflinedScreen$1$1RememberedValue);
                    }
                    Function4 function7 = (Function4) offlinedScreenKt$OfflinedScreen$1$1RememberedValue;
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -993383082, "CC(remember):OfflinedScreen.kt#9igjgp");
                    zChanged = composerStartRestartGroup.changed(store);
                    objRememberedValue = composerStartRestartGroup.rememberedValue();
                    if (!zChanged) {
                        objRememberedValue = new Function1() { // from class: com.box.android.browse.cpl.offlined.OfflinedScreenKt$$ExternalSyntheticLambda4
                            @Override // kotlin.jvm.functions.Function1
                            public final Object invoke(Object obj) {
                                return OfflinedScreenKt.OfflinedScreen$lambda$2$0(store, ((Boolean) obj).booleanValue());
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                    } else {
                        objRememberedValue = new Function1() { // from class: com.box.android.browse.cpl.offlined.OfflinedScreenKt$$ExternalSyntheticLambda4
                            @Override // kotlin.jvm.functions.Function1
                            public final Object invoke(Object obj) {
                                return OfflinedScreenKt.OfflinedScreen$lambda$2$0(store, ((Boolean) obj).booleanValue());
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                    }
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    Modifier modifierOnVisibilityChanged$default4 = OnVisibilityChangedModifierKt.onVisibilityChanged$default(modifier4, 0L, 1.0f, null, (Function1) objRememberedValue, 5, null);
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -993376502, "CC(remember):OfflinedScreen.kt#9igjgp");
                    zChanged2 = composerStartRestartGroup.changed(store);
                    objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                    if (!zChanged2) {
                        objRememberedValue2 = new Function1() { // from class: com.box.android.browse.cpl.offlined.OfflinedScreenKt$$ExternalSyntheticLambda5
                            @Override // kotlin.jvm.functions.Function1
                            public final Object invoke(Object obj) {
                                return OfflinedScreenKt.OfflinedScreen$lambda$3$0(store, ((Boolean) obj).booleanValue());
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                    } else {
                        objRememberedValue2 = new Function1() { // from class: com.box.android.browse.cpl.offlined.OfflinedScreenKt$$ExternalSyntheticLambda5
                            @Override // kotlin.jvm.functions.Function1
                            public final Object invoke(Object obj) {
                                return OfflinedScreenKt.OfflinedScreen$lambda$3$0(store, ((Boolean) obj).booleanValue());
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                    }
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    int i14 = i8 >> 3;
                    OfflinedContentKt.OfflinedContent(store, OnVisibilityChangedModifierKt.onVisibilityChanged$default(modifierOnVisibilityChanged$default4, 0L, 0.0f, null, (Function1) objRememberedValue2, 5, null), function7, true, z5, composerStartRestartGroup, (i14 & 57344) | 3072, 0);
                    NavigationRouteEffect(OfflinedScreen$lambda$0(stateCollectAsStateWithLifecycle4).getNavigationRoute(), navigator, store, composerStartRestartGroup, (i8 << 3) & 112);
                    SelectionModeViewsVisibilityEffect(OfflinedScreen$lambda$0(stateCollectAsStateWithLifecycle4).getActionableItemsListState().getIsSelecting(), homeScreenViewsVisibilityState3, composerStartRestartGroup, (i8 >> 9) & 112);
                    UpdateItemsSnackbarEffect(OfflinedScreen$lambda$0(stateCollectAsStateWithLifecycle4), store, snackbarHostState, composerStartRestartGroup, i8 & 896);
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -993355224, "CC(remember):OfflinedScreen.kt#9igjgp");
                    zChanged3 = composerStartRestartGroup.changed(store);
                    objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                    if (!zChanged3) {
                        objRememberedValue3 = new Function1() { // from class: com.box.android.browse.cpl.offlined.OfflinedScreenKt$$ExternalSyntheticLambda6
                            @Override // kotlin.jvm.functions.Function1
                            public final Object invoke(Object obj) {
                                return OfflinedScreenKt.OfflinedScreen$lambda$4$0(store, (BoxMessage) obj);
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                    } else {
                        objRememberedValue3 = new Function1() { // from class: com.box.android.browse.cpl.offlined.OfflinedScreenKt$$ExternalSyntheticLambda6
                            @Override // kotlin.jvm.functions.Function1
                            public final Object invoke(Object obj) {
                                return OfflinedScreenKt.OfflinedScreen$lambda$4$0(store, (BoxMessage) obj);
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                    }
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    BoxMessageListenerEffectKt.BoxMessageListenerEffect(boxMessageDispatcher, (Function1) objRememberedValue3, composerStartRestartGroup, BoxMessageDispatcher.$stable | (i14 & 14));
                    Lifecycle.Event event4 = Lifecycle.Event.ON_RESUME;
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -993349174, "CC(remember):OfflinedScreen.kt#9igjgp");
                    zChanged4 = composerStartRestartGroup.changed(store);
                    objRememberedValue4 = composerStartRestartGroup.rememberedValue();
                    if (!zChanged4) {
                        objRememberedValue4 = new Function0() { // from class: com.box.android.browse.cpl.offlined.OfflinedScreenKt$$ExternalSyntheticLambda7
                            @Override // kotlin.jvm.functions.Function0
                            public final Object invoke() {
                                return OfflinedScreenKt.OfflinedScreen$lambda$5$0(store);
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue4);
                    } else {
                        objRememberedValue4 = new Function0() { // from class: com.box.android.browse.cpl.offlined.OfflinedScreenKt$$ExternalSyntheticLambda7
                            @Override // kotlin.jvm.functions.Function0
                            public final Object invoke() {
                                return OfflinedScreenKt.OfflinedScreen$lambda$5$0(store);
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue4);
                    }
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    LifecycleEffectKt.LifecycleEventEffect(event4, null, (Function0) objRememberedValue4, composerStartRestartGroup, 6, 2);
                    composerStartRestartGroup = composerStartRestartGroup;
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    z4 = z5;
                    offlinedViewModel3 = offlinedViewModel4;
                    modifier3 = modifier4;
                } else {
                    composerStartRestartGroup.skipToGroupEnd();
                    modifier3 = modifier2;
                    homeScreenViewsVisibilityState3 = homeScreenViewsVisibilityState2;
                    z4 = z2;
                    offlinedViewModel3 = offlinedViewModel2;
                }
                scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.box.android.browse.cpl.offlined.OfflinedScreenKt$$ExternalSyntheticLambda8
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return OfflinedScreenKt.OfflinedScreen$lambda$6(navigator, boxMessageDispatcher, snackbarHostState, modifier3, homeScreenViewsVisibilityState3, z4, offlinedViewModel3, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    });
                }
            }
            i3 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
            z2 = z;
            if ((1572864 & i) == 0) {
                if ((i2 & 64) == 0) {
                    offlinedViewModel2 = offlinedViewModel;
                    if (composerStartRestartGroup.changedInstance(offlinedViewModel2)) {
                    }
                    i3 |= i10;
                } else {
                    offlinedViewModel2 = offlinedViewModel;
                }
                i3 |= i10;
            } else {
                offlinedViewModel2 = offlinedViewModel;
            }
            if ((599187 & i3) != 599186) {
                z3 = true;
            } else {
                z3 = false;
            }
            if (composerStartRestartGroup.shouldExecute(z3, i3 & 1)) {
                composerStartRestartGroup.startDefaults();
                ComposerKt.sourceInformation(composerStartRestartGroup, "39@1956L23");
                continuation = null;
                if ((i & 1) != 0) {
                    if (i9 != 0) {
                        modifier2 = Modifier.INSTANCE;
                    }
                    if (i4 != 0) {
                        homeScreenViewsVisibilityState3 = null;
                    } else {
                        homeScreenViewsVisibilityState3 = homeScreenViewsVisibilityState2;
                    }
                    if (i6 != 0) {
                        z5 = false;
                    } else {
                        z5 = z2;
                    }
                    if ((i2 & 64) != 0) {
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1447482489, "CC(hiltActivityViewModel)N(key)159@5773L7,160@5813L56:ComposeUtils.kt#vejmn0");
                        ProvidableCompositionLocal<Activity> localActivity6 = LocalActivityKt.getLocalActivity();
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
                        Object objConsume6 = composerStartRestartGroup.consume(localActivity6);
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        Intrinsics.checkNotNull(objConsume6, "null cannot be cast to non-null type androidx.activity.ComponentActivity");
                        componentActivity = (ComponentActivity) objConsume6;
                        composerStartRestartGroup.startReplaceableGroup(1890788296);
                        ComposerKt.sourceInformation(composerStartRestartGroup, "CC(hiltViewModel)P(1)*45@1969L7,50@2112L47,51@2171L54:HiltViewModel.kt#9mcars");
                        ViewModelProvider.Factory factoryCreateHiltViewModelFactory6 = HiltViewModelKt.createHiltViewModelFactory(componentActivity, composerStartRestartGroup, 0);
                        composerStartRestartGroup.startReplaceableGroup(1729797275);
                        ComposerKt.sourceInformation(composerStartRestartGroup, "CC(viewModel)P(3,2,1)*80@3834L7,90@4209L68:ViewModel.kt#3tja67");
                        if (componentActivity instanceof HasDefaultViewModelProviderFactory) {
                            defaultViewModelCreationExtras = componentActivity.getDefaultViewModelCreationExtras();
                        } else {
                            defaultViewModelCreationExtras = CreationExtras.Empty.INSTANCE;
                        }
                        CreationExtras creationExtras6 = defaultViewModelCreationExtras;
                        continuation = null;
                        ViewModel viewModel6 = ViewModelKt.viewModel((Class<ViewModel>) OfflinedViewModel.class, componentActivity, (String) null, factoryCreateHiltViewModelFactory6, creationExtras6, composerStartRestartGroup, 36936, 0);
                        composerStartRestartGroup.endReplaceableGroup();
                        composerStartRestartGroup.endReplaceableGroup();
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        modifier4 = modifier2;
                        i8 = i3 & (-3670017);
                        offlinedViewModel4 = (OfflinedViewModel) viewModel6;
                    } else {
                        modifier4 = modifier2;
                        i8 = i3;
                        offlinedViewModel4 = offlinedViewModel2;
                    }
                } else {
                    if (i9 != 0) {
                        modifier2 = Modifier.INSTANCE;
                    }
                    if (i4 != 0) {
                        homeScreenViewsVisibilityState3 = null;
                    } else {
                        homeScreenViewsVisibilityState3 = homeScreenViewsVisibilityState2;
                    }
                    if (i6 != 0) {
                        z5 = false;
                    } else {
                        z5 = z2;
                    }
                    if ((i2 & 64) != 0) {
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1447482489, "CC(hiltActivityViewModel)N(key)159@5773L7,160@5813L56:ComposeUtils.kt#vejmn0");
                        ProvidableCompositionLocal<Activity> localActivity7 = LocalActivityKt.getLocalActivity();
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
                        Object objConsume7 = composerStartRestartGroup.consume(localActivity7);
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        Intrinsics.checkNotNull(objConsume7, "null cannot be cast to non-null type androidx.activity.ComponentActivity");
                        componentActivity = (ComponentActivity) objConsume7;
                        composerStartRestartGroup.startReplaceableGroup(1890788296);
                        ComposerKt.sourceInformation(composerStartRestartGroup, "CC(hiltViewModel)P(1)*45@1969L7,50@2112L47,51@2171L54:HiltViewModel.kt#9mcars");
                        ViewModelProvider.Factory factoryCreateHiltViewModelFactory7 = HiltViewModelKt.createHiltViewModelFactory(componentActivity, composerStartRestartGroup, 0);
                        composerStartRestartGroup.startReplaceableGroup(1729797275);
                        ComposerKt.sourceInformation(composerStartRestartGroup, "CC(viewModel)P(3,2,1)*80@3834L7,90@4209L68:ViewModel.kt#3tja67");
                        if (componentActivity instanceof HasDefaultViewModelProviderFactory) {
                            defaultViewModelCreationExtras = componentActivity.getDefaultViewModelCreationExtras();
                        } else {
                            defaultViewModelCreationExtras = CreationExtras.Empty.INSTANCE;
                        }
                        CreationExtras creationExtras7 = defaultViewModelCreationExtras;
                        continuation = null;
                        ViewModel viewModel7 = ViewModelKt.viewModel((Class<ViewModel>) OfflinedViewModel.class, componentActivity, (String) null, factoryCreateHiltViewModelFactory7, creationExtras7, composerStartRestartGroup, 36936, 0);
                        composerStartRestartGroup.endReplaceableGroup();
                        composerStartRestartGroup.endReplaceableGroup();
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        modifier4 = modifier2;
                        i8 = i3 & (-3670017);
                        offlinedViewModel4 = (OfflinedViewModel) viewModel7;
                    } else {
                        modifier4 = modifier2;
                        i8 = i3;
                        offlinedViewModel4 = offlinedViewModel2;
                    }
                }
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-523938171, i8, -1, "com.box.android.browse.cpl.offlined.OfflinedScreen (OfflinedScreen.kt:40)");
                }
                store = offlinedViewModel4.getStore();
                State stateCollectAsStateWithLifecycle5 = FlowExtKt.collectAsStateWithLifecycle(store.getState(), (LifecycleOwner) null, (Lifecycle.State) null, (CoroutineContext) null, composerStartRestartGroup, 0, 7);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -993392011, "CC(remember):OfflinedScreen.kt#9igjgp");
                offlinedScreenKt$OfflinedScreen$1$1RememberedValue = composerStartRestartGroup.rememberedValue();
                if (offlinedScreenKt$OfflinedScreen$1$1RememberedValue == Composer.INSTANCE.getEmpty()) {
                    offlinedScreenKt$OfflinedScreen$1$1RememberedValue = new OfflinedScreenKt$OfflinedScreen$1$1(snackbarHostState, continuation);
                    composerStartRestartGroup.updateRememberedValue(offlinedScreenKt$OfflinedScreen$1$1RememberedValue);
                }
                Function4 function8 = (Function4) offlinedScreenKt$OfflinedScreen$1$1RememberedValue;
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -993383082, "CC(remember):OfflinedScreen.kt#9igjgp");
                zChanged = composerStartRestartGroup.changed(store);
                objRememberedValue = composerStartRestartGroup.rememberedValue();
                if (!zChanged) {
                    objRememberedValue = new Function1() { // from class: com.box.android.browse.cpl.offlined.OfflinedScreenKt$$ExternalSyntheticLambda4
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            return OfflinedScreenKt.OfflinedScreen$lambda$2$0(store, ((Boolean) obj).booleanValue());
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                } else {
                    objRememberedValue = new Function1() { // from class: com.box.android.browse.cpl.offlined.OfflinedScreenKt$$ExternalSyntheticLambda4
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            return OfflinedScreenKt.OfflinedScreen$lambda$2$0(store, ((Boolean) obj).booleanValue());
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                }
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                Modifier modifierOnVisibilityChanged$default5 = OnVisibilityChangedModifierKt.onVisibilityChanged$default(modifier4, 0L, 1.0f, null, (Function1) objRememberedValue, 5, null);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -993376502, "CC(remember):OfflinedScreen.kt#9igjgp");
                zChanged2 = composerStartRestartGroup.changed(store);
                objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                if (!zChanged2) {
                    objRememberedValue2 = new Function1() { // from class: com.box.android.browse.cpl.offlined.OfflinedScreenKt$$ExternalSyntheticLambda5
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            return OfflinedScreenKt.OfflinedScreen$lambda$3$0(store, ((Boolean) obj).booleanValue());
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                } else {
                    objRememberedValue2 = new Function1() { // from class: com.box.android.browse.cpl.offlined.OfflinedScreenKt$$ExternalSyntheticLambda5
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            return OfflinedScreenKt.OfflinedScreen$lambda$3$0(store, ((Boolean) obj).booleanValue());
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                }
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                int i15 = i8 >> 3;
                OfflinedContentKt.OfflinedContent(store, OnVisibilityChangedModifierKt.onVisibilityChanged$default(modifierOnVisibilityChanged$default5, 0L, 0.0f, null, (Function1) objRememberedValue2, 5, null), function8, true, z5, composerStartRestartGroup, (i15 & 57344) | 3072, 0);
                NavigationRouteEffect(OfflinedScreen$lambda$0(stateCollectAsStateWithLifecycle5).getNavigationRoute(), navigator, store, composerStartRestartGroup, (i8 << 3) & 112);
                SelectionModeViewsVisibilityEffect(OfflinedScreen$lambda$0(stateCollectAsStateWithLifecycle5).getActionableItemsListState().getIsSelecting(), homeScreenViewsVisibilityState3, composerStartRestartGroup, (i8 >> 9) & 112);
                UpdateItemsSnackbarEffect(OfflinedScreen$lambda$0(stateCollectAsStateWithLifecycle5), store, snackbarHostState, composerStartRestartGroup, i8 & 896);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -993355224, "CC(remember):OfflinedScreen.kt#9igjgp");
                zChanged3 = composerStartRestartGroup.changed(store);
                objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                if (!zChanged3) {
                    objRememberedValue3 = new Function1() { // from class: com.box.android.browse.cpl.offlined.OfflinedScreenKt$$ExternalSyntheticLambda6
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            return OfflinedScreenKt.OfflinedScreen$lambda$4$0(store, (BoxMessage) obj);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                } else {
                    objRememberedValue3 = new Function1() { // from class: com.box.android.browse.cpl.offlined.OfflinedScreenKt$$ExternalSyntheticLambda6
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            return OfflinedScreenKt.OfflinedScreen$lambda$4$0(store, (BoxMessage) obj);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                }
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                BoxMessageListenerEffectKt.BoxMessageListenerEffect(boxMessageDispatcher, (Function1) objRememberedValue3, composerStartRestartGroup, BoxMessageDispatcher.$stable | (i15 & 14));
                Lifecycle.Event event5 = Lifecycle.Event.ON_RESUME;
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -993349174, "CC(remember):OfflinedScreen.kt#9igjgp");
                zChanged4 = composerStartRestartGroup.changed(store);
                objRememberedValue4 = composerStartRestartGroup.rememberedValue();
                if (!zChanged4) {
                    objRememberedValue4 = new Function0() { // from class: com.box.android.browse.cpl.offlined.OfflinedScreenKt$$ExternalSyntheticLambda7
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            return OfflinedScreenKt.OfflinedScreen$lambda$5$0(store);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue4);
                } else {
                    objRememberedValue4 = new Function0() { // from class: com.box.android.browse.cpl.offlined.OfflinedScreenKt$$ExternalSyntheticLambda7
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            return OfflinedScreenKt.OfflinedScreen$lambda$5$0(store);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue4);
                }
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                LifecycleEffectKt.LifecycleEventEffect(event5, null, (Function0) objRememberedValue4, composerStartRestartGroup, 6, 2);
                composerStartRestartGroup = composerStartRestartGroup;
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                z4 = z5;
                offlinedViewModel3 = offlinedViewModel4;
                modifier3 = modifier4;
            } else {
                composerStartRestartGroup.skipToGroupEnd();
                modifier3 = modifier2;
                homeScreenViewsVisibilityState3 = homeScreenViewsVisibilityState2;
                z4 = z2;
                offlinedViewModel3 = offlinedViewModel2;
            }
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.box.android.browse.cpl.offlined.OfflinedScreenKt$$ExternalSyntheticLambda8
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return OfflinedScreenKt.OfflinedScreen$lambda$6(navigator, boxMessageDispatcher, snackbarHostState, modifier3, homeScreenViewsVisibilityState3, z4, offlinedViewModel3, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                    }
                });
            }
        }
        i3 |= 3072;
        modifier2 = modifier;
        i4 = i2 & 16;
        if (i4 != 0) {
            if ((i & 24576) == 0) {
                homeScreenViewsVisibilityState2 = homeScreenViewsVisibilityState;
                if (composerStartRestartGroup.changed(homeScreenViewsVisibilityState2)) {
                    i5 = 16384;
                } else {
                    i5 = 8192;
                }
                i3 |= i5;
            }
            i6 = i2 & 32;
            if (i6 != 0) {
                if ((196608 & i) == 0) {
                    z2 = z;
                    if (composerStartRestartGroup.changed(z2)) {
                        i7 = 131072;
                    } else {
                        i7 = 65536;
                    }
                    i3 |= i7;
                }
                if ((1572864 & i) == 0) {
                    if ((i2 & 64) == 0) {
                        offlinedViewModel2 = offlinedViewModel;
                        if (composerStartRestartGroup.changedInstance(offlinedViewModel2)) {
                        }
                        i3 |= i10;
                    } else {
                        offlinedViewModel2 = offlinedViewModel;
                    }
                    i3 |= i10;
                } else {
                    offlinedViewModel2 = offlinedViewModel;
                }
                if ((599187 & i3) != 599186) {
                    z3 = true;
                } else {
                    z3 = false;
                }
                if (composerStartRestartGroup.shouldExecute(z3, i3 & 1)) {
                    composerStartRestartGroup.startDefaults();
                    ComposerKt.sourceInformation(composerStartRestartGroup, "39@1956L23");
                    continuation = null;
                    if ((i & 1) != 0) {
                        if (i9 != 0) {
                            modifier2 = Modifier.INSTANCE;
                        }
                        if (i4 != 0) {
                            homeScreenViewsVisibilityState3 = null;
                        } else {
                            homeScreenViewsVisibilityState3 = homeScreenViewsVisibilityState2;
                        }
                        if (i6 != 0) {
                            z5 = false;
                        } else {
                            z5 = z2;
                        }
                        if ((i2 & 64) != 0) {
                            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1447482489, "CC(hiltActivityViewModel)N(key)159@5773L7,160@5813L56:ComposeUtils.kt#vejmn0");
                            ProvidableCompositionLocal<Activity> localActivity8 = LocalActivityKt.getLocalActivity();
                            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
                            Object objConsume8 = composerStartRestartGroup.consume(localActivity8);
                            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                            Intrinsics.checkNotNull(objConsume8, "null cannot be cast to non-null type androidx.activity.ComponentActivity");
                            componentActivity = (ComponentActivity) objConsume8;
                            composerStartRestartGroup.startReplaceableGroup(1890788296);
                            ComposerKt.sourceInformation(composerStartRestartGroup, "CC(hiltViewModel)P(1)*45@1969L7,50@2112L47,51@2171L54:HiltViewModel.kt#9mcars");
                            ViewModelProvider.Factory factoryCreateHiltViewModelFactory8 = HiltViewModelKt.createHiltViewModelFactory(componentActivity, composerStartRestartGroup, 0);
                            composerStartRestartGroup.startReplaceableGroup(1729797275);
                            ComposerKt.sourceInformation(composerStartRestartGroup, "CC(viewModel)P(3,2,1)*80@3834L7,90@4209L68:ViewModel.kt#3tja67");
                            if (componentActivity instanceof HasDefaultViewModelProviderFactory) {
                                defaultViewModelCreationExtras = componentActivity.getDefaultViewModelCreationExtras();
                            } else {
                                defaultViewModelCreationExtras = CreationExtras.Empty.INSTANCE;
                            }
                            CreationExtras creationExtras8 = defaultViewModelCreationExtras;
                            continuation = null;
                            ViewModel viewModel8 = ViewModelKt.viewModel((Class<ViewModel>) OfflinedViewModel.class, componentActivity, (String) null, factoryCreateHiltViewModelFactory8, creationExtras8, composerStartRestartGroup, 36936, 0);
                            composerStartRestartGroup.endReplaceableGroup();
                            composerStartRestartGroup.endReplaceableGroup();
                            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                            modifier4 = modifier2;
                            i8 = i3 & (-3670017);
                            offlinedViewModel4 = (OfflinedViewModel) viewModel8;
                        } else {
                            modifier4 = modifier2;
                            i8 = i3;
                            offlinedViewModel4 = offlinedViewModel2;
                        }
                    } else {
                        if (i9 != 0) {
                            modifier2 = Modifier.INSTANCE;
                        }
                        if (i4 != 0) {
                            homeScreenViewsVisibilityState3 = null;
                        } else {
                            homeScreenViewsVisibilityState3 = homeScreenViewsVisibilityState2;
                        }
                        if (i6 != 0) {
                            z5 = false;
                        } else {
                            z5 = z2;
                        }
                        if ((i2 & 64) != 0) {
                            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1447482489, "CC(hiltActivityViewModel)N(key)159@5773L7,160@5813L56:ComposeUtils.kt#vejmn0");
                            ProvidableCompositionLocal<Activity> localActivity9 = LocalActivityKt.getLocalActivity();
                            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
                            Object objConsume9 = composerStartRestartGroup.consume(localActivity9);
                            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                            Intrinsics.checkNotNull(objConsume9, "null cannot be cast to non-null type androidx.activity.ComponentActivity");
                            componentActivity = (ComponentActivity) objConsume9;
                            composerStartRestartGroup.startReplaceableGroup(1890788296);
                            ComposerKt.sourceInformation(composerStartRestartGroup, "CC(hiltViewModel)P(1)*45@1969L7,50@2112L47,51@2171L54:HiltViewModel.kt#9mcars");
                            ViewModelProvider.Factory factoryCreateHiltViewModelFactory9 = HiltViewModelKt.createHiltViewModelFactory(componentActivity, composerStartRestartGroup, 0);
                            composerStartRestartGroup.startReplaceableGroup(1729797275);
                            ComposerKt.sourceInformation(composerStartRestartGroup, "CC(viewModel)P(3,2,1)*80@3834L7,90@4209L68:ViewModel.kt#3tja67");
                            if (componentActivity instanceof HasDefaultViewModelProviderFactory) {
                                defaultViewModelCreationExtras = componentActivity.getDefaultViewModelCreationExtras();
                            } else {
                                defaultViewModelCreationExtras = CreationExtras.Empty.INSTANCE;
                            }
                            CreationExtras creationExtras9 = defaultViewModelCreationExtras;
                            continuation = null;
                            ViewModel viewModel9 = ViewModelKt.viewModel((Class<ViewModel>) OfflinedViewModel.class, componentActivity, (String) null, factoryCreateHiltViewModelFactory9, creationExtras9, composerStartRestartGroup, 36936, 0);
                            composerStartRestartGroup.endReplaceableGroup();
                            composerStartRestartGroup.endReplaceableGroup();
                            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                            modifier4 = modifier2;
                            i8 = i3 & (-3670017);
                            offlinedViewModel4 = (OfflinedViewModel) viewModel9;
                        } else {
                            modifier4 = modifier2;
                            i8 = i3;
                            offlinedViewModel4 = offlinedViewModel2;
                        }
                    }
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-523938171, i8, -1, "com.box.android.browse.cpl.offlined.OfflinedScreen (OfflinedScreen.kt:40)");
                    }
                    store = offlinedViewModel4.getStore();
                    State stateCollectAsStateWithLifecycle6 = FlowExtKt.collectAsStateWithLifecycle(store.getState(), (LifecycleOwner) null, (Lifecycle.State) null, (CoroutineContext) null, composerStartRestartGroup, 0, 7);
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -993392011, "CC(remember):OfflinedScreen.kt#9igjgp");
                    offlinedScreenKt$OfflinedScreen$1$1RememberedValue = composerStartRestartGroup.rememberedValue();
                    if (offlinedScreenKt$OfflinedScreen$1$1RememberedValue == Composer.INSTANCE.getEmpty()) {
                        offlinedScreenKt$OfflinedScreen$1$1RememberedValue = new OfflinedScreenKt$OfflinedScreen$1$1(snackbarHostState, continuation);
                        composerStartRestartGroup.updateRememberedValue(offlinedScreenKt$OfflinedScreen$1$1RememberedValue);
                    }
                    Function4 function9 = (Function4) offlinedScreenKt$OfflinedScreen$1$1RememberedValue;
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -993383082, "CC(remember):OfflinedScreen.kt#9igjgp");
                    zChanged = composerStartRestartGroup.changed(store);
                    objRememberedValue = composerStartRestartGroup.rememberedValue();
                    if (!zChanged) {
                        objRememberedValue = new Function1() { // from class: com.box.android.browse.cpl.offlined.OfflinedScreenKt$$ExternalSyntheticLambda4
                            @Override // kotlin.jvm.functions.Function1
                            public final Object invoke(Object obj) {
                                return OfflinedScreenKt.OfflinedScreen$lambda$2$0(store, ((Boolean) obj).booleanValue());
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                    } else {
                        objRememberedValue = new Function1() { // from class: com.box.android.browse.cpl.offlined.OfflinedScreenKt$$ExternalSyntheticLambda4
                            @Override // kotlin.jvm.functions.Function1
                            public final Object invoke(Object obj) {
                                return OfflinedScreenKt.OfflinedScreen$lambda$2$0(store, ((Boolean) obj).booleanValue());
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                    }
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    Modifier modifierOnVisibilityChanged$default6 = OnVisibilityChangedModifierKt.onVisibilityChanged$default(modifier4, 0L, 1.0f, null, (Function1) objRememberedValue, 5, null);
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -993376502, "CC(remember):OfflinedScreen.kt#9igjgp");
                    zChanged2 = composerStartRestartGroup.changed(store);
                    objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                    if (!zChanged2) {
                        objRememberedValue2 = new Function1() { // from class: com.box.android.browse.cpl.offlined.OfflinedScreenKt$$ExternalSyntheticLambda5
                            @Override // kotlin.jvm.functions.Function1
                            public final Object invoke(Object obj) {
                                return OfflinedScreenKt.OfflinedScreen$lambda$3$0(store, ((Boolean) obj).booleanValue());
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                    } else {
                        objRememberedValue2 = new Function1() { // from class: com.box.android.browse.cpl.offlined.OfflinedScreenKt$$ExternalSyntheticLambda5
                            @Override // kotlin.jvm.functions.Function1
                            public final Object invoke(Object obj) {
                                return OfflinedScreenKt.OfflinedScreen$lambda$3$0(store, ((Boolean) obj).booleanValue());
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                    }
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    int i16 = i8 >> 3;
                    OfflinedContentKt.OfflinedContent(store, OnVisibilityChangedModifierKt.onVisibilityChanged$default(modifierOnVisibilityChanged$default6, 0L, 0.0f, null, (Function1) objRememberedValue2, 5, null), function9, true, z5, composerStartRestartGroup, (i16 & 57344) | 3072, 0);
                    NavigationRouteEffect(OfflinedScreen$lambda$0(stateCollectAsStateWithLifecycle6).getNavigationRoute(), navigator, store, composerStartRestartGroup, (i8 << 3) & 112);
                    SelectionModeViewsVisibilityEffect(OfflinedScreen$lambda$0(stateCollectAsStateWithLifecycle6).getActionableItemsListState().getIsSelecting(), homeScreenViewsVisibilityState3, composerStartRestartGroup, (i8 >> 9) & 112);
                    UpdateItemsSnackbarEffect(OfflinedScreen$lambda$0(stateCollectAsStateWithLifecycle6), store, snackbarHostState, composerStartRestartGroup, i8 & 896);
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -993355224, "CC(remember):OfflinedScreen.kt#9igjgp");
                    zChanged3 = composerStartRestartGroup.changed(store);
                    objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                    if (!zChanged3) {
                        objRememberedValue3 = new Function1() { // from class: com.box.android.browse.cpl.offlined.OfflinedScreenKt$$ExternalSyntheticLambda6
                            @Override // kotlin.jvm.functions.Function1
                            public final Object invoke(Object obj) {
                                return OfflinedScreenKt.OfflinedScreen$lambda$4$0(store, (BoxMessage) obj);
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                    } else {
                        objRememberedValue3 = new Function1() { // from class: com.box.android.browse.cpl.offlined.OfflinedScreenKt$$ExternalSyntheticLambda6
                            @Override // kotlin.jvm.functions.Function1
                            public final Object invoke(Object obj) {
                                return OfflinedScreenKt.OfflinedScreen$lambda$4$0(store, (BoxMessage) obj);
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                    }
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    BoxMessageListenerEffectKt.BoxMessageListenerEffect(boxMessageDispatcher, (Function1) objRememberedValue3, composerStartRestartGroup, BoxMessageDispatcher.$stable | (i16 & 14));
                    Lifecycle.Event event6 = Lifecycle.Event.ON_RESUME;
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -993349174, "CC(remember):OfflinedScreen.kt#9igjgp");
                    zChanged4 = composerStartRestartGroup.changed(store);
                    objRememberedValue4 = composerStartRestartGroup.rememberedValue();
                    if (!zChanged4) {
                        objRememberedValue4 = new Function0() { // from class: com.box.android.browse.cpl.offlined.OfflinedScreenKt$$ExternalSyntheticLambda7
                            @Override // kotlin.jvm.functions.Function0
                            public final Object invoke() {
                                return OfflinedScreenKt.OfflinedScreen$lambda$5$0(store);
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue4);
                    } else {
                        objRememberedValue4 = new Function0() { // from class: com.box.android.browse.cpl.offlined.OfflinedScreenKt$$ExternalSyntheticLambda7
                            @Override // kotlin.jvm.functions.Function0
                            public final Object invoke() {
                                return OfflinedScreenKt.OfflinedScreen$lambda$5$0(store);
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue4);
                    }
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    LifecycleEffectKt.LifecycleEventEffect(event6, null, (Function0) objRememberedValue4, composerStartRestartGroup, 6, 2);
                    composerStartRestartGroup = composerStartRestartGroup;
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    z4 = z5;
                    offlinedViewModel3 = offlinedViewModel4;
                    modifier3 = modifier4;
                } else {
                    composerStartRestartGroup.skipToGroupEnd();
                    modifier3 = modifier2;
                    homeScreenViewsVisibilityState3 = homeScreenViewsVisibilityState2;
                    z4 = z2;
                    offlinedViewModel3 = offlinedViewModel2;
                }
                scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.box.android.browse.cpl.offlined.OfflinedScreenKt$$ExternalSyntheticLambda8
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return OfflinedScreenKt.OfflinedScreen$lambda$6(navigator, boxMessageDispatcher, snackbarHostState, modifier3, homeScreenViewsVisibilityState3, z4, offlinedViewModel3, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    });
                }
            }
            i3 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
            z2 = z;
            if ((1572864 & i) == 0) {
                if ((i2 & 64) == 0) {
                    offlinedViewModel2 = offlinedViewModel;
                    if (composerStartRestartGroup.changedInstance(offlinedViewModel2)) {
                    }
                    i3 |= i10;
                } else {
                    offlinedViewModel2 = offlinedViewModel;
                }
                i3 |= i10;
            } else {
                offlinedViewModel2 = offlinedViewModel;
            }
            if ((599187 & i3) != 599186) {
                z3 = true;
            } else {
                z3 = false;
            }
            if (composerStartRestartGroup.shouldExecute(z3, i3 & 1)) {
                composerStartRestartGroup.startDefaults();
                ComposerKt.sourceInformation(composerStartRestartGroup, "39@1956L23");
                continuation = null;
                if ((i & 1) != 0) {
                    if (i9 != 0) {
                        modifier2 = Modifier.INSTANCE;
                    }
                    if (i4 != 0) {
                        homeScreenViewsVisibilityState3 = null;
                    } else {
                        homeScreenViewsVisibilityState3 = homeScreenViewsVisibilityState2;
                    }
                    if (i6 != 0) {
                        z5 = false;
                    } else {
                        z5 = z2;
                    }
                    if ((i2 & 64) != 0) {
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1447482489, "CC(hiltActivityViewModel)N(key)159@5773L7,160@5813L56:ComposeUtils.kt#vejmn0");
                        ProvidableCompositionLocal<Activity> localActivity10 = LocalActivityKt.getLocalActivity();
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
                        Object objConsume10 = composerStartRestartGroup.consume(localActivity10);
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        Intrinsics.checkNotNull(objConsume10, "null cannot be cast to non-null type androidx.activity.ComponentActivity");
                        componentActivity = (ComponentActivity) objConsume10;
                        composerStartRestartGroup.startReplaceableGroup(1890788296);
                        ComposerKt.sourceInformation(composerStartRestartGroup, "CC(hiltViewModel)P(1)*45@1969L7,50@2112L47,51@2171L54:HiltViewModel.kt#9mcars");
                        ViewModelProvider.Factory factoryCreateHiltViewModelFactory10 = HiltViewModelKt.createHiltViewModelFactory(componentActivity, composerStartRestartGroup, 0);
                        composerStartRestartGroup.startReplaceableGroup(1729797275);
                        ComposerKt.sourceInformation(composerStartRestartGroup, "CC(viewModel)P(3,2,1)*80@3834L7,90@4209L68:ViewModel.kt#3tja67");
                        if (componentActivity instanceof HasDefaultViewModelProviderFactory) {
                            defaultViewModelCreationExtras = componentActivity.getDefaultViewModelCreationExtras();
                        } else {
                            defaultViewModelCreationExtras = CreationExtras.Empty.INSTANCE;
                        }
                        CreationExtras creationExtras10 = defaultViewModelCreationExtras;
                        continuation = null;
                        ViewModel viewModel10 = ViewModelKt.viewModel((Class<ViewModel>) OfflinedViewModel.class, componentActivity, (String) null, factoryCreateHiltViewModelFactory10, creationExtras10, composerStartRestartGroup, 36936, 0);
                        composerStartRestartGroup.endReplaceableGroup();
                        composerStartRestartGroup.endReplaceableGroup();
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        modifier4 = modifier2;
                        i8 = i3 & (-3670017);
                        offlinedViewModel4 = (OfflinedViewModel) viewModel10;
                    } else {
                        modifier4 = modifier2;
                        i8 = i3;
                        offlinedViewModel4 = offlinedViewModel2;
                    }
                } else {
                    if (i9 != 0) {
                        modifier2 = Modifier.INSTANCE;
                    }
                    if (i4 != 0) {
                        homeScreenViewsVisibilityState3 = null;
                    } else {
                        homeScreenViewsVisibilityState3 = homeScreenViewsVisibilityState2;
                    }
                    if (i6 != 0) {
                        z5 = false;
                    } else {
                        z5 = z2;
                    }
                    if ((i2 & 64) != 0) {
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1447482489, "CC(hiltActivityViewModel)N(key)159@5773L7,160@5813L56:ComposeUtils.kt#vejmn0");
                        ProvidableCompositionLocal<Activity> localActivity11 = LocalActivityKt.getLocalActivity();
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
                        Object objConsume11 = composerStartRestartGroup.consume(localActivity11);
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        Intrinsics.checkNotNull(objConsume11, "null cannot be cast to non-null type androidx.activity.ComponentActivity");
                        componentActivity = (ComponentActivity) objConsume11;
                        composerStartRestartGroup.startReplaceableGroup(1890788296);
                        ComposerKt.sourceInformation(composerStartRestartGroup, "CC(hiltViewModel)P(1)*45@1969L7,50@2112L47,51@2171L54:HiltViewModel.kt#9mcars");
                        ViewModelProvider.Factory factoryCreateHiltViewModelFactory11 = HiltViewModelKt.createHiltViewModelFactory(componentActivity, composerStartRestartGroup, 0);
                        composerStartRestartGroup.startReplaceableGroup(1729797275);
                        ComposerKt.sourceInformation(composerStartRestartGroup, "CC(viewModel)P(3,2,1)*80@3834L7,90@4209L68:ViewModel.kt#3tja67");
                        if (componentActivity instanceof HasDefaultViewModelProviderFactory) {
                            defaultViewModelCreationExtras = componentActivity.getDefaultViewModelCreationExtras();
                        } else {
                            defaultViewModelCreationExtras = CreationExtras.Empty.INSTANCE;
                        }
                        CreationExtras creationExtras11 = defaultViewModelCreationExtras;
                        continuation = null;
                        ViewModel viewModel11 = ViewModelKt.viewModel((Class<ViewModel>) OfflinedViewModel.class, componentActivity, (String) null, factoryCreateHiltViewModelFactory11, creationExtras11, composerStartRestartGroup, 36936, 0);
                        composerStartRestartGroup.endReplaceableGroup();
                        composerStartRestartGroup.endReplaceableGroup();
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        modifier4 = modifier2;
                        i8 = i3 & (-3670017);
                        offlinedViewModel4 = (OfflinedViewModel) viewModel11;
                    } else {
                        modifier4 = modifier2;
                        i8 = i3;
                        offlinedViewModel4 = offlinedViewModel2;
                    }
                }
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-523938171, i8, -1, "com.box.android.browse.cpl.offlined.OfflinedScreen (OfflinedScreen.kt:40)");
                }
                store = offlinedViewModel4.getStore();
                State stateCollectAsStateWithLifecycle7 = FlowExtKt.collectAsStateWithLifecycle(store.getState(), (LifecycleOwner) null, (Lifecycle.State) null, (CoroutineContext) null, composerStartRestartGroup, 0, 7);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -993392011, "CC(remember):OfflinedScreen.kt#9igjgp");
                offlinedScreenKt$OfflinedScreen$1$1RememberedValue = composerStartRestartGroup.rememberedValue();
                if (offlinedScreenKt$OfflinedScreen$1$1RememberedValue == Composer.INSTANCE.getEmpty()) {
                    offlinedScreenKt$OfflinedScreen$1$1RememberedValue = new OfflinedScreenKt$OfflinedScreen$1$1(snackbarHostState, continuation);
                    composerStartRestartGroup.updateRememberedValue(offlinedScreenKt$OfflinedScreen$1$1RememberedValue);
                }
                Function4 function10 = (Function4) offlinedScreenKt$OfflinedScreen$1$1RememberedValue;
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -993383082, "CC(remember):OfflinedScreen.kt#9igjgp");
                zChanged = composerStartRestartGroup.changed(store);
                objRememberedValue = composerStartRestartGroup.rememberedValue();
                if (!zChanged) {
                    objRememberedValue = new Function1() { // from class: com.box.android.browse.cpl.offlined.OfflinedScreenKt$$ExternalSyntheticLambda4
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            return OfflinedScreenKt.OfflinedScreen$lambda$2$0(store, ((Boolean) obj).booleanValue());
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                } else {
                    objRememberedValue = new Function1() { // from class: com.box.android.browse.cpl.offlined.OfflinedScreenKt$$ExternalSyntheticLambda4
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            return OfflinedScreenKt.OfflinedScreen$lambda$2$0(store, ((Boolean) obj).booleanValue());
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                }
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                Modifier modifierOnVisibilityChanged$default7 = OnVisibilityChangedModifierKt.onVisibilityChanged$default(modifier4, 0L, 1.0f, null, (Function1) objRememberedValue, 5, null);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -993376502, "CC(remember):OfflinedScreen.kt#9igjgp");
                zChanged2 = composerStartRestartGroup.changed(store);
                objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                if (!zChanged2) {
                    objRememberedValue2 = new Function1() { // from class: com.box.android.browse.cpl.offlined.OfflinedScreenKt$$ExternalSyntheticLambda5
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            return OfflinedScreenKt.OfflinedScreen$lambda$3$0(store, ((Boolean) obj).booleanValue());
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                } else {
                    objRememberedValue2 = new Function1() { // from class: com.box.android.browse.cpl.offlined.OfflinedScreenKt$$ExternalSyntheticLambda5
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            return OfflinedScreenKt.OfflinedScreen$lambda$3$0(store, ((Boolean) obj).booleanValue());
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                }
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                int i17 = i8 >> 3;
                OfflinedContentKt.OfflinedContent(store, OnVisibilityChangedModifierKt.onVisibilityChanged$default(modifierOnVisibilityChanged$default7, 0L, 0.0f, null, (Function1) objRememberedValue2, 5, null), function10, true, z5, composerStartRestartGroup, (i17 & 57344) | 3072, 0);
                NavigationRouteEffect(OfflinedScreen$lambda$0(stateCollectAsStateWithLifecycle7).getNavigationRoute(), navigator, store, composerStartRestartGroup, (i8 << 3) & 112);
                SelectionModeViewsVisibilityEffect(OfflinedScreen$lambda$0(stateCollectAsStateWithLifecycle7).getActionableItemsListState().getIsSelecting(), homeScreenViewsVisibilityState3, composerStartRestartGroup, (i8 >> 9) & 112);
                UpdateItemsSnackbarEffect(OfflinedScreen$lambda$0(stateCollectAsStateWithLifecycle7), store, snackbarHostState, composerStartRestartGroup, i8 & 896);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -993355224, "CC(remember):OfflinedScreen.kt#9igjgp");
                zChanged3 = composerStartRestartGroup.changed(store);
                objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                if (!zChanged3) {
                    objRememberedValue3 = new Function1() { // from class: com.box.android.browse.cpl.offlined.OfflinedScreenKt$$ExternalSyntheticLambda6
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            return OfflinedScreenKt.OfflinedScreen$lambda$4$0(store, (BoxMessage) obj);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                } else {
                    objRememberedValue3 = new Function1() { // from class: com.box.android.browse.cpl.offlined.OfflinedScreenKt$$ExternalSyntheticLambda6
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            return OfflinedScreenKt.OfflinedScreen$lambda$4$0(store, (BoxMessage) obj);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                }
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                BoxMessageListenerEffectKt.BoxMessageListenerEffect(boxMessageDispatcher, (Function1) objRememberedValue3, composerStartRestartGroup, BoxMessageDispatcher.$stable | (i17 & 14));
                Lifecycle.Event event7 = Lifecycle.Event.ON_RESUME;
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -993349174, "CC(remember):OfflinedScreen.kt#9igjgp");
                zChanged4 = composerStartRestartGroup.changed(store);
                objRememberedValue4 = composerStartRestartGroup.rememberedValue();
                if (!zChanged4) {
                    objRememberedValue4 = new Function0() { // from class: com.box.android.browse.cpl.offlined.OfflinedScreenKt$$ExternalSyntheticLambda7
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            return OfflinedScreenKt.OfflinedScreen$lambda$5$0(store);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue4);
                } else {
                    objRememberedValue4 = new Function0() { // from class: com.box.android.browse.cpl.offlined.OfflinedScreenKt$$ExternalSyntheticLambda7
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            return OfflinedScreenKt.OfflinedScreen$lambda$5$0(store);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue4);
                }
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                LifecycleEffectKt.LifecycleEventEffect(event7, null, (Function0) objRememberedValue4, composerStartRestartGroup, 6, 2);
                composerStartRestartGroup = composerStartRestartGroup;
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                z4 = z5;
                offlinedViewModel3 = offlinedViewModel4;
                modifier3 = modifier4;
            } else {
                composerStartRestartGroup.skipToGroupEnd();
                modifier3 = modifier2;
                homeScreenViewsVisibilityState3 = homeScreenViewsVisibilityState2;
                z4 = z2;
                offlinedViewModel3 = offlinedViewModel2;
            }
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.box.android.browse.cpl.offlined.OfflinedScreenKt$$ExternalSyntheticLambda8
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return OfflinedScreenKt.OfflinedScreen$lambda$6(navigator, boxMessageDispatcher, snackbarHostState, modifier3, homeScreenViewsVisibilityState3, z4, offlinedViewModel3, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                    }
                });
            }
        }
        i3 |= 24576;
        homeScreenViewsVisibilityState2 = homeScreenViewsVisibilityState;
        i6 = i2 & 32;
        if (i6 != 0) {
            if ((196608 & i) == 0) {
                z2 = z;
                if (composerStartRestartGroup.changed(z2)) {
                    i7 = 131072;
                } else {
                    i7 = 65536;
                }
                i3 |= i7;
            }
            if ((1572864 & i) == 0) {
                if ((i2 & 64) == 0) {
                    offlinedViewModel2 = offlinedViewModel;
                    if (composerStartRestartGroup.changedInstance(offlinedViewModel2)) {
                    }
                    i3 |= i10;
                } else {
                    offlinedViewModel2 = offlinedViewModel;
                }
                i3 |= i10;
            } else {
                offlinedViewModel2 = offlinedViewModel;
            }
            if ((599187 & i3) != 599186) {
                z3 = true;
            } else {
                z3 = false;
            }
            if (composerStartRestartGroup.shouldExecute(z3, i3 & 1)) {
                composerStartRestartGroup.startDefaults();
                ComposerKt.sourceInformation(composerStartRestartGroup, "39@1956L23");
                continuation = null;
                if ((i & 1) != 0) {
                    if (i9 != 0) {
                        modifier2 = Modifier.INSTANCE;
                    }
                    if (i4 != 0) {
                        homeScreenViewsVisibilityState3 = null;
                    } else {
                        homeScreenViewsVisibilityState3 = homeScreenViewsVisibilityState2;
                    }
                    if (i6 != 0) {
                        z5 = false;
                    } else {
                        z5 = z2;
                    }
                    if ((i2 & 64) != 0) {
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1447482489, "CC(hiltActivityViewModel)N(key)159@5773L7,160@5813L56:ComposeUtils.kt#vejmn0");
                        ProvidableCompositionLocal<Activity> localActivity12 = LocalActivityKt.getLocalActivity();
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
                        Object objConsume12 = composerStartRestartGroup.consume(localActivity12);
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        Intrinsics.checkNotNull(objConsume12, "null cannot be cast to non-null type androidx.activity.ComponentActivity");
                        componentActivity = (ComponentActivity) objConsume12;
                        composerStartRestartGroup.startReplaceableGroup(1890788296);
                        ComposerKt.sourceInformation(composerStartRestartGroup, "CC(hiltViewModel)P(1)*45@1969L7,50@2112L47,51@2171L54:HiltViewModel.kt#9mcars");
                        ViewModelProvider.Factory factoryCreateHiltViewModelFactory12 = HiltViewModelKt.createHiltViewModelFactory(componentActivity, composerStartRestartGroup, 0);
                        composerStartRestartGroup.startReplaceableGroup(1729797275);
                        ComposerKt.sourceInformation(composerStartRestartGroup, "CC(viewModel)P(3,2,1)*80@3834L7,90@4209L68:ViewModel.kt#3tja67");
                        if (componentActivity instanceof HasDefaultViewModelProviderFactory) {
                            defaultViewModelCreationExtras = componentActivity.getDefaultViewModelCreationExtras();
                        } else {
                            defaultViewModelCreationExtras = CreationExtras.Empty.INSTANCE;
                        }
                        CreationExtras creationExtras12 = defaultViewModelCreationExtras;
                        continuation = null;
                        ViewModel viewModel12 = ViewModelKt.viewModel((Class<ViewModel>) OfflinedViewModel.class, componentActivity, (String) null, factoryCreateHiltViewModelFactory12, creationExtras12, composerStartRestartGroup, 36936, 0);
                        composerStartRestartGroup.endReplaceableGroup();
                        composerStartRestartGroup.endReplaceableGroup();
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        modifier4 = modifier2;
                        i8 = i3 & (-3670017);
                        offlinedViewModel4 = (OfflinedViewModel) viewModel12;
                    } else {
                        modifier4 = modifier2;
                        i8 = i3;
                        offlinedViewModel4 = offlinedViewModel2;
                    }
                } else {
                    if (i9 != 0) {
                        modifier2 = Modifier.INSTANCE;
                    }
                    if (i4 != 0) {
                        homeScreenViewsVisibilityState3 = null;
                    } else {
                        homeScreenViewsVisibilityState3 = homeScreenViewsVisibilityState2;
                    }
                    if (i6 != 0) {
                        z5 = false;
                    } else {
                        z5 = z2;
                    }
                    if ((i2 & 64) != 0) {
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1447482489, "CC(hiltActivityViewModel)N(key)159@5773L7,160@5813L56:ComposeUtils.kt#vejmn0");
                        ProvidableCompositionLocal<Activity> localActivity13 = LocalActivityKt.getLocalActivity();
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
                        Object objConsume13 = composerStartRestartGroup.consume(localActivity13);
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        Intrinsics.checkNotNull(objConsume13, "null cannot be cast to non-null type androidx.activity.ComponentActivity");
                        componentActivity = (ComponentActivity) objConsume13;
                        composerStartRestartGroup.startReplaceableGroup(1890788296);
                        ComposerKt.sourceInformation(composerStartRestartGroup, "CC(hiltViewModel)P(1)*45@1969L7,50@2112L47,51@2171L54:HiltViewModel.kt#9mcars");
                        ViewModelProvider.Factory factoryCreateHiltViewModelFactory13 = HiltViewModelKt.createHiltViewModelFactory(componentActivity, composerStartRestartGroup, 0);
                        composerStartRestartGroup.startReplaceableGroup(1729797275);
                        ComposerKt.sourceInformation(composerStartRestartGroup, "CC(viewModel)P(3,2,1)*80@3834L7,90@4209L68:ViewModel.kt#3tja67");
                        if (componentActivity instanceof HasDefaultViewModelProviderFactory) {
                            defaultViewModelCreationExtras = componentActivity.getDefaultViewModelCreationExtras();
                        } else {
                            defaultViewModelCreationExtras = CreationExtras.Empty.INSTANCE;
                        }
                        CreationExtras creationExtras13 = defaultViewModelCreationExtras;
                        continuation = null;
                        ViewModel viewModel13 = ViewModelKt.viewModel((Class<ViewModel>) OfflinedViewModel.class, componentActivity, (String) null, factoryCreateHiltViewModelFactory13, creationExtras13, composerStartRestartGroup, 36936, 0);
                        composerStartRestartGroup.endReplaceableGroup();
                        composerStartRestartGroup.endReplaceableGroup();
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        modifier4 = modifier2;
                        i8 = i3 & (-3670017);
                        offlinedViewModel4 = (OfflinedViewModel) viewModel13;
                    } else {
                        modifier4 = modifier2;
                        i8 = i3;
                        offlinedViewModel4 = offlinedViewModel2;
                    }
                }
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-523938171, i8, -1, "com.box.android.browse.cpl.offlined.OfflinedScreen (OfflinedScreen.kt:40)");
                }
                store = offlinedViewModel4.getStore();
                State stateCollectAsStateWithLifecycle8 = FlowExtKt.collectAsStateWithLifecycle(store.getState(), (LifecycleOwner) null, (Lifecycle.State) null, (CoroutineContext) null, composerStartRestartGroup, 0, 7);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -993392011, "CC(remember):OfflinedScreen.kt#9igjgp");
                offlinedScreenKt$OfflinedScreen$1$1RememberedValue = composerStartRestartGroup.rememberedValue();
                if (offlinedScreenKt$OfflinedScreen$1$1RememberedValue == Composer.INSTANCE.getEmpty()) {
                    offlinedScreenKt$OfflinedScreen$1$1RememberedValue = new OfflinedScreenKt$OfflinedScreen$1$1(snackbarHostState, continuation);
                    composerStartRestartGroup.updateRememberedValue(offlinedScreenKt$OfflinedScreen$1$1RememberedValue);
                }
                Function4 function11 = (Function4) offlinedScreenKt$OfflinedScreen$1$1RememberedValue;
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -993383082, "CC(remember):OfflinedScreen.kt#9igjgp");
                zChanged = composerStartRestartGroup.changed(store);
                objRememberedValue = composerStartRestartGroup.rememberedValue();
                if (!zChanged) {
                    objRememberedValue = new Function1() { // from class: com.box.android.browse.cpl.offlined.OfflinedScreenKt$$ExternalSyntheticLambda4
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            return OfflinedScreenKt.OfflinedScreen$lambda$2$0(store, ((Boolean) obj).booleanValue());
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                } else {
                    objRememberedValue = new Function1() { // from class: com.box.android.browse.cpl.offlined.OfflinedScreenKt$$ExternalSyntheticLambda4
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            return OfflinedScreenKt.OfflinedScreen$lambda$2$0(store, ((Boolean) obj).booleanValue());
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                }
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                Modifier modifierOnVisibilityChanged$default8 = OnVisibilityChangedModifierKt.onVisibilityChanged$default(modifier4, 0L, 1.0f, null, (Function1) objRememberedValue, 5, null);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -993376502, "CC(remember):OfflinedScreen.kt#9igjgp");
                zChanged2 = composerStartRestartGroup.changed(store);
                objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                if (!zChanged2) {
                    objRememberedValue2 = new Function1() { // from class: com.box.android.browse.cpl.offlined.OfflinedScreenKt$$ExternalSyntheticLambda5
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            return OfflinedScreenKt.OfflinedScreen$lambda$3$0(store, ((Boolean) obj).booleanValue());
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                } else {
                    objRememberedValue2 = new Function1() { // from class: com.box.android.browse.cpl.offlined.OfflinedScreenKt$$ExternalSyntheticLambda5
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            return OfflinedScreenKt.OfflinedScreen$lambda$3$0(store, ((Boolean) obj).booleanValue());
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                }
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                int i18 = i8 >> 3;
                OfflinedContentKt.OfflinedContent(store, OnVisibilityChangedModifierKt.onVisibilityChanged$default(modifierOnVisibilityChanged$default8, 0L, 0.0f, null, (Function1) objRememberedValue2, 5, null), function11, true, z5, composerStartRestartGroup, (i18 & 57344) | 3072, 0);
                NavigationRouteEffect(OfflinedScreen$lambda$0(stateCollectAsStateWithLifecycle8).getNavigationRoute(), navigator, store, composerStartRestartGroup, (i8 << 3) & 112);
                SelectionModeViewsVisibilityEffect(OfflinedScreen$lambda$0(stateCollectAsStateWithLifecycle8).getActionableItemsListState().getIsSelecting(), homeScreenViewsVisibilityState3, composerStartRestartGroup, (i8 >> 9) & 112);
                UpdateItemsSnackbarEffect(OfflinedScreen$lambda$0(stateCollectAsStateWithLifecycle8), store, snackbarHostState, composerStartRestartGroup, i8 & 896);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -993355224, "CC(remember):OfflinedScreen.kt#9igjgp");
                zChanged3 = composerStartRestartGroup.changed(store);
                objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                if (!zChanged3) {
                    objRememberedValue3 = new Function1() { // from class: com.box.android.browse.cpl.offlined.OfflinedScreenKt$$ExternalSyntheticLambda6
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            return OfflinedScreenKt.OfflinedScreen$lambda$4$0(store, (BoxMessage) obj);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                } else {
                    objRememberedValue3 = new Function1() { // from class: com.box.android.browse.cpl.offlined.OfflinedScreenKt$$ExternalSyntheticLambda6
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            return OfflinedScreenKt.OfflinedScreen$lambda$4$0(store, (BoxMessage) obj);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                }
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                BoxMessageListenerEffectKt.BoxMessageListenerEffect(boxMessageDispatcher, (Function1) objRememberedValue3, composerStartRestartGroup, BoxMessageDispatcher.$stable | (i18 & 14));
                Lifecycle.Event event8 = Lifecycle.Event.ON_RESUME;
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -993349174, "CC(remember):OfflinedScreen.kt#9igjgp");
                zChanged4 = composerStartRestartGroup.changed(store);
                objRememberedValue4 = composerStartRestartGroup.rememberedValue();
                if (!zChanged4) {
                    objRememberedValue4 = new Function0() { // from class: com.box.android.browse.cpl.offlined.OfflinedScreenKt$$ExternalSyntheticLambda7
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            return OfflinedScreenKt.OfflinedScreen$lambda$5$0(store);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue4);
                } else {
                    objRememberedValue4 = new Function0() { // from class: com.box.android.browse.cpl.offlined.OfflinedScreenKt$$ExternalSyntheticLambda7
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            return OfflinedScreenKt.OfflinedScreen$lambda$5$0(store);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue4);
                }
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                LifecycleEffectKt.LifecycleEventEffect(event8, null, (Function0) objRememberedValue4, composerStartRestartGroup, 6, 2);
                composerStartRestartGroup = composerStartRestartGroup;
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                z4 = z5;
                offlinedViewModel3 = offlinedViewModel4;
                modifier3 = modifier4;
            } else {
                composerStartRestartGroup.skipToGroupEnd();
                modifier3 = modifier2;
                homeScreenViewsVisibilityState3 = homeScreenViewsVisibilityState2;
                z4 = z2;
                offlinedViewModel3 = offlinedViewModel2;
            }
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.box.android.browse.cpl.offlined.OfflinedScreenKt$$ExternalSyntheticLambda8
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return OfflinedScreenKt.OfflinedScreen$lambda$6(navigator, boxMessageDispatcher, snackbarHostState, modifier3, homeScreenViewsVisibilityState3, z4, offlinedViewModel3, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                    }
                });
            }
        }
        i3 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
        z2 = z;
        if ((1572864 & i) == 0) {
            if ((i2 & 64) == 0) {
                offlinedViewModel2 = offlinedViewModel;
                if (composerStartRestartGroup.changedInstance(offlinedViewModel2)) {
                }
                i3 |= i10;
            } else {
                offlinedViewModel2 = offlinedViewModel;
            }
            i3 |= i10;
        } else {
            offlinedViewModel2 = offlinedViewModel;
        }
        if ((599187 & i3) != 599186) {
            z3 = true;
        } else {
            z3 = false;
        }
        if (composerStartRestartGroup.shouldExecute(z3, i3 & 1)) {
            composerStartRestartGroup.startDefaults();
            ComposerKt.sourceInformation(composerStartRestartGroup, "39@1956L23");
            continuation = null;
            if ((i & 1) != 0) {
                if (i9 != 0) {
                    modifier2 = Modifier.INSTANCE;
                }
                if (i4 != 0) {
                    homeScreenViewsVisibilityState3 = null;
                } else {
                    homeScreenViewsVisibilityState3 = homeScreenViewsVisibilityState2;
                }
                if (i6 != 0) {
                    z5 = false;
                } else {
                    z5 = z2;
                }
                if ((i2 & 64) != 0) {
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1447482489, "CC(hiltActivityViewModel)N(key)159@5773L7,160@5813L56:ComposeUtils.kt#vejmn0");
                    ProvidableCompositionLocal<Activity> localActivity14 = LocalActivityKt.getLocalActivity();
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
                    Object objConsume14 = composerStartRestartGroup.consume(localActivity14);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    Intrinsics.checkNotNull(objConsume14, "null cannot be cast to non-null type androidx.activity.ComponentActivity");
                    componentActivity = (ComponentActivity) objConsume14;
                    composerStartRestartGroup.startReplaceableGroup(1890788296);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "CC(hiltViewModel)P(1)*45@1969L7,50@2112L47,51@2171L54:HiltViewModel.kt#9mcars");
                    ViewModelProvider.Factory factoryCreateHiltViewModelFactory14 = HiltViewModelKt.createHiltViewModelFactory(componentActivity, composerStartRestartGroup, 0);
                    composerStartRestartGroup.startReplaceableGroup(1729797275);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "CC(viewModel)P(3,2,1)*80@3834L7,90@4209L68:ViewModel.kt#3tja67");
                    if (componentActivity instanceof HasDefaultViewModelProviderFactory) {
                        defaultViewModelCreationExtras = componentActivity.getDefaultViewModelCreationExtras();
                    } else {
                        defaultViewModelCreationExtras = CreationExtras.Empty.INSTANCE;
                    }
                    CreationExtras creationExtras14 = defaultViewModelCreationExtras;
                    continuation = null;
                    ViewModel viewModel14 = ViewModelKt.viewModel((Class<ViewModel>) OfflinedViewModel.class, componentActivity, (String) null, factoryCreateHiltViewModelFactory14, creationExtras14, composerStartRestartGroup, 36936, 0);
                    composerStartRestartGroup.endReplaceableGroup();
                    composerStartRestartGroup.endReplaceableGroup();
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    modifier4 = modifier2;
                    i8 = i3 & (-3670017);
                    offlinedViewModel4 = (OfflinedViewModel) viewModel14;
                } else {
                    modifier4 = modifier2;
                    i8 = i3;
                    offlinedViewModel4 = offlinedViewModel2;
                }
            } else {
                if (i9 != 0) {
                    modifier2 = Modifier.INSTANCE;
                }
                if (i4 != 0) {
                    homeScreenViewsVisibilityState3 = null;
                } else {
                    homeScreenViewsVisibilityState3 = homeScreenViewsVisibilityState2;
                }
                if (i6 != 0) {
                    z5 = false;
                } else {
                    z5 = z2;
                }
                if ((i2 & 64) != 0) {
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1447482489, "CC(hiltActivityViewModel)N(key)159@5773L7,160@5813L56:ComposeUtils.kt#vejmn0");
                    ProvidableCompositionLocal<Activity> localActivity15 = LocalActivityKt.getLocalActivity();
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
                    Object objConsume15 = composerStartRestartGroup.consume(localActivity15);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    Intrinsics.checkNotNull(objConsume15, "null cannot be cast to non-null type androidx.activity.ComponentActivity");
                    componentActivity = (ComponentActivity) objConsume15;
                    composerStartRestartGroup.startReplaceableGroup(1890788296);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "CC(hiltViewModel)P(1)*45@1969L7,50@2112L47,51@2171L54:HiltViewModel.kt#9mcars");
                    ViewModelProvider.Factory factoryCreateHiltViewModelFactory15 = HiltViewModelKt.createHiltViewModelFactory(componentActivity, composerStartRestartGroup, 0);
                    composerStartRestartGroup.startReplaceableGroup(1729797275);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "CC(viewModel)P(3,2,1)*80@3834L7,90@4209L68:ViewModel.kt#3tja67");
                    if (componentActivity instanceof HasDefaultViewModelProviderFactory) {
                        defaultViewModelCreationExtras = componentActivity.getDefaultViewModelCreationExtras();
                    } else {
                        defaultViewModelCreationExtras = CreationExtras.Empty.INSTANCE;
                    }
                    CreationExtras creationExtras15 = defaultViewModelCreationExtras;
                    continuation = null;
                    ViewModel viewModel15 = ViewModelKt.viewModel((Class<ViewModel>) OfflinedViewModel.class, componentActivity, (String) null, factoryCreateHiltViewModelFactory15, creationExtras15, composerStartRestartGroup, 36936, 0);
                    composerStartRestartGroup.endReplaceableGroup();
                    composerStartRestartGroup.endReplaceableGroup();
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    modifier4 = modifier2;
                    i8 = i3 & (-3670017);
                    offlinedViewModel4 = (OfflinedViewModel) viewModel15;
                } else {
                    modifier4 = modifier2;
                    i8 = i3;
                    offlinedViewModel4 = offlinedViewModel2;
                }
            }
            composerStartRestartGroup.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-523938171, i8, -1, "com.box.android.browse.cpl.offlined.OfflinedScreen (OfflinedScreen.kt:40)");
            }
            store = offlinedViewModel4.getStore();
            State stateCollectAsStateWithLifecycle9 = FlowExtKt.collectAsStateWithLifecycle(store.getState(), (LifecycleOwner) null, (Lifecycle.State) null, (CoroutineContext) null, composerStartRestartGroup, 0, 7);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -993392011, "CC(remember):OfflinedScreen.kt#9igjgp");
            offlinedScreenKt$OfflinedScreen$1$1RememberedValue = composerStartRestartGroup.rememberedValue();
            if (offlinedScreenKt$OfflinedScreen$1$1RememberedValue == Composer.INSTANCE.getEmpty()) {
                offlinedScreenKt$OfflinedScreen$1$1RememberedValue = new OfflinedScreenKt$OfflinedScreen$1$1(snackbarHostState, continuation);
                composerStartRestartGroup.updateRememberedValue(offlinedScreenKt$OfflinedScreen$1$1RememberedValue);
            }
            Function4 function12 = (Function4) offlinedScreenKt$OfflinedScreen$1$1RememberedValue;
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -993383082, "CC(remember):OfflinedScreen.kt#9igjgp");
            zChanged = composerStartRestartGroup.changed(store);
            objRememberedValue = composerStartRestartGroup.rememberedValue();
            if (!zChanged) {
                objRememberedValue = new Function1() { // from class: com.box.android.browse.cpl.offlined.OfflinedScreenKt$$ExternalSyntheticLambda4
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return OfflinedScreenKt.OfflinedScreen$lambda$2$0(store, ((Boolean) obj).booleanValue());
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
            } else {
                objRememberedValue = new Function1() { // from class: com.box.android.browse.cpl.offlined.OfflinedScreenKt$$ExternalSyntheticLambda4
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return OfflinedScreenKt.OfflinedScreen$lambda$2$0(store, ((Boolean) obj).booleanValue());
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
            }
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            Modifier modifierOnVisibilityChanged$default9 = OnVisibilityChangedModifierKt.onVisibilityChanged$default(modifier4, 0L, 1.0f, null, (Function1) objRememberedValue, 5, null);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -993376502, "CC(remember):OfflinedScreen.kt#9igjgp");
            zChanged2 = composerStartRestartGroup.changed(store);
            objRememberedValue2 = composerStartRestartGroup.rememberedValue();
            if (!zChanged2) {
                objRememberedValue2 = new Function1() { // from class: com.box.android.browse.cpl.offlined.OfflinedScreenKt$$ExternalSyntheticLambda5
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return OfflinedScreenKt.OfflinedScreen$lambda$3$0(store, ((Boolean) obj).booleanValue());
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
            } else {
                objRememberedValue2 = new Function1() { // from class: com.box.android.browse.cpl.offlined.OfflinedScreenKt$$ExternalSyntheticLambda5
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return OfflinedScreenKt.OfflinedScreen$lambda$3$0(store, ((Boolean) obj).booleanValue());
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
            }
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            int i19 = i8 >> 3;
            OfflinedContentKt.OfflinedContent(store, OnVisibilityChangedModifierKt.onVisibilityChanged$default(modifierOnVisibilityChanged$default9, 0L, 0.0f, null, (Function1) objRememberedValue2, 5, null), function12, true, z5, composerStartRestartGroup, (i19 & 57344) | 3072, 0);
            NavigationRouteEffect(OfflinedScreen$lambda$0(stateCollectAsStateWithLifecycle9).getNavigationRoute(), navigator, store, composerStartRestartGroup, (i8 << 3) & 112);
            SelectionModeViewsVisibilityEffect(OfflinedScreen$lambda$0(stateCollectAsStateWithLifecycle9).getActionableItemsListState().getIsSelecting(), homeScreenViewsVisibilityState3, composerStartRestartGroup, (i8 >> 9) & 112);
            UpdateItemsSnackbarEffect(OfflinedScreen$lambda$0(stateCollectAsStateWithLifecycle9), store, snackbarHostState, composerStartRestartGroup, i8 & 896);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -993355224, "CC(remember):OfflinedScreen.kt#9igjgp");
            zChanged3 = composerStartRestartGroup.changed(store);
            objRememberedValue3 = composerStartRestartGroup.rememberedValue();
            if (!zChanged3) {
                objRememberedValue3 = new Function1() { // from class: com.box.android.browse.cpl.offlined.OfflinedScreenKt$$ExternalSyntheticLambda6
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return OfflinedScreenKt.OfflinedScreen$lambda$4$0(store, (BoxMessage) obj);
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
            } else {
                objRememberedValue3 = new Function1() { // from class: com.box.android.browse.cpl.offlined.OfflinedScreenKt$$ExternalSyntheticLambda6
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return OfflinedScreenKt.OfflinedScreen$lambda$4$0(store, (BoxMessage) obj);
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
            }
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            BoxMessageListenerEffectKt.BoxMessageListenerEffect(boxMessageDispatcher, (Function1) objRememberedValue3, composerStartRestartGroup, BoxMessageDispatcher.$stable | (i19 & 14));
            Lifecycle.Event event9 = Lifecycle.Event.ON_RESUME;
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -993349174, "CC(remember):OfflinedScreen.kt#9igjgp");
            zChanged4 = composerStartRestartGroup.changed(store);
            objRememberedValue4 = composerStartRestartGroup.rememberedValue();
            if (!zChanged4) {
                objRememberedValue4 = new Function0() { // from class: com.box.android.browse.cpl.offlined.OfflinedScreenKt$$ExternalSyntheticLambda7
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return OfflinedScreenKt.OfflinedScreen$lambda$5$0(store);
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue4);
            } else {
                objRememberedValue4 = new Function0() { // from class: com.box.android.browse.cpl.offlined.OfflinedScreenKt$$ExternalSyntheticLambda7
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return OfflinedScreenKt.OfflinedScreen$lambda$5$0(store);
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue4);
            }
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            LifecycleEffectKt.LifecycleEventEffect(event9, null, (Function0) objRememberedValue4, composerStartRestartGroup, 6, 2);
            composerStartRestartGroup = composerStartRestartGroup;
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            z4 = z5;
            offlinedViewModel3 = offlinedViewModel4;
            modifier3 = modifier4;
        } else {
            composerStartRestartGroup.skipToGroupEnd();
            modifier3 = modifier2;
            homeScreenViewsVisibilityState3 = homeScreenViewsVisibilityState2;
            z4 = z2;
            offlinedViewModel3 = offlinedViewModel2;
        }
        scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.box.android.browse.cpl.offlined.OfflinedScreenKt$$ExternalSyntheticLambda8
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return OfflinedScreenKt.OfflinedScreen$lambda$6(navigator, boxMessageDispatcher, snackbarHostState, modifier3, homeScreenViewsVisibilityState3, z4, offlinedViewModel3, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit OfflinedScreen$lambda$2$0(Store store, boolean z) {
        if (z) {
            store.send(OfflinedReducer.Action.TabVisible.INSTANCE);
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit OfflinedScreen$lambda$3$0(Store store, boolean z) {
        if (!z) {
            store.send(OfflinedReducer.Action.TabHidden.INSTANCE);
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit OfflinedScreen$lambda$4$0(Store store, BoxMessage message) {
        Intrinsics.checkNotNullParameter(message, "message");
        OfflinedReducer.Action actionHandle = OfflineScreenBoxMessageHandler.INSTANCE.handle((BoxMessage<?>) message);
        if (actionHandle != null) {
            store.send(actionHandle);
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit OfflinedScreen$lambda$5$0(Store store) {
        store.send(new OfflinedReducer.Action.ChildActionableItemsListAction(new ActionableItemsListReducer.Action.ItemsListAction(ItemsListReducer.Action.ScreenUpdated.INSTANCE)));
        return Unit.INSTANCE;
    }

    private static final void NavigationRouteEffect(final OfflinedReducer.Route route, final BrowseNavigator browseNavigator, final Store<OfflinedReducer.State, OfflinedReducer.Action> store, Composer composer, final int i) {
        int i2;
        Composer composerStartRestartGroup = composer.startRestartGroup(640976821);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(NavigationRouteEffect)N(route,navigator,store)100@3952L1088,100@3930L1110:OfflinedScreen.kt#t6qdi3");
        if ((i & 6) == 0) {
            i2 = (composerStartRestartGroup.changed(route) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 48) == 0) {
            i2 |= composerStartRestartGroup.changedInstance(browseNavigator) ? 32 : 16;
        }
        if ((i & 384) == 0) {
            i2 |= composerStartRestartGroup.changed(store) ? 256 : 128;
        }
        if (!composerStartRestartGroup.shouldExecute((i2 & Token.DOTQUERY) != 146, i2 & 1)) {
            composerStartRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(640976821, i2, -1, "com.box.android.browse.cpl.offlined.NavigationRouteEffect (OfflinedScreen.kt:99)");
            }
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1798408725, "CC(remember):OfflinedScreen.kt#9igjgp");
            int i3 = i2 & 14;
            boolean zChangedInstance = (i3 == 4) | composerStartRestartGroup.changedInstance(browseNavigator) | ((i2 & 896) == 256);
            OfflinedScreenKt$NavigationRouteEffect$1$1 offlinedScreenKt$NavigationRouteEffect$1$1RememberedValue = composerStartRestartGroup.rememberedValue();
            if (zChangedInstance || offlinedScreenKt$NavigationRouteEffect$1$1RememberedValue == Composer.INSTANCE.getEmpty()) {
                offlinedScreenKt$NavigationRouteEffect$1$1RememberedValue = new OfflinedScreenKt$NavigationRouteEffect$1$1(route, browseNavigator, store, null);
                composerStartRestartGroup.updateRememberedValue(offlinedScreenKt$NavigationRouteEffect$1$1RememberedValue);
            }
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            EffectsKt.LaunchedEffect(route, (Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object>) offlinedScreenKt$NavigationRouteEffect$1$1RememberedValue, composerStartRestartGroup, i3);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.box.android.browse.cpl.offlined.OfflinedScreenKt$$ExternalSyntheticLambda2
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return OfflinedScreenKt.NavigationRouteEffect$lambda$1(route, browseNavigator, store, i, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    private static final void SelectionModeViewsVisibilityEffect(final boolean z, final HomeScreenViewsVisibilityState homeScreenViewsVisibilityState, Composer composer, final int i) {
        int i2;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        Function2<? super Composer, ? super Integer, Unit> function2;
        Composer composerStartRestartGroup = composer.startRestartGroup(-124268418);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(SelectionModeViewsVisibilityEffect)N(isSelecting,homeScreenViewsVisibilityState)134@5302L313,134@5242L373:OfflinedScreen.kt#t6qdi3");
        if ((i & 6) == 0) {
            i2 = (composerStartRestartGroup.changed(z) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 48) == 0) {
            i2 |= composerStartRestartGroup.changed(homeScreenViewsVisibilityState) ? 32 : 16;
        }
        if (composerStartRestartGroup.shouldExecute((i2 & 19) != 18, i2 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-124268418, i2, -1, "com.box.android.browse.cpl.offlined.SelectionModeViewsVisibilityEffect (OfflinedScreen.kt:131)");
            }
            if (homeScreenViewsVisibilityState == null) {
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup == null) {
                    return;
                } else {
                    function2 = new Function2() { // from class: com.box.android.browse.cpl.offlined.OfflinedScreenKt$$ExternalSyntheticLambda0
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return OfflinedScreenKt.SelectionModeViewsVisibilityEffect$lambda$0(z, homeScreenViewsVisibilityState, i, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    };
                }
            } else {
                Boolean boolValueOf = Boolean.valueOf(z);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 837142519, "CC(remember):OfflinedScreen.kt#9igjgp");
                boolean z2 = ((i2 & 14) == 4) | ((i2 & 112) == 32);
                OfflinedScreenKt$SelectionModeViewsVisibilityEffect$2$1 offlinedScreenKt$SelectionModeViewsVisibilityEffect$2$1RememberedValue = composerStartRestartGroup.rememberedValue();
                if (z2 || offlinedScreenKt$SelectionModeViewsVisibilityEffect$2$1RememberedValue == Composer.INSTANCE.getEmpty()) {
                    offlinedScreenKt$SelectionModeViewsVisibilityEffect$2$1RememberedValue = new OfflinedScreenKt$SelectionModeViewsVisibilityEffect$2$1(z, homeScreenViewsVisibilityState, null);
                    composerStartRestartGroup.updateRememberedValue(offlinedScreenKt$SelectionModeViewsVisibilityEffect$2$1RememberedValue);
                }
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                EffectsKt.LaunchedEffect(boolValueOf, homeScreenViewsVisibilityState, (Function2) offlinedScreenKt$SelectionModeViewsVisibilityEffect$2$1RememberedValue, composerStartRestartGroup, i2 & 126);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
            }
            scopeUpdateScopeEndRestartGroup.updateScope(function2);
        }
        composerStartRestartGroup.skipToGroupEnd();
        scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            function2 = new Function2() { // from class: com.box.android.browse.cpl.offlined.OfflinedScreenKt$$ExternalSyntheticLambda1
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return OfflinedScreenKt.SelectionModeViewsVisibilityEffect$lambda$2(z, homeScreenViewsVisibilityState, i, (Composer) obj, ((Integer) obj2).intValue());
                }
            };
            scopeUpdateScopeEndRestartGroup.updateScope(function2);
        }
    }

    private static final void UpdateItemsSnackbarEffect(final OfflinedReducer.State state, final Store<OfflinedReducer.State, OfflinedReducer.Action> store, final SnackbarHostState snackbarHostState, Composer composer, final int i) {
        int i2;
        OfflinedScreenKt$UpdateItemsSnackbarEffect$1$1 offlinedScreenKt$UpdateItemsSnackbarEffect$1$1;
        Composer composerStartRestartGroup = composer.startRestartGroup(-2103124965);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(UpdateItemsSnackbarEffect)N(state,store,snackbarHostState):OfflinedScreen.kt#t6qdi3");
        if ((i & 6) == 0) {
            i2 = (composerStartRestartGroup.changedInstance(state) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 48) == 0) {
            i2 |= composerStartRestartGroup.changed(store) ? 32 : 16;
        }
        if ((i & 384) == 0) {
            i2 |= composerStartRestartGroup.changed(snackbarHostState) ? 256 : 128;
        }
        if (!composerStartRestartGroup.shouldExecute((i2 & Token.DOTQUERY) != 146, i2 & 1)) {
            composerStartRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-2103124965, i2, -1, "com.box.android.browse.cpl.offlined.UpdateItemsSnackbarEffect (OfflinedScreen.kt:150)");
            }
            if (!state.getVisible() || state.getOutdatedItems().isEmpty()) {
                composerStartRestartGroup.startReplaceGroup(781486855);
            } else {
                composerStartRestartGroup.startReplaceGroup(787327348);
                ComposerKt.sourceInformation(composerStartRestartGroup, "152@5897L45,153@5963L35,154@6028L274,154@6007L295");
                String strStringResource = StringResources_androidKt.stringResource(R.string.Update_offline_files, composerStartRestartGroup, 0);
                String strStringResource2 = StringResources_androidKt.stringResource(R.string.Update_all, composerStartRestartGroup, 0);
                Unit unit = Unit.INSTANCE;
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1826517773, "CC(remember):OfflinedScreen.kt#9igjgp");
                boolean zChanged = ((i2 & 896) == 256) | composerStartRestartGroup.changed(strStringResource) | composerStartRestartGroup.changed(strStringResource2) | ((i2 & 112) == 32);
                Object objRememberedValue = composerStartRestartGroup.rememberedValue();
                if (zChanged || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                    offlinedScreenKt$UpdateItemsSnackbarEffect$1$1 = new OfflinedScreenKt$UpdateItemsSnackbarEffect$1$1(snackbarHostState, strStringResource, strStringResource2, store, null);
                    composerStartRestartGroup.updateRememberedValue(offlinedScreenKt$UpdateItemsSnackbarEffect$1$1);
                } else {
                    offlinedScreenKt$UpdateItemsSnackbarEffect$1$1 = objRememberedValue;
                }
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                EffectsKt.LaunchedEffect(unit, (Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object>) offlinedScreenKt$UpdateItemsSnackbarEffect$1$1, composerStartRestartGroup, 6);
            }
            composerStartRestartGroup.endReplaceGroup();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.box.android.browse.cpl.offlined.OfflinedScreenKt$$ExternalSyntheticLambda3
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return OfflinedScreenKt.UpdateItemsSnackbarEffect$lambda$1(state, store, snackbarHostState, i, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    private static final OfflinedReducer.State OfflinedScreen$lambda$0(State<OfflinedReducer.State> state) {
        return state.getValue();
    }
}
