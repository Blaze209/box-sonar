package com.box.android.fragments;

import android.R;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import androidx.fragment.app.DialogFragment;
import com.google.android.material.dialog.MaterialAlertDialogBuilder;

/* JADX INFO: loaded from: classes11.dex */
public class NotificationEnableDialogFragment extends DialogFragment {
    public static final String FRAGMENT_TAG = "pushRegistrationDialog";

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setStyle(1, R.style.Theme.Holo.Light.Dialog);
    }

    @Override // androidx.fragment.app.DialogFragment
    public Dialog onCreateDialog(Bundle bundle) {
        MaterialAlertDialogBuilder materialAlertDialogBuilder = new MaterialAlertDialogBuilder(getActivity());
        materialAlertDialogBuilder.setTitle(com.box.android.R.string.notifications_disabled_alert_title);
        materialAlertDialogBuilder.setMessage(com.box.android.R.string.Turn_on_app_notifications);
        materialAlertDialogBuilder.setPositiveButton(com.box.android.R.string.update_settings_alert_button, new DialogInterface.OnClickListener() { // from class: com.box.android.fragments.NotificationEnableDialogFragment.1
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i) {
                Intent intent = new Intent("android.settings.APP_NOTIFICATION_SETTINGS");
                intent.putExtra("android.provider.extra.APP_PACKAGE", NotificationEnableDialogFragment.this.getContext().getPackageName());
                NotificationEnableDialogFragment.this.startActivity(intent);
            }
        });
        materialAlertDialogBuilder.setNegativeButton(com.box.android.R.string.dismiss, new DialogInterface.OnClickListener() { // from class: com.box.android.fragments.NotificationEnableDialogFragment.2
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i) {
                NotificationEnableDialogFragment.this.dismiss();
            }
        });
        return materialAlertDialogBuilder.create();
    }

    @Override // androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
    }
}
