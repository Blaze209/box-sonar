package com.box.android.usx.fragments;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import com.box.android.R;
import com.box.android.databinding.UsxFragmentCollaborationsBinding;
import com.box.android.domain.analytics.BoxAmplitudeAnalytics;
import com.box.android.domain.analytics.BoxAnalyticsParams;
import com.box.android.usx.adapters.CollaboratorsAdapter;
import com.box.android.utilities.CollaborationUtils;
import com.box.android.vm.ActionbarTitleVM;
import com.box.android.vm.CollaborationsShareVM;
import com.box.android.vm.PresenterData;
import com.box.android.vm.SelectRoleShareVM;
import com.box.androidsdk.content.BoxException;
import com.box.androidsdk.content.models.BoxCollaboration;
import com.box.androidsdk.content.models.BoxCollaborationItem;
import com.box.androidsdk.content.models.BoxCollaborator;
import com.box.androidsdk.content.models.BoxFolder;
import com.box.androidsdk.content.models.BoxItem;
import com.box.androidsdk.content.models.BoxIteratorCollaborations;
import com.box.androidsdk.content.models.BoxVoid;
import com.box.androidsdk.content.requests.BoxRequest;
import com.box.androidsdk.content.requests.BoxRequestsShare;
import com.box.androidsdk.content.utils.BoxLogUtils;
import com.box.androidsdk.content.utils.SdkUtils;
import com.google.android.material.dialog.MaterialAlertDialogBuilder;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes13.dex */
public class CollaborationsFragment extends BoxShareFragment implements AdapterView.OnItemClickListener {
    protected static final String TAG = "com.box.android.usx.fragments.CollaborationsFragment";
    private UsxFragmentCollaborationsBinding binding;
    private CollaborationsFragmentCallback mCallback;
    private CollaborationsShareVM mCollaborationsShareVM;
    private CollaboratorsAdapter mCollaboratorsAdapter;
    private SelectRoleShareVM mSelectRoleShareVM;
    private Observer<PresenterData<BoxCollaboration>> onUpdateCollaboration = new Observer() { // from class: com.box.android.usx.fragments.CollaborationsFragment$$ExternalSyntheticLambda0
        @Override // androidx.lifecycle.Observer
        public final void onChanged(Object obj) {
            this.f$0.lambda$new$2((PresenterData) obj);
        }
    };
    private Observer<PresenterData<BoxItem>> onBoxItemComplete = new Observer() { // from class: com.box.android.usx.fragments.CollaborationsFragment$$ExternalSyntheticLambda1
        @Override // androidx.lifecycle.Observer
        public final void onChanged(Object obj) {
            this.f$0.lambda$new$3((PresenterData) obj);
        }
    };
    private Observer<PresenterData<BoxIteratorCollaborations>> onCollaborationsChange = new Observer() { // from class: com.box.android.usx.fragments.CollaborationsFragment$$ExternalSyntheticLambda2
        @Override // androidx.lifecycle.Observer
        public final void onChanged(Object obj) {
            this.f$0.lambda$new$4((PresenterData) obj);
        }
    };
    private Observer<PresenterData<BoxCollaborationItem>> onRoleItemChange = new Observer() { // from class: com.box.android.usx.fragments.CollaborationsFragment$$ExternalSyntheticLambda3
        @Override // androidx.lifecycle.Observer
        public final void onChanged(Object obj) {
            this.f$0.lambda$new$5((PresenterData) obj);
        }
    };
    private Observer<PresenterData<BoxVoid>> onUpdateOwnerCollaboration = new Observer() { // from class: com.box.android.usx.fragments.CollaborationsFragment$$ExternalSyntheticLambda4
        @Override // androidx.lifecycle.Observer
        public final void onChanged(Object obj) {
            this.f$0.lambda$new$6((PresenterData) obj);
        }
    };
    private Observer<PresenterData<BoxRequest>> onDeleteCollaboration = new Observer() { // from class: com.box.android.usx.fragments.CollaborationsFragment$$ExternalSyntheticLambda5
        @Override // androidx.lifecycle.Observer
        public final void onChanged(Object obj) {
            this.f$0.lambda$new$7((PresenterData) obj);
        }
    };

    public interface CollaborationsFragmentCallback {
        void notifySwitchToAccessRoleFragment();
    }

    static /* synthetic */ void lambda$onResume$1(DialogInterface dialogInterface, int i) {
    }

    @Override // com.box.android.usx.fragments.BoxShareFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
    }

    @Override // com.box.android.usx.fragments.BoxShareFragment
    public Class<CollaborationsShareVM> getVMClass() {
        return CollaborationsShareVM.class;
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        setTitles();
        UsxFragmentCollaborationsBinding usxFragmentCollaborationsBinding = (UsxFragmentCollaborationsBinding) DataBindingUtil.inflate(layoutInflater, R.layout.usx_fragment_collaborations, viewGroup, false);
        this.binding = usxFragmentCollaborationsBinding;
        return usxFragmentCollaborationsBinding.getRoot();
    }

    @Override // com.box.android.usx.fragments.BoxShareFragment, androidx.fragment.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        this.mCollaborationsShareVM = (CollaborationsShareVM) new ViewModelProvider(getActivity(), ((BoxShareFragment.ShareVMFactoryProvider) getActivity()).getShareVMFactory()).get(CollaborationsShareVM.class);
        this.mSelectRoleShareVM = (SelectRoleShareVM) new ViewModelProvider(getActivity()).get(SelectRoleShareVM.class);
        this.binding.collaboratorsList.setDivider(null);
        this.mCollaboratorsAdapter = new CollaboratorsAdapter(getActivity(), this.mCollaborationsShareVM);
        this.binding.collaboratorsList.setAdapter((ListAdapter) this.mCollaboratorsAdapter);
        this.binding.collaboratorsList.setOnItemClickListener(this);
        this.mCollaborationsShareVM.getCollaborations().observe(getViewLifecycleOwner(), this.onCollaborationsChange);
        this.mCollaborationsShareVM.getRoleItem().observe(getViewLifecycleOwner(), this.onRoleItemChange);
        this.mCollaborationsShareVM.getUpdateCollaboration().observe(getViewLifecycleOwner(), this.onUpdateCollaboration);
        this.mCollaborationsShareVM.getUpdateOwner().observe(getViewLifecycleOwner(), this.onUpdateOwnerCollaboration);
        this.mCollaborationsShareVM.getDeleteCollaboration().observe(getViewLifecycleOwner(), this.onDeleteCollaboration);
        this.mCollaborationsShareVM.getItemInfo().observe(getViewLifecycleOwner(), this.onBoxItemComplete);
        if (getItem().getAllowedInviteeRoles() == null) {
            fetchRoles();
        }
        if (this.mCollaborationsShareVM.getCachedCollaborations() == null) {
            fetchCollaborations();
        } else {
            this.mCollaboratorsAdapter.setItems(this.mCollaborationsShareVM.getCachedCollaborations());
        }
        updateView();
    }

    @Override // androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        if (this.mSelectRoleShareVM.isRemoveSelected()) {
            showSpinner(0L);
            this.mCollaborationsShareVM.deleteCollaboration(this.mSelectRoleShareVM.getCollaboration());
            this.mSelectRoleShareVM.setRemoveSelected(false);
        } else {
            if (this.mSelectRoleShareVM.getSelectedRole().getValue() == null || this.mSelectRoleShareVM.getCollaboration() == null || this.mSelectRoleShareVM.getSelectedRole().getValue() == this.mSelectRoleShareVM.getCollaboration().getRole()) {
                return;
            }
            if (this.mSelectRoleShareVM.getSelectedRole().getValue() == BoxCollaboration.Role.OWNER) {
                new MaterialAlertDialogBuilder(getActivity()).setTitle(R.string.box_sharesdk_change_owner_alert_title).setMessage(R.string.box_sharesdk_change_owner_alert_message).setPositiveButton(android.R.string.yes, new DialogInterface.OnClickListener() { // from class: com.box.android.usx.fragments.CollaborationsFragment$$ExternalSyntheticLambda6
                    @Override // android.content.DialogInterface.OnClickListener
                    public final void onClick(DialogInterface dialogInterface, int i) {
                        this.f$0.lambda$onResume$0(dialogInterface, i);
                    }
                }).setNegativeButton(android.R.string.no, new DialogInterface.OnClickListener() { // from class: com.box.android.usx.fragments.CollaborationsFragment$$ExternalSyntheticLambda7
                    @Override // android.content.DialogInterface.OnClickListener
                    public final void onClick(DialogInterface dialogInterface, int i) {
                        CollaborationsFragment.lambda$onResume$1(dialogInterface, i);
                    }
                }).setIcon(android.R.drawable.ic_dialog_alert).show();
            } else {
                showSpinner(0L);
                this.mCollaborationsShareVM.updateCollaboration(this.mSelectRoleShareVM.getCollaboration(), this.mSelectRoleShareVM.getSelectedRole().getValue());
            }
            this.mSelectRoleShareVM.setSelectedRole(null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onResume$0(DialogInterface dialogInterface, int i) {
        showSpinner(R.string.box_sharesdk_fetching_collaborators);
        this.mCollaborationsShareVM.updateOwner(this.mSelectRoleShareVM.getCollaboration());
    }

    public void setCallback(CollaborationsFragmentCallback collaborationsFragmentCallback) {
        this.mCallback = collaborationsFragmentCallback;
    }

    @Override // com.box.android.usx.fragments.BoxShareFragment
    public void addResult(Intent intent) {
        intent.putExtra(CollaborationUtils.EXTRA_OWNER_UPDATED, this.mCollaborationsShareVM.isOwnerUpdated());
        super.addResult(intent);
    }

    @Override // com.box.android.usx.fragments.BoxShareFragment
    protected void setTitles() {
        ActionbarTitleVM actionbarTitleVM = (ActionbarTitleVM) new ViewModelProvider(getActivity()).get(ActionbarTitleVM.class);
        actionbarTitleVM.setTitle(getString(R.string.box_sharesdk_shared_with));
        actionbarTitleVM.setSubtitle(null);
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        String userName;
        BoxCollaboration boxCollaboration = (BoxCollaboration) this.mCollaboratorsAdapter.getItem(i);
        if (boxCollaboration != null) {
            BoxCollaboration.Role role = boxCollaboration.getRole();
            logCollaboratorViewed(role);
            ArrayList<BoxCollaboration.Role> roles = getRoles();
            BoxCollaborator accessibleBy = boxCollaboration.getAccessibleBy();
            String id = accessibleBy == null ? "" : accessibleBy.getUserId();
            if (roles == null) {
                showToast(R.string.box_sharesdk_network_error);
                return;
            }
            if (roles.size() == 0 && !id.equals(this.mCollaborationsShareVM.getUserId())) {
                showToast(R.string.box_sharesdk_cannot_get_collaborators);
                return;
            }
            if (accessibleBy == null) {
                userName = boxCollaboration.getInviteEmail();
                if (userName == null || userName.isEmpty()) {
                    userName = getString(R.string.box_sharesdk_another_person);
                }
            } else {
                userName = accessibleBy.getUserName();
            }
            boolean zEquals = getItem().getOwnedBy().getUserId().equals(this.mCollaborationsShareVM.getUserId());
            if (zEquals) {
                zEquals = getItem() instanceof BoxFolder;
            }
            if (roles.isEmpty() && role != null) {
                roles.add(role);
            }
            if (role != null && !roles.contains(role)) {
                roles.add(role);
            }
            this.mSelectRoleShareVM.setSelectedRole(role);
            this.mSelectRoleShareVM.setRoles(roles);
            this.mSelectRoleShareVM.setName(userName);
            this.mSelectRoleShareVM.setAllowRemove(true);
            this.mSelectRoleShareVM.setAllowOwnerRole(zEquals);
            this.mSelectRoleShareVM.setCollaboration(boxCollaboration);
            this.mCallback.notifySwitchToAccessRoleFragment();
        }
    }

    private void logCollaboratorViewed(BoxCollaboration.Role role) {
        BoxAmplitudeAnalytics.ShareEventPropertyBuilder shareEventPropertyBuilderCreateShareEventBuilder = BoxAmplitudeAnalytics.createShareEventBuilder();
        shareEventPropertyBuilderCreateShareEventBuilder.setAccessType(role);
        shareEventPropertyBuilderCreateShareEventBuilder.logEvent(BoxAnalyticsParams.EVENT_SHARE_COLLABORATOR_VIEWED);
    }

    public BoxCollaborationItem getItem() {
        return (BoxCollaborationItem) this.mCollaborationsShareVM.getShareItem();
    }

    public void fetchCollaborations() {
        if (getItem() == null || SdkUtils.isBlank(getItem().getUserId())) {
            showToast(R.string.box_sharesdk_cannot_view_collaborations);
        } else {
            showSpinner(R.string.box_sharesdk_fetching_collaborators);
            this.mCollaborationsShareVM.fetchCollaborations(getItem());
        }
    }

    private void fetchRoles() {
        if (getItem() == null || SdkUtils.isBlank(getItem().getUserId())) {
            return;
        }
        showSpinner(R.string.box_sharesdk_fetching_collaborators);
        this.mCollaborationsShareVM.fetchRoles(getItem());
    }

    public ArrayList<BoxCollaboration.Role> getRoles() {
        return getItem().getAllowedInviteeRoles();
    }

    public static CollaborationsFragment newInstance(BoxCollaborationItem boxCollaborationItem) {
        Bundle bundle = BoxShareFragment.getBundle(boxCollaborationItem);
        CollaborationsFragment collaborationsFragment = new CollaborationsFragment();
        collaborationsFragment.setArguments(bundle);
        return collaborationsFragment;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$new$2(PresenterData presenterData) {
        if (presenterData.isHandled()) {
            return;
        }
        dismissSpinner();
        if (presenterData.isSuccess()) {
            BoxCollaborator accessibleBy = ((BoxCollaboration) presenterData.getData()).getAccessibleBy();
            if ((accessibleBy == null ? "" : accessibleBy.getUserId()).equals(this.mCollaborationsShareVM.getUserId())) {
                CollaborationsShareVM collaborationsShareVM = this.mCollaborationsShareVM;
                collaborationsShareVM.fetchItemInfo(collaborationsShareVM.getShareItem());
            }
            this.mCollaboratorsAdapter.update((BoxCollaboration) presenterData.getData());
            this.mCollaborationsShareVM.setCachedCollaborations(this.mCollaboratorsAdapter.getBoxCollaborationList());
            return;
        }
        BoxLogUtils.e(CollaborationsFragment.class.getName(), "Update Collaborator request failed", presenterData.getException());
        if (presenterData.getStrCode() != -1) {
            showToast(presenterData.getStrCode());
        }
        if (presenterData.getException() instanceof BoxException) {
            logBoxException((BoxException) presenterData.getException(), R.string.box_sharesdk_cannot_get_collaborators);
        }
    }

    private void logBoxException(BoxException boxException, int i) {
        BoxLogUtils.logException("UpdateCollabError", getString(i) + boxException.getErrorType() + " " + boxException.getResponseCode(), boxException);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$new$3(PresenterData presenterData) {
        if (presenterData.isHandled()) {
            return;
        }
        dismissSpinner();
        if (presenterData.isSuccess()) {
            this.mCollaborationsShareVM.setShareItem((BoxItem) presenterData.getData());
            fetchCollaborations();
        } else if (presenterData.getStrCode() != -1) {
            showToast(presenterData.getStrCode());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$new$4(PresenterData presenterData) {
        if (presenterData.isHandled()) {
            return;
        }
        dismissSpinner();
        if (presenterData.isSuccess()) {
            this.mCollaboratorsAdapter.setItems((BoxIteratorCollaborations) presenterData.getData());
            this.mCollaborationsShareVM.setCachedCollaborations(this.mCollaboratorsAdapter.getBoxCollaborationList());
            updateView();
        } else {
            BoxLogUtils.e(CollaborationsFragment.class.getName(), "Fetch Collaborators request failed", presenterData.getException());
            if (presenterData.getStrCode() != -1) {
                showToast(presenterData.getStrCode());
            }
            BoxLogUtils.logException("CollaborationsError", getString(R.string.box_sharesdk_cannot_get_collaborators) + presenterData.getException(), presenterData.getException());
        }
    }

    private void updateView() {
        if (this.mCollaboratorsAdapter.getCount() > 0) {
            showHasCollabsView();
        } else if (this.mCollaborationsShareVM.getCachedCollaborations() != null) {
            showNoCollabView();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$new$5(PresenterData presenterData) {
        if (presenterData.isHandled()) {
            return;
        }
        dismissSpinner();
        if (presenterData.isSuccess()) {
            this.mCollaborationsShareVM.setShareItem((BoxItem) presenterData.getData());
        } else {
            BoxLogUtils.e(CollaborationsFragment.class.getName(), "Fetch roles request failed", presenterData.getException());
            showToast(presenterData.getStrCode());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$new$6(PresenterData presenterData) {
        if (presenterData.isHandled()) {
            return;
        }
        dismissSpinner();
        if (presenterData.isSuccess()) {
            this.mCollaborationsShareVM.setOwnerUpdated(true);
            getActivity().finish();
        } else {
            BoxLogUtils.e(CollaborationsFragment.class.getName(), "Update Owner request failed", presenterData.getException());
            if (presenterData.getStrCode() != -1) {
                showToast(presenterData.getStrCode());
            }
            BoxLogUtils.logException("UpdateOwner", getString(R.string.box_sharesdk_cannot_get_collaborators), presenterData.getException());
        }
    }

    private void showHasCollabsView() {
        this.binding.collaboratorsList.setVisibility(0);
        this.binding.noCollaboratorsText.setVisibility(8);
    }

    private void showNoCollabView() {
        this.binding.collaboratorsList.setVisibility(8);
        this.binding.noCollaboratorsText.setVisibility(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$new$7(PresenterData presenterData) {
        if (presenterData.isHandled()) {
            return;
        }
        dismissSpinner();
        if (presenterData.isSuccess()) {
            this.mCollaboratorsAdapter.delete(((BoxRequestsShare.DeleteCollaboration) presenterData.getData()).getId());
            this.mCollaborationsShareVM.setCachedCollaborations(this.mCollaboratorsAdapter.getBoxCollaborationList());
            updateView();
            return;
        }
        BoxLogUtils.e(CollaborationsFragment.class.getName(), "Delete Collaborator request failed", presenterData.getException());
        showToast(presenterData.getStrCode());
    }
}
