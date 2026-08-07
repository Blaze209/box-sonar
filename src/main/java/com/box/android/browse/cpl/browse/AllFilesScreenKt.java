package com.box.android.browse.cpl.browse;

import android.app.Activity;
import androidx.activity.ComponentActivity;
import androidx.activity.compose.LocalActivityKt;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.material3.SnackbarDuration;
import androidx.compose.material3.SnackbarHostState;
import androidx.compose.material3.SnackbarResult;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.ProvidableCompositionLocal;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.runtime.Updater;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.input.nestedscroll.NestedScrollModifierKt;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.layout.OnVisibilityChangedModifierKt;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.hilt.navigation.compose.HiltViewModelKt;
import androidx.lifecycle.HasDefaultViewModelProviderFactory;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.compose.FlowExtKt;
import androidx.lifecycle.compose.LifecycleEffectKt;
import androidx.lifecycle.compose.LifecyclePauseOrDisposeEffectResult;
import androidx.lifecycle.compose.LifecycleResumePauseEffectScope;
import androidx.lifecycle.viewmodel.CreationExtras;
import androidx.lifecycle.viewmodel.compose.ViewModelKt;
import androidx.profileinstaller.ProfileVerifier;
import com.box.android.base.compose.button.fab.ScrollAwareFabVisibility;
import com.box.android.base.compose.button.fab.ScrollAwareFabVisibilityKt;
import com.box.android.base.presentation.message.BoxMessageDispatcher;
import com.box.android.base.presentation.message.BoxMessageListenerEffectKt;
import com.box.android.base.presentation.state.HomeScreenViewsVisibilityState;
import com.box.android.browse.cpl.browse.fab.FilesFabComponentKt;
import com.box.android.browse.cpl.browse.fab.FilesFabReducer;
import com.box.android.browse.cpl.itemsList.ActionableItemsListReducer;
import com.box.android.browse.cpl.itemsList.ItemsListReducer;
import com.box.android.browse.cpl.message.BrowseScreenMessageHandler;
import com.box.android.browse.cpl.navigationmodernization.BrowseDestination;
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
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.reflect.KFunction;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: compiled from: AllFilesScreen.kt */
/* JADX INFO: loaded from: classes10.dex */
@Metadata(d1 = {"\u0000x\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\u001aO\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\b\b\u0002\u0010\u000f\u001a\u00020\u00102\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u00122\b\b\u0002\u0010\u0013\u001a\u00020\u00022\b\b\u0002\u0010\u0014\u001a\u00020\u0015H\u0007¢\u0006\u0002\u0010\u0016\u001a \u0001\u0010\u0017\u001a\u00020\b2\u0012\u0010\u0018\u001a\u000e\u0012\u0004\u0012\u00020\u001a\u0012\u0004\u0012\u00020\u001b0\u00192\u0006\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010\u000f\u001a\u00020\u00102a\b\u0002\u0010\u001c\u001a[\b\u0001\u0012\u0013\u0012\u00110\u001e¢\u0006\f\b\u001f\u0012\b\b \u0012\u0004\b\b(!\u0012\u0015\u0012\u0013\u0018\u00010\u001e¢\u0006\f\b\u001f\u0012\b\b \u0012\u0004\b\b(\"\u0012\u0013\u0012\u00110#¢\u0006\f\b\u001f\u0012\b\b \u0012\u0004\b\b($\u0012\n\u0012\b\u0012\u0004\u0012\u00020&0%\u0012\u0006\u0012\u0004\u0018\u00010'\u0018\u00010\u001d2\b\b\u0002\u0010\u0013\u001a\u00020\u0002H\u0007¢\u0006\u0002\u0010(\u001a1\u0010)\u001a\u00020\b2\u0006\u0010*\u001a\u00020+2\u0006\u0010\t\u001a\u00020\n2\u0012\u0010\u0018\u001a\u000e\u0012\u0004\u0012\u00020\u001a\u0012\u0004\u0012\u00020\u001b0\u0019H\u0003¢\u0006\u0002\u0010,\u001a\u001f\u0010-\u001a\u00020\b2\u0006\u0010.\u001a\u00020\u00022\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012H\u0003¢\u0006\u0002\u0010/\"\"\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u00018\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006¨\u00060²\u0006\n\u00101\u001a\u00020\u001aX\u008a\u0084\u0002²\u0006\n\u00102\u001a\u00020\u0002X\u008a\u008e\u0002"}, d2 = {"LocalFabInitiallyVisible", "Landroidx/compose/runtime/ProvidableCompositionLocal;", "", "getLocalFabInitiallyVisible$annotations", "()V", "getLocalFabInitiallyVisible", "()Landroidx/compose/runtime/ProvidableCompositionLocal;", "AllFilesScreen", "", "navigator", "Lcom/box/android/browse/cpl/navigationmodernization/BrowseNavigator;", "boxMessageDispatcher", "Lcom/box/android/base/presentation/message/BoxMessageDispatcher;", "snackbarHostState", "Landroidx/compose/material3/SnackbarHostState;", "modifier", "Landroidx/compose/ui/Modifier;", "homeScreenViewsVisibilityState", "Lcom/box/android/base/presentation/state/HomeScreenViewsVisibilityState;", "shouldUseAiCenter", "viewModel", "Lcom/box/android/browse/cpl/browse/AllFilesViewModel;", "(Lcom/box/android/browse/cpl/navigationmodernization/BrowseNavigator;Lcom/box/android/base/presentation/message/BoxMessageDispatcher;Landroidx/compose/material3/SnackbarHostState;Landroidx/compose/ui/Modifier;Lcom/box/android/base/presentation/state/HomeScreenViewsVisibilityState;ZLcom/box/android/browse/cpl/browse/AllFilesViewModel;Landroidx/compose/runtime/Composer;II)V", "AllFilesContent", "store", "Lcom/box/android/cpl/Store;", "Lcom/box/android/browse/cpl/browse/BrowseReducer$State;", "Lcom/box/android/browse/cpl/browse/BrowseReducer$Action;", "onShowSnackbar", "Lkotlin/Function4;", "", "Lkotlin/ParameterName;", "name", "message", "actionLabel", "Landroidx/compose/material3/SnackbarDuration;", "duration", "Lkotlin/coroutines/Continuation;", "Landroidx/compose/material3/SnackbarResult;", "", "(Lcom/box/android/cpl/Store;Lcom/box/android/base/presentation/message/BoxMessageDispatcher;Landroidx/compose/ui/Modifier;Lkotlin/jvm/functions/Function4;ZLandroidx/compose/runtime/Composer;II)V", "NavigationRouteEffect", "route", "Lcom/box/android/browse/cpl/browse/BrowseReducer$Route;", "(Lcom/box/android/browse/cpl/browse/BrowseReducer$Route;Lcom/box/android/browse/cpl/navigationmodernization/BrowseNavigator;Lcom/box/android/cpl/Store;Landroidx/compose/runtime/Composer;I)V", "SelectionModeViewsVisibilityEffect", "isSelecting", "(ZLcom/box/android/base/presentation/state/HomeScreenViewsVisibilityState;Landroidx/compose/runtime/Composer;I)V", "browse_generalProdRelease", "state", "isFullyVisible"}, k = 2, mv = {2, 2, 0}, xi = 48)
public final class AllFilesScreenKt {
    private static final ProvidableCompositionLocal<Boolean> LocalFabInitiallyVisible = CompositionLocalKt.staticCompositionLocalOf(new Function0() { // from class: com.box.android.browse.cpl.browse.AllFilesScreenKt$$ExternalSyntheticLambda9
        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() {
            return Boolean.valueOf(AllFilesScreenKt.LocalFabInitiallyVisible$lambda$0());
        }
    });

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit AllFilesContent$lambda$3(Store store, BoxMessageDispatcher boxMessageDispatcher, Modifier modifier, Function4 function4, boolean z, int i, int i2, Composer composer, int i3) {
        AllFilesContent(store, boxMessageDispatcher, modifier, function4, z, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit AllFilesScreen$lambda$5(BrowseNavigator browseNavigator, BoxMessageDispatcher boxMessageDispatcher, SnackbarHostState snackbarHostState, Modifier modifier, HomeScreenViewsVisibilityState homeScreenViewsVisibilityState, boolean z, AllFilesViewModel allFilesViewModel, int i, int i2, Composer composer, int i3) {
        AllFilesScreen(browseNavigator, boxMessageDispatcher, snackbarHostState, modifier, homeScreenViewsVisibilityState, z, allFilesViewModel, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean LocalFabInitiallyVisible$lambda$0() {
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit NavigationRouteEffect$lambda$1(BrowseReducer.Route route, BrowseNavigator browseNavigator, Store store, int i, Composer composer, int i2) {
        NavigationRouteEffect(route, browseNavigator, store, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
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

    public static /* synthetic */ void getLocalFabInitiallyVisible$annotations() {
    }

    public static final ProvidableCompositionLocal<Boolean> getLocalFabInitiallyVisible() {
        return LocalFabInitiallyVisible;
    }

    /* JADX WARN: Code duplicated, block: B:100:0x0179  */
    /* JADX WARN: Code duplicated, block: B:102:0x01ab  */
    /* JADX WARN: Code duplicated, block: B:105:0x01bf  */
    /* JADX WARN: Code duplicated, block: B:108:0x0203  */
    /* JADX WARN: Code duplicated, block: B:109:0x0210  */
    /* JADX WARN: Code duplicated, block: B:112:0x0271  */
    /* JADX WARN: Code duplicated, block: B:115:0x027d  */
    /* JADX WARN: Code duplicated, block: B:116:0x0281  */
    /* JADX WARN: Code duplicated, block: B:119:0x02e3  */
    /* JADX WARN: Code duplicated, block: B:121:0x02eb  */
    /* JADX WARN: Code duplicated, block: B:124:0x031a  */
    /* JADX WARN: Code duplicated, block: B:127:0x0354  */
    /* JADX WARN: Code duplicated, block: B:128:0x0360  */
    /* JADX WARN: Code duplicated, block: B:130:0x0379  */
    /* JADX WARN: Code duplicated, block: B:132:0x039a  */
    /* JADX WARN: Code duplicated, block: B:135:0x03b2  */
    /* JADX WARN: Code duplicated, block: B:138:0x03bb  */
    /* JADX WARN: Code duplicated, block: B:141:0x03d2  */
    /* JADX WARN: Code duplicated, block: B:143:0x03da  */
    /* JADX WARN: Code duplicated, block: B:145:0x03f6  */
    /* JADX WARN: Code duplicated, block: B:149:0x0441  */
    /* JADX WARN: Code duplicated, block: B:151:0x044d  */
    /* JADX WARN: Code duplicated, block: B:154:0x045c  */
    /* JADX WARN: Code duplicated, block: B:156:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:40:0x0080  */
    /* JADX WARN: Code duplicated, block: B:41:0x0083  */
    /* JADX WARN: Code duplicated, block: B:43:0x0087  */
    /* JADX WARN: Code duplicated, block: B:45:0x008f  */
    /* JADX WARN: Code duplicated, block: B:46:0x0092  */
    /* JADX WARN: Code duplicated, block: B:51:0x009e  */
    /* JADX WARN: Code duplicated, block: B:52:0x00a0  */
    /* JADX WARN: Code duplicated, block: B:54:0x00a3  */
    /* JADX WARN: Code duplicated, block: B:56:0x00ab  */
    /* JADX WARN: Code duplicated, block: B:57:0x00ae  */
    /* JADX WARN: Code duplicated, block: B:62:0x00b9  */
    /* JADX WARN: Code duplicated, block: B:64:0x00bd  */
    /* JADX WARN: Code duplicated, block: B:66:0x00c5  */
    /* JADX WARN: Code duplicated, block: B:67:0x00c8  */
    /* JADX WARN: Code duplicated, block: B:70:0x00ce  */
    /* JADX WARN: Code duplicated, block: B:73:0x00dc  */
    /* JADX WARN: Code duplicated, block: B:74:0x00de  */
    /* JADX WARN: Code duplicated, block: B:77:0x00e7  */
    /* JADX WARN: Code duplicated, block: B:79:0x00fc  */
    /* JADX WARN: Code duplicated, block: B:87:0x011a A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:88:0x011c  */
    /* JADX WARN: Code duplicated, block: B:90:0x0123  */
    /* JADX WARN: Code duplicated, block: B:91:0x0125  */
    /* JADX WARN: Code duplicated, block: B:93:0x0128  */
    /* JADX WARN: Code duplicated, block: B:94:0x012a  */
    /* JADX WARN: Code duplicated, block: B:97:0x0130  */
    /* JADX WARN: Code duplicated, block: B:99:0x0171  */
    /* JADX WARN: Type inference failed for: r13v3 */
    /* JADX WARN: Type inference failed for: r9v10 */
    /* JADX WARN: Type inference failed for: r9v11, types: [androidx.compose.runtime.SnapshotMutationPolicy, androidx.compose.ui.input.nestedscroll.NestedScrollDispatcher, java.lang.Object] */
    public static final void AllFilesScreen(final BrowseNavigator navigator, final BoxMessageDispatcher boxMessageDispatcher, final SnackbarHostState snackbarHostState, Modifier modifier, HomeScreenViewsVisibilityState homeScreenViewsVisibilityState, boolean z, AllFilesViewModel allFilesViewModel, Composer composer, final int i, final int i2) {
        int i3;
        Modifier modifier2;
        int i4;
        HomeScreenViewsVisibilityState homeScreenViewsVisibilityState2;
        int i5;
        int i6;
        int i7;
        AllFilesViewModel allFilesViewModel2;
        boolean z2;
        final boolean z3;
        Composer composer2;
        final Modifier modifier3;
        final HomeScreenViewsVisibilityState homeScreenViewsVisibilityState3;
        final AllFilesViewModel allFilesViewModel3;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        ?? r13;
        HomeScreenViewsVisibilityState homeScreenViewsVisibilityState4;
        boolean z4;
        String str;
        int i8;
        Modifier modifier4;
        ComponentActivity componentActivity;
        CreationExtras.Empty defaultViewModelCreationExtras;
        AllFilesViewModel allFilesViewModel4;
        final Store<BrowseReducer.State, BrowseReducer.Action> store;
        State stateCollectAsStateWithLifecycle;
        boolean zBooleanValue;
        Object objRememberedValue;
        int i9;
        final MutableState mutableState;
        Function0<ComposeUiNode> constructor;
        boolean zChanged;
        Object objRememberedValue2;
        AllFilesScreenKt$AllFilesScreen$1$2$1 allFilesScreenKt$AllFilesScreen$1$2$1RememberedValue;
        int i10;
        Composer composer3;
        final FilesFabReducer.State fabMenuState;
        AllFilesScreenKt$AllFilesScreen$1$3$2$1 allFilesScreenKt$AllFilesScreen$1$3$2$1RememberedValue;
        boolean z5;
        boolean zChangedInstance;
        Object objRememberedValue3;
        Intrinsics.checkNotNullParameter(navigator, "navigator");
        Intrinsics.checkNotNullParameter(boxMessageDispatcher, "boxMessageDispatcher");
        Intrinsics.checkNotNullParameter(snackbarHostState, "snackbarHostState");
        Composer composerStartRestartGroup = composer.startRestartGroup(-2014686211);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(AllFilesScreen)N(navigator,boxMessageDispatcher,snackbarHostState,modifier,homeScreenViewsVisibilityState,shouldUseAiCenter,viewModel)51@2504L29,53@2590L7,54@2624L60,57@2709L34,59@2749L1760,102@4515L120,108@4641L179:AllFilesScreen.kt#89mwni");
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
        int i11 = i2 & 8;
        if (i11 == 0) {
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
                        if (composerStartRestartGroup.changed(z)) {
                            i7 = 131072;
                        } else {
                            i7 = 65536;
                        }
                        i3 |= i7;
                    }
                    if ((1572864 & i) == 0) {
                        if ((i2 & 64) == 0) {
                            allFilesViewModel2 = allFilesViewModel;
                            int i12 = composerStartRestartGroup.changedInstance(allFilesViewModel2) ? 1048576 : 524288;
                            i3 |= i12;
                        } else {
                            allFilesViewModel2 = allFilesViewModel;
                        }
                        i3 |= i12;
                    } else {
                        allFilesViewModel2 = allFilesViewModel;
                    }
                    if ((599187 & i3) != 599186) {
                        z2 = true;
                    } else {
                        z2 = false;
                    }
                    if (composerStartRestartGroup.shouldExecute(z2, i3 & 1)) {
                        composerStartRestartGroup.startDefaults();
                        ComposerKt.sourceInformation(composerStartRestartGroup, "48@2415L23");
                        r13 = 0;
                        if ((i & 1) != 0 || composerStartRestartGroup.getDefaultsInvalid()) {
                            if (i11 != 0) {
                                modifier2 = Modifier.INSTANCE;
                            }
                            if (i4 != 0) {
                                homeScreenViewsVisibilityState4 = null;
                            } else {
                                homeScreenViewsVisibilityState4 = homeScreenViewsVisibilityState2;
                            }
                            if (i6 != 0) {
                                z4 = false;
                            } else {
                                z4 = z;
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
                                str = "CC(<get-current>):CompositionLocal.kt#9igjgp";
                                r13 = 0;
                                ViewModel viewModel = ViewModelKt.viewModel((Class<ViewModel>) AllFilesViewModel.class, componentActivity, (String) null, factoryCreateHiltViewModelFactory, defaultViewModelCreationExtras, composerStartRestartGroup, 36936, 0);
                                composerStartRestartGroup = composerStartRestartGroup;
                                composerStartRestartGroup.endReplaceableGroup();
                                composerStartRestartGroup.endReplaceableGroup();
                                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                                Modifier modifier5 = modifier2;
                                i8 = i3 & (-3670017);
                                modifier4 = modifier5;
                                allFilesViewModel4 = (AllFilesViewModel) viewModel;
                            } else {
                                str = "CC(<get-current>):CompositionLocal.kt#9igjgp";
                                Modifier modifier6 = modifier2;
                                i8 = i3;
                                modifier4 = modifier6;
                            }
                            composerStartRestartGroup.endDefaults();
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(-2014686211, i8, -1, "com.box.android.browse.cpl.browse.AllFilesScreen (AllFilesScreen.kt:49)");
                            }
                            store = allFilesViewModel4.getStore();
                            stateCollectAsStateWithLifecycle = FlowExtKt.collectAsStateWithLifecycle(store.getState(), (LifecycleOwner) null, (Lifecycle.State) null, (CoroutineContext) null, composerStartRestartGroup, 0, 7);
                            ProvidableCompositionLocal<Boolean> providableCompositionLocal = LocalFabInitiallyVisible;
                            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, str);
                            Object objConsume2 = composerStartRestartGroup.consume(providableCompositionLocal);
                            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                            zBooleanValue = ((Boolean) objConsume2).booleanValue();
                            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 916818969, "CC(remember):AllFilesScreen.kt#9igjgp");
                            objRememberedValue = composerStartRestartGroup.rememberedValue();
                            if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                                i9 = 2;
                                objRememberedValue = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(Boolean.valueOf(zBooleanValue), r13, 2, r13);
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                            } else {
                                i9 = 2;
                            }
                            mutableState = (MutableState) objRememberedValue;
                            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                            ScrollAwareFabVisibility scrollAwareFabVisibilityRememberScrollAwareFabVisibility = ScrollAwareFabVisibilityKt.rememberScrollAwareFabVisibility(composerStartRestartGroup, 0);
                            Modifier modifierNestedScroll$default = NestedScrollModifierKt.nestedScroll$default(SizeKt.fillMaxSize$default(modifier4, 0.0f, 1, r13), scrollAwareFabVisibilityRememberScrollAwareFabVisibility, r13, i9, r13);
                            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1042775818, "CC(Box)N(modifier,contentAlignment,propagateMinConstraints,content)71@3424L131:Box.kt#2w3rfo");
                            MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), false);
                            Modifier modifier7 = modifier4;
                            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
                            int iHashCode = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
                            CompositionLocalMap currentCompositionLocalMap = composerStartRestartGroup.getCurrentCompositionLocalMap();
                            Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierNestedScroll$default);
                            constructor = ComposeUiNode.INSTANCE.getConstructor();
                            HomeScreenViewsVisibilityState homeScreenViewsVisibilityState5 = homeScreenViewsVisibilityState4;
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
                            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1000030181, "C67@3044L195,73@3270L152,64@2866L617:AllFilesScreen.kt#89mwni");
                            Modifier.Companion companion = Modifier.INSTANCE;
                            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1971917434, "CC(remember):AllFilesScreen.kt#9igjgp");
                            zChanged = composerStartRestartGroup.changed(store);
                            objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                            if (!zChanged || objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                                objRememberedValue2 = new Function1() { // from class: com.box.android.browse.cpl.browse.AllFilesScreenKt$$ExternalSyntheticLambda3
                                    @Override // kotlin.jvm.functions.Function1
                                    public final Object invoke(Object obj) {
                                        return AllFilesScreenKt.AllFilesScreen$lambda$4$0$0(store, mutableState, ((Boolean) obj).booleanValue());
                                    }
                                };
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                            }
                            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                            Modifier modifierOnVisibilityChanged$default = OnVisibilityChangedModifierKt.onVisibilityChanged$default(companion, 0L, 1.0f, null, (Function1) objRememberedValue2, 5, null);
                            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1971910245, "CC(remember):AllFilesScreen.kt#9igjgp");
                            allFilesScreenKt$AllFilesScreen$1$2$1RememberedValue = composerStartRestartGroup.rememberedValue();
                            if (allFilesScreenKt$AllFilesScreen$1$2$1RememberedValue == Composer.INSTANCE.getEmpty()) {
                                allFilesScreenKt$AllFilesScreen$1$2$1RememberedValue = new AllFilesScreenKt$AllFilesScreen$1$2$1(snackbarHostState, null);
                                composerStartRestartGroup.updateRememberedValue(allFilesScreenKt$AllFilesScreen$1$2$1RememberedValue);
                            }
                            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                            i10 = i8 >> 3;
                            composer3 = composerStartRestartGroup;
                            int i13 = i8;
                            AllFilesContent(store, boxMessageDispatcher, modifierOnVisibilityChanged$default, (Function4) allFilesScreenKt$AllFilesScreen$1$2$1RememberedValue, z4, composer3, (BoxMessageDispatcher.$stable << 3) | (i8 & 112) | (57344 & i10), 0);
                            boolean z6 = z4;
                            fabMenuState = AllFilesScreen$lambda$0(stateCollectAsStateWithLifecycle).getFabMenuState();
                            if (fabMenuState == null) {
                                composer3.startReplaceGroup(-999408416);
                                composer3.endReplaceGroup();
                                store = store;
                            } else {
                                composer3.startReplaceGroup(-999408415);
                                ComposerKt.sourceInformation(composer3, "");
                                if (AllFilesScreen$lambda$0(stateCollectAsStateWithLifecycle).getActionableItemsListState().getIsSelecting()) {
                                    composer3.startReplaceGroup(1266836787);
                                } else {
                                    composer3.startReplaceGroup(1270513108);
                                    ComposerKt.sourceInformation(composer3, "85@3850L40,89@4097L364,82@3680L799");
                                    AllFilesScreenKt$AllFilesScreen$1$3$1 allFilesScreenKt$AllFilesScreen$1$3$1 = new PropertyReference1Impl() { // from class: com.box.android.browse.cpl.browse.AllFilesScreenKt$AllFilesScreen$1$3$1
                                        @Override // kotlin.jvm.internal.PropertyReference1Impl, kotlin.reflect.KProperty1
                                        public Object get(Object obj) {
                                            return ((BrowseReducer.State) obj).getFabMenuState();
                                        }
                                    };
                                    ComposerKt.sourceInformationMarkerStart(composer3, 318083639, "CC(remember):AllFilesScreen.kt#9igjgp");
                                    allFilesScreenKt$AllFilesScreen$1$3$2$1RememberedValue = composer3.rememberedValue();
                                    if (allFilesScreenKt$AllFilesScreen$1$3$2$1RememberedValue == Composer.INSTANCE.getEmpty()) {
                                        allFilesScreenKt$AllFilesScreen$1$3$2$1RememberedValue = AllFilesScreenKt$AllFilesScreen$1$3$2$1.INSTANCE;
                                        composer3.updateRememberedValue(allFilesScreenKt$AllFilesScreen$1$3$2$1RememberedValue);
                                    }
                                    ComposerKt.sourceInformationMarkerEnd(composer3);
                                    Store<LocalState, LocalAction> storeIfScope = store.ifScope(allFilesScreenKt$AllFilesScreen$1$3$1, (Function1) ((KFunction) allFilesScreenKt$AllFilesScreen$1$3$2$1RememberedValue));
                                    if (AllFilesScreen$lambda$2(mutableState) || !scrollAwareFabVisibilityRememberScrollAwareFabVisibility.isVisible()) {
                                        z5 = false;
                                    } else {
                                        z5 = true;
                                    }
                                    ComposerKt.sourceInformationMarkerStart(composer3, 318091867, "CC(remember):AllFilesScreen.kt#9igjgp");
                                    zChangedInstance = composer3.changedInstance(navigator) | composer3.changedInstance(fabMenuState);
                                    objRememberedValue3 = composer3.rememberedValue();
                                    if (!zChangedInstance || objRememberedValue3 == Composer.INSTANCE.getEmpty()) {
                                        objRememberedValue3 = new Function1() { // from class: com.box.android.browse.cpl.browse.AllFilesScreenKt$$ExternalSyntheticLambda4
                                            @Override // kotlin.jvm.functions.Function1
                                            public final Object invoke(Object obj) {
                                                return AllFilesScreenKt.AllFilesScreen$lambda$4$2$1$0(navigator, fabMenuState, (String) obj);
                                            }
                                        };
                                        composer3.updateRememberedValue(objRememberedValue3);
                                    }
                                    ComposerKt.sourceInformationMarkerEnd(composer3);
                                    FilesFabComponentKt.FilesFabComponent(storeIfScope, snackbarHostState, (Function1) objRememberedValue3, null, z5, composer3, i10 & 112, 8);
                                }
                                composer3.endReplaceGroup();
                                Unit unit = Unit.INSTANCE;
                                composer3.endReplaceGroup();
                                Unit unit2 = Unit.INSTANCE;
                            }
                            ComposerKt.sourceInformationMarkerEnd(composer3);
                            ComposerKt.sourceInformationMarkerEnd(composer3);
                            composer3.endNode();
                            ComposerKt.sourceInformationMarkerEnd(composer3);
                            ComposerKt.sourceInformationMarkerEnd(composer3);
                            ComposerKt.sourceInformationMarkerEnd(composer3);
                            NavigationRouteEffect(AllFilesScreen$lambda$0(stateCollectAsStateWithLifecycle).getNavigationRoute(), navigator, store, composer3, (i13 << 3) & 112);
                            SelectionModeViewsVisibilityEffect(AllFilesScreen$lambda$0(stateCollectAsStateWithLifecycle).getActionableItemsListState().getIsSelecting(), homeScreenViewsVisibilityState5, composer3, (i13 >> 9) & 112);
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                            homeScreenViewsVisibilityState3 = homeScreenViewsVisibilityState5;
                            composer2 = composer3;
                            modifier3 = modifier7;
                            allFilesViewModel3 = allFilesViewModel4;
                            z3 = z6;
                        } else {
                            composerStartRestartGroup.skipToGroupEnd();
                            if ((i2 & 64) != 0) {
                                i3 &= -3670017;
                            }
                            Modifier modifier8 = modifier2;
                            i8 = i3;
                            modifier4 = modifier8;
                            str = "CC(<get-current>):CompositionLocal.kt#9igjgp";
                            z4 = z;
                            homeScreenViewsVisibilityState4 = homeScreenViewsVisibilityState2;
                        }
                        allFilesViewModel4 = allFilesViewModel2;
                        composerStartRestartGroup.endDefaults();
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-2014686211, i8, -1, "com.box.android.browse.cpl.browse.AllFilesScreen (AllFilesScreen.kt:49)");
                        }
                        store = allFilesViewModel4.getStore();
                        stateCollectAsStateWithLifecycle = FlowExtKt.collectAsStateWithLifecycle(store.getState(), (LifecycleOwner) null, (Lifecycle.State) null, (CoroutineContext) null, composerStartRestartGroup, 0, 7);
                        ProvidableCompositionLocal<Boolean> providableCompositionLocal2 = LocalFabInitiallyVisible;
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, str);
                        Object objConsume3 = composerStartRestartGroup.consume(providableCompositionLocal2);
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        zBooleanValue = ((Boolean) objConsume3).booleanValue();
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 916818969, "CC(remember):AllFilesScreen.kt#9igjgp");
                        objRememberedValue = composerStartRestartGroup.rememberedValue();
                        if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                            i9 = 2;
                            objRememberedValue = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(Boolean.valueOf(zBooleanValue), r13, 2, r13);
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                        } else {
                            i9 = 2;
                        }
                        mutableState = (MutableState) objRememberedValue;
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        ScrollAwareFabVisibility scrollAwareFabVisibilityRememberScrollAwareFabVisibility2 = ScrollAwareFabVisibilityKt.rememberScrollAwareFabVisibility(composerStartRestartGroup, 0);
                        Modifier modifierNestedScroll$default2 = NestedScrollModifierKt.nestedScroll$default(SizeKt.fillMaxSize$default(modifier4, 0.0f, 1, r13), scrollAwareFabVisibilityRememberScrollAwareFabVisibility2, r13, i9, r13);
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1042775818, "CC(Box)N(modifier,contentAlignment,propagateMinConstraints,content)71@3424L131:Box.kt#2w3rfo");
                        MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy2 = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), false);
                        Modifier modifier9 = modifier4;
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
                        int iHashCode2 = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
                        CompositionLocalMap currentCompositionLocalMap2 = composerStartRestartGroup.getCurrentCompositionLocalMap();
                        Modifier modifierMaterializeModifier2 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierNestedScroll$default2);
                        constructor = ComposeUiNode.INSTANCE.getConstructor();
                        HomeScreenViewsVisibilityState homeScreenViewsVisibilityState6 = homeScreenViewsVisibilityState4;
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
                        Composer composerM6062constructorimpl2 = Updater.m6062constructorimpl(composerStartRestartGroup);
                        Updater.m6070setimpl(composerM6062constructorimpl2, measurePolicyMaybeCachedBoxMeasurePolicy2, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                        Updater.m6070setimpl(composerM6062constructorimpl2, currentCompositionLocalMap2, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                        Updater.m6066initimpl(composerM6062constructorimpl2, Integer.valueOf(iHashCode2), ComposeUiNode.INSTANCE.getSetCompositeKeyHash());
                        Updater.m6068reconcileimpl(composerM6062constructorimpl2, ComposeUiNode.INSTANCE.getApplyOnDeactivatedNodeAssertion());
                        Updater.m6070setimpl(composerM6062constructorimpl2, modifierMaterializeModifier2, ComposeUiNode.INSTANCE.getSetModifier());
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1833054614, "C72@3469L9:Box.kt#2w3rfo");
                        BoxScopeInstance boxScopeInstance2 = BoxScopeInstance.INSTANCE;
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1000030181, "C67@3044L195,73@3270L152,64@2866L617:AllFilesScreen.kt#89mwni");
                        Modifier.Companion companion2 = Modifier.INSTANCE;
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1971917434, "CC(remember):AllFilesScreen.kt#9igjgp");
                        zChanged = composerStartRestartGroup.changed(store);
                        objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                        if (!zChanged) {
                            objRememberedValue2 = new Function1() { // from class: com.box.android.browse.cpl.browse.AllFilesScreenKt$$ExternalSyntheticLambda3
                                @Override // kotlin.jvm.functions.Function1
                                public final Object invoke(Object obj) {
                                    return AllFilesScreenKt.AllFilesScreen$lambda$4$0$0(store, mutableState, ((Boolean) obj).booleanValue());
                                }
                            };
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                        } else {
                            objRememberedValue2 = new Function1() { // from class: com.box.android.browse.cpl.browse.AllFilesScreenKt$$ExternalSyntheticLambda3
                                @Override // kotlin.jvm.functions.Function1
                                public final Object invoke(Object obj) {
                                    return AllFilesScreenKt.AllFilesScreen$lambda$4$0$0(store, mutableState, ((Boolean) obj).booleanValue());
                                }
                            };
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                        }
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        Modifier modifierOnVisibilityChanged$default2 = OnVisibilityChangedModifierKt.onVisibilityChanged$default(companion2, 0L, 1.0f, null, (Function1) objRememberedValue2, 5, null);
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1971910245, "CC(remember):AllFilesScreen.kt#9igjgp");
                        allFilesScreenKt$AllFilesScreen$1$2$1RememberedValue = composerStartRestartGroup.rememberedValue();
                        if (allFilesScreenKt$AllFilesScreen$1$2$1RememberedValue == Composer.INSTANCE.getEmpty()) {
                            allFilesScreenKt$AllFilesScreen$1$2$1RememberedValue = new AllFilesScreenKt$AllFilesScreen$1$2$1(snackbarHostState, null);
                            composerStartRestartGroup.updateRememberedValue(allFilesScreenKt$AllFilesScreen$1$2$1RememberedValue);
                        }
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        i10 = i8 >> 3;
                        composer3 = composerStartRestartGroup;
                        int i14 = i8;
                        AllFilesContent(store, boxMessageDispatcher, modifierOnVisibilityChanged$default2, (Function4) allFilesScreenKt$AllFilesScreen$1$2$1RememberedValue, z4, composer3, (BoxMessageDispatcher.$stable << 3) | (i8 & 112) | (57344 & i10), 0);
                        boolean z7 = z4;
                        fabMenuState = AllFilesScreen$lambda$0(stateCollectAsStateWithLifecycle).getFabMenuState();
                        if (fabMenuState == null) {
                            composer3.startReplaceGroup(-999408416);
                            composer3.endReplaceGroup();
                            store = store;
                        } else {
                            composer3.startReplaceGroup(-999408415);
                            ComposerKt.sourceInformation(composer3, "");
                            if (AllFilesScreen$lambda$0(stateCollectAsStateWithLifecycle).getActionableItemsListState().getIsSelecting()) {
                                composer3.startReplaceGroup(1270513108);
                                ComposerKt.sourceInformation(composer3, "85@3850L40,89@4097L364,82@3680L799");
                                AllFilesScreenKt$AllFilesScreen$1$3$1 allFilesScreenKt$AllFilesScreen$1$3$2 = new PropertyReference1Impl() { // from class: com.box.android.browse.cpl.browse.AllFilesScreenKt$AllFilesScreen$1$3$1
                                    @Override // kotlin.jvm.internal.PropertyReference1Impl, kotlin.reflect.KProperty1
                                    public Object get(Object obj) {
                                        return ((BrowseReducer.State) obj).getFabMenuState();
                                    }
                                };
                                ComposerKt.sourceInformationMarkerStart(composer3, 318083639, "CC(remember):AllFilesScreen.kt#9igjgp");
                                allFilesScreenKt$AllFilesScreen$1$3$2$1RememberedValue = composer3.rememberedValue();
                                if (allFilesScreenKt$AllFilesScreen$1$3$2$1RememberedValue == Composer.INSTANCE.getEmpty()) {
                                    allFilesScreenKt$AllFilesScreen$1$3$2$1RememberedValue = AllFilesScreenKt$AllFilesScreen$1$3$2$1.INSTANCE;
                                    composer3.updateRememberedValue(allFilesScreenKt$AllFilesScreen$1$3$2$1RememberedValue);
                                }
                                ComposerKt.sourceInformationMarkerEnd(composer3);
                                Store<LocalState, LocalAction> storeIfScope2 = store.ifScope(allFilesScreenKt$AllFilesScreen$1$3$2, (Function1) ((KFunction) allFilesScreenKt$AllFilesScreen$1$3$2$1RememberedValue));
                                if (AllFilesScreen$lambda$2(mutableState)) {
                                    z5 = false;
                                } else {
                                    z5 = false;
                                }
                                ComposerKt.sourceInformationMarkerStart(composer3, 318091867, "CC(remember):AllFilesScreen.kt#9igjgp");
                                zChangedInstance = composer3.changedInstance(navigator) | composer3.changedInstance(fabMenuState);
                                objRememberedValue3 = composer3.rememberedValue();
                                if (!zChangedInstance) {
                                    objRememberedValue3 = new Function1() { // from class: com.box.android.browse.cpl.browse.AllFilesScreenKt$$ExternalSyntheticLambda4
                                        @Override // kotlin.jvm.functions.Function1
                                        public final Object invoke(Object obj) {
                                            return AllFilesScreenKt.AllFilesScreen$lambda$4$2$1$0(navigator, fabMenuState, (String) obj);
                                        }
                                    };
                                    composer3.updateRememberedValue(objRememberedValue3);
                                } else {
                                    objRememberedValue3 = new Function1() { // from class: com.box.android.browse.cpl.browse.AllFilesScreenKt$$ExternalSyntheticLambda4
                                        @Override // kotlin.jvm.functions.Function1
                                        public final Object invoke(Object obj) {
                                            return AllFilesScreenKt.AllFilesScreen$lambda$4$2$1$0(navigator, fabMenuState, (String) obj);
                                        }
                                    };
                                    composer3.updateRememberedValue(objRememberedValue3);
                                }
                                ComposerKt.sourceInformationMarkerEnd(composer3);
                                FilesFabComponentKt.FilesFabComponent(storeIfScope2, snackbarHostState, (Function1) objRememberedValue3, null, z5, composer3, i10 & 112, 8);
                            } else {
                                composer3.startReplaceGroup(1266836787);
                            }
                            composer3.endReplaceGroup();
                            Unit unit3 = Unit.INSTANCE;
                            composer3.endReplaceGroup();
                            Unit unit4 = Unit.INSTANCE;
                        }
                        ComposerKt.sourceInformationMarkerEnd(composer3);
                        ComposerKt.sourceInformationMarkerEnd(composer3);
                        composer3.endNode();
                        ComposerKt.sourceInformationMarkerEnd(composer3);
                        ComposerKt.sourceInformationMarkerEnd(composer3);
                        ComposerKt.sourceInformationMarkerEnd(composer3);
                        NavigationRouteEffect(AllFilesScreen$lambda$0(stateCollectAsStateWithLifecycle).getNavigationRoute(), navigator, store, composer3, (i14 << 3) & 112);
                        SelectionModeViewsVisibilityEffect(AllFilesScreen$lambda$0(stateCollectAsStateWithLifecycle).getActionableItemsListState().getIsSelecting(), homeScreenViewsVisibilityState6, composer3, (i14 >> 9) & 112);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        homeScreenViewsVisibilityState3 = homeScreenViewsVisibilityState6;
                        composer2 = composer3;
                        modifier3 = modifier9;
                        allFilesViewModel3 = allFilesViewModel4;
                        z3 = z7;
                    } else {
                        composerStartRestartGroup.skipToGroupEnd();
                        z3 = z;
                        composer2 = composerStartRestartGroup;
                        modifier3 = modifier2;
                        homeScreenViewsVisibilityState3 = homeScreenViewsVisibilityState2;
                        allFilesViewModel3 = allFilesViewModel2;
                    }
                    scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup != null) {
                        scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.box.android.browse.cpl.browse.AllFilesScreenKt$$ExternalSyntheticLambda5
                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj, Object obj2) {
                                return AllFilesScreenKt.AllFilesScreen$lambda$5(navigator, boxMessageDispatcher, snackbarHostState, modifier3, homeScreenViewsVisibilityState3, z3, allFilesViewModel3, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                            }
                        });
                    }
                }
                i3 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
                if ((1572864 & i) == 0) {
                    if ((i2 & 64) == 0) {
                        allFilesViewModel2 = allFilesViewModel;
                        if (composerStartRestartGroup.changedInstance(allFilesViewModel2)) {
                        }
                        i3 |= i12;
                    } else {
                        allFilesViewModel2 = allFilesViewModel;
                    }
                    i3 |= i12;
                } else {
                    allFilesViewModel2 = allFilesViewModel;
                }
                if ((599187 & i3) != 599186) {
                    z2 = true;
                } else {
                    z2 = false;
                }
                if (composerStartRestartGroup.shouldExecute(z2, i3 & 1)) {
                    composerStartRestartGroup.startDefaults();
                    ComposerKt.sourceInformation(composerStartRestartGroup, "48@2415L23");
                    r13 = 0;
                    if ((i & 1) != 0) {
                        if (i11 != 0) {
                            modifier2 = Modifier.INSTANCE;
                        }
                        if (i4 != 0) {
                            homeScreenViewsVisibilityState4 = null;
                        } else {
                            homeScreenViewsVisibilityState4 = homeScreenViewsVisibilityState2;
                        }
                        if (i6 != 0) {
                            z4 = false;
                        } else {
                            z4 = z;
                        }
                        if ((i2 & 64) != 0) {
                            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1447482489, "CC(hiltActivityViewModel)N(key)159@5773L7,160@5813L56:ComposeUtils.kt#vejmn0");
                            ProvidableCompositionLocal<Activity> localActivity2 = LocalActivityKt.getLocalActivity();
                            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
                            Object objConsume4 = composerStartRestartGroup.consume(localActivity2);
                            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                            Intrinsics.checkNotNull(objConsume4, "null cannot be cast to non-null type androidx.activity.ComponentActivity");
                            componentActivity = (ComponentActivity) objConsume4;
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
                            str = "CC(<get-current>):CompositionLocal.kt#9igjgp";
                            r13 = 0;
                            ViewModel viewModel2 = ViewModelKt.viewModel((Class<ViewModel>) AllFilesViewModel.class, componentActivity, (String) null, factoryCreateHiltViewModelFactory2, defaultViewModelCreationExtras, composerStartRestartGroup, 36936, 0);
                            composerStartRestartGroup = composerStartRestartGroup;
                            composerStartRestartGroup.endReplaceableGroup();
                            composerStartRestartGroup.endReplaceableGroup();
                            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                            Modifier modifier10 = modifier2;
                            i8 = i3 & (-3670017);
                            modifier4 = modifier10;
                            allFilesViewModel4 = (AllFilesViewModel) viewModel2;
                        } else {
                            str = "CC(<get-current>):CompositionLocal.kt#9igjgp";
                            Modifier modifier11 = modifier2;
                            i8 = i3;
                            modifier4 = modifier11;
                            allFilesViewModel4 = allFilesViewModel2;
                        }
                    } else {
                        if (i11 != 0) {
                            modifier2 = Modifier.INSTANCE;
                        }
                        if (i4 != 0) {
                            homeScreenViewsVisibilityState4 = null;
                        } else {
                            homeScreenViewsVisibilityState4 = homeScreenViewsVisibilityState2;
                        }
                        if (i6 != 0) {
                            z4 = false;
                        } else {
                            z4 = z;
                        }
                        if ((i2 & 64) != 0) {
                            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1447482489, "CC(hiltActivityViewModel)N(key)159@5773L7,160@5813L56:ComposeUtils.kt#vejmn0");
                            ProvidableCompositionLocal<Activity> localActivity3 = LocalActivityKt.getLocalActivity();
                            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
                            Object objConsume5 = composerStartRestartGroup.consume(localActivity3);
                            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                            Intrinsics.checkNotNull(objConsume5, "null cannot be cast to non-null type androidx.activity.ComponentActivity");
                            componentActivity = (ComponentActivity) objConsume5;
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
                            str = "CC(<get-current>):CompositionLocal.kt#9igjgp";
                            r13 = 0;
                            ViewModel viewModel3 = ViewModelKt.viewModel((Class<ViewModel>) AllFilesViewModel.class, componentActivity, (String) null, factoryCreateHiltViewModelFactory3, defaultViewModelCreationExtras, composerStartRestartGroup, 36936, 0);
                            composerStartRestartGroup = composerStartRestartGroup;
                            composerStartRestartGroup.endReplaceableGroup();
                            composerStartRestartGroup.endReplaceableGroup();
                            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                            Modifier modifier12 = modifier2;
                            i8 = i3 & (-3670017);
                            modifier4 = modifier12;
                            allFilesViewModel4 = (AllFilesViewModel) viewModel3;
                        } else {
                            str = "CC(<get-current>):CompositionLocal.kt#9igjgp";
                            Modifier modifier13 = modifier2;
                            i8 = i3;
                            modifier4 = modifier13;
                            allFilesViewModel4 = allFilesViewModel2;
                        }
                    }
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-2014686211, i8, -1, "com.box.android.browse.cpl.browse.AllFilesScreen (AllFilesScreen.kt:49)");
                    }
                    store = allFilesViewModel4.getStore();
                    stateCollectAsStateWithLifecycle = FlowExtKt.collectAsStateWithLifecycle(store.getState(), (LifecycleOwner) null, (Lifecycle.State) null, (CoroutineContext) null, composerStartRestartGroup, 0, 7);
                    ProvidableCompositionLocal<Boolean> providableCompositionLocal3 = LocalFabInitiallyVisible;
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, str);
                    Object objConsume6 = composerStartRestartGroup.consume(providableCompositionLocal3);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    zBooleanValue = ((Boolean) objConsume6).booleanValue();
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 916818969, "CC(remember):AllFilesScreen.kt#9igjgp");
                    objRememberedValue = composerStartRestartGroup.rememberedValue();
                    if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                        i9 = 2;
                        objRememberedValue = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(Boolean.valueOf(zBooleanValue), r13, 2, r13);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                    } else {
                        i9 = 2;
                    }
                    mutableState = (MutableState) objRememberedValue;
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    ScrollAwareFabVisibility scrollAwareFabVisibilityRememberScrollAwareFabVisibility3 = ScrollAwareFabVisibilityKt.rememberScrollAwareFabVisibility(composerStartRestartGroup, 0);
                    Modifier modifierNestedScroll$default3 = NestedScrollModifierKt.nestedScroll$default(SizeKt.fillMaxSize$default(modifier4, 0.0f, 1, r13), scrollAwareFabVisibilityRememberScrollAwareFabVisibility3, r13, i9, r13);
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1042775818, "CC(Box)N(modifier,contentAlignment,propagateMinConstraints,content)71@3424L131:Box.kt#2w3rfo");
                    MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy3 = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), false);
                    Modifier modifier14 = modifier4;
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
                    int iHashCode3 = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
                    CompositionLocalMap currentCompositionLocalMap3 = composerStartRestartGroup.getCurrentCompositionLocalMap();
                    Modifier modifierMaterializeModifier3 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierNestedScroll$default3);
                    constructor = ComposeUiNode.INSTANCE.getConstructor();
                    HomeScreenViewsVisibilityState homeScreenViewsVisibilityState7 = homeScreenViewsVisibilityState4;
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
                    Composer composerM6062constructorimpl3 = Updater.m6062constructorimpl(composerStartRestartGroup);
                    Updater.m6070setimpl(composerM6062constructorimpl3, measurePolicyMaybeCachedBoxMeasurePolicy3, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                    Updater.m6070setimpl(composerM6062constructorimpl3, currentCompositionLocalMap3, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                    Updater.m6066initimpl(composerM6062constructorimpl3, Integer.valueOf(iHashCode3), ComposeUiNode.INSTANCE.getSetCompositeKeyHash());
                    Updater.m6068reconcileimpl(composerM6062constructorimpl3, ComposeUiNode.INSTANCE.getApplyOnDeactivatedNodeAssertion());
                    Updater.m6070setimpl(composerM6062constructorimpl3, modifierMaterializeModifier3, ComposeUiNode.INSTANCE.getSetModifier());
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1833054614, "C72@3469L9:Box.kt#2w3rfo");
                    BoxScopeInstance boxScopeInstance3 = BoxScopeInstance.INSTANCE;
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1000030181, "C67@3044L195,73@3270L152,64@2866L617:AllFilesScreen.kt#89mwni");
                    Modifier.Companion companion3 = Modifier.INSTANCE;
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1971917434, "CC(remember):AllFilesScreen.kt#9igjgp");
                    zChanged = composerStartRestartGroup.changed(store);
                    objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                    if (!zChanged) {
                        objRememberedValue2 = new Function1() { // from class: com.box.android.browse.cpl.browse.AllFilesScreenKt$$ExternalSyntheticLambda3
                            @Override // kotlin.jvm.functions.Function1
                            public final Object invoke(Object obj) {
                                return AllFilesScreenKt.AllFilesScreen$lambda$4$0$0(store, mutableState, ((Boolean) obj).booleanValue());
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                    } else {
                        objRememberedValue2 = new Function1() { // from class: com.box.android.browse.cpl.browse.AllFilesScreenKt$$ExternalSyntheticLambda3
                            @Override // kotlin.jvm.functions.Function1
                            public final Object invoke(Object obj) {
                                return AllFilesScreenKt.AllFilesScreen$lambda$4$0$0(store, mutableState, ((Boolean) obj).booleanValue());
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                    }
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    Modifier modifierOnVisibilityChanged$default3 = OnVisibilityChangedModifierKt.onVisibilityChanged$default(companion3, 0L, 1.0f, null, (Function1) objRememberedValue2, 5, null);
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1971910245, "CC(remember):AllFilesScreen.kt#9igjgp");
                    allFilesScreenKt$AllFilesScreen$1$2$1RememberedValue = composerStartRestartGroup.rememberedValue();
                    if (allFilesScreenKt$AllFilesScreen$1$2$1RememberedValue == Composer.INSTANCE.getEmpty()) {
                        allFilesScreenKt$AllFilesScreen$1$2$1RememberedValue = new AllFilesScreenKt$AllFilesScreen$1$2$1(snackbarHostState, null);
                        composerStartRestartGroup.updateRememberedValue(allFilesScreenKt$AllFilesScreen$1$2$1RememberedValue);
                    }
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    i10 = i8 >> 3;
                    composer3 = composerStartRestartGroup;
                    int i15 = i8;
                    AllFilesContent(store, boxMessageDispatcher, modifierOnVisibilityChanged$default3, (Function4) allFilesScreenKt$AllFilesScreen$1$2$1RememberedValue, z4, composer3, (BoxMessageDispatcher.$stable << 3) | (i8 & 112) | (57344 & i10), 0);
                    boolean z8 = z4;
                    fabMenuState = AllFilesScreen$lambda$0(stateCollectAsStateWithLifecycle).getFabMenuState();
                    if (fabMenuState == null) {
                        composer3.startReplaceGroup(-999408416);
                        composer3.endReplaceGroup();
                        store = store;
                    } else {
                        composer3.startReplaceGroup(-999408415);
                        ComposerKt.sourceInformation(composer3, "");
                        if (AllFilesScreen$lambda$0(stateCollectAsStateWithLifecycle).getActionableItemsListState().getIsSelecting()) {
                            composer3.startReplaceGroup(1270513108);
                            ComposerKt.sourceInformation(composer3, "85@3850L40,89@4097L364,82@3680L799");
                            AllFilesScreenKt$AllFilesScreen$1$3$1 allFilesScreenKt$AllFilesScreen$1$3$3 = new PropertyReference1Impl() { // from class: com.box.android.browse.cpl.browse.AllFilesScreenKt$AllFilesScreen$1$3$1
                                @Override // kotlin.jvm.internal.PropertyReference1Impl, kotlin.reflect.KProperty1
                                public Object get(Object obj) {
                                    return ((BrowseReducer.State) obj).getFabMenuState();
                                }
                            };
                            ComposerKt.sourceInformationMarkerStart(composer3, 318083639, "CC(remember):AllFilesScreen.kt#9igjgp");
                            allFilesScreenKt$AllFilesScreen$1$3$2$1RememberedValue = composer3.rememberedValue();
                            if (allFilesScreenKt$AllFilesScreen$1$3$2$1RememberedValue == Composer.INSTANCE.getEmpty()) {
                                allFilesScreenKt$AllFilesScreen$1$3$2$1RememberedValue = AllFilesScreenKt$AllFilesScreen$1$3$2$1.INSTANCE;
                                composer3.updateRememberedValue(allFilesScreenKt$AllFilesScreen$1$3$2$1RememberedValue);
                            }
                            ComposerKt.sourceInformationMarkerEnd(composer3);
                            Store<LocalState, LocalAction> storeIfScope3 = store.ifScope(allFilesScreenKt$AllFilesScreen$1$3$3, (Function1) ((KFunction) allFilesScreenKt$AllFilesScreen$1$3$2$1RememberedValue));
                            if (AllFilesScreen$lambda$2(mutableState)) {
                                z5 = false;
                            } else {
                                z5 = false;
                            }
                            ComposerKt.sourceInformationMarkerStart(composer3, 318091867, "CC(remember):AllFilesScreen.kt#9igjgp");
                            zChangedInstance = composer3.changedInstance(navigator) | composer3.changedInstance(fabMenuState);
                            objRememberedValue3 = composer3.rememberedValue();
                            if (!zChangedInstance) {
                                objRememberedValue3 = new Function1() { // from class: com.box.android.browse.cpl.browse.AllFilesScreenKt$$ExternalSyntheticLambda4
                                    @Override // kotlin.jvm.functions.Function1
                                    public final Object invoke(Object obj) {
                                        return AllFilesScreenKt.AllFilesScreen$lambda$4$2$1$0(navigator, fabMenuState, (String) obj);
                                    }
                                };
                                composer3.updateRememberedValue(objRememberedValue3);
                            } else {
                                objRememberedValue3 = new Function1() { // from class: com.box.android.browse.cpl.browse.AllFilesScreenKt$$ExternalSyntheticLambda4
                                    @Override // kotlin.jvm.functions.Function1
                                    public final Object invoke(Object obj) {
                                        return AllFilesScreenKt.AllFilesScreen$lambda$4$2$1$0(navigator, fabMenuState, (String) obj);
                                    }
                                };
                                composer3.updateRememberedValue(objRememberedValue3);
                            }
                            ComposerKt.sourceInformationMarkerEnd(composer3);
                            FilesFabComponentKt.FilesFabComponent(storeIfScope3, snackbarHostState, (Function1) objRememberedValue3, null, z5, composer3, i10 & 112, 8);
                        } else {
                            composer3.startReplaceGroup(1266836787);
                        }
                        composer3.endReplaceGroup();
                        Unit unit5 = Unit.INSTANCE;
                        composer3.endReplaceGroup();
                        Unit unit6 = Unit.INSTANCE;
                    }
                    ComposerKt.sourceInformationMarkerEnd(composer3);
                    ComposerKt.sourceInformationMarkerEnd(composer3);
                    composer3.endNode();
                    ComposerKt.sourceInformationMarkerEnd(composer3);
                    ComposerKt.sourceInformationMarkerEnd(composer3);
                    ComposerKt.sourceInformationMarkerEnd(composer3);
                    NavigationRouteEffect(AllFilesScreen$lambda$0(stateCollectAsStateWithLifecycle).getNavigationRoute(), navigator, store, composer3, (i15 << 3) & 112);
                    SelectionModeViewsVisibilityEffect(AllFilesScreen$lambda$0(stateCollectAsStateWithLifecycle).getActionableItemsListState().getIsSelecting(), homeScreenViewsVisibilityState7, composer3, (i15 >> 9) & 112);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    homeScreenViewsVisibilityState3 = homeScreenViewsVisibilityState7;
                    composer2 = composer3;
                    modifier3 = modifier14;
                    allFilesViewModel3 = allFilesViewModel4;
                    z3 = z8;
                } else {
                    composerStartRestartGroup.skipToGroupEnd();
                    z3 = z;
                    composer2 = composerStartRestartGroup;
                    modifier3 = modifier2;
                    homeScreenViewsVisibilityState3 = homeScreenViewsVisibilityState2;
                    allFilesViewModel3 = allFilesViewModel2;
                }
                scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.box.android.browse.cpl.browse.AllFilesScreenKt$$ExternalSyntheticLambda5
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return AllFilesScreenKt.AllFilesScreen$lambda$5(navigator, boxMessageDispatcher, snackbarHostState, modifier3, homeScreenViewsVisibilityState3, z3, allFilesViewModel3, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    });
                }
            }
            i3 |= 24576;
            homeScreenViewsVisibilityState2 = homeScreenViewsVisibilityState;
            i6 = i2 & 32;
            if (i6 != 0) {
                if ((196608 & i) == 0) {
                    if (composerStartRestartGroup.changed(z)) {
                        i7 = 131072;
                    } else {
                        i7 = 65536;
                    }
                    i3 |= i7;
                }
                if ((1572864 & i) == 0) {
                    if ((i2 & 64) == 0) {
                        allFilesViewModel2 = allFilesViewModel;
                        if (composerStartRestartGroup.changedInstance(allFilesViewModel2)) {
                        }
                        i3 |= i12;
                    } else {
                        allFilesViewModel2 = allFilesViewModel;
                    }
                    i3 |= i12;
                } else {
                    allFilesViewModel2 = allFilesViewModel;
                }
                if ((599187 & i3) != 599186) {
                    z2 = true;
                } else {
                    z2 = false;
                }
                if (composerStartRestartGroup.shouldExecute(z2, i3 & 1)) {
                    composerStartRestartGroup.startDefaults();
                    ComposerKt.sourceInformation(composerStartRestartGroup, "48@2415L23");
                    r13 = 0;
                    if ((i & 1) != 0) {
                        if (i11 != 0) {
                            modifier2 = Modifier.INSTANCE;
                        }
                        if (i4 != 0) {
                            homeScreenViewsVisibilityState4 = null;
                        } else {
                            homeScreenViewsVisibilityState4 = homeScreenViewsVisibilityState2;
                        }
                        if (i6 != 0) {
                            z4 = false;
                        } else {
                            z4 = z;
                        }
                        if ((i2 & 64) != 0) {
                            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1447482489, "CC(hiltActivityViewModel)N(key)159@5773L7,160@5813L56:ComposeUtils.kt#vejmn0");
                            ProvidableCompositionLocal<Activity> localActivity4 = LocalActivityKt.getLocalActivity();
                            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
                            Object objConsume7 = composerStartRestartGroup.consume(localActivity4);
                            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                            Intrinsics.checkNotNull(objConsume7, "null cannot be cast to non-null type androidx.activity.ComponentActivity");
                            componentActivity = (ComponentActivity) objConsume7;
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
                            str = "CC(<get-current>):CompositionLocal.kt#9igjgp";
                            r13 = 0;
                            ViewModel viewModel4 = ViewModelKt.viewModel((Class<ViewModel>) AllFilesViewModel.class, componentActivity, (String) null, factoryCreateHiltViewModelFactory4, defaultViewModelCreationExtras, composerStartRestartGroup, 36936, 0);
                            composerStartRestartGroup = composerStartRestartGroup;
                            composerStartRestartGroup.endReplaceableGroup();
                            composerStartRestartGroup.endReplaceableGroup();
                            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                            Modifier modifier15 = modifier2;
                            i8 = i3 & (-3670017);
                            modifier4 = modifier15;
                            allFilesViewModel4 = (AllFilesViewModel) viewModel4;
                        } else {
                            str = "CC(<get-current>):CompositionLocal.kt#9igjgp";
                            Modifier modifier16 = modifier2;
                            i8 = i3;
                            modifier4 = modifier16;
                            allFilesViewModel4 = allFilesViewModel2;
                        }
                    } else {
                        if (i11 != 0) {
                            modifier2 = Modifier.INSTANCE;
                        }
                        if (i4 != 0) {
                            homeScreenViewsVisibilityState4 = null;
                        } else {
                            homeScreenViewsVisibilityState4 = homeScreenViewsVisibilityState2;
                        }
                        if (i6 != 0) {
                            z4 = false;
                        } else {
                            z4 = z;
                        }
                        if ((i2 & 64) != 0) {
                            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1447482489, "CC(hiltActivityViewModel)N(key)159@5773L7,160@5813L56:ComposeUtils.kt#vejmn0");
                            ProvidableCompositionLocal<Activity> localActivity5 = LocalActivityKt.getLocalActivity();
                            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
                            Object objConsume8 = composerStartRestartGroup.consume(localActivity5);
                            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                            Intrinsics.checkNotNull(objConsume8, "null cannot be cast to non-null type androidx.activity.ComponentActivity");
                            componentActivity = (ComponentActivity) objConsume8;
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
                            str = "CC(<get-current>):CompositionLocal.kt#9igjgp";
                            r13 = 0;
                            ViewModel viewModel5 = ViewModelKt.viewModel((Class<ViewModel>) AllFilesViewModel.class, componentActivity, (String) null, factoryCreateHiltViewModelFactory5, defaultViewModelCreationExtras, composerStartRestartGroup, 36936, 0);
                            composerStartRestartGroup = composerStartRestartGroup;
                            composerStartRestartGroup.endReplaceableGroup();
                            composerStartRestartGroup.endReplaceableGroup();
                            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                            Modifier modifier17 = modifier2;
                            i8 = i3 & (-3670017);
                            modifier4 = modifier17;
                            allFilesViewModel4 = (AllFilesViewModel) viewModel5;
                        } else {
                            str = "CC(<get-current>):CompositionLocal.kt#9igjgp";
                            Modifier modifier18 = modifier2;
                            i8 = i3;
                            modifier4 = modifier18;
                            allFilesViewModel4 = allFilesViewModel2;
                        }
                    }
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-2014686211, i8, -1, "com.box.android.browse.cpl.browse.AllFilesScreen (AllFilesScreen.kt:49)");
                    }
                    store = allFilesViewModel4.getStore();
                    stateCollectAsStateWithLifecycle = FlowExtKt.collectAsStateWithLifecycle(store.getState(), (LifecycleOwner) null, (Lifecycle.State) null, (CoroutineContext) null, composerStartRestartGroup, 0, 7);
                    ProvidableCompositionLocal<Boolean> providableCompositionLocal4 = LocalFabInitiallyVisible;
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, str);
                    Object objConsume9 = composerStartRestartGroup.consume(providableCompositionLocal4);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    zBooleanValue = ((Boolean) objConsume9).booleanValue();
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 916818969, "CC(remember):AllFilesScreen.kt#9igjgp");
                    objRememberedValue = composerStartRestartGroup.rememberedValue();
                    if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                        i9 = 2;
                        objRememberedValue = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(Boolean.valueOf(zBooleanValue), r13, 2, r13);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                    } else {
                        i9 = 2;
                    }
                    mutableState = (MutableState) objRememberedValue;
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    ScrollAwareFabVisibility scrollAwareFabVisibilityRememberScrollAwareFabVisibility4 = ScrollAwareFabVisibilityKt.rememberScrollAwareFabVisibility(composerStartRestartGroup, 0);
                    Modifier modifierNestedScroll$default4 = NestedScrollModifierKt.nestedScroll$default(SizeKt.fillMaxSize$default(modifier4, 0.0f, 1, r13), scrollAwareFabVisibilityRememberScrollAwareFabVisibility4, r13, i9, r13);
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1042775818, "CC(Box)N(modifier,contentAlignment,propagateMinConstraints,content)71@3424L131:Box.kt#2w3rfo");
                    MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy4 = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), false);
                    Modifier modifier19 = modifier4;
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
                    int iHashCode4 = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
                    CompositionLocalMap currentCompositionLocalMap4 = composerStartRestartGroup.getCurrentCompositionLocalMap();
                    Modifier modifierMaterializeModifier4 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierNestedScroll$default4);
                    constructor = ComposeUiNode.INSTANCE.getConstructor();
                    HomeScreenViewsVisibilityState homeScreenViewsVisibilityState8 = homeScreenViewsVisibilityState4;
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
                    Composer composerM6062constructorimpl4 = Updater.m6062constructorimpl(composerStartRestartGroup);
                    Updater.m6070setimpl(composerM6062constructorimpl4, measurePolicyMaybeCachedBoxMeasurePolicy4, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                    Updater.m6070setimpl(composerM6062constructorimpl4, currentCompositionLocalMap4, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                    Updater.m6066initimpl(composerM6062constructorimpl4, Integer.valueOf(iHashCode4), ComposeUiNode.INSTANCE.getSetCompositeKeyHash());
                    Updater.m6068reconcileimpl(composerM6062constructorimpl4, ComposeUiNode.INSTANCE.getApplyOnDeactivatedNodeAssertion());
                    Updater.m6070setimpl(composerM6062constructorimpl4, modifierMaterializeModifier4, ComposeUiNode.INSTANCE.getSetModifier());
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1833054614, "C72@3469L9:Box.kt#2w3rfo");
                    BoxScopeInstance boxScopeInstance4 = BoxScopeInstance.INSTANCE;
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1000030181, "C67@3044L195,73@3270L152,64@2866L617:AllFilesScreen.kt#89mwni");
                    Modifier.Companion companion4 = Modifier.INSTANCE;
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1971917434, "CC(remember):AllFilesScreen.kt#9igjgp");
                    zChanged = composerStartRestartGroup.changed(store);
                    objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                    if (!zChanged) {
                        objRememberedValue2 = new Function1() { // from class: com.box.android.browse.cpl.browse.AllFilesScreenKt$$ExternalSyntheticLambda3
                            @Override // kotlin.jvm.functions.Function1
                            public final Object invoke(Object obj) {
                                return AllFilesScreenKt.AllFilesScreen$lambda$4$0$0(store, mutableState, ((Boolean) obj).booleanValue());
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                    } else {
                        objRememberedValue2 = new Function1() { // from class: com.box.android.browse.cpl.browse.AllFilesScreenKt$$ExternalSyntheticLambda3
                            @Override // kotlin.jvm.functions.Function1
                            public final Object invoke(Object obj) {
                                return AllFilesScreenKt.AllFilesScreen$lambda$4$0$0(store, mutableState, ((Boolean) obj).booleanValue());
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                    }
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    Modifier modifierOnVisibilityChanged$default4 = OnVisibilityChangedModifierKt.onVisibilityChanged$default(companion4, 0L, 1.0f, null, (Function1) objRememberedValue2, 5, null);
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1971910245, "CC(remember):AllFilesScreen.kt#9igjgp");
                    allFilesScreenKt$AllFilesScreen$1$2$1RememberedValue = composerStartRestartGroup.rememberedValue();
                    if (allFilesScreenKt$AllFilesScreen$1$2$1RememberedValue == Composer.INSTANCE.getEmpty()) {
                        allFilesScreenKt$AllFilesScreen$1$2$1RememberedValue = new AllFilesScreenKt$AllFilesScreen$1$2$1(snackbarHostState, null);
                        composerStartRestartGroup.updateRememberedValue(allFilesScreenKt$AllFilesScreen$1$2$1RememberedValue);
                    }
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    i10 = i8 >> 3;
                    composer3 = composerStartRestartGroup;
                    int i16 = i8;
                    AllFilesContent(store, boxMessageDispatcher, modifierOnVisibilityChanged$default4, (Function4) allFilesScreenKt$AllFilesScreen$1$2$1RememberedValue, z4, composer3, (BoxMessageDispatcher.$stable << 3) | (i8 & 112) | (57344 & i10), 0);
                    boolean z9 = z4;
                    fabMenuState = AllFilesScreen$lambda$0(stateCollectAsStateWithLifecycle).getFabMenuState();
                    if (fabMenuState == null) {
                        composer3.startReplaceGroup(-999408416);
                        composer3.endReplaceGroup();
                        store = store;
                    } else {
                        composer3.startReplaceGroup(-999408415);
                        ComposerKt.sourceInformation(composer3, "");
                        if (AllFilesScreen$lambda$0(stateCollectAsStateWithLifecycle).getActionableItemsListState().getIsSelecting()) {
                            composer3.startReplaceGroup(1270513108);
                            ComposerKt.sourceInformation(composer3, "85@3850L40,89@4097L364,82@3680L799");
                            AllFilesScreenKt$AllFilesScreen$1$3$1 allFilesScreenKt$AllFilesScreen$1$3$4 = new PropertyReference1Impl() { // from class: com.box.android.browse.cpl.browse.AllFilesScreenKt$AllFilesScreen$1$3$1
                                @Override // kotlin.jvm.internal.PropertyReference1Impl, kotlin.reflect.KProperty1
                                public Object get(Object obj) {
                                    return ((BrowseReducer.State) obj).getFabMenuState();
                                }
                            };
                            ComposerKt.sourceInformationMarkerStart(composer3, 318083639, "CC(remember):AllFilesScreen.kt#9igjgp");
                            allFilesScreenKt$AllFilesScreen$1$3$2$1RememberedValue = composer3.rememberedValue();
                            if (allFilesScreenKt$AllFilesScreen$1$3$2$1RememberedValue == Composer.INSTANCE.getEmpty()) {
                                allFilesScreenKt$AllFilesScreen$1$3$2$1RememberedValue = AllFilesScreenKt$AllFilesScreen$1$3$2$1.INSTANCE;
                                composer3.updateRememberedValue(allFilesScreenKt$AllFilesScreen$1$3$2$1RememberedValue);
                            }
                            ComposerKt.sourceInformationMarkerEnd(composer3);
                            Store<LocalState, LocalAction> storeIfScope4 = store.ifScope(allFilesScreenKt$AllFilesScreen$1$3$4, (Function1) ((KFunction) allFilesScreenKt$AllFilesScreen$1$3$2$1RememberedValue));
                            if (AllFilesScreen$lambda$2(mutableState)) {
                                z5 = false;
                            } else {
                                z5 = false;
                            }
                            ComposerKt.sourceInformationMarkerStart(composer3, 318091867, "CC(remember):AllFilesScreen.kt#9igjgp");
                            zChangedInstance = composer3.changedInstance(navigator) | composer3.changedInstance(fabMenuState);
                            objRememberedValue3 = composer3.rememberedValue();
                            if (!zChangedInstance) {
                                objRememberedValue3 = new Function1() { // from class: com.box.android.browse.cpl.browse.AllFilesScreenKt$$ExternalSyntheticLambda4
                                    @Override // kotlin.jvm.functions.Function1
                                    public final Object invoke(Object obj) {
                                        return AllFilesScreenKt.AllFilesScreen$lambda$4$2$1$0(navigator, fabMenuState, (String) obj);
                                    }
                                };
                                composer3.updateRememberedValue(objRememberedValue3);
                            } else {
                                objRememberedValue3 = new Function1() { // from class: com.box.android.browse.cpl.browse.AllFilesScreenKt$$ExternalSyntheticLambda4
                                    @Override // kotlin.jvm.functions.Function1
                                    public final Object invoke(Object obj) {
                                        return AllFilesScreenKt.AllFilesScreen$lambda$4$2$1$0(navigator, fabMenuState, (String) obj);
                                    }
                                };
                                composer3.updateRememberedValue(objRememberedValue3);
                            }
                            ComposerKt.sourceInformationMarkerEnd(composer3);
                            FilesFabComponentKt.FilesFabComponent(storeIfScope4, snackbarHostState, (Function1) objRememberedValue3, null, z5, composer3, i10 & 112, 8);
                        } else {
                            composer3.startReplaceGroup(1266836787);
                        }
                        composer3.endReplaceGroup();
                        Unit unit7 = Unit.INSTANCE;
                        composer3.endReplaceGroup();
                        Unit unit8 = Unit.INSTANCE;
                    }
                    ComposerKt.sourceInformationMarkerEnd(composer3);
                    ComposerKt.sourceInformationMarkerEnd(composer3);
                    composer3.endNode();
                    ComposerKt.sourceInformationMarkerEnd(composer3);
                    ComposerKt.sourceInformationMarkerEnd(composer3);
                    ComposerKt.sourceInformationMarkerEnd(composer3);
                    NavigationRouteEffect(AllFilesScreen$lambda$0(stateCollectAsStateWithLifecycle).getNavigationRoute(), navigator, store, composer3, (i16 << 3) & 112);
                    SelectionModeViewsVisibilityEffect(AllFilesScreen$lambda$0(stateCollectAsStateWithLifecycle).getActionableItemsListState().getIsSelecting(), homeScreenViewsVisibilityState8, composer3, (i16 >> 9) & 112);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    homeScreenViewsVisibilityState3 = homeScreenViewsVisibilityState8;
                    composer2 = composer3;
                    modifier3 = modifier19;
                    allFilesViewModel3 = allFilesViewModel4;
                    z3 = z9;
                } else {
                    composerStartRestartGroup.skipToGroupEnd();
                    z3 = z;
                    composer2 = composerStartRestartGroup;
                    modifier3 = modifier2;
                    homeScreenViewsVisibilityState3 = homeScreenViewsVisibilityState2;
                    allFilesViewModel3 = allFilesViewModel2;
                }
                scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.box.android.browse.cpl.browse.AllFilesScreenKt$$ExternalSyntheticLambda5
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return AllFilesScreenKt.AllFilesScreen$lambda$5(navigator, boxMessageDispatcher, snackbarHostState, modifier3, homeScreenViewsVisibilityState3, z3, allFilesViewModel3, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    });
                }
            }
            i3 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
            if ((1572864 & i) == 0) {
                if ((i2 & 64) == 0) {
                    allFilesViewModel2 = allFilesViewModel;
                    if (composerStartRestartGroup.changedInstance(allFilesViewModel2)) {
                    }
                    i3 |= i12;
                } else {
                    allFilesViewModel2 = allFilesViewModel;
                }
                i3 |= i12;
            } else {
                allFilesViewModel2 = allFilesViewModel;
            }
            if ((599187 & i3) != 599186) {
                z2 = true;
            } else {
                z2 = false;
            }
            if (composerStartRestartGroup.shouldExecute(z2, i3 & 1)) {
                composerStartRestartGroup.startDefaults();
                ComposerKt.sourceInformation(composerStartRestartGroup, "48@2415L23");
                r13 = 0;
                if ((i & 1) != 0) {
                    if (i11 != 0) {
                        modifier2 = Modifier.INSTANCE;
                    }
                    if (i4 != 0) {
                        homeScreenViewsVisibilityState4 = null;
                    } else {
                        homeScreenViewsVisibilityState4 = homeScreenViewsVisibilityState2;
                    }
                    if (i6 != 0) {
                        z4 = false;
                    } else {
                        z4 = z;
                    }
                    if ((i2 & 64) != 0) {
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1447482489, "CC(hiltActivityViewModel)N(key)159@5773L7,160@5813L56:ComposeUtils.kt#vejmn0");
                        ProvidableCompositionLocal<Activity> localActivity6 = LocalActivityKt.getLocalActivity();
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
                        Object objConsume10 = composerStartRestartGroup.consume(localActivity6);
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        Intrinsics.checkNotNull(objConsume10, "null cannot be cast to non-null type androidx.activity.ComponentActivity");
                        componentActivity = (ComponentActivity) objConsume10;
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
                        str = "CC(<get-current>):CompositionLocal.kt#9igjgp";
                        r13 = 0;
                        ViewModel viewModel6 = ViewModelKt.viewModel((Class<ViewModel>) AllFilesViewModel.class, componentActivity, (String) null, factoryCreateHiltViewModelFactory6, defaultViewModelCreationExtras, composerStartRestartGroup, 36936, 0);
                        composerStartRestartGroup = composerStartRestartGroup;
                        composerStartRestartGroup.endReplaceableGroup();
                        composerStartRestartGroup.endReplaceableGroup();
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        Modifier modifier110 = modifier2;
                        i8 = i3 & (-3670017);
                        modifier4 = modifier110;
                        allFilesViewModel4 = (AllFilesViewModel) viewModel6;
                    } else {
                        str = "CC(<get-current>):CompositionLocal.kt#9igjgp";
                        Modifier modifier111 = modifier2;
                        i8 = i3;
                        modifier4 = modifier111;
                        allFilesViewModel4 = allFilesViewModel2;
                    }
                } else {
                    if (i11 != 0) {
                        modifier2 = Modifier.INSTANCE;
                    }
                    if (i4 != 0) {
                        homeScreenViewsVisibilityState4 = null;
                    } else {
                        homeScreenViewsVisibilityState4 = homeScreenViewsVisibilityState2;
                    }
                    if (i6 != 0) {
                        z4 = false;
                    } else {
                        z4 = z;
                    }
                    if ((i2 & 64) != 0) {
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1447482489, "CC(hiltActivityViewModel)N(key)159@5773L7,160@5813L56:ComposeUtils.kt#vejmn0");
                        ProvidableCompositionLocal<Activity> localActivity7 = LocalActivityKt.getLocalActivity();
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
                        Object objConsume11 = composerStartRestartGroup.consume(localActivity7);
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        Intrinsics.checkNotNull(objConsume11, "null cannot be cast to non-null type androidx.activity.ComponentActivity");
                        componentActivity = (ComponentActivity) objConsume11;
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
                        str = "CC(<get-current>):CompositionLocal.kt#9igjgp";
                        r13 = 0;
                        ViewModel viewModel7 = ViewModelKt.viewModel((Class<ViewModel>) AllFilesViewModel.class, componentActivity, (String) null, factoryCreateHiltViewModelFactory7, defaultViewModelCreationExtras, composerStartRestartGroup, 36936, 0);
                        composerStartRestartGroup = composerStartRestartGroup;
                        composerStartRestartGroup.endReplaceableGroup();
                        composerStartRestartGroup.endReplaceableGroup();
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        Modifier modifier112 = modifier2;
                        i8 = i3 & (-3670017);
                        modifier4 = modifier112;
                        allFilesViewModel4 = (AllFilesViewModel) viewModel7;
                    } else {
                        str = "CC(<get-current>):CompositionLocal.kt#9igjgp";
                        Modifier modifier113 = modifier2;
                        i8 = i3;
                        modifier4 = modifier113;
                        allFilesViewModel4 = allFilesViewModel2;
                    }
                }
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-2014686211, i8, -1, "com.box.android.browse.cpl.browse.AllFilesScreen (AllFilesScreen.kt:49)");
                }
                store = allFilesViewModel4.getStore();
                stateCollectAsStateWithLifecycle = FlowExtKt.collectAsStateWithLifecycle(store.getState(), (LifecycleOwner) null, (Lifecycle.State) null, (CoroutineContext) null, composerStartRestartGroup, 0, 7);
                ProvidableCompositionLocal<Boolean> providableCompositionLocal5 = LocalFabInitiallyVisible;
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, str);
                Object objConsume12 = composerStartRestartGroup.consume(providableCompositionLocal5);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                zBooleanValue = ((Boolean) objConsume12).booleanValue();
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 916818969, "CC(remember):AllFilesScreen.kt#9igjgp");
                objRememberedValue = composerStartRestartGroup.rememberedValue();
                if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                    i9 = 2;
                    objRememberedValue = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(Boolean.valueOf(zBooleanValue), r13, 2, r13);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                } else {
                    i9 = 2;
                }
                mutableState = (MutableState) objRememberedValue;
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ScrollAwareFabVisibility scrollAwareFabVisibilityRememberScrollAwareFabVisibility5 = ScrollAwareFabVisibilityKt.rememberScrollAwareFabVisibility(composerStartRestartGroup, 0);
                Modifier modifierNestedScroll$default5 = NestedScrollModifierKt.nestedScroll$default(SizeKt.fillMaxSize$default(modifier4, 0.0f, 1, r13), scrollAwareFabVisibilityRememberScrollAwareFabVisibility5, r13, i9, r13);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1042775818, "CC(Box)N(modifier,contentAlignment,propagateMinConstraints,content)71@3424L131:Box.kt#2w3rfo");
                MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy5 = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), false);
                Modifier modifier114 = modifier4;
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
                int iHashCode5 = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
                CompositionLocalMap currentCompositionLocalMap5 = composerStartRestartGroup.getCurrentCompositionLocalMap();
                Modifier modifierMaterializeModifier5 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierNestedScroll$default5);
                constructor = ComposeUiNode.INSTANCE.getConstructor();
                HomeScreenViewsVisibilityState homeScreenViewsVisibilityState9 = homeScreenViewsVisibilityState4;
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
                Composer composerM6062constructorimpl5 = Updater.m6062constructorimpl(composerStartRestartGroup);
                Updater.m6070setimpl(composerM6062constructorimpl5, measurePolicyMaybeCachedBoxMeasurePolicy5, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                Updater.m6070setimpl(composerM6062constructorimpl5, currentCompositionLocalMap5, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                Updater.m6066initimpl(composerM6062constructorimpl5, Integer.valueOf(iHashCode5), ComposeUiNode.INSTANCE.getSetCompositeKeyHash());
                Updater.m6068reconcileimpl(composerM6062constructorimpl5, ComposeUiNode.INSTANCE.getApplyOnDeactivatedNodeAssertion());
                Updater.m6070setimpl(composerM6062constructorimpl5, modifierMaterializeModifier5, ComposeUiNode.INSTANCE.getSetModifier());
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1833054614, "C72@3469L9:Box.kt#2w3rfo");
                BoxScopeInstance boxScopeInstance5 = BoxScopeInstance.INSTANCE;
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1000030181, "C67@3044L195,73@3270L152,64@2866L617:AllFilesScreen.kt#89mwni");
                Modifier.Companion companion5 = Modifier.INSTANCE;
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1971917434, "CC(remember):AllFilesScreen.kt#9igjgp");
                zChanged = composerStartRestartGroup.changed(store);
                objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                if (!zChanged) {
                    objRememberedValue2 = new Function1() { // from class: com.box.android.browse.cpl.browse.AllFilesScreenKt$$ExternalSyntheticLambda3
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            return AllFilesScreenKt.AllFilesScreen$lambda$4$0$0(store, mutableState, ((Boolean) obj).booleanValue());
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                } else {
                    objRememberedValue2 = new Function1() { // from class: com.box.android.browse.cpl.browse.AllFilesScreenKt$$ExternalSyntheticLambda3
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            return AllFilesScreenKt.AllFilesScreen$lambda$4$0$0(store, mutableState, ((Boolean) obj).booleanValue());
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                }
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                Modifier modifierOnVisibilityChanged$default5 = OnVisibilityChangedModifierKt.onVisibilityChanged$default(companion5, 0L, 1.0f, null, (Function1) objRememberedValue2, 5, null);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1971910245, "CC(remember):AllFilesScreen.kt#9igjgp");
                allFilesScreenKt$AllFilesScreen$1$2$1RememberedValue = composerStartRestartGroup.rememberedValue();
                if (allFilesScreenKt$AllFilesScreen$1$2$1RememberedValue == Composer.INSTANCE.getEmpty()) {
                    allFilesScreenKt$AllFilesScreen$1$2$1RememberedValue = new AllFilesScreenKt$AllFilesScreen$1$2$1(snackbarHostState, null);
                    composerStartRestartGroup.updateRememberedValue(allFilesScreenKt$AllFilesScreen$1$2$1RememberedValue);
                }
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                i10 = i8 >> 3;
                composer3 = composerStartRestartGroup;
                int i17 = i8;
                AllFilesContent(store, boxMessageDispatcher, modifierOnVisibilityChanged$default5, (Function4) allFilesScreenKt$AllFilesScreen$1$2$1RememberedValue, z4, composer3, (BoxMessageDispatcher.$stable << 3) | (i8 & 112) | (57344 & i10), 0);
                boolean z10 = z4;
                fabMenuState = AllFilesScreen$lambda$0(stateCollectAsStateWithLifecycle).getFabMenuState();
                if (fabMenuState == null) {
                    composer3.startReplaceGroup(-999408416);
                    composer3.endReplaceGroup();
                    store = store;
                } else {
                    composer3.startReplaceGroup(-999408415);
                    ComposerKt.sourceInformation(composer3, "");
                    if (AllFilesScreen$lambda$0(stateCollectAsStateWithLifecycle).getActionableItemsListState().getIsSelecting()) {
                        composer3.startReplaceGroup(1270513108);
                        ComposerKt.sourceInformation(composer3, "85@3850L40,89@4097L364,82@3680L799");
                        AllFilesScreenKt$AllFilesScreen$1$3$1 allFilesScreenKt$AllFilesScreen$1$3$5 = new PropertyReference1Impl() { // from class: com.box.android.browse.cpl.browse.AllFilesScreenKt$AllFilesScreen$1$3$1
                            @Override // kotlin.jvm.internal.PropertyReference1Impl, kotlin.reflect.KProperty1
                            public Object get(Object obj) {
                                return ((BrowseReducer.State) obj).getFabMenuState();
                            }
                        };
                        ComposerKt.sourceInformationMarkerStart(composer3, 318083639, "CC(remember):AllFilesScreen.kt#9igjgp");
                        allFilesScreenKt$AllFilesScreen$1$3$2$1RememberedValue = composer3.rememberedValue();
                        if (allFilesScreenKt$AllFilesScreen$1$3$2$1RememberedValue == Composer.INSTANCE.getEmpty()) {
                            allFilesScreenKt$AllFilesScreen$1$3$2$1RememberedValue = AllFilesScreenKt$AllFilesScreen$1$3$2$1.INSTANCE;
                            composer3.updateRememberedValue(allFilesScreenKt$AllFilesScreen$1$3$2$1RememberedValue);
                        }
                        ComposerKt.sourceInformationMarkerEnd(composer3);
                        Store<LocalState, LocalAction> storeIfScope5 = store.ifScope(allFilesScreenKt$AllFilesScreen$1$3$5, (Function1) ((KFunction) allFilesScreenKt$AllFilesScreen$1$3$2$1RememberedValue));
                        if (AllFilesScreen$lambda$2(mutableState)) {
                            z5 = false;
                        } else {
                            z5 = false;
                        }
                        ComposerKt.sourceInformationMarkerStart(composer3, 318091867, "CC(remember):AllFilesScreen.kt#9igjgp");
                        zChangedInstance = composer3.changedInstance(navigator) | composer3.changedInstance(fabMenuState);
                        objRememberedValue3 = composer3.rememberedValue();
                        if (!zChangedInstance) {
                            objRememberedValue3 = new Function1() { // from class: com.box.android.browse.cpl.browse.AllFilesScreenKt$$ExternalSyntheticLambda4
                                @Override // kotlin.jvm.functions.Function1
                                public final Object invoke(Object obj) {
                                    return AllFilesScreenKt.AllFilesScreen$lambda$4$2$1$0(navigator, fabMenuState, (String) obj);
                                }
                            };
                            composer3.updateRememberedValue(objRememberedValue3);
                        } else {
                            objRememberedValue3 = new Function1() { // from class: com.box.android.browse.cpl.browse.AllFilesScreenKt$$ExternalSyntheticLambda4
                                @Override // kotlin.jvm.functions.Function1
                                public final Object invoke(Object obj) {
                                    return AllFilesScreenKt.AllFilesScreen$lambda$4$2$1$0(navigator, fabMenuState, (String) obj);
                                }
                            };
                            composer3.updateRememberedValue(objRememberedValue3);
                        }
                        ComposerKt.sourceInformationMarkerEnd(composer3);
                        FilesFabComponentKt.FilesFabComponent(storeIfScope5, snackbarHostState, (Function1) objRememberedValue3, null, z5, composer3, i10 & 112, 8);
                    } else {
                        composer3.startReplaceGroup(1266836787);
                    }
                    composer3.endReplaceGroup();
                    Unit unit9 = Unit.INSTANCE;
                    composer3.endReplaceGroup();
                    Unit unit10 = Unit.INSTANCE;
                }
                ComposerKt.sourceInformationMarkerEnd(composer3);
                ComposerKt.sourceInformationMarkerEnd(composer3);
                composer3.endNode();
                ComposerKt.sourceInformationMarkerEnd(composer3);
                ComposerKt.sourceInformationMarkerEnd(composer3);
                ComposerKt.sourceInformationMarkerEnd(composer3);
                NavigationRouteEffect(AllFilesScreen$lambda$0(stateCollectAsStateWithLifecycle).getNavigationRoute(), navigator, store, composer3, (i17 << 3) & 112);
                SelectionModeViewsVisibilityEffect(AllFilesScreen$lambda$0(stateCollectAsStateWithLifecycle).getActionableItemsListState().getIsSelecting(), homeScreenViewsVisibilityState9, composer3, (i17 >> 9) & 112);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                homeScreenViewsVisibilityState3 = homeScreenViewsVisibilityState9;
                composer2 = composer3;
                modifier3 = modifier114;
                allFilesViewModel3 = allFilesViewModel4;
                z3 = z10;
            } else {
                composerStartRestartGroup.skipToGroupEnd();
                z3 = z;
                composer2 = composerStartRestartGroup;
                modifier3 = modifier2;
                homeScreenViewsVisibilityState3 = homeScreenViewsVisibilityState2;
                allFilesViewModel3 = allFilesViewModel2;
            }
            scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.box.android.browse.cpl.browse.AllFilesScreenKt$$ExternalSyntheticLambda5
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return AllFilesScreenKt.AllFilesScreen$lambda$5(navigator, boxMessageDispatcher, snackbarHostState, modifier3, homeScreenViewsVisibilityState3, z3, allFilesViewModel3, i, i2, (Composer) obj, ((Integer) obj2).intValue());
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
                    if (composerStartRestartGroup.changed(z)) {
                        i7 = 131072;
                    } else {
                        i7 = 65536;
                    }
                    i3 |= i7;
                }
                if ((1572864 & i) == 0) {
                    if ((i2 & 64) == 0) {
                        allFilesViewModel2 = allFilesViewModel;
                        if (composerStartRestartGroup.changedInstance(allFilesViewModel2)) {
                        }
                        i3 |= i12;
                    } else {
                        allFilesViewModel2 = allFilesViewModel;
                    }
                    i3 |= i12;
                } else {
                    allFilesViewModel2 = allFilesViewModel;
                }
                if ((599187 & i3) != 599186) {
                    z2 = true;
                } else {
                    z2 = false;
                }
                if (composerStartRestartGroup.shouldExecute(z2, i3 & 1)) {
                    composerStartRestartGroup.startDefaults();
                    ComposerKt.sourceInformation(composerStartRestartGroup, "48@2415L23");
                    r13 = 0;
                    if ((i & 1) != 0) {
                        if (i11 != 0) {
                            modifier2 = Modifier.INSTANCE;
                        }
                        if (i4 != 0) {
                            homeScreenViewsVisibilityState4 = null;
                        } else {
                            homeScreenViewsVisibilityState4 = homeScreenViewsVisibilityState2;
                        }
                        if (i6 != 0) {
                            z4 = false;
                        } else {
                            z4 = z;
                        }
                        if ((i2 & 64) != 0) {
                            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1447482489, "CC(hiltActivityViewModel)N(key)159@5773L7,160@5813L56:ComposeUtils.kt#vejmn0");
                            ProvidableCompositionLocal<Activity> localActivity8 = LocalActivityKt.getLocalActivity();
                            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
                            Object objConsume13 = composerStartRestartGroup.consume(localActivity8);
                            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                            Intrinsics.checkNotNull(objConsume13, "null cannot be cast to non-null type androidx.activity.ComponentActivity");
                            componentActivity = (ComponentActivity) objConsume13;
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
                            str = "CC(<get-current>):CompositionLocal.kt#9igjgp";
                            r13 = 0;
                            ViewModel viewModel8 = ViewModelKt.viewModel((Class<ViewModel>) AllFilesViewModel.class, componentActivity, (String) null, factoryCreateHiltViewModelFactory8, defaultViewModelCreationExtras, composerStartRestartGroup, 36936, 0);
                            composerStartRestartGroup = composerStartRestartGroup;
                            composerStartRestartGroup.endReplaceableGroup();
                            composerStartRestartGroup.endReplaceableGroup();
                            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                            Modifier modifier115 = modifier2;
                            i8 = i3 & (-3670017);
                            modifier4 = modifier115;
                            allFilesViewModel4 = (AllFilesViewModel) viewModel8;
                        } else {
                            str = "CC(<get-current>):CompositionLocal.kt#9igjgp";
                            Modifier modifier116 = modifier2;
                            i8 = i3;
                            modifier4 = modifier116;
                            allFilesViewModel4 = allFilesViewModel2;
                        }
                    } else {
                        if (i11 != 0) {
                            modifier2 = Modifier.INSTANCE;
                        }
                        if (i4 != 0) {
                            homeScreenViewsVisibilityState4 = null;
                        } else {
                            homeScreenViewsVisibilityState4 = homeScreenViewsVisibilityState2;
                        }
                        if (i6 != 0) {
                            z4 = false;
                        } else {
                            z4 = z;
                        }
                        if ((i2 & 64) != 0) {
                            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1447482489, "CC(hiltActivityViewModel)N(key)159@5773L7,160@5813L56:ComposeUtils.kt#vejmn0");
                            ProvidableCompositionLocal<Activity> localActivity9 = LocalActivityKt.getLocalActivity();
                            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
                            Object objConsume14 = composerStartRestartGroup.consume(localActivity9);
                            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                            Intrinsics.checkNotNull(objConsume14, "null cannot be cast to non-null type androidx.activity.ComponentActivity");
                            componentActivity = (ComponentActivity) objConsume14;
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
                            str = "CC(<get-current>):CompositionLocal.kt#9igjgp";
                            r13 = 0;
                            ViewModel viewModel9 = ViewModelKt.viewModel((Class<ViewModel>) AllFilesViewModel.class, componentActivity, (String) null, factoryCreateHiltViewModelFactory9, defaultViewModelCreationExtras, composerStartRestartGroup, 36936, 0);
                            composerStartRestartGroup = composerStartRestartGroup;
                            composerStartRestartGroup.endReplaceableGroup();
                            composerStartRestartGroup.endReplaceableGroup();
                            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                            Modifier modifier117 = modifier2;
                            i8 = i3 & (-3670017);
                            modifier4 = modifier117;
                            allFilesViewModel4 = (AllFilesViewModel) viewModel9;
                        } else {
                            str = "CC(<get-current>):CompositionLocal.kt#9igjgp";
                            Modifier modifier118 = modifier2;
                            i8 = i3;
                            modifier4 = modifier118;
                            allFilesViewModel4 = allFilesViewModel2;
                        }
                    }
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-2014686211, i8, -1, "com.box.android.browse.cpl.browse.AllFilesScreen (AllFilesScreen.kt:49)");
                    }
                    store = allFilesViewModel4.getStore();
                    stateCollectAsStateWithLifecycle = FlowExtKt.collectAsStateWithLifecycle(store.getState(), (LifecycleOwner) null, (Lifecycle.State) null, (CoroutineContext) null, composerStartRestartGroup, 0, 7);
                    ProvidableCompositionLocal<Boolean> providableCompositionLocal6 = LocalFabInitiallyVisible;
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, str);
                    Object objConsume15 = composerStartRestartGroup.consume(providableCompositionLocal6);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    zBooleanValue = ((Boolean) objConsume15).booleanValue();
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 916818969, "CC(remember):AllFilesScreen.kt#9igjgp");
                    objRememberedValue = composerStartRestartGroup.rememberedValue();
                    if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                        i9 = 2;
                        objRememberedValue = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(Boolean.valueOf(zBooleanValue), r13, 2, r13);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                    } else {
                        i9 = 2;
                    }
                    mutableState = (MutableState) objRememberedValue;
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    ScrollAwareFabVisibility scrollAwareFabVisibilityRememberScrollAwareFabVisibility6 = ScrollAwareFabVisibilityKt.rememberScrollAwareFabVisibility(composerStartRestartGroup, 0);
                    Modifier modifierNestedScroll$default6 = NestedScrollModifierKt.nestedScroll$default(SizeKt.fillMaxSize$default(modifier4, 0.0f, 1, r13), scrollAwareFabVisibilityRememberScrollAwareFabVisibility6, r13, i9, r13);
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1042775818, "CC(Box)N(modifier,contentAlignment,propagateMinConstraints,content)71@3424L131:Box.kt#2w3rfo");
                    MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy6 = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), false);
                    Modifier modifier119 = modifier4;
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
                    int iHashCode6 = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
                    CompositionLocalMap currentCompositionLocalMap6 = composerStartRestartGroup.getCurrentCompositionLocalMap();
                    Modifier modifierMaterializeModifier6 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierNestedScroll$default6);
                    constructor = ComposeUiNode.INSTANCE.getConstructor();
                    HomeScreenViewsVisibilityState homeScreenViewsVisibilityState10 = homeScreenViewsVisibilityState4;
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
                    Composer composerM6062constructorimpl6 = Updater.m6062constructorimpl(composerStartRestartGroup);
                    Updater.m6070setimpl(composerM6062constructorimpl6, measurePolicyMaybeCachedBoxMeasurePolicy6, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                    Updater.m6070setimpl(composerM6062constructorimpl6, currentCompositionLocalMap6, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                    Updater.m6066initimpl(composerM6062constructorimpl6, Integer.valueOf(iHashCode6), ComposeUiNode.INSTANCE.getSetCompositeKeyHash());
                    Updater.m6068reconcileimpl(composerM6062constructorimpl6, ComposeUiNode.INSTANCE.getApplyOnDeactivatedNodeAssertion());
                    Updater.m6070setimpl(composerM6062constructorimpl6, modifierMaterializeModifier6, ComposeUiNode.INSTANCE.getSetModifier());
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1833054614, "C72@3469L9:Box.kt#2w3rfo");
                    BoxScopeInstance boxScopeInstance6 = BoxScopeInstance.INSTANCE;
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1000030181, "C67@3044L195,73@3270L152,64@2866L617:AllFilesScreen.kt#89mwni");
                    Modifier.Companion companion6 = Modifier.INSTANCE;
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1971917434, "CC(remember):AllFilesScreen.kt#9igjgp");
                    zChanged = composerStartRestartGroup.changed(store);
                    objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                    if (!zChanged) {
                        objRememberedValue2 = new Function1() { // from class: com.box.android.browse.cpl.browse.AllFilesScreenKt$$ExternalSyntheticLambda3
                            @Override // kotlin.jvm.functions.Function1
                            public final Object invoke(Object obj) {
                                return AllFilesScreenKt.AllFilesScreen$lambda$4$0$0(store, mutableState, ((Boolean) obj).booleanValue());
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                    } else {
                        objRememberedValue2 = new Function1() { // from class: com.box.android.browse.cpl.browse.AllFilesScreenKt$$ExternalSyntheticLambda3
                            @Override // kotlin.jvm.functions.Function1
                            public final Object invoke(Object obj) {
                                return AllFilesScreenKt.AllFilesScreen$lambda$4$0$0(store, mutableState, ((Boolean) obj).booleanValue());
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                    }
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    Modifier modifierOnVisibilityChanged$default6 = OnVisibilityChangedModifierKt.onVisibilityChanged$default(companion6, 0L, 1.0f, null, (Function1) objRememberedValue2, 5, null);
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1971910245, "CC(remember):AllFilesScreen.kt#9igjgp");
                    allFilesScreenKt$AllFilesScreen$1$2$1RememberedValue = composerStartRestartGroup.rememberedValue();
                    if (allFilesScreenKt$AllFilesScreen$1$2$1RememberedValue == Composer.INSTANCE.getEmpty()) {
                        allFilesScreenKt$AllFilesScreen$1$2$1RememberedValue = new AllFilesScreenKt$AllFilesScreen$1$2$1(snackbarHostState, null);
                        composerStartRestartGroup.updateRememberedValue(allFilesScreenKt$AllFilesScreen$1$2$1RememberedValue);
                    }
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    i10 = i8 >> 3;
                    composer3 = composerStartRestartGroup;
                    int i18 = i8;
                    AllFilesContent(store, boxMessageDispatcher, modifierOnVisibilityChanged$default6, (Function4) allFilesScreenKt$AllFilesScreen$1$2$1RememberedValue, z4, composer3, (BoxMessageDispatcher.$stable << 3) | (i8 & 112) | (57344 & i10), 0);
                    boolean z11 = z4;
                    fabMenuState = AllFilesScreen$lambda$0(stateCollectAsStateWithLifecycle).getFabMenuState();
                    if (fabMenuState == null) {
                        composer3.startReplaceGroup(-999408416);
                        composer3.endReplaceGroup();
                        store = store;
                    } else {
                        composer3.startReplaceGroup(-999408415);
                        ComposerKt.sourceInformation(composer3, "");
                        if (AllFilesScreen$lambda$0(stateCollectAsStateWithLifecycle).getActionableItemsListState().getIsSelecting()) {
                            composer3.startReplaceGroup(1270513108);
                            ComposerKt.sourceInformation(composer3, "85@3850L40,89@4097L364,82@3680L799");
                            AllFilesScreenKt$AllFilesScreen$1$3$1 allFilesScreenKt$AllFilesScreen$1$3$6 = new PropertyReference1Impl() { // from class: com.box.android.browse.cpl.browse.AllFilesScreenKt$AllFilesScreen$1$3$1
                                @Override // kotlin.jvm.internal.PropertyReference1Impl, kotlin.reflect.KProperty1
                                public Object get(Object obj) {
                                    return ((BrowseReducer.State) obj).getFabMenuState();
                                }
                            };
                            ComposerKt.sourceInformationMarkerStart(composer3, 318083639, "CC(remember):AllFilesScreen.kt#9igjgp");
                            allFilesScreenKt$AllFilesScreen$1$3$2$1RememberedValue = composer3.rememberedValue();
                            if (allFilesScreenKt$AllFilesScreen$1$3$2$1RememberedValue == Composer.INSTANCE.getEmpty()) {
                                allFilesScreenKt$AllFilesScreen$1$3$2$1RememberedValue = AllFilesScreenKt$AllFilesScreen$1$3$2$1.INSTANCE;
                                composer3.updateRememberedValue(allFilesScreenKt$AllFilesScreen$1$3$2$1RememberedValue);
                            }
                            ComposerKt.sourceInformationMarkerEnd(composer3);
                            Store<LocalState, LocalAction> storeIfScope6 = store.ifScope(allFilesScreenKt$AllFilesScreen$1$3$6, (Function1) ((KFunction) allFilesScreenKt$AllFilesScreen$1$3$2$1RememberedValue));
                            if (AllFilesScreen$lambda$2(mutableState)) {
                                z5 = false;
                            } else {
                                z5 = false;
                            }
                            ComposerKt.sourceInformationMarkerStart(composer3, 318091867, "CC(remember):AllFilesScreen.kt#9igjgp");
                            zChangedInstance = composer3.changedInstance(navigator) | composer3.changedInstance(fabMenuState);
                            objRememberedValue3 = composer3.rememberedValue();
                            if (!zChangedInstance) {
                                objRememberedValue3 = new Function1() { // from class: com.box.android.browse.cpl.browse.AllFilesScreenKt$$ExternalSyntheticLambda4
                                    @Override // kotlin.jvm.functions.Function1
                                    public final Object invoke(Object obj) {
                                        return AllFilesScreenKt.AllFilesScreen$lambda$4$2$1$0(navigator, fabMenuState, (String) obj);
                                    }
                                };
                                composer3.updateRememberedValue(objRememberedValue3);
                            } else {
                                objRememberedValue3 = new Function1() { // from class: com.box.android.browse.cpl.browse.AllFilesScreenKt$$ExternalSyntheticLambda4
                                    @Override // kotlin.jvm.functions.Function1
                                    public final Object invoke(Object obj) {
                                        return AllFilesScreenKt.AllFilesScreen$lambda$4$2$1$0(navigator, fabMenuState, (String) obj);
                                    }
                                };
                                composer3.updateRememberedValue(objRememberedValue3);
                            }
                            ComposerKt.sourceInformationMarkerEnd(composer3);
                            FilesFabComponentKt.FilesFabComponent(storeIfScope6, snackbarHostState, (Function1) objRememberedValue3, null, z5, composer3, i10 & 112, 8);
                        } else {
                            composer3.startReplaceGroup(1266836787);
                        }
                        composer3.endReplaceGroup();
                        Unit unit11 = Unit.INSTANCE;
                        composer3.endReplaceGroup();
                        Unit unit12 = Unit.INSTANCE;
                    }
                    ComposerKt.sourceInformationMarkerEnd(composer3);
                    ComposerKt.sourceInformationMarkerEnd(composer3);
                    composer3.endNode();
                    ComposerKt.sourceInformationMarkerEnd(composer3);
                    ComposerKt.sourceInformationMarkerEnd(composer3);
                    ComposerKt.sourceInformationMarkerEnd(composer3);
                    NavigationRouteEffect(AllFilesScreen$lambda$0(stateCollectAsStateWithLifecycle).getNavigationRoute(), navigator, store, composer3, (i18 << 3) & 112);
                    SelectionModeViewsVisibilityEffect(AllFilesScreen$lambda$0(stateCollectAsStateWithLifecycle).getActionableItemsListState().getIsSelecting(), homeScreenViewsVisibilityState10, composer3, (i18 >> 9) & 112);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    homeScreenViewsVisibilityState3 = homeScreenViewsVisibilityState10;
                    composer2 = composer3;
                    modifier3 = modifier119;
                    allFilesViewModel3 = allFilesViewModel4;
                    z3 = z11;
                } else {
                    composerStartRestartGroup.skipToGroupEnd();
                    z3 = z;
                    composer2 = composerStartRestartGroup;
                    modifier3 = modifier2;
                    homeScreenViewsVisibilityState3 = homeScreenViewsVisibilityState2;
                    allFilesViewModel3 = allFilesViewModel2;
                }
                scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.box.android.browse.cpl.browse.AllFilesScreenKt$$ExternalSyntheticLambda5
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return AllFilesScreenKt.AllFilesScreen$lambda$5(navigator, boxMessageDispatcher, snackbarHostState, modifier3, homeScreenViewsVisibilityState3, z3, allFilesViewModel3, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    });
                }
            }
            i3 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
            if ((1572864 & i) == 0) {
                if ((i2 & 64) == 0) {
                    allFilesViewModel2 = allFilesViewModel;
                    if (composerStartRestartGroup.changedInstance(allFilesViewModel2)) {
                    }
                    i3 |= i12;
                } else {
                    allFilesViewModel2 = allFilesViewModel;
                }
                i3 |= i12;
            } else {
                allFilesViewModel2 = allFilesViewModel;
            }
            if ((599187 & i3) != 599186) {
                z2 = true;
            } else {
                z2 = false;
            }
            if (composerStartRestartGroup.shouldExecute(z2, i3 & 1)) {
                composerStartRestartGroup.startDefaults();
                ComposerKt.sourceInformation(composerStartRestartGroup, "48@2415L23");
                r13 = 0;
                if ((i & 1) != 0) {
                    if (i11 != 0) {
                        modifier2 = Modifier.INSTANCE;
                    }
                    if (i4 != 0) {
                        homeScreenViewsVisibilityState4 = null;
                    } else {
                        homeScreenViewsVisibilityState4 = homeScreenViewsVisibilityState2;
                    }
                    if (i6 != 0) {
                        z4 = false;
                    } else {
                        z4 = z;
                    }
                    if ((i2 & 64) != 0) {
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1447482489, "CC(hiltActivityViewModel)N(key)159@5773L7,160@5813L56:ComposeUtils.kt#vejmn0");
                        ProvidableCompositionLocal<Activity> localActivity10 = LocalActivityKt.getLocalActivity();
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
                        Object objConsume16 = composerStartRestartGroup.consume(localActivity10);
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        Intrinsics.checkNotNull(objConsume16, "null cannot be cast to non-null type androidx.activity.ComponentActivity");
                        componentActivity = (ComponentActivity) objConsume16;
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
                        str = "CC(<get-current>):CompositionLocal.kt#9igjgp";
                        r13 = 0;
                        ViewModel viewModel10 = ViewModelKt.viewModel((Class<ViewModel>) AllFilesViewModel.class, componentActivity, (String) null, factoryCreateHiltViewModelFactory10, defaultViewModelCreationExtras, composerStartRestartGroup, 36936, 0);
                        composerStartRestartGroup = composerStartRestartGroup;
                        composerStartRestartGroup.endReplaceableGroup();
                        composerStartRestartGroup.endReplaceableGroup();
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        Modifier modifier1110 = modifier2;
                        i8 = i3 & (-3670017);
                        modifier4 = modifier1110;
                        allFilesViewModel4 = (AllFilesViewModel) viewModel10;
                    } else {
                        str = "CC(<get-current>):CompositionLocal.kt#9igjgp";
                        Modifier modifier1111 = modifier2;
                        i8 = i3;
                        modifier4 = modifier1111;
                        allFilesViewModel4 = allFilesViewModel2;
                    }
                } else {
                    if (i11 != 0) {
                        modifier2 = Modifier.INSTANCE;
                    }
                    if (i4 != 0) {
                        homeScreenViewsVisibilityState4 = null;
                    } else {
                        homeScreenViewsVisibilityState4 = homeScreenViewsVisibilityState2;
                    }
                    if (i6 != 0) {
                        z4 = false;
                    } else {
                        z4 = z;
                    }
                    if ((i2 & 64) != 0) {
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1447482489, "CC(hiltActivityViewModel)N(key)159@5773L7,160@5813L56:ComposeUtils.kt#vejmn0");
                        ProvidableCompositionLocal<Activity> localActivity11 = LocalActivityKt.getLocalActivity();
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
                        Object objConsume17 = composerStartRestartGroup.consume(localActivity11);
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        Intrinsics.checkNotNull(objConsume17, "null cannot be cast to non-null type androidx.activity.ComponentActivity");
                        componentActivity = (ComponentActivity) objConsume17;
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
                        str = "CC(<get-current>):CompositionLocal.kt#9igjgp";
                        r13 = 0;
                        ViewModel viewModel11 = ViewModelKt.viewModel((Class<ViewModel>) AllFilesViewModel.class, componentActivity, (String) null, factoryCreateHiltViewModelFactory11, defaultViewModelCreationExtras, composerStartRestartGroup, 36936, 0);
                        composerStartRestartGroup = composerStartRestartGroup;
                        composerStartRestartGroup.endReplaceableGroup();
                        composerStartRestartGroup.endReplaceableGroup();
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        Modifier modifier1112 = modifier2;
                        i8 = i3 & (-3670017);
                        modifier4 = modifier1112;
                        allFilesViewModel4 = (AllFilesViewModel) viewModel11;
                    } else {
                        str = "CC(<get-current>):CompositionLocal.kt#9igjgp";
                        Modifier modifier1113 = modifier2;
                        i8 = i3;
                        modifier4 = modifier1113;
                        allFilesViewModel4 = allFilesViewModel2;
                    }
                }
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-2014686211, i8, -1, "com.box.android.browse.cpl.browse.AllFilesScreen (AllFilesScreen.kt:49)");
                }
                store = allFilesViewModel4.getStore();
                stateCollectAsStateWithLifecycle = FlowExtKt.collectAsStateWithLifecycle(store.getState(), (LifecycleOwner) null, (Lifecycle.State) null, (CoroutineContext) null, composerStartRestartGroup, 0, 7);
                ProvidableCompositionLocal<Boolean> providableCompositionLocal7 = LocalFabInitiallyVisible;
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, str);
                Object objConsume18 = composerStartRestartGroup.consume(providableCompositionLocal7);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                zBooleanValue = ((Boolean) objConsume18).booleanValue();
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 916818969, "CC(remember):AllFilesScreen.kt#9igjgp");
                objRememberedValue = composerStartRestartGroup.rememberedValue();
                if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                    i9 = 2;
                    objRememberedValue = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(Boolean.valueOf(zBooleanValue), r13, 2, r13);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                } else {
                    i9 = 2;
                }
                mutableState = (MutableState) objRememberedValue;
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ScrollAwareFabVisibility scrollAwareFabVisibilityRememberScrollAwareFabVisibility7 = ScrollAwareFabVisibilityKt.rememberScrollAwareFabVisibility(composerStartRestartGroup, 0);
                Modifier modifierNestedScroll$default7 = NestedScrollModifierKt.nestedScroll$default(SizeKt.fillMaxSize$default(modifier4, 0.0f, 1, r13), scrollAwareFabVisibilityRememberScrollAwareFabVisibility7, r13, i9, r13);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1042775818, "CC(Box)N(modifier,contentAlignment,propagateMinConstraints,content)71@3424L131:Box.kt#2w3rfo");
                MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy7 = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), false);
                Modifier modifier1114 = modifier4;
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
                int iHashCode7 = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
                CompositionLocalMap currentCompositionLocalMap7 = composerStartRestartGroup.getCurrentCompositionLocalMap();
                Modifier modifierMaterializeModifier7 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierNestedScroll$default7);
                constructor = ComposeUiNode.INSTANCE.getConstructor();
                HomeScreenViewsVisibilityState homeScreenViewsVisibilityState11 = homeScreenViewsVisibilityState4;
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
                Composer composerM6062constructorimpl7 = Updater.m6062constructorimpl(composerStartRestartGroup);
                Updater.m6070setimpl(composerM6062constructorimpl7, measurePolicyMaybeCachedBoxMeasurePolicy7, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                Updater.m6070setimpl(composerM6062constructorimpl7, currentCompositionLocalMap7, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                Updater.m6066initimpl(composerM6062constructorimpl7, Integer.valueOf(iHashCode7), ComposeUiNode.INSTANCE.getSetCompositeKeyHash());
                Updater.m6068reconcileimpl(composerM6062constructorimpl7, ComposeUiNode.INSTANCE.getApplyOnDeactivatedNodeAssertion());
                Updater.m6070setimpl(composerM6062constructorimpl7, modifierMaterializeModifier7, ComposeUiNode.INSTANCE.getSetModifier());
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1833054614, "C72@3469L9:Box.kt#2w3rfo");
                BoxScopeInstance boxScopeInstance7 = BoxScopeInstance.INSTANCE;
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1000030181, "C67@3044L195,73@3270L152,64@2866L617:AllFilesScreen.kt#89mwni");
                Modifier.Companion companion7 = Modifier.INSTANCE;
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1971917434, "CC(remember):AllFilesScreen.kt#9igjgp");
                zChanged = composerStartRestartGroup.changed(store);
                objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                if (!zChanged) {
                    objRememberedValue2 = new Function1() { // from class: com.box.android.browse.cpl.browse.AllFilesScreenKt$$ExternalSyntheticLambda3
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            return AllFilesScreenKt.AllFilesScreen$lambda$4$0$0(store, mutableState, ((Boolean) obj).booleanValue());
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                } else {
                    objRememberedValue2 = new Function1() { // from class: com.box.android.browse.cpl.browse.AllFilesScreenKt$$ExternalSyntheticLambda3
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            return AllFilesScreenKt.AllFilesScreen$lambda$4$0$0(store, mutableState, ((Boolean) obj).booleanValue());
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                }
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                Modifier modifierOnVisibilityChanged$default7 = OnVisibilityChangedModifierKt.onVisibilityChanged$default(companion7, 0L, 1.0f, null, (Function1) objRememberedValue2, 5, null);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1971910245, "CC(remember):AllFilesScreen.kt#9igjgp");
                allFilesScreenKt$AllFilesScreen$1$2$1RememberedValue = composerStartRestartGroup.rememberedValue();
                if (allFilesScreenKt$AllFilesScreen$1$2$1RememberedValue == Composer.INSTANCE.getEmpty()) {
                    allFilesScreenKt$AllFilesScreen$1$2$1RememberedValue = new AllFilesScreenKt$AllFilesScreen$1$2$1(snackbarHostState, null);
                    composerStartRestartGroup.updateRememberedValue(allFilesScreenKt$AllFilesScreen$1$2$1RememberedValue);
                }
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                i10 = i8 >> 3;
                composer3 = composerStartRestartGroup;
                int i19 = i8;
                AllFilesContent(store, boxMessageDispatcher, modifierOnVisibilityChanged$default7, (Function4) allFilesScreenKt$AllFilesScreen$1$2$1RememberedValue, z4, composer3, (BoxMessageDispatcher.$stable << 3) | (i8 & 112) | (57344 & i10), 0);
                boolean z12 = z4;
                fabMenuState = AllFilesScreen$lambda$0(stateCollectAsStateWithLifecycle).getFabMenuState();
                if (fabMenuState == null) {
                    composer3.startReplaceGroup(-999408416);
                    composer3.endReplaceGroup();
                    store = store;
                } else {
                    composer3.startReplaceGroup(-999408415);
                    ComposerKt.sourceInformation(composer3, "");
                    if (AllFilesScreen$lambda$0(stateCollectAsStateWithLifecycle).getActionableItemsListState().getIsSelecting()) {
                        composer3.startReplaceGroup(1270513108);
                        ComposerKt.sourceInformation(composer3, "85@3850L40,89@4097L364,82@3680L799");
                        AllFilesScreenKt$AllFilesScreen$1$3$1 allFilesScreenKt$AllFilesScreen$1$3$7 = new PropertyReference1Impl() { // from class: com.box.android.browse.cpl.browse.AllFilesScreenKt$AllFilesScreen$1$3$1
                            @Override // kotlin.jvm.internal.PropertyReference1Impl, kotlin.reflect.KProperty1
                            public Object get(Object obj) {
                                return ((BrowseReducer.State) obj).getFabMenuState();
                            }
                        };
                        ComposerKt.sourceInformationMarkerStart(composer3, 318083639, "CC(remember):AllFilesScreen.kt#9igjgp");
                        allFilesScreenKt$AllFilesScreen$1$3$2$1RememberedValue = composer3.rememberedValue();
                        if (allFilesScreenKt$AllFilesScreen$1$3$2$1RememberedValue == Composer.INSTANCE.getEmpty()) {
                            allFilesScreenKt$AllFilesScreen$1$3$2$1RememberedValue = AllFilesScreenKt$AllFilesScreen$1$3$2$1.INSTANCE;
                            composer3.updateRememberedValue(allFilesScreenKt$AllFilesScreen$1$3$2$1RememberedValue);
                        }
                        ComposerKt.sourceInformationMarkerEnd(composer3);
                        Store<LocalState, LocalAction> storeIfScope7 = store.ifScope(allFilesScreenKt$AllFilesScreen$1$3$7, (Function1) ((KFunction) allFilesScreenKt$AllFilesScreen$1$3$2$1RememberedValue));
                        if (AllFilesScreen$lambda$2(mutableState)) {
                            z5 = false;
                        } else {
                            z5 = false;
                        }
                        ComposerKt.sourceInformationMarkerStart(composer3, 318091867, "CC(remember):AllFilesScreen.kt#9igjgp");
                        zChangedInstance = composer3.changedInstance(navigator) | composer3.changedInstance(fabMenuState);
                        objRememberedValue3 = composer3.rememberedValue();
                        if (!zChangedInstance) {
                            objRememberedValue3 = new Function1() { // from class: com.box.android.browse.cpl.browse.AllFilesScreenKt$$ExternalSyntheticLambda4
                                @Override // kotlin.jvm.functions.Function1
                                public final Object invoke(Object obj) {
                                    return AllFilesScreenKt.AllFilesScreen$lambda$4$2$1$0(navigator, fabMenuState, (String) obj);
                                }
                            };
                            composer3.updateRememberedValue(objRememberedValue3);
                        } else {
                            objRememberedValue3 = new Function1() { // from class: com.box.android.browse.cpl.browse.AllFilesScreenKt$$ExternalSyntheticLambda4
                                @Override // kotlin.jvm.functions.Function1
                                public final Object invoke(Object obj) {
                                    return AllFilesScreenKt.AllFilesScreen$lambda$4$2$1$0(navigator, fabMenuState, (String) obj);
                                }
                            };
                            composer3.updateRememberedValue(objRememberedValue3);
                        }
                        ComposerKt.sourceInformationMarkerEnd(composer3);
                        FilesFabComponentKt.FilesFabComponent(storeIfScope7, snackbarHostState, (Function1) objRememberedValue3, null, z5, composer3, i10 & 112, 8);
                    } else {
                        composer3.startReplaceGroup(1266836787);
                    }
                    composer3.endReplaceGroup();
                    Unit unit13 = Unit.INSTANCE;
                    composer3.endReplaceGroup();
                    Unit unit14 = Unit.INSTANCE;
                }
                ComposerKt.sourceInformationMarkerEnd(composer3);
                ComposerKt.sourceInformationMarkerEnd(composer3);
                composer3.endNode();
                ComposerKt.sourceInformationMarkerEnd(composer3);
                ComposerKt.sourceInformationMarkerEnd(composer3);
                ComposerKt.sourceInformationMarkerEnd(composer3);
                NavigationRouteEffect(AllFilesScreen$lambda$0(stateCollectAsStateWithLifecycle).getNavigationRoute(), navigator, store, composer3, (i19 << 3) & 112);
                SelectionModeViewsVisibilityEffect(AllFilesScreen$lambda$0(stateCollectAsStateWithLifecycle).getActionableItemsListState().getIsSelecting(), homeScreenViewsVisibilityState11, composer3, (i19 >> 9) & 112);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                homeScreenViewsVisibilityState3 = homeScreenViewsVisibilityState11;
                composer2 = composer3;
                modifier3 = modifier1114;
                allFilesViewModel3 = allFilesViewModel4;
                z3 = z12;
            } else {
                composerStartRestartGroup.skipToGroupEnd();
                z3 = z;
                composer2 = composerStartRestartGroup;
                modifier3 = modifier2;
                homeScreenViewsVisibilityState3 = homeScreenViewsVisibilityState2;
                allFilesViewModel3 = allFilesViewModel2;
            }
            scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.box.android.browse.cpl.browse.AllFilesScreenKt$$ExternalSyntheticLambda5
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return AllFilesScreenKt.AllFilesScreen$lambda$5(navigator, boxMessageDispatcher, snackbarHostState, modifier3, homeScreenViewsVisibilityState3, z3, allFilesViewModel3, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                    }
                });
            }
        }
        i3 |= 24576;
        homeScreenViewsVisibilityState2 = homeScreenViewsVisibilityState;
        i6 = i2 & 32;
        if (i6 != 0) {
            if ((196608 & i) == 0) {
                if (composerStartRestartGroup.changed(z)) {
                    i7 = 131072;
                } else {
                    i7 = 65536;
                }
                i3 |= i7;
            }
            if ((1572864 & i) == 0) {
                if ((i2 & 64) == 0) {
                    allFilesViewModel2 = allFilesViewModel;
                    if (composerStartRestartGroup.changedInstance(allFilesViewModel2)) {
                    }
                    i3 |= i12;
                } else {
                    allFilesViewModel2 = allFilesViewModel;
                }
                i3 |= i12;
            } else {
                allFilesViewModel2 = allFilesViewModel;
            }
            if ((599187 & i3) != 599186) {
                z2 = true;
            } else {
                z2 = false;
            }
            if (composerStartRestartGroup.shouldExecute(z2, i3 & 1)) {
                composerStartRestartGroup.startDefaults();
                ComposerKt.sourceInformation(composerStartRestartGroup, "48@2415L23");
                r13 = 0;
                if ((i & 1) != 0) {
                    if (i11 != 0) {
                        modifier2 = Modifier.INSTANCE;
                    }
                    if (i4 != 0) {
                        homeScreenViewsVisibilityState4 = null;
                    } else {
                        homeScreenViewsVisibilityState4 = homeScreenViewsVisibilityState2;
                    }
                    if (i6 != 0) {
                        z4 = false;
                    } else {
                        z4 = z;
                    }
                    if ((i2 & 64) != 0) {
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1447482489, "CC(hiltActivityViewModel)N(key)159@5773L7,160@5813L56:ComposeUtils.kt#vejmn0");
                        ProvidableCompositionLocal<Activity> localActivity12 = LocalActivityKt.getLocalActivity();
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
                        Object objConsume19 = composerStartRestartGroup.consume(localActivity12);
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        Intrinsics.checkNotNull(objConsume19, "null cannot be cast to non-null type androidx.activity.ComponentActivity");
                        componentActivity = (ComponentActivity) objConsume19;
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
                        str = "CC(<get-current>):CompositionLocal.kt#9igjgp";
                        r13 = 0;
                        ViewModel viewModel12 = ViewModelKt.viewModel((Class<ViewModel>) AllFilesViewModel.class, componentActivity, (String) null, factoryCreateHiltViewModelFactory12, defaultViewModelCreationExtras, composerStartRestartGroup, 36936, 0);
                        composerStartRestartGroup = composerStartRestartGroup;
                        composerStartRestartGroup.endReplaceableGroup();
                        composerStartRestartGroup.endReplaceableGroup();
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        Modifier modifier1115 = modifier2;
                        i8 = i3 & (-3670017);
                        modifier4 = modifier1115;
                        allFilesViewModel4 = (AllFilesViewModel) viewModel12;
                    } else {
                        str = "CC(<get-current>):CompositionLocal.kt#9igjgp";
                        Modifier modifier1116 = modifier2;
                        i8 = i3;
                        modifier4 = modifier1116;
                        allFilesViewModel4 = allFilesViewModel2;
                    }
                } else {
                    if (i11 != 0) {
                        modifier2 = Modifier.INSTANCE;
                    }
                    if (i4 != 0) {
                        homeScreenViewsVisibilityState4 = null;
                    } else {
                        homeScreenViewsVisibilityState4 = homeScreenViewsVisibilityState2;
                    }
                    if (i6 != 0) {
                        z4 = false;
                    } else {
                        z4 = z;
                    }
                    if ((i2 & 64) != 0) {
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1447482489, "CC(hiltActivityViewModel)N(key)159@5773L7,160@5813L56:ComposeUtils.kt#vejmn0");
                        ProvidableCompositionLocal<Activity> localActivity13 = LocalActivityKt.getLocalActivity();
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
                        Object objConsume110 = composerStartRestartGroup.consume(localActivity13);
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        Intrinsics.checkNotNull(objConsume110, "null cannot be cast to non-null type androidx.activity.ComponentActivity");
                        componentActivity = (ComponentActivity) objConsume110;
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
                        str = "CC(<get-current>):CompositionLocal.kt#9igjgp";
                        r13 = 0;
                        ViewModel viewModel13 = ViewModelKt.viewModel((Class<ViewModel>) AllFilesViewModel.class, componentActivity, (String) null, factoryCreateHiltViewModelFactory13, defaultViewModelCreationExtras, composerStartRestartGroup, 36936, 0);
                        composerStartRestartGroup = composerStartRestartGroup;
                        composerStartRestartGroup.endReplaceableGroup();
                        composerStartRestartGroup.endReplaceableGroup();
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        Modifier modifier1117 = modifier2;
                        i8 = i3 & (-3670017);
                        modifier4 = modifier1117;
                        allFilesViewModel4 = (AllFilesViewModel) viewModel13;
                    } else {
                        str = "CC(<get-current>):CompositionLocal.kt#9igjgp";
                        Modifier modifier1118 = modifier2;
                        i8 = i3;
                        modifier4 = modifier1118;
                        allFilesViewModel4 = allFilesViewModel2;
                    }
                }
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-2014686211, i8, -1, "com.box.android.browse.cpl.browse.AllFilesScreen (AllFilesScreen.kt:49)");
                }
                store = allFilesViewModel4.getStore();
                stateCollectAsStateWithLifecycle = FlowExtKt.collectAsStateWithLifecycle(store.getState(), (LifecycleOwner) null, (Lifecycle.State) null, (CoroutineContext) null, composerStartRestartGroup, 0, 7);
                ProvidableCompositionLocal<Boolean> providableCompositionLocal8 = LocalFabInitiallyVisible;
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, str);
                Object objConsume111 = composerStartRestartGroup.consume(providableCompositionLocal8);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                zBooleanValue = ((Boolean) objConsume111).booleanValue();
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 916818969, "CC(remember):AllFilesScreen.kt#9igjgp");
                objRememberedValue = composerStartRestartGroup.rememberedValue();
                if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                    i9 = 2;
                    objRememberedValue = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(Boolean.valueOf(zBooleanValue), r13, 2, r13);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                } else {
                    i9 = 2;
                }
                mutableState = (MutableState) objRememberedValue;
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ScrollAwareFabVisibility scrollAwareFabVisibilityRememberScrollAwareFabVisibility8 = ScrollAwareFabVisibilityKt.rememberScrollAwareFabVisibility(composerStartRestartGroup, 0);
                Modifier modifierNestedScroll$default8 = NestedScrollModifierKt.nestedScroll$default(SizeKt.fillMaxSize$default(modifier4, 0.0f, 1, r13), scrollAwareFabVisibilityRememberScrollAwareFabVisibility8, r13, i9, r13);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1042775818, "CC(Box)N(modifier,contentAlignment,propagateMinConstraints,content)71@3424L131:Box.kt#2w3rfo");
                MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy8 = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), false);
                Modifier modifier1119 = modifier4;
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
                int iHashCode8 = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
                CompositionLocalMap currentCompositionLocalMap8 = composerStartRestartGroup.getCurrentCompositionLocalMap();
                Modifier modifierMaterializeModifier8 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierNestedScroll$default8);
                constructor = ComposeUiNode.INSTANCE.getConstructor();
                HomeScreenViewsVisibilityState homeScreenViewsVisibilityState12 = homeScreenViewsVisibilityState4;
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
                Composer composerM6062constructorimpl8 = Updater.m6062constructorimpl(composerStartRestartGroup);
                Updater.m6070setimpl(composerM6062constructorimpl8, measurePolicyMaybeCachedBoxMeasurePolicy8, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                Updater.m6070setimpl(composerM6062constructorimpl8, currentCompositionLocalMap8, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                Updater.m6066initimpl(composerM6062constructorimpl8, Integer.valueOf(iHashCode8), ComposeUiNode.INSTANCE.getSetCompositeKeyHash());
                Updater.m6068reconcileimpl(composerM6062constructorimpl8, ComposeUiNode.INSTANCE.getApplyOnDeactivatedNodeAssertion());
                Updater.m6070setimpl(composerM6062constructorimpl8, modifierMaterializeModifier8, ComposeUiNode.INSTANCE.getSetModifier());
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1833054614, "C72@3469L9:Box.kt#2w3rfo");
                BoxScopeInstance boxScopeInstance8 = BoxScopeInstance.INSTANCE;
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1000030181, "C67@3044L195,73@3270L152,64@2866L617:AllFilesScreen.kt#89mwni");
                Modifier.Companion companion8 = Modifier.INSTANCE;
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1971917434, "CC(remember):AllFilesScreen.kt#9igjgp");
                zChanged = composerStartRestartGroup.changed(store);
                objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                if (!zChanged) {
                    objRememberedValue2 = new Function1() { // from class: com.box.android.browse.cpl.browse.AllFilesScreenKt$$ExternalSyntheticLambda3
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            return AllFilesScreenKt.AllFilesScreen$lambda$4$0$0(store, mutableState, ((Boolean) obj).booleanValue());
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                } else {
                    objRememberedValue2 = new Function1() { // from class: com.box.android.browse.cpl.browse.AllFilesScreenKt$$ExternalSyntheticLambda3
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            return AllFilesScreenKt.AllFilesScreen$lambda$4$0$0(store, mutableState, ((Boolean) obj).booleanValue());
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                }
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                Modifier modifierOnVisibilityChanged$default8 = OnVisibilityChangedModifierKt.onVisibilityChanged$default(companion8, 0L, 1.0f, null, (Function1) objRememberedValue2, 5, null);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1971910245, "CC(remember):AllFilesScreen.kt#9igjgp");
                allFilesScreenKt$AllFilesScreen$1$2$1RememberedValue = composerStartRestartGroup.rememberedValue();
                if (allFilesScreenKt$AllFilesScreen$1$2$1RememberedValue == Composer.INSTANCE.getEmpty()) {
                    allFilesScreenKt$AllFilesScreen$1$2$1RememberedValue = new AllFilesScreenKt$AllFilesScreen$1$2$1(snackbarHostState, null);
                    composerStartRestartGroup.updateRememberedValue(allFilesScreenKt$AllFilesScreen$1$2$1RememberedValue);
                }
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                i10 = i8 >> 3;
                composer3 = composerStartRestartGroup;
                int i110 = i8;
                AllFilesContent(store, boxMessageDispatcher, modifierOnVisibilityChanged$default8, (Function4) allFilesScreenKt$AllFilesScreen$1$2$1RememberedValue, z4, composer3, (BoxMessageDispatcher.$stable << 3) | (i8 & 112) | (57344 & i10), 0);
                boolean z13 = z4;
                fabMenuState = AllFilesScreen$lambda$0(stateCollectAsStateWithLifecycle).getFabMenuState();
                if (fabMenuState == null) {
                    composer3.startReplaceGroup(-999408416);
                    composer3.endReplaceGroup();
                    store = store;
                } else {
                    composer3.startReplaceGroup(-999408415);
                    ComposerKt.sourceInformation(composer3, "");
                    if (AllFilesScreen$lambda$0(stateCollectAsStateWithLifecycle).getActionableItemsListState().getIsSelecting()) {
                        composer3.startReplaceGroup(1270513108);
                        ComposerKt.sourceInformation(composer3, "85@3850L40,89@4097L364,82@3680L799");
                        AllFilesScreenKt$AllFilesScreen$1$3$1 allFilesScreenKt$AllFilesScreen$1$3$8 = new PropertyReference1Impl() { // from class: com.box.android.browse.cpl.browse.AllFilesScreenKt$AllFilesScreen$1$3$1
                            @Override // kotlin.jvm.internal.PropertyReference1Impl, kotlin.reflect.KProperty1
                            public Object get(Object obj) {
                                return ((BrowseReducer.State) obj).getFabMenuState();
                            }
                        };
                        ComposerKt.sourceInformationMarkerStart(composer3, 318083639, "CC(remember):AllFilesScreen.kt#9igjgp");
                        allFilesScreenKt$AllFilesScreen$1$3$2$1RememberedValue = composer3.rememberedValue();
                        if (allFilesScreenKt$AllFilesScreen$1$3$2$1RememberedValue == Composer.INSTANCE.getEmpty()) {
                            allFilesScreenKt$AllFilesScreen$1$3$2$1RememberedValue = AllFilesScreenKt$AllFilesScreen$1$3$2$1.INSTANCE;
                            composer3.updateRememberedValue(allFilesScreenKt$AllFilesScreen$1$3$2$1RememberedValue);
                        }
                        ComposerKt.sourceInformationMarkerEnd(composer3);
                        Store<LocalState, LocalAction> storeIfScope8 = store.ifScope(allFilesScreenKt$AllFilesScreen$1$3$8, (Function1) ((KFunction) allFilesScreenKt$AllFilesScreen$1$3$2$1RememberedValue));
                        if (AllFilesScreen$lambda$2(mutableState)) {
                            z5 = false;
                        } else {
                            z5 = false;
                        }
                        ComposerKt.sourceInformationMarkerStart(composer3, 318091867, "CC(remember):AllFilesScreen.kt#9igjgp");
                        zChangedInstance = composer3.changedInstance(navigator) | composer3.changedInstance(fabMenuState);
                        objRememberedValue3 = composer3.rememberedValue();
                        if (!zChangedInstance) {
                            objRememberedValue3 = new Function1() { // from class: com.box.android.browse.cpl.browse.AllFilesScreenKt$$ExternalSyntheticLambda4
                                @Override // kotlin.jvm.functions.Function1
                                public final Object invoke(Object obj) {
                                    return AllFilesScreenKt.AllFilesScreen$lambda$4$2$1$0(navigator, fabMenuState, (String) obj);
                                }
                            };
                            composer3.updateRememberedValue(objRememberedValue3);
                        } else {
                            objRememberedValue3 = new Function1() { // from class: com.box.android.browse.cpl.browse.AllFilesScreenKt$$ExternalSyntheticLambda4
                                @Override // kotlin.jvm.functions.Function1
                                public final Object invoke(Object obj) {
                                    return AllFilesScreenKt.AllFilesScreen$lambda$4$2$1$0(navigator, fabMenuState, (String) obj);
                                }
                            };
                            composer3.updateRememberedValue(objRememberedValue3);
                        }
                        ComposerKt.sourceInformationMarkerEnd(composer3);
                        FilesFabComponentKt.FilesFabComponent(storeIfScope8, snackbarHostState, (Function1) objRememberedValue3, null, z5, composer3, i10 & 112, 8);
                    } else {
                        composer3.startReplaceGroup(1266836787);
                    }
                    composer3.endReplaceGroup();
                    Unit unit15 = Unit.INSTANCE;
                    composer3.endReplaceGroup();
                    Unit unit16 = Unit.INSTANCE;
                }
                ComposerKt.sourceInformationMarkerEnd(composer3);
                ComposerKt.sourceInformationMarkerEnd(composer3);
                composer3.endNode();
                ComposerKt.sourceInformationMarkerEnd(composer3);
                ComposerKt.sourceInformationMarkerEnd(composer3);
                ComposerKt.sourceInformationMarkerEnd(composer3);
                NavigationRouteEffect(AllFilesScreen$lambda$0(stateCollectAsStateWithLifecycle).getNavigationRoute(), navigator, store, composer3, (i110 << 3) & 112);
                SelectionModeViewsVisibilityEffect(AllFilesScreen$lambda$0(stateCollectAsStateWithLifecycle).getActionableItemsListState().getIsSelecting(), homeScreenViewsVisibilityState12, composer3, (i110 >> 9) & 112);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                homeScreenViewsVisibilityState3 = homeScreenViewsVisibilityState12;
                composer2 = composer3;
                modifier3 = modifier1119;
                allFilesViewModel3 = allFilesViewModel4;
                z3 = z13;
            } else {
                composerStartRestartGroup.skipToGroupEnd();
                z3 = z;
                composer2 = composerStartRestartGroup;
                modifier3 = modifier2;
                homeScreenViewsVisibilityState3 = homeScreenViewsVisibilityState2;
                allFilesViewModel3 = allFilesViewModel2;
            }
            scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.box.android.browse.cpl.browse.AllFilesScreenKt$$ExternalSyntheticLambda5
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return AllFilesScreenKt.AllFilesScreen$lambda$5(navigator, boxMessageDispatcher, snackbarHostState, modifier3, homeScreenViewsVisibilityState3, z3, allFilesViewModel3, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                    }
                });
            }
        }
        i3 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
        if ((1572864 & i) == 0) {
            if ((i2 & 64) == 0) {
                allFilesViewModel2 = allFilesViewModel;
                if (composerStartRestartGroup.changedInstance(allFilesViewModel2)) {
                }
                i3 |= i12;
            } else {
                allFilesViewModel2 = allFilesViewModel;
            }
            i3 |= i12;
        } else {
            allFilesViewModel2 = allFilesViewModel;
        }
        if ((599187 & i3) != 599186) {
            z2 = true;
        } else {
            z2 = false;
        }
        if (composerStartRestartGroup.shouldExecute(z2, i3 & 1)) {
            composerStartRestartGroup.startDefaults();
            ComposerKt.sourceInformation(composerStartRestartGroup, "48@2415L23");
            r13 = 0;
            if ((i & 1) != 0) {
                if (i11 != 0) {
                    modifier2 = Modifier.INSTANCE;
                }
                if (i4 != 0) {
                    homeScreenViewsVisibilityState4 = null;
                } else {
                    homeScreenViewsVisibilityState4 = homeScreenViewsVisibilityState2;
                }
                if (i6 != 0) {
                    z4 = false;
                } else {
                    z4 = z;
                }
                if ((i2 & 64) != 0) {
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1447482489, "CC(hiltActivityViewModel)N(key)159@5773L7,160@5813L56:ComposeUtils.kt#vejmn0");
                    ProvidableCompositionLocal<Activity> localActivity14 = LocalActivityKt.getLocalActivity();
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
                    Object objConsume112 = composerStartRestartGroup.consume(localActivity14);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    Intrinsics.checkNotNull(objConsume112, "null cannot be cast to non-null type androidx.activity.ComponentActivity");
                    componentActivity = (ComponentActivity) objConsume112;
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
                    str = "CC(<get-current>):CompositionLocal.kt#9igjgp";
                    r13 = 0;
                    ViewModel viewModel14 = ViewModelKt.viewModel((Class<ViewModel>) AllFilesViewModel.class, componentActivity, (String) null, factoryCreateHiltViewModelFactory14, defaultViewModelCreationExtras, composerStartRestartGroup, 36936, 0);
                    composerStartRestartGroup = composerStartRestartGroup;
                    composerStartRestartGroup.endReplaceableGroup();
                    composerStartRestartGroup.endReplaceableGroup();
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    Modifier modifier11110 = modifier2;
                    i8 = i3 & (-3670017);
                    modifier4 = modifier11110;
                    allFilesViewModel4 = (AllFilesViewModel) viewModel14;
                } else {
                    str = "CC(<get-current>):CompositionLocal.kt#9igjgp";
                    Modifier modifier11111 = modifier2;
                    i8 = i3;
                    modifier4 = modifier11111;
                    allFilesViewModel4 = allFilesViewModel2;
                }
            } else {
                if (i11 != 0) {
                    modifier2 = Modifier.INSTANCE;
                }
                if (i4 != 0) {
                    homeScreenViewsVisibilityState4 = null;
                } else {
                    homeScreenViewsVisibilityState4 = homeScreenViewsVisibilityState2;
                }
                if (i6 != 0) {
                    z4 = false;
                } else {
                    z4 = z;
                }
                if ((i2 & 64) != 0) {
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1447482489, "CC(hiltActivityViewModel)N(key)159@5773L7,160@5813L56:ComposeUtils.kt#vejmn0");
                    ProvidableCompositionLocal<Activity> localActivity15 = LocalActivityKt.getLocalActivity();
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
                    Object objConsume113 = composerStartRestartGroup.consume(localActivity15);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    Intrinsics.checkNotNull(objConsume113, "null cannot be cast to non-null type androidx.activity.ComponentActivity");
                    componentActivity = (ComponentActivity) objConsume113;
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
                    str = "CC(<get-current>):CompositionLocal.kt#9igjgp";
                    r13 = 0;
                    ViewModel viewModel15 = ViewModelKt.viewModel((Class<ViewModel>) AllFilesViewModel.class, componentActivity, (String) null, factoryCreateHiltViewModelFactory15, defaultViewModelCreationExtras, composerStartRestartGroup, 36936, 0);
                    composerStartRestartGroup = composerStartRestartGroup;
                    composerStartRestartGroup.endReplaceableGroup();
                    composerStartRestartGroup.endReplaceableGroup();
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    Modifier modifier11112 = modifier2;
                    i8 = i3 & (-3670017);
                    modifier4 = modifier11112;
                    allFilesViewModel4 = (AllFilesViewModel) viewModel15;
                } else {
                    str = "CC(<get-current>):CompositionLocal.kt#9igjgp";
                    Modifier modifier11113 = modifier2;
                    i8 = i3;
                    modifier4 = modifier11113;
                    allFilesViewModel4 = allFilesViewModel2;
                }
            }
            composerStartRestartGroup.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-2014686211, i8, -1, "com.box.android.browse.cpl.browse.AllFilesScreen (AllFilesScreen.kt:49)");
            }
            store = allFilesViewModel4.getStore();
            stateCollectAsStateWithLifecycle = FlowExtKt.collectAsStateWithLifecycle(store.getState(), (LifecycleOwner) null, (Lifecycle.State) null, (CoroutineContext) null, composerStartRestartGroup, 0, 7);
            ProvidableCompositionLocal<Boolean> providableCompositionLocal9 = LocalFabInitiallyVisible;
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, str);
            Object objConsume114 = composerStartRestartGroup.consume(providableCompositionLocal9);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            zBooleanValue = ((Boolean) objConsume114).booleanValue();
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 916818969, "CC(remember):AllFilesScreen.kt#9igjgp");
            objRememberedValue = composerStartRestartGroup.rememberedValue();
            if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                i9 = 2;
                objRememberedValue = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(Boolean.valueOf(zBooleanValue), r13, 2, r13);
                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
            } else {
                i9 = 2;
            }
            mutableState = (MutableState) objRememberedValue;
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ScrollAwareFabVisibility scrollAwareFabVisibilityRememberScrollAwareFabVisibility9 = ScrollAwareFabVisibilityKt.rememberScrollAwareFabVisibility(composerStartRestartGroup, 0);
            Modifier modifierNestedScroll$default9 = NestedScrollModifierKt.nestedScroll$default(SizeKt.fillMaxSize$default(modifier4, 0.0f, 1, r13), scrollAwareFabVisibilityRememberScrollAwareFabVisibility9, r13, i9, r13);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1042775818, "CC(Box)N(modifier,contentAlignment,propagateMinConstraints,content)71@3424L131:Box.kt#2w3rfo");
            MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy9 = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), false);
            Modifier modifier11114 = modifier4;
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
            int iHashCode9 = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
            CompositionLocalMap currentCompositionLocalMap9 = composerStartRestartGroup.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier9 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierNestedScroll$default9);
            constructor = ComposeUiNode.INSTANCE.getConstructor();
            HomeScreenViewsVisibilityState homeScreenViewsVisibilityState13 = homeScreenViewsVisibilityState4;
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
            Composer composerM6062constructorimpl9 = Updater.m6062constructorimpl(composerStartRestartGroup);
            Updater.m6070setimpl(composerM6062constructorimpl9, measurePolicyMaybeCachedBoxMeasurePolicy9, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
            Updater.m6070setimpl(composerM6062constructorimpl9, currentCompositionLocalMap9, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
            Updater.m6066initimpl(composerM6062constructorimpl9, Integer.valueOf(iHashCode9), ComposeUiNode.INSTANCE.getSetCompositeKeyHash());
            Updater.m6068reconcileimpl(composerM6062constructorimpl9, ComposeUiNode.INSTANCE.getApplyOnDeactivatedNodeAssertion());
            Updater.m6070setimpl(composerM6062constructorimpl9, modifierMaterializeModifier9, ComposeUiNode.INSTANCE.getSetModifier());
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1833054614, "C72@3469L9:Box.kt#2w3rfo");
            BoxScopeInstance boxScopeInstance9 = BoxScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1000030181, "C67@3044L195,73@3270L152,64@2866L617:AllFilesScreen.kt#89mwni");
            Modifier.Companion companion9 = Modifier.INSTANCE;
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1971917434, "CC(remember):AllFilesScreen.kt#9igjgp");
            zChanged = composerStartRestartGroup.changed(store);
            objRememberedValue2 = composerStartRestartGroup.rememberedValue();
            if (!zChanged) {
                objRememberedValue2 = new Function1() { // from class: com.box.android.browse.cpl.browse.AllFilesScreenKt$$ExternalSyntheticLambda3
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return AllFilesScreenKt.AllFilesScreen$lambda$4$0$0(store, mutableState, ((Boolean) obj).booleanValue());
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
            } else {
                objRememberedValue2 = new Function1() { // from class: com.box.android.browse.cpl.browse.AllFilesScreenKt$$ExternalSyntheticLambda3
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return AllFilesScreenKt.AllFilesScreen$lambda$4$0$0(store, mutableState, ((Boolean) obj).booleanValue());
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
            }
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            Modifier modifierOnVisibilityChanged$default9 = OnVisibilityChangedModifierKt.onVisibilityChanged$default(companion9, 0L, 1.0f, null, (Function1) objRememberedValue2, 5, null);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1971910245, "CC(remember):AllFilesScreen.kt#9igjgp");
            allFilesScreenKt$AllFilesScreen$1$2$1RememberedValue = composerStartRestartGroup.rememberedValue();
            if (allFilesScreenKt$AllFilesScreen$1$2$1RememberedValue == Composer.INSTANCE.getEmpty()) {
                allFilesScreenKt$AllFilesScreen$1$2$1RememberedValue = new AllFilesScreenKt$AllFilesScreen$1$2$1(snackbarHostState, null);
                composerStartRestartGroup.updateRememberedValue(allFilesScreenKt$AllFilesScreen$1$2$1RememberedValue);
            }
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            i10 = i8 >> 3;
            composer3 = composerStartRestartGroup;
            int i111 = i8;
            AllFilesContent(store, boxMessageDispatcher, modifierOnVisibilityChanged$default9, (Function4) allFilesScreenKt$AllFilesScreen$1$2$1RememberedValue, z4, composer3, (BoxMessageDispatcher.$stable << 3) | (i8 & 112) | (57344 & i10), 0);
            boolean z14 = z4;
            fabMenuState = AllFilesScreen$lambda$0(stateCollectAsStateWithLifecycle).getFabMenuState();
            if (fabMenuState == null) {
                composer3.startReplaceGroup(-999408416);
                composer3.endReplaceGroup();
                store = store;
            } else {
                composer3.startReplaceGroup(-999408415);
                ComposerKt.sourceInformation(composer3, "");
                if (AllFilesScreen$lambda$0(stateCollectAsStateWithLifecycle).getActionableItemsListState().getIsSelecting()) {
                    composer3.startReplaceGroup(1270513108);
                    ComposerKt.sourceInformation(composer3, "85@3850L40,89@4097L364,82@3680L799");
                    AllFilesScreenKt$AllFilesScreen$1$3$1 allFilesScreenKt$AllFilesScreen$1$3$9 = new PropertyReference1Impl() { // from class: com.box.android.browse.cpl.browse.AllFilesScreenKt$AllFilesScreen$1$3$1
                        @Override // kotlin.jvm.internal.PropertyReference1Impl, kotlin.reflect.KProperty1
                        public Object get(Object obj) {
                            return ((BrowseReducer.State) obj).getFabMenuState();
                        }
                    };
                    ComposerKt.sourceInformationMarkerStart(composer3, 318083639, "CC(remember):AllFilesScreen.kt#9igjgp");
                    allFilesScreenKt$AllFilesScreen$1$3$2$1RememberedValue = composer3.rememberedValue();
                    if (allFilesScreenKt$AllFilesScreen$1$3$2$1RememberedValue == Composer.INSTANCE.getEmpty()) {
                        allFilesScreenKt$AllFilesScreen$1$3$2$1RememberedValue = AllFilesScreenKt$AllFilesScreen$1$3$2$1.INSTANCE;
                        composer3.updateRememberedValue(allFilesScreenKt$AllFilesScreen$1$3$2$1RememberedValue);
                    }
                    ComposerKt.sourceInformationMarkerEnd(composer3);
                    Store<LocalState, LocalAction> storeIfScope9 = store.ifScope(allFilesScreenKt$AllFilesScreen$1$3$9, (Function1) ((KFunction) allFilesScreenKt$AllFilesScreen$1$3$2$1RememberedValue));
                    if (AllFilesScreen$lambda$2(mutableState)) {
                        z5 = false;
                    } else {
                        z5 = false;
                    }
                    ComposerKt.sourceInformationMarkerStart(composer3, 318091867, "CC(remember):AllFilesScreen.kt#9igjgp");
                    zChangedInstance = composer3.changedInstance(navigator) | composer3.changedInstance(fabMenuState);
                    objRememberedValue3 = composer3.rememberedValue();
                    if (!zChangedInstance) {
                        objRememberedValue3 = new Function1() { // from class: com.box.android.browse.cpl.browse.AllFilesScreenKt$$ExternalSyntheticLambda4
                            @Override // kotlin.jvm.functions.Function1
                            public final Object invoke(Object obj) {
                                return AllFilesScreenKt.AllFilesScreen$lambda$4$2$1$0(navigator, fabMenuState, (String) obj);
                            }
                        };
                        composer3.updateRememberedValue(objRememberedValue3);
                    } else {
                        objRememberedValue3 = new Function1() { // from class: com.box.android.browse.cpl.browse.AllFilesScreenKt$$ExternalSyntheticLambda4
                            @Override // kotlin.jvm.functions.Function1
                            public final Object invoke(Object obj) {
                                return AllFilesScreenKt.AllFilesScreen$lambda$4$2$1$0(navigator, fabMenuState, (String) obj);
                            }
                        };
                        composer3.updateRememberedValue(objRememberedValue3);
                    }
                    ComposerKt.sourceInformationMarkerEnd(composer3);
                    FilesFabComponentKt.FilesFabComponent(storeIfScope9, snackbarHostState, (Function1) objRememberedValue3, null, z5, composer3, i10 & 112, 8);
                } else {
                    composer3.startReplaceGroup(1266836787);
                }
                composer3.endReplaceGroup();
                Unit unit17 = Unit.INSTANCE;
                composer3.endReplaceGroup();
                Unit unit18 = Unit.INSTANCE;
            }
            ComposerKt.sourceInformationMarkerEnd(composer3);
            ComposerKt.sourceInformationMarkerEnd(composer3);
            composer3.endNode();
            ComposerKt.sourceInformationMarkerEnd(composer3);
            ComposerKt.sourceInformationMarkerEnd(composer3);
            ComposerKt.sourceInformationMarkerEnd(composer3);
            NavigationRouteEffect(AllFilesScreen$lambda$0(stateCollectAsStateWithLifecycle).getNavigationRoute(), navigator, store, composer3, (i111 << 3) & 112);
            SelectionModeViewsVisibilityEffect(AllFilesScreen$lambda$0(stateCollectAsStateWithLifecycle).getActionableItemsListState().getIsSelecting(), homeScreenViewsVisibilityState13, composer3, (i111 >> 9) & 112);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            homeScreenViewsVisibilityState3 = homeScreenViewsVisibilityState13;
            composer2 = composer3;
            modifier3 = modifier11114;
            allFilesViewModel3 = allFilesViewModel4;
            z3 = z14;
        } else {
            composerStartRestartGroup.skipToGroupEnd();
            z3 = z;
            composer2 = composerStartRestartGroup;
            modifier3 = modifier2;
            homeScreenViewsVisibilityState3 = homeScreenViewsVisibilityState2;
            allFilesViewModel3 = allFilesViewModel2;
        }
        scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.box.android.browse.cpl.browse.AllFilesScreenKt$$ExternalSyntheticLambda5
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return AllFilesScreenKt.AllFilesScreen$lambda$5(navigator, boxMessageDispatcher, snackbarHostState, modifier3, homeScreenViewsVisibilityState3, z3, allFilesViewModel3, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    private static final boolean AllFilesScreen$lambda$2(MutableState<Boolean> mutableState) {
        return mutableState.getValue().booleanValue();
    }

    private static final void AllFilesScreen$lambda$3(MutableState<Boolean> mutableState, boolean z) {
        mutableState.setValue(Boolean.valueOf(z));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit AllFilesScreen$lambda$4$0$0(Store store, MutableState mutableState, boolean z) {
        if (z) {
            store.send(BrowseReducer.Action.TabVisible.INSTANCE);
        }
        AllFilesScreen$lambda$3(mutableState, z);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit AllFilesScreen$lambda$4$2$1$0(BrowseNavigator browseNavigator, FilesFabReducer.State state, String fileTypeAssetName) {
        Intrinsics.checkNotNullParameter(fileTypeAssetName, "fileTypeAssetName");
        browseNavigator.navigateTo(new BrowseDestination.OuterDestination.CreateNewDocument(state.getCurrentFolder(), fileTypeAssetName));
        return Unit.INSTANCE;
    }

    /* JADX WARN: Code duplicated, block: B:100:0x0185  */
    /* JADX WARN: Code duplicated, block: B:102:0x018d  */
    /* JADX WARN: Code duplicated, block: B:105:0x019a  */
    /* JADX WARN: Code duplicated, block: B:107:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:33:0x0069  */
    /* JADX WARN: Code duplicated, block: B:34:0x006c  */
    /* JADX WARN: Code duplicated, block: B:36:0x0070  */
    /* JADX WARN: Code duplicated, block: B:38:0x0078  */
    /* JADX WARN: Code duplicated, block: B:39:0x007b  */
    /* JADX WARN: Code duplicated, block: B:44:0x0085  */
    /* JADX WARN: Code duplicated, block: B:45:0x0088  */
    /* JADX WARN: Code duplicated, block: B:47:0x008c  */
    /* JADX WARN: Code duplicated, block: B:49:0x0094  */
    /* JADX WARN: Code duplicated, block: B:50:0x0097  */
    /* JADX WARN: Code duplicated, block: B:55:0x00a7  */
    /* JADX WARN: Code duplicated, block: B:56:0x00a9  */
    /* JADX WARN: Code duplicated, block: B:59:0x00b3 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:60:0x00b5  */
    /* JADX WARN: Code duplicated, block: B:61:0x00bb  */
    /* JADX WARN: Code duplicated, block: B:64:0x00bf  */
    /* JADX WARN: Code duplicated, block: B:65:0x00c2  */
    /* JADX WARN: Code duplicated, block: B:67:0x00c6  */
    /* JADX WARN: Code duplicated, block: B:70:0x00ce  */
    /* JADX WARN: Code duplicated, block: B:73:0x00e2  */
    /* JADX WARN: Code duplicated, block: B:74:0x00e4  */
    /* JADX WARN: Code duplicated, block: B:77:0x00ec  */
    /* JADX WARN: Code duplicated, block: B:79:0x00f4  */
    /* JADX WARN: Code duplicated, block: B:82:0x0112  */
    /* JADX WARN: Code duplicated, block: B:83:0x0114  */
    /* JADX WARN: Code duplicated, block: B:86:0x011c  */
    /* JADX WARN: Code duplicated, block: B:88:0x0124  */
    /* JADX WARN: Code duplicated, block: B:92:0x0141  */
    /* JADX WARN: Code duplicated, block: B:95:0x0149  */
    /* JADX WARN: Code duplicated, block: B:97:0x0151  */
    public static final void AllFilesContent(final Store<BrowseReducer.State, BrowseReducer.Action> store, final BoxMessageDispatcher boxMessageDispatcher, Modifier modifier, Function4<? super String, ? super String, ? super SnackbarDuration, ? super Continuation<? super SnackbarResult>, ? extends Object> function4, boolean z, Composer composer, final int i, final int i2) {
        int i3;
        Modifier modifier2;
        int i4;
        Function4<? super String, ? super String, ? super SnackbarDuration, ? super Continuation<? super SnackbarResult>, ? extends Object> function5;
        int i5;
        int i6;
        boolean z2;
        int i7;
        int i8;
        boolean z3;
        final Modifier modifier3;
        final Function4<? super String, ? super String, ? super SnackbarDuration, ? super Continuation<? super SnackbarResult>, ? extends Object> function6;
        final boolean z4;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        Modifier modifier4;
        Function4<? super String, ? super String, ? super SnackbarDuration, ? super Continuation<? super SnackbarResult>, ? extends Object> function7;
        int i9;
        boolean z5;
        AllFilesScreenKt$AllFilesContent$1$1 allFilesScreenKt$AllFilesContent$1$1RememberedValue;
        boolean z6;
        Object objRememberedValue;
        boolean z7;
        Object objRememberedValue2;
        Intrinsics.checkNotNullParameter(store, "store");
        Intrinsics.checkNotNullParameter(boxMessageDispatcher, "boxMessageDispatcher");
        Composer composerStartRestartGroup = composer.startRestartGroup(443371213);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(AllFilesContent)N(store,boxMessageDispatcher,modifier,onShowSnackbar,shouldUseAiCenter)122@5194L89,122@5173L110,126@5317L557,126@5289L585,144@5927L127,144@5880L174,150@6060L195:AllFilesScreen.kt#89mwni");
        if ((i & 6) == 0) {
            i3 = (composerStartRestartGroup.changed(store) ? 4 : 2) | i;
        } else {
            i3 = i;
        }
        if ((i & 48) == 0) {
            i3 |= (i & 64) == 0 ? composerStartRestartGroup.changed(boxMessageDispatcher) : composerStartRestartGroup.changedInstance(boxMessageDispatcher) ? 32 : 16;
        }
        int i10 = i2 & 4;
        if (i10 == 0) {
            if ((i & 384) == 0) {
                modifier2 = modifier;
                i3 |= composerStartRestartGroup.changed(modifier2) ? 256 : 128;
            }
            i4 = i2 & 8;
            if (i4 != 0) {
                if ((i & 3072) == 0) {
                    function5 = function4;
                    if (composerStartRestartGroup.changedInstance(function5)) {
                        i5 = 2048;
                    } else {
                        i5 = 1024;
                    }
                    i3 |= i5;
                }
                i6 = i2 & 16;
                if (i6 != 0) {
                    if ((i & 24576) == 0) {
                        z2 = z;
                        if (composerStartRestartGroup.changed(z2)) {
                            i7 = 16384;
                        } else {
                            i7 = 8192;
                        }
                        i3 |= i7;
                    }
                    i8 = i3;
                    if ((i8 & 9363) != 9362) {
                        z3 = true;
                    } else {
                        z3 = false;
                    }
                    if (composerStartRestartGroup.shouldExecute(z3, i8 & 1)) {
                        composerStartRestartGroup.skipToGroupEnd();
                        modifier3 = modifier2;
                        function6 = function5;
                        z4 = z2;
                    } else {
                        if (i10 != 0) {
                            modifier4 = Modifier.INSTANCE;
                        } else {
                            modifier4 = modifier2;
                        }
                        if (i4 != 0) {
                            function7 = null;
                        } else {
                            function7 = function5;
                        }
                        if (i6 != 0) {
                            z2 = false;
                        }
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(443371213, i8, -1, "com.box.android.browse.cpl.browse.AllFilesContent (AllFilesScreen.kt:121)");
                        }
                        Unit unit = Unit.INSTANCE;
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 877984934, "CC(remember):AllFilesScreen.kt#9igjgp");
                        i9 = i8 & 14;
                        if (i9 == 4) {
                            z5 = true;
                        } else {
                            z5 = false;
                        }
                        allFilesScreenKt$AllFilesContent$1$1RememberedValue = composerStartRestartGroup.rememberedValue();
                        if (!z5 || allFilesScreenKt$AllFilesContent$1$1RememberedValue == Composer.INSTANCE.getEmpty()) {
                            allFilesScreenKt$AllFilesContent$1$1RememberedValue = new AllFilesScreenKt$AllFilesContent$1$1(store, null);
                            composerStartRestartGroup.updateRememberedValue(allFilesScreenKt$AllFilesContent$1$1RememberedValue);
                        }
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        EffectsKt.LaunchedEffect(unit, (Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object>) allFilesScreenKt$AllFilesContent$1$1RememberedValue, composerStartRestartGroup, 6);
                        Unit unit2 = Unit.INSTANCE;
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 877989338, "CC(remember):AllFilesScreen.kt#9igjgp");
                        if (i9 == 4) {
                            z6 = true;
                        } else {
                            z6 = false;
                        }
                        objRememberedValue = composerStartRestartGroup.rememberedValue();
                        if (!z6 || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                            objRememberedValue = new Function1() { // from class: com.box.android.browse.cpl.browse.AllFilesScreenKt$$ExternalSyntheticLambda6
                                @Override // kotlin.jvm.functions.Function1
                                public final Object invoke(Object obj) {
                                    return AllFilesScreenKt.AllFilesContent$lambda$1$0(store, (LifecycleResumePauseEffectScope) obj);
                                }
                            };
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                        }
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        LifecycleEffectKt.LifecycleResumeEffect(unit2, (LifecycleOwner) null, (Function1<? super LifecycleResumePauseEffectScope, ? extends LifecyclePauseOrDisposeEffectResult>) objRememberedValue, composerStartRestartGroup, 6, 2);
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 878008428, "CC(remember):AllFilesScreen.kt#9igjgp");
                        z7 = i9 == 4;
                        objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                        if (!z7 || objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                            objRememberedValue2 = new Function1() { // from class: com.box.android.browse.cpl.browse.AllFilesScreenKt$$ExternalSyntheticLambda7
                                @Override // kotlin.jvm.functions.Function1
                                public final Object invoke(Object obj) {
                                    return AllFilesScreenKt.AllFilesContent$lambda$2$0(store, (BoxMessage) obj);
                                }
                            };
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                        }
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        int i11 = i8 >> 3;
                        BoxMessageListenerEffectKt.BoxMessageListenerEffect(boxMessageDispatcher, (Function1) objRememberedValue2, composerStartRestartGroup, BoxMessageDispatcher.$stable | (i11 & 14));
                        int i12 = i9 | 3072 | (i11 & 112) | (i11 & 896) | (57344 & i8);
                        boolean z8 = z2;
                        Modifier modifier5 = modifier4;
                        Function4<? super String, ? super String, ? super SnackbarDuration, ? super Continuation<? super SnackbarResult>, ? extends Object> function8 = function7;
                        BrowseContentKt.BrowseContent(store, modifier5, function8, true, z8, composerStartRestartGroup, i12, 0);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        modifier3 = modifier5;
                        z4 = z8;
                        function6 = function8;
                    }
                    scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup != null) {
                        scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.box.android.browse.cpl.browse.AllFilesScreenKt$$ExternalSyntheticLambda8
                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj, Object obj2) {
                                return AllFilesScreenKt.AllFilesContent$lambda$3(store, boxMessageDispatcher, modifier3, function6, z4, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                            }
                        });
                    }
                }
                i3 |= 24576;
                z2 = z;
                i8 = i3;
                if ((i8 & 9363) != 9362) {
                    z3 = true;
                } else {
                    z3 = false;
                }
                if (composerStartRestartGroup.shouldExecute(z3, i8 & 1)) {
                    composerStartRestartGroup.skipToGroupEnd();
                    modifier3 = modifier2;
                    function6 = function5;
                    z4 = z2;
                } else {
                    if (i10 != 0) {
                        modifier4 = Modifier.INSTANCE;
                    } else {
                        modifier4 = modifier2;
                    }
                    if (i4 != 0) {
                        function7 = null;
                    } else {
                        function7 = function5;
                    }
                    if (i6 != 0) {
                        z2 = false;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(443371213, i8, -1, "com.box.android.browse.cpl.browse.AllFilesContent (AllFilesScreen.kt:121)");
                    }
                    Unit unit3 = Unit.INSTANCE;
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 877984934, "CC(remember):AllFilesScreen.kt#9igjgp");
                    i9 = i8 & 14;
                    if (i9 == 4) {
                        z5 = true;
                    } else {
                        z5 = false;
                    }
                    allFilesScreenKt$AllFilesContent$1$1RememberedValue = composerStartRestartGroup.rememberedValue();
                    if (!z5) {
                        allFilesScreenKt$AllFilesContent$1$1RememberedValue = new AllFilesScreenKt$AllFilesContent$1$1(store, null);
                        composerStartRestartGroup.updateRememberedValue(allFilesScreenKt$AllFilesContent$1$1RememberedValue);
                    } else {
                        allFilesScreenKt$AllFilesContent$1$1RememberedValue = new AllFilesScreenKt$AllFilesContent$1$1(store, null);
                        composerStartRestartGroup.updateRememberedValue(allFilesScreenKt$AllFilesContent$1$1RememberedValue);
                    }
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    EffectsKt.LaunchedEffect(unit3, (Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object>) allFilesScreenKt$AllFilesContent$1$1RememberedValue, composerStartRestartGroup, 6);
                    Unit unit4 = Unit.INSTANCE;
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 877989338, "CC(remember):AllFilesScreen.kt#9igjgp");
                    if (i9 == 4) {
                        z6 = true;
                    } else {
                        z6 = false;
                    }
                    objRememberedValue = composerStartRestartGroup.rememberedValue();
                    if (!z6) {
                        objRememberedValue = new Function1() { // from class: com.box.android.browse.cpl.browse.AllFilesScreenKt$$ExternalSyntheticLambda6
                            @Override // kotlin.jvm.functions.Function1
                            public final Object invoke(Object obj) {
                                return AllFilesScreenKt.AllFilesContent$lambda$1$0(store, (LifecycleResumePauseEffectScope) obj);
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                    } else {
                        objRememberedValue = new Function1() { // from class: com.box.android.browse.cpl.browse.AllFilesScreenKt$$ExternalSyntheticLambda6
                            @Override // kotlin.jvm.functions.Function1
                            public final Object invoke(Object obj) {
                                return AllFilesScreenKt.AllFilesContent$lambda$1$0(store, (LifecycleResumePauseEffectScope) obj);
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                    }
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    LifecycleEffectKt.LifecycleResumeEffect(unit4, (LifecycleOwner) null, (Function1<? super LifecycleResumePauseEffectScope, ? extends LifecyclePauseOrDisposeEffectResult>) objRememberedValue, composerStartRestartGroup, 6, 2);
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 878008428, "CC(remember):AllFilesScreen.kt#9igjgp");
                    if (i9 == 4) {
                    }
                    objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                    if (!z7) {
                        objRememberedValue2 = new Function1() { // from class: com.box.android.browse.cpl.browse.AllFilesScreenKt$$ExternalSyntheticLambda7
                            @Override // kotlin.jvm.functions.Function1
                            public final Object invoke(Object obj) {
                                return AllFilesScreenKt.AllFilesContent$lambda$2$0(store, (BoxMessage) obj);
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                    } else {
                        objRememberedValue2 = new Function1() { // from class: com.box.android.browse.cpl.browse.AllFilesScreenKt$$ExternalSyntheticLambda7
                            @Override // kotlin.jvm.functions.Function1
                            public final Object invoke(Object obj) {
                                return AllFilesScreenKt.AllFilesContent$lambda$2$0(store, (BoxMessage) obj);
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                    }
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    int i13 = i8 >> 3;
                    BoxMessageListenerEffectKt.BoxMessageListenerEffect(boxMessageDispatcher, (Function1) objRememberedValue2, composerStartRestartGroup, BoxMessageDispatcher.$stable | (i13 & 14));
                    int i14 = i9 | 3072 | (i13 & 112) | (i13 & 896) | (57344 & i8);
                    boolean z9 = z2;
                    Modifier modifier6 = modifier4;
                    Function4<? super String, ? super String, ? super SnackbarDuration, ? super Continuation<? super SnackbarResult>, ? extends Object> function9 = function7;
                    BrowseContentKt.BrowseContent(store, modifier6, function9, true, z9, composerStartRestartGroup, i14, 0);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    modifier3 = modifier6;
                    z4 = z9;
                    function6 = function9;
                }
                scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.box.android.browse.cpl.browse.AllFilesScreenKt$$ExternalSyntheticLambda8
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return AllFilesScreenKt.AllFilesContent$lambda$3(store, boxMessageDispatcher, modifier3, function6, z4, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    });
                }
            }
            i3 |= 3072;
            function5 = function4;
            i6 = i2 & 16;
            if (i6 != 0) {
                if ((i & 24576) == 0) {
                    z2 = z;
                    if (composerStartRestartGroup.changed(z2)) {
                        i7 = 16384;
                    } else {
                        i7 = 8192;
                    }
                    i3 |= i7;
                }
                i8 = i3;
                if ((i8 & 9363) != 9362) {
                    z3 = true;
                } else {
                    z3 = false;
                }
                if (composerStartRestartGroup.shouldExecute(z3, i8 & 1)) {
                    composerStartRestartGroup.skipToGroupEnd();
                    modifier3 = modifier2;
                    function6 = function5;
                    z4 = z2;
                } else {
                    if (i10 != 0) {
                        modifier4 = Modifier.INSTANCE;
                    } else {
                        modifier4 = modifier2;
                    }
                    if (i4 != 0) {
                        function7 = null;
                    } else {
                        function7 = function5;
                    }
                    if (i6 != 0) {
                        z2 = false;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(443371213, i8, -1, "com.box.android.browse.cpl.browse.AllFilesContent (AllFilesScreen.kt:121)");
                    }
                    Unit unit5 = Unit.INSTANCE;
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 877984934, "CC(remember):AllFilesScreen.kt#9igjgp");
                    i9 = i8 & 14;
                    if (i9 == 4) {
                        z5 = true;
                    } else {
                        z5 = false;
                    }
                    allFilesScreenKt$AllFilesContent$1$1RememberedValue = composerStartRestartGroup.rememberedValue();
                    if (!z5) {
                        allFilesScreenKt$AllFilesContent$1$1RememberedValue = new AllFilesScreenKt$AllFilesContent$1$1(store, null);
                        composerStartRestartGroup.updateRememberedValue(allFilesScreenKt$AllFilesContent$1$1RememberedValue);
                    } else {
                        allFilesScreenKt$AllFilesContent$1$1RememberedValue = new AllFilesScreenKt$AllFilesContent$1$1(store, null);
                        composerStartRestartGroup.updateRememberedValue(allFilesScreenKt$AllFilesContent$1$1RememberedValue);
                    }
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    EffectsKt.LaunchedEffect(unit5, (Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object>) allFilesScreenKt$AllFilesContent$1$1RememberedValue, composerStartRestartGroup, 6);
                    Unit unit6 = Unit.INSTANCE;
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 877989338, "CC(remember):AllFilesScreen.kt#9igjgp");
                    if (i9 == 4) {
                        z6 = true;
                    } else {
                        z6 = false;
                    }
                    objRememberedValue = composerStartRestartGroup.rememberedValue();
                    if (!z6) {
                        objRememberedValue = new Function1() { // from class: com.box.android.browse.cpl.browse.AllFilesScreenKt$$ExternalSyntheticLambda6
                            @Override // kotlin.jvm.functions.Function1
                            public final Object invoke(Object obj) {
                                return AllFilesScreenKt.AllFilesContent$lambda$1$0(store, (LifecycleResumePauseEffectScope) obj);
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                    } else {
                        objRememberedValue = new Function1() { // from class: com.box.android.browse.cpl.browse.AllFilesScreenKt$$ExternalSyntheticLambda6
                            @Override // kotlin.jvm.functions.Function1
                            public final Object invoke(Object obj) {
                                return AllFilesScreenKt.AllFilesContent$lambda$1$0(store, (LifecycleResumePauseEffectScope) obj);
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                    }
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    LifecycleEffectKt.LifecycleResumeEffect(unit6, (LifecycleOwner) null, (Function1<? super LifecycleResumePauseEffectScope, ? extends LifecyclePauseOrDisposeEffectResult>) objRememberedValue, composerStartRestartGroup, 6, 2);
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 878008428, "CC(remember):AllFilesScreen.kt#9igjgp");
                    if (i9 == 4) {
                    }
                    objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                    if (!z7) {
                        objRememberedValue2 = new Function1() { // from class: com.box.android.browse.cpl.browse.AllFilesScreenKt$$ExternalSyntheticLambda7
                            @Override // kotlin.jvm.functions.Function1
                            public final Object invoke(Object obj) {
                                return AllFilesScreenKt.AllFilesContent$lambda$2$0(store, (BoxMessage) obj);
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                    } else {
                        objRememberedValue2 = new Function1() { // from class: com.box.android.browse.cpl.browse.AllFilesScreenKt$$ExternalSyntheticLambda7
                            @Override // kotlin.jvm.functions.Function1
                            public final Object invoke(Object obj) {
                                return AllFilesScreenKt.AllFilesContent$lambda$2$0(store, (BoxMessage) obj);
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                    }
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    int i15 = i8 >> 3;
                    BoxMessageListenerEffectKt.BoxMessageListenerEffect(boxMessageDispatcher, (Function1) objRememberedValue2, composerStartRestartGroup, BoxMessageDispatcher.$stable | (i15 & 14));
                    int i16 = i9 | 3072 | (i15 & 112) | (i15 & 896) | (57344 & i8);
                    boolean z10 = z2;
                    Modifier modifier7 = modifier4;
                    Function4<? super String, ? super String, ? super SnackbarDuration, ? super Continuation<? super SnackbarResult>, ? extends Object> function10 = function7;
                    BrowseContentKt.BrowseContent(store, modifier7, function10, true, z10, composerStartRestartGroup, i16, 0);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    modifier3 = modifier7;
                    z4 = z10;
                    function6 = function10;
                }
                scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.box.android.browse.cpl.browse.AllFilesScreenKt$$ExternalSyntheticLambda8
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return AllFilesScreenKt.AllFilesContent$lambda$3(store, boxMessageDispatcher, modifier3, function6, z4, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    });
                }
            }
            i3 |= 24576;
            z2 = z;
            i8 = i3;
            if ((i8 & 9363) != 9362) {
                z3 = true;
            } else {
                z3 = false;
            }
            if (composerStartRestartGroup.shouldExecute(z3, i8 & 1)) {
                composerStartRestartGroup.skipToGroupEnd();
                modifier3 = modifier2;
                function6 = function5;
                z4 = z2;
            } else {
                if (i10 != 0) {
                    modifier4 = Modifier.INSTANCE;
                } else {
                    modifier4 = modifier2;
                }
                if (i4 != 0) {
                    function7 = null;
                } else {
                    function7 = function5;
                }
                if (i6 != 0) {
                    z2 = false;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(443371213, i8, -1, "com.box.android.browse.cpl.browse.AllFilesContent (AllFilesScreen.kt:121)");
                }
                Unit unit7 = Unit.INSTANCE;
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 877984934, "CC(remember):AllFilesScreen.kt#9igjgp");
                i9 = i8 & 14;
                if (i9 == 4) {
                    z5 = true;
                } else {
                    z5 = false;
                }
                allFilesScreenKt$AllFilesContent$1$1RememberedValue = composerStartRestartGroup.rememberedValue();
                if (!z5) {
                    allFilesScreenKt$AllFilesContent$1$1RememberedValue = new AllFilesScreenKt$AllFilesContent$1$1(store, null);
                    composerStartRestartGroup.updateRememberedValue(allFilesScreenKt$AllFilesContent$1$1RememberedValue);
                } else {
                    allFilesScreenKt$AllFilesContent$1$1RememberedValue = new AllFilesScreenKt$AllFilesContent$1$1(store, null);
                    composerStartRestartGroup.updateRememberedValue(allFilesScreenKt$AllFilesContent$1$1RememberedValue);
                }
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                EffectsKt.LaunchedEffect(unit7, (Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object>) allFilesScreenKt$AllFilesContent$1$1RememberedValue, composerStartRestartGroup, 6);
                Unit unit8 = Unit.INSTANCE;
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 877989338, "CC(remember):AllFilesScreen.kt#9igjgp");
                if (i9 == 4) {
                    z6 = true;
                } else {
                    z6 = false;
                }
                objRememberedValue = composerStartRestartGroup.rememberedValue();
                if (!z6) {
                    objRememberedValue = new Function1() { // from class: com.box.android.browse.cpl.browse.AllFilesScreenKt$$ExternalSyntheticLambda6
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            return AllFilesScreenKt.AllFilesContent$lambda$1$0(store, (LifecycleResumePauseEffectScope) obj);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                } else {
                    objRememberedValue = new Function1() { // from class: com.box.android.browse.cpl.browse.AllFilesScreenKt$$ExternalSyntheticLambda6
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            return AllFilesScreenKt.AllFilesContent$lambda$1$0(store, (LifecycleResumePauseEffectScope) obj);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                }
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                LifecycleEffectKt.LifecycleResumeEffect(unit8, (LifecycleOwner) null, (Function1<? super LifecycleResumePauseEffectScope, ? extends LifecyclePauseOrDisposeEffectResult>) objRememberedValue, composerStartRestartGroup, 6, 2);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 878008428, "CC(remember):AllFilesScreen.kt#9igjgp");
                if (i9 == 4) {
                }
                objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                if (!z7) {
                    objRememberedValue2 = new Function1() { // from class: com.box.android.browse.cpl.browse.AllFilesScreenKt$$ExternalSyntheticLambda7
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            return AllFilesScreenKt.AllFilesContent$lambda$2$0(store, (BoxMessage) obj);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                } else {
                    objRememberedValue2 = new Function1() { // from class: com.box.android.browse.cpl.browse.AllFilesScreenKt$$ExternalSyntheticLambda7
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            return AllFilesScreenKt.AllFilesContent$lambda$2$0(store, (BoxMessage) obj);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                }
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                int i17 = i8 >> 3;
                BoxMessageListenerEffectKt.BoxMessageListenerEffect(boxMessageDispatcher, (Function1) objRememberedValue2, composerStartRestartGroup, BoxMessageDispatcher.$stable | (i17 & 14));
                int i18 = i9 | 3072 | (i17 & 112) | (i17 & 896) | (57344 & i8);
                boolean z11 = z2;
                Modifier modifier8 = modifier4;
                Function4<? super String, ? super String, ? super SnackbarDuration, ? super Continuation<? super SnackbarResult>, ? extends Object> function11 = function7;
                BrowseContentKt.BrowseContent(store, modifier8, function11, true, z11, composerStartRestartGroup, i18, 0);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                modifier3 = modifier8;
                z4 = z11;
                function6 = function11;
            }
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.box.android.browse.cpl.browse.AllFilesScreenKt$$ExternalSyntheticLambda8
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return AllFilesScreenKt.AllFilesContent$lambda$3(store, boxMessageDispatcher, modifier3, function6, z4, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                    }
                });
            }
        }
        i3 |= 384;
        modifier2 = modifier;
        i4 = i2 & 8;
        if (i4 != 0) {
            if ((i & 3072) == 0) {
                function5 = function4;
                if (composerStartRestartGroup.changedInstance(function5)) {
                    i5 = 2048;
                } else {
                    i5 = 1024;
                }
                i3 |= i5;
            }
            i6 = i2 & 16;
            if (i6 != 0) {
                if ((i & 24576) == 0) {
                    z2 = z;
                    if (composerStartRestartGroup.changed(z2)) {
                        i7 = 16384;
                    } else {
                        i7 = 8192;
                    }
                    i3 |= i7;
                }
                i8 = i3;
                if ((i8 & 9363) != 9362) {
                    z3 = true;
                } else {
                    z3 = false;
                }
                if (composerStartRestartGroup.shouldExecute(z3, i8 & 1)) {
                    composerStartRestartGroup.skipToGroupEnd();
                    modifier3 = modifier2;
                    function6 = function5;
                    z4 = z2;
                } else {
                    if (i10 != 0) {
                        modifier4 = Modifier.INSTANCE;
                    } else {
                        modifier4 = modifier2;
                    }
                    if (i4 != 0) {
                        function7 = null;
                    } else {
                        function7 = function5;
                    }
                    if (i6 != 0) {
                        z2 = false;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(443371213, i8, -1, "com.box.android.browse.cpl.browse.AllFilesContent (AllFilesScreen.kt:121)");
                    }
                    Unit unit9 = Unit.INSTANCE;
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 877984934, "CC(remember):AllFilesScreen.kt#9igjgp");
                    i9 = i8 & 14;
                    if (i9 == 4) {
                        z5 = true;
                    } else {
                        z5 = false;
                    }
                    allFilesScreenKt$AllFilesContent$1$1RememberedValue = composerStartRestartGroup.rememberedValue();
                    if (!z5) {
                        allFilesScreenKt$AllFilesContent$1$1RememberedValue = new AllFilesScreenKt$AllFilesContent$1$1(store, null);
                        composerStartRestartGroup.updateRememberedValue(allFilesScreenKt$AllFilesContent$1$1RememberedValue);
                    } else {
                        allFilesScreenKt$AllFilesContent$1$1RememberedValue = new AllFilesScreenKt$AllFilesContent$1$1(store, null);
                        composerStartRestartGroup.updateRememberedValue(allFilesScreenKt$AllFilesContent$1$1RememberedValue);
                    }
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    EffectsKt.LaunchedEffect(unit9, (Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object>) allFilesScreenKt$AllFilesContent$1$1RememberedValue, composerStartRestartGroup, 6);
                    Unit unit10 = Unit.INSTANCE;
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 877989338, "CC(remember):AllFilesScreen.kt#9igjgp");
                    if (i9 == 4) {
                        z6 = true;
                    } else {
                        z6 = false;
                    }
                    objRememberedValue = composerStartRestartGroup.rememberedValue();
                    if (!z6) {
                        objRememberedValue = new Function1() { // from class: com.box.android.browse.cpl.browse.AllFilesScreenKt$$ExternalSyntheticLambda6
                            @Override // kotlin.jvm.functions.Function1
                            public final Object invoke(Object obj) {
                                return AllFilesScreenKt.AllFilesContent$lambda$1$0(store, (LifecycleResumePauseEffectScope) obj);
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                    } else {
                        objRememberedValue = new Function1() { // from class: com.box.android.browse.cpl.browse.AllFilesScreenKt$$ExternalSyntheticLambda6
                            @Override // kotlin.jvm.functions.Function1
                            public final Object invoke(Object obj) {
                                return AllFilesScreenKt.AllFilesContent$lambda$1$0(store, (LifecycleResumePauseEffectScope) obj);
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                    }
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    LifecycleEffectKt.LifecycleResumeEffect(unit10, (LifecycleOwner) null, (Function1<? super LifecycleResumePauseEffectScope, ? extends LifecyclePauseOrDisposeEffectResult>) objRememberedValue, composerStartRestartGroup, 6, 2);
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 878008428, "CC(remember):AllFilesScreen.kt#9igjgp");
                    if (i9 == 4) {
                    }
                    objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                    if (!z7) {
                        objRememberedValue2 = new Function1() { // from class: com.box.android.browse.cpl.browse.AllFilesScreenKt$$ExternalSyntheticLambda7
                            @Override // kotlin.jvm.functions.Function1
                            public final Object invoke(Object obj) {
                                return AllFilesScreenKt.AllFilesContent$lambda$2$0(store, (BoxMessage) obj);
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                    } else {
                        objRememberedValue2 = new Function1() { // from class: com.box.android.browse.cpl.browse.AllFilesScreenKt$$ExternalSyntheticLambda7
                            @Override // kotlin.jvm.functions.Function1
                            public final Object invoke(Object obj) {
                                return AllFilesScreenKt.AllFilesContent$lambda$2$0(store, (BoxMessage) obj);
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                    }
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    int i19 = i8 >> 3;
                    BoxMessageListenerEffectKt.BoxMessageListenerEffect(boxMessageDispatcher, (Function1) objRememberedValue2, composerStartRestartGroup, BoxMessageDispatcher.$stable | (i19 & 14));
                    int i110 = i9 | 3072 | (i19 & 112) | (i19 & 896) | (57344 & i8);
                    boolean z12 = z2;
                    Modifier modifier9 = modifier4;
                    Function4<? super String, ? super String, ? super SnackbarDuration, ? super Continuation<? super SnackbarResult>, ? extends Object> function12 = function7;
                    BrowseContentKt.BrowseContent(store, modifier9, function12, true, z12, composerStartRestartGroup, i110, 0);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    modifier3 = modifier9;
                    z4 = z12;
                    function6 = function12;
                }
                scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.box.android.browse.cpl.browse.AllFilesScreenKt$$ExternalSyntheticLambda8
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return AllFilesScreenKt.AllFilesContent$lambda$3(store, boxMessageDispatcher, modifier3, function6, z4, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    });
                }
            }
            i3 |= 24576;
            z2 = z;
            i8 = i3;
            if ((i8 & 9363) != 9362) {
                z3 = true;
            } else {
                z3 = false;
            }
            if (composerStartRestartGroup.shouldExecute(z3, i8 & 1)) {
                composerStartRestartGroup.skipToGroupEnd();
                modifier3 = modifier2;
                function6 = function5;
                z4 = z2;
            } else {
                if (i10 != 0) {
                    modifier4 = Modifier.INSTANCE;
                } else {
                    modifier4 = modifier2;
                }
                if (i4 != 0) {
                    function7 = null;
                } else {
                    function7 = function5;
                }
                if (i6 != 0) {
                    z2 = false;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(443371213, i8, -1, "com.box.android.browse.cpl.browse.AllFilesContent (AllFilesScreen.kt:121)");
                }
                Unit unit11 = Unit.INSTANCE;
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 877984934, "CC(remember):AllFilesScreen.kt#9igjgp");
                i9 = i8 & 14;
                if (i9 == 4) {
                    z5 = true;
                } else {
                    z5 = false;
                }
                allFilesScreenKt$AllFilesContent$1$1RememberedValue = composerStartRestartGroup.rememberedValue();
                if (!z5) {
                    allFilesScreenKt$AllFilesContent$1$1RememberedValue = new AllFilesScreenKt$AllFilesContent$1$1(store, null);
                    composerStartRestartGroup.updateRememberedValue(allFilesScreenKt$AllFilesContent$1$1RememberedValue);
                } else {
                    allFilesScreenKt$AllFilesContent$1$1RememberedValue = new AllFilesScreenKt$AllFilesContent$1$1(store, null);
                    composerStartRestartGroup.updateRememberedValue(allFilesScreenKt$AllFilesContent$1$1RememberedValue);
                }
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                EffectsKt.LaunchedEffect(unit11, (Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object>) allFilesScreenKt$AllFilesContent$1$1RememberedValue, composerStartRestartGroup, 6);
                Unit unit12 = Unit.INSTANCE;
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 877989338, "CC(remember):AllFilesScreen.kt#9igjgp");
                if (i9 == 4) {
                    z6 = true;
                } else {
                    z6 = false;
                }
                objRememberedValue = composerStartRestartGroup.rememberedValue();
                if (!z6) {
                    objRememberedValue = new Function1() { // from class: com.box.android.browse.cpl.browse.AllFilesScreenKt$$ExternalSyntheticLambda6
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            return AllFilesScreenKt.AllFilesContent$lambda$1$0(store, (LifecycleResumePauseEffectScope) obj);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                } else {
                    objRememberedValue = new Function1() { // from class: com.box.android.browse.cpl.browse.AllFilesScreenKt$$ExternalSyntheticLambda6
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            return AllFilesScreenKt.AllFilesContent$lambda$1$0(store, (LifecycleResumePauseEffectScope) obj);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                }
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                LifecycleEffectKt.LifecycleResumeEffect(unit12, (LifecycleOwner) null, (Function1<? super LifecycleResumePauseEffectScope, ? extends LifecyclePauseOrDisposeEffectResult>) objRememberedValue, composerStartRestartGroup, 6, 2);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 878008428, "CC(remember):AllFilesScreen.kt#9igjgp");
                if (i9 == 4) {
                }
                objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                if (!z7) {
                    objRememberedValue2 = new Function1() { // from class: com.box.android.browse.cpl.browse.AllFilesScreenKt$$ExternalSyntheticLambda7
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            return AllFilesScreenKt.AllFilesContent$lambda$2$0(store, (BoxMessage) obj);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                } else {
                    objRememberedValue2 = new Function1() { // from class: com.box.android.browse.cpl.browse.AllFilesScreenKt$$ExternalSyntheticLambda7
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            return AllFilesScreenKt.AllFilesContent$lambda$2$0(store, (BoxMessage) obj);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                }
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                int i111 = i8 >> 3;
                BoxMessageListenerEffectKt.BoxMessageListenerEffect(boxMessageDispatcher, (Function1) objRememberedValue2, composerStartRestartGroup, BoxMessageDispatcher.$stable | (i111 & 14));
                int i112 = i9 | 3072 | (i111 & 112) | (i111 & 896) | (57344 & i8);
                boolean z13 = z2;
                Modifier modifier10 = modifier4;
                Function4<? super String, ? super String, ? super SnackbarDuration, ? super Continuation<? super SnackbarResult>, ? extends Object> function13 = function7;
                BrowseContentKt.BrowseContent(store, modifier10, function13, true, z13, composerStartRestartGroup, i112, 0);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                modifier3 = modifier10;
                z4 = z13;
                function6 = function13;
            }
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.box.android.browse.cpl.browse.AllFilesScreenKt$$ExternalSyntheticLambda8
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return AllFilesScreenKt.AllFilesContent$lambda$3(store, boxMessageDispatcher, modifier3, function6, z4, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                    }
                });
            }
        }
        i3 |= 3072;
        function5 = function4;
        i6 = i2 & 16;
        if (i6 != 0) {
            if ((i & 24576) == 0) {
                z2 = z;
                if (composerStartRestartGroup.changed(z2)) {
                    i7 = 16384;
                } else {
                    i7 = 8192;
                }
                i3 |= i7;
            }
            i8 = i3;
            if ((i8 & 9363) != 9362) {
                z3 = true;
            } else {
                z3 = false;
            }
            if (composerStartRestartGroup.shouldExecute(z3, i8 & 1)) {
                composerStartRestartGroup.skipToGroupEnd();
                modifier3 = modifier2;
                function6 = function5;
                z4 = z2;
            } else {
                if (i10 != 0) {
                    modifier4 = Modifier.INSTANCE;
                } else {
                    modifier4 = modifier2;
                }
                if (i4 != 0) {
                    function7 = null;
                } else {
                    function7 = function5;
                }
                if (i6 != 0) {
                    z2 = false;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(443371213, i8, -1, "com.box.android.browse.cpl.browse.AllFilesContent (AllFilesScreen.kt:121)");
                }
                Unit unit13 = Unit.INSTANCE;
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 877984934, "CC(remember):AllFilesScreen.kt#9igjgp");
                i9 = i8 & 14;
                if (i9 == 4) {
                    z5 = true;
                } else {
                    z5 = false;
                }
                allFilesScreenKt$AllFilesContent$1$1RememberedValue = composerStartRestartGroup.rememberedValue();
                if (!z5) {
                    allFilesScreenKt$AllFilesContent$1$1RememberedValue = new AllFilesScreenKt$AllFilesContent$1$1(store, null);
                    composerStartRestartGroup.updateRememberedValue(allFilesScreenKt$AllFilesContent$1$1RememberedValue);
                } else {
                    allFilesScreenKt$AllFilesContent$1$1RememberedValue = new AllFilesScreenKt$AllFilesContent$1$1(store, null);
                    composerStartRestartGroup.updateRememberedValue(allFilesScreenKt$AllFilesContent$1$1RememberedValue);
                }
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                EffectsKt.LaunchedEffect(unit13, (Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object>) allFilesScreenKt$AllFilesContent$1$1RememberedValue, composerStartRestartGroup, 6);
                Unit unit14 = Unit.INSTANCE;
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 877989338, "CC(remember):AllFilesScreen.kt#9igjgp");
                if (i9 == 4) {
                    z6 = true;
                } else {
                    z6 = false;
                }
                objRememberedValue = composerStartRestartGroup.rememberedValue();
                if (!z6) {
                    objRememberedValue = new Function1() { // from class: com.box.android.browse.cpl.browse.AllFilesScreenKt$$ExternalSyntheticLambda6
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            return AllFilesScreenKt.AllFilesContent$lambda$1$0(store, (LifecycleResumePauseEffectScope) obj);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                } else {
                    objRememberedValue = new Function1() { // from class: com.box.android.browse.cpl.browse.AllFilesScreenKt$$ExternalSyntheticLambda6
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            return AllFilesScreenKt.AllFilesContent$lambda$1$0(store, (LifecycleResumePauseEffectScope) obj);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                }
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                LifecycleEffectKt.LifecycleResumeEffect(unit14, (LifecycleOwner) null, (Function1<? super LifecycleResumePauseEffectScope, ? extends LifecyclePauseOrDisposeEffectResult>) objRememberedValue, composerStartRestartGroup, 6, 2);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 878008428, "CC(remember):AllFilesScreen.kt#9igjgp");
                if (i9 == 4) {
                }
                objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                if (!z7) {
                    objRememberedValue2 = new Function1() { // from class: com.box.android.browse.cpl.browse.AllFilesScreenKt$$ExternalSyntheticLambda7
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            return AllFilesScreenKt.AllFilesContent$lambda$2$0(store, (BoxMessage) obj);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                } else {
                    objRememberedValue2 = new Function1() { // from class: com.box.android.browse.cpl.browse.AllFilesScreenKt$$ExternalSyntheticLambda7
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            return AllFilesScreenKt.AllFilesContent$lambda$2$0(store, (BoxMessage) obj);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                }
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                int i113 = i8 >> 3;
                BoxMessageListenerEffectKt.BoxMessageListenerEffect(boxMessageDispatcher, (Function1) objRememberedValue2, composerStartRestartGroup, BoxMessageDispatcher.$stable | (i113 & 14));
                int i114 = i9 | 3072 | (i113 & 112) | (i113 & 896) | (57344 & i8);
                boolean z14 = z2;
                Modifier modifier11 = modifier4;
                Function4<? super String, ? super String, ? super SnackbarDuration, ? super Continuation<? super SnackbarResult>, ? extends Object> function14 = function7;
                BrowseContentKt.BrowseContent(store, modifier11, function14, true, z14, composerStartRestartGroup, i114, 0);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                modifier3 = modifier11;
                z4 = z14;
                function6 = function14;
            }
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.box.android.browse.cpl.browse.AllFilesScreenKt$$ExternalSyntheticLambda8
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return AllFilesScreenKt.AllFilesContent$lambda$3(store, boxMessageDispatcher, modifier3, function6, z4, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                    }
                });
            }
        }
        i3 |= 24576;
        z2 = z;
        i8 = i3;
        if ((i8 & 9363) != 9362) {
            z3 = true;
        } else {
            z3 = false;
        }
        if (composerStartRestartGroup.shouldExecute(z3, i8 & 1)) {
            composerStartRestartGroup.skipToGroupEnd();
            modifier3 = modifier2;
            function6 = function5;
            z4 = z2;
        } else {
            if (i10 != 0) {
                modifier4 = Modifier.INSTANCE;
            } else {
                modifier4 = modifier2;
            }
            if (i4 != 0) {
                function7 = null;
            } else {
                function7 = function5;
            }
            if (i6 != 0) {
                z2 = false;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(443371213, i8, -1, "com.box.android.browse.cpl.browse.AllFilesContent (AllFilesScreen.kt:121)");
            }
            Unit unit15 = Unit.INSTANCE;
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 877984934, "CC(remember):AllFilesScreen.kt#9igjgp");
            i9 = i8 & 14;
            if (i9 == 4) {
                z5 = true;
            } else {
                z5 = false;
            }
            allFilesScreenKt$AllFilesContent$1$1RememberedValue = composerStartRestartGroup.rememberedValue();
            if (!z5) {
                allFilesScreenKt$AllFilesContent$1$1RememberedValue = new AllFilesScreenKt$AllFilesContent$1$1(store, null);
                composerStartRestartGroup.updateRememberedValue(allFilesScreenKt$AllFilesContent$1$1RememberedValue);
            } else {
                allFilesScreenKt$AllFilesContent$1$1RememberedValue = new AllFilesScreenKt$AllFilesContent$1$1(store, null);
                composerStartRestartGroup.updateRememberedValue(allFilesScreenKt$AllFilesContent$1$1RememberedValue);
            }
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            EffectsKt.LaunchedEffect(unit15, (Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object>) allFilesScreenKt$AllFilesContent$1$1RememberedValue, composerStartRestartGroup, 6);
            Unit unit16 = Unit.INSTANCE;
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 877989338, "CC(remember):AllFilesScreen.kt#9igjgp");
            if (i9 == 4) {
                z6 = true;
            } else {
                z6 = false;
            }
            objRememberedValue = composerStartRestartGroup.rememberedValue();
            if (!z6) {
                objRememberedValue = new Function1() { // from class: com.box.android.browse.cpl.browse.AllFilesScreenKt$$ExternalSyntheticLambda6
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return AllFilesScreenKt.AllFilesContent$lambda$1$0(store, (LifecycleResumePauseEffectScope) obj);
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
            } else {
                objRememberedValue = new Function1() { // from class: com.box.android.browse.cpl.browse.AllFilesScreenKt$$ExternalSyntheticLambda6
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return AllFilesScreenKt.AllFilesContent$lambda$1$0(store, (LifecycleResumePauseEffectScope) obj);
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
            }
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            LifecycleEffectKt.LifecycleResumeEffect(unit16, (LifecycleOwner) null, (Function1<? super LifecycleResumePauseEffectScope, ? extends LifecyclePauseOrDisposeEffectResult>) objRememberedValue, composerStartRestartGroup, 6, 2);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 878008428, "CC(remember):AllFilesScreen.kt#9igjgp");
            if (i9 == 4) {
            }
            objRememberedValue2 = composerStartRestartGroup.rememberedValue();
            if (!z7) {
                objRememberedValue2 = new Function1() { // from class: com.box.android.browse.cpl.browse.AllFilesScreenKt$$ExternalSyntheticLambda7
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return AllFilesScreenKt.AllFilesContent$lambda$2$0(store, (BoxMessage) obj);
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
            } else {
                objRememberedValue2 = new Function1() { // from class: com.box.android.browse.cpl.browse.AllFilesScreenKt$$ExternalSyntheticLambda7
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return AllFilesScreenKt.AllFilesContent$lambda$2$0(store, (BoxMessage) obj);
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
            }
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            int i115 = i8 >> 3;
            BoxMessageListenerEffectKt.BoxMessageListenerEffect(boxMessageDispatcher, (Function1) objRememberedValue2, composerStartRestartGroup, BoxMessageDispatcher.$stable | (i115 & 14));
            int i116 = i9 | 3072 | (i115 & 112) | (i115 & 896) | (57344 & i8);
            boolean z15 = z2;
            Modifier modifier12 = modifier4;
            Function4<? super String, ? super String, ? super SnackbarDuration, ? super Continuation<? super SnackbarResult>, ? extends Object> function15 = function7;
            BrowseContentKt.BrowseContent(store, modifier12, function15, true, z15, composerStartRestartGroup, i116, 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            modifier3 = modifier12;
            z4 = z15;
            function6 = function15;
        }
        scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.box.android.browse.cpl.browse.AllFilesScreenKt$$ExternalSyntheticLambda8
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return AllFilesScreenKt.AllFilesContent$lambda$3(store, boxMessageDispatcher, modifier3, function6, z4, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final LifecyclePauseOrDisposeEffectResult AllFilesContent$lambda$1$0(Store store, final LifecycleResumePauseEffectScope LifecycleResumeEffect) {
        Intrinsics.checkNotNullParameter(LifecycleResumeEffect, "$this$LifecycleResumeEffect");
        store.send(new BrowseReducer.Action.ChildActionableItemsListAction(new ActionableItemsListReducer.Action.ItemsListAction(ItemsListReducer.Action.RefreshFeatureBannerVisibility.INSTANCE)));
        store.send(new BrowseReducer.Action.ChildActionableItemsListAction(new ActionableItemsListReducer.Action.ItemsListAction(ItemsListReducer.Action.ScreenUpdated.INSTANCE)));
        return new LifecyclePauseOrDisposeEffectResult() { // from class: com.box.android.browse.cpl.browse.AllFilesScreenKt$AllFilesContent$lambda$1$0$$inlined$onPauseOrDispose$1
            @Override // androidx.lifecycle.compose.LifecyclePauseOrDisposeEffectResult
            public void runPauseOrOnDisposeEffect() {
                LifecycleResumePauseEffectScope lifecycleResumePauseEffectScope = LifecycleResumeEffect;
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit AllFilesContent$lambda$2$0(Store store, BoxMessage message) {
        Intrinsics.checkNotNullParameter(message, "message");
        BrowseReducer.Action actionHandle = BrowseScreenMessageHandler.INSTANCE.handle((BoxMessage<?>) message);
        if (actionHandle != null) {
            store.send(actionHandle);
        }
        return Unit.INSTANCE;
    }

    private static final void NavigationRouteEffect(final BrowseReducer.Route route, final BrowseNavigator browseNavigator, final Store<BrowseReducer.State, BrowseReducer.Action> store, Composer composer, final int i) {
        int i2;
        Composer composerStartRestartGroup = composer.startRestartGroup(-2062497129);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(NavigationRouteEffect)N(route,navigator,store)165@6460L2406,165@6438L2428:AllFilesScreen.kt#89mwni");
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
                ComposerKt.traceEventStart(-2062497129, i2, -1, "com.box.android.browse.cpl.browse.NavigationRouteEffect (AllFilesScreen.kt:164)");
            }
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -2079809315, "CC(remember):AllFilesScreen.kt#9igjgp");
            boolean z = (i2 & 896) == 256;
            int i3 = i2 & 14;
            boolean zChangedInstance = z | (i3 == 4) | composerStartRestartGroup.changedInstance(browseNavigator);
            AllFilesScreenKt$NavigationRouteEffect$1$1 allFilesScreenKt$NavigationRouteEffect$1$1RememberedValue = composerStartRestartGroup.rememberedValue();
            if (zChangedInstance || allFilesScreenKt$NavigationRouteEffect$1$1RememberedValue == Composer.INSTANCE.getEmpty()) {
                allFilesScreenKt$NavigationRouteEffect$1$1RememberedValue = new AllFilesScreenKt$NavigationRouteEffect$1$1(route, browseNavigator, store, null);
                composerStartRestartGroup.updateRememberedValue(allFilesScreenKt$NavigationRouteEffect$1$1RememberedValue);
            }
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            EffectsKt.LaunchedEffect(route, (Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object>) allFilesScreenKt$NavigationRouteEffect$1$1RememberedValue, composerStartRestartGroup, i3);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.box.android.browse.cpl.browse.AllFilesScreenKt$$ExternalSyntheticLambda0
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return AllFilesScreenKt.NavigationRouteEffect$lambda$1(route, browseNavigator, store, i, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    private static final void SelectionModeViewsVisibilityEffect(final boolean z, final HomeScreenViewsVisibilityState homeScreenViewsVisibilityState, Composer composer, final int i) {
        int i2;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        Function2<? super Composer, ? super Integer, Unit> function2;
        Composer composerStartRestartGroup = composer.startRestartGroup(336703904);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(SelectionModeViewsVisibilityEffect)N(isSelecting,homeScreenViewsVisibilityState)232@9128L313,232@9068L373:AllFilesScreen.kt#89mwni");
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
                ComposerKt.traceEventStart(336703904, i2, -1, "com.box.android.browse.cpl.browse.SelectionModeViewsVisibilityEffect (AllFilesScreen.kt:229)");
            }
            if (homeScreenViewsVisibilityState == null) {
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup == null) {
                    return;
                } else {
                    function2 = new Function2() { // from class: com.box.android.browse.cpl.browse.AllFilesScreenKt$$ExternalSyntheticLambda1
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return AllFilesScreenKt.SelectionModeViewsVisibilityEffect$lambda$0(z, homeScreenViewsVisibilityState, i, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    };
                }
            } else {
                Boolean boolValueOf = Boolean.valueOf(z);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1449912473, "CC(remember):AllFilesScreen.kt#9igjgp");
                boolean z2 = ((i2 & 14) == 4) | ((i2 & 112) == 32);
                AllFilesScreenKt$SelectionModeViewsVisibilityEffect$2$1 allFilesScreenKt$SelectionModeViewsVisibilityEffect$2$1RememberedValue = composerStartRestartGroup.rememberedValue();
                if (z2 || allFilesScreenKt$SelectionModeViewsVisibilityEffect$2$1RememberedValue == Composer.INSTANCE.getEmpty()) {
                    allFilesScreenKt$SelectionModeViewsVisibilityEffect$2$1RememberedValue = new AllFilesScreenKt$SelectionModeViewsVisibilityEffect$2$1(z, homeScreenViewsVisibilityState, null);
                    composerStartRestartGroup.updateRememberedValue(allFilesScreenKt$SelectionModeViewsVisibilityEffect$2$1RememberedValue);
                }
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                EffectsKt.LaunchedEffect(boolValueOf, homeScreenViewsVisibilityState, (Function2) allFilesScreenKt$SelectionModeViewsVisibilityEffect$2$1RememberedValue, composerStartRestartGroup, i2 & 126);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
            }
            scopeUpdateScopeEndRestartGroup.updateScope(function2);
        }
        composerStartRestartGroup.skipToGroupEnd();
        scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            function2 = new Function2() { // from class: com.box.android.browse.cpl.browse.AllFilesScreenKt$$ExternalSyntheticLambda2
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return AllFilesScreenKt.SelectionModeViewsVisibilityEffect$lambda$2(z, homeScreenViewsVisibilityState, i, (Composer) obj, ((Integer) obj2).intValue());
                }
            };
            scopeUpdateScopeEndRestartGroup.updateScope(function2);
        }
    }

    private static final BrowseReducer.State AllFilesScreen$lambda$0(State<BrowseReducer.State> state) {
        return state.getValue();
    }
}
