package com.box.android.data.service.impl;

import com.box.android.domain.models.item.ItemModel;
import com.box.android.domain.utils.result.Result;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: compiled from: RemoteItemService.kt */
/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\u0003H\n"}, d2 = {"<anonymous>", "Lcom/box/android/domain/utils/result/Result;", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "com.box.android.data.service.impl.RemoteItemService$updateCopiedItemInCache$2$saveInLegacyCacheJob$1", f = "RemoteItemService.kt", i = {}, l = {948}, m = "invokeSuspend", n = {}, s = {}, v = 1)
final class RemoteItemService$updateCopiedItemInCache$2$saveInLegacyCacheJob$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Result<? extends Unit, ? extends Unit>>, Object> {
    final /* synthetic */ ItemModel $itemModel;
    int label;
    final /* synthetic */ RemoteItemService this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    RemoteItemService$updateCopiedItemInCache$2$saveInLegacyCacheJob$1(RemoteItemService remoteItemService, ItemModel itemModel, Continuation<? super RemoteItemService$updateCopiedItemInCache$2$saveInLegacyCacheJob$1> continuation) {
        super(2, continuation);
        this.this$0 = remoteItemService;
        this.$itemModel = itemModel;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new RemoteItemService$updateCopiedItemInCache$2$saveInLegacyCacheJob$1(this.this$0, this.$itemModel, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(CoroutineScope coroutineScope, Continuation<? super Result<? extends Unit, ? extends Unit>> continuation) {
        return invoke2(coroutineScope, (Continuation<? super Result<Unit, Unit>>) continuation);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(CoroutineScope coroutineScope, Continuation<? super Result<Unit, Unit>> continuation) {
        return ((RemoteItemService$updateCopiedItemInCache$2$saveInLegacyCacheJob$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            this.label = 1;
            obj = this.this$0.saveInLegacyCache(this.$itemModel, this);
            if (obj == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
        }
        Result result = (Result) obj;
        RemoteItemService remoteItemService = this.this$0;
        ItemModel itemModel = this.$itemModel;
        if (result instanceof Result.Success) {
            return result;
        }
        if (result instanceof Result.Error) {
            remoteItemService.gqlCacheHelper.logCacheError("Failed to save itemModel to legacy cache when copy item: " + itemModel);
            return new Result.Error(Unit.INSTANCE);
        }
        throw new NoWhenBranchMatchedException();
    }
}
