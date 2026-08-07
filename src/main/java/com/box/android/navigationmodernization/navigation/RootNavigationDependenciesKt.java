package com.box.android.navigationmodernization.navigation;

import androidx.activity.ComponentActivity;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.navigation.NavHostController;
import androidx.navigation.Navigator;
import androidx.navigation.compose.NavHostControllerKt;
import com.box.android.base.presentation.components.tabscreen.CommonTabsScreenKt;
import com.box.android.base.presentation.components.tabscreen.TabsSelector;
import com.box.android.base.presentation.utilities.IItemClickHandler;
import com.box.android.domain.configuration.FeatureFlips;
import com.box.android.domain.configuration.IBoxAccountSettings;
import com.box.android.domain.services.ITabPersistenceService;
import com.box.android.navigationmodernization.MainNavigationTarget;
import com.box.android.navigationmodernization.homescreen.navigation.HomeScreenNavigationDependencies;
import com.box.android.navigationmodernization.homescreen.navigation.HomeScreenNavigationDependenciesKt;
import com.box.android.navigationmodernization.homescreen.navigation.compose.HomeScreenInnerNavigatorsProvider;
import com.box.android.navigationmodernization.navigation.configuration.MainNavigationTargetConfigFactory;
import com.box.android.navigationmodernization.navigation.configuration.RootNavigationConfigurator;
import com.box.android.navigationmodernization.navigation.navigator.InnerNavigatorsProviderFactory;
import com.box.android.navigationmodernization.navigation.navigator.RootInnerNavigatorsProvider;
import com.box.android.navigationmodernization.navigation.navigator.RootNavigator;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: RootNavigationDependencies.kt */
/* JADX INFO: loaded from: classes12.dex */
@Metadata(d1 = {"\u0000J\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u001ay\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t2\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000b2\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000e0\u000b2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00142\b\b\u0002\u0010\u0015\u001a\u00020\u00162\b\b\u0002\u0010\u0017\u001a\u00020\u0016H\u0007¢\u0006\u0002\u0010\u0018¨\u0006\u0019"}, d2 = {"rememberRootNavigationDependencies", "Lcom/box/android/navigationmodernization/navigation/RootNavigationDependencies;", "featureFlips", "Lcom/box/android/domain/configuration/FeatureFlips;", "boxAccountSettings", "Lcom/box/android/domain/configuration/IBoxAccountSettings;", "tabPersistenceService", "Lcom/box/android/domain/services/ITabPersistenceService;", "navigationTarget", "Lcom/box/android/navigationmodernization/MainNavigationTarget;", "rootNavigatorsFactory", "Lcom/box/android/navigationmodernization/navigation/navigator/InnerNavigatorsProviderFactory;", "Lcom/box/android/navigationmodernization/navigation/navigator/RootInnerNavigatorsProvider;", "homeScreenNavigatorsFactory", "Lcom/box/android/navigationmodernization/homescreen/navigation/compose/HomeScreenInnerNavigatorsProvider;", "activity", "Landroidx/activity/ComponentActivity;", "itemClickHandler", "Lcom/box/android/base/presentation/utilities/IItemClickHandler;", "mainNavigationTargetConfigFactory", "Lcom/box/android/navigationmodernization/navigation/configuration/MainNavigationTargetConfigFactory;", "rootNavController", "Landroidx/navigation/NavHostController;", "homeScreenNavController", "(Lcom/box/android/domain/configuration/FeatureFlips;Lcom/box/android/domain/configuration/IBoxAccountSettings;Lcom/box/android/domain/services/ITabPersistenceService;Lcom/box/android/navigationmodernization/MainNavigationTarget;Lcom/box/android/navigationmodernization/navigation/navigator/InnerNavigatorsProviderFactory;Lcom/box/android/navigationmodernization/navigation/navigator/InnerNavigatorsProviderFactory;Landroidx/activity/ComponentActivity;Lcom/box/android/base/presentation/utilities/IItemClickHandler;Lcom/box/android/navigationmodernization/navigation/configuration/MainNavigationTargetConfigFactory;Landroidx/navigation/NavHostController;Landroidx/navigation/NavHostController;Landroidx/compose/runtime/Composer;III)Lcom/box/android/navigationmodernization/navigation/RootNavigationDependencies;", "box_generalProdRelease"}, k = 2, mv = {2, 2, 0}, xi = 48)
public final class RootNavigationDependenciesKt {
    public static final RootNavigationDependencies rememberRootNavigationDependencies(FeatureFlips featureFlips, IBoxAccountSettings boxAccountSettings, ITabPersistenceService tabPersistenceService, MainNavigationTarget mainNavigationTarget, InnerNavigatorsProviderFactory<RootInnerNavigatorsProvider> rootNavigatorsFactory, InnerNavigatorsProviderFactory<HomeScreenInnerNavigatorsProvider> homeScreenNavigatorsFactory, ComponentActivity activity, IItemClickHandler itemClickHandler, MainNavigationTargetConfigFactory mainNavigationTargetConfigFactory, NavHostController navHostController, NavHostController navHostController2, Composer composer, int i, int i2, int i3) {
        Intrinsics.checkNotNullParameter(featureFlips, "featureFlips");
        Intrinsics.checkNotNullParameter(boxAccountSettings, "boxAccountSettings");
        Intrinsics.checkNotNullParameter(tabPersistenceService, "tabPersistenceService");
        Intrinsics.checkNotNullParameter(rootNavigatorsFactory, "rootNavigatorsFactory");
        Intrinsics.checkNotNullParameter(homeScreenNavigatorsFactory, "homeScreenNavigatorsFactory");
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(itemClickHandler, "itemClickHandler");
        Intrinsics.checkNotNullParameter(mainNavigationTargetConfigFactory, "mainNavigationTargetConfigFactory");
        ComposerKt.sourceInformationMarkerStart(composer, -538507156, "C(rememberRootNavigationDependencies)N(featureFlips,boxAccountSettings,tabPersistenceService,navigationTarget,rootNavigatorsFactory,homeScreenNavigatorsFactory,activity,itemClickHandler,mainNavigationTargetConfigFactory,rootNavController,homeScreenNavController)67@3924L23,68@3998L23,71@4139L459,83@4666L60,86@4882L1394:RootNavigationDependencies.kt#ii2ips");
        MainNavigationTarget mainNavigationTarget2 = (i3 & 8) != 0 ? null : mainNavigationTarget;
        NavHostController navHostControllerRememberNavController = (i3 & 512) != 0 ? NavHostControllerKt.rememberNavController(new Navigator[0], composer, 0) : navHostController;
        NavHostController navHostControllerRememberNavController2 = (i3 & 1024) != 0 ? NavHostControllerKt.rememberNavController(new Navigator[0], composer, 0) : navHostController2;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-538507156, i, i2, "com.box.android.navigationmodernization.navigation.rememberRootNavigationDependencies (RootNavigationDependencies.kt:69)");
        }
        int i4 = i >> 3;
        int i5 = i & 7168;
        HomeScreenNavigationDependencies homeScreenNavigationDependenciesRememberHomeScreenNavigationDependencies = HomeScreenNavigationDependenciesKt.rememberHomeScreenNavigationDependencies(boxAccountSettings, featureFlips, tabPersistenceService, mainNavigationTarget2, homeScreenNavigatorsFactory, activity, mainNavigationTargetConfigFactory, navHostControllerRememberNavController2, composer, (i & 896) | (i4 & 14) | ((i << 3) & 112) | i5 | (i4 & 57344) | (i4 & 458752) | ((i >> 6) & 3670016) | ((i2 << 21) & 29360128), 0);
        TabsSelector tabsSelectorRememberTabsSelector = CommonTabsScreenKt.rememberTabsSelector(composer, 0);
        RootNavigationConfigurator rootNavigationConfigurator = new RootNavigationConfigurator(mainNavigationTargetConfigFactory, mainNavigationTarget2);
        ComposerKt.sourceInformationMarkerStart(composer, -2109250178, "CC(remember):RootNavigationDependencies.kt#9igjgp");
        boolean zChanged = composer.changed(navHostControllerRememberNavController) | composer.changed(homeScreenNavigationDependenciesRememberHomeScreenNavigationDependencies) | (((i5 ^ 3072) > 2048 && composer.changed(mainNavigationTarget2)) || (i & 3072) == 2048) | composer.changed(tabsSelectorRememberTabsSelector);
        Object objRememberedValue = composer.rememberedValue();
        if (zChanged || objRememberedValue == Composer.INSTANCE.getEmpty()) {
            RootNavigator rootNavigator = new RootNavigator(navHostControllerRememberNavController, activity, itemClickHandler, featureFlips);
            Object rootNavigationDependencies = new RootNavigationDependencies(rootNavigationConfigurator, navHostControllerRememberNavController, rootNavigator, rootNavigatorsFactory.create(navHostControllerRememberNavController), tabsSelectorRememberTabsSelector, homeScreenNavigationDependenciesRememberHomeScreenNavigationDependencies, mainNavigationTargetConfigFactory, new MainNavigationTargetRequestHandler(mainNavigationTargetConfigFactory, rootNavigator, homeScreenNavigationDependenciesRememberHomeScreenNavigationDependencies.getNavigator(), homeScreenNavigationDependenciesRememberHomeScreenNavigationDependencies.getInnerNavigatorsProvider().getCollectionsNavigator(), homeScreenNavigationDependenciesRememberHomeScreenNavigationDependencies.getBrowseTabsSelector(), tabsSelectorRememberTabsSelector));
            composer.updateRememberedValue(rootNavigationDependencies);
            objRememberedValue = rootNavigationDependencies;
        }
        RootNavigationDependencies rootNavigationDependencies2 = (RootNavigationDependencies) objRememberedValue;
        ComposerKt.sourceInformationMarkerEnd(composer);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return rootNavigationDependencies2;
    }
}
