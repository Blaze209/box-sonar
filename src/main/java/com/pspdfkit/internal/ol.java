package com.pspdfkit.internal;

import com.pspdfkit.annotations.NoteAnnotation;
import com.pspdfkit.ui.special_mode.controller.AnnotationTool;
import com.pspdfkit.ui.special_mode.controller.AnnotationToolVariant;

/* JADX INFO: loaded from: classes3.dex */
public final class ol extends zr {
    public ol(q0 q0Var, AnnotationToolVariant annotationToolVariant) {
        super(q0Var, annotationToolVariant);
    }

    @Override // com.pspdfkit.internal.zr
    public final void a(NoteAnnotation noteAnnotation) {
        noteAnnotation.getInternal().markAsInstantCommentRoot();
        super.a(noteAnnotation);
    }

    @Override // com.pspdfkit.internal.zr, com.pspdfkit.internal.d3
    public final AnnotationTool h() {
        return AnnotationTool.INSTANT_COMMENT_MARKER;
    }
}
