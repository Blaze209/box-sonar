package external.sdk.pendo.io.yoyo.zooming_exits;

import android.animation.ObjectAnimator;
import android.view.View;
import external.sdk.pendo.io.yoyo.BaseViewAnimator;

/* JADX INFO: loaded from: classes4.dex */
public class ZoomOutUpAnimator extends BaseViewAnimator {
    @Override // external.sdk.pendo.io.yoyo.BaseViewAnimator
    protected void prepare(View view) {
        getAnimatorAgent().playTogether(ObjectAnimator.ofFloat(view, "alpha", 1.0f, 1.0f, 0.0f), ObjectAnimator.ofFloat(view, "scaleX", 1.0f, 0.475f, 0.1f), ObjectAnimator.ofFloat(view, "scaleY", 1.0f, 0.475f, 0.1f), ObjectAnimator.ofFloat(view, "translationY", 0.0f, 60.0f, -view.getBottom()));
    }
}
