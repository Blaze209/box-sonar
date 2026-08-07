package com.box.android.activities;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.Process;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import androidx.appcompat.app.AlertDialog;
import androidx.lifecycle.ViewModelProvider;
import com.box.android.R;
import com.box.android.application.BoxBaseApplication;
import com.box.android.common.utilities.CommonBoxUtil;
import com.box.android.coreservices.models.BoxAccountManager;
import com.box.android.coreservices.services.IntentServices;
import com.box.android.domain.configuration.BoxConfigConstants;
import com.box.android.utilities.BoxUtils;
import com.google.android.material.dialog.MaterialAlertDialogBuilder;
import javax.inject.Inject;

/* JADX INFO: loaded from: classes9.dex */
public class ExpiredVersionDialogActivity extends Hilt_ExpiredVersionDialogActivity implements View.OnClickListener {
    private static final String EXTRA_BUTTON_TEXT = "extraButtonText";
    private static final String EXTRA_MESSAGE = "extraMessage";
    private static final String EXTRA_TITLE = "extraTitle";
    private String btnText;

    @Inject
    protected IntentServices mIntentServices;
    private String message;
    private String title;

    @Override // com.box.android.base.presentation.activities.BoxFragmentActivity
    protected boolean requiresAuthToken() {
        return false;
    }

    @Override // com.box.android.base.presentation.activities.BoxFragmentActivity
    protected boolean requiresPinCode() {
        return false;
    }

    @Override // com.box.android.base.presentation.activities.Hilt_BoxFragmentActivity, androidx.activity.ComponentActivity, androidx.lifecycle.HasDefaultViewModelProviderFactory
    public /* bridge */ /* synthetic */ ViewModelProvider.Factory getDefaultViewModelProviderFactory() {
        return super.getDefaultViewModelProviderFactory();
    }

    @Override // com.box.android.base.presentation.activities.BoxFragmentActivity
    protected Integer getActivityLayoutId() {
        return Integer.valueOf(R.layout.layout_dialog_confirm);
    }

    @Override // com.box.android.base.presentation.activities.BoxFragmentActivity
    public void onBoxCreate(Bundle bundle) {
        super.onBoxCreate(bundle);
        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            this.title = extras.getString(EXTRA_TITLE);
            this.message = extras.getString(EXTRA_MESSAGE);
            this.btnText = extras.getString(EXTRA_BUTTON_TEXT);
        }
        if (this.title == null) {
            this.title = "";
        }
        if (this.btnText == null) {
            this.btnText = CommonBoxUtil.LS(R.string.button_ok);
        }
        setMainText(this.title, this.message);
        initializeButtons();
    }

    private void setMainText(String str, String str2) {
        TextView textView = (TextView) findViewById(R.id.dialog_title);
        TextView textView2 = (TextView) findViewById(R.id.dialog_text);
        textView.setText(str);
        if (str2.equals("")) {
            textView2.setVisibility(8);
        } else {
            textView2.setText(str2);
        }
    }

    private void initializeButtons() {
        findViewById(R.id.btnOK).setOnClickListener(this);
        ((Button) findViewById(R.id.btnOK)).setText(this.btnText);
        findViewById(R.id.btnCancel).setVisibility(8);
    }

    public static Intent newInstance(Context context, String str, String str2, String str3) {
        Intent intent = new Intent(context, (Class<?>) ExpiredVersionDialogActivity.class);
        intent.putExtra(EXTRA_TITLE, str);
        intent.putExtra(EXTRA_MESSAGE, str2);
        intent.putExtra(EXTRA_BUTTON_TEXT, str3);
        intent.setFlags(268435456);
        return intent;
    }

    @Override // android.app.Activity
    protected Dialog onCreateDialog(int i) {
        MaterialAlertDialogBuilder materialAlertDialogBuilder = new MaterialAlertDialogBuilder(this);
        materialAlertDialogBuilder.setIcon(android.R.drawable.ic_dialog_info);
        String str = this.title;
        if (str != null) {
            materialAlertDialogBuilder.setTitle((CharSequence) str);
        }
        materialAlertDialogBuilder.setMessage((CharSequence) this.message);
        materialAlertDialogBuilder.setPositiveButton((CharSequence) this.btnText, new DialogInterface.OnClickListener() { // from class: com.box.android.activities.ExpiredVersionDialogActivity.1
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i2) {
                ExpiredVersionDialogActivity.this.finish();
            }
        });
        AlertDialog alertDialogCreate = materialAlertDialogBuilder.create();
        alertDialogCreate.setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: com.box.android.activities.ExpiredVersionDialogActivity.2
            @Override // android.content.DialogInterface.OnDismissListener
            public void onDismiss(DialogInterface dialogInterface) {
                ExpiredVersionDialogActivity.this.finish();
            }
        });
        return alertDialogCreate;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.btnText.equals(CommonBoxUtil.LS(R.string.Get_Update))) {
            BoxUtils.reviewApplicationAction(this);
        }
    }

    @Override // com.box.android.base.presentation.activities.BoxFragmentActivity, com.box.android.base.presentation.activities.Hilt_BoxFragmentActivity, com.box.android.base.presentation.activities.BoxSpinnerDialogFragmentActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, com.microsoft.intune.mam.client.app.MAMActivity, com.microsoft.intune.mam.client.app.HookedActivity
    public void onMAMDestroy() {
        super.onMAMDestroy();
        if (BoxBaseApplication.getInstance().getConfigManager().getBoolean(BoxConfigConstants.CONFIG_KEY_UTEST_BOOL).booleanValue()) {
            Process.killProcess(Process.myPid());
        } else {
            BoxAccountManager.checkMinimumVersion(this.mNotificationServices, this.mIntentServices, 1, getUserSharedPrefs());
        }
    }
}
