package com.apollographql.apollo3.network;

import com.apollographql.apollo3.ApolloClient;
import com.apollographql.apollo3.api.http.HttpHeader;
import com.apollographql.apollo3.network.http.DefaultHttpEngine;
import com.apollographql.apollo3.network.http.HttpNetworkTransport;
import com.apollographql.apollo3.network.ws.DefaultWebSocketEngine;
import com.apollographql.apollo3.network.ws.WebSocketNetworkTransport;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.Call;
import okhttp3.Headers;
import okhttp3.OkHttpClient;

/* JADX INFO: compiled from: OkHttpExtensions.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000*\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\u001a\u0012\u0010\u0000\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003\u001a\u0012\u0010\u0000\u001a\u00020\u0004*\u00020\u00042\u0006\u0010\u0000\u001a\u00020\u0003\u001a\u0012\u0010\u0005\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0005\u001a\u00020\u0006\u001a\u0012\u0010\u0005\u001a\u00020\u0004*\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006\u001a\u0012\u0010\u0005\u001a\u00020\u0007*\u00020\u00072\u0006\u0010\u0005\u001a\u00020\u0006\u001a\u0012\u0010\b\u001a\u00020\t*\b\u0012\u0004\u0012\u00020\u000b0\nH\u0000¨\u0006\f"}, d2 = {"okHttpCallFactory", "Lcom/apollographql/apollo3/ApolloClient$Builder;", "callFactory", "Lokhttp3/Call$Factory;", "Lcom/apollographql/apollo3/network/http/HttpNetworkTransport$Builder;", "okHttpClient", "Lokhttp3/OkHttpClient;", "Lcom/apollographql/apollo3/network/ws/WebSocketNetworkTransport$Builder;", "toOkHttpHeaders", "Lokhttp3/Headers;", "", "Lcom/apollographql/apollo3/api/http/HttpHeader;", "apollo-runtime"}, k = 2, mv = {1, 5, 1}, xi = 48)
public final class OkHttpExtensionsKt {
    public static final ApolloClient.Builder okHttpClient(ApolloClient.Builder builder, OkHttpClient okHttpClient) {
        Intrinsics.checkNotNullParameter(builder, "<this>");
        Intrinsics.checkNotNullParameter(okHttpClient, "okHttpClient");
        builder.httpEngine(new DefaultHttpEngine(okHttpClient));
        builder.webSocketEngine(new DefaultWebSocketEngine(okHttpClient));
        return builder;
    }

    public static final ApolloClient.Builder okHttpCallFactory(ApolloClient.Builder builder, Call.Factory callFactory) {
        Intrinsics.checkNotNullParameter(builder, "<this>");
        Intrinsics.checkNotNullParameter(callFactory, "callFactory");
        builder.httpEngine(new DefaultHttpEngine(callFactory));
        return builder;
    }

    public static final HttpNetworkTransport.Builder okHttpClient(HttpNetworkTransport.Builder builder, OkHttpClient okHttpClient) {
        Intrinsics.checkNotNullParameter(builder, "<this>");
        Intrinsics.checkNotNullParameter(okHttpClient, "okHttpClient");
        builder.httpEngine(new DefaultHttpEngine(okHttpClient));
        return builder;
    }

    public static final HttpNetworkTransport.Builder okHttpCallFactory(HttpNetworkTransport.Builder builder, Call.Factory okHttpCallFactory) {
        Intrinsics.checkNotNullParameter(builder, "<this>");
        Intrinsics.checkNotNullParameter(okHttpCallFactory, "okHttpCallFactory");
        builder.httpEngine(new DefaultHttpEngine(okHttpCallFactory));
        return builder;
    }

    public static final WebSocketNetworkTransport.Builder okHttpClient(WebSocketNetworkTransport.Builder builder, OkHttpClient okHttpClient) {
        Intrinsics.checkNotNullParameter(builder, "<this>");
        Intrinsics.checkNotNullParameter(okHttpClient, "okHttpClient");
        builder.webSocketEngine(new DefaultWebSocketEngine(okHttpClient));
        return builder;
    }

    public static final Headers toOkHttpHeaders(List<HttpHeader> list) {
        Intrinsics.checkNotNullParameter(list, "<this>");
        Headers.Builder builder = new Headers.Builder();
        for (HttpHeader httpHeader : list) {
            builder.add(httpHeader.getName(), httpHeader.getValue());
        }
        return builder.build();
    }
}
