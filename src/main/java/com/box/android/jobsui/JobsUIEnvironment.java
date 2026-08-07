package com.box.android.jobsui;

import com.box.android.base.presentation.ThumbnailManager;
import com.box.android.domain.services.IJobManagerBridgeService;
import com.box.android.domain.services.IJobService;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: JobsReducer.kt */
/* JADX INFO: loaded from: classes12.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\b\u0007\u0018\u00002\u00020\u0001B1\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b¢\u0006\u0004\b\f\u0010\rR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0011\u0010\n\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017¨\u0006\u0018"}, d2 = {"Lcom/box/android/jobsui/JobsUIEnvironment;", "", "jobManagerBridgeService", "Lcom/box/android/domain/services/IJobManagerBridgeService;", "jobService", "Lcom/box/android/domain/services/IJobService;", "thumbnailManager", "Lcom/box/android/base/presentation/ThumbnailManager;", "jobsUICoreHelper", "Lcom/box/android/jobsui/JobsUICoreHelper;", "jobNotificationService", "Lcom/box/android/jobsui/IJobNotificationService;", "<init>", "(Lcom/box/android/domain/services/IJobManagerBridgeService;Lcom/box/android/domain/services/IJobService;Lcom/box/android/base/presentation/ThumbnailManager;Lcom/box/android/jobsui/JobsUICoreHelper;Lcom/box/android/jobsui/IJobNotificationService;)V", "getJobManagerBridgeService", "()Lcom/box/android/domain/services/IJobManagerBridgeService;", "getJobService", "()Lcom/box/android/domain/services/IJobService;", "getThumbnailManager", "()Lcom/box/android/base/presentation/ThumbnailManager;", "getJobsUICoreHelper", "()Lcom/box/android/jobsui/JobsUICoreHelper;", "getJobNotificationService", "()Lcom/box/android/jobsui/IJobNotificationService;", "jobsui_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class JobsUIEnvironment {
    public static final int $stable = 8;
    private final IJobManagerBridgeService jobManagerBridgeService;
    private final IJobNotificationService jobNotificationService;
    private final IJobService jobService;
    private final JobsUICoreHelper jobsUICoreHelper;
    private final ThumbnailManager thumbnailManager;

    @Inject
    public JobsUIEnvironment(IJobManagerBridgeService jobManagerBridgeService, IJobService jobService, ThumbnailManager thumbnailManager, JobsUICoreHelper jobsUICoreHelper, IJobNotificationService jobNotificationService) {
        Intrinsics.checkNotNullParameter(jobManagerBridgeService, "jobManagerBridgeService");
        Intrinsics.checkNotNullParameter(jobService, "jobService");
        Intrinsics.checkNotNullParameter(thumbnailManager, "thumbnailManager");
        Intrinsics.checkNotNullParameter(jobsUICoreHelper, "jobsUICoreHelper");
        Intrinsics.checkNotNullParameter(jobNotificationService, "jobNotificationService");
        this.jobManagerBridgeService = jobManagerBridgeService;
        this.jobService = jobService;
        this.thumbnailManager = thumbnailManager;
        this.jobsUICoreHelper = jobsUICoreHelper;
        this.jobNotificationService = jobNotificationService;
    }

    public final IJobManagerBridgeService getJobManagerBridgeService() {
        return this.jobManagerBridgeService;
    }

    public final IJobService getJobService() {
        return this.jobService;
    }

    public final ThumbnailManager getThumbnailManager() {
        return this.thumbnailManager;
    }

    public final JobsUICoreHelper getJobsUICoreHelper() {
        return this.jobsUICoreHelper;
    }

    public final IJobNotificationService getJobNotificationService() {
        return this.jobNotificationService;
    }
}
