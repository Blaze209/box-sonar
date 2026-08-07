package external.sdk.pendo.io.yoyo.attention;

import android.animation.ObjectAnimator;
import android.view.View;
import external.sdk.pendo.io.yoyo.BaseViewAnimator;

/* JADX INFO: loaded from: classes4.dex */
public class RubberBandAnimator extends BaseViewAnimator {
    @Override // external.sdk.pendo.io.yoyo.BaseViewAnimator
    public void prepare(View view) {
        getAnimatorAgent().playTogether(ObjectAnimator.ofFloat(view, "scaleX", 1.0f, 1.25f, 0.75f, 1.15f, 1.0f), ObjectAnimator.ofFloat(view, "scaleY", 1.0f, 0.75f, 1.25f, 0.85f, 1.0f));
    }
}
