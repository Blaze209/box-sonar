package sdk.pendo.io.t5;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.util.Property;
import android.view.View;
import android.view.animation.AnticipateInterpolator;
import android.view.animation.OvershootInterpolator;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes5.dex */
public final class a {
    public static AnimatorSet a(View view, int i) {
        return a(view, i, 600L);
    }

    public static AnimatorSet b(View view, int i) {
        return b(view, i, 400L);
    }

    public static AnimatorSet a(View view, int i, long j) {
        View viewFindViewById = i != -1 ? view.findViewById(i) : view;
        viewFindViewById.setScaleX(0.0f);
        viewFindViewById.setScaleY(0.0f);
        viewFindViewById.setVisibility(0);
        AnimatorSet animatorSet = new AnimatorSet();
        ArrayList arrayList = new ArrayList();
        arrayList.add(ObjectAnimator.ofFloat(viewFindViewById, (Property<View, Float>) View.SCALE_X, 1.0f));
        arrayList.add(ObjectAnimator.ofFloat(viewFindViewById, (Property<View, Float>) View.SCALE_Y, 1.0f));
        view.setAlpha(0.0f);
        arrayList.add(ObjectAnimator.ofFloat(view, (Property<View, Float>) View.ALPHA, 1.0f));
        animatorSet.playTogether(arrayList);
        animatorSet.setInterpolator(new OvershootInterpolator());
        animatorSet.setDuration(j);
        return animatorSet;
    }

    public static AnimatorSet b(View view, int i, long j) {
        View viewFindViewById = i != -1 ? view.findViewById(i) : view;
        viewFindViewById.setScaleX(1.0f);
        viewFindViewById.setScaleY(1.0f);
        AnimatorSet animatorSet = new AnimatorSet();
        ArrayList arrayList = new ArrayList();
        arrayList.add(ObjectAnimator.ofFloat(viewFindViewById, (Property<View, Float>) View.SCALE_X, 0.0f));
        arrayList.add(ObjectAnimator.ofFloat(viewFindViewById, (Property<View, Float>) View.SCALE_Y, 0.0f));
        view.setAlpha(1.0f);
        arrayList.add(ObjectAnimator.ofFloat(view, (Property<View, Float>) View.ALPHA, 0.0f));
        animatorSet.playTogether(arrayList);
        animatorSet.setInterpolator(new AnticipateInterpolator());
        animatorSet.setDuration(j);
        return animatorSet;
    }
}
