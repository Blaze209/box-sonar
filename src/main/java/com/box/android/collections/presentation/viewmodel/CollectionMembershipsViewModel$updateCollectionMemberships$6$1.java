package com.box.android.collections.presentation.viewmodel;

import com.box.android.base.presentation.BoxPresentationUtils;
import com.box.android.collections.R;
import com.box.android.common.utilities.ApplicationProvider;
import com.box.android.common.utilities.ErrorEvent;
import com.box.android.domain.models.DomainError;
import com.box.android.domain.utils.result.Result;
import com.facebook.imageutils.JfifUtil;
import java.util.List;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: compiled from: CollectionMembershipsViewModel.kt */
/* JADX INFO: loaded from: classes10.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "com.box.android.collections.presentation.viewmodel.CollectionMembershipsViewModel$updateCollectionMemberships$6$1", f = "CollectionMembershipsViewModel.kt", i = {}, l = {JfifUtil.MARKER_SOI}, m = "invokeSuspend", n = {}, s = {}, v = 1)
final class CollectionMembershipsViewModel$updateCollectionMemberships$6$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ List<String> $collectionIds;
    int label;
    final /* synthetic */ CollectionMembershipsViewModel this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    CollectionMembershipsViewModel$updateCollectionMemberships$6$1(CollectionMembershipsViewModel collectionMembershipsViewModel, List<String> list, Continuation<? super CollectionMembershipsViewModel$updateCollectionMemberships$6$1> continuation) {
        super(2, continuation);
        this.this$0 = collectionMembershipsViewModel;
        this.$collectionIds = list;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new CollectionMembershipsViewModel$updateCollectionMemberships$6$1(this.this$0, this.$collectionIds, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((CollectionMembershipsViewModel$updateCollectionMemberships$6$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            this.label = 1;
            obj = this.this$0.collectionMembershipInteractor.addItemToCollections(this.this$0.remoteId, this.$collectionIds, this);
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
        CollectionMembershipsViewModel collectionMembershipsViewModel = this.this$0;
        boolean z = result instanceof Result.Success;
        if (!z) {
            if (result instanceof Result.Error) {
                ErrorEvent errorEventAddCollectionMembershipErrorHelper = collectionMembershipsViewModel.addCollectionMembershipErrorHelper((DomainError) ((Result.Error) result).getValue());
                Intrinsics.checkNotNull(errorEventAddCollectionMembershipErrorHelper, "null cannot be cast to non-null type com.box.android.common.utilities.ErrorEvent.Toast");
                BoxPresentationUtils.displayToast(((ErrorEvent.Toast) errorEventAddCollectionMembershipErrorHelper).getMessage(), ApplicationProvider.getApplication(), new String[0]);
            } else {
                throw new NoWhenBranchMatchedException();
            }
        }
        if (z) {
            BoxPresentationUtils.displayToast(R.string.add_collection_membership_success, ApplicationProvider.getApplication(), new String[0]);
        } else if (!(result instanceof Result.Error)) {
            throw new NoWhenBranchMatchedException();
        }
        return Unit.INSTANCE;
    }
}
