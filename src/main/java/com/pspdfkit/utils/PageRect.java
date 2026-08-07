package com.pspdfkit.utils;

import android.graphics.Matrix;
import android.graphics.RectF;
import com.pspdfkit.internal.s60;
import com.pspdfkit.internal.uw;

/* JADX INFO: loaded from: classes3.dex */
public class PageRect implements Comparable<PageRect> {
    private final RectF pageRect = new RectF();
    private final RectF screenRect = new RectF();

    public PageRect() {
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof PageRect) {
            return this.pageRect.equals(((PageRect) obj).pageRect);
        }
        return false;
    }

    public RectF getPageRect() {
        return this.pageRect;
    }

    public RectF getScreenRect() {
        return this.screenRect;
    }

    public int hashCode() {
        return this.pageRect.hashCode();
    }

    public void inset(float f, float f2) {
        this.pageRect.inset(f, f2);
    }

    public void set(RectF rectF) {
        uw.a(rectF, "rect", null);
        this.pageRect.set(rectF);
    }

    public String toString() {
        return "PageRect(pageRect:{" + this.pageRect.toShortString() + "}, screenRect:{" + this.screenRect.toShortString() + "})";
    }

    public void updatePageRect(Matrix matrix) {
        uw.a(matrix, "pageToScreenMatrix", null);
        RectF rectF = this.screenRect;
        RectF rectF2 = this.pageRect;
        rectF2.set(rectF);
        s60.a(rectF2, matrix);
    }

    public void updateScreenRect(Matrix matrix) {
        uw.a(matrix, "pageToScreenMatrix", null);
        RectF rectF = this.pageRect;
        RectF rectF2 = this.screenRect;
        rectF2.set(rectF);
        matrix.mapRect(rectF2);
    }

    @Override // java.lang.Comparable
    public int compareTo(PageRect pageRect) {
        RectF rectF = this.screenRect;
        RectF rectF2 = pageRect.screenRect;
        float f = rectF.top;
        float f2 = rectF2.top;
        if (f != f2) {
            return f > f2 ? 1 : -1;
        }
        float f3 = rectF.left;
        float f4 = rectF2.left;
        if (f3 == f4) {
            return 0;
        }
        return f3 > f4 ? 1 : -1;
    }

    public void set(PageRect pageRect) {
        uw.a(pageRect, "pageRect", null);
        this.pageRect.set(pageRect.pageRect);
        this.screenRect.set(pageRect.screenRect);
    }

    public void set(float f, float f2, float f3, float f4) {
        this.pageRect.set(f, f2, f3, f4);
    }

    public PageRect(float f, float f2, float f3, float f4) {
        set(f, f2, f3, f4);
    }

    public PageRect(RectF rectF) {
        set(rectF);
    }
}
