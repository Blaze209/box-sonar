package sdk.pendo.io.h2;

import androidx.media3.exoplayer.upstream.CmcdData;
import com.box.androidsdk.content.models.BoxItem;
import java.util.Date;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import sdk.pendo.io.e2.b0;
import sdk.pendo.io.e2.d;
import sdk.pendo.io.e2.d0;
import sdk.pendo.io.e2.u;
import sdk.pendo.io.k2.c;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u0000 \u00102\u00020\u0001:\u0002\u0003\tB\u001d\b\u0000\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\r\u001a\u0004\u0018\u00010\b¢\u0006\u0004\b\u000e\u0010\u000fR\u0019\u0010\u0007\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u0019\u0010\r\u001a\u0004\u0018\u00010\b8\u0006¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\f¨\u0006\u0011"}, d2 = {"Lsdk/pendo/io/h2/b;", "", "Lsdk/pendo/io/e2/b0;", CmcdData.OBJECT_TYPE_AUDIO_ONLY, "Lsdk/pendo/io/e2/b0;", "getNetworkRequest", "()Lokhttp3/Request;", "networkRequest", "Lsdk/pendo/io/e2/d0;", "b", "Lsdk/pendo/io/e2/d0;", "getCacheResponse", "()Lokhttp3/Response;", "cacheResponse", "<init>", "(Lokhttp3/Request;Lokhttp3/Response;)V", "c", "okhttp"}, k = 1, mv = {1, 8, 0})
public final class b {

    /* JADX INFO: renamed from: c, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* JADX INFO: renamed from: a, reason: from kotlin metadata */
    private final b0 networkRequest;

    /* JADX INFO: renamed from: b, reason: from kotlin metadata */
    private final d0 cacheResponse;

    /* JADX INFO: renamed from: sdk.pendo.io.h2.b$a, reason: from kotlin metadata */
    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\b\u0010\tJ\u0016\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004¨\u0006\n"}, d2 = {"Lsdk/pendo/io/h2/b$a;", "", "Lsdk/pendo/io/e2/d0;", "response", "Lsdk/pendo/io/e2/b0;", "request", "", CmcdData.OBJECT_TYPE_AUDIO_ONLY, "<init>", "()V", "okhttp"}, k = 1, mv = {1, 8, 0})
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* JADX WARN: Code duplicated, block: B:24:0x003b  */
        public final boolean a(d0 response, b0 request) {
            Intrinsics.checkNotNullParameter(response, "response");
            Intrinsics.checkNotNullParameter(request, "request");
            int code = response.getCode();
            if (code != 200 && code != 410 && code != 414 && code != 501 && code != 203 && code != 204) {
                if (code == 307) {
                    if (d0.a(response, "Expires", null, 2, null) == null && response.c().getMaxAgeSeconds() == -1 && !response.c().getIsPublic() && !response.c().getIsPrivate()) {
                        return false;
                    }
                } else if (code != 308 && code != 404 && code != 405) {
                    switch (code) {
                        case 300:
                        case 301:
                            break;
                        case 302:
                            if (d0.a(response, "Expires", null, 2, null) == null) {
                                return false;
                            }
                            break;
                        default:
                            return false;
                    }
                }
            }
            return (response.c().getNoStore() || request.c().getNoStore()) ? false : true;
        }
    }

    /* JADX INFO: renamed from: sdk.pendo.io.h2.b$b, reason: collision with other inner class name */
    @Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u000e\n\u0002\u0010\b\n\u0002\b\u0006\u0018\u00002\u00020\u0001B!\u0012\u0006\u0010\r\u001a\u00020\u0006\u0012\u0006\u0010\n\u001a\u00020\t\u0012\b\u0010\u0013\u001a\u0004\u0018\u00010\u0011¢\u0006\u0004\b*\u0010+J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0005\u001a\u00020\u0004H\u0002J\b\u0010\u0007\u001a\u00020\u0006H\u0002J\b\u0010\b\u001a\u00020\u0006H\u0002J\u0010\u0010\b\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\tH\u0002J\u0006\u0010\u000b\u001a\u00020\u0004R\u0014\u0010\r\u001a\u00020\u00068\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\b\u0010\fR\u001a\u0010\n\u001a\u00020\t8\u0000X\u0080\u0004¢\u0006\f\n\u0004\b\u000b\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010R\u0016\u0010\u0013\u001a\u0004\u0018\u00010\u00118\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0005\u0010\u0012R\u0018\u0010\u0016\u001a\u0004\u0018\u00010\u00148\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0007\u0010\u0015R\u0018\u0010\u0019\u001a\u0004\u0018\u00010\u00178\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0003\u0010\u0018R\u0018\u0010\u001b\u001a\u0004\u0018\u00010\u00148\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001a\u0010\u0015R\u0018\u0010\u001d\u001a\u0004\u0018\u00010\u00178\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001c\u0010\u0018R\u0018\u0010\u001f\u001a\u0004\u0018\u00010\u00148\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001e\u0010\u0015R\u0016\u0010!\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b \u0010\fR\u0016\u0010#\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\"\u0010\fR\u0018\u0010%\u001a\u0004\u0018\u00010\u00178\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b$\u0010\u0018R\u0016\u0010)\u001a\u00020&8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b'\u0010(¨\u0006,"}, d2 = {"Lsdk/pendo/io/h2/b$b;", "", "", "e", "Lsdk/pendo/io/h2/b;", "c", "", "d", CmcdData.OBJECT_TYPE_AUDIO_ONLY, "Lsdk/pendo/io/e2/b0;", "request", "b", "J", "nowMillis", "Lsdk/pendo/io/e2/b0;", "getRequest$okhttp", "()Lokhttp3/Request;", "Lsdk/pendo/io/e2/d0;", "Lsdk/pendo/io/e2/d0;", "cacheResponse", "Ljava/util/Date;", "Ljava/util/Date;", "servedDate", "", "Ljava/lang/String;", "servedDateString", "f", "lastModified", "g", "lastModifiedString", CmcdData.STREAMING_FORMAT_HLS, "expires", "i", "sentRequestMillis", "j", "receivedResponseMillis", "k", BoxItem.FIELD_ETAG, "", CmcdData.STREAM_TYPE_LIVE, "I", "ageSeconds", "<init>", "(JLokhttp3/Request;Lokhttp3/Response;)V", "okhttp"}, k = 1, mv = {1, 8, 0})
    public static final class C0393b {

        /* JADX INFO: renamed from: a, reason: from kotlin metadata */
        private final long nowMillis;

        /* JADX INFO: renamed from: b, reason: from kotlin metadata */
        private final b0 request;

        /* JADX INFO: renamed from: c, reason: from kotlin metadata */
        private final d0 cacheResponse;

        /* JADX INFO: renamed from: d, reason: from kotlin metadata */
        private Date servedDate;

        /* JADX INFO: renamed from: e, reason: from kotlin metadata */
        private String servedDateString;

        /* JADX INFO: renamed from: f, reason: from kotlin metadata */
        private Date lastModified;

        /* JADX INFO: renamed from: g, reason: from kotlin metadata */
        private String lastModifiedString;

        /* JADX INFO: renamed from: h, reason: from kotlin metadata */
        private Date expires;

        /* JADX INFO: renamed from: i, reason: from kotlin metadata */
        private long sentRequestMillis;

        /* JADX INFO: renamed from: j, reason: from kotlin metadata */
        private long receivedResponseMillis;

        /* JADX INFO: renamed from: k, reason: from kotlin metadata */
        private String etag;

        /* JADX INFO: renamed from: l, reason: from kotlin metadata */
        private int ageSeconds;

        public C0393b(long j, b0 request, d0 d0Var) {
            Intrinsics.checkNotNullParameter(request, "request");
            this.nowMillis = j;
            this.request = request;
            this.cacheResponse = d0Var;
            this.ageSeconds = -1;
            if (d0Var != null) {
                this.sentRequestMillis = d0Var.getSentRequestAtMillis();
                this.receivedResponseMillis = d0Var.getReceivedResponseAtMillis();
                u headers = d0Var.getHeaders();
                int size = headers.size();
                for (int i = 0; i < size; i++) {
                    String strA = headers.a(i);
                    String strB = headers.b(i);
                    if (StringsKt.equals(strA, "Date", true)) {
                        this.servedDate = c.a(strB);
                        this.servedDateString = strB;
                    } else if (StringsKt.equals(strA, "Expires", true)) {
                        this.expires = c.a(strB);
                    } else if (StringsKt.equals(strA, "Last-Modified", true)) {
                        this.lastModified = c.a(strB);
                        this.lastModifiedString = strB;
                    } else if (StringsKt.equals(strA, "ETag", true)) {
                        this.etag = strB;
                    } else if (StringsKt.equals(strA, "Age", true)) {
                        this.ageSeconds = sdk.pendo.io.f2.b.b(strB, -1);
                    }
                }
            }
        }

        private final long a() {
            Date date = this.servedDate;
            long jMax = date != null ? Math.max(0L, this.receivedResponseMillis - date.getTime()) : 0L;
            int i = this.ageSeconds;
            if (i != -1) {
                jMax = Math.max(jMax, TimeUnit.SECONDS.toMillis(i));
            }
            long j = this.receivedResponseMillis;
            return jMax + (j - this.sentRequestMillis) + (this.nowMillis - j);
        }

        private final b c() {
            String str;
            if (this.cacheResponse == null) {
                return new b(this.request, null);
            }
            if ((!this.request.f() || this.cacheResponse.getHandshake() != null) && b.INSTANCE.a(this.cacheResponse, this.request)) {
                d dVarC = this.request.c();
                if (dVarC.getNoCache() || a(this.request)) {
                    return new b(this.request, null);
                }
                d dVarC2 = this.cacheResponse.c();
                long jA = a();
                long jD = d();
                if (dVarC.getMaxAgeSeconds() != -1) {
                    jD = Math.min(jD, TimeUnit.SECONDS.toMillis(dVarC.getMaxAgeSeconds()));
                }
                long millis = 0;
                long millis2 = dVarC.getMinFreshSeconds() != -1 ? TimeUnit.SECONDS.toMillis(dVarC.getMinFreshSeconds()) : 0L;
                if (!dVarC2.getMustRevalidate() && dVarC.getMaxStaleSeconds() != -1) {
                    millis = TimeUnit.SECONDS.toMillis(dVarC.getMaxStaleSeconds());
                }
                if (!dVarC2.getNoCache()) {
                    long j = millis2 + jA;
                    if (j < millis + jD) {
                        d0.a aVarM = this.cacheResponse.m();
                        if (j >= jD) {
                            aVarM.a("Warning", "110 HttpURLConnection \"Response is stale\"");
                        }
                        if (jA > 86400000 && e()) {
                            aVarM.a("Warning", "113 HttpURLConnection \"Heuristic expiration\"");
                        }
                        return new b(null, aVarM.a());
                    }
                }
                String str2 = this.etag;
                if (str2 != null) {
                    str = "If-None-Match";
                } else {
                    if (this.lastModified != null) {
                        str2 = this.lastModifiedString;
                    } else {
                        if (this.servedDate == null) {
                            return new b(this.request, null);
                        }
                        str2 = this.servedDateString;
                    }
                    str = "If-Modified-Since";
                }
                u.a aVarA = this.request.getHeaders().a();
                Intrinsics.checkNotNull(str2);
                aVarA.b(str, str2);
                return new b(this.request.h().a(aVarA.a()).a(), this.cacheResponse);
            }
            return new b(this.request, null);
        }

        private final long d() {
            d0 d0Var = this.cacheResponse;
            Intrinsics.checkNotNull(d0Var);
            d dVarC = d0Var.c();
            if (dVarC.getMaxAgeSeconds() != -1) {
                return TimeUnit.SECONDS.toMillis(dVarC.getMaxAgeSeconds());
            }
            Date date = this.expires;
            if (date != null) {
                Date date2 = this.servedDate;
                long time = date.getTime() - (date2 != null ? date2.getTime() : this.receivedResponseMillis);
                if (time > 0) {
                    return time;
                }
                return 0L;
            }
            if (this.lastModified != null && this.cacheResponse.getRequest().i().m() == null) {
                Date date3 = this.servedDate;
                long time2 = date3 != null ? date3.getTime() : this.sentRequestMillis;
                Date date4 = this.lastModified;
                Intrinsics.checkNotNull(date4);
                long time3 = time2 - date4.getTime();
                if (time3 > 0) {
                    return time3 / ((long) 10);
                }
            }
            return 0L;
        }

        private final boolean e() {
            d0 d0Var = this.cacheResponse;
            Intrinsics.checkNotNull(d0Var);
            return d0Var.c().getMaxAgeSeconds() == -1 && this.expires == null;
        }

        public final b b() {
            b bVarC = c();
            return (bVarC.getNetworkRequest() == null || !this.request.c().getOnlyIfCached()) ? bVarC : new b(null, null);
        }

        private final boolean a(b0 request) {
            return (request.a("If-Modified-Since") == null && request.a("If-None-Match") == null) ? false : true;
        }
    }

    public b(b0 b0Var, d0 d0Var) {
        this.networkRequest = b0Var;
        this.cacheResponse = d0Var;
    }

    /* JADX INFO: renamed from: a, reason: from getter */
    public final d0 getCacheResponse() {
        return this.cacheResponse;
    }

    /* JADX INFO: renamed from: b, reason: from getter */
    public final b0 getNetworkRequest() {
        return this.networkRequest;
    }
}
