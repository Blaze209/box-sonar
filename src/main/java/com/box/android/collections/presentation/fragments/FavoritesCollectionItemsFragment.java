package com.box.android.collections.presentation.fragments;

import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.util.Log;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.lifecycle.HasDefaultViewModelProviderFactory;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStore;
import androidx.lifecycle.ViewModelStoreOwner;
import androidx.lifecycle.viewmodel.CreationExtras;
import androidx.recyclerview.widget.RecyclerView;
import com.box.android.base.databinding.FragmentItemListingBinding;
import com.box.android.base.presentation.TabVisibility;
import com.box.android.base.presentation.ThumbnailManager;
import com.box.android.base.presentation.fragments.BaseListingAbstractFragment;
import com.box.android.base.presentation.fragments.models.BottomSheetAttributes;
import com.box.android.base.presentation.presenters.BaseListingPresenter;
import com.box.android.base.presentation.utilities.IItemActionHandler;
import com.box.android.base.presentation.utilities.ItemActionHandlerProvider;
import com.box.android.base.presentation.utilities.ItemActionListener;
import com.box.android.collections.R;
import com.box.android.collections.presentation.FavoritesCollectionItemsPresenter;
import com.box.android.collections.presentation.adapter.CollectionItemsAdapter;
import com.box.android.collections.presentation.viewmodel.FavoritesCollectionItemsViewModel;
import com.box.android.common.utilities.CommonBoxUtil;
import com.box.android.common.utilities.IntentConstants;
import com.box.android.coreservices.jobmanager.jobcollections.OfflineBoxJobCollection;
import com.box.android.coreservices.jobmanager.jobs.BoxItemJob;
import com.box.android.coreservices.modelcontroller.messages.BoxMessage;
import com.box.android.domain.analytics.BoxAmplitudeAnalytics;
import com.box.android.domain.analytics.BoxAnalyticsParams;
import com.box.android.domain.configuration.FeatureFlips;
import com.box.android.domain.identity.IUserContextManager;
import com.box.android.domain.models.item.ItemModel;
import com.box.android.domain.models.preview.PreviewSource;
import dagger.hilt.android.AndroidEntryPoint;
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
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;

/* JADX INFO: compiled from: FavoritesCollectionItemsFragment.kt */
/* JADX INFO: loaded from: classes10.dex */
@Metadata(d1 = {"\u0000¢\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0007\u0018\u0000 W2\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u00012\u00020\u0004:\u0001WB\u0007¢\u0006\u0004\b\u0005\u0010\u0006J\u0010\u00109\u001a\u00020 2\u0006\u0010:\u001a\u00020;H\u0016J\f\u0010<\u001a\u0006\u0012\u0002\b\u00030=H\u0014J\u0010\u0010>\u001a\u00020 2\u0006\u0010?\u001a\u00020@H\u0016J\u0012\u0010A\u001a\u00020.2\b\u0010:\u001a\u0004\u0018\u00010;H\u0016J\b\u0010B\u001a\u00020.H\u0016J\n\u0010C\u001a\u0004\u0018\u00010.H\u0016J\b\u0010D\u001a\u00020EH\u0016J\u0016\u0010F\u001a\u00020 2\f\u0010G\u001a\b\u0012\u0004\u0012\u00020\u00020HH\u0016J \u0010I\u001a\u001a\u0012\u0004\u0012\u00020\u0002\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u00010JH\u0014JP\u0010K\u001a\u00020 2\u0016\u0010L\u001a\u0012\u0012\u0004\u0012\u00020E\u0012\u0004\u0012\u00020 0\u001cj\u0002`M2\u0016\u0010N\u001a\u0012\u0012\u0004\u0012\u00020E\u0012\u0004\u0012\u00020 0\u001cj\u0002`M2\u0016\u0010O\u001a\u0012\u0012\u0004\u0012\u00020E\u0012\u0004\u0012\u00020 0\u001cj\u0002`MH\u0016J\b\u0010P\u001a\u00020 H\u0016J\b\u0010Q\u001a\u00020@H\u0016J\u0016\u0010R\u001a\u00020@2\f\u0010S\u001a\b\u0012\u0002\b\u0003\u0018\u00010TH\u0017J\u000e\u0010U\u001a\u00020 2\u0006\u0010V\u001a\u00020\u0002R\u001e\u0010\u0007\u001a\u00020\b8\u0006@\u0006X\u0087.¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u001e\u0010\r\u001a\u00020\u000e8\u0006@\u0006X\u0087.¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u001e\u0010\u0013\u001a\u00020\u00148\u0006@\u0006X\u0087.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\u0010\u0010\u0019\u001a\u0004\u0018\u00010\u001aX\u0082\u000e¢\u0006\u0002\n\u0000R7\u0010\u001b\u001a\u001f\u0012\u0013\u0012\u00110\u0002¢\u0006\f\b\u001d\u0012\b\b\u001e\u0012\u0004\b\b(\u001f\u0012\u0004\u0012\u00020 \u0018\u00010\u001cX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b!\u0010\"\"\u0004\b#\u0010$RL\u0010%\u001a4\u0012\u0013\u0012\u00110\u0002¢\u0006\f\b\u001d\u0012\b\b\u001e\u0012\u0004\b\b(\u001f\u0012\u0013\u0012\u00110'¢\u0006\f\b\u001d\u0012\b\b\u001e\u0012\u0004\b\b((\u0012\u0004\u0012\u00020 \u0018\u00010&X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b)\u0010*\"\u0004\b+\u0010,R\u001c\u0010-\u001a\u0004\u0018\u00010.X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b/\u00100\"\u0004\b1\u00102R\u001b\u00103\u001a\u0002048BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b7\u00108\u001a\u0004\b5\u00106¨\u0006X"}, d2 = {"Lcom/box/android/collections/presentation/fragments/FavoritesCollectionItemsFragment;", "Lcom/box/android/base/presentation/fragments/BaseListingAbstractFragment;", "Lcom/box/android/domain/models/item/ItemModel;", "Lcom/box/android/base/databinding/FragmentItemListingBinding;", "Lcom/box/android/base/presentation/TabVisibility;", "<init>", "()V", "userContextManager", "Lcom/box/android/domain/identity/IUserContextManager;", "getUserContextManager", "()Lcom/box/android/domain/identity/IUserContextManager;", "setUserContextManager", "(Lcom/box/android/domain/identity/IUserContextManager;)V", "thumbnailManager", "Lcom/box/android/base/presentation/ThumbnailManager;", "getThumbnailManager", "()Lcom/box/android/base/presentation/ThumbnailManager;", "setThumbnailManager", "(Lcom/box/android/base/presentation/ThumbnailManager;)V", "featureFlips", "Lcom/box/android/domain/configuration/FeatureFlips;", "getFeatureFlips", "()Lcom/box/android/domain/configuration/FeatureFlips;", "setFeatureFlips", "(Lcom/box/android/domain/configuration/FeatureFlips;)V", "itemActionHandler", "Lcom/box/android/base/presentation/utilities/IItemActionHandler;", "itemClickListener", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "itemModel", "", "getItemClickListener", "()Lkotlin/jvm/functions/Function1;", "setItemClickListener", "(Lkotlin/jvm/functions/Function1;)V", "itemMoreActionClickListener", "Lkotlin/Function2;", "Lcom/box/android/base/presentation/fragments/models/BottomSheetAttributes$BottomSheetMenuType;", "bottomSheetMenuType", "getItemMoreActionClickListener", "()Lkotlin/jvm/functions/Function2;", "setItemMoreActionClickListener", "(Lkotlin/jvm/functions/Function2;)V", BoxItemJob.COLLECTION_ID, "", "getCollectionId", "()Ljava/lang/String;", "setCollectionId", "(Ljava/lang/String;)V", "viewModel", "Lcom/box/android/collections/presentation/viewmodel/FavoritesCollectionItemsViewModel;", "getViewModel", "()Lcom/box/android/collections/presentation/viewmodel/FavoritesCollectionItemsViewModel;", "viewModel$delegate", "Lkotlin/Lazy;", "onAttach", "context", "Landroid/content/Context;", "createAdapter", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "setTabVisibility", "isTabVisible", "", "getTitle", "getAmplitudePageName", "getGenericId", "getType", "", "renderNewList", "newList", "", "createPresenter", "Lcom/box/android/base/presentation/presenters/BaseListingPresenter;", "setupEmptyView", "emptyImageSetter", "Lcom/box/android/base/presentation/fragments/ResourceSetter;", "emptyTextSetter", "emptySubtextSetter", "onAddFabClicked", "isAddFabAvailable", "shouldUpdateFragment", "message", "Lcom/box/android/coreservices/modelcontroller/messages/BoxMessage;", "updateItem", "item", "Companion", "collections_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
@AndroidEntryPoint
public final class FavoritesCollectionItemsFragment extends Hilt_FavoritesCollectionItemsFragment<ItemModel, FragmentItemListingBinding> implements TabVisibility {
    private String collectionId;

    @Inject
    public FeatureFlips featureFlips;
    private IItemActionHandler itemActionHandler;
    private Function1<? super ItemModel, Unit> itemClickListener;
    private Function2<? super ItemModel, ? super BottomSheetAttributes.BottomSheetMenuType, Unit> itemMoreActionClickListener;

    @Inject
    public ThumbnailManager thumbnailManager;

    @Inject
    public IUserContextManager userContextManager;

    /* JADX INFO: renamed from: viewModel$delegate, reason: from kotlin metadata */
    private final Lazy viewModel;

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public static final int $stable = 8;
    private static final String TAG = "javaClass";

    @Override // com.box.android.base.presentation.BoxFragmentInterface
    public int getType() {
        return 25;
    }

    @Override // com.box.android.base.presentation.utilities.AddFabHelper
    public boolean isAddFabAvailable() {
        return false;
    }

    @Override // com.box.android.base.presentation.TabVisibility
    public void setTabVisibility(boolean isTabVisible) {
    }

    public FavoritesCollectionItemsFragment() {
        final FavoritesCollectionItemsFragment favoritesCollectionItemsFragment = this;
        final Function0<Fragment> function0 = new Function0<Fragment>() { // from class: com.box.android.collections.presentation.fragments.FavoritesCollectionItemsFragment$special$$inlined$viewModels$default$1
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final Fragment invoke() {
                return favoritesCollectionItemsFragment;
            }
        };
        final Lazy lazy = LazyKt.lazy(LazyThreadSafetyMode.NONE, (Function0) new Function0<ViewModelStoreOwner>() { // from class: com.box.android.collections.presentation.fragments.FavoritesCollectionItemsFragment$special$$inlined$viewModels$default$2
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ViewModelStoreOwner invoke() {
                return (ViewModelStoreOwner) function0.invoke();
            }
        });
        final Function0 function1 = null;
        this.viewModel = FragmentViewModelLazyKt.createViewModelLazy(favoritesCollectionItemsFragment, Reflection.getOrCreateKotlinClass(FavoritesCollectionItemsViewModel.class), new Function0<ViewModelStore>() { // from class: com.box.android.collections.presentation.fragments.FavoritesCollectionItemsFragment$special$$inlined$viewModels$default$3
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ViewModelStore invoke() {
                return FragmentViewModelLazyKt.m10254viewModels$lambda1(lazy).getViewModelStore();
            }
        }, new Function0<CreationExtras>() { // from class: com.box.android.collections.presentation.fragments.FavoritesCollectionItemsFragment$special$$inlined$viewModels$default$4
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final CreationExtras invoke() {
                CreationExtras creationExtras;
                Function0 function2 = function1;
                if (function2 != null && (creationExtras = (CreationExtras) function2.invoke()) != null) {
                    return creationExtras;
                }
                ViewModelStoreOwner viewModelStoreOwnerM10254viewModels$lambda1 = FragmentViewModelLazyKt.m10254viewModels$lambda1(lazy);
                HasDefaultViewModelProviderFactory hasDefaultViewModelProviderFactory = viewModelStoreOwnerM10254viewModels$lambda1 instanceof HasDefaultViewModelProviderFactory ? (HasDefaultViewModelProviderFactory) viewModelStoreOwnerM10254viewModels$lambda1 : null;
                return hasDefaultViewModelProviderFactory != null ? hasDefaultViewModelProviderFactory.getDefaultViewModelCreationExtras() : CreationExtras.Empty.INSTANCE;
            }
        }, new Function0<ViewModelProvider.Factory>() { // from class: com.box.android.collections.presentation.fragments.FavoritesCollectionItemsFragment$special$$inlined$viewModels$default$5
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
                return (hasDefaultViewModelProviderFactory == null || (defaultViewModelProviderFactory = hasDefaultViewModelProviderFactory.getDefaultViewModelProviderFactory()) == null) ? favoritesCollectionItemsFragment.getDefaultViewModelProviderFactory() : defaultViewModelProviderFactory;
            }
        });
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

    public final Function1<ItemModel, Unit> getItemClickListener() {
        return this.itemClickListener;
    }

    public final void setItemClickListener(Function1<? super ItemModel, Unit> function1) {
        this.itemClickListener = function1;
    }

    public final Function2<ItemModel, BottomSheetAttributes.BottomSheetMenuType, Unit> getItemMoreActionClickListener() {
        return this.itemMoreActionClickListener;
    }

    public final void setItemMoreActionClickListener(Function2<? super ItemModel, ? super BottomSheetAttributes.BottomSheetMenuType, Unit> function2) {
        this.itemMoreActionClickListener = function2;
    }

    public final String getCollectionId() {
        return this.collectionId;
    }

    public final void setCollectionId(String str) {
        this.collectionId = str;
    }

    private final FavoritesCollectionItemsViewModel getViewModel() {
        return (FavoritesCollectionItemsViewModel) this.viewModel.getValue();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.box.android.collections.presentation.fragments.Hilt_FavoritesCollectionItemsFragment, androidx.fragment.app.Fragment
    public void onAttach(Context context) {
        IItemActionHandler iItemActionHandlerProvideItemActionHandler;
        Intrinsics.checkNotNullParameter(context, "context");
        super.onAttach(context);
        if (getFeatureFlips().getMainScreenRedesign().getEnabled()) {
            return;
        }
        ItemActionHandlerProvider itemActionHandlerProvider = context instanceof ItemActionHandlerProvider ? (ItemActionHandlerProvider) context : null;
        if (itemActionHandlerProvider == null || (iItemActionHandlerProvideItemActionHandler = itemActionHandlerProvider.provideItemActionHandler()) == null) {
            throw new IllegalStateException(context + " must implement ItemActionHandlerProvider");
        }
        this.itemActionHandler = iItemActionHandlerProvideItemActionHandler;
    }

    @Override // com.box.android.base.presentation.fragments.BaseListingAbstractFragment
    protected RecyclerView.Adapter<?> createAdapter() {
        Context contextRequireContext = requireContext();
        Intrinsics.checkNotNullExpressionValue(contextRequireContext, "requireContext(...)");
        return new CollectionItemsAdapter(contextRequireContext, new ItemActionListener<ItemModel>() { // from class: com.box.android.collections.presentation.fragments.FavoritesCollectionItemsFragment.createAdapter.1
            @Override // com.box.android.base.presentation.utilities.ItemActionListener
            public /* bridge */ boolean onLongClick(ItemModel itemModel) {
                return super.onLongClick(itemModel);
            }

            @Override // com.box.android.base.presentation.utilities.ItemActionListener
            public void onPrimaryAction(ItemModel item) {
                Intrinsics.checkNotNullParameter(item, "item");
                if (!FavoritesCollectionItemsFragment.this.getFeatureFlips().getMainScreenRedesign().getEnabled()) {
                    IItemActionHandler iItemActionHandler = FavoritesCollectionItemsFragment.this.itemActionHandler;
                    if (iItemActionHandler != null) {
                        IItemActionHandler.onItemClick$default(iItemActionHandler, item, false, PreviewSource.Favorites.INSTANCE, 2, null);
                        return;
                    }
                    return;
                }
                Function1<ItemModel, Unit> itemClickListener = FavoritesCollectionItemsFragment.this.getItemClickListener();
                if (itemClickListener != null) {
                    itemClickListener.invoke(item);
                }
            }

            @Override // com.box.android.base.presentation.utilities.ItemActionListener
            public void onSecondaryAction(ItemModel item) {
                Intrinsics.checkNotNullParameter(item, "item");
                String collectionId = FavoritesCollectionItemsFragment.this.getCollectionId();
                if (collectionId == null) {
                    return;
                }
                if (!FavoritesCollectionItemsFragment.this.getFeatureFlips().getMainScreenRedesign().getEnabled()) {
                    IItemActionHandler iItemActionHandler = FavoritesCollectionItemsFragment.this.itemActionHandler;
                    if (iItemActionHandler != null) {
                        FavoritesCollectionItemsFragment favoritesCollectionItemsFragment = FavoritesCollectionItemsFragment.this;
                        IItemActionHandler.showBottomSheet$default(iItemActionHandler, item, new BottomSheetAttributes.BottomSheetMenuType.RemoveCollectionItems(favoritesCollectionItemsFragment.getTitle(favoritesCollectionItemsFragment.requireContext()), collectionId), (BottomSheetAttributes.LaunchContext) null, (DialogInterface.OnShowListener) null, (List) null, 28, (Object) null);
                        return;
                    }
                    return;
                }
                Function2<ItemModel, BottomSheetAttributes.BottomSheetMenuType, Unit> itemMoreActionClickListener = FavoritesCollectionItemsFragment.this.getItemMoreActionClickListener();
                if (itemMoreActionClickListener != null) {
                    FavoritesCollectionItemsFragment favoritesCollectionItemsFragment2 = FavoritesCollectionItemsFragment.this;
                    itemMoreActionClickListener.invoke(item, new BottomSheetAttributes.BottomSheetMenuType.RemoveCollectionItems(favoritesCollectionItemsFragment2.getTitle(favoritesCollectionItemsFragment2.requireContext()), collectionId));
                }
            }
        }, getThumbnailManager(), getFeatureFlips(), getUserContextManager());
    }

    @Override // com.box.android.base.presentation.BoxFragmentInterface
    public String getTitle(Context context) {
        return CommonBoxUtil.LS(R.string.favorites);
    }

    @Override // com.box.android.base.presentation.BoxFragmentInterface
    public String getAmplitudePageName() {
        return BoxAnalyticsParams.PAGE_NAME_FAVORITES_COLLECTION_ITEMS;
    }

    @Override // com.box.android.base.presentation.BoxFragmentInterface
    public String getGenericId() {
        return this.collectionId;
    }

    /* JADX INFO: compiled from: FavoritesCollectionItemsFragment.kt */
    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0016\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0007R\u0011\u0010\t\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\f"}, d2 = {"Lcom/box/android/collections/presentation/fragments/FavoritesCollectionItemsFragment$Companion;", "", "<init>", "()V", "newInstance", "Lcom/box/android/collections/presentation/fragments/FavoritesCollectionItemsFragment;", "id", "", "name", "TAG", "getTAG", "()Ljava/lang/String;", "collections_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final FavoritesCollectionItemsFragment newInstance(String id, String name) {
            Intrinsics.checkNotNullParameter(id, "id");
            Intrinsics.checkNotNullParameter(name, "name");
            FavoritesCollectionItemsFragment favoritesCollectionItemsFragment = new FavoritesCollectionItemsFragment();
            Bundle bundle = new Bundle();
            bundle.putString(IntentConstants.EXTRA_INIT_COLLECTION_ID, id);
            bundle.putString(IntentConstants.EXTRA_ITEM_NAME, name);
            favoritesCollectionItemsFragment.setArguments(bundle);
            return favoritesCollectionItemsFragment;
        }

        public final String getTAG() {
            return FavoritesCollectionItemsFragment.TAG;
        }
    }

    @Override // com.box.android.base.presentation.fragments.BaseListingAbstractFragment, com.box.android.base.presentation.presenters.BaseListingPresenter.BoxItemsView
    public void renderNewList(List<? extends ItemModel> newList) {
        Intrinsics.checkNotNullParameter(newList, "newList");
        super.renderNewList(newList);
        BoxAmplitudeAnalytics.createEventBuilder().setFlow(BoxAnalyticsParams.FLOW_COLLECTIONS_NAVIGATION).setCtaPageLocation(getAmplitudePageName()).setCtaItemCount(Integer.valueOf(getAdapter().getItemCount())).setTimeOnPage().logEvent(BoxAnalyticsParams.EVENT_FAVORITES_COLLECTION_ITEMS_RENDERED);
    }

    @Override // com.box.android.base.presentation.fragments.BaseListingAbstractFragment
    protected BaseListingPresenter<ItemModel, BaseListingAbstractFragment<ItemModel, FragmentItemListingBinding>> createPresenter() {
        return new FavoritesCollectionItemsPresenter(this, getViewModel());
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

    @Override // com.box.android.base.presentation.utilities.AddFabHelper
    public void onAddFabClicked() {
        Log.d(getClass().getName(), "FAB Clicked");
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
