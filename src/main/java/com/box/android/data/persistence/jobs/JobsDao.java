package com.box.android.data.persistence.jobs;

import com.box.android.coreservices.jobmanager.jobs.DeleteBoxJob;
import com.box.android.data.jobs.JobWorker;
import com.box.android.domain.jobs.JobId;
import com.box.android.domain.models.DomainError;
import java.util.Date;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.random.Random;
import kotlin.ranges.RangesKt;
import kotlinx.coroutines.flow.Flow;
import org.apache.commons.lang3.time.DateUtils;

/* JADX INFO: compiled from: JobsDao.kt */
/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000~\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0012\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0007\bg\u0018\u0000 P2\u00020\u0001:\u0001PJ\u0016\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H§@¢\u0006\u0002\u0010\u0006J\u0016\u0010\u0007\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H§@¢\u0006\u0002\u0010\u0006J\u0016\u0010\b\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H§@¢\u0006\u0002\u0010\u0006J\u0016\u0010\t\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\u000bH§@¢\u0006\u0002\u0010\fJ\u0018\u0010\r\u001a\u0004\u0018\u00010\u00052\u0006\u0010\n\u001a\u00020\u000bH§@¢\u0006\u0002\u0010\fJ\u001a\u0010\u000e\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\u000f\u001a\u00020\u0010H§@¢\u0006\u0002\u0010\u0011J\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u0010H§@¢\u0006\u0002\u0010\u0013J\u000e\u0010\u0014\u001a\u00020\u0015H§@¢\u0006\u0002\u0010\u0013J\u0014\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00180\u0017H§@¢\u0006\u0002\u0010\u0013J\u0014\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u000b0\u0017H§@¢\u0006\u0002\u0010\u0013J\"\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00050\u00172\f\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u000b0\u0017H§@¢\u0006\u0002\u0010\u001cJ\u0014\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u00050\u0017H§@¢\u0006\u0002\u0010\u0013J*\u0010\u001e\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\u001f\u001a\u00020 2\n\b\u0002\u0010!\u001a\u0004\u0018\u00010\"H§@¢\u0006\u0002\u0010#J\u001e\u0010$\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010%\u001a\u00020&H§@¢\u0006\u0002\u0010'J\u0016\u0010(\u001a\u00020\u00152\u0006\u0010\n\u001a\u00020\u000bH§@¢\u0006\u0002\u0010\fJ\u0016\u0010)\u001a\u00020\u00152\u0006\u0010\n\u001a\u00020\u000bH§@¢\u0006\u0002\u0010\fJ\u0016\u0010*\u001a\u00020&2\u0006\u0010\n\u001a\u00020\u000bH§@¢\u0006\u0002\u0010\fJ\u001c\u0010+\u001a\b\u0012\u0004\u0012\u00020\u000b0\u00172\u0006\u0010\n\u001a\u00020\u000bH§@¢\u0006\u0002\u0010\fJ\u0016\u0010,\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\u000bH\u0097@¢\u0006\u0002\u0010\fJ\u0016\u0010-\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\u000bH\u0097@¢\u0006\u0002\u0010\fJ\u0010\u0010.\u001a\u00020\u00102\u0006\u0010/\u001a\u00020\u0015H\u0016J\u0016\u00100\u001a\b\u0012\u0004\u0012\u00020 012\u0006\u0010\n\u001a\u00020\u000bH'J\u001c\u00102\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u0017012\u0006\u00103\u001a\u00020 H'J\u0018\u00104\u001a\u0004\u0018\u00010&2\u0006\u0010\n\u001a\u00020\u000bH§@¢\u0006\u0002\u0010\fJ \u00105\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\u000b2\b\u00106\u001a\u0004\u0018\u00010&H§@¢\u0006\u0002\u0010'J\u0016\u00107\u001a\u0002082\u0006\u00109\u001a\u00020:H§@¢\u0006\u0002\u0010;J\u001c\u0010<\u001a\b\u0012\u0004\u0012\u00020\u000b0\u00172\u0006\u0010\n\u001a\u00020\u000bH§@¢\u0006\u0002\u0010\fJ\u0018\u0010=\u001a\u0004\u0018\u00010\u000b2\u0006\u0010>\u001a\u00020\u000bH§@¢\u0006\u0002\u0010\fJ\u0016\u0010?\u001a\u0002082\u0006\u0010@\u001a\u00020AH§@¢\u0006\u0002\u0010BJ\u0016\u0010C\u001a\u00020A2\u0006\u0010\n\u001a\u00020\u000bH§@¢\u0006\u0002\u0010\fJ\u0016\u0010D\u001a\u0002082\u0006\u0010E\u001a\u00020FH§@¢\u0006\u0002\u0010GJ\u001e\u0010H\u001a\u00020\u00032\u0006\u0010I\u001a\u00020J2\u0006\u0010\n\u001a\u00020\u000bH§@¢\u0006\u0002\u0010KJ\"\u0010L\u001a\b\u0012\u0004\u0012\u00020\u00050\u00172\f\u0010M\u001a\b\u0012\u0004\u0012\u00020J0\u0017H§@¢\u0006\u0002\u0010\u001cJ\u0014\u0010N\u001a\b\u0012\u0004\u0012\u00020\u00050\u0017H§@¢\u0006\u0002\u0010\u0013J\u001c\u0010O\u001a\b\u0012\u0004\u0012\u00020J0\u00172\u0006\u0010\n\u001a\u00020\u000bH§@¢\u0006\u0002\u0010\f¨\u0006QÀ\u0006\u0003"}, d2 = {"Lcom/box/android/data/persistence/jobs/JobsDao;", "", "insertOrUpdateJob", "", "jobEntity", "Lcom/box/android/data/persistence/jobs/JobEntity;", "(Lcom/box/android/data/persistence/jobs/JobEntity;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "updateJob", "insertJob", DeleteBoxJob.TYPE, JobWorker.JOB_ID_PARAM, "Lcom/box/android/domain/jobs/JobId;", "(Lcom/box/android/domain/jobs/JobId;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getJob", "getNextJobToRun", "currentDate", "Ljava/util/Date;", "(Ljava/util/Date;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getEarliestStartDateOfNextJob", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "numberOfExecutingJobs", "", "rootIDsWithRunningJobsCount", "", "Lcom/box/android/data/persistence/jobs/RootIdWithRunningJobsCount;", "waitingRootIDs", "enqueuedJobsWithTheseRootIDs", "rootIDs", "(Ljava/util/List;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "enqueuedJobs", "updateStatusOfJob", "newStatus", "Lcom/box/android/data/persistence/jobs/JobStatus;", "error", "Lcom/box/android/domain/models/DomainError;", "(Lcom/box/android/domain/jobs/JobId;Lcom/box/android/data/persistence/jobs/JobStatus;Lcom/box/android/domain/models/DomainError;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "updateLogDataOfJob", "newLogData", "", "(Lcom/box/android/domain/jobs/JobId;[BLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getAutoRetryCount", "getManualRetryCount", "getLogData", "getChildJobs", "increaseManualRetryInformation", "increaseAutoRetryInformation", "calculateNextStartTimeDelay", "retryCount", "getJobStatus", "Lkotlinx/coroutines/flow/Flow;", "getAllJobsByStatus", "jobStatus", "getJobRunningInfo", "updateRunningInfoOfJob", "runningInfo", "addDependency", "", "jobDependencyRelation", "Lcom/box/android/data/persistence/jobs/JobDependencyRelation;", "(Lcom/box/android/data/persistence/jobs/JobDependencyRelation;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getAllDependentsOnJobAsList", "getPredecessorJobIDOfJob", "jobID", "insertJobIdToWorkId", "jobIdToWorkIdRelation", "Lcom/box/android/data/persistence/jobs/JobIdToWorkIdRelation;", "(Lcom/box/android/data/persistence/jobs/JobIdToWorkIdRelation;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getJobIdToWorkId", "addTagToJob", "jobToTagRelation", "Lcom/box/android/data/persistence/jobs/JobToTagRelation;", "(Lcom/box/android/data/persistence/jobs/JobToTagRelation;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "deleteTagToJob", "tag", "", "(Ljava/lang/String;Lcom/box/android/domain/jobs/JobId;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getJobsWithTags", "tags", "getAllJobs", "getTags", "Companion", "data_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public interface JobsDao {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = Companion.$$INSTANCE;
    public static final double EXPONENTIAL_FACTOR = 2.0d;
    public static final int INITIAL_RETRY_DELAY = 3;
    public static final double JITTER_LOWER_LIMIT = 0.8d;
    public static final double JITTER_UPPER_LIMIT = 1.2d;
    public static final double MAX_DELAY_TIME = 60.0d;

    /* JADX INFO: renamed from: com.box.android.data.persistence.jobs.JobsDao$increaseAutoRetryInformation$1, reason: invalid class name */
    /* JADX INFO: compiled from: JobsDao.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.box.android.data.persistence.jobs.JobsDao", f = "JobsDao.kt", i = {0, 0, 1, 1, 1, 1}, l = {108, 112}, m = "increaseAutoRetryInformation$suspendImpl", n = {"$this", JobWorker.JOB_ID_PARAM, "$this", JobWorker.JOB_ID_PARAM, "it", "$i$a$-let-JobsDao$increaseAutoRetryInformation$2"}, s = {"L$0", "L$1", "L$0", "L$1", "L$2", "I$0"}, v = 1)
    static final class AnonymousClass1 extends ContinuationImpl {
        int I$0;
        Object L$0;
        Object L$1;
        Object L$2;
        int label;
        /* synthetic */ Object result;

        AnonymousClass1(Continuation<? super AnonymousClass1> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return JobsDao.increaseAutoRetryInformation$suspendImpl(JobsDao.this, null, this);
        }
    }

    /* JADX INFO: renamed from: com.box.android.data.persistence.jobs.JobsDao$increaseManualRetryInformation$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: JobsDao.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.box.android.data.persistence.jobs.JobsDao", f = "JobsDao.kt", i = {0, 0, 1, 1, 1, 1}, l = {97, 102}, m = "increaseManualRetryInformation$suspendImpl", n = {"$this", JobWorker.JOB_ID_PARAM, "$this", JobWorker.JOB_ID_PARAM, "it", "$i$a$-let-JobsDao$increaseManualRetryInformation$2"}, s = {"L$0", "L$1", "L$0", "L$1", "L$2", "I$0"}, v = 1)
    static final class C13731 extends ContinuationImpl {
        int I$0;
        Object L$0;
        Object L$1;
        Object L$2;
        int label;
        /* synthetic */ Object result;

        C13731(Continuation<? super C13731> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return JobsDao.increaseManualRetryInformation$suspendImpl(JobsDao.this, null, this);
        }
    }

    Object addDependency(JobDependencyRelation jobDependencyRelation, Continuation<? super Long> continuation);

    Object addTagToJob(JobToTagRelation jobToTagRelation, Continuation<? super Long> continuation);

    Object deleteJob(JobId jobId, Continuation<? super Unit> continuation);

    Object deleteTagToJob(String str, JobId jobId, Continuation<? super Unit> continuation);

    Object enqueuedJobs(Continuation<? super List<JobEntity>> continuation);

    Object enqueuedJobsWithTheseRootIDs(List<JobId> list, Continuation<? super List<JobEntity>> continuation);

    Object getAllDependentsOnJobAsList(JobId jobId, Continuation<? super List<JobId>> continuation);

    Object getAllJobs(Continuation<? super List<JobEntity>> continuation);

    Flow<List<JobEntity>> getAllJobsByStatus(JobStatus jobStatus);

    Object getAutoRetryCount(JobId jobId, Continuation<? super Integer> continuation);

    Object getChildJobs(JobId jobId, Continuation<? super List<JobId>> continuation);

    Object getEarliestStartDateOfNextJob(Continuation<? super Date> continuation);

    Object getJob(JobId jobId, Continuation<? super JobEntity> continuation);

    Object getJobIdToWorkId(JobId jobId, Continuation<? super JobIdToWorkIdRelation> continuation);

    Object getJobRunningInfo(JobId jobId, Continuation<? super byte[]> continuation);

    Flow<JobStatus> getJobStatus(JobId jobId);

    Object getJobsWithTags(List<String> list, Continuation<? super List<JobEntity>> continuation);

    Object getLogData(JobId jobId, Continuation<? super byte[]> continuation);

    Object getManualRetryCount(JobId jobId, Continuation<? super Integer> continuation);

    Object getNextJobToRun(Date date, Continuation<? super JobEntity> continuation);

    Object getPredecessorJobIDOfJob(JobId jobId, Continuation<? super JobId> continuation);

    Object getTags(JobId jobId, Continuation<? super List<String>> continuation);

    default Object increaseAutoRetryInformation(JobId jobId, Continuation<? super Unit> continuation) {
        return increaseAutoRetryInformation$suspendImpl(this, jobId, continuation);
    }

    default Object increaseManualRetryInformation(JobId jobId, Continuation<? super Unit> continuation) {
        return increaseManualRetryInformation$suspendImpl(this, jobId, continuation);
    }

    Object insertJob(JobEntity jobEntity, Continuation<? super Unit> continuation);

    Object insertJobIdToWorkId(JobIdToWorkIdRelation jobIdToWorkIdRelation, Continuation<? super Long> continuation);

    Object insertOrUpdateJob(JobEntity jobEntity, Continuation<? super Unit> continuation);

    Object numberOfExecutingJobs(Continuation<? super Integer> continuation);

    Object rootIDsWithRunningJobsCount(Continuation<? super List<RootIdWithRunningJobsCount>> continuation);

    Object updateJob(JobEntity jobEntity, Continuation<? super Unit> continuation);

    Object updateLogDataOfJob(JobId jobId, byte[] bArr, Continuation<? super Unit> continuation);

    Object updateRunningInfoOfJob(JobId jobId, byte[] bArr, Continuation<? super Unit> continuation);

    Object updateStatusOfJob(JobId jobId, JobStatus jobStatus, DomainError domainError, Continuation<? super Unit> continuation);

    Object waitingRootIDs(Continuation<? super List<JobId>> continuation);

    /* JADX INFO: compiled from: JobsDao.kt */
    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0006\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u000b"}, d2 = {"Lcom/box/android/data/persistence/jobs/JobsDao$Companion;", "", "<init>", "()V", "MAX_DELAY_TIME", "", "INITIAL_RETRY_DELAY", "", "EXPONENTIAL_FACTOR", "JITTER_LOWER_LIMIT", "JITTER_UPPER_LIMIT", "data_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class Companion {
        static final /* synthetic */ Companion $$INSTANCE = new Companion();
        public static final double EXPONENTIAL_FACTOR = 2.0d;
        public static final int INITIAL_RETRY_DELAY = 3;
        public static final double JITTER_LOWER_LIMIT = 0.8d;
        public static final double JITTER_UPPER_LIMIT = 1.2d;
        public static final double MAX_DELAY_TIME = 60.0d;

        private Companion() {
        }
    }

    /* JADX INFO: compiled from: JobsDao.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    public static final class DefaultImpls {
        @Deprecated
        public static Object increaseManualRetryInformation(JobsDao jobsDao, JobId jobId, Continuation<? super Unit> continuation) {
            return JobsDao.super.increaseManualRetryInformation(jobId, continuation);
        }

        @Deprecated
        public static Object increaseAutoRetryInformation(JobsDao jobsDao, JobId jobId, Continuation<? super Unit> continuation) {
            return JobsDao.super.increaseAutoRetryInformation(jobId, continuation);
        }

        @Deprecated
        public static Date calculateNextStartTimeDelay(JobsDao jobsDao, int i) {
            return JobsDao.super.calculateNextStartTimeDelay(i);
        }
    }

    static /* synthetic */ Object getNextJobToRun$default(JobsDao jobsDao, Date date, Continuation continuation, int i, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: getNextJobToRun");
        }
        if ((i & 1) != 0) {
            date = new Date();
        }
        return jobsDao.getNextJobToRun(date, continuation);
    }

    static /* synthetic */ Object updateStatusOfJob$default(JobsDao jobsDao, JobId jobId, JobStatus jobStatus, DomainError domainError, Continuation continuation, int i, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: updateStatusOfJob");
        }
        if ((i & 4) != 0) {
            domainError = null;
        }
        return jobsDao.updateStatusOfJob(jobId, jobStatus, domainError, continuation);
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x009a, code lost:
    
        if (r6.updateJob(r8, r0) == r1) goto L23;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    static /* synthetic */ java.lang.Object increaseManualRetryInformation$suspendImpl(com.box.android.data.persistence.jobs.JobsDao r6, com.box.android.domain.jobs.JobId r7, kotlin.coroutines.Continuation<? super kotlin.Unit> r8) {
        /*
            boolean r0 = r8 instanceof com.box.android.data.persistence.jobs.JobsDao.C13731
            if (r0 == 0) goto L14
            r0 = r8
            com.box.android.data.persistence.jobs.JobsDao$increaseManualRetryInformation$1 r0 = (com.box.android.data.persistence.jobs.JobsDao.C13731) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L14
            int r8 = r0.label
            int r8 = r8 - r2
            r0.label = r8
            goto L19
        L14:
            com.box.android.data.persistence.jobs.JobsDao$increaseManualRetryInformation$1 r0 = new com.box.android.data.persistence.jobs.JobsDao$increaseManualRetryInformation$1
            r0.<init>(r8)
        L19:
            java.lang.Object r8 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 2
            r4 = 1
            if (r2 == 0) goto L50
            if (r2 == r4) goto L43
            if (r2 != r3) goto L3b
            int r6 = r0.I$0
            java.lang.Object r6 = r0.L$2
            com.box.android.data.persistence.jobs.JobEntity r6 = (com.box.android.data.persistence.jobs.JobEntity) r6
            java.lang.Object r6 = r0.L$1
            com.box.android.domain.jobs.JobId r6 = (com.box.android.domain.jobs.JobId) r6
            java.lang.Object r6 = r0.L$0
            com.box.android.data.persistence.jobs.JobsDao r6 = (com.box.android.data.persistence.jobs.JobsDao) r6
            kotlin.ResultKt.throwOnFailure(r8)
            goto L9d
        L3b:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r7)
            throw r6
        L43:
            java.lang.Object r6 = r0.L$1
            r7 = r6
            com.box.android.domain.jobs.JobId r7 = (com.box.android.domain.jobs.JobId) r7
            java.lang.Object r6 = r0.L$0
            com.box.android.data.persistence.jobs.JobsDao r6 = (com.box.android.data.persistence.jobs.JobsDao) r6
            kotlin.ResultKt.throwOnFailure(r8)
            goto L64
        L50:
            kotlin.ResultKt.throwOnFailure(r8)
            r0.L$0 = r6
            java.lang.Object r8 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r7)
            r0.L$1 = r8
            r0.label = r4
            java.lang.Object r8 = r6.getJob(r7, r0)
            if (r8 != r1) goto L64
            goto L9c
        L64:
            com.box.android.data.persistence.jobs.JobEntity r8 = (com.box.android.data.persistence.jobs.JobEntity) r8
            if (r8 == 0) goto L9d
            r2 = 0
            r8.setAutoRetryCount(r2)
            int r5 = r8.getManualRetryCount()
            int r5 = r5 + r4
            r8.setManualRetryCount(r5)
            java.util.Date r4 = r6.calculateNextStartTimeDelay(r2)
            r8.setEarliestStartDate(r4)
            com.box.android.data.persistence.jobs.JobStatus r4 = com.box.android.data.persistence.jobs.JobStatus.ENQUEUED
            r8.setStatus(r4)
            java.lang.Object r4 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r6)
            r0.L$0 = r4
            java.lang.Object r7 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r7)
            r0.L$1 = r7
            java.lang.Object r7 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r8)
            r0.L$2 = r7
            r0.I$0 = r2
            r0.label = r3
            java.lang.Object r6 = r6.updateJob(r8, r0)
            if (r6 != r1) goto L9d
        L9c:
            return r1
        L9d:
            kotlin.Unit r6 = kotlin.Unit.INSTANCE
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.box.android.data.persistence.jobs.JobsDao.increaseManualRetryInformation$suspendImpl(com.box.android.data.persistence.jobs.JobsDao, com.box.android.domain.jobs.JobId, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x009c, code lost:
    
        if (r5.updateJob(r7, r0) == r1) goto L23;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    static /* synthetic */ java.lang.Object increaseAutoRetryInformation$suspendImpl(com.box.android.data.persistence.jobs.JobsDao r5, com.box.android.domain.jobs.JobId r6, kotlin.coroutines.Continuation<? super kotlin.Unit> r7) {
        /*
            boolean r0 = r7 instanceof com.box.android.data.persistence.jobs.JobsDao.AnonymousClass1
            if (r0 == 0) goto L14
            r0 = r7
            com.box.android.data.persistence.jobs.JobsDao$increaseAutoRetryInformation$1 r0 = (com.box.android.data.persistence.jobs.JobsDao.AnonymousClass1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L14
            int r7 = r0.label
            int r7 = r7 - r2
            r0.label = r7
            goto L19
        L14:
            com.box.android.data.persistence.jobs.JobsDao$increaseAutoRetryInformation$1 r0 = new com.box.android.data.persistence.jobs.JobsDao$increaseAutoRetryInformation$1
            r0.<init>(r7)
        L19:
            java.lang.Object r7 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 2
            r4 = 1
            if (r2 == 0) goto L50
            if (r2 == r4) goto L43
            if (r2 != r3) goto L3b
            int r5 = r0.I$0
            java.lang.Object r5 = r0.L$2
            com.box.android.data.persistence.jobs.JobEntity r5 = (com.box.android.data.persistence.jobs.JobEntity) r5
            java.lang.Object r5 = r0.L$1
            com.box.android.domain.jobs.JobId r5 = (com.box.android.domain.jobs.JobId) r5
            java.lang.Object r5 = r0.L$0
            com.box.android.data.persistence.jobs.JobsDao r5 = (com.box.android.data.persistence.jobs.JobsDao) r5
            kotlin.ResultKt.throwOnFailure(r7)
            goto L9f
        L3b:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L43:
            java.lang.Object r5 = r0.L$1
            r6 = r5
            com.box.android.domain.jobs.JobId r6 = (com.box.android.domain.jobs.JobId) r6
            java.lang.Object r5 = r0.L$0
            com.box.android.data.persistence.jobs.JobsDao r5 = (com.box.android.data.persistence.jobs.JobsDao) r5
            kotlin.ResultKt.throwOnFailure(r7)
            goto L64
        L50:
            kotlin.ResultKt.throwOnFailure(r7)
            r0.L$0 = r5
            java.lang.Object r7 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r6)
            r0.L$1 = r7
            r0.label = r4
            java.lang.Object r7 = r5.getJob(r6, r0)
            if (r7 != r1) goto L64
            goto L9e
        L64:
            com.box.android.data.persistence.jobs.JobEntity r7 = (com.box.android.data.persistence.jobs.JobEntity) r7
            if (r7 == 0) goto L9f
            int r2 = r7.getAutoRetryCount()
            int r2 = r2 + r4
            r7.setAutoRetryCount(r2)
            int r2 = r7.getAutoRetryCount()
            int r2 = r2 - r4
            java.util.Date r2 = r5.calculateNextStartTimeDelay(r2)
            r7.setEarliestStartDate(r2)
            com.box.android.data.persistence.jobs.JobStatus r2 = com.box.android.data.persistence.jobs.JobStatus.ENQUEUED
            r7.setStatus(r2)
            java.lang.Object r2 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r5)
            r0.L$0 = r2
            java.lang.Object r6 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r6)
            r0.L$1 = r6
            java.lang.Object r6 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r7)
            r0.L$2 = r6
            r6 = 0
            r0.I$0 = r6
            r0.label = r3
            java.lang.Object r5 = r5.updateJob(r7, r0)
            if (r5 != r1) goto L9f
        L9e:
            return r1
        L9f:
            kotlin.Unit r5 = kotlin.Unit.INSTANCE
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.box.android.data.persistence.jobs.JobsDao.increaseAutoRetryInformation$suspendImpl(com.box.android.data.persistence.jobs.JobsDao, com.box.android.domain.jobs.JobId, kotlin.coroutines.Continuation):java.lang.Object");
    }

    default Date calculateNextStartTimeDelay(int retryCount) {
        Date dateAddSeconds = DateUtils.addSeconds(new Date(), (int) (RangesKt.coerceAtMost(((double) 3) * Math.pow(2.0d, retryCount), 60.0d) * Random.INSTANCE.nextDouble(0.8d, 1.2d)));
        Intrinsics.checkNotNullExpressionValue(dateAddSeconds, "addSeconds(...)");
        return dateAddSeconds;
    }
}
