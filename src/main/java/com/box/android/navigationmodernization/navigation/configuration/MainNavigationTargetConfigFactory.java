package com.box.android.navigationmodernization.navigation.configuration;

import com.box.android.browse.cpl.navigationmodernization.BrowseDestination;
import com.box.android.browse.cpl.navigationmodernization.BrowseNavigationConfig;
import com.box.android.collections.presentation.navigationmodernization.navigation.CollectionsDestination;
import com.box.android.collections.presentation.navigationmodernization.navigation.CollectionsNavigationConfig;
import com.box.android.domain.configuration.FeatureFlips;
import com.box.android.domain.configuration.IBoxAccountSettings;
import com.box.android.domain.models.CollectionModel;
import com.box.android.domain.models.DomainError;
import com.box.android.domain.usecases.collections.GetFavoritesCollectionIdUseCase;
import com.box.android.domain.utils.result.Result;
import com.box.android.inbox.InboxDestination;
import com.box.android.inbox.InboxNavigationConfig;
import com.box.android.navigationmodernization.MainNavigationTarget;
import com.box.android.navigationmodernization.homescreen.navigation.HomeNavigationBarDestination;
import com.box.androidsdk.content.models.BoxCollection;
import com.microsoft.identity.common.internal.providers.oauth2.PasskeyWebListener;
import java.util.List;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.ResultKt;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.enums.EnumEntries;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: MainNavigationTargetConfigFactory.kt */
/* JADX INFO: loaded from: classes12.dex */
@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0007\u0018\u0000 \u001d2\u00020\u0001:\u0001\u001dB!\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\u001a\u0010\n\u001a\u0004\u0018\u00010\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rH\u0086@¢\u0006\u0002\u0010\u000eJ\u001a\u0010\u000f\u001a\u0004\u0018\u00010\u00102\b\u0010\f\u001a\u0004\u0018\u00010\rH\u0086@¢\u0006\u0002\u0010\u000eJ\u0010\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0012\u001a\u00020\u0013H\u0002J\u0010\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0012\u001a\u00020\u0016H\u0002J\u0014\u0010\u0017\u001a\u00020\u00102\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u0019H\u0002J\u000e\u0010\u001a\u001a\u00020\u0010H\u0082@¢\u0006\u0002\u0010\u001bJ\b\u0010\u001c\u001a\u00020\u0010H\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001e"}, d2 = {"Lcom/box/android/navigationmodernization/navigation/configuration/MainNavigationTargetConfigFactory;", "", "getFavoritesCollectionIdUseCase", "Lcom/box/android/domain/usecases/collections/GetFavoritesCollectionIdUseCase;", "featureFlips", "Lcom/box/android/domain/configuration/FeatureFlips;", "boxAccountSettings", "Lcom/box/android/domain/configuration/IBoxAccountSettings;", "<init>", "(Lcom/box/android/domain/usecases/collections/GetFavoritesCollectionIdUseCase;Lcom/box/android/domain/configuration/FeatureFlips;Lcom/box/android/domain/configuration/IBoxAccountSettings;)V", PasskeyWebListener.CREATE_UNIQUE_KEY, "Lcom/box/android/navigationmodernization/navigation/configuration/MainNavigationConfig;", "target", "Lcom/box/android/navigationmodernization/MainNavigationTarget;", "(Lcom/box/android/navigationmodernization/MainNavigationTarget;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "createForHome", "Lcom/box/android/navigationmodernization/navigation/configuration/MainNavigationConfig$Home;", "browseConfig", "startTab", "Lcom/box/android/browse/cpl/navigationmodernization/BrowseDestination$InnerDestination$TabsScreen$BrowseTab;", "inboxConfig", "Lcom/box/android/navigationmodernization/navigation/configuration/MainNavigationConfig$Inbox;", "Lcom/box/android/inbox/InboxDestination$TabsScreen$InboxTab;", "collectionsConfig", BoxCollection.TYPE, "Lcom/box/android/domain/models/CollectionModel;", "favoritesConfig", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "hubsConfig", "Companion", "box_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class MainNavigationTargetConfigFactory {
    private final IBoxAccountSettings boxAccountSettings;
    private final FeatureFlips featureFlips;
    private final GetFavoritesCollectionIdUseCase getFavoritesCollectionIdUseCase;
    private static final Companion Companion = new Companion(null);
    public static final int $stable = 8;
    private static final EnumEntries<BrowseDestination.InnerDestination.TabsScreen.BrowseTab> browseTabs = BrowseDestination.InnerDestination.TabsScreen.BrowseTab.getEntries();
    private static final EnumEntries<InboxDestination.TabsScreen.InboxTab> inboxTabs = InboxDestination.TabsScreen.InboxTab.getEntries();

    /* JADX INFO: renamed from: com.box.android.navigationmodernization.navigation.configuration.MainNavigationTargetConfigFactory$createForHome$1, reason: invalid class name */
    /* JADX INFO: compiled from: MainNavigationTargetConfigFactory.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.box.android.navigationmodernization.navigation.configuration.MainNavigationTargetConfigFactory", f = "MainNavigationTargetConfigFactory.kt", i = {0}, l = {44}, m = "createForHome", n = {"target"}, s = {"L$0"}, v = 1)
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
            return MainNavigationTargetConfigFactory.this.createForHome(null, this);
        }
    }

    /* JADX INFO: renamed from: com.box.android.navigationmodernization.navigation.configuration.MainNavigationTargetConfigFactory$favoritesConfig$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: MainNavigationTargetConfigFactory.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.box.android.navigationmodernization.navigation.configuration.MainNavigationTargetConfigFactory", f = "MainNavigationTargetConfigFactory.kt", i = {}, l = {76}, m = "favoritesConfig", n = {}, s = {}, v = 1)
    static final class C16611 extends ContinuationImpl {
        int label;
        /* synthetic */ Object result;

        C16611(Continuation<? super C16611> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return MainNavigationTargetConfigFactory.this.favoritesConfig(this);
        }
    }

    @Inject
    public MainNavigationTargetConfigFactory(GetFavoritesCollectionIdUseCase getFavoritesCollectionIdUseCase, FeatureFlips featureFlips, IBoxAccountSettings boxAccountSettings) {
        Intrinsics.checkNotNullParameter(getFavoritesCollectionIdUseCase, "getFavoritesCollectionIdUseCase");
        Intrinsics.checkNotNullParameter(featureFlips, "featureFlips");
        Intrinsics.checkNotNullParameter(boxAccountSettings, "boxAccountSettings");
        this.getFavoritesCollectionIdUseCase = getFavoritesCollectionIdUseCase;
        this.featureFlips = featureFlips;
        this.boxAccountSettings = boxAccountSettings;
    }

    public final Object create(MainNavigationTarget mainNavigationTarget, Continuation<? super MainNavigationConfig> continuation) {
        if (mainNavigationTarget == null) {
            return null;
        }
        if (Intrinsics.areEqual(mainNavigationTarget, MainNavigationTarget.AllFiles.INSTANCE)) {
            return browseConfig(BrowseDestination.InnerDestination.TabsScreen.BrowseTab.AllFilesTab);
        }
        if (Intrinsics.areEqual(mainNavigationTarget, MainNavigationTarget.Recents.INSTANCE)) {
            return browseConfig(BrowseDestination.InnerDestination.TabsScreen.BrowseTab.RecentsTab);
        }
        if (Intrinsics.areEqual(mainNavigationTarget, MainNavigationTarget.Offline.INSTANCE)) {
            return browseConfig(BrowseDestination.InnerDestination.TabsScreen.BrowseTab.OfflinedTab);
        }
        if (Intrinsics.areEqual(mainNavigationTarget, MainNavigationTarget.Collections.INSTANCE)) {
            return collectionsConfig$default(this, null, 1, null);
        }
        if (Intrinsics.areEqual(mainNavigationTarget, MainNavigationTarget.FavoritesCollection.INSTANCE)) {
            Object objFavoritesConfig = favoritesConfig(continuation);
            return objFavoritesConfig == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objFavoritesConfig : (MainNavigationConfig) objFavoritesConfig;
        }
        if (mainNavigationTarget instanceof MainNavigationTarget.PersonalCollection) {
            return collectionsConfig(CollectionModel.INSTANCE.createFromId(((MainNavigationTarget.PersonalCollection) mainNavigationTarget).getCollectionId()));
        }
        if (Intrinsics.areEqual(mainNavigationTarget, MainNavigationTarget.Notifications.INSTANCE)) {
            return inboxConfig(InboxDestination.TabsScreen.InboxTab.Notifications);
        }
        if (Intrinsics.areEqual(mainNavigationTarget, MainNavigationTarget.MyTasks.INSTANCE)) {
            return inboxConfig(InboxDestination.TabsScreen.InboxTab.MyTasks);
        }
        if (Intrinsics.areEqual(mainNavigationTarget, MainNavigationTarget.SentTasks.INSTANCE)) {
            return inboxConfig(InboxDestination.TabsScreen.InboxTab.SentTasks);
        }
        if (Intrinsics.areEqual(mainNavigationTarget, MainNavigationTarget.Hubs.INSTANCE)) {
            return hubsConfig();
        }
        throw new NoWhenBranchMatchedException();
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    public final Object createForHome(MainNavigationTarget mainNavigationTarget, Continuation<? super MainNavigationConfig.Home> continuation) {
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
            anonymousClass1.L$0 = SpillingKt.nullOutSpilledVariable(mainNavigationTarget);
            anonymousClass1.label = 1;
            objCreate = create(mainNavigationTarget, anonymousClass1);
            if (objCreate == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(objCreate);
        }
        if (objCreate instanceof MainNavigationConfig.Home) {
            return (MainNavigationConfig.Home) objCreate;
        }
        return null;
    }

    private final MainNavigationConfig.Home browseConfig(BrowseDestination.InnerDestination.TabsScreen.BrowseTab startTab) {
        return new MainNavigationConfig.Home(HomeNavigationBarDestination.Browse.INSTANCE, new BrowseNavigationConfig(new BrowseDestination.InnerDestination.TabsScreen(browseTabs, startTab)), null, null, 12, null);
    }

    private final MainNavigationConfig.Inbox inboxConfig(InboxDestination.TabsScreen.InboxTab startTab) {
        return new MainNavigationConfig.Inbox(new InboxNavigationConfig(new InboxDestination.TabsScreen(inboxTabs, startTab)));
    }

    static /* synthetic */ MainNavigationConfig.Home collectionsConfig$default(MainNavigationTargetConfigFactory mainNavigationTargetConfigFactory, CollectionModel collectionModel, int i, Object obj) {
        if ((i & 1) != 0) {
            collectionModel = null;
        }
        return mainNavigationTargetConfigFactory.collectionsConfig(collectionModel);
    }

    private final MainNavigationConfig.Home collectionsConfig(CollectionModel collection) {
        HomeNavigationBarDestination.Collections collections = HomeNavigationBarDestination.Collections.INSTANCE;
        CollectionsDestination.InnerDestination.Collections collections2 = CollectionsDestination.InnerDestination.Collections.INSTANCE;
        List listListOf = collection != null ? CollectionsKt.listOf(new CollectionsDestination.InnerDestination.CollectionItemsList(collection)) : null;
        if (listListOf == null) {
            listListOf = CollectionsKt.emptyList();
        }
        return new MainNavigationConfig.Home(collections, null, new CollectionsNavigationConfig(collections2, listListOf), null, 10, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    public final Object favoritesConfig(Continuation<? super MainNavigationConfig.Home> continuation) {
        C16611 c16611;
        if (continuation instanceof C16611) {
            c16611 = (C16611) continuation;
            if ((c16611.label & Integer.MIN_VALUE) != 0) {
                c16611.label -= Integer.MIN_VALUE;
            } else {
                c16611 = new C16611(continuation);
            }
        } else {
            c16611 = new C16611(continuation);
        }
        Object objInvoke = c16611.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = c16611.label;
        if (i == 0) {
            ResultKt.throwOnFailure(objInvoke);
            GetFavoritesCollectionIdUseCase getFavoritesCollectionIdUseCase = this.getFavoritesCollectionIdUseCase;
            c16611.label = 1;
            objInvoke = getFavoritesCollectionIdUseCase.invoke(c16611);
            if (objInvoke == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(objInvoke);
        }
        Result result = (Result) objInvoke;
        if (result instanceof Result.Success) {
            return collectionsConfig(CollectionModel.INSTANCE.createFavorites((String) ((Result.Success) result).getValue()));
        }
        if (result instanceof Result.Error) {
            return MainNavigationConfig.Home.copy$default(collectionsConfig$default(this, null, 1, null), null, null, null, (DomainError) ((Result.Error) result).getValue(), 7, null);
        }
        throw new NoWhenBranchMatchedException();
    }

    private final MainNavigationConfig.Home hubsConfig() {
        if (this.featureFlips.getHubsFeatureFlip().getEnabled() && this.boxAccountSettings.isHubsGalleryEnabled()) {
            return new MainNavigationConfig.Home(HomeNavigationBarDestination.Hubs.INSTANCE, null, null, null, 14, null);
        }
        return browseConfig(BrowseDestination.InnerDestination.TabsScreen.BrowseTab.AllFilesTab);
    }

    /* JADX INFO: compiled from: MainNavigationTargetConfigFactory.kt */
    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0082\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0017\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0017\u0010\t\u001a\b\u0012\u0004\u0012\u00020\n0\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\b¨\u0006\f"}, d2 = {"Lcom/box/android/navigationmodernization/navigation/configuration/MainNavigationTargetConfigFactory$Companion;", "", "<init>", "()V", "browseTabs", "Lkotlin/enums/EnumEntries;", "Lcom/box/android/browse/cpl/navigationmodernization/BrowseDestination$InnerDestination$TabsScreen$BrowseTab;", "getBrowseTabs", "()Lkotlin/enums/EnumEntries;", "inboxTabs", "Lcom/box/android/inbox/InboxDestination$TabsScreen$InboxTab;", "getInboxTabs", "box_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    private static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final EnumEntries<BrowseDestination.InnerDestination.TabsScreen.BrowseTab> getBrowseTabs() {
            return MainNavigationTargetConfigFactory.browseTabs;
        }

        public final EnumEntries<InboxDestination.TabsScreen.InboxTab> getInboxTabs() {
            return MainNavigationTargetConfigFactory.inboxTabs;
        }
    }
}
