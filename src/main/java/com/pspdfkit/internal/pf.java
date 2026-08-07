package com.pspdfkit.internal;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.Window;
import androidx.appcompat.app.AppCompatDialogFragment;
import com.pspdfkit.R;
import com.pspdfkit.signatures.Signature;
import com.pspdfkit.ui.signatures.ElectronicSignatureOptions;
import com.pspdfkit.ui.signatures.SignatureUiData;
import com.pspdfkit.utils.BundleExtensions;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u00012\u00020\u0002B\u0007¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, d2 = {"Lcom/pspdfkit/internal/pf;", "Landroidx/appcompat/app/AppCompatDialogFragment;", "Lcom/pspdfkit/internal/x10;", "<init>", "()V", "sdk-nutrient"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class pf extends AppCompatDialogFragment implements x10 {
    public static final /* synthetic */ int e = 0;
    public x10 a;
    public List<Signature> b;
    public ElectronicSignatureOptions c;
    public qf d;

    @Override // androidx.appcompat.app.AppCompatDialogFragment, androidx.fragment.app.DialogFragment
    public final Dialog onCreateDialog(Bundle bundle) {
        qf qfVar;
        if (bundle != null) {
            ArrayList supportParcelableArrayList = BundleExtensions.getSupportParcelableArrayList(bundle, "STATE_SIGNATURES", Signature.class);
            if (supportParcelableArrayList == null || (qfVar = this.d) == null) {
                this.b = supportParcelableArrayList;
            } else {
                qfVar.setItems(supportParcelableArrayList);
            }
            this.c = (ElectronicSignatureOptions) BundleExtensions.getSupportParcelable(bundle, "STATE_SIGNATURE_OPTIONS", ElectronicSignatureOptions.class);
        }
        setStyle(2, R.style.PSPDFKit_Dialog_Light_Panel_Dim);
        Dialog dialogOnCreateDialog = super.onCreateDialog(bundle);
        dialogOnCreateDialog.getClass();
        dialogOnCreateDialog.setCancelable(true);
        return dialogOnCreateDialog;
    }

    @Override // com.pspdfkit.signatures.listeners.OnSignaturePickedListener
    public final void onDismiss() {
        x10 x10Var = this.a;
        if (x10Var != null) {
            x10Var.onDismiss();
        }
        dismiss();
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public final void onSaveInstanceState(Bundle bundle) {
        ArrayList<? extends Parcelable> arrayList;
        bundle.getClass();
        super.onSaveInstanceState(bundle);
        List<Signature> list = this.b;
        if (list != null) {
            list.getClass();
            arrayList = (ArrayList) list;
        } else {
            arrayList = null;
        }
        bundle.putParcelableArrayList("STATE_SIGNATURES", arrayList);
        bundle.putParcelable("STATE_SIGNATURE_OPTIONS", this.c);
    }

    @Override // com.pspdfkit.signatures.listeners.OnSignaturePickedListener
    public final void onSignatureCreated(Signature signature, boolean z) {
        signature.getClass();
        x10 x10Var = this.a;
        if (x10Var != null) {
            x10Var.onSignatureCreated(signature, z);
        }
        dismiss();
    }

    @Override // com.pspdfkit.signatures.listeners.OnSignaturePickedListener
    public final void onSignaturePicked(Signature signature) {
        signature.getClass();
        x10 x10Var = this.a;
        if (x10Var != null) {
            x10Var.onSignaturePicked(signature);
        }
        dismiss();
    }

    @Override // com.pspdfkit.signatures.listeners.OnSignaturePickedListener
    public final void onSignatureUiDataCollected(Signature signature, SignatureUiData signatureUiData) {
        signature.getClass();
        signatureUiData.getClass();
        x10 x10Var = this.a;
        if (x10Var != null) {
            x10Var.onSignatureUiDataCollected(signature, signatureUiData);
        }
    }

    @Override // com.pspdfkit.internal.x10
    public final void onSignaturesDeleted(List<Signature> list) {
        x10 x10Var = this.a;
        if (x10Var != null) {
            x10Var.onSignaturesDeleted(list);
        }
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public final void onStart() {
        Window window;
        super.onStart();
        Dialog dialog = getDialog();
        if (dialog == null || (window = dialog.getWindow()) == null) {
            return;
        }
        int dimension = (int) getResources().getDimension(R.dimen.pspdf__electronic_signature_dialog_width);
        int dimension2 = (int) getResources().getDimension(R.dimen.pspdf__electronic_signature_dialog_height);
        boolean zA = uc.a(getResources(), R.dimen.pspdf__electronic_signature_dialog_width, R.dimen.pspdf__electronic_signature_dialog_height);
        if (!zA) {
            dimension = -1;
        }
        if (!zA) {
            dimension2 = -1;
        }
        window.setLayout(dimension, dimension2);
        window.setGravity(17);
        dialog.setCanceledOnTouchOutside(false);
        window.addFlags(67108864);
        qf qfVar = this.d;
        if (qfVar != null) {
            qfVar.setFullscreen(!zA);
            qfVar.setListener(this);
            List<Signature> list = this.b;
            if (list != null) {
                list.getClass();
                qfVar.setItems(list);
                this.b = null;
            }
        }
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public final void onStop() {
        super.onStop();
        qf qfVar = this.d;
        if (qfVar != null) {
            qfVar.h = null;
        }
    }

    @Override // androidx.appcompat.app.AppCompatDialogFragment, androidx.fragment.app.DialogFragment
    public final void setupDialog(Dialog dialog, int i) {
        dialog.getClass();
        super.setupDialog(dialog, i);
        ElectronicSignatureOptions electronicSignatureOptions = this.c;
        if (electronicSignatureOptions == null) {
            throw new IllegalStateException("Signature options are missing!");
        }
        Context contextRequireContext = requireContext();
        contextRequireContext.getClass();
        qf qfVar = new qf(contextRequireContext, electronicSignatureOptions);
        qfVar.setListener(this);
        qfVar.setId(R.id.pspdf__signature_layout);
        dialog.setContentView(qfVar);
        this.d = qfVar;
    }
}
