package com.apollographql.apollo3.network.ws;

import com.apollographql.apollo3.api.Adapters;
import com.apollographql.apollo3.api.ApolloRequest;
import com.apollographql.apollo3.api.CustomScalarAdapters;
import com.apollographql.apollo3.api.Operation;
import com.apollographql.apollo3.api.json.BufferedSinkJsonWriter;
import com.apollographql.apollo3.api.json.BufferedSourceJsonReader;
import com.apollographql.apollo3.api.json.JsonWriters;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.microsoft.identity.common.internal.providers.oauth2.PasskeyWebListener;
import external.sdk.pendo.io.mozilla.javascript.Token;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import okio.Buffer;
import okio.ByteString;
import org.apache.hc.core5.http.HeaderElements;

/* JADX INFO: compiled from: WsProtocol.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b&\u0018\u00002\u00020\u0001:\u0002$%B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\b\u0010\u000b\u001a\u00020\fH\u0016J\u000e\u0010\r\u001a\u00020\fH¦@¢\u0006\u0002\u0010\u000eJ\u001e\u0010\u000f\u001a\u00020\f2\u0014\u0010\u0010\u001a\u0010\u0012\u0004\u0012\u00020\u0012\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0011H&J\u001c\u0010\u0013\u001a\u0010\u0012\u0004\u0012\u00020\u0012\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0011H\u0084@¢\u0006\u0002\u0010\u000eJ\u000e\u0010\u0014\u001a\u00020\fH\u0096@¢\u0006\u0002\u0010\u000eJ&\u0010\u0015\u001a\u00020\f2\u0014\u0010\u0010\u001a\u0010\u0012\u0004\u0012\u00020\u0012\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u00112\u0006\u0010\u0016\u001a\u00020\u0017H\u0004J\u001e\u0010\u0018\u001a\u00020\f2\u0014\u0010\u0010\u001a\u0010\u0012\u0004\u0012\u00020\u0012\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0011H\u0004J\u001e\u0010\u0019\u001a\u00020\f2\u0014\u0010\u0010\u001a\u0010\u0012\u0004\u0012\u00020\u0012\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0011H\u0004J \u0010\u001a\u001a\u00020\f\"\b\b\u0000\u0010\u001b*\u00020\u001c2\f\u0010\u001d\u001a\b\u0012\u0004\u0012\u0002H\u001b0\u001eH&J \u0010\u001f\u001a\u00020\f\"\b\b\u0000\u0010\u001b*\u00020\u001c2\f\u0010\u001d\u001a\b\u0012\u0004\u0012\u0002H\u001b0\u001eH&J\u001a\u0010 \u001a\u00020!*\u0010\u0012\u0004\u0012\u00020\u0012\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0011H\u0004J\u001c\u0010\"\u001a\u0012\u0012\u0004\u0012\u00020\u0012\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0018\u00010\u0011*\u00020\u0012H\u0004J\u001a\u0010#\u001a\u00020\u0012*\u0010\u0012\u0004\u0012\u00020\u0012\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0011H\u0004R\u0014\u0010\u0004\u001a\u00020\u0005X\u0084\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0014\u0010\u0002\u001a\u00020\u0003X\u0084\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006&"}, d2 = {"Lcom/apollographql/apollo3/network/ws/WsProtocol;", "", "webSocketConnection", "Lcom/apollographql/apollo3/network/ws/WebSocketConnection;", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "Lcom/apollographql/apollo3/network/ws/WsProtocol$Listener;", "(Lcom/apollographql/apollo3/network/ws/WebSocketConnection;Lcom/apollographql/apollo3/network/ws/WsProtocol$Listener;)V", "getListener", "()Lcom/apollographql/apollo3/network/ws/WsProtocol$Listener;", "getWebSocketConnection", "()Lcom/apollographql/apollo3/network/ws/WebSocketConnection;", HeaderElements.CLOSE, "", "connectionInit", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "handleServerMessage", "messageMap", "", "", "receiveMessageMap", "run", "sendMessageMap", "frameType", "Lcom/apollographql/apollo3/network/ws/WsFrameType;", "sendMessageMapBinary", "sendMessageMapText", "startOperation", "D", "Lcom/apollographql/apollo3/api/Operation$Data;", "request", "Lcom/apollographql/apollo3/api/ApolloRequest;", "stopOperation", "toByteString", "Lokio/ByteString;", "toMessageMap", "toUtf8", "Factory", "Listener", "apollo-runtime"}, k = 1, mv = {1, 5, 1}, xi = 48)
public abstract class WsProtocol {
    private final Listener listener;
    private final WebSocketConnection webSocketConnection;

    /* JADX INFO: compiled from: WsProtocol.kt */
    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J \u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rH&R\u0012\u0010\u0002\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005¨\u0006\u000e"}, d2 = {"Lcom/apollographql/apollo3/network/ws/WsProtocol$Factory;", "", "name", "", "getName", "()Ljava/lang/String;", PasskeyWebListener.CREATE_UNIQUE_KEY, "Lcom/apollographql/apollo3/network/ws/WsProtocol;", "webSocketConnection", "Lcom/apollographql/apollo3/network/ws/WebSocketConnection;", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "Lcom/apollographql/apollo3/network/ws/WsProtocol$Listener;", "scope", "Lkotlinx/coroutines/CoroutineScope;", "apollo-runtime"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public interface Factory {
        WsProtocol create(WebSocketConnection webSocketConnection, Listener listener, CoroutineScope scope);

        String getName();
    }

    /* JADX INFO: compiled from: WsProtocol.kt */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0003\n\u0002\b\u0005\bf\u0018\u00002\u00020\u0001J \u0010\u0002\u001a\u00020\u00032\u0016\u0010\u0004\u001a\u0012\u0012\u0004\u0012\u00020\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0018\u00010\u0005H&J\u0010\u0010\u0007\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\tH&J\u0010\u0010\n\u001a\u00020\u00032\u0006\u0010\u000b\u001a\u00020\u0006H&J(\u0010\f\u001a\u00020\u00032\u0006\u0010\u000b\u001a\u00020\u00062\u0016\u0010\u0004\u001a\u0012\u0012\u0004\u0012\u00020\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0018\u00010\u0005H&J&\u0010\r\u001a\u00020\u00032\u0006\u0010\u000b\u001a\u00020\u00062\u0014\u0010\u0004\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0005H&¨\u0006\u000e"}, d2 = {"Lcom/apollographql/apollo3/network/ws/WsProtocol$Listener;", "", "generalError", "", "payload", "", "", "networkError", "cause", "", "operationComplete", "id", "operationError", "operationResponse", "apollo-runtime"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public interface Listener {
        void generalError(Map<String, ? extends Object> payload);

        void networkError(Throwable cause);

        void operationComplete(String id);

        void operationError(String id, Map<String, ? extends Object> payload);

        void operationResponse(String id, Map<String, ? extends Object> payload);
    }

    /* JADX INFO: compiled from: WsProtocol.kt */
    @Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[WsFrameType.values().length];
            try {
                iArr[WsFrameType.Text.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[WsFrameType.Binary.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    /* JADX INFO: renamed from: com.apollographql.apollo3.network.ws.WsProtocol$receiveMessageMap$1, reason: invalid class name */
    /* JADX INFO: compiled from: WsProtocol.kt */
    @Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
    @DebugMetadata(c = "com.apollographql.apollo3.network.ws.WsProtocol", f = "WsProtocol.kt", i = {0}, l = {Token.LABEL}, m = "receiveMessageMap", n = {"this"}, s = {"L$0"})
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
            return WsProtocol.this.receiveMessageMap(this);
        }
    }

    /* JADX INFO: renamed from: com.apollographql.apollo3.network.ws.WsProtocol$run$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: WsProtocol.kt */
    @Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
    @DebugMetadata(c = "com.apollographql.apollo3.network.ws.WsProtocol", f = "WsProtocol.kt", i = {0}, l = {Token.DOTDOT}, m = "run$suspendImpl", n = {"$this"}, s = {"L$0"})
    static final class C09171 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        int label;
        /* synthetic */ Object result;

        C09171(Continuation<? super C09171> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return WsProtocol.run$suspendImpl(WsProtocol.this, this);
        }
    }

    public abstract Object connectionInit(Continuation<? super Unit> continuation);

    public abstract void handleServerMessage(Map<String, ? extends Object> messageMap);

    public Object run(Continuation<? super Unit> continuation) {
        return run$suspendImpl(this, continuation);
    }

    public abstract <D extends Operation.Data> void startOperation(ApolloRequest<D> request);

    public abstract <D extends Operation.Data> void stopOperation(ApolloRequest<D> request);

    public WsProtocol(WebSocketConnection webSocketConnection, Listener listener) {
        Intrinsics.checkNotNullParameter(webSocketConnection, "webSocketConnection");
        Intrinsics.checkNotNullParameter(listener, "listener");
        this.webSocketConnection = webSocketConnection;
        this.listener = listener;
    }

    protected final WebSocketConnection getWebSocketConnection() {
        return this.webSocketConnection;
    }

    protected final Listener getListener() {
        return this.listener;
    }

    protected final Map<String, Object> toMessageMap(String str) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        try {
            Object objFromJson = Adapters.AnyAdapter.fromJson(new BufferedSourceJsonReader(new Buffer().writeUtf8(str)), CustomScalarAdapters.Empty);
            if (objFromJson instanceof Map) {
                return (Map) objFromJson;
            }
        } catch (Exception unused) {
        }
        return null;
    }

    protected final void sendMessageMapBinary(Map<String, ? extends Object> messageMap) {
        Intrinsics.checkNotNullParameter(messageMap, "messageMap");
        this.webSocketConnection.send(toByteString(messageMap));
    }

    protected final void sendMessageMapText(Map<String, ? extends Object> messageMap) {
        Intrinsics.checkNotNullParameter(messageMap, "messageMap");
        this.webSocketConnection.send(toUtf8(messageMap));
    }

    protected final void sendMessageMap(Map<String, ? extends Object> messageMap, WsFrameType frameType) {
        Intrinsics.checkNotNullParameter(messageMap, "messageMap");
        Intrinsics.checkNotNullParameter(frameType, "frameType");
        int i = WhenMappings.$EnumSwitchMapping$0[frameType.ordinal()];
        if (i == 1) {
            sendMessageMapText(messageMap);
        } else {
            if (i != 2) {
                return;
            }
            sendMessageMapBinary(messageMap);
        }
    }

    /* JADX WARN: Code duplicated, block: B:17:0x004b A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:18:0x004c  */
    /* JADX WARN: Code duplicated, block: B:21:0x0055 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:22:0x0056  */
    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:18:0x004c -> B:19:0x004d). Please report as a decompilation issue!!! */
    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions stack size limit reached
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        */
    protected final java.lang.Object receiveMessageMap(kotlin.coroutines.Continuation<? super java.util.Map<java.lang.String, ? extends java.lang.Object>> r5) {
        /*
            r4 = this;
            boolean r0 = r5 instanceof com.apollographql.apollo3.network.ws.WsProtocol.AnonymousClass1
            if (r0 == 0) goto L14
            r0 = r5
            com.apollographql.apollo3.network.ws.WsProtocol$receiveMessageMap$1 r0 = (com.apollographql.apollo3.network.ws.WsProtocol.AnonymousClass1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L14
            int r5 = r0.label
            int r5 = r5 - r2
            r0.label = r5
            goto L19
        L14:
            com.apollographql.apollo3.network.ws.WsProtocol$receiveMessageMap$1 r0 = new com.apollographql.apollo3.network.ws.WsProtocol$receiveMessageMap$1
            r0.<init>(r5)
        L19:
            java.lang.Object r5 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L3a
            if (r2 != r3) goto L32
            java.lang.Object r4 = r0.L$1
            com.apollographql.apollo3.network.ws.WsProtocol r4 = (com.apollographql.apollo3.network.ws.WsProtocol) r4
            java.lang.Object r2 = r0.L$0
            com.apollographql.apollo3.network.ws.WsProtocol r2 = (com.apollographql.apollo3.network.ws.WsProtocol) r2
            kotlin.ResultKt.throwOnFailure(r5)
            goto L4d
        L32:
            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
            java.lang.String r5 = "call to 'resume' before 'invoke' with coroutine"
            r4.<init>(r5)
            throw r4
        L3a:
            kotlin.ResultKt.throwOnFailure(r5)
        L3d:
            com.apollographql.apollo3.network.ws.WebSocketConnection r5 = r4.webSocketConnection
            r0.L$0 = r4
            r0.L$1 = r4
            r0.label = r3
            java.lang.Object r5 = r5.receive(r0)
            if (r5 != r1) goto L4c
            return r1
        L4c:
            r2 = r4
        L4d:
            java.lang.String r5 = (java.lang.String) r5
            java.util.Map r4 = r4.toMessageMap(r5)
            if (r4 == 0) goto L56
            return r4
        L56:
            r4 = r2
            goto L3d
        */
        throw new UnsupportedOperationException("Method not decompiled: com.apollographql.apollo3.network.ws.WsProtocol.receiveMessageMap(kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARN: Code duplicated, block: B:21:0x004b A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:22:0x004c  */
    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:22:0x004c -> B:23:0x004d). Please report as a decompilation issue!!! */
    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions stack size limit reached
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        */
    static /* synthetic */ java.lang.Object run$suspendImpl(com.apollographql.apollo3.network.ws.WsProtocol r4, kotlin.coroutines.Continuation<? super kotlin.Unit> r5) {
        /*
            boolean r0 = r5 instanceof com.apollographql.apollo3.network.ws.WsProtocol.C09171
            if (r0 == 0) goto L14
            r0 = r5
            com.apollographql.apollo3.network.ws.WsProtocol$run$1 r0 = (com.apollographql.apollo3.network.ws.WsProtocol.C09171) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L14
            int r5 = r0.label
            int r5 = r5 - r2
            r0.label = r5
            goto L19
        L14:
            com.apollographql.apollo3.network.ws.WsProtocol$run$1 r0 = new com.apollographql.apollo3.network.ws.WsProtocol$run$1
            r0.<init>(r5)
        L19:
            java.lang.Object r5 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L3c
            if (r2 != r3) goto L34
            java.lang.Object r4 = r0.L$1
            com.apollographql.apollo3.network.ws.WsProtocol r4 = (com.apollographql.apollo3.network.ws.WsProtocol) r4
            java.lang.Object r2 = r0.L$0
            com.apollographql.apollo3.network.ws.WsProtocol r2 = (com.apollographql.apollo3.network.ws.WsProtocol) r2
            kotlin.ResultKt.throwOnFailure(r5)     // Catch: java.lang.Exception -> L32 java.util.concurrent.CancellationException -> L61
            goto L4d
        L32:
            r4 = move-exception
            goto L57
        L34:
            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
            java.lang.String r5 = "call to 'resume' before 'invoke' with coroutine"
            r4.<init>(r5)
            throw r4
        L3c:
            kotlin.ResultKt.throwOnFailure(r5)
        L3f:
            r0.L$0 = r4     // Catch: java.lang.Exception -> L54 java.util.concurrent.CancellationException -> L61
            r0.L$1 = r4     // Catch: java.lang.Exception -> L54 java.util.concurrent.CancellationException -> L61
            r0.label = r3     // Catch: java.lang.Exception -> L54 java.util.concurrent.CancellationException -> L61
            java.lang.Object r5 = r4.receiveMessageMap(r0)     // Catch: java.lang.Exception -> L54 java.util.concurrent.CancellationException -> L61
            if (r5 != r1) goto L4c
            return r1
        L4c:
            r2 = r4
        L4d:
            java.util.Map r5 = (java.util.Map) r5     // Catch: java.lang.Exception -> L32 java.util.concurrent.CancellationException -> L61
            r4.handleServerMessage(r5)     // Catch: java.lang.Exception -> L32 java.util.concurrent.CancellationException -> L61
            r4 = r2
            goto L3f
        L54:
            r5 = move-exception
            r2 = r4
            r4 = r5
        L57:
            com.apollographql.apollo3.network.ws.WsProtocol$Listener r5 = r2.listener
            java.lang.Throwable r4 = (java.lang.Throwable) r4
            r5.networkError(r4)
            kotlin.Unit r4 = kotlin.Unit.INSTANCE
            return r4
        L61:
            r4 = move-exception
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.apollographql.apollo3.network.ws.WsProtocol.run$suspendImpl(com.apollographql.apollo3.network.ws.WsProtocol, kotlin.coroutines.Continuation):java.lang.Object");
    }

    public void close() {
        this.webSocketConnection.close();
    }

    protected final ByteString toByteString(Map<String, ? extends Object> map) {
        Intrinsics.checkNotNullParameter(map, "<this>");
        Buffer buffer = new Buffer();
        JsonWriters.writeAny(new BufferedSinkJsonWriter(buffer, null), map);
        return buffer.readByteString();
    }

    protected final String toUtf8(Map<String, ? extends Object> map) {
        Intrinsics.checkNotNullParameter(map, "<this>");
        Buffer buffer = new Buffer();
        JsonWriters.writeAny(new BufferedSinkJsonWriter(buffer, null), map);
        return buffer.readUtf8();
    }
}
