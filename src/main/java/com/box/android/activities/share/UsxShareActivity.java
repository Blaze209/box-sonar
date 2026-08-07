package com.box.android.activities.share;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import com.box.android.R;
import com.box.android.domain.analytics.BoxAmplitudeAnalytics;
import com.box.android.domain.analytics.BoxAnalyticsParams;
import com.box.android.usx.fragments.SharedLinkAccessFragment;
import com.box.android.usx.fragments.UsxFragment;
import com.box.android.utilities.CollaborationUtils;
import com.box.androidsdk.content.models.BoxCollaborationItem;
import com.box.androidsdk.content.models.BoxItem;
import com.box.androidsdk.content.models.BoxSession;

/* JADX INFO: loaded from: classes9.dex */
public class UsxShareActivity extends Hilt_UsxShareActivity {
    private static int REQUEST_COLLABORATORS = 32;

    @Override // com.box.android.base.presentation.activities.BoxFragmentActivity
    protected Integer getActivityLayoutId() {
        return Integer.valueOf(R.layout.usx_activity_usx);
    }

    @Override // com.box.android.base.presentation.activities.BoxSpinnerDialogFragmentActivity
    public boolean amplitudeSetCurrentPage() {
        return BoxAmplitudeAnalytics.getInstance().setCurrentPage(BoxAnalyticsParams.PAGE_NAME_SHARE);
    }

    @Override // com.box.android.activities.share.UsxShareBaseActivity, com.box.android.base.presentation.activities.BoxFragmentActivity
    protected void onBoxCreate(Bundle bundle) {
        super.onBoxCreate(bundle);
        initToolbar();
        Fragment fragmentFindFragmentById = getSupportFragmentManager().findFragmentById(R.id.fragmentContainer);
        if (fragmentFindFragmentById == null || (fragmentFindFragmentById instanceof UsxFragment)) {
            setupUsxFragment();
        }
    }

    private void setupUsxFragment() {
        FragmentTransaction fragmentTransactionBeginTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransactionBeginTransaction.setTransition(0);
        this.mFragment = UsxFragment.newInstance(this.baseShareVM.getShareItem(), new UsxFragment.ClickListener() { // from class: com.box.android.activities.share.UsxShareActivity.1
            @Override // com.box.android.usx.fragments.UsxFragment.ClickListener
            public void editAccessClicked() {
                UsxShareActivity.this.setupSharedLinkAccessFragment();
            }

            @Override // com.box.android.usx.fragments.UsxFragment.ClickListener
            public void inviteCollabsClicked() {
                UsxShareActivity usxShareActivity = UsxShareActivity.this;
                usxShareActivity.startActivityForResult(UsxInviteCollaboratorsActivity.getLaunchIntent(usxShareActivity, (BoxCollaborationItem) usxShareActivity.baseShareVM.getShareItem(), UsxShareActivity.this.mBoxSession), UsxShareActivity.REQUEST_COLLABORATORS);
            }

            @Override // com.box.android.usx.fragments.UsxFragment.ClickListener
            public void collabsClicked() {
                UsxShareActivity usxShareActivity = UsxShareActivity.this;
                usxShareActivity.startActivityForResult(UsxCollaborationsActivity.getLaunchIntent(usxShareActivity, (BoxCollaborationItem) usxShareActivity.baseShareVM.getShareItem(), UsxShareActivity.this.mBoxSession, null), UsxShareActivity.REQUEST_COLLABORATORS);
            }
        }, this.mVMFactory);
        fragmentTransactionBeginTransaction.replace(R.id.fragmentContainer, this.mFragment);
        fragmentTransactionBeginTransaction.commit();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setupSharedLinkAccessFragment() {
        FragmentTransaction fragmentTransactionBeginTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransactionBeginTransaction.setTransition(0);
        fragmentTransactionBeginTransaction.replace(R.id.fragmentContainer, SharedLinkAccessFragment.newInstance(this.baseShareVM.getShareItem()));
        fragmentTransactionBeginTransaction.commit();
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public void onBackPressed() {
        if (getSupportFragmentManager().findFragmentById(R.id.fragmentContainer) instanceof SharedLinkAccessFragment) {
            setupUsxFragment();
        } else {
            super.onBackPressed();
        }
    }

    public static Intent getLaunchIntent(Context context, BoxItem boxItem, BoxSession boxSession) {
        if (boxSession == null || boxSession.getUser() == null) {
            throw new IllegalArgumentException("Invalid user associated with Box session.");
        }
        Intent intent = new Intent(context, (Class<?>) UsxShareActivity.class);
        intent.putExtra(CollaborationUtils.EXTRA_ITEM, boxItem);
        intent.putExtra(CollaborationUtils.EXTRA_USER_ID, boxSession.getUser().getUserId());
        return intent;
    }
}
