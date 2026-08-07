package com.microsoft.identity.common.internal.ui.webview.certbasedauth;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.res.ColorStateList;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;
import androidx.appcompat.app.AlertDialog;
import com.microsoft.identity.common.R;
import com.microsoft.identity.common.logging.Logger;

/* JADX INFO: loaded from: classes14.dex */
public class SmartcardPinDialog extends SmartcardDialog {
    private static final String TAG = "SmartcardPinDialog";
    private final ICancelCbaCallback mCancelCbaCallback;
    private View mPinLayout;
    private final PositiveButtonListener mPositiveButtonListener;

    public interface PositiveButtonListener {
        void onClick(char[] cArr);
    }

    public SmartcardPinDialog(PositiveButtonListener positiveButtonListener, ICancelCbaCallback iCancelCbaCallback, Activity activity) {
        super(activity);
        if (positiveButtonListener == null) {
            throw new NullPointerException("positiveButtonListener is marked non-null but is null");
        }
        if (iCancelCbaCallback == null) {
            throw new NullPointerException("cancelCbaCallback is marked non-null but is null");
        }
        if (activity == null) {
            throw new NullPointerException("activity is marked non-null but is null");
        }
        this.mPositiveButtonListener = positiveButtonListener;
        this.mCancelCbaCallback = iCancelCbaCallback;
        createDialog();
    }

    @Override // com.microsoft.identity.common.internal.ui.webview.certbasedauth.SmartcardDialog
    protected void createDialog() {
        this.mActivity.runOnUiThread(new Runnable() { // from class: com.microsoft.identity.common.internal.ui.webview.certbasedauth.SmartcardPinDialog.1
            @Override // java.lang.Runnable
            public void run() {
                SmartcardPinDialog smartcardPinDialog = SmartcardPinDialog.this;
                smartcardPinDialog.mPinLayout = smartcardPinDialog.mActivity.getLayoutInflater().inflate(R.layout.pin_textview_layout, (ViewGroup) SmartcardPinDialog.this.mActivity.findViewById(android.R.id.content), false);
                AlertDialog alertDialogCreate = new AlertDialog.Builder(SmartcardPinDialog.this.mActivity, R.style.CertAlertDialogTheme).setTitle(R.string.smartcard_pin_dialog_title).setMessage(R.string.smartcard_pin_dialog_message).setView(SmartcardPinDialog.this.mPinLayout).setPositiveButton(R.string.smartcard_pin_dialog_positive_button, (DialogInterface.OnClickListener) null).setNegativeButton(R.string.smartcard_pin_dialog_negative_button, new DialogInterface.OnClickListener() { // from class: com.microsoft.identity.common.internal.ui.webview.certbasedauth.SmartcardPinDialog.1.1
                    @Override // android.content.DialogInterface.OnClickListener
                    public void onClick(DialogInterface dialogInterface, int i) {
                        SmartcardPinDialog.this.mCancelCbaCallback.onCancel();
                    }
                }).create();
                alertDialogCreate.setCanceledOnTouchOutside(false);
                alertDialogCreate.setOnCancelListener(new DialogInterface.OnCancelListener() { // from class: com.microsoft.identity.common.internal.ui.webview.certbasedauth.SmartcardPinDialog.1.2
                    @Override // android.content.DialogInterface.OnCancelListener
                    public void onCancel(DialogInterface dialogInterface) {
                        SmartcardPinDialog.this.mCancelCbaCallback.onCancel();
                    }
                });
                SmartcardPinDialog.this.mDialog = alertDialogCreate;
            }
        });
    }

    @Override // com.microsoft.identity.common.internal.ui.webview.certbasedauth.SmartcardDialog
    void onUnexpectedUnplug() {
        this.mCancelCbaCallback.onCancel();
    }

    @Override // com.microsoft.identity.common.internal.ui.webview.certbasedauth.SmartcardDialog
    public void show() {
        final String str = TAG + ":show";
        this.mActivity.runOnUiThread(new Runnable() { // from class: com.microsoft.identity.common.internal.ui.webview.certbasedauth.SmartcardPinDialog.2
            @Override // java.lang.Runnable
            public void run() {
                SmartcardPinDialog.this.mDialog.show();
                final EditText editText = (EditText) SmartcardPinDialog.this.mPinLayout.findViewById(R.id.pinEditText);
                if (editText == null) {
                    SmartcardPinDialog.this.mCancelCbaCallback.onCancel();
                    Logger.error(str, "Error while retrieving dialog EditText component.", null);
                } else {
                    editText.addTextChangedListener(new TextWatcher() { // from class: com.microsoft.identity.common.internal.ui.webview.certbasedauth.SmartcardPinDialog.2.1
                        @Override // android.text.TextWatcher
                        public void afterTextChanged(Editable editable) {
                        }

                        @Override // android.text.TextWatcher
                        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                        }

                        @Override // android.text.TextWatcher
                        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                            if (i == 0) {
                                SmartcardPinDialog.this.resetErrorMode();
                            }
                        }
                    });
                    ((AlertDialog) SmartcardPinDialog.this.mDialog).getButton(-1).setOnClickListener(new View.OnClickListener() { // from class: com.microsoft.identity.common.internal.ui.webview.certbasedauth.SmartcardPinDialog.2.2
                        @Override // android.view.View.OnClickListener
                        public void onClick(View view) {
                            char[] cArr = new char[editText.length()];
                            editText.getText().getChars(0, editText.length(), cArr, 0);
                            SmartcardPinDialog.this.mPositiveButtonListener.onClick(cArr);
                        }
                    });
                }
            }
        });
    }

    public void setErrorMode() {
        this.mActivity.runOnUiThread(new Runnable() { // from class: com.microsoft.identity.common.internal.ui.webview.certbasedauth.SmartcardPinDialog.3
            @Override // java.lang.Runnable
            public void run() {
                EditText editText = (EditText) SmartcardPinDialog.this.mPinLayout.findViewById(R.id.pinEditText);
                editText.getText().clear();
                editText.setBackgroundTintList(ColorStateList.valueOf(SmartcardPinDialog.this.mActivity.getResources().getColor(R.color.dialogErrorText)));
                ((TextView) SmartcardPinDialog.this.mPinLayout.findViewById(R.id.errorTextView)).setText(R.string.smartcard_pin_dialog_error_message);
            }
        });
    }

    public void resetErrorMode() {
        this.mActivity.runOnUiThread(new Runnable() { // from class: com.microsoft.identity.common.internal.ui.webview.certbasedauth.SmartcardPinDialog.4
            @Override // java.lang.Runnable
            public void run() {
                ((TextView) SmartcardPinDialog.this.mPinLayout.findViewById(R.id.errorTextView)).setText("");
                ((EditText) SmartcardPinDialog.this.mPinLayout.findViewById(R.id.pinEditText)).setBackgroundTintList(ColorStateList.valueOf(SmartcardPinDialog.this.mActivity.getResources().getColor(R.color.dialogPinEditText)));
            }
        });
    }
}
