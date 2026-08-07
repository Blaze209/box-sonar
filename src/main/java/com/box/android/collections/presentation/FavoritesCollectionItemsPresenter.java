package com.box.android.collections.presentation;

import androidx.paging.PagedList;
import com.box.android.base.databinding.FragmentItemListingBinding;
import com.box.android.base.presentation.fragments.BaseListingAbstractFragment;
import com.box.android.base.presentation.presenters.BaseListingPresenter;
import com.box.android.base.vm.BaseListingViewModel;
import com.box.android.collections.presentation.fragments.FavoritesCollectionItemsFragment;
import com.box.android.collections.presentation.viewmodel.FavoritesCollectionItemsViewModel;
import com.box.android.common.utilities.ErrorEvent;
import com.box.android.common.utilities.SingleEventObserver;
import com.box.android.coreservices.modelcontroller.messages.BoxMessage;
import com.box.android.domain.analytics.BoxAnalyticsParams;
import com.box.android.domain.mappers.ItemModelMapper;
import com.box.android.domain.models.item.ItemModel;
import com.box.androidsdk.content.models.BoxItem;
import com.pspdfkit.BuildConfig;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: FavoritesCollectionItemsPresenter.kt */
/* JADX INFO: loaded from: classes10.dex */
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0007\u0018\u00002\u001a\u0012\u0004\u0012\u00020\u0002\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00040\u00030\u0001B\u0017\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b¢\u0006\u0004\b\t\u0010\nJ\b\u0010\u000b\u001a\u00020\fH\u0016J\u0014\u0010\r\u001a\u00020\f2\n\u0010\u000e\u001a\u0006\u0012\u0002\b\u00030\u000fH\u0016J\b\u0010\u0010\u001a\u00020\u0011H\u0016J\b\u0010\u0012\u001a\u00020\u0013H\u0014J\u0014\u0010\u0014\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00040\u0003H\u0014J\b\u0010\u0015\u001a\u00020\u0016H\u0014R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0017"}, d2 = {"Lcom/box/android/collections/presentation/FavoritesCollectionItemsPresenter;", "Lcom/box/android/base/presentation/presenters/BaseListingPresenter;", "Lcom/box/android/domain/models/item/ItemModel;", "Lcom/box/android/base/presentation/fragments/BaseListingAbstractFragment;", "Lcom/box/android/base/databinding/FragmentItemListingBinding;", BuildConfig.FLAVOR, "Lcom/box/android/collections/presentation/fragments/FavoritesCollectionItemsFragment;", "viewModel", "Lcom/box/android/collections/presentation/viewmodel/FavoritesCollectionItemsViewModel;", "<init>", "(Lcom/box/android/collections/presentation/fragments/FavoritesCollectionItemsFragment;Lcom/box/android/collections/presentation/viewmodel/FavoritesCollectionItemsViewModel;)V", "onViewCreate", "", "handleBroadcastMessage", "message", "Lcom/box/android/coreservices/modelcontroller/messages/BoxMessage;", "isContentAvailable", "", "getViewModel", "Lcom/box/android/base/vm/BaseListingViewModel;", "getFragment", "getRefreshEventName", "", "collections_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class FavoritesCollectionItemsPresenter extends BaseListingPresenter<ItemModel, BaseListingAbstractFragment<ItemModel, FragmentItemListingBinding>> {
    public static final int $stable = 8;
    private final FavoritesCollectionItemsFragment fragment;
    private final FavoritesCollectionItemsViewModel viewModel;

    public FavoritesCollectionItemsPresenter(FavoritesCollectionItemsFragment fragment, FavoritesCollectionItemsViewModel viewModel) {
        Intrinsics.checkNotNullParameter(fragment, "fragment");
        Intrinsics.checkNotNullParameter(viewModel, "viewModel");
        this.fragment = fragment;
        this.viewModel = viewModel;
    }

    @Override // com.box.android.base.presentation.presenters.BaseListingPresenter
    public void onViewCreate() {
        this.viewModel.getCollectionItemsLiveData().observe(this.fragment.getViewLifecycleOwner(), new FavoritesCollectionItemsPresenter$sam$androidx_lifecycle_Observer$0(new Function1() { // from class: com.box.android.collections.presentation.FavoritesCollectionItemsPresenter$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return FavoritesCollectionItemsPresenter.onViewCreate$lambda$0(this.f$0, (PagedList) obj);
            }
        }));
        this.viewModel.getCollectionId().observe(this.fragment.getViewLifecycleOwner(), new FavoritesCollectionItemsPresenter$sam$androidx_lifecycle_Observer$0(new Function1() { // from class: com.box.android.collections.presentation.FavoritesCollectionItemsPresenter$$ExternalSyntheticLambda1
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return FavoritesCollectionItemsPresenter.onViewCreate$lambda$1(this.f$0, (String) obj);
            }
        }));
        this.viewModel.getErrorLiveData().observe(this.fragment.getViewLifecycleOwner(), new SingleEventObserver(new Function1() { // from class: com.box.android.collections.presentation.FavoritesCollectionItemsPresenter$$ExternalSyntheticLambda2
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return FavoritesCollectionItemsPresenter.onViewCreate$lambda$2(this.f$0, (ErrorEvent) obj);
            }
        }));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit onViewCreate$lambda$0(FavoritesCollectionItemsPresenter favoritesCollectionItemsPresenter, PagedList pagedList) {
        BaseListingPresenter.BoxItemsView<ItemModel> boxItemsView;
        if (pagedList != null && (boxItemsView = favoritesCollectionItemsPresenter.getBoxItemsView()) != null) {
            boxItemsView.renderNewList(pagedList);
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit onViewCreate$lambda$1(FavoritesCollectionItemsPresenter favoritesCollectionItemsPresenter, String str) {
        favoritesCollectionItemsPresenter.fragment.setCollectionId(str);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit onViewCreate$lambda$2(FavoritesCollectionItemsPresenter favoritesCollectionItemsPresenter, ErrorEvent errorEvent) {
        FavoritesCollectionItemsFragment favoritesCollectionItemsFragment = favoritesCollectionItemsPresenter.fragment;
        Intrinsics.checkNotNull(errorEvent);
        favoritesCollectionItemsFragment.handleError(errorEvent);
        return Unit.INSTANCE;
    }

    @Override // com.box.android.base.presentation.presenters.BaseListingPresenter
    public void handleBroadcastMessage(BoxMessage<?> message) {
        ItemModel itemModel;
        Intrinsics.checkNotNullParameter(message, "message");
        if (message.wasSuccessful()) {
            Object payload = message.getPayload();
            BoxItem boxItem = payload instanceof BoxItem ? (BoxItem) payload : null;
            if (boxItem == null || (itemModel = ItemModelMapper.INSTANCE.toItemModel(boxItem)) == null) {
                return;
            }
            this.fragment.updateItem(itemModel);
        }
    }

    @Override // com.box.android.base.presentation.presenters.BaseListingPresenter
    public boolean isContentAvailable() {
        PagedList<ItemModel> value = this.viewModel.getCollectionItemsLiveData().getValue();
        return (value != null ? value.size() : 0) != 0 || this.viewModel.getInitialFetchCompleted();
    }

    @Override // com.box.android.base.presentation.presenters.BaseListingPresenter
    protected BaseListingViewModel getViewModel() {
        return this.viewModel;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.box.android.base.presentation.presenters.BaseListingPresenter
    public BaseListingAbstractFragment<ItemModel, FragmentItemListingBinding> getFragment() {
        return this.fragment;
    }

    @Override // com.box.android.base.presentation.presenters.BaseListingPresenter
    protected String getRefreshEventName() {
        return BoxAnalyticsParams.EVENT_FAVORITES_COLLECTION_ITEMS_RETURNED;
    }
}
