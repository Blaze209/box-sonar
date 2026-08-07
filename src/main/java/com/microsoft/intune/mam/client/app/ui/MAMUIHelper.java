package com.microsoft.intune.mam.client.app.ui;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import com.microsoft.intune.mam.R;
import com.microsoft.intune.mam.log.MAMLogger;
import com.microsoft.intune.mam.log.MAMLoggerProvider;

/* JADX INFO: loaded from: classes3.dex */
public final class MAMUIHelper {
    private static final MAMLogger LOGGER = MAMLoggerProvider.getLogger(MAMUIHelper.class);

    private MAMUIHelper() {
    }

    public static void showSharingBlockedDialog(Activity activity) {
        LOGGER.info("Showing sharing blocked dialog.", new Object[0]);
        Context applicationContext = activity.getApplicationContext();
        new AlertDialog.Builder(activity).setTitle(applicationContext.getText(R.string.wg_offline_sharing_blocked_dialog_title)).setMessage(applicationContext.getText(R.string.wg_offline_sharing_blocked_dialog_text)).setPositiveButton(applicationContext.getString(R.string.wg_offline_ok), new DialogInterface.OnClickListener() { // from class: com.microsoft.intune.mam.client.app.ui.MAMUIHelper$$ExternalSyntheticLambda0
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.dismiss();
            }
        }).create().show();
    }
}
