package sdk.pendo.io.l2;

import androidx.media3.exoplayer.upstream.CmcdData;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import sdk.pendo.io.e2.u;
import sdk.pendo.io.s2.f;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0006\u0018\u0000 \u00102\u00020\u0001:\u0001\u0005B\u000f\u0012\u0006\u0010\n\u001a\u00020\u0006¢\u0006\u0004\b\u000e\u0010\u000fJ\u0006\u0010\u0003\u001a\u00020\u0002J\u0006\u0010\u0005\u001a\u00020\u0004R\u0017\u0010\n\u001a\u00020\u00068\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u0007\u001a\u0004\b\b\u0010\tR\u0016\u0010\r\u001a\u00020\u000b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0003\u0010\f¨\u0006\u0011"}, d2 = {"Lsdk/pendo/io/l2/a;", "", "", "b", "Lsdk/pendo/io/e2/u;", CmcdData.OBJECT_TYPE_AUDIO_ONLY, "Lsdk/pendo/io/s2/f;", "Lsdk/pendo/io/s2/f;", "getSource", "()Lokio/BufferedSource;", "source", "", "J", "headerLimit", "<init>", "(Lokio/BufferedSource;)V", "c", "okhttp"}, k = 1, mv = {1, 8, 0})
public final class a {

    /* JADX INFO: renamed from: a, reason: from kotlin metadata */
    private final f source;

    /* JADX INFO: renamed from: b, reason: from kotlin metadata */
    private long headerLimit;

    public a(f source) {
        Intrinsics.checkNotNullParameter(source, "source");
        this.source = source;
        this.headerLimit = 262144L;
    }

    public final u a() {
        u.a aVar = new u.a();
        while (true) {
            String strB = b();
            if (strB.length() == 0) {
                return aVar.a();
            }
            aVar.a(strB);
        }
    }

    public final String b() {
        String utf8LineStrict = this.source.readUtf8LineStrict(this.headerLimit);
        this.headerLimit -= (long) utf8LineStrict.length();
        return utf8LineStrict;
    }
}
