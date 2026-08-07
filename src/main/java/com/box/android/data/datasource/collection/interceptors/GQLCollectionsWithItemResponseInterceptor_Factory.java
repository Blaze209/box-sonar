package com.box.android.data.datasource.collection.interceptors;

import com.box.android.data.datasource.gql.GQLRequestParser;
import com.box.android.domain.services.IBaseModelControllerService;
import com.box.boxandroidlibv2private.resourcemanagers.BoxExtendedApiFile;
import com.box.boxandroidlibv2private.resourcemanagers.BoxExtendedApiFolder;
import com.box.boxandroidlibv2private.resourcemanagers.BoxExtendedApiWeblink;
import com.squareup.moshi.Moshi;
import dagger.internal.Factory;
import dagger.internal.Provider;

/* JADX INFO: loaded from: classes11.dex */
public final class GQLCollectionsWithItemResponseInterceptor_Factory implements Factory<GQLCollectionsWithItemResponseInterceptor> {
    private final Provider<IBaseModelControllerService> baseModelControllerServiceProvider;
    private final Provider<BoxExtendedApiFile> boxExtendedApiFileProvider;
    private final Provider<BoxExtendedApiFolder> boxExtendedApiFolderProvider;
    private final Provider<BoxExtendedApiWeblink> boxExtendedApiWeblinkProvider;
    private final Provider<Moshi> moshiProvider;
    private final Provider<GQLRequestParser> requestParserProvider;

    private GQLCollectionsWithItemResponseInterceptor_Factory(Provider<GQLRequestParser> requestParserProvider, Provider<BoxExtendedApiFile> boxExtendedApiFileProvider, Provider<BoxExtendedApiFolder> boxExtendedApiFolderProvider, Provider<BoxExtendedApiWeblink> boxExtendedApiWeblinkProvider, Provider<IBaseModelControllerService> baseModelControllerServiceProvider, Provider<Moshi> moshiProvider) {
        this.requestParserProvider = requestParserProvider;
        this.boxExtendedApiFileProvider = boxExtendedApiFileProvider;
        this.boxExtendedApiFolderProvider = boxExtendedApiFolderProvider;
        this.boxExtendedApiWeblinkProvider = boxExtendedApiWeblinkProvider;
        this.baseModelControllerServiceProvider = baseModelControllerServiceProvider;
        this.moshiProvider = moshiProvider;
    }

    @Override // javax.inject.Provider, jakarta.inject.Provider
    public GQLCollectionsWithItemResponseInterceptor get() {
        return newInstance(this.requestParserProvider.get(), this.boxExtendedApiFileProvider.get(), this.boxExtendedApiFolderProvider.get(), this.boxExtendedApiWeblinkProvider.get(), this.baseModelControllerServiceProvider.get(), this.moshiProvider.get());
    }

    public static GQLCollectionsWithItemResponseInterceptor_Factory create(Provider<GQLRequestParser> requestParserProvider, Provider<BoxExtendedApiFile> boxExtendedApiFileProvider, Provider<BoxExtendedApiFolder> boxExtendedApiFolderProvider, Provider<BoxExtendedApiWeblink> boxExtendedApiWeblinkProvider, Provider<IBaseModelControllerService> baseModelControllerServiceProvider, Provider<Moshi> moshiProvider) {
        return new GQLCollectionsWithItemResponseInterceptor_Factory(requestParserProvider, boxExtendedApiFileProvider, boxExtendedApiFolderProvider, boxExtendedApiWeblinkProvider, baseModelControllerServiceProvider, moshiProvider);
    }

    public static GQLCollectionsWithItemResponseInterceptor newInstance(GQLRequestParser requestParser, BoxExtendedApiFile boxExtendedApiFile, BoxExtendedApiFolder boxExtendedApiFolder, BoxExtendedApiWeblink boxExtendedApiWeblink, IBaseModelControllerService baseModelControllerService, Moshi moshi) {
        return new GQLCollectionsWithItemResponseInterceptor(requestParser, boxExtendedApiFile, boxExtendedApiFolder, boxExtendedApiWeblink, baseModelControllerService, moshi);
    }
}
