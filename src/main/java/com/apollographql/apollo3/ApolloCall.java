package com.apollographql.apollo3;

import com.apollographql.apollo3.api.ApolloRequest;
import com.apollographql.apollo3.api.ApolloResponse;
import com.apollographql.apollo3.api.ExecutionContext;
import com.apollographql.apollo3.api.MutableExecutionOptions;
import com.apollographql.apollo3.api.Operation;
import com.apollographql.apollo3.api.Operation.Data;
import com.apollographql.apollo3.api.http.HttpHeader;
import com.apollographql.apollo3.api.http.HttpMethod;
import com.box.android.domain.analytics.BoxAmplitudeAnalytics;
import com.microsoft.identity.common.internal.broker.SerializedNames;
import java.util.Collection;
import java.util.List;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowKt;

/* JADX INFO: compiled from: ApolloCall.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u00022\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00010\u00000\u0003B\u001d\b\u0000\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00028\u00000\u0007¢\u0006\u0002\u0010\bJ\u0016\u00102\u001a\b\u0012\u0004\u0012\u00028\u00000\u00002\u0006\u0010\u0017\u001a\u00020\u0016H\u0016J\u001e\u00103\u001a\b\u0012\u0004\u0012\u00028\u00000\u00002\u0006\u00104\u001a\u0002052\u0006\u00106\u001a\u000205H\u0016J\u001d\u0010\r\u001a\b\u0012\u0004\u0012\u00028\u00000\u00002\b\u0010\r\u001a\u0004\u0018\u00010\fH\u0016¢\u0006\u0002\u00107J\f\u00108\u001a\b\u0012\u0004\u0012\u00028\u00000\u0000J\u001d\u0010\u0013\u001a\b\u0012\u0004\u0012\u00028\u00000\u00002\b\u0010\u0013\u001a\u0004\u0018\u00010\fH\u0016¢\u0006\u0002\u00107J\u0014\u00109\u001a\b\u0012\u0004\u0012\u00028\u00000:H\u0086@¢\u0006\u0002\u0010;J\u001e\u0010\u001e\u001a\b\u0012\u0004\u0012\u00028\u00000\u00002\u000e\u0010\u001e\u001a\n\u0012\u0004\u0012\u00020\u001d\u0018\u00010\u001cH\u0016J\u0018\u0010$\u001a\b\u0012\u0004\u0012\u00028\u00000\u00002\b\u0010$\u001a\u0004\u0018\u00010#H\u0016J\u001d\u0010)\u001a\b\u0012\u0004\u0012\u00028\u00000\u00002\b\u0010)\u001a\u0004\u0018\u00010\fH\u0002¢\u0006\u0002\u00107J\u001d\u0010,\u001a\b\u0012\u0004\u0012\u00028\u00000\u00002\b\u0010,\u001a\u0004\u0018\u00010\fH\u0016¢\u0006\u0002\u00107J\u001d\u0010/\u001a\b\u0012\u0004\u0012\u00028\u00000\u00002\b\u0010/\u001a\u0004\u0018\u00010\fH\u0016¢\u0006\u0002\u00107J\u0012\u0010<\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000:0=R\u0014\u0010\u0004\u001a\u00020\u0005X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR*\u0010\r\u001a\u0004\u0018\u00010\f2\b\u0010\u000b\u001a\u0004\u0018\u00010\f@WX\u0096\u000e¢\u0006\u0010\n\u0002\u0010\u0012\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R*\u0010\u0013\u001a\u0004\u0018\u00010\f2\b\u0010\u000b\u001a\u0004\u0018\u00010\f@WX\u0096\u000e¢\u0006\u0010\n\u0002\u0010\u0012\u001a\u0004\b\u0014\u0010\u000f\"\u0004\b\u0015\u0010\u0011R$\u0010\u0017\u001a\u00020\u00162\u0006\u0010\u000b\u001a\u00020\u0016@WX\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR4\u0010\u001e\u001a\n\u0012\u0004\u0012\u00020\u001d\u0018\u00010\u001c2\u000e\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\u001d\u0018\u00010\u001c@WX\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010 \"\u0004\b!\u0010\"R(\u0010$\u001a\u0004\u0018\u00010#2\b\u0010\u000b\u001a\u0004\u0018\u00010#@WX\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b%\u0010&\"\u0004\b'\u0010(R\u0012\u0010)\u001a\u0004\u0018\u00010\fX\u0082\u000e¢\u0006\u0004\n\u0002\u0010\u0012R\u0017\u0010\u0006\u001a\b\u0012\u0004\u0012\u00028\u00000\u0007¢\u0006\b\n\u0000\u001a\u0004\b*\u0010+R*\u0010,\u001a\u0004\u0018\u00010\f2\b\u0010\u000b\u001a\u0004\u0018\u00010\f@WX\u0096\u000e¢\u0006\u0010\n\u0002\u0010\u0012\u001a\u0004\b-\u0010\u000f\"\u0004\b.\u0010\u0011R*\u0010/\u001a\u0004\u0018\u00010\f2\b\u0010\u000b\u001a\u0004\u0018\u00010\f@WX\u0096\u000e¢\u0006\u0010\n\u0002\u0010\u0012\u001a\u0004\b0\u0010\u000f\"\u0004\b1\u0010\u0011¨\u0006>"}, d2 = {"Lcom/apollographql/apollo3/ApolloCall;", "D", "Lcom/apollographql/apollo3/api/Operation$Data;", "Lcom/apollographql/apollo3/api/MutableExecutionOptions;", "apolloClient", "Lcom/apollographql/apollo3/ApolloClient;", SerializedNames.OPERATION, "Lcom/apollographql/apollo3/api/Operation;", "(Lcom/apollographql/apollo3/ApolloClient;Lcom/apollographql/apollo3/api/Operation;)V", "getApolloClient$apollo_runtime", "()Lcom/apollographql/apollo3/ApolloClient;", "<set-?>", "", "canBeBatched", "getCanBeBatched", "()Ljava/lang/Boolean;", "setCanBeBatched", "(Ljava/lang/Boolean;)V", "Ljava/lang/Boolean;", "enableAutoPersistedQueries", "getEnableAutoPersistedQueries", "setEnableAutoPersistedQueries", "Lcom/apollographql/apollo3/api/ExecutionContext;", "executionContext", "getExecutionContext", "()Lcom/apollographql/apollo3/api/ExecutionContext;", "setExecutionContext", "(Lcom/apollographql/apollo3/api/ExecutionContext;)V", "", "Lcom/apollographql/apollo3/api/http/HttpHeader;", "httpHeaders", "getHttpHeaders", "()Ljava/util/List;", "setHttpHeaders", "(Ljava/util/List;)V", "Lcom/apollographql/apollo3/api/http/HttpMethod;", "httpMethod", "getHttpMethod", "()Lcom/apollographql/apollo3/api/http/HttpMethod;", "setHttpMethod", "(Lcom/apollographql/apollo3/api/http/HttpMethod;)V", "ignoreApolloClientHttpHeaders", "getOperation", "()Lcom/apollographql/apollo3/api/Operation;", "sendApqExtensions", "getSendApqExtensions", "setSendApqExtensions", "sendDocument", "getSendDocument", "setSendDocument", "addExecutionContext", "addHttpHeader", "name", "", "value", "(Ljava/lang/Boolean;)Lcom/apollographql/apollo3/ApolloCall;", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "execute", "Lcom/apollographql/apollo3/api/ApolloResponse;", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "toFlow", "Lkotlinx/coroutines/flow/Flow;", "apollo-runtime"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class ApolloCall<D extends Operation.Data> implements MutableExecutionOptions<ApolloCall<D>> {
    private final ApolloClient apolloClient;
    private Boolean canBeBatched;
    private Boolean enableAutoPersistedQueries;
    private ExecutionContext executionContext;
    private List<HttpHeader> httpHeaders;
    private HttpMethod httpMethod;
    private Boolean ignoreApolloClientHttpHeaders;
    private final Operation<D> operation;
    private Boolean sendApqExtensions;
    private Boolean sendDocument;

    public ApolloCall(ApolloClient apolloClient, Operation<D> operation) {
        Intrinsics.checkNotNullParameter(apolloClient, "apolloClient");
        Intrinsics.checkNotNullParameter(operation, "operation");
        this.apolloClient = apolloClient;
        this.operation = operation;
        this.executionContext = ExecutionContext.Empty;
    }

    @Override // com.apollographql.apollo3.api.MutableExecutionOptions
    public /* bridge */ /* synthetic */ Object httpHeaders(List list) {
        return httpHeaders((List<HttpHeader>) list);
    }

    /* JADX INFO: renamed from: getApolloClient$apollo_runtime, reason: from getter */
    public final ApolloClient getApolloClient() {
        return this.apolloClient;
    }

    public final Operation<D> getOperation() {
        return this.operation;
    }

    @Override // com.apollographql.apollo3.api.ExecutionOptions
    public ExecutionContext getExecutionContext() {
        return this.executionContext;
    }

    @Deprecated(message = "Use addExecutionContext() instead")
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

    @Override // com.apollographql.apollo3.api.ExecutionOptions
    public Boolean getSendApqExtensions() {
        return this.sendApqExtensions;
    }

    @Deprecated(message = "Use sendApqExtensions() instead")
    public void setSendApqExtensions(Boolean bool) {
        this.sendApqExtensions = bool;
    }

    @Override // com.apollographql.apollo3.api.ExecutionOptions
    public Boolean getSendDocument() {
        return this.sendDocument;
    }

    @Deprecated(message = "Use sendDocument() instead")
    public void setSendDocument(Boolean bool) {
        this.sendDocument = bool;
    }

    @Override // com.apollographql.apollo3.api.ExecutionOptions
    public Boolean getEnableAutoPersistedQueries() {
        return this.enableAutoPersistedQueries;
    }

    @Deprecated(message = "Use enableAutoPersistedQueries() instead")
    public void setEnableAutoPersistedQueries(Boolean bool) {
        this.enableAutoPersistedQueries = bool;
    }

    @Override // com.apollographql.apollo3.api.ExecutionOptions
    public List<HttpHeader> getHttpHeaders() {
        return this.httpHeaders;
    }

    @Deprecated(message = "Use httpHeaders() instead")
    public void setHttpHeaders(List<HttpHeader> list) {
        this.httpHeaders = list;
    }

    @Override // com.apollographql.apollo3.api.MutableExecutionOptions
    public ApolloCall<D> addExecutionContext(ExecutionContext executionContext) {
        Intrinsics.checkNotNullParameter(executionContext, "executionContext");
        setExecutionContext(getExecutionContext().plus(executionContext));
        return this;
    }

    @Override // com.apollographql.apollo3.api.MutableExecutionOptions
    public ApolloCall<D> httpMethod(HttpMethod httpMethod) {
        setHttpMethod(httpMethod);
        return this;
    }

    @Override // com.apollographql.apollo3.api.MutableExecutionOptions
    public ApolloCall<D> httpHeaders(List<HttpHeader> httpHeaders) {
        if (this.ignoreApolloClientHttpHeaders != null) {
            throw new IllegalStateException("Apollo: it is an error to call both .headers() and .addHeader() or .additionalHeaders() at the same time".toString());
        }
        setHttpHeaders(httpHeaders);
        return this;
    }

    @Override // com.apollographql.apollo3.api.MutableExecutionOptions
    public ApolloCall<D> addHttpHeader(String name, String value) {
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(value, "value");
        if (getHttpHeaders() != null && !Intrinsics.areEqual((Object) this.ignoreApolloClientHttpHeaders, (Object) false)) {
            throw new IllegalStateException("Apollo: it is an error to call both .headers() and .addHeader() or .additionalHeaders() at the same time".toString());
        }
        this.ignoreApolloClientHttpHeaders = false;
        List<HttpHeader> httpHeaders = getHttpHeaders();
        if (httpHeaders == null) {
            httpHeaders = CollectionsKt.emptyList();
        }
        setHttpHeaders(CollectionsKt.plus((Collection<? extends HttpHeader>) httpHeaders, new HttpHeader(name, value)));
        return this;
    }

    @Override // com.apollographql.apollo3.api.MutableExecutionOptions
    public ApolloCall<D> sendApqExtensions(Boolean sendApqExtensions) {
        setSendApqExtensions(sendApqExtensions);
        return this;
    }

    @Override // com.apollographql.apollo3.api.MutableExecutionOptions
    public ApolloCall<D> sendDocument(Boolean sendDocument) {
        setSendDocument(sendDocument);
        return this;
    }

    @Override // com.apollographql.apollo3.api.MutableExecutionOptions
    public ApolloCall<D> enableAutoPersistedQueries(Boolean enableAutoPersistedQueries) {
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

    @Override // com.apollographql.apollo3.api.MutableExecutionOptions
    public ApolloCall<D> canBeBatched(Boolean canBeBatched) {
        setCanBeBatched(canBeBatched);
        return this;
    }

    private final ApolloCall<D> ignoreApolloClientHttpHeaders(Boolean ignoreApolloClientHttpHeaders) {
        this.ignoreApolloClientHttpHeaders = ignoreApolloClientHttpHeaders;
        return this;
    }

    public final ApolloCall<D> copy() {
        return new ApolloCall(this.apolloClient, this.operation).addExecutionContext(getExecutionContext()).httpMethod(getHttpMethod()).httpHeaders(getHttpHeaders()).ignoreApolloClientHttpHeaders(this.ignoreApolloClientHttpHeaders).sendApqExtensions(getSendApqExtensions()).sendDocument(getSendDocument()).enableAutoPersistedQueries(getEnableAutoPersistedQueries()).canBeBatched(getCanBeBatched());
    }

    public final Flow<ApolloResponse<D>> toFlow() {
        ApolloRequest<D> apolloRequestBuild = new ApolloRequest.Builder(this.operation).executionContext(getExecutionContext()).httpMethod(getHttpMethod()).httpHeaders(getHttpHeaders()).sendApqExtensions(getSendApqExtensions()).sendDocument(getSendDocument()).enableAutoPersistedQueries(getEnableAutoPersistedQueries()).canBeBatched(getCanBeBatched()).build();
        ApolloClient apolloClient = this.apolloClient;
        Boolean bool = this.ignoreApolloClientHttpHeaders;
        boolean z = true;
        if (bool != null && !Intrinsics.areEqual((Object) bool, (Object) true)) {
            z = false;
        }
        return apolloClient.executeAsFlow$apollo_runtime(apolloRequestBuild, z);
    }

    public final Object execute(Continuation<? super ApolloResponse<D>> continuation) {
        return FlowKt.single(toFlow(), continuation);
    }
}
