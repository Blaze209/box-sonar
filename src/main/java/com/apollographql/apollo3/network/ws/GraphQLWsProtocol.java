package com.apollographql.apollo3.network.ws;

import com.apollographql.apollo3.api.ApolloRequest;
import com.apollographql.apollo3.api.Operation;
import com.apollographql.apollo3.api.http.DefaultWebSocketPayloadComposer;
import com.apollographql.apollo3.api.http.WebSocketPayloadComposer;
import com.box.android.domain.analytics.BoxAnalyticsParams;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.microsoft.identity.common.internal.providers.oauth2.PasskeyWebListener;
import external.sdk.pendo.io.mozilla.javascript.ES6Iterator;
import java.util.Map;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: compiled from: GraphQLWsProtocol.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001:\u0001(B\u009b\u0001\b\u0017\u0012.\b\u0002\u0010\u0002\u001a(\b\u0001\u0012\u001a\u0012\u0018\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u0007\u0018\u00010\u00050\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u0003\u0012\u0018\b\u0002\u0010\b\u001a\u0012\u0012\u0004\u0012\u00020\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u0007\u0018\u00010\u0005\u0012\u0018\b\u0002\u0010\t\u001a\u0012\u0012\u0004\u0012\u00020\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u0007\u0018\u00010\u0005\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\u0006\u0010\f\u001a\u00020\u000b\u0012\u0006\u0010\r\u001a\u00020\u000e\u0012\u0006\u0010\u000f\u001a\u00020\u0010\u0012\u0006\u0010\u0011\u001a\u00020\u0012\u0012\u0006\u0010\u0013\u001a\u00020\u0014¢\u0006\u0002\u0010\u0015B\u0085\u0001\b\u0017\u0012\u0018\b\u0002\u0010\u0002\u001a\u0012\u0012\u0004\u0012\u00020\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u0007\u0018\u00010\u0005\u0012\u0018\b\u0002\u0010\b\u001a\u0012\u0012\u0004\u0012\u00020\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u0007\u0018\u00010\u0005\u0012\u0018\b\u0002\u0010\t\u001a\u0012\u0012\u0004\u0012\u00020\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u0007\u0018\u00010\u0005\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\u0006\u0010\f\u001a\u00020\u000b\u0012\u0006\u0010\r\u001a\u00020\u000e\u0012\u0006\u0010\u000f\u001a\u00020\u0010\u0012\u0006\u0010\u0011\u001a\u00020\u0012\u0012\u0006\u0010\u0013\u001a\u00020\u0014¢\u0006\u0002\u0010\u0016B£\u0001\b\u0000\u0012.\b\u0002\u0010\u0002\u001a(\b\u0001\u0012\u001a\u0012\u0018\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u0007\u0018\u00010\u00050\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u0003\u0012\u0018\b\u0002\u0010\b\u001a\u0012\u0012\u0004\u0012\u00020\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u0007\u0018\u00010\u0005\u0012\u0018\b\u0002\u0010\t\u001a\u0012\u0012\u0004\u0012\u00020\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u0007\u0018\u00010\u0005\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\u0006\u0010\f\u001a\u00020\u000b\u0012\u0006\u0010\r\u001a\u00020\u000e\u0012\u0006\u0010\u000f\u001a\u00020\u0010\u0012\u0006\u0010\u0011\u001a\u00020\u0012\u0012\u0006\u0010\u0013\u001a\u00020\u0014\u0012\u0006\u0010\u0017\u001a\u00020\u0018¢\u0006\u0002\u0010\u0019J\u000e\u0010\u001b\u001a\u00020\u001cH\u0096@¢\u0006\u0002\u0010\u001dJ\u001e\u0010\u001e\u001a\u00020\u001c2\u0014\u0010\u001f\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u0005H\u0016J\u000e\u0010 \u001a\u00020\u001cH\u0096@¢\u0006\u0002\u0010\u001dJ\b\u0010!\u001a\u00020\u001cH\u0002J \u0010\"\u001a\u00020\u001c\"\b\b\u0000\u0010#*\u00020$2\f\u0010%\u001a\b\u0012\u0004\u0012\u0002H#0&H\u0016J \u0010'\u001a\u00020\u001c\"\b\b\u0000\u0010#*\u00020$2\f\u0010%\u001a\b\u0012\u0004\u0012\u0002H#0&H\u0016R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R6\u0010\u0002\u001a(\b\u0001\u0012\u001a\u0012\u0018\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u0007\u0018\u00010\u00050\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u0003X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u001aR\u000e\u0010\r\u001a\u00020\u000eX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u001e\u0010\b\u001a\u0012\u0012\u0004\u0012\u00020\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u0007\u0018\u00010\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u001e\u0010\t\u001a\u0012\u0012\u0004\u0012\u00020\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u0007\u0018\u00010\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0014X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0018X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006)"}, d2 = {"Lcom/apollographql/apollo3/network/ws/GraphQLWsProtocol;", "Lcom/apollographql/apollo3/network/ws/WsProtocol;", "connectionPayload", "Lkotlin/Function1;", "Lkotlin/coroutines/Continuation;", "", "", "", "pingPayload", "pongPayload", "connectionAcknowledgeTimeoutMs", "", "pingIntervalMillis", "frameType", "Lcom/apollographql/apollo3/network/ws/WsFrameType;", "webSocketConnection", "Lcom/apollographql/apollo3/network/ws/WebSocketConnection;", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "Lcom/apollographql/apollo3/network/ws/WsProtocol$Listener;", "scope", "Lkotlinx/coroutines/CoroutineScope;", "(Lkotlin/jvm/functions/Function1;Ljava/util/Map;Ljava/util/Map;JJLcom/apollographql/apollo3/network/ws/WsFrameType;Lcom/apollographql/apollo3/network/ws/WebSocketConnection;Lcom/apollographql/apollo3/network/ws/WsProtocol$Listener;Lkotlinx/coroutines/CoroutineScope;)V", "(Ljava/util/Map;Ljava/util/Map;Ljava/util/Map;JJLcom/apollographql/apollo3/network/ws/WsFrameType;Lcom/apollographql/apollo3/network/ws/WebSocketConnection;Lcom/apollographql/apollo3/network/ws/WsProtocol$Listener;Lkotlinx/coroutines/CoroutineScope;)V", "webSocketPayloadComposer", "Lcom/apollographql/apollo3/api/http/WebSocketPayloadComposer;", "(Lkotlin/jvm/functions/Function1;Ljava/util/Map;Ljava/util/Map;JJLcom/apollographql/apollo3/network/ws/WsFrameType;Lcom/apollographql/apollo3/network/ws/WebSocketConnection;Lcom/apollographql/apollo3/network/ws/WsProtocol$Listener;Lkotlinx/coroutines/CoroutineScope;Lcom/apollographql/apollo3/api/http/WebSocketPayloadComposer;)V", "Lkotlin/jvm/functions/Function1;", "connectionInit", "", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "handleServerMessage", "messageMap", "run", "sendPong", "startOperation", "D", "Lcom/apollographql/apollo3/api/Operation$Data;", "request", "Lcom/apollographql/apollo3/api/ApolloRequest;", "stopOperation", "Factory", "apollo-runtime"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class GraphQLWsProtocol extends WsProtocol {
    private final long connectionAcknowledgeTimeoutMs;
    private final Function1<Continuation<? super Map<String, ? extends Object>>, Object> connectionPayload;
    private final WsFrameType frameType;
    private final long pingIntervalMillis;
    private final Map<String, Object> pingPayload;
    private final Map<String, Object> pongPayload;
    private final CoroutineScope scope;
    private final WebSocketPayloadComposer webSocketPayloadComposer;

    /* JADX INFO: renamed from: com.apollographql.apollo3.network.ws.GraphQLWsProtocol$connectionInit$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: GraphQLWsProtocol.kt */
    @Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
    @DebugMetadata(c = "com.apollographql.apollo3.network.ws.GraphQLWsProtocol", f = "GraphQLWsProtocol.kt", i = {0, 0}, l = {79, 86}, m = "connectionInit", n = {"this", "message"}, s = {"L$0", "L$1"})
    static final class C09101 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        int label;
        /* synthetic */ Object result;

        C09101(Continuation<? super C09101> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return GraphQLWsProtocol.this.connectionInit(this);
        }
    }

    /* JADX INFO: renamed from: com.apollographql.apollo3.network.ws.GraphQLWsProtocol$1, reason: invalid class name */
    /* JADX INFO: compiled from: GraphQLWsProtocol.kt */
    @Metadata(d1 = {"\u0000\u0006\n\u0000\n\u0002\u0010\u0001\u0010\u0000\u001a\u0004\u0018\u00010\u0001H\u008a@"}, d2 = {"<anonymous>", ""}, k = 3, mv = {1, 5, 1}, xi = 48)
    @DebugMetadata(c = "com.apollographql.apollo3.network.ws.GraphQLWsProtocol$1", f = "GraphQLWsProtocol.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    static final class AnonymousClass1 extends SuspendLambda implements Function1<Continuation, Object> {
        int label;

        AnonymousClass1(Continuation<? super AnonymousClass1> continuation) {
            super(1, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Continuation<?> continuation) {
            return new AnonymousClass1(continuation);
        }

        @Override // kotlin.jvm.functions.Function1
        public final Object invoke(Continuation continuation) {
            return ((AnonymousClass1) create(continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            return null;
        }
    }

    public /* synthetic */ GraphQLWsProtocol(AnonymousClass1 anonymousClass1, Map map, Map map2, long j, long j2, WsFrameType wsFrameType, WebSocketConnection webSocketConnection, WsProtocol.Listener listener, CoroutineScope coroutineScope, WebSocketPayloadComposer webSocketPayloadComposer, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? new AnonymousClass1(null) : anonymousClass1, (i & 2) != 0 ? null : map, (i & 4) != 0 ? null : map2, j, j2, wsFrameType, webSocketConnection, listener, coroutineScope, webSocketPayloadComposer);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public GraphQLWsProtocol(Function1<? super Continuation<? super Map<String, ? extends Object>>, ? extends Object> connectionPayload, Map<String, ? extends Object> map, Map<String, ? extends Object> map2, long j, long j2, WsFrameType frameType, WebSocketConnection webSocketConnection, WsProtocol.Listener listener, CoroutineScope scope, WebSocketPayloadComposer webSocketPayloadComposer) {
        super(webSocketConnection, listener);
        Intrinsics.checkNotNullParameter(connectionPayload, "connectionPayload");
        Intrinsics.checkNotNullParameter(frameType, "frameType");
        Intrinsics.checkNotNullParameter(webSocketConnection, "webSocketConnection");
        Intrinsics.checkNotNullParameter(listener, "listener");
        Intrinsics.checkNotNullParameter(scope, "scope");
        Intrinsics.checkNotNullParameter(webSocketPayloadComposer, "webSocketPayloadComposer");
        this.connectionPayload = connectionPayload;
        this.pingPayload = map;
        this.pongPayload = map2;
        this.connectionAcknowledgeTimeoutMs = j;
        this.pingIntervalMillis = j2;
        this.frameType = frameType;
        this.scope = scope;
        this.webSocketPayloadComposer = webSocketPayloadComposer;
    }

    /* JADX INFO: renamed from: com.apollographql.apollo3.network.ws.GraphQLWsProtocol$2, reason: invalid class name */
    /* JADX INFO: compiled from: GraphQLWsProtocol.kt */
    @Metadata(d1 = {"\u0000\u0006\n\u0000\n\u0002\u0010\u0001\u0010\u0000\u001a\u0004\u0018\u00010\u0001H\u008a@"}, d2 = {"<anonymous>", ""}, k = 3, mv = {1, 5, 1}, xi = 48)
    @DebugMetadata(c = "com.apollographql.apollo3.network.ws.GraphQLWsProtocol$2", f = "GraphQLWsProtocol.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    static final class AnonymousClass2 extends SuspendLambda implements Function1<Continuation, Object> {
        int label;

        AnonymousClass2(Continuation<? super AnonymousClass2> continuation) {
            super(1, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Continuation<?> continuation) {
            return new AnonymousClass2(continuation);
        }

        @Override // kotlin.jvm.functions.Function1
        public final Object invoke(Continuation continuation) {
            return ((AnonymousClass2) create(continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            return null;
        }
    }

    public /* synthetic */ GraphQLWsProtocol(AnonymousClass2 anonymousClass2, Map map, Map map2, long j, long j2, WsFrameType wsFrameType, WebSocketConnection webSocketConnection, WsProtocol.Listener listener, CoroutineScope coroutineScope, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((Function1<? super Continuation<? super Map<String, ? extends Object>>, ? extends Object>) ((i & 1) != 0 ? new AnonymousClass2(null) : anonymousClass2), (Map<String, ? extends Object>) ((i & 2) != 0 ? null : map), (Map<String, ? extends Object>) ((i & 4) != 0 ? null : map2), j, j2, wsFrameType, webSocketConnection, listener, coroutineScope);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @Deprecated(message = "Use GraphQLWsProtocol.Factory instead")
    public GraphQLWsProtocol(Function1<? super Continuation<? super Map<String, ? extends Object>>, ? extends Object> connectionPayload, Map<String, ? extends Object> map, Map<String, ? extends Object> map2, long j, long j2, WsFrameType frameType, WebSocketConnection webSocketConnection, WsProtocol.Listener listener, CoroutineScope scope) {
        this(connectionPayload, map, map2, j, j2, frameType, webSocketConnection, listener, scope, new DefaultWebSocketPayloadComposer());
        Intrinsics.checkNotNullParameter(connectionPayload, "connectionPayload");
        Intrinsics.checkNotNullParameter(frameType, "frameType");
        Intrinsics.checkNotNullParameter(webSocketConnection, "webSocketConnection");
        Intrinsics.checkNotNullParameter(listener, "listener");
        Intrinsics.checkNotNullParameter(scope, "scope");
    }

    public /* synthetic */ GraphQLWsProtocol(Map map, Map map2, Map map3, long j, long j2, WsFrameType wsFrameType, WebSocketConnection webSocketConnection, WsProtocol.Listener listener, CoroutineScope coroutineScope, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((Map<String, ? extends Object>) ((i & 1) != 0 ? null : map), (Map<String, ? extends Object>) ((i & 2) != 0 ? null : map2), (Map<String, ? extends Object>) ((i & 4) != 0 ? null : map3), j, j2, wsFrameType, webSocketConnection, listener, coroutineScope);
    }

    /* JADX INFO: renamed from: com.apollographql.apollo3.network.ws.GraphQLWsProtocol$3, reason: invalid class name */
    /* JADX INFO: compiled from: GraphQLWsProtocol.kt */
    @Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0010\u0000\u0010\u0000\u001a\u0012\u0012\u0004\u0012\u00020\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0018\u00010\u0001H\u008a@"}, d2 = {"<anonymous>", "", "", ""}, k = 3, mv = {1, 5, 1}, xi = 48)
    @DebugMetadata(c = "com.apollographql.apollo3.network.ws.GraphQLWsProtocol$3", f = "GraphQLWsProtocol.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    static final class AnonymousClass3 extends SuspendLambda implements Function1<Continuation<? super Map<String, ? extends Object>>, Object> {
        final /* synthetic */ Map<String, Object> $connectionPayload;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass3(Map<String, ? extends Object> map, Continuation<? super AnonymousClass3> continuation) {
            super(1, continuation);
            this.$connectionPayload = map;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Continuation<?> continuation) {
            return new AnonymousClass3(this.$connectionPayload, continuation);
        }

        @Override // kotlin.jvm.functions.Function1
        public final Object invoke(Continuation<? super Map<String, ? extends Object>> continuation) {
            return ((AnonymousClass3) create(continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            return this.$connectionPayload;
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @Deprecated(message = "Use GraphQLWsProtocol.Factory instead")
    public GraphQLWsProtocol(Map<String, ? extends Object> map, Map<String, ? extends Object> map2, Map<String, ? extends Object> map3, long j, long j2, WsFrameType frameType, WebSocketConnection webSocketConnection, WsProtocol.Listener listener, CoroutineScope scope) {
        this(new AnonymousClass3(map, null), map2, map3, j, j2, frameType, webSocketConnection, listener, scope);
        Intrinsics.checkNotNullParameter(frameType, "frameType");
        Intrinsics.checkNotNullParameter(webSocketConnection, "webSocketConnection");
        Intrinsics.checkNotNullParameter(listener, "listener");
        Intrinsics.checkNotNullParameter(scope, "scope");
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x008b, code lost:
    
        if (kotlinx.coroutines.TimeoutKt.withTimeout(r7, r4, r0) == r1) goto L25;
     */
    @Override // com.apollographql.apollo3.network.ws.WsProtocol
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.Object connectionInit(kotlin.coroutines.Continuation<? super kotlin.Unit> r8) {
        /*
            r7 = this;
            boolean r0 = r8 instanceof com.apollographql.apollo3.network.ws.GraphQLWsProtocol.C09101
            if (r0 == 0) goto L14
            r0 = r8
            com.apollographql.apollo3.network.ws.GraphQLWsProtocol$connectionInit$1 r0 = (com.apollographql.apollo3.network.ws.GraphQLWsProtocol.C09101) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L14
            int r8 = r0.label
            int r8 = r8 - r2
            r0.label = r8
            goto L19
        L14:
            com.apollographql.apollo3.network.ws.GraphQLWsProtocol$connectionInit$1 r0 = new com.apollographql.apollo3.network.ws.GraphQLWsProtocol$connectionInit$1
            r0.<init>(r8)
        L19:
            java.lang.Object r8 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 2
            r4 = 1
            if (r2 == 0) goto L41
            if (r2 == r4) goto L35
            if (r2 != r3) goto L2d
            kotlin.ResultKt.throwOnFailure(r8)
            goto L8e
        L2d:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.String r8 = "call to 'resume' before 'invoke' with coroutine"
            r7.<init>(r8)
            throw r7
        L35:
            java.lang.Object r7 = r0.L$1
            java.util.Map r7 = (java.util.Map) r7
            java.lang.Object r2 = r0.L$0
            com.apollographql.apollo3.network.ws.GraphQLWsProtocol r2 = (com.apollographql.apollo3.network.ws.GraphQLWsProtocol) r2
            kotlin.ResultKt.throwOnFailure(r8)
            goto L69
        L41:
            kotlin.ResultKt.throwOnFailure(r8)
            kotlin.Pair[] r8 = new kotlin.Pair[r4]
            java.lang.String r2 = "type"
            java.lang.String r5 = "connection_init"
            kotlin.Pair r2 = kotlin.TuplesKt.to(r2, r5)
            r5 = 0
            r8[r5] = r2
            java.util.Map r8 = kotlin.collections.MapsKt.mutableMapOf(r8)
            kotlin.jvm.functions.Function1<kotlin.coroutines.Continuation<? super java.util.Map<java.lang.String, ? extends java.lang.Object>>, java.lang.Object> r2 = r7.connectionPayload
            r0.L$0 = r7
            r0.L$1 = r8
            r0.label = r4
            java.lang.Object r2 = r2.invoke(r0)
            if (r2 != r1) goto L65
            goto L8d
        L65:
            r6 = r2
            r2 = r7
            r7 = r8
            r8 = r6
        L69:
            java.util.Map r8 = (java.util.Map) r8
            if (r8 == 0) goto L72
            java.lang.String r4 = "payload"
            r7.put(r4, r8)
        L72:
            com.apollographql.apollo3.network.ws.WsFrameType r8 = r2.frameType
            r2.sendMessageMap(r7, r8)
            long r7 = r2.connectionAcknowledgeTimeoutMs
            com.apollographql.apollo3.network.ws.GraphQLWsProtocol$connectionInit$2 r4 = new com.apollographql.apollo3.network.ws.GraphQLWsProtocol$connectionInit$2
            r5 = 0
            r4.<init>(r5)
            kotlin.jvm.functions.Function2 r4 = (kotlin.jvm.functions.Function2) r4
            r0.L$0 = r5
            r0.L$1 = r5
            r0.label = r3
            java.lang.Object r7 = kotlinx.coroutines.TimeoutKt.withTimeout(r7, r4, r0)
            if (r7 != r1) goto L8e
        L8d:
            return r1
        L8e:
            kotlin.Unit r7 = kotlin.Unit.INSTANCE
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.apollographql.apollo3.network.ws.GraphQLWsProtocol.connectionInit(kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX INFO: renamed from: com.apollographql.apollo3.network.ws.GraphQLWsProtocol$connectionInit$2, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: GraphQLWsProtocol.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 5, 1}, xi = 48)
    @DebugMetadata(c = "com.apollographql.apollo3.network.ws.GraphQLWsProtocol$connectionInit$2", f = "GraphQLWsProtocol.kt", i = {}, l = {87}, m = "invokeSuspend", n = {}, s = {})
    static final class C09112 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;

        C09112(Continuation<? super C09112> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return GraphQLWsProtocol.this.new C09112(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C09112) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                this.label = 1;
                obj = GraphQLWsProtocol.this.receiveMessageMap(this);
                if (obj == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
            Object obj2 = ((Map) obj).get("type");
            if (Intrinsics.areEqual(obj2, "connection_ack")) {
                return Unit.INSTANCE;
            }
            if (Intrinsics.areEqual(obj2, "ping")) {
                GraphQLWsProtocol.this.sendPong();
            } else {
                System.out.println((Object) ("unknown graphql-ws message while waiting for connection_ack: '" + obj2));
            }
            return Unit.INSTANCE;
        }
    }

    @Override // com.apollographql.apollo3.network.ws.WsProtocol
    public <D extends Operation.Data> void startOperation(ApolloRequest<D> request) {
        Intrinsics.checkNotNullParameter(request, "request");
        sendMessageMap(MapsKt.mapOf(TuplesKt.to("type", "subscribe"), TuplesKt.to("id", request.getRequestUuid().toString()), TuplesKt.to("payload", this.webSocketPayloadComposer.compose(request))), this.frameType);
    }

    @Override // com.apollographql.apollo3.network.ws.WsProtocol
    public <D extends Operation.Data> void stopOperation(ApolloRequest<D> request) {
        Intrinsics.checkNotNullParameter(request, "request");
        sendMessageMap(MapsKt.mapOf(TuplesKt.to("type", "complete"), TuplesKt.to("id", request.getRequestUuid().toString())), this.frameType);
    }

    /* JADX INFO: renamed from: com.apollographql.apollo3.network.ws.GraphQLWsProtocol$run$2, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: GraphQLWsProtocol.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 5, 1}, xi = 48)
    @DebugMetadata(c = "com.apollographql.apollo3.network.ws.GraphQLWsProtocol$run$2", f = "GraphQLWsProtocol.kt", i = {0}, l = {128}, m = "invokeSuspend", n = {"map"}, s = {"L$0"})
    static final class C09122 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        Object L$0;
        int label;

        C09122(Continuation<? super C09122> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return GraphQLWsProtocol.this.new C09122(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C09122) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Code duplicated, block: B:14:0x0057 A[RETURN] */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:13:0x0055 -> B:15:0x0058). Please report as a decompilation issue!!! */
        /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
            jadx.core.utils.exceptions.JadxOverflowException: Regions count limit reached at block B:0:?
            	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
            	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
            	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
            */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final java.lang.Object invokeSuspend(java.lang.Object r6) {
            /*
                r5 = this;
                java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
                int r1 = r5.label
                r2 = 1
                if (r1 == 0) goto L1b
                if (r1 != r2) goto L13
                java.lang.Object r1 = r5.L$0
                java.util.Map r1 = (java.util.Map) r1
                kotlin.ResultKt.throwOnFailure(r6)
                goto L58
            L13:
                java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
                java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
                r5.<init>(r6)
                throw r5
            L1b:
                kotlin.ResultKt.throwOnFailure(r6)
                kotlin.Pair[] r6 = new kotlin.Pair[r2]
                java.lang.String r1 = "type"
                java.lang.String r3 = "ping"
                kotlin.Pair r1 = kotlin.TuplesKt.to(r1, r3)
                r3 = 0
                r6[r3] = r1
                java.util.Map r6 = kotlin.collections.MapsKt.mutableMapOf(r6)
                com.apollographql.apollo3.network.ws.GraphQLWsProtocol r1 = com.apollographql.apollo3.network.ws.GraphQLWsProtocol.this
                java.util.Map r1 = com.apollographql.apollo3.network.ws.GraphQLWsProtocol.access$getPingPayload$p(r1)
                if (r1 == 0) goto L43
                com.apollographql.apollo3.network.ws.GraphQLWsProtocol r1 = com.apollographql.apollo3.network.ws.GraphQLWsProtocol.this
                java.util.Map r1 = com.apollographql.apollo3.network.ws.GraphQLWsProtocol.access$getPingPayload$p(r1)
                java.lang.String r3 = "payload"
                r6.put(r3, r1)
            L43:
                r1 = r6
            L44:
                com.apollographql.apollo3.network.ws.GraphQLWsProtocol r6 = com.apollographql.apollo3.network.ws.GraphQLWsProtocol.this
                long r3 = com.apollographql.apollo3.network.ws.GraphQLWsProtocol.access$getPingIntervalMillis$p(r6)
                r6 = r5
                kotlin.coroutines.Continuation r6 = (kotlin.coroutines.Continuation) r6
                r5.L$0 = r1
                r5.label = r2
                java.lang.Object r6 = kotlinx.coroutines.DelayKt.delay(r3, r6)
                if (r6 != r0) goto L58
                return r0
            L58:
                com.apollographql.apollo3.network.ws.GraphQLWsProtocol r6 = com.apollographql.apollo3.network.ws.GraphQLWsProtocol.this
                com.apollographql.apollo3.network.ws.WsFrameType r3 = com.apollographql.apollo3.network.ws.GraphQLWsProtocol.access$getFrameType$p(r6)
                r6.sendMessageMap(r1, r3)
                goto L44
            */
            throw new UnsupportedOperationException("Method not decompiled: com.apollographql.apollo3.network.ws.GraphQLWsProtocol.C09122.invokeSuspend(java.lang.Object):java.lang.Object");
        }
    }

    @Override // com.apollographql.apollo3.network.ws.WsProtocol
    public Object run(Continuation<? super Unit> continuation) {
        if (this.pingIntervalMillis > 0) {
            BuildersKt__Builders_commonKt.launch$default(this.scope, null, null, new C09122(null), 3, null);
        }
        Object objRun = super.run(continuation);
        return objRun == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objRun : Unit.INSTANCE;
    }

    @Override // com.apollographql.apollo3.network.ws.WsProtocol
    public void handleServerMessage(Map<String, ? extends Object> messageMap) {
        Intrinsics.checkNotNullParameter(messageMap, "messageMap");
        Object obj = messageMap.get("type");
        if (Intrinsics.areEqual(obj, ES6Iterator.NEXT_METHOD)) {
            WsProtocol.Listener listener = getListener();
            Object obj2 = messageMap.get("id");
            Intrinsics.checkNotNull(obj2, "null cannot be cast to non-null type kotlin.String");
            Object obj3 = messageMap.get("payload");
            Intrinsics.checkNotNull(obj3, "null cannot be cast to non-null type kotlin.collections.Map<kotlin.String, kotlin.Any?>");
            listener.operationResponse((String) obj2, (Map) obj3);
            return;
        }
        if (Intrinsics.areEqual(obj, "error")) {
            WsProtocol.Listener listener2 = getListener();
            Object obj4 = messageMap.get("id");
            Intrinsics.checkNotNull(obj4, "null cannot be cast to non-null type kotlin.String");
            listener2.operationResponse((String) obj4, MapsKt.mapOf(TuplesKt.to(BoxAnalyticsParams.CATEGORY_ERRORS, messageMap.get("payload"))));
            WsProtocol.Listener listener3 = getListener();
            Object obj5 = messageMap.get("id");
            Intrinsics.checkNotNull(obj5, "null cannot be cast to non-null type kotlin.String");
            listener3.operationComplete((String) obj5);
            return;
        }
        if (Intrinsics.areEqual(obj, "complete")) {
            WsProtocol.Listener listener4 = getListener();
            Object obj6 = messageMap.get("id");
            Intrinsics.checkNotNull(obj6, "null cannot be cast to non-null type kotlin.String");
            listener4.operationComplete((String) obj6);
            return;
        }
        if (Intrinsics.areEqual(obj, "ping")) {
            sendPong();
        } else {
            Intrinsics.areEqual(obj, "pong");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void sendPong() {
        Map<String, ? extends Object> mapMutableMapOf = MapsKt.mutableMapOf(TuplesKt.to("type", "pong"));
        Map<String, Object> map = this.pongPayload;
        if (map != null) {
            mapMutableMapOf.put("payload", map);
        }
        sendMessageMap(mapMutableMapOf, this.frameType);
    }

    /* JADX INFO: compiled from: GraphQLWsProtocol.kt */
    @Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0089\u0001\b\u0016\u0012.\b\u0002\u0010\u0002\u001a(\b\u0001\u0012\u001a\u0012\u0018\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u0007\u0018\u00010\u00050\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u0003\u0012\b\b\u0002\u0010\b\u001a\u00020\t\u0012\u0018\b\u0002\u0010\n\u001a\u0012\u0012\u0004\u0012\u00020\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u0007\u0018\u00010\u0005\u0012\u0018\b\u0002\u0010\u000b\u001a\u0012\u0012\u0004\u0012\u00020\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u0007\u0018\u00010\u0005\u0012\b\b\u0002\u0010\f\u001a\u00020\t\u0012\b\b\u0002\u0010\r\u001a\u00020\u000e¢\u0006\u0002\u0010\u000fBq\b\u0017\u0012\u0016\u0010\u0002\u001a\u0012\u0012\u0004\u0012\u00020\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u0007\u0018\u00010\u0005\u0012\b\b\u0002\u0010\b\u001a\u00020\t\u0012\u0018\b\u0002\u0010\n\u001a\u0012\u0012\u0004\u0012\u00020\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u0007\u0018\u00010\u0005\u0012\u0018\b\u0002\u0010\u000b\u001a\u0012\u0012\u0004\u0012\u00020\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u0007\u0018\u00010\u0005\u0012\b\b\u0002\u0010\f\u001a\u00020\t\u0012\b\b\u0002\u0010\r\u001a\u00020\u000e¢\u0006\u0002\u0010\u0010B\u0005¢\u0006\u0002\u0010\u0011J\u0010\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u0019\u001a\u00020\tH\u0007J9\u0010\u0002\u001a\u00020\u001a2*\u0010\u0002\u001a&\b\u0001\u0012\u0018\u0012\u0016\u0012\u0012\u0012\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u00050\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u0003H\u0007¢\u0006\u0002\u0010\u001bJ \u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020!2\u0006\u0010\"\u001a\u00020#H\u0016J\u0010\u0010\r\u001a\u00020\u001a2\u0006\u0010\r\u001a\u00020\u000eH\u0007J\u0010\u0010\b\u001a\u00020\u001a2\u0006\u0010\b\u001a\u00020\tH\u0007J \u0010\n\u001a\u00020\u001a2\u0016\u0010\n\u001a\u0012\u0012\u0004\u0012\u00020\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u0007\u0018\u00010\u0005H\u0007J \u0010\u000b\u001a\u00020\u001a2\u0016\u0010\u000b\u001a\u0012\u0012\u0004\u0012\u00020\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u0007\u0018\u00010\u0005H\u0007J\u0010\u0010\u0017\u001a\u00020\u001a2\u0006\u0010\u0017\u001a\u00020\u0018H\u0007R\u0012\u0010\f\u001a\u0004\u0018\u00010\tX\u0082\u000e¢\u0006\u0004\n\u0002\u0010\u0012R8\u0010\u0002\u001a*\b\u0001\u0012\u001a\u0012\u0018\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u0007\u0018\u00010\u00050\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u0007\u0018\u00010\u0003X\u0082\u000e¢\u0006\u0004\n\u0002\u0010\u0013R\u0010\u0010\r\u001a\u0004\u0018\u00010\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0014\u001a\u00020\u00068VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0015\u0010\u0016R\u0012\u0010\b\u001a\u0004\u0018\u00010\tX\u0082\u000e¢\u0006\u0004\n\u0002\u0010\u0012R\u001e\u0010\n\u001a\u0012\u0012\u0004\u0012\u00020\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u0007\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u001e\u0010\u000b\u001a\u0012\u0012\u0004\u0012\u00020\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u0007\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0017\u001a\u0004\u0018\u00010\u0018X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006$"}, d2 = {"Lcom/apollographql/apollo3/network/ws/GraphQLWsProtocol$Factory;", "Lcom/apollographql/apollo3/network/ws/WsProtocol$Factory;", "connectionPayload", "Lkotlin/Function1;", "Lkotlin/coroutines/Continuation;", "", "", "", "pingIntervalMillis", "", "pingPayload", "pongPayload", "connectionAcknowledgeTimeoutMs", "frameType", "Lcom/apollographql/apollo3/network/ws/WsFrameType;", "(Lkotlin/jvm/functions/Function1;JLjava/util/Map;Ljava/util/Map;JLcom/apollographql/apollo3/network/ws/WsFrameType;)V", "(Ljava/util/Map;JLjava/util/Map;Ljava/util/Map;JLcom/apollographql/apollo3/network/ws/WsFrameType;)V", "()V", "Ljava/lang/Long;", "Lkotlin/jvm/functions/Function1;", "name", "getName", "()Ljava/lang/String;", "webSocketPayloadComposer", "Lcom/apollographql/apollo3/api/http/WebSocketPayloadComposer;", "connectionAcknowledgeTimeoutMillis", "", "(Lkotlin/jvm/functions/Function1;)V", PasskeyWebListener.CREATE_UNIQUE_KEY, "Lcom/apollographql/apollo3/network/ws/WsProtocol;", "webSocketConnection", "Lcom/apollographql/apollo3/network/ws/WebSocketConnection;", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "Lcom/apollographql/apollo3/network/ws/WsProtocol$Listener;", "scope", "Lkotlinx/coroutines/CoroutineScope;", "apollo-runtime"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class Factory implements WsProtocol.Factory {
        private Long connectionAcknowledgeTimeoutMs;
        private Function1<? super Continuation<? super Map<String, ? extends Object>>, ? extends Object> connectionPayload;
        private WsFrameType frameType;
        private Long pingIntervalMillis;
        private Map<String, ? extends Object> pingPayload;
        private Map<String, ? extends Object> pongPayload;
        private WebSocketPayloadComposer webSocketPayloadComposer;

        public Factory() {
        }

        /* JADX INFO: renamed from: com.apollographql.apollo3.network.ws.GraphQLWsProtocol$Factory$1, reason: invalid class name */
        /* JADX INFO: compiled from: GraphQLWsProtocol.kt */
        @Metadata(d1 = {"\u0000\u0006\n\u0000\n\u0002\u0010\u0001\u0010\u0000\u001a\u0004\u0018\u00010\u0001H\u008a@"}, d2 = {"<anonymous>", ""}, k = 3, mv = {1, 5, 1}, xi = 48)
        @DebugMetadata(c = "com.apollographql.apollo3.network.ws.GraphQLWsProtocol$Factory$1", f = "GraphQLWsProtocol.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
        static final class AnonymousClass1 extends SuspendLambda implements Function1<Continuation, Object> {
            int label;

            AnonymousClass1(Continuation<? super AnonymousClass1> continuation) {
                super(1, continuation);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation<Unit> create(Continuation<?> continuation) {
                return new AnonymousClass1(continuation);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Continuation continuation) {
                return ((AnonymousClass1) create(continuation)).invokeSuspend(Unit.INSTANCE);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object obj) {
                IntrinsicsKt.getCOROUTINE_SUSPENDED();
                if (this.label != 0) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
                return null;
            }
        }

        public /* synthetic */ Factory(AnonymousClass1 anonymousClass1, long j, Map map, Map map2, long j2, WsFrameType wsFrameType, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((Function1<? super Continuation<? super Map<String, ? extends Object>>, ? extends Object>) ((i & 1) != 0 ? new AnonymousClass1(null) : anonymousClass1), (i & 2) != 0 ? -1L : j, (Map<String, ? extends Object>) ((i & 4) != 0 ? null : map), (Map<String, ? extends Object>) ((i & 8) != 0 ? null : map2), (i & 16) != 0 ? 10000L : j2, (i & 32) != 0 ? WsFrameType.Text : wsFrameType);
        }

        /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
        public Factory(Function1<? super Continuation<? super Map<String, ? extends Object>>, ? extends Object> connectionPayload, long j, Map<String, ? extends Object> map, Map<String, ? extends Object> map2, long j2, WsFrameType frameType) {
            this();
            Intrinsics.checkNotNullParameter(connectionPayload, "connectionPayload");
            Intrinsics.checkNotNullParameter(frameType, "frameType");
            this.connectionPayload = connectionPayload;
            this.pingIntervalMillis = Long.valueOf(j);
            this.pingPayload = map;
            this.pongPayload = map2;
            this.connectionAcknowledgeTimeoutMs = Long.valueOf(j2);
            this.frameType = frameType;
        }

        public final void connectionPayload(Function1<? super Continuation<? super Map<String, ? extends Object>>, ? extends Object> connectionPayload) {
            Intrinsics.checkNotNullParameter(connectionPayload, "connectionPayload");
            this.connectionPayload = connectionPayload;
        }

        public final void pingIntervalMillis(long pingIntervalMillis) {
            this.pingIntervalMillis = Long.valueOf(pingIntervalMillis);
        }

        public final void pingPayload(Map<String, ? extends Object> pingPayload) {
            this.pingPayload = pingPayload;
        }

        public final void pongPayload(Map<String, ? extends Object> pongPayload) {
            this.pongPayload = pongPayload;
        }

        public final void connectionAcknowledgeTimeoutMillis(long connectionAcknowledgeTimeoutMillis) {
            this.connectionAcknowledgeTimeoutMs = Long.valueOf(connectionAcknowledgeTimeoutMillis);
        }

        public final void frameType(WsFrameType frameType) {
            Intrinsics.checkNotNullParameter(frameType, "frameType");
            this.frameType = frameType;
        }

        public final void webSocketPayloadComposer(WebSocketPayloadComposer webSocketPayloadComposer) {
            Intrinsics.checkNotNullParameter(webSocketPayloadComposer, "webSocketPayloadComposer");
            this.webSocketPayloadComposer = webSocketPayloadComposer;
        }

        public /* synthetic */ Factory(Map map, long j, Map map2, Map map3, long j2, WsFrameType wsFrameType, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((Map<String, ? extends Object>) map, (i & 2) != 0 ? -1L : j, (Map<String, ? extends Object>) ((i & 4) != 0 ? null : map2), (Map<String, ? extends Object>) ((i & 8) == 0 ? map3 : null), (i & 16) != 0 ? 10000L : j2, (i & 32) != 0 ? WsFrameType.Text : wsFrameType);
        }

        /* JADX INFO: renamed from: com.apollographql.apollo3.network.ws.GraphQLWsProtocol$Factory$2, reason: invalid class name */
        /* JADX INFO: compiled from: GraphQLWsProtocol.kt */
        @Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0010\u0000\u0010\u0000\u001a\u0012\u0012\u0004\u0012\u00020\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0018\u00010\u0001H\u008a@"}, d2 = {"<anonymous>", "", "", ""}, k = 3, mv = {1, 5, 1}, xi = 48)
        @DebugMetadata(c = "com.apollographql.apollo3.network.ws.GraphQLWsProtocol$Factory$2", f = "GraphQLWsProtocol.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
        static final class AnonymousClass2 extends SuspendLambda implements Function1<Continuation<? super Map<String, ? extends Object>>, Object> {
            final /* synthetic */ Map<String, Object> $connectionPayload;
            int label;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            AnonymousClass2(Map<String, ? extends Object> map, Continuation<? super AnonymousClass2> continuation) {
                super(1, continuation);
                this.$connectionPayload = map;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation<Unit> create(Continuation<?> continuation) {
                return new AnonymousClass2(this.$connectionPayload, continuation);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Continuation<? super Map<String, ? extends Object>> continuation) {
                return ((AnonymousClass2) create(continuation)).invokeSuspend(Unit.INSTANCE);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object obj) {
                IntrinsicsKt.getCOROUTINE_SUSPENDED();
                if (this.label != 0) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
                return this.$connectionPayload;
            }
        }

        /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
        @Deprecated(message = "Use the constructor with connectionPayload as a lambda instead", replaceWith = @ReplaceWith(expression = "Factory({ connectionPayload }, pingIntervalMillis, pingPayload, pongPayload, connectionAcknowledgeTimeoutMs)", imports = {}))
        public Factory(Map<String, ? extends Object> map, long j, Map<String, ? extends Object> map2, Map<String, ? extends Object> map3, long j2, WsFrameType frameType) {
            this(new AnonymousClass2(map, null), j, map2, map3, j2, frameType);
            Intrinsics.checkNotNullParameter(frameType, "frameType");
        }

        @Override // com.apollographql.apollo3.network.ws.WsProtocol.Factory
        public String getName() {
            return "graphql-transport-ws";
        }

        @Override // com.apollographql.apollo3.network.ws.WsProtocol.Factory
        public WsProtocol create(WebSocketConnection webSocketConnection, WsProtocol.Listener listener, CoroutineScope scope) {
            Intrinsics.checkNotNullParameter(webSocketConnection, "webSocketConnection");
            Intrinsics.checkNotNullParameter(listener, "listener");
            Intrinsics.checkNotNullParameter(scope, "scope");
            GraphQLWsProtocol$Factory$create$connectionPayload$1 graphQLWsProtocol$Factory$create$connectionPayload$1 = this.connectionPayload;
            if (graphQLWsProtocol$Factory$create$connectionPayload$1 == null) {
                graphQLWsProtocol$Factory$create$connectionPayload$1 = new GraphQLWsProtocol$Factory$create$connectionPayload$1(null);
            }
            Function1<? super Continuation<? super Map<String, ? extends Object>>, ? extends Object> function1 = graphQLWsProtocol$Factory$create$connectionPayload$1;
            Long l = this.connectionAcknowledgeTimeoutMs;
            long jLongValue = l != null ? l.longValue() : 10000L;
            Long l2 = this.pingIntervalMillis;
            long jLongValue2 = l2 != null ? l2.longValue() : -1L;
            WsFrameType wsFrameType = this.frameType;
            if (wsFrameType == null) {
                wsFrameType = WsFrameType.Text;
            }
            WsFrameType wsFrameType2 = wsFrameType;
            Map<String, ? extends Object> map = this.pingPayload;
            Map<String, ? extends Object> map2 = this.pongPayload;
            DefaultWebSocketPayloadComposer defaultWebSocketPayloadComposer = this.webSocketPayloadComposer;
            if (defaultWebSocketPayloadComposer == null) {
                defaultWebSocketPayloadComposer = new DefaultWebSocketPayloadComposer();
            }
            return new GraphQLWsProtocol(function1, map, map2, jLongValue, jLongValue2, wsFrameType2, webSocketConnection, listener, scope, defaultWebSocketPayloadComposer);
        }
    }
}
