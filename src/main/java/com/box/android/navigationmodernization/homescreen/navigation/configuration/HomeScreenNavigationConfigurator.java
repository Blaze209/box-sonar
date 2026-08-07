package com.box.android.navigationmodernization.homescreen.navigation.configuration;

import com.box.android.browse.cpl.navigationmodernization.BrowseDestination;
import com.box.android.browse.cpl.navigationmodernization.BrowseNavigationConfig;
import com.box.android.collections.presentation.navigationmodernization.navigation.CollectionsDestination;
import com.box.android.collections.presentation.navigationmodernization.navigation.CollectionsNavigationConfig;
import com.box.android.domain.configuration.FeatureFlips;
import com.box.android.domain.configuration.IBoxAccountSettings;
import com.box.android.domain.services.ITabPersistenceService;
import com.box.android.navigationmodernization.MainNavigationTarget;
import com.box.android.navigationmodernization.homescreen.navigation.HomeNavigationBarDestination;
import com.box.android.navigationmodernization.navigation.configuration.MainNavigationConfig;
import com.box.android.navigationmodernization.navigation.configuration.MainNavigationTargetConfigFactory;
import com.box.android.notes.navigationmodernization.NotesDestination;
import com.box.android.notes.navigationmodernization.NotesNavigationConfig;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.enums.EnumEntries;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: HomeScreenNavigationConfigurator.kt */
/* JADX INFO: loaded from: classes12.dex */
@Metadata(d1 = {"\u0000r\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0010 \n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0007\b\u0007\u0018\u00002\u00020\u0001B3\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b¢\u0006\u0004\b\f\u0010\rJ\u000e\u0010\u0016\u001a\u00020\u0017H\u0086@¢\u0006\u0002\u0010\u0018J\b\u00108\u001a\u000203H\u0002J\b\u00109\u001a\u000203H\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0014\u001a\u0004\u0018\u00010\u0015X\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u0010\u0019\u001a\u00020\u000f8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u001c\u0010\u001d\u001a\u0004\b\u001a\u0010\u001bR!\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u000f0\u001f8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\"\u0010\u001d\u001a\u0004\b \u0010!R\u001b\u0010#\u001a\u00020$8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b'\u0010\u001d\u001a\u0004\b%\u0010&R\u001b\u0010(\u001a\u00020)8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b,\u0010\u001d\u001a\u0004\b*\u0010+R\u001b\u0010-\u001a\u00020.8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b1\u0010\u001d\u001a\u0004\b/\u00100R\u0011\u00102\u001a\u0002038F¢\u0006\u0006\u001a\u0004\b4\u00105R\u0014\u00106\u001a\u0002038BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b7\u00105¨\u0006:"}, d2 = {"Lcom/box/android/navigationmodernization/homescreen/navigation/configuration/HomeScreenNavigationConfigurator;", "", "boxAccountSettings", "Lcom/box/android/domain/configuration/IBoxAccountSettings;", "featureFlips", "Lcom/box/android/domain/configuration/FeatureFlips;", "tabPersistenceService", "Lcom/box/android/domain/services/ITabPersistenceService;", "mainNavigationTargetConfigFactory", "Lcom/box/android/navigationmodernization/navigation/configuration/MainNavigationTargetConfigFactory;", "requestedNavigationTarget", "Lcom/box/android/navigationmodernization/MainNavigationTarget;", "<init>", "(Lcom/box/android/domain/configuration/IBoxAccountSettings;Lcom/box/android/domain/configuration/FeatureFlips;Lcom/box/android/domain/services/ITabPersistenceService;Lcom/box/android/navigationmodernization/navigation/configuration/MainNavigationTargetConfigFactory;Lcom/box/android/navigationmodernization/MainNavigationTarget;)V", "savedStartGraph", "Lcom/box/android/navigationmodernization/homescreen/navigation/HomeNavigationBarDestination;", "savedBrowseTab", "Lcom/box/android/browse/cpl/navigationmodernization/BrowseDestination$InnerDestination$TabsScreen$BrowseTab;", "savedNotesTab", "Lcom/box/android/notes/navigationmodernization/NotesDestination$InnerDestination$TabsScreen$NotesTab;", "mainNavigationConfig", "Lcom/box/android/navigationmodernization/navigation/configuration/MainNavigationConfig$Home;", "initialize", "", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "startNavigationBarGraph", "getStartNavigationBarGraph", "()Lcom/box/android/navigationmodernization/homescreen/navigation/HomeNavigationBarDestination;", "startNavigationBarGraph$delegate", "Lkotlin/Lazy;", "navigationBarGraphs", "", "getNavigationBarGraphs", "()Ljava/util/List;", "navigationBarGraphs$delegate", "browseNavigationConfig", "Lcom/box/android/browse/cpl/navigationmodernization/BrowseNavigationConfig;", "getBrowseNavigationConfig", "()Lcom/box/android/browse/cpl/navigationmodernization/BrowseNavigationConfig;", "browseNavigationConfig$delegate", "notesNavigationConfig", "Lcom/box/android/notes/navigationmodernization/NotesNavigationConfig;", "getNotesNavigationConfig", "()Lcom/box/android/notes/navigationmodernization/NotesNavigationConfig;", "notesNavigationConfig$delegate", "collectionsNavigationConfig", "Lcom/box/android/collections/presentation/navigationmodernization/navigation/CollectionsNavigationConfig;", "getCollectionsNavigationConfig", "()Lcom/box/android/collections/presentation/navigationmodernization/navigation/CollectionsNavigationConfig;", "collectionsNavigationConfig$delegate", "useAiCenterForMultiDoc", "", "getUseAiCenterForMultiDoc", "()Z", "aiCenterExperienceEnabled", "getAiCenterExperienceEnabled", "isHubsAvailable", "isNotesScreenAvailable", "box_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class HomeScreenNavigationConfigurator {
    public static final int $stable = 8;
    private final IBoxAccountSettings boxAccountSettings;

    /* JADX INFO: renamed from: browseNavigationConfig$delegate, reason: from kotlin metadata */
    private final Lazy browseNavigationConfig;

    /* JADX INFO: renamed from: collectionsNavigationConfig$delegate, reason: from kotlin metadata */
    private final Lazy collectionsNavigationConfig;
    private final FeatureFlips featureFlips;
    private MainNavigationConfig.Home mainNavigationConfig;
    private final MainNavigationTargetConfigFactory mainNavigationTargetConfigFactory;

    /* JADX INFO: renamed from: navigationBarGraphs$delegate, reason: from kotlin metadata */
    private final Lazy navigationBarGraphs;

    /* JADX INFO: renamed from: notesNavigationConfig$delegate, reason: from kotlin metadata */
    private final Lazy notesNavigationConfig;
    private final MainNavigationTarget requestedNavigationTarget;
    private BrowseDestination.InnerDestination.TabsScreen.BrowseTab savedBrowseTab;
    private NotesDestination.InnerDestination.TabsScreen.NotesTab savedNotesTab;
    private HomeNavigationBarDestination savedStartGraph;

    /* JADX INFO: renamed from: startNavigationBarGraph$delegate, reason: from kotlin metadata */
    private final Lazy startNavigationBarGraph;
    private final ITabPersistenceService tabPersistenceService;

    /* JADX INFO: renamed from: com.box.android.navigationmodernization.homescreen.navigation.configuration.HomeScreenNavigationConfigurator$initialize$1, reason: invalid class name */
    /* JADX INFO: compiled from: HomeScreenNavigationConfigurator.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.box.android.navigationmodernization.homescreen.navigation.configuration.HomeScreenNavigationConfigurator", f = "HomeScreenNavigationConfigurator.kt", i = {0, 1, 1}, l = {44, 50}, m = "initialize", n = {"persistenceKeys", "persistenceKeys", "savedState"}, s = {"L$0", "L$0", "L$1"}, v = 1)
    static final class AnonymousClass1 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        Object L$2;
        int label;
        /* synthetic */ Object result;

        AnonymousClass1(Continuation<? super AnonymousClass1> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return HomeScreenNavigationConfigurator.this.initialize(this);
        }
    }

    public HomeScreenNavigationConfigurator(IBoxAccountSettings boxAccountSettings, FeatureFlips featureFlips, ITabPersistenceService tabPersistenceService, MainNavigationTargetConfigFactory mainNavigationTargetConfigFactory, MainNavigationTarget mainNavigationTarget) {
        Intrinsics.checkNotNullParameter(boxAccountSettings, "boxAccountSettings");
        Intrinsics.checkNotNullParameter(featureFlips, "featureFlips");
        Intrinsics.checkNotNullParameter(tabPersistenceService, "tabPersistenceService");
        Intrinsics.checkNotNullParameter(mainNavigationTargetConfigFactory, "mainNavigationTargetConfigFactory");
        this.boxAccountSettings = boxAccountSettings;
        this.featureFlips = featureFlips;
        this.tabPersistenceService = tabPersistenceService;
        this.mainNavigationTargetConfigFactory = mainNavigationTargetConfigFactory;
        this.requestedNavigationTarget = mainNavigationTarget;
        this.startNavigationBarGraph = LazyKt.lazy(new Function0() { // from class: com.box.android.navigationmodernization.homescreen.navigation.configuration.HomeScreenNavigationConfigurator$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return HomeScreenNavigationConfigurator.startNavigationBarGraph_delegate$lambda$0(this.f$0);
            }
        });
        this.navigationBarGraphs = LazyKt.lazy(new Function0() { // from class: com.box.android.navigationmodernization.homescreen.navigation.configuration.HomeScreenNavigationConfigurator$$ExternalSyntheticLambda1
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return HomeScreenNavigationConfigurator.navigationBarGraphs_delegate$lambda$0(this.f$0);
            }
        });
        this.browseNavigationConfig = LazyKt.lazy(new Function0() { // from class: com.box.android.navigationmodernization.homescreen.navigation.configuration.HomeScreenNavigationConfigurator$$ExternalSyntheticLambda2
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return HomeScreenNavigationConfigurator.browseNavigationConfig_delegate$lambda$0(this.f$0);
            }
        });
        this.notesNavigationConfig = LazyKt.lazy(new Function0() { // from class: com.box.android.navigationmodernization.homescreen.navigation.configuration.HomeScreenNavigationConfigurator$$ExternalSyntheticLambda3
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return HomeScreenNavigationConfigurator.notesNavigationConfig_delegate$lambda$0(this.f$0);
            }
        });
        this.collectionsNavigationConfig = LazyKt.lazy(new Function0() { // from class: com.box.android.navigationmodernization.homescreen.navigation.configuration.HomeScreenNavigationConfigurator$$ExternalSyntheticLambda4
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return HomeScreenNavigationConfigurator.collectionsNavigationConfig_delegate$lambda$0(this.f$0);
            }
        });
    }

    public /* synthetic */ HomeScreenNavigationConfigurator(IBoxAccountSettings iBoxAccountSettings, FeatureFlips featureFlips, ITabPersistenceService iTabPersistenceService, MainNavigationTargetConfigFactory mainNavigationTargetConfigFactory, MainNavigationTarget mainNavigationTarget, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(iBoxAccountSettings, featureFlips, iTabPersistenceService, mainNavigationTargetConfigFactory, (i & 16) != 0 ? null : mainNavigationTarget);
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    /* JADX WARN: Code restructure failed: missing block: B:35:0x00ea, code lost:
    
        if (r8 == r1) goto L36;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object initialize(kotlin.coroutines.Continuation<? super kotlin.Unit> r8) {
        /*
            Method dump skipped, instruction units count: 244
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.box.android.navigationmodernization.homescreen.navigation.configuration.HomeScreenNavigationConfigurator.initialize(kotlin.coroutines.Continuation):java.lang.Object");
    }

    public final HomeNavigationBarDestination getStartNavigationBarGraph() {
        return (HomeNavigationBarDestination) this.startNavigationBarGraph.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final HomeNavigationBarDestination startNavigationBarGraph_delegate$lambda$0(HomeScreenNavigationConfigurator homeScreenNavigationConfigurator) {
        HomeNavigationBarDestination homeGraph;
        MainNavigationConfig.Home home = homeScreenNavigationConfigurator.mainNavigationConfig;
        if (home != null && (homeGraph = home.getHomeGraph()) != null) {
            return homeGraph;
        }
        HomeNavigationBarDestination homeNavigationBarDestination = homeScreenNavigationConfigurator.savedStartGraph;
        return homeNavigationBarDestination == null ? HomeNavigationBarDestination.Browse.INSTANCE : homeNavigationBarDestination;
    }

    public final List<HomeNavigationBarDestination> getNavigationBarGraphs() {
        return (List) this.navigationBarGraphs.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final List navigationBarGraphs_delegate$lambda$0(HomeScreenNavigationConfigurator homeScreenNavigationConfigurator) {
        List listCreateListBuilder = CollectionsKt.createListBuilder();
        listCreateListBuilder.add(HomeNavigationBarDestination.Browse.INSTANCE);
        if (homeScreenNavigationConfigurator.isNotesScreenAvailable()) {
            listCreateListBuilder.add(HomeNavigationBarDestination.Notes.INSTANCE);
        }
        if (homeScreenNavigationConfigurator.isHubsAvailable()) {
            listCreateListBuilder.add(HomeNavigationBarDestination.Hubs.INSTANCE);
        }
        listCreateListBuilder.add(HomeNavigationBarDestination.Collections.INSTANCE);
        if (homeScreenNavigationConfigurator.getAiCenterExperienceEnabled()) {
            listCreateListBuilder.add(HomeNavigationBarDestination.BoxAi.INSTANCE);
        }
        return CollectionsKt.build(listCreateListBuilder);
    }

    public final BrowseNavigationConfig getBrowseNavigationConfig() {
        return (BrowseNavigationConfig) this.browseNavigationConfig.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final BrowseNavigationConfig browseNavigationConfig_delegate$lambda$0(HomeScreenNavigationConfigurator homeScreenNavigationConfigurator) {
        BrowseNavigationConfig browseNavigationConfig;
        MainNavigationConfig.Home home = homeScreenNavigationConfigurator.mainNavigationConfig;
        if (home != null && (browseNavigationConfig = home.getBrowseNavigationConfig()) != null) {
            return browseNavigationConfig;
        }
        EnumEntries<BrowseDestination.InnerDestination.TabsScreen.BrowseTab> entries = BrowseDestination.InnerDestination.TabsScreen.BrowseTab.getEntries();
        BrowseDestination.InnerDestination.TabsScreen.BrowseTab browseTab = homeScreenNavigationConfigurator.savedBrowseTab;
        if (browseTab == null) {
            browseTab = BrowseDestination.InnerDestination.TabsScreen.BrowseTab.AllFilesTab;
        }
        return new BrowseNavigationConfig(new BrowseDestination.InnerDestination.TabsScreen(entries, browseTab));
    }

    public final NotesNavigationConfig getNotesNavigationConfig() {
        return (NotesNavigationConfig) this.notesNavigationConfig.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final NotesNavigationConfig notesNavigationConfig_delegate$lambda$0(HomeScreenNavigationConfigurator homeScreenNavigationConfigurator) {
        EnumEntries<NotesDestination.InnerDestination.TabsScreen.NotesTab> entries = NotesDestination.InnerDestination.TabsScreen.NotesTab.getEntries();
        NotesDestination.InnerDestination.TabsScreen.NotesTab notesTab = homeScreenNavigationConfigurator.savedNotesTab;
        if (notesTab == null) {
            notesTab = NotesDestination.InnerDestination.TabsScreen.NotesTab.RecentsTab;
        }
        return new NotesNavigationConfig(new NotesDestination.InnerDestination.TabsScreen(entries, notesTab));
    }

    public final CollectionsNavigationConfig getCollectionsNavigationConfig() {
        return (CollectionsNavigationConfig) this.collectionsNavigationConfig.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final CollectionsNavigationConfig collectionsNavigationConfig_delegate$lambda$0(HomeScreenNavigationConfigurator homeScreenNavigationConfigurator) {
        CollectionsNavigationConfig collectionsNavigationConfig;
        MainNavigationConfig.Home home = homeScreenNavigationConfigurator.mainNavigationConfig;
        return (home == null || (collectionsNavigationConfig = home.getCollectionsNavigationConfig()) == null) ? new CollectionsNavigationConfig(CollectionsDestination.InnerDestination.Collections.INSTANCE, null, 2, null) : collectionsNavigationConfig;
    }

    public final boolean getUseAiCenterForMultiDoc() {
        return this.boxAccountSettings.isAxCenterEnabled() && this.featureFlips.getBoxAiCenterForPreviewAndMultidoc().getEnabled();
    }

    private final boolean getAiCenterExperienceEnabled() {
        return this.boxAccountSettings.isAxCenterEnabled() && this.featureFlips.getBoxAiInNewMainScreen().getEnabled();
    }

    private final boolean isHubsAvailable() {
        return this.featureFlips.getHubsFeatureFlip().getEnabled() && this.boxAccountSettings.isHubsGalleryEnabled();
    }

    private final boolean isNotesScreenAvailable() {
        return this.featureFlips.getBoxNotesScreen().getEnabled();
    }
}
