package com.apollographql.apollo3;

import androidx.exifinterface.media.ExifInterface;
import com.apollographql.apollo3.api.Adapter;
import com.apollographql.apollo3.api.ApolloRequest;
import com.apollographql.apollo3.api.ApolloResponse;
import com.apollographql.apollo3.api.CustomScalarAdapters;
import com.apollographql.apollo3.api.CustomScalarType;
import com.apollographql.apollo3.api.CustomTypeAdapter;
import com.apollographql.apollo3.api.ExecutionContext;
import com.apollographql.apollo3.api.ExecutionOptions;
import com.apollographql.apollo3.api.MutableExecutionOptions;
import com.apollographql.apollo3.api.Mutation;
import com.apollographql.apollo3.api.Operation;
import com.apollographql.apollo3.api.Query;
import com.apollographql.apollo3.api.Subscription;
import com.apollographql.apollo3.api.http.HttpHeader;
import com.apollographql.apollo3.api.http.HttpMethod;
import com.apollographql.apollo3.api.internal.Version2CustomTypeAdapterToAdapter;
import com.apollographql.apollo3.interceptor.ApolloInterceptor;
import com.apollographql.apollo3.interceptor.AutoPersistedQueryInterceptor;
import com.apollographql.apollo3.interceptor.DefaultInterceptorChain;
import com.apollographql.apollo3.interceptor.NetworkInterceptor;
import com.apollographql.apollo3.internal.DispatchersKt;
import com.apollographql.apollo3.network.NetworkTransport;
import com.apollographql.apollo3.network.http.BatchingHttpInterceptor;
import com.apollographql.apollo3.network.http.HttpEngine;
import com.apollographql.apollo3.network.http.HttpInterceptor;
import com.apollographql.apollo3.network.http.HttpNetworkTransport;
import com.apollographql.apollo3.network.ws.WebSocketEngine;
import com.apollographql.apollo3.network.ws.WebSocketNetworkTransport;
import com.apollographql.apollo3.network.ws.WsProtocol;
import com.box.android.domain.analytics.BoxAmplitudeAnalytics;
import com.microsoft.identity.common.internal.broker.SerializedNames;
import io.opentelemetry.semconv.trace.attributes.SemanticAttributes;
import java.io.Closeable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.NotImplementedError;
import kotlin.ReplaceWith;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.flow.Flow;
import org.apache.hc.core5.http.HeaderElements;

/* JADX INFO: compiled from: ApolloClient.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000¸\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0001\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 P2\u00020\u00012\u00060\u0002j\u0002`\u0003:\u0002OPB\u0089\u0001\b\u0002\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\u0005\u0012\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\n\u0012\u0006\u0010\f\u001a\u00020\r\u0012\b\u0010\u000e\u001a\u0004\u0018\u00010\u000f\u0012\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011\u0012\u000e\u0010\u0012\u001a\n\u0012\u0004\u0012\u00020\u0013\u0018\u00010\n\u0012\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015\u0012\b\u0010\u0016\u001a\u0004\u0018\u00010\u0015\u0012\b\u0010\u0017\u001a\u0004\u0018\u00010\u0015\u0012\b\u0010\u0018\u001a\u0004\u0018\u00010\u0015\u0012\u0006\u0010\u0019\u001a\u00020\u001a¢\u0006\u0002\u0010\u001bJ\b\u00102\u001a\u000203H\u0016J\b\u00104\u001a\u000203H\u0007J*\u00105\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002H80706\"\b\b\u0000\u00108*\u0002092\f\u0010:\u001a\b\u0012\u0004\u0012\u0002H80;J9\u00105\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002H80706\"\b\b\u0000\u00108*\u0002092\f\u0010:\u001a\b\u0012\u0004\u0012\u0002H80;2\u0006\u0010<\u001a\u00020\u0015H\u0000¢\u0006\u0002\b=J&\u0010>\u001a\b\u0012\u0004\u0012\u0002H80?\"\b\b\u0000\u00108*\u00020@2\f\u0010A\u001a\b\u0012\u0004\u0012\u0002H80BH\u0007J$\u0010A\u001a\b\u0012\u0004\u0012\u0002H80?\"\b\b\u0000\u00108*\u00020@2\f\u0010A\u001a\b\u0012\u0004\u0012\u0002H80BJ\u0006\u0010C\u001a\u00020\u001aJ \u0010D\u001a\u00020E\"\b\b\u0000\u00108*\u0002092\f\u0010F\u001a\b\u0012\u0004\u0012\u0002H80GH\u0007J$\u0010H\u001a\b\u0012\u0004\u0012\u0002H80?\"\b\b\u0000\u00108*\u00020I2\f\u0010H\u001a\b\u0012\u0004\u0012\u0002H80JJ&\u0010K\u001a\b\u0012\u0004\u0012\u0002H80?\"\b\b\u0000\u00108*\u00020L2\f\u0010M\u001a\b\u0012\u0004\u0012\u0002H80NH\u0007J$\u0010M\u001a\b\u0012\u0004\u0012\u0002H80?\"\b\b\u0000\u00108*\u00020L2\f\u0010M\u001a\b\u0012\u0004\u0012\u0002H80NR\u000e\u0010\u0019\u001a\u00020\u001aX\u0082\u0004¢\u0006\u0002\n\u0000R\u0018\u0010\u0018\u001a\u0004\u0018\u00010\u0015X\u0096\u0004¢\u0006\n\n\u0002\u0010\u001e\u001a\u0004\b\u001c\u0010\u001dR\u000e\u0010\u001f\u001a\u00020 X\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\"R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R\u0018\u0010\u0017\u001a\u0004\u0018\u00010\u0015X\u0096\u0004¢\u0006\n\n\u0002\u0010\u001e\u001a\u0004\b#\u0010\u001dR\u0014\u0010\f\u001a\u00020\rX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b$\u0010%R\u001c\u0010\u0012\u001a\n\u0012\u0004\u0012\u00020\u0013\u0018\u00010\nX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b&\u0010'R\u0016\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b(\u0010)R\u0017\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\n¢\u0006\b\n\u0000\u001a\u0004\b*\u0010'R\u000e\u0010+\u001a\u00020,X\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b-\u0010.R\u0018\u0010\u0014\u001a\u0004\u0018\u00010\u0015X\u0096\u0004¢\u0006\n\n\u0002\u0010\u001e\u001a\u0004\b/\u0010\u001dR\u0018\u0010\u0016\u001a\u0004\u0018\u00010\u0015X\u0096\u0004¢\u0006\n\n\u0002\u0010\u001e\u001a\u0004\b0\u0010\u001dR\u0011\u0010\b\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b1\u0010.¨\u0006Q"}, d2 = {"Lcom/apollographql/apollo3/ApolloClient;", "Lcom/apollographql/apollo3/api/ExecutionOptions;", "Ljava/io/Closeable;", "Lokio/Closeable;", "networkTransport", "Lcom/apollographql/apollo3/network/NetworkTransport;", "customScalarAdapters", "Lcom/apollographql/apollo3/api/CustomScalarAdapters;", "subscriptionNetworkTransport", "interceptors", "", "Lcom/apollographql/apollo3/interceptor/ApolloInterceptor;", "executionContext", "Lcom/apollographql/apollo3/api/ExecutionContext;", "dispatcher", "Lkotlinx/coroutines/CoroutineDispatcher;", "httpMethod", "Lcom/apollographql/apollo3/api/http/HttpMethod;", "httpHeaders", "Lcom/apollographql/apollo3/api/http/HttpHeader;", "sendApqExtensions", "", "sendDocument", "enableAutoPersistedQueries", "canBeBatched", "builder", "Lcom/apollographql/apollo3/ApolloClient$Builder;", "(Lcom/apollographql/apollo3/network/NetworkTransport;Lcom/apollographql/apollo3/api/CustomScalarAdapters;Lcom/apollographql/apollo3/network/NetworkTransport;Ljava/util/List;Lcom/apollographql/apollo3/api/ExecutionContext;Lkotlinx/coroutines/CoroutineDispatcher;Lcom/apollographql/apollo3/api/http/HttpMethod;Ljava/util/List;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;Lcom/apollographql/apollo3/ApolloClient$Builder;)V", "getCanBeBatched", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "concurrencyInfo", "Lcom/apollographql/apollo3/ConcurrencyInfo;", "getCustomScalarAdapters", "()Lcom/apollographql/apollo3/api/CustomScalarAdapters;", "getEnableAutoPersistedQueries", "getExecutionContext", "()Lcom/apollographql/apollo3/api/ExecutionContext;", "getHttpHeaders", "()Ljava/util/List;", "getHttpMethod", "()Lcom/apollographql/apollo3/api/http/HttpMethod;", "getInterceptors", "networkInterceptor", "Lcom/apollographql/apollo3/interceptor/NetworkInterceptor;", "getNetworkTransport", "()Lcom/apollographql/apollo3/network/NetworkTransport;", "getSendApqExtensions", "getSendDocument", "getSubscriptionNetworkTransport", HeaderElements.CLOSE, "", "dispose", "executeAsFlow", "Lkotlinx/coroutines/flow/Flow;", "Lcom/apollographql/apollo3/api/ApolloResponse;", "D", "Lcom/apollographql/apollo3/api/Operation$Data;", "apolloRequest", "Lcom/apollographql/apollo3/api/ApolloRequest;", "ignoreApolloClientHttpHeaders", "executeAsFlow$apollo_runtime", "mutate", "Lcom/apollographql/apollo3/ApolloCall;", "Lcom/apollographql/apollo3/api/Mutation$Data;", SemanticAttributes.GraphqlOperationTypeValues.MUTATION, "Lcom/apollographql/apollo3/api/Mutation;", "newBuilder", "prefetch", "", SerializedNames.OPERATION, "Lcom/apollographql/apollo3/api/Operation;", "query", "Lcom/apollographql/apollo3/api/Query$Data;", "Lcom/apollographql/apollo3/api/Query;", "subscribe", "Lcom/apollographql/apollo3/api/Subscription$Data;", SemanticAttributes.GraphqlOperationTypeValues.SUBSCRIPTION, "Lcom/apollographql/apollo3/api/Subscription;", "Builder", "Companion", "apollo-runtime"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class ApolloClient implements ExecutionOptions, Closeable {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final Builder builder;
    private final Boolean canBeBatched;
    private final ConcurrencyInfo concurrencyInfo;
    private final CustomScalarAdapters customScalarAdapters;
    private final CoroutineDispatcher dispatcher;
    private final Boolean enableAutoPersistedQueries;
    private final ExecutionContext executionContext;
    private final List<HttpHeader> httpHeaders;
    private final HttpMethod httpMethod;
    private final List<ApolloInterceptor> interceptors;
    private final NetworkInterceptor networkInterceptor;
    private final NetworkTransport networkTransport;
    private final Boolean sendApqExtensions;
    private final Boolean sendDocument;
    private final NetworkTransport subscriptionNetworkTransport;

    public /* synthetic */ ApolloClient(NetworkTransport networkTransport, CustomScalarAdapters customScalarAdapters, NetworkTransport networkTransport2, List list, ExecutionContext executionContext, CoroutineDispatcher coroutineDispatcher, HttpMethod httpMethod, List list2, Boolean bool, Boolean bool2, Boolean bool3, Boolean bool4, Builder builder, DefaultConstructorMarker defaultConstructorMarker) {
        this(networkTransport, customScalarAdapters, networkTransport2, list, executionContext, coroutineDispatcher, httpMethod, list2, bool, bool2, bool3, bool4, builder);
    }

    @Deprecated(message = "Used for backward compatibility with 2.x", replaceWith = @ReplaceWith(expression = "ApolloClient.Builder()", imports = {}))
    @JvmStatic
    public static final Builder builder() {
        return INSTANCE.builder();
    }

    /* JADX WARN: Multi-variable type inference failed */
    private ApolloClient(NetworkTransport networkTransport, CustomScalarAdapters customScalarAdapters, NetworkTransport networkTransport2, List<? extends ApolloInterceptor> list, ExecutionContext executionContext, CoroutineDispatcher coroutineDispatcher, HttpMethod httpMethod, List<HttpHeader> list2, Boolean bool, Boolean bool2, Boolean bool3, Boolean bool4, Builder builder) {
        this.networkTransport = networkTransport;
        this.customScalarAdapters = customScalarAdapters;
        this.subscriptionNetworkTransport = networkTransport2;
        this.interceptors = list;
        this.executionContext = executionContext;
        this.dispatcher = coroutineDispatcher;
        this.httpMethod = httpMethod;
        this.httpHeaders = list2;
        this.sendApqExtensions = bool;
        this.sendDocument = bool2;
        this.enableAutoPersistedQueries = bool3;
        this.canBeBatched = bool4;
        this.builder = builder;
        coroutineDispatcher = coroutineDispatcher == null ? DispatchersKt.getDefaultDispatcher() : coroutineDispatcher;
        ConcurrencyInfo concurrencyInfo = new ConcurrencyInfo(coroutineDispatcher, CoroutineScopeKt.CoroutineScope(coroutineDispatcher));
        this.concurrencyInfo = concurrencyInfo;
        this.networkInterceptor = new NetworkInterceptor(networkTransport, networkTransport2, concurrencyInfo.getDispatcher());
    }

    public final NetworkTransport getNetworkTransport() {
        return this.networkTransport;
    }

    public final CustomScalarAdapters getCustomScalarAdapters() {
        return this.customScalarAdapters;
    }

    public final NetworkTransport getSubscriptionNetworkTransport() {
        return this.subscriptionNetworkTransport;
    }

    public final List<ApolloInterceptor> getInterceptors() {
        return this.interceptors;
    }

    @Override // com.apollographql.apollo3.api.ExecutionOptions
    public ExecutionContext getExecutionContext() {
        return this.executionContext;
    }

    @Override // com.apollographql.apollo3.api.ExecutionOptions
    public HttpMethod getHttpMethod() {
        return this.httpMethod;
    }

    @Override // com.apollographql.apollo3.api.ExecutionOptions
    public List<HttpHeader> getHttpHeaders() {
        return this.httpHeaders;
    }

    @Override // com.apollographql.apollo3.api.ExecutionOptions
    public Boolean getSendApqExtensions() {
        return this.sendApqExtensions;
    }

    @Override // com.apollographql.apollo3.api.ExecutionOptions
    public Boolean getSendDocument() {
        return this.sendDocument;
    }

    @Override // com.apollographql.apollo3.api.ExecutionOptions
    public Boolean getEnableAutoPersistedQueries() {
        return this.enableAutoPersistedQueries;
    }

    @Override // com.apollographql.apollo3.api.ExecutionOptions
    public Boolean getCanBeBatched() {
        return this.canBeBatched;
    }

    public final <D extends Query.Data> ApolloCall<D> query(Query<D> query) {
        Intrinsics.checkNotNullParameter(query, "query");
        return new ApolloCall<>(this, query);
    }

    public final <D extends Mutation.Data> ApolloCall<D> mutation(Mutation<D> mutation) {
        Intrinsics.checkNotNullParameter(mutation, "mutation");
        return new ApolloCall<>(this, mutation);
    }

    @Deprecated(message = "Used for backward compatibility with 2.x", replaceWith = @ReplaceWith(expression = "mutation(mutation)", imports = {}))
    public final <D extends Mutation.Data> ApolloCall<D> mutate(Mutation<D> mutation) {
        Intrinsics.checkNotNullParameter(mutation, "mutation");
        return mutation(mutation);
    }

    public final <D extends Subscription.Data> ApolloCall<D> subscription(Subscription<D> subscription) {
        Intrinsics.checkNotNullParameter(subscription, "subscription");
        return new ApolloCall<>(this, subscription);
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "Use a query and ignore the result")
    public final <D extends Operation.Data> Void prefetch(Operation<D> operation) {
        Intrinsics.checkNotNullParameter(operation, "operation");
        throw new NotImplementedError(null, 1, null);
    }

    @Deprecated(message = "Used for backward compatibility with 2.x", replaceWith = @ReplaceWith(expression = "subscription(subscription)", imports = {}))
    public final <D extends Subscription.Data> ApolloCall<D> subscribe(Subscription<D> subscription) {
        Intrinsics.checkNotNullParameter(subscription, "subscription");
        return subscription(subscription);
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        CoroutineScopeKt.cancel$default(this.concurrencyInfo.getCoroutineScope(), null, 1, null);
        this.networkTransport.dispose();
        this.subscriptionNetworkTransport.dispose();
    }

    @Deprecated(message = "Use close() instead or call okio.use { }", replaceWith = @ReplaceWith(expression = "close()", imports = {}))
    public final void dispose() {
        close();
    }

    public final <D extends Operation.Data> Flow<ApolloResponse<D>> executeAsFlow(ApolloRequest<D> apolloRequest) {
        Intrinsics.checkNotNullParameter(apolloRequest, "apolloRequest");
        return executeAsFlow$apollo_runtime(apolloRequest, true);
    }

    public final <D extends Operation.Data> Flow<ApolloResponse<D>> executeAsFlow$apollo_runtime(ApolloRequest<D> apolloRequest, boolean ignoreApolloClientHttpHeaders) {
        List<HttpHeader> listPlus;
        Intrinsics.checkNotNullParameter(apolloRequest, "apolloRequest");
        ApolloRequest.Builder<D> builderEnableAutoPersistedQueries = new ApolloRequest.Builder(apolloRequest.getOperation()).addExecutionContext((ExecutionContext) this.concurrencyInfo).addExecutionContext((ExecutionContext) this.customScalarAdapters).addExecutionContext(this.concurrencyInfo.plus(this.customScalarAdapters).plus(getExecutionContext()).plus(apolloRequest.getExecutionContext())).addExecutionContext(apolloRequest.getExecutionContext()).httpMethod(getHttpMethod()).sendApqExtensions(getSendApqExtensions()).sendDocument(getSendDocument()).enableAutoPersistedQueries(getEnableAutoPersistedQueries());
        if (apolloRequest.getHttpHeaders() == null) {
            listPlus = getHttpHeaders();
        } else if (ignoreApolloClientHttpHeaders) {
            listPlus = apolloRequest.getHttpHeaders();
        } else {
            List<HttpHeader> httpHeaders = getHttpHeaders();
            if (httpHeaders == null) {
                httpHeaders = CollectionsKt.emptyList();
            }
            List<HttpHeader> httpHeaders2 = apolloRequest.getHttpHeaders();
            Intrinsics.checkNotNull(httpHeaders2);
            listPlus = CollectionsKt.plus((Collection) httpHeaders, (Iterable) httpHeaders2);
        }
        ApolloRequest.Builder<D> builderHttpHeaders = builderEnableAutoPersistedQueries.httpHeaders(listPlus);
        if (apolloRequest.getHttpMethod() != null) {
            builderHttpHeaders.httpMethod(apolloRequest.getHttpMethod());
        }
        if (apolloRequest.getSendApqExtensions() != null) {
            builderHttpHeaders.sendApqExtensions(apolloRequest.getSendApqExtensions());
        }
        if (apolloRequest.getSendDocument() != null) {
            builderHttpHeaders.sendDocument(apolloRequest.getSendDocument());
        }
        if (apolloRequest.getEnableAutoPersistedQueries() != null) {
            builderHttpHeaders.enableAutoPersistedQueries(apolloRequest.getEnableAutoPersistedQueries());
        }
        if (apolloRequest.getCanBeBatched() != null) {
            builderHttpHeaders.addHttpHeader("X-APOLLO-CAN-BE-BATCHED", String.valueOf(apolloRequest.getCanBeBatched()));
        }
        return new DefaultInterceptorChain(CollectionsKt.plus((Collection<? extends NetworkInterceptor>) this.interceptors, this.networkInterceptor), 0).proceed(builderHttpHeaders.build());
    }

    /* JADX INFO: compiled from: ApolloClient.kt */
    @Metadata(d1 = {"\u0000Æ\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u000b\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0005¢\u0006\u0002\u0010\u0002J\"\u0010O\u001a\u00020\u0000\"\u0004\b\u0000\u0010P2\u0006\u0010Q\u001a\u00020R2\f\u0010S\u001a\b\u0012\u0004\u0012\u0002HP0TJ$\u0010U\u001a\u00020\u0000\"\u0004\b\u0000\u0010P2\u0006\u0010Q\u001a\u00020R2\f\u0010V\u001a\b\u0012\u0004\u0012\u0002HP0WH\u0007J\u0010\u0010X\u001a\u00020\u00002\u0006\u0010\u0018\u001a\u00020\u0019H\u0016J\u0018\u0010Y\u001a\u00020\u00002\u0006\u0010I\u001a\u0002012\u0006\u0010Z\u001a\u000201H\u0016J\u000e\u0010[\u001a\u00020\u00002\u0006\u0010\\\u001a\u00020)J\u000e\u0010]\u001a\u00020\u00002\u0006\u0010^\u001a\u00020\u0005J\u0014\u0010_\u001a\u00020\u00002\f\u00102\u001a\b\u0012\u0004\u0012\u00020\u00050!J&\u0010`\u001a\u00020\u00002\b\b\u0002\u0010a\u001a\u00020*2\b\b\u0002\u0010b\u001a\u00020*2\b\b\u0002\u0010c\u001a\u00020\nH\u0007J\u0006\u0010d\u001a\u00020eJ\u0017\u0010\u000b\u001a\u00020\u00002\b\u0010\u000b\u001a\u0004\u0018\u00010\nH\u0016¢\u0006\u0002\u0010fJ\u0006\u0010g\u001a\u00020\u0000J\u000e\u0010h\u001a\u00020\u00002\u0006\u0010h\u001a\u00020iJ\u0010\u0010\u0013\u001a\u00020\u00002\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014J\u0017\u0010\u0015\u001a\u00020\u00002\b\u0010\u0015\u001a\u0004\u0018\u00010\nH\u0016¢\u0006\u0002\u0010fJ\u000e\u0010\u0018\u001a\u00020\u00002\u0006\u0010\u0018\u001a\u00020\u0019J&\u0010j\u001a\u00020\u00002\b\b\u0002\u0010k\u001a\u00020>2\b\b\u0002\u0010l\u001a\u00020m2\b\b\u0002\u0010c\u001a\u00020\nH\u0007J\u000e\u0010\u001e\u001a\u00020\u00002\u0006\u0010\u001e\u001a\u00020\u001fJ\u000e\u0010 \u001a\u00020\u00002\u0006\u0010 \u001a\u00020\nJ\u0018\u0010#\u001a\u00020\u00002\u000e\u0010#\u001a\n\u0012\u0004\u0012\u00020\"\u0018\u00010!H\u0016J\u0012\u0010+\u001a\u00020\u00002\b\u0010+\u001a\u0004\u0018\u00010*H\u0016J\u000e\u00100\u001a\u00020\u00002\u0006\u00100\u001a\u000201J\u0014\u00102\u001a\u00020\u00002\f\u00102\u001a\b\u0012\u0004\u0012\u00020\u00050!J\u000e\u0010n\u001a\u00020\u00002\u0006\u0010n\u001a\u00020\u0007J\u0012\u0010o\u001a\u00020\u00002\b\u0010o\u001a\u0004\u0018\u00010\u0014H\u0007J\u0017\u00104\u001a\u00020\u00002\b\u00104\u001a\u0004\u0018\u00010\nH\u0016¢\u0006\u0002\u0010fJ\u0017\u00107\u001a\u00020\u00002\b\u00107\u001a\u0004\u0018\u00010\nH\u0016¢\u0006\u0002\u0010fJ\u000e\u0010p\u001a\u00020\u00002\u0006\u0010p\u001a\u000201J\u000e\u0010:\u001a\u00020\u00002\u0006\u0010:\u001a\u00020\u0007J\u0010\u0010q\u001a\u00020\u00002\u0006\u0010r\u001a\u00020\nH\u0007J\u0010\u0010r\u001a\u00020\u00002\u0006\u0010r\u001a\u00020\nH\u0007J\u000e\u0010;\u001a\u00020\u00002\u0006\u0010;\u001a\u00020<J\u000e\u0010=\u001a\u00020\u00002\u0006\u0010=\u001a\u00020>J\u001e\u0010s\u001a\u00020\u00002\u0014\u0010t\u001a\u0010\u0012\u0004\u0012\u00020G\u0012\u0004\u0012\u00020\n\u0018\u00010AH\u0007JD\u0010E\u001a\u00020\u000027\u0010E\u001a3\b\u0001\u0012\u0004\u0012\u00020G\u0012\u0013\u0012\u00110>¢\u0006\f\bH\u0012\b\bI\u0012\u0004\b\b(J\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0B\u0012\u0006\u0012\u0004\u0018\u00010C0F¢\u0006\u0002\u0010uJ\u000e\u0010L\u001a\u00020\u00002\u0006\u0010L\u001a\u000201J)\u0010L\u001a\u00020\u00002\u001c\u0010L\u001a\u0018\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u0002010B\u0012\u0006\u0012\u0004\u0018\u00010C0A¢\u0006\u0002\u0010vJ\u000e\u0010w\u001a\u00020\u00002\u0006\u0010M\u001a\u00020NR\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R*\u0010\u000b\u001a\u0004\u0018\u00010\n2\b\u0010\t\u001a\u0004\u0018\u00010\n@WX\u0096\u000e¢\u0006\u0010\n\u0002\u0010\u0010\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u000e\u0010\u0011\u001a\u00020\u0012X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0013\u001a\u0004\u0018\u00010\u0014X\u0082\u000e¢\u0006\u0002\n\u0000R*\u0010\u0015\u001a\u0004\u0018\u00010\n2\b\u0010\t\u001a\u0004\u0018\u00010\n@WX\u0096\u000e¢\u0006\u0010\n\u0002\u0010\u0010\u001a\u0004\b\u0016\u0010\r\"\u0004\b\u0017\u0010\u000fR\u001a\u0010\u0018\u001a\u00020\u0019X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR\u0010\u0010\u001e\u001a\u0004\u0018\u00010\u001fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0012\u0010 \u001a\u0004\u0018\u00010\nX\u0082\u000e¢\u0006\u0004\n\u0002\u0010\u0010R4\u0010#\u001a\n\u0012\u0004\u0012\u00020\"\u0018\u00010!2\u000e\u0010\t\u001a\n\u0012\u0004\u0012\u00020\"\u0018\u00010!@WX\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b$\u0010%\"\u0004\b&\u0010'R\u0014\u0010(\u001a\b\u0012\u0004\u0012\u00020)0\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R(\u0010+\u001a\u0004\u0018\u00010*2\b\u0010\t\u001a\u0004\u0018\u00010*@WX\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b,\u0010-\"\u0004\b.\u0010/R\u0010\u00100\u001a\u0004\u0018\u000101X\u0082\u000e¢\u0006\u0002\n\u0000R\u0017\u00102\u001a\b\u0012\u0004\u0012\u00020\u00050!¢\u0006\b\n\u0000\u001a\u0004\b3\u0010%R*\u00104\u001a\u0004\u0018\u00010\n2\b\u0010\t\u001a\u0004\u0018\u00010\n@WX\u0096\u000e¢\u0006\u0010\n\u0002\u0010\u0010\u001a\u0004\b5\u0010\r\"\u0004\b6\u0010\u000fR*\u00107\u001a\u0004\u0018\u00010\n2\b\u0010\t\u001a\u0004\u0018\u00010\n@WX\u0096\u000e¢\u0006\u0010\n\u0002\u0010\u0010\u001a\u0004\b8\u0010\r\"\u0004\b9\u0010\u000fR\u0010\u0010:\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010;\u001a\u0004\u0018\u00010<X\u0082\u000e¢\u0006\u0002\n\u0000R\u0012\u0010=\u001a\u0004\u0018\u00010>X\u0082\u000e¢\u0006\u0004\n\u0002\u0010?R(\u0010@\u001a\u001a\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u0002010B\u0012\u0006\u0012\u0004\u0018\u00010C\u0018\u00010AX\u0082\u000e¢\u0006\u0004\n\u0002\u0010DRC\u0010E\u001a5\b\u0001\u0012\u0004\u0012\u00020G\u0012\u0013\u0012\u00110>¢\u0006\f\bH\u0012\b\bI\u0012\u0004\b\b(J\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0B\u0012\u0006\u0012\u0004\u0018\u00010C\u0018\u00010FX\u0082\u000e¢\u0006\u0004\n\u0002\u0010KR\u0010\u0010L\u001a\u0004\u0018\u000101X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010M\u001a\u0004\u0018\u00010NX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006x"}, d2 = {"Lcom/apollographql/apollo3/ApolloClient$Builder;", "Lcom/apollographql/apollo3/api/MutableExecutionOptions;", "()V", "_interceptors", "", "Lcom/apollographql/apollo3/interceptor/ApolloInterceptor;", "_networkTransport", "Lcom/apollographql/apollo3/network/NetworkTransport;", "apqInterceptor", "<set-?>", "", "canBeBatched", "getCanBeBatched", "()Ljava/lang/Boolean;", "setCanBeBatched", "(Ljava/lang/Boolean;)V", "Ljava/lang/Boolean;", "customScalarAdaptersBuilder", "Lcom/apollographql/apollo3/api/CustomScalarAdapters$Builder;", "dispatcher", "Lkotlinx/coroutines/CoroutineDispatcher;", "enableAutoPersistedQueries", "getEnableAutoPersistedQueries", "setEnableAutoPersistedQueries", "executionContext", "Lcom/apollographql/apollo3/api/ExecutionContext;", "getExecutionContext", "()Lcom/apollographql/apollo3/api/ExecutionContext;", "setExecutionContext", "(Lcom/apollographql/apollo3/api/ExecutionContext;)V", "httpEngine", "Lcom/apollographql/apollo3/network/http/HttpEngine;", "httpExposeErrorBody", "", "Lcom/apollographql/apollo3/api/http/HttpHeader;", "httpHeaders", "getHttpHeaders", "()Ljava/util/List;", "setHttpHeaders", "(Ljava/util/List;)V", "httpInterceptors", "Lcom/apollographql/apollo3/network/http/HttpInterceptor;", "Lcom/apollographql/apollo3/api/http/HttpMethod;", "httpMethod", "getHttpMethod", "()Lcom/apollographql/apollo3/api/http/HttpMethod;", "setHttpMethod", "(Lcom/apollographql/apollo3/api/http/HttpMethod;)V", "httpServerUrl", "", "interceptors", "getInterceptors", "sendApqExtensions", "getSendApqExtensions", "setSendApqExtensions", "sendDocument", "getSendDocument", "setSendDocument", "subscriptionNetworkTransport", "webSocketEngine", "Lcom/apollographql/apollo3/network/ws/WebSocketEngine;", "webSocketIdleTimeoutMillis", "", "Ljava/lang/Long;", "webSocketReopenServerUrl", "Lkotlin/Function1;", "Lkotlin/coroutines/Continuation;", "", "Lkotlin/jvm/functions/Function1;", "webSocketReopenWhen", "Lkotlin/Function3;", "", "Lkotlin/ParameterName;", "name", "attempt", "Lkotlin/jvm/functions/Function3;", "webSocketServerUrl", "wsProtocolFactory", "Lcom/apollographql/apollo3/network/ws/WsProtocol$Factory;", "addCustomScalarAdapter", ExifInterface.GPS_DIRECTION_TRUE, "customScalarType", "Lcom/apollographql/apollo3/api/CustomScalarType;", "customScalarAdapter", "Lcom/apollographql/apollo3/api/Adapter;", "addCustomTypeAdapter", "customTypeAdapter", "Lcom/apollographql/apollo3/api/CustomTypeAdapter;", "addExecutionContext", "addHttpHeader", "value", "addHttpInterceptor", "httpInterceptor", "addInterceptor", "interceptor", "addInterceptors", "autoPersistedQueries", "httpMethodForHashedQueries", "httpMethodForDocumentQueries", "enableByDefault", "build", "Lcom/apollographql/apollo3/ApolloClient;", "(Ljava/lang/Boolean;)Lcom/apollographql/apollo3/ApolloClient$Builder;", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "customScalarAdapters", "Lcom/apollographql/apollo3/api/CustomScalarAdapters;", "httpBatching", "batchIntervalMillis", "maxBatchSize", "", "networkTransport", "requestedDispatcher", "serverUrl", "useHttpGetMethodForPersistedQueries", "useHttpGetMethodForQueries", "webSocketReconnectWhen", "reconnectWhen", "(Lkotlin/jvm/functions/Function3;)Lcom/apollographql/apollo3/ApolloClient$Builder;", "(Lkotlin/jvm/functions/Function1;)Lcom/apollographql/apollo3/ApolloClient$Builder;", "wsProtocol", "apollo-runtime"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class Builder implements MutableExecutionOptions<Builder> {
        private final List<ApolloInterceptor> _interceptors;
        private NetworkTransport _networkTransport;
        private ApolloInterceptor apqInterceptor;
        private Boolean canBeBatched;
        private final CustomScalarAdapters.Builder customScalarAdaptersBuilder = new CustomScalarAdapters.Builder();
        private CoroutineDispatcher dispatcher;
        private Boolean enableAutoPersistedQueries;
        private ExecutionContext executionContext;
        private HttpEngine httpEngine;
        private Boolean httpExposeErrorBody;
        private List<HttpHeader> httpHeaders;
        private final List<HttpInterceptor> httpInterceptors;
        private HttpMethod httpMethod;
        private String httpServerUrl;
        private final List<ApolloInterceptor> interceptors;
        private Boolean sendApqExtensions;
        private Boolean sendDocument;
        private NetworkTransport subscriptionNetworkTransport;
        private WebSocketEngine webSocketEngine;
        private Long webSocketIdleTimeoutMillis;
        private Function1<? super Continuation<? super String>, ? extends Object> webSocketReopenServerUrl;
        private Function3<? super Throwable, ? super Long, ? super Continuation<? super Boolean>, ? extends Object> webSocketReopenWhen;
        private String webSocketServerUrl;
        private WsProtocol.Factory wsProtocolFactory;

        public final Builder autoPersistedQueries() {
            return autoPersistedQueries$default(this, null, null, false, 7, null);
        }

        public final Builder autoPersistedQueries(HttpMethod httpMethodForHashedQueries) {
            Intrinsics.checkNotNullParameter(httpMethodForHashedQueries, "httpMethodForHashedQueries");
            return autoPersistedQueries$default(this, httpMethodForHashedQueries, null, false, 6, null);
        }

        public final Builder autoPersistedQueries(HttpMethod httpMethodForHashedQueries, HttpMethod httpMethodForDocumentQueries) {
            Intrinsics.checkNotNullParameter(httpMethodForHashedQueries, "httpMethodForHashedQueries");
            Intrinsics.checkNotNullParameter(httpMethodForDocumentQueries, "httpMethodForDocumentQueries");
            return autoPersistedQueries$default(this, httpMethodForHashedQueries, httpMethodForDocumentQueries, false, 4, null);
        }

        public final Builder httpBatching() {
            return httpBatching$default(this, 0L, 0, false, 7, null);
        }

        public final Builder httpBatching(long j) {
            return httpBatching$default(this, j, 0, false, 6, null);
        }

        public final Builder httpBatching(long j, int i) {
            return httpBatching$default(this, j, i, false, 4, null);
        }

        public Builder() {
            ArrayList arrayList = new ArrayList();
            this._interceptors = arrayList;
            this.interceptors = arrayList;
            this.httpInterceptors = new ArrayList();
            this.executionContext = ExecutionContext.Empty;
            DispatchersKt.failOnNativeIfLegacyMemoryManager();
        }

        @Override // com.apollographql.apollo3.api.MutableExecutionOptions
        public /* bridge */ /* synthetic */ Builder httpHeaders(List list) {
            return httpHeaders((List<HttpHeader>) list);
        }

        public final List<ApolloInterceptor> getInterceptors() {
            return this.interceptors;
        }

        @Override // com.apollographql.apollo3.api.ExecutionOptions
        public ExecutionContext getExecutionContext() {
            return this.executionContext;
        }

        public void setExecutionContext(ExecutionContext executionContext) {
            Intrinsics.checkNotNullParameter(executionContext, "<set-?>");
            this.executionContext = executionContext;
        }

        @Override // com.apollographql.apollo3.api.ExecutionOptions
        public HttpMethod getHttpMethod() {
            return this.httpMethod;
        }

        @Deprecated(message = "Use httpMethod() instead")
        public void setHttpMethod(HttpMethod httpMethod) {
            this.httpMethod = httpMethod;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.apollographql.apollo3.api.MutableExecutionOptions
        public Builder httpMethod(HttpMethod httpMethod) {
            setHttpMethod(httpMethod);
            return this;
        }

        @Override // com.apollographql.apollo3.api.ExecutionOptions
        public List<HttpHeader> getHttpHeaders() {
            return this.httpHeaders;
        }

        @Deprecated(message = "Use httpHeaders() instead")
        public void setHttpHeaders(List<HttpHeader> list) {
            this.httpHeaders = list;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.apollographql.apollo3.api.MutableExecutionOptions
        public Builder httpHeaders(List<HttpHeader> httpHeaders) {
            setHttpHeaders(httpHeaders);
            return this;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.apollographql.apollo3.api.MutableExecutionOptions
        public Builder addHttpHeader(String name, String value) {
            Intrinsics.checkNotNullParameter(name, "name");
            Intrinsics.checkNotNullParameter(value, "value");
            List<HttpHeader> httpHeaders = getHttpHeaders();
            if (httpHeaders == null) {
                httpHeaders = CollectionsKt.emptyList();
            }
            setHttpHeaders(CollectionsKt.plus((Collection<? extends HttpHeader>) httpHeaders, new HttpHeader(name, value)));
            return this;
        }

        @Override // com.apollographql.apollo3.api.ExecutionOptions
        public Boolean getSendApqExtensions() {
            return this.sendApqExtensions;
        }

        @Deprecated(message = "Use sendApqExtensions() instead")
        public void setSendApqExtensions(Boolean bool) {
            this.sendApqExtensions = bool;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.apollographql.apollo3.api.MutableExecutionOptions
        public Builder sendApqExtensions(Boolean sendApqExtensions) {
            setSendApqExtensions(sendApqExtensions);
            return this;
        }

        @Override // com.apollographql.apollo3.api.ExecutionOptions
        public Boolean getSendDocument() {
            return this.sendDocument;
        }

        @Deprecated(message = "Use sendDocument() instead")
        public void setSendDocument(Boolean bool) {
            this.sendDocument = bool;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.apollographql.apollo3.api.MutableExecutionOptions
        public Builder sendDocument(Boolean sendDocument) {
            setSendDocument(sendDocument);
            return this;
        }

        @Override // com.apollographql.apollo3.api.ExecutionOptions
        public Boolean getEnableAutoPersistedQueries() {
            return this.enableAutoPersistedQueries;
        }

        @Deprecated(message = "Use enableAutoPersistedQueries() instead")
        public void setEnableAutoPersistedQueries(Boolean bool) {
            this.enableAutoPersistedQueries = bool;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.apollographql.apollo3.api.MutableExecutionOptions
        public Builder enableAutoPersistedQueries(Boolean enableAutoPersistedQueries) {
            setEnableAutoPersistedQueries(enableAutoPersistedQueries);
            return this;
        }

        @Override // com.apollographql.apollo3.api.ExecutionOptions
        public Boolean getCanBeBatched() {
            return this.canBeBatched;
        }

        @Deprecated(message = "Use canBeBatched() instead")
        public void setCanBeBatched(Boolean bool) {
            this.canBeBatched = bool;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.apollographql.apollo3.api.MutableExecutionOptions
        public Builder canBeBatched(Boolean canBeBatched) {
            setCanBeBatched(canBeBatched);
            return this;
        }

        public final Builder serverUrl(String serverUrl) {
            Intrinsics.checkNotNullParameter(serverUrl, "serverUrl");
            this.httpServerUrl = serverUrl;
            return this;
        }

        public final Builder httpServerUrl(String httpServerUrl) {
            Intrinsics.checkNotNullParameter(httpServerUrl, "httpServerUrl");
            this.httpServerUrl = httpServerUrl;
            return this;
        }

        public final Builder httpEngine(HttpEngine httpEngine) {
            Intrinsics.checkNotNullParameter(httpEngine, "httpEngine");
            this.httpEngine = httpEngine;
            return this;
        }

        public final Builder httpExposeErrorBody(boolean httpExposeErrorBody) {
            this.httpExposeErrorBody = Boolean.valueOf(httpExposeErrorBody);
            return this;
        }

        public final Builder addHttpInterceptor(HttpInterceptor httpInterceptor) {
            Intrinsics.checkNotNullParameter(httpInterceptor, "httpInterceptor");
            this.httpInterceptors.add(httpInterceptor);
            return this;
        }

        public final Builder webSocketServerUrl(String webSocketServerUrl) {
            Intrinsics.checkNotNullParameter(webSocketServerUrl, "webSocketServerUrl");
            this.webSocketServerUrl = webSocketServerUrl;
            return this;
        }

        public final Builder webSocketServerUrl(Function1<? super Continuation<? super String>, ? extends Object> webSocketServerUrl) {
            Intrinsics.checkNotNullParameter(webSocketServerUrl, "webSocketServerUrl");
            this.webSocketReopenServerUrl = webSocketServerUrl;
            return this;
        }

        public final Builder webSocketIdleTimeoutMillis(long webSocketIdleTimeoutMillis) {
            this.webSocketIdleTimeoutMillis = Long.valueOf(webSocketIdleTimeoutMillis);
            return this;
        }

        public final Builder wsProtocol(WsProtocol.Factory wsProtocolFactory) {
            Intrinsics.checkNotNullParameter(wsProtocolFactory, "wsProtocolFactory");
            this.wsProtocolFactory = wsProtocolFactory;
            return this;
        }

        public final Builder webSocketEngine(WebSocketEngine webSocketEngine) {
            Intrinsics.checkNotNullParameter(webSocketEngine, "webSocketEngine");
            this.webSocketEngine = webSocketEngine;
            return this;
        }

        public final Builder webSocketReopenWhen(Function3<? super Throwable, ? super Long, ? super Continuation<? super Boolean>, ? extends Object> webSocketReopenWhen) {
            Intrinsics.checkNotNullParameter(webSocketReopenWhen, "webSocketReopenWhen");
            this.webSocketReopenWhen = webSocketReopenWhen;
            return this;
        }

        @Deprecated(message = "Use webSocketReopenWhen(webSocketReopenWhen: (suspend (Throwable, attempt: Long) -> Boolean))")
        public final Builder webSocketReconnectWhen(Function1<? super Throwable, Boolean> reconnectWhen) {
            this.webSocketReopenWhen = reconnectWhen != null ? new ApolloClient$Builder$webSocketReconnectWhen$1$1$adaptedLambda$1(reconnectWhen, null) : null;
            return this;
        }

        public final Builder networkTransport(NetworkTransport networkTransport) {
            Intrinsics.checkNotNullParameter(networkTransport, "networkTransport");
            this._networkTransport = networkTransport;
            return this;
        }

        public final Builder subscriptionNetworkTransport(NetworkTransport subscriptionNetworkTransport) {
            Intrinsics.checkNotNullParameter(subscriptionNetworkTransport, "subscriptionNetworkTransport");
            this.subscriptionNetworkTransport = subscriptionNetworkTransport;
            return this;
        }

        public final Builder customScalarAdapters(CustomScalarAdapters customScalarAdapters) {
            Intrinsics.checkNotNullParameter(customScalarAdapters, "customScalarAdapters");
            this.customScalarAdaptersBuilder.clear();
            this.customScalarAdaptersBuilder.addAll(customScalarAdapters);
            return this;
        }

        public final <T> Builder addCustomScalarAdapter(CustomScalarType customScalarType, Adapter<T> customScalarAdapter) {
            Intrinsics.checkNotNullParameter(customScalarType, "customScalarType");
            Intrinsics.checkNotNullParameter(customScalarAdapter, "customScalarAdapter");
            this.customScalarAdaptersBuilder.add(customScalarType, customScalarAdapter);
            return this;
        }

        @Deprecated(message = "Used for backward compatibility with 2.x", replaceWith = @ReplaceWith(expression = "addCustomScalarAdapter", imports = {}))
        public final <T> Builder addCustomTypeAdapter(CustomScalarType customScalarType, CustomTypeAdapter<T> customTypeAdapter) {
            Intrinsics.checkNotNullParameter(customScalarType, "customScalarType");
            Intrinsics.checkNotNullParameter(customTypeAdapter, "customTypeAdapter");
            return addCustomScalarAdapter(customScalarType, new Version2CustomTypeAdapterToAdapter(customTypeAdapter));
        }

        public final Builder addInterceptor(ApolloInterceptor interceptor) {
            Intrinsics.checkNotNullParameter(interceptor, "interceptor");
            this._interceptors.add(interceptor);
            return this;
        }

        public final Builder addInterceptors(List<? extends ApolloInterceptor> interceptors) {
            Intrinsics.checkNotNullParameter(interceptors, "interceptors");
            CollectionsKt.addAll(this._interceptors, interceptors);
            return this;
        }

        public final Builder interceptors(List<? extends ApolloInterceptor> interceptors) {
            Intrinsics.checkNotNullParameter(interceptors, "interceptors");
            this._interceptors.clear();
            CollectionsKt.addAll(this._interceptors, interceptors);
            return this;
        }

        @Deprecated(message = "Use dispatcher instead", replaceWith = @ReplaceWith(expression = "dispatcher(requestedDispatcher)", imports = {}))
        public final Builder requestedDispatcher(CoroutineDispatcher requestedDispatcher) {
            dispatcher(requestedDispatcher);
            return this;
        }

        public final Builder dispatcher(CoroutineDispatcher dispatcher) {
            this.dispatcher = dispatcher;
            return this;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.apollographql.apollo3.api.MutableExecutionOptions
        public Builder addExecutionContext(ExecutionContext executionContext) {
            Intrinsics.checkNotNullParameter(executionContext, "executionContext");
            setExecutionContext(getExecutionContext().plus(executionContext));
            return this;
        }

        public final Builder executionContext(ExecutionContext executionContext) {
            Intrinsics.checkNotNullParameter(executionContext, "executionContext");
            setExecutionContext(executionContext);
            return this;
        }

        public static /* synthetic */ Builder autoPersistedQueries$default(Builder builder, HttpMethod httpMethod, HttpMethod httpMethod2, boolean z, int i, Object obj) {
            if ((i & 1) != 0) {
                httpMethod = HttpMethod.Get;
            }
            if ((i & 2) != 0) {
                httpMethod2 = HttpMethod.Post;
            }
            if ((i & 4) != 0) {
                z = true;
            }
            return builder.autoPersistedQueries(httpMethod, httpMethod2, z);
        }

        public final Builder autoPersistedQueries(HttpMethod httpMethodForHashedQueries, HttpMethod httpMethodForDocumentQueries, boolean enableByDefault) {
            Intrinsics.checkNotNullParameter(httpMethodForHashedQueries, "httpMethodForHashedQueries");
            Intrinsics.checkNotNullParameter(httpMethodForDocumentQueries, "httpMethodForDocumentQueries");
            this.apqInterceptor = new AutoPersistedQueryInterceptor(httpMethodForHashedQueries, httpMethodForDocumentQueries);
            enableAutoPersistedQueries(Boolean.valueOf(enableByDefault));
            return this;
        }

        public static /* synthetic */ Builder httpBatching$default(Builder builder, long j, int i, boolean z, int i2, Object obj) {
            if ((i2 & 1) != 0) {
                j = 10;
            }
            if ((i2 & 2) != 0) {
                i = 10;
            }
            if ((i2 & 4) != 0) {
                z = true;
            }
            return builder.httpBatching(j, i, z);
        }

        public final Builder httpBatching(long batchIntervalMillis, int maxBatchSize, boolean enableByDefault) {
            addHttpInterceptor(new BatchingHttpInterceptor(batchIntervalMillis, maxBatchSize, false, 4, null));
            canBeBatched(Boolean.valueOf(enableByDefault));
            return this;
        }

        @Deprecated(message = "Used for backward compatibility with 2.x", replaceWith = @ReplaceWith(expression = "httpMethod(HttpMethod.Get)", imports = {"com.apollographql.apollo3.api.http.httpMethod", "com.apollographql.apollo3.api.http.HttpMethod"}))
        public final Builder useHttpGetMethodForQueries(boolean useHttpGetMethodForQueries) {
            return httpMethod(useHttpGetMethodForQueries ? HttpMethod.Get : HttpMethod.Post);
        }

        @Deprecated(message = "Used for backward compatibility with 2.x. This method throws immediately", replaceWith = @ReplaceWith(expression = "autoPersistedQueries(httpMethodForHashedQueries = HttpMethod.Get)", imports = {"com.apollographql.apollo3.api.http.HttpMethod", "com.apollographql.apollo3.api.http.HttpMethod"}))
        public final Builder useHttpGetMethodForPersistedQueries(boolean useHttpGetMethodForQueries) {
            throw new NotImplementedError("useHttpGetMethodForPersistedQueries is now configured at the same time as auto persisted queries. Use autoPersistedQueries(httpMethodForHashedQueries = HttpMethod.GET) instead.");
        }

        public final ApolloClient build() {
            HttpNetworkTransport httpNetworkTransportBuild;
            NetworkTransport networkTransport;
            if (this._networkTransport != null) {
                if (this.httpServerUrl != null) {
                    throw new IllegalStateException("Apollo: 'httpServerUrl' has no effect if 'networkTransport' is set".toString());
                }
                if (this.httpEngine != null) {
                    throw new IllegalStateException("Apollo: 'httpEngine' has no effect if 'networkTransport' is set".toString());
                }
                if (!this.httpInterceptors.isEmpty()) {
                    throw new IllegalStateException("Apollo: 'addHttpInterceptor' has no effect if 'networkTransport' is set".toString());
                }
                if (this.httpExposeErrorBody != null) {
                    throw new IllegalStateException("Apollo: 'httpExposeErrorBody' has no effect if 'networkTransport' is set".toString());
                }
                httpNetworkTransportBuild = this._networkTransport;
                Intrinsics.checkNotNull(httpNetworkTransportBuild);
            } else {
                if (this.httpServerUrl == null) {
                    throw new IllegalStateException("Apollo: 'serverUrl' is required".toString());
                }
                HttpNetworkTransport.Builder builder = new HttpNetworkTransport.Builder();
                String str = this.httpServerUrl;
                Intrinsics.checkNotNull(str);
                HttpNetworkTransport.Builder builderServerUrl = builder.serverUrl(str);
                HttpEngine httpEngine = this.httpEngine;
                if (httpEngine != null) {
                    Intrinsics.checkNotNull(httpEngine);
                    builderServerUrl.httpEngine(httpEngine);
                }
                Boolean bool = this.httpExposeErrorBody;
                if (bool != null) {
                    Intrinsics.checkNotNull(bool);
                    builderServerUrl.exposeErrorBody(bool.booleanValue());
                }
                httpNetworkTransportBuild = builderServerUrl.interceptors(this.httpInterceptors).build();
            }
            NetworkTransport networkTransport2 = httpNetworkTransportBuild;
            WebSocketNetworkTransport webSocketNetworkTransportBuild = this.subscriptionNetworkTransport;
            if (webSocketNetworkTransportBuild != null) {
                if (this.webSocketServerUrl != null) {
                    throw new IllegalStateException("Apollo: 'webSocketServerUrl' has no effect if 'subscriptionNetworkTransport' is set".toString());
                }
                if (this.webSocketEngine != null) {
                    throw new IllegalStateException("Apollo: 'webSocketEngine' has no effect if 'subscriptionNetworkTransport' is set".toString());
                }
                if (this.webSocketIdleTimeoutMillis != null) {
                    throw new IllegalStateException("Apollo: 'webSocketIdleTimeoutMillis' has no effect if 'subscriptionNetworkTransport' is set".toString());
                }
                if (this.wsProtocolFactory != null) {
                    throw new IllegalStateException("Apollo: 'wsProtocolFactory' has no effect if 'subscriptionNetworkTransport' is set".toString());
                }
                if (this.webSocketReopenWhen != null) {
                    throw new IllegalStateException("Apollo: 'webSocketReopenWhen' has no effect if 'subscriptionNetworkTransport' is set".toString());
                }
                if (this.webSocketReopenServerUrl != null) {
                    throw new IllegalStateException("Apollo: 'webSocketReopenServerUrl' has no effect if 'subscriptionNetworkTransport' is set".toString());
                }
                Intrinsics.checkNotNull(webSocketNetworkTransportBuild);
            } else {
                String str2 = this.webSocketServerUrl;
                if (str2 == null) {
                    str2 = this.httpServerUrl;
                }
                if (str2 == null) {
                    networkTransport = networkTransport2;
                } else {
                    WebSocketNetworkTransport.Builder builderServerUrl2 = new WebSocketNetworkTransport.Builder().serverUrl(str2);
                    WebSocketEngine webSocketEngine = this.webSocketEngine;
                    if (webSocketEngine != null) {
                        Intrinsics.checkNotNull(webSocketEngine);
                        builderServerUrl2.webSocketEngine(webSocketEngine);
                    }
                    Long l = this.webSocketIdleTimeoutMillis;
                    if (l != null) {
                        Intrinsics.checkNotNull(l);
                        builderServerUrl2.idleTimeoutMillis(l.longValue());
                    }
                    WsProtocol.Factory factory = this.wsProtocolFactory;
                    if (factory != null) {
                        Intrinsics.checkNotNull(factory);
                        builderServerUrl2.protocol(factory);
                    }
                    Function3<? super Throwable, ? super Long, ? super Continuation<? super Boolean>, ? extends Object> function3 = this.webSocketReopenWhen;
                    if (function3 != null) {
                        builderServerUrl2.reopenWhen(function3);
                    }
                    Function1<? super Continuation<? super String>, ? extends Object> function1 = this.webSocketReopenServerUrl;
                    if (function1 != null) {
                        builderServerUrl2.serverUrl(function1);
                    }
                    webSocketNetworkTransportBuild = builderServerUrl2.build();
                }
                return new ApolloClient(networkTransport2, this.customScalarAdaptersBuilder.build(), networkTransport, CollectionsKt.plus((Collection) this._interceptors, (Iterable) CollectionsKt.listOfNotNull(this.apqInterceptor)), getExecutionContext(), this.dispatcher, getHttpMethod(), getHttpHeaders(), getSendApqExtensions(), getSendDocument(), getEnableAutoPersistedQueries(), getCanBeBatched(), this, null);
            }
            networkTransport = webSocketNetworkTransportBuild;
            return new ApolloClient(networkTransport2, this.customScalarAdaptersBuilder.build(), networkTransport, CollectionsKt.plus((Collection) this._interceptors, (Iterable) CollectionsKt.listOfNotNull(this.apqInterceptor)), getExecutionContext(), this.dispatcher, getHttpMethod(), getHttpHeaders(), getSendApqExtensions(), getSendDocument(), getEnableAutoPersistedQueries(), getCanBeBatched(), this, null);
        }

        public final Builder copy() {
            Builder builderCanBeBatched = new Builder().customScalarAdapters(this.customScalarAdaptersBuilder.build()).interceptors(this.interceptors).dispatcher(this.dispatcher).executionContext(getExecutionContext()).httpMethod(getHttpMethod()).httpHeaders(getHttpHeaders()).sendApqExtensions(getSendApqExtensions()).sendDocument(getSendDocument()).enableAutoPersistedQueries(getEnableAutoPersistedQueries()).canBeBatched(getCanBeBatched());
            NetworkTransport networkTransport = this._networkTransport;
            if (networkTransport != null) {
                builderCanBeBatched.networkTransport(networkTransport);
            }
            String str = this.httpServerUrl;
            if (str != null) {
                builderCanBeBatched.httpServerUrl(str);
            }
            HttpEngine httpEngine = this.httpEngine;
            if (httpEngine != null) {
                builderCanBeBatched.httpEngine(httpEngine);
            }
            Boolean bool = this.httpExposeErrorBody;
            if (bool != null) {
                builderCanBeBatched.httpExposeErrorBody(bool.booleanValue());
            }
            Iterator<HttpInterceptor> it = this.httpInterceptors.iterator();
            while (it.hasNext()) {
                builderCanBeBatched.addHttpInterceptor(it.next());
            }
            NetworkTransport networkTransport2 = this.subscriptionNetworkTransport;
            if (networkTransport2 != null) {
                builderCanBeBatched.subscriptionNetworkTransport(networkTransport2);
            }
            String str2 = this.webSocketServerUrl;
            if (str2 != null) {
                builderCanBeBatched.webSocketServerUrl(str2);
            }
            Function1<? super Continuation<? super String>, ? extends Object> function1 = this.webSocketReopenServerUrl;
            if (function1 != null) {
                builderCanBeBatched.webSocketServerUrl(function1);
            }
            WebSocketEngine webSocketEngine = this.webSocketEngine;
            if (webSocketEngine != null) {
                builderCanBeBatched.webSocketEngine(webSocketEngine);
            }
            Function3<? super Throwable, ? super Long, ? super Continuation<? super Boolean>, ? extends Object> function3 = this.webSocketReopenWhen;
            if (function3 != null) {
                builderCanBeBatched.webSocketReopenWhen(function3);
            }
            Long l = this.webSocketIdleTimeoutMillis;
            if (l != null) {
                builderCanBeBatched.webSocketIdleTimeoutMillis(l.longValue());
            }
            WsProtocol.Factory factory = this.wsProtocolFactory;
            if (factory != null) {
                builderCanBeBatched.wsProtocol(factory);
            }
            return builderCanBeBatched;
        }
    }

    public final Builder newBuilder() {
        return this.builder.copy();
    }

    /* JADX INFO: compiled from: ApolloClient.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0007¨\u0006\u0005"}, d2 = {"Lcom/apollographql/apollo3/ApolloClient$Companion;", "", "()V", "builder", "Lcom/apollographql/apollo3/ApolloClient$Builder;", "apollo-runtime"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @Deprecated(message = "Used for backward compatibility with 2.x", replaceWith = @ReplaceWith(expression = "ApolloClient.Builder()", imports = {}))
        @JvmStatic
        public final Builder builder() {
            return new Builder();
        }
    }
}
