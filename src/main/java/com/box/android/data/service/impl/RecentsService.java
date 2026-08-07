package com.box.android.data.service.impl;

import com.box.android.coreservices.modelcontroller.BoxAppFutureTask;
import com.box.android.coreservices.modelcontroller.IBaseModelController;
import com.box.android.coreservices.modelcontroller.IMoCoBoxRecentEvents;
import com.box.android.data.datasource.RecentsRemoteDataSource;
import com.box.android.data.datasource.errors.RemoteError;
import com.box.android.domain.controller.IPreviewController;
import com.box.android.domain.mappers.ItemModelMapper;
import com.box.android.domain.models.DomainError;
import com.box.android.domain.models.ItemId;
import com.box.android.domain.models.item.ItemModel;
import com.box.android.domain.services.IRecentsService;
import com.box.android.domain.services.IdMappingService;
import com.box.android.domain.usecases.InteractionType;
import com.box.android.domain.utils.ExtensionsKt;
import com.box.android.domain.utils.result.Result;
import com.box.android.preview.previewtype.boxnote.BoxNoteConstants;
import com.box.androidsdk.content.BoxApiRecentItems;
import com.box.androidsdk.content.models.BoxItem;
import com.box.androidsdk.content.requests.BoxFilePreviewRequest;
import com.box.androidsdk.content.requests.BoxRequestRecentItems;
import com.box.androidsdk.content.requests.BoxRequestsFile;
import com.box.androidsdk.content.requests.BoxResponse;
import com.box.androidsdk.content.utils.BoxLogUtils;
import com.box.boxandroidlibv2private.requests.BoxRequestLocalRecentItems;
import com.box.boxandroidlibv2private.resourcemanagers.BoxExtendedApiRecentItems;
import com.box.brownfieldApi.featuresNavigator.activities.ReactNativeFeatureActivity;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.FlowKt;

/* JADX INFO: compiled from: RecentsService.kt */
/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000p\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001BA\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\u0006\u0010\f\u001a\u00020\r\u0012\u0006\u0010\u000e\u001a\u00020\u000f¢\u0006\u0004\b\u0010\u0010\u0011J<\u0010\u0012\u001a\u000e\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u00150\u00132\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u001b2\b\u0010\u001c\u001a\u0004\u0018\u00010\u001bH\u0096@¢\u0006\u0002\u0010\u001dJ(\u0010\u0012\u001a\u00020\u00142\u0006\u0010\u001e\u001a\u00020\u001f2\u0006\u0010\u0018\u001a\u00020\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u001bH\u0096@¢\u0006\u0002\u0010 J \u0010!\u001a\u001a\u0012\u0016\u0012\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020$0#\u0012\u0004\u0012\u00020\u00150\u00130\"H\u0016J\u001a\u0010%\u001a\u000e\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u00150\u0013H\u0096@¢\u0006\u0002\u0010&R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006'"}, d2 = {"Lcom/box/android/data/service/impl/RecentsService;", "Lcom/box/android/domain/services/IRecentsService;", "recentsRemoteDataSource", "Lcom/box/android/data/datasource/RecentsRemoteDataSource;", "extendedRecentApi", "Lcom/box/boxandroidlibv2private/resourcemanagers/BoxExtendedApiRecentItems;", "recentApi", "Lcom/box/androidsdk/content/BoxApiRecentItems;", "baseModelController", "Lcom/box/android/coreservices/modelcontroller/IBaseModelController;", "mocoRecentEvents", "Lcom/box/android/coreservices/modelcontroller/IMoCoBoxRecentEvents;", "previewController", "Lcom/box/android/domain/controller/IPreviewController;", "idMappingService", "Lcom/box/android/domain/services/IdMappingService;", "<init>", "(Lcom/box/android/data/datasource/RecentsRemoteDataSource;Lcom/box/boxandroidlibv2private/resourcemanagers/BoxExtendedApiRecentItems;Lcom/box/androidsdk/content/BoxApiRecentItems;Lcom/box/android/coreservices/modelcontroller/IBaseModelController;Lcom/box/android/coreservices/modelcontroller/IMoCoBoxRecentEvents;Lcom/box/android/domain/controller/IPreviewController;Lcom/box/android/domain/services/IdMappingService;)V", "addToRecents", "Lcom/box/android/domain/utils/result/Result;", "", "Lcom/box/android/domain/models/DomainError;", "remoteId", "Lcom/box/android/domain/models/ItemId$Remote;", "interactionType", "Lcom/box/android/domain/usecases/InteractionType;", BoxNoteConstants.NOTES_BUILDER_SHARED_LINK, "", "password", "(Lcom/box/android/domain/models/ItemId$Remote;Lcom/box/android/domain/usecases/InteractionType;Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "itemId", "Lcom/box/android/domain/models/ItemId;", "(Lcom/box/android/domain/models/ItemId;Lcom/box/android/domain/usecases/InteractionType;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "recentItems", "Lkotlinx/coroutines/flow/Flow;", "", "Lcom/box/android/domain/models/item/ItemModel;", "fetchRecentItemsFromRemote", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "data_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class RecentsService implements IRecentsService {
    private final IBaseModelController baseModelController;
    private final BoxExtendedApiRecentItems extendedRecentApi;
    private final IdMappingService idMappingService;
    private final IMoCoBoxRecentEvents mocoRecentEvents;
    private final IPreviewController previewController;
    private final BoxApiRecentItems recentApi;
    private final RecentsRemoteDataSource recentsRemoteDataSource;

    /* JADX INFO: renamed from: com.box.android.data.service.impl.RecentsService$addToRecents$3, reason: invalid class name */
    /* JADX INFO: compiled from: RecentsService.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.box.android.data.service.impl.RecentsService", f = "RecentsService.kt", i = {0, 0, 0}, l = {66}, m = "addToRecents", n = {"itemId", "interactionType", BoxNoteConstants.NOTES_BUILDER_SHARED_LINK}, s = {"L$0", "L$1", "L$2"}, v = 1)
    static final class AnonymousClass3 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        Object L$2;
        int label;
        /* synthetic */ Object result;

        AnonymousClass3(Continuation<? super AnonymousClass3> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return RecentsService.this.addToRecents(null, null, null, this);
        }
    }

    @Inject
    public RecentsService(RecentsRemoteDataSource recentsRemoteDataSource, BoxExtendedApiRecentItems extendedRecentApi, BoxApiRecentItems recentApi, IBaseModelController baseModelController, IMoCoBoxRecentEvents mocoRecentEvents, IPreviewController previewController, IdMappingService idMappingService) {
        Intrinsics.checkNotNullParameter(recentsRemoteDataSource, "recentsRemoteDataSource");
        Intrinsics.checkNotNullParameter(extendedRecentApi, "extendedRecentApi");
        Intrinsics.checkNotNullParameter(recentApi, "recentApi");
        Intrinsics.checkNotNullParameter(baseModelController, "baseModelController");
        Intrinsics.checkNotNullParameter(mocoRecentEvents, "mocoRecentEvents");
        Intrinsics.checkNotNullParameter(previewController, "previewController");
        Intrinsics.checkNotNullParameter(idMappingService, "idMappingService");
        this.recentsRemoteDataSource = recentsRemoteDataSource;
        this.extendedRecentApi = extendedRecentApi;
        this.recentApi = recentApi;
        this.baseModelController = baseModelController;
        this.mocoRecentEvents = mocoRecentEvents;
        this.previewController = previewController;
        this.idMappingService = idMappingService;
    }

    /* JADX INFO: renamed from: com.box.android.data.service.impl.RecentsService$addToRecents$2, reason: invalid class name */
    /* JADX INFO: compiled from: RecentsService.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001*\u00020\u0004H\n"}, d2 = {"<anonymous>", "Lcom/box/android/domain/utils/result/Result;", "", "Lcom/box/android/domain/models/DomainError;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.box.android.data.service.impl.RecentsService$addToRecents$2", f = "RecentsService.kt", i = {0}, l = {51}, m = "invokeSuspend", n = {"$this$withContext"}, s = {"L$0"}, v = 1)
    static final class AnonymousClass2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Result<? extends Unit, ? extends DomainError>>, Object> {
        final /* synthetic */ InteractionType $interactionType;
        final /* synthetic */ String $password;
        final /* synthetic */ ItemId.Remote $remoteId;
        final /* synthetic */ String $sharedLink;
        private /* synthetic */ Object L$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass2(ItemId.Remote remote, InteractionType interactionType, String str, String str2, Continuation<? super AnonymousClass2> continuation) {
            super(2, continuation);
            this.$remoteId = remote;
            this.$interactionType = interactionType;
            this.$sharedLink = str;
            this.$password = str2;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            AnonymousClass2 anonymousClass2 = RecentsService.this.new AnonymousClass2(this.$remoteId, this.$interactionType, this.$sharedLink, this.$password, continuation);
            anonymousClass2.L$0 = obj;
            return anonymousClass2;
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
            CoroutineScope coroutineScope = (CoroutineScope) this.L$0;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                this.L$0 = coroutineScope;
                this.label = 1;
                obj = RecentsService.this.recentsRemoteDataSource.addToRecents(this.$remoteId, this.$interactionType, this.$sharedLink, this.$password, this);
                if (obj == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
            Result result = (Result) obj;
            ItemId.Remote remote = this.$remoteId;
            if (result instanceof Result.Success) {
                return result;
            }
            if (result instanceof Result.Error) {
                RemoteError remoteError = (RemoteError) ((Result.Error) result).getValue();
                BoxLogUtils.e(ExtensionsKt.getTAG(coroutineScope), "Error while adding file " + remote.getBoxId() + " to recents: " + remoteError);
                return new Result.Error(DomainErrorMapper.toDomainError$default(DomainErrorMapper.INSTANCE, remoteError, null, 2, null));
            }
            throw new NoWhenBranchMatchedException();
        }
    }

    @Override // com.box.android.domain.services.IRecentsService
    public Object addToRecents(ItemId.Remote remote, InteractionType interactionType, String str, String str2, Continuation<? super Result<Unit, ? extends DomainError>> continuation) {
        return BuildersKt.withContext(Dispatchers.getIO(), new AnonymousClass2(remote, interactionType, str, str2, null), continuation);
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    @Override // com.box.android.domain.services.IRecentsService
    public Object addToRecents(ItemId itemId, InteractionType interactionType, String str, Continuation<? super Unit> continuation) {
        AnonymousClass3 anonymousClass3;
        if (continuation instanceof AnonymousClass3) {
            anonymousClass3 = (AnonymousClass3) continuation;
            if ((anonymousClass3.label & Integer.MIN_VALUE) != 0) {
                anonymousClass3.label -= Integer.MIN_VALUE;
            } else {
                anonymousClass3 = new AnonymousClass3(continuation);
            }
        } else {
            anonymousClass3 = new AnonymousClass3(continuation);
        }
        Object remoteId = anonymousClass3.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = anonymousClass3.label;
        if (i == 0) {
            ResultKt.throwOnFailure(remoteId);
            IdMappingService idMappingService = this.idMappingService;
            anonymousClass3.L$0 = SpillingKt.nullOutSpilledVariable(itemId);
            anonymousClass3.L$1 = SpillingKt.nullOutSpilledVariable(interactionType);
            anonymousClass3.L$2 = str;
            anonymousClass3.label = 1;
            remoteId = idMappingService.getRemoteId(itemId, anonymousClass3);
            if (remoteId == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            str = (String) anonymousClass3.L$2;
            ResultKt.throwOnFailure(remoteId);
        }
        ItemId.Remote remote = (ItemId.Remote) remoteId;
        if (remote != null) {
            this.mocoRecentEvents.addFileToRecents(remote.getBoxId(), str);
            BoxRequestsFile.FilePreviewed filePreviewedRequest = this.previewController.getApiPreview().getFilePreviewedRequest(remote.getBoxId());
            Intrinsics.checkNotNull(filePreviewedRequest, "null cannot be cast to non-null type com.box.androidsdk.content.requests.BoxFilePreviewRequest");
            BoxFilePreviewRequest boxFilePreviewRequest = (BoxFilePreviewRequest) filePreviewedRequest;
            boxFilePreviewRequest.setInteractionSharedLink(str);
            this.previewController.execute(boxFilePreviewRequest.toTask());
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: renamed from: com.box.android.data.service.impl.RecentsService$recentItems$1, reason: invalid class name */
    /* JADX INFO: compiled from: RecentsService.kt */
    @Metadata(d1 = {"\u0000\u001a\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u001a\u0012\u0016\u0012\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u0004\u0012\u0004\u0012\u00020\u00060\u00030\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/flow/FlowCollector;", "Lcom/box/android/domain/utils/result/Result;", "", "Lcom/box/android/domain/models/item/ItemModel;", "Lcom/box/android/domain/models/DomainError;"}, k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.box.android.data.service.impl.RecentsService$recentItems$1", f = "RecentsService.kt", i = {0, 0, 0}, l = {81}, m = "invokeSuspend", n = {"$this$flow", "task", ReactNativeFeatureActivity.RESULT_EXTRA_KEY}, s = {"L$0", "L$1", "L$2"}, v = 1)
    static final class AnonymousClass1 extends SuspendLambda implements Function2<FlowCollector<? super Result<? extends List<? extends ItemModel>, ? extends DomainError>>, Continuation<? super Unit>, Object> {
        private /* synthetic */ Object L$0;
        Object L$1;
        Object L$2;
        int label;

        AnonymousClass1(Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            AnonymousClass1 anonymousClass1 = RecentsService.this.new AnonymousClass1(continuation);
            anonymousClass1.L$0 = obj;
            return anonymousClass1;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(FlowCollector<? super Result<? extends List<? extends ItemModel>, ? extends DomainError>> flowCollector, Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(flowCollector, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Result error;
            FlowCollector flowCollector = (FlowCollector) this.L$0;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                IBaseModelController iBaseModelController = RecentsService.this.baseModelController;
                BoxRequestLocalRecentItems sqlRecentItems = RecentsService.this.extendedRecentApi.getSqlRecentItems(BoxExtendedApiRecentItems.FILTER.ALL);
                Intrinsics.checkNotNullExpressionValue(sqlRecentItems, "getSqlRecentItems(...)");
                BoxAppFutureTask boxAppFutureTaskPerformLocal = iBaseModelController.performLocal(sqlRecentItems);
                BoxResponse boxResponse = boxAppFutureTaskPerformLocal.get();
                if (boxResponse.isSuccess()) {
                    Object result = boxResponse.getResult();
                    Intrinsics.checkNotNullExpressionValue(result, "getResult(...)");
                    ArrayList arrayList = new ArrayList();
                    for (BoxItem boxItem : (Iterable) result) {
                        ItemModelMapper itemModelMapper = ItemModelMapper.INSTANCE;
                        Intrinsics.checkNotNull(boxItem);
                        ItemModel itemModel = itemModelMapper.toItemModel(boxItem);
                        if (itemModel != null) {
                            arrayList.add(itemModel);
                        }
                    }
                    error = new Result.Success(arrayList);
                } else {
                    DomainErrorMapper domainErrorMapper = DomainErrorMapper.INSTANCE;
                    Exception exception = boxResponse.getException();
                    Intrinsics.checkNotNullExpressionValue(exception, "getException(...)");
                    error = new Result.Error(domainErrorMapper.toDomainError(exception, "Couldn't fetch recent items from local db."));
                }
                this.L$0 = SpillingKt.nullOutSpilledVariable(flowCollector);
                this.L$1 = SpillingKt.nullOutSpilledVariable(boxAppFutureTaskPerformLocal);
                this.L$2 = SpillingKt.nullOutSpilledVariable(boxResponse);
                this.label = 1;
                if (flowCollector.emit(error, this) == coroutine_suspended) {
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

    @Override // com.box.android.domain.services.IRecentsService
    public Flow<Result<List<ItemModel>, DomainError>> recentItems() {
        return FlowKt.flowOn(FlowKt.flow(new AnonymousClass1(null)), Dispatchers.getIO());
    }

    /* JADX INFO: renamed from: com.box.android.data.service.impl.RecentsService$fetchRecentItemsFromRemote$2, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: RecentsService.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001*\u00020\u0004H\n"}, d2 = {"<anonymous>", "Lcom/box/android/domain/utils/result/Result;", "", "Lcom/box/android/domain/models/DomainError;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.box.android.data.service.impl.RecentsService$fetchRecentItemsFromRemote$2", f = "RecentsService.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {}, v = 1)
    static final class C14902 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Result<? extends Unit, ? extends DomainError>>, Object> {
        int label;

        C14902(Continuation<? super C14902> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return RecentsService.this.new C14902(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Object invoke(CoroutineScope coroutineScope, Continuation<? super Result<? extends Unit, ? extends DomainError>> continuation) {
            return invoke2(coroutineScope, (Continuation<? super Result<Unit, ? extends DomainError>>) continuation);
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(CoroutineScope coroutineScope, Continuation<? super Result<Unit, ? extends DomainError>> continuation) {
            return ((C14902) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label == 0) {
                ResultKt.throwOnFailure(obj);
                IBaseModelController iBaseModelController = RecentsService.this.baseModelController;
                BoxRequestRecentItems.GetRecentItems recentItemsRequest = RecentsService.this.recentApi.getRecentItemsRequest();
                Intrinsics.checkNotNullExpressionValue(recentItemsRequest, "getRecentItemsRequest(...)");
                BoxResponse boxResponse = iBaseModelController.performRemote(recentItemsRequest).get();
                if (boxResponse.isSuccess()) {
                    return new Result.Success(Unit.INSTANCE);
                }
                DomainErrorMapper domainErrorMapper = DomainErrorMapper.INSTANCE;
                Exception exception = boxResponse.getException();
                Intrinsics.checkNotNullExpressionValue(exception, "getException(...)");
                return new Result.Error(domainErrorMapper.toDomainError(exception, "Couldn't fetch recent items from remote."));
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    @Override // com.box.android.domain.services.IRecentsService
    public Object fetchRecentItemsFromRemote(Continuation<? super Result<Unit, ? extends DomainError>> continuation) {
        return BuildersKt.withContext(Dispatchers.getIO(), new C14902(null), continuation);
    }
}
