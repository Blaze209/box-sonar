package external.sdk.pendo.io.glide.load.model;

import android.text.TextUtils;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;

/* JADX INFO: loaded from: classes4.dex */
public final class LazyHeaders implements external.sdk.pendo.io.glide.load.model.a {
    private volatile Map<String, String> combinedHeaders;
    private final Map<String, List<sdk.pendo.io.l.a>> headers;

    public static final class a {
        private static final String d;
        private static final Map<String, List<sdk.pendo.io.l.a>> e;
        private boolean a = true;
        private Map<String, List<sdk.pendo.io.l.a>> b = e;
        private boolean c = true;

        static {
            String strB = b();
            d = strB;
            HashMap map = new HashMap(2);
            if (!TextUtils.isEmpty(strB)) {
                map.put("User-Agent", Collections.singletonList(new b(strB)));
            }
            e = Collections.unmodifiableMap(map);
        }

        static String b() {
            String property = System.getProperty("http.agent");
            if (TextUtils.isEmpty(property)) {
                return property;
            }
            int length = property.length();
            StringBuilder sb = new StringBuilder(property.length());
            for (int i = 0; i < length; i++) {
                char cCharAt = property.charAt(i);
                if ((cCharAt <= 31 && cCharAt != '\t') || cCharAt >= 127) {
                    cCharAt = '?';
                }
                sb.append(cCharAt);
            }
            return sb.toString();
        }

        public LazyHeaders a() {
            this.a = true;
            return new LazyHeaders(this.b);
        }
    }

    static final class b implements sdk.pendo.io.l.a {
        private final String a;

        b(String str) {
            this.a = str;
        }

        @Override // sdk.pendo.io.l.a
        public String a() {
            return this.a;
        }

        public boolean equals(Object obj) {
            if (obj instanceof b) {
                return this.a.equals(((b) obj).a);
            }
            return false;
        }

        public int hashCode() {
            return this.a.hashCode();
        }

        public String toString() {
            return "StringHeaderFactory{value='" + this.a + "'}";
        }
    }

    LazyHeaders(Map<String, List<sdk.pendo.io.l.a>> map) {
        this.headers = Collections.unmodifiableMap(map);
    }

    private String buildHeaderValue(List<sdk.pendo.io.l.a> list) {
        StringBuilder sb = new StringBuilder();
        int size = list.size();
        for (int i = 0; i < size; i++) {
            String strA = list.get(i).a();
            if (!TextUtils.isEmpty(strA)) {
                sb.append(strA);
                if (i != list.size() - 1) {
                    sb.append(AbstractJsonLexerKt.COMMA);
                }
            }
        }
        return sb.toString();
    }

    private Map<String, String> generateHeaders() {
        HashMap map = new HashMap();
        for (Map.Entry<String, List<sdk.pendo.io.l.a>> entry : this.headers.entrySet()) {
            String strBuildHeaderValue = buildHeaderValue(entry.getValue());
            if (!TextUtils.isEmpty(strBuildHeaderValue)) {
                map.put(entry.getKey(), strBuildHeaderValue);
            }
        }
        return map;
    }

    public boolean equals(Object obj) {
        if (obj instanceof LazyHeaders) {
            return this.headers.equals(((LazyHeaders) obj).headers);
        }
        return false;
    }

    @Override // external.sdk.pendo.io.glide.load.model.a
    public Map<String, String> getHeaders() {
        if (this.combinedHeaders == null) {
            synchronized (this) {
                if (this.combinedHeaders == null) {
                    this.combinedHeaders = Collections.unmodifiableMap(generateHeaders());
                }
            }
        }
        return this.combinedHeaders;
    }

    public int hashCode() {
        return this.headers.hashCode();
    }

    public String toString() {
        return "LazyHeaders{headers=" + this.headers + AbstractJsonLexerKt.END_OBJ;
    }
}
