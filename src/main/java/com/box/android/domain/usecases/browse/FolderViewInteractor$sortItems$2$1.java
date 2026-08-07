package com.box.android.domain.usecases.browse;

import com.box.android.domain.models.item.ItemModel;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: compiled from: FolderViewInteractor.kt */
/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\u0003H\n"}, d2 = {"<anonymous>", "", "Lcom/box/android/domain/models/item/ItemModel;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "com.box.android.domain.usecases.browse.FolderViewInteractor$sortItems$2$1", f = "FolderViewInteractor.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {}, v = 1)
final class FolderViewInteractor$sortItems$2$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super List<? extends ItemModel>>, Object> {
    final /* synthetic */ List<ItemModel> $items;
    int label;
    final /* synthetic */ FolderViewInteractor this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    FolderViewInteractor$sortItems$2$1(FolderViewInteractor folderViewInteractor, List<? extends ItemModel> list, Continuation<? super FolderViewInteractor$sortItems$2$1> continuation) {
        super(2, continuation);
        this.this$0 = folderViewInteractor;
        this.$items = list;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new FolderViewInteractor$sortItems$2$1(this.this$0, this.$items, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super List<? extends ItemModel>> continuation) {
        return ((FolderViewInteractor$sortItems$2$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            return this.this$0.itemSorter.sort(this.$items);
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
