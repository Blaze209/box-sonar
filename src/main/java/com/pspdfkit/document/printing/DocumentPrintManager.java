package com.pspdfkit.document.printing;

import android.content.ComponentName;
import android.content.Context;
import android.content.pm.PackageManager;
import android.print.PrintManager;
import com.microsoft.intune.mam.client.content.pm.MAMPackageManagement;
import com.microsoft.intune.mam.client.print.MAMPrintManagement;
import com.pspdfkit.analytics.Analytics;
import com.pspdfkit.configuration.activity.PdfActivityConfiguration;
import com.pspdfkit.document.DocumentPermissions;
import com.pspdfkit.document.PdfDocument;
import com.pspdfkit.document.processor.PdfProcessorTask;
import com.pspdfkit.internal.lm;
import com.pspdfkit.internal.ww;
import com.pspdfkit.internal.yw;

/* JADX INFO: loaded from: classes3.dex */
public class DocumentPrintManager {
    static DocumentPrintManager instance = new DocumentPrintManager();

    public static DocumentPrintManager get() {
        return instance;
    }

    private boolean hasPrintActivity(Context context) {
        try {
            MAMPackageManagement.getActivityInfo(context.getPackageManager(), new ComponentName(context, (Class<?>) PrintActivity.class), 0);
            return true;
        } catch (PackageManager.NameNotFoundException unused) {
            return false;
        }
    }

    public String getPrintJobName(Context context, PdfDocument pdfDocument) {
        return ww.a(context, pdfDocument) + ".pdf";
    }

    public boolean hasPrintPermission(PdfDocument pdfDocument) {
        return pdfDocument.hasPermission(DocumentPermissions.PRINT_HIGH_QUALITY) || pdfDocument.hasPermission(DocumentPermissions.PRINTING);
    }

    public boolean isPrintingAvailable(PdfActivityConfiguration pdfActivityConfiguration) {
        return pdfActivityConfiguration.isPrintingEnabled();
    }

    public boolean isPrintingEnabled(PdfActivityConfiguration pdfActivityConfiguration, PdfDocument pdfDocument) {
        return isPrintingAvailable(pdfActivityConfiguration) && hasPrintPermission(pdfDocument);
    }

    public void print(Context context, PdfDocument pdfDocument) {
        print(context, pdfDocument, null, null);
    }

    public void startPrintJob(Context context, PdfDocument pdfDocument, PrintOptions printOptions, PdfProcessorTask pdfProcessorTask, yw.b bVar) {
        PrintManager printManager = (PrintManager) context.getSystemService(Analytics.Event.PRINT);
        if (printManager == null) {
            throw new IllegalStateException("System PrintManager could not be retrieved from system services.");
        }
        String printJobName = getPrintJobName(context, pdfDocument);
        yw ywVar = new yw(context, (lm) pdfDocument, printOptions, pdfProcessorTask, bVar);
        if (MAMPrintManagement.print(printManager, printJobName, ywVar, null) == null) {
            ywVar.onFinish();
        }
    }

    public void print(Context context, PdfDocument pdfDocument, PrintOptions printOptions) {
        print(context, pdfDocument, printOptions, null);
    }

    public void print(Context context, PdfDocument pdfDocument, PdfProcessorTask pdfProcessorTask) {
        print(context, pdfDocument, null, pdfProcessorTask);
    }

    private void print(Context context, PdfDocument pdfDocument, PrintOptions printOptions, PdfProcessorTask pdfProcessorTask) {
        if (!pdfDocument.hasPermission(DocumentPermissions.PRINT_HIGH_QUALITY) && !pdfDocument.hasPermission(DocumentPermissions.PRINTING)) {
            throw new IllegalStateException("Can't print documents without print permissions!");
        }
        if (hasPrintActivity(context)) {
            context.startActivity(PrintActivity.getStartIntent(context, pdfDocument, printOptions, pdfProcessorTask));
        } else {
            startPrintJob(context, pdfDocument, printOptions, pdfProcessorTask, null);
        }
    }
}
