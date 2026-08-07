package sdk.pendo.io.f6;

import androidx.media3.exoplayer.upstream.CmcdData;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u0012\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0001\u001a\u0004\u0018\u00010\u0000¨\u0006\u0004"}, d2 = {"", "name", "Lsdk/pendo/io/f6/b;", CmcdData.OBJECT_TYPE_AUDIO_ONLY, "pendoIO_release"}, k = 2, mv = {1, 9, 0})
public final class f {
    public static final b a(String str) {
        b next;
        Iterator<b> it = b.d().iterator();
        while (it.hasNext()) {
            next = it.next();
            if (StringsKt.equals(next.getEndPointName(), str, true)) {
                return next;
            }
        }
        next = null;
        return next;
    }
}
