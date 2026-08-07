package com.box.android.data.service.impl.preview;

import com.box.android.domain.models.DomainError;
import com.box.android.domain.models.ItemId;
import com.box.android.domain.models.item.ItemModel;
import com.box.android.domain.services.IRemoteItemService;
import com.box.android.domain.utils.result.Result;
import com.box.brownfieldApi.featuresNavigator.activities.ReactNativeFeatureActivity;
import java.util.List;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Ref;

/* JADX INFO: compiled from: GalleryItemsService.kt */
/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\u0018\u0010\u0002\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u0004\u0012\u0004\u0012\u00020\u00060\u0003H\n"}, d2 = {"<anonymous>", "", ReactNativeFeatureActivity.RESULT_EXTRA_KEY, "Lcom/box/android/domain/utils/result/Result;", "", "Lcom/box/android/domain/models/item/ItemModel;", "Lcom/box/android/domain/models/DomainError;"}, k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "com.box.android.data.service.impl.preview.GalleryItemsService$fetchPreviewItems$2$1", f = "GalleryItemsService.kt", i = {0, 0, 0, 0, 0}, l = {57}, m = "invokeSuspend", n = {ReactNativeFeatureActivity.RESULT_EXTRA_KEY, "$this$onError$iv", "error", "$i$f$onError", "$i$a$-onError-GalleryItemsService$fetchPreviewItems$2$1$1"}, s = {"L$0", "L$1", "L$2", "I$0", "I$1"}, v = 1)
final class GalleryItemsService$fetchPreviewItems$2$1 extends SuspendLambda implements Function2<Result<? extends List<? extends ItemModel>, ? extends DomainError>, Continuation<? super Unit>, Object> {
    final /* synthetic */ ItemId $folderId;
    final /* synthetic */ Ref.BooleanRef $hasFetchedFromRemote;
    int I$0;
    int I$1;
    /* synthetic */ Object L$0;
    Object L$1;
    Object L$2;
    int label;
    final /* synthetic */ GalleryItemsService this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    GalleryItemsService$fetchPreviewItems$2$1(Ref.BooleanRef booleanRef, GalleryItemsService galleryItemsService, ItemId itemId, Continuation<? super GalleryItemsService$fetchPreviewItems$2$1> continuation) {
        super(2, continuation);
        this.$hasFetchedFromRemote = booleanRef;
        this.this$0 = galleryItemsService;
        this.$folderId = itemId;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        GalleryItemsService$fetchPreviewItems$2$1 galleryItemsService$fetchPreviewItems$2$1 = new GalleryItemsService$fetchPreviewItems$2$1(this.$hasFetchedFromRemote, this.this$0, this.$folderId, continuation);
        galleryItemsService$fetchPreviewItems$2$1.L$0 = obj;
        return galleryItemsService$fetchPreviewItems$2$1;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(Result<? extends List<? extends ItemModel>, ? extends DomainError> result, Continuation<? super Unit> continuation) {
        return ((GalleryItemsService$fetchPreviewItems$2$1) create(result, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Result result = (Result) this.L$0;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            Ref.BooleanRef booleanRef = this.$hasFetchedFromRemote;
            GalleryItemsService galleryItemsService = this.this$0;
            ItemId itemId = this.$folderId;
            if (!(result instanceof Result.Success)) {
                if (!(result instanceof Result.Error)) {
                    throw new NoWhenBranchMatchedException();
                }
                DomainError domainError = (DomainError) ((Result.Error) result).getValue();
                if (!booleanRef.element && (domainError instanceof DomainError.NoResultFoundError)) {
                    booleanRef.element = true;
                    IRemoteItemService iRemoteItemService = galleryItemsService.itemsService;
                    this.L$0 = SpillingKt.nullOutSpilledVariable(result);
                    this.L$1 = result;
                    this.L$2 = SpillingKt.nullOutSpilledVariable(domainError);
                    this.I$0 = 0;
                    this.I$1 = 0;
                    this.label = 1;
                    if (iRemoteItemService.fetchFolderItemsFromRemote(itemId, this) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                }
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
