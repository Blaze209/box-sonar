package com.box.android.collections.presentation.fragments;

import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.util.Log;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.lifecycle.HasDefaultViewModelProviderFactory;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStore;
import androidx.lifecycle.ViewModelStoreOwner;
import androidx.lifecycle.viewmodel.CreationExtras;
import androidx.recyclerview.widget.RecyclerView;
import com.box.android.base.cpl.ICollectionsHelper;
import com.box.android.base.databinding.FragmentItemListingBinding;
import com.box.android.base.presentation.ThumbnailManager;
import com.box.android.base.presentation.activities.BoxFragmentActivity;
import com.box.android.base.presentation.fragments.BaseListingAbstractFragment;
import com.box.android.base.presentation.fragments.models.BottomSheetAttributes;
import com.box.android.base.presentation.presenters.BaseListingPresenter;
import com.box.android.base.presentation.utilities.IItemActionHandler;
import com.box.android.base.presentation.utilities.ItemActionHandlerProvider;
import com.box.android.base.presentation.utilities.ItemActionListener;
import com.box.android.collections.R;
import com.box.android.collections.presentation.CollectionItemsPresenter;
import com.box.android.collections.presentation.adapter.CollectionItemsAdapter;
import com.box.android.collections.presentation.viewmodel.CollectionItemsViewModel;
import com.box.android.common.utilities.IntentConstants;
import com.box.android.common.utilities.ViewModelAssistedFactory;
import com.box.android.coreservices.jobmanager.jobcollections.OfflineBoxJobCollection;
import com.box.android.coreservices.jobmanager.jobs.BoxItemJob;
import com.box.android.coreservices.modelcontroller.messages.BoxMessage;
import com.box.android.domain.analytics.BoxAnalyticsParams;
import com.box.android.domain.configuration.FeatureFlips;
import com.box.android.domain.identity.IUserContextManager;
import com.box.android.domain.models.item.ItemModel;
import dagger.hilt.android.AndroidEntryPoint;
import dagger.hilt.android.lifecycle.HiltViewModelExtensions;
import java.util.List;
import javax.inject.Inject;
import kotlin.Deprecated;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;

/* JADX INFO: compiled from: CollectionItemsFragment.kt */
/* JADX INFO: loaded from: classes10.dex */
@Metadata(d1 = {"\u0000\u0094\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u0007¢\u0006\u0004\b\u0004\u0010\u0005J\u0012\u00102\u001a\u0002032\b\u00104\u001a\u0004\u0018\u000105H\u0016J\u0010\u00106\u001a\u0002032\u0006\u00107\u001a\u000208H\u0016J\u0012\u00109\u001a\u0002032\b\u00104\u001a\u0004\u0018\u000105H\u0017J\f\u0010:\u001a\u0006\u0012\u0002\b\u00030;H\u0014J\u0012\u0010<\u001a\u00020\u00072\b\u00107\u001a\u0004\u0018\u000108H\u0016J\b\u0010=\u001a\u000203H\u0016J\b\u0010>\u001a\u00020?H\u0016J\b\u0010@\u001a\u00020\u0007H\u0016J\b\u0010A\u001a\u00020\u0007H\u0016J\b\u0010B\u001a\u00020CH\u0016J \u0010D\u001a\u001a\u0012\u0004\u0012\u00020\u0002\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u00010EH\u0014JP\u0010F\u001a\u0002032\u0016\u0010G\u001a\u0012\u0012\u0004\u0012\u00020C\u0012\u0004\u0012\u0002030Hj\u0002`I2\u0016\u0010J\u001a\u0012\u0012\u0004\u0012\u00020C\u0012\u0004\u0012\u0002030Hj\u0002`I2\u0016\u0010K\u001a\u0012\u0012\u0004\u0012\u00020C\u0012\u0004\u0012\u0002030Hj\u0002`IH\u0016J\u0016\u0010L\u001a\u00020?2\f\u0010M\u001a\b\u0012\u0002\b\u0003\u0018\u00010NH\u0017J\u000e\u0010O\u001a\u0002032\u0006\u0010P\u001a\u00020\u0002R\u001c\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u0014\u0010\f\u001a\u00020\u00078BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\r\u0010\tR\u001e\u0010\u000e\u001a\u00020\u000f8\u0006@\u0006X\u0087.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u001e\u0010\u0014\u001a\u00020\u00158\u0006@\u0006X\u0087.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R\u001e\u0010\u001a\u001a\u00020\u001b8\u0006@\u0006X\u0087.¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001fR\u001e\u0010 \u001a\u00020!8\u0006@\u0006X\u0087.¢\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010#\"\u0004\b$\u0010%R\u001a\u0010&\u001a\u00020'X\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\b(\u0010)\"\u0004\b*\u0010+R\u001b\u0010,\u001a\u00020-8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b0\u00101\u001a\u0004\b.\u0010/¨\u0006Q"}, d2 = {"Lcom/box/android/collections/presentation/fragments/CollectionItemsFragment;", "Lcom/box/android/base/presentation/fragments/BaseListingAbstractFragment;", "Lcom/box/android/domain/models/item/ItemModel;", "Lcom/box/android/base/databinding/FragmentItemListingBinding;", "<init>", "()V", "collectionName", "", "getCollectionName", "()Ljava/lang/String;", "setCollectionName", "(Ljava/lang/String;)V", BoxItemJob.COLLECTION_ID, "getCollectionId", "userContextManager", "Lcom/box/android/domain/identity/IUserContextManager;", "getUserContextManager", "()Lcom/box/android/domain/identity/IUserContextManager;", "setUserContextManager", "(Lcom/box/android/domain/identity/IUserContextManager;)V", "thumbnailManager", "Lcom/box/android/base/presentation/ThumbnailManager;", "getThumbnailManager", "()Lcom/box/android/base/presentation/ThumbnailManager;", "setThumbnailManager", "(Lcom/box/android/base/presentation/ThumbnailManager;)V", "featureFlips", "Lcom/box/android/domain/configuration/FeatureFlips;", "getFeatureFlips", "()Lcom/box/android/domain/configuration/FeatureFlips;", "setFeatureFlips", "(Lcom/box/android/domain/configuration/FeatureFlips;)V", "collectionsHelper", "Lcom/box/android/base/cpl/ICollectionsHelper;", "getCollectionsHelper", "()Lcom/box/android/base/cpl/ICollectionsHelper;", "setCollectionsHelper", "(Lcom/box/android/base/cpl/ICollectionsHelper;)V", "itemActionHandler", "Lcom/box/android/base/presentation/utilities/IItemActionHandler;", "getItemActionHandler", "()Lcom/box/android/base/presentation/utilities/IItemActionHandler;", "setItemActionHandler", "(Lcom/box/android/base/presentation/utilities/IItemActionHandler;)V", "viewModel", "Lcom/box/android/collections/presentation/viewmodel/CollectionItemsViewModel;", "getViewModel", "()Lcom/box/android/collections/presentation/viewmodel/CollectionItemsViewModel;", "viewModel$delegate", "Lkotlin/Lazy;", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "onAttach", "context", "Landroid/content/Context;", "onActivityCreated", "createAdapter", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "getTitle", "onAddFabClicked", "isAddFabAvailable", "", "getAmplitudePageName", "getGenericId", "getType", "", "createPresenter", "Lcom/box/android/base/presentation/presenters/BaseListingPresenter;", "setupEmptyView", "emptyImageSetter", "Lkotlin/Function1;", "Lcom/box/android/base/presentation/fragments/ResourceSetter;", "emptyTextSetter", "emptySubtextSetter", "shouldUpdateFragment", "message", "Lcom/box/android/coreservices/modelcontroller/messages/BoxMessage;", "updateItem", "item", "collections_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
@AndroidEntryPoint
public final class CollectionItemsFragment extends Hilt_CollectionItemsFragment<ItemModel, FragmentItemListingBinding> {
    public static final int $stable = 8;
    private String collectionName;

    @Inject
    public ICollectionsHelper collectionsHelper;

    @Inject
    public FeatureFlips featureFlips;
    public IItemActionHandler itemActionHandler;

    @Inject
    public ThumbnailManager thumbnailManager;

    @Inject
    public IUserContextManager userContextManager;

    /* JADX INFO: renamed from: viewModel$delegate, reason: from kotlin metadata */
    private final Lazy viewModel;

    @Override // com.box.android.base.presentation.BoxFragmentInterface
    public int getType() {
        return 26;
    }

    @Override // com.box.android.base.presentation.utilities.AddFabHelper
    public boolean isAddFabAvailable() {
        return false;
    }

    public CollectionItemsFragment() {
        final CollectionItemsFragment collectionItemsFragment = this;
        final Function0<CreationExtras> function0 = new Function0<CreationExtras>() { // from class: com.box.android.collections.presentation.fragments.CollectionItemsFragment$special$$inlined$viewModelsWithArgs$1
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final CreationExtras invoke() {
                CreationExtras defaultViewModelCreationExtras = collectionItemsFragment.getDefaultViewModelCreationExtras();
                Intrinsics.checkNotNullExpressionValue(defaultViewModelCreationExtras, "<get-defaultViewModelCreationExtras>(...)");
                final CollectionItemsFragment collectionItemsFragment2 = this;
                return HiltViewModelExtensions.withCreationCallback(defaultViewModelCreationExtras, new Function1<ViewModelAssistedFactory<CollectionItemsViewModel>, ViewModel>() { // from class: com.box.android.collections.presentation.fragments.CollectionItemsFragment$special$$inlined$viewModelsWithArgs$1.1
                    @Override // kotlin.jvm.functions.Function1
                    public final ViewModel invoke(ViewModelAssistedFactory<CollectionItemsViewModel> factory) {
                        Intrinsics.checkNotNullParameter(factory, "factory");
                        Bundle bundle = new Bundle();
                        bundle.putString(CollectionItemsViewModel.VM_COLLECTION_ID_KEY, collectionItemsFragment2.getCollectionId());
                        return factory.create(bundle);
                    }
                });
            }
        };
        final Function0<Fragment> function1 = new Function0<Fragment>() { // from class: com.box.android.collections.presentation.fragments.CollectionItemsFragment$special$$inlined$viewModelsWithArgs$2
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final Fragment invoke() {
                return collectionItemsFragment;
            }
        };
        final Lazy lazy = LazyKt.lazy(LazyThreadSafetyMode.NONE, (Function0) new Function0<ViewModelStoreOwner>() { // from class: com.box.android.collections.presentation.fragments.CollectionItemsFragment$special$$inlined$viewModelsWithArgs$3
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ViewModelStoreOwner invoke() {
                return (ViewModelStoreOwner) function1.invoke();
            }
        });
        this.viewModel = FragmentViewModelLazyKt.createViewModelLazy(collectionItemsFragment, Reflection.getOrCreateKotlinClass(CollectionItemsViewModel.class), new Function0<ViewModelStore>() { // from class: com.box.android.collections.presentation.fragments.CollectionItemsFragment$special$$inlined$viewModelsWithArgs$4
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ViewModelStore invoke() {
                return FragmentViewModelLazyKt.m10254viewModels$lambda1(lazy).getViewModelStore();
            }
        }, new Function0<CreationExtras>() { // from class: com.box.android.collections.presentation.fragments.CollectionItemsFragment$special$$inlined$viewModelsWithArgs$5
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final CreationExtras invoke() {
                CreationExtras creationExtras;
                Function0 function2 = function0;
                if (function2 != null && (creationExtras = (CreationExtras) function2.invoke()) != null) {
                    return creationExtras;
                }
                ViewModelStoreOwner viewModelStoreOwnerM10254viewModels$lambda1 = FragmentViewModelLazyKt.m10254viewModels$lambda1(lazy);
                HasDefaultViewModelProviderFactory hasDefaultViewModelProviderFactory = viewModelStoreOwnerM10254viewModels$lambda1 instanceof HasDefaultViewModelProviderFactory ? (HasDefaultViewModelProviderFactory) viewModelStoreOwnerM10254viewModels$lambda1 : null;
                return hasDefaultViewModelProviderFactory != null ? hasDefaultViewModelProviderFactory.getDefaultViewModelCreationExtras() : CreationExtras.Empty.INSTANCE;
            }
        }, new Function0<ViewModelProvider.Factory>() { // from class: com.box.android.collections.presentation.fragments.CollectionItemsFragment$special$$inlined$viewModelsWithArgs$6
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ViewModelProvider.Factory invoke() {
                ViewModelProvider.Factory defaultViewModelProviderFactory;
                ViewModelStoreOwner viewModelStoreOwnerM10254viewModels$lambda1 = FragmentViewModelLazyKt.m10254viewModels$lambda1(lazy);
                HasDefaultViewModelProviderFactory hasDefaultViewModelProviderFactory = viewModelStoreOwnerM10254viewModels$lambda1 instanceof HasDefaultViewModelProviderFactory ? (HasDefaultViewModelProviderFactory) viewModelStoreOwnerM10254viewModels$lambda1 : null;
                return (hasDefaultViewModelProviderFactory == null || (defaultViewModelProviderFactory = hasDefaultViewModelProviderFactory.getDefaultViewModelProviderFactory()) == null) ? collectionItemsFragment.getDefaultViewModelProviderFactory() : defaultViewModelProviderFactory;
            }
        });
    }

    public final String getCollectionName() {
        return this.collectionName;
    }

    public final void setCollectionName(String str) {
        this.collectionName = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final String getCollectionId() {
        Bundle arguments = getArguments();
        String string = arguments != null ? arguments.getString(IntentConstants.EXTRA_INIT_COLLECTION_ID) : null;
        Intrinsics.checkNotNull(string);
        return string;
    }

    public final IUserContextManager getUserContextManager() {
        IUserContextManager iUserContextManager = this.userContextManager;
        if (iUserContextManager != null) {
            return iUserContextManager;
        }
        Intrinsics.throwUninitializedPropertyAccessException("userContextManager");
        return null;
    }

    public final void setUserContextManager(IUserContextManager iUserContextManager) {
        Intrinsics.checkNotNullParameter(iUserContextManager, "<set-?>");
        this.userContextManager = iUserContextManager;
    }

    public final ThumbnailManager getThumbnailManager() {
        ThumbnailManager thumbnailManager = this.thumbnailManager;
        if (thumbnailManager != null) {
            return thumbnailManager;
        }
        Intrinsics.throwUninitializedPropertyAccessException("thumbnailManager");
        return null;
    }

    public final void setThumbnailManager(ThumbnailManager thumbnailManager) {
        Intrinsics.checkNotNullParameter(thumbnailManager, "<set-?>");
        this.thumbnailManager = thumbnailManager;
    }

    public final FeatureFlips getFeatureFlips() {
        FeatureFlips featureFlips = this.featureFlips;
        if (featureFlips != null) {
            return featureFlips;
        }
        Intrinsics.throwUninitializedPropertyAccessException("featureFlips");
        return null;
    }

    public final void setFeatureFlips(FeatureFlips featureFlips) {
        Intrinsics.checkNotNullParameter(featureFlips, "<set-?>");
        this.featureFlips = featureFlips;
    }

    public final ICollectionsHelper getCollectionsHelper() {
        ICollectionsHelper iCollectionsHelper = this.collectionsHelper;
        if (iCollectionsHelper != null) {
            return iCollectionsHelper;
        }
        Intrinsics.throwUninitializedPropertyAccessException("collectionsHelper");
        return null;
    }

    public final void setCollectionsHelper(ICollectionsHelper iCollectionsHelper) {
        Intrinsics.checkNotNullParameter(iCollectionsHelper, "<set-?>");
        this.collectionsHelper = iCollectionsHelper;
    }

    public final IItemActionHandler getItemActionHandler() {
        IItemActionHandler iItemActionHandler = this.itemActionHandler;
        if (iItemActionHandler != null) {
            return iItemActionHandler;
        }
        Intrinsics.throwUninitializedPropertyAccessException("itemActionHandler");
        return null;
    }

    public final void setItemActionHandler(IItemActionHandler iItemActionHandler) {
        Intrinsics.checkNotNullParameter(iItemActionHandler, "<set-?>");
        this.itemActionHandler = iItemActionHandler;
    }

    private final CollectionItemsViewModel getViewModel() {
        return (CollectionItemsViewModel) this.viewModel.getValue();
    }

    @Override // androidx.fragment.app.Fragment
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Bundle arguments = getArguments();
        this.collectionName = arguments != null ? arguments.getString(IntentConstants.EXTRA_ITEM_NAME) : null;
        setHasOptionsMenu(true);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.box.android.collections.presentation.fragments.Hilt_CollectionItemsFragment, androidx.fragment.app.Fragment
    public void onAttach(Context context) {
        IItemActionHandler iItemActionHandlerProvideItemActionHandler;
        Intrinsics.checkNotNullParameter(context, "context");
        super.onAttach(context);
        ItemActionHandlerProvider itemActionHandlerProvider = context instanceof ItemActionHandlerProvider ? (ItemActionHandlerProvider) context : null;
        if (itemActionHandlerProvider == null || (iItemActionHandlerProvideItemActionHandler = itemActionHandlerProvider.provideItemActionHandler()) == null) {
            throw new IllegalStateException(context + " must implement ItemActionHandlerProvider");
        }
        setItemActionHandler(iItemActionHandlerProvideItemActionHandler);
    }

    @Override // androidx.fragment.app.Fragment
    @Deprecated(message = "Deprecated in Java")
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        FragmentActivity activity = getActivity();
        Intrinsics.checkNotNull(activity, "null cannot be cast to non-null type com.box.android.base.presentation.activities.BoxFragmentActivity");
        ((BoxFragmentActivity) activity).amplitudeSetCurrentPage();
    }

    @Override // com.box.android.base.presentation.fragments.BaseListingAbstractFragment
    protected RecyclerView.Adapter<?> createAdapter() {
        Context contextRequireContext = requireContext();
        Intrinsics.checkNotNullExpressionValue(contextRequireContext, "requireContext(...)");
        return new CollectionItemsAdapter(contextRequireContext, new ItemActionListener<ItemModel>() { // from class: com.box.android.collections.presentation.fragments.CollectionItemsFragment.createAdapter.1
            @Override // com.box.android.base.presentation.utilities.ItemActionListener
            public /* bridge */ boolean onLongClick(ItemModel itemModel) {
                return super.onLongClick(itemModel);
            }

            @Override // com.box.android.base.presentation.utilities.ItemActionListener
            public void onPrimaryAction(ItemModel item) {
                Intrinsics.checkNotNullParameter(item, "item");
                CollectionItemsFragment.this.getCollectionsHelper().onItemClickOnCPL(CollectionItemsFragment.this.getArguments(), item);
            }

            @Override // com.box.android.base.presentation.utilities.ItemActionListener
            public void onSecondaryAction(ItemModel item) {
                Intrinsics.checkNotNullParameter(item, "item");
                IItemActionHandler itemActionHandler = CollectionItemsFragment.this.getItemActionHandler();
                CollectionItemsFragment collectionItemsFragment = CollectionItemsFragment.this;
                IItemActionHandler.showBottomSheet$default(itemActionHandler, item, new BottomSheetAttributes.BottomSheetMenuType.RemoveCollectionItems(collectionItemsFragment.getTitle(collectionItemsFragment.requireContext()), CollectionItemsFragment.this.getCollectionId()), (BottomSheetAttributes.LaunchContext) null, (DialogInterface.OnShowListener) null, (List) null, 28, (Object) null);
            }
        }, getThumbnailManager(), getFeatureFlips(), getUserContextManager());
    }

    @Override // com.box.android.base.presentation.BoxFragmentInterface
    public String getTitle(Context context) {
        String str = this.collectionName;
        return str == null ? "" : str;
    }

    @Override // com.box.android.base.presentation.utilities.AddFabHelper
    public void onAddFabClicked() {
        Log.d(getClass().getName(), "FAB Clicked");
    }

    @Override // com.box.android.base.presentation.BoxFragmentInterface
    public String getAmplitudePageName() {
        return BoxAnalyticsParams.PAGE_NAME_COLLECTION_ITEMS;
    }

    @Override // com.box.android.base.presentation.BoxFragmentInterface
    public String getGenericId() {
        return getCollectionId();
    }

    @Override // com.box.android.base.presentation.fragments.BaseListingAbstractFragment
    protected BaseListingPresenter<ItemModel, BaseListingAbstractFragment<ItemModel, FragmentItemListingBinding>> createPresenter() {
        return new CollectionItemsPresenter(this, getViewModel());
    }

    @Override // com.box.android.base.presentation.fragments.BaseListingAbstractFragment
    public void setupEmptyView(Function1<? super Integer, Unit> emptyImageSetter, Function1<? super Integer, Unit> emptyTextSetter, Function1<? super Integer, Unit> emptySubtextSetter) {
        Intrinsics.checkNotNullParameter(emptyImageSetter, "emptyImageSetter");
        Intrinsics.checkNotNullParameter(emptyTextSetter, "emptyTextSetter");
        Intrinsics.checkNotNullParameter(emptySubtextSetter, "emptySubtextSetter");
        emptyImageSetter.invoke(Integer.valueOf(R.drawable.ic_collectionstar140));
        emptyTextSetter.invoke(Integer.valueOf(R.string.empty_collection_items_text));
        emptySubtextSetter.invoke(Integer.valueOf(R.string.empty_collection_items_subtext));
    }

    @Override // com.box.android.base.presentation.fragments.BaseListingAbstractFragment, com.box.android.base.presentation.BoxFragmentInterface
    @Deprecated(message = "Deprecated in Java")
    public boolean shouldUpdateFragment(BoxMessage<?> message) {
        Intrinsics.checkNotNull(message);
        if (!message.wasSuccessful()) {
            return false;
        }
        Intrinsics.areEqual(message.getAction(), OfflineBoxJobCollection.class.getName());
        return CollectionItemsFragmentKt.isOfflineSingleTaskMessage(message);
    }

    public final void updateItem(ItemModel item) {
        Intrinsics.checkNotNullParameter(item, "item");
        RecyclerView.Adapter<?> adapter = getAdapter();
        Intrinsics.checkNotNull(adapter, "null cannot be cast to non-null type com.box.android.collections.presentation.adapter.CollectionItemsAdapter");
        ((CollectionItemsAdapter) adapter).updateItem(item);
    }
}
