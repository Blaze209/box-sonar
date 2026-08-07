package sdk.pendo.io.e2;

import androidx.media3.exoplayer.upstream.CmcdData;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u001a\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001:\u0001\tJ\b\u0010\u0003\u001a\u00020\u0002H&J\b\u0010\u0005\u001a\u00020\u0004H&J\u0010\u0010\t\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006H&J\b\u0010\n\u001a\u00020\bH&J\b\u0010\f\u001a\u00020\u000bH&¨\u0006\r"}, d2 = {"Lsdk/pendo/io/e2/e;", "", "Lsdk/pendo/io/e2/b0;", "request", "Lsdk/pendo/io/e2/d0;", "execute", "Lsdk/pendo/io/e2/f;", "responseCallback", "", CmcdData.OBJECT_TYPE_AUDIO_ONLY, "cancel", "", "isCanceled", "okhttp"}, k = 1, mv = {1, 8, 0})
public interface e extends Cloneable {

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bæ\u0080\u0001\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¨\u0006\u0006"}, d2 = {"Lsdk/pendo/io/e2/e$a;", "", "Lsdk/pendo/io/e2/b0;", "request", "Lsdk/pendo/io/e2/e;", CmcdData.OBJECT_TYPE_AUDIO_ONLY, "okhttp"}, k = 1, mv = {1, 8, 0})
    public interface a {
        e a(b0 request);
    }

    void a(f responseCallback);

    void cancel();

    d0 execute();

    boolean isCanceled();

    b0 request();
}
