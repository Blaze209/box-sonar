package external.sdk.pendo.io.yoyo.sliders;

import android.animation.ObjectAnimator;
import android.view.View;
import android.view.ViewGroup;
import external.sdk.pendo.io.yoyo.BaseViewAnimator;

/* JADX INFO: loaded from: classes4.dex */
public class SlideInDownAnimator extends BaseViewAnimator {
    @Override // external.sdk.pendo.io.yoyo.BaseViewAnimator
    public void prepare(View view) {
        getAnimatorAgent().playTogether(ObjectAnimator.ofFloat(view, "alpha", 0.0f, 1.0f), ObjectAnimator.ofFloat(view, "translationY", -(view.getTop() + ((ViewGroup) view.getParent()).getHeight()), 0.0f));
    }
}
