package com.box.android.collections.presentation.viewmodel;

import androidx.lifecycle.CoroutineLiveDataKt;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Transformations;
import androidx.paging.PagedList;
import com.box.android.base.vm.BaseListingViewModel;
import com.box.android.collections.R;
import com.box.android.common.utilities.ErrorEvent;
import com.box.android.coreservices.jobmanager.jobs.BoxItemJob;
import com.box.android.domain.models.DomainError;
import com.box.android.domain.models.DomainErrorKt;
import com.box.android.domain.models.item.ItemModel;
import com.box.android.domain.usecases.collections.GetFavoritesCollectionIdUseCase;
import com.box.android.domain.usecases.collections.ListCollectionItemsInteractor;
import com.box.android.domain.utils.result.Result;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: FavoritesCollectionItemsViewModel.kt */
/* JADX INFO: loaded from: classes10.dex */
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u0001B\u0019\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0016H\u0014J\u001c\u0010\u0017\u001a\u0010\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u0016\u0018\u00010\u0018H\u0096@¢\u0006\u0002\u0010\u0019J\b\u0010\u001a\u001a\u00020\tH\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u0017\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000b¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u001d\u0010\u000f\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00110\u00100\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u000e¨\u0006\u001b"}, d2 = {"Lcom/box/android/collections/presentation/viewmodel/FavoritesCollectionItemsViewModel;", "Lcom/box/android/base/vm/BaseListingViewModel;", "listCollectionItemsInteractor", "Lcom/box/android/domain/usecases/collections/ListCollectionItemsInteractor;", "getFavoritesCollectionIdUseCase", "Lcom/box/android/domain/usecases/collections/GetFavoritesCollectionIdUseCase;", "<init>", "(Lcom/box/android/domain/usecases/collections/ListCollectionItemsInteractor;Lcom/box/android/domain/usecases/collections/GetFavoritesCollectionIdUseCase;)V", "initialFetchCompleted", "", BoxItemJob.COLLECTION_ID, "Landroidx/lifecycle/LiveData;", "", "getCollectionId", "()Landroidx/lifecycle/LiveData;", "collectionItemsLiveData", "Landroidx/paging/PagedList;", "Lcom/box/android/domain/models/item/ItemModel;", "getCollectionItemsLiveData", "errorHelper", "Lcom/box/android/common/utilities/ErrorEvent;", "error", "Lcom/box/android/domain/models/DomainError;", "fetchItems", "Lcom/box/android/domain/utils/result/Result;", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "areItemsFetched", "collections_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class FavoritesCollectionItemsViewModel extends BaseListingViewModel {
    public static final int $stable = 8;
    private final LiveData<String> collectionId;
    private final LiveData<PagedList<ItemModel>> collectionItemsLiveData;
    private final GetFavoritesCollectionIdUseCase getFavoritesCollectionIdUseCase;
    private boolean initialFetchCompleted;
    private final ListCollectionItemsInteractor listCollectionItemsInteractor;

    @Inject
    public FavoritesCollectionItemsViewModel(ListCollectionItemsInteractor listCollectionItemsInteractor, GetFavoritesCollectionIdUseCase getFavoritesCollectionIdUseCase) {
        Intrinsics.checkNotNullParameter(listCollectionItemsInteractor, "listCollectionItemsInteractor");
        Intrinsics.checkNotNullParameter(getFavoritesCollectionIdUseCase, "getFavoritesCollectionIdUseCase");
        this.listCollectionItemsInteractor = listCollectionItemsInteractor;
        this.getFavoritesCollectionIdUseCase = getFavoritesCollectionIdUseCase;
        LiveData<String> liveDataLiveData$default = CoroutineLiveDataKt.liveData$default((CoroutineContext) null, 0L, new FavoritesCollectionItemsViewModel$collectionId$1(this, null), 3, (Object) null);
        this.collectionId = liveDataLiveData$default;
        this.collectionItemsLiveData = Transformations.switchMap(liveDataLiveData$default, new Function1() { // from class: com.box.android.collections.presentation.viewmodel.FavoritesCollectionItemsViewModel$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return FavoritesCollectionItemsViewModel.collectionItemsLiveData$lambda$0(this.f$0, (String) obj);
            }
        });
    }

    public final LiveData<String> getCollectionId() {
        return this.collectionId;
    }

    public final LiveData<PagedList<ItemModel>> getCollectionItemsLiveData() {
        return this.collectionItemsLiveData;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final LiveData collectionItemsLiveData$lambda$0(FavoritesCollectionItemsViewModel favoritesCollectionItemsViewModel, String collectionId) {
        Intrinsics.checkNotNullParameter(collectionId, "collectionId");
        return CoroutineLiveDataKt.liveData$default((CoroutineContext) null, 0L, new FavoritesCollectionItemsViewModel$collectionItemsLiveData$1$1(favoritesCollectionItemsViewModel, collectionId, null), 3, (Object) null);
    }

    @Override // com.box.android.base.vm.BaseListingViewModel
    protected ErrorEvent errorHelper(DomainError error) {
        Intrinsics.checkNotNullParameter(error, "error");
        if (DomainErrorKt.isNetworkConnectionError(error)) {
            return new ErrorEvent.SnackbarWithButton(R.string.boxsdk_error_network_connection, R.string.box_browsesdk_tap_to_retry);
        }
        return new ErrorEvent.Toast(R.string.box_sharesdk_generic_error, new String[0]);
    }

    @Override // com.box.android.base.vm.BaseListingViewModel
    public Object fetchItems(Continuation<? super Result<Boolean, ? extends DomainError>> continuation) {
        String value = this.collectionId.getValue();
        if (value == null) {
            return null;
        }
        Object objFetchCollectionItemsFromRemote = this.listCollectionItemsInteractor.fetchCollectionItemsFromRemote(value, continuation);
        return objFetchCollectionItemsFromRemote == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objFetchCollectionItemsFromRemote : (Result) objFetchCollectionItemsFromRemote;
    }

    @Override // com.box.android.base.vm.BaseListingViewModel
    /* JADX INFO: renamed from: areItemsFetched, reason: from getter */
    public boolean getInitialFetchCompleted() {
        return this.initialFetchCompleted;
    }
}
