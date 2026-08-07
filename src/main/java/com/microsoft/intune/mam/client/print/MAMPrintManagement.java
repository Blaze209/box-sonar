package com.microsoft.intune.mam.client.print;

import android.print.PrintAttributes;
import android.print.PrintDocumentAdapter;
import android.print.PrintJob;
import android.print.PrintManager;
import com.microsoft.intune.mam.client.CachedBehaviorProvider;

/* JADX INFO: loaded from: classes3.dex */
public final class MAMPrintManagement {
    private static CachedBehaviorProvider<PrintManagementBehavior> sCachedBehavior = new CachedBehaviorProvider<>(PrintManagementBehavior.class);

    public static PrintJob print(PrintManager printManager, String str, PrintDocumentAdapter printDocumentAdapter, PrintAttributes printAttributes) {
        return getBehavior().print(printManager, str, printDocumentAdapter, printAttributes);
    }

    private static PrintManagementBehavior getBehavior() {
        return sCachedBehavior.get();
    }

    private MAMPrintManagement() {
    }
}
