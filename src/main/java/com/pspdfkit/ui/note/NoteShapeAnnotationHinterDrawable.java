package com.pspdfkit.ui.note;

import android.graphics.drawable.Drawable;
import com.pspdfkit.annotations.Annotation;
import com.pspdfkit.annotations.AnnotationType;

/* JADX INFO: loaded from: classes3.dex */
public class NoteShapeAnnotationHinterDrawable extends AlignedAnnotationHinterDrawable {
    public NoteShapeAnnotationHinterDrawable(Drawable drawable, Annotation annotation, AnnotationNoteHinterThemeConfiguration annotationNoteHinterThemeConfiguration) {
        super(drawable, annotation, annotationNoteHinterThemeConfiguration, AlignedAnnotationHinterDrawable.HorizontalAlignment.LEFT, annotation.getType() == AnnotationType.CIRCLE ? AlignedAnnotationHinterDrawable.VerticalAlignment.CENTER : AlignedAnnotationHinterDrawable.VerticalAlignment.BOTTOM);
    }
}
