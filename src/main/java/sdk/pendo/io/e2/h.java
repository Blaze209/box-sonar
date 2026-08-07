package sdk.pendo.io.e2;

import androidx.media3.exoplayer.upstream.CmcdData;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Locale;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010$\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\r\u001a\u00020\u0007\u0012\u0014\u0010\u0011\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u0007\u0012\u0004\u0012\u00020\u00070\u000e¢\u0006\u0004\b\u0017\u0010\u0018J\u0013\u0010\u0004\u001a\u00020\u00032\b\u0010\u0002\u001a\u0004\u0018\u00010\u0001H\u0096\u0002J\b\u0010\u0006\u001a\u00020\u0005H\u0016J\b\u0010\b\u001a\u00020\u0007H\u0016R\u0017\u0010\r\u001a\u00020\u00078\u0007¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR%\u0010\u0011\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u0007\u0012\u0004\u0012\u00020\u00070\u000e8G¢\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012R\u0013\u0010\u0013\u001a\u0004\u0018\u00010\u00078G¢\u0006\u0006\u001a\u0004\b\u000f\u0010\fR\u0011\u0010\u0016\u001a\u00020\u00148G¢\u0006\u0006\u001a\u0004\b\t\u0010\u0015¨\u0006\u0019"}, d2 = {"Lsdk/pendo/io/e2/h;", "", "other", "", "equals", "", "hashCode", "", "toString", CmcdData.OBJECT_TYPE_AUDIO_ONLY, "Ljava/lang/String;", "c", "()Ljava/lang/String;", "scheme", "", "b", "Ljava/util/Map;", "authParams", "()Ljava/util/Map;", "realm", "Ljava/nio/charset/Charset;", "()Ljava/nio/charset/Charset;", "charset", "<init>", "(Ljava/lang/String;Ljava/util/Map;)V", "okhttp"}, k = 1, mv = {1, 8, 0})
public final class h {

    /* JADX INFO: renamed from: a, reason: from kotlin metadata */
    private final String scheme;

    /* JADX INFO: renamed from: b, reason: from kotlin metadata */
    private final Map<String, String> authParams;

    public h(String scheme, Map<String, String> authParams) {
        String lowerCase;
        Intrinsics.checkNotNullParameter(scheme, "scheme");
        Intrinsics.checkNotNullParameter(authParams, "authParams");
        this.scheme = scheme;
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (Map.Entry<String, String> entry : authParams.entrySet()) {
            String key = entry.getKey();
            String value = entry.getValue();
            if (key != null) {
                Locale US = Locale.US;
                Intrinsics.checkNotNullExpressionValue(US, "US");
                lowerCase = key.toLowerCase(US);
                Intrinsics.checkNotNullExpressionValue(lowerCase, "this as java.lang.String).toLowerCase(locale)");
            } else {
                lowerCase = null;
            }
            linkedHashMap.put(lowerCase, value);
        }
        Map<String, String> mapUnmodifiableMap = Collections.unmodifiableMap(linkedHashMap);
        Intrinsics.checkNotNullExpressionValue(mapUnmodifiableMap, "unmodifiableMap<String?, String>(newAuthParams)");
        this.authParams = mapUnmodifiableMap;
    }

    public final Charset a() {
        String str = this.authParams.get("charset");
        if (str != null) {
            try {
                Charset charsetForName = Charset.forName(str);
                Intrinsics.checkNotNullExpressionValue(charsetForName, "forName(charset)");
                return charsetForName;
            } catch (Exception unused) {
            }
        }
        Charset ISO_8859_1 = StandardCharsets.ISO_8859_1;
        Intrinsics.checkNotNullExpressionValue(ISO_8859_1, "ISO_8859_1");
        return ISO_8859_1;
    }

    public final String b() {
        return this.authParams.get("realm");
    }

    /* JADX INFO: renamed from: c, reason: from getter */
    public final String getScheme() {
        return this.scheme;
    }

    public boolean equals(Object other) {
        if (!(other instanceof h)) {
            return false;
        }
        h hVar = (h) other;
        return Intrinsics.areEqual(hVar.scheme, this.scheme) && Intrinsics.areEqual(hVar.authParams, this.authParams);
    }

    public int hashCode() {
        return ((this.scheme.hashCode() + 899) * 31) + this.authParams.hashCode();
    }

    public String toString() {
        return this.scheme + " authParams=" + this.authParams;
    }
}
