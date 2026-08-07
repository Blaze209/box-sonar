package sdk.pendo.io.i2;

import androidx.media3.exoplayer.upstream.CmcdData;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010!\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 '2\u00020\u0001:\u0003\u0005\u0006\rB\u000f\u0012\u0006\u0010\u0012\u001a\u00020\u000e¢\u0006\u0004\b%\u0010&J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0018\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u0007H\u0002J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\tH\u0000¢\u0006\u0004\b\u0005\u0010\u000bJ\b\u0010\u0006\u001a\u0004\u0018\u00010\u0002J\u0006\u0010\f\u001a\u00020\tJ\u0006\u0010\r\u001a\u00020\u0004R\u0017\u0010\u0012\u001a\u00020\u000e8\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011R\u0016\u0010\u0015\u001a\u00020\u00138\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0006\u0010\u0014R\u0016\u0010\u0018\u001a\u00020\u00168\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\r\u0010\u0017R\u0016\u0010\u001b\u001a\u00020\u00078\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0019\u0010\u001aR\u001a\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\t0\u001c8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\f\u0010\u001dR\u001a\u0010 \u001a\b\u0012\u0004\u0012\u00020\t0\u001c8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001f\u0010\u001dR\u0014\u0010$\u001a\u00020!8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\"\u0010#¨\u0006("}, d2 = {"Lsdk/pendo/io/i2/e;", "", "Lsdk/pendo/io/i2/a;", "task", "", CmcdData.OBJECT_TYPE_AUDIO_ONLY, "b", "", "delayNanos", "Lsdk/pendo/io/i2/d;", "taskQueue", "(Lsdk/pendo/io/i2/d;)V", "e", "c", "Lsdk/pendo/io/i2/e$a;", "Lsdk/pendo/io/i2/e$a;", "getBackend", "()Lokhttp3/internal/concurrent/TaskRunner$Backend;", "backend", "", "I", "nextQueueName", "", "Z", "coordinatorWaiting", "d", "J", "coordinatorWakeUpAt", "", "Ljava/util/List;", "busyQueues", "f", "readyQueues", "Ljava/lang/Runnable;", "g", "Ljava/lang/Runnable;", "runnable", "<init>", "(Lokhttp3/internal/concurrent/TaskRunner$Backend;)V", CmcdData.STREAMING_FORMAT_HLS, "okhttp"}, k = 1, mv = {1, 8, 0})
public final class e {

    /* JADX INFO: renamed from: h, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public static final e i = new e(new c(sdk.pendo.io.f2.b.a(sdk.pendo.io.f2.b.i + " TaskRunner", true)));
    private static final Logger j;

    /* JADX INFO: renamed from: a, reason: from kotlin metadata */
    private final a backend;

    /* JADX INFO: renamed from: b, reason: from kotlin metadata */
    private int nextQueueName;

    /* JADX INFO: renamed from: c, reason: from kotlin metadata */
    private boolean coordinatorWaiting;

    /* JADX INFO: renamed from: d, reason: from kotlin metadata */
    private long coordinatorWakeUpAt;

    /* JADX INFO: renamed from: e, reason: from kotlin metadata */
    private final List<sdk.pendo.io.i2.d> busyQueues;

    /* JADX INFO: renamed from: f, reason: from kotlin metadata */
    private final List<sdk.pendo.io.i2.d> readyQueues;

    /* JADX INFO: renamed from: g, reason: from kotlin metadata */
    private final Runnable runnable;

    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H&J\u0010\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H&J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0002H&J\u0010\u0010\u000b\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\tH&¨\u0006\f"}, d2 = {"Lsdk/pendo/io/i2/e$a;", "", "", "nanoTime", "Lsdk/pendo/io/i2/e;", "taskRunner", "", CmcdData.OBJECT_TYPE_AUDIO_ONLY, "nanos", "Ljava/lang/Runnable;", "runnable", "execute", "okhttp"}, k = 1, mv = {1, 8, 0})
    public interface a {
        void a(e taskRunner);

        void a(e taskRunner, long nanos);

        void execute(Runnable runnable);

        long nanoTime();
    }

    /* JADX INFO: renamed from: sdk.pendo.io.i2.e$b, reason: from kotlin metadata */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\n\u0010\u000bR\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u0014\u0010\b\u001a\u00020\u00078\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\b\b\u0010\t¨\u0006\f"}, d2 = {"Lsdk/pendo/io/i2/e$b;", "", "Ljava/util/logging/Logger;", "logger", "Ljava/util/logging/Logger;", CmcdData.OBJECT_TYPE_AUDIO_ONLY, "()Ljava/util/logging/Logger;", "Lsdk/pendo/io/i2/e;", "INSTANCE", "Lsdk/pendo/io/i2/e;", "<init>", "()V", "okhttp"}, k = 1, mv = {1, 8, 0})
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final Logger a() {
            return e.j;
        }
    }

    @Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0010\u001a\u00020\u000f¢\u0006\u0004\b\u0011\u0010\u0012J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0002H\u0016J\u0010\u0010\u000b\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\tH\u0016R\u0014\u0010\u000e\u001a\u00020\f8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0007\u0010\r¨\u0006\u0013"}, d2 = {"Lsdk/pendo/io/i2/e$c;", "Lsdk/pendo/io/i2/e$a;", "", "nanoTime", "Lsdk/pendo/io/i2/e;", "taskRunner", "", CmcdData.OBJECT_TYPE_AUDIO_ONLY, "nanos", "Ljava/lang/Runnable;", "runnable", "execute", "Ljava/util/concurrent/ThreadPoolExecutor;", "Ljava/util/concurrent/ThreadPoolExecutor;", "executor", "Ljava/util/concurrent/ThreadFactory;", "threadFactory", "<init>", "(Ljava/util/concurrent/ThreadFactory;)V", "okhttp"}, k = 1, mv = {1, 8, 0})
    public static final class c implements a {

        /* JADX INFO: renamed from: a, reason: from kotlin metadata */
        private final ThreadPoolExecutor executor;

        public c(ThreadFactory threadFactory) {
            Intrinsics.checkNotNullParameter(threadFactory, "threadFactory");
            this.executor = new ThreadPoolExecutor(0, Integer.MAX_VALUE, 60L, TimeUnit.SECONDS, new SynchronousQueue(), threadFactory);
        }

        @Override // sdk.pendo.io.i2.e.a
        public void a(e taskRunner) {
            Intrinsics.checkNotNullParameter(taskRunner, "taskRunner");
            taskRunner.notify();
        }

        @Override // sdk.pendo.io.i2.e.a
        public void execute(Runnable runnable) {
            Intrinsics.checkNotNullParameter(runnable, "runnable");
            this.executor.execute(runnable);
        }

        @Override // sdk.pendo.io.i2.e.a
        public long nanoTime() {
            return System.nanoTime();
        }

        @Override // sdk.pendo.io.i2.e.a
        public void a(e taskRunner, long nanos) throws InterruptedException {
            Intrinsics.checkNotNullParameter(taskRunner, "taskRunner");
            long j = nanos / 1000000;
            long j2 = nanos - (1000000 * j);
            if (j > 0 || nanos > 0) {
                taskRunner.wait(j, (int) j2);
            }
        }
    }

    @Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016¨\u0006\u0004"}, d2 = {"sdk/pendo/io/i2/e$d", "Ljava/lang/Runnable;", "", "run", "okhttp"}, k = 1, mv = {1, 8, 0})
    public static final class d implements Runnable {
        d() {
        }

        @Override // java.lang.Runnable
        public void run() {
            sdk.pendo.io.i2.a aVarB;
            long jNanoTime;
            while (true) {
                e eVar = e.this;
                synchronized (eVar) {
                    aVarB = eVar.b();
                }
                if (aVarB == null) {
                    return;
                }
                sdk.pendo.io.i2.d dVar = aVarB.getIo.opentelemetry.semconv.trace.attributes.SemanticAttributes.MessagingDestinationKindValues.QUEUE java.lang.String();
                Intrinsics.checkNotNull(dVar);
                e eVar2 = e.this;
                boolean zIsLoggable = e.INSTANCE.a().isLoggable(Level.FINE);
                if (zIsLoggable) {
                    jNanoTime = dVar.getTaskRunner().getBackend().nanoTime();
                    b.b(aVarB, dVar, "starting");
                } else {
                    jNanoTime = -1;
                }
                try {
                    eVar2.b(aVarB);
                    try {
                        Unit unit = Unit.INSTANCE;
                        if (zIsLoggable) {
                            b.b(aVarB, dVar, "finished run in " + b.a(dVar.getTaskRunner().getBackend().nanoTime() - jNanoTime));
                        }
                    } catch (Throwable th) {
                        if (zIsLoggable) {
                            b.b(aVarB, dVar, "failed a run in " + b.a(dVar.getTaskRunner().getBackend().nanoTime() - jNanoTime));
                        }
                        throw th;
                    }
                } catch (Throwable th2) {
                    eVar2.getBackend().execute(this);
                    throw th2;
                }
            }
        }
    }

    static {
        Logger logger = Logger.getLogger(e.class.getName());
        Intrinsics.checkNotNullExpressionValue(logger, "getLogger(TaskRunner::class.java.name)");
        j = logger;
    }

    public e(a backend) {
        Intrinsics.checkNotNullParameter(backend, "backend");
        this.backend = backend;
        this.nextQueueName = 10000;
        this.busyQueues = new ArrayList();
        this.readyQueues = new ArrayList();
        this.runnable = new d();
    }

    public final sdk.pendo.io.i2.a b() {
        boolean z;
        if (sdk.pendo.io.f2.b.h && !Thread.holdsLock(this)) {
            throw new AssertionError("Thread " + Thread.currentThread().getName() + " MUST hold lock on " + this);
        }
        while (!this.readyQueues.isEmpty()) {
            long jNanoTime = this.backend.nanoTime();
            Iterator<sdk.pendo.io.i2.d> it = this.readyQueues.iterator();
            long jMin = Long.MAX_VALUE;
            sdk.pendo.io.i2.a aVar = null;
            while (true) {
                if (!it.hasNext()) {
                    z = false;
                    break;
                }
                sdk.pendo.io.i2.a aVar2 = it.next().e().get(0);
                long jMax = Math.max(0L, aVar2.getNextExecuteNanoTime() - jNanoTime);
                if (jMax > 0) {
                    jMin = Math.min(jMax, jMin);
                } else {
                    if (aVar != null) {
                        z = true;
                        break;
                    }
                    aVar = aVar2;
                }
            }
            if (aVar != null) {
                a(aVar);
                if (z || (!this.coordinatorWaiting && !this.readyQueues.isEmpty())) {
                    this.backend.execute(this.runnable);
                }
                return aVar;
            }
            if (this.coordinatorWaiting) {
                if (jMin < this.coordinatorWakeUpAt - jNanoTime) {
                    this.backend.a(this);
                }
                return null;
            }
            this.coordinatorWaiting = true;
            this.coordinatorWakeUpAt = jNanoTime + jMin;
            try {
                try {
                    this.backend.a(this, jMin);
                } catch (InterruptedException unused) {
                    c();
                }
                this.coordinatorWaiting = false;
            } catch (Throwable th) {
                this.coordinatorWaiting = false;
                throw th;
            }
        }
        return null;
    }

    public final void c() {
        int size = this.busyQueues.size();
        while (true) {
            size--;
            if (-1 >= size) {
                break;
            } else {
                this.busyQueues.get(size).b();
            }
        }
        for (int size2 = this.readyQueues.size() - 1; -1 < size2; size2--) {
            sdk.pendo.io.i2.d dVar = this.readyQueues.get(size2);
            dVar.b();
            if (dVar.e().isEmpty()) {
                this.readyQueues.remove(size2);
            }
        }
    }

    /* JADX INFO: renamed from: d, reason: from getter */
    public final a getBackend() {
        return this.backend;
    }

    public final sdk.pendo.io.i2.d e() {
        int i2;
        synchronized (this) {
            i2 = this.nextQueueName;
            this.nextQueueName = i2 + 1;
        }
        return new sdk.pendo.io.i2.d(this, "Q" + i2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void b(sdk.pendo.io.i2.a task) {
        if (sdk.pendo.io.f2.b.h && Thread.holdsLock(this)) {
            throw new AssertionError("Thread " + Thread.currentThread().getName() + " MUST NOT hold lock on " + this);
        }
        Thread threadCurrentThread = Thread.currentThread();
        String name = threadCurrentThread.getName();
        threadCurrentThread.setName(task.getName());
        try {
            long jE = task.e();
            synchronized (this) {
                a(task, jE);
                Unit unit = Unit.INSTANCE;
            }
        } finally {
            synchronized (this) {
                a(task, -1L);
                Unit unit2 = Unit.INSTANCE;
                threadCurrentThread.setName(name);
            }
        }
    }

    private final void a(sdk.pendo.io.i2.a task, long delayNanos) {
        if (sdk.pendo.io.f2.b.h && !Thread.holdsLock(this)) {
            throw new AssertionError("Thread " + Thread.currentThread().getName() + " MUST hold lock on " + this);
        }
        sdk.pendo.io.i2.d dVar = task.getIo.opentelemetry.semconv.trace.attributes.SemanticAttributes.MessagingDestinationKindValues.QUEUE java.lang.String();
        Intrinsics.checkNotNull(dVar);
        if (dVar.getActiveTask() != task) {
            throw new IllegalStateException("Check failed.".toString());
        }
        boolean cancelActiveTask = dVar.getCancelActiveTask();
        dVar.a(false);
        dVar.a((sdk.pendo.io.i2.a) null);
        this.busyQueues.remove(dVar);
        if (delayNanos != -1 && !cancelActiveTask && !dVar.getShutdown()) {
            dVar.a(task, delayNanos, true);
        }
        if (dVar.e().isEmpty()) {
            return;
        }
        this.readyQueues.add(dVar);
    }

    private final void a(sdk.pendo.io.i2.a task) {
        if (sdk.pendo.io.f2.b.h && !Thread.holdsLock(this)) {
            throw new AssertionError("Thread " + Thread.currentThread().getName() + " MUST hold lock on " + this);
        }
        task.a(-1L);
        sdk.pendo.io.i2.d dVar = task.getIo.opentelemetry.semconv.trace.attributes.SemanticAttributes.MessagingDestinationKindValues.QUEUE java.lang.String();
        Intrinsics.checkNotNull(dVar);
        dVar.e().remove(task);
        this.readyQueues.remove(dVar);
        dVar.a(task);
        this.busyQueues.add(dVar);
    }

    public final void a(sdk.pendo.io.i2.d taskQueue) {
        Intrinsics.checkNotNullParameter(taskQueue, "taskQueue");
        if (sdk.pendo.io.f2.b.h && !Thread.holdsLock(this)) {
            throw new AssertionError("Thread " + Thread.currentThread().getName() + " MUST hold lock on " + this);
        }
        if (taskQueue.getActiveTask() == null) {
            if (taskQueue.e().isEmpty()) {
                this.readyQueues.remove(taskQueue);
            } else {
                sdk.pendo.io.f2.b.a(this.readyQueues, taskQueue);
            }
        }
        if (this.coordinatorWaiting) {
            this.backend.a(this);
        } else {
            this.backend.execute(this.runnable);
        }
    }
}
