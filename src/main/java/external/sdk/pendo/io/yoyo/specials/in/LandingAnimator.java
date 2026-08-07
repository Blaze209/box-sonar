package external.sdk.pendo.io.yoyo.specials.in;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.view.View;
import android.view.ViewGroup;
import external.sdk.pendo.io.daimajia.Glider;
import external.sdk.pendo.io.daimajia.Skill;
import external.sdk.pendo.io.yoyo.BaseViewAnimator;

/* JADX INFO: loaded from: classes4.dex */
public class LandingAnimator extends BaseViewAnimator {
    @Override // external.sdk.pendo.io.yoyo.BaseViewAnimator
    protected void prepare(View view) {
        view.setPivotX(((ViewGroup) view.getParent()).getMeasuredWidth() / 2.0f);
        view.setPivotY(((ViewGroup) view.getParent()).getMeasuredHeight() / 2.0f);
        AnimatorSet animatorAgent = getAnimatorAgent();
        Skill skill = Skill.QuintEaseOut;
        animatorAgent.playTogether(Glider.glide(skill, getDuration(), ObjectAnimator.ofFloat(view, "scaleX", 1.5f, 1.0f)), Glider.glide(skill, getDuration(), ObjectAnimator.ofFloat(view, "scaleY", 1.5f, 1.0f)), Glider.glide(skill, getDuration(), ObjectAnimator.ofFloat(view, "alpha", 0.0f, 1.0f)));
    }
}
