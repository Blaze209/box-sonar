package com.box.android.data.jobs;

import com.box.android.common.utilities.BoxCommonConstants;
import com.box.android.coreservices.jobmanager.JobItem;
import com.box.android.coreservices.jobmanager.ParentJobItem;
import com.box.android.coreservices.jobmanager.dao.ProgressReporter;
import com.box.android.coreservices.jobmanager.jobcollections.BoxJobCollection;
import com.box.android.coreservices.jobmanager.jobs.BoxJob;
import com.box.android.coreservices.jobmanager.jobs.DeleteBoxJob;
import com.box.android.coreservices.jobmanager.jobs.ExportBoxJob;
import com.box.android.coreservices.jobmanager.jobs.OfflineBoxJob;
import com.box.android.coreservices.jobmanager.jobs.RemoveOfflineBoxJob;
import com.box.android.domain.jobs.JobType;
import com.box.android.domain.models.JobInfo;
import com.box.androidsdk.content.models.BoxCollection;
import com.box.androidsdk.content.utils.BoxLogUtils;
import external.sdk.pendo.io.mozilla.javascript.Context;
import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.SetsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.DelayKt;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.FlowKt;

/* JADX INFO: compiled from: JobManagerBridgeService.kt */
/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000P\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\"\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u001a\f\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u0002\u001a\u0012\u0010\u0003\u001a\n \u0005*\u0004\u0018\u00010\u00040\u0004*\u00020\u0006\u001a.\u0010\u0007\u001a\u00020\b*\b\u0012\u0004\u0012\u00020\n0\t2\u0006\u0010\u000b\u001a\u00020\f2\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00040\u000eH\u0082@¢\u0006\u0002\u0010\u000f\u001a \u0010\u0010\u001a\u00020\b*\b\u0012\u0004\u0012\u00020\n0\t2\u0006\u0010\u000b\u001a\u00020\u0011H\u0082@¢\u0006\u0002\u0010\u0012\u001a2\u0010\u0013\u001a\u00020\b*\b\u0012\u0004\u0012\u00020\n0\t2\u0006\u0010\u000b\u001a\u00020\f2\b\u0010\u0014\u001a\u0004\u0018\u00010\u00152\u0006\u0010\u0016\u001a\u00020\u0017H\u0082@¢\u0006\u0002\u0010\u0018\u001a,\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\n0\u001a*\u00020\u00112\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u00152\u000e\b\u0002\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00040\u000e¨\u0006\u001b"}, d2 = {"toJobProgress", "Lcom/box/android/domain/models/JobInfo$Progress;", "", "getJobType", "", "kotlin.jvm.PlatformType", "Lcom/box/android/coreservices/jobmanager/jobs/BoxJob;", "processCancellation", "", "Lkotlinx/coroutines/flow/FlowCollector;", "Lcom/box/android/domain/models/JobInfo$Status;", "jobItem", "Lcom/box/android/coreservices/jobmanager/JobItem;", "userCancelledJobs", "", "(Lkotlinx/coroutines/flow/FlowCollector;Lcom/box/android/coreservices/jobmanager/JobItem;Ljava/util/Set;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "processCompletion", "Lcom/box/android/coreservices/jobmanager/ParentJobItem;", "(Lkotlinx/coroutines/flow/FlowCollector;Lcom/box/android/coreservices/jobmanager/ParentJobItem;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "processProgress", BoxCollection.TYPE, "Lcom/box/android/coreservices/jobmanager/jobcollections/BoxJobCollection;", "isPaused", "", "(Lkotlinx/coroutines/flow/FlowCollector;Lcom/box/android/coreservices/jobmanager/JobItem;Lcom/box/android/coreservices/jobmanager/jobcollections/BoxJobCollection;ZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getJobStatus", "Lkotlinx/coroutines/flow/Flow;", "data_generalProdRelease"}, k = 2, mv = {2, 2, 0}, xi = 48)
public final class JobManagerBridgeServiceKt {

    /* JADX INFO: renamed from: com.box.android.data.jobs.JobManagerBridgeServiceKt$processCompletion$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: JobManagerBridgeService.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.box.android.data.jobs.JobManagerBridgeServiceKt", f = "JobManagerBridgeService.kt", i = {0, 0, 1, 1, 1, 1, 1, 1, 2, 2, 3, 3}, l = {Context.VERSION_1_7, 175, 177, 180}, m = "processCompletion", n = {"$this$processCompletion", "jobItem", "$this$processCompletion", "jobItem", "it", "it", "$i$a$-let-JobManagerBridgeServiceKt$processCompletion$2", "$i$a$-let-JobManagerBridgeServiceKt$processCompletion$2$2", "$this$processCompletion", "jobItem", "$this$processCompletion", "jobItem"}, s = {"L$0", "L$1", "L$0", "L$1", "L$2", "L$3", "I$0", "I$1", "L$0", "L$1", "L$0", "L$1"}, v = 1)
    static final class C12601 extends ContinuationImpl {
        int I$0;
        int I$1;
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        int label;
        /* synthetic */ Object result;

        C12601(Continuation<? super C12601> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return JobManagerBridgeServiceKt.processCompletion(null, null, this);
        }
    }

    public static final JobInfo.Progress toJobProgress(long j) {
        if (j > 0) {
            return new JobInfo.Progress(j, 100.0d);
        }
        return null;
    }

    public static final String getJobType(BoxJob boxJob) {
        Intrinsics.checkNotNullParameter(boxJob, "<this>");
        if (boxJob instanceof DeleteBoxJob) {
            return JobType.DELETE_FILE;
        }
        if (boxJob instanceof ExportBoxJob) {
            return JobType.DOWNLOAD_FILE_LEGACY;
        }
        if (boxJob instanceof OfflineBoxJob) {
            return JobType.OFFLINE_FILE;
        }
        if (boxJob instanceof RemoveOfflineBoxJob) {
            return JobType.REMOVE_OFFLINE_JOB;
        }
        BoxLogUtils.e("Need to handle mapping job type for " + boxJob);
        return boxJob.getClass().getSimpleName();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Object processCancellation(FlowCollector<? super JobInfo.Status> flowCollector, JobItem jobItem, Set<String> set, Continuation<? super Unit> continuation) {
        if (!set.contains(jobItem.getId())) {
            Object objEmit = flowCollector.emit(JobInfo.Status.Succeeded.INSTANCE, continuation);
            return objEmit == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objEmit : Unit.INSTANCE;
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:7:0x001a  */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x009f, code lost:
    
        if (r18.emit(r2, r3) == r4) goto L50;
     */
    /* JADX WARN: Code restructure failed: missing block: B:39:0x0129, code lost:
    
        if (r18.emit(r6, r3) == r4) goto L50;
     */
    /* JADX WARN: Code restructure failed: missing block: B:44:0x015a, code lost:
    
        if (r18.emit(r2, r3) == r4) goto L50;
     */
    /* JADX WARN: Code restructure failed: missing block: B:49:0x0174, code lost:
    
        if (r18.emit(r2, r3) == r4) goto L50;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final java.lang.Object processCompletion(kotlinx.coroutines.flow.FlowCollector<? super com.box.android.domain.models.JobInfo.Status> r18, com.box.android.coreservices.jobmanager.ParentJobItem r19, kotlin.coroutines.Continuation<? super kotlin.Unit> r20) {
        /*
            Method dump skipped, instruction units count: 378
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.box.android.data.jobs.JobManagerBridgeServiceKt.processCompletion(kotlinx.coroutines.flow.FlowCollector, com.box.android.coreservices.jobmanager.ParentJobItem, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Object processProgress(FlowCollector<? super JobInfo.Status> flowCollector, JobItem jobItem, BoxJobCollection boxJobCollection, boolean z, Continuation<? super Unit> continuation) {
        List<BoxJob> childJobItems;
        long progress = jobItem.getProgress(ProgressReporter.ProgressType.PERCENTAGE);
        Long lBoxLong = boxJobCollection != null ? Boxing.boxLong(boxJobCollection.getProgress(ProgressReporter.ProgressType.PERCENTAGE)) : null;
        if (progress > 0) {
            lBoxLong = Boxing.boxLong(progress);
        } else if (boxJobCollection == null || (childJobItems = boxJobCollection.getChildJobItems()) == null || childJobItems.size() != 1) {
            lBoxLong = null;
        }
        JobInfo.Progress jobProgress = lBoxLong != null ? toJobProgress(lBoxLong.longValue()) : null;
        if (z) {
            Object objEmit = flowCollector.emit(new JobInfo.Status.Paused(jobProgress), continuation);
            return objEmit == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objEmit : Unit.INSTANCE;
        }
        Object objEmit2 = flowCollector.emit(new JobInfo.Status.Running(jobProgress), continuation);
        return objEmit2 == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objEmit2 : Unit.INSTANCE;
    }

    public static /* synthetic */ Flow getJobStatus$default(ParentJobItem parentJobItem, BoxJobCollection boxJobCollection, Set set, int i, Object obj) {
        if ((i & 1) != 0) {
            boxJobCollection = null;
        }
        if ((i & 2) != 0) {
            set = SetsKt.emptySet();
        }
        return getJobStatus(parentJobItem, boxJobCollection, set);
    }

    /* JADX INFO: renamed from: com.box.android.data.jobs.JobManagerBridgeServiceKt$getJobStatus$1, reason: invalid class name */
    /* JADX INFO: compiled from: JobManagerBridgeService.kt */
    @Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\b\u0012\u0004\u0012\u00020\u00030\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/flow/FlowCollector;", "Lcom/box/android/domain/models/JobInfo$Status;"}, k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.box.android.data.jobs.JobManagerBridgeServiceKt$getJobStatus$1", f = "JobManagerBridgeService.kt", i = {0, 0, 1, 1, 2, 2, 3, 3, 4, 4, 5, 5}, l = {209, BoxCommonConstants.REQUEST_OPTIONS, BoxCommonConstants.REQUEST_DELETE, BoxCommonConstants.REQUEST_RENAME, 213, 218}, m = "invokeSuspend", n = {"$this$flow", "state", "$this$flow", "state", "$this$flow", "state", "$this$flow", "state", "$this$flow", "state", "$this$flow", "state"}, s = {"L$0", "L$1", "L$0", "L$1", "L$0", "L$1", "L$0", "L$1", "L$0", "L$1", "L$0", "L$1"}, v = 1)
    static final class AnonymousClass1 extends SuspendLambda implements Function2<FlowCollector<? super JobInfo.Status>, Continuation<? super Unit>, Object> {
        final /* synthetic */ BoxJobCollection $collection;
        final /* synthetic */ ParentJobItem $jobItem;
        final /* synthetic */ Set<String> $userCancelledJobs;
        private /* synthetic */ Object L$0;
        Object L$1;
        int label;

        /* JADX INFO: renamed from: com.box.android.data.jobs.JobManagerBridgeServiceKt$getJobStatus$1$WhenMappings */
        /* JADX INFO: compiled from: JobManagerBridgeService.kt */
        @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
        public static final /* synthetic */ class WhenMappings {
            public static final /* synthetic */ int[] $EnumSwitchMapping$0;

            static {
                int[] iArr = new int[JobItem.JobItemState.values().length];
                try {
                    iArr[JobItem.JobItemState.COMPLETED.ordinal()] = 1;
                } catch (NoSuchFieldError unused) {
                }
                try {
                    iArr[JobItem.JobItemState.EXECUTING.ordinal()] = 2;
                } catch (NoSuchFieldError unused2) {
                }
                try {
                    iArr[JobItem.JobItemState.PAUSED.ordinal()] = 3;
                } catch (NoSuchFieldError unused3) {
                }
                try {
                    iArr[JobItem.JobItemState.CANCELLED.ordinal()] = 4;
                } catch (NoSuchFieldError unused4) {
                }
                try {
                    iArr[JobItem.JobItemState.QUEUED.ordinal()] = 5;
                } catch (NoSuchFieldError unused5) {
                }
                $EnumSwitchMapping$0 = iArr;
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(ParentJobItem parentJobItem, BoxJobCollection boxJobCollection, Set<String> set, Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
            this.$jobItem = parentJobItem;
            this.$collection = boxJobCollection;
            this.$userCancelledJobs = set;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            AnonymousClass1 anonymousClass1 = new AnonymousClass1(this.$jobItem, this.$collection, this.$userCancelledJobs, continuation);
            anonymousClass1.L$0 = obj;
            return anonymousClass1;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(FlowCollector<? super JobInfo.Status> flowCollector, Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(flowCollector, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
        /* JADX WARN: Code duplicated, block: B:11:0x003a  */
        /* JADX WARN: Code duplicated, block: B:13:0x003d  */
        /* JADX WARN: Code duplicated, block: B:15:0x0040  */
        /* JADX WARN: Code duplicated, block: B:17:0x0043  */
        /* JADX WARN: Code duplicated, block: B:19:0x0046  */
        /* JADX WARN: Code duplicated, block: B:22:0x0059  */
        /* JADX WARN: Code duplicated, block: B:24:0x005f  */
        /* JADX WARN: Code duplicated, block: B:27:0x0075  */
        /* JADX WARN: Code duplicated, block: B:30:0x008b  */
        /* JADX WARN: Code duplicated, block: B:33:0x00a2  */
        /* JADX WARN: Code duplicated, block: B:36:0x00b4 A[PHI: r2
          0x00b4: PHI (r2v2 com.box.android.coreservices.jobmanager.JobItem$JobItemState) = 
          (r2v1 com.box.android.coreservices.jobmanager.JobItem$JobItemState)
          (r2v1 com.box.android.coreservices.jobmanager.JobItem$JobItemState)
          (r2v1 com.box.android.coreservices.jobmanager.JobItem$JobItemState)
          (r2v1 com.box.android.coreservices.jobmanager.JobItem$JobItemState)
          (r2v1 com.box.android.coreservices.jobmanager.JobItem$JobItemState)
          (r2v7 com.box.android.coreservices.jobmanager.JobItem$JobItemState)
         binds: [B:34:0x00b1, B:31:0x009f, B:28:0x0088, B:25:0x0072, B:20:0x0055, B:7:0x001a] A[DONT_GENERATE, DONT_INLINE]] */
        /* JADX WARN: Code duplicated, block: B:38:0x00b8  */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:44:0x00d9 -> B:9:0x0026). Please report as a decompilation issue!!! */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            JobItem.JobItemState currentState;
            int i;
            FlowCollector flowCollector = (FlowCollector) this.L$0;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            switch (this.label) {
                case 0:
                    ResultKt.throwOnFailure(obj);
                    currentState = this.$jobItem.getCurrentState();
                    Intrinsics.checkNotNull(currentState);
                    i = WhenMappings.$EnumSwitchMapping$0[currentState.ordinal()];
                    if (i == 1) {
                        this.L$0 = flowCollector;
                        this.L$1 = currentState;
                        this.label = 1;
                        if (JobManagerBridgeServiceKt.processCompletion(flowCollector, this.$jobItem, this) != coroutine_suspended) {
                            if (currentState == JobItem.JobItemState.CANCELLED && (currentState != JobItem.JobItemState.COMPLETED || this.$jobItem.hasError())) {
                                this.L$0 = flowCollector;
                                this.L$1 = SpillingKt.nullOutSpilledVariable(currentState);
                                this.label = 6;
                                if (DelayKt.delay(500L, this) != coroutine_suspended) {
                                    currentState = this.$jobItem.getCurrentState();
                                    Intrinsics.checkNotNull(currentState);
                                    i = WhenMappings.$EnumSwitchMapping$0[currentState.ordinal()];
                                    if (i == 1) {
                                        this.L$0 = flowCollector;
                                        this.L$1 = currentState;
                                        this.label = 1;
                                        if (JobManagerBridgeServiceKt.processCompletion(flowCollector, this.$jobItem, this) != coroutine_suspended) {
                                            if (currentState == JobItem.JobItemState.CANCELLED) {
                                            }
                                            return Unit.INSTANCE;
                                        }
                                    } else if (i == 2) {
                                        this.L$0 = flowCollector;
                                        this.L$1 = currentState;
                                        this.label = 2;
                                        if (JobManagerBridgeServiceKt.processProgress(flowCollector, this.$jobItem, this.$collection, false, this) != coroutine_suspended) {
                                            if (currentState == JobItem.JobItemState.CANCELLED) {
                                            }
                                            return Unit.INSTANCE;
                                        }
                                    } else if (i == 3) {
                                        this.L$0 = flowCollector;
                                        this.L$1 = currentState;
                                        this.label = 3;
                                        if (JobManagerBridgeServiceKt.processProgress(flowCollector, this.$jobItem, this.$collection, true, this) != coroutine_suspended) {
                                            if (currentState == JobItem.JobItemState.CANCELLED) {
                                            }
                                            return Unit.INSTANCE;
                                        }
                                    } else if (i == 4) {
                                        this.L$0 = flowCollector;
                                        this.L$1 = currentState;
                                        this.label = 4;
                                        if (JobManagerBridgeServiceKt.processCancellation(flowCollector, this.$jobItem, this.$userCancelledJobs, this) != coroutine_suspended) {
                                            if (currentState == JobItem.JobItemState.CANCELLED) {
                                            }
                                            return Unit.INSTANCE;
                                        }
                                    } else {
                                        if (i != 5) {
                                            throw new NoWhenBranchMatchedException();
                                        }
                                        this.L$0 = flowCollector;
                                        this.L$1 = currentState;
                                        this.label = 5;
                                        if (flowCollector.emit(JobInfo.Status.Waiting.INSTANCE, this) != coroutine_suspended) {
                                            if (currentState == JobItem.JobItemState.CANCELLED) {
                                            }
                                            return Unit.INSTANCE;
                                        }
                                    }
                                }
                            } else {
                                return Unit.INSTANCE;
                            }
                        }
                    } else if (i == 2) {
                        this.L$0 = flowCollector;
                        this.L$1 = currentState;
                        this.label = 2;
                        if (JobManagerBridgeServiceKt.processProgress(flowCollector, this.$jobItem, this.$collection, false, this) != coroutine_suspended) {
                            if (currentState == JobItem.JobItemState.CANCELLED) {
                            }
                            return Unit.INSTANCE;
                        }
                    } else if (i == 3) {
                        this.L$0 = flowCollector;
                        this.L$1 = currentState;
                        this.label = 3;
                        if (JobManagerBridgeServiceKt.processProgress(flowCollector, this.$jobItem, this.$collection, true, this) != coroutine_suspended) {
                            if (currentState == JobItem.JobItemState.CANCELLED) {
                            }
                            return Unit.INSTANCE;
                        }
                    } else if (i == 4) {
                        this.L$0 = flowCollector;
                        this.L$1 = currentState;
                        this.label = 4;
                        if (JobManagerBridgeServiceKt.processCancellation(flowCollector, this.$jobItem, this.$userCancelledJobs, this) != coroutine_suspended) {
                            if (currentState == JobItem.JobItemState.CANCELLED) {
                            }
                            return Unit.INSTANCE;
                        }
                    } else {
                        if (i != 5) {
                            throw new NoWhenBranchMatchedException();
                        }
                        this.L$0 = flowCollector;
                        this.L$1 = currentState;
                        this.label = 5;
                        if (flowCollector.emit(JobInfo.Status.Waiting.INSTANCE, this) != coroutine_suspended) {
                            if (currentState == JobItem.JobItemState.CANCELLED) {
                            }
                            return Unit.INSTANCE;
                        }
                    }
                    return coroutine_suspended;
                case 1:
                case 2:
                case 3:
                case 4:
                case 5:
                    currentState = (JobItem.JobItemState) this.L$1;
                    ResultKt.throwOnFailure(obj);
                    if (currentState == JobItem.JobItemState.CANCELLED) {
                        break;
                    }
                    return Unit.INSTANCE;
                case 6:
                    ResultKt.throwOnFailure(obj);
                    currentState = this.$jobItem.getCurrentState();
                    Intrinsics.checkNotNull(currentState);
                    i = WhenMappings.$EnumSwitchMapping$0[currentState.ordinal()];
                    if (i == 1) {
                        this.L$0 = flowCollector;
                        this.L$1 = currentState;
                        this.label = 1;
                        if (JobManagerBridgeServiceKt.processCompletion(flowCollector, this.$jobItem, this) != coroutine_suspended) {
                            if (currentState == JobItem.JobItemState.CANCELLED) {
                                break;
                            }
                            return Unit.INSTANCE;
                        }
                    } else if (i == 2) {
                        this.L$0 = flowCollector;
                        this.L$1 = currentState;
                        this.label = 2;
                        if (JobManagerBridgeServiceKt.processProgress(flowCollector, this.$jobItem, this.$collection, false, this) != coroutine_suspended) {
                            if (currentState == JobItem.JobItemState.CANCELLED) {
                                break;
                            }
                            return Unit.INSTANCE;
                        }
                    } else if (i == 3) {
                        this.L$0 = flowCollector;
                        this.L$1 = currentState;
                        this.label = 3;
                        if (JobManagerBridgeServiceKt.processProgress(flowCollector, this.$jobItem, this.$collection, true, this) != coroutine_suspended) {
                            if (currentState == JobItem.JobItemState.CANCELLED) {
                                break;
                            }
                            return Unit.INSTANCE;
                        }
                    } else if (i == 4) {
                        this.L$0 = flowCollector;
                        this.L$1 = currentState;
                        this.label = 4;
                        if (JobManagerBridgeServiceKt.processCancellation(flowCollector, this.$jobItem, this.$userCancelledJobs, this) != coroutine_suspended) {
                            if (currentState == JobItem.JobItemState.CANCELLED) {
                                break;
                            }
                            return Unit.INSTANCE;
                        }
                    } else {
                        if (i != 5) {
                            throw new NoWhenBranchMatchedException();
                        }
                        this.L$0 = flowCollector;
                        this.L$1 = currentState;
                        this.label = 5;
                        if (flowCollector.emit(JobInfo.Status.Waiting.INSTANCE, this) != coroutine_suspended) {
                            if (currentState == JobItem.JobItemState.CANCELLED) {
                                break;
                            }
                            return Unit.INSTANCE;
                        }
                    }
                    return coroutine_suspended;
                default:
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }
    }

    public static final Flow<JobInfo.Status> getJobStatus(ParentJobItem parentJobItem, BoxJobCollection boxJobCollection, Set<String> userCancelledJobs) {
        Intrinsics.checkNotNullParameter(parentJobItem, "<this>");
        Intrinsics.checkNotNullParameter(userCancelledJobs, "userCancelledJobs");
        return FlowKt.distinctUntilChanged(FlowKt.flow(new AnonymousClass1(parentJobItem, boxJobCollection, userCancelledJobs, null)));
    }
}
