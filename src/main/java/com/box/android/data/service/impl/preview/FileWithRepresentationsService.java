package com.box.android.data.service.impl.preview;

import com.box.android.data.api.models.RepresentationDTO;
import com.box.android.data.api.models.RepresentationsDTO;
import com.box.android.data.api.models.items.FileDTO;
import com.box.android.data.datasource.CacheError;
import com.box.android.data.datasource.LegacyCacheDataSource;
import com.box.android.data.datasource.gql.CustomAttributeKeys;
import com.box.android.data.datasource.representations.RepresentationsCacheDataSource;
import com.box.android.data.datasource.representations.RepresentationsRemoteDataSource;
import com.box.android.data.mappers.FileDTOtoFileModelMapper;
import com.box.android.data.mappers.representations.RepresentationDTODomainMapper;
import com.box.android.data.service.impl.DomainErrorMapper;
import com.box.android.domain.configuration.DataPolicy;
import com.box.android.domain.models.DomainError;
import com.box.android.domain.models.IGenericError;
import com.box.android.domain.models.ItemId;
import com.box.android.domain.models.RepresentationModel;
import com.box.android.domain.models.item.FileModel;
import com.box.android.domain.services.FileWithRepresentationsResult;
import com.box.android.domain.services.IFileWithRepresentationsService;
import com.box.android.domain.services.ILocalItemService;
import com.box.android.domain.services.IdMappingService;
import com.box.android.domain.utils.result.Result;
import com.box.androidsdk.content.models.BoxFile;
import java.util.ArrayList;
import java.util.Iterator;
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
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: compiled from: FileWithRepresentationsService.kt */
/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0000\u0018\u00002\u00020\u0001B1\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b¢\u0006\u0004\b\f\u0010\rJ\u001e\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0013H\u0096@¢\u0006\u0002\u0010\u0014J \u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u001aH\u0082@¢\u0006\u0002\u0010\u001bJ&\u0010\u001c\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u0012\u001a\u00020\u0013H\u0082@¢\u0006\u0002\u0010\u001fJ0\u0010 \u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020#0\"\u0012\u0004\u0012\u00020$0!2\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0012\u001a\u00020\u0013H\u0082@¢\u0006\u0002\u0010%J\"\u0010&\u001a\u000e\u0012\u0004\u0012\u00020\u0018\u0012\u0004\u0012\u00020\u001e0!2\u0006\u0010\u0010\u001a\u00020\u0011H\u0082@¢\u0006\u0002\u0010'J\u0010\u0010(\u001a\u00020)2\u0006\u0010\u0012\u001a\u00020\u0013H\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006*"}, d2 = {"Lcom/box/android/data/service/impl/preview/FileWithRepresentationsService;", "Lcom/box/android/domain/services/IFileWithRepresentationsService;", "representationsRemoteDataSource", "Lcom/box/android/data/datasource/representations/RepresentationsRemoteDataSource;", "representationsCacheDataSource", "Lcom/box/android/data/datasource/representations/RepresentationsCacheDataSource;", "legacyCacheDataSource", "Lcom/box/android/data/datasource/LegacyCacheDataSource;", "mappingService", "Lcom/box/android/domain/services/IdMappingService;", "localItemService", "Lcom/box/android/domain/services/ILocalItemService;", "<init>", "(Lcom/box/android/data/datasource/representations/RepresentationsRemoteDataSource;Lcom/box/android/data/datasource/representations/RepresentationsCacheDataSource;Lcom/box/android/data/datasource/LegacyCacheDataSource;Lcom/box/android/domain/services/IdMappingService;Lcom/box/android/domain/services/ILocalItemService;)V", "fetchFileWithRepresentations", "Lcom/box/android/domain/services/FileWithRepresentationsResult;", "itemId", "Lcom/box/android/domain/models/ItemId;", "forOffline", "", "(Lcom/box/android/domain/models/ItemId;ZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "updateCache", "", "fileModel", "Lcom/box/android/domain/models/item/FileModel;", BoxFile.FIELD_REPRESENTATIONS, "Lcom/box/android/data/api/models/RepresentationsDTO;", "(Lcom/box/android/domain/models/item/FileModel;Lcom/box/android/data/api/models/RepresentationsDTO;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "fetchFromCache", CustomAttributeKeys.REMOTE_ERROR, "Lcom/box/android/domain/models/DomainError;", "(Lcom/box/android/domain/models/ItemId;Lcom/box/android/domain/models/DomainError;ZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getCachedRepresentations", "Lcom/box/android/domain/utils/result/Result;", "", "Lcom/box/android/domain/models/RepresentationModel;", "Lcom/box/android/data/datasource/CacheError;", "(Lcom/box/android/domain/models/item/FileModel;ZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getCachedFileModel", "(Lcom/box/android/domain/models/ItemId;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getRepresentationHeader", "", "data_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class FileWithRepresentationsService implements IFileWithRepresentationsService {
    private final LegacyCacheDataSource legacyCacheDataSource;
    private final ILocalItemService localItemService;
    private final IdMappingService mappingService;
    private final RepresentationsCacheDataSource representationsCacheDataSource;
    private final RepresentationsRemoteDataSource representationsRemoteDataSource;

    /* JADX INFO: renamed from: com.box.android.data.service.impl.preview.FileWithRepresentationsService$fetchFileWithRepresentations$1, reason: invalid class name */
    /* JADX INFO: compiled from: FileWithRepresentationsService.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.box.android.data.service.impl.preview.FileWithRepresentationsService", f = "FileWithRepresentationsService.kt", i = {0, 0, 1, 1, 1, 1, 2, 2, 2, 2, 2, 2, 2, 3, 3, 3, 3, 3}, l = {36, 44, 49, 57}, m = "fetchFileWithRepresentations", n = {"itemId", "forOffline", "itemId", "remoteId", "repHeader", "forOffline", "itemId", "remoteId", "repHeader", "remoteFetchResult", "fileDto", "updatedFileModel", "forOffline", "itemId", "remoteId", "repHeader", "remoteFetchResult", "forOffline"}, s = {"L$0", "Z$0", "L$0", "L$1", "L$2", "Z$0", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "Z$0", "L$0", "L$1", "L$2", "L$3", "Z$0"}, v = 1)
    static final class AnonymousClass1 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        Object L$4;
        Object L$5;
        boolean Z$0;
        int label;
        /* synthetic */ Object result;

        AnonymousClass1(Continuation<? super AnonymousClass1> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return FileWithRepresentationsService.this.fetchFileWithRepresentations(null, false, this);
        }
    }

    /* JADX INFO: renamed from: com.box.android.data.service.impl.preview.FileWithRepresentationsService$fetchFromCache$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: FileWithRepresentationsService.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.box.android.data.service.impl.preview.FileWithRepresentationsService", f = "FileWithRepresentationsService.kt", i = {0, 0, 0, 1, 1, 1, 1}, l = {75, 80}, m = "fetchFromCache", n = {"itemId", CustomAttributeKeys.REMOTE_ERROR, "forOffline", "itemId", CustomAttributeKeys.REMOTE_ERROR, "cachedFileModel", "forOffline"}, s = {"L$0", "L$1", "Z$0", "L$0", "L$1", "L$2", "Z$0"}, v = 1)
    static final class C15531 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        Object L$2;
        boolean Z$0;
        int label;
        /* synthetic */ Object result;

        C15531(Continuation<? super C15531> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return FileWithRepresentationsService.this.fetchFromCache(null, null, false, this);
        }
    }

    /* JADX INFO: renamed from: com.box.android.data.service.impl.preview.FileWithRepresentationsService$getCachedFileModel$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: FileWithRepresentationsService.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.box.android.data.service.impl.preview.FileWithRepresentationsService", f = "FileWithRepresentationsService.kt", i = {0}, l = {108}, m = "getCachedFileModel", n = {"itemId"}, s = {"L$0"}, v = 1)
    static final class C15541 extends ContinuationImpl {
        Object L$0;
        int label;
        /* synthetic */ Object result;

        C15541(Continuation<? super C15541> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return FileWithRepresentationsService.this.getCachedFileModel(null, this);
        }
    }

    /* JADX INFO: renamed from: com.box.android.data.service.impl.preview.FileWithRepresentationsService$getCachedRepresentations$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: FileWithRepresentationsService.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.box.android.data.service.impl.preview.FileWithRepresentationsService", f = "FileWithRepresentationsService.kt", i = {0, 0, 0}, l = {97}, m = "getCachedRepresentations", n = {"fileModel", "repHeader", "forOffline"}, s = {"L$0", "L$1", "Z$0"}, v = 1)
    static final class C15551 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        boolean Z$0;
        int label;
        /* synthetic */ Object result;

        C15551(Continuation<? super C15551> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return FileWithRepresentationsService.this.getCachedRepresentations(null, false, this);
        }
    }

    /* JADX INFO: renamed from: com.box.android.data.service.impl.preview.FileWithRepresentationsService$updateCache$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: FileWithRepresentationsService.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.box.android.data.service.impl.preview.FileWithRepresentationsService", f = "FileWithRepresentationsService.kt", i = {0, 0, 1, 1}, l = {67, 71}, m = "updateCache", n = {"fileModel", BoxFile.FIELD_REPRESENTATIONS, "fileModel", BoxFile.FIELD_REPRESENTATIONS}, s = {"L$0", "L$1", "L$0", "L$1"}, v = 1)
    static final class C15561 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        int label;
        /* synthetic */ Object result;

        C15561(Continuation<? super C15561> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return FileWithRepresentationsService.this.updateCache(null, null, this);
        }
    }

    @Inject
    public FileWithRepresentationsService(RepresentationsRemoteDataSource representationsRemoteDataSource, RepresentationsCacheDataSource representationsCacheDataSource, LegacyCacheDataSource legacyCacheDataSource, IdMappingService mappingService, ILocalItemService localItemService) {
        Intrinsics.checkNotNullParameter(representationsRemoteDataSource, "representationsRemoteDataSource");
        Intrinsics.checkNotNullParameter(representationsCacheDataSource, "representationsCacheDataSource");
        Intrinsics.checkNotNullParameter(legacyCacheDataSource, "legacyCacheDataSource");
        Intrinsics.checkNotNullParameter(mappingService, "mappingService");
        Intrinsics.checkNotNullParameter(localItemService, "localItemService");
        this.representationsRemoteDataSource = representationsRemoteDataSource;
        this.representationsCacheDataSource = representationsCacheDataSource;
        this.legacyCacheDataSource = legacyCacheDataSource;
        this.mappingService = mappingService;
        this.localItemService = localItemService;
    }

    /* JADX WARN: Code duplicated, block: B:34:0x0102  */
    /* JADX WARN: Code duplicated, block: B:37:0x0140  */
    /* JADX WARN: Code duplicated, block: B:40:0x0149  */
    /* JADX WARN: Code duplicated, block: B:43:0x0151  */
    /* JADX WARN: Code duplicated, block: B:45:0x0155  */
    /* JADX WARN: Code duplicated, block: B:48:0x0188 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:49:0x0189  */
    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    @Override // com.box.android.domain.services.IFileWithRepresentationsService
    public Object fetchFileWithRepresentations(ItemId itemId, boolean z, Continuation<? super FileWithRepresentationsResult> continuation) {
        AnonymousClass1 anonymousClass1;
        ItemId.Remote remote;
        ItemId itemId2;
        boolean z2;
        String str;
        Result result;
        Object objFetchFromCache;
        FileModel domain;
        RepresentationsDTO representations;
        FileModel fileModel;
        List<RepresentationModel> representations2;
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
        Object remoteId = anonymousClass1.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = anonymousClass1.label;
        if (i == 0) {
            ResultKt.throwOnFailure(remoteId);
            IdMappingService idMappingService = this.mappingService;
            anonymousClass1.L$0 = itemId;
            anonymousClass1.Z$0 = z;
            anonymousClass1.label = 1;
            remoteId = idMappingService.getRemoteId(itemId, anonymousClass1);
            if (remoteId != coroutine_suspended) {
            }
            return coroutine_suspended;
        }
        if (i == 1) {
            z = anonymousClass1.Z$0;
            itemId = (ItemId) anonymousClass1.L$0;
            ResultKt.throwOnFailure(remoteId);
        } else {
            if (i == 2) {
                z2 = anonymousClass1.Z$0;
                str = (String) anonymousClass1.L$2;
                remote = (ItemId.Remote) anonymousClass1.L$1;
                itemId2 = (ItemId) anonymousClass1.L$0;
                ResultKt.throwOnFailure(remoteId);
                result = (Result) remoteId;
                if (result instanceof Result.Success) {
                    FileDTO fileDTO = (FileDTO) ((Result.Success) result).getValue();
                    domain = FileDTOtoFileModelMapper.INSTANCE.toDomain(fileDTO);
                    representations = fileDTO.getRepresentations();
                    anonymousClass1.L$0 = SpillingKt.nullOutSpilledVariable(itemId2);
                    anonymousClass1.L$1 = SpillingKt.nullOutSpilledVariable(remote);
                    anonymousClass1.L$2 = SpillingKt.nullOutSpilledVariable(str);
                    anonymousClass1.L$3 = SpillingKt.nullOutSpilledVariable(result);
                    anonymousClass1.L$4 = SpillingKt.nullOutSpilledVariable(fileDTO);
                    anonymousClass1.L$5 = domain;
                    anonymousClass1.Z$0 = z2;
                    anonymousClass1.label = 3;
                    if (updateCache(domain, representations, anonymousClass1) != coroutine_suspended) {
                        fileModel = domain;
                    }
                } else {
                    if (result instanceof Result.Error) {
                        throw new NoWhenBranchMatchedException();
                    }
                    DomainError domainError$default = DomainErrorMapper.toDomainError$default(DomainErrorMapper.INSTANCE, (IGenericError) ((Result.Error) result).getValue(), null, 2, null);
                    anonymousClass1.L$0 = SpillingKt.nullOutSpilledVariable(itemId2);
                    anonymousClass1.L$1 = SpillingKt.nullOutSpilledVariable(remote);
                    anonymousClass1.L$2 = SpillingKt.nullOutSpilledVariable(str);
                    anonymousClass1.L$3 = SpillingKt.nullOutSpilledVariable(result);
                    anonymousClass1.Z$0 = z2;
                    anonymousClass1.label = 4;
                    objFetchFromCache = fetchFromCache(itemId2, domainError$default, z2, anonymousClass1);
                    if (objFetchFromCache == coroutine_suspended) {
                        return objFetchFromCache;
                    }
                }
                return coroutine_suspended;
            }
            if (i != 3) {
                if (i != 4) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                boolean z3 = anonymousClass1.Z$0;
                ResultKt.throwOnFailure(remoteId);
                return remoteId;
            }
            boolean z4 = anonymousClass1.Z$0;
            fileModel = (FileModel) anonymousClass1.L$5;
            ResultKt.throwOnFailure(remoteId);
        }
        representations2 = fileModel.getRepresentations();
        if (representations2 == null) {
            representations2 = CollectionsKt.emptyList();
        }
        return new FileWithRepresentationsResult.Success(fileModel, representations2);
        remote = (ItemId.Remote) remoteId;
        if (remote == null) {
            return new FileWithRepresentationsResult.Error(new DomainError.NoResultFoundError("No remote id found for item with id: " + itemId), new DomainError.NoResultFoundError("No cached representation may exist for local item with id: " + itemId));
        }
        String representationHeader = getRepresentationHeader(z);
        RepresentationsRemoteDataSource representationsRemoteDataSource = this.representationsRemoteDataSource;
        String boxId = remote.getBoxId();
        anonymousClass1.L$0 = itemId;
        anonymousClass1.L$1 = SpillingKt.nullOutSpilledVariable(remote);
        anonymousClass1.L$2 = SpillingKt.nullOutSpilledVariable(representationHeader);
        anonymousClass1.Z$0 = z;
        anonymousClass1.label = 2;
        Object fileWithRepresentations = representationsRemoteDataSource.getFileWithRepresentations(boxId, representationHeader, anonymousClass1);
        if (fileWithRepresentations != coroutine_suspended) {
            itemId2 = itemId;
            z2 = z;
            str = representationHeader;
            remoteId = fileWithRepresentations;
            result = (Result) remoteId;
            if (result instanceof Result.Success) {
                FileDTO fileDTO2 = (FileDTO) ((Result.Success) result).getValue();
                domain = FileDTOtoFileModelMapper.INSTANCE.toDomain(fileDTO2);
                representations = fileDTO2.getRepresentations();
                anonymousClass1.L$0 = SpillingKt.nullOutSpilledVariable(itemId2);
                anonymousClass1.L$1 = SpillingKt.nullOutSpilledVariable(remote);
                anonymousClass1.L$2 = SpillingKt.nullOutSpilledVariable(str);
                anonymousClass1.L$3 = SpillingKt.nullOutSpilledVariable(result);
                anonymousClass1.L$4 = SpillingKt.nullOutSpilledVariable(fileDTO2);
                anonymousClass1.L$5 = domain;
                anonymousClass1.Z$0 = z2;
                anonymousClass1.label = 3;
                if (updateCache(domain, representations, anonymousClass1) != coroutine_suspended) {
                    fileModel = domain;
                    representations2 = fileModel.getRepresentations();
                    if (representations2 == null) {
                        representations2 = CollectionsKt.emptyList();
                    }
                    return new FileWithRepresentationsResult.Success(fileModel, representations2);
                }
            } else {
                if (result instanceof Result.Error) {
                    throw new NoWhenBranchMatchedException();
                }
                DomainError domainError$default2 = DomainErrorMapper.toDomainError$default(DomainErrorMapper.INSTANCE, (IGenericError) ((Result.Error) result).getValue(), null, 2, null);
                anonymousClass1.L$0 = SpillingKt.nullOutSpilledVariable(itemId2);
                anonymousClass1.L$1 = SpillingKt.nullOutSpilledVariable(remote);
                anonymousClass1.L$2 = SpillingKt.nullOutSpilledVariable(str);
                anonymousClass1.L$3 = SpillingKt.nullOutSpilledVariable(result);
                anonymousClass1.Z$0 = z2;
                anonymousClass1.label = 4;
                objFetchFromCache = fetchFromCache(itemId2, domainError$default2, z2, anonymousClass1);
                if (objFetchFromCache == coroutine_suspended) {
                    return objFetchFromCache;
                }
            }
        }
        return coroutine_suspended;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x0084, code lost:
    
        if (r6.saveItem((com.box.android.domain.models.item.ItemModel) r9, true, (kotlin.coroutines.Continuation<? super com.box.android.domain.utils.result.Result<kotlin.Unit, com.box.android.data.datasource.CacheError.SaveError>>) r0) == r1) goto L25;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object updateCache(com.box.android.domain.models.item.FileModel r7, com.box.android.data.api.models.RepresentationsDTO r8, kotlin.coroutines.Continuation<? super kotlin.Unit> r9) {
        /*
            r6 = this;
            boolean r0 = r9 instanceof com.box.android.data.service.impl.preview.FileWithRepresentationsService.C15561
            if (r0 == 0) goto L14
            r0 = r9
            com.box.android.data.service.impl.preview.FileWithRepresentationsService$updateCache$1 r0 = (com.box.android.data.service.impl.preview.FileWithRepresentationsService.C15561) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L14
            int r9 = r0.label
            int r9 = r9 - r2
            r0.label = r9
            goto L19
        L14:
            com.box.android.data.service.impl.preview.FileWithRepresentationsService$updateCache$1 r0 = new com.box.android.data.service.impl.preview.FileWithRepresentationsService$updateCache$1
            r0.<init>(r9)
        L19:
            java.lang.Object r9 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 2
            r4 = 1
            if (r2 == 0) goto L4a
            if (r2 == r4) goto L3d
            if (r2 != r3) goto L35
            java.lang.Object r6 = r0.L$1
            com.box.android.data.api.models.RepresentationsDTO r6 = (com.box.android.data.api.models.RepresentationsDTO) r6
            java.lang.Object r6 = r0.L$0
            com.box.android.domain.models.item.FileModel r6 = (com.box.android.domain.models.item.FileModel) r6
            kotlin.ResultKt.throwOnFailure(r9)
            goto L87
        L35:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r7)
            throw r6
        L3d:
            java.lang.Object r7 = r0.L$1
            r8 = r7
            com.box.android.data.api.models.RepresentationsDTO r8 = (com.box.android.data.api.models.RepresentationsDTO) r8
            java.lang.Object r7 = r0.L$0
            com.box.android.domain.models.item.FileModel r7 = (com.box.android.domain.models.item.FileModel) r7
            kotlin.ResultKt.throwOnFailure(r9)
            goto L6d
        L4a:
            kotlin.ResultKt.throwOnFailure(r9)
            com.box.android.data.datasource.representations.RepresentationsCacheDataSource r9 = r6.representationsCacheDataSource
            if (r8 != 0) goto L5b
            com.box.android.data.api.models.RepresentationsDTO r2 = new com.box.android.data.api.models.RepresentationsDTO
            java.util.List r5 = kotlin.collections.CollectionsKt.emptyList()
            r2.<init>(r5)
            goto L5c
        L5b:
            r2 = r8
        L5c:
            r0.L$0 = r7
            java.lang.Object r5 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r8)
            r0.L$1 = r5
            r0.label = r4
            java.lang.Object r9 = r9.updateFileRepresentations(r7, r2, r0)
            if (r9 != r1) goto L6d
            goto L86
        L6d:
            com.box.android.data.datasource.LegacyCacheDataSource r6 = r6.legacyCacheDataSource
            r9 = r7
            com.box.android.domain.models.item.ItemModel r9 = (com.box.android.domain.models.item.ItemModel) r9
            java.lang.Object r7 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r7)
            r0.L$0 = r7
            java.lang.Object r7 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r8)
            r0.L$1 = r7
            r0.label = r3
            java.lang.Object r6 = r6.saveItem(r9, r4, r0)
            if (r6 != r1) goto L87
        L86:
            return r1
        L87:
            kotlin.Unit r6 = kotlin.Unit.INSTANCE
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.box.android.data.service.impl.preview.FileWithRepresentationsService.updateCache(com.box.android.domain.models.item.FileModel, com.box.android.data.api.models.RepresentationsDTO, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:31:0x00a7  */
    /* JADX WARN: Code duplicated, block: B:33:0x00be  */
    /* JADX WARN: Code duplicated, block: B:35:0x00c2  */
    /* JADX WARN: Code duplicated, block: B:37:0x00d2  */
    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    public final Object fetchFromCache(ItemId itemId, DomainError domainError, boolean z, Continuation<? super FileWithRepresentationsResult> continuation) {
        C15531 c15531;
        FileModel fileModel;
        DomainError domainError2;
        Result result;
        if (continuation instanceof C15531) {
            c15531 = (C15531) continuation;
            if ((c15531.label & Integer.MIN_VALUE) != 0) {
                c15531.label -= Integer.MIN_VALUE;
            } else {
                c15531 = new C15531(continuation);
            }
        } else {
            c15531 = new C15531(continuation);
        }
        Object cachedFileModel = c15531.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = c15531.label;
        if (i != 0) {
            if (i == 1) {
                z = c15531.Z$0;
                domainError = (DomainError) c15531.L$1;
                itemId = (ItemId) c15531.L$0;
                ResultKt.throwOnFailure(cachedFileModel);
            } else {
                if (i != 2) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                boolean z2 = c15531.Z$0;
                fileModel = (FileModel) c15531.L$2;
                domainError2 = (DomainError) c15531.L$1;
                ResultKt.throwOnFailure(cachedFileModel);
            }
            result = (Result) cachedFileModel;
            if (result instanceof Result.Error) {
                return new FileWithRepresentationsResult.Error(domainError2, DomainErrorMapper.toDomainError$default(DomainErrorMapper.INSTANCE, (IGenericError) ((Result.Error) result).getValue(), null, 2, null));
            }
            if (result instanceof Result.Success) {
                throw new NoWhenBranchMatchedException();
            }
            return new FileWithRepresentationsResult.Cached(fileModel, (List) ((Result.Success) result).getValue(), domainError2);
        }
        ResultKt.throwOnFailure(cachedFileModel);
        c15531.L$0 = SpillingKt.nullOutSpilledVariable(itemId);
        c15531.L$1 = domainError;
        c15531.Z$0 = z;
        c15531.label = 1;
        cachedFileModel = getCachedFileModel(itemId, c15531);
        if (cachedFileModel != coroutine_suspended) {
        }
        return coroutine_suspended;
        Result result2 = (Result) cachedFileModel;
        if (result2 instanceof Result.Error) {
            return new FileWithRepresentationsResult.Error(domainError, (DomainError) ((Result.Error) result2).getValue());
        }
        if (!(result2 instanceof Result.Success)) {
            throw new NoWhenBranchMatchedException();
        }
        FileModel fileModel2 = (FileModel) ((Result.Success) result2).getValue();
        c15531.L$0 = SpillingKt.nullOutSpilledVariable(itemId);
        c15531.L$1 = domainError;
        c15531.L$2 = fileModel2;
        c15531.Z$0 = z;
        c15531.label = 2;
        Object cachedRepresentations = getCachedRepresentations(fileModel2, z, c15531);
        if (cachedRepresentations != coroutine_suspended) {
            cachedFileModel = cachedRepresentations;
            fileModel = fileModel2;
            domainError2 = domainError;
            result = (Result) cachedFileModel;
            if (result instanceof Result.Error) {
                return new FileWithRepresentationsResult.Error(domainError2, DomainErrorMapper.toDomainError$default(DomainErrorMapper.INSTANCE, (IGenericError) ((Result.Error) result).getValue(), null, 2, null));
            }
            if (result instanceof Result.Success) {
                throw new NoWhenBranchMatchedException();
            }
            return new FileWithRepresentationsResult.Cached(fileModel, (List) ((Result.Success) result).getValue(), domainError2);
        }
        return coroutine_suspended;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    public final Object getCachedRepresentations(FileModel fileModel, boolean z, Continuation<? super Result<? extends List<RepresentationModel>, ? extends CacheError>> continuation) {
        C15551 c15551;
        String str;
        if (continuation instanceof C15551) {
            c15551 = (C15551) continuation;
            if ((c15551.label & Integer.MIN_VALUE) != 0) {
                c15551.label -= Integer.MIN_VALUE;
            } else {
                c15551 = new C15551(continuation);
            }
        } else {
            c15551 = new C15551(continuation);
        }
        Object obj = c15551.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = c15551.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            String representationHeader = getRepresentationHeader(z);
            RepresentationsCacheDataSource representationsCacheDataSource = this.representationsCacheDataSource;
            c15551.L$0 = SpillingKt.nullOutSpilledVariable(fileModel);
            c15551.L$1 = representationHeader;
            c15551.Z$0 = z;
            c15551.label = 1;
            Object representations = representationsCacheDataSource.getRepresentations(fileModel, c15551);
            if (representations == coroutine_suspended) {
                return coroutine_suspended;
            }
            obj = representations;
            str = representationHeader;
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            boolean z2 = c15551.Z$0;
            str = (String) c15551.L$1;
            ResultKt.throwOnFailure(obj);
        }
        Result result = (Result) obj;
        if (result instanceof Result.Success) {
            List<RepresentationDTO> entries = ((RepresentationsDTO) ((Result.Success) result).getValue()).getEntries();
            ArrayList arrayList = new ArrayList();
            for (Object obj2 : entries) {
                if (StringsKt.contains((CharSequence) str, (CharSequence) ((RepresentationDTO) obj2).getRepresentationType().getValue(), true)) {
                    arrayList.add(obj2);
                }
            }
            ArrayList arrayList2 = arrayList;
            ArrayList arrayList3 = new ArrayList(CollectionsKt.collectionSizeOrDefault(arrayList2, 10));
            Iterator it = arrayList2.iterator();
            while (it.hasNext()) {
                arrayList3.add(RepresentationDTODomainMapper.INSTANCE.toDomain((RepresentationDTO) it.next()));
            }
            return new Result.Success(arrayList3);
        }
        if (result instanceof Result.Error) {
            return result;
        }
        throw new NoWhenBranchMatchedException();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    public final Object getCachedFileModel(ItemId itemId, Continuation<? super Result<FileModel, ? extends DomainError>> continuation) {
        C15541 c15541;
        if (continuation instanceof C15541) {
            c15541 = (C15541) continuation;
            if ((c15541.label & Integer.MIN_VALUE) != 0) {
                c15541.label -= Integer.MIN_VALUE;
            } else {
                c15541 = new C15541(continuation);
            }
        } else {
            c15541 = new C15541(continuation);
        }
        Object objItem = c15541.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = c15541.label;
        if (i == 0) {
            ResultKt.throwOnFailure(objItem);
            ILocalItemService iLocalItemService = this.localItemService;
            DataPolicy dataPolicy = DataPolicy.CACHE;
            c15541.L$0 = itemId;
            c15541.label = 1;
            objItem = iLocalItemService.item(itemId, dataPolicy, c15541);
            if (objItem == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            itemId = (ItemId) c15541.L$0;
            ResultKt.throwOnFailure(objItem);
        }
        Result result = (Result) objItem;
        if (result instanceof Result.Success) {
            Result.Success success = (Result.Success) result;
            if (success.getValue() instanceof FileModel) {
                Object value = success.getValue();
                Intrinsics.checkNotNull(value, "null cannot be cast to non-null type com.box.android.domain.models.item.FileModel");
                return new Result.Success((FileModel) value);
            }
            return new Result.Error(new DomainError.NoResultFoundError("No file with id " + itemId + " found"));
        }
        if (result instanceof Result.Error) {
            return new Result.Error(((Result.Error) result).getValue());
        }
        throw new NoWhenBranchMatchedException();
    }

    private final String getRepresentationHeader(boolean forOffline) {
        if (forOffline) {
            return RepresentationsRemoteDataSource.OFFLINE_REPRESENTATION_HINT_HEADER;
        }
        return RepresentationsRemoteDataSource.REPRESENTATION_HINT_HEADER;
    }
}
