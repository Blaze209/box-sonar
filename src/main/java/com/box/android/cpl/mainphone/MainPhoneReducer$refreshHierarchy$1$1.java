package com.box.android.cpl.mainphone;

import com.box.android.domain.models.item.FolderModel;
import com.box.android.domain.models.item.ItemModel;
import com.box.android.domain.models.item.ItemModelKt;
import com.box.android.domain.utils.result.Result;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: MainPhoneReducer.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000\u0006\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001H\n"}, d2 = {"<anonymous>", "Lcom/box/android/cpl/mainphone/MainPhoneReducer$Action;"}, k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "com.box.android.cpl.mainphone.MainPhoneReducer$refreshHierarchy$1$1", f = "MainPhoneReducer.kt", i = {}, l = {232}, m = "invokeSuspend", n = {}, s = {}, v = 1)
final class MainPhoneReducer$refreshHierarchy$1$1 extends SuspendLambda implements Function1<Continuation<? super MainPhoneReducer.Action>, Object> {
    final /* synthetic */ FolderModel $it;
    int label;
    final /* synthetic */ MainPhoneReducer this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    MainPhoneReducer$refreshHierarchy$1$1(MainPhoneReducer mainPhoneReducer, FolderModel folderModel, Continuation<? super MainPhoneReducer$refreshHierarchy$1$1> continuation) {
        super(1, continuation);
        this.this$0 = mainPhoneReducer;
        this.$it = folderModel;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Continuation<?> continuation) {
        return new MainPhoneReducer$refreshHierarchy$1$1(this.this$0, this.$it, continuation);
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Continuation<? super MainPhoneReducer.Action> continuation) {
        return ((MainPhoneReducer$refreshHierarchy$1$1) create(continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            this.label = 1;
            obj = this.this$0.environment.getBrowseEnvironment().getFolderViewUseCase().getFolderHierarchy(ItemModelKt.toItemIdRemoteId(this.$it), this);
            if (obj == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
        }
        Result.Error error = (Result) obj;
        if (error instanceof Result.Success) {
            List<ItemModel> list = (List) ((Result.Success) error).getValue();
            ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
            for (ItemModel itemModel : list) {
                arrayList.add(new MainPhoneReducer.HierarchyModel(ItemModelKt.toItemIdRemoteId(itemModel).getBoxId(), itemModel.getName(), MainPhoneReducer.HierarchyModelType.FOLDER));
            }
            error = new Result.Success(new MainPhoneReducer.Action.HierarchyRefreshed(arrayList));
        } else if (!(error instanceof Result.Error)) {
            throw new NoWhenBranchMatchedException();
        }
        if (!(error instanceof Result.Success)) {
            if (!(error instanceof Result.Error)) {
                throw new NoWhenBranchMatchedException();
            }
            error = new Result.Error(MainPhoneReducer.Action.HierarchyRefreshFailed.INSTANCE);
        }
        Object obj2 = com.box.android.domain.utils.result.ResultKt.get(error);
        Intrinsics.checkNotNull(obj2, "null cannot be cast to non-null type com.box.android.cpl.mainphone.MainPhoneReducer.Action");
        return (MainPhoneReducer.Action) obj2;
    }
}
