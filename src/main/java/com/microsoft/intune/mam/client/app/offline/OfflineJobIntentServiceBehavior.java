package com.microsoft.intune.mam.client.app.offline;

import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import com.microsoft.intune.mam.client.app.HookedJobIntentService;
import com.microsoft.intune.mam.client.app.HookedService;
import com.microsoft.intune.mam.client.app.JobIntentServiceBehavior;

/* JADX INFO: loaded from: classes3.dex */
class OfflineJobIntentServiceBehavior extends OfflineServiceBehavior implements JobIntentServiceBehavior {
    private HookedJobIntentService mJobIntentService;

    OfflineJobIntentServiceBehavior() {
    }

    @Override // com.microsoft.intune.mam.client.app.JobIntentServiceBehavior
    public void attachBaseContext(HookedJobIntentService hookedJobIntentService, Context context) {
        super.attachBaseContext((HookedService) hookedJobIntentService, context);
        this.mJobIntentService = hookedJobIntentService;
    }

    @Override // com.microsoft.intune.mam.client.app.JobIntentServiceBehavior
    public void onHandleWork(Intent intent) {
        this.mJobIntentService.onMAMHandleWork(intent);
    }

    @Override // com.microsoft.intune.mam.client.app.JobIntentServiceBehavior
    public IBinder onMAMBind(Intent intent) {
        return this.mJobIntentService.onBindReal(intent);
    }
}
