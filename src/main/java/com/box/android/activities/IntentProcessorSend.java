package com.box.android.activities;

import android.content.Intent;
import androidx.lifecycle.ViewModelProvider;
import com.box.android.R;
import com.box.android.browse.activities.UploadToFolderActivity;
import com.box.android.common.utilities.CommonBoxUtil;
import com.box.android.coreservices.modelcontroller.messages.BoxUserAuthenticationMessage;
import com.box.android.coreservices.models.BoxStaticUploadModel;
import com.box.android.coreservices.utilities.CoreServiceUtils;
import com.box.android.domain.usecases.jobs.JobTags;
import com.box.android.utilities.notificationmanager.BoxNotificationHelper;

/* JADX INFO: loaded from: classes9.dex */
public class IntentProcessorSend extends Hilt_IntentProcessorSend {
    @Override // com.box.android.base.presentation.activities.Hilt_BoxFragmentActivity, androidx.activity.ComponentActivity, androidx.lifecycle.HasDefaultViewModelProviderFactory
    public /* bridge */ /* synthetic */ ViewModelProvider.Factory getDefaultViewModelProviderFactory() {
        return super.getDefaultViewModelProviderFactory();
    }

    @Override // com.box.android.base.presentation.activities.BoxEntrypointActivity
    public void onAuthenticated(BoxUserAuthenticationMessage boxUserAuthenticationMessage) {
        if (boxUserAuthenticationMessage.wasSuccessful()) {
            if (getIntent() != null) {
                processIntent();
            }
        } else {
            BoxNotificationHelper.displayDialog(CommonBoxUtil.LS(R.string.LS_Error), CommonBoxUtil.LS(R.string.LS_Please_register));
            finish();
        }
    }

    private void processIntent() {
        showSpinner();
        new Thread() { // from class: com.box.android.activities.IntentProcessorSend.1
            @Override // java.lang.Thread, java.lang.Runnable
            public void run() {
                boolean z;
                Intent intent = IntentProcessorSend.this.getIntent();
                if (intent == null) {
                    return;
                }
                try {
                    CoreServiceUtils.logcatIntent(intent);
                    BoxStaticUploadModel.parseIntent(intent, IntentProcessorSend.this.mBoxExtendedApiFolder, IntentProcessorSend.this.mBaseMoco, IntentProcessorSend.this.mUserContextManager);
                    IntentProcessorSend.this.setIntent(null);
                    z = false;
                } catch (Exception unused) {
                    z = true;
                }
                try {
                    IntentProcessorSend.this.broadcastDismissSpinner();
                } catch (Exception unused2) {
                }
                if (!BoxStaticUploadModel.isUploading() || z) {
                    BoxNotificationHelper.displayDialog(R.string.this_file_type_or_application_is_currently_not_supported);
                    IntentProcessorSend.this.finish();
                } else {
                    Intent launchIntent = UploadToFolderActivity.getLaunchIntent(IntentProcessorSend.this, null, JobTags.JobSource.SHARE_SHEET);
                    launchIntent.setFlags(intent.getFlags() | 603979776);
                    IntentProcessorSend.this.finish();
                    IntentProcessorSend.this.startActivity(launchIntent);
                }
            }
        }.start();
    }
}
