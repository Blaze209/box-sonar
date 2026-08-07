package com.apollographql.apollo3.network.ws;

import androidx.exifinterface.media.ExifInterface;
import com.apollographql.apollo3.api.AdapterContext;
import com.apollographql.apollo3.api.ApolloRequest;
import com.apollographql.apollo3.api.ApolloResponse;
import com.apollographql.apollo3.api.CustomScalarAdapters;
import com.apollographql.apollo3.api.ExecutionContext;
import com.apollographql.apollo3.api.Operation;
import com.apollographql.apollo3.api.Operations;
import com.apollographql.apollo3.api.http.HttpHeader;
import com.apollographql.apollo3.api.json.JsonReaders;
import com.apollographql.apollo3.exception.ApolloNetworkException;
import com.apollographql.apollo3.exception.SubscriptionOperationException;
import com.apollographql.apollo3.internal.CloseableSingleThreadDispatcher;
import com.apollographql.apollo3.internal.DeferredJsonMerger;
import com.apollographql.apollo3.internal.DeferredJsonMergerKt;
import com.apollographql.apollo3.internal.FlowsKt;
import com.apollographql.apollo3.network.NetworkTransport;
import com.apollographql.apollo3.network.ws.internal.ConnectionReEstablished;
import com.apollographql.apollo3.network.ws.internal.Dispose;
import com.apollographql.apollo3.network.ws.internal.Event;
import com.apollographql.apollo3.network.ws.internal.GeneralError;
import com.apollographql.apollo3.network.ws.internal.Message;
import com.apollographql.apollo3.network.ws.internal.NetworkError;
import com.apollographql.apollo3.network.ws.internal.OperationComplete;
import com.apollographql.apollo3.network.ws.internal.OperationError;
import com.apollographql.apollo3.network.ws.internal.OperationResponse;
import com.apollographql.apollo3.network.ws.internal.StartOperation;
import com.apollographql.apollo3.network.ws.internal.StopOperation;
import com.box.android.common.utilities.BoxCommonConstants;
import com.box.android.preview.previewtype.boxnote.BoxNoteConstants;
import com.box.boxandroidlibv2private.dao.BoxConvertedPushNotificationDevice;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import external.sdk.pendo.io.mozilla.javascript.Token;
import java.io.Closeable;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CancellationException;
import kotlin.Deprecated;
import kotlin.ExceptionsKt;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.DelayKt;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.channels.BufferOverflow;
import kotlinx.coroutines.channels.Channel;
import kotlinx.coroutines.channels.ChannelKt;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.FlowKt;
import kotlinx.coroutines.flow.MutableSharedFlow;
import kotlinx.coroutines.flow.SharedFlow;
import kotlinx.coroutines.flow.SharedFlowKt;
import kotlinx.coroutines.flow.StateFlow;

/* JADX INFO: compiled from: WebSocketNetworkTransport.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000«\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005*\u0001 \u0018\u00002\u00020\u0001:\u0001<B\u008c\u0001\b\u0002\u0012\u001c\u0010\u0002\u001a\u0018\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u0003\u0012\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\b\u0012\b\b\u0002\u0010\n\u001a\u00020\u000b\u0012\b\b\u0002\u0010\f\u001a\u00020\r\u0012\b\b\u0002\u0010\u000e\u001a\u00020\u000f\u00129\u0010\u0010\u001a5\b\u0001\u0012\u0004\u0012\u00020\u0012\u0012\u0013\u0012\u00110\r¢\u0006\f\b\u0013\u0012\b\b\u0014\u0012\u0004\b\b(\u0015\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00160\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u0006\u0018\u00010\u0011¢\u0006\u0002\u0010\u0017J\u000e\u0010.\u001a\u00020/2\u0006\u00100\u001a\u00020\u0012J\b\u00101\u001a\u00020/H\u0016J,\u00102\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002H50403\"\b\b\u0000\u00105*\u0002062\f\u00107\u001a\b\u0012\u0004\u0012\u0002H508H\u0016J\u0016\u00109\u001a\u00020/2\u0006\u0010:\u001a\u00020\u001bH\u0082@¢\u0006\u0002\u0010;R\u000e\u0010\u0018\u001a\u00020\u0019X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u001bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u001e0\u001dX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u001f\u001a\u00020 X\u0082\u0004¢\u0006\u0004\n\u0002\u0010!R\u0014\u0010\"\u001a\b\u0012\u0004\u0012\u00020$0#X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010%\u001a\b\u0012\u0004\u0012\u00020\u001e0&X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u0004¢\u0006\u0002\n\u0000RC\u0010\u0010\u001a5\b\u0001\u0012\u0004\u0012\u00020\u0012\u0012\u0013\u0012\u00110\r¢\u0006\f\b\u0013\u0012\b\b\u0014\u0012\u0004\b\b(\u0015\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00160\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u0006\u0018\u00010\u0011X\u0082\u0004¢\u0006\u0004\n\u0002\u0010'R&\u0010\u0002\u001a\u0018\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u0003X\u0082\u0004¢\u0006\u0004\n\u0002\u0010(R\u0017\u0010)\u001a\b\u0012\u0004\u0012\u00020+0*¢\u0006\b\n\u0000\u001a\u0004\b,\u0010-R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006="}, d2 = {"Lcom/apollographql/apollo3/network/ws/WebSocketNetworkTransport;", "Lcom/apollographql/apollo3/network/NetworkTransport;", "serverUrl", "Lkotlin/Function1;", "Lkotlin/coroutines/Continuation;", "", "", "headers", "", "Lcom/apollographql/apollo3/api/http/HttpHeader;", "webSocketEngine", "Lcom/apollographql/apollo3/network/ws/WebSocketEngine;", "idleTimeoutMillis", "", "protocolFactory", "Lcom/apollographql/apollo3/network/ws/WsProtocol$Factory;", "reopenWhen", "Lkotlin/Function3;", "", "Lkotlin/ParameterName;", "name", "attempt", "", "(Lkotlin/jvm/functions/Function1;Ljava/util/List;Lcom/apollographql/apollo3/network/ws/WebSocketEngine;JLcom/apollographql/apollo3/network/ws/WsProtocol$Factory;Lkotlin/jvm/functions/Function3;)V", "backgroundDispatcher", "Lcom/apollographql/apollo3/internal/CloseableSingleThreadDispatcher;", "coroutineScope", "Lkotlinx/coroutines/CoroutineScope;", BoxConvertedPushNotificationDevice.EVENTS, "Lkotlinx/coroutines/flow/SharedFlow;", "Lcom/apollographql/apollo3/network/ws/internal/Event;", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "com/apollographql/apollo3/network/ws/WebSocketNetworkTransport$listener$1", "Lcom/apollographql/apollo3/network/ws/WebSocketNetworkTransport$listener$1;", "messages", "Lkotlinx/coroutines/channels/Channel;", "Lcom/apollographql/apollo3/network/ws/internal/Message;", "mutableEvents", "Lkotlinx/coroutines/flow/MutableSharedFlow;", "Lkotlin/jvm/functions/Function3;", "Lkotlin/jvm/functions/Function1;", "subscriptionCount", "Lkotlinx/coroutines/flow/StateFlow;", "", "getSubscriptionCount", "()Lkotlinx/coroutines/flow/StateFlow;", "closeConnection", "", BoxNoteConstants.BOX_NOTE_BRIDGE_KEY_REASON, "dispose", "execute", "Lkotlinx/coroutines/flow/Flow;", "Lcom/apollographql/apollo3/api/ApolloResponse;", "D", "Lcom/apollographql/apollo3/api/Operation$Data;", "request", "Lcom/apollographql/apollo3/api/ApolloRequest;", "supervise", "scope", "(Lkotlinx/coroutines/CoroutineScope;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Builder", "apollo-runtime"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class WebSocketNetworkTransport implements NetworkTransport {
    private final CloseableSingleThreadDispatcher backgroundDispatcher;
    private final CoroutineScope coroutineScope;
    private final SharedFlow<Event> events;
    private final List<HttpHeader> headers;
    private final long idleTimeoutMillis;
    private final WebSocketNetworkTransport$listener$1 listener;
    private final Channel<Message> messages;
    private final MutableSharedFlow<Event> mutableEvents;
    private final WsProtocol.Factory protocolFactory;
    private final Function3<Throwable, Long, Continuation<? super Boolean>, Object> reopenWhen;
    private final Function1<Continuation<? super String>, Object> serverUrl;
    private final StateFlow<Integer> subscriptionCount;
    private final WebSocketEngine webSocketEngine;

    /* JADX INFO: renamed from: com.apollographql.apollo3.network.ws.WebSocketNetworkTransport$supervise$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: WebSocketNetworkTransport.kt */
    @Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
    @DebugMetadata(c = "com.apollographql.apollo3.network.ws.WebSocketNetworkTransport", f = "WebSocketNetworkTransport.kt", i = {0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 2, 2, 2, 2, 2, 2, 2, 3, 3, 3, 3, 3, 3, 3, 3, 4, 4, 4, 4, 4, 4, 4, 4, 5, 5, 5, 5, 5, 5, 5, 6, 6, 6, 6, 6, 6, 6, 6, 7, 7, 7, 7, 7, 7, 7, 8, 8, 8, 8, 8, 8, 8}, l = {Token.LET, Token.LETEXPR, Token.DEBUGGER, 195, 194, 204, 214, 218, 244}, m = "supervise", n = {"this", "scope", "idleJob", "connectionJob", "protocol", "activeMessages", "reopenAttemptCount", "this", "scope", "idleJob", "connectionJob", "protocol", "activeMessages", "message", "reopenAttemptCount", "this", "scope", "idleJob", "connectionJob", "protocol", "activeMessages", "reopenAttemptCount", "this", "scope", "idleJob", "connectionJob", "protocol", "activeMessages", "message", "reopenAttemptCount", "this", "scope", "idleJob", "connectionJob", "protocol", "activeMessages", "message", "reopenAttemptCount", "this", "scope", "idleJob", "connectionJob", "protocol", "activeMessages", "reopenAttemptCount", "this", "scope", "idleJob", "connectionJob", "protocol", "activeMessages", "message", "reopenAttemptCount", "this", "scope", "idleJob", "connectionJob", "protocol", "activeMessages", "reopenAttemptCount", "this", "scope", "idleJob", "connectionJob", "protocol", "activeMessages", "reopenAttemptCount"}, s = {"L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "J$0", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "J$0", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "J$0", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "J$0", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "J$0", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "J$0", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "J$0", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "J$0", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "J$0"})
    static final class C09151 extends ContinuationImpl {
        long J$0;
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        Object L$4;
        Object L$5;
        Object L$6;
        Object L$7;
        int label;
        /* synthetic */ Object result;

        C09151(Continuation<? super C09151> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return WebSocketNetworkTransport.this.supervise(null, this);
        }
    }

    public /* synthetic */ WebSocketNetworkTransport(Function1 function1, List list, WebSocketEngine webSocketEngine, long j, WsProtocol.Factory factory, Function3 function3, DefaultConstructorMarker defaultConstructorMarker) {
        this(function1, list, webSocketEngine, j, factory, function3);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r7v10, types: [com.apollographql.apollo3.network.ws.WebSocketNetworkTransport$listener$1] */
    private WebSocketNetworkTransport(Function1<? super Continuation<? super String>, ? extends Object> function1, List<HttpHeader> list, WebSocketEngine webSocketEngine, long j, WsProtocol.Factory factory, Function3<? super Throwable, ? super Long, ? super Continuation<? super Boolean>, ? extends Object> function3) {
        this.serverUrl = function1;
        this.headers = list;
        this.webSocketEngine = webSocketEngine;
        this.idleTimeoutMillis = j;
        this.protocolFactory = factory;
        this.reopenWhen = function3;
        this.messages = ChannelKt.Channel$default(Integer.MAX_VALUE, null, null, 6, null);
        MutableSharedFlow<Event> MutableSharedFlow = SharedFlowKt.MutableSharedFlow(0, Integer.MAX_VALUE, BufferOverflow.SUSPEND);
        this.mutableEvents = MutableSharedFlow;
        this.events = FlowKt.asSharedFlow(MutableSharedFlow);
        this.subscriptionCount = MutableSharedFlow.getSubscriptionCount();
        CloseableSingleThreadDispatcher closeableSingleThreadDispatcher = new CloseableSingleThreadDispatcher();
        this.backgroundDispatcher = closeableSingleThreadDispatcher;
        CoroutineScope CoroutineScope = CoroutineScopeKt.CoroutineScope(closeableSingleThreadDispatcher.getCoroutineDispatcher());
        this.coroutineScope = CoroutineScope;
        BuildersKt__Builders_commonKt.launch$default(CoroutineScope, null, null, new AnonymousClass1(null), 3, null);
        this.listener = new WsProtocol.Listener() { // from class: com.apollographql.apollo3.network.ws.WebSocketNetworkTransport$listener$1
            @Override // com.apollographql.apollo3.network.ws.WsProtocol.Listener
            public void operationResponse(String id, Map<String, ? extends Object> payload) {
                Intrinsics.checkNotNullParameter(id, "id");
                Intrinsics.checkNotNullParameter(payload, "payload");
                this.this$0.messages.mo11206trySendJP2dKIU(new OperationResponse(id, payload));
            }

            @Override // com.apollographql.apollo3.network.ws.WsProtocol.Listener
            public void operationError(String id, Map<String, ? extends Object> payload) {
                Intrinsics.checkNotNullParameter(id, "id");
                this.this$0.messages.mo11206trySendJP2dKIU(new OperationError(id, payload));
            }

            @Override // com.apollographql.apollo3.network.ws.WsProtocol.Listener
            public void operationComplete(String id) {
                Intrinsics.checkNotNullParameter(id, "id");
                this.this$0.messages.mo11206trySendJP2dKIU(new OperationComplete(id));
            }

            @Override // com.apollographql.apollo3.network.ws.WsProtocol.Listener
            public void generalError(Map<String, ? extends Object> payload) {
                this.this$0.messages.mo11206trySendJP2dKIU(new GeneralError(payload));
            }

            @Override // com.apollographql.apollo3.network.ws.WsProtocol.Listener
            public void networkError(Throwable cause) {
                Intrinsics.checkNotNullParameter(cause, "cause");
                this.this$0.messages.mo11206trySendJP2dKIU(new NetworkError(cause));
            }
        };
    }

    /* synthetic */ WebSocketNetworkTransport(Function1 function1, List list, WebSocketEngine webSocketEngine, long j, WsProtocol.Factory factory, Function3 function3, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(function1, list, (i & 4) != 0 ? new DefaultWebSocketEngine() : webSocketEngine, (i & 8) != 0 ? 60000L : j, (i & 16) != 0 ? new SubscriptionWsProtocol.Factory(0L, null, null, 7, null) : factory, function3);
    }

    public final StateFlow<Integer> getSubscriptionCount() {
        return this.subscriptionCount;
    }

    /* JADX INFO: renamed from: com.apollographql.apollo3.network.ws.WebSocketNetworkTransport$1, reason: invalid class name */
    /* JADX INFO: compiled from: WebSocketNetworkTransport.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 5, 1}, xi = 48)
    @DebugMetadata(c = "com.apollographql.apollo3.network.ws.WebSocketNetworkTransport$1", f = "WebSocketNetworkTransport.kt", i = {0}, l = {98}, m = "invokeSuspend", n = {"$this$use$iv"}, s = {"L$0"})
    static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        private /* synthetic */ Object L$0;
        int label;

        AnonymousClass1(Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            AnonymousClass1 anonymousClass1 = WebSocketNetworkTransport.this.new AnonymousClass1(continuation);
            anonymousClass1.L$0 = obj;
            return anonymousClass1;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Code duplicated, block: B:36:0x004d A[EXC_TOP_SPLITTER, SYNTHETIC] */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            Closeable closeable;
            Throwable th;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                CoroutineScope coroutineScope = (CoroutineScope) this.L$0;
                CloseableSingleThreadDispatcher closeableSingleThreadDispatcher = WebSocketNetworkTransport.this.backgroundDispatcher;
                WebSocketNetworkTransport webSocketNetworkTransport = WebSocketNetworkTransport.this;
                try {
                    this.L$0 = closeableSingleThreadDispatcher;
                    this.label = 1;
                    if (webSocketNetworkTransport.supervise(coroutineScope, this) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    closeable = closeableSingleThreadDispatcher;
                } catch (Throwable th2) {
                    th = th2;
                    closeable = closeableSingleThreadDispatcher;
                    if (closeable != null) {
                        closeable.close();
                    }
                    th = th;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                closeable = (Closeable) this.L$0;
                try {
                    ResultKt.throwOnFailure(obj);
                } catch (Throwable th3) {
                    th = th3;
                    if (closeable != null) {
                        try {
                            closeable.close();
                        } catch (Throwable th4) {
                            ExceptionsKt.addSuppressed(th, th4);
                        }
                    }
                    th = th;
                }
            }
            Unit unit = Unit.INSTANCE;
            if (closeable != null) {
                try {
                    closeable.close();
                } catch (Throwable th5) {
                    th = th5;
                }
            }
            th = null;
            if (th == null) {
                return Unit.INSTANCE;
            }
            throw th;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:106:0x0374  */
    /* JADX WARN: Code duplicated, block: B:150:0x04e8  */
    /* JADX WARN: Code duplicated, block: B:151:0x0502  */
    /* JADX WARN: Code duplicated, block: B:153:0x050c  */
    /* JADX WARN: Code duplicated, block: B:176:0x033a A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:177:0x033f A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:178:? A[LOOP:1: B:94:0x0324->B:178:?, LOOP_END, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:7:0x0018  */
    /* JADX WARN: Code duplicated, block: B:96:0x032a A[Catch: Exception -> 0x0417, TryCatch #4 {Exception -> 0x0417, blocks: (B:87:0x030a, B:90:0x0316, B:99:0x033f, B:93:0x0320, B:94:0x0324, B:96:0x032a, B:98:0x033a), top: B:165:0x030a }] */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v36, types: [T, kotlinx.coroutines.Job] */
    /* JADX WARN: Type inference failed for: r0v40, types: [T, com.apollographql.apollo3.network.ws.WsProtocol] */
    /* JADX WARN: Type inference failed for: r0v91, types: [T, kotlinx.coroutines.Job] */
    /* JADX WARN: Type inference incomplete: some casts might be missing */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:144:0x04c8 -> B:145:0x04cf). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:147:0x04d9 -> B:146:0x04d6). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:61:0x0280 -> B:36:0x01cf). Please report as a decompilation issue!!! */
    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions stack size limit reached
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        */
    public final java.lang.Object supervise(kotlinx.coroutines.CoroutineScope r26, kotlin.coroutines.Continuation<? super kotlin.Unit> r27) {
        /*
            Method dump skipped, instruction units count: 1338
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.apollographql.apollo3.network.ws.WebSocketNetworkTransport.supervise(kotlinx.coroutines.CoroutineScope, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void supervise$closeProtocol(Ref.ObjectRef<WsProtocol> objectRef, Ref.ObjectRef<Job> objectRef2, Ref.ObjectRef<Job> objectRef3) {
        WsProtocol wsProtocol = objectRef.element;
        if (wsProtocol != null) {
            wsProtocol.close();
        }
        objectRef.element = null;
        Job job = objectRef2.element;
        if (job != null) {
            Job.DefaultImpls.cancel$default(job, (CancellationException) null, 1, (Object) null);
        }
        objectRef2.element = null;
        Job job2 = objectRef3.element;
        if (job2 != null) {
            Job.DefaultImpls.cancel$default(job2, (CancellationException) null, 1, (Object) null);
        }
        objectRef3.element = null;
    }

    /* JADX INFO: renamed from: com.apollographql.apollo3.network.ws.WebSocketNetworkTransport$supervise$3, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: WebSocketNetworkTransport.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 5, 1}, xi = 48)
    @DebugMetadata(c = "com.apollographql.apollo3.network.ws.WebSocketNetworkTransport$supervise$3", f = "WebSocketNetworkTransport.kt", i = {}, l = {229}, m = "invokeSuspend", n = {}, s = {})
    static final class C09163 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ Ref.ObjectRef<WsProtocol> $protocol;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C09163(Ref.ObjectRef<WsProtocol> objectRef, Continuation<? super C09163> continuation) {
            super(2, continuation);
            this.$protocol = objectRef;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new C09163(this.$protocol, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C09163) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                WsProtocol wsProtocol = this.$protocol.element;
                Intrinsics.checkNotNull(wsProtocol);
                this.label = 1;
                if (wsProtocol.run(this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
            return Unit.INSTANCE;
        }
    }

    /* JADX INFO: renamed from: com.apollographql.apollo3.network.ws.WebSocketNetworkTransport$supervise$4, reason: invalid class name */
    /* JADX INFO: compiled from: WebSocketNetworkTransport.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 5, 1}, xi = 48)
    @DebugMetadata(c = "com.apollographql.apollo3.network.ws.WebSocketNetworkTransport$supervise$4", f = "WebSocketNetworkTransport.kt", i = {}, l = {254}, m = "invokeSuspend", n = {}, s = {})
    static final class AnonymousClass4 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ Ref.ObjectRef<Job> $connectionJob;
        final /* synthetic */ Ref.ObjectRef<Job> $idleJob;
        final /* synthetic */ Ref.ObjectRef<WsProtocol> $protocol;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass4(Ref.ObjectRef<WsProtocol> objectRef, Ref.ObjectRef<Job> objectRef2, Ref.ObjectRef<Job> objectRef3, Continuation<? super AnonymousClass4> continuation) {
            super(2, continuation);
            this.$protocol = objectRef;
            this.$connectionJob = objectRef2;
            this.$idleJob = objectRef3;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return WebSocketNetworkTransport.this.new AnonymousClass4(this.$protocol, this.$connectionJob, this.$idleJob, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass4) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                this.label = 1;
                if (DelayKt.delay(WebSocketNetworkTransport.this.idleTimeoutMillis, this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
            WebSocketNetworkTransport.supervise$closeProtocol(this.$protocol, this.$connectionJob, this.$idleJob);
            return Unit.INSTANCE;
        }
    }

    @Override // com.apollographql.apollo3.network.NetworkTransport
    public <D extends Operation.Data> Flow<ApolloResponse<D>> execute(final ApolloRequest<D> request) {
        Intrinsics.checkNotNullParameter(request, "request");
        final DeferredJsonMerger deferredJsonMerger = new DeferredJsonMerger();
        final SharedFlow sharedFlowOnSubscription = FlowKt.onSubscription(this.events, new C09141(request, null));
        final Flow flowTransformWhile = FlowsKt.transformWhile(new Flow<Event>() { // from class: com.apollographql.apollo3.network.ws.WebSocketNetworkTransport$execute$$inlined$filter$1

            /* JADX INFO: renamed from: com.apollographql.apollo3.network.ws.WebSocketNetworkTransport$execute$$inlined$filter$1$2, reason: invalid class name */
            /* JADX INFO: compiled from: Emitters.kt */
            @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u00032\u0006\u0010\u0004\u001a\u0002H\u0002H\u008a@¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\b"}, d2 = {"<anonymous>", "", ExifInterface.GPS_DIRECTION_TRUE, "R", "value", "emit", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "kotlinx/coroutines/flow/FlowKt__EmittersKt$unsafeTransform$1$1", "kotlinx/coroutines/flow/FlowKt__TransformKt$filter$$inlined$unsafeTransform$1$2"}, k = 3, mv = {1, 5, 1}, xi = 48)
            public static final class AnonymousClass2<T> implements FlowCollector {
                final /* synthetic */ ApolloRequest $request$inlined;
                final /* synthetic */ FlowCollector $this_unsafeFlow;

                /* JADX INFO: renamed from: com.apollographql.apollo3.network.ws.WebSocketNetworkTransport$execute$$inlined$filter$1$2$1, reason: invalid class name */
                /* JADX INFO: compiled from: Emitters.kt */
                @Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
                @DebugMetadata(c = "com.apollographql.apollo3.network.ws.WebSocketNetworkTransport$execute$$inlined$filter$1$2", f = "WebSocketNetworkTransport.kt", i = {}, l = {223}, m = "emit", n = {}, s = {})
                public static final class AnonymousClass1 extends ContinuationImpl {
                    Object L$0;
                    Object L$1;
                    int label;
                    /* synthetic */ Object result;

                    public AnonymousClass1(Continuation continuation) {
                        super(continuation);
                    }

                    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                    public final Object invokeSuspend(Object obj) {
                        this.result = obj;
                        this.label |= Integer.MIN_VALUE;
                        return AnonymousClass2.this.emit(null, this);
                    }
                }

                public AnonymousClass2(FlowCollector flowCollector, ApolloRequest apolloRequest) {
                    this.$this_unsafeFlow = flowCollector;
                    this.$request$inlined = apolloRequest;
                }

                /* JADX WARN: Code duplicated, block: B:7:0x0014  */
                @Override // kotlinx.coroutines.flow.FlowCollector
                public final Object emit(Object obj, Continuation continuation) {
                    AnonymousClass1 anonymousClass1;
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
                    Object obj2 = anonymousClass1.result;
                    Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                    int i = anonymousClass1.label;
                    if (i == 0) {
                        ResultKt.throwOnFailure(obj2);
                        FlowCollector flowCollector = this.$this_unsafeFlow;
                        Event event = (Event) obj;
                        if (Intrinsics.areEqual(event.getId(), this.$request$inlined.getRequestUuid().toString()) || event.getId() == null) {
                            anonymousClass1.label = 1;
                            if (flowCollector.emit(obj, anonymousClass1) == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                        }
                    } else {
                        if (i != 1) {
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                        ResultKt.throwOnFailure(obj2);
                    }
                    return Unit.INSTANCE;
                }
            }

            @Override // kotlinx.coroutines.flow.Flow
            public Object collect(FlowCollector<? super Event> flowCollector, Continuation continuation) {
                Object objCollect = sharedFlowOnSubscription.collect(new AnonymousClass2(flowCollector, request), continuation);
                return objCollect == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objCollect : Unit.INSTANCE;
            }
        }, new AnonymousClass3(request, null));
        final Flow flow = new Flow<ApolloResponse<D>>() { // from class: com.apollographql.apollo3.network.ws.WebSocketNetworkTransport$execute$$inlined$map$1

            /* JADX INFO: renamed from: com.apollographql.apollo3.network.ws.WebSocketNetworkTransport$execute$$inlined$map$1$2, reason: invalid class name */
            /* JADX INFO: compiled from: Emitters.kt */
            @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u00032\u0006\u0010\u0004\u001a\u0002H\u0002H\u008a@¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\b"}, d2 = {"<anonymous>", "", ExifInterface.GPS_DIRECTION_TRUE, "R", "value", "emit", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "kotlinx/coroutines/flow/FlowKt__EmittersKt$unsafeTransform$1$1", "kotlinx/coroutines/flow/FlowKt__TransformKt$map$$inlined$unsafeTransform$1$2"}, k = 3, mv = {1, 5, 1}, xi = 48)
            public static final class AnonymousClass2<T> implements FlowCollector {
                final /* synthetic */ DeferredJsonMerger $deferredJsonMerger$inlined;
                final /* synthetic */ ApolloRequest $request$inlined;
                final /* synthetic */ FlowCollector $this_unsafeFlow;

                /* JADX INFO: renamed from: com.apollographql.apollo3.network.ws.WebSocketNetworkTransport$execute$$inlined$map$1$2$1, reason: invalid class name */
                /* JADX INFO: compiled from: Emitters.kt */
                @Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
                @DebugMetadata(c = "com.apollographql.apollo3.network.ws.WebSocketNetworkTransport$execute$$inlined$map$1$2", f = "WebSocketNetworkTransport.kt", i = {}, l = {223}, m = "emit", n = {}, s = {})
                public static final class AnonymousClass1 extends ContinuationImpl {
                    Object L$0;
                    int label;
                    /* synthetic */ Object result;

                    public AnonymousClass1(Continuation continuation) {
                        super(continuation);
                    }

                    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                    public final Object invokeSuspend(Object obj) {
                        this.result = obj;
                        this.label |= Integer.MIN_VALUE;
                        return AnonymousClass2.this.emit(null, this);
                    }
                }

                public AnonymousClass2(FlowCollector flowCollector, ApolloRequest apolloRequest, DeferredJsonMerger deferredJsonMerger) {
                    this.$this_unsafeFlow = flowCollector;
                    this.$request$inlined = apolloRequest;
                    this.$deferredJsonMerger$inlined = deferredJsonMerger;
                }

                /* JADX WARN: Code duplicated, block: B:7:0x0014  */
                @Override // kotlinx.coroutines.flow.FlowCollector
                public final Object emit(Object obj, Continuation continuation) {
                    AnonymousClass1 anonymousClass1;
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
                    Object obj2 = anonymousClass1.result;
                    Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                    int i = anonymousClass1.label;
                    if (i == 0) {
                        ResultKt.throwOnFailure(obj2);
                        FlowCollector flowCollector = this.$this_unsafeFlow;
                        Event event = (Event) obj;
                        if (!(event instanceof OperationResponse)) {
                            if (event instanceof OperationError) {
                                throw new SubscriptionOperationException(this.$request$inlined.getOperation().name(), ((OperationError) event).getPayload());
                            }
                            if (event instanceof NetworkError) {
                                throw new ApolloNetworkException("Network error while executing " + this.$request$inlined.getOperation().name(), ((NetworkError) event).getCause());
                            }
                            if (event instanceof ConnectionReEstablished ? true : event instanceof OperationComplete ? true : event instanceof GeneralError) {
                                throw new IllegalStateException(("Unexpected event " + event).toString());
                            }
                            throw new NoWhenBranchMatchedException();
                        }
                        Map<String, ? extends Object> payload = ((OperationResponse) event).getPayload();
                        ExecutionContext.Element element = this.$request$inlined.getExecutionContext().get(CustomScalarAdapters.INSTANCE);
                        Intrinsics.checkNotNull(element);
                        CustomScalarAdapters customScalarAdapters = (CustomScalarAdapters) element;
                        Pair pair = DeferredJsonMergerKt.isDeferred(payload) ? TuplesKt.to(this.$deferredJsonMerger$inlined.merge(payload), AdapterContext.withDeferredFragmentIds(customScalarAdapters, this.$deferredJsonMerger$inlined.getMergedFragmentIds())) : TuplesKt.to(payload, customScalarAdapters);
                        ApolloResponse apolloResponseBuild = Operations.parseJsonResponse(this.$request$inlined.getOperation(), JsonReaders.jsonReader((Map<String, ? extends Object>) pair.component1()), (CustomScalarAdapters) pair.component2()).newBuilder().requestUuid(this.$request$inlined.getRequestUuid()).build();
                        if (!this.$deferredJsonMerger$inlined.getHasNext()) {
                            this.$deferredJsonMerger$inlined.reset();
                        }
                        anonymousClass1.label = 1;
                        if (flowCollector.emit(apolloResponseBuild, anonymousClass1) == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                    } else {
                        if (i != 1) {
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                        ResultKt.throwOnFailure(obj2);
                    }
                    return Unit.INSTANCE;
                }
            }

            @Override // kotlinx.coroutines.flow.Flow
            public Object collect(FlowCollector flowCollector, Continuation continuation) {
                Object objCollect = flowTransformWhile.collect(new AnonymousClass2(flowCollector, request, deferredJsonMerger), continuation);
                return objCollect == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objCollect : Unit.INSTANCE;
            }
        };
        return FlowKt.onCompletion(new Flow<ApolloResponse<D>>() { // from class: com.apollographql.apollo3.network.ws.WebSocketNetworkTransport$execute$$inlined$filterNot$1

            /* JADX INFO: renamed from: com.apollographql.apollo3.network.ws.WebSocketNetworkTransport$execute$$inlined$filterNot$1$2, reason: invalid class name */
            /* JADX INFO: compiled from: Emitters.kt */
            @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u00032\u0006\u0010\u0004\u001a\u0002H\u0002H\u008a@¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\b"}, d2 = {"<anonymous>", "", ExifInterface.GPS_DIRECTION_TRUE, "R", "value", "emit", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "kotlinx/coroutines/flow/FlowKt__EmittersKt$unsafeTransform$1$1", "kotlinx/coroutines/flow/FlowKt__TransformKt$filterNot$$inlined$unsafeTransform$1$2"}, k = 3, mv = {1, 5, 1}, xi = 48)
            public static final class AnonymousClass2<T> implements FlowCollector {
                final /* synthetic */ DeferredJsonMerger $deferredJsonMerger$inlined;
                final /* synthetic */ FlowCollector $this_unsafeFlow;

                /* JADX INFO: renamed from: com.apollographql.apollo3.network.ws.WebSocketNetworkTransport$execute$$inlined$filterNot$1$2$1, reason: invalid class name */
                /* JADX INFO: compiled from: Emitters.kt */
                @Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
                @DebugMetadata(c = "com.apollographql.apollo3.network.ws.WebSocketNetworkTransport$execute$$inlined$filterNot$1$2", f = "WebSocketNetworkTransport.kt", i = {}, l = {223}, m = "emit", n = {}, s = {})
                public static final class AnonymousClass1 extends ContinuationImpl {
                    Object L$0;
                    Object L$1;
                    int label;
                    /* synthetic */ Object result;

                    public AnonymousClass1(Continuation continuation) {
                        super(continuation);
                    }

                    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                    public final Object invokeSuspend(Object obj) {
                        this.result = obj;
                        this.label |= Integer.MIN_VALUE;
                        return AnonymousClass2.this.emit(null, this);
                    }
                }

                public AnonymousClass2(FlowCollector flowCollector, DeferredJsonMerger deferredJsonMerger) {
                    this.$this_unsafeFlow = flowCollector;
                    this.$deferredJsonMerger$inlined = deferredJsonMerger;
                }

                /* JADX WARN: Code duplicated, block: B:7:0x0014  */
                @Override // kotlinx.coroutines.flow.FlowCollector
                public final Object emit(Object obj, Continuation continuation) {
                    AnonymousClass1 anonymousClass1;
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
                    Object obj2 = anonymousClass1.result;
                    Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                    int i = anonymousClass1.label;
                    if (i == 0) {
                        ResultKt.throwOnFailure(obj2);
                        FlowCollector flowCollector = this.$this_unsafeFlow;
                        if (!this.$deferredJsonMerger$inlined.getIsEmptyPayload()) {
                            anonymousClass1.label = 1;
                            if (flowCollector.emit(obj, anonymousClass1) == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                        }
                    } else {
                        if (i != 1) {
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                        ResultKt.throwOnFailure(obj2);
                    }
                    return Unit.INSTANCE;
                }
            }

            @Override // kotlinx.coroutines.flow.Flow
            public Object collect(FlowCollector flowCollector, Continuation continuation) {
                Object objCollect = flow.collect(new AnonymousClass2(flowCollector, deferredJsonMerger), continuation);
                return objCollect == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objCollect : Unit.INSTANCE;
            }
        }, new AnonymousClass6(request, null));
    }

    /* JADX INFO: renamed from: com.apollographql.apollo3.network.ws.WebSocketNetworkTransport$execute$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: WebSocketNetworkTransport.kt */
    @Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001\"\b\b\u0000\u0010\u0002*\u00020\u0003*\b\u0012\u0004\u0012\u00020\u00050\u0004H\u008a@"}, d2 = {"<anonymous>", "", "D", "Lcom/apollographql/apollo3/api/Operation$Data;", "Lkotlinx/coroutines/flow/FlowCollector;", "Lcom/apollographql/apollo3/network/ws/internal/Event;"}, k = 3, mv = {1, 5, 1}, xi = 48)
    @DebugMetadata(c = "com.apollographql.apollo3.network.ws.WebSocketNetworkTransport$execute$1", f = "WebSocketNetworkTransport.kt", i = {}, l = {272}, m = "invokeSuspend", n = {}, s = {})
    static final class C09141 extends SuspendLambda implements Function2<FlowCollector<? super Event>, Continuation<? super Unit>, Object> {
        final /* synthetic */ ApolloRequest<D> $request;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C09141(ApolloRequest<D> apolloRequest, Continuation<? super C09141> continuation) {
            super(2, continuation);
            this.$request = apolloRequest;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return WebSocketNetworkTransport.this.new C09141(this.$request, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(FlowCollector<? super Event> flowCollector, Continuation<? super Unit> continuation) {
            return ((C09141) create(flowCollector, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                this.label = 1;
                if (WebSocketNetworkTransport.this.messages.send(new StartOperation(this.$request), this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
            return Unit.INSTANCE;
        }
    }

    /* JADX INFO: renamed from: com.apollographql.apollo3.network.ws.WebSocketNetworkTransport$execute$3, reason: invalid class name */
    /* JADX INFO: compiled from: WebSocketNetworkTransport.kt */
    @Metadata(d1 = {"\u0000\u0016\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001\"\b\b\u0000\u0010\u0002*\u00020\u0003*\b\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010\u0006\u001a\u00020\u0005H\u008a@"}, d2 = {"<anonymous>", "", "D", "Lcom/apollographql/apollo3/api/Operation$Data;", "Lkotlinx/coroutines/flow/FlowCollector;", "Lcom/apollographql/apollo3/network/ws/internal/Event;", "it"}, k = 3, mv = {1, 5, 1}, xi = 48)
    @DebugMetadata(c = "com.apollographql.apollo3.network.ws.WebSocketNetworkTransport$execute$3", f = "WebSocketNetworkTransport.kt", i = {}, l = {287, BoxCommonConstants.REQUEST_RETRY_SHARED_LINK}, m = "invokeSuspend", n = {}, s = {})
    static final class AnonymousClass3 extends SuspendLambda implements Function3<FlowCollector<? super Event>, Event, Continuation<? super Boolean>, Object> {
        final /* synthetic */ ApolloRequest<D> $request;
        private /* synthetic */ Object L$0;
        /* synthetic */ Object L$1;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass3(ApolloRequest<D> apolloRequest, Continuation<? super AnonymousClass3> continuation) {
            super(3, continuation);
            this.$request = apolloRequest;
        }

        @Override // kotlin.jvm.functions.Function3
        public final Object invoke(FlowCollector<? super Event> flowCollector, Event event, Continuation<? super Boolean> continuation) {
            AnonymousClass3 anonymousClass3 = new AnonymousClass3(this.$request, continuation);
            anonymousClass3.L$0 = flowCollector;
            anonymousClass3.L$1 = event;
            return anonymousClass3.invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Code restructure failed: missing block: B:19:0x0045, code lost:
        
            if (r8.emit(r1, r7) == r0) goto L26;
         */
        /* JADX WARN: Code restructure failed: missing block: B:25:0x0086, code lost:
        
            if (r8.emit(r1, r7) == r0) goto L26;
         */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final java.lang.Object invokeSuspend(java.lang.Object r8) {
            /*
                r7 = this;
                java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
                int r1 = r7.label
                r2 = 2
                r3 = 0
                r4 = 1
                if (r1 == 0) goto L20
                if (r1 == r4) goto L1c
                if (r1 != r2) goto L14
                kotlin.ResultKt.throwOnFailure(r8)
                goto L89
            L14:
                java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
                java.lang.String r8 = "call to 'resume' before 'invoke' with coroutine"
                r7.<init>(r8)
                throw r7
            L1c:
                kotlin.ResultKt.throwOnFailure(r8)
                goto L8a
            L20:
                kotlin.ResultKt.throwOnFailure(r8)
                java.lang.Object r8 = r7.L$0
                kotlinx.coroutines.flow.FlowCollector r8 = (kotlinx.coroutines.flow.FlowCollector) r8
                java.lang.Object r1 = r7.L$1
                com.apollographql.apollo3.network.ws.internal.Event r1 = (com.apollographql.apollo3.network.ws.internal.Event) r1
                boolean r5 = r1 instanceof com.apollographql.apollo3.network.ws.internal.OperationComplete
                if (r5 == 0) goto L30
                goto L8a
            L30:
                boolean r5 = r1 instanceof com.apollographql.apollo3.network.ws.internal.ConnectionReEstablished
                if (r5 == 0) goto L35
                goto L8a
            L35:
                boolean r5 = r1 instanceof com.apollographql.apollo3.network.ws.internal.NetworkError
                r6 = 0
                if (r5 == 0) goto L48
                r2 = r7
                kotlin.coroutines.Continuation r2 = (kotlin.coroutines.Continuation) r2
                r7.L$0 = r6
                r7.label = r4
                java.lang.Object r7 = r8.emit(r1, r2)
                if (r7 != r0) goto L8a
                goto L88
            L48:
                boolean r3 = r1 instanceof com.apollographql.apollo3.network.ws.internal.GeneralError
                if (r3 == 0) goto L7b
                java.lang.StringBuilder r8 = new java.lang.StringBuilder
                java.lang.String r0 = "Received general error while executing operation "
                r8.<init>(r0)
                com.apollographql.apollo3.api.ApolloRequest<D> r7 = r7.$request
                com.apollographql.apollo3.api.Operation r7 = r7.getOperation()
                java.lang.String r7 = r7.name()
                java.lang.StringBuilder r7 = r8.append(r7)
                java.lang.String r8 = ": "
                java.lang.StringBuilder r7 = r7.append(r8)
                com.apollographql.apollo3.network.ws.internal.GeneralError r1 = (com.apollographql.apollo3.network.ws.internal.GeneralError) r1
                java.util.Map r8 = r1.getPayload()
                java.lang.StringBuilder r7 = r7.append(r8)
                java.lang.String r7 = r7.toString()
                java.io.PrintStream r8 = java.lang.System.out
                r8.println(r7)
                goto L89
            L7b:
                r3 = r7
                kotlin.coroutines.Continuation r3 = (kotlin.coroutines.Continuation) r3
                r7.L$0 = r6
                r7.label = r2
                java.lang.Object r7 = r8.emit(r1, r3)
                if (r7 != r0) goto L89
            L88:
                return r0
            L89:
                r3 = r4
            L8a:
                java.lang.Boolean r7 = kotlin.coroutines.jvm.internal.Boxing.boxBoolean(r3)
                return r7
            */
            throw new UnsupportedOperationException("Method not decompiled: com.apollographql.apollo3.network.ws.WebSocketNetworkTransport.AnonymousClass3.invokeSuspend(java.lang.Object):java.lang.Object");
        }
    }

    /* JADX INFO: Add missing generic type declarations: [D] */
    /* JADX INFO: renamed from: com.apollographql.apollo3.network.ws.WebSocketNetworkTransport$execute$6, reason: invalid class name */
    /* JADX INFO: compiled from: WebSocketNetworkTransport.kt */
    @Metadata(d1 = {"\u0000\u001a\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0003\u0010\u0000\u001a\u00020\u0001\"\b\b\u0000\u0010\u0002*\u00020\u0003*\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00020\u00050\u00042\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u008a@"}, d2 = {"<anonymous>", "", "D", "Lcom/apollographql/apollo3/api/Operation$Data;", "Lkotlinx/coroutines/flow/FlowCollector;", "Lcom/apollographql/apollo3/api/ApolloResponse;", "it", ""}, k = 3, mv = {1, 5, 1}, xi = 48)
    @DebugMetadata(c = "com.apollographql.apollo3.network.ws.WebSocketNetworkTransport$execute$6", f = "WebSocketNetworkTransport.kt", i = {}, l = {333}, m = "invokeSuspend", n = {}, s = {})
    static final class AnonymousClass6<D> extends SuspendLambda implements Function3<FlowCollector<? super ApolloResponse<D>>, Throwable, Continuation<? super Unit>, Object> {
        final /* synthetic */ ApolloRequest<D> $request;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass6(ApolloRequest<D> apolloRequest, Continuation<? super AnonymousClass6> continuation) {
            super(3, continuation);
            this.$request = apolloRequest;
        }

        @Override // kotlin.jvm.functions.Function3
        public final Object invoke(FlowCollector<? super ApolloResponse<D>> flowCollector, Throwable th, Continuation<? super Unit> continuation) {
            return WebSocketNetworkTransport.this.new AnonymousClass6(this.$request, continuation).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                this.label = 1;
                if (WebSocketNetworkTransport.this.messages.send(new StopOperation(this.$request), this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
            return Unit.INSTANCE;
        }
    }

    @Override // com.apollographql.apollo3.network.NetworkTransport
    public void dispose() {
        this.messages.mo11206trySendJP2dKIU(Dispose.INSTANCE);
    }

    public final void closeConnection(Throwable reason) {
        Intrinsics.checkNotNullParameter(reason, "reason");
        this.messages.mo11206trySendJP2dKIU(new NetworkError(reason));
    }

    /* JADX INFO: compiled from: WebSocketNetworkTransport.kt */
    @Metadata(d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0016\u0010\u001a\u001a\u00020\u00002\u0006\u0010\u000f\u001a\u00020\u00162\u0006\u0010\u001b\u001a\u00020\u0016J\u0014\u0010\u001c\u001a\u00020\u00002\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u001dJ\u0006\u0010\u001e\u001a\u00020\u001fJ\u0014\u0010\u0003\u001a\u00020\u00002\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u001dJ\u000e\u0010\u0006\u001a\u00020\u00002\u0006\u0010\u0006\u001a\u00020\u0007J\u000e\u0010 \u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\nJ\u001e\u0010!\u001a\u00020\u00002\u0014\u0010!\u001a\u0010\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u0012\u0018\u00010\u0015H\u0007JF\u0010\u000b\u001a\u00020\u000029\u0010\u000b\u001a5\b\u0001\u0012\u0004\u0012\u00020\r\u0012\u0013\u0012\u00110\u0007¢\u0006\f\b\u000e\u0012\b\b\u000f\u0012\u0004\b\b(\u0010\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00120\u0011\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0018\u00010\f¢\u0006\u0002\u0010\"J+\u0010\u0014\u001a\u00020\u00002\u001e\u0010\u0014\u001a\u001a\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00160\u0011\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0018\u00010\u0015¢\u0006\u0002\u0010#J\u000e\u0010\u0014\u001a\u00020\u00002\u0006\u0010\u0014\u001a\u00020\u0016J\u000e\u0010\u0018\u001a\u00020\u00002\u0006\u0010\u0018\u001a\u00020\u0019R\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0004\n\u0002\u0010\bR\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u0082\u000e¢\u0006\u0002\n\u0000RC\u0010\u000b\u001a5\b\u0001\u0012\u0004\u0012\u00020\r\u0012\u0013\u0012\u00110\u0007¢\u0006\f\b\u000e\u0012\b\b\u000f\u0012\u0004\b\b(\u0010\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00120\u0011\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0018\u00010\fX\u0082\u000e¢\u0006\u0004\n\u0002\u0010\u0013R(\u0010\u0014\u001a\u001a\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00160\u0011\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0018\u00010\u0015X\u0082\u000e¢\u0006\u0004\n\u0002\u0010\u0017R\u0010\u0010\u0018\u001a\u0004\u0018\u00010\u0019X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006$"}, d2 = {"Lcom/apollographql/apollo3/network/ws/WebSocketNetworkTransport$Builder;", "", "()V", "headers", "", "Lcom/apollographql/apollo3/api/http/HttpHeader;", "idleTimeoutMillis", "", "Ljava/lang/Long;", "protocolFactory", "Lcom/apollographql/apollo3/network/ws/WsProtocol$Factory;", "reopenWhen", "Lkotlin/Function3;", "", "Lkotlin/ParameterName;", "name", "attempt", "Lkotlin/coroutines/Continuation;", "", "Lkotlin/jvm/functions/Function3;", "serverUrl", "Lkotlin/Function1;", "", "Lkotlin/jvm/functions/Function1;", "webSocketEngine", "Lcom/apollographql/apollo3/network/ws/WebSocketEngine;", "addHeader", "value", "addHeaders", "", "build", "Lcom/apollographql/apollo3/network/ws/WebSocketNetworkTransport;", "protocol", "reconnectWhen", "(Lkotlin/jvm/functions/Function3;)Lcom/apollographql/apollo3/network/ws/WebSocketNetworkTransport$Builder;", "(Lkotlin/jvm/functions/Function1;)Lcom/apollographql/apollo3/network/ws/WebSocketNetworkTransport$Builder;", "apollo-runtime"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class Builder {
        private List<HttpHeader> headers = new ArrayList();
        private Long idleTimeoutMillis;
        private WsProtocol.Factory protocolFactory;
        private Function3<? super Throwable, ? super Long, ? super Continuation<? super Boolean>, ? extends Object> reopenWhen;
        private Function1<? super Continuation<? super String>, ? extends Object> serverUrl;
        private WebSocketEngine webSocketEngine;

        public final Builder serverUrl(String serverUrl) {
            Intrinsics.checkNotNullParameter(serverUrl, "serverUrl");
            this.serverUrl = new WebSocketNetworkTransport$Builder$serverUrl$1$1(serverUrl, null);
            return this;
        }

        public final Builder serverUrl(Function1<? super Continuation<? super String>, ? extends Object> serverUrl) {
            this.serverUrl = serverUrl;
            return this;
        }

        public final Builder addHeader(String name, String value) {
            Intrinsics.checkNotNullParameter(name, "name");
            Intrinsics.checkNotNullParameter(value, "value");
            this.headers.add(new HttpHeader(name, value));
            return this;
        }

        public final Builder addHeaders(List<HttpHeader> headers) {
            Intrinsics.checkNotNullParameter(headers, "headers");
            this.headers.addAll(headers);
            return this;
        }

        public final Builder headers(List<HttpHeader> headers) {
            Intrinsics.checkNotNullParameter(headers, "headers");
            this.headers.clear();
            this.headers.addAll(headers);
            return this;
        }

        public final Builder webSocketEngine(WebSocketEngine webSocketEngine) {
            Intrinsics.checkNotNullParameter(webSocketEngine, "webSocketEngine");
            this.webSocketEngine = webSocketEngine;
            return this;
        }

        public final Builder idleTimeoutMillis(long idleTimeoutMillis) {
            this.idleTimeoutMillis = Long.valueOf(idleTimeoutMillis);
            return this;
        }

        public final Builder protocol(WsProtocol.Factory protocolFactory) {
            Intrinsics.checkNotNullParameter(protocolFactory, "protocolFactory");
            this.protocolFactory = protocolFactory;
            return this;
        }

        public final Builder reopenWhen(Function3<? super Throwable, ? super Long, ? super Continuation<? super Boolean>, ? extends Object> reopenWhen) {
            this.reopenWhen = reopenWhen;
            return this;
        }

        @Deprecated(message = "Use reopenWhen(reopenWhen: (suspend (Throwable, attempt: Long) -> Boolean))")
        public final Builder reconnectWhen(Function1<? super Throwable, Boolean> reconnectWhen) {
            this.reopenWhen = reconnectWhen != null ? new WebSocketNetworkTransport$Builder$reconnectWhen$1$1$adaptedLambda$1(reconnectWhen, null) : null;
            return this;
        }

        public final WebSocketNetworkTransport build() {
            Function1<? super Continuation<? super String>, ? extends Object> function1 = this.serverUrl;
            if (function1 == null) {
                throw new IllegalStateException("No serverUrl specified".toString());
            }
            List<HttpHeader> list = this.headers;
            DefaultWebSocketEngine defaultWebSocketEngine = this.webSocketEngine;
            if (defaultWebSocketEngine == null) {
                defaultWebSocketEngine = new DefaultWebSocketEngine();
            }
            Long l = this.idleTimeoutMillis;
            long jLongValue = l != null ? l.longValue() : 60000L;
            SubscriptionWsProtocol.Factory factory = this.protocolFactory;
            if (factory == null) {
                factory = new SubscriptionWsProtocol.Factory(0L, null, null, 7, null);
            }
            return new WebSocketNetworkTransport(function1, list, defaultWebSocketEngine, jLongValue, factory, this.reopenWhen, null);
        }
    }
}
