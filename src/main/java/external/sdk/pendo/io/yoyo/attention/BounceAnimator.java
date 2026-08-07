package external.sdk.pendo.io.yoyo.attention;

import android.animation.ObjectAnimator;
import android.view.View;
import external.sdk.pendo.io.yoyo.BaseViewAnimator;

/* JADX INFO: loaded from: classes4.dex */
public class BounceAnimator extends BaseViewAnimator {
    @Override // external.sdk.pendo.io.yoyo.BaseViewAnimator
    public void prepare(View view) {
        getAnimatorAgent().playTogether(ObjectAnimator.ofFloat(view, "translationY", 0.0f, 0.0f, -30.0f, 0.0f, -15.0f, 0.0f, 0.0f));
    }
}
