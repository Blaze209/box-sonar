package com.apollographql.apollo3.exception;

import kotlin.Metadata;

/* JADX INFO: compiled from: Exceptions.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/apollographql/apollo3/exception/AutoPersistedQueriesNotSupported;", "Lcom/apollographql/apollo3/exception/ApolloException;", "()V", "apollo-api"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class AutoPersistedQueriesNotSupported extends ApolloException {
    public AutoPersistedQueriesNotSupported() {
        super("The server does not support auto persisted queries", null, 2, null);
    }
}
