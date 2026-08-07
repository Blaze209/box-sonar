package com.pspdfkit.internal;

import androidx.compose.ui.graphics.drawscope.DrawContext;
import com.pspdfkit.annotations.Annotation;
import com.pspdfkit.utils.PageRect;

/* JADX INFO: loaded from: classes3.dex */
public class q1 {
    public final Annotation a;
    public final PageRect b;

    public q1(Annotation annotation) {
        annotation.getClass();
        this.a = annotation;
        this.b = new PageRect(annotation.getBoundingBox());
    }

    public void a(DrawContext drawContext) {
        drawContext.getClass();
    }
}
