package com.microsoft.intune.mam.client.app.offline;

import android.app.AlertDialog;
import android.content.DialogInterface;
import com.microsoft.intune.mam.R;
import com.microsoft.intune.mam.client.app.MAMApplication;

/* JADX INFO: loaded from: classes3.dex */
public class OfflineRestartRequiredActivity extends OfflineBlockedActivityBase {
    @Override // com.microsoft.intune.mam.client.app.offline.OfflineBlockedActivityBase
    protected void showUI() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage(getText(R.string.wg_offline_must_restart)).setPositiveButton(getText(R.string.wg_offline_ok), new DialogInterface.OnClickListener() { // from class: com.microsoft.intune.mam.client.app.offline.OfflineRestartRequiredActivity$$ExternalSyntheticLambda0
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i) {
                MAMApplication.endProcess();
            }
        }).setCancelable(false);
        builder.show().setCanceledOnTouchOutside(false);
    }
}
