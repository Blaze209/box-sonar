package com.box.android.hubs.navigationmodernization;

import androidx.compose.animation.AnimatedContentScope;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.hilt.navigation.compose.HiltViewModelKt;
import androidx.lifecycle.HasDefaultViewModelProviderFactory;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStoreOwner;
import androidx.lifecycle.viewmodel.CreationExtras;
import androidx.lifecycle.viewmodel.compose.LocalViewModelStoreOwner;
import androidx.lifecycle.viewmodel.compose.ViewModelKt;
import androidx.navigation.NavBackStackEntry;
import androidx.navigation.NavGraphBuilder;
import androidx.navigation.compose.NavGraphBuilderKt;
import com.box.android.coreservices.services.IntentServices;
import com.box.android.hubs.presentation.HubsScreenKt;
import com.box.android.hubs.presentation.HubsViewModel;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: HubsNavigationCompose.kt */
/* JADX INFO: loaded from: classes12.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a\u0012\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0004¨\u0006\u0005"}, d2 = {"hubsNavigationGraph", "", "Landroidx/navigation/NavGraphBuilder;", "intentServices", "Lcom/box/android/coreservices/services/IntentServices;", "hubs_generalProdRelease"}, k = 2, mv = {2, 2, 0}, xi = 48)
public final class HubsNavigationComposeKt {
    public static final void hubsNavigationGraph(NavGraphBuilder navGraphBuilder, final IntentServices intentServices) {
        Intrinsics.checkNotNullParameter(navGraphBuilder, "<this>");
        Intrinsics.checkNotNullParameter(intentServices, "intentServices");
        String strGraphToRoute = HubsNavigationMappingKt.graphToRoute(HubsDestination.INSTANCE);
        NavGraphBuilder navGraphBuilder2 = new NavGraphBuilder(navGraphBuilder.getProvider(), HubsNavigationMappingKt.toRoute(HubsDestination.Hubs.INSTANCE), strGraphToRoute);
        NavGraphBuilderKt.composable$default(navGraphBuilder2, HubsNavigationMappingKt.toRoute(HubsDestination.Hubs.INSTANCE), (List) null, (List) null, (Function1) null, (Function1) null, (Function1) null, (Function1) null, (Function1) null, ComposableLambdaKt.composableLambdaInstance(-635130175, true, new Function4() { // from class: com.box.android.hubs.navigationmodernization.HubsNavigationComposeKt$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function4
            public final Object invoke(Object obj, Object obj2, Object obj3, Object obj4) {
                return HubsNavigationComposeKt.hubsNavigationGraph$lambda$0$0(intentServices, (AnimatedContentScope) obj, (NavBackStackEntry) obj2, (Composer) obj3, ((Integer) obj4).intValue());
            }
        }), 254, (Object) null);
        navGraphBuilder.destination(navGraphBuilder2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit hubsNavigationGraph$lambda$0$0(IntentServices intentServices, AnimatedContentScope composable, NavBackStackEntry it, Composer composer, int i) {
        CreationExtras.Empty defaultViewModelCreationExtras;
        Intrinsics.checkNotNullParameter(composable, "$this$composable");
        Intrinsics.checkNotNullParameter(it, "it");
        ComposerKt.sourceInformation(composer, "CN(it)30@1306L15,31@1334L158:HubsNavigationCompose.kt#myyjow");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-635130175, i, -1, "com.box.android.hubs.navigationmodernization.hubsNavigationGraph.<anonymous>.<anonymous> (HubsNavigationCompose.kt:30)");
        }
        composer.startReplaceableGroup(1890788296);
        ComposerKt.sourceInformation(composer, "CC(hiltViewModel)P(1)*45@1969L7,50@2112L47,51@2171L54:HiltViewModel.kt#9mcars");
        ViewModelStoreOwner current = LocalViewModelStoreOwner.INSTANCE.getCurrent(composer, LocalViewModelStoreOwner.$stable);
        if (current == null) {
            throw new IllegalStateException("No ViewModelStoreOwner was provided via LocalViewModelStoreOwner".toString());
        }
        ViewModelProvider.Factory factoryCreateHiltViewModelFactory = HiltViewModelKt.createHiltViewModelFactory(current, composer, 0);
        composer.startReplaceableGroup(1729797275);
        ComposerKt.sourceInformation(composer, "CC(viewModel)P(3,2,1)*80@3834L7,90@4209L68:ViewModel.kt#3tja67");
        if (current instanceof HasDefaultViewModelProviderFactory) {
            defaultViewModelCreationExtras = ((HasDefaultViewModelProviderFactory) current).getDefaultViewModelCreationExtras();
        } else {
            defaultViewModelCreationExtras = CreationExtras.Empty.INSTANCE;
        }
        ViewModel viewModel = ViewModelKt.viewModel((Class<ViewModel>) HubsViewModel.class, current, (String) null, factoryCreateHiltViewModelFactory, defaultViewModelCreationExtras, composer, 36936, 0);
        composer.endReplaceableGroup();
        composer.endReplaceableGroup();
        HubsScreenKt.HubsScreen(((HubsViewModel) viewModel).getStore(), intentServices, true, composer, 384, 0);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        return Unit.INSTANCE;
    }
}
