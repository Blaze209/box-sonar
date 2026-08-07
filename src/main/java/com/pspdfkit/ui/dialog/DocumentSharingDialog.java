package com.pspdfkit.ui.dialog;

import android.app.Dialog;
import android.os.Bundle;
import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.FragmentManager;
import com.pspdfkit.document.sharing.SharingOptions;
import com.pspdfkit.internal.a80;
import com.pspdfkit.internal.qe;
import com.pspdfkit.internal.uw;

/* JADX INFO: loaded from: classes3.dex */
public class DocumentSharingDialog extends BaseDocumentSharingDialog {
    static final String FRAGMENT_TAG = "com.pspdfkit.ui.dialog.DocumentSharingDialog.FRAGMENT_TAG";
    private qe shareDialogLayout;

    public interface SharingDialogListener {
        void onAccept(SharingOptions sharingOptions);

        void onDismiss();
    }

    private static BaseDocumentSharingDialog getInstance(FragmentManager fragmentManager) {
        return getInstance(fragmentManager, null);
    }

    public static void hide(FragmentManager fragmentManager) {
        if (isVisible(fragmentManager)) {
            getInstance(fragmentManager).dismiss();
        }
    }

    public static boolean isVisible(FragmentManager fragmentManager) {
        BaseDocumentSharingDialog baseDocumentSharingDialog = (BaseDocumentSharingDialog) fragmentManager.findFragmentByTag(FRAGMENT_TAG);
        return baseDocumentSharingDialog != null && baseDocumentSharingDialog.isAdded();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onCreateDialog$0(qe qeVar) {
        SharingDialogListener sharingDialogListener = this.listener;
        if (sharingDialogListener != null) {
            sharingDialogListener.onAccept(this.shareDialogLayout.getSharingOptions());
            dismiss();
        }
    }

    public static void restore(FragmentManager fragmentManager, SharingDialogListener sharingDialogListener) {
        BaseDocumentSharingDialog baseDocumentSharingDialog = (BaseDocumentSharingDialog) fragmentManager.findFragmentByTag(FRAGMENT_TAG);
        if (baseDocumentSharingDialog != null) {
            baseDocumentSharingDialog.listener = sharingDialogListener;
        }
    }

    public static void show(FragmentManager fragmentManager, DocumentSharingDialogConfiguration documentSharingDialogConfiguration, SharingDialogListener sharingDialogListener) {
        show(null, fragmentManager, documentSharingDialogConfiguration, sharingDialogListener);
    }

    @Override // androidx.appcompat.app.AppCompatDialogFragment, androidx.fragment.app.DialogFragment
    public Dialog onCreateDialog(Bundle bundle) {
        qe qeVar = new qe(getContext(), this.configuration, null);
        this.shareDialogLayout = qeVar;
        qeVar.setOnConfirmDocumentSharingListener(new qe.b() { // from class: com.pspdfkit.ui.dialog.DocumentSharingDialog$$ExternalSyntheticLambda0
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

    private static BaseDocumentSharingDialog getInstance(FragmentManager fragmentManager, BaseDocumentSharingDialog baseDocumentSharingDialog) {
        BaseDocumentSharingDialog baseDocumentSharingDialog2 = (BaseDocumentSharingDialog) fragmentManager.findFragmentByTag(FRAGMENT_TAG);
        if (baseDocumentSharingDialog2 != null) {
            return baseDocumentSharingDialog2;
        }
        if (baseDocumentSharingDialog == null) {
            baseDocumentSharingDialog = new DocumentSharingDialog();
        }
        baseDocumentSharingDialog.setArguments(new Bundle());
        return baseDocumentSharingDialog;
    }

    public static void show(BaseDocumentSharingDialog baseDocumentSharingDialog, FragmentManager fragmentManager, DocumentSharingDialogConfiguration documentSharingDialogConfiguration, SharingDialogListener sharingDialogListener) {
        uw.a(fragmentManager, "manager", null);
        uw.a(documentSharingDialogConfiguration, "configuration", null);
        BaseDocumentSharingDialog documentSharingDialog = getInstance(fragmentManager, baseDocumentSharingDialog);
        documentSharingDialog.listener = sharingDialogListener;
        documentSharingDialog.configuration = documentSharingDialogConfiguration;
        if (documentSharingDialog.isAdded()) {
            return;
        }
        documentSharingDialog.show(fragmentManager, FRAGMENT_TAG);
    }
}
