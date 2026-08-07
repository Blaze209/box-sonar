package com.geniusscansdk.scanflow;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.ProgressBar;
import androidx.core.os.BundleCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.media3.extractor.text.ttml.TtmlNode;
import com.box.android.data.api.models.annotations.Location;
import com.geniusscansdk.BitmapLoader;
import com.geniusscansdk.R;
import com.geniusscansdk.core.DocumentDetector;
import com.geniusscansdk.core.Quadrangle;
import com.geniusscansdk.ui.BorderDetectionImageView;
import com.geniusscansdk.ui.MagnifierBorderDetectionListener;
import com.geniusscansdk.ui.MagnifierView;
import com.google.android.material.button.MaterialButton;
import java.io.File;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineExceptionHandler;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;

/* JADX INFO: compiled from: BorderDetectionFragment.kt */
/* JADX INFO: loaded from: classes13.dex */
@Metadata(d1 = {"\u0000~\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 62\u00020\u0001:\u00016B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J&\u0010\u001e\u001a\u0004\u0018\u00010\u001f2\u0006\u0010 \u001a\u00020!2\b\u0010\"\u001a\u0004\u0018\u00010#2\b\u0010$\u001a\u0004\u0018\u00010%H\u0016J\b\u0010&\u001a\u00020'H\u0016J\b\u0010(\u001a\u00020)H\u0002J\b\u0010*\u001a\u00020'H\u0002J\b\u0010+\u001a\u00020'H\u0002J\u0012\u0010,\u001a\u00020'2\b\u0010-\u001a\u0004\u0018\u00010.H\u0002J\b\u0010/\u001a\u00020'H\u0002J\b\u00100\u001a\u00020'H\u0002J\b\u00101\u001a\u00020'H\u0002R\u001b\u0010\u0004\u001a\u00020\u00058BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\u0006\u0010\u0007R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082.¢\u0006\u0002\n\u0000R\u001b\u0010\u000e\u001a\u00020\u000f8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0012\u0010\t\u001a\u0004\b\u0010\u0010\u0011R\u000e\u0010\u0013\u001a\u00020\u0014X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0016X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0018X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u001aX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u001cX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\u001cX\u0082.¢\u0006\u0002\n\u0000R\u0014\u00102\u001a\u0002038BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b4\u00105¨\u00067"}, d2 = {"Lcom/geniusscansdk/scanflow/BorderDetectionFragment;", "Landroidx/fragment/app/Fragment;", "<init>", "()V", "scanConfiguration", "Lcom/geniusscansdk/scanflow/ScanConfiguration;", "getScanConfiguration", "()Lcom/geniusscansdk/scanflow/ScanConfiguration;", "scanConfiguration$delegate", "Lkotlin/Lazy;", "bitmapLoader", "Lcom/geniusscansdk/BitmapLoader;", "documentDetector", "Lcom/geniusscansdk/core/DocumentDetector;", Location.TYPE_PAGE, "Lcom/geniusscansdk/scanflow/Page;", "getPage", "()Lcom/geniusscansdk/scanflow/Page;", "page$delegate", "exceptionHandler", "Lkotlinx/coroutines/CoroutineExceptionHandler;", "progressBar", "Landroid/widget/ProgressBar;", "imageView", "Lcom/geniusscansdk/ui/BorderDetectionImageView;", "magnifierView", "Lcom/geniusscansdk/ui/MagnifierView;", "validateButton", "Lcom/google/android/material/button/MaterialButton;", "detectButton", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", TtmlNode.RUBY_CONTAINER, "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onResume", "", "loadBitmap", "Lkotlinx/coroutines/Job;", "updateDetectButton", "startDetection", "addQuadrangleToView", "quadrangle", "Lcom/geniusscansdk/core/Quadrangle;", "setQuadrangleToFullImage", "validatePage", "applyCustomStyle", "scanActivity", "Lcom/geniusscansdk/scanflow/ScanActivity;", "getScanActivity", "()Lcom/geniusscansdk/scanflow/ScanActivity;", "Companion", "gssdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class BorderDetectionFragment extends Fragment {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public static final String REQUEST_KEY = "BORDER_DETECTION_REQUEST";
    private MaterialButton detectButton;
    private DocumentDetector documentDetector;
    private BorderDetectionImageView imageView;
    private MagnifierView magnifierView;
    private ProgressBar progressBar;
    private MaterialButton validateButton;

    /* JADX INFO: renamed from: scanConfiguration$delegate, reason: from kotlin metadata */
    private final Lazy scanConfiguration = LazyKt.lazy(new Function0() { // from class: com.geniusscansdk.scanflow.BorderDetectionFragment$$ExternalSyntheticLambda0
        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() {
            return BorderDetectionFragment.scanConfiguration_delegate$lambda$0(this.f$0);
        }
    });
    private final BitmapLoader bitmapLoader = new BitmapLoader();

    /* JADX INFO: renamed from: page$delegate, reason: from kotlin metadata */
    private final Lazy page = LazyKt.lazy(new Function0() { // from class: com.geniusscansdk.scanflow.BorderDetectionFragment$$ExternalSyntheticLambda1
        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() {
            return BorderDetectionFragment.page_delegate$lambda$1(this.f$0);
        }
    });
    private final CoroutineExceptionHandler exceptionHandler = new BorderDetectionFragment$special$$inlined$CoroutineExceptionHandler$1(CoroutineExceptionHandler.INSTANCE, this);

    private final ScanConfiguration getScanConfiguration() {
        return (ScanConfiguration) this.scanConfiguration.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ScanConfiguration scanConfiguration_delegate$lambda$0(BorderDetectionFragment borderDetectionFragment) {
        ScanConfiguration scanConfiguration = (ScanConfiguration) BundleCompat.getSerializable(borderDetectionFragment.requireArguments(), "scanConfiguration", ScanConfiguration.class);
        if (scanConfiguration != null) {
            return scanConfiguration;
        }
        throw new NullPointerException("Impossible to retrieve scan scanConfiguration");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Page getPage() {
        return (Page) this.page.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Page page_delegate$lambda$1(BorderDetectionFragment borderDetectionFragment) {
        Object parcelable = BundleCompat.getParcelable(borderDetectionFragment.requireArguments(), Location.TYPE_PAGE, Page.class);
        Intrinsics.checkNotNull(parcelable);
        return (Page) parcelable;
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        View viewInflate = inflater.inflate(R.layout.border_detection_fragment, container, false);
        this.imageView = (BorderDetectionImageView) viewInflate.findViewById(R.id.image_view);
        this.magnifierView = (MagnifierView) viewInflate.findViewById(R.id.magnifier_view);
        MaterialButton materialButton = (MaterialButton) viewInflate.findViewById(R.id.validate_button);
        this.validateButton = materialButton;
        MagnifierView magnifierView = null;
        if (materialButton == null) {
            Intrinsics.throwUninitializedPropertyAccessException("validateButton");
            materialButton = null;
        }
        materialButton.setOnClickListener(new View.OnClickListener() { // from class: com.geniusscansdk.scanflow.BorderDetectionFragment$$ExternalSyntheticLambda2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.validatePage();
            }
        });
        this.detectButton = (MaterialButton) viewInflate.findViewById(R.id.detect_button);
        this.progressBar = (ProgressBar) viewInflate.findViewById(R.id.progress_bar);
        BorderDetectionImageView borderDetectionImageView = this.imageView;
        if (borderDetectionImageView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("imageView");
            borderDetectionImageView = null;
        }
        MagnifierView magnifierView2 = this.magnifierView;
        if (magnifierView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("magnifierView");
        } else {
            magnifierView = magnifierView2;
        }
        borderDetectionImageView.setListener(new MagnifierBorderDetectionListener(magnifierView));
        this.documentDetector = DocumentDetector.create(requireContext());
        applyCustomStyle();
        return viewInflate;
    }

    @Override // androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        loadBitmap();
        addQuadrangleToView(getPage().getQuadrangle());
    }

    /* JADX INFO: renamed from: com.geniusscansdk.scanflow.BorderDetectionFragment$loadBitmap$1, reason: invalid class name */
    /* JADX INFO: compiled from: BorderDetectionFragment.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.geniusscansdk.scanflow.BorderDetectionFragment$loadBitmap$1", f = "BorderDetectionFragment.kt", i = {}, l = {78}, m = "invokeSuspend", n = {}, s = {})
    static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;

        AnonymousClass1(Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return BorderDetectionFragment.this.new AnonymousClass1(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                BitmapLoader bitmapLoader = BorderDetectionFragment.this.bitmapLoader;
                File originalImage = BorderDetectionFragment.this.getPage().getOriginalImage();
                WindowManager windowManager = BorderDetectionFragment.this.requireActivity().getWindowManager();
                Intrinsics.checkNotNullExpressionValue(windowManager, "getWindowManager(...)");
                this.label = 1;
                obj = bitmapLoader.loadFullScreenBitmap(originalImage, windowManager, this);
                if (obj == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
            Bitmap bitmap = (Bitmap) obj;
            BorderDetectionImageView borderDetectionImageView = BorderDetectionFragment.this.imageView;
            MagnifierView magnifierView = null;
            if (borderDetectionImageView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("imageView");
                borderDetectionImageView = null;
            }
            borderDetectionImageView.setImageBitmap(bitmap);
            MagnifierView magnifierView2 = BorderDetectionFragment.this.magnifierView;
            if (magnifierView2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("magnifierView");
            } else {
                magnifierView = magnifierView2;
            }
            magnifierView.setBitmap(bitmap);
            return Unit.INSTANCE;
        }
    }

    private final Job loadBitmap() {
        return BuildersKt__Builders_commonKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this), null, null, new AnonymousClass1(null), 3, null);
    }

    private final void updateDetectButton() {
        BorderDetectionImageView borderDetectionImageView = this.imageView;
        MaterialButton materialButton = null;
        if (borderDetectionImageView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("imageView");
            borderDetectionImageView = null;
        }
        Quadrangle quad = borderDetectionImageView.getQuad();
        if (quad == null || quad.isFullImage()) {
            MaterialButton materialButton2 = this.detectButton;
            if (materialButton2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("detectButton");
                materialButton2 = null;
            }
            materialButton2.setIconResource(R.drawable.ic_baseline_fullscreen_exit_24);
            MaterialButton materialButton3 = this.detectButton;
            if (materialButton3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("detectButton");
                materialButton3 = null;
            }
            materialButton3.setOnClickListener(new View.OnClickListener() { // from class: com.geniusscansdk.scanflow.BorderDetectionFragment$$ExternalSyntheticLambda3
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    this.f$0.startDetection();
                }
            });
            MaterialButton materialButton4 = this.detectButton;
            if (materialButton4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("detectButton");
                materialButton4 = null;
            }
            materialButton4.setContentDescription(getString(R.string.gssdk_crop_autodetect));
        } else {
            MaterialButton materialButton5 = this.detectButton;
            if (materialButton5 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("detectButton");
                materialButton5 = null;
            }
            materialButton5.setIconResource(R.drawable.ic_baseline_fullscreen_24);
            MaterialButton materialButton6 = this.detectButton;
            if (materialButton6 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("detectButton");
                materialButton6 = null;
            }
            materialButton6.setOnClickListener(new View.OnClickListener() { // from class: com.geniusscansdk.scanflow.BorderDetectionFragment$$ExternalSyntheticLambda4
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    this.f$0.setQuadrangleToFullImage();
                }
            });
            MaterialButton materialButton7 = this.detectButton;
            if (materialButton7 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("detectButton");
                materialButton7 = null;
            }
            materialButton7.setContentDescription(getString(R.string.gssdk_crop_maximize));
        }
        MaterialButton materialButton8 = this.detectButton;
        if (materialButton8 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("detectButton");
        } else {
            materialButton = materialButton8;
        }
        ViewUtils.applyColor(materialButton, getScanConfiguration().foregroundColor, getScanConfiguration().backgroundColor);
    }

    /* JADX INFO: renamed from: com.geniusscansdk.scanflow.BorderDetectionFragment$startDetection$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: BorderDetectionFragment.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.geniusscansdk.scanflow.BorderDetectionFragment$startDetection$1", f = "BorderDetectionFragment.kt", i = {}, l = {102}, m = "invokeSuspend", n = {}, s = {})
    static final class C17761 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;

        C17761(Continuation<? super C17761> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return BorderDetectionFragment.this.new C17761(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C17761) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            ProgressBar progressBar = null;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                ProgressBar progressBar2 = BorderDetectionFragment.this.progressBar;
                if (progressBar2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("progressBar");
                    progressBar2 = null;
                }
                progressBar2.setVisibility(0);
                this.label = 1;
                obj = BuildersKt.withContext(Dispatchers.getIO(), new BorderDetectionFragment$startDetection$1$quadrangle$1(BorderDetectionFragment.this, null), this);
                if (obj == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
            Intrinsics.checkNotNullExpressionValue(obj, "withContext(...)");
            BorderDetectionFragment.this.addQuadrangleToView((Quadrangle) obj);
            ProgressBar progressBar3 = BorderDetectionFragment.this.progressBar;
            if (progressBar3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("progressBar");
            } else {
                progressBar = progressBar3;
            }
            progressBar.setVisibility(8);
            return Unit.INSTANCE;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void startDetection() {
        BuildersKt__Builders_commonKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this), this.exceptionHandler, null, new C17761(null), 2, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void addQuadrangleToView(Quadrangle quadrangle) {
        BorderDetectionImageView borderDetectionImageView = this.imageView;
        BorderDetectionImageView borderDetectionImageView2 = null;
        if (borderDetectionImageView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("imageView");
            borderDetectionImageView = null;
        }
        borderDetectionImageView.setQuad(quadrangle);
        BorderDetectionImageView borderDetectionImageView3 = this.imageView;
        if (borderDetectionImageView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("imageView");
        } else {
            borderDetectionImageView2 = borderDetectionImageView3;
        }
        borderDetectionImageView2.invalidate();
        updateDetectButton();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void setQuadrangleToFullImage() {
        BorderDetectionImageView borderDetectionImageView = this.imageView;
        BorderDetectionImageView borderDetectionImageView2 = null;
        if (borderDetectionImageView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("imageView");
            borderDetectionImageView = null;
        }
        borderDetectionImageView.setQuad(Quadrangle.INSTANCE.createFullQuadrangle());
        BorderDetectionImageView borderDetectionImageView3 = this.imageView;
        if (borderDetectionImageView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("imageView");
        } else {
            borderDetectionImageView2 = borderDetectionImageView3;
        }
        borderDetectionImageView2.invalidate();
        updateDetectButton();
    }

    /* JADX INFO: renamed from: com.geniusscansdk.scanflow.BorderDetectionFragment$validatePage$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: BorderDetectionFragment.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.geniusscansdk.scanflow.BorderDetectionFragment$validatePage$1", f = "BorderDetectionFragment.kt", i = {}, l = {127}, m = "invokeSuspend", n = {}, s = {})
    static final class C17771 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;

        C17771(Continuation<? super C17771> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return BorderDetectionFragment.this.new C17771(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C17771) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            ProgressBar progressBar = null;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                ProgressBar progressBar2 = BorderDetectionFragment.this.progressBar;
                if (progressBar2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("progressBar");
                    progressBar2 = null;
                }
                progressBar2.setVisibility(0);
                this.label = 1;
                if (BorderDetectionFragment.this.getScanActivity().processPage$gssdk_release(BorderDetectionFragment.this.getPage(), this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
            ProgressBar progressBar3 = BorderDetectionFragment.this.progressBar;
            if (progressBar3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("progressBar");
            } else {
                progressBar = progressBar3;
            }
            progressBar.setVisibility(8);
            BorderDetectionFragment.this.getParentFragmentManager().setFragmentResult(BorderDetectionFragment.REQUEST_KEY, new Bundle());
            return Unit.INSTANCE;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void validatePage() {
        Page page = getPage();
        BorderDetectionImageView borderDetectionImageView = this.imageView;
        if (borderDetectionImageView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("imageView");
            borderDetectionImageView = null;
        }
        page.setQuadrangle(borderDetectionImageView.getQuad());
        BuildersKt__Builders_commonKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this), this.exceptionHandler, null, new C17771(null), 2, null);
    }

    private final void applyCustomStyle() {
        BorderDetectionImageView borderDetectionImageView = this.imageView;
        ProgressBar progressBar = null;
        if (borderDetectionImageView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("imageView");
            borderDetectionImageView = null;
        }
        borderDetectionImageView.setOverlayColor(getScanConfiguration().highlightColor);
        MaterialButton materialButton = this.validateButton;
        if (materialButton == null) {
            Intrinsics.throwUninitializedPropertyAccessException("validateButton");
            materialButton = null;
        }
        ViewUtils.applyColor(materialButton, getScanConfiguration().foregroundColor, getScanConfiguration().backgroundColor);
        MaterialButton materialButton2 = this.detectButton;
        if (materialButton2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("detectButton");
            materialButton2 = null;
        }
        ViewUtils.applyColor(materialButton2, getScanConfiguration().foregroundColor, getScanConfiguration().backgroundColor);
        ProgressBar progressBar2 = this.progressBar;
        if (progressBar2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("progressBar");
        } else {
            progressBar = progressBar2;
        }
        ViewUtils.applyColor(progressBar, getScanConfiguration().foregroundColor);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final ScanActivity getScanActivity() {
        FragmentActivity activity = getActivity();
        Intrinsics.checkNotNull(activity, "null cannot be cast to non-null type com.geniusscansdk.scanflow.ScanActivity");
        return (ScanActivity) activity;
    }

    /* JADX INFO: compiled from: BorderDetectionFragment.kt */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0080\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0016\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bR\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006\f"}, d2 = {"Lcom/geniusscansdk/scanflow/BorderDetectionFragment$Companion;", "", "<init>", "()V", "REQUEST_KEY", "", "newInstance", "Lcom/geniusscansdk/scanflow/BorderDetectionFragment;", Location.TYPE_PAGE, "Lcom/geniusscansdk/scanflow/Page;", "scanConfiguration", "Lcom/geniusscansdk/scanflow/ScanConfiguration;", "gssdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final BorderDetectionFragment newInstance(Page page, ScanConfiguration scanConfiguration) {
            Intrinsics.checkNotNullParameter(page, "page");
            Intrinsics.checkNotNullParameter(scanConfiguration, "scanConfiguration");
            Bundle bundle = new Bundle();
            bundle.putParcelable(Location.TYPE_PAGE, page);
            bundle.putSerializable("scanConfiguration", scanConfiguration);
            BorderDetectionFragment borderDetectionFragment = new BorderDetectionFragment();
            borderDetectionFragment.setArguments(bundle);
            return borderDetectionFragment;
        }
    }
}
