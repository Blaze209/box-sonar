package com.box.android.base.presentation.components.fileactions;

import com.box.android.coreservices.jobmanager.JobManager;
import com.box.android.coreservices.utilities.FileActionsManager;
import com.box.android.domain.configuration.FeatureFlips;
import com.box.android.domain.services.ILocalItemService;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: DownloadFilesReducer.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\b\u0007\u0018\u00002\u00020\u0001B)\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0004\b\n\u0010\u000bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013¨\u0006\u0014"}, d2 = {"Lcom/box/android/base/presentation/components/fileactions/DownloadEnvironment;", "", "fileActionsManager", "Lcom/box/android/coreservices/utilities/FileActionsManager;", "jobManager", "Lcom/box/android/coreservices/jobmanager/JobManager;", "featureFlips", "Lcom/box/android/domain/configuration/FeatureFlips;", "itemService", "Lcom/box/android/domain/services/ILocalItemService;", "<init>", "(Lcom/box/android/coreservices/utilities/FileActionsManager;Lcom/box/android/coreservices/jobmanager/JobManager;Lcom/box/android/domain/configuration/FeatureFlips;Lcom/box/android/domain/services/ILocalItemService;)V", "getFileActionsManager", "()Lcom/box/android/coreservices/utilities/FileActionsManager;", "getJobManager", "()Lcom/box/android/coreservices/jobmanager/JobManager;", "getFeatureFlips", "()Lcom/box/android/domain/configuration/FeatureFlips;", "getItemService", "()Lcom/box/android/domain/services/ILocalItemService;", "base_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class DownloadEnvironment {
    public static final int $stable = 8;
    private final FeatureFlips featureFlips;
    private final FileActionsManager fileActionsManager;
    private final ILocalItemService itemService;
    private final JobManager jobManager;

    @Inject
    public DownloadEnvironment(FileActionsManager fileActionsManager, JobManager jobManager, FeatureFlips featureFlips, ILocalItemService itemService) {
        Intrinsics.checkNotNullParameter(fileActionsManager, "fileActionsManager");
        Intrinsics.checkNotNullParameter(jobManager, "jobManager");
        Intrinsics.checkNotNullParameter(featureFlips, "featureFlips");
        Intrinsics.checkNotNullParameter(itemService, "itemService");
        this.fileActionsManager = fileActionsManager;
        this.jobManager = jobManager;
        this.featureFlips = featureFlips;
        this.itemService = itemService;
    }

    public final FileActionsManager getFileActionsManager() {
        return this.fileActionsManager;
    }

    public final JobManager getJobManager() {
        return this.jobManager;
    }

    public final FeatureFlips getFeatureFlips() {
        return this.featureFlips;
    }

    public final ILocalItemService getItemService() {
        return this.itemService;
    }
}
