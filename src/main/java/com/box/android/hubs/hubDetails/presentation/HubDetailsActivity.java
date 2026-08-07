package com.box.android.hubs.hubDetails.presentation;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelLazy;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStore;
import androidx.lifecycle.viewmodel.CreationExtras;
import com.box.android.common.utilities.ViewModelAssistedFactory;
import com.box.android.domain.webBridgeAuth.IBoxWebBridgeAuthenticator;
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

/* JADX INFO: compiled from: HubDetailsActivity.kt */
/* JADX INFO: loaded from: classes12.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u0000 \u00172\u00020\u0001:\u0001\u0017B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u000f\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0014¢\u0006\u0002\u0010\u0006J\u0012\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016H\u0014R\u001e\u0010\u0007\u001a\u00020\b8\u0006@\u0006X\u0087.¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u001b\u0010\r\u001a\u00020\u000e8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u000f\u0010\u0010¨\u0006\u0018"}, d2 = {"Lcom/box/android/hubs/hubDetails/presentation/HubDetailsActivity;", "Lcom/box/android/base/presentation/activities/BoxFragmentActivity;", "<init>", "()V", "getActivityLayoutId", "", "()Ljava/lang/Integer;", "webBridgeAuthenticator", "Lcom/box/android/domain/webBridgeAuth/IBoxWebBridgeAuthenticator;", "getWebBridgeAuthenticator", "()Lcom/box/android/domain/webBridgeAuth/IBoxWebBridgeAuthenticator;", "setWebBridgeAuthenticator", "(Lcom/box/android/domain/webBridgeAuth/IBoxWebBridgeAuthenticator;)V", "viewModel", "Lcom/box/android/hubs/hubDetails/presentation/HubDetailsViewModel;", "getViewModel", "()Lcom/box/android/hubs/hubDetails/presentation/HubDetailsViewModel;", "viewModel$delegate", "Lkotlin/Lazy;", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "Companion", "hubs_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
@AndroidEntryPoint
public final class HubDetailsActivity extends Hilt_HubDetailsActivity {
    private static final String HUB_ID_KEY = "HUB_ID_KEY";

    /* JADX INFO: renamed from: viewModel$delegate, reason: from kotlin metadata */
    private final Lazy viewModel;

    @Inject
    public IBoxWebBridgeAuthenticator webBridgeAuthenticator;

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public static final int $stable = 8;

    @Override // com.box.android.base.presentation.activities.BoxFragmentActivity
    protected Integer getActivityLayoutId() {
        return null;
    }

    public HubDetailsActivity() {
        final HubDetailsActivity hubDetailsActivity = this;
        final Function0<CreationExtras> function0 = new Function0<CreationExtras>() { // from class: com.box.android.hubs.hubDetails.presentation.HubDetailsActivity$special$$inlined$viewModelsWithArgs$1
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final CreationExtras invoke() {
                CreationExtras defaultViewModelCreationExtras = hubDetailsActivity.getDefaultViewModelCreationExtras();
                Intrinsics.checkNotNullExpressionValue(defaultViewModelCreationExtras, "<get-defaultViewModelCreationExtras>(...)");
                final HubDetailsActivity hubDetailsActivity2 = this;
                return HiltViewModelExtensions.withCreationCallback(defaultViewModelCreationExtras, new Function1<ViewModelAssistedFactory<HubDetailsViewModel>, ViewModel>() { // from class: com.box.android.hubs.hubDetails.presentation.HubDetailsActivity$special$$inlined$viewModelsWithArgs$1.1
                    @Override // kotlin.jvm.functions.Function1
                    public final ViewModel invoke(ViewModelAssistedFactory<HubDetailsViewModel> factory) {
                        Intrinsics.checkNotNullParameter(factory, "factory");
                        Bundle bundle = new Bundle();
                        bundle.putString(HubDetailsViewModel.VM_HUB_ID_KEY, hubDetailsActivity2.getIntent().getStringExtra("HUB_ID_KEY"));
                        return factory.create(bundle);
                    }
                });
            }
        };
        this.viewModel = new ViewModelLazy(Reflection.getOrCreateKotlinClass(HubDetailsViewModel.class), new Function0<ViewModelStore>() { // from class: com.box.android.hubs.hubDetails.presentation.HubDetailsActivity$special$$inlined$viewModelsWithArgs$3
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ViewModelStore invoke() {
                return hubDetailsActivity.getViewModelStore();
            }
        }, new Function0<ViewModelProvider.Factory>() { // from class: com.box.android.hubs.hubDetails.presentation.HubDetailsActivity$special$$inlined$viewModelsWithArgs$2
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ViewModelProvider.Factory invoke() {
                return hubDetailsActivity.getDefaultViewModelProviderFactory();
            }
        }, new Function0<CreationExtras>() { // from class: com.box.android.hubs.hubDetails.presentation.HubDetailsActivity$special$$inlined$viewModelsWithArgs$4
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final CreationExtras invoke() {
                CreationExtras creationExtras;
                Function0 function1 = function0;
                return (function1 == null || (creationExtras = (CreationExtras) function1.invoke()) == null) ? hubDetailsActivity.getDefaultViewModelCreationExtras() : creationExtras;
            }
        });
    }

    public final IBoxWebBridgeAuthenticator getWebBridgeAuthenticator() {
        IBoxWebBridgeAuthenticator iBoxWebBridgeAuthenticator = this.webBridgeAuthenticator;
        if (iBoxWebBridgeAuthenticator != null) {
            return iBoxWebBridgeAuthenticator;
        }
        Intrinsics.throwUninitializedPropertyAccessException("webBridgeAuthenticator");
        return null;
    }

    public final void setWebBridgeAuthenticator(IBoxWebBridgeAuthenticator iBoxWebBridgeAuthenticator) {
        Intrinsics.checkNotNullParameter(iBoxWebBridgeAuthenticator, "<set-?>");
        this.webBridgeAuthenticator = iBoxWebBridgeAuthenticator;
    }

    private final HubDetailsViewModel getViewModel() {
        return (HubDetailsViewModel) this.viewModel.getValue();
    }

    @Override // com.box.android.base.presentation.activities.BoxFragmentActivity, com.box.android.base.presentation.activities.Hilt_BoxFragmentActivity, com.box.android.base.presentation.activities.BoxSpinnerDialogFragmentActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, com.microsoft.intune.mam.client.app.MAMActivity, com.microsoft.intune.mam.client.app.HookedActivity
    public void onMAMCreate(Bundle bundle) {
        super.onMAMCreate(bundle);
        new HubDetailsContent(this, getViewModel().getStore(), getWebBridgeAuthenticator());
    }

    /* JADX INFO: compiled from: HubDetailsActivity.kt */
    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0016\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u0005R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u000b"}, d2 = {"Lcom/box/android/hubs/hubDetails/presentation/HubDetailsActivity$Companion;", "", "<init>", "()V", HubDetailsActivity.HUB_ID_KEY, "", "getIntent", "Landroid/content/Intent;", "context", "Landroid/content/Context;", "id", "hubs_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final Intent getIntent(Context context, String id) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(id, "id");
            Intent intent = new Intent(context, (Class<?>) HubDetailsActivity.class);
            intent.putExtra(HubDetailsActivity.HUB_ID_KEY, id);
            return intent;
        }
    }
}
