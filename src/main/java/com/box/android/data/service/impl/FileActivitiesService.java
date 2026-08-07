package com.box.android.data.service.impl;

import androidx.arch.core.util.Function;
import androidx.paging.DataSource;
import com.box.android.common.utilities.BoxCommonConstants;
import com.box.android.data.api.models.annotations.ActivityType;
import com.box.android.data.api.models.annotations.CommentDTO;
import com.box.android.data.api.models.annotations.FileActivityDTO;
import com.box.android.data.api.models.annotations.Location;
import com.box.android.data.datasource.CacheError;
import com.box.android.data.datasource.annotations.FileActivityCacheDataSource;
import com.box.android.data.datasource.annotations.FileActivityRemoteDataSource;
import com.box.android.data.datasource.errors.AnnotationsRemoteError;
import com.box.android.data.datasource.errors.RemoteError;
import com.box.android.data.mappers.annotation.CommentDTOEntityMapper;
import com.box.android.data.mappers.annotation.CommentEntityDomainMapper;
import com.box.android.data.mappers.annotation.FileActivityDTOEntityMapper;
import com.box.android.data.mappers.annotation.FileActivityEntityDomainMapper;
import com.box.android.data.persistence.annotations.CommentEntity;
import com.box.android.data.persistence.annotations.FileActivityEntities;
import com.box.android.domain.configuration.DataPolicy;
import com.box.android.domain.configuration.FeatureFlips;
import com.box.android.domain.models.DomainError;
import com.box.android.domain.models.FileActivityDomainError;
import com.box.android.domain.models.IGenericError;
import com.box.android.domain.models.ItemId;
import com.box.android.domain.models.annotations.FileActivityModel;
import com.box.android.domain.models.item.ItemModel;
import com.box.android.domain.models.item.ItemType;
import com.box.android.domain.models.item.PermissionsModel;
import com.box.android.domain.services.IFileActivitiesService;
import com.box.android.domain.services.IdMappingService;
import com.box.android.domain.utils.exceptions.AbortFlowCollectionException;
import com.box.android.domain.utils.result.Result;
import com.box.androidsdk.content.utils.BoxLogUtils;
import com.box.brownfieldApi.featuresNavigator.activities.ReactNativeFeatureActivity;
import com.microsoft.identity.common.java.providers.microsoft.MicrosoftAuthorizationErrorResponse;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Date;
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
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.FlowKt;

/* JADX INFO: compiled from: FileActivitiesService.kt */
/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000´\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 >2\u00020\u0001:\u0001>BQ\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\u0006\u0010\f\u001a\u00020\r\u0012\u0006\u0010\u000e\u001a\u00020\u000f\u0012\u0006\u0010\u0010\u001a\u00020\u0011\u0012\u0006\u0010\u0012\u001a\u00020\u0013¢\u0006\u0004\b\u0014\u0010\u0015J(\u0010\u0016\u001a\u001a\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0019\u0012\u0004\u0012\u00020\u001a0\u0018\u0012\u0004\u0012\u00020\u001b0\u00172\u0006\u0010\u001c\u001a\u00020\u001dH\u0016J(\u0010\u001e\u001a\u001a\u0012\u0016\u0012\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001a0 \u0012\u0004\u0012\u00020\u001b0\u00170\u001f2\u0006\u0010!\u001a\u00020\"H\u0016J(\u0010#\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020$0 \u0012\u0004\u0012\u00020\u001b0\u00172\u0006\u0010%\u001a\u00020\u001dH\u0096@¢\u0006\u0002\u0010&J\"\u0010'\u001a\u000e\u0012\u0004\u0012\u00020(\u0012\u0004\u0012\u00020\u001b0\u00172\u0006\u0010!\u001a\u00020\"H\u0096@¢\u0006\u0002\u0010)J\u0016\u0010*\u001a\b\u0012\u0004\u0012\u00020\u001b0+2\u0006\u0010,\u001a\u00020-H\u0002J$\u0010.\u001a\b\u0012\u0004\u0012\u00020\u001a0 2\f\u0010/\u001a\b\u0012\u0004\u0012\u0002000 2\u0006\u0010\u001c\u001a\u00020\u001dH\u0007J*\u00101\u001a\b\u0012\u0004\u0012\u00020\u001a0 2\f\u0010/\u001a\b\u0012\u0004\u0012\u0002000 2\u0006\u0010\u001c\u001a\u00020\u001dH\u0087@¢\u0006\u0002\u00102J>\u00103\u001a\u001a\u0012\u0016\u0012\u0014\u0012\u0004\u0012\u000200\u0012\n\u0012\b\u0012\u0004\u0012\u0002050 040 2\f\u00106\u001a\b\u0012\u0004\u0012\u0002070 2\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u00108\u001a\u00020\u0019H\u0002J\u001e\u00109\u001a\u00020:2\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010;\u001a\u00020<H\u0082@¢\u0006\u0002\u0010=R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006?"}, d2 = {"Lcom/box/android/data/service/impl/FileActivitiesService;", "Lcom/box/android/domain/services/IFileActivitiesService;", "fileActivitiesRemoteDataSource", "Lcom/box/android/data/datasource/annotations/FileActivityRemoteDataSource;", "fileActivitiesCacheDataSource", "Lcom/box/android/data/datasource/annotations/FileActivityCacheDataSource;", "itemService", "Lcom/box/android/data/service/impl/LocalItemService;", "fileActivitiesDTOEntityMapper", "Lcom/box/android/data/mappers/annotation/FileActivityDTOEntityMapper;", "fileActivityEntityDomainMapper", "Lcom/box/android/data/mappers/annotation/FileActivityEntityDomainMapper;", "commentDTOEntityMapper", "Lcom/box/android/data/mappers/annotation/CommentDTOEntityMapper;", "commentEntityDomainMapper", "Lcom/box/android/data/mappers/annotation/CommentEntityDomainMapper;", "idMappingService", "Lcom/box/android/domain/services/IdMappingService;", "featureFlips", "Lcom/box/android/domain/configuration/FeatureFlips;", "<init>", "(Lcom/box/android/data/datasource/annotations/FileActivityRemoteDataSource;Lcom/box/android/data/datasource/annotations/FileActivityCacheDataSource;Lcom/box/android/data/service/impl/LocalItemService;Lcom/box/android/data/mappers/annotation/FileActivityDTOEntityMapper;Lcom/box/android/data/mappers/annotation/FileActivityEntityDomainMapper;Lcom/box/android/data/mappers/annotation/CommentDTOEntityMapper;Lcom/box/android/data/mappers/annotation/CommentEntityDomainMapper;Lcom/box/android/domain/services/IdMappingService;Lcom/box/android/domain/configuration/FeatureFlips;)V", "activities", "Lcom/box/android/domain/utils/result/Result;", "Landroidx/paging/DataSource$Factory;", "", "Lcom/box/android/domain/models/annotations/FileActivityModel;", "Lcom/box/android/domain/models/DomainError;", "fileId", "", "activitiesV2", "Lkotlinx/coroutines/flow/Flow;", "", "fileItemId", "Lcom/box/android/domain/models/ItemId;", "replies", "Lcom/box/android/domain/models/annotations/FileActivityModel$CommentModel;", "activityID", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "fetchActivitiesFromRemote", "", "(Lcom/box/android/domain/models/ItemId;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "handleException", "Lcom/box/android/domain/utils/result/Result$Error;", "cause", "", "mapToFileActivityModels", "input", "Lcom/box/android/data/persistence/annotations/FileActivityEntities;", "mapToFileActivityModelsV2", "(Ljava/util/List;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "mapDtosToFileActivityEntitiesWithReplies", "Lkotlin/Pair;", "Lcom/box/android/data/persistence/annotations/CommentEntity;", "apiModels", "Lcom/box/android/data/api/models/annotations/FileActivityDTO;", Location.TYPE_PAGE, "deleteOldFileActivities", "", "fetchedBefore", "Ljava/util/Date;", "(Ljava/lang/String;Ljava/util/Date;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Companion", "data_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class FileActivitiesService implements IFileActivitiesService {
    public static final String LOGTAG = "FileActivitiesService";
    private final CommentDTOEntityMapper commentDTOEntityMapper;
    private final CommentEntityDomainMapper commentEntityDomainMapper;
    private final FeatureFlips featureFlips;
    private final FileActivityCacheDataSource fileActivitiesCacheDataSource;
    private final FileActivityDTOEntityMapper fileActivitiesDTOEntityMapper;
    private final FileActivityRemoteDataSource fileActivitiesRemoteDataSource;
    private final FileActivityEntityDomainMapper fileActivityEntityDomainMapper;
    private final IdMappingService idMappingService;
    private final LocalItemService itemService;

    /* JADX INFO: renamed from: com.box.android.data.service.impl.FileActivitiesService$deleteOldFileActivities$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: FileActivitiesService.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.box.android.data.service.impl.FileActivitiesService", f = "FileActivitiesService.kt", i = {0, 0}, l = {258}, m = "deleteOldFileActivities", n = {"fileId", "fetchedBefore"}, s = {"L$0", "L$1"}, v = 1)
    static final class C14281 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        int label;
        /* synthetic */ Object result;

        C14281(Continuation<? super C14281> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return FileActivitiesService.this.deleteOldFileActivities(null, null, this);
        }
    }

    /* JADX INFO: renamed from: com.box.android.data.service.impl.FileActivitiesService$mapToFileActivityModelsV2$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: FileActivitiesService.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.box.android.data.service.impl.FileActivitiesService", f = "FileActivitiesService.kt", i = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, l = {BoxCommonConstants.REQUEST_INVITE_COLLABORATORS}, m = "mapToFileActivityModelsV2", n = {"input", "fileId", "$this$map$iv", "$this$mapTo$iv$iv", "destination$iv$iv", "item$iv$iv", "fileActivityEntities", "$i$f$map", "$i$f$mapTo", "$i$a$-map-FileActivitiesService$mapToFileActivityModelsV2$2"}, s = {"L$0", "L$1", "L$2", "L$3", "L$4", "L$6", "L$7", "I$0", "I$1", "I$2"}, v = 1)
    static final class C14291 extends ContinuationImpl {
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
        Object L$8;
        int label;
        /* synthetic */ Object result;

        C14291(Continuation<? super C14291> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return FileActivitiesService.this.mapToFileActivityModelsV2(null, null, this);
        }
    }

    /* JADX INFO: renamed from: com.box.android.data.service.impl.FileActivitiesService$replies$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: FileActivitiesService.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.box.android.data.service.impl.FileActivitiesService", f = "FileActivitiesService.kt", i = {0}, l = {83}, m = "replies", n = {"activityID"}, s = {"L$0"}, v = 1)
    static final class C14301 extends ContinuationImpl {
        Object L$0;
        int label;
        /* synthetic */ Object result;

        C14301(Continuation<? super C14301> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return FileActivitiesService.this.replies(null, this);
        }
    }

    @Inject
    public FileActivitiesService(FileActivityRemoteDataSource fileActivitiesRemoteDataSource, FileActivityCacheDataSource fileActivitiesCacheDataSource, LocalItemService itemService, FileActivityDTOEntityMapper fileActivitiesDTOEntityMapper, FileActivityEntityDomainMapper fileActivityEntityDomainMapper, CommentDTOEntityMapper commentDTOEntityMapper, CommentEntityDomainMapper commentEntityDomainMapper, IdMappingService idMappingService, FeatureFlips featureFlips) {
        Intrinsics.checkNotNullParameter(fileActivitiesRemoteDataSource, "fileActivitiesRemoteDataSource");
        Intrinsics.checkNotNullParameter(fileActivitiesCacheDataSource, "fileActivitiesCacheDataSource");
        Intrinsics.checkNotNullParameter(itemService, "itemService");
        Intrinsics.checkNotNullParameter(fileActivitiesDTOEntityMapper, "fileActivitiesDTOEntityMapper");
        Intrinsics.checkNotNullParameter(fileActivityEntityDomainMapper, "fileActivityEntityDomainMapper");
        Intrinsics.checkNotNullParameter(commentDTOEntityMapper, "commentDTOEntityMapper");
        Intrinsics.checkNotNullParameter(commentEntityDomainMapper, "commentEntityDomainMapper");
        Intrinsics.checkNotNullParameter(idMappingService, "idMappingService");
        Intrinsics.checkNotNullParameter(featureFlips, "featureFlips");
        this.fileActivitiesRemoteDataSource = fileActivitiesRemoteDataSource;
        this.fileActivitiesCacheDataSource = fileActivitiesCacheDataSource;
        this.itemService = itemService;
        this.fileActivitiesDTOEntityMapper = fileActivitiesDTOEntityMapper;
        this.fileActivityEntityDomainMapper = fileActivityEntityDomainMapper;
        this.commentDTOEntityMapper = commentDTOEntityMapper;
        this.commentEntityDomainMapper = commentEntityDomainMapper;
        this.idMappingService = idMappingService;
        this.featureFlips = featureFlips;
    }

    @Override // com.box.android.domain.services.IFileActivitiesService
    public Result<DataSource.Factory<Integer, FileActivityModel>, DomainError> activities(final String fileId) {
        Intrinsics.checkNotNullParameter(fileId, "fileId");
        Result<DataSource.Factory<Integer, FileActivityEntities>, CacheError> resultActivity = this.fileActivitiesCacheDataSource.activity(fileId);
        if (resultActivity instanceof Result.Success) {
            return new Result.Success(((DataSource.Factory) ((Result.Success) resultActivity).getValue()).mapByPage(new Function() { // from class: com.box.android.data.service.impl.FileActivitiesService$$ExternalSyntheticLambda0
                @Override // androidx.arch.core.util.Function
                public final Object apply(Object obj) {
                    return FileActivitiesService.activities$lambda$0(this.f$0, fileId, (List) obj);
                }
            }));
        }
        if (!(resultActivity instanceof Result.Error)) {
            throw new NoWhenBranchMatchedException();
        }
        return new Result.Error(DomainErrorMapper.toDomainError$default(DomainErrorMapper.INSTANCE, (IGenericError) ((Result.Error) resultActivity).getValue(), null, 2, null));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final List activities$lambda$0(FileActivitiesService fileActivitiesService, String str, List list) {
        Intrinsics.checkNotNull(list);
        return fileActivitiesService.mapToFileActivityModels(list, str);
    }

    /* JADX INFO: renamed from: com.box.android.data.service.impl.FileActivitiesService$activitiesV2$1, reason: invalid class name */
    /* JADX INFO: compiled from: FileActivitiesService.kt */
    @Metadata(d1 = {"\u0000\u001a\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u001a\u0012\u0016\u0012\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u0004\u0012\u0004\u0012\u00020\u00060\u00030\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/flow/FlowCollector;", "Lcom/box/android/domain/utils/result/Result;", "", "Lcom/box/android/domain/models/annotations/FileActivityModel;", "Lcom/box/android/domain/models/DomainError;"}, k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.box.android.data.service.impl.FileActivitiesService$activitiesV2$1", f = "FileActivitiesService.kt", i = {0, 1, 1, 1, 2, 2, 2}, l = {70, 71, 78}, m = "invokeSuspend", n = {"$this$flow", "$this$flow", "boxId", "$i$a$-let-FileActivitiesService$activitiesV2$1$1", "$this$flow", "$this$invokeSuspend_u24lambda_u241", "$i$a$-run-FileActivitiesService$activitiesV2$1$2"}, s = {"L$0", "L$0", "L$1", "I$0", "L$0", "L$1", "I$0"}, v = 1)
    static final class AnonymousClass1 extends SuspendLambda implements Function2<FlowCollector<? super Result<? extends List<? extends FileActivityModel>, ? extends DomainError>>, Continuation<? super Unit>, Object> {
        final /* synthetic */ ItemId $fileItemId;
        int I$0;
        private /* synthetic */ Object L$0;
        Object L$1;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(ItemId itemId, Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
            this.$fileItemId = itemId;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            AnonymousClass1 anonymousClass1 = FileActivitiesService.this.new AnonymousClass1(this.$fileItemId, continuation);
            anonymousClass1.L$0 = obj;
            return anonymousClass1;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(FlowCollector<? super Result<? extends List<? extends FileActivityModel>, ? extends DomainError>> flowCollector, Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(flowCollector, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Code restructure failed: missing block: B:21:0x0073, code lost:
        
            if (kotlinx.coroutines.flow.FlowKt.emitAll(r0, r6, r7) == r1) goto L25;
         */
        /* JADX WARN: Code restructure failed: missing block: B:24:0x0096, code lost:
        
            if (r0.emit(r8, r7) == r1) goto L25;
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
                if (r2 == 0) goto L2e
                if (r2 == r5) goto L2a
                if (r2 == r4) goto L22
                if (r2 != r3) goto L1a
                java.lang.Object r7 = r7.L$1
                kotlinx.coroutines.flow.FlowCollector r7 = (kotlinx.coroutines.flow.FlowCollector) r7
                goto L26
            L1a:
                java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
                java.lang.String r8 = "call to 'resume' before 'invoke' with coroutine"
                r7.<init>(r8)
                throw r7
            L22:
                java.lang.Object r7 = r7.L$1
                java.lang.String r7 = (java.lang.String) r7
            L26:
                kotlin.ResultKt.throwOnFailure(r8)
                goto L99
            L2a:
                kotlin.ResultKt.throwOnFailure(r8)
                goto L47
            L2e:
                kotlin.ResultKt.throwOnFailure(r8)
                com.box.android.data.service.impl.FileActivitiesService r8 = com.box.android.data.service.impl.FileActivitiesService.this
                com.box.android.domain.services.IdMappingService r8 = com.box.android.data.service.impl.FileActivitiesService.access$getIdMappingService$p(r8)
                com.box.android.domain.models.ItemId r2 = r7.$fileItemId
                r6 = r7
                kotlin.coroutines.Continuation r6 = (kotlin.coroutines.Continuation) r6
                r7.L$0 = r0
                r7.label = r5
                java.lang.Object r8 = r8.getRemoteId(r2, r6)
                if (r8 != r1) goto L47
                goto L98
            L47:
                com.box.android.domain.models.ItemId$Remote r8 = (com.box.android.domain.models.ItemId.Remote) r8
                r2 = 0
                if (r8 == 0) goto L76
                java.lang.String r8 = r8.getBoxId()
                if (r8 == 0) goto L76
                com.box.android.data.service.impl.FileActivitiesService r3 = com.box.android.data.service.impl.FileActivitiesService.this
                com.box.android.data.datasource.annotations.FileActivityCacheDataSource r5 = com.box.android.data.service.impl.FileActivitiesService.access$getFileActivitiesCacheDataSource$p(r3)
                kotlinx.coroutines.flow.Flow r5 = r5.activities(r8)
                com.box.android.data.service.impl.FileActivitiesService$activitiesV2$1$invokeSuspend$lambda$0$$inlined$map$1 r6 = new com.box.android.data.service.impl.FileActivitiesService$activitiesV2$1$invokeSuspend$lambda$0$$inlined$map$1
                r6.<init>()
                kotlinx.coroutines.flow.Flow r6 = (kotlinx.coroutines.flow.Flow) r6
                r7.L$0 = r0
                java.lang.Object r8 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r8)
                r7.L$1 = r8
                r7.I$0 = r2
                r7.label = r4
                java.lang.Object r7 = kotlinx.coroutines.flow.FlowKt.emitAll(r0, r6, r7)
                if (r7 != r1) goto L99
                goto L98
            L76:
                com.box.android.domain.utils.result.Result$Error r8 = new com.box.android.domain.utils.result.Result$Error
                com.box.android.domain.models.DomainError$ItemRemoteIdIsNull r4 = new com.box.android.domain.models.DomainError$ItemRemoteIdIsNull
                java.lang.String r5 = "Activities can not be fetched for local files"
                r4.<init>(r5)
                r8.<init>(r4)
                java.lang.Object r4 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r0)
                r7.L$0 = r4
                java.lang.Object r4 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r0)
                r7.L$1 = r4
                r7.I$0 = r2
                r7.label = r3
                java.lang.Object r7 = r0.emit(r8, r7)
                if (r7 != r1) goto L99
            L98:
                return r1
            L99:
                kotlin.Unit r7 = kotlin.Unit.INSTANCE
                return r7
            */
            throw new UnsupportedOperationException("Method not decompiled: com.box.android.data.service.impl.FileActivitiesService.AnonymousClass1.invokeSuspend(java.lang.Object):java.lang.Object");
        }
    }

    @Override // com.box.android.domain.services.IFileActivitiesService
    public Flow<Result<List<FileActivityModel>, DomainError>> activitiesV2(ItemId fileItemId) {
        Intrinsics.checkNotNullParameter(fileItemId, "fileItemId");
        return FlowKt.flow(new AnonymousClass1(fileItemId, null));
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    @Override // com.box.android.domain.services.IFileActivitiesService
    public Object replies(String str, Continuation<? super Result<? extends List<FileActivityModel.CommentModel>, ? extends DomainError>> continuation) {
        C14301 c14301;
        if (continuation instanceof C14301) {
            c14301 = (C14301) continuation;
            if ((c14301.label & Integer.MIN_VALUE) != 0) {
                c14301.label -= Integer.MIN_VALUE;
            } else {
                c14301 = new C14301(continuation);
            }
        } else {
            c14301 = new C14301(continuation);
        }
        Object objReplies = c14301.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = c14301.label;
        if (i == 0) {
            ResultKt.throwOnFailure(objReplies);
            FileActivityCacheDataSource fileActivityCacheDataSource = this.fileActivitiesCacheDataSource;
            c14301.L$0 = SpillingKt.nullOutSpilledVariable(str);
            c14301.label = 1;
            objReplies = fileActivityCacheDataSource.replies(str, c14301);
            if (objReplies == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(objReplies);
        }
        Result.Success success = (Result) objReplies;
        if (success instanceof Result.Success) {
            List list = (List) ((Result.Success) success).getValue();
            ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
            Iterator it = list.iterator();
            while (it.hasNext()) {
                arrayList.add(this.commentEntityDomainMapper.toDomain((CommentEntity) it.next()));
            }
            success = new Result.Success(arrayList);
        } else if (!(success instanceof Result.Error)) {
            throw new NoWhenBranchMatchedException();
        }
        if (success instanceof Result.Success) {
            return success;
        }
        if (!(success instanceof Result.Error)) {
            throw new NoWhenBranchMatchedException();
        }
        return new Result.Error(DomainErrorMapper.toDomainError$default(DomainErrorMapper.INSTANCE, (CacheError) ((Result.Error) success).getValue(), null, 2, null));
    }

    /* JADX INFO: renamed from: com.box.android.data.service.impl.FileActivitiesService$fetchActivitiesFromRemote$2, reason: invalid class name */
    /* JADX INFO: compiled from: FileActivitiesService.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001*\u00020\u0004H\n"}, d2 = {"<anonymous>", "Lcom/box/android/domain/utils/result/Result;", "", "Lcom/box/android/domain/models/DomainError;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.box.android.data.service.impl.FileActivitiesService$fetchActivitiesFromRemote$2", f = "FileActivitiesService.kt", i = {1, 1, 1, 1, 1, 2, 2, 2, 2, 2, 2}, l = {88, 101, 201}, m = "invokeSuspend", n = {"fileId", ReactNativeFeatureActivity.RESULT_EXTRA_KEY, "networkOpStartTime", "fetchDomainError", "types", "fileId", ReactNativeFeatureActivity.RESULT_EXTRA_KEY, "networkOpStartTime", "fetchDomainError", "types", Location.TYPE_PAGE}, s = {"L$0", "L$1", "L$2", "L$3", "L$4", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5"}, v = 1)
    static final class AnonymousClass2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Result<? extends Unit, ? extends DomainError>>, Object> {
        final /* synthetic */ ItemId $fileItemId;
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        Object L$4;
        Object L$5;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass2(ItemId itemId, Continuation<? super AnonymousClass2> continuation) {
            super(2, continuation);
            this.$fileItemId = itemId;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return FileActivitiesService.this.new AnonymousClass2(this.$fileItemId, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Object invoke(CoroutineScope coroutineScope, Continuation<? super Result<? extends Unit, ? extends DomainError>> continuation) {
            return invoke2(coroutineScope, (Continuation<? super Result<Unit, ? extends DomainError>>) continuation);
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(CoroutineScope coroutineScope, Continuation<? super Result<Unit, ? extends DomainError>> continuation) {
            return ((AnonymousClass2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Code duplicated, block: B:31:0x00ed  */
        /* JADX WARN: Code duplicated, block: B:37:0x010f  */
        /* JADX WARN: Code duplicated, block: B:38:0x0115  */
        /* JADX WARN: Code duplicated, block: B:39:0x011b  */
        /* JADX WARN: Code duplicated, block: B:44:0x0189  */
        /* JADX WARN: Code duplicated, block: B:47:0x0190  */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws UnsupportedEncodingException {
            Object remoteId;
            String boxId;
            Ref.ObjectRef objectRef;
            Date date;
            List<? extends ActivityType> listMutableListOf;
            Object objItem;
            FileActivityDomainError.CouldNotFetchActivityError couldNotFetchActivityError;
            Date date2;
            Ref.ObjectRef objectRef2;
            String str;
            Result result;
            FileActivitiesService fileActivitiesService;
            Ref.IntRef intRef;
            Ref.ObjectRef objectRef3;
            PermissionsModel permissions;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                this.label = 1;
                remoteId = FileActivitiesService.this.idMappingService.getRemoteId(this.$fileItemId, this);
                if (remoteId != coroutine_suspended) {
                }
                return coroutine_suspended;
            }
            if (i == 1) {
                ResultKt.throwOnFailure(obj);
                remoteId = obj;
            } else {
                if (i == 2) {
                    listMutableListOf = (List) this.L$4;
                    FileActivityDomainError.CouldNotFetchActivityError couldNotFetchActivityError2 = (FileActivityDomainError.CouldNotFetchActivityError) this.L$3;
                    date = (Date) this.L$2;
                    objectRef = (Ref.ObjectRef) this.L$1;
                    boxId = (String) this.L$0;
                    ResultKt.throwOnFailure(obj);
                    couldNotFetchActivityError = couldNotFetchActivityError2;
                    objItem = obj;
                    date2 = date;
                    objectRef2 = objectRef;
                    str = boxId;
                    result = (Result) objItem;
                    fileActivitiesService = FileActivitiesService.this;
                    if (result instanceof Result.Success) {
                        permissions = ((ItemModel) ((Result.Success) result).getValue()).getPermissions();
                        if (permissions != null && permissions.getCanViewAnnotations()) {
                            if (fileActivitiesService.featureFlips.getVideoAnnotations().getEnabled()) {
                                listMutableListOf.add(ActivityType.ENHANCED_ANNOTATION);
                            } else {
                                listMutableListOf.add(ActivityType.ANNOTATION);
                            }
                        }
                    } else if (!(result instanceof Result.Error)) {
                        throw new NoWhenBranchMatchedException();
                    }
                    intRef = new Ref.IntRef();
                    this.L$0 = SpillingKt.nullOutSpilledVariable(str);
                    this.L$1 = objectRef2;
                    this.L$2 = SpillingKt.nullOutSpilledVariable(date2);
                    this.L$3 = SpillingKt.nullOutSpilledVariable(couldNotFetchActivityError);
                    this.L$4 = SpillingKt.nullOutSpilledVariable(listMutableListOf);
                    this.L$5 = SpillingKt.nullOutSpilledVariable(intRef);
                    this.label = 3;
                    if (FlowKt.collect(FlowKt.m16356catch(FlowKt.onCompletion(FlowKt.onEach(FileActivitiesService.this.fileActivitiesRemoteDataSource.getFileActivity(str, listMutableListOf), new C01672(FileActivitiesService.this, str, intRef, couldNotFetchActivityError, objectRef2, null)), new AnonymousClass3(objectRef2, FileActivitiesService.this, str, date2, null)), new AnonymousClass4(objectRef2, FileActivitiesService.this, null)), this) != coroutine_suspended) {
                        objectRef3 = objectRef2;
                    }
                    return coroutine_suspended;
                }
                if (i != 3) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                objectRef3 = (Ref.ObjectRef) this.L$1;
                ResultKt.throwOnFailure(obj);
            }
            T t = objectRef3.element;
            Intrinsics.checkNotNull(t);
            return t;
            ItemId.Remote remote = (ItemId.Remote) remoteId;
            if (remote == null || (boxId = remote.getBoxId()) == null) {
                return new Result.Error(new DomainError.ItemRemoteIdIsNull("Activities can not be fetched for local files"));
            }
            objectRef = new Ref.ObjectRef();
            date = new Date();
            FileActivityDomainError.CouldNotFetchActivityError couldNotFetchActivityError3 = new FileActivityDomainError.CouldNotFetchActivityError(false, false, false, 7, null);
            listMutableListOf = CollectionsKt.mutableListOf(ActivityType.VERSIONS);
            if (FileActivitiesService.this.featureFlips.getVideoAnnotations().getEnabled()) {
                listMutableListOf.add(ActivityType.ENHANCED_COMMENT);
            } else {
                listMutableListOf.add(ActivityType.COMMENT);
            }
            this.L$0 = boxId;
            this.L$1 = objectRef;
            this.L$2 = date;
            this.L$3 = couldNotFetchActivityError3;
            this.L$4 = listMutableListOf;
            this.label = 2;
            objItem = FileActivitiesService.this.itemService.item(new ItemId.Remote(boxId, ItemType.FILE), DataPolicy.CACHE, this);
            if (objItem != coroutine_suspended) {
                couldNotFetchActivityError = couldNotFetchActivityError3;
                date2 = date;
                objectRef2 = objectRef;
                str = boxId;
                result = (Result) objItem;
                fileActivitiesService = FileActivitiesService.this;
                if (result instanceof Result.Success) {
                    permissions = ((ItemModel) ((Result.Success) result).getValue()).getPermissions();
                    if (permissions != null) {
                        if (fileActivitiesService.featureFlips.getVideoAnnotations().getEnabled()) {
                            listMutableListOf.add(ActivityType.ENHANCED_ANNOTATION);
                        } else {
                            listMutableListOf.add(ActivityType.ANNOTATION);
                        }
                    }
                } else if (!(result instanceof Result.Error)) {
                    throw new NoWhenBranchMatchedException();
                }
                intRef = new Ref.IntRef();
                this.L$0 = SpillingKt.nullOutSpilledVariable(str);
                this.L$1 = objectRef2;
                this.L$2 = SpillingKt.nullOutSpilledVariable(date2);
                this.L$3 = SpillingKt.nullOutSpilledVariable(couldNotFetchActivityError);
                this.L$4 = SpillingKt.nullOutSpilledVariable(listMutableListOf);
                this.L$5 = SpillingKt.nullOutSpilledVariable(intRef);
                this.label = 3;
                if (FlowKt.collect(FlowKt.m16356catch(FlowKt.onCompletion(FlowKt.onEach(FileActivitiesService.this.fileActivitiesRemoteDataSource.getFileActivity(str, listMutableListOf), new C01672(FileActivitiesService.this, str, intRef, couldNotFetchActivityError, objectRef2, null)), new AnonymousClass3(objectRef2, FileActivitiesService.this, str, date2, null)), new AnonymousClass4(objectRef2, FileActivitiesService.this, null)), this) != coroutine_suspended) {
                    objectRef3 = objectRef2;
                    T t2 = objectRef3.element;
                    Intrinsics.checkNotNull(t2);
                    return t2;
                }
            }
            return coroutine_suspended;
        }

        /* JADX INFO: renamed from: com.box.android.data.service.impl.FileActivitiesService$fetchActivitiesFromRemote$2$2, reason: invalid class name and collision with other inner class name */
        /* JADX INFO: compiled from: FileActivitiesService.kt */
        @Metadata(d1 = {"\u0000\u0018\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\u0018\u0010\u0002\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u0004\u0012\u0004\u0012\u00020\u00060\u0003H\n"}, d2 = {"<anonymous>", "", "remoteCallResult", "Lcom/box/android/domain/utils/result/Result;", "", "Lcom/box/android/data/api/models/annotations/FileActivityDTO;", "Lcom/box/android/data/datasource/errors/RemoteError;"}, k = 3, mv = {2, 2, 0}, xi = 48)
        @DebugMetadata(c = "com.box.android.data.service.impl.FileActivitiesService$fetchActivitiesFromRemote$2$2", f = "FileActivitiesService.kt", i = {0, 0, 0, 0, 0}, l = {125}, m = "invokeSuspend", n = {"remoteCallResult", "$this$flatMap$iv", "fileActivityEntitiesWithReplies", "$i$f$flatMap", "$i$a$-flatMap-FileActivitiesService$fetchActivitiesFromRemote$2$2$2"}, s = {"L$0", "L$1", "L$2", "I$0", "I$1"}, v = 1)
        static final class C01672 extends SuspendLambda implements Function2<Result<? extends List<? extends FileActivityDTO>, ? extends RemoteError>, Continuation<? super Unit>, Object> {
            final /* synthetic */ FileActivityDomainError.CouldNotFetchActivityError $fetchDomainError;
            final /* synthetic */ String $fileId;
            final /* synthetic */ Ref.IntRef $page;
            final /* synthetic */ Ref.ObjectRef<Result<Unit, DomainError>> $result;
            int I$0;
            int I$1;
            /* synthetic */ Object L$0;
            Object L$1;
            Object L$2;
            int label;
            final /* synthetic */ FileActivitiesService this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            C01672(FileActivitiesService fileActivitiesService, String str, Ref.IntRef intRef, FileActivityDomainError.CouldNotFetchActivityError couldNotFetchActivityError, Ref.ObjectRef<Result<Unit, DomainError>> objectRef, Continuation<? super C01672> continuation) {
                super(2, continuation);
                this.this$0 = fileActivitiesService;
                this.$fileId = str;
                this.$page = intRef;
                this.$fetchDomainError = couldNotFetchActivityError;
                this.$result = objectRef;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                C01672 c01672 = new C01672(this.this$0, this.$fileId, this.$page, this.$fetchDomainError, this.$result, continuation);
                c01672.L$0 = obj;
                return c01672;
            }

            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(Result<? extends List<? extends FileActivityDTO>, ? extends RemoteError> result, Continuation<? super Unit> continuation) {
                return ((C01672) create(result, continuation)).invokeSuspend(Unit.INSTANCE);
            }

            /* JADX WARN: Code duplicated, block: B:25:0x0095  */
            /* JADX WARN: Code duplicated, block: B:27:0x0099  */
            /* JADX WARN: Code duplicated, block: B:29:0x00a5  */
            /* JADX WARN: Code duplicated, block: B:30:0x00b1  */
            /* JADX WARN: Code duplicated, block: B:32:0x00b5  */
            /* JADX WARN: Code duplicated, block: B:34:0x00bc  */
            /* JADX WARN: Code duplicated, block: B:36:0x00c6  */
            /* JADX WARN: Code duplicated, block: B:38:0x00ca  */
            /* JADX WARN: Code duplicated, block: B:39:0x00d3  */
            /* JADX WARN: Code duplicated, block: B:41:0x00d7  */
            /* JADX WARN: Code duplicated, block: B:42:0x00e0  */
            /* JADX WARN: Code duplicated, block: B:43:0x00ec  */
            /* JADX WARN: Code duplicated, block: B:47:0x0106  */
            /* JADX WARN: Code duplicated, block: B:49:0x010a  */
            /* JADX WARN: Code duplicated, block: B:52:0x011d  */
            /* JADX WARN: Code duplicated, block: B:54:0x0125  */
            /* JADX WARN: Code duplicated, block: B:58:0x012e  */
            /* JADX WARN: Type inference failed for: r9v12, types: [T, com.box.android.domain.utils.result.Result$Error] */
            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object obj) throws AbortFlowCollectionException {
                Result.Success success;
                FileActivityDomainError.CouldNotFetchActivityError couldNotFetchActivityError;
                Ref.ObjectRef<Result<Unit, DomainError>> objectRef;
                ?? r9;
                IGenericError iGenericError;
                Result.Error error;
                RemoteError remoteError;
                Result.Error error2;
                Result result = (Result) this.L$0;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                int i = this.label;
                if (i == 0) {
                    ResultKt.throwOnFailure(obj);
                    FileActivitiesService fileActivitiesService = this.this$0;
                    String str = this.$fileId;
                    Ref.IntRef intRef = this.$page;
                    if (result instanceof Result.Success) {
                        List list = (List) ((Result.Success) result).getValue();
                        int i2 = intRef.element;
                        intRef.element = i2 + 1;
                        success = new Result.Success(fileActivitiesService.mapDtosToFileActivityEntitiesWithReplies(list, str, i2));
                    } else {
                        if (!(result instanceof Result.Error)) {
                            throw new NoWhenBranchMatchedException();
                        }
                        success = result;
                    }
                    FileActivitiesService fileActivitiesService2 = this.this$0;
                    if (success instanceof Result.Success) {
                        List<? extends Pair<FileActivityEntities, ? extends List<CommentEntity>>> list2 = (List) ((Result.Success) success).getValue();
                        FileActivityCacheDataSource fileActivityCacheDataSource = fileActivitiesService2.fileActivitiesCacheDataSource;
                        this.L$0 = SpillingKt.nullOutSpilledVariable(result);
                        this.L$1 = SpillingKt.nullOutSpilledVariable(success);
                        this.L$2 = SpillingKt.nullOutSpilledVariable(list2);
                        this.I$0 = 0;
                        this.I$1 = 0;
                        this.label = 1;
                        obj = fileActivityCacheDataSource.saveActivitiesWithReplies(list2, this);
                        if (obj == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                    } else if (!(success instanceof Result.Error)) {
                        throw new NoWhenBranchMatchedException();
                    }
                    couldNotFetchActivityError = this.$fetchDomainError;
                    if (!(success instanceof Result.Success)) {
                        if (success instanceof Result.Error) {
                            iGenericError = (IGenericError) ((Result.Error) success).getValue();
                            if (iGenericError instanceof CacheError) {
                                error = new Result.Error(DomainErrorMapper.toDomainError$default(DomainErrorMapper.INSTANCE, iGenericError, null, 2, null));
                            } else if (iGenericError instanceof RemoteError) {
                                remoteError = (RemoteError) iGenericError;
                                if (remoteError instanceof AnnotationsRemoteError.AnnotationFetchError) {
                                    couldNotFetchActivityError.setAnnotationNotFetched(true);
                                    error2 = new Result.Error(couldNotFetchActivityError);
                                } else if (remoteError instanceof AnnotationsRemoteError.VersionsFetchError) {
                                    couldNotFetchActivityError.setVersionsNotFetched(true);
                                    error2 = new Result.Error(couldNotFetchActivityError);
                                } else if (remoteError instanceof AnnotationsRemoteError.CommentsFetchError) {
                                    couldNotFetchActivityError.setCommentsNotFetched(true);
                                    error2 = new Result.Error(couldNotFetchActivityError);
                                } else {
                                    error = new Result.Error(DomainErrorMapper.toDomainError$default(DomainErrorMapper.INSTANCE, iGenericError, null, 2, null));
                                }
                                error = error2;
                            } else {
                                error = new Result.Error(new DomainError.UnknownError("Unknown error while fetching annotations"));
                            }
                            success = new Result.Error(error);
                        } else {
                            throw new NoWhenBranchMatchedException();
                        }
                    }
                    objectRef = this.$result;
                    if (!(success instanceof Result.Success)) {
                        if (success instanceof Result.Error) {
                            throw new NoWhenBranchMatchedException();
                        }
                        r9 = (Result.Error) ((Result.Error) success).getValue();
                        objectRef.element = r9;
                        if (!(r9.getValue() instanceof FileActivityDomainError.CouldNotFetchActivityError)) {
                            throw new AbortFlowCollectionException("Abort flow processing", null, 2, null);
                        }
                    }
                    return Unit.INSTANCE;
                }
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
                success = (Result) obj;
                couldNotFetchActivityError = this.$fetchDomainError;
                if (!(success instanceof Result.Success)) {
                    if (success instanceof Result.Error) {
                        iGenericError = (IGenericError) ((Result.Error) success).getValue();
                        if (iGenericError instanceof CacheError) {
                            error = new Result.Error(DomainErrorMapper.toDomainError$default(DomainErrorMapper.INSTANCE, iGenericError, null, 2, null));
                        } else if (iGenericError instanceof RemoteError) {
                            remoteError = (RemoteError) iGenericError;
                            if (remoteError instanceof AnnotationsRemoteError.AnnotationFetchError) {
                                couldNotFetchActivityError.setAnnotationNotFetched(true);
                                error2 = new Result.Error(couldNotFetchActivityError);
                            } else if (remoteError instanceof AnnotationsRemoteError.VersionsFetchError) {
                                couldNotFetchActivityError.setVersionsNotFetched(true);
                                error2 = new Result.Error(couldNotFetchActivityError);
                            } else if (remoteError instanceof AnnotationsRemoteError.CommentsFetchError) {
                                couldNotFetchActivityError.setCommentsNotFetched(true);
                                error2 = new Result.Error(couldNotFetchActivityError);
                            } else {
                                error = new Result.Error(DomainErrorMapper.toDomainError$default(DomainErrorMapper.INSTANCE, iGenericError, null, 2, null));
                            }
                            error = error2;
                        } else {
                            error = new Result.Error(new DomainError.UnknownError("Unknown error while fetching annotations"));
                        }
                        success = new Result.Error(error);
                    } else {
                        throw new NoWhenBranchMatchedException();
                    }
                }
                objectRef = this.$result;
                if (!(success instanceof Result.Success)) {
                    if (success instanceof Result.Error) {
                        throw new NoWhenBranchMatchedException();
                    }
                    r9 = (Result.Error) ((Result.Error) success).getValue();
                    objectRef.element = r9;
                    if (!(r9.getValue() instanceof FileActivityDomainError.CouldNotFetchActivityError)) {
                        throw new AbortFlowCollectionException("Abort flow processing", null, 2, null);
                    }
                }
                return Unit.INSTANCE;
            }
        }

        /* JADX INFO: renamed from: com.box.android.data.service.impl.FileActivitiesService$fetchActivitiesFromRemote$2$3, reason: invalid class name */
        /* JADX INFO: compiled from: FileActivitiesService.kt */
        @Metadata(d1 = {"\u0000 \n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0003\u0010\u0000\u001a\u00020\u0001*\u001a\u0012\u0016\u0012\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u0004\u0012\u0004\u0012\u00020\u00060\u00030\u00022\b\u0010\u0007\u001a\u0004\u0018\u00010\bH\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/flow/FlowCollector;", "Lcom/box/android/domain/utils/result/Result;", "", "Lcom/box/android/data/api/models/annotations/FileActivityDTO;", "Lcom/box/android/data/datasource/errors/RemoteError;", "cause", ""}, k = 3, mv = {2, 2, 0}, xi = 48)
        @DebugMetadata(c = "com.box.android.data.service.impl.FileActivitiesService$fetchActivitiesFromRemote$2$3", f = "FileActivitiesService.kt", i = {0, 0, 0, 0, 0, 1, 1, 1, 1, 1}, l = {187, 193}, m = "invokeSuspend", n = {"cause", "$this$onSuccess$iv", "it", "$i$f$onSuccess", "$i$a$-onSuccess-FileActivitiesService$fetchActivitiesFromRemote$2$3$1", "cause", "$this$onError$iv", "it", "$i$f$onError", "$i$a$-onError-FileActivitiesService$fetchActivitiesFromRemote$2$3$2"}, s = {"L$0", "L$1", "L$2", "I$0", "I$1", "L$0", "L$1", "L$2", "I$0", "I$1"}, v = 1)
        static final class AnonymousClass3 extends SuspendLambda implements Function3<FlowCollector<? super Result<? extends List<? extends FileActivityDTO>, ? extends RemoteError>>, Throwable, Continuation<? super Unit>, Object> {
            final /* synthetic */ String $fileId;
            final /* synthetic */ Date $networkOpStartTime;
            final /* synthetic */ Ref.ObjectRef<Result<Unit, DomainError>> $result;
            int I$0;
            int I$1;
            /* synthetic */ Object L$0;
            Object L$1;
            Object L$2;
            int label;
            final /* synthetic */ FileActivitiesService this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            AnonymousClass3(Ref.ObjectRef<Result<Unit, DomainError>> objectRef, FileActivitiesService fileActivitiesService, String str, Date date, Continuation<? super AnonymousClass3> continuation) {
                super(3, continuation);
                this.$result = objectRef;
                this.this$0 = fileActivitiesService;
                this.$fileId = str;
                this.$networkOpStartTime = date;
            }

            @Override // kotlin.jvm.functions.Function3
            public final Object invoke(FlowCollector<? super Result<? extends List<? extends FileActivityDTO>, ? extends RemoteError>> flowCollector, Throwable th, Continuation<? super Unit> continuation) {
                AnonymousClass3 anonymousClass3 = new AnonymousClass3(this.$result, this.this$0, this.$fileId, this.$networkOpStartTime, continuation);
                anonymousClass3.L$0 = th;
                return anonymousClass3.invokeSuspend(Unit.INSTANCE);
            }

            /* JADX WARN: Code duplicated, block: B:24:0x0090  */
            /* JADX WARN: Code duplicated, block: B:26:0x0094  */
            /* JADX WARN: Code duplicated, block: B:28:0x00a1  */
            /* JADX WARN: Code duplicated, block: B:31:0x00bc  */
            /* JADX WARN: Code restructure failed: missing block: B:29:0x00b9, code lost:
            
                if (r11.deleteOldFileActivities(r4, r6, r10) == r1) goto L30;
             */
            /* JADX WARN: Type inference failed for: r2v3, types: [T, com.box.android.domain.utils.result.Result$Success] */
            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct add '--show-bad-code' argument
            */
            public final java.lang.Object invokeSuspend(java.lang.Object r11) {
                /*
                    Method dump skipped, instruction units count: 203
                    To view this dump add '--comments-level debug' option
                */
                throw new UnsupportedOperationException("Method not decompiled: com.box.android.data.service.impl.FileActivitiesService.AnonymousClass2.AnonymousClass3.invokeSuspend(java.lang.Object):java.lang.Object");
            }
        }

        /* JADX INFO: renamed from: com.box.android.data.service.impl.FileActivitiesService$fetchActivitiesFromRemote$2$4, reason: invalid class name */
        /* JADX INFO: compiled from: FileActivitiesService.kt */
        @Metadata(d1 = {"\u0000 \n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0003\u0010\u0000\u001a\u00020\u0001*\u001a\u0012\u0016\u0012\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u0004\u0012\u0004\u0012\u00020\u00060\u00030\u00022\u0006\u0010\u0007\u001a\u00020\bH\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/flow/FlowCollector;", "Lcom/box/android/domain/utils/result/Result;", "", "Lcom/box/android/data/api/models/annotations/FileActivityDTO;", "Lcom/box/android/data/datasource/errors/RemoteError;", "cause", ""}, k = 3, mv = {2, 2, 0}, xi = 48)
        @DebugMetadata(c = "com.box.android.data.service.impl.FileActivitiesService$fetchActivitiesFromRemote$2$4", f = "FileActivitiesService.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {}, v = 1)
        static final class AnonymousClass4 extends SuspendLambda implements Function3<FlowCollector<? super Result<? extends List<? extends FileActivityDTO>, ? extends RemoteError>>, Throwable, Continuation<? super Unit>, Object> {
            final /* synthetic */ Ref.ObjectRef<Result<Unit, DomainError>> $result;
            /* synthetic */ Object L$0;
            int label;
            final /* synthetic */ FileActivitiesService this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            AnonymousClass4(Ref.ObjectRef<Result<Unit, DomainError>> objectRef, FileActivitiesService fileActivitiesService, Continuation<? super AnonymousClass4> continuation) {
                super(3, continuation);
                this.$result = objectRef;
                this.this$0 = fileActivitiesService;
            }

            @Override // kotlin.jvm.functions.Function3
            public final Object invoke(FlowCollector<? super Result<? extends List<? extends FileActivityDTO>, ? extends RemoteError>> flowCollector, Throwable th, Continuation<? super Unit> continuation) {
                AnonymousClass4 anonymousClass4 = new AnonymousClass4(this.$result, this.this$0, continuation);
                anonymousClass4.L$0 = th;
                return anonymousClass4.invokeSuspend(Unit.INSTANCE);
            }

            /* JADX WARN: Multi-variable type inference failed */
            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object obj) {
                T tHandleException;
                Throwable th = (Throwable) this.L$0;
                IntrinsicsKt.getCOROUTINE_SUSPENDED();
                if (this.label != 0) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
                Ref.ObjectRef<Result<Unit, DomainError>> objectRef = this.$result;
                Result<Unit, DomainError> result = objectRef.element;
                if (result == null) {
                    tHandleException = result;
                    tHandleException = this.this$0.handleException(th);
                }
                tHandleException = result;
                objectRef.element = tHandleException;
                return Unit.INSTANCE;
            }
        }
    }

    @Override // com.box.android.domain.services.IFileActivitiesService
    public Object fetchActivitiesFromRemote(ItemId itemId, Continuation<? super Result<Unit, ? extends DomainError>> continuation) {
        return BuildersKt.withContext(Dispatchers.getIO(), new AnonymousClass2(itemId, null), continuation);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Result.Error<DomainError> handleException(Throwable cause) {
        BoxLogUtils.e(LOGTAG, cause);
        String message = cause.getMessage();
        if (message == null) {
            message = MicrosoftAuthorizationErrorResponse.UNKNOWN_ERROR;
        }
        return new Result.Error<>(new DomainError.UnknownError(message));
    }

    public final List<FileActivityModel> mapToFileActivityModels(List<FileActivityEntities> input, String fileId) {
        Intrinsics.checkNotNullParameter(input, "input");
        Intrinsics.checkNotNullParameter(fileId, "fileId");
        List<FileActivityEntities> list = input;
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
        Iterator<T> it = list.iterator();
        while (it.hasNext()) {
            String str = fileId;
            arrayList.add(FileActivityEntityDomainMapper.toDomain$default(this.fileActivityEntityDomainMapper, (FileActivityEntities) it.next(), str, null, 4, null));
            fileId = str;
        }
        return arrayList;
    }

    /* JADX WARN: Code duplicated, block: B:17:0x0093  */
    /* JADX WARN: Code duplicated, block: B:19:0x00d6 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:20:0x00d7  */
    /* JADX WARN: Code duplicated, block: B:23:0x00e4  */
    /* JADX WARN: Code duplicated, block: B:7:0x0018  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:20:0x00d7 -> B:21:0x00da). Please report as a decompilation issue!!! */
    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions stack size limit reached
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        */
    public final java.lang.Object mapToFileActivityModelsV2(java.util.List<com.box.android.data.persistence.annotations.FileActivityEntities> r18, java.lang.String r19, kotlin.coroutines.Continuation<? super java.util.List<? extends com.box.android.domain.models.annotations.FileActivityModel>> r20) {
        /*
            Method dump skipped, instruction units count: 248
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.box.android.data.service.impl.FileActivitiesService.mapToFileActivityModelsV2(java.util.List, java.lang.String, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final List<Pair<FileActivityEntities, List<CommentEntity>>> mapDtosToFileActivityEntitiesWithReplies(List<? extends FileActivityDTO> apiModels, String fileId, int page) {
        List<CommentDTO> listEmptyList;
        int i = page * 100;
        List<? extends FileActivityDTO> list = apiModels;
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
        for (FileActivityDTO fileActivityDTO : list) {
            if (fileActivityDTO instanceof FileActivityDTO.AnnotationActivityDTO) {
                listEmptyList = ((FileActivityDTO.AnnotationActivityDTO) fileActivityDTO).getSource().getAnnotation().getReplies();
            } else if (fileActivityDTO instanceof FileActivityDTO.EnhancedAnnotationActivityDTO) {
                listEmptyList = ((FileActivityDTO.EnhancedAnnotationActivityDTO) fileActivityDTO).getSource().getEnhancedAnnotation().getReplies();
            } else if (fileActivityDTO instanceof FileActivityDTO.CommentActivityDTO) {
                listEmptyList = ((FileActivityDTO.CommentActivityDTO) fileActivityDTO).getSource().getComment().getReplies();
            } else if (fileActivityDTO instanceof FileActivityDTO.EnhancedCommentActivityDTO) {
                listEmptyList = ((FileActivityDTO.EnhancedCommentActivityDTO) fileActivityDTO).getSource().getEnhancedComment().getReplies();
            } else {
                if (!(fileActivityDTO instanceof FileActivityDTO.VersionsActivityDTO)) {
                    throw new NoWhenBranchMatchedException();
                }
                listEmptyList = CollectionsKt.emptyList();
            }
            List<CommentDTO> list2 = listEmptyList;
            ArrayList arrayList2 = new ArrayList(CollectionsKt.collectionSizeOrDefault(list2, 10));
            Iterator<T> it = list2.iterator();
            while (it.hasNext()) {
                arrayList2.add(this.commentDTOEntityMapper.toEntity((CommentDTO) it.next(), fileId));
            }
            int i2 = i + 1;
            arrayList.add(TuplesKt.to(this.fileActivitiesDTOEntityMapper.toEntities(fileActivityDTO, fileId, i), arrayList2));
            i = i2;
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    public final Object deleteOldFileActivities(String str, Date date, Continuation<? super Boolean> continuation) {
        C14281 c14281;
        if (continuation instanceof C14281) {
            c14281 = (C14281) continuation;
            if ((c14281.label & Integer.MIN_VALUE) != 0) {
                c14281.label -= Integer.MIN_VALUE;
            } else {
                c14281 = new C14281(continuation);
            }
        } else {
            c14281 = new C14281(continuation);
        }
        Object objDeleteActivity = c14281.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = c14281.label;
        if (i == 0) {
            ResultKt.throwOnFailure(objDeleteActivity);
            FileActivityCacheDataSource fileActivityCacheDataSource = this.fileActivitiesCacheDataSource;
            c14281.L$0 = SpillingKt.nullOutSpilledVariable(str);
            c14281.L$1 = SpillingKt.nullOutSpilledVariable(date);
            c14281.label = 1;
            objDeleteActivity = fileActivityCacheDataSource.deleteActivity(str, date, c14281);
            if (objDeleteActivity == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(objDeleteActivity);
        }
        return Boxing.boxBoolean(objDeleteActivity instanceof Result.Success);
    }
}
