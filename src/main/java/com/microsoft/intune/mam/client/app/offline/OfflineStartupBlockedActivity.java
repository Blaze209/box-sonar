package com.microsoft.intune.mam.client.app.offline;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import com.microsoft.intune.mam.R;
import com.microsoft.intune.mam.client.app.AppStoreUtils;
import com.microsoft.intune.mam.client.app.MAMComponents;
import com.microsoft.intune.mam.client.app.utils.IntentUtils;
import com.microsoft.intune.mam.client.telemetry.events.MAMExternalError;
import com.microsoft.intune.mam.log.MAMLogger;
import com.microsoft.intune.mam.log.MAMLoggerProvider;
import com.microsoft.intune.mam.util.IntentCompat;

/* JADX INFO: loaded from: classes3.dex */
public class OfflineStartupBlockedActivity extends OfflineBlockedActivityBase {
    public static final String EXTRA_RESTART_ON_FINISH = "restartonfinish";
    private static final MAMLogger LOGGER = MAMLoggerProvider.getLogger(OfflineStartupBlockedActivity.class);
    public static final String MESSAGE_EXTRA_NAME = "message";
    public static final String STRING_IDENTITY_AUTHORITY_EXTRA = "identityAuthority";

    @Override // com.microsoft.intune.mam.client.app.offline.OfflineBlockedActivityBase
    protected void showUI() {
        Intent intent = getIntent();
        CharSequence charSequenceExtra = intent.getCharSequenceExtra("message");
        String stringExtra = intent.getStringExtra("identityAuthority");
        if (charSequenceExtra == null) {
            charSequenceExtra = getString(R.string.wg_offline_policy_required_message);
        }
        showLaunchBlockedUI(charSequenceExtra, stringExtra);
    }

    private void showLaunchBlockedUI(CharSequence charSequence, final String str) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage(charSequence).setNegativeButton(getText(R.string.wg_offline_close), new DialogInterface.OnClickListener() { // from class: com.microsoft.intune.mam.client.app.offline.OfflineStartupBlockedActivity$$ExternalSyntheticLambda0
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i) {
                this.f$0.m13870x32bf28bd(dialogInterface, i);
            }
        }).setCancelable(true);
        if (MAMComponents.getAgentOutdated()) {
            builder.setPositiveButton(getText(AppStoreUtils.isGooglePlayEnabled(this) ? R.string.wg_offline_get_the_app : R.string.wg_offline_learn_more), new DialogInterface.OnClickListener() { // from class: com.microsoft.intune.mam.client.app.offline.OfflineStartupBlockedActivity$$ExternalSyntheticLambda1
                @Override // android.content.DialogInterface.OnClickListener
                public final void onClick(DialogInterface dialogInterface, int i) {
                    AppStoreUtils.onClickInstallPortal(str, dialogInterface, this);
                }
            });
        }
        AlertDialog alertDialogShow = builder.show();
        alertDialogShow.setCanceledOnTouchOutside(false);
        alertDialogShow.setOnCancelListener(new DialogInterface.OnCancelListener() { // from class: com.microsoft.intune.mam.client.app.offline.OfflineStartupBlockedActivity$$ExternalSyntheticLambda2
            @Override // android.content.DialogInterface.OnCancelListener
            public final void onCancel(DialogInterface dialogInterface) {
                this.f$0.m13871x9a1b7e3f(dialogInterface);
            }
        });
    }

    /* JADX INFO: renamed from: lambda$showLaunchBlockedUI$0$com-microsoft-intune-mam-client-app-offline-OfflineStartupBlockedActivity, reason: not valid java name */
    /* synthetic */ void m13870x32bf28bd(DialogInterface dialogInterface, int i) {
        dialogInterface.dismiss();
        finish();
    }

    /* JADX INFO: renamed from: lambda$showLaunchBlockedUI$2$com-microsoft-intune-mam-client-app-offline-OfflineStartupBlockedActivity, reason: not valid java name */
    /* synthetic */ void m13871x9a1b7e3f(DialogInterface dialogInterface) {
        dialogInterface.dismiss();
        finish();
    }

    @Override // android.app.Activity
    public void finish() {
        if (getIntent().getBooleanExtra(EXTRA_RESTART_ON_FINISH, false)) {
            Intent intent = (Intent) IntentCompat.getParcelableExtra(getIntent(), "android.intent.extra.INTENT", Intent.class);
            if (intent == null) {
                LOGGER.error(MAMExternalError.STARTUP_BLOCKED_RESTART_WITHOUT_INTENT, "Caller requested restart but did not provide intent", new Object[0]);
                super.finish();
                return;
            } else {
                intent.putExtra(OfflineActivityBehavior.EXTRA_ORIGINAL_FLAGS, intent.getFlags());
                IntentUtils.stripStackManipulationFlags(intent);
                startActivity(intent);
            }
        }
        super.finish();
    }
}
