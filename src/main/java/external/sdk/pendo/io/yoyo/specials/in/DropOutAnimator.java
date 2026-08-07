package external.sdk.pendo.io.yoyo.specials.in;

import android.animation.ObjectAnimator;
import android.view.View;
import external.sdk.pendo.io.daimajia.Glider;
import external.sdk.pendo.io.daimajia.Skill;
import external.sdk.pendo.io.yoyo.BaseViewAnimator;

/* JADX INFO: loaded from: classes4.dex */
public class DropOutAnimator extends BaseViewAnimator {
    @Override // external.sdk.pendo.io.yoyo.BaseViewAnimator
    protected void prepare(View view) {
        getAnimatorAgent().playTogether(ObjectAnimator.ofFloat(view, "alpha", 0.0f, 1.0f), Glider.glide(Skill.BounceEaseOut, getDuration(), ObjectAnimator.ofFloat(view, "translationY", -(view.getTop() + view.getHeight()), 0.0f)));
    }
}
