package com.box.android.data.service.impl;

import androidx.media3.extractor.ts.PsExtractor;
import androidx.media3.extractor.ts.TsExtractor;
import com.box.android.common.utilities.BoxCommonConstants;
import com.box.android.coreservices.jobmanager.JobManager;
import com.box.android.coreservices.models.BoxModelOfflineManager;
import com.box.android.coreservices.models.BoxModelOfflineManagerWrapper;
import com.box.android.domain.configuration.DataPolicy;
import com.box.android.domain.configuration.FeatureFlips;
import com.box.android.domain.identity.IUserContextManager;
import com.box.android.domain.jobs.JobType;
import com.box.android.domain.mappers.ItemModelMapper;
import com.box.android.domain.models.DomainError;
import com.box.android.domain.models.ItemId;
import com.box.android.domain.models.JobInfo;
import com.box.android.domain.models.item.FileModel;
import com.box.android.domain.models.item.FolderModel;
import com.box.android.domain.models.item.ItemModel;
import com.box.android.domain.services.IJobManagerBridgeService;
import com.box.android.domain.services.IJobService;
import com.box.android.domain.services.ILocalItemService;
import com.box.android.domain.services.IOfflineService;
import com.box.android.domain.services.IRemoteItemService;
import com.box.android.domain.services.IdMappingService;
import com.box.android.domain.usecases.jobs.JobTags;
import com.box.android.domain.utils.ExtensionsKt;
import com.box.android.domain.utils.ItemSorter;
import com.box.android.domain.utils.result.Result;
import com.box.androidsdk.content.utils.BoxLogUtils;
import com.facebook.imageutils.JfifUtil;
import com.facebook.react.modules.dialog.AlertFragment;
import external.sdk.pendo.io.mozilla.javascript.Token;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Deferred;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.FlowKt;

/* JADX INFO: compiled from: OfflineService.kt */
/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000²\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001Bc\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\u0006\u0010\f\u001a\u00020\r\u0012\u0006\u0010\u000e\u001a\u00020\u000f\u0012\u0006\u0010\u0010\u001a\u00020\u0011\u0012\u0006\u0010\u0012\u001a\u00020\u0013\u0012\u0006\u0010\u0014\u001a\u00020\u0015\u0012\b\b\u0001\u0010\u0016\u001a\u00020\u0017¢\u0006\u0004\b\u0018\u0010\u0019J \u0010\u001a\u001a\u001a\u0012\u0016\u0012\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001e0\u001d\u0012\u0004\u0012\u00020\u001f0\u001c0\u001bH\u0016J \u0010 \u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001e0\u001d\u0012\u0004\u0012\u00020\u001f0\u001cH\u0096@¢\u0006\u0002\u0010!J.\u0010\"\u001a\u001a\u0012\n\u0012\b\u0012\u0004\u0012\u00020$0\u001d\u0012\n\u0012\b\u0012\u0004\u0012\u00020%0\u001d0#2\u0006\u0010&\u001a\u00020'H\u0082@¢\u0006\u0002\u0010(J(\u0010)\u001a\u000e\u0012\u0004\u0012\u00020*\u0012\u0004\u0012\u00020\u001f0\u001c2\f\u0010+\u001a\b\u0012\u0004\u0012\u00020\u001e0\u001dH\u0096@¢\u0006\u0002\u0010,J!\u0010-\u001a\u00020.2\u0012\u0010/\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u001e00\"\u00020\u001eH\u0016¢\u0006\u0002\u00101J8\u00102\u001a\u000e\u0012\u0004\u0012\u00020*\u0012\u0004\u0012\u00020\u001f0\u001c2\f\u0010+\u001a\b\u0012\u0004\u0012\u00020\u001e0\u001d2\u0006\u00103\u001a\u00020.2\u0006\u00104\u001a\u000205H\u0096@¢\u0006\u0002\u00106J(\u00107\u001a\u000e\u0012\u0004\u0012\u00020*\u0012\u0004\u0012\u00020\u001f0\u001c2\f\u0010+\u001a\b\u0012\u0004\u0012\u00020\u001e0\u001dH\u0096@¢\u0006\u0002\u0010,J\u0016\u00108\u001a\u00020*2\u0006\u00109\u001a\u00020$H\u0082@¢\u0006\u0002\u0010:J\u0016\u0010;\u001a\u00020*2\u0006\u0010<\u001a\u00020=H\u0082@¢\u0006\u0002\u0010>J\u0016\u0010?\u001a\u00020.2\u0006\u0010@\u001a\u00020%H\u0096@¢\u0006\u0002\u0010AJ\"\u0010B\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020C\u0012\u0004\u0012\u00020\u001f0\u001c0\u001b2\u0006\u0010<\u001a\u00020=H\u0016J\"\u0010D\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020C\u0012\u0004\u0012\u00020\u001f0\u001c0\u001b2\u0006\u0010E\u001a\u00020FH\u0002J\"\u0010G\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020C\u0012\u0004\u0012\u00020\u001f0\u001c0\u001b2\u0006\u0010E\u001a\u00020FH\u0002J\u001c\u0010H\u001a\u000e\u0012\u0004\u0012\u00020C\u0012\u0004\u0012\u00020\u001f0\u001c2\u0006\u0010I\u001a\u00020CH\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0015X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0017X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006J"}, d2 = {"Lcom/box/android/data/service/impl/OfflineService;", "Lcom/box/android/domain/services/IOfflineService;", "jobManager", "Lcom/box/android/coreservices/jobmanager/JobManager;", "jobManagerBridgeService", "Lcom/box/android/domain/services/IJobManagerBridgeService;", "itemIdMappingService", "Lcom/box/android/domain/services/IdMappingService;", "modelOfflineManagerWrapper", "Lcom/box/android/coreservices/models/BoxModelOfflineManagerWrapper;", "localItemService", "Lcom/box/android/domain/services/ILocalItemService;", "remoteItemService", "Lcom/box/android/domain/services/IRemoteItemService;", "userContextManager", "Lcom/box/android/domain/identity/IUserContextManager;", "jobService", "Lcom/box/android/domain/services/IJobService;", "featureFlips", "Lcom/box/android/domain/configuration/FeatureFlips;", "itemSorter", "Lcom/box/android/domain/utils/ItemSorter;", "ioDispatcher", "Lkotlinx/coroutines/CoroutineDispatcher;", "<init>", "(Lcom/box/android/coreservices/jobmanager/JobManager;Lcom/box/android/domain/services/IJobManagerBridgeService;Lcom/box/android/domain/services/IdMappingService;Lcom/box/android/coreservices/models/BoxModelOfflineManagerWrapper;Lcom/box/android/domain/services/ILocalItemService;Lcom/box/android/domain/services/IRemoteItemService;Lcom/box/android/domain/identity/IUserContextManager;Lcom/box/android/domain/services/IJobService;Lcom/box/android/domain/configuration/FeatureFlips;Lcom/box/android/domain/utils/ItemSorter;Lkotlinx/coroutines/CoroutineDispatcher;)V", "offlineItems", "Lkotlinx/coroutines/flow/Flow;", "Lcom/box/android/domain/utils/result/Result;", "", "Lcom/box/android/domain/models/item/ItemModel;", "Lcom/box/android/domain/models/DomainError;", "getOutdatedOfflineItems", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "fetchOfflineItems", "Lkotlin/Pair;", "Lcom/box/android/domain/models/item/FolderModel;", "Lcom/box/android/domain/models/item/FileModel;", "dataPolicy", "Lcom/box/android/domain/configuration/DataPolicy;", "(Lcom/box/android/domain/configuration/DataPolicy;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "syncOfflineItems", "", AlertFragment.ARG_ITEMS, "(Ljava/util/List;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "isSizeBigEnoughToSaveOnlyPreviews", "", "itemsToOffline", "", "([Lcom/box/android/domain/models/item/ItemModel;)Z", "makeAvailableOffline", "shouldSaveOriginal", "jobSource", "Lcom/box/android/domain/usecases/jobs/JobTags$JobSource;", "(Ljava/util/List;ZLcom/box/android/domain/usecases/jobs/JobTags$JobSource;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "removeFromOffline", "removeFolderFromOffline", "folder", "(Lcom/box/android/domain/models/item/FolderModel;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "tryCancelMarkForOfflineJob", "itemId", "Lcom/box/android/domain/models/ItemId;", "(Lcom/box/android/domain/models/ItemId;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "isFileOfflined", "fileModel", "(Lcom/box/android/domain/models/item/FileModel;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getStatusOfJob", "Lcom/box/android/domain/models/JobInfo$Status;", "getJobStatusFromJobService", "remoteId", "Lcom/box/android/domain/models/ItemId$Remote;", "getJobStatusFromJobManager", "mapStatusToResult", "status", "data_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class OfflineService implements IOfflineService {
    private final FeatureFlips featureFlips;
    private final CoroutineDispatcher ioDispatcher;
    private final IdMappingService itemIdMappingService;
    private final ItemSorter itemSorter;
    private final JobManager jobManager;
    private final IJobManagerBridgeService jobManagerBridgeService;
    private final IJobService jobService;
    private final ILocalItemService localItemService;
    private final BoxModelOfflineManagerWrapper modelOfflineManagerWrapper;
    private final IRemoteItemService remoteItemService;
    private final IUserContextManager userContextManager;

    /* JADX INFO: renamed from: com.box.android.data.service.impl.OfflineService$isFileOfflined$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: OfflineService.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.box.android.data.service.impl.OfflineService", f = "OfflineService.kt", i = {0}, l = {PsExtractor.VIDEO_STREAM_MASK}, m = "isFileOfflined", n = {"fileModel"}, s = {"L$0"}, v = 1)
    static final class C14771 extends ContinuationImpl {
        Object L$0;
        int label;
        /* synthetic */ Object result;

        C14771(Continuation<? super C14771> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return OfflineService.this.isFileOfflined(null, this);
        }
    }

    /* JADX INFO: renamed from: com.box.android.data.service.impl.OfflineService$removeFolderFromOffline$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: OfflineService.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.box.android.data.service.impl.OfflineService", f = "OfflineService.kt", i = {0, 1, 1, 1, 1, 2, 2, 2, 2, 3, 3, 3, 3, 3, 3, 4, 4, 4, 4, 4, 4, 5, 5, 5, 5, 5, 5, 6, 6, 6, 6, 6, 7, 7, 7, 7, 7}, l = {TsExtractor.TS_PACKET_SIZE, 195, 196, 207, BoxCommonConstants.REQUEST_DELETE, 213, 224, JfifUtil.MARKER_APP1}, m = "removeFolderFromOffline", n = {"folder", "folder", "foldersToProcess", "currentFolder", "remoteId", "folder", "foldersToProcess", "currentFolder", "remoteId", "folder", "foldersToProcess", "currentFolder", "remoteId", "itemsResult", "item", "folder", "foldersToProcess", "currentFolder", "remoteId", "itemsResult", "item", "folder", "foldersToProcess", "currentFolder", "remoteId", "itemsResult", "item", "folder", "foldersToProcess", "currentFolder", "remoteId", "itemsResult", "folder", "foldersToProcess", "currentFolder", "remoteId", "itemsResult"}, s = {"L$0", "L$0", "L$1", "L$2", "L$3", "L$0", "L$1", "L$2", "L$3", "L$0", "L$1", "L$2", "L$3", "L$4", "L$6", "L$0", "L$1", "L$2", "L$3", "L$4", "L$6", "L$0", "L$1", "L$2", "L$3", "L$4", "L$6", "L$0", "L$1", "L$2", "L$3", "L$4", "L$0", "L$1", "L$2", "L$3", "L$4"}, v = 1)
    static final class C14791 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        Object L$4;
        Object L$5;
        Object L$6;
        int label;
        /* synthetic */ Object result;

        C14791(Continuation<? super C14791> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return OfflineService.this.removeFolderFromOffline(null, this);
        }
    }

    /* JADX INFO: renamed from: com.box.android.data.service.impl.OfflineService$tryCancelMarkForOfflineJob$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: OfflineService.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.box.android.data.service.impl.OfflineService", f = "OfflineService.kt", i = {0, 0, 0}, l = {232}, m = "tryCancelMarkForOfflineJob", n = {"itemId", "remoteId", "$i$a$-let-OfflineService$tryCancelMarkForOfflineJob$2"}, s = {"L$0", "L$1", "I$0"}, v = 1)
    static final class C14811 extends ContinuationImpl {
        int I$0;
        Object L$0;
        Object L$1;
        int label;
        /* synthetic */ Object result;

        C14811(Continuation<? super C14811> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return OfflineService.this.tryCancelMarkForOfflineJob(null, this);
        }
    }

    @Inject
    public OfflineService(JobManager jobManager, IJobManagerBridgeService jobManagerBridgeService, IdMappingService itemIdMappingService, BoxModelOfflineManagerWrapper modelOfflineManagerWrapper, ILocalItemService localItemService, IRemoteItemService remoteItemService, IUserContextManager userContextManager, IJobService jobService, FeatureFlips featureFlips, ItemSorter itemSorter, CoroutineDispatcher ioDispatcher) {
        Intrinsics.checkNotNullParameter(jobManager, "jobManager");
        Intrinsics.checkNotNullParameter(jobManagerBridgeService, "jobManagerBridgeService");
        Intrinsics.checkNotNullParameter(itemIdMappingService, "itemIdMappingService");
        Intrinsics.checkNotNullParameter(modelOfflineManagerWrapper, "modelOfflineManagerWrapper");
        Intrinsics.checkNotNullParameter(localItemService, "localItemService");
        Intrinsics.checkNotNullParameter(remoteItemService, "remoteItemService");
        Intrinsics.checkNotNullParameter(userContextManager, "userContextManager");
        Intrinsics.checkNotNullParameter(jobService, "jobService");
        Intrinsics.checkNotNullParameter(featureFlips, "featureFlips");
        Intrinsics.checkNotNullParameter(itemSorter, "itemSorter");
        Intrinsics.checkNotNullParameter(ioDispatcher, "ioDispatcher");
        this.jobManager = jobManager;
        this.jobManagerBridgeService = jobManagerBridgeService;
        this.itemIdMappingService = itemIdMappingService;
        this.modelOfflineManagerWrapper = modelOfflineManagerWrapper;
        this.localItemService = localItemService;
        this.remoteItemService = remoteItemService;
        this.userContextManager = userContextManager;
        this.jobService = jobService;
        this.featureFlips = featureFlips;
        this.itemSorter = itemSorter;
        this.ioDispatcher = ioDispatcher;
    }

    /* JADX INFO: renamed from: com.box.android.data.service.impl.OfflineService$offlineItems$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: OfflineService.kt */
    @Metadata(d1 = {"\u0000\u001a\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u001a\u0012\u0016\u0012\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u0004\u0012\u0004\u0012\u00020\u00060\u00030\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/flow/FlowCollector;", "Lcom/box/android/domain/utils/result/Result;", "", "Lcom/box/android/domain/models/item/ItemModel;", "Lcom/box/android/domain/models/DomainError;"}, k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.box.android.data.service.impl.OfflineService$offlineItems$1", f = "OfflineService.kt", i = {0, 1, 1, 1, 2, 2}, l = {67, 68, 71}, m = "invokeSuspend", n = {"$this$flow", "$this$flow", "folders", "files", "$this$flow", "e"}, s = {"L$0", "L$0", "L$1", "L$2", "L$0", "L$1"}, v = 1)
    static final class C14781 extends SuspendLambda implements Function2<FlowCollector<? super Result<? extends List<? extends ItemModel>, ? extends DomainError>>, Continuation<? super Unit>, Object> {
        private /* synthetic */ Object L$0;
        Object L$1;
        Object L$2;
        int label;

        C14781(Continuation<? super C14781> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            C14781 c14781 = OfflineService.this.new C14781(continuation);
            c14781.L$0 = obj;
            return c14781;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(FlowCollector<? super Result<? extends List<? extends ItemModel>, ? extends DomainError>> flowCollector, Continuation<? super Unit> continuation) {
            return ((C14781) create(flowCollector, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Code restructure failed: missing block: B:21:0x008c, code lost:
        
            if (r0.emit(new com.box.android.domain.utils.result.Result.Success(r9.this$0.itemSorter.sort(kotlin.collections.CollectionsKt.plus((java.util.Collection) r2, (java.lang.Iterable) r10))), r9) == r1) goto L25;
         */
        /* JADX WARN: Code restructure failed: missing block: B:24:0x00c0, code lost:
        
            if (r0.emit(new com.box.android.domain.utils.result.Result.Error(com.box.android.data.service.impl.DomainErrorMapper.INSTANCE.toDomainError(r10, "Couldn't fetch offline items.")), r9) == r1) goto L25;
         */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final java.lang.Object invokeSuspend(java.lang.Object r10) {
            /*
                r9 = this;
                java.lang.Object r0 = r9.L$0
                kotlinx.coroutines.flow.FlowCollector r0 = (kotlinx.coroutines.flow.FlowCollector) r0
                java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
                int r2 = r9.label
                r3 = 3
                r4 = 2
                r5 = 1
                if (r2 == 0) goto L39
                if (r2 == r5) goto L33
                if (r2 == r4) goto L26
                if (r2 != r3) goto L1e
                java.lang.Object r9 = r9.L$1
                java.lang.Exception r9 = (java.lang.Exception) r9
                kotlin.ResultKt.throwOnFailure(r10)
                goto Lc3
            L1e:
                java.lang.IllegalStateException r9 = new java.lang.IllegalStateException
                java.lang.String r10 = "call to 'resume' before 'invoke' with coroutine"
                r9.<init>(r10)
                throw r9
            L26:
                java.lang.Object r2 = r9.L$2
                java.util.List r2 = (java.util.List) r2
                java.lang.Object r2 = r9.L$1
                java.util.List r2 = (java.util.List) r2
                kotlin.ResultKt.throwOnFailure(r10)     // Catch: java.lang.Exception -> L37
                goto Lc3
            L33:
                kotlin.ResultKt.throwOnFailure(r10)     // Catch: java.lang.Exception -> L37
                goto L4e
            L37:
                r10 = move-exception
                goto L8f
            L39:
                kotlin.ResultKt.throwOnFailure(r10)
                com.box.android.data.service.impl.OfflineService r10 = com.box.android.data.service.impl.OfflineService.this     // Catch: java.lang.Exception -> L37
                com.box.android.domain.configuration.DataPolicy r2 = com.box.android.domain.configuration.DataPolicy.CACHE     // Catch: java.lang.Exception -> L37
                r6 = r9
                kotlin.coroutines.Continuation r6 = (kotlin.coroutines.Continuation) r6     // Catch: java.lang.Exception -> L37
                r9.L$0 = r0     // Catch: java.lang.Exception -> L37
                r9.label = r5     // Catch: java.lang.Exception -> L37
                java.lang.Object r10 = com.box.android.data.service.impl.OfflineService.access$fetchOfflineItems(r10, r2, r6)     // Catch: java.lang.Exception -> L37
                if (r10 != r1) goto L4e
                goto Lc2
            L4e:
                kotlin.Pair r10 = (kotlin.Pair) r10     // Catch: java.lang.Exception -> L37
                java.lang.Object r2 = r10.component1()     // Catch: java.lang.Exception -> L37
                java.util.List r2 = (java.util.List) r2     // Catch: java.lang.Exception -> L37
                java.lang.Object r10 = r10.component2()     // Catch: java.lang.Exception -> L37
                java.util.List r10 = (java.util.List) r10     // Catch: java.lang.Exception -> L37
                com.box.android.domain.utils.result.Result$Success r5 = new com.box.android.domain.utils.result.Result$Success     // Catch: java.lang.Exception -> L37
                com.box.android.data.service.impl.OfflineService r6 = com.box.android.data.service.impl.OfflineService.this     // Catch: java.lang.Exception -> L37
                com.box.android.domain.utils.ItemSorter r6 = com.box.android.data.service.impl.OfflineService.access$getItemSorter$p(r6)     // Catch: java.lang.Exception -> L37
                r7 = r2
                java.util.Collection r7 = (java.util.Collection) r7     // Catch: java.lang.Exception -> L37
                r8 = r10
                java.lang.Iterable r8 = (java.lang.Iterable) r8     // Catch: java.lang.Exception -> L37
                java.util.List r7 = kotlin.collections.CollectionsKt.plus(r7, r8)     // Catch: java.lang.Exception -> L37
                java.util.List r6 = r6.sort(r7)     // Catch: java.lang.Exception -> L37
                r5.<init>(r6)     // Catch: java.lang.Exception -> L37
                r6 = r9
                kotlin.coroutines.Continuation r6 = (kotlin.coroutines.Continuation) r6     // Catch: java.lang.Exception -> L37
                r9.L$0 = r0     // Catch: java.lang.Exception -> L37
                java.lang.Object r2 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r2)     // Catch: java.lang.Exception -> L37
                r9.L$1 = r2     // Catch: java.lang.Exception -> L37
                java.lang.Object r10 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r10)     // Catch: java.lang.Exception -> L37
                r9.L$2 = r10     // Catch: java.lang.Exception -> L37
                r9.label = r4     // Catch: java.lang.Exception -> L37
                java.lang.Object r9 = r0.emit(r5, r6)     // Catch: java.lang.Exception -> L37
                if (r9 != r1) goto Lc3
                goto Lc2
            L8f:
                java.lang.String r2 = com.box.android.domain.utils.ExtensionsKt.getTAG(r0)
                java.lang.String r4 = "Error fetching offline items"
                r5 = r10
                java.lang.Throwable r5 = (java.lang.Throwable) r5
                com.box.androidsdk.content.utils.BoxLogUtils.e(r2, r4, r5)
                com.box.android.domain.utils.result.Result$Error r2 = new com.box.android.domain.utils.result.Result$Error
                com.box.android.data.service.impl.DomainErrorMapper r4 = com.box.android.data.service.impl.DomainErrorMapper.INSTANCE
                java.lang.String r5 = "Couldn't fetch offline items."
                com.box.android.domain.models.DomainError r4 = r4.toDomainError(r10, r5)
                r2.<init>(r4)
                r4 = r9
                kotlin.coroutines.Continuation r4 = (kotlin.coroutines.Continuation) r4
                java.lang.Object r5 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r0)
                r9.L$0 = r5
                java.lang.Object r10 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r10)
                r9.L$1 = r10
                r10 = 0
                r9.L$2 = r10
                r9.label = r3
                java.lang.Object r9 = r0.emit(r2, r4)
                if (r9 != r1) goto Lc3
            Lc2:
                return r1
            Lc3:
                kotlin.Unit r9 = kotlin.Unit.INSTANCE
                return r9
            */
            throw new UnsupportedOperationException("Method not decompiled: com.box.android.data.service.impl.OfflineService.C14781.invokeSuspend(java.lang.Object):java.lang.Object");
        }
    }

    @Override // com.box.android.domain.services.IOfflineService
    public Flow<Result<List<ItemModel>, DomainError>> offlineItems() {
        return FlowKt.flowOn(FlowKt.flow(new C14781(null)), this.ioDispatcher);
    }

    /* JADX INFO: renamed from: com.box.android.data.service.impl.OfflineService$getOutdatedOfflineItems$2, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: OfflineService.kt */
    @Metadata(d1 = {"\u0000\u0016\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u0002\u0012\u0004\u0012\u00020\u00040\u0001*\u00020\u0005H\n"}, d2 = {"<anonymous>", "Lcom/box/android/domain/utils/result/Result;", "", "Lcom/box/android/domain/models/item/ItemModel;", "Lcom/box/android/domain/models/DomainError;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.box.android.data.service.impl.OfflineService$getOutdatedOfflineItems$2", f = "OfflineService.kt", i = {0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2}, l = {77, 81, 88}, m = "invokeSuspend", n = {"$this$withContext", "$this$withContext", "folders", "files", "$this$filter$iv", "$this$filterTo$iv$iv", "destination$iv$iv", "element$iv$iv", "folder", "$i$f$filter", "$i$f$filterTo", "$i$a$-filter-OfflineService$getOutdatedOfflineItems$2$staleFolders$1", "modifiedTime", "$i$a$-let-OfflineService$getOutdatedOfflineItems$2$staleFolders$1$1", "$this$withContext", "folders", "files", "staleFolders", "$this$filter$iv", "$this$filterTo$iv$iv", "destination$iv$iv", "element$iv$iv", "file", "$i$f$filter", "$i$f$filterTo", "$i$a$-filter-OfflineService$getOutdatedOfflineItems$2$staleFiles$1"}, s = {"L$0", "L$0", "L$1", "L$2", "L$3", "L$5", "L$6", "L$8", "L$9", "I$0", "I$1", "I$2", "J$0", "I$3", "L$0", "L$1", "L$2", "L$3", "L$4", "L$6", "L$7", "L$9", "L$10", "I$0", "I$1", "I$2"}, v = 1)
    static final class C14752 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Result<? extends List<? extends ItemModel>, ? extends DomainError>>, Object> {
        int I$0;
        int I$1;
        int I$2;
        int I$3;
        long J$0;
        long J$1;
        private /* synthetic */ Object L$0;
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

        C14752(Continuation<? super C14752> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            C14752 c14752 = OfflineService.this.new C14752(continuation);
            c14752.L$0 = obj;
            return c14752;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Result<? extends List<? extends ItemModel>, ? extends DomainError>> continuation) {
            return ((C14752) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Code duplicated, block: B:25:0x00df A[Catch: Exception -> 0x0097, TryCatch #0 {Exception -> 0x0097, blocks: (B:8:0x0045, B:41:0x0183, B:43:0x0189, B:13:0x0082, B:31:0x0142, B:38:0x015c, B:23:0x00d9, B:25:0x00df, B:27:0x00ec, B:40:0x0164, B:14:0x0091, B:22:0x00b2, B:19:0x009f), top: B:59:0x000f }] */
        /* JADX WARN: Code duplicated, block: B:27:0x00ec A[Catch: Exception -> 0x0097, TryCatch #0 {Exception -> 0x0097, blocks: (B:8:0x0045, B:41:0x0183, B:43:0x0189, B:13:0x0082, B:31:0x0142, B:38:0x015c, B:23:0x00d9, B:25:0x00df, B:27:0x00ec, B:40:0x0164, B:14:0x0091, B:22:0x00b2, B:19:0x009f), top: B:59:0x000f }] */
        /* JADX WARN: Code duplicated, block: B:29:0x013c  */
        /* JADX WARN: Code duplicated, block: B:30:0x013e  */
        /* JADX WARN: Code duplicated, block: B:33:0x014c  */
        /* JADX WARN: Code duplicated, block: B:34:0x014f  */
        /* JADX WARN: Code duplicated, block: B:38:0x015c A[Catch: Exception -> 0x0097, TryCatch #0 {Exception -> 0x0097, blocks: (B:8:0x0045, B:41:0x0183, B:43:0x0189, B:13:0x0082, B:31:0x0142, B:38:0x015c, B:23:0x00d9, B:25:0x00df, B:27:0x00ec, B:40:0x0164, B:14:0x0091, B:22:0x00b2, B:19:0x009f), top: B:59:0x000f }] */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:30:0x013e -> B:31:0x0142). Please report as a decompilation issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:48:0x01e3 -> B:61:0x01e8). Please report as a decompilation issue!!! */
        /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
            jadx.core.utils.exceptions.JadxOverflowException: Regions stack size limit reached
            	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
            	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
            	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
            */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final java.lang.Object invokeSuspend(java.lang.Object r24) {
            /*
                Method dump skipped, instruction units count: 552
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: com.box.android.data.service.impl.OfflineService.C14752.invokeSuspend(java.lang.Object):java.lang.Object");
        }
    }

    @Override // com.box.android.domain.services.IOfflineService
    public Object getOutdatedOfflineItems(Continuation<? super Result<? extends List<? extends ItemModel>, ? extends DomainError>> continuation) {
        return BuildersKt.withContext(this.ioDispatcher, new C14752(null), continuation);
    }

    /* JADX INFO: renamed from: com.box.android.data.service.impl.OfflineService$fetchOfflineItems$2, reason: invalid class name */
    /* JADX INFO: compiled from: OfflineService.kt */
    @Metadata(d1 = {"\u0000\u0016\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u001a\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u00020\u0001*\u00020\u0005H\n"}, d2 = {"<anonymous>", "Lkotlin/Pair;", "", "Lcom/box/android/domain/models/item/FolderModel;", "Lcom/box/android/domain/models/item/FileModel;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.box.android.data.service.impl.OfflineService$fetchOfflineItems$2", f = "OfflineService.kt", i = {0, 1, 1, 2, 2, 2, 2, 2, 3, 3, 3, 3, 3}, l = {102, 103, 119, 119}, m = "invokeSuspend", n = {"$this$coroutineScope", "$this$coroutineScope", "folderIds", "$this$coroutineScope", "folderIds", "fileIds", "folders", "files", "$this$coroutineScope", "folderIds", "fileIds", "folders", "files"}, s = {"L$0", "L$0", "L$1", "L$0", "L$1", "L$2", "L$3", "L$4", "L$0", "L$1", "L$2", "L$3", "L$4"}, v = 1)
    static final class AnonymousClass2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Pair<? extends List<? extends FolderModel>, ? extends List<? extends FileModel>>>, Object> {
        final /* synthetic */ DataPolicy $dataPolicy;
        private /* synthetic */ Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        Object L$4;
        Object L$5;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass2(DataPolicy dataPolicy, Continuation<? super AnonymousClass2> continuation) {
            super(2, continuation);
            this.$dataPolicy = dataPolicy;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            AnonymousClass2 anonymousClass2 = OfflineService.this.new AnonymousClass2(this.$dataPolicy, continuation);
            anonymousClass2.L$0 = obj;
            return anonymousClass2;
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Object invoke(CoroutineScope coroutineScope, Continuation<? super Pair<? extends List<? extends FolderModel>, ? extends List<? extends FileModel>>> continuation) {
            return invoke2(coroutineScope, (Continuation<? super Pair<? extends List<FolderModel>, ? extends List<FileModel>>>) continuation);
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(CoroutineScope coroutineScope, Continuation<? super Pair<? extends List<FolderModel>, ? extends List<FileModel>>> continuation) {
            return ((AnonymousClass2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Code duplicated, block: B:24:0x00e0  */
        /* JADX WARN: Code duplicated, block: B:28:0x0110  */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            List list;
            List list2;
            Deferred deferredAsync$default;
            Deferred deferredAsync$default2;
            Object objAwait;
            List list3;
            List list4;
            Deferred deferred;
            Object objAwait2;
            Object obj2;
            CoroutineScope coroutineScope = (CoroutineScope) this.L$0;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                this.L$0 = coroutineScope;
                this.label = 1;
                obj = BoxModelOfflineManager.INSTANCE.fetchUserOfflinedFolderIds(OfflineService.this.userContextManager, this);
                if (obj != coroutine_suspended) {
                }
                return coroutine_suspended;
            }
            if (i == 1) {
                ResultKt.throwOnFailure(obj);
            } else {
                if (i == 2) {
                    List list5 = (List) this.L$1;
                    ResultKt.throwOnFailure(obj);
                    list = list5;
                    list2 = (List) obj;
                    deferredAsync$default = BuildersKt__Builders_commonKt.async$default(coroutineScope, null, null, new OfflineService$fetchOfflineItems$2$folders$1(list, OfflineService.this, this.$dataPolicy, null), 3, null);
                    deferredAsync$default2 = BuildersKt__Builders_commonKt.async$default(coroutineScope, null, null, new OfflineService$fetchOfflineItems$2$files$1(list2, OfflineService.this, this.$dataPolicy, null), 3, null);
                    this.L$0 = SpillingKt.nullOutSpilledVariable(coroutineScope);
                    this.L$1 = SpillingKt.nullOutSpilledVariable(list);
                    this.L$2 = SpillingKt.nullOutSpilledVariable(list2);
                    this.L$3 = SpillingKt.nullOutSpilledVariable(deferredAsync$default);
                    this.L$4 = deferredAsync$default2;
                    this.label = 3;
                    objAwait = deferredAsync$default.await(this);
                    if (objAwait != coroutine_suspended) {
                        list3 = list2;
                        obj = objAwait;
                        list4 = list;
                        deferred = deferredAsync$default;
                        this.L$0 = SpillingKt.nullOutSpilledVariable(coroutineScope);
                        this.L$1 = SpillingKt.nullOutSpilledVariable(list4);
                        this.L$2 = SpillingKt.nullOutSpilledVariable(list3);
                        this.L$3 = SpillingKt.nullOutSpilledVariable(deferred);
                        this.L$4 = SpillingKt.nullOutSpilledVariable(deferredAsync$default2);
                        this.L$5 = obj;
                        this.label = 4;
                        objAwait2 = deferredAsync$default2.await(this);
                        if (objAwait2 != coroutine_suspended) {
                            obj2 = obj;
                            obj = objAwait2;
                        }
                    }
                    return coroutine_suspended;
                }
                if (i == 3) {
                    deferredAsync$default2 = (Deferred) this.L$4;
                    deferred = (Deferred) this.L$3;
                    list3 = (List) this.L$2;
                    list4 = (List) this.L$1;
                    ResultKt.throwOnFailure(obj);
                    this.L$0 = SpillingKt.nullOutSpilledVariable(coroutineScope);
                    this.L$1 = SpillingKt.nullOutSpilledVariable(list4);
                    this.L$2 = SpillingKt.nullOutSpilledVariable(list3);
                    this.L$3 = SpillingKt.nullOutSpilledVariable(deferred);
                    this.L$4 = SpillingKt.nullOutSpilledVariable(deferredAsync$default2);
                    this.L$5 = obj;
                    this.label = 4;
                    objAwait2 = deferredAsync$default2.await(this);
                    if (objAwait2 != coroutine_suspended) {
                        obj2 = obj;
                        obj = objAwait2;
                    }
                    return coroutine_suspended;
                }
                if (i != 4) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                obj2 = this.L$5;
                ResultKt.throwOnFailure(obj);
            }
            return TuplesKt.to(obj2, obj);
            List list6 = (List) obj;
            this.L$0 = coroutineScope;
            this.L$1 = list6;
            this.label = 2;
            Object objFetchUserOfflinedFileIds = BoxModelOfflineManager.INSTANCE.fetchUserOfflinedFileIds(OfflineService.this.userContextManager, this);
            if (objFetchUserOfflinedFileIds != coroutine_suspended) {
                list = list6;
                obj = objFetchUserOfflinedFileIds;
                list2 = (List) obj;
                deferredAsync$default = BuildersKt__Builders_commonKt.async$default(coroutineScope, null, null, new OfflineService$fetchOfflineItems$2$folders$1(list, OfflineService.this, this.$dataPolicy, null), 3, null);
                deferredAsync$default2 = BuildersKt__Builders_commonKt.async$default(coroutineScope, null, null, new OfflineService$fetchOfflineItems$2$files$1(list2, OfflineService.this, this.$dataPolicy, null), 3, null);
                this.L$0 = SpillingKt.nullOutSpilledVariable(coroutineScope);
                this.L$1 = SpillingKt.nullOutSpilledVariable(list);
                this.L$2 = SpillingKt.nullOutSpilledVariable(list2);
                this.L$3 = SpillingKt.nullOutSpilledVariable(deferredAsync$default);
                this.L$4 = deferredAsync$default2;
                this.label = 3;
                objAwait = deferredAsync$default.await(this);
                if (objAwait != coroutine_suspended) {
                    list3 = list2;
                    obj = objAwait;
                    list4 = list;
                    deferred = deferredAsync$default;
                    this.L$0 = SpillingKt.nullOutSpilledVariable(coroutineScope);
                    this.L$1 = SpillingKt.nullOutSpilledVariable(list4);
                    this.L$2 = SpillingKt.nullOutSpilledVariable(list3);
                    this.L$3 = SpillingKt.nullOutSpilledVariable(deferred);
                    this.L$4 = SpillingKt.nullOutSpilledVariable(deferredAsync$default2);
                    this.L$5 = obj;
                    this.label = 4;
                    objAwait2 = deferredAsync$default2.await(this);
                    if (objAwait2 != coroutine_suspended) {
                        obj2 = obj;
                        obj = objAwait2;
                        return TuplesKt.to(obj2, obj);
                    }
                }
            }
            return coroutine_suspended;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object fetchOfflineItems(DataPolicy dataPolicy, Continuation<? super Pair<? extends List<FolderModel>, ? extends List<FileModel>>> continuation) {
        return CoroutineScopeKt.coroutineScope(new AnonymousClass2(dataPolicy, null), continuation);
    }

    @Override // com.box.android.domain.services.IOfflineService
    public Object syncOfflineItems(List<? extends ItemModel> list, Continuation<? super Result<Unit, ? extends DomainError>> continuation) {
        return makeAvailableOffline(list, false, JobTags.JobSource.OFFLINE_UPDATE, continuation);
    }

    @Override // com.box.android.domain.services.IOfflineService
    public boolean isSizeBigEnoughToSaveOnlyPreviews(ItemModel... itemsToOffline) {
        Intrinsics.checkNotNullParameter(itemsToOffline, "itemsToOffline");
        long jLongValue = 0;
        for (ItemModel itemModel : itemsToOffline) {
            Long size = itemModel.getSize();
            if (size != null) {
                jLongValue += size.longValue();
                if (jLongValue >= 20971520) {
                    return true;
                }
            }
        }
        return false;
    }

    @Override // com.box.android.domain.services.IOfflineService
    public Object makeAvailableOffline(List<? extends ItemModel> list, boolean z, JobTags.JobSource jobSource, Continuation<? super Result<Unit, ? extends DomainError>> continuation) {
        if (this.featureFlips.getOfflineMigration().getEnabled()) {
            return this.localItemService.enqueueMarkOfflineJobForItems(list, z, jobSource, continuation);
        }
        JobManager jobManager = this.jobManager;
        List<? extends ItemModel> list2 = list;
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list2, 10));
        Iterator<T> it = list2.iterator();
        while (it.hasNext()) {
            arrayList.add(ItemModelMapper.toBoxItem$default(ItemModelMapper.INSTANCE, (ItemModel) it.next(), false, 1, null));
        }
        jobManager.offlineItems(arrayList, z);
        return new Result.Success(Unit.INSTANCE);
    }

    /* JADX INFO: renamed from: com.box.android.data.service.impl.OfflineService$removeFromOffline$2, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: OfflineService.kt */
    @Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\u0003H\n"}, d2 = {"<anonymous>", "Lcom/box/android/domain/utils/result/Result$Success;", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.box.android.data.service.impl.OfflineService$removeFromOffline$2", f = "OfflineService.kt", i = {0, 1, 2, 3, 4}, l = {Token.GET, Token.LET, Token.ARRAYCOMP, 160, Token.METHOD}, m = "invokeSuspend", n = {"item", "item", "item", "item", "item"}, s = {"L$1", "L$1", "L$1", "L$1", "L$1"}, v = 1)
    static final class C14802 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Result.Success<? extends Unit>>, Object> {
        final /* synthetic */ List<ItemModel> $items;
        Object L$0;
        Object L$1;
        int label;
        final /* synthetic */ OfflineService this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        C14802(List<? extends ItemModel> list, OfflineService offlineService, Continuation<? super C14802> continuation) {
            super(2, continuation);
            this.$items = list;
            this.this$0 = offlineService;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new C14802(this.$items, this.this$0, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Object invoke(CoroutineScope coroutineScope, Continuation<? super Result.Success<? extends Unit>> continuation) {
            return invoke2(coroutineScope, (Continuation<? super Result.Success<Unit>>) continuation);
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(CoroutineScope coroutineScope, Continuation<? super Result.Success<Unit>> continuation) {
            return ((C14802) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Code duplicated, block: B:18:0x0056  */
        /* JADX WARN: Code duplicated, block: B:23:0x007a  */
        /* JADX WARN: Code duplicated, block: B:27:0x00b5  */
        /* JADX WARN: Code duplicated, block: B:28:0x00b7  */
        /* JADX WARN: Code duplicated, block: B:33:0x00d4  */
        /* JADX WARN: Code duplicated, block: B:37:0x0112  */
        /* JADX WARN: Code duplicated, block: B:46:0x0060 A[SYNTHETIC] */
        /* JADX WARN: Code duplicated, block: B:47:0x0116 A[SYNTHETIC] */
        /* JADX WARN: Code duplicated, block: B:48:0x00bb A[SYNTHETIC] */
        /* JADX WARN: Code duplicated, block: B:49:0x012e A[SYNTHETIC] */
        /* JADX WARN: Code duplicated, block: B:51:0x0050 A[SYNTHETIC] */
        /* JADX WARN: Code duplicated, block: B:52:0x0050 A[SYNTHETIC] */
        /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
            jadx.core.utils.exceptions.JadxOverflowException: Regions stack size limit reached
            	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
            	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
            	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
            */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final java.lang.Object invokeSuspend(java.lang.Object r13) {
            /*
                Method dump skipped, instruction units count: 311
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: com.box.android.data.service.impl.OfflineService.C14802.invokeSuspend(java.lang.Object):java.lang.Object");
        }
    }

    @Override // com.box.android.domain.services.IOfflineService
    public Object removeFromOffline(List<? extends ItemModel> list, Continuation<? super Result<Unit, ? extends DomainError>> continuation) {
        if (this.featureFlips.getOfflineMigration().getEnabled()) {
            Object objWithContext = BuildersKt.withContext(this.ioDispatcher, new C14802(list, this, null), continuation);
            return objWithContext == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objWithContext : (Result) objWithContext;
        }
        JobManager jobManager = this.jobManager;
        List<? extends ItemModel> list2 = list;
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list2, 10));
        Iterator<T> it = list2.iterator();
        while (it.hasNext()) {
            arrayList.add(ItemModelMapper.toBoxItem$default(ItemModelMapper.INSTANCE, (ItemModel) it.next(), false, 1, null));
        }
        jobManager.removeOfflineItems(arrayList);
        return new Result.Success(Unit.INSTANCE);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:26:0x010f  */
    /* JADX WARN: Code duplicated, block: B:28:0x011d  */
    /* JADX WARN: Code duplicated, block: B:29:0x0120  */
    /* JADX WARN: Code duplicated, block: B:35:0x013f  */
    /* JADX WARN: Code duplicated, block: B:75:0x0124 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:79:? A[LOOP:0: B:24:0x0106->B:79:?, LOOP_END, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:7:0x001a  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:61:0x0255 -> B:42:0x017d). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:71:0x02ca -> B:13:0x004c). Please report as a decompilation issue!!! */
    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions stack size limit reached
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        */
    public final java.lang.Object removeFolderFromOffline(com.box.android.domain.models.item.FolderModel r21, kotlin.coroutines.Continuation<? super kotlin.Unit> r22) {
        /*
            Method dump skipped, instruction units count: 744
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.box.android.data.service.impl.OfflineService.removeFolderFromOffline(com.box.android.domain.models.item.FolderModel, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r5v8 */
    public final Object tryCancelMarkForOfflineJob(ItemId itemId, Continuation<? super Unit> continuation) {
        C14811 c14811;
        Object objCancelMarkForOfflineJob;
        if (continuation instanceof C14811) {
            c14811 = (C14811) continuation;
            if ((c14811.label & Integer.MIN_VALUE) != 0) {
                c14811.label -= Integer.MIN_VALUE;
            } else {
                c14811 = new C14811(continuation);
            }
        } else {
            c14811 = new C14811(continuation);
        }
        Object obj = c14811.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = c14811.label;
        try {
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                ItemId.Remote remote = itemId instanceof ItemId.Remote ? (ItemId.Remote) itemId : null;
                if (remote != null) {
                    IJobService iJobService = this.jobService;
                    c14811.L$0 = itemId;
                    c14811.L$1 = SpillingKt.nullOutSpilledVariable(remote);
                    c14811.I$0 = 0;
                    c14811.label = 1;
                    objCancelMarkForOfflineJob = iJobService.cancelMarkForOfflineJob(remote, c14811);
                    if (objCancelMarkForOfflineJob == coroutine_suspended) {
                        this = objCancelMarkForOfflineJob;
                        return coroutine_suspended;
                    }
                }
                return Unit.INSTANCE;
            }
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            int i2 = c14811.I$0;
            itemId = (ItemId) c14811.L$0;
            ResultKt.throwOnFailure(obj);
            this = this;
            this = objCancelMarkForOfflineJob;
        } catch (Exception e) {
            BoxLogUtils.e(ExtensionsKt.getTAG(this), "Failed to cancel mark for offline job for item " + itemId, e);
        }
        return Unit.INSTANCE;
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    @Override // com.box.android.domain.services.IOfflineService
    public Object isFileOfflined(FileModel fileModel, Continuation<? super Boolean> continuation) {
        C14771 c14771;
        if (continuation instanceof C14771) {
            c14771 = (C14771) continuation;
            if ((c14771.label & Integer.MIN_VALUE) != 0) {
                c14771.label -= Integer.MIN_VALUE;
            } else {
                c14771 = new C14771(continuation);
            }
        } else {
            c14771 = new C14771(continuation);
        }
        Object state = c14771.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = c14771.label;
        if (i == 0) {
            ResultKt.throwOnFailure(state);
            c14771.L$0 = SpillingKt.nullOutSpilledVariable(fileModel);
            c14771.label = 1;
            state = this.modelOfflineManagerWrapper.getState(fileModel, c14771);
            if (state == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(state);
        }
        return Boxing.boxBoolean(state == BoxModelOfflineManager.State.OFFLINE);
    }

    /* JADX INFO: renamed from: com.box.android.data.service.impl.OfflineService$getStatusOfJob$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: OfflineService.kt */
    @Metadata(d1 = {"\u0000\u0016\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u00030\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/flow/FlowCollector;", "Lcom/box/android/domain/utils/result/Result;", "Lcom/box/android/domain/models/JobInfo$Status;", "Lcom/box/android/domain/models/DomainError;"}, k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.box.android.data.service.impl.OfflineService$getStatusOfJob$1", f = "OfflineService.kt", i = {0, 1, 1, 2, 2}, l = {243, 245, 254}, m = "invokeSuspend", n = {"$this$flow", "$this$flow", "remoteIdResult", "$this$flow", "remoteIdResult"}, s = {"L$0", "L$0", "L$1", "L$0", "L$1"}, v = 1)
    static final class C14761 extends SuspendLambda implements Function2<FlowCollector<? super Result<? extends JobInfo.Status, ? extends DomainError>>, Continuation<? super Unit>, Object> {
        final /* synthetic */ ItemId $itemId;
        private /* synthetic */ Object L$0;
        Object L$1;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C14761(ItemId itemId, Continuation<? super C14761> continuation) {
            super(2, continuation);
            this.$itemId = itemId;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            C14761 c14761 = OfflineService.this.new C14761(this.$itemId, continuation);
            c14761.L$0 = obj;
            return c14761;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(FlowCollector<? super Result<? extends JobInfo.Status, ? extends DomainError>> flowCollector, Continuation<? super Unit> continuation) {
            return ((C14761) create(flowCollector, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Code restructure failed: missing block: B:22:0x008f, code lost:
        
            if (kotlinx.coroutines.flow.FlowKt.emitAll(r0, r2, r7) == r1) goto L28;
         */
        /* JADX WARN: Code restructure failed: missing block: B:27:0x00b7, code lost:
        
            if (r0.emit(new com.box.android.domain.utils.result.Result.Error(((com.box.android.domain.utils.result.Result.Error) r8).getValue()), r7) == r1) goto L28;
         */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final java.lang.Object invokeSuspend(java.lang.Object r8) {
            /*
                r7 = this;
                java.lang.Object r0 = r7.L$0
                kotlinx.coroutines.flow.FlowCollector r0 = (kotlinx.coroutines.flow.FlowCollector) r0
                java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
                int r2 = r7.label
                r3 = 3
                r4 = 2
                r5 = 1
                if (r2 == 0) goto L2b
                if (r2 == r5) goto L27
                if (r2 == r4) goto L1e
                if (r2 != r3) goto L16
                goto L1e
            L16:
                java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
                java.lang.String r8 = "call to 'resume' before 'invoke' with coroutine"
                r7.<init>(r8)
                throw r7
            L1e:
                java.lang.Object r7 = r7.L$1
                com.box.android.domain.utils.result.Result r7 = (com.box.android.domain.utils.result.Result) r7
                kotlin.ResultKt.throwOnFailure(r8)
                goto Lba
            L27:
                kotlin.ResultKt.throwOnFailure(r8)
                goto L45
            L2b:
                kotlin.ResultKt.throwOnFailure(r8)
                com.box.android.data.service.impl.OfflineService r8 = com.box.android.data.service.impl.OfflineService.this
                com.box.android.domain.services.IdMappingService r8 = com.box.android.data.service.impl.OfflineService.access$getItemIdMappingService$p(r8)
                com.box.android.domain.models.ItemId r2 = r7.$itemId
                r6 = r7
                kotlin.coroutines.Continuation r6 = (kotlin.coroutines.Continuation) r6
                r7.L$0 = r0
                r7.label = r5
                java.lang.Object r8 = r8.getRemoteIdOrError(r2, r6)
                if (r8 != r1) goto L45
                goto Lb9
            L45:
                com.box.android.domain.utils.result.Result r8 = (com.box.android.domain.utils.result.Result) r8
                boolean r2 = r8 instanceof com.box.android.domain.utils.result.Result.Success
                if (r2 == 0) goto L92
                com.box.android.data.service.impl.OfflineService r2 = com.box.android.data.service.impl.OfflineService.this
                com.box.android.domain.configuration.FeatureFlips r2 = com.box.android.data.service.impl.OfflineService.access$getFeatureFlips$p(r2)
                com.box.android.domain.configuration.IFeatureFlip r2 = r2.getOfflineMigration()
                boolean r2 = r2.getEnabled()
                if (r2 == 0) goto L6b
                com.box.android.data.service.impl.OfflineService r2 = com.box.android.data.service.impl.OfflineService.this
                r3 = r8
                com.box.android.domain.utils.result.Result$Success r3 = (com.box.android.domain.utils.result.Result.Success) r3
                java.lang.Object r3 = r3.getValue()
                com.box.android.domain.models.ItemId$Remote r3 = (com.box.android.domain.models.ItemId.Remote) r3
                kotlinx.coroutines.flow.Flow r2 = com.box.android.data.service.impl.OfflineService.access$getJobStatusFromJobService(r2, r3)
                goto L7a
            L6b:
                com.box.android.data.service.impl.OfflineService r2 = com.box.android.data.service.impl.OfflineService.this
                r3 = r8
                com.box.android.domain.utils.result.Result$Success r3 = (com.box.android.domain.utils.result.Result.Success) r3
                java.lang.Object r3 = r3.getValue()
                com.box.android.domain.models.ItemId$Remote r3 = (com.box.android.domain.models.ItemId.Remote) r3
                kotlinx.coroutines.flow.Flow r2 = com.box.android.data.service.impl.OfflineService.access$getJobStatusFromJobManager(r2, r3)
            L7a:
                r3 = r7
                kotlin.coroutines.Continuation r3 = (kotlin.coroutines.Continuation) r3
                java.lang.Object r5 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r0)
                r7.L$0 = r5
                java.lang.Object r8 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r8)
                r7.L$1 = r8
                r7.label = r4
                java.lang.Object r7 = kotlinx.coroutines.flow.FlowKt.emitAll(r0, r2, r3)
                if (r7 != r1) goto Lba
                goto Lb9
            L92:
                boolean r2 = r8 instanceof com.box.android.domain.utils.result.Result.Error
                if (r2 == 0) goto Lbd
                com.box.android.domain.utils.result.Result$Error r2 = new com.box.android.domain.utils.result.Result$Error
                r4 = r8
                com.box.android.domain.utils.result.Result$Error r4 = (com.box.android.domain.utils.result.Result.Error) r4
                java.lang.Object r4 = r4.getValue()
                r2.<init>(r4)
                r4 = r7
                kotlin.coroutines.Continuation r4 = (kotlin.coroutines.Continuation) r4
                java.lang.Object r5 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r0)
                r7.L$0 = r5
                java.lang.Object r8 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r8)
                r7.L$1 = r8
                r7.label = r3
                java.lang.Object r7 = r0.emit(r2, r4)
                if (r7 != r1) goto Lba
            Lb9:
                return r1
            Lba:
                kotlin.Unit r7 = kotlin.Unit.INSTANCE
                return r7
            Lbd:
                kotlin.NoWhenBranchMatchedException r7 = new kotlin.NoWhenBranchMatchedException
                r7.<init>()
                throw r7
            */
            throw new UnsupportedOperationException("Method not decompiled: com.box.android.data.service.impl.OfflineService.C14761.invokeSuspend(java.lang.Object):java.lang.Object");
        }
    }

    @Override // com.box.android.domain.services.IOfflineService
    public Flow<Result<JobInfo.Status, DomainError>> getStatusOfJob(ItemId itemId) {
        Intrinsics.checkNotNullParameter(itemId, "itemId");
        return FlowKt.flowOn(FlowKt.flow(new C14761(itemId, null)), this.ioDispatcher);
    }

    /* JADX INFO: renamed from: com.box.android.data.service.impl.OfflineService$getJobStatusFromJobService$1, reason: invalid class name */
    /* JADX INFO: compiled from: OfflineService.kt */
    @Metadata(d1 = {"\u0000\u0016\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u00030\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/flow/FlowCollector;", "Lcom/box/android/domain/utils/result/Result;", "Lcom/box/android/domain/models/JobInfo$Status;", "Lcom/box/android/domain/models/DomainError;"}, k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.box.android.data.service.impl.OfflineService$getJobStatusFromJobService$1", f = "OfflineService.kt", i = {0, 1, 1, 2, 2, 2, 3, 3}, l = {259, 262, 264, 269}, m = "invokeSuspend", n = {"$this$flow", "$this$flow", "jobInfosResult", "$this$flow", "jobInfosResult", "jobInfo", "$this$flow", "jobInfosResult"}, s = {"L$0", "L$0", "L$1", "L$0", "L$1", "L$2", "L$0", "L$1"}, v = 1)
    static final class AnonymousClass1 extends SuspendLambda implements Function2<FlowCollector<? super Result<? extends JobInfo.Status, ? extends DomainError>>, Continuation<? super Unit>, Object> {
        final /* synthetic */ ItemId.Remote $remoteId;
        private /* synthetic */ Object L$0;
        Object L$1;
        Object L$2;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(ItemId.Remote remote, Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
            this.$remoteId = remote;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            AnonymousClass1 anonymousClass1 = OfflineService.this.new AnonymousClass1(this.$remoteId, continuation);
            anonymousClass1.L$0 = obj;
            return anonymousClass1;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(FlowCollector<? super Result<? extends JobInfo.Status, ? extends DomainError>> flowCollector, Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(flowCollector, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Code restructure failed: missing block: B:23:0x009f, code lost:
        
            if (r0.emit(new com.box.android.domain.utils.result.Result.Error(new com.box.android.domain.models.DomainError.NoResultFoundError(null, 1, null)), r9) == r1) goto L34;
         */
        /* JADX WARN: Code restructure failed: missing block: B:28:0x00cd, code lost:
        
            if (r3.collect(new com.box.android.data.service.impl.OfflineService.AnonymousClass1.C01681<>(), r9) == r1) goto L34;
         */
        /* JADX WARN: Code restructure failed: missing block: B:33:0x00f5, code lost:
        
            if (r0.emit(new com.box.android.domain.utils.result.Result.Error(((com.box.android.domain.utils.result.Result.Error) r10).getValue()), r9) == r1) goto L34;
         */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final java.lang.Object invokeSuspend(java.lang.Object r10) {
            /*
                Method dump skipped, instruction units count: 257
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: com.box.android.data.service.impl.OfflineService.AnonymousClass1.invokeSuspend(java.lang.Object):java.lang.Object");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Flow<Result<JobInfo.Status, DomainError>> getJobStatusFromJobService(ItemId.Remote remoteId) {
        return FlowKt.flow(new AnonymousClass1(remoteId, null));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Flow<Result<JobInfo.Status, DomainError>> getJobStatusFromJobManager(ItemId.Remote remoteId) {
        final Flow<Result<JobInfo.Status, DomainError>> jobStatus = this.jobManagerBridgeService.getJobStatus(remoteId.getBoxId(), JobType.OFFLINE_FILE, JobType.REMOVE_OFFLINE_JOB);
        return (Flow) new Flow<Result<? extends JobInfo.Status, ? extends DomainError>>() { // from class: com.box.android.data.service.impl.OfflineService$getJobStatusFromJobManager$$inlined$map$1
            @Override // kotlinx.coroutines.flow.Flow
            public Object collect(FlowCollector<? super Result<? extends JobInfo.Status, ? extends DomainError>> flowCollector, Continuation continuation) {
                Object objCollect = jobStatus.collect(new AnonymousClass2(flowCollector, this), continuation);
                return objCollect == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objCollect : Unit.INSTANCE;
            }

            /* JADX INFO: renamed from: com.box.android.data.service.impl.OfflineService$getJobStatusFromJobManager$$inlined$map$1$2, reason: invalid class name */
            /* JADX INFO: compiled from: Emitters.kt */
            @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
            public static final class AnonymousClass2<T> implements FlowCollector {
                final /* synthetic */ FlowCollector $this_unsafeFlow;
                final /* synthetic */ OfflineService this$0;

                /* JADX INFO: renamed from: com.box.android.data.service.impl.OfflineService$getJobStatusFromJobManager$$inlined$map$1$2$1, reason: invalid class name */
                @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
                @DebugMetadata(c = "com.box.android.data.service.impl.OfflineService$getJobStatusFromJobManager$$inlined$map$1$2", f = "OfflineService.kt", i = {0, 0, 0, 0, 0}, l = {50}, m = "emit", n = {"value", "$completion", "value", "$this$map_u24lambda_u245", "$i$a$-unsafeTransform-FlowKt__TransformKt$map$1"}, s = {"L$0", "L$1", "L$2", "L$3", "I$0"}, v = 1)
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

                public AnonymousClass2(FlowCollector flowCollector, OfflineService offlineService) {
                    this.$this_unsafeFlow = flowCollector;
                    this.this$0 = offlineService;
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
                        Result resultMapStatusToResult = (Result) obj;
                        if (resultMapStatusToResult instanceof Result.Success) {
                            resultMapStatusToResult = this.this$0.mapStatusToResult((JobInfo.Status) ((Result.Success) resultMapStatusToResult).getValue());
                        } else if (!(resultMapStatusToResult instanceof Result.Error)) {
                            throw new NoWhenBranchMatchedException();
                        }
                        anonymousClass1.L$0 = SpillingKt.nullOutSpilledVariable(obj);
                        anonymousClass1.L$1 = SpillingKt.nullOutSpilledVariable(anonymousClass1);
                        anonymousClass1.L$2 = SpillingKt.nullOutSpilledVariable(obj);
                        anonymousClass1.L$3 = SpillingKt.nullOutSpilledVariable(flowCollector);
                        anonymousClass1.I$0 = 0;
                        anonymousClass1.label = 1;
                        if (flowCollector.emit(resultMapStatusToResult, anonymousClass1) == coroutine_suspended) {
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
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Result<JobInfo.Status, DomainError> mapStatusToResult(JobInfo.Status status) {
        return status instanceof JobInfo.Status.Failed ? new Result.Error(((JobInfo.Status.Failed) status).getError()) : new Result.Success(status);
    }
}
