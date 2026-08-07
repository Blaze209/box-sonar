package sdk.pendo.io.j2;

import androidx.core.app.NotificationCompat;
import androidx.media3.exoplayer.upstream.CmcdData;
import com.microsoft.identity.common.java.providers.oauth2.IDToken;
import java.lang.ref.Reference;
import java.util.List;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import sdk.pendo.io.e2.f0;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005*\u0001\u001b\u0018\u0000 *2\u00020\u0001:\u0001\u0007B'\u0012\u0006\u0010$\u001a\u00020#\u0012\u0006\u0010\u0014\u001a\u00020\u0006\u0012\u0006\u0010%\u001a\u00020\u0004\u0012\u0006\u0010'\u001a\u00020&¢\u0006\u0004\b(\u0010)J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J.\u0010\u0007\u001a\u00020\u000f2\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\n2\u000e\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010\f2\u0006\u0010\u0010\u001a\u00020\u000fJ\u000e\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\u0007\u001a\u00020\u000f2\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0004R\u0014\u0010\u0014\u001a\u00020\u00068\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0007\u0010\u0013R\u0014\u0010\u0016\u001a\u00020\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0012\u0010\u0015R\u0014\u0010\u001a\u001a\u00020\u00178\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0018\u0010\u0019R\u0014\u0010\u001e\u001a\u00020\u001b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001c\u0010\u001dR\u001a\u0010\"\u001a\b\u0012\u0004\u0012\u00020\u00020\u001f8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b \u0010!¨\u0006+"}, d2 = {"Lsdk/pendo/io/j2/g;", "", "Lsdk/pendo/io/j2/f;", "connection", "", "now", "", CmcdData.OBJECT_TYPE_AUDIO_ONLY, "Lsdk/pendo/io/e2/a;", IDToken.ADDRESS, "Lsdk/pendo/io/j2/e;", NotificationCompat.CATEGORY_CALL, "", "Lsdk/pendo/io/e2/f0;", "routes", "", "requireMultiplexed", "", "b", "I", "maxIdleConnections", "J", "keepAliveDurationNs", "Lsdk/pendo/io/i2/d;", "c", "Lsdk/pendo/io/i2/d;", "cleanupQueue", "sdk/pendo/io/j2/g$b", "d", "Lsdk/pendo/io/j2/g$b;", "cleanupTask", "Ljava/util/concurrent/ConcurrentLinkedQueue;", "e", "Ljava/util/concurrent/ConcurrentLinkedQueue;", "connections", "Lsdk/pendo/io/i2/e;", "taskRunner", "keepAliveDuration", "Ljava/util/concurrent/TimeUnit;", "timeUnit", "<init>", "(Lokhttp3/internal/concurrent/TaskRunner;IJLjava/util/concurrent/TimeUnit;)V", "f", "okhttp"}, k = 1, mv = {1, 8, 0})
public final class g {

    /* JADX INFO: renamed from: a, reason: from kotlin metadata */
    private final int maxIdleConnections;

    /* JADX INFO: renamed from: b, reason: from kotlin metadata */
    private final long keepAliveDurationNs;

    /* JADX INFO: renamed from: c, reason: from kotlin metadata */
    private final sdk.pendo.io.i2.d cleanupQueue;

    /* JADX INFO: renamed from: d, reason: from kotlin metadata */
    private final b cleanupTask;

    /* JADX INFO: renamed from: e, reason: from kotlin metadata */
    private final ConcurrentLinkedQueue<f> connections;

    @Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016¨\u0006\u0004"}, d2 = {"sdk/pendo/io/j2/g$b", "Lsdk/pendo/io/i2/a;", "", "e", "okhttp"}, k = 1, mv = {1, 8, 0})
    public static final class b extends sdk.pendo.io.i2.a {
        b(String str) {
            super(str, false, 2, null);
        }

        @Override // sdk.pendo.io.i2.a
        public long e() {
            return g.this.a(System.nanoTime());
        }
    }

    public g(sdk.pendo.io.i2.e taskRunner, int i, long j, TimeUnit timeUnit) {
        Intrinsics.checkNotNullParameter(taskRunner, "taskRunner");
        Intrinsics.checkNotNullParameter(timeUnit, "timeUnit");
        this.maxIdleConnections = i;
        this.keepAliveDurationNs = timeUnit.toNanos(j);
        this.cleanupQueue = taskRunner.e();
        this.cleanupTask = new b(sdk.pendo.io.f2.b.i + " ConnectionPool");
        this.connections = new ConcurrentLinkedQueue<>();
        if (j <= 0) {
            throw new IllegalArgumentException(("keepAliveDuration <= 0: " + j).toString());
        }
    }

    public final boolean a(sdk.pendo.io.e2.a address, e call, List<f0> routes, boolean requireMultiplexed) {
        Intrinsics.checkNotNullParameter(address, "address");
        Intrinsics.checkNotNullParameter(call, "call");
        for (f connection : this.connections) {
            Intrinsics.checkNotNullExpressionValue(connection, "connection");
            synchronized (connection) {
                if (requireMultiplexed) {
                    if (connection.i()) {
                    }
                    Unit unit = Unit.INSTANCE;
                }
                if (connection.a(address, routes)) {
                    call.a(connection);
                    return true;
                }
                Unit unit2 = Unit.INSTANCE;
            }
        }
        return false;
    }

    public final void b(f connection) {
        Intrinsics.checkNotNullParameter(connection, "connection");
        if (sdk.pendo.io.f2.b.h && !Thread.holdsLock(connection)) {
            throw new AssertionError("Thread " + Thread.currentThread().getName() + " MUST hold lock on " + connection);
        }
        this.connections.add(connection);
        sdk.pendo.io.i2.d.a(this.cleanupQueue, this.cleanupTask, 0L, 2, null);
    }

    public final long a(long now) {
        int i = 0;
        long j = Long.MIN_VALUE;
        f fVar = null;
        int i2 = 0;
        for (f connection : this.connections) {
            Intrinsics.checkNotNullExpressionValue(connection, "connection");
            synchronized (connection) {
                if (a(connection, now) > 0) {
                    i2++;
                } else {
                    i++;
                    long idleAtNs = now - connection.getIdleAtNs();
                    if (idleAtNs > j) {
                        fVar = connection;
                        j = idleAtNs;
                    }
                    Unit unit = Unit.INSTANCE;
                }
            }
        }
        long j2 = this.keepAliveDurationNs;
        if (j < j2 && i <= this.maxIdleConnections) {
            if (i > 0) {
                return j2 - j;
            }
            if (i2 > 0) {
                return j2;
            }
            return -1L;
        }
        Intrinsics.checkNotNull(fVar);
        synchronized (fVar) {
            if (!fVar.c().isEmpty()) {
                return 0L;
            }
            if (fVar.getIdleAtNs() + j != now) {
                return 0L;
            }
            fVar.b(true);
            this.connections.remove(fVar);
            sdk.pendo.io.f2.b.a(fVar.m());
            if (this.connections.isEmpty()) {
                this.cleanupQueue.a();
            }
            return 0L;
        }
    }

    public final boolean a(f connection) {
        Intrinsics.checkNotNullParameter(connection, "connection");
        if (sdk.pendo.io.f2.b.h && !Thread.holdsLock(connection)) {
            throw new AssertionError("Thread " + Thread.currentThread().getName() + " MUST hold lock on " + connection);
        }
        if (!connection.getNoNewExchanges() && this.maxIdleConnections != 0) {
            sdk.pendo.io.i2.d.a(this.cleanupQueue, this.cleanupTask, 0L, 2, null);
            return false;
        }
        connection.b(true);
        this.connections.remove(connection);
        if (this.connections.isEmpty()) {
            this.cleanupQueue.a();
        }
        return true;
    }

    private final int a(f connection, long now) {
        if (sdk.pendo.io.f2.b.h && !Thread.holdsLock(connection)) {
            throw new AssertionError("Thread " + Thread.currentThread().getName() + " MUST hold lock on " + connection);
        }
        List<Reference<e>> listC = connection.c();
        int i = 0;
        while (i < listC.size()) {
            Reference<e> reference = listC.get(i);
            if (reference.get() != null) {
                i++;
            } else {
                Intrinsics.checkNotNull(reference, "null cannot be cast to non-null type okhttp3.internal.connection.RealCall.CallReference");
                sdk.pendo.io.n2.h.INSTANCE.d().a("A connection to " + connection.getRoute().getAddress().getUrl() + " was leaked. Did you forget to close a response body?", ((e.b) reference).getCallStackTrace());
                listC.remove(i);
                connection.b(true);
                if (listC.isEmpty()) {
                    connection.a(now - this.keepAliveDurationNs);
                    return 0;
                }
            }
        }
        return listC.size();
    }
}
