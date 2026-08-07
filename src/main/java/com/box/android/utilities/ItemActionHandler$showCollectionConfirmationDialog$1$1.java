package com.box.android.utilities;

import com.box.android.R;
import com.box.android.base.presentation.BoxPresentationUtils;
import com.box.android.domain.models.DomainError;
import com.box.android.domain.models.ItemId;
import com.box.android.domain.utils.result.Result;
import java.util.ArrayList;
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

/* JADX INFO: compiled from: ItemActionHandler.kt */
/* JADX INFO: loaded from: classes13.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "com.box.android.utilities.ItemActionHandler$showCollectionConfirmationDialog$1$1", f = "ItemActionHandler.kt", i = {}, l = {751}, m = "invokeSuspend", n = {}, s = {}, v = 1)
final class ItemActionHandler$showCollectionConfirmationDialog$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ ArrayList<String> $collections;
    final /* synthetic */ ItemId.Remote $remoteId;
    int label;
    final /* synthetic */ ItemActionHandler this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    ItemActionHandler$showCollectionConfirmationDialog$1$1(ItemActionHandler itemActionHandler, ItemId.Remote remote, ArrayList<String> arrayList, Continuation<? super ItemActionHandler$showCollectionConfirmationDialog$1$1> continuation) {
        super(2, continuation);
        this.this$0 = itemActionHandler;
        this.$remoteId = remote;
        this.$collections = arrayList;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new ItemActionHandler$showCollectionConfirmationDialog$1$1(this.this$0, this.$remoteId, this.$collections, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((ItemActionHandler$showCollectionConfirmationDialog$1$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            this.label = 1;
            obj = this.this$0.collectionMembershipsInteractor.removeItemFromCollections(this.$remoteId, this.$collections, this);
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
        boolean z = result instanceof Result.Success;
        if (z) {
            BoxPresentationUtils.displayToast(R.string.remove_collection_membership_success, itemActionHandler.getActivity(), new String[0]);
        } else if (!(result instanceof Result.Error)) {
            throw new NoWhenBranchMatchedException();
        }
        ItemActionHandler itemActionHandler2 = this.this$0;
        if (!z) {
            if (!(result instanceof Result.Error)) {
                throw new NoWhenBranchMatchedException();
            }
            DomainError domainError = (DomainError) ((Result.Error) result).getValue();
            if ((domainError instanceof DomainError.NetworkError) || (domainError instanceof DomainError.NoConnectivityError)) {
                BoxPresentationUtils.displayToast(R.string.remove_collection_membership_network_error, itemActionHandler2.getActivity(), new String[0]);
            } else {
                BoxPresentationUtils.displayToast(R.string.remove_collection_membership_generic_error, itemActionHandler2.getActivity(), new String[0]);
            }
        }
        return Unit.INSTANCE;
    }
}
