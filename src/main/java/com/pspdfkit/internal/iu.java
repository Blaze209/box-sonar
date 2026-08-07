package com.pspdfkit.internal;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.ColorMatrix;
import android.graphics.ColorMatrixColorFilter;
import android.graphics.Paint;
import android.graphics.Point;
import com.pspdfkit.annotations.AnnotationType;
import com.pspdfkit.internal.bx.a;
import com.pspdfkit.internal.jni.NativeDocumentEditor;
import com.pspdfkit.internal.jni.NativePage;
import com.pspdfkit.internal.jni.NativePageCache;
import com.pspdfkit.internal.jni.NativePageRenderingConfig;
import com.pspdfkit.internal.jni.NativeRenderResult;
import com.pspdfkit.internal.rendering.PageRenderingException;
import com.pspdfkit.ui.drawable.PdfDrawable;
import com.pspdfkit.utils.PdfLog;
import io.reactivex.rxjava3.core.Completable;
import io.reactivex.rxjava3.core.Maybe;
import io.reactivex.rxjava3.core.MaybeEmitter;
import io.reactivex.rxjava3.core.MaybeOnSubscribe;
import io.reactivex.rxjava3.core.Single;
import io.reactivex.rxjava3.core.SingleEmitter;
import io.reactivex.rxjava3.core.SingleOnSubscribe;
import io.reactivex.rxjava3.functions.Action;
import io.reactivex.rxjava3.schedulers.Schedulers;
import java.util.EnumSet;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import kotlin.Unit;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;

/* JADX INFO: loaded from: classes3.dex */
public final class iu {
    public static final iu a = new iu();
    public static final EnumSet<AnnotationType> b;
    public static int c;

    static {
        EnumSet<AnnotationType> enumSetOf = EnumSet.of(AnnotationType.FILE);
        enumSetOf.getClass();
        b = enumSetOf;
    }

    public static void a(String str, jm jmVar, int i) {
        if (jmVar.a.b.cancelRenderProcess(jmVar.b, i)) {
            PdfLog.d("Nutri.PageRenderer", str + " report: [cancelled]", new Object[0]);
        }
    }

    @JvmStatic
    public static final Single<Bitmap> b(jm jmVar) {
        jmVar.getClass();
        ut utVar = q10.b;
        if (utVar == null) {
            utVar = new ut(NativePageCache.create(15728640));
            q10.b = utVar;
        }
        if (!jmVar.e) {
            return a.b(jmVar, utVar);
        }
        Single<Bitmap> singleSwitchIfEmpty = a(jmVar, utVar).switchIfEmpty(a.b(jmVar, utVar));
        singleSwitchIfEmpty.getClass();
        return singleSwitchIfEmpty;
    }

    @JvmStatic
    public static final Single<Bitmap> c(final jm jmVar) {
        final int i;
        final oy oyVar = jmVar.g;
        if (oyVar == null) {
            throw new IllegalArgumentException("No region options passed for region rendering.");
        }
        final String str = "renderPageRegion()";
        synchronized (a) {
            i = c;
            c = i + 1;
        }
        return a(jmVar, new Function2() { // from class: com.pspdfkit.internal.iu$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(Object obj, Object obj2) {
                return iu.a(jmVar, oyVar, i, (Bitmap) obj, (NativePageRenderingConfig) obj2);
            }
        }, new Function0() { // from class: com.pspdfkit.internal.iu$$ExternalSyntheticLambda1
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return iu.d(str, jmVar, i);
            }
        }, "renderPageRegion()");
    }

    public static final Unit d(final String str, final jm jmVar, final int i) {
        Completable.fromAction(new Action() { // from class: com.pspdfkit.internal.iu$$ExternalSyntheticLambda7
            @Override // io.reactivex.rxjava3.functions.Action
            public final void run() {
                iu.e(str, jmVar, i);
            }
        }).subscribeOn(Schedulers.computation()).subscribe();
        return Unit.INSTANCE;
    }

    public static final void e(String str, jm jmVar, int i) {
        a(str, jmVar, i);
    }

    public static final NativeRenderResult a(jm jmVar, oy oyVar, int i, Bitmap bitmap, NativePageRenderingConfig nativePageRenderingConfig) {
        bitmap.getClass();
        nativePageRenderingConfig.getClass();
        ou ouVar = jmVar.a;
        int i2 = jmVar.b;
        Point point = oyVar.a;
        return ouVar.a(i2, bitmap, point.x, point.y, oyVar.b.getWidth(), oyVar.b.getHeight(), nativePageRenderingConfig, i);
    }

    public static final NativeRenderResult a(NativeDocumentEditor nativeDocumentEditor, jm jmVar, Bitmap bitmap, NativePageRenderingConfig nativePageRenderingConfig) {
        bitmap.getClass();
        nativePageRenderingConfig.getClass();
        nativeDocumentEditor.render(jmVar.b, bitmap, nativePageRenderingConfig);
        return new NativeRenderResult(true, null, null, null);
    }

    public final Single<Bitmap> b(final jm jmVar, final ut utVar) {
        final int i;
        final String str = "renderFullPage()";
        synchronized (this) {
            i = c;
            c = i + 1;
        }
        return a(jmVar, new Function2() { // from class: com.pspdfkit.internal.iu$$ExternalSyntheticLambda2
            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(Object obj, Object obj2) {
                return iu.a(jmVar, utVar, i, (Bitmap) obj, (NativePageRenderingConfig) obj2);
            }
        }, new Function0() { // from class: com.pspdfkit.internal.iu$$ExternalSyntheticLambda3
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return iu.b(str, jmVar, i);
            }
        }, "renderFullPage()");
    }

    public static final void a(jm jmVar, long j, ut utVar, MaybeEmitter maybeEmitter) {
        float width;
        float f;
        maybeEmitter.getClass();
        if (jmVar.d.getWidth() > 0 && jmVar.d.getHeight() > 0) {
            long jCurrentTimeMillis = System.currentTimeMillis() - j;
            zo zoVar = new zo(jmVar.c, jmVar.d);
            Bitmap bitmapA = zoVar.a();
            bitmapA.getClass();
            synchronized (bitmapA) {
                Bitmap bitmapA2 = zoVar.a();
                bitmapA2.getClass();
                if (maybeEmitter.isDisposed()) {
                    zoVar.b();
                    return;
                }
                long jCurrentTimeMillis2 = System.currentTimeMillis();
                if (!utVar.a.get(bitmapA2, String.format(Locale.getDefault(), "d[%s]p[%d]_", jmVar.a.a, Integer.valueOf(jmVar.b)), r10.a(jmVar))) {
                    zoVar.b();
                    maybeEmitter.onComplete();
                    return;
                }
                bitmapA2.setHasAlpha(Color.alpha(jmVar.i) < 255);
                NativeDocumentEditor nativeDocumentEditor = jmVar.f;
                if (nativeDocumentEditor != null) {
                    width = bitmapA2.getWidth();
                    f = nativeDocumentEditor.getRotatedPageSize(jmVar.b).width;
                } else {
                    width = bitmapA2.getWidth();
                    ou ouVar = jmVar.a;
                    int i = jmVar.b;
                    ouVar.a(i);
                    f = ouVar.f.getPageSize(i).width;
                }
                float f2 = width / f;
                List<PdfDrawable> list = jmVar.r;
                int width2 = bitmapA2.getWidth();
                int height = bitmapA2.getHeight();
                if (!list.isEmpty()) {
                    Canvas canvas = new Canvas(bitmapA2);
                    Iterator<T> it = list.iterator();
                    while (it.hasNext()) {
                        yv yvVar = new yv((PdfDrawable) it.next(), f2);
                        yvVar.setBounds(0, 0, width2, height);
                        yvVar.a.draw(canvas);
                    }
                }
                if (maybeEmitter.isDisposed()) {
                    zoVar.b();
                    return;
                }
                a("getFullPageRenderingFromCache()", jmVar, jCurrentTimeMillis, jCurrentTimeMillis2);
                Unit unit = Unit.INSTANCE;
                maybeEmitter.onSuccess(zoVar.a());
                return;
            }
        }
        maybeEmitter.onComplete();
    }

    public static final void c(String str, jm jmVar, int i) {
        a(str, jmVar, i);
    }

    public static final Unit b(final String str, final jm jmVar, final int i) {
        Completable.fromAction(new Action() { // from class: com.pspdfkit.internal.iu$$ExternalSyntheticLambda4
            @Override // io.reactivex.rxjava3.functions.Action
            public final void run() {
                iu.c(str, jmVar, i);
            }
        }).subscribeOn(Schedulers.computation()).subscribe();
        return Unit.INSTANCE;
    }

    public static final NativeRenderResult a(jm jmVar, ut utVar, int i, Bitmap bitmap, NativePageRenderingConfig nativePageRenderingConfig) {
        bitmap.getClass();
        nativePageRenderingConfig.getClass();
        boolean z = jmVar.e;
        ou ouVar = jmVar.a;
        int i2 = jmVar.b;
        if (z) {
            ouVar.getClass();
            utVar.getClass();
            ouVar.e.readLock().lock();
            try {
                vv vvVarB = ouVar.b(i2);
                String str = String.format(Locale.getDefault(), "d[%s]p[%d]_", ouVar.a, Integer.valueOf(i2));
                NativePage nativePage = vvVarB.c;
                return nativePage != null ? nativePage.renderPageWithCache(bitmap, utVar.a, str, nativePageRenderingConfig, Integer.valueOf(i)) : null;
            } finally {
                ouVar.e.readLock().unlock();
            }
        }
        ouVar.getClass();
        return ouVar.a(i2, bitmap, 0, 0, bitmap.getWidth(), bitmap.getHeight(), nativePageRenderingConfig, i);
    }

    @JvmStatic
    public static final Single<Bitmap> a(final jm jmVar) {
        final NativeDocumentEditor nativeDocumentEditor = jmVar.f;
        if (nativeDocumentEditor != null) {
            return a(jmVar, new Function2() { // from class: com.pspdfkit.internal.iu$$ExternalSyntheticLambda8
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return iu.a(nativeDocumentEditor, jmVar, (Bitmap) obj, (NativePageRenderingConfig) obj2);
                }
            }, (Function0) null, "renderDocumentEditorPage()");
        }
        throw new IllegalArgumentException("No document editor passed for document editor rendering.");
    }

    public static void a(String str, jm jmVar, long j, long j2) {
        Point point;
        oy oyVar = jmVar.g;
        if (oyVar == null || (point = oyVar.a) == null) {
            point = new Point(0, 0);
        }
        PdfLog.d("Nutri.PageRenderer", str + " report: [pageIndex = " + jmVar.b + ", region = " + point.x + ", " + point.y + ", " + jmVar.d.getWidth() + "x" + jmVar.d.getHeight() + ", queue_waiting_time = " + j + " ms, total_rendering_time = " + (System.currentTimeMillis() - j2) + "ms, priority = " + jmVar.h + "]", new Object[0]);
    }

    public static Maybe a(final jm jmVar, final ut utVar) {
        final long jCurrentTimeMillis = System.currentTimeMillis();
        Maybe maybeCreate = Maybe.create(new MaybeOnSubscribe() { // from class: com.pspdfkit.internal.iu$$ExternalSyntheticLambda9
            @Override // io.reactivex.rxjava3.core.MaybeOnSubscribe
            public final void subscribe(MaybeEmitter maybeEmitter) {
                iu.a(jmVar, jCurrentTimeMillis, utVar, maybeEmitter);
            }
        });
        g60 g60VarC = q10.c();
        int i = jmVar.h;
        bx bxVar = ((m0) g60VarC).a;
        bxVar.getClass();
        Maybe maybeSubscribeOn = maybeCreate.subscribeOn(bxVar.new a(i));
        maybeSubscribeOn.getClass();
        return maybeSubscribeOn;
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

    public static Single a(final jm jmVar, final Function2 function2, final Function0 function0, final String str) {
        final long jCurrentTimeMillis = System.currentTimeMillis();
        Single singleDoOnDispose = Single.create(new SingleOnSubscribe() { // from class: com.pspdfkit.internal.iu$$ExternalSyntheticLambda5
            @Override // io.reactivex.rxjava3.core.SingleOnSubscribe
            public final void subscribe(SingleEmitter singleEmitter) {
                iu.a(jCurrentTimeMillis, jmVar, function2, str, singleEmitter);
            }
        }).doOnDispose(new Action() { // from class: com.pspdfkit.internal.iu$$ExternalSyntheticLambda6
            @Override // io.reactivex.rxjava3.functions.Action
            public final void run() {
                iu.a(function0);
            }
        });
        g60 g60VarC = q10.c();
        int i = jmVar.h;
        bx bxVar = ((m0) g60VarC).a;
        bxVar.getClass();
        Single singleSubscribeOn = singleDoOnDispose.subscribeOn(bxVar.new a(i));
        singleSubscribeOn.getClass();
        return singleSubscribeOn;
    }

    public static final void a(long j, jm jmVar, Function2 function2, String str, SingleEmitter singleEmitter) {
        float width;
        float f;
        singleEmitter.getClass();
        long jCurrentTimeMillis = System.currentTimeMillis() - j;
        zo zoVar = new zo(jmVar.c, jmVar.d);
        Bitmap bitmapA = zoVar.a();
        bitmapA.getClass();
        synchronized (bitmapA) {
            Bitmap bitmapA2 = zoVar.a();
            bitmapA2.getClass();
            if (singleEmitter.isDisposed()) {
                zoVar.b();
                return;
            }
            long jCurrentTimeMillis2 = System.currentTimeMillis();
            NativeRenderResult nativeRenderResult = (NativeRenderResult) function2.invoke(bitmapA2, r10.a(jmVar));
            if (nativeRenderResult != null && nativeRenderResult.getError() == null) {
                if (jmVar.n) {
                    ColorMatrix colorMatrix = (ColorMatrix) um.a.getValue();
                    Paint paint = new Paint();
                    paint.setColorFilter(new ColorMatrixColorFilter(colorMatrix));
                    new Canvas(bitmapA2).drawBitmap(bitmapA2, 0.0f, 0.0f, paint);
                }
                bitmapA2.setHasAlpha(Color.alpha(jmVar.i) < 255);
                oy oyVar = jmVar.g;
                if (oyVar != null) {
                    a(bitmapA2, jmVar, oyVar);
                } else {
                    NativeDocumentEditor nativeDocumentEditor = jmVar.f;
                    if (nativeDocumentEditor != null) {
                        width = bitmapA2.getWidth();
                        f = nativeDocumentEditor.getRotatedPageSize(jmVar.b).width;
                    } else {
                        width = bitmapA2.getWidth();
                        ou ouVar = jmVar.a;
                        int i = jmVar.b;
                        ouVar.a(i);
                        f = ouVar.f.getPageSize(i).width;
                    }
                    float f2 = width / f;
                    List<PdfDrawable> list = jmVar.r;
                    int width2 = bitmapA2.getWidth();
                    int height = bitmapA2.getHeight();
                    if (!list.isEmpty()) {
                        Canvas canvas = new Canvas(bitmapA2);
                        Iterator<T> it = list.iterator();
                        while (it.hasNext()) {
                            yv yvVar = new yv((PdfDrawable) it.next(), f2);
                            yvVar.setBounds(0, 0, width2, height);
                            yvVar.a.draw(canvas);
                        }
                    }
                }
                if (singleEmitter.isDisposed()) {
                    zoVar.b();
                    return;
                }
                a(str, jmVar, jCurrentTimeMillis, jCurrentTimeMillis2);
                Unit unit = Unit.INSTANCE;
                singleEmitter.onSuccess(zoVar.a());
                return;
            }
            zoVar.b();
            singleEmitter.tryOnError(new PageRenderingException(jmVar.b, nativeRenderResult != null ? nativeRenderResult.getError() : null));
        }
    }

    public static final void a(Function0 function0) {
        if (function0 != null) {
            function0.invoke();
        }
    }
}
