package com.pspdfkit.internal;

import android.graphics.Bitmap;
import android.graphics.Point;
import android.util.Size;
import com.pspdfkit.annotations.AnnotationType;
import com.pspdfkit.configuration.rendering.PageRenderConfiguration;
import com.pspdfkit.internal.jni.NativeDocumentEditor;
import com.pspdfkit.ui.drawable.PdfDrawable;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public final class km {
    public static final jm a(ou ouVar, int i, Bitmap bitmap, Size size, PageRenderConfiguration pageRenderConfiguration, int i2, NativeDocumentEditor nativeDocumentEditor, Boolean bool, List<? extends AnnotationType> list, List<? extends PdfDrawable> list2, Integer num) {
        Size size2;
        ouVar.getClass();
        pageRenderConfiguration.getClass();
        list.getClass();
        list2.getClass();
        if (size == null) {
            Size size3 = bitmap != null ? new Size(bitmap.getWidth(), bitmap.getHeight()) : null;
            if (size3 == null) {
                throw new IllegalArgumentException("Either bitmapSize or reuseBitmap must be provided");
            }
            size2 = size3;
        } else {
            size2 = size;
        }
        oy oyVar = pageRenderConfiguration.renderRegion ? new oy(new Point(pageRenderConfiguration.regionX, pageRenderConfiguration.regionY), new Size(pageRenderConfiguration.regionFullPageWidth, pageRenderConfiguration.regionFullPageHeight)) : null;
        Bitmap bitmap2 = pageRenderConfiguration.reuseBitmap;
        int i3 = pageRenderConfiguration.paperColor;
        Integer num2 = pageRenderConfiguration.formHighlightColor;
        Integer num3 = pageRenderConfiguration.formItemHighlightColor;
        Integer num4 = pageRenderConfiguration.formRequiredFieldBorderColor;
        Integer num5 = pageRenderConfiguration.signHereOverlayBackgroundColor;
        boolean z = pageRenderConfiguration.toGrayscale;
        boolean z2 = pageRenderConfiguration.invertColors;
        boolean z3 = pageRenderConfiguration.redactionAnnotationPreviewEnabled;
        List<PdfDrawable> list3 = pageRenderConfiguration.renderedDrawables;
        list3.getClass();
        boolean z4 = pageRenderConfiguration.showSignHereOverlay;
        boolean z5 = pageRenderConfiguration.useCache;
        List<Integer> list4 = pageRenderConfiguration.excludedAnnotations;
        list4.getClass();
        List<AnnotationType> list5 = pageRenderConfiguration.excludedAnnotationTypes;
        list5.getClass();
        return jm.a(new jm(ouVar, i, bitmap2, size2, z5, null, oyVar, 3, i3, num2, num3, num4, num5, z2, z, list4, list5, list3, z3, z4, true), bitmap, nativeDocumentEditor, null, i2, num, null, list, list2, bool != null ? bool.booleanValue() : z3, false, 1636187);
    }
}
