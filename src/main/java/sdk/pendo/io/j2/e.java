package sdk.pendo.io.j2;

import androidx.core.app.NotificationCompat;
import androidx.exifinterface.media.ExifInterface;
import androidx.media3.exoplayer.upstream.CmcdData;
import com.microsoft.identity.common.nativeauth.internal.commands.ResetPasswordSubmitNewPasswordCommand;
import java.io.Closeable;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.lang.ref.Reference;
import java.lang.ref.WeakReference;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLSocketFactory;
import kotlin.ExceptionsKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import sdk.pendo.io.e2.b0;
import sdk.pendo.io.e2.d0;
import sdk.pendo.io.e2.p;
import sdk.pendo.io.e2.r;
import sdk.pendo.io.e2.v;
import sdk.pendo.io.e2.z;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u0095\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u001a*\u0001G\u0018\u00002\u00020\u0001:\u0002\u0003\u000fB\u001f\u0012\u0006\u00105\u001a\u000201\u0012\u0006\u00109\u001a\u00020\u0010\u0012\u0006\u0010=\u001a\u00020\u0013¢\u0006\u0004\bj\u0010kJ\b\u0010\u0003\u001a\u00020\u0002H\u0002J#\u0010\u0003\u001a\u00028\u0000\"\n\b\u0000\u0010\u0005*\u0004\u0018\u00010\u00042\u0006\u0010\u0006\u001a\u00028\u0000H\u0002¢\u0006\u0004\b\u0003\u0010\u0007J#\u0010\t\u001a\u00028\u0000\"\n\b\u0000\u0010\u0005*\u0004\u0018\u00010\u00042\u0006\u0010\b\u001a\u00028\u0000H\u0002¢\u0006\u0004\b\t\u0010\u0007J\u0010\u0010\u0003\u001a\u00020\f2\u0006\u0010\u000b\u001a\u00020\nH\u0002J\b\u0010\u000e\u001a\u00020\rH\u0002J\b\u0010\u000f\u001a\u00020\u0000H\u0016J\b\u0010\u0011\u001a\u00020\u0010H\u0016J\b\u0010\u0012\u001a\u00020\u0002H\u0016J\b\u0010\u0014\u001a\u00020\u0013H\u0016J\b\u0010\u0016\u001a\u00020\u0015H\u0016J\u0010\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0018\u001a\u00020\u0017H\u0016J\u000f\u0010\u0019\u001a\u00020\u0015H\u0000¢\u0006\u0004\b\u0019\u0010\u001aJ\u0016\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u001b\u001a\u00020\u0013J\u0017\u0010\u0003\u001a\u00020\u001e2\u0006\u0010\u001d\u001a\u00020\u001cH\u0000¢\u0006\u0004\b\u0003\u0010\u001fJ\u000e\u0010\u0003\u001a\u00020\u00022\u0006\u0010!\u001a\u00020 J\u001b\u0010\u000f\u001a\u0004\u0018\u00010\u00042\b\u0010\u0006\u001a\u0004\u0018\u00010\u0004H\u0000¢\u0006\u0004\b\u000f\u0010\u0007J\u0011\u0010#\u001a\u0004\u0018\u00010\"H\u0000¢\u0006\u0004\b#\u0010$J\u0006\u0010%\u001a\u00020\u0002J\u0017\u0010\u0003\u001a\u00020\u00022\u0006\u0010&\u001a\u00020\u0013H\u0000¢\u0006\u0004\b\u0003\u0010'J\u0006\u0010(\u001a\u00020\u0013J\u000f\u0010)\u001a\u00020\rH\u0000¢\u0006\u0004\b)\u0010*J;\u00100\u001a\u00028\u0000\"\n\b\u0000\u0010\u0005*\u0004\u0018\u00010\u00042\u0006\u0010+\u001a\u00020\u001e2\u0006\u0010,\u001a\u00020\u00132\u0006\u0010-\u001a\u00020\u00132\u0006\u0010\u0006\u001a\u00028\u0000H\u0000¢\u0006\u0004\b.\u0010/R\u0017\u00105\u001a\u0002018\u0006¢\u0006\f\n\u0004\b\u0003\u00102\u001a\u0004\b3\u00104R\u0017\u00109\u001a\u00020\u00108\u0006¢\u0006\f\n\u0004\b\u000f\u00106\u001a\u0004\b7\u00108R\u0017\u0010=\u001a\u00020\u00138\u0006¢\u0006\f\n\u0004\b\t\u0010:\u001a\u0004\b;\u0010<R\u0014\u0010A\u001a\u00020>8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b?\u0010@R\u001a\u0010F\u001a\u00020B8\u0000X\u0080\u0004¢\u0006\f\n\u0004\b\u0006\u0010C\u001a\u0004\bD\u0010ER\u0014\u0010I\u001a\u00020G8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b;\u0010HR\u0014\u0010M\u001a\u00020J8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bK\u0010LR\u0018\u0010Q\u001a\u0004\u0018\u00010N8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bO\u0010PR\u0018\u0010T\u001a\u0004\u0018\u00010R8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0019\u0010SR(\u0010!\u001a\u0004\u0018\u00010 2\b\u0010U\u001a\u0004\u0018\u00010 8\u0006@BX\u0086\u000e¢\u0006\f\n\u0004\b)\u0010V\u001a\u0004\bW\u0010XR\u0016\u0010Y\u001a\u00020\u00138\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b#\u0010:R(\u0010]\u001a\u0004\u0018\u00010\u001e2\b\u0010U\u001a\u0004\u0018\u00010\u001e8\u0000@BX\u0080\u000e¢\u0006\f\n\u0004\b(\u0010Z\u001a\u0004\b[\u0010\\R\u0016\u0010^\u001a\u00020\u00138\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b%\u0010:R\u0016\u0010_\u001a\u00020\u00138\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u000e\u0010:R\u0016\u0010a\u001a\u00020\u00138\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b`\u0010:R\u0016\u0010c\u001a\u00020\u00138\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bb\u0010:R\u0018\u0010+\u001a\u0004\u0018\u00010\u001e8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bd\u0010ZR$\u0010i\u001a\u0004\u0018\u00010 8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\be\u0010V\u001a\u0004\bf\u0010X\"\u0004\bg\u0010h¨\u0006l"}, d2 = {"Lsdk/pendo/io/j2/e;", "Lsdk/pendo/io/e2/e;", "", CmcdData.OBJECT_TYPE_AUDIO_ONLY, "Ljava/io/IOException;", ExifInterface.LONGITUDE_EAST, "e", "(Ljava/io/IOException;)Ljava/io/IOException;", "cause", "c", "Lsdk/pendo/io/e2/v;", "url", "Lsdk/pendo/io/e2/a;", "", "n", "b", "Lsdk/pendo/io/e2/b0;", "request", "cancel", "", "isCanceled", "Lsdk/pendo/io/e2/d0;", "execute", "Lsdk/pendo/io/e2/f;", "responseCallback", "i", "()Lsdk/pendo/io/e2/d0;", "newExchangeFinder", "Lsdk/pendo/io/k2/g;", "chain", "Lsdk/pendo/io/j2/c;", "(Lsdk/pendo/io/k2/g;)Lsdk/pendo/io/j2/c;", "Lsdk/pendo/io/j2/f;", "connection", "Ljava/net/Socket;", "k", "()Ljava/net/Socket;", CmcdData.OBJECT_TYPE_MANIFEST, "closeExchange", "(Z)V", CmcdData.STREAM_TYPE_LIVE, "j", "()Ljava/lang/String;", "exchange", "requestDone", "responseDone", "messageDone$okhttp", "(Lokhttp3/internal/connection/Exchange;ZZLjava/io/IOException;)Ljava/io/IOException;", "messageDone", "Lsdk/pendo/io/e2/z;", "Lsdk/pendo/io/e2/z;", "getClient", "()Lokhttp3/OkHttpClient;", "client", "Lsdk/pendo/io/e2/b0;", "getOriginalRequest", "()Lokhttp3/Request;", "originalRequest", "Z", "f", "()Z", "forWebSocket", "Lsdk/pendo/io/j2/g;", "d", "Lsdk/pendo/io/j2/g;", "connectionPool", "Lsdk/pendo/io/e2/r;", "Lsdk/pendo/io/e2/r;", "getEventListener$okhttp", "()Lokhttp3/EventListener;", "eventListener", "sdk/pendo/io/j2/e$c", "Lsdk/pendo/io/j2/e$c;", ResetPasswordSubmitNewPasswordCommand.POLL_COMPLETION_TIMEOUT_ERROR_CODE, "Ljava/util/concurrent/atomic/AtomicBoolean;", "g", "Ljava/util/concurrent/atomic/AtomicBoolean;", "executed", "", CmcdData.STREAMING_FORMAT_HLS, "Ljava/lang/Object;", "callStackTrace", "Lsdk/pendo/io/j2/d;", "Lsdk/pendo/io/j2/d;", "exchangeFinder", "<set-?>", "Lsdk/pendo/io/j2/f;", "getConnection", "()Lokhttp3/internal/connection/RealConnection;", "timeoutEarlyExit", "Lsdk/pendo/io/j2/c;", "getInterceptorScopedExchange$okhttp", "()Lokhttp3/internal/connection/Exchange;", "interceptorScopedExchange", "requestBodyOpen", "responseBodyOpen", "o", "expectMoreExchanges", "p", "canceled", "q", "r", "getConnectionToCancel", "setConnectionToCancel", "(Lokhttp3/internal/connection/RealConnection;)V", "connectionToCancel", "<init>", "(Lokhttp3/OkHttpClient;Lokhttp3/Request;Z)V", "okhttp"}, k = 1, mv = {1, 8, 0})
public final class e implements sdk.pendo.io.e2.e {

    /* JADX INFO: renamed from: a, reason: from kotlin metadata */
    private final z client;

    /* JADX INFO: renamed from: b, reason: from kotlin metadata */
    private final b0 originalRequest;

    /* JADX INFO: renamed from: c, reason: from kotlin metadata */
    private final boolean forWebSocket;

    /* JADX INFO: renamed from: d, reason: from kotlin metadata */
    private final g connectionPool;

    /* JADX INFO: renamed from: e, reason: from kotlin metadata */
    private final r eventListener;

    /* JADX INFO: renamed from: f, reason: from kotlin metadata */
    private final c timeout;

    /* JADX INFO: renamed from: g, reason: from kotlin metadata */
    private final AtomicBoolean executed;

    /* JADX INFO: renamed from: h, reason: from kotlin metadata */
    private Object callStackTrace;

    /* JADX INFO: renamed from: i, reason: from kotlin metadata */
    private d exchangeFinder;

    /* JADX INFO: renamed from: j, reason: from kotlin metadata */
    private f connection;

    /* JADX INFO: renamed from: k, reason: from kotlin metadata */
    private boolean timeoutEarlyExit;

    /* JADX INFO: renamed from: l, reason: from kotlin metadata */
    private sdk.pendo.io.j2.c interceptorScopedExchange;

    /* JADX INFO: renamed from: m, reason: from kotlin metadata */
    private boolean requestBodyOpen;

    /* JADX INFO: renamed from: n, reason: from kotlin metadata */
    private boolean responseBodyOpen;

    /* JADX INFO: renamed from: o, reason: from kotlin metadata */
    private boolean expectMoreExchanges;

    /* JADX INFO: renamed from: p, reason: from kotlin metadata */
    private volatile boolean canceled;

    /* JADX INFO: renamed from: q, reason: from kotlin metadata */
    private volatile sdk.pendo.io.j2.c exchange;

    /* JADX INFO: renamed from: r, reason: from kotlin metadata */
    private volatile f connectionToCancel;

    @Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0080\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u000b\u001a\u00020\t¢\u0006\u0004\b\u001d\u0010\u001eJ\u0012\u0010\u0005\u001a\u00020\u00042\n\u0010\u0003\u001a\u00060\u0000R\u00020\u0002J\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006J\b\u0010\b\u001a\u00020\u0004H\u0016R\u0014\u0010\u000b\u001a\u00020\t8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0005\u0010\nR$\u0010\u0011\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\f8\u0006@BX\u0086\u000e¢\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u000e\u0010\u0010R\u0011\u0010\u0015\u001a\u00020\u00128F¢\u0006\u0006\u001a\u0004\b\u0013\u0010\u0014R\u0011\u0010\u0018\u001a\u00020\u00028F¢\u0006\u0006\u001a\u0004\b\u0016\u0010\u0017R\u0011\u0010\u001c\u001a\u00020\u00198F¢\u0006\u0006\u001a\u0004\b\u001a\u0010\u001b¨\u0006\u001f"}, d2 = {"Lsdk/pendo/io/j2/e$a;", "Ljava/lang/Runnable;", "Lsdk/pendo/io/j2/e;", "other", "", CmcdData.OBJECT_TYPE_AUDIO_ONLY, "Ljava/util/concurrent/ExecutorService;", "executorService", "run", "Lsdk/pendo/io/e2/f;", "Lsdk/pendo/io/e2/f;", "responseCallback", "Ljava/util/concurrent/atomic/AtomicInteger;", "<set-?>", "b", "Ljava/util/concurrent/atomic/AtomicInteger;", "()Ljava/util/concurrent/atomic/AtomicInteger;", "callsPerHost", "", "c", "()Ljava/lang/String;", "host", "getCall", "()Lokhttp3/internal/connection/RealCall;", NotificationCompat.CATEGORY_CALL, "Lsdk/pendo/io/e2/b0;", "getRequest", "()Lokhttp3/Request;", "request", "<init>", "(Lokhttp3/internal/connection/RealCall;Lokhttp3/Callback;)V", "okhttp"}, k = 1, mv = {1, 8, 0})
    public final class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: from kotlin metadata */
        private final sdk.pendo.io.e2.f responseCallback;

        /* JADX INFO: renamed from: b, reason: from kotlin metadata */
        private volatile AtomicInteger callsPerHost;
        final /* synthetic */ e c;

        public a(e eVar, sdk.pendo.io.e2.f responseCallback) {
            Intrinsics.checkNotNullParameter(responseCallback, "responseCallback");
            this.c = eVar;
            this.responseCallback = responseCallback;
            this.callsPerHost = new AtomicInteger(0);
        }

        public final void a(ExecutorService executorService) {
            Intrinsics.checkNotNullParameter(executorService, "executorService");
            p dispatcher = this.c.getClient().getDispatcher();
            if (sdk.pendo.io.f2.b.h && Thread.holdsLock(dispatcher)) {
                throw new AssertionError("Thread " + Thread.currentThread().getName() + " MUST NOT hold lock on " + dispatcher);
            }
            try {
                try {
                    executorService.execute(this);
                } catch (RejectedExecutionException e) {
                    InterruptedIOException interruptedIOException = new InterruptedIOException("executor rejected");
                    interruptedIOException.initCause(e);
                    this.c.b(interruptedIOException);
                    this.responseCallback.a(this.c, interruptedIOException);
                    this.c.getClient().getDispatcher().b(this);
                }
            } catch (Throwable th) {
                this.c.getClient().getDispatcher().b(this);
                throw th;
            }
        }

        /* JADX INFO: renamed from: b, reason: from getter */
        public final AtomicInteger getCallsPerHost() {
            return this.callsPerHost;
        }

        public final String c() {
            return this.c.getOriginalRequest().i().getHost();
        }

        @Override // java.lang.Runnable
        public void run() {
            z client;
            String str = "OkHttp " + this.c.j();
            e eVar = this.c;
            Thread threadCurrentThread = Thread.currentThread();
            String name = threadCurrentThread.getName();
            threadCurrentThread.setName(str);
            try {
                eVar.timeout.l();
                boolean z = false;
                try {
                    try {
                        try {
                            this.responseCallback.a(eVar, eVar.i());
                            client = eVar.getClient();
                        } catch (IOException e) {
                            e = e;
                            z = true;
                            if (z) {
                                sdk.pendo.io.n2.h.INSTANCE.d().a("Callback failure for " + eVar.n(), 4, e);
                            } else {
                                this.responseCallback.a(eVar, e);
                            }
                            client = eVar.getClient();
                        } catch (Throwable th) {
                            th = th;
                            z = true;
                            eVar.cancel();
                            if (!z) {
                                IOException iOException = new IOException("canceled due to " + th);
                                ExceptionsKt.addSuppressed(iOException, th);
                                this.responseCallback.a(eVar, iOException);
                            }
                            throw th;
                        }
                    } catch (Throwable th2) {
                        eVar.getClient().getDispatcher().b(this);
                        throw th2;
                    }
                } catch (IOException e2) {
                    e = e2;
                } catch (Throwable th3) {
                    th = th3;
                }
                client.getDispatcher().b(this);
                threadCurrentThread.setName(name);
            } catch (Throwable th4) {
                threadCurrentThread.setName(name);
                throw th4;
            }
        }

        /* JADX INFO: renamed from: a, reason: from getter */
        public final e getC() {
            return this.c;
        }

        public final void a(a other) {
            Intrinsics.checkNotNullParameter(other, "other");
            this.callsPerHost = other.callsPerHost;
        }
    }

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\b\b\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0019\u0012\u0006\u0010\b\u001a\u00020\u0002\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\t\u0010\nR\u0019\u0010\u0007\u001a\u0004\u0018\u00010\u00038\u0006¢\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0004\u0010\u0006¨\u0006\u000b"}, d2 = {"Lsdk/pendo/io/j2/e$b;", "Ljava/lang/ref/WeakReference;", "Lsdk/pendo/io/j2/e;", "", CmcdData.OBJECT_TYPE_AUDIO_ONLY, "Ljava/lang/Object;", "()Ljava/lang/Object;", "callStackTrace", "referent", "<init>", "(Lokhttp3/internal/connection/RealCall;Ljava/lang/Object;)V", "okhttp"}, k = 1, mv = {1, 8, 0})
    public static final class b extends WeakReference<e> {

        /* JADX INFO: renamed from: a, reason: from kotlin metadata */
        private final Object callStackTrace;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(e referent, Object obj) {
            super(referent);
            Intrinsics.checkNotNullParameter(referent, "referent");
            this.callStackTrace = obj;
        }

        /* JADX INFO: renamed from: a, reason: from getter */
        public final Object getCallStackTrace() {
            return this.callStackTrace;
        }
    }

    @Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0014¨\u0006\u0004"}, d2 = {"sdk/pendo/io/j2/e$c", "Lsdk/pendo/io/s2/c;", "", "n", "okhttp"}, k = 1, mv = {1, 8, 0})
    public static final class c extends sdk.pendo.io.s2.c {
        c() {
        }

        @Override // sdk.pendo.io.s2.c
        protected void n() {
            e.this.cancel();
        }
    }

    public e(z client, b0 originalRequest, boolean z) {
        Intrinsics.checkNotNullParameter(client, "client");
        Intrinsics.checkNotNullParameter(originalRequest, "originalRequest");
        this.client = client;
        this.originalRequest = originalRequest;
        this.forWebSocket = z;
        this.connectionPool = client.getConnectionPool().getDelegate();
        this.eventListener = client.getEventListenerFactory().a(this);
        c cVar = new c();
        cVar.a(client.getCallTimeoutMillis(), TimeUnit.MILLISECONDS);
        this.timeout = cVar;
        this.executed = new AtomicBoolean();
        this.expectMoreExchanges = true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final String n() {
        return (getCanceled() ? "canceled " : "") + (this.forWebSocket ? "web socket" : NotificationCompat.CATEGORY_CALL) + " to " + j();
    }

    /* JADX INFO: renamed from: c, reason: from getter */
    public final z getClient() {
        return this.client;
    }

    @Override // sdk.pendo.io.e2.e
    public void cancel() {
        if (this.canceled) {
            return;
        }
        this.canceled = true;
        sdk.pendo.io.j2.c cVar = this.exchange;
        if (cVar != null) {
            cVar.a();
        }
        f fVar = this.connectionToCancel;
        if (fVar != null) {
            fVar.a();
        }
        this.eventListener.c(this);
    }

    /* JADX INFO: renamed from: d, reason: from getter */
    public final f getConnection() {
        return this.connection;
    }

    /* JADX INFO: renamed from: e, reason: from getter */
    public final r getEventListener() {
        return this.eventListener;
    }

    @Override // sdk.pendo.io.e2.e
    public d0 execute() {
        if (!this.executed.compareAndSet(false, true)) {
            throw new IllegalStateException("Already Executed".toString());
        }
        this.timeout.l();
        a();
        try {
            this.client.getDispatcher().a(this);
            return i();
        } finally {
            this.client.getDispatcher().b(this);
        }
    }

    /* JADX INFO: renamed from: f, reason: from getter */
    public final boolean getForWebSocket() {
        return this.forWebSocket;
    }

    /* JADX INFO: renamed from: g, reason: from getter */
    public final sdk.pendo.io.j2.c getInterceptorScopedExchange() {
        return this.interceptorScopedExchange;
    }

    /* JADX INFO: renamed from: h, reason: from getter */
    public final b0 getOriginalRequest() {
        return this.originalRequest;
    }

    /* JADX WARN: Code duplicated, block: B:21:0x009b  */
    public final d0 i() throws Throwable {
        ArrayList arrayList = new ArrayList();
        CollectionsKt.addAll(arrayList, this.client.s());
        arrayList.add(new sdk.pendo.io.k2.j(this.client));
        arrayList.add(new sdk.pendo.io.k2.a(this.client.getCookieJar()));
        this.client.d();
        arrayList.add(new sdk.pendo.io.h2.a(null));
        arrayList.add(sdk.pendo.io.j2.a.a);
        if (!this.forWebSocket) {
            CollectionsKt.addAll(arrayList, this.client.u());
        }
        arrayList.add(new sdk.pendo.io.k2.b(this.forWebSocket));
        sdk.pendo.io.k2.g gVar = new sdk.pendo.io.k2.g(this, arrayList, 0, null, this.originalRequest, this.client.getConnectTimeoutMillis(), this.client.getReadTimeoutMillis(), this.client.getWriteTimeoutMillis());
        boolean z = false;
        try {
            d0 d0VarA = gVar.a(this.originalRequest);
            if (getCanceled()) {
                sdk.pendo.io.f2.b.a((Closeable) d0VarA);
                throw new IOException("Canceled");
            }
            b((IOException) null);
            return d0VarA;
        } catch (IOException e) {
            try {
                IOException iOExceptionB = b(e);
                Intrinsics.checkNotNull(iOExceptionB, "null cannot be cast to non-null type kotlin.Throwable");
                throw iOExceptionB;
            } catch (Throwable th) {
                th = th;
                z = true;
                if (!z) {
                    b((IOException) null);
                }
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
            if (!z) {
                b((IOException) null);
            }
            throw th;
        }
    }

    @Override // sdk.pendo.io.e2.e
    /* JADX INFO: renamed from: isCanceled, reason: from getter */
    public boolean getCanceled() {
        return this.canceled;
    }

    public final String j() {
        return this.originalRequest.i().n();
    }

    public final Socket k() {
        f fVar = this.connection;
        Intrinsics.checkNotNull(fVar);
        if (sdk.pendo.io.f2.b.h && !Thread.holdsLock(fVar)) {
            throw new AssertionError("Thread " + Thread.currentThread().getName() + " MUST hold lock on " + fVar);
        }
        List<Reference<e>> listC = fVar.c();
        Iterator<Reference<e>> it = listC.iterator();
        int i = 0;
        while (true) {
            if (!it.hasNext()) {
                i = -1;
                break;
            }
            if (Intrinsics.areEqual(it.next().get(), this)) {
                break;
            }
            i++;
        }
        if (i == -1) {
            throw new IllegalStateException("Check failed.".toString());
        }
        listC.remove(i);
        this.connection = null;
        if (listC.isEmpty()) {
            fVar.a(System.nanoTime());
            if (this.connectionPool.a(fVar)) {
                return fVar.m();
            }
        }
        return null;
    }

    public final boolean l() {
        d dVar = this.exchangeFinder;
        Intrinsics.checkNotNull(dVar);
        return dVar.b();
    }

    public final void m() {
        if (this.timeoutEarlyExit) {
            throw new IllegalStateException("Check failed.".toString());
        }
        this.timeoutEarlyExit = true;
        this.timeout.m();
    }

    @Override // sdk.pendo.io.e2.e
    public b0 request() {
        return this.originalRequest;
    }

    private final <E extends IOException> E c(E cause) {
        if (this.timeoutEarlyExit || !this.timeout.m()) {
            return cause;
        }
        InterruptedIOException interruptedIOException = new InterruptedIOException(ResetPasswordSubmitNewPasswordCommand.POLL_COMPLETION_TIMEOUT_ERROR_CODE);
        if (cause != null) {
            interruptedIOException.initCause(cause);
        }
        return interruptedIOException;
    }

    public final void a(f connection) {
        Intrinsics.checkNotNullParameter(connection, "connection");
        if (sdk.pendo.io.f2.b.h && !Thread.holdsLock(connection)) {
            throw new AssertionError("Thread " + Thread.currentThread().getName() + " MUST hold lock on " + connection);
        }
        if (this.connection != null) {
            throw new IllegalStateException("Check failed.".toString());
        }
        this.connection = connection;
        connection.c().add(new b(this, this.callStackTrace));
    }

    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public e clone() {
        return new e(this.client, this.originalRequest, this.forWebSocket);
    }

    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    private final <E extends IOException> E a(E e) {
        Socket socketK;
        boolean z = sdk.pendo.io.f2.b.h;
        if (z && Thread.holdsLock(this)) {
            throw new AssertionError("Thread " + Thread.currentThread().getName() + " MUST NOT hold lock on " + this);
        }
        f fVar = this.connection;
        if (fVar != null) {
            if (z && Thread.holdsLock(fVar)) {
                throw new AssertionError("Thread " + Thread.currentThread().getName() + " MUST NOT hold lock on " + fVar);
            }
            synchronized (fVar) {
                socketK = k();
            }
            if (this.connection == null) {
                if (socketK != null) {
                    sdk.pendo.io.f2.b.a(socketK);
                }
                this.eventListener.b(this, fVar);
            } else if (socketK != null) {
                throw new IllegalStateException("Check failed.".toString());
            }
        }
        E e2 = (E) c(e);
        if (e == null) {
            this.eventListener.a(this);
            return e2;
        }
        r rVar = this.eventListener;
        Intrinsics.checkNotNull(e2);
        rVar.a(this, e2);
        return e2;
    }

    public final IOException b(IOException e) {
        boolean z;
        synchronized (this) {
            z = false;
            if (this.expectMoreExchanges) {
                this.expectMoreExchanges = false;
                if (!this.requestBodyOpen && !this.responseBodyOpen) {
                    z = true;
                }
            }
            Unit unit = Unit.INSTANCE;
        }
        return z ? a(e) : e;
    }

    private final void a() {
        this.callStackTrace = sdk.pendo.io.n2.h.INSTANCE.d().a("response.body().close()");
        this.eventListener.b(this);
    }

    public final void b(f fVar) {
        this.connectionToCancel = fVar;
    }

    private final sdk.pendo.io.e2.a a(v url) {
        SSLSocketFactory sSLSocketFactoryE;
        HostnameVerifier hostnameVerifier;
        sdk.pendo.io.e2.g certificatePinner;
        if (url.getIsHttps()) {
            sSLSocketFactoryE = this.client.E();
            hostnameVerifier = this.client.getHostnameVerifier();
            certificatePinner = this.client.getCertificatePinner();
        } else {
            sSLSocketFactoryE = null;
            hostnameVerifier = null;
            certificatePinner = null;
        }
        return new sdk.pendo.io.e2.a(url.getHost(), url.getPort(), this.client.getDns(), this.client.getSocketFactory(), sSLSocketFactoryE, hostnameVerifier, certificatePinner, this.client.getProxyAuthenticator(), this.client.getProxy(), this.client.x(), this.client.j(), this.client.getProxySelector());
    }

    @Override // sdk.pendo.io.e2.e
    public void a(sdk.pendo.io.e2.f responseCallback) {
        Intrinsics.checkNotNullParameter(responseCallback, "responseCallback");
        if (!this.executed.compareAndSet(false, true)) {
            throw new IllegalStateException("Already Executed".toString());
        }
        a();
        this.client.getDispatcher().a(new a(this, responseCallback));
    }

    public final void a(b0 request, boolean newExchangeFinder) {
        Intrinsics.checkNotNullParameter(request, "request");
        if (this.interceptorScopedExchange != null) {
            throw new IllegalStateException("Check failed.".toString());
        }
        synchronized (this) {
            if (this.responseBodyOpen) {
                throw new IllegalStateException("cannot make a new request because the previous response is still open: please call response.close()".toString());
            }
            if (this.requestBodyOpen) {
                throw new IllegalStateException("Check failed.".toString());
            }
            Unit unit = Unit.INSTANCE;
        }
        if (newExchangeFinder) {
            this.exchangeFinder = new d(this.connectionPool, a(request.i()), this, this.eventListener);
        }
    }

    public final void a(boolean closeExchange) {
        sdk.pendo.io.j2.c cVar;
        synchronized (this) {
            if (!this.expectMoreExchanges) {
                throw new IllegalStateException("released".toString());
            }
            Unit unit = Unit.INSTANCE;
        }
        if (closeExchange && (cVar = this.exchange) != null) {
            cVar.b();
        }
        this.interceptorScopedExchange = null;
    }

    public final sdk.pendo.io.j2.c a(sdk.pendo.io.k2.g chain) throws IOException {
        Intrinsics.checkNotNullParameter(chain, "chain");
        synchronized (this) {
            if (!this.expectMoreExchanges) {
                throw new IllegalStateException("released".toString());
            }
            if (this.responseBodyOpen) {
                throw new IllegalStateException("Check failed.".toString());
            }
            if (this.requestBodyOpen) {
                throw new IllegalStateException("Check failed.".toString());
            }
            Unit unit = Unit.INSTANCE;
        }
        d dVar = this.exchangeFinder;
        Intrinsics.checkNotNull(dVar);
        sdk.pendo.io.j2.c cVar = new sdk.pendo.io.j2.c(this, this.eventListener, dVar, dVar.a(this.client, chain));
        this.interceptorScopedExchange = cVar;
        this.exchange = cVar;
        synchronized (this) {
            this.requestBodyOpen = true;
            this.responseBodyOpen = true;
            Unit unit2 = Unit.INSTANCE;
        }
        if (this.canceled) {
            throw new IOException("Canceled");
        }
        return cVar;
    }

    /* JADX WARN: Code duplicated, block: B:16:0x001f A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:17:0x0021 A[Catch: all -> 0x0017, TryCatch #0 {all -> 0x0017, blocks: (B:8:0x0012, B:17:0x0021, B:19:0x0025, B:20:0x0027, B:22:0x002c, B:27:0x0035, B:29:0x0039, B:34:0x0042, B:14:0x001b), top: B:46:0x0012 }] */
    /* JADX WARN: Code duplicated, block: B:19:0x0025 A[Catch: all -> 0x0017, TryCatch #0 {all -> 0x0017, blocks: (B:8:0x0012, B:17:0x0021, B:19:0x0025, B:20:0x0027, B:22:0x002c, B:27:0x0035, B:29:0x0039, B:34:0x0042, B:14:0x001b), top: B:46:0x0012 }] */
    /* JADX WARN: Code duplicated, block: B:25:0x0032  */
    public final <E extends IOException> E a(sdk.pendo.io.j2.c exchange, boolean z, boolean z2, E e) {
        boolean z3;
        boolean z4;
        boolean z5;
        boolean z6;
        Intrinsics.checkNotNullParameter(exchange, "exchange");
        if (Intrinsics.areEqual(exchange, this.exchange)) {
            synchronized (this) {
                z3 = false;
                if (z) {
                    try {
                        if (this.requestBodyOpen) {
                            if (z) {
                                this.requestBodyOpen = false;
                            }
                            if (z2) {
                                this.responseBodyOpen = false;
                            }
                            z5 = this.requestBodyOpen;
                            if (z5) {
                                z6 = false;
                            } else {
                                z6 = false;
                            }
                            if (!z5) {
                                z3 = true;
                            }
                            z4 = z3;
                            z3 = z6;
                        } else if (z2 || !this.responseBodyOpen) {
                            z4 = false;
                        } else {
                            if (z) {
                                this.requestBodyOpen = false;
                            }
                            if (z2) {
                                this.responseBodyOpen = false;
                            }
                            z5 = this.requestBodyOpen;
                            if (z5 || this.responseBodyOpen) {
                                z6 = false;
                            } else {
                                z6 = true;
                            }
                            if (!z5 && !this.responseBodyOpen && !this.expectMoreExchanges) {
                                z3 = true;
                            }
                            z4 = z3;
                            z3 = z6;
                        }
                        Unit unit = Unit.INSTANCE;
                    } catch (Throwable th) {
                        throw th;
                    }
                } else {
                    if (z2) {
                    }
                    z4 = false;
                    Unit unit2 = Unit.INSTANCE;
                }
            }
            if (z3) {
                this.exchange = null;
                f fVar = this.connection;
                if (fVar != null) {
                    fVar.h();
                }
            }
            if (z4) {
                return (E) a(e);
            }
        }
        return e;
    }
}
