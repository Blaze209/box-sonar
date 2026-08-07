package com.box.android.usx.fragments;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import com.box.android.R;
import com.box.android.databinding.UsxFragmentSharedLinkBinding;
import com.box.android.domain.analytics.BoxAmplitudeAnalytics;
import com.box.android.domain.analytics.BoxAnalyticsParams;
import com.box.android.utilities.CollaborationUtils;
import com.box.android.vm.ActionbarTitleVM;
import com.box.android.vm.CollaboratorsInitialsVM;
import com.box.android.vm.PresenterData;
import com.box.android.vm.ShareVMFactory;
import com.box.android.vm.SharedLinkVM;
import com.box.androidsdk.content.models.BoxCollaboration;
import com.box.androidsdk.content.models.BoxCollaborationItem;
import com.box.androidsdk.content.models.BoxCollaborator;
import com.box.androidsdk.content.models.BoxItem;
import com.box.androidsdk.content.models.BoxIteratorCollaborations;
import com.microsoft.intune.mam.client.content.MAMClipboard;
import java.util.EnumSet;

/* JADX INFO: loaded from: classes13.dex */
public class UsxFragment extends BoxShareFragment {
    private static final String UNSHARE_WARNING_TAG = "com.box.sharesdk.unshare_warning";
    private UsxFragmentSharedLinkBinding binding;
    CollaboratorsInitialsVM mInitialsVM;
    private ClickListener mListener;
    private SharedLinkVM mSharedLinkVm;
    private Observer<PresenterData<BoxItem>> onBoxItemComplete = new Observer() { // from class: com.box.android.usx.fragments.UsxFragment$$ExternalSyntheticLambda1
        @Override // androidx.lifecycle.Observer
        public final void onChanged(Object obj) {
            this.f$0.lambda$new$5((PresenterData) obj);
        }
    };

    public interface ClickListener {
        void collabsClicked();

        void editAccessClicked();

        void inviteCollabsClicked();
    }

    public interface RefreshUserRole {
        void refresh();
    }

    public interface UsxNotifiers {
        void linkClicked();

        void notifyShare();

        void notifyUnshare();
    }

    @Override // com.box.android.usx.fragments.BoxShareFragment
    public Class<SharedLinkVM> getVMClass() {
        return SharedLinkVM.class;
    }

    @Override // com.box.android.usx.fragments.BoxShareFragment
    protected void setTitles() {
        ActionbarTitleVM actionbarTitleVM = (ActionbarTitleVM) new ViewModelProvider(getActivity()).get(ActionbarTitleVM.class);
        actionbarTitleVM.setTitle(this.mSharedLinkVm.getShareItem().getName());
        actionbarTitleVM.setSubtitle(CollaborationUtils.getSubtitleForItemType(getContext(), this.mSharedLinkVm.getShareItem().getType()));
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        UsxFragmentSharedLinkBinding usxFragmentSharedLinkBinding = (UsxFragmentSharedLinkBinding) DataBindingUtil.inflate(layoutInflater, R.layout.usx_fragment_shared_link, viewGroup, false);
        this.binding = usxFragmentSharedLinkBinding;
        return usxFragmentSharedLinkBinding.getRoot();
    }

    @Override // com.box.android.usx.fragments.BoxShareFragment, androidx.fragment.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        this.mInitialsVM = (CollaboratorsInitialsVM) new ViewModelProvider(getActivity(), ((BoxShareFragment.ShareVMFactoryProvider) getActivity()).getShareVMFactory()).get(CollaboratorsInitialsVM.class);
        this.mSharedLinkVm = (SharedLinkVM) new ViewModelProvider(getActivity(), ((BoxShareFragment.ShareVMFactoryProvider) getActivity()).getShareVMFactory()).get(SharedLinkVM.class);
        setupListeners();
        setTitles();
        this.mSharedLinkVm.getItemInfo().observe(getViewLifecycleOwner(), this.onBoxItemComplete);
        this.mSharedLinkVm.getSharedLinkedItem().observe(getViewLifecycleOwner(), this.onBoxItemComplete);
        this.binding.setIsAllowedToInviteCollaborator(true);
        this.binding.setIsAllowedToShare(true);
        this.binding.setShareItem(this.mSharedLinkVm.getShareItem());
        this.binding.setUsxNotifier(new UsxNotifiers() { // from class: com.box.android.usx.fragments.UsxFragment.1
            @Override // com.box.android.usx.fragments.UsxFragment.UsxNotifiers
            public void notifyUnshare() {
                UsxFragment.this.displayUnshareWarning();
            }

            @Override // com.box.android.usx.fragments.UsxFragment.UsxNotifiers
            public void notifyShare() {
                UsxFragment.this.logEvent(BoxAnalyticsParams.EVENT_SHARE_LINK_ENABLED);
                UsxFragment.this.createDefaultShareItem();
            }

            @Override // com.box.android.usx.fragments.UsxFragment.UsxNotifiers
            public void linkClicked() {
                UsxFragment.this.copyLink();
            }
        });
        this.binding.setOnShareViaListener(new View.OnClickListener() { // from class: com.box.android.usx.fragments.UsxFragment$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$onActivityCreated$0(view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onActivityCreated$0(View view) {
        logEvent(BoxAnalyticsParams.EVENT_SHARE_SEND_LINK);
        showShareVia();
    }

    private boolean isAllowedToInvite() {
        EnumSet<BoxItem.Permission> permissions = this.mSharedLinkVm.getShareItem().getPermissions();
        return permissions != null && permissions.contains(BoxItem.Permission.CAN_INVITE_COLLABORATOR);
    }

    private boolean isAllowedToShare() {
        EnumSet<BoxItem.Permission> permissions = this.mSharedLinkVm.getShareItem().getPermissions();
        return permissions != null && permissions.contains(BoxItem.Permission.CAN_SHARE);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$setupListeners$1(View view) {
        this.mListener.inviteCollabsClicked();
    }

    private void setupListeners() {
        this.binding.setOnInviteCollabsClickListener(new View.OnClickListener() { // from class: com.box.android.usx.fragments.UsxFragment$$ExternalSyntheticLambda2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$setupListeners$1(view);
            }
        });
        this.binding.setOnEditAccessClickListener(new View.OnClickListener() { // from class: com.box.android.usx.fragments.UsxFragment$$ExternalSyntheticLambda3
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$setupListeners$2(view);
            }
        });
        this.binding.setOnCollabsListener(new View.OnClickListener() { // from class: com.box.android.usx.fragments.UsxFragment$$ExternalSyntheticLambda4
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$setupListeners$3(view);
            }
        });
        this.binding.setOnCopyLinkListener(new View.OnClickListener() { // from class: com.box.android.usx.fragments.UsxFragment$$ExternalSyntheticLambda5
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$setupListeners$4(view);
            }
        });
        this.binding.initialViews.setArguments(this.mInitialsVM, new RefreshUserRole() { // from class: com.box.android.usx.fragments.UsxFragment$$ExternalSyntheticLambda6
            @Override // com.box.android.usx.fragments.UsxFragment.RefreshUserRole
            public final void refresh() {
                this.f$0.refreshUserRole();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$setupListeners$2(View view) {
        this.mListener.editAccessClicked();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$setupListeners$3(View view) {
        this.mListener.collabsClicked();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$setupListeners$4(View view) {
        logEvent(BoxAnalyticsParams.EVENT_SHARE_COPY_LINK);
        copyLink();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void logEvent(String str) {
        BoxAmplitudeAnalytics.createShareEventBuilder().logEvent(str);
    }

    @Override // androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        showSpinner(0L);
        SharedLinkVM sharedLinkVM = this.mSharedLinkVm;
        sharedLinkVM.fetchItemInfo(sharedLinkVM.getShareItem());
        refreshInitialsViews();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$new$5(PresenterData presenterData) {
        if (presenterData.isHandled()) {
            return;
        }
        dismissSpinner();
        if (presenterData.isSuccess() && presenterData.getData() != null) {
            setShareItem((BoxItem) presenterData.getData());
            return;
        }
        if (presenterData.getStrCode() != -1) {
            showToast(presenterData.getStrCode());
        }
        refreshUI();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void refreshUI() {
        this.binding.setShareItem(this.mSharedLinkVm.getShareItem());
        this.binding.setIsAllowedToInviteCollaborator(isAllowedToInvite());
        this.binding.setIsAllowedToShare(isAllowedToShare());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void refreshUserRole() {
        this.binding.setUserRole(getUserRole());
    }

    private BoxCollaboration.Role getUserRole() {
        BoxIteratorCollaborations<BoxCollaboration> collaborationsValue = this.mInitialsVM.getCollaborationsValue();
        if (collaborationsValue == null) {
            return null;
        }
        for (BoxCollaboration boxCollaboration : collaborationsValue) {
            BoxCollaborator accessibleBy = boxCollaboration.getAccessibleBy();
            if (accessibleBy != null && accessibleBy.getUserId().equals(this.mSharedLinkVm.getUserId())) {
                return boxCollaboration.getRole();
            }
        }
        return null;
    }

    public void refreshInitialsViews() {
        UsxFragmentSharedLinkBinding usxFragmentSharedLinkBinding = this.binding;
        if (usxFragmentSharedLinkBinding == null || usxFragmentSharedLinkBinding.initialViews == null) {
            return;
        }
        this.binding.initialViews.refreshView();
    }

    public static UsxFragment newInstance(BoxItem boxItem, ClickListener clickListener, ShareVMFactory shareVMFactory) {
        Bundle bundle = BoxShareFragment.getBundle(boxItem);
        UsxFragment usxFragment = new UsxFragment();
        usxFragment.setArguments(bundle);
        usxFragment.mListener = clickListener;
        return usxFragment;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void createDefaultShareItem() {
        showSpinner(R.string.box_sharesdk_enabling_share_link);
        SharedLinkVM sharedLinkVM = this.mSharedLinkVm;
        sharedLinkVM.createDefaultSharedLink((BoxCollaborationItem) sharedLinkVM.getShareItem());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void disableShareItem() {
        showSpinner(R.string.box_sharesdk_disabling_share_link);
        SharedLinkVM sharedLinkVM = this.mSharedLinkVm;
        sharedLinkVM.disableSharedLink((BoxCollaborationItem) sharedLinkVM.getShareItem());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void copyLink() {
        if (this.mSharedLinkVm.getShareItem().getSharedLink() != null) {
            MAMClipboard.setPrimaryClip((ClipboardManager) getActivity().getSystemService("clipboard"), ClipData.newPlainText("", this.mSharedLinkVm.getShareItem().getSharedLink().getURL()));
            showToast(R.string.box_sharesdk_link_copied_to_clipboard);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void displayUnshareWarning() {
        if (getFragmentManager().findFragmentByTag(UNSHARE_WARNING_TAG) != null) {
            return;
        }
        PositiveNegativeDialogFragment.createFragment(R.string.box_sharesdk_disable_title, R.string.box_sharesdk_disable_message, R.string.box_sharesdk_disable_share_link, R.string.box_sharesdk_cancel, new PositiveNegativeDialogFragment.OnPositiveOrNegativeButtonClickedListener() { // from class: com.box.android.usx.fragments.UsxFragment.2
            @Override // com.box.android.usx.fragments.PositiveNegativeDialogFragment.OnPositiveOrNegativeButtonClickedListener
            public void onPositiveButtonClicked(PositiveNegativeDialogFragment positiveNegativeDialogFragment) {
                UsxFragment.this.logEvent(BoxAnalyticsParams.EVENT_SHARE_LINK_DISABLED);
                UsxFragment.this.disableShareItem();
            }

            @Override // com.box.android.usx.fragments.PositiveNegativeDialogFragment.OnPositiveOrNegativeButtonClickedListener
            public void onNegativeButtonClicked(PositiveNegativeDialogFragment positiveNegativeDialogFragment) {
                UsxFragment.this.refreshUI();
            }
        }).show(getActivity().getSupportFragmentManager(), UNSHARE_WARNING_TAG);
    }

    public void setShareItem(BoxItem boxItem) {
        this.mSharedLinkVm.setShareItem(boxItem);
        refreshUI();
    }

    private void showShareVia() {
        Intent intent = new Intent("android.intent.action.SEND");
        intent.setType("text/plain");
        intent.putExtra("android.intent.extra.SUBJECT", String.format(getString(R.string.box_sharesdk_I_have_shared_x_with_you), this.mSharedLinkVm.getShareItem().getName()));
        intent.putExtra("android.intent.extra.TEXT", this.mSharedLinkVm.getShareItem().getSharedLink().getURL());
        intent.setFlags(335544320);
        startActivity(Intent.createChooser(intent, getString(R.string.box_sharesdk_send_with)));
    }
}
