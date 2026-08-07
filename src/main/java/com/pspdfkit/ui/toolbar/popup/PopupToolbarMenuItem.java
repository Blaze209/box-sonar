package com.pspdfkit.ui.toolbar.popup;

import android.graphics.drawable.Drawable;

/* JADX INFO: loaded from: classes3.dex */
public class PopupToolbarMenuItem {
    private Drawable iconDrawable;
    private int iconRes;
    private final int id;
    private boolean isEnabled;
    private int tintColor;
    private final int title;

    public PopupToolbarMenuItem(int i, int i2) {
        this.isEnabled = true;
        this.id = i;
        this.title = i2;
    }

    public Drawable getIconDrawable() {
        return this.iconDrawable;
    }

    public int getIconRes() {
        return this.iconRes;
    }

    public int getId() {
        return this.id;
    }

    public int getTintColor() {
        return this.tintColor;
    }

    public int getTitle() {
        return this.title;
    }

    public boolean isEnabled() {
        return this.isEnabled;
    }

    public void setEnabled(boolean z) {
        this.isEnabled = z;
    }

    public void setIconDrawable(Drawable drawable) {
        this.iconDrawable = drawable;
    }

    public void setIconRes(int i) {
        this.iconRes = i;
    }

    public void setTintColor(int i) {
        this.tintColor = i;
    }

    public PopupToolbarMenuItem(int i, int i2, boolean z) {
        this.id = i;
        this.title = i2;
        this.isEnabled = z;
    }

    public PopupToolbarMenuItem(int i, int i2, int i3, boolean z) {
        this.id = i;
        this.title = i2;
        this.iconRes = i3;
        this.isEnabled = z;
    }
}
