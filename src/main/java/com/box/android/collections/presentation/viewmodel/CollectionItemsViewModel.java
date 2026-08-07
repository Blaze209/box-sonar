package com.box.android.collections.presentation.viewmodel;

import android.os.Bundle;
import androidx.lifecycle.CoroutineLiveDataKt;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Transformations;
import androidx.paging.PagedList;
import com.box.android.base.vm.BaseListingViewModel;
import com.box.android.collections.R;
import com.box.android.common.utilities.ErrorEvent;
import com.box.android.common.utilities.ViewModelAssistedFactory;
import com.box.android.coreservices.jobmanager.jobs.BoxItemJob;
import com.box.android.domain.models.CollectionModel;
import com.box.android.domain.models.CollectionType;
import com.box.android.domain.models.DomainError;
import com.box.android.domain.models.DomainErrorKt;
import com.box.android.domain.models.item.ItemModel;
import com.box.android.domain.usecases.collections.ListCollectionItemsInteractor;
import com.box.android.domain.usecases.collections.ListCollectionsInteractor;
import com.box.android.domain.usecases.collections.ListCollectionsUseCase;
import com.box.android.domain.utils.result.Result;
import dagger.assisted.Assisted;
import dagger.assisted.AssistedFactory;
import dagger.assisted.AssistedInject;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.ResultKt;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: CollectionItemsViewModel.kt */
/* JADX INFO: loaded from: classes10.dex */
@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0007\u0018\u0000 \u001f2\u00020\u0001:\u0002\u001e\u001fB#\b\u0007\u0012\b\b\u0001\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\u0018\u0010\u0015\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u000b\u0018\u00010\u000fH\u0082@¢\u0006\u0002\u0010\u0016J\u001a\u0010\u0017\u001a\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u00190\u0018H\u0096@¢\u0006\u0002\u0010\u0016J\u0010\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u0019H\u0014J\b\u0010\u001d\u001a\u00020\rH\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u001d\u0010\u000e\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00110\u00100\u000f¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0019\u0010\u0014\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u000b0\u000f¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0013¨\u0006 "}, d2 = {"Lcom/box/android/collections/presentation/viewmodel/CollectionItemsViewModel;", "Lcom/box/android/base/vm/BaseListingViewModel;", "args", "Landroid/os/Bundle;", "listCollectionItemsInteractor", "Lcom/box/android/domain/usecases/collections/ListCollectionItemsInteractor;", "listCollectionsInteractor", "Lcom/box/android/domain/usecases/collections/ListCollectionsInteractor;", "<init>", "(Landroid/os/Bundle;Lcom/box/android/domain/usecases/collections/ListCollectionItemsInteractor;Lcom/box/android/domain/usecases/collections/ListCollectionsInteractor;)V", BoxItemJob.COLLECTION_ID, "", "initialFetchCompleted", "", "collectionItemsLiveData", "Landroidx/lifecycle/LiveData;", "Landroidx/paging/PagedList;", "Lcom/box/android/domain/models/item/ItemModel;", "getCollectionItemsLiveData", "()Landroidx/lifecycle/LiveData;", "collectionNameLiveData", "getCollectionNameLiveData", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "fetchItems", "Lcom/box/android/domain/utils/result/Result;", "Lcom/box/android/domain/models/DomainError;", "errorHelper", "Lcom/box/android/common/utilities/ErrorEvent;", "error", "areItemsFetched", "Factory", "Companion", "collections_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class CollectionItemsViewModel extends BaseListingViewModel {
    public static final String VM_COLLECTION_ID_KEY = "VM_COLLECTION_ID_KEY";
    private final Bundle args;
    private final String collectionId;
    private final LiveData<PagedList<ItemModel>> collectionItemsLiveData;
    private final LiveData<String> collectionNameLiveData;
    private boolean initialFetchCompleted;
    private final ListCollectionItemsInteractor listCollectionItemsInteractor;
    private final ListCollectionsInteractor listCollectionsInteractor;
    public static final int $stable = 8;

    /* JADX INFO: compiled from: CollectionItemsViewModel.kt */
    @Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bg\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001¨\u0006\u0003À\u0006\u0003"}, d2 = {"Lcom/box/android/collections/presentation/viewmodel/CollectionItemsViewModel$Factory;", "Lcom/box/android/common/utilities/ViewModelAssistedFactory;", "Lcom/box/android/collections/presentation/viewmodel/CollectionItemsViewModel;", "collections_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    @AssistedFactory
    public interface Factory extends ViewModelAssistedFactory<CollectionItemsViewModel> {
    }

    /* JADX INFO: renamed from: com.box.android.collections.presentation.viewmodel.CollectionItemsViewModel$getCollectionNameLiveData$1, reason: invalid class name */
    /* JADX INFO: compiled from: CollectionItemsViewModel.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.box.android.collections.presentation.viewmodel.CollectionItemsViewModel", f = "CollectionItemsViewModel.kt", i = {}, l = {64}, m = "getCollectionNameLiveData", n = {}, s = {}, v = 1)
    static final class AnonymousClass1 extends ContinuationImpl {
        int label;
        /* synthetic */ Object result;

        AnonymousClass1(Continuation<? super AnonymousClass1> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return CollectionItemsViewModel.this.getCollectionNameLiveData(this);
        }
    }

    @AssistedInject
    public CollectionItemsViewModel(@Assisted Bundle args, ListCollectionItemsInteractor listCollectionItemsInteractor, ListCollectionsInteractor listCollectionsInteractor) {
        Intrinsics.checkNotNullParameter(args, "args");
        Intrinsics.checkNotNullParameter(listCollectionItemsInteractor, "listCollectionItemsInteractor");
        Intrinsics.checkNotNullParameter(listCollectionsInteractor, "listCollectionsInteractor");
        this.args = args;
        this.listCollectionItemsInteractor = listCollectionItemsInteractor;
        this.listCollectionsInteractor = listCollectionsInteractor;
        String string = args.getString(VM_COLLECTION_ID_KEY);
        Intrinsics.checkNotNull(string);
        this.collectionId = string;
        this.collectionItemsLiveData = CoroutineLiveDataKt.liveData$default((CoroutineContext) null, 0L, new CollectionItemsViewModel$collectionItemsLiveData$1(this, null), 3, (Object) null);
        this.collectionNameLiveData = CoroutineLiveDataKt.liveData$default((CoroutineContext) null, 0L, new CollectionItemsViewModel$collectionNameLiveData$1(this, null), 3, (Object) null);
    }

    public final LiveData<PagedList<ItemModel>> getCollectionItemsLiveData() {
        return this.collectionItemsLiveData;
    }

    public final LiveData<String> getCollectionNameLiveData() {
        return this.collectionNameLiveData;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    public final Object getCollectionNameLiveData(Continuation<? super LiveData<String>> continuation) {
        AnonymousClass1 anonymousClass1;
        if (continuation instanceof AnonymousClass1) {
            anonymousClass1 = (AnonymousClass1) continuation;
            if ((anonymousClass1.label & Integer.MIN_VALUE) != 0) {
                anonymousClass1.label -= Integer.MIN_VALUE;
            } else {
                anonymousClass1 = new AnonymousClass1(continuation);
            }
        } else {
            anonymousClass1 = new AnonymousClass1(continuation);
        }
        AnonymousClass1 anonymousClass2 = anonymousClass1;
        Object objListCollections$default = anonymousClass2.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = anonymousClass2.label;
        if (i == 0) {
            ResultKt.throwOnFailure(objListCollections$default);
            ListCollectionsInteractor listCollectionsInteractor = this.listCollectionsInteractor;
            List listListOf = CollectionsKt.listOf(CollectionType.PERSONAL);
            anonymousClass2.label = 1;
            objListCollections$default = ListCollectionsUseCase.listCollections$default(listCollectionsInteractor, listListOf, 0, null, anonymousClass2, 6, null);
            if (objListCollections$default == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(objListCollections$default);
        }
        Result result = (Result) objListCollections$default;
        if (result instanceof Result.Success) {
            return Transformations.map((LiveData) ((Result.Success) result).getValue(), new Function1() { // from class: com.box.android.collections.presentation.viewmodel.CollectionItemsViewModel$$ExternalSyntheticLambda0
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    return CollectionItemsViewModel.getCollectionNameLiveData$lambda$0(this.f$0, (PagedList) obj);
                }
            });
        }
        if (result instanceof Result.Error) {
            return null;
        }
        throw new NoWhenBranchMatchedException();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String getCollectionNameLiveData$lambda$0(CollectionItemsViewModel collectionItemsViewModel, PagedList collections) {
        Object next;
        Intrinsics.checkNotNullParameter(collections, "collections");
        Iterator<T> it = collections.iterator();
        do {
            if (!it.hasNext()) {
                next = null;
                break;
            }
            next = it.next();
        } while (!Intrinsics.areEqual(((CollectionModel) next).getId(), collectionItemsViewModel.collectionId));
        CollectionModel collectionModel = (CollectionModel) next;
        if (collectionModel != null) {
            return collectionModel.getName();
        }
        return null;
    }

    @Override // com.box.android.base.vm.BaseListingViewModel
    public Object fetchItems(Continuation<? super Result<Boolean, ? extends DomainError>> continuation) {
        return this.listCollectionItemsInteractor.fetchCollectionItemsFromRemote(this.collectionId, continuation);
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
    /* JADX INFO: renamed from: areItemsFetched, reason: from getter */
    public boolean getInitialFetchCompleted() {
        return this.initialFetchCompleted;
    }
}
