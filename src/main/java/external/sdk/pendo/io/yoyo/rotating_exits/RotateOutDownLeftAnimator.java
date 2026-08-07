package external.sdk.pendo.io.yoyo.rotating_exits;

import android.animation.ObjectAnimator;
import android.view.View;
import external.sdk.pendo.io.yoyo.BaseViewAnimator;

/* JADX INFO: loaded from: classes4.dex */
public class RotateOutDownLeftAnimator extends BaseViewAnimator {
    @Override // external.sdk.pendo.io.yoyo.BaseViewAnimator
    public void prepare(View view) {
        float paddingLeft = view.getPaddingLeft();
        float height = view.getHeight() - view.getPaddingBottom();
        getAnimatorAgent().playTogether(ObjectAnimator.ofFloat(view, "alpha", 1.0f, 0.0f), ObjectAnimator.ofFloat(view, "rotation", 0.0f, 90.0f), ObjectAnimator.ofFloat(view, "pivotX", paddingLeft, paddingLeft), ObjectAnimator.ofFloat(view, "pivotY", height, height));
    }
}
