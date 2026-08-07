package com.pspdfkit.internal;

import android.app.ActivityManager;
import android.content.Context;
import android.os.Debug;
import androidx.core.content.ContextCompat;
import com.pspdfkit.internal.jni.NativeMemoryNotificationLevel;
import com.pspdfkit.internal.jni.NativeNativeServices;
import com.pspdfkit.utils.PdfLog;
import cz.msebera.android.httpclient.impl.client.cache.CacheValidityPolicy;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.WeakHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.DelayKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;

/* JADX INFO: loaded from: classes3.dex */
public final class tq {
    public static Job a = null;
    public static long b = 0;
    public static ActivityManager c = null;
    public static String d = null;
    public static int e = -1;
    public static String f;
    public static long g;
    public static final ExecutorService h = Executors.newSingleThreadExecutor(new ThreadFactory() { // from class: com.pspdfkit.internal.tq$$ExternalSyntheticLambda0
        @Override // java.util.concurrent.ThreadFactory
        public final Thread newThread(Runnable runnable) {
            return tq.a(runnable);
        }
    });
    public static final AtomicBoolean i = new AtomicBoolean(false);
    public static final Set<ou> j;

    @DebugMetadata(c = "com.pspdfkit.internal.core.MemoryNotificationHandler$startMemoryObservation$1", f = "MemoryNotificationHandler.kt", i = {}, l = {128}, m = "invokeSuspend", n = {}, nl = {-1}, s = {}, v = 2)
    public static final class a extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        public int a;

        public a(Continuation<? super a> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new a(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return new a(continuation).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.a;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                long j = 1024;
                PdfLog.d("PSPDF.MemoryNotHandler", "Memory observation started. Budget: " + (tq.b / (j * j)) + "MB", new Object[0]);
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
            do {
                tq.a();
                this.a = 1;
            } while (DelayKt.delay(1000L, this) != coroutine_suspended);
            return coroutine_suspended;
        }
    }

    static {
        Set<ou> setNewSetFromMap = Collections.newSetFromMap(Collections.synchronizedMap(new WeakHashMap()));
        setNewSetFromMap.getClass();
        j = setNewSetFromMap;
    }

    public static final Thread a(Runnable runnable) {
        Thread thread = new Thread(runnable, "pspdfkit-mem-notify");
        thread.setDaemon(true);
        return thread;
    }

    @JvmStatic
    public static final void b() {
        Job job = a;
        if (job == null || !job.isActive()) {
            Context context = n5.a;
            if (context == null) {
                throw new IllegalStateException("The application context should not be null. Please call fun setApplicationContext(context: Context) first");
            }
            if (c == null) {
                c = (ActivityManager) ContextCompat.getSystemService(context, ActivityManager.class);
            }
            if (b == 0) {
                long j2 = 1024;
                long jCoerceAtLeast = j2 * j2 * j2;
                ActivityManager activityManager = c;
                if (activityManager != null) {
                    ActivityManager.MemoryInfo memoryInfo = new ActivityManager.MemoryInfo();
                    activityManager.getMemoryInfo(memoryInfo);
                    jCoerceAtLeast = RangesKt.coerceAtLeast((long) (memoryInfo.totalMem * (activityManager.isLowRamDevice() ? 0.2f : 0.4f)), 256 * j2 * j2);
                }
                b = jCoerceAtLeast;
            }
            d = null;
            e = -1;
            f = null;
            g = 0L;
            a = BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getDefault()), null, null, new a(null), 3, null);
        }
    }

    public static void a() {
        Pair pair;
        long nativeHeapAllocatedSize = Debug.getNativeHeapAllocatedSize();
        float f2 = nativeHeapAllocatedSize / b;
        if (nativeHeapAllocatedSize >= CacheValidityPolicy.MAX_AGE) {
            pair = TuplesKt.to("HARD_CEILING_CRITICAL", NativeMemoryNotificationLevel.CRITICAL);
        } else if (f2 >= 0.9f) {
            pair = TuplesKt.to("CRITICAL", NativeMemoryNotificationLevel.CRITICAL);
        } else if (nativeHeapAllocatedSize >= 1572864000) {
            pair = TuplesKt.to("HARD_CEILING_WARNING", NativeMemoryNotificationLevel.WARNING);
        } else if (f2 < 0.8f) {
            return;
        } else {
            pair = TuplesKt.to("WARNING", NativeMemoryNotificationLevel.WARNING);
        }
        String str = (String) pair.component1();
        NativeMemoryNotificationLevel nativeMemoryNotificationLevel = (NativeMemoryNotificationLevel) pair.component2();
        int i2 = (int) (f2 * 100);
        String str2 = nativeMemoryNotificationLevel == NativeMemoryNotificationLevel.CRITICAL ? "critical" : "elevated";
        long jCurrentTimeMillis = System.currentTimeMillis();
        if (!Intrinsics.areEqual(str2, f) || jCurrentTimeMillis - g >= 10000) {
            f = str2;
            g = jCurrentTimeMillis;
            PdfLog.w("PSPDF.MemoryNotHandler", "Detected " + str2 + " memory pressure — applying safeguards to reduce memory consumption and prevent crashes.", new Object[0]);
        }
        if (!Intrinsics.areEqual(str, d) || i2 != e) {
            d = str;
            e = i2;
            Context context = n5.a;
            if (context == null) {
                throw new IllegalStateException("The application context should not be null. Please call fun setApplicationContext(context: Context) first");
            }
            ActivityManager.MemoryInfo memoryInfo = new ActivityManager.MemoryInfo();
            Object systemService = context.getSystemService("activity");
            systemService.getClass();
            ((ActivityManager) systemService).getMemoryInfo(memoryInfo);
            String str3 = "[" + sq.a(memoryInfo) + "]";
            long j2 = 1024;
            long j3 = j2 * j2;
            PdfLog.d("PSPDF.MemoryNotHandler", "Memory details — trigger: " + str + ", native heap: " + (nativeHeapAllocatedSize / j3) + "MB / " + (b / j3) + "MB budget (" + i2 + "%). " + str3, new Object[0]);
        }
        a(nativeMemoryNotificationLevel);
    }

    public static void a(final NativeMemoryNotificationLevel nativeMemoryNotificationLevel) {
        List<ou> list;
        if (nativeMemoryNotificationLevel == NativeMemoryNotificationLevel.CRITICAL) {
            Set<ou> set = j;
            synchronized (set) {
                list = CollectionsKt.toList(set);
            }
            for (ou ouVar : list) {
                ouVar.d.lock();
                try {
                    ouVar.g.clear();
                    ouVar.d.unlock();
                } catch (Throwable th) {
                    ouVar.d.unlock();
                    throw th;
                }
            }
        }
        if (i.compareAndSet(false, true)) {
            h.execute(new Runnable() { // from class: com.pspdfkit.internal.tq$$ExternalSyntheticLambda1
                @Override // java.lang.Runnable
                public final void run() {
                    tq.b(nativeMemoryNotificationLevel);
                }
            });
        }
    }

    public static final void b(NativeMemoryNotificationLevel nativeMemoryNotificationLevel) {
        try {
            NativeNativeServices.memoryNotification(nativeMemoryNotificationLevel);
        } finally {
            i.set(false);
        }
    }
}
