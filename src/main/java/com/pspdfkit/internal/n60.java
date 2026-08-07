package com.pspdfkit.internal;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.RippleDrawable;
import android.graphics.drawable.TransitionDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.OvershootInterpolator;
import android.view.animation.ScaleAnimation;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.cardview.widget.CardView;
import androidx.core.content.ContextCompat;
import androidx.core.graphics.drawable.DrawableCompat;
import androidx.core.view.ViewCompat;
import androidx.core.widget.TextViewCompat;
import com.microsoft.intune.mam.client.widget.MAMRelativeLayout;
import com.pspdfkit.R;

/* JADX INFO: loaded from: classes3.dex */
public final class n60 extends MAMRelativeLayout {
    public static final /* synthetic */ int j = 0;
    public final ImageView a;
    public final View b;
    public final CardView c;
    public final TextView d;
    public final ImageView e;
    public final ImageView f;
    public final TransitionDrawable g;
    public final a h;
    public boolean i;

    public static class a {
        public final int a;
        public final int b;
        public final int c;

        public a(Context context) {
            TypedArray typedArrayObtainStyledAttributes = context.getTheme().obtainStyledAttributes(null, R.styleable.pspdf__ThumbnailGrid, R.attr.pspdf__thumbnailGridStyle, R.style.PSPDFKit_ThumbnailGrid);
            this.a = typedArrayObtainStyledAttributes.getColor(R.styleable.pspdf__ThumbnailGrid_pspdf__selectionCheckBackgroundColor, ContextCompat.getColor(context, R.color.pspdf__primaryLight));
            this.b = typedArrayObtainStyledAttributes.getColor(R.styleable.pspdf__ThumbnailGrid_pspdf__itemRippleBackgroundColor, ContextCompat.getColor(context, R.color.pspdf__inversePrimaryLight));
            this.c = typedArrayObtainStyledAttributes.getColor(R.styleable.pspdf__ThumbnailGrid_pspdf__itemSelectedBorderColor, f60.a(context, androidx.appcompat.R.attr.colorAccent));
            typedArrayObtainStyledAttributes.recycle();
        }
    }

    public n60(Context context) {
        super(context);
        this.i = false;
        LayoutInflater layoutInflaterFrom = LayoutInflater.from(context);
        a aVar = new a(context);
        this.h = aVar;
        View viewInflate = layoutInflaterFrom.inflate(R.layout.pspdf__thumbnail_grid_item_view, this);
        ImageView imageView = (ImageView) viewInflate.findViewById(R.id.pspdf__thumbnail_grid_item_highlight_bg);
        this.a = imageView;
        imageView.setImageTintList(ColorStateList.valueOf(aVar.c));
        this.b = viewInflate.findViewById(R.id.pspdf__thumbnail_grid_item_wrapper);
        CardView cardView = (CardView) viewInflate.findViewById(R.id.pspdf__thumbnail_grid_item_bg_card);
        this.c = cardView;
        cardView.setPreventCornerOverlap(false);
        TextView textView = (TextView) viewInflate.findViewById(R.id.pspdf__thumbnail_grid_item_label);
        this.d = textView;
        this.e = (ImageView) viewInflate.findViewById(R.id.pspdf__thumbnail_grid_item_content);
        ImageView imageView2 = (ImageView) viewInflate.findViewById(R.id.pspdf__thumbnail_grid_item_selected_ic);
        this.f = imageView2;
        Drawable drawableMutate = AppCompatResources.getDrawable(getContext(), R.drawable.pspdf__circle_shape).mutate();
        int i = aVar.a;
        drawableMutate.getClass();
        Drawable drawableWrap = DrawableCompat.wrap(drawableMutate);
        drawableWrap.getClass();
        DrawableCompat.setTint(drawableWrap, i);
        Drawable drawableMutate2 = AppCompatResources.getDrawable(getContext(), R.drawable.pspdf__circle_shape_transparent).mutate();
        int color = ContextCompat.getColor(getContext(), R.color.pspdf__outlineVariantLight);
        drawableMutate2.getClass();
        Drawable drawableWrap2 = DrawableCompat.wrap(drawableMutate2);
        drawableWrap2.getClass();
        DrawableCompat.setTint(drawableWrap2, color);
        TransitionDrawable transitionDrawable = new TransitionDrawable(new Drawable[]{drawableWrap2, drawableWrap});
        this.g = transitionDrawable;
        ViewCompat.setBackground(imageView2, transitionDrawable);
        cardView.setForeground(new RippleDrawable(new ColorStateList(new int[][]{new int[0]}, new int[]{aVar.b}), null, null));
        float elevation = cardView.getElevation();
        imageView2.setElevation(elevation);
        textView.setElevation(elevation);
    }

    public final void a(boolean z) {
        this.f.setVisibility(0);
        a(this.d, !z);
        ImageView imageView = this.f;
        if (z) {
            imageView.animate().alpha(1.0f).setDuration(150L).scaleX(1.0f).scaleY(1.0f).setInterpolator(new OvershootInterpolator(10.0f)).start();
        } else {
            a(imageView, false);
        }
    }

    public TextView getItemLabel() {
        return this.d;
    }

    public Drawable getThumbnailDrawable() {
        return this.e.getDrawable();
    }

    public ImageView getThumbnailView() {
        return this.e;
    }

    @Override // android.view.View
    public final boolean isActivated() {
        return this.b.isActivated();
    }

    @Override // android.widget.RelativeLayout, android.view.View, android.view.ViewParent
    public final void requestLayout() {
        if (this.i) {
            return;
        }
        super.requestLayout();
    }

    @Override // android.view.View
    public void setActivated(boolean z) {
        this.b.setActivated(z);
        TransitionDrawable transitionDrawable = this.g;
        if (z) {
            transitionDrawable.startTransition(150);
            this.b.animate().scaleX(0.85f).scaleY(0.85f).setDuration(150L).setInterpolator(new OvershootInterpolator(4.0f)).start();
        } else {
            transitionDrawable.reverseTransition(150);
            this.b.animate().scaleX(1.0f).scaleY(1.0f).setDuration(150L).setInterpolator(new DecelerateInterpolator(4.0f)).start();
        }
    }

    public void setHighlighted(boolean z) {
        this.a.setVisibility(z ? 0 : 4);
    }

    public void setItemLabelBackground(int i) {
        ViewCompat.setBackground(this.d, AppCompatResources.getDrawable(getContext(), i));
    }

    public void setItemLabelStyle(int i) {
        TextViewCompat.setTextAppearance(this.d, i);
    }

    public void setItemLabelText(String str) {
        this.d.setText(str);
    }

    public void setThumbnailDrawable(Drawable drawable) {
        this.i = true;
        this.e.setImageDrawable(drawable);
        this.i = false;
    }

    public static void a(View view, float f, float f2) {
        ScaleAnimation scaleAnimation = new ScaleAnimation(f, f2, f, f2, 1, 0.5f, 1, 0.5f);
        scaleAnimation.setDuration(100L);
        scaleAnimation.setInterpolator(new DecelerateInterpolator(3.0f));
        scaleAnimation.setFillAfter(true);
        view.startAnimation(scaleAnimation);
    }

    public static void a(View view, boolean z) {
        view.animate().alpha(z ? 1.0f : 0.0f).scaleX(z ? 1.0f : 0.6f).scaleY(z ? 1.0f : 0.6f).setDuration(150L).setInterpolator(z ? new DecelerateInterpolator(2.0f) : new AccelerateInterpolator(2.0f)).start();
    }
}
