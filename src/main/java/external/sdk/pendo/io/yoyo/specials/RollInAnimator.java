package external.sdk.pendo.io.yoyo.specials;

import android.animation.ObjectAnimator;
import android.view.View;
import external.sdk.pendo.io.yoyo.BaseViewAnimator;

/* JADX INFO: loaded from: classes4.dex */
public class RollInAnimator extends BaseViewAnimator {
    @Override // external.sdk.pendo.io.yoyo.BaseViewAnimator
    public void prepare(View view) {
        getAnimatorAgent().playTogether(ObjectAnimator.ofFloat(view, "alpha", 0.0f, 1.0f), ObjectAnimator.ofFloat(view, "translationX", -((view.getWidth() - view.getPaddingLeft()) - view.getPaddingRight()), 0.0f), ObjectAnimator.ofFloat(view, "rotation", -120.0f, 0.0f));
    }
}
