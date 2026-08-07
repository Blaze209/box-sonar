package com.pspdfkit.internal;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import androidx.appcompat.content.res.AppCompatResources;

/* JADX INFO: loaded from: classes3.dex */
public final class c70 extends Drawable {
    public final Drawable a;
    public final Drawable b;

    public c70(Context context, boolean z, boolean z2, int i, int i2) {
        Drawable drawable;
        Drawable drawable2;
        if (z && (drawable2 = AppCompatResources.getDrawable(context, i)) != null) {
            this.a = drawable2.mutate();
        }
        if (!z2 || (drawable = AppCompatResources.getDrawable(context, i2)) == null) {
            return;
        }
        this.b = drawable.mutate();
    }

    @Override // android.graphics.drawable.Drawable
    public final void draw(Canvas canvas) {
        Drawable drawable = this.a;
        if (drawable == null || this.b == null) {
            return;
        }
        drawable.draw(canvas);
        this.b.draw(canvas);
    }

    @Override // android.graphics.drawable.Drawable
    public final int getIntrinsicHeight() {
        Drawable drawable = this.a;
        if (drawable == null) {
            Drawable drawable2 = this.b;
            return drawable2 != null ? drawable2.getIntrinsicHeight() : super.getIntrinsicHeight();
        }
        int intrinsicHeight = drawable.getIntrinsicHeight();
        Drawable drawable3 = this.b;
        return intrinsicHeight + (drawable3 != null ? drawable3.getIntrinsicHeight() / 4 : 0);
    }

    @Override // android.graphics.drawable.Drawable
    public final int getIntrinsicWidth() {
        Drawable drawable = this.a;
        if (drawable == null) {
            Drawable drawable2 = this.b;
            return drawable2 != null ? drawable2.getIntrinsicWidth() : super.getIntrinsicWidth();
        }
        int intrinsicWidth = drawable.getIntrinsicWidth();
        Drawable drawable3 = this.b;
        return intrinsicWidth + (drawable3 != null ? drawable3.getIntrinsicWidth() / 4 : 0);
    }

    @Override // android.graphics.drawable.Drawable
    public final int getOpacity() {
        return -3;
    }

    @Override // android.graphics.drawable.Drawable
    public final void setAlpha(int i) {
    }

    @Override // android.graphics.drawable.Drawable
    public final void setBounds(int i, int i2, int i3, int i4) {
        super.setBounds(i, i2, i3, i4);
        Drawable drawable = this.a;
        if (drawable != null && this.b != null) {
            drawable.setBounds(i, i2, drawable.getIntrinsicWidth() + i, this.a.getIntrinsicHeight() + i2);
            Drawable drawable2 = this.b;
            drawable2.setBounds(i3 - (drawable2.getIntrinsicWidth() / 2), i4 - (this.b.getIntrinsicHeight() / 2), i3, i4);
        } else {
            if (drawable != null) {
                drawable.setBounds(i, i2, i3, i4);
                return;
            }
            Drawable drawable3 = this.b;
            if (drawable3 != null) {
                drawable3.setBounds(i, i2, i3, i4);
            }
        }
    }

    @Override // android.graphics.drawable.Drawable
    public final void setColorFilter(ColorFilter colorFilter) {
        Drawable drawable = this.a;
        if (drawable != null) {
            drawable.setColorFilter(colorFilter);
        }
        Drawable drawable2 = this.b;
        if (drawable2 != null) {
            drawable2.setColorFilter(colorFilter);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public final void setTint(int i) {
        Drawable drawable = this.a;
        if (drawable != null) {
            drawable.setTint(i);
        }
        Drawable drawable2 = this.b;
        if (drawable2 != null) {
            drawable2.setTint(i);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public final void setTintList(ColorStateList colorStateList) {
        Drawable drawable = this.a;
        if (drawable != null) {
            drawable.setTintList(colorStateList);
        }
        Drawable drawable2 = this.b;
        if (drawable2 != null) {
            drawable2.setTintList(colorStateList);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public final void setTintMode(PorterDuff.Mode mode) {
        Drawable drawable = this.a;
        if (drawable != null) {
            drawable.setTintMode(mode);
        }
        Drawable drawable2 = this.b;
        if (drawable2 != null) {
            drawable2.setTintMode(mode);
        }
    }
}
