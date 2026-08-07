package com.box.android.base.presentation.views.jobmanager;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.ProgressBar;
import com.box.android.base.R;
import com.box.android.coreservices.jobmanager.JobItem;
import com.box.android.coreservices.jobmanager.dao.ProgressReporter;

/* JADX INFO: loaded from: classes9.dex */
public class JobManagerProgressBar extends ProgressBar {
    private Drawable inProgressOrCompletedDrawable;
    private Drawable queuedDrawable;
    private boolean wasIndeterminate;

    public JobManagerProgressBar(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.inProgressOrCompletedDrawable = context.getResources().getDrawable(R.drawable.job_manager_progress_animation, context.getTheme()).mutate();
        this.queuedDrawable = context.getResources().getDrawable(R.drawable.job_manager_queued_animation).mutate();
    }

    public void onBind(ProgressReporter progressReporter) {
        int max = (int) progressReporter.getMax(ProgressReporter.ProgressType.PERCENTAGE);
        boolean z = ((long) ((int) progressReporter.getProgress(ProgressReporter.ProgressType.PERCENTAGE))) == -4;
        setIndeterminate(z);
        if (this.wasIndeterminate != z) {
            this.wasIndeterminate = z;
        }
        if (z) {
            return;
        }
        setMax(max);
        JobItem jobItem = (JobItem) progressReporter;
        if (jobItem.getCurrentState() == JobItem.JobItemState.QUEUED) {
            setProgressDrawable(this.queuedDrawable);
        } else {
            setProgressDrawable(this.inProgressOrCompletedDrawable);
        }
        if (jobItem.isSuccessfullyCompleted()) {
            setProgress(0);
        } else {
            setProgress((int) progressReporter.getProgress(ProgressReporter.ProgressType.PERCENTAGE));
        }
    }
}
