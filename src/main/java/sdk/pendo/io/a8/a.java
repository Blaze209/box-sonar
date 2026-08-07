package sdk.pendo.io.a8;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.util.DisplayMetrics;
import android.util.Property;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.Interpolator;
import android.widget.FrameLayout;
import sdk.pendo.io.PendoInternal;
import sdk.pendo.io.views.listener.FloatingListenerButton;

/* JADX INFO: loaded from: classes4.dex */
public class a extends View {
    static final Interpolator c = new AccelerateInterpolator();
    private ViewGroup a;
    private FloatingListenerButton b;

    /* JADX INFO: renamed from: sdk.pendo.io.a8.a$a, reason: collision with other inner class name */
    class C0345a implements Animator.AnimatorListener {
        C0345a() {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            a.this.setVisibility(8);
            a aVar = a.this;
            aVar.a.removeView(aVar);
            FloatingListenerButton floatingListenerButton = a.this.b;
            if (floatingListenerButton != null) {
                floatingListenerButton.flashFinished();
            }
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(Animator animator) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
        }
    }

    public a(Context context) {
        super(context);
    }

    public a a(View view, FloatingListenerButton floatingListenerButton) {
        this.a = (ViewGroup) view;
        this.b = floatingListenerButton;
        DisplayMetrics displayMetrics = PendoInternal.o().getResources().getDisplayMetrics();
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(displayMetrics.widthPixels, displayMetrics.heightPixels);
        setAlpha(0.5f);
        setBackgroundColor(-1);
        this.a.addView(this, layoutParams);
        ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(this, (Property<a, Float>) View.ALPHA, 0.5f, 1.0f);
        ObjectAnimator objectAnimatorOfFloat2 = ObjectAnimator.ofFloat(this, (Property<a, Float>) View.ALPHA, 1.0f, 0.0f);
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.playSequentially(objectAnimatorOfFloat, objectAnimatorOfFloat2);
        animatorSet.setInterpolator(c);
        animatorSet.setDuration(50L);
        animatorSet.addListener(new C0345a());
        animatorSet.start();
        return this;
    }
}
