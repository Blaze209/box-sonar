package sdk.pendo.io.j2;

import androidx.core.app.NotificationCompat;
import androidx.media3.exoplayer.upstream.CmcdData;
import com.box.android.domain.analytics.BoxAnalyticsParams;
import com.google.api.client.http.HttpMethods;
import com.microsoft.identity.common.java.providers.oauth2.IDToken;
import java.io.IOException;
import java.lang.ref.Reference;
import java.net.ConnectException;
import java.net.ProtocolException;
import java.net.Proxy;
import java.net.Socket;
import java.net.SocketException;
import java.net.UnknownServiceException;
import java.security.cert.Certificate;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.TimeUnit;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLPeerUnverifiedException;
import javax.net.ssl.SSLSession;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.text.StringsKt;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;
import okhttp3.internal.Util;
import okhttp3.internal.connection.RealConnection;
import org.apache.hc.core5.http.HeaderElements;
import org.apache.hc.core5.http.HttpHeaders;
import sdk.pendo.io.e2.a0;
import sdk.pendo.io.e2.b0;
import sdk.pendo.io.e2.c0;
import sdk.pendo.io.e2.d0;
import sdk.pendo.io.e2.f0;
import sdk.pendo.io.e2.l;
import sdk.pendo.io.e2.r;
import sdk.pendo.io.e2.t;
import sdk.pendo.io.e2.v;
import sdk.pendo.io.e2.z;
import sdk.pendo.io.m2.m;
import sdk.pendo.io.s2.o;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000Þ\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0013\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\n\u0018\u0000 |2\u00020\u00012\u00020\u0002:\u0001\fB\u0017\u0012\u0006\u0010I\u001a\u00020D\u0012\u0006\u0010L\u001a\u00020\u0016¢\u0006\u0004\bz\u0010{J0\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\tH\u0002J(\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\tH\u0002J(\u0010\f\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u000f\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\tH\u0002J\u0010\u0010\f\u001a\u00020\u000b2\u0006\u0010\u000f\u001a\u00020\u0003H\u0002J\u0010\u0010\f\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\rH\u0002J*\u0010\f\u001a\u0004\u0018\u00010\u00102\u0006\u0010\u0005\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0013\u001a\u00020\u0012H\u0002J\b\u0010\u0014\u001a\u00020\u0010H\u0002J\u0016\u0010\f\u001a\u00020\u00182\f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00160\u0015H\u0002J\u0010\u0010\f\u001a\u00020\u00182\u0006\u0010\u0013\u001a\u00020\u0012H\u0002J\u0018\u0010\f\u001a\u00020\u00182\u0006\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u001a\u001a\u00020\u0019H\u0002J\u000f\u0010\u001b\u001a\u00020\u000bH\u0000¢\u0006\u0004\b\u001b\u0010\u001cJ\u000f\u0010\u001d\u001a\u00020\u000bH\u0000¢\u0006\u0004\b\u001d\u0010\u001cJ\u000f\u0010\u001e\u001a\u00020\u000bH\u0000¢\u0006\u0004\b\u001e\u0010\u001cJ>\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u000f\u001a\u00020\u00032\u0006\u0010\u001f\u001a\u00020\u00182\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\tJ'\u0010\f\u001a\u00020\u00182\u0006\u0010!\u001a\u00020 2\u000e\u0010\"\u001a\n\u0012\u0004\u0012\u00020\u0016\u0018\u00010\u0015H\u0000¢\u0006\u0004\b\f\u0010#J\u001f\u0010\f\u001a\u00020(2\u0006\u0010%\u001a\u00020$2\u0006\u0010'\u001a\u00020&H\u0000¢\u0006\u0004\b\f\u0010)J\u0017\u0010\f\u001a\u00020,2\u0006\u0010+\u001a\u00020*H\u0000¢\u0006\u0004\b\f\u0010-J\b\u0010.\u001a\u00020\u0016H\u0016J\u0006\u0010\f\u001a\u00020\u000bJ\b\u00100\u001a\u00020/H\u0016J\u000e\u0010\f\u001a\u00020\u00182\u0006\u00101\u001a\u00020\u0018J\u0010\u0010\f\u001a\u00020\u000b2\u0006\u00103\u001a\u000202H\u0016J\u0018\u0010\f\u001a\u00020\u000b2\u0006\u00105\u001a\u0002042\u0006\u00107\u001a\u000206H\u0016J\n\u00108\u001a\u0004\u0018\u00010\u0019H\u0016J'\u0010\f\u001a\u00020\u000b2\u0006\u0010%\u001a\u00020$2\u0006\u00109\u001a\u00020\u00162\u0006\u0010;\u001a\u00020:H\u0000¢\u0006\u0004\b\f\u0010<J!\u0010\f\u001a\u00020\u000b2\u0006\u0010\b\u001a\u00020=2\b\u0010>\u001a\u0004\u0018\u00010:H\u0000¢\u0006\u0004\b\f\u0010?J\b\u0010A\u001a\u00020@H\u0016J\b\u0010C\u001a\u00020BH\u0016R\u0017\u0010I\u001a\u00020D8\u0006¢\u0006\f\n\u0004\bE\u0010F\u001a\u0004\bG\u0010HR\u0014\u0010L\u001a\u00020\u00168\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bJ\u0010KR\u0018\u0010N\u001a\u0004\u0018\u00010/8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b>\u0010MR\u0018\u0010P\u001a\u0004\u0018\u00010/8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bO\u0010MR\u0018\u0010\u001a\u001a\u0004\u0018\u00010\u00198\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b8\u0010QR\u0018\u0010A\u001a\u0004\u0018\u00010@8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001e\u0010RR\u0018\u0010U\u001a\u0004\u0018\u0001048\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bS\u0010TR\u0018\u0010X\u001a\u0004\u0018\u00010V8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001d\u0010WR\u0018\u0010[\u001a\u0004\u0018\u00010Y8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001b\u0010ZR\"\u0010_\u001a\u00020\u00188\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b.\u0010\\\u001a\u0004\b>\u0010]\"\u0004\b\u0014\u0010^R\u0016\u0010`\u001a\u00020\u00188\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b0\u0010\\R\"\u0010f\u001a\u00020\u00038\u0000@\u0000X\u0080\u000e¢\u0006\u0012\n\u0004\ba\u0010b\u001a\u0004\bO\u0010c\"\u0004\bd\u0010eR\u0016\u0010h\u001a\u00020\u00038\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bg\u0010bR\u0016\u0010j\u001a\u00020\u00038\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bi\u0010bR\u0016\u0010l\u001a\u00020\u00038\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bk\u0010bR#\u0010r\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020=0n0m8\u0006¢\u0006\f\n\u0004\bo\u0010p\u001a\u0004\bE\u0010qR\"\u0010x\u001a\u00020s8\u0000@\u0000X\u0080\u000e¢\u0006\u0012\n\u0004\bt\u0010u\u001a\u0004\bJ\u0010v\"\u0004\b\f\u0010wR\u0014\u0010y\u001a\u00020\u00188@X\u0080\u0004¢\u0006\u0006\u001a\u0004\bS\u0010]¨\u0006}"}, d2 = {"Lsdk/pendo/io/j2/f;", "Lsdk/pendo/io/m2/f$c;", "Lsdk/pendo/io/e2/j;", "", "connectTimeout", "readTimeout", "writeTimeout", "Lsdk/pendo/io/e2/e;", NotificationCompat.CATEGORY_CALL, "Lsdk/pendo/io/e2/r;", "eventListener", "", CmcdData.OBJECT_TYPE_AUDIO_ONLY, "Lsdk/pendo/io/j2/b;", "connectionSpecSelector", "pingIntervalMillis", "Lsdk/pendo/io/e2/b0;", "tunnelRequest", "Lsdk/pendo/io/e2/v;", "url", "b", "", "Lsdk/pendo/io/e2/f0;", "candidates", "", "Lsdk/pendo/io/e2/t;", "handshake", "k", "()V", "j", CmcdData.STREAMING_FORMAT_HLS, "connectionRetryEnabled", "Lsdk/pendo/io/e2/a;", IDToken.ADDRESS, "routes", "(Lsdk/pendo/io/e2/a;Ljava/util/List;)Z", "Lsdk/pendo/io/e2/z;", "client", "Lsdk/pendo/io/k2/g;", "chain", "Lsdk/pendo/io/k2/d;", "(Lsdk/pendo/io/e2/z;Lsdk/pendo/io/k2/g;)Lsdk/pendo/io/k2/d;", "Lsdk/pendo/io/j2/c;", "exchange", "Lsdk/pendo/io/r2/d$d;", "(Lsdk/pendo/io/j2/c;)Lsdk/pendo/io/r2/d$d;", CmcdData.STREAM_TYPE_LIVE, "Ljava/net/Socket;", CmcdData.OBJECT_TYPE_MANIFEST, "doExtensiveChecks", "Lsdk/pendo/io/m2/i;", "stream", "Lsdk/pendo/io/m2/f;", "connection", "Lsdk/pendo/io/m2/m;", BoxAnalyticsParams.CATEGORY_SETTINGS, "g", "failedRoute", "Ljava/io/IOException;", "failure", "(Lsdk/pendo/io/e2/z;Lsdk/pendo/io/e2/f0;Ljava/io/IOException;)V", "Lsdk/pendo/io/j2/e;", "e", "(Lsdk/pendo/io/j2/e;Ljava/io/IOException;)V", "Lsdk/pendo/io/e2/a0;", "protocol", "", "toString", "Lsdk/pendo/io/j2/g;", "c", "Lsdk/pendo/io/j2/g;", "getConnectionPool", "()Lokhttp3/internal/connection/RealConnectionPool;", "connectionPool", "d", "Lsdk/pendo/io/e2/f0;", "route", "Ljava/net/Socket;", "rawSocket", "f", "socket", "Lsdk/pendo/io/e2/t;", "Lsdk/pendo/io/e2/a0;", "i", "Lsdk/pendo/io/m2/f;", "http2Connection", "Lsdk/pendo/io/s2/f;", "Lsdk/pendo/io/s2/f;", "source", "Lsdk/pendo/io/s2/e;", "Lsdk/pendo/io/s2/e;", "sink", "Z", "()Z", "(Z)V", "noNewExchanges", "noCoalescedConnections", "n", "I", "()I", "setRouteFailureCount$okhttp", "(I)V", "routeFailureCount", "o", "successCount", "p", "refusedStreamCount", "q", "allocationLimit", "", "Ljava/lang/ref/Reference;", "r", "Ljava/util/List;", "()Ljava/util/List;", "calls", "", "s", "J", "()J", "(J)V", "idleAtNs", "isMultiplexed", "<init>", "(Lokhttp3/internal/connection/RealConnectionPool;Lokhttp3/Route;)V", "t", "okhttp"}, k = 1, mv = {1, 8, 0})
public final class f extends sdk.pendo.io.m2.f.c implements sdk.pendo.io.e2.j {

    /* JADX INFO: renamed from: c, reason: from kotlin metadata */
    private final g connectionPool;

    /* JADX INFO: renamed from: d, reason: from kotlin metadata */
    private final f0 route;

    /* JADX INFO: renamed from: e, reason: from kotlin metadata */
    private Socket rawSocket;

    /* JADX INFO: renamed from: f, reason: from kotlin metadata */
    private Socket socket;

    /* JADX INFO: renamed from: g, reason: from kotlin metadata */
    private t handshake;

    /* JADX INFO: renamed from: h, reason: from kotlin metadata */
    private a0 protocol;

    /* JADX INFO: renamed from: i, reason: from kotlin metadata */
    private sdk.pendo.io.m2.f http2Connection;

    /* JADX INFO: renamed from: j, reason: from kotlin metadata */
    private sdk.pendo.io.s2.f source;

    /* JADX INFO: renamed from: k, reason: from kotlin metadata */
    private sdk.pendo.io.s2.e sink;

    /* JADX INFO: renamed from: l, reason: from kotlin metadata */
    private boolean noNewExchanges;

    /* JADX INFO: renamed from: m, reason: from kotlin metadata */
    private boolean noCoalescedConnections;

    /* JADX INFO: renamed from: n, reason: from kotlin metadata */
    private int routeFailureCount;

    /* JADX INFO: renamed from: o, reason: from kotlin metadata */
    private int successCount;

    /* JADX INFO: renamed from: p, reason: from kotlin metadata */
    private int refusedStreamCount;

    /* JADX INFO: renamed from: q, reason: from kotlin metadata */
    private int allocationLimit;

    /* JADX INFO: renamed from: r, reason: from kotlin metadata */
    private final List<Reference<sdk.pendo.io.j2.e>> calls;

    /* JADX INFO: renamed from: s, reason: from kotlin metadata */
    private long idleAtNs;

    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    public /* synthetic */ class b {
        public static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[Proxy.Type.values().length];
            try {
                iArr[Proxy.Type.DIRECT.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[Proxy.Type.HTTP.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            a = iArr;
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00010\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"", "Ljava/security/cert/Certificate;", CmcdData.OBJECT_TYPE_AUDIO_ONLY, "()Ljava/util/List;"}, k = 3, mv = {1, 8, 0})
    static final class c extends Lambda implements Function0<List<? extends Certificate>> {
        final /* synthetic */ sdk.pendo.io.e2.g a;
        final /* synthetic */ t b;
        final /* synthetic */ sdk.pendo.io.e2.a c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        c(sdk.pendo.io.e2.g gVar, t tVar, sdk.pendo.io.e2.a aVar) {
            super(0);
            this.a = gVar;
            this.b = tVar;
            this.c = aVar;
        }

        @Override // kotlin.jvm.functions.Function0
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final List<Certificate> invoke() {
            sdk.pendo.io.q2.c cVarA = this.a.getCertificateChainCleaner();
            Intrinsics.checkNotNull(cVarA);
            return cVarA.a(this.b.c(), this.c.getUrl().getHost());
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00010\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"", "Ljava/security/cert/X509Certificate;", CmcdData.OBJECT_TYPE_AUDIO_ONLY, "()Ljava/util/List;"}, k = 3, mv = {1, 8, 0})
    static final class d extends Lambda implements Function0<List<? extends X509Certificate>> {
        d() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final List<X509Certificate> invoke() {
            t tVar = f.this.handshake;
            Intrinsics.checkNotNull(tVar);
            List<Certificate> listC = tVar.c();
            ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(listC, 10));
            for (Certificate certificate : listC) {
                Intrinsics.checkNotNull(certificate, "null cannot be cast to non-null type java.security.cert.X509Certificate");
                arrayList.add((X509Certificate) certificate);
            }
            return arrayList;
        }
    }

    @Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016¨\u0006\u0004"}, d2 = {"sdk/pendo/io/j2/f$e", "Lsdk/pendo/io/r2/d$d;", "", HeaderElements.CLOSE, "okhttp"}, k = 1, mv = {1, 8, 0})
    public static final class e extends sdk.pendo.io.r2.d.AbstractC0471d {
        final /* synthetic */ sdk.pendo.io.j2.c d;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        e(sdk.pendo.io.s2.f fVar, sdk.pendo.io.s2.e eVar, sdk.pendo.io.j2.c cVar) {
            super(true, fVar, eVar);
            this.d = cVar;
        }

        @Override // java.io.Closeable, java.lang.AutoCloseable
        public void close() {
            this.d.a(-1L, true, true, null);
        }
    }

    public f(g connectionPool, f0 route) {
        Intrinsics.checkNotNullParameter(connectionPool, "connectionPool");
        Intrinsics.checkNotNullParameter(route, "route");
        this.connectionPool = connectionPool;
        this.route = route;
        this.allocationLimit = 1;
        this.calls = new ArrayList();
        this.idleAtNs = Long.MAX_VALUE;
    }

    private final b0 b() {
        b0 b0VarA = new b0.a().a(this.route.getAddress().getUrl()).a(HttpMethods.CONNECT, (c0) null).b("Host", sdk.pendo.io.f2.b.a(this.route.getAddress().getUrl(), true)).b(HttpHeaders.PROXY_CONNECTION, "Keep-Alive").b("User-Agent", Util.userAgent).a();
        b0 b0VarA2 = this.route.getAddress().getProxyAuthenticator().a(this.route, new d0.a().a(b0VarA).a(a0.HTTP_1_1).a(407).a("Preemptive Authenticate").a(sdk.pendo.io.f2.b.c).b(-1L).a(-1L).b("Proxy-Authenticate", "OkHttp-Preemptive").a());
        return b0VarA2 == null ? b0VarA : b0VarA2;
    }

    public final List<Reference<sdk.pendo.io.j2.e>> c() {
        return this.calls;
    }

    /* JADX INFO: renamed from: d, reason: from getter */
    public final long getIdleAtNs() {
        return this.idleAtNs;
    }

    /* JADX INFO: renamed from: e, reason: from getter */
    public final boolean getNoNewExchanges() {
        return this.noNewExchanges;
    }

    /* JADX INFO: renamed from: f, reason: from getter */
    public final int getRouteFailureCount() {
        return this.routeFailureCount;
    }

    /* JADX INFO: renamed from: g, reason: from getter */
    public t getHandshake() {
        return this.handshake;
    }

    public final synchronized void h() {
        this.successCount++;
    }

    public final boolean i() {
        return this.http2Connection != null;
    }

    public final synchronized void j() {
        this.noCoalescedConnections = true;
    }

    public final synchronized void k() {
        this.noNewExchanges = true;
    }

    /* JADX INFO: renamed from: l, reason: from getter */
    public f0 getRoute() {
        return this.route;
    }

    public Socket m() {
        Socket socket = this.socket;
        Intrinsics.checkNotNull(socket);
        return socket;
    }

    @Override // sdk.pendo.io.e2.j
    public a0 protocol() {
        a0 a0Var = this.protocol;
        Intrinsics.checkNotNull(a0Var);
        return a0Var;
    }

    public String toString() {
        Object cipherSuite;
        StringBuilder sbAppend = new StringBuilder("Connection{").append(this.route.getAddress().getUrl().getHost()).append(AbstractJsonLexerKt.COLON).append(this.route.getAddress().getUrl().getPort()).append(", proxy=").append(this.route.getProxy()).append(" hostAddress=").append(this.route.getSocketAddress()).append(" cipherSuite=");
        t tVar = this.handshake;
        if (tVar == null || (cipherSuite = tVar.getCipherSuite()) == null) {
            cipherSuite = "none";
        }
        return sbAppend.append(cipherSuite).append(" protocol=").append(this.protocol).append(AbstractJsonLexerKt.END_OBJ).toString();
    }

    public final void a() {
        Socket socket = this.rawSocket;
        if (socket != null) {
            sdk.pendo.io.f2.b.a(socket);
        }
    }

    public final void b(boolean z) {
        this.noNewExchanges = z;
    }

    private final boolean a(v url, t handshake) {
        List<Certificate> listC = handshake.c();
        if (!listC.isEmpty()) {
            sdk.pendo.io.q2.d dVar = sdk.pendo.io.q2.d.a;
            String host = url.getHost();
            Certificate certificate = listC.get(0);
            Intrinsics.checkNotNull(certificate, "null cannot be cast to non-null type java.security.cert.X509Certificate");
            if (dVar.a(host, (X509Certificate) certificate)) {
                return true;
            }
        }
        return false;
    }

    /* JADX WARN: Code duplicated, block: B:49:0x00f7  */
    /* JADX WARN: Code duplicated, block: B:52:0x00fe  */
    /* JADX WARN: Code duplicated, block: B:55:0x0124  */
    /* JADX WARN: Code duplicated, block: B:56:0x012a  */
    /* JADX WARN: Code duplicated, block: B:58:0x012f  */
    /* JADX WARN: Code duplicated, block: B:60:0x0135 A[LOOP:0: B:70:0x0091->B:60:0x0135, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:76:0x013b A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:77:0x013b A[SYNTHETIC] */
    public final void a(int connectTimeout, int readTimeout, int writeTimeout, int pingIntervalMillis, boolean connectionRetryEnabled, sdk.pendo.io.e2.e call, r eventListener) throws Throwable {
        IOException iOException;
        Socket socket;
        Socket socket2;
        sdk.pendo.io.e2.e call2 = call;
        r eventListener2 = eventListener;
        Intrinsics.checkNotNullParameter(call2, "call");
        Intrinsics.checkNotNullParameter(eventListener2, "eventListener");
        if (this.protocol != null) {
            throw new IllegalStateException("already connected".toString());
        }
        List<l> listB = this.route.getAddress().b();
        sdk.pendo.io.j2.b bVar = new sdk.pendo.io.j2.b(listB);
        if (this.route.getAddress().getSslSocketFactory() == null) {
            if (!listB.contains(l.k)) {
                throw new i(new UnknownServiceException("CLEARTEXT communication not enabled for client"));
            }
            String host = this.route.getAddress().getUrl().getHost();
            if (!sdk.pendo.io.n2.h.INSTANCE.d().b(host)) {
                throw new i(new UnknownServiceException("CLEARTEXT communication to " + host + " not permitted by network security policy"));
            }
        } else if (this.route.getAddress().e().contains(a0.H2_PRIOR_KNOWLEDGE)) {
            throw new i(new UnknownServiceException("H2_PRIOR_KNOWLEDGE cannot be used with HTTPS"));
        }
        i iVar = null;
        while (true) {
            try {
                if (this.route.c()) {
                    r rVar = eventListener2;
                    sdk.pendo.io.e2.e eVar = call2;
                    try {
                        a(connectTimeout, readTimeout, writeTimeout, eVar, rVar);
                        call2 = eVar;
                        eventListener2 = rVar;
                        try {
                            if (this.rawSocket != null) {
                                break;
                            } else {
                                break;
                            }
                        } catch (IOException e2) {
                            e = e2;
                            iOException = e;
                            socket = this.socket;
                            if (socket != null) {
                                sdk.pendo.io.f2.b.a(socket);
                            }
                            socket2 = this.rawSocket;
                            if (socket2 != null) {
                                sdk.pendo.io.f2.b.a(socket2);
                            }
                            this.socket = null;
                            this.rawSocket = null;
                            this.source = null;
                            this.sink = null;
                            this.handshake = null;
                            this.protocol = null;
                            this.http2Connection = null;
                            this.allocationLimit = 1;
                            eventListener2.a(call2, this.route.getSocketAddress(), this.route.getProxy(), null, iOException);
                            if (iVar == null) {
                                iVar = new i(iOException);
                            } else {
                                iVar.a(iOException);
                            }
                            if (connectionRetryEnabled) {
                                throw iVar;
                            }
                            if (bVar.a(iOException)) {
                                throw iVar;
                            }
                            call2 = call;
                            eventListener2 = eventListener;
                        }
                    } catch (IOException e3) {
                        e = e3;
                        call2 = eVar;
                        eventListener2 = rVar;
                    }
                } else {
                    a(connectTimeout, readTimeout, call2, eventListener2);
                }
                try {
                    a(bVar, pingIntervalMillis, call2, eventListener2);
                    eventListener2.a(call2, this.route.getSocketAddress(), this.route.getProxy(), this.protocol);
                    break;
                } catch (IOException e4) {
                    e = e4;
                    iOException = e;
                    socket = this.socket;
                    if (socket != null) {
                        sdk.pendo.io.f2.b.a(socket);
                    }
                    socket2 = this.rawSocket;
                    if (socket2 != null) {
                        sdk.pendo.io.f2.b.a(socket2);
                    }
                    this.socket = null;
                    this.rawSocket = null;
                    this.source = null;
                    this.sink = null;
                    this.handshake = null;
                    this.protocol = null;
                    this.http2Connection = null;
                    this.allocationLimit = 1;
                    eventListener2.a(call2, this.route.getSocketAddress(), this.route.getProxy(), null, iOException);
                    if (iVar == null) {
                        iVar = new i(iOException);
                    } else {
                        iVar.a(iOException);
                    }
                    if (connectionRetryEnabled) {
                        throw iVar;
                    }
                    if (bVar.a(iOException)) {
                        throw iVar;
                    }
                    call2 = call;
                    eventListener2 = eventListener;
                }
            } catch (IOException e5) {
                e = e5;
            }
            call2 = call;
            eventListener2 = eventListener;
        }
        if (this.route.c() && this.rawSocket == null) {
            throw new i(new ProtocolException("Too many tunnel connections attempted: 21"));
        }
        this.idleAtNs = System.nanoTime();
    }

    public final void a(z client, f0 failedRoute, IOException failure) {
        Intrinsics.checkNotNullParameter(client, "client");
        Intrinsics.checkNotNullParameter(failedRoute, "failedRoute");
        Intrinsics.checkNotNullParameter(failure, "failure");
        if (failedRoute.getProxy().type() != Proxy.Type.DIRECT) {
            sdk.pendo.io.e2.a address = failedRoute.getAddress();
            address.getProxySelector().connectFailed(address.getUrl().p(), failedRoute.getProxy().address(), failure);
        }
        client.getRouteDatabase().b(failedRoute);
    }

    private final void a(int connectTimeout, int readTimeout, sdk.pendo.io.e2.e call, r eventListener) throws IOException {
        Socket socketCreateSocket;
        Proxy proxy = this.route.getProxy();
        sdk.pendo.io.e2.a address = this.route.getAddress();
        Proxy.Type type = proxy.type();
        int i = type == null ? -1 : b.a[type.ordinal()];
        if (i == 1 || i == 2) {
            socketCreateSocket = address.getSocketFactory().createSocket();
            Intrinsics.checkNotNull(socketCreateSocket);
        } else {
            socketCreateSocket = new Socket(proxy);
        }
        this.rawSocket = socketCreateSocket;
        eventListener.a(call, this.route.getSocketAddress(), proxy);
        socketCreateSocket.setSoTimeout(readTimeout);
        try {
            sdk.pendo.io.n2.h.INSTANCE.d().a(socketCreateSocket, this.route.getSocketAddress(), connectTimeout);
            try {
                this.source = o.a(o.b(socketCreateSocket));
                this.sink = o.a(o.a(socketCreateSocket));
            } catch (NullPointerException e2) {
                if (Intrinsics.areEqual(e2.getMessage(), "throw with null exception")) {
                    throw new IOException(e2);
                }
            }
        } catch (ConnectException e3) {
            ConnectException connectException = new ConnectException("Failed to connect to " + this.route.getSocketAddress());
            connectException.initCause(e3);
            throw connectException;
        }
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
    private final void a(sdk.pendo.io.j2.b connectionSpecSelector) throws Throwable {
        sdk.pendo.io.e2.a address = this.route.getAddress();
        SSLSocketFactory sslSocketFactory = address.getSslSocketFactory();
        SSLSocket sSLSocket = null;
        try {
            Intrinsics.checkNotNull(sslSocketFactory);
            Socket socketCreateSocket = sslSocketFactory.createSocket(this.rawSocket, address.getUrl().getHost(), address.getUrl().getPort(), true);
            Intrinsics.checkNotNull(socketCreateSocket, "null cannot be cast to non-null type javax.net.ssl.SSLSocket");
            SSLSocket sSLSocket2 = (SSLSocket) socketCreateSocket;
            try {
                l lVarA = connectionSpecSelector.a(sSLSocket2);
                if (lVarA.getSupportsTlsExtensions()) {
                    sdk.pendo.io.n2.h.INSTANCE.d().a(sSLSocket2, address.getUrl().getHost(), address.e());
                }
                sSLSocket2.startHandshake();
                SSLSession sslSocketSession = sSLSocket2.getSession();
                t.Companion companion = t.INSTANCE;
                Intrinsics.checkNotNullExpressionValue(sslSocketSession, "sslSocketSession");
                t tVarA = companion.a(sslSocketSession);
                HostnameVerifier hostnameVerifier = address.getHostnameVerifier();
                Intrinsics.checkNotNull(hostnameVerifier);
                if (!hostnameVerifier.verify(address.getUrl().getHost(), sslSocketSession)) {
                    List<Certificate> listC = tVarA.c();
                    if (listC.isEmpty()) {
                        throw new SSLPeerUnverifiedException("Hostname " + address.getUrl().getHost() + " not verified (no certificates)");
                    }
                    Certificate certificate = listC.get(0);
                    Intrinsics.checkNotNull(certificate, "null cannot be cast to non-null type java.security.cert.X509Certificate");
                    X509Certificate x509Certificate = (X509Certificate) certificate;
                    throw new SSLPeerUnverifiedException(StringsKt.trimMargin$default("\n              |Hostname " + address.getUrl().getHost() + " not verified:\n              |    certificate: " + sdk.pendo.io.e2.g.INSTANCE.a((Certificate) x509Certificate) + "\n              |    DN: " + x509Certificate.getSubjectDN().getName() + "\n              |    subjectAltNames: " + sdk.pendo.io.q2.d.a.a(x509Certificate) + "\n              ", null, 1, null));
                }
                sdk.pendo.io.e2.g certificatePinner = address.getCertificatePinner();
                Intrinsics.checkNotNull(certificatePinner);
                this.handshake = new t(tVarA.getTlsVersion(), tVarA.getCipherSuite(), tVarA.b(), new c(certificatePinner, tVarA, address));
                certificatePinner.a(address.getUrl().getHost(), new d());
                String strB = lVarA.getSupportsTlsExtensions() ? sdk.pendo.io.n2.h.INSTANCE.d().b(sSLSocket2) : null;
                this.socket = sSLSocket2;
                this.source = o.a(o.b(sSLSocket2));
                this.sink = o.a(o.a(sSLSocket2));
                this.protocol = strB != null ? a0.INSTANCE.a(strB) : a0.HTTP_1_1;
                sdk.pendo.io.n2.h.INSTANCE.d().a(sSLSocket2);
            } catch (Throwable th) {
                th = th;
                sSLSocket = sSLSocket2;
                if (sSLSocket != null) {
                    sdk.pendo.io.n2.h.INSTANCE.d().a(sSLSocket);
                }
                if (sSLSocket != null) {
                    sdk.pendo.io.f2.b.a((Socket) sSLSocket);
                }
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
        }
    }

    private final void a(int connectTimeout, int readTimeout, int writeTimeout, sdk.pendo.io.e2.e call, r eventListener) throws IOException {
        b0 b0VarB = b();
        v vVarI = b0VarB.i();
        for (int i = 0; i < 21; i++) {
            a(connectTimeout, readTimeout, call, eventListener);
            b0VarB = a(readTimeout, writeTimeout, b0VarB, vVarI);
            if (b0VarB == null) {
                return;
            }
            Socket socket = this.rawSocket;
            if (socket != null) {
                sdk.pendo.io.f2.b.a(socket);
            }
            this.rawSocket = null;
            this.sink = null;
            this.source = null;
            eventListener.a(call, this.route.getSocketAddress(), this.route.getProxy(), null);
        }
    }

    private final b0 a(int readTimeout, int writeTimeout, b0 tunnelRequest, v url) throws IOException {
        String str = "CONNECT " + sdk.pendo.io.f2.b.a(url, true) + " HTTP/1.1";
        while (true) {
            sdk.pendo.io.s2.f fVar = this.source;
            Intrinsics.checkNotNull(fVar);
            sdk.pendo.io.s2.e eVar = this.sink;
            Intrinsics.checkNotNull(eVar);
            sdk.pendo.io.l2.b bVar = new sdk.pendo.io.l2.b(null, this, fVar, eVar);
            TimeUnit timeUnit = TimeUnit.MILLISECONDS;
            fVar.getTimeout().a(readTimeout, timeUnit);
            eVar.getTimeout().a(writeTimeout, timeUnit);
            bVar.a(tunnelRequest.getHeaders(), str);
            bVar.finishRequest();
            d0.a responseHeaders = bVar.readResponseHeaders(false);
            Intrinsics.checkNotNull(responseHeaders);
            d0 d0VarA = responseHeaders.a(tunnelRequest).a();
            bVar.d(d0VarA);
            int code = d0VarA.getCode();
            if (code == 200) {
                if (fVar.getBufferField().exhausted() && eVar.getBufferField().exhausted()) {
                    return null;
                }
                throw new IOException("TLS tunnel buffered too many bytes!");
            }
            if (code != 407) {
                throw new IOException("Unexpected response code for CONNECT: " + d0VarA.getCode());
            }
            b0 b0VarA = this.route.getAddress().getProxyAuthenticator().a(this.route, d0VarA);
            if (b0VarA == null) {
                throw new IOException("Failed to authenticate with proxy");
            }
            if (StringsKt.equals(HeaderElements.CLOSE, d0.a(d0VarA, "Connection", null, 2, null), true)) {
                return b0VarA;
            }
            tunnelRequest = b0VarA;
        }
    }

    private final void a(sdk.pendo.io.j2.b connectionSpecSelector, int pingIntervalMillis, sdk.pendo.io.e2.e call, r eventListener) throws Throwable {
        if (this.route.getAddress().getSslSocketFactory() != null) {
            eventListener.h(call);
            a(connectionSpecSelector);
            eventListener.a(call, this.handshake);
            if (this.protocol == a0.HTTP_2) {
                a(pingIntervalMillis);
                return;
            }
            return;
        }
        List<a0> listE = this.route.getAddress().e();
        a0 a0Var = a0.H2_PRIOR_KNOWLEDGE;
        if (!listE.contains(a0Var)) {
            this.socket = this.rawSocket;
            this.protocol = a0.HTTP_1_1;
        } else {
            this.socket = this.rawSocket;
            this.protocol = a0Var;
            a(pingIntervalMillis);
        }
    }

    public final boolean a(sdk.pendo.io.e2.a address, List<f0> routes) {
        Intrinsics.checkNotNullParameter(address, "address");
        if (sdk.pendo.io.f2.b.h && !Thread.holdsLock(this)) {
            throw new AssertionError("Thread " + Thread.currentThread().getName() + " MUST hold lock on " + this);
        }
        if (this.calls.size() >= this.allocationLimit || this.noNewExchanges || !this.route.getAddress().a(address)) {
            return false;
        }
        if (Intrinsics.areEqual(address.getUrl().getHost(), getRoute().getAddress().getUrl().getHost())) {
            return true;
        }
        if (this.http2Connection == null || routes == null || !a(routes) || address.getHostnameVerifier() != sdk.pendo.io.q2.d.a || !a(address.getUrl())) {
            return false;
        }
        try {
            sdk.pendo.io.e2.g certificatePinner = address.getCertificatePinner();
            Intrinsics.checkNotNull(certificatePinner);
            String host = address.getUrl().getHost();
            t handshake = getHandshake();
            Intrinsics.checkNotNull(handshake);
            certificatePinner.a(host, handshake.c());
            return true;
        } catch (SSLPeerUnverifiedException unused) {
            return false;
        }
    }

    public final boolean a(boolean doExtensiveChecks) {
        long j;
        if (sdk.pendo.io.f2.b.h && Thread.holdsLock(this)) {
            throw new AssertionError("Thread " + Thread.currentThread().getName() + " MUST NOT hold lock on " + this);
        }
        long jNanoTime = System.nanoTime();
        Socket socket = this.rawSocket;
        Intrinsics.checkNotNull(socket);
        Socket socket2 = this.socket;
        Intrinsics.checkNotNull(socket2);
        sdk.pendo.io.s2.f fVar = this.source;
        Intrinsics.checkNotNull(fVar);
        if (socket.isClosed() || socket2.isClosed() || socket2.isInputShutdown() || socket2.isOutputShutdown()) {
            return false;
        }
        sdk.pendo.io.m2.f fVar2 = this.http2Connection;
        if (fVar2 != null) {
            return fVar2.a(jNanoTime);
        }
        synchronized (this) {
            j = jNanoTime - this.idleAtNs;
        }
        if (j < RealConnection.IDLE_CONNECTION_HEALTHY_NS || !doExtensiveChecks) {
            return true;
        }
        return sdk.pendo.io.f2.b.a(socket2, fVar);
    }

    public final sdk.pendo.io.k2.d a(z client, sdk.pendo.io.k2.g chain) throws SocketException {
        Intrinsics.checkNotNullParameter(client, "client");
        Intrinsics.checkNotNullParameter(chain, "chain");
        Socket socket = this.socket;
        Intrinsics.checkNotNull(socket);
        sdk.pendo.io.s2.f fVar = this.source;
        Intrinsics.checkNotNull(fVar);
        sdk.pendo.io.s2.e eVar = this.sink;
        Intrinsics.checkNotNull(eVar);
        sdk.pendo.io.m2.f fVar2 = this.http2Connection;
        if (fVar2 != null) {
            return new sdk.pendo.io.m2.g(client, this, chain, fVar2);
        }
        socket.setSoTimeout(chain.g());
        sdk.pendo.io.s2.b0 b0VarTimeout = fVar.getTimeout();
        long jD = chain.getReadTimeoutMillis();
        TimeUnit timeUnit = TimeUnit.MILLISECONDS;
        b0VarTimeout.a(jD, timeUnit);
        eVar.getTimeout().a(chain.getWriteTimeoutMillis(), timeUnit);
        return new sdk.pendo.io.l2.b(client, this, fVar, eVar);
    }

    public final sdk.pendo.io.r2.d.AbstractC0471d a(sdk.pendo.io.j2.c exchange) throws SocketException {
        Intrinsics.checkNotNullParameter(exchange, "exchange");
        Socket socket = this.socket;
        Intrinsics.checkNotNull(socket);
        sdk.pendo.io.s2.f fVar = this.source;
        Intrinsics.checkNotNull(fVar);
        sdk.pendo.io.s2.e eVar = this.sink;
        Intrinsics.checkNotNull(eVar);
        socket.setSoTimeout(0);
        k();
        return new e(fVar, eVar, exchange);
    }

    @Override // sdk.pendo.io.m2.f.c
    public synchronized void a(sdk.pendo.io.m2.f connection, m settings) {
        Intrinsics.checkNotNullParameter(connection, "connection");
        Intrinsics.checkNotNullParameter(settings, "settings");
        this.allocationLimit = settings.c();
    }

    @Override // sdk.pendo.io.m2.f.c
    public void a(sdk.pendo.io.m2.i stream) {
        Intrinsics.checkNotNullParameter(stream, "stream");
        stream.a(sdk.pendo.io.m2.b.REFUSED_STREAM, (IOException) null);
    }

    private final boolean a(List<f0> candidates) {
        if ((candidates instanceof Collection) && candidates.isEmpty()) {
            return false;
        }
        for (f0 f0Var : candidates) {
            if (f0Var.getProxy().type() == Proxy.Type.DIRECT && this.route.getProxy().type() == Proxy.Type.DIRECT && Intrinsics.areEqual(this.route.getSocketAddress(), f0Var.getSocketAddress())) {
                return true;
            }
        }
        return false;
    }

    public final void a(long j) {
        this.idleAtNs = j;
    }

    private final void a(int pingIntervalMillis) throws SocketException {
        Socket socket = this.socket;
        Intrinsics.checkNotNull(socket);
        sdk.pendo.io.s2.f fVar = this.source;
        Intrinsics.checkNotNull(fVar);
        sdk.pendo.io.s2.e eVar = this.sink;
        Intrinsics.checkNotNull(eVar);
        socket.setSoTimeout(0);
        sdk.pendo.io.m2.f fVarA = new sdk.pendo.io.m2.f.a(true, sdk.pendo.io.i2.e.i).a(socket, this.route.getAddress().getUrl().getHost(), fVar, eVar).a(this).a(pingIntervalMillis).a();
        this.http2Connection = fVarA;
        this.allocationLimit = sdk.pendo.io.m2.f.INSTANCE.a().c();
        sdk.pendo.io.m2.f.a(fVarA, false, null, 3, null);
    }

    private final boolean a(v url) {
        t tVar;
        if (sdk.pendo.io.f2.b.h && !Thread.holdsLock(this)) {
            throw new AssertionError("Thread " + Thread.currentThread().getName() + " MUST hold lock on " + this);
        }
        v url2 = this.route.getAddress().getUrl();
        if (url.getPort() != url2.getPort()) {
            return false;
        }
        if (Intrinsics.areEqual(url.getHost(), url2.getHost())) {
            return true;
        }
        if (!this.noCoalescedConnections && (tVar = this.handshake) != null) {
            Intrinsics.checkNotNull(tVar);
            if (a(url, tVar)) {
                return true;
            }
        }
        return false;
    }

    /* JADX WARN: Code restructure failed: missing block: B:13:0x0023, code lost:
    
        if (r3.getCanceled() != false) goto L26;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final synchronized void a(sdk.pendo.io.j2.e r3, java.io.IOException r4) {
        /*
            r2 = this;
            monitor-enter(r2)
            java.lang.String r0 = "call"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r3, r0)     // Catch: java.lang.Throwable -> L4d
            boolean r0 = r4 instanceof sdk.pendo.io.m2.n     // Catch: java.lang.Throwable -> L4d
            r1 = 1
            if (r0 == 0) goto L2d
            sdk.pendo.io.m2.n r4 = (sdk.pendo.io.m2.n) r4     // Catch: java.lang.Throwable -> L4d
            sdk.pendo.io.m2.b r4 = r4.errorCode     // Catch: java.lang.Throwable -> L4d
            sdk.pendo.io.m2.b r0 = sdk.pendo.io.m2.b.REFUSED_STREAM     // Catch: java.lang.Throwable -> L4d
            if (r4 != r0) goto L1b
            int r3 = r2.refusedStreamCount     // Catch: java.lang.Throwable -> L4d
            int r3 = r3 + r1
            r2.refusedStreamCount = r3     // Catch: java.lang.Throwable -> L4d
            if (r3 <= r1) goto L4b
            goto L25
        L1b:
            sdk.pendo.io.m2.b r0 = sdk.pendo.io.m2.b.CANCEL     // Catch: java.lang.Throwable -> L4d
            if (r4 != r0) goto L25
            boolean r3 = r3.getCanceled()     // Catch: java.lang.Throwable -> L4d
            if (r3 != 0) goto L4b
        L25:
            r2.noNewExchanges = r1     // Catch: java.lang.Throwable -> L4d
            int r3 = r2.routeFailureCount     // Catch: java.lang.Throwable -> L4d
        L29:
            int r3 = r3 + r1
            r2.routeFailureCount = r3     // Catch: java.lang.Throwable -> L4d
            goto L4b
        L2d:
            boolean r0 = r2.i()     // Catch: java.lang.Throwable -> L4d
            if (r0 == 0) goto L37
            boolean r0 = r4 instanceof sdk.pendo.io.m2.a     // Catch: java.lang.Throwable -> L4d
            if (r0 == 0) goto L4b
        L37:
            r2.noNewExchanges = r1     // Catch: java.lang.Throwable -> L4d
            int r0 = r2.successCount     // Catch: java.lang.Throwable -> L4d
            if (r0 != 0) goto L4b
            if (r4 == 0) goto L48
            sdk.pendo.io.e2.z r3 = r3.getClient()     // Catch: java.lang.Throwable -> L4d
            sdk.pendo.io.e2.f0 r0 = r2.route     // Catch: java.lang.Throwable -> L4d
            r2.a(r3, r0, r4)     // Catch: java.lang.Throwable -> L4d
        L48:
            int r3 = r2.routeFailureCount     // Catch: java.lang.Throwable -> L4d
            goto L29
        L4b:
            monitor-exit(r2)
            return
        L4d:
            r3 = move-exception
            monitor-exit(r2)     // Catch: java.lang.Throwable -> L4d
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: sdk.pendo.io.j2.f.a(sdk.pendo.io.j2.e, java.io.IOException):void");
    }
}
