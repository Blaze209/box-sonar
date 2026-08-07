package com.microsoft.intune.mam.client.app.offline;

import android.app.job.JobParameters;
import android.app.job.JobService;
import android.content.Intent;
import com.microsoft.intune.mam.client.service.MAMBackgroundJobServiceBehavior;
import com.microsoft.intune.mam.log.MAMLogger;
import com.microsoft.intune.mam.log.MAMLoggerProvider;

/* JADX INFO: loaded from: classes3.dex */
public final class OfflineMAMBackgroundJobServiceBehavior implements MAMBackgroundJobServiceBehavior {
    private static final MAMLogger LOGGER = MAMLoggerProvider.getLogger(OfflineMAMBackgroundJobServiceBehavior.class);
    private JobService mJobService;

    @Override // com.microsoft.intune.mam.client.service.MAMBackgroundJobServiceBehavior
    public void onCreate() {
    }

    @Override // com.microsoft.intune.mam.client.service.MAMBackgroundJobServiceBehavior
    public void onDestroy() {
    }

    @Override // com.microsoft.intune.mam.client.service.MAMBackgroundJobServiceBehavior
    public int onStartCommand(Intent intent, int i, int i2, int i3) {
        return i3;
    }

    @Override // com.microsoft.intune.mam.client.service.MAMBackgroundJobServiceBehavior
    public void setJobService(JobService jobService) {
        this.mJobService = jobService;
    }

    @Override // com.microsoft.intune.mam.client.service.MAMBackgroundJobServiceBehavior
    public boolean onStartJob(JobParameters jobParameters) {
        LOGGER.info("Ignoring job in offline mode", new Object[0]);
        return false;
    }

    @Override // com.microsoft.intune.mam.client.service.MAMBackgroundJobServiceBehavior
    public boolean onStopJob(JobParameters jobParameters) {
        LOGGER.info("Ignoring job in offline mode", new Object[0]);
        return false;
    }
}
