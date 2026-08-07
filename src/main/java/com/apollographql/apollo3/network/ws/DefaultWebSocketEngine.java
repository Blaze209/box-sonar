package com.apollographql.apollo3.network.ws;

import com.apollographql.apollo3.api.http.HttpHeader;
import com.apollographql.apollo3.exception.ApolloWebSocketClosedException;
import com.apollographql.apollo3.internal.ChannelWrapper;
import com.apollographql.apollo3.network.OkHttpExtensionsKt;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CompletableDeferred;
import kotlinx.coroutines.CompletableDeferredKt;
import kotlinx.coroutines.channels.ChannelKt;
import kotlinx.coroutines.channels.SendChannel;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.WebSocket;
import okhttp3.WebSocketListener;
import okio.ByteString;

/* JADX INFO: compiled from: OkHttpWebSocketEngine.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0016¢\u0006\u0002\u0010\u0002B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J$\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000bH\u0096@¢\u0006\u0002\u0010\rJ*\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0012\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\t0\u000eH\u0097@¢\u0006\u0002\u0010\u000fR\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0010"}, d2 = {"Lcom/apollographql/apollo3/network/ws/DefaultWebSocketEngine;", "Lcom/apollographql/apollo3/network/ws/WebSocketEngine;", "()V", "webSocketFactory", "Lokhttp3/WebSocket$Factory;", "(Lokhttp3/WebSocket$Factory;)V", "open", "Lcom/apollographql/apollo3/network/ws/WebSocketConnection;", "url", "", "headers", "", "Lcom/apollographql/apollo3/api/http/HttpHeader;", "(Ljava/lang/String;Ljava/util/List;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "", "(Ljava/lang/String;Ljava/util/Map;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "apollo-runtime"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class DefaultWebSocketEngine implements WebSocketEngine {
    private final WebSocket.Factory webSocketFactory;

    /* JADX INFO: renamed from: com.apollographql.apollo3.network.ws.DefaultWebSocketEngine$open$1, reason: invalid class name */
    /* JADX INFO: compiled from: OkHttpWebSocketEngine.kt */
    @Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
    @DebugMetadata(c = "com.apollographql.apollo3.network.ws.DefaultWebSocketEngine", f = "OkHttpWebSocketEngine.kt", i = {0, 0}, l = {74}, m = "open", n = {"messageChannel", "webSocket"}, s = {"L$0", "L$1"})
    static final class AnonymousClass1 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        int label;
        /* synthetic */ Object result;

        AnonymousClass1(Continuation<? super AnonymousClass1> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return DefaultWebSocketEngine.this.open((String) null, (List<HttpHeader>) null, this);
        }
    }

    public DefaultWebSocketEngine(WebSocket.Factory webSocketFactory) {
        Intrinsics.checkNotNullParameter(webSocketFactory, "webSocketFactory");
        this.webSocketFactory = webSocketFactory;
    }

    public DefaultWebSocketEngine() {
        this(new OkHttpClient());
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    @Override // com.apollographql.apollo3.network.ws.WebSocketEngine
    public Object open(String str, List<HttpHeader> list, Continuation<? super WebSocketConnection> continuation) {
        AnonymousClass1 anonymousClass1;
        final WebSocket webSocketNewWebSocket;
        final ChannelWrapper channelWrapper;
        if (continuation instanceof AnonymousClass1) {
            anonymousClass1 = (AnonymousClass1) continuation;
            if ((anonymousClass1.label & Integer.MIN_VALUE) != 0) {
                anonymousClass1.label -= Integer.MIN_VALUE;
            } else {
                anonymousClass1 = new AnonymousClass1(continuation);
            }
        } else {
            anonymousClass1 = new AnonymousClass1(continuation);
        }
        Object obj = anonymousClass1.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = anonymousClass1.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            final ChannelWrapper channelWrapper2 = new ChannelWrapper(ChannelKt.Channel$default(Integer.MAX_VALUE, null, null, 6, null));
            final CompletableDeferred completableDeferredCompletableDeferred$default = CompletableDeferredKt.CompletableDeferred$default(null, 1, null);
            webSocketNewWebSocket = this.webSocketFactory.newWebSocket(new Request.Builder().url(str).headers(OkHttpExtensionsKt.toOkHttpHeaders(list)).build(), new WebSocketListener() { // from class: com.apollographql.apollo3.network.ws.DefaultWebSocketEngine$open$webSocket$1
                @Override // okhttp3.WebSocketListener
                public void onOpen(WebSocket webSocket, Response response) {
                    Intrinsics.checkNotNullParameter(webSocket, "webSocket");
                    Intrinsics.checkNotNullParameter(response, "response");
                    completableDeferredCompletableDeferred$default.complete(Unit.INSTANCE);
                }

                @Override // okhttp3.WebSocketListener
                public void onMessage(WebSocket webSocket, String text) {
                    Intrinsics.checkNotNullParameter(webSocket, "webSocket");
                    Intrinsics.checkNotNullParameter(text, "text");
                    channelWrapper2.mo11206trySendJP2dKIU(text);
                }

                @Override // okhttp3.WebSocketListener
                public void onMessage(WebSocket webSocket, ByteString bytes) {
                    Intrinsics.checkNotNullParameter(webSocket, "webSocket");
                    Intrinsics.checkNotNullParameter(bytes, "bytes");
                    channelWrapper2.mo11206trySendJP2dKIU(bytes.utf8());
                }

                @Override // okhttp3.WebSocketListener
                public void onFailure(WebSocket webSocket, Throwable t, Response response) {
                    Intrinsics.checkNotNullParameter(webSocket, "webSocket");
                    Intrinsics.checkNotNullParameter(t, "t");
                    completableDeferredCompletableDeferred$default.complete(Unit.INSTANCE);
                    channelWrapper2.close(t);
                }

                @Override // okhttp3.WebSocketListener
                public void onClosing(WebSocket webSocket, int code, String reason) {
                    Intrinsics.checkNotNullParameter(webSocket, "webSocket");
                    Intrinsics.checkNotNullParameter(reason, "reason");
                    completableDeferredCompletableDeferred$default.complete(Unit.INSTANCE);
                    channelWrapper2.close(new ApolloWebSocketClosedException(code, reason, null, 4, null));
                }

                @Override // okhttp3.WebSocketListener
                public void onClosed(WebSocket webSocket, int code, String reason) {
                    Intrinsics.checkNotNullParameter(webSocket, "webSocket");
                    Intrinsics.checkNotNullParameter(reason, "reason");
                    SendChannel.DefaultImpls.close$default(channelWrapper2, null, 1, null);
                }
            });
            anonymousClass1.L$0 = channelWrapper2;
            anonymousClass1.L$1 = webSocketNewWebSocket;
            anonymousClass1.label = 1;
            if (completableDeferredCompletableDeferred$default.await(anonymousClass1) == coroutine_suspended) {
                return coroutine_suspended;
            }
            channelWrapper = channelWrapper2;
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            webSocketNewWebSocket = (WebSocket) anonymousClass1.L$1;
            channelWrapper = (ChannelWrapper) anonymousClass1.L$0;
            ResultKt.throwOnFailure(obj);
        }
        channelWrapper.setInvokeOnClose(new Function1<Throwable, Unit>() { // from class: com.apollographql.apollo3.network.ws.DefaultWebSocketEngine.open.2
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Throwable th) {
                invoke2(th);
                return Unit.INSTANCE;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Throwable th) {
                webSocketNewWebSocket.close(1001, null);
            }
        });
        return new WebSocketConnection() { // from class: com.apollographql.apollo3.network.ws.DefaultWebSocketEngine.open.3
            @Override // com.apollographql.apollo3.network.ws.WebSocketConnection
            public Object receive(Continuation<? super String> continuation2) {
                return channelWrapper.receive(continuation2);
            }

            @Override // com.apollographql.apollo3.network.ws.WebSocketConnection
            public void send(ByteString data) {
                Intrinsics.checkNotNullParameter(data, "data");
                if (webSocketNewWebSocket.send(data)) {
                    return;
                }
                SendChannel.DefaultImpls.close$default(channelWrapper, null, 1, null);
            }

            @Override // com.apollographql.apollo3.network.ws.WebSocketConnection
            public void send(String string) {
                Intrinsics.checkNotNullParameter(string, "string");
                if (webSocketNewWebSocket.send(string)) {
                    return;
                }
                SendChannel.DefaultImpls.close$default(channelWrapper, null, 1, null);
            }

            @Override // com.apollographql.apollo3.network.ws.WebSocketConnection
            public void close() {
                webSocketNewWebSocket.close(1000, null);
            }
        };
    }

    @Override // com.apollographql.apollo3.network.ws.WebSocketEngine
    @Deprecated(message = "Use open(String, List<HttpHeader>) instead.", replaceWith = @ReplaceWith(expression = "open(url, headers.map { HttpHeader(it.key, it.value })", imports = {"com.apollographql.apollo3.api.http.HttpHeader"}))
    public Object open(String str, Map<String, String> map, Continuation<? super WebSocketConnection> continuation) {
        ArrayList arrayList = new ArrayList(map.size());
        for (Map.Entry<String, String> entry : map.entrySet()) {
            arrayList.add(new HttpHeader(entry.getKey(), entry.getValue()));
        }
        return open(str, arrayList, continuation);
    }
}
