package sdk.pendo.io.q2;

import androidx.media3.exoplayer.upstream.CmcdData;
import java.security.cert.X509Certificate;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;
import javax.security.auth.x500.X500Principal;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\u0010\"\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u001b\u0012\u0012\u0010\u0012\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00020\u0011\"\u00020\u0002¢\u0006\u0004\b\u0013\u0010\u0014J\u0012\u0010\u0004\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0096\u0002J\b\u0010\n\u001a\u00020\tH\u0016R&\u0010\u0010\u001a\u0014\u0012\u0004\u0012\u00020\f\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00020\r0\u000b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000e\u0010\u000f¨\u0006\u0015"}, d2 = {"Lsdk/pendo/io/q2/b;", "Lsdk/pendo/io/q2/e;", "Ljava/security/cert/X509Certificate;", "cert", "findByIssuerAndSignature", "", "other", "", "equals", "", "hashCode", "", "Ljavax/security/auth/x500/X500Principal;", "", CmcdData.OBJECT_TYPE_AUDIO_ONLY, "Ljava/util/Map;", "subjectToCaCerts", "", "caCerts", "<init>", "([Ljava/security/cert/X509Certificate;)V", "okhttp"}, k = 1, mv = {1, 8, 0})
public final class b implements e {

    /* JADX INFO: renamed from: a, reason: from kotlin metadata */
    private final Map<X500Principal, Set<X509Certificate>> subjectToCaCerts;

    public b(X509Certificate... caCerts) {
        Intrinsics.checkNotNullParameter(caCerts, "caCerts");
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (X509Certificate x509Certificate : caCerts) {
            X500Principal subjectX500Principal = x509Certificate.getSubjectX500Principal();
            Intrinsics.checkNotNullExpressionValue(subjectX500Principal, "caCert.subjectX500Principal");
            Object linkedHashSet = linkedHashMap.get(subjectX500Principal);
            if (linkedHashSet == null) {
                linkedHashSet = new LinkedHashSet();
                linkedHashMap.put(subjectX500Principal, linkedHashSet);
            }
            ((Set) linkedHashSet).add(x509Certificate);
        }
        this.subjectToCaCerts = linkedHashMap;
    }

    public boolean equals(Object other) {
        if (other != this) {
            return (other instanceof b) && Intrinsics.areEqual(((b) other).subjectToCaCerts, this.subjectToCaCerts);
        }
        return true;
    }

    @Override // sdk.pendo.io.q2.e
    public X509Certificate findByIssuerAndSignature(X509Certificate cert) {
        Intrinsics.checkNotNullParameter(cert, "cert");
        Set<X509Certificate> set = this.subjectToCaCerts.get(cert.getIssuerX500Principal());
        Object obj = null;
        if (set == null) {
            return null;
        }
        for (Object obj2 : set) {
            try {
                cert.verify(((X509Certificate) obj2).getPublicKey());
                obj = obj2;
                break;
            } catch (Exception unused) {
            }
        }
        return (X509Certificate) obj;
    }

    public int hashCode() {
        return this.subjectToCaCerts.hashCode();
    }
}
