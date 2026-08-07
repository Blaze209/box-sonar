package external.sdk.pendo.io.yoyo;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.view.View;
import android.view.animation.Interpolator;
import androidx.core.view.ViewCompat;

/* JADX INFO: loaded from: classes4.dex */
public abstract class BaseViewAnimator {
    static final long DURATION = 1000;
    private long mDuration = 1000;
    private AnimatorSet mAnimatorSet = new AnimatorSet();

    BaseViewAnimator addAnimatorListener(Animator.AnimatorListener animatorListener) {
        this.mAnimatorSet.addListener(animatorListener);
        return this;
    }

    void animate() {
        start();
    }

    void cancel() {
        this.mAnimatorSet.cancel();
    }

    public AnimatorSet getAnimatorAgent() {
        return this.mAnimatorSet;
    }

    public long getDuration() {
        return this.mDuration;
    }

    public long getStartDelay() {
        return this.mAnimatorSet.getStartDelay();
    }

    boolean isRunning() {
        return this.mAnimatorSet.isRunning();
    }

    boolean isStarted() {
        return this.mAnimatorSet.isStarted();
    }

    protected abstract void prepare(View view);

    public void removeAllListener() {
        this.mAnimatorSet.removeAllListeners();
    }

    public void removeAnimatorListener(Animator.AnimatorListener animatorListener) {
        this.mAnimatorSet.removeListener(animatorListener);
    }

    public void reset(View view) {
        ViewCompat.setAlpha(view, 1.0f);
        ViewCompat.setScaleX(view, 1.0f);
        ViewCompat.setScaleY(view, 1.0f);
        ViewCompat.setTranslationX(view, 0.0f);
        ViewCompat.setTranslationY(view, 0.0f);
        ViewCompat.setRotation(view, 0.0f);
        ViewCompat.setRotationY(view, 0.0f);
        ViewCompat.setRotationX(view, 0.0f);
    }

    public void restart() {
        this.mAnimatorSet = this.mAnimatorSet.clone();
        start();
    }

    public BaseViewAnimator setDuration(long j) {
        this.mDuration = j;
        return this;
    }

    BaseViewAnimator setInterpolator(Interpolator interpolator) {
        this.mAnimatorSet.setInterpolator(interpolator);
        return this;
    }

    BaseViewAnimator setStartDelay(long j) {
        getAnimatorAgent().setStartDelay(j);
        return this;
    }

    public BaseViewAnimator setTarget(View view) {
        reset(view);
        prepare(view);
        return this;
    }

    public void start() {
        this.mAnimatorSet.setDuration(this.mDuration);
        this.mAnimatorSet.start();
    }
}
