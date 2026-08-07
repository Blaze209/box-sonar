package com.box.android.data.jobs;

import android.content.Context;
import androidx.work.Data;
import com.box.android.data.persistence.jobs.JobEntity;
import com.box.android.data.service.impl.CreateFolderService;
import com.box.android.data.service.impl.LocalItemService;
import com.box.android.domain.jobs.JobId;
import com.box.android.domain.jobs.JobRequest;
import com.box.android.domain.models.CreateFolderJobInfoProvider;
import com.box.android.domain.models.DisplayableJob;
import com.box.android.domain.models.DomainError;
import com.box.android.domain.models.IJobDisplayInfoProvider;
import com.box.android.domain.models.ItemId;
import com.box.android.domain.models.item.FolderModel;
import com.box.android.domain.services.IdMappingService;
import com.box.android.domain.utils.result.Result;
import com.box.brownfieldApi.featuresNavigator.activities.ReactNativeFeatureActivity;
import dagger.assisted.Assisted;
import dagger.assisted.AssistedFactory;
import dagger.assisted.AssistedInject;
import java.io.UnsupportedEncodingException;
import java.util.Date;
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
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import sdk.pendo.io.events.IdentificationData;

/* JADX INFO: compiled from: CreateFolderJob.kt */
/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 *2\u00020\u00012\u00020\u0002:\u0002*+BE\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\b\b\u0001\u0010\t\u001a\u00020\n\u0012\b\b\u0001\u0010\u000b\u001a\u00020\f\u0012\u0006\u0010\r\u001a\u00020\u000e\u0012\u0006\u0010\u000f\u001a\u00020\u0010¢\u0006\u0004\b\u0011\u0010\u0012J\u000e\u0010\u001b\u001a\u00020\u001cH\u0096@¢\u0006\u0002\u0010\u001dJ\u0018\u0010\u001e\u001a\u0004\u0018\u00010\u001f2\u0006\u0010 \u001a\u00020!H\u0087@¢\u0006\u0002\u0010\"J\u0018\u0010#\u001a\u0004\u0018\u00010$2\u0006\u0010 \u001a\u00020!H\u0087@¢\u0006\u0002\u0010\"J\u000e\u0010%\u001a\u00020\u001cH\u0096@¢\u0006\u0002\u0010\u001dJ\u000e\u0010&\u001a\u00020'H\u0096@¢\u0006\u0002\u0010\u001dJ\b\u0010(\u001a\u00020)H\u0016R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\t\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0011\u0010\u000b\u001a\u00020\f¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0014\u0010\r\u001a\u00020\u000eX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u0014\u0010\u000f\u001a\u00020\u0010X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001a¨\u0006,"}, d2 = {"Lcom/box/android/data/jobs/CreateFolderJob;", "Lcom/box/android/data/jobs/Job;", "Lcom/box/android/domain/models/DisplayableJob;", "createFolderService", "Lcom/box/android/data/service/impl/CreateFolderService;", "localItemService", "Lcom/box/android/data/service/impl/LocalItemService;", "idMappingService", "Lcom/box/android/domain/services/IdMappingService;", JobWorker.JOB_ID_PARAM, "Lcom/box/android/domain/jobs/JobId;", "inputData", "Landroidx/work/Data;", "appContext", "Landroid/content/Context;", "jobService", "Lcom/box/android/data/jobs/JobService;", "<init>", "(Lcom/box/android/data/service/impl/CreateFolderService;Lcom/box/android/data/service/impl/LocalItemService;Lcom/box/android/domain/services/IdMappingService;Lcom/box/android/domain/jobs/JobId;Landroidx/work/Data;Landroid/content/Context;Lcom/box/android/data/jobs/JobService;)V", "getJobId", "()Lcom/box/android/domain/jobs/JobId;", "getInputData", "()Landroidx/work/Data;", "getAppContext", "()Landroid/content/Context;", "getJobService", "()Lcom/box/android/data/jobs/JobService;", "start", "", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getLocalFolder", "Lcom/box/android/domain/models/item/FolderModel;", "localId", "Lcom/box/android/domain/models/ItemId;", "(Lcom/box/android/domain/models/ItemId;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getServerId", "", "cleanup", "shouldBeRemovedFromDbOnSuccess", "", "getJobDisplayInfoProvider", "Lcom/box/android/domain/models/IJobDisplayInfoProvider;", "Companion", "Factory", "data_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class CreateFolderJob implements Job, DisplayableJob {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public static final String LOCAL_ID = "local_id";
    private final Context appContext;
    private final CreateFolderService createFolderService;
    private final IdMappingService idMappingService;
    private final Data inputData;
    private final JobId jobId;
    private final JobService jobService;
    private final LocalItemService localItemService;

    /* JADX INFO: compiled from: CreateFolderJob.kt */
    @AssistedFactory
    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bg\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H&¨\u0006\bÀ\u0006\u0003"}, d2 = {"Lcom/box/android/data/jobs/CreateFolderJob$Factory;", "", "createJob", "Lcom/box/android/data/jobs/CreateFolderJob;", JobWorker.JOB_ID_PARAM, "Lcom/box/android/domain/jobs/JobId;", "inputData", "Landroidx/work/Data;", "data_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public interface Factory {
        CreateFolderJob createJob(JobId jobId, Data inputData);
    }

    /* JADX INFO: renamed from: com.box.android.data.jobs.CreateFolderJob$getLocalFolder$1, reason: invalid class name */
    /* JADX INFO: compiled from: CreateFolderJob.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.box.android.data.jobs.CreateFolderJob", f = "CreateFolderJob.kt", i = {0}, l = {95}, m = "getLocalFolder", n = {"localId"}, s = {"L$0"}, v = 1)
    static final class AnonymousClass1 extends ContinuationImpl {
        Object L$0;
        int label;
        /* synthetic */ Object result;

        AnonymousClass1(Continuation<? super AnonymousClass1> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return CreateFolderJob.this.getLocalFolder(null, this);
        }
    }

    /* JADX INFO: renamed from: com.box.android.data.jobs.CreateFolderJob$getServerId$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: CreateFolderJob.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.box.android.data.jobs.CreateFolderJob", f = "CreateFolderJob.kt", i = {0}, l = {101}, m = "getServerId", n = {"localId"}, s = {"L$0"}, v = 1)
    static final class C12401 extends ContinuationImpl {
        Object L$0;
        int label;
        /* synthetic */ Object result;

        C12401(Continuation<? super C12401> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return CreateFolderJob.this.getServerId(null, this);
        }
    }

    /* JADX INFO: renamed from: com.box.android.data.jobs.CreateFolderJob$start$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: CreateFolderJob.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.box.android.data.jobs.CreateFolderJob", f = "CreateFolderJob.kt", i = {1, 1, 2, 2, 3, 3, 3, 4, 4, 4, 4, 5, 5, 5, 5, 6, 6, 6, 6, 6, 7, 7, 7, 7, 7, 7}, l = {50, 58, 59, 66, 72, 73, 79, 80}, m = "start", n = {"localId", "itemId", "localId", "itemId", "localId", "itemId", "localFolderModel", "localId", "itemId", "localFolderModel", IdentificationData.FIELD_PARENT_ID, "localId", "itemId", "localFolderModel", IdentificationData.FIELD_PARENT_ID, "localId", "itemId", "localFolderModel", IdentificationData.FIELD_PARENT_ID, "parentServerId", "localId", "itemId", "localFolderModel", IdentificationData.FIELD_PARENT_ID, "parentServerId", ReactNativeFeatureActivity.RESULT_EXTRA_KEY}, s = {"L$0", "L$1", "L$0", "L$1", "L$0", "L$1", "L$2", "L$0", "L$1", "L$2", "L$3", "L$0", "L$1", "L$2", "L$3", "L$0", "L$1", "L$2", "L$3", "L$4", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5"}, v = 1)
    static final class C12411 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        Object L$4;
        Object L$5;
        int label;
        /* synthetic */ Object result;

        C12411(Continuation<? super C12411> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return CreateFolderJob.this.start(this);
        }
    }

    @AssistedInject
    public CreateFolderJob(CreateFolderService createFolderService, LocalItemService localItemService, IdMappingService idMappingService, @Assisted JobId jobId, @Assisted Data inputData, Context appContext, JobService jobService) {
        Intrinsics.checkNotNullParameter(createFolderService, "createFolderService");
        Intrinsics.checkNotNullParameter(localItemService, "localItemService");
        Intrinsics.checkNotNullParameter(idMappingService, "idMappingService");
        Intrinsics.checkNotNullParameter(jobId, "jobId");
        Intrinsics.checkNotNullParameter(inputData, "inputData");
        Intrinsics.checkNotNullParameter(appContext, "appContext");
        Intrinsics.checkNotNullParameter(jobService, "jobService");
        this.createFolderService = createFolderService;
        this.localItemService = localItemService;
        this.idMappingService = idMappingService;
        this.jobId = jobId;
        this.inputData = inputData;
        this.appContext = appContext;
        this.jobService = jobService;
    }

    @Override // com.box.android.data.jobs.Job
    public /* bridge */ Object run(JobEntity jobEntity, Continuation<? super Unit> continuation) {
        return super.run(jobEntity, continuation);
    }

    @Override // com.box.android.domain.models.DisplayableJob
    public /* bridge */ boolean shouldDisplay() {
        return super.shouldDisplay();
    }

    public final JobId getJobId() {
        return this.jobId;
    }

    public final Data getInputData() {
        return this.inputData;
    }

    @Override // com.box.android.data.jobs.Job
    public Context getAppContext() {
        return this.appContext;
    }

    @Override // com.box.android.data.jobs.Job
    public JobService getJobService() {
        return this.jobService;
    }

    /* JADX INFO: compiled from: CreateFolderJob.kt */
    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tR\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006\n"}, d2 = {"Lcom/box/android/data/jobs/CreateFolderJob$Companion;", "", "<init>", "()V", "LOCAL_ID", "", "createJobRequest", "Lcom/box/android/domain/jobs/JobRequest;", "itemId", "Lcom/box/android/domain/models/ItemId;", "data_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final JobRequest createJobRequest(ItemId itemId) {
            Intrinsics.checkNotNullParameter(itemId, "itemId");
            return new JobRequest.Builder("create_folder", SetsKt.hashSetOf("create_folder:" + itemId), new Date(), new Data.Builder().putString(CreateFolderJob.LOCAL_ID, itemId.toString()).build()).build();
        }
    }

    /* JADX WARN: Code duplicated, block: B:32:0x0103  */
    /* JADX WARN: Code duplicated, block: B:37:0x012c  */
    /* JADX WARN: Code duplicated, block: B:48:0x0162  */
    /* JADX WARN: Code duplicated, block: B:53:0x0197  */
    /* JADX WARN: Code duplicated, block: B:56:0x01c4  */
    /* JADX WARN: Code duplicated, block: B:62:0x0208  */
    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x00df, code lost:
    
        if (r12.jobFailed(r11, "create_folder", r2, r0) == r1) goto L64;
     */
    /* JADX WARN: Code restructure failed: missing block: B:33:0x0125, code lost:
    
        if (r12.jobFailed(r11, "create_folder", r5, r0) == r1) goto L64;
     */
    /* JADX WARN: Code restructure failed: missing block: B:49:0x0190, code lost:
    
        if (r12.jobFailed(r11, "create_folder", r7, r0) == r1) goto L64;
     */
    /* JADX WARN: Code restructure failed: missing block: B:58:0x0202, code lost:
    
        if (kotlinx.coroutines.BuildersKt.withContext(r7, r8, r0) == r1) goto L64;
     */
    /* JADX WARN: Code restructure failed: missing block: B:63:0x0230, code lost:
    
        if (r5.jobFailed(r11, "create_folder", r6, r0) == r1) goto L64;
     */
    @Override // com.box.android.data.jobs.Job
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.Object start(kotlin.coroutines.Continuation<? super kotlin.Unit> r12) throws java.io.UnsupportedEncodingException {
        /*
            Method dump skipped, instruction units count: 588
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.box.android.data.jobs.CreateFolderJob.start(kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX INFO: renamed from: com.box.android.data.jobs.CreateFolderJob$start$2, reason: invalid class name */
    /* JADX INFO: compiled from: CreateFolderJob.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001*\u00020\u0004H\n"}, d2 = {"<anonymous>", "Lcom/box/android/domain/utils/result/Result;", "Lcom/box/android/domain/models/item/FolderModel;", "Lcom/box/android/domain/models/DomainError;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.box.android.data.jobs.CreateFolderJob$start$2", f = "CreateFolderJob.kt", i = {0, 0, 0, 0, 1, 1, 1, 1, 2, 2, 2, 2}, l = {82, 83, 85}, m = "invokeSuspend", n = {"$this$onSuccess$iv", "it", "$i$f$onSuccess", "$i$a$-onSuccess-CreateFolderJob$start$2$1", "$this$onSuccess$iv", "it", "$i$f$onSuccess", "$i$a$-onSuccess-CreateFolderJob$start$2$1", "$this$onError$iv", "it", "$i$f$onError", "$i$a$-onError-CreateFolderJob$start$2$2"}, s = {"L$0", "L$2", "I$0", "I$1", "L$0", "L$1", "I$0", "I$1", "L$0", "L$1", "I$0", "I$1"}, v = 1)
    static final class AnonymousClass2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Result<? extends FolderModel, ? extends DomainError>>, Object> {
        final /* synthetic */ ItemId $itemId;
        final /* synthetic */ Result<FolderModel, DomainError> $result;
        int I$0;
        int I$1;
        Object L$0;
        Object L$1;
        Object L$2;
        int label;
        final /* synthetic */ CreateFolderJob this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        AnonymousClass2(Result<FolderModel, ? extends DomainError> result, CreateFolderJob createFolderJob, ItemId itemId, Continuation<? super AnonymousClass2> continuation) {
            super(2, continuation);
            this.$result = result;
            this.this$0 = createFolderJob;
            this.$itemId = itemId;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new AnonymousClass2(this.$result, this.this$0, this.$itemId, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Object invoke(CoroutineScope coroutineScope, Continuation<? super Result<? extends FolderModel, ? extends DomainError>> continuation) {
            return invoke2(coroutineScope, (Continuation<? super Result<FolderModel, ? extends DomainError>>) continuation);
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(CoroutineScope coroutineScope, Continuation<? super Result<FolderModel, ? extends DomainError>> continuation) {
            return ((AnonymousClass2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Code duplicated, block: B:28:0x00ae  */
        /* JADX WARN: Code duplicated, block: B:30:0x00b2  */
        /* JADX WARN: Code duplicated, block: B:34:0x00db  */
        /* JADX WARN: Code restructure failed: missing block: B:20:0x009e, code lost:
        
            if (r8.jobSucceeded(r7, r11) == r0) goto L32;
         */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final java.lang.Object invokeSuspend(java.lang.Object r12) {
            /*
                Method dump skipped, instruction units count: 231
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: com.box.android.data.jobs.CreateFolderJob.AnonymousClass2.invokeSuspend(java.lang.Object):java.lang.Object");
        }
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    public final Object getLocalFolder(ItemId itemId, Continuation<? super FolderModel> continuation) throws UnsupportedEncodingException {
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
        Object itemByLocalId = anonymousClass1.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = anonymousClass1.label;
        if (i == 0) {
            ResultKt.throwOnFailure(itemByLocalId);
            LocalItemService localItemService = this.localItemService;
            anonymousClass1.L$0 = SpillingKt.nullOutSpilledVariable(itemId);
            anonymousClass1.label = 1;
            itemByLocalId = localItemService.getItemByLocalId(itemId, anonymousClass1);
            if (itemByLocalId == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(itemByLocalId);
        }
        Result result = (Result) itemByLocalId;
        if (result instanceof Result.Success) {
            Object value = ((Result.Success) result).getValue();
            Intrinsics.checkNotNull(value, "null cannot be cast to non-null type com.box.android.domain.models.item.FolderModel");
            return (FolderModel) value;
        }
        if (result instanceof Result.Error) {
            return null;
        }
        throw new NoWhenBranchMatchedException();
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    public final Object getServerId(ItemId itemId, Continuation<? super String> continuation) {
        C12401 c12401;
        if (continuation instanceof C12401) {
            c12401 = (C12401) continuation;
            if ((c12401.label & Integer.MIN_VALUE) != 0) {
                c12401.label -= Integer.MIN_VALUE;
            } else {
                c12401 = new C12401(continuation);
            }
        } else {
            c12401 = new C12401(continuation);
        }
        Object remoteIdOrError = c12401.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = c12401.label;
        if (i == 0) {
            ResultKt.throwOnFailure(remoteIdOrError);
            IdMappingService idMappingService = this.idMappingService;
            c12401.L$0 = SpillingKt.nullOutSpilledVariable(itemId);
            c12401.label = 1;
            remoteIdOrError = idMappingService.getRemoteIdOrError(itemId, c12401);
            if (remoteIdOrError == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(remoteIdOrError);
        }
        Result result = (Result) remoteIdOrError;
        if (result instanceof Result.Success) {
            return ((ItemId.Remote) ((Result.Success) result).getValue()).getBoxId();
        }
        if (result instanceof Result.Error) {
            return null;
        }
        throw new NoWhenBranchMatchedException();
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
        String string = this.inputData.getString(LOCAL_ID);
        Intrinsics.checkNotNull(string);
        return new CreateFolderJobInfoProvider(companion.create(string), this.localItemService, this.idMappingService);
    }
}
