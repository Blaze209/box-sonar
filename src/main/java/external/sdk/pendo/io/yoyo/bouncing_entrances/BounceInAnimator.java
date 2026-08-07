package external.sdk.pendo.io.yoyo.bouncing_entrances;

import android.animation.ObjectAnimator;
import android.view.View;
import external.sdk.pendo.io.yoyo.BaseViewAnimator;

/* JADX INFO: loaded from: classes4.dex */
public class BounceInAnimator extends BaseViewAnimator {
    @Override // external.sdk.pendo.io.yoyo.BaseViewAnimator
    public void prepare(View view) {
        getAnimatorAgent().playTogether(ObjectAnimator.ofFloat(view, "alpha", 0.0f, 1.0f, 1.0f, 1.0f), ObjectAnimator.ofFloat(view, "scaleX", 0.3f, 1.05f, 0.9f, 1.0f), ObjectAnimator.ofFloat(view, "scaleY", 0.3f, 1.05f, 0.9f, 1.0f));
    }
}
