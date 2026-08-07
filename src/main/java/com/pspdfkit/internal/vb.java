package com.pspdfkit.internal;

import com.pspdfkit.annotations.Annotation;
import com.pspdfkit.configuration.PdfConfiguration;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public interface vb {
    String getAnnotationCreator();

    PdfConfiguration getConfiguration();

    at getRecordedListener();

    void onAnnotationsCopied(List<? extends Annotation> list);

    void onAnnotationsCut(List<? extends Annotation> list);

    void onAnnotationsPasted(List<? extends Annotation> list);
}
