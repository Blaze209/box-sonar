package com.box.android.activities;

import android.content.Intent;
import androidx.lifecycle.ViewModelProvider;
import com.box.android.R;
import com.box.android.base.presentation.ThumbnailManager;
import com.box.android.browse.cpl.itempicker.ItemPickerActivity;
import com.box.android.coreservices.modelcontroller.messages.BoxUserAuthenticationMessage;
import com.box.androidsdk.content.models.BoxBookmark;
import com.box.androidsdk.content.models.BoxFile;
import com.box.androidsdk.content.models.BoxFolder;
import javax.inject.Inject;

/* JADX INFO: loaded from: classes9.dex */
public class CreateBoxItemShortcutActivity extends Hilt_CreateBoxItemShortcutActivity {

    @Inject
    ThumbnailManager mThumbnailManager;

    @Override // com.box.android.base.presentation.activities.ShortcutEntryActivity
    public int getAuthErrorMessageRes() {
        return R.string.to_choose_files_from_box_you_need_to_stay_logged_into_the_Box_app;
    }

    @Override // com.box.android.base.presentation.activities.Hilt_BoxFragmentActivity, androidx.activity.ComponentActivity, androidx.lifecycle.HasDefaultViewModelProviderFactory
    public /* bridge */ /* synthetic */ ViewModelProvider.Factory getDefaultViewModelProviderFactory() {
        return super.getDefaultViewModelProviderFactory();
    }

    private void setupShortcut() {
        startActivityForResult(ItemPickerActivity.getLaunchIntent(this), 0);
    }

    @Override // com.box.android.base.presentation.activities.BoxFragmentActivity
    protected void handleOnActivityResult(int i, int i2, Intent intent) {
        if (i2 == -1) {
            intent.setExtrasClassLoader(getClassLoader());
            BoxFile boxFile = (BoxFile) intent.getSerializableExtra(ItemPickerActivity.EXTRA_FILE);
            BoxFolder boxFolder = (BoxFolder) intent.getSerializableExtra(ItemPickerActivity.EXTRA_FOLDER);
            BoxBookmark boxBookmark = (BoxBookmark) intent.getSerializableExtra(ItemPickerActivity.EXTRA_WEB_LINK);
            if (boxFile != null) {
                setResult(-1, BoxItemShortcutActivity.getFileShortcutIntent(this, boxFile, this.mThumbnailManager));
            } else if (boxFolder != null) {
                setResult(-1, BoxItemShortcutActivity.getFolderShortcutIntent(this, boxFolder, this.mThumbnailManager));
            } else if (boxBookmark != null) {
                setResult(-1, BoxItemShortcutActivity.getWebLinkShortcutIntent(this, boxBookmark, this.mThumbnailManager));
            }
        }
        super.handleOnActivityResult(i, i2, intent);
        finish();
    }

    @Override // com.box.android.base.presentation.activities.ShortcutEntryActivity, com.box.android.base.presentation.activities.BoxEntrypointActivity
    protected void onAuthenticated(BoxUserAuthenticationMessage boxUserAuthenticationMessage) {
        String action = getIntent().getAction();
        if (boxUserAuthenticationMessage.wasSuccessful() && "android.intent.action.CREATE_SHORTCUT".equals(action)) {
            setupShortcut();
        } else {
            super.onAuthenticated(boxUserAuthenticationMessage);
        }
    }
}
