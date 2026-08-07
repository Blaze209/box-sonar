package external.sdk.pendo.io.yoyo.attention;

import android.animation.ObjectAnimator;
import android.view.View;
import external.sdk.pendo.io.yoyo.BaseViewAnimator;

/* JADX INFO: loaded from: classes4.dex */
public class WobbleAnimator extends BaseViewAnimator {
    @Override // external.sdk.pendo.io.yoyo.BaseViewAnimator
    public void prepare(View view) {
        float width = (float) (((double) view.getWidth()) / 100.0d);
        float f = width * 0.0f;
        getAnimatorAgent().playTogether(ObjectAnimator.ofFloat(view, "translationX", f, (-25.0f) * width, 20.0f * width, (-15.0f) * width, 10.0f * width, width * (-5.0f), f, 0.0f), ObjectAnimator.ofFloat(view, "rotation", 0.0f, -5.0f, 3.0f, -3.0f, 2.0f, -1.0f, 0.0f));
    }
}
