package com.box.android.coreservices.modelcontroller;

import com.box.android.coreservices.jobmanager.dao.ProgressReporter;
import com.box.android.domain.services.BatchOperationStatus;
import com.box.android.domain.services.IBatchOperationsService;
import com.box.android.domain.utils.BoxTypeIdPair;
import java.util.List;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.MutableStateFlow;
import kotlinx.coroutines.flow.StateFlowKt;

/* JADX INFO: compiled from: BatchOperationsService.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0011\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u001c\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u00072\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\nH\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\f"}, d2 = {"Lcom/box/android/coreservices/modelcontroller/BatchOperationsService;", "Lcom/box/android/domain/services/IBatchOperationsService;", "mocoBatchOperations", "Lcom/box/android/coreservices/modelcontroller/IMoCoBatchOperations;", "<init>", "(Lcom/box/android/coreservices/modelcontroller/IMoCoBatchOperations;)V", "deleteTypeIdPairs", "Lkotlinx/coroutines/flow/Flow;", "Lcom/box/android/domain/services/BatchOperationStatus;", "itemsToDelete", "", "Lcom/box/android/domain/utils/BoxTypeIdPair;", "coreservices_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class BatchOperationsService implements IBatchOperationsService {
    private final IMoCoBatchOperations mocoBatchOperations;

    @Inject
    public BatchOperationsService(IMoCoBatchOperations mocoBatchOperations) {
        Intrinsics.checkNotNullParameter(mocoBatchOperations, "mocoBatchOperations");
        this.mocoBatchOperations = mocoBatchOperations;
    }

    @Override // com.box.android.domain.services.IBatchOperationsService
    public Flow<BatchOperationStatus> deleteTypeIdPairs(List<? extends BoxTypeIdPair> itemsToDelete) {
        Intrinsics.checkNotNullParameter(itemsToDelete, "itemsToDelete");
        final MutableStateFlow MutableStateFlow = StateFlowKt.MutableStateFlow(BatchOperationStatus.Started.INSTANCE);
        this.mocoBatchOperations.deleteTypeIdPairs(itemsToDelete, new ProgressReporter.ProgressListener() { // from class: com.box.android.coreservices.modelcontroller.BatchOperationsService.deleteTypeIdPairs.1
            @Override // com.box.android.coreservices.jobmanager.dao.ProgressReporter.ProgressListener
            public void onPaused(ProgressReporter reporter) {
            }

            @Override // com.box.android.coreservices.jobmanager.dao.ProgressReporter.ProgressListener
            public void onProgressUpdated(ProgressReporter reporter, ProgressReporter.ProgressType type, long progressChangeSinceLastUpdate, long maxChangeSinceLastUpdate) {
            }

            @Override // com.box.android.coreservices.jobmanager.dao.ProgressReporter.ProgressListener
            public void onStarted(ProgressReporter reporter) {
                MutableStateFlow.tryEmit(BatchOperationStatus.Started.INSTANCE);
            }

            @Override // com.box.android.coreservices.jobmanager.dao.ProgressReporter.ProgressListener
            public void onError(ProgressReporter reporter, Exception e) {
                MutableStateFlow.tryEmit(new BatchOperationStatus.Failed(e));
            }

            @Override // com.box.android.coreservices.jobmanager.dao.ProgressReporter.ProgressListener
            public void onCompleted(ProgressReporter reporter) {
                MutableStateFlow.tryEmit(BatchOperationStatus.Successful.INSTANCE);
            }
        });
        return MutableStateFlow;
    }
}
