package com.microsoft.intune.mam.client.app.offline;

import android.app.ActivityManager;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import com.microsoft.intune.mam.R;
import com.microsoft.intune.mam.client.app.data.AbstractUserDataWiper;
import com.microsoft.intune.mam.log.MAMLogger;
import com.microsoft.intune.mam.log.MAMLoggerProvider;
import com.microsoft.intune.mam.policy.MAMEnrollmentStatusCache;

/* JADX INFO: loaded from: classes3.dex */
public class OfflineNotifyWipeActivity extends OfflineStartupBlockedActivity {
    private static final MAMLogger LOGGER = MAMLoggerProvider.getLogger(OfflineNotifyWipeActivity.class);
    private MAMEnrollmentStatusCache mEnrollmentStatus;

    @Override // com.microsoft.intune.mam.client.app.offline.OfflineBlockedActivityBase, android.app.Activity
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.mEnrollmentStatus = (MAMEnrollmentStatusCache) OfflineComponents.get(MAMEnrollmentStatusCache.class);
    }

    @Override // com.microsoft.intune.mam.client.app.offline.OfflineStartupBlockedActivity, com.microsoft.intune.mam.client.app.offline.OfflineBlockedActivityBase
    protected void showUI() {
        if (AbstractUserDataWiper.isWipeInProgress()) {
            LOGGER.info("Wipe not completed yet, waiting to show dialog", new Object[0]);
            new Thread(new Runnable() { // from class: com.microsoft.intune.mam.client.app.offline.OfflineNotifyWipeActivity$$ExternalSyntheticLambda1
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.m13869xb47dde99();
                }
            }, "Intune MAM wipe waiter").start();
        } else {
            showDialog();
        }
    }

    /* JADX INFO: renamed from: lambda$showUI$0$com-microsoft-intune-mam-client-app-offline-OfflineNotifyWipeActivity, reason: not valid java name */
    /* synthetic */ void m13869xb47dde99() {
        AbstractUserDataWiper.waitForWipesToComplete();
        runOnUiThread(new Runnable() { // from class: com.microsoft.intune.mam.client.app.offline.OfflineNotifyWipeActivity$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.showDialog();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showDialog() {
        CharSequence text;
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        getApplicationContext();
        final boolean systemWipeNotice = this.mEnrollmentStatus.getSystemWipeNotice();
        DialogInterface.OnClickListener onClickListener = new DialogInterface.OnClickListener() { // from class: com.microsoft.intune.mam.client.app.offline.OfflineNotifyWipeActivity.1
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i) {
                if (!systemWipeNotice) {
                    OfflineNotifyWipeActivity.this.mEnrollmentStatus.clearImplicitWipeNotice();
                    dialogInterface.dismiss();
                    OfflineNotifyWipeActivity.this.finish();
                    return;
                }
                systemWipe();
            }

            private void systemWipe() {
                OfflineNotifyWipeActivity.LOGGER.info("User clicked OK on OfflineSystemWipeNotification dialog, App will be shutdown.", new Object[0]);
                ((ActivityManager) OfflineNotifyWipeActivity.this.getApplicationContext().getSystemService("activity")).clearApplicationUserData();
            }
        };
        if (systemWipeNotice) {
            LOGGER.info("Display System Wipe Notification Message.", new Object[0]);
            text = getText(R.string.wg_offline_ssp_removed_notify_system_wipe);
        } else {
            LOGGER.info("Display Implicit Wipe Notification Message.", new Object[0]);
            text = getText(R.string.wg_offline_ssp_removed_notify_wipe);
        }
        builder.setMessage(text).setCancelable(false);
        builder.setPositiveButton(R.string.wg_offline_ok, onClickListener).setCancelable(false);
        builder.show().setCanceledOnTouchOutside(false);
    }
}
