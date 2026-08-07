package com.pspdfkit.internal;

import com.pspdfkit.configuration.activity.PdfActivityConfiguration;
import com.pspdfkit.internal.jni.NativeLicenseFeatures;
import com.pspdfkit.ui.special_mode.controller.AnnotationTool;

/* JADX INFO: loaded from: classes3.dex */
public final class sg {
    public static final boolean a(PdfActivityConfiguration pdfActivityConfiguration, tg tgVar) {
        pdfActivityConfiguration.getClass();
        tgVar.getClass();
        if (!tgVar.a(pdfActivityConfiguration.getConfiguration(), AnnotationTool.SIGNATURE)) {
            return false;
        }
        synchronized (tgVar) {
            if (tgVar.a(NativeLicenseFeatures.ANNOTATION_EDITING) || !tg.b()) {
                return pdfActivityConfiguration.isSignatureButtonPositionForcedInMainToolbar();
            }
            return true;
        }
    }
}
