package com.pspdfkit.internal;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.MotionEvent;
import com.pspdfkit.R;

/* JADX INFO: loaded from: classes3.dex */
public final class ye extends com.pspdfkit.internal.ui.dialog.signatures.e {
    public final Paint p;
    public final String q;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ye(Context context) {
        super(context, null, 0);
        context.getClass();
        Paint paint = new Paint();
        this.p = paint;
        String strA = no.a(getContext(), R.string.pspdf__electronic_signature_clear_signature, this);
        strA.getClass();
        this.q = strA;
        setId(R.id.pspdf__electronic_signatures_draw_signature_canvas);
        uc.a(getResources(), R.dimen.pspdf__electronic_signature_dialog_width, R.dimen.pspdf__electronic_signature_dialog_height);
        paint.setAntiAlias(true);
        paint.setDither(true);
        paint.setColor(this.o.u);
        paint.setTextSize((int) TypedValue.applyDimension(2, 16.0f, context.getResources().getDisplayMetrics()));
        paint.setTextAlign(Paint.Align.CENTER);
    }

    @Override // com.pspdfkit.internal.ui.dialog.signatures.e
    public final void a(Paint paint) {
        paint.getClass();
        paint.setAntiAlias(true);
        paint.setDither(true);
        paint.setColor(this.o.x);
        Context context = getContext();
        context.getClass();
        paint.setTextSize((int) TypedValue.applyDimension(2, 16.0f, context.getResources().getDisplayMetrics()));
        paint.setTextAlign(Paint.Align.CENTER);
    }

    @Override // com.pspdfkit.internal.ui.dialog.signatures.e
    public final float b() {
        float height = getHeight();
        Context context = getContext();
        context.getClass();
        DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
        displayMetrics.getClass();
        return height - TypedValue.applyDimension(1, 1 + 18.0f, displayMetrics);
    }

    @Override // com.pspdfkit.internal.ui.dialog.signatures.e
    public final void d() {
        this.m = true;
    }

    @Override // com.pspdfkit.internal.ui.dialog.signatures.e
    public final void f() {
        this.m = false;
    }

    @Override // com.pspdfkit.internal.ui.dialog.signatures.e
    public int getSignHereStringRes() {
        return R.string.pspdf__electronic_signature_sign_here;
    }

    @Override // com.pspdfkit.internal.ui.dialog.signatures.e
    public final void a(MotionEvent motionEvent) {
        if (!this.m && motionEvent.getY() > a()) {
            c();
        } else {
            super.a(motionEvent);
        }
    }

    @Override // com.pspdfkit.internal.ui.dialog.signatures.e
    public final float a() {
        float height = getHeight();
        Context context = getContext();
        context.getClass();
        DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
        displayMetrics.getClass();
        float fApplyDimension = TypedValue.applyDimension(1, 18.0f, displayMetrics) * 2;
        Context context2 = getContext();
        context2.getClass();
        return height - (fApplyDimension + ((int) TypedValue.applyDimension(2, 16.0f, context2.getResources().getDisplayMetrics())));
    }

    @Override // com.pspdfkit.internal.ui.dialog.signatures.e
    public final void a(Canvas canvas) {
        canvas.drawText(this.q, getWidth() / 2, b(), this.p);
    }
}
