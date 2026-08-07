package com.box.android.navigationmodernization.homescreen;

import androidx.compose.animation.AnimatedContentScope;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalKt;
import androidx.compose.runtime.ProvidedValue;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.navigation.NavBackStackEntry;
import androidx.navigation.NavGraphBuilder;
import androidx.navigation.compose.NavGraphBuilderKt;
import com.box.android.base.compose.ComposeAnimationUtilsKt;
import com.box.android.base.cpl.IPreviewLauncher;
import com.box.android.base.presentation.components.tabscreen.TabsSelector;
import com.box.android.base.presentation.message.BoxMessageDispatcher;
import com.box.android.boxai.homescreen.AiCenterViewFactory;
import com.box.android.browse.cpl.navigationmodernization.BrowseDestination;
import com.box.android.browse.cpl.navigationmodernization.BrowseNavigator;
import com.box.android.collections.presentation.navigationmodernization.navigation.CollectionsNavigator;
import com.box.android.coreservices.services.IntentServices;
import com.box.android.domain.models.item.ItemModel;
import com.box.android.domain.models.preview.PreviewSource;
import com.box.android.navigationmodernization.homescreen.navigation.HomeScreenNavigationDependencies;
import com.box.android.navigationmodernization.navigation.RootNavigationDestination;
import com.box.android.navigationmodernization.navigation.compose.RootNavigationMappingKt;
import com.box.android.notes.navigationmodernization.NotesNavigator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: HomeNavigationCompose.kt */
/* JADX INFO: loaded from: classes12.dex */
@Metadata(d1 = {"\u0000J\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u001a¤\u0001\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00010\u000e2\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00010\u000e2\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00010\u000e2\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00010\u000e2\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00010\u000e2\u0018\u0010\u0013\u001a\u0014\u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u00020\u0016\u0012\u0004\u0012\u00020\u00010\u00142\u0010\b\u0002\u0010\u0017\u001a\n\u0012\u0004\u0012\u00020\u0019\u0018\u00010\u0018¨\u0006\u001a"}, d2 = {"homeScreenDestination", "", "Landroidx/navigation/NavGraphBuilder;", "homeScreenNavigationDependencies", "Lcom/box/android/navigationmodernization/homescreen/navigation/HomeScreenNavigationDependencies;", "intentServices", "Lcom/box/android/coreservices/services/IntentServices;", "previewLauncher", "Lcom/box/android/base/cpl/IPreviewLauncher;", "boxMessageDispatcher", "Lcom/box/android/base/presentation/message/BoxMessageDispatcher;", "aiCenterViewFactory", "Lcom/box/android/boxai/homescreen/AiCenterViewFactory;", "onNavigateToFilesSearch", "Lkotlin/Function0;", "onNavigateToNotesSearch", "onNavigateToSettings", "onNavigateToJobsUI", "onNavigateToInbox", "onNavigateToItem", "Lkotlin/Function2;", "Lcom/box/android/domain/models/item/ItemModel;", "Lcom/box/android/domain/models/preview/PreviewSource;", "browseTabsSelector", "Lcom/box/android/base/presentation/components/tabscreen/TabsSelector;", "Lcom/box/android/browse/cpl/navigationmodernization/BrowseDestination$InnerDestination$TabsScreen$BrowseTab;", "box_generalProdRelease"}, k = 2, mv = {2, 2, 0}, xi = 48)
public final class HomeNavigationComposeKt {
    public static final void homeScreenDestination(NavGraphBuilder navGraphBuilder, final HomeScreenNavigationDependencies homeScreenNavigationDependencies, final IntentServices intentServices, final IPreviewLauncher previewLauncher, final BoxMessageDispatcher boxMessageDispatcher, final AiCenterViewFactory aiCenterViewFactory, final Function0<Unit> onNavigateToFilesSearch, final Function0<Unit> onNavigateToNotesSearch, final Function0<Unit> onNavigateToSettings, final Function0<Unit> onNavigateToJobsUI, final Function0<Unit> onNavigateToInbox, final Function2<? super ItemModel, ? super PreviewSource, Unit> onNavigateToItem, final TabsSelector<BrowseDestination.InnerDestination.TabsScreen.BrowseTab> tabsSelector) {
        Intrinsics.checkNotNullParameter(navGraphBuilder, "<this>");
        Intrinsics.checkNotNullParameter(homeScreenNavigationDependencies, "homeScreenNavigationDependencies");
        Intrinsics.checkNotNullParameter(intentServices, "intentServices");
        Intrinsics.checkNotNullParameter(previewLauncher, "previewLauncher");
        Intrinsics.checkNotNullParameter(boxMessageDispatcher, "boxMessageDispatcher");
        Intrinsics.checkNotNullParameter(aiCenterViewFactory, "aiCenterViewFactory");
        Intrinsics.checkNotNullParameter(onNavigateToFilesSearch, "onNavigateToFilesSearch");
        Intrinsics.checkNotNullParameter(onNavigateToNotesSearch, "onNavigateToNotesSearch");
        Intrinsics.checkNotNullParameter(onNavigateToSettings, "onNavigateToSettings");
        Intrinsics.checkNotNullParameter(onNavigateToJobsUI, "onNavigateToJobsUI");
        Intrinsics.checkNotNullParameter(onNavigateToInbox, "onNavigateToInbox");
        Intrinsics.checkNotNullParameter(onNavigateToItem, "onNavigateToItem");
        NavGraphBuilderKt.composable$default(navGraphBuilder, RootNavigationMappingKt.toRoute(RootNavigationDestination.InnerDestination.HomeScreen.INSTANCE), (List) null, (List) null, (Function1) null, (Function1) null, (Function1) null, (Function1) null, (Function1) null, ComposableLambdaKt.composableLambdaInstance(-1946150258, true, new Function4() { // from class: com.box.android.navigationmodernization.homescreen.HomeNavigationComposeKt$$ExternalSyntheticLambda1
            @Override // kotlin.jvm.functions.Function4
            public final Object invoke(Object obj, Object obj2, Object obj3, Object obj4) {
                return HomeNavigationComposeKt.homeScreenDestination$lambda$0(homeScreenNavigationDependencies, intentServices, previewLauncher, boxMessageDispatcher, aiCenterViewFactory, tabsSelector, onNavigateToFilesSearch, onNavigateToNotesSearch, onNavigateToSettings, onNavigateToJobsUI, onNavigateToInbox, onNavigateToItem, (AnimatedContentScope) obj, (NavBackStackEntry) obj2, (Composer) obj3, ((Integer) obj4).intValue());
            }
        }), 254, (Object) null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit homeScreenDestination$lambda$0(final HomeScreenNavigationDependencies homeScreenNavigationDependencies, final IntentServices intentServices, final IPreviewLauncher iPreviewLauncher, final BoxMessageDispatcher boxMessageDispatcher, final AiCenterViewFactory aiCenterViewFactory, final TabsSelector tabsSelector, final Function0 function0, final Function0 function1, final Function0 function2, final Function0 function3, final Function0 function4, final Function2 function5, AnimatedContentScope composable, NavBackStackEntry it, Composer composer, int i) {
        Intrinsics.checkNotNullParameter(composable, "$this$composable");
        Intrinsics.checkNotNullParameter(it, "it");
        ComposerKt.sourceInformation(composer, "CN(it)34@1956L1035,34@1873L1118:HomeNavigationCompose.kt#hf0ugn");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1946150258, i, -1, "com.box.android.navigationmodernization.homescreen.homeScreenDestination.<anonymous> (HomeNavigationCompose.kt:34)");
        }
        CompositionLocalKt.CompositionLocalProvider(ComposeAnimationUtilsKt.getLocalNavAnimatedVisibilityScope().provides(composable), ComposableLambdaKt.rememberComposableLambda(2026311118, true, new Function2() { // from class: com.box.android.navigationmodernization.homescreen.HomeNavigationComposeKt$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(Object obj, Object obj2) {
                return HomeNavigationComposeKt.homeScreenDestination$lambda$0$0(homeScreenNavigationDependencies, intentServices, iPreviewLauncher, boxMessageDispatcher, aiCenterViewFactory, tabsSelector, function0, function1, function2, function3, function4, function5, (Composer) obj, ((Integer) obj2).intValue());
            }
        }, composer, 54), composer, ProvidedValue.$stable | 48);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit homeScreenDestination$lambda$0$0(HomeScreenNavigationDependencies homeScreenNavigationDependencies, IntentServices intentServices, IPreviewLauncher iPreviewLauncher, BoxMessageDispatcher boxMessageDispatcher, AiCenterViewFactory aiCenterViewFactory, TabsSelector tabsSelector, Function0 function0, Function0 function1, Function0 function2, Function0 function3, Function0 function4, Function2 function5, Composer composer, int i) {
        ComposerKt.sourceInformation(composer, "C35@1970L1011:HomeNavigationCompose.kt#hf0ugn");
        if (!composer.shouldExecute((i & 3) != 2, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(2026311118, i, -1, "com.box.android.navigationmodernization.homescreen.homeScreenDestination.<anonymous>.<anonymous> (HomeNavigationCompose.kt:35)");
            }
            HomeScreenKt.HomeScreen(homeScreenNavigationDependencies.getNavigationConfigurator(), homeScreenNavigationDependencies.getNavigator(), homeScreenNavigationDependencies.getNavController(), homeScreenNavigationDependencies.getInnerNavigatorsProvider(), intentServices, iPreviewLauncher, boxMessageDispatcher, aiCenterViewFactory, null, tabsSelector, function0, function1, function2, function3, function4, function5, composer, (((BrowseNavigator.$stable | CollectionsNavigator.$stable) | NotesNavigator.$stable) << 9) | (BoxMessageDispatcher.$stable << 18) | (AiCenterViewFactory.$stable << 21) | (TabsSelector.$stable << 27), 0, 256);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }
}
