package com.box.android.browse.cpl.navigationmodernization.compose;

import android.app.Activity;
import androidx.activity.ComponentActivity;
import androidx.activity.compose.LocalActivityKt;
import androidx.compose.animation.AnimatedContentScope;
import androidx.compose.material3.SnackbarHostState;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.ProvidableCompositionLocal;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.hilt.navigation.compose.HiltViewModelKt;
import androidx.lifecycle.HasDefaultViewModelProviderFactory;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.viewmodel.CreationExtras;
import androidx.lifecycle.viewmodel.compose.ViewModelKt;
import androidx.navigation.NavBackStackEntry;
import androidx.navigation.NavGraphBuilder;
import androidx.navigation.compose.NavGraphBuilderKt;
import com.box.android.base.presentation.components.tabscreen.TabsSelector;
import com.box.android.base.presentation.components.topbar.component.inbox.InboxCountViewModel;
import com.box.android.base.presentation.components.topbar.component.jobsprogress.JobsProgressViewModel;
import com.box.android.base.presentation.components.topbar.component.settings.UserAvatarViewModel;
import com.box.android.base.presentation.message.BoxMessageDispatcher;
import com.box.android.base.presentation.state.HomeScreenViewsVisibilityState;
import com.box.android.browse.cpl.browse.AllFilesViewModel;
import com.box.android.browse.cpl.navigationmodernization.BrowseDestination;
import com.box.android.browse.cpl.navigationmodernization.BrowseNavigationConfig;
import com.box.android.browse.cpl.navigationmodernization.BrowseNavigator;
import com.box.android.browse.cpl.navigationmodernization.tabsscreen.BrowseTabsScreenKt;
import com.box.android.browse.cpl.navigationmodernization.tabsscreen.BrowseTabsViewModel;
import com.box.android.browse.cpl.navigationmodernization.tabsscreen.BrowseTabsViewModels;
import com.box.android.browse.cpl.offlined.OfflinedViewModel;
import com.box.android.browse.cpl.recents.RecentsViewModel;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: BrowseNavigationCompose.kt */
/* JADX INFO: loaded from: classes10.dex */
@Metadata(d1 = {"\u0000X\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a¶\u0001\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0014\b\u0002\u0010\r\u001a\u000e\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u00010\u000e2\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00010\u00112\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00010\u00112\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00010\u00112\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00010\u00112\u0010\b\u0002\u0010\u0015\u001a\n\u0012\u0004\u0012\u00020\u0017\u0018\u00010\u00162\b\b\u0002\u0010\u0018\u001a\u00020\u00192\u0013\b\u0002\u0010\u001a\u001a\r\u0012\u0004\u0012\u00020\u001b0\u0011¢\u0006\u0002\b\u001c¢\u0006\u0002\u0010\u001d\u001a\r\u0010\u001e\u001a\u00020\u001bH\u0003¢\u0006\u0002\u0010\u001f¨\u0006 "}, d2 = {"browseNavigationGraph", "", "Landroidx/navigation/NavGraphBuilder;", "browseNavigationConfig", "Lcom/box/android/browse/cpl/navigationmodernization/BrowseNavigationConfig;", "navigator", "Lcom/box/android/browse/cpl/navigationmodernization/BrowseNavigator;", "homeScreenViewsVisibilityState", "Lcom/box/android/base/presentation/state/HomeScreenViewsVisibilityState;", "boxMessageDispatcher", "Lcom/box/android/base/presentation/message/BoxMessageDispatcher;", "snackbarHostState", "Landroidx/compose/material3/SnackbarHostState;", "onInnerTabChanged", "Lkotlin/Function1;", "", "onNavigateToSettings", "Lkotlin/Function0;", "onNavigateToSearch", "onNavigateToJobs", "onNavigateToInbox", "tabsSelector", "Lcom/box/android/base/presentation/components/tabscreen/TabsSelector;", "Lcom/box/android/browse/cpl/navigationmodernization/BrowseDestination$InnerDestination$TabsScreen$BrowseTab;", "shouldUseAiCenter", "", "browseViewModelsProvider", "Lcom/box/android/browse/cpl/navigationmodernization/compose/BrowseViewModels;", "Landroidx/compose/runtime/Composable;", "(Landroidx/navigation/NavGraphBuilder;Lcom/box/android/browse/cpl/navigationmodernization/BrowseNavigationConfig;Lcom/box/android/browse/cpl/navigationmodernization/BrowseNavigator;Lcom/box/android/base/presentation/state/HomeScreenViewsVisibilityState;Lcom/box/android/base/presentation/message/BoxMessageDispatcher;Landroidx/compose/material3/SnackbarHostState;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;Lcom/box/android/base/presentation/components/tabscreen/TabsSelector;ZLkotlin/jvm/functions/Function2;)V", "defaultBrowseViewModels", "(Landroidx/compose/runtime/Composer;I)Lcom/box/android/browse/cpl/navigationmodernization/compose/BrowseViewModels;", "browse_generalProdRelease"}, k = 2, mv = {2, 2, 0}, xi = 48)
public final class BrowseNavigationComposeKt {
    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit browseNavigationGraph$lambda$0(String it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final BrowseViewModels browseNavigationGraph$lambda$1(Composer composer, int i) {
        composer.startReplaceGroup(734083359);
        ComposerKt.sourceInformation(composer, "C44@2492L25:BrowseNavigationCompose.kt#ow8rin");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(734083359, i, -1, "com.box.android.browse.cpl.navigationmodernization.compose.browseNavigationGraph.<anonymous> (BrowseNavigationCompose.kt:44)");
        }
        BrowseViewModels browseViewModelsDefaultBrowseViewModels = defaultBrowseViewModels(composer, 0);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceGroup();
        return browseViewModelsDefaultBrowseViewModels;
    }

    public static final void browseNavigationGraph(NavGraphBuilder navGraphBuilder, final BrowseNavigationConfig browseNavigationConfig, final BrowseNavigator navigator, final HomeScreenViewsVisibilityState homeScreenViewsVisibilityState, final BoxMessageDispatcher boxMessageDispatcher, final SnackbarHostState snackbarHostState, final Function1<? super String, Unit> onInnerTabChanged, final Function0<Unit> onNavigateToSettings, final Function0<Unit> onNavigateToSearch, final Function0<Unit> onNavigateToJobs, final Function0<Unit> onNavigateToInbox, final TabsSelector<BrowseDestination.InnerDestination.TabsScreen.BrowseTab> tabsSelector, final boolean z, final Function2<? super Composer, ? super Integer, BrowseViewModels> browseViewModelsProvider) {
        Intrinsics.checkNotNullParameter(navGraphBuilder, "<this>");
        Intrinsics.checkNotNullParameter(browseNavigationConfig, "browseNavigationConfig");
        Intrinsics.checkNotNullParameter(navigator, "navigator");
        Intrinsics.checkNotNullParameter(homeScreenViewsVisibilityState, "homeScreenViewsVisibilityState");
        Intrinsics.checkNotNullParameter(boxMessageDispatcher, "boxMessageDispatcher");
        Intrinsics.checkNotNullParameter(snackbarHostState, "snackbarHostState");
        Intrinsics.checkNotNullParameter(onInnerTabChanged, "onInnerTabChanged");
        Intrinsics.checkNotNullParameter(onNavigateToSettings, "onNavigateToSettings");
        Intrinsics.checkNotNullParameter(onNavigateToSearch, "onNavigateToSearch");
        Intrinsics.checkNotNullParameter(onNavigateToJobs, "onNavigateToJobs");
        Intrinsics.checkNotNullParameter(onNavigateToInbox, "onNavigateToInbox");
        Intrinsics.checkNotNullParameter(browseViewModelsProvider, "browseViewModelsProvider");
        String strGraphToRoute = BrowseNavigationMappingKt.graphToRoute(BrowseDestination.INSTANCE);
        NavGraphBuilder navGraphBuilder2 = new NavGraphBuilder(navGraphBuilder.getProvider(), BrowseNavigationMappingKt.toRoute(browseNavigationConfig.getStartDestination()), strGraphToRoute);
        NavGraphBuilderKt.composable$default(navGraphBuilder2, BrowseNavigationMappingKt.toRoute(browseNavigationConfig.getStartDestination()), (List) null, (List) null, (Function1) null, (Function1) null, (Function1) null, (Function1) null, (Function1) null, ComposableLambdaKt.composableLambdaInstance(-1810726023, true, new Function4() { // from class: com.box.android.browse.cpl.navigationmodernization.compose.BrowseNavigationComposeKt$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function4
            public final Object invoke(Object obj, Object obj2, Object obj3, Object obj4) {
                return BrowseNavigationComposeKt.browseNavigationGraph$lambda$2$0(browseNavigationConfig, browseViewModelsProvider, navigator, homeScreenViewsVisibilityState, boxMessageDispatcher, snackbarHostState, onInnerTabChanged, onNavigateToSettings, onNavigateToSearch, onNavigateToJobs, onNavigateToInbox, tabsSelector, z, (AnimatedContentScope) obj, (NavBackStackEntry) obj2, (Composer) obj3, ((Integer) obj4).intValue());
            }
        }), 254, (Object) null);
        navGraphBuilder.destination(navGraphBuilder2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit browseNavigationGraph$lambda$2$0(BrowseNavigationConfig browseNavigationConfig, Function2 function2, BrowseNavigator browseNavigator, HomeScreenViewsVisibilityState homeScreenViewsVisibilityState, BoxMessageDispatcher boxMessageDispatcher, SnackbarHostState snackbarHostState, Function1 function1, Function0 function0, Function0 function3, Function0 function4, Function0 function5, TabsSelector tabsSelector, boolean z, AnimatedContentScope composable, NavBackStackEntry it, Composer composer, int i) {
        Intrinsics.checkNotNullParameter(composable, "$this$composable");
        Intrinsics.checkNotNullParameter(it, "it");
        ComposerKt.sourceInformation(composer, "CN(it)53@2892L26,51@2767L797:BrowseNavigationCompose.kt#ow8rin");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1810726023, i, -1, "com.box.android.browse.cpl.navigationmodernization.compose.browseNavigationGraph.<anonymous>.<anonymous> (BrowseNavigationCompose.kt:51)");
        }
        BrowseTabsScreenKt.BrowseTabsScreen(browseNavigationConfig.getStartDestination(), ((BrowseViewModels) function2.invoke(composer, 0)).getTabsViewModels(), browseNavigator, homeScreenViewsVisibilityState, boxMessageDispatcher, snackbarHostState, function1, function0, function3, function4, function5, tabsSelector, z, null, composer, BoxMessageDispatcher.$stable << 12, TabsSelector.$stable << 3, 8192);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        return Unit.INSTANCE;
    }

    private static final BrowseViewModels defaultBrowseViewModels(Composer composer, int i) {
        ComposerKt.sourceInformationMarkerStart(composer, 1114945600, "C(defaultBrowseViewModels)74@3752L664:BrowseNavigationCompose.kt#ow8rin");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1114945600, i, -1, "com.box.android.browse.cpl.navigationmodernization.compose.defaultBrowseViewModels (BrowseNavigationCompose.kt:74)");
        }
        ComposerKt.sourceInformationMarkerStart(composer, 2015867160, "CC(remember):BrowseNavigationCompose.kt#9igjgp");
        Object objRememberedValue = composer.rememberedValue();
        if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
            objRememberedValue = new BrowseViewModels(new BrowseTabsViewModels(new Function2() { // from class: com.box.android.browse.cpl.navigationmodernization.compose.BrowseNavigationComposeKt$$ExternalSyntheticLambda1
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return BrowseNavigationComposeKt.defaultBrowseViewModels$lambda$0$0((Composer) obj, ((Integer) obj2).intValue());
                }
            }, new Function2() { // from class: com.box.android.browse.cpl.navigationmodernization.compose.BrowseNavigationComposeKt$$ExternalSyntheticLambda2
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return BrowseNavigationComposeKt.defaultBrowseViewModels$lambda$0$1((Composer) obj, ((Integer) obj2).intValue());
                }
            }, new Function2() { // from class: com.box.android.browse.cpl.navigationmodernization.compose.BrowseNavigationComposeKt$$ExternalSyntheticLambda3
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return BrowseNavigationComposeKt.defaultBrowseViewModels$lambda$0$2((Composer) obj, ((Integer) obj2).intValue());
                }
            }, new Function2() { // from class: com.box.android.browse.cpl.navigationmodernization.compose.BrowseNavigationComposeKt$$ExternalSyntheticLambda4
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return BrowseNavigationComposeKt.defaultBrowseViewModels$lambda$0$3((Composer) obj, ((Integer) obj2).intValue());
                }
            }, new Function2() { // from class: com.box.android.browse.cpl.navigationmodernization.compose.BrowseNavigationComposeKt$$ExternalSyntheticLambda5
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return BrowseNavigationComposeKt.defaultBrowseViewModels$lambda$0$4((Composer) obj, ((Integer) obj2).intValue());
                }
            }, new Function2() { // from class: com.box.android.browse.cpl.navigationmodernization.compose.BrowseNavigationComposeKt$$ExternalSyntheticLambda6
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return BrowseNavigationComposeKt.defaultBrowseViewModels$lambda$0$5((Composer) obj, ((Integer) obj2).intValue());
                }
            }, new Function2() { // from class: com.box.android.browse.cpl.navigationmodernization.compose.BrowseNavigationComposeKt$$ExternalSyntheticLambda7
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return BrowseNavigationComposeKt.defaultBrowseViewModels$lambda$0$6((Composer) obj, ((Integer) obj2).intValue());
                }
            }));
            composer.updateRememberedValue(objRememberedValue);
        }
        BrowseViewModels browseViewModels = (BrowseViewModels) objRememberedValue;
        ComposerKt.sourceInformationMarkerEnd(composer);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return browseViewModels;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final BrowseTabsViewModel defaultBrowseViewModels$lambda$0$0(Composer composer, int i) {
        CreationExtras.Empty defaultViewModelCreationExtras;
        composer.startReplaceGroup(2011859358);
        ComposerKt.sourceInformation(composer, "C77@3858L44:BrowseNavigationCompose.kt#ow8rin");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(2011859358, i, -1, "com.box.android.browse.cpl.navigationmodernization.compose.defaultBrowseViewModels.<anonymous>.<anonymous> (BrowseNavigationCompose.kt:77)");
        }
        ComposerKt.sourceInformationMarkerStart(composer, -1447482489, "CC(hiltActivityViewModel)N(key)159@5773L7,160@5813L56:ComposeUtils.kt#vejmn0");
        ProvidableCompositionLocal<Activity> localActivity = LocalActivityKt.getLocalActivity();
        ComposerKt.sourceInformationMarkerStart(composer, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
        Object objConsume = composer.consume(localActivity);
        ComposerKt.sourceInformationMarkerEnd(composer);
        Intrinsics.checkNotNull(objConsume, "null cannot be cast to non-null type androidx.activity.ComponentActivity");
        ComponentActivity componentActivity = (ComponentActivity) objConsume;
        composer.startReplaceableGroup(1890788296);
        ComposerKt.sourceInformation(composer, "CC(hiltViewModel)P(1)*45@1969L7,50@2112L47,51@2171L54:HiltViewModel.kt#9mcars");
        ViewModelProvider.Factory factoryCreateHiltViewModelFactory = HiltViewModelKt.createHiltViewModelFactory(componentActivity, composer, 0);
        composer.startReplaceableGroup(1729797275);
        ComposerKt.sourceInformation(composer, "CC(viewModel)P(3,2,1)*80@3834L7,90@4209L68:ViewModel.kt#3tja67");
        if (componentActivity instanceof HasDefaultViewModelProviderFactory) {
            defaultViewModelCreationExtras = componentActivity.getDefaultViewModelCreationExtras();
        } else {
            defaultViewModelCreationExtras = CreationExtras.Empty.INSTANCE;
        }
        ViewModel viewModel = ViewModelKt.viewModel((Class<ViewModel>) BrowseTabsViewModel.class, componentActivity, (String) null, factoryCreateHiltViewModelFactory, defaultViewModelCreationExtras, composer, 36936, 0);
        composer.endReplaceableGroup();
        composer.endReplaceableGroup();
        ComposerKt.sourceInformationMarkerEnd(composer);
        BrowseTabsViewModel browseTabsViewModel = (BrowseTabsViewModel) viewModel;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceGroup();
        return browseTabsViewModel;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final AllFilesViewModel defaultBrowseViewModels$lambda$0$1(Composer composer, int i) {
        CreationExtras.Empty defaultViewModelCreationExtras;
        composer.startReplaceGroup(-853442197);
        ComposerKt.sourceInformation(composer, "C78@3940L42:BrowseNavigationCompose.kt#ow8rin");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-853442197, i, -1, "com.box.android.browse.cpl.navigationmodernization.compose.defaultBrowseViewModels.<anonymous>.<anonymous> (BrowseNavigationCompose.kt:78)");
        }
        ComposerKt.sourceInformationMarkerStart(composer, -1447482489, "CC(hiltActivityViewModel)N(key)159@5773L7,160@5813L56:ComposeUtils.kt#vejmn0");
        ProvidableCompositionLocal<Activity> localActivity = LocalActivityKt.getLocalActivity();
        ComposerKt.sourceInformationMarkerStart(composer, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
        Object objConsume = composer.consume(localActivity);
        ComposerKt.sourceInformationMarkerEnd(composer);
        Intrinsics.checkNotNull(objConsume, "null cannot be cast to non-null type androidx.activity.ComponentActivity");
        ComponentActivity componentActivity = (ComponentActivity) objConsume;
        composer.startReplaceableGroup(1890788296);
        ComposerKt.sourceInformation(composer, "CC(hiltViewModel)P(1)*45@1969L7,50@2112L47,51@2171L54:HiltViewModel.kt#9mcars");
        ViewModelProvider.Factory factoryCreateHiltViewModelFactory = HiltViewModelKt.createHiltViewModelFactory(componentActivity, composer, 0);
        composer.startReplaceableGroup(1729797275);
        ComposerKt.sourceInformation(composer, "CC(viewModel)P(3,2,1)*80@3834L7,90@4209L68:ViewModel.kt#3tja67");
        if (componentActivity instanceof HasDefaultViewModelProviderFactory) {
            defaultViewModelCreationExtras = componentActivity.getDefaultViewModelCreationExtras();
        } else {
            defaultViewModelCreationExtras = CreationExtras.Empty.INSTANCE;
        }
        ViewModel viewModel = ViewModelKt.viewModel((Class<ViewModel>) AllFilesViewModel.class, componentActivity, (String) null, factoryCreateHiltViewModelFactory, defaultViewModelCreationExtras, composer, 36936, 0);
        composer.endReplaceableGroup();
        composer.endReplaceableGroup();
        ComposerKt.sourceInformationMarkerEnd(composer);
        AllFilesViewModel allFilesViewModel = (AllFilesViewModel) viewModel;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceGroup();
        return allFilesViewModel;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final OfflinedViewModel defaultBrowseViewModels$lambda$0$2(Composer composer, int i) {
        CreationExtras.Empty defaultViewModelCreationExtras;
        composer.startReplaceGroup(-58690283);
        ComposerKt.sourceInformation(composer, "C79@4020L42:BrowseNavigationCompose.kt#ow8rin");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-58690283, i, -1, "com.box.android.browse.cpl.navigationmodernization.compose.defaultBrowseViewModels.<anonymous>.<anonymous> (BrowseNavigationCompose.kt:79)");
        }
        ComposerKt.sourceInformationMarkerStart(composer, -1447482489, "CC(hiltActivityViewModel)N(key)159@5773L7,160@5813L56:ComposeUtils.kt#vejmn0");
        ProvidableCompositionLocal<Activity> localActivity = LocalActivityKt.getLocalActivity();
        ComposerKt.sourceInformationMarkerStart(composer, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
        Object objConsume = composer.consume(localActivity);
        ComposerKt.sourceInformationMarkerEnd(composer);
        Intrinsics.checkNotNull(objConsume, "null cannot be cast to non-null type androidx.activity.ComponentActivity");
        ComponentActivity componentActivity = (ComponentActivity) objConsume;
        composer.startReplaceableGroup(1890788296);
        ComposerKt.sourceInformation(composer, "CC(hiltViewModel)P(1)*45@1969L7,50@2112L47,51@2171L54:HiltViewModel.kt#9mcars");
        ViewModelProvider.Factory factoryCreateHiltViewModelFactory = HiltViewModelKt.createHiltViewModelFactory(componentActivity, composer, 0);
        composer.startReplaceableGroup(1729797275);
        ComposerKt.sourceInformation(composer, "CC(viewModel)P(3,2,1)*80@3834L7,90@4209L68:ViewModel.kt#3tja67");
        if (componentActivity instanceof HasDefaultViewModelProviderFactory) {
            defaultViewModelCreationExtras = componentActivity.getDefaultViewModelCreationExtras();
        } else {
            defaultViewModelCreationExtras = CreationExtras.Empty.INSTANCE;
        }
        ViewModel viewModel = ViewModelKt.viewModel((Class<ViewModel>) OfflinedViewModel.class, componentActivity, (String) null, factoryCreateHiltViewModelFactory, defaultViewModelCreationExtras, composer, 36936, 0);
        composer.endReplaceableGroup();
        composer.endReplaceableGroup();
        ComposerKt.sourceInformationMarkerEnd(composer);
        OfflinedViewModel offlinedViewModel = (OfflinedViewModel) viewModel;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceGroup();
        return offlinedViewModel;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final RecentsViewModel defaultBrowseViewModels$lambda$0$3(Composer composer, int i) {
        CreationExtras.Empty defaultViewModelCreationExtras;
        composer.startReplaceGroup(-460615185);
        ComposerKt.sourceInformation(composer, "C80@4099L41:BrowseNavigationCompose.kt#ow8rin");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-460615185, i, -1, "com.box.android.browse.cpl.navigationmodernization.compose.defaultBrowseViewModels.<anonymous>.<anonymous> (BrowseNavigationCompose.kt:80)");
        }
        ComposerKt.sourceInformationMarkerStart(composer, -1447482489, "CC(hiltActivityViewModel)N(key)159@5773L7,160@5813L56:ComposeUtils.kt#vejmn0");
        ProvidableCompositionLocal<Activity> localActivity = LocalActivityKt.getLocalActivity();
        ComposerKt.sourceInformationMarkerStart(composer, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
        Object objConsume = composer.consume(localActivity);
        ComposerKt.sourceInformationMarkerEnd(composer);
        Intrinsics.checkNotNull(objConsume, "null cannot be cast to non-null type androidx.activity.ComponentActivity");
        ComponentActivity componentActivity = (ComponentActivity) objConsume;
        composer.startReplaceableGroup(1890788296);
        ComposerKt.sourceInformation(composer, "CC(hiltViewModel)P(1)*45@1969L7,50@2112L47,51@2171L54:HiltViewModel.kt#9mcars");
        ViewModelProvider.Factory factoryCreateHiltViewModelFactory = HiltViewModelKt.createHiltViewModelFactory(componentActivity, composer, 0);
        composer.startReplaceableGroup(1729797275);
        ComposerKt.sourceInformation(composer, "CC(viewModel)P(3,2,1)*80@3834L7,90@4209L68:ViewModel.kt#3tja67");
        if (componentActivity instanceof HasDefaultViewModelProviderFactory) {
            defaultViewModelCreationExtras = componentActivity.getDefaultViewModelCreationExtras();
        } else {
            defaultViewModelCreationExtras = CreationExtras.Empty.INSTANCE;
        }
        ViewModel viewModel = ViewModelKt.viewModel((Class<ViewModel>) RecentsViewModel.class, componentActivity, (String) null, factoryCreateHiltViewModelFactory, defaultViewModelCreationExtras, composer, 36936, 0);
        composer.endReplaceableGroup();
        composer.endReplaceableGroup();
        ComposerKt.sourceInformationMarkerEnd(composer);
        RecentsViewModel recentsViewModel = (RecentsViewModel) viewModel;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceGroup();
        return recentsViewModel;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final UserAvatarViewModel defaultBrowseViewModels$lambda$0$4(Composer composer, int i) {
        CreationExtras.Empty defaultViewModelCreationExtras;
        composer.startReplaceGroup(-1718874634);
        ComposerKt.sourceInformation(composer, "C81@4180L44:BrowseNavigationCompose.kt#ow8rin");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1718874634, i, -1, "com.box.android.browse.cpl.navigationmodernization.compose.defaultBrowseViewModels.<anonymous>.<anonymous> (BrowseNavigationCompose.kt:81)");
        }
        ComposerKt.sourceInformationMarkerStart(composer, -1447482489, "CC(hiltActivityViewModel)N(key)159@5773L7,160@5813L56:ComposeUtils.kt#vejmn0");
        ProvidableCompositionLocal<Activity> localActivity = LocalActivityKt.getLocalActivity();
        ComposerKt.sourceInformationMarkerStart(composer, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
        Object objConsume = composer.consume(localActivity);
        ComposerKt.sourceInformationMarkerEnd(composer);
        Intrinsics.checkNotNull(objConsume, "null cannot be cast to non-null type androidx.activity.ComponentActivity");
        ComponentActivity componentActivity = (ComponentActivity) objConsume;
        composer.startReplaceableGroup(1890788296);
        ComposerKt.sourceInformation(composer, "CC(hiltViewModel)P(1)*45@1969L7,50@2112L47,51@2171L54:HiltViewModel.kt#9mcars");
        ViewModelProvider.Factory factoryCreateHiltViewModelFactory = HiltViewModelKt.createHiltViewModelFactory(componentActivity, composer, 0);
        composer.startReplaceableGroup(1729797275);
        ComposerKt.sourceInformation(composer, "CC(viewModel)P(3,2,1)*80@3834L7,90@4209L68:ViewModel.kt#3tja67");
        if (componentActivity instanceof HasDefaultViewModelProviderFactory) {
            defaultViewModelCreationExtras = componentActivity.getDefaultViewModelCreationExtras();
        } else {
            defaultViewModelCreationExtras = CreationExtras.Empty.INSTANCE;
        }
        ViewModel viewModel = ViewModelKt.viewModel((Class<ViewModel>) UserAvatarViewModel.class, componentActivity, (String) null, factoryCreateHiltViewModelFactory, defaultViewModelCreationExtras, composer, 36936, 0);
        composer.endReplaceableGroup();
        composer.endReplaceableGroup();
        ComposerKt.sourceInformationMarkerEnd(composer);
        UserAvatarViewModel userAvatarViewModel = (UserAvatarViewModel) viewModel;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceGroup();
        return userAvatarViewModel;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final JobsProgressViewModel defaultBrowseViewModels$lambda$0$5(Composer composer, int i) {
        CreationExtras.Empty defaultViewModelCreationExtras;
        composer.startReplaceGroup(808219700);
        ComposerKt.sourceInformation(composer, "C82@4266L46:BrowseNavigationCompose.kt#ow8rin");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(808219700, i, -1, "com.box.android.browse.cpl.navigationmodernization.compose.defaultBrowseViewModels.<anonymous>.<anonymous> (BrowseNavigationCompose.kt:82)");
        }
        ComposerKt.sourceInformationMarkerStart(composer, -1447482489, "CC(hiltActivityViewModel)N(key)159@5773L7,160@5813L56:ComposeUtils.kt#vejmn0");
        ProvidableCompositionLocal<Activity> localActivity = LocalActivityKt.getLocalActivity();
        ComposerKt.sourceInformationMarkerStart(composer, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
        Object objConsume = composer.consume(localActivity);
        ComposerKt.sourceInformationMarkerEnd(composer);
        Intrinsics.checkNotNull(objConsume, "null cannot be cast to non-null type androidx.activity.ComponentActivity");
        ComponentActivity componentActivity = (ComponentActivity) objConsume;
        composer.startReplaceableGroup(1890788296);
        ComposerKt.sourceInformation(composer, "CC(hiltViewModel)P(1)*45@1969L7,50@2112L47,51@2171L54:HiltViewModel.kt#9mcars");
        ViewModelProvider.Factory factoryCreateHiltViewModelFactory = HiltViewModelKt.createHiltViewModelFactory(componentActivity, composer, 0);
        composer.startReplaceableGroup(1729797275);
        ComposerKt.sourceInformation(composer, "CC(viewModel)P(3,2,1)*80@3834L7,90@4209L68:ViewModel.kt#3tja67");
        if (componentActivity instanceof HasDefaultViewModelProviderFactory) {
            defaultViewModelCreationExtras = componentActivity.getDefaultViewModelCreationExtras();
        } else {
            defaultViewModelCreationExtras = CreationExtras.Empty.INSTANCE;
        }
        ViewModel viewModel = ViewModelKt.viewModel((Class<ViewModel>) JobsProgressViewModel.class, componentActivity, (String) null, factoryCreateHiltViewModelFactory, defaultViewModelCreationExtras, composer, 36936, 0);
        composer.endReplaceableGroup();
        composer.endReplaceableGroup();
        ComposerKt.sourceInformationMarkerEnd(composer);
        JobsProgressViewModel jobsProgressViewModel = (JobsProgressViewModel) viewModel;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceGroup();
        return jobsProgressViewModel;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final InboxCountViewModel defaultBrowseViewModels$lambda$0$6(Composer composer, int i) {
        CreationExtras.Empty defaultViewModelCreationExtras;
        composer.startReplaceGroup(-483418791);
        ComposerKt.sourceInformation(composer, "C83@4352L44:BrowseNavigationCompose.kt#ow8rin");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-483418791, i, -1, "com.box.android.browse.cpl.navigationmodernization.compose.defaultBrowseViewModels.<anonymous>.<anonymous> (BrowseNavigationCompose.kt:83)");
        }
        ComposerKt.sourceInformationMarkerStart(composer, -1447482489, "CC(hiltActivityViewModel)N(key)159@5773L7,160@5813L56:ComposeUtils.kt#vejmn0");
        ProvidableCompositionLocal<Activity> localActivity = LocalActivityKt.getLocalActivity();
        ComposerKt.sourceInformationMarkerStart(composer, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
        Object objConsume = composer.consume(localActivity);
        ComposerKt.sourceInformationMarkerEnd(composer);
        Intrinsics.checkNotNull(objConsume, "null cannot be cast to non-null type androidx.activity.ComponentActivity");
        ComponentActivity componentActivity = (ComponentActivity) objConsume;
        composer.startReplaceableGroup(1890788296);
        ComposerKt.sourceInformation(composer, "CC(hiltViewModel)P(1)*45@1969L7,50@2112L47,51@2171L54:HiltViewModel.kt#9mcars");
        ViewModelProvider.Factory factoryCreateHiltViewModelFactory = HiltViewModelKt.createHiltViewModelFactory(componentActivity, composer, 0);
        composer.startReplaceableGroup(1729797275);
        ComposerKt.sourceInformation(composer, "CC(viewModel)P(3,2,1)*80@3834L7,90@4209L68:ViewModel.kt#3tja67");
        if (componentActivity instanceof HasDefaultViewModelProviderFactory) {
            defaultViewModelCreationExtras = componentActivity.getDefaultViewModelCreationExtras();
        } else {
            defaultViewModelCreationExtras = CreationExtras.Empty.INSTANCE;
        }
        ViewModel viewModel = ViewModelKt.viewModel((Class<ViewModel>) InboxCountViewModel.class, componentActivity, (String) null, factoryCreateHiltViewModelFactory, defaultViewModelCreationExtras, composer, 36936, 0);
        composer.endReplaceableGroup();
        composer.endReplaceableGroup();
        ComposerKt.sourceInformationMarkerEnd(composer);
        InboxCountViewModel inboxCountViewModel = (InboxCountViewModel) viewModel;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceGroup();
        return inboxCountViewModel;
    }
}
