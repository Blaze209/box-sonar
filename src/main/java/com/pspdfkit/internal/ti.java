package com.pspdfkit.internal;

import android.net.Uri;
import com.pspdfkit.document.image.ImagePicker;
import com.pspdfkit.ui.special_mode.controller.AnnotationTool;
import com.pspdfkit.ui.special_mode.controller.AnnotationToolVariant;

/* JADX INFO: loaded from: classes3.dex */
public final class ti extends i7 {
    public ti(q0 q0Var, AnnotationToolVariant annotationToolVariant) {
        super(q0Var, annotationToolVariant);
    }

    @Override // com.pspdfkit.internal.i7
    public final void b(Uri uri) {
    }

    @Override // com.pspdfkit.internal.gu
    public final int f() {
        return 13;
    }

    @Override // com.pspdfkit.internal.d3
    public final AnnotationTool h() {
        return AnnotationTool.IMAGE;
    }

    @Override // com.pspdfkit.internal.i7
    public final String o() {
        return "com.pspdfkit.ui.GalleryImageStampAnnotationModeHandler.FRAGMENT_TAG." + k();
    }

    @Override // com.pspdfkit.internal.i7
    public final void p() {
        ImagePicker imagePicker = this.g;
        if (imagePicker != null) {
            imagePicker.startImageGallery();
        }
    }
}
