package com.pspdfkit.internal;

import android.app.Activity;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.net.Uri;
import android.os.Parcelable;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.microsoft.intune.mam.client.widget.MAMTextView;
import com.pspdfkit.R;
import com.pspdfkit.document.image.BitmapUtils;
import com.pspdfkit.document.sharing.DocumentSharingProvider;
import com.pspdfkit.signatures.Signature;
import io.reactivex.rxjava3.core.Single;
import io.reactivex.rxjava3.functions.Action;
import io.reactivex.rxjava3.functions.Function;

/* JADX INFO: loaded from: classes3.dex */
public final class ak extends com.pspdfkit.internal.ui.dialog.signatures.e {
    public final Paint p;
    public final String q;
    public final ImageView r;
    public final zl s;
    public final FloatingActionButton t;
    public final TextView u;

    public static final class a<T, R> implements Function {
        public static final a<T, R> a = new a<>();

        @Override // io.reactivex.rxjava3.functions.Function
        public final Object apply(Object obj) {
            Bitmap bitmap = (Bitmap) obj;
            bitmap.getClass();
            return Single.just(Signature.Companion.createStampSignature$default(Signature.INSTANCE, bitmap, new RectF(0.0f, bitmap.getHeight(), bitmap.getWidth(), 0.0f), null, 0.0f, 12, null));
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ak(Context context) {
        super(context, null, 0);
        context.getClass();
        Paint paint = new Paint();
        this.p = paint;
        String strA = no.a(getContext(), R.string.pspdf__electronic_signature_replace_image, this);
        strA.getClass();
        this.q = strA;
        uc.a(getResources(), R.dimen.pspdf__electronic_signature_dialog_width, R.dimen.pspdf__electronic_signature_dialog_height);
        g20 g20Var = this.o;
        int i = g20Var.m;
        int i2 = g20Var.o;
        int i3 = g20Var.n;
        int i4 = g20Var.v;
        int i5 = g20Var.w;
        int iA = (int) un.a(context, 1, 56);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(iA, iA);
        layoutParams.alignWithParent = true;
        layoutParams.addRule(13);
        FloatingActionButton floatingActionButton = new FloatingActionButton(context);
        this.t = floatingActionButton;
        floatingActionButton.setId(R.id.pspdf__electronic_signatures_signature_fab_add_new_signature);
        floatingActionButton.setCompatElevation((int) un.a(context, 1, 4));
        floatingActionButton.setUseCompatPadding(true);
        floatingActionButton.setSize(0);
        floatingActionButton.setBackgroundTintList(ColorStateList.valueOf(i2));
        floatingActionButton.setImageResource(i);
        floatingActionButton.setColorFilter(i3);
        floatingActionButton.setClickable(true);
        floatingActionButton.setOnClickListener(new View.OnClickListener() { // from class: com.pspdfkit.internal.ak$$ExternalSyntheticLambda1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ak.a(this.f$0, view);
            }
        });
        addView(floatingActionButton, layoutParams);
        MAMTextView mAMTextView = new MAMTextView(context);
        this.u = mAMTextView;
        mAMTextView.setText(getResources().getString(R.string.pspdf__electronic_signature_select_image));
        mAMTextView.setTextSize(16.0f);
        mAMTextView.setTextColor(i4);
        mAMTextView.setTypeface(ar.c().b().getDefaultTypeface());
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams2.addRule(14);
        layoutParams2.addRule(3, floatingActionButton.getId());
        mAMTextView.setLayoutParams(layoutParams2);
        addView(mAMTextView);
        paint.setAntiAlias(true);
        paint.setDither(true);
        paint.setColor(i5);
        Paint.Align align = Paint.Align.CENTER;
        paint.setTextAlign(align);
        paint.setTextSize((int) TypedValue.applyDimension(2, 16.0f, context.getResources().getDisplayMetrics()));
        paint.setTextAlign(align);
        Context context2 = getContext();
        context2.getClass();
        Activity activityA = a80.a(context2);
        if (!(activityA instanceof FragmentActivity)) {
            throw new IllegalStateException("Can't retrieve fragment manager from view context.");
        }
        FragmentManager supportFragmentManager = ((FragmentActivity) activityA).getSupportFragmentManager();
        supportFragmentManager.getClass();
        this.s = new zl(supportFragmentManager);
        ImageView imageView = new ImageView(context);
        this.r = imageView;
        RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(-1, -1);
        layoutParams3.setMargins(0, 0, 0, (int) h());
        imageView.setLayoutParams(layoutParams3);
        addView(imageView);
    }

    @Override // com.pspdfkit.internal.ui.dialog.signatures.e
    public final void a(Paint paint) {
        paint.getClass();
        paint.setAntiAlias(true);
        paint.setDither(true);
        paint.setColor(this.o.v);
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
        return 0;
    }

    public final Single<Signature> getSignatureImage() {
        final Uri uri = this.n;
        if (uri == null) {
            Single<Signature> singleError = Single.error(new IllegalStateException("Can't import signature image: Signature URI is null."));
            singleError.getClass();
            return singleError;
        }
        Single<Signature> singleDoFinally = BitmapUtils.decodeBitmapAsync(getContext(), uri).flatMap(a.a).doFinally(new Action() { // from class: com.pspdfkit.internal.ak$$ExternalSyntheticLambda0
            @Override // io.reactivex.rxjava3.functions.Action
            public final void run() {
                ak.a(this.f$0, uri);
            }
        });
        singleDoFinally.getClass();
        return singleDoFinally;
    }

    public final Uri getSignatureUri() {
        return this.n;
    }

    public final float h() {
        Context context = getContext();
        context.getClass();
        DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
        displayMetrics.getClass();
        float fApplyDimension = TypedValue.applyDimension(1, 18.0f, displayMetrics) * 2;
        Context context2 = getContext();
        context2.getClass();
        return fApplyDimension + ((int) TypedValue.applyDimension(2, 16.0f, context2.getResources().getDisplayMetrics()));
    }

    @Override // com.pspdfkit.internal.ui.dialog.signatures.e, android.view.View
    public final void onDraw(Canvas canvas) {
        canvas.getClass();
        if (this.m) {
            return;
        }
        Context context = getContext();
        context.getClass();
        float fA = (int) un.a(context, 1, 12);
        float height = getHeight() - h();
        canvas.drawLine(fA, height, getWidth() - fA, height, this.a);
        canvas.drawText(this.q, getWidth() / 2, b(), this.p);
    }

    @Override // com.pspdfkit.internal.ui.dialog.signatures.e, android.view.View
    public final void onRestoreInstanceState(Parcelable parcelable) {
        super.onRestoreInstanceState(parcelable);
        Uri uri = this.n;
        if (uri != null) {
            this.r.setImageURI(uri);
        }
    }

    public final void setOnImagePickedListener(yl.c cVar) {
        zl zlVar = this.s;
        zlVar.b = cVar;
        yl ylVar = zlVar.c;
        if (ylVar != null) {
            ylVar.b = cVar;
            yl.a aVar = ylVar.c;
            if (aVar != null) {
                ylVar.a(aVar);
            }
        }
    }

    public final void setSignatureUri(Uri uri) {
        this.n = uri;
        this.r.setImageURI(uri);
        int i = uri != null ? 4 : 0;
        this.t.setVisibility(i);
        this.u.setVisibility(i);
    }

    public static final void a(ak akVar, View view) {
        akVar.s.a(akVar.getResources().getString(R.string.pspdf__electronic_signature_select_image));
    }

    @Override // com.pspdfkit.internal.ui.dialog.signatures.e
    public final void a(MotionEvent motionEvent) {
        if (this.m) {
            this.s.a(getResources().getString(R.string.pspdf__electronic_signature_select_image));
        }
        if (this.m || motionEvent.getY() <= getHeight() - h()) {
            return;
        }
        c();
        this.s.a(getResources().getString(R.string.pspdf__electronic_signature_select_image));
    }

    @Override // com.pspdfkit.internal.ui.dialog.signatures.e
    public final float a() {
        return getHeight() - h();
    }

    @Override // com.pspdfkit.internal.ui.dialog.signatures.e
    public final void a(Canvas canvas) {
        canvas.drawText(this.q, getWidth() / 2, b(), this.p);
    }

    public static final void a(ak akVar, Uri uri) {
        int i = yl.k;
        Context context = akVar.getContext();
        context.getClass();
        if (uri != null) {
            DocumentSharingProvider.deleteFile(context, uri);
        }
    }
}
