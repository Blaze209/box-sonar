package com.microsoft.intune.mam.client.app.offline;

import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import com.microsoft.intune.mam.client.app.HookedIntentService;
import com.microsoft.intune.mam.client.app.HookedService;
import com.microsoft.intune.mam.client.app.IntentServiceBehavior;

/* JADX INFO: loaded from: classes3.dex */
final class OfflineIntentServiceBehavior extends OfflineServiceBehavior implements IntentServiceBehavior {
    protected HookedIntentService mIntentService;

    OfflineIntentServiceBehavior() {
    }

    @Override // com.microsoft.intune.mam.client.app.IntentServiceBehavior
    public void attachBaseContext(HookedIntentService hookedIntentService, Context context) {
        super.attachBaseContext((HookedService) hookedIntentService, context);
        this.mIntentService = hookedIntentService;
    }

    @Override // com.microsoft.intune.mam.client.app.IntentServiceBehavior
    public IBinder onMAMBind(Intent intent) {
        return this.mIntentService.onBindReal(intent);
    }
}
