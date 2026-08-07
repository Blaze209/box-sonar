package com.box.android.data.service.impl;

import com.box.android.common.utilities.BoxCommonConstants;
import com.box.android.data.api.models.items.FolderDTO;
import com.box.android.data.api.models.items.IItemDTO;
import com.box.android.data.datasource.ItemRemoteDataSource;
import com.box.android.data.datasource.errors.ItemsRemoteError;
import com.box.android.data.datasource.errors.RemoteError;
import com.box.android.data.datasource.gql.CustomAttributeKeys;
import com.box.android.data.mappers.FolderDTOtoFolderModelMapper;
import com.box.android.domain.models.DomainError;
import com.box.android.domain.models.IGenericError;
import com.box.android.domain.models.item.FolderModel;
import com.box.android.domain.services.ICreateFolderService;
import com.box.android.domain.services.IdMappingService;
import com.box.android.domain.utils.result.Result;
import com.box.brownfieldApi.featuresNavigator.activities.ReactNativeFeatureActivity;
import java.util.List;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.ResultKt;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: CreateFolderService.kt */
/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 \u00182\u00020\u0001:\u0001\u0018B!\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ*\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\r0\u000b2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0011H\u0096@¢\u0006\u0002\u0010\u0012J(\u0010\u0013\u001a\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\r0\u000b2\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00160\u0015H\u0082@¢\u0006\u0002\u0010\u0017R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0019"}, d2 = {"Lcom/box/android/data/service/impl/CreateFolderService;", "Lcom/box/android/domain/services/ICreateFolderService;", "itemRemoteDataSource", "Lcom/box/android/data/datasource/ItemRemoteDataSource;", "commonServiceUtils", "Lcom/box/android/data/service/impl/CommonServiceUtils;", "idMappingService", "Lcom/box/android/domain/services/IdMappingService;", "<init>", "(Lcom/box/android/data/datasource/ItemRemoteDataSource;Lcom/box/android/data/service/impl/CommonServiceUtils;Lcom/box/android/domain/services/IdMappingService;)V", "createFolder", "Lcom/box/android/domain/utils/result/Result;", "Lcom/box/android/domain/models/item/FolderModel;", "Lcom/box/android/domain/models/DomainError;", BoxCommonConstants.EXTRA_FOLDER_NAME, "", "parentFolderId", "Lcom/box/android/domain/models/ItemId;", "(Ljava/lang/String;Lcom/box/android/domain/models/ItemId;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "handleResultError", ReactNativeFeatureActivity.RESULT_EXTRA_KEY, "Lcom/box/android/domain/utils/result/Result$Error;", "Lcom/box/android/data/datasource/errors/RemoteError;", "(Lcom/box/android/domain/utils/result/Result$Error;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Companion", "data_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class CreateFolderService implements ICreateFolderService {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final String TAG = "javaClass";
    private final CommonServiceUtils commonServiceUtils;
    private final IdMappingService idMappingService;
    private final ItemRemoteDataSource itemRemoteDataSource;

    /* JADX INFO: renamed from: com.box.android.data.service.impl.CreateFolderService$createFolder$1, reason: invalid class name */
    /* JADX INFO: compiled from: CreateFolderService.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.box.android.data.service.impl.CreateFolderService", f = "CreateFolderService.kt", i = {0, 0, 1, 1, 1, 1, 1, 1, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 3, 3, 3, 3, 3, 3, 3}, l = {27, 29, 31, 36}, m = "createFolder", n = {BoxCommonConstants.EXTRA_FOLDER_NAME, "parentFolderId", BoxCommonConstants.EXTRA_FOLDER_NAME, "parentFolderId", "$this$flatMap$iv", "parentFolderRemoteId", "$i$f$flatMap", "$i$a$-flatMap-CreateFolderService$createFolder$2", BoxCommonConstants.EXTRA_FOLDER_NAME, "parentFolderId", "$this$flatMap$iv", "parentFolderRemoteId", ReactNativeFeatureActivity.RESULT_EXTRA_KEY, "$this$flatMap$iv", "it", "$i$f$flatMap", "$i$a$-flatMap-CreateFolderService$createFolder$2", "$i$f$flatMap", "$i$a$-flatMap-CreateFolderService$createFolder$2$1", BoxCommonConstants.EXTRA_FOLDER_NAME, "parentFolderId", "$this$flatMap$iv", "parentFolderRemoteId", ReactNativeFeatureActivity.RESULT_EXTRA_KEY, "$i$f$flatMap", "$i$a$-flatMap-CreateFolderService$createFolder$2"}, s = {"L$0", "L$1", "L$0", "L$1", "L$2", "L$3", "I$0", "I$1", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "I$0", "I$1", "I$2", "I$3", "L$0", "L$1", "L$2", "L$3", "L$4", "I$0", "I$1"}, v = 1)
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
            return CreateFolderService.this.createFolder(null, null, this);
        }
    }

    /* JADX INFO: renamed from: com.box.android.data.service.impl.CreateFolderService$handleResultError$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: CreateFolderService.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.box.android.data.service.impl.CreateFolderService", f = "CreateFolderService.kt", i = {0, 0, 0, 0, 0, 0}, l = {43}, m = "handleResultError", n = {ReactNativeFeatureActivity.RESULT_EXTRA_KEY, CustomAttributeKeys.REMOTE_ERROR, "$this$flatMapError$iv", "it", "$i$f$flatMapError", "$i$a$-flatMapError-CreateFolderService$handleResultError$2"}, s = {"L$0", "L$1", "L$2", "L$3", "I$0", "I$1"}, v = 1)
    static final class C14181 extends ContinuationImpl {
        int I$0;
        int I$1;
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        int label;
        /* synthetic */ Object result;

        C14181(Continuation<? super C14181> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return CreateFolderService.this.handleResultError(null, this);
        }
    }

    @Inject
    public CreateFolderService(ItemRemoteDataSource itemRemoteDataSource, CommonServiceUtils commonServiceUtils, IdMappingService idMappingService) {
        Intrinsics.checkNotNullParameter(itemRemoteDataSource, "itemRemoteDataSource");
        Intrinsics.checkNotNullParameter(commonServiceUtils, "commonServiceUtils");
        Intrinsics.checkNotNullParameter(idMappingService, "idMappingService");
        this.itemRemoteDataSource = itemRemoteDataSource;
        this.commonServiceUtils = commonServiceUtils;
        this.idMappingService = idMappingService;
    }

    /* JADX INFO: compiled from: CreateFolderService.kt */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Lcom/box/android/data/service/impl/CreateFolderService$Companion;", "", "<init>", "()V", "TAG", "", "getTAG", "()Ljava/lang/String;", "data_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final String getTAG() {
            return CreateFolderService.TAG;
        }
    }

    /* JADX WARN: Code duplicated, block: B:31:0x00fd A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:32:0x00ff  */
    /* JADX WARN: Code duplicated, block: B:35:0x0146  */
    /* JADX WARN: Code duplicated, block: B:37:0x014c  */
    /* JADX WARN: Code duplicated, block: B:39:0x0150  */
    /* JADX WARN: Code duplicated, block: B:42:0x0155  */
    /* JADX WARN: Code duplicated, block: B:43:0x0174  */
    /* JADX WARN: Code duplicated, block: B:47:0x017c A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:48:0x017d  */
    /* JADX WARN: Code duplicated, block: B:50:0x0181  */
    /* JADX WARN: Code duplicated, block: B:52:0x019a  */
    /* JADX WARN: Code duplicated, block: B:54:0x01a0  */
    /* JADX WARN: Code duplicated, block: B:56:0x01a6  */
    /* JADX WARN: Code duplicated, block: B:58:0x01ac  */
    /* JADX WARN: Code duplicated, block: B:60:0x01b0  */
    /* JADX WARN: Code duplicated, block: B:65:0x01e1  */
    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    /* JADX WARN: Code restructure failed: missing block: B:61:0x01db, code lost:
    
        if (r15 == r1) goto L62;
     */
    @Override // com.box.android.domain.services.ICreateFolderService
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.Object createFolder(java.lang.String r13, com.box.android.domain.models.ItemId r14, kotlin.coroutines.Continuation<? super com.box.android.domain.utils.result.Result<com.box.android.domain.models.item.FolderModel, ? extends com.box.android.domain.models.DomainError>> r15) {
        /*
            Method dump skipped, instruction units count: 498
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.box.android.data.service.impl.CreateFolderService.createFolder(java.lang.String, com.box.android.domain.models.ItemId, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:28:0x00a0  */
    /* JADX WARN: Code duplicated, block: B:30:0x00b9  */
    /* JADX WARN: Code duplicated, block: B:31:0x00d8  */
    /* JADX WARN: Code duplicated, block: B:32:0x00e1  */
    /* JADX WARN: Code duplicated, block: B:36:0x00e9 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:37:0x00ea  */
    /* JADX WARN: Code duplicated, block: B:39:0x00ee  */
    /* JADX WARN: Code duplicated, block: B:41:0x0104  */
    /* JADX WARN: Code duplicated, block: B:43:0x010a  */
    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    public final Object handleResultError(Result.Error<? extends RemoteError> error, Continuation<? super Result<FolderModel, ? extends DomainError>> continuation) {
        C14181 c14181;
        RemoteError value;
        Result.Error<? extends RemoteError> error2;
        RemoteError remoteError;
        ItemsRemoteError.NameConflict nameConflict;
        if (continuation instanceof C14181) {
            c14181 = (C14181) continuation;
            if ((c14181.label & Integer.MIN_VALUE) != 0) {
                c14181.label -= Integer.MIN_VALUE;
            } else {
                c14181 = new C14181(continuation);
            }
        } else {
            c14181 = new C14181(continuation);
        }
        Object obj = c14181.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = c14181.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            value = error.getValue();
            if (value instanceof ItemsRemoteError.NameConflict) {
                error2 = error;
                if (!(error2 instanceof Result.Success)) {
                    if (error2 instanceof Result.Error) {
                        RemoteError remoteError2 = (RemoteError) error2.getValue();
                        CommonServiceUtils commonServiceUtils = this.commonServiceUtils;
                        List<IItemDTO> itemDTOs = ((ItemsRemoteError.NameConflict) value).getItemDTOs();
                        c14181.L$0 = SpillingKt.nullOutSpilledVariable(error);
                        c14181.L$1 = value;
                        c14181.L$2 = SpillingKt.nullOutSpilledVariable(error2);
                        c14181.L$3 = SpillingKt.nullOutSpilledVariable(remoteError2);
                        c14181.I$0 = 0;
                        c14181.I$1 = 0;
                        c14181.label = 1;
                        Object objSaveInLegacyCache = commonServiceUtils.saveInLegacyCache(itemDTOs, c14181);
                        if (objSaveInLegacyCache == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        obj = objSaveInLegacyCache;
                        remoteError = value;
                    } else {
                        throw new NoWhenBranchMatchedException();
                    }
                }
                if (error2 instanceof Result.Success) {
                    nameConflict = (ItemsRemoteError.NameConflict) value;
                    if (((IItemDTO) CollectionsKt.first((List) nameConflict.getItemDTOs())) instanceof FolderDTO) {
                        FolderDTOtoFolderModelMapper folderDTOtoFolderModelMapper = FolderDTOtoFolderModelMapper.INSTANCE;
                        Object objFirst = CollectionsKt.first((List<? extends Object>) nameConflict.getItemDTOs());
                        Intrinsics.checkNotNull(objFirst, "null cannot be cast to non-null type com.box.android.data.api.models.items.FolderDTO");
                        error2 = new Result.Success(folderDTOtoFolderModelMapper.toDomain((FolderDTO) objFirst));
                    } else {
                        error2 = new Result.Error(value);
                    }
                } else if (!(error2 instanceof Result.Error)) {
                    throw new NoWhenBranchMatchedException();
                }
                if (error2 instanceof Result.Success) {
                    return error2;
                }
                if (error2 instanceof Result.Error) {
                    throw new NoWhenBranchMatchedException();
                }
                return new Result.Error(DomainErrorMapper.toDomainError$default(DomainErrorMapper.INSTANCE, (IGenericError) ((Result.Error) error2).getValue(), null, 2, null));
            }
            return new Result.Error(DomainErrorMapper.toDomainError$default(DomainErrorMapper.INSTANCE, value, null, 2, null));
        }
        if (i != 1) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        int i2 = c14181.I$1;
        int i3 = c14181.I$0;
        remoteError = (RemoteError) c14181.L$1;
        ResultKt.throwOnFailure(obj);
        error2 = (Result) obj;
        value = remoteError;
        if (error2 instanceof Result.Success) {
            nameConflict = (ItemsRemoteError.NameConflict) value;
            if (((IItemDTO) CollectionsKt.first((List) nameConflict.getItemDTOs())) instanceof FolderDTO) {
                FolderDTOtoFolderModelMapper folderDTOtoFolderModelMapper2 = FolderDTOtoFolderModelMapper.INSTANCE;
                Object objFirst2 = CollectionsKt.first((List<? extends Object>) nameConflict.getItemDTOs());
                Intrinsics.checkNotNull(objFirst2, "null cannot be cast to non-null type com.box.android.data.api.models.items.FolderDTO");
                error2 = new Result.Success(folderDTOtoFolderModelMapper2.toDomain((FolderDTO) objFirst2));
            } else {
                error2 = new Result.Error(value);
            }
        } else if (!(error2 instanceof Result.Error)) {
            throw new NoWhenBranchMatchedException();
        }
        if (error2 instanceof Result.Success) {
            return error2;
        }
        if (error2 instanceof Result.Error) {
            throw new NoWhenBranchMatchedException();
        }
        return new Result.Error(DomainErrorMapper.toDomainError$default(DomainErrorMapper.INSTANCE, (IGenericError) ((Result.Error) error2).getValue(), null, 2, null));
    }
}
