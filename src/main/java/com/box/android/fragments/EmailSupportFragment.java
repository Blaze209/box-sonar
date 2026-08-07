package com.box.android.fragments;

import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.EditText;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import com.box.android.R;
import com.box.android.common.utilities.CommonBoxUtil;
import com.box.android.usercontext.UserContextManager;
import com.box.android.utilities.BoxUtils;
import com.google.android.material.dialog.MaterialAlertDialogBuilder;
import javax.inject.Inject;

/* JADX INFO: loaded from: classes11.dex */
public class EmailSupportFragment extends Hilt_EmailSupportFragment {
    public static final String TAG = "EmailSupportFragment";
    private static final String msgSaveInstanceKey = "MsgSaveInstanceKey";
    private CheckBox mAttachLogsCheckBox;
    private EditText mMsgBody;

    @Inject
    protected UserContextManager mUserContextManager;

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View viewInflate = layoutInflater.inflate(R.layout.email_support_layout, viewGroup, false);
        this.mMsgBody = (EditText) viewInflate.findViewById(R.id.msgBody);
        this.mAttachLogsCheckBox = (CheckBox) viewInflate.findViewById(R.id.attachLogFilesCheckBox);
        initToolbar(viewInflate);
        return viewInflate;
    }

    private void initToolbar(View view) {
        Toolbar toolbar = (Toolbar) view.findViewById(R.id.toolbarSupport);
        toolbar.setTitle(R.string.email_support_title);
        ((AppCompatActivity) getActivity()).setSupportActionBar(toolbar);
        ActionBar supportActionBar = ((AppCompatActivity) getActivity()).getSupportActionBar();
        if (supportActionBar != null) {
            supportActionBar.setDisplayHomeAsUpEnabled(true);
            supportActionBar.setHomeButtonEnabled(true);
            supportActionBar.setHomeAsUpIndicator(R.drawable.ic_toolbar_clear_24);
        }
        setHasOptionsMenu(true);
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onSaveInstanceState(Bundle bundle) {
        bundle.putString(msgSaveInstanceKey, this.mMsgBody.getText().toString());
        super.onSaveInstanceState(bundle);
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        if (bundle != null) {
            this.mMsgBody.setText((String) bundle.get(msgSaveInstanceKey));
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        this.mMsgBody.requestFocus();
        CommonBoxUtil.showKeyboard((AppCompatActivity) getActivity(), this.mMsgBody);
    }

    @Override // androidx.fragment.app.Fragment
    public void onPause() {
        super.onPause();
        CommonBoxUtil.hideKeyboard((AppCompatActivity) getActivity(), this.mMsgBody);
    }

    @Override // androidx.fragment.app.DialogFragment
    public Dialog onCreateDialog(Bundle bundle) {
        Dialog dialogOnCreateDialog = super.onCreateDialog(bundle);
        dialogOnCreateDialog.requestWindowFeature(1);
        return dialogOnCreateDialog;
    }

    @Override // androidx.fragment.app.Fragment
    public void onCreateOptionsMenu(Menu menu, MenuInflater menuInflater) {
        menu.clear();
        getActivity().getMenuInflater().inflate(R.menu.email_support_menu, menu);
    }

    @Override // androidx.fragment.app.Fragment
    public boolean onOptionsItemSelected(MenuItem menuItem) {
        int itemId = menuItem.getItemId();
        if (itemId == R.id.action_send) {
            BoxUtils.sendEmailForSupport(this.mUserContextManager.getCurrentContextId(), this.mMsgBody.getText().toString(), this.mAttachLogsCheckBox.isChecked(), getContext());
            getActivity().finish();
            dismiss();
            return true;
        }
        if (itemId == 16908332) {
            if (this.mMsgBody.getText().toString().length() > 0) {
                showConfirmDialog();
            } else {
                getActivity().finish();
                dismiss();
            }
            return true;
        }
        return super.onOptionsItemSelected(menuItem);
    }

    private void showConfirmDialog() {
        new MaterialAlertDialogBuilder(getContext()).setCancelable(false).setMessage(R.string.discard_confirm).setPositiveButton(R.string.yes, new DialogInterface.OnClickListener() { // from class: com.box.android.fragments.EmailSupportFragment.2
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i) {
                EmailSupportFragment.this.getActivity().finish();
                EmailSupportFragment.this.dismiss();
            }
        }).setNegativeButton(R.string.no, new DialogInterface.OnClickListener() { // from class: com.box.android.fragments.EmailSupportFragment.1
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.cancel();
            }
        }).create().show();
    }
}
