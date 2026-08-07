package com.box.android.collections.presentation.viewmodel;

import android.os.Bundle;
import com.box.android.domain.usecases.collections.CollectionMembershipsInteractor;
import com.box.android.domain.usecases.collections.CreateCollectionInteractor;
import com.box.android.domain.usecases.collections.ListCollectionsInteractor;
import dagger.internal.Provider;

/* JADX INFO: renamed from: com.box.android.collections.presentation.viewmodel.CollectionMembershipsViewModel_Factory, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes10.dex */
public final class C1004CollectionMembershipsViewModel_Factory {
    private final Provider<CollectionMembershipsInteractor> collectionMembershipInteractorProvider;
    private final Provider<CreateCollectionInteractor> createCollectionInteractorProvider;
    private final Provider<ListCollectionsInteractor> listCollectionsInteractorProvider;

    private C1004CollectionMembershipsViewModel_Factory(Provider<ListCollectionsInteractor> provider, Provider<CollectionMembershipsInteractor> provider2, Provider<CreateCollectionInteractor> provider3) {
        this.listCollectionsInteractorProvider = provider;
        this.collectionMembershipInteractorProvider = provider2;
        this.createCollectionInteractorProvider = provider3;
    }

    public CollectionMembershipsViewModel get(Bundle bundle) {
        return newInstance(bundle, this.listCollectionsInteractorProvider.get(), this.collectionMembershipInteractorProvider.get(), this.createCollectionInteractorProvider.get());
    }

    public static C1004CollectionMembershipsViewModel_Factory create(Provider<ListCollectionsInteractor> provider, Provider<CollectionMembershipsInteractor> provider2, Provider<CreateCollectionInteractor> provider3) {
        return new C1004CollectionMembershipsViewModel_Factory(provider, provider2, provider3);
    }

    public static CollectionMembershipsViewModel newInstance(Bundle bundle, ListCollectionsInteractor listCollectionsInteractor, CollectionMembershipsInteractor collectionMembershipsInteractor, CreateCollectionInteractor createCollectionInteractor) {
        return new CollectionMembershipsViewModel(bundle, listCollectionsInteractor, collectionMembershipsInteractor, createCollectionInteractor);
    }
}
