package com.box.android.data.service.impl;

import com.box.android.data.api.models.items.FileDTO;
import com.box.android.data.api.models.items.FolderDTO;
import com.box.android.data.api.models.items.IItemDTO;
import com.box.android.data.api.models.items.WebLinkDTO;
import com.box.android.data.datasource.LegacyCacheDataSource;
import com.box.android.data.datasource.SharedLinkCredentialsCacheDatasource;
import com.box.android.data.datasource.errors.RemoteError;
import com.box.android.data.datasource.item.UpdateItemInfoRemoteDataSource;
import com.box.android.data.mappers.FileDTOtoFileModelMapper;
import com.box.android.data.mappers.FolderDTOtoFolderModelMapper;
import com.box.android.data.mappers.WebLinkDTOtoWebLinkModelMapper;
import com.box.android.data.persistence.sharedlink.SharedlinkCredentialEntity;
import com.box.android.domain.models.DomainError;
import com.box.android.domain.models.ItemId;
import com.box.android.domain.models.item.ItemModel;
import com.box.android.domain.models.item.SharedLinkModel;
import com.box.android.domain.services.ISharedLinkService;
import com.box.android.domain.services.IdMappingService;
import com.box.android.domain.utils.result.Result;
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
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: SharedLinkService.kt */
/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\u0018\u00002\u00020\u0001B)\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0004\b\n\u0010\u000bJ\"\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u000f0\r2\u0006\u0010\u0010\u001a\u00020\u0011H\u0096@¢\u0006\u0002\u0010\u0012J(\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00162\b\u0010\u0018\u001a\u0004\u0018\u00010\u0016H\u0096@¢\u0006\u0002\u0010\u0019J\u0018\u0010\u001a\u001a\u0004\u0018\u00010\u00162\u0006\u0010\u0015\u001a\u00020\u0016H\u0096@¢\u0006\u0002\u0010\u001bR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001c"}, d2 = {"Lcom/box/android/data/service/impl/SharedLinkService;", "Lcom/box/android/domain/services/ISharedLinkService;", "updateItemInfoRemoteDataSource", "Lcom/box/android/data/datasource/item/UpdateItemInfoRemoteDataSource;", "legacyCacheDataSource", "Lcom/box/android/data/datasource/LegacyCacheDataSource;", "idMappingService", "Lcom/box/android/domain/services/IdMappingService;", "sharedLinkCredentialsCacheDatasource", "Lcom/box/android/data/datasource/SharedLinkCredentialsCacheDatasource;", "<init>", "(Lcom/box/android/data/datasource/item/UpdateItemInfoRemoteDataSource;Lcom/box/android/data/datasource/LegacyCacheDataSource;Lcom/box/android/domain/services/IdMappingService;Lcom/box/android/data/datasource/SharedLinkCredentialsCacheDatasource;)V", "createDefaultSharedLink", "Lcom/box/android/domain/utils/result/Result;", "Lcom/box/android/domain/models/item/SharedLinkModel;", "Lcom/box/android/domain/models/DomainError;", "itemId", "Lcom/box/android/domain/models/ItemId;", "(Lcom/box/android/domain/models/ItemId;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "saveSharedLinkCredential", "", "fileId", "", "url", "password", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getSharedLinkHeader", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "data_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class SharedLinkService implements ISharedLinkService {
    private final IdMappingService idMappingService;
    private final LegacyCacheDataSource legacyCacheDataSource;
    private final SharedLinkCredentialsCacheDatasource sharedLinkCredentialsCacheDatasource;
    private final UpdateItemInfoRemoteDataSource updateItemInfoRemoteDataSource;

    /* JADX INFO: renamed from: com.box.android.data.service.impl.SharedLinkService$createDefaultSharedLink$1, reason: invalid class name */
    /* JADX INFO: compiled from: SharedLinkService.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.box.android.data.service.impl.SharedLinkService", f = "SharedLinkService.kt", i = {0, 1, 1, 1, 1, 1, 2, 2, 2, 2, 2, 2, 2, 2, 2}, l = {34, 35, 58}, m = "createDefaultSharedLink", n = {"itemId", "itemId", "$this$flatMap$iv", "remoteId", "$i$f$flatMap", "$i$a$-flatMap-SharedLinkService$createDefaultSharedLink$2", "itemId", "$this$flatMap$iv", "remoteId", "$this$onSuccess$iv", "itemModel", "$i$f$flatMap", "$i$a$-flatMap-SharedLinkService$createDefaultSharedLink$2", "$i$f$onSuccess", "$i$a$-onSuccess-SharedLinkService$createDefaultSharedLink$2$2"}, s = {"L$0", "L$0", "L$1", "L$2", "I$0", "I$1", "L$0", "L$1", "L$2", "L$3", "L$4", "I$0", "I$1", "I$2", "I$3"}, v = 1)
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
        int label;
        /* synthetic */ Object result;

        AnonymousClass1(Continuation<? super AnonymousClass1> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return SharedLinkService.this.createDefaultSharedLink(null, this);
        }
    }

    /* JADX INFO: renamed from: com.box.android.data.service.impl.SharedLinkService$getSharedLinkHeader$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: SharedLinkService.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.box.android.data.service.impl.SharedLinkService", f = "SharedLinkService.kt", i = {0}, l = {86}, m = "getSharedLinkHeader", n = {"fileId"}, s = {"L$0"}, v = 1)
    static final class C15271 extends ContinuationImpl {
        Object L$0;
        int label;
        /* synthetic */ Object result;

        C15271(Continuation<? super C15271> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return SharedLinkService.this.getSharedLinkHeader(null, this);
        }
    }

    @Inject
    public SharedLinkService(UpdateItemInfoRemoteDataSource updateItemInfoRemoteDataSource, LegacyCacheDataSource legacyCacheDataSource, IdMappingService idMappingService, SharedLinkCredentialsCacheDatasource sharedLinkCredentialsCacheDatasource) {
        Intrinsics.checkNotNullParameter(updateItemInfoRemoteDataSource, "updateItemInfoRemoteDataSource");
        Intrinsics.checkNotNullParameter(legacyCacheDataSource, "legacyCacheDataSource");
        Intrinsics.checkNotNullParameter(idMappingService, "idMappingService");
        Intrinsics.checkNotNullParameter(sharedLinkCredentialsCacheDatasource, "sharedLinkCredentialsCacheDatasource");
        this.updateItemInfoRemoteDataSource = updateItemInfoRemoteDataSource;
        this.legacyCacheDataSource = legacyCacheDataSource;
        this.idMappingService = idMappingService;
        this.sharedLinkCredentialsCacheDatasource = sharedLinkCredentialsCacheDatasource;
    }

    /* JADX WARN: Code duplicated, block: B:29:0x00c6  */
    /* JADX WARN: Code duplicated, block: B:31:0x00d2  */
    /* JADX WARN: Code duplicated, block: B:32:0x00e2  */
    /* JADX WARN: Code duplicated, block: B:34:0x00e6  */
    /* JADX WARN: Code duplicated, block: B:35:0x00f6  */
    /* JADX WARN: Code duplicated, block: B:37:0x00fa  */
    /* JADX WARN: Code duplicated, block: B:38:0x010a  */
    /* JADX WARN: Code duplicated, block: B:40:0x011b  */
    /* JADX WARN: Code duplicated, block: B:44:0x0123  */
    /* JADX WARN: Code duplicated, block: B:47:0x015e  */
    /* JADX WARN: Code duplicated, block: B:49:0x0161  */
    /* JADX WARN: Code duplicated, block: B:53:0x0169  */
    /* JADX WARN: Code duplicated, block: B:55:0x0177  */
    /* JADX WARN: Code duplicated, block: B:56:0x0180  */
    /* JADX WARN: Code duplicated, block: B:57:0x0190  */
    /* JADX WARN: Code duplicated, block: B:61:0x0198 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:62:0x0199  */
    /* JADX WARN: Code duplicated, block: B:64:0x019d  */
    /* JADX WARN: Code duplicated, block: B:66:0x01b7  */
    /* JADX WARN: Code duplicated, block: B:68:0x01bd  */
    /* JADX WARN: Code duplicated, block: B:70:0x01c3  */
    /* JADX WARN: Code duplicated, block: B:72:0x01c9  */
    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    @Override // com.box.android.domain.services.ISharedLinkService
    public Object createDefaultSharedLink(ItemId itemId, Continuation<? super Result<SharedLinkModel, ? extends DomainError>> continuation) {
        AnonymousClass1 anonymousClass1;
        Result result;
        ItemId itemId2;
        ItemId.Remote remote;
        int i;
        int i2;
        Result error;
        ItemModel itemModel;
        LegacyCacheDataSource legacyCacheDataSource;
        Result result2;
        IItemDTO iItemDTO;
        Result.Error error2;
        SharedLinkModel sharedLink;
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
        AnonymousClass1 anonymousClass2 = anonymousClass1;
        Object remoteIdOrError = anonymousClass2.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i3 = anonymousClass2.label;
        if (i3 == 0) {
            ResultKt.throwOnFailure(remoteIdOrError);
            IdMappingService idMappingService = this.idMappingService;
            anonymousClass2.L$0 = SpillingKt.nullOutSpilledVariable(itemId);
            anonymousClass2.label = 1;
            remoteIdOrError = idMappingService.getRemoteIdOrError(itemId, anonymousClass2);
            if (remoteIdOrError != coroutine_suspended) {
            }
            return coroutine_suspended;
        }
        if (i3 == 1) {
            itemId = (ItemId) anonymousClass2.L$0;
            ResultKt.throwOnFailure(remoteIdOrError);
        } else {
            if (i3 == 2) {
                i = anonymousClass2.I$1;
                i2 = anonymousClass2.I$0;
                remote = (ItemId.Remote) anonymousClass2.L$2;
                result = (Result) anonymousClass2.L$1;
                itemId2 = (ItemId) anonymousClass2.L$0;
                ResultKt.throwOnFailure(remoteIdOrError);
                error = (Result) remoteIdOrError;
                if (error instanceof Result.Success) {
                    iItemDTO = (IItemDTO) ((Result.Success) error).getValue();
                    if (iItemDTO instanceof WebLinkDTO) {
                        error2 = new Result.Success(WebLinkDTOtoWebLinkModelMapper.INSTANCE.toDomain((WebLinkDTO) iItemDTO));
                    } else if (iItemDTO instanceof FolderDTO) {
                        error2 = new Result.Success(FolderDTOtoFolderModelMapper.INSTANCE.toDomain((FolderDTO) iItemDTO));
                    } else if (iItemDTO instanceof FileDTO) {
                        error2 = new Result.Success(FileDTOtoFileModelMapper.INSTANCE.toDomain((FileDTO) iItemDTO));
                    } else {
                        error2 = new Result.Error(new RemoteError.Unknown(-1, "Unexpected IItemDTO implementation"));
                    }
                    error = error2;
                } else if (!(error instanceof Result.Error)) {
                    throw new NoWhenBranchMatchedException();
                }
                if (error instanceof Result.Success) {
                    itemModel = (ItemModel) ((Result.Success) error).getValue();
                    legacyCacheDataSource = this.legacyCacheDataSource;
                    anonymousClass2.L$0 = SpillingKt.nullOutSpilledVariable(itemId2);
                    anonymousClass2.L$1 = SpillingKt.nullOutSpilledVariable(result);
                    anonymousClass2.L$2 = SpillingKt.nullOutSpilledVariable(remote);
                    anonymousClass2.L$3 = error;
                    anonymousClass2.L$4 = SpillingKt.nullOutSpilledVariable(itemModel);
                    anonymousClass2.I$0 = i2;
                    anonymousClass2.I$1 = i;
                    anonymousClass2.I$2 = 0;
                    anonymousClass2.I$3 = 0;
                    anonymousClass2.label = 3;
                    if (LegacyCacheDataSource.saveItem$default(legacyCacheDataSource, itemModel, false, (Continuation) anonymousClass2, 2, (Object) null) != coroutine_suspended) {
                        result2 = error;
                    }
                    return coroutine_suspended;
                }
                if (!(error instanceof Result.Error)) {
                    throw new NoWhenBranchMatchedException();
                }
                if (error instanceof Result.Success) {
                    sharedLink = ((ItemModel) ((Result.Success) error).getValue()).getSharedLink();
                    if (sharedLink != null) {
                        error = new Result.Success(sharedLink);
                    } else {
                        error = new Result.Error(new RemoteError.Unknown(-1, "Successful response but shared link is null"));
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
                return new Result.Error(DomainErrorMapper.INSTANCE.toDomainError((RemoteError) ((Result.Error) error).getValue(), "Error when creating default shared link"));
            }
            if (i3 != 3) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            int i4 = anonymousClass2.I$3;
            int i5 = anonymousClass2.I$2;
            int i6 = anonymousClass2.I$1;
            int i7 = anonymousClass2.I$0;
            result2 = (Result) anonymousClass2.L$3;
            ResultKt.throwOnFailure(remoteIdOrError);
        }
        error = result2;
        if (error instanceof Result.Success) {
            sharedLink = ((ItemModel) ((Result.Success) error).getValue()).getSharedLink();
            if (sharedLink != null) {
                error = new Result.Success(sharedLink);
            } else {
                error = new Result.Error(new RemoteError.Unknown(-1, "Successful response but shared link is null"));
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
        return new Result.Error(DomainErrorMapper.INSTANCE.toDomainError((RemoteError) ((Result.Error) error).getValue(), "Error when creating default shared link"));
        result = (Result) remoteIdOrError;
        if (result instanceof Result.Success) {
            ItemId.Remote remote2 = (ItemId.Remote) ((Result.Success) result).getValue();
            UpdateItemInfoRemoteDataSource updateItemInfoRemoteDataSource = this.updateItemInfoRemoteDataSource;
            anonymousClass2.L$0 = SpillingKt.nullOutSpilledVariable(itemId);
            anonymousClass2.L$1 = SpillingKt.nullOutSpilledVariable(result);
            anonymousClass2.L$2 = SpillingKt.nullOutSpilledVariable(remote2);
            anonymousClass2.I$0 = 0;
            anonymousClass2.I$1 = 0;
            anonymousClass2.label = 2;
            Object objCreateDefaultSharedLink = updateItemInfoRemoteDataSource.createDefaultSharedLink(remote2, anonymousClass2);
            if (objCreateDefaultSharedLink != coroutine_suspended) {
                itemId2 = itemId;
                remote = remote2;
                remoteIdOrError = objCreateDefaultSharedLink;
                i = 0;
                i2 = 0;
                error = (Result) remoteIdOrError;
                if (error instanceof Result.Success) {
                    iItemDTO = (IItemDTO) ((Result.Success) error).getValue();
                    if (iItemDTO instanceof WebLinkDTO) {
                        error2 = new Result.Success(WebLinkDTOtoWebLinkModelMapper.INSTANCE.toDomain((WebLinkDTO) iItemDTO));
                    } else if (iItemDTO instanceof FolderDTO) {
                        error2 = new Result.Success(FolderDTOtoFolderModelMapper.INSTANCE.toDomain((FolderDTO) iItemDTO));
                    } else if (iItemDTO instanceof FileDTO) {
                        error2 = new Result.Success(FileDTOtoFileModelMapper.INSTANCE.toDomain((FileDTO) iItemDTO));
                    } else {
                        error2 = new Result.Error(new RemoteError.Unknown(-1, "Unexpected IItemDTO implementation"));
                    }
                    error = error2;
                } else if (!(error instanceof Result.Error)) {
                    throw new NoWhenBranchMatchedException();
                }
                if (error instanceof Result.Success) {
                    itemModel = (ItemModel) ((Result.Success) error).getValue();
                    legacyCacheDataSource = this.legacyCacheDataSource;
                    anonymousClass2.L$0 = SpillingKt.nullOutSpilledVariable(itemId2);
                    anonymousClass2.L$1 = SpillingKt.nullOutSpilledVariable(result);
                    anonymousClass2.L$2 = SpillingKt.nullOutSpilledVariable(remote);
                    anonymousClass2.L$3 = error;
                    anonymousClass2.L$4 = SpillingKt.nullOutSpilledVariable(itemModel);
                    anonymousClass2.I$0 = i2;
                    anonymousClass2.I$1 = i;
                    anonymousClass2.I$2 = 0;
                    anonymousClass2.I$3 = 0;
                    anonymousClass2.label = 3;
                    if (LegacyCacheDataSource.saveItem$default(legacyCacheDataSource, itemModel, false, (Continuation) anonymousClass2, 2, (Object) null) != coroutine_suspended) {
                        result2 = error;
                        error = result2;
                    }
                } else if (!(error instanceof Result.Error)) {
                    throw new NoWhenBranchMatchedException();
                }
                if (error instanceof Result.Success) {
                    sharedLink = ((ItemModel) ((Result.Success) error).getValue()).getSharedLink();
                    if (sharedLink != null) {
                        error = new Result.Success(sharedLink);
                    } else {
                        error = new Result.Error(new RemoteError.Unknown(-1, "Successful response but shared link is null"));
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
                return new Result.Error(DomainErrorMapper.INSTANCE.toDomainError((RemoteError) ((Result.Error) error).getValue(), "Error when creating default shared link"));
            }
            return coroutine_suspended;
        }
        if (result instanceof Result.Error) {
            return result;
        }
        throw new NoWhenBranchMatchedException();
    }

    @Override // com.box.android.domain.services.ISharedLinkService
    public Object saveSharedLinkCredential(String str, String str2, String str3, Continuation<? super Unit> continuation) {
        Object objAddSharedLinkCredentials = this.sharedLinkCredentialsCacheDatasource.addSharedLinkCredentials(new SharedlinkCredentialEntity(str, str2, str3), continuation);
        return objAddSharedLinkCredentials == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objAddSharedLinkCredentials : Unit.INSTANCE;
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    @Override // com.box.android.domain.services.ISharedLinkService
    public Object getSharedLinkHeader(String str, Continuation<? super String> continuation) {
        C15271 c15271;
        if (continuation instanceof C15271) {
            c15271 = (C15271) continuation;
            if ((c15271.label & Integer.MIN_VALUE) != 0) {
                c15271.label -= Integer.MIN_VALUE;
            } else {
                c15271 = new C15271(continuation);
            }
        } else {
            c15271 = new C15271(continuation);
        }
        Object sharedLinkCredential = c15271.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = c15271.label;
        if (i == 0) {
            ResultKt.throwOnFailure(sharedLinkCredential);
            SharedLinkCredentialsCacheDatasource sharedLinkCredentialsCacheDatasource = this.sharedLinkCredentialsCacheDatasource;
            c15271.L$0 = SpillingKt.nullOutSpilledVariable(str);
            c15271.label = 1;
            sharedLinkCredential = sharedLinkCredentialsCacheDatasource.getSharedLinkCredential(str, c15271);
            if (sharedLinkCredential == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(sharedLinkCredential);
        }
        SharedlinkCredentialEntity sharedlinkCredentialEntity = (SharedlinkCredentialEntity) sharedLinkCredential;
        if (sharedlinkCredentialEntity == null) {
            return null;
        }
        StringBuilder sb = new StringBuilder("shared_link=" + sharedlinkCredentialEntity.getUrl());
        String password = sharedlinkCredentialEntity.getPassword();
        if (password != null) {
            sb.append("&shared_link_password=" + password);
        }
        return sb.toString();
    }
}
