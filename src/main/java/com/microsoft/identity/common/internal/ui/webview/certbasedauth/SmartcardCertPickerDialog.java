package com.microsoft.identity.common.internal.ui.webview.certbasedauth;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.TextView;
import androidx.appcompat.app.AlertDialog;
import com.microsoft.identity.common.R;
import com.microsoft.identity.common.logging.Logger;
import java.security.cert.X509Certificate;
import java.util.List;

/* JADX INFO: loaded from: classes14.dex */
public class SmartcardCertPickerDialog extends SmartcardDialog {
    private static final String TAG = "SmartcardCertPickerDialog";
    private final ICancelCbaCallback mCancelCbaCallback;
    private final List<ICertDetails> mCertList;
    private final PositiveButtonListener mPositiveButtonListener;

    public interface PositiveButtonListener {
        void onClick(ICertDetails iCertDetails);
    }

    public SmartcardCertPickerDialog(List<ICertDetails> list, PositiveButtonListener positiveButtonListener, ICancelCbaCallback iCancelCbaCallback, Activity activity) {
        super(activity);
        this.mCertList = list;
        this.mPositiveButtonListener = positiveButtonListener;
        this.mCancelCbaCallback = iCancelCbaCallback;
        createDialog();
    }

    @Override // com.microsoft.identity.common.internal.ui.webview.certbasedauth.SmartcardDialog
    protected void createDialog() {
        final String str = TAG + ":createDialog";
        final CertDetailsAdapter certDetailsAdapter = new CertDetailsAdapter(this.mActivity, this.mCertList);
        this.mActivity.runOnUiThread(new Runnable() { // from class: com.microsoft.identity.common.internal.ui.webview.certbasedauth.SmartcardCertPickerDialog.1
            @Override // java.lang.Runnable
            public void run() {
                AlertDialog alertDialogCreate = new AlertDialog.Builder(SmartcardCertPickerDialog.this.mActivity, R.style.CertAlertDialogTheme).setTitle(R.string.smartcard_cert_dialog_title).setSingleChoiceItems(certDetailsAdapter, 0, (DialogInterface.OnClickListener) null).setPositiveButton(R.string.smartcard_cert_dialog_positive_button, new DialogInterface.OnClickListener() { // from class: com.microsoft.identity.common.internal.ui.webview.certbasedauth.SmartcardCertPickerDialog.1.2
                    @Override // android.content.DialogInterface.OnClickListener
                    public void onClick(DialogInterface dialogInterface, int i) {
                        ICertDetails item = certDetailsAdapter.getItem(((AlertDialog) dialogInterface).getListView().getCheckedItemPosition());
                        if (item != null) {
                            SmartcardCertPickerDialog.this.mPositiveButtonListener.onClick(item);
                        } else {
                            SmartcardCertPickerDialog.this.mCancelCbaCallback.onCancel();
                            Logger.error(str, "Could not retrieve info for selected certificate entry.", null);
                        }
                    }
                }).setNegativeButton(R.string.smartcard_cert_dialog_negative_button, new DialogInterface.OnClickListener() { // from class: com.microsoft.identity.common.internal.ui.webview.certbasedauth.SmartcardCertPickerDialog.1.1
                    @Override // android.content.DialogInterface.OnClickListener
                    public void onClick(DialogInterface dialogInterface, int i) {
                        SmartcardCertPickerDialog.this.mCancelCbaCallback.onCancel();
                    }
                }).create();
                final ListView listView = alertDialogCreate.getListView();
                listView.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.microsoft.identity.common.internal.ui.webview.certbasedauth.SmartcardCertPickerDialog.1.3
                    @Override // android.widget.AdapterView.OnItemClickListener
                    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                        listView.setItemChecked(i, true);
                        certDetailsAdapter.notifyDataSetChanged();
                    }
                });
                alertDialogCreate.setCanceledOnTouchOutside(false);
                alertDialogCreate.setOnCancelListener(new DialogInterface.OnCancelListener() { // from class: com.microsoft.identity.common.internal.ui.webview.certbasedauth.SmartcardCertPickerDialog.1.4
                    @Override // android.content.DialogInterface.OnCancelListener
                    public void onCancel(DialogInterface dialogInterface) {
                        SmartcardCertPickerDialog.this.mCancelCbaCallback.onCancel();
                    }
                });
                SmartcardCertPickerDialog.this.mDialog = alertDialogCreate;
            }
        });
    }

    @Override // com.microsoft.identity.common.internal.ui.webview.certbasedauth.SmartcardDialog
    void onUnexpectedUnplug() {
        this.mCancelCbaCallback.onCancel();
    }

    public static class CertDetailsAdapter extends ArrayAdapter<ICertDetails> {
        public CertDetailsAdapter(Context context, List<ICertDetails> list) {
            super(context, 0, list);
        }

        @Override // android.widget.ArrayAdapter, android.widget.Adapter
        public View getView(int i, View view, ViewGroup viewGroup) {
            if (view == null) {
                view = LayoutInflater.from(getContext()).inflate(R.layout.certificate_row_layout, viewGroup, false);
            }
            TextView textView = (TextView) view.findViewById(R.id.subjectText);
            TextView textView2 = (TextView) view.findViewById(R.id.issuerText);
            X509Certificate certificate = getItem(i).getCertificate();
            textView.setText(certificate.getSubjectDN().getName());
            textView2.setText(certificate.getIssuerDN().getName());
            ((RadioButton) view.findViewById(R.id.radioButton)).setChecked(i == ((ListView) viewGroup).getCheckedItemPosition());
            return view;
        }
    }
}
