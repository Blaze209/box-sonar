package external.sdk.pendo.io.yoyo.flippers;

import android.animation.ObjectAnimator;
import android.view.View;
import external.sdk.pendo.io.yoyo.BaseViewAnimator;

/* JADX INFO: loaded from: classes4.dex */
public class FlipInXAnimator extends BaseViewAnimator {
    @Override // external.sdk.pendo.io.yoyo.BaseViewAnimator
    public void prepare(View view) {
        getAnimatorAgent().playTogether(ObjectAnimator.ofFloat(view, "rotationX", 90.0f, -15.0f, 15.0f, 0.0f), ObjectAnimator.ofFloat(view, "alpha", 0.25f, 0.5f, 0.75f, 1.0f));
    }
}
