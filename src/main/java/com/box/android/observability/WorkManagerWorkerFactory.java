package com.box.android.observability;

import android.content.Context;
import androidx.work.ListenableWorker;
import androidx.work.WorkerFactory;
import androidx.work.WorkerParameters;
import com.box.android.common.utilities.WorkerUtilsKt;
import com.box.android.coreservices.jobmanager.JobManager;
import com.box.android.coreservices.jobmanager.tasks.BoxRetryWorker;
import com.box.android.domain.identity.IUserContextManager;
import com.box.android.domain.services.ILocalItemService;
import com.box.android.domain.usecases.observability.MetricsUseCase;
import com.box.android.domain.usecases.observability.UploadLogsUseCase;
import com.box.android.workers.AutoUploadUriTriggerWorker;
import com.box.android.workers.MetricsUploadWorker;
import com.box.boxandroidlibv2private.resourcemanagers.BoxApiPrivate;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.Dispatchers;

/* JADX INFO: compiled from: WorkManagerWorkerFactory.kt */
/* JADX INFO: loaded from: classes12.dex */
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B9\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\u0006\u0010\f\u001a\u00020\r¢\u0006\u0004\b\u000e\u0010\u000fJ\"\u0010\u0010\u001a\u0004\u0018\u00010\u00112\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0017H\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0018"}, d2 = {"Lcom/box/android/observability/WorkManagerWorkerFactory;", "Landroidx/work/WorkerFactory;", "uploadLogsInteractor", "Lcom/box/android/domain/usecases/observability/UploadLogsUseCase;", "metricsInteractor", "Lcom/box/android/domain/usecases/observability/MetricsUseCase;", "userContextManager", "Lcom/box/android/domain/identity/IUserContextManager;", "boxApiPrivate", "Lcom/box/boxandroidlibv2private/resourcemanagers/BoxApiPrivate;", "jobManager", "Lcom/box/android/coreservices/jobmanager/JobManager;", "localItemService", "Lcom/box/android/domain/services/ILocalItemService;", "<init>", "(Lcom/box/android/domain/usecases/observability/UploadLogsUseCase;Lcom/box/android/domain/usecases/observability/MetricsUseCase;Lcom/box/android/domain/identity/IUserContextManager;Lcom/box/boxandroidlibv2private/resourcemanagers/BoxApiPrivate;Lcom/box/android/coreservices/jobmanager/JobManager;Lcom/box/android/domain/services/ILocalItemService;)V", "createWorker", "Landroidx/work/ListenableWorker;", "appContext", "Landroid/content/Context;", "workerClassName", "", "workerParameters", "Landroidx/work/WorkerParameters;", "box_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class WorkManagerWorkerFactory extends WorkerFactory {
    public static final int $stable = 8;
    private final BoxApiPrivate boxApiPrivate;
    private final JobManager jobManager;
    private final ILocalItemService localItemService;
    private final MetricsUseCase metricsInteractor;
    private final UploadLogsUseCase uploadLogsInteractor;
    private final IUserContextManager userContextManager;

    @Inject
    public WorkManagerWorkerFactory(UploadLogsUseCase uploadLogsInteractor, MetricsUseCase metricsInteractor, IUserContextManager userContextManager, BoxApiPrivate boxApiPrivate, JobManager jobManager, ILocalItemService localItemService) {
        Intrinsics.checkNotNullParameter(uploadLogsInteractor, "uploadLogsInteractor");
        Intrinsics.checkNotNullParameter(metricsInteractor, "metricsInteractor");
        Intrinsics.checkNotNullParameter(userContextManager, "userContextManager");
        Intrinsics.checkNotNullParameter(boxApiPrivate, "boxApiPrivate");
        Intrinsics.checkNotNullParameter(jobManager, "jobManager");
        Intrinsics.checkNotNullParameter(localItemService, "localItemService");
        this.uploadLogsInteractor = uploadLogsInteractor;
        this.metricsInteractor = metricsInteractor;
        this.userContextManager = userContextManager;
        this.boxApiPrivate = boxApiPrivate;
        this.jobManager = jobManager;
        this.localItemService = localItemService;
    }

    @Override // androidx.work.WorkerFactory
    public ListenableWorker createWorker(Context appContext, String workerClassName, WorkerParameters workerParameters) {
        Intrinsics.checkNotNullParameter(appContext, "appContext");
        Intrinsics.checkNotNullParameter(workerClassName, "workerClassName");
        Intrinsics.checkNotNullParameter(workerParameters, "workerParameters");
        String strWorkerNameFix = WorkerUtilsKt.workerNameFix(workerClassName);
        if (Class.forName(strWorkerNameFix).isAssignableFrom(UploadLogsWorker.class)) {
            return new UploadLogsWorker(appContext, workerParameters, this.uploadLogsInteractor);
        }
        if (Class.forName(strWorkerNameFix).isAssignableFrom(BoxRetryWorker.class)) {
            return new BoxRetryWorker(appContext, workerParameters, this.jobManager);
        }
        if (Class.forName(strWorkerNameFix).isAssignableFrom(AutoUploadUriTriggerWorker.class)) {
            return new AutoUploadUriTriggerWorker(appContext, workerParameters, this.userContextManager, this.boxApiPrivate, this.localItemService, Dispatchers.getIO());
        }
        if (Class.forName(strWorkerNameFix).isAssignableFrom(MetricsUploadWorker.class)) {
            return new MetricsUploadWorker(appContext, workerParameters, this.metricsInteractor);
        }
        return null;
    }
}
