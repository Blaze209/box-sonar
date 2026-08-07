package com.pspdfkit.internal;

import android.graphics.Bitmap;
import com.pspdfkit.utils.PdfLog;
import io.reactivex.rxjava3.core.Completable;
import io.reactivex.rxjava3.functions.Action;
import io.reactivex.rxjava3.schedulers.Schedulers;
import java.util.ArrayDeque;
import java.util.Iterator;

/* JADX INFO: loaded from: classes3.dex */
public final class y7 {
    public final long a;
    public final ArrayDeque b;
    public final ArrayDeque c;
    public final boolean d;
    public long e;

    public static class a {
        public final Bitmap a;
        public final long b;

        public a(Bitmap bitmap) {
            this.a = bitmap;
            this.b = y7.a(bitmap);
        }
    }

    public y7() {
        long jMaxMemory = Runtime.getRuntime().maxMemory() / 4;
        this.e = 0L;
        this.a = jMaxMemory;
        this.d = true;
        PdfLog.v("Nutri.BitmapPool", "Bitmap pool initialized to " + (jMaxMemory / 1024) + " KB.", new Object[0]);
        this.b = new ArrayDeque();
        this.c = new ArrayDeque();
    }

    public static long a(Bitmap bitmap) {
        if (bitmap == null) {
            return 0L;
        }
        synchronized (bitmap) {
            if (bitmap.isRecycled()) {
                return 0L;
            }
            return bitmap.getAllocationByteCount();
        }
    }

    public final void b(Bitmap bitmap) throws Throwable {
        ArrayDeque arrayDeque = this.b;
        a aVar = new a(bitmap);
        synchronized (this) {
            arrayDeque.addLast(aVar);
            this.e += aVar.b;
            b();
        }
        PdfLog.v("Nutri.BitmapPool", "Placed bitmap into the pool %dx%d, cache size %d.", Integer.valueOf(bitmap.getWidth()), Integer.valueOf(bitmap.getHeight()), Long.valueOf(this.e));
    }

    public final void c(final Bitmap bitmap) {
        if (bitmap == null || bitmap.isRecycled() || this.a == 0) {
            return;
        }
        Completable completableFromAction = Completable.fromAction(new Action() { // from class: com.pspdfkit.internal.y7$$ExternalSyntheticLambda0
            @Override // io.reactivex.rxjava3.functions.Action
            public final void run() throws Throwable {
                this.f$0.b(bitmap);
            }
        });
        if (this.d) {
            completableFromAction.subscribeOn(Schedulers.computation()).subscribe();
        } else {
            completableFromAction.blockingAwait();
        }
    }

    public final Bitmap a(int i, int i2) {
        synchronized (this) {
            Iterator it = this.b.iterator();
            while (it.hasNext()) {
                a aVar = (a) it.next();
                if (aVar.a.getWidth() == i && aVar.a.getHeight() == i2) {
                    it.remove();
                    this.e -= aVar.b;
                    if (!aVar.a.isRecycled()) {
                        PdfLog.v("Nutri.BitmapPool", "Got allocated bitmap %dx%d, cache size %d.", Integer.valueOf(aVar.a.getWidth()), Integer.valueOf(aVar.a.getHeight()), Long.valueOf(this.e));
                        return aVar.a;
                    }
                }
            }
            PdfLog.v("Nutri.BitmapPool", "Allocating new bitmap %dx%d.", Integer.valueOf(i2), Integer.valueOf(i));
            return Bitmap.createBitmap(i, i2, Bitmap.Config.ARGB_8888);
        }
    }

    /* JADX WARN: Code duplicated, block: B:43:0x00e7 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:58:0x00aa A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:60:0x004b A[SYNTHETIC] */
    public final void b() {
        a aVar;
        synchronized (this) {
            Iterator it = this.b.iterator();
            while (it.hasNext()) {
                a aVar2 = (a) it.next();
                if (aVar2.a.isRecycled()) {
                    it.remove();
                    this.e -= aVar2.b;
                }
            }
            Iterator it2 = this.c.iterator();
            while (it2.hasNext()) {
                a aVar3 = (a) it2.next();
                if (aVar3.a.isRecycled()) {
                    it2.remove();
                    this.e -= aVar3.b;
                }
            }
            while (this.e > this.a) {
                if (!this.b.isEmpty()) {
                    a aVar4 = (a) this.b.removeFirst();
                    this.e -= aVar4.b;
                    PdfLog.v("Nutri.BitmapPool", "Evicting bitmap %dx%d, cache size %d/%d.", Integer.valueOf(aVar4.a.getWidth()), Integer.valueOf(aVar4.a.getHeight()), Long.valueOf(this.e), Long.valueOf(this.a));
                    synchronized (aVar4.a) {
                        aVar4.a.recycle();
                    }
                    if (!this.c.isEmpty()) {
                        aVar = (a) this.c.removeFirst();
                        this.e -= aVar.b;
                        PdfLog.v("Nutri.BitmapPool", "Evicting bitmap tile %dx%d, cache size %d/%d.", Integer.valueOf(aVar.a.getWidth()), Integer.valueOf(aVar.a.getHeight()), Long.valueOf(this.e), Long.valueOf(this.a));
                        synchronized (aVar.a) {
                            aVar.a.recycle();
                        }
                    }
                } else if (!this.c.isEmpty()) {
                    aVar = (a) this.c.removeFirst();
                    this.e -= aVar.b;
                    PdfLog.v("Nutri.BitmapPool", "Evicting bitmap tile %dx%d, cache size %d/%d.", Integer.valueOf(aVar.a.getWidth()), Integer.valueOf(aVar.a.getHeight()), Long.valueOf(this.e), Long.valueOf(this.a));
                    synchronized (aVar.a) {
                        aVar.a.recycle();
                    }
                }
                throw th;
            }
        }
    }

    public final void a() {
        synchronized (this) {
            while (!this.b.isEmpty()) {
                Bitmap bitmap = ((a) this.b.removeFirst()).a;
                synchronized (bitmap) {
                    bitmap.recycle();
                }
            }
            while (!this.c.isEmpty()) {
                Bitmap bitmap2 = ((a) this.c.removeFirst()).a;
                synchronized (bitmap2) {
                    bitmap2.recycle();
                }
            }
            this.e = 0L;
        }
    }
}
