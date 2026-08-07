package sdk.pendo.io.e2;

import androidx.exifinterface.media.ExifInterface;
import androidx.media3.exoplayer.upstream.CmcdData;
import com.google.firebase.analytics.FirebaseAnalytics;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.ReplaceWith;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010$\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0007\u0018\u00002\u00020\u0001:\u0001\u0004BC\b\u0000\u0012\u0006\u0010\u000f\u001a\u00020\u000b\u0012\u0006\u0010\u0015\u001a\u00020\u0002\u0012\u0006\u0010\u0019\u001a\u00020\u0016\u0012\b\u0010\u001e\u001a\u0004\u0018\u00010\u001b\u0012\u0016\u0010$\u001a\u0012\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u0006\u0012\u0004\u0012\u00020\u00010 ¢\u0006\u0004\b.\u0010/J\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0003\u001a\u00020\u0002J%\u0010\u0004\u001a\u0004\u0018\u00018\u0000\"\u0004\b\u0000\u0010\u00052\u000e\u0010\u0007\u001a\n\u0012\u0006\b\u0001\u0012\u00028\u00000\u0006¢\u0006\u0004\b\u0004\u0010\bJ\u0006\u0010\n\u001a\u00020\tJ\u000f\u0010\u0004\u001a\u00020\u000bH\u0007¢\u0006\u0004\b\u0004\u0010\fJ\b\u0010\r\u001a\u00020\u0002H\u0016R\u0017\u0010\u000f\u001a\u00020\u000b8\u0007¢\u0006\f\n\u0004\b\u0004\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010R\u0017\u0010\u0015\u001a\u00020\u00028\u0007¢\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014R\u0017\u0010\u0019\u001a\u00020\u00168\u0007¢\u0006\f\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0019\u0010\u001aR\u0019\u0010\u001e\u001a\u0004\u0018\u00010\u001b8\u0007¢\u0006\f\n\u0004\b\u001c\u0010\u001d\u001a\u0004\b\u001e\u0010\u001fR*\u0010$\u001a\u0012\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u0006\u0012\u0004\u0012\u00020\u00010 8\u0000X\u0080\u0004¢\u0006\f\n\u0004\b!\u0010\"\u001a\u0004\b\u001c\u0010#R\u0018\u0010(\u001a\u0004\u0018\u00010%8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b&\u0010'R\u0011\u0010+\u001a\u00020)8F¢\u0006\u0006\u001a\u0004\b&\u0010*R\u0011\u0010,\u001a\u00020%8G¢\u0006\u0006\u001a\u0004\b,\u0010-¨\u00060"}, d2 = {"Lsdk/pendo/io/e2/b0;", "", "", "name", CmcdData.OBJECT_TYPE_AUDIO_ONLY, ExifInterface.GPS_DIRECTION_TRUE, "Ljava/lang/Class;", "type", "(Ljava/lang/Class;)Ljava/lang/Object;", "Lsdk/pendo/io/e2/b0$a;", CmcdData.STREAMING_FORMAT_HLS, "Lsdk/pendo/io/e2/v;", "()Lsdk/pendo/io/e2/v;", "toString", "Lsdk/pendo/io/e2/v;", "url", "()Lokhttp3/HttpUrl;", "b", "Ljava/lang/String;", "g", "()Ljava/lang/String;", FirebaseAnalytics.Param.METHOD, "Lsdk/pendo/io/e2/u;", "c", "Lsdk/pendo/io/e2/u;", "headers", "()Lokhttp3/Headers;", "Lsdk/pendo/io/e2/c0;", "d", "Lsdk/pendo/io/e2/c0;", "body", "()Lokhttp3/RequestBody;", "", "e", "Ljava/util/Map;", "()Ljava/util/Map;", "tags", "Lsdk/pendo/io/e2/d;", "f", "Lsdk/pendo/io/e2/d;", "lazyCacheControl", "", "()Z", "isHttps", "cacheControl", "()Lokhttp3/CacheControl;", "<init>", "(Lokhttp3/HttpUrl;Ljava/lang/String;Lokhttp3/Headers;Lokhttp3/RequestBody;Ljava/util/Map;)V", "okhttp"}, k = 1, mv = {1, 8, 0})
public final class b0 {

    /* JADX INFO: renamed from: a, reason: from kotlin metadata */
    private final v url;

    /* JADX INFO: renamed from: b, reason: from kotlin metadata */
    private final String method;

    /* JADX INFO: renamed from: c, reason: from kotlin metadata */
    private final u headers;

    /* JADX INFO: renamed from: d, reason: from kotlin metadata */
    private final c0 body;

    /* JADX INFO: renamed from: e, reason: from kotlin metadata */
    private final Map<Class<?>, Object> tags;

    /* JADX INFO: renamed from: f, reason: from kotlin metadata */
    private d lazyCacheControl;

    @Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010%\n\u0002\b\f\b\u0016\u0018\u00002\u00020\u0001B\u0011\b\u0010\u0012\u0006\u00103\u001a\u00020\u000e¢\u0006\u0004\b4\u00105B\t\b\u0016¢\u0006\u0004\b4\u00106J\u0010\u0010\u0004\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\u0006\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0005H\u0016J\u0018\u0010\u0006\u001a\u00020\u00002\u0006\u0010\u0007\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0005H\u0016J\u0018\u0010\u0004\u001a\u00020\u00002\u0006\u0010\u0007\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0005H\u0016J\u0010\u0010\u0004\u001a\u00020\u00002\u0006\u0010\u0007\u001a\u00020\u0005H\u0016J\u0010\u0010\u0004\u001a\u00020\u00002\u0006\u0010\n\u001a\u00020\tH\u0016J\u001a\u0010\u0004\u001a\u00020\u00002\u0006\u0010\u000b\u001a\u00020\u00052\b\u0010\r\u001a\u0004\u0018\u00010\fH\u0016J\b\u0010\u0004\u001a\u00020\u000eH\u0016J/\u0010\u0012\u001a\u00020\u0000\"\u0004\b\u0000\u0010\u000f2\u000e\u0010\u0011\u001a\n\u0012\u0006\b\u0000\u0012\u00028\u00000\u00102\b\u0010\u0012\u001a\u0004\u0018\u00018\u0000H\u0016¢\u0006\u0004\b\u0012\u0010\u0013R$\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0000@\u0000X\u0080\u000e¢\u0006\u0012\n\u0004\b\u0004\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\"\u0010\u000b\u001a\u00020\u00058\u0000@\u0000X\u0080\u000e¢\u0006\u0012\n\u0004\b\u0006\u0010\u0019\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR\"\u0010\n\u001a\u00020\u001e8\u0000@\u0000X\u0080\u000e¢\u0006\u0012\n\u0004\b\u001f\u0010 \u001a\u0004\b!\u0010\"\"\u0004\b#\u0010$R$\u0010\r\u001a\u0004\u0018\u00010\f8\u0000@\u0000X\u0080\u000e¢\u0006\u0012\n\u0004\b%\u0010&\u001a\u0004\b'\u0010(\"\u0004\b)\u0010*R2\u00102\u001a\u0012\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u0010\u0012\u0004\u0012\u00020\u00010+8\u0000@\u0000X\u0080\u000e¢\u0006\u0012\n\u0004\b,\u0010-\u001a\u0004\b.\u0010/\"\u0004\b0\u00101¨\u00067"}, d2 = {"Lsdk/pendo/io/e2/b0$a;", "", "Lsdk/pendo/io/e2/v;", "url", CmcdData.OBJECT_TYPE_AUDIO_ONLY, "", "b", "name", "value", "Lsdk/pendo/io/e2/u;", "headers", FirebaseAnalytics.Param.METHOD, "Lsdk/pendo/io/e2/c0;", "body", "Lsdk/pendo/io/e2/b0;", ExifInterface.GPS_DIRECTION_TRUE, "Ljava/lang/Class;", "type", "tag", "(Ljava/lang/Class;Ljava/lang/Object;)Lokhttp3/Request$Builder;", "Lsdk/pendo/io/e2/v;", "getUrl$okhttp", "()Lokhttp3/HttpUrl;", "setUrl$okhttp", "(Lokhttp3/HttpUrl;)V", "Ljava/lang/String;", "getMethod$okhttp", "()Ljava/lang/String;", "setMethod$okhttp", "(Ljava/lang/String;)V", "Lsdk/pendo/io/e2/u$a;", "c", "Lsdk/pendo/io/e2/u$a;", "getHeaders$okhttp", "()Lokhttp3/Headers$Builder;", "setHeaders$okhttp", "(Lokhttp3/Headers$Builder;)V", "d", "Lsdk/pendo/io/e2/c0;", "getBody$okhttp", "()Lokhttp3/RequestBody;", "setBody$okhttp", "(Lokhttp3/RequestBody;)V", "", "e", "Ljava/util/Map;", "getTags$okhttp", "()Ljava/util/Map;", "setTags$okhttp", "(Ljava/util/Map;)V", "tags", "request", "<init>", "(Lokhttp3/Request;)V", "()V", "okhttp"}, k = 1, mv = {1, 8, 0})
    public static class a {

        /* JADX INFO: renamed from: a, reason: from kotlin metadata */
        private v url;

        /* JADX INFO: renamed from: b, reason: from kotlin metadata */
        private String method;

        /* JADX INFO: renamed from: c, reason: from kotlin metadata */
        private u.a headers;

        /* JADX INFO: renamed from: d, reason: from kotlin metadata */
        private c0 body;

        /* JADX INFO: renamed from: e, reason: from kotlin metadata */
        private Map<Class<?>, Object> tags;

        public a() {
            this.tags = new LinkedHashMap();
            this.method = "GET";
            this.headers = new u.a();
        }

        public a a(String name, String value) {
            Intrinsics.checkNotNullParameter(name, "name");
            Intrinsics.checkNotNullParameter(value, "value");
            this.headers.a(name, value);
            return this;
        }

        public a b(String name, String value) {
            Intrinsics.checkNotNullParameter(name, "name");
            Intrinsics.checkNotNullParameter(value, "value");
            this.headers.c(name, value);
            return this;
        }

        public a(b0 request) {
            Intrinsics.checkNotNullParameter(request, "request");
            this.tags = new LinkedHashMap();
            this.url = request.i();
            this.method = request.getMethod();
            this.body = request.getBody();
            this.tags = request.d().isEmpty() ? new LinkedHashMap<>() : MapsKt.toMutableMap(request.d());
            this.headers = request.getHeaders().a();
        }

        public b0 a() {
            v vVar = this.url;
            if (vVar != null) {
                return new b0(vVar, this.method, this.headers.a(), this.body, sdk.pendo.io.f2.b.a(this.tags));
            }
            throw new IllegalStateException("url == null".toString());
        }

        public a b(String url) {
            StringBuilder sb;
            int i;
            Intrinsics.checkNotNullParameter(url, "url");
            if (!StringsKt.startsWith(url, "ws:", true)) {
                if (StringsKt.startsWith(url, "wss:", true)) {
                    sb = new StringBuilder("https:");
                    i = 4;
                }
                return a(v.INSTANCE.b(url));
            }
            sb = new StringBuilder("http:");
            i = 3;
            String strSubstring = url.substring(i);
            Intrinsics.checkNotNullExpressionValue(strSubstring, "this as java.lang.String).substring(startIndex)");
            url = sb.append(strSubstring).toString();
            return a(v.INSTANCE.b(url));
        }

        public a a(u headers) {
            Intrinsics.checkNotNullParameter(headers, "headers");
            this.headers = headers.a();
            return this;
        }

        public a a(String method, c0 body) {
            Intrinsics.checkNotNullParameter(method, "method");
            if (method.length() <= 0) {
                throw new IllegalArgumentException("method.isEmpty() == true".toString());
            }
            if (body == null) {
                if (sdk.pendo.io.k2.f.d(method)) {
                    throw new IllegalArgumentException(("method " + method + " must have a request body.").toString());
                }
            } else if (!sdk.pendo.io.k2.f.a(method)) {
                throw new IllegalArgumentException(("method " + method + " must not have a request body.").toString());
            }
            this.method = method;
            this.body = body;
            return this;
        }

        public a a(String name) {
            Intrinsics.checkNotNullParameter(name, "name");
            this.headers.b(name);
            return this;
        }

        public <T> a a(Class<? super T> type, T t) {
            Intrinsics.checkNotNullParameter(type, "type");
            if (t == null) {
                this.tags.remove(type);
                return this;
            }
            if (this.tags.isEmpty()) {
                this.tags = new LinkedHashMap();
            }
            Map<Class<?>, Object> map = this.tags;
            T tCast = type.cast(t);
            Intrinsics.checkNotNull(tCast);
            map.put(type, tCast);
            return this;
        }

        public a a(v url) {
            Intrinsics.checkNotNullParameter(url, "url");
            this.url = url;
            return this;
        }
    }

    public b0(v url, String method, u headers, c0 c0Var, Map<Class<?>, ? extends Object> tags) {
        Intrinsics.checkNotNullParameter(url, "url");
        Intrinsics.checkNotNullParameter(method, "method");
        Intrinsics.checkNotNullParameter(headers, "headers");
        Intrinsics.checkNotNullParameter(tags, "tags");
        this.url = url;
        this.method = method;
        this.headers = headers;
        this.body = c0Var;
        this.tags = tags;
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @ReplaceWith(expression = "url", imports = {}))
    /* JADX INFO: renamed from: a, reason: from getter */
    public final v getUrl() {
        return this.url;
    }

    /* JADX INFO: renamed from: b, reason: from getter */
    public final c0 getBody() {
        return this.body;
    }

    public final d c() {
        d dVar = this.lazyCacheControl;
        if (dVar != null) {
            return dVar;
        }
        d dVarA = d.INSTANCE.a(this.headers);
        this.lazyCacheControl = dVarA;
        return dVarA;
    }

    public final Map<Class<?>, Object> d() {
        return this.tags;
    }

    /* JADX INFO: renamed from: e, reason: from getter */
    public final u getHeaders() {
        return this.headers;
    }

    public final boolean f() {
        return this.url.getIsHttps();
    }

    /* JADX INFO: renamed from: g, reason: from getter */
    public final String getMethod() {
        return this.method;
    }

    public final a h() {
        return new a(this);
    }

    public final v i() {
        return this.url;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("Request{method=");
        sb.append(this.method);
        sb.append(", url=");
        sb.append(this.url);
        if (this.headers.size() != 0) {
            sb.append(", headers=[");
            int i = 0;
            for (Pair<? extends String, ? extends String> pair : this.headers) {
                int i2 = i + 1;
                if (i < 0) {
                    CollectionsKt.throwIndexOverflow();
                }
                Pair<? extends String, ? extends String> pair2 = pair;
                String strComponent1 = pair2.component1();
                String strComponent2 = pair2.component2();
                if (i > 0) {
                    sb.append(", ");
                }
                sb.append(strComponent1);
                sb.append(AbstractJsonLexerKt.COLON);
                sb.append(strComponent2);
                i = i2;
            }
            sb.append(AbstractJsonLexerKt.END_LIST);
        }
        if (!this.tags.isEmpty()) {
            sb.append(", tags=");
            sb.append(this.tags);
        }
        sb.append(AbstractJsonLexerKt.END_OBJ);
        String string = sb.toString();
        Intrinsics.checkNotNullExpressionValue(string, "StringBuilder().apply(builderAction).toString()");
        return string;
    }

    public final String a(String name) {
        Intrinsics.checkNotNullParameter(name, "name");
        return this.headers.a(name);
    }

    public final <T> T a(Class<? extends T> type) {
        Intrinsics.checkNotNullParameter(type, "type");
        return type.cast(this.tags.get(type));
    }
}
