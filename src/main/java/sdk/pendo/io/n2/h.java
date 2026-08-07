package sdk.pendo.io.n2;

import androidx.media3.exoplayer.upstream.CmcdData;
import com.box.androidsdk.content.models.BoxUser;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.microsoft.identity.common.java.providers.oauth2.IDToken;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.security.GeneralSecurityException;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.Security;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManager;
import javax.net.ssl.TrustManagerFactory;
import javax.net.ssl.X509TrustManager;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import sdk.pendo.io.e2.a0;
import sdk.pendo.io.e2.z;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000h\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0003\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0016\u0018\u0000 \u000f2\u00020\u0001:\u0001\u000fB\u0007¢\u0006\u0004\b#\u0010$J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0005\u001a\u00020\u0004H\u0016J-\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010\b2\u0011\u0010\r\u001a\r\u0012\t\u0012\u00070\u000b¢\u0006\u0002\b\f0\nH\u0016J\u0010\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0007\u001a\u00020\u0006H\u0016J\u0012\u0010\u0010\u001a\u0004\u0018\u00010\b2\u0006\u0010\u0007\u001a\u00020\u0006H\u0016J \u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0016\u001a\u00020\u0015H\u0016J&\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0017\u001a\u00020\b2\b\b\u0002\u0010\u0018\u001a\u00020\u00152\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u0019H\u0016J\u0010\u0010\u0010\u001a\u00020\u001b2\u0006\u0010\t\u001a\u00020\bH\u0016J\u0012\u0010\u000f\u001a\u0004\u0018\u00010\u00012\u0006\u0010\u001c\u001a\u00020\bH\u0016J\u001a\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0017\u001a\u00020\b2\b\u0010\u001d\u001a\u0004\u0018\u00010\u0001H\u0016J\u0010\u0010\u000f\u001a\u00020\u001f2\u0006\u0010\u001e\u001a\u00020\u0004H\u0016J\u0010\u0010\u0010\u001a\u00020 2\u0006\u0010\u001e\u001a\u00020\u0004H\u0016J\u0010\u0010\u0003\u001a\u00020!2\u0006\u0010\u001e\u001a\u00020\u0004H\u0016J\b\u0010\"\u001a\u00020\bH\u0016¨\u0006%"}, d2 = {"Lsdk/pendo/io/n2/h;", "", "Ljavax/net/ssl/SSLContext;", "c", "Ljavax/net/ssl/X509TrustManager;", "d", "Ljavax/net/ssl/SSLSocket;", "sslSocket", "", BoxUser.FIELD_HOSTNAME, "", "Lsdk/pendo/io/e2/a0;", "Lkotlin/jvm/JvmSuppressWildcards;", "protocols", "", CmcdData.OBJECT_TYPE_AUDIO_ONLY, "b", "Ljava/net/Socket;", "socket", "Ljava/net/InetSocketAddress;", IDToken.ADDRESS, "", "connectTimeout", "message", FirebaseAnalytics.Param.LEVEL, "", "t", "", "closer", "stackTrace", "trustManager", "Lsdk/pendo/io/q2/c;", "Lsdk/pendo/io/q2/e;", "Ljavax/net/ssl/SSLSocketFactory;", "toString", "<init>", "()V", "okhttp"}, k = 1, mv = {1, 8, 0})
public class h {

    /* JADX INFO: renamed from: a, reason: from kotlin metadata */
    public static final Companion INSTANCE;
    private static volatile h b;
    private static final Logger c;

    /* JADX INFO: renamed from: sdk.pendo.io.n2.h$a, reason: from kotlin metadata */
    @Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\u0010\u0012\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b \u0010!J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0004\u001a\u00020\u0002H\u0002J\b\u0010\u0005\u001a\u00020\u0002H\u0002J\b\u0010\u0006\u001a\u00020\u0002H\u0007J\u001a\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\n0\u00072\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\u0007J\u0014\u0010\u0005\u001a\u00020\u000b2\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\u0007R\u0014\u0010\u000f\u001a\u00020\f8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\r\u0010\u000eR\u0014\u0010\u0011\u001a\u00020\f8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0010\u0010\u000eR\u0014\u0010\u0013\u001a\u00020\f8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0012\u0010\u000eR\u0011\u0010\u0015\u001a\u00020\f8F¢\u0006\u0006\u001a\u0004\b\u0014\u0010\u000eR\u0014\u0010\u0017\u001a\u00020\u00168\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0017\u0010\u0018R\u0014\u0010\u0019\u001a\u00020\u00168\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0019\u0010\u0018R\u001c\u0010\u001c\u001a\n \u001b*\u0004\u0018\u00010\u001a0\u001a8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001c\u0010\u001dR\u0016\u0010\u001e\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001e\u0010\u001f¨\u0006\""}, d2 = {"Lsdk/pendo/io/n2/h$a;", "", "Lsdk/pendo/io/n2/h;", "c", CmcdData.OBJECT_TYPE_AUDIO_ONLY, "b", "d", "", "Lsdk/pendo/io/e2/a0;", "protocols", "", "", "", "g", "()Z", "isConscryptPreferred", CmcdData.STREAMING_FORMAT_HLS, "isOpenJSSEPreferred", "f", "isBouncyCastlePreferred", "e", "isAndroid", "", "INFO", "I", "WARN", "Ljava/util/logging/Logger;", "kotlin.jvm.PlatformType", "logger", "Ljava/util/logging/Logger;", "platform", "Lsdk/pendo/io/n2/h;", "<init>", "()V", "okhttp"}, k = 1, mv = {1, 8, 0})
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final h c() {
            return e() ? a() : b();
        }

        private final boolean f() {
            return Intrinsics.areEqual("BC", Security.getProviders()[0].getName());
        }

        private final boolean g() {
            return Intrinsics.areEqual("Conscrypt", Security.getProviders()[0].getName());
        }

        private final boolean h() {
            return Intrinsics.areEqual("OpenJSSE", Security.getProviders()[0].getName());
        }

        public final byte[] b(List<? extends a0> protocols) {
            Intrinsics.checkNotNullParameter(protocols, "protocols");
            sdk.pendo.io.s2.d dVar = new sdk.pendo.io.s2.d();
            for (String str : a(protocols)) {
                dVar.writeByte(str.length());
                dVar.writeUtf8(str);
            }
            return dVar.readByteArray();
        }

        @JvmStatic
        public final h d() {
            return h.b;
        }

        public final boolean e() {
            return Intrinsics.areEqual("Dalvik", System.getProperty("java.vm.name"));
        }

        private final h b() {
            g gVarA;
            c cVarA;
            d dVarA;
            if (g() && (dVarA = d.INSTANCE.a()) != null) {
                return dVarA;
            }
            if (f() && (cVarA = c.INSTANCE.a()) != null) {
                return cVarA;
            }
            if (h() && (gVarA = g.INSTANCE.a()) != null) {
                return gVarA;
            }
            f fVarA = f.INSTANCE.a();
            if (fVarA != null) {
                return fVarA;
            }
            h hVarA = e.INSTANCE.a();
            return hVarA != null ? hVarA : new h();
        }

        public final List<String> a(List<? extends a0> protocols) {
            Intrinsics.checkNotNullParameter(protocols, "protocols");
            ArrayList arrayList = new ArrayList();
            for (Object obj : protocols) {
                if (((a0) obj) != a0.HTTP_1_0) {
                    arrayList.add(obj);
                }
            }
            ArrayList arrayList2 = new ArrayList(CollectionsKt.collectionSizeOrDefault(arrayList, 10));
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                arrayList2.add(((a0) it.next()).getProtocol());
            }
            return arrayList2;
        }

        private final h a() {
            sdk.pendo.io.o2.c.a.a();
            h hVarA = a.INSTANCE.a();
            if (hVarA != null) {
                return hVarA;
            }
            h hVarA2 = b.f.a();
            Intrinsics.checkNotNull(hVarA2);
            return hVarA2;
        }
    }

    static {
        Companion companion = new Companion(null);
        INSTANCE = companion;
        b = companion.c();
        c = Logger.getLogger(z.class.getName());
    }

    public sdk.pendo.io.q2.e b(X509TrustManager trustManager) {
        Intrinsics.checkNotNullParameter(trustManager, "trustManager");
        X509Certificate[] acceptedIssuers = trustManager.getAcceptedIssuers();
        Intrinsics.checkNotNullExpressionValue(acceptedIssuers, "trustManager.acceptedIssuers");
        return new sdk.pendo.io.q2.b((X509Certificate[]) Arrays.copyOf(acceptedIssuers, acceptedIssuers.length));
    }

    public SSLContext c() throws NoSuchAlgorithmException {
        SSLContext sSLContext = SSLContext.getInstance("TLS");
        Intrinsics.checkNotNullExpressionValue(sSLContext, "getInstance(\"TLS\")");
        return sSLContext;
    }

    public X509TrustManager d() throws NoSuchAlgorithmException, KeyStoreException {
        TrustManagerFactory trustManagerFactory = TrustManagerFactory.getInstance(TrustManagerFactory.getDefaultAlgorithm());
        trustManagerFactory.init((KeyStore) null);
        TrustManager[] trustManagers = trustManagerFactory.getTrustManagers();
        Intrinsics.checkNotNull(trustManagers);
        if (trustManagers.length == 1) {
            TrustManager trustManager = trustManagers[0];
            if (trustManager instanceof X509TrustManager) {
                Intrinsics.checkNotNull(trustManager, "null cannot be cast to non-null type javax.net.ssl.X509TrustManager");
                return (X509TrustManager) trustManager;
            }
        }
        StringBuilder sb = new StringBuilder("Unexpected default trust managers: ");
        String string = Arrays.toString(trustManagers);
        Intrinsics.checkNotNullExpressionValue(string, "toString(this)");
        throw new IllegalStateException(sb.append(string).toString().toString());
    }

    public String toString() {
        String simpleName = getClass().getSimpleName();
        Intrinsics.checkNotNullExpressionValue(simpleName, "javaClass.simpleName");
        return simpleName;
    }

    @JvmStatic
    public static final h b() {
        return INSTANCE.d();
    }

    public void a(SSLSocket sslSocket) {
        Intrinsics.checkNotNullParameter(sslSocket, "sslSocket");
    }

    public SSLSocketFactory c(X509TrustManager trustManager) {
        Intrinsics.checkNotNullParameter(trustManager, "trustManager");
        try {
            SSLContext sSLContextC = c();
            sSLContextC.init(null, new TrustManager[]{trustManager}, null);
            SSLSocketFactory socketFactory = sSLContextC.getSocketFactory();
            Intrinsics.checkNotNullExpressionValue(socketFactory, "newSSLContext().apply {\n…ll)\n      }.socketFactory");
            return socketFactory;
        } catch (GeneralSecurityException e) {
            throw new AssertionError("No System TLS: " + e, e);
        }
    }

    public sdk.pendo.io.q2.c a(X509TrustManager trustManager) {
        Intrinsics.checkNotNullParameter(trustManager, "trustManager");
        return new sdk.pendo.io.q2.a(b(trustManager));
    }

    public String b(SSLSocket sslSocket) {
        Intrinsics.checkNotNullParameter(sslSocket, "sslSocket");
        return null;
    }

    public void a(SSLSocket sslSocket, String hostname, List<a0> protocols) {
        Intrinsics.checkNotNullParameter(sslSocket, "sslSocket");
        Intrinsics.checkNotNullParameter(protocols, "protocols");
    }

    public boolean b(String hostname) {
        Intrinsics.checkNotNullParameter(hostname, "hostname");
        return true;
    }

    public void a(Socket socket, InetSocketAddress address, int connectTimeout) throws IOException {
        Intrinsics.checkNotNullParameter(socket, "socket");
        Intrinsics.checkNotNullParameter(address, "address");
        socket.connect(address, connectTimeout);
    }

    public Object a(String closer) {
        Intrinsics.checkNotNullParameter(closer, "closer");
        if (c.isLoggable(Level.FINE)) {
            return new Throwable(closer);
        }
        return null;
    }

    public void a(String message, int level, Throwable t) {
        Intrinsics.checkNotNullParameter(message, "message");
        c.log(level == 5 ? Level.WARNING : Level.INFO, message, t);
    }

    public static /* synthetic */ void a(h hVar, String str, int i, Throwable th, int i2, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: log");
        }
        if ((i2 & 2) != 0) {
            i = 4;
        }
        if ((i2 & 4) != 0) {
            th = null;
        }
        hVar.a(str, i, th);
    }

    public void a(String message, Object stackTrace) {
        Intrinsics.checkNotNullParameter(message, "message");
        if (stackTrace == null) {
            message = message + " To see where this was allocated, set the OkHttpClient logger level to FINE: Logger.getLogger(OkHttpClient.class.getName()).setLevel(Level.FINE);";
        }
        a(message, 5, (Throwable) stackTrace);
    }
}
