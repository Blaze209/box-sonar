package com.pspdfkit.ui.note;

import android.graphics.drawable.Drawable;
import com.pspdfkit.annotations.Annotation;

/* JADX INFO: loaded from: classes3.dex */
public class NoteLineAnnotationHinterDrawable extends AlignedAnnotationHinterDrawable {
    public NoteLineAnnotationHinterDrawable(Drawable drawable, Annotation annotation, AnnotationNoteHinterThemeConfiguration annotationNoteHinterThemeConfiguration) {
        super(drawable, annotation, annotationNoteHinterThemeConfiguration, AlignedAnnotationHinterDrawable.HorizontalAlignment.CENTER, AlignedAnnotationHinterDrawable.VerticalAlignment.CENTER);
    }
}
