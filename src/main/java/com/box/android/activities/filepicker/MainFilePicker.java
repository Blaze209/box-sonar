package com.box.android.activities.filepicker;

import android.os.Bundle;
import android.widget.Toast;
import com.box.android.R;
import com.box.android.base.presentation.BoxFragmentInterface;
import com.box.androidsdk.content.models.BoxItem;

/* JADX INFO: loaded from: classes9.dex */
public class MainFilePicker extends Hilt_MainFilePicker {
    @Override // com.box.android.activities.MainPhone, com.box.android.activities.MainParent
    protected boolean shouldFabBeVisible(BoxFragmentInterface boxFragmentInterface) {
        return false;
    }

    @Override // com.box.android.activities.MainPhone, com.box.android.activities.MainParent, com.box.android.base.presentation.activities.BoxFragmentActivity
    public void onBoxCreate(Bundle bundle) {
        super.onBoxCreate(bundle);
        Toast.makeText(getApplicationContext(), R.string.select_a_file, 1).show();
    }

    @Override // com.box.android.activities.MainPhone, com.box.android.base.presentation.activities.BoxFragmentActivity, com.box.android.base.presentation.activities.Hilt_BoxFragmentActivity, com.box.android.base.presentation.activities.BoxSpinnerDialogFragmentActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, com.microsoft.intune.mam.client.app.MAMActivity, com.microsoft.intune.mam.client.app.HookedActivity
    public void onMAMDestroy() {
        super.onMAMDestroy();
        broadcastDismissSpinner();
    }

    @Override // com.box.android.activities.MainParent, com.box.android.base.presentation.activities.BoxFragmentActivity
    protected boolean onDifferentUserAccessed() {
        finish();
        return true;
    }

    @Override // com.box.android.activities.MainPhone, com.box.android.activities.MainParent, com.box.android.browse.fragments.BoxBrowseFragment.OnItemClickListener
    public void onItemClick(BoxItem boxItem) {
        this.mItemActionHandler.onItemPicked(boxItem);
    }
}
