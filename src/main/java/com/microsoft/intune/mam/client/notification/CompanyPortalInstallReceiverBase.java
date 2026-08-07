package com.microsoft.intune.mam.client.notification;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.Uri;
import com.microsoft.intune.mam.client.MAMInfo;
import com.microsoft.intune.mam.log.MAMLogger;
import com.microsoft.intune.mam.log.MAMLoggerProvider;

/* JADX INFO: loaded from: classes3.dex */
public abstract class CompanyPortalInstallReceiverBase extends BroadcastReceiver {
    private static final MAMLogger LOGGER = MAMLoggerProvider.getLogger(CompanyPortalInstallReceiverBase.class);
    private static final String PACKAGE_DATA_SCHEME = "package";
    private boolean mIsRegistered = false;

    protected abstract void onAgentPackageModified(Context context);

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        Uri data = intent.getData();
        if (data == null) {
            return;
        }
        if (MAMInfo.getPackageName().equals(data.getEncodedSchemeSpecificPart())) {
            LOGGER.info("Received intent about agent package change, starting background thread", new Object[0]);
            new Thread(new InstallAction(context, goAsync()), "Intune MAM CompanyPortal install action").start();
        }
    }

    final class InstallAction implements Runnable {
        private Context mContext;
        private BroadcastReceiver.PendingResult mPendingResult;

        private InstallAction(Context context, BroadcastReceiver.PendingResult pendingResult) {
            this.mContext = context;
            this.mPendingResult = pendingResult;
        }

        @Override // java.lang.Runnable
        public void run() {
            CompanyPortalInstallReceiverBase.this.onAgentPackageModified(this.mContext);
            this.mPendingResult.finish();
        }
    }

    public synchronized void registerReceiver(Context context) {
        if (this.mIsRegistered) {
            return;
        }
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.intent.action.PACKAGE_ADDED");
        intentFilter.addAction("android.intent.action.PACKAGE_REPLACED");
        intentFilter.addAction("android.intent.action.PACKAGE_FULLY_REMOVED");
        intentFilter.addAction("android.intent.action.PACKAGE_DATA_CLEARED");
        intentFilter.addDataScheme(PACKAGE_DATA_SCHEME);
        context.registerReceiver(this, intentFilter);
        this.mIsRegistered = true;
    }
}
