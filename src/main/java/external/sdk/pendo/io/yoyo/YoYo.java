package external.sdk.pendo.io.yoyo;

import android.animation.Animator;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Interpolator;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes4.dex */
public class YoYo {
    private static final long ANIMATION_DURATION = 1000;
    static final float CENTER_PIVOT = Float.MAX_VALUE;
    static final int INFINITE = -1;
    private static final long NO_DELAY = 0;
    private final BaseViewAnimator animator;
    private final List<Animator.AnimatorListener> callbacks;
    private final long delay;
    private final long duration;
    private final Interpolator interpolator;
    private final boolean pivotRelationToParent;
    private final float pivotX;
    private final float pivotY;
    private boolean repeat;
    private long repeatTimes;
    private final View target;

    public static final class AnimationComposer {
        private BaseViewAnimator animator;
        private List<Animator.AnimatorListener> callbacks;
        private long delay;
        private long duration;
        private Interpolator interpolator;
        private boolean pivotRelationToParent;
        private float pivotX;
        private float pivotY;
        private boolean repeat;
        private long repeatTimes;
        private View target;

        private AnimationComposer(BaseViewAnimator baseViewAnimator) {
            this.callbacks = new ArrayList();
            this.duration = 1000L;
            this.delay = 0L;
            this.repeat = false;
            this.repeatTimes = 0L;
            this.pivotX = Float.MAX_VALUE;
            this.pivotY = Float.MAX_VALUE;
            this.pivotRelationToParent = false;
            this.animator = baseViewAnimator;
        }

        public AnimationComposer delay(long j) {
            this.delay = j;
            return this;
        }

        public AnimationComposer duration(long j) {
            this.duration = j;
            return this;
        }

        public AnimationComposer interpolate(Interpolator interpolator) {
            this.interpolator = interpolator;
            return this;
        }

        public AnimationComposer onCancel(final AnimatorCallback animatorCallback) {
            this.callbacks.add(new EmptyAnimatorListener() { // from class: external.sdk.pendo.io.yoyo.YoYo.AnimationComposer.3
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super();
                }

                @Override // external.sdk.pendo.io.yoyo.YoYo.EmptyAnimatorListener, android.animation.Animator.AnimatorListener
                public void onAnimationCancel(Animator animator) {
                    animatorCallback.call(animator);
                }
            });
            return this;
        }

        public AnimationComposer onEnd(final AnimatorCallback animatorCallback) {
            this.callbacks.add(new EmptyAnimatorListener() { // from class: external.sdk.pendo.io.yoyo.YoYo.AnimationComposer.2
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super();
                }

                @Override // external.sdk.pendo.io.yoyo.YoYo.EmptyAnimatorListener, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    animatorCallback.call(animator);
                }
            });
            return this;
        }

        public AnimationComposer onRepeat(final AnimatorCallback animatorCallback) {
            this.callbacks.add(new EmptyAnimatorListener() { // from class: external.sdk.pendo.io.yoyo.YoYo.AnimationComposer.4
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super();
                }

                @Override // external.sdk.pendo.io.yoyo.YoYo.EmptyAnimatorListener, android.animation.Animator.AnimatorListener
                public void onAnimationRepeat(Animator animator) {
                    animatorCallback.call(animator);
                }
            });
            return this;
        }

        public AnimationComposer onStart(final AnimatorCallback animatorCallback) {
            this.callbacks.add(new EmptyAnimatorListener() { // from class: external.sdk.pendo.io.yoyo.YoYo.AnimationComposer.1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super();
                }

                @Override // external.sdk.pendo.io.yoyo.YoYo.EmptyAnimatorListener, android.animation.Animator.AnimatorListener
                public void onAnimationStart(Animator animator) {
                    animatorCallback.call(animator);
                }
            });
            return this;
        }

        public AnimationComposer pivot(float f, float f2) {
            this.pivotX = f;
            this.pivotY = f2;
            return this;
        }

        public AnimationComposer pivotRelationToParent(boolean z) {
            this.pivotRelationToParent = z;
            return this;
        }

        public AnimationComposer pivotX(float f) {
            this.pivotX = f;
            return this;
        }

        public AnimationComposer pivotY(float f) {
            this.pivotY = f;
            return this;
        }

        public YoYoString playOn(View view) {
            this.target = view;
            return new YoYoString(new YoYo(this).play(), this.target);
        }

        public AnimationComposer repeat(int i) {
            if (i < -1) {
                throw new RuntimeException("Can not be less than -1, -1 is infinite loop");
            }
            this.repeat = i != 0;
            this.repeatTimes = i;
            return this;
        }

        public AnimationComposer withListener(Animator.AnimatorListener animatorListener) {
            this.callbacks.add(animatorListener);
            return this;
        }

        private AnimationComposer(Techniques techniques) {
            this.callbacks = new ArrayList();
            this.duration = 1000L;
            this.delay = 0L;
            this.repeat = false;
            this.repeatTimes = 0L;
            this.pivotX = Float.MAX_VALUE;
            this.pivotY = Float.MAX_VALUE;
            this.pivotRelationToParent = false;
            this.animator = techniques.getAnimator();
        }
    }

    public interface AnimatorCallback {
        void call(Animator animator);
    }

    private static class EmptyAnimatorListener implements Animator.AnimatorListener {
        private EmptyAnimatorListener() {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(Animator animator) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
        }
    }

    public static final class YoYoString {
        private BaseViewAnimator animator;
        private View target;

        private YoYoString(BaseViewAnimator baseViewAnimator, View view) {
            this.target = view;
            this.animator = baseViewAnimator;
        }

        public boolean isRunning() {
            return this.animator.isRunning();
        }

        public boolean isStarted() {
            return this.animator.isStarted();
        }

        public void stop() {
            stop(true);
        }

        public void stop(boolean z) {
            this.animator.cancel();
            if (z) {
                this.animator.reset(this.target);
            }
        }
    }

    private YoYo(AnimationComposer animationComposer) {
        this.animator = animationComposer.animator;
        this.duration = animationComposer.duration;
        this.delay = animationComposer.delay;
        this.repeat = animationComposer.repeat;
        this.repeatTimes = animationComposer.repeatTimes;
        this.interpolator = animationComposer.interpolator;
        this.pivotX = animationComposer.pivotX;
        this.pivotY = animationComposer.pivotY;
        this.pivotRelationToParent = animationComposer.pivotRelationToParent;
        this.callbacks = animationComposer.callbacks;
        this.target = animationComposer.target;
    }

    private View getTargetWithRegardsToPivotRelationToParent() {
        return (!this.pivotRelationToParent || this.target.getParent() == null) ? this.target : (ViewGroup) this.target.getParent();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public BaseViewAnimator play() {
        this.animator.setTarget(this.target);
        float f = this.pivotX;
        if (f == Float.MAX_VALUE) {
            this.target.setPivotX(getTargetWithRegardsToPivotRelationToParent().getMeasuredWidth() / 2.0f);
        } else {
            this.target.setPivotX(f);
        }
        float f2 = this.pivotY;
        if (f2 == Float.MAX_VALUE) {
            this.target.setPivotY(getTargetWithRegardsToPivotRelationToParent().getMeasuredHeight() / 2.0f);
        } else {
            this.target.setPivotY(f2);
        }
        this.animator.setDuration(this.duration).setInterpolator(this.interpolator).setStartDelay(this.delay);
        if (!this.callbacks.isEmpty()) {
            Iterator<Animator.AnimatorListener> it = this.callbacks.iterator();
            while (it.hasNext()) {
                this.animator.addAnimatorListener(it.next());
            }
        }
        if (this.repeat) {
            this.animator.addAnimatorListener(new Animator.AnimatorListener() { // from class: external.sdk.pendo.io.yoyo.YoYo.1
                private long currentTimes = 0;

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationCancel(Animator animator) {
                    YoYo yoYo = YoYo.this;
                    yoYo.repeatTimes = 0L;
                    yoYo.repeat = false;
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    YoYo yoYo = YoYo.this;
                    if (yoYo.repeat) {
                        long j = yoYo.repeatTimes;
                        if (j == -1 || this.currentTimes < j) {
                            yoYo.animator.restart();
                        }
                    }
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationRepeat(Animator animator) {
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationStart(Animator animator) {
                    this.currentTimes++;
                }
            });
        }
        this.animator.animate();
        return this.animator;
    }

    public static AnimationComposer with(BaseViewAnimator baseViewAnimator) {
        return new AnimationComposer(baseViewAnimator);
    }

    public static AnimationComposer with(Techniques techniques) {
        return new AnimationComposer(techniques);
    }
}
