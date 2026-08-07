package com.box.android.data.utilities;

import com.box.android.data.datasource.gql.GQLCache;
import dagger.internal.Factory;
import dagger.internal.Provider;

/* JADX INFO: loaded from: classes11.dex */
public final class GQLCacheHelper_Factory implements Factory<GQLCacheHelper> {
    private final Provider<GQLCache> gqlCacheProvider;

    private GQLCacheHelper_Factory(Provider<GQLCache> gqlCacheProvider) {
        this.gqlCacheProvider = gqlCacheProvider;
    }

    @Override // javax.inject.Provider, jakarta.inject.Provider
    public GQLCacheHelper get() {
        return newInstance(this.gqlCacheProvider.get());
    }

    public static GQLCacheHelper_Factory create(Provider<GQLCache> gqlCacheProvider) {
        return new GQLCacheHelper_Factory(gqlCacheProvider);
    }

    public static GQLCacheHelper newInstance(GQLCache gqlCache) {
        return new GQLCacheHelper(gqlCache);
    }
}
