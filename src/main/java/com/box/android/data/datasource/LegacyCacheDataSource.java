package com.box.android.data.datasource;

import com.box.android.domain.mappers.ItemModelMapper;
import com.box.android.domain.models.item.ItemModel;
import com.box.android.domain.models.item.ItemType;
import com.box.android.domain.utils.result.Result;
import com.box.androidsdk.content.BoxCache;
import com.box.androidsdk.content.models.BoxEntity;
import com.box.androidsdk.content.models.BoxItem;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;

/* JADX INFO: compiled from: LegacyCacheDataSource.kt */
/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0016\u0018\u00002\u00020\u0001B\u0011\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J,\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t0\u00072\u0006\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\f\u001a\u00020\rH\u0096@¢\u0006\u0002\u0010\u000eJ,\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t0\u00072\u0006\u0010\u000f\u001a\u00020\u00102\b\b\u0002\u0010\f\u001a\u00020\rH\u0096@¢\u0006\u0002\u0010\u0011J,\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t0\u00072\u0006\u0010\u0012\u001a\u00020\u00132\b\b\u0002\u0010\f\u001a\u00020\rH\u0096@¢\u0006\u0002\u0010\u0014J*\u0010\u0015\u001a\u000e\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u00160\u00072\u0006\u0010\u0017\u001a\u00020\u000b2\u0006\u0010\u0018\u001a\u00020\u0019H\u0086@¢\u0006\u0002\u0010\u001aR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001b"}, d2 = {"Lcom/box/android/data/datasource/LegacyCacheDataSource;", "", "boxCache", "Lcom/box/androidsdk/content/BoxCache;", "<init>", "(Lcom/box/androidsdk/content/BoxCache;)V", "saveItem", "Lcom/box/android/domain/utils/result/Result;", "", "Lcom/box/android/data/datasource/CacheError$SaveError;", "itemJson", "", "updateGQLCache", "", "(Ljava/lang/String;ZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "boxItem", "Lcom/box/androidsdk/content/models/BoxItem;", "(Lcom/box/androidsdk/content/models/BoxItem;ZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "itemModel", "Lcom/box/android/domain/models/item/ItemModel;", "(Lcom/box/android/domain/models/item/ItemModel;ZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getItem", "Lcom/box/android/data/datasource/CacheError$ReadError;", "itemId", "itemType", "Lcom/box/android/domain/models/item/ItemType;", "(Ljava/lang/String;Lcom/box/android/domain/models/item/ItemType;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "data_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public class LegacyCacheDataSource {
    private final BoxCache boxCache;

    public Object saveItem(ItemModel itemModel, boolean z, Continuation<? super Result<Unit, CacheError.SaveError>> continuation) {
        return saveItem$suspendImpl(this, itemModel, z, continuation);
    }

    public Object saveItem(BoxItem boxItem, boolean z, Continuation<? super Result<Unit, CacheError.SaveError>> continuation) {
        return saveItem$suspendImpl(this, boxItem, z, continuation);
    }

    public Object saveItem(String str, boolean z, Continuation<? super Result<Unit, CacheError.SaveError>> continuation) {
        return saveItem$suspendImpl(this, str, z, continuation);
    }

    @Inject
    public LegacyCacheDataSource(BoxCache boxCache) {
        Intrinsics.checkNotNullParameter(boxCache, "boxCache");
        this.boxCache = boxCache;
    }

    /* JADX INFO: renamed from: com.box.android.data.datasource.LegacyCacheDataSource$saveItem$2, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: LegacyCacheDataSource.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001*\u00020\u0004H\n"}, d2 = {"<anonymous>", "Lcom/box/android/domain/utils/result/Result;", "", "Lcom/box/android/data/datasource/CacheError$SaveError;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.box.android.data.datasource.LegacyCacheDataSource$saveItem$2", f = "LegacyCacheDataSource.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {}, v = 1)
    static final class C10952 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Result<? extends Unit, ? extends CacheError.SaveError>>, Object> {
        final /* synthetic */ String $itemJson;
        final /* synthetic */ boolean $updateGQLCache;
        int label;
        final /* synthetic */ LegacyCacheDataSource this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C10952(String str, LegacyCacheDataSource legacyCacheDataSource, boolean z, Continuation<? super C10952> continuation) {
            super(2, continuation);
            this.$itemJson = str;
            this.this$0 = legacyCacheDataSource;
            this.$updateGQLCache = z;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new C10952(this.$itemJson, this.this$0, this.$updateGQLCache, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Object invoke(CoroutineScope coroutineScope, Continuation<? super Result<? extends Unit, ? extends CacheError.SaveError>> continuation) {
            return invoke2(coroutineScope, (Continuation<? super Result<Unit, CacheError.SaveError>>) continuation);
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(CoroutineScope coroutineScope, Continuation<? super Result<Unit, CacheError.SaveError>> continuation) {
            return ((C10952) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            BoxEntity boxEntityCreateEntityFromJson = BoxEntity.createEntityFromJson(this.$itemJson);
            Intrinsics.checkNotNull(boxEntityCreateEntityFromJson, "null cannot be cast to non-null type com.box.androidsdk.content.models.BoxItem");
            try {
                this.this$0.boxCache.saveItem((BoxItem) boxEntityCreateEntityFromJson, this.$updateGQLCache);
                return new Result.Success(Unit.INSTANCE);
            } catch (Exception unused) {
                return new Result.Error(CacheError.SaveError.INSTANCE);
            }
        }
    }

    public static /* synthetic */ Object saveItem$default(LegacyCacheDataSource legacyCacheDataSource, String str, boolean z, Continuation continuation, int i, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: saveItem");
        }
        if ((i & 2) != 0) {
            z = true;
        }
        return legacyCacheDataSource.saveItem(str, z, (Continuation<? super Result<Unit, CacheError.SaveError>>) continuation);
    }

    static /* synthetic */ Object saveItem$suspendImpl(LegacyCacheDataSource legacyCacheDataSource, String str, boolean z, Continuation<? super Result<Unit, CacheError.SaveError>> continuation) {
        return BuildersKt.withContext(Dispatchers.getIO(), new C10952(str, legacyCacheDataSource, z, null), continuation);
    }

    public static /* synthetic */ Object saveItem$default(LegacyCacheDataSource legacyCacheDataSource, BoxItem boxItem, boolean z, Continuation continuation, int i, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: saveItem");
        }
        if ((i & 2) != 0) {
            z = true;
        }
        return legacyCacheDataSource.saveItem(boxItem, z, (Continuation<? super Result<Unit, CacheError.SaveError>>) continuation);
    }

    static /* synthetic */ Object saveItem$suspendImpl(LegacyCacheDataSource legacyCacheDataSource, BoxItem boxItem, boolean z, Continuation<? super Result<Unit, CacheError.SaveError>> continuation) {
        String json = boxItem.toJson();
        Intrinsics.checkNotNullExpressionValue(json, "toJson(...)");
        return legacyCacheDataSource.saveItem(json, z, continuation);
    }

    public static /* synthetic */ Object saveItem$default(LegacyCacheDataSource legacyCacheDataSource, ItemModel itemModel, boolean z, Continuation continuation, int i, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: saveItem");
        }
        if ((i & 2) != 0) {
            z = true;
        }
        return legacyCacheDataSource.saveItem(itemModel, z, (Continuation<? super Result<Unit, CacheError.SaveError>>) continuation);
    }

    static /* synthetic */ Object saveItem$suspendImpl(LegacyCacheDataSource legacyCacheDataSource, ItemModel itemModel, boolean z, Continuation<? super Result<Unit, CacheError.SaveError>> continuation) {
        return legacyCacheDataSource.saveItem(ItemModelMapper.INSTANCE.toBoxItem(itemModel, true), z, continuation);
    }

    /* JADX INFO: renamed from: com.box.android.data.datasource.LegacyCacheDataSource$getItem$2, reason: invalid class name */
    /* JADX INFO: compiled from: LegacyCacheDataSource.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001*\u00020\u0004H\n"}, d2 = {"<anonymous>", "Lcom/box/android/domain/utils/result/Result;", "Lcom/box/androidsdk/content/models/BoxItem;", "Lcom/box/android/data/datasource/CacheError$ReadError;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.box.android.data.datasource.LegacyCacheDataSource$getItem$2", f = "LegacyCacheDataSource.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {}, v = 1)
    static final class AnonymousClass2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Result<? extends BoxItem, ? extends CacheError.ReadError>>, Object> {
        final /* synthetic */ String $itemId;
        final /* synthetic */ ItemType $itemType;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass2(String str, ItemType itemType, Continuation<? super AnonymousClass2> continuation) {
            super(2, continuation);
            this.$itemId = str;
            this.$itemType = itemType;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return LegacyCacheDataSource.this.new AnonymousClass2(this.$itemId, this.$itemType, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Object invoke(CoroutineScope coroutineScope, Continuation<? super Result<? extends BoxItem, ? extends CacheError.ReadError>> continuation) {
            return invoke2(coroutineScope, (Continuation<? super Result<? extends BoxItem, CacheError.ReadError>>) continuation);
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(CoroutineScope coroutineScope, Continuation<? super Result<? extends BoxItem, CacheError.ReadError>> continuation) {
            return ((AnonymousClass2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            try {
                BoxItem item = LegacyCacheDataSource.this.boxCache.getItem(this.$itemId, this.$itemType.name());
                if (item == null) {
                    throw new Exception("BoxItem not found");
                }
                return new Result.Success(item);
            } catch (Exception unused) {
                return new Result.Error(CacheError.ReadError.INSTANCE);
            }
        }
    }

    public final Object getItem(String str, ItemType itemType, Continuation<? super Result<? extends BoxItem, CacheError.ReadError>> continuation) {
        return BuildersKt.withContext(Dispatchers.getIO(), new AnonymousClass2(str, itemType, null), continuation);
    }
}
