package com.box.android.data.service.impl;

import com.box.android.data.datasource.errors.RemoteError;
import com.box.android.data.datasource.files.DeleteFileRemoteDataSource;
import com.box.android.domain.models.DomainError;
import com.box.android.domain.models.ItemId;
import com.box.android.domain.services.IDeleteFileService;
import com.box.android.domain.services.IdMappingService;
import com.box.android.domain.utils.result.Result;
import com.box.androidsdk.content.BoxCache;
import java.sql.SQLException;
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

/* JADX INFO: compiled from: DeleteFileService.kt */
/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\u0018\u00002\u00020\u0001B!\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ,\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\r0\u000b2\u0006\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011H\u0096@¢\u0006\u0002\u0010\u0012R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0013"}, d2 = {"Lcom/box/android/data/service/impl/DeleteFileService;", "Lcom/box/android/domain/services/IDeleteFileService;", "deleteFileRemoteDataSource", "Lcom/box/android/data/datasource/files/DeleteFileRemoteDataSource;", "boxCache", "Lcom/box/androidsdk/content/BoxCache;", "idMappingService", "Lcom/box/android/domain/services/IdMappingService;", "<init>", "(Lcom/box/android/data/datasource/files/DeleteFileRemoteDataSource;Lcom/box/androidsdk/content/BoxCache;Lcom/box/android/domain/services/IdMappingService;)V", "deleteFile", "Lcom/box/android/domain/utils/result/Result;", "", "Lcom/box/android/domain/models/DomainError;", "fileId", "Lcom/box/android/domain/models/ItemId;", "ifMatchEtag", "", "(Lcom/box/android/domain/models/ItemId;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "data_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class DeleteFileService implements IDeleteFileService {
    private final BoxCache boxCache;
    private final DeleteFileRemoteDataSource deleteFileRemoteDataSource;
    private final IdMappingService idMappingService;

    /* JADX INFO: renamed from: com.box.android.data.service.impl.DeleteFileService$deleteFile$1, reason: invalid class name */
    /* JADX INFO: compiled from: DeleteFileService.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.box.android.data.service.impl.DeleteFileService", f = "DeleteFileService.kt", i = {0, 0, 1, 1, 1, 1, 1, 1}, l = {22, 24}, m = "deleteFile", n = {"fileId", "ifMatchEtag", "fileId", "ifMatchEtag", "$this$flatMap$iv", "remoteId", "$i$f$flatMap", "$i$a$-flatMap-DeleteFileService$deleteFile$2"}, s = {"L$0", "L$1", "L$0", "L$1", "L$2", "L$3", "I$0", "I$1"}, v = 1)
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
            return DeleteFileService.this.deleteFile(null, null, this);
        }
    }

    @Inject
    public DeleteFileService(DeleteFileRemoteDataSource deleteFileRemoteDataSource, BoxCache boxCache, IdMappingService idMappingService) {
        Intrinsics.checkNotNullParameter(deleteFileRemoteDataSource, "deleteFileRemoteDataSource");
        Intrinsics.checkNotNullParameter(boxCache, "boxCache");
        Intrinsics.checkNotNullParameter(idMappingService, "idMappingService");
        this.deleteFileRemoteDataSource = deleteFileRemoteDataSource;
        this.boxCache = boxCache;
        this.idMappingService = idMappingService;
    }

    /* JADX WARN: Code duplicated, block: B:27:0x00a6  */
    /* JADX WARN: Code duplicated, block: B:28:0x00b9  */
    /* JADX WARN: Code duplicated, block: B:31:0x00bf A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:32:0x00c0  */
    /* JADX WARN: Code duplicated, block: B:34:0x00c4  */
    /* JADX WARN: Code duplicated, block: B:36:0x00dd  */
    /* JADX WARN: Code duplicated, block: B:38:0x00e3  */
    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    @Override // com.box.android.domain.services.IDeleteFileService
    public Object deleteFile(ItemId itemId, String str, Continuation<? super Result<Unit, ? extends DomainError>> continuation) throws SQLException {
        AnonymousClass1 anonymousClass1;
        ItemId.Remote remote;
        Result result;
        boolean z;
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
        int i = anonymousClass1.label;
        if (i != 0) {
            if (i == 1) {
                str = (String) anonymousClass1.L$1;
                itemId = (ItemId) anonymousClass1.L$0;
                ResultKt.throwOnFailure(remoteIdOrError);
            } else {
                if (i != 2) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                int i2 = anonymousClass1.I$1;
                int i3 = anonymousClass1.I$0;
                remote = (ItemId.Remote) anonymousClass1.L$3;
                ResultKt.throwOnFailure(remoteIdOrError);
            }
            result = (Result) remoteIdOrError;
            z = result instanceof Result.Success;
            if (z) {
                this.boxCache.deleteFile(remote.getBoxId());
            } else if (!(result instanceof Result.Error)) {
                throw new NoWhenBranchMatchedException();
            }
            if (z) {
                return result;
            }
            if (result instanceof Result.Error) {
                throw new NoWhenBranchMatchedException();
            }
            return new Result.Error(DomainErrorMapper.toDomainError$default(DomainErrorMapper.INSTANCE, (RemoteError) ((Result.Error) result).getValue(), null, 2, null));
        }
        ResultKt.throwOnFailure(remoteIdOrError);
        IdMappingService idMappingService = this.idMappingService;
        anonymousClass1.L$0 = SpillingKt.nullOutSpilledVariable(itemId);
        anonymousClass1.L$1 = str;
        anonymousClass1.label = 1;
        remoteIdOrError = idMappingService.getRemoteIdOrError(itemId, anonymousClass1);
        if (remoteIdOrError != coroutine_suspended) {
        }
        return coroutine_suspended;
        Result result2 = (Result) remoteIdOrError;
        if (result2 instanceof Result.Success) {
            ItemId.Remote remote2 = (ItemId.Remote) ((Result.Success) result2).getValue();
            DeleteFileRemoteDataSource deleteFileRemoteDataSource = this.deleteFileRemoteDataSource;
            anonymousClass1.L$0 = SpillingKt.nullOutSpilledVariable(itemId);
            anonymousClass1.L$1 = SpillingKt.nullOutSpilledVariable(str);
            anonymousClass1.L$2 = SpillingKt.nullOutSpilledVariable(result2);
            anonymousClass1.L$3 = remote2;
            anonymousClass1.I$0 = 0;
            anonymousClass1.I$1 = 0;
            anonymousClass1.label = 2;
            remoteIdOrError = deleteFileRemoteDataSource.deleteFile(remote2, str, anonymousClass1);
            if (remoteIdOrError != coroutine_suspended) {
                remote = remote2;
                result = (Result) remoteIdOrError;
                z = result instanceof Result.Success;
                if (z) {
                    this.boxCache.deleteFile(remote.getBoxId());
                } else if (!(result instanceof Result.Error)) {
                    throw new NoWhenBranchMatchedException();
                }
                if (z) {
                    return result;
                }
                if (result instanceof Result.Error) {
                    throw new NoWhenBranchMatchedException();
                }
                return new Result.Error(DomainErrorMapper.toDomainError$default(DomainErrorMapper.INSTANCE, (RemoteError) ((Result.Error) result).getValue(), null, 2, null));
            }
            return coroutine_suspended;
        }
        if (result2 instanceof Result.Error) {
            return result2;
        }
        throw new NoWhenBranchMatchedException();
    }
}
