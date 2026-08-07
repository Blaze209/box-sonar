package sdk.pendo.io.s5;

import android.view.MotionEvent;
import androidx.media3.exoplayer.upstream.CmcdData;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\b`\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¨\u0006\u0007"}, d2 = {"Lsdk/pendo/io/s5/c;", "", "Landroid/view/MotionEvent;", "event", "", "b", CmcdData.OBJECT_TYPE_AUDIO_ONLY, "pendoIO_release"}, k = 1, mv = {1, 9, 0})
public interface c {

    @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
    public static final class a {
        public static void a(c cVar, MotionEvent event) {
            Intrinsics.checkNotNullParameter(event, "event");
        }
    }

    void a(MotionEvent event);

    void b(MotionEvent event);
}
