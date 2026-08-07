package com.pspdfkit.internal;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.ColorMatrix;
import android.graphics.ColorMatrixColorFilter;
import android.graphics.Paint;
import android.graphics.Point;
import android.os.Process;
import com.pspdfkit.annotations.AnnotationType;
import com.pspdfkit.internal.jni.NativeDocumentEditor;
import com.pspdfkit.internal.jni.NativePageRenderingConfig;
import com.pspdfkit.internal.jni.NativeRenderResult;
import com.pspdfkit.internal.jni.NativeRenderResultError;
import com.pspdfkit.internal.rendering.PageRenderingException;
import com.pspdfkit.ui.drawable.PdfDrawable;
import com.pspdfkit.utils.PdfLog;
import java.util.EnumSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.Lazy;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CompletableDeferred;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.ExecutorCoroutineDispatcher;
import kotlinx.coroutines.ExecutorsKt;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.SupervisorKt;

/* JADX INFO: loaded from: classes3.dex */
public final class ju {
    public static final ConcurrentHashMap<String, a> a;
    public static final Map<Integer, CoroutineDispatcher> b;
    public static final CoroutineScope c;

    public static final class a {
        public final String a;
        public final int b;
        public final long c;
        public final CompletableDeferred<Bitmap> d;
        public final int e;

        public a(String str, int i, long j, CompletableDeferred<Bitmap> completableDeferred, int i2) {
            str.getClass();
            completableDeferred.getClass();
            this.a = str;
            this.b = i;
            this.c = j;
            this.d = completableDeferred;
            this.e = i2;
        }

        public final boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof a)) {
                return false;
            }
            a aVar = (a) obj;
            return Intrinsics.areEqual(this.a, aVar.a) && this.b == aVar.b && this.c == aVar.c && Intrinsics.areEqual(this.d, aVar.d) && this.e == aVar.e;
        }

        public final int hashCode() {
            return Integer.hashCode(this.e) + ((this.d.hashCode() + ((Long.hashCode(this.c) + nd.a(this.b, this.a.hashCode() * 31, 31)) * 31)) * 31);
        }

        public final String toString() {
            return "RenderTask(id=" + this.a + ", priority=" + this.b + ", timestamp=" + this.c + ", deferred=" + this.d + ", cancellationToken=" + this.e + ")";
        }
    }

    static {
        EnumSet.of(AnnotationType.FILE).getClass();
        new AtomicInteger(0);
        a = new ConcurrentHashMap<>();
        b = MapsKt.mapOf(TuplesKt.to(15, a(15, 2)), TuplesKt.to(10, a(10, 2)), TuplesKt.to(5, a(5, 1)), TuplesKt.to(3, a(3, 1)), TuplesKt.to(1, a(1, 1)));
        c = CoroutineScopeKt.CoroutineScope(SupervisorKt.SupervisorJob$default((Job) null, 1, (Object) null).plus(Dispatchers.getDefault()));
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0017  */
    /* JADX WARN: Not initialized variable reg: 8, insn: 0x012f: INVOKE (r8 I:com.pspdfkit.internal.zo) VIRTUAL call: com.pspdfkit.internal.zo.b():void A[MD:():void (m)] (LINE:423), block:B:55:0x012f */
    public static final Object a(jm jmVar, String str, int i, mu muVar, ContinuationImpl continuationImpl) throws Exception {
        lu luVar;
        zo zoVarB;
        zo zoVar;
        long jCurrentTimeMillis;
        String str2;
        jm jmVar2;
        long j;
        if (continuationImpl instanceof lu) {
            luVar = (lu) continuationImpl;
            int i2 = luVar.h;
            if ((i2 & Integer.MIN_VALUE) != 0) {
                luVar.h = i2 - Integer.MIN_VALUE;
            } else {
                luVar = new lu(continuationImpl);
            }
        } else {
            luVar = new lu(continuationImpl);
        }
        Object objInvoke = luVar.g;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i3 = luVar.h;
        boolean z = true;
        try {
            if (i3 == 0) {
                ResultKt.throwOnFailure(objInvoke);
                long jCurrentTimeMillis2 = System.currentTimeMillis();
                zoVar = new zo(jmVar.c, jmVar.d);
                CoroutineScopeKt.ensureActive(c);
                jCurrentTimeMillis = System.currentTimeMillis() - jCurrentTimeMillis2;
                long jCurrentTimeMillis3 = System.currentTimeMillis();
                Bitmap bitmapA = zoVar.a();
                bitmapA.getClass();
                NativePageRenderingConfig nativePageRenderingConfigA = r10.a(jmVar);
                luVar.a = jmVar;
                str2 = str;
                luVar.b = str2;
                luVar.c = SpillingKt.nullOutSpilledVariable(muVar);
                luVar.d = zoVar;
                luVar.e = jCurrentTimeMillis;
                luVar.f = jCurrentTimeMillis3;
                luVar.h = 1;
                objInvoke = muVar.invoke(bitmapA, nativePageRenderingConfigA, luVar);
                if (objInvoke == coroutine_suspended) {
                    return coroutine_suspended;
                }
                jmVar2 = jmVar;
                j = jCurrentTimeMillis3;
            } else {
                if (i3 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                long j2 = luVar.f;
                jCurrentTimeMillis = luVar.e;
                zoVar = luVar.d;
                String str3 = luVar.b;
                jm jmVar3 = luVar.a;
                ResultKt.throwOnFailure(objInvoke);
                str2 = str3;
                jmVar2 = jmVar3;
                j = j2;
            }
            long j3 = jCurrentTimeMillis;
            NativeRenderResult nativeRenderResult = (NativeRenderResult) objInvoke;
            if (nativeRenderResult != null && nativeRenderResult.getError() == null) {
                CoroutineScope coroutineScope = c;
                CoroutineScopeKt.ensureActive(coroutineScope);
                if (jmVar2.n) {
                    Lazy lazy = um.a;
                    Bitmap bitmapA2 = zoVar.a();
                    bitmapA2.getClass();
                    ColorMatrix colorMatrix = (ColorMatrix) um.a.getValue();
                    Paint paint = new Paint();
                    paint.setColorFilter(new ColorMatrixColorFilter(colorMatrix));
                    new Canvas(bitmapA2).drawBitmap(bitmapA2, 0.0f, 0.0f, paint);
                }
                Bitmap bitmapA3 = zoVar.a();
                if (Color.alpha(jmVar2.i) >= 255) {
                    z = false;
                }
                bitmapA3.setHasAlpha(z);
                if (jmVar2.g != null) {
                    Bitmap bitmapA4 = zoVar.a();
                    bitmapA4.getClass();
                    a(bitmapA4, jmVar2, jmVar2.g);
                } else {
                    Bitmap bitmapA5 = zoVar.a();
                    bitmapA5.getClass();
                    a(bitmapA5, jmVar2);
                }
                CoroutineScopeKt.ensureActive(coroutineScope);
                a(str2, jmVar2, j3, j);
                Bitmap bitmapA6 = zoVar.a();
                bitmapA6.getClass();
                return bitmapA6;
            }
            zoVar.b();
            if ((nativeRenderResult != null ? nativeRenderResult.getError() : null) != NativeRenderResultError.CANCELED) {
                throw new PageRenderingException(jmVar2.b, nativeRenderResult != null ? nativeRenderResult.getError() : null);
            }
            throw new CancellationException();
        } catch (Exception e) {
            zoVarB.b();
            throw e;
        }
    }

    public static void a(Bitmap bitmap, jm jmVar) {
        float width;
        NativeDocumentEditor nativeDocumentEditor = jmVar.f;
        if (nativeDocumentEditor != null) {
            width = bitmap.getWidth() / nativeDocumentEditor.getRotatedPageSize(jmVar.b).width;
        } else {
            float width2 = bitmap.getWidth();
            ou ouVar = jmVar.a;
            int i = jmVar.b;
            ouVar.a(i);
            width = width2 / ouVar.f.getPageSize(i).width;
        }
        List<PdfDrawable> list = jmVar.r;
        int width3 = bitmap.getWidth();
        int height = bitmap.getHeight();
        if (list.isEmpty()) {
            return;
        }
        Canvas canvas = new Canvas(bitmap);
        Iterator<T> it = list.iterator();
        while (it.hasNext()) {
            yv yvVar = new yv((PdfDrawable) it.next(), width);
            yvVar.setBounds(0, 0, width3, height);
            yvVar.a.draw(canvas);
        }
    }

    public static void a(String str, jm jmVar, long j, long j2) {
        Point point;
        oy oyVar = jmVar.g;
        if (oyVar == null || (point = oyVar.a) == null) {
            point = new Point(0, 0);
        }
        PdfLog.d("Nutri.PageRendererCoroutines", str + " report: [pageIndex = " + jmVar.b + ", region = " + point.x + ", " + point.y + ", " + jmVar.d.getWidth() + "x" + jmVar.d.getHeight() + ", queue_waiting_time = " + j + " ms, total_rendering_time = " + (System.currentTimeMillis() - j2) + "ms, priority = " + jmVar.h + ", active_tasks = " + a.size() + "]", new Object[0]);
    }

    public static Object a(jm jmVar, int i, pj.b bVar) {
        oy oyVar = jmVar.g;
        if (oyVar != null) {
            return CoroutineScopeKt.coroutineScope(new nu(jmVar, i, new mu(jmVar, oyVar, i, null), null), bVar);
        }
        throw new IllegalArgumentException("No region options passed for region rendering.");
    }

    public static ExecutorCoroutineDispatcher a(final int i, int i2) {
        ExecutorService executorServiceNewFixedThreadPool = Executors.newFixedThreadPool(i2, new ThreadFactory() { // from class: com.pspdfkit.internal.ju$$ExternalSyntheticLambda0
            @Override // java.util.concurrent.ThreadFactory
            public final Thread newThread(Runnable runnable) {
                return ju.a(i, runnable);
            }
        });
        executorServiceNewFixedThreadPool.getClass();
        return ExecutorsKt.from(executorServiceNewFixedThreadPool);
    }

    public static final Thread a(int i, Runnable runnable) {
        Thread thread = new Thread(runnable, "PageRenderer-Priority-" + i);
        thread.setDaemon(true);
        Process.setThreadPriority(10);
        return thread;
    }

    public static void a(Bitmap bitmap, jm jmVar, oy oyVar) {
        Point point = oyVar.a;
        int i = point.x;
        int i2 = -point.y;
        List<PdfDrawable> list = jmVar.r;
        float width = oyVar.b.getWidth();
        ou ouVar = jmVar.a;
        int i3 = jmVar.b;
        ouVar.a(i3);
        float f = width / ouVar.f.getPageSize(i3).width;
        int width2 = oyVar.b.getWidth() + i;
        int height = oyVar.b.getHeight() + i2;
        if (list.isEmpty()) {
            return;
        }
        Canvas canvas = new Canvas(bitmap);
        Iterator<T> it = list.iterator();
        while (it.hasNext()) {
            yv yvVar = new yv((PdfDrawable) it.next(), f);
            yvVar.setBounds(i, i2, width2, height);
            yvVar.a.draw(canvas);
        }
    }
}
