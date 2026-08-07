package external.sdk.pendo.io.yoyo.attention;

import android.animation.ObjectAnimator;
import android.view.View;
import external.sdk.pendo.io.yoyo.BaseViewAnimator;

/* JADX INFO: loaded from: classes4.dex */
public class SwingAnimator extends BaseViewAnimator {
    @Override // external.sdk.pendo.io.yoyo.BaseViewAnimator
    public void prepare(View view) {
        getAnimatorAgent().playTogether(ObjectAnimator.ofFloat(view, "rotation", 0.0f, 10.0f, -10.0f, 6.0f, -6.0f, 3.0f, -3.0f, 0.0f));
    }
}
