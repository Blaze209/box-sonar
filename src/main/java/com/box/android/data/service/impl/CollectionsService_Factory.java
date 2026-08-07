package com.box.android.data.service.impl;

import com.box.android.data.datasource.gql.BoxGraphQL;
import com.box.android.data.datasource.gql.GQLCache;
import com.box.android.domain.identity.IUserContextManager;
import com.box.boxandroidlibv2private.resourcemanagers.BoxExtendedApiFile;
import com.box.boxandroidlibv2private.resourcemanagers.BoxExtendedApiFolder;
import com.box.boxandroidlibv2private.resourcemanagers.BoxExtendedApiWeblink;
import dagger.internal.Factory;
import dagger.internal.Provider;

/* JADX INFO: loaded from: classes11.dex */
public final class CollectionsService_Factory implements Factory<CollectionsService> {
    private final Provider<BoxExtendedApiFile> boxExtendedApiFileProvider;
    private final Provider<BoxExtendedApiFolder> boxExtendedApiFolderProvider;
    private final Provider<BoxExtendedApiWeblink> boxExtendedApiWeblinkProvider;
    private final Provider<GQLCache> gqlCacheProvider;
    private final Provider<BoxGraphQL> graphQLProvider;
    private final Provider<IUserContextManager> userContextManagerProvider;

    private CollectionsService_Factory(Provider<BoxGraphQL> graphQLProvider, Provider<GQLCache> gqlCacheProvider, Provider<IUserContextManager> userContextManagerProvider, Provider<BoxExtendedApiFile> boxExtendedApiFileProvider, Provider<BoxExtendedApiFolder> boxExtendedApiFolderProvider, Provider<BoxExtendedApiWeblink> boxExtendedApiWeblinkProvider) {
        this.graphQLProvider = graphQLProvider;
        this.gqlCacheProvider = gqlCacheProvider;
        this.userContextManagerProvider = userContextManagerProvider;
        this.boxExtendedApiFileProvider = boxExtendedApiFileProvider;
        this.boxExtendedApiFolderProvider = boxExtendedApiFolderProvider;
        this.boxExtendedApiWeblinkProvider = boxExtendedApiWeblinkProvider;
    }

    @Override // javax.inject.Provider, jakarta.inject.Provider
    public CollectionsService get() {
        return newInstance(this.graphQLProvider.get(), this.gqlCacheProvider.get(), this.userContextManagerProvider.get(), this.boxExtendedApiFileProvider.get(), this.boxExtendedApiFolderProvider.get(), this.boxExtendedApiWeblinkProvider.get());
    }

    public static CollectionsService_Factory create(Provider<BoxGraphQL> graphQLProvider, Provider<GQLCache> gqlCacheProvider, Provider<IUserContextManager> userContextManagerProvider, Provider<BoxExtendedApiFile> boxExtendedApiFileProvider, Provider<BoxExtendedApiFolder> boxExtendedApiFolderProvider, Provider<BoxExtendedApiWeblink> boxExtendedApiWeblinkProvider) {
        return new CollectionsService_Factory(graphQLProvider, gqlCacheProvider, userContextManagerProvider, boxExtendedApiFileProvider, boxExtendedApiFolderProvider, boxExtendedApiWeblinkProvider);
    }

    public static CollectionsService newInstance(BoxGraphQL graphQL, GQLCache gqlCache, IUserContextManager userContextManager, BoxExtendedApiFile boxExtendedApiFile, BoxExtendedApiFolder boxExtendedApiFolder, BoxExtendedApiWeblink boxExtendedApiWeblink) {
        return new CollectionsService(graphQL, gqlCache, userContextManager, boxExtendedApiFile, boxExtendedApiFolder, boxExtendedApiWeblink);
    }
}
