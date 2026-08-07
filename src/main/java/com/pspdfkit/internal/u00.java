package com.pspdfkit.internal;

import android.graphics.Point;
import android.graphics.PointF;
import android.graphics.Rect;
import android.graphics.RectF;
import android.view.MotionEvent;
import android.view.View;
import com.pspdfkit.annotations.Annotation;
import com.pspdfkit.annotations.AnnotationType;
import com.pspdfkit.annotations.FreeTextAnnotation;
import com.pspdfkit.utils.Size;
import java.util.List;
import kotlin.collections.CollectionsKt;

/* JADX INFO: loaded from: classes3.dex */
public final class u00 {
    public final o4 a;
    public int g;
    public final Rect b = new Rect();
    public final Rect c = new Rect();
    public final RectF d = new RectF();
    public final RectF e = new RectF();
    public List<? extends z4<Annotation>> f = CollectionsKt.emptyList();
    public boolean h = true;
    public double i = Double.NaN;
    public double j = Double.NaN;
    public double k = Double.NaN;
    public final RectF l = new RectF(0.0f, 0.0f, 0.0f, 0.0f);

    public u00(o4 o4Var) {
        this.a = o4Var;
    }

    public final boolean a() {
        Annotation annotation;
        if (this.f.size() != 1 || (annotation = this.f.get(0).getAnnotation()) == null) {
            return false;
        }
        return annotation.isUiRotationSupported();
    }

    public final List<PointF> b(z4<?> z4Var) {
        Annotation annotation = z4Var.getAnnotation();
        if (annotation == null) {
            throw new IllegalArgumentException("annotationView isn't bound to an annotation.");
        }
        int width = this.a.getWidth() / 2;
        int height = this.a.getHeight() / 2;
        double radians = Math.toRadians(annotation.getInternal().getPageRotation()) + (Double.isNaN(this.i) ? Math.toRadians(annotation.getInternal().getRotation()) : this.i);
        RectF rectF = this.l;
        double dSqrt = Math.sqrt(Math.pow((((double) rectF.height()) / 2.0d) + ((double) this.g), 2.0d) + Math.pow((((double) rectF.width()) / 2.0d) + ((double) this.g), 2.0d));
        double dAtan2 = Math.atan2((((double) rectF.height()) / 2.0d) + ((double) this.g), (((double) rectF.width()) / 2.0d) + ((double) this.g));
        double d = (radians - 3.141592653589793d) + dAtan2;
        float fCos = (float) (Math.cos(d) * dSqrt);
        float fSin = (float) (Math.sin(d) * dSqrt);
        double d2 = radians - dAtan2;
        float fCos2 = (float) (Math.cos(d2) * dSqrt);
        float fSin2 = (float) (Math.sin(d2) * dSqrt);
        float f = width;
        float f2 = height;
        return CollectionsKt.listOf((Object[]) new PointF[]{new PointF(f + fCos, f2 + fSin), new PointF(f + fCos2, f2 + fSin2), new PointF(f - fCos, f2 - fSin), new PointF(f - fCos2, f2 - fSin2)});
    }

    public final RectF c(z4<?> z4Var) {
        Annotation annotation = z4Var.getAnnotation();
        if (annotation == null) {
            throw new IllegalArgumentException("annotationView isn't bound to an annotation.");
        }
        RectF rectFA = a(annotation);
        rectFA.sort();
        Rect rectA = this.a.a(z4Var.a(), this.b);
        rectA.sort();
        Size sizeB = ip.b(new Size(rectFA.width(), rectFA.height()), annotation.getInternal().getRotation() + annotation.getInternal().getPageRotation());
        float fMin = Math.min(rectA.width() / sizeB.width, rectA.height() / sizeB.height);
        rectFA.set(0.0f, 0.0f, rectFA.width() * fMin, rectFA.height() * fMin);
        return rectFA;
    }

    public final void a(MotionEvent motionEvent) {
        if (motionEvent == null || !a()) {
            return;
        }
        Rect rect = this.c;
        rect.set(this.a.getLeft(), this.a.getTop(), this.a.getRight(), this.a.getBottom());
        Point point = new Point(rect.centerX(), rect.centerY());
        double dAtan2 = Math.atan2(motionEvent.getY() - point.y, motionEvent.getX() - point.x);
        z4<Annotation> z4Var = this.f.get(0);
        Annotation annotation = z4Var.getAnnotation();
        if (annotation == null) {
            return;
        }
        if (Double.isNaN(this.k)) {
            this.j = Math.toRadians(annotation.getInternal().getRotation());
            this.k = dAtan2;
        }
        double d = (dAtan2 - this.k) + this.j;
        this.i = d;
        if (annotation.getInternal().getContentSize(this.d) == null) {
            annotation.setContentSize(a(annotation), true);
        }
        float degrees = (float) Math.toDegrees(d - this.j);
        z4Var.a().setRotation(degrees);
        if (this.h) {
            this.a.setScaleHandleDrawableRotation(degrees);
        }
        o4 o4Var = this.a;
        o4Var.b(o4Var.getLeft(), o4Var.getTop());
        o4Var.a(o4Var.getLeft(), o4Var.getTop(), o4Var.getRight(), o4Var.getBottom());
        this.a.invalidate();
        this.l.set(c(z4Var));
    }

    public final <T extends Annotation> boolean a(final z4<T> z4Var) {
        Annotation annotation;
        z4Var.getClass();
        if (Double.isNaN(this.i) || (annotation = z4Var.getAnnotation()) == null) {
            return false;
        }
        RectF rectFA = a(annotation);
        rectFA.sort();
        RectF boundingBox = annotation.getBoundingBox();
        boundingBox.sort();
        Size sizeB = ip.b(new Size(rectFA.width(), rectFA.height()), annotation.getInternal().getRotation() + annotation.getInternal().getPageRotation());
        float fMin = Math.min(boundingBox.width() / sizeB.width, boundingBox.height() / sizeB.height);
        if (annotation.getType() == AnnotationType.FREETEXT) {
            ((FreeTextAnnotation) annotation).setRotation((int) Math.toDegrees(this.i));
        } else {
            annotation.getInternal().setRotation((int) Math.toDegrees(this.i));
            annotation.getInternal().adjustBoundsForRotation(fMin);
        }
        if (this.h) {
            this.a.setScaleHandleDrawableInitialRotation((float) Math.toDegrees(this.i));
        }
        if (z4Var instanceof vy) {
            vy vyVar = (vy) z4Var;
            vyVar.setRefreshBoundingBoxAfterRendering(true);
            vyVar.setOnRenderedListener(new vy.a() { // from class: com.pspdfkit.internal.u00$$ExternalSyntheticLambda0
                @Override // com.pspdfkit.internal.vy.a
                public final void a() {
                    u00.a(z4Var, z4Var);
                }
            });
        } else {
            z4Var.a().setRotation(0.0f);
        }
        z4Var.b();
        this.i = Double.NaN;
        this.j = Double.NaN;
        this.k = Double.NaN;
        return true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final void a(z4 z4Var, z4 z4Var2) {
        ((View) z4Var).setRotation(0.0f);
        vy vyVar = (vy) z4Var2;
        vyVar.setRefreshBoundingBoxAfterRendering(false);
        vyVar.setOnRenderedListener(null);
    }

    public final RectF a(Annotation annotation) {
        float fHeight;
        float fWidth;
        RectF contentSize = annotation.getInternal().getContentSize(this.e);
        if (contentSize != null) {
            return contentSize;
        }
        List<o4.b> list = tz.a;
        RectF boundingBox = annotation.getBoundingBox();
        boundingBox.sort();
        int pageRotation = (annotation.getInternal().getPageRotation() + annotation.getInternal().getRotation()) % 360;
        if (pageRotation != 90 && pageRotation != 270) {
            fHeight = boundingBox.width();
            fWidth = boundingBox.height();
        } else {
            fHeight = boundingBox.height();
            fWidth = boundingBox.width();
        }
        return new RectF(0.0f, 0.0f, fHeight, fWidth);
    }
}
