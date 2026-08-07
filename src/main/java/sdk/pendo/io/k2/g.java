package sdk.pendo.io.k2;

import androidx.core.app.NotificationCompat;
import androidx.media3.exoplayer.upstream.CmcdData;
import com.google.firebase.analytics.FirebaseAnalytics;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import sdk.pendo.io.e2.b0;
import sdk.pendo.io.e2.d0;
import sdk.pendo.io.e2.w;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0015\u0018\u00002\u00020\u0001BO\u0012\u0006\u0010\u0011\u001a\u00020\u0013\u0012\f\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u00180\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\u0006\u0010\b\u001a\u00020\u0002\u0012\u0006\u0010\t\u001a\u00020\u0002\u0012\u0006\u0010\n\u001a\u00020\u0002¢\u0006\u0004\b+\u0010,JM\u0010\u000b\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00022\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\b\u0002\u0010\u0007\u001a\u00020\u00062\b\b\u0002\u0010\b\u001a\u00020\u00022\b\b\u0002\u0010\t\u001a\u00020\u00022\b\b\u0002\u0010\n\u001a\u00020\u0002H\u0000¢\u0006\u0004\b\u000b\u0010\fJ\n\u0010\u000e\u001a\u0004\u0018\u00010\rH\u0016J\b\u0010\u000f\u001a\u00020\u0002H\u0016J\b\u0010\u0011\u001a\u00020\u0010H\u0016J\b\u0010\u0007\u001a\u00020\u0006H\u0016J\u0010\u0010\u000b\u001a\u00020\u00122\u0006\u0010\u0007\u001a\u00020\u0006H\u0016R\u001a\u0010\u0011\u001a\u00020\u00138\u0000X\u0080\u0004¢\u0006\f\n\u0004\b\u000b\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016R\u001a\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u00180\u00178\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0019\u0010\u001aR\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001c\u0010\u001dR\u001c\u0010\u0005\u001a\u0004\u0018\u00010\u00048\u0000X\u0080\u0004¢\u0006\f\n\u0004\b\u001e\u0010\u001f\u001a\u0004\b \u0010!R\u001a\u0010\u0007\u001a\u00020\u00068\u0000X\u0080\u0004¢\u0006\f\n\u0004\b\"\u0010#\u001a\u0004\b$\u0010%R\u001a\u0010\b\u001a\u00020\u00028\u0000X\u0080\u0004¢\u0006\f\n\u0004\b&\u0010\u001d\u001a\u0004\b\u0019\u0010'R\u001a\u0010\t\u001a\u00020\u00028\u0000X\u0080\u0004¢\u0006\f\n\u0004\b\u000f\u0010\u001d\u001a\u0004\b\u001e\u0010'R\u001a\u0010\n\u001a\u00020\u00028\u0000X\u0080\u0004¢\u0006\f\n\u0004\b(\u0010\u001d\u001a\u0004\b&\u0010'R\u0016\u0010*\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b)\u0010\u001d¨\u0006-"}, d2 = {"Lsdk/pendo/io/k2/g;", "Lsdk/pendo/io/e2/w$a;", "", FirebaseAnalytics.Param.INDEX, "Lsdk/pendo/io/j2/c;", "exchange", "Lsdk/pendo/io/e2/b0;", "request", "connectTimeoutMillis", "readTimeoutMillis", "writeTimeoutMillis", CmcdData.OBJECT_TYPE_AUDIO_ONLY, "(ILsdk/pendo/io/j2/c;Lsdk/pendo/io/e2/b0;III)Lsdk/pendo/io/k2/g;", "Lsdk/pendo/io/e2/j;", "connection", "g", "Lsdk/pendo/io/e2/e;", NotificationCompat.CATEGORY_CALL, "Lsdk/pendo/io/e2/d0;", "Lsdk/pendo/io/j2/e;", "Lsdk/pendo/io/j2/e;", "getCall$okhttp", "()Lokhttp3/internal/connection/RealCall;", "", "Lsdk/pendo/io/e2/w;", "b", "Ljava/util/List;", "interceptors", "c", "I", "d", "Lsdk/pendo/io/j2/c;", "getExchange$okhttp", "()Lokhttp3/internal/connection/Exchange;", "e", "Lsdk/pendo/io/e2/b0;", "getRequest$okhttp", "()Lokhttp3/Request;", "f", "()I", CmcdData.STREAMING_FORMAT_HLS, "i", "calls", "<init>", "(Lokhttp3/internal/connection/RealCall;Ljava/util/List;ILokhttp3/internal/connection/Exchange;Lokhttp3/Request;III)V", "okhttp"}, k = 1, mv = {1, 8, 0})
public final class g implements w.a {

    /* JADX INFO: renamed from: a, reason: from kotlin metadata */
    private final sdk.pendo.io.j2.e call;

    /* JADX INFO: renamed from: b, reason: from kotlin metadata */
    private final List<w> interceptors;

    /* JADX INFO: renamed from: c, reason: from kotlin metadata */
    private final int index;

    /* JADX INFO: renamed from: d, reason: from kotlin metadata */
    private final sdk.pendo.io.j2.c exchange;

    /* JADX INFO: renamed from: e, reason: from kotlin metadata */
    private final b0 request;

    /* JADX INFO: renamed from: f, reason: from kotlin metadata */
    private final int connectTimeoutMillis;

    /* JADX INFO: renamed from: g, reason: from kotlin metadata */
    private final int readTimeoutMillis;

    /* JADX INFO: renamed from: h, reason: from kotlin metadata */
    private final int writeTimeoutMillis;

    /* JADX INFO: renamed from: i, reason: from kotlin metadata */
    private int calls;

    /* JADX WARN: Multi-variable type inference failed */
    public g(sdk.pendo.io.j2.e call, List<? extends w> interceptors, int i, sdk.pendo.io.j2.c cVar, b0 request, int i2, int i3, int i4) {
        Intrinsics.checkNotNullParameter(call, "call");
        Intrinsics.checkNotNullParameter(interceptors, "interceptors");
        Intrinsics.checkNotNullParameter(request, "request");
        this.call = call;
        this.interceptors = interceptors;
        this.index = i;
        this.exchange = cVar;
        this.request = request;
        this.connectTimeoutMillis = i2;
        this.readTimeoutMillis = i3;
        this.writeTimeoutMillis = i4;
    }

    public final g a(int index, sdk.pendo.io.j2.c exchange, b0 request, int connectTimeoutMillis, int readTimeoutMillis, int writeTimeoutMillis) {
        Intrinsics.checkNotNullParameter(request, "request");
        return new g(this.call, this.interceptors, index, exchange, request, connectTimeoutMillis, readTimeoutMillis, writeTimeoutMillis);
    }

    /* JADX INFO: renamed from: b, reason: from getter */
    public final int getConnectTimeoutMillis() {
        return this.connectTimeoutMillis;
    }

    /* JADX INFO: renamed from: c, reason: from getter */
    public final sdk.pendo.io.j2.c getExchange() {
        return this.exchange;
    }

    @Override // sdk.pendo.io.e2.w.a
    public sdk.pendo.io.e2.e call() {
        return this.call;
    }

    @Override // sdk.pendo.io.e2.w.a
    public sdk.pendo.io.e2.j connection() {
        sdk.pendo.io.j2.c cVar = this.exchange;
        if (cVar != null) {
            return cVar.getConnection();
        }
        return null;
    }

    /* JADX INFO: renamed from: d, reason: from getter */
    public final int getReadTimeoutMillis() {
        return this.readTimeoutMillis;
    }

    /* JADX INFO: renamed from: e, reason: from getter */
    public final b0 getRequest() {
        return this.request;
    }

    /* JADX INFO: renamed from: f, reason: from getter */
    public final int getWriteTimeoutMillis() {
        return this.writeTimeoutMillis;
    }

    public int g() {
        return this.readTimeoutMillis;
    }

    @Override // sdk.pendo.io.e2.w.a
    public b0 request() {
        return this.request;
    }

    public static /* synthetic */ g a(g gVar, int i, sdk.pendo.io.j2.c cVar, b0 b0Var, int i2, int i3, int i4, int i5, Object obj) {
        if ((i5 & 1) != 0) {
            i = gVar.index;
        }
        if ((i5 & 2) != 0) {
            cVar = gVar.exchange;
        }
        if ((i5 & 4) != 0) {
            b0Var = gVar.request;
        }
        if ((i5 & 8) != 0) {
            i2 = gVar.connectTimeoutMillis;
        }
        if ((i5 & 16) != 0) {
            i3 = gVar.readTimeoutMillis;
        }
        if ((i5 & 32) != 0) {
            i4 = gVar.writeTimeoutMillis;
        }
        int i6 = i3;
        int i7 = i4;
        return gVar.a(i, cVar, b0Var, i2, i6, i7);
    }

    /* JADX INFO: renamed from: a, reason: from getter */
    public final sdk.pendo.io.j2.e getCall() {
        return this.call;
    }

    @Override // sdk.pendo.io.e2.w.a
    public d0 a(b0 request) {
        Intrinsics.checkNotNullParameter(request, "request");
        if (this.index >= this.interceptors.size()) {
            throw new IllegalStateException("Check failed.".toString());
        }
        this.calls++;
        sdk.pendo.io.j2.c cVar = this.exchange;
        if (cVar != null) {
            if (!cVar.getFinder().a(request.i())) {
                throw new IllegalStateException(("network interceptor " + this.interceptors.get(this.index - 1) + " must retain the same host and port").toString());
            }
            if (this.calls != 1) {
                throw new IllegalStateException(("network interceptor " + this.interceptors.get(this.index - 1) + " must call proceed() exactly once").toString());
            }
        }
        g gVarA = a(this, this.index + 1, null, request, 0, 0, 0, 58, null);
        w wVar = this.interceptors.get(this.index);
        d0 d0VarA = wVar.a(gVarA);
        if (d0VarA == null) {
            throw new NullPointerException("interceptor " + wVar + " returned null");
        }
        if (this.exchange != null && this.index + 1 < this.interceptors.size() && gVarA.calls != 1) {
            throw new IllegalStateException(("network interceptor " + wVar + " must call proceed() exactly once").toString());
        }
        if (d0VarA.b() != null) {
            return d0VarA;
        }
        throw new IllegalStateException(("interceptor " + wVar + " returned a response with no body").toString());
    }
}
