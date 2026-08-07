package com.box.android.collections.presentation.viewmodel;

import android.os.Build;
import android.os.Bundle;
import android.os.Parcelable;
import androidx.lifecycle.CoroutineLiveDataKt;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MediatorLiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelKt;
import androidx.paging.PagedList;
import com.box.android.base.presentation.fragments.EditTextDialogFragment;
import com.box.android.collections.R;
import com.box.android.common.utilities.ErrorEvent;
import com.box.android.common.utilities.ViewModelAssistedFactory;
import com.box.android.domain.analytics.BoxAnalyticsParams;
import com.box.android.domain.models.CollectionModel;
import com.box.android.domain.models.CollectionType;
import com.box.android.domain.models.CollectionsDomainError;
import com.box.android.domain.models.DomainError;
import com.box.android.domain.models.DomainErrorKt;
import com.box.android.domain.models.ItemId;
import com.box.android.domain.models.item.ItemModel;
import com.box.android.domain.models.item.ItemModelKt;
import com.box.android.domain.usecases.collections.CollectionMembershipsInteractor;
import com.box.android.domain.usecases.collections.CreateCollectionInteractor;
import com.box.android.domain.usecases.collections.ListCollectionsInteractor;
import com.box.android.domain.utils.result.Result;
import dagger.assisted.Assisted;
import dagger.assisted.AssistedFactory;
import dagger.assisted.AssistedInject;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashSet;
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
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;

/* JADX INFO: compiled from: CollectionMembershipsViewModel.kt */
/* JADX INFO: loaded from: classes10.dex */
@Metadata(d1 = {"\u0000\u0086\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0007\u0018\u0000 52\u00020\u00012\u00020\u0002:\u000256B+\b\u0007\u0012\b\b\u0001\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\n¢\u0006\u0004\b\u000b\u0010\fJ\u001c\u0010!\u001a\u0010\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000f0\u0015\u0018\u00010\u0014H\u0082@¢\u0006\u0002\u0010\"J\u0014\u0010#\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001e0\u001d0\u0017H\u0002J\u0018\u0010$\u001a\u00020%2\u0006\u0010&\u001a\u00020\u001e2\b\b\u0002\u0010'\u001a\u00020(J\u0006\u0010)\u001a\u00020%J\u0010\u0010*\u001a\u00020\u00182\u0006\u0010+\u001a\u00020,H\u0007J\u0018\u0010-\u001a\u00020\u00182\u0006\u0010+\u001a\u00020,2\u0006\u0010.\u001a\u00020/H\u0007J\u000e\u00100\u001a\u00020%2\u0006\u0010.\u001a\u00020/R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u001e\u0010\r\u001a\u0012\u0012\u0004\u0012\u00020\u000f0\u000ej\b\u0012\u0004\u0012\u00020\u000f`\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0013\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000f0\u00150\u0014X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00180\u0017X\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00180\u00148F¢\u0006\u0006\u001a\u0004\b\u001a\u0010\u001bR\u001a\u0010\u001c\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001e0\u001d0\u0017X\u0082\u0004¢\u0006\u0002\n\u0000R\u001d\u0010\u001f\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001e0\u001d0\u00148F¢\u0006\u0006\u001a\u0004\b \u0010\u001bR\u0012\u00101\u001a\u000202X\u0096\u0005¢\u0006\u0006\u001a\u0004\b3\u00104¨\u00067"}, d2 = {"Lcom/box/android/collections/presentation/viewmodel/CollectionMembershipsViewModel;", "Landroidx/lifecycle/ViewModel;", "Lkotlinx/coroutines/CoroutineScope;", "args", "Landroid/os/Bundle;", "listCollectionsInteractor", "Lcom/box/android/domain/usecases/collections/ListCollectionsInteractor;", "collectionMembershipInteractor", "Lcom/box/android/domain/usecases/collections/CollectionMembershipsInteractor;", "createCollectionInteractor", "Lcom/box/android/domain/usecases/collections/CreateCollectionInteractor;", "<init>", "(Landroid/os/Bundle;Lcom/box/android/domain/usecases/collections/ListCollectionsInteractor;Lcom/box/android/domain/usecases/collections/CollectionMembershipsInteractor;Lcom/box/android/domain/usecases/collections/CreateCollectionInteractor;)V", "initialCollectionMemberships", "Ljava/util/HashSet;", "Lcom/box/android/domain/models/CollectionModel;", "Lkotlin/collections/HashSet;", "remoteId", "Lcom/box/android/domain/models/ItemId$Remote;", "collectionsLiveData", "Landroidx/lifecycle/LiveData;", "Landroidx/paging/PagedList;", "_errorLiveData", "Landroidx/lifecycle/MutableLiveData;", "Lcom/box/android/common/utilities/ErrorEvent;", "errorLiveData", "getErrorLiveData", "()Landroidx/lifecycle/LiveData;", "_collectionMembershipsLiveData", "", "Lcom/box/android/collections/presentation/viewmodel/CollectionMembershipModel;", "collectionMembershipsLiveData", "getCollectionMembershipsLiveData", "getLiveData", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getMembershipsLiveData", "updateCollectionMembershipModel", "", "collectionMembershipModel", "isChecked", "", "updateCollectionMemberships", "addCollectionMembershipErrorHelper", "error", "Lcom/box/android/domain/models/DomainError;", "createCollectionErrorHelper", "newCollectionName", "", "createAndAddSelected", "coroutineContext", "Lkotlin/coroutines/CoroutineContext;", "getCoroutineContext", "()Lkotlin/coroutines/CoroutineContext;", "CollectionModelComparator", "Factory", "collections_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class CollectionMembershipsViewModel extends ViewModel implements CoroutineScope {
    public static final String VM_ITEM_MODEL_KEY = "VM_ITEM_MODEL_KEY";
    private final /* synthetic */ CoroutineScope $$delegate_0;
    private final MutableLiveData<List<CollectionMembershipModel>> _collectionMembershipsLiveData;
    private final MutableLiveData<ErrorEvent> _errorLiveData;
    private final Bundle args;
    private final CollectionMembershipsInteractor collectionMembershipInteractor;
    private final LiveData<PagedList<CollectionModel>> collectionsLiveData;
    private final CreateCollectionInteractor createCollectionInteractor;
    private HashSet<CollectionModel> initialCollectionMemberships;
    private final ListCollectionsInteractor listCollectionsInteractor;
    private final ItemId.Remote remoteId;

    /* JADX INFO: renamed from: CollectionModelComparator, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public static final int $stable = 8;

    /* JADX INFO: compiled from: CollectionMembershipsViewModel.kt */
    @Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bg\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001¨\u0006\u0003À\u0006\u0003"}, d2 = {"Lcom/box/android/collections/presentation/viewmodel/CollectionMembershipsViewModel$Factory;", "Lcom/box/android/common/utilities/ViewModelAssistedFactory;", "Lcom/box/android/collections/presentation/viewmodel/CollectionMembershipsViewModel;", "collections_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    @AssistedFactory
    public interface Factory extends ViewModelAssistedFactory<CollectionMembershipsViewModel> {
    }

    /* JADX INFO: renamed from: com.box.android.collections.presentation.viewmodel.CollectionMembershipsViewModel$getLiveData$1, reason: invalid class name */
    /* JADX INFO: compiled from: CollectionMembershipsViewModel.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.box.android.collections.presentation.viewmodel.CollectionMembershipsViewModel", f = "CollectionMembershipsViewModel.kt", i = {}, l = {92}, m = "getLiveData", n = {}, s = {}, v = 1)
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
            return CollectionMembershipsViewModel.this.getLiveData(this);
        }
    }

    @Override // kotlinx.coroutines.CoroutineScope
    public CoroutineContext getCoroutineContext() {
        return this.$$delegate_0.getCoroutineContext();
    }

    @AssistedInject
    public CollectionMembershipsViewModel(@Assisted Bundle args, ListCollectionsInteractor listCollectionsInteractor, CollectionMembershipsInteractor collectionMembershipInteractor, CreateCollectionInteractor createCollectionInteractor) {
        Parcelable parcelable;
        Intrinsics.checkNotNullParameter(args, "args");
        Intrinsics.checkNotNullParameter(listCollectionsInteractor, "listCollectionsInteractor");
        Intrinsics.checkNotNullParameter(collectionMembershipInteractor, "collectionMembershipInteractor");
        Intrinsics.checkNotNullParameter(createCollectionInteractor, "createCollectionInteractor");
        this.$$delegate_0 = CoroutineScopeKt.CoroutineScope(Dispatchers.getMain());
        this.args = args;
        this.listCollectionsInteractor = listCollectionsInteractor;
        this.collectionMembershipInteractor = collectionMembershipInteractor;
        this.createCollectionInteractor = createCollectionInteractor;
        this.initialCollectionMemberships = new HashSet<>();
        if (Build.VERSION.SDK_INT >= 33) {
            parcelable = (Parcelable) args.getParcelable(VM_ITEM_MODEL_KEY, ItemModel.class);
        } else {
            Parcelable parcelable2 = args.getParcelable(VM_ITEM_MODEL_KEY);
            parcelable = (ItemModel) (parcelable2 instanceof ItemModel ? parcelable2 : null);
        }
        if (parcelable != null) {
            this.remoteId = ItemModelKt.toItemIdRemoteId((ItemModel) parcelable);
            this.collectionsLiveData = CoroutineLiveDataKt.liveData$default((CoroutineContext) null, 0L, new CollectionMembershipsViewModel$collectionsLiveData$1(this, null), 3, (Object) null);
            this._errorLiveData = new MutableLiveData<>();
            this._collectionMembershipsLiveData = getMembershipsLiveData();
            return;
        }
        throw new IllegalArgumentException("Parcelable with key VM_ITEM_MODEL_KEY not found in Bundle".toString());
    }

    public final LiveData<ErrorEvent> getErrorLiveData() {
        return this._errorLiveData;
    }

    public final LiveData<List<CollectionMembershipModel>> getCollectionMembershipsLiveData() {
        return this._collectionMembershipsLiveData;
    }

    /* JADX INFO: renamed from: com.box.android.collections.presentation.viewmodel.CollectionMembershipsViewModel$CollectionModelComparator, reason: from kotlin metadata */
    /* JADX INFO: compiled from: CollectionMembershipsViewModel.kt */
    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0087\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0016\u0010\u0006\u001a\u0012\u0012\u0004\u0012\u00020\b0\u0007j\b\u0012\u0004\u0012\u00020\b`\tR\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006\n"}, d2 = {"Lcom/box/android/collections/presentation/viewmodel/CollectionMembershipsViewModel$CollectionModelComparator;", "", "<init>", "()V", CollectionMembershipsViewModel.VM_ITEM_MODEL_KEY, "", "listComparator", "Ljava/util/Comparator;", "Lcom/box/android/domain/models/CollectionModel;", "Lkotlin/Comparator;", "collections_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final Comparator<CollectionModel> listComparator() {
            return new Comparator() { // from class: com.box.android.collections.presentation.viewmodel.CollectionMembershipsViewModel$CollectionModelComparator$$ExternalSyntheticLambda0
                @Override // java.util.Comparator
                public final int compare(Object obj, Object obj2) {
                    return CollectionMembershipsViewModel.Companion.listComparator$lambda$0((CollectionModel) obj, (CollectionModel) obj2);
                }
            };
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final int listComparator$lambda$0(CollectionModel collectionModel, CollectionModel collectionModel2) {
            if (collectionModel.getType() == CollectionType.FAVORITES) {
                return -1;
            }
            if (collectionModel2.getType() == CollectionType.FAVORITES) {
                return 1;
            }
            return collectionModel.getName().compareTo(collectionModel2.getName());
        }
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
        Object objListCollections = anonymousClass1.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = anonymousClass1.label;
        if (i == 0) {
            ResultKt.throwOnFailure(objListCollections);
            ListCollectionsInteractor listCollectionsInteractor = this.listCollectionsInteractor;
            List<? extends CollectionType> listListOf = CollectionsKt.listOf((Object[]) new CollectionType[]{CollectionType.PERSONAL, CollectionType.FAVORITES});
            Comparator<CollectionModel> comparatorListComparator = INSTANCE.listComparator();
            anonymousClass1.label = 1;
            objListCollections = listCollectionsInteractor.listCollections(listListOf, 100, comparatorListComparator, anonymousClass1);
            if (objListCollections == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(objListCollections);
        }
        Result result = (Result) objListCollections;
        if (result instanceof Result.Success) {
            return (LiveData) ((Result.Success) result).getValue();
        }
        if (!(result instanceof Result.Error)) {
            throw new NoWhenBranchMatchedException();
        }
        if (DomainErrorKt.isNetworkConnectionError((DomainError) ((Result.Error) result).getValue())) {
            this._errorLiveData.postValue(new ErrorEvent.Toast(R.string.boxsdk_unable_to_connect_todo, new String[0]));
            return null;
        }
        this._errorLiveData.postValue(new ErrorEvent.Toast(R.string.fetch_collections_error, new String[0]));
        return null;
    }

    private final MutableLiveData<List<CollectionMembershipModel>> getMembershipsLiveData() {
        MediatorLiveData mediatorLiveData = new MediatorLiveData();
        LiveData<PagedList<CollectionModel>> liveData = this.collectionsLiveData;
        if (liveData != null) {
            BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new CollectionMembershipsViewModel$getMembershipsLiveData$1$1(this, mediatorLiveData, liveData, null), 3, null);
        }
        return mediatorLiveData;
    }

    public static /* synthetic */ void updateCollectionMembershipModel$default(CollectionMembershipsViewModel collectionMembershipsViewModel, CollectionMembershipModel collectionMembershipModel, boolean z, int i, Object obj) {
        if ((i & 2) != 0) {
            z = !collectionMembershipModel.isChecked();
        }
        collectionMembershipsViewModel.updateCollectionMembershipModel(collectionMembershipModel, z);
    }

    public final void updateCollectionMembershipModel(CollectionMembershipModel collectionMembershipModel, boolean isChecked) {
        Intrinsics.checkNotNullParameter(collectionMembershipModel, "collectionMembershipModel");
        List<CollectionMembershipModel> value = this._collectionMembershipsLiveData.getValue();
        Integer numValueOf = value != null ? Integer.valueOf(value.indexOf(collectionMembershipModel)) : null;
        if (numValueOf != null && numValueOf.intValue() == -1) {
            value.add(new CollectionMembershipModel(collectionMembershipModel.getCollectionModel(), isChecked));
        } else if (numValueOf != null) {
            value.set(numValueOf.intValue(), new CollectionMembershipModel(collectionMembershipModel.getCollectionModel(), isChecked));
        }
        this._collectionMembershipsLiveData.postValue(value);
    }

    public final void updateCollectionMemberships() {
        List<CollectionMembershipModel> value = this._collectionMembershipsLiveData.getValue();
        if (value != null) {
            ArrayList arrayList = new ArrayList();
            for (Object obj : value) {
                if (((CollectionMembershipModel) obj).isChecked()) {
                    arrayList.add(obj);
                }
            }
            ArrayList arrayList2 = arrayList;
            ArrayList arrayList3 = new ArrayList(CollectionsKt.collectionSizeOrDefault(arrayList2, 10));
            Iterator it = arrayList2.iterator();
            while (it.hasNext()) {
                arrayList3.add(((CollectionMembershipModel) it.next()).getCollectionModel());
            }
            ArrayList arrayList4 = arrayList3;
            HashSet<CollectionModel> hashSet = this.initialCollectionMemberships;
            ArrayList arrayList5 = new ArrayList();
            for (Object obj2 : hashSet) {
                if (!arrayList4.contains((CollectionModel) obj2)) {
                    arrayList5.add(obj2);
                }
            }
            ArrayList arrayList6 = arrayList5;
            ArrayList arrayList7 = new ArrayList(CollectionsKt.collectionSizeOrDefault(arrayList6, 10));
            Iterator it2 = arrayList6.iterator();
            while (it2.hasNext()) {
                arrayList7.add(((CollectionModel) it2.next()).getId());
            }
            ArrayList arrayList8 = arrayList7;
            if (!arrayList8.isEmpty()) {
                BuildersKt__Builders_commonKt.launch$default(this, null, null, new CollectionMembershipsViewModel$updateCollectionMemberships$3$1(this, arrayList8, null), 3, null);
            }
            ArrayList arrayList9 = new ArrayList();
            for (Object obj3 : arrayList4) {
                if (!this.initialCollectionMemberships.contains((CollectionModel) obj3)) {
                    arrayList9.add(obj3);
                }
            }
            ArrayList arrayList10 = arrayList9;
            ArrayList arrayList11 = new ArrayList(CollectionsKt.collectionSizeOrDefault(arrayList10, 10));
            Iterator it3 = arrayList10.iterator();
            while (it3.hasNext()) {
                arrayList11.add(((CollectionModel) it3.next()).getId());
            }
            ArrayList arrayList12 = arrayList11;
            if (arrayList12.isEmpty()) {
                return;
            }
            BuildersKt__Builders_commonKt.launch$default(this, null, null, new CollectionMembershipsViewModel$updateCollectionMemberships$6$1(this, arrayList12, null), 3, null);
        }
    }

    public final ErrorEvent addCollectionMembershipErrorHelper(DomainError error) {
        Intrinsics.checkNotNullParameter(error, "error");
        if (DomainErrorKt.isNetworkConnectionError(error)) {
            return new ErrorEvent.Toast(R.string.add_collection_membership_network_error, new String[0]);
        }
        if (error instanceof DomainError.APIResourceConflict) {
            return new ErrorEvent.Toast(R.string.add_collection_membership_duplicate_error, new String[0]);
        }
        return new ErrorEvent.Toast(R.string.add_collection_membership_generic_error, new String[0]);
    }

    public final ErrorEvent createCollectionErrorHelper(DomainError error, String newCollectionName) {
        Intrinsics.checkNotNullParameter(error, "error");
        Intrinsics.checkNotNullParameter(newCollectionName, "newCollectionName");
        if (error instanceof CollectionsDomainError.CollectionNameConflict) {
            return new ErrorEvent.Toast(R.string.create_collection_collection_name_conflict_error, newCollectionName);
        }
        if (error instanceof CollectionsDomainError.CollectionNameMalformed) {
            return new ErrorEvent.Toast(R.string.create_collection_malformed_name, new String[0]);
        }
        if (DomainErrorKt.isNetworkConnectionError(error)) {
            return new ErrorEvent.Toast(R.string.create_collection_network_error, new String[0]);
        }
        return new ErrorEvent.Toast(R.string.create_collection_generic_error, new String[0]);
    }

    public final void createAndAddSelected(String newCollectionName) {
        Intrinsics.checkNotNullParameter(newCollectionName, "newCollectionName");
        Result<CollectionModel, DomainError> resultCreateCollection = this.createCollectionInteractor.createCollection(newCollectionName, CollectionType.PERSONAL);
        boolean z = resultCreateCollection instanceof Result.Success;
        if (z) {
            updateCollectionMembershipModel(new CollectionMembershipModel((CollectionModel) ((Result.Success) resultCreateCollection).getValue(), true), true);
            EditTextDialogFragment.Companion.logEvent$default(EditTextDialogFragment.INSTANCE, null, BoxAnalyticsParams.EVENT_CREATE_COLLECTION_CTA_TRIGGERED, 1, null);
        } else if (!(resultCreateCollection instanceof Result.Error)) {
            throw new NoWhenBranchMatchedException();
        }
        if (!z) {
            if (!(resultCreateCollection instanceof Result.Error)) {
                throw new NoWhenBranchMatchedException();
            }
            DomainError domainError = (DomainError) ((Result.Error) resultCreateCollection).getValue();
            this._errorLiveData.postValue(createCollectionErrorHelper(domainError, newCollectionName));
            EditTextDialogFragment.INSTANCE.logEvent(BoxAnalyticsParams.INSTANCE.getCreateCollectionError(domainError), BoxAnalyticsParams.EVENT_CREATE_COLLECTION_CTA_TRIGGERED);
        }
        updateCollectionMemberships();
    }
}
