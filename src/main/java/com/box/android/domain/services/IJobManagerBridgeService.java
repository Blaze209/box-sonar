package com.box.android.domain.services;

import com.box.android.data.jobs.JobWorker;
import com.box.android.domain.models.DomainError;
import com.box.android.domain.models.JobInfo;
import com.box.android.domain.models.LegacyJobModel;
import com.box.android.domain.utils.result.Result;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlinx.coroutines.flow.Flow;

/* JADX INFO: compiled from: IJobManagerBridgeService.kt */
/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0005\bf\u0018\u00002\u00020\u0001J;\u0010\u0002\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u00040\u00032\u0006\u0010\u0007\u001a\u00020\b2\u0012\u0010\t\u001a\n\u0012\u0006\b\u0001\u0012\u00020\b0\n\"\u00020\bH&¢\u0006\u0002\u0010\u000bJ \u0010\f\u001a\u0014\u0012\u0004\u0012\u00020\b\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000f0\u000e0\rH¦@¢\u0006\u0002\u0010\u0010J(\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\b2\b\u0010\u0014\u001a\u0004\u0018\u00010\b2\u0006\u0010\u0015\u001a\u00020\u0016H¦@¢\u0006\u0002\u0010\u0017J \u0010\u0018\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\b2\b\u0010\u0014\u001a\u0004\u0018\u00010\bH¦@¢\u0006\u0002\u0010\u0019J,\u0010\u001a\u001a\u000e\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\u00060\u00042\u0006\u0010\u0013\u001a\u00020\b2\b\u0010\u0014\u001a\u0004\u0018\u00010\bH¦@¢\u0006\u0002\u0010\u0019¨\u0006\u001bÀ\u0006\u0003"}, d2 = {"Lcom/box/android/domain/services/IJobManagerBridgeService;", "", "getJobStatus", "Lkotlinx/coroutines/flow/Flow;", "Lcom/box/android/domain/utils/result/Result;", "Lcom/box/android/domain/models/JobInfo$Status;", "Lcom/box/android/domain/models/DomainError;", "fileID", "", "jobTypes", "", "(Ljava/lang/String;[Ljava/lang/String;)Lkotlinx/coroutines/flow/Flow;", "getJobsGrouped", "", "", "Lcom/box/android/domain/models/LegacyJobModel;", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "retryJob", "", JobWorker.JOB_ID_PARAM, "groupId", "isFailure", "", "(Ljava/lang/String;Ljava/lang/String;ZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "forceCancelJob", "(Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "cancelJob", "domain_prodRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public interface IJobManagerBridgeService {
    Object cancelJob(String str, String str2, Continuation<? super Result<Unit, ? extends DomainError>> continuation);

    Object forceCancelJob(String str, String str2, Continuation<? super Unit> continuation);

    Flow<Result<JobInfo.Status, DomainError>> getJobStatus(String fileID, String... jobTypes);

    Object getJobsGrouped(Continuation<? super Map<String, ? extends List<LegacyJobModel>>> continuation);

    Object retryJob(String str, String str2, boolean z, Continuation<? super Unit> continuation);
}
