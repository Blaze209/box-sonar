package com.box.android.collections.presentation;

import androidx.paging.PagedList;
import com.box.android.base.databinding.FragmentItemListingBinding;
import com.box.android.base.presentation.fragments.BaseListingAbstractFragment;
import com.box.android.base.presentation.presenters.BaseListingPresenter;
import com.box.android.base.vm.BaseListingViewModel;
import com.box.android.collections.presentation.fragments.MyCollectionsFragment;
import com.box.android.collections.presentation.viewmodel.MyCollectionsViewModel;
import com.box.android.common.utilities.ErrorEvent;
import com.box.android.common.utilities.SingleEventObserver;
import com.box.android.domain.analytics.BoxAnalyticsParams;
import com.box.android.domain.models.CollectionModel;
import com.pspdfkit.BuildConfig;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: MyCollectionsPresenter.kt */
/* JADX INFO: loaded from: classes10.dex */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u00002\u001a\u0012\u0004\u0012\u00020\u0002\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00040\u00030\u0001B\u0017\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b¢\u0006\u0004\b\t\u0010\nJ\b\u0010\u000b\u001a\u00020\fH\u0016J\b\u0010\r\u001a\u00020\u000eH\u0016J\u000e\u0010\u000f\u001a\u00020\f2\u0006\u0010\u0010\u001a\u00020\u0011J\b\u0010\u0012\u001a\u00020\u0013H\u0014J\u0014\u0010\u0014\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00040\u0003H\u0014J\b\u0010\u0015\u001a\u00020\u0011H\u0014R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0016"}, d2 = {"Lcom/box/android/collections/presentation/MyCollectionsPresenter;", "Lcom/box/android/base/presentation/presenters/BaseListingPresenter;", "Lcom/box/android/domain/models/CollectionModel;", "Lcom/box/android/base/presentation/fragments/BaseListingAbstractFragment;", "Lcom/box/android/base/databinding/FragmentItemListingBinding;", BuildConfig.FLAVOR, "Lcom/box/android/collections/presentation/fragments/MyCollectionsFragment;", "viewModel", "Lcom/box/android/collections/presentation/viewmodel/MyCollectionsViewModel;", "<init>", "(Lcom/box/android/collections/presentation/fragments/MyCollectionsFragment;Lcom/box/android/collections/presentation/viewmodel/MyCollectionsViewModel;)V", "onViewCreate", "", "isContentAvailable", "", "createCollection", "newCollectionName", "", "getViewModel", "Lcom/box/android/base/vm/BaseListingViewModel;", "getFragment", "getRefreshEventName", "collections_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class MyCollectionsPresenter extends BaseListingPresenter<CollectionModel, BaseListingAbstractFragment<CollectionModel, FragmentItemListingBinding>> {
    public static final int $stable = 8;
    private final MyCollectionsFragment fragment;
    private final MyCollectionsViewModel viewModel;

    public MyCollectionsPresenter(MyCollectionsFragment fragment, MyCollectionsViewModel viewModel) {
        Intrinsics.checkNotNullParameter(fragment, "fragment");
        Intrinsics.checkNotNullParameter(viewModel, "viewModel");
        this.fragment = fragment;
        this.viewModel = viewModel;
    }

    @Override // com.box.android.base.presentation.presenters.BaseListingPresenter
    public void onViewCreate() {
        this.viewModel.getCollectionsLiveData().observe(this.fragment.getViewLifecycleOwner(), new MyCollectionsPresenter$sam$androidx_lifecycle_Observer$0(new Function1() { // from class: com.box.android.collections.presentation.MyCollectionsPresenter$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return MyCollectionsPresenter.onViewCreate$lambda$0(this.f$0, (PagedList) obj);
            }
        }));
        this.viewModel.getErrorLiveData().observe(this.fragment.getViewLifecycleOwner(), new SingleEventObserver(new Function1() { // from class: com.box.android.collections.presentation.MyCollectionsPresenter$$ExternalSyntheticLambda1
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return MyCollectionsPresenter.onViewCreate$lambda$1(this.f$0, (ErrorEvent) obj);
            }
        }));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit onViewCreate$lambda$0(MyCollectionsPresenter myCollectionsPresenter, PagedList pagedList) {
        BaseListingPresenter.BoxItemsView<CollectionModel> boxItemsView = myCollectionsPresenter.getBoxItemsView();
        if (boxItemsView != null) {
            Intrinsics.checkNotNull(pagedList);
            boxItemsView.renderNewList(pagedList);
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit onViewCreate$lambda$1(MyCollectionsPresenter myCollectionsPresenter, ErrorEvent errorEvent) {
        MyCollectionsFragment myCollectionsFragment = myCollectionsPresenter.fragment;
        Intrinsics.checkNotNull(errorEvent);
        myCollectionsFragment.handleError(errorEvent);
        return Unit.INSTANCE;
    }

    @Override // com.box.android.base.presentation.presenters.BaseListingPresenter
    public boolean isContentAvailable() {
        return this.viewModel.getCollectionsLiveData().getValue() != null;
    }

    public final void createCollection(String newCollectionName) {
        Intrinsics.checkNotNullParameter(newCollectionName, "newCollectionName");
        this.viewModel.createCollection(newCollectionName);
    }

    @Override // com.box.android.base.presentation.presenters.BaseListingPresenter
    protected BaseListingViewModel getViewModel() {
        return this.viewModel;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.box.android.base.presentation.presenters.BaseListingPresenter
    public BaseListingAbstractFragment<CollectionModel, FragmentItemListingBinding> getFragment() {
        return this.fragment;
    }

    @Override // com.box.android.base.presentation.presenters.BaseListingPresenter
    protected String getRefreshEventName() {
        return BoxAnalyticsParams.EVENT_MY_COLLECTIONS_RETURNED;
    }
}
