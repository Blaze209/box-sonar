package com.box.android.data.jobs;

import android.content.Context;
import androidx.work.Data;
import com.box.android.data.persistence.jobs.JobEntity;
import com.box.android.domain.jobs.JobId;
import com.box.android.domain.jobs.JobRequest;
import com.box.android.domain.jobs.JobType;
import com.box.android.domain.models.DeleteCollaborationJobInfoProvider;
import com.box.android.domain.models.DisplayableJob;
import com.box.android.domain.models.IJobDisplayInfoProvider;
import com.box.android.domain.models.ItemId;
import com.box.android.domain.services.IItemCollaborationsService;
import com.box.android.domain.services.ILocalItemService;
import com.box.android.domain.services.IdMappingService;
import dagger.assisted.Assisted;
import dagger.assisted.AssistedFactory;
import dagger.assisted.AssistedInject;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.SetsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: DeleteCollaborationJob.kt */
/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 #2\u00020\u00012\u00020\u0002:\u0002#$BE\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\n\u0012\b\b\u0001\u0010\u000b\u001a\u00020\f\u0012\b\b\u0001\u0010\r\u001a\u00020\u000e\u0012\u0006\u0010\u000f\u001a\u00020\u0010¢\u0006\u0004\b\u0011\u0010\u0012J\u000e\u0010\u001b\u001a\u00020\u001cH\u0096@¢\u0006\u0002\u0010\u001dJ\u000e\u0010\u001e\u001a\u00020\u001cH\u0096@¢\u0006\u0002\u0010\u001dJ\u000e\u0010\u001f\u001a\u00020 H\u0096@¢\u0006\u0002\u0010\u001dJ\b\u0010!\u001a\u00020\"H\u0016R\u0014\u0010\u0003\u001a\u00020\u0004X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0014\u0010\u0005\u001a\u00020\u0006X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u000b\u001a\u00020\f¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u0011\u0010\r\u001a\u00020\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001aR\u000e\u0010\u000f\u001a\u00020\u0010X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006%"}, d2 = {"Lcom/box/android/data/jobs/DeleteCollaborationJob;", "Lcom/box/android/data/jobs/Job;", "Lcom/box/android/domain/models/DisplayableJob;", "appContext", "Landroid/content/Context;", "jobService", "Lcom/box/android/data/jobs/JobService;", "itemCollaborationsService", "Lcom/box/android/domain/services/IItemCollaborationsService;", "itemService", "Lcom/box/android/domain/services/ILocalItemService;", JobWorker.JOB_ID_PARAM, "Lcom/box/android/domain/jobs/JobId;", "inputData", "Landroidx/work/Data;", "idMappingService", "Lcom/box/android/domain/services/IdMappingService;", "<init>", "(Landroid/content/Context;Lcom/box/android/data/jobs/JobService;Lcom/box/android/domain/services/IItemCollaborationsService;Lcom/box/android/domain/services/ILocalItemService;Lcom/box/android/domain/jobs/JobId;Landroidx/work/Data;Lcom/box/android/domain/services/IdMappingService;)V", "getAppContext", "()Landroid/content/Context;", "getJobService", "()Lcom/box/android/data/jobs/JobService;", "getJobId", "()Lcom/box/android/domain/jobs/JobId;", "getInputData", "()Landroidx/work/Data;", "start", "", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "cleanup", "shouldBeRemovedFromDbOnSuccess", "", "getJobDisplayInfoProvider", "Lcom/box/android/domain/models/IJobDisplayInfoProvider;", "Companion", "Factory", "data_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class DeleteCollaborationJob implements Job, DisplayableJob {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public static final String ITEM_ID_PARAM = "ItemIdParam";
    public static final String TARGET_USER_ID_PARAM = "targetUserId";
    private final Context appContext;
    private final IdMappingService idMappingService;
    private final Data inputData;
    private final IItemCollaborationsService itemCollaborationsService;
    private final ILocalItemService itemService;
    private final JobId jobId;
    private final JobService jobService;

    /* JADX INFO: compiled from: DeleteCollaborationJob.kt */
    @AssistedFactory
    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bg\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H&¨\u0006\bÀ\u0006\u0003"}, d2 = {"Lcom/box/android/data/jobs/DeleteCollaborationJob$Factory;", "", "createJob", "Lcom/box/android/data/jobs/DeleteCollaborationJob;", JobWorker.JOB_ID_PARAM, "Lcom/box/android/domain/jobs/JobId;", "inputData", "Landroidx/work/Data;", "data_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public interface Factory {
        DeleteCollaborationJob createJob(JobId jobId, Data inputData);
    }

    /* JADX INFO: renamed from: com.box.android.data.jobs.DeleteCollaborationJob$start$1, reason: invalid class name */
    /* JADX INFO: compiled from: DeleteCollaborationJob.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.box.android.data.jobs.DeleteCollaborationJob", f = "DeleteCollaborationJob.kt", i = {1, 1, 1, 1, 2, 2, 2, 2}, l = {51, 55, 57}, m = "start", n = {"$this$onSuccess$iv", "it", "$i$f$onSuccess", "$i$a$-onSuccess-DeleteCollaborationJob$start$2", "$this$onError$iv", "it", "$i$f$onError", "$i$a$-onError-DeleteCollaborationJob$start$3"}, s = {"L$0", "L$1", "I$0", "I$1", "L$0", "L$1", "I$0", "I$1"}, v = 1)
    static final class AnonymousClass1 extends ContinuationImpl {
        int I$0;
        int I$1;
        Object L$0;
        Object L$1;
        int label;
        /* synthetic */ Object result;

        AnonymousClass1(Continuation<? super AnonymousClass1> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return DeleteCollaborationJob.this.start(this);
        }
    }

    @AssistedInject
    public DeleteCollaborationJob(Context appContext, JobService jobService, IItemCollaborationsService itemCollaborationsService, ILocalItemService itemService, @Assisted JobId jobId, @Assisted Data inputData, IdMappingService idMappingService) {
        Intrinsics.checkNotNullParameter(appContext, "appContext");
        Intrinsics.checkNotNullParameter(jobService, "jobService");
        Intrinsics.checkNotNullParameter(itemCollaborationsService, "itemCollaborationsService");
        Intrinsics.checkNotNullParameter(itemService, "itemService");
        Intrinsics.checkNotNullParameter(jobId, "jobId");
        Intrinsics.checkNotNullParameter(inputData, "inputData");
        Intrinsics.checkNotNullParameter(idMappingService, "idMappingService");
        this.appContext = appContext;
        this.jobService = jobService;
        this.itemCollaborationsService = itemCollaborationsService;
        this.itemService = itemService;
        this.jobId = jobId;
        this.inputData = inputData;
        this.idMappingService = idMappingService;
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

    /* JADX INFO: compiled from: DeleteCollaborationJob.kt */
    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\"\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J&\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u00052\u000e\b\u0002\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00050\rR\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u000e"}, d2 = {"Lcom/box/android/data/jobs/DeleteCollaborationJob$Companion;", "", "<init>", "()V", "ITEM_ID_PARAM", "", "TARGET_USER_ID_PARAM", "getRequest", "Lcom/box/android/domain/jobs/JobRequest;", "itemId", "Lcom/box/android/domain/models/ItemId;", "targetCollabId", "tags", "", "data_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ JobRequest getRequest$default(Companion companion, ItemId itemId, String str, Set set, int i, Object obj) {
            if ((i & 4) != 0) {
                set = SetsKt.emptySet();
            }
            return companion.getRequest(itemId, str, set);
        }

        public final JobRequest getRequest(ItemId itemId, String targetCollabId, Set<String> tags) {
            Intrinsics.checkNotNullParameter(itemId, "itemId");
            Intrinsics.checkNotNullParameter(targetCollabId, "targetCollabId");
            Intrinsics.checkNotNullParameter(tags, "tags");
            JobRequest.Builder builder = new JobRequest.Builder(JobType.DELETE_COLLABORATION, null, null, null, 14, null);
            Data.Builder builder2 = new Data.Builder();
            builder2.putString(DeleteCollaborationJob.ITEM_ID_PARAM, itemId.toString());
            builder2.putString(DeleteCollaborationJob.TARGET_USER_ID_PARAM, targetCollabId);
            builder.setTags(SetsKt.plus(SetsKt.setOf("delete_collaboration:" + itemId), (Iterable) tags));
            builder.setData(builder2.build());
            return builder.build();
        }
    }

    /* JADX WARN: Code duplicated, block: B:30:0x00b8  */
    /* JADX WARN: Code duplicated, block: B:32:0x00bc  */
    /* JADX WARN: Code duplicated, block: B:35:0x00e2  */
    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    /* JADX WARN: Code restructure failed: missing block: B:33:0x00df, code lost:
    
        if (r4.jobFailed(r9, com.box.android.domain.jobs.JobType.DELETE_COLLABORATION, r10, r0) == r1) goto L34;
     */
    @Override // com.box.android.data.jobs.Job
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.Object start(kotlin.coroutines.Continuation<? super kotlin.Unit> r10) {
        /*
            Method dump skipped, instruction units count: 241
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.box.android.data.jobs.DeleteCollaborationJob.start(kotlin.coroutines.Continuation):java.lang.Object");
    }

    @Override // com.box.android.data.jobs.Job
    public Object cleanup(Continuation<? super Unit> continuation) {
        return Unit.INSTANCE;
    }

    @Override // com.box.android.data.jobs.Job
    public Object shouldBeRemovedFromDbOnSuccess(Continuation<? super Boolean> continuation) {
        return Boxing.boxBoolean(true);
    }

    @Override // com.box.android.domain.models.DisplayableJob
    public IJobDisplayInfoProvider getJobDisplayInfoProvider() {
        ItemId.Companion companion = ItemId.INSTANCE;
        String string = this.inputData.getString(ITEM_ID_PARAM);
        Intrinsics.checkNotNull(string);
        return new DeleteCollaborationJobInfoProvider(companion.create(string), this.itemService, this.idMappingService);
    }
}
