package sdk.pendo.io.n2;

import android.security.NetworkSecurityPolicy;
import androidx.media3.exoplayer.upstream.CmcdData;
import com.box.androidsdk.content.models.BoxUser;
import com.microsoft.identity.common.java.providers.oauth2.IDToken;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.security.cert.TrustAnchor;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.X509TrustManager;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import sdk.pendo.io.e2.a0;
import sdk.pendo.io.o2.i;
import sdk.pendo.io.o2.j;
import sdk.pendo.io.o2.k;
import sdk.pendo.io.o2.l;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0007\u0018\u0000 &2\u00020\u0001:\u0002\t\u0012B\u0007¢\u0006\u0004\b$\u0010%J \u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016J-\u0010\t\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\n2\b\u0010\r\u001a\u0004\u0018\u00010\f2\u0011\u0010\u0011\u001a\r\u0012\t\u0012\u00070\u000f¢\u0006\u0002\b\u00100\u000eH\u0016J\u0012\u0010\u0012\u001a\u0004\u0018\u00010\f2\u0006\u0010\u000b\u001a\u00020\nH\u0016J\u0012\u0010\t\u001a\u0004\u0018\u00010\u00142\u0006\u0010\u0013\u001a\u00020\fH\u0016J\u001a\u0010\t\u001a\u00020\b2\u0006\u0010\u0015\u001a\u00020\f2\b\u0010\u0016\u001a\u0004\u0018\u00010\u0014H\u0016J\u0010\u0010\u0012\u001a\u00020\u00172\u0006\u0010\r\u001a\u00020\fH\u0016J\u0010\u0010\t\u001a\u00020\u001a2\u0006\u0010\u0019\u001a\u00020\u0018H\u0016J\u0010\u0010\u0012\u001a\u00020\u001b2\u0006\u0010\u0019\u001a\u00020\u0018H\u0016R\u001a\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u001c0\u000e8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001d\u0010\u001eR\u0014\u0010#\u001a\u00020 8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b!\u0010\"¨\u0006'"}, d2 = {"Lsdk/pendo/io/n2/b;", "Lsdk/pendo/io/n2/h;", "Ljava/net/Socket;", "socket", "Ljava/net/InetSocketAddress;", IDToken.ADDRESS, "", "connectTimeout", "", CmcdData.OBJECT_TYPE_AUDIO_ONLY, "Ljavax/net/ssl/SSLSocket;", "sslSocket", "", BoxUser.FIELD_HOSTNAME, "", "Lsdk/pendo/io/e2/a0;", "Lkotlin/jvm/JvmSuppressWildcards;", "protocols", "b", "closer", "", "message", "stackTrace", "", "Ljavax/net/ssl/X509TrustManager;", "trustManager", "Lsdk/pendo/io/q2/c;", "Lsdk/pendo/io/q2/e;", "Lsdk/pendo/io/o2/k;", "d", "Ljava/util/List;", "socketAdapters", "Lsdk/pendo/io/o2/h;", "e", "Lsdk/pendo/io/o2/h;", "closeGuard", "<init>", "()V", "f", "okhttp"}, k = 1, mv = {1, 8, 0})
public final class b extends h {

    /* JADX INFO: renamed from: f, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final boolean g;

    /* JADX INFO: renamed from: d, reason: from kotlin metadata */
    private final List<k> socketAdapters;

    /* JADX INFO: renamed from: e, reason: from kotlin metadata */
    private final sdk.pendo.io.o2.h closeGuard;

    /* JADX INFO: renamed from: sdk.pendo.io.n2.b$a, reason: from kotlin metadata */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\t\u0010\nJ\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002R\u0017\u0010\u0005\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0007\u0010\b¨\u0006\u000b"}, d2 = {"Lsdk/pendo/io/n2/b$a;", "", "Lsdk/pendo/io/n2/h;", CmcdData.OBJECT_TYPE_AUDIO_ONLY, "", "isSupported", "Z", "b", "()Z", "<init>", "()V", "okhttp"}, k = 1, mv = {1, 8, 0})
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final h a() {
            if (b()) {
                return new b();
            }
            return null;
        }

        public final boolean b() {
            return b.g;
        }
    }

    /* JADX INFO: renamed from: sdk.pendo.io.n2.b$b, reason: collision with other inner class name */
    @Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0080\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0010\u001a\u00020\r\u0012\u0006\u0010\u0014\u001a\u00020\u0011¢\u0006\u0004\b\u0015\u0010\u0016J\u0012\u0010\u0004\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\t\u0010\u0006\u001a\u00020\u0005HÖ\u0001J\t\u0010\b\u001a\u00020\u0007HÖ\u0001J\u0013\u0010\f\u001a\u00020\u000b2\b\u0010\n\u001a\u0004\u0018\u00010\tHÖ\u0003R\u0014\u0010\u0010\u001a\u00020\r8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000e\u0010\u000fR\u0014\u0010\u0014\u001a\u00020\u00118\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0012\u0010\u0013¨\u0006\u0017"}, d2 = {"Lsdk/pendo/io/n2/b$b;", "Lsdk/pendo/io/q2/e;", "Ljava/security/cert/X509Certificate;", "cert", "findByIssuerAndSignature", "", "toString", "", "hashCode", "", "other", "", "equals", "Ljavax/net/ssl/X509TrustManager;", CmcdData.OBJECT_TYPE_AUDIO_ONLY, "Ljavax/net/ssl/X509TrustManager;", "trustManager", "Ljava/lang/reflect/Method;", "b", "Ljava/lang/reflect/Method;", "findByIssuerAndSignatureMethod", "<init>", "(Ljavax/net/ssl/X509TrustManager;Ljava/lang/reflect/Method;)V", "okhttp"}, k = 1, mv = {1, 8, 0})
    public static final /* data */ class C0427b implements sdk.pendo.io.q2.e {

        /* JADX INFO: renamed from: a, reason: from kotlin metadata */
        private final X509TrustManager trustManager;

        /* JADX INFO: renamed from: b, reason: from kotlin metadata */
        private final Method findByIssuerAndSignatureMethod;

        public C0427b(X509TrustManager trustManager, Method findByIssuerAndSignatureMethod) {
            Intrinsics.checkNotNullParameter(trustManager, "trustManager");
            Intrinsics.checkNotNullParameter(findByIssuerAndSignatureMethod, "findByIssuerAndSignatureMethod");
            this.trustManager = trustManager;
            this.findByIssuerAndSignatureMethod = findByIssuerAndSignatureMethod;
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof C0427b)) {
                return false;
            }
            C0427b c0427b = (C0427b) other;
            return Intrinsics.areEqual(this.trustManager, c0427b.trustManager) && Intrinsics.areEqual(this.findByIssuerAndSignatureMethod, c0427b.findByIssuerAndSignatureMethod);
        }

        @Override // sdk.pendo.io.q2.e
        public X509Certificate findByIssuerAndSignature(X509Certificate cert) {
            Intrinsics.checkNotNullParameter(cert, "cert");
            try {
                Object objInvoke = this.findByIssuerAndSignatureMethod.invoke(this.trustManager, cert);
                Intrinsics.checkNotNull(objInvoke, "null cannot be cast to non-null type java.security.cert.TrustAnchor");
                return ((TrustAnchor) objInvoke).getTrustedCert();
            } catch (IllegalAccessException e) {
                throw new AssertionError("unable to get issues and signature", e);
            } catch (InvocationTargetException unused) {
                return null;
            }
        }

        public int hashCode() {
            return (this.trustManager.hashCode() * 31) + this.findByIssuerAndSignatureMethod.hashCode();
        }

        public String toString() {
            return "CustomTrustRootIndex(trustManager=" + this.trustManager + ", findByIssuerAndSignatureMethod=" + this.findByIssuerAndSignatureMethod + ')';
        }
    }

    static {
        h.INSTANCE.e();
        g = false;
    }

    public b() {
        List listListOfNotNull = CollectionsKt.listOfNotNull((Object[]) new k[]{l.Companion.a(l.INSTANCE, null, 1, null), new j(sdk.pendo.io.o2.f.INSTANCE.a()), new j(i.INSTANCE.a()), new j(sdk.pendo.io.o2.g.INSTANCE.a())});
        ArrayList arrayList = new ArrayList();
        for (Object obj : listListOfNotNull) {
            if (((k) obj).isSupported()) {
                arrayList.add(obj);
            }
        }
        this.socketAdapters = arrayList;
        this.closeGuard = sdk.pendo.io.o2.h.INSTANCE.a();
    }

    @Override // sdk.pendo.io.n2.h
    public sdk.pendo.io.q2.c a(X509TrustManager trustManager) {
        Intrinsics.checkNotNullParameter(trustManager, "trustManager");
        sdk.pendo.io.o2.b bVarA = sdk.pendo.io.o2.b.INSTANCE.a(trustManager);
        return bVarA != null ? bVarA : super.a(trustManager);
    }

    @Override // sdk.pendo.io.n2.h
    public sdk.pendo.io.q2.e b(X509TrustManager trustManager) {
        Intrinsics.checkNotNullParameter(trustManager, "trustManager");
        try {
            Method method = trustManager.getClass().getDeclaredMethod("findTrustAnchorByIssuerAndSignature", X509Certificate.class);
            method.setAccessible(true);
            Intrinsics.checkNotNullExpressionValue(method, "method");
            return new C0427b(trustManager, method);
        } catch (NoSuchMethodException unused) {
            return super.b(trustManager);
        }
    }

    @Override // sdk.pendo.io.n2.h
    public void a(SSLSocket sslSocket, String hostname, List<a0> protocols) {
        Object next;
        Intrinsics.checkNotNullParameter(sslSocket, "sslSocket");
        Intrinsics.checkNotNullParameter(protocols, "protocols");
        Iterator<T> it = this.socketAdapters.iterator();
        do {
            if (!it.hasNext()) {
                next = null;
                break;
            }
            next = it.next();
        } while (!((k) next).matchesSocket(sslSocket));
        k kVar = (k) next;
        if (kVar != null) {
            kVar.configureTlsExtensions(sslSocket, hostname, protocols);
        }
    }

    @Override // sdk.pendo.io.n2.h
    public String b(SSLSocket sslSocket) {
        Object next;
        Intrinsics.checkNotNullParameter(sslSocket, "sslSocket");
        Iterator<T> it = this.socketAdapters.iterator();
        do {
            if (!it.hasNext()) {
                next = null;
                break;
            }
            next = it.next();
        } while (!((k) next).matchesSocket(sslSocket));
        k kVar = (k) next;
        if (kVar != null) {
            return kVar.getSelectedProtocol(sslSocket);
        }
        return null;
    }

    @Override // sdk.pendo.io.n2.h
    public void a(Socket socket, InetSocketAddress address, int connectTimeout) throws IOException {
        Intrinsics.checkNotNullParameter(socket, "socket");
        Intrinsics.checkNotNullParameter(address, "address");
        socket.connect(address, connectTimeout);
    }

    @Override // sdk.pendo.io.n2.h
    public boolean b(String hostname) {
        Intrinsics.checkNotNullParameter(hostname, "hostname");
        return NetworkSecurityPolicy.getInstance().isCleartextTrafficPermitted(hostname);
    }

    @Override // sdk.pendo.io.n2.h
    public Object a(String closer) {
        Intrinsics.checkNotNullParameter(closer, "closer");
        return this.closeGuard.a(closer);
    }

    @Override // sdk.pendo.io.n2.h
    public void a(String message, Object stackTrace) {
        Intrinsics.checkNotNullParameter(message, "message");
        if (this.closeGuard.a(stackTrace)) {
            return;
        }
        h.a(this, message, 5, null, 4, null);
    }
}
