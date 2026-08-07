package com.box.android.navigationmodernization.navigation;

import androidx.navigation.NavHostController;
import com.box.android.base.presentation.components.tabscreen.TabsSelector;
import com.box.android.domain.analytics.BoxAmplitudeAnalytics;
import com.box.android.inbox.InboxDestination;
import com.box.android.navigationmodernization.homescreen.navigation.HomeScreenNavigationDependencies;
import com.box.android.navigationmodernization.navigation.configuration.MainNavigationTargetConfigFactory;
import com.box.android.navigationmodernization.navigation.configuration.RootNavigationConfigurator;
import com.box.android.navigationmodernization.navigation.navigator.RootInnerNavigatorsProvider;
import com.box.android.navigationmodernization.navigation.navigator.RootNavigator;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: RootNavigationDependencies.kt */
/* JADX INFO: loaded from: classes12.dex */
@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u001c\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001BM\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000b\u0012\u0006\u0010\r\u001a\u00020\u000e\u0012\u0006\u0010\u000f\u001a\u00020\u0010\u0012\u0006\u0010\u0011\u001a\u00020\u0012¢\u0006\u0004\b\u0013\u0010\u0014J\t\u0010%\u001a\u00020\u0003HÆ\u0003J\t\u0010&\u001a\u00020\u0005HÆ\u0003J\t\u0010'\u001a\u00020\u0007HÆ\u0003J\t\u0010(\u001a\u00020\tHÆ\u0003J\u000f\u0010)\u001a\b\u0012\u0004\u0012\u00020\f0\u000bHÆ\u0003J\t\u0010*\u001a\u00020\u000eHÆ\u0003J\t\u0010+\u001a\u00020\u0010HÆ\u0003J\t\u0010,\u001a\u00020\u0012HÆ\u0003J_\u0010-\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\u000e\b\u0002\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000b2\b\b\u0002\u0010\r\u001a\u00020\u000e2\b\b\u0002\u0010\u000f\u001a\u00020\u00102\b\b\u0002\u0010\u0011\u001a\u00020\u0012HÆ\u0001J\u0013\u0010.\u001a\u00020/2\b\u00100\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u00101\u001a\u000202HÖ\u0001J\t\u00103\u001a\u000204HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001aR\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001cR\u0017\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001eR\u0011\u0010\r\u001a\u00020\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010 R\u0011\u0010\u000f\u001a\u00020\u0010¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\"R\u0011\u0010\u0011\u001a\u00020\u0012¢\u0006\b\n\u0000\u001a\u0004\b#\u0010$¨\u00065"}, d2 = {"Lcom/box/android/navigationmodernization/navigation/RootNavigationDependencies;", "", "navigationConfigurator", "Lcom/box/android/navigationmodernization/navigation/configuration/RootNavigationConfigurator;", "navController", "Landroidx/navigation/NavHostController;", "navigator", "Lcom/box/android/navigationmodernization/navigation/navigator/RootNavigator;", "navigatorsProvider", "Lcom/box/android/navigationmodernization/navigation/navigator/RootInnerNavigatorsProvider;", "inboxTabsSelector", "Lcom/box/android/base/presentation/components/tabscreen/TabsSelector;", "Lcom/box/android/inbox/InboxDestination$TabsScreen$InboxTab;", "homeScreenNavigationDependencies", "Lcom/box/android/navigationmodernization/homescreen/navigation/HomeScreenNavigationDependencies;", "mainNavigationTargetConfigFactory", "Lcom/box/android/navigationmodernization/navigation/configuration/MainNavigationTargetConfigFactory;", "mainNavigationTargetRequestHandler", "Lcom/box/android/navigationmodernization/navigation/MainNavigationTargetRequestHandler;", "<init>", "(Lcom/box/android/navigationmodernization/navigation/configuration/RootNavigationConfigurator;Landroidx/navigation/NavHostController;Lcom/box/android/navigationmodernization/navigation/navigator/RootNavigator;Lcom/box/android/navigationmodernization/navigation/navigator/RootInnerNavigatorsProvider;Lcom/box/android/base/presentation/components/tabscreen/TabsSelector;Lcom/box/android/navigationmodernization/homescreen/navigation/HomeScreenNavigationDependencies;Lcom/box/android/navigationmodernization/navigation/configuration/MainNavigationTargetConfigFactory;Lcom/box/android/navigationmodernization/navigation/MainNavigationTargetRequestHandler;)V", "getNavigationConfigurator", "()Lcom/box/android/navigationmodernization/navigation/configuration/RootNavigationConfigurator;", "getNavController", "()Landroidx/navigation/NavHostController;", "getNavigator", "()Lcom/box/android/navigationmodernization/navigation/navigator/RootNavigator;", "getNavigatorsProvider", "()Lcom/box/android/navigationmodernization/navigation/navigator/RootInnerNavigatorsProvider;", "getInboxTabsSelector", "()Lcom/box/android/base/presentation/components/tabscreen/TabsSelector;", "getHomeScreenNavigationDependencies", "()Lcom/box/android/navigationmodernization/homescreen/navigation/HomeScreenNavigationDependencies;", "getMainNavigationTargetConfigFactory", "()Lcom/box/android/navigationmodernization/navigation/configuration/MainNavigationTargetConfigFactory;", "getMainNavigationTargetRequestHandler", "()Lcom/box/android/navigationmodernization/navigation/MainNavigationTargetRequestHandler;", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "", "other", "hashCode", "", "toString", "", "box_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final /* data */ class RootNavigationDependencies {
    public static final int $stable = 8;
    private final HomeScreenNavigationDependencies homeScreenNavigationDependencies;
    private final TabsSelector<InboxDestination.TabsScreen.InboxTab> inboxTabsSelector;
    private final MainNavigationTargetConfigFactory mainNavigationTargetConfigFactory;
    private final MainNavigationTargetRequestHandler mainNavigationTargetRequestHandler;
    private final NavHostController navController;
    private final RootNavigationConfigurator navigationConfigurator;
    private final RootNavigator navigator;
    private final RootInnerNavigatorsProvider navigatorsProvider;

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ RootNavigationDependencies copy$default(RootNavigationDependencies rootNavigationDependencies, RootNavigationConfigurator rootNavigationConfigurator, NavHostController navHostController, RootNavigator rootNavigator, RootInnerNavigatorsProvider rootInnerNavigatorsProvider, TabsSelector tabsSelector, HomeScreenNavigationDependencies homeScreenNavigationDependencies, MainNavigationTargetConfigFactory mainNavigationTargetConfigFactory, MainNavigationTargetRequestHandler mainNavigationTargetRequestHandler, int i, Object obj) {
        if ((i & 1) != 0) {
            rootNavigationConfigurator = rootNavigationDependencies.navigationConfigurator;
        }
        if ((i & 2) != 0) {
            navHostController = rootNavigationDependencies.navController;
        }
        if ((i & 4) != 0) {
            rootNavigator = rootNavigationDependencies.navigator;
        }
        if ((i & 8) != 0) {
            rootInnerNavigatorsProvider = rootNavigationDependencies.navigatorsProvider;
        }
        if ((i & 16) != 0) {
            tabsSelector = rootNavigationDependencies.inboxTabsSelector;
        }
        if ((i & 32) != 0) {
            homeScreenNavigationDependencies = rootNavigationDependencies.homeScreenNavigationDependencies;
        }
        if ((i & 64) != 0) {
            mainNavigationTargetConfigFactory = rootNavigationDependencies.mainNavigationTargetConfigFactory;
        }
        if ((i & 128) != 0) {
            mainNavigationTargetRequestHandler = rootNavigationDependencies.mainNavigationTargetRequestHandler;
        }
        MainNavigationTargetConfigFactory mainNavigationTargetConfigFactory2 = mainNavigationTargetConfigFactory;
        MainNavigationTargetRequestHandler mainNavigationTargetRequestHandler2 = mainNavigationTargetRequestHandler;
        TabsSelector tabsSelector2 = tabsSelector;
        HomeScreenNavigationDependencies homeScreenNavigationDependencies2 = homeScreenNavigationDependencies;
        return rootNavigationDependencies.copy(rootNavigationConfigurator, navHostController, rootNavigator, rootInnerNavigatorsProvider, tabsSelector2, homeScreenNavigationDependencies2, mainNavigationTargetConfigFactory2, mainNavigationTargetRequestHandler2);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final RootNavigationConfigurator getNavigationConfigurator() {
        return this.navigationConfigurator;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final NavHostController getNavController() {
        return this.navController;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final RootNavigator getNavigator() {
        return this.navigator;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final RootInnerNavigatorsProvider getNavigatorsProvider() {
        return this.navigatorsProvider;
    }

    public final TabsSelector<InboxDestination.TabsScreen.InboxTab> component5() {
        return this.inboxTabsSelector;
    }

    /* JADX INFO: renamed from: component6, reason: from getter */
    public final HomeScreenNavigationDependencies getHomeScreenNavigationDependencies() {
        return this.homeScreenNavigationDependencies;
    }

    /* JADX INFO: renamed from: component7, reason: from getter */
    public final MainNavigationTargetConfigFactory getMainNavigationTargetConfigFactory() {
        return this.mainNavigationTargetConfigFactory;
    }

    /* JADX INFO: renamed from: component8, reason: from getter */
    public final MainNavigationTargetRequestHandler getMainNavigationTargetRequestHandler() {
        return this.mainNavigationTargetRequestHandler;
    }

    public final RootNavigationDependencies copy(RootNavigationConfigurator navigationConfigurator, NavHostController navController, RootNavigator navigator, RootInnerNavigatorsProvider navigatorsProvider, TabsSelector<InboxDestination.TabsScreen.InboxTab> inboxTabsSelector, HomeScreenNavigationDependencies homeScreenNavigationDependencies, MainNavigationTargetConfigFactory mainNavigationTargetConfigFactory, MainNavigationTargetRequestHandler mainNavigationTargetRequestHandler) {
        Intrinsics.checkNotNullParameter(navigationConfigurator, "navigationConfigurator");
        Intrinsics.checkNotNullParameter(navController, "navController");
        Intrinsics.checkNotNullParameter(navigator, "navigator");
        Intrinsics.checkNotNullParameter(navigatorsProvider, "navigatorsProvider");
        Intrinsics.checkNotNullParameter(inboxTabsSelector, "inboxTabsSelector");
        Intrinsics.checkNotNullParameter(homeScreenNavigationDependencies, "homeScreenNavigationDependencies");
        Intrinsics.checkNotNullParameter(mainNavigationTargetConfigFactory, "mainNavigationTargetConfigFactory");
        Intrinsics.checkNotNullParameter(mainNavigationTargetRequestHandler, "mainNavigationTargetRequestHandler");
        return new RootNavigationDependencies(navigationConfigurator, navController, navigator, navigatorsProvider, inboxTabsSelector, homeScreenNavigationDependencies, mainNavigationTargetConfigFactory, mainNavigationTargetRequestHandler);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof RootNavigationDependencies)) {
            return false;
        }
        RootNavigationDependencies rootNavigationDependencies = (RootNavigationDependencies) other;
        return Intrinsics.areEqual(this.navigationConfigurator, rootNavigationDependencies.navigationConfigurator) && Intrinsics.areEqual(this.navController, rootNavigationDependencies.navController) && Intrinsics.areEqual(this.navigator, rootNavigationDependencies.navigator) && Intrinsics.areEqual(this.navigatorsProvider, rootNavigationDependencies.navigatorsProvider) && Intrinsics.areEqual(this.inboxTabsSelector, rootNavigationDependencies.inboxTabsSelector) && Intrinsics.areEqual(this.homeScreenNavigationDependencies, rootNavigationDependencies.homeScreenNavigationDependencies) && Intrinsics.areEqual(this.mainNavigationTargetConfigFactory, rootNavigationDependencies.mainNavigationTargetConfigFactory) && Intrinsics.areEqual(this.mainNavigationTargetRequestHandler, rootNavigationDependencies.mainNavigationTargetRequestHandler);
    }

    public int hashCode() {
        return (((((((((((((this.navigationConfigurator.hashCode() * 31) + this.navController.hashCode()) * 31) + this.navigator.hashCode()) * 31) + this.navigatorsProvider.hashCode()) * 31) + this.inboxTabsSelector.hashCode()) * 31) + this.homeScreenNavigationDependencies.hashCode()) * 31) + this.mainNavigationTargetConfigFactory.hashCode()) * 31) + this.mainNavigationTargetRequestHandler.hashCode();
    }

    public String toString() {
        return "RootNavigationDependencies(navigationConfigurator=" + this.navigationConfigurator + ", navController=" + this.navController + ", navigator=" + this.navigator + ", navigatorsProvider=" + this.navigatorsProvider + ", inboxTabsSelector=" + this.inboxTabsSelector + ", homeScreenNavigationDependencies=" + this.homeScreenNavigationDependencies + ", mainNavigationTargetConfigFactory=" + this.mainNavigationTargetConfigFactory + ", mainNavigationTargetRequestHandler=" + this.mainNavigationTargetRequestHandler + ")";
    }

    public RootNavigationDependencies(RootNavigationConfigurator navigationConfigurator, NavHostController navController, RootNavigator navigator, RootInnerNavigatorsProvider navigatorsProvider, TabsSelector<InboxDestination.TabsScreen.InboxTab> inboxTabsSelector, HomeScreenNavigationDependencies homeScreenNavigationDependencies, MainNavigationTargetConfigFactory mainNavigationTargetConfigFactory, MainNavigationTargetRequestHandler mainNavigationTargetRequestHandler) {
        Intrinsics.checkNotNullParameter(navigationConfigurator, "navigationConfigurator");
        Intrinsics.checkNotNullParameter(navController, "navController");
        Intrinsics.checkNotNullParameter(navigator, "navigator");
        Intrinsics.checkNotNullParameter(navigatorsProvider, "navigatorsProvider");
        Intrinsics.checkNotNullParameter(inboxTabsSelector, "inboxTabsSelector");
        Intrinsics.checkNotNullParameter(homeScreenNavigationDependencies, "homeScreenNavigationDependencies");
        Intrinsics.checkNotNullParameter(mainNavigationTargetConfigFactory, "mainNavigationTargetConfigFactory");
        Intrinsics.checkNotNullParameter(mainNavigationTargetRequestHandler, "mainNavigationTargetRequestHandler");
        this.navigationConfigurator = navigationConfigurator;
        this.navController = navController;
        this.navigator = navigator;
        this.navigatorsProvider = navigatorsProvider;
        this.inboxTabsSelector = inboxTabsSelector;
        this.homeScreenNavigationDependencies = homeScreenNavigationDependencies;
        this.mainNavigationTargetConfigFactory = mainNavigationTargetConfigFactory;
        this.mainNavigationTargetRequestHandler = mainNavigationTargetRequestHandler;
    }

    public final RootNavigationConfigurator getNavigationConfigurator() {
        return this.navigationConfigurator;
    }

    public final NavHostController getNavController() {
        return this.navController;
    }

    public final RootNavigator getNavigator() {
        return this.navigator;
    }

    public final RootInnerNavigatorsProvider getNavigatorsProvider() {
        return this.navigatorsProvider;
    }

    public final TabsSelector<InboxDestination.TabsScreen.InboxTab> getInboxTabsSelector() {
        return this.inboxTabsSelector;
    }

    public final HomeScreenNavigationDependencies getHomeScreenNavigationDependencies() {
        return this.homeScreenNavigationDependencies;
    }

    public final MainNavigationTargetConfigFactory getMainNavigationTargetConfigFactory() {
        return this.mainNavigationTargetConfigFactory;
    }

    public final MainNavigationTargetRequestHandler getMainNavigationTargetRequestHandler() {
        return this.mainNavigationTargetRequestHandler;
    }
}
