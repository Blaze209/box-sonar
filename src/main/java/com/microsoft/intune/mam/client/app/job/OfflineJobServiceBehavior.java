package com.microsoft.intune.mam.client.app.job;

import android.content.Context;

/* JADX INFO: loaded from: classes3.dex */
public class OfflineJobServiceBehavior implements JobServiceBehavior {
    @Override // com.microsoft.intune.mam.client.app.job.JobServiceBehavior
    public void attachBaseContext(HookedJobService hookedJobService, Context context) {
        hookedJobService.attachBaseContextReal(context);
    }
}
