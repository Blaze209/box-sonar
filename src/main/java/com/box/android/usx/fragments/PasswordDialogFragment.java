package com.box.android.usx.fragments;

import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.app.AlertDialog;
import com.box.android.R;
import com.google.android.material.dialog.MaterialAlertDialogBuilder;

/* JADX INFO: loaded from: classes13.dex */
public class PasswordDialogFragment extends PositiveNegativeDialogFragment {
    private static final String EXTRA_PREV_TEXT = "extraPrevText";
    private TextView errorMessage;
    private EditText mPasswordEditText;

    @Override // com.box.android.usx.fragments.PositiveNegativeDialogFragment, androidx.fragment.app.DialogFragment
    public Dialog onCreateDialog(Bundle bundle) {
        String string;
        if (bundle == null) {
            string = "";
        } else {
            string = bundle.getString(EXTRA_PREV_TEXT);
        }
        int i = getArguments().getInt("title_res_id");
        int i2 = getArguments().getInt("message_res_id");
        int i3 = getArguments().getInt("positive_res_id");
        int i4 = getArguments().getInt("negative_res_id");
        MaterialAlertDialogBuilder materialAlertDialogBuilder = new MaterialAlertDialogBuilder(getActivity());
        LinearLayout linearLayout = (LinearLayout) getActivity().getLayoutInflater().inflate(R.layout.usx_password_edit_text, (ViewGroup) null);
        this.mPasswordEditText = (EditText) linearLayout.findViewById(R.id.box_password_edit_text);
        this.errorMessage = (TextView) linearLayout.findViewById(R.id.box_password_error_message);
        this.mPasswordEditText.setHint(i2);
        this.mPasswordEditText.setText(string);
        materialAlertDialogBuilder.setPositiveButton(getText(i3), (DialogInterface.OnClickListener) null).setNegativeButton(getText(i4), new DialogInterface.OnClickListener() { // from class: com.box.android.usx.fragments.PasswordDialogFragment$$ExternalSyntheticLambda1
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i5) {
                this.f$0.lambda$onCreateDialog$0(dialogInterface, i5);
            }
        });
        materialAlertDialogBuilder.setTitle(i);
        materialAlertDialogBuilder.setView((View) linearLayout);
        return materialAlertDialogBuilder.create();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onCreateDialog$0(DialogInterface dialogInterface, int i) {
        if (this.mButtonClickedListener != null) {
            this.mButtonClickedListener.onNegativeButtonClicked(this);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        AlertDialog alertDialog = (AlertDialog) getDialog();
        if (alertDialog != null) {
            alertDialog.getButton(-1).setOnClickListener(new View.OnClickListener() { // from class: com.box.android.usx.fragments.PasswordDialogFragment$$ExternalSyntheticLambda0
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    this.f$0.lambda$onResume$1(view);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onResume$1(View view) {
        if (this.mButtonClickedListener != null) {
            this.mButtonClickedListener.onPositiveButtonClicked(this);
        }
    }

    public String getPassword() {
        EditText editText = this.mPasswordEditText;
        if (editText == null) {
            return null;
        }
        return editText.getText().toString();
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onSaveInstanceState(Bundle bundle) {
        bundle.putString(EXTRA_PREV_TEXT, this.mPasswordEditText.getText().toString());
        super.onSaveInstanceState(bundle);
    }

    public static PasswordDialogFragment createFragment(int i, int i2, int i3, int i4, PositiveNegativeDialogFragment.OnPositiveOrNegativeButtonClickedListener onPositiveOrNegativeButtonClickedListener) {
        PasswordDialogFragment passwordDialogFragment = new PasswordDialogFragment();
        Bundle bundle = new Bundle();
        bundle.putInt("title_res_id", i);
        bundle.putInt("message_res_id", i2);
        bundle.putInt("positive_res_id", i3);
        bundle.putInt("negative_res_id", i4);
        passwordDialogFragment.setArguments(bundle);
        passwordDialogFragment.setOnPositiveOrNegativeButtonClickedListener(onPositiveOrNegativeButtonClickedListener);
        return passwordDialogFragment;
    }

    public void showError(int i) {
        TextView textView = this.errorMessage;
        if (textView != null) {
            textView.setText(i);
        }
    }
}
