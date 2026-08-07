package com.pspdfkit.internal;

import android.content.Context;
import android.graphics.ColorFilter;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.view.View;
import android.view.ViewStructure;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.appcompat.widget.AppCompatImageView;
import com.pspdfkit.R;
import com.pspdfkit.annotations.Annotation;
import com.pspdfkit.annotations.AnnotationType;
import com.pspdfkit.configuration.PdfConfiguration;
import com.pspdfkit.ui.overlay.OverlayLayoutParams;
import com.pspdfkit.utils.PageRect;
import com.pspdfkit.utils.Size;

/* JADX INFO: loaded from: classes3.dex */
public final class yj extends AppCompatImageView implements z4<Annotation>, nx {
    public final PdfConfiguration a;
    public Annotation b;
    public final ft<Annotation> c;
    public final int d;

    public yj(Context context, PdfConfiguration pdfConfiguration) {
        super(context, null, 0);
        this.c = new ft<>(this);
        this.a = pdfConfiguration;
        this.d = context.getResources().getDimensionPixelSize(R.dimen.pspdf__view_annotation_size);
    }

    @Override // com.pspdfkit.internal.z4
    public final View a() {
        return this;
    }

    @Override // com.pspdfkit.internal.z4
    public final void b() {
        if (this.b == null) {
            throw new IllegalStateException("Cannot update NoteAnnotationView if no annotation is set.");
        }
        setImageDrawable(null);
        setColorFilter((ColorFilter) null);
        setAlpha(this.b.getAlpha());
        setImageDrawable(AppCompatResources.getDrawable(getContext(), ww.a(this.b)));
        if (!this.b.getInternal().isInstantCommentThreadRoot()) {
            setColorFilter(new PorterDuffColorFilter(ff.a(this.b.getColor(), this.a.isToGrayscale(), this.a.isInvertColors()), PorterDuff.Mode.SRC_ATOP));
        }
        setContentDescription(this.b.getContents());
    }

    @Override // com.pspdfkit.internal.z4
    public Annotation getAnnotation() {
        return this.b;
    }

    @Override // com.pspdfkit.internal.z4
    public /* bridge */ /* synthetic */ l1 getContentScaler() {
        return super.getContentScaler();
    }

    @Override // com.pspdfkit.internal.z4
    public /* bridge */ /* synthetic */ PageRect getPageRect() {
        return super.getPageRect();
    }

    @Override // com.pspdfkit.internal.z4
    public final void n() {
        OverlayLayoutParams overlayLayoutParamsA = b5.a(this, this.b.getType() == AnnotationType.NOTE && !this.a.isNoteAnnotationNoZoomHandlingEnabled());
        float f = this.d;
        overlayLayoutParamsA.minSize = new Size(f, f);
        if (overlayLayoutParamsA.noZoom) {
            float f2 = this.d;
            overlayLayoutParamsA.fixedScreenSize = new Size(f2, f2);
        } else {
            overlayLayoutParamsA.fixedScreenSize = null;
        }
        setLayoutParams(overlayLayoutParamsA);
    }

    @Override // android.view.View
    public final void onProvideStructure(ViewStructure viewStructure) {
        super.onProvideStructure(viewStructure);
        if (getAnnotation() == null || getAnnotation().getContents() == null) {
            return;
        }
        viewStructure.setText(getAnnotation().getContents());
    }

    @Override // com.pspdfkit.internal.nx
    public final void recycle() {
        setImageDrawable(null);
        setColorFilter((ColorFilter) null);
        this.b = null;
        this.c.b.clear();
    }

    @Override // com.pspdfkit.internal.z4
    public void setAnnotation(Annotation annotation) {
        if (annotation.getType() != AnnotationType.NOTE && annotation.getType() != AnnotationType.FILE) {
            throw new IllegalArgumentException("Only note and file annotations are supported.");
        }
        if (annotation.equals(this.b)) {
            return;
        }
        this.b = annotation;
        n();
        b();
        this.c.a();
    }

    /* JADX WARN: Type inference incomplete: some casts might be missing */
    @Override // com.pspdfkit.internal.z4
    public final void a(z4.a<Annotation> aVar) {
        this.c.b.a((z4.a<T>) aVar);
        if (this.b != null) {
            this.c.a();
        }
    }
}
