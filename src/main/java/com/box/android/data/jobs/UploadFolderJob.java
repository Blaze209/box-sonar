package com.box.android.data.jobs;

import android.content.Context;
import android.net.Uri;
import androidx.media3.extractor.ts.TsExtractor;
import androidx.work.Data;
import com.box.android.common.utilities.BoxCommonConstants;
import com.box.android.data.mappers.annotation.AnnotationEntityDomainMapperKt;
import com.box.android.data.persistence.jobs.JobEntity;
import com.box.android.data.service.impl.DomainErrorMapper;
import com.box.android.data.service.impl.LocalItemService;
import com.box.android.data.service.impl.RemoteItemService;
import com.box.android.domain.jobs.JobConstants;
import com.box.android.domain.jobs.JobId;
import com.box.android.domain.jobs.JobRequest;
import com.box.android.domain.jobs.JobType;
import com.box.android.domain.localrepo.IBoxStorage;
import com.box.android.domain.models.DisplayableJob;
import com.box.android.domain.models.DomainError;
import com.box.android.domain.models.IGenericError;
import com.box.android.domain.models.IJobDisplayInfoProvider;
import com.box.android.domain.models.ItemId;
import com.box.android.domain.models.MetricKeysParam;
import com.box.android.domain.models.MetricsInfoProvider;
import com.box.android.domain.models.UploadFolderJobDisplayInfoProvider;
import com.box.android.domain.models.item.FolderModel;
import com.box.android.domain.models.item.ItemModel;
import com.box.android.domain.services.IdMappingService;
import com.box.android.domain.utils.result.Result;
import com.box.androidsdk.content.models.BoxRepresentation;
import com.google.common.util.concurrent.AtomicDouble;
import com.squareup.moshi.JsonAdapter;
import com.squareup.moshi.Moshi;
import dagger.assisted.Assisted;
import dagger.assisted.AssistedFactory;
import dagger.assisted.AssistedInject;
import external.sdk.pendo.io.mozilla.javascript.Token;
import java.io.UnsupportedEncodingException;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.collections.SetsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
import kotlin.text.StringsKt;
import org.apache.hc.core5.http.HttpStatus;
import sdk.pendo.io.events.IdentificationData;

/* JADX INFO: compiled from: UploadFolderJob.kt */
/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000Ð\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\"\n\u0002\b\u000b\n\u0002\u0010\u0006\n\u0002\b\u0003\n\u0002\u0010\u0012\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010$\n\u0002\b\u0006\u0018\u0000 u2\u00020\u00012\u00020\u00022\u00020\u0003:\u0002uvBU\b\u0007\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0001\u0010\b\u001a\u00020\t\u0012\b\b\u0001\u0010\n\u001a\u00020\u000b\u0012\u0006\u0010\f\u001a\u00020\r\u0012\u0006\u0010\u000e\u001a\u00020\u000f\u0012\u0006\u0010\u0010\u001a\u00020\u0011\u0012\u0006\u0010\u0012\u001a\u00020\u0013\u0012\u0006\u0010\u0014\u001a\u00020\u0015¢\u0006\u0004\b\u0016\u0010\u0017J\u000e\u00104\u001a\u000205H\u0096@¢\u0006\u0002\u00106J\u000e\u00107\u001a\u000205H\u0087@¢\u0006\u0002\u00106J\u001a\u00108\u001a\u000e\u0012\u0004\u0012\u00020:\u0012\u0004\u0012\u00020%09H\u0087@¢\u0006\u0002\u00106J\"\u0010;\u001a\u000e\u0012\u0004\u0012\u00020:\u0012\u0004\u0012\u00020%092\u0006\u0010<\u001a\u00020:H\u0087@¢\u0006\u0002\u0010=J\u001c\u0010>\u001a\u000e\u0012\u0004\u0012\u00020?\u0012\u0004\u0012\u00020%092\u0006\u0010@\u001a\u00020%H\u0003J\u000e\u0010A\u001a\u000205H\u0087@¢\u0006\u0002\u00106J\u0010\u0010B\u001a\u00020C2\u0006\u0010D\u001a\u00020CH\u0007JN\u0010E\u001a\u000e\u0012\u0004\u0012\u00020F\u0012\u0004\u0012\u00020%092\u0006\u0010G\u001a\u00020H2\u0006\u0010I\u001a\u00020J2\u0006\u0010K\u001a\u00020C2\u000e\b\u0002\u0010L\u001a\b\u0012\u0004\u0012\u00020H0M2\n\b\u0002\u0010N\u001a\u0004\u0018\u00010JH\u0087@¢\u0006\u0002\u0010OJ@\u0010P\u001a\u000e\u0012\u0004\u0012\u00020F\u0012\u0004\u0012\u00020%092\u0006\u0010G\u001a\u00020H2\u0006\u0010I\u001a\u00020J2\u0006\u0010K\u001a\u00020C2\f\u0010L\u001a\b\u0012\u0004\u0012\u00020H0MH\u0087@¢\u0006\u0002\u0010QJ\u0016\u0010R\u001a\u0002052\u0006\u0010S\u001a\u00020\tH\u0096@¢\u0006\u0002\u0010TJ\u001e\u0010U\u001a\u0002052\u0006\u0010S\u001a\u00020\t2\u0006\u0010@\u001a\u00020%H\u0096@¢\u0006\u0002\u0010VJ&\u0010W\u001a\u0002052\u0006\u0010S\u001a\u00020\t2\u0006\u0010X\u001a\u00020Y2\u0006\u00101\u001a\u00020YH\u0096@¢\u0006\u0002\u0010ZJ\u001e\u0010[\u001a\u0002052\u0006\u0010S\u001a\u00020\t2\u0006\u0010\\\u001a\u00020]H\u0096@¢\u0006\u0002\u0010^J<\u0010_\u001a\u0002052\b\b\u0002\u0010`\u001a\u00020a2\"\u0010b\u001a\u001e\b\u0001\u0012\u0004\u0012\u00020:\u0012\n\u0012\b\u0012\u0004\u0012\u0002050d\u0012\u0006\u0012\u0004\u0018\u00010e0cH\u0086@¢\u0006\u0002\u0010fJ\u001c\u0010g\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u00010:\u0012\u0004\u0012\u00020%09H\u0086@¢\u0006\u0002\u00106J\u000e\u0010h\u001a\u000205H\u0087@¢\u0006\u0002\u00106J\u000e\u0010i\u001a\u000205H\u0096@¢\u0006\u0002\u00106J\u000e\u0010j\u001a\u00020aH\u0096@¢\u0006\u0002\u00106J\b\u0010k\u001a\u00020lH\u0016J\b\u0010m\u001a\u00020aH\u0016J\b\u0010n\u001a\u00020aH\u0002J\b\u0010o\u001a\u00020HH\u0016J\u001a\u0010p\u001a\u000e\u0012\u0004\u0012\u00020H\u0012\u0004\u0012\u00020e0qH\u0096@¢\u0006\u0002\u00106J\u0010\u0010r\u001a\u00020]2\u0006\u0010<\u001a\u00020:H\u0007J\u0010\u0010s\u001a\u00020:2\u0006\u0010t\u001a\u00020]H\u0007R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R\u0011\u0010\n\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u001bR\u0014\u0010\f\u001a\u00020\rX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001dR\u0014\u0010\u000e\u001a\u00020\u000fX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001fR\u000e\u0010\u0010\u001a\u00020\u0011X\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0012\u001a\u00020\u0013¢\u0006\b\n\u0000\u001a\u0004\b \u0010!R\u0011\u0010\u0014\u001a\u00020\u0015¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010#R&\u0010$\u001a\u0004\u0018\u00010%8\u0006@\u0006X\u0087\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b&\u0010'\u001a\u0004\b(\u0010)\"\u0004\b*\u0010+R\u001c\u0010,\u001a\u00020-8\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b.\u0010'\u001a\u0004\b/\u00100R\u001c\u00101\u001a\u00020-8\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b2\u0010'\u001a\u0004\b3\u00100¨\u0006w"}, d2 = {"Lcom/box/android/data/jobs/UploadFolderJob;", "Lcom/box/android/data/jobs/ParentJob;", "Lcom/box/android/domain/models/DisplayableJob;", "Lcom/box/android/domain/models/MetricsInfoProvider;", "localItemService", "Lcom/box/android/data/service/impl/LocalItemService;", "moshi", "Lcom/squareup/moshi/Moshi;", JobWorker.JOB_ID_PARAM, "Lcom/box/android/domain/jobs/JobId;", "inputData", "Landroidx/work/Data;", "appContext", "Landroid/content/Context;", "jobService", "Lcom/box/android/data/jobs/JobService;", "idMappingService", "Lcom/box/android/domain/services/IdMappingService;", "remoteItemService", "Lcom/box/android/data/service/impl/RemoteItemService;", "boxStorage", "Lcom/box/android/domain/localrepo/IBoxStorage;", "<init>", "(Lcom/box/android/data/service/impl/LocalItemService;Lcom/squareup/moshi/Moshi;Lcom/box/android/domain/jobs/JobId;Landroidx/work/Data;Landroid/content/Context;Lcom/box/android/data/jobs/JobService;Lcom/box/android/domain/services/IdMappingService;Lcom/box/android/data/service/impl/RemoteItemService;Lcom/box/android/domain/localrepo/IBoxStorage;)V", "getJobId", "()Lcom/box/android/domain/jobs/JobId;", "getInputData", "()Landroidx/work/Data;", "getAppContext", "()Landroid/content/Context;", "getJobService", "()Lcom/box/android/data/jobs/JobService;", "getRemoteItemService", "()Lcom/box/android/data/service/impl/RemoteItemService;", "getBoxStorage", "()Lcom/box/android/domain/localrepo/IBoxStorage;", "lastRecordError", "Lcom/box/android/domain/models/DomainError;", "getLastRecordError$annotations", "()V", "getLastRecordError", "()Lcom/box/android/domain/models/DomainError;", "setLastRecordError", "(Lcom/box/android/domain/models/DomainError;)V", "progress", "Lcom/google/common/util/concurrent/AtomicDouble;", "getProgress$annotations", "getProgress", "()Lcom/google/common/util/concurrent/AtomicDouble;", "estimatedWork", "getEstimatedWork$annotations", "getEstimatedWork", "start", "", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "checkCompletion", "initialRunningInfo", "Lcom/box/android/domain/utils/result/Result;", "Lcom/box/android/data/jobs/UploadFolderRunningInfo;", "createFolder", "runningInfo", "(Lcom/box/android/data/jobs/UploadFolderRunningInfo;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "recoverFromNameConflict", "Lcom/box/android/domain/models/item/ItemModel;", "domainError", "enqueueUploads", "encodeTreeUri", "Landroid/net/Uri;", "uri", "uploadNestedFile", "Lcom/box/android/domain/jobs/JobRequest;", "name", "", IdentificationData.FIELD_PARENT_ID, "Lcom/box/android/domain/models/ItemId;", "contentUrl", "tags", "", "fileId", "(Ljava/lang/String;Lcom/box/android/domain/models/ItemId;Landroid/net/Uri;Ljava/util/Set;Lcom/box/android/domain/models/ItemId;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "uploadNestedFolder", "(Ljava/lang/String;Lcom/box/android/domain/models/ItemId;Landroid/net/Uri;Ljava/util/Set;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "childSucceeded", "childJobId", "(Lcom/box/android/domain/jobs/JobId;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "childFailed", "(Lcom/box/android/domain/jobs/JobId;Lcom/box/android/domain/models/DomainError;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "childProgressed", "currentProgress", "", "(Lcom/box/android/domain/jobs/JobId;DDLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "receiveFromChild", BoxRepresentation.FIELD_INFO, "", "(Lcom/box/android/domain/jobs/JobId;[BLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "updatingRunningInfo", "isLockNeeded", "", "updateRunningData", "Lkotlin/Function2;", "Lkotlin/coroutines/Continuation;", "", "(ZLkotlin/jvm/functions/Function2;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getRunningInfo", "initProgress", "cleanup", "shouldBeRemovedFromDbOnSuccess", "getJobDisplayInfoProvider", "Lcom/box/android/domain/models/IJobDisplayInfoProvider;", "shouldDisplay", "shouldDisplayInJobsUi", "getAmplitudeJobType", "getAmplitudeInfos", "", "runningInfoToByteArray", "byteArrayToRunningInfo", "byteArray", "Companion", "Factory", "data_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class UploadFolderJob implements ParentJob, DisplayableJob, MetricsInfoProvider {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public static final String LOCAL_FOLDER_ID_PARAM = "localFolderIdParam";
    private final Context appContext;
    private final IBoxStorage boxStorage;
    private final AtomicDouble estimatedWork;
    private final IdMappingService idMappingService;
    private final Data inputData;
    private final JobId jobId;
    private final JobService jobService;
    private DomainError lastRecordError;
    private final LocalItemService localItemService;
    private final Moshi moshi;
    private final AtomicDouble progress;
    private final RemoteItemService remoteItemService;

    /* JADX INFO: compiled from: UploadFolderJob.kt */
    @AssistedFactory
    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bg\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H&¨\u0006\bÀ\u0006\u0003"}, d2 = {"Lcom/box/android/data/jobs/UploadFolderJob$Factory;", "", "createJob", "Lcom/box/android/data/jobs/UploadFolderJob;", JobWorker.JOB_ID_PARAM, "Lcom/box/android/domain/jobs/JobId;", "inputData", "Landroidx/work/Data;", "data_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public interface Factory {
        UploadFolderJob createJob(JobId jobId, Data inputData);
    }

    /* JADX INFO: renamed from: com.box.android.data.jobs.UploadFolderJob$createFolder$1, reason: invalid class name */
    /* JADX INFO: compiled from: UploadFolderJob.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.box.android.data.jobs.UploadFolderJob", f = "UploadFolderJob.kt", i = {0, 0, 1, 1, 1, 1, 2, 2, 2, 2, 2, 2, 2, 2, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 4, 4, 4, 4, 4, 4, 4, 4}, l = {185, 190, 193, 195, 198}, m = "createFolder", n = {"runningInfo", IdentificationData.FIELD_PARENT_ID, "runningInfo", IdentificationData.FIELD_PARENT_ID, "parentServerId", "localFolderId", "runningInfo", IdentificationData.FIELD_PARENT_ID, "parentServerId", "localFolderId", "$this$flatMap$iv", "folderModel", "$i$f$flatMap", "$i$a$-flatMap-UploadFolderJob$createFolder$3", "runningInfo", IdentificationData.FIELD_PARENT_ID, "parentServerId", "localFolderId", "$this$flatMap$iv", "folderModel", "it", "$i$f$flatMap", "$i$a$-flatMap-UploadFolderJob$createFolder$3", "$i$a$-also-UploadFolderJob$createFolder$3$2", "runningInfo", IdentificationData.FIELD_PARENT_ID, "parentServerId", "localFolderId", "$this$flatMap$iv", "newRunningInfo", "$i$f$flatMap", "$i$a$-flatMap-UploadFolderJob$createFolder$4"}, s = {"L$0", "L$1", "L$0", "L$1", "L$2", "L$3", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "I$0", "I$1", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$7", "I$0", "I$1", "I$2", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "I$0", "I$1"}, v = 1)
    static final class AnonymousClass1 extends ContinuationImpl {
        int I$0;
        int I$1;
        int I$2;
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        Object L$4;
        Object L$5;
        Object L$6;
        Object L$7;
        int label;
        /* synthetic */ Object result;

        AnonymousClass1(Continuation<? super AnonymousClass1> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return UploadFolderJob.this.createFolder(null, this);
        }
    }

    /* JADX INFO: renamed from: com.box.android.data.jobs.UploadFolderJob$getRunningInfo$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: UploadFolderJob.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.box.android.data.jobs.UploadFolderJob", f = "UploadFolderJob.kt", i = {}, l = {446}, m = "getRunningInfo", n = {}, s = {}, v = 1)
    static final class C13511 extends ContinuationImpl {
        int label;
        /* synthetic */ Object result;

        C13511(Continuation<? super C13511> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return UploadFolderJob.this.getRunningInfo(this);
        }
    }

    /* JADX INFO: renamed from: com.box.android.data.jobs.UploadFolderJob$initProgress$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: UploadFolderJob.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.box.android.data.jobs.UploadFolderJob", f = "UploadFolderJob.kt", i = {1, 1}, l = {456, 459}, m = "initProgress", n = {"runningInfo", "$i$a$-let-UploadFolderJob$initProgress$2"}, s = {"L$0", "I$0"}, v = 1)
    static final class C13521 extends ContinuationImpl {
        int I$0;
        Object L$0;
        int label;
        /* synthetic */ Object result;

        C13521(Continuation<? super C13521> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return UploadFolderJob.this.initProgress(this);
        }
    }

    /* JADX INFO: renamed from: com.box.android.data.jobs.UploadFolderJob$initialRunningInfo$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: UploadFolderJob.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.box.android.data.jobs.UploadFolderJob", f = "UploadFolderJob.kt", i = {0, 1, 1, 1, 2, 2, 2, 2}, l = {Token.SET_REF_OP, 150, TsExtractor.TS_STREAM_TYPE_AC4}, m = "initialRunningInfo", n = {"localFolderId", "localFolderId", "folderModel", "parentFolderId", "localFolderId", "folderModel", "parentFolderId", "newRunningInfo"}, s = {"L$0", "L$0", "L$1", "L$2", "L$0", "L$1", "L$2", "L$3"}, v = 1)
    static final class C13531 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        int label;
        /* synthetic */ Object result;

        C13531(Continuation<? super C13531> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return UploadFolderJob.this.initialRunningInfo(this);
        }
    }

    /* JADX INFO: renamed from: com.box.android.data.jobs.UploadFolderJob$start$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: UploadFolderJob.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.box.android.data.jobs.UploadFolderJob", f = "UploadFolderJob.kt", i = {2, 2, 3, 4, 4, 4, 4, 4, 5, 6, 7}, l = {95, 96, 97, 104, 106, 109, 110, 112}, m = "start", n = {"$this$start_u24lambda_u240", "$i$a$-run-UploadFolderJob$start$runningInfo$1", "runningInfo", "runningInfo", "$this$onError$iv", "it", "$i$f$onError", "$i$a$-onError-UploadFolderJob$start$2", "runningInfo", "runningInfo", "e"}, s = {"L$0", "I$0", "L$0", "L$0", "L$1", "L$2", "I$0", "I$1", "L$0", "L$0", "L$0"}, v = 1)
    static final class C13551 extends ContinuationImpl {
        int I$0;
        int I$1;
        Object L$0;
        Object L$1;
        Object L$2;
        int label;
        /* synthetic */ Object result;

        C13551(Continuation<? super C13551> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return UploadFolderJob.this.start(this);
        }
    }

    /* JADX INFO: renamed from: com.box.android.data.jobs.UploadFolderJob$updatingRunningInfo$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: UploadFolderJob.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.box.android.data.jobs.UploadFolderJob", f = "UploadFolderJob.kt", i = {0, 0, 1, 1, 2, 2, 2, 2}, l = {433, 439, 440}, m = "updatingRunningInfo", n = {"updateRunningData", "isLockNeeded", "updateRunningData", "isLockNeeded", "updateRunningData", "it", "isLockNeeded", "$i$a$-let-UploadFolderJob$updatingRunningInfo$3"}, s = {"L$0", "Z$0", "L$0", "Z$0", "L$0", "L$1", "Z$0", "I$0"}, v = 1)
    static final class C13561 extends ContinuationImpl {
        int I$0;
        Object L$0;
        Object L$1;
        boolean Z$0;
        int label;
        /* synthetic */ Object result;

        C13561(Continuation<? super C13561> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return UploadFolderJob.this.updatingRunningInfo(false, null, this);
        }
    }

    /* JADX INFO: renamed from: com.box.android.data.jobs.UploadFolderJob$uploadNestedFile$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: UploadFolderJob.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.box.android.data.jobs.UploadFolderJob", f = "UploadFolderJob.kt", i = {0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1}, l = {343, 346}, m = "uploadNestedFile", n = {"name", IdentificationData.FIELD_PARENT_ID, "contentUrl", "tags", "fileId", "name", IdentificationData.FIELD_PARENT_ID, "contentUrl", "tags", "fileId", "$this$flatMap$iv", "fileModel", "uploadRequest", "$i$f$flatMap", "$i$a$-flatMap-UploadFolderJob$uploadNestedFile$2"}, s = {"L$0", "L$1", "L$2", "L$3", "L$4", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "I$0", "I$1"}, v = 1)
    static final class C13581 extends ContinuationImpl {
        int I$0;
        int I$1;
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        Object L$4;
        Object L$5;
        Object L$6;
        Object L$7;
        int label;
        /* synthetic */ Object result;

        C13581(Continuation<? super C13581> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return UploadFolderJob.this.uploadNestedFile(null, null, null, null, null, this);
        }
    }

    /* JADX INFO: renamed from: com.box.android.data.jobs.UploadFolderJob$uploadNestedFolder$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: UploadFolderJob.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.box.android.data.jobs.UploadFolderJob", f = "UploadFolderJob.kt", i = {0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1}, l = {363, 366}, m = "uploadNestedFolder", n = {"name", IdentificationData.FIELD_PARENT_ID, "contentUrl", "tags", "name", IdentificationData.FIELD_PARENT_ID, "contentUrl", "tags", "$this$flatMap$iv", "localItem", "uploadRequest", "$i$f$flatMap", "$i$a$-flatMap-UploadFolderJob$uploadNestedFolder$2"}, s = {"L$0", "L$1", "L$2", "L$3", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "I$0", "I$1"}, v = 1)
    static final class C13591 extends ContinuationImpl {
        int I$0;
        int I$1;
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        Object L$4;
        Object L$5;
        Object L$6;
        int label;
        /* synthetic */ Object result;

        C13591(Continuation<? super C13591> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return UploadFolderJob.this.uploadNestedFolder(null, null, null, null, this);
        }
    }

    public static /* synthetic */ void getEstimatedWork$annotations() {
    }

    public static /* synthetic */ void getLastRecordError$annotations() {
    }

    public static /* synthetic */ void getProgress$annotations() {
    }

    @AssistedInject
    public UploadFolderJob(LocalItemService localItemService, Moshi moshi, @Assisted JobId jobId, @Assisted Data inputData, Context appContext, JobService jobService, IdMappingService idMappingService, RemoteItemService remoteItemService, IBoxStorage boxStorage) {
        Intrinsics.checkNotNullParameter(localItemService, "localItemService");
        Intrinsics.checkNotNullParameter(moshi, "moshi");
        Intrinsics.checkNotNullParameter(jobId, "jobId");
        Intrinsics.checkNotNullParameter(inputData, "inputData");
        Intrinsics.checkNotNullParameter(appContext, "appContext");
        Intrinsics.checkNotNullParameter(jobService, "jobService");
        Intrinsics.checkNotNullParameter(idMappingService, "idMappingService");
        Intrinsics.checkNotNullParameter(remoteItemService, "remoteItemService");
        Intrinsics.checkNotNullParameter(boxStorage, "boxStorage");
        this.localItemService = localItemService;
        this.moshi = moshi;
        this.jobId = jobId;
        this.inputData = inputData;
        this.appContext = appContext;
        this.jobService = jobService;
        this.idMappingService = idMappingService;
        this.remoteItemService = remoteItemService;
        this.boxStorage = boxStorage;
        this.progress = new AtomicDouble(-1.0d);
        this.estimatedWork = new AtomicDouble(-1.0d);
    }

    @Override // com.box.android.data.jobs.Job
    public /* bridge */ Object run(JobEntity jobEntity, Continuation<? super Unit> continuation) {
        return super.run(jobEntity, continuation);
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

    public final RemoteItemService getRemoteItemService() {
        return this.remoteItemService;
    }

    public final IBoxStorage getBoxStorage() {
        return this.boxStorage;
    }

    /* JADX INFO: compiled from: UploadFolderJob.kt */
    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\"\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J0\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00050\u000b2\b\b\u0002\u0010\f\u001a\u00020\r2\b\b\u0002\u0010\u000e\u001a\u00020\rR\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u000f"}, d2 = {"Lcom/box/android/data/jobs/UploadFolderJob$Companion;", "", "<init>", "()V", "LOCAL_FOLDER_ID_PARAM", "", "getRequest", "Lcom/box/android/domain/jobs/JobRequest;", "folderId", "Lcom/box/android/domain/models/ItemId;", "tags", "", "showInJobsUI", "", JobConstants.SHOW_NOTIFICATION, "data_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public static /* synthetic */ JobRequest getRequest$default(Companion companion, ItemId itemId, Set set, boolean z, boolean z2, int i, Object obj) {
            if ((i & 4) != 0) {
                z = true;
            }
            if ((i & 8) != 0) {
                z2 = true;
            }
            return companion.getRequest(itemId, set, z, z2);
        }

        public final JobRequest getRequest(ItemId folderId, Set<String> tags, boolean showInJobsUI, boolean showNotification) {
            Intrinsics.checkNotNullParameter(folderId, "folderId");
            Intrinsics.checkNotNullParameter(tags, "tags");
            JobRequest.Builder builder = new JobRequest.Builder(JobType.UPLOAD_FOLDER_V2, null, null, null, 14, null);
            Data.Builder builder2 = new Data.Builder();
            builder2.putString(UploadFolderJob.LOCAL_FOLDER_ID_PARAM, folderId.toString());
            builder2.putBoolean(JobConstants.SHOULD_DISPLAY_JOB, showInJobsUI);
            builder2.putBoolean(JobConstants.SHOW_NOTIFICATION, showNotification);
            builder.setData(builder2.build());
            builder.setTags(SetsKt.plus(SetsKt.setOf("upload_folder:" + folderId), (Iterable) tags));
            return builder.build();
        }
    }

    public final DomainError getLastRecordError() {
        return this.lastRecordError;
    }

    public final void setLastRecordError(DomainError domainError) {
        this.lastRecordError = domainError;
    }

    public final AtomicDouble getProgress() {
        return this.progress;
    }

    public final AtomicDouble getEstimatedWork() {
        return this.estimatedWork;
    }

    /* JADX WARN: Code duplicated, block: B:38:0x00a2  */
    /* JADX WARN: Code duplicated, block: B:39:0x00a4 A[Catch: IllegalStateException -> 0x007b, PHI: r11
      0x00a4: PHI (r11v11 java.lang.Object) = (r11v10 java.lang.Object), (r11v1 java.lang.Object) binds: [B:37:0x00a0, B:27:0x0073] A[DONT_GENERATE, DONT_INLINE], TryCatch #0 {IllegalStateException -> 0x007b, blocks: (B:14:0x003d, B:17:0x0046, B:72:0x0153, B:20:0x005b, B:65:0x013a, B:23:0x0064, B:58:0x0101, B:60:0x0107, B:62:0x010b, B:67:0x013d, B:68:0x0142, B:69:0x0143, B:26:0x006f, B:44:0x00c4, B:46:0x00ca, B:53:0x00e9, B:55:0x00f0, B:47:0x00d3, B:49:0x00d7, B:50:0x00e2, B:51:0x00e3, B:52:0x00e8, B:27:0x0073, B:39:0x00a4, B:41:0x00ae, B:28:0x0077, B:36:0x0099, B:33:0x0082), top: B:83:0x0025 }] */
    /* JADX WARN: Code duplicated, block: B:41:0x00ae A[Catch: IllegalStateException -> 0x007b, TryCatch #0 {IllegalStateException -> 0x007b, blocks: (B:14:0x003d, B:17:0x0046, B:72:0x0153, B:20:0x005b, B:65:0x013a, B:23:0x0064, B:58:0x0101, B:60:0x0107, B:62:0x010b, B:67:0x013d, B:68:0x0142, B:69:0x0143, B:26:0x006f, B:44:0x00c4, B:46:0x00ca, B:53:0x00e9, B:55:0x00f0, B:47:0x00d3, B:49:0x00d7, B:50:0x00e2, B:51:0x00e3, B:52:0x00e8, B:27:0x0073, B:39:0x00a4, B:41:0x00ae, B:28:0x0077, B:36:0x0099, B:33:0x0082), top: B:83:0x0025 }] */
    /* JADX WARN: Code duplicated, block: B:43:0x00c2  */
    /* JADX WARN: Code duplicated, block: B:44:0x00c4 A[Catch: IllegalStateException -> 0x007b, PHI: r11
      0x00c4: PHI (r11v25 java.lang.Object) = (r11v19 java.lang.Object), (r11v1 java.lang.Object) binds: [B:42:0x00c0, B:26:0x006f] A[DONT_GENERATE, DONT_INLINE], TryCatch #0 {IllegalStateException -> 0x007b, blocks: (B:14:0x003d, B:17:0x0046, B:72:0x0153, B:20:0x005b, B:65:0x013a, B:23:0x0064, B:58:0x0101, B:60:0x0107, B:62:0x010b, B:67:0x013d, B:68:0x0142, B:69:0x0143, B:26:0x006f, B:44:0x00c4, B:46:0x00ca, B:53:0x00e9, B:55:0x00f0, B:47:0x00d3, B:49:0x00d7, B:50:0x00e2, B:51:0x00e3, B:52:0x00e8, B:27:0x0073, B:39:0x00a4, B:41:0x00ae, B:28:0x0077, B:36:0x0099, B:33:0x0082), top: B:83:0x0025 }] */
    /* JADX WARN: Code duplicated, block: B:46:0x00ca A[Catch: IllegalStateException -> 0x007b, TryCatch #0 {IllegalStateException -> 0x007b, blocks: (B:14:0x003d, B:17:0x0046, B:72:0x0153, B:20:0x005b, B:65:0x013a, B:23:0x0064, B:58:0x0101, B:60:0x0107, B:62:0x010b, B:67:0x013d, B:68:0x0142, B:69:0x0143, B:26:0x006f, B:44:0x00c4, B:46:0x00ca, B:53:0x00e9, B:55:0x00f0, B:47:0x00d3, B:49:0x00d7, B:50:0x00e2, B:51:0x00e3, B:52:0x00e8, B:27:0x0073, B:39:0x00a4, B:41:0x00ae, B:28:0x0077, B:36:0x0099, B:33:0x0082), top: B:83:0x0025 }] */
    /* JADX WARN: Code duplicated, block: B:47:0x00d3 A[Catch: IllegalStateException -> 0x007b, TryCatch #0 {IllegalStateException -> 0x007b, blocks: (B:14:0x003d, B:17:0x0046, B:72:0x0153, B:20:0x005b, B:65:0x013a, B:23:0x0064, B:58:0x0101, B:60:0x0107, B:62:0x010b, B:67:0x013d, B:68:0x0142, B:69:0x0143, B:26:0x006f, B:44:0x00c4, B:46:0x00ca, B:53:0x00e9, B:55:0x00f0, B:47:0x00d3, B:49:0x00d7, B:50:0x00e2, B:51:0x00e3, B:52:0x00e8, B:27:0x0073, B:39:0x00a4, B:41:0x00ae, B:28:0x0077, B:36:0x0099, B:33:0x0082), top: B:83:0x0025 }] */
    /* JADX WARN: Code duplicated, block: B:49:0x00d7 A[Catch: IllegalStateException -> 0x007b, TryCatch #0 {IllegalStateException -> 0x007b, blocks: (B:14:0x003d, B:17:0x0046, B:72:0x0153, B:20:0x005b, B:65:0x013a, B:23:0x0064, B:58:0x0101, B:60:0x0107, B:62:0x010b, B:67:0x013d, B:68:0x0142, B:69:0x0143, B:26:0x006f, B:44:0x00c4, B:46:0x00ca, B:53:0x00e9, B:55:0x00f0, B:47:0x00d3, B:49:0x00d7, B:50:0x00e2, B:51:0x00e3, B:52:0x00e8, B:27:0x0073, B:39:0x00a4, B:41:0x00ae, B:28:0x0077, B:36:0x0099, B:33:0x0082), top: B:83:0x0025 }] */
    /* JADX WARN: Code duplicated, block: B:51:0x00e3 A[Catch: IllegalStateException -> 0x007b, TryCatch #0 {IllegalStateException -> 0x007b, blocks: (B:14:0x003d, B:17:0x0046, B:72:0x0153, B:20:0x005b, B:65:0x013a, B:23:0x0064, B:58:0x0101, B:60:0x0107, B:62:0x010b, B:67:0x013d, B:68:0x0142, B:69:0x0143, B:26:0x006f, B:44:0x00c4, B:46:0x00ca, B:53:0x00e9, B:55:0x00f0, B:47:0x00d3, B:49:0x00d7, B:50:0x00e2, B:51:0x00e3, B:52:0x00e8, B:27:0x0073, B:39:0x00a4, B:41:0x00ae, B:28:0x0077, B:36:0x0099, B:33:0x0082), top: B:83:0x0025 }] */
    /* JADX WARN: Code duplicated, block: B:53:0x00e9 A[Catch: IllegalStateException -> 0x007b, PHI: r11
      0x00e9: PHI (r11v20 com.box.android.data.jobs.UploadFolderRunningInfo) = (r11v14 com.box.android.data.jobs.UploadFolderRunningInfo), (r11v32 com.box.android.data.jobs.UploadFolderRunningInfo) binds: [B:40:0x00ac, B:46:0x00ca] A[DONT_GENERATE, DONT_INLINE], TryCatch #0 {IllegalStateException -> 0x007b, blocks: (B:14:0x003d, B:17:0x0046, B:72:0x0153, B:20:0x005b, B:65:0x013a, B:23:0x0064, B:58:0x0101, B:60:0x0107, B:62:0x010b, B:67:0x013d, B:68:0x0142, B:69:0x0143, B:26:0x006f, B:44:0x00c4, B:46:0x00ca, B:53:0x00e9, B:55:0x00f0, B:47:0x00d3, B:49:0x00d7, B:50:0x00e2, B:51:0x00e3, B:52:0x00e8, B:27:0x0073, B:39:0x00a4, B:41:0x00ae, B:28:0x0077, B:36:0x0099, B:33:0x0082), top: B:83:0x0025 }] */
    /* JADX WARN: Code duplicated, block: B:55:0x00f0 A[Catch: IllegalStateException -> 0x007b, TryCatch #0 {IllegalStateException -> 0x007b, blocks: (B:14:0x003d, B:17:0x0046, B:72:0x0153, B:20:0x005b, B:65:0x013a, B:23:0x0064, B:58:0x0101, B:60:0x0107, B:62:0x010b, B:67:0x013d, B:68:0x0142, B:69:0x0143, B:26:0x006f, B:44:0x00c4, B:46:0x00ca, B:53:0x00e9, B:55:0x00f0, B:47:0x00d3, B:49:0x00d7, B:50:0x00e2, B:51:0x00e3, B:52:0x00e8, B:27:0x0073, B:39:0x00a4, B:41:0x00ae, B:28:0x0077, B:36:0x0099, B:33:0x0082), top: B:83:0x0025 }] */
    /* JADX WARN: Code duplicated, block: B:57:0x00ff  */
    /* JADX WARN: Code duplicated, block: B:58:0x0101 A[Catch: IllegalStateException -> 0x007b, PHI: r0 r11
      0x0101: PHI (r0v14 com.box.android.data.jobs.UploadFolderRunningInfo) = (r0v6 com.box.android.data.jobs.UploadFolderRunningInfo), (r0v17 com.box.android.data.jobs.UploadFolderRunningInfo) binds: [B:56:0x00fd, B:23:0x0064] A[DONT_GENERATE, DONT_INLINE]
      0x0101: PHI (r11v36 java.lang.Object) = (r11v24 java.lang.Object), (r11v1 java.lang.Object) binds: [B:56:0x00fd, B:23:0x0064] A[DONT_GENERATE, DONT_INLINE], TryCatch #0 {IllegalStateException -> 0x007b, blocks: (B:14:0x003d, B:17:0x0046, B:72:0x0153, B:20:0x005b, B:65:0x013a, B:23:0x0064, B:58:0x0101, B:60:0x0107, B:62:0x010b, B:67:0x013d, B:68:0x0142, B:69:0x0143, B:26:0x006f, B:44:0x00c4, B:46:0x00ca, B:53:0x00e9, B:55:0x00f0, B:47:0x00d3, B:49:0x00d7, B:50:0x00e2, B:51:0x00e3, B:52:0x00e8, B:27:0x0073, B:39:0x00a4, B:41:0x00ae, B:28:0x0077, B:36:0x0099, B:33:0x0082), top: B:83:0x0025 }] */
    /* JADX WARN: Code duplicated, block: B:60:0x0107 A[Catch: IllegalStateException -> 0x007b, TryCatch #0 {IllegalStateException -> 0x007b, blocks: (B:14:0x003d, B:17:0x0046, B:72:0x0153, B:20:0x005b, B:65:0x013a, B:23:0x0064, B:58:0x0101, B:60:0x0107, B:62:0x010b, B:67:0x013d, B:68:0x0142, B:69:0x0143, B:26:0x006f, B:44:0x00c4, B:46:0x00ca, B:53:0x00e9, B:55:0x00f0, B:47:0x00d3, B:49:0x00d7, B:50:0x00e2, B:51:0x00e3, B:52:0x00e8, B:27:0x0073, B:39:0x00a4, B:41:0x00ae, B:28:0x0077, B:36:0x0099, B:33:0x0082), top: B:83:0x0025 }] */
    /* JADX WARN: Code duplicated, block: B:62:0x010b A[Catch: IllegalStateException -> 0x007b, TryCatch #0 {IllegalStateException -> 0x007b, blocks: (B:14:0x003d, B:17:0x0046, B:72:0x0153, B:20:0x005b, B:65:0x013a, B:23:0x0064, B:58:0x0101, B:60:0x0107, B:62:0x010b, B:67:0x013d, B:68:0x0142, B:69:0x0143, B:26:0x006f, B:44:0x00c4, B:46:0x00ca, B:53:0x00e9, B:55:0x00f0, B:47:0x00d3, B:49:0x00d7, B:50:0x00e2, B:51:0x00e3, B:52:0x00e8, B:27:0x0073, B:39:0x00a4, B:41:0x00ae, B:28:0x0077, B:36:0x0099, B:33:0x0082), top: B:83:0x0025 }] */
    /* JADX WARN: Code duplicated, block: B:64:0x0139  */
    /* JADX WARN: Code duplicated, block: B:67:0x013d A[Catch: IllegalStateException -> 0x007b, TryCatch #0 {IllegalStateException -> 0x007b, blocks: (B:14:0x003d, B:17:0x0046, B:72:0x0153, B:20:0x005b, B:65:0x013a, B:23:0x0064, B:58:0x0101, B:60:0x0107, B:62:0x010b, B:67:0x013d, B:68:0x0142, B:69:0x0143, B:26:0x006f, B:44:0x00c4, B:46:0x00ca, B:53:0x00e9, B:55:0x00f0, B:47:0x00d3, B:49:0x00d7, B:50:0x00e2, B:51:0x00e3, B:52:0x00e8, B:27:0x0073, B:39:0x00a4, B:41:0x00ae, B:28:0x0077, B:36:0x0099, B:33:0x0082), top: B:83:0x0025 }] */
    /* JADX WARN: Code duplicated, block: B:69:0x0143 A[Catch: IllegalStateException -> 0x007b, PHI: r0
      0x0143: PHI (r0v13 com.box.android.data.jobs.UploadFolderRunningInfo) = (r0v6 com.box.android.data.jobs.UploadFolderRunningInfo), (r0v14 com.box.android.data.jobs.UploadFolderRunningInfo) binds: [B:54:0x00ee, B:59:0x0105] A[DONT_GENERATE, DONT_INLINE], TryCatch #0 {IllegalStateException -> 0x007b, blocks: (B:14:0x003d, B:17:0x0046, B:72:0x0153, B:20:0x005b, B:65:0x013a, B:23:0x0064, B:58:0x0101, B:60:0x0107, B:62:0x010b, B:67:0x013d, B:68:0x0142, B:69:0x0143, B:26:0x006f, B:44:0x00c4, B:46:0x00ca, B:53:0x00e9, B:55:0x00f0, B:47:0x00d3, B:49:0x00d7, B:50:0x00e2, B:51:0x00e3, B:52:0x00e8, B:27:0x0073, B:39:0x00a4, B:41:0x00ae, B:28:0x0077, B:36:0x0099, B:33:0x0082), top: B:83:0x0025 }] */
    /* JADX WARN: Code duplicated, block: B:71:0x0152  */
    /* JADX WARN: Code duplicated, block: B:72:0x0153 A[Catch: IllegalStateException -> 0x007b, PHI: r0
      0x0153: PHI (r0v26 com.box.android.data.jobs.UploadFolderRunningInfo) = (r0v13 com.box.android.data.jobs.UploadFolderRunningInfo), (r0v28 com.box.android.data.jobs.UploadFolderRunningInfo) binds: [B:70:0x0150, B:17:0x0046] A[DONT_GENERATE, DONT_INLINE], TRY_LEAVE, TryCatch #0 {IllegalStateException -> 0x007b, blocks: (B:14:0x003d, B:17:0x0046, B:72:0x0153, B:20:0x005b, B:65:0x013a, B:23:0x0064, B:58:0x0101, B:60:0x0107, B:62:0x010b, B:67:0x013d, B:68:0x0142, B:69:0x0143, B:26:0x006f, B:44:0x00c4, B:46:0x00ca, B:53:0x00e9, B:55:0x00f0, B:47:0x00d3, B:49:0x00d7, B:50:0x00e2, B:51:0x00e3, B:52:0x00e8, B:27:0x0073, B:39:0x00a4, B:41:0x00ae, B:28:0x0077, B:36:0x0099, B:33:0x0082), top: B:83:0x0025 }] */
    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    /* JADX WARN: Code restructure failed: missing block: B:73:0x0160, code lost:
    
        if (checkCompletion(r4) == r7) goto L80;
     */
    /* JADX WARN: Code restructure failed: missing block: B:79:0x018b, code lost:
    
        if (r0.jobFailed(r10, com.box.android.domain.jobs.JobType.UPLOAD_FOLDER_V2, r1, r4) == r7) goto L80;
     */
    @Override // com.box.android.data.jobs.Job
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.Object start(kotlin.coroutines.Continuation<? super kotlin.Unit> r11) throws java.io.UnsupportedEncodingException {
        /*
            Method dump skipped, instruction units count: 424
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.box.android.data.jobs.UploadFolderJob.start(kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX INFO: renamed from: com.box.android.data.jobs.UploadFolderJob$checkCompletion$2, reason: invalid class name */
    /* JADX INFO: compiled from: UploadFolderJob.kt */
    @Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n"}, d2 = {"<anonymous>", "", "runningInfo", "Lcom/box/android/data/jobs/UploadFolderRunningInfo;"}, k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.box.android.data.jobs.UploadFolderJob$checkCompletion$2", f = "UploadFolderJob.kt", i = {0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1}, l = {126, Token.LABEL}, m = "invokeSuspend", n = {"runningInfo", "totalFiles", "succeededCount", "failedCount", "completedCount", "runningInfo", "error", "totalFiles", "succeededCount", "failedCount", "completedCount"}, s = {"L$0", "I$0", "I$1", "I$2", "I$3", "L$0", "L$1", "I$0", "I$1", "I$2", "I$3"}, v = 1)
    static final class AnonymousClass2 extends SuspendLambda implements Function2<UploadFolderRunningInfo, Continuation<? super Unit>, Object> {
        int I$0;
        int I$1;
        int I$2;
        int I$3;
        /* synthetic */ Object L$0;
        Object L$1;
        int label;

        AnonymousClass2(Continuation<? super AnonymousClass2> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            AnonymousClass2 anonymousClass2 = UploadFolderJob.this.new AnonymousClass2(continuation);
            anonymousClass2.L$0 = obj;
            return anonymousClass2;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(UploadFolderRunningInfo uploadFolderRunningInfo, Continuation<? super Unit> continuation) {
            return ((AnonymousClass2) create(uploadFolderRunningInfo, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Code restructure failed: missing block: B:13:0x0062, code lost:
        
            if (r10.this$0.getJobService().jobSucceeded(r10.this$0.getJobId(), r10) == r1) goto L21;
         */
        /* JADX WARN: Code restructure failed: missing block: B:20:0x00a3, code lost:
        
            if (r10.this$0.getJobService().jobFailed(r10.this$0.getJobId(), com.box.android.domain.jobs.JobType.UPLOAD_FOLDER_V2, r4, r10) == r1) goto L21;
         */
        /* JADX WARN: Code restructure failed: missing block: B:21:0x00a5, code lost:
        
            return r1;
         */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final java.lang.Object invokeSuspend(java.lang.Object r11) {
            /*
                r10 = this;
                java.lang.Object r0 = r10.L$0
                com.box.android.data.jobs.UploadFolderRunningInfo r0 = (com.box.android.data.jobs.UploadFolderRunningInfo) r0
                java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
                int r2 = r10.label
                r3 = 2
                r4 = 1
                if (r2 == 0) goto L24
                if (r2 == r4) goto L1f
                if (r2 != r3) goto L17
                java.lang.Object r10 = r10.L$1
                com.box.android.domain.models.DomainError r10 = (com.box.android.domain.models.DomainError) r10
                goto L1f
            L17:
                java.lang.IllegalStateException r10 = new java.lang.IllegalStateException
                java.lang.String r11 = "call to 'resume' before 'invoke' with coroutine"
                r10.<init>(r11)
                throw r10
            L1f:
                kotlin.ResultKt.throwOnFailure(r11)
                goto La6
            L24:
                kotlin.ResultKt.throwOnFailure(r11)
                int r11 = r0.getTotalFiles()
                java.util.Set r2 = r0.getSucceededFiles()
                int r2 = r2.size()
                java.util.Map r5 = r0.getFailedFiles()
                int r5 = r5.size()
                int r6 = r2 + r5
                if (r2 != r11) goto L65
                com.box.android.data.jobs.UploadFolderJob r3 = com.box.android.data.jobs.UploadFolderJob.this
                com.box.android.data.jobs.JobService r3 = r3.getJobService()
                com.box.android.data.jobs.UploadFolderJob r7 = com.box.android.data.jobs.UploadFolderJob.this
                com.box.android.domain.jobs.JobId r7 = r7.getJobId()
                r8 = r10
                kotlin.coroutines.Continuation r8 = (kotlin.coroutines.Continuation) r8
                java.lang.Object r0 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r0)
                r10.L$0 = r0
                r10.I$0 = r11
                r10.I$1 = r2
                r10.I$2 = r5
                r10.I$3 = r6
                r10.label = r4
                java.lang.Object r10 = r3.jobSucceeded(r7, r8)
                if (r10 != r1) goto La6
                goto La5
            L65:
                if (r6 != r11) goto La6
                com.box.android.data.jobs.UploadFolderJob r4 = com.box.android.data.jobs.UploadFolderJob.this
                com.box.android.domain.models.DomainError r4 = r4.getLastRecordError()
                if (r4 != 0) goto L78
                com.box.android.domain.models.DomainError$UnknownError r4 = new com.box.android.domain.models.DomainError$UnknownError
                java.lang.String r7 = "Unknown error"
                r4.<init>(r7)
                com.box.android.domain.models.DomainError r4 = (com.box.android.domain.models.DomainError) r4
            L78:
                com.box.android.data.jobs.UploadFolderJob r7 = com.box.android.data.jobs.UploadFolderJob.this
                com.box.android.data.jobs.JobService r7 = r7.getJobService()
                com.box.android.data.jobs.UploadFolderJob r8 = com.box.android.data.jobs.UploadFolderJob.this
                com.box.android.domain.jobs.JobId r8 = r8.getJobId()
                r9 = r10
                kotlin.coroutines.Continuation r9 = (kotlin.coroutines.Continuation) r9
                java.lang.Object r0 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r0)
                r10.L$0 = r0
                java.lang.Object r0 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r4)
                r10.L$1 = r0
                r10.I$0 = r11
                r10.I$1 = r2
                r10.I$2 = r5
                r10.I$3 = r6
                r10.label = r3
                java.lang.String r10 = "UploadFolderJob"
                java.lang.Object r10 = r7.jobFailed(r8, r10, r4, r9)
                if (r10 != r1) goto La6
            La5:
                return r1
            La6:
                kotlin.Unit r10 = kotlin.Unit.INSTANCE
                return r10
            */
            throw new UnsupportedOperationException("Method not decompiled: com.box.android.data.jobs.UploadFolderJob.AnonymousClass2.invokeSuspend(java.lang.Object):java.lang.Object");
        }
    }

    public final Object checkCompletion(Continuation<? super Unit> continuation) {
        Object objUpdatingRunningInfo$default = updatingRunningInfo$default(this, false, new AnonymousClass2(null), continuation, 1, null);
        return objUpdatingRunningInfo$default == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objUpdatingRunningInfo$default : Unit.INSTANCE;
    }

    /* JADX WARN: Code duplicated, block: B:45:0x014b  */
    /* JADX WARN: Code duplicated, block: B:48:0x0152  */
    /* JADX WARN: Code duplicated, block: B:50:0x015a  */
    /* JADX WARN: Code duplicated, block: B:52:0x015e A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:53:0x015f  */
    /* JADX WARN: Code duplicated, block: B:7:0x0018  */
    public final Object initialRunningInfo(Continuation<? super Result<UploadFolderRunningInfo, ? extends DomainError>> continuation) throws UnsupportedEncodingException {
        C13531 c13531;
        ItemId itemIdCreate;
        ItemId itemId;
        FolderModel folderModel;
        ItemId itemId2;
        ItemId itemId3;
        UploadFolderRunningInfo uploadFolderRunningInfo;
        UploadFolderRunningInfo uploadFolderRunningInfo2;
        Result result;
        if (continuation instanceof C13531) {
            c13531 = (C13531) continuation;
            if ((c13531.label & Integer.MIN_VALUE) != 0) {
                c13531.label -= Integer.MIN_VALUE;
            } else {
                c13531 = new C13531(continuation);
            }
        } else {
            c13531 = new C13531(continuation);
        }
        Object objUpdateRunningInfo = c13531.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = c13531.label;
        if (i != 0) {
            if (i == 1) {
                itemId = (ItemId) c13531.L$0;
                ResultKt.throwOnFailure(objUpdateRunningInfo);
            } else {
                if (i == 2) {
                    itemId3 = (ItemId) c13531.L$2;
                    folderModel = (FolderModel) c13531.L$1;
                    itemId2 = (ItemId) c13531.L$0;
                    ResultKt.throwOnFailure(objUpdateRunningInfo);
                    uploadFolderRunningInfo = new UploadFolderRunningInfo(folderModel.getName(), itemId2.toString(), itemId3.toString(), null, 0, MapsKt.emptyMap(), SetsKt.emptySet(), MapsKt.emptyMap(), MapsKt.emptyMap());
                    JobService jobService = getJobService();
                    byte[] bArrRunningInfoToByteArray = runningInfoToByteArray(uploadFolderRunningInfo);
                    JobId jobId = this.jobId;
                    c13531.L$0 = SpillingKt.nullOutSpilledVariable(itemId2);
                    c13531.L$1 = SpillingKt.nullOutSpilledVariable(folderModel);
                    c13531.L$2 = SpillingKt.nullOutSpilledVariable(itemId3);
                    c13531.L$3 = uploadFolderRunningInfo;
                    c13531.label = 3;
                    objUpdateRunningInfo = jobService.updateRunningInfo(bArrRunningInfoToByteArray, jobId, c13531);
                    if (objUpdateRunningInfo != coroutine_suspended) {
                        uploadFolderRunningInfo2 = uploadFolderRunningInfo;
                    }
                    return coroutine_suspended;
                }
                if (i != 3) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                uploadFolderRunningInfo2 = (UploadFolderRunningInfo) c13531.L$3;
                ResultKt.throwOnFailure(objUpdateRunningInfo);
            }
            result = (Result) objUpdateRunningInfo;
            if (result instanceof Result.Success) {
                return new Result.Success(uploadFolderRunningInfo2);
            }
            if (result instanceof Result.Error) {
                return result;
            }
            throw new NoWhenBranchMatchedException();
        }
        ResultKt.throwOnFailure(objUpdateRunningInfo);
        String string = this.inputData.getString(LOCAL_FOLDER_ID_PARAM);
        if (string == null || (itemIdCreate = ItemId.INSTANCE.create(string)) == null) {
            throw new IllegalStateException("Unable to retrieve parent folderId".toString());
        }
        LocalItemService localItemService = this.localItemService;
        c13531.L$0 = itemIdCreate;
        c13531.label = 1;
        Object itemByLocalId = localItemService.getItemByLocalId(itemIdCreate, c13531);
        if (itemByLocalId != coroutine_suspended) {
            itemId = itemIdCreate;
            objUpdateRunningInfo = itemByLocalId;
        }
        return coroutine_suspended;
        Result result2 = (Result) objUpdateRunningInfo;
        if (!(result2 instanceof Result.Success)) {
            if (result2 instanceof Result.Error) {
                throw new IllegalStateException("Failed to get the folder model".toString());
            }
            throw new NoWhenBranchMatchedException();
        }
        Object value = ((Result.Success) result2).getValue();
        FolderModel folderModel2 = value instanceof FolderModel ? (FolderModel) value : null;
        if (folderModel2 == null) {
            throw new IllegalStateException("Failed to get the folder model".toString());
        }
        FolderModel parentFolder = folderModel2.getParentFolder();
        ItemId itemId4 = parentFolder != null ? parentFolder.getItemId() : null;
        if (itemId4 == null) {
            throw new IllegalStateException("Failed to get the parent folder id".toString());
        }
        JobService jobService2 = getJobService();
        JobId jobId2 = this.jobId;
        Map<String, ? extends Object> mapMapOf = MapsKt.mapOf(TuplesKt.to(MetricKeysParam.METRIC_FILE_ID, itemId.toString()), TuplesKt.to(MetricKeysParam.METRIC_FOLDER_ID, itemId4.toString()), TuplesKt.to(MetricKeysParam.METRIC_IS_USER_TRIGGERED_JOB, Boxing.boxBoolean(this.inputData.getBoolean(JobConstants.SHOULD_DISPLAY_JOB, true))));
        c13531.L$0 = itemId;
        c13531.L$1 = folderModel2;
        c13531.L$2 = itemId4;
        c13531.label = 2;
        if (jobService2.updateLogData(jobId2, mapMapOf, c13531) != coroutine_suspended) {
            folderModel = folderModel2;
            itemId2 = itemId;
            itemId3 = itemId4;
            uploadFolderRunningInfo = new UploadFolderRunningInfo(folderModel.getName(), itemId2.toString(), itemId3.toString(), null, 0, MapsKt.emptyMap(), SetsKt.emptySet(), MapsKt.emptyMap(), MapsKt.emptyMap());
            JobService jobService3 = getJobService();
            byte[] bArrRunningInfoToByteArray2 = runningInfoToByteArray(uploadFolderRunningInfo);
            JobId jobId3 = this.jobId;
            c13531.L$0 = SpillingKt.nullOutSpilledVariable(itemId2);
            c13531.L$1 = SpillingKt.nullOutSpilledVariable(folderModel);
            c13531.L$2 = SpillingKt.nullOutSpilledVariable(itemId3);
            c13531.L$3 = uploadFolderRunningInfo;
            c13531.label = 3;
            objUpdateRunningInfo = jobService3.updateRunningInfo(bArrRunningInfoToByteArray2, jobId3, c13531);
            if (objUpdateRunningInfo != coroutine_suspended) {
                uploadFolderRunningInfo2 = uploadFolderRunningInfo;
                result = (Result) objUpdateRunningInfo;
                if (result instanceof Result.Success) {
                    return new Result.Success(uploadFolderRunningInfo2);
                }
                if (result instanceof Result.Error) {
                    return result;
                }
                throw new NoWhenBranchMatchedException();
            }
        }
        return coroutine_suspended;
    }

    /* JADX WARN: Code duplicated, block: B:34:0x0137  */
    /* JADX WARN: Code duplicated, block: B:36:0x013b  */
    /* JADX WARN: Code duplicated, block: B:39:0x014b  */
    /* JADX WARN: Code duplicated, block: B:42:0x0184  */
    /* JADX WARN: Code duplicated, block: B:45:0x0192  */
    /* JADX WARN: Code duplicated, block: B:46:0x01c1  */
    /* JADX WARN: Code duplicated, block: B:48:0x01c5  */
    /* JADX WARN: Code duplicated, block: B:52:0x021b  */
    /* JADX WARN: Code duplicated, block: B:54:0x0225  */
    /* JADX WARN: Code duplicated, block: B:56:0x022b  */
    /* JADX WARN: Code duplicated, block: B:60:0x0233  */
    /* JADX WARN: Code duplicated, block: B:63:0x027a  */
    /* JADX WARN: Code duplicated, block: B:66:0x0281  */
    /* JADX WARN: Code duplicated, block: B:68:0x0291  */
    /* JADX WARN: Code duplicated, block: B:70:0x0295 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:71:0x0296  */
    /* JADX WARN: Code duplicated, block: B:73:0x029c  */
    /* JADX WARN: Code duplicated, block: B:75:0x02a0 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:76:0x02a1  */
    /* JADX WARN: Code duplicated, block: B:78:0x02a7  */
    /* JADX WARN: Code duplicated, block: B:7:0x0018  */
    /* JADX WARN: Code duplicated, block: B:80:0x02ad  */
    public final Object createFolder(UploadFolderRunningInfo uploadFolderRunningInfo, Continuation<? super Result<UploadFolderRunningInfo, ? extends DomainError>> continuation) {
        AnonymousClass1 anonymousClass1;
        ItemId itemId;
        UploadFolderRunningInfo uploadFolderRunningInfo2;
        ItemId.Remote remote;
        UploadFolderRunningInfo uploadFolderRunningInfo3;
        ItemId itemId2;
        ItemId itemId3;
        Result<ItemModel, DomainError> resultRecoverFromNameConflict;
        ItemModel itemModel;
        Object serverId;
        Result<ItemModel, DomainError> result;
        ItemId.Remote remote2;
        ItemId itemId4;
        int i;
        ItemModel itemModel2;
        ItemId itemId5;
        int i2;
        Result<ItemModel, DomainError> result2;
        Result.Success success;
        JobService jobService;
        JobId jobId;
        Map<String, ? extends Object> mapMapOf;
        ItemId itemId6;
        ItemId itemId7;
        UploadFolderRunningInfo uploadFolderRunningInfo4;
        Result<ItemModel, DomainError> result3;
        UploadFolderRunningInfo uploadFolderRunningInfo5;
        UploadFolderRunningInfo uploadFolderRunningInfo6;
        Result result4;
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
        Object objUpdateRunningInfo = anonymousClass1.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i3 = anonymousClass1.label;
        if (i3 == 0) {
            ResultKt.throwOnFailure(objUpdateRunningInfo);
            ItemId itemIdCreate = ItemId.INSTANCE.create(uploadFolderRunningInfo.getParentFolderLocalId());
            IdMappingService idMappingService = this.idMappingService;
            anonymousClass1.L$0 = uploadFolderRunningInfo;
            anonymousClass1.L$1 = SpillingKt.nullOutSpilledVariable(itemIdCreate);
            anonymousClass1.label = 1;
            Object remoteId = idMappingService.getRemoteId(itemIdCreate, anonymousClass1);
            if (remoteId != coroutine_suspended) {
                itemId = itemIdCreate;
                objUpdateRunningInfo = remoteId;
                uploadFolderRunningInfo2 = uploadFolderRunningInfo;
            }
            return coroutine_suspended;
        }
        if (i3 == 1) {
            itemId = (ItemId) anonymousClass1.L$1;
            uploadFolderRunningInfo2 = (UploadFolderRunningInfo) anonymousClass1.L$0;
            ResultKt.throwOnFailure(objUpdateRunningInfo);
        } else {
            if (i3 == 2) {
                itemId3 = (ItemId) anonymousClass1.L$3;
                remote = (ItemId.Remote) anonymousClass1.L$2;
                itemId2 = (ItemId) anonymousClass1.L$1;
                UploadFolderRunningInfo uploadFolderRunningInfo7 = (UploadFolderRunningInfo) anonymousClass1.L$0;
                ResultKt.throwOnFailure(objUpdateRunningInfo);
                uploadFolderRunningInfo3 = uploadFolderRunningInfo7;
                resultRecoverFromNameConflict = (Result) objUpdateRunningInfo;
                if (!(resultRecoverFromNameConflict instanceof Result.Success)) {
                    if (resultRecoverFromNameConflict instanceof Result.Error) {
                        throw new NoWhenBranchMatchedException();
                    }
                    resultRecoverFromNameConflict = recoverFromNameConflict((DomainError) ((Result.Error) resultRecoverFromNameConflict).getValue());
                }
                if (resultRecoverFromNameConflict instanceof Result.Success) {
                    itemModel = (ItemModel) ((Result.Success) resultRecoverFromNameConflict).getValue();
                    LocalItemService localItemService = this.localItemService;
                    ItemId itemId8 = itemModel.getItemId();
                    anonymousClass1.L$0 = uploadFolderRunningInfo3;
                    anonymousClass1.L$1 = SpillingKt.nullOutSpilledVariable(itemId2);
                    anonymousClass1.L$2 = SpillingKt.nullOutSpilledVariable(remote);
                    anonymousClass1.L$3 = SpillingKt.nullOutSpilledVariable(itemId3);
                    anonymousClass1.L$4 = SpillingKt.nullOutSpilledVariable(resultRecoverFromNameConflict);
                    anonymousClass1.L$5 = itemModel;
                    anonymousClass1.I$0 = 0;
                    anonymousClass1.I$1 = 0;
                    anonymousClass1.label = 3;
                    serverId = localItemService.setServerId(itemId3, itemId8, anonymousClass1);
                    if (serverId != coroutine_suspended) {
                        result = resultRecoverFromNameConflict;
                        objUpdateRunningInfo = serverId;
                        remote2 = remote;
                        itemId4 = itemId2;
                        i = 0;
                        itemModel2 = itemModel;
                        itemId5 = itemId3;
                        i2 = 0;
                        result2 = (Result) objUpdateRunningInfo;
                        if (result2 instanceof Result.Success) {
                            success = new Result.Success(UploadFolderRunningInfo.copy$default(uploadFolderRunningInfo3, null, null, null, itemModel2.getItemId().toString(), 0, null, null, null, null, 503, null));
                        } else {
                            if (!(result2 instanceof Result.Error)) {
                                throw new NoWhenBranchMatchedException();
                            }
                            success = result2;
                        }
                        jobService = getJobService();
                        jobId = this.jobId;
                        mapMapOf = MapsKt.mapOf(TuplesKt.to(MetricKeysParam.METRIC_FILE_ID, itemModel2.getItemId().toString()));
                        anonymousClass1.L$0 = SpillingKt.nullOutSpilledVariable(uploadFolderRunningInfo3);
                        anonymousClass1.L$1 = SpillingKt.nullOutSpilledVariable(itemId4);
                        anonymousClass1.L$2 = SpillingKt.nullOutSpilledVariable(remote2);
                        anonymousClass1.L$3 = SpillingKt.nullOutSpilledVariable(itemId5);
                        anonymousClass1.L$4 = SpillingKt.nullOutSpilledVariable(result);
                        anonymousClass1.L$5 = SpillingKt.nullOutSpilledVariable(itemModel2);
                        anonymousClass1.L$6 = success;
                        anonymousClass1.L$7 = SpillingKt.nullOutSpilledVariable(success);
                        anonymousClass1.I$0 = i;
                        anonymousClass1.I$1 = i2;
                        anonymousClass1.I$2 = 0;
                        anonymousClass1.label = 4;
                        if (jobService.updateLogData(jobId, mapMapOf, anonymousClass1) != coroutine_suspended) {
                            itemId6 = itemId5;
                            itemId7 = itemId4;
                            uploadFolderRunningInfo4 = uploadFolderRunningInfo3;
                            result3 = success;
                            resultRecoverFromNameConflict = result3;
                            itemId3 = itemId6;
                            uploadFolderRunningInfo3 = uploadFolderRunningInfo4;
                            itemId2 = itemId7;
                            remote = remote2;
                            if (resultRecoverFromNameConflict instanceof Result.Success) {
                                if (resultRecoverFromNameConflict instanceof Result.Error) {
                                    return resultRecoverFromNameConflict;
                                }
                                throw new NoWhenBranchMatchedException();
                            }
                            uploadFolderRunningInfo5 = (UploadFolderRunningInfo) ((Result.Success) resultRecoverFromNameConflict).getValue();
                            JobService jobService2 = getJobService();
                            byte[] bArrRunningInfoToByteArray = runningInfoToByteArray(uploadFolderRunningInfo5);
                            JobId jobId2 = this.jobId;
                            anonymousClass1.L$0 = SpillingKt.nullOutSpilledVariable(uploadFolderRunningInfo3);
                            anonymousClass1.L$1 = SpillingKt.nullOutSpilledVariable(itemId2);
                            anonymousClass1.L$2 = SpillingKt.nullOutSpilledVariable(remote);
                            anonymousClass1.L$3 = SpillingKt.nullOutSpilledVariable(itemId3);
                            anonymousClass1.L$4 = SpillingKt.nullOutSpilledVariable(resultRecoverFromNameConflict);
                            anonymousClass1.L$5 = uploadFolderRunningInfo5;
                            anonymousClass1.L$6 = null;
                            anonymousClass1.L$7 = null;
                            anonymousClass1.I$0 = 0;
                            anonymousClass1.I$1 = 0;
                            anonymousClass1.label = 5;
                            objUpdateRunningInfo = jobService2.updateRunningInfo(bArrRunningInfoToByteArray, jobId2, anonymousClass1);
                            if (objUpdateRunningInfo != coroutine_suspended) {
                                uploadFolderRunningInfo6 = uploadFolderRunningInfo5;
                            }
                        }
                    }
                } else {
                    if (!(resultRecoverFromNameConflict instanceof Result.Error)) {
                        throw new NoWhenBranchMatchedException();
                    }
                    if (resultRecoverFromNameConflict instanceof Result.Success) {
                        if (resultRecoverFromNameConflict instanceof Result.Error) {
                            return resultRecoverFromNameConflict;
                        }
                        throw new NoWhenBranchMatchedException();
                    }
                    uploadFolderRunningInfo5 = (UploadFolderRunningInfo) ((Result.Success) resultRecoverFromNameConflict).getValue();
                    JobService jobService3 = getJobService();
                    byte[] bArrRunningInfoToByteArray2 = runningInfoToByteArray(uploadFolderRunningInfo5);
                    JobId jobId3 = this.jobId;
                    anonymousClass1.L$0 = SpillingKt.nullOutSpilledVariable(uploadFolderRunningInfo3);
                    anonymousClass1.L$1 = SpillingKt.nullOutSpilledVariable(itemId2);
                    anonymousClass1.L$2 = SpillingKt.nullOutSpilledVariable(remote);
                    anonymousClass1.L$3 = SpillingKt.nullOutSpilledVariable(itemId3);
                    anonymousClass1.L$4 = SpillingKt.nullOutSpilledVariable(resultRecoverFromNameConflict);
                    anonymousClass1.L$5 = uploadFolderRunningInfo5;
                    anonymousClass1.L$6 = null;
                    anonymousClass1.L$7 = null;
                    anonymousClass1.I$0 = 0;
                    anonymousClass1.I$1 = 0;
                    anonymousClass1.label = 5;
                    objUpdateRunningInfo = jobService3.updateRunningInfo(bArrRunningInfoToByteArray2, jobId3, anonymousClass1);
                    if (objUpdateRunningInfo != coroutine_suspended) {
                        uploadFolderRunningInfo6 = uploadFolderRunningInfo5;
                    }
                }
                return coroutine_suspended;
            }
            if (i3 == 3) {
                i2 = anonymousClass1.I$1;
                int i4 = anonymousClass1.I$0;
                ItemModel itemModel3 = (ItemModel) anonymousClass1.L$5;
                Result<ItemModel, DomainError> result5 = (Result) anonymousClass1.L$4;
                itemId5 = (ItemId) anonymousClass1.L$3;
                ItemId.Remote remote3 = (ItemId.Remote) anonymousClass1.L$2;
                itemId4 = (ItemId) anonymousClass1.L$1;
                uploadFolderRunningInfo3 = (UploadFolderRunningInfo) anonymousClass1.L$0;
                ResultKt.throwOnFailure(objUpdateRunningInfo);
                i = i4;
                remote2 = remote3;
                result = result5;
                itemModel2 = itemModel3;
                result2 = (Result) objUpdateRunningInfo;
                if (result2 instanceof Result.Success) {
                    success = new Result.Success(UploadFolderRunningInfo.copy$default(uploadFolderRunningInfo3, null, null, null, itemModel2.getItemId().toString(), 0, null, null, null, null, 503, null));
                } else {
                    if (!(result2 instanceof Result.Error)) {
                        throw new NoWhenBranchMatchedException();
                    }
                    success = result2;
                }
                jobService = getJobService();
                jobId = this.jobId;
                mapMapOf = MapsKt.mapOf(TuplesKt.to(MetricKeysParam.METRIC_FILE_ID, itemModel2.getItemId().toString()));
                anonymousClass1.L$0 = SpillingKt.nullOutSpilledVariable(uploadFolderRunningInfo3);
                anonymousClass1.L$1 = SpillingKt.nullOutSpilledVariable(itemId4);
                anonymousClass1.L$2 = SpillingKt.nullOutSpilledVariable(remote2);
                anonymousClass1.L$3 = SpillingKt.nullOutSpilledVariable(itemId5);
                anonymousClass1.L$4 = SpillingKt.nullOutSpilledVariable(result);
                anonymousClass1.L$5 = SpillingKt.nullOutSpilledVariable(itemModel2);
                anonymousClass1.L$6 = success;
                anonymousClass1.L$7 = SpillingKt.nullOutSpilledVariable(success);
                anonymousClass1.I$0 = i;
                anonymousClass1.I$1 = i2;
                anonymousClass1.I$2 = 0;
                anonymousClass1.label = 4;
                if (jobService.updateLogData(jobId, mapMapOf, anonymousClass1) != coroutine_suspended) {
                    itemId6 = itemId5;
                    itemId7 = itemId4;
                    uploadFolderRunningInfo4 = uploadFolderRunningInfo3;
                    result3 = success;
                    resultRecoverFromNameConflict = result3;
                    itemId3 = itemId6;
                    uploadFolderRunningInfo3 = uploadFolderRunningInfo4;
                    itemId2 = itemId7;
                    remote = remote2;
                    if (resultRecoverFromNameConflict instanceof Result.Success) {
                        if (resultRecoverFromNameConflict instanceof Result.Error) {
                            return resultRecoverFromNameConflict;
                        }
                        throw new NoWhenBranchMatchedException();
                    }
                    uploadFolderRunningInfo5 = (UploadFolderRunningInfo) ((Result.Success) resultRecoverFromNameConflict).getValue();
                    JobService jobService4 = getJobService();
                    byte[] bArrRunningInfoToByteArray3 = runningInfoToByteArray(uploadFolderRunningInfo5);
                    JobId jobId4 = this.jobId;
                    anonymousClass1.L$0 = SpillingKt.nullOutSpilledVariable(uploadFolderRunningInfo3);
                    anonymousClass1.L$1 = SpillingKt.nullOutSpilledVariable(itemId2);
                    anonymousClass1.L$2 = SpillingKt.nullOutSpilledVariable(remote);
                    anonymousClass1.L$3 = SpillingKt.nullOutSpilledVariable(itemId3);
                    anonymousClass1.L$4 = SpillingKt.nullOutSpilledVariable(resultRecoverFromNameConflict);
                    anonymousClass1.L$5 = uploadFolderRunningInfo5;
                    anonymousClass1.L$6 = null;
                    anonymousClass1.L$7 = null;
                    anonymousClass1.I$0 = 0;
                    anonymousClass1.I$1 = 0;
                    anonymousClass1.label = 5;
                    objUpdateRunningInfo = jobService4.updateRunningInfo(bArrRunningInfoToByteArray3, jobId4, anonymousClass1);
                    if (objUpdateRunningInfo != coroutine_suspended) {
                        uploadFolderRunningInfo6 = uploadFolderRunningInfo5;
                    }
                }
                return coroutine_suspended;
            }
            if (i3 == 4) {
                int i5 = anonymousClass1.I$2;
                int i6 = anonymousClass1.I$1;
                int i7 = anonymousClass1.I$0;
                result3 = (Result) anonymousClass1.L$6;
                itemId6 = (ItemId) anonymousClass1.L$3;
                remote2 = (ItemId.Remote) anonymousClass1.L$2;
                itemId7 = (ItemId) anonymousClass1.L$1;
                uploadFolderRunningInfo4 = (UploadFolderRunningInfo) anonymousClass1.L$0;
                ResultKt.throwOnFailure(objUpdateRunningInfo);
                resultRecoverFromNameConflict = result3;
                itemId3 = itemId6;
                uploadFolderRunningInfo3 = uploadFolderRunningInfo4;
                itemId2 = itemId7;
                remote = remote2;
                if (resultRecoverFromNameConflict instanceof Result.Success) {
                    if (resultRecoverFromNameConflict instanceof Result.Error) {
                        return resultRecoverFromNameConflict;
                    }
                    throw new NoWhenBranchMatchedException();
                }
                uploadFolderRunningInfo5 = (UploadFolderRunningInfo) ((Result.Success) resultRecoverFromNameConflict).getValue();
                JobService jobService5 = getJobService();
                byte[] bArrRunningInfoToByteArray4 = runningInfoToByteArray(uploadFolderRunningInfo5);
                JobId jobId5 = this.jobId;
                anonymousClass1.L$0 = SpillingKt.nullOutSpilledVariable(uploadFolderRunningInfo3);
                anonymousClass1.L$1 = SpillingKt.nullOutSpilledVariable(itemId2);
                anonymousClass1.L$2 = SpillingKt.nullOutSpilledVariable(remote);
                anonymousClass1.L$3 = SpillingKt.nullOutSpilledVariable(itemId3);
                anonymousClass1.L$4 = SpillingKt.nullOutSpilledVariable(resultRecoverFromNameConflict);
                anonymousClass1.L$5 = uploadFolderRunningInfo5;
                anonymousClass1.L$6 = null;
                anonymousClass1.L$7 = null;
                anonymousClass1.I$0 = 0;
                anonymousClass1.I$1 = 0;
                anonymousClass1.label = 5;
                objUpdateRunningInfo = jobService5.updateRunningInfo(bArrRunningInfoToByteArray4, jobId5, anonymousClass1);
                if (objUpdateRunningInfo != coroutine_suspended) {
                    uploadFolderRunningInfo6 = uploadFolderRunningInfo5;
                }
                return coroutine_suspended;
            }
            if (i3 != 5) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            int i8 = anonymousClass1.I$1;
            int i9 = anonymousClass1.I$0;
            uploadFolderRunningInfo6 = (UploadFolderRunningInfo) anonymousClass1.L$5;
            ResultKt.throwOnFailure(objUpdateRunningInfo);
        }
        result4 = (Result) objUpdateRunningInfo;
        if (result4 instanceof Result.Success) {
            return new Result.Success(uploadFolderRunningInfo6);
        }
        if (result4 instanceof Result.Error) {
            return result4;
        }
        throw new NoWhenBranchMatchedException();
        if (objUpdateRunningInfo == null) {
            throw new IllegalStateException("Folder creation -> Server Id not found for parent folder".toString());
        }
        ItemId.Remote remote4 = (ItemId.Remote) objUpdateRunningInfo;
        ItemId itemIdCreate2 = ItemId.INSTANCE.create(uploadFolderRunningInfo2.getLocalFolderId());
        RemoteItemService remoteItemService = this.remoteItemService;
        String folderName = uploadFolderRunningInfo2.getFolderName();
        anonymousClass1.L$0 = uploadFolderRunningInfo2;
        anonymousClass1.L$1 = SpillingKt.nullOutSpilledVariable(itemId);
        anonymousClass1.L$2 = SpillingKt.nullOutSpilledVariable(remote4);
        anonymousClass1.L$3 = itemIdCreate2;
        anonymousClass1.label = 2;
        Object objCreateFolder = remoteItemService.createFolder(folderName, remote4, anonymousClass1);
        if (objCreateFolder != coroutine_suspended) {
            remote = remote4;
            objUpdateRunningInfo = objCreateFolder;
            uploadFolderRunningInfo3 = uploadFolderRunningInfo2;
            itemId2 = itemId;
            itemId3 = itemIdCreate2;
            resultRecoverFromNameConflict = (Result) objUpdateRunningInfo;
            if (!(resultRecoverFromNameConflict instanceof Result.Success)) {
                if (resultRecoverFromNameConflict instanceof Result.Error) {
                    throw new NoWhenBranchMatchedException();
                }
                resultRecoverFromNameConflict = recoverFromNameConflict((DomainError) ((Result.Error) resultRecoverFromNameConflict).getValue());
            }
            if (resultRecoverFromNameConflict instanceof Result.Success) {
                itemModel = (ItemModel) ((Result.Success) resultRecoverFromNameConflict).getValue();
                LocalItemService localItemService2 = this.localItemService;
                ItemId itemId9 = itemModel.getItemId();
                anonymousClass1.L$0 = uploadFolderRunningInfo3;
                anonymousClass1.L$1 = SpillingKt.nullOutSpilledVariable(itemId2);
                anonymousClass1.L$2 = SpillingKt.nullOutSpilledVariable(remote);
                anonymousClass1.L$3 = SpillingKt.nullOutSpilledVariable(itemId3);
                anonymousClass1.L$4 = SpillingKt.nullOutSpilledVariable(resultRecoverFromNameConflict);
                anonymousClass1.L$5 = itemModel;
                anonymousClass1.I$0 = 0;
                anonymousClass1.I$1 = 0;
                anonymousClass1.label = 3;
                serverId = localItemService2.setServerId(itemId3, itemId9, anonymousClass1);
                if (serverId != coroutine_suspended) {
                    result = resultRecoverFromNameConflict;
                    objUpdateRunningInfo = serverId;
                    remote2 = remote;
                    itemId4 = itemId2;
                    i = 0;
                    itemModel2 = itemModel;
                    itemId5 = itemId3;
                    i2 = 0;
                    result2 = (Result) objUpdateRunningInfo;
                    if (result2 instanceof Result.Success) {
                        success = new Result.Success(UploadFolderRunningInfo.copy$default(uploadFolderRunningInfo3, null, null, null, itemModel2.getItemId().toString(), 0, null, null, null, null, 503, null));
                    } else {
                        if (!(result2 instanceof Result.Error)) {
                            throw new NoWhenBranchMatchedException();
                        }
                        success = result2;
                    }
                    jobService = getJobService();
                    jobId = this.jobId;
                    mapMapOf = MapsKt.mapOf(TuplesKt.to(MetricKeysParam.METRIC_FILE_ID, itemModel2.getItemId().toString()));
                    anonymousClass1.L$0 = SpillingKt.nullOutSpilledVariable(uploadFolderRunningInfo3);
                    anonymousClass1.L$1 = SpillingKt.nullOutSpilledVariable(itemId4);
                    anonymousClass1.L$2 = SpillingKt.nullOutSpilledVariable(remote2);
                    anonymousClass1.L$3 = SpillingKt.nullOutSpilledVariable(itemId5);
                    anonymousClass1.L$4 = SpillingKt.nullOutSpilledVariable(result);
                    anonymousClass1.L$5 = SpillingKt.nullOutSpilledVariable(itemModel2);
                    anonymousClass1.L$6 = success;
                    anonymousClass1.L$7 = SpillingKt.nullOutSpilledVariable(success);
                    anonymousClass1.I$0 = i;
                    anonymousClass1.I$1 = i2;
                    anonymousClass1.I$2 = 0;
                    anonymousClass1.label = 4;
                    if (jobService.updateLogData(jobId, mapMapOf, anonymousClass1) != coroutine_suspended) {
                        itemId6 = itemId5;
                        itemId7 = itemId4;
                        uploadFolderRunningInfo4 = uploadFolderRunningInfo3;
                        result3 = success;
                        resultRecoverFromNameConflict = result3;
                        itemId3 = itemId6;
                        uploadFolderRunningInfo3 = uploadFolderRunningInfo4;
                        itemId2 = itemId7;
                        remote = remote2;
                        if (resultRecoverFromNameConflict instanceof Result.Success) {
                            if (resultRecoverFromNameConflict instanceof Result.Error) {
                                return resultRecoverFromNameConflict;
                            }
                            throw new NoWhenBranchMatchedException();
                        }
                        uploadFolderRunningInfo5 = (UploadFolderRunningInfo) ((Result.Success) resultRecoverFromNameConflict).getValue();
                        JobService jobService6 = getJobService();
                        byte[] bArrRunningInfoToByteArray5 = runningInfoToByteArray(uploadFolderRunningInfo5);
                        JobId jobId6 = this.jobId;
                        anonymousClass1.L$0 = SpillingKt.nullOutSpilledVariable(uploadFolderRunningInfo3);
                        anonymousClass1.L$1 = SpillingKt.nullOutSpilledVariable(itemId2);
                        anonymousClass1.L$2 = SpillingKt.nullOutSpilledVariable(remote);
                        anonymousClass1.L$3 = SpillingKt.nullOutSpilledVariable(itemId3);
                        anonymousClass1.L$4 = SpillingKt.nullOutSpilledVariable(resultRecoverFromNameConflict);
                        anonymousClass1.L$5 = uploadFolderRunningInfo5;
                        anonymousClass1.L$6 = null;
                        anonymousClass1.L$7 = null;
                        anonymousClass1.I$0 = 0;
                        anonymousClass1.I$1 = 0;
                        anonymousClass1.label = 5;
                        objUpdateRunningInfo = jobService6.updateRunningInfo(bArrRunningInfoToByteArray5, jobId6, anonymousClass1);
                        if (objUpdateRunningInfo != coroutine_suspended) {
                            uploadFolderRunningInfo6 = uploadFolderRunningInfo5;
                            result4 = (Result) objUpdateRunningInfo;
                            if (result4 instanceof Result.Success) {
                                return new Result.Success(uploadFolderRunningInfo6);
                            }
                            if (result4 instanceof Result.Error) {
                                return result4;
                            }
                            throw new NoWhenBranchMatchedException();
                        }
                    }
                }
            } else {
                if (!(resultRecoverFromNameConflict instanceof Result.Error)) {
                    throw new NoWhenBranchMatchedException();
                }
                if (resultRecoverFromNameConflict instanceof Result.Success) {
                    if (resultRecoverFromNameConflict instanceof Result.Error) {
                        return resultRecoverFromNameConflict;
                    }
                    throw new NoWhenBranchMatchedException();
                }
                uploadFolderRunningInfo5 = (UploadFolderRunningInfo) ((Result.Success) resultRecoverFromNameConflict).getValue();
                JobService jobService7 = getJobService();
                byte[] bArrRunningInfoToByteArray6 = runningInfoToByteArray(uploadFolderRunningInfo5);
                JobId jobId7 = this.jobId;
                anonymousClass1.L$0 = SpillingKt.nullOutSpilledVariable(uploadFolderRunningInfo3);
                anonymousClass1.L$1 = SpillingKt.nullOutSpilledVariable(itemId2);
                anonymousClass1.L$2 = SpillingKt.nullOutSpilledVariable(remote);
                anonymousClass1.L$3 = SpillingKt.nullOutSpilledVariable(itemId3);
                anonymousClass1.L$4 = SpillingKt.nullOutSpilledVariable(resultRecoverFromNameConflict);
                anonymousClass1.L$5 = uploadFolderRunningInfo5;
                anonymousClass1.L$6 = null;
                anonymousClass1.L$7 = null;
                anonymousClass1.I$0 = 0;
                anonymousClass1.I$1 = 0;
                anonymousClass1.label = 5;
                objUpdateRunningInfo = jobService7.updateRunningInfo(bArrRunningInfoToByteArray6, jobId7, anonymousClass1);
                if (objUpdateRunningInfo != coroutine_suspended) {
                    uploadFolderRunningInfo6 = uploadFolderRunningInfo5;
                    result4 = (Result) objUpdateRunningInfo;
                    if (result4 instanceof Result.Success) {
                        return new Result.Success(uploadFolderRunningInfo6);
                    }
                    if (result4 instanceof Result.Error) {
                        return result4;
                    }
                    throw new NoWhenBranchMatchedException();
                }
            }
        }
        return coroutine_suspended;
    }

    private final Result<ItemModel, DomainError> recoverFromNameConflict(DomainError domainError) {
        if (domainError instanceof DomainError.NameConflict) {
            ItemModel itemModel = (ItemModel) CollectionsKt.firstOrNull((List) ((DomainError.NameConflict) domainError).getItemModels());
            if (itemModel != null) {
                return new Result.Success(itemModel);
            }
            return new Result.Error(domainError);
        }
        return new Result.Error(domainError);
    }

    /* JADX INFO: renamed from: com.box.android.data.jobs.UploadFolderJob$enqueueUploads$2, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: UploadFolderJob.kt */
    @Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n"}, d2 = {"<anonymous>", "", "runningInfo", "Lcom/box/android/data/jobs/UploadFolderRunningInfo;"}, k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.box.android.data.jobs.UploadFolderJob$enqueueUploads$2", f = "UploadFolderJob.kt", i = {0, 0, 0, 1, 1, 1, 1, 1, 1, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5}, l = {223, 242, 271, 283, 303, 305}, m = "invokeSuspend", n = {"runningInfo", "localFolderId", "remoteFolderId", "runningInfo", "localFolderId", "remoteFolderId", "contentUrl", "folderOnDevice", "listOfFiles", "runningInfo", "localFolderId", "remoteFolderId", "contentUrl", "folderOnDevice", "listOfFiles", "jobIdFilenameMap", "jobIdFileSizeMap", "$this$forEach$iv", "element$iv", "documentFile", "invalidPath", "copiedFilePath", "documentName", "$i$f$forEach", "$i$a$-forEach-UploadFolderJob$enqueueUploads$2$1", "runningInfo", "localFolderId", "remoteFolderId", "contentUrl", "folderOnDevice", "listOfFiles", "jobIdFilenameMap", "jobIdFileSizeMap", "$this$forEach$iv", "element$iv", "documentFile", "documentName", "$i$f$forEach", "$i$a$-forEach-UploadFolderJob$enqueueUploads$2$1", "runningInfo", "localFolderId", "remoteFolderId", "contentUrl", "folderOnDevice", "listOfFiles", "jobIdFilenameMap", "jobIdFileSizeMap", "newRunningInfo", "runningInfoByteArray", "runningInfo", "localFolderId", "remoteFolderId", "contentUrl", "folderOnDevice", "listOfFiles", "jobIdFilenameMap", "jobIdFileSizeMap", "newRunningInfo", "runningInfoByteArray"}, s = {"L$0", "L$1", "L$2", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$8", "L$10", "L$11", "L$12", "L$13", "L$14", "I$0", "I$3", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$8", "L$10", "L$11", "L$12", "I$0", "I$3", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$8", "L$9", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$8", "L$9"}, v = 1)
    static final class C13502 extends SuspendLambda implements Function2<UploadFolderRunningInfo, Continuation<? super Unit>, Object> {
        int I$0;
        int I$1;
        int I$2;
        int I$3;
        /* synthetic */ Object L$0;
        Object L$1;
        Object L$10;
        Object L$11;
        Object L$12;
        Object L$13;
        Object L$14;
        Object L$2;
        Object L$3;
        Object L$4;
        Object L$5;
        Object L$6;
        Object L$7;
        Object L$8;
        Object L$9;
        int label;

        C13502(Continuation<? super C13502> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            C13502 c13502 = UploadFolderJob.this.new C13502(continuation);
            c13502.L$0 = obj;
            return c13502;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(UploadFolderRunningInfo uploadFolderRunningInfo, Continuation<? super Unit> continuation) {
            return ((C13502) create(uploadFolderRunningInfo, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Code duplicated, block: B:39:0x020c  */
        /* JADX WARN: Code duplicated, block: B:41:0x0214  */
        /* JADX WARN: Code duplicated, block: B:42:0x0222  */
        /* JADX WARN: Code duplicated, block: B:44:0x022c  */
        /* JADX WARN: Code duplicated, block: B:46:0x024b  */
        /* JADX WARN: Code duplicated, block: B:49:0x0252  */
        /* JADX WARN: Code duplicated, block: B:53:0x02d9  */
        /* JADX WARN: Code duplicated, block: B:56:0x02f3  */
        /* JADX WARN: Code duplicated, block: B:57:0x0319  */
        /* JADX WARN: Code duplicated, block: B:59:0x032f  */
        /* JADX WARN: Code duplicated, block: B:61:0x0344  */
        /* JADX WARN: Code duplicated, block: B:64:0x03a0  */
        /* JADX WARN: Code duplicated, block: B:67:0x03ba  */
        /* JADX WARN: Code duplicated, block: B:69:0x03d4  */
        /* JADX WARN: Code duplicated, block: B:71:0x03ee  */
        /* JADX WARN: Code duplicated, block: B:74:0x0472  */
        /* JADX WARN: Code duplicated, block: B:93:? A[RETURN, SYNTHETIC] */
        /* JADX WARN: Code duplicated, block: B:96:? A[RETURN, SYNTHETIC] */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:41:0x0214 -> B:70:0x03e5). Please report as a decompilation issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:64:0x03a0 -> B:65:0x03b0). Please report as a decompilation issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:69:0x03d4 -> B:70:0x03e5). Please report as a decompilation issue!!! */
        /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
            jadx.core.utils.exceptions.JadxOverflowException: Regions count limit reached at block B:64:0x03a0
            	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
            	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
            	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
            */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final java.lang.Object invokeSuspend(java.lang.Object r25) {
            /*
                Method dump skipped, instruction units count: 1310
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: com.box.android.data.jobs.UploadFolderJob.C13502.invokeSuspend(java.lang.Object):java.lang.Object");
        }
    }

    public final Object enqueueUploads(Continuation<? super Unit> continuation) {
        Object objUpdatingRunningInfo$default = updatingRunningInfo$default(this, false, new C13502(null), continuation, 1, null);
        return objUpdatingRunningInfo$default == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objUpdatingRunningInfo$default : Unit.INSTANCE;
    }

    public final Uri encodeTreeUri(Uri uri) {
        Intrinsics.checkNotNullParameter(uri, "uri");
        String path = uri.getPath();
        Intrinsics.checkNotNull(path);
        if (!Intrinsics.areEqual(uri.getScheme(), "content") || !Intrinsics.areEqual(uri.getAuthority(), "com.android.externalstorage.documents") || !StringsKt.startsWith$default(path, "/tree/", false, 2, (Object) null)) {
            throw new IllegalStateException("Unexpected folder URI format " + uri);
        }
        return Uri.parse("content://com.android.externalstorage.documents/tree/" + CollectionsKt.joinToString$default(StringsKt.split$default((CharSequence) StringsKt.removePrefix(path, (CharSequence) "/tree/"), new String[]{"/document/"}, false, 2, 2, (Object) null), "/document/", null, null, 0, null, new Function1() { // from class: com.box.android.data.jobs.UploadFolderJob$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return UploadFolderJob.encodeTreeUri$lambda$0((String) obj);
            }
        }, 30, null));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final CharSequence encodeTreeUri$lambda$0(String it) {
        Intrinsics.checkNotNullParameter(it, "it");
        String strEncode = Uri.encode(it);
        Intrinsics.checkNotNullExpressionValue(strEncode, "encode(...)");
        return strEncode;
    }

    /* JADX WARN: Code duplicated, block: B:38:0x015a A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:39:0x015b  */
    /* JADX WARN: Code duplicated, block: B:41:0x015f  */
    /* JADX WARN: Code duplicated, block: B:43:0x0174  */
    /* JADX WARN: Code duplicated, block: B:7:0x0018  */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x012b, code lost:
    
        if (r1 == r3) goto L24;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object uploadNestedFile(java.lang.String r17, com.box.android.domain.models.ItemId r18, android.net.Uri r19, java.util.Set<java.lang.String> r20, com.box.android.domain.models.ItemId r21, kotlin.coroutines.Continuation<? super com.box.android.domain.utils.result.Result<com.box.android.domain.jobs.JobRequest, ? extends com.box.android.domain.models.DomainError>> r22) throws java.io.UnsupportedEncodingException {
        /*
            Method dump skipped, instruction units count: 384
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.box.android.data.jobs.UploadFolderJob.uploadNestedFile(java.lang.String, com.box.android.domain.models.ItemId, android.net.Uri, java.util.Set, com.box.android.domain.models.ItemId, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ Object uploadNestedFile$default(UploadFolderJob uploadFolderJob, String str, ItemId itemId, Uri uri, Set set, ItemId itemId2, Continuation continuation, int i, Object obj) {
        if ((i & 8) != 0) {
            set = SetsKt.emptySet();
        }
        Set set2 = set;
        if ((i & 16) != 0) {
            itemId2 = null;
        }
        return uploadFolderJob.uploadNestedFile(str, itemId, uri, set2, itemId2, continuation);
    }

    /* JADX WARN: Code duplicated, block: B:27:0x00f1  */
    /* JADX WARN: Code duplicated, block: B:28:0x0102  */
    /* JADX WARN: Code duplicated, block: B:31:0x0107  */
    /* JADX WARN: Code duplicated, block: B:37:0x0117 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:38:0x0118  */
    /* JADX WARN: Code duplicated, block: B:40:0x011c  */
    /* JADX WARN: Code duplicated, block: B:42:0x0131  */
    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    public final Object uploadNestedFolder(String str, ItemId itemId, Uri uri, Set<String> set, Continuation<? super Result<JobRequest, ? extends DomainError>> continuation) throws UnsupportedEncodingException {
        C13591 c13591;
        Result success;
        JobRequest jobRequest;
        DomainErrorMapper domainErrorMapper;
        if (continuation instanceof C13591) {
            c13591 = (C13591) continuation;
            if ((c13591.label & Integer.MIN_VALUE) != 0) {
                c13591.label -= Integer.MIN_VALUE;
            } else {
                c13591 = new C13591(continuation);
            }
        } else {
            c13591 = new C13591(continuation);
        }
        C13591 c13592 = c13591;
        Object objCreateLocalFolder = c13592.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = c13592.label;
        if (i != 0) {
            if (i == 1) {
                set = (Set) c13592.L$3;
                uri = (Uri) c13592.L$2;
                itemId = (ItemId) c13592.L$1;
                str = (String) c13592.L$0;
                ResultKt.throwOnFailure(objCreateLocalFolder);
            } else {
                if (i != 2) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                int i2 = c13592.I$1;
                int i3 = c13592.I$0;
                jobRequest = (JobRequest) c13592.L$6;
                ResultKt.throwOnFailure(objCreateLocalFolder);
            }
            success = (Result) objCreateLocalFolder;
            if (success instanceof Result.Success) {
                success = new Result.Success(jobRequest);
            } else if (!(success instanceof Result.Error)) {
                throw new NoWhenBranchMatchedException();
            }
            domainErrorMapper = DomainErrorMapper.INSTANCE;
            if (success instanceof Result.Success) {
                return success;
            }
            if (success instanceof Result.Error) {
                throw new NoWhenBranchMatchedException();
            }
            return new Result.Error(DomainErrorMapper.toDomainError$default(domainErrorMapper, (IGenericError) ((Result.Error) success).getValue(), null, 2, null));
        }
        ResultKt.throwOnFailure(objCreateLocalFolder);
        LocalItemService localItemService = this.localItemService;
        c13592.L$0 = SpillingKt.nullOutSpilledVariable(str);
        c13592.L$1 = SpillingKt.nullOutSpilledVariable(itemId);
        c13592.L$2 = SpillingKt.nullOutSpilledVariable(uri);
        c13592.L$3 = set;
        c13592.label = 1;
        objCreateLocalFolder = localItemService.createLocalFolder(str, itemId, uri, c13592);
        if (objCreateLocalFolder != coroutine_suspended) {
        }
        return coroutine_suspended;
        success = (Result) objCreateLocalFolder;
        if (success instanceof Result.Success) {
            FolderModel folderModel = (FolderModel) ((Result.Success) success).getValue();
            JobRequest request = INSTANCE.getRequest(folderModel.getItemId(), set, false, false);
            JobService jobService = getJobService();
            JobId jobId = this.jobId;
            c13592.L$0 = SpillingKt.nullOutSpilledVariable(str);
            c13592.L$1 = SpillingKt.nullOutSpilledVariable(itemId);
            c13592.L$2 = SpillingKt.nullOutSpilledVariable(uri);
            c13592.L$3 = SpillingKt.nullOutSpilledVariable(set);
            c13592.L$4 = SpillingKt.nullOutSpilledVariable(success);
            c13592.L$5 = SpillingKt.nullOutSpilledVariable(folderModel);
            c13592.L$6 = request;
            c13592.I$0 = 0;
            c13592.I$1 = 0;
            c13592.label = 2;
            objCreateLocalFolder = IJobEventObserver.enqueueChildJob$default(jobService, request, jobId, null, c13592, 4, null);
            if (objCreateLocalFolder != coroutine_suspended) {
                jobRequest = request;
                success = (Result) objCreateLocalFolder;
                if (success instanceof Result.Success) {
                    success = new Result.Success(jobRequest);
                } else if (!(success instanceof Result.Error)) {
                    throw new NoWhenBranchMatchedException();
                }
            }
            return coroutine_suspended;
        }
        if (!(success instanceof Result.Error)) {
            throw new NoWhenBranchMatchedException();
        }
        domainErrorMapper = DomainErrorMapper.INSTANCE;
        if (success instanceof Result.Success) {
            return success;
        }
        if (success instanceof Result.Error) {
            throw new NoWhenBranchMatchedException();
        }
        return new Result.Error(DomainErrorMapper.toDomainError$default(domainErrorMapper, (IGenericError) ((Result.Error) success).getValue(), null, 2, null));
    }

    /* JADX INFO: renamed from: com.box.android.data.jobs.UploadFolderJob$childSucceeded$2, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: UploadFolderJob.kt */
    @Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n"}, d2 = {"<anonymous>", "", "runningInfo", "Lcom/box/android/data/jobs/UploadFolderRunningInfo;"}, k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.box.android.data.jobs.UploadFolderJob$childSucceeded$2", f = "UploadFolderJob.kt", i = {0, 0, 0, 0, 1, 1, 1, 1, 2, 2, 3, 3}, l = {378, 379, 381, 382}, m = "invokeSuspend", n = {"runningInfo", "newRunningInfo", "it", "$i$a$-let-UploadFolderJob$childSucceeded$2$1", "runningInfo", "newRunningInfo", "it", "$i$a$-let-UploadFolderJob$childSucceeded$2$1", "runningInfo", "newRunningInfo", "runningInfo", "newRunningInfo"}, s = {"L$0", "L$1", "D$0", "I$0", "L$0", "L$1", "D$0", "I$0", "L$0", "L$1", "L$0", "L$1"}, v = 1)
    static final class C13492 extends SuspendLambda implements Function2<UploadFolderRunningInfo, Continuation<? super Unit>, Object> {
        final /* synthetic */ JobId $childJobId;
        double D$0;
        int I$0;
        /* synthetic */ Object L$0;
        Object L$1;
        Object L$2;
        int label;
        final /* synthetic */ UploadFolderJob this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C13492(JobId jobId, UploadFolderJob uploadFolderJob, Continuation<? super C13492> continuation) {
            super(2, continuation);
            this.$childJobId = jobId;
            this.this$0 = uploadFolderJob;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            C13492 c13492 = new C13492(this.$childJobId, this.this$0, continuation);
            c13492.L$0 = obj;
            return c13492;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(UploadFolderRunningInfo uploadFolderRunningInfo, Continuation<? super Unit> continuation) {
            return ((C13492) create(uploadFolderRunningInfo, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Code duplicated, block: B:28:0x0166 A[PHI: r1 r12 r13
          0x0166: PHI (r1v16 com.box.android.data.jobs.UploadFolderRunningInfo) = (r1v14 com.box.android.data.jobs.UploadFolderRunningInfo), (r1v23 com.box.android.data.jobs.UploadFolderRunningInfo) binds: [B:26:0x0163, B:11:0x002c] A[DONT_GENERATE, DONT_INLINE]
          0x0166: PHI (r12v7 java.lang.Object) = (r12v4 java.lang.Object), (r12v10 java.lang.Object) binds: [B:26:0x0163, B:11:0x002c] A[DONT_GENERATE, DONT_INLINE]
          0x0166: PHI (r13v8 int) = (r13v6 int), (r13v11 int) binds: [B:26:0x0163, B:11:0x002c] A[DONT_GENERATE, DONT_INLINE]] */
        /* JADX WARN: Code restructure failed: missing block: B:21:0x0132, code lost:
        
            if (r0 == r12) goto L30;
         */
        /* JADX WARN: Code restructure failed: missing block: B:29:0x017d, code lost:
        
            if (r21.this$0.checkCompletion(r21) == r12) goto L30;
         */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final java.lang.Object invokeSuspend(java.lang.Object r22) {
            /*
                Method dump skipped, instruction units count: 387
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: com.box.android.data.jobs.UploadFolderJob.C13492.invokeSuspend(java.lang.Object):java.lang.Object");
        }
    }

    @Override // com.box.android.data.jobs.ParentJob
    public Object childSucceeded(JobId jobId, Continuation<? super Unit> continuation) {
        Object objUpdatingRunningInfo$default = updatingRunningInfo$default(this, false, new C13492(jobId, this, null), continuation, 1, null);
        return objUpdatingRunningInfo$default == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objUpdatingRunningInfo$default : Unit.INSTANCE;
    }

    /* JADX INFO: renamed from: com.box.android.data.jobs.UploadFolderJob$childFailed$2, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: UploadFolderJob.kt */
    @Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n"}, d2 = {"<anonymous>", "", "runningInfo", "Lcom/box/android/data/jobs/UploadFolderRunningInfo;"}, k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.box.android.data.jobs.UploadFolderJob$childFailed$2", f = "UploadFolderJob.kt", i = {0, 0, 0, 0, 0, 1, 1}, l = {396, 398}, m = "invokeSuspend", n = {"runningInfo", BoxCommonConstants.EXTRA_FILE_NAME, "it", "newRunningInfo", "$i$a$-let-UploadFolderJob$childFailed$2$1", "runningInfo", BoxCommonConstants.EXTRA_FILE_NAME}, s = {"L$0", "L$1", "L$2", "L$3", "I$0", "L$0", "L$1"}, v = 1)
    static final class C13482 extends SuspendLambda implements Function2<UploadFolderRunningInfo, Continuation<? super Unit>, Object> {
        final /* synthetic */ JobId $childJobId;
        int I$0;
        /* synthetic */ Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        int label;
        final /* synthetic */ UploadFolderJob this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C13482(JobId jobId, UploadFolderJob uploadFolderJob, Continuation<? super C13482> continuation) {
            super(2, continuation);
            this.$childJobId = jobId;
            this.this$0 = uploadFolderJob;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            C13482 c13482 = new C13482(this.$childJobId, this.this$0, continuation);
            c13482.L$0 = obj;
            return c13482;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(UploadFolderRunningInfo uploadFolderRunningInfo, Continuation<? super Unit> continuation) {
            return ((C13482) create(uploadFolderRunningInfo, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Code restructure failed: missing block: B:13:0x00c0, code lost:
        
            if (r3 == r1) goto L19;
         */
        /* JADX WARN: Code restructure failed: missing block: B:18:0x00e6, code lost:
        
            if (r18.this$0.checkCompletion(r18) == r1) goto L19;
         */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final java.lang.Object invokeSuspend(java.lang.Object r19) {
            /*
                Method dump skipped, instruction units count: 236
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: com.box.android.data.jobs.UploadFolderJob.C13482.invokeSuspend(java.lang.Object):java.lang.Object");
        }
    }

    @Override // com.box.android.data.jobs.ParentJob
    public Object childFailed(JobId jobId, DomainError domainError, Continuation<? super Unit> continuation) {
        this.lastRecordError = domainError;
        Object objUpdatingRunningInfo$default = updatingRunningInfo$default(this, false, new C13482(jobId, this, null), continuation, 1, null);
        return objUpdatingRunningInfo$default == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objUpdatingRunningInfo$default : Unit.INSTANCE;
    }

    @Override // com.box.android.data.jobs.ParentJob
    public Object childProgressed(JobId jobId, double d, double d2, Continuation<? super Unit> continuation) {
        Object objInitProgress = initProgress(continuation);
        return objInitProgress == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objInitProgress : Unit.INSTANCE;
    }

    /* JADX INFO: renamed from: com.box.android.data.jobs.UploadFolderJob$receiveFromChild$2, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: UploadFolderJob.kt */
    @Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n"}, d2 = {"<anonymous>", "", "runningInfo", "Lcom/box/android/data/jobs/UploadFolderRunningInfo;"}, k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.box.android.data.jobs.UploadFolderJob$receiveFromChild$2", f = "UploadFolderJob.kt", i = {0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 2, 2, 2, 2, 2, 2, 2, 3, 3, 3, 3, 3, 3, 3}, l = {418, 419, 425, HttpStatus.SC_UPGRADE_REQUIRED}, m = "invokeSuspend", n = {"runningInfo", "nestedFolderRunningInfo", "newRunningData", "$this$invokeSuspend_u24lambda_u240", "runningInfoByteArray", "totalSizeOfNestedFolder", "$i$a$-with-UploadFolderJob$receiveFromChild$2$1", "runningInfo", "nestedFolderRunningInfo", "newRunningData", "$this$invokeSuspend_u24lambda_u240", "runningInfoByteArray", "totalSizeOfNestedFolder", "$i$a$-with-UploadFolderJob$receiveFromChild$2$1", "runningInfo", "nestedFolderRunningInfo", "newRunningData", "$this$invokeSuspend_u24lambda_u240", "runningInfoByteArray", "totalSizeOfNestedFolder", "$i$a$-with-UploadFolderJob$receiveFromChild$2$1", "runningInfo", "nestedFolderRunningInfo", "newRunningData", "$this$invokeSuspend_u24lambda_u240", "runningInfoByteArray", "totalSizeOfNestedFolder", "$i$a$-with-UploadFolderJob$receiveFromChild$2$1"}, s = {"L$0", "L$1", "L$2", "L$4", "L$5", "D$0", "I$0", "L$0", "L$1", "L$2", "L$4", "L$5", "D$0", "I$0", "L$0", "L$1", "L$2", "L$4", "L$5", "D$0", "I$0", "L$0", "L$1", "L$2", "L$3", "L$4", "D$0", "I$0"}, v = 1)
    static final class C13542 extends SuspendLambda implements Function2<UploadFolderRunningInfo, Continuation<? super Unit>, Object> {
        final /* synthetic */ JobId $childJobId;
        final /* synthetic */ byte[] $info;
        double D$0;
        int I$0;
        /* synthetic */ Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        Object L$4;
        Object L$5;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C13542(byte[] bArr, JobId jobId, Continuation<? super C13542> continuation) {
            super(2, continuation);
            this.$info = bArr;
            this.$childJobId = jobId;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            C13542 c13542 = UploadFolderJob.this.new C13542(this.$info, this.$childJobId, continuation);
            c13542.L$0 = obj;
            return c13542;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(UploadFolderRunningInfo uploadFolderRunningInfo, Continuation<? super Unit> continuation) {
            return ((C13542) create(uploadFolderRunningInfo, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Code duplicated, block: B:25:0x01b8  */
        /* JADX WARN: Code duplicated, block: B:31:? A[RETURN, SYNTHETIC] */
        /* JADX WARN: Code duplicated, block: B:32:? A[RETURN, SYNTHETIC] */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            UploadFolderRunningInfo uploadFolderRunningInfoCopy$default;
            UploadFolderJob uploadFolderJob;
            UploadFolderRunningInfo uploadFolderRunningInfo;
            int i;
            JobService jobService;
            byte[] bArr;
            double d;
            JobService jobService2;
            double d2;
            int i2;
            UploadFolderRunningInfo uploadFolderRunningInfo2;
            UploadFolderRunningInfo uploadFolderRunningInfo3;
            UploadFolderJob uploadFolderJob2;
            byte[] bArr2;
            JobId jobId;
            double d3;
            double d4;
            Object obj2;
            int i3;
            int i4;
            double d5;
            byte[] bArr3;
            UploadFolderJob uploadFolderJob3;
            UploadFolderRunningInfo uploadFolderRunningInfo4;
            UploadFolderRunningInfo uploadFolderRunningInfo5;
            JobService jobService3;
            JobId jobId2;
            UploadFolderRunningInfo uploadFolderRunningInfo6 = (UploadFolderRunningInfo) this.L$0;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i5 = this.label;
            if (i5 == 0) {
                ResultKt.throwOnFailure(obj);
                UploadFolderRunningInfo uploadFolderRunningInfoByteArrayToRunningInfo = UploadFolderJob.this.byteArrayToRunningInfo(this.$info);
                double dSumOfDouble = CollectionsKt.sumOfDouble(uploadFolderRunningInfoByteArrayToRunningInfo.getSizes().values());
                uploadFolderRunningInfoCopy$default = UploadFolderRunningInfo.copy$default(uploadFolderRunningInfo6, null, null, null, null, 0, null, null, null, MapsKt.plus(uploadFolderRunningInfo6.getSizes(), TuplesKt.to(this.$childJobId.getIdentifier(), Boxing.boxDouble(dSumOfDouble))), 255, null);
                UploadFolderJob.this.getEstimatedWork().addAndGet(dSumOfDouble);
                JobService jobService4 = UploadFolderJob.this.getJobService();
                uploadFolderJob = UploadFolderJob.this;
                byte[] bArrRunningInfoToByteArray = uploadFolderJob.runningInfoToByteArray(uploadFolderRunningInfoCopy$default);
                JobId jobId3 = uploadFolderJob.getJobId();
                this.L$0 = SpillingKt.nullOutSpilledVariable(uploadFolderRunningInfo6);
                this.L$1 = SpillingKt.nullOutSpilledVariable(uploadFolderRunningInfoByteArrayToRunningInfo);
                this.L$2 = SpillingKt.nullOutSpilledVariable(uploadFolderRunningInfoCopy$default);
                this.L$3 = uploadFolderJob;
                this.L$4 = jobService4;
                this.L$5 = bArrRunningInfoToByteArray;
                this.D$0 = dSumOfDouble;
                this.I$0 = 0;
                this.label = 1;
                if (jobService4.updateRunningInfo(bArrRunningInfoToByteArray, jobId3, this) != coroutine_suspended) {
                    uploadFolderRunningInfo = uploadFolderRunningInfoByteArrayToRunningInfo;
                    i = 0;
                    jobService = jobService4;
                    bArr = bArrRunningInfoToByteArray;
                    d = dSumOfDouble;
                }
                return coroutine_suspended;
            }
            if (i5 == 1) {
                i = this.I$0;
                d = this.D$0;
                bArr = (byte[]) this.L$5;
                jobService = (JobService) this.L$4;
                uploadFolderJob = (UploadFolderJob) this.L$3;
                uploadFolderRunningInfoCopy$default = (UploadFolderRunningInfo) this.L$2;
                uploadFolderRunningInfo = (UploadFolderRunningInfo) this.L$1;
                ResultKt.throwOnFailure(obj);
            } else if (i5 == 2) {
                int i6 = this.I$0;
                double d6 = this.D$0;
                byte[] bArr4 = (byte[]) this.L$5;
                JobService jobService5 = (JobService) this.L$4;
                UploadFolderJob uploadFolderJob4 = (UploadFolderJob) this.L$3;
                UploadFolderRunningInfo uploadFolderRunningInfo7 = (UploadFolderRunningInfo) this.L$2;
                UploadFolderRunningInfo uploadFolderRunningInfo8 = (UploadFolderRunningInfo) this.L$1;
                ResultKt.throwOnFailure(obj);
                uploadFolderRunningInfo3 = uploadFolderRunningInfo7;
                uploadFolderRunningInfo2 = uploadFolderRunningInfo8;
                bArr2 = bArr4;
                uploadFolderJob2 = uploadFolderJob4;
                i2 = i6;
                jobService2 = jobService5;
                d2 = d6;
                jobId = uploadFolderJob2.getJobId();
                d3 = uploadFolderJob2.getProgress().get();
                d4 = uploadFolderJob2.getEstimatedWork().get();
                this.L$0 = SpillingKt.nullOutSpilledVariable(uploadFolderRunningInfo6);
                this.L$1 = SpillingKt.nullOutSpilledVariable(uploadFolderRunningInfo2);
                this.L$2 = SpillingKt.nullOutSpilledVariable(uploadFolderRunningInfo3);
                this.L$3 = uploadFolderJob2;
                this.L$4 = jobService2;
                this.L$5 = bArr2;
                this.D$0 = d2;
                this.I$0 = i2;
                this.label = 3;
                obj2 = coroutine_suspended;
                i3 = 4;
                if (jobService2.taskProgress(jobId, d3, d4, this) == obj2) {
                    return obj2;
                }
                i4 = i2;
                d5 = d2;
                bArr3 = bArr2;
                uploadFolderJob3 = uploadFolderJob2;
                uploadFolderRunningInfo4 = uploadFolderRunningInfo3;
                uploadFolderRunningInfo5 = uploadFolderRunningInfo2;
                jobService3 = jobService2;
                jobId2 = uploadFolderJob3.getJobId();
                this.L$0 = SpillingKt.nullOutSpilledVariable(uploadFolderRunningInfo6);
                this.L$1 = SpillingKt.nullOutSpilledVariable(uploadFolderRunningInfo5);
                this.L$2 = SpillingKt.nullOutSpilledVariable(uploadFolderRunningInfo4);
                this.L$3 = SpillingKt.nullOutSpilledVariable(jobService3);
                this.L$4 = SpillingKt.nullOutSpilledVariable(bArr3);
                this.L$5 = null;
                this.D$0 = d5;
                this.I$0 = i4;
                this.label = i3;
                if (jobService3.notifyParent(jobId2, bArr3, this) == obj2) {
                    return obj2;
                }
            } else if (i5 == 3) {
                i4 = this.I$0;
                d5 = this.D$0;
                bArr3 = (byte[]) this.L$5;
                jobService3 = (JobService) this.L$4;
                uploadFolderJob3 = (UploadFolderJob) this.L$3;
                uploadFolderRunningInfo4 = (UploadFolderRunningInfo) this.L$2;
                uploadFolderRunningInfo5 = (UploadFolderRunningInfo) this.L$1;
                ResultKt.throwOnFailure(obj);
                obj2 = coroutine_suspended;
                i3 = 4;
                jobId2 = uploadFolderJob3.getJobId();
                this.L$0 = SpillingKt.nullOutSpilledVariable(uploadFolderRunningInfo6);
                this.L$1 = SpillingKt.nullOutSpilledVariable(uploadFolderRunningInfo5);
                this.L$2 = SpillingKt.nullOutSpilledVariable(uploadFolderRunningInfo4);
                this.L$3 = SpillingKt.nullOutSpilledVariable(jobService3);
                this.L$4 = SpillingKt.nullOutSpilledVariable(bArr3);
                this.L$5 = null;
                this.D$0 = d5;
                this.I$0 = i4;
                this.label = i3;
                if (jobService3.notifyParent(jobId2, bArr3, this) == obj2) {
                    return obj2;
                }
            } else {
                if (i5 != 4) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
            return Unit.INSTANCE;
            JobId jobId4 = uploadFolderJob.getJobId();
            Map<String, ? extends Object> mapMapOf = MapsKt.mapOf(TuplesKt.to(MetricKeysParam.METRIC_FILE_SIZE, Boxing.boxLong((long) uploadFolderJob.getEstimatedWork().get())));
            this.L$0 = SpillingKt.nullOutSpilledVariable(uploadFolderRunningInfo6);
            this.L$1 = SpillingKt.nullOutSpilledVariable(uploadFolderRunningInfo);
            this.L$2 = SpillingKt.nullOutSpilledVariable(uploadFolderRunningInfoCopy$default);
            this.L$3 = uploadFolderJob;
            this.L$4 = jobService;
            this.L$5 = bArr;
            this.D$0 = d;
            this.I$0 = i;
            this.label = 2;
            if (jobService.updateLogData(jobId4, mapMapOf, this) != coroutine_suspended) {
                jobService2 = jobService;
                d2 = d;
                i2 = i;
                uploadFolderRunningInfo2 = uploadFolderRunningInfo;
                uploadFolderRunningInfo3 = uploadFolderRunningInfoCopy$default;
                uploadFolderJob2 = uploadFolderJob;
                bArr2 = bArr;
                jobId = uploadFolderJob2.getJobId();
                d3 = uploadFolderJob2.getProgress().get();
                d4 = uploadFolderJob2.getEstimatedWork().get();
                this.L$0 = SpillingKt.nullOutSpilledVariable(uploadFolderRunningInfo6);
                this.L$1 = SpillingKt.nullOutSpilledVariable(uploadFolderRunningInfo2);
                this.L$2 = SpillingKt.nullOutSpilledVariable(uploadFolderRunningInfo3);
                this.L$3 = uploadFolderJob2;
                this.L$4 = jobService2;
                this.L$5 = bArr2;
                this.D$0 = d2;
                this.I$0 = i2;
                this.label = 3;
                obj2 = coroutine_suspended;
                i3 = 4;
                if (jobService2.taskProgress(jobId, d3, d4, this) == obj2) {
                    return obj2;
                }
                i4 = i2;
                d5 = d2;
                bArr3 = bArr2;
                uploadFolderJob3 = uploadFolderJob2;
                uploadFolderRunningInfo4 = uploadFolderRunningInfo3;
                uploadFolderRunningInfo5 = uploadFolderRunningInfo2;
                jobService3 = jobService2;
                jobId2 = uploadFolderJob3.getJobId();
                this.L$0 = SpillingKt.nullOutSpilledVariable(uploadFolderRunningInfo6);
                this.L$1 = SpillingKt.nullOutSpilledVariable(uploadFolderRunningInfo5);
                this.L$2 = SpillingKt.nullOutSpilledVariable(uploadFolderRunningInfo4);
                this.L$3 = SpillingKt.nullOutSpilledVariable(jobService3);
                this.L$4 = SpillingKt.nullOutSpilledVariable(bArr3);
                this.L$5 = null;
                this.D$0 = d5;
                this.I$0 = i4;
                this.label = i3;
                if (jobService3.notifyParent(jobId2, bArr3, this) == obj2) {
                    return obj2;
                }
                return Unit.INSTANCE;
            }
            return coroutine_suspended;
        }
    }

    @Override // com.box.android.data.jobs.ParentJob
    public Object receiveFromChild(JobId jobId, byte[] bArr, Continuation<? super Unit> continuation) {
        Object objUpdatingRunningInfo$default = updatingRunningInfo$default(this, false, new C13542(bArr, jobId, null), continuation, 1, null);
        return objUpdatingRunningInfo$default == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objUpdatingRunningInfo$default : Unit.INSTANCE;
    }

    public static /* synthetic */ Object updatingRunningInfo$default(UploadFolderJob uploadFolderJob, boolean z, Function2 function2, Continuation continuation, int i, Object obj) {
        if ((i & 1) != 0) {
            z = true;
        }
        return uploadFolderJob.updatingRunningInfo(z, function2, continuation);
    }

    /* JADX WARN: Code duplicated, block: B:30:0x0096  */
    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x0079, code lost:
    
        if (r9.withTransaction(r2, r0) == r1) goto L32;
     */
    /* JADX WARN: Code restructure failed: missing block: B:31:0x00ad, code lost:
    
        if (r8.invoke(r6, r0) == r1) goto L32;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object updatingRunningInfo(boolean r7, kotlin.jvm.functions.Function2<? super com.box.android.data.jobs.UploadFolderRunningInfo, ? super kotlin.coroutines.Continuation<? super kotlin.Unit>, ? extends java.lang.Object> r8, kotlin.coroutines.Continuation<? super kotlin.Unit> r9) {
        /*
            r6 = this;
            boolean r0 = r9 instanceof com.box.android.data.jobs.UploadFolderJob.C13561
            if (r0 == 0) goto L14
            r0 = r9
            com.box.android.data.jobs.UploadFolderJob$updatingRunningInfo$1 r0 = (com.box.android.data.jobs.UploadFolderJob.C13561) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L14
            int r9 = r0.label
            int r9 = r9 - r2
            r0.label = r9
            goto L19
        L14:
            com.box.android.data.jobs.UploadFolderJob$updatingRunningInfo$1 r0 = new com.box.android.data.jobs.UploadFolderJob$updatingRunningInfo$1
            r0.<init>(r9)
        L19:
            java.lang.Object r9 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 3
            r4 = 2
            r5 = 1
            if (r2 == 0) goto L5a
            if (r2 == r5) goto L50
            if (r2 == r4) goto L45
            if (r2 != r3) goto L3d
            int r6 = r0.I$0
            boolean r6 = r0.Z$0
            java.lang.Object r6 = r0.L$1
            com.box.android.data.jobs.UploadFolderRunningInfo r6 = (com.box.android.data.jobs.UploadFolderRunningInfo) r6
            java.lang.Object r6 = r0.L$0
            kotlin.jvm.functions.Function2 r6 = (kotlin.jvm.functions.Function2) r6
            kotlin.ResultKt.throwOnFailure(r9)
            goto Lb0
        L3d:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r7)
            throw r6
        L45:
            boolean r7 = r0.Z$0
            java.lang.Object r6 = r0.L$0
            r8 = r6
            kotlin.jvm.functions.Function2 r8 = (kotlin.jvm.functions.Function2) r8
            kotlin.ResultKt.throwOnFailure(r9)
            goto L8c
        L50:
            boolean r6 = r0.Z$0
            java.lang.Object r6 = r0.L$0
            kotlin.jvm.functions.Function2 r6 = (kotlin.jvm.functions.Function2) r6
            kotlin.ResultKt.throwOnFailure(r9)
            goto L7c
        L5a:
            kotlin.ResultKt.throwOnFailure(r9)
            if (r7 == 0) goto L7f
            com.box.android.data.jobs.JobService r9 = r6.getJobService()
            com.box.android.data.jobs.UploadFolderJob$updatingRunningInfo$2 r2 = new com.box.android.data.jobs.UploadFolderJob$updatingRunningInfo$2
            r3 = 0
            r2.<init>(r8, r3)
            kotlin.jvm.functions.Function1 r2 = (kotlin.jvm.functions.Function1) r2
            java.lang.Object r6 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r8)
            r0.L$0 = r6
            r0.Z$0 = r7
            r0.label = r5
            java.lang.Object r6 = r9.withTransaction(r2, r0)
            if (r6 != r1) goto L7c
            goto Laf
        L7c:
            kotlin.Unit r6 = kotlin.Unit.INSTANCE
            return r6
        L7f:
            r0.L$0 = r8
            r0.Z$0 = r7
            r0.label = r4
            java.lang.Object r9 = r6.getRunningInfo(r0)
            if (r9 != r1) goto L8c
            goto Laf
        L8c:
            com.box.android.domain.utils.result.Result r9 = (com.box.android.domain.utils.result.Result) r9
            java.lang.Object r6 = com.box.android.domain.utils.result.ResultKt.getOrNull(r9)
            com.box.android.data.jobs.UploadFolderRunningInfo r6 = (com.box.android.data.jobs.UploadFolderRunningInfo) r6
            if (r6 == 0) goto Lb0
            java.lang.Object r9 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r8)
            r0.L$0 = r9
            java.lang.Object r9 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r6)
            r0.L$1 = r9
            r0.Z$0 = r7
            r7 = 0
            r0.I$0 = r7
            r0.label = r3
            java.lang.Object r6 = r8.invoke(r6, r0)
            if (r6 != r1) goto Lb0
        Laf:
            return r1
        Lb0:
            kotlin.Unit r6 = kotlin.Unit.INSTANCE
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.box.android.data.jobs.UploadFolderJob.updatingRunningInfo(boolean, kotlin.jvm.functions.Function2, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX INFO: renamed from: com.box.android.data.jobs.UploadFolderJob$updatingRunningInfo$2, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: UploadFolderJob.kt */
    @Metadata(d1 = {"\u0000\u0006\n\u0000\n\u0002\u0010\u0002\u0010\u0000\u001a\u00020\u0001H\n"}, d2 = {"<anonymous>", ""}, k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.box.android.data.jobs.UploadFolderJob$updatingRunningInfo$2", f = "UploadFolderJob.kt", i = {1, 1}, l = {434, 435}, m = "invokeSuspend", n = {"it", "$i$a$-let-UploadFolderJob$updatingRunningInfo$2$1"}, s = {"L$0", "I$0"}, v = 1)
    static final class C13572 extends SuspendLambda implements Function1<Continuation<? super Unit>, Object> {
        final /* synthetic */ Function2<UploadFolderRunningInfo, Continuation<? super Unit>, Object> $updateRunningData;
        int I$0;
        Object L$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        C13572(Function2<? super UploadFolderRunningInfo, ? super Continuation<? super Unit>, ? extends Object> function2, Continuation<? super C13572> continuation) {
            super(1, continuation);
            this.$updateRunningData = function2;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Continuation<?> continuation) {
            return UploadFolderJob.this.new C13572(this.$updateRunningData, continuation);
        }

        @Override // kotlin.jvm.functions.Function1
        public final Object invoke(Continuation<? super Unit> continuation) {
            return ((C13572) create(continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Code restructure failed: missing block: B:16:0x004e, code lost:
        
            if (r1.invoke(r5, r4) == r0) goto L17;
         */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final java.lang.Object invokeSuspend(java.lang.Object r5) {
            /*
                r4 = this;
                java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
                int r1 = r4.label
                r2 = 2
                r3 = 1
                if (r1 == 0) goto L22
                if (r1 == r3) goto L1e
                if (r1 != r2) goto L16
                java.lang.Object r4 = r4.L$0
                com.box.android.data.jobs.UploadFolderRunningInfo r4 = (com.box.android.data.jobs.UploadFolderRunningInfo) r4
                kotlin.ResultKt.throwOnFailure(r5)
                goto L51
            L16:
                java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
                java.lang.String r5 = "call to 'resume' before 'invoke' with coroutine"
                r4.<init>(r5)
                throw r4
            L1e:
                kotlin.ResultKt.throwOnFailure(r5)
                goto L33
            L22:
                kotlin.ResultKt.throwOnFailure(r5)
                com.box.android.data.jobs.UploadFolderJob r5 = com.box.android.data.jobs.UploadFolderJob.this
                r1 = r4
                kotlin.coroutines.Continuation r1 = (kotlin.coroutines.Continuation) r1
                r4.label = r3
                java.lang.Object r5 = r5.getRunningInfo(r1)
                if (r5 != r0) goto L33
                goto L50
            L33:
                com.box.android.domain.utils.result.Result r5 = (com.box.android.domain.utils.result.Result) r5
                java.lang.Object r5 = com.box.android.domain.utils.result.ResultKt.getOrNull(r5)
                com.box.android.data.jobs.UploadFolderRunningInfo r5 = (com.box.android.data.jobs.UploadFolderRunningInfo) r5
                if (r5 == 0) goto L51
                kotlin.jvm.functions.Function2<com.box.android.data.jobs.UploadFolderRunningInfo, kotlin.coroutines.Continuation<? super kotlin.Unit>, java.lang.Object> r1 = r4.$updateRunningData
                java.lang.Object r3 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r5)
                r4.L$0 = r3
                r3 = 0
                r4.I$0 = r3
                r4.label = r2
                java.lang.Object r4 = r1.invoke(r5, r4)
                if (r4 != r0) goto L51
            L50:
                return r0
            L51:
                kotlin.Unit r4 = kotlin.Unit.INSTANCE
                return r4
            */
            throw new UnsupportedOperationException("Method not decompiled: com.box.android.data.jobs.UploadFolderJob.C13572.invokeSuspend(java.lang.Object):java.lang.Object");
        }
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    public final Object getRunningInfo(Continuation<? super Result<UploadFolderRunningInfo, ? extends DomainError>> continuation) {
        C13511 c13511;
        if (continuation instanceof C13511) {
            c13511 = (C13511) continuation;
            if ((c13511.label & Integer.MIN_VALUE) != 0) {
                c13511.label -= Integer.MIN_VALUE;
            } else {
                c13511 = new C13511(continuation);
            }
        } else {
            c13511 = new C13511(continuation);
        }
        Object runningInfo = c13511.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = c13511.label;
        if (i == 0) {
            ResultKt.throwOnFailure(runningInfo);
            JobService jobService = getJobService();
            JobId jobId = this.jobId;
            c13511.label = 1;
            runningInfo = jobService.getRunningInfo(jobId, c13511);
            if (runningInfo == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(runningInfo);
        }
        Result result = (Result) runningInfo;
        if (result instanceof Result.Success) {
            byte[] bArr = (byte[]) ((Result.Success) result).getValue();
            return new Result.Success(bArr == null ? null : byteArrayToRunningInfo(bArr));
        }
        if (result instanceof Result.Error) {
            return result;
        }
        throw new NoWhenBranchMatchedException();
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x00f1, code lost:
    
        if (r14 == r1) goto L31;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object initProgress(kotlin.coroutines.Continuation<? super kotlin.Unit> r14) {
        /*
            Method dump skipped, instruction units count: 249
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.box.android.data.jobs.UploadFolderJob.initProgress(kotlin.coroutines.Continuation):java.lang.Object");
    }

    @Override // com.box.android.data.jobs.Job
    public Object cleanup(Continuation<? super Unit> continuation) {
        return Unit.INSTANCE;
    }

    @Override // com.box.android.data.jobs.Job
    public Object shouldBeRemovedFromDbOnSuccess(Continuation<? super Boolean> continuation) {
        return Boxing.boxBoolean(false);
    }

    @Override // com.box.android.domain.models.DisplayableJob
    public IJobDisplayInfoProvider getJobDisplayInfoProvider() {
        ItemId.Companion companion = ItemId.INSTANCE;
        String string = this.inputData.getString(LOCAL_FOLDER_ID_PARAM);
        Intrinsics.checkNotNull(string);
        return new UploadFolderJobDisplayInfoProvider(companion.create(string), this.localItemService, this.idMappingService, this.inputData.getBoolean(JobConstants.SHOW_NOTIFICATION, true));
    }

    @Override // com.box.android.domain.models.DisplayableJob
    public boolean shouldDisplay() {
        return shouldDisplayInJobsUi();
    }

    private final boolean shouldDisplayInJobsUi() {
        if (this.inputData.getKeyValueMap().keySet().contains(JobConstants.SHOULD_DISPLAY_JOB)) {
            return this.inputData.getBoolean(JobConstants.SHOULD_DISPLAY_JOB, true);
        }
        return this.inputData.getBoolean(JobConstants.IS_USER_TRIGGERED, true);
    }

    @Override // com.box.android.domain.models.MetricsInfoProvider
    public String getAmplitudeJobType() {
        return "upload_folder";
    }

    @Override // com.box.android.domain.models.MetricsInfoProvider
    public Object getAmplitudeInfos(Continuation<? super Map<String, ? extends Object>> continuation) {
        return MapsKt.emptyMap();
    }

    public final byte[] runningInfoToByteArray(UploadFolderRunningInfo runningInfo) {
        Intrinsics.checkNotNullParameter(runningInfo, "runningInfo");
        String json = this.moshi.adapter(UploadFolderRunningInfo.class).toJson(runningInfo);
        Intrinsics.checkNotNullExpressionValue(json, "toJson(...)");
        byte[] bytes = json.getBytes(Charsets.UTF_8);
        Intrinsics.checkNotNullExpressionValue(bytes, "getBytes(...)");
        return bytes;
    }

    public final UploadFolderRunningInfo byteArrayToRunningInfo(byte[] byteArray) {
        Intrinsics.checkNotNullParameter(byteArray, "byteArray");
        String str = new String(byteArray, Charsets.UTF_8);
        JsonAdapter jsonAdapterAdapter = this.moshi.adapter(UploadFolderRunningInfo.class);
        Intrinsics.checkNotNullExpressionValue(jsonAdapterAdapter, "adapter(...)");
        UploadFolderRunningInfo uploadFolderRunningInfo = (UploadFolderRunningInfo) AnnotationEntityDomainMapperKt.fromJsonOrNull(jsonAdapterAdapter, str);
        if (uploadFolderRunningInfo != null) {
            return uploadFolderRunningInfo;
        }
        throw new IllegalStateException("Failed to parse running info from JSON ".concat(str).toString());
    }
}
