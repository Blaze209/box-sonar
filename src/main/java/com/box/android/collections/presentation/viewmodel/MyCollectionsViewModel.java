package com.box.android.collections.presentation.viewmodel;

import androidx.lifecycle.CoroutineLiveDataKt;
import androidx.lifecycle.LiveData;
import androidx.paging.PagedList;
import com.box.android.base.presentation.fragments.EditTextDialogFragment;
import com.box.android.base.vm.BaseListingViewModel;
import com.box.android.collections.R;
import com.box.android.common.utilities.ErrorEvent;
import com.box.android.domain.analytics.BoxAnalyticsParams;
import com.box.android.domain.models.CollectionModel;
import com.box.android.domain.models.CollectionType;
import com.box.android.domain.models.CollectionsDomainError;
import com.box.android.domain.models.DomainError;
import com.box.android.domain.models.DomainErrorKt;
import com.box.android.domain.usecases.collections.CreateCollectionInteractor;
import com.box.android.domain.usecases.collections.ListCollectionsInteractor;
import com.box.android.domain.usecases.collections.ListCollectionsUseCase;
import com.box.android.domain.utils.result.Result;
import java.util.List;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.ResultKt;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: MyCollectionsViewModel.kt */
/* JADX INFO: loaded from: classes10.dex */
@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0019\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u001c\u0010\u000e\u001a\u0010\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000b0\n\u0018\u00010\tH\u0082@¢\u0006\u0002\u0010\u000fJ\u0010\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0013H\u0014J\u0018\u0010\u0014\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0015\u001a\u00020\u0016H\u0007J\u001a\u0010\u0017\u001a\u000e\u0012\u0004\u0012\u00020\u0019\u0012\u0004\u0012\u00020\u00130\u0018H\u0096@¢\u0006\u0002\u0010\u000fJ\u000e\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u0015\u001a\u00020\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u001d\u0010\b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000b0\n0\t¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\r¨\u0006\u001c"}, d2 = {"Lcom/box/android/collections/presentation/viewmodel/MyCollectionsViewModel;", "Lcom/box/android/base/vm/BaseListingViewModel;", "listCollectionsInteractor", "Lcom/box/android/domain/usecases/collections/ListCollectionsInteractor;", "createCollectionInteractor", "Lcom/box/android/domain/usecases/collections/CreateCollectionInteractor;", "<init>", "(Lcom/box/android/domain/usecases/collections/ListCollectionsInteractor;Lcom/box/android/domain/usecases/collections/CreateCollectionInteractor;)V", "collectionsLiveData", "Landroidx/lifecycle/LiveData;", "Landroidx/paging/PagedList;", "Lcom/box/android/domain/models/CollectionModel;", "getCollectionsLiveData", "()Landroidx/lifecycle/LiveData;", "getLiveData", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "errorHelper", "Lcom/box/android/common/utilities/ErrorEvent;", "error", "Lcom/box/android/domain/models/DomainError;", "createErrorHelper", "newCollectionName", "", "fetchItems", "Lcom/box/android/domain/utils/result/Result;", "", "createCollection", "", "collections_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class MyCollectionsViewModel extends BaseListingViewModel {
    public static final int $stable = 8;
    private final LiveData<PagedList<CollectionModel>> collectionsLiveData;
    private final CreateCollectionInteractor createCollectionInteractor;
    private final ListCollectionsInteractor listCollectionsInteractor;

    /* JADX INFO: renamed from: com.box.android.collections.presentation.viewmodel.MyCollectionsViewModel$getLiveData$1, reason: invalid class name */
    /* JADX INFO: compiled from: MyCollectionsViewModel.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.box.android.collections.presentation.viewmodel.MyCollectionsViewModel", f = "MyCollectionsViewModel.kt", i = {}, l = {39}, m = "getLiveData", n = {}, s = {}, v = 1)
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
            return MyCollectionsViewModel.this.getLiveData(this);
        }
    }

    @Inject
    public MyCollectionsViewModel(ListCollectionsInteractor listCollectionsInteractor, CreateCollectionInteractor createCollectionInteractor) {
        Intrinsics.checkNotNullParameter(listCollectionsInteractor, "listCollectionsInteractor");
        Intrinsics.checkNotNullParameter(createCollectionInteractor, "createCollectionInteractor");
        this.listCollectionsInteractor = listCollectionsInteractor;
        this.createCollectionInteractor = createCollectionInteractor;
        this.collectionsLiveData = CoroutineLiveDataKt.liveData$default((CoroutineContext) null, 0L, new MyCollectionsViewModel$collectionsLiveData$1(this, null), 3, (Object) null);
    }

    public final LiveData<PagedList<CollectionModel>> getCollectionsLiveData() {
        return this.collectionsLiveData;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    public final Object getLiveData(Continuation<? super LiveData<PagedList<CollectionModel>>> continuation) {
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
            return (LiveData) ((Result.Success) result).getValue();
        }
        if (!(result instanceof Result.Error)) {
            throw new NoWhenBranchMatchedException();
        }
        Result.Error error = (Result.Error) result;
        Object value = error.getValue();
        DomainError.CachedDomainError cachedDomainError = value instanceof DomainError.CachedDomainError ? (DomainError.CachedDomainError) value : null;
        if (cachedDomainError == null) {
            cachedDomainError = new DomainError.CachedDomainError(null, (DomainError) error.getValue());
        }
        get_errorLiveData().setValue(errorHelper(cachedDomainError.getError()));
        return (LiveData) cachedDomainError.getCache();
    }

    @Override // com.box.android.base.vm.BaseListingViewModel
    protected ErrorEvent errorHelper(DomainError error) {
        Intrinsics.checkNotNullParameter(error, "error");
        if (DomainErrorKt.isNetworkConnectionError(error)) {
            return new ErrorEvent.SnackbarWithButton(R.string.boxsdk_error_network_connection, R.string.box_browsesdk_tap_to_retry);
        }
        return new ErrorEvent.Toast(R.string.box_sharesdk_generic_error, new String[0]);
    }

    public final ErrorEvent createErrorHelper(DomainError error, String newCollectionName) {
        Intrinsics.checkNotNullParameter(error, "error");
        Intrinsics.checkNotNullParameter(newCollectionName, "newCollectionName");
        if ((error instanceof CollectionsDomainError.CollectionNameConflict) || (error instanceof DomainError.APIResourceConflict)) {
            return new ErrorEvent.Toast(R.string.create_collection_collection_name_conflict_error, newCollectionName);
        }
        if ((error instanceof CollectionsDomainError.CollectionNameMalformed) || (error instanceof DomainError.APIRequestError)) {
            return new ErrorEvent.Toast(R.string.create_collection_malformed_name, new String[0]);
        }
        if (DomainErrorKt.isNetworkConnectionError(error)) {
            return new ErrorEvent.Toast(R.string.create_collection_network_error, new String[0]);
        }
        return new ErrorEvent.Toast(R.string.create_collection_generic_error, new String[0]);
    }

    @Override // com.box.android.base.vm.BaseListingViewModel
    public Object fetchItems(Continuation<? super Result<Boolean, ? extends DomainError>> continuation) {
        return this.listCollectionsInteractor.fetchCollectionsFromRemote(CollectionType.PERSONAL, continuation);
    }

    public final void createCollection(String newCollectionName) {
        Intrinsics.checkNotNullParameter(newCollectionName, "newCollectionName");
        Result<CollectionModel, DomainError> resultCreateCollection = this.createCollectionInteractor.createCollection(newCollectionName, CollectionType.PERSONAL);
        boolean z = resultCreateCollection instanceof Result.Success;
        if (z) {
            EditTextDialogFragment.Companion.logEvent$default(EditTextDialogFragment.INSTANCE, null, BoxAnalyticsParams.EVENT_CREATE_COLLECTION_CTA_TRIGGERED, 1, null);
        } else if (!(resultCreateCollection instanceof Result.Error)) {
            throw new NoWhenBranchMatchedException();
        }
        if (z) {
            return;
        }
        if (!(resultCreateCollection instanceof Result.Error)) {
            throw new NoWhenBranchMatchedException();
        }
        DomainError domainError = (DomainError) ((Result.Error) resultCreateCollection).getValue();
        get_errorLiveData().postValue(createErrorHelper(domainError, newCollectionName));
        EditTextDialogFragment.INSTANCE.logEvent(BoxAnalyticsParams.INSTANCE.getCreateCollectionError(domainError), BoxAnalyticsParams.EVENT_CREATE_COLLECTION_CTA_TRIGGERED);
    }
}
