package com.box.android.collections.presentation.viewmodel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MediatorLiveData;
import androidx.paging.PagedList;
import com.box.android.collections.R;
import com.box.android.common.utilities.ErrorEvent;
import com.box.android.domain.models.CollectionModel;
import com.box.android.domain.models.DomainError;
import com.box.android.domain.models.DomainErrorKt;
import com.box.android.domain.utils.result.Result;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: compiled from: CollectionMembershipsViewModel.kt */
/* JADX INFO: loaded from: classes10.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "com.box.android.collections.presentation.viewmodel.CollectionMembershipsViewModel$getMembershipsLiveData$1$1", f = "CollectionMembershipsViewModel.kt", i = {}, l = {120}, m = "invokeSuspend", n = {}, s = {}, v = 1)
final class CollectionMembershipsViewModel$getMembershipsLiveData$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ LiveData<PagedList<CollectionModel>> $collectionsLiveData;
    final /* synthetic */ MediatorLiveData<List<CollectionMembershipModel>> $mutableMemberships;
    int label;
    final /* synthetic */ CollectionMembershipsViewModel this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    CollectionMembershipsViewModel$getMembershipsLiveData$1$1(CollectionMembershipsViewModel collectionMembershipsViewModel, MediatorLiveData<List<CollectionMembershipModel>> mediatorLiveData, LiveData<PagedList<CollectionModel>> liveData, Continuation<? super CollectionMembershipsViewModel$getMembershipsLiveData$1$1> continuation) {
        super(2, continuation);
        this.this$0 = collectionMembershipsViewModel;
        this.$mutableMemberships = mediatorLiveData;
        this.$collectionsLiveData = liveData;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new CollectionMembershipsViewModel$getMembershipsLiveData$1$1(this.this$0, this.$mutableMemberships, this.$collectionsLiveData, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((CollectionMembershipsViewModel$getMembershipsLiveData$1$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            this.label = 1;
            obj = this.this$0.collectionMembershipInteractor.getCollectionMemberships(this.this$0.remoteId, this);
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
        if (result instanceof Result.Success) {
            Boxing.boxBoolean(this.this$0.initialCollectionMemberships.addAll((Collection) ((Result.Success) result).getValue()));
        } else {
            if (!(result instanceof Result.Error)) {
                throw new NoWhenBranchMatchedException();
            }
            if (DomainErrorKt.isNetworkConnectionError((DomainError) ((Result.Error) result).getValue())) {
                this.this$0._errorLiveData.postValue(new ErrorEvent.Toast(R.string.boxsdk_unable_to_connect_todo, new String[0]));
            } else {
                this.this$0._errorLiveData.postValue(new ErrorEvent.Toast(R.string.fetch_collections_error, new String[0]));
            }
        }
        final MediatorLiveData<List<CollectionMembershipModel>> mediatorLiveData = this.$mutableMemberships;
        LiveData liveData = this.$collectionsLiveData;
        final CollectionMembershipsViewModel collectionMembershipsViewModel = this.this$0;
        mediatorLiveData.addSource(liveData, new CollectionMembershipsViewModelKt$sam$androidx_lifecycle_Observer$0(new Function1() { // from class: com.box.android.collections.presentation.viewmodel.CollectionMembershipsViewModel$getMembershipsLiveData$1$1$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj2) {
                return CollectionMembershipsViewModel$getMembershipsLiveData$1$1.invokeSuspend$lambda$0(mediatorLiveData, collectionMembershipsViewModel, (PagedList) obj2);
            }
        }));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit invokeSuspend$lambda$0(MediatorLiveData mediatorLiveData, CollectionMembershipsViewModel collectionMembershipsViewModel, PagedList pagedList) {
        Intrinsics.checkNotNull(pagedList);
        PagedList<CollectionModel> pagedList2 = pagedList;
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(pagedList2, 10));
        for (CollectionModel collectionModel : pagedList2) {
            Intrinsics.checkNotNull(collectionModel);
            arrayList.add(new CollectionMembershipModel(collectionModel, collectionMembershipsViewModel.initialCollectionMemberships.contains(collectionModel)));
        }
        mediatorLiveData.postValue(CollectionsKt.toMutableList((Collection) arrayList));
        return Unit.INSTANCE;
    }
}
