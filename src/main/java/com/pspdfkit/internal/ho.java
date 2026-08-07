package com.pspdfkit.internal;

import android.content.Context;
import android.graphics.Paint;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.OvershootInterpolator;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import androidx.appcompat.content.res.AppCompatResources;
import com.pspdfkit.R;

/* JADX INFO: loaded from: classes3.dex */
public final class ho extends LinearLayout {
    public final ProgressBar a;
    public ProgressBar b;
    public Runnable c;

    public ho(Context context, Integer num, int i, boolean z, boolean z2) {
        super(context);
        setGravity(17);
        setOrientation(1);
        ProgressBar progressBar = (ProgressBar) View.inflate(getContext(), R.layout.pspdf__loading_view, this).findViewById(R.id.pspdf__loading_progress_bar);
        this.a = progressBar;
        if (num == null) {
            progressBar.setVisibility(8);
            setVisibility(8);
        } else if (!num.equals(Integer.MIN_VALUE)) {
            progressBar.setIndeterminateDrawable(AppCompatResources.getDrawable(getContext(), num.intValue()));
        }
        Paint paint = new Paint();
        paint.setColor(ff.a(i, z2, z));
        setBackgroundColor(paint.getColor());
    }

    public final void a(long j) {
        if (this.a.getVisibility() != 8) {
            removeCallbacks(this.c);
            Runnable runnable = new Runnable() { // from class: com.pspdfkit.internal.ho$$ExternalSyntheticLambda0
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.b();
                }
            };
            this.c = runnable;
            if (j == 0) {
                runnable.run();
            } else {
                postDelayed(runnable, j);
            }
        }
    }

    public final /* synthetic */ void b() {
        setVisibility(0);
    }

    public final void c() {
        if (this.b == null) {
            ProgressBar progressBar = (ProgressBar) LayoutInflater.from(getContext()).inflate(R.layout.pspdf__loading_view_progress, (ViewGroup) this, false);
            this.b = progressBar;
            addView(progressBar);
        }
        if (this.b != null) {
            this.a.animate().scaleX(0.0f).scaleY(0.0f).setInterpolator(new AccelerateDecelerateInterpolator());
            this.b.setVisibility(0);
            this.b.animate().scaleX(1.0f).setInterpolator(new OvershootInterpolator());
            setVisibility(0);
        }
    }

    public double getLoadingProgress() {
        if (this.b == null) {
            ProgressBar progressBar = (ProgressBar) LayoutInflater.from(getContext()).inflate(R.layout.pspdf__loading_view_progress, (ViewGroup) this, false);
            this.b = progressBar;
            addView(progressBar);
        }
        ProgressBar progressBar2 = this.b;
        if (progressBar2 != null) {
            return ((double) progressBar2.getProgress()) / 1000.0d;
        }
        return 1.0d;
    }

    public ProgressBar getProgressBar() {
        return this.b;
    }

    public ProgressBar getThrobber() {
        return this.a;
    }

    public void setLoadingProgress(double d) {
        if (this.b == null) {
            ProgressBar progressBar = (ProgressBar) LayoutInflater.from(getContext()).inflate(R.layout.pspdf__loading_view_progress, (ViewGroup) this, false);
            this.b = progressBar;
            addView(progressBar);
        }
        ProgressBar progressBar2 = this.b;
        if (progressBar2 != null) {
            progressBar2.setMax(1000);
            this.b.setProgress((int) (d * 1000.0d));
        }
    }

    public final void a() {
        if (this.b != null) {
            this.a.setScaleX(1.0f);
            this.a.setScaleY(1.0f);
            this.b.setScaleX(0.0f);
            this.b.setVisibility(8);
            if (this.a.getVisibility() != 8) {
                return;
            }
            setVisibility(8);
        }
    }
}
