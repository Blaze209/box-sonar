package com.pspdfkit.internal;

import android.content.Context;
import android.graphics.PorterDuff;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import androidx.appcompat.widget.TooltipCompat;
import androidx.core.content.ContextCompat;
import androidx.core.graphics.drawable.DrawableCompat;
import androidx.core.view.GravityCompat;
import com.google.android.material.navigation.NavigationBarView;
import com.pspdfkit.R;
import com.pspdfkit.ui.toolbar.popup.PopupToolbarMenuItem;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public final class sw extends LinearLayout {
    public final LinkedHashMap a;
    public final LinkedHashMap b;
    public final ImageButton c;
    public final ImageButton d;
    public a e;
    public boolean f;
    public final rw g;
    public final int h;
    public int i;

    public interface a {
        void onBackItemClicked();

        void onItemClicked(PopupToolbarMenuItem popupToolbarMenuItem);

        void onOverflowItemClicked();
    }

    public sw(Context context) {
        super(context);
        this.a = new LinkedHashMap();
        this.b = new LinkedHashMap();
        this.f = false;
        this.i = 0;
        View.inflate(context, R.layout.pspdf__overflow_menu_view, this);
        rw rwVar = new rw(context);
        this.g = rwVar;
        DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
        displayMetrics.getClass();
        this.h = (int) TypedValue.applyDimension(1, 48.0f, displayMetrics);
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setColor(rwVar.a);
        DisplayMetrics displayMetrics2 = context.getResources().getDisplayMetrics();
        displayMetrics2.getClass();
        gradientDrawable.setCornerRadius(TypedValue.applyDimension(1, 24.0f, displayMetrics2));
        setBackground(gradientDrawable);
        DisplayMetrics displayMetrics3 = context.getResources().getDisplayMetrics();
        displayMetrics3.getClass();
        int iApplyDimension = (int) TypedValue.applyDimension(1, 4.0f, displayMetrics3);
        setPadding(iApplyDimension, 0, iApplyDimension, 0);
        setGravity(16);
        setClipToPadding(false);
        ImageButton imageButton = new ImageButton(context, null, android.R.attr.borderlessButtonStyle);
        this.c = imageButton;
        imageButton.setId(R.id.pspdf__toolbar_more_items);
        imageButton.setContentDescription("More");
        imageButton.setLayoutParams(new LinearLayout.LayoutParams(-2, -1));
        Drawable drawable = ContextCompat.getDrawable(context, R.drawable.pspdf__ic_more);
        int i = rwVar.b;
        drawable.getClass();
        Drawable drawableWrap = DrawableCompat.wrap(drawable);
        drawableWrap.getClass();
        DrawableCompat.setTint(drawableWrap, i);
        imageButton.setImageDrawable(drawableWrap);
        imageButton.setOnClickListener(new View.OnClickListener() { // from class: com.pspdfkit.internal.sw$$ExternalSyntheticLambda2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.a(view);
            }
        });
        imageButton.setClickable(true);
        imageButton.setAdjustViewBounds(true);
        ImageButton imageButton2 = new ImageButton(context, null, android.R.attr.borderlessButtonStyle);
        this.d = imageButton2;
        imageButton2.setId(R.id.pspdf__toolbar_back_button);
        imageButton2.setContentDescription("Back");
        imageButton2.setLayoutParams(new LinearLayout.LayoutParams(-2, -2));
        Drawable drawable2 = ContextCompat.getDrawable(context, R.drawable.pspdf__ic_arrow_back);
        int i2 = rwVar.b;
        drawable2.getClass();
        Drawable drawableWrap2 = DrawableCompat.wrap(drawable2);
        drawableWrap2.getClass();
        DrawableCompat.setTint(drawableWrap2, i2);
        imageButton2.setImageDrawable(drawableWrap2);
        imageButton2.setOnClickListener(new View.OnClickListener() { // from class: com.pspdfkit.internal.sw$$ExternalSyntheticLambda3
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.b(view);
            }
        });
        imageButton2.setClickable(true);
        imageButton2.setAdjustViewBounds(true);
    }

    public final /* synthetic */ void a(View view) {
        a aVar = this.e;
        if (aVar != null) {
            aVar.onOverflowItemClicked();
        }
    }

    public final /* synthetic */ void b(View view) {
        a aVar = this.e;
        if (aVar != null) {
            aVar.onBackItemClicked();
        }
    }

    public final void c() {
        this.f = true;
        setOrientation(1);
        a(true);
        requestLayout();
        animate().alpha(1.0f).setDuration(100L);
    }

    public final void d() {
        if (this.f) {
            return;
        }
        animate().alpha(0.0f).setDuration(100L).withEndAction(new Runnable() { // from class: com.pspdfkit.internal.sw$$ExternalSyntheticLambda4
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.c();
            }
        });
    }

    public List<PopupToolbarMenuItem> getMenuItems() {
        return new ArrayList(this.a.keySet());
    }

    @Override // android.widget.LinearLayout, android.view.View
    public final void onMeasure(int i, int i2) {
        int iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(0, 0);
        if (this.i > 0) {
            int mode = View.MeasureSpec.getMode(i);
            int size = View.MeasureSpec.getSize(i);
            int i3 = this.i;
            if (mode == 0 || size > i3) {
                i = View.MeasureSpec.makeMeasureSpec(i3, Integer.MIN_VALUE);
            }
        }
        int mode2 = View.MeasureSpec.getMode(i);
        int size2 = View.MeasureSpec.getSize(i);
        if (mode2 == 0 && (size2 = this.i) <= 0) {
            size2 = Integer.MAX_VALUE;
        }
        int iMax = 0;
        int i4 = 0;
        int i5 = 0;
        for (Button button : this.a.values()) {
            button.setVisibility(0);
            button.measure(iMakeMeasureSpec, iMakeMeasureSpec);
            int measuredWidth = this.b.containsKey(button) ? this.h : button.getMeasuredWidth();
            i5 += measuredWidth;
            if (i5 <= size2) {
                i4 += measuredWidth;
                iMax++;
            }
        }
        if (iMax != this.a.size()) {
            this.c.measure(iMakeMeasureSpec, iMakeMeasureSpec);
            this.d.measure(iMakeMeasureSpec, iMakeMeasureSpec);
            if (Math.max(this.c.getMeasuredWidth(), this.d.getMeasuredWidth()) + i4 > size2) {
                iMax--;
            }
            iMax = Math.max(0, iMax);
        }
        int size3 = this.a.size();
        ImageButton imageButton = this.c;
        if (iMax == size3) {
            imageButton.setVisibility(8);
            this.d.setVisibility(8);
        } else {
            imageButton.measure(iMakeMeasureSpec, iMakeMeasureSpec);
            this.d.measure(iMakeMeasureSpec, iMakeMeasureSpec);
            Iterator it = this.a.values().iterator();
            int i6 = 0;
            while (it.hasNext()) {
                ((Button) it.next()).setVisibility(((i6 >= iMax || !this.f) && (i6 < iMax || this.f)) ? 0 : 8);
                i6++;
            }
            this.c.setVisibility(this.f ? 8 : 0);
            this.d.setVisibility(this.f ? 0 : 8);
        }
        if (this.f) {
            int measuredWidth2 = this.d.getVisibility() == 0 ? this.d.getMeasuredWidth() : 0;
            for (Button button2 : this.a.values()) {
                if (button2.getVisibility() == 0) {
                    measuredWidth2 = Math.max(measuredWidth2, button2.getMeasuredWidth());
                }
            }
            i = View.MeasureSpec.makeMeasureSpec(Math.min(measuredWidth2, size2), 1073741824);
        }
        super.onMeasure(i, i2);
    }

    public void setMaxWidthPx(int i) {
        this.i = i;
    }

    public void setMenuItems(List<PopupToolbarMenuItem> list) {
        this.f = false;
        this.a.clear();
        this.b.clear();
        removeAllViews();
        for (PopupToolbarMenuItem popupToolbarMenuItem : list) {
            Button buttonA = a(popupToolbarMenuItem);
            this.a.put(popupToolbarMenuItem, buttonA);
            addView(buttonA);
        }
        addView(this.c);
        addView(this.d);
        a(false);
    }

    public void setOnPopupToolbarViewItemClickedListener(a aVar) {
        this.e = aVar;
    }

    public final Button a(final PopupToolbarMenuItem popupToolbarMenuItem) {
        Button button = new Button(getContext(), null, android.R.attr.borderlessButtonStyle);
        button.setId(popupToolbarMenuItem.getId());
        String strA = no.a(getContext(), popupToolbarMenuItem.getTitle(), null);
        button.setText(strA);
        button.setEnabled(popupToolbarMenuItem.isEnabled());
        boolean zIsEnabled = popupToolbarMenuItem.isEnabled();
        rw rwVar = this.g;
        int tintColor = zIsEnabled ? rwVar.b : rwVar.c;
        if (popupToolbarMenuItem.getTintColor() != 0 && popupToolbarMenuItem.isEnabled()) {
            tintColor = popupToolbarMenuItem.getTintColor();
        }
        button.setTextColor(tintColor);
        button.setAllCaps(false);
        button.setTypeface(Typeface.DEFAULT);
        button.setTextSize(2, 14.0f);
        Drawable iconDrawable = popupToolbarMenuItem.getIconDrawable();
        if (iconDrawable == null && popupToolbarMenuItem.getIconRes() != 0) {
            iconDrawable = ContextCompat.getDrawable(getContext(), popupToolbarMenuItem.getIconRes());
        }
        if (iconDrawable != null) {
            Drawable drawableMutate = iconDrawable.mutate();
            if (popupToolbarMenuItem.getIconDrawable() == null) {
                drawableMutate.setColorFilter(tintColor, PorterDuff.Mode.SRC_IN);
            }
            if (drawableMutate.getIntrinsicWidth() > 0 && drawableMutate.getIntrinsicHeight() > 0) {
                button.setCompoundDrawablesRelativeWithIntrinsicBounds(drawableMutate, (Drawable) null, (Drawable) null, (Drawable) null);
            } else {
                int dimension = (int) getContext().getResources().getDimension(R.dimen.pspdf__popup_toolbar_icon_size);
                drawableMutate.setBounds(0, 0, dimension, dimension);
                button.setCompoundDrawablesRelative(drawableMutate, null, null, null);
            }
            button.setCompoundDrawablePadding((int) getContext().getResources().getDimension(R.dimen.pspdf__popup_toolbar_icon_padding));
            this.b.put(button, strA);
            button.setContentDescription(strA);
            TooltipCompat.setTooltipText(button, strA);
        }
        button.setOnClickListener(new View.OnClickListener() { // from class: com.pspdfkit.internal.sw$$ExternalSyntheticLambda1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.a(popupToolbarMenuItem, view);
            }
        });
        return button;
    }

    public final void b() {
        this.f = false;
        setOrientation(0);
        a(false);
        requestLayout();
        animate().alpha(1.0f).setDuration(100L);
    }

    public final /* synthetic */ void a(PopupToolbarMenuItem popupToolbarMenuItem, View view) {
        a aVar = this.e;
        if (aVar != null) {
            aVar.onItemClicked(popupToolbarMenuItem);
        }
    }

    public final void a() {
        if (this.f) {
            animate().alpha(0.0f).setDuration(100L).withEndAction(new Runnable() { // from class: com.pspdfkit.internal.sw$$ExternalSyntheticLambda0
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.b();
                }
            });
        }
    }

    public final void a(boolean z) {
        int i = z ? -1 : -2;
        int i2 = z ? NavigationBarView.ITEM_GRAVITY_START_CENTER : 17;
        for (Button button : this.a.values()) {
            boolean zContainsKey = this.b.containsKey(button);
            button.setGravity(i2);
            if (zContainsKey) {
                button.setText(z ? (CharSequence) this.b.get(button) : null);
            }
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) button.getLayoutParams();
            if (layoutParams != null) {
                layoutParams.width = (!zContainsKey || z) ? i : this.h;
                button.setLayoutParams(layoutParams);
            }
        }
        LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.d.getLayoutParams();
        if (layoutParams2 != null) {
            layoutParams2.width = -2;
            layoutParams2.gravity = z ? GravityCompat.START : 0;
            this.d.setLayoutParams(layoutParams2);
        }
        ViewGroup.LayoutParams layoutParams3 = getLayoutParams();
        if (layoutParams3 != null) {
            layoutParams3.width = -2;
            setLayoutParams(layoutParams3);
        }
    }
}
