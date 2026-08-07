package com.microsoft.intune.mam.client.app.job;

import android.app.job.JobService;
import android.content.Context;
import com.microsoft.intune.mam.client.app.MAMComponents;
import com.microsoft.intune.mam.client.identity.MAMIdentity;

/* JADX INFO: loaded from: classes3.dex */
public abstract class MAMJobService extends JobService implements HookedJobService {
    private MAMIdentity mOfflineIdentity;

    @Override // android.app.Service, android.content.ContextWrapper
    protected void attachBaseContext(Context context) {
        MAMComponents.initialize(context);
        ((JobServiceBehavior) MAMComponents.get(JobServiceBehavior.class)).attachBaseContext(this, context);
    }

    @Override // com.microsoft.intune.mam.client.app.HookedContextWrapper
    public final void attachBaseContextReal(Context context) {
        super.attachBaseContext(context);
    }

    @Override // com.microsoft.intune.mam.client.app.HookedContextWrapper
    public void setMAMOfflineIdentity(MAMIdentity mAMIdentity) {
        this.mOfflineIdentity = mAMIdentity;
    }

    @Override // com.microsoft.intune.mam.client.app.HookedContextWrapper
    public MAMIdentity getMAMOfflineIdentity() {
        return this.mOfflineIdentity;
    }
}
