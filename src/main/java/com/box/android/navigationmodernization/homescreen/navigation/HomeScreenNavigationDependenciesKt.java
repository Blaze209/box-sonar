package com.box.android.navigationmodernization.homescreen.navigation;

import androidx.activity.ComponentActivity;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.navigation.NavHostController;
import androidx.navigation.Navigator;
import androidx.navigation.compose.NavHostControllerKt;
import com.box.android.base.presentation.components.tabscreen.CommonTabsScreenKt;
import com.box.android.base.presentation.components.tabscreen.TabsSelector;
import com.box.android.domain.configuration.FeatureFlips;
import com.box.android.domain.configuration.IBoxAccountSettings;
import com.box.android.domain.services.ITabPersistenceService;
import com.box.android.navigationmodernization.MainNavigationTarget;
import com.box.android.navigationmodernization.homescreen.navigation.compose.HomeScreenInnerNavigatorsProvider;
import com.box.android.navigationmodernization.homescreen.navigation.configuration.HomeScreenNavigationConfigurator;
import com.box.android.navigationmodernization.navigation.configuration.MainNavigationTargetConfigFactory;
import com.box.android.navigationmodernization.navigation.navigator.InnerNavigatorsProviderFactory;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: HomeScreenNavigationDependencies.kt */
/* JADX INFO: loaded from: classes12.dex */
@Metadata(d1 = {"\u0000>\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001aY\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t2\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000b2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\b\b\u0002\u0010\u0011\u001a\u00020\u0012H\u0007¢\u0006\u0002\u0010\u0013¨\u0006\u0014"}, d2 = {"rememberHomeScreenNavigationDependencies", "Lcom/box/android/navigationmodernization/homescreen/navigation/HomeScreenNavigationDependencies;", "boxAccountSettings", "Lcom/box/android/domain/configuration/IBoxAccountSettings;", "featureFlips", "Lcom/box/android/domain/configuration/FeatureFlips;", "tabPersistenceService", "Lcom/box/android/domain/services/ITabPersistenceService;", "navigationTarget", "Lcom/box/android/navigationmodernization/MainNavigationTarget;", "innerNavigatorsProviderFactory", "Lcom/box/android/navigationmodernization/navigation/navigator/InnerNavigatorsProviderFactory;", "Lcom/box/android/navigationmodernization/homescreen/navigation/compose/HomeScreenInnerNavigatorsProvider;", "activity", "Landroidx/activity/ComponentActivity;", "mainNavigationTargetConfigFactory", "Lcom/box/android/navigationmodernization/navigation/configuration/MainNavigationTargetConfigFactory;", "navController", "Landroidx/navigation/NavHostController;", "(Lcom/box/android/domain/configuration/IBoxAccountSettings;Lcom/box/android/domain/configuration/FeatureFlips;Lcom/box/android/domain/services/ITabPersistenceService;Lcom/box/android/navigationmodernization/MainNavigationTarget;Lcom/box/android/navigationmodernization/navigation/navigator/InnerNavigatorsProviderFactory;Landroidx/activity/ComponentActivity;Lcom/box/android/navigationmodernization/navigation/configuration/MainNavigationTargetConfigFactory;Landroidx/navigation/NavHostController;Landroidx/compose/runtime/Composer;II)Lcom/box/android/navigationmodernization/homescreen/navigation/HomeScreenNavigationDependencies;", "box_generalProdRelease"}, k = 2, mv = {2, 2, 0}, xi = 48)
public final class HomeScreenNavigationDependenciesKt {
    public static final HomeScreenNavigationDependencies rememberHomeScreenNavigationDependencies(IBoxAccountSettings boxAccountSettings, FeatureFlips featureFlips, ITabPersistenceService tabPersistenceService, MainNavigationTarget mainNavigationTarget, InnerNavigatorsProviderFactory<HomeScreenInnerNavigatorsProvider> innerNavigatorsProviderFactory, ComponentActivity activity, MainNavigationTargetConfigFactory mainNavigationTargetConfigFactory, NavHostController navHostController, Composer composer, int i, int i2) {
        Intrinsics.checkNotNullParameter(boxAccountSettings, "boxAccountSettings");
        Intrinsics.checkNotNullParameter(featureFlips, "featureFlips");
        Intrinsics.checkNotNullParameter(tabPersistenceService, "tabPersistenceService");
        Intrinsics.checkNotNullParameter(innerNavigatorsProviderFactory, "innerNavigatorsProviderFactory");
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(mainNavigationTargetConfigFactory, "mainNavigationTargetConfigFactory");
        ComposerKt.sourceInformationMarkerStart(composer, 674769598, "C(rememberHomeScreenNavigationDependencies)N(boxAccountSettings,featureFlips,tabPersistenceService,navigationTarget,innerNavigatorsProviderFactory,activity,mainNavigationTargetConfigFactory,navController)53@2952L23,55@3045L79,57@3137L955:HomeScreenNavigationDependencies.kt#unvutx");
        MainNavigationTarget mainNavigationTarget2 = (i2 & 8) != 0 ? null : mainNavigationTarget;
        NavHostController navHostControllerRememberNavController = (i2 & 128) != 0 ? NavHostControllerKt.rememberNavController(new Navigator[0], composer, 0) : navHostController;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(674769598, i, -1, "com.box.android.navigationmodernization.homescreen.navigation.rememberHomeScreenNavigationDependencies (HomeScreenNavigationDependencies.kt:54)");
        }
        TabsSelector tabsSelectorRememberTabsSelector = CommonTabsScreenKt.rememberTabsSelector(composer, 0);
        ComposerKt.sourceInformationMarkerStart(composer, -86455943, "CC(remember):HomeScreenNavigationDependencies.kt#9igjgp");
        boolean zChanged = composer.changed(navHostControllerRememberNavController) | ((((i & 7168) ^ 3072) > 2048 && composer.changed(mainNavigationTarget2)) || (i & 3072) == 2048) | composer.changed(mainNavigationTargetConfigFactory) | composer.changed(tabsSelectorRememberTabsSelector);
        Object objRememberedValue = composer.rememberedValue();
        if (zChanged || objRememberedValue == Composer.INSTANCE.getEmpty()) {
            Object homeScreenNavigationDependencies = new HomeScreenNavigationDependencies(new HomeScreenNavigationConfigurator(boxAccountSettings, featureFlips, tabPersistenceService, mainNavigationTargetConfigFactory, mainNavigationTarget2), navHostControllerRememberNavController, new HomeScreenNavigator(navHostControllerRememberNavController), innerNavigatorsProviderFactory.create(navHostControllerRememberNavController), tabsSelectorRememberTabsSelector);
            composer.updateRememberedValue(homeScreenNavigationDependencies);
            objRememberedValue = homeScreenNavigationDependencies;
        }
        HomeScreenNavigationDependencies homeScreenNavigationDependencies2 = (HomeScreenNavigationDependencies) objRememberedValue;
        ComposerKt.sourceInformationMarkerEnd(composer);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return homeScreenNavigationDependencies2;
    }
}
