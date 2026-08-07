package com.box.android.domain.usecases.capture;

import com.box.android.data.jobs.JobWorker;
import com.box.android.domain.jobs.JobId;
import com.box.android.domain.models.CaptureHistoryModel;
import com.box.android.domain.models.DomainError;
import com.box.android.domain.models.ItemId;
import com.box.android.domain.utils.result.Result;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlinx.coroutines.flow.Flow;

/* JADX INFO: compiled from: CaptureHistoryUseCase.kt */
/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\bf\u0018\u00002\u00020\u0001J<\u0010\u0002\u001a,\u0012(\u0012&\u0012\u001c\u0012\u001a\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u0006\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u00060\u0005\u0012\u0004\u0012\u00020\b0\u00040\u00032\b\b\u0002\u0010\t\u001a\u00020\nH&J\u0016\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH¦@¢\u0006\u0002\u0010\u000fJ\u0016\u0010\u0010\u001a\u00020\f2\u0006\u0010\u0011\u001a\u00020\u0012H¦@¢\u0006\u0002\u0010\u0013J&\u0010\u0014\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u0015\u001a\u00020\u00122\u0006\u0010\u0011\u001a\u00020\u0012H¦@¢\u0006\u0002\u0010\u0016¨\u0006\u0017À\u0006\u0003"}, d2 = {"Lcom/box/android/domain/usecases/capture/CaptureHistoryUseCase;", "", "getHistoricalCaptures", "Lkotlinx/coroutines/flow/Flow;", "Lcom/box/android/domain/utils/result/Result;", "Lkotlin/Pair;", "", "Lcom/box/android/domain/models/CaptureHistoryModel;", "Lcom/box/android/domain/models/DomainError;", "preventSuccessFromMoving", "", "retryJob", "", JobWorker.JOB_ID_PARAM, "Lcom/box/android/domain/jobs/JobId;", "(Lcom/box/android/domain/jobs/JobId;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "changeParentFolderForNonRunningJobsAndRetry", "newParentFolderId", "Lcom/box/android/domain/models/ItemId;", "(Lcom/box/android/domain/models/ItemId;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "changeParentFolderOfJobAndRetry", "itemId", "(Lcom/box/android/domain/jobs/JobId;Lcom/box/android/domain/models/ItemId;Lcom/box/android/domain/models/ItemId;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "domain_prodRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public interface CaptureHistoryUseCase {
    Object changeParentFolderForNonRunningJobsAndRetry(ItemId itemId, Continuation<? super Unit> continuation);

    Object changeParentFolderOfJobAndRetry(JobId jobId, ItemId itemId, ItemId itemId2, Continuation<? super Unit> continuation);

    Flow<Result<Pair<List<CaptureHistoryModel>, List<CaptureHistoryModel>>, DomainError>> getHistoricalCaptures(boolean preventSuccessFromMoving);

    Object retryJob(JobId jobId, Continuation<? super Unit> continuation);

    /* JADX INFO: compiled from: CaptureHistoryUseCase.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    public static final class DefaultImpls {
    }

    static /* synthetic */ Flow getHistoricalCaptures$default(CaptureHistoryUseCase captureHistoryUseCase, boolean z, int i, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: getHistoricalCaptures");
        }
        if ((i & 1) != 0) {
            z = true;
        }
        return captureHistoryUseCase.getHistoricalCaptures(z);
    }
}
