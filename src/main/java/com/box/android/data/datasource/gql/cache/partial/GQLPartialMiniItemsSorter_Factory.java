package com.box.android.data.datasource.gql.cache.partial;

import com.box.android.domain.localrepo.LocalSortPreferences;
import dagger.internal.Factory;
import dagger.internal.Provider;

/* JADX INFO: loaded from: classes11.dex */
public final class GQLPartialMiniItemsSorter_Factory implements Factory<GQLPartialMiniItemsSorter> {
    private final Provider<LocalSortPreferences> localSortPreferencesProvider;

    private GQLPartialMiniItemsSorter_Factory(Provider<LocalSortPreferences> localSortPreferencesProvider) {
        this.localSortPreferencesProvider = localSortPreferencesProvider;
    }

    @Override // javax.inject.Provider, jakarta.inject.Provider
    public GQLPartialMiniItemsSorter get() {
        return newInstance(this.localSortPreferencesProvider.get());
    }

    public static GQLPartialMiniItemsSorter_Factory create(Provider<LocalSortPreferences> localSortPreferencesProvider) {
        return new GQLPartialMiniItemsSorter_Factory(localSortPreferencesProvider);
    }

    public static GQLPartialMiniItemsSorter newInstance(LocalSortPreferences localSortPreferences) {
        return new GQLPartialMiniItemsSorter(localSortPreferences);
    }
}
