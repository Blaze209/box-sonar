package com.apollographql.apollo3.cache.normalized;

import androidx.exifinterface.media.ExifInterface;
import com.apollographql.apollo3.ApolloCall;
import com.apollographql.apollo3.ApolloClient;
import com.apollographql.apollo3.api.ApolloRequest;
import com.apollographql.apollo3.api.ApolloResponse;
import com.apollographql.apollo3.api.ExecutionContext;
import com.apollographql.apollo3.api.MutableExecutionOptions;
import com.apollographql.apollo3.api.Mutation;
import com.apollographql.apollo3.api.Operation;
import com.apollographql.apollo3.api.Query;
import com.apollographql.apollo3.cache.normalized.api.CacheHeaders;
import com.apollographql.apollo3.cache.normalized.api.CacheKeyGenerator;
import com.apollographql.apollo3.cache.normalized.api.CacheResolver;
import com.apollographql.apollo3.cache.normalized.api.FieldPolicyCacheResolver;
import com.apollographql.apollo3.cache.normalized.api.NormalizedCacheFactory;
import com.apollographql.apollo3.cache.normalized.api.TypePolicyCacheKeyGenerator;
import com.apollographql.apollo3.cache.normalized.internal.ApolloCacheInterceptor;
import com.apollographql.apollo3.cache.normalized.internal.WatcherInterceptor;
import com.apollographql.apollo3.exception.ApolloException;
import com.apollographql.apollo3.interceptor.ApolloInterceptor;
import com.box.android.common.utilities.BoxCommonConstants;
import external.sdk.pendo.io.mozilla.javascript.Token;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.ReplaceWith;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.FlowKt;

/* JADX INFO: compiled from: ClientCacheExtensions.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000Ä\u0001\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0005\u001a\u0010\u00105\u001a\u00020\u001b2\u0006\u00106\u001a\u000207H\u0002\u001a\f\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u0007\u001a(\u0010\u0005\u001a\b\u0012\u0004\u0012\u0002H\u000708\"\b\b\u0000\u0010\u0007*\u00020\b*\b\u0012\u0004\u0012\u0002H\u0007082\u0006\u0010\u0005\u001a\u00020\u0006\u001a#\u0010\u0005\u001a\u0002H'\"\u0004\b\u0000\u0010'*\b\u0012\u0004\u0012\u0002H'0(2\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u00109\u001a*\u0010\u000e\u001a\b\u0012\u0004\u0012\u0002H\u000708\"\b\b\u0000\u0010\u0007*\u00020\b*\b\u0012\u0004\u0012\u0002H\u0007082\u0006\u0010\u000e\u001a\u00020\u000fH\u0000\u001a\f\u0010:\u001a\u00020\u0013*\u00020\u0002H\u0007\u001a#\u0010\u0012\u001a\u0002H'\"\u0004\b\u0000\u0010'*\b\u0012\u0004\u0012\u0002H'0(2\u0006\u0010\u0012\u001a\u00020\u0013¢\u0006\u0002\u0010;\u001a#\u0010\u0016\u001a\u0002H'\"\u0004\b\u0000\u0010'*\b\u0012\u0004\u0012\u0002H'0(2\u0006\u0010\u0016\u001a\u00020\u0013¢\u0006\u0002\u0010;\u001a(\u0010<\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00070\f0=\"\b\b\u0000\u0010\u0007*\u00020>*\b\u0012\u0004\u0012\u0002H\u00070\u001cH\u0007\u001a*\u0010\u0018\u001a\b\u0012\u0004\u0012\u0002H\u00070?\"\b\b\u0000\u0010\u0007*\u00020\b*\b\u0012\u0004\u0012\u0002H\u00070?2\u0006\u0010\u0018\u001a\u00020\u0013H\u0000\u001a#\u00106\u001a\u0002H'\"\u0004\b\u0000\u0010'*\b\u0012\u0004\u0012\u0002H'0(2\u0006\u00106\u001a\u000207¢\u0006\u0002\u0010@\u001a#\u0010\u001a\u001a\u0002H'\"\u0004\b\u0000\u0010'*\b\u0012\u0004\u0012\u0002H'0(2\u0006\u0010A\u001a\u00020\u001b¢\u0006\u0002\u0010B\u001a'\u0010C\u001a\u00020D*\u00020D2\u0014\b\u0002\u0010E\u001a\u000e\u0012\u0004\u0012\u00020G\u0012\u0004\u0012\u00020H0FH\u0007¢\u0006\u0002\bI\u001a7\u0010J\u001a\u00020D*\u00020D2\u0006\u0010K\u001a\u00020L2\b\b\u0002\u0010M\u001a\u00020N2\b\b\u0002\u0010O\u001a\u00020P2\b\b\u0002\u00103\u001a\u00020\u0013H\u0007¢\u0006\u0002\bQ\u001a-\u0010R\u001a\b\u0012\u0004\u0012\u0002H\u00070\u001c\"\b\b\u0000\u0010\u0007*\u00020#*\b\u0012\u0004\u0012\u0002H\u00070\u001c2\u0006\u0010S\u001a\u0002H\u0007¢\u0006\u0002\u0010T\u001a-\u0010R\u001a\b\u0012\u0004\u0012\u0002H\u00070?\"\b\b\u0000\u0010\u0007*\u00020#*\b\u0012\u0004\u0012\u0002H\u00070?2\u0006\u0010S\u001a\u0002H\u0007¢\u0006\u0002\u0010U\u001a#\u0010V\u001a\u0002H'\"\u0004\b\u0000\u0010'*\b\u0012\u0004\u0012\u0002H'0(2\u0006\u00106\u001a\u000207¢\u0006\u0002\u0010@\u001a#\u0010&\u001a\u0002H'\"\u0004\b\u0000\u0010'*\b\u0012\u0004\u0012\u0002H'0(2\u0006\u0010A\u001a\u00020\u001b¢\u0006\u0002\u0010B\u001a\u001c\u0010W\u001a\u00020D*\u00020D2\u0006\u0010W\u001a\u00020\u00012\b\b\u0002\u00103\u001a\u00020\u0013\u001a%\u0010X\u001a\u0002H'\"\u0004\b\u0000\u0010'*\b\u0012\u0004\u0012\u0002H'0(2\u0006\u0010X\u001a\u00020\u0013H\u0007¢\u0006\u0002\u0010;\u001a#\u0010+\u001a\u0002H'\"\u0004\b\u0000\u0010'*\b\u0012\u0004\u0012\u0002H'0(2\u0006\u0010+\u001a\u00020\u0013¢\u0006\u0002\u0010;\u001a%\u0010-\u001a\u0002H'\"\u0004\b\u0000\u0010'*\b\u0012\u0004\u0012\u0002H'0(2\u0006\u0010-\u001a\u00020\u0013H\u0007¢\u0006\u0002\u0010;\u001a\u007f\u0010Y\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00070\f0=\"\b\b\u0000\u0010\u0007*\u00020>*\b\u0012\u0004\u0012\u0002H\u00070\u001c2\b\u0010S\u001a\u0004\u0018\u0001H\u00072H\b\u0002\u0010Z\u001aB\b\u0001\u0012\u0013\u0012\u00110\\¢\u0006\f\b]\u0012\b\b^\u0012\u0004\b\b(_\u0012\u0013\u0012\u00110`¢\u0006\f\b]\u0012\b\b^\u0012\u0004\b\b(a\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00130b\u0012\u0006\u0012\u0004\u0018\u00010c0[¢\u0006\u0002\u0010d\u001a<\u0010Y\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00070\f0=\"\b\b\u0000\u0010\u0007*\u00020>*\b\u0012\u0004\u0012\u0002H\u00070\u001c2\b\b\u0002\u0010e\u001a\u00020\u00132\b\b\u0002\u0010f\u001a\u00020\u0013H\u0007\u001a*\u0010g\u001a\b\u0012\u0004\u0012\u0002H\u00070\f\"\b\b\u0000\u0010\u0007*\u00020\b*\b\u0012\u0004\u0012\u0002H\u00070\f2\u0006\u0010\u000e\u001a\u00020\u000fH\u0000\u001a#\u00103\u001a\u0002H'\"\u0004\b\u0000\u0010'*\b\u0012\u0004\u0012\u0002H'0(2\u0006\u00103\u001a\u00020\u0013¢\u0006\u0002\u0010;\"\u0015\u0010\u0000\u001a\u00020\u0001*\u00020\u00028F¢\u0006\u0006\u001a\u0004\b\u0003\u0010\u0004\"(\u0010\u0005\u001a\u00020\u0006\"\b\b\u0000\u0010\u0007*\u00020\b*\b\u0012\u0004\u0012\u0002H\u00070\t8@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b\n\u0010\u000b\"%\u0010\u0005\u001a\u00020\u0006\"\b\b\u0000\u0010\u0007*\u00020\b*\b\u0012\u0004\u0012\u0002H\u00070\f8F¢\u0006\u0006\u001a\u0004\b\n\u0010\r\"'\u0010\u000e\u001a\u0004\u0018\u00010\u000f\"\b\b\u0000\u0010\u0007*\u00020\b*\b\u0012\u0004\u0012\u0002H\u00070\f8F¢\u0006\u0006\u001a\u0004\b\u0010\u0010\u0011\"(\u0010\u0012\u001a\u00020\u0013\"\b\b\u0000\u0010\u0007*\u00020\b*\b\u0012\u0004\u0012\u0002H\u00070\t8@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b\u0014\u0010\u0015\"(\u0010\u0016\u001a\u00020\u0013\"\b\b\u0000\u0010\u0007*\u00020\b*\b\u0012\u0004\u0012\u0002H\u00070\t8@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b\u0017\u0010\u0015\"(\u0010\u0018\u001a\u00020\u0013\"\b\b\u0000\u0010\u0007*\u00020\b*\b\u0012\u0004\u0012\u0002H\u00070\t8@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b\u0019\u0010\u0015\"(\u0010\u001a\u001a\u00020\u001b\"\b\b\u0000\u0010\u0007*\u00020\b*\b\u0012\u0004\u0012\u0002H\u00070\u001c8@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b\u001d\u0010\u001e\"(\u0010\u001a\u001a\u00020\u001b\"\b\b\u0000\u0010\u0007*\u00020\b*\b\u0012\u0004\u0012\u0002H\u00070\t8@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b\u001d\u0010\u001f\"%\u0010 \u001a\u00020\u0013\"\b\b\u0000\u0010\u0007*\u00020\b*\b\u0012\u0004\u0012\u0002H\u00070\f8F¢\u0006\u0006\u001a\u0004\b \u0010!\"*\u0010\"\u001a\u0004\u0018\u00010#\"\b\b\u0000\u0010\u0007*\u00020#*\b\u0012\u0004\u0012\u0002H\u00070\t8@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b$\u0010%\"$\u0010&\u001a\u00020\u001b\"\u0004\b\u0000\u0010'*\b\u0012\u0004\u0012\u0002H'0(8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b)\u0010*\"(\u0010+\u001a\u00020\u0013\"\b\b\u0000\u0010\u0007*\u00020\b*\b\u0012\u0004\u0012\u0002H\u00070\t8@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b,\u0010\u0015\"(\u0010-\u001a\u00020\u0013\"\b\b\u0000\u0010\u0007*\u00020\b*\b\u0012\u0004\u0012\u0002H\u00070\t8@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b.\u0010\u0015\"*\u0010/\u001a\u0004\u0018\u000100\"\b\b\u0000\u0010\u0007*\u00020\b*\b\u0012\u0004\u0012\u0002H\u00070\t8@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b1\u00102\"(\u00103\u001a\u00020\u0013\"\b\b\u0000\u0010\u0007*\u00020\b*\b\u0012\u0004\u0012\u0002H\u00070\t8@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b4\u0010\u0015¨\u0006h"}, d2 = {"apolloStore", "Lcom/apollographql/apollo3/cache/normalized/ApolloStore;", "Lcom/apollographql/apollo3/ApolloClient;", "getApolloStore", "(Lcom/apollographql/apollo3/ApolloClient;)Lcom/apollographql/apollo3/cache/normalized/ApolloStore;", "cacheHeaders", "Lcom/apollographql/apollo3/cache/normalized/api/CacheHeaders;", "D", "Lcom/apollographql/apollo3/api/Operation$Data;", "Lcom/apollographql/apollo3/api/ApolloRequest;", "getCacheHeaders", "(Lcom/apollographql/apollo3/api/ApolloRequest;)Lcom/apollographql/apollo3/cache/normalized/api/CacheHeaders;", "Lcom/apollographql/apollo3/api/ApolloResponse;", "(Lcom/apollographql/apollo3/api/ApolloResponse;)Lcom/apollographql/apollo3/cache/normalized/api/CacheHeaders;", "cacheInfo", "Lcom/apollographql/apollo3/cache/normalized/CacheInfo;", "getCacheInfo", "(Lcom/apollographql/apollo3/api/ApolloResponse;)Lcom/apollographql/apollo3/cache/normalized/CacheInfo;", "doNotStore", "", "getDoNotStore", "(Lcom/apollographql/apollo3/api/ApolloRequest;)Z", "emitCacheMisses", "getEmitCacheMisses", "fetchFromCache", "getFetchFromCache", "fetchPolicyInterceptor", "Lcom/apollographql/apollo3/interceptor/ApolloInterceptor;", "Lcom/apollographql/apollo3/ApolloCall;", "getFetchPolicyInterceptor", "(Lcom/apollographql/apollo3/ApolloCall;)Lcom/apollographql/apollo3/interceptor/ApolloInterceptor;", "(Lcom/apollographql/apollo3/api/ApolloRequest;)Lcom/apollographql/apollo3/interceptor/ApolloInterceptor;", "isFromCache", "(Lcom/apollographql/apollo3/api/ApolloResponse;)Z", "optimisticData", "Lcom/apollographql/apollo3/api/Mutation$Data;", "getOptimisticData", "(Lcom/apollographql/apollo3/api/ApolloRequest;)Lcom/apollographql/apollo3/api/Mutation$Data;", "refetchPolicyInterceptor", ExifInterface.GPS_DIRECTION_TRUE, "Lcom/apollographql/apollo3/api/MutableExecutionOptions;", "getRefetchPolicyInterceptor", "(Lcom/apollographql/apollo3/api/MutableExecutionOptions;)Lcom/apollographql/apollo3/interceptor/ApolloInterceptor;", "storePartialResponses", "getStorePartialResponses", "storeReceiveDate", "getStoreReceiveDate", "watchContext", "Lcom/apollographql/apollo3/cache/normalized/WatchContext;", "getWatchContext", "(Lcom/apollographql/apollo3/api/ApolloRequest;)Lcom/apollographql/apollo3/cache/normalized/WatchContext;", "writeToCacheAsynchronously", "getWriteToCacheAsynchronously", "interceptorFor", "fetchPolicy", "Lcom/apollographql/apollo3/cache/normalized/FetchPolicy;", "Lcom/apollographql/apollo3/api/ApolloResponse$Builder;", "(Lcom/apollographql/apollo3/api/MutableExecutionOptions;Lcom/apollographql/apollo3/cache/normalized/api/CacheHeaders;)Ljava/lang/Object;", "clearNormalizedCache", "(Lcom/apollographql/apollo3/api/MutableExecutionOptions;Z)Ljava/lang/Object;", "executeCacheAndNetwork", "Lkotlinx/coroutines/flow/Flow;", "Lcom/apollographql/apollo3/api/Query$Data;", "Lcom/apollographql/apollo3/api/ApolloRequest$Builder;", "(Lcom/apollographql/apollo3/api/MutableExecutionOptions;Lcom/apollographql/apollo3/cache/normalized/FetchPolicy;)Ljava/lang/Object;", "interceptor", "(Lcom/apollographql/apollo3/api/MutableExecutionOptions;Lcom/apollographql/apollo3/interceptor/ApolloInterceptor;)Ljava/lang/Object;", "logCacheMisses", "Lcom/apollographql/apollo3/ApolloClient$Builder;", "log", "Lkotlin/Function1;", "", "", "-logCacheMisses", "normalizedCache", "normalizedCacheFactory", "Lcom/apollographql/apollo3/cache/normalized/api/NormalizedCacheFactory;", "cacheKeyGenerator", "Lcom/apollographql/apollo3/cache/normalized/api/CacheKeyGenerator;", "cacheResolver", "Lcom/apollographql/apollo3/cache/normalized/api/CacheResolver;", "configureApolloClientBuilder", "optimisticUpdates", "data", "(Lcom/apollographql/apollo3/ApolloCall;Lcom/apollographql/apollo3/api/Mutation$Data;)Lcom/apollographql/apollo3/ApolloCall;", "(Lcom/apollographql/apollo3/api/ApolloRequest$Builder;Lcom/apollographql/apollo3/api/Mutation$Data;)Lcom/apollographql/apollo3/api/ApolloRequest$Builder;", "refetchPolicy", "store", "storeExpirationDate", "watch", "retryWhen", "Lkotlin/Function3;", "", "Lkotlin/ParameterName;", "name", "cause", "", "attempt", "Lkotlin/coroutines/Continuation;", "", "(Lcom/apollographql/apollo3/ApolloCall;Lcom/apollographql/apollo3/api/Query$Data;Lkotlin/jvm/functions/Function3;)Lkotlinx/coroutines/flow/Flow;", "fetchThrows", "refetchThrows", "withCacheInfo", "apollo-normalized-cache"}, k = 2, mv = {1, 5, 1}, xi = 48)
public final class NormalizedCache {

    /* JADX INFO: compiled from: ClientCacheExtensions.kt */
    @Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[FetchPolicy.values().length];
            try {
                iArr[FetchPolicy.CacheOnly.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[FetchPolicy.NetworkOnly.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[FetchPolicy.CacheFirst.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[FetchPolicy.NetworkFirst.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr[FetchPolicy.CacheAndNetwork.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public static final ApolloClient.Builder configureApolloClientBuilder(ApolloClient.Builder builder, NormalizedCacheFactory normalizedCacheFactory) {
        Intrinsics.checkNotNullParameter(builder, "<this>");
        Intrinsics.checkNotNullParameter(normalizedCacheFactory, "normalizedCacheFactory");
        return configureApolloClientBuilder$default(builder, normalizedCacheFactory, null, null, false, 14, null);
    }

    public static final ApolloClient.Builder configureApolloClientBuilder(ApolloClient.Builder builder, NormalizedCacheFactory normalizedCacheFactory, CacheKeyGenerator cacheKeyGenerator) {
        Intrinsics.checkNotNullParameter(builder, "<this>");
        Intrinsics.checkNotNullParameter(normalizedCacheFactory, "normalizedCacheFactory");
        Intrinsics.checkNotNullParameter(cacheKeyGenerator, "cacheKeyGenerator");
        return configureApolloClientBuilder$default(builder, normalizedCacheFactory, cacheKeyGenerator, null, false, 12, null);
    }

    public static final ApolloClient.Builder configureApolloClientBuilder(ApolloClient.Builder builder, NormalizedCacheFactory normalizedCacheFactory, CacheKeyGenerator cacheKeyGenerator, CacheResolver cacheResolver) {
        Intrinsics.checkNotNullParameter(builder, "<this>");
        Intrinsics.checkNotNullParameter(normalizedCacheFactory, "normalizedCacheFactory");
        Intrinsics.checkNotNullParameter(cacheKeyGenerator, "cacheKeyGenerator");
        Intrinsics.checkNotNullParameter(cacheResolver, "cacheResolver");
        return configureApolloClientBuilder$default(builder, normalizedCacheFactory, cacheKeyGenerator, cacheResolver, false, 8, null);
    }

    public static final <D extends Query.Data> Flow<ApolloResponse<D>> watch(ApolloCall<D> apolloCall) {
        Intrinsics.checkNotNullParameter(apolloCall, "<this>");
        return watch$default((ApolloCall) apolloCall, false, false, 3, (Object) null);
    }

    public static final <D extends Query.Data> Flow<ApolloResponse<D>> watch(ApolloCall<D> apolloCall, boolean z) {
        Intrinsics.checkNotNullParameter(apolloCall, "<this>");
        return watch$default((ApolloCall) apolloCall, z, false, 2, (Object) null);
    }

    public static /* synthetic */ ApolloClient.Builder configureApolloClientBuilder$default(ApolloClient.Builder builder, NormalizedCacheFactory normalizedCacheFactory, CacheKeyGenerator cacheKeyGenerator, CacheResolver cacheResolver, boolean z, int i, Object obj) {
        if ((i & 2) != 0) {
            cacheKeyGenerator = TypePolicyCacheKeyGenerator.INSTANCE;
        }
        if ((i & 4) != 0) {
            cacheResolver = FieldPolicyCacheResolver.INSTANCE;
        }
        if ((i & 8) != 0) {
            z = false;
        }
        return configureApolloClientBuilder(builder, normalizedCacheFactory, cacheKeyGenerator, cacheResolver, z);
    }

    public static final ApolloClient.Builder configureApolloClientBuilder(ApolloClient.Builder builder, NormalizedCacheFactory normalizedCacheFactory, CacheKeyGenerator cacheKeyGenerator, CacheResolver cacheResolver, boolean z) {
        Intrinsics.checkNotNullParameter(builder, "<this>");
        Intrinsics.checkNotNullParameter(normalizedCacheFactory, "normalizedCacheFactory");
        Intrinsics.checkNotNullParameter(cacheKeyGenerator, "cacheKeyGenerator");
        Intrinsics.checkNotNullParameter(cacheResolver, "cacheResolver");
        return store(builder, ApolloStoreKt.ApolloStore(normalizedCacheFactory, cacheKeyGenerator, cacheResolver), z);
    }

    /* JADX INFO: renamed from: -logCacheMisses$default, reason: not valid java name */
    public static /* synthetic */ ApolloClient.Builder m11203logCacheMisses$default(ApolloClient.Builder builder, Function1 function1, int i, Object obj) {
        if ((i & 1) != 0) {
            function1 = new Function1<String, Unit>() { // from class: com.apollographql.apollo3.cache.normalized.NormalizedCache$logCacheMisses$1
                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(String str) {
                    invoke2(str);
                    return Unit.INSTANCE;
                }

                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(String it) {
                    Intrinsics.checkNotNullParameter(it, "it");
                    System.out.println((Object) it);
                }
            };
        }
        return m11202logCacheMisses(builder, function1);
    }

    /* JADX INFO: renamed from: -logCacheMisses, reason: not valid java name */
    public static final ApolloClient.Builder m11202logCacheMisses(ApolloClient.Builder builder, Function1<? super String, Unit> log) {
        Intrinsics.checkNotNullParameter(builder, "<this>");
        Intrinsics.checkNotNullParameter(log, "log");
        List<ApolloInterceptor> interceptors = builder.getInterceptors();
        if (!(interceptors instanceof Collection) || !interceptors.isEmpty()) {
            Iterator<T> it = interceptors.iterator();
            while (it.hasNext()) {
                if (((ApolloInterceptor) it.next()) instanceof ApolloCacheInterceptor) {
                    throw new IllegalStateException("Apollo: logCacheMisses() must be called before setting up your normalized cache".toString());
                }
            }
        }
        return builder.addInterceptor(new CacheMissLoggingInterceptor(log));
    }

    public static /* synthetic */ ApolloClient.Builder store$default(ApolloClient.Builder builder, ApolloStore apolloStore, boolean z, int i, Object obj) {
        if ((i & 2) != 0) {
            z = false;
        }
        return store(builder, apolloStore, z);
    }

    public static final ApolloClient.Builder store(ApolloClient.Builder builder, ApolloStore store, boolean z) {
        Intrinsics.checkNotNullParameter(builder, "<this>");
        Intrinsics.checkNotNullParameter(store, "store");
        return (ApolloClient.Builder) writeToCacheAsynchronously(builder.addInterceptor(new WatcherInterceptor(store)).addInterceptor(FetchPolicyInterceptors.getFetchPolicyRouterInterceptor()).addInterceptor(new ApolloCacheInterceptor(store)), z);
    }

    public static /* synthetic */ Flow watch$default(ApolloCall apolloCall, boolean z, boolean z2, int i, Object obj) {
        if ((i & 1) != 0) {
            z = false;
        }
        if ((i & 2) != 0) {
            z2 = false;
        }
        return watch(apolloCall, z, z2);
    }

    /* JADX INFO: Add missing generic type declarations: [D] */
    /* JADX INFO: renamed from: com.apollographql.apollo3.cache.normalized.NormalizedCache$watch$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: ClientCacheExtensions.kt */
    @Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001\"\b\b\u0000\u0010\u0002*\u00020\u0003*\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00020\u00050\u0004H\u008a@"}, d2 = {"<anonymous>", "", "D", "Lcom/apollographql/apollo3/api/Query$Data;", "Lkotlinx/coroutines/flow/FlowCollector;", "Lcom/apollographql/apollo3/api/ApolloResponse;"}, k = 3, mv = {1, 5, 1}, xi = 48)
    @DebugMetadata(c = "com.apollographql.apollo3.cache.normalized.NormalizedCache$watch$1", f = "ClientCacheExtensions.kt", i = {0, 0, 0}, l = {Token.XMLATTR, 182}, m = "invokeSuspend", n = {"$this$flow", "lastResponse", "response"}, s = {"L$0", "L$1", "L$2"})
    static final class C08711<D> extends SuspendLambda implements Function2<FlowCollector<? super ApolloResponse<D>>, Continuation<? super Unit>, Object> {
        final /* synthetic */ boolean $fetchThrows;
        final /* synthetic */ boolean $refetchThrows;
        final /* synthetic */ ApolloCall<D> $this_watch;
        private /* synthetic */ Object L$0;
        Object L$1;
        Object L$2;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C08711(ApolloCall<D> apolloCall, boolean z, boolean z2, Continuation<? super C08711> continuation) {
            super(2, continuation);
            this.$this_watch = apolloCall;
            this.$fetchThrows = z;
            this.$refetchThrows = z2;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            C08711 c08711 = new C08711(this.$this_watch, this.$fetchThrows, this.$refetchThrows, continuation);
            c08711.L$0 = obj;
            return c08711;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(FlowCollector<? super ApolloResponse<D>> flowCollector, Continuation<? super Unit> continuation) {
            return ((C08711) create(flowCollector, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Code restructure failed: missing block: B:19:0x00bb, code lost:
        
            if (kotlinx.coroutines.flow.FlowKt.onStart(com.apollographql.apollo3.cache.normalized.NormalizedCache.watch((com.apollographql.apollo3.ApolloCall<com.apollographql.apollo3.api.Query.Data>) r10, r1, new com.apollographql.apollo3.cache.normalized.NormalizedCache.C08711.AnonymousClass3(r9.$refetchThrows, null)), new com.apollographql.apollo3.cache.normalized.NormalizedCache.C08711.AnonymousClass4(r3, null)).collect(new com.apollographql.apollo3.cache.normalized.NormalizedCache.C08711.AnonymousClass5(), r9) == r0) goto L20;
         */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final java.lang.Object invokeSuspend(java.lang.Object r10) {
            /*
                r9 = this;
                java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
                int r1 = r9.label
                r2 = 2
                r3 = 1
                r4 = 0
                if (r1 == 0) goto L2c
                if (r1 == r3) goto L1c
                if (r1 != r2) goto L14
                kotlin.ResultKt.throwOnFailure(r10)
                goto Lbe
            L14:
                java.lang.IllegalStateException r9 = new java.lang.IllegalStateException
                java.lang.String r10 = "call to 'resume' before 'invoke' with coroutine"
                r9.<init>(r10)
                throw r9
            L1c:
                java.lang.Object r1 = r9.L$2
                kotlin.jvm.internal.Ref$ObjectRef r1 = (kotlin.jvm.internal.Ref.ObjectRef) r1
                java.lang.Object r3 = r9.L$1
                kotlin.jvm.internal.Ref$ObjectRef r3 = (kotlin.jvm.internal.Ref.ObjectRef) r3
                java.lang.Object r5 = r9.L$0
                kotlinx.coroutines.flow.FlowCollector r5 = (kotlinx.coroutines.flow.FlowCollector) r5
                kotlin.ResultKt.throwOnFailure(r10)
                goto L6b
            L2c:
                kotlin.ResultKt.throwOnFailure(r10)
                java.lang.Object r10 = r9.L$0
                r5 = r10
                kotlinx.coroutines.flow.FlowCollector r5 = (kotlinx.coroutines.flow.FlowCollector) r5
                kotlin.jvm.internal.Ref$ObjectRef r10 = new kotlin.jvm.internal.Ref$ObjectRef
                r10.<init>()
                kotlin.jvm.internal.Ref$ObjectRef r1 = new kotlin.jvm.internal.Ref$ObjectRef
                r1.<init>()
                com.apollographql.apollo3.ApolloCall<D> r6 = r9.$this_watch
                kotlinx.coroutines.flow.Flow r6 = r6.toFlow()
                com.apollographql.apollo3.cache.normalized.NormalizedCache$watch$1$1 r7 = new com.apollographql.apollo3.cache.normalized.NormalizedCache$watch$1$1
                boolean r8 = r9.$fetchThrows
                r7.<init>(r8, r4)
                kotlin.jvm.functions.Function3 r7 = (kotlin.jvm.functions.Function3) r7
                kotlinx.coroutines.flow.Flow r6 = kotlinx.coroutines.flow.FlowKt.m16356catch(r6, r7)
                com.apollographql.apollo3.cache.normalized.NormalizedCache$watch$1$2 r7 = new com.apollographql.apollo3.cache.normalized.NormalizedCache$watch$1$2
                r7.<init>(r1, r10, r5)
                kotlinx.coroutines.flow.FlowCollector r7 = (kotlinx.coroutines.flow.FlowCollector) r7
                r8 = r9
                kotlin.coroutines.Continuation r8 = (kotlin.coroutines.Continuation) r8
                r9.L$0 = r5
                r9.L$1 = r10
                r9.L$2 = r1
                r9.label = r3
                java.lang.Object r3 = r6.collect(r7, r8)
                if (r3 != r0) goto L6a
                goto Lbd
            L6a:
                r3 = r10
            L6b:
                com.apollographql.apollo3.ApolloCall<D> r10 = r9.$this_watch
                com.apollographql.apollo3.ApolloCall r10 = r10.copy()
                com.apollographql.apollo3.api.MutableExecutionOptions r10 = (com.apollographql.apollo3.api.MutableExecutionOptions) r10
                com.apollographql.apollo3.ApolloCall<D> r6 = r9.$this_watch
                com.apollographql.apollo3.api.MutableExecutionOptions r6 = (com.apollographql.apollo3.api.MutableExecutionOptions) r6
                com.apollographql.apollo3.interceptor.ApolloInterceptor r6 = com.apollographql.apollo3.cache.normalized.NormalizedCache.access$getRefetchPolicyInterceptor(r6)
                java.lang.Object r10 = com.apollographql.apollo3.cache.normalized.NormalizedCache.fetchPolicyInterceptor(r10, r6)
                com.apollographql.apollo3.ApolloCall r10 = (com.apollographql.apollo3.ApolloCall) r10
                T r1 = r1.element
                com.apollographql.apollo3.api.ApolloResponse r1 = (com.apollographql.apollo3.api.ApolloResponse) r1
                if (r1 == 0) goto L8c
                D extends com.apollographql.apollo3.api.Operation$Data r1 = r1.data
                com.apollographql.apollo3.api.Query$Data r1 = (com.apollographql.apollo3.api.Query.Data) r1
                goto L8d
            L8c:
                r1 = r4
            L8d:
                com.apollographql.apollo3.cache.normalized.NormalizedCache$watch$1$3 r6 = new com.apollographql.apollo3.cache.normalized.NormalizedCache$watch$1$3
                boolean r7 = r9.$refetchThrows
                r6.<init>(r7, r4)
                kotlin.jvm.functions.Function3 r6 = (kotlin.jvm.functions.Function3) r6
                kotlinx.coroutines.flow.Flow r10 = com.apollographql.apollo3.cache.normalized.NormalizedCache.watch(r10, r1, r6)
                com.apollographql.apollo3.cache.normalized.NormalizedCache$watch$1$4 r1 = new com.apollographql.apollo3.cache.normalized.NormalizedCache$watch$1$4
                r1.<init>(r3, r4)
                kotlin.jvm.functions.Function2 r1 = (kotlin.jvm.functions.Function2) r1
                kotlinx.coroutines.flow.Flow r10 = kotlinx.coroutines.flow.FlowKt.onStart(r10, r1)
                com.apollographql.apollo3.cache.normalized.NormalizedCache$watch$1$5 r1 = new com.apollographql.apollo3.cache.normalized.NormalizedCache$watch$1$5
                r1.<init>()
                kotlinx.coroutines.flow.FlowCollector r1 = (kotlinx.coroutines.flow.FlowCollector) r1
                r3 = r9
                kotlin.coroutines.Continuation r3 = (kotlin.coroutines.Continuation) r3
                r9.L$0 = r4
                r9.L$1 = r4
                r9.L$2 = r4
                r9.label = r2
                java.lang.Object r9 = r10.collect(r1, r3)
                if (r9 != r0) goto Lbe
            Lbd:
                return r0
            Lbe:
                kotlin.Unit r9 = kotlin.Unit.INSTANCE
                return r9
            */
            throw new UnsupportedOperationException("Method not decompiled: com.apollographql.apollo3.cache.normalized.NormalizedCache.C08711.invokeSuspend(java.lang.Object):java.lang.Object");
        }

        /* JADX INFO: renamed from: com.apollographql.apollo3.cache.normalized.NormalizedCache$watch$1$1, reason: invalid class name and collision with other inner class name */
        /* JADX INFO: compiled from: ClientCacheExtensions.kt */
        @Metadata(d1 = {"\u0000\u001a\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0003\u0010\u0000\u001a\u00020\u0001\"\b\b\u0000\u0010\u0002*\u00020\u0003*\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00020\u00050\u00042\u0006\u0010\u0006\u001a\u00020\u0007H\u008a@"}, d2 = {"<anonymous>", "", "D", "Lcom/apollographql/apollo3/api/Query$Data;", "Lkotlinx/coroutines/flow/FlowCollector;", "Lcom/apollographql/apollo3/api/ApolloResponse;", "it", ""}, k = 3, mv = {1, 5, 1}, xi = 48)
        @DebugMetadata(c = "com.apollographql.apollo3.cache.normalized.NormalizedCache$watch$1$1", f = "ClientCacheExtensions.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
        static final class C01021 extends SuspendLambda implements Function3<FlowCollector<? super ApolloResponse<D>>, Throwable, Continuation<? super Unit>, Object> {
            final /* synthetic */ boolean $fetchThrows;
            /* synthetic */ Object L$0;
            int label;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            C01021(boolean z, Continuation<? super C01021> continuation) {
                super(3, continuation);
                this.$fetchThrows = z;
            }

            @Override // kotlin.jvm.functions.Function3
            public final Object invoke(FlowCollector<? super ApolloResponse<D>> flowCollector, Throwable th, Continuation<? super Unit> continuation) {
                C01021 c01021 = new C01021(this.$fetchThrows, continuation);
                c01021.L$0 = th;
                return c01021.invokeSuspend(Unit.INSTANCE);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object obj) throws Throwable {
                IntrinsicsKt.getCOROUTINE_SUSPENDED();
                if (this.label != 0) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
                Throwable th = (Throwable) this.L$0;
                if (!(th instanceof ApolloException) || this.$fetchThrows) {
                    throw th;
                }
                return Unit.INSTANCE;
            }
        }

        /* JADX INFO: renamed from: com.apollographql.apollo3.cache.normalized.NormalizedCache$watch$1$2, reason: invalid class name */
        /* JADX INFO: compiled from: ClientCacheExtensions.kt */
        @Metadata(d1 = {"\u0000\u0016\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001\"\b\b\u0000\u0010\u0002*\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0005H\u008a@¢\u0006\u0004\b\u0006\u0010\u0007"}, d2 = {"<anonymous>", "", "D", "Lcom/apollographql/apollo3/api/Query$Data;", "it", "Lcom/apollographql/apollo3/api/ApolloResponse;", "emit", "(Lcom/apollographql/apollo3/api/ApolloResponse;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;"}, k = 3, mv = {1, 5, 1}, xi = 48)
        static final class AnonymousClass2<T> implements FlowCollector {
            final /* synthetic */ FlowCollector<ApolloResponse<D>> $$this$flow;
            final /* synthetic */ Ref.ObjectRef<ApolloResponse<D>> $lastResponse;
            final /* synthetic */ Ref.ObjectRef<ApolloResponse<D>> $response;

            /* JADX WARN: Multi-variable type inference failed */
            AnonymousClass2(Ref.ObjectRef<ApolloResponse<D>> objectRef, Ref.ObjectRef<ApolloResponse<D>> objectRef2, FlowCollector<? super ApolloResponse<D>> flowCollector) {
                this.$response = objectRef;
                this.$lastResponse = objectRef2;
                this.$$this$flow = flowCollector;
            }

            /* JADX WARN: Code duplicated, block: B:7:0x0014  */
            /* JADX WARN: Code restructure failed: missing block: B:21:0x006f, code lost:
            
                if (r8.emit(r2, r0) == r1) goto L27;
             */
            /* JADX WARN: Code restructure failed: missing block: B:26:0x0081, code lost:
            
                if (r6.emit(r7, r0) == r1) goto L27;
             */
            /* JADX WARN: Multi-variable type inference failed */
            /* JADX WARN: Type inference failed for: r7v1, types: [T] */
            /* JADX WARN: Type inference failed for: r7v7 */
            /* JADX WARN: Type inference failed for: r7v8 */
            /* JADX WARN: Type inference failed for: r7v9 */
            /* JADX WARN: Type inference incomplete: some casts might be missing */
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct add '--show-bad-code' argument
            */
            public final java.lang.Object emit(com.apollographql.apollo3.api.ApolloResponse<D> r7, kotlin.coroutines.Continuation<? super kotlin.Unit> r8) {
                /*
                    r6 = this;
                    boolean r0 = r8 instanceof com.apollographql.apollo3.cache.normalized.NormalizedCache$watch$1$2$emit$1
                    if (r0 == 0) goto L14
                    r0 = r8
                    com.apollographql.apollo3.cache.normalized.NormalizedCache$watch$1$2$emit$1 r0 = (com.apollographql.apollo3.cache.normalized.NormalizedCache$watch$1$2$emit$1) r0
                    int r1 = r0.label
                    r2 = -2147483648(0xffffffff80000000, float:-0.0)
                    r1 = r1 & r2
                    if (r1 == 0) goto L14
                    int r8 = r0.label
                    int r8 = r8 - r2
                    r0.label = r8
                    goto L19
                L14:
                    com.apollographql.apollo3.cache.normalized.NormalizedCache$watch$1$2$emit$1 r0 = new com.apollographql.apollo3.cache.normalized.NormalizedCache$watch$1$2$emit$1
                    r0.<init>(r6, r8)
                L19:
                    java.lang.Object r8 = r0.result
                    java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
                    int r2 = r0.label
                    r3 = 2
                    r4 = 1
                    if (r2 == 0) goto L44
                    if (r2 == r4) goto L35
                    if (r2 != r3) goto L2d
                    kotlin.ResultKt.throwOnFailure(r8)
                    goto L84
                L2d:
                    java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
                    java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
                    r6.<init>(r7)
                    throw r6
                L35:
                    java.lang.Object r6 = r0.L$1
                    com.apollographql.apollo3.api.ApolloResponse r6 = (com.apollographql.apollo3.api.ApolloResponse) r6
                    java.lang.Object r7 = r0.L$0
                    com.apollographql.apollo3.cache.normalized.NormalizedCache$watch$1$2 r7 = (com.apollographql.apollo3.cache.normalized.NormalizedCache.C08711.AnonymousClass2) r7
                    kotlin.ResultKt.throwOnFailure(r8)
                    r5 = r7
                    r7 = r6
                    r6 = r5
                    goto L72
                L44:
                    kotlin.ResultKt.throwOnFailure(r8)
                    kotlin.jvm.internal.Ref$ObjectRef<com.apollographql.apollo3.api.ApolloResponse<D>> r8 = r6.$response
                    r8.element = r7
                    boolean r8 = r7.isLast
                    if (r8 == 0) goto L79
                    kotlin.jvm.internal.Ref$ObjectRef<com.apollographql.apollo3.api.ApolloResponse<D>> r8 = r6.$lastResponse
                    T r8 = r8.element
                    if (r8 == 0) goto L72
                    java.lang.String r8 = "ApolloGraphQL: extra response received after the last one"
                    java.io.PrintStream r2 = java.lang.System.out
                    r2.println(r8)
                    kotlinx.coroutines.flow.FlowCollector<com.apollographql.apollo3.api.ApolloResponse<D>> r8 = r6.$$this$flow
                    kotlin.jvm.internal.Ref$ObjectRef<com.apollographql.apollo3.api.ApolloResponse<D>> r2 = r6.$lastResponse
                    T r2 = r2.element
                    kotlin.jvm.internal.Intrinsics.checkNotNull(r2)
                    r0.L$0 = r6
                    r0.L$1 = r7
                    r0.label = r4
                    java.lang.Object r8 = r8.emit(r2, r0)
                    if (r8 != r1) goto L72
                    goto L83
                L72:
                    kotlin.jvm.internal.Ref$ObjectRef<com.apollographql.apollo3.api.ApolloResponse<D>> r6 = r6.$lastResponse
                    r6.element = r7
                    kotlin.Unit r6 = kotlin.Unit.INSTANCE
                    return r6
                L79:
                    kotlinx.coroutines.flow.FlowCollector<com.apollographql.apollo3.api.ApolloResponse<D>> r6 = r6.$$this$flow
                    r0.label = r3
                    java.lang.Object r6 = r6.emit(r7, r0)
                    if (r6 != r1) goto L84
                L83:
                    return r1
                L84:
                    kotlin.Unit r6 = kotlin.Unit.INSTANCE
                    return r6
                */
                throw new UnsupportedOperationException("Method not decompiled: com.apollographql.apollo3.cache.normalized.NormalizedCache.C08711.AnonymousClass2.emit(com.apollographql.apollo3.api.ApolloResponse, kotlin.coroutines.Continuation):java.lang.Object");
            }

            @Override // kotlinx.coroutines.flow.FlowCollector
            public /* bridge */ /* synthetic */ Object emit(Object obj, Continuation continuation) {
                return emit((ApolloResponse) obj, (Continuation<? super Unit>) continuation);
            }
        }

        /* JADX INFO: renamed from: com.apollographql.apollo3.cache.normalized.NormalizedCache$watch$1$3, reason: invalid class name */
        /* JADX INFO: compiled from: ClientCacheExtensions.kt */
        @Metadata(d1 = {"\u0000\u0018\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0003\n\u0000\n\u0002\u0010\t\u0010\u0000\u001a\u00020\u0001\"\b\b\u0000\u0010\u0002*\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u008a@"}, d2 = {"<anonymous>", "", "D", "Lcom/apollographql/apollo3/api/Query$Data;", "<anonymous parameter 0>", "", "<anonymous parameter 1>", ""}, k = 3, mv = {1, 5, 1}, xi = 48)
        @DebugMetadata(c = "com.apollographql.apollo3.cache.normalized.NormalizedCache$watch$1$3", f = "ClientCacheExtensions.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
        static final class AnonymousClass3 extends SuspendLambda implements Function3<Throwable, Long, Continuation<? super Boolean>, Object> {
            final /* synthetic */ boolean $refetchThrows;
            int label;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            AnonymousClass3(boolean z, Continuation<? super AnonymousClass3> continuation) {
                super(3, continuation);
                this.$refetchThrows = z;
            }

            @Override // kotlin.jvm.functions.Function3
            public /* bridge */ /* synthetic */ Object invoke(Throwable th, Long l, Continuation<? super Boolean> continuation) {
                return invoke(th, l.longValue(), continuation);
            }

            public final Object invoke(Throwable th, long j, Continuation<? super Boolean> continuation) {
                return new AnonymousClass3(this.$refetchThrows, continuation).invokeSuspend(Unit.INSTANCE);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object obj) {
                IntrinsicsKt.getCOROUTINE_SUSPENDED();
                if (this.label != 0) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
                return Boxing.boxBoolean(!this.$refetchThrows);
            }
        }

        /* JADX INFO: renamed from: com.apollographql.apollo3.cache.normalized.NormalizedCache$watch$1$4, reason: invalid class name */
        /* JADX INFO: compiled from: ClientCacheExtensions.kt */
        @Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001\"\b\b\u0000\u0010\u0002*\u00020\u0003*\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00020\u00050\u0004H\u008a@"}, d2 = {"<anonymous>", "", "D", "Lcom/apollographql/apollo3/api/Query$Data;", "Lkotlinx/coroutines/flow/FlowCollector;", "Lcom/apollographql/apollo3/api/ApolloResponse;"}, k = 3, mv = {1, 5, 1}, xi = 48)
        @DebugMetadata(c = "com.apollographql.apollo3.cache.normalized.NormalizedCache$watch$1$4", f = "ClientCacheExtensions.kt", i = {}, l = {180}, m = "invokeSuspend", n = {}, s = {})
        static final class AnonymousClass4 extends SuspendLambda implements Function2<FlowCollector<? super ApolloResponse<D>>, Continuation<? super Unit>, Object> {
            final /* synthetic */ Ref.ObjectRef<ApolloResponse<D>> $lastResponse;
            private /* synthetic */ Object L$0;
            int label;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            AnonymousClass4(Ref.ObjectRef<ApolloResponse<D>> objectRef, Continuation<? super AnonymousClass4> continuation) {
                super(2, continuation);
                this.$lastResponse = objectRef;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                AnonymousClass4 anonymousClass4 = new AnonymousClass4(this.$lastResponse, continuation);
                anonymousClass4.L$0 = obj;
                return anonymousClass4;
            }

            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(FlowCollector<? super ApolloResponse<D>> flowCollector, Continuation<? super Unit> continuation) {
                return ((AnonymousClass4) create(flowCollector, continuation)).invokeSuspend(Unit.INSTANCE);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object obj) {
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                int i = this.label;
                if (i == 0) {
                    ResultKt.throwOnFailure(obj);
                    FlowCollector flowCollector = (FlowCollector) this.L$0;
                    if (this.$lastResponse.element != null) {
                        ApolloResponse<D> apolloResponse = this.$lastResponse.element;
                        Intrinsics.checkNotNull(apolloResponse);
                        this.label = 1;
                        if (flowCollector.emit(apolloResponse, this) == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                    }
                } else {
                    if (i != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    ResultKt.throwOnFailure(obj);
                }
                return Unit.INSTANCE;
            }
        }
    }

    public static final <D extends Query.Data> Flow<ApolloResponse<D>> watch(ApolloCall<D> apolloCall, boolean z, boolean z2) {
        Intrinsics.checkNotNullParameter(apolloCall, "<this>");
        return FlowKt.flow(new C08711(apolloCall, z, z2, null));
    }

    /* JADX INFO: renamed from: com.apollographql.apollo3.cache.normalized.NormalizedCache$watch$2, reason: invalid class name */
    /* JADX INFO: compiled from: ClientCacheExtensions.kt */
    @Metadata(d1 = {"\u0000\u0018\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0003\n\u0000\n\u0002\u0010\t\u0010\u0000\u001a\u00020\u0001\"\b\b\u0000\u0010\u0002*\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u008a@"}, d2 = {"<anonymous>", "", "D", "Lcom/apollographql/apollo3/api/Query$Data;", "<anonymous parameter 0>", "", "<anonymous parameter 1>", ""}, k = 3, mv = {1, 5, 1}, xi = 48)
    @DebugMetadata(c = "com.apollographql.apollo3.cache.normalized.NormalizedCache$watch$2", f = "ClientCacheExtensions.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    static final class AnonymousClass2 extends SuspendLambda implements Function3<Throwable, Long, Continuation<? super Boolean>, Object> {
        int label;

        AnonymousClass2(Continuation<? super AnonymousClass2> continuation) {
            super(3, continuation);
        }

        @Override // kotlin.jvm.functions.Function3
        public /* bridge */ /* synthetic */ Object invoke(Throwable th, Long l, Continuation<? super Boolean> continuation) {
            return invoke(th, l.longValue(), continuation);
        }

        public final Object invoke(Throwable th, long j, Continuation<? super Boolean> continuation) {
            return new AnonymousClass2(continuation).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            return Boxing.boxBoolean(true);
        }
    }

    public static /* synthetic */ Flow watch$default(ApolloCall apolloCall, Query.Data data, Function3 function3, int i, Object obj) {
        if ((i & 2) != 0) {
            function3 = new AnonymousClass2(null);
        }
        return watch((ApolloCall<Query.Data>) apolloCall, data, (Function3<? super Throwable, ? super Long, ? super Continuation<? super Boolean>, ? extends Object>) function3);
    }

    public static final <D extends Query.Data> Flow<ApolloResponse<D>> watch(ApolloCall<D> apolloCall, D d, Function3<? super Throwable, ? super Long, ? super Continuation<? super Boolean>, ? extends Object> retryWhen) {
        Intrinsics.checkNotNullParameter(apolloCall, "<this>");
        Intrinsics.checkNotNullParameter(retryWhen, "retryWhen");
        return apolloCall.copy().addExecutionContext(new WatchContext(d, retryWhen)).toFlow();
    }

    /* JADX INFO: Add missing generic type declarations: [D] */
    /* JADX INFO: renamed from: com.apollographql.apollo3.cache.normalized.NormalizedCache$executeCacheAndNetwork$1, reason: invalid class name */
    /* JADX INFO: compiled from: ClientCacheExtensions.kt */
    @Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001\"\b\b\u0000\u0010\u0002*\u00020\u0003*\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00020\u00050\u0004H\u008a@"}, d2 = {"<anonymous>", "", "D", "Lcom/apollographql/apollo3/api/Query$Data;", "Lkotlinx/coroutines/flow/FlowCollector;", "Lcom/apollographql/apollo3/api/ApolloResponse;"}, k = 3, mv = {1, 5, 1}, xi = 48)
    @DebugMetadata(c = "com.apollographql.apollo3.cache.normalized.NormalizedCache$executeCacheAndNetwork$1", f = "ClientCacheExtensions.kt", i = {0, 1, 2, 3}, l = {213, 213, BoxCommonConstants.REQUEST_INVITE_COLLABORATORS, BoxCommonConstants.REQUEST_INVITE_COLLABORATORS}, m = "invokeSuspend", n = {"$this$flow", "$this$flow", "cacheException", "cacheException"}, s = {"L$0", "L$0", "L$0", "L$0"})
    static final class AnonymousClass1<D> extends SuspendLambda implements Function2<FlowCollector<? super ApolloResponse<D>>, Continuation<? super Unit>, Object> {
        final /* synthetic */ ApolloCall<D> $this_executeCacheAndNetwork;
        private /* synthetic */ Object L$0;
        Object L$1;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(ApolloCall<D> apolloCall, Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
            this.$this_executeCacheAndNetwork = apolloCall;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            AnonymousClass1 anonymousClass1 = new AnonymousClass1(this.$this_executeCacheAndNetwork, continuation);
            anonymousClass1.L$0 = obj;
            return anonymousClass1;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(FlowCollector<? super ApolloResponse<D>> flowCollector, Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(flowCollector, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Code duplicated, block: B:41:0x00b2  */
        /* JADX WARN: Code duplicated, block: B:42:0x00b3 A[Catch: ApolloException -> 0x00c5, PHI: r1 r3 r10
          0x00b3: PHI (r1v2 ??) = (r1v15 ??), (r1v16 ??) binds: [B:40:0x00b0, B:17:0x0035] A[DONT_GENERATE, DONT_INLINE]
          0x00b3: PHI (r3v2 java.lang.Object) = (r3v1 java.lang.Object), (r3v5 java.lang.Object) binds: [B:40:0x00b0, B:17:0x0035] A[DONT_GENERATE, DONT_INLINE]
          0x00b3: PHI (r10v5 'e' com.apollographql.apollo3.exception.ApolloException) = 
          (r10v2 'e' com.apollographql.apollo3.exception.ApolloException)
          (r10v18 'e' com.apollographql.apollo3.exception.ApolloException)
         binds: [B:40:0x00b0, B:17:0x0035] A[DONT_GENERATE, DONT_INLINE], TRY_LEAVE, TryCatch #4 {ApolloException -> 0x00c5, blocks: (B:42:0x00b3, B:39:0x0093), top: B:62:0x0093 }] */
        /* JADX WARN: Code restructure failed: missing block: B:43:0x00c0, code lost:
        
            if (r1.emit(r3, r9) == r0) goto L44;
         */
        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r1v0, types: [int] */
        /* JADX WARN: Type inference failed for: r1v1, types: [java.lang.Object] */
        /* JADX WARN: Type inference failed for: r1v15 */
        /* JADX WARN: Type inference failed for: r1v16 */
        /* JADX WARN: Type inference failed for: r1v17 */
        /* JADX WARN: Type inference failed for: r1v2, types: [kotlinx.coroutines.flow.FlowCollector] */
        /* JADX WARN: Type inference failed for: r1v5 */
        /* JADX WARN: Type inference failed for: r1v7 */
        /* JADX WARN: Type inference failed for: r1v8 */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final java.lang.Object invokeSuspend(java.lang.Object r10) {
            /*
                Method dump skipped, instruction units count: 218
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: com.apollographql.apollo3.cache.normalized.NormalizedCache.AnonymousClass1.invokeSuspend(java.lang.Object):java.lang.Object");
        }
    }

    @Deprecated(message = "Use fetchPolicy(FetchPolicy.CacheAndNetwork) instead", replaceWith = @ReplaceWith(expression = "fetchPolicy(FetchPolicy.CacheAndNetwork).toFlow()", imports = {}))
    public static final <D extends Query.Data> Flow<ApolloResponse<D>> executeCacheAndNetwork(ApolloCall<D> apolloCall) {
        Intrinsics.checkNotNullParameter(apolloCall, "<this>");
        return FlowKt.flow(new AnonymousClass1(apolloCall, null));
    }

    public static final ApolloStore getApolloStore(ApolloClient apolloClient) {
        Object next;
        ApolloStore store;
        Intrinsics.checkNotNullParameter(apolloClient, "<this>");
        Iterator<T> it = apolloClient.getInterceptors().iterator();
        do {
            if (!it.hasNext()) {
                next = null;
                break;
            }
            next = it.next();
        } while (!(((ApolloInterceptor) next) instanceof ApolloCacheInterceptor));
        ApolloInterceptor apolloInterceptor = (ApolloInterceptor) next;
        if (apolloInterceptor == null || (store = ((ApolloCacheInterceptor) apolloInterceptor).getStore()) == null) {
            throw new IllegalStateException("no cache configured".toString());
        }
        return store;
    }

    @Deprecated(message = "Used for backward compatibility with 2.x.", replaceWith = @ReplaceWith(expression = "apolloStore", imports = {}))
    public static final ApolloStore apolloStore(ApolloClient apolloClient) {
        Intrinsics.checkNotNullParameter(apolloClient, "<this>");
        return getApolloStore(apolloClient);
    }

    @Deprecated(message = "Use apolloStore directly", replaceWith = @ReplaceWith(expression = "apolloStore.clearAll()", imports = {}))
    public static final boolean clearNormalizedCache(ApolloClient apolloClient) {
        Intrinsics.checkNotNullParameter(apolloClient, "<this>");
        return getApolloStore(apolloClient).clearAll();
    }

    public static final <T> T fetchPolicy(MutableExecutionOptions<T> mutableExecutionOptions, FetchPolicy fetchPolicy) {
        Intrinsics.checkNotNullParameter(mutableExecutionOptions, "<this>");
        Intrinsics.checkNotNullParameter(fetchPolicy, "fetchPolicy");
        return mutableExecutionOptions.addExecutionContext(new FetchPolicyContext(interceptorFor(fetchPolicy)));
    }

    public static final <T> T refetchPolicy(MutableExecutionOptions<T> mutableExecutionOptions, FetchPolicy fetchPolicy) {
        Intrinsics.checkNotNullParameter(mutableExecutionOptions, "<this>");
        Intrinsics.checkNotNullParameter(fetchPolicy, "fetchPolicy");
        return mutableExecutionOptions.addExecutionContext(new RefetchPolicyContext(interceptorFor(fetchPolicy)));
    }

    public static final <T> T fetchPolicyInterceptor(MutableExecutionOptions<T> mutableExecutionOptions, ApolloInterceptor interceptor) {
        Intrinsics.checkNotNullParameter(mutableExecutionOptions, "<this>");
        Intrinsics.checkNotNullParameter(interceptor, "interceptor");
        return mutableExecutionOptions.addExecutionContext(new FetchPolicyContext(interceptor));
    }

    public static final <T> T refetchPolicyInterceptor(MutableExecutionOptions<T> mutableExecutionOptions, ApolloInterceptor interceptor) {
        Intrinsics.checkNotNullParameter(mutableExecutionOptions, "<this>");
        Intrinsics.checkNotNullParameter(interceptor, "interceptor");
        return mutableExecutionOptions.addExecutionContext(new RefetchPolicyContext(interceptor));
    }

    private static final ApolloInterceptor interceptorFor(FetchPolicy fetchPolicy) {
        int i = WhenMappings.$EnumSwitchMapping$0[fetchPolicy.ordinal()];
        if (i == 1) {
            return FetchPolicyInterceptors.getCacheOnlyInterceptor();
        }
        if (i == 2) {
            return FetchPolicyInterceptors.getNetworkOnlyInterceptor();
        }
        if (i == 3) {
            return FetchPolicyInterceptors.getCacheFirstInterceptor();
        }
        if (i == 4) {
            return FetchPolicyInterceptors.getNetworkFirstInterceptor();
        }
        if (i == 5) {
            return FetchPolicyInterceptors.getCacheAndNetworkInterceptor();
        }
        throw new NoWhenBranchMatchedException();
    }

    public static final <T> T doNotStore(MutableExecutionOptions<T> mutableExecutionOptions, boolean z) {
        Intrinsics.checkNotNullParameter(mutableExecutionOptions, "<this>");
        return mutableExecutionOptions.addExecutionContext(new DoNotStoreContext(z));
    }

    public static final <T> T emitCacheMisses(MutableExecutionOptions<T> mutableExecutionOptions, boolean z) {
        Intrinsics.checkNotNullParameter(mutableExecutionOptions, "<this>");
        return mutableExecutionOptions.addExecutionContext(new EmitCacheMissesContext(z));
    }

    public static final <T> T storePartialResponses(MutableExecutionOptions<T> mutableExecutionOptions, boolean z) {
        Intrinsics.checkNotNullParameter(mutableExecutionOptions, "<this>");
        return mutableExecutionOptions.addExecutionContext(new StorePartialResponsesContext(z));
    }

    public static final <T> T storeReceiveDate(MutableExecutionOptions<T> mutableExecutionOptions, boolean z) {
        Intrinsics.checkNotNullParameter(mutableExecutionOptions, "<this>");
        return mutableExecutionOptions.addExecutionContext(new StoreReceiveDateContext(z));
    }

    public static final <T> T storeExpirationDate(MutableExecutionOptions<T> mutableExecutionOptions, boolean z) {
        Intrinsics.checkNotNullParameter(mutableExecutionOptions, "<this>");
        mutableExecutionOptions.addExecutionContext(new StoreExpirationDateContext(z));
        if (mutableExecutionOptions instanceof ApolloClient.Builder) {
            ApolloClient.Builder builder = (ApolloClient.Builder) mutableExecutionOptions;
            List<ApolloInterceptor> interceptors = builder.getInterceptors();
            if (!(interceptors instanceof Collection) || !interceptors.isEmpty()) {
                Iterator<T> it = interceptors.iterator();
                while (it.hasNext()) {
                    if (((ApolloInterceptor) it.next()) instanceof StoreExpirationInterceptor) {
                        throw new IllegalStateException("Apollo: storeExpirationDate() can only be called once on ApolloClient.Builder()".toString());
                    }
                }
            }
            builder.addInterceptor(new StoreExpirationInterceptor());
        }
        return mutableExecutionOptions;
    }

    public static final <T> T cacheHeaders(MutableExecutionOptions<T> mutableExecutionOptions, CacheHeaders cacheHeaders) {
        Intrinsics.checkNotNullParameter(mutableExecutionOptions, "<this>");
        Intrinsics.checkNotNullParameter(cacheHeaders, "cacheHeaders");
        return mutableExecutionOptions.addExecutionContext(new CacheHeadersContext(cacheHeaders));
    }

    public static final <T> T writeToCacheAsynchronously(MutableExecutionOptions<T> mutableExecutionOptions, boolean z) {
        Intrinsics.checkNotNullParameter(mutableExecutionOptions, "<this>");
        return mutableExecutionOptions.addExecutionContext(new WriteToCacheAsynchronouslyContext(z));
    }

    public static final <D extends Mutation.Data> ApolloRequest.Builder<D> optimisticUpdates(ApolloRequest.Builder<D> builder, D data) {
        Intrinsics.checkNotNullParameter(builder, "<this>");
        Intrinsics.checkNotNullParameter(data, "data");
        return (ApolloRequest.Builder<D>) builder.addExecutionContext((ExecutionContext) new OptimisticUpdatesContext(data));
    }

    public static final <D extends Mutation.Data> ApolloCall<D> optimisticUpdates(ApolloCall<D> apolloCall, D data) {
        Intrinsics.checkNotNullParameter(apolloCall, "<this>");
        Intrinsics.checkNotNullParameter(data, "data");
        return (ApolloCall<D>) apolloCall.addExecutionContext((ExecutionContext) new OptimisticUpdatesContext(data));
    }

    public static final <D extends Operation.Data> ApolloInterceptor getFetchPolicyInterceptor(ApolloRequest<D> apolloRequest) {
        ApolloInterceptor interceptor;
        Intrinsics.checkNotNullParameter(apolloRequest, "<this>");
        FetchPolicyContext fetchPolicyContext = (FetchPolicyContext) apolloRequest.getExecutionContext().get(FetchPolicyContext.INSTANCE);
        return (fetchPolicyContext == null || (interceptor = fetchPolicyContext.getInterceptor()) == null) ? FetchPolicyInterceptors.getCacheFirstInterceptor() : interceptor;
    }

    public static final <D extends Operation.Data> ApolloInterceptor getFetchPolicyInterceptor(ApolloCall<D> apolloCall) {
        ApolloInterceptor interceptor;
        Intrinsics.checkNotNullParameter(apolloCall, "<this>");
        FetchPolicyContext fetchPolicyContext = (FetchPolicyContext) apolloCall.getExecutionContext().get(FetchPolicyContext.INSTANCE);
        return (fetchPolicyContext == null || (interceptor = fetchPolicyContext.getInterceptor()) == null) ? FetchPolicyInterceptors.getCacheFirstInterceptor() : interceptor;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final <T> ApolloInterceptor getRefetchPolicyInterceptor(MutableExecutionOptions<T> mutableExecutionOptions) {
        ApolloInterceptor interceptor;
        RefetchPolicyContext refetchPolicyContext = (RefetchPolicyContext) mutableExecutionOptions.getExecutionContext().get(RefetchPolicyContext.INSTANCE);
        return (refetchPolicyContext == null || (interceptor = refetchPolicyContext.getInterceptor()) == null) ? FetchPolicyInterceptors.getCacheOnlyInterceptor() : interceptor;
    }

    public static final <D extends Operation.Data> boolean getDoNotStore(ApolloRequest<D> apolloRequest) {
        Intrinsics.checkNotNullParameter(apolloRequest, "<this>");
        DoNotStoreContext doNotStoreContext = (DoNotStoreContext) apolloRequest.getExecutionContext().get(DoNotStoreContext.INSTANCE);
        if (doNotStoreContext != null) {
            return doNotStoreContext.getValue();
        }
        return false;
    }

    public static final <D extends Operation.Data> boolean getStorePartialResponses(ApolloRequest<D> apolloRequest) {
        Intrinsics.checkNotNullParameter(apolloRequest, "<this>");
        StorePartialResponsesContext storePartialResponsesContext = (StorePartialResponsesContext) apolloRequest.getExecutionContext().get(StorePartialResponsesContext.INSTANCE);
        if (storePartialResponsesContext != null) {
            return storePartialResponsesContext.getValue();
        }
        return false;
    }

    public static final <D extends Operation.Data> boolean getStoreReceiveDate(ApolloRequest<D> apolloRequest) {
        Intrinsics.checkNotNullParameter(apolloRequest, "<this>");
        StoreReceiveDateContext storeReceiveDateContext = (StoreReceiveDateContext) apolloRequest.getExecutionContext().get(StoreReceiveDateContext.INSTANCE);
        if (storeReceiveDateContext != null) {
            return storeReceiveDateContext.getValue();
        }
        return false;
    }

    public static final <D extends Operation.Data> boolean getEmitCacheMisses(ApolloRequest<D> apolloRequest) {
        Intrinsics.checkNotNullParameter(apolloRequest, "<this>");
        EmitCacheMissesContext emitCacheMissesContext = (EmitCacheMissesContext) apolloRequest.getExecutionContext().get(EmitCacheMissesContext.INSTANCE);
        if (emitCacheMissesContext != null) {
            return emitCacheMissesContext.getValue();
        }
        return false;
    }

    public static final <D extends Operation.Data> boolean getWriteToCacheAsynchronously(ApolloRequest<D> apolloRequest) {
        Intrinsics.checkNotNullParameter(apolloRequest, "<this>");
        WriteToCacheAsynchronouslyContext writeToCacheAsynchronouslyContext = (WriteToCacheAsynchronouslyContext) apolloRequest.getExecutionContext().get(WriteToCacheAsynchronouslyContext.INSTANCE);
        if (writeToCacheAsynchronouslyContext != null) {
            return writeToCacheAsynchronouslyContext.getValue();
        }
        return false;
    }

    public static final <D extends Mutation.Data> Mutation.Data getOptimisticData(ApolloRequest<D> apolloRequest) {
        Intrinsics.checkNotNullParameter(apolloRequest, "<this>");
        OptimisticUpdatesContext optimisticUpdatesContext = (OptimisticUpdatesContext) apolloRequest.getExecutionContext().get(OptimisticUpdatesContext.INSTANCE);
        if (optimisticUpdatesContext != null) {
            return optimisticUpdatesContext.getValue();
        }
        return null;
    }

    public static final <D extends Operation.Data> CacheHeaders getCacheHeaders(ApolloRequest<D> apolloRequest) {
        CacheHeaders value;
        Intrinsics.checkNotNullParameter(apolloRequest, "<this>");
        CacheHeadersContext cacheHeadersContext = (CacheHeadersContext) apolloRequest.getExecutionContext().get(CacheHeadersContext.INSTANCE);
        return (cacheHeadersContext == null || (value = cacheHeadersContext.getValue()) == null) ? CacheHeaders.NONE : value;
    }

    public static final <D extends Operation.Data> WatchContext getWatchContext(ApolloRequest<D> apolloRequest) {
        Intrinsics.checkNotNullParameter(apolloRequest, "<this>");
        return (WatchContext) apolloRequest.getExecutionContext().get(WatchContext.INSTANCE);
    }

    public static final <D extends Operation.Data> boolean isFromCache(ApolloResponse<D> apolloResponse) {
        Intrinsics.checkNotNullParameter(apolloResponse, "<this>");
        CacheInfo cacheInfo = getCacheInfo(apolloResponse);
        return cacheInfo != null && cacheInfo.isCacheHit();
    }

    public static final <D extends Operation.Data> CacheInfo getCacheInfo(ApolloResponse<D> apolloResponse) {
        Intrinsics.checkNotNullParameter(apolloResponse, "<this>");
        return (CacheInfo) apolloResponse.executionContext.get(CacheInfo.INSTANCE);
    }

    public static final <D extends Operation.Data> ApolloResponse<D> withCacheInfo(ApolloResponse<D> apolloResponse, CacheInfo cacheInfo) {
        Intrinsics.checkNotNullParameter(apolloResponse, "<this>");
        Intrinsics.checkNotNullParameter(cacheInfo, "cacheInfo");
        return apolloResponse.newBuilder().addExecutionContext(cacheInfo).build();
    }

    public static final <D extends Operation.Data> ApolloResponse.Builder<D> cacheInfo(ApolloResponse.Builder<D> builder, CacheInfo cacheInfo) {
        Intrinsics.checkNotNullParameter(builder, "<this>");
        Intrinsics.checkNotNullParameter(cacheInfo, "cacheInfo");
        return builder.addExecutionContext(cacheInfo);
    }

    public static final <D extends Operation.Data> ApolloRequest.Builder<D> fetchFromCache(ApolloRequest.Builder<D> builder, boolean z) {
        Intrinsics.checkNotNullParameter(builder, "<this>");
        builder.addExecutionContext((ExecutionContext) new FetchFromCacheContext(z));
        return builder;
    }

    public static final <D extends Operation.Data> boolean getFetchFromCache(ApolloRequest<D> apolloRequest) {
        Intrinsics.checkNotNullParameter(apolloRequest, "<this>");
        FetchFromCacheContext fetchFromCacheContext = (FetchFromCacheContext) apolloRequest.getExecutionContext().get(FetchFromCacheContext.INSTANCE);
        if (fetchFromCacheContext != null) {
            return fetchFromCacheContext.getValue();
        }
        return false;
    }

    public static final <D extends Operation.Data> ApolloResponse.Builder<D> cacheHeaders(ApolloResponse.Builder<D> builder, CacheHeaders cacheHeaders) {
        Intrinsics.checkNotNullParameter(builder, "<this>");
        Intrinsics.checkNotNullParameter(cacheHeaders, "cacheHeaders");
        return builder.addExecutionContext(new CacheHeadersContext(cacheHeaders));
    }

    public static final <D extends Operation.Data> CacheHeaders getCacheHeaders(ApolloResponse<D> apolloResponse) {
        CacheHeaders value;
        Intrinsics.checkNotNullParameter(apolloResponse, "<this>");
        CacheHeadersContext cacheHeadersContext = (CacheHeadersContext) apolloResponse.executionContext.get(CacheHeadersContext.INSTANCE);
        return (cacheHeadersContext == null || (value = cacheHeadersContext.getValue()) == null) ? CacheHeaders.NONE : value;
    }
}
