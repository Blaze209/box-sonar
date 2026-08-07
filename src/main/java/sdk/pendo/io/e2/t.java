package sdk.pendo.io.e2;

import androidx.media3.exoplayer.upstream.CmcdData;
import java.io.IOException;
import java.security.cert.Certificate;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import javax.net.ssl.SSLPeerUnverifiedException;
import javax.net.ssl.SSLSession;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 \"2\u00020\u0001:\u0001\nB;\b\u0000\u0012\u0006\u0010\f\u001a\u00020\t\u0012\u0006\u0010\u0011\u001a\u00020\u000e\u0012\f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00140\u0013\u0012\u0012\u0010\u001f\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00140\u00130\u001e¢\u0006\u0004\b \u0010!J\u0013\u0010\u0004\u001a\u00020\u00032\b\u0010\u0002\u001a\u0004\u0018\u00010\u0001H\u0096\u0002J\b\u0010\u0006\u001a\u00020\u0005H\u0016J\b\u0010\b\u001a\u00020\u0007H\u0016R\u0017\u0010\f\u001a\u00020\t8\u0007¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR\u0017\u0010\u0011\u001a\u00020\u000e8\u0007¢\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012R\u001d\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00140\u00138\u0007¢\u0006\f\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u000f\u0010\u0017R!\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u00140\u00138GX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u0015\u0010\u0017R\u0018\u0010\u001d\u001a\u00020\u0007*\u00020\u00148BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\n\u0010\u001c¨\u0006#"}, d2 = {"Lsdk/pendo/io/e2/t;", "", "other", "", "equals", "", "hashCode", "", "toString", "Lsdk/pendo/io/e2/g0;", CmcdData.OBJECT_TYPE_AUDIO_ONLY, "Lsdk/pendo/io/e2/g0;", "tlsVersion", "()Lokhttp3/TlsVersion;", "Lsdk/pendo/io/e2/i;", "b", "Lsdk/pendo/io/e2/i;", "cipherSuite", "()Lokhttp3/CipherSuite;", "", "Ljava/security/cert/Certificate;", "c", "Ljava/util/List;", "()Ljava/util/List;", "localCertificates", "d", "Lkotlin/Lazy;", "peerCertificates", "(Ljava/security/cert/Certificate;)Ljava/lang/String;", "name", "Lkotlin/Function0;", "peerCertificatesFn", "<init>", "(Lokhttp3/TlsVersion;Lokhttp3/CipherSuite;Ljava/util/List;Lkotlin/jvm/functions/Function0;)V", "e", "okhttp"}, k = 1, mv = {1, 8, 0})
public final class t {

    /* JADX INFO: renamed from: e, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* JADX INFO: renamed from: a, reason: from kotlin metadata */
    private final g0 tlsVersion;

    /* JADX INFO: renamed from: b, reason: from kotlin metadata */
    private final i cipherSuite;

    /* JADX INFO: renamed from: c, reason: from kotlin metadata */
    private final List<Certificate> localCertificates;

    /* JADX INFO: renamed from: d, reason: from kotlin metadata */
    private final Lazy peerCertificates;

    /* JADX INFO: renamed from: sdk.pendo.io.e2.t$a, reason: from kotlin metadata */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\n\u0010\u000bJ#\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00030\u0004*\f\u0012\u0006\b\u0001\u0012\u00020\u0003\u0018\u00010\u0002H\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u0013\u0010\u0005\u001a\u00020\b*\u00020\u0007H\u0007¢\u0006\u0004\b\u0005\u0010\t¨\u0006\f"}, d2 = {"Lsdk/pendo/io/e2/t$a;", "", "", "Ljava/security/cert/Certificate;", "", CmcdData.OBJECT_TYPE_AUDIO_ONLY, "([Ljava/security/cert/Certificate;)Ljava/util/List;", "Ljavax/net/ssl/SSLSession;", "Lsdk/pendo/io/e2/t;", "(Ljavax/net/ssl/SSLSession;)Lsdk/pendo/io/e2/t;", "<init>", "()V", "okhttp"}, k = 1, mv = {1, 8, 0})
    public static final class Companion {

        /* JADX INFO: renamed from: sdk.pendo.io.e2.t$a$a, reason: collision with other inner class name */
        @Metadata(d1 = {"\u0000\f\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00010\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"", "Ljava/security/cert/Certificate;", CmcdData.OBJECT_TYPE_AUDIO_ONLY, "()Ljava/util/List;"}, k = 3, mv = {1, 8, 0})
        static final class C0380a extends Lambda implements Function0<List<? extends Certificate>> {
            final /* synthetic */ List<Certificate> a;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            C0380a(List<? extends Certificate> list) {
                super(0);
                this.a = list;
            }

            @Override // kotlin.jvm.functions.Function0
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public final List<Certificate> invoke() {
                return this.a;
            }
        }

        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @JvmStatic
        public final t a(SSLSession sSLSession) throws IOException {
            List<Certificate> listEmptyList;
            Intrinsics.checkNotNullParameter(sSLSession, "<this>");
            String cipherSuite = sSLSession.getCipherSuite();
            if (cipherSuite == null) {
                throw new IllegalStateException("cipherSuite == null".toString());
            }
            if (Intrinsics.areEqual(cipherSuite, "TLS_NULL_WITH_NULL_NULL") ? true : Intrinsics.areEqual(cipherSuite, "SSL_NULL_WITH_NULL_NULL")) {
                throw new IOException("cipherSuite == " + cipherSuite);
            }
            i iVarA = i.INSTANCE.a(cipherSuite);
            String protocol = sSLSession.getProtocol();
            if (protocol == null) {
                throw new IllegalStateException("tlsVersion == null".toString());
            }
            if (Intrinsics.areEqual("NONE", protocol)) {
                throw new IOException("tlsVersion == NONE");
            }
            g0 g0VarA = g0.INSTANCE.a(protocol);
            try {
                listEmptyList = a(sSLSession.getPeerCertificates());
            } catch (SSLPeerUnverifiedException unused) {
                listEmptyList = CollectionsKt.emptyList();
            }
            return new t(g0VarA, iVarA, a(sSLSession.getLocalCertificates()), new C0380a(listEmptyList));
        }

        private final List<Certificate> a(Certificate[] certificateArr) {
            return certificateArr != null ? sdk.pendo.io.f2.b.a(Arrays.copyOf(certificateArr, certificateArr.length)) : CollectionsKt.emptyList();
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00010\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"", "Ljava/security/cert/Certificate;", CmcdData.OBJECT_TYPE_AUDIO_ONLY, "()Ljava/util/List;"}, k = 3, mv = {1, 8, 0})
    static final class b extends Lambda implements Function0<List<? extends Certificate>> {
        final /* synthetic */ Function0<List<Certificate>> a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        b(Function0<? extends List<? extends Certificate>> function0) {
            super(0);
            this.a = function0;
        }

        @Override // kotlin.jvm.functions.Function0
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final List<Certificate> invoke() {
            try {
                return this.a.invoke();
            } catch (SSLPeerUnverifiedException unused) {
                return CollectionsKt.emptyList();
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public t(g0 tlsVersion, i cipherSuite, List<? extends Certificate> localCertificates, Function0<? extends List<? extends Certificate>> peerCertificatesFn) {
        Intrinsics.checkNotNullParameter(tlsVersion, "tlsVersion");
        Intrinsics.checkNotNullParameter(cipherSuite, "cipherSuite");
        Intrinsics.checkNotNullParameter(localCertificates, "localCertificates");
        Intrinsics.checkNotNullParameter(peerCertificatesFn, "peerCertificatesFn");
        this.tlsVersion = tlsVersion;
        this.cipherSuite = cipherSuite;
        this.localCertificates = localCertificates;
        this.peerCertificates = LazyKt.lazy(new b(peerCertificatesFn));
    }

    /* JADX INFO: renamed from: a, reason: from getter */
    public final i getCipherSuite() {
        return this.cipherSuite;
    }

    public final List<Certificate> b() {
        return this.localCertificates;
    }

    public final List<Certificate> c() {
        return (List) this.peerCertificates.getValue();
    }

    /* JADX INFO: renamed from: d, reason: from getter */
    public final g0 getTlsVersion() {
        return this.tlsVersion;
    }

    public boolean equals(Object other) {
        if (!(other instanceof t)) {
            return false;
        }
        t tVar = (t) other;
        return tVar.tlsVersion == this.tlsVersion && Intrinsics.areEqual(tVar.cipherSuite, this.cipherSuite) && Intrinsics.areEqual(tVar.c(), c()) && Intrinsics.areEqual(tVar.localCertificates, this.localCertificates);
    }

    public int hashCode() {
        return ((((((this.tlsVersion.hashCode() + 527) * 31) + this.cipherSuite.hashCode()) * 31) + c().hashCode()) * 31) + this.localCertificates.hashCode();
    }

    public String toString() {
        List<Certificate> listC = c();
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(listC, 10));
        Iterator<T> it = listC.iterator();
        while (it.hasNext()) {
            arrayList.add(a((Certificate) it.next()));
        }
        StringBuilder sbAppend = new StringBuilder("Handshake{tlsVersion=").append(this.tlsVersion).append(" cipherSuite=").append(this.cipherSuite).append(" peerCertificates=").append(arrayList.toString()).append(" localCertificates=");
        List<Certificate> list = this.localCertificates;
        ArrayList arrayList2 = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
        Iterator<T> it2 = list.iterator();
        while (it2.hasNext()) {
            arrayList2.add(a((Certificate) it2.next()));
        }
        return sbAppend.append(arrayList2).append(AbstractJsonLexerKt.END_OBJ).toString();
    }

    private final String a(Certificate certificate) {
        if (certificate instanceof X509Certificate) {
            return ((X509Certificate) certificate).getSubjectDN().toString();
        }
        String type = certificate.getType();
        Intrinsics.checkNotNullExpressionValue(type, "type");
        return type;
    }
}
