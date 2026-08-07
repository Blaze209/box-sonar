package com.box.android.search.presentation.vm;

import android.os.Bundle;
import dagger.internal.InstanceFactory;
import javax.inject.Provider;

/* JADX INFO: loaded from: classes13.dex */
public final class SearchViewModel_Factory_Impl implements SearchViewModel.Factory {
    private final C1718SearchViewModel_Factory delegateFactory;

    SearchViewModel_Factory_Impl(C1718SearchViewModel_Factory c1718SearchViewModel_Factory) {
        this.delegateFactory = c1718SearchViewModel_Factory;
    }

    @Override // com.box.android.common.utilities.ViewModelAssistedFactory
    public SearchViewModel create(Bundle bundle) {
        return this.delegateFactory.get(bundle);
    }

    public static Provider<SearchViewModel.Factory> create(C1718SearchViewModel_Factory c1718SearchViewModel_Factory) {
        return InstanceFactory.create(new SearchViewModel_Factory_Impl(c1718SearchViewModel_Factory));
    }

    public static dagger.internal.Provider<SearchViewModel.Factory> createFactoryProvider(C1718SearchViewModel_Factory c1718SearchViewModel_Factory) {
        return InstanceFactory.create(new SearchViewModel_Factory_Impl(c1718SearchViewModel_Factory));
    }
}
