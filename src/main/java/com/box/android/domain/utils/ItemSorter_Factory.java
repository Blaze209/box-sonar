package com.box.android.domain.utils;

import com.box.android.domain.localrepo.LocalSortPreferences;
import dagger.internal.Factory;
import dagger.internal.Provider;

/* JADX INFO: loaded from: classes11.dex */
public final class ItemSorter_Factory implements Factory<ItemSorter> {
    private final Provider<LocalSortPreferences> localSortPreferencesProvider;

    private ItemSorter_Factory(Provider<LocalSortPreferences> provider) {
        this.localSortPreferencesProvider = provider;
    }

    @Override // javax.inject.Provider, jakarta.inject.Provider
    public ItemSorter get() {
        return newInstance(this.localSortPreferencesProvider.get());
    }

    public static ItemSorter_Factory create(Provider<LocalSortPreferences> provider) {
        return new ItemSorter_Factory(provider);
    }

    public static ItemSorter newInstance(LocalSortPreferences localSortPreferences) {
        return new ItemSorter(localSortPreferences);
    }
}
