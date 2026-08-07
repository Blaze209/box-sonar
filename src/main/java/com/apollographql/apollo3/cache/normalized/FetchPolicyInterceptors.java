package com.apollographql.apollo3.cache.normalized;

import com.apollographql.apollo3.api.ApolloRequest;
import com.apollographql.apollo3.api.ApolloResponse;
import com.apollographql.apollo3.api.Operation;
import com.apollographql.apollo3.api.Query;
import com.apollographql.apollo3.interceptor.ApolloInterceptor;
import com.apollographql.apollo3.interceptor.ApolloInterceptorChain;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowKt;

/* JADX INFO: compiled from: FetchPolicyInterceptors.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\"\u0011\u0010\u0000\u001a\u00020\u0001¢\u0006\b\n\u0000\u001a\u0004\b\u0002\u0010\u0003\"\u0011\u0010\u0004\u001a\u00020\u0001¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0003\"\u0011\u0010\u0006\u001a\u00020\u0001¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\u0003\"\u0014\u0010\b\u001a\u00020\u0001X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\u0003\"\u0011\u0010\n\u001a\u00020\u0001¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\u0003\"\u0011\u0010\f\u001a\u00020\u0001¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u0003¨\u0006\u000e"}, d2 = {"CacheAndNetworkInterceptor", "Lcom/apollographql/apollo3/interceptor/ApolloInterceptor;", "getCacheAndNetworkInterceptor", "()Lcom/apollographql/apollo3/interceptor/ApolloInterceptor;", "CacheFirstInterceptor", "getCacheFirstInterceptor", "CacheOnlyInterceptor", "getCacheOnlyInterceptor", "FetchPolicyRouterInterceptor", "getFetchPolicyRouterInterceptor", "NetworkFirstInterceptor", "getNetworkFirstInterceptor", "NetworkOnlyInterceptor", "getNetworkOnlyInterceptor", "apollo-normalized-cache"}, k = 2, mv = {1, 5, 1}, xi = 48)
public final class FetchPolicyInterceptors {
    private static final ApolloInterceptor CacheOnlyInterceptor = new ApolloInterceptor() { // from class: com.apollographql.apollo3.cache.normalized.FetchPolicyInterceptors$CacheOnlyInterceptor$1
        @Override // com.apollographql.apollo3.interceptor.ApolloInterceptor
        public <D extends Operation.Data> Flow<ApolloResponse<D>> intercept(ApolloRequest<D> request, ApolloInterceptorChain chain) {
            Intrinsics.checkNotNullParameter(request, "request");
            Intrinsics.checkNotNullParameter(chain, "chain");
            return chain.proceed(NormalizedCache.fetchFromCache(request.newBuilder(), true).build());
        }
    };
    private static final ApolloInterceptor NetworkOnlyInterceptor = new ApolloInterceptor() { // from class: com.apollographql.apollo3.cache.normalized.FetchPolicyInterceptors$NetworkOnlyInterceptor$1
        @Override // com.apollographql.apollo3.interceptor.ApolloInterceptor
        public <D extends Operation.Data> Flow<ApolloResponse<D>> intercept(ApolloRequest<D> request, ApolloInterceptorChain chain) {
            Intrinsics.checkNotNullParameter(request, "request");
            Intrinsics.checkNotNullParameter(chain, "chain");
            return chain.proceed(request);
        }
    };
    private static final ApolloInterceptor CacheFirstInterceptor = new ApolloInterceptor() { // from class: com.apollographql.apollo3.cache.normalized.FetchPolicyInterceptors$CacheFirstInterceptor$1
        @Override // com.apollographql.apollo3.interceptor.ApolloInterceptor
        public <D extends Operation.Data> Flow<ApolloResponse<D>> intercept(ApolloRequest<D> request, ApolloInterceptorChain chain) {
            Intrinsics.checkNotNullParameter(request, "request");
            Intrinsics.checkNotNullParameter(chain, "chain");
            return FlowKt.flow(new FetchPolicyInterceptors$CacheFirstInterceptor$1$intercept$1(chain, request, null));
        }
    };
    private static final ApolloInterceptor NetworkFirstInterceptor = new ApolloInterceptor() { // from class: com.apollographql.apollo3.cache.normalized.FetchPolicyInterceptors$NetworkFirstInterceptor$1
        @Override // com.apollographql.apollo3.interceptor.ApolloInterceptor
        public <D extends Operation.Data> Flow<ApolloResponse<D>> intercept(ApolloRequest<D> request, ApolloInterceptorChain chain) {
            Intrinsics.checkNotNullParameter(request, "request");
            Intrinsics.checkNotNullParameter(chain, "chain");
            return FlowKt.flow(new FetchPolicyInterceptors$NetworkFirstInterceptor$1$intercept$1(chain, request, null));
        }
    };
    private static final ApolloInterceptor CacheAndNetworkInterceptor = new ApolloInterceptor() { // from class: com.apollographql.apollo3.cache.normalized.FetchPolicyInterceptors$CacheAndNetworkInterceptor$1
        @Override // com.apollographql.apollo3.interceptor.ApolloInterceptor
        public <D extends Operation.Data> Flow<ApolloResponse<D>> intercept(ApolloRequest<D> request, ApolloInterceptorChain chain) {
            Intrinsics.checkNotNullParameter(request, "request");
            Intrinsics.checkNotNullParameter(chain, "chain");
            return FlowKt.flow(new FetchPolicyInterceptors$CacheAndNetworkInterceptor$1$intercept$1(chain, request, null));
        }
    };
    private static final ApolloInterceptor FetchPolicyRouterInterceptor = new ApolloInterceptor() { // from class: com.apollographql.apollo3.cache.normalized.FetchPolicyInterceptors$FetchPolicyRouterInterceptor$1
        @Override // com.apollographql.apollo3.interceptor.ApolloInterceptor
        public <D extends Operation.Data> Flow<ApolloResponse<D>> intercept(ApolloRequest<D> request, ApolloInterceptorChain chain) {
            Intrinsics.checkNotNullParameter(request, "request");
            Intrinsics.checkNotNullParameter(chain, "chain");
            if (!(request.getOperation() instanceof Query)) {
                return chain.proceed(request);
            }
            return NormalizedCache.getFetchPolicyInterceptor(request).intercept(request, chain);
        }
    };

    public static final ApolloInterceptor getCacheOnlyInterceptor() {
        return CacheOnlyInterceptor;
    }

    public static final ApolloInterceptor getNetworkOnlyInterceptor() {
        return NetworkOnlyInterceptor;
    }

    public static final ApolloInterceptor getCacheFirstInterceptor() {
        return CacheFirstInterceptor;
    }

    public static final ApolloInterceptor getNetworkFirstInterceptor() {
        return NetworkFirstInterceptor;
    }

    public static final ApolloInterceptor getCacheAndNetworkInterceptor() {
        return CacheAndNetworkInterceptor;
    }

    public static final ApolloInterceptor getFetchPolicyRouterInterceptor() {
        return FetchPolicyRouterInterceptor;
    }
}
