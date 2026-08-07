package com.pspdfkit.document.printing;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.print.PrintManager;
import com.microsoft.intune.mam.client.app.MAMActivity;
import com.pspdfkit.analytics.Analytics;
import com.pspdfkit.document.PdfDocument;
import com.pspdfkit.document.processor.PdfProcessorTask;
import com.pspdfkit.internal.q70;
import com.pspdfkit.internal.uw;
import com.pspdfkit.internal.yw;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

/* JADX INFO: loaded from: classes3.dex */
public class PrintActivity extends MAMActivity {
    private static final String PRINT_JOB_COMMAND_UID = "Nutrient.PrintActivity.PrintJobCommandUID";
    private static final Map<String, PrintCommand> pendingPrintCommands = new HashMap();

    public static class PrintCommand {
        final PdfDocument document;
        final PrintOptions printOptions;
        final PdfProcessorTask processorTask;

        public PrintCommand(PdfDocument pdfDocument, PrintOptions printOptions, PdfProcessorTask pdfProcessorTask) {
            this.document = pdfDocument;
            this.printOptions = printOptions;
            this.processorTask = pdfProcessorTask;
        }
    }

    public static Intent getStartIntent(Context context, PdfDocument pdfDocument, PrintOptions printOptions, PdfProcessorTask pdfProcessorTask) {
        uw.a(context, "context", null);
        uw.a(pdfDocument, "document", null);
        q70.a();
        String string = UUID.randomUUID().toString();
        string.getClass();
        pendingPrintCommands.put(string, new PrintCommand(pdfDocument, printOptions, pdfProcessorTask));
        Intent intent = new Intent(context, (Class<?>) PrintActivity.class);
        intent.putExtra(PRINT_JOB_COMMAND_UID, string);
        intent.addFlags(8388608);
        return intent;
    }

    @Override // com.microsoft.intune.mam.client.app.MAMActivity, com.microsoft.intune.mam.client.app.HookedActivity
    public void onMAMCreate(Bundle bundle) {
        super.onMAMCreate(bundle);
        PrintManager printManager = (PrintManager) getSystemService(Analytics.Event.PRINT);
        PrintCommand printCommandRemove = pendingPrintCommands.remove(getIntent().getStringExtra(PRINT_JOB_COMMAND_UID));
        if (printManager == null || printCommandRemove == null) {
            finish();
        } else {
            DocumentPrintManager.get().startPrintJob(this, printCommandRemove.document, printCommandRemove.printOptions, printCommandRemove.processorTask, new yw.b() { // from class: com.pspdfkit.document.printing.PrintActivity$$ExternalSyntheticLambda0
                @Override // com.pspdfkit.internal.yw.b
                public final void a() {
                    this.f$0.finish();
                }
            });
        }
    }
}
