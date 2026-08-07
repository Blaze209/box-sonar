package com.pspdfkit.document.sharing;

import android.content.Context;
import android.graphics.Bitmap;
import android.net.Uri;
import android.text.TextUtils;
import com.facebook.cache.disk.DefaultDiskStorage;
import com.pspdfkit.annotations.Annotation;
import com.pspdfkit.annotations.SoundAnnotation;
import com.pspdfkit.annotations.sound.WavWriter;
import com.pspdfkit.document.DocumentSource;
import com.pspdfkit.document.PdfDocument;
import com.pspdfkit.document.files.EmbeddedFile;
import com.pspdfkit.document.processor.PdfProcessor;
import com.pspdfkit.document.processor.PdfProcessorTask;
import com.pspdfkit.document.providers.DataProvider;
import com.pspdfkit.instant.document.InstantPdfDocument;
import com.pspdfkit.internal.uw;
import com.pspdfkit.internal.wg;
import com.pspdfkit.internal.ww;
import com.pspdfkit.internal.zj;
import io.reactivex.rxjava3.core.Single;
import io.reactivex.rxjava3.core.SingleSource;
import io.reactivex.rxjava3.functions.Consumer;
import io.reactivex.rxjava3.functions.Supplier;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

/* JADX INFO: loaded from: classes3.dex */
public class DocumentSharingProviderProcessor {
    private static final String EXT_PDF = ".pdf";
    private static final String EXT_WAV = ".wav";

    public interface PdfProcessorProgressListener {
        void onProcessorProgress(PdfProcessor.ProcessorProgress processorProgress);
    }

    private static File getOutputFile(Context context, String str, String str2) throws IOException {
        File sharedFileDirectory = DocumentSharingProvider.getSharedFileDirectory(context);
        sharedFileDirectory.mkdirs();
        File fileCreateTempFile = File.createTempFile(str, str2, sharedFileDirectory);
        fileCreateTempFile.delete();
        return fileCreateTempFile;
    }

    static /* synthetic */ SingleSource lambda$prepareBitmapForSharing$5(String str, Context context, Bitmap.CompressFormat compressFormat, Bitmap bitmap, int i) throws Throwable {
        String str2;
        File outputFile;
        if (str != null) {
            outputFile = getOutputFile(context, str);
        } else {
            if (compressFormat == Bitmap.CompressFormat.PNG) {
                str2 = ".png";
            } else {
                str2 = compressFormat == Bitmap.CompressFormat.WEBP ? ".webp" : ".jpg";
            }
            outputFile = getOutputFile(context, "bitmap_", str2);
        }
        bitmap.compress(compressFormat, i, new BufferedOutputStream(new FileOutputStream(outputFile)));
        return Single.just(DocumentSharingProvider.getUriForFile(context, outputFile));
    }

    static /* synthetic */ void lambda$prepareDocumentForSharing$0(PdfProcessorProgressListener pdfProcessorProgressListener, PdfProcessor.ProcessorProgress processorProgress) throws Throwable {
        if (pdfProcessorProgressListener != null) {
            pdfProcessorProgressListener.onProcessorProgress(processorProgress);
        }
    }

    static /* synthetic */ SingleSource lambda$prepareDocumentForSharing$2(final Context context, String str, PdfDocument pdfDocument, PdfProcessorTask pdfProcessorTask, final PdfProcessorProgressListener pdfProcessorProgressListener) throws Throwable {
        final File outputFile = getOutputFile(context, TextUtils.isEmpty(str) ? ww.a(context, pdfDocument) + EXT_PDF : str + EXT_PDF);
        return PdfProcessor.processDocumentAsync(pdfProcessorTask, outputFile).onBackpressureDrop().doOnNext(new Consumer() { // from class: com.pspdfkit.document.sharing.DocumentSharingProviderProcessor$$ExternalSyntheticLambda1
            @Override // io.reactivex.rxjava3.functions.Consumer
            public final void accept(Object obj) throws Throwable {
                DocumentSharingProviderProcessor.lambda$prepareDocumentForSharing$0(pdfProcessorProgressListener, (PdfProcessor.ProcessorProgress) obj);
            }
        }).ignoreElements().toSingle(new Supplier() { // from class: com.pspdfkit.document.sharing.DocumentSharingProviderProcessor$$ExternalSyntheticLambda2
            @Override // io.reactivex.rxjava3.functions.Supplier
            public final Object get() {
                return DocumentSharingProvider.getUriForFile(context, outputFile);
            }
        });
    }

    static /* synthetic */ SingleSource lambda$prepareDocumentForSharing$3(Context context, String str, PdfDocument pdfDocument) throws Throwable {
        File outputFile = getOutputFile(context, TextUtils.isEmpty(str) ? ww.a(context, pdfDocument) + EXT_PDF : str + EXT_PDF);
        if (pdfDocument.wasModified() || pdfDocument.getDocumentSources().size() != 1) {
            pdfDocument.save(outputFile.getAbsolutePath());
        } else {
            FileOutputStream fileOutputStream = new FileOutputStream(outputFile);
            try {
                DocumentSource documentSource = pdfDocument.getDocumentSource();
                if (documentSource.getFileUri() != null) {
                    wg.a(wg.b(context, documentSource.getFileUri()), fileOutputStream);
                } else {
                    if (documentSource.getDataProvider() == null) {
                        throw new IllegalArgumentException("Illegal document provided");
                    }
                    wg.a(documentSource.getDataProvider(), fileOutputStream);
                }
                fileOutputStream.close();
            } catch (Throwable th) {
                try {
                    fileOutputStream.close();
                } catch (Throwable th2) {
                    th.addSuppressed(th2);
                }
                throw th;
            }
        }
        return Single.just(DocumentSharingProvider.getUriForFile(context, outputFile));
    }

    static /* synthetic */ SingleSource lambda$prepareEmbeddedFileForSharing$4(Context context, EmbeddedFile embeddedFile) throws Throwable {
        File outputFile = getOutputFile(context, embeddedFile.getFileName());
        embeddedFile.a(new BufferedOutputStream(new FileOutputStream(outputFile)));
        return Single.just(DocumentSharingProvider.getUriForFile(context, outputFile));
    }

    static /* synthetic */ SingleSource lambda$prepareFileForSharing$6(String str, Context context, DataProvider dataProvider) throws Throwable {
        File outputFile = str != null ? getOutputFile(context, str) : getOutputFile(context, "file_", DefaultDiskStorage.FileType.TEMP);
        BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(outputFile));
        try {
            wg.a(dataProvider, bufferedOutputStream);
            bufferedOutputStream.close();
            return Single.just(DocumentSharingProvider.getUriForFile(context, outputFile));
        } catch (Throwable th) {
            try {
                bufferedOutputStream.close();
            } catch (Throwable th2) {
                th.addSuppressed(th2);
            }
            throw th;
        }
    }

    static SingleSource lambda$prepareSoundAnnotationForSharing$7(String str, Context context, SoundAnnotation soundAnnotation) throws Throwable {
        File outputFile;
        if (str != null) {
            outputFile = getOutputFile(context, str);
        } else if (soundAnnotation.getContents() != null) {
            float f = ww.a;
            context.getClass();
            outputFile = getOutputFile(context, ww.a(context, (Annotation) soundAnnotation, true).concat(EXT_WAV));
        } else {
            outputFile = getOutputFile(context, "sound_", EXT_WAV);
        }
        BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(outputFile));
        try {
            WavWriter.forAnnotation(soundAnnotation).writeToStream(bufferedOutputStream);
            bufferedOutputStream.close();
            return Single.just(DocumentSharingProvider.getUriForFile(context, outputFile));
        } catch (Throwable th) {
            try {
                bufferedOutputStream.close();
            } catch (Throwable th2) {
                th.addSuppressed(th2);
            }
            throw th;
        }
    }

    public static Single<Uri> prepareBitmapForSharing(Context context, Bitmap bitmap) {
        uw.a(context, "context", null);
        uw.a(bitmap, "bitmap", null);
        return prepareBitmapForSharing(context, bitmap, bitmap.hasAlpha() ? Bitmap.CompressFormat.PNG : Bitmap.CompressFormat.JPEG, 99, null);
    }

    public static Single<Uri> prepareDocumentForSharing(final Context context, final PdfDocument pdfDocument, final PdfProcessorTask pdfProcessorTask, final String str, final PdfProcessorProgressListener pdfProcessorProgressListener) {
        uw.a(context, "context", null);
        uw.a(pdfDocument, "document", null);
        uw.a(pdfProcessorTask, "processorTask", null);
        DocumentSharingProvider.checkProviderConfiguration(context);
        return Single.defer(new Supplier() { // from class: com.pspdfkit.document.sharing.DocumentSharingProviderProcessor$$ExternalSyntheticLambda0
            @Override // io.reactivex.rxjava3.functions.Supplier
            public final Object get() {
                return DocumentSharingProviderProcessor.lambda$prepareDocumentForSharing$2(context, str, pdfDocument, pdfProcessorTask, pdfProcessorProgressListener);
            }
        });
    }

    public static Single<Uri> prepareEmbeddedFileForSharing(final Context context, final EmbeddedFile embeddedFile) {
        uw.a(context, "context", null);
        uw.a(embeddedFile, "embeddedFile", null);
        DocumentSharingProvider.checkProviderConfiguration(context);
        return Single.defer(new Supplier() { // from class: com.pspdfkit.document.sharing.DocumentSharingProviderProcessor$$ExternalSyntheticLambda7
            @Override // io.reactivex.rxjava3.functions.Supplier
            public final Object get() {
                return DocumentSharingProviderProcessor.lambda$prepareEmbeddedFileForSharing$4(context, embeddedFile);
            }
        });
    }

    public static Single<Uri> prepareFileForSharing(final Context context, final DataProvider dataProvider, final String str) {
        uw.a(context, "context", null);
        uw.a(dataProvider, "fileDataProvider", null);
        DocumentSharingProvider.checkProviderConfiguration(context);
        return Single.defer(new Supplier() { // from class: com.pspdfkit.document.sharing.DocumentSharingProviderProcessor$$ExternalSyntheticLambda3
            @Override // io.reactivex.rxjava3.functions.Supplier
            public final Object get() {
                return DocumentSharingProviderProcessor.lambda$prepareFileForSharing$6(str, context, dataProvider);
            }
        });
    }

    public static Single<Uri> prepareSoundAnnotationForSharing(final Context context, final SoundAnnotation soundAnnotation, final String str) {
        uw.a(context, "context", null);
        uw.a(soundAnnotation, "soundAnnotation", null);
        DocumentSharingProvider.checkProviderConfiguration(context);
        return Single.defer(new Supplier() { // from class: com.pspdfkit.document.sharing.DocumentSharingProviderProcessor$$ExternalSyntheticLambda4
            @Override // io.reactivex.rxjava3.functions.Supplier
            public final Object get() {
                return DocumentSharingProviderProcessor.lambda$prepareSoundAnnotationForSharing$7(str, context, soundAnnotation);
            }
        });
    }

    public static boolean soundAnnotationSupportsSharing(SoundAnnotation soundAnnotation) {
        return soundAnnotation.hasAudioData() && WavWriter.soundAnnotationSupportsWavExport(soundAnnotation);
    }

    public static Single<Uri> prepareBitmapForSharing(final Context context, final Bitmap bitmap, final Bitmap.CompressFormat compressFormat, final int i, final String str) {
        uw.a(context, "context", null);
        uw.a(bitmap, "bitmap", null);
        uw.a(compressFormat, "compressFormat", null);
        DocumentSharingProvider.checkProviderConfiguration(context);
        return Single.defer(new Supplier() { // from class: com.pspdfkit.document.sharing.DocumentSharingProviderProcessor$$ExternalSyntheticLambda5
            @Override // io.reactivex.rxjava3.functions.Supplier
            public final Object get() {
                return DocumentSharingProviderProcessor.lambda$prepareBitmapForSharing$5(str, context, compressFormat, bitmap, i);
            }
        });
    }

    public static Single<Uri> prepareSoundAnnotationForSharing(Context context, SoundAnnotation soundAnnotation) {
        return prepareSoundAnnotationForSharing(context, soundAnnotation, null);
    }

    public static Single<Uri> prepareDocumentForSharing(final Context context, final PdfDocument pdfDocument, final String str) {
        uw.a(context, "context", null);
        uw.a(pdfDocument, "document", null);
        DocumentSharingProvider.checkProviderConfiguration(context);
        if (!(pdfDocument instanceof zj.a) && !(pdfDocument instanceof InstantPdfDocument)) {
            return Single.defer(new Supplier() { // from class: com.pspdfkit.document.sharing.DocumentSharingProviderProcessor$$ExternalSyntheticLambda6
                @Override // io.reactivex.rxjava3.functions.Supplier
                public final Object get() {
                    return DocumentSharingProviderProcessor.lambda$prepareDocumentForSharing$3(context, str, pdfDocument);
                }
            });
        }
        return prepareDocumentForSharing(context, pdfDocument, PdfProcessorTask.fromDocument(pdfDocument), str);
    }

    private static File getOutputFile(Context context, String str) {
        String strReplaceAll = str.replaceAll("[:\\\\/*\"?|<>']", "");
        File sharedFileDirectory = DocumentSharingProvider.getSharedFileDirectory(context);
        sharedFileDirectory.mkdirs();
        File file = new File(sharedFileDirectory, strReplaceAll);
        file.delete();
        return file;
    }

    public static Single<Uri> prepareDocumentForSharing(Context context, PdfDocument pdfDocument, PdfProcessorTask pdfProcessorTask, String str) {
        return prepareDocumentForSharing(context, pdfDocument, pdfProcessorTask, str, null);
    }
}
