package com.box.android.data.datasource.gql;

import android.content.Context;
import com.apollographql.apollo3.ApolloClient;
import com.apollographql.apollo3.cache.normalized.sql.SqlNormalizedCacheFactory;
import com.apollographql.apollo3.network.OkHttpExtensionsKt;
import com.box.android.data.api.interceptors.GQLClientRequestInterceptor;
import com.box.android.data.api.interceptors.GQLForceUpdateInterceptor;
import com.box.android.data.api.interceptors.auth.AuthInterceptor;
import com.box.android.data.api.interceptors.auth.SharedLinkAuthInterceptor;
import com.box.android.data.api.models.adapters.graphql.GQLCustomScalarAdapters;
import com.box.android.data.datasource.CacheError;
import com.box.android.data.datasource.gql.cache.GQLCacheKeyGenerator;
import com.box.android.data.datasource.gql.cache.GQLCacheKeyResolver;
import com.box.android.data.datasource.gql.cache.custom.CustomCacheExtensionsKt;
import com.box.android.data.user.UserData;
import com.box.android.domain.services.IBVEManager;
import com.box.android.domain.utils.result.Result;
import com.box.androidsdk.content.utils.BoxLogUtils;
import dagger.Lazy;
import javax.inject.Inject;
import javax.inject.Singleton;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.OkHttpClient;

/* JADX INFO: compiled from: GQLApolloClientConfigurator.kt */
/* JADX INFO: loaded from: classes11.dex */
@Singleton
@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0007\u0018\u0000 \u001b2\u00020\u0001:\u0001\u001bBU\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\u0006\u0010\f\u001a\u00020\r\u0012\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00100\u000f\u0012\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00120\u000f¢\u0006\u0004\b\u0013\u0010\u0014J\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016J\u0015\u0010\u0017\u001a\u00020\u00162\u0006\u0010\u0018\u001a\u00020\u0019H\u0001¢\u0006\u0002\b\u001aR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00100\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00120\u000fX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001c"}, d2 = {"Lcom/box/android/data/datasource/gql/GQLApolloClientConfigurator;", "", "context", "Landroid/content/Context;", "userData", "Lcom/box/android/data/user/UserData;", "authInterceptor", "Lcom/box/android/data/api/interceptors/auth/AuthInterceptor;", "sharedLinkAuthInterceptor", "Lcom/box/android/data/api/interceptors/auth/SharedLinkAuthInterceptor;", "gqlClientRequestInterceptor", "Lcom/box/android/data/api/interceptors/GQLClientRequestInterceptor;", "bveManager", "Lcom/box/android/domain/services/IBVEManager;", "gqlResponseInterceptor", "Ldagger/Lazy;", "Lcom/box/android/data/datasource/gql/GQLResponseInterceptor;", "gqlForceUpdateInterceptor", "Lcom/box/android/data/api/interceptors/GQLForceUpdateInterceptor;", "<init>", "(Landroid/content/Context;Lcom/box/android/data/user/UserData;Lcom/box/android/data/api/interceptors/auth/AuthInterceptor;Lcom/box/android/data/api/interceptors/auth/SharedLinkAuthInterceptor;Lcom/box/android/data/api/interceptors/GQLClientRequestInterceptor;Lcom/box/android/domain/services/IBVEManager;Ldagger/Lazy;Ldagger/Lazy;)V", "getApolloClient", "Lcom/apollographql/apollo3/ApolloClient;", "createApolloClient", "apolloDbName", "", "createApolloClient$data_generalProdRelease", "Companion", "data_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class GQLApolloClientConfigurator {
    private static final Companion Companion = new Companion(null);
    private static final String LOG_TAG = "GQLApolloClientConfigurator";
    private final AuthInterceptor authInterceptor;
    private final IBVEManager bveManager;
    private final Context context;
    private final GQLClientRequestInterceptor gqlClientRequestInterceptor;
    private final Lazy<GQLForceUpdateInterceptor> gqlForceUpdateInterceptor;
    private final Lazy<GQLResponseInterceptor> gqlResponseInterceptor;
    private final SharedLinkAuthInterceptor sharedLinkAuthInterceptor;
    private final UserData userData;

    @Inject
    public GQLApolloClientConfigurator(Context context, UserData userData, AuthInterceptor authInterceptor, SharedLinkAuthInterceptor sharedLinkAuthInterceptor, GQLClientRequestInterceptor gqlClientRequestInterceptor, IBVEManager bveManager, Lazy<GQLResponseInterceptor> gqlResponseInterceptor, Lazy<GQLForceUpdateInterceptor> gqlForceUpdateInterceptor) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(userData, "userData");
        Intrinsics.checkNotNullParameter(authInterceptor, "authInterceptor");
        Intrinsics.checkNotNullParameter(sharedLinkAuthInterceptor, "sharedLinkAuthInterceptor");
        Intrinsics.checkNotNullParameter(gqlClientRequestInterceptor, "gqlClientRequestInterceptor");
        Intrinsics.checkNotNullParameter(bveManager, "bveManager");
        Intrinsics.checkNotNullParameter(gqlResponseInterceptor, "gqlResponseInterceptor");
        Intrinsics.checkNotNullParameter(gqlForceUpdateInterceptor, "gqlForceUpdateInterceptor");
        this.context = context;
        this.userData = userData;
        this.authInterceptor = authInterceptor;
        this.sharedLinkAuthInterceptor = sharedLinkAuthInterceptor;
        this.gqlClientRequestInterceptor = gqlClientRequestInterceptor;
        this.bveManager = bveManager;
        this.gqlResponseInterceptor = gqlResponseInterceptor;
        this.gqlForceUpdateInterceptor = gqlForceUpdateInterceptor;
    }

    public final synchronized ApolloClient getApolloClient() {
        ApolloClient apolloClient;
        Result<ApolloClient, CacheError> resultRetrieveApolloClient = this.userData.retrieveApolloClient(new GQLApolloClientConfigurator$getApolloClient$result$1(this));
        if (resultRetrieveApolloClient instanceof Result.Success) {
            apolloClient = (ApolloClient) ((Result.Success) resultRetrieveApolloClient).getValue();
        } else {
            if (!(resultRetrieveApolloClient instanceof Result.Error)) {
                throw new NoWhenBranchMatchedException();
            }
            BoxLogUtils.e(LOG_TAG, "Error while retrieving apollo client: " + ((Result.Error) resultRetrieveApolloClient).getValue());
            apolloClient = null;
        }
        return apolloClient;
    }

    public final ApolloClient createApolloClient$data_generalProdRelease(String apolloDbName) {
        Intrinsics.checkNotNullParameter(apolloDbName, "apolloDbName");
        ApolloClient.Builder builderConfigureApolloClientBuilder$default = CustomCacheExtensionsKt.configureApolloClientBuilder$default(new ApolloClient.Builder().serverUrl(this.bveManager.getBaseUri() + "app-api/graphql"), new SqlNormalizedCacheFactory(this.context, apolloDbName, null, false, 12, null), new GQLCacheKeyGenerator(), new GQLCacheKeyResolver(), false, 8, null);
        OkHttpClient.Builder builder = new OkHttpClient.Builder();
        GQLResponseInterceptor gQLResponseInterceptor = this.gqlResponseInterceptor.get();
        Intrinsics.checkNotNullExpressionValue(gQLResponseInterceptor, "get(...)");
        OkHttpClient.Builder builderAddInterceptor = builder.addInterceptor(gQLResponseInterceptor).addInterceptor(this.authInterceptor).addInterceptor(this.sharedLinkAuthInterceptor).addInterceptor(this.gqlClientRequestInterceptor);
        GQLForceUpdateInterceptor gQLForceUpdateInterceptor = this.gqlForceUpdateInterceptor.get();
        Intrinsics.checkNotNullExpressionValue(gQLForceUpdateInterceptor, "get(...)");
        return OkHttpExtensionsKt.okHttpClient(builderConfigureApolloClientBuilder$default, builderAddInterceptor.addInterceptor(gQLForceUpdateInterceptor).build()).customScalarAdapters(GQLCustomScalarAdapters.INSTANCE.getCustomScalars()).build();
    }

    /* JADX INFO: compiled from: GQLApolloClientConfigurator.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0082\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082D¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Lcom/box/android/data/datasource/gql/GQLApolloClientConfigurator$Companion;", "", "<init>", "()V", "LOG_TAG", "", "data_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    private static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }
}
