package sdk.pendo.io.s2;

import androidx.media3.exoplayer.upstream.CmcdData;
import com.box.androidsdk.content.models.BoxFile;
import com.microsoft.identity.common.nativeauth.internal.commands.ResetPasswordSubmitNewPasswordCommand;
import external.sdk.pendo.io.mozilla.javascript.ES6Iterator;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.apache.hc.core5.http.HeaderElements;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000e\b\u0016\u0018\u0000 \u001c2\u00020\u0001:\u0002\f\u0004B\u0007¢\u0006\u0004\b\u001a\u0010\u001bJ\u0010\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0006\u0010\u0006\u001a\u00020\u0005J\u0006\u0010\b\u001a\u00020\u0007J\b\u0010\t\u001a\u00020\u0005H\u0014J\u000e\u0010\f\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\nJ\u000e\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\rJ\u0012\u0010\f\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u000fH\u0001J\u0012\u0010\u0004\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u000fH\u0014R\u0016\u0010\u0013\u001a\u00020\u00078\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0011\u0010\u0012R\u0018\u0010\u0016\u001a\u0004\u0018\u00010\u00008\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0014\u0010\u0015R\u0016\u0010\u0019\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0017\u0010\u0018¨\u0006\u001d"}, d2 = {"Lsdk/pendo/io/s2/c;", "Lsdk/pendo/io/s2/b0;", "", "now", "b", "", CmcdData.STREAM_TYPE_LIVE, "", CmcdData.OBJECT_TYPE_MANIFEST, "n", "Lsdk/pendo/io/s2/y;", "sink", CmcdData.OBJECT_TYPE_AUDIO_ONLY, "Lsdk/pendo/io/s2/a0;", "source", "Ljava/io/IOException;", "cause", "f", "Z", "inQueue", "g", "Lsdk/pendo/io/s2/c;", ES6Iterator.NEXT_METHOD, CmcdData.STREAMING_FORMAT_HLS, "J", "timeoutAt", "<init>", "()V", "i", "external.sdk.pendo.io.okio"}, k = 1, mv = {1, 9, 0})
public class c extends b0 {

    /* JADX INFO: renamed from: i, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final ReentrantLock j;
    private static final Condition k;
    private static final long l;
    private static final long m;
    private static c n;

    /* JADX INFO: renamed from: f, reason: from kotlin metadata */
    private boolean inQueue;

    /* JADX INFO: renamed from: g, reason: from kotlin metadata */
    private c next;

    /* JADX INFO: renamed from: h, reason: from kotlin metadata */
    private long timeoutAt;

    /* JADX INFO: renamed from: sdk.pendo.io.s2.c$a, reason: from kotlin metadata */
    @Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u0007\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u001d\u0010\u001eJ \u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J\u0010\u0010\t\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0011\u0010\t\u001a\u0004\u0018\u00010\u0002H\u0000¢\u0006\u0004\b\t\u0010\nR\u0017\u0010\f\u001a\u00020\u000b8\u0006¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000fR\u0017\u0010\u0011\u001a\u00020\u00108\u0006¢\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014R\u0014\u0010\u0015\u001a\u00020\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0015\u0010\u0016R\u0014\u0010\u0017\u001a\u00020\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0017\u0010\u0016R\u0014\u0010\u0019\u001a\u00020\u00188\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0019\u0010\u001aR\u0018\u0010\u001b\u001a\u0004\u0018\u00010\u00028\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001b\u0010\u001c¨\u0006\u001f"}, d2 = {"Lsdk/pendo/io/s2/c$a;", "", "Lsdk/pendo/io/s2/c;", "node", "", "timeoutNanos", "", "hasDeadline", "", CmcdData.OBJECT_TYPE_AUDIO_ONLY, "()Lsdk/pendo/io/s2/c;", "Ljava/util/concurrent/locks/ReentrantLock;", BoxFile.FIELD_LOCK, "Ljava/util/concurrent/locks/ReentrantLock;", "c", "()Ljava/util/concurrent/locks/ReentrantLock;", "Ljava/util/concurrent/locks/Condition;", "condition", "Ljava/util/concurrent/locks/Condition;", "b", "()Ljava/util/concurrent/locks/Condition;", "IDLE_TIMEOUT_MILLIS", "J", "IDLE_TIMEOUT_NANOS", "", "TIMEOUT_WRITE_SIZE", "I", "head", "Lsdk/pendo/io/s2/c;", "<init>", "()V", "external.sdk.pendo.io.okio"}, k = 1, mv = {1, 9, 0})
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final Condition b() {
            return c.k;
        }

        public final ReentrantLock c() {
            return c.j;
        }

        public final c a() throws InterruptedException {
            c cVar = c.n;
            Intrinsics.checkNotNull(cVar);
            c cVar2 = cVar.next;
            long jNanoTime = System.nanoTime();
            if (cVar2 == null) {
                b().await(c.l, TimeUnit.MILLISECONDS);
                c cVar3 = c.n;
                Intrinsics.checkNotNull(cVar3);
                if (cVar3.next != null || System.nanoTime() - jNanoTime < c.m) {
                    return null;
                }
                return c.n;
            }
            long jB = cVar2.b(jNanoTime);
            if (jB > 0) {
                b().await(jB, TimeUnit.NANOSECONDS);
                return null;
            }
            c cVar4 = c.n;
            Intrinsics.checkNotNull(cVar4);
            cVar4.next = cVar2.next;
            cVar2.next = null;
            return cVar2;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final boolean a(c node) {
            ReentrantLock reentrantLockC = c.INSTANCE.c();
            reentrantLockC.lock();
            try {
                if (!node.inQueue) {
                    return false;
                }
                node.inQueue = false;
                for (c cVar = c.n; cVar != null; cVar = cVar.next) {
                    if (cVar.next == node) {
                        cVar.next = node.next;
                        node.next = null;
                        return false;
                    }
                }
                return true;
            } finally {
                reentrantLockC.unlock();
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX WARN: Code duplicated, block: B:19:0x005d A[Catch: all -> 0x00a3, TryCatch #0 {all -> 0x00a3, blocks: (B:3:0x0009, B:5:0x000f, B:7:0x0019, B:8:0x0029, B:11:0x0035, B:13:0x0041, B:16:0x0049, B:17:0x0054, B:19:0x005d, B:22:0x006d, B:23:0x0072, B:25:0x0082, B:26:0x008b, B:15:0x0045, B:29:0x0091, B:30:0x0096, B:31:0x0097, B:32:0x00a2), top: B:36:0x0009 }] */
        /* JADX WARN: Code duplicated, block: B:22:0x006d A[Catch: all -> 0x00a3, LOOP:0: B:17:0x0054->B:22:0x006d, LOOP_END, TryCatch #0 {all -> 0x00a3, blocks: (B:3:0x0009, B:5:0x000f, B:7:0x0019, B:8:0x0029, B:11:0x0035, B:13:0x0041, B:16:0x0049, B:17:0x0054, B:19:0x005d, B:22:0x006d, B:23:0x0072, B:25:0x0082, B:26:0x008b, B:15:0x0045, B:29:0x0091, B:30:0x0096, B:31:0x0097, B:32:0x00a2), top: B:36:0x0009 }] */
        /* JADX WARN: Code duplicated, block: B:25:0x0082 A[Catch: all -> 0x00a3, TryCatch #0 {all -> 0x00a3, blocks: (B:3:0x0009, B:5:0x000f, B:7:0x0019, B:8:0x0029, B:11:0x0035, B:13:0x0041, B:16:0x0049, B:17:0x0054, B:19:0x005d, B:22:0x006d, B:23:0x0072, B:25:0x0082, B:26:0x008b, B:15:0x0045, B:29:0x0091, B:30:0x0096, B:31:0x0097, B:32:0x00a2), top: B:36:0x0009 }] */
        /* JADX WARN: Code duplicated, block: B:37:0x0072 A[EDGE_INSN: B:37:0x0072->B:23:0x0072 BREAK  A[LOOP:0: B:17:0x0054->B:22:0x006d], SYNTHETIC] */
        /* JADX WARN: Code duplicated, block: B:38:0x006c A[SYNTHETIC] */
        public final void a(c node, long timeoutNanos, boolean hasDeadline) {
            long jC;
            long jB;
            c cVar;
            c cVar2;
            ReentrantLock reentrantLockC = c.INSTANCE.c();
            reentrantLockC.lock();
            try {
                if (node.inQueue) {
                    throw new IllegalStateException("Unbalanced enter/exit".toString());
                }
                node.inQueue = true;
                if (c.n == null) {
                    c.n = new c();
                    new b().start();
                }
                long jNanoTime = System.nanoTime();
                if (timeoutNanos == 0 || !hasDeadline) {
                    if (timeoutNanos == 0) {
                        if (!hasDeadline) {
                            throw new AssertionError();
                        }
                        jC = node.c();
                    }
                    node.timeoutAt = jC;
                    jB = node.b(jNanoTime);
                    cVar = c.n;
                    while (true) {
                        Intrinsics.checkNotNull(cVar);
                        if (cVar.next != null) {
                            break;
                        }
                        cVar2 = cVar.next;
                        Intrinsics.checkNotNull(cVar2);
                        if (jB < cVar2.b(jNanoTime)) {
                            break;
                        } else {
                            cVar = cVar.next;
                        }
                    }
                    node.next = cVar.next;
                    cVar.next = node;
                    if (cVar == c.n) {
                        c.INSTANCE.b().signal();
                    }
                    Unit unit = Unit.INSTANCE;
                    reentrantLockC.unlock();
                }
                timeoutNanos = Math.min(timeoutNanos, node.c() - jNanoTime);
                jC = timeoutNanos + jNanoTime;
                node.timeoutAt = jC;
                jB = node.b(jNanoTime);
                cVar = c.n;
                while (true) {
                    Intrinsics.checkNotNull(cVar);
                    if (cVar.next != null) {
                        break;
                        break;
                    }
                    cVar2 = cVar.next;
                    Intrinsics.checkNotNull(cVar2);
                    if (jB < cVar2.b(jNanoTime)) {
                        break;
                        break;
                    }
                    cVar = cVar.next;
                }
                node.next = cVar.next;
                cVar.next = node;
                if (cVar == c.n) {
                    c.INSTANCE.b().signal();
                }
                Unit unit2 = Unit.INSTANCE;
                reentrantLockC.unlock();
            } catch (Throwable th) {
                reentrantLockC.unlock();
                throw th;
            }
        }
    }

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\b\u0002\u0018\u00002\u00020\u0001B\t\b\u0000¢\u0006\u0004\b\u0004\u0010\u0005J\b\u0010\u0003\u001a\u00020\u0002H\u0016¨\u0006\u0006"}, d2 = {"Lsdk/pendo/io/s2/c$b;", "Ljava/lang/Thread;", "", "run", "<init>", "()V", "external.sdk.pendo.io.okio"}, k = 1, mv = {1, 9, 0})
    private static final class b extends Thread {
        public b() {
            super("Okio Watchdog");
            setDaemon(true);
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            while (true) {
                try {
                    Companion companion = c.INSTANCE;
                    ReentrantLock reentrantLockC = companion.c();
                    reentrantLockC.lock();
                    try {
                        c cVarA = companion.a();
                        if (cVarA == c.n) {
                            c.n = null;
                            reentrantLockC.unlock();
                            return;
                        } else {
                            Unit unit = Unit.INSTANCE;
                            reentrantLockC.unlock();
                            if (cVarA != null) {
                                cVarA.n();
                            }
                        }
                    } catch (Throwable th) {
                        reentrantLockC.unlock();
                        throw th;
                    }
                } catch (InterruptedException unused) {
                    continue;
                }
            }
        }
    }

    /* JADX INFO: renamed from: sdk.pendo.io.s2.c$c, reason: collision with other inner class name */
    @Metadata(d1 = {"\u0000)\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\b\u0010\b\u001a\u00020\u0006H\u0016J\b\u0010\t\u001a\u00020\u0006H\u0016J\b\u0010\u0007\u001a\u00020\nH\u0016J\b\u0010\f\u001a\u00020\u000bH\u0016¨\u0006\r"}, d2 = {"sdk/pendo/io/s2/c$c", "Lsdk/pendo/io/s2/y;", "Lsdk/pendo/io/s2/d;", "source", "", "byteCount", "", CmcdData.OBJECT_TYPE_AUDIO_ONLY, "flush", HeaderElements.CLOSE, "Lsdk/pendo/io/s2/c;", "", "toString", "external.sdk.pendo.io.okio"}, k = 1, mv = {1, 9, 0})
    public static final class C0475c implements y {
        final /* synthetic */ y b;

        C0475c(y yVar) {
            this.b = yVar;
        }

        @Override // sdk.pendo.io.s2.y
        /* JADX INFO: renamed from: a, reason: from getter and merged with bridge method [inline-methods] */
        public c timeout() {
            return c.this;
        }

        @Override // sdk.pendo.io.s2.y, java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
            c cVar = c.this;
            y yVar = this.b;
            cVar.l();
            try {
                try {
                    yVar.close();
                    Unit unit = Unit.INSTANCE;
                    if (cVar.m()) {
                        throw cVar.a((IOException) null);
                    }
                } catch (IOException e) {
                    if (!cVar.m()) {
                        throw e;
                    }
                    throw cVar.a(e);
                }
            } catch (Throwable th) {
                cVar.m();
                throw th;
            }
        }

        @Override // sdk.pendo.io.s2.y, java.io.Flushable
        public void flush() throws IOException {
            c cVar = c.this;
            y yVar = this.b;
            cVar.l();
            try {
                try {
                    yVar.flush();
                    Unit unit = Unit.INSTANCE;
                    if (cVar.m()) {
                        throw cVar.a((IOException) null);
                    }
                } catch (IOException e) {
                    if (!cVar.m()) {
                        throw e;
                    }
                    throw cVar.a(e);
                }
            } catch (Throwable th) {
                cVar.m();
                throw th;
            }
        }

        public String toString() {
            return "AsyncTimeout.sink(" + this.b + ')';
        }

        @Override // sdk.pendo.io.s2.y
        public void a(sdk.pendo.io.s2.d source, long byteCount) throws IOException {
            Intrinsics.checkNotNullParameter(source, "source");
            sdk.pendo.io.s2.b.a(source.getSize(), 0L, byteCount);
            while (true) {
                long j = 0;
                if (byteCount <= 0) {
                    return;
                }
                v vVar = source.head;
                while (true) {
                    Intrinsics.checkNotNull(vVar);
                    if (j >= 65536) {
                        break;
                    }
                    j += (long) (vVar.com.box.androidsdk.content.models.BoxIterator.FIELD_LIMIT java.lang.String - vVar.pos);
                    if (j >= byteCount) {
                        j = byteCount;
                        break;
                    }
                    vVar = vVar.external.sdk.pendo.io.mozilla.javascript.ES6Iterator.NEXT_METHOD java.lang.String;
                }
                c cVar = c.this;
                y yVar = this.b;
                cVar.l();
                try {
                    try {
                        yVar.a(source, j);
                        Unit unit = Unit.INSTANCE;
                        if (cVar.m()) {
                            throw cVar.a((IOException) null);
                        }
                        byteCount -= j;
                    } catch (IOException e) {
                        if (!cVar.m()) {
                            throw e;
                        }
                        throw cVar.a(e);
                    }
                } catch (Throwable th) {
                    cVar.m();
                    throw th;
                }
            }
        }
    }

    @Metadata(d1 = {"\u0000+\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\b\u0010\b\u001a\u00020\u0007H\u0016J\b\u0010\n\u001a\u00020\tH\u0016J\b\u0010\f\u001a\u00020\u000bH\u0016¨\u0006\r"}, d2 = {"sdk/pendo/io/s2/c$d", "Lsdk/pendo/io/s2/a0;", "Lsdk/pendo/io/s2/d;", "sink", "", "byteCount", "b", "", HeaderElements.CLOSE, "Lsdk/pendo/io/s2/c;", CmcdData.OBJECT_TYPE_AUDIO_ONLY, "", "toString", "external.sdk.pendo.io.okio"}, k = 1, mv = {1, 9, 0})
    public static final class d implements a0 {
        final /* synthetic */ a0 b;

        d(a0 a0Var) {
            this.b = a0Var;
        }

        @Override // sdk.pendo.io.s2.a0
        /* JADX INFO: renamed from: a, reason: from getter and merged with bridge method [inline-methods] */
        public c timeout() {
            return c.this;
        }

        @Override // sdk.pendo.io.s2.a0
        public long b(sdk.pendo.io.s2.d sink, long byteCount) throws IOException {
            Intrinsics.checkNotNullParameter(sink, "sink");
            c cVar = c.this;
            a0 a0Var = this.b;
            cVar.l();
            try {
                try {
                    long jB = a0Var.b(sink, byteCount);
                    if (cVar.m()) {
                        throw cVar.a((IOException) null);
                    }
                    return jB;
                } catch (IOException e) {
                    if (cVar.m()) {
                        throw cVar.a(e);
                    }
                    throw e;
                }
            } catch (Throwable th) {
                cVar.m();
                throw th;
            }
        }

        @Override // sdk.pendo.io.s2.a0, java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
            c cVar = c.this;
            a0 a0Var = this.b;
            cVar.l();
            try {
                try {
                    a0Var.close();
                    Unit unit = Unit.INSTANCE;
                    if (cVar.m()) {
                        throw cVar.a((IOException) null);
                    }
                } catch (IOException e) {
                    if (!cVar.m()) {
                        throw e;
                    }
                    throw cVar.a(e);
                }
            } catch (Throwable th) {
                cVar.m();
                throw th;
            }
        }

        public String toString() {
            return "AsyncTimeout.source(" + this.b + ')';
        }
    }

    static {
        ReentrantLock reentrantLock = new ReentrantLock();
        j = reentrantLock;
        Condition conditionNewCondition = reentrantLock.newCondition();
        Intrinsics.checkNotNullExpressionValue(conditionNewCondition, "newCondition(...)");
        k = conditionNewCondition;
        long millis = TimeUnit.SECONDS.toMillis(60L);
        l = millis;
        m = TimeUnit.MILLISECONDS.toNanos(millis);
    }

    public final void l() {
        long timeoutNanos = getTimeoutNanos();
        boolean hasDeadline = getHasDeadline();
        if (timeoutNanos != 0 || hasDeadline) {
            INSTANCE.a(this, timeoutNanos, hasDeadline);
        }
    }

    public final boolean m() {
        return INSTANCE.a(this);
    }

    protected void n() {
    }

    public final IOException a(IOException cause) {
        return b(cause);
    }

    protected IOException b(IOException cause) {
        InterruptedIOException interruptedIOException = new InterruptedIOException(ResetPasswordSubmitNewPasswordCommand.POLL_COMPLETION_TIMEOUT_ERROR_CODE);
        if (cause != null) {
            interruptedIOException.initCause(cause);
        }
        return interruptedIOException;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final long b(long now) {
        return this.timeoutAt - now;
    }

    public final y a(y sink) {
        Intrinsics.checkNotNullParameter(sink, "sink");
        return new C0475c(sink);
    }

    public final a0 a(a0 source) {
        Intrinsics.checkNotNullParameter(source, "source");
        return new d(source);
    }
}
