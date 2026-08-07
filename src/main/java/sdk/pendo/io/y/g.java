package sdk.pendo.io.y;

import android.os.SystemClock;

/* JADX INFO: loaded from: classes6.dex */
public final class g {
    private static final double a = 1.0d / Math.pow(10.0d, 6.0d);

    public static double a(long j) {
        return (a() - j) * a;
    }

    public static long a() {
        return SystemClock.elapsedRealtimeNanos();
    }
}
