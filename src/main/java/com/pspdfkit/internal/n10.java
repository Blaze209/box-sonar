package com.pspdfkit.internal;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import com.pspdfkit.internal.bx.a;
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers;
import io.reactivex.rxjava3.core.Completable;
import io.reactivex.rxjava3.core.CompletableEmitter;
import io.reactivex.rxjava3.core.CompletableOnSubscribe;
import io.reactivex.rxjava3.core.Single;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.functions.Action;
import io.reactivex.rxjava3.functions.Consumer;
import io.reactivex.rxjava3.internal.operators.single.SingleJust;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes3.dex */
public final class n10 implements nx {
    public final Paint a;
    public final Paint b;
    public final bx e;
    public Disposable j;
    public final Matrix d = new Matrix();
    public final Object f = new Object();
    public volatile boolean g = false;
    public Bitmap h = null;
    public Rect i = new Rect();
    public final Canvas c = new Canvas();

    public class a implements Callable<Bitmap> {
        public final /* synthetic */ Rect a;
        public final /* synthetic */ ArrayList b;
        public final /* synthetic */ float c;
        public final /* synthetic */ Matrix d;

        public a(Rect rect, ArrayList arrayList, float f, Matrix matrix) {
            this.a = rect;
            this.b = arrayList;
            this.c = f;
            this.d = matrix;
        }

        @Override // java.util.concurrent.Callable
        public final Bitmap call() throws Exception {
            Bitmap bitmapCreateBitmap;
            Rect rect = this.a;
            int iMax = (int) Math.max(Math.ceil(rect.width() / Math.min(2048, rect.width())), Math.ceil(rect.height() / Math.min(2048, rect.height())));
            int iHighestOneBit = Integer.highestOneBit(iMax);
            if (iHighestOneBit != iMax) {
                iMax = iHighestOneBit * 2;
            }
            int iWidth = this.a.width() / iMax;
            int iHeight = this.a.height() / iMax;
            synchronized (this) {
                bitmapCreateBitmap = n10.this.h;
            }
            int i = 0;
            if (bitmapCreateBitmap != null && bitmapCreateBitmap.getWidth() == iWidth && bitmapCreateBitmap.getHeight() == iHeight) {
                n10.this.c.drawColor(0, PorterDuff.Mode.CLEAR);
                n10.this.c.setMatrix(null);
            } else {
                if (bitmapCreateBitmap != null) {
                    bitmapCreateBitmap.recycle();
                }
                bitmapCreateBitmap = Bitmap.createBitmap(iWidth, iHeight, Bitmap.Config.ARGB_8888);
                n10.this.c.setBitmap(bitmapCreateBitmap);
                n10.this.c.setMatrix(null);
            }
            n10.this.c.save();
            if (iMax != 1) {
                float f = 1.0f / iMax;
                n10.this.c.scale(f, f);
            }
            Canvas canvas = n10.this.c;
            Rect rect2 = this.a;
            canvas.translate(-rect2.left, -rect2.top);
            ArrayList arrayList = this.b;
            int size = arrayList.size();
            while (i < size) {
                Object obj = arrayList.get(i);
                i++;
                f10 f10Var = (f10) obj;
                if (f10Var.c() != 1) {
                    f10Var.a(this.c, this.d);
                    n10 n10Var = n10.this;
                    f10Var.a(n10Var.c, n10Var.a, n10Var.b);
                }
            }
            n10.this.c.restore();
            return bitmapCreateBitmap;
        }
    }

    public n10(Paint paint, Paint paint2) {
        this.a = new Paint(paint);
        this.b = new Paint(paint2);
        synchronized (ar.class) {
            q10.c();
        }
        this.e = new bx("pspdfkit-shape-render", 1);
    }

    public final Completable a(final Rect rect, final ArrayList arrayList, final Matrix matrix, final float f, final long j) {
        return Completable.create(new CompletableOnSubscribe() { // from class: com.pspdfkit.internal.n10$$ExternalSyntheticLambda0
            @Override // io.reactivex.rxjava3.core.CompletableOnSubscribe
            public final void subscribe(CompletableEmitter completableEmitter) throws Throwable {
                this.f$0.a(rect, arrayList, matrix, f, j, completableEmitter);
            }
        });
    }

    public final Rect b() {
        Rect rect;
        synchronized (this.f) {
            rect = new Rect(this.i);
        }
        return rect;
    }

    public final void finalize() throws Throwable {
        this.e.b();
        super.finalize();
    }

    @Override // com.pspdfkit.internal.nx
    public final void recycle() {
        this.g = false;
        yz.a(this.j);
        this.j = null;
        synchronized (this) {
            Bitmap bitmap = this.h;
            if (bitmap != null) {
                bitmap.recycle();
                this.h = null;
            }
        }
    }

    public final Single<Bitmap> a(Rect rect, List<? extends f10> list, Matrix matrix, float f, long j) {
        if (list.isEmpty() || rect.isEmpty()) {
            this.i = new Rect(rect);
            return Single.never();
        }
        this.g = false;
        final Rect rect2 = new Rect(rect);
        final ArrayList arrayList = new ArrayList(list);
        this.d.set(matrix);
        Single singleFromCallable = SingleJust.fromCallable(new a(rect2, arrayList, f, matrix));
        bx bxVar = this.e;
        bxVar.getClass();
        return singleFromCallable.subscribeOn(bxVar.new a(5)).delaySubscription(j, TimeUnit.MILLISECONDS).observeOn(AndroidSchedulers.mainThread()).doOnSuccess(new Consumer() { // from class: com.pspdfkit.internal.n10$$ExternalSyntheticLambda1
            @Override // io.reactivex.rxjava3.functions.Consumer
            public final void accept(Object obj) throws Throwable {
                this.f$0.a(arrayList, rect2, (Bitmap) obj);
            }
        }).doOnDispose(new Action() { // from class: com.pspdfkit.internal.n10$$ExternalSyntheticLambda2
            @Override // io.reactivex.rxjava3.functions.Action
            public final void run() throws Throwable {
                n10.a(arrayList);
            }
        });
    }

    public final void a(List list, Rect rect, Bitmap bitmap) throws Throwable {
        Iterator it = list.iterator();
        while (it.hasNext()) {
            f10 f10Var = (f10) it.next();
            if (f10Var.c() == 2) {
                f10Var.a(3);
            }
        }
        synchronized (this.f) {
            this.h = bitmap;
            this.i = rect;
            this.g = true;
        }
    }

    public static /* synthetic */ void a(List list) throws Throwable {
        Iterator it = list.iterator();
        while (it.hasNext()) {
            f10 f10Var = (f10) it.next();
            if (f10Var.c() != 3) {
                f10Var.a(2);
            }
        }
    }

    public final Bitmap a() {
        Bitmap bitmap;
        synchronized (this.f) {
            bitmap = this.h;
        }
        return bitmap;
    }

    public final void a(Rect rect, List list, Matrix matrix, float f, long j, CompletableEmitter completableEmitter) throws Throwable {
        this.g = false;
        yz.a(this.j);
        this.j = null;
        this.j = (Disposable) a(rect, (List<? extends f10>) list, matrix, f, j).subscribeWith(new m10(this, completableEmitter));
    }
}
