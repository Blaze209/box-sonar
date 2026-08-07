package sdk.pendo.io.j2;

import androidx.core.app.NotificationCompat;
import androidx.media3.exoplayer.upstream.CmcdData;
import com.microsoft.identity.common.java.providers.oauth2.IDToken;
import java.io.IOException;
import java.net.Socket;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import sdk.pendo.io.e2.f0;
import sdk.pendo.io.e2.r;
import sdk.pendo.io.e2.v;
import sdk.pendo.io.e2.z;
import sdk.pendo.io.m2.n;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000v\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0010\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010\u001b\u001a\u00020\u0019\u0012\u0006\u0010 \u001a\u00020\u001c\u0012\u0006\u0010#\u001a\u00020!\u0012\u0006\u0010'\u001a\u00020$¢\u0006\u0004\b9\u0010:J8\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u0007H\u0002J0\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u0007H\u0002J\n\u0010\r\u001a\u0004\u0018\u00010\fH\u0002J\u0016\u0010\u000b\u001a\u00020\u00122\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0011\u001a\u00020\u0010J\u000e\u0010\u000b\u001a\u00020\u00152\u0006\u0010\u0014\u001a\u00020\u0013J\u0006\u0010\u0016\u001a\u00020\u0007J\u000e\u0010\u000b\u001a\u00020\u00072\u0006\u0010\u0018\u001a\u00020\u0017R\u0014\u0010\u001b\u001a\u00020\u00198\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000b\u0010\u001aR\u001a\u0010 \u001a\u00020\u001c8\u0000X\u0080\u0004¢\u0006\f\n\u0004\b\u0016\u0010\u001d\u001a\u0004\b\u001e\u0010\u001fR\u0014\u0010#\u001a\u00020!8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\r\u0010\"R\u0014\u0010'\u001a\u00020$8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b%\u0010&R\u0018\u0010*\u001a\u0004\u0018\u00010(8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0014\u0010)R\u0018\u0010.\u001a\u0004\u0018\u00010+8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b,\u0010-R\u0016\u00101\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b/\u00100R\u0016\u00103\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b2\u00100R\u0016\u00105\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b4\u00100R\u0018\u00108\u001a\u0004\u0018\u00010\f8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b6\u00107¨\u0006;"}, d2 = {"Lsdk/pendo/io/j2/d;", "", "", "connectTimeout", "readTimeout", "writeTimeout", "pingIntervalMillis", "", "connectionRetryEnabled", "doExtensiveHealthChecks", "Lsdk/pendo/io/j2/f;", CmcdData.OBJECT_TYPE_AUDIO_ONLY, "Lsdk/pendo/io/e2/f0;", "c", "Lsdk/pendo/io/e2/z;", "client", "Lsdk/pendo/io/k2/g;", "chain", "Lsdk/pendo/io/k2/d;", "Ljava/io/IOException;", "e", "", "b", "Lsdk/pendo/io/e2/v;", "url", "Lsdk/pendo/io/j2/g;", "Lsdk/pendo/io/j2/g;", "connectionPool", "Lsdk/pendo/io/e2/a;", "Lsdk/pendo/io/e2/a;", "getAddress$okhttp", "()Lokhttp3/Address;", IDToken.ADDRESS, "Lsdk/pendo/io/j2/e;", "Lsdk/pendo/io/j2/e;", NotificationCompat.CATEGORY_CALL, "Lsdk/pendo/io/e2/r;", "d", "Lsdk/pendo/io/e2/r;", "eventListener", "Lsdk/pendo/io/j2/j$b;", "Lsdk/pendo/io/j2/j$b;", "routeSelection", "Lsdk/pendo/io/j2/j;", "f", "Lsdk/pendo/io/j2/j;", "routeSelector", "g", "I", "refusedStreamCount", CmcdData.STREAMING_FORMAT_HLS, "connectionShutdownCount", "i", "otherFailureCount", "j", "Lsdk/pendo/io/e2/f0;", "nextRouteToTry", "<init>", "(Lokhttp3/internal/connection/RealConnectionPool;Lokhttp3/Address;Lokhttp3/internal/connection/RealCall;Lokhttp3/EventListener;)V", "okhttp"}, k = 1, mv = {1, 8, 0})
public final class d {

    /* JADX INFO: renamed from: a, reason: from kotlin metadata */
    private final g connectionPool;

    /* JADX INFO: renamed from: b, reason: from kotlin metadata */
    private final sdk.pendo.io.e2.a address;

    /* JADX INFO: renamed from: c, reason: from kotlin metadata */
    private final e call;

    /* JADX INFO: renamed from: d, reason: from kotlin metadata */
    private final r eventListener;

    /* JADX INFO: renamed from: e, reason: from kotlin metadata */
    private j.b routeSelection;

    /* JADX INFO: renamed from: f, reason: from kotlin metadata */
    private j routeSelector;

    /* JADX INFO: renamed from: g, reason: from kotlin metadata */
    private int refusedStreamCount;

    /* JADX INFO: renamed from: h, reason: from kotlin metadata */
    private int connectionShutdownCount;

    /* JADX INFO: renamed from: i, reason: from kotlin metadata */
    private int otherFailureCount;

    /* JADX INFO: renamed from: j, reason: from kotlin metadata */
    private f0 nextRouteToTry;

    public d(g connectionPool, sdk.pendo.io.e2.a address, e call, r eventListener) {
        Intrinsics.checkNotNullParameter(connectionPool, "connectionPool");
        Intrinsics.checkNotNullParameter(address, "address");
        Intrinsics.checkNotNullParameter(call, "call");
        Intrinsics.checkNotNullParameter(eventListener, "eventListener");
        this.connectionPool = connectionPool;
        this.address = address;
        this.call = call;
        this.eventListener = eventListener;
    }

    private final f0 c() {
        f connection;
        if (this.refusedStreamCount > 1 || this.connectionShutdownCount > 1 || this.otherFailureCount > 0 || (connection = this.call.getConnection()) == null) {
            return null;
        }
        synchronized (connection) {
            if (connection.getRouteFailureCount() != 0) {
                return null;
            }
            if (sdk.pendo.io.f2.b.a(connection.getRoute().getAddress().getUrl(), this.address.getUrl())) {
                return connection.getRoute();
            }
            return null;
        }
    }

    public final sdk.pendo.io.k2.d a(z client, sdk.pendo.io.k2.g chain) {
        d dVar;
        Intrinsics.checkNotNullParameter(client, "client");
        Intrinsics.checkNotNullParameter(chain, "chain");
        try {
            dVar = this;
            try {
                return dVar.a(chain.getConnectTimeoutMillis(), chain.getReadTimeoutMillis(), chain.getWriteTimeoutMillis(), client.getPingIntervalMillis(), client.getRetryOnConnectionFailure(), !Intrinsics.areEqual(chain.getRequest().getCom.google.firebase.analytics.FirebaseAnalytics.Param.METHOD java.lang.String(), "GET")).a(client, chain);
            } catch (IOException e) {
                e = e;
                IOException iOException = e;
                dVar.a(iOException);
                throw new i(iOException);
            } catch (i e2) {
                e = e2;
                i iVar = e;
                dVar.a(iVar.getLastConnectException());
                throw iVar;
            }
        } catch (IOException e3) {
            e = e3;
            dVar = this;
        } catch (i e4) {
            e = e4;
            dVar = this;
        }
    }

    public final boolean b() {
        j jVar;
        if (this.refusedStreamCount == 0 && this.connectionShutdownCount == 0 && this.otherFailureCount == 0) {
            return false;
        }
        if (this.nextRouteToTry != null) {
            return true;
        }
        f0 f0VarC = c();
        if (f0VarC != null) {
            this.nextRouteToTry = f0VarC;
            return true;
        }
        j.b bVar = this.routeSelection;
        if ((bVar == null || !bVar.b()) && (jVar = this.routeSelector) != null) {
            return jVar.a();
        }
        return true;
    }

    /* JADX WARN: Code duplicated, block: B:31:0x0071  */
    /* JADX WARN: Code duplicated, block: B:56:0x011f  */
    /* JADX WARN: Code duplicated, block: B:57:0x0133  */
    /* JADX WARN: Code duplicated, block: B:73:0x0134 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    private final f a(int connectTimeout, int readTimeout, int writeTimeout, int pingIntervalMillis, boolean connectionRetryEnabled) throws IOException {
        List<f0> listA;
        f fVar;
        f connection;
        Socket socketK;
        if (this.call.getCanceled()) {
            throw new IOException("Canceled");
        }
        f connection2 = this.call.getConnection();
        if (connection2 != null) {
            synchronized (connection2) {
                socketK = (connection2.getNoNewExchanges() || !a(connection2.getRoute().getAddress().getUrl())) ? this.call.k() : null;
                Unit unit = Unit.INSTANCE;
            }
            if (this.call.getConnection() != null) {
                if (socketK == null) {
                    return connection2;
                }
                throw new IllegalStateException("Check failed.".toString());
            }
            if (socketK != null) {
                sdk.pendo.io.f2.b.a(socketK);
            }
            this.eventListener.b(this.call, connection2);
        }
        this.refusedStreamCount = 0;
        this.connectionShutdownCount = 0;
        this.otherFailureCount = 0;
        if (this.connectionPool.a(this.address, this.call, null, false)) {
            connection = this.call.getConnection();
            Intrinsics.checkNotNull(connection);
        } else {
            f0 f0VarC = this.nextRouteToTry;
            try {
                if (f0VarC != null) {
                    Intrinsics.checkNotNull(f0VarC);
                    this.nextRouteToTry = null;
                } else {
                    j.b bVar = this.routeSelection;
                    if (bVar != null) {
                        Intrinsics.checkNotNull(bVar);
                        if (bVar.b()) {
                            j.b bVar2 = this.routeSelection;
                            Intrinsics.checkNotNull(bVar2);
                            f0VarC = bVar2.c();
                        }
                        fVar = new f(this.connectionPool, f0VarC);
                        this.call.b(fVar);
                        fVar.a(connectTimeout, readTimeout, writeTimeout, pingIntervalMillis, connectionRetryEnabled, this.call, this.eventListener);
                        this.call.b((f) null);
                        this.call.getClient().getRouteDatabase().a(fVar.getRoute());
                        if (!this.connectionPool.a(this.address, this.call, listA, true)) {
                            synchronized (fVar) {
                                this.connectionPool.b(fVar);
                                this.call.a(fVar);
                                Unit unit2 = Unit.INSTANCE;
                            }
                            this.eventListener.a(this.call, fVar);
                            return fVar;
                        }
                        connection = this.call.getConnection();
                        Intrinsics.checkNotNull(connection);
                        this.nextRouteToTry = f0VarC;
                        sdk.pendo.io.f2.b.a(fVar.m());
                    }
                    j jVar = this.routeSelector;
                    if (jVar == null) {
                        jVar = new j(this.address, this.call.getClient().getRouteDatabase(), this.call, this.eventListener);
                        this.routeSelector = jVar;
                    }
                    j.b bVarC = jVar.c();
                    this.routeSelection = bVarC;
                    listA = bVarC.a();
                    if (this.call.getCanceled()) {
                        throw new IOException("Canceled");
                    }
                    if (this.connectionPool.a(this.address, this.call, listA, false)) {
                        connection = this.call.getConnection();
                        Intrinsics.checkNotNull(connection);
                    } else {
                        f0VarC = bVarC.c();
                        fVar = new f(this.connectionPool, f0VarC);
                        this.call.b(fVar);
                        fVar.a(connectTimeout, readTimeout, writeTimeout, pingIntervalMillis, connectionRetryEnabled, this.call, this.eventListener);
                        this.call.b((f) null);
                        this.call.getClient().getRouteDatabase().a(fVar.getRoute());
                        if (!this.connectionPool.a(this.address, this.call, listA, true)) {
                            synchronized (fVar) {
                                this.connectionPool.b(fVar);
                                this.call.a(fVar);
                                Unit unit3 = Unit.INSTANCE;
                                this.eventListener.a(this.call, fVar);
                                return fVar;
                            }
                        }
                        connection = this.call.getConnection();
                        Intrinsics.checkNotNull(connection);
                        this.nextRouteToTry = f0VarC;
                        sdk.pendo.io.f2.b.a(fVar.m());
                    }
                }
                fVar.a(connectTimeout, readTimeout, writeTimeout, pingIntervalMillis, connectionRetryEnabled, this.call, this.eventListener);
                this.call.b((f) null);
                this.call.getClient().getRouteDatabase().a(fVar.getRoute());
                if (!this.connectionPool.a(this.address, this.call, listA, true)) {
                    synchronized (fVar) {
                        this.connectionPool.b(fVar);
                        this.call.a(fVar);
                        Unit unit4 = Unit.INSTANCE;
                        this.eventListener.a(this.call, fVar);
                        return fVar;
                    }
                }
                connection = this.call.getConnection();
                Intrinsics.checkNotNull(connection);
                this.nextRouteToTry = f0VarC;
                sdk.pendo.io.f2.b.a(fVar.m());
            } catch (Throwable th) {
                this.call.b((f) null);
                throw th;
            }
            listA = null;
            fVar = new f(this.connectionPool, f0VarC);
            this.call.b(fVar);
        }
        this.eventListener.a(this.call, connection);
        return connection;
    }

    private final f a(int connectTimeout, int readTimeout, int writeTimeout, int pingIntervalMillis, boolean connectionRetryEnabled, boolean doExtensiveHealthChecks) throws IOException {
        while (true) {
            f fVarA = a(connectTimeout, readTimeout, writeTimeout, pingIntervalMillis, connectionRetryEnabled);
            if (fVarA.a(doExtensiveHealthChecks)) {
                return fVarA;
            }
            fVarA.k();
            if (this.nextRouteToTry == null) {
                j.b bVar = this.routeSelection;
                if (bVar != null ? bVar.b() : true) {
                    continue;
                } else {
                    j jVar = this.routeSelector;
                    if (!(jVar != null ? jVar.a() : true)) {
                        throw new IOException("exhausted all routes");
                    }
                }
            }
        }
    }

    /* JADX INFO: renamed from: a, reason: from getter */
    public final sdk.pendo.io.e2.a getAddress() {
        return this.address;
    }

    public final boolean a(v url) {
        Intrinsics.checkNotNullParameter(url, "url");
        v url2 = this.address.getUrl();
        return url.getPort() == url2.getPort() && Intrinsics.areEqual(url.getHost(), url2.getHost());
    }

    public final void a(IOException e) {
        Intrinsics.checkNotNullParameter(e, "e");
        this.nextRouteToTry = null;
        if ((e instanceof n) && ((n) e).errorCode == sdk.pendo.io.m2.b.REFUSED_STREAM) {
            this.refusedStreamCount++;
        } else if (e instanceof sdk.pendo.io.m2.a) {
            this.connectionShutdownCount++;
        } else {
            this.otherFailureCount++;
        }
    }
}
