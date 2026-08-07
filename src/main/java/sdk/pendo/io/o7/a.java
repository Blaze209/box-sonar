package sdk.pendo.io.o7;

import android.app.Activity;
import android.graphics.Insets;
import android.graphics.Rect;
import android.view.WindowInsets;
import android.view.WindowManager;
import android.view.WindowMetrics;
import androidx.exifinterface.media.ExifInterface;
import androidx.media3.exoplayer.upstream.CmcdData;
import external.sdk.pendo.io.mozilla.javascript.Token;
import io.split.android.client.service.ServiceConstants;
import java.util.concurrent.CancellationException;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.AbstractCoroutineContextElement;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.Reflection;
import kotlinx.coroutines.CompletableJob;
import kotlinx.coroutines.CoroutineExceptionHandler;
import kotlinx.coroutines.CoroutineName;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.JobKt__JobKt;
import kotlinx.coroutines.SupervisorKt;
import kotlinx.coroutines.sync.Mutex;
import kotlinx.coroutines.sync.MutexKt;
import sdk.pendo.io.h7.m;
import sdk.pendo.io.h7.p;
import sdk.pendo.io.h7.s;
import sdk.pendo.io.h7.t;
import sdk.pendo.io.logging.PendoLogger;
import sdk.pendo.io.models.SessionData;
import sdk.pendo.io.s7.p0;
import sdk.pendo.io.s7.x;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u0080\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0010\b \u0018\u0000 P2\u00020\u00012\u00020\u0002:\u0001\nB#\b\u0007\u0012\u0006\u0010\u0012\u001a\u00020\u0010\u0012\u0006\u0010\u0013\u001a\u00020\u0010\u0012\b\b\u0002\u0010\u0018\u001a\u00020\u0014¢\u0006\u0004\bN\u0010OJ+\u0010\n\u001a\u00020\t2\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0007H¦@ø\u0001\u0000¢\u0006\u0004\b\n\u0010\u000bJ\b\u0010\f\u001a\u00020\tH\u0014J\u0010\u0010\n\u001a\u00020\r2\u0006\u0010\u0004\u001a\u00020\u0003H\u0005J\u0018\u0010\n\u001a\u00020\t2\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0005H\u0016J\n\u0010\u000f\u001a\u0004\u0018\u00010\u000eH\u0016R\u0014\u0010\u0012\u001a\u00020\u00108\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\n\u0010\u0011R\u0014\u0010\u0013\u001a\u00020\u00108\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000f\u0010\u0011R\u001a\u0010\u0018\u001a\u00020\u00148\u0004X\u0084\u0004¢\u0006\f\n\u0004\b\f\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017R\u001b\u0010\u001e\u001a\u00020\u00198@X\u0080\u0084\u0002¢\u0006\f\n\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u001c\u0010\u001dR\u0014\u0010\"\u001a\u00020\u001f8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b \u0010!R\u0016\u0010%\u001a\u00020#8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0016\u0010$R\u001a\u0010*\u001a\u00020&8\u0004X\u0084\u0004¢\u0006\f\n\u0004\b'\u0010(\u001a\u0004\b \u0010)R\u001a\u00100\u001a\u00020+8\u0004X\u0084\u0004¢\u0006\f\n\u0004\b,\u0010-\u001a\u0004\b.\u0010/R$\u00106\u001a\u0004\u0018\u0001018\u0004@\u0004X\u0084\u000e¢\u0006\u0012\n\u0004\b2\u00103\u001a\u0004\b,\u00104\"\u0004\b\n\u00105R$\u0010;\u001a\u0004\u0018\u00010\u00078\u0004@\u0004X\u0084\u000e¢\u0006\u0012\n\u0004\b7\u00108\u001a\u0004\b\u001a\u00109\"\u0004\b\n\u0010:R$\u0010@\u001a\u0004\u0018\u00010<8\u0004@\u0004X\u0084\u000e¢\u0006\u0012\n\u0004\b\u001c\u0010=\u001a\u0004\b2\u0010>\"\u0004\b\n\u0010?R$\u0010E\u001a\u0004\u0018\u00010A8\u0000@\u0000X\u0080\u000e¢\u0006\u0012\n\u0004\b.\u0010B\u001a\u0004\b7\u0010C\"\u0004\b\n\u0010DR\"\u0010J\u001a\u00020\r8\u0004@\u0004X\u0084\u000e¢\u0006\u0012\n\u0004\bF\u0010G\u001a\u0004\b'\u0010H\"\u0004\b\n\u0010IR\u001b\u0010M\u001a\u00020\u00108DX\u0084\u0084\u0002¢\u0006\f\n\u0004\bK\u0010\u001b\u001a\u0004\bF\u0010L\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006Q"}, d2 = {"Lsdk/pendo/io/o7/a;", "Lsdk/pendo/io/o7/g;", "Lsdk/pendo/io/n7/a;", "Landroid/app/Activity;", "activity", "Lsdk/pendo/io/models/SessionData;", "data", "Lsdk/pendo/io/h7/m;", "config", "", CmcdData.OBJECT_TYPE_AUDIO_ONLY, "(Landroid/app/Activity;Lsdk/pendo/io/models/SessionData;Lsdk/pendo/io/h7/m;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "c", "Lsdk/pendo/io/h7/p;", "Lsdk/pendo/io/h7/t;", "b", "", "Ljava/lang/String;", ServiceConstants.WORKER_PARAM_API_KEY, "baseUrl", "Lsdk/pendo/io/z6/b;", "Lsdk/pendo/io/z6/b;", "f", "()Lsdk/pendo/io/z6/b;", "dispatcherProvider", "Lsdk/pendo/io/q7/a;", "d", "Lkotlin/Lazy;", "k", "()Lsdk/pendo/io/q7/a;", "repository", "Lkotlinx/coroutines/CoroutineExceptionHandler;", "e", "Lkotlinx/coroutines/CoroutineExceptionHandler;", "srCoroutineExceptionHandler", "Lkotlinx/coroutines/CompletableJob;", "Lkotlinx/coroutines/CompletableJob;", "mainSRCoroutineJob", "Lkotlinx/coroutines/CoroutineScope;", "g", "Lkotlinx/coroutines/CoroutineScope;", "()Lkotlinx/coroutines/CoroutineScope;", "coroutineScope", "Lkotlinx/coroutines/sync/Mutex;", CmcdData.STREAMING_FORMAT_HLS, "Lkotlinx/coroutines/sync/Mutex;", CmcdData.STREAM_TYPE_LIVE, "()Lkotlinx/coroutines/sync/Mutex;", "srMutex", "Lkotlinx/coroutines/Job;", "i", "Lkotlinx/coroutines/Job;", "()Lkotlinx/coroutines/Job;", "(Lkotlinx/coroutines/Job;)V", "onEventCollectionJob", "j", "Lsdk/pendo/io/h7/m;", "()Lsdk/pendo/io/h7/m;", "(Lsdk/pendo/io/h7/m;)V", "configurations", "Lsdk/pendo/io/h7/s;", "Lsdk/pendo/io/h7/s;", "()Lsdk/pendo/io/h7/s;", "(Lsdk/pendo/io/h7/s;)V", "privacyConfig", "Lsdk/pendo/io/p7/c;", "Lsdk/pendo/io/p7/c;", "()Lsdk/pendo/io/p7/c;", "(Lsdk/pendo/io/p7/c;)V", "recordingsManager", CmcdData.OBJECT_TYPE_MANIFEST, "Lsdk/pendo/io/h7/p;", "()Lsdk/pendo/io/h7/p;", "(Lsdk/pendo/io/h7/p;)V", "displayData", "n", "()Ljava/lang/String;", "tabId", "<init>", "(Ljava/lang/String;Ljava/lang/String;Lsdk/pendo/io/z6/b;)V", "o", "pendoIO_release"}, k = 1, mv = {1, 9, 0})
public abstract class a implements g, sdk.pendo.io.n7.a {

    /* JADX INFO: renamed from: a, reason: from kotlin metadata */
    private final String apiKey;

    /* JADX INFO: renamed from: b, reason: from kotlin metadata */
    private final String baseUrl;

    /* JADX INFO: renamed from: c, reason: from kotlin metadata */
    private final sdk.pendo.io.z6.b dispatcherProvider;

    /* JADX INFO: renamed from: d, reason: from kotlin metadata */
    private final Lazy repository;

    /* JADX INFO: renamed from: e, reason: from kotlin metadata */
    private final CoroutineExceptionHandler srCoroutineExceptionHandler;

    /* JADX INFO: renamed from: f, reason: from kotlin metadata */
    private CompletableJob mainSRCoroutineJob;

    /* JADX INFO: renamed from: g, reason: from kotlin metadata */
    private final CoroutineScope coroutineScope;

    /* JADX INFO: renamed from: h, reason: from kotlin metadata */
    private final Mutex srMutex;

    /* JADX INFO: renamed from: i, reason: from kotlin metadata */
    private Job onEventCollectionJob;

    /* JADX INFO: renamed from: j, reason: from kotlin metadata */
    private m configurations;

    /* JADX INFO: renamed from: k, reason: from kotlin metadata */
    private s privacyConfig;

    /* JADX INFO: renamed from: l, reason: from kotlin metadata */
    private sdk.pendo.io.p7.c recordingsManager;

    /* JADX INFO: renamed from: m, reason: from kotlin metadata */
    private p displayData;

    /* JADX INFO: renamed from: n, reason: from kotlin metadata */
    private final Lazy tabId;

    @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 9, 0})
    @DebugMetadata(c = "sdk.pendo.io.sessionreplay.managers.SRBaseManager$onStartSession$1", f = "SRBaseManager.kt", i = {}, l = {124, Token.TARGET}, m = "invokeSuspend", n = {}, s = {})
    static final class b extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        Object a;
        int b;
        final /* synthetic */ Activity d;
        final /* synthetic */ SessionData e;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        b(Activity activity, SessionData sessionData, Continuation<? super b> continuation) {
            super(2, continuation);
            this.d = activity;
            this.e = sessionData;
        }

        @Override // kotlin.jvm.functions.Function2
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((b) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return a.this.new b(this.d, this.e, continuation);
        }

        /* JADX WARN: Code restructure failed: missing block: B:22:0x00a9, code lost:
        
            if (r1.a(r3, r4, r9, r8) == r0) goto L23;
         */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final java.lang.Object invokeSuspend(java.lang.Object r9) {
            /*
                r8 = this;
                java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
                int r1 = r8.b
                r2 = 2
                r3 = 1
                if (r1 == 0) goto L23
                if (r1 == r3) goto L1b
                if (r1 != r2) goto L13
                kotlin.ResultKt.throwOnFailure(r9)
                goto Lac
            L13:
                java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
                java.lang.String r9 = "call to 'resume' before 'invoke' with coroutine"
                r8.<init>(r9)
                throw r8
            L1b:
                java.lang.Object r1 = r8.a
                sdk.pendo.io.o7.a r1 = (sdk.pendo.io.o7.a) r1
                kotlin.ResultKt.throwOnFailure(r9)
                goto L77
            L23:
                kotlin.ResultKt.throwOnFailure(r9)
                sdk.pendo.io.o7.a r9 = sdk.pendo.io.o7.a.this
                sdk.pendo.io.p7.c r9 = r9.getRecordingsManager()
                java.lang.String r1 = "SRBaseManager"
                if (r9 == 0) goto L3c
                java.lang.String r8 = "onStartSession -> we already have a running session"
                java.lang.Object[] r8 = new java.lang.Object[]{r8}
                sdk.pendo.io.logging.PendoLogger.i(r1, r8)
                kotlin.Unit r8 = kotlin.Unit.INSTANCE
                return r8
            L3c:
                android.app.Activity r9 = r8.d
                sdk.pendo.io.models.SessionData r4 = r8.e
                java.lang.String r4 = r4.getVisitorId()
                java.lang.StringBuilder r5 = new java.lang.StringBuilder
                java.lang.String r6 = "onStartSession -> "
                r5.<init>(r6)
                java.lang.StringBuilder r9 = r5.append(r9)
                java.lang.String r5 = " visitor:"
                java.lang.StringBuilder r9 = r9.append(r5)
                java.lang.StringBuilder r9 = r9.append(r4)
                java.lang.String r9 = r9.toString()
                java.lang.Object[] r9 = new java.lang.Object[]{r9}
                sdk.pendo.io.logging.PendoLogger.i(r1, r9)
                sdk.pendo.io.o7.a r1 = sdk.pendo.io.o7.a.this
                sdk.pendo.io.q7.a r9 = r1.k()
                sdk.pendo.io.models.SessionData r4 = r8.e
                r8.a = r1
                r8.b = r3
                java.lang.Object r9 = r9.a(r4, r8)
                if (r9 != r0) goto L77
                goto Lab
            L77:
                sdk.pendo.io.h7.m r9 = (sdk.pendo.io.h7.m) r9
                r1.a(r9)
                sdk.pendo.io.o7.a r9 = sdk.pendo.io.o7.a.this
                sdk.pendo.io.h7.m r9 = r9.getConfigurations()
                if (r9 == 0) goto Lac
                sdk.pendo.io.o7.a r1 = sdk.pendo.io.o7.a.this
                android.app.Activity r3 = r8.d
                sdk.pendo.io.models.SessionData r4 = r8.e
                boolean r5 = r9.getEnable()
                if (r5 == 0) goto Lac
                sdk.pendo.io.h7.s r5 = new sdk.pendo.io.h7.s
                sdk.pendo.io.h7.l r6 = r9.getPrivacyMode()
                java.util.List r7 = r9.a()
                r5.<init>(r6, r7)
                r1.a(r5)
                r5 = 0
                r8.a = r5
                r8.b = r2
                java.lang.Object r8 = r1.a(r3, r4, r9, r8)
                if (r8 != r0) goto Lac
            Lab:
                return r0
            Lac:
                kotlin.Unit r8 = kotlin.Unit.INSTANCE
                return r8
            */
            throw new UnsupportedOperationException("Method not decompiled: sdk.pendo.io.o7.a.b.invokeSuspend(java.lang.Object):java.lang.Object");
        }
    }

    @Metadata(d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"Lsdk/pendo/io/c3/a;", CmcdData.OBJECT_TYPE_AUDIO_ONLY, "()Lsdk/pendo/io/c3/a;"}, k = 3, mv = {1, 9, 0})
    static final class c extends Lambda implements Function0<sdk.pendo.io.c3.a> {
        c() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final sdk.pendo.io.c3.a invoke() {
            return sdk.pendo.io.c3.b.a(a.this.baseUrl, a.this.apiKey);
        }
    }

    @Metadata(d1 = {"\u0000!\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0003\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u00012\u00020\u0002J\u0018\u0010\b\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0005H\u0016¨\u0006\t¸\u0006\u0000"}, d2 = {"kotlinx/coroutines/CoroutineExceptionHandlerKt$CoroutineExceptionHandler$1", "Lkotlin/coroutines/AbstractCoroutineContextElement;", "Lkotlinx/coroutines/CoroutineExceptionHandler;", "Lkotlin/coroutines/CoroutineContext;", "context", "", "exception", "", "handleException", "kotlinx-coroutines-core"}, k = 1, mv = {1, 9, 0})
    public static final class d extends AbstractCoroutineContextElement implements CoroutineExceptionHandler {
        public d(CoroutineExceptionHandler.Companion companion) {
            super(companion);
        }

        @Override // kotlinx.coroutines.CoroutineExceptionHandler
        public void handleException(CoroutineContext context, Throwable exception) {
            String name;
            CoroutineName coroutineName = (CoroutineName) context.get(CoroutineName.INSTANCE);
            if (coroutineName == null || (name = coroutineName.getName()) == null) {
                name = "Unknown";
            }
            PendoLogger.e("SRBaseManager", "Uncaught exception in " + name, exception);
        }
    }

    @Metadata(d1 = {"\u0000\b\n\u0002\u0010\u0000\n\u0002\b\u0004\u0010\u0004\u001a\u00028\u0000\"\n\b\u0000\u0010\u0001\u0018\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"", ExifInterface.GPS_DIRECTION_TRUE, "invoke", "()Ljava/lang/Object;", "<anonymous>"}, k = 3, mv = {1, 9, 0})
    public static final class e extends Lambda implements Function0<sdk.pendo.io.q7.a> {
        final /* synthetic */ sdk.pendo.io.v2.a a;
        final /* synthetic */ sdk.pendo.io.d3.a b;
        final /* synthetic */ Function0 c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public e(sdk.pendo.io.v2.a aVar, sdk.pendo.io.d3.a aVar2, Function0 function0) {
            super(0);
            this.a = aVar;
            this.b = aVar2;
            this.c = function0;
        }

        /* JADX WARN: Type inference failed for: r3v2, types: [java.lang.Object, sdk.pendo.io.q7.a] */
        @Override // kotlin.jvm.functions.Function0
        public final sdk.pendo.io.q7.a invoke() {
            sdk.pendo.io.v2.a aVar = this.a;
            return (aVar instanceof sdk.pendo.io.v2.b ? ((sdk.pendo.io.v2.b) aVar).getScope() : aVar.getKoin().getScopeRegistry().getRootScope()).b(Reflection.getOrCreateKotlinClass(sdk.pendo.io.q7.a.class), this.b, this.c);
        }
    }

    @Metadata(d1 = {"\u0000\b\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", CmcdData.OBJECT_TYPE_AUDIO_ONLY, "()Ljava/lang/String;"}, k = 3, mv = {1, 9, 0})
    static final class f extends Lambda implements Function0<String> {
        public static final f a = new f();

        f() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final String invoke() {
            return p0.INSTANCE.a(16);
        }
    }

    public a(String apiKey, String baseUrl, sdk.pendo.io.z6.b dispatcherProvider) {
        Intrinsics.checkNotNullParameter(apiKey, "apiKey");
        Intrinsics.checkNotNullParameter(baseUrl, "baseUrl");
        Intrinsics.checkNotNullParameter(dispatcherProvider, "dispatcherProvider");
        this.apiKey = apiKey;
        this.baseUrl = baseUrl;
        this.dispatcherProvider = dispatcherProvider;
        this.repository = LazyKt.lazy(sdk.pendo.io.i3.b.a.a(), (Function0) new e(this, null, new c()));
        d dVar = new d(CoroutineExceptionHandler.INSTANCE);
        this.srCoroutineExceptionHandler = dVar;
        CompletableJob completableJobSupervisorJob$default = SupervisorKt.SupervisorJob$default((Job) null, 1, (Object) null);
        this.mainSRCoroutineJob = completableJobSupervisorJob$default;
        this.coroutineScope = CoroutineScopeKt.CoroutineScope(completableJobSupervisorJob$default.plus(dispatcherProvider.c()).plus(dVar).plus(new CoroutineName("SRManagerMainCoroutine")));
        this.srMutex = MutexKt.Mutex$default(false, 1, null);
        this.displayData = new p(1268, 2628, 0, 0, 0, 0);
        this.tabId = LazyKt.lazy(f.a);
    }

    public abstract Object a(Activity activity, SessionData sessionData, m mVar, Continuation<? super Unit> continuation);

    protected void c() {
        JobKt__JobKt.cancelChildren$default((Job) this.mainSRCoroutineJob, (CancellationException) null, 1, (Object) null);
        this.onEventCollectionJob = null;
    }

    /* JADX INFO: renamed from: d, reason: from getter */
    protected final m getConfigurations() {
        return this.configurations;
    }

    /* JADX INFO: renamed from: e, reason: from getter */
    protected final CoroutineScope getCoroutineScope() {
        return this.coroutineScope;
    }

    /* JADX INFO: renamed from: f, reason: from getter */
    protected final sdk.pendo.io.z6.b getDispatcherProvider() {
        return this.dispatcherProvider;
    }

    /* JADX INFO: renamed from: g, reason: from getter */
    protected final p getDisplayData() {
        return this.displayData;
    }

    @Override // sdk.pendo.io.v2.a
    public sdk.pendo.io.u2.a getKoin() {
        return sdk.pendo.io.n7.a.C0430a.a(this);
    }

    /* JADX INFO: renamed from: h, reason: from getter */
    protected final Job getOnEventCollectionJob() {
        return this.onEventCollectionJob;
    }

    /* JADX INFO: renamed from: i, reason: from getter */
    protected final s getPrivacyConfig() {
        return this.privacyConfig;
    }

    /* JADX INFO: renamed from: j, reason: from getter */
    public final sdk.pendo.io.p7.c getRecordingsManager() {
        return this.recordingsManager;
    }

    public final sdk.pendo.io.q7.a k() {
        return (sdk.pendo.io.q7.a) this.repository.getValue();
    }

    /* JADX INFO: renamed from: l, reason: from getter */
    protected final Mutex getSrMutex() {
        return this.srMutex;
    }

    protected final String m() {
        return (String) this.tabId.getValue();
    }

    protected final p a(Activity activity) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        WindowMetrics currentWindowMetrics = ((WindowManager) activity.getSystemService(WindowManager.class)).getCurrentWindowMetrics();
        Intrinsics.checkNotNullExpressionValue(currentWindowMetrics, "getCurrentWindowMetrics(...)");
        Rect bounds = currentWindowMetrics.getBounds();
        Intrinsics.checkNotNullExpressionValue(bounds, "getBounds(...)");
        Insets insetsIgnoringVisibility = currentWindowMetrics.getWindowInsets().getInsetsIgnoringVisibility(WindowInsets.Type.systemBars());
        Intrinsics.checkNotNullExpressionValue(insetsIgnoringVisibility, "getInsetsIgnoringVisibility(...)");
        return new p(bounds.width(), bounds.height(), insetsIgnoringVisibility.left, insetsIgnoringVisibility.top, insetsIgnoringVisibility.right, insetsIgnoringVisibility.bottom);
    }

    @Override // sdk.pendo.io.o7.g
    public t b() {
        sdk.pendo.io.p7.c cVar = this.recordingsManager;
        if (cVar != null) {
            return cVar.getAnalyticsData();
        }
        return null;
    }

    @Override // sdk.pendo.io.o7.g
    public void a(Activity activity, SessionData data) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(data, "data");
        x.a(this.coroutineScope, this.srMutex, this.dispatcherProvider.b(), null, new b(activity, data, null), 4, null);
    }

    protected final void a(m mVar) {
        this.configurations = mVar;
    }

    protected final void a(p pVar) {
        Intrinsics.checkNotNullParameter(pVar, "<set-?>");
        this.displayData = pVar;
    }

    protected final void a(Job job) {
        this.onEventCollectionJob = job;
    }

    protected final void a(s sVar) {
        this.privacyConfig = sVar;
    }

    public final void a(sdk.pendo.io.p7.c cVar) {
        this.recordingsManager = cVar;
    }
}
