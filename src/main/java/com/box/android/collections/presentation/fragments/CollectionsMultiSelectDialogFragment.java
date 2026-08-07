package com.box.android.collections.presentation.fragments;

import android.app.Dialog;
import android.os.Build;
import android.os.Bundle;
import android.os.Parcelable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.lifecycle.HasDefaultViewModelProviderFactory;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStore;
import androidx.lifecycle.ViewModelStoreOwner;
import androidx.lifecycle.viewmodel.CreationExtras;
import androidx.recyclerview.widget.ListAdapter;
import com.box.android.base.presentation.BoxPresentationUtils;
import com.box.android.base.presentation.fragments.EditTextDialogFragment;
import com.box.android.base.presentation.fragments.MultiSelectDialogFragmentKt;
import com.box.android.collections.R;
import com.box.android.collections.presentation.adapter.CollectionMembershipsAdapter;
import com.box.android.collections.presentation.viewmodel.CollectionMembershipModel;
import com.box.android.collections.presentation.viewmodel.CollectionMembershipsViewModel;
import com.box.android.common.utilities.ErrorEvent;
import com.box.android.common.utilities.SingleEventObserver;
import com.box.android.common.utilities.ViewModelAssistedFactory;
import com.box.android.domain.models.item.ItemModel;
import dagger.hilt.android.AndroidEntryPoint;
import dagger.hilt.android.lifecycle.HiltViewModelExtensions;
import java.util.Arrays;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;

/* JADX INFO: compiled from: CollectionsMultiSelectDialogFragment.kt */
/* JADX INFO: loaded from: classes10.dex */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\b\u0007\u0018\u0000 \u001b2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u001bB\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u0012\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012H\u0016J\u0012\u0010\u0013\u001a\f\u0012\u0004\u0012\u00020\u0002\u0012\u0002\b\u00030\u0014H\u0016J\b\u0010\u0015\u001a\u00020\u0016H\u0016J\b\u0010\u0017\u001a\u00020\u0018H\u0016J\b\u0010\u0019\u001a\u00020\u0018H\u0016J\b\u0010\u001a\u001a\u00020\u0018H\u0016R\u0014\u0010\u0005\u001a\u00020\u00068BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0007\u0010\bR\u001b\u0010\t\u001a\u00020\n8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000b\u0010\f¨\u0006\u001c"}, d2 = {"Lcom/box/android/collections/presentation/fragments/CollectionsMultiSelectDialogFragment;", "Lcom/box/android/base/presentation/fragments/MultiSelectDialogFragment;", "Lcom/box/android/collections/presentation/viewmodel/CollectionMembershipModel;", "<init>", "()V", "itemModel", "Lcom/box/android/domain/models/item/ItemModel;", "getItemModel", "()Lcom/box/android/domain/models/item/ItemModel;", "viewModel", "Lcom/box/android/collections/presentation/viewmodel/CollectionMembershipsViewModel;", "getViewModel", "()Lcom/box/android/collections/presentation/viewmodel/CollectionMembershipsViewModel;", "viewModel$delegate", "Lkotlin/Lazy;", "onCreateDialog", "Landroid/app/Dialog;", "savedInstanceState", "Landroid/os/Bundle;", "createAdapter", "Landroidx/recyclerview/widget/ListAdapter;", "isAddButtonAvailable", "", "onAddButton", "", "onPositiveButton", "onNegativeButton", "Factory", "collections_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
@AndroidEntryPoint
public final class CollectionsMultiSelectDialogFragment extends Hilt_CollectionsMultiSelectDialogFragment<CollectionMembershipModel> {
    public static final String TAG = "collections_multi_select_dialog";

    /* JADX INFO: renamed from: viewModel$delegate, reason: from kotlin metadata */
    private final Lazy viewModel;

    /* JADX INFO: renamed from: Factory, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public static final int $stable = 8;

    @Override // com.box.android.base.presentation.fragments.MultiSelectDialogFragment
    public boolean isAddButtonAvailable() {
        return true;
    }

    public CollectionsMultiSelectDialogFragment() {
        final CollectionsMultiSelectDialogFragment collectionsMultiSelectDialogFragment = this;
        final Function0<CreationExtras> function0 = new Function0<CreationExtras>() { // from class: com.box.android.collections.presentation.fragments.CollectionsMultiSelectDialogFragment$special$$inlined$viewModelsWithArgs$1
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final CreationExtras invoke() {
                CreationExtras defaultViewModelCreationExtras = collectionsMultiSelectDialogFragment.getDefaultViewModelCreationExtras();
                Intrinsics.checkNotNullExpressionValue(defaultViewModelCreationExtras, "<get-defaultViewModelCreationExtras>(...)");
                final CollectionsMultiSelectDialogFragment collectionsMultiSelectDialogFragment2 = this;
                return HiltViewModelExtensions.withCreationCallback(defaultViewModelCreationExtras, new Function1<ViewModelAssistedFactory<CollectionMembershipsViewModel>, ViewModel>() { // from class: com.box.android.collections.presentation.fragments.CollectionsMultiSelectDialogFragment$special$$inlined$viewModelsWithArgs$1.1
                    @Override // kotlin.jvm.functions.Function1
                    public final ViewModel invoke(ViewModelAssistedFactory<CollectionMembershipsViewModel> factory) {
                        Intrinsics.checkNotNullParameter(factory, "factory");
                        Bundle bundle = new Bundle();
                        bundle.putParcelable(CollectionMembershipsViewModel.VM_ITEM_MODEL_KEY, collectionsMultiSelectDialogFragment2.getItemModel());
                        return factory.create(bundle);
                    }
                });
            }
        };
        final Function0<Fragment> function1 = new Function0<Fragment>() { // from class: com.box.android.collections.presentation.fragments.CollectionsMultiSelectDialogFragment$special$$inlined$viewModelsWithArgs$2
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final Fragment invoke() {
                return collectionsMultiSelectDialogFragment;
            }
        };
        final Lazy lazy = LazyKt.lazy(LazyThreadSafetyMode.NONE, (Function0) new Function0<ViewModelStoreOwner>() { // from class: com.box.android.collections.presentation.fragments.CollectionsMultiSelectDialogFragment$special$$inlined$viewModelsWithArgs$3
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ViewModelStoreOwner invoke() {
                return (ViewModelStoreOwner) function1.invoke();
            }
        });
        this.viewModel = FragmentViewModelLazyKt.createViewModelLazy(collectionsMultiSelectDialogFragment, Reflection.getOrCreateKotlinClass(CollectionMembershipsViewModel.class), new Function0<ViewModelStore>() { // from class: com.box.android.collections.presentation.fragments.CollectionsMultiSelectDialogFragment$special$$inlined$viewModelsWithArgs$4
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ViewModelStore invoke() {
                return FragmentViewModelLazyKt.m10254viewModels$lambda1(lazy).getViewModelStore();
            }
        }, new Function0<CreationExtras>() { // from class: com.box.android.collections.presentation.fragments.CollectionsMultiSelectDialogFragment$special$$inlined$viewModelsWithArgs$5
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
        }, new Function0<ViewModelProvider.Factory>() { // from class: com.box.android.collections.presentation.fragments.CollectionsMultiSelectDialogFragment$special$$inlined$viewModelsWithArgs$6
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
                return (hasDefaultViewModelProviderFactory == null || (defaultViewModelProviderFactory = hasDefaultViewModelProviderFactory.getDefaultViewModelProviderFactory()) == null) ? collectionsMultiSelectDialogFragment.getDefaultViewModelProviderFactory() : defaultViewModelProviderFactory;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final ItemModel getItemModel() {
        Parcelable parcelable;
        Bundle arguments = getArguments();
        ItemModel itemModel = null;
        if (arguments != null) {
            if (Build.VERSION.SDK_INT >= 33) {
                parcelable = (Parcelable) arguments.getParcelable(CollectionsMultiSelectDialogFragmentKt.EXTRA_INIT_ITEM, ItemModel.class);
            } else {
                Parcelable parcelable2 = arguments.getParcelable(CollectionsMultiSelectDialogFragmentKt.EXTRA_INIT_ITEM);
                parcelable = (ItemModel) (parcelable2 instanceof ItemModel ? parcelable2 : null);
            }
            itemModel = (ItemModel) parcelable;
        }
        Intrinsics.checkNotNull(itemModel);
        return itemModel;
    }

    private final CollectionMembershipsViewModel getViewModel() {
        return (CollectionMembershipsViewModel) this.viewModel.getValue();
    }

    /* JADX INFO: renamed from: com.box.android.collections.presentation.fragments.CollectionsMultiSelectDialogFragment$Factory, reason: from kotlin metadata */
    /* JADX INFO: compiled from: CollectionsMultiSelectDialogFragment.kt */
    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tR\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006\n"}, d2 = {"Lcom/box/android/collections/presentation/fragments/CollectionsMultiSelectDialogFragment$Factory;", "", "<init>", "()V", "TAG", "", "newInstance", "Lcom/box/android/collections/presentation/fragments/CollectionsMultiSelectDialogFragment;", "itemModel", "Lcom/box/android/domain/models/item/ItemModel;", "collections_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final CollectionsMultiSelectDialogFragment newInstance(ItemModel itemModel) {
            Intrinsics.checkNotNullParameter(itemModel, "itemModel");
            CollectionsMultiSelectDialogFragment collectionsMultiSelectDialogFragment = new CollectionsMultiSelectDialogFragment();
            Bundle bundle = new Bundle();
            bundle.putInt(MultiSelectDialogFragmentKt.DIALOG_TITLE, R.string.Collections);
            bundle.putParcelable(CollectionsMultiSelectDialogFragmentKt.EXTRA_INIT_ITEM, itemModel);
            collectionsMultiSelectDialogFragment.setArguments(bundle);
            return collectionsMultiSelectDialogFragment;
        }
    }

    @Override // com.box.android.base.presentation.fragments.MultiSelectDialogFragment, androidx.fragment.app.DialogFragment
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        setAddButtonContentDescription(getString(R.string.collections_dialog_talkback_add_button_label));
        Dialog dialogOnCreateDialog = super.onCreateDialog(savedInstanceState);
        CollectionsMultiSelectDialogFragment collectionsMultiSelectDialogFragment = this;
        getViewModel().getCollectionMembershipsLiveData().observe(collectionsMultiSelectDialogFragment, new CollectionsMultiSelectDialogFragmentKt$sam$androidx_lifecycle_Observer$0(new Function1() { // from class: com.box.android.collections.presentation.fragments.CollectionsMultiSelectDialogFragment$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return CollectionsMultiSelectDialogFragment.onCreateDialog$lambda$0(this.f$0, (List) obj);
            }
        }));
        getViewModel().getErrorLiveData().observe(collectionsMultiSelectDialogFragment, new SingleEventObserver(new Function1() { // from class: com.box.android.collections.presentation.fragments.CollectionsMultiSelectDialogFragment$$ExternalSyntheticLambda1
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return CollectionsMultiSelectDialogFragment.onCreateDialog$lambda$1(this.f$0, (ErrorEvent) obj);
            }
        }));
        return dialogOnCreateDialog;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit onCreateDialog$lambda$0(CollectionsMultiSelectDialogFragment collectionsMultiSelectDialogFragment, List list) {
        if (list != null) {
            collectionsMultiSelectDialogFragment.renderList(CollectionsKt.toList(list));
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit onCreateDialog$lambda$1(CollectionsMultiSelectDialogFragment collectionsMultiSelectDialogFragment, ErrorEvent errorEvent) {
        if (errorEvent instanceof ErrorEvent.Toast) {
            ErrorEvent.Toast toast = (ErrorEvent.Toast) errorEvent;
            int message = toast.getMessage();
            FragmentActivity activity = collectionsMultiSelectDialogFragment.getActivity();
            String[] args = toast.getArgs();
            BoxPresentationUtils.displayToast(message, activity, (String[]) Arrays.copyOf(args, args.length));
        }
        collectionsMultiSelectDialogFragment.dismiss();
        return Unit.INSTANCE;
    }

    @Override // com.box.android.base.presentation.fragments.MultiSelectDialogFragment
    public ListAdapter<CollectionMembershipModel, ?> createAdapter() {
        return new CollectionMembershipsAdapter(CollectionsKt.emptyList(), new Function1() { // from class: com.box.android.collections.presentation.fragments.CollectionsMultiSelectDialogFragment$$ExternalSyntheticLambda2
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return CollectionsMultiSelectDialogFragment.createAdapter$lambda$0(this.f$0, (CollectionMembershipModel) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit createAdapter$lambda$0(CollectionsMultiSelectDialogFragment collectionsMultiSelectDialogFragment, CollectionMembershipModel collectionMembershipModel) {
        Intrinsics.checkNotNullParameter(collectionMembershipModel, "collectionMembershipModel");
        CollectionMembershipsViewModel.updateCollectionMembershipModel$default(collectionsMultiSelectDialogFragment.getViewModel(), collectionMembershipModel, false, 2, null);
        return Unit.INSTANCE;
    }

    @Override // com.box.android.base.presentation.fragments.MultiSelectDialogFragment
    public void onAddButton() {
        Dialog dialog = getDialog();
        if (dialog != null) {
            dialog.hide();
        }
        EditTextDialogFragment.Companion companion = EditTextDialogFragment.INSTANCE;
        String string = getString(R.string.create_collection);
        Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
        String string2 = getString(R.string.create_collection_notification_message, getItemModel().getName());
        Intrinsics.checkNotNullExpressionValue(string2, "getString(...)");
        String string3 = getString(R.string.enter_a_name);
        Intrinsics.checkNotNullExpressionValue(string3, "getString(...)");
        String string4 = getString(R.string.create_and_add);
        Intrinsics.checkNotNullExpressionValue(string4, "getString(...)");
        String string5 = getString(R.string.alert_dialog_cancel);
        Intrinsics.checkNotNullExpressionValue(string5, "getString(...)");
        companion.newInstance(string, string2, string3, string4, string5, new Function1() { // from class: com.box.android.collections.presentation.fragments.CollectionsMultiSelectDialogFragment$$ExternalSyntheticLambda3
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return CollectionsMultiSelectDialogFragment.onAddButton$lambda$0(this.f$0, (String) obj);
            }
        }, new Function0() { // from class: com.box.android.collections.presentation.fragments.CollectionsMultiSelectDialogFragment$$ExternalSyntheticLambda4
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return CollectionsMultiSelectDialogFragment.onAddButton$lambda$1(this.f$0);
            }
        }).show(getChildFragmentManager(), EditTextDialogFragment.TAG);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit onAddButton$lambda$0(CollectionsMultiSelectDialogFragment collectionsMultiSelectDialogFragment, String newCollectionName) {
        Intrinsics.checkNotNullParameter(newCollectionName, "newCollectionName");
        collectionsMultiSelectDialogFragment.getViewModel().createAndAddSelected(newCollectionName);
        collectionsMultiSelectDialogFragment.dismiss();
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit onAddButton$lambda$1(CollectionsMultiSelectDialogFragment collectionsMultiSelectDialogFragment) {
        Dialog dialog = collectionsMultiSelectDialogFragment.getDialog();
        if (dialog != null) {
            dialog.show();
        }
        return Unit.INSTANCE;
    }

    @Override // com.box.android.base.presentation.fragments.MultiSelectDialogFragment
    public void onPositiveButton() {
        getViewModel().updateCollectionMemberships();
    }

    @Override // com.box.android.base.presentation.fragments.MultiSelectDialogFragment
    public void onNegativeButton() {
        dismiss();
    }
}
