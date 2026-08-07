package com.box.android.utilities;

import com.box.android.R;
import com.box.android.base.presentation.BoxPresentationUtils;
import com.box.android.common.utilities.CommonBoxUtil;
import com.box.android.domain.models.item.ItemModel;
import com.box.android.domain.usecases.jobs.JobTags;
import com.box.android.domain.utils.result.Result;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: compiled from: ItemActionHandler.kt */
/* JADX INFO: loaded from: classes13.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "com.box.android.utilities.ItemActionHandler$handleOfflineItemMenuClick$saveToOffline$1$1", f = "ItemActionHandler.kt", i = {}, l = {618}, m = "invokeSuspend", n = {}, s = {}, v = 1)
final class ItemActionHandler$handleOfflineItemMenuClick$saveToOffline$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ ItemModel $itemModel;
    final /* synthetic */ boolean $shouldSaveOriginal;
    int label;
    final /* synthetic */ ItemActionHandler this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    ItemActionHandler$handleOfflineItemMenuClick$saveToOffline$1$1(ItemActionHandler itemActionHandler, ItemModel itemModel, boolean z, Continuation<? super ItemActionHandler$handleOfflineItemMenuClick$saveToOffline$1$1> continuation) {
        super(2, continuation);
        this.this$0 = itemActionHandler;
        this.$itemModel = itemModel;
        this.$shouldSaveOriginal = z;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new ItemActionHandler$handleOfflineItemMenuClick$saveToOffline$1$1(this.this$0, this.$itemModel, this.$shouldSaveOriginal, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((ItemActionHandler$handleOfflineItemMenuClick$saveToOffline$1$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            this.label = 1;
            obj = this.this$0.offlineService.makeAvailableOffline(CollectionsKt.listOf(this.$itemModel), this.$shouldSaveOriginal, JobTags.JobSource.OFFLINE_SAVE_BROWSE, this);
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
        ItemActionHandler itemActionHandler = this.this$0;
        if (!(result instanceof Result.Success)) {
            if (!(result instanceof Result.Error)) {
                throw new NoWhenBranchMatchedException();
            }
            BoxPresentationUtils.displayToast(CommonBoxUtil.LS(R.string.generic_error), itemActionHandler.getActivity().getApplicationContext());
        }
        return Unit.INSTANCE;
    }
}
