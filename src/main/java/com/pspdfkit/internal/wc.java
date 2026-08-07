package com.pspdfkit.internal;

import android.content.Context;
import android.graphics.Rect;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.ViewPropertyAnimator;
import android.view.animation.DecelerateInterpolator;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.core.view.ViewCompat;
import com.microsoft.intune.mam.client.widget.MAMTextView;
import com.pspdfkit.R;
import com.pspdfkit.ui.toolbar.ContextualToolbarMenuItem;

/* JADX INFO: loaded from: classes3.dex */
public class wc extends FrameLayout {
    public int a;
    public int b;
    public int c;
    public int d;
    public final TextView e;
    public String f;
    public final ContextualToolbarMenuItem g;
    public final ContextualToolbarMenuItem h;
    public final Rect i;
    public float j;
    public Runnable k;
    public final b l;

    public interface a {
        default int getBackButtonIcon() {
            return R.drawable.pspdf__ic_arrow_back;
        }

        default int getCloseButtonIcon() {
            return R.drawable.pspdf__ic_close;
        }

        int getCornerRadius();

        int getTitleColor();

        int getTitleHeight();

        int getTitleIconsColor();

        int getTitlePadding();

        int getTitleTextColor();

        int getTitleTextSize();
    }

    public class b extends FrameLayout {
        public b(Context context) {
            super(context);
        }

        @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
        public final void onLayout(boolean z, int i, int i2, int i3, int i4) {
            int measuredWidth;
            int measuredWidth2;
            int measuredWidth3;
            int i5;
            boolean zC = a80.c(getContext());
            int childCount = getChildCount();
            for (int i6 = 0; i6 < childCount; i6++) {
                View childAt = getChildAt(i6);
                wc wcVar = wc.this;
                if (childAt != wcVar.g) {
                    TextView textView = wcVar.e;
                    ContextualToolbarMenuItem contextualToolbarMenuItem = wcVar.h;
                    if (childAt == textView) {
                        measuredWidth3 = contextualToolbarMenuItem.getVisibility() == 0 ? wc.this.h.getMeasuredWidth() : 0;
                        if (wc.this.g.getVisibility() == 0) {
                            measuredWidth3 = wc.this.g.getMeasuredWidth() + measuredWidth3;
                        }
                        if (zC) {
                            i5 = i3;
                        } else {
                            measuredWidth2 = i3 - measuredWidth3;
                        }
                    } else {
                        if (childAt != contextualToolbarMenuItem) {
                            return;
                        }
                        if (zC) {
                            measuredWidth2 = contextualToolbarMenuItem.getMeasuredWidth();
                        } else {
                            measuredWidth = contextualToolbarMenuItem.getMeasuredWidth();
                            measuredWidth3 = i3 - measuredWidth;
                            i5 = i3;
                        }
                    }
                    i5 = measuredWidth2;
                    measuredWidth3 = 0;
                } else if (zC) {
                    measuredWidth = childAt.getMeasuredWidth();
                    measuredWidth3 = i3 - measuredWidth;
                    i5 = i3;
                } else {
                    measuredWidth2 = childAt.getMeasuredWidth();
                    i5 = measuredWidth2;
                    measuredWidth3 = 0;
                }
                childAt.layout(measuredWidth3, 0, i5, childAt.getMeasuredHeight());
            }
        }

        @Override // android.widget.FrameLayout, android.view.View
        public final void onMeasure(int i, int i2) {
            if (getVisibility() == 8) {
                setMeasuredDimension(0, 0);
                return;
            }
            int iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(wc.this.a, 1073741824);
            wc.this.h.measure(iMakeMeasureSpec, iMakeMeasureSpec);
            wc wcVar = wc.this;
            wcVar.i.set(0, 0, wcVar.h.getMeasuredWidth(), wc.this.h.getMeasuredHeight());
            wc wcVar2 = wc.this;
            ViewCompat.setClipBounds(wcVar2.h, wcVar2.i);
            wc.this.g.measure(iMakeMeasureSpec, iMakeMeasureSpec);
            wc wcVar3 = wc.this;
            wcVar3.i.set(0, 0, wcVar3.g.getMeasuredWidth(), wc.this.g.getMeasuredHeight());
            wc wcVar4 = wc.this;
            ViewCompat.setClipBounds(wcVar4.g, wcVar4.i);
            setMeasuredDimension(View.getDefaultSize(getSuggestedMinimumWidth(), i), View.MeasureSpec.makeMeasureSpec(wc.this.a, 1073741824));
            wc.this.e.measure(View.MeasureSpec.makeMeasureSpec((getMeasuredWidth() - (wc.this.g.getVisibility() == 0 ? wc.this.g.getMeasuredWidth() : 0)) - (wc.this.h.getVisibility() == 0 ? wc.this.h.getMeasuredWidth() : 0), 1073741824), iMakeMeasureSpec);
            wc.this.b();
            Runnable runnable = wc.this.k;
            if (runnable != null) {
                ViewCompat.postOnAnimation(this, runnable);
                wc.this.k = null;
            }
        }
    }

    public wc(Context context, a aVar) {
        super(context);
        this.i = new Rect();
        aVar = aVar == null ? new yq(context) : aVar;
        b bVar = new b(getContext());
        this.l = bVar;
        addView(bVar, new FrameLayout.LayoutParams(-1, -2));
        Drawable drawable = AppCompatResources.getDrawable(getContext(), aVar.getBackButtonIcon());
        Context context2 = getContext();
        int i = R.id.pspdf__toolbar_back_button;
        ContextualToolbarMenuItem.Position position = ContextualToolbarMenuItem.Position.START;
        ContextualToolbarMenuItem contextualToolbarMenuItemCreateSingleItem = ContextualToolbarMenuItem.createSingleItem(context2, i, drawable, "", 0, 0, position, false);
        this.g = contextualToolbarMenuItemCreateSingleItem;
        contextualToolbarMenuItemCreateSingleItem.setVisibility(8);
        bVar.addView(contextualToolbarMenuItemCreateSingleItem);
        MAMTextView mAMTextView = new MAMTextView(getContext());
        this.e = mAMTextView;
        mAMTextView.setId(R.id.pspdf__share_dialog_title);
        mAMTextView.setGravity(16);
        mAMTextView.setTextAlignment(5);
        bVar.addView(mAMTextView);
        ContextualToolbarMenuItem contextualToolbarMenuItemCreateSingleItem2 = ContextualToolbarMenuItem.createSingleItem(getContext(), R.id.pspdf__annotation_inspector_view_close, drawable, "", 0, 0, position, false);
        this.h = contextualToolbarMenuItemCreateSingleItem2;
        setCloseButtonVisible(false);
        bVar.addView(contextualToolbarMenuItemCreateSingleItem2);
        a(aVar);
    }

    public final void a(a aVar) {
        if (aVar == null) {
            return;
        }
        this.b = aVar.getTitleColor();
        this.a = aVar.getTitleHeight();
        this.j = aVar.getCornerRadius();
        int titlePadding = aVar.getTitlePadding();
        Drawable drawable = AppCompatResources.getDrawable(getContext(), aVar.getBackButtonIcon());
        if (drawable != null) {
            drawable.setAutoMirrored(true);
            this.g.setIcon(drawable);
        }
        this.g.setIconColor(aVar.getTitleIconsColor());
        this.g.setIconColorActivated(aVar.getTitleIconsColor());
        this.g.setMinimumHeight(this.a);
        this.g.setPadding(titlePadding, titlePadding, titlePadding, titlePadding);
        this.e.setPadding(titlePadding, 0, titlePadding, 0);
        this.e.setTextSize(0, aVar.getTitleTextSize());
        this.e.setTextColor(aVar.getTitleTextColor());
        Drawable drawable2 = AppCompatResources.getDrawable(getContext(), aVar.getCloseButtonIcon());
        if (drawable2 != null) {
            this.h.setIcon(drawable2);
        }
        this.h.setIconColor(aVar.getTitleIconsColor());
        this.h.setIconColorActivated(aVar.getTitleIconsColor());
        this.h.setMinimumHeight(this.a);
        this.h.setPadding(titlePadding, titlePadding, titlePadding, titlePadding);
    }

    public final void b() {
        if (getMeasuredWidth() == this.c) {
            return;
        }
        this.c = getMeasuredWidth();
        if (getResources().getDisplayMetrics().widthPixels > getMeasuredWidth()) {
            float f = this.j;
            if (f != 0.0f) {
                a80.a(this, this.b, new float[]{f, f, f, f, 0.0f, 0.0f, 0.0f, 0.0f});
                return;
            }
        }
        ViewCompat.setBackground(this, new ColorDrawable(this.b));
    }

    public ContextualToolbarMenuItem getBackButton() {
        return this.g;
    }

    public ContextualToolbarMenuItem getCloseButton() {
        return this.h;
    }

    public int getTitleHeight() {
        return this.a + this.d;
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    public final void onLayout(boolean z, int i, int i2, int i3, int i4) {
        for (int i5 = 0; i5 < getChildCount(); i5++) {
            View childAt = getChildAt(i5);
            if (childAt.getVisibility() != 8) {
                int i6 = this.d;
                childAt.layout(i, i6, i3, i6 + i4);
            }
        }
    }

    @Override // android.widget.FrameLayout, android.view.View
    public final void onMeasure(int i, int i2) {
        this.l.measure(i, i2);
        setMeasuredDimension(View.getDefaultSize(getSuggestedMinimumWidth(), i), View.MeasureSpec.makeMeasureSpec(this.l.getMeasuredHeight() + this.d, 1073741824));
    }

    public void setBackButtonColor(int i) {
        this.h.setIconColor(i);
        this.h.setIconColorActivated(i);
    }

    public void setBackButtonOnClickListener(View.OnClickListener onClickListener) {
        this.g.setOnClickListener(onClickListener);
    }

    public void setCloseButtonColor(int i) {
        this.h.setIconColor(i);
        this.h.setIconColorActivated(i);
    }

    public void setCloseButtonOnClickListener(View.OnClickListener onClickListener) {
        this.h.setOnClickListener(onClickListener);
    }

    public void setCloseButtonVisible(boolean z) {
        this.h.setVisibility(z ? 0 : 8);
    }

    public void setDetailTitle(String str) {
        this.f = this.e.getText().toString();
        setTitle(str);
    }

    public void setRoundedCornersRadius(float f) {
        this.j = f;
        b();
    }

    public void setTitle(String str) {
        this.e.setText(str);
    }

    public void setTitleColor(int i) {
        this.b = i;
        b();
    }

    public void setTitleTextColor(int i) {
        this.e.setTextColor(i);
    }

    public void setTopInset(int i) {
        this.d = i;
        requestLayout();
    }

    public void setTitle(int i) {
        this.e.setText(no.a(getContext(), i, this.e));
    }

    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public final void a(final boolean z, final boolean z2) {
        if (this.g.getWidth() == 0) {
            this.k = new Runnable() { // from class: com.pspdfkit.internal.wc$$ExternalSyntheticLambda1
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.a(z, z2);
                }
            };
            return;
        }
        this.g.animate().cancel();
        this.e.animate().cancel();
        boolean zC = a80.c(getContext());
        ContextualToolbarMenuItem contextualToolbarMenuItem = this.g;
        float f = 0.0f;
        if (!z2) {
            contextualToolbarMenuItem.setTranslationX(0.0f);
            this.g.setVisibility(z ? 0 : 8);
            TextView textView = this.e;
            if (z) {
                int width = this.g.getWidth();
                if (zC) {
                    width = -width;
                }
                f = width;
            }
            textView.setTranslationX(f);
            return;
        }
        if ((contextualToolbarMenuItem.getVisibility() == 0) == z) {
            return;
        }
        if (z) {
            this.g.setVisibility(0);
            ContextualToolbarMenuItem contextualToolbarMenuItem2 = this.g;
            int width2 = contextualToolbarMenuItem2.getWidth();
            if (!zC) {
                width2 = -width2;
            }
            contextualToolbarMenuItem2.setTranslationX(width2);
            this.g.animate().translationX(0.0f).setInterpolator(new DecelerateInterpolator()).setDuration(200L);
            this.e.setTranslationX(0.0f);
            ViewPropertyAnimator viewPropertyAnimatorAnimate = this.e.animate();
            int width3 = this.g.getWidth();
            if (zC) {
                width3 = -width3;
            }
            viewPropertyAnimatorAnimate.translationX(width3).setInterpolator(new DecelerateInterpolator()).setDuration(200L);
            return;
        }
        a(zC);
        TextView textView2 = this.e;
        int width4 = this.g.getWidth();
        if (zC) {
            width4 = -width4;
        }
        textView2.setTranslationX(width4);
        this.e.animate().translationX(0.0f).setInterpolator(new DecelerateInterpolator()).setDuration(200L);
    }

    public final void a(boolean z) {
        this.g.setTranslationX(0.0f);
        ViewPropertyAnimator viewPropertyAnimatorAnimate = this.g.animate();
        ContextualToolbarMenuItem contextualToolbarMenuItem = this.g;
        viewPropertyAnimatorAnimate.translationX(z ? contextualToolbarMenuItem.getWidth() : -contextualToolbarMenuItem.getWidth()).setInterpolator(new DecelerateInterpolator()).setDuration(200L).withEndAction(new Runnable() { // from class: com.pspdfkit.internal.wc$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.a();
            }
        });
    }

    public final /* synthetic */ void a() {
        this.g.setVisibility(8);
    }
}
