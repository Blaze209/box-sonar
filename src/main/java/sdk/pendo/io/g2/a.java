package sdk.pendo.io.g2;

import androidx.media3.exoplayer.upstream.CmcdData;
import java.net.Authenticator;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.PasswordAuthentication;
import java.net.Proxy;
import java.net.SocketAddress;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import sdk.pendo.io.e2.b;
import sdk.pendo.io.e2.b0;
import sdk.pendo.io.e2.d0;
import sdk.pendo.io.e2.f0;
import sdk.pendo.io.e2.h;
import sdk.pendo.io.e2.o;
import sdk.pendo.io.e2.q;
import sdk.pendo.io.e2.v;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0011\u0012\b\b\u0002\u0010\u0010\u001a\u00020\u0005¢\u0006\u0004\b\u0011\u0010\u0012J\u001c\u0010\b\u001a\u00020\u0007*\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0005H\u0002J\u001c\u0010\b\u001a\u0004\u0018\u00010\r2\b\u0010\n\u001a\u0004\u0018\u00010\t2\u0006\u0010\f\u001a\u00020\u000bH\u0016R\u0014\u0010\u0010\u001a\u00020\u00058\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000e\u0010\u000f¨\u0006\u0013"}, d2 = {"Lsdk/pendo/io/g2/a;", "Lsdk/pendo/io/e2/b;", "Ljava/net/Proxy;", "Lsdk/pendo/io/e2/v;", "url", "Lsdk/pendo/io/e2/q;", "dns", "Ljava/net/InetAddress;", CmcdData.OBJECT_TYPE_AUDIO_ONLY, "Lsdk/pendo/io/e2/f0;", "route", "Lsdk/pendo/io/e2/d0;", "response", "Lsdk/pendo/io/e2/b0;", "d", "Lsdk/pendo/io/e2/q;", "defaultDns", "<init>", "(Lokhttp3/Dns;)V", "okhttp"}, k = 1, mv = {1, 8, 0})
public final class a implements b {

    /* JADX INFO: renamed from: d, reason: from kotlin metadata */
    private final q defaultDns;

    /* JADX INFO: renamed from: sdk.pendo.io.g2.a$a, reason: collision with other inner class name */
    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    public /* synthetic */ class C0387a {
        public static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[Proxy.Type.values().length];
            try {
                iArr[Proxy.Type.DIRECT.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            a = iArr;
        }
    }

    public a(q defaultDns) {
        Intrinsics.checkNotNullParameter(defaultDns, "defaultDns");
        this.defaultDns = defaultDns;
    }

    @Override // sdk.pendo.io.e2.b
    public b0 a(f0 route, d0 response) {
        Proxy proxy;
        q dns;
        PasswordAuthentication passwordAuthenticationRequestPasswordAuthentication;
        sdk.pendo.io.e2.a address;
        Intrinsics.checkNotNullParameter(response, "response");
        List<h> listE = response.e();
        b0 request = response.getRequest();
        v vVarI = request.i();
        boolean z = response.getCode() == 407;
        if (route == null || (proxy = route.getProxy()) == null) {
            proxy = Proxy.NO_PROXY;
        }
        for (h hVar : listE) {
            if (StringsKt.equals("Basic", hVar.getScheme(), true)) {
                if (route == null || (address = route.getAddress()) == null || (dns = address.getDns()) == null) {
                    dns = this.defaultDns;
                }
                if (z) {
                    SocketAddress socketAddressAddress = proxy.address();
                    Intrinsics.checkNotNull(socketAddressAddress, "null cannot be cast to non-null type java.net.InetSocketAddress");
                    InetSocketAddress inetSocketAddress = (InetSocketAddress) socketAddressAddress;
                    String hostName = inetSocketAddress.getHostName();
                    Intrinsics.checkNotNullExpressionValue(proxy, "proxy");
                    passwordAuthenticationRequestPasswordAuthentication = Authenticator.requestPasswordAuthentication(hostName, a(proxy, vVarI, dns), inetSocketAddress.getPort(), vVarI.getScheme(), hVar.b(), hVar.getScheme(), vVarI.q(), Authenticator.RequestorType.PROXY);
                } else {
                    String host = vVarI.getHost();
                    Intrinsics.checkNotNullExpressionValue(proxy, "proxy");
                    passwordAuthenticationRequestPasswordAuthentication = Authenticator.requestPasswordAuthentication(host, a(proxy, vVarI, dns), vVarI.getPort(), vVarI.getScheme(), hVar.b(), hVar.getScheme(), vVarI.q(), Authenticator.RequestorType.SERVER);
                }
                if (passwordAuthenticationRequestPasswordAuthentication != null) {
                    String str = z ? "Proxy-Authorization" : "Authorization";
                    String userName = passwordAuthenticationRequestPasswordAuthentication.getUserName();
                    Intrinsics.checkNotNullExpressionValue(userName, "auth.userName");
                    char[] password = passwordAuthenticationRequestPasswordAuthentication.getPassword();
                    Intrinsics.checkNotNullExpressionValue(password, "auth.password");
                    return request.h().b(str, o.a(userName, new String(password), hVar.a())).a();
                }
            }
        }
        return null;
    }

    public /* synthetic */ a(q qVar, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? q.b : qVar);
    }

    private final InetAddress a(Proxy proxy, v vVar, q qVar) {
        Proxy.Type type = proxy.type();
        if ((type == null ? -1 : C0387a.a[type.ordinal()]) == 1) {
            return (InetAddress) CollectionsKt.first((List) qVar.lookup(vVar.getHost()));
        }
        SocketAddress socketAddressAddress = proxy.address();
        Intrinsics.checkNotNull(socketAddressAddress, "null cannot be cast to non-null type java.net.InetSocketAddress");
        InetAddress address = ((InetSocketAddress) socketAddressAddress).getAddress();
        Intrinsics.checkNotNullExpressionValue(address, "address() as InetSocketAddress).address");
        return address;
    }
}
