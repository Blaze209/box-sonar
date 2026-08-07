package com.apollographql.apollo3.api;

import androidx.exifinterface.media.ExifInterface;
import com.apollographql.apollo3.api.Operation.Data;
import com.apollographql.apollo3.api.http.HttpHeader;
import com.apollographql.apollo3.api.http.HttpMethod;
import com.microsoft.identity.common.internal.broker.SerializedNames;
import java.util.Collection;
import java.util.List;
import java.util.UUID;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: ApolloRequest.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0015\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u00022\u00020\u0003:\u0001)Bk\b\u0002\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0005\u0012\n\u0010\u0006\u001a\u00060\u0007j\u0002`\b\u0012\u0006\u0010\t\u001a\u00020\n\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\f\u0012\u000e\u0010\r\u001a\n\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u000e\u0012\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011\u0012\b\u0010\u0012\u001a\u0004\u0018\u00010\u0011\u0012\b\u0010\u0013\u001a\u0004\u0018\u00010\u0011\u0012\b\u0010\u0014\u001a\u0004\u0018\u00010\u0011¢\u0006\u0002\u0010\u0015J\f\u0010&\u001a\b\u0012\u0004\u0012\u00028\u00000'J&\u0010&\u001a\b\u0012\u0004\u0012\u0002H(0'\"\b\b\u0001\u0010(*\u00020\u00022\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u0002H(0\u0005H\u0007R\u0018\u0010\u0014\u001a\u0004\u0018\u00010\u0011X\u0096\u0004¢\u0006\n\n\u0002\u0010\u0018\u001a\u0004\b\u0016\u0010\u0017R\u0018\u0010\u0013\u001a\u0004\u0018\u00010\u0011X\u0096\u0004¢\u0006\n\n\u0002\u0010\u0018\u001a\u0004\b\u0019\u0010\u0017R\u0014\u0010\t\u001a\u00020\nX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u001bR\u001c\u0010\r\u001a\n\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u000eX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001dR\u0016\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001fR\u0017\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0005¢\u0006\b\n\u0000\u001a\u0004\b \u0010!R\u0015\u0010\u0006\u001a\u00060\u0007j\u0002`\b¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010#R\u0018\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u0096\u0004¢\u0006\n\n\u0002\u0010\u0018\u001a\u0004\b$\u0010\u0017R\u0018\u0010\u0012\u001a\u0004\u0018\u00010\u0011X\u0096\u0004¢\u0006\n\n\u0002\u0010\u0018\u001a\u0004\b%\u0010\u0017¨\u0006*"}, d2 = {"Lcom/apollographql/apollo3/api/ApolloRequest;", "D", "Lcom/apollographql/apollo3/api/Operation$Data;", "Lcom/apollographql/apollo3/api/ExecutionOptions;", SerializedNames.OPERATION, "Lcom/apollographql/apollo3/api/Operation;", "requestUuid", "Ljava/util/UUID;", "Lcom/benasher44/uuid/Uuid;", "executionContext", "Lcom/apollographql/apollo3/api/ExecutionContext;", "httpMethod", "Lcom/apollographql/apollo3/api/http/HttpMethod;", "httpHeaders", "", "Lcom/apollographql/apollo3/api/http/HttpHeader;", "sendApqExtensions", "", "sendDocument", "enableAutoPersistedQueries", "canBeBatched", "(Lcom/apollographql/apollo3/api/Operation;Ljava/util/UUID;Lcom/apollographql/apollo3/api/ExecutionContext;Lcom/apollographql/apollo3/api/http/HttpMethod;Ljava/util/List;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;)V", "getCanBeBatched", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "getEnableAutoPersistedQueries", "getExecutionContext", "()Lcom/apollographql/apollo3/api/ExecutionContext;", "getHttpHeaders", "()Ljava/util/List;", "getHttpMethod", "()Lcom/apollographql/apollo3/api/http/HttpMethod;", "getOperation", "()Lcom/apollographql/apollo3/api/Operation;", "getRequestUuid", "()Ljava/util/UUID;", "getSendApqExtensions", "getSendDocument", "newBuilder", "Lcom/apollographql/apollo3/api/ApolloRequest$Builder;", ExifInterface.LONGITUDE_EAST, "Builder", "apollo-api"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class ApolloRequest<D extends Operation.Data> implements ExecutionOptions {
    private final Boolean canBeBatched;
    private final Boolean enableAutoPersistedQueries;
    private final ExecutionContext executionContext;
    private final List<HttpHeader> httpHeaders;
    private final HttpMethod httpMethod;
    private final Operation<D> operation;
    private final UUID requestUuid;
    private final Boolean sendApqExtensions;
    private final Boolean sendDocument;

    public /* synthetic */ ApolloRequest(Operation operation, UUID uuid, ExecutionContext executionContext, HttpMethod httpMethod, List list, Boolean bool, Boolean bool2, Boolean bool3, Boolean bool4, DefaultConstructorMarker defaultConstructorMarker) {
        this(operation, uuid, executionContext, httpMethod, list, bool, bool2, bool3, bool4);
    }

    private ApolloRequest(Operation<D> operation, UUID uuid, ExecutionContext executionContext, HttpMethod httpMethod, List<HttpHeader> list, Boolean bool, Boolean bool2, Boolean bool3, Boolean bool4) {
        this.operation = operation;
        this.requestUuid = uuid;
        this.executionContext = executionContext;
        this.httpMethod = httpMethod;
        this.httpHeaders = list;
        this.sendApqExtensions = bool;
        this.sendDocument = bool2;
        this.enableAutoPersistedQueries = bool3;
        this.canBeBatched = bool4;
    }

    public final Operation<D> getOperation() {
        return this.operation;
    }

    public final UUID getRequestUuid() {
        return this.requestUuid;
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

    public final Builder<D> newBuilder() {
        return (Builder<D>) newBuilder(this.operation);
    }

    public final <E extends Operation.Data> Builder<E> newBuilder(Operation<E> operation) {
        Intrinsics.checkNotNullParameter(operation, "operation");
        return new Builder(operation).requestUuid(this.requestUuid).executionContext(getExecutionContext()).httpMethod(getHttpMethod()).httpHeaders(getHttpHeaders()).sendApqExtensions(getSendApqExtensions()).sendDocument(getSendDocument()).enableAutoPersistedQueries(getEnableAutoPersistedQueries()).canBeBatched(getCanBeBatched());
    }

    /* JADX INFO: compiled from: ApolloRequest.kt */
    @Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000*\b\b\u0001\u0010\u0001*\u00020\u00022\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00010\u00000\u0003B\u0013\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00010\u0005¢\u0006\u0002\u0010\u0006J\u0016\u0010.\u001a\b\u0012\u0004\u0012\u00028\u00010\u00002\u0006\u0010\u0013\u001a\u00020\u0012H\u0016J\u001e\u0010/\u001a\b\u0012\u0004\u0012\u00028\u00010\u00002\u0006\u00100\u001a\u0002012\u0006\u00102\u001a\u000201H\u0016J\f\u00103\u001a\b\u0012\u0004\u0012\u00028\u000104J\u001d\u0010\t\u001a\b\u0012\u0004\u0012\u00028\u00010\u00002\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0016¢\u0006\u0002\u00105J\u001d\u0010\u000f\u001a\b\u0012\u0004\u0012\u00028\u00010\u00002\b\u0010\u000f\u001a\u0004\u0018\u00010\bH\u0016¢\u0006\u0002\u00105J\u0014\u0010\u0013\u001a\b\u0012\u0004\u0012\u00028\u00010\u00002\u0006\u0010\u0013\u001a\u00020\u0012J\u001e\u0010\u001a\u001a\b\u0012\u0004\u0012\u00028\u00010\u00002\u000e\u0010\u001a\u001a\n\u0012\u0004\u0012\u00020\u0019\u0018\u00010\u0018H\u0016J\u0018\u0010 \u001a\b\u0012\u0004\u0012\u00028\u00010\u00002\b\u0010 \u001a\u0004\u0018\u00010\u001fH\u0016J\u0018\u0010%\u001a\b\u0012\u0004\u0012\u00028\u00010\u00002\n\u0010%\u001a\u00060&j\u0002`'J\u001d\u0010(\u001a\b\u0012\u0004\u0012\u00028\u00010\u00002\b\u0010(\u001a\u0004\u0018\u00010\bH\u0016¢\u0006\u0002\u00105J\u001d\u0010+\u001a\b\u0012\u0004\u0012\u00028\u00010\u00002\b\u0010+\u001a\u0004\u0018\u00010\bH\u0016¢\u0006\u0002\u00105R*\u0010\t\u001a\u0004\u0018\u00010\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\b@WX\u0096\u000e¢\u0006\u0010\n\u0002\u0010\u000e\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR*\u0010\u000f\u001a\u0004\u0018\u00010\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\b@WX\u0096\u000e¢\u0006\u0010\n\u0002\u0010\u000e\u001a\u0004\b\u0010\u0010\u000b\"\u0004\b\u0011\u0010\rR$\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0007\u001a\u00020\u0012@WX\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R4\u0010\u001a\u001a\n\u0012\u0004\u0012\u00020\u0019\u0018\u00010\u00182\u000e\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\u0019\u0018\u00010\u0018@WX\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001eR(\u0010 \u001a\u0004\u0018\u00010\u001f2\b\u0010\u0007\u001a\u0004\u0018\u00010\u001f@WX\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b!\u0010\"\"\u0004\b#\u0010$R\u0014\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u0012\u0010%\u001a\u00060&j\u0002`'X\u0082\u000e¢\u0006\u0002\n\u0000R*\u0010(\u001a\u0004\u0018\u00010\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\b@WX\u0096\u000e¢\u0006\u0010\n\u0002\u0010\u000e\u001a\u0004\b)\u0010\u000b\"\u0004\b*\u0010\rR*\u0010+\u001a\u0004\u0018\u00010\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\b@WX\u0096\u000e¢\u0006\u0010\n\u0002\u0010\u000e\u001a\u0004\b,\u0010\u000b\"\u0004\b-\u0010\r¨\u00066"}, d2 = {"Lcom/apollographql/apollo3/api/ApolloRequest$Builder;", "D", "Lcom/apollographql/apollo3/api/Operation$Data;", "Lcom/apollographql/apollo3/api/MutableExecutionOptions;", SerializedNames.OPERATION, "Lcom/apollographql/apollo3/api/Operation;", "(Lcom/apollographql/apollo3/api/Operation;)V", "<set-?>", "", "canBeBatched", "getCanBeBatched", "()Ljava/lang/Boolean;", "setCanBeBatched", "(Ljava/lang/Boolean;)V", "Ljava/lang/Boolean;", "enableAutoPersistedQueries", "getEnableAutoPersistedQueries", "setEnableAutoPersistedQueries", "Lcom/apollographql/apollo3/api/ExecutionContext;", "executionContext", "getExecutionContext", "()Lcom/apollographql/apollo3/api/ExecutionContext;", "setExecutionContext", "(Lcom/apollographql/apollo3/api/ExecutionContext;)V", "", "Lcom/apollographql/apollo3/api/http/HttpHeader;", "httpHeaders", "getHttpHeaders", "()Ljava/util/List;", "setHttpHeaders", "(Ljava/util/List;)V", "Lcom/apollographql/apollo3/api/http/HttpMethod;", "httpMethod", "getHttpMethod", "()Lcom/apollographql/apollo3/api/http/HttpMethod;", "setHttpMethod", "(Lcom/apollographql/apollo3/api/http/HttpMethod;)V", "requestUuid", "Ljava/util/UUID;", "Lcom/benasher44/uuid/Uuid;", "sendApqExtensions", "getSendApqExtensions", "setSendApqExtensions", "sendDocument", "getSendDocument", "setSendDocument", "addExecutionContext", "addHttpHeader", "name", "", "value", "build", "Lcom/apollographql/apollo3/api/ApolloRequest;", "(Ljava/lang/Boolean;)Lcom/apollographql/apollo3/api/ApolloRequest$Builder;", "apollo-api"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class Builder<D extends Operation.Data> implements MutableExecutionOptions<Builder<D>> {
        private Boolean canBeBatched;
        private Boolean enableAutoPersistedQueries;
        private ExecutionContext executionContext;
        private List<HttpHeader> httpHeaders;
        private HttpMethod httpMethod;
        private Operation<D> operation;
        private UUID requestUuid;
        private Boolean sendApqExtensions;
        private Boolean sendDocument;

        public Builder(Operation<D> operation) {
            Intrinsics.checkNotNullParameter(operation, "operation");
            this.operation = operation;
            UUID uuidRandomUUID = UUID.randomUUID();
            Intrinsics.checkNotNullExpressionValue(uuidRandomUUID, "randomUUID()");
            this.requestUuid = uuidRandomUUID;
            this.executionContext = ExecutionContext.Empty;
        }

        @Override // com.apollographql.apollo3.api.MutableExecutionOptions
        public /* bridge */ /* synthetic */ Object httpHeaders(List list) {
            return httpHeaders((List<HttpHeader>) list);
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

        @Override // com.apollographql.apollo3.api.MutableExecutionOptions
        public Builder<D> httpMethod(HttpMethod httpMethod) {
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

        @Override // com.apollographql.apollo3.api.MutableExecutionOptions
        public Builder<D> httpHeaders(List<HttpHeader> httpHeaders) {
            setHttpHeaders(httpHeaders);
            return this;
        }

        @Override // com.apollographql.apollo3.api.MutableExecutionOptions
        public Builder<D> addHttpHeader(String name, String value) {
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

        @Override // com.apollographql.apollo3.api.MutableExecutionOptions
        public Builder<D> sendApqExtensions(Boolean sendApqExtensions) {
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

        @Override // com.apollographql.apollo3.api.MutableExecutionOptions
        public Builder<D> sendDocument(Boolean sendDocument) {
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

        @Override // com.apollographql.apollo3.api.MutableExecutionOptions
        public Builder<D> enableAutoPersistedQueries(Boolean enableAutoPersistedQueries) {
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
        public Builder<D> canBeBatched(Boolean canBeBatched) {
            setCanBeBatched(canBeBatched);
            return this;
        }

        public final Builder<D> requestUuid(UUID requestUuid) {
            Intrinsics.checkNotNullParameter(requestUuid, "requestUuid");
            this.requestUuid = requestUuid;
            return this;
        }

        public final Builder<D> executionContext(ExecutionContext executionContext) {
            Intrinsics.checkNotNullParameter(executionContext, "executionContext");
            setExecutionContext(executionContext);
            return this;
        }

        @Override // com.apollographql.apollo3.api.MutableExecutionOptions
        public Builder<D> addExecutionContext(ExecutionContext executionContext) {
            Intrinsics.checkNotNullParameter(executionContext, "executionContext");
            setExecutionContext(getExecutionContext().plus(executionContext));
            return this;
        }

        public final ApolloRequest<D> build() {
            return new ApolloRequest<>(this.operation, this.requestUuid, getExecutionContext(), getHttpMethod(), getHttpHeaders(), getSendApqExtensions(), getSendDocument(), getEnableAutoPersistedQueries(), getCanBeBatched(), null);
        }
    }
}
