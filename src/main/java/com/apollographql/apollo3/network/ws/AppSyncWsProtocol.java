package com.apollographql.apollo3.network.ws;

import com.apollographql.apollo3.api.Adapters;
import com.apollographql.apollo3.api.ApolloRequest;
import com.apollographql.apollo3.api.CustomScalarAdapters;
import com.apollographql.apollo3.api.Operation;
import com.apollographql.apollo3.api.http.DefaultHttpRequestComposer;
import com.apollographql.apollo3.api.json.BufferedSinkJsonWriter;
import com.apollographql.apollo3.api.json.JsonWriters;
import com.apollographql.apollo3.exception.ApolloNetworkException;
import com.box.android.domain.analytics.BoxAnalyticsParams;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.microsoft.identity.common.internal.providers.oauth2.PasskeyWebListener;
import java.util.Map;
import kotlin.Metadata;
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
import kotlinx.coroutines.CoroutineScope;
import okio.Buffer;

/* JADX INFO: compiled from: AppSyncWsProtocol.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 \u001d2\u00020\u0001:\u0002\u001d\u001eB5\b\u0016\u0012\u0014\u0010\u0002\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b¢\u0006\u0002\u0010\fBM\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012.\b\u0002\u0010\r\u001a(\b\u0001\u0012\u001a\u0012\u0018\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u0005\u0018\u00010\u00030\u000f\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u000e\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b¢\u0006\u0002\u0010\u0010J\u000e\u0010\u0012\u001a\u00020\u0013H\u0096@¢\u0006\u0002\u0010\u0014J\u001e\u0010\u0015\u001a\u00020\u00132\u0014\u0010\u0016\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u0003H\u0016J \u0010\u0017\u001a\u00020\u0013\"\b\b\u0000\u0010\u0018*\u00020\u00192\f\u0010\u001a\u001a\b\u0012\u0004\u0012\u0002H\u00180\u001bH\u0016J \u0010\u001c\u001a\u00020\u0013\"\b\b\u0000\u0010\u0018*\u00020\u00192\f\u0010\u001a\u001a\b\u0012\u0004\u0012\u0002H\u00180\u001bH\u0016R\u001e\u0010\u0002\u001a\u0012\u0012\u0004\u0012\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u0005\u0018\u00010\u0003X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R6\u0010\r\u001a(\b\u0001\u0012\u001a\u0012\u0018\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u0005\u0018\u00010\u00030\u000f\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u000eX\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0011¨\u0006\u001f"}, d2 = {"Lcom/apollographql/apollo3/network/ws/AppSyncWsProtocol;", "Lcom/apollographql/apollo3/network/ws/WsProtocol;", "authorization", "", "", "", "connectionAcknowledgeTimeoutMs", "", "webSocketConnection", "Lcom/apollographql/apollo3/network/ws/WebSocketConnection;", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "Lcom/apollographql/apollo3/network/ws/WsProtocol$Listener;", "(Ljava/util/Map;JLcom/apollographql/apollo3/network/ws/WebSocketConnection;Lcom/apollographql/apollo3/network/ws/WsProtocol$Listener;)V", "connectionPayload", "Lkotlin/Function1;", "Lkotlin/coroutines/Continuation;", "(JLkotlin/jvm/functions/Function1;Lcom/apollographql/apollo3/network/ws/WebSocketConnection;Lcom/apollographql/apollo3/network/ws/WsProtocol$Listener;)V", "Lkotlin/jvm/functions/Function1;", "connectionInit", "", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "handleServerMessage", "messageMap", "startOperation", "D", "Lcom/apollographql/apollo3/api/Operation$Data;", "request", "Lcom/apollographql/apollo3/api/ApolloRequest;", "stopOperation", "Companion", "Factory", "apollo-runtime"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class AppSyncWsProtocol extends WsProtocol {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private Map<String, ? extends Object> authorization;
    private final long connectionAcknowledgeTimeoutMs;
    private final Function1<Continuation<? super Map<String, ? extends Object>>, Object> connectionPayload;

    /* JADX INFO: renamed from: com.apollographql.apollo3.network.ws.AppSyncWsProtocol$connectionInit$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: AppSyncWsProtocol.kt */
    @Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
    @DebugMetadata(c = "com.apollographql.apollo3.network.ws.AppSyncWsProtocol", f = "AppSyncWsProtocol.kt", i = {0}, l = {41, 43}, m = "connectionInit", n = {"this"}, s = {"L$0"})
    static final class C09081 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        int label;
        /* synthetic */ Object result;

        C09081(Continuation<? super C09081> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return AppSyncWsProtocol.this.connectionInit(this);
        }
    }

    /* JADX INFO: renamed from: com.apollographql.apollo3.network.ws.AppSyncWsProtocol$1, reason: invalid class name */
    /* JADX INFO: compiled from: AppSyncWsProtocol.kt */
    @Metadata(d1 = {"\u0000\u0006\n\u0000\n\u0002\u0010\u0001\u0010\u0000\u001a\u0004\u0018\u00010\u0001H\u008a@"}, d2 = {"<anonymous>", ""}, k = 3, mv = {1, 5, 1}, xi = 48)
    @DebugMetadata(c = "com.apollographql.apollo3.network.ws.AppSyncWsProtocol$1", f = "AppSyncWsProtocol.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
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

    public /* synthetic */ AppSyncWsProtocol(long j, AnonymousClass1 anonymousClass1, WebSocketConnection webSocketConnection, WsProtocol.Listener listener, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(j, (Function1<? super Continuation<? super Map<String, ? extends Object>>, ? extends Object>) ((i & 2) != 0 ? new AnonymousClass1(null) : anonymousClass1), webSocketConnection, listener);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public AppSyncWsProtocol(long j, Function1<? super Continuation<? super Map<String, ? extends Object>>, ? extends Object> connectionPayload, WebSocketConnection webSocketConnection, WsProtocol.Listener listener) {
        super(webSocketConnection, listener);
        Intrinsics.checkNotNullParameter(connectionPayload, "connectionPayload");
        Intrinsics.checkNotNullParameter(webSocketConnection, "webSocketConnection");
        Intrinsics.checkNotNullParameter(listener, "listener");
        this.connectionAcknowledgeTimeoutMs = j;
        this.connectionPayload = connectionPayload;
    }

    /* JADX INFO: renamed from: com.apollographql.apollo3.network.ws.AppSyncWsProtocol$2, reason: invalid class name */
    /* JADX INFO: compiled from: AppSyncWsProtocol.kt */
    @Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0010\u0000\u0010\u0000\u001a\u0012\u0012\u0004\u0012\u00020\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0018\u00010\u0001H\u008a@"}, d2 = {"<anonymous>", "", "", ""}, k = 3, mv = {1, 5, 1}, xi = 48)
    @DebugMetadata(c = "com.apollographql.apollo3.network.ws.AppSyncWsProtocol$2", f = "AppSyncWsProtocol.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    static final class AnonymousClass2 extends SuspendLambda implements Function1<Continuation<? super Map<String, ? extends Object>>, Object> {
        final /* synthetic */ Map<String, Object> $authorization;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass2(Map<String, ? extends Object> map, Continuation<? super AnonymousClass2> continuation) {
            super(1, continuation);
            this.$authorization = map;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Continuation<?> continuation) {
            return new AnonymousClass2(this.$authorization, continuation);
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
            return this.$authorization;
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public AppSyncWsProtocol(Map<String, ? extends Object> authorization, long j, WebSocketConnection webSocketConnection, WsProtocol.Listener listener) {
        this(j, new AnonymousClass2(authorization, null), webSocketConnection, listener);
        Intrinsics.checkNotNullParameter(authorization, "authorization");
        Intrinsics.checkNotNullParameter(webSocketConnection, "webSocketConnection");
        Intrinsics.checkNotNullParameter(listener, "listener");
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x0081, code lost:
    
        if (kotlinx.coroutines.TimeoutKt.withTimeout(r6, r4, r0) == r1) goto L22;
     */
    @Override // com.apollographql.apollo3.network.ws.WsProtocol
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.Object connectionInit(kotlin.coroutines.Continuation<? super kotlin.Unit> r7) {
        /*
            r6 = this;
            boolean r0 = r7 instanceof com.apollographql.apollo3.network.ws.AppSyncWsProtocol.C09081
            if (r0 == 0) goto L14
            r0 = r7
            com.apollographql.apollo3.network.ws.AppSyncWsProtocol$connectionInit$1 r0 = (com.apollographql.apollo3.network.ws.AppSyncWsProtocol.C09081) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L14
            int r7 = r0.label
            int r7 = r7 - r2
            r0.label = r7
            goto L19
        L14:
            com.apollographql.apollo3.network.ws.AppSyncWsProtocol$connectionInit$1 r0 = new com.apollographql.apollo3.network.ws.AppSyncWsProtocol$connectionInit$1
            r0.<init>(r7)
        L19:
            java.lang.Object r7 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 2
            r4 = 1
            if (r2 == 0) goto L41
            if (r2 == r4) goto L35
            if (r2 != r3) goto L2d
            kotlin.ResultKt.throwOnFailure(r7)
            goto L84
        L2d:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r7)
            throw r6
        L35:
            java.lang.Object r6 = r0.L$1
            com.apollographql.apollo3.network.ws.AppSyncWsProtocol r6 = (com.apollographql.apollo3.network.ws.AppSyncWsProtocol) r6
            java.lang.Object r2 = r0.L$0
            com.apollographql.apollo3.network.ws.AppSyncWsProtocol r2 = (com.apollographql.apollo3.network.ws.AppSyncWsProtocol) r2
            kotlin.ResultKt.throwOnFailure(r7)
            goto L69
        L41:
            kotlin.ResultKt.throwOnFailure(r7)
            kotlin.Pair[] r7 = new kotlin.Pair[r4]
            java.lang.String r2 = "type"
            java.lang.String r5 = "connection_init"
            kotlin.Pair r2 = kotlin.TuplesKt.to(r2, r5)
            r5 = 0
            r7[r5] = r2
            java.util.Map r7 = kotlin.collections.MapsKt.mutableMapOf(r7)
            r6.sendMessageMapText(r7)
            kotlin.jvm.functions.Function1<kotlin.coroutines.Continuation<? super java.util.Map<java.lang.String, ? extends java.lang.Object>>, java.lang.Object> r7 = r6.connectionPayload
            r0.L$0 = r6
            r0.L$1 = r6
            r0.label = r4
            java.lang.Object r7 = r7.invoke(r0)
            if (r7 != r1) goto L68
            goto L83
        L68:
            r2 = r6
        L69:
            java.util.Map r7 = (java.util.Map) r7
            r6.authorization = r7
            long r6 = r2.connectionAcknowledgeTimeoutMs
            com.apollographql.apollo3.network.ws.AppSyncWsProtocol$connectionInit$2 r4 = new com.apollographql.apollo3.network.ws.AppSyncWsProtocol$connectionInit$2
            r5 = 0
            r4.<init>(r5)
            kotlin.jvm.functions.Function2 r4 = (kotlin.jvm.functions.Function2) r4
            r0.L$0 = r5
            r0.L$1 = r5
            r0.label = r3
            java.lang.Object r6 = kotlinx.coroutines.TimeoutKt.withTimeout(r6, r4, r0)
            if (r6 != r1) goto L84
        L83:
            return r1
        L84:
            kotlin.Unit r6 = kotlin.Unit.INSTANCE
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.apollographql.apollo3.network.ws.AppSyncWsProtocol.connectionInit(kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX INFO: renamed from: com.apollographql.apollo3.network.ws.AppSyncWsProtocol$connectionInit$2, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: AppSyncWsProtocol.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 5, 1}, xi = 48)
    @DebugMetadata(c = "com.apollographql.apollo3.network.ws.AppSyncWsProtocol$connectionInit$2", f = "AppSyncWsProtocol.kt", i = {}, l = {44}, m = "invokeSuspend", n = {}, s = {})
    static final class C09092 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;

        C09092(Continuation<? super C09092> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return AppSyncWsProtocol.this.new C09092(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C09092) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                this.label = 1;
                obj = AppSyncWsProtocol.this.receiveMessageMap(this);
                if (obj == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
            Map map = (Map) obj;
            Object obj2 = map.get("type");
            if (Intrinsics.areEqual(obj2, "connection_ack")) {
                return Unit.INSTANCE;
            }
            if (Intrinsics.areEqual(obj2, "connection_error")) {
                throw new ApolloNetworkException("Connection error:\n" + map, null, 2, null);
            }
            System.out.println((Object) ("unknown AppSync message while waiting for connection_ack: '" + obj2));
            return Unit.INSTANCE;
        }
    }

    @Override // com.apollographql.apollo3.network.ws.WsProtocol
    public <D extends Operation.Data> void startOperation(ApolloRequest<D> request) {
        Intrinsics.checkNotNullParameter(request, "request");
        sendMessageMapText(MapsKt.mapOf(TuplesKt.to("type", "start"), TuplesKt.to("id", request.getRequestUuid().toString()), TuplesKt.to("payload", MapsKt.mapOf(TuplesKt.to("data", Adapters.m11193toJson$default(Adapters.NullableAnyAdapter, DefaultHttpRequestComposer.INSTANCE.composePayload(request), CustomScalarAdapters.Empty, null, 4, null)), TuplesKt.to("extensions", MapsKt.mapOf(TuplesKt.to("authorization", this.authorization)))))));
    }

    @Override // com.apollographql.apollo3.network.ws.WsProtocol
    public <D extends Operation.Data> void stopOperation(ApolloRequest<D> request) {
        Intrinsics.checkNotNullParameter(request, "request");
        sendMessageMapText(MapsKt.mapOf(TuplesKt.to("type", "stop"), TuplesKt.to("id", request.getRequestUuid().toString())));
    }

    @Override // com.apollographql.apollo3.network.ws.WsProtocol
    public void handleServerMessage(Map<String, ? extends Object> messageMap) {
        Intrinsics.checkNotNullParameter(messageMap, "messageMap");
        Object obj = messageMap.get("type");
        if (Intrinsics.areEqual(obj, "data")) {
            WsProtocol.Listener listener = getListener();
            Object obj2 = messageMap.get("id");
            Intrinsics.checkNotNull(obj2, "null cannot be cast to non-null type kotlin.String");
            Object obj3 = messageMap.get("payload");
            Intrinsics.checkNotNull(obj3, "null cannot be cast to non-null type kotlin.collections.Map<kotlin.String, kotlin.Any?>");
            listener.operationResponse((String) obj2, (Map) obj3);
            return;
        }
        if (Intrinsics.areEqual(obj, "error")) {
            Object obj4 = messageMap.get("id");
            if (obj4 instanceof String) {
                getListener().operationError((String) obj4, (Map) messageMap.get("payload"));
                return;
            } else {
                getListener().generalError((Map) messageMap.get("payload"));
                return;
            }
        }
        if (!Intrinsics.areEqual(obj, "complete")) {
            Intrinsics.areEqual(obj, "ka");
            return;
        }
        WsProtocol.Listener listener2 = getListener();
        Object obj5 = messageMap.get("id");
        Intrinsics.checkNotNull(obj5, "null cannot be cast to non-null type kotlin.String");
        listener2.operationComplete((String) obj5);
    }

    /* JADX INFO: compiled from: AppSyncWsProtocol.kt */
    @Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B'\b\u0016\u0012\u0014\u0010\u0002\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u0003\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bB?\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012.\b\u0002\u0010\t\u001a(\b\u0001\u0012\u001a\u0012\u0018\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u0005\u0018\u00010\u00030\u000b\u0012\u0006\u0012\u0004\u0018\u00010\u00050\n¢\u0006\u0002\u0010\fJ \u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0018H\u0016R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R6\u0010\t\u001a(\b\u0001\u0012\u001a\u0012\u0018\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u0005\u0018\u00010\u00030\u000b\u0012\u0006\u0012\u0004\u0018\u00010\u00050\nX\u0082\u0004¢\u0006\u0004\n\u0002\u0010\rR\u0014\u0010\u000e\u001a\u00020\u00048VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u000f\u0010\u0010¨\u0006\u0019"}, d2 = {"Lcom/apollographql/apollo3/network/ws/AppSyncWsProtocol$Factory;", "Lcom/apollographql/apollo3/network/ws/WsProtocol$Factory;", "authorization", "", "", "", "connectionAcknowledgeTimeoutMs", "", "(Ljava/util/Map;J)V", "connectionPayload", "Lkotlin/Function1;", "Lkotlin/coroutines/Continuation;", "(JLkotlin/jvm/functions/Function1;)V", "Lkotlin/jvm/functions/Function1;", "name", "getName", "()Ljava/lang/String;", PasskeyWebListener.CREATE_UNIQUE_KEY, "Lcom/apollographql/apollo3/network/ws/WsProtocol;", "webSocketConnection", "Lcom/apollographql/apollo3/network/ws/WebSocketConnection;", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "Lcom/apollographql/apollo3/network/ws/WsProtocol$Listener;", "scope", "Lkotlinx/coroutines/CoroutineScope;", "apollo-runtime"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class Factory implements WsProtocol.Factory {
        private final long connectionAcknowledgeTimeoutMs;
        private final Function1<Continuation<? super Map<String, ? extends Object>>, Object> connectionPayload;

        public Factory() {
            this(0L, (Function1) null, 3, (DefaultConstructorMarker) null);
        }

        /* JADX WARN: Multi-variable type inference failed */
        public Factory(long j, Function1<? super Continuation<? super Map<String, ? extends Object>>, ? extends Object> connectionPayload) {
            Intrinsics.checkNotNullParameter(connectionPayload, "connectionPayload");
            this.connectionAcknowledgeTimeoutMs = j;
            this.connectionPayload = connectionPayload;
        }

        /* JADX INFO: renamed from: com.apollographql.apollo3.network.ws.AppSyncWsProtocol$Factory$1, reason: invalid class name */
        /* JADX INFO: compiled from: AppSyncWsProtocol.kt */
        @Metadata(d1 = {"\u0000\u0006\n\u0000\n\u0002\u0010\u0001\u0010\u0000\u001a\u0004\u0018\u00010\u0001H\u008a@"}, d2 = {"<anonymous>", ""}, k = 3, mv = {1, 5, 1}, xi = 48)
        @DebugMetadata(c = "com.apollographql.apollo3.network.ws.AppSyncWsProtocol$Factory$1", f = "AppSyncWsProtocol.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
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

        public /* synthetic */ Factory(long j, AnonymousClass1 anonymousClass1, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? 10000L : j, (Function1<? super Continuation<? super Map<String, ? extends Object>>, ? extends Object>) ((i & 2) != 0 ? new AnonymousClass1(null) : anonymousClass1));
        }

        public /* synthetic */ Factory(Map map, long j, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((Map<String, ? extends Object>) map, (i & 2) != 0 ? 10000L : j);
        }

        /* JADX INFO: renamed from: com.apollographql.apollo3.network.ws.AppSyncWsProtocol$Factory$2, reason: invalid class name */
        /* JADX INFO: compiled from: AppSyncWsProtocol.kt */
        @Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0010\u0000\u0010\u0000\u001a\u0012\u0012\u0004\u0012\u00020\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0018\u00010\u0001H\u008a@"}, d2 = {"<anonymous>", "", "", ""}, k = 3, mv = {1, 5, 1}, xi = 48)
        @DebugMetadata(c = "com.apollographql.apollo3.network.ws.AppSyncWsProtocol$Factory$2", f = "AppSyncWsProtocol.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
        static final class AnonymousClass2 extends SuspendLambda implements Function1<Continuation<? super Map<String, ? extends Object>>, Object> {
            final /* synthetic */ Map<String, Object> $authorization;
            int label;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            AnonymousClass2(Map<String, ? extends Object> map, Continuation<? super AnonymousClass2> continuation) {
                super(1, continuation);
                this.$authorization = map;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation<Unit> create(Continuation<?> continuation) {
                return new AnonymousClass2(this.$authorization, continuation);
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
                return this.$authorization;
            }
        }

        /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
        public Factory(Map<String, ? extends Object> authorization, long j) {
            this(j, new AnonymousClass2(authorization, null));
            Intrinsics.checkNotNullParameter(authorization, "authorization");
        }

        @Override // com.apollographql.apollo3.network.ws.WsProtocol.Factory
        public String getName() {
            return "graphql-ws";
        }

        @Override // com.apollographql.apollo3.network.ws.WsProtocol.Factory
        public WsProtocol create(WebSocketConnection webSocketConnection, WsProtocol.Listener listener, CoroutineScope scope) {
            Intrinsics.checkNotNullParameter(webSocketConnection, "webSocketConnection");
            Intrinsics.checkNotNullParameter(listener, "listener");
            Intrinsics.checkNotNullParameter(scope, "scope");
            return new AppSyncWsProtocol(this.connectionAcknowledgeTimeoutMs, this.connectionPayload, webSocketConnection, listener);
        }
    }

    /* JADX INFO: compiled from: AppSyncWsProtocol.kt */
    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J<\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00042\u0014\u0010\u0006\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u00072\u0016\b\u0002\u0010\b\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0007J\u001a\u0010\t\u001a\u00020\u0004*\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0007H\u0002¨\u0006\n"}, d2 = {"Lcom/apollographql/apollo3/network/ws/AppSyncWsProtocol$Companion;", "", "()V", "buildUrl", "", "baseUrl", "authorization", "", "payload", "base64Encode", "apollo-runtime"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ String buildUrl$default(Companion companion, String str, Map map, Map map2, int i, Object obj) {
            if ((i & 4) != 0) {
                map2 = MapsKt.emptyMap();
            }
            return companion.buildUrl(str, map, map2);
        }

        public final String buildUrl(String baseUrl, Map<String, ? extends Object> authorization, Map<String, ? extends Object> payload) {
            Intrinsics.checkNotNullParameter(baseUrl, "baseUrl");
            Intrinsics.checkNotNullParameter(authorization, "authorization");
            Intrinsics.checkNotNullParameter(payload, "payload");
            return DefaultHttpRequestComposer.INSTANCE.appendQueryParameters(baseUrl, MapsKt.mapOf(TuplesKt.to(BoxAnalyticsParams.CTA_LOCATION_HEADER, base64Encode(authorization)), TuplesKt.to("payload", base64Encode(payload))));
        }

        private final String base64Encode(Map<String, ? extends Object> map) {
            Buffer buffer = new Buffer();
            JsonWriters.writeAny(new BufferedSinkJsonWriter(buffer, null), map);
            return buffer.readByteString().base64();
        }
    }
}
