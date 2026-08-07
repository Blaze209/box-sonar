package com.pspdfkit.ui.dialog;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.FragmentManager;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.pspdfkit.R;
import com.pspdfkit.document.printing.PrintOptions;
import com.pspdfkit.document.processor.PdfProcessorTask;
import com.pspdfkit.internal.a80;
import com.pspdfkit.internal.no;
import com.pspdfkit.internal.qe;
import com.pspdfkit.internal.uw;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes3.dex */
public final class DocumentPrintDialog extends BaseDocumentPrintDialog {
    static final String FRAGMENT_TAG = "com.pspdfkit.ui.dialog.DocumentPrintDialog.FRAGMENT_TAG";
    private qe shareDialogLayout;

    public interface PrintDialogListener {
        void onAccept(PrintOptions printOptions);

        void onDismiss();
    }

    private static BaseDocumentPrintDialog getInstance(FragmentManager fragmentManager) {
        return getInstance(fragmentManager, null);
    }

    public static void hide(FragmentManager fragmentManager) {
        if (isVisible(fragmentManager)) {
            getInstance(fragmentManager).dismiss();
        }
    }

    public static boolean isVisible(FragmentManager fragmentManager) {
        BaseDocumentPrintDialog baseDocumentPrintDialog = (BaseDocumentPrintDialog) fragmentManager.findFragmentByTag(FRAGMENT_TAG);
        return baseDocumentPrintDialog != null && baseDocumentPrintDialog.isAdded();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onCreateDialog$0(qe qeVar) {
        PrintDialogListener printDialogListener = this.listener;
        if (printDialogListener != null) {
            printDialogListener.onAccept(new PrintOptions(this.shareDialogLayout.getSharingOptions()));
        }
        dismiss();
    }

    public static void restore(FragmentManager fragmentManager, PrintDialogListener printDialogListener) {
        BaseDocumentPrintDialog baseDocumentPrintDialog = (BaseDocumentPrintDialog) fragmentManager.findFragmentByTag(FRAGMENT_TAG);
        if (baseDocumentPrintDialog != null) {
            baseDocumentPrintDialog.listener = printDialogListener;
        }
    }

    public static void show(BaseDocumentPrintDialog baseDocumentPrintDialog, Context context, FragmentManager fragmentManager, int i, int i2, String str, PrintDialogListener printDialogListener) {
        uw.a(context, "context", null);
        uw.a(fragmentManager, "manager", null);
        uw.a(str, "documentName", null);
        uw.a(printDialogListener, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, null);
        DocumentSharingDialogConfiguration.Builder builderInitialDocumentName = new DocumentSharingDialogConfiguration.Builder(context).dialogTitle(no.a(context, R.string.pspdf__print, null).concat("…")).positiveButtonText(no.a(context, R.string.pspdf__print, null)).currentPage(i).documentPages(i2).initialDocumentName(str);
        BaseDocumentPrintDialog documentPrintDialog = getInstance(fragmentManager, baseDocumentPrintDialog);
        documentPrintDialog.listener = printDialogListener;
        documentPrintDialog.configuration = builderInitialDocumentName.build();
        if (documentPrintDialog.isAdded()) {
            return;
        }
        documentPrintDialog.show(fragmentManager, FRAGMENT_TAG);
    }

    @Override // androidx.appcompat.app.AppCompatDialogFragment, androidx.fragment.app.DialogFragment
    public Dialog onCreateDialog(Bundle bundle) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(new qe.a(PdfProcessorTask.AnnotationProcessingMode.PRINT, R.string.pspdf__print_with_annotations, 0));
        arrayList.add(new qe.a(PdfProcessorTask.AnnotationProcessingMode.DELETE, R.string.pspdf__print_without_annotations, 0));
        qe qeVar = new qe(getContext(), this.configuration, arrayList);
        this.shareDialogLayout = qeVar;
        qeVar.setOnConfirmDocumentSharingListener(new qe.b() { // from class: com.pspdfkit.ui.dialog.DocumentPrintDialog$$ExternalSyntheticLambda0
            @Override // com.pspdfkit.internal.qe.b
            public final void a(qe qeVar2) {
                this.f$0.lambda$onCreateDialog$0(qeVar2);
            }
        });
        return new AlertDialog.Builder(getContext()).setCancelable(true).setView(this.shareDialogLayout).create();
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onStart() {
        super.onStart();
        if (getDialog() instanceof AlertDialog) {
            qe qeVar = this.shareDialogLayout;
            AlertDialog alertDialog = (AlertDialog) getDialog();
            qeVar.getClass();
            a80.a(alertDialog);
        }
    }

    private static BaseDocumentPrintDialog getInstance(FragmentManager fragmentManager, BaseDocumentPrintDialog baseDocumentPrintDialog) {
        BaseDocumentPrintDialog baseDocumentPrintDialog2 = (BaseDocumentPrintDialog) fragmentManager.findFragmentByTag(FRAGMENT_TAG);
        if (baseDocumentPrintDialog2 != null) {
            return baseDocumentPrintDialog2;
        }
        if (baseDocumentPrintDialog == null) {
            baseDocumentPrintDialog = new DocumentPrintDialog();
        }
        baseDocumentPrintDialog.setArguments(new Bundle());
        return baseDocumentPrintDialog;
    }

    public static void show(Context context, FragmentManager fragmentManager, int i, int i2, String str, PrintDialogListener printDialogListener) {
        show(null, context, fragmentManager, i, i2, str, printDialogListener);
    }
}
