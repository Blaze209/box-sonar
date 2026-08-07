package external.sdk.pendo.io.yoyo.zooming_entrances;

import android.animation.ObjectAnimator;
import android.view.View;
import android.view.ViewGroup;
import external.sdk.pendo.io.yoyo.BaseViewAnimator;

/* JADX INFO: loaded from: classes4.dex */
public class ZoomInAnimator extends BaseViewAnimator {
    @Override // external.sdk.pendo.io.yoyo.BaseViewAnimator
    public void prepare(View view) {
        view.setPivotX(((ViewGroup) view.getParent()).getMeasuredWidth() / 2.0f);
        view.setPivotY(((ViewGroup) view.getParent()).getMeasuredHeight() / 2.0f);
        getAnimatorAgent().playTogether(ObjectAnimator.ofFloat(view, "scaleX", 0.4f, 0.6f, 1.0f), ObjectAnimator.ofFloat(view, "scaleY", 0.4f, 0.6f, 1.0f), ObjectAnimator.ofFloat(view, "alpha", 0.0f, 1.0f, 1.0f));
    }
}
