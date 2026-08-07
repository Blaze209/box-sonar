package com.box.android.activities;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import androidx.lifecycle.ViewModelProvider;
import com.box.android.R;
import com.box.android.application.BoxBaseApplication;
import com.box.android.common.utilities.CommonBoxUtil;
import com.box.android.coreservices.modelcontroller.messages.BoxSwitchUserMessage;
import com.box.android.coreservices.models.BoxAccountManager;
import com.box.android.domain.configuration.BoxConfigConstants;

/* JADX INFO: loaded from: classes9.dex */
public class SwitchingAccountDialogActivity extends Hilt_SwitchingAccountDialogActivity {
    private static final String EXTRA_USER_ID_TO_SWITCH_TO = "extraUserIdToSwitchTo";

    @Override // com.box.android.base.presentation.activities.BoxFragmentActivity
    protected Integer getActivityLayoutId() {
        return null;
    }

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
    public void onBoxCreate(Bundle bundle) {
        super.onBoxCreate(bundle);
        if (!BoxBaseApplication.getInstance().getConfigManager().getBoolean(BoxConfigConstants.CONFIG_KEY_ACCOUNT_SWITCHING_ENABLED_BOOL).booleanValue()) {
            finish();
            return;
        }
        if (BoxAccountManager.isIntuneMAMEnabled(this.mUserContextManager.getUserSharedPrefs())) {
            setResult(100);
            finish();
            return;
        }
        Intent intent = getIntent();
        if (intent != null) {
            final String stringExtra = intent.getStringExtra(EXTRA_USER_ID_TO_SWITCH_TO);
            new Thread(new Runnable() { // from class: com.box.android.activities.SwitchingAccountDialogActivity$$ExternalSyntheticLambda0
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$onBoxCreate$0(stringExtra);
                }
            }).start();
        } else {
            finish();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onBoxCreate$0(String str) {
        showSpinner(CommonBoxUtil.LS(R.string.Please_wait_clearing_user_information));
        this.mUserContextManager.softSwitch(str);
        broadcastDismissSpinner();
    }

    @Override // com.box.android.base.presentation.activities.BoxFragmentActivity
    protected void onSwitchedUser(BoxSwitchUserMessage boxSwitchUserMessage) {
        setResult(-1, boxSwitchUserMessage);
        finish();
    }

    public static Intent newIntent(Context context, String str) {
        Intent intent = new Intent(context, (Class<?>) SwitchingAccountDialogActivity.class);
        intent.putExtra(EXTRA_USER_ID_TO_SWITCH_TO, str);
        return intent;
    }
}
