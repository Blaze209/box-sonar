package com.box.android.collections.presentation.fragments;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.lifecycle.HasDefaultViewModelProviderFactory;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStore;
import androidx.lifecycle.ViewModelStoreOwner;
import androidx.lifecycle.viewmodel.CreationExtras;
import androidx.media3.extractor.text.ttml.TtmlNode;
import androidx.recyclerview.widget.RecyclerView;
import com.box.android.base.databinding.FragmentItemListingBinding;
import com.box.android.base.presentation.TabVisibility;
import com.box.android.base.presentation.fragments.BaseListingAbstractFragment;
import com.box.android.base.presentation.fragments.EditTextDialogFragment;
import com.box.android.base.presentation.presenters.BaseListingPresenter;
import com.box.android.base.presentation.utilities.ItemActionListener;
import com.box.android.base.presentation.widgets.BoxItemDividerDecoration;
import com.box.android.collections.R;
import com.box.android.collections.presentation.MyCollectionsPresenter;
import com.box.android.collections.presentation.adapter.MyCollectionsAdapter;
import com.box.android.collections.presentation.viewmodel.MyCollectionsViewModel;
import com.box.android.common.utilities.CommonBoxUtil;
import com.box.android.common.utilities.IntentConstants;
import com.box.android.coreservices.services.IntentServices;
import com.box.android.domain.analytics.BoxAnalyticsParams;
import com.box.android.domain.models.CollectionModel;
import dagger.hilt.android.AndroidEntryPoint;
import javax.inject.Inject;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.NotImplementedError;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;

/* JADX INFO: compiled from: MyCollectionsFragment.kt */
/* JADX INFO: loaded from: classes10.dex */
@Metadata(d1 = {"\u0000\u0084\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0007\u0018\u0000 62\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u00012\u00020\u0004:\u00016B\u0007¢\u0006\u0004\b\u0005\u0010\u0006J&\u0010\u0013\u001a\u0004\u0018\u00010\u00142\u0006\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u001aH\u0016J\b\u0010\u001b\u001a\u00020\u001cH\u0016J\b\u0010\u001d\u001a\u00020\u001eH\u0016J\n\u0010\u001f\u001a\u0004\u0018\u00010 H\u0016J\f\u0010!\u001a\u0006\u0012\u0002\b\u00030\"H\u0014J\u0012\u0010#\u001a\u00020\u001c2\b\u0010$\u001a\u0004\u0018\u00010%H\u0016J\b\u0010&\u001a\u00020\u001cH\u0016J\b\u0010'\u001a\u00020(H\u0016J\u0010\u0010)\u001a\u00020\u001e2\u0006\u0010*\u001a\u00020+H\u0016J \u0010,\u001a\u001a\u0012\u0004\u0012\u00020\u0002\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u00010-H\u0014JP\u0010.\u001a\u00020\u001e2\u0016\u0010/\u001a\u0012\u0012\u0004\u0012\u00020(\u0012\u0004\u0012\u00020\u001e00j\u0002`12\u0016\u00102\u001a\u0012\u0012\u0004\u0012\u00020(\u0012\u0004\u0012\u00020\u001e00j\u0002`12\u0016\u00103\u001a\u0012\u0012\u0004\u0012\u00020(\u0012\u0004\u0012\u00020\u001e00j\u0002`1H\u0016J\b\u00104\u001a\u00020\u001eH\u0016J\b\u00105\u001a\u00020+H\u0016R\u001e\u0010\u0007\u001a\u00020\b8\u0006@\u0006X\u0087.¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u001b\u0010\r\u001a\u00020\u000e8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u000f\u0010\u0010¨\u00067"}, d2 = {"Lcom/box/android/collections/presentation/fragments/MyCollectionsFragment;", "Lcom/box/android/base/presentation/fragments/BaseListingAbstractFragment;", "Lcom/box/android/domain/models/CollectionModel;", "Lcom/box/android/base/databinding/FragmentItemListingBinding;", "Lcom/box/android/base/presentation/TabVisibility;", "<init>", "()V", "intentServices", "Lcom/box/android/coreservices/services/IntentServices;", "getIntentServices", "()Lcom/box/android/coreservices/services/IntentServices;", "setIntentServices", "(Lcom/box/android/coreservices/services/IntentServices;)V", "viewModel", "Lcom/box/android/collections/presentation/viewmodel/MyCollectionsViewModel;", "getViewModel", "()Lcom/box/android/collections/presentation/viewmodel/MyCollectionsViewModel;", "viewModel$delegate", "Lkotlin/Lazy;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", TtmlNode.RUBY_CONTAINER, "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "getGenericId", "", "setupRecyclerView", "", "getItemDividerDecoration", "Lcom/box/android/base/presentation/widgets/BoxItemDividerDecoration;", "createAdapter", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "getTitle", "context", "Landroid/content/Context;", "getAmplitudePageName", "getType", "", "setTabVisibility", "isTabVisible", "", "createPresenter", "Lcom/box/android/base/presentation/presenters/BaseListingPresenter;", "setupEmptyView", "emptyImageSetter", "Lkotlin/Function1;", "Lcom/box/android/base/presentation/fragments/ResourceSetter;", "emptyTextSetter", "emptySubtextSetter", "onAddFabClicked", "isAddFabAvailable", "Companion", "collections_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
@AndroidEntryPoint
public final class MyCollectionsFragment extends Hilt_MyCollectionsFragment<CollectionModel, FragmentItemListingBinding> implements TabVisibility {
    public static final String GENERIC_ID = "my_collections_fragment";

    @Inject
    public IntentServices intentServices;

    /* JADX INFO: renamed from: viewModel$delegate, reason: from kotlin metadata */
    private final Lazy viewModel;

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public static final int $stable = 8;
    private static final String TAG = "javaClass";

    @Override // com.box.android.base.presentation.fragments.BaseListingAbstractFragment
    public BoxItemDividerDecoration getItemDividerDecoration() {
        return null;
    }

    @Override // com.box.android.base.presentation.BoxFragmentInterface
    public int getType() {
        return 24;
    }

    @Override // com.box.android.base.presentation.utilities.AddFabHelper
    public boolean isAddFabAvailable() {
        return true;
    }

    @Override // com.box.android.base.presentation.TabVisibility
    public void setTabVisibility(boolean isTabVisible) {
    }

    public MyCollectionsFragment() {
        final MyCollectionsFragment myCollectionsFragment = this;
        final Function0<Fragment> function0 = new Function0<Fragment>() { // from class: com.box.android.collections.presentation.fragments.MyCollectionsFragment$special$$inlined$viewModels$default$1
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final Fragment invoke() {
                return myCollectionsFragment;
            }
        };
        final Lazy lazy = LazyKt.lazy(LazyThreadSafetyMode.NONE, (Function0) new Function0<ViewModelStoreOwner>() { // from class: com.box.android.collections.presentation.fragments.MyCollectionsFragment$special$$inlined$viewModels$default$2
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
        this.viewModel = FragmentViewModelLazyKt.createViewModelLazy(myCollectionsFragment, Reflection.getOrCreateKotlinClass(MyCollectionsViewModel.class), new Function0<ViewModelStore>() { // from class: com.box.android.collections.presentation.fragments.MyCollectionsFragment$special$$inlined$viewModels$default$3
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ViewModelStore invoke() {
                return FragmentViewModelLazyKt.m10254viewModels$lambda1(lazy).getViewModelStore();
            }
        }, new Function0<CreationExtras>() { // from class: com.box.android.collections.presentation.fragments.MyCollectionsFragment$special$$inlined$viewModels$default$4
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
        }, new Function0<ViewModelProvider.Factory>() { // from class: com.box.android.collections.presentation.fragments.MyCollectionsFragment$special$$inlined$viewModels$default$5
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
                return (hasDefaultViewModelProviderFactory == null || (defaultViewModelProviderFactory = hasDefaultViewModelProviderFactory.getDefaultViewModelProviderFactory()) == null) ? myCollectionsFragment.getDefaultViewModelProviderFactory() : defaultViewModelProviderFactory;
            }
        });
    }

    /* JADX INFO: compiled from: MyCollectionsFragment.kt */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u000e\u0010\b\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006\t"}, d2 = {"Lcom/box/android/collections/presentation/fragments/MyCollectionsFragment$Companion;", "", "<init>", "()V", "TAG", "", "getTAG", "()Ljava/lang/String;", "GENERIC_ID", "collections_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final String getTAG() {
            return MyCollectionsFragment.TAG;
        }
    }

    public final IntentServices getIntentServices() {
        IntentServices intentServices = this.intentServices;
        if (intentServices != null) {
            return intentServices;
        }
        Intrinsics.throwUninitializedPropertyAccessException("intentServices");
        return null;
    }

    public final void setIntentServices(IntentServices intentServices) {
        Intrinsics.checkNotNullParameter(intentServices, "<set-?>");
        this.intentServices = intentServices;
    }

    private final MyCollectionsViewModel getViewModel() {
        return (MyCollectionsViewModel) this.viewModel.getValue();
    }

    @Override // com.box.android.base.presentation.fragments.BaseListingAbstractFragment, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        return super.onCreateView(inflater, container, savedInstanceState);
    }

    @Override // com.box.android.base.presentation.BoxFragmentInterface
    public String getGenericId() {
        return GENERIC_ID;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.box.android.base.presentation.fragments.BaseListingAbstractFragment
    public void setupRecyclerView() {
        super.setupRecyclerView();
        RecyclerView recyclerView = ((FragmentItemListingBinding) getBinding()).recyclerView;
        Context contextRequireContext = requireContext();
        Intrinsics.checkNotNullExpressionValue(contextRequireContext, "requireContext(...)");
        recyclerView.setBackgroundColor(CommonBoxUtil.getColorFromAttribute(contextRequireContext, R.attr.appBackground));
        int dimension = (int) getResources().getDimension(R.dimen.box_collections_padding);
        ((FragmentItemListingBinding) getBinding()).recyclerView.setPadding(dimension, (int) getResources().getDimension(R.dimen.box_collections_padding_top), dimension, ((FragmentItemListingBinding) getBinding()).recyclerView.getPaddingBottom());
    }

    @Override // com.box.android.base.presentation.fragments.BaseListingAbstractFragment
    protected RecyclerView.Adapter<?> createAdapter() {
        return new MyCollectionsAdapter(new ItemActionListener<CollectionModel>() { // from class: com.box.android.collections.presentation.fragments.MyCollectionsFragment.createAdapter.1
            @Override // com.box.android.base.presentation.utilities.ItemActionListener
            public /* bridge */ boolean onLongClick(CollectionModel collectionModel) {
                return super.onLongClick(collectionModel);
            }

            @Override // com.box.android.base.presentation.utilities.ItemActionListener
            public void onPrimaryAction(CollectionModel item) {
                Intrinsics.checkNotNullParameter(item, "item");
                IntentServices intentServices = MyCollectionsFragment.this.getIntentServices();
                Context applicationContext = MyCollectionsFragment.this.requireContext().getApplicationContext();
                Intrinsics.checkNotNullExpressionValue(applicationContext, "getApplicationContext(...)");
                Intent intentMainPhoneActivityIntent = intentServices.mainPhoneActivityIntent(applicationContext);
                intentMainPhoneActivityIntent.setFlags(335544320);
                intentMainPhoneActivityIntent.putExtra(IntentConstants.EXTRA_INIT_COLLECTION_ID, item.getId());
                intentMainPhoneActivityIntent.putExtra(IntentConstants.EXTRA_ITEM_NAME, item.getName());
                MyCollectionsFragment.this.startActivity(intentMainPhoneActivityIntent);
            }

            @Override // com.box.android.base.presentation.utilities.ItemActionListener
            public void onSecondaryAction(CollectionModel item) {
                Intrinsics.checkNotNullParameter(item, "item");
                throw new NotImplementedError("An operation is not implemented: Not yet implemented");
            }
        });
    }

    @Override // com.box.android.base.presentation.BoxFragmentInterface
    public String getTitle(Context context) {
        return CommonBoxUtil.LS(R.string.my_collections);
    }

    @Override // com.box.android.base.presentation.BoxFragmentInterface
    public String getAmplitudePageName() {
        return BoxAnalyticsParams.PAGE_NAME_COLLECTIONS;
    }

    @Override // com.box.android.base.presentation.fragments.BaseListingAbstractFragment
    protected BaseListingPresenter<CollectionModel, BaseListingAbstractFragment<CollectionModel, FragmentItemListingBinding>> createPresenter() {
        return new MyCollectionsPresenter(this, getViewModel());
    }

    @Override // com.box.android.base.presentation.fragments.BaseListingAbstractFragment
    public void setupEmptyView(Function1<? super Integer, Unit> emptyImageSetter, Function1<? super Integer, Unit> emptyTextSetter, Function1<? super Integer, Unit> emptySubtextSetter) {
        Intrinsics.checkNotNullParameter(emptyImageSetter, "emptyImageSetter");
        Intrinsics.checkNotNullParameter(emptyTextSetter, "emptyTextSetter");
        Intrinsics.checkNotNullParameter(emptySubtextSetter, "emptySubtextSetter");
        emptyImageSetter.invoke(Integer.valueOf(R.drawable.ic_collectionstar140));
        emptyTextSetter.invoke(Integer.valueOf(R.string.empty_collections_text));
        emptySubtextSetter.invoke(Integer.valueOf(R.string.empty_collections_subtext));
    }

    @Override // com.box.android.base.presentation.utilities.AddFabHelper
    public void onAddFabClicked() {
        EditTextDialogFragment.Companion companion = EditTextDialogFragment.INSTANCE;
        String string = getString(R.string.create_collection);
        Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
        String string2 = getString(R.string.create_collection_message);
        Intrinsics.checkNotNullExpressionValue(string2, "getString(...)");
        String string3 = getString(R.string.enter_a_name);
        Intrinsics.checkNotNullExpressionValue(string3, "getString(...)");
        String string4 = getString(R.string.create);
        Intrinsics.checkNotNullExpressionValue(string4, "getString(...)");
        String string5 = getString(R.string.alert_dialog_cancel);
        Intrinsics.checkNotNullExpressionValue(string5, "getString(...)");
        companion.newInstance(string, string2, string3, string4, string5, new Function1() { // from class: com.box.android.collections.presentation.fragments.MyCollectionsFragment$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return MyCollectionsFragment.onAddFabClicked$lambda$0(this.f$0, (String) obj);
            }
        }, (64 & 64) != 0 ? null : null).show(getChildFragmentManager(), EditTextDialogFragment.TAG);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit onAddFabClicked$lambda$0(MyCollectionsFragment myCollectionsFragment, String newCollectionName) {
        Intrinsics.checkNotNullParameter(newCollectionName, "newCollectionName");
        LifecycleObserver presenter = myCollectionsFragment.getPresenter();
        Intrinsics.checkNotNull(presenter, "null cannot be cast to non-null type com.box.android.collections.presentation.MyCollectionsPresenter");
        ((MyCollectionsPresenter) presenter).createCollection(newCollectionName);
        return Unit.INSTANCE;
    }
}
