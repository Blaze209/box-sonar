package com.microsoft.intune.mam.client.service;

import android.app.job.JobParameters;
import android.app.job.JobService;
import android.content.Context;
import android.content.Intent;
import com.microsoft.intune.mam.client.app.MAMComponents;
import com.microsoft.intune.mam.log.MAMLogger;
import com.microsoft.intune.mam.log.MAMLoggerProvider;
import java.util.logging.Level;

/* JADX INFO: loaded from: classes3.dex */
public class MAMBackgroundJobService extends JobService {
    private static final MAMLogger LOGGER = MAMLoggerProvider.getLogger(MAMBackgroundJobService.class);
    private MAMBackgroundJobServiceBehavior mBehavior;

    @Override // android.app.Service, android.content.ContextWrapper
    protected void attachBaseContext(Context context) {
        MAMComponents.initialize(context);
        super.attachBaseContext(context);
    }

    @Override // android.app.Service
    public void onCreate() {
        this.mBehavior = (MAMBackgroundJobServiceBehavior) MAMComponents.get(MAMBackgroundJobServiceBehavior.class);
        try {
            LOGGER.log(Level.FINE, "enter onCreate");
            super.onCreate();
            this.mBehavior.setJobService(this);
            this.mBehavior.onCreate();
        } finally {
            LOGGER.log(Level.FINE, "exit onCreate");
        }
    }

    @Override // android.app.Service
    public void onDestroy() {
        super.onDestroy();
        this.mBehavior.onDestroy();
    }

    @Override // android.app.Service
    public int onStartCommand(Intent intent, int i, int i2) {
        return this.mBehavior.onStartCommand(intent, i, i2, super.onStartCommand(intent, i, i2));
    }

    @Override // android.app.job.JobService
    public boolean onStartJob(JobParameters jobParameters) {
        try {
            LOGGER.log(Level.FINE, "enter onStartJob");
            return this.mBehavior.onStartJob(jobParameters);
        } finally {
            LOGGER.log(Level.FINE, "exit onStartJob");
        }
    }

    @Override // android.app.job.JobService
    public boolean onStopJob(JobParameters jobParameters) {
        try {
            LOGGER.log(Level.FINE, "enter onStopJob");
            return this.mBehavior.onStopJob(jobParameters);
        } finally {
            LOGGER.log(Level.FINE, "exit onStopJob");
        }
    }
}
