package external.sdk.pendo.io.yoyo.sliders;

import android.animation.ObjectAnimator;
import android.view.View;
import android.view.ViewGroup;
import external.sdk.pendo.io.yoyo.BaseViewAnimator;

/* JADX INFO: loaded from: classes4.dex */
public class SlideOutDownAnimator extends BaseViewAnimator {
    @Override // external.sdk.pendo.io.yoyo.BaseViewAnimator
    public void prepare(View view) {
        getAnimatorAgent().playTogether(ObjectAnimator.ofFloat(view, "alpha", 1.0f, 0.0f), ObjectAnimator.ofFloat(view, "translationY", 0.0f, ((ViewGroup) view.getParent()).getHeight() - view.getTop()));
    }
}
