package sdk.pendo.io.e2;

import androidx.core.app.NotificationCompat;
import androidx.media3.exoplayer.upstream.CmcdData;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bæ\u0080\u0001\u0018\u00002\u00020\u0001:\u0001\u0005J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¨\u0006\u0006"}, d2 = {"Lsdk/pendo/io/e2/w;", "", "Lsdk/pendo/io/e2/w$a;", "chain", "Lsdk/pendo/io/e2/d0;", CmcdData.OBJECT_TYPE_AUDIO_ONLY, "okhttp"}, k = 1, mv = {1, 8, 0})
public interface w {

    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H&J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&J\n\u0010\u0007\u001a\u0004\u0018\u00010\u0006H&J\b\u0010\t\u001a\u00020\bH&¨\u0006\n"}, d2 = {"Lsdk/pendo/io/e2/w$a;", "", "Lsdk/pendo/io/e2/b0;", "request", "Lsdk/pendo/io/e2/d0;", CmcdData.OBJECT_TYPE_AUDIO_ONLY, "Lsdk/pendo/io/e2/j;", "connection", "Lsdk/pendo/io/e2/e;", NotificationCompat.CATEGORY_CALL, "okhttp"}, k = 1, mv = {1, 8, 0})
    public interface a {
        d0 a(b0 request);

        e call();

        j connection();

        b0 request();
    }

    d0 a(a chain);
}
