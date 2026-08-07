package com.box.android.preview.iteminformation;

import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.os.Parcelable;
import androidx.activity.EdgeToEdge;
import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelLazy;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStore;
import androidx.lifecycle.viewmodel.CreationExtras;
import com.box.android.common.utilities.ViewModelAssistedFactory;
import com.box.android.coreservices.services.IntentServices;
import com.box.android.domain.analytics.BoxAmplitudeAnalytics;
import com.box.android.domain.analytics.BoxAnalyticsParams;
import com.box.android.domain.identity.IUserContextManager;
import com.box.android.domain.models.item.ItemModel;
import dagger.hilt.android.AndroidEntryPoint;
import dagger.hilt.android.lifecycle.HiltViewModelExtensions;
import javax.inject.Inject;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;

/* JADX INFO: compiled from: ItemInformationActivity.kt */
/* JADX INFO: loaded from: classes12.dex */
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\b\u0007\u0018\u0000 \"2\u00020\u0001:\u0001\"B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\u0019\u001a\u00020\u001a2\b\u0010\u001b\u001a\u0004\u0018\u00010\u001cH\u0014J\u000f\u0010\u001d\u001a\u0004\u0018\u00010\u001eH\u0014¢\u0006\u0002\u0010\u001fJ\b\u0010 \u001a\u00020!H\u0016R\u001e\u0010\u0004\u001a\u00020\u00058\u0006@\u0006X\u0087.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001e\u0010\n\u001a\u00020\u000b8\u0006@\u0006X\u0087.¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001b\u0010\u0010\u001a\u00020\u00118BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0012\u0010\u0013R\u0014\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00180\u0017X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006#"}, d2 = {"Lcom/box/android/preview/iteminformation/ItemInformationActivity;", "Lcom/box/android/base/presentation/activities/BoxFragmentActivity;", "<init>", "()V", "userContextManager", "Lcom/box/android/domain/identity/IUserContextManager;", "getUserContextManager", "()Lcom/box/android/domain/identity/IUserContextManager;", "setUserContextManager", "(Lcom/box/android/domain/identity/IUserContextManager;)V", "intentServices", "Lcom/box/android/coreservices/services/IntentServices;", "getIntentServices", "()Lcom/box/android/coreservices/services/IntentServices;", "setIntentServices", "(Lcom/box/android/coreservices/services/IntentServices;)V", "viewModel", "Lcom/box/android/preview/iteminformation/ItemInformationViewModel;", "getViewModel", "()Lcom/box/android/preview/iteminformation/ItemInformationViewModel;", "viewModel$delegate", "Lkotlin/Lazy;", "collaborationsLauncher", "Landroidx/activity/result/ActivityResultLauncher;", "Landroid/content/Intent;", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "getActivityLayoutId", "", "()Ljava/lang/Integer;", "amplitudeSetCurrentPage", "", "Companion", "preview_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
@AndroidEntryPoint
public final class ItemInformationActivity extends Hilt_ItemInformationActivity {
    private static final String ITEM_MODEL_KEY = "ITEM_MODEL_KEY";
    private final ActivityResultLauncher<Intent> collaborationsLauncher;

    @Inject
    public IntentServices intentServices;

    @Inject
    public IUserContextManager userContextManager;

    /* JADX INFO: renamed from: viewModel$delegate, reason: from kotlin metadata */
    private final Lazy viewModel;

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public static final int $stable = 8;

    @Override // com.box.android.base.presentation.activities.BoxFragmentActivity
    protected Integer getActivityLayoutId() {
        return null;
    }

    public ItemInformationActivity() {
        final ItemInformationActivity itemInformationActivity = this;
        final Function0<CreationExtras> function0 = new Function0<CreationExtras>() { // from class: com.box.android.preview.iteminformation.ItemInformationActivity$special$$inlined$viewModelsWithArgs$1
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final CreationExtras invoke() {
                CreationExtras defaultViewModelCreationExtras = itemInformationActivity.getDefaultViewModelCreationExtras();
                Intrinsics.checkNotNullExpressionValue(defaultViewModelCreationExtras, "<get-defaultViewModelCreationExtras>(...)");
                final ItemInformationActivity itemInformationActivity2 = this;
                return HiltViewModelExtensions.withCreationCallback(defaultViewModelCreationExtras, new Function1<ViewModelAssistedFactory<ItemInformationViewModel>, ViewModel>() { // from class: com.box.android.preview.iteminformation.ItemInformationActivity$special$$inlined$viewModelsWithArgs$1.1
                    @Override // kotlin.jvm.functions.Function1
                    public final ViewModel invoke(ViewModelAssistedFactory<ItemInformationViewModel> factory) {
                        ItemModel itemModel;
                        Intrinsics.checkNotNullParameter(factory, "factory");
                        Bundle bundle = new Bundle();
                        Intent intent = itemInformationActivity2.getIntent();
                        Intrinsics.checkNotNullExpressionValue(intent, "getIntent(...)");
                        if (Build.VERSION.SDK_INT >= 33) {
                            itemModel = (Parcelable) intent.getParcelableExtra("ITEM_MODEL_KEY", ItemModel.class);
                        } else {
                            Parcelable parcelableExtra = intent.getParcelableExtra("ITEM_MODEL_KEY");
                            if (!(parcelableExtra instanceof ItemModel)) {
                                parcelableExtra = null;
                            }
                            itemModel = (ItemModel) parcelableExtra;
                        }
                        bundle.putParcelable(ItemInformationViewModel.VM_INITIAL_ITEM_MODEL_KEY, itemModel);
                        return factory.create(bundle);
                    }
                });
            }
        };
        this.viewModel = new ViewModelLazy(Reflection.getOrCreateKotlinClass(ItemInformationViewModel.class), new Function0<ViewModelStore>() { // from class: com.box.android.preview.iteminformation.ItemInformationActivity$special$$inlined$viewModelsWithArgs$3
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ViewModelStore invoke() {
                return itemInformationActivity.getViewModelStore();
            }
        }, new Function0<ViewModelProvider.Factory>() { // from class: com.box.android.preview.iteminformation.ItemInformationActivity$special$$inlined$viewModelsWithArgs$2
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ViewModelProvider.Factory invoke() {
                return itemInformationActivity.getDefaultViewModelProviderFactory();
            }
        }, new Function0<CreationExtras>() { // from class: com.box.android.preview.iteminformation.ItemInformationActivity$special$$inlined$viewModelsWithArgs$4
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final CreationExtras invoke() {
                CreationExtras creationExtras;
                Function0 function1 = function0;
                return (function1 == null || (creationExtras = (CreationExtras) function1.invoke()) == null) ? itemInformationActivity.getDefaultViewModelCreationExtras() : creationExtras;
            }
        });
        this.collaborationsLauncher = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), new ActivityResultCallback() { // from class: com.box.android.preview.iteminformation.ItemInformationActivity$$ExternalSyntheticLambda0
            @Override // androidx.activity.result.ActivityResultCallback
            public final void onActivityResult(Object obj) {
                ItemInformationActivity.collaborationsLauncher$lambda$0(this.f$0, (ActivityResult) obj);
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

    private final ItemInformationViewModel getViewModel() {
        return (ItemInformationViewModel) this.viewModel.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void collaborationsLauncher$lambda$0(ItemInformationActivity itemInformationActivity, ActivityResult it) {
        Intrinsics.checkNotNullParameter(it, "it");
        itemInformationActivity.getViewModel().getStore().send(ItemInformationReducer.Action.Initialize.INSTANCE);
    }

    @Override // com.box.android.base.presentation.activities.BoxFragmentActivity, com.box.android.base.presentation.activities.Hilt_BoxFragmentActivity, com.box.android.base.presentation.activities.BoxSpinnerDialogFragmentActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, com.microsoft.intune.mam.client.app.MAMActivity, com.microsoft.intune.mam.client.app.HookedActivity
    public void onMAMCreate(Bundle bundle) {
        ItemInformationActivity itemInformationActivity = this;
        EdgeToEdge.enable$default(itemInformationActivity, null, null, 3, null);
        super.onMAMCreate(bundle);
        new ItemInformationActivityContent(itemInformationActivity, getViewModel().getStore(), getIntentServices(), getUserContextManager(), this.collaborationsLauncher);
        getViewModel().getStore().send(ItemInformationReducer.Action.Initialize.INSTANCE);
    }

    @Override // com.box.android.base.presentation.activities.BoxSpinnerDialogFragmentActivity
    public boolean amplitudeSetCurrentPage() {
        return BoxAmplitudeAnalytics.getInstance().setCurrentPage(BoxAnalyticsParams.PAGE_NAME_ITEM_INFORMATION_PM23);
    }

    /* JADX INFO: compiled from: ItemInformationActivity.kt */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0016\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\f"}, d2 = {"Lcom/box/android/preview/iteminformation/ItemInformationActivity$Companion;", "", "<init>", "()V", ItemInformationActivity.ITEM_MODEL_KEY, "", "getIntent", "Landroid/content/Intent;", "context", "Landroid/content/Context;", "itemModel", "Lcom/box/android/domain/models/item/ItemModel;", "preview_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final Intent getIntent(Context context, ItemModel itemModel) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(itemModel, "itemModel");
            Intent intent = new Intent(context, (Class<?>) ItemInformationActivity.class);
            intent.putExtra(ItemInformationActivity.ITEM_MODEL_KEY, itemModel);
            return intent;
        }
    }
}
