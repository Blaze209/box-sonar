package sdk.pendo.io.m2;

import androidx.media3.exoplayer.upstream.CmcdData;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\bf\u0018\u0000 \u000f2\u00020\u0001:\u0001\u000fJ\u001e\u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004H&J&\u0010\u000b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010\n\u001a\u00020\u0007H&J(\u0010\u000f\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\u0007H&J\u0018\u0010\u000f\u001a\u00020\u00122\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0011\u001a\u00020\u0010H&¨\u0006\u0013"}, d2 = {"Lsdk/pendo/io/m2/l;", "", "", "streamId", "", "Lsdk/pendo/io/m2/c;", "requestHeaders", "", "onRequest", "responseHeaders", "last", "onHeaders", "Lsdk/pendo/io/s2/f;", "source", "byteCount", CmcdData.OBJECT_TYPE_AUDIO_ONLY, "Lsdk/pendo/io/m2/b;", "errorCode", "", "okhttp"}, k = 1, mv = {1, 8, 0})
public interface l {

    /* JADX INFO: renamed from: a, reason: from kotlin metadata */
    public static final Companion INSTANCE = Companion.a;
    public static final l b = new Companion.C0421a();

    /* JADX INFO: renamed from: sdk.pendo.io.m2.l$a, reason: from kotlin metadata */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0086\u0003\u0018\u00002\u00020\u0001:\u0001\u0007B\t\b\u0002¢\u0006\u0004\b\u0005\u0010\u0006R\u0017\u0010\u0003\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004¨\u0006\u0001¨\u0006\b"}, d2 = {"Lsdk/pendo/io/m2/l$a;", "", "Lsdk/pendo/io/m2/l;", "CANCEL", "Lsdk/pendo/io/m2/l;", "<init>", "()V", CmcdData.OBJECT_TYPE_AUDIO_ONLY, "okhttp"}, k = 1, mv = {1, 8, 0})
    public static final class Companion {
        static final /* synthetic */ Companion a = new Companion();

        /* JADX INFO: renamed from: sdk.pendo.io.m2.l$a$a, reason: collision with other inner class name */
        @Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\b\u0002\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0013\u0010\u0014J\u001e\u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004H\u0016J&\u0010\u000b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010\n\u001a\u00020\u0007H\u0016J(\u0010\u000f\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\u0007H\u0016J\u0018\u0010\u000f\u001a\u00020\u00122\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0011\u001a\u00020\u0010H\u0016¨\u0006\u0015"}, d2 = {"Lsdk/pendo/io/m2/l$a$a;", "Lsdk/pendo/io/m2/l;", "", "streamId", "", "Lsdk/pendo/io/m2/c;", "requestHeaders", "", "onRequest", "responseHeaders", "last", "onHeaders", "Lsdk/pendo/io/s2/f;", "source", "byteCount", CmcdData.OBJECT_TYPE_AUDIO_ONLY, "Lsdk/pendo/io/m2/b;", "errorCode", "", "<init>", "()V", "okhttp"}, k = 1, mv = {1, 8, 0})
        private static final class C0421a implements l {
            @Override // sdk.pendo.io.m2.l
            public boolean a(int streamId, sdk.pendo.io.s2.f source, int byteCount, boolean last) {
                Intrinsics.checkNotNullParameter(source, "source");
                source.skip(byteCount);
                return true;
            }

            @Override // sdk.pendo.io.m2.l
            public boolean onHeaders(int streamId, List<c> responseHeaders, boolean last) {
                Intrinsics.checkNotNullParameter(responseHeaders, "responseHeaders");
                return true;
            }

            @Override // sdk.pendo.io.m2.l
            public boolean onRequest(int streamId, List<c> requestHeaders) {
                Intrinsics.checkNotNullParameter(requestHeaders, "requestHeaders");
                return true;
            }

            @Override // sdk.pendo.io.m2.l
            public void a(int streamId, b errorCode) {
                Intrinsics.checkNotNullParameter(errorCode, "errorCode");
            }
        }

        private Companion() {
        }
    }

    void a(int streamId, b errorCode);

    boolean a(int streamId, sdk.pendo.io.s2.f source, int byteCount, boolean last);

    boolean onHeaders(int streamId, List<c> responseHeaders, boolean last);

    boolean onRequest(int streamId, List<c> requestHeaders);
}
