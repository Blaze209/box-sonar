package com.box.android.fragments;

import android.app.Dialog;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import com.box.android.R;
import com.box.android.coreservices.modelcontroller.IMoCoBoxGlobalSettings;
import com.box.android.vm.PushRegistrationDialogVM;
import com.google.firebase.iid.FirebaseInstanceId;
import javax.inject.Inject;

/* JADX INFO: loaded from: classes11.dex */
public class PushRegistrationDialogFragment extends Hilt_PushRegistrationDialogFragment {
    public static final String FRAGMENT_TAG = "pushRegistrationDialog";

    @Inject
    protected IMoCoBoxGlobalSettings mGlobalSettings;
    private PushRegistrationDialogVM mPushRegistrationDialogVM;

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setStyle(0, R.style.FullScreenDialogStyle);
        this.mPushRegistrationDialogVM = (PushRegistrationDialogVM) new ViewModelProvider(getActivity()).get(PushRegistrationDialogVM.class);
    }

    private void startObserveLiveData() {
        this.mPushRegistrationDialogVM.getBoxUserNotificationCategoriesStatus().observe(getViewLifecycleOwner(), new Observer() { // from class: com.box.android.fragments.PushRegistrationDialogFragment$$ExternalSyntheticLambda0
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                this.f$0.lambda$startObserveLiveData$0((PushRegistrationDialogVM.RegistrationStatus) obj);
            }
        });
        this.mPushRegistrationDialogVM.getBoxUserDeviceTokenSettingsStatus().observe(getViewLifecycleOwner(), new Observer() { // from class: com.box.android.fragments.PushRegistrationDialogFragment$$ExternalSyntheticLambda1
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                this.f$0.lambda$startObserveLiveData$1((PushRegistrationDialogVM.RegistrationStatus) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$startObserveLiveData$0(PushRegistrationDialogVM.RegistrationStatus registrationStatus) {
        if (registrationStatus == null) {
            return;
        }
        if (registrationStatus.getStatus().equals(PushRegistrationDialogVM.RegistrationStatus.StatusCode.SUCCESS_WITH_OS_NOTIFICATIONS_OFF)) {
            new NotificationEnableDialogFragment().show(getFragmentManager(), "pushRegistrationDialog");
        } else if (registrationStatus.getStatus().equals(PushRegistrationDialogVM.RegistrationStatus.StatusCode.ERROR)) {
            Toast.makeText(getContext(), getString(R.string.error_push_notification_register), 0).show();
            dismiss();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$startObserveLiveData$1(PushRegistrationDialogVM.RegistrationStatus registrationStatus) {
        if (registrationStatus == null) {
            return;
        }
        if (registrationStatus.getStatus().equals(PushRegistrationDialogVM.RegistrationStatus.StatusCode.SUCCESS)) {
            this.mPushRegistrationDialogVM.updateNotificationAllowCollab(Boolean.valueOf(this.mGlobalSettings.shouldAllowCollabsPushNotification()));
            this.mPushRegistrationDialogVM.updateNotificationAllowComments(Boolean.valueOf(this.mGlobalSettings.shouldAllowCommentsPushNotification()));
            this.mPushRegistrationDialogVM.updateNotificationAllowUpdates(Boolean.valueOf(this.mGlobalSettings.shouldAllowUpdatesPushNotification()));
            this.mPushRegistrationDialogVM.updateNotificationAllowTasks(true);
            return;
        }
        if (registrationStatus.getStatus().equals(PushRegistrationDialogVM.RegistrationStatus.StatusCode.ERROR)) {
            Toast.makeText(getContext(), getString(R.string.error_push_notification_register), 0).show();
            dismiss();
        }
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onStart() {
        super.onStart();
        Dialog dialog = getDialog();
        if (dialog != null) {
            dialog.getWindow().setLayout(-1, -1);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        ((Button) view.findViewById(R.id.enableButton)).setOnClickListener(new View.OnClickListener() { // from class: com.box.android.fragments.PushRegistrationDialogFragment.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                PushRegistrationDialogFragment.this.mPushRegistrationDialogVM.updateNotificationRegistrationDeviceTokenSettings(FirebaseInstanceId.getInstance().getToken(), true);
            }
        });
        ((Button) view.findViewById(R.id.dismissButton)).setOnClickListener(new View.OnClickListener() { // from class: com.box.android.fragments.PushRegistrationDialogFragment.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                PushRegistrationDialogFragment.this.dismiss();
            }
        });
    }

    @Override // androidx.fragment.app.Fragment
    public final View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View viewInflate = layoutInflater.inflate(R.layout.push_registration_install_prompt, viewGroup, false);
        startObserveLiveData();
        return viewInflate;
    }
}
