package com.box.android.workers;

import androidx.work.DelegatingWorkerFactory;
import androidx.work.WorkerFactory;
import com.box.android.domain.services.IJobWorkerFactory;
import com.box.android.observability.WorkManagerWorkerFactory;
import javax.inject.Inject;
import javax.inject.Singleton;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: AllWorkerFactories.kt */
/* JADX INFO: loaded from: classes13.dex */
@Singleton
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u0001B\u0019\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Lcom/box/android/workers/AllWorkerFactories;", "Landroidx/work/DelegatingWorkerFactory;", "workManagerWorkerFactory", "Lcom/box/android/observability/WorkManagerWorkerFactory;", "jobWorkerFactory", "Lcom/box/android/domain/services/IJobWorkerFactory;", "<init>", "(Lcom/box/android/observability/WorkManagerWorkerFactory;Lcom/box/android/domain/services/IJobWorkerFactory;)V", "box_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class AllWorkerFactories extends DelegatingWorkerFactory {
    public static final int $stable = 8;

    /* JADX WARN: Multi-variable type inference failed */
    @Inject
    public AllWorkerFactories(WorkManagerWorkerFactory workManagerWorkerFactory, IJobWorkerFactory jobWorkerFactory) {
        Intrinsics.checkNotNullParameter(workManagerWorkerFactory, "workManagerWorkerFactory");
        Intrinsics.checkNotNullParameter(jobWorkerFactory, "jobWorkerFactory");
        addFactory(workManagerWorkerFactory);
        addFactory((WorkerFactory) jobWorkerFactory);
    }
}
