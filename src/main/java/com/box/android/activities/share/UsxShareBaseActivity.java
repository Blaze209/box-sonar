package com.box.android.activities.share;

import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;
import androidx.activity.EdgeToEdge;
import androidx.appcompat.widget.Toolbar;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import com.box.android.R;
import com.box.android.base.presentation.activities.BoxFragmentActivity;
import com.box.android.coreservices.api.ShareController;
import com.box.android.coreservices.modelcontroller.messages.BoxMessage;
import com.box.android.coreservices.modelcontroller.messages.BoxResponseMessage;
import com.box.android.data.api.utils.UpdateSharedLinkPasswordErrorConverter;
import com.box.android.data.datasource.LegacyCacheDataSource;
import com.box.android.repo.ShareRepo;
import com.box.android.usx.fragments.BoxShareFragment;
import com.box.android.utilities.CollaborationUtils;
import com.box.android.vm.ActionbarTitleVM;
import com.box.android.vm.BaseShareVM;
import com.box.android.vm.PresenterData;
import com.box.android.vm.ShareVMFactory;
import com.box.androidsdk.content.models.BoxCollaborationItem;
import com.box.androidsdk.content.models.BoxItem;
import com.box.androidsdk.content.models.BoxIteratorCollaborations;
import com.box.androidsdk.content.models.BoxObject;
import com.box.androidsdk.content.requests.BoxRequestsBookmark;
import com.box.androidsdk.content.requests.BoxRequestsFile;
import com.box.androidsdk.content.requests.BoxRequestsFolder;
import com.box.androidsdk.content.utils.SdkUtils;
import java.util.Objects;
import javax.inject.Inject;

/* JADX INFO: loaded from: classes9.dex */
public abstract class UsxShareBaseActivity extends BoxFragmentActivity implements BoxShareFragment.ShareVMFactoryProvider {
    protected BaseShareVM baseShareVM;

    @Inject
    protected ShareController mController;
    protected BoxShareFragment mFragment;

    @Inject
    public LegacyCacheDataSource mLegacyCacheDataSource;
    protected ShareVMFactory mVMFactory;

    @Inject
    protected UpdateSharedLinkPasswordErrorConverter updateSharedLinkPasswordErrorConverter;

    @Override // com.box.android.base.presentation.activities.Hilt_BoxFragmentActivity, androidx.activity.ComponentActivity, androidx.lifecycle.HasDefaultViewModelProviderFactory
    public /* bridge */ /* synthetic */ ViewModelProvider.Factory getDefaultViewModelProviderFactory() {
        return super.getDefaultViewModelProviderFactory();
    }

    @Override // com.box.android.base.presentation.activities.BoxFragmentActivity
    protected void onBoxCreate(Bundle bundle) {
        String stringExtra;
        BoxItem boxItem;
        super.onBoxCreate(bundle);
        if (bundle != null && bundle.getSerializable(CollaborationUtils.EXTRA_ITEM) != null) {
            stringExtra = bundle.getString(CollaborationUtils.EXTRA_USER_ID);
            boxItem = (BoxItem) bundle.getSerializable(CollaborationUtils.EXTRA_ITEM);
        } else if (getIntent() != null) {
            stringExtra = getIntent().getStringExtra(CollaborationUtils.EXTRA_USER_ID);
            boxItem = (BoxItem) getIntent().getSerializableExtra(CollaborationUtils.EXTRA_ITEM);
        } else {
            stringExtra = null;
            boxItem = null;
        }
        if (SdkUtils.isBlank(stringExtra)) {
            showToast(R.string.box_sharesdk_session_is_not_authenticated);
            finish();
        } else {
            if (boxItem == null) {
                showToast(R.string.box_sharesdk_no_item_selected);
                finish();
                return;
            }
            this.mVMFactory = new ShareVMFactory(new ShareRepo(this.mController, this.updateSharedLinkPasswordErrorConverter, this.mLegacyCacheDataSource), (BoxCollaborationItem) boxItem);
            BaseShareVM baseShareVM = (BaseShareVM) new ViewModelProvider(this, this.mVMFactory).get(BaseShareVM.class);
            this.baseShareVM = baseShareVM;
            baseShareVM.fetchItemInfo(baseShareVM.getShareItem());
            this.baseShareVM.getItemInfo().observe(this, new Observer() { // from class: com.box.android.activities.share.UsxShareBaseActivity$$ExternalSyntheticLambda3
                @Override // androidx.lifecycle.Observer
                public final void onChanged(Object obj) {
                    this.f$0.lambda$onBoxCreate$0((PresenterData) obj);
                }
            });
            EdgeToEdge.enable(this);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onBoxCreate$0(PresenterData presenterData) {
        if (!presenterData.isSuccess() || presenterData.getData() == null) {
            return;
        }
        this.baseShareVM.setShareItem((BoxItem) presenterData.getData());
    }

    @Override // android.app.Activity
    public void finish() {
        Intent intent = new Intent();
        BoxShareFragment boxShareFragment = this.mFragment;
        if (boxShareFragment != null) {
            boxShareFragment.addResult(intent);
        }
        setResult(-1, intent);
        super.finish();
    }

    @Override // com.box.android.base.presentation.activities.BoxFragmentActivity, com.box.android.base.presentation.activities.BoxSpinnerDialogFragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, com.microsoft.intune.mam.client.app.MAMActivity, com.microsoft.intune.mam.client.app.HookedActivity
    public void onMAMSaveInstanceState(Bundle bundle) {
        bundle.putSerializable(CollaborationUtils.EXTRA_ITEM, this.baseShareVM.getShareItem());
        bundle.putString(CollaborationUtils.EXTRA_USER_ID, this.mBoxSession.getUser().getUserId());
        super.onMAMSaveInstanceState(bundle);
    }

    @Override // com.box.android.base.presentation.activities.BoxFragmentActivity
    protected void processBoxMessage(BoxMessage<?> boxMessage) {
        if (boxMessage.wasSuccessful() && (boxMessage instanceof BoxResponseMessage)) {
            BoxObject result = ((BoxResponseMessage) boxMessage).getResponse().getResult();
            if (result instanceof BoxItem) {
                BoxItem boxItem = (BoxItem) result;
                if (boxItem.getUserId().equals(this.baseShareVM.getShareItem().getUserId())) {
                    this.baseShareVM.setShareItem(boxItem);
                }
            }
        }
    }

    @Override // com.box.android.base.presentation.activities.BoxFragmentActivity
    public IntentFilter getIntentFilter() {
        IntentFilter intentFilter = super.getIntentFilter();
        intentFilter.addAction(BoxRequestsFolder.GetFolderWithAllItems.class.getName());
        intentFilter.addAction(BoxRequestsFile.GetFileInfo.class.getName());
        intentFilter.addAction(BoxRequestsFolder.GetFolderInfo.class.getName());
        intentFilter.addAction(BoxRequestsBookmark.GetBookmarkInfo.class.getName());
        intentFilter.addAction(BoxRequestsFolder.UpdateFolder.class.getName());
        return intentFilter;
    }

    protected void initToolbar() {
        final Toolbar toolbar = (Toolbar) findViewById(R.id.box_action_bar);
        setSupportActionBar(toolbar);
        toolbar.setNavigationIcon(R.drawable.ic_toolbar_back_btn);
        toolbar.setNavigationContentDescription(R.string.back_button_talkback_label);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() { // from class: com.box.android.activities.share.UsxShareBaseActivity$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$initToolbar$1(view);
            }
        });
        ActionbarTitleVM actionbarTitleVM = (ActionbarTitleVM) new ViewModelProvider(this).get(ActionbarTitleVM.class);
        LiveData<String> title = actionbarTitleVM.getTitle();
        Objects.requireNonNull(toolbar);
        title.observe(this, new Observer() { // from class: com.box.android.activities.share.UsxShareBaseActivity$$ExternalSyntheticLambda1
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                toolbar.setTitle((String) obj);
            }
        });
        LiveData<String> subtitle = actionbarTitleVM.getSubtitle();
        Objects.requireNonNull(toolbar);
        subtitle.observe(this, new Observer() { // from class: com.box.android.activities.share.UsxShareBaseActivity$$ExternalSyntheticLambda2
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                toolbar.setSubtitle((String) obj);
            }
        });
        if (toolbar.getTitle() == null) {
            toolbar.setTitle(getTitle());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$initToolbar$1(View view) {
        onBackPressed();
    }

    public static class ResultInterpreter {
        Intent mData;

        public ResultInterpreter(Intent intent) {
            this.mData = intent;
        }

        public BoxItem getBoxItem() {
            return (BoxItem) this.mData.getSerializableExtra(CollaborationUtils.EXTRA_ITEM);
        }

        public BoxIteratorCollaborations getCollaborations() {
            return (BoxIteratorCollaborations) this.mData.getSerializableExtra(CollaborationUtils.EXTRA_COLLABORATIONS);
        }

        public boolean isOwnerChanged() {
            return this.mData.getBooleanExtra(CollaborationUtils.EXTRA_OWNER_UPDATED, false);
        }
    }

    protected void showToast(String str) {
        Toast.makeText(this, str, 0).show();
    }

    protected void showToast(int i) {
        Toast.makeText(this, getString(i), 0).show();
    }

    @Override // com.box.android.usx.fragments.BoxShareFragment.ShareVMFactoryProvider
    public ViewModelProvider.Factory getShareVMFactory() {
        return this.mVMFactory;
    }
}
