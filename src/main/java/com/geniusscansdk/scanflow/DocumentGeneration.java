package com.geniusscansdk.scanflow;

import com.geniusscansdk.core.GeniusScanSDK;
import com.geniusscansdk.core.LicenseException;
import com.geniusscansdk.core.ProcessingException;
import com.geniusscansdk.pdf.DocumentGenerator;
import com.geniusscansdk.pdf.PDFDocument;
import com.geniusscansdk.pdf.PDFImageProcessor;
import com.geniusscansdk.pdf.PDFPage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

/* JADX INFO: loaded from: classes13.dex */
class DocumentGeneration {
    private final DocumentGenerator documentGenerator;
    private final ImageStore imageStore;
    private final ProgressListener progressListener;

    interface ProgressListener {
        void onProgressUpdate(int i);
    }

    public DocumentGeneration(ImageStore imageStore, DocumentGenerator documentGenerator, ProgressListener progressListener) {
        this.imageStore = imageStore;
        this.documentGenerator = documentGenerator;
        this.progressListener = progressListener;
    }

    public File generateDocument(List<Page> list, File file, ScanConfiguration scanConfiguration) throws IOException, DocumentGenerator.Exception {
        ScanConfiguration.MultiPageFormat multiPageFormat = scanConfiguration.multiPageFormat;
        if (multiPageFormat == ScanConfiguration.MultiPageFormat.NONE) {
            return null;
        }
        File file2 = new File(file, UUID.randomUUID().toString() + (multiPageFormat == ScanConfiguration.MultiPageFormat.PDF ? ".pdf" : ".tiff"));
        ScanConfiguration.OcrConfiguration ocrConfiguration = scanConfiguration.ocrConfiguration;
        boolean z = ocrConfiguration != null && ocrConfiguration.outputFormats.contains(ScanConfiguration.OcrOutputFormat.TEXT_LAYER_IN_PDF);
        ArrayList arrayList = new ArrayList();
        for (Page page : list) {
            arrayList.add(new PDFPage(page.getEnhancedImage(), scanConfiguration.pdfPageSize.toPDFSize(), (!z || page.getOcrResult() == null) ? null : page.getOcrResult().textLayout));
            this.progressListener.onProgressUpdate((arrayList.size() * 100) / list.size());
        }
        PDFDocument pDFDocument = new PDFDocument(arrayList, null, null, null, new Date(), new Date());
        ImageResizer imageResizer = new ImageResizer(scanConfiguration.pdfMaxScanDimension);
        if (multiPageFormat == ScanConfiguration.MultiPageFormat.PDF) {
            this.documentGenerator.generatePDFDocument(pDFDocument, new DocumentGenerator.Configuration(file2, scanConfiguration.pdfFontFile), imageResizer);
            return file2;
        }
        this.documentGenerator.generateTIFFDocument(pDFDocument, file2);
        return file2;
    }

    private class ImageResizer implements PDFImageProcessor {
        private final int maxPageDimension;

        ImageResizer(int i) {
            this.maxPageDimension = i;
        }

        @Override // com.geniusscansdk.pdf.PDFImageProcessor
        public File process(File file) {
            if (this.maxPageDimension == 0) {
                return file;
            }
            String path = file.getPath();
            File temporaryPdfImageFile = DocumentGeneration.this.imageStore.getTemporaryPdfImageFile(path.substring(path.lastIndexOf(".")));
            try {
                GeniusScanSDK.scaleImage(path, temporaryPdfImageFile.getAbsolutePath(), this.maxPageDimension);
                return temporaryPdfImageFile;
            } catch (LicenseException | ProcessingException | IOException unused) {
                return null;
            }
        }
    }
}
