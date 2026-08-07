package external.sdk.pendo.io.yoyo.specials;

import android.animation.ObjectAnimator;
import android.view.View;
import external.sdk.pendo.io.yoyo.BaseViewAnimator;

/* JADX INFO: loaded from: classes4.dex */
public class RollOutAnimator extends BaseViewAnimator {
    @Override // external.sdk.pendo.io.yoyo.BaseViewAnimator
    public void prepare(View view) {
        getAnimatorAgent().playTogether(ObjectAnimator.ofFloat(view, "alpha", 1.0f, 0.0f), ObjectAnimator.ofFloat(view, "translationX", 0.0f, view.getWidth()), ObjectAnimator.ofFloat(view, "rotation", 0.0f, 120.0f));
    }
}
