package com.box.android.collections.presentation.navigationmodernization.collectionitemslist;

import com.box.android.base.presentation.multiselect.MultiselectEnvironment;
import com.box.android.browse.cpl.itemsList.ItemEnvironment;
import com.box.android.collections.presentation.navigationmodernization.CollectionsAnalytics;
import com.box.android.domain.usecases.collections.ListCollectionItemsInteractor;
import dagger.internal.Factory;
import dagger.internal.Provider;

/* JADX INFO: loaded from: classes10.dex */
public final class CollectionItemsListEnvironment_Factory implements Factory<CollectionItemsListEnvironment> {
    private final Provider<CollectionsAnalytics> analyticsProvider;
    private final Provider<ItemEnvironment> itemEnvironmentProvider;
    private final Provider<ListCollectionItemsInteractor> listCollectionItemsInteractorProvider;
    private final Provider<MultiselectEnvironment> multiselectEnvironmentProvider;

    private CollectionItemsListEnvironment_Factory(Provider<ListCollectionItemsInteractor> provider, Provider<ItemEnvironment> provider2, Provider<MultiselectEnvironment> provider3, Provider<CollectionsAnalytics> provider4) {
        this.listCollectionItemsInteractorProvider = provider;
        this.itemEnvironmentProvider = provider2;
        this.multiselectEnvironmentProvider = provider3;
        this.analyticsProvider = provider4;
    }

    @Override // javax.inject.Provider, jakarta.inject.Provider
    public CollectionItemsListEnvironment get() {
        return newInstance(this.listCollectionItemsInteractorProvider.get(), this.itemEnvironmentProvider.get(), this.multiselectEnvironmentProvider.get(), this.analyticsProvider.get());
    }

    public static CollectionItemsListEnvironment_Factory create(Provider<ListCollectionItemsInteractor> provider, Provider<ItemEnvironment> provider2, Provider<MultiselectEnvironment> provider3, Provider<CollectionsAnalytics> provider4) {
        return new CollectionItemsListEnvironment_Factory(provider, provider2, provider3, provider4);
    }

    public static CollectionItemsListEnvironment newInstance(ListCollectionItemsInteractor listCollectionItemsInteractor, ItemEnvironment itemEnvironment, MultiselectEnvironment multiselectEnvironment, CollectionsAnalytics collectionsAnalytics) {
        return new CollectionItemsListEnvironment(listCollectionItemsInteractor, itemEnvironment, multiselectEnvironment, collectionsAnalytics);
    }
}
