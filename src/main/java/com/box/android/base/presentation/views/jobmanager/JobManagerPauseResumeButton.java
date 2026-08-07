package com.box.android.base.presentation.views.jobmanager;

import android.content.Context;
import android.util.AttributeSet;
import androidx.appcompat.widget.AppCompatImageView;
import com.box.android.base.R;
import com.box.android.coreservices.jobmanager.ParentJobItem;

/* JADX INFO: loaded from: classes9.dex */
public class JobManagerPauseResumeButton extends AppCompatImageView {
    private ButtonState mCurrentState;

    public enum ButtonState {
        STOPPED,
        RESUMED,
        DISABLED
    }

    public JobManagerPauseResumeButton(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mCurrentState = null;
    }

    public void setDisabled() {
        if (this.mCurrentState != ButtonState.DISABLED) {
            setImageDrawable(null);
            this.mCurrentState = ButtonState.DISABLED;
        }
    }

    public boolean isDisabled() {
        return this.mCurrentState == ButtonState.DISABLED;
    }

    public ButtonState getCurrentState() {
        return this.mCurrentState;
    }

    public void updateState(ParentJobItem parentJobItem, boolean z) {
        if (parentJobItem.isPaused()) {
            if (parentJobItem.canRestart()) {
                if (this.mCurrentState != ButtonState.STOPPED) {
                    setImageResource(R.drawable.resume_icon);
                    this.mCurrentState = ButtonState.STOPPED;
                    return;
                }
                return;
            }
            setDisabled();
            return;
        }
        if (z && parentJobItem.canPause()) {
            if (this.mCurrentState != ButtonState.RESUMED) {
                setImageResource(R.drawable.stop_icon);
                this.mCurrentState = ButtonState.RESUMED;
                return;
            }
            return;
        }
        setDisabled();
    }
}
