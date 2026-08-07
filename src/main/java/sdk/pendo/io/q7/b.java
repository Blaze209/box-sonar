package sdk.pendo.io.q7;

import androidx.media3.exoplayer.upstream.CmcdData;
import com.box.boxandroidlibv2private.dao.BoxConvertedPushNotificationDevice;
import external.sdk.pendo.io.mozilla.javascript.Token;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CancellationException;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.AbstractCoroutineContextElement;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.CoroutineExceptionHandler;
import kotlinx.coroutines.CoroutineName;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.SupervisorKt;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.FlowKt;
import kotlinx.coroutines.flow.MutableStateFlow;
import kotlinx.coroutines.flow.StateFlow;
import kotlinx.coroutines.flow.StateFlowKt;
import org.json.JSONArray;
import sdk.pendo.io.h7.m;
import sdk.pendo.io.h7.n;
import sdk.pendo.io.h7.q;
import sdk.pendo.io.h7.r;
import sdk.pendo.io.logging.PendoLogger;
import sdk.pendo.io.m7.c;
import sdk.pendo.io.models.SessionData;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u0094\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\n\b\u0000\u0018\u0000 F2\u00020\u0001:\u0001\u001bB5\u0012\u0006\u0010\u0016\u001a\u00020\u0014\u0012\u0006\u0010\u0019\u001a\u00020\u0017\u0012\u0006\u0010\u001d\u001a\u00020\u001a\u0012\b\b\u0002\u0010!\u001a\u00020\u001e\u0012\n\b\u0002\u0010C\u001a\u0004\u0018\u00010&¢\u0006\u0004\bD\u0010EJ\b\u0010\u0003\u001a\u00020\u0002H\u0002J\u0013\u0010\u0004\u001a\u00020\u0002H\u0082@ø\u0001\u0000¢\u0006\u0004\b\u0004\u0010\u0005J\u001b\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0006H\u0082@ø\u0001\u0000¢\u0006\u0004\b\u0004\u0010\bJ\u001b\u0010\u0004\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\tH\u0096@ø\u0001\u0000¢\u0006\u0004\b\u0004\u0010\u000bJ\u001f\u0010\u0004\u001a\u0004\u0018\u00010\u000e2\b\u0010\r\u001a\u0004\u0018\u00010\fH\u0096@ø\u0001\u0000¢\u0006\u0004\b\u0004\u0010\u000fJ!\u0010\u0004\u001a\u00020\u00022\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00110\u0010H\u0096@ø\u0001\u0000¢\u0006\u0004\b\u0004\u0010\u0013R\u0014\u0010\u0016\u001a\u00020\u00148\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0004\u0010\u0015R\u0014\u0010\u0019\u001a\u00020\u00178\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010\u0018R\u0014\u0010\u001d\u001a\u00020\u001a8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001b\u0010\u001cR\u0014\u0010!\u001a\u00020\u001e8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001f\u0010 R\u0014\u0010%\u001a\u00020\"8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b#\u0010$R\u0014\u0010)\u001a\u00020&8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b'\u0010(R\u001a\u0010/\u001a\u00020*8\u0002X\u0082\u0004¢\u0006\f\n\u0004\b+\u0010,\u0012\u0004\b-\u0010.R\u0018\u00103\u001a\u0004\u0018\u0001008\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b1\u00102R\u0018\u00107\u001a\u0004\u0018\u0001048\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b5\u00106R\u001a\u0010<\u001a\b\u0012\u0004\u0012\u000209088\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b:\u0010;R\u0016\u0010@\u001a\u00020=8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b>\u0010?R\u0014\u0010B\u001a\u0002048BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010A\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006G"}, d2 = {"Lsdk/pendo/io/q7/b;", "Lsdk/pendo/io/q7/a;", "", "b", CmcdData.OBJECT_TYPE_AUDIO_ONLY, "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lsdk/pendo/io/m7/c;", "entity", "(Lsdk/pendo/io/m7/c;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lsdk/pendo/io/h7/n;", "envelope", "(Lsdk/pendo/io/h7/n;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lsdk/pendo/io/models/SessionData;", "sessionData", "Lsdk/pendo/io/h7/m;", "(Lsdk/pendo/io/models/SessionData;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "", "Lsdk/pendo/io/h7/q;", BoxConvertedPushNotificationDevice.EVENTS, "(Ljava/util/List;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lsdk/pendo/io/l7/a;", "Lsdk/pendo/io/l7/a;", "remoteDataSource", "Lsdk/pendo/io/k7/a;", "Lsdk/pendo/io/k7/a;", "localDataSource", "Lsdk/pendo/io/f6/e;", "c", "Lsdk/pendo/io/f6/e;", "connectivityMonitor", "Lsdk/pendo/io/z6/b;", "d", "Lsdk/pendo/io/z6/b;", "dispatcherProvider", "Lkotlinx/coroutines/CoroutineExceptionHandler;", "e", "Lkotlinx/coroutines/CoroutineExceptionHandler;", "coroutineExceptionHandler", "Lkotlinx/coroutines/CoroutineScope;", "f", "Lkotlinx/coroutines/CoroutineScope;", "coroutineScope", "Lkotlinx/coroutines/CoroutineDispatcher;", "g", "Lkotlinx/coroutines/CoroutineDispatcher;", "getSingleThreadDispatcher$annotations", "()V", "singleThreadDispatcher", "Lkotlinx/coroutines/Job;", CmcdData.STREAMING_FORMAT_HLS, "Lkotlinx/coroutines/Job;", "drainJob", "", "i", "Ljava/lang/Boolean;", "previousOnlineState", "Lkotlinx/coroutines/flow/MutableStateFlow;", "Lsdk/pendo/io/h7/j;", "j", "Lkotlinx/coroutines/flow/MutableStateFlow;", "_transportMode", "", "k", "J", "offlineStorageMaxBytes", "()Z", "canTransmitSR", "externalScope", "<init>", "(Lsdk/pendo/io/l7/a;Lsdk/pendo/io/k7/a;Lsdk/pendo/io/f6/e;Lsdk/pendo/io/z6/b;Lkotlinx/coroutines/CoroutineScope;)V", CmcdData.STREAM_TYPE_LIVE, "pendoIO_release"}, k = 1, mv = {1, 9, 0})
public final class b implements sdk.pendo.io.q7.a {

    /* JADX INFO: renamed from: a, reason: from kotlin metadata */
    private final sdk.pendo.io.l7.a remoteDataSource;

    /* JADX INFO: renamed from: b, reason: from kotlin metadata */
    private final sdk.pendo.io.k7.a localDataSource;

    /* JADX INFO: renamed from: c, reason: from kotlin metadata */
    private final sdk.pendo.io.f6.e connectivityMonitor;

    /* JADX INFO: renamed from: d, reason: from kotlin metadata */
    private final sdk.pendo.io.z6.b dispatcherProvider;

    /* JADX INFO: renamed from: e, reason: from kotlin metadata */
    private final CoroutineExceptionHandler coroutineExceptionHandler;

    /* JADX INFO: renamed from: f, reason: from kotlin metadata */
    private final CoroutineScope coroutineScope;

    /* JADX INFO: renamed from: g, reason: from kotlin metadata */
    private final CoroutineDispatcher singleThreadDispatcher;

    /* JADX INFO: renamed from: h, reason: from kotlin metadata */
    private volatile Job drainJob;

    /* JADX INFO: renamed from: i, reason: from kotlin metadata */
    private volatile Boolean previousOnlineState;

    /* JADX INFO: renamed from: j, reason: from kotlin metadata */
    private final MutableStateFlow<sdk.pendo.io.h7.j> _transportMode;

    /* JADX INFO: renamed from: k, reason: from kotlin metadata */
    private volatile long offlineStorageMaxBytes;

    @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 9, 0})
    @DebugMetadata(c = "sdk.pendo.io.sessionreplay.repositories.SRRepository$1", f = "SRRepository.kt", i = {}, l = {74}, m = "invokeSuspend", n = {}, s = {})
    static final class a extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int a;

        /* JADX INFO: renamed from: sdk.pendo.io.q7.b$a$a, reason: collision with other inner class name */
        @Metadata(d1 = {"\u0000\u000e\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\u008a@¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"", "isOnline", "", CmcdData.OBJECT_TYPE_AUDIO_ONLY, "(ZLkotlin/coroutines/Continuation;)Ljava/lang/Object;"}, k = 3, mv = {1, 9, 0})
        static final class C0465a<T> implements FlowCollector {
            final /* synthetic */ b a;

            C0465a(b bVar) {
                this.a = bVar;
            }

            public final Object a(boolean z, Continuation<? super Unit> continuation) {
                Boolean bool = this.a.previousOnlineState;
                this.a.previousOnlineState = Boxing.boxBoolean(z);
                if (bool != null) {
                    sdk.pendo.io.s7.d.a(z);
                }
                return Unit.INSTANCE;
            }

            @Override // kotlinx.coroutines.flow.FlowCollector
            public /* bridge */ /* synthetic */ Object emit(Object obj, Continuation continuation) {
                return a(((Boolean) obj).booleanValue(), continuation);
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
            return b.this.new a(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.a;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                StateFlow<Boolean> stateFlowD = b.this.connectivityMonitor.d();
                C0465a c0465a = new C0465a(b.this);
                this.a = 1;
                if (stateFlowD.collect(c0465a, this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
            throw new KotlinNothingValueException();
        }
    }

    /* JADX INFO: renamed from: sdk.pendo.io.q7.b$b, reason: collision with other inner class name */
    @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 9, 0})
    @DebugMetadata(c = "sdk.pendo.io.sessionreplay.repositories.SRRepository$2", f = "SRRepository.kt", i = {}, l = {91}, m = "invokeSuspend", n = {}, s = {})
    static final class C0466b extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int a;

        /* JADX INFO: renamed from: sdk.pendo.io.q7.b$b$a */
        @Metadata(d1 = {"\u0000\u0014\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u00002\u0006\u0010\u0004\u001a\u00020\u0003H\u008a@"}, d2 = {"", "<anonymous parameter 0>", "<anonymous parameter 1>", "Lsdk/pendo/io/h7/j;", "<anonymous parameter 2>", "", "<anonymous>"}, k = 3, mv = {1, 9, 0})
        @DebugMetadata(c = "sdk.pendo.io.sessionreplay.repositories.SRRepository$2$1", f = "SRRepository.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
        static final class a extends SuspendLambda implements Function4<Boolean, Boolean, sdk.pendo.io.h7.j, Continuation<? super Unit>, Object> {
            int a;

            a(Continuation<? super a> continuation) {
                super(4, continuation);
            }

            public final Object a(boolean z, boolean z2, sdk.pendo.io.h7.j jVar, Continuation<? super Unit> continuation) {
                return new a(continuation).invokeSuspend(Unit.INSTANCE);
            }

            @Override // kotlin.jvm.functions.Function4
            public /* bridge */ /* synthetic */ Object invoke(Boolean bool, Boolean bool2, sdk.pendo.io.h7.j jVar, Continuation<? super Unit> continuation) {
                return a(bool.booleanValue(), bool2.booleanValue(), jVar, continuation);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object obj) {
                IntrinsicsKt.getCOROUTINE_SUSPENDED();
                if (this.a != 0) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
                return Unit.INSTANCE;
            }
        }

        /* JADX INFO: renamed from: sdk.pendo.io.q7.b$b$b, reason: collision with other inner class name */
        @Metadata(d1 = {"\u0000\b\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0002\u001a\u00020\u00002\u0006\u0010\u0001\u001a\u00020\u0000H\u008a@¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"", "it", CmcdData.OBJECT_TYPE_AUDIO_ONLY, "(Lkotlin/Unit;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;"}, k = 3, mv = {1, 9, 0})
        static final class C0467b<T> implements FlowCollector {
            final /* synthetic */ b a;

            C0467b(b bVar) {
                this.a = bVar;
            }

            @Override // kotlinx.coroutines.flow.FlowCollector
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public final Object emit(Unit unit, Continuation<? super Unit> continuation) {
                if (this.a.a()) {
                    PendoLogger.d("SRRepository", "canTransmitSR=true, triggering drain");
                    this.a.b();
                }
                return Unit.INSTANCE;
            }
        }

        C0466b(Continuation<? super C0466b> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C0466b) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return b.this.new C0466b(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.a;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                Flow flowCombine = FlowKt.combine(b.this.connectivityMonitor.d(), b.this.connectivityMonitor.c(), b.this._transportMode, new a(null));
                C0467b c0467b = new C0467b(b.this);
                this.a = 1;
                if (flowCombine.collect(c0467b, this) == coroutine_suspended) {
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

    @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
    @DebugMetadata(c = "sdk.pendo.io.sessionreplay.repositories.SRRepository", f = "SRRepository.kt", i = {0, 1, 2, 2, 3}, l = {Token.COLONCOLON, Token.SET, Token.SETCONST, Token.LAST_TOKEN}, m = "executeDrain", n = {"this", "this", "this", "currentlySending", "this"}, s = {"L$0", "L$0", "L$0", "I$0", "L$0"})
    static final class d extends ContinuationImpl {
        Object a;
        int b;
        /* synthetic */ Object c;
        int e;

        d(Continuation<? super d> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.c = obj;
            this.e |= Integer.MIN_VALUE;
            return b.this.a(this);
        }
    }

    @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 9, 0})
    @DebugMetadata(c = "sdk.pendo.io.sessionreplay.repositories.SRRepository$executeDrain$2$1", f = "SRRepository.kt", i = {}, l = {Token.GENEXPR}, m = "invokeSuspend", n = {}, s = {})
    static final class e extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int a;
        final /* synthetic */ c c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        e(c cVar, Continuation<? super e> continuation) {
            super(2, continuation);
            this.c = cVar;
        }

        @Override // kotlin.jvm.functions.Function2
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((e) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return b.this.new e(this.c, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.a;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                b bVar = b.this;
                c cVar = this.c;
                this.a = 1;
                if (bVar.a(cVar, this) == coroutine_suspended) {
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

    @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0002\u001a\u0004\u0018\u00010\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "Lsdk/pendo/io/h7/m;", "<anonymous>"}, k = 3, mv = {1, 9, 0})
    @DebugMetadata(c = "sdk.pendo.io.sessionreplay.repositories.SRRepository$getConfigurations$2", f = "SRRepository.kt", i = {}, l = {187}, m = "invokeSuspend", n = {}, s = {})
    static final class f extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super m>, Object> {
        int a;
        final /* synthetic */ SessionData c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        f(SessionData sessionData, Continuation<? super f> continuation) {
            super(2, continuation);
            this.c = sessionData;
        }

        @Override // kotlin.jvm.functions.Function2
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super m> continuation) {
            return ((f) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return b.this.new f(this.c, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object value;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.a;
            try {
                if (i == 0) {
                    ResultKt.throwOnFailure(obj);
                    sdk.pendo.io.l7.a aVar = b.this.remoteDataSource;
                    SessionData sessionData = this.c;
                    this.a = 1;
                    obj = aVar.a(sessionData, this);
                    if (obj == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                } else {
                    if (i != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    ResultKt.throwOnFailure(obj);
                }
                m mVar = (m) obj;
                if (mVar == null) {
                    return null;
                }
                b bVar = b.this;
                PendoLogger.d("SRRepository", "Applying config: transportMode=" + mVar.c() + ", offlineStorageLimit=" + mVar.d());
                MutableStateFlow mutableStateFlow = bVar._transportMode;
                do {
                    value = mutableStateFlow.getValue();
                } while (!mutableStateFlow.compareAndSet(value, mVar.c()));
                bVar.offlineStorageMaxBytes = mVar.d();
                return mVar;
            } catch (CancellationException e) {
                throw e;
            } catch (Exception e2) {
                PendoLogger.d("SRRepository", "getConfigurations: failed " + e2.getMessage());
                return null;
            }
        }
    }

    @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 9, 0})
    @DebugMetadata(c = "sdk.pendo.io.sessionreplay.repositories.SRRepository$sendDataToDebugger$2", f = "SRRepository.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    static final class g extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int a;
        final /* synthetic */ List<q> b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        g(List<? extends q> list, Continuation<? super g> continuation) {
            super(2, continuation);
            this.b = list;
        }

        @Override // kotlin.jvm.functions.Function2
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((g) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new g(this.b, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.a != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            try {
                if (!r.a.e()) {
                    return Unit.INSTANCE;
                }
                JSONArray jSONArray = new JSONArray();
                Iterator<T> it = this.b.iterator();
                while (it.hasNext()) {
                    jSONArray.put(((q) it.next()).a());
                }
                sdk.pendo.io.p6.b.a(sdk.pendo.io.m6.a.EVENT_DEBUG_MODE_RECORDING_EVENT.b(), jSONArray);
                return Unit.INSTANCE;
            } catch (Exception e) {
                PendoLogger.d("SRRepository", "sendDataToDebugger: failed to send data to debugger " + e.getMessage());
            }
        }
    }

    @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
    @DebugMetadata(c = "sdk.pendo.io.sessionreplay.repositories.SRRepository", f = "SRRepository.kt", i = {0, 0, 1, 1, 2, 2}, l = {173, 174, 175, 180}, m = "sendEntity", n = {"this", "entity", "this", "entity", "this", "entity"}, s = {"L$0", "L$1", "L$0", "L$1", "L$0", "L$1"})
    static final class h extends ContinuationImpl {
        Object a;
        Object b;
        /* synthetic */ Object c;
        int e;

        h(Continuation<? super h> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.c = obj;
            this.e |= Integer.MIN_VALUE;
            return b.this.a((c) null, this);
        }
    }

    @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 9, 0})
    @DebugMetadata(c = "sdk.pendo.io.sessionreplay.repositories.SRRepository$sendEnvelope$2", f = "SRRepository.kt", i = {0}, l = {106, 116, 119}, m = "invokeSuspend", n = {"json"}, s = {"L$0"})
    static final class i extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        Object a;
        int b;
        final /* synthetic */ n c;
        final /* synthetic */ b d;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        i(n nVar, b bVar, Continuation<? super i> continuation) {
            super(2, continuation);
            this.c = nVar;
            this.d = bVar;
        }

        @Override // kotlin.jvm.functions.Function2
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((i) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new i(this.c, this.d, continuation);
        }

        /* JADX WARN: Code restructure failed: missing block: B:20:0x00b6, code lost:
        
            if (r13.a(r1, r12) == r0) goto L24;
         */
        /* JADX WARN: Code restructure failed: missing block: B:23:0x00c7, code lost:
        
            if (r13.a(r1, r12) == r0) goto L24;
         */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final java.lang.Object invokeSuspend(java.lang.Object r13) throws org.json.JSONException, sdk.pendo.io.y5.k {
            /*
                Method dump skipped, instruction units count: 244
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: sdk.pendo.io.q7.b.i.invokeSuspend(java.lang.Object):java.lang.Object");
        }
    }

    @Metadata(d1 = {"\u0000!\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0003\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u00012\u00020\u0002J\u0018\u0010\b\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0005H\u0016¨\u0006\t¸\u0006\u0000"}, d2 = {"kotlinx/coroutines/CoroutineExceptionHandlerKt$CoroutineExceptionHandler$1", "Lkotlin/coroutines/AbstractCoroutineContextElement;", "Lkotlinx/coroutines/CoroutineExceptionHandler;", "Lkotlin/coroutines/CoroutineContext;", "context", "", "exception", "", "handleException", "kotlinx-coroutines-core"}, k = 1, mv = {1, 9, 0})
    public static final class j extends AbstractCoroutineContextElement implements CoroutineExceptionHandler {
        public j(CoroutineExceptionHandler.Companion companion) {
            super(companion);
        }

        @Override // kotlinx.coroutines.CoroutineExceptionHandler
        public void handleException(CoroutineContext context, Throwable exception) {
            String name;
            CoroutineName coroutineName = (CoroutineName) context.get(CoroutineName.INSTANCE);
            if (coroutineName == null || (name = coroutineName.getName()) == null) {
                name = "Unknown";
            }
            PendoLogger.e("SRRepository", "Uncaught exception in " + name, exception);
        }
    }

    @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 9, 0})
    @DebugMetadata(c = "sdk.pendo.io.sessionreplay.repositories.SRRepository$startDrain$1", f = "SRRepository.kt", i = {}, l = {Token.LOOP}, m = "invokeSuspend", n = {}, s = {})
    static final class k extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int a;

        k(Continuation<? super k> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((k) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return b.this.new k(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.a;
            try {
                if (i == 0) {
                    ResultKt.throwOnFailure(obj);
                    PendoLogger.d("SRRepository", "Drain started");
                    b bVar = b.this;
                    this.a = 1;
                    if (bVar.a(this) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                } else {
                    if (i != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    ResultKt.throwOnFailure(obj);
                }
            } catch (CancellationException e) {
                PendoLogger.d("SRRepository", "Drain cancelled");
                throw e;
            } catch (Exception e2) {
                PendoLogger.e("SRRepository", "Drain failed with unexpected error", e2);
            }
            PendoLogger.d("SRRepository", "Drain finished");
            return Unit.INSTANCE;
        }
    }

    public b(sdk.pendo.io.l7.a remoteDataSource, sdk.pendo.io.k7.a localDataSource, sdk.pendo.io.f6.e connectivityMonitor, sdk.pendo.io.z6.b dispatcherProvider, CoroutineScope coroutineScope) {
        Intrinsics.checkNotNullParameter(remoteDataSource, "remoteDataSource");
        Intrinsics.checkNotNullParameter(localDataSource, "localDataSource");
        Intrinsics.checkNotNullParameter(connectivityMonitor, "connectivityMonitor");
        Intrinsics.checkNotNullParameter(dispatcherProvider, "dispatcherProvider");
        this.remoteDataSource = remoteDataSource;
        this.localDataSource = localDataSource;
        this.connectivityMonitor = connectivityMonitor;
        this.dispatcherProvider = dispatcherProvider;
        j jVar = new j(CoroutineExceptionHandler.INSTANCE);
        this.coroutineExceptionHandler = jVar;
        CoroutineScope CoroutineScope = coroutineScope == null ? CoroutineScopeKt.CoroutineScope(SupervisorKt.SupervisorJob$default((Job) null, 1, (Object) null).plus(jVar).plus(dispatcherProvider.a())) : coroutineScope;
        this.coroutineScope = CoroutineScope;
        this.singleThreadDispatcher = dispatcherProvider.a().limitedParallelism(1);
        this._transportMode = StateFlowKt.MutableStateFlow(sdk.pendo.io.h7.j.WIFI_ONLY);
        this.offlineStorageMaxBytes = 262144000L;
        BuildersKt__Builders_commonKt.launch$default(CoroutineScope, null, null, new a(null), 3, null);
        BuildersKt__Builders_commonKt.launch$default(CoroutineScope, null, null, new C0466b(null), 3, null);
    }

    public /* synthetic */ b(sdk.pendo.io.l7.a aVar, sdk.pendo.io.k7.a aVar2, sdk.pendo.io.f6.e eVar, sdk.pendo.io.z6.b bVar, CoroutineScope coroutineScope, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(aVar, aVar2, eVar, (i2 & 8) != 0 ? sdk.pendo.io.z6.a.a : bVar, (i2 & 16) != 0 ? null : coroutineScope);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void b() {
        Job job = this.drainJob;
        if (job == null || !job.isActive()) {
            this.drainJob = BuildersKt__Builders_commonKt.launch$default(this.coroutineScope, null, null, new k(null), 3, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:19:0x004a A[PHI: r14 r15
      0x004a: PHI (r14v1 'this' sdk.pendo.io.q7.b) = (r14v3 'this' sdk.pendo.io.q7.b), (r14v19 'this' sdk.pendo.io.q7.b) binds: [B:28:0x007f, B:18:0x0043] A[DONT_GENERATE, DONT_INLINE]
      0x004a: PHI (r15v4 java.lang.Object) = (r15v10 java.lang.Object), (r15v1 java.lang.Object) binds: [B:28:0x007f, B:18:0x0043] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:24:0x0065 A[PHI: r14
      0x0065: PHI (r14v3 'this' sdk.pendo.io.q7.b) = 
      (r14v0 'this' sdk.pendo.io.q7.b A[IMMUTABLE_TYPE, THIS])
      (r14v6 'this' sdk.pendo.io.q7.b)
      (r14v17 'this' sdk.pendo.io.q7.b)
     binds: [B:22:0x0061, B:46:0x0107, B:20:0x004c] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:26:0x006b  */
    /* JADX WARN: Code duplicated, block: B:27:0x0075  */
    /* JADX WARN: Code duplicated, block: B:32:0x008d  */
    /* JADX WARN: Code duplicated, block: B:45:0x00fc A[PHI: r2
      0x00fc: PHI (r2v2 sdk.pendo.io.q7.b) = (r2v1 sdk.pendo.io.q7.b), (r2v3 sdk.pendo.io.q7.b) binds: [B:31:0x008b, B:48:0x00fc] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:46:0x0107 -> B:24:0x0065). Please report as a decompilation issue!!! */
    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions stack size limit reached
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        */
    public final java.lang.Object a(kotlin.coroutines.Continuation<? super kotlin.Unit> r15) {
        /*
            Method dump skipped, instruction units count: 266
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: sdk.pendo.io.q7.b.a(kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean a() {
        if (this.connectivityMonitor.d().getValue().booleanValue()) {
            return this._transportMode.getValue() == sdk.pendo.io.h7.j.WIFI_AND_CELLULAR || !this.connectivityMonitor.c().getValue().booleanValue();
        }
        return false;
    }

    @Override // sdk.pendo.io.q7.a
    public Object a(SessionData sessionData, Continuation<? super m> continuation) {
        return BuildersKt.withContext(this.dispatcherProvider.a(), new f(sessionData, null), continuation);
    }

    @Override // sdk.pendo.io.q7.a
    public Object a(List<? extends q> list, Continuation<? super Unit> continuation) {
        BuildersKt__Builders_commonKt.launch$default(this.coroutineScope, this.singleThreadDispatcher, null, new g(list, null), 2, null);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    /* JADX WARN: Code restructure failed: missing block: B:34:0x009c, code lost:
    
        if (r11.a(r5, r0) == r1) goto L39;
     */
    /* JADX WARN: Code restructure failed: missing block: B:38:0x00ca, code lost:
    
        if (r9.a(r10, false, r0) == r1) goto L39;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object a(sdk.pendo.io.m7.c r10, kotlin.coroutines.Continuation<? super kotlin.Unit> r11) {
        /*
            Method dump skipped, instruction units count: 210
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: sdk.pendo.io.q7.b.a(sdk.pendo.io.m7.c, kotlin.coroutines.Continuation):java.lang.Object");
    }

    @Override // sdk.pendo.io.q7.a
    public Object a(n nVar, Continuation<? super Unit> continuation) {
        Object objWithContext = BuildersKt.withContext(this.singleThreadDispatcher, new i(nVar, this, null), continuation);
        return objWithContext == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objWithContext : Unit.INSTANCE;
    }
}
