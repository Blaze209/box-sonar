package com.geniusscansdk.pdf;

import io.opentelemetry.semconv.trace.attributes.SemanticAttributes;
import java.io.File;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: PDFImageProcessor.kt */
/* JADX INFO: loaded from: classes13.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0005H\u0016¨\u0006\u0007"}, d2 = {"Lcom/geniusscansdk/pdf/NoopImageProcessor;", "Lcom/geniusscansdk/pdf/PDFImageProcessor;", "<init>", "()V", SemanticAttributes.MessagingOperationValues.PROCESS, "Ljava/io/File;", "imageFile", "gssdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class NoopImageProcessor implements PDFImageProcessor {
    @Override // com.geniusscansdk.pdf.PDFImageProcessor
    public File process(File imageFile) {
        Intrinsics.checkNotNullParameter(imageFile, "imageFile");
        return imageFile;
    }
}
