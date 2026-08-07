package com.box.android.base.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.box.android.base.R;
import com.box.android.base.presentation.views.jobmanager.JobManagerPauseResumeButton;
import com.box.android.base.presentation.views.jobmanager.JobManagerProgressBar;
import com.box.android.base.presentation.views.jobmanager.JobManagerTransferController;

/* JADX INFO: loaded from: classes9.dex */
public final class LayoutJobListItemBinding implements ViewBinding {
    public final ImageView cancelButton;
    public final TextView description;
    public final TextView errorDescInterpunct;
    public final TextView errorText;
    public final LinearLayout itemMain;
    public final ImageView jobItemCellDivider;
    public final JobManagerPauseResumeButton pauseResumeButton;
    public final JobManagerProgressBar progressIndicator;
    public final ImageView retryIcon;
    private final LinearLayout rootView;
    public final TextView title;
    public final JobManagerTransferController transferController;

    private LayoutJobListItemBinding(LinearLayout linearLayout, ImageView imageView, TextView textView, TextView textView2, TextView textView3, LinearLayout linearLayout2, ImageView imageView2, JobManagerPauseResumeButton jobManagerPauseResumeButton, JobManagerProgressBar jobManagerProgressBar, ImageView imageView3, TextView textView4, JobManagerTransferController jobManagerTransferController) {
        this.rootView = linearLayout;
        this.cancelButton = imageView;
        this.description = textView;
        this.errorDescInterpunct = textView2;
        this.errorText = textView3;
        this.itemMain = linearLayout2;
        this.jobItemCellDivider = imageView2;
        this.pauseResumeButton = jobManagerPauseResumeButton;
        this.progressIndicator = jobManagerProgressBar;
        this.retryIcon = imageView3;
        this.title = textView4;
        this.transferController = jobManagerTransferController;
    }

    @Override // androidx.viewbinding.ViewBinding
    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static LayoutJobListItemBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static LayoutJobListItemBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.layout_job_list_item, viewGroup, false);
        if (z) {
            viewGroup.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static LayoutJobListItemBinding bind(View view) {
        int i = R.id.cancelButton;
        ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, i);
        if (imageView != null) {
            i = R.id.description;
            TextView textView = (TextView) ViewBindings.findChildViewById(view, i);
            if (textView != null) {
                i = R.id.errorDescInterpunct;
                TextView textView2 = (TextView) ViewBindings.findChildViewById(view, i);
                if (textView2 != null) {
                    i = R.id.errorText;
                    TextView textView3 = (TextView) ViewBindings.findChildViewById(view, i);
                    if (textView3 != null) {
                        LinearLayout linearLayout = (LinearLayout) view;
                        i = R.id.jobItemCellDivider;
                        ImageView imageView2 = (ImageView) ViewBindings.findChildViewById(view, i);
                        if (imageView2 != null) {
                            i = R.id.pauseResumeButton;
                            JobManagerPauseResumeButton jobManagerPauseResumeButton = (JobManagerPauseResumeButton) ViewBindings.findChildViewById(view, i);
                            if (jobManagerPauseResumeButton != null) {
                                i = R.id.progressIndicator;
                                JobManagerProgressBar jobManagerProgressBar = (JobManagerProgressBar) ViewBindings.findChildViewById(view, i);
                                if (jobManagerProgressBar != null) {
                                    i = R.id.retryIcon;
                                    ImageView imageView3 = (ImageView) ViewBindings.findChildViewById(view, i);
                                    if (imageView3 != null) {
                                        i = R.id.title;
                                        TextView textView4 = (TextView) ViewBindings.findChildViewById(view, i);
                                        if (textView4 != null) {
                                            i = R.id.transferController;
                                            JobManagerTransferController jobManagerTransferController = (JobManagerTransferController) ViewBindings.findChildViewById(view, i);
                                            if (jobManagerTransferController != null) {
                                                return new LayoutJobListItemBinding(linearLayout, imageView, textView, textView2, textView3, linearLayout, imageView2, jobManagerPauseResumeButton, jobManagerProgressBar, imageView3, textView4, jobManagerTransferController);
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
