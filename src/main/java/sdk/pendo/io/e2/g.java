package sdk.pendo.io.e2;

import androidx.media3.exoplayer.upstream.CmcdData;
import com.box.androidsdk.content.models.BoxUser;
import java.security.cert.Certificate;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import javax.net.ssl.SSLPeerUnverifiedException;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.TypeIntrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\"\n\u0002\b\f\u0018\u0000 !2\u00020\u0001:\u0003\b\u001b!B#\b\u0000\u0012\f\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\r0\u0016\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u000e¢\u0006\u0004\b\u001f\u0010 J\u001c\u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004J+\u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0012\u0010\u000b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\u00040\tH\u0000¢\u0006\u0004\b\b\u0010\fJ\u0014\u0010\b\u001a\b\u0012\u0004\u0012\u00020\r0\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u0017\u0010\b\u001a\u00020\u00002\u0006\u0010\u000f\u001a\u00020\u000eH\u0000¢\u0006\u0004\b\b\u0010\u0010J\u0013\u0010\u0013\u001a\u00020\u00122\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001H\u0096\u0002J\b\u0010\u0015\u001a\u00020\u0014H\u0016R\u001d\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\r0\u00168\u0006¢\u0006\f\n\u0004\b\b\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019R\u001c\u0010\u000f\u001a\u0004\u0018\u00010\u000e8\u0000X\u0080\u0004¢\u0006\f\n\u0004\b\u001b\u0010\u001c\u001a\u0004\b\u001d\u0010\u001e¨\u0006\""}, d2 = {"Lsdk/pendo/io/e2/g;", "", "", BoxUser.FIELD_HOSTNAME, "", "Ljava/security/cert/Certificate;", "peerCertificates", "", CmcdData.OBJECT_TYPE_AUDIO_ONLY, "Lkotlin/Function0;", "Ljava/security/cert/X509Certificate;", "cleanedPeerCertificatesFn", "(Ljava/lang/String;Lkotlin/jvm/functions/Function0;)V", "Lsdk/pendo/io/e2/g$c;", "Lsdk/pendo/io/q2/c;", "certificateChainCleaner", "(Lsdk/pendo/io/q2/c;)Lsdk/pendo/io/e2/g;", "other", "", "equals", "", "hashCode", "", "Ljava/util/Set;", "getPins", "()Ljava/util/Set;", "pins", "b", "Lsdk/pendo/io/q2/c;", "getCertificateChainCleaner$okhttp", "()Lokhttp3/internal/tls/CertificateChainCleaner;", "<init>", "(Ljava/util/Set;Lokhttp3/internal/tls/CertificateChainCleaner;)V", "c", "okhttp"}, k = 1, mv = {1, 8, 0})
public final class g {

    /* JADX INFO: renamed from: c, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public static final g d = new a().a();

    /* JADX INFO: renamed from: a, reason: from kotlin metadata */
    private final Set<c> pins;

    /* JADX INFO: renamed from: b, reason: from kotlin metadata */
    private final sdk.pendo.io.q2.c certificateChainCleaner;

    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0003\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u000f\u0010\u0010J\u0006\u0010\u0003\u001a\u00020\u0002J)\u0010\b\u001a\u00020\u00002\u0006\u0010\u0005\u001a\u00020\u00042\u0012\u0010\u0007\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00040\u0006\"\u00020\u0004¢\u0006\u0004\b\b\u0010\tR\u001d\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u000b0\n8\u0006¢\u0006\f\n\u0004\b\u0003\u0010\f\u001a\u0004\b\r\u0010\u000e¨\u0006\u0011"}, d2 = {"Lsdk/pendo/io/e2/g$a;", "", "Lsdk/pendo/io/e2/g;", CmcdData.OBJECT_TYPE_AUDIO_ONLY, "", "pattern", "", "pins", "add", "(Ljava/lang/String;[Ljava/lang/String;)Lokhttp3/CertificatePinner$Builder;", "", "Lsdk/pendo/io/e2/g$c;", "Ljava/util/List;", "getPins", "()Ljava/util/List;", "<init>", "()V", "okhttp"}, k = 1, mv = {1, 8, 0})
    public static final class a {

        /* JADX INFO: renamed from: a, reason: from kotlin metadata */
        private final List<c> pins = new ArrayList();

        /* JADX WARN: Multi-variable type inference failed */
        public final g a() {
            return new g(CollectionsKt.toSet(this.pins), null, 2, 0 == true ? 1 : 0);
        }
    }

    /* JADX INFO: renamed from: sdk.pendo.io.e2.g$b, reason: from kotlin metadata */
    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\f\u0010\rJ\f\u0010\u0004\u001a\u00020\u0003*\u00020\u0002H\u0007J\f\u0010\u0005\u001a\u00020\u0003*\u00020\u0002H\u0007J\u0010\u0010\u0004\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006H\u0007R\u0014\u0010\n\u001a\u00020\t8\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\b\n\u0010\u000b¨\u0006\u000e"}, d2 = {"Lsdk/pendo/io/e2/g$b;", "", "Ljava/security/cert/X509Certificate;", "Lsdk/pendo/io/s2/g;", CmcdData.OBJECT_TYPE_AUDIO_ONLY, "b", "Ljava/security/cert/Certificate;", "certificate", "", "Lsdk/pendo/io/e2/g;", "DEFAULT", "Lsdk/pendo/io/e2/g;", "<init>", "()V", "okhttp"}, k = 1, mv = {1, 8, 0})
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @JvmStatic
        public final String a(Certificate certificate) {
            Intrinsics.checkNotNullParameter(certificate, "certificate");
            if (certificate instanceof X509Certificate) {
                return "sha256/" + b((X509Certificate) certificate).a();
            }
            throw new IllegalArgumentException("Certificate pinning requires X509 certificates".toString());
        }

        @JvmStatic
        public final sdk.pendo.io.s2.g b(X509Certificate x509Certificate) {
            Intrinsics.checkNotNullParameter(x509Certificate, "<this>");
            sdk.pendo.io.s2.g.Companion companion = sdk.pendo.io.s2.g.INSTANCE;
            byte[] encoded = x509Certificate.getPublicKey().getEncoded();
            Intrinsics.checkNotNullExpressionValue(encoded, "publicKey.encoded");
            return sdk.pendo.io.s2.g.Companion.a(companion, encoded, 0, 0, 3, null).i();
        }

        @JvmStatic
        public final sdk.pendo.io.s2.g a(X509Certificate x509Certificate) {
            Intrinsics.checkNotNullParameter(x509Certificate, "<this>");
            sdk.pendo.io.s2.g.Companion companion = sdk.pendo.io.s2.g.INSTANCE;
            byte[] encoded = x509Certificate.getPublicKey().getEncoded();
            Intrinsics.checkNotNullExpressionValue(encoded, "publicKey.encoded");
            return sdk.pendo.io.s2.g.Companion.a(companion, encoded, 0, 0, 3, null).h();
        }
    }

    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001J\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\b\u0010\u0006\u001a\u00020\u0002H\u0016J\u0013\u0010\b\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0001H\u0096\u0002J\b\u0010\n\u001a\u00020\tH\u0016R\u0017\u0010\u000e\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u000b\u001a\u0004\b\f\u0010\rR\u0017\u0010\u0010\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u000f\u0010\u000b\u001a\u0004\b\u000f\u0010\rR\u0017\u0010\u0016\u001a\u00020\u00118\u0006¢\u0006\f\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015¨\u0006\u0017"}, d2 = {"Lsdk/pendo/io/e2/g$c;", "", "", BoxUser.FIELD_HOSTNAME, "", CmcdData.OBJECT_TYPE_AUDIO_ONLY, "toString", "other", "equals", "", "hashCode", "Ljava/lang/String;", "getPattern", "()Ljava/lang/String;", "pattern", "b", "hashAlgorithm", "Lsdk/pendo/io/s2/g;", "c", "Lsdk/pendo/io/s2/g;", "getHash", "()Lokio/ByteString;", "hash", "okhttp"}, k = 1, mv = {1, 8, 0})
    public static final class c {

        /* JADX INFO: renamed from: a, reason: from kotlin metadata */
        private final String pattern;

        /* JADX INFO: renamed from: b, reason: from kotlin metadata */
        private final String hashAlgorithm;

        /* JADX INFO: renamed from: c, reason: from kotlin metadata */
        private final sdk.pendo.io.s2.g hash;

        /* JADX INFO: renamed from: a, reason: from getter */
        public final sdk.pendo.io.s2.g getHash() {
            return this.hash;
        }

        /* JADX INFO: renamed from: b, reason: from getter */
        public final String getHashAlgorithm() {
            return this.hashAlgorithm;
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof c)) {
                return false;
            }
            c cVar = (c) other;
            return Intrinsics.areEqual(this.pattern, cVar.pattern) && Intrinsics.areEqual(this.hashAlgorithm, cVar.hashAlgorithm) && Intrinsics.areEqual(this.hash, cVar.hash);
        }

        public int hashCode() {
            return (((this.pattern.hashCode() * 31) + this.hashAlgorithm.hashCode()) * 31) + this.hash.hashCode();
        }

        public String toString() {
            return this.hashAlgorithm + '/' + this.hash.a();
        }

        /* JADX WARN: Code duplicated, block: B:16:0x0079 A[RETURN] */
        /* JADX WARN: Code duplicated, block: B:17:0x007a A[RETURN] */
        public final boolean a(String hostname) {
            Intrinsics.checkNotNullParameter(hostname, "hostname");
            if (StringsKt.startsWith$default(this.pattern, "**.", false, 2, (Object) null)) {
                int length = this.pattern.length() - 3;
                int length2 = hostname.length() - length;
                if (StringsKt.regionMatches$default(hostname, hostname.length() - length, this.pattern, 3, length, false, 16, (Object) null) && (length2 == 0 || hostname.charAt(length2 - 1) == '.')) {
                    return true;
                }
                return false;
            }
            if (!StringsKt.startsWith$default(this.pattern, "*.", false, 2, (Object) null)) {
                return Intrinsics.areEqual(hostname, this.pattern);
            }
            int length3 = this.pattern.length() - 1;
            int length4 = hostname.length() - length3;
            if (StringsKt.regionMatches$default(hostname, hostname.length() - length3, this.pattern, 1, length3, false, 16, (Object) null) && StringsKt.lastIndexOf$default((CharSequence) hostname, '.', length4 - 1, false, 4, (Object) null) == -1) {
                return true;
            }
            return false;
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00010\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"", "Ljava/security/cert/X509Certificate;", CmcdData.OBJECT_TYPE_AUDIO_ONLY, "()Ljava/util/List;"}, k = 3, mv = {1, 8, 0})
    static final class d extends Lambda implements Function0<List<? extends X509Certificate>> {
        final /* synthetic */ List<Certificate> b;
        final /* synthetic */ String c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        d(List<? extends Certificate> list, String str) {
            super(0);
            this.b = list;
            this.c = str;
        }

        @Override // kotlin.jvm.functions.Function0
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final List<X509Certificate> invoke() {
            List<Certificate> listA;
            sdk.pendo.io.q2.c certificateChainCleaner = g.this.getCertificateChainCleaner();
            if (certificateChainCleaner == null || (listA = certificateChainCleaner.a(this.b, this.c)) == null) {
                listA = this.b;
            }
            ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(listA, 10));
            for (Certificate certificate : listA) {
                Intrinsics.checkNotNull(certificate, "null cannot be cast to non-null type java.security.cert.X509Certificate");
                arrayList.add((X509Certificate) certificate);
            }
            return arrayList;
        }
    }

    public g(Set<c> pins, sdk.pendo.io.q2.c cVar) {
        Intrinsics.checkNotNullParameter(pins, "pins");
        this.pins = pins;
        this.certificateChainCleaner = cVar;
    }

    public final void a(String hostname, List<? extends Certificate> peerCertificates) {
        Intrinsics.checkNotNullParameter(hostname, "hostname");
        Intrinsics.checkNotNullParameter(peerCertificates, "peerCertificates");
        a(hostname, new d(peerCertificates, hostname));
    }

    public boolean equals(Object other) {
        if (!(other instanceof g)) {
            return false;
        }
        g gVar = (g) other;
        return Intrinsics.areEqual(gVar.pins, this.pins) && Intrinsics.areEqual(gVar.certificateChainCleaner, this.certificateChainCleaner);
    }

    public int hashCode() {
        int iHashCode = (this.pins.hashCode() + 1517) * 41;
        sdk.pendo.io.q2.c cVar = this.certificateChainCleaner;
        return iHashCode + (cVar != null ? cVar.hashCode() : 0);
    }

    public /* synthetic */ g(Set set, sdk.pendo.io.q2.c cVar, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(set, (i & 2) != 0 ? null : cVar);
    }

    public final void a(String hostname, Function0<? extends List<? extends X509Certificate>> cleanedPeerCertificatesFn) throws SSLPeerUnverifiedException {
        Intrinsics.checkNotNullParameter(hostname, "hostname");
        Intrinsics.checkNotNullParameter(cleanedPeerCertificatesFn, "cleanedPeerCertificatesFn");
        List<c> listA = a(hostname);
        if (listA.isEmpty()) {
            return;
        }
        List<? extends X509Certificate> listInvoke = cleanedPeerCertificatesFn.invoke();
        for (X509Certificate x509Certificate : listInvoke) {
            sdk.pendo.io.s2.g gVarB = null;
            sdk.pendo.io.s2.g gVarA = null;
            for (c cVar : listA) {
                String hashAlgorithm = cVar.getHashAlgorithm();
                if (Intrinsics.areEqual(hashAlgorithm, "sha256")) {
                    if (gVarB == null) {
                        gVarB = INSTANCE.b(x509Certificate);
                    }
                    if (Intrinsics.areEqual(cVar.getHash(), gVarB)) {
                        return;
                    }
                } else {
                    if (!Intrinsics.areEqual(hashAlgorithm, "sha1")) {
                        throw new AssertionError("unsupported hashAlgorithm: " + cVar.getHashAlgorithm());
                    }
                    if (gVarA == null) {
                        gVarA = INSTANCE.a(x509Certificate);
                    }
                    if (Intrinsics.areEqual(cVar.getHash(), gVarA)) {
                        return;
                    }
                }
            }
        }
        StringBuilder sb = new StringBuilder("Certificate pinning failure!\n  Peer certificate chain:");
        for (X509Certificate x509Certificate2 : listInvoke) {
            sb.append("\n    ");
            sb.append(INSTANCE.a((Certificate) x509Certificate2));
            sb.append(": ");
            sb.append(x509Certificate2.getSubjectDN().getName());
        }
        sb.append("\n  Pinned certificates for ");
        sb.append(hostname);
        sb.append(":");
        for (c cVar2 : listA) {
            sb.append("\n    ");
            sb.append(cVar2);
        }
        String string = sb.toString();
        Intrinsics.checkNotNullExpressionValue(string, "StringBuilder().apply(builderAction).toString()");
        throw new SSLPeerUnverifiedException(string);
    }

    public final List<c> a(String hostname) {
        Intrinsics.checkNotNullParameter(hostname, "hostname");
        Set<c> set = this.pins;
        List<c> listEmptyList = CollectionsKt.emptyList();
        for (Object obj : set) {
            if (((c) obj).a(hostname)) {
                if (listEmptyList.isEmpty()) {
                    listEmptyList = new ArrayList<>();
                }
                Intrinsics.checkNotNull(listEmptyList, "null cannot be cast to non-null type kotlin.collections.MutableList<T of okhttp3.internal.Util.filterList>");
                TypeIntrinsics.asMutableList(listEmptyList).add(obj);
            }
        }
        return listEmptyList;
    }

    /* JADX INFO: renamed from: a, reason: from getter */
    public final sdk.pendo.io.q2.c getCertificateChainCleaner() {
        return this.certificateChainCleaner;
    }

    public final g a(sdk.pendo.io.q2.c certificateChainCleaner) {
        Intrinsics.checkNotNullParameter(certificateChainCleaner, "certificateChainCleaner");
        return Intrinsics.areEqual(this.certificateChainCleaner, certificateChainCleaner) ? this : new g(this.pins, certificateChainCleaner);
    }
}
