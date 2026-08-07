package com.pspdfkit.ui.toolbar.rx;

import android.view.ViewPropertyAnimator;
import android.view.animation.Interpolator;
import android.view.animation.LinearInterpolator;
import com.pspdfkit.ui.toolbar.ContextualToolbarSubMenu;
import io.reactivex.rxjava3.core.CompletableEmitter;
import io.reactivex.rxjava3.core.CompletableOnSubscribe;
import java.util.Objects;

/* JADX INFO: loaded from: classes3.dex */
public class TranslateSubmenuToolbarCompletableOnSubscribe implements CompletableOnSubscribe {
    private final long durationMs;
    private Interpolator interpolator;
    private final ContextualToolbarSubMenu submenuBar;
    private final int translateX;
    private final int translateY;

    public TranslateSubmenuToolbarCompletableOnSubscribe(ContextualToolbarSubMenu contextualToolbarSubMenu, int i, int i2, long j, Interpolator interpolator) {
        this.interpolator = new LinearInterpolator();
        this.submenuBar = contextualToolbarSubMenu;
        this.translateX = i;
        this.translateY = i2;
        this.durationMs = j;
        if (interpolator != null) {
            this.interpolator = interpolator;
        }
    }

    @Override // io.reactivex.rxjava3.core.CompletableOnSubscribe
    public void subscribe(final CompletableEmitter completableEmitter) throws Exception {
        ViewPropertyAnimator interpolator = this.submenuBar.animate().translationX(this.translateX).translationY(this.translateY).setDuration(this.durationMs).setInterpolator(this.interpolator);
        Objects.requireNonNull(completableEmitter);
        interpolator.withEndAction(new Runnable() { // from class: com.pspdfkit.ui.toolbar.rx.TranslateSubmenuToolbarCompletableOnSubscribe$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                completableEmitter.onComplete();
            }
        });
    }
}
