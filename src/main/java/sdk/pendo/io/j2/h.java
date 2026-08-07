package sdk.pendo.io.j2;

import androidx.media3.exoplayer.upstream.CmcdData;
import java.util.LinkedHashSet;
import java.util.Set;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import sdk.pendo.io.e2.f0;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010#\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\r\u0010\u000eJ\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0002J\u000e\u0010\t\u001a\u00020\b2\u0006\u0010\u0006\u001a\u00020\u0002R\u001a\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00020\n8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0007\u0010\u000b¨\u0006\u000f"}, d2 = {"Lsdk/pendo/io/j2/h;", "", "Lsdk/pendo/io/e2/f0;", "failedRoute", "", "b", "route", CmcdData.OBJECT_TYPE_AUDIO_ONLY, "", "c", "", "Ljava/util/Set;", "failedRoutes", "<init>", "()V", "okhttp"}, k = 1, mv = {1, 8, 0})
public final class h {

    /* JADX INFO: renamed from: a, reason: from kotlin metadata */
    private final Set<f0> failedRoutes = new LinkedHashSet();

    public final synchronized void a(f0 route) {
        Intrinsics.checkNotNullParameter(route, "route");
        this.failedRoutes.remove(route);
    }

    public final synchronized void b(f0 failedRoute) {
        Intrinsics.checkNotNullParameter(failedRoute, "failedRoute");
        this.failedRoutes.add(failedRoute);
    }

    public final synchronized boolean c(f0 route) {
        Intrinsics.checkNotNullParameter(route, "route");
        return this.failedRoutes.contains(route);
    }
}
