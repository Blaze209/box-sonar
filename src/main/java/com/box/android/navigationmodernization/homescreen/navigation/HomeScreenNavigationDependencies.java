package com.box.android.navigationmodernization.homescreen.navigation;

import androidx.navigation.NavHostController;
import com.box.android.base.presentation.components.tabscreen.TabsSelector;
import com.box.android.browse.cpl.navigationmodernization.BrowseDestination;
import com.box.android.domain.analytics.BoxAmplitudeAnalytics;
import com.box.android.navigationmodernization.homescreen.navigation.compose.HomeScreenInnerNavigatorsProvider;
import com.box.android.navigationmodernization.homescreen.navigation.configuration.HomeScreenNavigationConfigurator;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: HomeScreenNavigationDependencies.kt */
/* JADX INFO: loaded from: classes12.dex */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0013\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B5\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000b¢\u0006\u0004\b\r\u0010\u000eJ\t\u0010\u0019\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001a\u001a\u00020\u0005HÆ\u0003J\t\u0010\u001b\u001a\u00020\u0007HÆ\u0003J\t\u0010\u001c\u001a\u00020\tHÆ\u0003J\u000f\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\f0\u000bHÆ\u0003JA\u0010\u001e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\u000e\b\u0002\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000bHÆ\u0001J\u0013\u0010\u001f\u001a\u00020 2\b\u0010!\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\"\u001a\u00020#HÖ\u0001J\t\u0010$\u001a\u00020%HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0017\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018¨\u0006&"}, d2 = {"Lcom/box/android/navigationmodernization/homescreen/navigation/HomeScreenNavigationDependencies;", "", "navigationConfigurator", "Lcom/box/android/navigationmodernization/homescreen/navigation/configuration/HomeScreenNavigationConfigurator;", "navController", "Landroidx/navigation/NavHostController;", "navigator", "Lcom/box/android/navigationmodernization/homescreen/navigation/HomeScreenNavigator;", "innerNavigatorsProvider", "Lcom/box/android/navigationmodernization/homescreen/navigation/compose/HomeScreenInnerNavigatorsProvider;", "browseTabsSelector", "Lcom/box/android/base/presentation/components/tabscreen/TabsSelector;", "Lcom/box/android/browse/cpl/navigationmodernization/BrowseDestination$InnerDestination$TabsScreen$BrowseTab;", "<init>", "(Lcom/box/android/navigationmodernization/homescreen/navigation/configuration/HomeScreenNavigationConfigurator;Landroidx/navigation/NavHostController;Lcom/box/android/navigationmodernization/homescreen/navigation/HomeScreenNavigator;Lcom/box/android/navigationmodernization/homescreen/navigation/compose/HomeScreenInnerNavigatorsProvider;Lcom/box/android/base/presentation/components/tabscreen/TabsSelector;)V", "getNavigationConfigurator", "()Lcom/box/android/navigationmodernization/homescreen/navigation/configuration/HomeScreenNavigationConfigurator;", "getNavController", "()Landroidx/navigation/NavHostController;", "getNavigator", "()Lcom/box/android/navigationmodernization/homescreen/navigation/HomeScreenNavigator;", "getInnerNavigatorsProvider", "()Lcom/box/android/navigationmodernization/homescreen/navigation/compose/HomeScreenInnerNavigatorsProvider;", "getBrowseTabsSelector", "()Lcom/box/android/base/presentation/components/tabscreen/TabsSelector;", "component1", "component2", "component3", "component4", "component5", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "", "other", "hashCode", "", "toString", "", "box_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final /* data */ class HomeScreenNavigationDependencies {
    public static final int $stable = 8;
    private final TabsSelector<BrowseDestination.InnerDestination.TabsScreen.BrowseTab> browseTabsSelector;
    private final HomeScreenInnerNavigatorsProvider innerNavigatorsProvider;
    private final NavHostController navController;
    private final HomeScreenNavigationConfigurator navigationConfigurator;
    private final HomeScreenNavigator navigator;

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ HomeScreenNavigationDependencies copy$default(HomeScreenNavigationDependencies homeScreenNavigationDependencies, HomeScreenNavigationConfigurator homeScreenNavigationConfigurator, NavHostController navHostController, HomeScreenNavigator homeScreenNavigator, HomeScreenInnerNavigatorsProvider homeScreenInnerNavigatorsProvider, TabsSelector tabsSelector, int i, Object obj) {
        if ((i & 1) != 0) {
            homeScreenNavigationConfigurator = homeScreenNavigationDependencies.navigationConfigurator;
        }
        if ((i & 2) != 0) {
            navHostController = homeScreenNavigationDependencies.navController;
        }
        if ((i & 4) != 0) {
            homeScreenNavigator = homeScreenNavigationDependencies.navigator;
        }
        if ((i & 8) != 0) {
            homeScreenInnerNavigatorsProvider = homeScreenNavigationDependencies.innerNavigatorsProvider;
        }
        if ((i & 16) != 0) {
            tabsSelector = homeScreenNavigationDependencies.browseTabsSelector;
        }
        TabsSelector tabsSelector2 = tabsSelector;
        HomeScreenNavigator homeScreenNavigator2 = homeScreenNavigator;
        return homeScreenNavigationDependencies.copy(homeScreenNavigationConfigurator, navHostController, homeScreenNavigator2, homeScreenInnerNavigatorsProvider, tabsSelector2);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final HomeScreenNavigationConfigurator getNavigationConfigurator() {
        return this.navigationConfigurator;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final NavHostController getNavController() {
        return this.navController;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final HomeScreenNavigator getNavigator() {
        return this.navigator;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final HomeScreenInnerNavigatorsProvider getInnerNavigatorsProvider() {
        return this.innerNavigatorsProvider;
    }

    public final TabsSelector<BrowseDestination.InnerDestination.TabsScreen.BrowseTab> component5() {
        return this.browseTabsSelector;
    }

    public final HomeScreenNavigationDependencies copy(HomeScreenNavigationConfigurator navigationConfigurator, NavHostController navController, HomeScreenNavigator navigator, HomeScreenInnerNavigatorsProvider innerNavigatorsProvider, TabsSelector<BrowseDestination.InnerDestination.TabsScreen.BrowseTab> browseTabsSelector) {
        Intrinsics.checkNotNullParameter(navigationConfigurator, "navigationConfigurator");
        Intrinsics.checkNotNullParameter(navController, "navController");
        Intrinsics.checkNotNullParameter(navigator, "navigator");
        Intrinsics.checkNotNullParameter(innerNavigatorsProvider, "innerNavigatorsProvider");
        Intrinsics.checkNotNullParameter(browseTabsSelector, "browseTabsSelector");
        return new HomeScreenNavigationDependencies(navigationConfigurator, navController, navigator, innerNavigatorsProvider, browseTabsSelector);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof HomeScreenNavigationDependencies)) {
            return false;
        }
        HomeScreenNavigationDependencies homeScreenNavigationDependencies = (HomeScreenNavigationDependencies) other;
        return Intrinsics.areEqual(this.navigationConfigurator, homeScreenNavigationDependencies.navigationConfigurator) && Intrinsics.areEqual(this.navController, homeScreenNavigationDependencies.navController) && Intrinsics.areEqual(this.navigator, homeScreenNavigationDependencies.navigator) && Intrinsics.areEqual(this.innerNavigatorsProvider, homeScreenNavigationDependencies.innerNavigatorsProvider) && Intrinsics.areEqual(this.browseTabsSelector, homeScreenNavigationDependencies.browseTabsSelector);
    }

    public int hashCode() {
        return (((((((this.navigationConfigurator.hashCode() * 31) + this.navController.hashCode()) * 31) + this.navigator.hashCode()) * 31) + this.innerNavigatorsProvider.hashCode()) * 31) + this.browseTabsSelector.hashCode();
    }

    public String toString() {
        return "HomeScreenNavigationDependencies(navigationConfigurator=" + this.navigationConfigurator + ", navController=" + this.navController + ", navigator=" + this.navigator + ", innerNavigatorsProvider=" + this.innerNavigatorsProvider + ", browseTabsSelector=" + this.browseTabsSelector + ")";
    }

    public HomeScreenNavigationDependencies(HomeScreenNavigationConfigurator navigationConfigurator, NavHostController navController, HomeScreenNavigator navigator, HomeScreenInnerNavigatorsProvider innerNavigatorsProvider, TabsSelector<BrowseDestination.InnerDestination.TabsScreen.BrowseTab> browseTabsSelector) {
        Intrinsics.checkNotNullParameter(navigationConfigurator, "navigationConfigurator");
        Intrinsics.checkNotNullParameter(navController, "navController");
        Intrinsics.checkNotNullParameter(navigator, "navigator");
        Intrinsics.checkNotNullParameter(innerNavigatorsProvider, "innerNavigatorsProvider");
        Intrinsics.checkNotNullParameter(browseTabsSelector, "browseTabsSelector");
        this.navigationConfigurator = navigationConfigurator;
        this.navController = navController;
        this.navigator = navigator;
        this.innerNavigatorsProvider = innerNavigatorsProvider;
        this.browseTabsSelector = browseTabsSelector;
    }

    public final HomeScreenNavigationConfigurator getNavigationConfigurator() {
        return this.navigationConfigurator;
    }

    public final NavHostController getNavController() {
        return this.navController;
    }

    public final HomeScreenNavigator getNavigator() {
        return this.navigator;
    }

    public final HomeScreenInnerNavigatorsProvider getInnerNavigatorsProvider() {
        return this.innerNavigatorsProvider;
    }

    public final TabsSelector<BrowseDestination.InnerDestination.TabsScreen.BrowseTab> getBrowseTabsSelector() {
        return this.browseTabsSelector;
    }
}
