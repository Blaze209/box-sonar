package com.box.android.data.jobs;

import android.content.Context;
import androidx.work.Data;
import com.box.android.common.utilities.BoxCommonConstants;
import com.box.android.data.persistence.jobs.DomainErrorConverter;
import com.box.android.data.persistence.jobs.JobEntity;
import com.box.android.domain.jobs.JobConstants;
import com.box.android.domain.jobs.JobId;
import com.box.android.domain.jobs.JobRequest;
import com.box.android.domain.jobs.JobType;
import com.box.android.domain.models.DisplayableJob;
import com.box.android.domain.models.DomainError;
import com.box.android.domain.models.DownloadFileDomainError;
import com.box.android.domain.models.DownloadFolderJobDisplayInfoProvider;
import com.box.android.domain.models.IJobDisplayInfoProvider;
import com.box.android.domain.models.ItemId;
import com.box.android.domain.models.item.FileModel;
import com.box.android.domain.models.item.FolderModel;
import com.box.android.domain.models.item.ItemModel;
import com.box.android.domain.models.item.ItemModelKt;
import com.box.android.domain.services.IRemoteItemService;
import com.box.android.domain.usecases.jobs.JobTags;
import com.box.android.domain.utils.ExtensionsKt;
import com.box.android.domain.utils.result.Result;
import com.box.androidsdk.content.models.BoxRepresentation;
import com.box.androidsdk.content.utils.BoxLogUtils;
import com.box.brownfieldApi.featuresNavigator.activities.ReactNativeFeatureActivity;
import com.facebook.imageutils.JfifUtil;
import com.facebook.react.modules.dialog.AlertFragment;
import com.squareup.moshi.JsonAdapter;
import com.squareup.moshi.Moshi;
import dagger.assisted.Assisted;
import dagger.assisted.AssistedFactory;
import dagger.assisted.AssistedInject;
import external.sdk.pendo.io.mozilla.javascript.Token;
import java.io.File;
import java.io.IOException;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.SetsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
import kotlinx.coroutines.sync.Mutex;
import kotlinx.coroutines.sync.MutexKt;

/* JADX INFO: compiled from: DownloadFolderJob.kt */
/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000\u0092\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0006\n\u0002\b\u0004\n\u0002\u0010\u0012\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 J2\u00020\u00012\u00020\u0002:\u0002JKB=\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\b\b\u0001\u0010\u0007\u001a\u00020\b\u0012\b\b\u0001\u0010\t\u001a\u00020\n\u0012\u0006\u0010\u000b\u001a\u00020\f\u0012\u0006\u0010\r\u001a\u00020\u000e¢\u0006\u0004\b\u000f\u0010\u0010J\u000e\u0010#\u001a\u00020$H\u0096@¢\u0006\u0002\u0010%J\u0016\u0010&\u001a\u00020$2\u0006\u0010'\u001a\u00020\bH\u0096@¢\u0006\u0002\u0010(J\u0010\u0010)\u001a\u0004\u0018\u00010\u001bH\u0082@¢\u0006\u0002\u0010%J\u001e\u0010*\u001a\u00020$2\u0006\u0010'\u001a\u00020\b2\u0006\u0010+\u001a\u00020,H\u0096@¢\u0006\u0002\u0010-J&\u0010.\u001a\u00020$2\u0006\u0010'\u001a\u00020\b2\u0006\u0010/\u001a\u0002002\u0006\u00101\u001a\u000200H\u0096@¢\u0006\u0002\u00102J\u001e\u00103\u001a\u00020$2\u0006\u0010'\u001a\u00020\b2\u0006\u00104\u001a\u000205H\u0096@¢\u0006\u0002\u00106J\u000e\u00107\u001a\u00020$H\u0082@¢\u0006\u0002\u0010%J\u001a\u00108\u001a\u0004\u0018\u0001092\u0006\u0010:\u001a\u00020;2\u0006\u0010<\u001a\u00020=H\u0002J\u000e\u0010>\u001a\u00020\u001b2\u0006\u0010?\u001a\u000205J\u000e\u0010@\u001a\u0002052\u0006\u0010A\u001a\u00020\u001bJ\u0012\u0010B\u001a\u000e\u0012\u0004\u0012\u00020=\u0012\u0004\u0012\u00020,0CJ\u000e\u0010D\u001a\u00020$H\u0096@¢\u0006\u0002\u0010%J\u000e\u0010E\u001a\u00020FH\u0096@¢\u0006\u0002\u0010%J\b\u0010G\u001a\u00020FH\u0016J\b\u0010H\u001a\u00020IH\u0016R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0011\u0010\t\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0014\u0010\u000b\u001a\u00020\fX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0014\u0010\r\u001a\u00020\u000eX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R?\u0010\u0019\u001a&\u0012\f\u0012\n \u001c*\u0004\u0018\u00010\u001b0\u001b \u001c*\u0012\u0012\f\u0012\n \u001c*\u0004\u0018\u00010\u001b0\u001b\u0018\u00010\u001a0\u001a8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001f\u0010 \u001a\u0004\b\u001d\u0010\u001eR\u000e\u0010!\u001a\u00020\"X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006L"}, d2 = {"Lcom/box/android/data/jobs/DownloadFolderJob;", "Lcom/box/android/data/jobs/ParentJob;", "Lcom/box/android/domain/models/DisplayableJob;", "itemService", "Lcom/box/android/domain/services/IRemoteItemService;", "moshi", "Lcom/squareup/moshi/Moshi;", JobWorker.JOB_ID_PARAM, "Lcom/box/android/domain/jobs/JobId;", "inputData", "Landroidx/work/Data;", "appContext", "Landroid/content/Context;", "jobService", "Lcom/box/android/data/jobs/JobService;", "<init>", "(Lcom/box/android/domain/services/IRemoteItemService;Lcom/squareup/moshi/Moshi;Lcom/box/android/domain/jobs/JobId;Landroidx/work/Data;Landroid/content/Context;Lcom/box/android/data/jobs/JobService;)V", "getJobId", "()Lcom/box/android/domain/jobs/JobId;", "getInputData", "()Landroidx/work/Data;", "getAppContext", "()Landroid/content/Context;", "getJobService", "()Lcom/box/android/data/jobs/JobService;", "sessionInfoAdapter", "Lcom/squareup/moshi/JsonAdapter;", "Lcom/box/android/data/jobs/DownloadFolderSessionInfo;", "kotlin.jvm.PlatformType", "getSessionInfoAdapter", "()Lcom/squareup/moshi/JsonAdapter;", "sessionInfoAdapter$delegate", "Lkotlin/Lazy;", "mutex", "Lkotlinx/coroutines/sync/Mutex;", "start", "", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "childSucceeded", "childJobId", "(Lcom/box/android/domain/jobs/JobId;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getCurrentRunningInfo", "childFailed", "domainError", "Lcom/box/android/domain/models/DomainError;", "(Lcom/box/android/domain/jobs/JobId;Lcom/box/android/domain/models/DomainError;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "childProgressed", "currentProgress", "", "estimatedWork", "(Lcom/box/android/domain/jobs/JobId;DDLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "receiveFromChild", BoxRepresentation.FIELD_INFO, "", "(Lcom/box/android/domain/jobs/JobId;[BLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "enqueueChildJobs", "getDownloadJobRequestForItem", "Lcom/box/android/domain/jobs/JobRequest;", "itemModel", "Lcom/box/android/domain/models/item/ItemModel;", "targetFolder", "Ljava/io/File;", "getDownloadFolderSessionInfo", "byteArray", "getSessionInfoByteArray", "downloadFolderSessionInfo", "getTargetFolderOnDevice", "Lcom/box/android/domain/utils/result/Result;", "cleanup", "shouldBeRemovedFromDbOnSuccess", "", "shouldDisplay", "getJobDisplayInfoProvider", "Lcom/box/android/domain/models/IJobDisplayInfoProvider;", "Companion", "Factory", "data_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class DownloadFolderJob implements ParentJob, DisplayableJob {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public static final String FOLDER_ID_PARAM = "FileIdParam";
    public static final String FOLDER_NAME_PARAM = "FolderNameParam";
    public static final String TARGET_DEST_FOLDER_PARAM = "targetDestFolderParam";
    private final Context appContext;
    private final Data inputData;
    private final IRemoteItemService itemService;
    private final JobId jobId;
    private final JobService jobService;
    private final Moshi moshi;
    private final Mutex mutex;

    /* JADX INFO: renamed from: sessionInfoAdapter$delegate, reason: from kotlin metadata */
    private final Lazy sessionInfoAdapter;

    /* JADX INFO: compiled from: DownloadFolderJob.kt */
    @AssistedFactory
    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bg\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H&¨\u0006\bÀ\u0006\u0003"}, d2 = {"Lcom/box/android/data/jobs/DownloadFolderJob$Factory;", "", "createJob", "Lcom/box/android/data/jobs/DownloadFolderJob;", JobWorker.JOB_ID_PARAM, "Lcom/box/android/domain/jobs/JobId;", "inputData", "Landroidx/work/Data;", "data_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public interface Factory {
        DownloadFolderJob createJob(JobId jobId, Data inputData);
    }

    /* JADX INFO: renamed from: com.box.android.data.jobs.DownloadFolderJob$childFailed$1, reason: invalid class name */
    /* JADX INFO: compiled from: DownloadFolderJob.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.box.android.data.jobs.DownloadFolderJob", f = "DownloadFolderJob.kt", i = {0, 0, 0, 0, 1, 1, 1, 1, 1, 2, 2, 2, 2, 2, 3, 3, 3, 3, 3, 3, 3, 3, 3, 4, 4, 4, 4, 4, 4, 4, 4, 4}, l = {331, Token.ARRAYCOMP, Token.LETEXPR, 177, 183}, m = "childFailed", n = {"childJobId", "domainError", "$this$withLock_u24default$iv", "$i$f$withLock", "childJobId", "domainError", "$this$withLock_u24default$iv", "$i$f$withLock", "$i$a$-withLock$default-DownloadFolderJob$childFailed$2", "childJobId", "domainError", "$this$withLock_u24default$iv", "$i$f$withLock", "$i$a$-withLock$default-DownloadFolderJob$childFailed$2", "childJobId", "domainError", "$this$withLock_u24default$iv", "updatedPendingMap", "sessionInfo", "updatedFailedJobs", "updatedRunningInfo", "$i$f$withLock", "$i$a$-withLock$default-DownloadFolderJob$childFailed$2", "childJobId", "domainError", "$this$withLock_u24default$iv", "updatedPendingMap", "sessionInfo", "updatedFailedJobs", "updatedRunningInfo", "$i$f$withLock", "$i$a$-withLock$default-DownloadFolderJob$childFailed$2"}, s = {"L$0", "L$1", "L$2", "I$0", "L$0", "L$1", "L$2", "I$0", "I$1", "L$0", "L$1", "L$2", "I$0", "I$1", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "I$0", "I$1", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "I$0", "I$1"}, v = 1)
    static final class AnonymousClass1 extends ContinuationImpl {
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

        AnonymousClass1(Continuation<? super AnonymousClass1> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return DownloadFolderJob.this.childFailed(null, null, this);
        }
    }

    /* JADX INFO: renamed from: com.box.android.data.jobs.DownloadFolderJob$childSucceeded$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: DownloadFolderJob.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.box.android.data.jobs.DownloadFolderJob", f = "DownloadFolderJob.kt", i = {0, 0, 0, 1, 1, 1, 1, 2, 2, 2, 2, 3, 3, 3, 3, 3, 3, 4, 4, 4, 4, 4, 4, 4, 4, 5, 5, 5, 5, 5, 5, 5, 5, 6, 6, 6, 6, 6, 6, 6, 6}, l = {331, 113, 114, 124, 134, 140, Token.LOCAL_BLOCK}, m = "childSucceeded", n = {"childJobId", "$this$withLock_u24default$iv", "$i$f$withLock", "childJobId", "$this$withLock_u24default$iv", "$i$f$withLock", "$i$a$-withLock$default-DownloadFolderJob$childSucceeded$2", "childJobId", "$this$withLock_u24default$iv", "$i$f$withLock", "$i$a$-withLock$default-DownloadFolderJob$childSucceeded$2", "childJobId", "$this$withLock_u24default$iv", "sessionInfo", "$i$f$withLock", "$i$a$-withLock$default-DownloadFolderJob$childSucceeded$2", "newDownloadedSize", "childJobId", "$this$withLock_u24default$iv", "sessionInfo", "updatedRunningInfo", "updatedPendingMap", "$i$f$withLock", "$i$a$-withLock$default-DownloadFolderJob$childSucceeded$2", "newDownloadedSize", "childJobId", "$this$withLock_u24default$iv", "sessionInfo", "updatedRunningInfo", "updatedPendingMap", "$i$f$withLock", "$i$a$-withLock$default-DownloadFolderJob$childSucceeded$2", "newDownloadedSize", "childJobId", "$this$withLock_u24default$iv", "sessionInfo", "updatedRunningInfo", "updatedPendingMap", "$i$f$withLock", "$i$a$-withLock$default-DownloadFolderJob$childSucceeded$2", "newDownloadedSize"}, s = {"L$0", "L$1", "I$0", "L$0", "L$1", "I$0", "I$1", "L$0", "L$1", "I$0", "I$1", "L$0", "L$1", "L$2", "I$0", "I$1", "J$0", "L$0", "L$1", "L$2", "L$3", "L$4", "I$0", "I$1", "J$0", "L$0", "L$1", "L$2", "L$3", "L$4", "I$0", "I$1", "J$0", "L$0", "L$1", "L$2", "L$3", "L$4", "I$0", "I$1", "J$0"}, v = 1)
    static final class C12551 extends ContinuationImpl {
        int I$0;
        int I$1;
        long J$0;
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        Object L$4;
        int label;
        /* synthetic */ Object result;

        C12551(Continuation<? super C12551> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return DownloadFolderJob.this.childSucceeded(null, this);
        }
    }

    /* JADX INFO: renamed from: com.box.android.data.jobs.DownloadFolderJob$enqueueChildJobs$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: DownloadFolderJob.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.box.android.data.jobs.DownloadFolderJob", f = "DownloadFolderJob.kt", i = {0, 1, 1, 2, 2}, l = {204, 214, JfifUtil.MARKER_RST7}, m = "enqueueChildJobs", n = {ReactNativeFeatureActivity.RESULT_EXTRA_KEY, "targetFolder", "folderRemoteId", "targetFolder", "folderRemoteId"}, s = {"L$0", "L$0", "L$1", "L$0", "L$1"}, v = 1)
    static final class C12561 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        int label;
        /* synthetic */ Object result;

        C12561(Continuation<? super C12561> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return DownloadFolderJob.this.enqueueChildJobs(this);
        }
    }

    /* JADX INFO: renamed from: com.box.android.data.jobs.DownloadFolderJob$getCurrentRunningInfo$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: DownloadFolderJob.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.box.android.data.jobs.DownloadFolderJob", f = "DownloadFolderJob.kt", i = {}, l = {Token.SET}, m = "getCurrentRunningInfo", n = {}, s = {}, v = 1)
    static final class C12571 extends ContinuationImpl {
        Object L$0;
        int label;
        /* synthetic */ Object result;

        C12571(Continuation<? super C12571> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return DownloadFolderJob.this.getCurrentRunningInfo(this);
        }
    }

    /* JADX INFO: renamed from: com.box.android.data.jobs.DownloadFolderJob$start$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: DownloadFolderJob.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.box.android.data.jobs.DownloadFolderJob", f = "DownloadFolderJob.kt", i = {2, 3, 4, 4, 5, 5, 6, 6, 6, 6, 6, 6, 6, 7}, l = {83, 84, 87, 92, 99, 102, 104, 107}, m = "start", n = {"existingRunningInfo", "existingRunningInfo", "existingRunningInfo", "updatedRunningInfo", "existingRunningInfo", "updatedRunningInfo", "existingRunningInfo", "updatedRunningInfo", "$this$forEach$iv", "element$iv", "it", "$i$f$forEach", "$i$a$-forEach-DownloadFolderJob$start$2", "existingRunningInfo"}, s = {"L$0", "L$0", "L$0", "L$1", "L$0", "L$1", "L$0", "L$1", "L$2", "L$4", "L$5", "I$0", "I$1", "L$0"}, v = 1)
    static final class C12581 extends ContinuationImpl {
        int I$0;
        int I$1;
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        Object L$4;
        Object L$5;
        int label;
        /* synthetic */ Object result;

        C12581(Continuation<? super C12581> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return DownloadFolderJob.this.start(this);
        }
    }

    @AssistedInject
    public DownloadFolderJob(IRemoteItemService itemService, Moshi moshi, @Assisted JobId jobId, @Assisted Data inputData, Context appContext, JobService jobService) {
        Intrinsics.checkNotNullParameter(itemService, "itemService");
        Intrinsics.checkNotNullParameter(moshi, "moshi");
        Intrinsics.checkNotNullParameter(jobId, "jobId");
        Intrinsics.checkNotNullParameter(inputData, "inputData");
        Intrinsics.checkNotNullParameter(appContext, "appContext");
        Intrinsics.checkNotNullParameter(jobService, "jobService");
        this.itemService = itemService;
        this.moshi = moshi;
        this.jobId = jobId;
        this.inputData = inputData;
        this.appContext = appContext;
        this.jobService = jobService;
        this.sessionInfoAdapter = LazyKt.lazy(new Function0() { // from class: com.box.android.data.jobs.DownloadFolderJob$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return DownloadFolderJob.sessionInfoAdapter_delegate$lambda$0(this.f$0);
            }
        });
        this.mutex = MutexKt.Mutex$default(false, 1, null);
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

    /* JADX INFO: compiled from: DownloadFolderJob.kt */
    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J(\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u00052\u0006\u0010\r\u001a\u00020\u00052\b\b\u0002\u0010\u000e\u001a\u00020\u000fR\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0010"}, d2 = {"Lcom/box/android/data/jobs/DownloadFolderJob$Companion;", "", "<init>", "()V", "FOLDER_ID_PARAM", "", "FOLDER_NAME_PARAM", "TARGET_DEST_FOLDER_PARAM", "getRequest", "Lcom/box/android/domain/jobs/JobRequest;", "remoteId", "Lcom/box/android/domain/models/ItemId$Remote;", BoxCommonConstants.EXTRA_FOLDER_NAME, "targetFolderUri", JobConstants.SHOULD_DISPLAY_JOB, "", "data_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public static /* synthetic */ JobRequest getRequest$default(Companion companion, ItemId.Remote remote, String str, String str2, boolean z, int i, Object obj) {
            if ((i & 8) != 0) {
                z = true;
            }
            return companion.getRequest(remote, str, str2, z);
        }

        public final JobRequest getRequest(ItemId.Remote remoteId, String folderName, String targetFolderUri, boolean shouldDisplayJob) {
            Intrinsics.checkNotNullParameter(remoteId, "remoteId");
            Intrinsics.checkNotNullParameter(folderName, "folderName");
            Intrinsics.checkNotNullParameter(targetFolderUri, "targetFolderUri");
            JobRequest.Builder builder = new JobRequest.Builder(JobType.DOWNLOAD_FOLDER, null, null, null, 14, null);
            Data.Builder builder2 = new Data.Builder();
            builder2.putString("FileIdParam", remoteId.getBoxId());
            builder2.putString(DownloadFolderJob.TARGET_DEST_FOLDER_PARAM, targetFolderUri);
            builder2.putString(DownloadFolderJob.FOLDER_NAME_PARAM, folderName);
            builder2.putBoolean(JobConstants.SHOULD_DISPLAY_JOB, shouldDisplayJob);
            builder.setData(builder2.build());
            return builder.build();
        }
    }

    private final JsonAdapter<DownloadFolderSessionInfo> getSessionInfoAdapter() {
        return (JsonAdapter) this.sessionInfoAdapter.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final JsonAdapter sessionInfoAdapter_delegate$lambda$0(DownloadFolderJob downloadFolderJob) {
        DomainErrorConverter.Companion companion = DomainErrorConverter.INSTANCE;
        Moshi.Builder builderNewBuilder = downloadFolderJob.moshi.newBuilder();
        Intrinsics.checkNotNullExpressionValue(builderNewBuilder, "newBuilder(...)");
        return companion.appendTo(builderNewBuilder).build().adapter(DownloadFolderSessionInfo.class);
    }

    /* JADX WARN: Code duplicated, block: B:26:0x00b2 A[PHI: r1
      0x00b2: PHI (r1v7 java.lang.Object) = (r1v6 java.lang.Object), (r1v1 java.lang.Object) binds: [B:24:0x00ae, B:18:0x0085] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:28:0x00b7  */
    /* JADX WARN: Code duplicated, block: B:30:0x00c1  */
    /* JADX WARN: Code duplicated, block: B:35:0x00db  */
    /* JADX WARN: Code duplicated, block: B:37:0x00e5  */
    /* JADX WARN: Code duplicated, block: B:42:0x00ff  */
    /* JADX WARN: Code duplicated, block: B:45:0x0132  */
    /* JADX WARN: Code duplicated, block: B:52:0x0165  */
    /* JADX WARN: Code duplicated, block: B:57:0x01a6  */
    /* JADX WARN: Code duplicated, block: B:63:0x01b6 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:65:? A[LOOP:0: B:50:0x015f->B:65:?, LOOP_END, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:7:0x0018  */
    /* JADX WARN: Code restructure failed: missing block: B:31:0x00d4, code lost:
    
        if (r1.waitForChildren(r0, r6) == r2) goto L59;
     */
    /* JADX WARN: Code restructure failed: missing block: B:38:0x00f8, code lost:
    
        if (r1.jobSucceeded(r0, r6) == r2) goto L59;
     */
    /* JADX WARN: Code restructure failed: missing block: B:47:0x0149, code lost:
    
        if (r1.waitForChildren(r5, r6) == r2) goto L59;
     */
    /* JADX WARN: Code restructure failed: missing block: B:58:0x01b4, code lost:
    
        if (enqueueChildJobs(r6) == r2) goto L59;
     */
    @Override // com.box.android.data.jobs.Job
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.Object start(kotlin.coroutines.Continuation<? super kotlin.Unit> r21) {
        /*
            Method dump skipped, instruction units count: 464
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.box.android.data.jobs.DownloadFolderJob.start(kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARN: Code duplicated, block: B:46:0x011c  */
    /* JADX WARN: Code duplicated, block: B:49:0x0125 A[Catch: all -> 0x0152, TRY_ENTER, TRY_LEAVE, TryCatch #3 {all -> 0x0152, blocks: (B:49:0x0125, B:60:0x0165), top: B:116:0x0123 }] */
    /* JADX WARN: Code duplicated, block: B:52:0x014b  */
    /* JADX WARN: Code duplicated, block: B:58:0x0157 A[Catch: all -> 0x02ae, TRY_ENTER, TRY_LEAVE, TryCatch #10 {all -> 0x02ae, blocks: (B:47:0x0121, B:58:0x0157, B:63:0x016b), top: B:127:0x0121 }] */
    /* JADX WARN: Code duplicated, block: B:60:0x0165 A[Catch: all -> 0x0152, TRY_ENTER, TRY_LEAVE, TryCatch #3 {all -> 0x0152, blocks: (B:49:0x0125, B:60:0x0165), top: B:116:0x0123 }] */
    /* JADX WARN: Code duplicated, block: B:63:0x016b A[Catch: all -> 0x02ae, TRY_ENTER, TRY_LEAVE, TryCatch #10 {all -> 0x02ae, blocks: (B:47:0x0121, B:58:0x0157, B:63:0x016b), top: B:127:0x0121 }] */
    /* JADX WARN: Code duplicated, block: B:70:0x01b8  */
    /* JADX WARN: Code duplicated, block: B:74:0x020e  */
    /* JADX WARN: Code duplicated, block: B:77:0x021d A[Catch: all -> 0x02a2, TryCatch #4 {all -> 0x02a2, blocks: (B:75:0x0217, B:77:0x021d, B:79:0x0227, B:82:0x0257, B:84:0x0263, B:85:0x026c), top: B:117:0x0217 }] */
    /* JADX WARN: Code duplicated, block: B:79:0x0227 A[Catch: all -> 0x02a2, TryCatch #4 {all -> 0x02a2, blocks: (B:75:0x0217, B:77:0x021d, B:79:0x0227, B:82:0x0257, B:84:0x0263, B:85:0x026c), top: B:117:0x0217 }] */
    /* JADX WARN: Code duplicated, block: B:7:0x0018  */
    /* JADX WARN: Code duplicated, block: B:81:0x0256  */
    /* JADX WARN: Code duplicated, block: B:82:0x0257 A[Catch: all -> 0x02a2, TryCatch #4 {all -> 0x02a2, blocks: (B:75:0x0217, B:77:0x021d, B:79:0x0227, B:82:0x0257, B:84:0x0263, B:85:0x026c), top: B:117:0x0217 }] */
    /* JADX WARN: Code duplicated, block: B:84:0x0263 A[Catch: all -> 0x02a2, TryCatch #4 {all -> 0x02a2, blocks: (B:75:0x0217, B:77:0x021d, B:79:0x0227, B:82:0x0257, B:84:0x0263, B:85:0x026c), top: B:117:0x0217 }] */
    /* JADX WARN: Code restructure failed: missing block: B:86:0x0293, code lost:
    
        if (r1.jobFailed(r0, com.box.android.domain.jobs.JobType.DOWNLOAD_FOLDER, r11, r9) == r2) goto L87;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r23v0, types: [com.box.android.data.jobs.DownloadFolderJob] */
    /* JADX WARN: Type inference failed for: r2v18 */
    /* JADX WARN: Type inference failed for: r2v33 */
    /* JADX WARN: Type inference failed for: r2v34 */
    /* JADX WARN: Type inference failed for: r2v5, types: [kotlinx.coroutines.sync.Mutex] */
    /* JADX WARN: Type inference failed for: r2v8 */
    @Override // com.box.android.data.jobs.ParentJob
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.Object childSucceeded(com.box.android.domain.jobs.JobId r24, kotlin.coroutines.Continuation<? super kotlin.Unit> r25) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 718
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.box.android.data.jobs.DownloadFolderJob.childSucceeded(com.box.android.domain.jobs.JobId, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    public final Object getCurrentRunningInfo(Continuation<? super DownloadFolderSessionInfo> continuation) {
        C12571 c12571;
        if (continuation instanceof C12571) {
            c12571 = (C12571) continuation;
            if ((c12571.label & Integer.MIN_VALUE) != 0) {
                c12571.label -= Integer.MIN_VALUE;
            } else {
                c12571 = new C12571(continuation);
            }
        } else {
            c12571 = new C12571(continuation);
        }
        Object runningInfo = c12571.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = c12571.label;
        if (i == 0) {
            ResultKt.throwOnFailure(runningInfo);
            JobService jobService = getJobService();
            JobId jobId = this.jobId;
            c12571.L$0 = this;
            c12571.label = 1;
            runningInfo = jobService.getRunningInfo(jobId, c12571);
            if (runningInfo == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            this = (DownloadFolderJob) c12571.L$0;
            ResultKt.throwOnFailure(runningInfo);
        }
        byte[] bArr = (byte[]) com.box.android.domain.utils.result.ResultKt.getOrNull((Result) runningInfo);
        if (bArr == null) {
            return null;
        }
        return this.getDownloadFolderSessionInfo(bArr);
    }

    /* JADX WARN: Code duplicated, block: B:47:0x011d A[Catch: all -> 0x00c6, TRY_ENTER, TRY_LEAVE, TryCatch #1 {all -> 0x00c6, blocks: (B:31:0x00ba, B:47:0x011d, B:56:0x015d), top: B:85:0x00ba }] */
    /* JADX WARN: Code duplicated, block: B:50:0x0148  */
    /* JADX WARN: Code duplicated, block: B:54:0x014f A[Catch: all -> 0x022e, TRY_ENTER, TRY_LEAVE, TryCatch #6 {all -> 0x022e, blocks: (B:45:0x0118, B:54:0x014f, B:59:0x0163), top: B:93:0x0118 }] */
    /* JADX WARN: Code duplicated, block: B:56:0x015d A[Catch: all -> 0x00c6, TRY_ENTER, TRY_LEAVE, TryCatch #1 {all -> 0x00c6, blocks: (B:31:0x00ba, B:47:0x011d, B:56:0x015d), top: B:85:0x00ba }] */
    /* JADX WARN: Code duplicated, block: B:59:0x0163 A[Catch: all -> 0x022e, TRY_ENTER, TRY_LEAVE, TryCatch #6 {all -> 0x022e, blocks: (B:45:0x0118, B:54:0x014f, B:59:0x0163), top: B:93:0x0118 }] */
    /* JADX WARN: Code duplicated, block: B:62:0x01d6  */
    /* JADX WARN: Code duplicated, block: B:65:0x01e5 A[Catch: all -> 0x022b, TRY_LEAVE, TryCatch #4 {all -> 0x022b, blocks: (B:63:0x01df, B:65:0x01e5), top: B:89:0x01df }] */
    /* JADX WARN: Code duplicated, block: B:7:0x0018  */
    /* JADX WARN: Code restructure failed: missing block: B:66:0x021c, code lost:
    
        if (r1.jobFailed(r0, com.box.android.domain.jobs.JobType.DOWNLOAD_FOLDER, r14, r2) == r3) goto L67;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r23v0, types: [com.box.android.data.jobs.DownloadFolderJob] */
    /* JADX WARN: Type inference failed for: r3v14 */
    /* JADX WARN: Type inference failed for: r3v2, types: [kotlinx.coroutines.sync.Mutex] */
    /* JADX WARN: Type inference failed for: r3v20 */
    /* JADX WARN: Type inference failed for: r3v21 */
    @Override // com.box.android.data.jobs.ParentJob
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.Object childFailed(com.box.android.domain.jobs.JobId r24, com.box.android.domain.models.DomainError r25, kotlin.coroutines.Continuation<? super kotlin.Unit> r26) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 568
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.box.android.data.jobs.DownloadFolderJob.childFailed(com.box.android.domain.jobs.JobId, com.box.android.domain.models.DomainError, kotlin.coroutines.Continuation):java.lang.Object");
    }

    @Override // com.box.android.data.jobs.ParentJob
    public Object childProgressed(JobId jobId, double d, double d2, Continuation<? super Unit> continuation) {
        return Unit.INSTANCE;
    }

    @Override // com.box.android.data.jobs.ParentJob
    public Object receiveFromChild(JobId jobId, byte[] bArr, Continuation<? super Unit> continuation) {
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x00ab, code lost:
    
        if (kotlinx.coroutines.flow.FlowKt.collectLatest(r8, r5, r0) == r1) goto L33;
     */
    /* JADX WARN: Code restructure failed: missing block: B:32:0x00d2, code lost:
    
        if (r2.jobFailed(r7, com.box.android.domain.jobs.JobType.DOWNLOAD_FOLDER, r3, r0) == r1) goto L33;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object enqueueChildJobs(kotlin.coroutines.Continuation<? super kotlin.Unit> r8) {
        /*
            Method dump skipped, instruction units count: 222
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.box.android.data.jobs.DownloadFolderJob.enqueueChildJobs(kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX INFO: renamed from: com.box.android.data.jobs.DownloadFolderJob$enqueueChildJobs$2, reason: invalid class name */
    /* JADX INFO: compiled from: DownloadFolderJob.kt */
    @Metadata(d1 = {"\u0000\u0018\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\u0018\u0010\u0002\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u0004\u0012\u0004\u0012\u00020\u00060\u0003H\n"}, d2 = {"<anonymous>", "", ReactNativeFeatureActivity.RESULT_EXTRA_KEY, "Lcom/box/android/domain/utils/result/Result;", "", "Lcom/box/android/domain/models/item/ItemModel;", "Lcom/box/android/domain/models/DomainError;"}, k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.box.android.data.jobs.DownloadFolderJob$enqueueChildJobs$2", f = "DownloadFolderJob.kt", i = {0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 3, 3, 3, 3, 3, 3, 3, 3, 3, 4, 4, 4, 4, 4}, l = {227, 230, 232, 234, 238}, m = "invokeSuspend", n = {ReactNativeFeatureActivity.RESULT_EXTRA_KEY, "$this$map$iv", AlertFragment.ARG_ITEMS, "totalSize", "sessionInfoMap", "requests", "$i$f$map", "$i$a$-map-DownloadFolderJob$enqueueChildJobs$2$1", ReactNativeFeatureActivity.RESULT_EXTRA_KEY, "$this$map$iv", AlertFragment.ARG_ITEMS, "totalSize", "sessionInfoMap", "runningInfo", "requests", "$i$f$map", "$i$a$-map-DownloadFolderJob$enqueueChildJobs$2$1", ReactNativeFeatureActivity.RESULT_EXTRA_KEY, "$this$map$iv", AlertFragment.ARG_ITEMS, "totalSize", "sessionInfoMap", "runningInfo", "$this$forEach$iv", "element$iv", "it", "requests", "$i$f$map", "$i$a$-map-DownloadFolderJob$enqueueChildJobs$2$1", "$i$f$forEach", "$i$a$-forEach-DownloadFolderJob$enqueueChildJobs$2$1$1", ReactNativeFeatureActivity.RESULT_EXTRA_KEY, "$this$map$iv", AlertFragment.ARG_ITEMS, "totalSize", "sessionInfoMap", "runningInfo", "requests", "$i$f$map", "$i$a$-map-DownloadFolderJob$enqueueChildJobs$2$1", ReactNativeFeatureActivity.RESULT_EXTRA_KEY, "$this$mapError$iv", "error", "$i$f$mapError", "$i$a$-mapError-DownloadFolderJob$enqueueChildJobs$2$2"}, s = {"L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "I$0", "I$1", "L$0", "L$1", "L$3", "L$4", "L$5", "L$6", "L$7", "I$0", "I$1", "L$0", "L$1", "L$3", "L$4", "L$5", "L$6", "L$7", "L$9", "L$10", "L$11", "I$0", "I$1", "I$2", "I$3", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "I$0", "I$1", "L$0", "L$1", "L$2", "I$0", "I$1"}, v = 1)
    static final class AnonymousClass2 extends SuspendLambda implements Function2<Result<? extends List<? extends ItemModel>, ? extends DomainError>, Continuation<? super Unit>, Object> {
        final /* synthetic */ File $targetFolder;
        int I$0;
        int I$1;
        int I$2;
        int I$3;
        /* synthetic */ Object L$0;
        Object L$1;
        Object L$10;
        Object L$11;
        Object L$2;
        Object L$3;
        Object L$4;
        Object L$5;
        Object L$6;
        Object L$7;
        Object L$8;
        Object L$9;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass2(File file, Continuation<? super AnonymousClass2> continuation) {
            super(2, continuation);
            this.$targetFolder = file;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            AnonymousClass2 anonymousClass2 = DownloadFolderJob.this.new AnonymousClass2(this.$targetFolder, continuation);
            anonymousClass2.L$0 = obj;
            return anonymousClass2;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(Result<? extends List<? extends ItemModel>, ? extends DomainError> result, Continuation<? super Unit> continuation) {
            return ((AnonymousClass2) create(result, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Code duplicated, block: B:47:0x01f9  */
        /* JADX WARN: Code duplicated, block: B:50:0x0268 A[LOOP:0: B:45:0x01f3->B:50:0x0268, LOOP_END] */
        /* JADX WARN: Code duplicated, block: B:60:0x02cd  */
        /* JADX WARN: Code duplicated, block: B:62:0x02d1  */
        /* JADX WARN: Code duplicated, block: B:66:0x032d  */
        /* JADX WARN: Code duplicated, block: B:72:0x0322 A[SYNTHETIC] */
        /* JADX WARN: Code restructure failed: missing block: B:38:0x0178, code lost:
        
            if (r1.jobSucceeded(r5, r27) == r8) goto L64;
         */
        /* JADX WARN: Code restructure failed: missing block: B:52:0x02b5, code lost:
        
            if (r0.waitForChildren(r1, r27) == r8) goto L64;
         */
        /* JADX WARN: Code restructure failed: missing block: B:63:0x0320, code lost:
        
            if (r3.jobFailed(r0, com.box.android.domain.jobs.JobType.DOWNLOAD_FOLDER, r2, r27) == r8) goto L64;
         */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final java.lang.Object invokeSuspend(java.lang.Object r28) {
            /*
                Method dump skipped, instruction units count: 828
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: com.box.android.data.jobs.DownloadFolderJob.AnonymousClass2.invokeSuspend(java.lang.Object):java.lang.Object");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final JobRequest getDownloadJobRequestForItem(ItemModel itemModel, File targetFolder) {
        if (itemModel instanceof FileModel) {
            DownloadFileJob.Companion companion = DownloadFileJob.INSTANCE;
            ItemId.Remote itemIdRemoteId = ItemModelKt.toItemIdRemoteId(itemModel);
            FileModel fileModel = (FileModel) itemModel;
            String name = fileModel.getName();
            String sha1 = fileModel.getSha1();
            String path = targetFolder.getPath();
            Intrinsics.checkNotNullExpressionValue(path, "getPath(...)");
            return companion.getRequest(itemIdRemoteId, name, sha1, path, SetsKt.setOf("job_source:" + JobTags.JobSource.DOWNLOAD_FOLDER), false, false);
        }
        if (!(itemModel instanceof FolderModel)) {
            return null;
        }
        Companion companion2 = INSTANCE;
        ItemId.Remote itemIdRemoteId2 = ItemModelKt.toItemIdRemoteId(itemModel);
        String name2 = ((FolderModel) itemModel).getName();
        String path2 = targetFolder.getPath();
        Intrinsics.checkNotNullExpressionValue(path2, "getPath(...)");
        return companion2.getRequest(itemIdRemoteId2, name2, path2, false);
    }

    public final DownloadFolderSessionInfo getDownloadFolderSessionInfo(byte[] byteArray) throws IOException {
        Intrinsics.checkNotNullParameter(byteArray, "byteArray");
        DownloadFolderSessionInfo downloadFolderSessionInfoFromJson = getSessionInfoAdapter().fromJson(new String(byteArray, Charsets.UTF_8));
        Intrinsics.checkNotNull(downloadFolderSessionInfoFromJson);
        return downloadFolderSessionInfoFromJson;
    }

    public final byte[] getSessionInfoByteArray(DownloadFolderSessionInfo downloadFolderSessionInfo) {
        Intrinsics.checkNotNullParameter(downloadFolderSessionInfo, "downloadFolderSessionInfo");
        String json = getSessionInfoAdapter().toJson(downloadFolderSessionInfo);
        Intrinsics.checkNotNull(json);
        byte[] bytes = json.getBytes(Charsets.UTF_8);
        Intrinsics.checkNotNullExpressionValue(bytes, "getBytes(...)");
        return bytes;
    }

    public final Result<File, DomainError> getTargetFolderOnDevice() {
        String string = this.inputData.getString(TARGET_DEST_FOLDER_PARAM);
        Intrinsics.checkNotNull(string);
        File file = new File(string);
        if (!file.exists() && !file.mkdirs()) {
            File parentFile = file.getParentFile();
            if (parentFile != null && !parentFile.exists()) {
                BoxLogUtils.d(ExtensionsKt.getTAG(this), "Target folder does not exist: " + file.getPath());
                return new Result.Error(new DownloadFileDomainError.TargetLocationNotFound(null, 1, null));
            }
            BoxLogUtils.d(ExtensionsKt.getTAG(this), "Failed to create target folder: " + file.getPath());
            return new Result.Error(new DownloadFileDomainError.TargetFileCreationError(null, 1, null));
        }
        String string2 = this.inputData.getString(FOLDER_NAME_PARAM);
        Intrinsics.checkNotNull(string2);
        File file2 = new File(file, string2);
        if (!file2.exists() && !file2.mkdirs()) {
            return new Result.Error(new DownloadFileDomainError.TargetFileCreationError("Failed to create folder: " + file2.getPath()));
        }
        return new Result.Success(file2);
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
    public boolean shouldDisplay() {
        return this.inputData.getBoolean(JobConstants.SHOULD_DISPLAY_JOB, true);
    }

    @Override // com.box.android.domain.models.DisplayableJob
    public IJobDisplayInfoProvider getJobDisplayInfoProvider() {
        String string = this.inputData.getString("FileIdParam");
        Intrinsics.checkNotNull(string);
        String string2 = this.inputData.getString(FOLDER_NAME_PARAM);
        Intrinsics.checkNotNull(string2);
        return new DownloadFolderJobDisplayInfoProvider(string, string2, this.itemService);
    }
}
