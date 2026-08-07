package com.pspdfkit.ui.note;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.PointF;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import androidx.core.graphics.drawable.DrawableCompat;
import com.pspdfkit.annotations.Annotation;
import com.pspdfkit.internal.h60;
import com.pspdfkit.internal.uw;
import com.pspdfkit.ui.drawable.PdfDrawable;

/* JADX INFO: loaded from: classes3.dex */
public abstract class NoteHinterDrawable extends PdfDrawable {
    protected final Annotation annotation;
    protected final int halfHeightPx;
    protected final int halfWidthPx;
    protected final int heightPx;
    protected final int noteHinterColor;
    protected final Drawable noteIcon;
    protected RectF pdfBoundingBox;
    protected PointF pdfPoint;
    protected RectF viewBoundingBox;
    protected Rect viewBoundingBoxRounded;
    protected PointF viewPoint;
    protected final int widthPx;

    public NoteHinterDrawable(Drawable drawable, Annotation annotation, AnnotationNoteHinterThemeConfiguration annotationNoteHinterThemeConfiguration) {
        uw.a(drawable, "noteIcon", null);
        uw.a(annotation, "annotation", null);
        uw.a(annotationNoteHinterThemeConfiguration, "annotationNoteHinterThemeConfiguration", null);
        this.noteIcon = drawable;
        this.annotation = annotation;
        this.pdfBoundingBox = new RectF();
        this.viewBoundingBoxRounded = new Rect();
        this.viewBoundingBox = new RectF();
        this.viewPoint = new PointF();
        this.pdfPoint = new PointF();
        if (annotationNoteHinterThemeConfiguration.intrinsicSize) {
            this.widthPx = drawable.getIntrinsicWidth();
            this.heightPx = drawable.getIntrinsicHeight();
        } else {
            this.widthPx = annotationNoteHinterThemeConfiguration.noteHinterWidth;
            this.heightPx = annotationNoteHinterThemeConfiguration.noteHinterHeight;
        }
        this.halfWidthPx = this.widthPx / 2;
        this.halfHeightPx = this.heightPx / 2;
        int i = annotationNoteHinterThemeConfiguration.noteHinterColor;
        this.noteHinterColor = i;
        setAlpha(annotationNoteHinterThemeConfiguration.noteHinterAlpha);
        DrawableCompat.setTint(drawable, i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$refresh$0() {
        updatePdfToViewTransformation(getPdfToPageTransformation());
        setBounds(this.viewBoundingBoxRounded);
    }

    public void dispose() {
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        if (isDrawAllowed()) {
            this.noteIcon.setBounds(this.viewBoundingBoxRounded);
            this.noteIcon.draw(canvas);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return -3;
    }

    public boolean isDrawAllowed() {
        if (this.annotation.isMeasurement()) {
            return false;
        }
        return this.annotation.getInternal().isInstantCommentThreadRoot() || !TextUtils.isEmpty(this.annotation.getContents());
    }

    public void refresh() {
        h60.a(new Runnable() { // from class: com.pspdfkit.ui.note.NoteHinterDrawable$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$refresh$0();
            }
        });
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i) {
        this.noteIcon.setAlpha(i);
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
    }

    @Override // com.pspdfkit.ui.drawable.PdfDrawable
    public void updatePdfToViewTransformation(Matrix matrix) {
        super.updatePdfToViewTransformation(matrix);
    }
}
