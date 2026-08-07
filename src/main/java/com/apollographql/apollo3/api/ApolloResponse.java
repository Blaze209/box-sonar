package com.apollographql.apollo3.api;

import com.apollographql.apollo3.api.Operation.Data;
import com.apollographql.apollo3.exception.ApolloException;
import com.box.android.domain.analytics.BoxAnalyticsParams;
import com.microsoft.identity.common.internal.broker.SerializedNames;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import kotlin.Metadata;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: ApolloResponse.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u00022\u00020\u0003:\u0001\u001bBa\b\u0002\u0012\n\u0010\u0004\u001a\u00060\u0005j\u0002`\u0006\u0012\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00028\u00000\b\u0012\b\u0010\t\u001a\u0004\u0018\u00018\u0000\u0012\u000e\u0010\n\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u000b\u0012\u0014\u0010\r\u001a\u0010\u0012\u0004\u0012\u00020\u000f\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u000e\u0012\u0006\u0010\u0010\u001a\u00020\u0011\u0012\u0006\u0010\u0012\u001a\u00020\u0013¢\u0006\u0002\u0010\u0014J\u0006\u0010\u0018\u001a\u00020\u0013J\f\u0010\u0019\u001a\b\u0012\u0004\u0012\u00028\u00000\u001aR\u0014\u0010\t\u001a\u0004\u0018\u00018\u00008\u0006X\u0087\u0004¢\u0006\u0004\n\u0002\u0010\u0015R\u0011\u0010\u0016\u001a\u00028\u00008G¢\u0006\u0006\u001a\u0004\b\u0016\u0010\u0017R\u0018\u0010\n\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u000b8\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0010\u001a\u00020\u00118\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u001e\u0010\r\u001a\u0010\u0012\u0004\u0012\u00020\u000f\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u000e8\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0012\u001a\u00020\u00138\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0007\u001a\b\u0012\u0004\u0012\u00028\u00000\b8\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0004\u001a\u00060\u0005j\u0002`\u00068\u0006X\u0087\u0004¢\u0006\u0002\n\u0000¨\u0006\u001c"}, d2 = {"Lcom/apollographql/apollo3/api/ApolloResponse;", "D", "Lcom/apollographql/apollo3/api/Operation$Data;", "", "requestUuid", "Ljava/util/UUID;", "Lcom/benasher44/uuid/Uuid;", SerializedNames.OPERATION, "Lcom/apollographql/apollo3/api/Operation;", "data", BoxAnalyticsParams.CATEGORY_ERRORS, "", "Lcom/apollographql/apollo3/api/Error;", "extensions", "", "", "executionContext", "Lcom/apollographql/apollo3/api/ExecutionContext;", "isLast", "", "(Ljava/util/UUID;Lcom/apollographql/apollo3/api/Operation;Lcom/apollographql/apollo3/api/Operation$Data;Ljava/util/List;Ljava/util/Map;Lcom/apollographql/apollo3/api/ExecutionContext;Z)V", "Lcom/apollographql/apollo3/api/Operation$Data;", "dataAssertNoErrors", "()Lcom/apollographql/apollo3/api/Operation$Data;", "hasErrors", "newBuilder", "Lcom/apollographql/apollo3/api/ApolloResponse$Builder;", "Builder", "apollo-api"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class ApolloResponse<D extends Operation.Data> {
    public final D data;
    public final List<Error> errors;
    public final ExecutionContext executionContext;
    public final Map<String, Object> extensions;
    public final boolean isLast;
    public final Operation<D> operation;
    public final UUID requestUuid;

    public /* synthetic */ ApolloResponse(UUID uuid, Operation operation, Operation.Data data, List list, Map map, ExecutionContext executionContext, boolean z, DefaultConstructorMarker defaultConstructorMarker) {
        this(uuid, operation, data, list, map, executionContext, z);
    }

    private ApolloResponse(UUID uuid, Operation<D> operation, D d, List<Error> list, Map<String, ? extends Object> map, ExecutionContext executionContext, boolean z) {
        this.requestUuid = uuid;
        this.operation = operation;
        this.data = d;
        this.errors = list;
        this.extensions = map;
        this.executionContext = executionContext;
        this.isLast = z;
    }

    public final D dataAssertNoErrors() {
        if (hasErrors()) {
            throw new ApolloException("The response has errors: " + this.errors, null, 2, null);
        }
        D d = this.data;
        if (d != null) {
            return d;
        }
        throw new ApolloException("The server did not return any data", null, 2, null);
    }

    public final boolean hasErrors() {
        List<Error> list = this.errors;
        return !(list == null || list.isEmpty());
    }

    public final Builder<D> newBuilder() {
        return new Builder(this.operation, this.requestUuid, this.data).errors(this.errors).extensions(this.extensions).addExecutionContext(this.executionContext).isLast(this.isLast);
    }

    /* JADX INFO: compiled from: ApolloResponse.kt */
    @Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u0000*\b\b\u0001\u0010\u0001*\u00020\u00022\u00020\u0003B)\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00010\u0005\u0012\n\u0010\u0006\u001a\u00060\u0007j\u0002`\b\u0012\b\u0010\t\u001a\u0004\u0018\u00018\u0001¢\u0006\u0002\u0010\nJ\u0014\u0010\u0016\u001a\b\u0012\u0004\u0012\u00028\u00010\u00002\u0006\u0010\u000f\u001a\u00020\u0010J\f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00028\u00010\u0018J\u001c\u0010\f\u001a\b\u0012\u0004\u0012\u00028\u00010\u00002\u000e\u0010\f\u001a\n\u0012\u0004\u0012\u00020\u000e\u0018\u00010\rJ$\u0010\u0011\u001a\b\u0012\u0004\u0012\u00028\u00010\u00002\u0016\u0010\u0011\u001a\u0012\u0012\u0004\u0012\u00020\u0013\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0018\u00010\u0012J\u0014\u0010\u0014\u001a\b\u0012\u0004\u0012\u00028\u00010\u00002\u0006\u0010\u0014\u001a\u00020\u0015J\u0018\u0010\u0006\u001a\b\u0012\u0004\u0012\u00028\u00010\u00002\n\u0010\u0006\u001a\u00060\u0007j\u0002`\bR\u0012\u0010\t\u001a\u0004\u0018\u00018\u0001X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u000bR\u0016\u0010\f\u001a\n\u0012\u0004\u0012\u00020\u000e\u0018\u00010\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u001e\u0010\u0011\u001a\u0012\u0012\u0004\u0012\u00020\u0013\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0018\u00010\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0015X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00010\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0012\u0010\u0006\u001a\u00060\u0007j\u0002`\bX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0019"}, d2 = {"Lcom/apollographql/apollo3/api/ApolloResponse$Builder;", "D", "Lcom/apollographql/apollo3/api/Operation$Data;", "", SerializedNames.OPERATION, "Lcom/apollographql/apollo3/api/Operation;", "requestUuid", "Ljava/util/UUID;", "Lcom/benasher44/uuid/Uuid;", "data", "(Lcom/apollographql/apollo3/api/Operation;Ljava/util/UUID;Lcom/apollographql/apollo3/api/Operation$Data;)V", "Lcom/apollographql/apollo3/api/Operation$Data;", BoxAnalyticsParams.CATEGORY_ERRORS, "", "Lcom/apollographql/apollo3/api/Error;", "executionContext", "Lcom/apollographql/apollo3/api/ExecutionContext;", "extensions", "", "", "isLast", "", "addExecutionContext", "build", "Lcom/apollographql/apollo3/api/ApolloResponse;", "apollo-api"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class Builder<D extends Operation.Data> {
        private final D data;
        private List<Error> errors;
        private ExecutionContext executionContext;
        private Map<String, ? extends Object> extensions;
        private boolean isLast;
        private final Operation<D> operation;
        private UUID requestUuid;

        public Builder(Operation<D> operation, UUID requestUuid, D d) {
            Intrinsics.checkNotNullParameter(operation, "operation");
            Intrinsics.checkNotNullParameter(requestUuid, "requestUuid");
            this.operation = operation;
            this.requestUuid = requestUuid;
            this.data = d;
            this.executionContext = ExecutionContext.Empty;
        }

        public final Builder<D> addExecutionContext(ExecutionContext executionContext) {
            Intrinsics.checkNotNullParameter(executionContext, "executionContext");
            this.executionContext = this.executionContext.plus(executionContext);
            return this;
        }

        public final Builder<D> errors(List<Error> errors) {
            this.errors = errors;
            return this;
        }

        public final Builder<D> extensions(Map<String, ? extends Object> extensions) {
            this.extensions = extensions;
            return this;
        }

        public final Builder<D> requestUuid(UUID requestUuid) {
            Intrinsics.checkNotNullParameter(requestUuid, "requestUuid");
            this.requestUuid = requestUuid;
            return this;
        }

        public final Builder<D> isLast(boolean isLast) {
            this.isLast = isLast;
            return this;
        }

        public final ApolloResponse<D> build() {
            Operation<D> operation = this.operation;
            UUID uuid = this.requestUuid;
            D d = this.data;
            ExecutionContext executionContext = this.executionContext;
            Map<String, ? extends Object> mapEmptyMap = this.extensions;
            if (mapEmptyMap == null) {
                mapEmptyMap = MapsKt.emptyMap();
            }
            return new ApolloResponse<>(uuid, operation, d, this.errors, mapEmptyMap, executionContext, this.isLast, null);
        }
    }
}
