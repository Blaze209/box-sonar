package com.box.android.capture.imagecapture.presentation;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.activity.OnBackPressedCallback;
import androidx.activity.OnBackPressedDispatcher;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.view.OnApplyWindowInsetsListener;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.fragment.app.FragmentActivity;
import androidx.media3.extractor.text.ttml.TtmlNode;
import com.box.android.capture.R;
import com.box.android.capture.cpl.ImageCaptureReducer;
import com.box.android.capture.databinding.LayoutReviewPhotoBinding;
import com.box.android.common.utilities.CommonBoxUtil;
import com.box.android.cpl.Store;
import com.box.android.cpl.StoreKt;
import com.bumptech.glide.Glide;
import com.bumptech.glide.RequestBuilder;
import com.bumptech.glide.RequestManager;
import com.facebook.react.uimanager.ViewProps;
import dagger.hilt.android.AndroidEntryPoint;
import java.io.File;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference1Impl;

/* JADX INFO: compiled from: PhotoReviewFragment.kt */
/* JADX INFO: loaded from: classes10.dex */
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0007\u0018\u00002\u00020\u00012\u00020\u0002B\u001b\u0012\u0012\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004¢\u0006\u0004\b\u0007\u0010\bJ\u0012\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012H\u0016J$\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u00182\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012H\u0016J\u001a\u0010\u0019\u001a\u00020\u00102\u0006\u0010\u001a\u001a\u00020\u00142\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012H\u0016J\b\u0010\u001b\u001a\u00020\u0010H\u0002J\b\u0010\u001c\u001a\u00020\u0010H\u0002J\u0010\u0010\u001d\u001a\u00020\u00102\u0006\u0010\u001e\u001a\u00020\u0014H\u0016R\u001d\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u000e\u0010\u000b\u001a\u00020\fX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082.¢\u0006\u0002\n\u0000¨\u0006\u001f"}, d2 = {"Lcom/box/android/capture/imagecapture/presentation/PhotoReviewFragment;", "Lcom/box/android/base/presentation/fragments/BoxFragment;", "Landroid/view/View$OnClickListener;", "cameraStore", "Lcom/box/android/cpl/Store;", "Lcom/box/android/capture/cpl/ImageCaptureReducer$State$Review;", "Lcom/box/android/capture/cpl/ImageCaptureReducer$Action;", "<init>", "(Lcom/box/android/cpl/Store;)V", "getCameraStore", "()Lcom/box/android/cpl/Store;", "previewFile", "Ljava/io/File;", "binding", "Lcom/box/android/capture/databinding/LayoutReviewPhotoBinding;", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", TtmlNode.RUBY_CONTAINER, "Landroid/view/ViewGroup;", "onViewCreated", "view", "setupUI", "supportEdgeToEdge", ViewProps.ON_CLICK, "v", "capture_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
@AndroidEntryPoint
public final class PhotoReviewFragment extends Hilt_PhotoReviewFragment implements View.OnClickListener {
    public static final int $stable = 8;
    private LayoutReviewPhotoBinding binding;
    private final Store<ImageCaptureReducer.State.Review, ImageCaptureReducer.Action> cameraStore;
    private File previewFile;

    public PhotoReviewFragment(Store<ImageCaptureReducer.State.Review, ImageCaptureReducer.Action> cameraStore) {
        Intrinsics.checkNotNullParameter(cameraStore, "cameraStore");
        this.cameraStore = cameraStore;
    }

    public final Store<ImageCaptureReducer.State.Review, ImageCaptureReducer.Action> getCameraStore() {
        return this.cameraStore;
    }

    @Override // androidx.fragment.app.Fragment
    public void onCreate(Bundle savedInstanceState) {
        OnBackPressedDispatcher onBackPressedDispatcher;
        super.onCreate(savedInstanceState);
        FragmentActivity activity = getActivity();
        if (activity == null || (onBackPressedDispatcher = activity.getOnBackPressedDispatcher()) == null) {
            return;
        }
        onBackPressedDispatcher.addCallback(this, new OnBackPressedCallback() { // from class: com.box.android.capture.imagecapture.presentation.PhotoReviewFragment.onCreate.1
            {
                super(true);
            }

            @Override // androidx.activity.OnBackPressedCallback
            public void handleOnBackPressed() {
                File file = PhotoReviewFragment.this.previewFile;
                if (file == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("previewFile");
                    file = null;
                }
                file.delete();
                PhotoReviewFragment.this.getCameraStore().send(ImageCaptureReducer.Action.FinishReview.INSTANCE);
            }
        });
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        LayoutReviewPhotoBinding layoutReviewPhotoBindingInflate = LayoutReviewPhotoBinding.inflate(getLayoutInflater(), container, false);
        Intrinsics.checkNotNullExpressionValue(layoutReviewPhotoBindingInflate, "inflate(...)");
        this.binding = layoutReviewPhotoBindingInflate;
        if (layoutReviewPhotoBindingInflate == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            layoutReviewPhotoBindingInflate = null;
        }
        ConstraintLayout root = layoutReviewPhotoBindingInflate.getRoot();
        Intrinsics.checkNotNullExpressionValue(root, "getRoot(...)");
        return root;
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, savedInstanceState);
        StoreKt.observe$default(this.cameraStore, new PropertyReference1Impl() { // from class: com.box.android.capture.imagecapture.presentation.PhotoReviewFragment.onViewCreated.1
            @Override // kotlin.jvm.internal.PropertyReference1Impl, kotlin.reflect.KProperty1
            public Object get(Object obj) {
                return ((ImageCaptureReducer.State.Review) obj).getFile();
            }
        }, null, new Function1() { // from class: com.box.android.capture.imagecapture.presentation.PhotoReviewFragment$$ExternalSyntheticLambda1
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return PhotoReviewFragment.onViewCreated$lambda$0(this.f$0, (File) obj);
            }
        }, 2, null);
        setupUI();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit onViewCreated$lambda$0(PhotoReviewFragment photoReviewFragment, File file) {
        Intrinsics.checkNotNullParameter(file, "file");
        photoReviewFragment.previewFile = file;
        RequestManager requestManagerWith = Glide.with(photoReviewFragment.requireContext());
        File file2 = photoReviewFragment.previewFile;
        LayoutReviewPhotoBinding layoutReviewPhotoBinding = null;
        if (file2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("previewFile");
            file2 = null;
        }
        RequestBuilder requestBuilderFitCenter = requestManagerWith.load(file2).fitCenter();
        LayoutReviewPhotoBinding layoutReviewPhotoBinding2 = photoReviewFragment.binding;
        if (layoutReviewPhotoBinding2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        } else {
            layoutReviewPhotoBinding = layoutReviewPhotoBinding2;
        }
        requestBuilderFitCenter.into(layoutReviewPhotoBinding.photoPreview);
        return Unit.INSTANCE;
    }

    private final void setupUI() {
        LayoutReviewPhotoBinding layoutReviewPhotoBinding = this.binding;
        LayoutReviewPhotoBinding layoutReviewPhotoBinding2 = null;
        if (layoutReviewPhotoBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            layoutReviewPhotoBinding = null;
        }
        ImageView photoPreview = layoutReviewPhotoBinding.photoPreview;
        Intrinsics.checkNotNullExpressionValue(photoPreview, "photoPreview");
        CommonBoxUtil.addStatusBarPaddingTop(photoPreview);
        supportEdgeToEdge();
        LayoutReviewPhotoBinding layoutReviewPhotoBinding3 = this.binding;
        if (layoutReviewPhotoBinding3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            layoutReviewPhotoBinding3 = null;
        }
        PhotoReviewFragment photoReviewFragment = this;
        layoutReviewPhotoBinding3.retake.setOnClickListener(photoReviewFragment);
        LayoutReviewPhotoBinding layoutReviewPhotoBinding4 = this.binding;
        if (layoutReviewPhotoBinding4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        } else {
            layoutReviewPhotoBinding2 = layoutReviewPhotoBinding4;
        }
        layoutReviewPhotoBinding2.usePhoto.setOnClickListener(photoReviewFragment);
    }

    private final void supportEdgeToEdge() {
        LayoutReviewPhotoBinding layoutReviewPhotoBinding = this.binding;
        if (layoutReviewPhotoBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            layoutReviewPhotoBinding = null;
        }
        ViewCompat.setOnApplyWindowInsetsListener(layoutReviewPhotoBinding.getRoot(), new OnApplyWindowInsetsListener() { // from class: com.box.android.capture.imagecapture.presentation.PhotoReviewFragment$$ExternalSyntheticLambda0
            @Override // androidx.core.view.OnApplyWindowInsetsListener
            public final WindowInsetsCompat onApplyWindowInsets(View view, WindowInsetsCompat windowInsetsCompat) {
                return PhotoReviewFragment.supportEdgeToEdge$lambda$0(this.f$0, view, windowInsetsCompat);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final WindowInsetsCompat supportEdgeToEdge$lambda$0(PhotoReviewFragment photoReviewFragment, View view, WindowInsetsCompat insets) {
        Intrinsics.checkNotNullParameter(view, "<unused var>");
        Intrinsics.checkNotNullParameter(insets, "insets");
        int i = insets.getInsets(WindowInsetsCompat.Type.systemBars()).bottom;
        LayoutReviewPhotoBinding layoutReviewPhotoBinding = photoReviewFragment.binding;
        if (layoutReviewPhotoBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            layoutReviewPhotoBinding = null;
        }
        View bottomBarContainer = layoutReviewPhotoBinding.bottomBarContainer;
        Intrinsics.checkNotNullExpressionValue(bottomBarContainer, "bottomBarContainer");
        ViewGroup.LayoutParams layoutParams = bottomBarContainer.getLayoutParams();
        if (layoutParams != null) {
            ConstraintLayout.LayoutParams layoutParams2 = (ConstraintLayout.LayoutParams) layoutParams;
            layoutParams2.bottomMargin = i;
            bottomBarContainer.setLayoutParams(layoutParams2);
            return WindowInsetsCompat.CONSUMED;
        }
        throw new NullPointerException("null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View v) {
        Intrinsics.checkNotNullParameter(v, "v");
        int id = v.getId();
        File file = null;
        if (id == R.id.retake) {
            File file2 = this.previewFile;
            if (file2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("previewFile");
            } else {
                file = file2;
            }
            file.delete();
            this.cameraStore.send(ImageCaptureReducer.Action.FinishReview.INSTANCE);
            return;
        }
        if (id == R.id.use_photo) {
            Store<ImageCaptureReducer.State.Review, ImageCaptureReducer.Action> store = this.cameraStore;
            File file3 = this.previewFile;
            if (file3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("previewFile");
            } else {
                file = file3;
            }
            store.send(new ImageCaptureReducer.Action.UploadPhoto(file));
        }
    }
}
