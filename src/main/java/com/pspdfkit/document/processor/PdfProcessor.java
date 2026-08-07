package com.pspdfkit.document.processor;

import android.net.Uri;
import com.pspdfkit.document.DocumentPermissions;
import com.pspdfkit.document.DocumentSaveOptions;
import com.pspdfkit.document.DocumentSource;
import com.pspdfkit.document.PdfVersion;
import com.pspdfkit.exceptions.InvalidNutrientLicenseException;
import com.pspdfkit.internal.ar;
import com.pspdfkit.internal.jni.NativeDocumentSaveFlags;
import com.pspdfkit.internal.jni.NativeDocumentSaveOptions;
import com.pspdfkit.internal.jni.NativeLicenseFeatures;
import com.pspdfkit.internal.jni.NativeProcessor;
import com.pspdfkit.internal.jni.NativeProcessorDelegate;
import com.pspdfkit.internal.jni.NativeProcessorErrorType;
import com.pspdfkit.internal.jni.NativeResult;
import com.pspdfkit.internal.lm;
import com.pspdfkit.internal.pt;
import com.pspdfkit.internal.rr;
import com.pspdfkit.internal.sr;
import com.pspdfkit.utils.PdfLog;
import io.reactivex.rxjava3.core.BackpressureStrategy;
import io.reactivex.rxjava3.core.Flowable;
import io.reactivex.rxjava3.core.FlowableEmitter;
import io.reactivex.rxjava3.core.FlowableOnSubscribe;
import java.io.File;
import java.io.OutputStream;
import java.util.Collections;
import java.util.EnumSet;
import java.util.Iterator;
import java.util.List;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;

/* JADX INFO: loaded from: classes3.dex */
public final class PdfProcessor {
    private static final String LOG_TAG = "Nutri.PdfProcessor";

    public static final class ProcessorProgress {
        private final int pagesProcessed;
        private final int totalPages;

        public ProcessorProgress(int i, int i2) {
            this.pagesProcessed = i;
            this.totalPages = i2;
        }

        public int getPagesProcessed() {
            return this.pagesProcessed;
        }

        public int getTotalPages() {
            return this.totalPages;
        }

        public String toString() {
            return "ProcessorProgress{pagesProcessed=" + this.pagesProcessed + ", totalPages=" + this.totalPages + AbstractJsonLexerKt.END_OBJ;
        }
    }

    private PdfProcessor() {
    }

    private static void checkOutputFileDoesntOverwriteSource(PdfProcessorTask pdfProcessorTask, File file) {
        Uri uriFromFile = Uri.fromFile(file);
        lm lmVar = pdfProcessorTask.sourceDocument;
        if (lmVar != null) {
            List listUnmodifiableList = Collections.unmodifiableList(lmVar.A);
            listUnmodifiableList.getClass();
            Iterator it = listUnmodifiableList.iterator();
            while (it.hasNext()) {
                if (uriFromFile.equals(((DocumentSource) it.next()).getFileUri())) {
                    throw new IllegalStateException("outputFile can't point to the original input file.");
                }
            }
        }
    }

    private static DocumentSaveOptions createDefaultDocumentSaveOptions(PdfProcessorTask pdfProcessorTask) {
        lm lmVar = pdfProcessorTask.sourceDocument;
        return lmVar != null ? lmVar.a(true) : new DocumentSaveOptions(null, EnumSet.allOf(DocumentPermissions.class), true, PdfVersion.PDF_1_7);
    }

    public static void processDocument(PdfProcessorTask pdfProcessorTask, File file) throws PdfProcessorException {
        processDocument(pdfProcessorTask, file, createDefaultDocumentSaveOptions(pdfProcessorTask));
    }

    public static Flowable<ProcessorProgress> processDocumentAsync(PdfProcessorTask pdfProcessorTask, File file) {
        return processDocumentAsync(pdfProcessorTask, file, createDefaultDocumentSaveOptions(pdfProcessorTask));
    }

    public static void processDocument(PdfProcessorTask pdfProcessorTask, File file, DocumentSaveOptions documentSaveOptions) throws PdfProcessorException {
        if (!ar.b().a(NativeLicenseFeatures.PDF_CREATION)) {
            throw new InvalidNutrientLicenseException("Your current license does not allow creation of new PDF documents.");
        }
        if (pdfProcessorTask == null) {
            throw new IllegalArgumentException("Processor task must not be null!");
        }
        if (file == null) {
            throw new IllegalArgumentException("Output file must not be null!");
        }
        if (documentSaveOptions == null) {
            throw new IllegalArgumentException("Processor save options must not be null!");
        }
        checkOutputFileDoesntOverwriteSource(pdfProcessorTask, file);
        NativeResult nativeResultGenerateToFile = NativeProcessor.generateToFile(pdfProcessorTask.getProcessorConfiguration(), new NativeProcessorDelegate() { // from class: com.pspdfkit.document.processor.PdfProcessor.1
            @Override // com.pspdfkit.internal.jni.NativeProcessorDelegate
            public void completion(boolean z, String str) {
            }

            @Override // com.pspdfkit.internal.jni.NativeProcessorDelegate
            public void error(NativeProcessorErrorType nativeProcessorErrorType, String str) {
                PdfLog.w(PdfProcessor.LOG_TAG, "Error while processing document [" + nativeProcessorErrorType + "] " + str, new Object[0]);
            }

            @Override // com.pspdfkit.internal.jni.NativeProcessorDelegate
            public boolean isCanceled() {
                return false;
            }

            @Override // com.pspdfkit.internal.jni.NativeProcessorDelegate
            public void progress(int i, int i2) {
            }
        }, new NativeDocumentSaveOptions(sr.a(pdfProcessorTask.sourceDocument, documentSaveOptions), EnumSet.noneOf(NativeDocumentSaveFlags.class)), file.getAbsolutePath());
        if (nativeResultGenerateToFile.getHasError()) {
            throw new PdfProcessorException("Failed to process document: " + nativeResultGenerateToFile.getErrorString());
        }
    }

    public static Flowable<ProcessorProgress> processDocumentAsync(final PdfProcessorTask pdfProcessorTask, final File file, final DocumentSaveOptions documentSaveOptions) {
        if (!ar.b().a(NativeLicenseFeatures.PDF_CREATION)) {
            throw new InvalidNutrientLicenseException("Your current license does not allow creation of new PDF documents.");
        }
        if (pdfProcessorTask == null) {
            throw new IllegalArgumentException("Processor task must not be null!");
        }
        if (file == null) {
            throw new IllegalArgumentException("Output file must not be null!");
        }
        if (documentSaveOptions == null) {
            throw new IllegalArgumentException("Processor save options must not be null!");
        }
        checkOutputFileDoesntOverwriteSource(pdfProcessorTask, file);
        return Flowable.create(new FlowableOnSubscribe() { // from class: com.pspdfkit.document.processor.PdfProcessor$$ExternalSyntheticLambda1
            @Override // io.reactivex.rxjava3.core.FlowableOnSubscribe
            public final void subscribe(FlowableEmitter flowableEmitter) {
                PdfProcessorTask pdfProcessorTask2 = pdfProcessorTask;
                NativeProcessor.asyncGenerateToFile(pdfProcessorTask2.getProcessorConfiguration(), new rr(flowableEmitter), new NativeDocumentSaveOptions(sr.a(pdfProcessorTask2.sourceDocument, documentSaveOptions), EnumSet.noneOf(NativeDocumentSaveFlags.class)), file.getAbsolutePath());
            }
        }, BackpressureStrategy.MISSING);
    }

    public static Flowable<ProcessorProgress> processDocumentAsync(PdfProcessorTask pdfProcessorTask, OutputStream outputStream) {
        return processDocumentAsync(pdfProcessorTask, outputStream, createDefaultDocumentSaveOptions(pdfProcessorTask));
    }

    public static Flowable<ProcessorProgress> processDocumentAsync(final PdfProcessorTask pdfProcessorTask, final OutputStream outputStream, final DocumentSaveOptions documentSaveOptions) {
        if (!ar.b().a(NativeLicenseFeatures.PDF_CREATION)) {
            throw new InvalidNutrientLicenseException("Your current license does not allow creation of new PDF documents.");
        }
        if (outputStream == null) {
            throw new IllegalArgumentException("Output stream must not be null!");
        }
        if (pdfProcessorTask == null) {
            throw new IllegalArgumentException("Processor task must not be null!");
        }
        if (documentSaveOptions != null) {
            return Flowable.create(new FlowableOnSubscribe() { // from class: com.pspdfkit.document.processor.PdfProcessor$$ExternalSyntheticLambda0
                @Override // io.reactivex.rxjava3.core.FlowableOnSubscribe
                public final void subscribe(FlowableEmitter flowableEmitter) {
                    PdfProcessorTask pdfProcessorTask2 = pdfProcessorTask;
                    NativeProcessor.asyncGenerateToDataSink(pdfProcessorTask2.getProcessorConfiguration(), new rr(flowableEmitter), new NativeDocumentSaveOptions(sr.a(pdfProcessorTask2.sourceDocument, documentSaveOptions), EnumSet.noneOf(NativeDocumentSaveFlags.class)), new pt(outputStream));
                }
            }, BackpressureStrategy.MISSING);
        }
        throw new IllegalArgumentException("Processor save options must not be null!");
    }
}
