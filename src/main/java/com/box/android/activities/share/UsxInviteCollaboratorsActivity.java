package com.box.android.activities.share;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import androidx.core.app.NotificationManagerCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import com.box.android.R;
import com.box.android.base.presentation.fragments.BaseFTUX;
import com.box.android.domain.localrepo.ILocalSharedPreferences;
import com.box.android.usx.fragments.CollaboratorsRolesFragment;
import com.box.android.usx.fragments.InviteCollaboratorsFragment;
import com.box.android.utilities.CollaborationUtils;
import com.box.android.vm.SelectRoleShareVM;
import com.box.androidsdk.content.models.BoxCollaborationItem;
import com.box.androidsdk.content.models.BoxItem;
import com.box.androidsdk.content.models.BoxSession;
import com.box.androidsdk.content.utils.SdkUtils;
import java.util.Objects;

/* JADX INFO: loaded from: classes9.dex */
public class UsxInviteCollaboratorsActivity extends Hilt_UsxInviteCollaboratorsActivity {
    private static final String EXTRA_NOTIFICATION_ID = "ShareBaseActivity.NotificationId";
    private int mNotifId = -1;
    SelectRoleShareVM selectRoleShareVM;

    @Override // com.box.android.base.presentation.activities.BoxFragmentActivity
    protected Integer getActivityLayoutId() {
        return Integer.valueOf(R.layout.usx_activity_invite_collaborators);
    }

    @Override // com.box.android.activities.share.UsxShareBaseActivity, com.box.android.base.presentation.activities.BoxFragmentActivity
    protected void onBoxCreate(Bundle bundle) {
        super.onBoxCreate(bundle);
        if (getIntent() != null) {
            this.mNotifId = getIntent().getIntExtra(EXTRA_NOTIFICATION_ID, -1);
        }
        if (this.mNotifId != -1) {
            NotificationManagerCompat.from(this).cancel(getIntent().getIntExtra(EXTRA_NOTIFICATION_ID, -1));
        }
        this.selectRoleShareVM = (SelectRoleShareVM) new ViewModelProvider(this).get(SelectRoleShareVM.class);
        initToolbar();
        Fragment fragmentFindFragmentById = getSupportFragmentManager().findFragmentById(R.id.fragmentContainer);
        if (fragmentFindFragmentById == null || (fragmentFindFragmentById instanceof InviteCollaboratorsFragment)) {
            setupInviteCollabFragment();
        }
    }

    private void setupInviteCollabFragment() {
        FragmentTransaction fragmentTransactionBeginTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransactionBeginTransaction.setTransition(0);
        this.mFragment = InviteCollaboratorsFragment.newInstance((BoxCollaborationItem) this.baseShareVM.getShareItem(), new InviteCollaboratorsFragment.ClickListener() { // from class: com.box.android.activities.share.UsxInviteCollaboratorsActivity.1
            @Override // com.box.android.usx.fragments.InviteCollaboratorsFragment.ClickListener
            public void editAccessClicked() {
                UsxInviteCollaboratorsActivity.this.selectRoleShareVM.setAllowOwnerRole(false);
                UsxInviteCollaboratorsActivity.this.selectRoleShareVM.setAllowRemove(false);
                UsxInviteCollaboratorsActivity.this.selectRoleShareVM.setCollaboration(null);
                FragmentTransaction fragmentTransactionBeginTransaction2 = UsxInviteCollaboratorsActivity.this.getSupportFragmentManager().beginTransaction();
                fragmentTransactionBeginTransaction2.setTransition(0);
                fragmentTransactionBeginTransaction2.replace(R.id.fragmentContainer, CollaboratorsRolesFragment.newInstance(), CollaboratorsRolesFragment.TAG);
                UsxInviteCollaboratorsActivity.this.selectRoleShareVM.setShowSend(false);
                fragmentTransactionBeginTransaction2.commit();
            }
        });
        fragmentTransactionBeginTransaction.replace(R.id.fragmentContainer, this.mFragment, InviteCollaboratorsFragment.TAG);
        fragmentTransactionBeginTransaction.commit();
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public void onBackPressed() {
        if (getSupportFragmentManager().findFragmentById(R.id.fragmentContainer) instanceof CollaboratorsRolesFragment) {
            setupInviteCollabFragment();
            this.selectRoleShareVM.setShowSend(true);
        } else {
            super.onBackPressed();
        }
    }

    @Override // android.app.Activity
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_invite_collaborators, menu);
        return true;
    }

    @Override // com.microsoft.intune.mam.client.app.MAMActivity, com.microsoft.intune.mam.client.app.HookedActivity
    public boolean onMAMPrepareOptionsMenu(Menu menu) {
        final MenuItem menuItemFindItem = menu.findItem(R.id.box_sharesdk_action_send);
        LiveData<Boolean> liveDataIsShowSend = this.selectRoleShareVM.isShowSend();
        Objects.requireNonNull(menuItemFindItem);
        liveDataIsShowSend.observe(this, new Observer() { // from class: com.box.android.activities.share.UsxInviteCollaboratorsActivity$$ExternalSyntheticLambda0
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                menuItemFindItem.setVisible(((Boolean) obj).booleanValue());
            }
        });
        this.selectRoleShareVM.isSendInvitationEnabled().observe(this, new Observer() { // from class: com.box.android.activities.share.UsxInviteCollaboratorsActivity$$ExternalSyntheticLambda1
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                UsxInviteCollaboratorsActivity.lambda$onPrepareOptionsMenu$0(menuItemFindItem, (Boolean) obj);
            }
        });
        return super.onMAMPrepareOptionsMenu(menu);
    }

    static /* synthetic */ void lambda$onPrepareOptionsMenu$0(MenuItem menuItem, Boolean bool) {
        if (bool.booleanValue()) {
            menuItem.setEnabled(true);
        } else {
            menuItem.setEnabled(false);
        }
    }

    @Override // android.app.Activity
    public boolean onOptionsItemSelected(MenuItem menuItem) {
        if (menuItem.getItemId() == R.id.box_sharesdk_action_send) {
            ((InviteCollaboratorsFragment) this.mFragment).addCollaborations();
            this.mUserContextManager.getUserSharedPrefs(ILocalSharedPreferences.PreferenceName.FTUX).edit().putBoolean(BaseFTUX.SHARED_PREF_KEY_SHARING_OR_COLLAB_USED, true);
        }
        return super.onOptionsItemSelected(menuItem);
    }

    public static Intent getLaunchIntent(Context context, BoxItem boxItem, BoxSession boxSession) {
        if (boxItem == null || SdkUtils.isBlank(boxItem.getUserId())) {
            throw new IllegalArgumentException("A valid folder must be provided for retrieving collaborations");
        }
        if (boxSession == null || boxSession.getUser() == null || SdkUtils.isBlank(boxSession.getUser().getUserId())) {
            throw new IllegalArgumentException("A valid user must be provided for retrieving collaborations");
        }
        Intent intent = new Intent(context, (Class<?>) UsxInviteCollaboratorsActivity.class);
        intent.putExtra(CollaborationUtils.EXTRA_ITEM, boxItem);
        intent.putExtra(CollaborationUtils.EXTRA_USER_ID, boxSession.getUser().getUserId());
        return intent;
    }

    public static Intent getLaunchIntentForNotification(Context context, BoxItem boxItem, BoxSession boxSession, int i) {
        Intent launchIntent = getLaunchIntent(context, boxItem, boxSession);
        launchIntent.putExtra(EXTRA_NOTIFICATION_ID, i);
        return launchIntent;
    }
}
