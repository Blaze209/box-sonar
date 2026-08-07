package com.pspdfkit.document.metadata;

import com.pspdfkit.document.PdfValue;

/* JADX INFO: loaded from: classes3.dex */
public interface DocumentXmpMetadata {
    public static final String XMP_DC_NAMESPACE = "http://purl.org/dc/elements/1.1/";
    public static final String XMP_DC_NAMESPACE_PREFIX = "dc";
    public static final String XMP_PDF_NAMESPACE = "http://ns.adobe.com/pdf/1.3/";
    public static final String XMP_PDF_NAMESPACE_PREFIX = "pdf";

    PdfValue get(String str, String str2);

    boolean hasUnsavedChanges();

    void set(String str, String str2, String str3, String str4);
}
