package com.pspdfkit.ui.note;

import android.graphics.drawable.Drawable;
import com.pspdfkit.annotations.Annotation;

/* JADX INFO: loaded from: classes3.dex */
public class NoteStampAnnotationHinterDrawable extends AlignedAnnotationHinterDrawable {
    public NoteStampAnnotationHinterDrawable(Drawable drawable, Annotation annotation, AnnotationNoteHinterThemeConfiguration annotationNoteHinterThemeConfiguration) {
        super(drawable, annotation, annotationNoteHinterThemeConfiguration, AlignedAnnotationHinterDrawable.HorizontalAlignment.RIGHT, AlignedAnnotationHinterDrawable.VerticalAlignment.CENTER);
    }
}
