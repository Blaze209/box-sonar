package com.box.android.data.jobs;

import com.box.android.coreservices.jobmanager.JobItem;
import com.box.android.coreservices.jobmanager.JobManager;
import com.box.android.coreservices.jobmanager.jobcollections.BoxJobCollection;
import com.box.android.coreservices.jobmanager.jobcollections.OfflineBoxJobCollection;
import com.box.android.coreservices.jobmanager.jobcollections.RemoveOfflineBoxJobCollection;
import com.box.android.coreservices.jobmanager.jobs.BoxItemJob;
import com.box.android.coreservices.jobmanager.jobs.BoxJob;
import com.box.android.domain.jobs.JobId;
import com.box.android.domain.jobs.JobType;
import com.box.android.domain.mappers.ItemModelMapper;
import com.box.android.domain.models.DomainError;
import com.box.android.domain.models.ItemDescriptor;
import com.box.android.domain.models.JobInfo;
import com.box.android.domain.models.LegacyJobModel;
import com.box.android.domain.models.item.ItemModel;
import com.box.android.domain.services.IJobManagerBridgeService;
import com.box.android.domain.utils.result.Result;
import com.box.androidsdk.content.models.BoxCollection;
import com.box.androidsdk.content.models.BoxItem;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.FlowKt;

/* JADX INFO: compiled from: JobManagerBridgeService.kt */
/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000p\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010#\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\b\u0016\u0018\u0000 *2\u00020\u0001:\u0001*B\u001b\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0001\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J;\u0010\u000b\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u000f0\r0\f2\u0006\u0010\u0010\u001a\u00020\n2\u0012\u0010\u0011\u001a\n\u0012\u0006\b\u0001\u0012\u00020\n0\u0012\"\u00020\nH\u0016¢\u0006\u0002\u0010\u0013J\u0018\u0010\u0014\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00160\u00152\u0006\u0010\u0017\u001a\u00020\nH\u0002J \u0010\u0018\u001a\u0014\u0012\u0004\u0012\u00020\n\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001b0\u001a0\u0019H\u0096@¢\u0006\u0002\u0010\u001cJ\u001a\u0010\u001d\u001a\u0004\u0018\u00010\u001e2\u0006\u0010\u001f\u001a\u00020\n2\b\u0010 \u001a\u0004\u0018\u00010\nJ(\u0010!\u001a\u00020\"2\u0006\u0010\u001f\u001a\u00020\n2\b\u0010 \u001a\u0004\u0018\u00010\n2\u0006\u0010#\u001a\u00020$H\u0096@¢\u0006\u0002\u0010%J \u0010&\u001a\u00020\"2\u0006\u0010\u001f\u001a\u00020\n2\b\u0010 \u001a\u0004\u0018\u00010\nH\u0096@¢\u0006\u0002\u0010'J,\u0010(\u001a\u000e\u0012\u0004\u0012\u00020\"\u0012\u0004\u0012\u00020\u000f0\r2\u0006\u0010\u001f\u001a\u00020\n2\b\u0010 \u001a\u0004\u0018\u00010\nH\u0096@¢\u0006\u0002\u0010'J\u001c\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u000e0\f*\u00020\u001e2\b\u0010)\u001a\u0004\u0018\u00010\u0016H\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\tX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006+"}, d2 = {"Lcom/box/android/data/jobs/JobManagerBridgeService;", "Lcom/box/android/domain/services/IJobManagerBridgeService;", "jobManager", "Lcom/box/android/coreservices/jobmanager/JobManager;", "dispatcher", "Lkotlinx/coroutines/CoroutineDispatcher;", "<init>", "(Lcom/box/android/coreservices/jobmanager/JobManager;Lkotlinx/coroutines/CoroutineDispatcher;)V", "userCancelledJobs", "", "", "getJobStatus", "Lkotlinx/coroutines/flow/Flow;", "Lcom/box/android/domain/utils/result/Result;", "Lcom/box/android/domain/models/JobInfo$Status;", "Lcom/box/android/domain/models/DomainError;", "fileID", "jobTypes", "", "(Ljava/lang/String;[Ljava/lang/String;)Lkotlinx/coroutines/flow/Flow;", "getJobCollectionType", "Lkotlin/reflect/KClass;", "Lcom/box/android/coreservices/jobmanager/jobcollections/BoxJobCollection;", "jobtype", "getJobsGrouped", "", "", "Lcom/box/android/domain/models/LegacyJobModel;", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getJob", "Lcom/box/android/coreservices/jobmanager/jobs/BoxJob;", JobWorker.JOB_ID_PARAM, "groupId", "retryJob", "", "isFailure", "", "(Ljava/lang/String;Ljava/lang/String;ZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "forceCancelJob", "(Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "cancelJob", BoxCollection.TYPE, "Companion", "data_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public class JobManagerBridgeService implements IJobManagerBridgeService {
    public static final long POLL_DELAY_MS = 500;
    private final CoroutineDispatcher dispatcher;
    private final JobManager jobManager;
    private final Set<String> userCancelledJobs;

    /* JADX INFO: renamed from: com.box.android.data.jobs.JobManagerBridgeService$cancelJob$1, reason: invalid class name */
    /* JADX INFO: compiled from: JobManagerBridgeService.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.box.android.data.jobs.JobManagerBridgeService", f = "JobManagerBridgeService.kt", i = {0, 0, 0, 0, 0, 0, 0}, l = {122}, m = "cancelJob$suspendImpl", n = {"$this", JobWorker.JOB_ID_PARAM, "groupId", "boxJob", "it", "$i$a$-let-JobManagerBridgeService$cancelJob$2", "isSuccessJob"}, s = {"L$0", "L$1", "L$2", "L$3", "L$4", "I$0", "I$1"}, v = 1)
    static final class AnonymousClass1 extends ContinuationImpl {
        int I$0;
        int I$1;
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        Object L$4;
        int label;
        /* synthetic */ Object result;

        AnonymousClass1(Continuation<? super AnonymousClass1> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return JobManagerBridgeService.cancelJob$suspendImpl(JobManagerBridgeService.this, null, null, this);
        }
    }

    @Override // com.box.android.domain.services.IJobManagerBridgeService
    public Object cancelJob(String str, String str2, Continuation<? super Result<Unit, ? extends DomainError>> continuation) {
        return cancelJob$suspendImpl(this, str, str2, continuation);
    }

    @Override // com.box.android.domain.services.IJobManagerBridgeService
    public Object forceCancelJob(String str, String str2, Continuation<? super Unit> continuation) {
        return forceCancelJob$suspendImpl(this, str, str2, continuation);
    }

    @Override // com.box.android.domain.services.IJobManagerBridgeService
    public Object getJobsGrouped(Continuation<? super Map<String, ? extends List<LegacyJobModel>>> continuation) {
        return getJobsGrouped$suspendImpl(this, continuation);
    }

    @Override // com.box.android.domain.services.IJobManagerBridgeService
    public Object retryJob(String str, String str2, boolean z, Continuation<? super Unit> continuation) {
        return retryJob$suspendImpl(this, str, str2, z, continuation);
    }

    @Inject
    public JobManagerBridgeService(JobManager jobManager, CoroutineDispatcher dispatcher) {
        Intrinsics.checkNotNullParameter(jobManager, "jobManager");
        Intrinsics.checkNotNullParameter(dispatcher, "dispatcher");
        this.jobManager = jobManager;
        this.dispatcher = dispatcher;
        this.userCancelledJobs = new LinkedHashSet();
    }

    /* JADX WARN: Code duplicated, block: B:19:0x0051 A[LOOP:0: B:3:0x000c->B:19:0x0051, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:42:0x005b A[EDGE_INSN: B:42:0x005b->B:20:0x005b BREAK  A[LOOP:0: B:3:0x000c->B:19:0x0051], SYNTHETIC] */
    @Override // com.box.android.domain.services.IJobManagerBridgeService
    public Flow<Result<JobInfo.Status, DomainError>> getJobStatus(String fileID, String... jobTypes) throws InterruptedException {
        BoxJobCollection next;
        BoxJob next2;
        final Flow<JobInfo.Status> jobStatus;
        Intrinsics.checkNotNullParameter(fileID, "fileID");
        Intrinsics.checkNotNullParameter(jobTypes, "jobTypes");
        long j = 0;
        loop0: while (true) {
            List<BoxJobCollection> allJobCollections = this.jobManager.getAllJobCollections();
            Intrinsics.checkNotNullExpressionValue(allJobCollections, "getAllJobCollections(...)");
            List<BoxJobCollection> list = allJobCollections;
            if ((list instanceof Collection) && list.isEmpty()) {
                if (j < 1000) {
                    break;
                    break;
                }
                Thread.sleep(100L);
                j += (long) 100;
            } else {
                for (BoxJobCollection boxJobCollection : list) {
                    for (String str : jobTypes) {
                        if (getJobCollectionType(str).isInstance(boxJobCollection)) {
                            break loop0;
                        }
                    }
                }
                if (j < 1000) {
                    break;
                }
                Thread.sleep(100L);
                j += (long) 100;
            }
        }
        Iterator<BoxJobCollection> it = this.jobManager.getAllJobCollections().iterator();
        loop1: while (true) {
            if (!it.hasNext()) {
                next = null;
                next2 = null;
                break;
            }
            next = it.next();
            Iterator<BoxJob> it2 = next.getChildJobItems().iterator();
            while (it2.hasNext()) {
                next2 = it2.next();
                if ((next2 instanceof BoxItemJob) && Intrinsics.areEqual(((BoxItemJob) next2).getBoxItemId(), fileID) && ArraysKt.contains(jobTypes, JobManagerBridgeServiceKt.getJobType(next2))) {
                    break loop1;
                }
            }
        }
        if (next2 == null || (jobStatus = getJobStatus(next2, next)) == null) {
            return FlowKt.flowOf(new Result.Error(new DomainError.NoResultFoundError(null, 1, null)));
        }
        return new Flow<Result.Success<? extends JobInfo.Status>>() { // from class: com.box.android.data.jobs.JobManagerBridgeService$getJobStatus$$inlined$map$1

            /* JADX INFO: renamed from: com.box.android.data.jobs.JobManagerBridgeService$getJobStatus$$inlined$map$1$2, reason: invalid class name */
            /* JADX INFO: compiled from: Emitters.kt */
            @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
            public static final class AnonymousClass2<T> implements FlowCollector {
                final /* synthetic */ FlowCollector $this_unsafeFlow;

                /* JADX INFO: renamed from: com.box.android.data.jobs.JobManagerBridgeService$getJobStatus$$inlined$map$1$2$1, reason: invalid class name */
                @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
                @DebugMetadata(c = "com.box.android.data.jobs.JobManagerBridgeService$getJobStatus$$inlined$map$1$2", f = "JobManagerBridgeService.kt", i = {0, 0, 0, 0, 0}, l = {50}, m = "emit", n = {"value", "$completion", "value", "$this$map_u24lambda_u245", "$i$a$-unsafeTransform-FlowKt__TransformKt$map$1"}, s = {"L$0", "L$1", "L$2", "L$3", "I$0"}, v = 1)
                public static final class AnonymousClass1 extends ContinuationImpl {
                    int I$0;
                    Object L$0;
                    Object L$1;
                    Object L$2;
                    Object L$3;
                    int label;
                    /* synthetic */ Object result;

                    public AnonymousClass1(Continuation continuation) {
                        super(continuation);
                    }

                    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                    public final Object invokeSuspend(Object obj) {
                        this.result = obj;
                        this.label |= Integer.MIN_VALUE;
                        return AnonymousClass2.this.emit(null, this);
                    }
                }

                public AnonymousClass2(FlowCollector flowCollector) {
                    this.$this_unsafeFlow = flowCollector;
                }

                /* JADX WARN: Code duplicated, block: B:7:0x0014  */
                @Override // kotlinx.coroutines.flow.FlowCollector
                public final Object emit(Object obj, Continuation continuation) {
                    AnonymousClass1 anonymousClass1;
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
                    Object obj2 = anonymousClass1.result;
                    Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                    int i = anonymousClass1.label;
                    if (i == 0) {
                        ResultKt.throwOnFailure(obj2);
                        FlowCollector flowCollector = this.$this_unsafeFlow;
                        Result.Success success = new Result.Success((JobInfo.Status) obj);
                        anonymousClass1.L$0 = SpillingKt.nullOutSpilledVariable(obj);
                        anonymousClass1.L$1 = SpillingKt.nullOutSpilledVariable(anonymousClass1);
                        anonymousClass1.L$2 = SpillingKt.nullOutSpilledVariable(obj);
                        anonymousClass1.L$3 = SpillingKt.nullOutSpilledVariable(flowCollector);
                        anonymousClass1.I$0 = 0;
                        anonymousClass1.label = 1;
                        if (flowCollector.emit(success, anonymousClass1) == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                    } else {
                        if (i != 1) {
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                        int i2 = anonymousClass1.I$0;
                        Object obj3 = anonymousClass1.L$2;
                        Object obj4 = anonymousClass1.L$0;
                        ResultKt.throwOnFailure(obj2);
                    }
                    return Unit.INSTANCE;
                }
            }

            @Override // kotlinx.coroutines.flow.Flow
            public Object collect(FlowCollector<? super Result.Success<? extends JobInfo.Status>> flowCollector, Continuation continuation) {
                Object objCollect = jobStatus.collect(new AnonymousClass2(flowCollector), continuation);
                return objCollect == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objCollect : Unit.INSTANCE;
            }
        };
    }

    private final KClass<? extends BoxJobCollection> getJobCollectionType(String jobtype) {
        if (Intrinsics.areEqual(jobtype, JobType.OFFLINE_FILE)) {
            return Reflection.getOrCreateKotlinClass(OfflineBoxJobCollection.class);
        }
        return Intrinsics.areEqual(jobtype, JobType.REMOVE_OFFLINE_JOB) ? Reflection.getOrCreateKotlinClass(RemoveOfflineBoxJobCollection.class) : Reflection.getOrCreateKotlinClass(BoxJobCollection.class);
    }

    /* JADX INFO: renamed from: com.box.android.data.jobs.JobManagerBridgeService$getJobsGrouped$2, reason: invalid class name */
    /* JADX INFO: compiled from: JobManagerBridgeService.kt */
    @Metadata(d1 = {"\u0000\u0016\n\u0000\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u0014\u0012\u0004\u0012\u00020\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u00030\u0001*\u00020\u0005H\n"}, d2 = {"<anonymous>", "", "", "", "Lcom/box/android/domain/models/LegacyJobModel;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.box.android.data.jobs.JobManagerBridgeService$getJobsGrouped$2", f = "JobManagerBridgeService.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {}, v = 1)
    static final class AnonymousClass2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Map<String, List<? extends LegacyJobModel>>>, Object> {
        int label;

        AnonymousClass2(Continuation<? super AnonymousClass2> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return JobManagerBridgeService.this.new AnonymousClass2(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Object invoke(CoroutineScope coroutineScope, Continuation<? super Map<String, List<? extends LegacyJobModel>>> continuation) {
            return invoke2(coroutineScope, (Continuation<? super Map<String, List<LegacyJobModel>>>) continuation);
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(CoroutineScope coroutineScope, Continuation<? super Map<String, List<LegacyJobModel>>> continuation) {
            return ((AnonymousClass2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            ItemDescriptor.ExistingBoxItem existingBoxItem;
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            List<BoxJobCollection> allJobCollections = JobManagerBridgeService.this.jobManager.getAllJobCollections();
            Intrinsics.checkNotNull(allJobCollections);
            JobManagerBridgeService jobManagerBridgeService = JobManagerBridgeService.this;
            for (BoxJobCollection boxJobCollection : allJobCollections) {
                String id = boxJobCollection.getId();
                List<BoxJob> childJobItems = boxJobCollection.getChildJobItems();
                Intrinsics.checkNotNullExpressionValue(childJobItems, "getChildJobItems(...)");
                ArrayList arrayList = new ArrayList();
                for (BoxJob boxJob : childJobItems) {
                    String id2 = boxJob.getId();
                    Intrinsics.checkNotNullExpressionValue(id2, "getId(...)");
                    JobId jobId = new JobId(id2);
                    Intrinsics.checkNotNull(boxJob);
                    String jobType = JobManagerBridgeServiceKt.getJobType(boxJob);
                    Intrinsics.checkNotNullExpressionValue(jobType, "getJobType(...)");
                    JobInfo jobInfo = new JobInfo(jobId, jobType, null, jobManagerBridgeService.getJobStatus(boxJob, boxJobCollection));
                    BoxItem boxItem = ((BoxItemJob) boxJob).getBoxItem();
                    if (boxItem != null) {
                        ItemModel itemModel = ItemModelMapper.INSTANCE.toItemModel(boxItem);
                        Intrinsics.checkNotNull(itemModel);
                        existingBoxItem = new ItemDescriptor.ExistingBoxItem(itemModel);
                    } else {
                        existingBoxItem = null;
                    }
                    LegacyJobModel legacyJobModel = existingBoxItem != null ? new LegacyJobModel(existingBoxItem, jobInfo) : null;
                    if (legacyJobModel != null) {
                        arrayList.add(legacyJobModel);
                    }
                }
                linkedHashMap.put(id, arrayList);
            }
            return linkedHashMap;
        }
    }

    static /* synthetic */ Object getJobsGrouped$suspendImpl(JobManagerBridgeService jobManagerBridgeService, Continuation<? super Map<String, ? extends List<LegacyJobModel>>> continuation) {
        return BuildersKt.withContext(jobManagerBridgeService.dispatcher, jobManagerBridgeService.new AnonymousClass2(null), continuation);
    }

    public final BoxJob getJob(String jobId, String groupId) {
        Intrinsics.checkNotNullParameter(jobId, "jobId");
        if (groupId != null) {
            BoxJobCollection jobCollection = this.jobManager.getJobCollection(groupId);
            if (jobCollection != null) {
                return jobCollection.getJob(jobId);
            }
            return null;
        }
        List<BoxJobCollection> allJobCollections = this.jobManager.getAllJobCollections();
        Intrinsics.checkNotNullExpressionValue(allJobCollections, "getAllJobCollections(...)");
        Iterator<T> it = allJobCollections.iterator();
        while (it.hasNext()) {
            BoxJob job = ((BoxJobCollection) it.next()).getJob(jobId);
            if (job != null) {
                return job;
            }
        }
        return null;
    }

    static /* synthetic */ Object retryJob$suspendImpl(JobManagerBridgeService jobManagerBridgeService, String str, String str2, boolean z, Continuation<? super Unit> continuation) {
        BoxJob job = jobManagerBridgeService.getJob(str, str2);
        if (job != null) {
            Boxing.boxBoolean(job.restart(z));
        }
        return Unit.INSTANCE;
    }

    static /* synthetic */ Object forceCancelJob$suspendImpl(JobManagerBridgeService jobManagerBridgeService, String str, String str2, Continuation<? super Unit> continuation) {
        jobManagerBridgeService.userCancelledJobs.add(str);
        BoxJob job = jobManagerBridgeService.getJob(str, str2);
        if (job != null) {
            job.cancel();
        }
        return Unit.INSTANCE;
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    static /* synthetic */ Object cancelJob$suspendImpl(JobManagerBridgeService jobManagerBridgeService, String str, String str2, Continuation<? super Result<Unit, ? extends DomainError>> continuation) {
        AnonymousClass1 anonymousClass1;
        JobItem.JobItemState currentState;
        if (continuation instanceof AnonymousClass1) {
            anonymousClass1 = (AnonymousClass1) continuation;
            if ((anonymousClass1.label & Integer.MIN_VALUE) != 0) {
                anonymousClass1.label -= Integer.MIN_VALUE;
            } else {
                anonymousClass1 = jobManagerBridgeService.new AnonymousClass1(continuation);
            }
        } else {
            anonymousClass1 = jobManagerBridgeService.new AnonymousClass1(continuation);
        }
        Object obj = anonymousClass1.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = anonymousClass1.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            BoxJob job = jobManagerBridgeService.getJob(str, str2);
            if (job != null && (currentState = job.getCurrentState()) != null) {
                int i2 = (currentState != JobItem.JobItemState.COMPLETED || job.hasError()) ? 0 : 1;
                if (i2 == 0) {
                    anonymousClass1.L$0 = SpillingKt.nullOutSpilledVariable(jobManagerBridgeService);
                    anonymousClass1.L$1 = SpillingKt.nullOutSpilledVariable(str);
                    anonymousClass1.L$2 = SpillingKt.nullOutSpilledVariable(str2);
                    anonymousClass1.L$3 = SpillingKt.nullOutSpilledVariable(job);
                    anonymousClass1.L$4 = SpillingKt.nullOutSpilledVariable(currentState);
                    anonymousClass1.I$0 = 0;
                    anonymousClass1.I$1 = i2;
                    anonymousClass1.label = 1;
                    if (jobManagerBridgeService.forceCancelJob(str, str2, anonymousClass1) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                } else {
                    return new Result.Error(new DomainError.CacheWriteError("attempted to delete job that is successful"));
                }
            } else {
                return new Result.Error(new DomainError.CacheWriteError("attempted to delete job that no longer exists"));
            }
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            int i3 = anonymousClass1.I$1;
            int i4 = anonymousClass1.I$0;
            ResultKt.throwOnFailure(obj);
        }
        return new Result.Success(Unit.INSTANCE);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Flow<JobInfo.Status> getJobStatus(BoxJob boxJob, BoxJobCollection boxJobCollection) {
        return JobManagerBridgeServiceKt.getJobStatus(boxJob, boxJobCollection, this.userCancelledJobs);
    }
}
