package com.box.android.base.presentation.views.jobmanager;

import android.content.Context;
import android.os.AsyncTask;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import com.box.android.base.R;
import com.box.android.common.utilities.CommonBoxUtil;
import com.box.android.coreservices.jobmanager.JobItem;
import com.box.android.coreservices.jobmanager.ParentJobItem;
import com.microsoft.intune.mam.client.widget.MAMRelativeLayout;

/* JADX INFO: loaded from: classes9.dex */
public class JobManagerTransferController extends MAMRelativeLayout implements View.OnClickListener {
    private static final int COMPLETED_OR_QUEUED_PADDING_IN_DP = 15;
    private static final int IN_PROGRESS_PADDING_IN_DP = 10;
    private final int mCompletedOrQueuedPaddingInPx;
    private final int mInProgressPaddingInPx;
    private ParentJobItem mJobItem;
    private JobManagerPauseResumeButton mPauseResumeButton;
    private JobManagerProgressBar mProgressBar;
    private ImageView mRetryIcon;
    private boolean mSupportsPausingJobItems;

    public JobManagerTransferController(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mInProgressPaddingInPx = CommonBoxUtil.convertDpToPixel(10.0f, context);
        this.mCompletedOrQueuedPaddingInPx = CommonBoxUtil.convertDpToPixel(15.0f, context);
    }

    @Override // android.view.View
    protected void onFinishInflate() {
        super.onFinishInflate();
        this.mProgressBar = (JobManagerProgressBar) findViewById(R.id.progressIndicator);
        this.mRetryIcon = (ImageView) findViewById(R.id.retryIcon);
        this.mPauseResumeButton = (JobManagerPauseResumeButton) findViewById(R.id.pauseResumeButton);
        setOnClickListener(this);
    }

    /* JADX WARN: Type inference failed for: r3v5, types: [com.box.android.base.presentation.views.jobmanager.JobManagerTransferController$2] */
    /* JADX WARN: Type inference failed for: r3v8, types: [com.box.android.base.presentation.views.jobmanager.JobManagerTransferController$1] */
    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        ParentJobItem parentJobItem = this.mJobItem;
        if (parentJobItem == null) {
            return;
        }
        JobItem.JobItemState currentState = parentJobItem.getCurrentState();
        if (currentState == JobItem.JobItemState.COMPLETED) {
            if (this.mJobItem.hasError()) {
                new AsyncTask<Void, Void, Void>() { // from class: com.box.android.base.presentation.views.jobmanager.JobManagerTransferController.1
                    /* JADX INFO: Access modifiers changed from: protected */
                    @Override // android.os.AsyncTask
                    public Void doInBackground(Void... voidArr) {
                        JobManagerTransferController.this.mJobItem.restart(true);
                        return null;
                    }
                }.execute(new Void[0]);
            }
        } else {
            if (!this.mSupportsPausingJobItems || currentState == JobItem.JobItemState.QUEUED || this.mPauseResumeButton.isDisabled()) {
                return;
            }
            new AsyncTask<Void, Void, Void>() { // from class: com.box.android.base.presentation.views.jobmanager.JobManagerTransferController.2
                /* JADX INFO: Access modifiers changed from: protected */
                @Override // android.os.AsyncTask
                public Void doInBackground(Void... voidArr) {
                    if (JobManagerTransferController.this.mJobItem.isPaused()) {
                        JobManagerTransferController.this.mJobItem.restart(false);
                        return null;
                    }
                    JobManagerTransferController.this.mJobItem.pause();
                    return null;
                }

                /* JADX INFO: Access modifiers changed from: protected */
                @Override // android.os.AsyncTask
                public void onPostExecute(Void r2) {
                    JobManagerTransferController.this.mPauseResumeButton.updateState(JobManagerTransferController.this.mJobItem, JobManagerTransferController.this.mSupportsPausingJobItems);
                }
            }.execute(new Void[0]);
        }
    }

    public void onBind(ParentJobItem parentJobItem, boolean z) {
        this.mJobItem = parentJobItem;
        this.mSupportsPausingJobItems = z;
        JobItem.JobItemState currentState = parentJobItem.getCurrentState();
        boolean z2 = true;
        if (currentState == JobItem.JobItemState.COMPLETED) {
            if (this.mJobItem.hasError()) {
                this.mProgressBar.setVisibility(8);
                this.mRetryIcon.setVisibility(0);
                z2 = false;
            } else {
                this.mProgressBar.setVisibility(0);
                this.mRetryIcon.setVisibility(8);
            }
            this.mPauseResumeButton.setVisibility(8);
        } else {
            z2 = currentState == JobItem.JobItemState.QUEUED;
            this.mRetryIcon.setVisibility(8);
            this.mProgressBar.setVisibility(0);
            if (z && currentState != JobItem.JobItemState.QUEUED) {
                this.mPauseResumeButton.setVisibility(0);
                this.mPauseResumeButton.updateState(this.mJobItem, z);
            } else {
                this.mPauseResumeButton.setVisibility(8);
            }
            if (getPaddingBottom() != this.mInProgressPaddingInPx) {
                int i = this.mCompletedOrQueuedPaddingInPx;
                setPadding(i, i, i, i);
                requestLayout();
            }
        }
        if (z2) {
            int paddingBottom = getPaddingBottom();
            int i2 = this.mCompletedOrQueuedPaddingInPx;
            if (paddingBottom != i2) {
                setPadding(i2, i2, i2, i2);
                requestLayout();
            }
        } else {
            int paddingBottom2 = getPaddingBottom();
            int i3 = this.mInProgressPaddingInPx;
            if (paddingBottom2 != i3) {
                setPadding(i3, i3, i3, i3);
                requestLayout();
            }
        }
        this.mProgressBar.onBind(parentJobItem);
    }
}
