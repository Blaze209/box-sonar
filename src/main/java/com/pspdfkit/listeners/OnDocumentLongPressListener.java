package com.pspdfkit.listeners;

import android.graphics.PointF;
import android.view.MotionEvent;
import com.pspdfkit.annotations.Annotation;
import com.pspdfkit.document.PdfDocument;

/* JADX INFO: loaded from: classes3.dex */
public interface OnDocumentLongPressListener {
    boolean onDocumentLongPress(PdfDocument pdfDocument, int i, MotionEvent motionEvent, PointF pointF, Annotation annotation);
}
