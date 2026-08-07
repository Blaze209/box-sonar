package com.apollographql.apollo3.api.http;

import com.apollographql.apollo3.api.ApolloRequest;
import com.apollographql.apollo3.api.Operation;
import java.util.Map;
import kotlin.Metadata;

/* JADX INFO: compiled from: WebSocketPayloadComposer.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bg\u0018\u00002\u00020\u0001J.\u0010\u0002\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0003\"\b\b\u0000\u0010\u0005*\u00020\u00062\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u0002H\u00050\bH&¨\u0006\t"}, d2 = {"Lcom/apollographql/apollo3/api/http/WebSocketPayloadComposer;", "", "compose", "", "", "D", "Lcom/apollographql/apollo3/api/Operation$Data;", "apolloRequest", "Lcom/apollographql/apollo3/api/ApolloRequest;", "apollo-api"}, k = 1, mv = {1, 5, 1}, xi = 48)
public interface WebSocketPayloadComposer {
    <D extends Operation.Data> Map<String, Object> compose(ApolloRequest<D> apolloRequest);
}
