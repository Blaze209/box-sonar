package com.box.android.data.datasource.representations;

import com.box.android.data.api.models.RepresentationDTO;
import com.box.android.data.api.models.RepresentationsDTO;
import com.box.android.data.datasource.CacheError;
import com.box.android.data.mappers.representations.RepresentationDTOEntityMapper;
import com.box.android.data.persistence.BoxDatabase;
import com.box.android.data.persistence.representations.FileRepresentationsDao;
import com.box.android.data.persistence.representations.RepresentationsItemEntity;
import com.box.android.data.user.UserData;
import com.box.android.domain.models.ItemId;
import com.box.android.domain.models.item.FileModel;
import com.box.android.domain.utils.result.Result;
import com.box.androidsdk.content.models.BoxFile;
import com.box.androidsdk.content.utils.BoxLogUtils;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
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
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: RepresentationsCacheDataSource.kt */
/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 \u001b2\u00020\u0001:\u0001\u001bB\u0019\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J*\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u000b0\t2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fH\u0086@¢\u0006\u0002\u0010\u0010J\"\u0010\u0011\u001a\u000e\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u000b0\t2\u0006\u0010\f\u001a\u00020\rH\u0086@¢\u0006\u0002\u0010\u0012J \u0010\u0013\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\f\u001a\u00020\rH\u0082@¢\u0006\u0002\u0010\u0016J&\u0010\u0017\u001a\u00020\u000f2\u0006\u0010\u0018\u001a\u00020\r2\u0006\u0010\u0019\u001a\u00020\u000f2\u0006\u0010\u0014\u001a\u00020\u0015H\u0082@¢\u0006\u0002\u0010\u001aR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001c"}, d2 = {"Lcom/box/android/data/datasource/representations/RepresentationsCacheDataSource;", "", "userData", "Lcom/box/android/data/user/UserData;", "mapper", "Lcom/box/android/data/mappers/representations/RepresentationDTOEntityMapper;", "<init>", "(Lcom/box/android/data/user/UserData;Lcom/box/android/data/mappers/representations/RepresentationDTOEntityMapper;)V", "updateFileRepresentations", "Lcom/box/android/domain/utils/result/Result;", "", "Lcom/box/android/data/datasource/CacheError;", "fileModel", "Lcom/box/android/domain/models/item/FileModel;", BoxFile.FIELD_REPRESENTATIONS, "Lcom/box/android/data/api/models/RepresentationsDTO;", "(Lcom/box/android/domain/models/item/FileModel;Lcom/box/android/data/api/models/RepresentationsDTO;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getRepresentations", "(Lcom/box/android/domain/models/item/FileModel;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getRepresentationsDTOFromDatabase", "boxDatabase", "Lcom/box/android/data/persistence/BoxDatabase;", "(Lcom/box/android/data/persistence/BoxDatabase;Lcom/box/android/domain/models/item/FileModel;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "mergedCachedRepresentations", "forFileModel", "withRepresentations", "(Lcom/box/android/domain/models/item/FileModel;Lcom/box/android/data/api/models/RepresentationsDTO;Lcom/box/android/data/persistence/BoxDatabase;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Companion", "data_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class RepresentationsCacheDataSource {
    public static final String LOGTAG = "RepresentationsCacheDataSource";
    private final RepresentationDTOEntityMapper mapper;
    private UserData userData;

    /* JADX INFO: renamed from: com.box.android.data.datasource.representations.RepresentationsCacheDataSource$getRepresentations$1, reason: invalid class name */
    /* JADX INFO: compiled from: RepresentationsCacheDataSource.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.box.android.data.datasource.representations.RepresentationsCacheDataSource", f = "RepresentationsCacheDataSource.kt", i = {0, 0}, l = {71}, m = "getRepresentations", n = {"fileModel", "databaseResult"}, s = {"L$0", "L$1"}, v = 1)
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
            return RepresentationsCacheDataSource.this.getRepresentations(null, this);
        }
    }

    /* JADX INFO: renamed from: com.box.android.data.datasource.representations.RepresentationsCacheDataSource$getRepresentationsDTOFromDatabase$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: RepresentationsCacheDataSource.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.box.android.data.datasource.representations.RepresentationsCacheDataSource", f = "RepresentationsCacheDataSource.kt", i = {0, 0, 0}, l = {94}, m = "getRepresentationsDTOFromDatabase", n = {"boxDatabase", "fileModel", "fileRemoteId"}, s = {"L$0", "L$1", "L$2"}, v = 1)
    static final class C12131 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        Object L$2;
        int label;
        /* synthetic */ Object result;

        C12131(Continuation<? super C12131> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return RepresentationsCacheDataSource.this.getRepresentationsDTOFromDatabase(null, null, this);
        }
    }

    /* JADX INFO: renamed from: com.box.android.data.datasource.representations.RepresentationsCacheDataSource$mergedCachedRepresentations$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: RepresentationsCacheDataSource.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.box.android.data.datasource.representations.RepresentationsCacheDataSource", f = "RepresentationsCacheDataSource.kt", i = {0, 0, 0}, l = {106}, m = "mergedCachedRepresentations", n = {"forFileModel", "withRepresentations", "boxDatabase"}, s = {"L$0", "L$1", "L$2"}, v = 1)
    static final class C12141 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        Object L$2;
        int label;
        /* synthetic */ Object result;

        C12141(Continuation<? super C12141> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return RepresentationsCacheDataSource.this.mergedCachedRepresentations(null, null, null, this);
        }
    }

    /* JADX INFO: renamed from: com.box.android.data.datasource.representations.RepresentationsCacheDataSource$updateFileRepresentations$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: RepresentationsCacheDataSource.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.box.android.data.datasource.representations.RepresentationsCacheDataSource", f = "RepresentationsCacheDataSource.kt", i = {0, 0, 0, 0, 0}, l = {39}, m = "updateFileRepresentations", n = {"fileModel", BoxFile.FIELD_REPRESENTATIONS, "fileRemoteId", "databaseResult", "database"}, s = {"L$0", "L$1", "L$2", "L$3", "L$4"}, v = 1)
    static final class C12151 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        Object L$4;
        int label;
        /* synthetic */ Object result;

        C12151(Continuation<? super C12151> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return RepresentationsCacheDataSource.this.updateFileRepresentations(null, null, this);
        }
    }

    @Inject
    public RepresentationsCacheDataSource(UserData userData, RepresentationDTOEntityMapper mapper) {
        Intrinsics.checkNotNullParameter(userData, "userData");
        Intrinsics.checkNotNullParameter(mapper, "mapper");
        this.userData = userData;
        this.mapper = mapper;
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    public final Object updateFileRepresentations(FileModel fileModel, RepresentationsDTO representationsDTO, Continuation<? super Result<Unit, ? extends CacheError>> continuation) {
        C12151 c12151;
        if (continuation instanceof C12151) {
            c12151 = (C12151) continuation;
            if ((c12151.label & Integer.MIN_VALUE) != 0) {
                c12151.label -= Integer.MIN_VALUE;
            } else {
                c12151 = new C12151(continuation);
            }
        } else {
            c12151 = new C12151(continuation);
        }
        Object obj = c12151.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = c12151.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            ItemId itemId = fileModel.getItemId();
            ItemId.Remote remote = itemId instanceof ItemId.Remote ? (ItemId.Remote) itemId : null;
            if (remote == null) {
                BoxLogUtils.e(LOGTAG, "Trying to save representation for file with local id " + fileModel.getItemId());
                return new Result.Error(CacheError.SaveError.INSTANCE);
            }
            Result<BoxDatabase, CacheError> boxDatabase = this.userData.getBoxDatabase();
            if (boxDatabase instanceof Result.Success) {
                BoxDatabase boxDatabase2 = (BoxDatabase) ((Result.Success) boxDatabase).getValue();
                AnonymousClass2 anonymousClass2 = new AnonymousClass2(fileModel, representationsDTO, boxDatabase2, remote, null);
                c12151.L$0 = SpillingKt.nullOutSpilledVariable(fileModel);
                c12151.L$1 = SpillingKt.nullOutSpilledVariable(representationsDTO);
                c12151.L$2 = SpillingKt.nullOutSpilledVariable(remote);
                c12151.L$3 = SpillingKt.nullOutSpilledVariable(boxDatabase);
                c12151.L$4 = SpillingKt.nullOutSpilledVariable(boxDatabase2);
                c12151.label = 1;
                if (boxDatabase2.withTransactionWrapper(anonymousClass2, c12151) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (!(boxDatabase instanceof Result.Error)) {
                    throw new NoWhenBranchMatchedException();
                }
                Result.Error error = (Result.Error) boxDatabase;
                BoxLogUtils.e(LOGTAG, "Error saving representations to cache " + error.getValue());
                return new Result.Error(error.getValue());
            }
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
        }
        return new Result.Success(Unit.INSTANCE);
    }

    /* JADX INFO: renamed from: com.box.android.data.datasource.representations.RepresentationsCacheDataSource$updateFileRepresentations$2, reason: invalid class name */
    /* JADX INFO: compiled from: RepresentationsCacheDataSource.kt */
    @Metadata(d1 = {"\u0000\u0006\n\u0000\n\u0002\u0010\u0002\u0010\u0000\u001a\u00020\u0001H\n"}, d2 = {"<anonymous>", ""}, k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.box.android.data.datasource.representations.RepresentationsCacheDataSource$updateFileRepresentations$2", f = "RepresentationsCacheDataSource.kt", i = {1}, l = {40, 41}, m = "invokeSuspend", n = {"mergedRepresentations"}, s = {"L$0"}, v = 1)
    static final class AnonymousClass2 extends SuspendLambda implements Function1<Continuation<? super Unit>, Object> {
        final /* synthetic */ BoxDatabase $database;
        final /* synthetic */ FileModel $fileModel;
        final /* synthetic */ ItemId.Remote $fileRemoteId;
        final /* synthetic */ RepresentationsDTO $representations;
        Object L$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass2(FileModel fileModel, RepresentationsDTO representationsDTO, BoxDatabase boxDatabase, ItemId.Remote remote, Continuation<? super AnonymousClass2> continuation) {
            super(1, continuation);
            this.$fileModel = fileModel;
            this.$representations = representationsDTO;
            this.$database = boxDatabase;
            this.$fileRemoteId = remote;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Continuation<?> continuation) {
            return RepresentationsCacheDataSource.this.new AnonymousClass2(this.$fileModel, this.$representations, this.$database, this.$fileRemoteId, continuation);
        }

        @Override // kotlin.jvm.functions.Function1
        public final Object invoke(Continuation<? super Unit> continuation) {
            return ((AnonymousClass2) create(continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Code restructure failed: missing block: B:14:0x0062, code lost:
        
            if (r7.$database.fileRepresentationsDao().insertRepresentation(r7.this$0.mapper.toEntity(r8, r7.$fileRemoteId, r7.$fileModel.getSha1()), r7) == r0) goto L15;
         */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final java.lang.Object invokeSuspend(java.lang.Object r8) {
            /*
                r7 = this;
                java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
                int r1 = r7.label
                r2 = 2
                r3 = 1
                if (r1 == 0) goto L22
                if (r1 == r3) goto L1e
                if (r1 != r2) goto L16
                java.lang.Object r7 = r7.L$0
                com.box.android.data.api.models.RepresentationsDTO r7 = (com.box.android.data.api.models.RepresentationsDTO) r7
                kotlin.ResultKt.throwOnFailure(r8)
                goto L65
            L16:
                java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
                java.lang.String r8 = "call to 'resume' before 'invoke' with coroutine"
                r7.<init>(r8)
                throw r7
            L1e:
                kotlin.ResultKt.throwOnFailure(r8)
                goto L39
            L22:
                kotlin.ResultKt.throwOnFailure(r8)
                com.box.android.data.datasource.representations.RepresentationsCacheDataSource r8 = com.box.android.data.datasource.representations.RepresentationsCacheDataSource.this
                com.box.android.domain.models.item.FileModel r1 = r7.$fileModel
                com.box.android.data.api.models.RepresentationsDTO r4 = r7.$representations
                com.box.android.data.persistence.BoxDatabase r5 = r7.$database
                r6 = r7
                kotlin.coroutines.Continuation r6 = (kotlin.coroutines.Continuation) r6
                r7.label = r3
                java.lang.Object r8 = com.box.android.data.datasource.representations.RepresentationsCacheDataSource.access$mergedCachedRepresentations(r8, r1, r4, r5, r6)
                if (r8 != r0) goto L39
                goto L64
            L39:
                com.box.android.data.api.models.RepresentationsDTO r8 = (com.box.android.data.api.models.RepresentationsDTO) r8
                com.box.android.data.persistence.BoxDatabase r1 = r7.$database
                com.box.android.data.persistence.representations.FileRepresentationsDao r1 = r1.fileRepresentationsDao()
                com.box.android.data.datasource.representations.RepresentationsCacheDataSource r3 = com.box.android.data.datasource.representations.RepresentationsCacheDataSource.this
                com.box.android.data.mappers.representations.RepresentationDTOEntityMapper r3 = com.box.android.data.datasource.representations.RepresentationsCacheDataSource.access$getMapper$p(r3)
                com.box.android.domain.models.ItemId$Remote r4 = r7.$fileRemoteId
                com.box.android.domain.models.item.FileModel r5 = r7.$fileModel
                java.lang.String r5 = r5.getSha1()
                com.box.android.data.persistence.representations.RepresentationsItemEntity r3 = r3.toEntity(r8, r4, r5)
                r4 = r7
                kotlin.coroutines.Continuation r4 = (kotlin.coroutines.Continuation) r4
                java.lang.Object r8 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r8)
                r7.L$0 = r8
                r7.label = r2
                java.lang.Object r7 = r1.insertRepresentation(r3, r4)
                if (r7 != r0) goto L65
            L64:
                return r0
            L65:
                kotlin.Unit r7 = kotlin.Unit.INSTANCE
                return r7
            */
            throw new UnsupportedOperationException("Method not decompiled: com.box.android.data.datasource.representations.RepresentationsCacheDataSource.AnonymousClass2.invokeSuspend(java.lang.Object):java.lang.Object");
        }
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    public final Object getRepresentations(FileModel fileModel, Continuation<? super Result<RepresentationsDTO, ? extends CacheError>> continuation) {
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
        Object representationsDTOFromDatabase = anonymousClass1.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = anonymousClass1.label;
        if (i == 0) {
            ResultKt.throwOnFailure(representationsDTOFromDatabase);
            Result<BoxDatabase, CacheError> boxDatabase = this.userData.getBoxDatabase();
            if (boxDatabase instanceof Result.Success) {
                BoxDatabase boxDatabase2 = (BoxDatabase) ((Result.Success) boxDatabase).getValue();
                anonymousClass1.L$0 = SpillingKt.nullOutSpilledVariable(fileModel);
                anonymousClass1.L$1 = SpillingKt.nullOutSpilledVariable(boxDatabase);
                anonymousClass1.label = 1;
                representationsDTOFromDatabase = getRepresentationsDTOFromDatabase(boxDatabase2, fileModel, anonymousClass1);
                if (representationsDTOFromDatabase == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (!(boxDatabase instanceof Result.Error)) {
                    throw new NoWhenBranchMatchedException();
                }
                BoxLogUtils.e(LOGTAG, "Error while fetching representations from cache " + ((Result.Error) boxDatabase).getValue());
                return boxDatabase;
            }
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(representationsDTOFromDatabase);
        }
        RepresentationsDTO representationsDTO = (RepresentationsDTO) representationsDTOFromDatabase;
        if (representationsDTO != null) {
            return new Result.Success(representationsDTO);
        }
        return new Result.Error(CacheError.NoResultFound.INSTANCE);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    public final Object getRepresentationsDTOFromDatabase(BoxDatabase boxDatabase, FileModel fileModel, Continuation<? super RepresentationsDTO> continuation) {
        C12131 c12131;
        if (continuation instanceof C12131) {
            c12131 = (C12131) continuation;
            if ((c12131.label & Integer.MIN_VALUE) != 0) {
                c12131.label -= Integer.MIN_VALUE;
            } else {
                c12131 = new C12131(continuation);
            }
        } else {
            c12131 = new C12131(continuation);
        }
        Object representationsForFile = c12131.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = c12131.label;
        if (i == 0) {
            ResultKt.throwOnFailure(representationsForFile);
            ItemId itemId = fileModel.getItemId();
            ItemId.Remote remote = itemId instanceof ItemId.Remote ? (ItemId.Remote) itemId : null;
            if (remote == null) {
                BoxLogUtils.e(LOGTAG, "Trying to get representation of file with local id " + fileModel.getItemId());
                return null;
            }
            FileRepresentationsDao fileRepresentationsDao = boxDatabase.fileRepresentationsDao();
            String sha1 = fileModel.getSha1();
            c12131.L$0 = SpillingKt.nullOutSpilledVariable(boxDatabase);
            c12131.L$1 = SpillingKt.nullOutSpilledVariable(fileModel);
            c12131.L$2 = SpillingKt.nullOutSpilledVariable(remote);
            c12131.label = 1;
            representationsForFile = fileRepresentationsDao.getRepresentationsForFile(remote, sha1, c12131);
            if (representationsForFile == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(representationsForFile);
        }
        RepresentationsItemEntity representationsItemEntity = (RepresentationsItemEntity) representationsForFile;
        if (representationsItemEntity != null) {
            return this.mapper.fromEntity(representationsItemEntity);
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    public final Object mergedCachedRepresentations(FileModel fileModel, RepresentationsDTO representationsDTO, BoxDatabase boxDatabase, Continuation<? super RepresentationsDTO> continuation) {
        C12141 c12141;
        if (continuation instanceof C12141) {
            c12141 = (C12141) continuation;
            if ((c12141.label & Integer.MIN_VALUE) != 0) {
                c12141.label -= Integer.MIN_VALUE;
            } else {
                c12141 = new C12141(continuation);
            }
        } else {
            c12141 = new C12141(continuation);
        }
        Object representationsDTOFromDatabase = c12141.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = c12141.label;
        if (i == 0) {
            ResultKt.throwOnFailure(representationsDTOFromDatabase);
            c12141.L$0 = SpillingKt.nullOutSpilledVariable(fileModel);
            c12141.L$1 = representationsDTO;
            c12141.L$2 = SpillingKt.nullOutSpilledVariable(boxDatabase);
            c12141.label = 1;
            representationsDTOFromDatabase = getRepresentationsDTOFromDatabase(boxDatabase, fileModel, c12141);
            if (representationsDTOFromDatabase == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            representationsDTO = (RepresentationsDTO) c12141.L$1;
            ResultKt.throwOnFailure(representationsDTOFromDatabase);
        }
        RepresentationsDTO representationsDTO2 = (RepresentationsDTO) representationsDTOFromDatabase;
        if (representationsDTO2 != null) {
            List<RepresentationDTO> mutableList = CollectionsKt.toMutableList((Collection) representationsDTO.getEntries());
            for (RepresentationDTO representationDTO : representationsDTO2.getEntries()) {
                List<RepresentationDTO> list = mutableList;
                if (!(list instanceof Collection) || !list.isEmpty()) {
                    Iterator<T> it = list.iterator();
                    while (true) {
                        if (it.hasNext()) {
                            RepresentationDTO representationDTO2 = (RepresentationDTO) it.next();
                            if (representationDTO2.getRepresentationType() == representationDTO.getRepresentationType() && Intrinsics.areEqual(representationDTO2.getProperties(), representationDTO.getProperties())) {
                                break;
                            }
                        }
                    }
                }
                mutableList.add(representationDTO);
            }
            RepresentationsDTO representationsDTOCopy = representationsDTO2.copy(mutableList);
            if (representationsDTOCopy != null) {
                return representationsDTOCopy;
            }
        }
        return representationsDTO;
    }
}
