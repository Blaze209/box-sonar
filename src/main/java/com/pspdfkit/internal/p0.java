package com.pspdfkit.internal;

import android.view.View;
import android.view.animation.Animation;
import android.view.animation.TranslateAnimation;

/* JADX INFO: loaded from: classes3.dex */
public final class p0 {

    public class a implements Animation.AnimationListener {
        public final /* synthetic */ View a;

        public a(View view) {
            this.a = view;
        }

        @Override // android.view.animation.Animation.AnimationListener
        public final void onAnimationEnd(Animation animation) {
            this.a.setVisibility(8);
        }

        @Override // android.view.animation.Animation.AnimationListener
        public final void onAnimationRepeat(Animation animation) {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public final void onAnimationStart(Animation animation) {
        }
    }

    public static void a(View view, boolean z) {
        if (!z) {
            view.setVisibility(8);
            return;
        }
        TranslateAnimation translateAnimation = new TranslateAnimation(2, 0.0f, 2, 1.0f, 2, 0.0f, 2, 0.0f);
        translateAnimation.setDuration(300L);
        translateAnimation.setAnimationListener(new a(view));
        view.startAnimation(translateAnimation);
    }

    public static void b(View view, boolean z) {
        if (!z) {
            view.setVisibility(0);
            return;
        }
        TranslateAnimation translateAnimation = new TranslateAnimation(2, 1.0f, 2, 0.0f, 2, 0.0f, 2, 0.0f);
        translateAnimation.setDuration(300L);
        view.setVisibility(0);
        view.startAnimation(translateAnimation);
    }
}
