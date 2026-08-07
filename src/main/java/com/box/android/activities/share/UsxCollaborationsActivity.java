package com.box.android.activities.share;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import com.box.android.R;
import com.box.android.usx.fragments.CollaborationsFragment;
import com.box.android.usx.fragments.CollaboratorsRolesFragment;
import com.box.android.utilities.CollaborationUtils;
import com.box.androidsdk.content.models.BoxCollaborationItem;
import com.box.androidsdk.content.models.BoxIteratorCollaborations;
import com.box.androidsdk.content.models.BoxSession;
import com.box.androidsdk.content.utils.SdkUtils;

/* JADX INFO: loaded from: classes9.dex */
public class UsxCollaborationsActivity extends Hilt_UsxCollaborationsActivity {
    protected static final String TAG = "com.box.android.activities.share.UsxCollaborationsActivity";

    @Override // com.box.android.base.presentation.activities.BoxFragmentActivity
    protected Integer getActivityLayoutId() {
        return Integer.valueOf(R.layout.usx_activity_collaborations);
    }

    @Override // com.box.android.activities.share.UsxShareBaseActivity, com.box.android.base.presentation.activities.BoxFragmentActivity
    protected void onBoxCreate(Bundle bundle) {
        super.onBoxCreate(bundle);
        initToolbar();
        if (this.baseShareVM.getShareItem() == null || this.baseShareVM.getShareItem().getType() == null || !(this.baseShareVM.getShareItem() instanceof BoxCollaborationItem)) {
            this.mController.showToast(this, R.string.box_sharesdk_selected_item_not_expected_type);
            finish();
            return;
        }
        Fragment fragmentFindFragmentById = getSupportFragmentManager().findFragmentById(R.id.fragmentContainer);
        if (fragmentFindFragmentById == null || (fragmentFindFragmentById instanceof CollaborationsFragment)) {
            setupCollaborationsFragment();
        }
    }

    private void setupCollaborationsFragment() {
        FragmentTransaction fragmentTransactionBeginTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransactionBeginTransaction.setTransition(0);
        this.mFragment = CollaborationsFragment.newInstance((BoxCollaborationItem) this.baseShareVM.getShareItem());
        ((CollaborationsFragment) this.mFragment).setCallback(new CollaborationsFragment.CollaborationsFragmentCallback() { // from class: com.box.android.activities.share.UsxCollaborationsActivity$$ExternalSyntheticLambda0
            @Override // com.box.android.usx.fragments.CollaborationsFragment.CollaborationsFragmentCallback
            public final void notifySwitchToAccessRoleFragment() {
                this.f$0.switchToRolesFragment();
            }
        });
        fragmentTransactionBeginTransaction.replace(R.id.fragmentContainer, this.mFragment);
        fragmentTransactionBeginTransaction.commit();
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public void onBackPressed() {
        if (getSupportFragmentManager().findFragmentById(R.id.fragmentContainer) instanceof CollaboratorsRolesFragment) {
            setupCollaborationsFragment();
        } else {
            super.onBackPressed();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void switchToRolesFragment() {
        getSupportFragmentManager().beginTransaction().replace(R.id.fragmentContainer, CollaboratorsRolesFragment.newInstance()).commit();
    }

    public static Intent getLaunchIntent(Context context, BoxCollaborationItem boxCollaborationItem, BoxSession boxSession, BoxIteratorCollaborations boxIteratorCollaborations) {
        if (boxCollaborationItem == null || SdkUtils.isBlank(boxCollaborationItem.getUserId())) {
            throw new IllegalArgumentException("A valid collaboration item must be provided for retrieving collaborations");
        }
        if (boxSession == null || boxSession.getUser() == null || SdkUtils.isBlank(boxSession.getUser().getUserId())) {
            throw new IllegalArgumentException("A valid user must be provided for retrieving collaborations");
        }
        Intent intent = new Intent(context, (Class<?>) UsxCollaborationsActivity.class);
        intent.putExtra(CollaborationUtils.EXTRA_ITEM, boxCollaborationItem);
        intent.putExtra(CollaborationUtils.EXTRA_USER_ID, boxSession.getUser().getUserId());
        intent.putExtra(CollaborationUtils.EXTRA_COLLABORATIONS, boxIteratorCollaborations);
        return intent;
    }
}
