package com.box.android.capture.fragments;

import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.RadioGroup;
import androidx.activity.OnBackPressedCallback;
import androidx.activity.OnBackPressedDispatcherKt;
import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AlertDialog;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.lifecycle.HasDefaultViewModelProviderFactory;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.lifecycle.RepeatOnLifecycleKt;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStore;
import androidx.lifecycle.ViewModelStoreOwner;
import androidx.lifecycle.viewmodel.CreationExtras;
import androidx.media3.extractor.text.ttml.TtmlNode;
import com.box.android.base.presentation.views.ToolbarWithOverlayWarning;
import com.box.android.capture.R;
import com.box.android.capture.activities.CaptureActivity;
import com.box.android.capture.cpl.CaptureSettingsReducer;
import com.box.android.capture.databinding.CaptureSettingsFragmentBinding;
import com.box.android.capture.viewmodel.CaptureSettingsViewModel;
import com.box.android.common.utilities.CommonBoxUtil;
import com.box.android.common.utilities.IntentUtils;
import com.box.android.cpl.Store;
import com.box.android.domain.analytics.BoxAmplitudeAnalytics;
import com.box.android.domain.analytics.BoxAnalyticsParams;
import com.box.android.domain.models.capture.PhotoQuality;
import com.box.android.domain.models.capture.VideoQuality;
import com.box.android.utilities.FlowExtensionsKt;
import com.google.android.material.dialog.MaterialAlertDialogBuilder;
import dagger.hilt.android.AndroidEntryPoint;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.FlowKt;

/* JADX INFO: compiled from: CaptureSettingsFragment.kt */
/* JADX INFO: loaded from: classes10.dex */
@Metadata(d1 = {"\u0000p\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0007\u0018\u0000 12\u00020\u0001:\u00011B\u0007¢\u0006\u0004\b\u0002\u0010\u0003B%\b\u0016\u0012\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0005\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0004\b\u0002\u0010\nJ$\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001d2\b\u0010\u001e\u001a\u0004\u0018\u00010\u001f2\b\u0010 \u001a\u0004\u0018\u00010!H\u0016J\u001a\u0010\"\u001a\u00020#2\u0006\u0010$\u001a\u00020\u001b2\b\u0010 \u001a\u0004\u0018\u00010!H\u0016J\b\u0010%\u001a\u00020#H\u0002J\u0010\u0010&\u001a\u00020#2\u0006\u0010'\u001a\u00020(H\u0002J\u0010\u0010)\u001a\u00020#2\u0006\u0010*\u001a\u00020+H\u0002J\b\u0010,\u001a\u00020#H\u0002J\u0010\u0010-\u001a\u00020\u000f2\u0006\u0010.\u001a\u00020(H\u0002J\u0010\u0010/\u001a\u00020\u000f2\u0006\u00100\u001a\u00020+H\u0002R\u001a\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0005X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000eX\u0082.¢\u0006\u0002\n\u0000R\u0014\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00110\u000eX\u0082.¢\u0006\u0002\n\u0000R\u001b\u0010\u0012\u001a\u00020\u00138BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0014\u0010\u0015R\u000e\u0010\u0018\u001a\u00020\u0019X\u0082.¢\u0006\u0002\n\u0000¨\u00062"}, d2 = {"Lcom/box/android/capture/fragments/CaptureSettingsFragment;", "Landroidx/fragment/app/Fragment;", "<init>", "()V", "store", "Lcom/box/android/cpl/Store;", "Lcom/box/android/capture/cpl/CaptureSettingsReducer$State;", "Lcom/box/android/capture/cpl/CaptureSettingsReducer$Action;", "inCaptureMode", "", "(Lcom/box/android/cpl/Store;Z)V", "localStore", "isInCaptureMode", "requestPermissionLauncher", "Landroidx/activity/result/ActivityResultLauncher;", "", "settingsLauncher", "Landroid/content/Intent;", "viewModel", "Lcom/box/android/capture/viewmodel/CaptureSettingsViewModel;", "getViewModel", "()Lcom/box/android/capture/viewmodel/CaptureSettingsViewModel;", "viewModel$delegate", "Lkotlin/Lazy;", "binding", "Lcom/box/android/capture/databinding/CaptureSettingsFragmentBinding;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", TtmlNode.RUBY_CONTAINER, "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onViewCreated", "", "view", "showPermissionDialog", "showSelectPhotoQualityDialog", "selectedPhotoQuality", "Lcom/box/android/domain/models/capture/PhotoQuality;", "showSelectedVideoQualityDialog", "selectedVideoQuality", "Lcom/box/android/domain/models/capture/VideoQuality;", "showLaunchIntoCaptureDialog", "getPhotoQualityName", "photoQuality", "getVideoQualityName", "videoQuality", "Companion", "capture_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
@AndroidEntryPoint
public final class CaptureSettingsFragment extends Hilt_CaptureSettingsFragment {
    private static final String LEARN_MORE_LINK = "https://support.box.com/hc/en-us/articles/1500012907101-Using-Capture-mode-in-the-Box-app-on-iOS-and-Android";
    private CaptureSettingsFragmentBinding binding;
    private boolean isInCaptureMode;
    private Store<CaptureSettingsReducer.State, CaptureSettingsReducer.Action> localStore;
    private ActivityResultLauncher<String> requestPermissionLauncher;
    private ActivityResultLauncher<Intent> settingsLauncher;

    /* JADX INFO: renamed from: viewModel$delegate, reason: from kotlin metadata */
    private final Lazy viewModel;
    private static final Companion Companion = new Companion(null);
    public static final int $stable = 8;

    /* JADX INFO: compiled from: CaptureSettingsFragment.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    public static final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;
        public static final /* synthetic */ int[] $EnumSwitchMapping$1;

        static {
            int[] iArr = new int[PhotoQuality.values().length];
            try {
                iArr[PhotoQuality.ORIGINAL.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[PhotoQuality.LARGE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[PhotoQuality.MEDIUM.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[PhotoQuality.SMALL.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            $EnumSwitchMapping$0 = iArr;
            int[] iArr2 = new int[VideoQuality.values().length];
            try {
                iArr2[VideoQuality.QUALITY_720P.ordinal()] = 1;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                iArr2[VideoQuality.QUALITY_1080P.ordinal()] = 2;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                iArr2[VideoQuality.QUALITY_4K.ordinal()] = 3;
            } catch (NoSuchFieldError unused7) {
            }
            $EnumSwitchMapping$1 = iArr2;
        }
    }

    public CaptureSettingsFragment() {
        final CaptureSettingsFragment captureSettingsFragment = this;
        final Function0<Fragment> function0 = new Function0<Fragment>() { // from class: com.box.android.capture.fragments.CaptureSettingsFragment$special$$inlined$viewModels$default$1
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final Fragment invoke() {
                return captureSettingsFragment;
            }
        };
        final Lazy lazy = LazyKt.lazy(LazyThreadSafetyMode.NONE, (Function0) new Function0<ViewModelStoreOwner>() { // from class: com.box.android.capture.fragments.CaptureSettingsFragment$special$$inlined$viewModels$default$2
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
        this.viewModel = FragmentViewModelLazyKt.createViewModelLazy(captureSettingsFragment, Reflection.getOrCreateKotlinClass(CaptureSettingsViewModel.class), new Function0<ViewModelStore>() { // from class: com.box.android.capture.fragments.CaptureSettingsFragment$special$$inlined$viewModels$default$3
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ViewModelStore invoke() {
                return FragmentViewModelLazyKt.m10254viewModels$lambda1(lazy).getViewModelStore();
            }
        }, new Function0<CreationExtras>() { // from class: com.box.android.capture.fragments.CaptureSettingsFragment$special$$inlined$viewModels$default$4
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
        }, new Function0<ViewModelProvider.Factory>() { // from class: com.box.android.capture.fragments.CaptureSettingsFragment$special$$inlined$viewModels$default$5
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
                return (hasDefaultViewModelProviderFactory == null || (defaultViewModelProviderFactory = hasDefaultViewModelProviderFactory.getDefaultViewModelProviderFactory()) == null) ? captureSettingsFragment.getDefaultViewModelProviderFactory() : defaultViewModelProviderFactory;
            }
        });
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public CaptureSettingsFragment(Store<CaptureSettingsReducer.State, CaptureSettingsReducer.Action> store, boolean z) {
        this();
        Intrinsics.checkNotNullParameter(store, "store");
        this.localStore = store;
        this.isInCaptureMode = z;
    }

    private final CaptureSettingsViewModel getViewModel() {
        return (CaptureSettingsViewModel) this.viewModel.getValue();
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        OnBackPressedDispatcherKt.addCallback$default(requireActivity().getOnBackPressedDispatcher(), this, false, new Function1() { // from class: com.box.android.capture.fragments.CaptureSettingsFragment$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return CaptureSettingsFragment.onCreateView$lambda$0(this.f$0, (OnBackPressedCallback) obj);
            }
        }, 2, null);
        ActivityResultLauncher<Intent> activityResultLauncherRegisterForActivityResult = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), new ActivityResultCallback() { // from class: com.box.android.capture.fragments.CaptureSettingsFragment$$ExternalSyntheticLambda11
            @Override // androidx.activity.result.ActivityResultCallback
            public final void onActivityResult(Object obj) {
                CaptureSettingsFragment.onCreateView$lambda$1(this.f$0, (ActivityResult) obj);
            }
        });
        Intrinsics.checkNotNullExpressionValue(activityResultLauncherRegisterForActivityResult, "registerForActivityResult(...)");
        this.settingsLauncher = activityResultLauncherRegisterForActivityResult;
        ActivityResultLauncher<String> activityResultLauncherRegisterForActivityResult2 = registerForActivityResult(new ActivityResultContracts.RequestPermission(), new ActivityResultCallback() { // from class: com.box.android.capture.fragments.CaptureSettingsFragment$$ExternalSyntheticLambda14
            @Override // androidx.activity.result.ActivityResultCallback
            public final void onActivityResult(Object obj) {
                CaptureSettingsFragment.onCreateView$lambda$2(this.f$0, (Boolean) obj);
            }
        });
        Intrinsics.checkNotNullExpressionValue(activityResultLauncherRegisterForActivityResult2, "registerForActivityResult(...)");
        this.requestPermissionLauncher = activityResultLauncherRegisterForActivityResult2;
        CaptureSettingsFragmentBinding captureSettingsFragmentBindingInflate = CaptureSettingsFragmentBinding.inflate(getLayoutInflater(), container, false);
        Intrinsics.checkNotNullExpressionValue(captureSettingsFragmentBindingInflate, "inflate(...)");
        this.binding = captureSettingsFragmentBindingInflate;
        if (captureSettingsFragmentBindingInflate == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            captureSettingsFragmentBindingInflate = null;
        }
        ConstraintLayout root = captureSettingsFragmentBindingInflate.getRoot();
        Intrinsics.checkNotNullExpressionValue(root, "getRoot(...)");
        return root;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit onCreateView$lambda$0(CaptureSettingsFragment captureSettingsFragment, OnBackPressedCallback addCallback) {
        Intrinsics.checkNotNullParameter(addCallback, "$this$addCallback");
        Store<CaptureSettingsReducer.State, CaptureSettingsReducer.Action> store = captureSettingsFragment.localStore;
        if (store == null) {
            Intrinsics.throwUninitializedPropertyAccessException("localStore");
            store = null;
        }
        store.send(CaptureSettingsReducer.Action.CloseSettings.INSTANCE);
        captureSettingsFragment.getParentFragmentManager().popBackStackImmediate();
        addCallback.setEnabled(false);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onCreateView$lambda$1(CaptureSettingsFragment captureSettingsFragment, ActivityResult it) {
        Intrinsics.checkNotNullParameter(it, "it");
        Store<CaptureSettingsReducer.State, CaptureSettingsReducer.Action> store = null;
        if (ContextCompat.checkSelfPermission(captureSettingsFragment.requireContext(), "android.permission.ACCESS_FINE_LOCATION") == 0) {
            Store<CaptureSettingsReducer.State, CaptureSettingsReducer.Action> store2 = captureSettingsFragment.localStore;
            if (store2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("localStore");
            } else {
                store = store2;
            }
            store.send(new CaptureSettingsReducer.Action.ToggleGpsLocation(true));
            return;
        }
        Store<CaptureSettingsReducer.State, CaptureSettingsReducer.Action> store3 = captureSettingsFragment.localStore;
        if (store3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("localStore");
        } else {
            store = store3;
        }
        store.send(new CaptureSettingsReducer.Action.ToggleGpsLocation(false));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onCreateView$lambda$2(CaptureSettingsFragment captureSettingsFragment, Boolean isGranted) {
        Intrinsics.checkNotNullParameter(isGranted, "isGranted");
        Store<CaptureSettingsReducer.State, CaptureSettingsReducer.Action> store = null;
        if (isGranted.booleanValue()) {
            Store<CaptureSettingsReducer.State, CaptureSettingsReducer.Action> store2 = captureSettingsFragment.localStore;
            if (store2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("localStore");
            } else {
                store = store2;
            }
            store.send(new CaptureSettingsReducer.Action.ToggleGpsLocation(true));
            return;
        }
        if (!captureSettingsFragment.shouldShowRequestPermissionRationale("android.permission.ACCESS_FINE_LOCATION")) {
            captureSettingsFragment.showPermissionDialog();
            return;
        }
        Store<CaptureSettingsReducer.State, CaptureSettingsReducer.Action> store3 = captureSettingsFragment.localStore;
        if (store3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("localStore");
        } else {
            store = store3;
        }
        store.send(new CaptureSettingsReducer.Action.ToggleGpsLocation(false));
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(view, "view");
        if (this.localStore == null) {
            this.localStore = getViewModel().getStore();
        }
        CaptureSettingsFragmentBinding captureSettingsFragmentBinding = this.binding;
        CaptureSettingsFragmentBinding captureSettingsFragmentBinding2 = null;
        if (captureSettingsFragmentBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            captureSettingsFragmentBinding = null;
        }
        captureSettingsFragmentBinding.settingsToolbar.toolbar.setNavigationIcon(R.drawable.ic_box_previewsdk_arrow_back_white_24dp);
        CaptureSettingsFragmentBinding captureSettingsFragmentBinding3 = this.binding;
        if (captureSettingsFragmentBinding3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            captureSettingsFragmentBinding3 = null;
        }
        captureSettingsFragmentBinding3.settingsToolbar.toolbar.setNavigationContentDescription(R.string.back_button_talkback_label);
        CaptureSettingsFragmentBinding captureSettingsFragmentBinding4 = this.binding;
        if (captureSettingsFragmentBinding4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            captureSettingsFragmentBinding4 = null;
        }
        captureSettingsFragmentBinding4.settingsToolbar.toolbar.setTitle(R.string.settings_capture_header);
        CaptureSettingsFragmentBinding captureSettingsFragmentBinding5 = this.binding;
        if (captureSettingsFragmentBinding5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            captureSettingsFragmentBinding5 = null;
        }
        captureSettingsFragmentBinding5.settingsToolbar.toolbar.setNavigationOnClickListener(new View.OnClickListener() { // from class: com.box.android.capture.fragments.CaptureSettingsFragment$$ExternalSyntheticLambda1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                CaptureSettingsFragment.onViewCreated$lambda$0(this.f$0, view2);
            }
        });
        if (this.isInCaptureMode) {
            CaptureSettingsFragmentBinding captureSettingsFragmentBinding6 = this.binding;
            if (captureSettingsFragmentBinding6 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
                captureSettingsFragmentBinding6 = null;
            }
            ToolbarWithOverlayWarning toolbar = captureSettingsFragmentBinding6.settingsToolbar.toolbar;
            Intrinsics.checkNotNullExpressionValue(toolbar, "toolbar");
            CommonBoxUtil.addStatusBarPaddingTop(toolbar);
        }
        LifecycleOwner viewLifecycleOwner = getViewLifecycleOwner();
        Intrinsics.checkNotNullExpressionValue(viewLifecycleOwner, "getViewLifecycleOwner(...)");
        BuildersKt__Builders_commonKt.launch$default(LifecycleOwnerKt.getLifecycleScope(viewLifecycleOwner), null, null, new AnonymousClass2(null), 3, null);
        CaptureSettingsFragmentBinding captureSettingsFragmentBinding7 = this.binding;
        if (captureSettingsFragmentBinding7 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            captureSettingsFragmentBinding7 = null;
        }
        captureSettingsFragmentBinding7.launchIntoCapture.setOnClickListener(new View.OnClickListener() { // from class: com.box.android.capture.fragments.CaptureSettingsFragment$$ExternalSyntheticLambda2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                CaptureSettingsFragment.onViewCreated$lambda$1(this.f$0, view2);
            }
        });
        CaptureSettingsFragmentBinding captureSettingsFragmentBinding8 = this.binding;
        if (captureSettingsFragmentBinding8 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            captureSettingsFragmentBinding8 = null;
        }
        captureSettingsFragmentBinding8.launchIntoCaptureContainer.setOnClickListener(new View.OnClickListener() { // from class: com.box.android.capture.fragments.CaptureSettingsFragment$$ExternalSyntheticLambda3
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                CaptureSettingsFragment.onViewCreated$lambda$2(this.f$0, view2);
            }
        });
        CaptureSettingsFragmentBinding captureSettingsFragmentBinding9 = this.binding;
        if (captureSettingsFragmentBinding9 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            captureSettingsFragmentBinding9 = null;
        }
        captureSettingsFragmentBinding9.reviewAfterCaptureSettings.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: com.box.android.capture.fragments.CaptureSettingsFragment$$ExternalSyntheticLambda4
            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public final void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                CaptureSettingsFragment.onViewCreated$lambda$3(this.f$0, compoundButton, z);
            }
        });
        CaptureSettingsFragmentBinding captureSettingsFragmentBinding10 = this.binding;
        if (captureSettingsFragmentBinding10 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            captureSettingsFragmentBinding10 = null;
        }
        captureSettingsFragmentBinding10.reviewAfterCaptureContainer.setOnClickListener(new View.OnClickListener() { // from class: com.box.android.capture.fragments.CaptureSettingsFragment$$ExternalSyntheticLambda5
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                CaptureSettingsFragment.onViewCreated$lambda$4(this.f$0, view2);
            }
        });
        CaptureSettingsFragmentBinding captureSettingsFragmentBinding11 = this.binding;
        if (captureSettingsFragmentBinding11 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            captureSettingsFragmentBinding11 = null;
        }
        captureSettingsFragmentBinding11.photoQualityContainer.setOnClickListener(new View.OnClickListener() { // from class: com.box.android.capture.fragments.CaptureSettingsFragment$$ExternalSyntheticLambda6
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                CaptureSettingsFragment.onViewCreated$lambda$5(this.f$0, view2);
            }
        });
        CaptureSettingsFragmentBinding captureSettingsFragmentBinding12 = this.binding;
        if (captureSettingsFragmentBinding12 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            captureSettingsFragmentBinding12 = null;
        }
        captureSettingsFragmentBinding12.videoQualityContainer.setOnClickListener(new View.OnClickListener() { // from class: com.box.android.capture.fragments.CaptureSettingsFragment$$ExternalSyntheticLambda7
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                CaptureSettingsFragment.onViewCreated$lambda$6(this.f$0, view2);
            }
        });
        CaptureSettingsFragmentBinding captureSettingsFragmentBinding13 = this.binding;
        if (captureSettingsFragmentBinding13 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            captureSettingsFragmentBinding13 = null;
        }
        captureSettingsFragmentBinding13.launchIntoCaptureLearnMore.setOnClickListener(new View.OnClickListener() { // from class: com.box.android.capture.fragments.CaptureSettingsFragment$$ExternalSyntheticLambda8
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                CaptureSettingsFragment.onViewCreated$lambda$7(this.f$0, view2);
            }
        });
        CaptureSettingsFragmentBinding captureSettingsFragmentBinding14 = this.binding;
        if (captureSettingsFragmentBinding14 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            captureSettingsFragmentBinding14 = null;
        }
        captureSettingsFragmentBinding14.gpsLocationSetting.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: com.box.android.capture.fragments.CaptureSettingsFragment$$ExternalSyntheticLambda9
            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public final void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                CaptureSettingsFragment.onViewCreated$lambda$8(this.f$0, compoundButton, z);
            }
        });
        CaptureSettingsFragmentBinding captureSettingsFragmentBinding15 = this.binding;
        if (captureSettingsFragmentBinding15 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        } else {
            captureSettingsFragmentBinding2 = captureSettingsFragmentBinding15;
        }
        captureSettingsFragmentBinding2.gpsLocationContainer.setOnClickListener(new View.OnClickListener() { // from class: com.box.android.capture.fragments.CaptureSettingsFragment$$ExternalSyntheticLambda10
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                CaptureSettingsFragment.onViewCreated$lambda$9(this.f$0, view2);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onViewCreated$lambda$0(CaptureSettingsFragment captureSettingsFragment, View view) {
        captureSettingsFragment.requireActivity().getOnBackPressedDispatcher().onBackPressed();
    }

    /* JADX INFO: renamed from: com.box.android.capture.fragments.CaptureSettingsFragment$onViewCreated$2, reason: invalid class name */
    /* JADX INFO: compiled from: CaptureSettingsFragment.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.box.android.capture.fragments.CaptureSettingsFragment$onViewCreated$2", f = "CaptureSettingsFragment.kt", i = {}, l = {127}, m = "invokeSuspend", n = {}, s = {}, v = 1)
    static final class AnonymousClass2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;

        AnonymousClass2(Continuation<? super AnonymousClass2> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return CaptureSettingsFragment.this.new AnonymousClass2(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX INFO: renamed from: com.box.android.capture.fragments.CaptureSettingsFragment$onViewCreated$2$1, reason: invalid class name */
        /* JADX INFO: compiled from: CaptureSettingsFragment.kt */
        @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
        @DebugMetadata(c = "com.box.android.capture.fragments.CaptureSettingsFragment$onViewCreated$2$1", f = "CaptureSettingsFragment.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {}, v = 1)
        static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
            private /* synthetic */ Object L$0;
            int label;
            final /* synthetic */ CaptureSettingsFragment this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            AnonymousClass1(CaptureSettingsFragment captureSettingsFragment, Continuation<? super AnonymousClass1> continuation) {
                super(2, continuation);
                this.this$0 = captureSettingsFragment;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                AnonymousClass1 anonymousClass1 = new AnonymousClass1(this.this$0, continuation);
                anonymousClass1.L$0 = obj;
                return anonymousClass1;
            }

            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object obj) {
                CoroutineScope coroutineScope = (CoroutineScope) this.L$0;
                IntrinsicsKt.getCOROUTINE_SUSPENDED();
                if (this.label == 0) {
                    ResultKt.throwOnFailure(obj);
                    Store store = this.this$0.localStore;
                    if (store == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("localStore");
                        store = null;
                    }
                    FlowKt.launchIn(FlowKt.onEach(FlowExtensionsKt.observe(store.getState(), new PropertyReference1Impl() { // from class: com.box.android.capture.fragments.CaptureSettingsFragment.onViewCreated.2.1.1
                        @Override // kotlin.jvm.internal.PropertyReference1Impl, kotlin.reflect.KProperty1
                        public Object get(Object obj2) {
                            return Boolean.valueOf(((CaptureSettingsReducer.State) obj2).getLaunchIntoCapture());
                        }
                    }), new C01472(this.this$0, null)), coroutineScope);
                    Store store2 = this.this$0.localStore;
                    if (store2 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("localStore");
                        store2 = null;
                    }
                    FlowKt.launchIn(FlowKt.onEach(FlowExtensionsKt.observe(store2.getState(), new PropertyReference1Impl() { // from class: com.box.android.capture.fragments.CaptureSettingsFragment.onViewCreated.2.1.3
                        @Override // kotlin.jvm.internal.PropertyReference1Impl, kotlin.reflect.KProperty1
                        public Object get(Object obj2) {
                            return Boolean.valueOf(((CaptureSettingsReducer.State) obj2).getReviewPhotoAfterCapture());
                        }
                    }), new AnonymousClass4(this.this$0, null)), coroutineScope);
                    Store store3 = this.this$0.localStore;
                    if (store3 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("localStore");
                        store3 = null;
                    }
                    FlowKt.launchIn(FlowKt.onEach(FlowExtensionsKt.observe(store3.getState(), new PropertyReference1Impl() { // from class: com.box.android.capture.fragments.CaptureSettingsFragment.onViewCreated.2.1.5
                        @Override // kotlin.jvm.internal.PropertyReference1Impl, kotlin.reflect.KProperty1
                        public Object get(Object obj2) {
                            return ((CaptureSettingsReducer.State) obj2).getPhotoQuality();
                        }
                    }), new AnonymousClass6(this.this$0, null)), coroutineScope);
                    Store store4 = this.this$0.localStore;
                    if (store4 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("localStore");
                        store4 = null;
                    }
                    FlowKt.launchIn(FlowKt.onEach(FlowExtensionsKt.observe(store4.getState(), new PropertyReference1Impl() { // from class: com.box.android.capture.fragments.CaptureSettingsFragment.onViewCreated.2.1.7
                        @Override // kotlin.jvm.internal.PropertyReference1Impl, kotlin.reflect.KProperty1
                        public Object get(Object obj2) {
                            return ((CaptureSettingsReducer.State) obj2).getVideoQuality();
                        }
                    }), new AnonymousClass8(this.this$0, null)), coroutineScope);
                    Store store5 = this.this$0.localStore;
                    if (store5 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("localStore");
                        store5 = null;
                    }
                    FlowKt.launchIn(FlowKt.onEach(FlowExtensionsKt.observe(store5.getState(), new PropertyReference1Impl() { // from class: com.box.android.capture.fragments.CaptureSettingsFragment.onViewCreated.2.1.9
                        @Override // kotlin.jvm.internal.PropertyReference1Impl, kotlin.reflect.KProperty1
                        public Object get(Object obj2) {
                            return Boolean.valueOf(((CaptureSettingsReducer.State) obj2).getSaveGpsLocation());
                        }
                    }), new AnonymousClass10(this.this$0, null)), coroutineScope);
                    Store store6 = this.this$0.localStore;
                    if (store6 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("localStore");
                        store6 = null;
                    }
                    FlowKt.launchIn(FlowKt.onEach(FlowExtensionsKt.observe(store6.getState(), new PropertyReference1Impl() { // from class: com.box.android.capture.fragments.CaptureSettingsFragment.onViewCreated.2.1.11
                        @Override // kotlin.jvm.internal.PropertyReference1Impl, kotlin.reflect.KProperty1
                        public Object get(Object obj2) {
                            return Boolean.valueOf(((CaptureSettingsReducer.State) obj2).getLaunchIntoCaptureDialog());
                        }
                    }), new AnonymousClass12(this.this$0, null)), coroutineScope);
                    return Unit.INSTANCE;
                }
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }

            /* JADX INFO: renamed from: com.box.android.capture.fragments.CaptureSettingsFragment$onViewCreated$2$1$2, reason: invalid class name and collision with other inner class name */
            /* JADX INFO: compiled from: CaptureSettingsFragment.kt */
            @Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n"}, d2 = {"<anonymous>", "", "launchIntoCapture", ""}, k = 3, mv = {2, 2, 0}, xi = 48)
            @DebugMetadata(c = "com.box.android.capture.fragments.CaptureSettingsFragment$onViewCreated$2$1$2", f = "CaptureSettingsFragment.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {}, v = 1)
            static final class C01472 extends SuspendLambda implements Function2<Boolean, Continuation<? super Unit>, Object> {
                /* synthetic */ boolean Z$0;
                int label;
                final /* synthetic */ CaptureSettingsFragment this$0;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                C01472(CaptureSettingsFragment captureSettingsFragment, Continuation<? super C01472> continuation) {
                    super(2, continuation);
                    this.this$0 = captureSettingsFragment;
                }

                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                    C01472 c01472 = new C01472(this.this$0, continuation);
                    c01472.Z$0 = ((Boolean) obj).booleanValue();
                    return c01472;
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Object invoke(Boolean bool, Continuation<? super Unit> continuation) {
                    return invoke(bool.booleanValue(), continuation);
                }

                public final Object invoke(boolean z, Continuation<? super Unit> continuation) {
                    return ((C01472) create(Boolean.valueOf(z), continuation)).invokeSuspend(Unit.INSTANCE);
                }

                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                public final Object invokeSuspend(Object obj) {
                    boolean z = this.Z$0;
                    IntrinsicsKt.getCOROUTINE_SUSPENDED();
                    if (this.label == 0) {
                        ResultKt.throwOnFailure(obj);
                        CaptureSettingsFragmentBinding captureSettingsFragmentBinding = this.this$0.binding;
                        if (captureSettingsFragmentBinding == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("binding");
                            captureSettingsFragmentBinding = null;
                        }
                        captureSettingsFragmentBinding.launchIntoCapture.setChecked(z);
                        return Unit.INSTANCE;
                    }
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
            }

            /* JADX INFO: renamed from: com.box.android.capture.fragments.CaptureSettingsFragment$onViewCreated$2$1$4, reason: invalid class name */
            /* JADX INFO: compiled from: CaptureSettingsFragment.kt */
            @Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n"}, d2 = {"<anonymous>", "", "reviewAfterPhotoCapture", ""}, k = 3, mv = {2, 2, 0}, xi = 48)
            @DebugMetadata(c = "com.box.android.capture.fragments.CaptureSettingsFragment$onViewCreated$2$1$4", f = "CaptureSettingsFragment.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {}, v = 1)
            static final class AnonymousClass4 extends SuspendLambda implements Function2<Boolean, Continuation<? super Unit>, Object> {
                /* synthetic */ boolean Z$0;
                int label;
                final /* synthetic */ CaptureSettingsFragment this$0;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                AnonymousClass4(CaptureSettingsFragment captureSettingsFragment, Continuation<? super AnonymousClass4> continuation) {
                    super(2, continuation);
                    this.this$0 = captureSettingsFragment;
                }

                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                    AnonymousClass4 anonymousClass4 = new AnonymousClass4(this.this$0, continuation);
                    anonymousClass4.Z$0 = ((Boolean) obj).booleanValue();
                    return anonymousClass4;
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Object invoke(Boolean bool, Continuation<? super Unit> continuation) {
                    return invoke(bool.booleanValue(), continuation);
                }

                public final Object invoke(boolean z, Continuation<? super Unit> continuation) {
                    return ((AnonymousClass4) create(Boolean.valueOf(z), continuation)).invokeSuspend(Unit.INSTANCE);
                }

                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                public final Object invokeSuspend(Object obj) {
                    boolean z = this.Z$0;
                    IntrinsicsKt.getCOROUTINE_SUSPENDED();
                    if (this.label == 0) {
                        ResultKt.throwOnFailure(obj);
                        CaptureSettingsFragmentBinding captureSettingsFragmentBinding = this.this$0.binding;
                        if (captureSettingsFragmentBinding == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("binding");
                            captureSettingsFragmentBinding = null;
                        }
                        captureSettingsFragmentBinding.reviewAfterCaptureSettings.setChecked(z);
                        return Unit.INSTANCE;
                    }
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
            }

            /* JADX INFO: renamed from: com.box.android.capture.fragments.CaptureSettingsFragment$onViewCreated$2$1$6, reason: invalid class name */
            /* JADX INFO: compiled from: CaptureSettingsFragment.kt */
            @Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n"}, d2 = {"<anonymous>", "", "photoQuality", "Lcom/box/android/domain/models/capture/PhotoQuality;"}, k = 3, mv = {2, 2, 0}, xi = 48)
            @DebugMetadata(c = "com.box.android.capture.fragments.CaptureSettingsFragment$onViewCreated$2$1$6", f = "CaptureSettingsFragment.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {}, v = 1)
            static final class AnonymousClass6 extends SuspendLambda implements Function2<PhotoQuality, Continuation<? super Unit>, Object> {
                /* synthetic */ Object L$0;
                int label;
                final /* synthetic */ CaptureSettingsFragment this$0;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                AnonymousClass6(CaptureSettingsFragment captureSettingsFragment, Continuation<? super AnonymousClass6> continuation) {
                    super(2, continuation);
                    this.this$0 = captureSettingsFragment;
                }

                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                    AnonymousClass6 anonymousClass6 = new AnonymousClass6(this.this$0, continuation);
                    anonymousClass6.L$0 = obj;
                    return anonymousClass6;
                }

                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(PhotoQuality photoQuality, Continuation<? super Unit> continuation) {
                    return ((AnonymousClass6) create(photoQuality, continuation)).invokeSuspend(Unit.INSTANCE);
                }

                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                public final Object invokeSuspend(Object obj) {
                    PhotoQuality photoQuality = (PhotoQuality) this.L$0;
                    IntrinsicsKt.getCOROUTINE_SUSPENDED();
                    if (this.label == 0) {
                        ResultKt.throwOnFailure(obj);
                        String photoQualityName = this.this$0.getPhotoQualityName(photoQuality);
                        CaptureSettingsFragmentBinding captureSettingsFragmentBinding = this.this$0.binding;
                        if (captureSettingsFragmentBinding == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("binding");
                            captureSettingsFragmentBinding = null;
                        }
                        captureSettingsFragmentBinding.photoQualitySelected.setText(photoQualityName);
                        return Unit.INSTANCE;
                    }
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
            }

            /* JADX INFO: renamed from: com.box.android.capture.fragments.CaptureSettingsFragment$onViewCreated$2$1$8, reason: invalid class name */
            /* JADX INFO: compiled from: CaptureSettingsFragment.kt */
            @Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n"}, d2 = {"<anonymous>", "", "videoQuality", "Lcom/box/android/domain/models/capture/VideoQuality;"}, k = 3, mv = {2, 2, 0}, xi = 48)
            @DebugMetadata(c = "com.box.android.capture.fragments.CaptureSettingsFragment$onViewCreated$2$1$8", f = "CaptureSettingsFragment.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {}, v = 1)
            static final class AnonymousClass8 extends SuspendLambda implements Function2<VideoQuality, Continuation<? super Unit>, Object> {
                /* synthetic */ Object L$0;
                int label;
                final /* synthetic */ CaptureSettingsFragment this$0;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                AnonymousClass8(CaptureSettingsFragment captureSettingsFragment, Continuation<? super AnonymousClass8> continuation) {
                    super(2, continuation);
                    this.this$0 = captureSettingsFragment;
                }

                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                    AnonymousClass8 anonymousClass8 = new AnonymousClass8(this.this$0, continuation);
                    anonymousClass8.L$0 = obj;
                    return anonymousClass8;
                }

                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(VideoQuality videoQuality, Continuation<? super Unit> continuation) {
                    return ((AnonymousClass8) create(videoQuality, continuation)).invokeSuspend(Unit.INSTANCE);
                }

                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                public final Object invokeSuspend(Object obj) {
                    VideoQuality videoQuality = (VideoQuality) this.L$0;
                    IntrinsicsKt.getCOROUTINE_SUSPENDED();
                    if (this.label == 0) {
                        ResultKt.throwOnFailure(obj);
                        String videoQualityName = this.this$0.getVideoQualityName(videoQuality);
                        CaptureSettingsFragmentBinding captureSettingsFragmentBinding = this.this$0.binding;
                        if (captureSettingsFragmentBinding == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("binding");
                            captureSettingsFragmentBinding = null;
                        }
                        captureSettingsFragmentBinding.videoQualitySelected.setText(videoQualityName);
                        return Unit.INSTANCE;
                    }
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
            }

            /* JADX INFO: renamed from: com.box.android.capture.fragments.CaptureSettingsFragment$onViewCreated$2$1$10, reason: invalid class name */
            /* JADX INFO: compiled from: CaptureSettingsFragment.kt */
            @Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n"}, d2 = {"<anonymous>", "", "saveGpsLocation", ""}, k = 3, mv = {2, 2, 0}, xi = 48)
            @DebugMetadata(c = "com.box.android.capture.fragments.CaptureSettingsFragment$onViewCreated$2$1$10", f = "CaptureSettingsFragment.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {}, v = 1)
            static final class AnonymousClass10 extends SuspendLambda implements Function2<Boolean, Continuation<? super Unit>, Object> {
                /* synthetic */ boolean Z$0;
                int label;
                final /* synthetic */ CaptureSettingsFragment this$0;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                AnonymousClass10(CaptureSettingsFragment captureSettingsFragment, Continuation<? super AnonymousClass10> continuation) {
                    super(2, continuation);
                    this.this$0 = captureSettingsFragment;
                }

                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                    AnonymousClass10 anonymousClass10 = new AnonymousClass10(this.this$0, continuation);
                    anonymousClass10.Z$0 = ((Boolean) obj).booleanValue();
                    return anonymousClass10;
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Object invoke(Boolean bool, Continuation<? super Unit> continuation) {
                    return invoke(bool.booleanValue(), continuation);
                }

                public final Object invoke(boolean z, Continuation<? super Unit> continuation) {
                    return ((AnonymousClass10) create(Boolean.valueOf(z), continuation)).invokeSuspend(Unit.INSTANCE);
                }

                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                public final Object invokeSuspend(Object obj) {
                    boolean z = this.Z$0;
                    IntrinsicsKt.getCOROUTINE_SUSPENDED();
                    if (this.label == 0) {
                        ResultKt.throwOnFailure(obj);
                        CaptureSettingsFragmentBinding captureSettingsFragmentBinding = this.this$0.binding;
                        if (captureSettingsFragmentBinding == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("binding");
                            captureSettingsFragmentBinding = null;
                        }
                        captureSettingsFragmentBinding.gpsLocationSetting.setChecked(z);
                        return Unit.INSTANCE;
                    }
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
            }

            /* JADX INFO: renamed from: com.box.android.capture.fragments.CaptureSettingsFragment$onViewCreated$2$1$12, reason: invalid class name */
            /* JADX INFO: compiled from: CaptureSettingsFragment.kt */
            @Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n"}, d2 = {"<anonymous>", "", "showDialog", ""}, k = 3, mv = {2, 2, 0}, xi = 48)
            @DebugMetadata(c = "com.box.android.capture.fragments.CaptureSettingsFragment$onViewCreated$2$1$12", f = "CaptureSettingsFragment.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {}, v = 1)
            static final class AnonymousClass12 extends SuspendLambda implements Function2<Boolean, Continuation<? super Unit>, Object> {
                /* synthetic */ boolean Z$0;
                int label;
                final /* synthetic */ CaptureSettingsFragment this$0;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                AnonymousClass12(CaptureSettingsFragment captureSettingsFragment, Continuation<? super AnonymousClass12> continuation) {
                    super(2, continuation);
                    this.this$0 = captureSettingsFragment;
                }

                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                    AnonymousClass12 anonymousClass12 = new AnonymousClass12(this.this$0, continuation);
                    anonymousClass12.Z$0 = ((Boolean) obj).booleanValue();
                    return anonymousClass12;
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Object invoke(Boolean bool, Continuation<? super Unit> continuation) {
                    return invoke(bool.booleanValue(), continuation);
                }

                public final Object invoke(boolean z, Continuation<? super Unit> continuation) {
                    return ((AnonymousClass12) create(Boolean.valueOf(z), continuation)).invokeSuspend(Unit.INSTANCE);
                }

                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                public final Object invokeSuspend(Object obj) {
                    boolean z = this.Z$0;
                    IntrinsicsKt.getCOROUTINE_SUSPENDED();
                    if (this.label != 0) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    ResultKt.throwOnFailure(obj);
                    if (z) {
                        this.this$0.showLaunchIntoCaptureDialog();
                        Store store = this.this$0.localStore;
                        if (store == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("localStore");
                            store = null;
                        }
                        store.send(CaptureSettingsReducer.Action.LaunchIntoCaptureDialogShown.INSTANCE);
                    }
                    return Unit.INSTANCE;
                }
            }
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                LifecycleOwner viewLifecycleOwner = CaptureSettingsFragment.this.getViewLifecycleOwner();
                Intrinsics.checkNotNullExpressionValue(viewLifecycleOwner, "getViewLifecycleOwner(...)");
                this.label = 1;
                if (RepeatOnLifecycleKt.repeatOnLifecycle(viewLifecycleOwner, Lifecycle.State.CREATED, new AnonymousClass1(CaptureSettingsFragment.this, null), this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
            return Unit.INSTANCE;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onViewCreated$lambda$1(CaptureSettingsFragment captureSettingsFragment, View view) {
        Store<CaptureSettingsReducer.State, CaptureSettingsReducer.Action> store = captureSettingsFragment.localStore;
        if (store == null) {
            Intrinsics.throwUninitializedPropertyAccessException("localStore");
            store = null;
        }
        store.send(CaptureSettingsReducer.Action.ToggleLaunchIntoCapture.INSTANCE);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onViewCreated$lambda$2(CaptureSettingsFragment captureSettingsFragment, View view) {
        CaptureSettingsFragmentBinding captureSettingsFragmentBinding = captureSettingsFragment.binding;
        if (captureSettingsFragmentBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            captureSettingsFragmentBinding = null;
        }
        captureSettingsFragmentBinding.launchIntoCapture.performClick();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onViewCreated$lambda$3(CaptureSettingsFragment captureSettingsFragment, CompoundButton compoundButton, boolean z) {
        String str;
        Intrinsics.checkNotNullParameter(compoundButton, "<unused var>");
        Store<CaptureSettingsReducer.State, CaptureSettingsReducer.Action> store = captureSettingsFragment.localStore;
        if (store == null) {
            Intrinsics.throwUninitializedPropertyAccessException("localStore");
            store = null;
        }
        store.send(new CaptureSettingsReducer.Action.ToggleReviewPhotoAfterCapture(z));
        BoxAmplitudeAnalytics.EventPropertyBuilder eventPropertyBuilderCreateEventBuilder = BoxAmplitudeAnalytics.createEventBuilder();
        if (z) {
            str = BoxAnalyticsParams.CAPTURE_SETTINGS_PHOTO_REVIEW_AFTER_CAPTURE_ENABLED;
        } else {
            str = BoxAnalyticsParams.CAPTURE_SETTINGS_PHOTO_REVIEW_AFTER_CAPTURE_DISABLED;
        }
        eventPropertyBuilderCreateEventBuilder.logEvent(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onViewCreated$lambda$4(CaptureSettingsFragment captureSettingsFragment, View view) {
        CaptureSettingsFragmentBinding captureSettingsFragmentBinding = captureSettingsFragment.binding;
        if (captureSettingsFragmentBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            captureSettingsFragmentBinding = null;
        }
        captureSettingsFragmentBinding.reviewAfterCaptureSettings.performClick();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onViewCreated$lambda$5(CaptureSettingsFragment captureSettingsFragment, View view) {
        Store<CaptureSettingsReducer.State, CaptureSettingsReducer.Action> store = captureSettingsFragment.localStore;
        if (store == null) {
            Intrinsics.throwUninitializedPropertyAccessException("localStore");
            store = null;
        }
        captureSettingsFragment.showSelectPhotoQualityDialog(store.getState().getValue().getPhotoQuality());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onViewCreated$lambda$6(CaptureSettingsFragment captureSettingsFragment, View view) {
        Store<CaptureSettingsReducer.State, CaptureSettingsReducer.Action> store = captureSettingsFragment.localStore;
        if (store == null) {
            Intrinsics.throwUninitializedPropertyAccessException("localStore");
            store = null;
        }
        captureSettingsFragment.showSelectedVideoQualityDialog(store.getState().getValue().getVideoQuality());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onViewCreated$lambda$7(CaptureSettingsFragment captureSettingsFragment, View view) {
        BoxAmplitudeAnalytics.createEventBuilder().logEvent(BoxAnalyticsParams.EVENT_CAPTURE_MODE_LEARN_MORE);
        captureSettingsFragment.startActivity(new Intent("android.intent.action.VIEW", Uri.parse(LEARN_MORE_LINK)));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onViewCreated$lambda$8(CaptureSettingsFragment captureSettingsFragment, CompoundButton compoundButton, boolean z) {
        String str;
        Intrinsics.checkNotNullParameter(compoundButton, "<unused var>");
        Store<CaptureSettingsReducer.State, CaptureSettingsReducer.Action> store = captureSettingsFragment.localStore;
        ActivityResultLauncher<String> activityResultLauncher = null;
        if (store == null) {
            Intrinsics.throwUninitializedPropertyAccessException("localStore");
            store = null;
        }
        store.send(new CaptureSettingsReducer.Action.ToggleGpsLocation(z));
        BoxAmplitudeAnalytics.EventPropertyBuilder eventPropertyBuilderCreateEventBuilder = BoxAmplitudeAnalytics.createEventBuilder();
        if (z) {
            str = BoxAnalyticsParams.CAPTURE_SETTINGS_PHOTO_GPS_LOCATION_ENABLED;
        } else {
            str = BoxAnalyticsParams.CAPTURE_SETTINGS_PHOTO_GPS_LOCATION_DISABLED;
        }
        eventPropertyBuilderCreateEventBuilder.logEvent(str);
        if (!z || ContextCompat.checkSelfPermission(captureSettingsFragment.requireContext(), "android.permission.ACCESS_FINE_LOCATION") == 0) {
            return;
        }
        ActivityResultLauncher<String> activityResultLauncher2 = captureSettingsFragment.requestPermissionLauncher;
        if (activityResultLauncher2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("requestPermissionLauncher");
        } else {
            activityResultLauncher = activityResultLauncher2;
        }
        activityResultLauncher.launch("android.permission.ACCESS_FINE_LOCATION");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onViewCreated$lambda$9(CaptureSettingsFragment captureSettingsFragment, View view) {
        CaptureSettingsFragmentBinding captureSettingsFragmentBinding = captureSettingsFragment.binding;
        if (captureSettingsFragmentBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            captureSettingsFragmentBinding = null;
        }
        captureSettingsFragmentBinding.gpsLocationSetting.performClick();
    }

    private final void showPermissionDialog() {
        MaterialAlertDialogBuilder materialAlertDialogBuilder = new MaterialAlertDialogBuilder(requireContext());
        materialAlertDialogBuilder.setMessage((CharSequence) getString(R.string.location_permission_permanently_denied));
        materialAlertDialogBuilder.setTitle(R.string.job_item_error_type_permission);
        materialAlertDialogBuilder.setPositiveButton(R.string.account_settings, new DialogInterface.OnClickListener() { // from class: com.box.android.capture.fragments.CaptureSettingsFragment$$ExternalSyntheticLambda17
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i) {
                CaptureSettingsFragment.showPermissionDialog$lambda$0(this.f$0, dialogInterface, i);
            }
        });
        materialAlertDialogBuilder.setNegativeButton(R.string.dismiss, new DialogInterface.OnClickListener() { // from class: com.box.android.capture.fragments.CaptureSettingsFragment$$ExternalSyntheticLambda18
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.dismiss();
            }
        });
        materialAlertDialogBuilder.setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: com.box.android.capture.fragments.CaptureSettingsFragment$$ExternalSyntheticLambda19
            @Override // android.content.DialogInterface.OnDismissListener
            public final void onDismiss(DialogInterface dialogInterface) {
                CaptureSettingsFragment.showPermissionDialog$lambda$2(this.f$0, dialogInterface);
            }
        });
        materialAlertDialogBuilder.create().show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void showPermissionDialog$lambda$0(CaptureSettingsFragment captureSettingsFragment, DialogInterface dialogInterface, int i) {
        IntentUtils intentUtils = IntentUtils.INSTANCE;
        FragmentActivity fragmentActivityRequireActivity = captureSettingsFragment.requireActivity();
        Intrinsics.checkNotNullExpressionValue(fragmentActivityRequireActivity, "requireActivity(...)");
        Intent applicationSettingsIntent = intentUtils.getApplicationSettingsIntent(fragmentActivityRequireActivity);
        ActivityResultLauncher<Intent> activityResultLauncher = captureSettingsFragment.settingsLauncher;
        if (activityResultLauncher == null) {
            Intrinsics.throwUninitializedPropertyAccessException("settingsLauncher");
            activityResultLauncher = null;
        }
        activityResultLauncher.launch(applicationSettingsIntent);
        dialogInterface.dismiss();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void showPermissionDialog$lambda$2(CaptureSettingsFragment captureSettingsFragment, DialogInterface dialogInterface) {
        Store<CaptureSettingsReducer.State, CaptureSettingsReducer.Action> store = captureSettingsFragment.localStore;
        if (store == null) {
            Intrinsics.throwUninitializedPropertyAccessException("localStore");
            store = null;
        }
        store.send(new CaptureSettingsReducer.Action.ToggleGpsLocation(false));
    }

    private final void showSelectPhotoQualityDialog(PhotoQuality selectedPhotoQuality) {
        int i;
        MaterialAlertDialogBuilder positiveButton = new MaterialAlertDialogBuilder(requireContext()).setTitle((CharSequence) getString(R.string.settings_capture_review_photo_quality)).setView(R.layout.photo_quality_list_dialog).setPositiveButton(R.string.alert_dialog_cancel, new DialogInterface.OnClickListener() { // from class: com.box.android.capture.fragments.CaptureSettingsFragment$$ExternalSyntheticLambda20
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i2) {
                CaptureSettingsFragment.showSelectPhotoQualityDialog$lambda$0(dialogInterface, i2);
            }
        });
        Intrinsics.checkNotNullExpressionValue(positiveButton, "setPositiveButton(...)");
        final AlertDialog alertDialogShow = positiveButton.show();
        RadioGroup radioGroup = (RadioGroup) alertDialogShow.findViewById(R.id.quality_group);
        if (radioGroup != null) {
            int i2 = WhenMappings.$EnumSwitchMapping$0[selectedPhotoQuality.ordinal()];
            if (i2 == 1) {
                i = R.id.original_quality;
            } else if (i2 == 2) {
                i = R.id.large_quality;
            } else if (i2 == 3) {
                i = R.id.medium_quality;
            } else {
                if (i2 != 4) {
                    throw new NoWhenBranchMatchedException();
                }
                i = R.id.small_quality;
            }
            radioGroup.check(i);
        }
        if (radioGroup != null) {
            radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() { // from class: com.box.android.capture.fragments.CaptureSettingsFragment$$ExternalSyntheticLambda21
                @Override // android.widget.RadioGroup.OnCheckedChangeListener
                public final void onCheckedChanged(RadioGroup radioGroup2, int i3) {
                    CaptureSettingsFragment.showSelectPhotoQualityDialog$lambda$1(this.f$0, alertDialogShow, radioGroup2, i3);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void showSelectPhotoQualityDialog$lambda$0(DialogInterface dialog, int i) {
        Intrinsics.checkNotNullParameter(dialog, "dialog");
        dialog.dismiss();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void showSelectPhotoQualityDialog$lambda$1(CaptureSettingsFragment captureSettingsFragment, AlertDialog alertDialog, RadioGroup radioGroup, int i) {
        PhotoQuality photoQuality;
        Intrinsics.checkNotNullParameter(radioGroup, "<unused var>");
        if (i == R.id.large_quality) {
            photoQuality = PhotoQuality.LARGE;
        } else if (i == R.id.medium_quality) {
            photoQuality = PhotoQuality.MEDIUM;
        } else if (i == R.id.small_quality) {
            photoQuality = PhotoQuality.SMALL;
        } else {
            photoQuality = i == R.id.original_quality ? PhotoQuality.ORIGINAL : PhotoQuality.ORIGINAL;
        }
        Store<CaptureSettingsReducer.State, CaptureSettingsReducer.Action> store = captureSettingsFragment.localStore;
        if (store == null) {
            Intrinsics.throwUninitializedPropertyAccessException("localStore");
            store = null;
        }
        store.send(new CaptureSettingsReducer.Action.SelectPhotoQuality(photoQuality));
        BoxAmplitudeAnalytics.createCaptureSettingsEventBuilder().logPhotoQuality(captureSettingsFragment.getPhotoQualityName(photoQuality));
        alertDialog.dismiss();
    }

    private final void showSelectedVideoQualityDialog(VideoQuality selectedVideoQuality) {
        int i;
        MaterialAlertDialogBuilder positiveButton = new MaterialAlertDialogBuilder(requireContext()).setTitle((CharSequence) getString(R.string.settings_capture_review_video_quality)).setView(R.layout.video_quality_list_dialog).setPositiveButton(R.string.alert_dialog_cancel, new DialogInterface.OnClickListener() { // from class: com.box.android.capture.fragments.CaptureSettingsFragment$$ExternalSyntheticLambda12
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i2) {
                CaptureSettingsFragment.showSelectedVideoQualityDialog$lambda$0(dialogInterface, i2);
            }
        });
        Intrinsics.checkNotNullExpressionValue(positiveButton, "setPositiveButton(...)");
        final AlertDialog alertDialogShow = positiveButton.show();
        RadioGroup radioGroup = (RadioGroup) alertDialogShow.findViewById(R.id.quality_group);
        if (radioGroup != null) {
            int i2 = WhenMappings.$EnumSwitchMapping$1[selectedVideoQuality.ordinal()];
            if (i2 == 1) {
                i = R.id.quality_720p;
            } else if (i2 == 2) {
                i = R.id.quality_1080p;
            } else {
                if (i2 != 3) {
                    throw new NoWhenBranchMatchedException();
                }
                i = R.id.quality_4k;
            }
            radioGroup.check(i);
        }
        if (radioGroup != null) {
            radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() { // from class: com.box.android.capture.fragments.CaptureSettingsFragment$$ExternalSyntheticLambda13
                @Override // android.widget.RadioGroup.OnCheckedChangeListener
                public final void onCheckedChanged(RadioGroup radioGroup2, int i3) {
                    CaptureSettingsFragment.showSelectedVideoQualityDialog$lambda$1(this.f$0, alertDialogShow, radioGroup2, i3);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void showSelectedVideoQualityDialog$lambda$0(DialogInterface dialog, int i) {
        Intrinsics.checkNotNullParameter(dialog, "dialog");
        dialog.dismiss();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void showSelectedVideoQualityDialog$lambda$1(CaptureSettingsFragment captureSettingsFragment, AlertDialog alertDialog, RadioGroup radioGroup, int i) {
        VideoQuality videoQuality;
        Intrinsics.checkNotNullParameter(radioGroup, "<unused var>");
        if (i == R.id.quality_720p) {
            videoQuality = VideoQuality.QUALITY_720P;
        } else {
            videoQuality = (i != R.id.quality_1080p && i == R.id.quality_4k) ? VideoQuality.QUALITY_4K : VideoQuality.QUALITY_1080P;
        }
        Store<CaptureSettingsReducer.State, CaptureSettingsReducer.Action> store = captureSettingsFragment.localStore;
        if (store == null) {
            Intrinsics.throwUninitializedPropertyAccessException("localStore");
            store = null;
        }
        store.send(new CaptureSettingsReducer.Action.SelectVideoQuality(videoQuality));
        BoxAmplitudeAnalytics.createCaptureSettingsEventBuilder().logVideoQuality(captureSettingsFragment.getVideoQualityName(videoQuality));
        alertDialog.dismiss();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void showLaunchIntoCaptureDialog() {
        MaterialAlertDialogBuilder negativeButton = new MaterialAlertDialogBuilder(requireContext()).setTitle((CharSequence) getString(R.string.settings_launch_into_capture_dialog_title)).setMessage((CharSequence) getString(R.string.settings_launch_into_capture_dialog_message)).setPositiveButton((CharSequence) getString(R.string.settings_launch_into_capture_dialog_positive_text), new DialogInterface.OnClickListener() { // from class: com.box.android.capture.fragments.CaptureSettingsFragment$$ExternalSyntheticLambda15
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i) {
                CaptureSettingsFragment.showLaunchIntoCaptureDialog$lambda$0(this.f$0, dialogInterface, i);
            }
        }).setNegativeButton((CharSequence) getString(R.string.settings_launch_into_capture_dialog_negative_text), new DialogInterface.OnClickListener() { // from class: com.box.android.capture.fragments.CaptureSettingsFragment$$ExternalSyntheticLambda16
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i) {
                CaptureSettingsFragment.showLaunchIntoCaptureDialog$lambda$1(dialogInterface, i);
            }
        });
        Intrinsics.checkNotNullExpressionValue(negativeButton, "setNegativeButton(...)");
        negativeButton.create().show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void showLaunchIntoCaptureDialog$lambda$0(CaptureSettingsFragment captureSettingsFragment, DialogInterface dialog, int i) {
        Intrinsics.checkNotNullParameter(dialog, "dialog");
        BoxAmplitudeAnalytics.createEventBuilder().logEvent(BoxAnalyticsParams.EVENT_CAPTURE_MODE_ENTER_FROM_SETTINGS);
        dialog.dismiss();
        captureSettingsFragment.startActivity(new Intent(captureSettingsFragment.getContext(), (Class<?>) CaptureActivity.class));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void showLaunchIntoCaptureDialog$lambda$1(DialogInterface dialog, int i) {
        Intrinsics.checkNotNullParameter(dialog, "dialog");
        BoxAmplitudeAnalytics.createEventBuilder().logEvent(BoxAnalyticsParams.EVENT_CAPTURE_MODE_DISMISS_FROM_SETTINGS);
        dialog.dismiss();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final String getPhotoQualityName(PhotoQuality photoQuality) {
        int i;
        int i2 = WhenMappings.$EnumSwitchMapping$0[photoQuality.ordinal()];
        if (i2 == 1) {
            i = R.string.photo_quality_original;
        } else if (i2 == 2) {
            i = R.string.photo_quality_large;
        } else if (i2 == 3) {
            i = R.string.photo_quality_medium;
        } else {
            if (i2 != 4) {
                throw new NoWhenBranchMatchedException();
            }
            i = R.string.photo_quality_small;
        }
        String string = getString(i);
        Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
        return string;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final String getVideoQualityName(VideoQuality videoQuality) {
        int i;
        int i2 = WhenMappings.$EnumSwitchMapping$1[videoQuality.ordinal()];
        if (i2 == 1) {
            i = R.string.video_quality_720p_at_30fps;
        } else if (i2 == 2) {
            i = R.string.video_quality_1080p_at_30fps;
        } else {
            if (i2 != 3) {
                throw new NoWhenBranchMatchedException();
            }
            i = R.string.video_quality_4k_at_30fps;
        }
        String string = getString(i);
        Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
        return string;
    }

    /* JADX INFO: compiled from: CaptureSettingsFragment.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0082\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Lcom/box/android/capture/fragments/CaptureSettingsFragment$Companion;", "", "<init>", "()V", "LEARN_MORE_LINK", "", "capture_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    private static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }
}
