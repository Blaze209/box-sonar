package com.box.android.navigationmodernization.navigation;

import com.box.android.base.presentation.components.tabscreen.TabsSelector;
import com.box.android.browse.cpl.navigationmodernization.BrowseDestination;
import com.box.android.browse.cpl.navigationmodernization.BrowseNavigationConfig;
import com.box.android.collections.presentation.navigationmodernization.navigation.CollectionsNavigationConfig;
import com.box.android.collections.presentation.navigationmodernization.navigation.CollectionsNavigator;
import com.box.android.domain.models.DomainError;
import com.box.android.domain.utils.result.Result;
import com.box.android.inbox.InboxDestination;
import com.box.android.navigationmodernization.MainNavigationTarget;
import com.box.android.navigationmodernization.homescreen.navigation.HomeNavigationBarDestination;
import com.box.android.navigationmodernization.homescreen.navigation.HomeScreenNavigator;
import com.box.android.navigationmodernization.navigation.configuration.MainNavigationConfig;
import com.box.android.navigationmodernization.navigation.configuration.MainNavigationTargetConfigFactory;
import com.box.android.navigationmodernization.navigation.navigator.RootNavigator;
import com.box.androidsdk.content.utils.BoxLogUtils;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: MainNavigationTargetRequestHandler.kt */
/* JADX INFO: loaded from: classes12.dex */
@Metadata(d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001BC\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000b\u0012\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000e0\u000b¢\u0006\u0004\b\u000f\u0010\u0010J\"\u0010\u0011\u001a\u000e\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\u00140\u00122\u0006\u0010\u0015\u001a\u00020\u0016H\u0086@¢\u0006\u0002\u0010\u0017J\u0012\u0010\u0018\u001a\u00020\u00132\b\u0010\u0019\u001a\u0004\u0018\u00010\u001aH\u0002J\u0010\u0010\u001b\u001a\u00020\u00132\u0006\u0010\u0019\u001a\u00020\u001cH\u0002J\u0010\u0010\u001d\u001a\u00020\u00132\u0006\u0010\u0019\u001a\u00020\u001cH\u0002J\u0010\u0010\u001e\u001a\u00020\u00132\u0006\u0010\u0019\u001a\u00020\u001cH\u0002J\b\u0010\u001f\u001a\u00020\u0013H\u0002J\u0010\u0010 \u001a\u00020\u00132\u0006\u0010\u0019\u001a\u00020!H\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000e0\u000bX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\""}, d2 = {"Lcom/box/android/navigationmodernization/navigation/MainNavigationTargetRequestHandler;", "", "configFactory", "Lcom/box/android/navigationmodernization/navigation/configuration/MainNavigationTargetConfigFactory;", "rootNavigator", "Lcom/box/android/navigationmodernization/navigation/navigator/RootNavigator;", "homeScreenNavigator", "Lcom/box/android/navigationmodernization/homescreen/navigation/HomeScreenNavigator;", "collectionsNavigator", "Lcom/box/android/collections/presentation/navigationmodernization/navigation/CollectionsNavigator;", "browseTabsSelector", "Lcom/box/android/base/presentation/components/tabscreen/TabsSelector;", "Lcom/box/android/browse/cpl/navigationmodernization/BrowseDestination$InnerDestination$TabsScreen$BrowseTab;", "inboxTabsSelector", "Lcom/box/android/inbox/InboxDestination$TabsScreen$InboxTab;", "<init>", "(Lcom/box/android/navigationmodernization/navigation/configuration/MainNavigationTargetConfigFactory;Lcom/box/android/navigationmodernization/navigation/navigator/RootNavigator;Lcom/box/android/navigationmodernization/homescreen/navigation/HomeScreenNavigator;Lcom/box/android/collections/presentation/navigationmodernization/navigation/CollectionsNavigator;Lcom/box/android/base/presentation/components/tabscreen/TabsSelector;Lcom/box/android/base/presentation/components/tabscreen/TabsSelector;)V", "handle", "Lcom/box/android/domain/utils/result/Result;", "", "Lcom/box/android/domain/models/DomainError;", "requestedTarget", "Lcom/box/android/navigationmodernization/MainNavigationTarget;", "(Lcom/box/android/navigationmodernization/MainNavigationTarget;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "navigateTo", "config", "Lcom/box/android/navigationmodernization/navigation/configuration/MainNavigationConfig;", "navigateToHomeGraph", "Lcom/box/android/navigationmodernization/navigation/configuration/MainNavigationConfig$Home;", "navigateToBrowse", "navigateToCollections", "navigateToHubs", "navigateToInbox", "Lcom/box/android/navigationmodernization/navigation/configuration/MainNavigationConfig$Inbox;", "box_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class MainNavigationTargetRequestHandler {
    public static final int $stable = 8;
    private final TabsSelector<BrowseDestination.InnerDestination.TabsScreen.BrowseTab> browseTabsSelector;
    private final CollectionsNavigator collectionsNavigator;
    private final MainNavigationTargetConfigFactory configFactory;
    private final HomeScreenNavigator homeScreenNavigator;
    private final TabsSelector<InboxDestination.TabsScreen.InboxTab> inboxTabsSelector;
    private final RootNavigator rootNavigator;

    /* JADX INFO: renamed from: com.box.android.navigationmodernization.navigation.MainNavigationTargetRequestHandler$handle$1, reason: invalid class name */
    /* JADX INFO: compiled from: MainNavigationTargetRequestHandler.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.box.android.navigationmodernization.navigation.MainNavigationTargetRequestHandler", f = "MainNavigationTargetRequestHandler.kt", i = {0}, l = {32}, m = "handle", n = {"requestedTarget"}, s = {"L$0"}, v = 1)
    static final class AnonymousClass1 extends ContinuationImpl {
        Object L$0;
        int label;
        /* synthetic */ Object result;

        AnonymousClass1(Continuation<? super AnonymousClass1> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return MainNavigationTargetRequestHandler.this.handle(null, this);
        }
    }

    public MainNavigationTargetRequestHandler(MainNavigationTargetConfigFactory configFactory, RootNavigator rootNavigator, HomeScreenNavigator homeScreenNavigator, CollectionsNavigator collectionsNavigator, TabsSelector<BrowseDestination.InnerDestination.TabsScreen.BrowseTab> browseTabsSelector, TabsSelector<InboxDestination.TabsScreen.InboxTab> inboxTabsSelector) {
        Intrinsics.checkNotNullParameter(configFactory, "configFactory");
        Intrinsics.checkNotNullParameter(rootNavigator, "rootNavigator");
        Intrinsics.checkNotNullParameter(homeScreenNavigator, "homeScreenNavigator");
        Intrinsics.checkNotNullParameter(collectionsNavigator, "collectionsNavigator");
        Intrinsics.checkNotNullParameter(browseTabsSelector, "browseTabsSelector");
        Intrinsics.checkNotNullParameter(inboxTabsSelector, "inboxTabsSelector");
        this.configFactory = configFactory;
        this.rootNavigator = rootNavigator;
        this.homeScreenNavigator = homeScreenNavigator;
        this.collectionsNavigator = collectionsNavigator;
        this.browseTabsSelector = browseTabsSelector;
        this.inboxTabsSelector = inboxTabsSelector;
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    public final Object handle(MainNavigationTarget mainNavigationTarget, Continuation<? super Result<Unit, ? extends DomainError>> continuation) {
        AnonymousClass1 anonymousClass1;
        if (continuation instanceof AnonymousClass1) {
            anonymousClass1 = (AnonymousClass1) continuation;
            if ((anonymousClass1.label & Integer.MIN_VALUE) != 0) {
                anonymousClass1.label -= Integer.MIN_VALUE;
            } else {
                anonymousClass1 = new AnonymousClass1(continuation);
            }
        } else {
            anonymousClass1 = new AnonymousClass1(continuation);
        }
        Object objCreate = anonymousClass1.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = anonymousClass1.label;
        if (i == 0) {
            ResultKt.throwOnFailure(objCreate);
            MainNavigationTargetConfigFactory mainNavigationTargetConfigFactory = this.configFactory;
            anonymousClass1.L$0 = mainNavigationTarget;
            anonymousClass1.label = 1;
            objCreate = mainNavigationTargetConfigFactory.create(mainNavigationTarget, anonymousClass1);
            if (objCreate == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            mainNavigationTarget = (MainNavigationTarget) anonymousClass1.L$0;
            ResultKt.throwOnFailure(objCreate);
        }
        MainNavigationConfig mainNavigationConfig = (MainNavigationConfig) objCreate;
        BoxLogUtils.i("Runtime navigation request target=" + mainNavigationTarget + " config=" + mainNavigationConfig);
        navigateTo(mainNavigationConfig);
        MainNavigationConfig.Home home = mainNavigationConfig instanceof MainNavigationConfig.Home ? (MainNavigationConfig.Home) mainNavigationConfig : null;
        DomainError error = home != null ? home.getError() : null;
        if (error != null) {
            BoxLogUtils.w("Runtime navigation requested target error=" + error);
            return new Result.Error(error);
        }
        return new Result.Success(Unit.INSTANCE);
    }

    private final void navigateTo(MainNavigationConfig config) {
        if (config instanceof MainNavigationConfig.Home) {
            navigateToHomeGraph((MainNavigationConfig.Home) config);
        } else if (config instanceof MainNavigationConfig.Inbox) {
            navigateToInbox((MainNavigationConfig.Inbox) config);
        } else if (config != null) {
            throw new NoWhenBranchMatchedException();
        }
    }

    private final void navigateToHomeGraph(MainNavigationConfig.Home config) {
        HomeNavigationBarDestination homeGraph = config.getHomeGraph();
        if (Intrinsics.areEqual(homeGraph, HomeNavigationBarDestination.Browse.INSTANCE)) {
            navigateToBrowse(config);
        } else if (Intrinsics.areEqual(homeGraph, HomeNavigationBarDestination.Collections.INSTANCE)) {
            navigateToCollections(config);
        } else if (Intrinsics.areEqual(homeGraph, HomeNavigationBarDestination.Hubs.INSTANCE)) {
            navigateToHubs();
        }
    }

    private final void navigateToBrowse(MainNavigationConfig.Home config) {
        BrowseDestination.InnerDestination.TabsScreen startDestination;
        BrowseDestination.InnerDestination.TabsScreen.BrowseTab startTab;
        BrowseNavigationConfig browseNavigationConfig = config.getBrowseNavigationConfig();
        if (browseNavigationConfig == null || (startDestination = browseNavigationConfig.getStartDestination()) == null || (startTab = startDestination.getStartTab()) == null) {
            return;
        }
        this.rootNavigator.resetToIfNotAtDestination(RootNavigationDestination.InnerDestination.HomeScreen.INSTANCE);
        this.homeScreenNavigator.resetToIfNotAtDestination(HomeNavigationBarDestination.Browse.INSTANCE);
        this.browseTabsSelector.selectTab(startTab);
    }

    private final void navigateToCollections(MainNavigationConfig.Home config) {
        CollectionsNavigationConfig collectionsNavigationConfig = config.getCollectionsNavigationConfig();
        if (collectionsNavigationConfig == null) {
            return;
        }
        this.rootNavigator.resetToIfNotAtDestination(RootNavigationDestination.InnerDestination.HomeScreen.INSTANCE);
        this.homeScreenNavigator.resetToIfNotAtDestination(HomeNavigationBarDestination.Collections.INSTANCE);
        this.collectionsNavigator.resetTo(collectionsNavigationConfig);
    }

    private final void navigateToHubs() {
        this.rootNavigator.resetToIfNotAtDestination(RootNavigationDestination.InnerDestination.HomeScreen.INSTANCE);
        this.homeScreenNavigator.resetToIfNotAtDestination(HomeNavigationBarDestination.Hubs.INSTANCE);
    }

    private final void navigateToInbox(MainNavigationConfig.Inbox config) {
        InboxDestination.TabsScreen.InboxTab startTab = config.getInboxNavigationConfig().getStartDestination().getStartTab();
        this.rootNavigator.resetToIfNotAtDestination(RootNavigationDestination.InnerDestination.Inbox.INSTANCE);
        this.inboxTabsSelector.selectTab(startTab);
    }
}
