package com.pspdfkit.internal;

import android.content.Context;
import android.graphics.Matrix;
import android.graphics.Rect;
import android.graphics.RectF;
import android.text.Editable;
import android.text.TextPaint;
import android.text.TextWatcher;
import android.text.method.KeyListener;
import android.view.View;
import android.view.ViewParent;
import androidx.appcompat.widget.AppCompatEditText;
import androidx.core.view.ViewCompat;
import java.util.WeakHashMap;

/* JADX INFO: loaded from: classes3.dex */
public abstract class f7 extends AppCompatEditText implements hn.d, TextWatcher, View.OnFocusChangeListener, nx {
    public a a;
    public final Matrix b;
    public final Runnable c;
    public final Matrix d;
    public hn.c e;
    public int f;
    public boolean g;
    public boolean h;
    public KeyListener i;

    public interface a {
        void a(RectF rectF);

        int b();

        boolean c();
    }

    public static class b {
        public static long a = 0;
        public static int b = -1;
    }

    public f7(Context context) {
        super(context);
        this.b = new Matrix();
        this.c = new Runnable() { // from class: com.pspdfkit.internal.f7$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.k();
            }
        };
        this.d = new Matrix();
        ViewCompat.setBackground(this, null);
        setPadding(0, 0, 0, 0);
        setInputType(163841);
        setIncludeFontPadding(false);
        setSingleLine(false);
        setGravity(8388659);
        setTypeface(ar.c().b().getDefaultTypeface());
        setEnabled(false);
        TextPaint paint = getPaint();
        paint.setLinearText(true);
        paint.setSubpixelText(true);
    }

    private void setKeyboardResizeWindow(boolean z) {
        if (z) {
            this.f = hn.a(getContext(), 16);
        } else {
            hn.a(getContext(), this.f);
        }
    }

    public void a(Matrix matrix, float f) {
        this.b.set(matrix);
    }

    @Override // android.text.TextWatcher
    public final void afterTextChanged(Editable editable) {
    }

    @Override // android.text.TextWatcher
    public final void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }

    public void c() {
        if (this.g) {
            return;
        }
        this.g = true;
        this.h = false;
        a aVar = this.a;
        if (aVar != null) {
            int iB = aVar.b();
            b.a = System.currentTimeMillis();
            b.b = iB;
        }
        if (this.i != null && getKeyListener() == null) {
            setKeyListener(this.i);
        }
        this.i = null;
        setEnabled(true);
        setCursorVisible(true);
        requestFocus();
        Editable text = getText();
        if (text != null) {
            setSelection(text.length());
        }
        addTextChangedListener(this);
        WeakHashMap weakHashMap = hn.a;
        this.e = new hn.c(a80.a(this), this);
        setKeyboardVisible(true);
        setOnFocusChangeListener(this);
    }

    public abstract RectF getBoundingBox();

    public Matrix getPdfToViewMatrix() {
        return this.b;
    }

    public void j() {
        if (this.g) {
            this.g = false;
            this.h = false;
            a aVar = this.a;
            if ((aVar == null || !aVar.c()) && (hasFocus() || !(a80.a(this).getCurrentFocus() instanceof f7))) {
                setKeyboardVisible(false);
                setEnabled(false);
                clearFocus();
            } else {
                this.i = getKeyListener();
                setKeyListener(null);
                setCursorVisible(false);
            }
            setSelection(0);
            setOnFocusChangeListener(null);
            removeTextChangedListener(this);
            hn.c cVar = this.e;
            if (cVar != null) {
                cVar.b();
            }
        }
    }

    public final void k() {
        if (getLayout() == null || this.a == null) {
            return;
        }
        RectF boundingBox = getBoundingBox();
        getPdfToViewMatrix().mapRect(boundingBox);
        Rect rect = new Rect();
        getLineBounds(getLayout().getLineForOffset(getSelectionStart()), rect);
        rect.offset(-getScrollX(), -getScrollY());
        float lineHeight = getLineHeight();
        float fMax = Math.max(boundingBox.top, Math.min((boundingBox.top + rect.centerY()) - (lineHeight / 2.0f), boundingBox.bottom));
        float fMax2 = Math.max(boundingBox.top, Math.min(lineHeight + fMax, boundingBox.bottom));
        boundingBox.top = fMax;
        boundingBox.bottom = fMax2;
        s60.a(boundingBox, getPdfToViewMatrix());
        this.a.a(boundingBox);
    }

    @Override // android.view.View.OnFocusChangeListener
    public void onFocusChange(View view, boolean z) {
        if (z) {
            if (this.h) {
                return;
            }
            setKeyboardVisible(true);
            return;
        }
        this.h = false;
        a aVar = this.a;
        if (aVar == null || !aVar.c()) {
            if (hasFocus() || !(a80.a(this).getCurrentFocus() instanceof f7)) {
                setKeyboardVisible(false);
            }
        }
    }

    @Override // android.widget.TextView, android.view.View
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        ViewParent parent = getParent();
        if (parent instanceof dw) {
            dw dwVar = (dw) parent;
            dwVar.a(this.d);
            float zoomScale = dwVar.getZoomScale();
            if (getPdfToViewMatrix().equals(this.d)) {
                return;
            }
            a(this.d, zoomScale);
        }
    }

    @Override // android.widget.TextView, android.text.TextWatcher
    public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        if (this.a != null) {
            charSequence.toString();
        }
        k();
    }

    @Override // android.widget.TextView, android.view.View
    public final void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        if (!z) {
            onFocusChange(this, false);
        } else {
            if (!hasFocus() || this.h) {
                return;
            }
            onFocusChange(this, true);
        }
    }

    @Override // com.pspdfkit.internal.nx
    public void recycle() {
        this.a = null;
        j();
        this.f = 0;
    }

    public void setEditTextViewListener(a aVar) {
        this.a = aVar;
    }

    public void setKeyboardVisible(boolean z) {
        if (z) {
            setKeyboardResizeWindow(true);
            hn.a(this, this);
        } else {
            setKeyboardResizeWindow(false);
            hn.c(this);
        }
    }

    @Override // com.pspdfkit.internal.hn.d
    public final void a(boolean z) {
        if (!z) {
            if (this.g) {
                this.h = true;
            }
        } else {
            this.h = false;
            if (isAttachedToWindow()) {
                removeCallbacks(this.c);
                postDelayed(this.c, 100L);
            }
        }
    }
}
