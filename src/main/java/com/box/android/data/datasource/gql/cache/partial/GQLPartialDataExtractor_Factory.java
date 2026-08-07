package com.box.android.data.datasource.gql.cache.partial;

import com.box.android.data.datasource.gql.GQLCache;
import com.box.android.data.persistence.gql.GQLDbHelper;
import com.box.android.data.utilities.GQLCacheHelper;
import dagger.internal.Factory;
import dagger.internal.Provider;

/* JADX INFO: loaded from: classes11.dex */
public final class GQLPartialDataExtractor_Factory implements Factory<GQLPartialDataExtractor> {
    private final Provider<GQLCacheHelper> gqlCacheHelperProvider;
    private final Provider<GQLCache> gqlCacheProvider;
    private final Provider<GQLDbHelper> gqlDbHelperProvider;
    private final Provider<GQLPartialMiniItemsSorter> gqlPartialMiniItemsSorterProvider;
    private final Provider<GQLPartialModelParser> gqlPartialModelParserProvider;

    private GQLPartialDataExtractor_Factory(Provider<GQLDbHelper> gqlDbHelperProvider, Provider<GQLPartialModelParser> gqlPartialModelParserProvider, Provider<GQLPartialMiniItemsSorter> gqlPartialMiniItemsSorterProvider, Provider<GQLCacheHelper> gqlCacheHelperProvider, Provider<GQLCache> gqlCacheProvider) {
        this.gqlDbHelperProvider = gqlDbHelperProvider;
        this.gqlPartialModelParserProvider = gqlPartialModelParserProvider;
        this.gqlPartialMiniItemsSorterProvider = gqlPartialMiniItemsSorterProvider;
        this.gqlCacheHelperProvider = gqlCacheHelperProvider;
        this.gqlCacheProvider = gqlCacheProvider;
    }

    @Override // javax.inject.Provider, jakarta.inject.Provider
    public GQLPartialDataExtractor get() {
        return newInstance(this.gqlDbHelperProvider.get(), this.gqlPartialModelParserProvider.get(), this.gqlPartialMiniItemsSorterProvider.get(), this.gqlCacheHelperProvider.get(), this.gqlCacheProvider.get());
    }

    public static GQLPartialDataExtractor_Factory create(Provider<GQLDbHelper> gqlDbHelperProvider, Provider<GQLPartialModelParser> gqlPartialModelParserProvider, Provider<GQLPartialMiniItemsSorter> gqlPartialMiniItemsSorterProvider, Provider<GQLCacheHelper> gqlCacheHelperProvider, Provider<GQLCache> gqlCacheProvider) {
        return new GQLPartialDataExtractor_Factory(gqlDbHelperProvider, gqlPartialModelParserProvider, gqlPartialMiniItemsSorterProvider, gqlCacheHelperProvider, gqlCacheProvider);
    }

    public static GQLPartialDataExtractor newInstance(GQLDbHelper gqlDbHelper, GQLPartialModelParser gqlPartialModelParser, GQLPartialMiniItemsSorter gqlPartialMiniItemsSorter, GQLCacheHelper gqlCacheHelper, GQLCache gqlCache) {
        return new GQLPartialDataExtractor(gqlDbHelper, gqlPartialModelParser, gqlPartialMiniItemsSorter, gqlCacheHelper, gqlCache);
    }
}
