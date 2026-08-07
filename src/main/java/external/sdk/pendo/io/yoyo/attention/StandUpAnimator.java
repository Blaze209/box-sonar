package external.sdk.pendo.io.yoyo.attention;

import android.animation.ObjectAnimator;
import android.view.View;
import external.sdk.pendo.io.yoyo.BaseViewAnimator;

/* JADX INFO: loaded from: classes4.dex */
public class StandUpAnimator extends BaseViewAnimator {
    @Override // external.sdk.pendo.io.yoyo.BaseViewAnimator
    public void prepare(View view) {
        float width = (((view.getWidth() - view.getPaddingLeft()) - view.getPaddingRight()) / 2) + view.getPaddingLeft();
        float height = view.getHeight() - view.getPaddingBottom();
        getAnimatorAgent().playTogether(ObjectAnimator.ofFloat(view, "pivotX", width, width, width, width, width), ObjectAnimator.ofFloat(view, "pivotY", height, height, height, height, height), ObjectAnimator.ofFloat(view, "rotationX", 55.0f, -30.0f, 15.0f, -15.0f, 0.0f));
    }
}
