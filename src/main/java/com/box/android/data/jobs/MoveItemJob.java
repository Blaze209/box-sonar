package com.box.android.data.jobs;

import android.content.Context;
import androidx.work.Data;
import com.box.android.data.persistence.jobs.JobEntity;
import com.box.android.domain.analytics.BoxAmplitudeAnalytics;
import com.box.android.domain.jobs.JobId;
import com.box.android.domain.jobs.JobRequest;
import com.box.android.domain.models.DisplayableJob;
import com.box.android.domain.models.IJobDisplayInfoProvider;
import com.box.android.domain.models.ItemId;
import com.box.android.domain.models.MetricsInfoProvider;
import com.box.android.domain.models.MoveItemJobInfoProvider;
import com.box.android.domain.services.ILocalItemService;
import com.box.android.domain.services.IRemoteItemService;
import com.box.android.domain.services.IdMappingService;
import com.box.brownfieldApi.featuresNavigator.activities.ReactNativeFeatureActivity;
import dagger.assisted.Assisted;
import dagger.assisted.AssistedFactory;
import dagger.assisted.AssistedInject;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.collections.SetsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: MoveItemJob.kt */
/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000j\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010$\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 +2\u00020\u00012\u00020\u00022\u00020\u0003:\u0002+,BM\b\u0007\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\b\b\u0001\u0010\f\u001a\u00020\r\u0012\b\b\u0001\u0010\u000e\u001a\u00020\u000f\u0012\u0006\u0010\u0010\u001a\u00020\u0011\u0012\u0006\u0010\u0012\u001a\u00020\u0013¢\u0006\u0004\b\u0014\u0010\u0015J\u000e\u0010\u001e\u001a\u00020\u001fH\u0096@¢\u0006\u0002\u0010 J\u000e\u0010!\u001a\u00020\u001fH\u0096@¢\u0006\u0002\u0010 J\u000e\u0010\"\u001a\u00020#H\u0096@¢\u0006\u0002\u0010 J\b\u0010$\u001a\u00020%H\u0016J\u001a\u0010&\u001a\u000e\u0012\u0004\u0012\u00020%\u0012\u0004\u0012\u00020(0'H\u0096@¢\u0006\u0002\u0010 J\b\u0010)\u001a\u00020*H\u0016R\u0014\u0010\u0004\u001a\u00020\u0005X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u0014\u0010\u0006\u001a\u00020\u0007X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\f\u001a\u00020\r¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u001bR\u0011\u0010\u000e\u001a\u00020\u000f¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001dR\u000e\u0010\u0010\u001a\u00020\u0011X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006-"}, d2 = {"Lcom/box/android/data/jobs/MoveItemJob;", "Lcom/box/android/data/jobs/Job;", "Lcom/box/android/domain/models/DisplayableJob;", "Lcom/box/android/domain/models/MetricsInfoProvider;", "appContext", "Landroid/content/Context;", "jobService", "Lcom/box/android/data/jobs/JobService;", "localItemService", "Lcom/box/android/domain/services/ILocalItemService;", "remoteService", "Lcom/box/android/domain/services/IRemoteItemService;", JobWorker.JOB_ID_PARAM, "Lcom/box/android/domain/jobs/JobId;", "inputData", "Landroidx/work/Data;", "idMappingService", "Lcom/box/android/domain/services/IdMappingService;", "inputValidator", "Lcom/box/android/data/jobs/IMoveCopyJobInputValidator;", "<init>", "(Landroid/content/Context;Lcom/box/android/data/jobs/JobService;Lcom/box/android/domain/services/ILocalItemService;Lcom/box/android/domain/services/IRemoteItemService;Lcom/box/android/domain/jobs/JobId;Landroidx/work/Data;Lcom/box/android/domain/services/IdMappingService;Lcom/box/android/data/jobs/IMoveCopyJobInputValidator;)V", "getAppContext", "()Landroid/content/Context;", "getJobService", "()Lcom/box/android/data/jobs/JobService;", "getJobId", "()Lcom/box/android/domain/jobs/JobId;", "getInputData", "()Landroidx/work/Data;", "start", "", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "cleanup", "shouldBeRemovedFromDbOnSuccess", "", "getAmplitudeJobType", "", "getAmplitudeInfos", "", "", "getJobDisplayInfoProvider", "Lcom/box/android/domain/models/IJobDisplayInfoProvider;", "Companion", "Factory", "data_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class MoveItemJob implements Job, DisplayableJob, MetricsInfoProvider {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public static final String DESTINATION_FOLDER_ID = "destinationFolderIdParam";
    public static final String ITEM_ID_PARAM = "itemIdParam";
    private final Context appContext;
    private final IdMappingService idMappingService;
    private final Data inputData;
    private final IMoveCopyJobInputValidator inputValidator;
    private final JobId jobId;
    private final JobService jobService;
    private final ILocalItemService localItemService;
    private final IRemoteItemService remoteService;

    /* JADX INFO: compiled from: MoveItemJob.kt */
    @AssistedFactory
    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bg\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H&¨\u0006\bÀ\u0006\u0003"}, d2 = {"Lcom/box/android/data/jobs/MoveItemJob$Factory;", "", "createJob", "Lcom/box/android/data/jobs/MoveItemJob;", JobWorker.JOB_ID_PARAM, "Lcom/box/android/domain/jobs/JobId;", "inputData", "Landroidx/work/Data;", "data_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public interface Factory {
        MoveItemJob createJob(JobId jobId, Data inputData);
    }

    /* JADX INFO: renamed from: com.box.android.data.jobs.MoveItemJob$start$1, reason: invalid class name */
    /* JADX INFO: compiled from: MoveItemJob.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.box.android.data.jobs.MoveItemJob", f = "MoveItemJob.kt", i = {0, 0, 1, 1, 1, 2, 2, 3, 3, 4, 4, 4, 4, 4, 4, 5, 5, 5, 5, 5, 5}, l = {56, 60, 64, 72, 78, 80}, m = "start", n = {"$this$start_u24lambda_u240", "$i$a$-runCatching-MoveItemJob$start$result$1", ReactNativeFeatureActivity.RESULT_EXTRA_KEY, "it", "$i$a$-getOrElse-MoveItemJob$start$validationResult$1", ReactNativeFeatureActivity.RESULT_EXTRA_KEY, "validationResult", ReactNativeFeatureActivity.RESULT_EXTRA_KEY, "validationResult", ReactNativeFeatureActivity.RESULT_EXTRA_KEY, "validationResult", "$this$onSuccess$iv", "it", "$i$f$onSuccess", "$i$a$-onSuccess-MoveItemJob$start$2", ReactNativeFeatureActivity.RESULT_EXTRA_KEY, "validationResult", "$this$onError$iv", "it", "$i$f$onError", "$i$a$-onError-MoveItemJob$start$3"}, s = {"L$0", "I$0", "L$0", "L$1", "I$0", "L$0", "L$1", "L$0", "L$1", "L$0", "L$1", "L$2", "L$3", "I$0", "I$1", "L$0", "L$1", "L$2", "L$3", "I$0", "I$1"}, v = 1)
    static final class AnonymousClass1 extends ContinuationImpl {
        int I$0;
        int I$1;
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        int label;
        /* synthetic */ Object result;

        AnonymousClass1(Continuation<? super AnonymousClass1> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return MoveItemJob.this.start(this);
        }
    }

    @AssistedInject
    public MoveItemJob(Context appContext, JobService jobService, ILocalItemService localItemService, IRemoteItemService remoteService, @Assisted JobId jobId, @Assisted Data inputData, IdMappingService idMappingService, IMoveCopyJobInputValidator inputValidator) {
        Intrinsics.checkNotNullParameter(appContext, "appContext");
        Intrinsics.checkNotNullParameter(jobService, "jobService");
        Intrinsics.checkNotNullParameter(localItemService, "localItemService");
        Intrinsics.checkNotNullParameter(remoteService, "remoteService");
        Intrinsics.checkNotNullParameter(jobId, "jobId");
        Intrinsics.checkNotNullParameter(inputData, "inputData");
        Intrinsics.checkNotNullParameter(idMappingService, "idMappingService");
        Intrinsics.checkNotNullParameter(inputValidator, "inputValidator");
        this.appContext = appContext;
        this.jobService = jobService;
        this.localItemService = localItemService;
        this.remoteService = remoteService;
        this.jobId = jobId;
        this.inputData = inputData;
        this.idMappingService = idMappingService;
        this.inputValidator = inputValidator;
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

    /* JADX INFO: compiled from: MoveItemJob.kt */
    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\"\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J&\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\n2\u000e\b\u0002\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00050\rR\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u000e"}, d2 = {"Lcom/box/android/data/jobs/MoveItemJob$Companion;", "", "<init>", "()V", "ITEM_ID_PARAM", "", "DESTINATION_FOLDER_ID", "getRequest", "Lcom/box/android/domain/jobs/JobRequest;", "itemId", "Lcom/box/android/domain/models/ItemId;", "destinationFolderId", "tags", "", "data_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ JobRequest getRequest$default(Companion companion, ItemId itemId, ItemId itemId2, Set set, int i, Object obj) {
            if ((i & 4) != 0) {
                set = SetsKt.emptySet();
            }
            return companion.getRequest(itemId, itemId2, set);
        }

        public final JobRequest getRequest(ItemId itemId, ItemId destinationFolderId, Set<String> tags) {
            Intrinsics.checkNotNullParameter(itemId, "itemId");
            Intrinsics.checkNotNullParameter(destinationFolderId, "destinationFolderId");
            Intrinsics.checkNotNullParameter(tags, "tags");
            JobRequest.Builder builder = new JobRequest.Builder("MoveItem", null, null, null, 14, null);
            Data.Builder builder2 = new Data.Builder();
            builder2.putString("itemIdParam", itemId.toString());
            builder2.putString("destinationFolderIdParam", destinationFolderId.toString());
            builder.setData(builder2.build());
            builder.setTags(SetsKt.plus(SetsKt.setOf("move_item:" + itemId), (Iterable) tags));
            return builder.build();
        }
    }

    /* JADX WARN: Code duplicated, block: B:15:0x0067 A[PHI: r2 r3 r12
      0x0067: PHI (r2v6 com.box.android.data.jobs.MoveCopyJobInputValidator$ValidationResult) = 
      (r2v5 com.box.android.data.jobs.MoveCopyJobInputValidator$ValidationResult)
      (r2v19 com.box.android.data.jobs.MoveCopyJobInputValidator$ValidationResult)
     binds: [B:36:0x0128, B:14:0x005e] A[DONT_GENERATE, DONT_INLINE]
      0x0067: PHI (r3v6 java.lang.Object) = (r3v5 java.lang.Object), (r3v11 java.lang.Object) binds: [B:36:0x0128, B:14:0x005e] A[DONT_GENERATE, DONT_INLINE]
      0x0067: PHI (r12v10 java.lang.Object) = (r12v9 java.lang.Object), (r12v1 java.lang.Object) binds: [B:36:0x0128, B:14:0x005e] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:31:0x00c4  */
    /* JADX WARN: Code duplicated, block: B:34:0x0106  */
    /* JADX WARN: Code duplicated, block: B:40:0x0133  */
    /* JADX WARN: Code duplicated, block: B:43:0x0165  */
    /* JADX WARN: Code duplicated, block: B:47:0x016d  */
    /* JADX WARN: Code duplicated, block: B:49:0x0171  */
    /* JADX WARN: Code duplicated, block: B:52:0x01a2  */
    /* JADX WARN: Code duplicated, block: B:56:0x01ab  */
    /* JADX WARN: Code duplicated, block: B:58:0x01b1  */
    /* JADX WARN: Code duplicated, block: B:60:0x01bf  */
    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    /* JADX WARN: Code restructure failed: missing block: B:50:0x019f, code lost:
    
        if (r7.jobFailed(r11, "MoveItem", r12, r0) == r1) goto L63;
     */
    /* JADX WARN: Code restructure failed: missing block: B:62:0x01da, code lost:
    
        if (r3.jobFailed(r11, "MoveItem", r7, r0) == r1) goto L63;
     */
    @Override // com.box.android.data.jobs.Job
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.Object start(kotlin.coroutines.Continuation<? super kotlin.Unit> r12) {
        /*
            Method dump skipped, instruction units count: 498
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.box.android.data.jobs.MoveItemJob.start(kotlin.coroutines.Continuation):java.lang.Object");
    }

    @Override // com.box.android.data.jobs.Job
    public Object cleanup(Continuation<? super Unit> continuation) {
        return Unit.INSTANCE;
    }

    @Override // com.box.android.data.jobs.Job
    public Object shouldBeRemovedFromDbOnSuccess(Continuation<? super Boolean> continuation) {
        return Boxing.boxBoolean(true);
    }

    @Override // com.box.android.domain.models.MetricsInfoProvider
    public String getAmplitudeJobType() {
        return BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_MOVE_JOB;
    }

    @Override // com.box.android.domain.models.MetricsInfoProvider
    public Object getAmplitudeInfos(Continuation<? super Map<String, ? extends Object>> continuation) {
        return MapsKt.emptyMap();
    }

    @Override // com.box.android.domain.models.DisplayableJob
    public IJobDisplayInfoProvider getJobDisplayInfoProvider() {
        ItemId.Companion companion = ItemId.INSTANCE;
        String string = this.inputData.getString("itemIdParam");
        Intrinsics.checkNotNull(string);
        return new MoveItemJobInfoProvider(companion.create(string), this.localItemService, this.idMappingService);
    }
}
