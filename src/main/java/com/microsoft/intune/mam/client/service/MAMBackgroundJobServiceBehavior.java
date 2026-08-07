package com.microsoft.intune.mam.client.service;

import android.app.job.JobParameters;
import android.app.job.JobService;
import android.content.Intent;

/* JADX INFO: loaded from: classes3.dex */
public interface MAMBackgroundJobServiceBehavior {
    void onCreate();

    void onDestroy();

    int onStartCommand(Intent intent, int i, int i2, int i3);

    boolean onStartJob(JobParameters jobParameters);

    boolean onStopJob(JobParameters jobParameters);

    void setJobService(JobService jobService);
}
