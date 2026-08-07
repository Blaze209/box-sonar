package com.pspdfkit.internal;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.ViewStructure;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.core.content.ContextCompat;
import androidx.core.graphics.drawable.DrawableCompat;
import com.pspdfkit.R;
import com.pspdfkit.annotations.SoundAnnotation;
import com.pspdfkit.ui.overlay.OverlayLayoutParams;
import com.pspdfkit.utils.PageRect;
import com.pspdfkit.utils.Size;

/* JADX INFO: loaded from: classes3.dex */
public final class k30 extends AppCompatImageView implements z4<SoundAnnotation>, nx {
    public static final int[] k = R.styleable.pspdf__SoundAnnotationIcon;
    public static final int l = R.attr.pspdf__soundAnnotationIconStyle;
    public static final int m = R.style.PSPDFKit_SoundAnnotationIcon;
    public SoundAnnotation a;
    public final ft<SoundAnnotation> b;
    public final int c;
    public final int d;
    public final int e;
    public final int f;
    public final int g;
    public final i30 h;
    public a i;
    public boolean j;

    public enum a {
        IDLE,
        SELECTED,
        PLAYBACK,
        RECORDING
    }

    public k30(Context context) {
        super(context, null, 0);
        this.b = new ft<>(this);
        this.i = a.IDLE;
        this.j = false;
        this.c = context.getResources().getDimensionPixelSize(R.dimen.pspdf__sound_annotation_size);
        TypedArray typedArrayObtainStyledAttributes = context.getTheme().obtainStyledAttributes(null, k, l, m);
        this.d = typedArrayObtainStyledAttributes.getColor(R.styleable.pspdf__SoundAnnotationIcon_pspdf__iconColor, -16777216);
        int color = typedArrayObtainStyledAttributes.getColor(R.styleable.pspdf__SoundAnnotationIcon_pspdf__backgroundColor, -1);
        this.e = typedArrayObtainStyledAttributes.getColor(R.styleable.pspdf__SoundAnnotationIcon_pspdf__selectionColor, ContextCompat.getColor(context, R.color.pspdf__primaryContainerLight));
        this.f = typedArrayObtainStyledAttributes.getColor(R.styleable.pspdf__SoundAnnotationIcon_pspdf__playbackColor, ContextCompat.getColor(context, R.color.pspdf__primaryContainerLight));
        this.g = typedArrayObtainStyledAttributes.getColor(R.styleable.pspdf__SoundAnnotationIcon_pspdf__recordColor, ContextCompat.getColor(context, R.color.pspdf__errorContainerLight));
        typedArrayObtainStyledAttributes.recycle();
        i30 i30Var = new i30(context, color);
        this.h = i30Var;
        setImageDrawable(i30Var);
    }

    private void setState(a aVar) {
        if (this.i == aVar) {
            return;
        }
        this.i = aVar;
        int iOrdinal = aVar.ordinal();
        if (iOrdinal == 0) {
            i30 i30Var = this.h;
            i30Var.c.setColor(0);
            i30Var.invalidateSelf();
            return;
        }
        if (iOrdinal == 1) {
            i30 i30Var2 = this.h;
            i30Var2.c.setColor(this.e);
            i30Var2.invalidateSelf();
            return;
        }
        if (iOrdinal == 2) {
            i30 i30Var3 = this.h;
            i30Var3.c.setColor(this.f);
            i30Var3.invalidateSelf();
            return;
        }
        if (iOrdinal != 3) {
            return;
        }
        i30 i30Var4 = this.h;
        i30Var4.c.setColor(this.g);
        i30Var4.invalidateSelf();
    }

    @Override // com.pspdfkit.internal.z4
    public final View a() {
        return this;
    }

    @Override // com.pspdfkit.internal.z4
    public final void b() {
        uw.b(this.a != null, "Cannot update SoundAnnotationView if no annotation is set.");
        Drawable drawable = AppCompatResources.getDrawable(getContext(), ww.a(this.a));
        int i = this.d;
        drawable.getClass();
        Drawable drawableWrap = DrawableCompat.wrap(drawable);
        drawableWrap.getClass();
        DrawableCompat.setTint(drawableWrap, i);
        i30 i30Var = this.h;
        i30Var.d = drawableWrap;
        int i2 = (int) (i30Var.j - i30Var.f);
        int i3 = i30Var.h;
        int i4 = i30Var.i;
        drawableWrap.setBounds(i3 - i2, i4 - i2, i3 + i2, i4 + i2);
        i30Var.invalidateSelf();
        j30 soundAnnotationState = this.a.getInternal().getSoundAnnotationState();
        if (soundAnnotationState != null) {
            setSoundAnnotationState(soundAnnotationState);
        }
        setContentDescription(this.a.getContents());
    }

    @Override // com.pspdfkit.internal.z4
    public /* bridge */ /* synthetic */ l1 getContentScaler() {
        return super.getContentScaler();
    }

    @Override // com.pspdfkit.internal.z4
    public /* bridge */ /* synthetic */ PageRect getPageRect() {
        return super.getPageRect();
    }

    @Override // com.pspdfkit.internal.z4
    public final boolean i() {
        this.j = false;
        a aVar = this.i;
        if (aVar != a.PLAYBACK && aVar != a.RECORDING) {
            setState(a.IDLE);
        }
        return false;
    }

    @Override // com.pspdfkit.internal.z4
    public final void m() {
        this.j = true;
        a aVar = this.i;
        if (aVar == a.PLAYBACK || aVar == a.RECORDING) {
            return;
        }
        setState(a.SELECTED);
    }

    @Override // com.pspdfkit.internal.z4
    public final void n() {
        OverlayLayoutParams overlayLayoutParamsA = b5.a(this, true);
        float f = this.c;
        overlayLayoutParamsA.fixedScreenSize = new Size(f, f);
        setLayoutParams(overlayLayoutParamsA);
    }

    @Override // android.view.View
    public final void onProvideStructure(ViewStructure viewStructure) {
        super.onProvideStructure(viewStructure);
        SoundAnnotation soundAnnotation = this.a;
        if (soundAnnotation == null || soundAnnotation.getContents() == null) {
            return;
        }
        viewStructure.setText(this.a.getContents());
    }

    @Override // com.pspdfkit.internal.nx
    public final void recycle() {
        this.a = null;
        setState(a.IDLE);
        this.b.b.clear();
    }

    public void setSoundAnnotationState(j30 j30Var) {
        int iOrdinal = j30Var.ordinal();
        if (iOrdinal == 0) {
            setState(this.j ? a.SELECTED : a.IDLE);
            return;
        }
        if (iOrdinal == 1 || iOrdinal == 2) {
            setState(a.RECORDING);
        } else if (iOrdinal == 3 || iOrdinal == 4) {
            setState(a.PLAYBACK);
        }
    }

    /* JADX WARN: Type inference incomplete: some casts might be missing */
    @Override // com.pspdfkit.internal.z4
    public final void a(z4.a<SoundAnnotation> aVar) {
        this.b.b.a(aVar);
        if (this.a != null) {
            this.b.a();
        }
    }

    @Override // com.pspdfkit.internal.z4
    public SoundAnnotation getAnnotation() {
        return this.a;
    }

    @Override // com.pspdfkit.internal.z4
    public void setAnnotation(SoundAnnotation soundAnnotation) {
        if (soundAnnotation.equals(this.a)) {
            return;
        }
        this.a = soundAnnotation;
        n();
        b();
        this.b.a();
    }
}
