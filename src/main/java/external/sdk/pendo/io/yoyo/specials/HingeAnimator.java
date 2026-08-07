package external.sdk.pendo.io.yoyo.specials;

import android.animation.ObjectAnimator;
import android.view.View;
import external.sdk.pendo.io.daimajia.Glider;
import external.sdk.pendo.io.daimajia.Skill;
import external.sdk.pendo.io.yoyo.BaseViewAnimator;

/* JADX INFO: loaded from: classes4.dex */
public class HingeAnimator extends BaseViewAnimator {
    @Override // external.sdk.pendo.io.yoyo.BaseViewAnimator
    public void prepare(View view) {
        float paddingLeft = view.getPaddingLeft();
        float paddingTop = view.getPaddingTop();
        getAnimatorAgent().playTogether(Glider.glide(Skill.SineEaseInOut, 1300.0f, ObjectAnimator.ofFloat(view, "rotation", 0.0f, 80.0f, 60.0f, 80.0f, 60.0f, 60.0f)), ObjectAnimator.ofFloat(view, "translationY", 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 700.0f), ObjectAnimator.ofFloat(view, "alpha", 1.0f, 1.0f, 1.0f, 1.0f, 1.0f, 0.0f), ObjectAnimator.ofFloat(view, "pivotX", paddingLeft, paddingLeft, paddingLeft, paddingLeft, paddingLeft, paddingLeft), ObjectAnimator.ofFloat(view, "pivotY", paddingTop, paddingTop, paddingTop, paddingTop, paddingTop, paddingTop));
        setDuration(1300L);
    }
}
