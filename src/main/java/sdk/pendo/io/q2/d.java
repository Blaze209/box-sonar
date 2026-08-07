package sdk.pendo.io.q2;

import androidx.media3.exoplayer.upstream.CmcdData;
import com.box.androidsdk.content.models.BoxUser;
import java.security.cert.Certificate;
import java.security.cert.CertificateParsingException;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLException;
import javax.net.ssl.SSLSession;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import sdk.pendo.io.s2.c0;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0013\u0010\u0014J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u0018\u0010\t\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\f\u0010\n\u001a\u00020\u0002*\u00020\u0002H\u0002J\f\u0010\t\u001a\u00020\u0006*\u00020\u0002H\u0002J\u001c\u0010\n\u001a\u00020\u00062\b\u0010\b\u001a\u0004\u0018\u00010\u00022\b\u0010\u000b\u001a\u0004\u0018\u00010\u0002H\u0002J\u001e\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00020\u000e2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\fH\u0002J\u0018\u0010\u0012\u001a\u00020\u00062\u0006\u0010\u000f\u001a\u00020\u00022\u0006\u0010\u0011\u001a\u00020\u0010H\u0016J\u0016\u0010\n\u001a\u00020\u00062\u0006\u0010\u000f\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004J\u0014\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00020\u000e2\u0006\u0010\u0005\u001a\u00020\u0004¨\u0006\u0015"}, d2 = {"Lsdk/pendo/io/q2/d;", "Ljavax/net/ssl/HostnameVerifier;", "", "ipAddress", "Ljava/security/cert/X509Certificate;", "certificate", "", "c", BoxUser.FIELD_HOSTNAME, "b", CmcdData.OBJECT_TYPE_AUDIO_ONLY, "pattern", "", "type", "", "host", "Ljavax/net/ssl/SSLSession;", "session", "verify", "<init>", "()V", "okhttp"}, k = 1, mv = {1, 8, 0})
public final class d implements HostnameVerifier {
    public static final d a = new d();

    private d() {
    }

    private final boolean b(String str) {
        return str.length() == ((int) c0.a(str, 0, 0, 3, null));
    }

    private final boolean c(String ipAddress, X509Certificate certificate) {
        String strB = sdk.pendo.io.f2.a.b(ipAddress);
        List<String> listA = a(certificate, 7);
        if ((listA instanceof Collection) && listA.isEmpty()) {
            return false;
        }
        Iterator<T> it = listA.iterator();
        while (it.hasNext()) {
            if (Intrinsics.areEqual(strB, sdk.pendo.io.f2.a.b((String) it.next()))) {
                return true;
            }
        }
        return false;
    }

    public final List<String> a(X509Certificate certificate) {
        Intrinsics.checkNotNullParameter(certificate, "certificate");
        return CollectionsKt.plus((Collection) a(certificate, 7), (Iterable) a(certificate, 2));
    }

    @Override // javax.net.ssl.HostnameVerifier
    public boolean verify(String host, SSLSession session) {
        Intrinsics.checkNotNullParameter(host, "host");
        Intrinsics.checkNotNullParameter(session, "session");
        if (b(host)) {
            try {
                Certificate certificate = session.getPeerCertificates()[0];
                Intrinsics.checkNotNull(certificate, "null cannot be cast to non-null type java.security.cert.X509Certificate");
                return a(host, (X509Certificate) certificate);
            } catch (SSLException unused) {
            }
        }
        return false;
    }

    private final String a(String str) {
        if (!b(str)) {
            return str;
        }
        Locale US = Locale.US;
        Intrinsics.checkNotNullExpressionValue(US, "US");
        String lowerCase = str.toLowerCase(US);
        Intrinsics.checkNotNullExpressionValue(lowerCase, "this as java.lang.String).toLowerCase(locale)");
        return lowerCase;
    }

    private final boolean b(String hostname, X509Certificate certificate) {
        String strA = a(hostname);
        List<String> listA = a(certificate, 2);
        if ((listA instanceof Collection) && listA.isEmpty()) {
            return false;
        }
        Iterator<T> it = listA.iterator();
        while (it.hasNext()) {
            if (a.a(strA, (String) it.next())) {
                return true;
            }
        }
        return false;
    }

    private final List<String> a(X509Certificate certificate, int type) {
        Object obj;
        try {
            Collection<List<?>> subjectAlternativeNames = certificate.getSubjectAlternativeNames();
            if (subjectAlternativeNames == null) {
                return CollectionsKt.emptyList();
            }
            ArrayList arrayList = new ArrayList();
            for (List<?> list : subjectAlternativeNames) {
                if (list != null && list.size() >= 2 && Intrinsics.areEqual(list.get(0), Integer.valueOf(type)) && (obj = list.get(1)) != null) {
                    arrayList.add((String) obj);
                }
            }
            return arrayList;
        } catch (CertificateParsingException unused) {
            return CollectionsKt.emptyList();
        }
    }

    public final boolean a(String host, X509Certificate certificate) {
        Intrinsics.checkNotNullParameter(host, "host");
        Intrinsics.checkNotNullParameter(certificate, "certificate");
        return sdk.pendo.io.f2.b.a(host) ? c(host, certificate) : b(host, certificate);
    }

    private final boolean a(String hostname, String pattern) {
        if (hostname != null && hostname.length() != 0 && !StringsKt.startsWith$default(hostname, ".", false, 2, (Object) null) && !StringsKt.endsWith$default(hostname, "..", false, 2, (Object) null) && pattern != null && pattern.length() != 0 && !StringsKt.startsWith$default(pattern, ".", false, 2, (Object) null) && !StringsKt.endsWith$default(pattern, "..", false, 2, (Object) null)) {
            if (!StringsKt.endsWith$default(hostname, ".", false, 2, (Object) null)) {
                hostname = hostname + '.';
            }
            String str = hostname;
            if (!StringsKt.endsWith$default(pattern, ".", false, 2, (Object) null)) {
                pattern = pattern + '.';
            }
            String strA = a(pattern);
            if (!StringsKt.contains$default((CharSequence) strA, (CharSequence) "*", false, 2, (Object) null)) {
                return Intrinsics.areEqual(str, strA);
            }
            if (!StringsKt.startsWith$default(strA, "*.", false, 2, (Object) null) || StringsKt.indexOf$default((CharSequence) strA, '*', 1, false, 4, (Object) null) != -1 || str.length() < strA.length() || Intrinsics.areEqual("*.", strA)) {
                return false;
            }
            String strSubstring = strA.substring(1);
            Intrinsics.checkNotNullExpressionValue(strSubstring, "this as java.lang.String).substring(startIndex)");
            if (!StringsKt.endsWith$default(str, strSubstring, false, 2, (Object) null)) {
                return false;
            }
            int length = str.length() - strSubstring.length();
            return length <= 0 || StringsKt.lastIndexOf$default((CharSequence) str, '.', length + (-1), false, 4, (Object) null) == -1;
        }
        return false;
    }
}
