package com.microsoft.intune.mam.client.app.offline;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import com.microsoft.intune.mam.R;
import com.microsoft.intune.mam.client.app.AppStoreUtils;
import com.microsoft.intune.mam.client.app.MAMComponents;
import com.microsoft.intune.mam.client.app.ThemeManagerBehavior;
import com.microsoft.intune.mam.log.MAMLogger;
import com.microsoft.intune.mam.log.MAMLoggerProvider;

/* JADX INFO: loaded from: classes3.dex */
public class OfflineInstallCompanyPortalDialogActivity extends OfflineStartupBlockedActivity {
    public static final String ACTIVITY_BLOCKED_EXTRA = "activityLaunchBlocked";
    public static final String STRING_IDENTITY_AUTHORITY_EXTRA = "identityAuthority";
    private boolean mBlockActivity = false;
    private String mStringIdentityAuthority = null;
    private final ThemeManagerBehavior mThemeManager = (ThemeManagerBehavior) MAMComponents.get(ThemeManagerBehavior.class);
    private static final MAMLogger LOGGER = MAMLoggerProvider.getLogger(OfflineInstallCompanyPortalDialogActivity.class);
    private static int sDisplayed = 0;

    @Override // com.microsoft.intune.mam.client.app.offline.OfflineBlockedActivityBase, android.app.Activity
    protected void onCreate(Bundle bundle) {
        this.mBlockActivity = getIntent().getBooleanExtra(ACTIVITY_BLOCKED_EXTRA, false);
        this.mStringIdentityAuthority = getIntent().getStringExtra("identityAuthority");
        int i = sDisplayed + 1;
        sDisplayed = i;
        if (!this.mBlockActivity && i > 1) {
            finish();
        }
        if (this.mBlockActivity) {
            this.mThemeManager.applyAppThemeOrDefault(this, R.style.MAMActivityBaseTheme);
        }
        super.onCreate(bundle);
    }

    @Override // android.app.Activity
    protected void onDestroy() {
        sDisplayed--;
        super.onDestroy();
    }

    @Override // com.microsoft.intune.mam.client.app.offline.OfflineBlockedActivityBase
    protected void setupBackground() {
        if (this.mBlockActivity) {
            super.setupBackground();
        } else {
            setTheme(R.style.MAMDialogWithTrasparentBackground);
        }
    }

    @Override // com.microsoft.intune.mam.client.app.offline.OfflineStartupBlockedActivity, com.microsoft.intune.mam.client.app.offline.OfflineBlockedActivityBase
    protected void showUI() {
        String string;
        LOGGER.info("Displaying OfflineInstallCompanyPortalDialogActivity", new Object[0]);
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        final Context applicationContext = getApplicationContext();
        boolean zIsGooglePlayEnabled = AppStoreUtils.isGooglePlayEnabled(this);
        if (MAMComponents.getAgentOutdated()) {
            string = MAMComponents.getAgentOutdatedMessage();
        } else if (zIsGooglePlayEnabled) {
            string = getString(R.string.wg_offline_ssp_install_required_message);
        } else {
            string = getString(R.string.wg_offline_ssp_install_required_message_ngms);
        }
        builder.setMessage(string).setPositiveButton(applicationContext.getText(zIsGooglePlayEnabled ? R.string.wg_offline_get_the_app : R.string.wg_offline_learn_more), new DialogInterface.OnClickListener() { // from class: com.microsoft.intune.mam.client.app.offline.OfflineInstallCompanyPortalDialogActivity$$ExternalSyntheticLambda0
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i) {
                this.f$0.m13864x57df31bf(applicationContext, dialogInterface, i);
            }
        }).setCancelable(true);
        builder.setNegativeButton(getText(this.mBlockActivity ? R.string.wg_offline_close : R.string.wg_offline_cancel), new DialogInterface.OnClickListener() { // from class: com.microsoft.intune.mam.client.app.offline.OfflineInstallCompanyPortalDialogActivity$$ExternalSyntheticLambda1
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i) {
                this.f$0.m13865xc6664300(dialogInterface, i);
            }
        });
        AlertDialog alertDialogShow = builder.show();
        alertDialogShow.setCanceledOnTouchOutside(false);
        alertDialogShow.setOnCancelListener(new DialogInterface.OnCancelListener() { // from class: com.microsoft.intune.mam.client.app.offline.OfflineInstallCompanyPortalDialogActivity$$ExternalSyntheticLambda2
            @Override // android.content.DialogInterface.OnCancelListener
            public final void onCancel(DialogInterface dialogInterface) {
                this.f$0.m13866x34ed5441(dialogInterface);
            }
        });
        ((TextView) alertDialogShow.findViewById(android.R.id.message)).setTextColor(this.mThemeManager.getTextColor(getResources().getColor(android.R.color.black), this));
        ((Button) alertDialogShow.findViewById(android.R.id.button1)).setTextColor(this.mThemeManager.getAccentColor(getResources().getColor(R.color.intune_default_button_color), this));
        ((Button) alertDialogShow.findViewById(android.R.id.button2)).setTextColor(this.mThemeManager.getAccentColor(getResources().getColor(R.color.intune_default_button_color), this));
        this.mThemeManager.applyBackgroundColor(alertDialogShow.getWindow(), getResources().getColor(R.color.intune_default_background), this);
    }

    /* JADX INFO: renamed from: lambda$showUI$0$com-microsoft-intune-mam-client-app-offline-OfflineInstallCompanyPortalDialogActivity, reason: not valid java name */
    /* synthetic */ void m13864x57df31bf(Context context, DialogInterface dialogInterface, int i) {
        LOGGER.info("User clicked positive button to go to Play Store.", new Object[0]);
        AppStoreUtils.onClickInstallPortal(this.mStringIdentityAuthority, dialogInterface, context);
        finish();
    }

    /* JADX INFO: renamed from: lambda$showUI$1$com-microsoft-intune-mam-client-app-offline-OfflineInstallCompanyPortalDialogActivity, reason: not valid java name */
    /* synthetic */ void m13865xc6664300(DialogInterface dialogInterface, int i) {
        LOGGER.info("User clicked negative button to go back.", new Object[0]);
        dialogInterface.dismiss();
        finish();
    }

    /* JADX INFO: renamed from: lambda$showUI$2$com-microsoft-intune-mam-client-app-offline-OfflineInstallCompanyPortalDialogActivity, reason: not valid java name */
    /* synthetic */ void m13866x34ed5441(DialogInterface dialogInterface) {
        LOGGER.info("User cancelled dialog with hardware back button.", new Object[0]);
        dialogInterface.dismiss();
        finish();
    }
}
