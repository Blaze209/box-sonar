package com.box.android.usx.fragments;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import com.box.android.R;
import com.box.android.databinding.UsxFragmentCollaborationRolesBinding;
import com.box.android.domain.analytics.BoxAmplitudeAnalytics;
import com.box.android.domain.analytics.BoxAnalyticsParams;
import com.box.android.vm.ActionbarTitleVM;
import com.box.android.vm.SelectRoleShareVM;
import com.box.androidsdk.content.models.BoxCollaboration;
import com.google.android.material.dialog.MaterialAlertDialogBuilder;

/* JADX INFO: loaded from: classes13.dex */
public class CollaboratorsRolesFragment extends Fragment {
    public static final String TAG = "com.box.android.usx.fragments.CollaboratorsRolesFragment";
    SelectRoleShareVM vm;

    public interface RoleUpdateNotifier {
        void notifyRemove();

        void setRole(BoxCollaboration.Role role);
    }

    private void setTitles() {
        ActionbarTitleVM actionbarTitleVM = (ActionbarTitleVM) new ViewModelProvider(getActivity()).get(ActionbarTitleVM.class);
        actionbarTitleVM.setTitle(getString(R.string.box_sharesdk_title_access_level));
        actionbarTitleVM.setSubtitle(null);
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        UsxFragmentCollaborationRolesBinding usxFragmentCollaborationRolesBinding = (UsxFragmentCollaborationRolesBinding) DataBindingUtil.inflate(layoutInflater, R.layout.usx_fragment_collaboration_roles, viewGroup, false);
        View root = usxFragmentCollaborationRolesBinding.getRoot();
        setTitles();
        SelectRoleShareVM selectRoleShareVM = (SelectRoleShareVM) new ViewModelProvider(getActivity()).get(SelectRoleShareVM.class);
        this.vm = selectRoleShareVM;
        usxFragmentCollaborationRolesBinding.setViewModel(selectRoleShareVM);
        usxFragmentCollaborationRolesBinding.setRoleUpdateNotifier(new RoleUpdateNotifier() { // from class: com.box.android.usx.fragments.CollaboratorsRolesFragment.1
            @Override // com.box.android.usx.fragments.CollaboratorsRolesFragment.RoleUpdateNotifier
            public void setRole(BoxCollaboration.Role role) {
                CollaboratorsRolesFragment collaboratorsRolesFragment = CollaboratorsRolesFragment.this;
                collaboratorsRolesFragment.logCollaborationUpdate(collaboratorsRolesFragment.vm.getSelectedRole().getValue(), role);
                CollaboratorsRolesFragment.this.vm.setSelectedRole(role);
            }

            @Override // com.box.android.usx.fragments.CollaboratorsRolesFragment.RoleUpdateNotifier
            public void notifyRemove() {
                CollaboratorsRolesFragment.this.showRemoveWarning();
            }
        });
        return root;
    }

    public static CollaboratorsRolesFragment newInstance() {
        return new CollaboratorsRolesFragment();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showRemoveWarning() {
        new MaterialAlertDialogBuilder(getActivity()).setTitle(R.string.box_sharesdk_title_remove_different_collaboration_folder).setMessage((CharSequence) getResources().getString(R.string.box_sharesdk_warn_remove_different_collaboration_folder, this.vm.getName(), this.vm.getCollaboration().getItem().getName())).setPositiveButton(android.R.string.yes, new DialogInterface.OnClickListener() { // from class: com.box.android.usx.fragments.CollaboratorsRolesFragment.3
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i) {
                CollaboratorsRolesFragment collaboratorsRolesFragment = CollaboratorsRolesFragment.this;
                collaboratorsRolesFragment.logCollaborationRemoved(collaboratorsRolesFragment.vm.getSelectedRole().getValue());
                CollaboratorsRolesFragment.this.vm.setRemoveSelected(true);
                CollaboratorsRolesFragment.this.getActivity().onBackPressed();
            }
        }).setNegativeButton(android.R.string.no, new DialogInterface.OnClickListener() { // from class: com.box.android.usx.fragments.CollaboratorsRolesFragment.2
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i) {
            }
        }).setIcon(android.R.drawable.ic_dialog_alert).show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void logCollaborationUpdate(BoxCollaboration.Role role, BoxCollaboration.Role role2) {
        BoxAmplitudeAnalytics.ShareEventPropertyBuilder shareEventPropertyBuilderCreateShareEventBuilder = BoxAmplitudeAnalytics.createShareEventBuilder();
        shareEventPropertyBuilderCreateShareEventBuilder.setAccessTypeUpdate(role, role2);
        shareEventPropertyBuilderCreateShareEventBuilder.logEvent(BoxAnalyticsParams.EVENT_SHARE_COLLABORATOR_UPDATED);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void logCollaborationRemoved(BoxCollaboration.Role role) {
        BoxAmplitudeAnalytics.ShareEventPropertyBuilder shareEventPropertyBuilderCreateShareEventBuilder = BoxAmplitudeAnalytics.createShareEventBuilder();
        shareEventPropertyBuilderCreateShareEventBuilder.setAccessType(role);
        shareEventPropertyBuilderCreateShareEventBuilder.logEvent(BoxAnalyticsParams.EVENT_SHARE_COLLABORATOR_REMOVED);
    }
}
