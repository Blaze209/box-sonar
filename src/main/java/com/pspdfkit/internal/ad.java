package com.pspdfkit.internal;

import android.content.Context;
import android.graphics.Matrix;
import android.net.Uri;
import com.pspdfkit.annotations.BlendMode;
import com.pspdfkit.document.PdfDocument;
import com.pspdfkit.document.PdfDocumentLoader;
import com.pspdfkit.document.processor.ComparisonDocument;
import com.pspdfkit.document.processor.PagePdf;
import com.pspdfkit.document.processor.PdfProcessor;
import com.pspdfkit.document.processor.PdfProcessorTask;
import java.io.File;
import java.io.IOException;

/* JADX INFO: loaded from: classes3.dex */
public final class ad {
    public static Uri a(Context context, ComparisonDocument comparisonDocument, String str) throws IOException {
        context.getClass();
        comparisonDocument.getClass();
        str.getClass();
        File file = new File(context.getFilesDir(), str + ".pdf");
        PdfDocument pdfDocumentOpenDocument = PdfDocumentLoader.openDocument(context, comparisonDocument.getDocumentSource());
        pdfDocumentOpenDocument.getClass();
        PdfProcessorTask pdfProcessorTaskChangeStrokeColorOnPage = PdfProcessorTask.fromDocument(pdfDocumentOpenDocument).changeStrokeColorOnPage(comparisonDocument.getPageIndex(), comparisonDocument.getLineColor());
        pdfProcessorTaskChangeStrokeColorOnPage.getClass();
        PdfProcessor.processDocument(pdfProcessorTaskChangeStrokeColorOnPage, file);
        Uri uriFromFile = Uri.fromFile(file);
        uriFromFile.getClass();
        return uriFromFile;
    }

    public static Uri a(Context context, Uri uri, int i, Uri uri2, int i2, String str, Matrix matrix, BlendMode blendMode) throws IOException {
        context.getClass();
        uri.getClass();
        uri2.getClass();
        str.getClass();
        matrix.getClass();
        blendMode.getClass();
        File file = new File(context.getFilesDir(), str + ".pdf");
        PdfDocument pdfDocumentOpenDocument = PdfDocumentLoader.openDocument(context, uri);
        pdfDocumentOpenDocument.getClass();
        PdfProcessorTask pdfProcessorTaskMergePage = PdfProcessorTask.fromDocument(pdfDocumentOpenDocument).mergePage(new PagePdf(context, uri2, i2, matrix), i, blendMode);
        pdfProcessorTaskMergePage.getClass();
        PdfProcessor.processDocument(pdfProcessorTaskMergePage, file);
        Uri uriFromFile = Uri.fromFile(file);
        uriFromFile.getClass();
        return uriFromFile;
    }
}
