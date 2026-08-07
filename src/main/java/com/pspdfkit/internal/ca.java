package com.pspdfkit.internal;

import com.pspdfkit.annotations.AnnotationType;
import com.pspdfkit.configuration.PdfConfiguration;
import com.pspdfkit.configuration.rendering.PageRenderConfiguration;
import com.pspdfkit.document.PdfDocument;
import com.pspdfkit.exceptions.NutrientException;
import com.pspdfkit.internal.jni.NativeLicenseFeatures;
import java.util.ArrayList;
import java.util.Collection;
import java.util.EnumSet;

/* JADX INFO: loaded from: classes3.dex */
public final class ca {
    public static w4 a;
    public static ci b;

    public static EnumSet<AnnotationType> a(PdfConfiguration pdfConfiguration) {
        ArrayList arrayList = new ArrayList(pdfConfiguration.getExcludedAnnotationTypes());
        if (!ar.b().a(NativeLicenseFeatures.REDACTION)) {
            arrayList.add(AnnotationType.REDACT);
        }
        return arrayList.isEmpty() ? EnumSet.noneOf(AnnotationType.class) : EnumSet.copyOf((Collection) arrayList);
    }

    public static PageRenderConfiguration a(PdfConfiguration pdfConfiguration, PdfDocument pdfDocument) {
        int i;
        int i2;
        int i3;
        Integer numValueOf;
        PageRenderConfiguration.Builder builderPaperColor = new PageRenderConfiguration.Builder().paperColor(pdfConfiguration.getBackgroundColor());
        if (ar.b().b(pdfConfiguration, pdfDocument)) {
            ci ciVar = b;
            if (ciVar != null) {
                i = ciVar.a;
            } else {
                throw new NutrientException("Make sure to call ConfigurationUtils#parseThemeConfigurations() before calling getFormSelectionThemeConfiguration()");
            }
        } else {
            i = 0;
        }
        PageRenderConfiguration.Builder builderFormHighlightColor = builderPaperColor.formHighlightColor(i);
        if (ar.b().b(pdfConfiguration, pdfDocument)) {
            ci ciVar2 = b;
            if (ciVar2 != null) {
                i2 = ciVar2.f;
            } else {
                throw new NutrientException("Make sure to call ConfigurationUtils#parseThemeConfigurations() before calling getFormSelectionThemeConfiguration()");
            }
        } else {
            i2 = 0;
        }
        PageRenderConfiguration.Builder builderFormRequiredFieldBorderColor = builderFormHighlightColor.formRequiredFieldBorderColor(i2);
        if (ar.b().b(pdfConfiguration, pdfDocument)) {
            ci ciVar3 = b;
            if (ciVar3 != null) {
                i3 = ciVar3.g;
            } else {
                throw new NutrientException("Make sure to call ConfigurationUtils#parseThemeConfigurations() before calling getFormSelectionThemeConfiguration()");
            }
        } else {
            i3 = 0;
        }
        PageRenderConfiguration.Builder builderShowSignHereOverlay = builderFormRequiredFieldBorderColor.signHereOverlayBackgroundColor(Integer.valueOf(i3)).toGrayscale(pdfConfiguration.isToGrayscale()).invertColors(pdfConfiguration.isInvertColors()).showSignHereOverlay(pdfConfiguration.getShowSignHereOverlay());
        if (!ar.b().a(NativeLicenseFeatures.ACRO_FORMS)) {
            numValueOf = 0;
        } else {
            ci ciVar4 = b;
            if (ciVar4 != null) {
                int i4 = ciVar4.b;
                numValueOf = i4 == 0 ? null : Integer.valueOf(i4);
            } else {
                throw new NutrientException("Make sure to call ConfigurationUtils#parseThemeConfigurations() before calling getFormSelectionThemeConfiguration()");
            }
        }
        if (numValueOf != null) {
            builderShowSignHereOverlay.formItemHighlightColor(numValueOf.intValue());
        }
        return builderShowSignHereOverlay.build();
    }
}
