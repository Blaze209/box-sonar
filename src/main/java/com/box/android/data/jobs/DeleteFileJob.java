package com.box.android.data.jobs;

import android.content.Context;
import androidx.work.Data;
import com.box.android.data.persistence.jobs.JobEntity;
import com.box.android.domain.jobs.JobId;
import com.box.android.domain.jobs.JobRequest;
import com.box.android.domain.jobs.JobType;
import com.box.android.domain.models.DeleteFileJobInfoProviders;
import com.box.android.domain.models.DisplayableJob;
import com.box.android.domain.models.DomainError;
import com.box.android.domain.models.IJobDisplayInfoProvider;
import com.box.android.domain.models.ItemId;
import com.box.android.domain.models.MetricsInfoProvider;
import com.box.android.domain.services.IDeleteFileService;
import com.box.android.domain.services.ILocalItemService;
import com.box.android.domain.services.IdMappingService;
import com.box.android.domain.utils.result.Result;
import com.box.brownfieldApi.featuresNavigator.activities.ReactNativeFeatureActivity;
import dagger.assisted.Assisted;
import dagger.assisted.AssistedFactory;
import dagger.assisted.AssistedInject;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.collections.SetsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: compiled from: DeleteFileJob.kt */
/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010$\n\u0002\u0010\u0000\n\u0002\b\u0003\u0018\u0000 )2\u00020\u00012\u00020\u00022\u00020\u0003:\u0002)*BE\b\u0007\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\u0006\u0010\f\u001a\u00020\r\u0012\b\b\u0001\u0010\u000e\u001a\u00020\u000f\u0012\b\b\u0001\u0010\u0010\u001a\u00020\u0011¢\u0006\u0004\b\u0012\u0010\u0013J\u000e\u0010\u001c\u001a\u00020\u001dH\u0096@¢\u0006\u0002\u0010\u001eJ\u000e\u0010\u001f\u001a\u00020\u001dH\u0096@¢\u0006\u0002\u0010\u001eJ\u000e\u0010 \u001a\u00020!H\u0096@¢\u0006\u0002\u0010\u001eJ\b\u0010\"\u001a\u00020#H\u0016J\b\u0010$\u001a\u00020%H\u0016J\u001a\u0010&\u001a\u000e\u0012\u0004\u0012\u00020%\u0012\u0004\u0012\u00020(0'H\u0096@¢\u0006\u0002\u0010\u001eR\u0014\u0010\u0004\u001a\u00020\u0005X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0014\u0010\u0006\u001a\u00020\u0007X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u000e\u001a\u00020\u000f¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R\u0011\u0010\u0010\u001a\u00020\u0011¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u001b¨\u0006+"}, d2 = {"Lcom/box/android/data/jobs/DeleteFileJob;", "Lcom/box/android/data/jobs/Job;", "Lcom/box/android/domain/models/DisplayableJob;", "Lcom/box/android/domain/models/MetricsInfoProvider;", "appContext", "Landroid/content/Context;", "jobService", "Lcom/box/android/data/jobs/JobService;", "deleteFileService", "Lcom/box/android/domain/services/IDeleteFileService;", "localItemService", "Lcom/box/android/domain/services/ILocalItemService;", "idMappingService", "Lcom/box/android/domain/services/IdMappingService;", JobWorker.JOB_ID_PARAM, "Lcom/box/android/domain/jobs/JobId;", "inputData", "Landroidx/work/Data;", "<init>", "(Landroid/content/Context;Lcom/box/android/data/jobs/JobService;Lcom/box/android/domain/services/IDeleteFileService;Lcom/box/android/domain/services/ILocalItemService;Lcom/box/android/domain/services/IdMappingService;Lcom/box/android/domain/jobs/JobId;Landroidx/work/Data;)V", "getAppContext", "()Landroid/content/Context;", "getJobService", "()Lcom/box/android/data/jobs/JobService;", "getJobId", "()Lcom/box/android/domain/jobs/JobId;", "getInputData", "()Landroidx/work/Data;", "start", "", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "cleanup", "shouldBeRemovedFromDbOnSuccess", "", "getJobDisplayInfoProvider", "Lcom/box/android/domain/models/IJobDisplayInfoProvider;", "getAmplitudeJobType", "", "getAmplitudeInfos", "", "", "Companion", "Factory", "data_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class DeleteFileJob implements Job, DisplayableJob, MetricsInfoProvider {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public static final String LOCAL_ITEM_ID_PARAM = "localItemIdParam";
    private final Context appContext;
    private final IDeleteFileService deleteFileService;
    private final IdMappingService idMappingService;
    private final Data inputData;
    private final JobId jobId;
    private final JobService jobService;
    private final ILocalItemService localItemService;

    /* JADX INFO: compiled from: DeleteFileJob.kt */
    @AssistedFactory
    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bg\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H&¨\u0006\bÀ\u0006\u0003"}, d2 = {"Lcom/box/android/data/jobs/DeleteFileJob$Factory;", "", "createJob", "Lcom/box/android/data/jobs/DeleteFileJob;", JobWorker.JOB_ID_PARAM, "Lcom/box/android/domain/jobs/JobId;", "inputData", "Landroidx/work/Data;", "data_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public interface Factory {
        DeleteFileJob createJob(JobId jobId, Data inputData);
    }

    /* JADX INFO: renamed from: com.box.android.data.jobs.DeleteFileJob$start$1, reason: invalid class name */
    /* JADX INFO: compiled from: DeleteFileJob.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.box.android.data.jobs.DeleteFileJob", f = "DeleteFileJob.kt", i = {0, 1, 2, 2, 3, 3, 4, 4, 5, 5, 5}, l = {52, 62, 64, 74, 75, 76}, m = "start", n = {"itemId", "itemId", "itemId", "serverId", "itemId", "serverId", "itemId", "serverId", "itemId", "serverId", ReactNativeFeatureActivity.RESULT_EXTRA_KEY}, s = {"L$0", "L$0", "L$0", "L$1", "L$0", "L$1", "L$0", "L$1", "L$0", "L$1", "L$2"}, v = 1)
    static final class AnonymousClass1 extends ContinuationImpl {
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
            return DeleteFileJob.this.start(this);
        }
    }

    @AssistedInject
    public DeleteFileJob(Context appContext, JobService jobService, IDeleteFileService deleteFileService, ILocalItemService localItemService, IdMappingService idMappingService, @Assisted JobId jobId, @Assisted Data inputData) {
        Intrinsics.checkNotNullParameter(appContext, "appContext");
        Intrinsics.checkNotNullParameter(jobService, "jobService");
        Intrinsics.checkNotNullParameter(deleteFileService, "deleteFileService");
        Intrinsics.checkNotNullParameter(localItemService, "localItemService");
        Intrinsics.checkNotNullParameter(idMappingService, "idMappingService");
        Intrinsics.checkNotNullParameter(jobId, "jobId");
        Intrinsics.checkNotNullParameter(inputData, "inputData");
        this.appContext = appContext;
        this.jobService = jobService;
        this.deleteFileService = deleteFileService;
        this.localItemService = localItemService;
        this.idMappingService = idMappingService;
        this.jobId = jobId;
        this.inputData = inputData;
    }

    @Override // com.box.android.data.jobs.Job
    public /* bridge */ Object run(JobEntity jobEntity, Continuation<? super Unit> continuation) {
        return super.run(jobEntity, continuation);
    }

    @Override // com.box.android.domain.models.DisplayableJob
    public /* bridge */ boolean shouldDisplay() {
        return super.shouldDisplay();
    }

    @Override // com.box.android.data.jobs.Job
    public Context getAppContext() {
        return this.appContext;
    }

    @Override // com.box.android.data.jobs.Job
    public JobService getJobService() {
        return this.jobService;
    }

    public final JobId getJobId() {
        return this.jobId;
    }

    public final Data getInputData() {
        return this.inputData;
    }

    /* JADX INFO: compiled from: DeleteFileJob.kt */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\"\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u001e\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u000e\b\u0002\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00050\u000bR\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006\f"}, d2 = {"Lcom/box/android/data/jobs/DeleteFileJob$Companion;", "", "<init>", "()V", "LOCAL_ITEM_ID_PARAM", "", "getRequest", "Lcom/box/android/domain/jobs/JobRequest;", "itemId", "Lcom/box/android/domain/models/ItemId;", "tags", "", "data_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ JobRequest getRequest$default(Companion companion, ItemId itemId, Set set, int i, Object obj) {
            if ((i & 2) != 0) {
                set = SetsKt.emptySet();
            }
            return companion.getRequest(itemId, set);
        }

        public final JobRequest getRequest(ItemId itemId, Set<String> tags) {
            Intrinsics.checkNotNullParameter(itemId, "itemId");
            Intrinsics.checkNotNullParameter(tags, "tags");
            JobRequest.Builder builder = new JobRequest.Builder(JobType.DELETE_FILE, null, null, null, 14, null);
            Data.Builder builder2 = new Data.Builder();
            builder2.putString(DeleteFileJob.LOCAL_ITEM_ID_PARAM, itemId.toString());
            builder.setTags(SetsKt.plus(SetsKt.setOf("delete_file:" + itemId), (Iterable) tags));
            builder.setData(builder2.build());
            return builder.build();
        }
    }

    /* JADX WARN: Code duplicated, block: B:34:0x00c9  */
    /* JADX WARN: Code duplicated, block: B:39:0x00fe  */
    /* JADX WARN: Code duplicated, block: B:42:0x011b A[PHI: r8 r10
      0x011b: PHI (r8v1 com.box.android.domain.models.ItemId) = (r8v0 com.box.android.domain.models.ItemId), (r8v2 com.box.android.domain.models.ItemId) binds: [B:40:0x0118, B:14:0x004e] A[DONT_GENERATE, DONT_INLINE]
      0x011b: PHI (r10v12 com.box.android.domain.models.ItemId$Remote) = (r10v9 com.box.android.domain.models.ItemId$Remote), (r10v14 com.box.android.domain.models.ItemId$Remote) binds: [B:40:0x0118, B:14:0x004e] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:45:0x0139  */
    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x00af, code lost:
    
        if (r10.jobFailed(r9, com.box.android.domain.jobs.JobType.DELETE_FILE, r3, r4) == r0) goto L48;
     */
    /* JADX WARN: Code restructure failed: missing block: B:35:0x00f8, code lost:
    
        if (r1.jobFailed(r9, com.box.android.domain.jobs.JobType.DELETE_FILE, r3, r4) == r0) goto L48;
     */
    /* JADX WARN: Code restructure failed: missing block: B:47:0x0163, code lost:
    
        if (kotlinx.coroutines.BuildersKt.withContext(r3, r5, r4) == r0) goto L48;
     */
    @Override // com.box.android.data.jobs.Job
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.Object start(kotlin.coroutines.Continuation<? super kotlin.Unit> r10) {
        /*
            Method dump skipped, instruction units count: 380
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.box.android.data.jobs.DeleteFileJob.start(kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX INFO: renamed from: com.box.android.data.jobs.DeleteFileJob$start$2, reason: invalid class name */
    /* JADX INFO: compiled from: DeleteFileJob.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001*\u00020\u0004H\n"}, d2 = {"<anonymous>", "Lcom/box/android/domain/utils/result/Result;", "", "Lcom/box/android/domain/models/DomainError;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.box.android.data.jobs.DeleteFileJob$start$2", f = "DeleteFileJob.kt", i = {0, 0, 0, 0, 1, 1, 1, 1}, l = {78, 80}, m = "invokeSuspend", n = {"$this$onSuccess$iv", "it", "$i$f$onSuccess", "$i$a$-onSuccess-DeleteFileJob$start$2$1", "$this$onError$iv", "it", "$i$f$onError", "$i$a$-onError-DeleteFileJob$start$2$2"}, s = {"L$0", "L$1", "I$0", "I$1", "L$0", "L$1", "I$0", "I$1"}, v = 1)
    static final class AnonymousClass2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Result<? extends Unit, ? extends DomainError>>, Object> {
        final /* synthetic */ Result<Unit, DomainError> $result;
        int I$0;
        int I$1;
        Object L$0;
        Object L$1;
        int label;
        final /* synthetic */ DeleteFileJob this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        AnonymousClass2(Result<Unit, ? extends DomainError> result, DeleteFileJob deleteFileJob, Continuation<? super AnonymousClass2> continuation) {
            super(2, continuation);
            this.$result = result;
            this.this$0 = deleteFileJob;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new AnonymousClass2(this.$result, this.this$0, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Object invoke(CoroutineScope coroutineScope, Continuation<? super Result<? extends Unit, ? extends DomainError>> continuation) {
            return invoke2(coroutineScope, (Continuation<? super Result<Unit, ? extends DomainError>>) continuation);
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(CoroutineScope coroutineScope, Continuation<? super Result<Unit, ? extends DomainError>> continuation) {
            return ((AnonymousClass2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Result<Unit, DomainError> result;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                result = this.$result;
                DeleteFileJob deleteFileJob = this.this$0;
                if (result instanceof Result.Success) {
                    Unit unit = (Unit) ((Result.Success) result).getValue();
                    JobService jobService = deleteFileJob.getJobService();
                    JobId jobId = deleteFileJob.getJobId();
                    this.L$0 = result;
                    this.L$1 = SpillingKt.nullOutSpilledVariable(unit);
                    this.I$0 = 0;
                    this.I$1 = 0;
                    this.label = 1;
                    if (jobService.jobSucceeded(jobId, this) != coroutine_suspended) {
                    }
                    return coroutine_suspended;
                }
                if (!(result instanceof Result.Error)) {
                    throw new NoWhenBranchMatchedException();
                }
            } else {
                if (i != 1) {
                    if (i != 2) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    Result result2 = (Result) this.L$0;
                    ResultKt.throwOnFailure(obj);
                    return result2;
                }
                result = (Result) this.L$0;
                ResultKt.throwOnFailure(obj);
            }
            DeleteFileJob deleteFileJob2 = this.this$0;
            if (!(result instanceof Result.Success)) {
                if (!(result instanceof Result.Error)) {
                    throw new NoWhenBranchMatchedException();
                }
                DomainError domainError = (DomainError) ((Result.Error) result).getValue();
                JobService jobService2 = deleteFileJob2.getJobService();
                JobId jobId2 = deleteFileJob2.getJobId();
                this.L$0 = result;
                this.L$1 = SpillingKt.nullOutSpilledVariable(domainError);
                this.I$0 = 0;
                this.I$1 = 0;
                this.label = 2;
                if (jobService2.jobFailed(jobId2, JobType.DELETE_FILE, domainError, this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            }
            return result;
        }
    }

    @Override // com.box.android.data.jobs.Job
    public Object cleanup(Continuation<? super Unit> continuation) {
        String string = this.inputData.getString(LOCAL_ITEM_ID_PARAM);
        ItemId itemIdCreate = string != null ? ItemId.INSTANCE.create(string) : null;
        if (itemIdCreate != null) {
            Object objCleanup = this.localItemService.cleanup(itemIdCreate, continuation);
            if (objCleanup == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
                return objCleanup;
            }
        }
        return Unit.INSTANCE;
    }

    @Override // com.box.android.data.jobs.Job
    public Object shouldBeRemovedFromDbOnSuccess(Continuation<? super Boolean> continuation) {
        return Boxing.boxBoolean(true);
    }

    @Override // com.box.android.domain.models.DisplayableJob
    public IJobDisplayInfoProvider getJobDisplayInfoProvider() {
        ItemId.Companion companion = ItemId.INSTANCE;
        String string = this.inputData.getString(LOCAL_ITEM_ID_PARAM);
        Intrinsics.checkNotNull(string);
        return new DeleteFileJobInfoProviders(companion.create(string), this.localItemService, this.idMappingService);
    }

    @Override // com.box.android.domain.models.MetricsInfoProvider
    public String getAmplitudeJobType() {
        return "delete";
    }

    @Override // com.box.android.domain.models.MetricsInfoProvider
    public Object getAmplitudeInfos(Continuation<? super Map<String, ? extends Object>> continuation) {
        return MapsKt.emptyMap();
    }
}
