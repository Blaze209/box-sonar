package sdk.pendo.io.i2;

import androidx.media3.exoplayer.upstream.CmcdData;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.RejectedExecutionException;
import java.util.logging.Level;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0015\n\u0002\u0010!\n\u0002\b\b\u0018\u00002\u00020\u0001B\u0019\b\u0000\u0012\u0006\u0010\u0014\u001a\u00020\u0010\u0012\u0006\u0010\u0018\u001a\u00020\u000e¢\u0006\u0004\b,\u0010-J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\u0005\u001a\u00020\u0004J'\u0010\u0007\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\bH\u0000¢\u0006\u0004\b\u0007\u0010\nJ\u0006\u0010\u0007\u001a\u00020\u0006J\u0006\u0010\u000b\u001a\u00020\u0006J\u000f\u0010\f\u001a\u00020\bH\u0000¢\u0006\u0004\b\f\u0010\rJ\b\u0010\u000f\u001a\u00020\u000eH\u0016R\u001a\u0010\u0014\u001a\u00020\u00108\u0000X\u0080\u0004¢\u0006\f\n\u0004\b\u0007\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013R\u001a\u0010\u0018\u001a\u00020\u000e8\u0000X\u0080\u0004¢\u0006\f\n\u0004\b\f\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017R\"\u0010\u001e\u001a\u00020\b8\u0000@\u0000X\u0080\u000e¢\u0006\u0012\n\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u001b\u0010\r\"\u0004\b\u001c\u0010\u001dR$\u0010%\u001a\u0004\u0018\u00010\u00028\u0000@\u0000X\u0080\u000e¢\u0006\u0012\n\u0004\b\u001f\u0010 \u001a\u0004\b!\u0010\"\"\u0004\b#\u0010$R \u0010*\u001a\b\u0012\u0004\u0012\u00020\u00020&8\u0000X\u0080\u0004¢\u0006\f\n\u0004\b'\u0010(\u001a\u0004\b'\u0010)R\"\u0010+\u001a\u00020\b8\u0000@\u0000X\u0080\u000e¢\u0006\u0012\n\u0004\b\u0016\u0010\u001a\u001a\u0004\b\u001f\u0010\r\"\u0004\b\u0007\u0010\u001d¨\u0006."}, d2 = {"Lsdk/pendo/io/i2/d;", "", "Lsdk/pendo/io/i2/a;", "task", "", "delayNanos", "", CmcdData.OBJECT_TYPE_AUDIO_ONLY, "", "recurrence", "(Lsdk/pendo/io/i2/a;JZ)Z", "i", "b", "()Z", "", "toString", "Lsdk/pendo/io/i2/e;", "Lsdk/pendo/io/i2/e;", "getTaskRunner$okhttp", "()Lokhttp3/internal/concurrent/TaskRunner;", "taskRunner", "Ljava/lang/String;", "f", "()Ljava/lang/String;", "name", "c", "Z", "g", "setShutdown$okhttp", "(Z)V", "shutdown", "d", "Lsdk/pendo/io/i2/a;", "getActiveTask$okhttp", "()Lokhttp3/internal/concurrent/Task;", "setActiveTask$okhttp", "(Lokhttp3/internal/concurrent/Task;)V", "activeTask", "", "e", "Ljava/util/List;", "()Ljava/util/List;", "futureTasks", "cancelActiveTask", "<init>", "(Lokhttp3/internal/concurrent/TaskRunner;Ljava/lang/String;)V", "okhttp"}, k = 1, mv = {1, 8, 0})
public final class d {

    /* JADX INFO: renamed from: a, reason: from kotlin metadata */
    private final e taskRunner;

    /* JADX INFO: renamed from: b, reason: from kotlin metadata */
    private final String name;

    /* JADX INFO: renamed from: c, reason: from kotlin metadata */
    private boolean shutdown;

    /* JADX INFO: renamed from: d, reason: from kotlin metadata */
    private a activeTask;

    /* JADX INFO: renamed from: e, reason: from kotlin metadata */
    private final List<a> futureTasks;

    /* JADX INFO: renamed from: f, reason: from kotlin metadata */
    private boolean cancelActiveTask;

    public d(e taskRunner, String name) {
        Intrinsics.checkNotNullParameter(taskRunner, "taskRunner");
        Intrinsics.checkNotNullParameter(name, "name");
        this.taskRunner = taskRunner;
        this.name = name;
        this.futureTasks = new ArrayList();
    }

    public final void a() {
        if (sdk.pendo.io.f2.b.h && Thread.holdsLock(this)) {
            throw new AssertionError("Thread " + Thread.currentThread().getName() + " MUST NOT hold lock on " + this);
        }
        synchronized (this.taskRunner) {
            if (b()) {
                this.taskRunner.a(this);
            }
            Unit unit = Unit.INSTANCE;
        }
    }

    public final boolean b() {
        a aVar = this.activeTask;
        if (aVar != null) {
            Intrinsics.checkNotNull(aVar);
            if (aVar.getCancelable()) {
                this.cancelActiveTask = true;
            }
        }
        boolean z = false;
        for (int size = this.futureTasks.size() - 1; -1 < size; size--) {
            if (this.futureTasks.get(size).getCancelable()) {
                a aVar2 = this.futureTasks.get(size);
                if (e.INSTANCE.a().isLoggable(Level.FINE)) {
                    b.b(aVar2, this, "canceled");
                }
                this.futureTasks.remove(size);
                z = true;
            }
        }
        return z;
    }

    /* JADX INFO: renamed from: c, reason: from getter */
    public final a getActiveTask() {
        return this.activeTask;
    }

    /* JADX INFO: renamed from: d, reason: from getter */
    public final boolean getCancelActiveTask() {
        return this.cancelActiveTask;
    }

    public final List<a> e() {
        return this.futureTasks;
    }

    /* JADX INFO: renamed from: f, reason: from getter */
    public final String getName() {
        return this.name;
    }

    /* JADX INFO: renamed from: g, reason: from getter */
    public final boolean getShutdown() {
        return this.shutdown;
    }

    /* JADX INFO: renamed from: h, reason: from getter */
    public final e getTaskRunner() {
        return this.taskRunner;
    }

    public final void i() {
        if (sdk.pendo.io.f2.b.h && Thread.holdsLock(this)) {
            throw new AssertionError("Thread " + Thread.currentThread().getName() + " MUST NOT hold lock on " + this);
        }
        synchronized (this.taskRunner) {
            this.shutdown = true;
            if (b()) {
                this.taskRunner.a(this);
            }
            Unit unit = Unit.INSTANCE;
        }
    }

    public String toString() {
        return this.name;
    }

    public final void a(a task, long delayNanos) {
        Intrinsics.checkNotNullParameter(task, "task");
        synchronized (this.taskRunner) {
            if (!this.shutdown) {
                if (a(task, delayNanos, false)) {
                    this.taskRunner.a(this);
                }
                Unit unit = Unit.INSTANCE;
            } else if (task.getCancelable()) {
                if (e.INSTANCE.a().isLoggable(Level.FINE)) {
                    b.b(task, this, "schedule canceled (queue is shutdown)");
                }
            } else {
                if (e.INSTANCE.a().isLoggable(Level.FINE)) {
                    b.b(task, this, "schedule failed (queue is shutdown)");
                }
                throw new RejectedExecutionException();
            }
        }
    }

    public static /* synthetic */ void a(d dVar, a aVar, long j, int i, Object obj) {
        if ((i & 2) != 0) {
            j = 0;
        }
        dVar.a(aVar, j);
    }

    public final boolean a(a task, long delayNanos, boolean recurrence) {
        Intrinsics.checkNotNullParameter(task, "task");
        task.a(this);
        long jNanoTime = this.taskRunner.getBackend().nanoTime();
        long j = jNanoTime + delayNanos;
        int iIndexOf = this.futureTasks.indexOf(task);
        if (iIndexOf != -1) {
            if (task.getNextExecuteNanoTime() <= j) {
                if (e.INSTANCE.a().isLoggable(Level.FINE)) {
                    b.b(task, this, "already scheduled");
                }
                return false;
            }
            this.futureTasks.remove(iIndexOf);
        }
        task.a(j);
        if (e.INSTANCE.a().isLoggable(Level.FINE)) {
            b.b(task, this, (recurrence ? new StringBuilder("run again after ") : new StringBuilder("scheduled after ")).append(b.a(j - jNanoTime)).toString());
        }
        Iterator<a> it = this.futureTasks.iterator();
        int size = 0;
        while (true) {
            if (!it.hasNext()) {
                size = -1;
                break;
            }
            if (it.next().getNextExecuteNanoTime() - jNanoTime > delayNanos) {
                break;
            }
            size++;
        }
        if (size == -1) {
            size = this.futureTasks.size();
        }
        this.futureTasks.add(size, task);
        return size == 0;
    }

    public final void a(a aVar) {
        this.activeTask = aVar;
    }

    public final void a(boolean z) {
        this.cancelActiveTask = z;
    }
}
