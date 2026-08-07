package com.box.android.inbox;

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
import com.box.android.base.compose.ComposeAnimationUtilsKt;
import com.box.android.base.compose.ComposeFragmentInjector;
import com.box.android.base.presentation.components.tabscreen.TabsSelector;
import com.box.android.coreservices.services.IntentServices;
import com.box.android.domain.identity.IUserContextManager;
import com.box.android.domain.models.item.ItemModel;
import com.box.android.domain.models.preview.PreviewSource;
import com.box.android.inbox.notifications.InboxViewModel;
import com.box.android.inbox.tabsscreen.InboxTabsScreenKt;
import com.box.android.inbox.tabsscreen.InboxTabsViewModel;
import com.box.android.inbox.tabsscreen.InboxTabsViewModels;
import com.box.android.vm.InboxBadgeVM;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: InboxNavigationCompose.kt */
/* JADX INFO: loaded from: classes12.dex */
@Metadata(d1 = {"\u0000^\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a¤\u0001\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n26\u0010\u000b\u001a2\u0012\u0013\u0012\u00110\r¢\u0006\f\b\u000e\u0012\b\b\u000f\u0012\u0004\b\b(\u0010\u0012\u0013\u0012\u00110\u0011¢\u0006\f\b\u000e\u0012\b\b\u000f\u0012\u0004\b\b(\u0012\u0012\u0004\u0012\u00020\u00010\f2\u0006\u0010\u0013\u001a\u00020\u00142\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00010\u00162\u0010\b\u0002\u0010\u0017\u001a\n\u0012\u0004\u0012\u00020\u0019\u0018\u00010\u00182\u0013\b\u0002\u0010\u001a\u001a\r\u0012\u0004\u0012\u00020\u001b0\u0016¢\u0006\u0002\b\u001c¢\u0006\u0002\u0010\u001d\u001a\r\u0010\u001e\u001a\u00020\u001bH\u0003¢\u0006\u0002\u0010\u001f¨\u0006 "}, d2 = {"inboxNavigationGraph", "", "Landroidx/navigation/NavGraphBuilder;", "inboxNavigationConfig", "Lcom/box/android/inbox/InboxNavigationConfig;", "composeFragmentInjector", "Lcom/box/android/base/compose/ComposeFragmentInjector;", "intentServices", "Lcom/box/android/coreservices/services/IntentServices;", "userContextManager", "Lcom/box/android/domain/identity/IUserContextManager;", "onNavigateToTask", "Lkotlin/Function2;", "Lcom/box/android/domain/models/item/ItemModel;", "Lkotlin/ParameterName;", "name", "itemModel", "Lcom/box/android/domain/models/preview/PreviewSource;", "source", "snackbarHostState", "Landroidx/compose/material3/SnackbarHostState;", "onNavigateBack", "Lkotlin/Function0;", "tabsSelector", "Lcom/box/android/base/presentation/components/tabscreen/TabsSelector;", "Lcom/box/android/inbox/InboxDestination$TabsScreen$InboxTab;", "inboxViewModelsProvider", "Lcom/box/android/inbox/InboxViewModels;", "Landroidx/compose/runtime/Composable;", "(Landroidx/navigation/NavGraphBuilder;Lcom/box/android/inbox/InboxNavigationConfig;Lcom/box/android/base/compose/ComposeFragmentInjector;Lcom/box/android/coreservices/services/IntentServices;Lcom/box/android/domain/identity/IUserContextManager;Lkotlin/jvm/functions/Function2;Landroidx/compose/material3/SnackbarHostState;Lkotlin/jvm/functions/Function0;Lcom/box/android/base/presentation/components/tabscreen/TabsSelector;Lkotlin/jvm/functions/Function2;)V", "defaultInboxViewModels", "(Landroidx/compose/runtime/Composer;I)Lcom/box/android/inbox/InboxViewModels;", "box_generalProdRelease"}, k = 2, mv = {2, 2, 0}, xi = 48)
public final class InboxNavigationComposeKt {
    /* JADX INFO: Access modifiers changed from: private */
    public static final InboxViewModels inboxNavigationGraph$lambda$0(Composer composer, int i) {
        composer.startReplaceGroup(1304527714);
        ComposerKt.sourceInformation(composer, "C38@1879L24:InboxNavigationCompose.kt#72wfg7");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1304527714, i, -1, "com.box.android.inbox.inboxNavigationGraph.<anonymous> (InboxNavigationCompose.kt:38)");
        }
        InboxViewModels inboxViewModelsDefaultInboxViewModels = defaultInboxViewModels(composer, 0);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceGroup();
        return inboxViewModelsDefaultInboxViewModels;
    }

    public static final void inboxNavigationGraph(NavGraphBuilder navGraphBuilder, final InboxNavigationConfig inboxNavigationConfig, final ComposeFragmentInjector composeFragmentInjector, final IntentServices intentServices, final IUserContextManager userContextManager, final Function2<? super ItemModel, ? super PreviewSource, Unit> onNavigateToTask, final SnackbarHostState snackbarHostState, final Function0<Unit> onNavigateBack, final TabsSelector<InboxDestination.TabsScreen.InboxTab> tabsSelector, final Function2<? super Composer, ? super Integer, InboxViewModels> inboxViewModelsProvider) {
        Intrinsics.checkNotNullParameter(navGraphBuilder, "<this>");
        Intrinsics.checkNotNullParameter(inboxNavigationConfig, "inboxNavigationConfig");
        Intrinsics.checkNotNullParameter(composeFragmentInjector, "composeFragmentInjector");
        Intrinsics.checkNotNullParameter(intentServices, "intentServices");
        Intrinsics.checkNotNullParameter(userContextManager, "userContextManager");
        Intrinsics.checkNotNullParameter(onNavigateToTask, "onNavigateToTask");
        Intrinsics.checkNotNullParameter(snackbarHostState, "snackbarHostState");
        Intrinsics.checkNotNullParameter(onNavigateBack, "onNavigateBack");
        Intrinsics.checkNotNullParameter(inboxViewModelsProvider, "inboxViewModelsProvider");
        String strGraphToRoute = InboxNavigationMappingKt.graphToRoute(InboxDestination.INSTANCE);
        NavGraphBuilderKt.navigation$default(navGraphBuilder, InboxNavigationMappingKt.toRoute(inboxNavigationConfig.getStartDestination()), strGraphToRoute, (List) null, (List) null, ComposeAnimationUtilsKt.slidingNavGraphEnterTransition(strGraphToRoute), ComposeAnimationUtilsKt.slidingNavGraphExitTransition(strGraphToRoute), ComposeAnimationUtilsKt.slidingNavGraphEnterTransition(strGraphToRoute), ComposeAnimationUtilsKt.slidingNavGraphExitTransition(strGraphToRoute), (Function1) null, new Function1() { // from class: com.box.android.inbox.InboxNavigationComposeKt$$ExternalSyntheticLambda4
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return InboxNavigationComposeKt.inboxNavigationGraph$lambda$1(inboxNavigationConfig, inboxViewModelsProvider, composeFragmentInjector, intentServices, userContextManager, onNavigateToTask, snackbarHostState, onNavigateBack, tabsSelector, (NavGraphBuilder) obj);
            }
        }, 268, (Object) null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit inboxNavigationGraph$lambda$1(final InboxNavigationConfig inboxNavigationConfig, final Function2 function2, final ComposeFragmentInjector composeFragmentInjector, final IntentServices intentServices, final IUserContextManager iUserContextManager, final Function2 function3, final SnackbarHostState snackbarHostState, final Function0 function0, final TabsSelector tabsSelector, NavGraphBuilder navigation) {
        Intrinsics.checkNotNullParameter(navigation, "$this$navigation");
        NavGraphBuilderKt.composable$default(navigation, InboxNavigationMappingKt.toRoute(inboxNavigationConfig.getStartDestination()), (List) null, (List) null, (Function1) null, (Function1) null, (Function1) null, (Function1) null, (Function1) null, ComposableLambdaKt.composableLambdaInstance(1056788141, true, new Function4() { // from class: com.box.android.inbox.InboxNavigationComposeKt$$ExternalSyntheticLambda5
            @Override // kotlin.jvm.functions.Function4
            public final Object invoke(Object obj, Object obj2, Object obj3, Object obj4) {
                return InboxNavigationComposeKt.inboxNavigationGraph$lambda$1$0(inboxNavigationConfig, function2, composeFragmentInjector, intentServices, iUserContextManager, function3, snackbarHostState, function0, tabsSelector, (AnimatedContentScope) obj, (NavBackStackEntry) obj2, (Composer) obj3, ((Integer) obj4).intValue());
            }
        }), 254, (Object) null);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit inboxNavigationGraph$lambda$1$0(InboxNavigationConfig inboxNavigationConfig, Function2 function2, ComposeFragmentInjector composeFragmentInjector, IntentServices intentServices, IUserContextManager iUserContextManager, Function2 function3, SnackbarHostState snackbarHostState, Function0 function0, TabsSelector tabsSelector, AnimatedContentScope composable, NavBackStackEntry it, Composer composer, int i) {
        Intrinsics.checkNotNullParameter(composable, "$this$composable");
        Intrinsics.checkNotNullParameter(it, "it");
        ComposerKt.sourceInformation(composer, "CN(it)52@2587L25,50@2464L552:InboxNavigationCompose.kt#72wfg7");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1056788141, i, -1, "com.box.android.inbox.inboxNavigationGraph.<anonymous>.<anonymous> (InboxNavigationCompose.kt:50)");
        }
        InboxTabsScreenKt.InboxTabsScreen(inboxNavigationConfig.getStartDestination(), ((InboxViewModels) function2.invoke(composer, 0)).getTabsViewModels(), composeFragmentInjector, intentServices, iUserContextManager, function3, snackbarHostState, function0, tabsSelector, null, composer, TabsSelector.$stable << 24, 512);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        return Unit.INSTANCE;
    }

    private static final InboxViewModels defaultInboxViewModels(Composer composer, int i) {
        ComposerKt.sourceInformationMarkerStart(composer, 146109220, "C(defaultInboxViewModels)70@3201L326:InboxNavigationCompose.kt#72wfg7");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(146109220, i, -1, "com.box.android.inbox.defaultInboxViewModels (InboxNavigationCompose.kt:70)");
        }
        ComposerKt.sourceInformationMarkerStart(composer, -1322958486, "CC(remember):InboxNavigationCompose.kt#9igjgp");
        Object objRememberedValue = composer.rememberedValue();
        if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
            objRememberedValue = new InboxViewModels(new InboxTabsViewModels(new Function2() { // from class: com.box.android.inbox.InboxNavigationComposeKt$$ExternalSyntheticLambda0
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return InboxNavigationComposeKt.defaultInboxViewModels$lambda$0$0((Composer) obj, ((Integer) obj2).intValue());
                }
            }, new Function2() { // from class: com.box.android.inbox.InboxNavigationComposeKt$$ExternalSyntheticLambda1
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return InboxNavigationComposeKt.defaultInboxViewModels$lambda$0$1((Composer) obj, ((Integer) obj2).intValue());
                }
            }, new Function2() { // from class: com.box.android.inbox.InboxNavigationComposeKt$$ExternalSyntheticLambda2
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return InboxNavigationComposeKt.defaultInboxViewModels$lambda$0$2((Composer) obj, ((Integer) obj2).intValue());
                }
            }));
            composer.updateRememberedValue(objRememberedValue);
        }
        InboxViewModels inboxViewModels = (InboxViewModels) objRememberedValue;
        ComposerKt.sourceInformationMarkerEnd(composer);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return inboxViewModels;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final InboxTabsViewModel defaultInboxViewModels$lambda$0$0(Composer composer, int i) {
        CreationExtras.Empty defaultViewModelCreationExtras;
        composer.startReplaceGroup(-380063352);
        ComposerKt.sourceInformation(composer, "C73@3305L43:InboxNavigationCompose.kt#72wfg7");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-380063352, i, -1, "com.box.android.inbox.defaultInboxViewModels.<anonymous>.<anonymous> (InboxNavigationCompose.kt:73)");
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
        ViewModel viewModel = ViewModelKt.viewModel((Class<ViewModel>) InboxTabsViewModel.class, componentActivity, (String) null, factoryCreateHiltViewModelFactory, defaultViewModelCreationExtras, composer, 36936, 0);
        composer.endReplaceableGroup();
        composer.endReplaceableGroup();
        ComposerKt.sourceInformationMarkerEnd(composer);
        InboxTabsViewModel inboxTabsViewModel = (InboxTabsViewModel) viewModel;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceGroup();
        return inboxTabsViewModel;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final InboxViewModel defaultInboxViewModels$lambda$0$1(Composer composer, int i) {
        CreationExtras.Empty defaultViewModelCreationExtras;
        composer.startReplaceGroup(529617895);
        ComposerKt.sourceInformation(composer, "C74@3391L39:InboxNavigationCompose.kt#72wfg7");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(529617895, i, -1, "com.box.android.inbox.defaultInboxViewModels.<anonymous>.<anonymous> (InboxNavigationCompose.kt:74)");
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
        ViewModel viewModel = ViewModelKt.viewModel((Class<ViewModel>) InboxViewModel.class, componentActivity, (String) null, factoryCreateHiltViewModelFactory, defaultViewModelCreationExtras, composer, 36936, 0);
        composer.endReplaceableGroup();
        composer.endReplaceableGroup();
        ComposerKt.sourceInformationMarkerEnd(composer);
        InboxViewModel inboxViewModel = (InboxViewModel) viewModel;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceGroup();
        return inboxViewModel;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final InboxBadgeVM defaultInboxViewModels$lambda$0$2(Composer composer, int i) {
        CreationExtras.Empty defaultViewModelCreationExtras;
        composer.startReplaceGroup(765619838);
        ComposerKt.sourceInformation(composer, "C75@3470L37:InboxNavigationCompose.kt#72wfg7");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(765619838, i, -1, "com.box.android.inbox.defaultInboxViewModels.<anonymous>.<anonymous> (InboxNavigationCompose.kt:75)");
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
        ViewModel viewModel = ViewModelKt.viewModel((Class<ViewModel>) InboxBadgeVM.class, componentActivity, (String) null, factoryCreateHiltViewModelFactory, defaultViewModelCreationExtras, composer, 36936, 0);
        composer.endReplaceableGroup();
        composer.endReplaceableGroup();
        ComposerKt.sourceInformationMarkerEnd(composer);
        InboxBadgeVM inboxBadgeVM = (InboxBadgeVM) viewModel;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceGroup();
        return inboxBadgeVM;
    }
}
