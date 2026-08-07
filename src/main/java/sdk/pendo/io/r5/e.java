package sdk.pendo.io.r5;

import android.view.MotionEvent;
import androidx.media3.exoplayer.upstream.CmcdData;
import com.microsoft.identity.common.java.cache.CacheKeyValueDelegate;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import sdk.pendo.io.logging.PendoLogger;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010#\n\u0000\n\u0002\u0010\"\n\u0002\b\u0005\bÀ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0010\u0010\u0011J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u000e\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\n\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u0002R8\u0010\u000f\u001a&\u0012\f\u0012\n \f*\u0004\u0018\u00010\u00040\u0004 \f*\u0012\u0012\f\u0012\n \f*\u0004\u0018\u00010\u00040\u0004\u0018\u00010\r0\u000b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\n\u0010\u000e¨\u0006\u0012"}, d2 = {"Lsdk/pendo/io/r5/e;", "", "Landroid/view/MotionEvent;", "event", "", CmcdData.OBJECT_TYPE_AUDIO_ONLY, "d", "", "c", "", "b", "", "kotlin.jvm.PlatformType", "", "Ljava/util/Set;", "unprocessedClicks", "<init>", "()V", "pendoIO_release"}, k = 1, mv = {1, 9, 0})
public final class e {
    public static final e a = new e();

    /* JADX INFO: renamed from: b, reason: from kotlin metadata */
    private static final Set<String> unprocessedClicks = Collections.synchronizedSet(new HashSet());

    private e() {
    }

    private final String a(MotionEvent event) {
        int action = event.getAction();
        int actionIndex = event.getActionIndex();
        return event.getDownTime() + CacheKeyValueDelegate.CACHE_VALUE_SEPARATOR + event.getEventTime() + CacheKeyValueDelegate.CACHE_VALUE_SEPARATOR + action + CacheKeyValueDelegate.CACHE_VALUE_SEPARATOR + (event.getPointerCount() > actionIndex ? event.getPointerId(actionIndex) : -1);
    }

    public final boolean b(MotionEvent event) {
        Intrinsics.checkNotNullParameter(event, "event");
        return unprocessedClicks.contains(a(event));
    }

    public final void c(MotionEvent event) {
        Intrinsics.checkNotNullParameter(event, "event");
        String strA = a(event);
        unprocessedClicks.remove(strA);
        PendoLogger.d("ConsumedMotionEventsTracker", "Removed processed click: " + strA);
    }

    public final String d(MotionEvent event) {
        Intrinsics.checkNotNullParameter(event, "event");
        String strA = a(event);
        unprocessedClicks.add(strA);
        PendoLogger.d("ConsumedMotionEventsTracker", "Added unprocessed click: " + strA);
        return strA;
    }
}
