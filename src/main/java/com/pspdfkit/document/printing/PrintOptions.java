package com.pspdfkit.document.printing;

import com.pspdfkit.datastructures.Range;
import com.pspdfkit.document.processor.PdfProcessorTask;
import com.pspdfkit.document.sharing.SharingOptions;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public class PrintOptions extends SharingOptions {
    public PrintOptions(boolean z) {
        super(getProcessingMode(z));
    }

    private static PdfProcessorTask.AnnotationProcessingMode getProcessingMode(boolean z) {
        return z ? PdfProcessorTask.AnnotationProcessingMode.PRINT : PdfProcessorTask.AnnotationProcessingMode.DELETE;
    }

    public PrintOptions(boolean z, List<Range> list) {
        super(getProcessingMode(z), list);
    }

    public PrintOptions(String str) {
        super(str);
    }

    public PrintOptions(boolean z, List<Range> list, String str) {
        super(getProcessingMode(z), list, str);
    }

    public PrintOptions(SharingOptions sharingOptions) {
        super(sharingOptions);
    }
}
