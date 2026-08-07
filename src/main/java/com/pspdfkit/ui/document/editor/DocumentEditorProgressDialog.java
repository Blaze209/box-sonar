package com.pspdfkit.ui.document.editor;

import android.content.Context;
import android.content.DialogInterface;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.app.AlertDialog;
import com.pspdfkit.R;
import com.pspdfkit.internal.no;

/* JADX INFO: loaded from: classes3.dex */
public final class DocumentEditorProgressDialog {
    private AlertDialog alertDialog;

    private int getThemeColor(Context context, int i) {
        TypedValue typedValue = new TypedValue();
        context.getTheme().resolveAttribute(i, typedValue, true);
        return typedValue.data;
    }

    private void showProgressDialog(Context context, int i) {
        ViewGroup viewGroup = (ViewGroup) LayoutInflater.from(context).inflate(R.layout.pspdf__document_editor_alert_dialog, (ViewGroup) new LinearLayout(context), false);
        ImageView imageView = (ImageView) viewGroup.findViewById(R.id.pspdf__alert_dialog_img);
        ((TextView) viewGroup.findViewById(R.id.pspdf__alert_dialog_label)).setText(i);
        MaterialProgressDrawable materialProgressDrawable = new MaterialProgressDrawable(context, imageView);
        materialProgressDrawable.setBackgroundColor(-1);
        materialProgressDrawable.setAlpha(255);
        materialProgressDrawable.setColorSchemeColors(getThemeColor(context, androidx.appcompat.R.attr.colorPrimary));
        imageView.setImageDrawable(materialProgressDrawable);
        materialProgressDrawable.start();
        this.alertDialog = new AlertDialog.Builder(context).setView(viewGroup).setCancelable(false).show();
    }

    public void dismiss() {
        AlertDialog alertDialog = this.alertDialog;
        if (alertDialog == null || !alertDialog.isShowing()) {
            return;
        }
        this.alertDialog.dismiss();
    }

    public void showErrorDialog(Context context, int i) {
        dismiss();
        this.alertDialog = new AlertDialog.Builder(context).setMessage(i).setPositiveButton(no.a(context, R.string.pspdf__ok, null), new DialogInterface.OnClickListener() { // from class: com.pspdfkit.ui.document.editor.DocumentEditorProgressDialog$$ExternalSyntheticLambda0
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i2) {
                dialogInterface.dismiss();
            }
        }).setCancelable(true).show();
    }

    public void showIndeterminateProgressDialog(Context context, int i) {
        dismiss();
        showProgressDialog(context, i);
    }
}
