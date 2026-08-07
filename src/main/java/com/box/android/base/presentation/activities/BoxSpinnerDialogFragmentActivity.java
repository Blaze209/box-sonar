package com.box.android.base.presentation.activities;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.view.ContextThemeWrapper;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;
import com.box.android.base.R;
import com.box.android.base.presentation.fragments.ISpinnerDialog;
import com.box.android.common.utilities.CommonBoxUtil;
import com.box.android.coreservices.modelcontroller.messages.Controller;
import com.box.android.domain.analytics.BoxAmplitudeAnalytics;
import com.box.android.domain.analytics.BoxAnalyticsParams;
import com.box.androidsdk.content.utils.BoxLogUtils;
import com.google.android.material.dialog.MaterialAlertDialogBuilder;
import com.microsoft.intune.mam.client.content.MAMBroadcastReceiver;
import org.apache.commons.lang3.StringUtils;

/* JADX INFO: loaded from: classes9.dex */
public class BoxSpinnerDialogFragmentActivity extends AppCompatActivity implements ISpinnerDialog {
    private static final Intent DISMISS_SPINNER_INTENT = new Intent(Controller.ACTION_DISMISS_SPINNER);
    private static final String EXTRA_SPINNER_CANCELABLE = "EXTRA_SPINNER_CANCELABLE";
    private static final String EXTRA_SPINNER_MESSAGE = "EXTRA_SPINNER_MESSAGE";
    private LocalBroadcastManager mLocalBroadcastManager;
    private AlertDialog mSpinnerDialog;
    private String mSpinnerMessage;
    private DialogInterface.OnCancelListener onCancelListener;
    private boolean mSpinnerCancellable = false;
    private final DialogInterface.OnDismissListener mSpinnerDismissListener = new DialogInterface.OnDismissListener() { // from class: com.box.android.base.presentation.activities.BoxSpinnerDialogFragmentActivity.1
        @Override // android.content.DialogInterface.OnDismissListener
        public void onDismiss(DialogInterface dialogInterface) {
            BoxSpinnerDialogFragmentActivity.this.mSpinnerMessage = null;
        }
    };
    private final BroadcastReceiver mSpinnerReceiver = new MAMBroadcastReceiver() { // from class: com.box.android.base.presentation.activities.BoxSpinnerDialogFragmentActivity.2
        @Override // com.microsoft.intune.mam.client.content.HookedBroadcastReceiver
        public void onMAMReceive(Context context, Intent intent) {
            if (intent.getAction().equals(Controller.ACTION_DISMISS_SPINNER)) {
                BoxSpinnerDialogFragmentActivity.this.dismissSpinnerSynchronous();
            }
        }
    };

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, com.microsoft.intune.mam.client.app.MAMActivity, com.microsoft.intune.mam.client.app.HookedActivity
    public void onMAMCreate(Bundle bundle) {
        super.onMAMCreate(bundle);
        this.mLocalBroadcastManager = LocalBroadcastManager.getInstance(this);
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction(Controller.ACTION_DISMISS_SPINNER);
        this.mLocalBroadcastManager.registerReceiver(this.mSpinnerReceiver, intentFilter);
        if (bundle != null) {
            this.mSpinnerCancellable = bundle.getBoolean(EXTRA_SPINNER_CANCELABLE, false);
            this.mSpinnerMessage = bundle.getString(EXTRA_SPINNER_MESSAGE);
        }
        if (StringUtils.isEmpty(this.mSpinnerMessage)) {
            return;
        }
        showSpinner(this.mSpinnerMessage, this.mSpinnerCancellable);
    }

    @Override // com.box.android.base.presentation.fragments.ISpinnerDialog
    public void showSpinner(final String str, boolean z) {
        if (StringUtils.isEmpty(str)) {
            this.mSpinnerMessage = CommonBoxUtil.LS(R.string.please_wait_dot_dot_dot);
        } else {
            this.mSpinnerMessage = str;
        }
        this.mSpinnerCancellable = z;
        new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.box.android.base.presentation.activities.BoxSpinnerDialogFragmentActivity.3
            @Override // java.lang.Runnable
            public void run() {
                try {
                    BoxSpinnerDialogFragmentActivity.this.dismissSpinnerSynchronous();
                    View viewInflate = LayoutInflater.from(new ContextThemeWrapper(BoxSpinnerDialogFragmentActivity.this, R.style.Theme_Box_Dialog_Alert)).inflate(R.layout.progress_dialog, (ViewGroup) null);
                    ((TextView) viewInflate.findViewById(R.id.message)).setText(str);
                    BoxSpinnerDialogFragmentActivity.this.mSpinnerDialog = new MaterialAlertDialogBuilder(BoxSpinnerDialogFragmentActivity.this).setView(viewInflate).create();
                    BoxSpinnerDialogFragmentActivity.this.mSpinnerDialog.setOnCancelListener(BoxSpinnerDialogFragmentActivity.this.onCancelListener);
                    BoxSpinnerDialogFragmentActivity.this.mSpinnerDialog.setOnDismissListener(BoxSpinnerDialogFragmentActivity.this.mSpinnerDismissListener);
                    BoxSpinnerDialogFragmentActivity.this.mSpinnerDialog.setCancelable(BoxSpinnerDialogFragmentActivity.this.mSpinnerCancellable);
                    BoxSpinnerDialogFragmentActivity.this.mSpinnerDialog.show();
                } catch (Exception unused) {
                }
            }
        });
    }

    @Override // com.box.android.base.presentation.fragments.ISpinnerDialog
    public void showSpinner(String str) {
        showSpinner(str, false);
    }

    public void showSpinner(boolean z) {
        showSpinner(CommonBoxUtil.LS(R.string.please_wait_dot_dot_dot), z);
    }

    @Override // com.box.android.base.presentation.fragments.ISpinnerDialog
    public void showSpinner() {
        showSpinner(CommonBoxUtil.LS(R.string.please_wait_dot_dot_dot), false);
    }

    @Override // com.box.android.base.presentation.fragments.ISpinnerDialog
    public void setSpinnerOnCancelListener(DialogInterface.OnCancelListener onCancelListener) {
        this.onCancelListener = onCancelListener;
    }

    @Override // com.box.android.base.presentation.fragments.ISpinnerDialog
    public void broadcastDismissSpinner() {
        new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.box.android.base.presentation.activities.BoxSpinnerDialogFragmentActivity.4
            @Override // java.lang.Runnable
            public void run() {
                BoxSpinnerDialogFragmentActivity.this.mLocalBroadcastManager.sendBroadcast(BoxSpinnerDialogFragmentActivity.DISMISS_SPINNER_INTENT);
            }
        });
    }

    @Override // androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, com.microsoft.intune.mam.client.app.MAMActivity, com.microsoft.intune.mam.client.app.HookedActivity
    public void onMAMSaveInstanceState(Bundle bundle) {
        bundle.putString(EXTRA_SPINNER_MESSAGE, this.mSpinnerMessage);
        bundle.putBoolean(EXTRA_SPINNER_CANCELABLE, this.mSpinnerCancellable);
        super.onMAMSaveInstanceState(bundle);
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, com.microsoft.intune.mam.client.app.MAMActivity, com.microsoft.intune.mam.client.app.HookedActivity
    public void onMAMDestroy() {
        dismissSpinnerSynchronous();
        LocalBroadcastManager localBroadcastManager = this.mLocalBroadcastManager;
        if (localBroadcastManager != null) {
            localBroadcastManager.unregisterReceiver(this.mSpinnerReceiver);
        }
        super.onMAMDestroy();
    }

    public void dismissSpinnerSynchronous() {
        AlertDialog alertDialog = this.mSpinnerDialog;
        if (alertDialog == null || !alertDialog.isShowing()) {
            return;
        }
        try {
            this.mSpinnerDialog.dismiss();
        } catch (Exception e) {
            BoxLogUtils.logException(e);
        }
        this.mSpinnerDialog = null;
    }

    public boolean amplitudeSetCurrentPage() {
        BoxAmplitudeAnalytics.getInstance().setCurrentPage(String.format(BoxAnalyticsParams.PAGE_NAME_UNKNOWN, getClass().getSimpleName()));
        return true;
    }

    public void amplitudeSetCurrentPageAndLog(BoxAmplitudeAnalytics.EventPropertyBuilder eventPropertyBuilder, String str) {
        if (BoxAmplitudeAnalytics.getInstance().setCurrentPage(str)) {
            eventPropertyBuilder.logEvent(String.format(BoxAnalyticsParams.EVENT_PAGE_VIEWED_TEMPLATE, str));
        }
    }
}
