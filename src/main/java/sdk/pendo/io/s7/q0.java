package sdk.pendo.io.s7;

import androidx.media3.exoplayer.upstream.CmcdData;
import com.pspdfkit.analytics.Analytics;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import sdk.pendo.io.logging.PendoLogger;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\t\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0013\u0010\u0014J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0018\u0010\u0005\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J\u0010\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0012\u0010\u0005\u001a\u00020\f2\b\u0010\u000b\u001a\u0004\u0018\u00010\nH\u0007R\u0014\u0010\u000e\u001a\u00020\b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\t\u0010\rR\u0014\u0010\u0010\u001a\u00020\b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000f\u0010\rR\u0014\u0010\u0012\u001a\u00020\b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0011\u0010\r¨\u0006\u0015"}, d2 = {"Lsdk/pendo/io/s7/q0;", "", "", "threadName", "Ljava/util/concurrent/ThreadFactory;", CmcdData.OBJECT_TYPE_AUDIO_ONLY, "", "queueCapacity", "Ljava/util/concurrent/ThreadPoolExecutor;", "b", "Lsdk/pendo/io/i6/a;", Analytics.Data.ACTION, "", "Ljava/util/concurrent/ThreadPoolExecutor;", "sGeneralThreadPool", "c", "sAnalyticsThreadPool", "d", "sLoggerThreadPool", "<init>", "()V", "pendoIO_release"}, k = 1, mv = {1, 9, 0})
public final class q0 {
    public static final q0 a;

    /* JADX INFO: renamed from: b, reason: from kotlin metadata */
    private static final ThreadPoolExecutor sGeneralThreadPool;

    /* JADX INFO: renamed from: c, reason: from kotlin metadata */
    private static final ThreadPoolExecutor sAnalyticsThreadPool;

    /* JADX INFO: renamed from: d, reason: from kotlin metadata */
    private static final ThreadPoolExecutor sLoggerThreadPool;

    static {
        q0 q0Var = new q0();
        a = q0Var;
        sGeneralThreadPool = q0Var.b("pendo-general");
        sAnalyticsThreadPool = q0Var.b("pendo-analytics");
        sLoggerThreadPool = q0Var.a("pendo-logger", 120);
    }

    private q0() {
    }

    private final ThreadPoolExecutor a(final String threadName, int queueCapacity) {
        final AtomicBoolean atomicBoolean = new AtomicBoolean(false);
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(1, 1, 30L, TimeUnit.SECONDS, new ArrayBlockingQueue(queueCapacity), a(threadName), new RejectedExecutionHandler() { // from class: sdk.pendo.io.s7.q0$$ExternalSyntheticLambda1
            @Override // java.util.concurrent.RejectedExecutionHandler
            public final void rejectedExecution(Runnable runnable, ThreadPoolExecutor threadPoolExecutor2) {
                q0.a(atomicBoolean, threadName, runnable, threadPoolExecutor2);
            }
        });
        threadPoolExecutor.allowCoreThreadTimeOut(true);
        return threadPoolExecutor;
    }

    private final ThreadPoolExecutor b(String threadName) {
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(1, 1, 30L, TimeUnit.SECONDS, new LinkedBlockingQueue(), a(threadName));
        threadPoolExecutor.allowCoreThreadTimeOut(true);
        return threadPoolExecutor;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(AtomicBoolean loggedOnce, String threadName, Runnable runnable, ThreadPoolExecutor threadPoolExecutor) {
        Intrinsics.checkNotNullParameter(loggedOnce, "$loggedOnce");
        Intrinsics.checkNotNullParameter(threadName, "$threadName");
        if (threadPoolExecutor != null) {
            try {
                BlockingQueue<Runnable> queue = threadPoolExecutor.getQueue();
                if (queue != null) {
                    queue.clear();
                }
            } catch (Throwable unused) {
                return;
            }
        }
        if (loggedOnce.compareAndSet(false, true)) {
            PendoLogger.e("ReactiveUtils", threadName + " rejection handler dropping queue.", (Throwable) null);
        }
        threadPoolExecutor.execute(runnable);
    }

    private final ThreadFactory a(final String threadName) {
        return new ThreadFactory() { // from class: sdk.pendo.io.s7.q0$$ExternalSyntheticLambda0
            @Override // java.util.concurrent.ThreadFactory
            public final Thread newThread(Runnable runnable) {
                return q0.a(threadName, runnable);
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Thread a(String threadName, Runnable runnable) {
        Intrinsics.checkNotNullParameter(threadName, "$threadName");
        Thread thread = new Thread(runnable, threadName);
        thread.setPriority(4);
        return thread;
    }

    @JvmStatic
    public static final void a(sdk.pendo.io.i6.a action) {
        ThreadPoolExecutor threadPoolExecutor;
        if (action == null) {
            return;
        }
        if (action instanceof PendoLogger.c) {
            threadPoolExecutor = sLoggerThreadPool;
        } else {
            threadPoolExecutor = action instanceof sdk.pendo.io.f6.a.e ? true : action instanceof sdk.pendo.io.f6.a.f ? sAnalyticsThreadPool : sGeneralThreadPool;
        }
        threadPoolExecutor.execute(action);
    }
}
