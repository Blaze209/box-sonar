package sdk.pendo.io.j2;

import androidx.core.app.NotificationCompat;
import androidx.media3.exoplayer.upstream.CmcdData;
import com.microsoft.identity.common.java.providers.oauth2.IDToken;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.net.SocketAddress;
import java.net.SocketException;
import java.net.URI;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;
import sdk.pendo.io.e2.f0;
import sdk.pendo.io.e2.r;
import sdk.pendo.io.e2.v;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000l\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 *2\u00020\u0001:\u0002\u0007\tB'\u0012\u0006\u0010\u000f\u001a\u00020\r\u0012\u0006\u0010\u0012\u001a\u00020\u0010\u0012\u0006\u0010\u0015\u001a\u00020\u0013\u0012\u0006\u0010\u0018\u001a\u00020\u0016¢\u0006\u0004\b(\u0010)J\u001a\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0002J\b\u0010\t\u001a\u00020\bH\u0002J\b\u0010\n\u001a\u00020\u0004H\u0002J\u0010\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\t\u0010\u0007\u001a\u00020\bH\u0086\u0002J\t\u0010\f\u001a\u00020\u000bH\u0086\u0002R\u0014\u0010\u000f\u001a\u00020\r8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0007\u0010\u000eR\u0014\u0010\u0012\u001a\u00020\u00108\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\t\u0010\u0011R\u0014\u0010\u0015\u001a\u00020\u00138\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\f\u0010\u0014R\u0014\u0010\u0018\u001a\u00020\u00168\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\n\u0010\u0017R\u001c\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u00040\u00198\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001a\u0010\u001bR\u0016\u0010 \u001a\u00020\u001d8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001e\u0010\u001fR\u001c\u0010#\u001a\b\u0012\u0004\u0012\u00020!0\u00198\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\"\u0010\u001bR\u001a\u0010'\u001a\b\u0012\u0004\u0012\u00020%0$8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b&\u0010\u001b¨\u0006+"}, d2 = {"Lsdk/pendo/io/j2/j;", "", "Lsdk/pendo/io/e2/v;", "url", "Ljava/net/Proxy;", "proxy", "", CmcdData.OBJECT_TYPE_AUDIO_ONLY, "", "b", "d", "Lsdk/pendo/io/j2/j$b;", "c", "Lsdk/pendo/io/e2/a;", "Lsdk/pendo/io/e2/a;", IDToken.ADDRESS, "Lsdk/pendo/io/j2/h;", "Lsdk/pendo/io/j2/h;", "routeDatabase", "Lsdk/pendo/io/e2/e;", "Lsdk/pendo/io/e2/e;", NotificationCompat.CATEGORY_CALL, "Lsdk/pendo/io/e2/r;", "Lsdk/pendo/io/e2/r;", "eventListener", "", "e", "Ljava/util/List;", "proxies", "", "f", "I", "nextProxyIndex", "Ljava/net/InetSocketAddress;", "g", "inetSocketAddresses", "", "Lsdk/pendo/io/e2/f0;", CmcdData.STREAMING_FORMAT_HLS, "postponedRoutes", "<init>", "(Lokhttp3/Address;Lokhttp3/internal/connection/RouteDatabase;Lokhttp3/Call;Lokhttp3/EventListener;)V", "i", "okhttp"}, k = 1, mv = {1, 8, 0})
public final class j {

    /* JADX INFO: renamed from: i, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* JADX INFO: renamed from: a, reason: from kotlin metadata */
    private final sdk.pendo.io.e2.a address;

    /* JADX INFO: renamed from: b, reason: from kotlin metadata */
    private final h routeDatabase;

    /* JADX INFO: renamed from: c, reason: from kotlin metadata */
    private final sdk.pendo.io.e2.e call;

    /* JADX INFO: renamed from: d, reason: from kotlin metadata */
    private final r eventListener;

    /* JADX INFO: renamed from: e, reason: from kotlin metadata */
    private List<? extends Proxy> proxies;

    /* JADX INFO: renamed from: f, reason: from kotlin metadata */
    private int nextProxyIndex;

    /* JADX INFO: renamed from: g, reason: from kotlin metadata */
    private List<? extends InetSocketAddress> inetSocketAddresses;

    /* JADX INFO: renamed from: h, reason: from kotlin metadata */
    private final List<f0> postponedRoutes;

    /* JADX INFO: renamed from: sdk.pendo.io.j2.j$a, reason: from kotlin metadata */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0007\u0010\bR\u0015\u0010\u0006\u001a\u00020\u0003*\u00020\u00028F¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005¨\u0006\t"}, d2 = {"Lsdk/pendo/io/j2/j$a;", "", "Ljava/net/InetSocketAddress;", "", CmcdData.OBJECT_TYPE_AUDIO_ONLY, "(Ljava/net/InetSocketAddress;)Ljava/lang/String;", "socketHost", "<init>", "()V", "okhttp"}, k = 1, mv = {1, 8, 0})
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final String a(InetSocketAddress inetSocketAddress) {
            String hostAddress;
            String str;
            Intrinsics.checkNotNullParameter(inetSocketAddress, "<this>");
            InetAddress address = inetSocketAddress.getAddress();
            if (address == null) {
                hostAddress = inetSocketAddress.getHostName();
                str = "hostName";
            } else {
                hostAddress = address.getHostAddress();
                str = "address.hostAddress";
            }
            Intrinsics.checkNotNullExpressionValue(hostAddress, str);
            return hostAddress;
        }
    }

    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0015\u0012\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00040\u0006¢\u0006\u0004\b\u000e\u0010\u000fJ\t\u0010\u0003\u001a\u00020\u0002H\u0086\u0002J\t\u0010\u0005\u001a\u00020\u0004H\u0086\u0002R\u001d\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00040\u00068\u0006¢\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\u0007\u0010\tR\u0016\u0010\r\u001a\u00020\u000b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0003\u0010\f¨\u0006\u0010"}, d2 = {"Lsdk/pendo/io/j2/j$b;", "", "", "b", "Lsdk/pendo/io/e2/f0;", "c", "", CmcdData.OBJECT_TYPE_AUDIO_ONLY, "Ljava/util/List;", "()Ljava/util/List;", "routes", "", "I", "nextRouteIndex", "<init>", "(Ljava/util/List;)V", "okhttp"}, k = 1, mv = {1, 8, 0})
    public static final class b {

        /* JADX INFO: renamed from: a, reason: from kotlin metadata */
        private final List<f0> routes;

        /* JADX INFO: renamed from: b, reason: from kotlin metadata */
        private int nextRouteIndex;

        public b(List<f0> routes) {
            Intrinsics.checkNotNullParameter(routes, "routes");
            this.routes = routes;
        }

        public final List<f0> a() {
            return this.routes;
        }

        public final boolean b() {
            return this.nextRouteIndex < this.routes.size();
        }

        public final f0 c() {
            if (!b()) {
                throw new NoSuchElementException();
            }
            List<f0> list = this.routes;
            int i = this.nextRouteIndex;
            this.nextRouteIndex = i + 1;
            return list.get(i);
        }
    }

    public j(sdk.pendo.io.e2.a address, h routeDatabase, sdk.pendo.io.e2.e call, r eventListener) {
        Intrinsics.checkNotNullParameter(address, "address");
        Intrinsics.checkNotNullParameter(routeDatabase, "routeDatabase");
        Intrinsics.checkNotNullParameter(call, "call");
        Intrinsics.checkNotNullParameter(eventListener, "eventListener");
        this.address = address;
        this.routeDatabase = routeDatabase;
        this.call = call;
        this.eventListener = eventListener;
        this.proxies = CollectionsKt.emptyList();
        this.inetSocketAddresses = CollectionsKt.emptyList();
        this.postponedRoutes = new ArrayList();
        a(address.getUrl(), address.getProxy());
    }

    private final boolean b() {
        return this.nextProxyIndex < this.proxies.size();
    }

    private final Proxy d() throws SocketException, UnknownHostException {
        if (!b()) {
            throw new SocketException("No route to " + this.address.getUrl().getHost() + "; exhausted proxy configurations: " + this.proxies);
        }
        List<? extends Proxy> list = this.proxies;
        int i = this.nextProxyIndex;
        this.nextProxyIndex = i + 1;
        Proxy proxy = list.get(i);
        a(proxy);
        return proxy;
    }

    public final boolean a() {
        return b() || !this.postponedRoutes.isEmpty();
    }

    public final b c() {
        if (!a()) {
            throw new NoSuchElementException();
        }
        ArrayList arrayList = new ArrayList();
        while (b()) {
            Proxy proxyD = d();
            Iterator<? extends InetSocketAddress> it = this.inetSocketAddresses.iterator();
            while (it.hasNext()) {
                f0 f0Var = new f0(this.address, proxyD, it.next());
                if (this.routeDatabase.c(f0Var)) {
                    this.postponedRoutes.add(f0Var);
                } else {
                    arrayList.add(f0Var);
                }
            }
            if (!arrayList.isEmpty()) {
                break;
            }
        }
        if (arrayList.isEmpty()) {
            CollectionsKt.addAll(arrayList, this.postponedRoutes);
            this.postponedRoutes.clear();
        }
        return new b(arrayList);
    }

    private final void a(Proxy proxy) throws SocketException, UnknownHostException {
        String host;
        int port;
        List<InetAddress> listListOf;
        ArrayList arrayList = new ArrayList();
        this.inetSocketAddresses = arrayList;
        if (proxy.type() == Proxy.Type.DIRECT || proxy.type() == Proxy.Type.SOCKS) {
            host = this.address.getUrl().getHost();
            port = this.address.getUrl().getPort();
        } else {
            SocketAddress proxyAddress = proxy.address();
            if (!(proxyAddress instanceof InetSocketAddress)) {
                throw new IllegalArgumentException(("Proxy.address() is not an InetSocketAddress: " + proxyAddress.getClass()).toString());
            }
            Companion companion = INSTANCE;
            Intrinsics.checkNotNullExpressionValue(proxyAddress, "proxyAddress");
            InetSocketAddress inetSocketAddress = (InetSocketAddress) proxyAddress;
            host = companion.a(inetSocketAddress);
            port = inetSocketAddress.getPort();
        }
        if (1 > port || port >= 65536) {
            throw new SocketException("No route to " + host + AbstractJsonLexerKt.COLON + port + "; port is out of range");
        }
        if (proxy.type() == Proxy.Type.SOCKS) {
            arrayList.add(InetSocketAddress.createUnresolved(host, port));
            return;
        }
        if (sdk.pendo.io.f2.b.a(host)) {
            listListOf = CollectionsKt.listOf(InetAddress.getByName(host));
        } else {
            this.eventListener.a(this.call, host);
            List<InetAddress> listLookup = this.address.getDns().lookup(host);
            if (listLookup.isEmpty()) {
                throw new UnknownHostException(this.address.getDns() + " returned no addresses for " + host);
            }
            this.eventListener.a(this.call, host, listLookup);
            listListOf = listLookup;
        }
        Iterator<InetAddress> it = listListOf.iterator();
        while (it.hasNext()) {
            arrayList.add(new InetSocketAddress(it.next(), port));
        }
    }

    private final void a(v url, Proxy proxy) {
        this.eventListener.a(this.call, url);
        List<Proxy> listA = a(proxy, url, this);
        this.proxies = listA;
        this.nextProxyIndex = 0;
        this.eventListener.a(this.call, url, listA);
    }

    private static final List<Proxy> a(Proxy proxy, v vVar, j jVar) {
        if (proxy != null) {
            return CollectionsKt.listOf(proxy);
        }
        URI uriP = vVar.p();
        if (uriP.getHost() == null) {
            return sdk.pendo.io.f2.b.a(Proxy.NO_PROXY);
        }
        List<Proxy> proxiesOrNull = jVar.address.getProxySelector().select(uriP);
        if (proxiesOrNull == null || proxiesOrNull.isEmpty()) {
            return sdk.pendo.io.f2.b.a(Proxy.NO_PROXY);
        }
        Intrinsics.checkNotNullExpressionValue(proxiesOrNull, "proxiesOrNull");
        return sdk.pendo.io.f2.b.b(proxiesOrNull);
    }
}
