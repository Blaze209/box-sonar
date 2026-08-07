package sdk.pendo.io.k2;

import androidx.media3.exoplayer.upstream.CmcdData;
import kotlin.Metadata;
import sdk.pendo.io.e2.b0;
import sdk.pendo.io.e2.d0;
import sdk.pendo.io.s2.a0;
import sdk.pendo.io.s2.y;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H&J\u0010\u0010\u0007\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u0002H&J\b\u0010\t\u001a\u00020\bH&J\b\u0010\n\u001a\u00020\bH&J\u0012\u0010\u000e\u001a\u0004\u0018\u00010\r2\u0006\u0010\f\u001a\u00020\u000bH&J\u0010\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00020\u000fH&J\u0010\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0010\u001a\u00020\u000fH&J\b\u0010\u0013\u001a\u00020\bH&R\u0014\u0010\u0017\u001a\u00020\u00148&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0015\u0010\u0016¨\u0006\u0018"}, d2 = {"Lsdk/pendo/io/k2/d;", "", "Lsdk/pendo/io/e2/b0;", "request", "", "contentLength", "Lsdk/pendo/io/s2/y;", CmcdData.OBJECT_TYPE_AUDIO_ONLY, "", "flushRequest", "finishRequest", "", "expectContinue", "Lsdk/pendo/io/e2/d0$a;", "readResponseHeaders", "Lsdk/pendo/io/e2/d0;", "response", "Lsdk/pendo/io/s2/a0;", "b", "cancel", "Lsdk/pendo/io/j2/f;", "getConnection", "()Lokhttp3/internal/connection/RealConnection;", "connection", "okhttp"}, k = 1, mv = {1, 8, 0})
public interface d {
    long a(d0 response);

    y a(b0 request, long contentLength);

    void a(b0 request);

    a0 b(d0 response);

    void cancel();

    void finishRequest();

    void flushRequest();

    sdk.pendo.io.j2.f getConnection();

    d0.a readResponseHeaders(boolean expectContinue);
}
