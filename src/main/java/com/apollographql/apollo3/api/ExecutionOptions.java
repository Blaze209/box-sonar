package com.apollographql.apollo3.api;

import com.apollographql.apollo3.api.http.HttpHeader;
import com.apollographql.apollo3.api.http.HttpMethod;
import java.util.List;
import kotlin.Metadata;

/* JADX INFO: compiled from: ExecutionOptions.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\bf\u0018\u0000 \u00192\u00020\u0001:\u0001\u0019R\u0014\u0010\u0002\u001a\u0004\u0018\u00010\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005R\u0014\u0010\u0006\u001a\u0004\u0018\u00010\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0007\u0010\u0005R\u0012\u0010\b\u001a\u00020\tX¦\u0004¢\u0006\u0006\u001a\u0004\b\n\u0010\u000bR\u001a\u0010\f\u001a\n\u0012\u0004\u0012\u00020\u000e\u0018\u00010\rX¦\u0004¢\u0006\u0006\u001a\u0004\b\u000f\u0010\u0010R\u0014\u0010\u0011\u001a\u0004\u0018\u00010\u0012X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0013\u0010\u0014R\u0014\u0010\u0015\u001a\u0004\u0018\u00010\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0016\u0010\u0005R\u0014\u0010\u0017\u001a\u0004\u0018\u00010\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0018\u0010\u0005¨\u0006\u001a"}, d2 = {"Lcom/apollographql/apollo3/api/ExecutionOptions;", "", "canBeBatched", "", "getCanBeBatched", "()Ljava/lang/Boolean;", "enableAutoPersistedQueries", "getEnableAutoPersistedQueries", "executionContext", "Lcom/apollographql/apollo3/api/ExecutionContext;", "getExecutionContext", "()Lcom/apollographql/apollo3/api/ExecutionContext;", "httpHeaders", "", "Lcom/apollographql/apollo3/api/http/HttpHeader;", "getHttpHeaders", "()Ljava/util/List;", "httpMethod", "Lcom/apollographql/apollo3/api/http/HttpMethod;", "getHttpMethod", "()Lcom/apollographql/apollo3/api/http/HttpMethod;", "sendApqExtensions", "getSendApqExtensions", "sendDocument", "getSendDocument", "Companion", "apollo-api"}, k = 1, mv = {1, 5, 1}, xi = 48)
public interface ExecutionOptions {
    public static final String CAN_BE_BATCHED = "X-APOLLO-CAN-BE-BATCHED";

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = Companion.$$INSTANCE;

    Boolean getCanBeBatched();

    Boolean getEnableAutoPersistedQueries();

    ExecutionContext getExecutionContext();

    List<HttpHeader> getHttpHeaders();

    HttpMethod getHttpMethod();

    Boolean getSendApqExtensions();

    Boolean getSendDocument();

    /* JADX INFO: compiled from: ExecutionOptions.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/apollographql/apollo3/api/ExecutionOptions$Companion;", "", "()V", "CAN_BE_BATCHED", "", "apollo-api"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class Companion {
        static final /* synthetic */ Companion $$INSTANCE = new Companion();
        public static final String CAN_BE_BATCHED = "X-APOLLO-CAN-BE-BATCHED";

        private Companion() {
        }
    }
}
