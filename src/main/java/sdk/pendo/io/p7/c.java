package sdk.pendo.io.p7;

import androidx.media3.exoplayer.upstream.CmcdData;
import androidx.media3.extractor.ts.PsExtractor;
import external.sdk.pendo.io.mozilla.javascript.Context;
import external.sdk.pendo.io.mozilla.javascript.Token;
import java.util.List;
import java.util.concurrent.CancellationException;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.AbstractCoroutineContextElement;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineExceptionHandler;
import kotlinx.coroutines.CoroutineName;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.DelayKt;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.SupervisorKt;
import kotlinx.coroutines.channels.Channel;
import kotlinx.coroutines.channels.ChannelKt;
import kotlinx.coroutines.channels.ChannelResult;
import kotlinx.coroutines.channels.SendChannel;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.FlowKt;
import kotlinx.coroutines.sync.Mutex;
import kotlinx.coroutines.sync.MutexKt;
import org.json.JSONArray;
import org.json.JSONException;
import sdk.pendo.io.h7.m;
import sdk.pendo.io.h7.n;
import sdk.pendo.io.h7.o;
import sdk.pendo.io.h7.q;
import sdk.pendo.io.h7.r;
import sdk.pendo.io.h7.t;
import sdk.pendo.io.h7.u;
import sdk.pendo.io.logging.PendoLogger;
import sdk.pendo.io.s7.p0;
import sdk.pendo.io.y5.k;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u0096\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0000\u0018\u0000 X2\u00020\u00012\u00020\u0002:\u0001\u000eB9\u0012\u0006\u0010\u001a\u001a\u00020\u0014\u0012\u0006\u0010\u001c\u001a\u00020\u0014\u0012\u0006\u0010\u001d\u001a\u00020\u0014\u0012\u0006\u0010!\u001a\u00020\u001e\u0012\u0006\u0010$\u001a\u00020\"\u0012\b\b\u0002\u0010'\u001a\u00020%¢\u0006\u0004\bV\u0010WJ\u001b\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0082@ø\u0001\u0000¢\u0006\u0004\b\u0006\u0010\u0007J\u001b\u0010\u0006\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\bH\u0082@ø\u0001\u0000¢\u0006\u0004\b\u0006\u0010\nJ\u001b\u0010\u0006\u001a\u00020\u00052\u0006\u0010\f\u001a\u00020\u000bH\u0082@ø\u0001\u0000¢\u0006\u0004\b\u0006\u0010\rJ\u0013\u0010\u000e\u001a\u00020\u0005H\u0082@ø\u0001\u0000¢\u0006\u0004\b\u000e\u0010\u000fJ\u0013\u0010\u0006\u001a\u00020\u0005H\u0082@ø\u0001\u0000¢\u0006\u0004\b\u0006\u0010\u000fJ\b\u0010\u0010\u001a\u00020\u0005H\u0002J\u0013\u0010\u0011\u001a\u00020\u0005H\u0082@ø\u0001\u0000¢\u0006\u0004\b\u0011\u0010\u000fJ\u0010\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0013\u001a\u00020\u0012H\u0002J\b\u0010\u000e\u001a\u00020\u0014H\u0002J\u0010\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0015\u001a\u00020\u0003H\u0016J\b\u0010\u0006\u001a\u00020\u0005H\u0016J\b\u0010\u0011\u001a\u00020\u0016H\u0016R\u0017\u0010\u001a\u001a\u00020\u00148\u0006¢\u0006\f\n\u0004\b\u0006\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019R\u0017\u0010\u001c\u001a\u00020\u00148\u0006¢\u0006\f\n\u0004\b\u000e\u0010\u0017\u001a\u0004\b\u001b\u0010\u0019R\u0014\u0010\u001d\u001a\u00020\u00148\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0011\u0010\u0017R\u0014\u0010!\u001a\u00020\u001e8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001f\u0010 R\u0014\u0010$\u001a\u00020\"8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0018\u0010#R\u0014\u0010'\u001a\u00020%8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0010\u0010&R\u0016\u0010)\u001a\u00020\u00148\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b(\u0010\u0017R\u0016\u0010+\u001a\u00020\u00148\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b*\u0010\u0017R\u0016\u0010.\u001a\u00020\u00168\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b,\u0010-R\u0018\u00102\u001a\u0004\u0018\u00010/8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b0\u00101R\u0018\u00104\u001a\u0004\u0018\u00010/8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b3\u00101R\u0016\u00108\u001a\u0002058\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b6\u00107R\u0018\u0010<\u001a\u0004\u0018\u0001098\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b:\u0010;R\u001b\u0010A\u001a\u00020=8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b>\u0010?\u001a\u0004\b\u001f\u0010@R\u0014\u0010E\u001a\u00020B8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bC\u0010DR\u0018\u0010I\u001a\u0004\u0018\u00010F8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bG\u0010HR\u0014\u0010K\u001a\u0002058\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bJ\u00107R\u001c\u0010O\u001a\b\u0012\u0004\u0012\u00020\u00030L8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bM\u0010NR\u0018\u0010Q\u001a\u0004\u0018\u00010F8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bP\u0010HR\u0014\u0010U\u001a\u00020R8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bS\u0010T\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006Y"}, d2 = {"Lsdk/pendo/io/p7/c;", "", "Lsdk/pendo/io/n7/a;", "Lsdk/pendo/io/h7/u;", "snapshotEvent", "", CmcdData.OBJECT_TYPE_AUDIO_ONLY, "(Lsdk/pendo/io/h7/u;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lsdk/pendo/io/h7/f;", "fullSnapshotData", "(Lsdk/pendo/io/h7/f;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lsdk/pendo/io/h7/h;", "incrementalSnapshotData", "(Lsdk/pendo/io/h7/h;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "b", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "f", "c", "", "recordingSize", "", "snapshotData", "Lsdk/pendo/io/h7/t;", "Ljava/lang/String;", "e", "()Ljava/lang/String;", "sessionVisitorId", "getSessionAccountId", "sessionAccountId", "tabId", "Lsdk/pendo/io/h7/m;", "d", "Lsdk/pendo/io/h7/m;", "configurations", "Lsdk/pendo/io/q7/a;", "Lsdk/pendo/io/q7/a;", "repository", "Lsdk/pendo/io/z6/b;", "Lsdk/pendo/io/z6/b;", "dispatcherProvider", "g", "recordingSessionId", CmcdData.STREAMING_FORMAT_HLS, "recordingId", "i", "Lsdk/pendo/io/h7/t;", "analyticsData", "Lsdk/pendo/io/h7/n;", "j", "Lsdk/pendo/io/h7/n;", "currentEnvelope", "k", "previousEnvelope", "", CmcdData.STREAM_TYPE_LIVE, "J", "recentlySentRecordingsBytes", "Lorg/json/JSONArray;", CmcdData.OBJECT_TYPE_MANIFEST, "Lorg/json/JSONArray;", "currentChildNodesJsonArray", "Lkotlinx/coroutines/CoroutineExceptionHandler;", "n", "Lkotlin/Lazy;", "()Lkotlinx/coroutines/CoroutineExceptionHandler;", "coroutineExceptionHandler", "Lkotlinx/coroutines/CoroutineScope;", "o", "Lkotlinx/coroutines/CoroutineScope;", "coroutineScope", "Lkotlinx/coroutines/Job;", "p", "Lkotlinx/coroutines/Job;", "delayedSendJob", "q", "bufferSize", "Lkotlinx/coroutines/channels/Channel;", "r", "Lkotlinx/coroutines/channels/Channel;", "snapshotsChannel", "s", "snapshotsCollectorJob", "Lkotlinx/coroutines/sync/Mutex;", "t", "Lkotlinx/coroutines/sync/Mutex;", "stateMutex", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lsdk/pendo/io/h7/m;Lsdk/pendo/io/q7/a;Lsdk/pendo/io/z6/b;)V", "u", "pendoIO_release"}, k = 1, mv = {1, 9, 0})
public final class c implements sdk.pendo.io.n7.a {

    /* JADX INFO: renamed from: a, reason: from kotlin metadata */
    private final String sessionVisitorId;

    /* JADX INFO: renamed from: b, reason: from kotlin metadata */
    private final String sessionAccountId;

    /* JADX INFO: renamed from: c, reason: from kotlin metadata */
    private final String tabId;

    /* JADX INFO: renamed from: d, reason: from kotlin metadata */
    private final m configurations;

    /* JADX INFO: renamed from: e, reason: from kotlin metadata */
    private final sdk.pendo.io.q7.a repository;

    /* JADX INFO: renamed from: f, reason: from kotlin metadata */
    private final sdk.pendo.io.z6.b dispatcherProvider;

    /* JADX INFO: renamed from: g, reason: from kotlin metadata */
    private String recordingSessionId;

    /* JADX INFO: renamed from: h, reason: from kotlin metadata */
    private String recordingId;

    /* JADX INFO: renamed from: i, reason: from kotlin metadata */
    private t analyticsData;

    /* JADX INFO: renamed from: j, reason: from kotlin metadata */
    private n currentEnvelope;

    /* JADX INFO: renamed from: k, reason: from kotlin metadata */
    private n previousEnvelope;

    /* JADX INFO: renamed from: l, reason: from kotlin metadata */
    private long recentlySentRecordingsBytes;

    /* JADX INFO: renamed from: m, reason: from kotlin metadata */
    private JSONArray currentChildNodesJsonArray;

    /* JADX INFO: renamed from: n, reason: from kotlin metadata */
    private final Lazy coroutineExceptionHandler;

    /* JADX INFO: renamed from: o, reason: from kotlin metadata */
    private final CoroutineScope coroutineScope;

    /* JADX INFO: renamed from: p, reason: from kotlin metadata */
    private Job delayedSendJob;

    /* JADX INFO: renamed from: q, reason: from kotlin metadata */
    private final long bufferSize;

    /* JADX INFO: renamed from: r, reason: from kotlin metadata */
    private Channel<u> snapshotsChannel;

    /* JADX INFO: renamed from: s, reason: from kotlin metadata */
    private Job snapshotsCollectorJob;

    /* JADX INFO: renamed from: t, reason: from kotlin metadata */
    private final Mutex stateMutex;

    @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 9, 0})
    @DebugMetadata(c = "sdk.pendo.io.sessionreplay.network.RecordingsManager$1", f = "RecordingsManager.kt", i = {}, l = {97}, m = "invokeSuspend", n = {}, s = {})
    static final class a extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int a;

        /* JADX INFO: renamed from: sdk.pendo.io.p7.c$a$a, reason: collision with other inner class name */
        @Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\u008a@¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lsdk/pendo/io/h7/u;", "snapshotEvent", "", CmcdData.OBJECT_TYPE_AUDIO_ONLY, "(Lsdk/pendo/io/h7/u;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;"}, k = 3, mv = {1, 9, 0})
        static final class C0460a<T> implements FlowCollector {
            final /* synthetic */ c a;

            /* JADX INFO: renamed from: sdk.pendo.io.p7.c$a$a$a, reason: collision with other inner class name */
            @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
            @DebugMetadata(c = "sdk.pendo.io.sessionreplay.network.RecordingsManager$1$1", f = "RecordingsManager.kt", i = {0, 0, 1, 1}, l = {303, 100}, m = "emit", n = {"snapshotEvent", "$this$withLock_u24default$iv", "snapshotEvent", "$this$withLock_u24default$iv"}, s = {"L$0", "L$1", "L$0", "L$1"})
            static final class C0461a extends ContinuationImpl {
                Object a;
                Object b;
                Object c;
                /* synthetic */ Object d;
                final /* synthetic */ C0460a<T> e;
                int f;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                C0461a(C0460a<? super T> c0460a, Continuation<? super C0461a> continuation) {
                    super(continuation);
                    this.e = c0460a;
                }

                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                public final Object invokeSuspend(Object obj) {
                    this.d = obj;
                    this.f |= Integer.MIN_VALUE;
                    return this.e.emit(null, this);
                }
            }

            C0460a(c cVar) {
                this.a = cVar;
            }

            /* JADX WARN: Code duplicated, block: B:7:0x0013  */
            @Override // kotlinx.coroutines.flow.FlowCollector
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public final Object emit(u uVar, Continuation<? super Unit> continuation) throws Throwable {
                C0461a c0461a;
                u uVar2;
                Mutex mutex;
                c cVar;
                Mutex mutex2;
                if (continuation instanceof C0461a) {
                    c0461a = (C0461a) continuation;
                    int i = c0461a.f;
                    if ((i & Integer.MIN_VALUE) != 0) {
                        c0461a.f = i - Integer.MIN_VALUE;
                    } else {
                        c0461a = new C0461a(this, continuation);
                    }
                } else {
                    c0461a = new C0461a(this, continuation);
                }
                Object obj = c0461a.d;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                int i2 = c0461a.f;
                try {
                    try {
                        try {
                            if (i2 == 0) {
                                ResultKt.throwOnFailure(obj);
                                mutex = this.a.stateMutex;
                                cVar = this.a;
                                c0461a.a = uVar;
                                c0461a.b = mutex;
                                c0461a.c = cVar;
                                c0461a.f = 1;
                                if (mutex.lock(null, c0461a) != coroutine_suspended) {
                                }
                                return coroutine_suspended;
                            }
                            if (i2 != 1) {
                                if (i2 != 2) {
                                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                                }
                                mutex2 = (Mutex) c0461a.b;
                                try {
                                    ResultKt.throwOnFailure(obj);
                                    Unit unit = Unit.INSTANCE;
                                    mutex2.unlock(null);
                                    return Unit.INSTANCE;
                                } catch (Throwable th) {
                                    mutex = mutex2;
                                    th = th;
                                    mutex.unlock(null);
                                    throw th;
                                }
                            }
                            cVar = (c) c0461a.c;
                            Mutex mutex3 = (Mutex) c0461a.b;
                            uVar2 = (u) c0461a.a;
                            try {
                                ResultKt.throwOnFailure(obj);
                                mutex = mutex3;
                                uVar = uVar2;
                            } catch (Exception e) {
                                e = e;
                                PendoLogger.e("RecordingsManager", "snapshotsCollector -> failed to process " + uVar2, e);
                            }
                            c0461a.a = uVar;
                            c0461a.b = mutex;
                            c0461a.c = null;
                            c0461a.f = 2;
                            if (cVar.a(uVar, c0461a) != coroutine_suspended) {
                                mutex2 = mutex;
                                Unit unit2 = Unit.INSTANCE;
                                mutex2.unlock(null);
                                return Unit.INSTANCE;
                            }
                            return coroutine_suspended;
                        } catch (Throwable th2) {
                            th = th2;
                            mutex.unlock(null);
                            throw th;
                        }
                    } catch (Exception e2) {
                        e = e2;
                        uVar2 = uVar;
                    }
                } catch (CancellationException e3) {
                    throw e3;
                }
            }
        }

        a(Continuation<? super a> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((a) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return c.this.new a(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.a;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                Flow flowConsumeAsFlow = FlowKt.consumeAsFlow(c.this.snapshotsChannel);
                C0460a c0460a = new C0460a(c.this);
                this.a = 1;
                if (flowConsumeAsFlow.collect(c0460a, this) == coroutine_suspended) {
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

    /* JADX INFO: renamed from: sdk.pendo.io.p7.c$c, reason: collision with other inner class name */
    @Metadata(d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"Lkotlinx/coroutines/CoroutineExceptionHandler;", CmcdData.OBJECT_TYPE_AUDIO_ONLY, "()Lkotlinx/coroutines/CoroutineExceptionHandler;"}, k = 3, mv = {1, 9, 0})
    static final class C0462c extends Lambda implements Function0<CoroutineExceptionHandler> {
        public static final C0462c a = new C0462c();

        /* JADX INFO: renamed from: sdk.pendo.io.p7.c$c$a */
        @Metadata(d1 = {"\u0000!\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0003\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u00012\u00020\u0002J\u0018\u0010\b\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0005H\u0016¨\u0006\t¸\u0006\u0000"}, d2 = {"kotlinx/coroutines/CoroutineExceptionHandlerKt$CoroutineExceptionHandler$1", "Lkotlin/coroutines/AbstractCoroutineContextElement;", "Lkotlinx/coroutines/CoroutineExceptionHandler;", "Lkotlin/coroutines/CoroutineContext;", "context", "", "exception", "", "handleException", "kotlinx-coroutines-core"}, k = 1, mv = {1, 9, 0})
        public static final class a extends AbstractCoroutineContextElement implements CoroutineExceptionHandler {
            public a(CoroutineExceptionHandler.Companion companion) {
                super(companion);
            }

            @Override // kotlinx.coroutines.CoroutineExceptionHandler
            public void handleException(CoroutineContext context, Throwable exception) {
                String name;
                CoroutineName coroutineName = (CoroutineName) context.get(CoroutineName.INSTANCE);
                if (coroutineName == null || (name = coroutineName.getName()) == null) {
                    name = "Unknown";
                }
                PendoLogger.e("RecordingsManager", "Uncaught exception in " + name, exception);
            }
        }

        C0462c() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final CoroutineExceptionHandler invoke() {
            return new a(CoroutineExceptionHandler.INSTANCE);
        }
    }

    @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 9, 0})
    @DebugMetadata(c = "sdk.pendo.io.sessionreplay.network.RecordingsManager$forceFlush$1", f = "RecordingsManager.kt", i = {1, 2}, l = {126, 303, 129}, m = "invokeSuspend", n = {"$this$withLock_u24default$iv", "$this$withLock_u24default$iv"}, s = {"L$0", "L$0"})
    static final class d extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        Object a;
        Object b;
        int c;

        d(Continuation<? super d> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((d) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return c.this.new d(continuation);
        }

        /* JADX WARN: Code duplicated, block: B:28:0x0079  */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            c cVar;
            Mutex mutex;
            Throwable th;
            Mutex mutex2;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.c;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                SendChannel.DefaultImpls.close$default(c.this.snapshotsChannel, null, 1, null);
                Job job = c.this.snapshotsCollectorJob;
                if (job != null) {
                    this.c = 1;
                    if (job.join(this) != coroutine_suspended) {
                    }
                }
                return coroutine_suspended;
            }
            if (i != 1) {
                if (i != 2) {
                    if (i != 3) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    mutex2 = (Mutex) this.a;
                    try {
                        ResultKt.throwOnFailure(obj);
                        Unit unit = Unit.INSTANCE;
                        mutex2.unlock(null);
                        return Unit.INSTANCE;
                    } catch (Throwable th2) {
                        th = th2;
                        mutex = mutex2;
                        mutex.unlock(null);
                        throw th;
                    }
                }
                cVar = (c) this.b;
                mutex = (Mutex) this.a;
                ResultKt.throwOnFailure(obj);
                try {
                    this.a = mutex;
                    this.b = null;
                    this.c = 3;
                    if (cVar.a(this) != coroutine_suspended) {
                        mutex2 = mutex;
                        Unit unit2 = Unit.INSTANCE;
                        mutex2.unlock(null);
                        return Unit.INSTANCE;
                    }
                    return coroutine_suspended;
                } catch (Throwable th3) {
                    th = th3;
                    mutex.unlock(null);
                    throw th;
                }
            }
            ResultKt.throwOnFailure(obj);
            c.this.snapshotsCollectorJob = null;
            Mutex mutex3 = c.this.stateMutex;
            cVar = c.this;
            this.a = mutex3;
            this.b = cVar;
            this.c = 2;
            if (mutex3.lock(null, this) != coroutine_suspended) {
                mutex = mutex3;
                this.a = mutex;
                this.b = null;
                this.c = 3;
                if (cVar.a(this) != coroutine_suspended) {
                    mutex2 = mutex;
                    Unit unit3 = Unit.INSTANCE;
                    mutex2.unlock(null);
                    return Unit.INSTANCE;
                }
            }
            return coroutine_suspended;
        }
    }

    @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
    @DebugMetadata(c = "sdk.pendo.io.sessionreplay.network.RecordingsManager", f = "RecordingsManager.kt", i = {0, 0, 1, 1, 1, 1}, l = {Token.DEBUGGER, Context.VERSION_1_7}, m = "handleFullSnapshotEvent", n = {"this", "fullSnapshotData", "this", "screenId", "recordingPayloadData", "timestamp"}, s = {"L$0", "L$1", "L$0", "L$1", "L$2", "J$0"})
    static final class e extends ContinuationImpl {
        Object a;
        Object b;
        Object c;
        long d;
        /* synthetic */ Object e;
        int g;

        e(Continuation<? super e> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.e = obj;
            this.g |= Integer.MIN_VALUE;
            return c.this.a((sdk.pendo.io.h7.f) null, (Continuation<? super Unit>) this);
        }
    }

    @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
    @DebugMetadata(c = "sdk.pendo.io.sessionreplay.network.RecordingsManager", f = "RecordingsManager.kt", i = {0, 0, 0, 1, 1, 1}, l = {191, 196}, m = "handleIncrementalSnapshotEvent", n = {"this", "incrementalSnapshotData", "recordingPayloadData", "this", "incrementalSnapshotData", "recordingPayloadData"}, s = {"L$0", "L$1", "L$2", "L$0", "L$1", "L$2"})
    static final class f extends ContinuationImpl {
        Object a;
        Object b;
        Object c;
        /* synthetic */ Object d;
        int f;

        f(Continuation<? super f> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.d = obj;
            this.f |= Integer.MIN_VALUE;
            return c.this.a((sdk.pendo.io.h7.h) null, (Continuation<? super Unit>) this);
        }
    }

    @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
    @DebugMetadata(c = "sdk.pendo.io.sessionreplay.network.RecordingsManager", f = "RecordingsManager.kt", i = {0, 1}, l = {Token.LOCAL_BLOCK, Token.XML}, m = "handleSnapshotEvent", n = {"logStartTime", "logStartTime"}, s = {"J$0", "J$0"})
    static final class g extends ContinuationImpl {
        long a;
        /* synthetic */ Object b;
        int d;

        g(Continuation<? super g> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.b = obj;
            this.d |= Integer.MIN_VALUE;
            return c.this.a((u) null, this);
        }
    }

    @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 9, 0})
    @DebugMetadata(c = "sdk.pendo.io.sessionreplay.network.RecordingsManager$sendImmediateEnvelop$2", f = "RecordingsManager.kt", i = {0}, l = {253}, m = "invokeSuspend", n = {"it"}, s = {"L$1"})
    static final class h extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        Object a;
        Object b;
        int c;

        h(Continuation<? super h> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((h) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return c.this.new h(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            n nVar;
            c cVar;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.c;
            try {
                if (i == 0) {
                    ResultKt.throwOnFailure(obj);
                    nVar = c.this.currentEnvelope;
                    if (nVar != null) {
                        c cVar2 = c.this;
                        try {
                            sdk.pendo.io.q7.a aVar = cVar2.repository;
                            this.a = cVar2;
                            this.b = nVar;
                            this.c = 1;
                            if (aVar.a(nVar, this) == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                            cVar = cVar2;
                            cVar.a(nVar.c());
                            cVar.previousEnvelope = new n("", "", "", "", "", "", null, nVar.getRecordingPayloadCount(), 0L, false, nVar.getLastKeyFrame(), nVar.getSequence(), 64, null);
                        } catch (k unused) {
                            cVar = cVar2;
                            PendoLogger.d("RecordingsManager", "Buffer limit reached — envelope dropped");
                        } catch (Exception e) {
                            e = e;
                            cVar = cVar2;
                            PendoLogger.e("RecordingsManager", "Failed to persist envelope", e);
                        }
                    }
                } else {
                    if (i != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    nVar = (n) this.b;
                    cVar = (c) this.a;
                    try {
                        ResultKt.throwOnFailure(obj);
                    } catch (k unused2) {
                        PendoLogger.d("RecordingsManager", "Buffer limit reached — envelope dropped");
                    } catch (Exception e2) {
                        e = e2;
                        PendoLogger.e("RecordingsManager", "Failed to persist envelope", e);
                    }
                    cVar.a(nVar.c());
                    cVar.previousEnvelope = new n("", "", "", "", "", "", null, nVar.getRecordingPayloadCount(), 0L, false, nVar.getLastKeyFrame(), nVar.getSequence(), 64, null);
                }
                c.this.currentEnvelope = null;
                return Unit.INSTANCE;
            } catch (CancellationException e3) {
                throw e3;
            }
        }
    }

    @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 9, 0})
    @DebugMetadata(c = "sdk.pendo.io.sessionreplay.network.RecordingsManager$startDelayedEnvelopSend$1", f = "RecordingsManager.kt", i = {1, 2}, l = {PsExtractor.VIDEO_STREAM_MASK, 303, 242}, m = "invokeSuspend", n = {"$this$withLock_u24default$iv", "$this$withLock_u24default$iv"}, s = {"L$0", "L$0"})
    static final class i extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        Object a;
        Object b;
        int c;

        i(Continuation<? super i> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((i) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return c.this.new i(continuation);
        }

        /* JADX WARN: Code duplicated, block: B:25:0x0071  */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            Mutex mutex;
            c cVar;
            Mutex mutex2;
            c cVar2;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.c;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                long recordingPayloadSendingFrequencyTimeMS = c.this.configurations.getRecordingPayloadSendingFrequencyTimeMS();
                this.c = 1;
                if (DelayKt.delay(recordingPayloadSendingFrequencyTimeMS, this) != coroutine_suspended) {
                }
                return coroutine_suspended;
            }
            if (i != 1) {
                if (i != 2) {
                    if (i != 3) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    cVar2 = (c) this.b;
                    mutex2 = (Mutex) this.a;
                    try {
                        ResultKt.throwOnFailure(obj);
                        cVar2.delayedSendJob = null;
                        Unit unit = Unit.INSTANCE;
                        mutex2.unlock(null);
                        return Unit.INSTANCE;
                    } catch (Throwable th) {
                        mutex = mutex2;
                        th = th;
                        mutex.unlock(null);
                        throw th;
                    }
                }
                cVar = (c) this.b;
                Mutex mutex3 = (Mutex) this.a;
                ResultKt.throwOnFailure(obj);
                mutex = mutex3;
                try {
                    this.a = mutex;
                    this.b = cVar;
                    this.c = 3;
                    if (cVar.c(this) != coroutine_suspended) {
                        mutex2 = mutex;
                        cVar2 = cVar;
                        cVar2.delayedSendJob = null;
                        Unit unit2 = Unit.INSTANCE;
                        mutex2.unlock(null);
                        return Unit.INSTANCE;
                    }
                    return coroutine_suspended;
                } catch (Throwable th2) {
                    th = th2;
                    mutex.unlock(null);
                    throw th;
                }
            }
            ResultKt.throwOnFailure(obj);
            mutex = c.this.stateMutex;
            cVar = c.this;
            this.a = mutex;
            this.b = cVar;
            this.c = 2;
            if (mutex.lock(null, this) != coroutine_suspended) {
                this.a = mutex;
                this.b = cVar;
                this.c = 3;
                if (cVar.c(this) != coroutine_suspended) {
                    mutex2 = mutex;
                    cVar2 = cVar;
                    cVar2.delayedSendJob = null;
                    Unit unit3 = Unit.INSTANCE;
                    mutex2.unlock(null);
                    return Unit.INSTANCE;
                }
            }
            return coroutine_suspended;
        }
    }

    public c(String sessionVisitorId, String sessionAccountId, String tabId, m configurations, sdk.pendo.io.q7.a repository, sdk.pendo.io.z6.b dispatcherProvider) {
        Intrinsics.checkNotNullParameter(sessionVisitorId, "sessionVisitorId");
        Intrinsics.checkNotNullParameter(sessionAccountId, "sessionAccountId");
        Intrinsics.checkNotNullParameter(tabId, "tabId");
        Intrinsics.checkNotNullParameter(configurations, "configurations");
        Intrinsics.checkNotNullParameter(repository, "repository");
        Intrinsics.checkNotNullParameter(dispatcherProvider, "dispatcherProvider");
        this.sessionVisitorId = sessionVisitorId;
        this.sessionAccountId = sessionAccountId;
        this.tabId = tabId;
        this.configurations = configurations;
        this.repository = repository;
        this.dispatcherProvider = dispatcherProvider;
        this.coroutineExceptionHandler = LazyKt.lazy(C0462c.a);
        CoroutineScope CoroutineScope = CoroutineScopeKt.CoroutineScope(SupervisorKt.SupervisorJob$default((Job) null, 1, (Object) null).plus(d()).plus(dispatcherProvider.c()));
        this.coroutineScope = CoroutineScope;
        long jG = ((long) 2000) / r.a.g();
        this.bufferSize = jG;
        this.snapshotsChannel = ChannelKt.Channel$default((int) jG, null, null, 6, null);
        this.stateMutex = MutexKt.Mutex$default(false, 1, null);
        String strB = b();
        this.recordingSessionId = strB;
        this.recordingId = strB;
        this.analyticsData = new t(strB, strB);
        this.snapshotsCollectorJob = BuildersKt__Builders_commonKt.launch$default(CoroutineScope, dispatcherProvider.a().plus(new CoroutineName("snapshotsFlowCollector")), null, new a(null), 2, null);
    }

    @Override // sdk.pendo.io.v2.a
    public sdk.pendo.io.u2.a getKoin() {
        return sdk.pendo.io.n7.a.C0430a.a(this);
    }

    public /* synthetic */ c(String str, String str2, String str3, m mVar, sdk.pendo.io.q7.a aVar, sdk.pendo.io.z6.b bVar, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, str2, str3, mVar, aVar, (i2 & 32) != 0 ? sdk.pendo.io.z6.a.a : bVar);
    }

    private final CoroutineExceptionHandler d() {
        return (CoroutineExceptionHandler) this.coroutineExceptionHandler.getValue();
    }

    private final void f() {
        this.delayedSendJob = BuildersKt__Builders_commonKt.launch$default(this.coroutineScope, this.dispatcherProvider.a().plus(new CoroutineName("delayedSend")), null, new i(null), 2, null);
    }

    /* JADX INFO: renamed from: c, reason: from getter */
    public t getAnalyticsData() {
        return this.analyticsData;
    }

    /* JADX INFO: renamed from: e, reason: from getter */
    public final String getSessionVisitorId() {
        return this.sessionVisitorId;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object c(Continuation<? super Unit> continuation) {
        Object objWithContext = BuildersKt.withContext(this.dispatcherProvider.a(), new h(null), continuation);
        return objWithContext == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objWithContext : Unit.INSTANCE;
    }

    private final Object b(Continuation<? super Unit> continuation) {
        Object objA;
        n nVar = this.currentEnvelope;
        return (nVar == null || ((long) nVar.getRecordingPayloadCount()) < this.configurations.getRecordingPayloadSendingFrequencyEvents() || (objA = a(continuation)) != IntrinsicsKt.getCOROUTINE_SUSPENDED()) ? Unit.INSTANCE : objA;
    }

    private final String b() {
        return p0.INSTANCE.a(16);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object a(Continuation<? super Unit> continuation) {
        Job job = this.delayedSendJob;
        if (job != null) {
            Job.DefaultImpls.cancel$default(job, (CancellationException) null, 1, (Object) null);
            this.delayedSendJob = null;
            Object objC = c(continuation);
            if (objC == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
                return objC;
            }
        }
        return Unit.INSTANCE;
    }

    public void a() {
        BuildersKt__Builders_commonKt.launch$default(this.coroutineScope, this.dispatcherProvider.a().plus(new CoroutineName("forceFlush")), null, new d(null), 2, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:7:0x0019  */
    public final Object a(sdk.pendo.io.h7.f fVar, Continuation<? super Unit> continuation) throws JSONException {
        e eVar;
        String retroactiveScreenId;
        c cVar;
        List<? extends q> list;
        long j;
        c cVar2 = this;
        sdk.pendo.io.h7.f fVar2 = fVar;
        if (continuation instanceof e) {
            eVar = (e) continuation;
            int i2 = eVar.g;
            if ((i2 & Integer.MIN_VALUE) != 0) {
                eVar.g = i2 - Integer.MIN_VALUE;
            } else {
                eVar = cVar2.new e(continuation);
            }
        } else {
            eVar = cVar2.new e(continuation);
        }
        Object obj = eVar.e;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i3 = eVar.g;
        if (i3 == 0) {
            ResultKt.throwOnFailure(obj);
            JSONArray jSONArrayA = fVar2.a(cVar2.currentChildNodesJsonArray);
            if (jSONArrayA == null) {
                return Unit.INSTANCE;
            }
            cVar2.currentChildNodesJsonArray = jSONArrayA;
            eVar.a = cVar2;
            eVar.b = fVar2;
            eVar.g = 1;
            if (cVar2.a(eVar) != coroutine_suspended) {
            }
            return coroutine_suspended;
        }
        if (i3 == 1) {
            sdk.pendo.io.h7.f fVar3 = (sdk.pendo.io.h7.f) eVar.b;
            c cVar3 = (c) eVar.a;
            ResultKt.throwOnFailure(obj);
            fVar2 = fVar3;
            cVar2 = cVar3;
        } else {
            if (i3 != 2) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            long j2 = eVar.d;
            list = (List) eVar.c;
            retroactiveScreenId = (String) eVar.b;
            cVar = (c) eVar.a;
            ResultKt.throwOnFailure(obj);
            j = j2;
        }
        cVar.currentEnvelope = new n(cVar.sessionVisitorId, cVar.sessionAccountId, cVar.recordingId, cVar.recordingSessionId, retroactiveScreenId, cVar.tabId, new o(list), 0, j, true, j, 0, 128, null);
        cVar.f();
        return Unit.INSTANCE;
        long timestamp = fVar2.getTimestamp();
        retroactiveScreenId = fVar2.getRetroactiveScreenId();
        List<? extends q> listListOf = CollectionsKt.listOf((Object[]) new u[]{new sdk.pendo.io.h7.i(timestamp, retroactiveScreenId, fVar2.getDisplayData()), fVar2});
        sdk.pendo.io.q7.a aVar = cVar2.repository;
        eVar.a = cVar2;
        eVar.b = retroactiveScreenId;
        eVar.c = listListOf;
        eVar.d = timestamp;
        eVar.g = 2;
        if (aVar.a(listListOf, eVar) != coroutine_suspended) {
            cVar = cVar2;
            list = listListOf;
            j = timestamp;
            cVar.currentEnvelope = new n(cVar.sessionVisitorId, cVar.sessionAccountId, cVar.recordingId, cVar.recordingSessionId, retroactiveScreenId, cVar.tabId, new o(list), 0, j, true, j, 0, 128, null);
            cVar.f();
            return Unit.INSTANCE;
        }
        return coroutine_suspended;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:29:0x0099  */
    /* JADX WARN: Code duplicated, block: B:31:0x009d  */
    /* JADX WARN: Code duplicated, block: B:7:0x0017  */
    public final Object a(sdk.pendo.io.h7.h hVar, Continuation<? super Unit> continuation) {
        f fVar;
        List<? extends q> listListOf;
        sdk.pendo.io.h7.h hVar2;
        List<? extends q> list;
        Unit unit;
        c cVar;
        List<? extends q> list2;
        sdk.pendo.io.h7.h hVar3;
        n nVar;
        c cVar2 = this;
        if (continuation instanceof f) {
            fVar = (f) continuation;
            int i2 = fVar.f;
            if ((i2 & Integer.MIN_VALUE) != 0) {
                fVar.f = i2 - Integer.MIN_VALUE;
            } else {
                fVar = cVar2.new f(continuation);
            }
        } else {
            fVar = cVar2.new f(continuation);
        }
        Object obj = fVar.d;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i3 = fVar.f;
        if (i3 == 0) {
            ResultKt.throwOnFailure(obj);
            listListOf = CollectionsKt.listOf(hVar);
            sdk.pendo.io.q7.a aVar = cVar2.repository;
            fVar.a = cVar2;
            fVar.b = hVar;
            fVar.c = listListOf;
            fVar.f = 1;
            if (aVar.a(listListOf, fVar) != coroutine_suspended) {
                hVar2 = hVar;
            }
            return coroutine_suspended;
        }
        if (i3 == 1) {
            List<? extends q> list3 = (List) fVar.c;
            hVar2 = (sdk.pendo.io.h7.h) fVar.b;
            c cVar3 = (c) fVar.a;
            ResultKt.throwOnFailure(obj);
            listListOf = list3;
            cVar2 = cVar3;
        } else {
            if (i3 != 2) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            list2 = (List) fVar.c;
            hVar3 = (sdk.pendo.io.h7.h) fVar.b;
            cVar = (c) fVar.a;
            ResultKt.throwOnFailure(obj);
        }
        unit = Unit.INSTANCE;
        c cVar4 = cVar;
        list = list2;
        cVar2 = cVar4;
        hVar2 = hVar3;
        if (unit == null) {
            nVar = cVar2.previousEnvelope;
            if (nVar != null) {
                cVar2.currentEnvelope = new n(cVar2.sessionVisitorId, cVar2.sessionAccountId, cVar2.recordingId, cVar2.recordingSessionId, hVar2.getRetroactiveScreenId(), cVar2.tabId, new o(list), 0, hVar2.getTimestamp(), false, nVar.getLastKeyFrame(), nVar.getRecordingPayloadCount() + nVar.getSequence(), 128, null);
            }
            cVar2.f();
        }
        return Unit.INSTANCE;
        n nVar2 = cVar2.currentEnvelope;
        if (nVar2 != null) {
            nVar2.a(listListOf);
            fVar.a = cVar2;
            fVar.b = hVar2;
            fVar.c = listListOf;
            fVar.f = 2;
            if (cVar2.b(fVar) != coroutine_suspended) {
                cVar = cVar2;
                list2 = listListOf;
                hVar3 = hVar2;
                unit = Unit.INSTANCE;
                c cVar5 = cVar;
                list = list2;
                cVar2 = cVar5;
                hVar2 = hVar3;
            }
            return coroutine_suspended;
        }
        list = listListOf;
        unit = null;
        if (unit == null) {
            nVar = cVar2.previousEnvelope;
            if (nVar != null) {
                cVar2.currentEnvelope = new n(cVar2.sessionVisitorId, cVar2.sessionAccountId, cVar2.recordingId, cVar2.recordingSessionId, hVar2.getRetroactiveScreenId(), cVar2.tabId, new o(list), 0, hVar2.getTimestamp(), false, nVar.getLastKeyFrame(), nVar.getRecordingPayloadCount() + nVar.getSequence(), 128, null);
            }
            cVar2.f();
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x004c, code lost:
    
        if (a((sdk.pendo.io.h7.f) r8, (kotlin.coroutines.Continuation<? super kotlin.Unit>) r0) == r1) goto L25;
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x005d, code lost:
    
        if (a((sdk.pendo.io.h7.h) r8, (kotlin.coroutines.Continuation<? super kotlin.Unit>) r0) == r1) goto L25;
     */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x005f, code lost:
    
        return r1;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object a(sdk.pendo.io.h7.u r8, kotlin.coroutines.Continuation<? super kotlin.Unit> r9) {
        /*
            r7 = this;
            boolean r0 = r9 instanceof sdk.pendo.io.p7.c.g
            if (r0 == 0) goto L13
            r0 = r9
            sdk.pendo.io.p7.c$g r0 = (sdk.pendo.io.p7.c.g) r0
            int r1 = r0.d
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.d = r1
            goto L18
        L13:
            sdk.pendo.io.p7.c$g r0 = new sdk.pendo.io.p7.c$g
            r0.<init>(r9)
        L18:
            java.lang.Object r9 = r0.b
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.d
            r3 = 2
            r4 = 1
            if (r2 == 0) goto L37
            if (r2 == r4) goto L31
            if (r2 != r3) goto L29
            goto L31
        L29:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.String r8 = "call to 'resume' before 'invoke' with coroutine"
            r7.<init>(r8)
            throw r7
        L31:
            long r7 = r0.a
            kotlin.ResultKt.throwOnFailure(r9)
            goto L61
        L37:
            kotlin.ResultKt.throwOnFailure(r9)
            long r5 = java.lang.System.currentTimeMillis()
            boolean r9 = r8 instanceof sdk.pendo.io.h7.f
            if (r9 == 0) goto L4f
            sdk.pendo.io.h7.f r8 = (sdk.pendo.io.h7.f) r8
            r0.a = r5
            r0.d = r4
            java.lang.Object r7 = r7.a(r8, r0)
            if (r7 != r1) goto L60
            goto L5f
        L4f:
            boolean r9 = r8 instanceof sdk.pendo.io.h7.h
            if (r9 == 0) goto L60
            sdk.pendo.io.h7.h r8 = (sdk.pendo.io.h7.h) r8
            r0.a = r5
            r0.d = r3
            java.lang.Object r7 = r7.a(r8, r0)
            if (r7 != r1) goto L60
        L5f:
            return r1
        L60:
            r7 = r5
        L61:
            long r0 = java.lang.System.currentTimeMillis()
            long r0 = r0 - r7
            java.lang.StringBuilder r7 = new java.lang.StringBuilder
            java.lang.String r8 = "startSnapshotsCollector -> process of snapshotEvent took "
            r7.<init>(r8)
            java.lang.StringBuilder r7 = r7.append(r0)
            java.lang.String r7 = r7.toString()
            java.lang.Object[] r7 = new java.lang.Object[]{r7}
            java.lang.String r8 = "RecordingsManager"
            sdk.pendo.io.logging.PendoLogger.d(r8, r7)
            kotlin.Unit r7 = kotlin.Unit.INSTANCE
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: sdk.pendo.io.p7.c.a(sdk.pendo.io.h7.u, kotlin.coroutines.Continuation):java.lang.Object");
    }

    public void a(u snapshotData) {
        Intrinsics.checkNotNullParameter(snapshotData, "snapshotData");
        Object obj = this.snapshotsChannel.mo11206trySendJP2dKIU(snapshotData);
        if (ChannelResult.m16343isFailureimpl(obj)) {
            PendoLogger.d("RecordingsManager", "recordSnapshot -> failed to add snapshotData to the buffer " + ChannelResult.m16345toStringimpl(obj));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void a(int recordingSize) {
        long j = this.recentlySentRecordingsBytes + ((long) recordingSize);
        this.recentlySentRecordingsBytes = j;
        if (j >= this.configurations.getRecordingSizeLimit()) {
            this.recentlySentRecordingsBytes = 0L;
            String strB = b();
            this.recordingId = strB;
            this.analyticsData = t.a(this.analyticsData, strB, null, 2, null);
        }
    }
}
