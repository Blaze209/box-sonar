package sdk.pendo.io.a4;

import androidx.camera.view.PreviewView$1$$ExternalSyntheticBackportWithForwarding0;
import com.microsoft.identity.common.java.telemetry.TelemetryEventStrings;
import java.util.ArrayList;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes4.dex */
public final class l {
    public static final boolean a;
    public static final int b;
    static final AtomicReference<ScheduledExecutorService> c = new AtomicReference<>();
    static final Map<ScheduledThreadPoolExecutor, Object> d = new ConcurrentHashMap();

    static final class a implements Runnable {
        a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            for (ScheduledThreadPoolExecutor scheduledThreadPoolExecutor : new ArrayList(l.d.keySet())) {
                if (scheduledThreadPoolExecutor.isShutdown()) {
                    l.d.remove(scheduledThreadPoolExecutor);
                } else {
                    scheduledThreadPoolExecutor.purge();
                }
            }
        }
    }

    static final class b implements sdk.pendo.io.q3.h<String, String> {
        b() {
        }

        @Override // sdk.pendo.io.q3.h
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public String apply(String str) {
            return System.getProperty(str);
        }
    }

    static {
        b bVar = new b();
        boolean zA = a(true, "rx2.purge-enabled", true, true, (sdk.pendo.io.q3.h<String, String>) bVar);
        a = zA;
        b = a(zA, "rx2.purge-period-seconds", 1, 1, bVar);
        a();
    }

    public static ScheduledExecutorService a(ThreadFactory threadFactory) {
        ScheduledExecutorService scheduledExecutorServiceNewScheduledThreadPool = Executors.newScheduledThreadPool(1, threadFactory);
        a(a, scheduledExecutorServiceNewScheduledThreadPool);
        return scheduledExecutorServiceNewScheduledThreadPool;
    }

    static boolean a(boolean z, String str, boolean z2, boolean z3, sdk.pendo.io.q3.h<String, String> hVar) {
        if (!z) {
            return z3;
        }
        try {
            String strApply = hVar.apply(str);
            if (strApply != null) {
                return TelemetryEventStrings.Value.TRUE.equals(strApply);
            }
        } catch (Throwable unused) {
        }
        return z2;
    }

    static int a(boolean z, String str, int i, int i2, sdk.pendo.io.q3.h<String, String> hVar) {
        if (!z) {
            return i2;
        }
        try {
            String strApply = hVar.apply(str);
            if (strApply != null) {
                return Integer.parseInt(strApply);
            }
        } catch (Throwable unused) {
        }
        return i;
    }

    public static void a() {
        a(a);
    }

    static void a(boolean z, ScheduledExecutorService scheduledExecutorService) {
        if (z && (scheduledExecutorService instanceof ScheduledThreadPoolExecutor)) {
            d.put((ScheduledThreadPoolExecutor) scheduledExecutorService, scheduledExecutorService);
        }
    }

    static void a(boolean z) {
        if (!z) {
            return;
        }
        while (true) {
            AtomicReference<ScheduledExecutorService> atomicReference = c;
            ScheduledExecutorService scheduledExecutorService = atomicReference.get();
            if (scheduledExecutorService != null) {
                return;
            }
            ScheduledExecutorService scheduledExecutorServiceNewScheduledThreadPool = Executors.newScheduledThreadPool(1, new h("RxSchedulerPurge"));
            if (PreviewView$1$$ExternalSyntheticBackportWithForwarding0.m(atomicReference, scheduledExecutorService, scheduledExecutorServiceNewScheduledThreadPool)) {
                a aVar = new a();
                long j = b;
                scheduledExecutorServiceNewScheduledThreadPool.scheduleAtFixedRate(aVar, j, j, TimeUnit.SECONDS);
                return;
            }
            scheduledExecutorServiceNewScheduledThreadPool.shutdownNow();
        }
    }
}
