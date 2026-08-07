package com.box.android.activities;

import android.content.Intent;
import androidx.lifecycle.ViewModelProvider;
import com.box.android.R;
import com.box.android.activities.filepicker.MainFilePicker;
import com.box.android.base.presentation.BoxPresentationUtils;
import com.box.android.common.utilities.IntentConstants;
import com.box.android.coreservices.modelcontroller.messages.BoxUserAuthenticationMessage;

/* JADX INFO: loaded from: classes9.dex */
public class IntentProcessorGetContent extends Hilt_IntentProcessorGetContent {
    @Override // com.box.android.base.presentation.activities.Hilt_BoxFragmentActivity, androidx.activity.ComponentActivity, androidx.lifecycle.HasDefaultViewModelProviderFactory
    public /* bridge */ /* synthetic */ ViewModelProvider.Factory getDefaultViewModelProviderFactory() {
        return super.getDefaultViewModelProviderFactory();
    }

    @Override // com.box.android.base.presentation.activities.BoxEntrypointActivity
    protected void onAuthenticated(BoxUserAuthenticationMessage boxUserAuthenticationMessage) {
        if (boxUserAuthenticationMessage.wasSuccessful()) {
            Intent intent = new Intent();
            intent.setClass(this, MainFilePicker.class);
            intent.putExtra(IntentConstants.EXTRA_INIT_FOLDER_ID, "0");
            intent.putExtra(IntentConstants.EXTRA_FILE_PICKER_MODE, true);
            intent.addFlags(33554432);
            startActivity(intent);
        } else {
            BoxPresentationUtils.displayToast(R.string.to_choose_files_from_box_you_need_to_stay_logged_into_the_Box_app, this, new String[0]);
        }
        finish();
    }
}
