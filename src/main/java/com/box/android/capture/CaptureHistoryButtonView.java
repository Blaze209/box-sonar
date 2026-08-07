package com.box.android.capture;

import android.content.Context;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.util.AttributeSet;
import android.widget.ProgressBar;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModelProvider;
import com.box.android.base.presentation.ThumbnailManager;
import com.box.android.capture.databinding.CaptureHistoryButtonViewBinding;
import com.box.android.capture.viewmodel.CaptureHistoryButtonViewModel;
import com.box.android.common.extensions.ProgressBarExtensionsKt;
import com.box.android.common.utilities.CommonBoxUtil;
import com.box.android.domain.models.JobInfo;
import com.box.android.domain.models.JobInfosSummary;
import com.google.android.material.imageview.ShapeableImageView;
import com.pspdfkit.BuildConfig;
import dagger.hilt.android.AndroidEntryPoint;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: CaptureHistoryButtonView.kt */
/* JADX INFO: loaded from: classes10.dex */
@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0005\b\u0007\u0018\u00002\u00020\u0001B%\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\u000e\u0010\u0018\u001a\u00020\u00192\u0006\u0010\n\u001a\u00020\u000bJ\b\u0010\u001a\u001a\u00020\u0019H\u0002J\b\u0010\u001b\u001a\u00020\u0019H\u0002J\b\u0010\u001c\u001a\u00020\u0019H\u0002J\b\u0010\u001d\u001a\u00020\u001eH\u0002J\b\u0010\u001f\u001a\u00020\u0007H\u0002J\b\u0010 \u001a\u00020\u001eH\u0002J\b\u0010!\u001a\u00020\u0019H\u0002J\b\u0010\"\u001a\u00020\u0019H\u0002R\u000e\u0010\n\u001a\u00020\u000bX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0082.¢\u0006\u0002\n\u0000R\u001e\u0010\u0012\u001a\u00020\u00138\u0006@\u0006X\u0087.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017¨\u0006#"}, d2 = {"Lcom/box/android/capture/CaptureHistoryButtonView;", "Landroidx/constraintlayout/widget/ConstraintLayout;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", BuildConfig.FLAVOR, "Landroidx/fragment/app/Fragment;", "activity", "Landroidx/fragment/app/FragmentActivity;", "captureHistoryButtonViewModel", "Lcom/box/android/capture/viewmodel/CaptureHistoryButtonViewModel;", "binding", "Lcom/box/android/capture/databinding/CaptureHistoryButtonViewBinding;", "thumbnailManager", "Lcom/box/android/base/presentation/ThumbnailManager;", "getThumbnailManager", "()Lcom/box/android/base/presentation/ThumbnailManager;", "setThumbnailManager", "(Lcom/box/android/base/presentation/ThumbnailManager;)V", "initView", "", "initViewModel", "enforceIndicatorsVisibility", "enforceRing", "hasUploadsInProgress", "", "getNumOfUploadsInProgress", "hasError", "showNoJobsRing", "showErrorRing", "capture_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
@AndroidEntryPoint
public final class CaptureHistoryButtonView extends Hilt_CaptureHistoryButtonView {
    public static final int $stable = 8;
    private FragmentActivity activity;
    private CaptureHistoryButtonViewBinding binding;
    private CaptureHistoryButtonViewModel captureHistoryButtonViewModel;
    private Fragment fragment;

    @Inject
    public ThumbnailManager thumbnailManager;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public CaptureHistoryButtonView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CaptureHistoryButtonView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    public /* synthetic */ CaptureHistoryButtonView(Context context, AttributeSet attributeSet, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, attributeSet, (i2 & 4) != 0 ? 0 : i);
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

    public final void initView(Fragment fragment) {
        Intrinsics.checkNotNullParameter(fragment, "fragment");
        this.fragment = fragment;
        FragmentActivity activity = fragment.getActivity();
        Intrinsics.checkNotNull(activity, "null cannot be cast to non-null type androidx.fragment.app.FragmentActivity");
        this.activity = activity;
        if (activity == null) {
            Intrinsics.throwUninitializedPropertyAccessException("activity");
            activity = null;
        }
        CaptureHistoryButtonViewBinding captureHistoryButtonViewBindingInflate = CaptureHistoryButtonViewBinding.inflate(activity.getLayoutInflater(), this, true);
        Intrinsics.checkNotNullExpressionValue(captureHistoryButtonViewBindingInflate, "inflate(...)");
        this.binding = captureHistoryButtonViewBindingInflate;
        initViewModel();
    }

    private final void initViewModel() {
        FragmentActivity fragmentActivity = this.activity;
        Fragment fragment = null;
        if (fragmentActivity == null) {
            Intrinsics.throwUninitializedPropertyAccessException("activity");
            fragmentActivity = null;
        }
        CaptureHistoryButtonViewModel captureHistoryButtonViewModel = (CaptureHistoryButtonViewModel) new ViewModelProvider(fragmentActivity).get(CaptureHistoryButtonViewModel.class);
        this.captureHistoryButtonViewModel = captureHistoryButtonViewModel;
        if (captureHistoryButtonViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("captureHistoryButtonViewModel");
            captureHistoryButtonViewModel = null;
        }
        LiveData<JobInfosSummary> jobInfosSummary = captureHistoryButtonViewModel.getJobInfosSummary();
        Fragment fragment2 = this.fragment;
        if (fragment2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException(BuildConfig.FLAVOR);
            fragment2 = null;
        }
        jobInfosSummary.observe(fragment2.getViewLifecycleOwner(), new CaptureHistoryButtonView$sam$androidx_lifecycle_Observer$0(new Function1() { // from class: com.box.android.capture.CaptureHistoryButtonView$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return CaptureHistoryButtonView.initViewModel$lambda$0(this.f$0, (JobInfosSummary) obj);
            }
        }));
        CaptureHistoryButtonViewModel captureHistoryButtonViewModel2 = this.captureHistoryButtonViewModel;
        if (captureHistoryButtonViewModel2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("captureHistoryButtonViewModel");
            captureHistoryButtonViewModel2 = null;
        }
        LiveData<CaptureHistoryButtonViewModel.CaptureThumbnailResource> lastCaptureThumbnail = captureHistoryButtonViewModel2.getLastCaptureThumbnail();
        Fragment fragment3 = this.fragment;
        if (fragment3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException(BuildConfig.FLAVOR);
        } else {
            fragment = fragment3;
        }
        lastCaptureThumbnail.observe(fragment.getViewLifecycleOwner(), new CaptureHistoryButtonView$sam$androidx_lifecycle_Observer$0(new Function1() { // from class: com.box.android.capture.CaptureHistoryButtonView$$ExternalSyntheticLambda1
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return CaptureHistoryButtonView.initViewModel$lambda$1(this.f$0, (CaptureHistoryButtonViewModel.CaptureThumbnailResource) obj);
            }
        }));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit initViewModel$lambda$0(CaptureHistoryButtonView captureHistoryButtonView, JobInfosSummary jobInfosSummary) {
        CaptureHistoryButtonViewBinding captureHistoryButtonViewBinding = captureHistoryButtonView.binding;
        CaptureHistoryButtonViewBinding captureHistoryButtonViewBinding2 = null;
        if (captureHistoryButtonViewBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            captureHistoryButtonViewBinding = null;
        }
        captureHistoryButtonViewBinding.numOfUploadsInProgress.setText(String.valueOf(jobInfosSummary.getJobCount()));
        JobInfo.Progress totalProgress = jobInfosSummary.getTotalProgress();
        CaptureHistoryButtonViewBinding captureHistoryButtonViewBinding3 = captureHistoryButtonView.binding;
        if (captureHistoryButtonViewBinding3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            captureHistoryButtonViewBinding3 = null;
        }
        ProgressBar progressBar = captureHistoryButtonViewBinding3.progressBar;
        Intrinsics.checkNotNullExpressionValue(progressBar, "progressBar");
        Context context = captureHistoryButtonView.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "getContext(...)");
        int colorFromAttribute = CommonBoxUtil.getColorFromAttribute(context, R.attr.contentSecondary);
        Context context2 = captureHistoryButtonView.getContext();
        Intrinsics.checkNotNullExpressionValue(context2, "getContext(...)");
        ProgressBarExtensionsKt.setRingsColor(progressBar, colorFromAttribute, CommonBoxUtil.getColorFromAttribute(context2, R.attr.statusProgress));
        CaptureHistoryButtonViewBinding captureHistoryButtonViewBinding4 = captureHistoryButtonView.binding;
        if (captureHistoryButtonViewBinding4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            captureHistoryButtonViewBinding4 = null;
        }
        captureHistoryButtonViewBinding4.progressBar.setMin(0);
        CaptureHistoryButtonViewBinding captureHistoryButtonViewBinding5 = captureHistoryButtonView.binding;
        if (captureHistoryButtonViewBinding5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            captureHistoryButtonViewBinding5 = null;
        }
        captureHistoryButtonViewBinding5.progressBar.setMax((int) totalProgress.getEstimatedTotal());
        CaptureHistoryButtonViewBinding captureHistoryButtonViewBinding6 = captureHistoryButtonView.binding;
        if (captureHistoryButtonViewBinding6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        } else {
            captureHistoryButtonViewBinding2 = captureHistoryButtonViewBinding6;
        }
        captureHistoryButtonViewBinding2.progressBar.setProgress((int) totalProgress.getDone(), true);
        captureHistoryButtonView.enforceRing();
        captureHistoryButtonView.enforceIndicatorsVisibility();
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit initViewModel$lambda$1(CaptureHistoryButtonView captureHistoryButtonView, CaptureHistoryButtonViewModel.CaptureThumbnailResource captureThumbnailResource) {
        CaptureHistoryButtonViewBinding captureHistoryButtonViewBinding = null;
        if (captureThumbnailResource != null) {
            CaptureHistoryButtonViewBinding captureHistoryButtonViewBinding2 = captureHistoryButtonView.binding;
            if (captureHistoryButtonViewBinding2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
                captureHistoryButtonViewBinding2 = null;
            }
            captureHistoryButtonViewBinding2.captureHistoryEmpty.setVisibility(8);
            CaptureHistoryButtonViewBinding captureHistoryButtonViewBinding3 = captureHistoryButtonView.binding;
            if (captureHistoryButtonViewBinding3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
                captureHistoryButtonViewBinding3 = null;
            }
            captureHistoryButtonViewBinding3.captureHistoryThumbnail.setVisibility(0);
            if (captureThumbnailResource instanceof CaptureHistoryButtonViewModel.CaptureThumbnailResource.ThumbnailResourceId) {
                ThumbnailManager thumbnailManager = captureHistoryButtonView.getThumbnailManager();
                int resourceId = ((CaptureHistoryButtonViewModel.CaptureThumbnailResource.ThumbnailResourceId) captureThumbnailResource).getResourceId();
                CaptureHistoryButtonViewBinding captureHistoryButtonViewBinding4 = captureHistoryButtonView.binding;
                if (captureHistoryButtonViewBinding4 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("binding");
                } else {
                    captureHistoryButtonViewBinding = captureHistoryButtonViewBinding4;
                }
                ShapeableImageView captureHistoryThumbnail = captureHistoryButtonViewBinding.captureHistoryThumbnail;
                Intrinsics.checkNotNullExpressionValue(captureHistoryThumbnail, "captureHistoryThumbnail");
                thumbnailManager.loadKnownThumbnail(resourceId, captureHistoryThumbnail);
            } else {
                if (!(captureThumbnailResource instanceof CaptureHistoryButtonViewModel.CaptureThumbnailResource.ThumbnailUrl)) {
                    throw new NoWhenBranchMatchedException();
                }
                ThumbnailManager thumbnailManager2 = captureHistoryButtonView.getThumbnailManager();
                String url = ((CaptureHistoryButtonViewModel.CaptureThumbnailResource.ThumbnailUrl) captureThumbnailResource).getUrl();
                CaptureHistoryButtonViewBinding captureHistoryButtonViewBinding5 = captureHistoryButtonView.binding;
                if (captureHistoryButtonViewBinding5 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("binding");
                } else {
                    captureHistoryButtonViewBinding = captureHistoryButtonViewBinding5;
                }
                ShapeableImageView captureHistoryThumbnail2 = captureHistoryButtonViewBinding.captureHistoryThumbnail;
                Intrinsics.checkNotNullExpressionValue(captureHistoryThumbnail2, "captureHistoryThumbnail");
                thumbnailManager2.loadKnownThumbnail(url, captureHistoryThumbnail2);
            }
        } else {
            CaptureHistoryButtonViewBinding captureHistoryButtonViewBinding6 = captureHistoryButtonView.binding;
            if (captureHistoryButtonViewBinding6 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
                captureHistoryButtonViewBinding6 = null;
            }
            captureHistoryButtonViewBinding6.captureHistoryEmpty.setVisibility(0);
            CaptureHistoryButtonViewBinding captureHistoryButtonViewBinding7 = captureHistoryButtonView.binding;
            if (captureHistoryButtonViewBinding7 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
            } else {
                captureHistoryButtonViewBinding = captureHistoryButtonViewBinding7;
            }
            captureHistoryButtonViewBinding.captureHistoryThumbnail.setVisibility(8);
        }
        return Unit.INSTANCE;
    }

    private final void enforceIndicatorsVisibility() {
        CaptureHistoryButtonViewBinding captureHistoryButtonViewBinding = this.binding;
        CaptureHistoryButtonViewBinding captureHistoryButtonViewBinding2 = null;
        if (captureHistoryButtonViewBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            captureHistoryButtonViewBinding = null;
        }
        captureHistoryButtonViewBinding.numOfUploadsInProgress.setVisibility((!hasUploadsInProgress() || hasError()) ? 8 : 0);
        CaptureHistoryButtonViewBinding captureHistoryButtonViewBinding3 = this.binding;
        if (captureHistoryButtonViewBinding3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            captureHistoryButtonViewBinding3 = null;
        }
        captureHistoryButtonViewBinding3.errorIndicator.setVisibility(hasError() ? 0 : 8);
        if (hasError() || hasUploadsInProgress()) {
            CaptureHistoryButtonViewBinding captureHistoryButtonViewBinding4 = this.binding;
            if (captureHistoryButtonViewBinding4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
            } else {
                captureHistoryButtonViewBinding2 = captureHistoryButtonViewBinding4;
            }
            captureHistoryButtonViewBinding2.captureHistoryThumbnail.setColorFilter(getContext().getColor(R.color.black_20), PorterDuff.Mode.DARKEN);
            return;
        }
        CaptureHistoryButtonViewBinding captureHistoryButtonViewBinding5 = this.binding;
        if (captureHistoryButtonViewBinding5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        } else {
            captureHistoryButtonViewBinding2 = captureHistoryButtonViewBinding5;
        }
        captureHistoryButtonViewBinding2.captureHistoryThumbnail.setColorFilter(0, PorterDuff.Mode.SRC_ATOP);
    }

    private final void enforceRing() {
        if (hasError() && !hasUploadsInProgress()) {
            showErrorRing();
        } else {
            if (hasError() || hasUploadsInProgress()) {
                return;
            }
            showNoJobsRing();
        }
    }

    private final boolean hasUploadsInProgress() {
        return getNumOfUploadsInProgress() > 0;
    }

    private final int getNumOfUploadsInProgress() {
        CaptureHistoryButtonViewModel captureHistoryButtonViewModel = this.captureHistoryButtonViewModel;
        if (captureHistoryButtonViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("captureHistoryButtonViewModel");
            captureHistoryButtonViewModel = null;
        }
        JobInfosSummary value = captureHistoryButtonViewModel.getJobInfosSummary().getValue();
        if (value != null) {
            return value.getJobCount();
        }
        return 0;
    }

    private final boolean hasError() {
        CaptureHistoryButtonViewModel captureHistoryButtonViewModel = this.captureHistoryButtonViewModel;
        if (captureHistoryButtonViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("captureHistoryButtonViewModel");
            captureHistoryButtonViewModel = null;
        }
        JobInfosSummary value = captureHistoryButtonViewModel.getJobInfosSummary().getValue();
        if (value != null) {
            return value.getHasError();
        }
        return false;
    }

    private final void showNoJobsRing() {
        CaptureHistoryButtonViewBinding captureHistoryButtonViewBinding = this.binding;
        if (captureHistoryButtonViewBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            captureHistoryButtonViewBinding = null;
        }
        Drawable progressDrawable = captureHistoryButtonViewBinding.progressBar.getProgressDrawable();
        Intrinsics.checkNotNull(progressDrawable, "null cannot be cast to non-null type android.graphics.drawable.LayerDrawable");
        ((LayerDrawable) progressDrawable).getDrawable(0).setColorFilter(null);
        CaptureHistoryButtonViewBinding captureHistoryButtonViewBinding2 = this.binding;
        if (captureHistoryButtonViewBinding2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            captureHistoryButtonViewBinding2 = null;
        }
        Drawable progressDrawable2 = captureHistoryButtonViewBinding2.progressBar.getProgressDrawable();
        Intrinsics.checkNotNull(progressDrawable2, "null cannot be cast to non-null type android.graphics.drawable.LayerDrawable");
        ((LayerDrawable) progressDrawable2).getDrawable(1).setColorFilter(null);
    }

    private final void showErrorRing() {
        CaptureHistoryButtonViewBinding captureHistoryButtonViewBinding = this.binding;
        if (captureHistoryButtonViewBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            captureHistoryButtonViewBinding = null;
        }
        Drawable progressDrawable = captureHistoryButtonViewBinding.progressBar.getProgressDrawable();
        Intrinsics.checkNotNull(progressDrawable, "null cannot be cast to non-null type android.graphics.drawable.LayerDrawable");
        Drawable drawable = ((LayerDrawable) progressDrawable).getDrawable(0);
        Context context = getContext();
        Intrinsics.checkNotNullExpressionValue(context, "getContext(...)");
        drawable.setColorFilter(CommonBoxUtil.getColorFromAttribute(context, R.attr.notification), PorterDuff.Mode.SRC_IN);
        CaptureHistoryButtonViewBinding captureHistoryButtonViewBinding2 = this.binding;
        if (captureHistoryButtonViewBinding2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            captureHistoryButtonViewBinding2 = null;
        }
        Drawable progressDrawable2 = captureHistoryButtonViewBinding2.progressBar.getProgressDrawable();
        Intrinsics.checkNotNull(progressDrawable2, "null cannot be cast to non-null type android.graphics.drawable.LayerDrawable");
        ((LayerDrawable) progressDrawable2).getDrawable(1).setColorFilter(null);
    }
}
