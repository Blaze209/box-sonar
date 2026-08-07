package com.box.android.capture.documentscanning.presentation;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.activity.OnBackPressedCallback;
import androidx.activity.OnBackPressedDispatcherKt;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.Guideline;
import androidx.core.view.KeyEventDispatcher;
import androidx.core.view.OnApplyWindowInsetsListener;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.lifecycle.RepeatOnLifecycleKt;
import androidx.media3.extractor.text.ttml.TtmlNode;
import com.box.android.base.presentation.fragments.AlertDialogFragment;
import com.box.android.base.presentation.fragments.AlertDialogFragmentListener;
import com.box.android.capture.ICaptureActivity;
import com.box.android.capture.R;
import com.box.android.capture.activities.CaptureActivity;
import com.box.android.capture.databinding.FragmentDocumentScanBaseBinding;
import com.box.android.capture.databinding.FragmentIntegratedDocumentScanBinding;
import com.box.android.capture.documentscanning.ScanPageReducer;
import com.box.android.cpl.Store;
import com.box.android.cpl.StoreKt;
import com.box.android.domain.models.DomainError;
import com.box.android.domain.models.ScannedDocumentPage;
import com.box.android.domain.utils.ExtensionsKt;
import com.box.androidsdk.content.utils.BoxLogUtils;
import com.bumptech.glide.Glide;
import com.bumptech.glide.RequestBuilder;
import com.bumptech.glide.signature.ObjectKey;
import com.geniusscansdk.camera.DetectionMode;
import com.geniusscansdk.camera.FileImageCaptureCallback;
import com.geniusscansdk.camera.ScanFragment;
import com.geniusscansdk.camera.realtime.BorderDetector;
import com.geniusscansdk.core.QuadStreamAnalyzer;
import com.geniusscansdk.core.RotationAngle;
import dagger.hilt.android.AndroidEntryPoint;
import java.io.File;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: compiled from: IntegratedDocumentScanFragment.kt */
/* JADX INFO: loaded from: classes10.dex */
@Metadata(d1 = {"\u0000x\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u0000 82\u00020\u00012\u00020\u00022\u00020\u0003:\u00018B\u001b\u0012\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0005¢\u0006\u0004\b\b\u0010\tJ$\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019H\u0016J\u001a\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u00132\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019H\u0016J\u001c\u0010\u001d\u001a\u00020\u001b2\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0005H\u0002J\u001c\u0010\u001e\u001a\u00020\u001b2\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0005H\u0002J\u001c\u0010\u001f\u001a\u00020\u001b2\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0005H\u0002J\u001c\u0010 \u001a\u00020\u001b2\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0005H\u0002J\u0010\u0010#\u001a\u00020\u001b2\u0006\u0010$\u001a\u00020\"H\u0002J\b\u0010%\u001a\u00020\u001bH\u0002J\b\u0010&\u001a\u00020\u001bH\u0002J\b\u0010'\u001a\u00020\u001bH\u0002J\b\u0010(\u001a\u00020\u001bH\u0002J\u0012\u0010)\u001a\u00020\u001b2\b\u0010*\u001a\u0004\u0018\u00010+H\u0016J\u0012\u0010,\u001a\u00020\u001b2\b\u0010*\u001a\u0004\u0018\u00010+H\u0016J\u0012\u0010-\u001a\u00020\u001b2\b\u0010*\u001a\u0004\u0018\u00010+H\u0016J\b\u0010.\u001a\u00020\u001bH\u0016J\b\u0010/\u001a\u00020\u001bH\u0002J\b\u00100\u001a\u00020\u001bH\u0002J\b\u00101\u001a\u000202H\u0016J\u0010\u00103\u001a\u0002042\b\u00105\u001a\u0004\u0018\u000106J\b\u00107\u001a\u00020\u001bH\u0002R\u001d\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u000e\u0010\f\u001a\u00020\rX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010!\u001a\u00020\"X\u0082\u000e¢\u0006\u0002\n\u0000¨\u00069"}, d2 = {"Lcom/box/android/capture/documentscanning/presentation/IntegratedDocumentScanFragment;", "Lcom/box/android/base/presentation/fragments/BoxFragment;", "Lcom/geniusscansdk/camera/ScanFragment$CameraCallbackProvider;", "Lcom/box/android/base/presentation/fragments/AlertDialogFragmentListener;", "store", "Lcom/box/android/cpl/Store;", "Lcom/box/android/capture/documentscanning/ScanPageReducer$State;", "Lcom/box/android/capture/documentscanning/ScanPageReducer$Action;", "<init>", "(Lcom/box/android/cpl/Store;)V", "getStore", "()Lcom/box/android/cpl/Store;", "scanFragment", "Lcom/geniusscansdk/camera/ScanFragment;", "binding", "Lcom/box/android/capture/databinding/FragmentIntegratedDocumentScanBinding;", "baseBinding", "Lcom/box/android/capture/databinding/FragmentDocumentScanBaseBinding;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", TtmlNode.RUBY_CONTAINER, "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onViewCreated", "", "view", "observePageCount", "observeLastScannedPage", "observeDiscarding", "observeSavedScanDialog", "savedScanDialogResultPending", "", "setScanControlsBlockedByRestoredScanPrompt", "blocked", "showSavedScanDialog", "setupUI", "supportEdgeToEdge", "showConfirmationDialog", "onAlertDialogFragmentPositiveButton", "tag", "", "onAlertDialogFragmentNeutralButton", "onAlertDialogFragmentDismissed", "onResume", "initializeCamera", "startAutoScanning", "getCameraCallback", "Lcom/geniusscansdk/camera/ScanFragment$Callback;", "getImageCaptureCallback", "Lcom/geniusscansdk/camera/FileImageCaptureCallback;", "outputFile", "Ljava/io/File;", "showCaptureHistory", "Companion", "capture_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
@AndroidEntryPoint
public final class IntegratedDocumentScanFragment extends Hilt_IntegratedDocumentScanFragment implements ScanFragment.CameraCallbackProvider, AlertDialogFragmentListener {
    private static final String CONFIRMATION_DIALOG_TAG = "confirmationDialogTag";
    private static final String SAVED_SCAN_DIALOG_TAG = "savedScanDialogTag";
    private FragmentDocumentScanBaseBinding baseBinding;
    private FragmentIntegratedDocumentScanBinding binding;
    private boolean savedScanDialogResultPending;
    private ScanFragment scanFragment;
    private final Store<ScanPageReducer.State, ScanPageReducer.Action> store;
    public static final int $stable = 8;

    public IntegratedDocumentScanFragment(Store<ScanPageReducer.State, ScanPageReducer.Action> store) {
        Intrinsics.checkNotNullParameter(store, "store");
        this.store = store;
    }

    @Override // com.box.android.base.presentation.fragments.AlertDialogFragmentListener
    public /* bridge */ void onAlertDialogFragmentNegativeButton(String str) {
        super.onAlertDialogFragmentNegativeButton(str);
    }

    public final Store<ScanPageReducer.State, ScanPageReducer.Action> getStore() {
        return this.store;
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        OnBackPressedDispatcherKt.addCallback$default(requireActivity().getOnBackPressedDispatcher(), getViewLifecycleOwner(), false, new Function1() { // from class: com.box.android.capture.documentscanning.presentation.IntegratedDocumentScanFragment$$ExternalSyntheticLambda7
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return IntegratedDocumentScanFragment.onCreateView$lambda$0(this.f$0, (OnBackPressedCallback) obj);
            }
        }, 2, null);
        FragmentIntegratedDocumentScanBinding fragmentIntegratedDocumentScanBindingInflate = FragmentIntegratedDocumentScanBinding.inflate(getLayoutInflater(), container, false);
        Intrinsics.checkNotNullExpressionValue(fragmentIntegratedDocumentScanBindingInflate, "inflate(...)");
        this.binding = fragmentIntegratedDocumentScanBindingInflate;
        FragmentIntegratedDocumentScanBinding fragmentIntegratedDocumentScanBinding = null;
        if (fragmentIntegratedDocumentScanBindingInflate == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            fragmentIntegratedDocumentScanBindingInflate = null;
        }
        FragmentDocumentScanBaseBinding fragmentDocumentScanBaseBindingBind = FragmentDocumentScanBaseBinding.bind(fragmentIntegratedDocumentScanBindingInflate.getRoot());
        Intrinsics.checkNotNullExpressionValue(fragmentDocumentScanBaseBindingBind, "bind(...)");
        this.baseBinding = fragmentDocumentScanBaseBindingBind;
        FragmentIntegratedDocumentScanBinding fragmentIntegratedDocumentScanBinding2 = this.binding;
        if (fragmentIntegratedDocumentScanBinding2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        } else {
            fragmentIntegratedDocumentScanBinding = fragmentIntegratedDocumentScanBinding2;
        }
        ConstraintLayout root = fragmentIntegratedDocumentScanBinding.getRoot();
        Intrinsics.checkNotNullExpressionValue(root, "getRoot(...)");
        return root;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit onCreateView$lambda$0(IntegratedDocumentScanFragment integratedDocumentScanFragment, OnBackPressedCallback addCallback) {
        Intrinsics.checkNotNullParameter(addCallback, "$this$addCallback");
        if (integratedDocumentScanFragment.store.getState().getValue().isAwaitingRestoredScanDecision()) {
            Fragment fragmentFindFragmentByTag = integratedDocumentScanFragment.getChildFragmentManager().findFragmentByTag(SAVED_SCAN_DIALOG_TAG);
            DialogFragment dialogFragment = fragmentFindFragmentByTag instanceof DialogFragment ? (DialogFragment) fragmentFindFragmentByTag : null;
            if (dialogFragment != null) {
                dialogFragment.dismiss();
            }
            return Unit.INSTANCE;
        }
        integratedDocumentScanFragment.store.send(ScanPageReducer.Action.TryDiscardScans.INSTANCE);
        return Unit.INSTANCE;
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, savedInstanceState);
        setupUI();
        LifecycleOwner viewLifecycleOwner = getViewLifecycleOwner();
        Intrinsics.checkNotNullExpressionValue(viewLifecycleOwner, "getViewLifecycleOwner(...)");
        BuildersKt__Builders_commonKt.launch$default(LifecycleOwnerKt.getLifecycleScope(viewLifecycleOwner), null, null, new C09911(null), 3, null);
    }

    /* JADX INFO: renamed from: com.box.android.capture.documentscanning.presentation.IntegratedDocumentScanFragment$onViewCreated$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: IntegratedDocumentScanFragment.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.box.android.capture.documentscanning.presentation.IntegratedDocumentScanFragment$onViewCreated$1", f = "IntegratedDocumentScanFragment.kt", i = {}, l = {82}, m = "invokeSuspend", n = {}, s = {}, v = 1)
    static final class C09911 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;

        C09911(Continuation<? super C09911> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return IntegratedDocumentScanFragment.this.new C09911(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C09911) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX INFO: renamed from: com.box.android.capture.documentscanning.presentation.IntegratedDocumentScanFragment$onViewCreated$1$1, reason: invalid class name and collision with other inner class name */
        /* JADX INFO: compiled from: IntegratedDocumentScanFragment.kt */
        @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
        @DebugMetadata(c = "com.box.android.capture.documentscanning.presentation.IntegratedDocumentScanFragment$onViewCreated$1$1", f = "IntegratedDocumentScanFragment.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {}, v = 1)
        static final class C01431 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
            int label;
            final /* synthetic */ IntegratedDocumentScanFragment this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            C01431(IntegratedDocumentScanFragment integratedDocumentScanFragment, Continuation<? super C01431> continuation) {
                super(2, continuation);
                this.this$0 = integratedDocumentScanFragment;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                return new C01431(this.this$0, continuation);
            }

            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                return ((C01431) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object obj) {
                IntrinsicsKt.getCOROUTINE_SUSPENDED();
                if (this.label != 0) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
                IntegratedDocumentScanFragment integratedDocumentScanFragment = this.this$0;
                integratedDocumentScanFragment.observePageCount(integratedDocumentScanFragment.getStore());
                IntegratedDocumentScanFragment integratedDocumentScanFragment2 = this.this$0;
                integratedDocumentScanFragment2.observeLastScannedPage(integratedDocumentScanFragment2.getStore());
                IntegratedDocumentScanFragment integratedDocumentScanFragment3 = this.this$0;
                integratedDocumentScanFragment3.observeDiscarding(integratedDocumentScanFragment3.getStore());
                IntegratedDocumentScanFragment integratedDocumentScanFragment4 = this.this$0;
                integratedDocumentScanFragment4.observeSavedScanDialog(integratedDocumentScanFragment4.getStore());
                return Unit.INSTANCE;
            }
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                LifecycleOwner viewLifecycleOwner = IntegratedDocumentScanFragment.this.getViewLifecycleOwner();
                Intrinsics.checkNotNullExpressionValue(viewLifecycleOwner, "getViewLifecycleOwner(...)");
                this.label = 1;
                if (RepeatOnLifecycleKt.repeatOnLifecycle(viewLifecycleOwner, Lifecycle.State.CREATED, new C01431(IntegratedDocumentScanFragment.this, null), this) == coroutine_suspended) {
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
    public final void observePageCount(Store<ScanPageReducer.State, ScanPageReducer.Action> store) {
        StoreKt.observe(store, new PropertyReference1Impl() { // from class: com.box.android.capture.documentscanning.presentation.IntegratedDocumentScanFragment.observePageCount.1
            @Override // kotlin.jvm.internal.PropertyReference1Impl, kotlin.reflect.KProperty1
            public Object get(Object obj) {
                return Integer.valueOf(((ScanPageReducer.State) obj).getPageCount());
            }
        }, LifecycleOwnerKt.getLifecycleScope(this), new Function1() { // from class: com.box.android.capture.documentscanning.presentation.IntegratedDocumentScanFragment$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return IntegratedDocumentScanFragment.observePageCount$lambda$0(this.f$0, ((Integer) obj).intValue());
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit observePageCount$lambda$0(IntegratedDocumentScanFragment integratedDocumentScanFragment, int i) {
        FragmentDocumentScanBaseBinding fragmentDocumentScanBaseBinding = integratedDocumentScanFragment.baseBinding;
        FragmentDocumentScanBaseBinding fragmentDocumentScanBaseBinding2 = null;
        if (fragmentDocumentScanBaseBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("baseBinding");
            fragmentDocumentScanBaseBinding = null;
        }
        fragmentDocumentScanBaseBinding.documentScanShutterButton.setText(String.valueOf(i));
        FragmentDocumentScanBaseBinding fragmentDocumentScanBaseBinding3 = integratedDocumentScanFragment.baseBinding;
        if (fragmentDocumentScanBaseBinding3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("baseBinding");
        } else {
            fragmentDocumentScanBaseBinding2 = fragmentDocumentScanBaseBinding3;
        }
        fragmentDocumentScanBaseBinding2.documentScanUpload.setVisibility(i > 0 ? 0 : 4);
        integratedDocumentScanFragment.startAutoScanning();
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void observeLastScannedPage(Store<ScanPageReducer.State, ScanPageReducer.Action> store) {
        StoreKt.observe(store, new PropertyReference1Impl() { // from class: com.box.android.capture.documentscanning.presentation.IntegratedDocumentScanFragment.observeLastScannedPage.1
            @Override // kotlin.jvm.internal.PropertyReference1Impl, kotlin.reflect.KProperty1
            public Object get(Object obj) {
                return ((ScanPageReducer.State) obj).getLastScannedPage();
            }
        }, LifecycleOwnerKt.getLifecycleScope(this), new Function1() { // from class: com.box.android.capture.documentscanning.presentation.IntegratedDocumentScanFragment$$ExternalSyntheticLambda10
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return IntegratedDocumentScanFragment.observeLastScannedPage$lambda$0(this.f$0, (ScannedDocumentPage) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit observeLastScannedPage$lambda$0(IntegratedDocumentScanFragment integratedDocumentScanFragment, ScannedDocumentPage scannedDocumentPage) {
        FragmentDocumentScanBaseBinding fragmentDocumentScanBaseBinding = null;
        if (scannedDocumentPage != null) {
            FragmentDocumentScanBaseBinding fragmentDocumentScanBaseBinding2 = integratedDocumentScanFragment.baseBinding;
            if (fragmentDocumentScanBaseBinding2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("baseBinding");
                fragmentDocumentScanBaseBinding2 = null;
            }
            fragmentDocumentScanBaseBinding2.documentScanThumbnailButton.setVisibility(0);
            FragmentDocumentScanBaseBinding fragmentDocumentScanBaseBinding3 = integratedDocumentScanFragment.baseBinding;
            if (fragmentDocumentScanBaseBinding3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("baseBinding");
                fragmentDocumentScanBaseBinding3 = null;
            }
            fragmentDocumentScanBaseBinding3.documentScanThumbnailButton.setRotation(scannedDocumentPage.getRotationAngle());
            RequestBuilder requestBuilderCircleCrop = Glide.with(integratedDocumentScanFragment.requireContext()).load(scannedDocumentPage.getEnhancedImagePath()).signature(new ObjectKey(Integer.valueOf(scannedDocumentPage.getVersion()))).fitCenter().circleCrop();
            FragmentDocumentScanBaseBinding fragmentDocumentScanBaseBinding4 = integratedDocumentScanFragment.baseBinding;
            if (fragmentDocumentScanBaseBinding4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("baseBinding");
                fragmentDocumentScanBaseBinding4 = null;
            }
            requestBuilderCircleCrop.into(fragmentDocumentScanBaseBinding4.documentScanThumbnailButton);
            FragmentDocumentScanBaseBinding fragmentDocumentScanBaseBinding5 = integratedDocumentScanFragment.baseBinding;
            if (fragmentDocumentScanBaseBinding5 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("baseBinding");
            } else {
                fragmentDocumentScanBaseBinding = fragmentDocumentScanBaseBinding5;
            }
            fragmentDocumentScanBaseBinding.documentScanCaptureHistoryButton.setVisibility(4);
        } else {
            FragmentDocumentScanBaseBinding fragmentDocumentScanBaseBinding6 = integratedDocumentScanFragment.baseBinding;
            if (fragmentDocumentScanBaseBinding6 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("baseBinding");
                fragmentDocumentScanBaseBinding6 = null;
            }
            fragmentDocumentScanBaseBinding6.documentScanThumbnailButton.setVisibility(4);
            FragmentDocumentScanBaseBinding fragmentDocumentScanBaseBinding7 = integratedDocumentScanFragment.baseBinding;
            if (fragmentDocumentScanBaseBinding7 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("baseBinding");
            } else {
                fragmentDocumentScanBaseBinding = fragmentDocumentScanBaseBinding7;
            }
            fragmentDocumentScanBaseBinding.documentScanCaptureHistoryButton.setVisibility(0);
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void observeDiscarding(Store<ScanPageReducer.State, ScanPageReducer.Action> store) {
        StoreKt.observe(store, new PropertyReference1Impl() { // from class: com.box.android.capture.documentscanning.presentation.IntegratedDocumentScanFragment.observeDiscarding.1
            @Override // kotlin.jvm.internal.PropertyReference1Impl, kotlin.reflect.KProperty1
            public Object get(Object obj) {
                return Boolean.valueOf(((ScanPageReducer.State) obj).isDiscardingScans());
            }
        }, LifecycleOwnerKt.getLifecycleScope(this), new Function1() { // from class: com.box.android.capture.documentscanning.presentation.IntegratedDocumentScanFragment$$ExternalSyntheticLambda6
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return IntegratedDocumentScanFragment.observeDiscarding$lambda$0(this.f$0, ((Boolean) obj).booleanValue());
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit observeDiscarding$lambda$0(IntegratedDocumentScanFragment integratedDocumentScanFragment, boolean z) {
        if (z) {
            integratedDocumentScanFragment.showConfirmationDialog();
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void observeSavedScanDialog(Store<ScanPageReducer.State, ScanPageReducer.Action> store) {
        StoreKt.observe(store, new PropertyReference1Impl() { // from class: com.box.android.capture.documentscanning.presentation.IntegratedDocumentScanFragment.observeSavedScanDialog.1
            @Override // kotlin.jvm.internal.PropertyReference1Impl, kotlin.reflect.KProperty1
            public Object get(Object obj) {
                return Boolean.valueOf(((ScanPageReducer.State) obj).isAwaitingRestoredScanDecision());
            }
        }, LifecycleOwnerKt.getLifecycleScope(this), new Function1() { // from class: com.box.android.capture.documentscanning.presentation.IntegratedDocumentScanFragment$$ExternalSyntheticLambda9
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return IntegratedDocumentScanFragment.observeSavedScanDialog$lambda$0(this.f$0, ((Boolean) obj).booleanValue());
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit observeSavedScanDialog$lambda$0(IntegratedDocumentScanFragment integratedDocumentScanFragment, boolean z) {
        if (z) {
            integratedDocumentScanFragment.showSavedScanDialog();
        }
        integratedDocumentScanFragment.setScanControlsBlockedByRestoredScanPrompt(z);
        return Unit.INSTANCE;
    }

    private final void setScanControlsBlockedByRestoredScanPrompt(boolean blocked) {
        FragmentDocumentScanBaseBinding fragmentDocumentScanBaseBinding = this.baseBinding;
        if (fragmentDocumentScanBaseBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("baseBinding");
            fragmentDocumentScanBaseBinding = null;
        }
        fragmentDocumentScanBaseBinding.documentScanShutterButton.setEnabled(!blocked);
        FragmentDocumentScanBaseBinding fragmentDocumentScanBaseBinding2 = this.baseBinding;
        if (fragmentDocumentScanBaseBinding2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("baseBinding");
            fragmentDocumentScanBaseBinding2 = null;
        }
        fragmentDocumentScanBaseBinding2.documentScanUpload.setEnabled(!blocked);
        FragmentDocumentScanBaseBinding fragmentDocumentScanBaseBinding3 = this.baseBinding;
        if (fragmentDocumentScanBaseBinding3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("baseBinding");
            fragmentDocumentScanBaseBinding3 = null;
        }
        fragmentDocumentScanBaseBinding3.documentScanThumbnailButton.setEnabled(!blocked);
        if (blocked) {
            ScanFragment scanFragment = this.scanFragment;
            if (scanFragment == null) {
                Intrinsics.throwUninitializedPropertyAccessException("scanFragment");
                scanFragment = null;
            }
            scanFragment.setDetectionMode(DetectionMode.Disabled.INSTANCE);
            ScanFragment scanFragment2 = this.scanFragment;
            if (scanFragment2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("scanFragment");
                scanFragment2 = null;
            }
            scanFragment2.setBorderDetectorListener(null);
            return;
        }
        startAutoScanning();
    }

    private final void showSavedScanDialog() {
        if (getChildFragmentManager().findFragmentByTag(SAVED_SCAN_DIALOG_TAG) != null) {
            return;
        }
        this.savedScanDialogResultPending = true;
        new AlertDialogFragment().setTitle(R.string.document_scan_saved_scan_title).setMessage(R.string.document_scan_saved_scan_message).setPositiveButtonId(R.string.document_scan_keep).setNeutralButtonId(R.string.document_scan_confirm_discard).show(getChildFragmentManager(), SAVED_SCAN_DIALOG_TAG);
    }

    private final void setupUI() {
        Fragment fragmentFindFragmentById = getChildFragmentManager().findFragmentById(R.id.scan_fragment);
        Intrinsics.checkNotNull(fragmentFindFragmentById, "null cannot be cast to non-null type com.geniusscansdk.camera.ScanFragment");
        ScanFragment scanFragment = (ScanFragment) fragmentFindFragmentById;
        this.scanFragment = scanFragment;
        FragmentDocumentScanBaseBinding fragmentDocumentScanBaseBinding = null;
        if (scanFragment == null) {
            Intrinsics.throwUninitializedPropertyAccessException("scanFragment");
            scanFragment = null;
        }
        scanFragment.setOverlayColorResource(R.color.box_blue_50);
        ScanFragment scanFragment2 = this.scanFragment;
        if (scanFragment2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("scanFragment");
            scanFragment2 = null;
        }
        scanFragment2.setPreviewAspectFill(true);
        ScanFragment scanFragment3 = this.scanFragment;
        if (scanFragment3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("scanFragment");
            scanFragment3 = null;
        }
        FragmentDocumentScanBaseBinding fragmentDocumentScanBaseBinding2 = this.baseBinding;
        if (fragmentDocumentScanBaseBinding2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("baseBinding");
            fragmentDocumentScanBaseBinding2 = null;
        }
        scanFragment3.setFocusIndicator(fragmentDocumentScanBaseBinding2.focusIndicator);
        ScanFragment scanFragment4 = this.scanFragment;
        if (scanFragment4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("scanFragment");
            scanFragment4 = null;
        }
        scanFragment4.setAutoTriggerAnimationEnabled(true);
        supportEdgeToEdge();
        FragmentDocumentScanBaseBinding fragmentDocumentScanBaseBinding3 = this.baseBinding;
        if (fragmentDocumentScanBaseBinding3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("baseBinding");
            fragmentDocumentScanBaseBinding3 = null;
        }
        fragmentDocumentScanBaseBinding3.documentScanShutterButton.setOnClickListener(new View.OnClickListener() { // from class: com.box.android.capture.documentscanning.presentation.IntegratedDocumentScanFragment$$ExternalSyntheticLambda2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                IntegratedDocumentScanFragment.setupUI$lambda$0(this.f$0, view);
            }
        });
        FragmentDocumentScanBaseBinding fragmentDocumentScanBaseBinding4 = this.baseBinding;
        if (fragmentDocumentScanBaseBinding4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("baseBinding");
            fragmentDocumentScanBaseBinding4 = null;
        }
        fragmentDocumentScanBaseBinding4.documentScanUpload.setOnClickListener(new View.OnClickListener() { // from class: com.box.android.capture.documentscanning.presentation.IntegratedDocumentScanFragment$$ExternalSyntheticLambda3
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                IntegratedDocumentScanFragment.setupUI$lambda$1(this.f$0, view);
            }
        });
        FragmentDocumentScanBaseBinding fragmentDocumentScanBaseBinding5 = this.baseBinding;
        if (fragmentDocumentScanBaseBinding5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("baseBinding");
            fragmentDocumentScanBaseBinding5 = null;
        }
        fragmentDocumentScanBaseBinding5.documentScanThumbnailButton.setOnClickListener(new View.OnClickListener() { // from class: com.box.android.capture.documentscanning.presentation.IntegratedDocumentScanFragment$$ExternalSyntheticLambda4
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                IntegratedDocumentScanFragment.setupUI$lambda$2(this.f$0, view);
            }
        });
        FragmentDocumentScanBaseBinding fragmentDocumentScanBaseBinding6 = this.baseBinding;
        if (fragmentDocumentScanBaseBinding6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("baseBinding");
            fragmentDocumentScanBaseBinding6 = null;
        }
        fragmentDocumentScanBaseBinding6.documentScanCaptureHistoryButton.initView(this);
        FragmentDocumentScanBaseBinding fragmentDocumentScanBaseBinding7 = this.baseBinding;
        if (fragmentDocumentScanBaseBinding7 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("baseBinding");
        } else {
            fragmentDocumentScanBaseBinding = fragmentDocumentScanBaseBinding7;
        }
        fragmentDocumentScanBaseBinding.documentScanCaptureHistoryButton.setOnClickListener(new View.OnClickListener() { // from class: com.box.android.capture.documentscanning.presentation.IntegratedDocumentScanFragment$$ExternalSyntheticLambda5
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.showCaptureHistory();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setupUI$lambda$0(IntegratedDocumentScanFragment integratedDocumentScanFragment, View view) {
        if (integratedDocumentScanFragment.store.getState().getValue().isAwaitingRestoredScanDecision()) {
            return;
        }
        FragmentDocumentScanBaseBinding fragmentDocumentScanBaseBinding = integratedDocumentScanFragment.baseBinding;
        ScanFragment scanFragment = null;
        if (fragmentDocumentScanBaseBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("baseBinding");
            fragmentDocumentScanBaseBinding = null;
        }
        fragmentDocumentScanBaseBinding.documentScanShutterButton.setEnabled(false);
        integratedDocumentScanFragment.store.send(ScanPageReducer.Action.ManualCapturePhoto.INSTANCE);
        ScanFragment scanFragment2 = integratedDocumentScanFragment.scanFragment;
        if (scanFragment2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("scanFragment");
        } else {
            scanFragment = scanFragment2;
        }
        scanFragment.takePicture(integratedDocumentScanFragment.getImageCaptureCallback(integratedDocumentScanFragment.store.getState().getValue().getOutputFile()), false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setupUI$lambda$1(IntegratedDocumentScanFragment integratedDocumentScanFragment, View view) {
        if (integratedDocumentScanFragment.store.getState().getValue().isAwaitingRestoredScanDecision()) {
            return;
        }
        ScanFragment scanFragment = integratedDocumentScanFragment.scanFragment;
        DefaultConstructorMarker defaultConstructorMarker = null;
        if (scanFragment == null) {
            Intrinsics.throwUninitializedPropertyAccessException("scanFragment");
            scanFragment = null;
        }
        scanFragment.setDetectionMode(DetectionMode.Disabled.INSTANCE);
        ScanFragment scanFragment2 = integratedDocumentScanFragment.scanFragment;
        if (scanFragment2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("scanFragment");
            scanFragment2 = null;
        }
        scanFragment2.setBorderDetectorListener(null);
        integratedDocumentScanFragment.store.send(new ScanPageReducer.Action.SaveDocument(false, 1, defaultConstructorMarker));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setupUI$lambda$2(IntegratedDocumentScanFragment integratedDocumentScanFragment, View view) {
        if (integratedDocumentScanFragment.store.getState().getValue().isAwaitingRestoredScanDecision()) {
            return;
        }
        integratedDocumentScanFragment.store.send(ScanPageReducer.Action.ClickThumbnail.INSTANCE);
    }

    private final void supportEdgeToEdge() {
        FragmentDocumentScanBaseBinding fragmentDocumentScanBaseBinding = this.baseBinding;
        FragmentIntegratedDocumentScanBinding fragmentIntegratedDocumentScanBinding = null;
        if (fragmentDocumentScanBaseBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("baseBinding");
            fragmentDocumentScanBaseBinding = null;
        }
        final Guideline guidelineBottomInset = fragmentDocumentScanBaseBinding.guidelineBottomInset;
        Intrinsics.checkNotNullExpressionValue(guidelineBottomInset, "guidelineBottomInset");
        FragmentIntegratedDocumentScanBinding fragmentIntegratedDocumentScanBinding2 = this.binding;
        if (fragmentIntegratedDocumentScanBinding2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        } else {
            fragmentIntegratedDocumentScanBinding = fragmentIntegratedDocumentScanBinding2;
        }
        ConstraintLayout root = fragmentIntegratedDocumentScanBinding.getRoot();
        Intrinsics.checkNotNullExpressionValue(root, "getRoot(...)");
        ViewCompat.setOnApplyWindowInsetsListener(root, new OnApplyWindowInsetsListener() { // from class: com.box.android.capture.documentscanning.presentation.IntegratedDocumentScanFragment$$ExternalSyntheticLambda1
            @Override // androidx.core.view.OnApplyWindowInsetsListener
            public final WindowInsetsCompat onApplyWindowInsets(View view, WindowInsetsCompat windowInsetsCompat) {
                return IntegratedDocumentScanFragment.supportEdgeToEdge$lambda$0(guidelineBottomInset, view, windowInsetsCompat);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final WindowInsetsCompat supportEdgeToEdge$lambda$0(Guideline guideline, View view, WindowInsetsCompat insets) {
        Intrinsics.checkNotNullParameter(view, "<unused var>");
        Intrinsics.checkNotNullParameter(insets, "insets");
        int i = insets.getInsets(WindowInsetsCompat.Type.systemBars()).bottom;
        Guideline guideline2 = guideline;
        ViewGroup.LayoutParams layoutParams = guideline2.getLayoutParams();
        if (layoutParams == null) {
            throw new NullPointerException("null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
        }
        ConstraintLayout.LayoutParams layoutParams2 = (ConstraintLayout.LayoutParams) layoutParams;
        ConstraintLayout.LayoutParams layoutParams3 = layoutParams2;
        ViewGroup.LayoutParams layoutParams4 = guideline2.getLayoutParams();
        ViewGroup.MarginLayoutParams marginLayoutParams = layoutParams4 instanceof ViewGroup.MarginLayoutParams ? (ViewGroup.MarginLayoutParams) layoutParams4 : null;
        layoutParams3.guideEnd = i + (marginLayoutParams != null ? marginLayoutParams.bottomMargin : 0);
        guideline2.setLayoutParams(layoutParams2);
        return WindowInsetsCompat.CONSUMED;
    }

    private final void showConfirmationDialog() {
        new AlertDialogFragment().setTitle(R.string.document_scan_confirm_discard_title).setMessage(R.string.document_scan_confirm_discard_body).setPositiveButtonId(R.string.document_scan_confirm_discard).setNeutralButtonId(R.string.alert_dialog_cancel).show(getChildFragmentManager(), CONFIRMATION_DIALOG_TAG);
    }

    @Override // com.box.android.base.presentation.fragments.AlertDialogFragmentListener
    public void onAlertDialogFragmentPositiveButton(String tag) {
        if (Intrinsics.areEqual(tag, CONFIRMATION_DIALOG_TAG)) {
            this.store.send(ScanPageReducer.Action.DiscardScans.INSTANCE);
        } else if (Intrinsics.areEqual(tag, SAVED_SCAN_DIALOG_TAG)) {
            this.savedScanDialogResultPending = false;
            this.store.send(ScanPageReducer.Action.RestoredScanKept.INSTANCE);
        }
    }

    @Override // com.box.android.base.presentation.fragments.AlertDialogFragmentListener
    public void onAlertDialogFragmentNeutralButton(String tag) {
        if (Intrinsics.areEqual(tag, CONFIRMATION_DIALOG_TAG)) {
            this.store.send(ScanPageReducer.Action.CancelDiscardScans.INSTANCE);
        } else if (Intrinsics.areEqual(tag, SAVED_SCAN_DIALOG_TAG)) {
            this.savedScanDialogResultPending = false;
            this.store.send(ScanPageReducer.Action.RestoredScanDiscarded.INSTANCE);
        }
    }

    @Override // com.box.android.base.presentation.fragments.AlertDialogFragmentListener
    public void onAlertDialogFragmentDismissed(String tag) {
        if (Intrinsics.areEqual(tag, CONFIRMATION_DIALOG_TAG)) {
            this.store.send(ScanPageReducer.Action.CancelDiscardScans.INSTANCE);
        } else if (Intrinsics.areEqual(tag, SAVED_SCAN_DIALOG_TAG) && this.savedScanDialogResultPending) {
            this.savedScanDialogResultPending = false;
            this.store.send(ScanPageReducer.Action.RestoredScanKept.INSTANCE);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        initializeCamera();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void initializeCamera() {
        FragmentActivity fragmentActivityRequireActivity = requireActivity();
        Intrinsics.checkNotNull(fragmentActivityRequireActivity, "null cannot be cast to non-null type com.box.android.capture.activities.CaptureActivity");
        if (!((CaptureActivity) fragmentActivityRequireActivity).areAllCamerasAvailable()) {
            new Handler(Looper.getMainLooper()).postDelayed(new Runnable() { // from class: com.box.android.capture.documentscanning.presentation.IntegratedDocumentScanFragment$$ExternalSyntheticLambda8
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.initializeCamera();
                }
            }, 50L);
            return;
        }
        ScanFragment scanFragment = this.scanFragment;
        if (scanFragment == null) {
            Intrinsics.throwUninitializedPropertyAccessException("scanFragment");
            scanFragment = null;
        }
        scanFragment.initializeCamera();
    }

    private final void startAutoScanning() {
        ScanFragment scanFragment = this.scanFragment;
        ScanFragment scanFragment2 = null;
        if (scanFragment == null) {
            Intrinsics.throwUninitializedPropertyAccessException("scanFragment");
            scanFragment = null;
        }
        scanFragment.setDetectionMode(DetectionMode.Document.INSTANCE);
        ScanFragment scanFragment3 = this.scanFragment;
        if (scanFragment3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("scanFragment");
        } else {
            scanFragment2 = scanFragment3;
        }
        scanFragment2.setBorderDetectorListener(new BorderDetector.BorderDetectorListener() { // from class: com.box.android.capture.documentscanning.presentation.IntegratedDocumentScanFragment.startAutoScanning.1

            /* JADX INFO: renamed from: com.box.android.capture.documentscanning.presentation.IntegratedDocumentScanFragment$startAutoScanning$1$WhenMappings */
            /* JADX INFO: compiled from: IntegratedDocumentScanFragment.kt */
            @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
            public static final /* synthetic */ class WhenMappings {
                public static final /* synthetic */ int[] $EnumSwitchMapping$0;

                static {
                    int[] iArr = new int[QuadStreamAnalyzer.Status.values().length];
                    try {
                        iArr[QuadStreamAnalyzer.Status.TRIGGER.ordinal()] = 1;
                    } catch (NoSuchFieldError unused) {
                    }
                    $EnumSwitchMapping$0 = iArr;
                }
            }

            @Override // com.geniusscansdk.camera.realtime.BorderDetector.BorderDetectorListener
            public void onBorderDetectionResult(QuadStreamAnalyzer.Result result) {
                ScanFragment scanFragment4 = null;
                QuadStreamAnalyzer.Status status = result != null ? result.status : null;
                if ((status == null ? -1 : WhenMappings.$EnumSwitchMapping$0[status.ordinal()]) == 1) {
                    if (IntegratedDocumentScanFragment.this.getStore().getState().getValue().isAwaitingRestoredScanDecision()) {
                        return;
                    }
                    FragmentDocumentScanBaseBinding fragmentDocumentScanBaseBinding = IntegratedDocumentScanFragment.this.baseBinding;
                    if (fragmentDocumentScanBaseBinding == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("baseBinding");
                        fragmentDocumentScanBaseBinding = null;
                    }
                    fragmentDocumentScanBaseBinding.documentScanShutterButton.setEnabled(false);
                    IntegratedDocumentScanFragment.this.getStore().send(ScanPageReducer.Action.AutoCapturePhoto.INSTANCE);
                    ScanFragment scanFragment5 = IntegratedDocumentScanFragment.this.scanFragment;
                    if (scanFragment5 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("scanFragment");
                    } else {
                        scanFragment4 = scanFragment5;
                    }
                    IntegratedDocumentScanFragment integratedDocumentScanFragment = IntegratedDocumentScanFragment.this;
                    File outputFile = integratedDocumentScanFragment.getStore().getState().getValue().getOutputFile();
                    Intrinsics.checkNotNull(outputFile);
                    scanFragment4.takePicture(integratedDocumentScanFragment.getImageCaptureCallback(outputFile));
                    return;
                }
                BoxLogUtils.v(ExtensionsKt.getTAG(this), "Auto scanning result: " + (result != null ? result.status : null));
            }

            @Override // com.geniusscansdk.camera.realtime.BorderDetector.BorderDetectorListener
            public void onBorderDetectionFailure(Exception exception) {
                Intrinsics.checkNotNullParameter(exception, "exception");
                BoxLogUtils.e(ExtensionsKt.getTAG(this), exception);
            }
        });
    }

    @Override // com.geniusscansdk.camera.ScanFragment.CameraCallbackProvider
    public ScanFragment.Callback getCameraCallback() {
        return new ScanFragment.Callback() { // from class: com.box.android.capture.documentscanning.presentation.IntegratedDocumentScanFragment.getCameraCallback.1
            @Override // com.geniusscansdk.camera.ScanFragment.Callback
            public void onCameraFailure() {
            }

            @Override // com.geniusscansdk.camera.ScanFragment.Callback
            public void onPreviewFrame(byte[] bytes, int width, int height, int format) {
                Intrinsics.checkNotNullParameter(bytes, "bytes");
            }

            @Override // com.geniusscansdk.camera.ScanFragment.Callback
            public void onShutterTriggered() {
            }

            @Override // com.geniusscansdk.camera.ScanFragment.Callback
            public void onCameraReady() {
                BuildersKt__Builders_commonKt.launch$default(LifecycleOwnerKt.getLifecycleScope(IntegratedDocumentScanFragment.this), null, null, new IntegratedDocumentScanFragment$getCameraCallback$1$onCameraReady$1(IntegratedDocumentScanFragment.this, null), 3, null);
            }
        };
    }

    public final FileImageCaptureCallback getImageCaptureCallback(File outputFile) {
        return new FileImageCaptureCallback(outputFile, this) { // from class: com.box.android.capture.documentscanning.presentation.IntegratedDocumentScanFragment.getImageCaptureCallback.1
            final /* synthetic */ File $outputFile;
            final /* synthetic */ IntegratedDocumentScanFragment this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(outputFile);
                this.$outputFile = outputFile;
                this.this$0 = this;
            }

            @Override // com.geniusscansdk.camera.FileImageCaptureCallback
            public void onImageCaptured(RotationAngle imageOrientation) {
                File file = this.$outputFile;
                if (file != null) {
                    this.this$0.getStore().send(new ScanPageReducer.Action.PhotoFetched(imageOrientation != null ? imageOrientation.getClockwiseDegrees() : 0, file));
                } else {
                    onError(new Exception("Null image capture output file"));
                }
            }

            @Override // com.geniusscansdk.camera.ImageCaptureCallback
            public void onError(Exception exception) {
                Intrinsics.checkNotNullParameter(exception, "exception");
                BoxLogUtils.e(ExtensionsKt.getTAG(this), exception);
                Store<ScanPageReducer.State, ScanPageReducer.Action> store = this.this$0.getStore();
                File file = this.$outputFile;
                store.send(new ScanPageReducer.Action.Error(new DomainError.CacheWriteError("Failed to save capture image to " + (file != null ? file.getAbsolutePath() : null))));
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void showCaptureHistory() {
        FragmentManager parentFragmentManager = getParentFragmentManager();
        Intrinsics.checkNotNullExpressionValue(parentFragmentManager, "getParentFragmentManager(...)");
        FragmentTransaction fragmentTransactionBeginTransaction = parentFragmentManager.beginTransaction();
        fragmentTransactionBeginTransaction.addToBackStack(null);
        KeyEventDispatcher.Component activity = getActivity();
        ICaptureActivity iCaptureActivity = activity instanceof ICaptureActivity ? (ICaptureActivity) activity : null;
        if (iCaptureActivity != null) {
            iCaptureActivity.showCaptureHistory(fragmentTransactionBeginTransaction);
        }
        fragmentTransactionBeginTransaction.commit();
    }
}
