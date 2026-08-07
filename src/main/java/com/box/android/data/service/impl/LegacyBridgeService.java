package com.box.android.data.service.impl;

import com.box.android.data.datasource.CacheError;
import com.box.android.data.datasource.capture.CaptureHistoryCacheDataSource;
import com.box.android.data.utilities.GQLCacheHelper;
import com.box.android.domain.mappers.ItemModelMapper;
import com.box.android.domain.models.DomainError;
import com.box.android.domain.models.ItemId;
import com.box.android.domain.models.item.FolderModel;
import com.box.android.domain.models.item.ItemModel;
import com.box.android.domain.models.item.ItemModelKt;
import com.box.android.domain.services.ILegacyBridgeService;
import com.box.android.domain.utils.result.Result;
import com.box.androidsdk.content.models.BoxItem;
import com.box.androidsdk.content.utils.BoxLogUtils;
import external.sdk.pendo.io.mozilla.javascript.Token;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
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
import sdk.pendo.io.events.IdentificationData;

/* JADX INFO: compiled from: LegacyBridgeService.kt */
/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0019\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\"\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u000b0\t2\u0006\u0010\f\u001a\u00020\rH\u0096@¢\u0006\u0002\u0010\u000eJ\u001e\u0010\u000f\u001a\u00020\n2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0011H\u0096@¢\u0006\u0002\u0010\u0013J\u0016\u0010\u0014\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\rH\u0096@¢\u0006\u0002\u0010\u000eJ\"\u0010\u0015\u001a\u000e\u0012\u0004\u0012\u00020\u0016\u0012\u0004\u0012\u00020\u000b0\t2\u0006\u0010\u0017\u001a\u00020\u0016H\u0086@¢\u0006\u0002\u0010\u0018J \u0010\u0019\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\r2\b\u0010\u001a\u001a\u0004\u0018\u00010\u0011H\u0096@¢\u0006\u0002\u0010\u001bR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001c"}, d2 = {"Lcom/box/android/data/service/impl/LegacyBridgeService;", "Lcom/box/android/domain/services/ILegacyBridgeService;", "captureHistoryCacheDataSource", "Lcom/box/android/data/datasource/capture/CaptureHistoryCacheDataSource;", "gqlCacheHelper", "Lcom/box/android/data/utilities/GQLCacheHelper;", "<init>", "(Lcom/box/android/data/datasource/capture/CaptureHistoryCacheDataSource;Lcom/box/android/data/utilities/GQLCacheHelper;)V", "save", "Lcom/box/android/domain/utils/result/Result;", "", "Lcom/box/android/domain/models/DomainError;", "boxItem", "Lcom/box/androidsdk/content/models/BoxItem;", "(Lcom/box/androidsdk/content/models/BoxItem;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "delete", "itemId", "", "itemType", "(Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "saveUploadedItemToGQLCache", "insertItemIntoParent", "Lcom/box/android/domain/models/item/ItemModel;", "itemModel", "(Lcom/box/android/domain/models/item/ItemModel;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "deleteItemFromGQLCache", IdentificationData.FIELD_PARENT_ID, "(Lcom/box/androidsdk/content/models/BoxItem;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "data_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class LegacyBridgeService implements ILegacyBridgeService {
    private final CaptureHistoryCacheDataSource captureHistoryCacheDataSource;
    private final GQLCacheHelper gqlCacheHelper;

    /* JADX INFO: renamed from: com.box.android.data.service.impl.LegacyBridgeService$deleteItemFromGQLCache$1, reason: invalid class name */
    /* JADX INFO: compiled from: LegacyBridgeService.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.box.android.data.service.impl.LegacyBridgeService", f = "LegacyBridgeService.kt", i = {0, 0, 0, 0, 0}, l = {Token.DOTDOT}, m = "deleteItemFromGQLCache", n = {"boxItem", IdentificationData.FIELD_PARENT_ID, "itemModel", "actualParentId", "$i$a$-let-LegacyBridgeService$deleteItemFromGQLCache$2"}, s = {"L$0", "L$1", "L$2", "L$3", "I$0"}, v = 1)
    static final class AnonymousClass1 extends ContinuationImpl {
        int I$0;
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
            return LegacyBridgeService.this.deleteItemFromGQLCache(null, null, this);
        }
    }

    /* JADX INFO: renamed from: com.box.android.data.service.impl.LegacyBridgeService$insertItemIntoParent$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: LegacyBridgeService.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.box.android.data.service.impl.LegacyBridgeService", f = "LegacyBridgeService.kt", i = {0}, l = {135}, m = "insertItemIntoParent", n = {"itemModel"}, s = {"L$0"}, v = 1)
    static final class C14431 extends ContinuationImpl {
        Object L$0;
        int label;
        /* synthetic */ Object result;

        C14431(Continuation<? super C14431> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return LegacyBridgeService.this.insertItemIntoParent(null, this);
        }
    }

    /* JADX INFO: renamed from: com.box.android.data.service.impl.LegacyBridgeService$saveUploadedItemToGQLCache$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: LegacyBridgeService.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.box.android.data.service.impl.LegacyBridgeService", f = "LegacyBridgeService.kt", i = {0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 2, 2, 2, 2, 3, 3, 3, 3, 3, 3, 3, 3}, l = {111, 115, 120, 124}, m = "saveUploadedItemToGQLCache", n = {"boxItem", "store", "itemModel", "$i$a$-let-LegacyBridgeService$saveUploadedItemToGQLCache$2", "boxItem", "store", "itemModel", "$this$flatMap$iv", "it", "$i$a$-let-LegacyBridgeService$saveUploadedItemToGQLCache$2", "$i$f$flatMap", "$i$a$-flatMap-LegacyBridgeService$saveUploadedItemToGQLCache$2$2", "boxItem", "store", "itemModel", "$i$a$-let-LegacyBridgeService$saveUploadedItemToGQLCache$2", "boxItem", "store", "itemModel", "$this$flatMap$iv", "it", "$i$a$-let-LegacyBridgeService$saveUploadedItemToGQLCache$2", "$i$f$flatMap", "$i$a$-flatMap-LegacyBridgeService$saveUploadedItemToGQLCache$2$4"}, s = {"L$0", "L$1", "L$2", "I$0", "L$0", "L$1", "L$2", "L$3", "L$4", "I$0", "I$1", "I$2", "L$0", "L$1", "L$2", "I$0", "L$0", "L$1", "L$2", "L$3", "L$4", "I$0", "I$1", "I$2"}, v = 1)
    static final class C14451 extends ContinuationImpl {
        int I$0;
        int I$1;
        int I$2;
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        Object L$4;
        int label;
        /* synthetic */ Object result;

        C14451(Continuation<? super C14451> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return LegacyBridgeService.this.saveUploadedItemToGQLCache(null, this);
        }
    }

    @Inject
    public LegacyBridgeService(CaptureHistoryCacheDataSource captureHistoryCacheDataSource, GQLCacheHelper gqlCacheHelper) {
        Intrinsics.checkNotNullParameter(captureHistoryCacheDataSource, "captureHistoryCacheDataSource");
        Intrinsics.checkNotNullParameter(gqlCacheHelper, "gqlCacheHelper");
        this.captureHistoryCacheDataSource = captureHistoryCacheDataSource;
        this.gqlCacheHelper = gqlCacheHelper;
    }

    /* JADX INFO: renamed from: com.box.android.data.service.impl.LegacyBridgeService$save$2, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: LegacyBridgeService.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001*\u00020\u0004H\n"}, d2 = {"<anonymous>", "Lcom/box/android/domain/utils/result/Result;", "", "Lcom/box/android/domain/models/DomainError$CacheWriteError;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.box.android.data.service.impl.LegacyBridgeService$save$2", f = "LegacyBridgeService.kt", i = {0, 1, 1, 1, 2, 2, 2, 3, 3, 3}, l = {32, 37, 52, 68}, m = "invokeSuspend", n = {"$this$withContext", "$this$withContext", "it", "$i$a$-let-LegacyBridgeService$save$2$1", "$this$withContext", "it", "$i$a$-let-LegacyBridgeService$save$2$1", "$this$withContext", "it", "$i$a$-let-LegacyBridgeService$save$2$1"}, s = {"L$0", "L$0", "L$1", "I$0", "L$0", "L$1", "I$0", "L$0", "L$1", "I$0"}, v = 1)
    static final class C14442 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Result<? extends Unit, ? extends DomainError.CacheWriteError>>, Object> {
        final /* synthetic */ BoxItem $boxItem;
        int I$0;
        private /* synthetic */ Object L$0;
        Object L$1;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C14442(BoxItem boxItem, Continuation<? super C14442> continuation) {
            super(2, continuation);
            this.$boxItem = boxItem;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            C14442 c14442 = LegacyBridgeService.this.new C14442(this.$boxItem, continuation);
            c14442.L$0 = obj;
            return c14442;
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Object invoke(CoroutineScope coroutineScope, Continuation<? super Result<? extends Unit, ? extends DomainError.CacheWriteError>> continuation) {
            return invoke2(coroutineScope, (Continuation<? super Result<Unit, DomainError.CacheWriteError>>) continuation);
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(CoroutineScope coroutineScope, Continuation<? super Result<Unit, DomainError.CacheWriteError>> continuation) {
            return ((C14442) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Code duplicated, block: B:27:0x00d1  */
        /* JADX WARN: Code duplicated, block: B:47:0x018f  */
        /* JADX WARN: Code restructure failed: missing block: B:24:0x00c9, code lost:
        
            if (r0 == r10) goto L42;
         */
        /* JADX WARN: Code restructure failed: missing block: B:33:0x0127, code lost:
        
            if (r0 == r10) goto L42;
         */
        /* JADX WARN: Code restructure failed: missing block: B:41:0x0181, code lost:
        
            if (r0 == r10) goto L42;
         */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final java.lang.Object invokeSuspend(java.lang.Object r15) {
            /*
                Method dump skipped, instruction units count: 474
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: com.box.android.data.service.impl.LegacyBridgeService.C14442.invokeSuspend(java.lang.Object):java.lang.Object");
        }
    }

    @Override // com.box.android.domain.services.ILegacyBridgeService
    public Object save(BoxItem boxItem, Continuation<? super Result<Unit, ? extends DomainError>> continuation) {
        return BuildersKt.withContext(Dispatchers.getIO(), new C14442(boxItem, null), continuation);
    }

    /* JADX INFO: renamed from: com.box.android.data.service.impl.LegacyBridgeService$delete$2, reason: invalid class name */
    /* JADX INFO: compiled from: LegacyBridgeService.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.box.android.data.service.impl.LegacyBridgeService$delete$2", f = "LegacyBridgeService.kt", i = {}, l = {103}, m = "invokeSuspend", n = {}, s = {}, v = 1)
    static final class AnonymousClass2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ String $itemId;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass2(String str, Continuation<? super AnonymousClass2> continuation) {
            super(2, continuation);
            this.$itemId = str;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return LegacyBridgeService.this.new AnonymousClass2(this.$itemId, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                this.label = 1;
                if (LegacyBridgeService.this.captureHistoryCacheDataSource.deleteHistoricalCapture(this.$itemId, this) == coroutine_suspended) {
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

    @Override // com.box.android.domain.services.ILegacyBridgeService
    public Object delete(String str, String str2, Continuation<? super Unit> continuation) {
        Object objWithContext = BuildersKt.withContext(Dispatchers.getIO(), new AnonymousClass2(str, null), continuation);
        return objWithContext == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objWithContext : Unit.INSTANCE;
    }

    /* JADX WARN: Code duplicated, block: B:31:0x00e9  */
    /* JADX WARN: Code duplicated, block: B:33:0x00ed  */
    /* JADX WARN: Code duplicated, block: B:36:0x0118  */
    /* JADX WARN: Code duplicated, block: B:40:0x0153  */
    /* JADX WARN: Code duplicated, block: B:43:0x0159  */
    /* JADX WARN: Code duplicated, block: B:45:0x015f  */
    /* JADX WARN: Code duplicated, block: B:56:0x0190  */
    /* JADX WARN: Code duplicated, block: B:58:0x0194  */
    /* JADX WARN: Code duplicated, block: B:61:0x01bf  */
    /* JADX WARN: Code duplicated, block: B:65:0x01f8  */
    /* JADX WARN: Code duplicated, block: B:68:0x01fd  */
    /* JADX WARN: Code duplicated, block: B:70:0x0203  */
    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    /* JADX WARN: Code restructure failed: missing block: B:37:0x014b, code lost:
    
        if (r15 == r1) goto L63;
     */
    /* JADX WARN: Code restructure failed: missing block: B:62:0x01f2, code lost:
    
        if (r15 == r1) goto L63;
     */
    @Override // com.box.android.domain.services.ILegacyBridgeService
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.Object saveUploadedItemToGQLCache(com.box.androidsdk.content.models.BoxItem r14, kotlin.coroutines.Continuation<? super kotlin.Unit> r15) {
        /*
            Method dump skipped, instruction units count: 524
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.box.android.data.service.impl.LegacyBridgeService.saveUploadedItemToGQLCache(com.box.androidsdk.content.models.BoxItem, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    public final Object insertItemIntoParent(ItemModel itemModel, Continuation<? super Result<? extends ItemModel, ? extends DomainError>> continuation) {
        C14431 c14431;
        if (continuation instanceof C14431) {
            c14431 = (C14431) continuation;
            if ((c14431.label & Integer.MIN_VALUE) != 0) {
                c14431.label -= Integer.MIN_VALUE;
            } else {
                c14431 = new C14431(continuation);
            }
        } else {
            c14431 = new C14431(continuation);
        }
        Object objGqlInsertItemToParentInCache = c14431.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = c14431.label;
        if (i == 0) {
            ResultKt.throwOnFailure(objGqlInsertItemToParentInCache);
            GQLCacheHelper gQLCacheHelper = this.gqlCacheHelper;
            c14431.L$0 = itemModel;
            c14431.label = 1;
            objGqlInsertItemToParentInCache = gQLCacheHelper.gqlInsertItemToParentInCache(itemModel, c14431);
            if (objGqlInsertItemToParentInCache == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            itemModel = (ItemModel) c14431.L$0;
            ResultKt.throwOnFailure(objGqlInsertItemToParentInCache);
        }
        Result result = (Result) objGqlInsertItemToParentInCache;
        if (result instanceof Result.Success) {
            return result;
        }
        if (result instanceof Result.Error) {
            CacheError cacheError = (CacheError) ((Result.Error) result).getValue();
            BoxLogUtils.w("Failed to save to parent in GraphQL cache: " + itemModel);
            return new Result.Error(DomainErrorMapper.toDomainError$default(DomainErrorMapper.INSTANCE, cacheError, null, 2, null));
        }
        throw new NoWhenBranchMatchedException();
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    @Override // com.box.android.domain.services.ILegacyBridgeService
    public Object deleteItemFromGQLCache(BoxItem boxItem, String str, Continuation<? super Unit> continuation) throws Throwable {
        AnonymousClass1 anonymousClass1;
        ItemModel itemModel;
        ItemId.Remote itemIdRemoteId;
        String boxId;
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
        Object objGqlRemoveFromParentAndDeleteItem = anonymousClass2.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = anonymousClass2.label;
        if (i == 0) {
            ResultKt.throwOnFailure(objGqlRemoveFromParentAndDeleteItem);
            ItemModel itemModel2 = ItemModelMapper.INSTANCE.toItemModel(boxItem);
            if (itemModel2 != null) {
                FolderModel parentFolder = itemModel2.getParentFolder();
                String str2 = (parentFolder == null || (itemIdRemoteId = ItemModelKt.toItemIdRemoteId(parentFolder)) == null || (boxId = itemIdRemoteId.getBoxId()) == null) ? str : boxId;
                GQLCacheHelper gQLCacheHelper = this.gqlCacheHelper;
                String id = boxItem.getUserId();
                Intrinsics.checkNotNullExpressionValue(id, "getId(...)");
                String type = boxItem.getType();
                Intrinsics.checkNotNullExpressionValue(type, "getType(...)");
                anonymousClass2.L$0 = SpillingKt.nullOutSpilledVariable(boxItem);
                anonymousClass2.L$1 = SpillingKt.nullOutSpilledVariable(str);
                anonymousClass2.L$2 = itemModel2;
                anonymousClass2.L$3 = SpillingKt.nullOutSpilledVariable(str2);
                anonymousClass2.I$0 = 0;
                anonymousClass2.label = 1;
                objGqlRemoveFromParentAndDeleteItem = gQLCacheHelper.gqlRemoveFromParentAndDeleteItem(itemModel2, str2, id, type, anonymousClass2);
                if (objGqlRemoveFromParentAndDeleteItem == coroutine_suspended) {
                    return coroutine_suspended;
                }
                itemModel = itemModel2;
            }
            return Unit.INSTANCE;
        }
        if (i != 1) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        int i2 = anonymousClass2.I$0;
        itemModel = (ItemModel) anonymousClass2.L$2;
        ResultKt.throwOnFailure(objGqlRemoveFromParentAndDeleteItem);
        Pair pair = (Pair) objGqlRemoveFromParentAndDeleteItem;
        Result result = (Result) pair.component1();
        Result result2 = (Result) pair.component2();
        if (!(result instanceof Result.Success)) {
            if (result instanceof Result.Error) {
                CacheError cacheError = (CacheError) ((Result.Error) result).getValue();
                BoxLogUtils.w("Failed to remove item from GraphQL parent cache: " + itemModel);
                new Result.Error(DomainErrorMapper.toDomainError$default(DomainErrorMapper.INSTANCE, cacheError, null, 2, null));
            } else {
                throw new NoWhenBranchMatchedException();
            }
        }
        if (!(result2 instanceof Result.Success)) {
            if (result2 instanceof Result.Error) {
                CacheError cacheError2 = (CacheError) ((Result.Error) result2).getValue();
                BoxLogUtils.w("Failed to remove item from GraphQL cache: " + itemModel);
                new Result.Error(DomainErrorMapper.toDomainError$default(DomainErrorMapper.INSTANCE, cacheError2, null, 2, null));
            } else {
                throw new NoWhenBranchMatchedException();
            }
        }
        return Unit.INSTANCE;
    }
}
