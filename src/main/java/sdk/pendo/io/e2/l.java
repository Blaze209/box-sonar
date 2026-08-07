package sdk.pendo.io.e2;

import androidx.media3.exoplayer.upstream.CmcdData;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;
import javax.net.ssl.SSLSocket;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.comparisons.ComparisonsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u0011\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 #2\u00020\u0001:\u0002\b\u0006B9\b\u0000\u0012\u0006\u0010\u0013\u001a\u00020\u0004\u0012\u0006\u0010\u0015\u001a\u00020\u0004\u0012\u000e\u0010\u0018\u001a\n\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u0016\u0012\u000e\u0010\u001a\u001a\n\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u0016¢\u0006\u0004\b!\u0010\"J\u0018\u0010\u0006\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u001f\u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0000¢\u0006\u0004\b\b\u0010\tJ\u000e\u0010\b\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\u0002J\u0013\u0010\f\u001a\u00020\u00042\b\u0010\u000b\u001a\u0004\u0018\u00010\u0001H\u0096\u0002J\b\u0010\u000e\u001a\u00020\rH\u0016J\b\u0010\u0010\u001a\u00020\u000fH\u0016R\u0017\u0010\u0013\u001a\u00020\u00048\u0007¢\u0006\f\n\u0004\b\b\u0010\u0011\u001a\u0004\b\u0006\u0010\u0012R\u0017\u0010\u0015\u001a\u00020\u00048\u0007¢\u0006\f\n\u0004\b\u0006\u0010\u0011\u001a\u0004\b\u0014\u0010\u0012R\u001c\u0010\u0018\u001a\n\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u00168\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0014\u0010\u0017R\u001c\u0010\u001a\u001a\n\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u00168\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0019\u0010\u0017R\u0019\u0010\u001e\u001a\n\u0012\u0004\u0012\u00020\u001c\u0018\u00010\u001b8G¢\u0006\u0006\u001a\u0004\b\b\u0010\u001dR\u0019\u0010 \u001a\n\u0012\u0004\u0012\u00020\u001f\u0018\u00010\u001b8G¢\u0006\u0006\u001a\u0004\b\u0019\u0010\u001d¨\u0006$"}, d2 = {"Lsdk/pendo/io/e2/l;", "", "Ljavax/net/ssl/SSLSocket;", "sslSocket", "", "isFallback", "b", "", CmcdData.OBJECT_TYPE_AUDIO_ONLY, "(Ljavax/net/ssl/SSLSocket;Z)V", "socket", "other", "equals", "", "hashCode", "", "toString", "Z", "()Z", "isTls", "c", "supportsTlsExtensions", "", "[Ljava/lang/String;", "cipherSuitesAsString", "d", "tlsVersionsAsString", "", "Lsdk/pendo/io/e2/i;", "()Ljava/util/List;", "cipherSuites", "Lsdk/pendo/io/e2/g0;", "tlsVersions", "<init>", "(ZZ[Ljava/lang/String;[Ljava/lang/String;)V", "e", "okhttp"}, k = 1, mv = {1, 8, 0})
public final class l {
    private static final i[] f;
    private static final i[] g;
    public static final l h;
    public static final l i;
    public static final l j;
    public static final l k;

    /* JADX INFO: renamed from: a, reason: from kotlin metadata */
    private final boolean isTls;

    /* JADX INFO: renamed from: b, reason: from kotlin metadata */
    private final boolean supportsTlsExtensions;

    /* JADX INFO: renamed from: c, reason: from kotlin metadata */
    private final String[] cipherSuitesAsString;

    /* JADX INFO: renamed from: d, reason: from kotlin metadata */
    private final String[] tlsVersionsAsString;

    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0017\u0018\u00002\u00020\u0001B\u0011\b\u0016\u0012\u0006\u0010!\u001a\u00020\u0005¢\u0006\u0004\b\"\u0010#B\u0011\b\u0010\u0012\u0006\u0010\u0014\u001a\u00020\u0002¢\u0006\u0004\b\"\u0010\u0013J\u0010\u0010\u0004\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0002H\u0007J\u0006\u0010\u0004\u001a\u00020\u0005J!\u0010\b\u001a\u00020\u00002\u0012\u0010\b\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00070\u0006\"\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ!\u0010\b\u001a\u00020\u00002\u0012\u0010\b\u001a\n\u0012\u0006\b\u0001\u0012\u00020\n0\u0006\"\u00020\n¢\u0006\u0004\b\b\u0010\u000bJ!\u0010\f\u001a\u00020\u00002\u0012\u0010\f\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00070\u0006\"\u00020\u0007¢\u0006\u0004\b\f\u0010\tJ!\u0010\f\u001a\u00020\u00002\u0012\u0010\f\u001a\n\u0012\u0006\b\u0001\u0012\u00020\r0\u0006\"\u00020\r¢\u0006\u0004\b\f\u0010\u000eR\"\u0010\u0014\u001a\u00020\u00028\u0000@\u0000X\u0080\u000e¢\u0006\u0012\n\u0004\b\u0004\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R*\u0010\b\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u00068\u0000@\u0000X\u0080\u000e¢\u0006\u0012\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR*\u0010\f\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u00068\u0000@\u0000X\u0080\u000e¢\u0006\u0012\n\u0004\b\u001b\u0010\u0016\u001a\u0004\b\u001c\u0010\u0018\"\u0004\b\u001d\u0010\u001aR\"\u0010\u0003\u001a\u00020\u00028\u0000@\u0000X\u0080\u000e¢\u0006\u0012\n\u0004\b\u001e\u0010\u000f\u001a\u0004\b\u001f\u0010\u0011\"\u0004\b \u0010\u0013¨\u0006$"}, d2 = {"Lsdk/pendo/io/e2/l$a;", "", "", "supportsTlsExtensions", CmcdData.OBJECT_TYPE_AUDIO_ONLY, "Lsdk/pendo/io/e2/l;", "", "", "cipherSuites", "([Ljava/lang/String;)Lokhttp3/ConnectionSpec$Builder;", "Lsdk/pendo/io/e2/i;", "([Lokhttp3/CipherSuite;)Lokhttp3/ConnectionSpec$Builder;", "tlsVersions", "Lsdk/pendo/io/e2/g0;", "([Lokhttp3/TlsVersion;)Lokhttp3/ConnectionSpec$Builder;", "Z", "getTls$okhttp", "()Z", "setTls$okhttp", "(Z)V", "tls", "b", "[Ljava/lang/String;", "getCipherSuites$okhttp", "()[Ljava/lang/String;", "setCipherSuites$okhttp", "([Ljava/lang/String;)V", "c", "getTlsVersions$okhttp", "setTlsVersions$okhttp", "d", "getSupportsTlsExtensions$okhttp", "setSupportsTlsExtensions$okhttp", "connectionSpec", "<init>", "(Lokhttp3/ConnectionSpec;)V", "okhttp"}, k = 1, mv = {1, 8, 0})
    public static final class a {

        /* JADX INFO: renamed from: a, reason: from kotlin metadata */
        private boolean tls;

        /* JADX INFO: renamed from: b, reason: from kotlin metadata */
        private String[] cipherSuites;

        /* JADX INFO: renamed from: c, reason: from kotlin metadata */
        private String[] tlsVersions;

        /* JADX INFO: renamed from: d, reason: from kotlin metadata */
        private boolean supportsTlsExtensions;

        public a(l connectionSpec) {
            Intrinsics.checkNotNullParameter(connectionSpec, "connectionSpec");
            this.tls = connectionSpec.getIsTls();
            this.cipherSuites = connectionSpec.cipherSuitesAsString;
            this.tlsVersions = connectionSpec.tlsVersionsAsString;
            this.supportsTlsExtensions = connectionSpec.getSupportsTlsExtensions();
        }

        public final l a() {
            return new l(this.tls, this.supportsTlsExtensions, this.cipherSuites, this.tlsVersions);
        }

        public final a b(String... tlsVersions) {
            Intrinsics.checkNotNullParameter(tlsVersions, "tlsVersions");
            if (!this.tls) {
                throw new IllegalArgumentException("no TLS versions for cleartext connections".toString());
            }
            if (tlsVersions.length == 0) {
                throw new IllegalArgumentException("At least one TLS version is required".toString());
            }
            this.tlsVersions = (String[]) tlsVersions.clone();
            return this;
        }

        public a(boolean z) {
            this.tls = z;
        }

        public final a a(String... cipherSuites) {
            Intrinsics.checkNotNullParameter(cipherSuites, "cipherSuites");
            if (!this.tls) {
                throw new IllegalArgumentException("no cipher suites for cleartext connections".toString());
            }
            if (cipherSuites.length == 0) {
                throw new IllegalArgumentException("At least one cipher suite is required".toString());
            }
            this.cipherSuites = (String[]) cipherSuites.clone();
            return this;
        }

        public final a a(i... cipherSuites) {
            Intrinsics.checkNotNullParameter(cipherSuites, "cipherSuites");
            if (!this.tls) {
                throw new IllegalArgumentException("no cipher suites for cleartext connections".toString());
            }
            ArrayList arrayList = new ArrayList(cipherSuites.length);
            for (i iVar : cipherSuites) {
                arrayList.add(iVar.getJavaName());
            }
            String[] strArr = (String[]) arrayList.toArray(new String[0]);
            return a((String[]) Arrays.copyOf(strArr, strArr.length));
        }

        @Deprecated(message = "since OkHttp 3.13 all TLS-connections are expected to support TLS extensions.\nIn a future release setting this to true will be unnecessary and setting it to false\nwill have no effect.")
        public final a a(boolean supportsTlsExtensions) {
            if (!this.tls) {
                throw new IllegalArgumentException("no TLS extensions for cleartext connections".toString());
            }
            this.supportsTlsExtensions = supportsTlsExtensions;
            return this;
        }

        public final a a(g0... tlsVersions) {
            Intrinsics.checkNotNullParameter(tlsVersions, "tlsVersions");
            if (!this.tls) {
                throw new IllegalArgumentException("no TLS versions for cleartext connections".toString());
            }
            ArrayList arrayList = new ArrayList(tlsVersions.length);
            for (g0 g0Var : tlsVersions) {
                arrayList.add(g0Var.getJavaName());
            }
            String[] strArr = (String[]) arrayList.toArray(new String[0]);
            return b((String[]) Arrays.copyOf(strArr, strArr.length));
        }
    }

    static {
        i iVar = i.o1;
        i iVar2 = i.p1;
        i iVar3 = i.q1;
        i iVar4 = i.a1;
        i iVar5 = i.e1;
        i iVar6 = i.b1;
        i iVar7 = i.f1;
        i iVar8 = i.l1;
        i iVar9 = i.k1;
        i[] iVarArr = {iVar, iVar2, iVar3, iVar4, iVar5, iVar6, iVar7, iVar8, iVar9};
        f = iVarArr;
        i[] iVarArr2 = {iVar, iVar2, iVar3, iVar4, iVar5, iVar6, iVar7, iVar8, iVar9, i.L0, i.M0, i.j0, i.k0, i.H, i.L, i.l};
        g = iVarArr2;
        a aVarA = new a(true).a((i[]) Arrays.copyOf(iVarArr, 9));
        g0 g0Var = g0.TLS_1_3;
        g0 g0Var2 = g0.TLS_1_2;
        h = aVarA.a(g0Var, g0Var2).a(true).a();
        i = new a(true).a((i[]) Arrays.copyOf(iVarArr2, 16)).a(g0Var, g0Var2).a(true).a();
        j = new a(true).a((i[]) Arrays.copyOf(iVarArr2, 16)).a(g0Var, g0Var2, g0.TLS_1_1, g0.TLS_1_0).a(true).a();
        k = new a(false).a();
    }

    public l(boolean z, boolean z2, String[] strArr, String[] strArr2) {
        this.isTls = z;
        this.supportsTlsExtensions = z2;
        this.cipherSuitesAsString = strArr;
        this.tlsVersionsAsString = strArr2;
    }

    /* JADX INFO: renamed from: c, reason: from getter */
    public final boolean getSupportsTlsExtensions() {
        return this.supportsTlsExtensions;
    }

    public final List<g0> d() {
        String[] strArr = this.tlsVersionsAsString;
        if (strArr == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList(strArr.length);
        for (String str : strArr) {
            arrayList.add(g0.INSTANCE.a(str));
        }
        return CollectionsKt.toList(arrayList);
    }

    public boolean equals(Object other) {
        if (!(other instanceof l)) {
            return false;
        }
        if (other == this) {
            return true;
        }
        boolean z = this.isTls;
        l lVar = (l) other;
        if (z != lVar.isTls) {
            return false;
        }
        return !z || (Arrays.equals(this.cipherSuitesAsString, lVar.cipherSuitesAsString) && Arrays.equals(this.tlsVersionsAsString, lVar.tlsVersionsAsString) && this.supportsTlsExtensions == lVar.supportsTlsExtensions);
    }

    public int hashCode() {
        if (!this.isTls) {
            return 17;
        }
        String[] strArr = this.cipherSuitesAsString;
        int iHashCode = ((strArr != null ? Arrays.hashCode(strArr) : 0) + 527) * 31;
        String[] strArr2 = this.tlsVersionsAsString;
        return ((iHashCode + (strArr2 != null ? Arrays.hashCode(strArr2) : 0)) * 31) + (!this.supportsTlsExtensions ? 1 : 0);
    }

    public String toString() {
        return !this.isTls ? "ConnectionSpec()" : "ConnectionSpec(cipherSuites=" + Objects.toString(a(), "[all enabled]") + ", tlsVersions=" + Objects.toString(d(), "[all enabled]") + ", supportsTlsExtensions=" + this.supportsTlsExtensions + ')';
    }

    public final void a(SSLSocket sslSocket, boolean isFallback) {
        Intrinsics.checkNotNullParameter(sslSocket, "sslSocket");
        l lVarB = b(sslSocket, isFallback);
        if (lVarB.d() != null) {
            sslSocket.setEnabledProtocols(lVarB.tlsVersionsAsString);
        }
        if (lVarB.a() != null) {
            sslSocket.setEnabledCipherSuites(lVarB.cipherSuitesAsString);
        }
    }

    /* JADX INFO: renamed from: b, reason: from getter */
    public final boolean getIsTls() {
        return this.isTls;
    }

    private final l b(SSLSocket sslSocket, boolean isFallback) {
        String[] cipherSuitesIntersection;
        String[] tlsVersionsIntersection;
        if (this.cipherSuitesAsString != null) {
            String[] enabledCipherSuites = sslSocket.getEnabledCipherSuites();
            Intrinsics.checkNotNullExpressionValue(enabledCipherSuites, "sslSocket.enabledCipherSuites");
            cipherSuitesIntersection = sdk.pendo.io.f2.b.b(enabledCipherSuites, this.cipherSuitesAsString, i.INSTANCE.a());
        } else {
            cipherSuitesIntersection = sslSocket.getEnabledCipherSuites();
        }
        if (this.tlsVersionsAsString != null) {
            String[] enabledProtocols = sslSocket.getEnabledProtocols();
            Intrinsics.checkNotNullExpressionValue(enabledProtocols, "sslSocket.enabledProtocols");
            tlsVersionsIntersection = sdk.pendo.io.f2.b.b(enabledProtocols, this.tlsVersionsAsString, (Comparator<? super String>) ComparisonsKt.naturalOrder());
        } else {
            tlsVersionsIntersection = sslSocket.getEnabledProtocols();
        }
        String[] supportedCipherSuites = sslSocket.getSupportedCipherSuites();
        Intrinsics.checkNotNullExpressionValue(supportedCipherSuites, "supportedCipherSuites");
        int iA = sdk.pendo.io.f2.b.a(supportedCipherSuites, "TLS_FALLBACK_SCSV", i.INSTANCE.a());
        if (isFallback && iA != -1) {
            Intrinsics.checkNotNullExpressionValue(cipherSuitesIntersection, "cipherSuitesIntersection");
            String str = supportedCipherSuites[iA];
            Intrinsics.checkNotNullExpressionValue(str, "supportedCipherSuites[indexOfFallbackScsv]");
            cipherSuitesIntersection = sdk.pendo.io.f2.b.a(cipherSuitesIntersection, str);
        }
        a aVar = new a(this);
        Intrinsics.checkNotNullExpressionValue(cipherSuitesIntersection, "cipherSuitesIntersection");
        a aVarA = aVar.a((String[]) Arrays.copyOf(cipherSuitesIntersection, cipherSuitesIntersection.length));
        Intrinsics.checkNotNullExpressionValue(tlsVersionsIntersection, "tlsVersionsIntersection");
        return aVarA.b((String[]) Arrays.copyOf(tlsVersionsIntersection, tlsVersionsIntersection.length)).a();
    }

    public final List<i> a() {
        String[] strArr = this.cipherSuitesAsString;
        if (strArr == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList(strArr.length);
        for (String str : strArr) {
            arrayList.add(i.INSTANCE.a(str));
        }
        return CollectionsKt.toList(arrayList);
    }

    public final boolean a(SSLSocket socket) {
        Intrinsics.checkNotNullParameter(socket, "socket");
        if (!this.isTls) {
            return false;
        }
        String[] strArr = this.tlsVersionsAsString;
        if (strArr != null && !sdk.pendo.io.f2.b.a(strArr, socket.getEnabledProtocols(), (Comparator<? super String>) ComparisonsKt.naturalOrder())) {
            return false;
        }
        String[] strArr2 = this.cipherSuitesAsString;
        return strArr2 == null || sdk.pendo.io.f2.b.a(strArr2, socket.getEnabledCipherSuites(), i.INSTANCE.a());
    }
}
