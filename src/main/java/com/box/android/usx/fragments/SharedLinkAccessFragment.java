package com.box.android.usx.fragments;

import android.app.DatePickerDialog;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.DatePicker;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import com.box.android.R;
import com.box.android.data.datasource.errors.ItemsRemoteError;
import com.box.android.data.datasource.errors.RemoteError;
import com.box.android.databinding.UsxFragmentSharedLinkAccessBinding;
import com.box.android.domain.utils.result.Result;
import com.box.android.vm.ActionbarTitleVM;
import com.box.android.vm.PresenterData;
import com.box.android.vm.SharedLinkVM;
import com.box.androidsdk.content.models.BoxCollaborationItem;
import com.box.androidsdk.content.models.BoxFile;
import com.box.androidsdk.content.models.BoxItem;
import com.box.androidsdk.content.models.BoxSharedLink;
import java.util.Date;
import java.util.GregorianCalendar;

/* JADX INFO: loaded from: classes13.dex */
public class SharedLinkAccessFragment extends BoxShareFragment {
    private static final String DATE_FRAGMENT_TAG = "datePicker";
    private static final String PASSWORD_FRAGMENT_TAG = "passwordFrag";
    private UsxFragmentSharedLinkAccessBinding binding;
    private SharedLinkVM mShareLinkVM;
    private final SharedLinkAccessNotifiers notifier = new SharedLinkAccessNotifiers() { // from class: com.box.android.usx.fragments.SharedLinkAccessFragment.1
        @Override // com.box.android.usx.fragments.SharedLinkAccessFragment.SharedLinkAccessNotifiers
        public void notifyAccessLevelChange(BoxSharedLink.Access access) {
            if (access == null || access == SharedLinkAccessFragment.this.mShareLinkVM.getShareItem().getSharedLink().getEffectiveAccess()) {
                return;
            }
            SharedLinkAccessFragment.this.changeAccess(access);
        }

        @Override // com.box.android.usx.fragments.SharedLinkAccessFragment.SharedLinkAccessNotifiers
        public void notifyPermissionChange(BoxSharedLink.Permission permission) {
            SharedLinkAccessFragment.this.changePermission(permission);
        }

        @Override // com.box.android.usx.fragments.SharedLinkAccessFragment.SharedLinkAccessNotifiers
        public void notifyRequirePassword(boolean z) {
            if (z) {
                SharedLinkAccessFragment.this.showPasswordChooserDialog();
            } else {
                SharedLinkAccessFragment.this.showSpinner(R.string.box_sharesdk_updating_link_access);
                SharedLinkAccessFragment.this.changePassword(null);
            }
        }

        @Override // com.box.android.usx.fragments.SharedLinkAccessFragment.SharedLinkAccessNotifiers
        public void notifyExpireLink(boolean z) {
            if (z) {
                SharedLinkAccessFragment.this.showDatePicker(new Date());
                return;
            }
            try {
                SharedLinkAccessFragment.this.showSpinner(R.string.box_sharesdk_updating_link_access);
                SharedLinkAccessFragment.this.mShareLinkVM.removeExpiryDate((BoxCollaborationItem) SharedLinkAccessFragment.this.mShareLinkVM.getShareItem());
            } catch (Exception unused) {
                SharedLinkAccessFragment.this.dismissSpinner();
            }
        }
    };
    private final Observer<PresenterData<BoxItem>> onBoxItemComplete = new Observer() { // from class: com.box.android.usx.fragments.SharedLinkAccessFragment$$ExternalSyntheticLambda0
        @Override // androidx.lifecycle.Observer
        public final void onChanged(Object obj) {
            this.f$0.lambda$new$2((PresenterData) obj);
        }
    };
    private final Observer<Result<BoxItem, RemoteError>> onSharedLinkChangePasswordCompleted = new Observer() { // from class: com.box.android.usx.fragments.SharedLinkAccessFragment$$ExternalSyntheticLambda1
        @Override // androidx.lifecycle.Observer
        public final void onChanged(Object obj) {
            this.f$0.lambda$new$3((Result) obj);
        }
    };

    public interface SharedLinkAccessNotifiers {
        void notifyAccessLevelChange(BoxSharedLink.Access access);

        void notifyExpireLink(boolean z);

        void notifyPermissionChange(BoxSharedLink.Permission permission);

        void notifyRequirePassword(boolean z);
    }

    @Override // com.box.android.usx.fragments.BoxShareFragment
    public Class<SharedLinkVM> getVMClass() {
        return SharedLinkVM.class;
    }

    @Override // com.box.android.usx.fragments.BoxShareFragment
    protected void setTitles() {
        ActionbarTitleVM actionbarTitleVM = (ActionbarTitleVM) new ViewModelProvider(requireActivity()).get(ActionbarTitleVM.class);
        actionbarTitleVM.setTitle(getString(R.string.box_sharesdk_title_link_access));
        actionbarTitleVM.setSubtitle(null);
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        UsxFragmentSharedLinkAccessBinding usxFragmentSharedLinkAccessBinding = (UsxFragmentSharedLinkAccessBinding) DataBindingUtil.inflate(layoutInflater, R.layout.usx_fragment_shared_link_access, viewGroup, false);
        this.binding = usxFragmentSharedLinkAccessBinding;
        return usxFragmentSharedLinkAccessBinding.getRoot();
    }

    @Override // com.box.android.usx.fragments.BoxShareFragment, androidx.fragment.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        this.binding.setSharedLinkAccessNotifier(this.notifier);
        this.binding.setOnPasswordListener(new View.OnClickListener() { // from class: com.box.android.usx.fragments.SharedLinkAccessFragment$$ExternalSyntheticLambda2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$onActivityCreated$0(view);
            }
        });
        this.binding.setOnDateListener(new View.OnClickListener() { // from class: com.box.android.usx.fragments.SharedLinkAccessFragment$$ExternalSyntheticLambda3
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$onActivityCreated$1(view);
            }
        });
        setTitles();
        SharedLinkVM sharedLinkVM = (SharedLinkVM) new ViewModelProvider(requireActivity(), ((BoxShareFragment.ShareVMFactoryProvider) requireActivity()).getShareVMFactory()).get(SharedLinkVM.class);
        this.mShareLinkVM = sharedLinkVM;
        sharedLinkVM.getItemInfo().observe(getViewLifecycleOwner(), this.onBoxItemComplete);
        this.mShareLinkVM.getSharedLinkedItem().observe(getViewLifecycleOwner(), this.onBoxItemComplete);
        this.mShareLinkVM.updateSharedLinkPasswordResult.observe(getViewLifecycleOwner(), this.onSharedLinkChangePasswordCompleted);
        setShareItem(this.mShareLinkVM.getShareItem());
        if (checkIfHasRequiredFields(this.mShareLinkVM.getShareItem())) {
            refreshUI();
        } else {
            refreshShareItemInfo();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onActivityCreated$0(View view) {
        showPasswordChooserDialog();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onActivityCreated$1(View view) {
        showDatePicker(this.mShareLinkVM.getShareItem().getSharedLink().getUnsharedDate());
    }

    public void refreshShareItemInfo() {
        showSpinner(0L);
        SharedLinkVM sharedLinkVM = this.mShareLinkVM;
        sharedLinkVM.fetchItemInfo(sharedLinkVM.getShareItem());
    }

    private boolean checkIfHasRequiredFields(BoxItem boxItem) {
        return (boxItem.getSharedLink() == null || boxItem.getAllowedSharedLinkAccessLevels() == null) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void changeAccess(BoxSharedLink.Access access) {
        if (access == null) {
            return;
        }
        showSpinner(R.string.box_sharesdk_updating_link_access);
        SharedLinkVM sharedLinkVM = this.mShareLinkVM;
        sharedLinkVM.changeAccessLevel((BoxCollaborationItem) sharedLinkVM.getShareItem(), access);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void changePermission(BoxSharedLink.Permission permission) {
        try {
            SharedLinkVM sharedLinkVM = this.mShareLinkVM;
            sharedLinkVM.changePermission((BoxCollaborationItem) sharedLinkVM.getShareItem(), permission);
        } catch (Exception unused) {
            showToast("Bookmarks do not have a permission that can be changed.");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void changePassword(String str) {
        SharedLinkVM sharedLinkVM = this.mShareLinkVM;
        sharedLinkVM.changePassword((BoxCollaborationItem) sharedLinkVM.getShareItem(), str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showPasswordChooserDialog() {
        if (getParentFragmentManager().findFragmentByTag(PASSWORD_FRAGMENT_TAG) != null) {
            return;
        }
        PasswordDialogFragment.createFragment(R.string.box_sharesdk_set_password, R.string.box_sharesdk_choose_password, R.string.box_sharesdk_ok, R.string.box_sharesdk_cancel, new PositiveNegativeDialogFragment.OnPositiveOrNegativeButtonClickedListener() { // from class: com.box.android.usx.fragments.SharedLinkAccessFragment.2
            @Override // com.box.android.usx.fragments.PositiveNegativeDialogFragment.OnPositiveOrNegativeButtonClickedListener
            public void onPositiveButtonClicked(PositiveNegativeDialogFragment positiveNegativeDialogFragment) {
                try {
                    SharedLinkAccessFragment.this.showSpinner();
                    SharedLinkAccessFragment.this.changePassword(((PasswordDialogFragment) positiveNegativeDialogFragment).getPassword());
                } catch (Exception unused) {
                    SharedLinkAccessFragment.this.dismissSpinner();
                    SharedLinkAccessFragment.this.showToast("Invalid password");
                }
            }

            @Override // com.box.android.usx.fragments.PositiveNegativeDialogFragment.OnPositiveOrNegativeButtonClickedListener
            public void onNegativeButtonClicked(PositiveNegativeDialogFragment positiveNegativeDialogFragment) {
                SharedLinkAccessFragment.this.refreshUI();
            }
        }).show(requireActivity().getSupportFragmentManager(), PASSWORD_FRAGMENT_TAG);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showDatePicker(Date date) {
        if (getFragmentManager().findFragmentByTag(DATE_FRAGMENT_TAG) != null) {
            return;
        }
        DatePickerFragment.createFragment(date, new DatePickerDialog.OnDateSetListener() { // from class: com.box.android.usx.fragments.SharedLinkAccessFragment.3
            @Override // android.app.DatePickerDialog.OnDateSetListener
            public void onDateSet(DatePicker datePicker, int i, int i2, int i3) {
                GregorianCalendar gregorianCalendar = new GregorianCalendar(i, i2, i3);
                try {
                    SharedLinkAccessFragment.this.showSpinner(R.string.box_sharesdk_updating_link_access);
                    SharedLinkAccessFragment.this.mShareLinkVM.setExpiryDate((BoxCollaborationItem) SharedLinkAccessFragment.this.mShareLinkVM.getShareItem(), gregorianCalendar.getTime());
                } catch (Exception unused) {
                    SharedLinkAccessFragment.this.dismissSpinner();
                    SharedLinkAccessFragment.this.showToast("invalid time selected");
                }
            }
        }, new PositiveNegativeDialogFragment.OnPositiveOrNegativeButtonClickedListener() { // from class: com.box.android.usx.fragments.SharedLinkAccessFragment.4
            @Override // com.box.android.usx.fragments.PositiveNegativeDialogFragment.OnPositiveOrNegativeButtonClickedListener
            public void onPositiveButtonClicked(PositiveNegativeDialogFragment positiveNegativeDialogFragment) {
            }

            @Override // com.box.android.usx.fragments.PositiveNegativeDialogFragment.OnPositiveOrNegativeButtonClickedListener
            public void onNegativeButtonClicked(PositiveNegativeDialogFragment positiveNegativeDialogFragment) {
                SharedLinkAccessFragment.this.refreshUI();
            }
        }).show(requireActivity().getSupportFragmentManager(), DATE_FRAGMENT_TAG);
    }

    public static SharedLinkAccessFragment newInstance(BoxItem boxItem) {
        Bundle bundle = BoxShareFragment.getBundle(boxItem);
        SharedLinkAccessFragment sharedLinkAccessFragment = new SharedLinkAccessFragment();
        sharedLinkAccessFragment.setArguments(bundle);
        return sharedLinkAccessFragment;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$new$2(PresenterData presenterData) {
        dismissSpinner();
        if (presenterData.isHandled()) {
            return;
        }
        if (presenterData.isSuccess() && presenterData.getData() != null && checkIfHasRequiredFields((BoxItem) presenterData.getData())) {
            setShareItem((BoxItem) presenterData.getData());
            return;
        }
        if (presenterData.getStrCode() != -1) {
            showToast(presenterData.getStrCode());
        }
        refreshUI();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$new$3(Result result) {
        if (result == null) {
            return;
        }
        dismissSpinner();
        if (result instanceof Result.Success) {
            dismissPasswordDialog();
            setShareItem((BoxItem) ((Result.Success) result).getValue());
        } else if (((RemoteError) ((Result.Error) result).getValue()) instanceof ItemsRemoteError.SharedLinkPasswordValidationError) {
            showPasswordValidationError();
        } else {
            dismissPasswordDialog();
            showToast(R.string.box_sharesdk_unable_to_modify_toast);
        }
    }

    private void showPasswordValidationError() {
        PasswordDialogFragment passwordDialogFragment = (PasswordDialogFragment) getParentFragmentManager().findFragmentByTag(PASSWORD_FRAGMENT_TAG);
        if (passwordDialogFragment != null) {
            passwordDialogFragment.showError(R.string.box_sharesdk_password_validation_error);
        }
    }

    private void dismissPasswordDialog() {
        PasswordDialogFragment passwordDialogFragment = (PasswordDialogFragment) getParentFragmentManager().findFragmentByTag(PASSWORD_FRAGMENT_TAG);
        if (passwordDialogFragment != null) {
            passwordDialogFragment.dismiss();
        }
    }

    public void refreshUI() {
        if (this.mShareLinkVM.getShareItem().getSharedLink() == null) {
            showToast(R.string.box_sharesdk_problem_accessing_this_shared_link);
            requireActivity().finish();
            return;
        }
        this.binding.setShareItem(this.mShareLinkVM.getShareItem());
        this.binding.setShouldShowDownloadOption(true);
        if (this.mShareLinkVM.getShareItem() instanceof BoxFile) {
            BoxFile boxFile = (BoxFile) this.mShareLinkVM.getShareItem();
            this.binding.setShouldShowDownloadOption(boxFile.getSharedLinkPermissionOptions().contains(BoxSharedLink.Permission.CAN_DOWNLOAD));
            this.binding.setShouldShowEditOption(boxFile.getSharedLinkPermissionOptions().contains(BoxSharedLink.Permission.CAN_EDIT));
        }
        this.binding.setActiveRadioButtons(this.mShareLinkVM.getActiveRadioButtons());
    }

    public void setShareItem(BoxItem boxItem) {
        this.mShareLinkVM.setShareItem(boxItem);
        refreshUI();
    }
}
