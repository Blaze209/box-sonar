package com.geniusscansdk.pdf;

import java.io.File;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: PDFImageProcessor.kt */
/* JADX INFO: loaded from: classes13.dex */
@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u001a\f\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u0000¨\u0006\u0003"}, d2 = {"toJNI", "Lcom/geniusscansdk/pdf/JNIPDFImageProcessor;", "Lcom/geniusscansdk/pdf/PDFImageProcessor;", "gssdk_release"}, k = 2, mv = {2, 1, 0}, xi = 48)
public final class PDFImageProcessorKt {
    public static final JNIPDFImageProcessor toJNI(final PDFImageProcessor pDFImageProcessor) {
        Intrinsics.checkNotNullParameter(pDFImageProcessor, "<this>");
        return new JNIPDFImageProcessor() { // from class: com.geniusscansdk.pdf.PDFImageProcessorKt.toJNI.1
            @Override // com.geniusscansdk.pdf.JNIPDFImageProcessor
            public String process(String inputFilePath) {
                Intrinsics.checkNotNullParameter(inputFilePath, "inputFilePath");
                File fileProcess = pDFImageProcessor.process(new File(inputFilePath));
                if (fileProcess != null) {
                    return fileProcess.getPath();
                }
                return null;
            }

            @Override // com.geniusscansdk.pdf.JNIPDFImageProcessor
            public JNIPDFImageData processBuffer(JNIPDFImageData imageData) {
                Intrinsics.checkNotNullParameter(imageData, "imageData");
                throw new UnsupportedOperationException();
            }
        };
    }
}
