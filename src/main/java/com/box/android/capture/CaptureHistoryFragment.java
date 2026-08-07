package com.box.android.capture;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.ActionMode;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import androidx.activity.OnBackPressedCallback;
import androidx.activity.OnBackPressedDispatcher;
import androidx.activity.OnBackPressedDispatcherKt;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.KeyEventDispatcher;
import androidx.exifinterface.media.ExifInterface;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.lifecycle.HasDefaultViewModelProviderFactory;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStore;
import androidx.lifecycle.ViewModelStoreOwner;
import androidx.lifecycle.viewmodel.CreationExtras;
import androidx.recyclerview.widget.ConcatAdapter;
import androidx.recyclerview.widget.RecyclerView;
import com.box.android.base.databinding.FragmentItemListingBinding;
import com.box.android.base.presentation.ThumbnailManager;
import com.box.android.base.presentation.fragments.BaseListingAbstractFragment;
import com.box.android.base.presentation.fragments.models.BottomSheetAttributes;
import com.box.android.base.presentation.presenters.BaseListingPresenter;
import com.box.android.base.presentation.utilities.HeaderActionListener;
import com.box.android.base.presentation.utilities.ItemActionListener;
import com.box.android.base.presentation.views.ToolbarWithOverlayWarning;
import com.box.android.browse.cpl.itempicker.ItemPickerActivity;
import com.box.android.capture.activities.CaptureActivity;
import com.box.android.capture.adapter.PendingCaptureFilesAdapter;
import com.box.android.capture.adapter.UploadedCaptureFilesAdapter;
import com.box.android.capture.viewmodel.CaptureHistoryViewModel;
import com.box.android.capture.viewmodel.CaptureViewModel;
import com.box.android.common.utilities.CommonBoxUtil;
import com.box.android.common.utilities.FlowExtensionsKt;
import com.box.android.coreservices.modelcontroller.messages.BoxMessage;
import com.box.android.coreservices.models.BoxModelOfflineManagerWrapper;
import com.box.android.domain.analytics.BoxAnalyticsParams;
import com.box.android.domain.configuration.FeatureFlips;
import com.box.android.domain.identity.IUserContextManager;
import com.box.android.domain.mappers.FolderModelMapper;
import com.box.android.domain.models.CaptureHistoryModel;
import com.box.android.domain.models.ItemId;
import com.box.android.domain.models.JobInfo;
import com.box.android.domain.models.item.FileModel;
import com.box.android.domain.models.item.FolderModel;
import com.box.android.domain.services.IOfflineService;
import com.box.android.observability.DiagnosisParams;
import com.box.androidsdk.content.models.BoxFolder;
import dagger.hilt.android.AndroidEntryPoint;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import javax.inject.Inject;
import kotlin.Deprecated;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.SetsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlinx.coroutines.BuildersKt__BuildersKt;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.internal.CombineKt;

/* JADX INFO: compiled from: CaptureHistoryFragment.kt */
/* JADX INFO: loaded from: classes10.dex */
@Metadata(d1 = {"\u0000î\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\b\u0007\u0018\u0000 }2\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0002}~B\u0007¢\u0006\u0004\b\u0004\u0010\u0005J\u0012\u0010;\u001a\u00020<2\b\u0010=\u001a\u0004\u0018\u00010>H\u0016J\u001a\u0010?\u001a\u00020<2\u0006\u0010@\u001a\u00020A2\b\u0010=\u001a\u0004\u0018\u00010>H\u0016J\"\u0010B\u001a\u00020<2\u0006\u0010C\u001a\u00020D2\u0006\u0010E\u001a\u00020D2\b\u0010F\u001a\u0004\u0018\u00010GH\u0017J\b\u0010H\u001a\u00020<H\u0002J\u0018\u0010I\u001a\u00020<2\u0006\u0010J\u001a\u00020K2\u0006\u0010L\u001a\u00020MH\u0017J\u0010\u0010N\u001a\u00020<2\u0006\u0010J\u001a\u00020KH\u0017J\u0010\u0010O\u001a\u0002062\u0006\u0010P\u001a\u00020QH\u0017J\b\u0010R\u001a\u00020<H\u0016J\b\u0010S\u001a\u00020DH\u0016J\b\u0010T\u001a\u00020UH\u0016J\u0012\u0010V\u001a\u00020U2\b\u0010W\u001a\u0004\u0018\u00010XH\u0016J\b\u0010Y\u001a\u00020UH\u0016J\b\u0010Z\u001a\u00020<H\u0016J\b\u0010[\u001a\u000206H\u0016J\u0016\u0010\\\u001a\u0002062\f\u0010]\u001a\b\u0012\u0002\b\u0003\u0018\u00010^H\u0017J \u0010_\u001a\u001a\u0012\u0004\u0012\u00020\u0002\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u00010`H\u0014J\u0010\u0010a\u001a\u00020<2\u0006\u0010P\u001a\u00020bH\u0002J\u0018\u0010c\u001a\u00020<2\u0006\u0010P\u001a\u00020b2\u0006\u0010d\u001a\u00020eH\u0002J\f\u0010f\u001a\u0006\u0012\u0002\b\u00030gH\u0014JP\u0010h\u001a\u00020<2\u0016\u0010i\u001a\u0012\u0012\u0004\u0012\u00020D\u0012\u0004\u0012\u00020<0jj\u0002`k2\u0016\u0010l\u001a\u0012\u0012\u0004\u0012\u00020D\u0012\u0004\u0012\u00020<0jj\u0002`k2\u0016\u0010m\u001a\u0012\u0012\u0004\u0012\u00020D\u0012\u0004\u0012\u00020<0jj\u0002`kH\u0016J\u0016\u0010n\u001a\u00020<2\f\u0010o\u001a\b\u0012\u0004\u0012\u00020\u00020pH\u0016J\u0014\u0010w\u001a\u00020<2\f\u0010o\u001a\b\u0012\u0004\u0012\u00020\u00020pJ\u0014\u0010x\u001a\u00020<2\f\u0010o\u001a\b\u0012\u0004\u0012\u00020\u00020pJ\u000e\u0010y\u001a\u00020<2\u0006\u0010z\u001a\u000206J\b\u0010{\u001a\u00020<H\u0016J\b\u0010|\u001a\u00020<H\u0016R\u001e\u0010\u0006\u001a\u00020\u00078\u0006@\u0006X\u0087.¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u001e\u0010\f\u001a\u00020\r8\u0006@\u0006X\u0087.¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u001e\u0010\u0012\u001a\u00020\u00138\u0006@\u0006X\u0087.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\u001e\u0010\u0018\u001a\u00020\u00198\u0006@\u0006X\u0087.¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR\u001e\u0010\u001e\u001a\u00020\u001f8\u0006@\u0006X\u0087.¢\u0006\u000e\n\u0000\u001a\u0004\b \u0010!\"\u0004\b\"\u0010#R\u001b\u0010$\u001a\u00020%8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b(\u0010)\u001a\u0004\b&\u0010'R\u001b\u0010*\u001a\u00020+8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b.\u0010)\u001a\u0004\b,\u0010-R\u000e\u0010/\u001a\u000200X\u0082.¢\u0006\u0002\n\u0000R\u000e\u00101\u001a\u000202X\u0082.¢\u0006\u0002\n\u0000R\u0012\u00103\u001a\u000604R\u00020\u0000X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u00105\u001a\u000206X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b7\u00108\"\u0004\b9\u0010:R\u001c\u0010q\u001a\u0004\u0018\u00010rX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bs\u0010t\"\u0004\bu\u0010v¨\u0006\u007f"}, d2 = {"Lcom/box/android/capture/CaptureHistoryFragment;", "Lcom/box/android/base/presentation/fragments/BaseListingAbstractFragment;", "Lcom/box/android/domain/models/CaptureHistoryModel;", "Lcom/box/android/base/databinding/FragmentItemListingBinding;", "<init>", "()V", "thumbnailManager", "Lcom/box/android/base/presentation/ThumbnailManager;", "getThumbnailManager", "()Lcom/box/android/base/presentation/ThumbnailManager;", "setThumbnailManager", "(Lcom/box/android/base/presentation/ThumbnailManager;)V", "featureFlips", "Lcom/box/android/domain/configuration/FeatureFlips;", "getFeatureFlips", "()Lcom/box/android/domain/configuration/FeatureFlips;", "setFeatureFlips", "(Lcom/box/android/domain/configuration/FeatureFlips;)V", "userContextManager", "Lcom/box/android/domain/identity/IUserContextManager;", "getUserContextManager", "()Lcom/box/android/domain/identity/IUserContextManager;", "setUserContextManager", "(Lcom/box/android/domain/identity/IUserContextManager;)V", "offlineService", "Lcom/box/android/domain/services/IOfflineService;", "getOfflineService", "()Lcom/box/android/domain/services/IOfflineService;", "setOfflineService", "(Lcom/box/android/domain/services/IOfflineService;)V", "offlineManagerWrapper", "Lcom/box/android/coreservices/models/BoxModelOfflineManagerWrapper;", "getOfflineManagerWrapper", "()Lcom/box/android/coreservices/models/BoxModelOfflineManagerWrapper;", "setOfflineManagerWrapper", "(Lcom/box/android/coreservices/models/BoxModelOfflineManagerWrapper;)V", "captureViewModel", "Lcom/box/android/capture/viewmodel/CaptureViewModel;", "getCaptureViewModel", "()Lcom/box/android/capture/viewmodel/CaptureViewModel;", "captureViewModel$delegate", "Lkotlin/Lazy;", "captureHistoryViewModel", "Lcom/box/android/capture/viewmodel/CaptureHistoryViewModel;", "getCaptureHistoryViewModel", "()Lcom/box/android/capture/viewmodel/CaptureHistoryViewModel;", "captureHistoryViewModel$delegate", "uploadedCaptureFilesAdapter", "Lcom/box/android/capture/adapter/UploadedCaptureFilesAdapter;", "pendingCaptureFilesAdapter", "Lcom/box/android/capture/adapter/PendingCaptureFilesAdapter;", "multiSelectHandler", "Lcom/box/android/capture/CaptureHistoryFragment$MultiSelectHandler;", "hasFailedJobs", "", "getHasFailedJobs", "()Z", "setHasFailedJobs", "(Z)V", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "onViewCreated", "view", "Landroid/view/View;", "onActivityResult", "requestCode", "", "resultCode", "data", "Landroid/content/Intent;", "initToolbar", "onCreateOptionsMenu", "menu", "Landroid/view/Menu;", "inflater", "Landroid/view/MenuInflater;", "onPrepareOptionsMenu", "onOptionsItemSelected", "item", "Landroid/view/MenuItem;", "onRefresh", "getType", "getGenericId", "", "getTitle", "context", "Landroid/content/Context;", "getAmplitudePageName", "onAddFabClicked", "isAddFabAvailable", "shouldUpdateFragment", "message", "Lcom/box/android/coreservices/modelcontroller/messages/BoxMessage;", "createPresenter", "Lcom/box/android/base/presentation/presenters/BaseListingPresenter;", "onItemClick", "Lcom/box/android/domain/models/item/FileModel;", "showBottomSheet", "type", "Lcom/box/android/base/presentation/fragments/models/BottomSheetAttributes$BottomSheetMenuType;", "createAdapter", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "setupEmptyView", "emptyImageSetter", "Lkotlin/Function1;", "Lcom/box/android/base/presentation/fragments/ResourceSetter;", "emptyTextSetter", "emptySubtextSetter", "renderNewList", "newList", "", "failedJobsObserver", "Lkotlinx/coroutines/Job;", "getFailedJobsObserver", "()Lkotlinx/coroutines/Job;", "setFailedJobsObserver", "(Lkotlinx/coroutines/Job;)V", "updatePendingFiles", "updateUploadedFiles", "updateChangeFolderBanner", "hasError", "onResume", "onDestroy", "Companion", "MultiSelectHandler", "capture_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
@AndroidEntryPoint
public final class CaptureHistoryFragment extends Hilt_CaptureHistoryFragment<CaptureHistoryModel, FragmentItemListingBinding> {
    private static final int SELECT_FOLDER_REQUEST = 100;

    /* JADX INFO: renamed from: captureHistoryViewModel$delegate, reason: from kotlin metadata */
    private final Lazy captureHistoryViewModel;

    /* JADX INFO: renamed from: captureViewModel$delegate, reason: from kotlin metadata */
    private final Lazy captureViewModel;
    private Job failedJobsObserver;

    @Inject
    public FeatureFlips featureFlips;
    private boolean hasFailedJobs;
    private final MultiSelectHandler multiSelectHandler;

    @Inject
    public BoxModelOfflineManagerWrapper offlineManagerWrapper;

    @Inject
    public IOfflineService offlineService;
    private PendingCaptureFilesAdapter pendingCaptureFilesAdapter;

    @Inject
    public ThumbnailManager thumbnailManager;
    private UploadedCaptureFilesAdapter uploadedCaptureFilesAdapter;

    @Inject
    public IUserContextManager userContextManager;
    public static final int $stable = 8;

    @Override // com.box.android.base.presentation.BoxFragmentInterface
    public int getType() {
        return 27;
    }

    @Override // com.box.android.base.presentation.utilities.AddFabHelper
    public boolean isAddFabAvailable() {
        return false;
    }

    @Override // com.box.android.base.presentation.utilities.AddFabHelper
    public void onAddFabClicked() {
    }

    @Override // com.box.android.base.presentation.fragments.BaseListingAbstractFragment, com.box.android.base.presentation.BoxFragmentInterface
    @Deprecated(message = "Deprecated in Java")
    public boolean shouldUpdateFragment(BoxMessage<?> message) {
        return false;
    }

    public CaptureHistoryFragment() {
        final CaptureHistoryFragment captureHistoryFragment = this;
        final Function0 function0 = null;
        this.captureViewModel = FragmentViewModelLazyKt.createViewModelLazy(captureHistoryFragment, Reflection.getOrCreateKotlinClass(CaptureViewModel.class), new Function0<ViewModelStore>() { // from class: com.box.android.capture.CaptureHistoryFragment$special$$inlined$activityViewModels$default$1
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ViewModelStore invoke() {
                return captureHistoryFragment.requireActivity().getViewModelStore();
            }
        }, new Function0<CreationExtras>() { // from class: com.box.android.capture.CaptureHistoryFragment$special$$inlined$activityViewModels$default$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final CreationExtras invoke() {
                CreationExtras creationExtras;
                Function0 function1 = function0;
                return (function1 == null || (creationExtras = (CreationExtras) function1.invoke()) == null) ? captureHistoryFragment.requireActivity().getDefaultViewModelCreationExtras() : creationExtras;
            }
        }, new Function0<ViewModelProvider.Factory>() { // from class: com.box.android.capture.CaptureHistoryFragment$special$$inlined$activityViewModels$default$3
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ViewModelProvider.Factory invoke() {
                return captureHistoryFragment.requireActivity().getDefaultViewModelProviderFactory();
            }
        });
        final Function0<Fragment> function1 = new Function0<Fragment>() { // from class: com.box.android.capture.CaptureHistoryFragment$special$$inlined$viewModels$default$1
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final Fragment invoke() {
                return captureHistoryFragment;
            }
        };
        final Lazy lazy = LazyKt.lazy(LazyThreadSafetyMode.NONE, (Function0) new Function0<ViewModelStoreOwner>() { // from class: com.box.android.capture.CaptureHistoryFragment$special$$inlined$viewModels$default$2
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ViewModelStoreOwner invoke() {
                return (ViewModelStoreOwner) function1.invoke();
            }
        });
        this.captureHistoryViewModel = FragmentViewModelLazyKt.createViewModelLazy(captureHistoryFragment, Reflection.getOrCreateKotlinClass(CaptureHistoryViewModel.class), new Function0<ViewModelStore>() { // from class: com.box.android.capture.CaptureHistoryFragment$special$$inlined$viewModels$default$3
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ViewModelStore invoke() {
                return FragmentViewModelLazyKt.m10254viewModels$lambda1(lazy).getViewModelStore();
            }
        }, new Function0<CreationExtras>() { // from class: com.box.android.capture.CaptureHistoryFragment$special$$inlined$viewModels$default$4
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
        }, new Function0<ViewModelProvider.Factory>() { // from class: com.box.android.capture.CaptureHistoryFragment$special$$inlined$viewModels$default$5
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
                return (hasDefaultViewModelProviderFactory == null || (defaultViewModelProviderFactory = hasDefaultViewModelProviderFactory.getDefaultViewModelProviderFactory()) == null) ? captureHistoryFragment.getDefaultViewModelProviderFactory() : defaultViewModelProviderFactory;
            }
        });
        this.multiSelectHandler = new MultiSelectHandler();
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

    public final IOfflineService getOfflineService() {
        IOfflineService iOfflineService = this.offlineService;
        if (iOfflineService != null) {
            return iOfflineService;
        }
        Intrinsics.throwUninitializedPropertyAccessException("offlineService");
        return null;
    }

    public final void setOfflineService(IOfflineService iOfflineService) {
        Intrinsics.checkNotNullParameter(iOfflineService, "<set-?>");
        this.offlineService = iOfflineService;
    }

    public final BoxModelOfflineManagerWrapper getOfflineManagerWrapper() {
        BoxModelOfflineManagerWrapper boxModelOfflineManagerWrapper = this.offlineManagerWrapper;
        if (boxModelOfflineManagerWrapper != null) {
            return boxModelOfflineManagerWrapper;
        }
        Intrinsics.throwUninitializedPropertyAccessException("offlineManagerWrapper");
        return null;
    }

    public final void setOfflineManagerWrapper(BoxModelOfflineManagerWrapper boxModelOfflineManagerWrapper) {
        Intrinsics.checkNotNullParameter(boxModelOfflineManagerWrapper, "<set-?>");
        this.offlineManagerWrapper = boxModelOfflineManagerWrapper;
    }

    private final CaptureViewModel getCaptureViewModel() {
        return (CaptureViewModel) this.captureViewModel.getValue();
    }

    private final CaptureHistoryViewModel getCaptureHistoryViewModel() {
        return (CaptureHistoryViewModel) this.captureHistoryViewModel.getValue();
    }

    public final boolean getHasFailedJobs() {
        return this.hasFailedJobs;
    }

    public final void setHasFailedJobs(boolean z) {
        this.hasFailedJobs = z;
    }

    @Override // androidx.fragment.app.Fragment
    public void onCreate(Bundle savedInstanceState) {
        OnBackPressedDispatcher onBackPressedDispatcher;
        super.onCreate(savedInstanceState);
        FragmentActivity activity = getActivity();
        if (activity != null && (onBackPressedDispatcher = activity.getOnBackPressedDispatcher()) != null) {
            OnBackPressedDispatcherKt.addCallback$default(onBackPressedDispatcher, this, false, new Function1() { // from class: com.box.android.capture.CaptureHistoryFragment$$ExternalSyntheticLambda1
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    return CaptureHistoryFragment.onCreate$lambda$0(this.f$0, (OnBackPressedCallback) obj);
                }
            }, 2, null);
        }
        setHasOptionsMenu(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit onCreate$lambda$0(CaptureHistoryFragment captureHistoryFragment, OnBackPressedCallback addCallback) {
        Intrinsics.checkNotNullParameter(addCallback, "$this$addCallback");
        KeyEventDispatcher.Component activity = captureHistoryFragment.getActivity();
        ICaptureActivity iCaptureActivity = activity instanceof ICaptureActivity ? (ICaptureActivity) activity : null;
        if (iCaptureActivity != null) {
            iCaptureActivity.closeCaptureHistory();
        }
        addCallback.setEnabled(false);
        return Unit.INSTANCE;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, savedInstanceState);
        ((FragmentItemListingBinding) getBinding()).swipeRefreshView.setEnabled(false);
    }

    @Override // androidx.fragment.app.Fragment
    @Deprecated(message = "Deprecated in Java")
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 100 && resultCode == -1) {
            FolderModelMapper folderModelMapper = FolderModelMapper.INSTANCE;
            Serializable serializableExtra = data != null ? data.getSerializableExtra(ItemPickerActivity.EXTRA_FOLDER) : null;
            Intrinsics.checkNotNull(serializableExtra, "null cannot be cast to non-null type com.box.androidsdk.content.models.BoxFolder");
            FolderModel folderModel$default = FolderModelMapper.toFolderModel$default(folderModelMapper, (BoxFolder) serializableExtra, false, 1, null);
            LifecycleObserver presenter = getPresenter();
            Intrinsics.checkNotNull(presenter, "null cannot be cast to non-null type com.box.android.capture.CaptureHistoryPresenter");
            ((CaptureHistoryPresenter) presenter).updateUploadFolder(folderModel$default);
        }
    }

    private final void initToolbar() {
        FragmentActivity fragmentActivityRequireActivity = requireActivity();
        Intrinsics.checkNotNull(fragmentActivityRequireActivity, "null cannot be cast to non-null type com.box.android.capture.activities.CaptureActivity");
        ToolbarWithOverlayWarning toolbar = ((CaptureActivity) fragmentActivityRequireActivity).getBinding().captureToolbar.toolbar;
        Intrinsics.checkNotNullExpressionValue(toolbar, "toolbar");
        toolbar.setTitle(getTitle(getContext()));
        Context contextRequireContext = requireContext();
        Intrinsics.checkNotNullExpressionValue(contextRequireContext, "requireContext(...)");
        toolbar.setNavigationIcon(CommonBoxUtil.getDrawable(contextRequireContext, R.drawable.ic_toolbar_back_btn));
        toolbar.setNavigationOnClickListener(new View.OnClickListener() { // from class: com.box.android.capture.CaptureHistoryFragment$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                CaptureHistoryFragment.initToolbar$lambda$0(this.f$0, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initToolbar$lambda$0(CaptureHistoryFragment captureHistoryFragment, View view) {
        KeyEventDispatcher.Component activity = captureHistoryFragment.getActivity();
        ICaptureActivity iCaptureActivity = activity instanceof ICaptureActivity ? (ICaptureActivity) activity : null;
        if (iCaptureActivity != null) {
            iCaptureActivity.closeCaptureHistory();
        }
    }

    @Override // androidx.fragment.app.Fragment
    @Deprecated(message = "Deprecated in Java")
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        Intrinsics.checkNotNullParameter(menu, "menu");
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        menu.clear();
        inflater.inflate(R.menu.capture_history_menu, menu);
        super.onCreateOptionsMenu(menu, inflater);
    }

    @Override // androidx.fragment.app.Fragment
    @Deprecated(message = "Deprecated in Java")
    public void onPrepareOptionsMenu(Menu menu) {
        Intrinsics.checkNotNullParameter(menu, "menu");
        super.onPrepareOptionsMenu(menu);
        if (this.hasFailedJobs) {
            enableMenuItem(menu, R.id.retry_all_menu_item);
        } else {
            disableMenuItem(menu, R.id.retry_all_menu_item);
        }
    }

    @Override // androidx.fragment.app.Fragment
    @Deprecated(message = "Deprecated in Java")
    public boolean onOptionsItemSelected(MenuItem item) {
        Intrinsics.checkNotNullParameter(item, "item");
        if (item.getItemId() == R.id.select_menu_item) {
            this.multiSelectHandler.startSelectionMode();
            return true;
        }
        if (item.getItemId() != R.id.retry_all_menu_item) {
            return true;
        }
        LifecycleObserver presenter = getPresenter();
        Intrinsics.checkNotNull(presenter, "null cannot be cast to non-null type com.box.android.capture.CaptureHistoryPresenter");
        ((CaptureHistoryPresenter) presenter).retryAllFailedJobs();
        return true;
    }

    @Override // com.box.android.base.presentation.fragments.BaseListingAbstractFragment, androidx.swiperefreshlayout.widget.SwipeRefreshLayout.OnRefreshListener
    public void onRefresh() {
        updateUI();
    }

    @Override // com.box.android.base.presentation.BoxFragmentInterface
    public String getGenericId() {
        return "CaptureHistory";
    }

    @Override // com.box.android.base.presentation.BoxFragmentInterface
    public String getTitle(Context context) {
        String string = getString(R.string.box_capture_capture_history);
        Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
        return string;
    }

    @Override // com.box.android.base.presentation.BoxFragmentInterface
    public String getAmplitudePageName() {
        return BoxAnalyticsParams.PAGE_NAME_CAPTURE_HISTORY_PAGE;
    }

    @Override // com.box.android.base.presentation.fragments.BaseListingAbstractFragment
    protected BaseListingPresenter<CaptureHistoryModel, BaseListingAbstractFragment<CaptureHistoryModel, FragmentItemListingBinding>> createPresenter() {
        return new CaptureHistoryPresenter(this, getCaptureHistoryViewModel(), getCaptureViewModel(), LifecycleOwnerKt.getLifecycleScope(this));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void onItemClick(FileModel item) {
        KeyEventDispatcher.Component activity = getActivity();
        ICaptureActivity iCaptureActivity = activity instanceof ICaptureActivity ? (ICaptureActivity) activity : null;
        if (iCaptureActivity != null) {
            iCaptureActivity.onItemClick(item);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void showBottomSheet(FileModel item, BottomSheetAttributes.BottomSheetMenuType type) {
        KeyEventDispatcher.Component activity = getActivity();
        ICaptureActivity iCaptureActivity = activity instanceof ICaptureActivity ? (ICaptureActivity) activity : null;
        if (iCaptureActivity != null) {
            iCaptureActivity.showBottomSheet(item, type, BottomSheetAttributes.LaunchContext.CaptureHistory.INSTANCE);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit createAdapter$handleMultiSelectIfEnabled(CaptureHistoryFragment captureHistoryFragment, Function0<Unit> function0) {
        if (!captureHistoryFragment.multiSelectHandler.get_isActionModeEnabled()) {
            return null;
        }
        function0.invoke();
        return Unit.INSTANCE;
    }

    @Override // com.box.android.base.presentation.fragments.BaseListingAbstractFragment
    protected RecyclerView.Adapter<?> createAdapter() {
        Context contextRequireContext = requireContext();
        Intrinsics.checkNotNullExpressionValue(contextRequireContext, "requireContext(...)");
        MultiSelectHandler multiSelectHandler = this.multiSelectHandler;
        AnonymousClass1 anonymousClass1 = new AnonymousClass1();
        ThumbnailManager thumbnailManager = getThumbnailManager();
        FeatureFlips featureFlips = getFeatureFlips();
        IUserContextManager userContextManager = getUserContextManager();
        BoxModelOfflineManagerWrapper offlineManagerWrapper = getOfflineManagerWrapper();
        IOfflineService offlineService = getOfflineService();
        LifecycleOwner viewLifecycleOwner = getViewLifecycleOwner();
        Intrinsics.checkNotNullExpressionValue(viewLifecycleOwner, "getViewLifecycleOwner(...)");
        this.uploadedCaptureFilesAdapter = new UploadedCaptureFilesAdapter(contextRequireContext, multiSelectHandler, anonymousClass1, thumbnailManager, featureFlips, userContextManager, offlineManagerWrapper, offlineService, LifecycleOwnerKt.getLifecycleScope(viewLifecycleOwner));
        FragmentActivity fragmentActivityRequireActivity = requireActivity();
        Intrinsics.checkNotNullExpressionValue(fragmentActivityRequireActivity, "requireActivity(...)");
        FragmentActivity fragmentActivity = fragmentActivityRequireActivity;
        MultiSelectHandler multiSelectHandler2 = this.multiSelectHandler;
        AnonymousClass2 anonymousClass2 = new AnonymousClass2();
        ThumbnailManager thumbnailManager2 = getThumbnailManager();
        FeatureFlips featureFlips2 = getFeatureFlips();
        IUserContextManager userContextManager2 = getUserContextManager();
        HeaderActionListener headerActionListener = new HeaderActionListener() { // from class: com.box.android.capture.CaptureHistoryFragment.createAdapter.3
            @Override // com.box.android.base.presentation.utilities.HeaderActionListener
            public void onPrimaryAction() {
                ItemPickerActivity.Companion companion = ItemPickerActivity.INSTANCE;
                Context contextRequireContext2 = CaptureHistoryFragment.this.requireContext();
                Intrinsics.checkNotNullExpressionValue(contextRequireContext2, "requireContext(...)");
                CaptureHistoryFragment.this.startActivityForResult(ItemPickerActivity.Companion.getLaunchIntent$default(companion, contextRequireContext2, null, true, true, CaptureHistoryFragment.this.requireContext().getString(R.string.pick_destination), 2, null), 100);
            }
        };
        BoxModelOfflineManagerWrapper offlineManagerWrapper2 = getOfflineManagerWrapper();
        IOfflineService offlineService2 = getOfflineService();
        LifecycleOwner viewLifecycleOwner2 = getViewLifecycleOwner();
        Intrinsics.checkNotNullExpressionValue(viewLifecycleOwner2, "getViewLifecycleOwner(...)");
        this.pendingCaptureFilesAdapter = new PendingCaptureFilesAdapter(fragmentActivity, multiSelectHandler2, anonymousClass2, thumbnailManager2, featureFlips2, userContextManager2, headerActionListener, offlineManagerWrapper2, offlineService2, LifecycleOwnerKt.getLifecycleScope(viewLifecycleOwner2));
        RecyclerView.Adapter[] adapterArr = new RecyclerView.Adapter[2];
        PendingCaptureFilesAdapter pendingCaptureFilesAdapter = this.pendingCaptureFilesAdapter;
        UploadedCaptureFilesAdapter uploadedCaptureFilesAdapter = null;
        if (pendingCaptureFilesAdapter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("pendingCaptureFilesAdapter");
            pendingCaptureFilesAdapter = null;
        }
        adapterArr[0] = pendingCaptureFilesAdapter;
        UploadedCaptureFilesAdapter uploadedCaptureFilesAdapter2 = this.uploadedCaptureFilesAdapter;
        if (uploadedCaptureFilesAdapter2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("uploadedCaptureFilesAdapter");
        } else {
            uploadedCaptureFilesAdapter = uploadedCaptureFilesAdapter2;
        }
        adapterArr[1] = uploadedCaptureFilesAdapter;
        return new ConcatAdapter((RecyclerView.Adapter<? extends RecyclerView.ViewHolder>[]) adapterArr);
    }

    /* JADX INFO: renamed from: com.box.android.capture.CaptureHistoryFragment$createAdapter$1, reason: invalid class name */
    /* JADX INFO: compiled from: CaptureHistoryFragment.kt */
    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0002H\u0016J\u0010\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0002H\u0016J\u0010\u0010\u0007\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u0002H\u0016¨\u0006\t"}, d2 = {"com/box/android/capture/CaptureHistoryFragment$createAdapter$1", "Lcom/box/android/base/presentation/utilities/ItemActionListener;", "Lcom/box/android/domain/models/CaptureHistoryModel;", "onPrimaryAction", "", "item", "onSecondaryAction", "onLongClick", "", "capture_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class AnonymousClass1 implements ItemActionListener<CaptureHistoryModel> {
        AnonymousClass1() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final Unit onPrimaryAction$lambda$0(CaptureHistoryFragment captureHistoryFragment, CaptureHistoryModel captureHistoryModel) {
            captureHistoryFragment.multiSelectHandler.toggleItem(captureHistoryModel);
            return Unit.INSTANCE;
        }

        @Override // com.box.android.base.presentation.utilities.ItemActionListener
        public void onPrimaryAction(final CaptureHistoryModel item) {
            Intrinsics.checkNotNullParameter(item, "item");
            final CaptureHistoryFragment captureHistoryFragment = CaptureHistoryFragment.this;
            if (CaptureHistoryFragment.createAdapter$handleMultiSelectIfEnabled(captureHistoryFragment, new Function0() { // from class: com.box.android.capture.CaptureHistoryFragment$createAdapter$1$$ExternalSyntheticLambda0
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    return CaptureHistoryFragment.AnonymousClass1.onPrimaryAction$lambda$0(captureHistoryFragment, item);
                }
            }) == null) {
                CaptureHistoryFragment.this.onItemClick(item.getFileModel());
            }
        }

        @Override // com.box.android.base.presentation.utilities.ItemActionListener
        public void onSecondaryAction(CaptureHistoryModel item) {
            Intrinsics.checkNotNullParameter(item, "item");
            CaptureHistoryFragment.this.showBottomSheet(item.getFileModel(), BottomSheetAttributes.BottomSheetMenuType.AddRemoveCollectionItems.INSTANCE);
        }

        @Override // com.box.android.base.presentation.utilities.ItemActionListener
        public boolean onLongClick(CaptureHistoryModel item) {
            Intrinsics.checkNotNullParameter(item, "item");
            if (!CaptureHistoryFragment.this.multiSelectHandler.isItemSelectable(item)) {
                return false;
            }
            CaptureHistoryFragment.this.multiSelectHandler.startSelectionMode();
            CaptureHistoryFragment.this.multiSelectHandler.toggleItem(item);
            return true;
        }
    }

    /* JADX INFO: renamed from: com.box.android.capture.CaptureHistoryFragment$createAdapter$2, reason: invalid class name */
    /* JADX INFO: compiled from: CaptureHistoryFragment.kt */
    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0002H\u0016J\u0010\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0002H\u0016J\u0010\u0010\u0007\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u0002H\u0016¨\u0006\t"}, d2 = {"com/box/android/capture/CaptureHistoryFragment$createAdapter$2", "Lcom/box/android/base/presentation/utilities/ItemActionListener;", "Lcom/box/android/domain/models/CaptureHistoryModel;", "onPrimaryAction", "", "item", "onSecondaryAction", "onLongClick", "", "capture_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class AnonymousClass2 implements ItemActionListener<CaptureHistoryModel> {
        AnonymousClass2() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final Unit onPrimaryAction$lambda$0(CaptureHistoryFragment captureHistoryFragment, CaptureHistoryModel captureHistoryModel) {
            captureHistoryFragment.multiSelectHandler.toggleItem(captureHistoryModel);
            return Unit.INSTANCE;
        }

        @Override // com.box.android.base.presentation.utilities.ItemActionListener
        public void onPrimaryAction(final CaptureHistoryModel item) {
            Intrinsics.checkNotNullParameter(item, "item");
            final CaptureHistoryFragment captureHistoryFragment = CaptureHistoryFragment.this;
            if (CaptureHistoryFragment.createAdapter$handleMultiSelectIfEnabled(captureHistoryFragment, new Function0() { // from class: com.box.android.capture.CaptureHistoryFragment$createAdapter$2$$ExternalSyntheticLambda0
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    return CaptureHistoryFragment.AnonymousClass2.onPrimaryAction$lambda$0(captureHistoryFragment, item);
                }
            }) != null || item.getContentUrl() == null) {
                return;
            }
            CaptureHistoryFragment.this.onItemClick(item.getFileModel());
            Unit unit = Unit.INSTANCE;
        }

        @Override // com.box.android.base.presentation.utilities.ItemActionListener
        public void onSecondaryAction(CaptureHistoryModel item) {
            Intrinsics.checkNotNullParameter(item, "item");
            BuildersKt__Builders_commonKt.launch$default(CaptureHistoryFragment.this, null, null, new CaptureHistoryFragment$createAdapter$2$onSecondaryAction$1(item, CaptureHistoryFragment.this, null), 3, null);
        }

        @Override // com.box.android.base.presentation.utilities.ItemActionListener
        public boolean onLongClick(CaptureHistoryModel item) {
            Intrinsics.checkNotNullParameter(item, "item");
            if (!CaptureHistoryFragment.this.multiSelectHandler.isItemSelectable(item)) {
                return false;
            }
            CaptureHistoryFragment.this.multiSelectHandler.startSelectionMode();
            CaptureHistoryFragment.this.multiSelectHandler.toggleItem(item);
            return true;
        }
    }

    @Override // com.box.android.base.presentation.fragments.BaseListingAbstractFragment
    public void setupEmptyView(Function1<? super Integer, Unit> emptyImageSetter, Function1<? super Integer, Unit> emptyTextSetter, Function1<? super Integer, Unit> emptySubtextSetter) {
        Intrinsics.checkNotNullParameter(emptyImageSetter, "emptyImageSetter");
        Intrinsics.checkNotNullParameter(emptyTextSetter, "emptyTextSetter");
        Intrinsics.checkNotNullParameter(emptySubtextSetter, "emptySubtextSetter");
        emptyImageSetter.invoke(Integer.valueOf(R.drawable.empty_capture_history_photos));
        emptyTextSetter.invoke(Integer.valueOf(R.string.box_capture_empty_capture_history_text));
        emptySubtextSetter.invoke(Integer.valueOf(R.string.box_capture_empty_capture_history_empty_subtext));
    }

    @Override // com.box.android.base.presentation.fragments.BaseListingAbstractFragment, com.box.android.base.presentation.presenters.BaseListingPresenter.BoxItemsView
    public void renderNewList(List<CaptureHistoryModel> newList) {
        Intrinsics.checkNotNullParameter(newList, "newList");
        throw new IllegalArgumentException("Please update adapters by calling updateUploadedFiles/updatePendingFiles");
    }

    public final Job getFailedJobsObserver() {
        return this.failedJobsObserver;
    }

    public final void setFailedJobsObserver(Job job) {
        this.failedJobsObserver = job;
    }

    /* JADX INFO: renamed from: com.box.android.capture.CaptureHistoryFragment$updatePendingFiles$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: CaptureHistoryFragment.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.box.android.capture.CaptureHistoryFragment$updatePendingFiles$1", f = "CaptureHistoryFragment.kt", i = {}, l = {304}, m = "invokeSuspend", n = {}, s = {}, v = 1)
    static final class C09621 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ List<CaptureHistoryModel> $newList;
        int label;
        final /* synthetic */ CaptureHistoryFragment this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C09621(List<CaptureHistoryModel> list, CaptureHistoryFragment captureHistoryFragment, Continuation<? super C09621> continuation) {
            super(2, continuation);
            this.$newList = list;
            this.this$0 = captureHistoryFragment;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new C09621(this.$newList, this.this$0, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C09621) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                List<CaptureHistoryModel> list = this.$newList;
                ArrayList arrayList = new ArrayList();
                Iterator<T> it = list.iterator();
                while (it.hasNext()) {
                    JobInfo jobInfo = ((CaptureHistoryModel) it.next()).getJobInfo();
                    Flow<JobInfo.Status> status = jobInfo != null ? jobInfo.getStatus() : null;
                    if (status != null) {
                        arrayList.add(status);
                    }
                }
                final Flow[] flowArr = (Flow[]) CollectionsKt.toList(arrayList).toArray(new Flow[0]);
                Flow<Boolean> flow = new Flow<Boolean>() { // from class: com.box.android.capture.CaptureHistoryFragment$updatePendingFiles$1$invokeSuspend$$inlined$combine$1
                    @Override // kotlinx.coroutines.flow.Flow
                    public Object collect(FlowCollector<? super Boolean> flowCollector, Continuation continuation) {
                        Flow[] flowArr2 = flowArr;
                        final Flow[] flowArr3 = flowArr;
                        Object objCombineInternal = CombineKt.combineInternal(flowCollector, flowArr2, new Function0<JobInfo.Status[]>() { // from class: com.box.android.capture.CaptureHistoryFragment$updatePendingFiles$1$invokeSuspend$$inlined$combine$1.2
                            @Override // kotlin.jvm.functions.Function0
                            public final JobInfo.Status[] invoke() {
                                return new JobInfo.Status[flowArr3.length];
                            }
                        }, new AnonymousClass3(null), continuation);
                        return objCombineInternal == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objCombineInternal : Unit.INSTANCE;
                    }

                    /* JADX INFO: renamed from: com.box.android.capture.CaptureHistoryFragment$updatePendingFiles$1$invokeSuspend$$inlined$combine$1$3, reason: invalid class name */
                    /* JADX INFO: compiled from: Zip.kt */
                    @Metadata(d1 = {"\u0000\u0016\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0000\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002\"\u0006\b\u0001\u0010\u0003\u0018\u0001*\b\u0012\u0004\u0012\u0002H\u00020\u00042\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u0002H\u00030\u0006H\n¨\u0006\u0007"}, d2 = {"<anonymous>", "", "R", ExifInterface.GPS_DIRECTION_TRUE, "Lkotlinx/coroutines/flow/FlowCollector;", "it", "", "kotlinx/coroutines/flow/FlowKt__ZipKt$combine$6$2"}, k = 3, mv = {2, 2, 0}, xi = 48)
                    @DebugMetadata(c = "com.box.android.capture.CaptureHistoryFragment$updatePendingFiles$1$invokeSuspend$$inlined$combine$1$3", f = "CaptureHistoryFragment.kt", i = {0, 0}, l = {288}, m = "invokeSuspend", n = {"$this$combineInternal", "it"}, s = {"L$0", "L$1"}, v = 1)
                    public static final class AnonymousClass3 extends SuspendLambda implements Function3<FlowCollector<? super Boolean>, JobInfo.Status[], Continuation<? super Unit>, Object> {
                        private /* synthetic */ Object L$0;
                        /* synthetic */ Object L$1;
                        int label;

                        public AnonymousClass3(Continuation continuation) {
                            super(3, continuation);
                        }

                        @Override // kotlin.jvm.functions.Function3
                        public final Object invoke(FlowCollector<? super Boolean> flowCollector, JobInfo.Status[] statusArr, Continuation<? super Unit> continuation) {
                            AnonymousClass3 anonymousClass3 = new AnonymousClass3(continuation);
                            anonymousClass3.L$0 = flowCollector;
                            anonymousClass3.L$1 = statusArr;
                            return anonymousClass3.invokeSuspend(Unit.INSTANCE);
                        }

                        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                        public final Object invokeSuspend(Object obj) {
                            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                            int i = this.label;
                            if (i == 0) {
                                ResultKt.throwOnFailure(obj);
                                FlowCollector flowCollector = (FlowCollector) this.L$0;
                                Object[] objArr = (Object[]) this.L$1;
                                AnonymousClass3 anonymousClass3 = this;
                                boolean z = false;
                                for (JobInfo.Status status : (JobInfo.Status[]) objArr) {
                                    if (status instanceof JobInfo.Status.Failed) {
                                        z = true;
                                        break;
                                    }
                                }
                                Boolean boolBoxBoolean = Boxing.boxBoolean(z);
                                this.L$0 = SpillingKt.nullOutSpilledVariable(flowCollector);
                                this.L$1 = SpillingKt.nullOutSpilledVariable(objArr);
                                this.label = 1;
                                if (flowCollector.emit(boolBoxBoolean, anonymousClass3) == coroutine_suspended) {
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
                };
                final CaptureHistoryFragment captureHistoryFragment = this.this$0;
                this.label = 1;
                if (flow.collect(new FlowCollector() { // from class: com.box.android.capture.CaptureHistoryFragment.updatePendingFiles.1.3
                    @Override // kotlinx.coroutines.flow.FlowCollector
                    public /* bridge */ /* synthetic */ Object emit(Object obj2, Continuation continuation) {
                        return emit(((Boolean) obj2).booleanValue(), (Continuation<? super Unit>) continuation);
                    }

                    public final Object emit(boolean z, Continuation<? super Unit> continuation) {
                        captureHistoryFragment.setHasFailedJobs(z);
                        return Unit.INSTANCE;
                    }
                }, this) == coroutine_suspended) {
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

    public final void updatePendingFiles(List<CaptureHistoryModel> newList) {
        Intrinsics.checkNotNullParameter(newList, "newList");
        Job job = this.failedJobsObserver;
        if (job != null) {
            FlowExtensionsKt.cancelIfActive(job);
        }
        PendingCaptureFilesAdapter pendingCaptureFilesAdapter = null;
        this.failedJobsObserver = BuildersKt__Builders_commonKt.launch$default(this, null, null, new C09621(newList, this, null), 3, null);
        PendingCaptureFilesAdapter pendingCaptureFilesAdapter2 = this.pendingCaptureFilesAdapter;
        if (pendingCaptureFilesAdapter2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("pendingCaptureFilesAdapter");
        } else {
            pendingCaptureFilesAdapter = pendingCaptureFilesAdapter2;
        }
        pendingCaptureFilesAdapter.updateItems(newList);
        this.multiSelectHandler.setPendingItems(CollectionsKt.toSet(newList));
    }

    public final void updateUploadedFiles(List<CaptureHistoryModel> newList) {
        Intrinsics.checkNotNullParameter(newList, "newList");
        UploadedCaptureFilesAdapter uploadedCaptureFilesAdapter = this.uploadedCaptureFilesAdapter;
        if (uploadedCaptureFilesAdapter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("uploadedCaptureFilesAdapter");
            uploadedCaptureFilesAdapter = null;
        }
        uploadedCaptureFilesAdapter.updateItems(newList);
    }

    public final void updateChangeFolderBanner(boolean hasError) {
        PendingCaptureFilesAdapter pendingCaptureFilesAdapter = null;
        if (hasError) {
            PendingCaptureFilesAdapter pendingCaptureFilesAdapter2 = this.pendingCaptureFilesAdapter;
            if (pendingCaptureFilesAdapter2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("pendingCaptureFilesAdapter");
            } else {
                pendingCaptureFilesAdapter = pendingCaptureFilesAdapter2;
            }
            pendingCaptureFilesAdapter.showErrorRecovery();
            return;
        }
        PendingCaptureFilesAdapter pendingCaptureFilesAdapter3 = this.pendingCaptureFilesAdapter;
        if (pendingCaptureFilesAdapter3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("pendingCaptureFilesAdapter");
        } else {
            pendingCaptureFilesAdapter = pendingCaptureFilesAdapter3;
        }
        pendingCaptureFilesAdapter.hideErrorRecovery();
    }

    @Override // com.box.android.base.presentation.fragments.BaseListingAbstractFragment, androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        initToolbar();
        FragmentActivity activity = getActivity();
        Intrinsics.checkNotNull(activity, "null cannot be cast to non-null type androidx.appcompat.app.AppCompatActivity");
        ActionBar supportActionBar = ((AppCompatActivity) activity).getSupportActionBar();
        if (supportActionBar != null) {
            supportActionBar.show();
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        FragmentActivity activity = getActivity();
        Intrinsics.checkNotNull(activity, "null cannot be cast to non-null type androidx.appcompat.app.AppCompatActivity");
        ActionBar supportActionBar = ((AppCompatActivity) activity).getSupportActionBar();
        if (supportActionBar != null) {
            supportActionBar.hide();
        }
    }

    /* JADX INFO: compiled from: CaptureHistoryFragment.kt */
    @Metadata(d1 = {"\u0000;\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010#\n\u0000\n\u0002\u0010\u0002\n\u0002\b\n\n\u0002\b\u0003*\u0001\u001f\b\u0087\u0004\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0007H\u0002J\u0006\u0010\u0016\u001a\u00020\u0007J\u000e\u0010\u0017\u001a\u00020\u00072\u0006\u0010\u0018\u001a\u00020\fJ\u000e\u0010\u0019\u001a\u00020\u00072\u0006\u0010\u0018\u001a\u00020\fJ\u000e\u0010\u001a\u001a\u00020\u00142\u0006\u0010\u001b\u001a\u00020\fJ\b\u0010\u001c\u001a\u00020\u0014H\u0002J\u0006\u0010\u001d\u001a\u00020\u0014R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\b\u001a\u00020\u00078F¢\u0006\u0006\u001a\u0004\b\b\u0010\tR \u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u0014\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\f0\u0012X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u001e\u001a\u00020\u001fX\u0082\u0004¢\u0006\u0004\n\u0002\u0010 ¨\u0006!"}, d2 = {"Lcom/box/android/capture/CaptureHistoryFragment$MultiSelectHandler;", "", "<init>", "(Lcom/box/android/capture/CaptureHistoryFragment;)V", "actionMode", "Landroid/view/ActionMode;", "_isActionModeEnabled", "", "isActionModeEnabled", "()Z", "pendingItems", "", "Lcom/box/android/domain/models/CaptureHistoryModel;", "getPendingItems", "()Ljava/util/Set;", "setPendingItems", "(Ljava/util/Set;)V", "selectedItems", "", "setMultiSelectEnabled", "", "isEnabled", "isAtLeastOneItemSelected", "isItemSelected", "item", "isItemSelectable", "toggleItem", "captureHistoryModel", DiagnosisParams.CLEAR_ON_LOGOUT, "startSelectionMode", "actionModeCallback", "com/box/android/capture/CaptureHistoryFragment$MultiSelectHandler$actionModeCallback$1", "Lcom/box/android/capture/CaptureHistoryFragment$MultiSelectHandler$actionModeCallback$1;", "capture_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public final class MultiSelectHandler {
        private boolean _isActionModeEnabled;
        private ActionMode actionMode;
        private final CaptureHistoryFragment$MultiSelectHandler$actionModeCallback$1 actionModeCallback;
        private Set<CaptureHistoryModel> pendingItems = SetsKt.emptySet();
        private final Set<CaptureHistoryModel> selectedItems = new LinkedHashSet();

        public MultiSelectHandler() {
            this.actionModeCallback = new CaptureHistoryFragment$MultiSelectHandler$actionModeCallback$1(this, CaptureHistoryFragment.this);
        }

        /* JADX INFO: renamed from: isActionModeEnabled, reason: from getter */
        public final boolean get_isActionModeEnabled() {
            return this._isActionModeEnabled;
        }

        public final Set<CaptureHistoryModel> getPendingItems() {
            return this.pendingItems;
        }

        public final void setPendingItems(Set<CaptureHistoryModel> set) {
            Intrinsics.checkNotNullParameter(set, "<set-?>");
            this.pendingItems = set;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void setMultiSelectEnabled(boolean isEnabled) {
            this._isActionModeEnabled = isEnabled;
            if (!get_isActionModeEnabled()) {
                clear();
            }
            CaptureHistoryFragment.this.getAdapter().notifyDataSetChanged();
        }

        public final boolean isAtLeastOneItemSelected() {
            return !this.selectedItems.isEmpty();
        }

        public final boolean isItemSelected(CaptureHistoryModel item) {
            Intrinsics.checkNotNullParameter(item, "item");
            return this.selectedItems.contains(item);
        }

        public final boolean isItemSelectable(CaptureHistoryModel item) {
            Intrinsics.checkNotNullParameter(item, "item");
            return ((Boolean) BuildersKt__BuildersKt.runBlocking$default(null, new CaptureHistoryFragment$MultiSelectHandler$isItemSelectable$1(item, this, null), 1, null)).booleanValue();
        }

        public final void toggleItem(CaptureHistoryModel captureHistoryModel) {
            Intrinsics.checkNotNullParameter(captureHistoryModel, "captureHistoryModel");
            if (!this.selectedItems.remove(captureHistoryModel)) {
                this.selectedItems.add(captureHistoryModel);
            }
            ItemId itemId = captureHistoryModel.getFileModel().getItemId();
            UploadedCaptureFilesAdapter uploadedCaptureFilesAdapter = null;
            PendingCaptureFilesAdapter pendingCaptureFilesAdapter = null;
            if (this.pendingItems.contains(captureHistoryModel)) {
                PendingCaptureFilesAdapter pendingCaptureFilesAdapter2 = CaptureHistoryFragment.this.pendingCaptureFilesAdapter;
                if (pendingCaptureFilesAdapter2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("pendingCaptureFilesAdapter");
                } else {
                    pendingCaptureFilesAdapter = pendingCaptureFilesAdapter2;
                }
                pendingCaptureFilesAdapter.updateItem(itemId);
            } else {
                UploadedCaptureFilesAdapter uploadedCaptureFilesAdapter2 = CaptureHistoryFragment.this.uploadedCaptureFilesAdapter;
                if (uploadedCaptureFilesAdapter2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("uploadedCaptureFilesAdapter");
                } else {
                    uploadedCaptureFilesAdapter = uploadedCaptureFilesAdapter2;
                }
                uploadedCaptureFilesAdapter.updateItem(itemId);
            }
            ActionMode actionMode = this.actionMode;
            if (actionMode != null) {
                actionMode.invalidate();
            }
        }

        private final void clear() {
            this.selectedItems.clear();
            CaptureHistoryFragment.this.getAdapter().notifyDataSetChanged();
        }

        public final void startSelectionMode() {
            ActionMode actionModeStartActionMode = CaptureHistoryFragment.this.requireActivity().startActionMode(this.actionModeCallback);
            Intrinsics.checkNotNull(actionModeStartActionMode);
            this.actionMode = actionModeStartActionMode;
        }
    }
}
