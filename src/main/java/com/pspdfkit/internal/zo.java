package com.pspdfkit.internal;

import android.graphics.Bitmap;
import android.util.Size;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: loaded from: classes3.dex */
public final class zo {
    public final boolean a;
    public final AtomicInteger b;
    public Bitmap c;

    public zo(Bitmap bitmap) {
        this.b = new AtomicInteger(1);
        this.c = bitmap;
        this.a = true;
    }

    public final Bitmap a() {
        Bitmap bitmap = this.c;
        if (bitmap != null) {
            return bitmap;
        }
        throw new IllegalStateException("Attempted to use recycled bitmap.");
    }

    public final synchronized void b() {
        if (this.a && this.b.decrementAndGet() == 0) {
            q10.a.b().c(this.c);
            this.c = null;
        }
    }

    public final synchronized Bitmap c() {
        if (this.c == null) {
            return null;
        }
        this.b.incrementAndGet();
        return this.c;
    }

    public zo(Bitmap bitmap, Size size) {
        this.b = new AtomicInteger(1);
        if (bitmap == null) {
            int iMax = Math.max(1, size.getWidth());
            int iMax2 = Math.max(1, size.getHeight());
            y7 y7Var = q10.c;
            if (y7Var == null) {
                y7Var = new y7();
                q10.c = y7Var;
            }
            this.c = y7Var.a(iMax, iMax2);
            this.a = true;
            return;
        }
        if (bitmap.getWidth() == size.getWidth() && bitmap.getHeight() == size.getHeight()) {
            this.a = false;
            this.c = bitmap;
            return;
        }
        throw new IllegalArgumentException("Reusable bitmap size doesn't conform to width and height parameters!");
    }
}
