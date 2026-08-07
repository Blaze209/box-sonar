package sdk.pendo.io.e2;

import androidx.core.app.NotificationCompat;
import androidx.exifinterface.media.ExifInterface;
import androidx.media3.exoplayer.upstream.CmcdData;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.Iterator;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\f\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b2\u00103J\u0016\u0010\u0006\u001a\b\u0018\u00010\u0004R\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\b\u001a\u00020\u0007H\u0002J+\u0010\u0006\u001a\u00020\r\"\u0004\b\u0000\u0010\t2\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00028\u00000\n2\u0006\u0010\f\u001a\u00028\u0000H\u0002¢\u0006\u0004\b\u0006\u0010\u000eJ\u001b\u0010\u0006\u001a\u00020\r2\n\u0010\f\u001a\u00060\u0004R\u00020\u0005H\u0000¢\u0006\u0004\b\u0006\u0010\u000fJ\u0017\u0010\u0006\u001a\u00020\r2\u0006\u0010\f\u001a\u00020\u0005H\u0000¢\u0006\u0004\b\u0006\u0010\u0010J\u001b\u0010\b\u001a\u00020\r2\n\u0010\f\u001a\u00060\u0004R\u00020\u0005H\u0000¢\u0006\u0004\b\b\u0010\u000fJ\u0017\u0010\b\u001a\u00020\r2\u0006\u0010\f\u001a\u00020\u0005H\u0000¢\u0006\u0004\b\b\u0010\u0010J\u0006\u0010\u0012\u001a\u00020\u0011R*\u0010\u0013\u001a\u00020\u00112\u0006\u0010\u0013\u001a\u00020\u00118F@FX\u0086\u000e¢\u0006\u0012\n\u0004\b\u0006\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R*\u0010\u0019\u001a\u00020\u00112\u0006\u0010\u0019\u001a\u00020\u00118F@FX\u0086\u000e¢\u0006\u0012\n\u0004\b\b\u0010\u0014\u001a\u0004\b\u001a\u0010\u0016\"\u0004\b\u001b\u0010\u0018R.\u0010#\u001a\u0004\u0018\u00010\u001c2\b\u0010\u001d\u001a\u0004\u0018\u00010\u001c8F@FX\u0086\u000e¢\u0006\u0012\n\u0004\b\u0012\u0010\u001e\u001a\u0004\b\u001f\u0010 \"\u0004\b!\u0010\"R\u0018\u0010'\u001a\u0004\u0018\u00010$8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b%\u0010&R\u001e\u0010+\u001a\f\u0012\b\u0012\u00060\u0004R\u00020\u00050(8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b)\u0010*R\u001e\u0010-\u001a\f\u0012\b\u0012\u00060\u0004R\u00020\u00050(8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b,\u0010*R\u001a\u0010/\u001a\b\u0012\u0004\u0012\u00020\u00050(8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b.\u0010*R\u0011\u00101\u001a\u00020$8G¢\u0006\u0006\u001a\u0004\b\u0006\u00100¨\u00064"}, d2 = {"Lsdk/pendo/io/e2/p;", "", "", "host", "Lsdk/pendo/io/j2/e$a;", "Lsdk/pendo/io/j2/e;", CmcdData.OBJECT_TYPE_AUDIO_ONLY, "", "b", ExifInterface.GPS_DIRECTION_TRUE, "Ljava/util/Deque;", "calls", NotificationCompat.CATEGORY_CALL, "", "(Ljava/util/Deque;Ljava/lang/Object;)V", "(Lsdk/pendo/io/j2/e$a;)V", "(Lsdk/pendo/io/j2/e;)V", "", "c", "maxRequests", "I", "getMaxRequests", "()I", "setMaxRequests", "(I)V", "maxRequestsPerHost", "getMaxRequestsPerHost", "setMaxRequestsPerHost", "Ljava/lang/Runnable;", "<set-?>", "Ljava/lang/Runnable;", "getIdleCallback", "()Ljava/lang/Runnable;", "setIdleCallback", "(Ljava/lang/Runnable;)V", "idleCallback", "Ljava/util/concurrent/ExecutorService;", "d", "Ljava/util/concurrent/ExecutorService;", "executorServiceOrNull", "Ljava/util/ArrayDeque;", "e", "Ljava/util/ArrayDeque;", "readyAsyncCalls", "f", "runningAsyncCalls", "g", "runningSyncCalls", "()Ljava/util/concurrent/ExecutorService;", "executorService", "<init>", "()V", "okhttp"}, k = 1, mv = {1, 8, 0})
public final class p {

    /* JADX INFO: renamed from: c, reason: from kotlin metadata */
    private Runnable idleCallback;

    /* JADX INFO: renamed from: d, reason: from kotlin metadata */
    private ExecutorService executorServiceOrNull;

    /* JADX INFO: renamed from: a, reason: from kotlin metadata */
    private int maxRequests = 64;

    /* JADX INFO: renamed from: b, reason: from kotlin metadata */
    private int maxRequestsPerHost = 5;

    /* JADX INFO: renamed from: e, reason: from kotlin metadata */
    private final ArrayDeque<sdk.pendo.io.j2.e.a> readyAsyncCalls = new ArrayDeque<>();

    /* JADX INFO: renamed from: f, reason: from kotlin metadata */
    private final ArrayDeque<sdk.pendo.io.j2.e.a> runningAsyncCalls = new ArrayDeque<>();

    /* JADX INFO: renamed from: g, reason: from kotlin metadata */
    private final ArrayDeque<sdk.pendo.io.j2.e> runningSyncCalls = new ArrayDeque<>();

    public final void a(sdk.pendo.io.j2.e.a call) {
        sdk.pendo.io.j2.e.a aVarA;
        Intrinsics.checkNotNullParameter(call, "call");
        synchronized (this) {
            this.readyAsyncCalls.add(call);
            if (!call.getC().getForWebSocket() && (aVarA = a(call.c())) != null) {
                call.a(aVarA);
            }
            Unit unit = Unit.INSTANCE;
        }
        b();
    }

    public final void b(sdk.pendo.io.j2.e.a call) {
        Intrinsics.checkNotNullParameter(call, "call");
        call.getCallsPerHost().decrementAndGet();
        a(this.runningAsyncCalls, call);
    }

    public final synchronized int c() {
        return this.runningAsyncCalls.size() + this.runningSyncCalls.size();
    }

    public final synchronized void a(sdk.pendo.io.j2.e call) {
        Intrinsics.checkNotNullParameter(call, "call");
        this.runningSyncCalls.add(call);
    }

    public final void b(sdk.pendo.io.j2.e call) {
        Intrinsics.checkNotNullParameter(call, "call");
        a(this.runningSyncCalls, call);
    }

    private final boolean b() {
        int i;
        boolean z;
        if (sdk.pendo.io.f2.b.h && Thread.holdsLock(this)) {
            throw new AssertionError("Thread " + Thread.currentThread().getName() + " MUST NOT hold lock on " + this);
        }
        ArrayList arrayList = new ArrayList();
        synchronized (this) {
            Iterator<sdk.pendo.io.j2.e.a> it = this.readyAsyncCalls.iterator();
            Intrinsics.checkNotNullExpressionValue(it, "readyAsyncCalls.iterator()");
            while (it.hasNext()) {
                sdk.pendo.io.j2.e.a asyncCall = it.next();
                if (this.runningAsyncCalls.size() >= this.maxRequests) {
                    break;
                }
                if (asyncCall.getCallsPerHost().get() < this.maxRequestsPerHost) {
                    it.remove();
                    asyncCall.getCallsPerHost().incrementAndGet();
                    Intrinsics.checkNotNullExpressionValue(asyncCall, "asyncCall");
                    arrayList.add(asyncCall);
                    this.runningAsyncCalls.add(asyncCall);
                }
            }
            z = c() > 0;
            Unit unit = Unit.INSTANCE;
        }
        int size = arrayList.size();
        for (i = 0; i < size; i++) {
            ((sdk.pendo.io.j2.e.a) arrayList.get(i)).a(a());
        }
        return z;
    }

    public final synchronized ExecutorService a() {
        ExecutorService executorService;
        if (this.executorServiceOrNull == null) {
            this.executorServiceOrNull = new ThreadPoolExecutor(0, Integer.MAX_VALUE, 60L, TimeUnit.SECONDS, new SynchronousQueue(), sdk.pendo.io.f2.b.a(sdk.pendo.io.f2.b.i + " Dispatcher", false));
        }
        executorService = this.executorServiceOrNull;
        Intrinsics.checkNotNull(executorService);
        return executorService;
    }

    private final sdk.pendo.io.j2.e.a a(String host) {
        for (sdk.pendo.io.j2.e.a aVar : this.runningAsyncCalls) {
            if (Intrinsics.areEqual(aVar.c(), host)) {
                return aVar;
            }
        }
        for (sdk.pendo.io.j2.e.a aVar2 : this.readyAsyncCalls) {
            if (Intrinsics.areEqual(aVar2.c(), host)) {
                return aVar2;
            }
        }
        return null;
    }

    private final <T> void a(Deque<T> calls, T call) {
        Runnable runnable;
        synchronized (this) {
            if (!calls.remove(call)) {
                throw new AssertionError("Call wasn't in-flight!");
            }
            runnable = this.idleCallback;
            Unit unit = Unit.INSTANCE;
        }
        if (b() || runnable == null) {
            return;
        }
        runnable.run();
    }
}
