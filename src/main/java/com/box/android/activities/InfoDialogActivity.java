package com.box.android.activities;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import androidx.appcompat.app.AlertDialog;
import androidx.lifecycle.ViewModelProvider;
import com.box.android.R;
import com.box.android.common.utilities.CommonBoxUtil;

/* JADX INFO: loaded from: classes9.dex */
public class InfoDialogActivity extends Hilt_InfoDialogActivity implements View.OnClickListener {
    private static final String EXTRA_BUTTON_TEXT = "extraButtonText";
    private static final String EXTRA_MESSAGE = "extraMessage";
    private static final String EXTRA_TITLE = "extraTitle";
    private String btnText;
    private String message;
    private String title;

    @Override // com.box.android.base.presentation.activities.BoxFragmentActivity
    protected boolean requiresAuthToken() {
        return false;
    }

    @Override // com.box.android.base.presentation.activities.Hilt_BoxFragmentActivity, androidx.activity.ComponentActivity, androidx.lifecycle.HasDefaultViewModelProviderFactory
    public /* bridge */ /* synthetic */ ViewModelProvider.Factory getDefaultViewModelProviderFactory() {
        return super.getDefaultViewModelProviderFactory();
    }

    @Override // com.box.android.base.presentation.activities.BoxFragmentActivity
    protected Integer getActivityLayoutId() {
        if (this.title == null) {
            this.title = getIntent().getExtras().getString(EXTRA_TITLE);
        }
        return Integer.valueOf(this.title == null ? R.layout.layout_titleless_confirm : R.layout.layout_dialog_confirm);
    }

    @Override // com.box.android.base.presentation.activities.BoxFragmentActivity
    public void onBoxCreate(Bundle bundle) {
        super.onBoxCreate(bundle);
        this.title = getIntent().getExtras().getString(EXTRA_TITLE);
        this.message = getIntent().getExtras().getString(EXTRA_MESSAGE);
        String string = getIntent().getExtras().getString(EXTRA_BUTTON_TEXT);
        this.btnText = string;
        if (string == null) {
            this.btnText = CommonBoxUtil.LS(R.string.button_ok);
        }
        setMainText(this.title, this.message);
        initializeButtons();
    }

    private void setMainText(String str, String str2) {
        if (str != null) {
            ((TextView) findViewById(R.id.dialog_title)).setText(str);
        }
        TextView textView = (TextView) findViewById(R.id.dialog_text);
        if (TextUtils.isEmpty(str2)) {
            textView.setVisibility(8);
        } else {
            textView.setText(str2);
        }
    }

    private void initializeButtons() {
        findViewById(R.id.btnOK).setOnClickListener(this);
        ((Button) findViewById(R.id.btnOK)).setText(this.btnText);
        findViewById(R.id.btnCancel).setVisibility(8);
    }

    public static Intent newInfoDialog(Context context, String str, String str2, String str3) {
        Intent intent = new Intent(context, (Class<?>) InfoDialogActivity.class);
        intent.putExtra(EXTRA_TITLE, str);
        intent.putExtra(EXTRA_MESSAGE, str2);
        intent.putExtra(EXTRA_BUTTON_TEXT, str3);
        return intent;
    }

    @Override // android.app.Activity
    protected Dialog onCreateDialog(int i) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this, 2132083682);
        builder.setIcon(android.R.drawable.ic_dialog_info);
        String str = this.title;
        if (str != null) {
            builder.setTitle(str);
        }
        builder.setMessage(this.message);
        builder.setPositiveButton(this.btnText, new DialogInterface.OnClickListener() { // from class: com.box.android.activities.InfoDialogActivity.1
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i2) {
                InfoDialogActivity.this.finish();
            }
        });
        AlertDialog alertDialogCreate = builder.create();
        alertDialogCreate.setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: com.box.android.activities.InfoDialogActivity.2
            @Override // android.content.DialogInterface.OnDismissListener
            public void onDismiss(DialogInterface dialogInterface) {
                InfoDialogActivity.this.finish();
            }
        });
        return alertDialogCreate;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        finish();
    }
}
