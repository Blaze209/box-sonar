package com.box.android.data.datasource.jobs;

import androidx.room.RoomDatabaseKt;
import androidx.work.Data;
import com.box.android.coreservices.jobmanager.jobs.DeleteBoxJob;
import com.box.android.data.datasource.CacheError;
import com.box.android.data.jobs.JobWorker;
import com.box.android.data.persistence.BoxDatabase;
import com.box.android.data.persistence.jobs.JobEntity;
import com.box.android.data.persistence.jobs.JobIdToWorkIdRelation;
import com.box.android.data.persistence.jobs.JobStatus;
import com.box.android.data.persistence.jobs.JobsDao;
import com.box.android.data.persistence.jobs.RootIdWithRunningJobsCount;
import com.box.android.data.user.UserData;
import com.box.android.domain.jobs.JobId;
import com.box.android.domain.models.DomainError;
import com.box.android.domain.utils.ExtensionsKt;
import com.box.android.domain.utils.result.Result;
import com.box.androidsdk.content.models.BoxOrder;
import com.box.androidsdk.content.utils.BoxLogUtils;
import external.sdk.pendo.io.mozilla.javascript.Context;
import external.sdk.pendo.io.mozilla.javascript.Token;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.SetsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: JobsDataSource.kt */
/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000¨\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0012\n\u0002\b\f\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0011\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005JB\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t0\u00072\u0006\u0010\n\u001a\u00020\u000b2\u000e\b\u0002\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000e0\r2\u000e\b\u0002\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00100\rH\u0086@¢\u0006\u0002\u0010\u0011J\"\u0010\u0012\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u00130\u00072\u0006\u0010\u0014\u001a\u00020\u000eH\u0086@¢\u0006\u0002\u0010\u0015J6\u0010\u0016\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u00130\u00072\u0006\u0010\u0014\u001a\u00020\u000e2\u0006\u0010\u0017\u001a\u00020\u00182\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u001aH\u0086@¢\u0006\u0002\u0010\u001bJ\"\u0010\u001c\u001a\u000e\u0012\u0004\u0012\u00020\u001d\u0012\u0004\u0012\u00020\u00130\u00072\u0006\u0010\u0014\u001a\u00020\u000eH\u0086@¢\u0006\u0002\u0010\u0015J$\u0010\u001e\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u001f\u0012\u0004\u0012\u00020\u00130\u00072\u0006\u0010\u0014\u001a\u00020\u000eH\u0086@¢\u0006\u0002\u0010\u0015J,\u0010 \u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u00130\u00072\u0006\u0010\u0014\u001a\u00020\u000e2\b\u0010!\u001a\u0004\u0018\u00010\u001fH\u0086@¢\u0006\u0002\u0010\"J\"\u0010#\u001a\u000e\u0012\u0004\u0012\u00020\u001d\u0012\u0004\u0012\u00020\u00130\u00072\u0006\u0010\u0014\u001a\u00020\u000eH\u0086@¢\u0006\u0002\u0010\u0015J\"\u0010$\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u00130\u00072\u0006\u0010\u0014\u001a\u00020\u000eH\u0086@¢\u0006\u0002\u0010\u0015J\"\u0010%\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u00130\u00072\u0006\u0010\u0014\u001a\u00020\u000eH\u0086@¢\u0006\u0002\u0010\u0015J\u001a\u0010&\u001a\u000e\u0012\u0004\u0012\u00020\u001d\u0012\u0004\u0012\u00020\u00130\u0007H\u0086@¢\u0006\u0002\u0010'J\u001c\u0010(\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u000b\u0012\u0004\u0012\u00020\u00130\u0007H\u0086@¢\u0006\u0002\u0010'J\u001c\u0010)\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u000b\u0012\u0004\u0012\u00020\u00130\u0007H\u0087@¢\u0006\u0002\u0010'J2\u0010*\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u000b\u0012\u0004\u0012\u00020\u00130\u00072\f\u0010+\u001a\b\u0012\u0004\u0012\u00020\u000b0,2\u0006\u0010-\u001a\u00020.H\u0087@¢\u0006\u0002\u0010/J \u00100\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000b0,\u0012\u0004\u0012\u00020\u00130\u0007H\u0087@¢\u0006\u0002\u0010'J \u00101\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u0002020,\u0012\u0004\u0012\u00020\u00130\u0007H\u0087@¢\u0006\u0002\u0010'J.\u00103\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000b0,\u0012\u0004\u0012\u00020\u00130\u00072\f\u00104\u001a\b\u0012\u0004\u0012\u00020\u000e0,H\u0087@¢\u0006\u0002\u00105J \u00106\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000e0,\u0012\u0004\u0012\u00020\u00130\u0007H\u0087@¢\u0006\u0002\u0010'J\"\u00107\u001a\u000e\u0012\u0004\u0012\u000208\u0012\u0004\u0012\u0002090\u00072\u0006\u0010:\u001a\u00020\u000eH\u0087@¢\u0006\u0002\u0010\u0015J\u001c\u0010;\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u00010.\u0012\u0004\u0012\u00020\u00130\u0007H\u0086@¢\u0006\u0002\u0010'J\"\u0010<\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u00130\u00072\u0006\u0010\u0014\u001a\u00020\u000eH\u0086@¢\u0006\u0002\u0010\u0015J(\u0010=\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000e0,\u0012\u0004\u0012\u00020\u00130\u00072\u0006\u0010\u0014\u001a\u00020\u000eH\u0086@¢\u0006\u0002\u0010\u0015J8\u0010>\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u00130\u00072\u001c\u0010?\u001a\u0018\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0A\u0012\u0006\u0012\u0004\u0018\u00010\u00010@H\u0086@¢\u0006\u0002\u0010BJ.\u0010C\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000b0,\u0012\u0004\u0012\u00020\u00130\u00072\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00100,H\u0086@¢\u0006\u0002\u00105J \u0010D\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000b0,\u0012\u0004\u0012\u00020\u00130\u0007H\u0086@¢\u0006\u0002\u0010'J(\u0010E\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000e0,\u0012\u0004\u0012\u00020\u00130\u00072\u0006\u0010:\u001a\u00020\u000eH\u0086@¢\u0006\u0002\u0010\u0015J(\u0010F\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00100,\u0012\u0004\u0012\u00020\u00130\u00072\u0006\u0010\u0014\u001a\u00020\u000eH\u0086@¢\u0006\u0002\u0010\u0015J\"\u0010G\u001a\u000e\u0012\u0004\u0012\u00020H\u0012\u0004\u0012\u00020\t0\u00072\u0006\u0010I\u001a\u00020JH\u0086@¢\u0006\u0002\u0010KJ\"\u0010L\u001a\u000e\u0012\u0004\u0012\u00020M\u0012\u0004\u0012\u00020\u00130\u00072\u0006\u0010\u0014\u001a\u00020\u000eH\u0086@¢\u0006\u0002\u0010\u0015J6\u0010N\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u00130\u00072\u0006\u0010\u0014\u001a\u00020\u000e2\u0012\u0010O\u001a\u000e\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u00010PH\u0086@¢\u0006\u0002\u0010QR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006R"}, d2 = {"Lcom/box/android/data/datasource/jobs/JobsDataSource;", "", "userData", "Lcom/box/android/data/user/UserData;", "<init>", "(Lcom/box/android/data/user/UserData;)V", "insertOrUpdateJob", "Lcom/box/android/domain/utils/result/Result;", "", "Lcom/box/android/data/datasource/CacheError$SaveError;", "jobEntity", "Lcom/box/android/data/persistence/jobs/JobEntity;", "dependingOn", "", "Lcom/box/android/domain/jobs/JobId;", "tags", "", "(Lcom/box/android/data/persistence/jobs/JobEntity;Ljava/util/Set;Ljava/util/Set;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", DeleteBoxJob.TYPE, "Lcom/box/android/data/datasource/CacheError;", JobWorker.JOB_ID_PARAM, "(Lcom/box/android/domain/jobs/JobId;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "updateStatusOfJob", "newStatus", "Lcom/box/android/data/persistence/jobs/JobStatus;", "error", "Lcom/box/android/domain/models/DomainError;", "(Lcom/box/android/domain/jobs/JobId;Lcom/box/android/data/persistence/jobs/JobStatus;Lcom/box/android/domain/models/DomainError;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getAutoRetryCountOfJob", "", "getRunningInfo", "", "updateRunningInfo", "runningInfo", "(Lcom/box/android/domain/jobs/JobId;[BLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getManualRetryCountOfJob", "manualRetry", "automaticRetry", "getNumberOfExecutingJobs", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getNextJobToRun", "nextRunnableJob", "firstRunnableJob", "jobs", "", BoxOrder.SORT_DATE, "Ljava/util/Date;", "(Ljava/util/List;Ljava/util/Date;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getEnqueuedJobs", "getRootIDsWithRunningJobsCount", "Lcom/box/android/data/persistence/jobs/RootIdWithRunningJobsCount;", "getChildrenOfStarvedRoots", "starvedRunningRoots", "(Ljava/util/List;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getWaitingRootIDs", "doesJobHavePredecessor", "", "Lcom/box/android/data/datasource/CacheError$ReadError;", "jobID", "getEarliestStartDateOfNextJob", "getJob", "getSuccessorsAsList", "withTransaction", "block", "Lkotlin/Function1;", "Lkotlin/coroutines/Continuation;", "(Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getJobsWithTags", "getAllJobs", "getChildJobs", "getTags", "insertJobIdToWorkIdRelation", "", "jobIdToWorkIdRelation", "Lcom/box/android/data/persistence/jobs/JobIdToWorkIdRelation;", "(Lcom/box/android/data/persistence/jobs/JobIdToWorkIdRelation;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getLogData", "Landroidx/work/Data;", "updateLogData", "additionalData", "", "(Lcom/box/android/domain/jobs/JobId;Ljava/util/Map;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "data_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class JobsDataSource {
    private final UserData userData;

    /* JADX INFO: renamed from: com.box.android.data.datasource.jobs.JobsDataSource$automaticRetry$1, reason: invalid class name */
    /* JADX INFO: compiled from: JobsDataSource.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.box.android.data.datasource.jobs.JobsDataSource", f = "JobsDataSource.kt", i = {0, 0, 0, 0, 0, 0, 0}, l = {124}, m = "automaticRetry", n = {JobWorker.JOB_ID_PARAM, "$this$flatMap$iv", "boxDatabase", "$i$f$flatMap", "$i$a$-flatMap-JobsDataSource$automaticRetry$2", "$i$f$resultOf", "$i$a$-resultOf-JobsDataSource$automaticRetry$2$1"}, s = {"L$0", "L$1", "L$2", "I$0", "I$1", "I$2", "I$3"}, v = 1)
    static final class AnonymousClass1 extends ContinuationImpl {
        int I$0;
        int I$1;
        int I$2;
        int I$3;
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
            return JobsDataSource.this.automaticRetry(null, this);
        }
    }

    /* JADX INFO: renamed from: com.box.android.data.datasource.jobs.JobsDataSource$deleteJob$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: JobsDataSource.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.box.android.data.datasource.jobs.JobsDataSource", f = "JobsDataSource.kt", i = {0, 0, 0, 0, 0, 0, 0}, l = {54}, m = DeleteBoxJob.TYPE, n = {JobWorker.JOB_ID_PARAM, "$this$flatMap$iv", "boxDatabase", "$i$f$flatMap", "$i$a$-flatMap-JobsDataSource$deleteJob$2", "$i$f$resultOf", "$i$a$-resultOf-JobsDataSource$deleteJob$2$1"}, s = {"L$0", "L$1", "L$2", "I$0", "I$1", "I$2", "I$3"}, v = 1)
    static final class C11711 extends ContinuationImpl {
        int I$0;
        int I$1;
        int I$2;
        int I$3;
        Object L$0;
        Object L$1;
        Object L$2;
        int label;
        /* synthetic */ Object result;

        C11711(Continuation<? super C11711> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return JobsDataSource.this.deleteJob(null, this);
        }
    }

    /* JADX INFO: renamed from: com.box.android.data.datasource.jobs.JobsDataSource$doesJobHavePredecessor$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: JobsDataSource.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.box.android.data.datasource.jobs.JobsDataSource", f = "JobsDataSource.kt", i = {0, 0, 0, 0, 0, 0, 0}, l = {259}, m = "doesJobHavePredecessor", n = {"jobID", "$this$flatMap$iv", "boxDatabase", "$i$f$flatMap", "$i$a$-flatMap-JobsDataSource$doesJobHavePredecessor$2", "$i$f$resultOf", "$i$a$-resultOf-JobsDataSource$doesJobHavePredecessor$2$1"}, s = {"L$0", "L$1", "L$2", "I$0", "I$1", "I$2", "I$3"}, v = 1)
    static final class C11721 extends ContinuationImpl {
        int I$0;
        int I$1;
        int I$2;
        int I$3;
        Object L$0;
        Object L$1;
        Object L$2;
        int label;
        /* synthetic */ Object result;

        C11721(Continuation<? super C11721> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return JobsDataSource.this.doesJobHavePredecessor(null, this);
        }
    }

    /* JADX INFO: renamed from: com.box.android.data.datasource.jobs.JobsDataSource$firstRunnableJob$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: JobsDataSource.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.box.android.data.datasource.jobs.JobsDataSource", f = "JobsDataSource.kt", i = {0, 0, 0}, l = {192}, m = "firstRunnableJob", n = {"jobs", BoxOrder.SORT_DATE, "job"}, s = {"L$0", "L$1", "L$3"}, v = 1)
    static final class C11731 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        int label;
        /* synthetic */ Object result;

        C11731(Continuation<? super C11731> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return JobsDataSource.this.firstRunnableJob(null, null, this);
        }
    }

    /* JADX INFO: renamed from: com.box.android.data.datasource.jobs.JobsDataSource$getAllJobs$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: JobsDataSource.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.box.android.data.datasource.jobs.JobsDataSource", f = "JobsDataSource.kt", i = {0, 0, 0, 0, 0, 0}, l = {332}, m = "getAllJobs", n = {"$this$flatMap$iv", "it", "$i$f$flatMap", "$i$a$-flatMap-JobsDataSource$getAllJobs$2", "$i$f$resultOf", "$i$a$-resultOf-JobsDataSource$getAllJobs$2$1"}, s = {"L$0", "L$1", "I$0", "I$1", "I$2", "I$3"}, v = 1)
    static final class C11741 extends ContinuationImpl {
        int I$0;
        int I$1;
        int I$2;
        int I$3;
        Object L$0;
        Object L$1;
        int label;
        /* synthetic */ Object result;

        C11741(Continuation<? super C11741> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return JobsDataSource.this.getAllJobs(this);
        }
    }

    /* JADX INFO: renamed from: com.box.android.data.datasource.jobs.JobsDataSource$getAutoRetryCountOfJob$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: JobsDataSource.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.box.android.data.datasource.jobs.JobsDataSource", f = "JobsDataSource.kt", i = {0, 0, 0, 0, 0, 0, 0}, l = {73}, m = "getAutoRetryCountOfJob", n = {JobWorker.JOB_ID_PARAM, "$this$flatMap$iv", "boxDatabase", "$i$f$flatMap", "$i$a$-flatMap-JobsDataSource$getAutoRetryCountOfJob$2", "$i$f$resultOf", "$i$a$-resultOf-JobsDataSource$getAutoRetryCountOfJob$2$1"}, s = {"L$0", "L$1", "L$2", "I$0", "I$1", "I$2", "I$3"}, v = 1)
    static final class C11751 extends ContinuationImpl {
        int I$0;
        int I$1;
        int I$2;
        int I$3;
        Object L$0;
        Object L$1;
        Object L$2;
        int label;
        /* synthetic */ Object result;

        C11751(Continuation<? super C11751> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return JobsDataSource.this.getAutoRetryCountOfJob(null, this);
        }
    }

    /* JADX INFO: renamed from: com.box.android.data.datasource.jobs.JobsDataSource$getChildJobs$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: JobsDataSource.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.box.android.data.datasource.jobs.JobsDataSource", f = "JobsDataSource.kt", i = {0, 0, 0, 0, 0, 0, 0}, l = {340}, m = "getChildJobs", n = {"jobID", "$this$flatMap$iv", "it", "$i$f$flatMap", "$i$a$-flatMap-JobsDataSource$getChildJobs$2", "$i$f$resultOf", "$i$a$-resultOf-JobsDataSource$getChildJobs$2$1"}, s = {"L$0", "L$1", "L$2", "I$0", "I$1", "I$2", "I$3"}, v = 1)
    static final class C11761 extends ContinuationImpl {
        int I$0;
        int I$1;
        int I$2;
        int I$3;
        Object L$0;
        Object L$1;
        Object L$2;
        int label;
        /* synthetic */ Object result;

        C11761(Continuation<? super C11761> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return JobsDataSource.this.getChildJobs(null, this);
        }
    }

    /* JADX INFO: renamed from: com.box.android.data.datasource.jobs.JobsDataSource$getChildrenOfStarvedRoots$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: JobsDataSource.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.box.android.data.datasource.jobs.JobsDataSource", f = "JobsDataSource.kt", i = {0, 0, 0, 0, 0, 0, 0}, l = {233}, m = "getChildrenOfStarvedRoots", n = {"starvedRunningRoots", "$this$flatMap$iv", "boxDatabase", "$i$f$flatMap", "$i$a$-flatMap-JobsDataSource$getChildrenOfStarvedRoots$2", "$i$f$resultOf", "$i$a$-resultOf-JobsDataSource$getChildrenOfStarvedRoots$2$1"}, s = {"L$0", "L$1", "L$2", "I$0", "I$1", "I$2", "I$3"}, v = 1)
    static final class C11771 extends ContinuationImpl {
        int I$0;
        int I$1;
        int I$2;
        int I$3;
        Object L$0;
        Object L$1;
        Object L$2;
        int label;
        /* synthetic */ Object result;

        C11771(Continuation<? super C11771> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return JobsDataSource.this.getChildrenOfStarvedRoots(null, this);
        }
    }

    /* JADX INFO: renamed from: com.box.android.data.datasource.jobs.JobsDataSource$getEarliestStartDateOfNextJob$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: JobsDataSource.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.box.android.data.datasource.jobs.JobsDataSource", f = "JobsDataSource.kt", i = {0, 0, 0, 0, 0, 0}, l = {271}, m = "getEarliestStartDateOfNextJob", n = {"$this$flatMap$iv", "boxDatabase", "$i$f$flatMap", "$i$a$-flatMap-JobsDataSource$getEarliestStartDateOfNextJob$2", "$i$f$resultOf", "$i$a$-resultOf-JobsDataSource$getEarliestStartDateOfNextJob$2$1"}, s = {"L$0", "L$1", "I$0", "I$1", "I$2", "I$3"}, v = 1)
    static final class C11781 extends ContinuationImpl {
        int I$0;
        int I$1;
        int I$2;
        int I$3;
        Object L$0;
        Object L$1;
        int label;
        /* synthetic */ Object result;

        C11781(Continuation<? super C11781> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return JobsDataSource.this.getEarliestStartDateOfNextJob(this);
        }
    }

    /* JADX INFO: renamed from: com.box.android.data.datasource.jobs.JobsDataSource$getEnqueuedJobs$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: JobsDataSource.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.box.android.data.datasource.jobs.JobsDataSource", f = "JobsDataSource.kt", i = {0, 0, 0, 0, 0, 0}, l = {207}, m = "getEnqueuedJobs", n = {"$this$flatMap$iv", "boxDatabase", "$i$f$flatMap", "$i$a$-flatMap-JobsDataSource$getEnqueuedJobs$2", "$i$f$resultOf", "$i$a$-resultOf-JobsDataSource$getEnqueuedJobs$2$1"}, s = {"L$0", "L$1", "I$0", "I$1", "I$2", "I$3"}, v = 1)
    static final class C11791 extends ContinuationImpl {
        int I$0;
        int I$1;
        int I$2;
        int I$3;
        Object L$0;
        Object L$1;
        int label;
        /* synthetic */ Object result;

        C11791(Continuation<? super C11791> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return JobsDataSource.this.getEnqueuedJobs(this);
        }
    }

    /* JADX INFO: renamed from: com.box.android.data.datasource.jobs.JobsDataSource$getJob$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: JobsDataSource.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.box.android.data.datasource.jobs.JobsDataSource", f = "JobsDataSource.kt", i = {0, 0, 0, 0, 0, 0, 0}, l = {283}, m = "getJob", n = {JobWorker.JOB_ID_PARAM, "$this$flatMap$iv", "boxDatabase", "$i$f$flatMap", "$i$a$-flatMap-JobsDataSource$getJob$2", "$i$f$resultOf", "$i$a$-resultOf-JobsDataSource$getJob$2$1"}, s = {"L$0", "L$1", "L$2", "I$0", "I$1", "I$2", "I$3"}, v = 1)
    static final class C11801 extends ContinuationImpl {
        int I$0;
        int I$1;
        int I$2;
        int I$3;
        Object L$0;
        Object L$1;
        Object L$2;
        int label;
        /* synthetic */ Object result;

        C11801(Continuation<? super C11801> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return JobsDataSource.this.getJob(null, this);
        }
    }

    /* JADX INFO: renamed from: com.box.android.data.datasource.jobs.JobsDataSource$getJobsWithTags$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: JobsDataSource.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.box.android.data.datasource.jobs.JobsDataSource", f = "JobsDataSource.kt", i = {0, 0, 0, 0, 0, 0, 0}, l = {323}, m = "getJobsWithTags", n = {"tags", "$this$flatMap$iv", "boxDatabase", "$i$f$flatMap", "$i$a$-flatMap-JobsDataSource$getJobsWithTags$2", "$i$f$resultOf", "$i$a$-resultOf-JobsDataSource$getJobsWithTags$2$1"}, s = {"L$0", "L$1", "L$2", "I$0", "I$1", "I$2", "I$3"}, v = 1)
    static final class C11811 extends ContinuationImpl {
        int I$0;
        int I$1;
        int I$2;
        int I$3;
        Object L$0;
        Object L$1;
        Object L$2;
        int label;
        /* synthetic */ Object result;

        C11811(Continuation<? super C11811> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return JobsDataSource.this.getJobsWithTags(null, this);
        }
    }

    /* JADX INFO: renamed from: com.box.android.data.datasource.jobs.JobsDataSource$getLogData$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: JobsDataSource.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.box.android.data.datasource.jobs.JobsDataSource", f = "JobsDataSource.kt", i = {0, 0, 0, 0, 0, 0, 0}, l = {375}, m = "getLogData", n = {JobWorker.JOB_ID_PARAM, "$this$flatMap$iv", "boxDatabase", "$i$f$flatMap", "$i$a$-flatMap-JobsDataSource$getLogData$2", "$i$f$resultOf", "$i$a$-resultOf-JobsDataSource$getLogData$2$1"}, s = {"L$0", "L$1", "L$2", "I$0", "I$1", "I$2", "I$3"}, v = 1)
    static final class C11821 extends ContinuationImpl {
        int I$0;
        int I$1;
        int I$2;
        int I$3;
        Object L$0;
        Object L$1;
        Object L$2;
        int label;
        /* synthetic */ Object result;

        C11821(Continuation<? super C11821> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return JobsDataSource.this.getLogData(null, this);
        }
    }

    /* JADX INFO: renamed from: com.box.android.data.datasource.jobs.JobsDataSource$getManualRetryCountOfJob$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: JobsDataSource.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.box.android.data.datasource.jobs.JobsDataSource", f = "JobsDataSource.kt", i = {0, 0, 0, 0, 0, 0, 0}, l = {100}, m = "getManualRetryCountOfJob", n = {JobWorker.JOB_ID_PARAM, "$this$flatMap$iv", "boxDatabase", "$i$f$flatMap", "$i$a$-flatMap-JobsDataSource$getManualRetryCountOfJob$2", "$i$f$resultOf", "$i$a$-resultOf-JobsDataSource$getManualRetryCountOfJob$2$1"}, s = {"L$0", "L$1", "L$2", "I$0", "I$1", "I$2", "I$3"}, v = 1)
    static final class C11831 extends ContinuationImpl {
        int I$0;
        int I$1;
        int I$2;
        int I$3;
        Object L$0;
        Object L$1;
        Object L$2;
        int label;
        /* synthetic */ Object result;

        C11831(Continuation<? super C11831> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return JobsDataSource.this.getManualRetryCountOfJob(null, this);
        }
    }

    /* JADX INFO: renamed from: com.box.android.data.datasource.jobs.JobsDataSource$getNextJobToRun$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: JobsDataSource.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.box.android.data.datasource.jobs.JobsDataSource", f = "JobsDataSource.kt", i = {0, 0, 0, 0}, l = {Token.COLONCOLON}, m = "getNextJobToRun", n = {"$this$flatMap$iv", "it", "$i$f$flatMap", "$i$a$-flatMap-JobsDataSource$getNextJobToRun$2"}, s = {"L$0", "L$1", "I$0", "I$1"}, v = 1)
    static final class C11841 extends ContinuationImpl {
        int I$0;
        int I$1;
        Object L$0;
        Object L$1;
        int label;
        /* synthetic */ Object result;

        C11841(Continuation<? super C11841> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return JobsDataSource.this.getNextJobToRun(this);
        }
    }

    /* JADX INFO: renamed from: com.box.android.data.datasource.jobs.JobsDataSource$getNumberOfExecutingJobs$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: JobsDataSource.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.box.android.data.datasource.jobs.JobsDataSource", f = "JobsDataSource.kt", i = {0, 0, 0, 0, 0, 0}, l = {136}, m = "getNumberOfExecutingJobs", n = {"$this$flatMap$iv", "boxDatabase", "$i$f$flatMap", "$i$a$-flatMap-JobsDataSource$getNumberOfExecutingJobs$2", "$i$f$resultOf", "$i$a$-resultOf-JobsDataSource$getNumberOfExecutingJobs$2$1"}, s = {"L$0", "L$1", "I$0", "I$1", "I$2", "I$3"}, v = 1)
    static final class C11851 extends ContinuationImpl {
        int I$0;
        int I$1;
        int I$2;
        int I$3;
        Object L$0;
        Object L$1;
        int label;
        /* synthetic */ Object result;

        C11851(Continuation<? super C11851> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return JobsDataSource.this.getNumberOfExecutingJobs(this);
        }
    }

    /* JADX INFO: renamed from: com.box.android.data.datasource.jobs.JobsDataSource$getRootIDsWithRunningJobsCount$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: JobsDataSource.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.box.android.data.datasource.jobs.JobsDataSource", f = "JobsDataSource.kt", i = {0, 0, 0, 0, 0, 0}, l = {220}, m = "getRootIDsWithRunningJobsCount", n = {"$this$flatMap$iv", "boxDatabase", "$i$f$flatMap", "$i$a$-flatMap-JobsDataSource$getRootIDsWithRunningJobsCount$2", "$i$f$resultOf", "$i$a$-resultOf-JobsDataSource$getRootIDsWithRunningJobsCount$2$1"}, s = {"L$0", "L$1", "I$0", "I$1", "I$2", "I$3"}, v = 1)
    static final class C11861 extends ContinuationImpl {
        int I$0;
        int I$1;
        int I$2;
        int I$3;
        Object L$0;
        Object L$1;
        int label;
        /* synthetic */ Object result;

        C11861(Continuation<? super C11861> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return JobsDataSource.this.getRootIDsWithRunningJobsCount(this);
        }
    }

    /* JADX INFO: renamed from: com.box.android.data.datasource.jobs.JobsDataSource$getRunningInfo$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: JobsDataSource.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.box.android.data.datasource.jobs.JobsDataSource", f = "JobsDataSource.kt", i = {0, 0, 0, 0, 0, 0, 0}, l = {82}, m = "getRunningInfo", n = {JobWorker.JOB_ID_PARAM, "$this$flatMap$iv", "boxDatabase", "$i$f$flatMap", "$i$a$-flatMap-JobsDataSource$getRunningInfo$2", "$i$f$resultOf", "$i$a$-resultOf-JobsDataSource$getRunningInfo$2$1"}, s = {"L$0", "L$1", "L$2", "I$0", "I$1", "I$2", "I$3"}, v = 1)
    static final class C11871 extends ContinuationImpl {
        int I$0;
        int I$1;
        int I$2;
        int I$3;
        Object L$0;
        Object L$1;
        Object L$2;
        int label;
        /* synthetic */ Object result;

        C11871(Continuation<? super C11871> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return JobsDataSource.this.getRunningInfo(null, this);
        }
    }

    /* JADX INFO: renamed from: com.box.android.data.datasource.jobs.JobsDataSource$getSuccessorsAsList$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: JobsDataSource.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.box.android.data.datasource.jobs.JobsDataSource", f = "JobsDataSource.kt", i = {0, 0, 0, 0, 0, 0, 0}, l = {303}, m = "getSuccessorsAsList", n = {JobWorker.JOB_ID_PARAM, "$this$flatMap$iv", "boxDatabase", "$i$f$flatMap", "$i$a$-flatMap-JobsDataSource$getSuccessorsAsList$2", "$i$f$resultOf", "$i$a$-resultOf-JobsDataSource$getSuccessorsAsList$2$1"}, s = {"L$0", "L$1", "L$2", "I$0", "I$1", "I$2", "I$3"}, v = 1)
    static final class C11881 extends ContinuationImpl {
        int I$0;
        int I$1;
        int I$2;
        int I$3;
        Object L$0;
        Object L$1;
        Object L$2;
        int label;
        /* synthetic */ Object result;

        C11881(Continuation<? super C11881> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return JobsDataSource.this.getSuccessorsAsList(null, this);
        }
    }

    /* JADX INFO: renamed from: com.box.android.data.datasource.jobs.JobsDataSource$getTags$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: JobsDataSource.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.box.android.data.datasource.jobs.JobsDataSource", f = "JobsDataSource.kt", i = {0, 0, 0, 0, 0, 0, 0}, l = {351}, m = "getTags", n = {JobWorker.JOB_ID_PARAM, "$this$flatMap$iv", "boxDatabase", "$i$f$flatMap", "$i$a$-flatMap-JobsDataSource$getTags$2", "$i$f$resultOf", "$i$a$-resultOf-JobsDataSource$getTags$2$1"}, s = {"L$0", "L$1", "L$2", "I$0", "I$1", "I$2", "I$3"}, v = 1)
    static final class C11891 extends ContinuationImpl {
        int I$0;
        int I$1;
        int I$2;
        int I$3;
        Object L$0;
        Object L$1;
        Object L$2;
        int label;
        /* synthetic */ Object result;

        C11891(Continuation<? super C11891> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return JobsDataSource.this.getTags(null, this);
        }
    }

    /* JADX INFO: renamed from: com.box.android.data.datasource.jobs.JobsDataSource$getWaitingRootIDs$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: JobsDataSource.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.box.android.data.datasource.jobs.JobsDataSource", f = "JobsDataSource.kt", i = {0, 0, 0, 0, 0, 0}, l = {246}, m = "getWaitingRootIDs", n = {"$this$flatMap$iv", "boxDatabase", "$i$f$flatMap", "$i$a$-flatMap-JobsDataSource$getWaitingRootIDs$2", "$i$f$resultOf", "$i$a$-resultOf-JobsDataSource$getWaitingRootIDs$2$1"}, s = {"L$0", "L$1", "I$0", "I$1", "I$2", "I$3"}, v = 1)
    static final class C11901 extends ContinuationImpl {
        int I$0;
        int I$1;
        int I$2;
        int I$3;
        Object L$0;
        Object L$1;
        int label;
        /* synthetic */ Object result;

        C11901(Continuation<? super C11901> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return JobsDataSource.this.getWaitingRootIDs(this);
        }
    }

    /* JADX INFO: renamed from: com.box.android.data.datasource.jobs.JobsDataSource$insertJobIdToWorkIdRelation$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: JobsDataSource.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.box.android.data.datasource.jobs.JobsDataSource", f = "JobsDataSource.kt", i = {0, 0, 0, 0, 0, 0, 0}, l = {362}, m = "insertJobIdToWorkIdRelation", n = {"jobIdToWorkIdRelation", "$this$flatMap$iv", "boxDatabase", "$i$f$flatMap", "$i$a$-flatMap-JobsDataSource$insertJobIdToWorkIdRelation$2", "$i$f$resultOf", "$i$a$-resultOf-JobsDataSource$insertJobIdToWorkIdRelation$2$1"}, s = {"L$0", "L$1", "L$2", "I$0", "I$1", "I$2", "I$3"}, v = 1)
    static final class C11911 extends ContinuationImpl {
        int I$0;
        int I$1;
        int I$2;
        int I$3;
        Object L$0;
        Object L$1;
        Object L$2;
        int label;
        /* synthetic */ Object result;

        C11911(Continuation<? super C11911> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return JobsDataSource.this.insertJobIdToWorkIdRelation(null, this);
        }
    }

    /* JADX INFO: renamed from: com.box.android.data.datasource.jobs.JobsDataSource$insertOrUpdateJob$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: JobsDataSource.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.box.android.data.datasource.jobs.JobsDataSource", f = "JobsDataSource.kt", i = {0, 0, 0, 0, 0, 0, 0, 0, 0}, l = {26}, m = "insertOrUpdateJob", n = {"jobEntity", "dependingOn", "tags", "$this$flatMap$iv", "boxDatabase", "$i$f$flatMap", "$i$a$-flatMap-JobsDataSource$insertOrUpdateJob$2", "$i$f$resultOf", "$i$a$-resultOf-JobsDataSource$insertOrUpdateJob$2$1"}, s = {"L$0", "L$1", "L$2", "L$3", "L$4", "I$0", "I$1", "I$2", "I$3"}, v = 1)
    static final class C11921 extends ContinuationImpl {
        int I$0;
        int I$1;
        int I$2;
        int I$3;
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        Object L$4;
        int label;
        /* synthetic */ Object result;

        C11921(Continuation<? super C11921> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return JobsDataSource.this.insertOrUpdateJob(null, null, null, this);
        }
    }

    /* JADX INFO: renamed from: com.box.android.data.datasource.jobs.JobsDataSource$manualRetry$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: JobsDataSource.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.box.android.data.datasource.jobs.JobsDataSource", f = "JobsDataSource.kt", i = {0, 0, 0, 0, 0, 0, 0}, l = {112}, m = "manualRetry", n = {JobWorker.JOB_ID_PARAM, "$this$flatMap$iv", "boxDatabase", "$i$f$flatMap", "$i$a$-flatMap-JobsDataSource$manualRetry$2", "$i$f$resultOf", "$i$a$-resultOf-JobsDataSource$manualRetry$2$1"}, s = {"L$0", "L$1", "L$2", "I$0", "I$1", "I$2", "I$3"}, v = 1)
    static final class C11931 extends ContinuationImpl {
        int I$0;
        int I$1;
        int I$2;
        int I$3;
        Object L$0;
        Object L$1;
        Object L$2;
        int label;
        /* synthetic */ Object result;

        C11931(Continuation<? super C11931> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return JobsDataSource.this.manualRetry(null, this);
        }
    }

    /* JADX INFO: renamed from: com.box.android.data.datasource.jobs.JobsDataSource$nextRunnableJob$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: JobsDataSource.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.box.android.data.datasource.jobs.JobsDataSource", f = "JobsDataSource.kt", i = {1, 1, 2, 2, 2, 2, 3, 3, 3, 3, 3, 3, 4, 4, 4, 4, 4, 4, 5, 5, 5, 5, 5, 5, 5}, l = {Token.LAST_TOKEN, Context.VERSION_1_7, 176, 180, 181, 182}, m = "nextRunnableJob", n = {"runningCount", "rootsWithRunningDescendants", "runningCount", "rootsWithRunningDescendants", "waitingRoots", "starvedRunningRoots", "runningCount", "rootsWithRunningDescendants", "waitingRoots", "starvedRunningRoots", "childrenOfStarvedRoots", "now", "runningCount", "rootsWithRunningDescendants", "waitingRoots", "starvedRunningRoots", "childrenOfStarvedRoots", "now", "runningCount", "rootsWithRunningDescendants", "waitingRoots", "starvedRunningRoots", "childrenOfStarvedRoots", "now", "enqueuedJobs"}, s = {"L$0", "L$1", "L$0", "L$1", "L$2", "L$3", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6"}, v = 1)
    static final class C11941 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        Object L$4;
        Object L$5;
        Object L$6;
        int label;
        /* synthetic */ Object result;

        C11941(Continuation<? super C11941> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return JobsDataSource.this.nextRunnableJob(this);
        }
    }

    /* JADX INFO: renamed from: com.box.android.data.datasource.jobs.JobsDataSource$updateLogData$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: JobsDataSource.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.box.android.data.datasource.jobs.JobsDataSource", f = "JobsDataSource.kt", i = {0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1}, l = {390, 396}, m = "updateLogData", n = {JobWorker.JOB_ID_PARAM, "additionalData", "$this$flatMap$iv", "boxDatabase", "$i$f$flatMap", "$i$a$-flatMap-JobsDataSource$updateLogData$2", JobWorker.JOB_ID_PARAM, "additionalData", "$this$flatMap$iv", "boxDatabase", "$this$map$iv", "currLogData", "newLogData", "$i$f$flatMap", "$i$a$-flatMap-JobsDataSource$updateLogData$2", "$i$f$map", "$i$a$-map-JobsDataSource$updateLogData$2$1"}, s = {"L$0", "L$1", "L$2", "L$3", "I$0", "I$1", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "I$0", "I$1", "I$2", "I$3"}, v = 1)
    static final class C11951 extends ContinuationImpl {
        int I$0;
        int I$1;
        int I$2;
        int I$3;
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        Object L$4;
        Object L$5;
        Object L$6;
        int label;
        /* synthetic */ Object result;

        C11951(Continuation<? super C11951> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return JobsDataSource.this.updateLogData(null, null, this);
        }
    }

    /* JADX INFO: renamed from: com.box.android.data.datasource.jobs.JobsDataSource$updateRunningInfo$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: JobsDataSource.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.box.android.data.datasource.jobs.JobsDataSource", f = "JobsDataSource.kt", i = {0, 0, 0, 0, 0, 0, 0, 0}, l = {91}, m = "updateRunningInfo", n = {JobWorker.JOB_ID_PARAM, "runningInfo", "$this$flatMap$iv", "boxDatabase", "$i$f$flatMap", "$i$a$-flatMap-JobsDataSource$updateRunningInfo$2", "$i$f$resultOf", "$i$a$-resultOf-JobsDataSource$updateRunningInfo$2$1"}, s = {"L$0", "L$1", "L$2", "L$3", "I$0", "I$1", "I$2", "I$3"}, v = 1)
    static final class C11961 extends ContinuationImpl {
        int I$0;
        int I$1;
        int I$2;
        int I$3;
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        int label;
        /* synthetic */ Object result;

        C11961(Continuation<? super C11961> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return JobsDataSource.this.updateRunningInfo(null, null, this);
        }
    }

    /* JADX INFO: renamed from: com.box.android.data.datasource.jobs.JobsDataSource$updateStatusOfJob$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: JobsDataSource.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.box.android.data.datasource.jobs.JobsDataSource", f = "JobsDataSource.kt", i = {0, 0, 0, 0, 0, 0, 0, 0, 0}, l = {64}, m = "updateStatusOfJob", n = {JobWorker.JOB_ID_PARAM, "newStatus", "error", "$this$flatMap$iv", "boxDatabase", "$i$f$flatMap", "$i$a$-flatMap-JobsDataSource$updateStatusOfJob$2", "$i$f$resultOf", "$i$a$-resultOf-JobsDataSource$updateStatusOfJob$2$1"}, s = {"L$0", "L$1", "L$2", "L$3", "L$4", "I$0", "I$1", "I$2", "I$3"}, v = 1)
    static final class C11971 extends ContinuationImpl {
        int I$0;
        int I$1;
        int I$2;
        int I$3;
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        Object L$4;
        int label;
        /* synthetic */ Object result;

        C11971(Continuation<? super C11971> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return JobsDataSource.this.updateStatusOfJob(null, null, null, this);
        }
    }

    /* JADX INFO: renamed from: com.box.android.data.datasource.jobs.JobsDataSource$withTransaction$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: JobsDataSource.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.box.android.data.datasource.jobs.JobsDataSource", f = "JobsDataSource.kt", i = {0, 0, 0, 0, 0}, l = {315}, m = "withTransaction", n = {"block", "$this$flatMap$iv", "it", "$i$f$flatMap", "$i$a$-flatMap-JobsDataSource$withTransaction$2"}, s = {"L$0", "L$1", "L$2", "I$0", "I$1"}, v = 1)
    static final class C11981 extends ContinuationImpl {
        int I$0;
        int I$1;
        Object L$0;
        Object L$1;
        Object L$2;
        int label;
        /* synthetic */ Object result;

        C11981(Continuation<? super C11981> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return JobsDataSource.this.withTransaction(null, this);
        }
    }

    @Inject
    public JobsDataSource(UserData userData) {
        Intrinsics.checkNotNullParameter(userData, "userData");
        this.userData = userData;
    }

    /* JADX WARN: Code duplicated, block: B:33:0x00c2  */
    /* JADX WARN: Code duplicated, block: B:35:0x00c6  */
    /* JADX WARN: Code duplicated, block: B:37:0x00ed  */
    /* JADX WARN: Code duplicated, block: B:43:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    public final Object insertOrUpdateJob(JobEntity jobEntity, Set<JobId> set, Set<String> set2, Continuation<? super Result<Unit, CacheError.SaveError>> continuation) {
        C11921 c11921;
        Result.Error error;
        Result<BoxDatabase, CacheError> boxDatabase;
        if (continuation instanceof C11921) {
            c11921 = (C11921) continuation;
            if ((c11921.label & Integer.MIN_VALUE) != 0) {
                c11921.label -= Integer.MIN_VALUE;
            } else {
                c11921 = new C11921(continuation);
            }
        } else {
            c11921 = new C11921(continuation);
        }
        Object obj = c11921.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = c11921.label;
        try {
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                boxDatabase = this.userData.getBoxDatabase();
                if (boxDatabase instanceof Result.Success) {
                    BoxDatabase boxDatabase2 = (BoxDatabase) ((Result.Success) boxDatabase).getValue();
                    JobsDataSource$insertOrUpdateJob$2$1$1 jobsDataSource$insertOrUpdateJob$2$1$1 = new JobsDataSource$insertOrUpdateJob$2$1$1(boxDatabase2, jobEntity, set2, set, null);
                    c11921.L$0 = SpillingKt.nullOutSpilledVariable(jobEntity);
                    c11921.L$1 = SpillingKt.nullOutSpilledVariable(set);
                    c11921.L$2 = SpillingKt.nullOutSpilledVariable(set2);
                    c11921.L$3 = SpillingKt.nullOutSpilledVariable(boxDatabase);
                    c11921.L$4 = SpillingKt.nullOutSpilledVariable(boxDatabase2);
                    c11921.I$0 = 0;
                    c11921.I$1 = 0;
                    c11921.I$2 = 0;
                    c11921.I$3 = 0;
                    c11921.label = 1;
                    if (RoomDatabaseKt.withTransaction(boxDatabase2, jobsDataSource$insertOrUpdateJob$2$1$1, c11921) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                } else if (!(boxDatabase instanceof Result.Error)) {
                    throw new NoWhenBranchMatchedException();
                }
                if (boxDatabase instanceof Result.Success) {
                    return boxDatabase;
                }
                if (boxDatabase instanceof Result.Error) {
                    BoxLogUtils.e(ExtensionsKt.getTAG(this), "Error while enqueuing a job: " + ((Result.Error) boxDatabase).getValue());
                    return new Result.Error(CacheError.SaveError.INSTANCE);
                }
                throw new NoWhenBranchMatchedException();
            }
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            int i2 = c11921.I$3;
            int i3 = c11921.I$2;
            int i4 = c11921.I$1;
            int i5 = c11921.I$0;
            ResultKt.throwOnFailure(obj);
            error = new Result.Success(Unit.INSTANCE);
        } catch (Exception e) {
            error = new Result.Error(e);
        }
        boxDatabase = error;
        if (boxDatabase instanceof Result.Success) {
            return boxDatabase;
        }
        if (boxDatabase instanceof Result.Error) {
            BoxLogUtils.e(ExtensionsKt.getTAG(this), "Error while enqueuing a job: " + ((Result.Error) boxDatabase).getValue());
            return new Result.Error(CacheError.SaveError.INSTANCE);
        }
        throw new NoWhenBranchMatchedException();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ Object insertOrUpdateJob$default(JobsDataSource jobsDataSource, JobEntity jobEntity, Set set, Set set2, Continuation continuation, int i, Object obj) {
        if ((i & 2) != 0) {
            set = SetsKt.emptySet();
        }
        if ((i & 4) != 0) {
            set2 = SetsKt.emptySet();
        }
        return jobsDataSource.insertOrUpdateJob(jobEntity, set, set2, continuation);
    }

    /* JADX WARN: Code duplicated, block: B:32:0x00a1  */
    /* JADX WARN: Code duplicated, block: B:34:0x00a5  */
    /* JADX WARN: Code duplicated, block: B:36:0x00cc  */
    /* JADX WARN: Code duplicated, block: B:42:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    public final Object deleteJob(JobId jobId, Continuation<? super Result<Unit, ? extends CacheError>> continuation) {
        C11711 c11711;
        Result.Error error;
        if (continuation instanceof C11711) {
            c11711 = (C11711) continuation;
            if ((c11711.label & Integer.MIN_VALUE) != 0) {
                c11711.label -= Integer.MIN_VALUE;
            } else {
                c11711 = new C11711(continuation);
            }
        } else {
            c11711 = new C11711(continuation);
        }
        Object obj = c11711.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = c11711.label;
        try {
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                error = this.userData.getBoxDatabase();
                if (error instanceof Result.Success) {
                    BoxDatabase boxDatabase = (BoxDatabase) ((Result.Success) error).getValue();
                    JobsDao jobsDao = boxDatabase.jobsDao();
                    c11711.L$0 = SpillingKt.nullOutSpilledVariable(jobId);
                    c11711.L$1 = SpillingKt.nullOutSpilledVariable(error);
                    c11711.L$2 = SpillingKt.nullOutSpilledVariable(boxDatabase);
                    c11711.I$0 = 0;
                    c11711.I$1 = 0;
                    c11711.I$2 = 0;
                    c11711.I$3 = 0;
                    c11711.label = 1;
                    if (jobsDao.deleteJob(jobId, c11711) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                } else if (!(error instanceof Result.Error)) {
                    throw new NoWhenBranchMatchedException();
                }
                if (error instanceof Result.Success) {
                    return error;
                }
                if (error instanceof Result.Error) {
                    BoxLogUtils.e(ExtensionsKt.getTAG(this), "Error while dequeuing a job: " + ((Result.Error) error).getValue());
                    return new Result.Error(CacheError.DeleteError.INSTANCE);
                }
                throw new NoWhenBranchMatchedException();
            }
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            int i2 = c11711.I$3;
            int i3 = c11711.I$2;
            int i4 = c11711.I$1;
            int i5 = c11711.I$0;
            ResultKt.throwOnFailure(obj);
            error = new Result.Success(Unit.INSTANCE);
        } catch (Exception e) {
            error = new Result.Error(e);
        }
        if (error instanceof Result.Success) {
            return error;
        }
        if (error instanceof Result.Error) {
            BoxLogUtils.e(ExtensionsKt.getTAG(this), "Error while dequeuing a job: " + ((Result.Error) error).getValue());
            return new Result.Error(CacheError.DeleteError.INSTANCE);
        }
        throw new NoWhenBranchMatchedException();
    }

    public static /* synthetic */ Object updateStatusOfJob$default(JobsDataSource jobsDataSource, JobId jobId, JobStatus jobStatus, DomainError domainError, Continuation continuation, int i, Object obj) {
        if ((i & 4) != 0) {
            domainError = null;
        }
        return jobsDataSource.updateStatusOfJob(jobId, jobStatus, domainError, continuation);
    }

    /* JADX WARN: Code duplicated, block: B:33:0x00b6  */
    /* JADX WARN: Code duplicated, block: B:35:0x00ba  */
    /* JADX WARN: Code duplicated, block: B:37:0x00e1  */
    /* JADX WARN: Code duplicated, block: B:43:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    public final Object updateStatusOfJob(JobId jobId, JobStatus jobStatus, DomainError domainError, Continuation<? super Result<Unit, ? extends CacheError>> continuation) {
        C11971 c11971;
        Result.Error error;
        Result<BoxDatabase, CacheError> boxDatabase;
        if (continuation instanceof C11971) {
            c11971 = (C11971) continuation;
            if ((c11971.label & Integer.MIN_VALUE) != 0) {
                c11971.label -= Integer.MIN_VALUE;
            } else {
                c11971 = new C11971(continuation);
            }
        } else {
            c11971 = new C11971(continuation);
        }
        Object obj = c11971.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = c11971.label;
        try {
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                boxDatabase = this.userData.getBoxDatabase();
                if (boxDatabase instanceof Result.Success) {
                    BoxDatabase boxDatabase2 = (BoxDatabase) ((Result.Success) boxDatabase).getValue();
                    JobsDao jobsDao = boxDatabase2.jobsDao();
                    c11971.L$0 = SpillingKt.nullOutSpilledVariable(jobId);
                    c11971.L$1 = SpillingKt.nullOutSpilledVariable(jobStatus);
                    c11971.L$2 = SpillingKt.nullOutSpilledVariable(domainError);
                    c11971.L$3 = SpillingKt.nullOutSpilledVariable(boxDatabase);
                    c11971.L$4 = SpillingKt.nullOutSpilledVariable(boxDatabase2);
                    c11971.I$0 = 0;
                    c11971.I$1 = 0;
                    c11971.I$2 = 0;
                    c11971.I$3 = 0;
                    c11971.label = 1;
                    if (jobsDao.updateStatusOfJob(jobId, jobStatus, domainError, c11971) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                } else if (!(boxDatabase instanceof Result.Error)) {
                    throw new NoWhenBranchMatchedException();
                }
                if (boxDatabase instanceof Result.Success) {
                    return boxDatabase;
                }
                if (boxDatabase instanceof Result.Error) {
                    BoxLogUtils.e(ExtensionsKt.getTAG(this), "Error while updating status of job : " + ((Result.Error) boxDatabase).getValue());
                    return new Result.Error(CacheError.SaveError.INSTANCE);
                }
                throw new NoWhenBranchMatchedException();
            }
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            int i2 = c11971.I$3;
            int i3 = c11971.I$2;
            int i4 = c11971.I$1;
            int i5 = c11971.I$0;
            ResultKt.throwOnFailure(obj);
            error = new Result.Success(Unit.INSTANCE);
        } catch (Exception e) {
            error = new Result.Error(e);
        }
        boxDatabase = error;
        if (boxDatabase instanceof Result.Success) {
            return boxDatabase;
        }
        if (boxDatabase instanceof Result.Error) {
            BoxLogUtils.e(ExtensionsKt.getTAG(this), "Error while updating status of job : " + ((Result.Error) boxDatabase).getValue());
            return new Result.Error(CacheError.SaveError.INSTANCE);
        }
        throw new NoWhenBranchMatchedException();
    }

    /* JADX WARN: Code duplicated, block: B:32:0x00a9  */
    /* JADX WARN: Code duplicated, block: B:34:0x00ad  */
    /* JADX WARN: Code duplicated, block: B:36:0x00d4  */
    /* JADX WARN: Code duplicated, block: B:42:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    public final Object getAutoRetryCountOfJob(JobId jobId, Continuation<? super Result<Integer, ? extends CacheError>> continuation) {
        C11751 c11751;
        Result.Error error;
        if (continuation instanceof C11751) {
            c11751 = (C11751) continuation;
            if ((c11751.label & Integer.MIN_VALUE) != 0) {
                c11751.label -= Integer.MIN_VALUE;
            } else {
                c11751 = new C11751(continuation);
            }
        } else {
            c11751 = new C11751(continuation);
        }
        Object autoRetryCount = c11751.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = c11751.label;
        try {
            if (i == 0) {
                ResultKt.throwOnFailure(autoRetryCount);
                error = this.userData.getBoxDatabase();
                if (error instanceof Result.Success) {
                    BoxDatabase boxDatabase = (BoxDatabase) ((Result.Success) error).getValue();
                    JobsDao jobsDao = boxDatabase.jobsDao();
                    c11751.L$0 = SpillingKt.nullOutSpilledVariable(jobId);
                    c11751.L$1 = SpillingKt.nullOutSpilledVariable(error);
                    c11751.L$2 = SpillingKt.nullOutSpilledVariable(boxDatabase);
                    c11751.I$0 = 0;
                    c11751.I$1 = 0;
                    c11751.I$2 = 0;
                    c11751.I$3 = 0;
                    c11751.label = 1;
                    autoRetryCount = jobsDao.getAutoRetryCount(jobId, c11751);
                    if (autoRetryCount == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                } else if (!(error instanceof Result.Error)) {
                    throw new NoWhenBranchMatchedException();
                }
                if (error instanceof Result.Success) {
                    return error;
                }
                if (error instanceof Result.Error) {
                    BoxLogUtils.e(ExtensionsKt.getTAG(this), "Error while fetching retry count of job " + ((Result.Error) error).getValue());
                    return new Result.Error(CacheError.ReadError.INSTANCE);
                }
                throw new NoWhenBranchMatchedException();
            }
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            int i2 = c11751.I$3;
            int i3 = c11751.I$2;
            int i4 = c11751.I$1;
            int i5 = c11751.I$0;
            ResultKt.throwOnFailure(autoRetryCount);
            error = new Result.Success(Boxing.boxInt(((Number) autoRetryCount).intValue()));
        } catch (Exception e) {
            error = new Result.Error(e);
        }
        if (error instanceof Result.Success) {
            return error;
        }
        if (error instanceof Result.Error) {
            BoxLogUtils.e(ExtensionsKt.getTAG(this), "Error while fetching retry count of job " + ((Result.Error) error).getValue());
            return new Result.Error(CacheError.ReadError.INSTANCE);
        }
        throw new NoWhenBranchMatchedException();
    }

    /* JADX WARN: Code duplicated, block: B:32:0x00a2  */
    /* JADX WARN: Code duplicated, block: B:34:0x00a6  */
    /* JADX WARN: Code duplicated, block: B:36:0x00cd  */
    /* JADX WARN: Code duplicated, block: B:42:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    public final Object getRunningInfo(JobId jobId, Continuation<? super Result<byte[], ? extends CacheError>> continuation) {
        C11871 c11871;
        Result.Error error;
        if (continuation instanceof C11871) {
            c11871 = (C11871) continuation;
            if ((c11871.label & Integer.MIN_VALUE) != 0) {
                c11871.label -= Integer.MIN_VALUE;
            } else {
                c11871 = new C11871(continuation);
            }
        } else {
            c11871 = new C11871(continuation);
        }
        Object jobRunningInfo = c11871.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = c11871.label;
        try {
            if (i == 0) {
                ResultKt.throwOnFailure(jobRunningInfo);
                error = this.userData.getBoxDatabase();
                if (error instanceof Result.Success) {
                    BoxDatabase boxDatabase = (BoxDatabase) ((Result.Success) error).getValue();
                    JobsDao jobsDao = boxDatabase.jobsDao();
                    c11871.L$0 = SpillingKt.nullOutSpilledVariable(jobId);
                    c11871.L$1 = SpillingKt.nullOutSpilledVariable(error);
                    c11871.L$2 = SpillingKt.nullOutSpilledVariable(boxDatabase);
                    c11871.I$0 = 0;
                    c11871.I$1 = 0;
                    c11871.I$2 = 0;
                    c11871.I$3 = 0;
                    c11871.label = 1;
                    jobRunningInfo = jobsDao.getJobRunningInfo(jobId, c11871);
                    if (jobRunningInfo == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                } else if (!(error instanceof Result.Error)) {
                    throw new NoWhenBranchMatchedException();
                }
                if (error instanceof Result.Success) {
                    return error;
                }
                if (error instanceof Result.Error) {
                    BoxLogUtils.e(ExtensionsKt.getTAG(this), "Error while fetching runningInfo of job " + ((Result.Error) error).getValue());
                    return new Result.Error(CacheError.ReadError.INSTANCE);
                }
                throw new NoWhenBranchMatchedException();
            }
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            int i2 = c11871.I$3;
            int i3 = c11871.I$2;
            int i4 = c11871.I$1;
            int i5 = c11871.I$0;
            ResultKt.throwOnFailure(jobRunningInfo);
            error = new Result.Success((byte[]) jobRunningInfo);
        } catch (Exception e) {
            error = new Result.Error(e);
        }
        if (error instanceof Result.Success) {
            return error;
        }
        if (error instanceof Result.Error) {
            BoxLogUtils.e(ExtensionsKt.getTAG(this), "Error while fetching runningInfo of job " + ((Result.Error) error).getValue());
            return new Result.Error(CacheError.ReadError.INSTANCE);
        }
        throw new NoWhenBranchMatchedException();
    }

    /* JADX WARN: Code duplicated, block: B:33:0x00ac  */
    /* JADX WARN: Code duplicated, block: B:35:0x00b0  */
    /* JADX WARN: Code duplicated, block: B:37:0x00d7  */
    /* JADX WARN: Code duplicated, block: B:43:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    public final Object updateRunningInfo(JobId jobId, byte[] bArr, Continuation<? super Result<Unit, ? extends CacheError>> continuation) {
        C11961 c11961;
        Result.Error error;
        Result<BoxDatabase, CacheError> boxDatabase;
        if (continuation instanceof C11961) {
            c11961 = (C11961) continuation;
            if ((c11961.label & Integer.MIN_VALUE) != 0) {
                c11961.label -= Integer.MIN_VALUE;
            } else {
                c11961 = new C11961(continuation);
            }
        } else {
            c11961 = new C11961(continuation);
        }
        Object obj = c11961.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = c11961.label;
        try {
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                boxDatabase = this.userData.getBoxDatabase();
                if (boxDatabase instanceof Result.Success) {
                    BoxDatabase boxDatabase2 = (BoxDatabase) ((Result.Success) boxDatabase).getValue();
                    JobsDao jobsDao = boxDatabase2.jobsDao();
                    c11961.L$0 = SpillingKt.nullOutSpilledVariable(jobId);
                    c11961.L$1 = SpillingKt.nullOutSpilledVariable(bArr);
                    c11961.L$2 = SpillingKt.nullOutSpilledVariable(boxDatabase);
                    c11961.L$3 = SpillingKt.nullOutSpilledVariable(boxDatabase2);
                    c11961.I$0 = 0;
                    c11961.I$1 = 0;
                    c11961.I$2 = 0;
                    c11961.I$3 = 0;
                    c11961.label = 1;
                    if (jobsDao.updateRunningInfoOfJob(jobId, bArr, c11961) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                } else if (!(boxDatabase instanceof Result.Error)) {
                    throw new NoWhenBranchMatchedException();
                }
                if (boxDatabase instanceof Result.Success) {
                    return boxDatabase;
                }
                if (boxDatabase instanceof Result.Error) {
                    BoxLogUtils.e(ExtensionsKt.getTAG(this), "Error while updating runningInfo of job : " + ((Result.Error) boxDatabase).getValue());
                    return new Result.Error(CacheError.SaveError.INSTANCE);
                }
                throw new NoWhenBranchMatchedException();
            }
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            int i2 = c11961.I$3;
            int i3 = c11961.I$2;
            int i4 = c11961.I$1;
            int i5 = c11961.I$0;
            ResultKt.throwOnFailure(obj);
            error = new Result.Success(Unit.INSTANCE);
        } catch (Exception e) {
            error = new Result.Error(e);
        }
        boxDatabase = error;
        if (boxDatabase instanceof Result.Success) {
            return boxDatabase;
        }
        if (boxDatabase instanceof Result.Error) {
            BoxLogUtils.e(ExtensionsKt.getTAG(this), "Error while updating runningInfo of job : " + ((Result.Error) boxDatabase).getValue());
            return new Result.Error(CacheError.SaveError.INSTANCE);
        }
        throw new NoWhenBranchMatchedException();
    }

    /* JADX WARN: Code duplicated, block: B:32:0x00a9  */
    /* JADX WARN: Code duplicated, block: B:34:0x00ad  */
    /* JADX WARN: Code duplicated, block: B:36:0x00d4  */
    /* JADX WARN: Code duplicated, block: B:42:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    public final Object getManualRetryCountOfJob(JobId jobId, Continuation<? super Result<Integer, ? extends CacheError>> continuation) {
        C11831 c11831;
        Result.Error error;
        if (continuation instanceof C11831) {
            c11831 = (C11831) continuation;
            if ((c11831.label & Integer.MIN_VALUE) != 0) {
                c11831.label -= Integer.MIN_VALUE;
            } else {
                c11831 = new C11831(continuation);
            }
        } else {
            c11831 = new C11831(continuation);
        }
        Object manualRetryCount = c11831.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = c11831.label;
        try {
            if (i == 0) {
                ResultKt.throwOnFailure(manualRetryCount);
                error = this.userData.getBoxDatabase();
                if (error instanceof Result.Success) {
                    BoxDatabase boxDatabase = (BoxDatabase) ((Result.Success) error).getValue();
                    JobsDao jobsDao = boxDatabase.jobsDao();
                    c11831.L$0 = SpillingKt.nullOutSpilledVariable(jobId);
                    c11831.L$1 = SpillingKt.nullOutSpilledVariable(error);
                    c11831.L$2 = SpillingKt.nullOutSpilledVariable(boxDatabase);
                    c11831.I$0 = 0;
                    c11831.I$1 = 0;
                    c11831.I$2 = 0;
                    c11831.I$3 = 0;
                    c11831.label = 1;
                    manualRetryCount = jobsDao.getManualRetryCount(jobId, c11831);
                    if (manualRetryCount == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                } else if (!(error instanceof Result.Error)) {
                    throw new NoWhenBranchMatchedException();
                }
                if (error instanceof Result.Success) {
                    return error;
                }
                if (error instanceof Result.Error) {
                    BoxLogUtils.e(ExtensionsKt.getTAG(this), "Error while fetching retry count of job " + ((Result.Error) error).getValue());
                    return new Result.Error(CacheError.ReadError.INSTANCE);
                }
                throw new NoWhenBranchMatchedException();
            }
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            int i2 = c11831.I$3;
            int i3 = c11831.I$2;
            int i4 = c11831.I$1;
            int i5 = c11831.I$0;
            ResultKt.throwOnFailure(manualRetryCount);
            error = new Result.Success(Boxing.boxInt(((Number) manualRetryCount).intValue()));
        } catch (Exception e) {
            error = new Result.Error(e);
        }
        if (error instanceof Result.Success) {
            return error;
        }
        if (error instanceof Result.Error) {
            BoxLogUtils.e(ExtensionsKt.getTAG(this), "Error while fetching retry count of job " + ((Result.Error) error).getValue());
            return new Result.Error(CacheError.ReadError.INSTANCE);
        }
        throw new NoWhenBranchMatchedException();
    }

    /* JADX WARN: Code duplicated, block: B:32:0x00a1  */
    /* JADX WARN: Code duplicated, block: B:34:0x00a5  */
    /* JADX WARN: Code duplicated, block: B:36:0x00cc  */
    /* JADX WARN: Code duplicated, block: B:42:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    public final Object manualRetry(JobId jobId, Continuation<? super Result<Unit, ? extends CacheError>> continuation) {
        C11931 c11931;
        Result.Error error;
        if (continuation instanceof C11931) {
            c11931 = (C11931) continuation;
            if ((c11931.label & Integer.MIN_VALUE) != 0) {
                c11931.label -= Integer.MIN_VALUE;
            } else {
                c11931 = new C11931(continuation);
            }
        } else {
            c11931 = new C11931(continuation);
        }
        Object obj = c11931.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = c11931.label;
        try {
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                error = this.userData.getBoxDatabase();
                if (error instanceof Result.Success) {
                    BoxDatabase boxDatabase = (BoxDatabase) ((Result.Success) error).getValue();
                    JobsDao jobsDao = boxDatabase.jobsDao();
                    c11931.L$0 = SpillingKt.nullOutSpilledVariable(jobId);
                    c11931.L$1 = SpillingKt.nullOutSpilledVariable(error);
                    c11931.L$2 = SpillingKt.nullOutSpilledVariable(boxDatabase);
                    c11931.I$0 = 0;
                    c11931.I$1 = 0;
                    c11931.I$2 = 0;
                    c11931.I$3 = 0;
                    c11931.label = 1;
                    if (jobsDao.increaseManualRetryInformation(jobId, c11931) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                } else if (!(error instanceof Result.Error)) {
                    throw new NoWhenBranchMatchedException();
                }
                if (error instanceof Result.Success) {
                    return error;
                }
                if (error instanceof Result.Error) {
                    BoxLogUtils.e(ExtensionsKt.getTAG(this), "Error while updating retry information of job: " + ((Result.Error) error).getValue());
                    return new Result.Error(CacheError.SaveError.INSTANCE);
                }
                throw new NoWhenBranchMatchedException();
            }
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            int i2 = c11931.I$3;
            int i3 = c11931.I$2;
            int i4 = c11931.I$1;
            int i5 = c11931.I$0;
            ResultKt.throwOnFailure(obj);
            error = new Result.Success(Unit.INSTANCE);
        } catch (Exception e) {
            error = new Result.Error(e);
        }
        if (error instanceof Result.Success) {
            return error;
        }
        if (error instanceof Result.Error) {
            BoxLogUtils.e(ExtensionsKt.getTAG(this), "Error while updating retry information of job: " + ((Result.Error) error).getValue());
            return new Result.Error(CacheError.SaveError.INSTANCE);
        }
        throw new NoWhenBranchMatchedException();
    }

    /* JADX WARN: Code duplicated, block: B:32:0x00a1  */
    /* JADX WARN: Code duplicated, block: B:34:0x00a5  */
    /* JADX WARN: Code duplicated, block: B:36:0x00cc  */
    /* JADX WARN: Code duplicated, block: B:42:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    public final Object automaticRetry(JobId jobId, Continuation<? super Result<Unit, ? extends CacheError>> continuation) {
        AnonymousClass1 anonymousClass1;
        Result.Error error;
        if (continuation instanceof AnonymousClass1) {
            anonymousClass1 = (AnonymousClass1) continuation;
            if ((anonymousClass1.label & Integer.MIN_VALUE) != 0) {
                anonymousClass1.label -= Integer.MIN_VALUE;
            } else {
                anonymousClass1 = new AnonymousClass1(continuation);
            }
        } else {
            anonymousClass1 = new AnonymousClass1(continuation);
        }
        Object obj = anonymousClass1.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = anonymousClass1.label;
        try {
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                error = this.userData.getBoxDatabase();
                if (error instanceof Result.Success) {
                    BoxDatabase boxDatabase = (BoxDatabase) ((Result.Success) error).getValue();
                    JobsDao jobsDao = boxDatabase.jobsDao();
                    anonymousClass1.L$0 = SpillingKt.nullOutSpilledVariable(jobId);
                    anonymousClass1.L$1 = SpillingKt.nullOutSpilledVariable(error);
                    anonymousClass1.L$2 = SpillingKt.nullOutSpilledVariable(boxDatabase);
                    anonymousClass1.I$0 = 0;
                    anonymousClass1.I$1 = 0;
                    anonymousClass1.I$2 = 0;
                    anonymousClass1.I$3 = 0;
                    anonymousClass1.label = 1;
                    if (jobsDao.increaseAutoRetryInformation(jobId, anonymousClass1) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                } else if (!(error instanceof Result.Error)) {
                    throw new NoWhenBranchMatchedException();
                }
                if (error instanceof Result.Success) {
                    return error;
                }
                if (error instanceof Result.Error) {
                    BoxLogUtils.e(ExtensionsKt.getTAG(this), "Error while updating retry information of job: " + ((Result.Error) error).getValue());
                    return new Result.Error(CacheError.SaveError.INSTANCE);
                }
                throw new NoWhenBranchMatchedException();
            }
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            int i2 = anonymousClass1.I$3;
            int i3 = anonymousClass1.I$2;
            int i4 = anonymousClass1.I$1;
            int i5 = anonymousClass1.I$0;
            ResultKt.throwOnFailure(obj);
            error = new Result.Success(Unit.INSTANCE);
        } catch (Exception e) {
            error = new Result.Error(e);
        }
        if (error instanceof Result.Success) {
            return error;
        }
        if (error instanceof Result.Error) {
            BoxLogUtils.e(ExtensionsKt.getTAG(this), "Error while updating retry information of job: " + ((Result.Error) error).getValue());
            return new Result.Error(CacheError.SaveError.INSTANCE);
        }
        throw new NoWhenBranchMatchedException();
    }

    /* JADX WARN: Code duplicated, block: B:33:0x00a0  */
    /* JADX WARN: Code duplicated, block: B:35:0x00a4  */
    /* JADX WARN: Code duplicated, block: B:37:0x00cb  */
    /* JADX WARN: Code duplicated, block: B:43:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    public final Object getNumberOfExecutingJobs(Continuation<? super Result<Integer, ? extends CacheError>> continuation) {
        C11851 c11851;
        Result.Error error;
        Result<BoxDatabase, CacheError> boxDatabase;
        if (continuation instanceof C11851) {
            c11851 = (C11851) continuation;
            if ((c11851.label & Integer.MIN_VALUE) != 0) {
                c11851.label -= Integer.MIN_VALUE;
            } else {
                c11851 = new C11851(continuation);
            }
        } else {
            c11851 = new C11851(continuation);
        }
        Object objNumberOfExecutingJobs = c11851.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = c11851.label;
        try {
            if (i == 0) {
                ResultKt.throwOnFailure(objNumberOfExecutingJobs);
                boxDatabase = this.userData.getBoxDatabase();
                if (boxDatabase instanceof Result.Success) {
                    BoxDatabase boxDatabase2 = (BoxDatabase) ((Result.Success) boxDatabase).getValue();
                    JobsDao jobsDao = boxDatabase2.jobsDao();
                    c11851.L$0 = SpillingKt.nullOutSpilledVariable(boxDatabase);
                    c11851.L$1 = SpillingKt.nullOutSpilledVariable(boxDatabase2);
                    c11851.I$0 = 0;
                    c11851.I$1 = 0;
                    c11851.I$2 = 0;
                    c11851.I$3 = 0;
                    c11851.label = 1;
                    objNumberOfExecutingJobs = jobsDao.numberOfExecutingJobs(c11851);
                    if (objNumberOfExecutingJobs == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                } else if (!(boxDatabase instanceof Result.Error)) {
                    throw new NoWhenBranchMatchedException();
                }
                if (boxDatabase instanceof Result.Success) {
                    return boxDatabase;
                }
                if (boxDatabase instanceof Result.Error) {
                    BoxLogUtils.e(ExtensionsKt.getTAG(this), "Error while fetching count of executing jobs " + ((Result.Error) boxDatabase).getValue());
                    return new Result.Error(CacheError.ReadError.INSTANCE);
                }
                throw new NoWhenBranchMatchedException();
            }
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            int i2 = c11851.I$3;
            int i3 = c11851.I$2;
            int i4 = c11851.I$1;
            int i5 = c11851.I$0;
            ResultKt.throwOnFailure(objNumberOfExecutingJobs);
            error = new Result.Success(Boxing.boxInt(((Number) objNumberOfExecutingJobs).intValue()));
        } catch (Exception e) {
            error = new Result.Error(e);
        }
        boxDatabase = error;
        if (boxDatabase instanceof Result.Success) {
            return boxDatabase;
        }
        if (boxDatabase instanceof Result.Error) {
            BoxLogUtils.e(ExtensionsKt.getTAG(this), "Error while fetching count of executing jobs " + ((Result.Error) boxDatabase).getValue());
            return new Result.Error(CacheError.ReadError.INSTANCE);
        }
        throw new NoWhenBranchMatchedException();
    }

    /* JADX WARN: Code duplicated, block: B:24:0x0079 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:25:0x007a  */
    /* JADX WARN: Code duplicated, block: B:27:0x007e  */
    /* JADX WARN: Code duplicated, block: B:29:0x00a6  */
    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    public final Object getNextJobToRun(Continuation<? super Result<JobEntity, ? extends CacheError>> continuation) {
        C11841 c11841;
        Result<BoxDatabase, CacheError> boxDatabase;
        if (continuation instanceof C11841) {
            c11841 = (C11841) continuation;
            if ((c11841.label & Integer.MIN_VALUE) != 0) {
                c11841.label -= Integer.MIN_VALUE;
            } else {
                c11841 = new C11841(continuation);
            }
        } else {
            c11841 = new C11841(continuation);
        }
        Object objNextRunnableJob = c11841.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = c11841.label;
        if (i == 0) {
            ResultKt.throwOnFailure(objNextRunnableJob);
            boxDatabase = this.userData.getBoxDatabase();
            if (boxDatabase instanceof Result.Success) {
                BoxDatabase boxDatabase2 = (BoxDatabase) ((Result.Success) boxDatabase).getValue();
                c11841.L$0 = SpillingKt.nullOutSpilledVariable(boxDatabase);
                c11841.L$1 = SpillingKt.nullOutSpilledVariable(boxDatabase2);
                c11841.I$0 = 0;
                c11841.I$1 = 0;
                c11841.label = 1;
                objNextRunnableJob = nextRunnableJob(c11841);
                if (objNextRunnableJob == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else if (!(boxDatabase instanceof Result.Error)) {
                throw new NoWhenBranchMatchedException();
            }
            if (boxDatabase instanceof Result.Success) {
                return boxDatabase;
            }
            if (boxDatabase instanceof Result.Error) {
                BoxLogUtils.e(ExtensionsKt.getTAG(this), "Error while fetching next job to run: " + ((CacheError) ((Result.Error) boxDatabase).getValue()));
                return new Result.Error(CacheError.ReadError.INSTANCE);
            }
            throw new NoWhenBranchMatchedException();
        }
        if (i != 1) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        int i2 = c11841.I$1;
        int i3 = c11841.I$0;
        ResultKt.throwOnFailure(objNextRunnableJob);
        boxDatabase = (Result) objNextRunnableJob;
        if (boxDatabase instanceof Result.Success) {
            return boxDatabase;
        }
        if (boxDatabase instanceof Result.Error) {
            BoxLogUtils.e(ExtensionsKt.getTAG(this), "Error while fetching next job to run: " + ((CacheError) ((Result.Error) boxDatabase).getValue()));
            return new Result.Error(CacheError.ReadError.INSTANCE);
        }
        throw new NoWhenBranchMatchedException();
    }

    /* JADX WARN: Code duplicated, block: B:25:0x00c6  */
    /* JADX WARN: Code duplicated, block: B:29:0x00de  */
    /* JADX WARN: Code duplicated, block: B:35:0x010a A[LOOP:2: B:33:0x0104->B:35:0x010a, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:39:0x012d  */
    /* JADX WARN: Code duplicated, block: B:42:0x013b  */
    /* JADX WARN: Code duplicated, block: B:46:0x0154  */
    /* JADX WARN: Code duplicated, block: B:52:0x018a A[PHI: r2 r3 r4 r5 r10
      0x018a: PHI (r2v13 java.util.List<com.box.android.domain.jobs.JobId>) = (r2v10 java.util.ArrayList), (r2v16 java.util.List<com.box.android.domain.jobs.JobId>) binds: [B:50:0x0186, B:16:0x0086] A[DONT_GENERATE, DONT_INLINE]
      0x018a: PHI (r3v11 java.util.List) = (r3v8 java.util.List), (r3v14 java.util.List) binds: [B:50:0x0186, B:16:0x0086] A[DONT_GENERATE, DONT_INLINE]
      0x018a: PHI (r4v9 java.util.List) = (r4v8 java.util.List), (r4v12 java.util.List) binds: [B:50:0x0186, B:16:0x0086] A[DONT_GENERATE, DONT_INLINE]
      0x018a: PHI (r5v6 java.util.List) = (r5v4 java.util.List), (r5v9 java.util.List) binds: [B:50:0x0186, B:16:0x0086] A[DONT_GENERATE, DONT_INLINE]
      0x018a: PHI (r10v26 java.lang.Object) = (r10v24 java.lang.Object), (r10v1 java.lang.Object) binds: [B:50:0x0186, B:16:0x0086] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:54:0x0194  */
    /* JADX WARN: Code duplicated, block: B:58:0x01c8  */
    /* JADX WARN: Code duplicated, block: B:61:0x01db  */
    /* JADX WARN: Code duplicated, block: B:63:0x01e1  */
    /* JADX WARN: Code duplicated, block: B:66:0x020b A[PHI: r2 r3 r4 r5 r6 r7 r10
      0x020b: PHI (r2v20 java.util.Date) = (r2v17 java.util.Date), (r2v22 java.util.Date) binds: [B:64:0x0208, B:14:0x004c] A[DONT_GENERATE, DONT_INLINE]
      0x020b: PHI (r3v18 java.util.List<com.box.android.data.persistence.jobs.JobEntity>) = 
      (r3v15 java.util.List<com.box.android.data.persistence.jobs.JobEntity>)
      (r3v24 java.util.List<com.box.android.data.persistence.jobs.JobEntity>)
     binds: [B:64:0x0208, B:14:0x004c] A[DONT_GENERATE, DONT_INLINE]
      0x020b: PHI (r4v16 java.util.List<com.box.android.domain.jobs.JobId>) = (r4v13 java.util.List<com.box.android.domain.jobs.JobId>), (r4v19 java.util.List<com.box.android.domain.jobs.JobId>) binds: [B:64:0x0208, B:14:0x004c] A[DONT_GENERATE, DONT_INLINE]
      0x020b: PHI (r5v13 java.util.List) = (r5v10 java.util.List), (r5v16 java.util.List) binds: [B:64:0x0208, B:14:0x004c] A[DONT_GENERATE, DONT_INLINE]
      0x020b: PHI (r6v7 java.util.List) = (r6v4 java.util.List), (r6v10 java.util.List) binds: [B:64:0x0208, B:14:0x004c] A[DONT_GENERATE, DONT_INLINE]
      0x020b: PHI (r7v14 java.util.List) = (r7v11 java.util.List), (r7v17 java.util.List) binds: [B:64:0x0208, B:14:0x004c] A[DONT_GENERATE, DONT_INLINE]
      0x020b: PHI (r10v44 java.lang.Object) = (r10v43 java.lang.Object), (r10v1 java.lang.Object) binds: [B:64:0x0208, B:14:0x004c] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:68:0x0215  */
    /* JADX WARN: Code duplicated, block: B:72:0x024d A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:74:0x0161 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:76:0x014e A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:79:0x00eb A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    /* JADX WARN: Code duplicated, block: B:81:0x00d8 A[SYNTHETIC] */
    public final Object nextRunnableJob(Continuation<? super Result<JobEntity, ? extends CacheError>> continuation) {
        C11941 c11941;
        List listEmptyList;
        ArrayList arrayList;
        ArrayList arrayList2;
        Iterator it;
        ArrayList arrayList3;
        Object waitingRootIDs;
        List list;
        List list2;
        List listEmptyList2;
        List list3;
        ArrayList arrayList4;
        ArrayList arrayList5;
        List<JobEntity> listEmptyList3;
        Date date;
        Object objFirstRunnableJob;
        List<JobEntity> list4;
        List list5;
        List list6;
        List<JobId> list7;
        Date date2;
        List list8;
        JobEntity jobEntity;
        List<JobEntity> listEmptyList4;
        Object objFirstRunnableJob2;
        if (continuation instanceof C11941) {
            c11941 = (C11941) continuation;
            if ((c11941.label & Integer.MIN_VALUE) != 0) {
                c11941.label -= Integer.MIN_VALUE;
            } else {
                c11941 = new C11941(continuation);
            }
        } else {
            c11941 = new C11941(continuation);
        }
        Object rootIDsWithRunningJobsCount = c11941.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (c11941.label) {
            case 0:
                ResultKt.throwOnFailure(rootIDsWithRunningJobsCount);
                c11941.label = 1;
                rootIDsWithRunningJobsCount = getRootIDsWithRunningJobsCount(c11941);
                if (rootIDsWithRunningJobsCount != coroutine_suspended) {
                    listEmptyList = (List) com.box.android.domain.utils.result.ResultKt.getOrNull((Result) rootIDsWithRunningJobsCount);
                    if (listEmptyList == null) {
                        listEmptyList = CollectionsKt.emptyList();
                    }
                    arrayList = new ArrayList();
                    for (Object obj : listEmptyList) {
                        if (((RootIdWithRunningJobsCount) obj).getCount() > 0) {
                            arrayList.add(obj);
                        }
                    }
                    ArrayList arrayList6 = arrayList;
                    arrayList2 = new ArrayList(CollectionsKt.collectionSizeOrDefault(arrayList6, 10));
                    it = arrayList6.iterator();
                    while (it.hasNext()) {
                        arrayList2.add(((RootIdWithRunningJobsCount) it.next()).getRootID());
                    }
                    arrayList3 = arrayList2;
                    c11941.L$0 = SpillingKt.nullOutSpilledVariable(listEmptyList);
                    c11941.L$1 = arrayList3;
                    c11941.label = 2;
                    waitingRootIDs = getWaitingRootIDs(c11941);
                    if (waitingRootIDs != coroutine_suspended) {
                        list = listEmptyList;
                        rootIDsWithRunningJobsCount = waitingRootIDs;
                        list2 = arrayList3;
                        listEmptyList2 = (List) com.box.android.domain.utils.result.ResultKt.getOrNull((Result) rootIDsWithRunningJobsCount);
                        if (listEmptyList2 == null) {
                            listEmptyList2 = CollectionsKt.emptyList();
                        }
                        list3 = listEmptyList2;
                        arrayList4 = new ArrayList();
                        for (Object obj2 : list3) {
                            if (!list2.contains((JobId) obj2)) {
                                arrayList4.add(obj2);
                            }
                        }
                        arrayList5 = arrayList4;
                        c11941.L$0 = SpillingKt.nullOutSpilledVariable(list);
                        c11941.L$1 = SpillingKt.nullOutSpilledVariable(list2);
                        c11941.L$2 = SpillingKt.nullOutSpilledVariable(list3);
                        c11941.L$3 = SpillingKt.nullOutSpilledVariable(arrayList5);
                        c11941.label = 3;
                        rootIDsWithRunningJobsCount = getChildrenOfStarvedRoots(arrayList5, c11941);
                        if (rootIDsWithRunningJobsCount != coroutine_suspended) {
                            listEmptyList3 = (List) com.box.android.domain.utils.result.ResultKt.getOrNull((Result) rootIDsWithRunningJobsCount);
                            if (listEmptyList3 == null) {
                                listEmptyList3 = CollectionsKt.emptyList();
                            }
                            date = new Date();
                            c11941.L$0 = SpillingKt.nullOutSpilledVariable(list);
                            c11941.L$1 = SpillingKt.nullOutSpilledVariable(list2);
                            c11941.L$2 = SpillingKt.nullOutSpilledVariable(list3);
                            c11941.L$3 = SpillingKt.nullOutSpilledVariable(arrayList5);
                            c11941.L$4 = SpillingKt.nullOutSpilledVariable(listEmptyList3);
                            c11941.L$5 = date;
                            c11941.label = 4;
                            objFirstRunnableJob = firstRunnableJob(listEmptyList3, date, c11941);
                            if (objFirstRunnableJob != coroutine_suspended) {
                                List list9 = list3;
                                list4 = listEmptyList3;
                                rootIDsWithRunningJobsCount = objFirstRunnableJob;
                                list5 = list;
                                list6 = list9;
                                List list10 = list2;
                                list7 = arrayList5;
                                date2 = date;
                                list8 = list10;
                                jobEntity = (JobEntity) com.box.android.domain.utils.result.ResultKt.getOrNull((Result) rootIDsWithRunningJobsCount);
                                if (jobEntity != null) {
                                    return new Result.Success(jobEntity);
                                }
                                c11941.L$0 = SpillingKt.nullOutSpilledVariable(list5);
                                c11941.L$1 = SpillingKt.nullOutSpilledVariable(list8);
                                c11941.L$2 = SpillingKt.nullOutSpilledVariable(list6);
                                c11941.L$3 = SpillingKt.nullOutSpilledVariable(list7);
                                c11941.L$4 = SpillingKt.nullOutSpilledVariable(list4);
                                c11941.L$5 = date2;
                                c11941.label = 5;
                                rootIDsWithRunningJobsCount = getEnqueuedJobs(c11941);
                                if (rootIDsWithRunningJobsCount != coroutine_suspended) {
                                    listEmptyList4 = (List) com.box.android.domain.utils.result.ResultKt.getOrNull((Result) rootIDsWithRunningJobsCount);
                                    if (listEmptyList4 == null) {
                                        listEmptyList4 = CollectionsKt.emptyList();
                                    }
                                    c11941.L$0 = SpillingKt.nullOutSpilledVariable(list5);
                                    c11941.L$1 = SpillingKt.nullOutSpilledVariable(list8);
                                    c11941.L$2 = SpillingKt.nullOutSpilledVariable(list6);
                                    c11941.L$3 = SpillingKt.nullOutSpilledVariable(list7);
                                    c11941.L$4 = SpillingKt.nullOutSpilledVariable(list4);
                                    c11941.L$5 = SpillingKt.nullOutSpilledVariable(date2);
                                    c11941.L$6 = SpillingKt.nullOutSpilledVariable(listEmptyList4);
                                    c11941.label = 6;
                                    objFirstRunnableJob2 = firstRunnableJob(listEmptyList4, date2, c11941);
                                    if (objFirstRunnableJob2 != coroutine_suspended) {
                                        return objFirstRunnableJob2;
                                    }
                                }
                            }
                        }
                    }
                }
                return coroutine_suspended;
            case 1:
                ResultKt.throwOnFailure(rootIDsWithRunningJobsCount);
                listEmptyList = (List) com.box.android.domain.utils.result.ResultKt.getOrNull((Result) rootIDsWithRunningJobsCount);
                if (listEmptyList == null) {
                    listEmptyList = CollectionsKt.emptyList();
                }
                arrayList = new ArrayList();
                while (r2.hasNext()) {
                    if (((RootIdWithRunningJobsCount) obj).getCount() > 0) {
                        arrayList.add(obj);
                    }
                }
                ArrayList arrayList7 = arrayList;
                arrayList2 = new ArrayList(CollectionsKt.collectionSizeOrDefault(arrayList7, 10));
                it = arrayList7.iterator();
                while (it.hasNext()) {
                    arrayList2.add(((RootIdWithRunningJobsCount) it.next()).getRootID());
                }
                arrayList3 = arrayList2;
                c11941.L$0 = SpillingKt.nullOutSpilledVariable(listEmptyList);
                c11941.L$1 = arrayList3;
                c11941.label = 2;
                waitingRootIDs = getWaitingRootIDs(c11941);
                if (waitingRootIDs != coroutine_suspended) {
                    list = listEmptyList;
                    rootIDsWithRunningJobsCount = waitingRootIDs;
                    list2 = arrayList3;
                    listEmptyList2 = (List) com.box.android.domain.utils.result.ResultKt.getOrNull((Result) rootIDsWithRunningJobsCount);
                    if (listEmptyList2 == null) {
                        listEmptyList2 = CollectionsKt.emptyList();
                    }
                    list3 = listEmptyList2;
                    arrayList4 = new ArrayList();
                    while (r10.hasNext()) {
                        if (!list2.contains((JobId) obj2)) {
                            arrayList4.add(obj2);
                        }
                    }
                    arrayList5 = arrayList4;
                    c11941.L$0 = SpillingKt.nullOutSpilledVariable(list);
                    c11941.L$1 = SpillingKt.nullOutSpilledVariable(list2);
                    c11941.L$2 = SpillingKt.nullOutSpilledVariable(list3);
                    c11941.L$3 = SpillingKt.nullOutSpilledVariable(arrayList5);
                    c11941.label = 3;
                    rootIDsWithRunningJobsCount = getChildrenOfStarvedRoots(arrayList5, c11941);
                    if (rootIDsWithRunningJobsCount != coroutine_suspended) {
                        listEmptyList3 = (List) com.box.android.domain.utils.result.ResultKt.getOrNull((Result) rootIDsWithRunningJobsCount);
                        if (listEmptyList3 == null) {
                            listEmptyList3 = CollectionsKt.emptyList();
                        }
                        date = new Date();
                        c11941.L$0 = SpillingKt.nullOutSpilledVariable(list);
                        c11941.L$1 = SpillingKt.nullOutSpilledVariable(list2);
                        c11941.L$2 = SpillingKt.nullOutSpilledVariable(list3);
                        c11941.L$3 = SpillingKt.nullOutSpilledVariable(arrayList5);
                        c11941.L$4 = SpillingKt.nullOutSpilledVariable(listEmptyList3);
                        c11941.L$5 = date;
                        c11941.label = 4;
                        objFirstRunnableJob = firstRunnableJob(listEmptyList3, date, c11941);
                        if (objFirstRunnableJob != coroutine_suspended) {
                            List list11 = list3;
                            list4 = listEmptyList3;
                            rootIDsWithRunningJobsCount = objFirstRunnableJob;
                            list5 = list;
                            list6 = list11;
                            List list12 = list2;
                            list7 = arrayList5;
                            date2 = date;
                            list8 = list12;
                            jobEntity = (JobEntity) com.box.android.domain.utils.result.ResultKt.getOrNull((Result) rootIDsWithRunningJobsCount);
                            if (jobEntity != null) {
                                return new Result.Success(jobEntity);
                            }
                            c11941.L$0 = SpillingKt.nullOutSpilledVariable(list5);
                            c11941.L$1 = SpillingKt.nullOutSpilledVariable(list8);
                            c11941.L$2 = SpillingKt.nullOutSpilledVariable(list6);
                            c11941.L$3 = SpillingKt.nullOutSpilledVariable(list7);
                            c11941.L$4 = SpillingKt.nullOutSpilledVariable(list4);
                            c11941.L$5 = date2;
                            c11941.label = 5;
                            rootIDsWithRunningJobsCount = getEnqueuedJobs(c11941);
                            if (rootIDsWithRunningJobsCount != coroutine_suspended) {
                                listEmptyList4 = (List) com.box.android.domain.utils.result.ResultKt.getOrNull((Result) rootIDsWithRunningJobsCount);
                                if (listEmptyList4 == null) {
                                    listEmptyList4 = CollectionsKt.emptyList();
                                }
                                c11941.L$0 = SpillingKt.nullOutSpilledVariable(list5);
                                c11941.L$1 = SpillingKt.nullOutSpilledVariable(list8);
                                c11941.L$2 = SpillingKt.nullOutSpilledVariable(list6);
                                c11941.L$3 = SpillingKt.nullOutSpilledVariable(list7);
                                c11941.L$4 = SpillingKt.nullOutSpilledVariable(list4);
                                c11941.L$5 = SpillingKt.nullOutSpilledVariable(date2);
                                c11941.L$6 = SpillingKt.nullOutSpilledVariable(listEmptyList4);
                                c11941.label = 6;
                                objFirstRunnableJob2 = firstRunnableJob(listEmptyList4, date2, c11941);
                                if (objFirstRunnableJob2 != coroutine_suspended) {
                                    return objFirstRunnableJob2;
                                }
                            }
                        }
                    }
                }
                return coroutine_suspended;
            case 2:
                arrayList3 = (List) c11941.L$1;
                List list13 = (List) c11941.L$0;
                ResultKt.throwOnFailure(rootIDsWithRunningJobsCount);
                list = list13;
                list2 = arrayList3;
                listEmptyList2 = (List) com.box.android.domain.utils.result.ResultKt.getOrNull((Result) rootIDsWithRunningJobsCount);
                if (listEmptyList2 == null) {
                    listEmptyList2 = CollectionsKt.emptyList();
                }
                list3 = listEmptyList2;
                arrayList4 = new ArrayList();
                while (r10.hasNext()) {
                    if (!list2.contains((JobId) obj2)) {
                        arrayList4.add(obj2);
                    }
                }
                arrayList5 = arrayList4;
                c11941.L$0 = SpillingKt.nullOutSpilledVariable(list);
                c11941.L$1 = SpillingKt.nullOutSpilledVariable(list2);
                c11941.L$2 = SpillingKt.nullOutSpilledVariable(list3);
                c11941.L$3 = SpillingKt.nullOutSpilledVariable(arrayList5);
                c11941.label = 3;
                rootIDsWithRunningJobsCount = getChildrenOfStarvedRoots(arrayList5, c11941);
                if (rootIDsWithRunningJobsCount != coroutine_suspended) {
                    listEmptyList3 = (List) com.box.android.domain.utils.result.ResultKt.getOrNull((Result) rootIDsWithRunningJobsCount);
                    if (listEmptyList3 == null) {
                        listEmptyList3 = CollectionsKt.emptyList();
                    }
                    date = new Date();
                    c11941.L$0 = SpillingKt.nullOutSpilledVariable(list);
                    c11941.L$1 = SpillingKt.nullOutSpilledVariable(list2);
                    c11941.L$2 = SpillingKt.nullOutSpilledVariable(list3);
                    c11941.L$3 = SpillingKt.nullOutSpilledVariable(arrayList5);
                    c11941.L$4 = SpillingKt.nullOutSpilledVariable(listEmptyList3);
                    c11941.L$5 = date;
                    c11941.label = 4;
                    objFirstRunnableJob = firstRunnableJob(listEmptyList3, date, c11941);
                    if (objFirstRunnableJob != coroutine_suspended) {
                        List list14 = list3;
                        list4 = listEmptyList3;
                        rootIDsWithRunningJobsCount = objFirstRunnableJob;
                        list5 = list;
                        list6 = list14;
                        List list15 = list2;
                        list7 = arrayList5;
                        date2 = date;
                        list8 = list15;
                        jobEntity = (JobEntity) com.box.android.domain.utils.result.ResultKt.getOrNull((Result) rootIDsWithRunningJobsCount);
                        if (jobEntity != null) {
                            return new Result.Success(jobEntity);
                        }
                        c11941.L$0 = SpillingKt.nullOutSpilledVariable(list5);
                        c11941.L$1 = SpillingKt.nullOutSpilledVariable(list8);
                        c11941.L$2 = SpillingKt.nullOutSpilledVariable(list6);
                        c11941.L$3 = SpillingKt.nullOutSpilledVariable(list7);
                        c11941.L$4 = SpillingKt.nullOutSpilledVariable(list4);
                        c11941.L$5 = date2;
                        c11941.label = 5;
                        rootIDsWithRunningJobsCount = getEnqueuedJobs(c11941);
                        if (rootIDsWithRunningJobsCount != coroutine_suspended) {
                            listEmptyList4 = (List) com.box.android.domain.utils.result.ResultKt.getOrNull((Result) rootIDsWithRunningJobsCount);
                            if (listEmptyList4 == null) {
                                listEmptyList4 = CollectionsKt.emptyList();
                            }
                            c11941.L$0 = SpillingKt.nullOutSpilledVariable(list5);
                            c11941.L$1 = SpillingKt.nullOutSpilledVariable(list8);
                            c11941.L$2 = SpillingKt.nullOutSpilledVariable(list6);
                            c11941.L$3 = SpillingKt.nullOutSpilledVariable(list7);
                            c11941.L$4 = SpillingKt.nullOutSpilledVariable(list4);
                            c11941.L$5 = SpillingKt.nullOutSpilledVariable(date2);
                            c11941.L$6 = SpillingKt.nullOutSpilledVariable(listEmptyList4);
                            c11941.label = 6;
                            objFirstRunnableJob2 = firstRunnableJob(listEmptyList4, date2, c11941);
                            if (objFirstRunnableJob2 != coroutine_suspended) {
                                return objFirstRunnableJob2;
                            }
                        }
                    }
                }
                return coroutine_suspended;
            case 3:
                arrayList5 = (List) c11941.L$3;
                list3 = (List) c11941.L$2;
                list2 = (List) c11941.L$1;
                list = (List) c11941.L$0;
                ResultKt.throwOnFailure(rootIDsWithRunningJobsCount);
                listEmptyList3 = (List) com.box.android.domain.utils.result.ResultKt.getOrNull((Result) rootIDsWithRunningJobsCount);
                if (listEmptyList3 == null) {
                    listEmptyList3 = CollectionsKt.emptyList();
                }
                date = new Date();
                c11941.L$0 = SpillingKt.nullOutSpilledVariable(list);
                c11941.L$1 = SpillingKt.nullOutSpilledVariable(list2);
                c11941.L$2 = SpillingKt.nullOutSpilledVariable(list3);
                c11941.L$3 = SpillingKt.nullOutSpilledVariable(arrayList5);
                c11941.L$4 = SpillingKt.nullOutSpilledVariable(listEmptyList3);
                c11941.L$5 = date;
                c11941.label = 4;
                objFirstRunnableJob = firstRunnableJob(listEmptyList3, date, c11941);
                if (objFirstRunnableJob != coroutine_suspended) {
                    List list16 = list3;
                    list4 = listEmptyList3;
                    rootIDsWithRunningJobsCount = objFirstRunnableJob;
                    list5 = list;
                    list6 = list16;
                    List list17 = list2;
                    list7 = arrayList5;
                    date2 = date;
                    list8 = list17;
                    jobEntity = (JobEntity) com.box.android.domain.utils.result.ResultKt.getOrNull((Result) rootIDsWithRunningJobsCount);
                    if (jobEntity != null) {
                        return new Result.Success(jobEntity);
                    }
                    c11941.L$0 = SpillingKt.nullOutSpilledVariable(list5);
                    c11941.L$1 = SpillingKt.nullOutSpilledVariable(list8);
                    c11941.L$2 = SpillingKt.nullOutSpilledVariable(list6);
                    c11941.L$3 = SpillingKt.nullOutSpilledVariable(list7);
                    c11941.L$4 = SpillingKt.nullOutSpilledVariable(list4);
                    c11941.L$5 = date2;
                    c11941.label = 5;
                    rootIDsWithRunningJobsCount = getEnqueuedJobs(c11941);
                    if (rootIDsWithRunningJobsCount != coroutine_suspended) {
                        listEmptyList4 = (List) com.box.android.domain.utils.result.ResultKt.getOrNull((Result) rootIDsWithRunningJobsCount);
                        if (listEmptyList4 == null) {
                            listEmptyList4 = CollectionsKt.emptyList();
                        }
                        c11941.L$0 = SpillingKt.nullOutSpilledVariable(list5);
                        c11941.L$1 = SpillingKt.nullOutSpilledVariable(list8);
                        c11941.L$2 = SpillingKt.nullOutSpilledVariable(list6);
                        c11941.L$3 = SpillingKt.nullOutSpilledVariable(list7);
                        c11941.L$4 = SpillingKt.nullOutSpilledVariable(list4);
                        c11941.L$5 = SpillingKt.nullOutSpilledVariable(date2);
                        c11941.L$6 = SpillingKt.nullOutSpilledVariable(listEmptyList4);
                        c11941.label = 6;
                        objFirstRunnableJob2 = firstRunnableJob(listEmptyList4, date2, c11941);
                        if (objFirstRunnableJob2 != coroutine_suspended) {
                            return objFirstRunnableJob2;
                        }
                    }
                }
                return coroutine_suspended;
            case 4:
                date2 = (Date) c11941.L$5;
                list4 = (List) c11941.L$4;
                list7 = (List) c11941.L$3;
                list6 = (List) c11941.L$2;
                list8 = (List) c11941.L$1;
                list5 = (List) c11941.L$0;
                ResultKt.throwOnFailure(rootIDsWithRunningJobsCount);
                jobEntity = (JobEntity) com.box.android.domain.utils.result.ResultKt.getOrNull((Result) rootIDsWithRunningJobsCount);
                if (jobEntity != null) {
                    return new Result.Success(jobEntity);
                }
                c11941.L$0 = SpillingKt.nullOutSpilledVariable(list5);
                c11941.L$1 = SpillingKt.nullOutSpilledVariable(list8);
                c11941.L$2 = SpillingKt.nullOutSpilledVariable(list6);
                c11941.L$3 = SpillingKt.nullOutSpilledVariable(list7);
                c11941.L$4 = SpillingKt.nullOutSpilledVariable(list4);
                c11941.L$5 = date2;
                c11941.label = 5;
                rootIDsWithRunningJobsCount = getEnqueuedJobs(c11941);
                if (rootIDsWithRunningJobsCount != coroutine_suspended) {
                    listEmptyList4 = (List) com.box.android.domain.utils.result.ResultKt.getOrNull((Result) rootIDsWithRunningJobsCount);
                    if (listEmptyList4 == null) {
                        listEmptyList4 = CollectionsKt.emptyList();
                    }
                    c11941.L$0 = SpillingKt.nullOutSpilledVariable(list5);
                    c11941.L$1 = SpillingKt.nullOutSpilledVariable(list8);
                    c11941.L$2 = SpillingKt.nullOutSpilledVariable(list6);
                    c11941.L$3 = SpillingKt.nullOutSpilledVariable(list7);
                    c11941.L$4 = SpillingKt.nullOutSpilledVariable(list4);
                    c11941.L$5 = SpillingKt.nullOutSpilledVariable(date2);
                    c11941.L$6 = SpillingKt.nullOutSpilledVariable(listEmptyList4);
                    c11941.label = 6;
                    objFirstRunnableJob2 = firstRunnableJob(listEmptyList4, date2, c11941);
                    if (objFirstRunnableJob2 != coroutine_suspended) {
                        return objFirstRunnableJob2;
                    }
                }
                return coroutine_suspended;
            case 5:
                date2 = (Date) c11941.L$5;
                list4 = (List) c11941.L$4;
                list7 = (List) c11941.L$3;
                list6 = (List) c11941.L$2;
                list8 = (List) c11941.L$1;
                list5 = (List) c11941.L$0;
                ResultKt.throwOnFailure(rootIDsWithRunningJobsCount);
                listEmptyList4 = (List) com.box.android.domain.utils.result.ResultKt.getOrNull((Result) rootIDsWithRunningJobsCount);
                if (listEmptyList4 == null) {
                    listEmptyList4 = CollectionsKt.emptyList();
                }
                c11941.L$0 = SpillingKt.nullOutSpilledVariable(list5);
                c11941.L$1 = SpillingKt.nullOutSpilledVariable(list8);
                c11941.L$2 = SpillingKt.nullOutSpilledVariable(list6);
                c11941.L$3 = SpillingKt.nullOutSpilledVariable(list7);
                c11941.L$4 = SpillingKt.nullOutSpilledVariable(list4);
                c11941.L$5 = SpillingKt.nullOutSpilledVariable(date2);
                c11941.L$6 = SpillingKt.nullOutSpilledVariable(listEmptyList4);
                c11941.label = 6;
                objFirstRunnableJob2 = firstRunnableJob(listEmptyList4, date2, c11941);
                if (objFirstRunnableJob2 != coroutine_suspended) {
                    return coroutine_suspended;
                }
                return objFirstRunnableJob2;
            case 6:
                ResultKt.throwOnFailure(rootIDsWithRunningJobsCount);
                return rootIDsWithRunningJobsCount;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX WARN: Code duplicated, block: B:17:0x0057  */
    /* JADX WARN: Code duplicated, block: B:21:0x007f A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:22:0x0080  */
    /* JADX WARN: Code duplicated, block: B:34:0x0067 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:36:? A[LOOP:0: B:15:0x0051->B:36:?, LOOP_END, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:22:0x0080 -> B:23:0x0084). Please report as a decompilation issue!!! */
    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions stack size limit reached
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        */
    public final java.lang.Object firstRunnableJob(java.util.List<com.box.android.data.persistence.jobs.JobEntity> r8, java.util.Date r9, kotlin.coroutines.Continuation<? super com.box.android.domain.utils.result.Result<com.box.android.data.persistence.jobs.JobEntity, ? extends com.box.android.data.datasource.CacheError>> r10) {
        /*
            r7 = this;
            boolean r0 = r10 instanceof com.box.android.data.datasource.jobs.JobsDataSource.C11731
            if (r0 == 0) goto L14
            r0 = r10
            com.box.android.data.datasource.jobs.JobsDataSource$firstRunnableJob$1 r0 = (com.box.android.data.datasource.jobs.JobsDataSource.C11731) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L14
            int r10 = r0.label
            int r10 = r10 - r2
            r0.label = r10
            goto L19
        L14:
            com.box.android.data.datasource.jobs.JobsDataSource$firstRunnableJob$1 r0 = new com.box.android.data.datasource.jobs.JobsDataSource$firstRunnableJob$1
            r0.<init>(r10)
        L19:
            java.lang.Object r10 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L47
            if (r2 != r3) goto L3f
            java.lang.Object r8 = r0.L$3
            com.box.android.data.persistence.jobs.JobEntity r8 = (com.box.android.data.persistence.jobs.JobEntity) r8
            java.lang.Object r9 = r0.L$2
            java.util.Iterator r9 = (java.util.Iterator) r9
            java.lang.Object r2 = r0.L$1
            java.util.Date r2 = (java.util.Date) r2
            java.lang.Object r4 = r0.L$0
            java.util.List r4 = (java.util.List) r4
            kotlin.ResultKt.throwOnFailure(r10)
            r6 = r2
            r2 = r8
            r8 = r4
            r4 = r0
            r0 = r6
            goto L84
        L3f:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.String r8 = "call to 'resume' before 'invoke' with coroutine"
            r7.<init>(r8)
            throw r7
        L47:
            kotlin.ResultKt.throwOnFailure(r10)
            java.util.Iterator r10 = r8.iterator()
            r6 = r10
            r10 = r9
            r9 = r6
        L51:
            boolean r2 = r9.hasNext()
            if (r2 == 0) goto L9f
            java.lang.Object r2 = r9.next()
            com.box.android.data.persistence.jobs.JobEntity r2 = (com.box.android.data.persistence.jobs.JobEntity) r2
            java.util.Date r4 = r2.getEarliestStartDate()
            int r4 = r4.compareTo(r10)
            if (r4 > 0) goto L51
            com.box.android.domain.jobs.JobId r4 = r2.getId()
            java.lang.Object r5 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r8)
            r0.L$0 = r5
            r0.L$1 = r10
            r0.L$2 = r9
            r0.L$3 = r2
            r0.label = r3
            java.lang.Object r4 = r7.doesJobHavePredecessor(r4, r0)
            if (r4 != r1) goto L80
            return r1
        L80:
            r6 = r0
            r0 = r10
            r10 = r4
            r4 = r6
        L84:
            com.box.android.domain.utils.result.Result r10 = (com.box.android.domain.utils.result.Result) r10
            java.lang.Object r10 = com.box.android.domain.utils.result.ResultKt.getOrNull(r10)
            java.lang.Boolean r10 = (java.lang.Boolean) r10
            if (r10 == 0) goto L93
            boolean r10 = r10.booleanValue()
            goto L94
        L93:
            r10 = r3
        L94:
            if (r10 != 0) goto L9c
            com.box.android.domain.utils.result.Result$Success r7 = new com.box.android.domain.utils.result.Result$Success
            r7.<init>(r2)
            return r7
        L9c:
            r10 = r0
            r0 = r4
            goto L51
        L9f:
            com.box.android.domain.utils.result.Result$Success r7 = new com.box.android.domain.utils.result.Result$Success
            r8 = 0
            r7.<init>(r8)
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.box.android.data.datasource.jobs.JobsDataSource.firstRunnableJob(java.util.List, java.util.Date, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARN: Code duplicated, block: B:33:0x0098  */
    /* JADX WARN: Code duplicated, block: B:35:0x009c  */
    /* JADX WARN: Code duplicated, block: B:37:0x00c3  */
    /* JADX WARN: Code duplicated, block: B:43:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    public final Object getEnqueuedJobs(Continuation<? super Result<? extends List<JobEntity>, ? extends CacheError>> continuation) {
        C11791 c11791;
        Result.Error error;
        Result<BoxDatabase, CacheError> boxDatabase;
        if (continuation instanceof C11791) {
            c11791 = (C11791) continuation;
            if ((c11791.label & Integer.MIN_VALUE) != 0) {
                c11791.label -= Integer.MIN_VALUE;
            } else {
                c11791 = new C11791(continuation);
            }
        } else {
            c11791 = new C11791(continuation);
        }
        Object objEnqueuedJobs = c11791.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = c11791.label;
        try {
            if (i == 0) {
                ResultKt.throwOnFailure(objEnqueuedJobs);
                boxDatabase = this.userData.getBoxDatabase();
                if (boxDatabase instanceof Result.Success) {
                    BoxDatabase boxDatabase2 = (BoxDatabase) ((Result.Success) boxDatabase).getValue();
                    JobsDao jobsDao = boxDatabase2.jobsDao();
                    c11791.L$0 = SpillingKt.nullOutSpilledVariable(boxDatabase);
                    c11791.L$1 = SpillingKt.nullOutSpilledVariable(boxDatabase2);
                    c11791.I$0 = 0;
                    c11791.I$1 = 0;
                    c11791.I$2 = 0;
                    c11791.I$3 = 0;
                    c11791.label = 1;
                    objEnqueuedJobs = jobsDao.enqueuedJobs(c11791);
                    if (objEnqueuedJobs == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                } else if (!(boxDatabase instanceof Result.Error)) {
                    throw new NoWhenBranchMatchedException();
                }
                if (boxDatabase instanceof Result.Success) {
                    return boxDatabase;
                }
                if (boxDatabase instanceof Result.Error) {
                    BoxLogUtils.e(ExtensionsKt.getTAG(this), "Error while fetching running count: " + ((Result.Error) boxDatabase).getValue());
                    return new Result.Error(CacheError.ReadError.INSTANCE);
                }
                throw new NoWhenBranchMatchedException();
            }
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            int i2 = c11791.I$3;
            int i3 = c11791.I$2;
            int i4 = c11791.I$1;
            int i5 = c11791.I$0;
            ResultKt.throwOnFailure(objEnqueuedJobs);
            error = new Result.Success((List) objEnqueuedJobs);
        } catch (Exception e) {
            error = new Result.Error(e);
        }
        boxDatabase = error;
        if (boxDatabase instanceof Result.Success) {
            return boxDatabase;
        }
        if (boxDatabase instanceof Result.Error) {
            BoxLogUtils.e(ExtensionsKt.getTAG(this), "Error while fetching running count: " + ((Result.Error) boxDatabase).getValue());
            return new Result.Error(CacheError.ReadError.INSTANCE);
        }
        throw new NoWhenBranchMatchedException();
    }

    /* JADX WARN: Code duplicated, block: B:33:0x0098  */
    /* JADX WARN: Code duplicated, block: B:35:0x009c  */
    /* JADX WARN: Code duplicated, block: B:37:0x00c3  */
    /* JADX WARN: Code duplicated, block: B:43:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    public final Object getRootIDsWithRunningJobsCount(Continuation<? super Result<? extends List<RootIdWithRunningJobsCount>, ? extends CacheError>> continuation) {
        C11861 c11861;
        Result.Error error;
        Result<BoxDatabase, CacheError> boxDatabase;
        if (continuation instanceof C11861) {
            c11861 = (C11861) continuation;
            if ((c11861.label & Integer.MIN_VALUE) != 0) {
                c11861.label -= Integer.MIN_VALUE;
            } else {
                c11861 = new C11861(continuation);
            }
        } else {
            c11861 = new C11861(continuation);
        }
        Object objRootIDsWithRunningJobsCount = c11861.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = c11861.label;
        try {
            if (i == 0) {
                ResultKt.throwOnFailure(objRootIDsWithRunningJobsCount);
                boxDatabase = this.userData.getBoxDatabase();
                if (boxDatabase instanceof Result.Success) {
                    BoxDatabase boxDatabase2 = (BoxDatabase) ((Result.Success) boxDatabase).getValue();
                    JobsDao jobsDao = boxDatabase2.jobsDao();
                    c11861.L$0 = SpillingKt.nullOutSpilledVariable(boxDatabase);
                    c11861.L$1 = SpillingKt.nullOutSpilledVariable(boxDatabase2);
                    c11861.I$0 = 0;
                    c11861.I$1 = 0;
                    c11861.I$2 = 0;
                    c11861.I$3 = 0;
                    c11861.label = 1;
                    objRootIDsWithRunningJobsCount = jobsDao.rootIDsWithRunningJobsCount(c11861);
                    if (objRootIDsWithRunningJobsCount == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                } else if (!(boxDatabase instanceof Result.Error)) {
                    throw new NoWhenBranchMatchedException();
                }
                if (boxDatabase instanceof Result.Success) {
                    return boxDatabase;
                }
                if (boxDatabase instanceof Result.Error) {
                    BoxLogUtils.e(ExtensionsKt.getTAG(this), "Error while fetching running count: " + ((Result.Error) boxDatabase).getValue());
                    return new Result.Error(CacheError.ReadError.INSTANCE);
                }
                throw new NoWhenBranchMatchedException();
            }
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            int i2 = c11861.I$3;
            int i3 = c11861.I$2;
            int i4 = c11861.I$1;
            int i5 = c11861.I$0;
            ResultKt.throwOnFailure(objRootIDsWithRunningJobsCount);
            error = new Result.Success((List) objRootIDsWithRunningJobsCount);
        } catch (Exception e) {
            error = new Result.Error(e);
        }
        boxDatabase = error;
        if (boxDatabase instanceof Result.Success) {
            return boxDatabase;
        }
        if (boxDatabase instanceof Result.Error) {
            BoxLogUtils.e(ExtensionsKt.getTAG(this), "Error while fetching running count: " + ((Result.Error) boxDatabase).getValue());
            return new Result.Error(CacheError.ReadError.INSTANCE);
        }
        throw new NoWhenBranchMatchedException();
    }

    /* JADX WARN: Code duplicated, block: B:32:0x00a2  */
    /* JADX WARN: Code duplicated, block: B:34:0x00a6  */
    /* JADX WARN: Code duplicated, block: B:36:0x00cd  */
    /* JADX WARN: Code duplicated, block: B:42:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    public final Object getChildrenOfStarvedRoots(List<JobId> list, Continuation<? super Result<? extends List<JobEntity>, ? extends CacheError>> continuation) {
        C11771 c11771;
        Result.Error error;
        if (continuation instanceof C11771) {
            c11771 = (C11771) continuation;
            if ((c11771.label & Integer.MIN_VALUE) != 0) {
                c11771.label -= Integer.MIN_VALUE;
            } else {
                c11771 = new C11771(continuation);
            }
        } else {
            c11771 = new C11771(continuation);
        }
        Object objEnqueuedJobsWithTheseRootIDs = c11771.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = c11771.label;
        try {
            if (i == 0) {
                ResultKt.throwOnFailure(objEnqueuedJobsWithTheseRootIDs);
                error = this.userData.getBoxDatabase();
                if (error instanceof Result.Success) {
                    BoxDatabase boxDatabase = (BoxDatabase) ((Result.Success) error).getValue();
                    JobsDao jobsDao = boxDatabase.jobsDao();
                    c11771.L$0 = SpillingKt.nullOutSpilledVariable(list);
                    c11771.L$1 = SpillingKt.nullOutSpilledVariable(error);
                    c11771.L$2 = SpillingKt.nullOutSpilledVariable(boxDatabase);
                    c11771.I$0 = 0;
                    c11771.I$1 = 0;
                    c11771.I$2 = 0;
                    c11771.I$3 = 0;
                    c11771.label = 1;
                    objEnqueuedJobsWithTheseRootIDs = jobsDao.enqueuedJobsWithTheseRootIDs(list, c11771);
                    if (objEnqueuedJobsWithTheseRootIDs == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                } else if (!(error instanceof Result.Error)) {
                    throw new NoWhenBranchMatchedException();
                }
                if (error instanceof Result.Success) {
                    return error;
                }
                if (error instanceof Result.Error) {
                    BoxLogUtils.e(ExtensionsKt.getTAG(this), "Error while fetching children of starved roots: " + ((Result.Error) error).getValue());
                    return new Result.Error(CacheError.ReadError.INSTANCE);
                }
                throw new NoWhenBranchMatchedException();
            }
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            int i2 = c11771.I$3;
            int i3 = c11771.I$2;
            int i4 = c11771.I$1;
            int i5 = c11771.I$0;
            ResultKt.throwOnFailure(objEnqueuedJobsWithTheseRootIDs);
            error = new Result.Success((List) objEnqueuedJobsWithTheseRootIDs);
        } catch (Exception e) {
            error = new Result.Error(e);
        }
        if (error instanceof Result.Success) {
            return error;
        }
        if (error instanceof Result.Error) {
            BoxLogUtils.e(ExtensionsKt.getTAG(this), "Error while fetching children of starved roots: " + ((Result.Error) error).getValue());
            return new Result.Error(CacheError.ReadError.INSTANCE);
        }
        throw new NoWhenBranchMatchedException();
    }

    /* JADX WARN: Code duplicated, block: B:33:0x0098  */
    /* JADX WARN: Code duplicated, block: B:35:0x009c  */
    /* JADX WARN: Code duplicated, block: B:37:0x00c3  */
    /* JADX WARN: Code duplicated, block: B:43:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    public final Object getWaitingRootIDs(Continuation<? super Result<? extends List<JobId>, ? extends CacheError>> continuation) {
        C11901 c11901;
        Result.Error error;
        Result<BoxDatabase, CacheError> boxDatabase;
        if (continuation instanceof C11901) {
            c11901 = (C11901) continuation;
            if ((c11901.label & Integer.MIN_VALUE) != 0) {
                c11901.label -= Integer.MIN_VALUE;
            } else {
                c11901 = new C11901(continuation);
            }
        } else {
            c11901 = new C11901(continuation);
        }
        Object objWaitingRootIDs = c11901.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = c11901.label;
        try {
            if (i == 0) {
                ResultKt.throwOnFailure(objWaitingRootIDs);
                boxDatabase = this.userData.getBoxDatabase();
                if (boxDatabase instanceof Result.Success) {
                    BoxDatabase boxDatabase2 = (BoxDatabase) ((Result.Success) boxDatabase).getValue();
                    JobsDao jobsDao = boxDatabase2.jobsDao();
                    c11901.L$0 = SpillingKt.nullOutSpilledVariable(boxDatabase);
                    c11901.L$1 = SpillingKt.nullOutSpilledVariable(boxDatabase2);
                    c11901.I$0 = 0;
                    c11901.I$1 = 0;
                    c11901.I$2 = 0;
                    c11901.I$3 = 0;
                    c11901.label = 1;
                    objWaitingRootIDs = jobsDao.waitingRootIDs(c11901);
                    if (objWaitingRootIDs == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                } else if (!(boxDatabase instanceof Result.Error)) {
                    throw new NoWhenBranchMatchedException();
                }
                if (boxDatabase instanceof Result.Success) {
                    return boxDatabase;
                }
                if (boxDatabase instanceof Result.Error) {
                    BoxLogUtils.e(ExtensionsKt.getTAG(this), "Error while fetching waiting roots: " + ((Result.Error) boxDatabase).getValue());
                    return new Result.Error(CacheError.ReadError.INSTANCE);
                }
                throw new NoWhenBranchMatchedException();
            }
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            int i2 = c11901.I$3;
            int i3 = c11901.I$2;
            int i4 = c11901.I$1;
            int i5 = c11901.I$0;
            ResultKt.throwOnFailure(objWaitingRootIDs);
            error = new Result.Success((List) objWaitingRootIDs);
        } catch (Exception e) {
            error = new Result.Error(e);
        }
        boxDatabase = error;
        if (boxDatabase instanceof Result.Success) {
            return boxDatabase;
        }
        if (boxDatabase instanceof Result.Error) {
            BoxLogUtils.e(ExtensionsKt.getTAG(this), "Error while fetching waiting roots: " + ((Result.Error) boxDatabase).getValue());
            return new Result.Error(CacheError.ReadError.INSTANCE);
        }
        throw new NoWhenBranchMatchedException();
    }

    /* JADX WARN: Code duplicated, block: B:35:0x00a7  */
    /* JADX WARN: Code duplicated, block: B:37:0x00ab  */
    /* JADX WARN: Code duplicated, block: B:39:0x00d2  */
    /* JADX WARN: Code duplicated, block: B:45:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    public final Object doesJobHavePredecessor(JobId jobId, Continuation<? super Result<Boolean, CacheError.ReadError>> continuation) {
        C11721 c11721;
        Result.Error error;
        if (continuation instanceof C11721) {
            c11721 = (C11721) continuation;
            if ((c11721.label & Integer.MIN_VALUE) != 0) {
                c11721.label -= Integer.MIN_VALUE;
            } else {
                c11721 = new C11721(continuation);
            }
        } else {
            c11721 = new C11721(continuation);
        }
        Object predecessorJobIDOfJob = c11721.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = c11721.label;
        boolean z = true;
        try {
            if (i == 0) {
                ResultKt.throwOnFailure(predecessorJobIDOfJob);
                error = this.userData.getBoxDatabase();
                if (error instanceof Result.Success) {
                    BoxDatabase boxDatabase = (BoxDatabase) ((Result.Success) error).getValue();
                    JobsDao jobsDao = boxDatabase.jobsDao();
                    c11721.L$0 = SpillingKt.nullOutSpilledVariable(jobId);
                    c11721.L$1 = SpillingKt.nullOutSpilledVariable(error);
                    c11721.L$2 = SpillingKt.nullOutSpilledVariable(boxDatabase);
                    c11721.I$0 = 0;
                    c11721.I$1 = 0;
                    c11721.I$2 = 0;
                    c11721.I$3 = 0;
                    c11721.label = 1;
                    predecessorJobIDOfJob = jobsDao.getPredecessorJobIDOfJob(jobId, c11721);
                    if (predecessorJobIDOfJob == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                } else if (!(error instanceof Result.Error)) {
                    throw new NoWhenBranchMatchedException();
                }
                if (error instanceof Result.Success) {
                    return error;
                }
                if (error instanceof Result.Error) {
                    BoxLogUtils.e(ExtensionsKt.getTAG(this), "Error while getting predecessor of job: " + ((Result.Error) error).getValue());
                    return new Result.Error(CacheError.ReadError.INSTANCE);
                }
                throw new NoWhenBranchMatchedException();
            }
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            int i2 = c11721.I$3;
            int i3 = c11721.I$2;
            int i4 = c11721.I$1;
            int i5 = c11721.I$0;
            ResultKt.throwOnFailure(predecessorJobIDOfJob);
            if (predecessorJobIDOfJob == null) {
                z = false;
            }
            error = new Result.Success(Boxing.boxBoolean(z));
        } catch (Exception e) {
            error = new Result.Error(e);
        }
        if (error instanceof Result.Success) {
            return error;
        }
        if (error instanceof Result.Error) {
            BoxLogUtils.e(ExtensionsKt.getTAG(this), "Error while getting predecessor of job: " + ((Result.Error) error).getValue());
            return new Result.Error(CacheError.ReadError.INSTANCE);
        }
        throw new NoWhenBranchMatchedException();
    }

    /* JADX WARN: Code duplicated, block: B:33:0x0098  */
    /* JADX WARN: Code duplicated, block: B:35:0x009c  */
    /* JADX WARN: Code duplicated, block: B:37:0x00c3  */
    /* JADX WARN: Code duplicated, block: B:43:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    public final Object getEarliestStartDateOfNextJob(Continuation<? super Result<? extends Date, ? extends CacheError>> continuation) {
        C11781 c11781;
        Result.Error error;
        Result<BoxDatabase, CacheError> boxDatabase;
        if (continuation instanceof C11781) {
            c11781 = (C11781) continuation;
            if ((c11781.label & Integer.MIN_VALUE) != 0) {
                c11781.label -= Integer.MIN_VALUE;
            } else {
                c11781 = new C11781(continuation);
            }
        } else {
            c11781 = new C11781(continuation);
        }
        Object earliestStartDateOfNextJob = c11781.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = c11781.label;
        try {
            if (i == 0) {
                ResultKt.throwOnFailure(earliestStartDateOfNextJob);
                boxDatabase = this.userData.getBoxDatabase();
                if (boxDatabase instanceof Result.Success) {
                    BoxDatabase boxDatabase2 = (BoxDatabase) ((Result.Success) boxDatabase).getValue();
                    JobsDao jobsDao = boxDatabase2.jobsDao();
                    c11781.L$0 = SpillingKt.nullOutSpilledVariable(boxDatabase);
                    c11781.L$1 = SpillingKt.nullOutSpilledVariable(boxDatabase2);
                    c11781.I$0 = 0;
                    c11781.I$1 = 0;
                    c11781.I$2 = 0;
                    c11781.I$3 = 0;
                    c11781.label = 1;
                    earliestStartDateOfNextJob = jobsDao.getEarliestStartDateOfNextJob(c11781);
                    if (earliestStartDateOfNextJob == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                } else if (!(boxDatabase instanceof Result.Error)) {
                    throw new NoWhenBranchMatchedException();
                }
                if (boxDatabase instanceof Result.Success) {
                    return boxDatabase;
                }
                if (boxDatabase instanceof Result.Error) {
                    BoxLogUtils.e(ExtensionsKt.getTAG(this), "Error while fetching earliest start date of next job to run: " + ((Result.Error) boxDatabase).getValue());
                    return new Result.Error(CacheError.ReadError.INSTANCE);
                }
                throw new NoWhenBranchMatchedException();
            }
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            int i2 = c11781.I$3;
            int i3 = c11781.I$2;
            int i4 = c11781.I$1;
            int i5 = c11781.I$0;
            ResultKt.throwOnFailure(earliestStartDateOfNextJob);
            error = new Result.Success((Date) earliestStartDateOfNextJob);
        } catch (Exception e) {
            error = new Result.Error(e);
        }
        boxDatabase = error;
        if (boxDatabase instanceof Result.Success) {
            return boxDatabase;
        }
        if (boxDatabase instanceof Result.Error) {
            BoxLogUtils.e(ExtensionsKt.getTAG(this), "Error while fetching earliest start date of next job to run: " + ((Result.Error) boxDatabase).getValue());
            return new Result.Error(CacheError.ReadError.INSTANCE);
        }
        throw new NoWhenBranchMatchedException();
    }

    /* JADX WARN: Code duplicated, block: B:50:0x0107  */
    /* JADX WARN: Code duplicated, block: B:52:0x010b  */
    /* JADX WARN: Code duplicated, block: B:54:0x0134  */
    /* JADX WARN: Code duplicated, block: B:60:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    public final Object getJob(JobId jobId, Continuation<? super Result<JobEntity, ? extends CacheError>> continuation) {
        C11801 c11801;
        Result.Error error;
        Result<BoxDatabase, CacheError> boxDatabase;
        if (continuation instanceof C11801) {
            c11801 = (C11801) continuation;
            if ((c11801.label & Integer.MIN_VALUE) != 0) {
                c11801.label -= Integer.MIN_VALUE;
            } else {
                c11801 = new C11801(continuation);
            }
        } else {
            c11801 = new C11801(continuation);
        }
        Object job = c11801.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = c11801.label;
        try {
            if (i == 0) {
                ResultKt.throwOnFailure(job);
                boxDatabase = this.userData.getBoxDatabase();
                if (boxDatabase instanceof Result.Success) {
                    BoxDatabase boxDatabase2 = (BoxDatabase) ((Result.Success) boxDatabase).getValue();
                    JobsDao jobsDao = boxDatabase2.jobsDao();
                    c11801.L$0 = jobId;
                    c11801.L$1 = SpillingKt.nullOutSpilledVariable(boxDatabase);
                    c11801.L$2 = SpillingKt.nullOutSpilledVariable(boxDatabase2);
                    c11801.I$0 = 0;
                    c11801.I$1 = 0;
                    c11801.I$2 = 0;
                    c11801.I$3 = 0;
                    c11801.label = 1;
                    job = jobsDao.getJob(jobId, c11801);
                    if (job == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                } else if (!(boxDatabase instanceof Result.Error)) {
                    throw new NoWhenBranchMatchedException();
                }
                if (boxDatabase instanceof Result.Success) {
                    return boxDatabase;
                }
                if (boxDatabase instanceof Result.Error) {
                    BoxLogUtils.e(ExtensionsKt.getTAG(this), "Error while getting Job: " + jobId);
                    return new Result.Error(CacheError.ReadError.INSTANCE);
                }
                throw new NoWhenBranchMatchedException();
            }
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            int i2 = c11801.I$3;
            int i3 = c11801.I$2;
            int i4 = c11801.I$1;
            int i5 = c11801.I$0;
            jobId = (JobId) c11801.L$0;
            ResultKt.throwOnFailure(job);
            error = new Result.Success((JobEntity) job);
        } catch (Exception e) {
            error = new Result.Error(e);
        }
        if (error instanceof Result.Success) {
            JobEntity jobEntity = (JobEntity) ((Result.Success) error).getValue();
            if (jobEntity != null) {
                error = new Result.Success(jobEntity);
            } else {
                error = new Result.Error(CacheError.NoResultFound.INSTANCE);
            }
        } else if (!(error instanceof Result.Error)) {
            throw new NoWhenBranchMatchedException();
        }
        if (!(error instanceof Result.Success)) {
            if (error instanceof Result.Error) {
                BoxLogUtils.e(ExtensionsKt.getTAG(this), "Error while fetching job with id " + jobId + " Exception " + ((Result.Error) error).getValue());
                error = new Result.Error(CacheError.ReadError.INSTANCE);
            } else {
                throw new NoWhenBranchMatchedException();
            }
        }
        boxDatabase = error;
        if (boxDatabase instanceof Result.Success) {
            return boxDatabase;
        }
        if (boxDatabase instanceof Result.Error) {
            BoxLogUtils.e(ExtensionsKt.getTAG(this), "Error while getting Job: " + jobId);
            return new Result.Error(CacheError.ReadError.INSTANCE);
        }
        throw new NoWhenBranchMatchedException();
    }

    /* JADX WARN: Code duplicated, block: B:32:0x00a2  */
    /* JADX WARN: Code duplicated, block: B:34:0x00a6  */
    /* JADX WARN: Code duplicated, block: B:36:0x00cd  */
    /* JADX WARN: Code duplicated, block: B:42:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    public final Object getSuccessorsAsList(JobId jobId, Continuation<? super Result<? extends List<JobId>, ? extends CacheError>> continuation) {
        C11881 c11881;
        Result.Error error;
        if (continuation instanceof C11881) {
            c11881 = (C11881) continuation;
            if ((c11881.label & Integer.MIN_VALUE) != 0) {
                c11881.label -= Integer.MIN_VALUE;
            } else {
                c11881 = new C11881(continuation);
            }
        } else {
            c11881 = new C11881(continuation);
        }
        Object allDependentsOnJobAsList = c11881.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = c11881.label;
        try {
            if (i == 0) {
                ResultKt.throwOnFailure(allDependentsOnJobAsList);
                error = this.userData.getBoxDatabase();
                if (error instanceof Result.Success) {
                    BoxDatabase boxDatabase = (BoxDatabase) ((Result.Success) error).getValue();
                    JobsDao jobsDao = boxDatabase.jobsDao();
                    c11881.L$0 = SpillingKt.nullOutSpilledVariable(jobId);
                    c11881.L$1 = SpillingKt.nullOutSpilledVariable(error);
                    c11881.L$2 = SpillingKt.nullOutSpilledVariable(boxDatabase);
                    c11881.I$0 = 0;
                    c11881.I$1 = 0;
                    c11881.I$2 = 0;
                    c11881.I$3 = 0;
                    c11881.label = 1;
                    allDependentsOnJobAsList = jobsDao.getAllDependentsOnJobAsList(jobId, c11881);
                    if (allDependentsOnJobAsList == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                } else if (!(error instanceof Result.Error)) {
                    throw new NoWhenBranchMatchedException();
                }
                if (error instanceof Result.Success) {
                    return error;
                }
                if (error instanceof Result.Error) {
                    BoxLogUtils.e(ExtensionsKt.getTAG(this), "Error while getting Job: " + ((Result.Error) error).getValue());
                    return new Result.Error(CacheError.ReadError.INSTANCE);
                }
                throw new NoWhenBranchMatchedException();
            }
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            int i2 = c11881.I$3;
            int i3 = c11881.I$2;
            int i4 = c11881.I$1;
            int i5 = c11881.I$0;
            ResultKt.throwOnFailure(allDependentsOnJobAsList);
            error = new Result.Success((List) allDependentsOnJobAsList);
        } catch (Exception e) {
            error = new Result.Error(e);
        }
        if (error instanceof Result.Success) {
            return error;
        }
        if (error instanceof Result.Error) {
            BoxLogUtils.e(ExtensionsKt.getTAG(this), "Error while getting Job: " + ((Result.Error) error).getValue());
            return new Result.Error(CacheError.ReadError.INSTANCE);
        }
        throw new NoWhenBranchMatchedException();
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    public final Object withTransaction(Function1<? super Continuation<? super Unit>, ? extends Object> function1, Continuation<? super Result<Unit, ? extends CacheError>> continuation) {
        C11981 c11981;
        if (continuation instanceof C11981) {
            c11981 = (C11981) continuation;
            if ((c11981.label & Integer.MIN_VALUE) != 0) {
                c11981.label -= Integer.MIN_VALUE;
            } else {
                c11981 = new C11981(continuation);
            }
        } else {
            c11981 = new C11981(continuation);
        }
        Object obj = c11981.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = c11981.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            Result<BoxDatabase, CacheError> boxDatabase = this.userData.getBoxDatabase();
            if (boxDatabase instanceof Result.Success) {
                BoxDatabase boxDatabase2 = (BoxDatabase) ((Result.Success) boxDatabase).getValue();
                JobsDataSource$withTransaction$2$1 jobsDataSource$withTransaction$2$1 = new JobsDataSource$withTransaction$2$1(function1, null);
                c11981.L$0 = SpillingKt.nullOutSpilledVariable(function1);
                c11981.L$1 = SpillingKt.nullOutSpilledVariable(boxDatabase);
                c11981.L$2 = SpillingKt.nullOutSpilledVariable(boxDatabase2);
                c11981.I$0 = 0;
                c11981.I$1 = 0;
                c11981.label = 1;
                if (RoomDatabaseKt.withTransaction(boxDatabase2, jobsDataSource$withTransaction$2$1, c11981) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (boxDatabase instanceof Result.Error) {
                    return boxDatabase;
                }
                throw new NoWhenBranchMatchedException();
            }
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            int i2 = c11981.I$1;
            int i3 = c11981.I$0;
            ResultKt.throwOnFailure(obj);
        }
        return new Result.Success(Unit.INSTANCE);
    }

    /* JADX WARN: Code duplicated, block: B:32:0x00a2  */
    /* JADX WARN: Code duplicated, block: B:34:0x00a6  */
    /* JADX WARN: Code duplicated, block: B:36:0x00cd  */
    /* JADX WARN: Code duplicated, block: B:42:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    public final Object getJobsWithTags(List<String> list, Continuation<? super Result<? extends List<JobEntity>, ? extends CacheError>> continuation) {
        C11811 c11811;
        Result.Error error;
        if (continuation instanceof C11811) {
            c11811 = (C11811) continuation;
            if ((c11811.label & Integer.MIN_VALUE) != 0) {
                c11811.label -= Integer.MIN_VALUE;
            } else {
                c11811 = new C11811(continuation);
            }
        } else {
            c11811 = new C11811(continuation);
        }
        Object jobsWithTags = c11811.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = c11811.label;
        try {
            if (i == 0) {
                ResultKt.throwOnFailure(jobsWithTags);
                error = this.userData.getBoxDatabase();
                if (error instanceof Result.Success) {
                    BoxDatabase boxDatabase = (BoxDatabase) ((Result.Success) error).getValue();
                    JobsDao jobsDao = boxDatabase.jobsDao();
                    c11811.L$0 = SpillingKt.nullOutSpilledVariable(list);
                    c11811.L$1 = SpillingKt.nullOutSpilledVariable(error);
                    c11811.L$2 = SpillingKt.nullOutSpilledVariable(boxDatabase);
                    c11811.I$0 = 0;
                    c11811.I$1 = 0;
                    c11811.I$2 = 0;
                    c11811.I$3 = 0;
                    c11811.label = 1;
                    jobsWithTags = jobsDao.getJobsWithTags(list, c11811);
                    if (jobsWithTags == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                } else if (!(error instanceof Result.Error)) {
                    throw new NoWhenBranchMatchedException();
                }
                if (error instanceof Result.Success) {
                    return error;
                }
                if (error instanceof Result.Error) {
                    BoxLogUtils.e(ExtensionsKt.getTAG(this), "Error while getting Jobs with tags: " + ((Result.Error) error).getValue());
                    return new Result.Error(CacheError.ReadError.INSTANCE);
                }
                throw new NoWhenBranchMatchedException();
            }
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            int i2 = c11811.I$3;
            int i3 = c11811.I$2;
            int i4 = c11811.I$1;
            int i5 = c11811.I$0;
            ResultKt.throwOnFailure(jobsWithTags);
            error = new Result.Success((List) jobsWithTags);
        } catch (Exception e) {
            error = new Result.Error(e);
        }
        if (error instanceof Result.Success) {
            return error;
        }
        if (error instanceof Result.Error) {
            BoxLogUtils.e(ExtensionsKt.getTAG(this), "Error while getting Jobs with tags: " + ((Result.Error) error).getValue());
            return new Result.Error(CacheError.ReadError.INSTANCE);
        }
        throw new NoWhenBranchMatchedException();
    }

    /* JADX WARN: Code duplicated, block: B:33:0x0098  */
    /* JADX WARN: Code duplicated, block: B:35:0x009c  */
    /* JADX WARN: Code duplicated, block: B:37:0x00b5  */
    /* JADX WARN: Code duplicated, block: B:43:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    public final Object getAllJobs(Continuation<? super Result<? extends List<JobEntity>, ? extends CacheError>> continuation) {
        C11741 c11741;
        Result.Error error;
        Result<BoxDatabase, CacheError> boxDatabase;
        if (continuation instanceof C11741) {
            c11741 = (C11741) continuation;
            if ((c11741.label & Integer.MIN_VALUE) != 0) {
                c11741.label -= Integer.MIN_VALUE;
            } else {
                c11741 = new C11741(continuation);
            }
        } else {
            c11741 = new C11741(continuation);
        }
        Object allJobs = c11741.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = c11741.label;
        try {
            if (i == 0) {
                ResultKt.throwOnFailure(allJobs);
                boxDatabase = this.userData.getBoxDatabase();
                if (boxDatabase instanceof Result.Success) {
                    BoxDatabase boxDatabase2 = (BoxDatabase) ((Result.Success) boxDatabase).getValue();
                    JobsDao jobsDao = boxDatabase2.jobsDao();
                    c11741.L$0 = SpillingKt.nullOutSpilledVariable(boxDatabase);
                    c11741.L$1 = SpillingKt.nullOutSpilledVariable(boxDatabase2);
                    c11741.I$0 = 0;
                    c11741.I$1 = 0;
                    c11741.I$2 = 0;
                    c11741.I$3 = 0;
                    c11741.label = 1;
                    allJobs = jobsDao.getAllJobs(c11741);
                    if (allJobs == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                } else if (!(boxDatabase instanceof Result.Error)) {
                    throw new NoWhenBranchMatchedException();
                }
                if (boxDatabase instanceof Result.Success) {
                    return boxDatabase;
                }
                if (boxDatabase instanceof Result.Error) {
                    ((Result.Error) boxDatabase).getValue();
                    BoxLogUtils.e(ExtensionsKt.getTAG(this), "Error while reading the jobs from db");
                    return new Result.Error(CacheError.ReadError.INSTANCE);
                }
                throw new NoWhenBranchMatchedException();
            }
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            int i2 = c11741.I$3;
            int i3 = c11741.I$2;
            int i4 = c11741.I$1;
            int i5 = c11741.I$0;
            ResultKt.throwOnFailure(allJobs);
            error = new Result.Success((List) allJobs);
        } catch (Exception e) {
            error = new Result.Error(e);
        }
        boxDatabase = error;
        if (boxDatabase instanceof Result.Success) {
            return boxDatabase;
        }
        if (boxDatabase instanceof Result.Error) {
            ((Result.Error) boxDatabase).getValue();
            BoxLogUtils.e(ExtensionsKt.getTAG(this), "Error while reading the jobs from db");
            return new Result.Error(CacheError.ReadError.INSTANCE);
        }
        throw new NoWhenBranchMatchedException();
    }

    /* JADX WARN: Code duplicated, block: B:32:0x00a2  */
    /* JADX WARN: Code duplicated, block: B:34:0x00a6  */
    /* JADX WARN: Code duplicated, block: B:36:0x00bf  */
    /* JADX WARN: Code duplicated, block: B:42:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    public final Object getChildJobs(JobId jobId, Continuation<? super Result<? extends List<JobId>, ? extends CacheError>> continuation) {
        C11761 c11761;
        Result.Error error;
        if (continuation instanceof C11761) {
            c11761 = (C11761) continuation;
            if ((c11761.label & Integer.MIN_VALUE) != 0) {
                c11761.label -= Integer.MIN_VALUE;
            } else {
                c11761 = new C11761(continuation);
            }
        } else {
            c11761 = new C11761(continuation);
        }
        Object childJobs = c11761.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = c11761.label;
        try {
            if (i == 0) {
                ResultKt.throwOnFailure(childJobs);
                error = this.userData.getBoxDatabase();
                if (error instanceof Result.Success) {
                    BoxDatabase boxDatabase = (BoxDatabase) ((Result.Success) error).getValue();
                    JobsDao jobsDao = boxDatabase.jobsDao();
                    c11761.L$0 = SpillingKt.nullOutSpilledVariable(jobId);
                    c11761.L$1 = SpillingKt.nullOutSpilledVariable(error);
                    c11761.L$2 = SpillingKt.nullOutSpilledVariable(boxDatabase);
                    c11761.I$0 = 0;
                    c11761.I$1 = 0;
                    c11761.I$2 = 0;
                    c11761.I$3 = 0;
                    c11761.label = 1;
                    childJobs = jobsDao.getChildJobs(jobId, c11761);
                    if (childJobs == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                } else if (!(error instanceof Result.Error)) {
                    throw new NoWhenBranchMatchedException();
                }
                if (error instanceof Result.Success) {
                    return error;
                }
                if (error instanceof Result.Error) {
                    ((Result.Error) error).getValue();
                    BoxLogUtils.e(ExtensionsKt.getTAG(this), "Error while reading the jobs from db");
                    return new Result.Error(CacheError.ReadError.INSTANCE);
                }
                throw new NoWhenBranchMatchedException();
            }
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            int i2 = c11761.I$3;
            int i3 = c11761.I$2;
            int i4 = c11761.I$1;
            int i5 = c11761.I$0;
            ResultKt.throwOnFailure(childJobs);
            error = new Result.Success((List) childJobs);
        } catch (Exception e) {
            error = new Result.Error(e);
        }
        if (error instanceof Result.Success) {
            return error;
        }
        if (error instanceof Result.Error) {
            ((Result.Error) error).getValue();
            BoxLogUtils.e(ExtensionsKt.getTAG(this), "Error while reading the jobs from db");
            return new Result.Error(CacheError.ReadError.INSTANCE);
        }
        throw new NoWhenBranchMatchedException();
    }

    /* JADX WARN: Code duplicated, block: B:33:0x009e  */
    /* JADX WARN: Code duplicated, block: B:35:0x00a2  */
    /* JADX WARN: Code duplicated, block: B:37:0x00d3  */
    /* JADX WARN: Code duplicated, block: B:43:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    public final Object getTags(JobId jobId, Continuation<? super Result<? extends List<String>, ? extends CacheError>> continuation) {
        C11891 c11891;
        Result.Error error;
        Result<BoxDatabase, CacheError> boxDatabase;
        if (continuation instanceof C11891) {
            c11891 = (C11891) continuation;
            if ((c11891.label & Integer.MIN_VALUE) != 0) {
                c11891.label -= Integer.MIN_VALUE;
            } else {
                c11891 = new C11891(continuation);
            }
        } else {
            c11891 = new C11891(continuation);
        }
        Object tags = c11891.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = c11891.label;
        try {
            if (i == 0) {
                ResultKt.throwOnFailure(tags);
                boxDatabase = this.userData.getBoxDatabase();
                if (boxDatabase instanceof Result.Success) {
                    BoxDatabase boxDatabase2 = (BoxDatabase) ((Result.Success) boxDatabase).getValue();
                    JobsDao jobsDao = boxDatabase2.jobsDao();
                    c11891.L$0 = jobId;
                    c11891.L$1 = SpillingKt.nullOutSpilledVariable(boxDatabase);
                    c11891.L$2 = SpillingKt.nullOutSpilledVariable(boxDatabase2);
                    c11891.I$0 = 0;
                    c11891.I$1 = 0;
                    c11891.I$2 = 0;
                    c11891.I$3 = 0;
                    c11891.label = 1;
                    tags = jobsDao.getTags(jobId, c11891);
                    if (tags == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                } else if (!(boxDatabase instanceof Result.Error)) {
                    throw new NoWhenBranchMatchedException();
                }
                if (boxDatabase instanceof Result.Success) {
                    return boxDatabase;
                }
                if (boxDatabase instanceof Result.Error) {
                    BoxLogUtils.e(ExtensionsKt.getTAG(this), "Error while getting tags for jobs (id:" + jobId + " err:" + ((Result.Error) boxDatabase).getValue());
                    return new Result.Error(CacheError.ReadError.INSTANCE);
                }
                throw new NoWhenBranchMatchedException();
            }
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            int i2 = c11891.I$3;
            int i3 = c11891.I$2;
            int i4 = c11891.I$1;
            int i5 = c11891.I$0;
            jobId = (JobId) c11891.L$0;
            ResultKt.throwOnFailure(tags);
            error = new Result.Success((List) tags);
        } catch (Exception e) {
            error = new Result.Error(e);
        }
        boxDatabase = error;
        if (boxDatabase instanceof Result.Success) {
            return boxDatabase;
        }
        if (boxDatabase instanceof Result.Error) {
            BoxLogUtils.e(ExtensionsKt.getTAG(this), "Error while getting tags for jobs (id:" + jobId + " err:" + ((Result.Error) boxDatabase).getValue());
            return new Result.Error(CacheError.ReadError.INSTANCE);
        }
        throw new NoWhenBranchMatchedException();
    }

    /* JADX WARN: Code duplicated, block: B:32:0x00b0  */
    /* JADX WARN: Code duplicated, block: B:34:0x00b4  */
    /* JADX WARN: Code duplicated, block: B:36:0x00db  */
    /* JADX WARN: Code duplicated, block: B:42:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    public final Object insertJobIdToWorkIdRelation(JobIdToWorkIdRelation jobIdToWorkIdRelation, Continuation<? super Result<Long, CacheError.SaveError>> continuation) {
        C11911 c11911;
        Result.Error error;
        if (continuation instanceof C11911) {
            c11911 = (C11911) continuation;
            if ((c11911.label & Integer.MIN_VALUE) != 0) {
                c11911.label -= Integer.MIN_VALUE;
            } else {
                c11911 = new C11911(continuation);
            }
        } else {
            c11911 = new C11911(continuation);
        }
        Object objWithTransaction = c11911.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = c11911.label;
        try {
            if (i == 0) {
                ResultKt.throwOnFailure(objWithTransaction);
                error = this.userData.getBoxDatabase();
                if (error instanceof Result.Success) {
                    BoxDatabase boxDatabase = (BoxDatabase) ((Result.Success) error).getValue();
                    JobsDataSource$insertJobIdToWorkIdRelation$2$1$1 jobsDataSource$insertJobIdToWorkIdRelation$2$1$1 = new JobsDataSource$insertJobIdToWorkIdRelation$2$1$1(boxDatabase, jobIdToWorkIdRelation, null);
                    c11911.L$0 = SpillingKt.nullOutSpilledVariable(jobIdToWorkIdRelation);
                    c11911.L$1 = SpillingKt.nullOutSpilledVariable(error);
                    c11911.L$2 = SpillingKt.nullOutSpilledVariable(boxDatabase);
                    c11911.I$0 = 0;
                    c11911.I$1 = 0;
                    c11911.I$2 = 0;
                    c11911.I$3 = 0;
                    c11911.label = 1;
                    objWithTransaction = RoomDatabaseKt.withTransaction(boxDatabase, jobsDataSource$insertJobIdToWorkIdRelation$2$1$1, c11911);
                    if (objWithTransaction == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                } else if (!(error instanceof Result.Error)) {
                    throw new NoWhenBranchMatchedException();
                }
                if (error instanceof Result.Success) {
                    return error;
                }
                if (error instanceof Result.Error) {
                    BoxLogUtils.e(ExtensionsKt.getTAG(this), "Error while inserting jobIdToWorkIdRelation: " + ((Result.Error) error).getValue());
                    return new Result.Error(CacheError.SaveError.INSTANCE);
                }
                throw new NoWhenBranchMatchedException();
            }
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            int i2 = c11911.I$3;
            int i3 = c11911.I$2;
            int i4 = c11911.I$1;
            int i5 = c11911.I$0;
            ResultKt.throwOnFailure(objWithTransaction);
            error = new Result.Success(Boxing.boxLong(((Number) objWithTransaction).longValue()));
        } catch (Exception e) {
            error = new Result.Error(e);
        }
        if (error instanceof Result.Success) {
            return error;
        }
        if (error instanceof Result.Error) {
            BoxLogUtils.e(ExtensionsKt.getTAG(this), "Error while inserting jobIdToWorkIdRelation: " + ((Result.Error) error).getValue());
            return new Result.Error(CacheError.SaveError.INSTANCE);
        }
        throw new NoWhenBranchMatchedException();
    }

    /* JADX WARN: Code duplicated, block: B:33:0x00a4  */
    /* JADX WARN: Code duplicated, block: B:35:0x00a8  */
    /* JADX WARN: Code duplicated, block: B:37:0x00d9  */
    /* JADX WARN: Code duplicated, block: B:43:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    public final Object getLogData(JobId jobId, Continuation<? super Result<Data, ? extends CacheError>> continuation) {
        C11821 c11821;
        Result.Error error;
        Result<BoxDatabase, CacheError> boxDatabase;
        if (continuation instanceof C11821) {
            c11821 = (C11821) continuation;
            if ((c11821.label & Integer.MIN_VALUE) != 0) {
                c11821.label -= Integer.MIN_VALUE;
            } else {
                c11821 = new C11821(continuation);
            }
        } else {
            c11821 = new C11821(continuation);
        }
        Object logData = c11821.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = c11821.label;
        try {
            if (i == 0) {
                ResultKt.throwOnFailure(logData);
                boxDatabase = this.userData.getBoxDatabase();
                if (boxDatabase instanceof Result.Success) {
                    BoxDatabase boxDatabase2 = (BoxDatabase) ((Result.Success) boxDatabase).getValue();
                    JobsDao jobsDao = boxDatabase2.jobsDao();
                    c11821.L$0 = jobId;
                    c11821.L$1 = SpillingKt.nullOutSpilledVariable(boxDatabase);
                    c11821.L$2 = SpillingKt.nullOutSpilledVariable(boxDatabase2);
                    c11821.I$0 = 0;
                    c11821.I$1 = 0;
                    c11821.I$2 = 0;
                    c11821.I$3 = 0;
                    c11821.label = 1;
                    logData = jobsDao.getLogData(jobId, c11821);
                    if (logData == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                } else if (!(boxDatabase instanceof Result.Error)) {
                    throw new NoWhenBranchMatchedException();
                }
                if (boxDatabase instanceof Result.Success) {
                    return boxDatabase;
                }
                if (boxDatabase instanceof Result.Error) {
                    BoxLogUtils.e(ExtensionsKt.getTAG(this), "Error while retrieving log data for job " + jobId + ": " + ((Result.Error) boxDatabase).getValue());
                    return new Result.Error(CacheError.ReadError.INSTANCE);
                }
                throw new NoWhenBranchMatchedException();
            }
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            int i2 = c11821.I$3;
            int i3 = c11821.I$2;
            int i4 = c11821.I$1;
            int i5 = c11821.I$0;
            jobId = (JobId) c11821.L$0;
            ResultKt.throwOnFailure(logData);
            error = new Result.Success(Data.INSTANCE.fromByteArray((byte[]) logData));
        } catch (Exception e) {
            error = new Result.Error(e);
        }
        boxDatabase = error;
        if (boxDatabase instanceof Result.Success) {
            return boxDatabase;
        }
        if (boxDatabase instanceof Result.Error) {
            BoxLogUtils.e(ExtensionsKt.getTAG(this), "Error while retrieving log data for job " + jobId + ": " + ((Result.Error) boxDatabase).getValue());
            return new Result.Error(CacheError.ReadError.INSTANCE);
        }
        throw new NoWhenBranchMatchedException();
    }

    /* JADX WARN: Code duplicated, block: B:37:0x0129 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:38:0x012a  */
    /* JADX WARN: Code duplicated, block: B:40:0x012e  */
    /* JADX WARN: Code duplicated, block: B:42:0x0160  */
    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x0108, code lost:
    
        if (r10.updateLogDataOfJob(r13, r9, r0) == r1) goto L26;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object updateLogData(com.box.android.domain.jobs.JobId r13, java.util.Map<java.lang.String, ? extends java.lang.Object> r14, kotlin.coroutines.Continuation<? super com.box.android.domain.utils.result.Result<kotlin.Unit, ? extends com.box.android.data.datasource.CacheError>> r15) {
        /*
            Method dump skipped, instruction units count: 364
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.box.android.data.datasource.jobs.JobsDataSource.updateLogData(com.box.android.domain.jobs.JobId, java.util.Map, kotlin.coroutines.Continuation):java.lang.Object");
    }
}
