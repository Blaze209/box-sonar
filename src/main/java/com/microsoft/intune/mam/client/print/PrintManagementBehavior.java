package com.microsoft.intune.mam.client.print;

import android.print.PrintAttributes;
import android.print.PrintDocumentAdapter;
import android.print.PrintJob;
import android.print.PrintManager;

/* JADX INFO: loaded from: classes3.dex */
public interface PrintManagementBehavior {
    PrintJob print(PrintManager printManager, String str, PrintDocumentAdapter printDocumentAdapter, PrintAttributes printAttributes);
}
