package com.pspdfkit.ui.dialog;

import android.content.DialogInterface;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatDialogFragment;

/* JADX INFO: loaded from: classes3.dex */
public abstract class BaseDocumentSharingDialog extends AppCompatDialogFragment {
    private static final String BUNDLE_DIALOG_CONFIGURATION = "BUNDLE_DIALOG_CONFIGURATION";
    DocumentSharingDialogConfiguration configuration;
    DocumentSharingDialog.SharingDialogListener listener;

    private void onRestoreState(Bundle bundle) {
        DocumentSharingDialogConfiguration documentSharingDialogConfigurationBuild = (DocumentSharingDialogConfiguration) bundle.getParcelable(BUNDLE_DIALOG_CONFIGURATION);
        if (documentSharingDialogConfigurationBuild == null) {
            documentSharingDialogConfigurationBuild = new DocumentSharingDialogConfiguration.Builder(getContext()).build();
        }
        this.configuration = documentSharingDialogConfigurationBuild;
    }

    public DocumentSharingDialogConfiguration getConfiguration() {
        return this.configuration;
    }

    public DocumentSharingDialog.SharingDialogListener getListener() {
        return this.listener;
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (bundle != null) {
            onRestoreState(bundle);
        }
    }

    @Override // androidx.fragment.app.DialogFragment, android.content.DialogInterface.OnDismissListener
    public void onDismiss(DialogInterface dialogInterface) {
        super.onDismiss(dialogInterface);
        DocumentSharingDialog.SharingDialogListener sharingDialogListener = this.listener;
        if (sharingDialogListener != null) {
            sharingDialogListener.onDismiss();
        }
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putParcelable(BUNDLE_DIALOG_CONFIGURATION, this.configuration);
    }
}
