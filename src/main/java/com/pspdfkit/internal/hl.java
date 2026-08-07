package com.pspdfkit.internal;

import android.content.Context;
import android.graphics.Bitmap;
import android.widget.FrameLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.core.content.res.ResourcesCompat;
import com.microsoft.intune.mam.client.widget.MAMTextView;
import com.pspdfkit.R;
import com.pspdfkit.annotations.Annotation;
import com.pspdfkit.configuration.PdfConfiguration;
import com.pspdfkit.document.PdfDocument;

/* JADX INFO: loaded from: classes3.dex */
public final class hl extends vy implements gl.b {
    public Runnable A;
    public final int w;
    public gl x;
    public ProgressBar y;
    public TextView z;

    public hl(Context context, PdfConfiguration pdfConfiguration, PdfDocument pdfDocument) {
        super(context, pdfConfiguration, pdfDocument);
        this.w = f60.a(getContext(), R.attr.pspdf__backgroundColor, R.color.pspdf__onPrimaryLight);
    }

    @Override // com.pspdfkit.internal.vy
    public final void a(Bitmap bitmap) {
        gl glVar = this.x;
        if (glVar == null || glVar.a()) {
            super.a(bitmap);
            gl glVar2 = this.x;
            if (glVar2 != null) {
                glVar2.a(this);
            }
            u();
            ProgressBar progressBar = this.y;
            if (progressBar != null) {
                progressBar.setVisibility(8);
            }
            t();
            TextView textView = this.z;
            if (textView != null) {
                textView.setVisibility(8);
            }
            t();
        }
    }

    @Override // com.pspdfkit.internal.vy, com.pspdfkit.internal.z4
    public final void b() {
        s();
        this.o = true;
        o();
    }

    @Override // com.pspdfkit.internal.gl.b
    public final void c() {
        hl$$ExternalSyntheticLambda0 hl__externalsyntheticlambda0 = new hl$$ExternalSyntheticLambda0(this);
        u();
        this.A = hl__externalsyntheticlambda0;
        postDelayed(hl__externalsyntheticlambda0, 300L);
    }

    @Override // com.pspdfkit.internal.gl.b
    public final void j() {
        hl$$ExternalSyntheticLambda1 hl__externalsyntheticlambda1 = new hl$$ExternalSyntheticLambda1(this);
        u();
        this.A = hl__externalsyntheticlambda1;
        postDelayed(hl__externalsyntheticlambda1, 300L);
    }

    @Override // com.pspdfkit.internal.gl.b
    public final void k() {
        h60.a(new Runnable() { // from class: com.pspdfkit.internal.hl$$ExternalSyntheticLambda2
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.r();
            }
        });
    }

    public final void r() {
        gl glVar = this.x;
        if (glVar != null) {
            glVar.a(this);
            s();
            this.o = true;
            o();
        }
    }

    @Override // com.pspdfkit.internal.vy, com.pspdfkit.internal.nx
    public final void recycle() {
        super.recycle();
        gl glVar = this.x;
        if (glVar != null) {
            glVar.a(this);
            this.x = null;
        }
        u();
        ProgressBar progressBar = this.y;
        if (progressBar != null) {
            progressBar.setVisibility(8);
        }
        t();
        TextView textView = this.z;
        if (textView != null) {
            textView.setVisibility(8);
        }
        t();
    }

    public final void s() {
        Annotation annotation = getAnnotation();
        if (annotation == null) {
            return;
        }
        Object annotationResource = annotation.getInternal().getAnnotationResource();
        if (annotationResource instanceof gl) {
            gl glVar = (gl) annotationResource;
            this.x = glVar;
            int iOrdinal = glVar.b().ordinal();
            if (iOrdinal != 0) {
                if (iOrdinal == 1) {
                    this.x.b(this);
                    hl$$ExternalSyntheticLambda1 hl__externalsyntheticlambda1 = new hl$$ExternalSyntheticLambda1(this);
                    u();
                    this.A = hl__externalsyntheticlambda1;
                    postDelayed(hl__externalsyntheticlambda1, 300L);
                    return;
                }
                if (iOrdinal != 2) {
                    return;
                }
            }
            this.x.b(this);
            hl$$ExternalSyntheticLambda0 hl__externalsyntheticlambda0 = new hl$$ExternalSyntheticLambda0(this);
            u();
            this.A = hl__externalsyntheticlambda0;
            postDelayed(hl__externalsyntheticlambda0, 300L);
        }
    }

    @Override // com.pspdfkit.internal.vy, com.pspdfkit.internal.z4
    public void setAnnotation(Annotation annotation) {
        if (annotation.equals(getAnnotation())) {
            return;
        }
        super.setAnnotation(annotation);
        s();
    }

    public final void t() {
        ProgressBar progressBar;
        TextView textView = this.z;
        if ((textView == null || textView.getVisibility() != 0) && ((progressBar = this.y) == null || progressBar.getVisibility() != 0)) {
            setBackground(null);
        } else {
            setBackgroundColor(this.w);
        }
    }

    public final void u() {
        Runnable runnable = this.A;
        if (runnable != null) {
            removeCallbacks(runnable);
            this.A = null;
        }
    }

    public final void v() {
        ProgressBar progressBar = this.y;
        if (progressBar != null) {
            progressBar.setVisibility(8);
        }
        t();
        TextView textView = this.z;
        if (textView == null) {
            MAMTextView mAMTextView = new MAMTextView(getContext());
            this.z = mAMTextView;
            mAMTextView.setText("✕");
            this.z.setTextColor(ResourcesCompat.getColor(getResources(), android.R.color.darker_gray, null));
            this.z.setTextSize(a80.a(getContext(), 24));
            this.z.setGravity(17);
            addView(this.z, new FrameLayout.LayoutParams(-2, -2, 17));
        } else {
            textView.setVisibility(0);
        }
        t();
    }

    public final void w() {
        TextView textView = this.z;
        if (textView != null) {
            textView.setVisibility(8);
        }
        t();
        ProgressBar progressBar = this.y;
        if (progressBar == null) {
            ProgressBar progressBar2 = new ProgressBar(getContext());
            this.y = progressBar2;
            progressBar2.setIndeterminate(true);
            addView(this.y, new FrameLayout.LayoutParams(-2, -2, 17));
        } else {
            progressBar.setVisibility(0);
        }
        t();
    }
}
