package com.box.android.domain.usecases.capture;

import com.box.android.data.jobs.JobWorker;
import com.box.android.domain.jobs.JobId;
import com.box.android.domain.mappers.FileModelMapper;
import com.box.android.domain.models.CaptureHistoryModel;
import com.box.android.domain.models.DomainError;
import com.box.android.domain.models.ItemId;
import com.box.android.domain.models.JobInfo;
import com.box.android.domain.models.item.FileModel;
import com.box.android.domain.models.item.FolderModel;
import com.box.android.domain.models.item.ItemModelKt;
import com.box.android.domain.services.ICaptureHistoryFilesService;
import com.box.android.domain.services.IJobService;
import com.box.android.domain.services.ILocalItemService;
import com.box.android.domain.services.IdMappingService;
import com.box.android.domain.utils.result.Result;
import com.box.androidsdk.content.BoxCache;
import com.box.androidsdk.content.models.BoxFile;
import com.box.androidsdk.content.models.BoxFolder;
import com.box.androidsdk.content.models.BoxItem;
import com.box.androidsdk.content.utils.BoxLogUtils;
import com.box.brownfieldApi.featuresNavigator.activities.ReactNativeFeatureActivity;
import external.sdk.pendo.io.mozilla.javascript.Token;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.FlowKt;

/* JADX INFO: compiled from: CaptureHistoryInteractor.kt */
/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000x\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001B1\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b¢\u0006\u0004\b\f\u0010\rJ:\u0010\u0012\u001a,\u0012(\u0012&\u0012\u001c\u0012\u001a\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00110\u0016\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00110\u00160\u0015\u0012\u0004\u0012\u00020\u00170\u00140\u00132\u0006\u0010\u0018\u001a\u00020\u0019H\u0016J\u001e\u0010\u001a\u001a\u0004\u0018\u00010\u001b2\f\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u001d0\u0016H\u0082@¢\u0006\u0002\u0010\u001eJ\u0016\u0010\u001f\u001a\u0004\u0018\u00010 *\u00020\u00072\u0006\u0010!\u001a\u00020\u001dH\u0002J\u0016\u0010\"\u001a\u00020#2\u0006\u0010$\u001a\u00020%H\u0096@¢\u0006\u0002\u0010&J\u0016\u0010'\u001a\u00020#2\u0006\u0010(\u001a\u00020\u0010H\u0096@¢\u0006\u0002\u0010)J&\u0010*\u001a\u00020#2\u0006\u0010$\u001a\u00020%2\u0006\u0010!\u001a\u00020\u00102\u0006\u0010(\u001a\u00020\u0010H\u0096@¢\u0006\u0002\u0010+R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u00110\u000fX\u0082.¢\u0006\u0002\n\u0000¨\u0006,"}, d2 = {"Lcom/box/android/domain/usecases/capture/CaptureHistoryInteractor;", "Lcom/box/android/domain/usecases/capture/CaptureHistoryUseCase;", "captureHistoryFilesService", "Lcom/box/android/domain/services/ICaptureHistoryFilesService;", "localItemService", "Lcom/box/android/domain/services/ILocalItemService;", "boxCache", "Lcom/box/androidsdk/content/BoxCache;", "jobService", "Lcom/box/android/domain/services/IJobService;", "idMappingService", "Lcom/box/android/domain/services/IdMappingService;", "<init>", "(Lcom/box/android/domain/services/ICaptureHistoryFilesService;Lcom/box/android/domain/services/ILocalItemService;Lcom/box/androidsdk/content/BoxCache;Lcom/box/android/domain/services/IJobService;Lcom/box/android/domain/services/IdMappingService;)V", "localIdToPendingModel", "", "Lcom/box/android/domain/models/ItemId;", "Lcom/box/android/domain/models/CaptureHistoryModel;", "getHistoricalCaptures", "Lkotlinx/coroutines/flow/Flow;", "Lcom/box/android/domain/utils/result/Result;", "Lkotlin/Pair;", "", "Lcom/box/android/domain/models/DomainError;", "preventSuccessFromMoving", "", "getJobInfoForTag", "Lcom/box/android/domain/models/JobInfo;", "tags", "", "(Ljava/util/List;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getFileModel", "Lcom/box/android/domain/models/item/FileModel;", "itemId", "retryJob", "", JobWorker.JOB_ID_PARAM, "Lcom/box/android/domain/jobs/JobId;", "(Lcom/box/android/domain/jobs/JobId;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "changeParentFolderForNonRunningJobsAndRetry", "newParentFolderId", "(Lcom/box/android/domain/models/ItemId;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "changeParentFolderOfJobAndRetry", "(Lcom/box/android/domain/jobs/JobId;Lcom/box/android/domain/models/ItemId;Lcom/box/android/domain/models/ItemId;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "domain_prodRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class CaptureHistoryInteractor implements CaptureHistoryUseCase {
    private final BoxCache boxCache;
    private final ICaptureHistoryFilesService captureHistoryFilesService;
    private final IdMappingService idMappingService;
    private final IJobService jobService;
    private Map<ItemId, CaptureHistoryModel> localIdToPendingModel;
    private final ILocalItemService localItemService;

    /* JADX INFO: renamed from: com.box.android.domain.usecases.capture.CaptureHistoryInteractor$changeParentFolderForNonRunningJobsAndRetry$1, reason: invalid class name */
    /* JADX INFO: compiled from: CaptureHistoryInteractor.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.box.android.domain.usecases.capture.CaptureHistoryInteractor", f = "CaptureHistoryInteractor.kt", i = {0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2}, l = {Token.LOCAL_BLOCK, Token.XML, Token.GET}, m = "changeParentFolderForNonRunningJobsAndRetry", n = {"newParentFolderId", "newParentFolderId", "it", "$this$filter$iv", "$this$filterTo$iv$iv", "destination$iv$iv", "element$iv$iv", "captureHistoryModel", "$i$a$-let-CaptureHistoryInteractor$changeParentFolderForNonRunningJobsAndRetry$2", "$i$f$filter", "$i$f$filterTo", "$i$a$-filter-CaptureHistoryInteractor$changeParentFolderForNonRunningJobsAndRetry$2$jobIdsToLocalIds$1", "newParentFolderId", "it", "$this$forEach$iv", "element$iv", JobWorker.JOB_ID_PARAM, "localId", "jobIdsToLocalIds", "$i$a$-let-CaptureHistoryInteractor$changeParentFolderForNonRunningJobsAndRetry$2", "$i$f$forEach", "$i$a$-forEach-CaptureHistoryInteractor$changeParentFolderForNonRunningJobsAndRetry$2$1"}, s = {"L$0", "L$0", "L$1", "L$2", "L$3", "L$4", "L$6", "L$7", "I$0", "I$1", "I$2", "I$3", "L$0", "L$1", "L$2", "L$4", "L$5", "L$6", "L$7", "I$0", "I$1", "I$2"}, v = 1)
    static final class AnonymousClass1 extends ContinuationImpl {
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
            return CaptureHistoryInteractor.this.changeParentFolderForNonRunningJobsAndRetry(null, this);
        }
    }

    /* JADX INFO: renamed from: com.box.android.domain.usecases.capture.CaptureHistoryInteractor$changeParentFolderOfJobAndRetry$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: CaptureHistoryInteractor.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.box.android.domain.usecases.capture.CaptureHistoryInteractor", f = "CaptureHistoryInteractor.kt", i = {0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 3, 3, 3, 3, 3, 3, 3, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5}, l = {Token.COMMENT, Token.METHOD, 169, 176, 179, 180}, m = "changeParentFolderOfJobAndRetry", n = {JobWorker.JOB_ID_PARAM, "itemId", "newParentFolderId", JobWorker.JOB_ID_PARAM, "itemId", "newParentFolderId", "$this$onSuccess$iv", "localItem", "$i$f$onSuccess", "$i$a$-onSuccess-CaptureHistoryInteractor$changeParentFolderOfJobAndRetry$2", JobWorker.JOB_ID_PARAM, "itemId", "newParentFolderId", "$this$onSuccess$iv", "localItem", "$this$onSuccess$iv", "jobInfos", "$this$forEach$iv", "element$iv", "it", "$i$f$onSuccess", "$i$a$-onSuccess-CaptureHistoryInteractor$changeParentFolderOfJobAndRetry$2", "$i$f$onSuccess", "$i$a$-onSuccess-CaptureHistoryInteractor$changeParentFolderOfJobAndRetry$2$1", "$i$f$forEach", "$i$a$-forEach-CaptureHistoryInteractor$changeParentFolderOfJobAndRetry$2$1$1", JobWorker.JOB_ID_PARAM, "itemId", "newParentFolderId", "$this$onSuccess$iv", "localItem", "$i$f$onSuccess", "$i$a$-onSuccess-CaptureHistoryInteractor$changeParentFolderOfJobAndRetry$2", JobWorker.JOB_ID_PARAM, "itemId", "newParentFolderId", "$this$onSuccess$iv", "localItem", "$this$onSuccess$iv", "it", "it", "$i$f$onSuccess", "$i$a$-onSuccess-CaptureHistoryInteractor$changeParentFolderOfJobAndRetry$2", "$i$f$onSuccess", "$i$a$-onSuccess-CaptureHistoryInteractor$changeParentFolderOfJobAndRetry$2$3", "$i$a$-let-CaptureHistoryInteractor$changeParentFolderOfJobAndRetry$2$3$1", JobWorker.JOB_ID_PARAM, "itemId", "newParentFolderId", "$this$onSuccess$iv", "localItem", "$this$onSuccess$iv", "it", "it", "$this$onSuccess$iv", "it", "$i$f$onSuccess", "$i$a$-onSuccess-CaptureHistoryInteractor$changeParentFolderOfJobAndRetry$2", "$i$f$onSuccess", "$i$a$-onSuccess-CaptureHistoryInteractor$changeParentFolderOfJobAndRetry$2$3", "$i$a$-let-CaptureHistoryInteractor$changeParentFolderOfJobAndRetry$2$3$1", "$i$f$onSuccess", "$i$a$-onSuccess-CaptureHistoryInteractor$changeParentFolderOfJobAndRetry$2$3$1$1"}, s = {"L$0", "L$1", "L$2", "L$0", "L$1", "L$2", "L$3", "L$4", "I$0", "I$1", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$9", "L$10", "I$0", "I$1", "I$2", "I$3", "I$4", "I$5", "L$0", "L$1", "L$2", "L$3", "L$4", "I$0", "I$1", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "I$0", "I$1", "I$2", "I$3", "I$4", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$8", "L$9", "I$0", "I$1", "I$2", "I$3", "I$4", "I$5", "I$6"}, v = 1)
    static final class C16261 extends ContinuationImpl {
        int I$0;
        int I$1;
        int I$2;
        int I$3;
        int I$4;
        int I$5;
        int I$6;
        Object L$0;
        Object L$1;
        Object L$10;
        Object L$2;
        Object L$3;
        Object L$4;
        Object L$5;
        Object L$6;
        Object L$7;
        Object L$8;
        Object L$9;
        int label;
        /* synthetic */ Object result;

        C16261(Continuation<? super C16261> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return CaptureHistoryInteractor.this.changeParentFolderOfJobAndRetry(null, null, null, this);
        }
    }

    /* JADX INFO: renamed from: com.box.android.domain.usecases.capture.CaptureHistoryInteractor$getJobInfoForTag$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: CaptureHistoryInteractor.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.box.android.domain.usecases.capture.CaptureHistoryInteractor", f = "CaptureHistoryInteractor.kt", i = {0}, l = {113}, m = "getJobInfoForTag", n = {"tags"}, s = {"L$0"}, v = 1)
    static final class C16271 extends ContinuationImpl {
        Object L$0;
        int label;
        /* synthetic */ Object result;

        C16271(Continuation<? super C16271> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return CaptureHistoryInteractor.this.getJobInfoForTag(null, this);
        }
    }

    @Inject
    public CaptureHistoryInteractor(ICaptureHistoryFilesService captureHistoryFilesService, ILocalItemService localItemService, BoxCache boxCache, IJobService jobService, IdMappingService idMappingService) {
        Intrinsics.checkNotNullParameter(captureHistoryFilesService, "captureHistoryFilesService");
        Intrinsics.checkNotNullParameter(localItemService, "localItemService");
        Intrinsics.checkNotNullParameter(boxCache, "boxCache");
        Intrinsics.checkNotNullParameter(jobService, "jobService");
        Intrinsics.checkNotNullParameter(idMappingService, "idMappingService");
        this.captureHistoryFilesService = captureHistoryFilesService;
        this.localItemService = localItemService;
        this.boxCache = boxCache;
        this.jobService = jobService;
        this.idMappingService = idMappingService;
    }

    @Override // com.box.android.domain.usecases.capture.CaptureHistoryUseCase
    public Flow<Result<Pair<List<CaptureHistoryModel>, List<CaptureHistoryModel>>, DomainError>> getHistoricalCaptures(boolean preventSuccessFromMoving) {
        if (!preventSuccessFromMoving) {
            this.localIdToPendingModel = new HashMap();
        }
        final Flow<Result<List<ItemId>, DomainError>> historicalCaptures = this.captureHistoryFilesService.getHistoricalCaptures();
        return FlowKt.m16356catch(new Flow<Result<? extends Pair<? extends List<CaptureHistoryModel>, ? extends List<CaptureHistoryModel>>, ? extends DomainError>>() { // from class: com.box.android.domain.usecases.capture.CaptureHistoryInteractor$getHistoricalCaptures$$inlined$map$1

            /* JADX INFO: renamed from: com.box.android.domain.usecases.capture.CaptureHistoryInteractor$getHistoricalCaptures$$inlined$map$1$2, reason: invalid class name */
            /* JADX INFO: compiled from: Emitters.kt */
            @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
            public static final class AnonymousClass2<T> implements FlowCollector {
                final /* synthetic */ FlowCollector $this_unsafeFlow;
                final /* synthetic */ CaptureHistoryInteractor this$0;

                /* JADX INFO: renamed from: com.box.android.domain.usecases.capture.CaptureHistoryInteractor$getHistoricalCaptures$$inlined$map$1$2$1, reason: invalid class name */
                @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
                @DebugMetadata(c = "com.box.android.domain.usecases.capture.CaptureHistoryInteractor$getHistoricalCaptures$$inlined$map$1$2", f = "CaptureHistoryInteractor.kt", i = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 5, 5, 5, 5, 5}, l = {58, 74, 94, 104, 110, 50}, m = "emit", n = {"value", "$completion", "value", "$this$map_u24lambda_u245", "$completion", ReactNativeFeatureActivity.RESULT_EXTRA_KEY, "$this$flatMap$iv", "it", "uploadedModels", "pendingModels", "$this$forEach$iv", "element$iv", "itemId", "$i$a$-unsafeTransform-FlowKt__TransformKt$map$1", "$i$a$-map-CaptureHistoryInteractor$getHistoricalCaptures$1", "$i$f$flatMap", "$i$a$-flatMap-CaptureHistoryInteractor$getHistoricalCaptures$1$1", "$i$f$forEach", "$i$a$-forEach-CaptureHistoryInteractor$getHistoricalCaptures$1$1$1", "value", "$completion", "value", "$this$map_u24lambda_u245", "$completion", ReactNativeFeatureActivity.RESULT_EXTRA_KEY, "$this$flatMap$iv", "it", "uploadedModels", "pendingModels", "$this$forEach$iv", "element$iv", "itemId", "$this$onSuccess$iv", "fileId", "fileModel", "$i$a$-unsafeTransform-FlowKt__TransformKt$map$1", "$i$a$-map-CaptureHistoryInteractor$getHistoricalCaptures$1", "$i$f$flatMap", "$i$a$-flatMap-CaptureHistoryInteractor$getHistoricalCaptures$1$1", "$i$f$forEach", "$i$a$-forEach-CaptureHistoryInteractor$getHistoricalCaptures$1$1$1", "$i$f$onSuccess", "$i$a$-onSuccess-CaptureHistoryInteractor$getHistoricalCaptures$1$1$1$1", "$i$a$-let-CaptureHistoryInteractor$getHistoricalCaptures$1$1$1$1$1", "value", "$completion", "value", "$this$map_u24lambda_u245", "$completion", ReactNativeFeatureActivity.RESULT_EXTRA_KEY, "$this$flatMap$iv", "it", "uploadedModels", "pendingModels", "$this$forEach$iv", "element$iv", "itemId", "$this$onError$iv", "it", "$i$a$-unsafeTransform-FlowKt__TransformKt$map$1", "$i$a$-map-CaptureHistoryInteractor$getHistoricalCaptures$1", "$i$f$flatMap", "$i$a$-flatMap-CaptureHistoryInteractor$getHistoricalCaptures$1$1", "$i$f$forEach", "$i$a$-forEach-CaptureHistoryInteractor$getHistoricalCaptures$1$1$1", "$i$f$onError", "$i$a$-onError-CaptureHistoryInteractor$getHistoricalCaptures$1$1$1$2", "value", "$completion", "value", "$this$map_u24lambda_u245", "$completion", ReactNativeFeatureActivity.RESULT_EXTRA_KEY, "$this$flatMap$iv", "it", "uploadedModels", "pendingModels", "$this$forEach$iv", "element$iv", "itemId", "$this$onError$iv", "it", "$this$onSuccess$iv", "itemModel", "tags", "$i$a$-unsafeTransform-FlowKt__TransformKt$map$1", "$i$a$-map-CaptureHistoryInteractor$getHistoricalCaptures$1", "$i$f$flatMap", "$i$a$-flatMap-CaptureHistoryInteractor$getHistoricalCaptures$1$1", "$i$f$forEach", "$i$a$-forEach-CaptureHistoryInteractor$getHistoricalCaptures$1$1$1", "$i$f$onError", "$i$a$-onError-CaptureHistoryInteractor$getHistoricalCaptures$1$1$1$2", "$i$f$onSuccess", "$i$a$-onSuccess-CaptureHistoryInteractor$getHistoricalCaptures$1$1$1$2$1", "value", "$completion", "value", "$this$map_u24lambda_u245", "$completion", ReactNativeFeatureActivity.RESULT_EXTRA_KEY, "$this$flatMap$iv", "it", "uploadedModels", "pendingModels", "$this$forEach$iv", "element$iv", "itemId", "$this$onError$iv", "it", "$this$onSuccess$iv", "itemModel", "tags", "jobInfo", "it", "$i$a$-unsafeTransform-FlowKt__TransformKt$map$1", "$i$a$-map-CaptureHistoryInteractor$getHistoricalCaptures$1", "$i$f$flatMap", "$i$a$-flatMap-CaptureHistoryInteractor$getHistoricalCaptures$1$1", "$i$f$forEach", "$i$a$-forEach-CaptureHistoryInteractor$getHistoricalCaptures$1$1$1", "$i$f$onError", "$i$a$-onError-CaptureHistoryInteractor$getHistoricalCaptures$1$1$1$2", "$i$f$onSuccess", "$i$a$-onSuccess-CaptureHistoryInteractor$getHistoricalCaptures$1$1$1$2$1", "$i$a$-let-CaptureHistoryInteractor$getHistoricalCaptures$1$1$1$2$1$1", "value", "$completion", "value", "$this$map_u24lambda_u245", "$i$a$-unsafeTransform-FlowKt__TransformKt$map$1"}, s = {"L$0", "L$1", "L$2", "L$3", "L$5", "L$6", "L$7", "L$8", "L$9", "L$10", "L$11", "L$13", "L$14", "I$0", "I$1", "I$2", "I$3", "I$4", "I$5", "L$0", "L$1", "L$2", "L$3", "L$5", "L$6", "L$7", "L$8", "L$9", "L$10", "L$11", "L$13", "L$14", "L$15", "L$16", "L$17", "I$0", "I$1", "I$2", "I$3", "I$4", "I$5", "I$6", "I$7", "I$8", "L$0", "L$1", "L$2", "L$3", "L$5", "L$6", "L$7", "L$8", "L$9", "L$10", "L$11", "L$13", "L$14", "L$15", "L$16", "I$0", "I$1", "I$2", "I$3", "I$4", "I$5", "I$6", "I$7", "L$0", "L$1", "L$2", "L$3", "L$5", "L$6", "L$7", "L$8", "L$9", "L$10", "L$11", "L$13", "L$14", "L$15", "L$16", "L$17", "L$18", "L$19", "I$0", "I$1", "I$2", "I$3", "I$4", "I$5", "I$6", "I$7", "I$8", "I$9", "L$0", "L$1", "L$2", "L$3", "L$5", "L$6", "L$7", "L$8", "L$9", "L$10", "L$11", "L$13", "L$14", "L$15", "L$16", "L$17", "L$18", "L$19", "L$20", "L$21", "I$0", "I$1", "I$2", "I$3", "I$4", "I$5", "I$6", "I$7", "I$8", "I$9", "I$10", "L$0", "L$1", "L$2", "L$3", "I$0"}, v = 1)
                public static final class AnonymousClass1 extends ContinuationImpl {
                    int I$0;
                    int I$1;
                    int I$10;
                    int I$2;
                    int I$3;
                    int I$4;
                    int I$5;
                    int I$6;
                    int I$7;
                    int I$8;
                    int I$9;
                    Object L$0;
                    Object L$1;
                    Object L$10;
                    Object L$11;
                    Object L$12;
                    Object L$13;
                    Object L$14;
                    Object L$15;
                    Object L$16;
                    Object L$17;
                    Object L$18;
                    Object L$19;
                    Object L$2;
                    Object L$20;
                    Object L$21;
                    Object L$22;
                    Object L$23;
                    Object L$3;
                    Object L$4;
                    Object L$5;
                    Object L$6;
                    Object L$7;
                    Object L$8;
                    Object L$9;
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

                public AnonymousClass2(FlowCollector flowCollector, CaptureHistoryInteractor captureHistoryInteractor) {
                    this.$this_unsafeFlow = flowCollector;
                    this.this$0 = captureHistoryInteractor;
                }

                /* JADX WARN: Code duplicated, block: B:123:? A[RETURN, SYNTHETIC] */
                /* JADX WARN: Code duplicated, block: B:24:0x03c2  */
                /* JADX WARN: Code duplicated, block: B:26:0x0449  */
                /* JADX WARN: Code duplicated, block: B:27:0x044c  */
                /* JADX WARN: Code duplicated, block: B:30:0x0465  */
                /* JADX WARN: Code duplicated, block: B:41:0x04a7  */
                /* JADX WARN: Code duplicated, block: B:43:0x04bb  */
                /* JADX WARN: Code duplicated, block: B:46:0x054f  */
                /* JADX WARN: Code duplicated, block: B:58:0x05bf  */
                /* JADX WARN: Code duplicated, block: B:60:0x05c3  */
                /* JADX WARN: Code duplicated, block: B:63:0x0649  */
                /* JADX WARN: Code duplicated, block: B:66:0x066c  */
                /* JADX WARN: Code duplicated, block: B:69:0x071b  */
                /* JADX WARN: Code duplicated, block: B:72:0x0746  */
                /* JADX WARN: Code duplicated, block: B:74:0x07f7  */
                /* JADX WARN: Code duplicated, block: B:75:0x07fa  */
                /* JADX WARN: Code duplicated, block: B:78:0x082b  */
                /* JADX WARN: Code duplicated, block: B:7:0x0018  */
                /* JADX WARN: Code duplicated, block: B:80:0x0833  */
                /* JADX WARN: Code duplicated, block: B:83:0x083d  */
                /* JADX WARN: Code duplicated, block: B:85:0x0845  */
                /* JADX WARN: Code duplicated, block: B:88:0x0860  */
                /* JADX WARN: Code duplicated, block: B:90:0x0876  */
                /* JADX WARN: Code duplicated, block: B:92:0x0882  */
                /* JADX WARN: Code duplicated, block: B:95:0x08ac  */
                /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:57:0x05a5 -> B:94:0x089d). Please report as a decompilation issue!!! */
                /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:75:0x07fa -> B:76:0x0814). Please report as a decompilation issue!!! */
                /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:88:0x0860 -> B:89:0x086a). Please report as a decompilation issue!!! */
                /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:92:0x0882 -> B:93:0x0889). Please report as a decompilation issue!!! */
                /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
                    jadx.core.utils.exceptions.JadxOverflowException: Regions stack size limit reached
                    	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
                    	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
                    	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
                    */
                @Override // kotlinx.coroutines.flow.FlowCollector
                public final java.lang.Object emit(java.lang.Object r38, kotlin.coroutines.Continuation r39) {
                    /*
                        Method dump skipped, instruction units count: 2436
                        To view this dump add '--comments-level debug' option
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.box.android.domain.usecases.capture.CaptureHistoryInteractor$getHistoricalCaptures$$inlined$map$1.AnonymousClass2.emit(java.lang.Object, kotlin.coroutines.Continuation):java.lang.Object");
                }
            }

            @Override // kotlinx.coroutines.flow.Flow
            public Object collect(FlowCollector<? super Result<? extends Pair<? extends List<CaptureHistoryModel>, ? extends List<CaptureHistoryModel>>, ? extends DomainError>> flowCollector, Continuation continuation) {
                Object objCollect = historicalCaptures.collect(new AnonymousClass2(flowCollector, this), continuation);
                return objCollect == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objCollect : Unit.INSTANCE;
            }
        }, new AnonymousClass2(null));
    }

    /* JADX INFO: renamed from: com.box.android.domain.usecases.capture.CaptureHistoryInteractor$getHistoricalCaptures$2, reason: invalid class name */
    /* JADX INFO: compiled from: CaptureHistoryInteractor.kt */
    @Metadata(d1 = {"\u0000$\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0003\u0010\u0000\u001a\u00020\u0001*,\u0012(\u0012&\u0012\u001c\u0012\u001a\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u00050\u0004\u0012\u0004\u0012\u00020\u00070\u00030\u00022\u0006\u0010\b\u001a\u00020\tH\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/flow/FlowCollector;", "Lcom/box/android/domain/utils/result/Result;", "Lkotlin/Pair;", "", "Lcom/box/android/domain/models/CaptureHistoryModel;", "Lcom/box/android/domain/models/DomainError;", "it", ""}, k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.box.android.domain.usecases.capture.CaptureHistoryInteractor$getHistoricalCaptures$2", f = "CaptureHistoryInteractor.kt", i = {0, 0}, l = {109}, m = "invokeSuspend", n = {"$this$catch", "it"}, s = {"L$0", "L$1"}, v = 1)
    static final class AnonymousClass2 extends SuspendLambda implements Function3<FlowCollector<? super Result<? extends Pair<? extends List<CaptureHistoryModel>, ? extends List<CaptureHistoryModel>>, ? extends DomainError>>, Throwable, Continuation<? super Unit>, Object> {
        private /* synthetic */ Object L$0;
        /* synthetic */ Object L$1;
        int label;

        AnonymousClass2(Continuation<? super AnonymousClass2> continuation) {
            super(3, continuation);
        }

        @Override // kotlin.jvm.functions.Function3
        public final Object invoke(FlowCollector<? super Result<? extends Pair<? extends List<CaptureHistoryModel>, ? extends List<CaptureHistoryModel>>, ? extends DomainError>> flowCollector, Throwable th, Continuation<? super Unit> continuation) {
            AnonymousClass2 anonymousClass2 = new AnonymousClass2(continuation);
            anonymousClass2.L$0 = flowCollector;
            anonymousClass2.L$1 = th;
            return anonymousClass2.invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            FlowCollector flowCollector = (FlowCollector) this.L$0;
            Throwable th = (Throwable) this.L$1;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                BoxLogUtils.e("Error mapping capture history: " + th);
                this.L$0 = SpillingKt.nullOutSpilledVariable(flowCollector);
                this.L$1 = SpillingKt.nullOutSpilledVariable(th);
                this.label = 1;
                if (flowCollector.emit(new Result.Error(new DomainError.CacheReadError(null, 1, null)), this) == coroutine_suspended) {
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

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    public final Object getJobInfoForTag(List<String> list, Continuation<? super JobInfo> continuation) {
        C16271 c16271;
        if (continuation instanceof C16271) {
            c16271 = (C16271) continuation;
            if ((c16271.label & Integer.MIN_VALUE) != 0) {
                c16271.label -= Integer.MIN_VALUE;
            } else {
                c16271 = new C16271(continuation);
            }
        } else {
            c16271 = new C16271(continuation);
        }
        Object jobInfos = c16271.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = c16271.label;
        if (i == 0) {
            ResultKt.throwOnFailure(jobInfos);
            IJobService iJobService = this.jobService;
            c16271.L$0 = SpillingKt.nullOutSpilledVariable(list);
            c16271.label = 1;
            jobInfos = iJobService.getJobInfos(list, c16271);
            if (jobInfos == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(jobInfos);
        }
        List list2 = (List) com.box.android.domain.utils.result.ResultKt.getOrNull((Result) jobInfos);
        if (list2 != null) {
            return (JobInfo) CollectionsKt.firstOrNull(list2);
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final FileModel getFileModel(BoxCache boxCache, String str) throws SQLException {
        BoxItem item = boxCache.getItem(str, "FILE");
        BoxFile boxFile = item instanceof BoxFile ? (BoxFile) item : null;
        FileModel fileModel$default = boxFile != null ? FileModelMapper.toFileModel$default(FileModelMapper.INSTANCE, boxFile, false, 1, null) : null;
        if (fileModel$default == null) {
            return null;
        }
        BoxCache boxCache2 = this.boxCache;
        FolderModel parentFolder = fileModel$default.getParentFolder();
        Intrinsics.checkNotNull(parentFolder);
        BoxItem item2 = boxCache2.getItem(ItemModelKt.toItemIdRemoteId(parentFolder).getBoxId(), "FOLDER");
        BoxFolder boxFolder = item2 instanceof BoxFolder ? (BoxFolder) item2 : null;
        if (boxFolder != null) {
            FolderModel parentFolder2 = fileModel$default.getParentFolder();
            FolderModel parentFolder3 = fileModel$default.getParentFolder();
            String name = boxFolder.getName();
            if (name == null) {
                name = parentFolder2.getName();
            }
            String str2 = name;
            Boolean hasCollaborations = boxFolder.getHasCollaborations();
            boolean zBooleanValue = hasCollaborations != null ? hasCollaborations.booleanValue() : parentFolder2.getHasCollaborations();
            Boolean isExternallyOwned = boxFolder.getIsExternallyOwned();
            FileModel fileModelCopy$default = FileModel.copy$default(fileModel$default, null, null, false, false, FolderModel.copy$default(parentFolder3, null, str2, zBooleanValue, isExternallyOwned != null ? isExternallyOwned.booleanValue() : parentFolder2.isExternallyOwned(), null, null, null, null, null, null, null, false, null, null, null, null, null, null, null, 524273, null), null, null, null, null, null, null, false, 0L, null, null, null, null, null, null, null, null, null, null, null, null, null, null, 134217711, null);
            if (fileModelCopy$default != null) {
                return fileModelCopy$default;
            }
        }
        return fileModel$default;
    }

    @Override // com.box.android.domain.usecases.capture.CaptureHistoryUseCase
    public Object retryJob(JobId jobId, Continuation<? super Unit> continuation) {
        Object objRetryJob = this.jobService.retryJob(jobId, continuation);
        return objRetryJob == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objRetryJob : Unit.INSTANCE;
    }

    /* JADX WARN: Code duplicated, block: B:28:0x00e6  */
    /* JADX WARN: Code duplicated, block: B:35:0x0136  */
    /* JADX WARN: Code duplicated, block: B:38:0x0151 A[LOOP:1: B:36:0x014b->B:38:0x0151, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:42:0x0189  */
    /* JADX WARN: Code duplicated, block: B:53:0x01d4 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:55:? A[LOOP:0: B:40:0x0183->B:55:?, LOOP_END, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:7:0x0018  */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x00b1, code lost:
    
        if (r1 == r3) goto L44;
     */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x0128, code lost:
    
        if (r6 == r3) goto L44;
     */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:29:0x0128 -> B:31:0x012c). Please report as a decompilation issue!!! */
    @Override // com.box.android.domain.usecases.capture.CaptureHistoryUseCase
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.Object changeParentFolderForNonRunningJobsAndRetry(com.box.android.domain.models.ItemId r19, kotlin.coroutines.Continuation<? super kotlin.Unit> r20) {
        /*
            Method dump skipped, instruction units count: 483
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.box.android.domain.usecases.capture.CaptureHistoryInteractor.changeParentFolderForNonRunningJobsAndRetry(com.box.android.domain.models.ItemId, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARN: Code duplicated, block: B:37:0x01e9  */
    /* JADX WARN: Code duplicated, block: B:40:0x0241  */
    /* JADX WARN: Code duplicated, block: B:7:0x001a  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:40:0x0241 -> B:41:0x024c). Please report as a decompilation issue!!! */
    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions stack size limit reached
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        */
    @Override // com.box.android.domain.usecases.capture.CaptureHistoryUseCase
    public java.lang.Object changeParentFolderOfJobAndRetry(com.box.android.domain.jobs.JobId r22, com.box.android.domain.models.ItemId r23, com.box.android.domain.models.ItemId r24, kotlin.coroutines.Continuation<? super kotlin.Unit> r25) {
        /*
            Method dump skipped, instruction units count: 978
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.box.android.domain.usecases.capture.CaptureHistoryInteractor.changeParentFolderOfJobAndRetry(com.box.android.domain.jobs.JobId, com.box.android.domain.models.ItemId, com.box.android.domain.models.ItemId, kotlin.coroutines.Continuation):java.lang.Object");
    }
}
