package com.box.android.data.persistence.jobs;

import androidx.room.EntityDeleteOrUpdateAdapter;
import androidx.room.EntityInsertAdapter;
import androidx.room.EntityUpsertAdapter;
import androidx.room.RoomDatabase;
import androidx.room.coroutines.FlowUtil;
import androidx.room.util.DBUtil;
import androidx.room.util.SQLiteStatementUtil;
import androidx.room.util.StringUtil;
import androidx.sqlite.SQLiteConnection;
import androidx.sqlite.SQLiteStatement;
import com.box.android.coreservices.jobmanager.jobs.DeleteBoxJob;
import com.box.android.data.jobs.JobWorker;
import com.box.android.data.persistence.DateToLongConverter;
import com.box.android.domain.jobs.JobId;
import com.box.android.domain.models.DomainError;
import com.google.firebase.analytics.FirebaseAnalytics;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KClass;
import kotlinx.coroutines.flow.Flow;

/* JADX INFO: compiled from: JobsDao_Impl.kt */
/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000¨\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0012\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u000b\u0018\u0000 c2\u00020\u0001:\u0001cB\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0016\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\bH\u0096@¢\u0006\u0002\u0010\u001eJ\u0016\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020\u0012H\u0096@¢\u0006\u0002\u0010\"J\u0016\u0010#\u001a\u00020 2\u0006\u0010$\u001a\u00020\u0014H\u0096@¢\u0006\u0002\u0010%J\u0016\u0010&\u001a\u00020 2\u0006\u0010'\u001a\u00020\u0016H\u0096@¢\u0006\u0002\u0010(J\u0016\u0010)\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\bH\u0096@¢\u0006\u0002\u0010\u001eJ\u0016\u0010*\u001a\u00020\u001c2\u0006\u0010+\u001a\u00020,H\u0096@¢\u0006\u0002\u0010-J\u0016\u0010.\u001a\u00020\u001c2\u0006\u0010+\u001a\u00020,H\u0096@¢\u0006\u0002\u0010-J\u0016\u0010/\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\bH\u0096@¢\u0006\u0002\u0010\u001eJ\u0018\u00100\u001a\u0004\u0018\u00010\b2\u0006\u0010+\u001a\u00020,H\u0096@¢\u0006\u0002\u0010-J\u0018\u00101\u001a\u0004\u0018\u00010\b2\u0006\u00102\u001a\u000203H\u0096@¢\u0006\u0002\u00104J\u0010\u00105\u001a\u0004\u0018\u000103H\u0096@¢\u0006\u0002\u00106J\u000e\u00107\u001a\u000208H\u0096@¢\u0006\u0002\u00106J\u0014\u00109\u001a\b\u0012\u0004\u0012\u00020;0:H\u0096@¢\u0006\u0002\u00106J\u0014\u0010<\u001a\b\u0012\u0004\u0012\u00020,0:H\u0096@¢\u0006\u0002\u00106J\"\u0010=\u001a\b\u0012\u0004\u0012\u00020\b0:2\f\u0010>\u001a\b\u0012\u0004\u0012\u00020,0:H\u0096@¢\u0006\u0002\u0010?J\u0014\u0010@\u001a\b\u0012\u0004\u0012\u00020\b0:H\u0096@¢\u0006\u0002\u00106J\u0016\u0010A\u001a\u0002082\u0006\u0010+\u001a\u00020,H\u0096@¢\u0006\u0002\u0010-J\u0016\u0010B\u001a\u0002082\u0006\u0010+\u001a\u00020,H\u0096@¢\u0006\u0002\u0010-J\u0016\u0010C\u001a\u00020D2\u0006\u0010+\u001a\u00020,H\u0096@¢\u0006\u0002\u0010-J\u001c\u0010E\u001a\b\u0012\u0004\u0012\u00020,0:2\u0006\u0010+\u001a\u00020,H\u0096@¢\u0006\u0002\u0010-J\u0016\u0010F\u001a\b\u0012\u0004\u0012\u00020H0G2\u0006\u0010+\u001a\u00020,H\u0016J\u001c\u0010I\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0:0G2\u0006\u0010J\u001a\u00020HH\u0016J\u0018\u0010K\u001a\u0004\u0018\u00010D2\u0006\u0010+\u001a\u00020,H\u0096@¢\u0006\u0002\u0010-J\u001c\u0010L\u001a\b\u0012\u0004\u0012\u00020,0:2\u0006\u0010+\u001a\u00020,H\u0096@¢\u0006\u0002\u0010-J\u0018\u0010M\u001a\u0004\u0018\u00010,2\u0006\u0010N\u001a\u00020,H\u0096@¢\u0006\u0002\u0010-J\u0016\u0010O\u001a\u00020\u00142\u0006\u0010+\u001a\u00020,H\u0096@¢\u0006\u0002\u0010-J\"\u0010P\u001a\b\u0012\u0004\u0012\u00020\b0:2\f\u0010Q\u001a\b\u0012\u0004\u0012\u00020R0:H\u0096@¢\u0006\u0002\u0010?J\u0014\u0010S\u001a\b\u0012\u0004\u0012\u00020\b0:H\u0096@¢\u0006\u0002\u00106J\u001c\u0010T\u001a\b\u0012\u0004\u0012\u00020R0:2\u0006\u0010+\u001a\u00020,H\u0096@¢\u0006\u0002\u0010-J\u0016\u0010U\u001a\u00020\u001c2\u0006\u0010+\u001a\u00020,H\u0096@¢\u0006\u0002\u0010-J(\u0010V\u001a\u00020\u001c2\u0006\u0010+\u001a\u00020,2\u0006\u0010W\u001a\u00020H2\b\u0010X\u001a\u0004\u0018\u00010YH\u0096@¢\u0006\u0002\u0010ZJ\u001e\u0010[\u001a\u00020\u001c2\u0006\u0010+\u001a\u00020,2\u0006\u0010\\\u001a\u00020DH\u0096@¢\u0006\u0002\u0010]J \u0010^\u001a\u00020\u001c2\u0006\u0010+\u001a\u00020,2\b\u0010_\u001a\u0004\u0018\u00010DH\u0096@¢\u0006\u0002\u0010]J\u001e\u0010`\u001a\u00020\u001c2\u0006\u0010a\u001a\u00020R2\u0006\u0010+\u001a\u00020,H\u0096@¢\u0006\u0002\u0010bR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00120\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00140\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00160\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\b0\u0018X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\b0\u001aX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006d"}, d2 = {"Lcom/box/android/data/persistence/jobs/JobsDao_Impl;", "Lcom/box/android/data/persistence/jobs/JobsDao;", "__db", "Landroidx/room/RoomDatabase;", "<init>", "(Landroidx/room/RoomDatabase;)V", "__insertAdapterOfJobEntity", "Landroidx/room/EntityInsertAdapter;", "Lcom/box/android/data/persistence/jobs/JobEntity;", "__jobIdConverter", "Lcom/box/android/data/persistence/jobs/JobIdConverter;", "__jobStatusConverter", "Lcom/box/android/data/persistence/jobs/JobStatusConverter;", "__dateToLongConverter", "Lcom/box/android/data/persistence/DateToLongConverter;", "__domainErrorConverter", "Lcom/box/android/data/persistence/jobs/DomainErrorConverter;", "__insertAdapterOfJobDependencyRelation", "Lcom/box/android/data/persistence/jobs/JobDependencyRelation;", "__insertAdapterOfJobIdToWorkIdRelation", "Lcom/box/android/data/persistence/jobs/JobIdToWorkIdRelation;", "__insertAdapterOfJobToTagRelation", "Lcom/box/android/data/persistence/jobs/JobToTagRelation;", "__updateAdapterOfJobEntity", "Landroidx/room/EntityDeleteOrUpdateAdapter;", "__upsertAdapterOfJobEntity", "Landroidx/room/EntityUpsertAdapter;", "insertJob", "", "jobEntity", "(Lcom/box/android/data/persistence/jobs/JobEntity;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "addDependency", "", "jobDependencyRelation", "(Lcom/box/android/data/persistence/jobs/JobDependencyRelation;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "insertJobIdToWorkId", "jobIdToWorkIdRelation", "(Lcom/box/android/data/persistence/jobs/JobIdToWorkIdRelation;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "addTagToJob", "jobToTagRelation", "(Lcom/box/android/data/persistence/jobs/JobToTagRelation;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "updateJob", "increaseManualRetryInformation", JobWorker.JOB_ID_PARAM, "Lcom/box/android/domain/jobs/JobId;", "(Lcom/box/android/domain/jobs/JobId;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "increaseAutoRetryInformation", "insertOrUpdateJob", "getJob", "getNextJobToRun", "currentDate", "Ljava/util/Date;", "(Ljava/util/Date;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getEarliestStartDateOfNextJob", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "numberOfExecutingJobs", "", "rootIDsWithRunningJobsCount", "", "Lcom/box/android/data/persistence/jobs/RootIdWithRunningJobsCount;", "waitingRootIDs", "enqueuedJobsWithTheseRootIDs", "rootIDs", "(Ljava/util/List;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "enqueuedJobs", "getAutoRetryCount", "getManualRetryCount", "getLogData", "", "getChildJobs", "getJobStatus", "Lkotlinx/coroutines/flow/Flow;", "Lcom/box/android/data/persistence/jobs/JobStatus;", "getAllJobsByStatus", "jobStatus", "getJobRunningInfo", "getAllDependentsOnJobAsList", "getPredecessorJobIDOfJob", "jobID", "getJobIdToWorkId", "getJobsWithTags", "tags", "", "getAllJobs", "getTags", DeleteBoxJob.TYPE, "updateStatusOfJob", "newStatus", "error", "Lcom/box/android/domain/models/DomainError;", "(Lcom/box/android/domain/jobs/JobId;Lcom/box/android/data/persistence/jobs/JobStatus;Lcom/box/android/domain/models/DomainError;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "updateLogDataOfJob", "newLogData", "(Lcom/box/android/domain/jobs/JobId;[BLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "updateRunningInfoOfJob", "runningInfo", "deleteTagToJob", "tag", "(Ljava/lang/String;Lcom/box/android/domain/jobs/JobId;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Companion", "data_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class JobsDao_Impl implements JobsDao {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final DateToLongConverter __dateToLongConverter;
    private final RoomDatabase __db;
    private final DomainErrorConverter __domainErrorConverter;
    private final EntityInsertAdapter<JobDependencyRelation> __insertAdapterOfJobDependencyRelation;
    private final EntityInsertAdapter<JobEntity> __insertAdapterOfJobEntity;
    private final EntityInsertAdapter<JobIdToWorkIdRelation> __insertAdapterOfJobIdToWorkIdRelation;
    private final EntityInsertAdapter<JobToTagRelation> __insertAdapterOfJobToTagRelation;
    private final JobIdConverter __jobIdConverter;
    private final JobStatusConverter __jobStatusConverter;
    private final EntityDeleteOrUpdateAdapter<JobEntity> __updateAdapterOfJobEntity;
    private final EntityUpsertAdapter<JobEntity> __upsertAdapterOfJobEntity;

    public JobsDao_Impl(RoomDatabase __db) {
        Intrinsics.checkNotNullParameter(__db, "__db");
        this.__jobIdConverter = new JobIdConverter();
        this.__jobStatusConverter = new JobStatusConverter();
        this.__dateToLongConverter = new DateToLongConverter();
        this.__domainErrorConverter = new DomainErrorConverter();
        this.__db = __db;
        this.__insertAdapterOfJobEntity = new EntityInsertAdapter<JobEntity>() { // from class: com.box.android.data.persistence.jobs.JobsDao_Impl.1
            @Override // androidx.room.EntityInsertAdapter
            protected String createQuery() {
                return "INSERT OR ABORT INTO `job` (`id`,`job_type`,`input_data`,`status`,`created_at`,`start_date`,`earliest_start_date`,`auto_retry_count`,`manual_retry_count`,`running_info`,`error_info`,`parentID`,`rootID`,`sortKey`,`log_data`) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // androidx.room.EntityInsertAdapter
            public void bind(SQLiteStatement statement, JobEntity entity) {
                Intrinsics.checkNotNullParameter(statement, "statement");
                Intrinsics.checkNotNullParameter(entity, "entity");
                String string = JobsDao_Impl.this.__jobIdConverter.toString(entity.getId());
                if (string == null) {
                    statement.mo10943bindNull(1);
                } else {
                    statement.mo10944bindText(1, string);
                }
                statement.mo10944bindText(2, entity.getType());
                statement.mo10940bindBlob(3, entity.getInputData());
                String string2 = JobsDao_Impl.this.__jobStatusConverter.toString(entity.getStatus());
                if (string2 == null) {
                    statement.mo10943bindNull(4);
                } else {
                    statement.mo10944bindText(4, string2);
                }
                Long lDateToTimestamp = JobsDao_Impl.this.__dateToLongConverter.dateToTimestamp(entity.getCreatedAt());
                if (lDateToTimestamp == null) {
                    statement.mo10943bindNull(5);
                } else {
                    statement.mo10942bindLong(5, lDateToTimestamp.longValue());
                }
                Long lDateToTimestamp2 = JobsDao_Impl.this.__dateToLongConverter.dateToTimestamp(entity.getStartDate());
                if (lDateToTimestamp2 == null) {
                    statement.mo10943bindNull(6);
                } else {
                    statement.mo10942bindLong(6, lDateToTimestamp2.longValue());
                }
                Long lDateToTimestamp3 = JobsDao_Impl.this.__dateToLongConverter.dateToTimestamp(entity.getEarliestStartDate());
                if (lDateToTimestamp3 == null) {
                    statement.mo10943bindNull(7);
                } else {
                    statement.mo10942bindLong(7, lDateToTimestamp3.longValue());
                }
                statement.mo10942bindLong(8, entity.getAutoRetryCount());
                statement.mo10942bindLong(9, entity.getManualRetryCount());
                byte[] runningInfo = entity.getRunningInfo();
                if (runningInfo == null) {
                    statement.mo10943bindNull(10);
                } else {
                    statement.mo10940bindBlob(10, runningInfo);
                }
                String string3 = JobsDao_Impl.this.__domainErrorConverter.toString(entity.getErrorInfo());
                if (string3 == null) {
                    statement.mo10943bindNull(11);
                } else {
                    statement.mo10944bindText(11, string3);
                }
                String string4 = JobsDao_Impl.this.__jobIdConverter.toString(entity.getParentID());
                if (string4 == null) {
                    statement.mo10943bindNull(12);
                } else {
                    statement.mo10944bindText(12, string4);
                }
                String string5 = JobsDao_Impl.this.__jobIdConverter.toString(entity.getRootID());
                if (string5 == null) {
                    statement.mo10943bindNull(13);
                } else {
                    statement.mo10944bindText(13, string5);
                }
                statement.mo10944bindText(14, entity.getSortKey());
                statement.mo10940bindBlob(15, entity.getLogData());
            }
        };
        this.__insertAdapterOfJobDependencyRelation = new EntityInsertAdapter<JobDependencyRelation>() { // from class: com.box.android.data.persistence.jobs.JobsDao_Impl.2
            @Override // androidx.room.EntityInsertAdapter
            protected String createQuery() {
                return "INSERT OR REPLACE INTO `job_dependency` (`successor`,`predecessor`) VALUES (?,?)";
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // androidx.room.EntityInsertAdapter
            public void bind(SQLiteStatement statement, JobDependencyRelation entity) {
                Intrinsics.checkNotNullParameter(statement, "statement");
                Intrinsics.checkNotNullParameter(entity, "entity");
                String string = JobsDao_Impl.this.__jobIdConverter.toString(entity.getSuccessor());
                if (string == null) {
                    statement.mo10943bindNull(1);
                } else {
                    statement.mo10944bindText(1, string);
                }
                String string2 = JobsDao_Impl.this.__jobIdConverter.toString(entity.getPredecessor());
                if (string2 == null) {
                    statement.mo10943bindNull(2);
                } else {
                    statement.mo10944bindText(2, string2);
                }
            }
        };
        this.__insertAdapterOfJobIdToWorkIdRelation = new EntityInsertAdapter<JobIdToWorkIdRelation>() { // from class: com.box.android.data.persistence.jobs.JobsDao_Impl.3
            @Override // androidx.room.EntityInsertAdapter
            protected String createQuery() {
                return "INSERT OR REPLACE INTO `job_id_to_work_id` (`job_id`,`work_id`) VALUES (?,?)";
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // androidx.room.EntityInsertAdapter
            public void bind(SQLiteStatement statement, JobIdToWorkIdRelation entity) {
                Intrinsics.checkNotNullParameter(statement, "statement");
                Intrinsics.checkNotNullParameter(entity, "entity");
                String string = JobsDao_Impl.this.__jobIdConverter.toString(entity.getJobId());
                if (string == null) {
                    statement.mo10943bindNull(1);
                } else {
                    statement.mo10944bindText(1, string);
                }
                statement.mo10944bindText(2, entity.getWorkId());
            }
        };
        this.__insertAdapterOfJobToTagRelation = new EntityInsertAdapter<JobToTagRelation>() { // from class: com.box.android.data.persistence.jobs.JobsDao_Impl.4
            @Override // androidx.room.EntityInsertAdapter
            protected String createQuery() {
                return "INSERT OR REPLACE INTO `job_to_tag` (`tag`,`job_id`) VALUES (?,?)";
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // androidx.room.EntityInsertAdapter
            public void bind(SQLiteStatement statement, JobToTagRelation entity) {
                Intrinsics.checkNotNullParameter(statement, "statement");
                Intrinsics.checkNotNullParameter(entity, "entity");
                statement.mo10944bindText(1, entity.getTag());
                String string = JobsDao_Impl.this.__jobIdConverter.toString(entity.getJobId());
                if (string == null) {
                    statement.mo10943bindNull(2);
                } else {
                    statement.mo10944bindText(2, string);
                }
            }
        };
        this.__updateAdapterOfJobEntity = new EntityDeleteOrUpdateAdapter<JobEntity>() { // from class: com.box.android.data.persistence.jobs.JobsDao_Impl.5
            @Override // androidx.room.EntityDeleteOrUpdateAdapter
            protected String createQuery() {
                return "UPDATE OR ABORT `job` SET `id` = ?,`job_type` = ?,`input_data` = ?,`status` = ?,`created_at` = ?,`start_date` = ?,`earliest_start_date` = ?,`auto_retry_count` = ?,`manual_retry_count` = ?,`running_info` = ?,`error_info` = ?,`parentID` = ?,`rootID` = ?,`sortKey` = ?,`log_data` = ? WHERE `id` = ?";
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // androidx.room.EntityDeleteOrUpdateAdapter
            public void bind(SQLiteStatement statement, JobEntity entity) {
                Intrinsics.checkNotNullParameter(statement, "statement");
                Intrinsics.checkNotNullParameter(entity, "entity");
                String string = JobsDao_Impl.this.__jobIdConverter.toString(entity.getId());
                if (string == null) {
                    statement.mo10943bindNull(1);
                } else {
                    statement.mo10944bindText(1, string);
                }
                statement.mo10944bindText(2, entity.getType());
                statement.mo10940bindBlob(3, entity.getInputData());
                String string2 = JobsDao_Impl.this.__jobStatusConverter.toString(entity.getStatus());
                if (string2 == null) {
                    statement.mo10943bindNull(4);
                } else {
                    statement.mo10944bindText(4, string2);
                }
                Long lDateToTimestamp = JobsDao_Impl.this.__dateToLongConverter.dateToTimestamp(entity.getCreatedAt());
                if (lDateToTimestamp == null) {
                    statement.mo10943bindNull(5);
                } else {
                    statement.mo10942bindLong(5, lDateToTimestamp.longValue());
                }
                Long lDateToTimestamp2 = JobsDao_Impl.this.__dateToLongConverter.dateToTimestamp(entity.getStartDate());
                if (lDateToTimestamp2 == null) {
                    statement.mo10943bindNull(6);
                } else {
                    statement.mo10942bindLong(6, lDateToTimestamp2.longValue());
                }
                Long lDateToTimestamp3 = JobsDao_Impl.this.__dateToLongConverter.dateToTimestamp(entity.getEarliestStartDate());
                if (lDateToTimestamp3 == null) {
                    statement.mo10943bindNull(7);
                } else {
                    statement.mo10942bindLong(7, lDateToTimestamp3.longValue());
                }
                statement.mo10942bindLong(8, entity.getAutoRetryCount());
                statement.mo10942bindLong(9, entity.getManualRetryCount());
                byte[] runningInfo = entity.getRunningInfo();
                if (runningInfo == null) {
                    statement.mo10943bindNull(10);
                } else {
                    statement.mo10940bindBlob(10, runningInfo);
                }
                String string3 = JobsDao_Impl.this.__domainErrorConverter.toString(entity.getErrorInfo());
                if (string3 == null) {
                    statement.mo10943bindNull(11);
                } else {
                    statement.mo10944bindText(11, string3);
                }
                String string4 = JobsDao_Impl.this.__jobIdConverter.toString(entity.getParentID());
                if (string4 == null) {
                    statement.mo10943bindNull(12);
                } else {
                    statement.mo10944bindText(12, string4);
                }
                String string5 = JobsDao_Impl.this.__jobIdConverter.toString(entity.getRootID());
                if (string5 == null) {
                    statement.mo10943bindNull(13);
                } else {
                    statement.mo10944bindText(13, string5);
                }
                statement.mo10944bindText(14, entity.getSortKey());
                statement.mo10940bindBlob(15, entity.getLogData());
                String string6 = JobsDao_Impl.this.__jobIdConverter.toString(entity.getId());
                if (string6 == null) {
                    statement.mo10943bindNull(16);
                } else {
                    statement.mo10944bindText(16, string6);
                }
            }
        };
        this.__upsertAdapterOfJobEntity = new EntityUpsertAdapter<>(new EntityInsertAdapter<JobEntity>() { // from class: com.box.android.data.persistence.jobs.JobsDao_Impl.6
            @Override // androidx.room.EntityInsertAdapter
            protected String createQuery() {
                return "INSERT INTO `job` (`id`,`job_type`,`input_data`,`status`,`created_at`,`start_date`,`earliest_start_date`,`auto_retry_count`,`manual_retry_count`,`running_info`,`error_info`,`parentID`,`rootID`,`sortKey`,`log_data`) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // androidx.room.EntityInsertAdapter
            public void bind(SQLiteStatement statement, JobEntity entity) {
                Intrinsics.checkNotNullParameter(statement, "statement");
                Intrinsics.checkNotNullParameter(entity, "entity");
                String string = JobsDao_Impl.this.__jobIdConverter.toString(entity.getId());
                if (string == null) {
                    statement.mo10943bindNull(1);
                } else {
                    statement.mo10944bindText(1, string);
                }
                statement.mo10944bindText(2, entity.getType());
                statement.mo10940bindBlob(3, entity.getInputData());
                String string2 = JobsDao_Impl.this.__jobStatusConverter.toString(entity.getStatus());
                if (string2 == null) {
                    statement.mo10943bindNull(4);
                } else {
                    statement.mo10944bindText(4, string2);
                }
                Long lDateToTimestamp = JobsDao_Impl.this.__dateToLongConverter.dateToTimestamp(entity.getCreatedAt());
                if (lDateToTimestamp == null) {
                    statement.mo10943bindNull(5);
                } else {
                    statement.mo10942bindLong(5, lDateToTimestamp.longValue());
                }
                Long lDateToTimestamp2 = JobsDao_Impl.this.__dateToLongConverter.dateToTimestamp(entity.getStartDate());
                if (lDateToTimestamp2 == null) {
                    statement.mo10943bindNull(6);
                } else {
                    statement.mo10942bindLong(6, lDateToTimestamp2.longValue());
                }
                Long lDateToTimestamp3 = JobsDao_Impl.this.__dateToLongConverter.dateToTimestamp(entity.getEarliestStartDate());
                if (lDateToTimestamp3 == null) {
                    statement.mo10943bindNull(7);
                } else {
                    statement.mo10942bindLong(7, lDateToTimestamp3.longValue());
                }
                statement.mo10942bindLong(8, entity.getAutoRetryCount());
                statement.mo10942bindLong(9, entity.getManualRetryCount());
                byte[] runningInfo = entity.getRunningInfo();
                if (runningInfo == null) {
                    statement.mo10943bindNull(10);
                } else {
                    statement.mo10940bindBlob(10, runningInfo);
                }
                String string3 = JobsDao_Impl.this.__domainErrorConverter.toString(entity.getErrorInfo());
                if (string3 == null) {
                    statement.mo10943bindNull(11);
                } else {
                    statement.mo10944bindText(11, string3);
                }
                String string4 = JobsDao_Impl.this.__jobIdConverter.toString(entity.getParentID());
                if (string4 == null) {
                    statement.mo10943bindNull(12);
                } else {
                    statement.mo10944bindText(12, string4);
                }
                String string5 = JobsDao_Impl.this.__jobIdConverter.toString(entity.getRootID());
                if (string5 == null) {
                    statement.mo10943bindNull(13);
                } else {
                    statement.mo10944bindText(13, string5);
                }
                statement.mo10944bindText(14, entity.getSortKey());
                statement.mo10940bindBlob(15, entity.getLogData());
            }
        }, new EntityDeleteOrUpdateAdapter<JobEntity>() { // from class: com.box.android.data.persistence.jobs.JobsDao_Impl.7
            @Override // androidx.room.EntityDeleteOrUpdateAdapter
            protected String createQuery() {
                return "UPDATE `job` SET `id` = ?,`job_type` = ?,`input_data` = ?,`status` = ?,`created_at` = ?,`start_date` = ?,`earliest_start_date` = ?,`auto_retry_count` = ?,`manual_retry_count` = ?,`running_info` = ?,`error_info` = ?,`parentID` = ?,`rootID` = ?,`sortKey` = ?,`log_data` = ? WHERE `id` = ?";
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // androidx.room.EntityDeleteOrUpdateAdapter
            public void bind(SQLiteStatement statement, JobEntity entity) {
                Intrinsics.checkNotNullParameter(statement, "statement");
                Intrinsics.checkNotNullParameter(entity, "entity");
                String string = JobsDao_Impl.this.__jobIdConverter.toString(entity.getId());
                if (string == null) {
                    statement.mo10943bindNull(1);
                } else {
                    statement.mo10944bindText(1, string);
                }
                statement.mo10944bindText(2, entity.getType());
                statement.mo10940bindBlob(3, entity.getInputData());
                String string2 = JobsDao_Impl.this.__jobStatusConverter.toString(entity.getStatus());
                if (string2 == null) {
                    statement.mo10943bindNull(4);
                } else {
                    statement.mo10944bindText(4, string2);
                }
                Long lDateToTimestamp = JobsDao_Impl.this.__dateToLongConverter.dateToTimestamp(entity.getCreatedAt());
                if (lDateToTimestamp == null) {
                    statement.mo10943bindNull(5);
                } else {
                    statement.mo10942bindLong(5, lDateToTimestamp.longValue());
                }
                Long lDateToTimestamp2 = JobsDao_Impl.this.__dateToLongConverter.dateToTimestamp(entity.getStartDate());
                if (lDateToTimestamp2 == null) {
                    statement.mo10943bindNull(6);
                } else {
                    statement.mo10942bindLong(6, lDateToTimestamp2.longValue());
                }
                Long lDateToTimestamp3 = JobsDao_Impl.this.__dateToLongConverter.dateToTimestamp(entity.getEarliestStartDate());
                if (lDateToTimestamp3 == null) {
                    statement.mo10943bindNull(7);
                } else {
                    statement.mo10942bindLong(7, lDateToTimestamp3.longValue());
                }
                statement.mo10942bindLong(8, entity.getAutoRetryCount());
                statement.mo10942bindLong(9, entity.getManualRetryCount());
                byte[] runningInfo = entity.getRunningInfo();
                if (runningInfo == null) {
                    statement.mo10943bindNull(10);
                } else {
                    statement.mo10940bindBlob(10, runningInfo);
                }
                String string3 = JobsDao_Impl.this.__domainErrorConverter.toString(entity.getErrorInfo());
                if (string3 == null) {
                    statement.mo10943bindNull(11);
                } else {
                    statement.mo10944bindText(11, string3);
                }
                String string4 = JobsDao_Impl.this.__jobIdConverter.toString(entity.getParentID());
                if (string4 == null) {
                    statement.mo10943bindNull(12);
                } else {
                    statement.mo10944bindText(12, string4);
                }
                String string5 = JobsDao_Impl.this.__jobIdConverter.toString(entity.getRootID());
                if (string5 == null) {
                    statement.mo10943bindNull(13);
                } else {
                    statement.mo10944bindText(13, string5);
                }
                statement.mo10944bindText(14, entity.getSortKey());
                statement.mo10940bindBlob(15, entity.getLogData());
                String string6 = JobsDao_Impl.this.__jobIdConverter.toString(entity.getId());
                if (string6 == null) {
                    statement.mo10943bindNull(16);
                } else {
                    statement.mo10944bindText(16, string6);
                }
            }
        });
    }

    @Override // com.box.android.data.persistence.jobs.JobsDao
    public /* bridge */ Date calculateNextStartTimeDelay(int i) {
        return super.calculateNextStartTimeDelay(i);
    }

    @Override // com.box.android.data.persistence.jobs.JobsDao
    public Object insertJob(final JobEntity jobEntity, Continuation<? super Unit> continuation) {
        Object objPerformSuspending = DBUtil.performSuspending(this.__db, false, true, new Function1() { // from class: com.box.android.data.persistence.jobs.JobsDao_Impl$$ExternalSyntheticLambda23
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return JobsDao_Impl.insertJob$lambda$0(this.f$0, jobEntity, (SQLiteConnection) obj);
            }
        }, continuation);
        return objPerformSuspending == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objPerformSuspending : Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit insertJob$lambda$0(JobsDao_Impl jobsDao_Impl, JobEntity jobEntity, SQLiteConnection _connection) throws Exception {
        Intrinsics.checkNotNullParameter(_connection, "_connection");
        jobsDao_Impl.__insertAdapterOfJobEntity.insert(_connection, jobEntity);
        return Unit.INSTANCE;
    }

    @Override // com.box.android.data.persistence.jobs.JobsDao
    public Object addDependency(final JobDependencyRelation jobDependencyRelation, Continuation<? super Long> continuation) {
        return DBUtil.performSuspending(this.__db, false, true, new Function1() { // from class: com.box.android.data.persistence.jobs.JobsDao_Impl$$ExternalSyntheticLambda19
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return Long.valueOf(JobsDao_Impl.addDependency$lambda$0(this.f$0, jobDependencyRelation, (SQLiteConnection) obj));
            }
        }, continuation);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final long addDependency$lambda$0(JobsDao_Impl jobsDao_Impl, JobDependencyRelation jobDependencyRelation, SQLiteConnection _connection) {
        Intrinsics.checkNotNullParameter(_connection, "_connection");
        return jobsDao_Impl.__insertAdapterOfJobDependencyRelation.insertAndReturnId(_connection, jobDependencyRelation);
    }

    @Override // com.box.android.data.persistence.jobs.JobsDao
    public Object insertJobIdToWorkId(final JobIdToWorkIdRelation jobIdToWorkIdRelation, Continuation<? super Long> continuation) {
        return DBUtil.performSuspending(this.__db, false, true, new Function1() { // from class: com.box.android.data.persistence.jobs.JobsDao_Impl$$ExternalSyntheticLambda29
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return Long.valueOf(JobsDao_Impl.insertJobIdToWorkId$lambda$0(this.f$0, jobIdToWorkIdRelation, (SQLiteConnection) obj));
            }
        }, continuation);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final long insertJobIdToWorkId$lambda$0(JobsDao_Impl jobsDao_Impl, JobIdToWorkIdRelation jobIdToWorkIdRelation, SQLiteConnection _connection) {
        Intrinsics.checkNotNullParameter(_connection, "_connection");
        return jobsDao_Impl.__insertAdapterOfJobIdToWorkIdRelation.insertAndReturnId(_connection, jobIdToWorkIdRelation);
    }

    @Override // com.box.android.data.persistence.jobs.JobsDao
    public Object addTagToJob(final JobToTagRelation jobToTagRelation, Continuation<? super Long> continuation) {
        return DBUtil.performSuspending(this.__db, false, true, new Function1() { // from class: com.box.android.data.persistence.jobs.JobsDao_Impl$$ExternalSyntheticLambda25
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return Long.valueOf(JobsDao_Impl.addTagToJob$lambda$0(this.f$0, jobToTagRelation, (SQLiteConnection) obj));
            }
        }, continuation);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final long addTagToJob$lambda$0(JobsDao_Impl jobsDao_Impl, JobToTagRelation jobToTagRelation, SQLiteConnection _connection) {
        Intrinsics.checkNotNullParameter(_connection, "_connection");
        return jobsDao_Impl.__insertAdapterOfJobToTagRelation.insertAndReturnId(_connection, jobToTagRelation);
    }

    @Override // com.box.android.data.persistence.jobs.JobsDao
    public Object updateJob(final JobEntity jobEntity, Continuation<? super Unit> continuation) {
        Object objPerformSuspending = DBUtil.performSuspending(this.__db, false, true, new Function1() { // from class: com.box.android.data.persistence.jobs.JobsDao_Impl$$ExternalSyntheticLambda15
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return JobsDao_Impl.updateJob$lambda$0(this.f$0, jobEntity, (SQLiteConnection) obj);
            }
        }, continuation);
        return objPerformSuspending == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objPerformSuspending : Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit updateJob$lambda$0(JobsDao_Impl jobsDao_Impl, JobEntity jobEntity, SQLiteConnection _connection) throws Exception {
        Intrinsics.checkNotNullParameter(_connection, "_connection");
        jobsDao_Impl.__updateAdapterOfJobEntity.handle(_connection, jobEntity);
        return Unit.INSTANCE;
    }

    /* JADX INFO: renamed from: com.box.android.data.persistence.jobs.JobsDao_Impl$increaseManualRetryInformation$2, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: JobsDao_Impl.kt */
    @Metadata(d1 = {"\u0000\u0006\n\u0000\n\u0002\u0010\u0002\u0010\u0000\u001a\u00020\u0001H\n"}, d2 = {"<anonymous>", ""}, k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.box.android.data.persistence.jobs.JobsDao_Impl$increaseManualRetryInformation$2", f = "JobsDao_Impl.kt", i = {}, l = {416}, m = "invokeSuspend", n = {}, s = {}, v = 1)
    static final class C13752 extends SuspendLambda implements Function1<Continuation<? super Unit>, Object> {
        final /* synthetic */ JobId $jobId;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C13752(JobId jobId, Continuation<? super C13752> continuation) {
            super(1, continuation);
            this.$jobId = jobId;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Continuation<?> continuation) {
            return JobsDao_Impl.this.new C13752(this.$jobId, continuation);
        }

        @Override // kotlin.jvm.functions.Function1
        public final Object invoke(Continuation<? super Unit> continuation) {
            return ((C13752) create(continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                this.label = 1;
                if (JobsDao_Impl.super.increaseManualRetryInformation(this.$jobId, this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
            return Unit.INSTANCE;
        }
    }

    @Override // com.box.android.data.persistence.jobs.JobsDao
    public Object increaseManualRetryInformation(JobId jobId, Continuation<? super Unit> continuation) {
        Object objPerformInTransactionSuspending = DBUtil.performInTransactionSuspending(this.__db, new C13752(jobId, null), continuation);
        return objPerformInTransactionSuspending == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objPerformInTransactionSuspending : Unit.INSTANCE;
    }

    /* JADX INFO: renamed from: com.box.android.data.persistence.jobs.JobsDao_Impl$increaseAutoRetryInformation$2, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: JobsDao_Impl.kt */
    @Metadata(d1 = {"\u0000\u0006\n\u0000\n\u0002\u0010\u0002\u0010\u0000\u001a\u00020\u0001H\n"}, d2 = {"<anonymous>", ""}, k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.box.android.data.persistence.jobs.JobsDao_Impl$increaseAutoRetryInformation$2", f = "JobsDao_Impl.kt", i = {}, l = {420}, m = "invokeSuspend", n = {}, s = {}, v = 1)
    static final class C13742 extends SuspendLambda implements Function1<Continuation<? super Unit>, Object> {
        final /* synthetic */ JobId $jobId;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C13742(JobId jobId, Continuation<? super C13742> continuation) {
            super(1, continuation);
            this.$jobId = jobId;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Continuation<?> continuation) {
            return JobsDao_Impl.this.new C13742(this.$jobId, continuation);
        }

        @Override // kotlin.jvm.functions.Function1
        public final Object invoke(Continuation<? super Unit> continuation) {
            return ((C13742) create(continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                this.label = 1;
                if (JobsDao_Impl.super.increaseAutoRetryInformation(this.$jobId, this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
            return Unit.INSTANCE;
        }
    }

    @Override // com.box.android.data.persistence.jobs.JobsDao
    public Object increaseAutoRetryInformation(JobId jobId, Continuation<? super Unit> continuation) {
        Object objPerformInTransactionSuspending = DBUtil.performInTransactionSuspending(this.__db, new C13742(jobId, null), continuation);
        return objPerformInTransactionSuspending == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objPerformInTransactionSuspending : Unit.INSTANCE;
    }

    @Override // com.box.android.data.persistence.jobs.JobsDao
    public Object insertOrUpdateJob(final JobEntity jobEntity, Continuation<? super Unit> continuation) {
        Object objPerformSuspending = DBUtil.performSuspending(this.__db, false, true, new Function1() { // from class: com.box.android.data.persistence.jobs.JobsDao_Impl$$ExternalSyntheticLambda24
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return JobsDao_Impl.insertOrUpdateJob$lambda$0(this.f$0, jobEntity, (SQLiteConnection) obj);
            }
        }, continuation);
        return objPerformSuspending == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objPerformSuspending : Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit insertOrUpdateJob$lambda$0(JobsDao_Impl jobsDao_Impl, JobEntity jobEntity, SQLiteConnection _connection) throws Exception {
        Intrinsics.checkNotNullParameter(_connection, "_connection");
        jobsDao_Impl.__upsertAdapterOfJobEntity.upsert(_connection, jobEntity);
        return Unit.INSTANCE;
    }

    @Override // com.box.android.data.persistence.jobs.JobsDao
    public Object getJob(final JobId jobId, Continuation<? super JobEntity> continuation) {
        final String str = "SELECT * FROM job where id = ?";
        return DBUtil.performSuspending(this.__db, true, false, new Function1() { // from class: com.box.android.data.persistence.jobs.JobsDao_Impl$$ExternalSyntheticLambda11
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return JobsDao_Impl.getJob$lambda$0(str, this, jobId, (SQLiteConnection) obj);
            }
        }, continuation);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    public static final JobEntity getJob$lambda$0(String str, JobsDao_Impl jobsDao_Impl, JobId jobId, SQLiteConnection _connection) {
        Intrinsics.checkNotNullParameter(_connection, "_connection");
        SQLiteStatement sQLiteStatementPrepare = _connection.prepare(str);
        try {
            String string = jobsDao_Impl.__jobIdConverter.toString(jobId);
            if (string == null) {
                sQLiteStatementPrepare.mo10943bindNull(1);
            } else {
                sQLiteStatementPrepare.mo10944bindText(1, string);
            }
            int columnIndexOrThrow = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "id");
            int columnIndexOrThrow2 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "job_type");
            int columnIndexOrThrow3 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "input_data");
            int columnIndexOrThrow4 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "status");
            int columnIndexOrThrow5 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "created_at");
            int columnIndexOrThrow6 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, FirebaseAnalytics.Param.START_DATE);
            int columnIndexOrThrow7 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "earliest_start_date");
            int columnIndexOrThrow8 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "auto_retry_count");
            int columnIndexOrThrow9 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "manual_retry_count");
            int columnIndexOrThrow10 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "running_info");
            int columnIndexOrThrow11 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "error_info");
            int columnIndexOrThrow12 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "parentID");
            int columnIndexOrThrow13 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "rootID");
            int columnIndexOrThrow14 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "sortKey");
            int columnIndexOrThrow15 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "log_data");
            JobEntity jobEntity = null;
            if (sQLiteStatementPrepare.step()) {
                JobId jobIdFromString = jobsDao_Impl.__jobIdConverter.fromString(sQLiteStatementPrepare.isNull(columnIndexOrThrow) ? null : sQLiteStatementPrepare.getText(columnIndexOrThrow));
                if (jobIdFromString == null) {
                    throw new IllegalStateException("Expected NON-NULL 'com.box.android.domain.jobs.JobId', but it was NULL.".toString());
                }
                String text = sQLiteStatementPrepare.getText(columnIndexOrThrow2);
                byte[] blob = sQLiteStatementPrepare.getBlob(columnIndexOrThrow3);
                JobStatus jobStatusFromString = jobsDao_Impl.__jobStatusConverter.fromString(sQLiteStatementPrepare.isNull(columnIndexOrThrow4) ? null : sQLiteStatementPrepare.getText(columnIndexOrThrow4));
                if (jobStatusFromString == null) {
                    throw new IllegalStateException("Expected NON-NULL 'com.box.android.`data`.persistence.jobs.JobStatus', but it was NULL.".toString());
                }
                Date dateFromTimestamp = jobsDao_Impl.__dateToLongConverter.fromTimestamp(sQLiteStatementPrepare.isNull(columnIndexOrThrow5) ? null : Long.valueOf(sQLiteStatementPrepare.getLong(columnIndexOrThrow5)));
                if (dateFromTimestamp == null) {
                    throw new IllegalStateException("Expected NON-NULL 'java.util.Date', but it was NULL.".toString());
                }
                Date dateFromTimestamp2 = jobsDao_Impl.__dateToLongConverter.fromTimestamp(sQLiteStatementPrepare.isNull(columnIndexOrThrow6) ? null : Long.valueOf(sQLiteStatementPrepare.getLong(columnIndexOrThrow6)));
                Date dateFromTimestamp3 = jobsDao_Impl.__dateToLongConverter.fromTimestamp(sQLiteStatementPrepare.isNull(columnIndexOrThrow7) ? null : Long.valueOf(sQLiteStatementPrepare.getLong(columnIndexOrThrow7)));
                if (dateFromTimestamp3 == null) {
                    throw new IllegalStateException("Expected NON-NULL 'java.util.Date', but it was NULL.".toString());
                }
                int i = (int) sQLiteStatementPrepare.getLong(columnIndexOrThrow8);
                int i2 = (int) sQLiteStatementPrepare.getLong(columnIndexOrThrow9);
                byte[] blob2 = sQLiteStatementPrepare.isNull(columnIndexOrThrow10) ? null : sQLiteStatementPrepare.getBlob(columnIndexOrThrow10);
                DomainError domainErrorFromString = jobsDao_Impl.__domainErrorConverter.fromString(sQLiteStatementPrepare.isNull(columnIndexOrThrow11) ? null : sQLiteStatementPrepare.getText(columnIndexOrThrow11));
                JobId jobIdFromString2 = jobsDao_Impl.__jobIdConverter.fromString(sQLiteStatementPrepare.isNull(columnIndexOrThrow12) ? null : sQLiteStatementPrepare.getText(columnIndexOrThrow12));
                JobId jobIdFromString3 = jobsDao_Impl.__jobIdConverter.fromString(sQLiteStatementPrepare.isNull(columnIndexOrThrow13) ? null : sQLiteStatementPrepare.getText(columnIndexOrThrow13));
                if (jobIdFromString3 == null) {
                    throw new IllegalStateException("Expected NON-NULL 'com.box.android.domain.jobs.JobId', but it was NULL.".toString());
                }
                jobEntity = new JobEntity(jobIdFromString, text, blob, jobStatusFromString, dateFromTimestamp, dateFromTimestamp2, dateFromTimestamp3, i, i2, blob2, domainErrorFromString, jobIdFromString2, jobIdFromString3, sQLiteStatementPrepare.getText(columnIndexOrThrow14), sQLiteStatementPrepare.getBlob(columnIndexOrThrow15));
            }
            sQLiteStatementPrepare.close();
            return jobEntity;
        } catch (Throwable th) {
            sQLiteStatementPrepare.close();
            throw th;
        }
    }

    @Override // com.box.android.data.persistence.jobs.JobsDao
    public Object getNextJobToRun(final Date date, Continuation<? super JobEntity> continuation) {
        final String str = "SELECT job.* FROM job WHERE NOT EXISTS (SELECT * FROM job_dependency WHERE job.id = job_dependency.successor) AND job.status = 'enqueued' AND ? >= job.earliest_start_date order by created_at ASC limit 1";
        return DBUtil.performSuspending(this.__db, true, true, new Function1() { // from class: com.box.android.data.persistence.jobs.JobsDao_Impl$$ExternalSyntheticLambda22
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return JobsDao_Impl.getNextJobToRun$lambda$0(str, this, date, (SQLiteConnection) obj);
            }
        }, continuation);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    public static final JobEntity getNextJobToRun$lambda$0(String str, JobsDao_Impl jobsDao_Impl, Date date, SQLiteConnection _connection) {
        Intrinsics.checkNotNullParameter(_connection, "_connection");
        SQLiteStatement sQLiteStatementPrepare = _connection.prepare(str);
        try {
            Long lDateToTimestamp = jobsDao_Impl.__dateToLongConverter.dateToTimestamp(date);
            if (lDateToTimestamp == null) {
                sQLiteStatementPrepare.mo10943bindNull(1);
            } else {
                sQLiteStatementPrepare.mo10942bindLong(1, lDateToTimestamp.longValue());
            }
            int columnIndexOrThrow = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "id");
            int columnIndexOrThrow2 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "job_type");
            int columnIndexOrThrow3 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "input_data");
            int columnIndexOrThrow4 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "status");
            int columnIndexOrThrow5 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "created_at");
            int columnIndexOrThrow6 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, FirebaseAnalytics.Param.START_DATE);
            int columnIndexOrThrow7 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "earliest_start_date");
            int columnIndexOrThrow8 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "auto_retry_count");
            int columnIndexOrThrow9 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "manual_retry_count");
            int columnIndexOrThrow10 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "running_info");
            int columnIndexOrThrow11 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "error_info");
            int columnIndexOrThrow12 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "parentID");
            int columnIndexOrThrow13 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "rootID");
            int columnIndexOrThrow14 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "sortKey");
            int columnIndexOrThrow15 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "log_data");
            JobEntity jobEntity = null;
            if (sQLiteStatementPrepare.step()) {
                JobId jobIdFromString = jobsDao_Impl.__jobIdConverter.fromString(sQLiteStatementPrepare.isNull(columnIndexOrThrow) ? null : sQLiteStatementPrepare.getText(columnIndexOrThrow));
                if (jobIdFromString == null) {
                    throw new IllegalStateException("Expected NON-NULL 'com.box.android.domain.jobs.JobId', but it was NULL.".toString());
                }
                String text = sQLiteStatementPrepare.getText(columnIndexOrThrow2);
                byte[] blob = sQLiteStatementPrepare.getBlob(columnIndexOrThrow3);
                JobStatus jobStatusFromString = jobsDao_Impl.__jobStatusConverter.fromString(sQLiteStatementPrepare.isNull(columnIndexOrThrow4) ? null : sQLiteStatementPrepare.getText(columnIndexOrThrow4));
                if (jobStatusFromString == null) {
                    throw new IllegalStateException("Expected NON-NULL 'com.box.android.`data`.persistence.jobs.JobStatus', but it was NULL.".toString());
                }
                Date dateFromTimestamp = jobsDao_Impl.__dateToLongConverter.fromTimestamp(sQLiteStatementPrepare.isNull(columnIndexOrThrow5) ? null : Long.valueOf(sQLiteStatementPrepare.getLong(columnIndexOrThrow5)));
                if (dateFromTimestamp == null) {
                    throw new IllegalStateException("Expected NON-NULL 'java.util.Date', but it was NULL.".toString());
                }
                Date dateFromTimestamp2 = jobsDao_Impl.__dateToLongConverter.fromTimestamp(sQLiteStatementPrepare.isNull(columnIndexOrThrow6) ? null : Long.valueOf(sQLiteStatementPrepare.getLong(columnIndexOrThrow6)));
                Date dateFromTimestamp3 = jobsDao_Impl.__dateToLongConverter.fromTimestamp(sQLiteStatementPrepare.isNull(columnIndexOrThrow7) ? null : Long.valueOf(sQLiteStatementPrepare.getLong(columnIndexOrThrow7)));
                if (dateFromTimestamp3 == null) {
                    throw new IllegalStateException("Expected NON-NULL 'java.util.Date', but it was NULL.".toString());
                }
                int i = (int) sQLiteStatementPrepare.getLong(columnIndexOrThrow8);
                int i2 = (int) sQLiteStatementPrepare.getLong(columnIndexOrThrow9);
                byte[] blob2 = sQLiteStatementPrepare.isNull(columnIndexOrThrow10) ? null : sQLiteStatementPrepare.getBlob(columnIndexOrThrow10);
                DomainError domainErrorFromString = jobsDao_Impl.__domainErrorConverter.fromString(sQLiteStatementPrepare.isNull(columnIndexOrThrow11) ? null : sQLiteStatementPrepare.getText(columnIndexOrThrow11));
                JobId jobIdFromString2 = jobsDao_Impl.__jobIdConverter.fromString(sQLiteStatementPrepare.isNull(columnIndexOrThrow12) ? null : sQLiteStatementPrepare.getText(columnIndexOrThrow12));
                JobId jobIdFromString3 = jobsDao_Impl.__jobIdConverter.fromString(sQLiteStatementPrepare.isNull(columnIndexOrThrow13) ? null : sQLiteStatementPrepare.getText(columnIndexOrThrow13));
                if (jobIdFromString3 == null) {
                    throw new IllegalStateException("Expected NON-NULL 'com.box.android.domain.jobs.JobId', but it was NULL.".toString());
                }
                jobEntity = new JobEntity(jobIdFromString, text, blob, jobStatusFromString, dateFromTimestamp, dateFromTimestamp2, dateFromTimestamp3, i, i2, blob2, domainErrorFromString, jobIdFromString2, jobIdFromString3, sQLiteStatementPrepare.getText(columnIndexOrThrow14), sQLiteStatementPrepare.getBlob(columnIndexOrThrow15));
            }
            sQLiteStatementPrepare.close();
            return jobEntity;
        } catch (Throwable th) {
            sQLiteStatementPrepare.close();
            throw th;
        }
    }

    @Override // com.box.android.data.persistence.jobs.JobsDao
    public Object getEarliestStartDateOfNextJob(Continuation<? super Date> continuation) {
        final String str = "SELECT MIN(earliest_start_date) FROM job WHERE NOT EXISTS (SELECT * FROM job_dependency WHERE job.id = job_dependency.successor) AND job.status = 'enqueued'";
        return DBUtil.performSuspending(this.__db, true, false, new Function1() { // from class: com.box.android.data.persistence.jobs.JobsDao_Impl$$ExternalSyntheticLambda2
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return JobsDao_Impl.getEarliestStartDateOfNextJob$lambda$0(str, this, (SQLiteConnection) obj);
            }
        }, continuation);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    public static final Date getEarliestStartDateOfNextJob$lambda$0(String str, JobsDao_Impl jobsDao_Impl, SQLiteConnection _connection) {
        Intrinsics.checkNotNullParameter(_connection, "_connection");
        SQLiteStatement sQLiteStatementPrepare = _connection.prepare(str);
        try {
            Date dateFromTimestamp = null;
            Long lValueOf = null;
            if (sQLiteStatementPrepare.step()) {
                if (!sQLiteStatementPrepare.isNull(0)) {
                    lValueOf = Long.valueOf(sQLiteStatementPrepare.getLong(0));
                }
                dateFromTimestamp = jobsDao_Impl.__dateToLongConverter.fromTimestamp(lValueOf);
            }
            return dateFromTimestamp;
        } finally {
            sQLiteStatementPrepare.close();
        }
    }

    @Override // com.box.android.data.persistence.jobs.JobsDao
    public Object numberOfExecutingJobs(Continuation<? super Integer> continuation) {
        final String str = "SELECT COUNT(*) FROM job where status = 'running' OR status = 'pending'";
        return DBUtil.performSuspending(this.__db, true, false, new Function1() { // from class: com.box.android.data.persistence.jobs.JobsDao_Impl$$ExternalSyntheticLambda17
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return Integer.valueOf(JobsDao_Impl.numberOfExecutingJobs$lambda$0(str, (SQLiteConnection) obj));
            }
        }, continuation);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final int numberOfExecutingJobs$lambda$0(String str, SQLiteConnection _connection) {
        Intrinsics.checkNotNullParameter(_connection, "_connection");
        SQLiteStatement sQLiteStatementPrepare = _connection.prepare(str);
        try {
            return sQLiteStatementPrepare.step() ? (int) sQLiteStatementPrepare.getLong(0) : 0;
        } finally {
            sQLiteStatementPrepare.close();
        }
    }

    @Override // com.box.android.data.persistence.jobs.JobsDao
    public Object rootIDsWithRunningJobsCount(Continuation<? super List<RootIdWithRunningJobsCount>> continuation) {
        final String str = "SELECT COUNT(id) AS count, rootID FROM job WHERE status = 'running' GROUP BY rootID";
        return DBUtil.performSuspending(this.__db, true, false, new Function1() { // from class: com.box.android.data.persistence.jobs.JobsDao_Impl$$ExternalSyntheticLambda9
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return JobsDao_Impl.rootIDsWithRunningJobsCount$lambda$0(str, this, (SQLiteConnection) obj);
            }
        }, continuation);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final List rootIDsWithRunningJobsCount$lambda$0(String str, JobsDao_Impl jobsDao_Impl, SQLiteConnection _connection) {
        Intrinsics.checkNotNullParameter(_connection, "_connection");
        SQLiteStatement sQLiteStatementPrepare = _connection.prepare(str);
        try {
            ArrayList arrayList = new ArrayList();
            while (sQLiteStatementPrepare.step()) {
                int i = (int) sQLiteStatementPrepare.getLong(0);
                JobId jobIdFromString = jobsDao_Impl.__jobIdConverter.fromString(sQLiteStatementPrepare.isNull(1) ? null : sQLiteStatementPrepare.getText(1));
                if (jobIdFromString == null) {
                    throw new IllegalStateException("Expected NON-NULL 'com.box.android.domain.jobs.JobId', but it was NULL.".toString());
                }
                arrayList.add(new RootIdWithRunningJobsCount(i, jobIdFromString));
            }
            sQLiteStatementPrepare.close();
            return arrayList;
        } catch (Throwable th) {
            sQLiteStatementPrepare.close();
            throw th;
        }
    }

    @Override // com.box.android.data.persistence.jobs.JobsDao
    public Object waitingRootIDs(Continuation<? super List<JobId>> continuation) {
        final String str = "SELECT id FROM job WHERE parentID IS NULL AND status = 'waiting_for_children' ORDER BY sortKey";
        return DBUtil.performSuspending(this.__db, true, false, new Function1() { // from class: com.box.android.data.persistence.jobs.JobsDao_Impl$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return JobsDao_Impl.waitingRootIDs$lambda$0(str, this, (SQLiteConnection) obj);
            }
        }, continuation);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final List waitingRootIDs$lambda$0(String str, JobsDao_Impl jobsDao_Impl, SQLiteConnection _connection) {
        Intrinsics.checkNotNullParameter(_connection, "_connection");
        SQLiteStatement sQLiteStatementPrepare = _connection.prepare(str);
        try {
            ArrayList arrayList = new ArrayList();
            while (sQLiteStatementPrepare.step()) {
                JobId jobIdFromString = jobsDao_Impl.__jobIdConverter.fromString(sQLiteStatementPrepare.isNull(0) ? null : sQLiteStatementPrepare.getText(0));
                if (jobIdFromString == null) {
                    throw new IllegalStateException("Expected NON-NULL 'com.box.android.domain.jobs.JobId', but it was NULL.".toString());
                }
                arrayList.add(jobIdFromString);
            }
            sQLiteStatementPrepare.close();
            return arrayList;
        } catch (Throwable th) {
            sQLiteStatementPrepare.close();
            throw th;
        }
    }

    @Override // com.box.android.data.persistence.jobs.JobsDao
    public Object enqueuedJobsWithTheseRootIDs(final List<JobId> list, Continuation<? super List<JobEntity>> continuation) {
        StringBuilder sb = new StringBuilder();
        sb.append("SELECT * FROM job WHERE rootID IN (");
        StringUtil.appendPlaceholders(sb, list.size());
        sb.append(") AND status = 'enqueued' ORDER BY sortKey");
        final String string = sb.toString();
        Intrinsics.checkNotNullExpressionValue(string, "toString(...)");
        return DBUtil.performSuspending(this.__db, true, false, new Function1() { // from class: com.box.android.data.persistence.jobs.JobsDao_Impl$$ExternalSyntheticLambda30
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return JobsDao_Impl.enqueuedJobsWithTheseRootIDs$lambda$0(string, list, this, (SQLiteConnection) obj);
            }
        }, continuation);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final List enqueuedJobsWithTheseRootIDs$lambda$0(String str, List list, JobsDao_Impl jobsDao_Impl, SQLiteConnection _connection) throws Throwable {
        SQLiteStatement sQLiteStatement;
        JobsDao_Impl jobsDao_Impl2 = jobsDao_Impl;
        Intrinsics.checkNotNullParameter(_connection, "_connection");
        SQLiteStatement sQLiteStatementPrepare = _connection.prepare(str);
        try {
            Iterator it = list.iterator();
            int i = 1;
            while (it.hasNext()) {
                String string = jobsDao_Impl2.__jobIdConverter.toString((JobId) it.next());
                if (string == null) {
                    sQLiteStatementPrepare.mo10943bindNull(i);
                } else {
                    sQLiteStatementPrepare.mo10944bindText(i, string);
                }
                i++;
            }
            int columnIndexOrThrow = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "id");
            int columnIndexOrThrow2 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "job_type");
            int columnIndexOrThrow3 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "input_data");
            int columnIndexOrThrow4 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "status");
            int columnIndexOrThrow5 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "created_at");
            int columnIndexOrThrow6 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, FirebaseAnalytics.Param.START_DATE);
            int columnIndexOrThrow7 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "earliest_start_date");
            int columnIndexOrThrow8 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "auto_retry_count");
            int columnIndexOrThrow9 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "manual_retry_count");
            int columnIndexOrThrow10 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "running_info");
            int columnIndexOrThrow11 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "error_info");
            int columnIndexOrThrow12 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "parentID");
            int columnIndexOrThrow13 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "rootID");
            int columnIndexOrThrow14 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "sortKey");
            int columnIndexOrThrow15 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "log_data");
            ArrayList arrayList = new ArrayList();
            while (sQLiteStatementPrepare.step()) {
                ArrayList arrayList2 = arrayList;
                JobId jobIdFromString = jobsDao_Impl2.__jobIdConverter.fromString(sQLiteStatementPrepare.isNull(columnIndexOrThrow) ? null : sQLiteStatementPrepare.getText(columnIndexOrThrow));
                if (jobIdFromString == null) {
                    throw new IllegalStateException("Expected NON-NULL 'com.box.android.domain.jobs.JobId', but it was NULL.".toString());
                }
                String text = sQLiteStatementPrepare.getText(columnIndexOrThrow2);
                byte[] blob = sQLiteStatementPrepare.getBlob(columnIndexOrThrow3);
                JobStatus jobStatusFromString = jobsDao_Impl2.__jobStatusConverter.fromString(sQLiteStatementPrepare.isNull(columnIndexOrThrow4) ? null : sQLiteStatementPrepare.getText(columnIndexOrThrow4));
                if (jobStatusFromString == null) {
                    throw new IllegalStateException("Expected NON-NULL 'com.box.android.`data`.persistence.jobs.JobStatus', but it was NULL.".toString());
                }
                Date dateFromTimestamp = jobsDao_Impl2.__dateToLongConverter.fromTimestamp(sQLiteStatementPrepare.isNull(columnIndexOrThrow5) ? null : Long.valueOf(sQLiteStatementPrepare.getLong(columnIndexOrThrow5)));
                if (dateFromTimestamp == null) {
                    throw new IllegalStateException("Expected NON-NULL 'java.util.Date', but it was NULL.".toString());
                }
                Date dateFromTimestamp2 = jobsDao_Impl2.__dateToLongConverter.fromTimestamp(sQLiteStatementPrepare.isNull(columnIndexOrThrow6) ? null : Long.valueOf(sQLiteStatementPrepare.getLong(columnIndexOrThrow6)));
                Date dateFromTimestamp3 = jobsDao_Impl2.__dateToLongConverter.fromTimestamp(sQLiteStatementPrepare.isNull(columnIndexOrThrow7) ? null : Long.valueOf(sQLiteStatementPrepare.getLong(columnIndexOrThrow7)));
                if (dateFromTimestamp3 == null) {
                    throw new IllegalStateException("Expected NON-NULL 'java.util.Date', but it was NULL.".toString());
                }
                int i2 = columnIndexOrThrow2;
                int i3 = (int) sQLiteStatementPrepare.getLong(columnIndexOrThrow8);
                int i4 = (int) sQLiteStatementPrepare.getLong(columnIndexOrThrow9);
                byte[] blob2 = sQLiteStatementPrepare.isNull(columnIndexOrThrow10) ? null : sQLiteStatementPrepare.getBlob(columnIndexOrThrow10);
                DomainError domainErrorFromString = jobsDao_Impl2.__domainErrorConverter.fromString(sQLiteStatementPrepare.isNull(columnIndexOrThrow11) ? null : sQLiteStatementPrepare.getText(columnIndexOrThrow11));
                JobId jobIdFromString2 = jobsDao_Impl2.__jobIdConverter.fromString(sQLiteStatementPrepare.isNull(columnIndexOrThrow12) ? null : sQLiteStatementPrepare.getText(columnIndexOrThrow12));
                JobId jobIdFromString3 = jobsDao_Impl2.__jobIdConverter.fromString(sQLiteStatementPrepare.isNull(columnIndexOrThrow13) ? null : sQLiteStatementPrepare.getText(columnIndexOrThrow13));
                if (jobIdFromString3 == null) {
                    throw new IllegalStateException("Expected NON-NULL 'com.box.android.domain.jobs.JobId', but it was NULL.".toString());
                }
                int i5 = columnIndexOrThrow14;
                int i6 = columnIndexOrThrow15;
                sQLiteStatement = sQLiteStatementPrepare;
                try {
                    arrayList2.add(new JobEntity(jobIdFromString, text, blob, jobStatusFromString, dateFromTimestamp, dateFromTimestamp2, dateFromTimestamp3, i3, i4, blob2, domainErrorFromString, jobIdFromString2, jobIdFromString3, sQLiteStatementPrepare.getText(i5), sQLiteStatementPrepare.getBlob(i6)));
                    jobsDao_Impl2 = jobsDao_Impl;
                    columnIndexOrThrow15 = i6;
                    columnIndexOrThrow2 = i2;
                    arrayList = arrayList2;
                    sQLiteStatementPrepare = sQLiteStatement;
                    columnIndexOrThrow14 = i5;
                    columnIndexOrThrow = columnIndexOrThrow;
                } catch (Throwable th) {
                    th = th;
                    sQLiteStatement.close();
                    throw th;
                }
            }
            SQLiteStatement sQLiteStatement2 = sQLiteStatementPrepare;
            ArrayList arrayList3 = arrayList;
            sQLiteStatement2.close();
            return arrayList3;
        } catch (Throwable th2) {
            th = th2;
            sQLiteStatement = sQLiteStatementPrepare;
        }
    }

    @Override // com.box.android.data.persistence.jobs.JobsDao
    public Object enqueuedJobs(Continuation<? super List<JobEntity>> continuation) {
        final String str = "SELECT * FROM job WHERE status = 'enqueued' ORDER BY sortKey";
        return DBUtil.performSuspending(this.__db, true, false, new Function1() { // from class: com.box.android.data.persistence.jobs.JobsDao_Impl$$ExternalSyntheticLambda20
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return JobsDao_Impl.enqueuedJobs$lambda$0(str, this, (SQLiteConnection) obj);
            }
        }, continuation);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final List enqueuedJobs$lambda$0(String str, JobsDao_Impl jobsDao_Impl, SQLiteConnection _connection) throws Throwable {
        SQLiteStatement sQLiteStatement;
        Intrinsics.checkNotNullParameter(_connection, "_connection");
        SQLiteStatement sQLiteStatementPrepare = _connection.prepare(str);
        try {
            int columnIndexOrThrow = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "id");
            int columnIndexOrThrow2 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "job_type");
            int columnIndexOrThrow3 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "input_data");
            int columnIndexOrThrow4 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "status");
            int columnIndexOrThrow5 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "created_at");
            int columnIndexOrThrow6 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, FirebaseAnalytics.Param.START_DATE);
            int columnIndexOrThrow7 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "earliest_start_date");
            int columnIndexOrThrow8 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "auto_retry_count");
            int columnIndexOrThrow9 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "manual_retry_count");
            int columnIndexOrThrow10 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "running_info");
            int columnIndexOrThrow11 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "error_info");
            int columnIndexOrThrow12 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "parentID");
            int columnIndexOrThrow13 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "rootID");
            int columnIndexOrThrow14 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "sortKey");
            int columnIndexOrThrow15 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "log_data");
            ArrayList arrayList = new ArrayList();
            while (sQLiteStatementPrepare.step()) {
                ArrayList arrayList2 = arrayList;
                JobId jobIdFromString = jobsDao_Impl.__jobIdConverter.fromString(sQLiteStatementPrepare.isNull(columnIndexOrThrow) ? null : sQLiteStatementPrepare.getText(columnIndexOrThrow));
                if (jobIdFromString == null) {
                    throw new IllegalStateException("Expected NON-NULL 'com.box.android.domain.jobs.JobId', but it was NULL.".toString());
                }
                String text = sQLiteStatementPrepare.getText(columnIndexOrThrow2);
                byte[] blob = sQLiteStatementPrepare.getBlob(columnIndexOrThrow3);
                JobStatus jobStatusFromString = jobsDao_Impl.__jobStatusConverter.fromString(sQLiteStatementPrepare.isNull(columnIndexOrThrow4) ? null : sQLiteStatementPrepare.getText(columnIndexOrThrow4));
                if (jobStatusFromString == null) {
                    throw new IllegalStateException("Expected NON-NULL 'com.box.android.`data`.persistence.jobs.JobStatus', but it was NULL.".toString());
                }
                Date dateFromTimestamp = jobsDao_Impl.__dateToLongConverter.fromTimestamp(sQLiteStatementPrepare.isNull(columnIndexOrThrow5) ? null : Long.valueOf(sQLiteStatementPrepare.getLong(columnIndexOrThrow5)));
                if (dateFromTimestamp == null) {
                    throw new IllegalStateException("Expected NON-NULL 'java.util.Date', but it was NULL.".toString());
                }
                Date dateFromTimestamp2 = jobsDao_Impl.__dateToLongConverter.fromTimestamp(sQLiteStatementPrepare.isNull(columnIndexOrThrow6) ? null : Long.valueOf(sQLiteStatementPrepare.getLong(columnIndexOrThrow6)));
                Date dateFromTimestamp3 = jobsDao_Impl.__dateToLongConverter.fromTimestamp(sQLiteStatementPrepare.isNull(columnIndexOrThrow7) ? null : Long.valueOf(sQLiteStatementPrepare.getLong(columnIndexOrThrow7)));
                if (dateFromTimestamp3 == null) {
                    throw new IllegalStateException("Expected NON-NULL 'java.util.Date', but it was NULL.".toString());
                }
                int i = columnIndexOrThrow2;
                int i2 = (int) sQLiteStatementPrepare.getLong(columnIndexOrThrow8);
                int i3 = (int) sQLiteStatementPrepare.getLong(columnIndexOrThrow9);
                byte[] blob2 = sQLiteStatementPrepare.isNull(columnIndexOrThrow10) ? null : sQLiteStatementPrepare.getBlob(columnIndexOrThrow10);
                DomainError domainErrorFromString = jobsDao_Impl.__domainErrorConverter.fromString(sQLiteStatementPrepare.isNull(columnIndexOrThrow11) ? null : sQLiteStatementPrepare.getText(columnIndexOrThrow11));
                JobId jobIdFromString2 = jobsDao_Impl.__jobIdConverter.fromString(sQLiteStatementPrepare.isNull(columnIndexOrThrow12) ? null : sQLiteStatementPrepare.getText(columnIndexOrThrow12));
                JobId jobIdFromString3 = jobsDao_Impl.__jobIdConverter.fromString(sQLiteStatementPrepare.isNull(columnIndexOrThrow13) ? null : sQLiteStatementPrepare.getText(columnIndexOrThrow13));
                if (jobIdFromString3 == null) {
                    throw new IllegalStateException("Expected NON-NULL 'com.box.android.domain.jobs.JobId', but it was NULL.".toString());
                }
                int i4 = columnIndexOrThrow14;
                int i5 = columnIndexOrThrow15;
                sQLiteStatement = sQLiteStatementPrepare;
                try {
                    arrayList2.add(new JobEntity(jobIdFromString, text, blob, jobStatusFromString, dateFromTimestamp, dateFromTimestamp2, dateFromTimestamp3, i2, i3, blob2, domainErrorFromString, jobIdFromString2, jobIdFromString3, sQLiteStatementPrepare.getText(i4), sQLiteStatementPrepare.getBlob(i5)));
                    columnIndexOrThrow15 = i5;
                    columnIndexOrThrow2 = i;
                    arrayList = arrayList2;
                    sQLiteStatementPrepare = sQLiteStatement;
                    columnIndexOrThrow14 = i4;
                    columnIndexOrThrow = columnIndexOrThrow;
                } catch (Throwable th) {
                    th = th;
                    sQLiteStatement.close();
                    throw th;
                }
            }
            SQLiteStatement sQLiteStatement2 = sQLiteStatementPrepare;
            ArrayList arrayList3 = arrayList;
            sQLiteStatement2.close();
            return arrayList3;
        } catch (Throwable th2) {
            th = th2;
            sQLiteStatement = sQLiteStatementPrepare;
        }
    }

    @Override // com.box.android.data.persistence.jobs.JobsDao
    public Object getAutoRetryCount(final JobId jobId, Continuation<? super Integer> continuation) {
        final String str = "SELECT auto_retry_count FROM job where id= ?";
        return DBUtil.performSuspending(this.__db, true, false, new Function1() { // from class: com.box.android.data.persistence.jobs.JobsDao_Impl$$ExternalSyntheticLambda13
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return Integer.valueOf(JobsDao_Impl.getAutoRetryCount$lambda$0(str, this, jobId, (SQLiteConnection) obj));
            }
        }, continuation);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final int getAutoRetryCount$lambda$0(String str, JobsDao_Impl jobsDao_Impl, JobId jobId, SQLiteConnection _connection) {
        Intrinsics.checkNotNullParameter(_connection, "_connection");
        SQLiteStatement sQLiteStatementPrepare = _connection.prepare(str);
        try {
            String string = jobsDao_Impl.__jobIdConverter.toString(jobId);
            if (string == null) {
                sQLiteStatementPrepare.mo10943bindNull(1);
            } else {
                sQLiteStatementPrepare.mo10944bindText(1, string);
            }
            return sQLiteStatementPrepare.step() ? (int) sQLiteStatementPrepare.getLong(0) : 0;
        } finally {
            sQLiteStatementPrepare.close();
        }
    }

    @Override // com.box.android.data.persistence.jobs.JobsDao
    public Object getManualRetryCount(final JobId jobId, Continuation<? super Integer> continuation) {
        final String str = "SELECT manual_retry_count FROM job where id= ?";
        return DBUtil.performSuspending(this.__db, true, false, new Function1() { // from class: com.box.android.data.persistence.jobs.JobsDao_Impl$$ExternalSyntheticLambda31
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return Integer.valueOf(JobsDao_Impl.getManualRetryCount$lambda$0(str, this, jobId, (SQLiteConnection) obj));
            }
        }, continuation);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final int getManualRetryCount$lambda$0(String str, JobsDao_Impl jobsDao_Impl, JobId jobId, SQLiteConnection _connection) {
        Intrinsics.checkNotNullParameter(_connection, "_connection");
        SQLiteStatement sQLiteStatementPrepare = _connection.prepare(str);
        try {
            String string = jobsDao_Impl.__jobIdConverter.toString(jobId);
            if (string == null) {
                sQLiteStatementPrepare.mo10943bindNull(1);
            } else {
                sQLiteStatementPrepare.mo10944bindText(1, string);
            }
            return sQLiteStatementPrepare.step() ? (int) sQLiteStatementPrepare.getLong(0) : 0;
        } finally {
            sQLiteStatementPrepare.close();
        }
    }

    @Override // com.box.android.data.persistence.jobs.JobsDao
    public Object getLogData(final JobId jobId, Continuation<? super byte[]> continuation) {
        final String str = "SELECT log_data FROM job where id= ?";
        return DBUtil.performSuspending(this.__db, true, false, new Function1() { // from class: com.box.android.data.persistence.jobs.JobsDao_Impl$$ExternalSyntheticLambda12
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return JobsDao_Impl.getLogData$lambda$0(str, this, jobId, (SQLiteConnection) obj);
            }
        }, continuation);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final byte[] getLogData$lambda$0(String str, JobsDao_Impl jobsDao_Impl, JobId jobId, SQLiteConnection _connection) {
        Intrinsics.checkNotNullParameter(_connection, "_connection");
        SQLiteStatement sQLiteStatementPrepare = _connection.prepare(str);
        try {
            String string = jobsDao_Impl.__jobIdConverter.toString(jobId);
            if (string == null) {
                sQLiteStatementPrepare.mo10943bindNull(1);
            } else {
                sQLiteStatementPrepare.mo10944bindText(1, string);
            }
            if (sQLiteStatementPrepare.step()) {
                byte[] blob = sQLiteStatementPrepare.getBlob(0);
                sQLiteStatementPrepare.close();
                return blob;
            }
            throw new IllegalStateException("The query result was empty, but expected a single row to return a NON-NULL object of type 'kotlin.ByteArray'.".toString());
        } catch (Throwable th) {
            sQLiteStatementPrepare.close();
            throw th;
        }
    }

    @Override // com.box.android.data.persistence.jobs.JobsDao
    public Object getChildJobs(final JobId jobId, Continuation<? super List<JobId>> continuation) {
        final String str = "SELECT id from job WHERE parentID=?";
        return DBUtil.performSuspending(this.__db, true, false, new Function1() { // from class: com.box.android.data.persistence.jobs.JobsDao_Impl$$ExternalSyntheticLambda10
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return JobsDao_Impl.getChildJobs$lambda$0(str, this, jobId, (SQLiteConnection) obj);
            }
        }, continuation);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final List getChildJobs$lambda$0(String str, JobsDao_Impl jobsDao_Impl, JobId jobId, SQLiteConnection _connection) {
        Intrinsics.checkNotNullParameter(_connection, "_connection");
        SQLiteStatement sQLiteStatementPrepare = _connection.prepare(str);
        try {
            String string = jobsDao_Impl.__jobIdConverter.toString(jobId);
            if (string == null) {
                sQLiteStatementPrepare.mo10943bindNull(1);
            } else {
                sQLiteStatementPrepare.mo10944bindText(1, string);
            }
            ArrayList arrayList = new ArrayList();
            while (sQLiteStatementPrepare.step()) {
                JobId jobIdFromString = jobsDao_Impl.__jobIdConverter.fromString(sQLiteStatementPrepare.isNull(0) ? null : sQLiteStatementPrepare.getText(0));
                if (jobIdFromString == null) {
                    throw new IllegalStateException("Expected NON-NULL 'com.box.android.domain.jobs.JobId', but it was NULL.".toString());
                }
                arrayList.add(jobIdFromString);
            }
            sQLiteStatementPrepare.close();
            return arrayList;
        } catch (Throwable th) {
            sQLiteStatementPrepare.close();
            throw th;
        }
    }

    @Override // com.box.android.data.persistence.jobs.JobsDao
    public Flow<JobStatus> getJobStatus(final JobId jobId) {
        Intrinsics.checkNotNullParameter(jobId, "jobId");
        final String str = "SELECT status FROM job where id= ?";
        return FlowUtil.createFlow(this.__db, false, new String[]{"job"}, new Function1() { // from class: com.box.android.data.persistence.jobs.JobsDao_Impl$$ExternalSyntheticLambda28
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return JobsDao_Impl.getJobStatus$lambda$0(str, this, jobId, (SQLiteConnection) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final JobStatus getJobStatus$lambda$0(String str, JobsDao_Impl jobsDao_Impl, JobId jobId, SQLiteConnection _connection) {
        Intrinsics.checkNotNullParameter(_connection, "_connection");
        SQLiteStatement sQLiteStatementPrepare = _connection.prepare(str);
        try {
            String string = jobsDao_Impl.__jobIdConverter.toString(jobId);
            if (string == null) {
                sQLiteStatementPrepare.mo10943bindNull(1);
            } else {
                sQLiteStatementPrepare.mo10944bindText(1, string);
            }
            if (sQLiteStatementPrepare.step()) {
                JobStatus jobStatusFromString = jobsDao_Impl.__jobStatusConverter.fromString(sQLiteStatementPrepare.isNull(0) ? null : sQLiteStatementPrepare.getText(0));
                if (jobStatusFromString == null) {
                    throw new IllegalStateException("Expected NON-NULL 'com.box.android.`data`.persistence.jobs.JobStatus', but it was NULL.".toString());
                }
                sQLiteStatementPrepare.close();
                return jobStatusFromString;
            }
            throw new IllegalStateException("The query result was empty, but expected a single row to return a NON-NULL object of type 'com.box.android.`data`.persistence.jobs.JobStatus'.".toString());
        } catch (Throwable th) {
            sQLiteStatementPrepare.close();
            throw th;
        }
    }

    @Override // com.box.android.data.persistence.jobs.JobsDao
    public Flow<List<JobEntity>> getAllJobsByStatus(final JobStatus jobStatus) {
        Intrinsics.checkNotNullParameter(jobStatus, "jobStatus");
        final String str = "SELECT * FROM job where status= ? ORDER BY created_at";
        return FlowUtil.createFlow(this.__db, false, new String[]{"job"}, new Function1() { // from class: com.box.android.data.persistence.jobs.JobsDao_Impl$$ExternalSyntheticLambda14
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return JobsDao_Impl.getAllJobsByStatus$lambda$0(str, this, jobStatus, (SQLiteConnection) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final List getAllJobsByStatus$lambda$0(String str, JobsDao_Impl jobsDao_Impl, JobStatus jobStatus, SQLiteConnection _connection) throws Throwable {
        SQLiteStatement sQLiteStatement;
        JobsDao_Impl jobsDao_Impl2 = jobsDao_Impl;
        Intrinsics.checkNotNullParameter(_connection, "_connection");
        SQLiteStatement sQLiteStatementPrepare = _connection.prepare(str);
        try {
            String string = jobsDao_Impl2.__jobStatusConverter.toString(jobStatus);
            if (string == null) {
                sQLiteStatementPrepare.mo10943bindNull(1);
            } else {
                sQLiteStatementPrepare.mo10944bindText(1, string);
            }
            int columnIndexOrThrow = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "id");
            int columnIndexOrThrow2 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "job_type");
            int columnIndexOrThrow3 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "input_data");
            int columnIndexOrThrow4 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "status");
            int columnIndexOrThrow5 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "created_at");
            int columnIndexOrThrow6 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, FirebaseAnalytics.Param.START_DATE);
            int columnIndexOrThrow7 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "earliest_start_date");
            int columnIndexOrThrow8 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "auto_retry_count");
            int columnIndexOrThrow9 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "manual_retry_count");
            int columnIndexOrThrow10 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "running_info");
            int columnIndexOrThrow11 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "error_info");
            int columnIndexOrThrow12 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "parentID");
            int columnIndexOrThrow13 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "rootID");
            int columnIndexOrThrow14 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "sortKey");
            int columnIndexOrThrow15 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "log_data");
            ArrayList arrayList = new ArrayList();
            while (sQLiteStatementPrepare.step()) {
                ArrayList arrayList2 = arrayList;
                JobId jobIdFromString = jobsDao_Impl2.__jobIdConverter.fromString(sQLiteStatementPrepare.isNull(columnIndexOrThrow) ? null : sQLiteStatementPrepare.getText(columnIndexOrThrow));
                if (jobIdFromString == null) {
                    throw new IllegalStateException("Expected NON-NULL 'com.box.android.domain.jobs.JobId', but it was NULL.".toString());
                }
                String text = sQLiteStatementPrepare.getText(columnIndexOrThrow2);
                byte[] blob = sQLiteStatementPrepare.getBlob(columnIndexOrThrow3);
                JobStatus jobStatusFromString = jobsDao_Impl2.__jobStatusConverter.fromString(sQLiteStatementPrepare.isNull(columnIndexOrThrow4) ? null : sQLiteStatementPrepare.getText(columnIndexOrThrow4));
                if (jobStatusFromString == null) {
                    throw new IllegalStateException("Expected NON-NULL 'com.box.android.`data`.persistence.jobs.JobStatus', but it was NULL.".toString());
                }
                Date dateFromTimestamp = jobsDao_Impl2.__dateToLongConverter.fromTimestamp(sQLiteStatementPrepare.isNull(columnIndexOrThrow5) ? null : Long.valueOf(sQLiteStatementPrepare.getLong(columnIndexOrThrow5)));
                if (dateFromTimestamp == null) {
                    throw new IllegalStateException("Expected NON-NULL 'java.util.Date', but it was NULL.".toString());
                }
                Date dateFromTimestamp2 = jobsDao_Impl2.__dateToLongConverter.fromTimestamp(sQLiteStatementPrepare.isNull(columnIndexOrThrow6) ? null : Long.valueOf(sQLiteStatementPrepare.getLong(columnIndexOrThrow6)));
                Date dateFromTimestamp3 = jobsDao_Impl2.__dateToLongConverter.fromTimestamp(sQLiteStatementPrepare.isNull(columnIndexOrThrow7) ? null : Long.valueOf(sQLiteStatementPrepare.getLong(columnIndexOrThrow7)));
                if (dateFromTimestamp3 == null) {
                    throw new IllegalStateException("Expected NON-NULL 'java.util.Date', but it was NULL.".toString());
                }
                int i = columnIndexOrThrow2;
                int i2 = (int) sQLiteStatementPrepare.getLong(columnIndexOrThrow8);
                int i3 = (int) sQLiteStatementPrepare.getLong(columnIndexOrThrow9);
                byte[] blob2 = sQLiteStatementPrepare.isNull(columnIndexOrThrow10) ? null : sQLiteStatementPrepare.getBlob(columnIndexOrThrow10);
                DomainError domainErrorFromString = jobsDao_Impl2.__domainErrorConverter.fromString(sQLiteStatementPrepare.isNull(columnIndexOrThrow11) ? null : sQLiteStatementPrepare.getText(columnIndexOrThrow11));
                JobId jobIdFromString2 = jobsDao_Impl2.__jobIdConverter.fromString(sQLiteStatementPrepare.isNull(columnIndexOrThrow12) ? null : sQLiteStatementPrepare.getText(columnIndexOrThrow12));
                JobId jobIdFromString3 = jobsDao_Impl2.__jobIdConverter.fromString(sQLiteStatementPrepare.isNull(columnIndexOrThrow13) ? null : sQLiteStatementPrepare.getText(columnIndexOrThrow13));
                if (jobIdFromString3 == null) {
                    throw new IllegalStateException("Expected NON-NULL 'com.box.android.domain.jobs.JobId', but it was NULL.".toString());
                }
                int i4 = columnIndexOrThrow14;
                int i5 = columnIndexOrThrow15;
                sQLiteStatement = sQLiteStatementPrepare;
                try {
                    arrayList2.add(new JobEntity(jobIdFromString, text, blob, jobStatusFromString, dateFromTimestamp, dateFromTimestamp2, dateFromTimestamp3, i2, i3, blob2, domainErrorFromString, jobIdFromString2, jobIdFromString3, sQLiteStatementPrepare.getText(i4), sQLiteStatementPrepare.getBlob(i5)));
                    jobsDao_Impl2 = jobsDao_Impl;
                    columnIndexOrThrow15 = i5;
                    columnIndexOrThrow2 = i;
                    arrayList = arrayList2;
                    sQLiteStatementPrepare = sQLiteStatement;
                    columnIndexOrThrow14 = i4;
                    columnIndexOrThrow = columnIndexOrThrow;
                } catch (Throwable th) {
                    th = th;
                    sQLiteStatement.close();
                    throw th;
                }
            }
            SQLiteStatement sQLiteStatement2 = sQLiteStatementPrepare;
            ArrayList arrayList3 = arrayList;
            sQLiteStatement2.close();
            return arrayList3;
        } catch (Throwable th2) {
            th = th2;
            sQLiteStatement = sQLiteStatementPrepare;
        }
    }

    @Override // com.box.android.data.persistence.jobs.JobsDao
    public Object getJobRunningInfo(final JobId jobId, Continuation<? super byte[]> continuation) {
        final String str = "SELECT running_info FROM job where id= ?";
        return DBUtil.performSuspending(this.__db, true, false, new Function1() { // from class: com.box.android.data.persistence.jobs.JobsDao_Impl$$ExternalSyntheticLambda3
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return JobsDao_Impl.getJobRunningInfo$lambda$0(str, this, jobId, (SQLiteConnection) obj);
            }
        }, continuation);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final byte[] getJobRunningInfo$lambda$0(String str, JobsDao_Impl jobsDao_Impl, JobId jobId, SQLiteConnection _connection) {
        Intrinsics.checkNotNullParameter(_connection, "_connection");
        SQLiteStatement sQLiteStatementPrepare = _connection.prepare(str);
        try {
            String string = jobsDao_Impl.__jobIdConverter.toString(jobId);
            if (string == null) {
                sQLiteStatementPrepare.mo10943bindNull(1);
            } else {
                sQLiteStatementPrepare.mo10944bindText(1, string);
            }
            byte[] blob = null;
            if (sQLiteStatementPrepare.step() && !sQLiteStatementPrepare.isNull(0)) {
                blob = sQLiteStatementPrepare.getBlob(0);
            }
            return blob;
        } finally {
            sQLiteStatementPrepare.close();
        }
    }

    @Override // com.box.android.data.persistence.jobs.JobsDao
    public Object getAllDependentsOnJobAsList(final JobId jobId, Continuation<? super List<JobId>> continuation) {
        final String str = "SELECT successor FROM job_dependency where predecessor = ?";
        return DBUtil.performSuspending(this.__db, true, false, new Function1() { // from class: com.box.android.data.persistence.jobs.JobsDao_Impl$$ExternalSyntheticLambda4
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return JobsDao_Impl.getAllDependentsOnJobAsList$lambda$0(str, this, jobId, (SQLiteConnection) obj);
            }
        }, continuation);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final List getAllDependentsOnJobAsList$lambda$0(String str, JobsDao_Impl jobsDao_Impl, JobId jobId, SQLiteConnection _connection) {
        Intrinsics.checkNotNullParameter(_connection, "_connection");
        SQLiteStatement sQLiteStatementPrepare = _connection.prepare(str);
        try {
            String string = jobsDao_Impl.__jobIdConverter.toString(jobId);
            if (string == null) {
                sQLiteStatementPrepare.mo10943bindNull(1);
            } else {
                sQLiteStatementPrepare.mo10944bindText(1, string);
            }
            ArrayList arrayList = new ArrayList();
            while (sQLiteStatementPrepare.step()) {
                JobId jobIdFromString = jobsDao_Impl.__jobIdConverter.fromString(sQLiteStatementPrepare.isNull(0) ? null : sQLiteStatementPrepare.getText(0));
                if (jobIdFromString == null) {
                    throw new IllegalStateException("Expected NON-NULL 'com.box.android.domain.jobs.JobId', but it was NULL.".toString());
                }
                arrayList.add(jobIdFromString);
            }
            sQLiteStatementPrepare.close();
            return arrayList;
        } catch (Throwable th) {
            sQLiteStatementPrepare.close();
            throw th;
        }
    }

    @Override // com.box.android.data.persistence.jobs.JobsDao
    public Object getPredecessorJobIDOfJob(final JobId jobId, Continuation<? super JobId> continuation) {
        final String str = "SELECT predecessor FROM job_dependency WHERE successor = ? LIMIT 1";
        return DBUtil.performSuspending(this.__db, true, false, new Function1() { // from class: com.box.android.data.persistence.jobs.JobsDao_Impl$$ExternalSyntheticLambda21
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return JobsDao_Impl.getPredecessorJobIDOfJob$lambda$0(str, this, jobId, (SQLiteConnection) obj);
            }
        }, continuation);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    public static final JobId getPredecessorJobIDOfJob$lambda$0(String str, JobsDao_Impl jobsDao_Impl, JobId jobId, SQLiteConnection _connection) {
        Intrinsics.checkNotNullParameter(_connection, "_connection");
        SQLiteStatement sQLiteStatementPrepare = _connection.prepare(str);
        try {
            String string = jobsDao_Impl.__jobIdConverter.toString(jobId);
            if (string == null) {
                sQLiteStatementPrepare.mo10943bindNull(1);
            } else {
                sQLiteStatementPrepare.mo10944bindText(1, string);
            }
            JobId jobIdFromString = null;
            String text = null;
            if (sQLiteStatementPrepare.step()) {
                if (!sQLiteStatementPrepare.isNull(0)) {
                    text = sQLiteStatementPrepare.getText(0);
                }
                jobIdFromString = jobsDao_Impl.__jobIdConverter.fromString(text);
            }
            return jobIdFromString;
        } finally {
            sQLiteStatementPrepare.close();
        }
    }

    @Override // com.box.android.data.persistence.jobs.JobsDao
    public Object getJobIdToWorkId(final JobId jobId, Continuation<? super JobIdToWorkIdRelation> continuation) {
        final String str = "SELECT * FROM job_id_to_work_id WHERE job_id = ?";
        return DBUtil.performSuspending(this.__db, true, false, new Function1() { // from class: com.box.android.data.persistence.jobs.JobsDao_Impl$$ExternalSyntheticLambda7
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return JobsDao_Impl.getJobIdToWorkId$lambda$0(str, this, jobId, (SQLiteConnection) obj);
            }
        }, continuation);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final JobIdToWorkIdRelation getJobIdToWorkId$lambda$0(String str, JobsDao_Impl jobsDao_Impl, JobId jobId, SQLiteConnection _connection) {
        Intrinsics.checkNotNullParameter(_connection, "_connection");
        SQLiteStatement sQLiteStatementPrepare = _connection.prepare(str);
        try {
            String string = jobsDao_Impl.__jobIdConverter.toString(jobId);
            if (string == null) {
                sQLiteStatementPrepare.mo10943bindNull(1);
            } else {
                sQLiteStatementPrepare.mo10944bindText(1, string);
            }
            int columnIndexOrThrow = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "job_id");
            int columnIndexOrThrow2 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "work_id");
            if (sQLiteStatementPrepare.step()) {
                JobId jobIdFromString = jobsDao_Impl.__jobIdConverter.fromString(sQLiteStatementPrepare.isNull(columnIndexOrThrow) ? null : sQLiteStatementPrepare.getText(columnIndexOrThrow));
                if (jobIdFromString == null) {
                    throw new IllegalStateException("Expected NON-NULL 'com.box.android.domain.jobs.JobId', but it was NULL.".toString());
                }
                JobIdToWorkIdRelation jobIdToWorkIdRelation = new JobIdToWorkIdRelation(jobIdFromString, sQLiteStatementPrepare.getText(columnIndexOrThrow2));
                sQLiteStatementPrepare.close();
                return jobIdToWorkIdRelation;
            }
            throw new IllegalStateException("The query result was empty, but expected a single row to return a NON-NULL object of type 'com.box.android.`data`.persistence.jobs.JobIdToWorkIdRelation'.".toString());
        } catch (Throwable th) {
            sQLiteStatementPrepare.close();
            throw th;
        }
    }

    @Override // com.box.android.data.persistence.jobs.JobsDao
    public Object getJobsWithTags(final List<String> list, Continuation<? super List<JobEntity>> continuation) {
        StringBuilder sb = new StringBuilder();
        sb.append("SELECT job.* FROM job INNER JOIN job_to_tag ON job.id = job_to_tag.job_id WHERE job_to_tag.tag IN (");
        StringUtil.appendPlaceholders(sb, list.size());
        sb.append(")");
        final String string = sb.toString();
        Intrinsics.checkNotNullExpressionValue(string, "toString(...)");
        return DBUtil.performSuspending(this.__db, true, false, new Function1() { // from class: com.box.android.data.persistence.jobs.JobsDao_Impl$$ExternalSyntheticLambda16
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return JobsDao_Impl.getJobsWithTags$lambda$0(string, list, this, (SQLiteConnection) obj);
            }
        }, continuation);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final List getJobsWithTags$lambda$0(String str, List list, JobsDao_Impl jobsDao_Impl, SQLiteConnection _connection) throws Throwable {
        SQLiteStatement sQLiteStatement;
        Intrinsics.checkNotNullParameter(_connection, "_connection");
        SQLiteStatement sQLiteStatementPrepare = _connection.prepare(str);
        try {
            Iterator it = list.iterator();
            int i = 1;
            while (it.hasNext()) {
                sQLiteStatementPrepare.mo10944bindText(i, (String) it.next());
                i++;
            }
            int columnIndexOrThrow = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "id");
            int columnIndexOrThrow2 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "job_type");
            int columnIndexOrThrow3 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "input_data");
            int columnIndexOrThrow4 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "status");
            int columnIndexOrThrow5 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "created_at");
            int columnIndexOrThrow6 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, FirebaseAnalytics.Param.START_DATE);
            int columnIndexOrThrow7 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "earliest_start_date");
            int columnIndexOrThrow8 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "auto_retry_count");
            int columnIndexOrThrow9 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "manual_retry_count");
            int columnIndexOrThrow10 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "running_info");
            int columnIndexOrThrow11 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "error_info");
            int columnIndexOrThrow12 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "parentID");
            int columnIndexOrThrow13 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "rootID");
            int columnIndexOrThrow14 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "sortKey");
            int columnIndexOrThrow15 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "log_data");
            ArrayList arrayList = new ArrayList();
            while (sQLiteStatementPrepare.step()) {
                ArrayList arrayList2 = arrayList;
                JobId jobIdFromString = jobsDao_Impl.__jobIdConverter.fromString(sQLiteStatementPrepare.isNull(columnIndexOrThrow) ? null : sQLiteStatementPrepare.getText(columnIndexOrThrow));
                if (jobIdFromString == null) {
                    throw new IllegalStateException("Expected NON-NULL 'com.box.android.domain.jobs.JobId', but it was NULL.".toString());
                }
                String text = sQLiteStatementPrepare.getText(columnIndexOrThrow2);
                byte[] blob = sQLiteStatementPrepare.getBlob(columnIndexOrThrow3);
                JobStatus jobStatusFromString = jobsDao_Impl.__jobStatusConverter.fromString(sQLiteStatementPrepare.isNull(columnIndexOrThrow4) ? null : sQLiteStatementPrepare.getText(columnIndexOrThrow4));
                if (jobStatusFromString == null) {
                    throw new IllegalStateException("Expected NON-NULL 'com.box.android.`data`.persistence.jobs.JobStatus', but it was NULL.".toString());
                }
                Date dateFromTimestamp = jobsDao_Impl.__dateToLongConverter.fromTimestamp(sQLiteStatementPrepare.isNull(columnIndexOrThrow5) ? null : Long.valueOf(sQLiteStatementPrepare.getLong(columnIndexOrThrow5)));
                if (dateFromTimestamp == null) {
                    throw new IllegalStateException("Expected NON-NULL 'java.util.Date', but it was NULL.".toString());
                }
                Date dateFromTimestamp2 = jobsDao_Impl.__dateToLongConverter.fromTimestamp(sQLiteStatementPrepare.isNull(columnIndexOrThrow6) ? null : Long.valueOf(sQLiteStatementPrepare.getLong(columnIndexOrThrow6)));
                Date dateFromTimestamp3 = jobsDao_Impl.__dateToLongConverter.fromTimestamp(sQLiteStatementPrepare.isNull(columnIndexOrThrow7) ? null : Long.valueOf(sQLiteStatementPrepare.getLong(columnIndexOrThrow7)));
                if (dateFromTimestamp3 == null) {
                    throw new IllegalStateException("Expected NON-NULL 'java.util.Date', but it was NULL.".toString());
                }
                int i2 = columnIndexOrThrow2;
                int i3 = (int) sQLiteStatementPrepare.getLong(columnIndexOrThrow8);
                int i4 = (int) sQLiteStatementPrepare.getLong(columnIndexOrThrow9);
                byte[] blob2 = sQLiteStatementPrepare.isNull(columnIndexOrThrow10) ? null : sQLiteStatementPrepare.getBlob(columnIndexOrThrow10);
                DomainError domainErrorFromString = jobsDao_Impl.__domainErrorConverter.fromString(sQLiteStatementPrepare.isNull(columnIndexOrThrow11) ? null : sQLiteStatementPrepare.getText(columnIndexOrThrow11));
                JobId jobIdFromString2 = jobsDao_Impl.__jobIdConverter.fromString(sQLiteStatementPrepare.isNull(columnIndexOrThrow12) ? null : sQLiteStatementPrepare.getText(columnIndexOrThrow12));
                JobId jobIdFromString3 = jobsDao_Impl.__jobIdConverter.fromString(sQLiteStatementPrepare.isNull(columnIndexOrThrow13) ? null : sQLiteStatementPrepare.getText(columnIndexOrThrow13));
                if (jobIdFromString3 == null) {
                    throw new IllegalStateException("Expected NON-NULL 'com.box.android.domain.jobs.JobId', but it was NULL.".toString());
                }
                int i5 = columnIndexOrThrow14;
                int i6 = columnIndexOrThrow15;
                sQLiteStatement = sQLiteStatementPrepare;
                try {
                    arrayList2.add(new JobEntity(jobIdFromString, text, blob, jobStatusFromString, dateFromTimestamp, dateFromTimestamp2, dateFromTimestamp3, i3, i4, blob2, domainErrorFromString, jobIdFromString2, jobIdFromString3, sQLiteStatementPrepare.getText(i5), sQLiteStatementPrepare.getBlob(i6)));
                    columnIndexOrThrow15 = i6;
                    columnIndexOrThrow2 = i2;
                    arrayList = arrayList2;
                    sQLiteStatementPrepare = sQLiteStatement;
                    columnIndexOrThrow14 = i5;
                    columnIndexOrThrow = columnIndexOrThrow;
                } catch (Throwable th) {
                    th = th;
                    sQLiteStatement.close();
                    throw th;
                }
            }
            SQLiteStatement sQLiteStatement2 = sQLiteStatementPrepare;
            ArrayList arrayList3 = arrayList;
            sQLiteStatement2.close();
            return arrayList3;
        } catch (Throwable th2) {
            th = th2;
            sQLiteStatement = sQLiteStatementPrepare;
        }
    }

    @Override // com.box.android.data.persistence.jobs.JobsDao
    public Object getAllJobs(Continuation<? super List<JobEntity>> continuation) {
        final String str = "SELECT job.* FROM job";
        return DBUtil.performSuspending(this.__db, true, false, new Function1() { // from class: com.box.android.data.persistence.jobs.JobsDao_Impl$$ExternalSyntheticLambda18
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return JobsDao_Impl.getAllJobs$lambda$0(str, this, (SQLiteConnection) obj);
            }
        }, continuation);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final List getAllJobs$lambda$0(String str, JobsDao_Impl jobsDao_Impl, SQLiteConnection _connection) throws Throwable {
        SQLiteStatement sQLiteStatement;
        Intrinsics.checkNotNullParameter(_connection, "_connection");
        SQLiteStatement sQLiteStatementPrepare = _connection.prepare(str);
        try {
            int columnIndexOrThrow = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "id");
            int columnIndexOrThrow2 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "job_type");
            int columnIndexOrThrow3 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "input_data");
            int columnIndexOrThrow4 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "status");
            int columnIndexOrThrow5 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "created_at");
            int columnIndexOrThrow6 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, FirebaseAnalytics.Param.START_DATE);
            int columnIndexOrThrow7 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "earliest_start_date");
            int columnIndexOrThrow8 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "auto_retry_count");
            int columnIndexOrThrow9 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "manual_retry_count");
            int columnIndexOrThrow10 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "running_info");
            int columnIndexOrThrow11 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "error_info");
            int columnIndexOrThrow12 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "parentID");
            int columnIndexOrThrow13 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "rootID");
            int columnIndexOrThrow14 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "sortKey");
            int columnIndexOrThrow15 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "log_data");
            ArrayList arrayList = new ArrayList();
            while (sQLiteStatementPrepare.step()) {
                ArrayList arrayList2 = arrayList;
                JobId jobIdFromString = jobsDao_Impl.__jobIdConverter.fromString(sQLiteStatementPrepare.isNull(columnIndexOrThrow) ? null : sQLiteStatementPrepare.getText(columnIndexOrThrow));
                if (jobIdFromString == null) {
                    throw new IllegalStateException("Expected NON-NULL 'com.box.android.domain.jobs.JobId', but it was NULL.".toString());
                }
                String text = sQLiteStatementPrepare.getText(columnIndexOrThrow2);
                byte[] blob = sQLiteStatementPrepare.getBlob(columnIndexOrThrow3);
                JobStatus jobStatusFromString = jobsDao_Impl.__jobStatusConverter.fromString(sQLiteStatementPrepare.isNull(columnIndexOrThrow4) ? null : sQLiteStatementPrepare.getText(columnIndexOrThrow4));
                if (jobStatusFromString == null) {
                    throw new IllegalStateException("Expected NON-NULL 'com.box.android.`data`.persistence.jobs.JobStatus', but it was NULL.".toString());
                }
                Date dateFromTimestamp = jobsDao_Impl.__dateToLongConverter.fromTimestamp(sQLiteStatementPrepare.isNull(columnIndexOrThrow5) ? null : Long.valueOf(sQLiteStatementPrepare.getLong(columnIndexOrThrow5)));
                if (dateFromTimestamp == null) {
                    throw new IllegalStateException("Expected NON-NULL 'java.util.Date', but it was NULL.".toString());
                }
                Date dateFromTimestamp2 = jobsDao_Impl.__dateToLongConverter.fromTimestamp(sQLiteStatementPrepare.isNull(columnIndexOrThrow6) ? null : Long.valueOf(sQLiteStatementPrepare.getLong(columnIndexOrThrow6)));
                Date dateFromTimestamp3 = jobsDao_Impl.__dateToLongConverter.fromTimestamp(sQLiteStatementPrepare.isNull(columnIndexOrThrow7) ? null : Long.valueOf(sQLiteStatementPrepare.getLong(columnIndexOrThrow7)));
                if (dateFromTimestamp3 == null) {
                    throw new IllegalStateException("Expected NON-NULL 'java.util.Date', but it was NULL.".toString());
                }
                int i = columnIndexOrThrow2;
                int i2 = (int) sQLiteStatementPrepare.getLong(columnIndexOrThrow8);
                int i3 = (int) sQLiteStatementPrepare.getLong(columnIndexOrThrow9);
                byte[] blob2 = sQLiteStatementPrepare.isNull(columnIndexOrThrow10) ? null : sQLiteStatementPrepare.getBlob(columnIndexOrThrow10);
                DomainError domainErrorFromString = jobsDao_Impl.__domainErrorConverter.fromString(sQLiteStatementPrepare.isNull(columnIndexOrThrow11) ? null : sQLiteStatementPrepare.getText(columnIndexOrThrow11));
                JobId jobIdFromString2 = jobsDao_Impl.__jobIdConverter.fromString(sQLiteStatementPrepare.isNull(columnIndexOrThrow12) ? null : sQLiteStatementPrepare.getText(columnIndexOrThrow12));
                JobId jobIdFromString3 = jobsDao_Impl.__jobIdConverter.fromString(sQLiteStatementPrepare.isNull(columnIndexOrThrow13) ? null : sQLiteStatementPrepare.getText(columnIndexOrThrow13));
                if (jobIdFromString3 == null) {
                    throw new IllegalStateException("Expected NON-NULL 'com.box.android.domain.jobs.JobId', but it was NULL.".toString());
                }
                int i4 = columnIndexOrThrow14;
                int i5 = columnIndexOrThrow15;
                sQLiteStatement = sQLiteStatementPrepare;
                try {
                    arrayList2.add(new JobEntity(jobIdFromString, text, blob, jobStatusFromString, dateFromTimestamp, dateFromTimestamp2, dateFromTimestamp3, i2, i3, blob2, domainErrorFromString, jobIdFromString2, jobIdFromString3, sQLiteStatementPrepare.getText(i4), sQLiteStatementPrepare.getBlob(i5)));
                    columnIndexOrThrow15 = i5;
                    columnIndexOrThrow2 = i;
                    arrayList = arrayList2;
                    sQLiteStatementPrepare = sQLiteStatement;
                    columnIndexOrThrow14 = i4;
                    columnIndexOrThrow = columnIndexOrThrow;
                } catch (Throwable th) {
                    th = th;
                    sQLiteStatement.close();
                    throw th;
                }
            }
            SQLiteStatement sQLiteStatement2 = sQLiteStatementPrepare;
            ArrayList arrayList3 = arrayList;
            sQLiteStatement2.close();
            return arrayList3;
        } catch (Throwable th2) {
            th = th2;
            sQLiteStatement = sQLiteStatementPrepare;
        }
    }

    @Override // com.box.android.data.persistence.jobs.JobsDao
    public Object getTags(final JobId jobId, Continuation<? super List<String>> continuation) {
        final String str = "SELECT tag from job_to_tag where job_id = ?";
        return DBUtil.performSuspending(this.__db, true, false, new Function1() { // from class: com.box.android.data.persistence.jobs.JobsDao_Impl$$ExternalSyntheticLambda8
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return JobsDao_Impl.getTags$lambda$0(str, this, jobId, (SQLiteConnection) obj);
            }
        }, continuation);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final List getTags$lambda$0(String str, JobsDao_Impl jobsDao_Impl, JobId jobId, SQLiteConnection _connection) {
        Intrinsics.checkNotNullParameter(_connection, "_connection");
        SQLiteStatement sQLiteStatementPrepare = _connection.prepare(str);
        try {
            String string = jobsDao_Impl.__jobIdConverter.toString(jobId);
            if (string == null) {
                sQLiteStatementPrepare.mo10943bindNull(1);
            } else {
                sQLiteStatementPrepare.mo10944bindText(1, string);
            }
            ArrayList arrayList = new ArrayList();
            while (sQLiteStatementPrepare.step()) {
                arrayList.add(sQLiteStatementPrepare.getText(0));
            }
            return arrayList;
        } finally {
            sQLiteStatementPrepare.close();
        }
    }

    @Override // com.box.android.data.persistence.jobs.JobsDao
    public Object deleteJob(final JobId jobId, Continuation<? super Unit> continuation) {
        final String str = "DELETE FROM job where id = ?";
        Object objPerformSuspending = DBUtil.performSuspending(this.__db, false, true, new Function1() { // from class: com.box.android.data.persistence.jobs.JobsDao_Impl$$ExternalSyntheticLambda5
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return JobsDao_Impl.deleteJob$lambda$0(str, this, jobId, (SQLiteConnection) obj);
            }
        }, continuation);
        return objPerformSuspending == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objPerformSuspending : Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit deleteJob$lambda$0(String str, JobsDao_Impl jobsDao_Impl, JobId jobId, SQLiteConnection _connection) {
        Intrinsics.checkNotNullParameter(_connection, "_connection");
        SQLiteStatement sQLiteStatementPrepare = _connection.prepare(str);
        try {
            String string = jobsDao_Impl.__jobIdConverter.toString(jobId);
            if (string == null) {
                sQLiteStatementPrepare.mo10943bindNull(1);
            } else {
                sQLiteStatementPrepare.mo10944bindText(1, string);
            }
            sQLiteStatementPrepare.step();
            return Unit.INSTANCE;
        } finally {
            sQLiteStatementPrepare.close();
        }
    }

    @Override // com.box.android.data.persistence.jobs.JobsDao
    public Object updateStatusOfJob(final JobId jobId, final JobStatus jobStatus, final DomainError domainError, Continuation<? super Unit> continuation) {
        final String str = "UPDATE job SET status = ?, error_info = ? WHERE id = ?";
        Object objPerformSuspending = DBUtil.performSuspending(this.__db, false, true, new Function1() { // from class: com.box.android.data.persistence.jobs.JobsDao_Impl$$ExternalSyntheticLambda26
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return JobsDao_Impl.updateStatusOfJob$lambda$0(str, this, jobStatus, domainError, jobId, (SQLiteConnection) obj);
            }
        }, continuation);
        return objPerformSuspending == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objPerformSuspending : Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit updateStatusOfJob$lambda$0(String str, JobsDao_Impl jobsDao_Impl, JobStatus jobStatus, DomainError domainError, JobId jobId, SQLiteConnection _connection) {
        Intrinsics.checkNotNullParameter(_connection, "_connection");
        SQLiteStatement sQLiteStatementPrepare = _connection.prepare(str);
        try {
            String string = jobsDao_Impl.__jobStatusConverter.toString(jobStatus);
            if (string == null) {
                sQLiteStatementPrepare.mo10943bindNull(1);
            } else {
                sQLiteStatementPrepare.mo10944bindText(1, string);
            }
            String string2 = jobsDao_Impl.__domainErrorConverter.toString(domainError);
            if (string2 == null) {
                sQLiteStatementPrepare.mo10943bindNull(2);
            } else {
                sQLiteStatementPrepare.mo10944bindText(2, string2);
            }
            String string3 = jobsDao_Impl.__jobIdConverter.toString(jobId);
            if (string3 == null) {
                sQLiteStatementPrepare.mo10943bindNull(3);
            } else {
                sQLiteStatementPrepare.mo10944bindText(3, string3);
            }
            sQLiteStatementPrepare.step();
            return Unit.INSTANCE;
        } finally {
            sQLiteStatementPrepare.close();
        }
    }

    @Override // com.box.android.data.persistence.jobs.JobsDao
    public Object updateLogDataOfJob(final JobId jobId, final byte[] bArr, Continuation<? super Unit> continuation) {
        final String str = "UPDATE job SET log_data = ? WHERE id = ?";
        Object objPerformSuspending = DBUtil.performSuspending(this.__db, false, true, new Function1() { // from class: com.box.android.data.persistence.jobs.JobsDao_Impl$$ExternalSyntheticLambda27
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return JobsDao_Impl.updateLogDataOfJob$lambda$0(str, bArr, this, jobId, (SQLiteConnection) obj);
            }
        }, continuation);
        return objPerformSuspending == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objPerformSuspending : Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit updateLogDataOfJob$lambda$0(String str, byte[] bArr, JobsDao_Impl jobsDao_Impl, JobId jobId, SQLiteConnection _connection) {
        Intrinsics.checkNotNullParameter(_connection, "_connection");
        SQLiteStatement sQLiteStatementPrepare = _connection.prepare(str);
        try {
            sQLiteStatementPrepare.mo10940bindBlob(1, bArr);
            String string = jobsDao_Impl.__jobIdConverter.toString(jobId);
            if (string == null) {
                sQLiteStatementPrepare.mo10943bindNull(2);
            } else {
                sQLiteStatementPrepare.mo10944bindText(2, string);
            }
            sQLiteStatementPrepare.step();
            return Unit.INSTANCE;
        } finally {
            sQLiteStatementPrepare.close();
        }
    }

    @Override // com.box.android.data.persistence.jobs.JobsDao
    public Object updateRunningInfoOfJob(final JobId jobId, final byte[] bArr, Continuation<? super Unit> continuation) {
        final String str = "UPDATE job SET running_info = ? WHERE id=?";
        Object objPerformSuspending = DBUtil.performSuspending(this.__db, false, true, new Function1() { // from class: com.box.android.data.persistence.jobs.JobsDao_Impl$$ExternalSyntheticLambda1
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return JobsDao_Impl.updateRunningInfoOfJob$lambda$0(str, bArr, this, jobId, (SQLiteConnection) obj);
            }
        }, continuation);
        return objPerformSuspending == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objPerformSuspending : Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit updateRunningInfoOfJob$lambda$0(String str, byte[] bArr, JobsDao_Impl jobsDao_Impl, JobId jobId, SQLiteConnection _connection) {
        Intrinsics.checkNotNullParameter(_connection, "_connection");
        SQLiteStatement sQLiteStatementPrepare = _connection.prepare(str);
        try {
            if (bArr == null) {
                sQLiteStatementPrepare.mo10943bindNull(1);
            } else {
                sQLiteStatementPrepare.mo10940bindBlob(1, bArr);
            }
            String string = jobsDao_Impl.__jobIdConverter.toString(jobId);
            if (string == null) {
                sQLiteStatementPrepare.mo10943bindNull(2);
            } else {
                sQLiteStatementPrepare.mo10944bindText(2, string);
            }
            sQLiteStatementPrepare.step();
            sQLiteStatementPrepare.close();
            return Unit.INSTANCE;
        } catch (Throwable th) {
            sQLiteStatementPrepare.close();
            throw th;
        }
    }

    @Override // com.box.android.data.persistence.jobs.JobsDao
    public Object deleteTagToJob(final String str, final JobId jobId, Continuation<? super Unit> continuation) {
        final String str2 = "DELETE FROM job_to_tag where tag = ? AND job_id = ?";
        Object objPerformSuspending = DBUtil.performSuspending(this.__db, false, true, new Function1() { // from class: com.box.android.data.persistence.jobs.JobsDao_Impl$$ExternalSyntheticLambda6
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return JobsDao_Impl.deleteTagToJob$lambda$0(str2, str, this, jobId, (SQLiteConnection) obj);
            }
        }, continuation);
        return objPerformSuspending == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objPerformSuspending : Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit deleteTagToJob$lambda$0(String str, String str2, JobsDao_Impl jobsDao_Impl, JobId jobId, SQLiteConnection _connection) {
        Intrinsics.checkNotNullParameter(_connection, "_connection");
        SQLiteStatement sQLiteStatementPrepare = _connection.prepare(str);
        try {
            sQLiteStatementPrepare.mo10944bindText(1, str2);
            String string = jobsDao_Impl.__jobIdConverter.toString(jobId);
            if (string == null) {
                sQLiteStatementPrepare.mo10943bindNull(2);
            } else {
                sQLiteStatementPrepare.mo10944bindText(2, string);
            }
            sQLiteStatementPrepare.step();
            return Unit.INSTANCE;
        } finally {
            sQLiteStatementPrepare.close();
        }
    }

    /* JADX INFO: compiled from: JobsDao_Impl.kt */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00060\u0005¨\u0006\u0007"}, d2 = {"Lcom/box/android/data/persistence/jobs/JobsDao_Impl$Companion;", "", "<init>", "()V", "getRequiredConverters", "", "Lkotlin/reflect/KClass;", "data_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final List<KClass<?>> getRequiredConverters() {
            return CollectionsKt.emptyList();
        }
    }
}
