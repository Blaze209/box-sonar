package com.box.android.data.service.impl;

import com.box.android.data.datasource.LegacyCacheDataSource;
import com.box.android.domain.configuration.DataPolicy;
import com.box.android.domain.mappers.FileModelMapper;
import com.box.android.domain.models.DomainError;
import com.box.android.domain.models.ItemId;
import com.box.android.domain.models.item.FileModel;
import com.box.android.domain.models.item.ItemModel;
import com.box.android.domain.utils.result.Result;
import com.box.androidsdk.content.BoxCache;
import com.box.brownfieldApi.featuresNavigator.activities.ReactNativeFeatureActivity;
import com.squareup.moshi.Moshi;
import java.sql.SQLException;
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

/* JADX INFO: compiled from: CommonServiceUtils.kt */
/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\u0018\u00002\u00020\u0001B1\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b¢\u0006\u0004\b\f\u0010\rJ(\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u00110\u000f2\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00140\u0013H\u0086@¢\u0006\u0002\u0010\u0015J*\u0010\u0016\u001a\u000e\u0012\u0004\u0012\u00020\u0017\u0012\u0004\u0012\u00020\u00180\u000f2\u0006\u0010\u0019\u001a\u00020\u00182\u0006\u0010\u001a\u001a\u00020\u001bH\u0086@¢\u0006\u0002\u0010\u001cJ\"\u0010\u001d\u001a\u000e\u0012\u0004\u0012\u00020\u0017\u0012\u0004\u0012\u00020\u00180\u000f2\u0006\u0010\u001e\u001a\u00020\u001fH\u0086@¢\u0006\u0002\u0010 J\u0018\u0010!\u001a\u00020\"2\u0006\u0010\u0019\u001a\u00020\u00182\u0006\u0010\u001a\u001a\u00020\u001bH\u0007R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006#"}, d2 = {"Lcom/box/android/data/service/impl/CommonServiceUtils;", "", "legacyCacheDataSource", "Lcom/box/android/data/datasource/LegacyCacheDataSource;", "moshi", "Lcom/squareup/moshi/Moshi;", "legacyBridgeService", "Lcom/box/android/data/service/impl/LegacyBridgeService;", "remoteItemService", "Lcom/box/android/data/service/impl/RemoteItemService;", "boxCache", "Lcom/box/androidsdk/content/BoxCache;", "<init>", "(Lcom/box/android/data/datasource/LegacyCacheDataSource;Lcom/squareup/moshi/Moshi;Lcom/box/android/data/service/impl/LegacyBridgeService;Lcom/box/android/data/service/impl/RemoteItemService;Lcom/box/androidsdk/content/BoxCache;)V", "saveInLegacyCache", "Lcom/box/android/domain/utils/result/Result;", "", "Lcom/box/android/data/datasource/CacheError$SaveError;", "itemDTOs", "", "Lcom/box/android/data/api/models/items/IItemDTO;", "(Ljava/util/List;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "handleConflictError", "Lcom/box/android/domain/models/item/FileModel;", "Lcom/box/android/domain/models/DomainError;", "error", "fileSha1", "", "(Lcom/box/android/domain/models/DomainError;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getFileInfoAndSaveInBoxCache", "itemId", "Lcom/box/android/domain/models/ItemId;", "(Lcom/box/android/domain/models/ItemId;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "isSameFileUploaded", "", "data_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class CommonServiceUtils {
    private final BoxCache boxCache;
    private final LegacyBridgeService legacyBridgeService;
    private final LegacyCacheDataSource legacyCacheDataSource;
    private final Moshi moshi;
    private final RemoteItemService remoteItemService;

    /* JADX INFO: renamed from: com.box.android.data.service.impl.CommonServiceUtils$getFileInfoAndSaveInBoxCache$1, reason: invalid class name */
    /* JADX INFO: compiled from: CommonServiceUtils.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.box.android.data.service.impl.CommonServiceUtils", f = "CommonServiceUtils.kt", i = {0, 1, 1, 1, 1, 1}, l = {58, 60}, m = "getFileInfoAndSaveInBoxCache", n = {"itemId", "itemId", "$this$map$iv", "itemModel", "$i$f$map", "$i$a$-map-CommonServiceUtils$getFileInfoAndSaveInBoxCache$2"}, s = {"L$0", "L$0", "L$1", "L$2", "I$0", "I$1"}, v = 1)
    static final class AnonymousClass1 extends ContinuationImpl {
        int I$0;
        int I$1;
        Object L$0;
        Object L$1;
        Object L$2;
        int label;
        /* synthetic */ Object result;

        AnonymousClass1(Continuation<? super AnonymousClass1> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return CommonServiceUtils.this.getFileInfoAndSaveInBoxCache(null, this);
        }
    }

    /* JADX INFO: renamed from: com.box.android.data.service.impl.CommonServiceUtils$saveInLegacyCache$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: CommonServiceUtils.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.box.android.data.service.impl.CommonServiceUtils", f = "CommonServiceUtils.kt", i = {0, 0, 0, 0, 0, 0, 0, 0, 0}, l = {37}, m = "saveInLegacyCache", n = {"itemDTOs", ReactNativeFeatureActivity.RESULT_EXTRA_KEY, "adapter", "$this$forEach$iv", "element$iv", "it", "jsonItem", "$i$f$forEach", "$i$a$-forEach-CommonServiceUtils$saveInLegacyCache$2"}, s = {"L$0", "L$1", "L$2", "L$3", "L$5", "L$6", "L$7", "I$0", "I$1"}, v = 1)
    static final class C14171 extends ContinuationImpl {
        int I$0;
        int I$1;
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

        C14171(Continuation<? super C14171> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return CommonServiceUtils.this.saveInLegacyCache(null, this);
        }
    }

    @Inject
    public CommonServiceUtils(LegacyCacheDataSource legacyCacheDataSource, Moshi moshi, LegacyBridgeService legacyBridgeService, RemoteItemService remoteItemService, BoxCache boxCache) {
        Intrinsics.checkNotNullParameter(legacyCacheDataSource, "legacyCacheDataSource");
        Intrinsics.checkNotNullParameter(moshi, "moshi");
        Intrinsics.checkNotNullParameter(legacyBridgeService, "legacyBridgeService");
        Intrinsics.checkNotNullParameter(remoteItemService, "remoteItemService");
        Intrinsics.checkNotNullParameter(boxCache, "boxCache");
        this.legacyCacheDataSource = legacyCacheDataSource;
        this.moshi = moshi;
        this.legacyBridgeService = legacyBridgeService;
        this.remoteItemService = remoteItemService;
        this.boxCache = boxCache;
    }

    /* JADX WARN: Code duplicated, block: B:17:0x008b  */
    /* JADX WARN: Code duplicated, block: B:19:0x00d2 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:20:0x00d3  */
    /* JADX WARN: Code duplicated, block: B:23:0x00e1  */
    /* JADX WARN: Code duplicated, block: B:25:0x00e4  */
    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v1, types: [T, com.box.android.domain.utils.result.Result$Success] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:20:0x00d3 -> B:21:0x00d9). Please report as a decompilation issue!!! */
    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions stack size limit reached
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        */
    public final java.lang.Object saveInLegacyCache(java.util.List<? extends com.box.android.data.api.models.items.IItemDTO> r14, kotlin.coroutines.Continuation<? super com.box.android.domain.utils.result.Result<kotlin.Unit, com.box.android.data.datasource.CacheError.SaveError>> r15) {
        /*
            Method dump skipped, instruction units count: 236
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.box.android.data.service.impl.CommonServiceUtils.saveInLegacyCache(java.util.List, kotlin.coroutines.Continuation):java.lang.Object");
    }

    public final Object handleConflictError(DomainError domainError, String str, Continuation<? super Result<FileModel, ? extends DomainError>> continuation) {
        if (isSameFileUploaded(domainError, str)) {
            Intrinsics.checkNotNull(domainError, "null cannot be cast to non-null type com.box.android.domain.models.DomainError.NameConflict");
            return getFileInfoAndSaveInBoxCache(((ItemModel) CollectionsKt.first((List) ((DomainError.NameConflict) domainError).getItemModels())).getItemId(), continuation);
        }
        return new Result.Error(domainError);
    }

    /* JADX WARN: Code duplicated, block: B:30:0x00b8 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:31:0x00b9  */
    /* JADX WARN: Code duplicated, block: B:33:0x00bd  */
    /* JADX WARN: Code duplicated, block: B:35:0x00d5  */
    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    public final Object getFileInfoAndSaveInBoxCache(ItemId itemId, Continuation<? super Result<FileModel, ? extends DomainError>> continuation) throws SQLException {
        AnonymousClass1 anonymousClass1;
        Result.Success success;
        ItemModel itemModel;
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
        Object objItem = anonymousClass1.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = anonymousClass1.label;
        if (i == 0) {
            ResultKt.throwOnFailure(objItem);
            RemoteItemService remoteItemService = this.remoteItemService;
            DataPolicy dataPolicy = DataPolicy.REMOTE;
            anonymousClass1.L$0 = SpillingKt.nullOutSpilledVariable(itemId);
            anonymousClass1.label = 1;
            objItem = remoteItemService.item(itemId, dataPolicy, anonymousClass1);
            if (objItem != coroutine_suspended) {
            }
            return coroutine_suspended;
        }
        if (i == 1) {
            itemId = (ItemId) anonymousClass1.L$0;
            ResultKt.throwOnFailure(objItem);
        } else {
            if (i != 2) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            int i2 = anonymousClass1.I$1;
            int i3 = anonymousClass1.I$0;
            itemModel = (ItemModel) anonymousClass1.L$2;
            ResultKt.throwOnFailure(objItem);
        }
        BoxCache boxCache = this.boxCache;
        FileModelMapper fileModelMapper = FileModelMapper.INSTANCE;
        Intrinsics.checkNotNull(itemModel, "null cannot be cast to non-null type com.box.android.domain.models.item.FileModel");
        FileModel fileModel = (FileModel) itemModel;
        boxCache.saveItem(FileModelMapper.toBoxFile$default(fileModelMapper, fileModel, false, 1, null), true);
        success = new Result.Success(fileModel);
        if (success instanceof Result.Success) {
            return success;
        }
        if (success instanceof Result.Error) {
            throw new NoWhenBranchMatchedException();
        }
        return new Result.Error(DomainErrorMapper.toDomainError$default(DomainErrorMapper.INSTANCE, (DomainError) ((Result.Error) success).getValue(), null, 2, null));
        success = (Result) objItem;
        if (success instanceof Result.Success) {
            ItemModel itemModel2 = (ItemModel) ((Result.Success) success).getValue();
            LegacyBridgeService legacyBridgeService = this.legacyBridgeService;
            anonymousClass1.L$0 = SpillingKt.nullOutSpilledVariable(itemId);
            anonymousClass1.L$1 = SpillingKt.nullOutSpilledVariable(success);
            anonymousClass1.L$2 = itemModel2;
            anonymousClass1.I$0 = 0;
            anonymousClass1.I$1 = 0;
            anonymousClass1.label = 2;
            if (legacyBridgeService.insertItemIntoParent(itemModel2, anonymousClass1) != coroutine_suspended) {
                itemModel = itemModel2;
                BoxCache boxCache2 = this.boxCache;
                FileModelMapper fileModelMapper2 = FileModelMapper.INSTANCE;
                Intrinsics.checkNotNull(itemModel, "null cannot be cast to non-null type com.box.android.domain.models.item.FileModel");
                FileModel fileModel2 = (FileModel) itemModel;
                boxCache2.saveItem(FileModelMapper.toBoxFile$default(fileModelMapper2, fileModel2, false, 1, null), true);
                success = new Result.Success(fileModel2);
            }
            return coroutine_suspended;
        }
        if (!(success instanceof Result.Error)) {
            throw new NoWhenBranchMatchedException();
        }
        if (success instanceof Result.Success) {
            return success;
        }
        if (success instanceof Result.Error) {
            throw new NoWhenBranchMatchedException();
        }
        return new Result.Error(DomainErrorMapper.toDomainError$default(DomainErrorMapper.INSTANCE, (DomainError) ((Result.Error) success).getValue(), null, 2, null));
    }

    public final boolean isSameFileUploaded(DomainError error, String fileSha1) {
        List<ItemModel> itemModels;
        Intrinsics.checkNotNullParameter(error, "error");
        Intrinsics.checkNotNullParameter(fileSha1, "fileSha1");
        DomainError.NameConflict nameConflict = error instanceof DomainError.NameConflict ? (DomainError.NameConflict) error : null;
        ItemModel itemModel = (nameConflict == null || (itemModels = nameConflict.getItemModels()) == null) ? null : (ItemModel) CollectionsKt.first((List) itemModels);
        FileModel fileModel = itemModel instanceof FileModel ? (FileModel) itemModel : null;
        return Intrinsics.areEqual(fileSha1, fileModel != null ? fileModel.getSha1() : null);
    }
}
