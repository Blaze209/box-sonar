package com.pspdfkit.internal.ui.dialog.signatures;

import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.Window;
import androidx.appcompat.app.AppCompatDialogFragment;
import com.pspdfkit.R;
import com.pspdfkit.configuration.forms.SignaturePickerOrientation;
import com.pspdfkit.configuration.signatures.SignatureSavingStrategy;
import com.pspdfkit.internal.uc;
import com.pspdfkit.internal.x10;
import com.pspdfkit.signatures.Signature;
import com.pspdfkit.ui.signatures.SignatureUiData;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public class f extends AppCompatDialogFragment implements g.a {
    public static final /* synthetic */ int g = 0;
    public Integer a;
    public List<Signature> b;
    public x10 c;
    public SignaturePickerOrientation d = SignaturePickerOrientation.AUTOMATIC;
    public SignatureSavingStrategy e = SignatureSavingStrategy.SAVE_IF_SELECTED;
    public g f;

    @Override // androidx.appcompat.app.AppCompatDialogFragment, androidx.fragment.app.DialogFragment
    public final Dialog onCreateDialog(Bundle bundle) {
        if (bundle != null) {
            this.b = bundle.getParcelableArrayList("STATE_SIGNATURES");
            if (bundle.containsKey("STATE_ORIGINAL_ORIENTATION")) {
                this.a = Integer.valueOf(bundle.getInt("STATE_ORIGINAL_ORIENTATION"));
            }
        }
        setStyle(2, R.style.PSPDFKit_Dialog_Light_Panel_Dim);
        Dialog dialogOnCreateDialog = super.onCreateDialog(bundle);
        dialogOnCreateDialog.setCancelable(true);
        return dialogOnCreateDialog;
    }

    @Override // com.pspdfkit.signatures.listeners.OnSignaturePickedListener
    public final void onDismiss() {
        x10 x10Var = this.c;
        if (x10Var != null) {
            x10Var.onDismiss();
        }
        dismiss();
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public final void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putParcelableArrayList("STATE_SIGNATURES", (ArrayList) this.b);
        Integer num = this.a;
        if (num != null) {
            bundle.putInt("STATE_ORIGINAL_ORIENTATION", num.intValue());
        }
    }

    @Override // com.pspdfkit.signatures.listeners.OnSignaturePickedListener
    public final void onSignatureCreated(Signature signature, boolean z) {
        x10 x10Var = this.c;
        if (x10Var != null) {
            x10Var.onSignatureCreated(signature, z);
        }
        dismiss();
    }

    @Override // com.pspdfkit.signatures.listeners.OnSignaturePickedListener
    public final void onSignaturePicked(Signature signature) {
        x10 x10Var = this.c;
        if (x10Var != null) {
            x10Var.onSignaturePicked(signature);
        }
        dismiss();
    }

    @Override // com.pspdfkit.signatures.listeners.OnSignaturePickedListener
    public final void onSignatureUiDataCollected(Signature signature, SignatureUiData signatureUiData) {
        x10 x10Var = this.c;
        if (x10Var != null) {
            x10Var.onSignatureUiDataCollected(signature, signatureUiData);
        }
    }

    @Override // com.pspdfkit.internal.x10
    public final void onSignaturesDeleted(List<Signature> list) {
        x10 x10Var = this.c;
        if (x10Var != null) {
            x10Var.onSignaturesDeleted(list);
        }
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public final void onStart() {
        super.onStart();
        Dialog dialog = getDialog();
        if (dialog == null || dialog.getWindow() == null) {
            return;
        }
        int dimension = (int) getResources().getDimension(R.dimen.pspdf__signature_dialog_width);
        int dimension2 = (int) getResources().getDimension(R.dimen.pspdf__signature_dialog_height);
        boolean zA = uc.a(getResources(), R.dimen.pspdf__signature_dialog_width, R.dimen.pspdf__signature_dialog_height);
        Window window = dialog.getWindow();
        if (!zA) {
            dimension = -1;
        }
        if (!zA) {
            dimension2 = -1;
        }
        window.setLayout(dimension, dimension2);
        dialog.getWindow().setGravity(17);
        dialog.getWindow().addFlags(67108864);
        g gVar = this.f;
        if (gVar != null) {
            gVar.setFullscreen(!zA);
            this.f.setListener(this);
            List<Signature> list = this.b;
            if (list != null) {
                this.f.setItems(list);
                this.b = null;
            }
        }
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public final void onStop() {
        super.onStop();
        g gVar = this.f;
        if (gVar != null) {
            gVar.f = null;
        }
    }

    @Override // androidx.appcompat.app.AppCompatDialogFragment, androidx.fragment.app.DialogFragment
    public final void setupDialog(Dialog dialog, int i) {
        super.setupDialog(dialog, i);
        g gVar = new g(requireContext(), this.d, this.e);
        this.f = gVar;
        gVar.setListener(this);
        this.f.setId(R.id.pspdf__signature_layout);
        dialog.setContentView(this.f);
    }

    @Override // androidx.fragment.app.DialogFragment, android.content.DialogInterface.OnDismissListener
    public final void onDismiss(DialogInterface dialogInterface) {
        super.onDismiss(dialogInterface);
        x10 x10Var = this.c;
        if (x10Var != null) {
            x10Var.onDismiss();
        }
    }
}
