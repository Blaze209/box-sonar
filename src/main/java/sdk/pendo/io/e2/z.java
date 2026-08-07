package sdk.pendo.io.e2;

import androidx.exifinterface.media.ExifInterface;
import androidx.media3.exoplayer.upstream.CmcdData;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.microsoft.identity.common.nativeauth.internal.commands.ResetPasswordSubmitNewPasswordCommand;
import java.net.Proxy;
import java.net.ProxySelector;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;
import javax.net.SocketFactory;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.X509TrustManager;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000Þ\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u000b\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\f\b\u0016\u0018\u0000 R2\u00020\u00012\u00020\u00022\u00020\u0003:\u0002\t\u0014B\u0014\b\u0000\u0012\u0007\u0010\u0089\u0001\u001a\u00020\r¢\u0006\u0006\b\u008a\u0001\u0010\u008b\u0001B\u000b\b\u0016¢\u0006\u0006\b\u008a\u0001\u0010\u008c\u0001J\b\u0010\u0005\u001a\u00020\u0004H\u0002J\u0010\u0010\t\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006H\u0016J\u0018\u0010\t\u001a\u00020\f2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\nH\u0016J\b\u0010\u000e\u001a\u00020\rH\u0016R\u0017\u0010\u0011\u001a\u00020\u000f8G¢\u0006\f\n\u0004\b\t\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012R\u0017\u0010\u0016\u001a\u00020\u00138G¢\u0006\f\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017R\u001d\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u00190\u00188G¢\u0006\f\n\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u001c\u0010\u001dR\u001d\u0010!\u001a\b\u0012\u0004\u0012\u00020\u00190\u00188G¢\u0006\f\n\u0004\b\u001f\u0010\u001b\u001a\u0004\b \u0010\u001dR\u0017\u0010%\u001a\u00020\"8G¢\u0006\f\n\u0004\b#\u0010$\u001a\u0004\b%\u0010&R\u0017\u0010,\u001a\u00020'8G¢\u0006\f\n\u0004\b(\u0010)\u001a\u0004\b*\u0010+R\u0017\u00100\u001a\u00020-8G¢\u0006\f\n\u0004\b.\u0010/\u001a\u0004\b0\u00101R\u0017\u00104\u001a\u00020'8G¢\u0006\f\n\u0004\b2\u0010)\u001a\u0004\b3\u0010+R\u0017\u00107\u001a\u00020'8G¢\u0006\f\n\u0004\b5\u0010)\u001a\u0004\b6\u0010+R\u0017\u0010;\u001a\u0002088G¢\u0006\f\n\u0004\b9\u0010:\u001a\u0004\b;\u0010<R\u0017\u0010@\u001a\u00020=8G¢\u0006\f\n\u0004\b>\u0010?\u001a\u0004\b@\u0010AR\u0019\u0010G\u001a\u0004\u0018\u00010B8G¢\u0006\f\n\u0004\bC\u0010D\u001a\u0004\bE\u0010FR\u0017\u0010M\u001a\u00020H8G¢\u0006\f\n\u0004\bI\u0010J\u001a\u0004\bK\u0010LR\u0017\u0010O\u001a\u00020-8G¢\u0006\f\n\u0004\bN\u0010/\u001a\u0004\bO\u00101R\u0017\u0010T\u001a\u00020P8G¢\u0006\f\n\u0004\b3\u0010Q\u001a\u0004\bR\u0010SR\u0016\u0010W\u001a\u0004\u0018\u00010U8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b6\u0010VR\u0019\u0010]\u001a\u0004\u0018\u00010X8G¢\u0006\f\n\u0004\bY\u0010Z\u001a\u0004\b[\u0010\\R\u001d\u0010`\u001a\b\u0012\u0004\u0012\u00020^0\u00188G¢\u0006\f\n\u0004\b_\u0010\u001b\u001a\u0004\b9\u0010\u001dR\u001d\u0010c\u001a\b\u0012\u0004\u0012\u00020a0\u00188G¢\u0006\f\n\u0004\b\u001c\u0010\u001b\u001a\u0004\bb\u0010\u001dR\u0017\u0010h\u001a\u00020d8G¢\u0006\f\n\u0004\be\u0010f\u001a\u0004\b_\u0010gR\u0017\u0010k\u001a\u00020i8G¢\u0006\f\n\u0004\b \u0010j\u001a\u0004\bk\u0010lR\u0019\u0010o\u001a\u0004\u0018\u00010m8G¢\u0006\f\n\u0004\b\u000e\u0010n\u001a\u0004\bo\u0010pR\u0017\u0010u\u001a\u00020q8G¢\u0006\f\n\u0004\br\u0010s\u001a\u0004\b#\u0010tR\u0017\u0010v\u001a\u00020q8G¢\u0006\f\n\u0004\bb\u0010s\u001a\u0004\b2\u0010tR\u0017\u0010x\u001a\u00020q8G¢\u0006\f\n\u0004\bE\u0010s\u001a\u0004\bw\u0010tR\u0017\u0010{\u001a\u00020q8G¢\u0006\f\n\u0004\by\u0010s\u001a\u0004\bz\u0010tR\u0017\u0010|\u001a\u00020q8G¢\u0006\f\n\u0004\bK\u0010s\u001a\u0004\br\u0010tR\u0018\u0010\u0080\u0001\u001a\u00020}8G¢\u0006\f\n\u0004\bw\u0010~\u001a\u0004\be\u0010\u007fR\u001c\u0010\u0085\u0001\u001a\u00030\u0081\u00018\u0006¢\u0006\u000f\n\u0005\b*\u0010\u0082\u0001\u001a\u0006\b\u0083\u0001\u0010\u0084\u0001R\u0014\u0010\u0088\u0001\u001a\u00020U8G¢\u0006\b\u001a\u0006\b\u0086\u0001\u0010\u0087\u0001¨\u0006\u008d\u0001"}, d2 = {"Lsdk/pendo/io/e2/z;", "", "Lsdk/pendo/io/e2/e$a;", "Lsdk/pendo/io/e2/h0$a;", "", "F", "Lsdk/pendo/io/e2/b0;", "request", "Lsdk/pendo/io/e2/e;", CmcdData.OBJECT_TYPE_AUDIO_ONLY, "Lsdk/pendo/io/e2/i0;", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "Lsdk/pendo/io/e2/h0;", "Lsdk/pendo/io/e2/z$a;", "v", "Lsdk/pendo/io/e2/p;", "Lsdk/pendo/io/e2/p;", "dispatcher", "()Lokhttp3/Dispatcher;", "Lsdk/pendo/io/e2/k;", "b", "Lsdk/pendo/io/e2/k;", "connectionPool", "()Lokhttp3/ConnectionPool;", "", "Lsdk/pendo/io/e2/w;", "c", "Ljava/util/List;", "s", "()Ljava/util/List;", "interceptors", "d", "u", "networkInterceptors", "Lsdk/pendo/io/e2/r$c;", "e", "Lsdk/pendo/io/e2/r$c;", "eventListenerFactory", "()Lokhttp3/EventListener$Factory;", "", "f", "Z", "C", "()Z", "retryOnConnectionFailure", "Lsdk/pendo/io/e2/b;", "g", "Lsdk/pendo/io/e2/b;", "authenticator", "()Lokhttp3/Authenticator;", CmcdData.STREAMING_FORMAT_HLS, "o", "followRedirects", "i", "p", "followSslRedirects", "Lsdk/pendo/io/e2/n;", "j", "Lsdk/pendo/io/e2/n;", "cookieJar", "()Lokhttp3/CookieJar;", "Lsdk/pendo/io/e2/q;", "k", "Lsdk/pendo/io/e2/q;", "dns", "()Lokhttp3/Dns;", "Ljava/net/Proxy;", CmcdData.STREAM_TYPE_LIVE, "Ljava/net/Proxy;", "y", "()Ljava/net/Proxy;", "proxy", "Ljava/net/ProxySelector;", CmcdData.OBJECT_TYPE_MANIFEST, "Ljava/net/ProxySelector;", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "()Ljava/net/ProxySelector;", "proxySelector", "n", "proxyAuthenticator", "Ljavax/net/SocketFactory;", "Ljavax/net/SocketFactory;", "D", "()Ljavax/net/SocketFactory;", "socketFactory", "Ljavax/net/ssl/SSLSocketFactory;", "Ljavax/net/ssl/SSLSocketFactory;", "sslSocketFactoryOrNull", "Ljavax/net/ssl/X509TrustManager;", "q", "Ljavax/net/ssl/X509TrustManager;", "H", "()Ljavax/net/ssl/X509TrustManager;", "x509TrustManager", "Lsdk/pendo/io/e2/l;", "r", "connectionSpecs", "Lsdk/pendo/io/e2/a0;", "x", "protocols", "Ljavax/net/ssl/HostnameVerifier;", "t", "Ljavax/net/ssl/HostnameVerifier;", "()Ljavax/net/ssl/HostnameVerifier;", "hostnameVerifier", "Lsdk/pendo/io/e2/g;", "Lsdk/pendo/io/e2/g;", "certificatePinner", "()Lokhttp3/CertificatePinner;", "Lsdk/pendo/io/q2/c;", "Lsdk/pendo/io/q2/c;", "certificateChainCleaner", "()Lokhttp3/internal/tls/CertificateChainCleaner;", "", "w", "I", "()I", "callTimeoutMillis", "connectTimeoutMillis", "B", "readTimeoutMillis", "z", "G", "writeTimeoutMillis", "pingIntervalMillis", "", "J", "()J", "minWebSocketMessageToCompress", "Lsdk/pendo/io/j2/h;", "Lsdk/pendo/io/j2/h;", "getRouteDatabase", "()Lokhttp3/internal/connection/RouteDatabase;", "routeDatabase", ExifInterface.LONGITUDE_EAST, "()Ljavax/net/ssl/SSLSocketFactory;", "sslSocketFactory", "builder", "<init>", "(Lokhttp3/OkHttpClient$Builder;)V", "()V", "okhttp"}, k = 1, mv = {1, 8, 0})
public class z implements Cloneable, e.a, h0.a {

    /* JADX INFO: renamed from: D, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final List<a0> E = sdk.pendo.io.f2.b.a(a0.HTTP_2, a0.HTTP_1_1);
    private static final List<l> F = sdk.pendo.io.f2.b.a(l.i, l.k);

    /* JADX INFO: renamed from: A, reason: from kotlin metadata */
    private final int pingIntervalMillis;

    /* JADX INFO: renamed from: B, reason: from kotlin metadata */
    private final long minWebSocketMessageToCompress;

    /* JADX INFO: renamed from: C, reason: from kotlin metadata */
    private final sdk.pendo.io.j2.h routeDatabase;

    /* JADX INFO: renamed from: a, reason: from kotlin metadata */
    private final p dispatcher;

    /* JADX INFO: renamed from: b, reason: from kotlin metadata */
    private final k connectionPool;

    /* JADX INFO: renamed from: c, reason: from kotlin metadata */
    private final List<w> interceptors;

    /* JADX INFO: renamed from: d, reason: from kotlin metadata */
    private final List<w> networkInterceptors;

    /* JADX INFO: renamed from: e, reason: from kotlin metadata */
    private final r.c eventListenerFactory;

    /* JADX INFO: renamed from: f, reason: from kotlin metadata */
    private final boolean retryOnConnectionFailure;

    /* JADX INFO: renamed from: g, reason: from kotlin metadata */
    private final b authenticator;

    /* JADX INFO: renamed from: h, reason: from kotlin metadata */
    private final boolean followRedirects;

    /* JADX INFO: renamed from: i, reason: from kotlin metadata */
    private final boolean followSslRedirects;

    /* JADX INFO: renamed from: j, reason: from kotlin metadata */
    private final n cookieJar;

    /* JADX INFO: renamed from: k, reason: from kotlin metadata */
    private final q dns;

    /* JADX INFO: renamed from: l, reason: from kotlin metadata */
    private final Proxy proxy;

    /* JADX INFO: renamed from: m, reason: from kotlin metadata */
    private final ProxySelector proxySelector;

    /* JADX INFO: renamed from: n, reason: from kotlin metadata */
    private final b proxyAuthenticator;

    /* JADX INFO: renamed from: o, reason: from kotlin metadata */
    private final SocketFactory socketFactory;

    /* JADX INFO: renamed from: p, reason: from kotlin metadata */
    private final SSLSocketFactory sslSocketFactoryOrNull;

    /* JADX INFO: renamed from: q, reason: from kotlin metadata */
    private final X509TrustManager x509TrustManager;

    /* JADX INFO: renamed from: r, reason: from kotlin metadata */
    private final List<l> connectionSpecs;

    /* JADX INFO: renamed from: s, reason: from kotlin metadata */
    private final List<a0> protocols;

    /* JADX INFO: renamed from: t, reason: from kotlin metadata */
    private final HostnameVerifier hostnameVerifier;

    /* JADX INFO: renamed from: u, reason: from kotlin metadata */
    private final g certificatePinner;

    /* JADX INFO: renamed from: v, reason: from kotlin metadata */
    private final sdk.pendo.io.q2.c certificateChainCleaner;

    /* JADX INFO: renamed from: w, reason: from kotlin metadata */
    private final int callTimeoutMillis;

    /* JADX INFO: renamed from: x, reason: from kotlin metadata */
    private final int connectTimeoutMillis;

    /* JADX INFO: renamed from: y, reason: from kotlin metadata */
    private final int readTimeoutMillis;

    /* JADX INFO: renamed from: z, reason: from kotlin metadata */
    private final int writeTimeoutMillis;

    @Metadata(d1 = {"\u0000Ê\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010!\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0016\n\u0002\u0018\u0002\n\u0002\b\u000b\u0018\u00002\u00020\u0001B\u0014\b\u0010\u0012\u0007\u0010º\u0001\u001a\u00020\u000f¢\u0006\u0006\b»\u0001\u0010¼\u0001B\t¢\u0006\u0006\b»\u0001\u0010½\u0001J\u000e\u0010\u0004\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\u0004\u001a\u00020\u00002\u0006\u0010\u0006\u001a\u00020\u0005J\u0014\u0010\u0004\u001a\u00020\u00002\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\u0007J\u0016\u0010\u0004\u001a\u00020\u00002\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\fJ\u0016\u0010\u000e\u001a\u00020\u00002\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\fJ\u0006\u0010\u0004\u001a\u00020\u000fR\"\u0010\u0016\u001a\u00020\u00108\u0000@\u0000X\u0080\u000e¢\u0006\u0012\n\u0004\b\u0004\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\"\u0010\u001d\u001a\u00020\u00178\u0000@\u0000X\u0080\u000e¢\u0006\u0012\n\u0004\b\u000e\u0010\u0018\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001cR \u0010#\u001a\b\u0012\u0004\u0012\u00020\u00020\u001e8\u0000X\u0080\u0004¢\u0006\f\n\u0004\b\u001f\u0010 \u001a\u0004\b!\u0010\"R \u0010&\u001a\b\u0012\u0004\u0012\u00020\u00020\u001e8\u0000X\u0080\u0004¢\u0006\f\n\u0004\b$\u0010 \u001a\u0004\b%\u0010\"R\"\u0010.\u001a\u00020'8\u0000@\u0000X\u0080\u000e¢\u0006\u0012\n\u0004\b(\u0010)\u001a\u0004\b*\u0010+\"\u0004\b,\u0010-R\"\u00106\u001a\u00020/8\u0000@\u0000X\u0080\u000e¢\u0006\u0012\n\u0004\b0\u00101\u001a\u0004\b2\u00103\"\u0004\b4\u00105R\"\u0010>\u001a\u0002078\u0000@\u0000X\u0080\u000e¢\u0006\u0012\n\u0004\b8\u00109\u001a\u0004\b:\u0010;\"\u0004\b<\u0010=R\"\u0010B\u001a\u00020/8\u0000@\u0000X\u0080\u000e¢\u0006\u0012\n\u0004\b?\u00101\u001a\u0004\b@\u00103\"\u0004\bA\u00105R\"\u0010F\u001a\u00020/8\u0000@\u0000X\u0080\u000e¢\u0006\u0012\n\u0004\bC\u00101\u001a\u0004\bD\u00103\"\u0004\bE\u00105R\"\u0010N\u001a\u00020G8\u0000@\u0000X\u0080\u000e¢\u0006\u0012\n\u0004\bH\u0010I\u001a\u0004\bJ\u0010K\"\u0004\bL\u0010MR\"\u0010V\u001a\u00020O8\u0000@\u0000X\u0080\u000e¢\u0006\u0012\n\u0004\bP\u0010Q\u001a\u0004\bR\u0010S\"\u0004\bT\u0010UR$\u0010^\u001a\u0004\u0018\u00010W8\u0000@\u0000X\u0080\u000e¢\u0006\u0012\n\u0004\bX\u0010Y\u001a\u0004\bZ\u0010[\"\u0004\b\\\u0010]R$\u0010f\u001a\u0004\u0018\u00010_8\u0000@\u0000X\u0080\u000e¢\u0006\u0012\n\u0004\b`\u0010a\u001a\u0004\bb\u0010c\"\u0004\bd\u0010eR\"\u0010i\u001a\u0002078\u0000@\u0000X\u0080\u000e¢\u0006\u0012\n\u0004\b@\u00109\u001a\u0004\bg\u0010;\"\u0004\bh\u0010=R\"\u0010p\u001a\u00020j8\u0000@\u0000X\u0080\u000e¢\u0006\u0012\n\u0004\bD\u0010k\u001a\u0004\bl\u0010m\"\u0004\bn\u0010oR$\u0010x\u001a\u0004\u0018\u00010q8\u0000@\u0000X\u0080\u000e¢\u0006\u0012\n\u0004\br\u0010s\u001a\u0004\bt\u0010u\"\u0004\bv\u0010wR$\u0010\u007f\u001a\u0004\u0018\u00010y8\u0000@\u0000X\u0080\u000e¢\u0006\u0012\n\u0004\b!\u0010z\u001a\u0004\b{\u0010|\"\u0004\b}\u0010~R-\u0010\u0084\u0001\u001a\t\u0012\u0005\u0012\u00030\u0080\u00010\u00078\u0000@\u0000X\u0080\u000e¢\u0006\u0015\n\u0005\b\u0081\u0001\u0010 \u001a\u0004\bC\u0010\"\"\u0006\b\u0082\u0001\u0010\u0083\u0001R+\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\u00078\u0000@\u0000X\u0080\u000e¢\u0006\u0015\n\u0004\b%\u0010 \u001a\u0005\b\u0085\u0001\u0010\"\"\u0006\b\u0086\u0001\u0010\u0083\u0001R)\u0010\u008d\u0001\u001a\u00030\u0087\u00018\u0000@\u0000X\u0080\u000e¢\u0006\u0017\n\u0006\b\u0088\u0001\u0010\u0089\u0001\u001a\u0005\br\u0010\u008a\u0001\"\u0006\b\u008b\u0001\u0010\u008c\u0001R*\u0010\u0094\u0001\u001a\u00030\u008e\u00018\u0000@\u0000X\u0080\u000e¢\u0006\u0018\n\u0006\b\u0085\u0001\u0010\u008f\u0001\u001a\u0006\b\u0090\u0001\u0010\u0091\u0001\"\u0006\b\u0092\u0001\u0010\u0093\u0001R+\u0010\u009b\u0001\u001a\u0005\u0018\u00010\u0095\u00018\u0000@\u0000X\u0080\u000e¢\u0006\u0017\n\u0005\bZ\u0010\u0096\u0001\u001a\u0006\b\u0097\u0001\u0010\u0098\u0001\"\u0006\b\u0099\u0001\u0010\u009a\u0001R)\u0010¢\u0001\u001a\u00030\u009c\u00018\u0000@\u0000X\u0080\u000e¢\u0006\u0017\n\u0006\b\u009d\u0001\u0010\u009e\u0001\u001a\u0005\b$\u0010\u009f\u0001\"\u0006\b \u0001\u0010¡\u0001R(\u0010¤\u0001\u001a\u00030\u009c\u00018\u0000@\u0000X\u0080\u000e¢\u0006\u0016\n\u0005\bb\u0010\u009e\u0001\u001a\u0005\b8\u0010\u009f\u0001\"\u0006\b£\u0001\u0010¡\u0001R*\u0010§\u0001\u001a\u00030\u009c\u00018\u0000@\u0000X\u0080\u000e¢\u0006\u0018\n\u0006\b¥\u0001\u0010\u009e\u0001\u001a\u0006\b¥\u0001\u0010\u009f\u0001\"\u0006\b¦\u0001\u0010¡\u0001R)\u0010ª\u0001\u001a\u00030\u009c\u00018\u0000@\u0000X\u0080\u000e¢\u0006\u0017\n\u0005\b2\u0010\u009e\u0001\u001a\u0006\b¨\u0001\u0010\u009f\u0001\"\u0006\b©\u0001\u0010¡\u0001R*\u0010\u00ad\u0001\u001a\u00030\u009c\u00018\u0000@\u0000X\u0080\u000e¢\u0006\u0018\n\u0006\b«\u0001\u0010\u009e\u0001\u001a\u0006\b\u0088\u0001\u0010\u009f\u0001\"\u0006\b¬\u0001\u0010¡\u0001R(\u0010²\u0001\u001a\u00020\n8\u0000@\u0000X\u0080\u000e¢\u0006\u0017\n\u0005\bl\u0010®\u0001\u001a\u0006\b\u0081\u0001\u0010¯\u0001\"\u0006\b°\u0001\u0010±\u0001R+\u0010¹\u0001\u001a\u0005\u0018\u00010³\u00018\u0000@\u0000X\u0080\u000e¢\u0006\u0017\n\u0005\bt\u0010´\u0001\u001a\u0006\bµ\u0001\u0010¶\u0001\"\u0006\b·\u0001\u0010¸\u0001¨\u0006¾\u0001"}, d2 = {"Lsdk/pendo/io/e2/z$a;", "", "Lsdk/pendo/io/e2/w;", "interceptor", CmcdData.OBJECT_TYPE_AUDIO_ONLY, "Lsdk/pendo/io/e2/r;", "eventListener", "", "Lsdk/pendo/io/e2/a0;", "protocols", "", ResetPasswordSubmitNewPasswordCommand.POLL_COMPLETION_TIMEOUT_ERROR_CODE, "Ljava/util/concurrent/TimeUnit;", "unit", "b", "Lsdk/pendo/io/e2/z;", "Lsdk/pendo/io/e2/p;", "Lsdk/pendo/io/e2/p;", "getDispatcher$okhttp", "()Lokhttp3/Dispatcher;", "setDispatcher$okhttp", "(Lokhttp3/Dispatcher;)V", "dispatcher", "Lsdk/pendo/io/e2/k;", "Lsdk/pendo/io/e2/k;", "getConnectionPool$okhttp", "()Lokhttp3/ConnectionPool;", "setConnectionPool$okhttp", "(Lokhttp3/ConnectionPool;)V", "connectionPool", "", "c", "Ljava/util/List;", "q", "()Ljava/util/List;", "interceptors", "d", "s", "networkInterceptors", "Lsdk/pendo/io/e2/r$c;", "e", "Lsdk/pendo/io/e2/r$c;", "getEventListenerFactory$okhttp", "()Lokhttp3/EventListener$Factory;", "setEventListenerFactory$okhttp", "(Lokhttp3/EventListener$Factory;)V", "eventListenerFactory", "", "f", "Z", "z", "()Z", "setRetryOnConnectionFailure$okhttp", "(Z)V", "retryOnConnectionFailure", "Lsdk/pendo/io/e2/b;", "g", "Lsdk/pendo/io/e2/b;", "getAuthenticator$okhttp", "()Lokhttp3/Authenticator;", "setAuthenticator$okhttp", "(Lokhttp3/Authenticator;)V", "authenticator", CmcdData.STREAMING_FORMAT_HLS, "n", "setFollowRedirects$okhttp", "followRedirects", "i", "o", "setFollowSslRedirects$okhttp", "followSslRedirects", "Lsdk/pendo/io/e2/n;", "j", "Lsdk/pendo/io/e2/n;", "getCookieJar$okhttp", "()Lokhttp3/CookieJar;", "setCookieJar$okhttp", "(Lokhttp3/CookieJar;)V", "cookieJar", "Lsdk/pendo/io/e2/q;", "k", "Lsdk/pendo/io/e2/q;", "getDns$okhttp", "()Lokhttp3/Dns;", "setDns$okhttp", "(Lokhttp3/Dns;)V", "dns", "Ljava/net/Proxy;", CmcdData.STREAM_TYPE_LIVE, "Ljava/net/Proxy;", "v", "()Ljava/net/Proxy;", "setProxy$okhttp", "(Ljava/net/Proxy;)V", "proxy", "Ljava/net/ProxySelector;", CmcdData.OBJECT_TYPE_MANIFEST, "Ljava/net/ProxySelector;", "x", "()Ljava/net/ProxySelector;", "setProxySelector$okhttp", "(Ljava/net/ProxySelector;)V", "proxySelector", "getProxyAuthenticator$okhttp", "setProxyAuthenticator$okhttp", "proxyAuthenticator", "Ljavax/net/SocketFactory;", "Ljavax/net/SocketFactory;", "B", "()Ljavax/net/SocketFactory;", "setSocketFactory$okhttp", "(Ljavax/net/SocketFactory;)V", "socketFactory", "Ljavax/net/ssl/SSLSocketFactory;", "p", "Ljavax/net/ssl/SSLSocketFactory;", "C", "()Ljavax/net/ssl/SSLSocketFactory;", "setSslSocketFactoryOrNull$okhttp", "(Ljavax/net/ssl/SSLSocketFactory;)V", "sslSocketFactoryOrNull", "Ljavax/net/ssl/X509TrustManager;", "Ljavax/net/ssl/X509TrustManager;", ExifInterface.LONGITUDE_EAST, "()Ljavax/net/ssl/X509TrustManager;", "setX509TrustManagerOrNull$okhttp", "(Ljavax/net/ssl/X509TrustManager;)V", "x509TrustManagerOrNull", "Lsdk/pendo/io/e2/l;", "r", "setConnectionSpecs$okhttp", "(Ljava/util/List;)V", "connectionSpecs", "u", "setProtocols$okhttp", "Ljavax/net/ssl/HostnameVerifier;", "t", "Ljavax/net/ssl/HostnameVerifier;", "()Ljavax/net/ssl/HostnameVerifier;", "setHostnameVerifier$okhttp", "(Ljavax/net/ssl/HostnameVerifier;)V", "hostnameVerifier", "Lsdk/pendo/io/e2/g;", "Lsdk/pendo/io/e2/g;", "getCertificatePinner$okhttp", "()Lokhttp3/CertificatePinner;", "setCertificatePinner$okhttp", "(Lokhttp3/CertificatePinner;)V", "certificatePinner", "Lsdk/pendo/io/q2/c;", "Lsdk/pendo/io/q2/c;", "getCertificateChainCleaner$okhttp", "()Lokhttp3/internal/tls/CertificateChainCleaner;", "setCertificateChainCleaner$okhttp", "(Lokhttp3/internal/tls/CertificateChainCleaner;)V", "certificateChainCleaner", "", "w", "I", "()I", "setCallTimeout$okhttp", "(I)V", "callTimeout", "setConnectTimeout$okhttp", "connectTimeout", "y", "setReadTimeout$okhttp", "readTimeout", "D", "setWriteTimeout$okhttp", "writeTimeout", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "setPingInterval$okhttp", "pingInterval", "J", "()J", "setMinWebSocketMessageToCompress$okhttp", "(J)V", "minWebSocketMessageToCompress", "Lsdk/pendo/io/j2/h;", "Lsdk/pendo/io/j2/h;", "getRouteDatabase$okhttp", "()Lokhttp3/internal/connection/RouteDatabase;", "setRouteDatabase$okhttp", "(Lokhttp3/internal/connection/RouteDatabase;)V", "routeDatabase", "okHttpClient", "<init>", "(Lokhttp3/OkHttpClient;)V", "()V", "okhttp"}, k = 1, mv = {1, 8, 0})
    public static final class a {

        /* JADX INFO: renamed from: A, reason: from kotlin metadata */
        private int pingInterval;

        /* JADX INFO: renamed from: B, reason: from kotlin metadata */
        private long minWebSocketMessageToCompress;

        /* JADX INFO: renamed from: C, reason: from kotlin metadata */
        private sdk.pendo.io.j2.h routeDatabase;

        /* JADX INFO: renamed from: a, reason: from kotlin metadata */
        private p dispatcher;

        /* JADX INFO: renamed from: b, reason: from kotlin metadata */
        private k connectionPool;

        /* JADX INFO: renamed from: c, reason: from kotlin metadata */
        private final List<w> interceptors;

        /* JADX INFO: renamed from: d, reason: from kotlin metadata */
        private final List<w> networkInterceptors;

        /* JADX INFO: renamed from: e, reason: from kotlin metadata */
        private r.c eventListenerFactory;

        /* JADX INFO: renamed from: f, reason: from kotlin metadata */
        private boolean retryOnConnectionFailure;

        /* JADX INFO: renamed from: g, reason: from kotlin metadata */
        private b authenticator;

        /* JADX INFO: renamed from: h, reason: from kotlin metadata */
        private boolean followRedirects;

        /* JADX INFO: renamed from: i, reason: from kotlin metadata */
        private boolean followSslRedirects;

        /* JADX INFO: renamed from: j, reason: from kotlin metadata */
        private n cookieJar;

        /* JADX INFO: renamed from: k, reason: from kotlin metadata */
        private q dns;

        /* JADX INFO: renamed from: l, reason: from kotlin metadata */
        private Proxy proxy;

        /* JADX INFO: renamed from: m, reason: from kotlin metadata */
        private ProxySelector proxySelector;

        /* JADX INFO: renamed from: n, reason: from kotlin metadata */
        private b proxyAuthenticator;

        /* JADX INFO: renamed from: o, reason: from kotlin metadata */
        private SocketFactory socketFactory;

        /* JADX INFO: renamed from: p, reason: from kotlin metadata */
        private SSLSocketFactory sslSocketFactoryOrNull;

        /* JADX INFO: renamed from: q, reason: from kotlin metadata */
        private X509TrustManager x509TrustManagerOrNull;

        /* JADX INFO: renamed from: r, reason: from kotlin metadata */
        private List<l> connectionSpecs;

        /* JADX INFO: renamed from: s, reason: from kotlin metadata */
        private List<? extends a0> protocols;

        /* JADX INFO: renamed from: t, reason: from kotlin metadata */
        private HostnameVerifier hostnameVerifier;

        /* JADX INFO: renamed from: u, reason: from kotlin metadata */
        private g certificatePinner;

        /* JADX INFO: renamed from: v, reason: from kotlin metadata */
        private sdk.pendo.io.q2.c certificateChainCleaner;

        /* JADX INFO: renamed from: w, reason: from kotlin metadata */
        private int callTimeout;

        /* JADX INFO: renamed from: x, reason: from kotlin metadata */
        private int connectTimeout;

        /* JADX INFO: renamed from: y, reason: from kotlin metadata */
        private int readTimeout;

        /* JADX INFO: renamed from: z, reason: from kotlin metadata */
        private int writeTimeout;

        public a() {
            this.dispatcher = new p();
            this.connectionPool = new k();
            this.interceptors = new ArrayList();
            this.networkInterceptors = new ArrayList();
            this.eventListenerFactory = sdk.pendo.io.f2.b.a(r.b);
            this.retryOnConnectionFailure = true;
            b bVar = b.b;
            this.authenticator = bVar;
            this.followRedirects = true;
            this.followSslRedirects = true;
            this.cookieJar = n.b;
            this.dns = q.b;
            this.proxyAuthenticator = bVar;
            SocketFactory socketFactory = SocketFactory.getDefault();
            Intrinsics.checkNotNullExpressionValue(socketFactory, "getDefault()");
            this.socketFactory = socketFactory;
            Companion companion = z.INSTANCE;
            this.connectionSpecs = companion.a();
            this.protocols = companion.b();
            this.hostnameVerifier = sdk.pendo.io.q2.d.a;
            this.certificatePinner = g.d;
            this.connectTimeout = 10000;
            this.readTimeout = 10000;
            this.writeTimeout = 10000;
            this.minWebSocketMessageToCompress = 1024L;
        }

        /* JADX INFO: renamed from: A, reason: from getter */
        public final sdk.pendo.io.j2.h getRouteDatabase() {
            return this.routeDatabase;
        }

        /* JADX INFO: renamed from: B, reason: from getter */
        public final SocketFactory getSocketFactory() {
            return this.socketFactory;
        }

        /* JADX INFO: renamed from: C, reason: from getter */
        public final SSLSocketFactory getSslSocketFactoryOrNull() {
            return this.sslSocketFactoryOrNull;
        }

        /* JADX INFO: renamed from: D, reason: from getter */
        public final int getWriteTimeout() {
            return this.writeTimeout;
        }

        /* JADX INFO: renamed from: E, reason: from getter */
        public final X509TrustManager getX509TrustManagerOrNull() {
            return this.x509TrustManagerOrNull;
        }

        public final a a(w interceptor) {
            Intrinsics.checkNotNullParameter(interceptor, "interceptor");
            this.interceptors.add(interceptor);
            return this;
        }

        /* JADX INFO: renamed from: b, reason: from getter */
        public final b getAuthenticator() {
            return this.authenticator;
        }

        public final c c() {
            return null;
        }

        /* JADX INFO: renamed from: d, reason: from getter */
        public final int getCallTimeout() {
            return this.callTimeout;
        }

        /* JADX INFO: renamed from: e, reason: from getter */
        public final sdk.pendo.io.q2.c getCertificateChainCleaner() {
            return this.certificateChainCleaner;
        }

        /* JADX INFO: renamed from: f, reason: from getter */
        public final g getCertificatePinner() {
            return this.certificatePinner;
        }

        /* JADX INFO: renamed from: g, reason: from getter */
        public final int getConnectTimeout() {
            return this.connectTimeout;
        }

        /* JADX INFO: renamed from: h, reason: from getter */
        public final k getConnectionPool() {
            return this.connectionPool;
        }

        public final List<l> i() {
            return this.connectionSpecs;
        }

        /* JADX INFO: renamed from: j, reason: from getter */
        public final n getCookieJar() {
            return this.cookieJar;
        }

        /* JADX INFO: renamed from: k, reason: from getter */
        public final p getDispatcher() {
            return this.dispatcher;
        }

        /* JADX INFO: renamed from: l, reason: from getter */
        public final q getDns() {
            return this.dns;
        }

        /* JADX INFO: renamed from: m, reason: from getter */
        public final r.c getEventListenerFactory() {
            return this.eventListenerFactory;
        }

        /* JADX INFO: renamed from: n, reason: from getter */
        public final boolean getFollowRedirects() {
            return this.followRedirects;
        }

        /* JADX INFO: renamed from: o, reason: from getter */
        public final boolean getFollowSslRedirects() {
            return this.followSslRedirects;
        }

        /* JADX INFO: renamed from: p, reason: from getter */
        public final HostnameVerifier getHostnameVerifier() {
            return this.hostnameVerifier;
        }

        public final List<w> q() {
            return this.interceptors;
        }

        /* JADX INFO: renamed from: r, reason: from getter */
        public final long getMinWebSocketMessageToCompress() {
            return this.minWebSocketMessageToCompress;
        }

        public final List<w> s() {
            return this.networkInterceptors;
        }

        /* JADX INFO: renamed from: t, reason: from getter */
        public final int getPingInterval() {
            return this.pingInterval;
        }

        public final List<a0> u() {
            return this.protocols;
        }

        /* JADX INFO: renamed from: v, reason: from getter */
        public final Proxy getProxy() {
            return this.proxy;
        }

        /* JADX INFO: renamed from: w, reason: from getter */
        public final b getProxyAuthenticator() {
            return this.proxyAuthenticator;
        }

        /* JADX INFO: renamed from: x, reason: from getter */
        public final ProxySelector getProxySelector() {
            return this.proxySelector;
        }

        /* JADX INFO: renamed from: y, reason: from getter */
        public final int getReadTimeout() {
            return this.readTimeout;
        }

        /* JADX INFO: renamed from: z, reason: from getter */
        public final boolean getRetryOnConnectionFailure() {
            return this.retryOnConnectionFailure;
        }

        /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
        public a(z okHttpClient) {
            this();
            Intrinsics.checkNotNullParameter(okHttpClient, "okHttpClient");
            this.dispatcher = okHttpClient.getDispatcher();
            this.connectionPool = okHttpClient.getConnectionPool();
            CollectionsKt.addAll(this.interceptors, okHttpClient.s());
            CollectionsKt.addAll(this.networkInterceptors, okHttpClient.u());
            this.eventListenerFactory = okHttpClient.getEventListenerFactory();
            this.retryOnConnectionFailure = okHttpClient.getRetryOnConnectionFailure();
            this.authenticator = okHttpClient.getAuthenticator();
            this.followRedirects = okHttpClient.getFollowRedirects();
            this.followSslRedirects = okHttpClient.getFollowSslRedirects();
            this.cookieJar = okHttpClient.getCookieJar();
            okHttpClient.d();
            this.dns = okHttpClient.getDns();
            this.proxy = okHttpClient.getProxy();
            this.proxySelector = okHttpClient.getProxySelector();
            this.proxyAuthenticator = okHttpClient.getProxyAuthenticator();
            this.socketFactory = okHttpClient.getSocketFactory();
            this.sslSocketFactoryOrNull = okHttpClient.sslSocketFactoryOrNull;
            this.x509TrustManagerOrNull = okHttpClient.getX509TrustManager();
            this.connectionSpecs = okHttpClient.j();
            this.protocols = okHttpClient.x();
            this.hostnameVerifier = okHttpClient.getHostnameVerifier();
            this.certificatePinner = okHttpClient.getCertificatePinner();
            this.certificateChainCleaner = okHttpClient.getCertificateChainCleaner();
            this.callTimeout = okHttpClient.getCallTimeoutMillis();
            this.connectTimeout = okHttpClient.getConnectTimeoutMillis();
            this.readTimeout = okHttpClient.getReadTimeoutMillis();
            this.writeTimeout = okHttpClient.getWriteTimeoutMillis();
            this.pingInterval = okHttpClient.getPingIntervalMillis();
            this.minWebSocketMessageToCompress = okHttpClient.getMinWebSocketMessageToCompress();
            this.routeDatabase = okHttpClient.getRouteDatabase();
        }

        public final z a() {
            return new z(this);
        }

        public final a b(long timeout, TimeUnit unit) {
            Intrinsics.checkNotNullParameter(unit, "unit");
            this.readTimeout = sdk.pendo.io.f2.b.a(ResetPasswordSubmitNewPasswordCommand.POLL_COMPLETION_TIMEOUT_ERROR_CODE, timeout, unit);
            return this;
        }

        public final a a(long timeout, TimeUnit unit) {
            Intrinsics.checkNotNullParameter(unit, "unit");
            this.connectTimeout = sdk.pendo.io.f2.b.a(ResetPasswordSubmitNewPasswordCommand.POLL_COMPLETION_TIMEOUT_ERROR_CODE, timeout, unit);
            return this;
        }

        public final a a(r eventListener) {
            Intrinsics.checkNotNullParameter(eventListener, "eventListener");
            this.eventListenerFactory = sdk.pendo.io.f2.b.a(eventListener);
            return this;
        }

        public final a a(List<? extends a0> protocols) {
            Intrinsics.checkNotNullParameter(protocols, "protocols");
            List mutableList = CollectionsKt.toMutableList((Collection) protocols);
            a0 a0Var = a0.H2_PRIOR_KNOWLEDGE;
            if (!mutableList.contains(a0Var) && !mutableList.contains(a0.HTTP_1_1)) {
                throw new IllegalArgumentException(("protocols must contain h2_prior_knowledge or http/1.1: " + mutableList).toString());
            }
            if (mutableList.contains(a0Var) && mutableList.size() > 1) {
                throw new IllegalArgumentException(("protocols containing h2_prior_knowledge cannot use other protocols: " + mutableList).toString());
            }
            if (mutableList.contains(a0.HTTP_1_0)) {
                throw new IllegalArgumentException(("protocols must not contain http/1.0: " + mutableList).toString());
            }
            Intrinsics.checkNotNull(mutableList, "null cannot be cast to non-null type kotlin.collections.List<okhttp3.Protocol?>");
            if (mutableList.contains(null)) {
                throw new IllegalArgumentException("protocols must not contain null".toString());
            }
            mutableList.remove(a0.SPDY_3);
            if (!Intrinsics.areEqual(mutableList, this.protocols)) {
                this.routeDatabase = null;
            }
            List<? extends a0> listUnmodifiableList = Collections.unmodifiableList(mutableList);
            Intrinsics.checkNotNullExpressionValue(listUnmodifiableList, "unmodifiableList(protocolsCopy)");
            this.protocols = listUnmodifiableList;
            return this;
        }
    }

    /* JADX INFO: renamed from: sdk.pendo.io.e2.z$b, reason: from kotlin metadata */
    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u000b\u0010\fR \u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0000X\u0080\u0004¢\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007R \u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\u00028\u0000X\u0080\u0004¢\u0006\f\n\u0004\b\t\u0010\u0005\u001a\u0004\b\n\u0010\u0007¨\u0006\r"}, d2 = {"Lsdk/pendo/io/e2/z$b;", "", "", "Lsdk/pendo/io/e2/a0;", "DEFAULT_PROTOCOLS", "Ljava/util/List;", "b", "()Ljava/util/List;", "Lsdk/pendo/io/e2/l;", "DEFAULT_CONNECTION_SPECS", CmcdData.OBJECT_TYPE_AUDIO_ONLY, "<init>", "()V", "okhttp"}, k = 1, mv = {1, 8, 0})
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final List<l> a() {
            return z.F;
        }

        public final List<a0> b() {
            return z.E;
        }
    }

    public z() {
        this(new a());
    }

    private final void F() {
        List<w> list = this.interceptors;
        Intrinsics.checkNotNull(list, "null cannot be cast to non-null type kotlin.collections.List<okhttp3.Interceptor?>");
        if (list.contains(null)) {
            throw new IllegalStateException(("Null interceptor: " + this.interceptors).toString());
        }
        List<w> list2 = this.networkInterceptors;
        Intrinsics.checkNotNull(list2, "null cannot be cast to non-null type kotlin.collections.List<okhttp3.Interceptor?>");
        if (list2.contains(null)) {
            throw new IllegalStateException(("Null network interceptor: " + this.networkInterceptors).toString());
        }
        List<l> list3 = this.connectionSpecs;
        if (!(list3 instanceof Collection) || !list3.isEmpty()) {
            Iterator<T> it = list3.iterator();
            while (it.hasNext()) {
                if (((l) it.next()).getIsTls()) {
                    if (this.sslSocketFactoryOrNull == null) {
                        throw new IllegalStateException("sslSocketFactory == null".toString());
                    }
                    if (this.certificateChainCleaner == null) {
                        throw new IllegalStateException("certificateChainCleaner == null".toString());
                    }
                    if (this.x509TrustManager == null) {
                        throw new IllegalStateException("x509TrustManager == null".toString());
                    }
                    return;
                }
            }
        }
        if (this.sslSocketFactoryOrNull != null) {
            throw new IllegalStateException("Check failed.".toString());
        }
        if (this.certificateChainCleaner != null) {
            throw new IllegalStateException("Check failed.".toString());
        }
        if (this.x509TrustManager != null) {
            throw new IllegalStateException("Check failed.".toString());
        }
        if (!Intrinsics.areEqual(this.certificatePinner, g.d)) {
            throw new IllegalStateException("Check failed.".toString());
        }
    }

    /* JADX INFO: renamed from: A, reason: from getter */
    public final ProxySelector getProxySelector() {
        return this.proxySelector;
    }

    /* JADX INFO: renamed from: B, reason: from getter */
    public final int getReadTimeoutMillis() {
        return this.readTimeoutMillis;
    }

    /* JADX INFO: renamed from: C, reason: from getter */
    public final boolean getRetryOnConnectionFailure() {
        return this.retryOnConnectionFailure;
    }

    /* JADX INFO: renamed from: D, reason: from getter */
    public final SocketFactory getSocketFactory() {
        return this.socketFactory;
    }

    public final SSLSocketFactory E() {
        SSLSocketFactory sSLSocketFactory = this.sslSocketFactoryOrNull;
        if (sSLSocketFactory != null) {
            return sSLSocketFactory;
        }
        throw new IllegalStateException("CLEARTEXT-only client");
    }

    /* JADX INFO: renamed from: G, reason: from getter */
    public final int getWriteTimeoutMillis() {
        return this.writeTimeoutMillis;
    }

    /* JADX INFO: renamed from: H, reason: from getter */
    public final X509TrustManager getX509TrustManager() {
        return this.x509TrustManager;
    }

    /* JADX INFO: renamed from: c, reason: from getter */
    public final b getAuthenticator() {
        return this.authenticator;
    }

    public Object clone() {
        return super.clone();
    }

    public final c d() {
        return null;
    }

    /* JADX INFO: renamed from: e, reason: from getter */
    public final int getCallTimeoutMillis() {
        return this.callTimeoutMillis;
    }

    /* JADX INFO: renamed from: f, reason: from getter */
    public final sdk.pendo.io.q2.c getCertificateChainCleaner() {
        return this.certificateChainCleaner;
    }

    /* JADX INFO: renamed from: g, reason: from getter */
    public final g getCertificatePinner() {
        return this.certificatePinner;
    }

    /* JADX INFO: renamed from: h, reason: from getter */
    public final int getConnectTimeoutMillis() {
        return this.connectTimeoutMillis;
    }

    /* JADX INFO: renamed from: i, reason: from getter */
    public final k getConnectionPool() {
        return this.connectionPool;
    }

    public final List<l> j() {
        return this.connectionSpecs;
    }

    /* JADX INFO: renamed from: k, reason: from getter */
    public final n getCookieJar() {
        return this.cookieJar;
    }

    /* JADX INFO: renamed from: l, reason: from getter */
    public final p getDispatcher() {
        return this.dispatcher;
    }

    /* JADX INFO: renamed from: m, reason: from getter */
    public final q getDns() {
        return this.dns;
    }

    /* JADX INFO: renamed from: n, reason: from getter */
    public final r.c getEventListenerFactory() {
        return this.eventListenerFactory;
    }

    /* JADX INFO: renamed from: o, reason: from getter */
    public final boolean getFollowRedirects() {
        return this.followRedirects;
    }

    /* JADX INFO: renamed from: p, reason: from getter */
    public final boolean getFollowSslRedirects() {
        return this.followSslRedirects;
    }

    /* JADX INFO: renamed from: q, reason: from getter */
    public final sdk.pendo.io.j2.h getRouteDatabase() {
        return this.routeDatabase;
    }

    /* JADX INFO: renamed from: r, reason: from getter */
    public final HostnameVerifier getHostnameVerifier() {
        return this.hostnameVerifier;
    }

    public final List<w> s() {
        return this.interceptors;
    }

    /* JADX INFO: renamed from: t, reason: from getter */
    public final long getMinWebSocketMessageToCompress() {
        return this.minWebSocketMessageToCompress;
    }

    public final List<w> u() {
        return this.networkInterceptors;
    }

    public a v() {
        return new a(this);
    }

    /* JADX INFO: renamed from: w, reason: from getter */
    public final int getPingIntervalMillis() {
        return this.pingIntervalMillis;
    }

    public final List<a0> x() {
        return this.protocols;
    }

    /* JADX INFO: renamed from: y, reason: from getter */
    public final Proxy getProxy() {
        return this.proxy;
    }

    /* JADX INFO: renamed from: z, reason: from getter */
    public final b getProxyAuthenticator() {
        return this.proxyAuthenticator;
    }

    /* JADX WARN: Code duplicated, block: B:9:0x006e  */
    public z(a builder) throws NoSuchAlgorithmException, KeyStoreException {
        ProxySelector proxySelector;
        sdk.pendo.io.q2.c cVarA;
        g gVarA;
        Intrinsics.checkNotNullParameter(builder, "builder");
        this.dispatcher = builder.getDispatcher();
        this.connectionPool = builder.getConnectionPool();
        this.interceptors = sdk.pendo.io.f2.b.b(builder.q());
        this.networkInterceptors = sdk.pendo.io.f2.b.b(builder.s());
        this.eventListenerFactory = builder.getEventListenerFactory();
        this.retryOnConnectionFailure = builder.getRetryOnConnectionFailure();
        this.authenticator = builder.getAuthenticator();
        this.followRedirects = builder.getFollowRedirects();
        this.followSslRedirects = builder.getFollowSslRedirects();
        this.cookieJar = builder.getCookieJar();
        builder.c();
        this.dns = builder.getDns();
        this.proxy = builder.getProxy();
        if (builder.getProxy() == null) {
            proxySelector = builder.getProxySelector();
            proxySelector = proxySelector == null ? ProxySelector.getDefault() : proxySelector;
            proxySelector = proxySelector == null ? sdk.pendo.io.p2.a.a : proxySelector;
        }
        this.proxySelector = proxySelector;
        this.proxyAuthenticator = builder.getProxyAuthenticator();
        this.socketFactory = builder.getSocketFactory();
        List<l> listI = builder.i();
        this.connectionSpecs = listI;
        this.protocols = builder.u();
        this.hostnameVerifier = builder.getHostnameVerifier();
        this.callTimeoutMillis = builder.getCallTimeout();
        this.connectTimeoutMillis = builder.getConnectTimeout();
        this.readTimeoutMillis = builder.getReadTimeout();
        this.writeTimeoutMillis = builder.getWriteTimeout();
        this.pingIntervalMillis = builder.getPingInterval();
        this.minWebSocketMessageToCompress = builder.getMinWebSocketMessageToCompress();
        sdk.pendo.io.j2.h routeDatabase = builder.getRouteDatabase();
        this.routeDatabase = routeDatabase == null ? new sdk.pendo.io.j2.h() : routeDatabase;
        if ((listI instanceof Collection) && listI.isEmpty()) {
            this.sslSocketFactoryOrNull = null;
            this.certificateChainCleaner = null;
            this.x509TrustManager = null;
            gVarA = g.d;
        } else {
            Iterator<T> it = listI.iterator();
            while (it.hasNext()) {
                if (((l) it.next()).getIsTls()) {
                    if (builder.getSslSocketFactoryOrNull() != null) {
                        this.sslSocketFactoryOrNull = builder.getSslSocketFactoryOrNull();
                        cVarA = builder.getCertificateChainCleaner();
                        Intrinsics.checkNotNull(cVarA);
                        this.certificateChainCleaner = cVarA;
                        X509TrustManager x509TrustManagerOrNull = builder.getX509TrustManagerOrNull();
                        Intrinsics.checkNotNull(x509TrustManagerOrNull);
                        this.x509TrustManager = x509TrustManagerOrNull;
                    } else {
                        sdk.pendo.io.n2.h.Companion companion = sdk.pendo.io.n2.h.INSTANCE;
                        X509TrustManager x509TrustManagerD = companion.d().d();
                        this.x509TrustManager = x509TrustManagerD;
                        sdk.pendo.io.n2.h hVarD = companion.d();
                        Intrinsics.checkNotNull(x509TrustManagerD);
                        this.sslSocketFactoryOrNull = hVarD.c(x509TrustManagerD);
                        sdk.pendo.io.q2.c.Companion companion2 = sdk.pendo.io.q2.c.INSTANCE;
                        Intrinsics.checkNotNull(x509TrustManagerD);
                        cVarA = companion2.a(x509TrustManagerD);
                        this.certificateChainCleaner = cVarA;
                    }
                    g certificatePinner = builder.getCertificatePinner();
                    Intrinsics.checkNotNull(cVarA);
                    gVarA = certificatePinner.a(cVarA);
                }
            }
            this.sslSocketFactoryOrNull = null;
            this.certificateChainCleaner = null;
            this.x509TrustManager = null;
            gVarA = g.d;
        }
        this.certificatePinner = gVarA;
        F();
    }

    @Override // sdk.pendo.io.e2.e.a
    public e a(b0 request) {
        Intrinsics.checkNotNullParameter(request, "request");
        return new sdk.pendo.io.j2.e(this, request, false);
    }

    @Override // sdk.pendo.io.e2.h0.a
    public h0 a(b0 request, i0 listener) {
        Intrinsics.checkNotNullParameter(request, "request");
        Intrinsics.checkNotNullParameter(listener, "listener");
        sdk.pendo.io.r2.d dVar = new sdk.pendo.io.r2.d(sdk.pendo.io.i2.e.i, request, listener, new Random(), this.pingIntervalMillis, null, this.minWebSocketMessageToCompress);
        dVar.a(this);
        return dVar;
    }
}
