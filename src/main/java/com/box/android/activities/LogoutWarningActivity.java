package com.box.android.activities;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import androidx.lifecycle.ViewModelProvider;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;
import com.box.android.R;
import com.box.android.application.BoxBaseApplication;
import com.box.android.common.utilities.CommonBoxUtil;
import com.box.android.coreservices.modelcontroller.messages.BoxSwitchUserMessage;
import com.box.android.domain.identity.IUserContextManager;
import com.box.androidsdk.content.utils.BoxLogUtils;
import com.microsoft.intune.mam.client.content.MAMBroadcastReceiver;

/* JADX INFO: loaded from: classes9.dex */
public class LogoutWarningActivity extends Hilt_LogoutWarningActivity implements View.OnClickListener {
    private static final String EXTRA_BUTTON_TEXT = "extraButtonText";
    private static final String EXTRA_MESSAGE = "extraMessage";
    private static final String EXTRA_TITLE = "extraTitle";
    private String btnText;
    private BroadcastReceiver mControllerReceiver;
    private LocalBroadcastManager mLocalBroadcastManager;

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
        return Integer.valueOf(R.layout.layout_dialog_confirm);
    }

    @Override // com.box.android.base.presentation.activities.BoxFragmentActivity
    public void onBoxInitialize(Bundle bundle) {
        super.onBoxInitialize(bundle);
        if (getUserInfo() == null) {
            finish();
            return;
        }
        String string = getIntent().getExtras().getString(EXTRA_TITLE);
        String string2 = getIntent().getExtras().getString(EXTRA_MESSAGE);
        String string3 = getIntent().getExtras().getString(EXTRA_BUTTON_TEXT);
        this.btnText = string3;
        if (string == null) {
            string = "";
        }
        if (string3 == null) {
            this.btnText = CommonBoxUtil.LS(R.string.button_ok);
        }
        setMainText(string, string2, "", false);
        initializeButtons();
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction(BoxSwitchUserMessage.ACTION_DESTROYED_USER);
        this.mControllerReceiver = new MAMBroadcastReceiver() { // from class: com.box.android.activities.LogoutWarningActivity.1
            @Override // com.microsoft.intune.mam.client.content.HookedBroadcastReceiver
            public void onMAMReceive(Context context, Intent intent) {
                LogoutWarningActivity.this.broadcastDismissSpinner();
                LogoutWarningActivity.this.finish();
            }
        };
        LocalBroadcastManager localBroadcastManager = LocalBroadcastManager.getInstance(this);
        this.mLocalBroadcastManager = localBroadcastManager;
        localBroadcastManager.registerReceiver(this.mControllerReceiver, intentFilter);
    }

    private void setMainText(String str, String str2, String str3, boolean z) {
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
        findViewById(R.id.btnCancel).setOnClickListener(new View.OnClickListener() { // from class: com.box.android.activities.LogoutWarningActivity.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                LogoutWarningActivity.this.finish();
            }
        });
    }

    public static Intent newInstance(Context context, String str, String str2, String str3) {
        Intent intent = new Intent(context, (Class<?>) LogoutWarningActivity.class);
        intent.putExtra(EXTRA_TITLE, str);
        intent.putExtra(EXTRA_MESSAGE, str2);
        intent.putExtra(EXTRA_BUTTON_TEXT, str3);
        return intent;
    }

    public static void showLogout() {
        Intent intentNewInstance = newInstance(BoxBaseApplication.getInstance(), CommonBoxUtil.LS(R.string.Log_Out), CommonBoxUtil.LS(R.string.Logging_out_will_reset_your_settings_and_clear_your_cache), CommonBoxUtil.LS(R.string.Log_Out));
        intentNewInstance.setFlags(805306368);
        BoxBaseApplication.getInstance().startActivity(intentNewInstance);
    }

    /* JADX WARN: Type inference failed for: r1v3, types: [com.box.android.activities.LogoutWarningActivity$3] */
    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        showSpinner(CommonBoxUtil.LS(R.string.Please_wait_clearing_user_information));
        new Thread() { // from class: com.box.android.activities.LogoutWarningActivity.3
            @Override // java.lang.Thread, java.lang.Runnable
            public void run() {
                BoxLogUtils.i(IUserContextManager.LOGOUT_ALL_USERS, "Initiated by user action.");
                LogoutWarningActivity.this.mUserContextManager.destroyAllUsers();
            }
        }.start();
    }

    @Override // com.box.android.base.presentation.activities.BoxFragmentActivity, com.box.android.base.presentation.activities.Hilt_BoxFragmentActivity, com.box.android.base.presentation.activities.BoxSpinnerDialogFragmentActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, com.microsoft.intune.mam.client.app.MAMActivity, com.microsoft.intune.mam.client.app.HookedActivity
    public void onMAMDestroy() {
        super.onMAMDestroy();
        LocalBroadcastManager localBroadcastManager = this.mLocalBroadcastManager;
        if (localBroadcastManager != null) {
            localBroadcastManager.unregisterReceiver(this.mControllerReceiver);
        }
    }
}
