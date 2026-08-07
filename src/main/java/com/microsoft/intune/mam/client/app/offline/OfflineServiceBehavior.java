package com.microsoft.intune.mam.client.app.offline;

import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import com.microsoft.intune.mam.client.MAMInfo;
import com.microsoft.intune.mam.client.app.HookedService;
import com.microsoft.intune.mam.client.app.ServiceBehavior;

/* JADX INFO: loaded from: classes3.dex */
class OfflineServiceBehavior implements ServiceBehavior {
    private HookedService mService;

    OfflineServiceBehavior() {
    }

    @Override // com.microsoft.intune.mam.client.app.ServiceBehavior
    public void attachBaseContext(HookedService hookedService, Context context) {
        this.mService = hookedService;
        hookedService.attachBaseContextReal(context);
    }

    @Override // com.microsoft.intune.mam.client.app.ServiceBehavior
    public IBinder onBind(Intent intent) {
        if (checkLaunchBlock()) {
            return null;
        }
        return this.mService.onMAMBind(intent);
    }

    @Override // com.microsoft.intune.mam.client.app.ServiceBehavior
    public int onStartCommand(Intent intent, int i, int i2) {
        if (checkLaunchBlock()) {
            return 2;
        }
        return this.mService.onMAMStartCommand(intent, i, i2);
    }

    @Override // com.microsoft.intune.mam.client.app.ServiceBehavior
    public int onMAMStartCommand(Intent intent, int i, int i2) {
        return this.mService.onStartCommandReal(intent, i, i2);
    }

    @Override // com.microsoft.intune.mam.client.app.ServiceBehavior
    @Deprecated
    public void onStart(Intent intent, int i) {
        if (checkLaunchBlock()) {
            return;
        }
        this.mService.onMAMStart(intent, i);
    }

    @Override // com.microsoft.intune.mam.client.app.ServiceBehavior
    @Deprecated
    public void onMAMStart(Intent intent, int i) {
        this.mService.onStartReal(intent, i);
    }

    private boolean checkLaunchBlock() {
        return MAMInfo.isPolicyRequired();
    }
}
