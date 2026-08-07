package com.box.android.data.service.impl;

import com.box.android.data.api.models.items.FileDTO;
import com.box.android.data.api.models.items.FolderDTO;
import com.box.android.data.api.models.items.IItemDTO;
import com.box.android.data.api.models.items.WebLinkDTO;
import com.box.android.data.datasource.LegacyCacheDataSource;
import com.box.android.data.datasource.errors.RemoteError;
import com.box.android.data.datasource.item.UpdateItemInfoRemoteDataSource;
import com.box.android.data.mappers.FileDTOtoFileModelMapper;
import com.box.android.data.mappers.FolderDTOtoFolderModelMapper;
import com.box.android.data.mappers.WebLinkDTOtoWebLinkModelMapper;
import com.box.android.domain.models.DomainError;
import com.box.android.domain.models.ItemId;
import com.box.android.domain.models.item.ItemModel;
import com.box.android.domain.services.IUpdateItemInfoService;
import com.box.android.domain.services.IdMappingService;
import com.box.android.domain.utils.result.Result;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;

/* JADX INFO: compiled from: UpdateItemInfoService.kt */
/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\u0018\u00002\u00020\u0001B!\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ6\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\r0\u000b2\u0006\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0011H\u0096@¢\u0006\u0002\u0010\u0013R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0014"}, d2 = {"Lcom/box/android/data/service/impl/UpdateItemInfoService;", "Lcom/box/android/domain/services/IUpdateItemInfoService;", "updateItemInfoRemoteDataSource", "Lcom/box/android/data/datasource/item/UpdateItemInfoRemoteDataSource;", "legacyCacheDataSource", "Lcom/box/android/data/datasource/LegacyCacheDataSource;", "idMappingService", "Lcom/box/android/domain/services/IdMappingService;", "<init>", "(Lcom/box/android/data/datasource/item/UpdateItemInfoRemoteDataSource;Lcom/box/android/data/datasource/LegacyCacheDataSource;Lcom/box/android/domain/services/IdMappingService;)V", "updateItemInfo", "Lcom/box/android/domain/utils/result/Result;", "Lcom/box/android/domain/models/item/ItemModel;", "Lcom/box/android/domain/models/DomainError;", "itemId", "Lcom/box/android/domain/models/ItemId;", "newItemName", "", "newDescription", "(Lcom/box/android/domain/models/ItemId;Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "data_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class UpdateItemInfoService implements IUpdateItemInfoService {
    private final IdMappingService idMappingService;
    private final LegacyCacheDataSource legacyCacheDataSource;
    private final UpdateItemInfoRemoteDataSource updateItemInfoRemoteDataSource;

    @Inject
    public UpdateItemInfoService(UpdateItemInfoRemoteDataSource updateItemInfoRemoteDataSource, LegacyCacheDataSource legacyCacheDataSource, IdMappingService idMappingService) {
        Intrinsics.checkNotNullParameter(updateItemInfoRemoteDataSource, "updateItemInfoRemoteDataSource");
        Intrinsics.checkNotNullParameter(legacyCacheDataSource, "legacyCacheDataSource");
        Intrinsics.checkNotNullParameter(idMappingService, "idMappingService");
        this.updateItemInfoRemoteDataSource = updateItemInfoRemoteDataSource;
        this.legacyCacheDataSource = legacyCacheDataSource;
        this.idMappingService = idMappingService;
    }

    /* JADX INFO: renamed from: com.box.android.data.service.impl.UpdateItemInfoService$updateItemInfo$2, reason: invalid class name */
    /* JADX INFO: compiled from: UpdateItemInfoService.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001*\u00020\u0004H\n"}, d2 = {"<anonymous>", "Lcom/box/android/domain/utils/result/Result;", "Lcom/box/android/domain/models/item/ItemModel;", "Lcom/box/android/domain/models/DomainError;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.box.android.data.service.impl.UpdateItemInfoService$updateItemInfo$2", f = "UpdateItemInfoService.kt", i = {1, 1, 1, 1, 2, 2, 2, 2, 2, 2, 2, 2}, l = {32, 33, 60}, m = "invokeSuspend", n = {"$this$flatMap$iv", "it", "$i$f$flatMap", "$i$a$-flatMap-UpdateItemInfoService$updateItemInfo$2$1", "$this$flatMap$iv", "it", "$this$onSuccess$iv", "itemModel", "$i$f$flatMap", "$i$a$-flatMap-UpdateItemInfoService$updateItemInfo$2$1", "$i$f$onSuccess", "$i$a$-onSuccess-UpdateItemInfoService$updateItemInfo$2$1$2"}, s = {"L$0", "L$2", "I$0", "I$1", "L$0", "L$1", "L$2", "L$3", "I$0", "I$1", "I$2", "I$3"}, v = 1)
    static final class AnonymousClass2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Result<? extends ItemModel, ? extends DomainError>>, Object> {
        final /* synthetic */ ItemId $itemId;
        final /* synthetic */ String $newDescription;
        final /* synthetic */ String $newItemName;
        int I$0;
        int I$1;
        int I$2;
        int I$3;
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass2(ItemId itemId, String str, String str2, Continuation<? super AnonymousClass2> continuation) {
            super(2, continuation);
            this.$itemId = itemId;
            this.$newItemName = str;
            this.$newDescription = str2;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return UpdateItemInfoService.this.new AnonymousClass2(this.$itemId, this.$newItemName, this.$newDescription, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Result<? extends ItemModel, ? extends DomainError>> continuation) {
            return ((AnonymousClass2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Code duplicated, block: B:23:0x00a2  */
        /* JADX WARN: Code duplicated, block: B:25:0x00ae  */
        /* JADX WARN: Code duplicated, block: B:26:0x00be  */
        /* JADX WARN: Code duplicated, block: B:28:0x00c2  */
        /* JADX WARN: Code duplicated, block: B:29:0x00d2  */
        /* JADX WARN: Code duplicated, block: B:31:0x00d6  */
        /* JADX WARN: Code duplicated, block: B:32:0x00e6  */
        /* JADX WARN: Code duplicated, block: B:33:0x00f7  */
        /* JADX WARN: Code duplicated, block: B:35:0x00fb  */
        /* JADX WARN: Code duplicated, block: B:38:0x0100  */
        /* JADX WARN: Code duplicated, block: B:41:0x0138  */
        /* JADX WARN: Code duplicated, block: B:43:0x013b  */
        /* JADX WARN: Code duplicated, block: B:47:0x0143 A[RETURN] */
        /* JADX WARN: Code duplicated, block: B:48:0x0144  */
        /* JADX WARN: Code duplicated, block: B:50:0x0148  */
        /* JADX WARN: Code duplicated, block: B:52:0x0162  */
        /* JADX WARN: Code duplicated, block: B:54:0x0168  */
        /* JADX WARN: Code duplicated, block: B:56:0x016e  */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object remoteIdOrError;
            Result result;
            UpdateItemInfoService updateItemInfoService;
            ItemId.Remote remote;
            Object objUpdateItem;
            int i;
            int i2;
            Result result2;
            Result.Error error;
            ItemModel itemModel;
            LegacyCacheDataSource legacyCacheDataSource;
            Result result3;
            IItemDTO iItemDTO;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i3 = this.label;
            if (i3 == 0) {
                ResultKt.throwOnFailure(obj);
                this.label = 1;
                remoteIdOrError = UpdateItemInfoService.this.idMappingService.getRemoteIdOrError(this.$itemId, this);
                if (remoteIdOrError != coroutine_suspended) {
                }
                return coroutine_suspended;
            }
            if (i3 == 1) {
                ResultKt.throwOnFailure(obj);
                remoteIdOrError = obj;
            } else {
                if (i3 == 2) {
                    int i4 = this.I$1;
                    int i5 = this.I$0;
                    ItemId.Remote remote2 = (ItemId.Remote) this.L$2;
                    updateItemInfoService = (UpdateItemInfoService) this.L$1;
                    result = (Result) this.L$0;
                    ResultKt.throwOnFailure(obj);
                    remote = remote2;
                    i2 = i5;
                    i = i4;
                    objUpdateItem = obj;
                    result2 = (Result) objUpdateItem;
                    if (result2 instanceof Result.Success) {
                        iItemDTO = (IItemDTO) ((Result.Success) result2).getValue();
                        if (iItemDTO instanceof WebLinkDTO) {
                            error = new Result.Success(WebLinkDTOtoWebLinkModelMapper.INSTANCE.toDomain((WebLinkDTO) iItemDTO));
                        } else if (iItemDTO instanceof FolderDTO) {
                            error = new Result.Success(FolderDTOtoFolderModelMapper.INSTANCE.toDomain((FolderDTO) iItemDTO));
                        } else if (iItemDTO instanceof FileDTO) {
                            error = new Result.Success(FileDTOtoFileModelMapper.INSTANCE.toDomain((FileDTO) iItemDTO));
                        } else {
                            error = new Result.Error(new RemoteError.Unknown(-1, "Unexpected IItemDTO implementation"));
                        }
                    } else {
                        if (result2 instanceof Result.Error) {
                            throw new NoWhenBranchMatchedException();
                        }
                        error = result2;
                    }
                    if (error instanceof Result.Success) {
                        itemModel = (ItemModel) ((Result.Success) error).getValue();
                        legacyCacheDataSource = updateItemInfoService.legacyCacheDataSource;
                        this.L$0 = SpillingKt.nullOutSpilledVariable(result);
                        this.L$1 = SpillingKt.nullOutSpilledVariable(remote);
                        this.L$2 = error;
                        this.L$3 = SpillingKt.nullOutSpilledVariable(itemModel);
                        this.I$0 = i2;
                        this.I$1 = i;
                        this.I$2 = 0;
                        this.I$3 = 0;
                        this.label = 3;
                        if (LegacyCacheDataSource.saveItem$default(legacyCacheDataSource, itemModel, false, (Continuation) this, 2, (Object) null) != coroutine_suspended) {
                            result3 = error;
                        }
                        return coroutine_suspended;
                    }
                    if (!(error instanceof Result.Error)) {
                        throw new NoWhenBranchMatchedException();
                    }
                    if (error instanceof Result.Success) {
                        return error;
                    }
                    if (!(error instanceof Result.Error)) {
                        throw new NoWhenBranchMatchedException();
                    }
                    return new Result.Error(DomainErrorMapper.INSTANCE.toDomainError((RemoteError) ((Result.Error) error).getValue(), "Error renaming item"));
                }
                if (i3 != 3) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                result3 = (Result) this.L$2;
                ResultKt.throwOnFailure(obj);
            }
            error = result3;
            if (error instanceof Result.Success) {
                return error;
            }
            if (!(error instanceof Result.Error)) {
                throw new NoWhenBranchMatchedException();
            }
            return new Result.Error(DomainErrorMapper.INSTANCE.toDomainError((RemoteError) ((Result.Error) error).getValue(), "Error renaming item"));
            result = (Result) remoteIdOrError;
            updateItemInfoService = UpdateItemInfoService.this;
            String str = this.$newItemName;
            String str2 = this.$newDescription;
            if (result instanceof Result.Success) {
                remote = (ItemId.Remote) ((Result.Success) result).getValue();
                UpdateItemInfoRemoteDataSource updateItemInfoRemoteDataSource = updateItemInfoService.updateItemInfoRemoteDataSource;
                this.L$0 = SpillingKt.nullOutSpilledVariable(result);
                this.L$1 = updateItemInfoService;
                this.L$2 = SpillingKt.nullOutSpilledVariable(remote);
                this.I$0 = 0;
                this.I$1 = 0;
                this.label = 2;
                objUpdateItem = updateItemInfoRemoteDataSource.updateItem(remote, str, str2, this);
                if (objUpdateItem != coroutine_suspended) {
                    i = 0;
                    i2 = 0;
                    result2 = (Result) objUpdateItem;
                    if (result2 instanceof Result.Success) {
                        iItemDTO = (IItemDTO) ((Result.Success) result2).getValue();
                        if (iItemDTO instanceof WebLinkDTO) {
                            error = new Result.Success(WebLinkDTOtoWebLinkModelMapper.INSTANCE.toDomain((WebLinkDTO) iItemDTO));
                        } else if (iItemDTO instanceof FolderDTO) {
                            error = new Result.Success(FolderDTOtoFolderModelMapper.INSTANCE.toDomain((FolderDTO) iItemDTO));
                        } else if (iItemDTO instanceof FileDTO) {
                            error = new Result.Success(FileDTOtoFileModelMapper.INSTANCE.toDomain((FileDTO) iItemDTO));
                        } else {
                            error = new Result.Error(new RemoteError.Unknown(-1, "Unexpected IItemDTO implementation"));
                        }
                    } else {
                        if (result2 instanceof Result.Error) {
                            throw new NoWhenBranchMatchedException();
                        }
                        error = result2;
                    }
                    if (error instanceof Result.Success) {
                        itemModel = (ItemModel) ((Result.Success) error).getValue();
                        legacyCacheDataSource = updateItemInfoService.legacyCacheDataSource;
                        this.L$0 = SpillingKt.nullOutSpilledVariable(result);
                        this.L$1 = SpillingKt.nullOutSpilledVariable(remote);
                        this.L$2 = error;
                        this.L$3 = SpillingKt.nullOutSpilledVariable(itemModel);
                        this.I$0 = i2;
                        this.I$1 = i;
                        this.I$2 = 0;
                        this.I$3 = 0;
                        this.label = 3;
                        if (LegacyCacheDataSource.saveItem$default(legacyCacheDataSource, itemModel, false, (Continuation) this, 2, (Object) null) != coroutine_suspended) {
                            result3 = error;
                            error = result3;
                        }
                    } else if (!(error instanceof Result.Error)) {
                        throw new NoWhenBranchMatchedException();
                    }
                    if (error instanceof Result.Success) {
                        return error;
                    }
                    if (!(error instanceof Result.Error)) {
                        throw new NoWhenBranchMatchedException();
                    }
                    return new Result.Error(DomainErrorMapper.INSTANCE.toDomainError((RemoteError) ((Result.Error) error).getValue(), "Error renaming item"));
                }
                return coroutine_suspended;
            }
            if (result instanceof Result.Error) {
                return result;
            }
            throw new NoWhenBranchMatchedException();
        }
    }

    @Override // com.box.android.domain.services.IUpdateItemInfoService
    public Object updateItemInfo(ItemId itemId, String str, String str2, Continuation<? super Result<? extends ItemModel, ? extends DomainError>> continuation) {
        return BuildersKt.withContext(Dispatchers.getIO(), new AnonymousClass2(itemId, str, str2, null), continuation);
    }
}
