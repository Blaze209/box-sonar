package com.geniusscansdk.scanflow;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import androidx.activity.OnBackPressedCallback;
import androidx.activity.OnBackPressedDispatcher;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.os.BundleCompat;
import androidx.core.view.AccessibilityDelegateCompat;
import androidx.core.view.ViewCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentResultListener;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.media3.extractor.text.ttml.TtmlNode;
import com.box.android.data.api.models.annotations.Location;
import com.facebook.react.uimanager.ViewProps;
import com.geniusscansdk.BitmapLoader;
import com.geniusscansdk.R;
import com.geniusscansdk.core.GeniusScanSDK;
import com.geniusscansdk.core.LicenseException;
import com.geniusscansdk.core.ProcessingException;
import com.geniusscansdk.core.Quadrangle;
import com.geniusscansdk.core.RotationAngle;
import com.geniusscansdk.core.ScanProcessor;
import com.google.android.material.button.MaterialButton;
import com.microsoft.identity.common.internal.broker.SerializedNames;
import java.io.File;
import java.io.IOException;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineExceptionHandler;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Job;

/* JADX INFO: compiled from: PostProcessingFragment.kt */
/* JADX INFO: loaded from: classes13.dex */
@Metadata(d1 = {"\u0000²\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\u0018\u0000 T2\u00020\u0001:\u0001TB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010$\u001a\u00020%2\b\u0010&\u001a\u0004\u0018\u00010'H\u0016J&\u0010(\u001a\u0004\u0018\u00010)2\u0006\u0010*\u001a\u00020+2\b\u0010,\u001a\u0004\u0018\u00010-2\b\u0010&\u001a\u0004\u0018\u00010'H\u0016J\b\u0010.\u001a\u00020%H\u0016J\u0010\u0010/\u001a\u00020%2\u0006\u00100\u001a\u00020'H\u0016J\u0010\u00101\u001a\u00020%2\u0006\u00102\u001a\u00020\u000bH\u0002J\b\u00103\u001a\u00020%H\u0002J\b\u00104\u001a\u00020%H\u0002J\b\u00105\u001a\u00020%H\u0002J\b\u00106\u001a\u000207H\u0002J\u0010\u00108\u001a\u00020%2\u0006\u00109\u001a\u00020:H\u0002J\u000e\u0010;\u001a\u00020%H\u0082@¢\u0006\u0002\u0010<J\b\u0010=\u001a\u00020%H\u0002J\u0012\u0010>\u001a\u00020%2\b\u0010?\u001a\u0004\u0018\u00010@H\u0002J\u0016\u0010A\u001a\u00020%2\u0006\u0010B\u001a\u00020CH\u0082@¢\u0006\u0002\u0010DJ\b\u0010E\u001a\u00020%H\u0002J\b\u0010F\u001a\u00020%H\u0002J\b\u0010G\u001a\u00020%H\u0002J\b\u0010H\u001a\u00020%H\u0002J\b\u0010I\u001a\u00020%H\u0002J,\u0010N\u001a\u00020%2\u001c\u0010O\u001a\u0018\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00020%0Q\u0012\u0006\u0012\u0004\u0018\u00010R0PH\u0082@¢\u0006\u0002\u0010SR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0012X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0015X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0017X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0017X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u0017X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u0017X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u0017X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u0017X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\u0017X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\u001fX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010 \u001a\u00020!X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\"\u001a\u00020#X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010J\u001a\u00020K8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\bL\u0010M¨\u0006U"}, d2 = {"Lcom/geniusscansdk/scanflow/PostProcessingFragment;", "Landroidx/fragment/app/Fragment;", "<init>", "()V", "scanConfiguration", "Lcom/geniusscansdk/scanflow/ScanConfiguration;", "bitmapLoader", "Lcom/geniusscansdk/BitmapLoader;", Location.TYPE_PAGE, "Lcom/geniusscansdk/scanflow/Page;", "isProcessing", "", "filterFragment", "Lcom/geniusscansdk/scanflow/EditFilterFragment;", PostProcessingFragment.IS_EDITING_FILTER_KEY, "imageView", "Lcom/geniusscansdk/scanflow/ZoomableImageView;", "buttonsLayout", "Landroidx/constraintlayout/widget/ConstraintLayout;", "validateLayout", "filterLayout", "Landroid/widget/FrameLayout;", "recropButton", "Lcom/google/android/material/button/MaterialButton;", "rotationButton", "editFilterButton", "distortionCorrectionButton", "validateButton", "addPageButton", "retryButton", "progressBar", "Landroid/widget/ProgressBar;", "readabilityView", "Landroid/widget/LinearLayout;", "exceptionHandler", "Lkotlinx/coroutines/CoroutineExceptionHandler;", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", TtmlNode.RUBY_CONTAINER, "Landroid/view/ViewGroup;", "onResume", "onSaveInstanceState", "outState", "updateButtons", "isEnabled", "initializeButtons", "updateDistortionCorrectionButton", "recrop", "rotateLeft", "Lkotlinx/coroutines/Job;", "onFilterChanged", ViewProps.FILTER, "Lcom/geniusscansdk/scanflow/ScanConfiguration$Filter;", "enhance", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "updateViews", "updateReadabilityView", "pageReadability", "Lcom/geniusscansdk/core/ScanProcessor$ReadabilityLevel;", "displayScan", "image", "Ljava/io/File;", "(Ljava/io/File;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "updateFilterEditingLayout", "toggleDistortionCorrection", "validatePage", "addPage", "applyCustomStyle", "scanActivity", "Lcom/geniusscansdk/scanflow/ScanActivity;", "getScanActivity", "()Lcom/geniusscansdk/scanflow/ScanActivity;", "performOperationAndReloadImage", SerializedNames.OPERATION, "Lkotlin/Function1;", "Lkotlin/coroutines/Continuation;", "", "(Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Companion", "gssdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class PostProcessingFragment extends Fragment {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final String IS_EDITING_FILTER_KEY = "isEditingFilter";
    private MaterialButton addPageButton;
    private ConstraintLayout buttonsLayout;
    private MaterialButton distortionCorrectionButton;
    private MaterialButton editFilterButton;
    private EditFilterFragment filterFragment;
    private FrameLayout filterLayout;
    private ZoomableImageView imageView;
    private boolean isEditingFilter;
    private boolean isProcessing;
    private Page page;
    private ProgressBar progressBar;
    private LinearLayout readabilityView;
    private MaterialButton recropButton;
    private MaterialButton retryButton;
    private MaterialButton rotationButton;
    private ScanConfiguration scanConfiguration;
    private MaterialButton validateButton;
    private ConstraintLayout validateLayout;
    private final BitmapLoader bitmapLoader = new BitmapLoader();
    private final CoroutineExceptionHandler exceptionHandler = new PostProcessingFragment$special$$inlined$CoroutineExceptionHandler$1(CoroutineExceptionHandler.INSTANCE, this);

    /* JADX INFO: compiled from: PostProcessingFragment.kt */
    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[ScanConfiguration.CurvatureCorrectionMode.values().length];
            try {
                iArr[ScanConfiguration.CurvatureCorrectionMode.DISABLED.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[ScanConfiguration.CurvatureCorrectionMode.ENABLED.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    /* JADX INFO: renamed from: com.geniusscansdk.scanflow.PostProcessingFragment$displayScan$1, reason: invalid class name */
    /* JADX INFO: compiled from: PostProcessingFragment.kt */
    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.geniusscansdk.scanflow.PostProcessingFragment", f = "PostProcessingFragment.kt", i = {0}, l = {277}, m = "displayScan", n = {"this"}, s = {"L$0"})
    static final class AnonymousClass1 extends ContinuationImpl {
        Object L$0;
        int label;
        /* synthetic */ Object result;

        AnonymousClass1(Continuation<? super AnonymousClass1> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return PostProcessingFragment.this.displayScan(null, this);
        }
    }

    /* JADX INFO: renamed from: com.geniusscansdk.scanflow.PostProcessingFragment$enhance$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: PostProcessingFragment.kt */
    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.geniusscansdk.scanflow.PostProcessingFragment", f = "PostProcessingFragment.kt", i = {0}, l = {256}, m = "enhance", n = {"this"}, s = {"L$0"})
    static final class C17861 extends ContinuationImpl {
        Object L$0;
        int label;
        /* synthetic */ Object result;

        C17861(Continuation<? super C17861> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return PostProcessingFragment.this.enhance(this);
        }
    }

    /* JADX INFO: renamed from: com.geniusscansdk.scanflow.PostProcessingFragment$performOperationAndReloadImage$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: PostProcessingFragment.kt */
    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.geniusscansdk.scanflow.PostProcessingFragment", f = "PostProcessingFragment.kt", i = {0}, l = {321, 326}, m = "performOperationAndReloadImage", n = {"this"}, s = {"L$0"})
    static final class C17891 extends ContinuationImpl {
        Object L$0;
        int label;
        /* synthetic */ Object result;

        C17891(Continuation<? super C17891> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return PostProcessingFragment.this.performOperationAndReloadImage(null, this);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Object parcelable = BundleCompat.getParcelable(requireArguments(), Location.TYPE_PAGE, Page.class);
        Intrinsics.checkNotNull(parcelable);
        this.page = (Page) parcelable;
        Serializable serializable = BundleCompat.getSerializable(requireArguments(), "scanConfiguration", ScanConfiguration.class);
        Intrinsics.checkNotNull(serializable);
        this.scanConfiguration = (ScanConfiguration) serializable;
        requireActivity().getOnBackPressedDispatcher().addCallback(this, new OnBackPressedCallback() { // from class: com.geniusscansdk.scanflow.PostProcessingFragment$onCreate$onBackPressedCallback$1
            {
                super(true);
            }

            @Override // androidx.activity.OnBackPressedCallback
            public void handleOnBackPressed() {
                if (this.this$0.isEditingFilter) {
                    this.this$0.isEditingFilter = false;
                    this.this$0.updateFilterEditingLayout();
                    return;
                }
                Page page = this.this$0.page;
                if (page == null) {
                    Intrinsics.throwUninitializedPropertyAccessException(Location.TYPE_PAGE);
                    page = null;
                }
                page.deleteImages();
                setEnabled(false);
                this.this$0.requireActivity().getOnBackPressedDispatcher().onBackPressed();
            }
        });
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        String string;
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        View viewInflate = inflater.inflate(R.layout.post_processing_fragment, container, false);
        this.imageView = (ZoomableImageView) viewInflate.findViewById(R.id.image_view);
        this.buttonsLayout = (ConstraintLayout) viewInflate.findViewById(R.id.buttons_layout);
        this.validateLayout = (ConstraintLayout) viewInflate.findViewById(R.id.validate_layout);
        this.filterLayout = (FrameLayout) viewInflate.findViewById(R.id.filter_layout);
        MaterialButton materialButton = (MaterialButton) viewInflate.findViewById(R.id.recrop_button);
        this.recropButton = materialButton;
        ScanConfiguration scanConfiguration = null;
        if (materialButton == null) {
            Intrinsics.throwUninitializedPropertyAccessException("recropButton");
            materialButton = null;
        }
        materialButton.setOnClickListener(new View.OnClickListener() { // from class: com.geniusscansdk.scanflow.PostProcessingFragment$$ExternalSyntheticLambda1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.recrop();
            }
        });
        MaterialButton materialButton2 = (MaterialButton) viewInflate.findViewById(R.id.rotate_left_button);
        this.rotationButton = materialButton2;
        if (materialButton2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("rotationButton");
            materialButton2 = null;
        }
        materialButton2.setOnClickListener(new View.OnClickListener() { // from class: com.geniusscansdk.scanflow.PostProcessingFragment$$ExternalSyntheticLambda2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.rotateLeft();
            }
        });
        MaterialButton materialButton3 = (MaterialButton) viewInflate.findViewById(R.id.edit_filter_button);
        this.editFilterButton = materialButton3;
        if (materialButton3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("editFilterButton");
            materialButton3 = null;
        }
        materialButton3.setOnClickListener(new View.OnClickListener() { // from class: com.geniusscansdk.scanflow.PostProcessingFragment$$ExternalSyntheticLambda3
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                PostProcessingFragment.onCreateView$lambda$3(this.f$0, view);
            }
        });
        MaterialButton materialButton4 = this.editFilterButton;
        if (materialButton4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("editFilterButton");
            materialButton4 = null;
        }
        materialButton4.setEnabled(false);
        MaterialButton materialButton5 = (MaterialButton) viewInflate.findViewById(R.id.distortion_correction_button);
        this.distortionCorrectionButton = materialButton5;
        if (materialButton5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("distortionCorrectionButton");
            materialButton5 = null;
        }
        materialButton5.setOnClickListener(new View.OnClickListener() { // from class: com.geniusscansdk.scanflow.PostProcessingFragment$$ExternalSyntheticLambda4
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.toggleDistortionCorrection();
            }
        });
        this.validateButton = (MaterialButton) viewInflate.findViewById(R.id.validate_button);
        if (getScanActivity().canAddPage$gssdk_release()) {
            string = getString(R.string.gssdk_flow_done, Integer.valueOf(getScanActivity().getPageCount$gssdk_release() + 1));
        } else {
            string = getString(R.string.gssdk_action_done);
        }
        Intrinsics.checkNotNull(string);
        MaterialButton materialButton6 = this.validateButton;
        if (materialButton6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("validateButton");
            materialButton6 = null;
        }
        materialButton6.setText(string);
        MaterialButton materialButton7 = this.validateButton;
        if (materialButton7 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("validateButton");
            materialButton7 = null;
        }
        materialButton7.setOnClickListener(new View.OnClickListener() { // from class: com.geniusscansdk.scanflow.PostProcessingFragment$$ExternalSyntheticLambda5
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.validatePage();
            }
        });
        this.addPageButton = (MaterialButton) viewInflate.findViewById(R.id.add_page_button);
        if (getScanActivity().canAddPage$gssdk_release()) {
            MaterialButton materialButton8 = this.addPageButton;
            if (materialButton8 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("addPageButton");
                materialButton8 = null;
            }
            materialButton8.setOnClickListener(new View.OnClickListener() { // from class: com.geniusscansdk.scanflow.PostProcessingFragment$$ExternalSyntheticLambda6
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    this.f$0.addPage();
                }
            });
            MaterialButton materialButton9 = this.addPageButton;
            if (materialButton9 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("addPageButton");
                materialButton9 = null;
            }
            materialButton9.setVisibility(0);
        }
        MaterialButton materialButton10 = (MaterialButton) viewInflate.findViewById(R.id.retry_button);
        this.retryButton = materialButton10;
        if (materialButton10 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("retryButton");
            materialButton10 = null;
        }
        materialButton10.setOnClickListener(new View.OnClickListener() { // from class: com.geniusscansdk.scanflow.PostProcessingFragment$$ExternalSyntheticLambda7
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                PostProcessingFragment.onCreateView$lambda$7(this.f$0, view);
            }
        });
        this.progressBar = (ProgressBar) viewInflate.findViewById(R.id.progress_bar);
        this.readabilityView = (LinearLayout) viewInflate.findViewById(R.id.readability_warning_layout);
        EditFilterFragment editFilterFragmentNewInstance = (EditFilterFragment) getChildFragmentManager().findFragmentByTag("filter_fragment");
        if (editFilterFragmentNewInstance == null) {
            EditFilterFragment.Companion companion = EditFilterFragment.INSTANCE;
            ScanConfiguration scanConfiguration2 = this.scanConfiguration;
            if (scanConfiguration2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("scanConfiguration");
            } else {
                scanConfiguration = scanConfiguration2;
            }
            editFilterFragmentNewInstance = companion.newInstance(scanConfiguration);
            FragmentManager childFragmentManager = getChildFragmentManager();
            Intrinsics.checkNotNullExpressionValue(childFragmentManager, "getChildFragmentManager(...)");
            FragmentTransaction fragmentTransactionBeginTransaction = childFragmentManager.beginTransaction();
            fragmentTransactionBeginTransaction.replace(R.id.filter_layout, editFilterFragmentNewInstance, "filter_fragment");
            fragmentTransactionBeginTransaction.commit();
        }
        this.filterFragment = editFilterFragmentNewInstance;
        getChildFragmentManager().setFragmentResultListener(EditFilterFragment.EDIT_FILTER_REQUEST_KEY, this, new FragmentResultListener() { // from class: com.geniusscansdk.scanflow.PostProcessingFragment$$ExternalSyntheticLambda8
            @Override // androidx.fragment.app.FragmentResultListener
            public final void onFragmentResult(String str, Bundle bundle) {
                PostProcessingFragment.onCreateView$lambda$10(this.f$0, str, bundle);
            }
        });
        this.isEditingFilter = savedInstanceState != null ? savedInstanceState.getBoolean(IS_EDITING_FILTER_KEY) : false;
        updateFilterEditingLayout();
        initializeButtons();
        applyCustomStyle();
        return viewInflate;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onCreateView$lambda$3(PostProcessingFragment postProcessingFragment, View view) {
        postProcessingFragment.isEditingFilter = true;
        postProcessingFragment.updateFilterEditingLayout();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onCreateView$lambda$7(PostProcessingFragment postProcessingFragment, View view) {
        OnBackPressedDispatcher onBackPressedDispatcher;
        FragmentActivity activity = postProcessingFragment.getActivity();
        if (activity == null || (onBackPressedDispatcher = activity.getOnBackPressedDispatcher()) == null) {
            return;
        }
        onBackPressedDispatcher.onBackPressed();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onCreateView$lambda$10(PostProcessingFragment postProcessingFragment, String str, Bundle result) {
        Intrinsics.checkNotNullParameter(str, "<unused var>");
        Intrinsics.checkNotNullParameter(result, "result");
        String string = result.getString(EditFilterFragment.ON_FILTER_CHANGED_KEY);
        if (string != null) {
            postProcessingFragment.onFilterChanged(ScanConfiguration.Filter.valueOf(string));
        }
        if (result.containsKey(EditFilterFragment.ON_FILTER_VALIDATED_KEY)) {
            postProcessingFragment.isEditingFilter = false;
            postProcessingFragment.updateFilterEditingLayout();
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        updateDistortionCorrectionButton();
        updateButtons(false);
        BuildersKt__Builders_commonKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this), this.exceptionHandler, null, new C17881(null), 2, null);
    }

    /* JADX INFO: renamed from: com.geniusscansdk.scanflow.PostProcessingFragment$onResume$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: PostProcessingFragment.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.geniusscansdk.scanflow.PostProcessingFragment$onResume$1", f = "PostProcessingFragment.kt", i = {}, l = {171}, m = "invokeSuspend", n = {}, s = {})
    static final class C17881 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;

        C17881(Continuation<? super C17881> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return PostProcessingFragment.this.new C17881(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C17881) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                PostProcessingFragment postProcessingFragment = PostProcessingFragment.this;
                Page page = postProcessingFragment.page;
                if (page == null) {
                    Intrinsics.throwUninitializedPropertyAccessException(Location.TYPE_PAGE);
                    page = null;
                }
                File enhancedImage = page.getEnhancedImage();
                Intrinsics.checkNotNull(enhancedImage);
                this.label = 1;
                if (postProcessingFragment.displayScan(enhancedImage, this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
            PostProcessingFragment.this.updateViews();
            PostProcessingFragment.this.updateButtons(true);
            return Unit.INSTANCE;
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onSaveInstanceState(Bundle outState) {
        Intrinsics.checkNotNullParameter(outState, "outState");
        super.onSaveInstanceState(outState);
        outState.putBoolean(IS_EDITING_FILTER_KEY, this.isEditingFilter);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void updateButtons(boolean isEnabled) {
        MaterialButton materialButton = this.validateButton;
        MaterialButton materialButton2 = null;
        if (materialButton == null) {
            Intrinsics.throwUninitializedPropertyAccessException("validateButton");
            materialButton = null;
        }
        materialButton.setEnabled(isEnabled);
        MaterialButton materialButton3 = this.retryButton;
        if (materialButton3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("retryButton");
            materialButton3 = null;
        }
        materialButton3.setEnabled(isEnabled);
        MaterialButton materialButton4 = this.addPageButton;
        if (materialButton4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("addPageButton");
            materialButton4 = null;
        }
        materialButton4.setEnabled(isEnabled);
        MaterialButton materialButton5 = this.editFilterButton;
        if (materialButton5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("editFilterButton");
        } else {
            materialButton2 = materialButton5;
        }
        materialButton2.setEnabled(isEnabled);
    }

    private final void initializeButtons() {
        MaterialButton materialButton = this.rotationButton;
        ScanConfiguration scanConfiguration = null;
        if (materialButton == null) {
            Intrinsics.throwUninitializedPropertyAccessException("rotationButton");
            materialButton = null;
        }
        ScanConfiguration scanConfiguration2 = this.scanConfiguration;
        if (scanConfiguration2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("scanConfiguration");
            scanConfiguration2 = null;
        }
        materialButton.setVisibility(scanConfiguration2.postProcessingActions.contains(ScanConfiguration.Action.ROTATE) ? 0 : 8);
        MaterialButton materialButton2 = this.editFilterButton;
        if (materialButton2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("editFilterButton");
            materialButton2 = null;
        }
        ScanConfiguration scanConfiguration3 = this.scanConfiguration;
        if (scanConfiguration3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("scanConfiguration");
            scanConfiguration3 = null;
        }
        materialButton2.setVisibility(scanConfiguration3.postProcessingActions.contains(ScanConfiguration.Action.EDIT_FILTER) ? 0 : 8);
        MaterialButton materialButton3 = this.distortionCorrectionButton;
        if (materialButton3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("distortionCorrectionButton");
            materialButton3 = null;
        }
        ScanConfiguration scanConfiguration4 = this.scanConfiguration;
        if (scanConfiguration4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("scanConfiguration");
        } else {
            scanConfiguration = scanConfiguration4;
        }
        materialButton3.setVisibility(scanConfiguration.postProcessingActions.contains(ScanConfiguration.Action.CORRECT_DISTORTION) ? 0 : 8);
    }

    private final void updateDistortionCorrectionButton() {
        int i;
        MaterialButton materialButton = this.distortionCorrectionButton;
        MaterialButton materialButton2 = null;
        if (materialButton == null) {
            Intrinsics.throwUninitializedPropertyAccessException("distortionCorrectionButton");
            materialButton = null;
        }
        Page page = this.page;
        if (page == null) {
            Intrinsics.throwUninitializedPropertyAccessException(Location.TYPE_PAGE);
            page = null;
        }
        int i2 = WhenMappings.$EnumSwitchMapping$0[page.getCurvatureCorrectionMode().ordinal()];
        if (i2 == 1) {
            i = R.drawable.distortion_grid;
        } else {
            if (i2 != 2) {
                throw new NoWhenBranchMatchedException();
            }
            i = R.drawable.straightened_distortion_grid;
        }
        materialButton.setIconResource(i);
        Page page2 = this.page;
        if (page2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException(Location.TYPE_PAGE);
            page2 = null;
        }
        String string = getString(page2.getCurvatureCorrectionMode().getLabel());
        Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
        MaterialButton materialButton3 = this.distortionCorrectionButton;
        if (materialButton3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("distortionCorrectionButton");
            materialButton3 = null;
        }
        materialButton3.setContentDescription(getString(R.string.gssdk_distortion_correction) + " " + string + "}");
        MaterialButton materialButton4 = this.distortionCorrectionButton;
        if (materialButton4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("distortionCorrectionButton");
        } else {
            materialButton2 = materialButton4;
        }
        ViewCompat.setAccessibilityDelegate(materialButton2, new AccessibilityDelegateCompat() { // from class: com.geniusscansdk.scanflow.PostProcessingFragment.updateDistortionCorrectionButton.1
            @Override // androidx.core.view.AccessibilityDelegateCompat
            public void onInitializeAccessibilityNodeInfo(View v, AccessibilityNodeInfoCompat info) {
                Intrinsics.checkNotNullParameter(v, "v");
                Intrinsics.checkNotNullParameter(info, "info");
                super.onInitializeAccessibilityNodeInfo(v, info);
                PostProcessingFragment postProcessingFragment = PostProcessingFragment.this;
                Page page3 = postProcessingFragment.page;
                if (page3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException(Location.TYPE_PAGE);
                    page3 = null;
                }
                ScanConfiguration.CurvatureCorrectionMode curvatureCorrectionMode = page3.getCurvatureCorrectionMode();
                ScanConfiguration.CurvatureCorrectionMode[] curvatureCorrectionModeArrValues = ScanConfiguration.CurvatureCorrectionMode.values();
                info.addAction(new AccessibilityNodeInfoCompat.AccessibilityActionCompat(16, postProcessingFragment.getString(curvatureCorrectionModeArrValues[(curvatureCorrectionMode.ordinal() + 1) % curvatureCorrectionModeArrValues.length].getLabel())));
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void recrop() {
        BorderDetectionFragment.Companion companion = BorderDetectionFragment.INSTANCE;
        Page page = this.page;
        if (page == null) {
            Intrinsics.throwUninitializedPropertyAccessException(Location.TYPE_PAGE);
            page = null;
        }
        ScanConfiguration scanConfiguration = this.scanConfiguration;
        if (scanConfiguration == null) {
            Intrinsics.throwUninitializedPropertyAccessException("scanConfiguration");
            scanConfiguration = null;
        }
        BorderDetectionFragment borderDetectionFragmentNewInstance = companion.newInstance(page, scanConfiguration);
        getParentFragmentManager().setFragmentResultListener(BorderDetectionFragment.REQUEST_KEY, requireActivity(), new FragmentResultListener() { // from class: com.geniusscansdk.scanflow.PostProcessingFragment$$ExternalSyntheticLambda0
            @Override // androidx.fragment.app.FragmentResultListener
            public final void onFragmentResult(String str, Bundle bundle) {
                PostProcessingFragment.recrop$lambda$11(this.f$0, str, bundle);
            }
        });
        FragmentManager parentFragmentManager = getParentFragmentManager();
        Intrinsics.checkNotNullExpressionValue(parentFragmentManager, "getParentFragmentManager(...)");
        FragmentTransaction fragmentTransactionBeginTransaction = parentFragmentManager.beginTransaction();
        fragmentTransactionBeginTransaction.replace(R.id.container, borderDetectionFragmentNewInstance);
        fragmentTransactionBeginTransaction.addToBackStack(null);
        fragmentTransactionBeginTransaction.commit();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void recrop$lambda$11(PostProcessingFragment postProcessingFragment, String str, Bundle bundle) {
        Intrinsics.checkNotNullParameter(str, "<unused var>");
        Intrinsics.checkNotNullParameter(bundle, "<unused var>");
        postProcessingFragment.getParentFragmentManager().popBackStack();
    }

    /* JADX INFO: renamed from: com.geniusscansdk.scanflow.PostProcessingFragment$rotateLeft$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: PostProcessingFragment.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.geniusscansdk.scanflow.PostProcessingFragment$rotateLeft$1", f = "PostProcessingFragment.kt", i = {}, l = {231}, m = "invokeSuspend", n = {}, s = {})
    static final class C17901 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;

        C17901(Continuation<? super C17901> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return PostProcessingFragment.this.new C17901(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C17901) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            MaterialButton materialButton = null;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                MaterialButton materialButton2 = PostProcessingFragment.this.rotationButton;
                if (materialButton2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("rotationButton");
                    materialButton2 = null;
                }
                materialButton2.setEnabled(false);
                RotationAngle rotationAngle = RotationAngle.ROTATION_90_CCW;
                this.label = 1;
                if (PostProcessingFragment.this.performOperationAndReloadImage(new C02021(PostProcessingFragment.this, rotationAngle, null), this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
            MaterialButton materialButton3 = PostProcessingFragment.this.rotationButton;
            if (materialButton3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("rotationButton");
            } else {
                materialButton = materialButton3;
            }
            materialButton.setEnabled(true);
            return Unit.INSTANCE;
        }

        /* JADX INFO: renamed from: com.geniusscansdk.scanflow.PostProcessingFragment$rotateLeft$1$1, reason: invalid class name and collision with other inner class name */
        /* JADX INFO: compiled from: PostProcessingFragment.kt */
        @Metadata(d1 = {"\u0000\u0006\n\u0000\n\u0002\u0010\u0002\u0010\u0000\u001a\u00020\u0001H\n"}, d2 = {"<anonymous>", ""}, k = 3, mv = {2, 1, 0}, xi = 48)
        @DebugMetadata(c = "com.geniusscansdk.scanflow.PostProcessingFragment$rotateLeft$1$1", f = "PostProcessingFragment.kt", i = {}, l = {232, 241}, m = "invokeSuspend", n = {}, s = {})
        static final class C02021 extends SuspendLambda implements Function1<Continuation<? super Unit>, Object> {
            final /* synthetic */ RotationAngle $angle;
            int label;
            final /* synthetic */ PostProcessingFragment this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            C02021(PostProcessingFragment postProcessingFragment, RotationAngle rotationAngle, Continuation<? super C02021> continuation) {
                super(1, continuation);
                this.this$0 = postProcessingFragment;
                this.$angle = rotationAngle;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation<Unit> create(Continuation<?> continuation) {
                return new C02021(this.this$0, this.$angle, continuation);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Continuation<? super Unit> continuation) {
                return ((C02021) create(continuation)).invokeSuspend(Unit.INSTANCE);
            }

            /* JADX INFO: renamed from: com.geniusscansdk.scanflow.PostProcessingFragment$rotateLeft$1$1$1, reason: invalid class name and collision with other inner class name */
            /* JADX INFO: compiled from: PostProcessingFragment.kt */
            @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
            @DebugMetadata(c = "com.geniusscansdk.scanflow.PostProcessingFragment$rotateLeft$1$1$1", f = "PostProcessingFragment.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
            static final class C02031 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
                final /* synthetic */ RotationAngle $angle;
                int label;
                final /* synthetic */ PostProcessingFragment this$0;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                C02031(PostProcessingFragment postProcessingFragment, RotationAngle rotationAngle, Continuation<? super C02031> continuation) {
                    super(2, continuation);
                    this.this$0 = postProcessingFragment;
                    this.$angle = rotationAngle;
                }

                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                    return new C02031(this.this$0, this.$angle, continuation);
                }

                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                    return ((C02031) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
                }

                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                public final Object invokeSuspend(Object obj) throws LicenseException, ProcessingException, IOException {
                    IntrinsicsKt.getCOROUTINE_SUSPENDED();
                    if (this.label == 0) {
                        ResultKt.throwOnFailure(obj);
                        Page page = this.this$0.page;
                        if (page == null) {
                            Intrinsics.throwUninitializedPropertyAccessException(Location.TYPE_PAGE);
                            page = null;
                        }
                        String absolutePath = page.getOriginalImage().getAbsolutePath();
                        Intrinsics.checkNotNull(absolutePath);
                        GeniusScanSDK.rotateImage$default(absolutePath, absolutePath, this.$angle, false, 8, null);
                        Page page2 = this.this$0.page;
                        if (page2 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException(Location.TYPE_PAGE);
                            page2 = null;
                        }
                        Page page3 = this.this$0.page;
                        if (page3 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException(Location.TYPE_PAGE);
                            page3 = null;
                        }
                        Quadrangle quadrangle = page3.getQuadrangle();
                        page2.setQuadrangle(quadrangle != null ? quadrangle.rotate(this.$angle) : null);
                        return Unit.INSTANCE;
                    }
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
            }

            /* JADX WARN: Code restructure failed: missing block: B:27:0x008a, code lost:
            
                if (r8.processPage$gssdk_release(r4, r7) == r0) goto L28;
             */
            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct add '--show-bad-code' argument
            */
            public final java.lang.Object invokeSuspend(java.lang.Object r8) {
                /*
                    r7 = this;
                    java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
                    int r1 = r7.label
                    r2 = 2
                    r3 = 1
                    r4 = 0
                    if (r1 == 0) goto L20
                    if (r1 == r3) goto L1c
                    if (r1 != r2) goto L14
                    kotlin.ResultKt.throwOnFailure(r8)
                    goto L8d
                L14:
                    java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
                    java.lang.String r8 = "call to 'resume' before 'invoke' with coroutine"
                    r7.<init>(r8)
                    throw r7
                L1c:
                    kotlin.ResultKt.throwOnFailure(r8)
                    goto L40
                L20:
                    kotlin.ResultKt.throwOnFailure(r8)
                    kotlinx.coroutines.CoroutineDispatcher r8 = kotlinx.coroutines.Dispatchers.getIO()
                    kotlin.coroutines.CoroutineContext r8 = (kotlin.coroutines.CoroutineContext) r8
                    com.geniusscansdk.scanflow.PostProcessingFragment$rotateLeft$1$1$1 r1 = new com.geniusscansdk.scanflow.PostProcessingFragment$rotateLeft$1$1$1
                    com.geniusscansdk.scanflow.PostProcessingFragment r5 = r7.this$0
                    com.geniusscansdk.core.RotationAngle r6 = r7.$angle
                    r1.<init>(r5, r6, r4)
                    kotlin.jvm.functions.Function2 r1 = (kotlin.jvm.functions.Function2) r1
                    r5 = r7
                    kotlin.coroutines.Continuation r5 = (kotlin.coroutines.Continuation) r5
                    r7.label = r3
                    java.lang.Object r8 = kotlinx.coroutines.BuildersKt.withContext(r8, r1, r5)
                    if (r8 != r0) goto L40
                    goto L8c
                L40:
                    com.geniusscansdk.scanflow.PostProcessingFragment r8 = r7.this$0
                    com.geniusscansdk.scanflow.EditFilterFragment r8 = com.geniusscansdk.scanflow.PostProcessingFragment.access$getFilterFragment$p(r8)
                    if (r8 != 0) goto L4e
                    java.lang.String r8 = "filterFragment"
                    kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r8)
                    r8 = r4
                L4e:
                    com.geniusscansdk.scanflow.PostProcessingFragment r1 = r7.this$0
                    com.geniusscansdk.scanflow.Page r1 = com.geniusscansdk.scanflow.PostProcessingFragment.access$getPage$p(r1)
                    java.lang.String r3 = "page"
                    if (r1 != 0) goto L5c
                    kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r3)
                    r1 = r4
                L5c:
                    com.geniusscansdk.scanflow.PostProcessingFragment r5 = r7.this$0
                    com.geniusscansdk.scanflow.ScanConfiguration r5 = com.geniusscansdk.scanflow.PostProcessingFragment.access$getScanConfiguration$p(r5)
                    if (r5 != 0) goto L6b
                    java.lang.String r5 = "scanConfiguration"
                    kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r5)
                    r5 = r4
                L6b:
                    r8.updateWithPage$gssdk_release(r1, r5)
                    com.geniusscansdk.scanflow.PostProcessingFragment r8 = r7.this$0
                    com.geniusscansdk.scanflow.ScanActivity r8 = com.geniusscansdk.scanflow.PostProcessingFragment.access$getScanActivity(r8)
                    com.geniusscansdk.scanflow.PostProcessingFragment r1 = r7.this$0
                    com.geniusscansdk.scanflow.Page r1 = com.geniusscansdk.scanflow.PostProcessingFragment.access$getPage$p(r1)
                    if (r1 != 0) goto L80
                    kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r3)
                    goto L81
                L80:
                    r4 = r1
                L81:
                    r1 = r7
                    kotlin.coroutines.Continuation r1 = (kotlin.coroutines.Continuation) r1
                    r7.label = r2
                    java.lang.Object r7 = r8.processPage$gssdk_release(r4, r1)
                    if (r7 != r0) goto L8d
                L8c:
                    return r0
                L8d:
                    kotlin.Unit r7 = kotlin.Unit.INSTANCE
                    return r7
                */
                throw new UnsupportedOperationException("Method not decompiled: com.geniusscansdk.scanflow.PostProcessingFragment.C17901.C02021.invokeSuspend(java.lang.Object):java.lang.Object");
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Job rotateLeft() {
        return BuildersKt__Builders_commonKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this), this.exceptionHandler, null, new C17901(null), 2, null);
    }

    private final void onFilterChanged(ScanConfiguration.Filter filter) {
        if (this.isProcessing) {
            return;
        }
        Page page = this.page;
        if (page == null) {
            Intrinsics.throwUninitializedPropertyAccessException(Location.TYPE_PAGE);
            page = null;
        }
        page.setFilter(filter);
        BuildersKt__Builders_commonKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this), this.exceptionHandler, null, new C17871(null), 2, null);
    }

    /* JADX INFO: renamed from: com.geniusscansdk.scanflow.PostProcessingFragment$onFilterChanged$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: PostProcessingFragment.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.geniusscansdk.scanflow.PostProcessingFragment$onFilterChanged$1", f = "PostProcessingFragment.kt", i = {}, l = {252}, m = "invokeSuspend", n = {}, s = {})
    static final class C17871 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;

        C17871(Continuation<? super C17871> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return PostProcessingFragment.this.new C17871(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C17871) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                this.label = 1;
                if (PostProcessingFragment.this.enhance(this) == coroutine_suspended) {
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

    /* JADX INFO: renamed from: com.geniusscansdk.scanflow.PostProcessingFragment$enhance$2, reason: invalid class name */
    /* JADX INFO: compiled from: PostProcessingFragment.kt */
    @Metadata(d1 = {"\u0000\u0006\n\u0000\n\u0002\u0010\u0002\u0010\u0000\u001a\u00020\u0001H\n"}, d2 = {"<anonymous>", ""}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.geniusscansdk.scanflow.PostProcessingFragment$enhance$2", f = "PostProcessingFragment.kt", i = {}, l = {257}, m = "invokeSuspend", n = {}, s = {})
    static final class AnonymousClass2 extends SuspendLambda implements Function1<Continuation<? super Unit>, Object> {
        int label;

        AnonymousClass2(Continuation<? super AnonymousClass2> continuation) {
            super(1, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Continuation<?> continuation) {
            return PostProcessingFragment.this.new AnonymousClass2(continuation);
        }

        @Override // kotlin.jvm.functions.Function1
        public final Object invoke(Continuation<? super Unit> continuation) {
            return ((AnonymousClass2) create(continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                ScanActivity scanActivity = PostProcessingFragment.this.getScanActivity();
                Page page = PostProcessingFragment.this.page;
                if (page == null) {
                    Intrinsics.throwUninitializedPropertyAccessException(Location.TYPE_PAGE);
                    page = null;
                }
                this.label = 1;
                if (scanActivity.processPage$gssdk_release(page, this) == coroutine_suspended) {
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
    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    public final Object enhance(Continuation<? super Unit> continuation) {
        C17861 c17861;
        if (continuation instanceof C17861) {
            c17861 = (C17861) continuation;
            if ((c17861.label & Integer.MIN_VALUE) != 0) {
                c17861.label -= Integer.MIN_VALUE;
            } else {
                c17861 = new C17861(continuation);
            }
        } else {
            c17861 = new C17861(continuation);
        }
        Object obj = c17861.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = c17861.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            AnonymousClass2 anonymousClass2 = new AnonymousClass2(null);
            c17861.L$0 = this;
            c17861.label = 1;
            if (performOperationAndReloadImage(anonymousClass2, c17861) == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            this = (PostProcessingFragment) c17861.L$0;
            ResultKt.throwOnFailure(obj);
        }
        this.updateViews();
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void updateViews() {
        EditFilterFragment editFilterFragment = this.filterFragment;
        Page page = null;
        if (editFilterFragment == null) {
            Intrinsics.throwUninitializedPropertyAccessException("filterFragment");
            editFilterFragment = null;
        }
        Page page2 = this.page;
        if (page2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException(Location.TYPE_PAGE);
            page2 = null;
        }
        ScanConfiguration scanConfiguration = this.scanConfiguration;
        if (scanConfiguration == null) {
            Intrinsics.throwUninitializedPropertyAccessException("scanConfiguration");
            scanConfiguration = null;
        }
        editFilterFragment.updateWithPage$gssdk_release(page2, scanConfiguration);
        Page page3 = this.page;
        if (page3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException(Location.TYPE_PAGE);
        } else {
            page = page3;
        }
        updateReadabilityView(page.getReadabilityLevel());
    }

    private final void updateReadabilityView(ScanProcessor.ReadabilityLevel pageReadability) {
        LinearLayout linearLayout = null;
        if (pageReadability != null) {
            ScanConfiguration scanConfiguration = this.scanConfiguration;
            if (scanConfiguration == null) {
                Intrinsics.throwUninitializedPropertyAccessException("scanConfiguration");
                scanConfiguration = null;
            }
            if (pageReadability.compareTo(scanConfiguration.requiredReadabilityLevel) < 0) {
                LinearLayout linearLayout2 = this.readabilityView;
                if (linearLayout2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("readabilityView");
                } else {
                    linearLayout = linearLayout2;
                }
                linearLayout.setVisibility(0);
                return;
            }
        }
        LinearLayout linearLayout3 = this.readabilityView;
        if (linearLayout3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("readabilityView");
        } else {
            linearLayout = linearLayout3;
        }
        linearLayout.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    public final Object displayScan(File file, Continuation<? super Unit> continuation) {
        AnonymousClass1 anonymousClass1;
        if (continuation instanceof AnonymousClass1) {
            anonymousClass1 = (AnonymousClass1) continuation;
            if ((anonymousClass1.label & Integer.MIN_VALUE) != 0) {
                anonymousClass1.label -= Integer.MIN_VALUE;
            } else {
                anonymousClass1 = new AnonymousClass1(continuation);
            }
        } else {
            anonymousClass1 = new AnonymousClass1(continuation);
        }
        Object objLoadFullScreenBitmap = anonymousClass1.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = anonymousClass1.label;
        if (i == 0) {
            ResultKt.throwOnFailure(objLoadFullScreenBitmap);
            BitmapLoader bitmapLoader = this.bitmapLoader;
            WindowManager windowManager = requireActivity().getWindowManager();
            Intrinsics.checkNotNullExpressionValue(windowManager, "getWindowManager(...)");
            anonymousClass1.L$0 = this;
            anonymousClass1.label = 1;
            objLoadFullScreenBitmap = bitmapLoader.loadFullScreenBitmap(file, windowManager, anonymousClass1);
            if (objLoadFullScreenBitmap == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            this = (PostProcessingFragment) anonymousClass1.L$0;
            ResultKt.throwOnFailure(objLoadFullScreenBitmap);
        }
        Bitmap bitmap = (Bitmap) objLoadFullScreenBitmap;
        ZoomableImageView zoomableImageView = this.imageView;
        ZoomableImageView zoomableImageView2 = null;
        if (zoomableImageView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("imageView");
            zoomableImageView = null;
        }
        zoomableImageView.setImageBitmap(bitmap);
        ZoomableImageView zoomableImageView3 = this.imageView;
        if (zoomableImageView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("imageView");
        } else {
            zoomableImageView2 = zoomableImageView3;
        }
        zoomableImageView2.invalidate();
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void updateFilterEditingLayout() {
        FrameLayout frameLayout = this.filterLayout;
        ConstraintLayout constraintLayout = null;
        if (frameLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("filterLayout");
            frameLayout = null;
        }
        frameLayout.setVisibility(this.isEditingFilter ? 0 : 8);
        ConstraintLayout constraintLayout2 = this.buttonsLayout;
        if (constraintLayout2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("buttonsLayout");
            constraintLayout2 = null;
        }
        constraintLayout2.setVisibility(this.isEditingFilter ? 8 : 0);
        ConstraintLayout constraintLayout3 = this.validateLayout;
        if (constraintLayout3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("validateLayout");
        } else {
            constraintLayout = constraintLayout3;
        }
        constraintLayout.setVisibility(this.isEditingFilter ? 8 : 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void toggleDistortionCorrection() {
        Page page = this.page;
        if (page == null) {
            Intrinsics.throwUninitializedPropertyAccessException(Location.TYPE_PAGE);
            page = null;
        }
        Page page2 = this.page;
        if (page2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException(Location.TYPE_PAGE);
            page2 = null;
        }
        ScanConfiguration.CurvatureCorrectionMode curvatureCorrectionMode = page2.getCurvatureCorrectionMode();
        ScanConfiguration.CurvatureCorrectionMode[] curvatureCorrectionModeArrValues = ScanConfiguration.CurvatureCorrectionMode.values();
        page.setCurvatureCorrectionMode(curvatureCorrectionModeArrValues[(curvatureCorrectionMode.ordinal() + 1) % curvatureCorrectionModeArrValues.length]);
        updateDistortionCorrectionButton();
        BuildersKt__Builders_commonKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this), this.exceptionHandler, null, new C17911(null), 2, null);
    }

    /* JADX INFO: renamed from: com.geniusscansdk.scanflow.PostProcessingFragment$toggleDistortionCorrection$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: PostProcessingFragment.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.geniusscansdk.scanflow.PostProcessingFragment$toggleDistortionCorrection$1", f = "PostProcessingFragment.kt", i = {}, l = {292}, m = "invokeSuspend", n = {}, s = {})
    static final class C17911 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;

        C17911(Continuation<? super C17911> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return PostProcessingFragment.this.new C17911(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C17911) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                this.label = 1;
                if (PostProcessingFragment.this.enhance(this) == coroutine_suspended) {
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
    public final void validatePage() {
        ScanActivity scanActivity = getScanActivity();
        Page page = this.page;
        if (page == null) {
            Intrinsics.throwUninitializedPropertyAccessException(Location.TYPE_PAGE);
            page = null;
        }
        scanActivity.onPostProcessingFragmentFinished$gssdk_release(page, false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void addPage() {
        ScanActivity scanActivity = getScanActivity();
        Page page = this.page;
        if (page == null) {
            Intrinsics.throwUninitializedPropertyAccessException(Location.TYPE_PAGE);
            page = null;
        }
        ScanActivity.onPostProcessingFragmentFinished$gssdk_release$default(scanActivity, page, false, 2, null);
    }

    private final void applyCustomStyle() {
        MaterialButton materialButton = this.recropButton;
        ScanConfiguration scanConfiguration = null;
        if (materialButton == null) {
            Intrinsics.throwUninitializedPropertyAccessException("recropButton");
            materialButton = null;
        }
        ScanConfiguration scanConfiguration2 = this.scanConfiguration;
        if (scanConfiguration2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("scanConfiguration");
            scanConfiguration2 = null;
        }
        int i = scanConfiguration2.foregroundColor;
        ScanConfiguration scanConfiguration3 = this.scanConfiguration;
        if (scanConfiguration3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("scanConfiguration");
            scanConfiguration3 = null;
        }
        ViewUtils.applyColor(materialButton, i, scanConfiguration3.backgroundColor);
        MaterialButton materialButton2 = this.rotationButton;
        if (materialButton2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("rotationButton");
            materialButton2 = null;
        }
        ScanConfiguration scanConfiguration4 = this.scanConfiguration;
        if (scanConfiguration4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("scanConfiguration");
            scanConfiguration4 = null;
        }
        int i2 = scanConfiguration4.foregroundColor;
        ScanConfiguration scanConfiguration5 = this.scanConfiguration;
        if (scanConfiguration5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("scanConfiguration");
            scanConfiguration5 = null;
        }
        ViewUtils.applyColor(materialButton2, i2, scanConfiguration5.backgroundColor);
        MaterialButton materialButton3 = this.editFilterButton;
        if (materialButton3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("editFilterButton");
            materialButton3 = null;
        }
        ScanConfiguration scanConfiguration6 = this.scanConfiguration;
        if (scanConfiguration6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("scanConfiguration");
            scanConfiguration6 = null;
        }
        int i3 = scanConfiguration6.foregroundColor;
        ScanConfiguration scanConfiguration7 = this.scanConfiguration;
        if (scanConfiguration7 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("scanConfiguration");
            scanConfiguration7 = null;
        }
        ViewUtils.applyColor(materialButton3, i3, scanConfiguration7.backgroundColor);
        MaterialButton materialButton4 = this.distortionCorrectionButton;
        if (materialButton4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("distortionCorrectionButton");
            materialButton4 = null;
        }
        ScanConfiguration scanConfiguration8 = this.scanConfiguration;
        if (scanConfiguration8 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("scanConfiguration");
            scanConfiguration8 = null;
        }
        int i4 = scanConfiguration8.foregroundColor;
        ScanConfiguration scanConfiguration9 = this.scanConfiguration;
        if (scanConfiguration9 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("scanConfiguration");
            scanConfiguration9 = null;
        }
        ViewUtils.applyColor(materialButton4, i4, scanConfiguration9.backgroundColor);
        ViewUtils viewUtils = ViewUtils.INSTANCE;
        MaterialButton materialButton5 = this.validateButton;
        if (materialButton5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("validateButton");
            materialButton5 = null;
        }
        ScanConfiguration scanConfiguration10 = this.scanConfiguration;
        if (scanConfiguration10 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("scanConfiguration");
            scanConfiguration10 = null;
        }
        int i5 = scanConfiguration10.foregroundColor;
        ScanConfiguration scanConfiguration11 = this.scanConfiguration;
        if (scanConfiguration11 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("scanConfiguration");
            scanConfiguration11 = null;
        }
        viewUtils.applyColorForFilled(materialButton5, i5, scanConfiguration11.backgroundColor);
        MaterialButton materialButton6 = this.retryButton;
        if (materialButton6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("retryButton");
            materialButton6 = null;
        }
        ScanConfiguration scanConfiguration12 = this.scanConfiguration;
        if (scanConfiguration12 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("scanConfiguration");
            scanConfiguration12 = null;
        }
        int i6 = scanConfiguration12.foregroundColor;
        ScanConfiguration scanConfiguration13 = this.scanConfiguration;
        if (scanConfiguration13 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("scanConfiguration");
            scanConfiguration13 = null;
        }
        ViewUtils.applyColor(materialButton6, i6, scanConfiguration13.backgroundColor);
        ViewUtils viewUtils2 = ViewUtils.INSTANCE;
        MaterialButton materialButton7 = this.addPageButton;
        if (materialButton7 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("addPageButton");
            materialButton7 = null;
        }
        ScanConfiguration scanConfiguration14 = this.scanConfiguration;
        if (scanConfiguration14 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("scanConfiguration");
            scanConfiguration14 = null;
        }
        int i7 = scanConfiguration14.foregroundColor;
        ScanConfiguration scanConfiguration15 = this.scanConfiguration;
        if (scanConfiguration15 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("scanConfiguration");
            scanConfiguration15 = null;
        }
        viewUtils2.applyColorForOutlined(materialButton7, i7, scanConfiguration15.backgroundColor);
        ProgressBar progressBar = this.progressBar;
        if (progressBar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("progressBar");
            progressBar = null;
        }
        ScanConfiguration scanConfiguration16 = this.scanConfiguration;
        if (scanConfiguration16 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("scanConfiguration");
        } else {
            scanConfiguration = scanConfiguration16;
        }
        ViewUtils.applyColor(progressBar, scanConfiguration.foregroundColor);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final ScanActivity getScanActivity() {
        FragmentActivity activity = getActivity();
        Intrinsics.checkNotNull(activity, "null cannot be cast to non-null type com.geniusscansdk.scanflow.ScanActivity");
        return (ScanActivity) activity;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    /* JADX WARN: Code restructure failed: missing block: B:31:0x0084, code lost:
    
        if (r8.displayScan(r9, r0) == r1) goto L32;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object performOperationAndReloadImage(kotlin.jvm.functions.Function1<? super kotlin.coroutines.Continuation<? super kotlin.Unit>, ? extends java.lang.Object> r9, kotlin.coroutines.Continuation<? super kotlin.Unit> r10) {
        /*
            r8 = this;
            boolean r0 = r10 instanceof com.geniusscansdk.scanflow.PostProcessingFragment.C17891
            if (r0 == 0) goto L14
            r0 = r10
            com.geniusscansdk.scanflow.PostProcessingFragment$performOperationAndReloadImage$1 r0 = (com.geniusscansdk.scanflow.PostProcessingFragment.C17891) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L14
            int r10 = r0.label
            int r10 = r10 - r2
            r0.label = r10
            goto L19
        L14:
            com.geniusscansdk.scanflow.PostProcessingFragment$performOperationAndReloadImage$1 r0 = new com.geniusscansdk.scanflow.PostProcessingFragment$performOperationAndReloadImage$1
            r0.<init>(r10)
        L19:
            java.lang.Object r10 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            java.lang.String r3 = "progressBar"
            r4 = 0
            r5 = 2
            r6 = 1
            r7 = 0
            if (r2 == 0) goto L42
            if (r2 == r6) goto L3a
            if (r2 != r5) goto L32
            kotlin.ResultKt.throwOnFailure(r10)
            goto L87
        L32:
            java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
            java.lang.String r9 = "call to 'resume' before 'invoke' with coroutine"
            r8.<init>(r9)
            throw r8
        L3a:
            java.lang.Object r8 = r0.L$0
            com.geniusscansdk.scanflow.PostProcessingFragment r8 = (com.geniusscansdk.scanflow.PostProcessingFragment) r8
            kotlin.ResultKt.throwOnFailure(r10)
            goto L5d
        L42:
            kotlin.ResultKt.throwOnFailure(r10)
            android.widget.ProgressBar r10 = r8.progressBar
            if (r10 != 0) goto L4d
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r3)
            r10 = r7
        L4d:
            r10.setVisibility(r4)
            r8.isProcessing = r6
            r0.L$0 = r8
            r0.label = r6
            java.lang.Object r9 = r9.invoke(r0)
            if (r9 != r1) goto L5d
            goto L86
        L5d:
            android.widget.ProgressBar r9 = r8.progressBar
            if (r9 != 0) goto L65
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r3)
            r9 = r7
        L65:
            r10 = 8
            r9.setVisibility(r10)
            r8.isProcessing = r4
            com.geniusscansdk.scanflow.Page r9 = r8.page
            if (r9 != 0) goto L76
            java.lang.String r9 = "page"
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r9)
            r9 = r7
        L76:
            java.io.File r9 = r9.getEnhancedImage()
            if (r9 == 0) goto L87
            r0.L$0 = r7
            r0.label = r5
            java.lang.Object r8 = r8.displayScan(r9, r0)
            if (r8 != r1) goto L87
        L86:
            return r1
        L87:
            kotlin.Unit r8 = kotlin.Unit.INSTANCE
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.geniusscansdk.scanflow.PostProcessingFragment.performOperationAndReloadImage(kotlin.jvm.functions.Function1, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX INFO: compiled from: PostProcessingFragment.kt */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0080\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0016\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\f"}, d2 = {"Lcom/geniusscansdk/scanflow/PostProcessingFragment$Companion;", "", "<init>", "()V", "IS_EDITING_FILTER_KEY", "", "newInstance", "Lcom/geniusscansdk/scanflow/PostProcessingFragment;", Location.TYPE_PAGE, "Lcom/geniusscansdk/scanflow/Page;", "scanConfiguration", "Lcom/geniusscansdk/scanflow/ScanConfiguration;", "gssdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final PostProcessingFragment newInstance(Page page, ScanConfiguration scanConfiguration) {
            Intrinsics.checkNotNullParameter(page, "page");
            Intrinsics.checkNotNullParameter(scanConfiguration, "scanConfiguration");
            Bundle bundle = new Bundle();
            bundle.putParcelable(Location.TYPE_PAGE, page);
            bundle.putSerializable("scanConfiguration", scanConfiguration);
            PostProcessingFragment postProcessingFragment = new PostProcessingFragment();
            postProcessingFragment.setArguments(bundle);
            return postProcessingFragment;
        }
    }
}
