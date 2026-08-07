package com.box.android.data.service.impl;

import android.content.Context;
import com.box.android.common.utilities.BoxCommonConstants;
import com.box.android.data.api.models.MetadataTemplateDTO;
import com.box.android.data.datasource.errors.RemoteError;
import com.box.android.data.datasource.files.FileMetadataRemoteDataSource;
import com.box.android.data.datasource.files.MetadataTemplatesRemoteDataSource;
import com.box.android.domain.models.DomainError;
import com.box.android.domain.models.ItemId;
import com.box.android.domain.models.metadata.MetadataTemplateModel;
import com.box.android.domain.services.IFileMetadataService;
import com.box.android.domain.services.IdMappingService;
import com.box.android.domain.utils.ExtensionsKt;
import com.box.android.domain.utils.result.Result;
import com.box.androidsdk.content.utils.BoxLogUtils;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
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
import kotlinx.coroutines.Dispatchers;

/* JADX INFO: compiled from: FileMetadataService.kt */
/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000h\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\u0018\u00002\u00020\u0001B!\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ(\u0010\n\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\r0\f\u0012\u0004\u0012\u00020\u000e0\u000b2\u0006\u0010\u000f\u001a\u00020\u0010H\u0096@¢\u0006\u0002\u0010\u0011J\u0014\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00130\fH\u0096@¢\u0006\u0002\u0010\u0014J6\u0010\u0015\u001a\u000e\u0012\u0004\u0012\u00020\u0016\u0012\u0004\u0012\u00020\u000e0\u000b2\u0006\u0010\u0017\u001a\u00020\u00182\u0012\u0010\u0019\u001a\u000e\u0012\u0004\u0012\u00020\u001b\u0012\u0004\u0012\u00020\u001b0\u001aH\u0082@¢\u0006\u0002\u0010\u001cJ8\u0010\u001d\u001a\u00020\u00162\u0006\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020\u001b2\u0006\u0010!\u001a\u00020\u001b2\u0006\u0010\u0017\u001a\u00020\u00182\b\b\u0002\u0010\"\u001a\u00020#H\u0086@¢\u0006\u0002\u0010$R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006%"}, d2 = {"Lcom/box/android/data/service/impl/FileMetadataService;", "Lcom/box/android/domain/services/IFileMetadataService;", "fileMetadataRemoteDataSource", "Lcom/box/android/data/datasource/files/FileMetadataRemoteDataSource;", "metadataTemplatesRemoteDataSource", "Lcom/box/android/data/datasource/files/MetadataTemplatesRemoteDataSource;", "idMappingService", "Lcom/box/android/domain/services/IdMappingService;", "<init>", "(Lcom/box/android/data/datasource/files/FileMetadataRemoteDataSource;Lcom/box/android/data/datasource/files/MetadataTemplatesRemoteDataSource;Lcom/box/android/domain/services/IdMappingService;)V", "listFileMetadata", "Lcom/box/android/domain/utils/result/Result;", "", "Lcom/box/android/domain/models/metadata/FileMetadataInstanceModel;", "Lcom/box/android/domain/models/DomainError;", "itemId", "Lcom/box/android/domain/models/ItemId;", "(Lcom/box/android/domain/models/ItemId;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "listMetadataTemplates", "Lcom/box/android/domain/models/metadata/MetadataTemplateModel;", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "addFileProperties", "", "fileId", "Lcom/box/android/domain/models/ItemId$Remote;", "properties", "", "", "(Lcom/box/android/domain/models/ItemId$Remote;Ljava/util/Map;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "extractAndUploadFileProperties", "context", "Landroid/content/Context;", "contentUriOrPath", BoxCommonConstants.EXTRA_FILE_NAME, "replaceExistingCaptureMetadata", "", "(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;Lcom/box/android/domain/models/ItemId$Remote;ZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "data_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class FileMetadataService implements IFileMetadataService {
    private final FileMetadataRemoteDataSource fileMetadataRemoteDataSource;
    private final IdMappingService idMappingService;
    private final MetadataTemplatesRemoteDataSource metadataTemplatesRemoteDataSource;

    /* JADX INFO: renamed from: com.box.android.data.service.impl.FileMetadataService$addFileProperties$1, reason: invalid class name */
    /* JADX INFO: compiled from: FileMetadataService.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.box.android.data.service.impl.FileMetadataService", f = "FileMetadataService.kt", i = {0, 0}, l = {65}, m = "addFileProperties", n = {"fileId", "properties"}, s = {"L$0", "L$1"}, v = 1)
    static final class AnonymousClass1 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        int label;
        /* synthetic */ Object result;

        AnonymousClass1(Continuation<? super AnonymousClass1> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return FileMetadataService.this.addFileProperties(null, null, this);
        }
    }

    /* JADX INFO: renamed from: com.box.android.data.service.impl.FileMetadataService$extractAndUploadFileProperties$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: FileMetadataService.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.box.android.data.service.impl.FileMetadataService", f = "FileMetadataService.kt", i = {0, 0, 0, 0, 0, 0, 0}, l = {82}, m = "extractAndUploadFileProperties", n = {"context", "contentUriOrPath", BoxCommonConstants.EXTRA_FILE_NAME, "fileId", "$this$extractAndUploadFileProperties_u24lambda_u240", "replaceExistingCaptureMetadata", "$i$a$-runCatching-FileMetadataService$extractAndUploadFileProperties$2"}, s = {"L$0", "L$1", "L$2", "L$3", "L$4", "Z$0", "I$0"}, v = 1)
    static final class C14311 extends ContinuationImpl {
        int I$0;
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        Object L$4;
        boolean Z$0;
        int label;
        /* synthetic */ Object result;

        C14311(Continuation<? super C14311> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return FileMetadataService.this.extractAndUploadFileProperties(null, null, null, null, false, this);
        }
    }

    /* JADX INFO: renamed from: com.box.android.data.service.impl.FileMetadataService$listFileMetadata$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: FileMetadataService.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.box.android.data.service.impl.FileMetadataService", f = "FileMetadataService.kt", i = {0, 1, 1, 1, 1, 1}, l = {44, 45}, m = "listFileMetadata", n = {"itemId", "itemId", "$this$flatMap$iv", "remoteId", "$i$f$flatMap", "$i$a$-flatMap-FileMetadataService$listFileMetadata$2"}, s = {"L$0", "L$0", "L$1", "L$2", "I$0", "I$1"}, v = 1)
    static final class C14321 extends ContinuationImpl {
        int I$0;
        int I$1;
        Object L$0;
        Object L$1;
        Object L$2;
        int label;
        /* synthetic */ Object result;

        C14321(Continuation<? super C14321> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return FileMetadataService.this.listFileMetadata(null, this);
        }
    }

    @Inject
    public FileMetadataService(FileMetadataRemoteDataSource fileMetadataRemoteDataSource, MetadataTemplatesRemoteDataSource metadataTemplatesRemoteDataSource, IdMappingService idMappingService) {
        Intrinsics.checkNotNullParameter(fileMetadataRemoteDataSource, "fileMetadataRemoteDataSource");
        Intrinsics.checkNotNullParameter(metadataTemplatesRemoteDataSource, "metadataTemplatesRemoteDataSource");
        Intrinsics.checkNotNullParameter(idMappingService, "idMappingService");
        this.fileMetadataRemoteDataSource = fileMetadataRemoteDataSource;
        this.metadataTemplatesRemoteDataSource = metadataTemplatesRemoteDataSource;
        this.idMappingService = idMappingService;
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x0093, code lost:
    
        if (r7 == r1) goto L23;
     */
    @Override // com.box.android.domain.services.IFileMetadataService
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.Object listFileMetadata(com.box.android.domain.models.ItemId r6, kotlin.coroutines.Continuation<? super com.box.android.domain.utils.result.Result<? extends java.util.List<com.box.android.domain.models.metadata.FileMetadataInstanceModel>, ? extends com.box.android.domain.models.DomainError>> r7) {
        /*
            Method dump skipped, instruction units count: 277
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.box.android.data.service.impl.FileMetadataService.listFileMetadata(com.box.android.domain.models.ItemId, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX INFO: renamed from: com.box.android.data.service.impl.FileMetadataService$listMetadataTemplates$2, reason: invalid class name */
    /* JADX INFO: compiled from: FileMetadataService.kt */
    @Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\u0003H\n"}, d2 = {"<anonymous>", "", "Lcom/box/android/domain/models/metadata/MetadataTemplateModel;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.box.android.data.service.impl.FileMetadataService$listMetadataTemplates$2", f = "FileMetadataService.kt", i = {0, 0, 0, 1, 1, 1, 1}, l = {54, 55}, m = "invokeSuspend", n = {"$this$coroutineScope", "globalDeferred", "enterpriseDeferred", "$this$coroutineScope", "globalDeferred", "enterpriseDeferred", "globalDtos"}, s = {"L$0", "L$1", "L$2", "L$0", "L$1", "L$2", "L$3"}, v = 1)
    static final class AnonymousClass2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super List<? extends MetadataTemplateModel>>, Object> {
        private /* synthetic */ Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        int label;

        AnonymousClass2(Continuation<? super AnonymousClass2> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            AnonymousClass2 anonymousClass2 = FileMetadataService.this.new AnonymousClass2(continuation);
            anonymousClass2.L$0 = obj;
            return anonymousClass2;
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Object invoke(CoroutineScope coroutineScope, Continuation<? super List<? extends MetadataTemplateModel>> continuation) {
            return invoke2(coroutineScope, (Continuation<? super List<MetadataTemplateModel>>) continuation);
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(CoroutineScope coroutineScope, Continuation<? super List<MetadataTemplateModel>> continuation) {
            return ((AnonymousClass2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Code duplicated, block: B:23:0x00b5  */
        /* JADX WARN: Code duplicated, block: B:27:0x00da A[LOOP:0: B:25:0x00d4->B:27:0x00da, LOOP_END] */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Deferred deferredAsync$default;
            Deferred deferred;
            List list;
            List listEmptyList;
            ArrayList arrayList;
            Iterator it;
            CoroutineScope coroutineScope = (CoroutineScope) this.L$0;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                Deferred deferredAsync$default2 = BuildersKt__Builders_commonKt.async$default(coroutineScope, null, null, new FileMetadataService$listMetadataTemplates$2$globalDeferred$1(FileMetadataService.this, null), 3, null);
                deferredAsync$default = BuildersKt__Builders_commonKt.async$default(coroutineScope, null, null, new FileMetadataService$listMetadataTemplates$2$enterpriseDeferred$1(FileMetadataService.this, null), 3, null);
                this.L$0 = SpillingKt.nullOutSpilledVariable(coroutineScope);
                this.L$1 = SpillingKt.nullOutSpilledVariable(deferredAsync$default2);
                this.L$2 = deferredAsync$default;
                this.label = 1;
                Object objAwait = deferredAsync$default2.await(this);
                if (objAwait != coroutine_suspended) {
                    deferred = deferredAsync$default2;
                    obj = objAwait;
                }
                return coroutine_suspended;
            }
            if (i == 1) {
                deferredAsync$default = (Deferred) this.L$2;
                deferred = (Deferred) this.L$1;
                ResultKt.throwOnFailure(obj);
            } else {
                if (i != 2) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                list = (List) this.L$3;
                ResultKt.throwOnFailure(obj);
            }
            listEmptyList = (List) com.box.android.domain.utils.result.ResultKt.getOrNull((Result) obj);
            if (listEmptyList == null) {
                listEmptyList = CollectionsKt.emptyList();
            }
            List listPlus = CollectionsKt.plus((Collection) list, (Iterable) listEmptyList);
            arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(listPlus, 10));
            it = listPlus.iterator();
            while (it.hasNext()) {
                arrayList.add(FileMetadataServiceKt.toTemplateModel((MetadataTemplateDTO) it.next()));
            }
            return arrayList;
            List listEmptyList2 = (List) com.box.android.domain.utils.result.ResultKt.getOrNull((Result) obj);
            if (listEmptyList2 == null) {
                listEmptyList2 = CollectionsKt.emptyList();
            }
            this.L$0 = SpillingKt.nullOutSpilledVariable(coroutineScope);
            this.L$1 = SpillingKt.nullOutSpilledVariable(deferred);
            this.L$2 = SpillingKt.nullOutSpilledVariable(deferredAsync$default);
            this.L$3 = listEmptyList2;
            this.label = 2;
            Object objAwait2 = deferredAsync$default.await(this);
            if (objAwait2 != coroutine_suspended) {
                list = listEmptyList2;
                obj = objAwait2;
                listEmptyList = (List) com.box.android.domain.utils.result.ResultKt.getOrNull((Result) obj);
                if (listEmptyList == null) {
                    listEmptyList = CollectionsKt.emptyList();
                }
                List listPlus2 = CollectionsKt.plus((Collection) list, (Iterable) listEmptyList);
                arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(listPlus2, 10));
                it = listPlus2.iterator();
                while (it.hasNext()) {
                    arrayList.add(FileMetadataServiceKt.toTemplateModel((MetadataTemplateDTO) it.next()));
                }
                return arrayList;
            }
            return coroutine_suspended;
        }
    }

    @Override // com.box.android.domain.services.IFileMetadataService
    public Object listMetadataTemplates(Continuation<? super List<MetadataTemplateModel>> continuation) {
        return CoroutineScopeKt.coroutineScope(new AnonymousClass2(null), continuation);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    public final Object addFileProperties(ItemId.Remote remote, Map<String, String> map, Continuation<? super Result<Unit, ? extends DomainError>> continuation) {
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
        Object objAddFileProperties = anonymousClass1.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = anonymousClass1.label;
        if (i == 0) {
            ResultKt.throwOnFailure(objAddFileProperties);
            FileMetadataRemoteDataSource fileMetadataRemoteDataSource = this.fileMetadataRemoteDataSource;
            String boxId = remote.getBoxId();
            anonymousClass1.L$0 = SpillingKt.nullOutSpilledVariable(remote);
            anonymousClass1.L$1 = SpillingKt.nullOutSpilledVariable(map);
            anonymousClass1.label = 1;
            objAddFileProperties = fileMetadataRemoteDataSource.addFileProperties(boxId, map, anonymousClass1);
            if (objAddFileProperties == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(objAddFileProperties);
        }
        Result result = (Result) objAddFileProperties;
        if (result instanceof Result.Success) {
            return result;
        }
        if (!(result instanceof Result.Error)) {
            throw new NoWhenBranchMatchedException();
        }
        return new Result.Error(DomainErrorMapper.toDomainError$default(DomainErrorMapper.INSTANCE, (RemoteError) ((Result.Error) result).getValue(), null, 2, null));
    }

    public static /* synthetic */ Object extractAndUploadFileProperties$default(FileMetadataService fileMetadataService, Context context, String str, String str2, ItemId.Remote remote, boolean z, Continuation continuation, int i, Object obj) {
        if ((i & 16) != 0) {
            z = false;
        }
        return fileMetadataService.extractAndUploadFileProperties(context, str, str2, remote, z, continuation);
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0016  */
    public final Object extractAndUploadFileProperties(Context context, String str, String str2, ItemId.Remote remote, boolean z, Continuation<? super Unit> continuation) {
        C14311 c14311;
        Object objM14780constructorimpl;
        if (continuation instanceof C14311) {
            c14311 = (C14311) continuation;
            if ((c14311.label & Integer.MIN_VALUE) != 0) {
                c14311.label -= Integer.MIN_VALUE;
            } else {
                c14311 = new C14311(continuation);
            }
        } else {
            c14311 = new C14311(continuation);
        }
        C14311 c14312 = c14311;
        Object obj = c14312.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = c14312.label;
        try {
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                kotlin.Result.Companion companion = kotlin.Result.INSTANCE;
                FileMetadataService fileMetadataService = this;
                CoroutineDispatcher io2 = Dispatchers.getIO();
                FileMetadataService$extractAndUploadFileProperties$2$1 fileMetadataService$extractAndUploadFileProperties$2$1 = new FileMetadataService$extractAndUploadFileProperties$2$1(z, this, remote, context, str, str2, null);
                c14312.L$0 = SpillingKt.nullOutSpilledVariable(context);
                c14312.L$1 = SpillingKt.nullOutSpilledVariable(str);
                c14312.L$2 = SpillingKt.nullOutSpilledVariable(str2);
                c14312.L$3 = SpillingKt.nullOutSpilledVariable(remote);
                c14312.L$4 = SpillingKt.nullOutSpilledVariable(this);
                c14312.Z$0 = z;
                c14312.I$0 = 0;
                c14312.label = 1;
                if (BuildersKt.withContext(io2, fileMetadataService$extractAndUploadFileProperties$2$1, c14312) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                int i2 = c14312.I$0;
                boolean z2 = c14312.Z$0;
                ResultKt.throwOnFailure(obj);
            }
            objM14780constructorimpl = kotlin.Result.m14780constructorimpl(Unit.INSTANCE);
        } catch (Throwable th) {
            kotlin.Result.Companion companion2 = kotlin.Result.INSTANCE;
            objM14780constructorimpl = kotlin.Result.m14780constructorimpl(ResultKt.createFailure(th));
        }
        Throwable thM14783exceptionOrNullimpl = kotlin.Result.m14783exceptionOrNullimpl(objM14780constructorimpl);
        if (thM14783exceptionOrNullimpl != null) {
            BoxLogUtils.e(ExtensionsKt.getTAG(this), "Failed to extract/upload file metadata", thM14783exceptionOrNullimpl);
        }
        return Unit.INSTANCE;
    }
}
