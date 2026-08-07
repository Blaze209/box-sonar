package sdk.pendo.io.r5;

import android.view.GestureDetector;
import android.view.MotionEvent;
import androidx.media3.exoplayer.upstream.CmcdData;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0000\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\t\u001a\u00020\u0007¢\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016R\u0014\u0010\t\u001a\u00020\u00078\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0006\u0010\b¨\u0006\f"}, d2 = {"Lsdk/pendo/io/r5/k;", "Lsdk/pendo/io/s5/c;", "Landroid/view/MotionEvent;", "event", "", "b", CmcdData.OBJECT_TYPE_AUDIO_ONLY, "Landroid/view/GestureDetector;", "Landroid/view/GestureDetector;", "gestureDetector", "<init>", "(Landroid/view/GestureDetector;)V", "pendoIO_release"}, k = 1, mv = {1, 9, 0})
public final class k implements sdk.pendo.io.s5.c {

    /* JADX INFO: renamed from: a, reason: from kotlin metadata */
    private final GestureDetector gestureDetector;

    public k(GestureDetector gestureDetector) {
        Intrinsics.checkNotNullParameter(gestureDetector, "gestureDetector");
        this.gestureDetector = gestureDetector;
    }

    @Override // sdk.pendo.io.s5.c
    public void a(MotionEvent event) {
        Intrinsics.checkNotNullParameter(event, "event");
        e eVar = e.a;
        if (eVar.b(event)) {
            eVar.c(event);
            this.gestureDetector.onTouchEvent(event);
        }
    }

    @Override // sdk.pendo.io.s5.c
    public void b(MotionEvent event) {
        Intrinsics.checkNotNullParameter(event, "event");
        e.a.d(event);
    }
}
