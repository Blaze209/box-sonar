package com.microsoft.intune.mam.client.print;

import android.print.PrintAttributes;
import android.print.PrintDocumentAdapter;
import android.print.PrintJob;
import android.print.PrintManager;

/* JADX INFO: loaded from: classes3.dex */
public class OfflinePrintManagementBehavior implements PrintManagementBehavior {
    @Override // com.microsoft.intune.mam.client.print.PrintManagementBehavior
    public PrintJob print(PrintManager printManager, String str, PrintDocumentAdapter printDocumentAdapter, PrintAttributes printAttributes) {
        return printManager.print(str, printDocumentAdapter, printAttributes);
    }
}
