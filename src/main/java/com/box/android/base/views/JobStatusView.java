package com.box.android.base.views;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.animation.LinearInterpolator;
import android.view.animation.RotateAnimation;
import android.widget.ImageView;
import android.widget.ProgressBar;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.box.android.base.R;
import com.box.android.base.databinding.JobStatusViewBinding;
import com.box.android.common.extensions.ProgressBarExtensionsKt;
import com.box.android.common.utilities.CommonBoxUtil;
import com.box.android.domain.models.JobInfo;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: JobStatusView.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B%\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\u000e\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0011R\u0011\u0010\n\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\r¨\u0006\u0012"}, d2 = {"Lcom/box/android/base/views/JobStatusView;", "Landroidx/constraintlayout/widget/ConstraintLayout;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "binding", "Lcom/box/android/base/databinding/JobStatusViewBinding;", "getBinding", "()Lcom/box/android/base/databinding/JobStatusViewBinding;", "updateProgress", "", "status", "Lcom/box/android/domain/models/JobInfo$Status;", "base_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class JobStatusView extends ConstraintLayout {
    public static final int $stable = 8;
    private final JobStatusViewBinding binding;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public JobStatusView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public JobStatusView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Intrinsics.checkNotNullParameter(context, "context");
        JobStatusViewBinding jobStatusViewBindingInflate = JobStatusViewBinding.inflate(LayoutInflater.from(context), this, true);
        Intrinsics.checkNotNullExpressionValue(jobStatusViewBindingInflate, "inflate(...)");
        this.binding = jobStatusViewBindingInflate;
    }

    public /* synthetic */ JobStatusView(Context context, AttributeSet attributeSet, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, attributeSet, (i2 & 4) != 0 ? 0 : i);
    }

    public final JobStatusViewBinding getBinding() {
        return this.binding;
    }

    public final void updateProgress(JobInfo.Status status) {
        Intrinsics.checkNotNullParameter(status, "status");
        ProgressBar progressBar = this.binding.progressBar;
        Intrinsics.checkNotNullExpressionValue(progressBar, "progressBar");
        ImageView jobProgressStatus = this.binding.jobProgressStatus;
        Intrinsics.checkNotNullExpressionValue(jobProgressStatus, "jobProgressStatus");
        if (status instanceof JobInfo.Status.Blocked) {
            Context context = getContext();
            Intrinsics.checkNotNullExpressionValue(context, "getContext(...)");
            updateProgress$updateViews$default(progressBar, jobProgressStatus, this, CommonBoxUtil.getColorFromAttribute(context, R.attr.contentBackground), R.drawable.ic_job_progress, null, 32, null);
            return;
        }
        if (status instanceof JobInfo.Status.Cancelled) {
            Context context2 = getContext();
            Intrinsics.checkNotNullExpressionValue(context2, "getContext(...)");
            updateProgress$updateViews$default(progressBar, jobProgressStatus, this, CommonBoxUtil.getColorFromAttribute(context2, R.attr.contentSecondary), R.drawable.ic_job_restart, null, 32, null);
            return;
        }
        if (status instanceof JobInfo.Status.Delayed) {
            Context context3 = getContext();
            Intrinsics.checkNotNullExpressionValue(context3, "getContext(...)");
            updateProgress$updateViews$default(progressBar, jobProgressStatus, this, CommonBoxUtil.getColorFromAttribute(context3, R.attr.contentBackground), R.drawable.ic_job_progress, null, 32, null);
            return;
        }
        if (status instanceof JobInfo.Status.Failed) {
            Context context4 = getContext();
            Intrinsics.checkNotNullExpressionValue(context4, "getContext(...)");
            updateProgress$updateViews$default(progressBar, jobProgressStatus, this, CommonBoxUtil.getColorFromAttribute(context4, R.attr.notification), R.drawable.ic_job_restart, null, 32, null);
            return;
        }
        if (status instanceof JobInfo.Status.Paused) {
            Context context5 = getContext();
            Intrinsics.checkNotNullExpressionValue(context5, "getContext(...)");
            updateProgress$updateViews(progressBar, jobProgressStatus, this, CommonBoxUtil.getColorFromAttribute(context5, R.attr.contentSecondary), R.drawable.ic_job_restart, ((JobInfo.Status.Paused) status).getProgress());
            return;
        }
        if (status instanceof JobInfo.Status.Running) {
            Context context6 = getContext();
            Intrinsics.checkNotNullExpressionValue(context6, "getContext(...)");
            updateProgress$updateViews(progressBar, jobProgressStatus, this, CommonBoxUtil.getColorFromAttribute(context6, R.attr.contentSecondary), R.drawable.ic_job_progress, ((JobInfo.Status.Running) status).getProgress());
        } else if (status instanceof JobInfo.Status.Succeeded) {
            Context context7 = getContext();
            Intrinsics.checkNotNullExpressionValue(context7, "getContext(...)");
            updateProgress$updateViews$default(progressBar, jobProgressStatus, this, CommonBoxUtil.getColorFromAttribute(context7, R.attr.statusDone), R.drawable.ic_job_completed, null, 32, null);
        } else {
            if (!(status instanceof JobInfo.Status.Waiting)) {
                throw new NoWhenBranchMatchedException();
            }
            Context context8 = getContext();
            Intrinsics.checkNotNullExpressionValue(context8, "getContext(...)");
            updateProgress$updateViews$default(progressBar, jobProgressStatus, this, CommonBoxUtil.getColorFromAttribute(context8, R.attr.contentBackground), R.drawable.ic_job_progress, null, 32, null);
        }
    }

    static /* synthetic */ void updateProgress$updateViews$default(ProgressBar progressBar, ImageView imageView, JobStatusView jobStatusView, int i, int i2, JobInfo.Progress progress, int i3, Object obj) {
        if ((i3 & 32) != 0) {
            progress = null;
        }
        updateProgress$updateViews(progressBar, imageView, jobStatusView, i, i2, progress);
    }

    private static final void updateProgress$updateViews(ProgressBar progressBar, ImageView imageView, JobStatusView jobStatusView, int i, int i2, JobInfo.Progress progress) {
        ProgressBarExtensionsKt.setBackgroundRingColor(progressBar, i);
        imageView.setImageResource(i2);
        if (progress != null) {
            Context context = jobStatusView.getContext();
            Intrinsics.checkNotNullExpressionValue(context, "getContext(...)");
            ProgressBarExtensionsKt.setProgressRingColor(progressBar, CommonBoxUtil.getColorFromAttribute(context, R.attr.statusProgress));
            progressBar.setMin(0);
            progressBar.setMax((int) progress.getEstimatedTotal());
            progressBar.setProgress((int) progress.getDone(), true);
            if (imageView.getAnimation() == null && i2 == R.drawable.ic_job_progress) {
                RotateAnimation rotateAnimation = new RotateAnimation(0.0f, 360.0f, 1, 0.5f, 1, 0.5f);
                rotateAnimation.setInterpolator(new LinearInterpolator());
                rotateAnimation.setDuration(3000L);
                rotateAnimation.setRepeatCount(-1);
                imageView.startAnimation(rotateAnimation);
                return;
            }
            return;
        }
        Drawable progressDrawable = progressBar.getProgressDrawable();
        Intrinsics.checkNotNull(progressDrawable, "null cannot be cast to non-null type android.graphics.drawable.LayerDrawable");
        ((LayerDrawable) progressDrawable).getDrawable(1).setColorFilter(null);
        imageView.setAnimation(null);
    }
}
