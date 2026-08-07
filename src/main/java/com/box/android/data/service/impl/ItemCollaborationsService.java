package com.box.android.data.service.impl;

import com.box.android.data.api.ItemCollaborationsDTO;
import com.box.android.data.api.models.CollaborationDTO;
import com.box.android.data.api.models.UserMiniDTO;
import com.box.android.data.datasource.errors.RemoteError;
import com.box.android.data.datasource.item.ItemCollaborationsRemoteDataSource;
import com.box.android.data.mappers.ItemCollaborationsDTOToDomainMapperKt;
import com.box.android.domain.identity.IUserContextManager;
import com.box.android.domain.models.DomainError;
import com.box.android.domain.models.IGenericError;
import com.box.android.domain.models.ItemId;
import com.box.android.domain.models.item.ItemCollaborationModel;
import com.box.android.domain.services.IItemCollaborationsService;
import com.box.android.domain.services.IdMappingService;
import com.box.android.domain.utils.result.Result;
import com.box.androidsdk.content.BoxCache;
import com.box.androidsdk.content.auth.OAuthActivity;
import com.box.androidsdk.content.models.BoxIterator;
import java.sql.SQLException;
import java.util.Iterator;
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

/* JADX INFO: compiled from: ItemCollaborationsService.kt */
/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\u0018\u00002\u00020\u0001B)\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0004\b\n\u0010\u000bJ2\u0010\f\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000f0\u000e\u0012\u0004\u0012\u00020\u00100\r2\u0006\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014H\u0096@¢\u0006\u0002\u0010\u0015J*\u0010\u0016\u001a\u000e\u0012\u0004\u0012\u00020\u0017\u0012\u0004\u0012\u00020\u00100\r2\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0018\u001a\u00020\u0019H\u0096@¢\u0006\u0002\u0010\u001aR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001b"}, d2 = {"Lcom/box/android/data/service/impl/ItemCollaborationsService;", "Lcom/box/android/domain/services/IItemCollaborationsService;", "itemCollaborationsRemoteDataSource", "Lcom/box/android/data/datasource/item/ItemCollaborationsRemoteDataSource;", "idMappingService", "Lcom/box/android/domain/services/IdMappingService;", "userContextManager", "Lcom/box/android/domain/identity/IUserContextManager;", "boxCache", "Lcom/box/androidsdk/content/BoxCache;", "<init>", "(Lcom/box/android/data/datasource/item/ItemCollaborationsRemoteDataSource;Lcom/box/android/domain/services/IdMappingService;Lcom/box/android/domain/identity/IUserContextManager;Lcom/box/androidsdk/content/BoxCache;)V", "getItemCollaborations", "Lcom/box/android/domain/utils/result/Result;", "", "Lcom/box/android/domain/models/item/ItemCollaborationModel;", "Lcom/box/android/domain/models/DomainError;", "itemId", "Lcom/box/android/domain/models/ItemId;", BoxIterator.FIELD_LIMIT, "", "(Lcom/box/android/domain/models/ItemId;Ljava/lang/Integer;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "deleteCollaboration", "", OAuthActivity.USER_ID, "", "(Lcom/box/android/domain/models/ItemId;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "data_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class ItemCollaborationsService implements IItemCollaborationsService {
    private final BoxCache boxCache;
    private final IdMappingService idMappingService;
    private final ItemCollaborationsRemoteDataSource itemCollaborationsRemoteDataSource;
    private final IUserContextManager userContextManager;

    /* JADX INFO: renamed from: com.box.android.data.service.impl.ItemCollaborationsService$deleteCollaboration$1, reason: invalid class name */
    /* JADX INFO: compiled from: ItemCollaborationsService.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.box.android.data.service.impl.ItemCollaborationsService", f = "ItemCollaborationsService.kt", i = {0, 0, 1, 1, 1, 1, 1, 1, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2}, l = {43, 44, 51}, m = "deleteCollaboration", n = {"itemId", OAuthActivity.USER_ID, "itemId", OAuthActivity.USER_ID, "$this$flatMap$iv", "remoteId", "$i$f$flatMap", "$i$a$-flatMap-ItemCollaborationsService$deleteCollaboration$2", "itemId", OAuthActivity.USER_ID, "$this$flatMap$iv", "remoteId", "$this$flatMap$iv", "collaborationsDTO", "collabId", "$i$f$flatMap", "$i$a$-flatMap-ItemCollaborationsService$deleteCollaboration$2", "$i$f$flatMap", "$i$a$-flatMap-ItemCollaborationsService$deleteCollaboration$2$1"}, s = {"L$0", "L$1", "L$0", "L$1", "L$2", "L$3", "I$0", "I$1", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "I$0", "I$1", "I$2", "I$3"}, v = 1)
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
        int label;
        /* synthetic */ Object result;

        AnonymousClass1(Continuation<? super AnonymousClass1> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return ItemCollaborationsService.this.deleteCollaboration(null, null, this);
        }
    }

    @Inject
    public ItemCollaborationsService(ItemCollaborationsRemoteDataSource itemCollaborationsRemoteDataSource, IdMappingService idMappingService, IUserContextManager userContextManager, BoxCache boxCache) {
        Intrinsics.checkNotNullParameter(itemCollaborationsRemoteDataSource, "itemCollaborationsRemoteDataSource");
        Intrinsics.checkNotNullParameter(idMappingService, "idMappingService");
        Intrinsics.checkNotNullParameter(userContextManager, "userContextManager");
        Intrinsics.checkNotNullParameter(boxCache, "boxCache");
        this.itemCollaborationsRemoteDataSource = itemCollaborationsRemoteDataSource;
        this.idMappingService = idMappingService;
        this.userContextManager = userContextManager;
        this.boxCache = boxCache;
    }

    /* JADX INFO: renamed from: com.box.android.data.service.impl.ItemCollaborationsService$getItemCollaborations$2, reason: invalid class name */
    /* JADX INFO: compiled from: ItemCollaborationsService.kt */
    @Metadata(d1 = {"\u0000\u0016\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u0002\u0012\u0004\u0012\u00020\u00040\u0001*\u00020\u0005H\n"}, d2 = {"<anonymous>", "Lcom/box/android/domain/utils/result/Result;", "", "Lcom/box/android/domain/models/item/ItemCollaborationModel;", "Lcom/box/android/domain/models/DomainError;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.box.android.data.service.impl.ItemCollaborationsService$getItemCollaborations$2", f = "ItemCollaborationsService.kt", i = {1, 1, 1, 1}, l = {30, 31}, m = "invokeSuspend", n = {"$this$flatMap$iv", "it", "$i$f$flatMap", "$i$a$-flatMap-ItemCollaborationsService$getItemCollaborations$2$1"}, s = {"L$0", "L$2", "I$0", "I$1"}, v = 1)
    static final class AnonymousClass2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Result<? extends List<? extends ItemCollaborationModel>, ? extends DomainError>>, Object> {
        final /* synthetic */ ItemId $itemId;
        final /* synthetic */ Integer $limit;
        int I$0;
        int I$1;
        Object L$0;
        Object L$1;
        Object L$2;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass2(ItemId itemId, Integer num, Continuation<? super AnonymousClass2> continuation) {
            super(2, continuation);
            this.$itemId = itemId;
            this.$limit = num;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return ItemCollaborationsService.this.new AnonymousClass2(this.$itemId, this.$limit, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Object invoke(CoroutineScope coroutineScope, Continuation<? super Result<? extends List<? extends ItemCollaborationModel>, ? extends DomainError>> continuation) {
            return invoke2(coroutineScope, (Continuation<? super Result<? extends List<ItemCollaborationModel>, ? extends DomainError>>) continuation);
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(CoroutineScope coroutineScope, Continuation<? super Result<? extends List<ItemCollaborationModel>, ? extends DomainError>> continuation) {
            return ((AnonymousClass2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Code duplicated, block: B:21:0x007d  */
        /* JADX WARN: Code duplicated, block: B:22:0x0091  */
        /* JADX WARN: Code duplicated, block: B:26:0x0099 A[RETURN] */
        /* JADX WARN: Code duplicated, block: B:27:0x009a  */
        /* JADX WARN: Code duplicated, block: B:29:0x009e  */
        /* JADX WARN: Code duplicated, block: B:31:0x00c5  */
        /* JADX WARN: Code duplicated, block: B:33:0x00cb  */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            ItemId itemId;
            Result.Success success;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                this.label = 1;
                obj = ItemCollaborationsService.this.idMappingService.getRemoteIdOrError(this.$itemId, this);
                if (obj != coroutine_suspended) {
                }
                return coroutine_suspended;
            }
            if (i == 1) {
                ResultKt.throwOnFailure(obj);
            } else {
                if (i != 2) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                itemId = (ItemId) this.L$1;
                ResultKt.throwOnFailure(obj);
            }
            success = (Result) obj;
            if (success instanceof Result.Success) {
                success = new Result.Success(ItemCollaborationsDTOToDomainMapperKt.toDomain((ItemCollaborationsDTO) ((Result.Success) success).getValue()));
            } else if (!(success instanceof Result.Error)) {
                throw new NoWhenBranchMatchedException();
            }
            if (success instanceof Result.Success) {
                return success;
            }
            if (success instanceof Result.Error) {
                throw new NoWhenBranchMatchedException();
            }
            return new Result.Error(DomainErrorMapper.INSTANCE.toDomainError((RemoteError) ((Result.Error) success).getValue(), "Error fetching collaborations for item with id " + itemId));
            Result result = (Result) obj;
            ItemCollaborationsService itemCollaborationsService = ItemCollaborationsService.this;
            Integer num = this.$limit;
            ItemId itemId2 = this.$itemId;
            if (result instanceof Result.Success) {
                ItemId.Remote remote = (ItemId.Remote) ((Result.Success) result).getValue();
                ItemCollaborationsRemoteDataSource itemCollaborationsRemoteDataSource = itemCollaborationsService.itemCollaborationsRemoteDataSource;
                this.L$0 = SpillingKt.nullOutSpilledVariable(result);
                this.L$1 = itemId2;
                this.L$2 = SpillingKt.nullOutSpilledVariable(remote);
                this.I$0 = 0;
                this.I$1 = 0;
                this.label = 2;
                obj = itemCollaborationsRemoteDataSource.getItemCollaborations(remote, num, this);
                if (obj != coroutine_suspended) {
                    itemId = itemId2;
                    success = (Result) obj;
                    if (success instanceof Result.Success) {
                        success = new Result.Success(ItemCollaborationsDTOToDomainMapperKt.toDomain((ItemCollaborationsDTO) ((Result.Success) success).getValue()));
                    } else if (!(success instanceof Result.Error)) {
                        throw new NoWhenBranchMatchedException();
                    }
                    if (success instanceof Result.Success) {
                        return success;
                    }
                    if (success instanceof Result.Error) {
                        throw new NoWhenBranchMatchedException();
                    }
                    return new Result.Error(DomainErrorMapper.INSTANCE.toDomainError((RemoteError) ((Result.Error) success).getValue(), "Error fetching collaborations for item with id " + itemId));
                }
                return coroutine_suspended;
            }
            if (result instanceof Result.Error) {
                return result;
            }
            throw new NoWhenBranchMatchedException();
        }
    }

    @Override // com.box.android.domain.services.IItemCollaborationsService
    public Object getItemCollaborations(ItemId itemId, Integer num, Continuation<? super Result<? extends List<ItemCollaborationModel>, ? extends DomainError>> continuation) {
        return BuildersKt.withContext(Dispatchers.getIO(), new AnonymousClass2(itemId, num, null), continuation);
    }

    /* JADX WARN: Code duplicated, block: B:29:0x00e0  */
    /* JADX WARN: Code duplicated, block: B:32:0x00f9  */
    /* JADX WARN: Code duplicated, block: B:34:0x0107  */
    /* JADX WARN: Code duplicated, block: B:35:0x010e  */
    /* JADX WARN: Code duplicated, block: B:43:0x011e  */
    /* JADX WARN: Code duplicated, block: B:45:0x012b  */
    /* JADX WARN: Code duplicated, block: B:48:0x0160  */
    /* JADX WARN: Code duplicated, block: B:51:0x0168  */
    /* JADX WARN: Code duplicated, block: B:52:0x016a  */
    /* JADX WARN: Code duplicated, block: B:54:0x016e  */
    /* JADX WARN: Code duplicated, block: B:57:0x018b  */
    /* JADX WARN: Code duplicated, block: B:59:0x01a0  */
    /* JADX WARN: Code duplicated, block: B:60:0x01aa  */
    /* JADX WARN: Code duplicated, block: B:63:0x01b0  */
    /* JADX WARN: Code duplicated, block: B:65:0x01b6  */
    /* JADX WARN: Code duplicated, block: B:67:0x01bc  */
    /* JADX WARN: Code duplicated, block: B:71:0x01c4 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:72:0x01c5  */
    /* JADX WARN: Code duplicated, block: B:74:0x01c9  */
    /* JADX WARN: Code duplicated, block: B:76:0x01ee  */
    /* JADX WARN: Code duplicated, block: B:78:0x01f4  */
    /* JADX WARN: Code duplicated, block: B:7:0x001a  */
    /* JADX WARN: Code duplicated, block: B:86:0x0118 A[SYNTHETIC] */
    @Override // com.box.android.domain.services.IItemCollaborationsService
    public Object deleteCollaboration(ItemId itemId, String str, Continuation<? super Result<Unit, ? extends DomainError>> continuation) throws SQLException {
        AnonymousClass1 anonymousClass1;
        String str2;
        Result result;
        Object itemCollaborations;
        ItemId itemId2;
        ItemId.Remote remote;
        String str3;
        int i;
        int i2;
        Result error;
        ItemCollaborationsDTO itemCollaborationsDTO;
        Iterator<T> it;
        Object next;
        CollaborationDTO collaborationDTO;
        String str4;
        ItemId itemId3;
        UserMiniDTO accessibleBy;
        String id;
        Result result2;
        ItemId itemId4 = itemId;
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
        Object remoteIdOrError = anonymousClass1.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i3 = anonymousClass1.label;
        if (i3 == 0) {
            ResultKt.throwOnFailure(remoteIdOrError);
            IdMappingService idMappingService = this.idMappingService;
            anonymousClass1.L$0 = itemId4;
            str2 = str;
            anonymousClass1.L$1 = str2;
            anonymousClass1.label = 1;
            remoteIdOrError = idMappingService.getRemoteIdOrError(itemId4, anonymousClass1);
            if (remoteIdOrError != coroutine_suspended) {
            }
            return coroutine_suspended;
        }
        if (i3 == 1) {
            String str5 = (String) anonymousClass1.L$1;
            ItemId itemId5 = (ItemId) anonymousClass1.L$0;
            ResultKt.throwOnFailure(remoteIdOrError);
            str2 = str5;
            itemId4 = itemId5;
        } else {
            if (i3 == 2) {
                int i4 = anonymousClass1.I$1;
                i2 = anonymousClass1.I$0;
                ItemId.Remote remote2 = (ItemId.Remote) anonymousClass1.L$3;
                result = (Result) anonymousClass1.L$2;
                str3 = (String) anonymousClass1.L$1;
                itemId2 = (ItemId) anonymousClass1.L$0;
                ResultKt.throwOnFailure(remoteIdOrError);
                i = i4;
                remote = remote2;
                itemCollaborations = remoteIdOrError;
                error = (Result) itemCollaborations;
                if (error instanceof Result.Success) {
                    itemCollaborationsDTO = (ItemCollaborationsDTO) ((Result.Success) error).getValue();
                    it = itemCollaborationsDTO.getEntries().iterator();
                    do {
                        if (it.hasNext()) {
                            next = null;
                            break;
                        }
                        next = it.next();
                        accessibleBy = ((CollaborationDTO) next).getAccessibleBy();
                        if (accessibleBy != null) {
                            id = accessibleBy.getId();
                        } else {
                            id = null;
                        }
                    } while (!Intrinsics.areEqual(id, str3));
                    collaborationDTO = (CollaborationDTO) next;
                    if (collaborationDTO == null) {
                        return new Result.Error(new DomainError.UnknownError("Expected collaboration not found"));
                    }
                    ItemCollaborationsRemoteDataSource itemCollaborationsRemoteDataSource = this.itemCollaborationsRemoteDataSource;
                    String id2 = collaborationDTO.getId();
                    anonymousClass1.L$0 = itemId2;
                    anonymousClass1.L$1 = str3;
                    anonymousClass1.L$2 = SpillingKt.nullOutSpilledVariable(result);
                    anonymousClass1.L$3 = remote;
                    anonymousClass1.L$4 = SpillingKt.nullOutSpilledVariable(error);
                    anonymousClass1.L$5 = SpillingKt.nullOutSpilledVariable(itemCollaborationsDTO);
                    anonymousClass1.L$6 = SpillingKt.nullOutSpilledVariable(collaborationDTO);
                    anonymousClass1.I$0 = i2;
                    anonymousClass1.I$1 = i;
                    anonymousClass1.I$2 = 0;
                    anonymousClass1.I$3 = 0;
                    anonymousClass1.label = 3;
                    remoteIdOrError = itemCollaborationsRemoteDataSource.deleteCollaborations(id2, anonymousClass1);
                    if (remoteIdOrError != coroutine_suspended) {
                        str4 = str3;
                        itemId3 = itemId2;
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
                return new Result.Error(DomainErrorMapper.INSTANCE.toDomainError((IGenericError) ((Result.Error) error).getValue(), "Error fetching collaborations for item with id " + itemId2));
            }
            if (i3 != 3) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            int i5 = anonymousClass1.I$3;
            int i6 = anonymousClass1.I$2;
            int i7 = anonymousClass1.I$1;
            int i8 = anonymousClass1.I$0;
            remote = (ItemId.Remote) anonymousClass1.L$3;
            str4 = (String) anonymousClass1.L$1;
            itemId3 = (ItemId) anonymousClass1.L$0;
            ResultKt.throwOnFailure(remoteIdOrError);
        }
        result2 = (Result) remoteIdOrError;
        if (result2 instanceof Result.Success) {
            error = result2;
        } else {
            if (result2 instanceof Result.Error) {
                throw new NoWhenBranchMatchedException();
            }
            error = new Result.Error(DomainErrorMapper.toDomainError$default(DomainErrorMapper.INSTANCE, (RemoteError) ((Result.Error) result2).getValue(), null, 2, null));
        }
        if (error instanceof Result.Success) {
            if (Intrinsics.areEqual(str4, this.userContextManager.getCurrentContextId())) {
                this.boxCache.deleteFile(remote.getBoxId());
            }
        } else if (!(error instanceof Result.Error)) {
            throw new NoWhenBranchMatchedException();
        }
        itemId2 = itemId3;
        if (error instanceof Result.Success) {
            return error;
        }
        if (!(error instanceof Result.Error)) {
            throw new NoWhenBranchMatchedException();
        }
        return new Result.Error(DomainErrorMapper.INSTANCE.toDomainError((IGenericError) ((Result.Error) error).getValue(), "Error fetching collaborations for item with id " + itemId2));
        result = (Result) remoteIdOrError;
        if (!(result instanceof Result.Success)) {
            if (result instanceof Result.Error) {
                return result;
            }
            throw new NoWhenBranchMatchedException();
        }
        ItemId.Remote remote3 = (ItemId.Remote) ((Result.Success) result).getValue();
        ItemCollaborationsRemoteDataSource itemCollaborationsRemoteDataSource2 = this.itemCollaborationsRemoteDataSource;
        anonymousClass1.L$0 = itemId4;
        anonymousClass1.L$1 = str2;
        anonymousClass1.L$2 = SpillingKt.nullOutSpilledVariable(result);
        anonymousClass1.L$3 = remote3;
        anonymousClass1.I$0 = 0;
        anonymousClass1.I$1 = 0;
        anonymousClass1.label = 2;
        itemCollaborations = itemCollaborationsRemoteDataSource2.getItemCollaborations(remote3, null, anonymousClass1);
        if (itemCollaborations != coroutine_suspended) {
            itemId2 = itemId4;
            remote = remote3;
            str3 = str2;
            i = 0;
            i2 = 0;
            error = (Result) itemCollaborations;
            if (error instanceof Result.Success) {
                itemCollaborationsDTO = (ItemCollaborationsDTO) ((Result.Success) error).getValue();
                it = itemCollaborationsDTO.getEntries().iterator();
                do {
                    if (it.hasNext()) {
                        next = null;
                        break;
                    }
                    next = it.next();
                    accessibleBy = ((CollaborationDTO) next).getAccessibleBy();
                    if (accessibleBy != null) {
                        id = accessibleBy.getId();
                    } else {
                        id = null;
                    }
                } while (!Intrinsics.areEqual(id, str3));
                collaborationDTO = (CollaborationDTO) next;
                if (collaborationDTO == null) {
                    return new Result.Error(new DomainError.UnknownError("Expected collaboration not found"));
                }
                ItemCollaborationsRemoteDataSource itemCollaborationsRemoteDataSource3 = this.itemCollaborationsRemoteDataSource;
                String id3 = collaborationDTO.getId();
                anonymousClass1.L$0 = itemId2;
                anonymousClass1.L$1 = str3;
                anonymousClass1.L$2 = SpillingKt.nullOutSpilledVariable(result);
                anonymousClass1.L$3 = remote;
                anonymousClass1.L$4 = SpillingKt.nullOutSpilledVariable(error);
                anonymousClass1.L$5 = SpillingKt.nullOutSpilledVariable(itemCollaborationsDTO);
                anonymousClass1.L$6 = SpillingKt.nullOutSpilledVariable(collaborationDTO);
                anonymousClass1.I$0 = i2;
                anonymousClass1.I$1 = i;
                anonymousClass1.I$2 = 0;
                anonymousClass1.I$3 = 0;
                anonymousClass1.label = 3;
                remoteIdOrError = itemCollaborationsRemoteDataSource3.deleteCollaborations(id3, anonymousClass1);
                if (remoteIdOrError != coroutine_suspended) {
                    str4 = str3;
                    itemId3 = itemId2;
                    result2 = (Result) remoteIdOrError;
                    if (result2 instanceof Result.Success) {
                        error = result2;
                    } else {
                        if (result2 instanceof Result.Error) {
                            throw new NoWhenBranchMatchedException();
                        }
                        error = new Result.Error(DomainErrorMapper.toDomainError$default(DomainErrorMapper.INSTANCE, (RemoteError) ((Result.Error) result2).getValue(), null, 2, null));
                    }
                    if (error instanceof Result.Success) {
                        if (Intrinsics.areEqual(str4, this.userContextManager.getCurrentContextId())) {
                            this.boxCache.deleteFile(remote.getBoxId());
                        }
                    } else if (!(error instanceof Result.Error)) {
                        throw new NoWhenBranchMatchedException();
                    }
                    itemId2 = itemId3;
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
            return new Result.Error(DomainErrorMapper.INSTANCE.toDomainError((IGenericError) ((Result.Error) error).getValue(), "Error fetching collaborations for item with id " + itemId2));
        }
        return coroutine_suspended;
    }
}
